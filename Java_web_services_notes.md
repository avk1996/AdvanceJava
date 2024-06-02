# Java Web Services

## JAX-WS
Sepcification (guidelines by Oracle)

Web services engines like CXF & GlassFish are implemented as per JAX-WX standards

API (for developers)
Annotations (markers for class level or at field or method level)

Web services like CXF & GlassFish read these run time annotations and take appropriate action.

## CORE:

All core annotations like are in this package as given below
```js
    @javax.jws.WebService

    @javax.jws.WebMethod

    @javax.jws.WebFault
    // for custom exceptions
```

## JAXB

for mapping XML schema with java objects.

## Runtime API

1. Marshall
2. UNMarshall
3. Annotation

## How to add JSON support

1. Jackson Dependency third-party is a open-source library which specialize in serialize and de-serialize of java objects
2. Add Jackson Dependencies:
    
    2.1 jackson-jaxrs

    2.2 jackson-xc
3. Change the configuration

    @Consumes & @Produces


