package br.net.kauan.produto.services;

import org.springframework.web.client.RestClient;

/**
 * Interface base para serviços que consomem a API do Open5e.
 */
public interface Open5eService {
    static RestClient client = RestClient.create("https://api.open5e.com/");
}