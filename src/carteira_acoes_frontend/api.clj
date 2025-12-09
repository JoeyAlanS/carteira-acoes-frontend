(ns carteira-acoes-frontend.api
  (:require [clj-http.client :as http]
            [cheshire.core :as json]))

(def base "http://localhost:3000")

(defn get-json [url]
  (try
    (let [resp (http/get (str base url)
                         {:as :json
                          :throw-exceptions false})]

      (:body resp))
    (catch Exception e
      {:erro "Falha ao conectar ao servidor."})))

(defn post-json [url body]
  (try
    (let [resp (http/post (str base url)
                          {:content-type :json
                           :accept :json
                           :body (json/encode body)
                           :as :json
                           :throw-exceptions false})]

      (:body resp))
    (catch Exception e
      {:erro "Falha ao enviar dados para o servidor."})))

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
