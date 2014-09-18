(ns comments.core
  (:require ;;[clojure.browser.repl]
            [figwheel.client :as fw :include-macros true]))
 
(enable-console-print!)

;; define your app data so that it doesn't get over-written on reload
;; (defonce app-data (atom {}))

(println "Changes to this text will display in your javascript console on file save.")

(fw/watch-and-reload
 :jsload-callback (fn []
                    ;; (stop-and-start-my app)
                    ))


