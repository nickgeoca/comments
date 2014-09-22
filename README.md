# Comments [![Build Status](https://semaphoreapp.com/api/v1/projects/5a7b5072-d324-46d3-9994-0b265cbdf054/251633/badge.png)](https://semaphoreapp.com/deltaalpharho/comments)<a href="https://floobits.com/DeltaAlphaRho/comments/redirect"> <img alt="Floobits status" width="100" height="40" src="https://floobits.com/DeltaAlphaRho/comments.png" /> </a>

A commenting plugin for websites. The following technologies will be leveraged for this project.

* [Clojure](http://clojure.org/)
* [Ring](https://github.com/ring-clojure/ring/wiki)
* [Friend](https://github.com/cemerick/friend)
* [Compojure](https://github.com/weavejester/compojure/wiki)
* [Bootstrap](http://getbootstrap.com/getting-started/ )
* [Enlive](https://github.com/cgrand/enlive/wiki/_pages)
* [FigWheel](https://github.com/bhauman/lein-figwheel)
* [Core.Async](https://github.com/clojure/core.async)
* [Om](https://github.com/swannodette/om)
* [Kioo](https://github.com/ckirkendall/kioo)
* [http-kit](http://http-kit.org/)

## Links

Production: [c0mment.com](http://c0mment.com)

Test: [test.c0mment.com](http://test.c0mment.com)

*Note that pushing to [master](https://github.com/DeltaAlphaRho/comments/tree/master) deploys to production and pushing to [test](https://github.com/DeltaAlphaRho/comments/tree/test) deploys to the test container.

## Installation

Clone the repo using the URL in the side bar.
```
~/workspace $ git clone https://github.com/DeltaAlphaRho/comments.git
```

## Usage

```
    $ cd comments
        
    comments$ lein server

```

If you would also like to have interactive web development via FigWheel then you might open another terminal and run...

```
    $ cd comments

    comments$ lein figwheel
```


After running the steps above you should be serving the project at http://localhost:3449/

## License

Copyright © 2014

Distributed under the Eclipse Public License, the same as Clojure.
