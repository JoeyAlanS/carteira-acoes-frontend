(ns carteira-acoes-frontend.api
  (:require [clj-http.client :as http]
            [cheshire.core :as json]))

(def base "http://localhost:3000")
(println "API base URL:" base) ;; debug

(defn get-json [url]
  (-> (http/get (str base url) {:as :json})
      :body))

(defn post-json [url body]
  (-> (http/post (str base url)
                 {:content-type :json
                  :accept :json
                  :body (json/encode body)
                  :as :json})
      :body))

(defn consultar-acao [ticker]
  (get-json (str "/acao/" ticker)))

(defn comprar [t q d]
  (post-json "/compra" {:ticker t :quantidade q :data d}))

(defn vender [t q d]
  (post-json "/venda" {:ticker t :quantidade q :data d}))

(defn extrato [i f]
  (get-json (str "/extrato?inicio=" i "&fim=" f)))

(defn saldo []
  (get-json "/saldo"))
