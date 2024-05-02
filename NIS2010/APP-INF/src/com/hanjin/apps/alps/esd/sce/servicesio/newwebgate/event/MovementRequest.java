/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MovementRequest.java
*@FileTitle : Movement Request
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
 * SPP_SCE_001 에 대한 WebService Document Object including Parameters<br>
 * - WebGateIWSProxy의 Input Parameter<br>
 * - SPP_SCE_001Event로 변환하여 사용<br>
 *
 * @author cho_gilhong
 * @see WebGateIWSProxy 참조
 * @since J2EE 1.4
 */
public class MovementRequest {
    /** (Header) */
    /** (Param 객체) */
    private String movTp = null;
    private String nodCd = null;
    private String direction = null;
    private String movedBy = null;
    private String userId = null;
    private String office = null;
    private String vndrSeq = null;
    
    private Movement[] mov = null;
    
    /**
     * get user_id
     * 
     * @return String user_id
     */
    public String getUser_id() {
    	return userId;
    }
    /**
     * set user_id
     * @param user_id String
     */
    public void setUser_id(String user_id) {
    	this.userId = user_id;
    }
    /**
     * get office
     * 
     * @return String office
     */
    public String getOffice() {
    	return office;
    }
    /**
     * set office
     * @param office String
     */
    public void setOffice(String office) {
    	this.office = office;
    }
        
    /**
     * get direction
     * 
     * @return String direction
     */
    public String getDirection() {
    	return direction;
    }
    /**
     * set direction
     * @param direction String
     */
    public void setDirection(String direction) {
    	this.direction = direction;
    }
    
    /**
     * get Movement[]
     * 
     * @return move Movement[]
     */
    public Movement[] getMov() {
    	return mov;
    }
    /**
     * set Movement[]
     * 
     * @param mov Movement[]
     */
    public void setMov(Movement[] mov) {
    	this.mov = mov;
    }
    
    /**
     * get Movement Type
     * 
     * @return String mov_tp
     */
    public String getMov_tp() {
    	return movTp;
    }
    /**
     * set Movement Type
     * 
     * @param mov_tp String
     */
    public void setMov_tp(String mov_tp) {
    	this.movTp = mov_tp;
    }
    
    /**
     * get nod_cd
     * 
     * @return String nod_cd
     */
    public String getNod_cd() {
    	return nodCd;
    }
    /**
     * set nod_cd
     * 
     * @param nod_cd String
     */
    public void setNod_cd(String nod_cd) {
    	this.nodCd = nod_cd;
    }
    
    /**
     * get moved_by
     * 
     * @return String moved_by
     */
    public String getMoved_by() {
    	return movedBy;
    }
    /**
     * set vsl_cd
     * 
     * @param moved_by String
     */
    public void setMoved_by(String moved_by) {
    	this.movedBy = moved_by;
    }
	/**
	 * @return Returns the vndr_seq.
	 */
	public String getVndr_seq() {
		return vndrSeq;
	}
	/**
	 * @param vndr_seq The vndr_seq to set.
	 */
	public void setVndr_seq(String vndr_seq) {
		this.vndrSeq = vndr_seq;
	}
    
}