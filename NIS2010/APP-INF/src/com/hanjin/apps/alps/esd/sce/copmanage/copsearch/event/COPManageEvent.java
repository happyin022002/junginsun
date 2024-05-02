/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COPManageEvent.java
*@FileTitle : COP
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-25
*@LastModifier : Jongwon Park
*@LastVersion : 1.0
* 2006-09-25 Jongwon Park
* 1.0 ���� ��
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event;


import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * COPManageEvent ���� PDTO(Data Transfer Object including Parameters)<br>
 * - <br>
 * - ServiceCommand Layer <br>
 *
 * @author Jongwon Park
 * @see HTMLAction ��v
 * @since J2EE 1.4
 */
public class COPManageEvent extends EventSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2393638994223865669L;
	
	String bkgRcvDt     = "";  
    String bkgRcvNo     = "";  
    String bkgNo         = "";  
    String bkgNoSplit   = "";  
    String bkgEvntDt    = "";  
    String copEvntSeq   = "";  
    String bkgEvntTpCd = "";  
    String cntrNo        = "";  
    String cntrTpszCd   = "";  
    String bkgIfStsCd  = "";  
    String pctlNo        = "";

    String oldcntrNo        = "";  
    String oldcntrTpszCd   = "";  
    
    /* Mail을 보내기 위한 변수들..*/
    String creOfcCd = "";
    String creUsrId = "";
    String curBkgNo = "";
    String oldBkgNo = "";
    String soNo = "";
    String soStatus = "";
    String actGrpCd = "";
    String curCopNo = "";
    String oldCopNo = "";
    String usrEml = "";
    
    String vvd = "";
    String polcd = "";
    String podcd = "";
    

	/**
	 * @return
	 */
	public String getPolCd() {
		return polcd;
	}

	/**
	 * @param polcd
	 */
	public void setPolCd(String polcd) {
		this.polcd = polcd;
	}
	
	/**
	 * @return
	 */
	public String getPodCd() {
		return podcd;
	}

	/**
	 * @param podcd
	 */
	public void setPodCd(String podcd) {
		this.podcd = podcd;
	}
	
	/**
	 * @return
	 */
	public String getVVD() {
		return vvd;
	}

	/**
	 * @param vvd
	 */
	public void setVVD(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * @return Returns the bkgEvntDt.
	 */
	public String getBkgEvntDt() {
		return bkgEvntDt;
	}

	/**
	 * @param bkgEvntDt The bkgEvntDt to set.
	 */
	public void setBkgEvntDt(String bkgEvntDt) {
		this.bkgEvntDt = bkgEvntDt;
	}

	/**
	 * @return Returns the bkgEvntTpCd.
	 */
	public String getBkgEvntTpCd() {
		return bkgEvntTpCd;
	}

	/**
	 * @param bkgEvntTpCd The bkgEvntTpCd to set.
	 */
	public void setBkgEvntTpCd(String bkgEvntTpCd) {
		this.bkgEvntTpCd = bkgEvntTpCd;
	}

	/**
	 * @return Returns the bkgIfStsCd.
	 */
	public String getBkgIfStsCd() {
		return bkgIfStsCd;
	}

	/**
	 * @param bkgIfStsCd The bkgIfStsCd to set.
	 */
	public void setBkgIfStsCd(String bkgIfStsCd) {
		this.bkgIfStsCd = bkgIfStsCd;
	}

	/**
	 * @return Returns the bkgNo.
	 */
	public String getBkgNo() {
		return bkgNo;
	}

	/**
	 * @param bkgNo The bkgNo to set.
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * @return Returns the bkgNoSplit.
	 */
	public String getBkgNoSplit() {
		return bkgNoSplit;
	}

	/**
	 * @param bkgNoSplit The bkgNoSplit to set.
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
	}

	/**
	 * @return Returns the bkgRcvDt.
	 */
	public String getBkgRcvDt() {
		return bkgRcvDt;
	}

	/**
	 * @param bkgRcvDt The bkgRcvDt to set.
	 */
	public void setBkgRcvDt(String bkgRcvDt) {
		this.bkgRcvDt = bkgRcvDt;
	}

	/**
	 * @return Returns the bkgRcvNo.
	 */
	public String getBkgRcvNo() {
		return bkgRcvNo;
	}

	/**
	 * @param bkgRcvNo The bkgRcvNo to set.
	 */
	public void setBkgRcvNo(String bkgRcvNo) {
		this.bkgRcvNo = bkgRcvNo;
	}

	/**
	 * @return Returns the cntrNo.
	 */
	public String getCntrNo() {
		return cntrNo;
	}

	/**
	 * @param cntrNo The cntrNo to set.
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * @return Returns the cntrTpszCd.
	 */
	public String getCntrTpszCd() {
		return cntrTpszCd;
	}

	/**
	 * @param cntrTpszCd The cntrTpszCd to set.
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	/**
	 * @return Returns the copEvntSeq.
	 */
	public String getCopEvntSeq() {
		return copEvntSeq;
	}

	/**
	 * @param copEvntSeq The copEvntSeq to set.
	 */
	public void setCopEvntSeq(String copEvntSeq) {
		this.copEvntSeq = copEvntSeq;
	}

	/**
	 * @return Returns the pctlNo.
	 */
	public String getPctlNo() {
		return pctlNo;
	}

	/**
	 * @param pctlNo The pctlNo to set.
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
	}

	/**
	 * @return Returns the oldcntrNo.
	 */
	public String getOldCntrNo() {
		return oldcntrNo;
	}

	/**
	 * @param oldcntrNo The oldcntrNo to set.
	 */
	public void setOldCntrNo(String oldcntrNo) {
		this.oldcntrNo = oldcntrNo;
	}

	/**
	 * @return Returns the oldcntrTpszCd.
	 */
	public String getOldCntrTpszCd() {
		return oldcntrTpszCd;
	}

	/**
	 * @param oldcntrTpszCd The oldcntrTpszCd to set.
	 */
	public void setOldCntrTpszCd(String oldcntrTpszCd) {
		this.oldcntrTpszCd = oldcntrTpszCd;
	}
	
	
	/**
	 * @return Returns the creOfcCd.
	 */
	public String getCreOfcCd() {
		return creOfcCd;
	}

	/**
	 * @param setgetCreOfcCd The creOfcCd to set.
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * @return Returns the creUsrId.
	 */
	public String getCreUsrId() {
		return creUsrId;
	}

	/**
	 * @param setCreUsrId The creUsrId to set.
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * @return Returns the curBkgNo.
	 */
	public String getCurBkgNo() {
		return curBkgNo;
	}

	/**
	 * @param setCurBkgNo The curBkgNo to set.
	 */
	public void setCurBkgNo(String curBkgNo) {
		this.curBkgNo = curBkgNo;
	}
	
	/**
	 * @return Returns the oldBkgNo.
	 */
	public String getOldBkgNo() {
		return oldBkgNo;
	}

	/**
	 * @param setOldBkgNo The oldBkgNo to set.
	 */
	public void setOldBkgNo(String oldBkgNo) {
		this.oldBkgNo = oldBkgNo;
	}
	
	
	/**
	 * @return Returns the soNo.
	 */
	public String getSoNo() {
		return soNo;
	}

	/**
	 * @param setSoNo The soNo to set.
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}
	
	/**
	 * @return Returns the soStatus.
	 */
	public String getSoStatus() {
		return soStatus;
	}

	/**
	 * @param setSoStatus The soStatus to set.
	 */
	public void setSoStatus(String soStatus) {
		this.soStatus = soStatus;
	}
	
	
	/**
	 * @return Returns the actGrpCd.
	 */
	public String getActGrpCd() {
		return actGrpCd;
	}

	/**
	 * @param setActGrpCd The actGrpCd to set.
	 */
	public void setActGrpCd(String actGrpCd) {
		this.actGrpCd = actGrpCd;
	}
	
	/**
	 * @return Returns the curCopNo.
	 */
	public String getCurCopNo() {
		return curCopNo;
	}

	/**
	 * @param setCurCopNo The curCopNo to set.
	 */
	public void setCurCopNo(String curCopNo) {
		this.curCopNo = curCopNo;
	}
	
	/**
	 * @return Returns the oldCopNo.
	 */
	public String getOldCopNo() {
		return oldCopNo;
	}

	/**
	 * @param setOldCopNo The oldCopNo to set.
	 */
	public void setOldCopNo(String oldCopNo) {
		this.oldCopNo = oldCopNo;
	}
	
	/**
	 * @return Returns the usrEml.
	 */
	public String getUsrEml() {
		return usrEml;
	}

	/**
	 * @param setUsrEml The usrEml to set.
	 */
	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}
    
	public Object getObject(String key){
		return (key==null) ? null : this.getAttribute(key);
	}


	public String getString(String key){
		Object tmp = this.getObject(key);
		return (tmp==null) ? "" : (String)tmp;
	}
	

	public int getInt(String key){
		String tmp = this.getString(key);
		return ("".equals(tmp)) ? 0 : Integer.parseInt(tmp);
	}
	
	/**
	 * @param key
	 * @param value
	 */
	public void putValue(String key, Object value){
		if(key==null) return;
		this.setAttribute(key, value);
	}
	
	/** Default 생성자
     * @param 
     */
	public COPManageEvent(){}

    /**
     * 이벤트 명(COPManageEvent)을 반환
     * 
     * @return COPManageEvent
     */
	public String getEventName() {
		return "COPManageEvent";
	}

    /**
     * 객체 표현 문자열(COPManageEvent)을 반환
     * 
     * @return String COPManageEvent
     */
	public String toString() {
		return "COPManageEvent";
	}
}