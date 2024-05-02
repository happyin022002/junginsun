/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdSce0037Event.java
 *@FileTitle : EsdSce0037
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-26
 *@LastModifier : yongcheon_shin
 *@LastVersion : 1.0
 * 2006-09-20 yongcheon_shin
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event;

import java.util.HashMap;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * EsdSce0037 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Yong-cheon Shin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0037Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	private String ediGrpCd = null;
	private String vvd = null;
	private String bkgNo = null;
	private String bkgNoSplit = null;
	private String cntrNo = null;
	private HashMap<String, String> parameterMap = null;

	/**
	 * Constructor
	 * 
	 * @param parameterMap_
	 */
	public EsdSce0037Event(HashMap<String, String> parameterMap_) {
		this.parameterMap = parameterMap_;
		this.ediGrpCd = (String) parameterMap_.get("edi_grp_cd");
		this.vvd = (String) parameterMap_.get("vvd");
		this.bkgNo = (String) parameterMap_.get("bkg_no");
		this.bkgNoSplit = (String) parameterMap_.get("bkg_no_split");
		this.cntrNo = (String) parameterMap_.get("cntr_no");
	}

	/**
	 * Evenct Name 을 반환한다.
	 * 
	 * @return "EsdSce0037Event"
	 */
	public String getEventName() {
		return "EsdSce0037Event";
	}

	/**
	 * String Casting 된 Evenct Name 을 반환한다.
	 * 
	 * @return "EsdSce0037Event"
	 */
	public String toString() {
		return "EsdSce0037Event";
	}

	/**
	 * @return Returns the bkgNo.
	 */
	public String getBkg_no() {
		return bkgNo;
	}

	/**
	 * @return Returns the bkgNoSplit.
	 */
	public String getBkg_no_split() {
		return bkgNoSplit;
	}

	/**
	 * @return Returns the cntrNo.
	 */
	public String getCntr_no() {
		return cntrNo;
	}

	/**
	 * @return Returns the ediGrpCd.
	 */
	public String getEdi_grp_cd() {
		return ediGrpCd;
	}

	/**
	 * @return Returns the parameterMap.
	 */
	public HashMap<String, String> getParameterMap() {
		return parameterMap;
	}

	/**
	 * @return Returns the vvd.
	 */
	public String getVvd() {
		return vvd;
	}

}
