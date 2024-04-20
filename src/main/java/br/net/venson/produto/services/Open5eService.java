package br.net.venson.produto.services;

import org.springframework.web.client.RestClient;

public interface Open5eService {
    static RestClient client = RestClient.create("https://api.open5e.com/");
}