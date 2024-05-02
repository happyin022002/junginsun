/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TrsInterfaceEvent.java
*@FileTitle : TrsInterfaceEvent
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-18
*@LastModifier : changgyu kim
*@LastVersion : 1.0
* 2006-11-13 changgyu kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.common.online.event;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * TRS I/F 관련 필요 정보<br>
 *
 * @author changgyu kim
 * @see 
 * @since J2EE 1.4
 */
public class TrsInterfaceEvent extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	private String trspSoOfcCtyCd		= "";
	private String trspSoSeq			= "";
	private String trspSoStsCd       = "";
	private String copNo           		= "";
	private String costActGrpSeq    	= ""; 
	
	/** Constructor
	 * @param trspSoOfcCtyCd
	 * @param trspSoSeq
	 * @param trspSoStsCd
	 * @param copNo
	 * @param costActGrpSeq
	 */
	public TrsInterfaceEvent(String trspSoOfcCtyCd,String trspSoSeq,String trspSoStsCd,String copNo,String costActGrpSeq){
		this.trspSoOfcCtyCd      =  trspSoOfcCtyCd;
		this.trspSoSeq           =  trspSoSeq;
		this.trspSoStsCd         =  trspSoStsCd;
		this.copNo               =  copNo;
		this.costActGrpSeq       =  costActGrpSeq;
	}
	
	/**
	 * @return Returns the trspSoStatusCd.
	 */
	public String getTrspSoStsCd() {
		return trspSoStsCd;
	}
	
	/**
	 * @param trspSoStatusCd The trspSoStatusCd to set.
	 */
	public void setTrspSoStsCd(String trspSoStsCd) {
		this.trspSoStsCd = trspSoStsCd;
	}
	
	/**
	 * @return Returns the trspSoOfcCtyCd.
	 */
	public String getTrspSoOfcCtyCd() {
		return trspSoOfcCtyCd;
	}
	
	/**
	 * @param trspSoOfcCtyCd.
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}
	
	/**
	 * @return Returns the trspSoSeq.
	 */
	public String getTrspSoSeq() {
		return trspSoSeq;
	}
	
	/**
	 * @param trspSoSeq.
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}
	
	/**
	 * @return Returns the copNo.
	 */
	public String getCopNo() {
		return copNo;
	}
	
	/**
	 * @param copNo The copNo to set.
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * @return Returns the costActGrpSeq.
	 */
	public String getCostActGrpSeq() {
		return costActGrpSeq;
	}
	
	/**
	 * @param costActGrpSeq The costActGrpSeq to set.
	 */
	public void setCostActGrpSeq(String costActGrpSeq) {
		this.costActGrpSeq = costActGrpSeq;
	}
}
