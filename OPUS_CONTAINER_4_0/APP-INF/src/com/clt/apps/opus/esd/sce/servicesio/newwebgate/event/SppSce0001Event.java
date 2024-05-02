/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SPP_SCE_001Event.java
*@FileTitle : Movement Input
*Open Issues :
*Change history :
*@LastModifyDate : 2007-07-10
*@LastModifier : cho_gilhong@naver.com
*@LastVersion : 1.0
* 2007-07-10 cho_gilhong@naver.com
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.servicesio.newwebgate.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * SPP_SCE_001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - WebGateIWSProxy에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author cho_gilhong
 * @see WebGateIWSProxy 참조
 * @since J2EE 1.4
 */
public class SppSce0001Event extends EventSupport {
	private static final long serialVersionUID = 1L;
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
     * default constructor
     */
    public SppSce0001Event() {}
    
    /**
     * constructor for SPP_SCE_001Event
     * @param mov_tp String
     * @param nod_cd String
     * @param direction String
     * @param moved_by String
     * @param office String
     * @param user_id String
     * @param vndr_seq String
     * @param mov Movement[]

     */
    public SppSce0001Event(String mov_tp,
    		            String nod_cd,
    		            String direction,
    		            String moved_by,
    		            String office,
    		            String user_id,
    		            String vndr_seq,
                        Movement[] mov
    		           ) {
    	this.movTp = mov_tp;
    	this.nodCd = nod_cd;
    	this.direction = direction;
    	this.movedBy = moved_by;
    	this.office = office;
    	this.userId = user_id;
    	this.vndrSeq = vndr_seq;
        this.mov = mov;
    }
    
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
     * set user_id
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
    	Movement[] rtnVOs = null;
		if (this.mov != null) {
			rtnVOs = Arrays.copyOf(mov, mov.length);
		}
		return rtnVOs;
    }
    /**
     * set Movement[]
     * 
     * @param mov Movement[]
     */
    public void setMov(Movement[] mov) {
		if(mov != null){
			Movement[] tmpVOs = Arrays.copyOf(mov, mov.length);
			this.mov = tmpVOs;
		}
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
     * get event name
     * @return String
     */
    public String getEventName() {
        return "SPP_SCE_001Event";
    }
	/**
	 * toString
	 * @return String
	 */
    public String toString() {
        return "SPP_SCE_001Event";
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