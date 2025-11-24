(ns carteira-acoes-frontend.core
  (:require [carteira-acoes-frontend.menu :as menu])
  (:gen-class))

(defn menu []
  (println "===== CARTEIRA DE AÇÕES =====")
  (println "1 - Consultar ação")
  (println "2 - Comprar")
  (println "3 - Vender")
  (println "4 - Extrato")
  (println "5 - Saldo")
  (println "0 - Sair")
  (print "Escolha: ")
  (flush)
  (read-line))

(defn loop-terminal []
  (let [op (menu)]
    (cond
      (= op "1") (do (menu/consultar-acao-menu) (recur))
      (= op "2") (do (menu/compra-menu) (recur))
      (= op "3") (do (menu/venda-menu) (recur))
      (= op "4") (do (menu/extrato-menu) (recur))
      (= op "5") (do (menu/saldo-menu) (recur))
      (= op "0") (println "Saindo...")
      :else (do (println "Opção inválida!") (recur)))))

(defn -main []
  (loop-terminal))
