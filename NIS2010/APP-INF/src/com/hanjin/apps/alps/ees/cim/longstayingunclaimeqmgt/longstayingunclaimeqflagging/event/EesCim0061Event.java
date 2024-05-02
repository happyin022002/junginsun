/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EesCim0061Event.java
*@FileTitle : EQ Balance Report Inquiry
*Open Issues : 
*Change history :
*@LastModifyDate : 2014.04.03
*@LastModifier : Kim Chang Young
*@LastVersion : 1.0
* 2014.04.03 Kim Chang Young
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.CimEqSplsDfctStsVO;


/**
 * EES_CIM_0061 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_0061HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Young Du
 * @see EES_CIM_0061HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCim0061Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/* Column Info */
	private String sendFlag = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibFlag = null;
	/* Column Info */
	private String fmWeek = null;
	/* Column Info */
	private String toWeek = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String scontiCd = null;
	/* Column Info */
	private String pageType = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String lccCd = null;
	/* Page Number */
	private String pageRows = null;
	
	public EesCim0061Event(){}
	
	/**
	 * Column Info
	 * @return sendFlag
	 */
	public String getSendFlag() {
		return this.sendFlag;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibFlag
	 */
	public String getIbFlag() {
		return this.ibFlag;
	}
	
	/**
	 * Column Info
	 * @return fmWeek
	 */
	public String getFmWeek() {
		return this.fmWeek;
	}
	
	/**
	 * Column Info
	 * @return toWeek
	 */
	public String getToWeek() {
		return this.toWeek;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return scontiCd
	 */
	public String getScontiCd() {
		return this.scontiCd;
	}
	
	/**
	 * Column Info
	 * @return pageType
	 */
	public String getPageType() {
		return this.pageType;
	}
	
	/**
	 * Column Info
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
	}
	
	/**
	 * Page Number
	 * @return pageRows
	 */
	public String getPageRows() {
		return this.pageRows;
	}
	

	/**
	 * Column Info
	 * @param sendFlag
	 */
	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibFlag
	 */
	public void setIbFlag(String ibFlag) {
		this.ibFlag = ibFlag;
	}
	
	/**
	 * Column Info
	 * @param fmWeek
	 */
	public void setFmWeek(String fmWeek) {
		this.fmWeek = fmWeek;
	}
	
	/**
	 * Column Info
	 * @param toWeek
	 */
	public void setToWeek(String toWeek) {
		this.toWeek = toWeek;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param scontiCd
	 */
	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
	}
	
	/**
	 * Column Info
	 * @param pageType
	 */
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	
	/**
	 * Column Info
	 * @param eccCd
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
	}
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
	}
	
	/**
	 * Page Number
	 * @param pageRows
	 */
	public void setPageRows(String pageRows) {
		this.pageRows = pageRows;
	}
	
}