(defproject comments "0.0.1-SNAPSHOT"
  :description "Comments Plugin for Websites"
  :min-lein-version "2.0.0"
  :url "http://104.131.30.116:3449"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]

                 ;; server
                 [cheshire "5.3.1"]
                 [compojure "1.1.8"]
                 [http-kit "2.1.16"]
                 [ring "1.3.1"]
                 [enlive "1.1.5"]
                 [com.cemerick/friend "0.2.0"]
                 [org.clojure/core.cache "0.6.3"]
                 [org.clojure/core.memoize "0.5.6" :exclusions [org.clojure/core.cache]]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]

                 ;; clojurescript
                 [org.clojure/clojurescript "0.0-2280"]
                 [om "0.7.1"]
                 [kioo "0.4.1-SNAPSHOT"]
                 [com.facebook/react "0.11.1"]
                 [cljs-hash "0.0.2"]

                 ;; dev
                 [org.clojure/tools.nrepl "0.2.3"]
                 [cider/cider-nrepl "0.7.0"]
                 [figwheel "0.1.4-SNAPSHOT"]]

  :plugins [[com.cemerick/austin "0.1.5"]
            [lein-cljsbuild "1.0.3"]
            [lein-ring "0.8.8"]
            [lein-figwheel "0.1.4-SNAPSHOT"]]

  :resource-paths ["resources"]

  :cljsbuild {:builds 
              [{:source-paths ["src-cljs"]
                :compiler {:output-to "resources/public/scripts/compiled/app.js"
                           :output-dir "resources/public/scripts/compiled"
                           :optimizations :none
                           :pretty-print true
                           :source-map true}}]}
  
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]]
                   :repl-options {:init-ns comments.core}}}
  
  :aliases {"server"  ["trampoline" "run" "-m" "comments.server"]} 
  
  :figwheel {:http-server-root "public"
             :server-port 3449}
  :uberjar-name "comments.jar")
