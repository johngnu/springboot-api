package com.heyma.service.core.util;

public class RestConstant {
    public static final String RESPONSE_PERSIST_SUCCESSFULY = "Registrado exitosamente";
    public static final String RESPONSE_UPDATE_SUCCESSFULY = "Actualizacio exitosamente";
    public static final String RESPONSE_FIND_SUCCESSFULLY = "Realizado correctamente";


    public static final String RESPONSE_SERVER_ERROR = "Se genero un error en el servidor, contacte con administracion";

    public static final String RESPONSE_NOT_FOUND_RECORD = "Registro no encontrado id: ";
    public static final String LOG_DELETE = "Se elimino correctamente el registro: {}";
    public static final String LOG_UPDATE = "Se actualizo correctamente el registro: {}";
    public static final String LOG_PERSIST = "Se registro correctamente el registro: {}";

    public static String FIREBASE_PUSH_PREPARATION_TITLE = "Pedido en preparación";
    public static String FIREBASE_PUSH_PREPARATION_BODY = "Tu pedido se encuentra en preparación por el comercio";

    public static String FIREBASE_PUSH_DELIVERY_TITLE = "Pedido en camino";
    public static String FIREBASE_PUSH_DELIVERY_BODY = "Tu pedido se encuentra en camino por uno de nuestros drivers";

    public static String FIREBASE_PUSH_ARRIVED_TITLE = "Te entregamos tu pedido";
    public static String FIREBASE_PUSH_ARRIBED_BODY = "Gracias por usar FAST DRIVER!";


    public static String FIREBASE_PUSH_DRIVER_TITLE = "Nuevos pedidos";
    public static String FIREBASE_PUSH_DRIVER_BODY = "Tienes nuevos pedidos disponibles en tu bandeja";

    public static String FIREBASE_PUSH_CANCEL_TITLE = "Pedido cancelado";
    public static String FIREBASE_PUSH_CANCEL_BODY = "Tu pedido ha sido cancelado por el comercio";

    public static final int ORDER_STATE_REQUESTED = 1;
    public static final int ORDER_STATE_IN_PREPARATION = 2;
    public static final int ORDER_STATE_IN_SHIPPING = 3;
    public static final int ORDER_STATE_DELIVERED = 4;
    public static final int ORDER_STATE_FAKE = 5;
    public static final int ORDER_STATE_REJECTED = 6;


}
