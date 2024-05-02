/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FaxSendVO.java
*@FileTitle : FaxSendVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

import java.util.HashMap;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FaxSendVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	/* Column Info */
	private String office = null;
	/* Column Info */
	private String batchFlg = null;
	/* Column Info */
	private String title = null;
	/* Column Info */
	private String rcvInfo = null;
	/* Column Info */
	private String tmplParam = null;
	/* Column Info */
	private String tmplMrd = null;
	/* Column Info */
	private String sysCd = null;
	/* Column Info */
	private String crtUserId = null;

	public FaxSendVO() {}

	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**
	 * Column Info
	 * @return batchFlg
	 */
	public String getBatchFlg() {
		return this.batchFlg;
	}
	
	/**
	 * Column Info
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Column Info
	 * @return rcvInfo
	 */
	public String getRcvInfo() {
		return this.rcvInfo;
	}
	
	/**
	 * Column Info
	 * @return tmplParam
	 */
	public String getTmplParam() {
		return this.tmplParam;
	}
	
	/**
	 * Column Info
	 * @return tmplMrd
	 */
	public String getTmplMrd() {
		return this.tmplMrd;
	}
	
	/**
	 * Column Info
	 * @return sysCd
	 */
	public String getSysCd() {
		return this.sysCd;
	}
	
	/**
	 * Column Info
	 * @return crtUserId
	 */
	public String getCrtUserId() {
		return this.crtUserId;
	}

	/**
	 * Column Info
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param batchFlg
	 */
	public void setBatchFlg(String batchFlg) {
		this.batchFlg = batchFlg;
	}
	
	/**
	 * Column Info
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Column Info
	 * @param rcvInfo
	 */
	public void setRcvInfo(String rcvInfo) {
		this.rcvInfo = rcvInfo;
	}
	
	/**
	 * Column Info
	 * @param tmplParam
	 */
	public void setTmplParam(String tmplParam) {
		this.tmplParam = tmplParam;
	}
	
	/**
	 * Column Info
	 * @param tmplMrd
	 */
	public void setTmplMrd(String tmplMrd) {
		this.tmplMrd = tmplMrd;
	}
	
	/**
	 * Column Info
	 * @param sysCd
	 */
	public void setSysCd(String sysCd) {
		this.sysCd = sysCd;
	}
	
	/**
	 * Column Info
	 * @param crtUserId
	 */
	public void setCrtUserId(String crtUserId) {
		this.crtUserId = crtUserId;
	}

	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
