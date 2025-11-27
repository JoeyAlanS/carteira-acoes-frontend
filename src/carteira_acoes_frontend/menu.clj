(ns carteira-acoes-frontend.menu
  (:require [carteira-acoes-frontend.api :as api]))

(defn espera []
  (println "\nPressione ENTER para continuar...")
  (read-line))

(defn consultar-acao-menu []
  (println "Ticker:")
  (let [t (read-line)]
    (println (api/consultar-acao t))
    (espera)))

(defn compra-menu []
  (println "Ticker:")
  (let [t (read-line)]
    (println "Quantidade:")
    (let [q (Integer/parseInt (read-line))]
      (println "Data (yyyymmdd):")
      (let [d (Integer/parseInt (read-line))]
        (println (api/comprar t q d))
        (espera)))))

(defn venda-menu []
  (println "Ticker:")
  (let [t (read-line)]
    (println "Quantidade:")
    (let [q (Integer/parseInt (read-line))]
      (println "Data (yyyymmdd):")
      (let [d (Integer/parseInt (read-line))]
        (println (api/vender t q d))
        (espera)))))

(defn extrato-menu []
  (println "Inicio (yyyymmdd):")
  (let [i (Integer/parseInt (read-line))]
    (println "Fim (yyyymmdd):")
    (let [f (Integer/parseInt (read-line))]
      (println (api/extrato i f))
      (espera))))

(defn saldo-menu []
  (println (api/saldo))
  (espera))
