package org.bedu.tipoCambio.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bedu.tipoCambio.model.TipoCambio;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * USD
 *  MXN = 18.01
 *  ARS = 1433.88
 * 
 * MXN
 *  USD = 0.056
 *  ARS = 79.13
 * 
 * ARS
 *  USD = 0.0007
 *  MXN = 0.013
 */

// Listas + Hash Tables/Hash Maps/Maps
@RestController
public class TipoCambioController {

    private List<TipoCambio> baseDatos;

    public TipoCambioController() {
        this.baseDatos = new ArrayList<>();

        HashMap<String, Double> conversionUsd = new HashMap<>();
        conversionUsd.put("MXN", 18.01);
        conversionUsd.put("ARS", 1433.88);

        this.baseDatos.add(new TipoCambio("USD", conversionUsd));

        HashMap<String, Double> conversionMxn = new HashMap<>();
        conversionMxn.put("USD", 0.056);
        conversionMxn.put("ARS", 79.13);

        this.baseDatos.add(new TipoCambio("MXN", conversionMxn));

        HashMap<String, Double> conversionArs = new HashMap<>();
        conversionArs.put("USD", 0.0007);
        conversionArs.put("MXN", 0.013);

        this.baseDatos.add(new TipoCambio("ARS", conversionArs));
    }

    /**
     * En un backend existen 4 formas de pasar parámetros a un endpoint
     * 
     * 1. Path Variable (@PathVariable)
     * 
     * Un pedazo de la url es una variable. 
     * 
     * Por ejemplo:
     *  /clima/toluca, /clima/cdmx, /clima/sinaloa, /clima/chiapas
     *  facebook.com/usuarios/8932768746, facebook.com/usuarios/12389098
     *  tiktok.com/@pepito, tiktok.com/@jose456/videos
     * 
     * 2. Querystring (@RequestParam)
     *  
     *  Son parámetros que van al final de la URL, son opcionales (pero en Spring por defecto es obligatorio) y son de la forma llave = valor
     *  Si son más de una variable se utiliza el & para separarlas
     * 
     *      ? variable1=valor1 & variable2=valor2 & variable3=valor3
     * 
     *  Por ejemplo:
     *      amazon.com/s?k=NintendoSwitch&es_USA=...
     */

    // 1. Obtener todas las conversiones de una moneda en específico
    // http://localhost:8080/conversiones/USD
    
    @RequestMapping("conversiones/{moneda}")
    public HashMap<String, Double> obtenerConversiones(@PathVariable("moneda") String codigo) {
        // Iteramos cada tipo de cambio de la base de datos
        for (TipoCambio tipoCambio : baseDatos) {
            // Si el tipo de cambio es el mismo codigo del que nos dieron como parametro
            if (tipoCambio.getCodigo().equals(codigo.toUpperCase())) {
                // Regresamos las conversiones
                return tipoCambio.getConversiones();
            }
        }

        // Si no existe el tipo de cambio, regresamos null
        return null;
    }

    // http://localhost:8080/conversiones/usd/convertir/jyp?cantidad=10
    @RequestMapping("conversiones/{moneda}/convertir/{destino}")
    public double convertir(
        @PathVariable("moneda") String codigo, 
        @PathVariable("destino") String destino,
        @RequestParam("cantidad") int cantidad) {
            for (TipoCambio tipoCambio : baseDatos) {
                if (tipoCambio.getCodigo().equals(codigo.toUpperCase())) {
                    // Wrapper Classes: int -> Integer, double -> Double, ....
                    Double valor = tipoCambio.getConversiones().get(destino.toUpperCase());

                    if (valor == null) {
                        return 0;
                    } else {
                        return cantidad == 0 ? valor : valor * cantidad;
                    }
                }
            }

            // Si no existe el tipo de cambio, regresamos 0
            return 0;
    }
}