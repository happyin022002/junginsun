/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0518Event.java
*@FileTitle : B/L Inquiry by Container
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.07.20 이수빈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0518 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0518HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Subin
 * @see ESM_BKG_0518HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0518Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private String cntrNo = null;
	private String vvd = null;
	private String blType = null;

	public EsmBkg0518Event(){}

	/**
	 * @return the cntrNo
	 */
	public String getCntrNo() {
		return cntrNo;
	}

	/**
	 * @param cntrNo the cntrNo to set
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * @return the vvd
	 */
	public String getVvd() {
		return vvd;
	}

	/**
	 * @param vvd the vvd to set
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * @return the blType
	 */
	public String getBlType() {
		return blType;
	}

	/**
	 * @param blType the blType to set
	 */
	public void setBlType(String blType) {
		this.blType = blType;
	}

}