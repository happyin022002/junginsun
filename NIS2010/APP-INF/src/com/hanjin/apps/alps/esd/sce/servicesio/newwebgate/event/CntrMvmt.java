/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : Movement.java
*@FileTitle : Movement DTO
*Open Issues :
*Change history :
*@LastModifyDate : 2007-07-10
*@LastModifier : cho_gilhong@naver.com
*@LastVersion : 1.0
* 2007-07-10 cho_gilhong@naver.com
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.servicesio.newwebgate.event;
 
/**
 * Movement DTO<br>
 *
 * @author cho_gilhong
 * @see WebGateIWSProxy 참조
 * @since J2EE 1.4
 */
public class CntrMvmt {
    
	private String seq 		= null;
	private String company 	= null;
    private String mvmtSts = null;
    private String yard 	= null;
    private String evntDt 	= null;
    
    /**
     * get seq
     * 
     * @return String seq
     */
    public String getSeq() {
    	return seq;
    }
    
    /**
     * set seq
     * 
     * @param seq String
     */
    public void setSeq(String seq) {
    	this.seq = seq;
    }
    
    /**
     * get company
     * 
     * @return String company
     */
    public String getCompany() {
    	return company;
    }
    
    /**
     * set company
     * 
     * @param company String
     */
    public void setCompany(String company) {
    	this.company = company;
    }
    
    /**
     * get mvmt_sts
     * 
     * @return String mvmt_sts
     */
    public String getMvmt_sts() {
    	return mvmtSts;
    }
    
    /**
     * set mvmt_sts
     * 
     * @param mvmt_sts String
     */
    public void setMvmt_sts(String mvmt_sts) {
    	this.mvmtSts = mvmt_sts;
    }
    
    /**
     * get yard
     * @return String yard
     */
    public String getYard() {
    	return yard;
    }
    
    /**
     * set yard
     * 
     * @param yard String
     */
    public void setYard(String yard) {
    	this.yard = yard;
    }
    
    /**
     * get evnt_dt
     * 
     * @return String evnt_dt
     */
    public String getEvnt_dt() {
    	return evntDt;
    }  
    
    /**
     * set evnt_dt
     * 
     * @param evnt_dt String
     */
    public void setEvnt_dt(String evnt_dt) {
    	this.evntDt = evnt_dt;
    }
}