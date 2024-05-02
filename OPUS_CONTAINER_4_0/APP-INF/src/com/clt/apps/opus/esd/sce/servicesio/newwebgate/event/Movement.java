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
package com.clt.apps.opus.esd.sce.servicesio.newwebgate.event;
 
/**
 * Movement DTO<br>
 *
 * @author cho_gilhong
 * @see WebGateIWSProxy 참조
 * @since J2EE 1.4
 */
public class Movement {
    private String cntrNo = null;
    private String bkgNo = null;
    private String actDt = null;
    private String rmk = null;
    
    /**
     * get act_dt
     * 
     * @return String act_dt
     */
    public String getAct_dt() {
    	return actDt;
    }
    
    /**
     * set act_dt
     * 
     * @param act_dt String
     */
    public void setAct_dt(String act_dt) {
    	this.actDt = act_dt;
    }
    
    /**
     * get cntr_no
     * 
     * @return String cntr_no
     */
    public String getCntr_no() {
    	return cntrNo;
    }
    
    /**
     * set cntr_no
     * 
     * @param cntr_no String
     */
    public void setCntr_no(String cntr_no) {
    	this.cntrNo = cntr_no;
    }
    
    /**
     * get rmk
     * @return String rmk
     */
    public String getRmk() {
    	return rmk;
    }
    
    /**
     * set rmk
     * 
     * @param rmk String
     */
    public void setRmk(String rmk) {
    	this.rmk = rmk;
    }
    
    /**
     * get bkg_no
     * 
     * @return String bkg_no
     */
    public String getBkg_no() {
    	return bkgNo;
    }  
    
    /**
     * set bkg_no
     * 
     * @param bkg_no String
     */
    public void setBkg_no(String bkg_no) {
    	this.bkgNo = bkg_no;
    }
    
}