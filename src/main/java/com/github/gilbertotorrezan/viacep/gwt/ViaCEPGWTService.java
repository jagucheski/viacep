/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2015 Gilberto Torrezan Filho
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 */
package com.github.gilbertotorrezan.viacep.gwt;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.Options;
import org.fusesource.restygwt.client.RestService;

import com.github.gilbertotorrezan.viacep.shared.ViaCEPEndereco;

/**
 * Interface REST utilizada pelo {@link ViaCEPGWTClient} para acessar os web services da ViaCEP.
 * 
 * As chamadas utilizam CORS.
 * 
 * @author Gilberto Torrezan Filho
 *
 * @since v.1.0.0
 */
@Options(serviceRootKey = ViaCEPGWTService.SERVICE_ROOT_KEY)
public interface ViaCEPGWTService extends RestService {
	
	String SERVICE_ROOT_KEY = "VIACEP_SERVICE_ROOT_KEY";

	@GET
    @Path("{cep}/json/")
    void getEndereco(@PathParam("cep") String cep, MethodCallback<ViaCEPEndereco> callback);
    
    @GET
    @Path("{uf}/{localidade}/{logradouro}/json/")
    void getEnderecos(@PathParam("uf") String uf, @PathParam("localidade") String localidade, @PathParam("logradouro") String logradouro,
    		MethodCallback<List<ViaCEPEndereco>> callback);

}
