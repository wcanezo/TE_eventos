package com.emergentes.dao;

import com.emergentes.modelo.Evento;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EventoDAOimpl extends ConexionBD implements EventoDAO{

    @Override
    public void insert(Evento evento) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT into eventos (titulo,expositor,fecha,hora,cupo) values(?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,evento.getTitulo());
            ps.setString(2,evento.getExpositor());
            ps.setDate(3,evento.getFecha());
            ps.setString(4,evento.getHora());
            ps.setInt(5,evento.getCupo());
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Evento evento) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE eventos set titulo=?, expositor=?, fecha=?, hora=?, cupo=? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,evento.getTitulo());
            ps.setString(2,evento.getExpositor());
            ps.setDate(3,evento.getFecha());
            ps.setString(4,evento.getHora());
            ps.setInt(5,evento.getCupo());
            ps.setInt(6,evento.getId());
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
        
        
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE from eventos where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1,id);
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
        
        
    }

    @Override
    public Evento getById(int id) throws Exception {
        Evento eve = new Evento();
        try {
            this.conectar();
            
            String sql = "select * from eventos where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                eve.setId(rs.getInt("id"));
                eve.setTitulo(rs.getString("titulo"));
                eve.setExpositor(rs.getString("expositor"));
                eve.setFecha(rs.getDate("fecha"));
                eve.setHora(rs.getString("hora"));
                eve.setCupo(rs.getInt("cupo"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
        
        return eve;
        
    }

    @Override
    public List<Evento> getAll() throws Exception {
        
        List<Evento> lista = null;
        try {
            this.conectar();
            String sql = "select * from eventos";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Evento>();
            while(rs.next()){
                Evento eve = new Evento();
                
                eve.setId(rs.getInt("id"));
                eve.setTitulo(rs.getString("titulo"));
                eve.setExpositor(rs.getString("expositor"));
                eve.setFecha(rs.getDate("fecha"));
                eve.setHora(rs.getString("hora"));
                eve.setCupo(rs.getInt("cupo"));
                
                lista.add(eve);
            }
            
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }       
}