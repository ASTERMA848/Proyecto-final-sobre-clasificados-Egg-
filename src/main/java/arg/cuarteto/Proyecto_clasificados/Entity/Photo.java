/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arg.cuarteto.Proyecto_clasificados.Entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Nnahu
 */
@Entity
public class Photo {
     @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String mime;
    
  
    
    @Lob @Basic(fetch = FetchType.LAZY) //LAZY significa carga tardia del archivo
    private byte[] content;

    /**
     * @return the Id
     */
    public String getid() {
        return id;
    }

    /**
     * @param Id the Id to set
     */
    public void setid(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the mime
     */
    public String getMime() {
        return mime;
    }

    /**
     * @param mime the mime to set
     */
    public void setMime(String mime) {
        this.mime = mime;
    }

    /**
     * @return the content
     */
    public byte[] getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Photo{" + "Id=" + id + ", name=" + name + ", mime=" + mime + ", content=" + content + '}';
    }

  
    
    
}
