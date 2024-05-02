/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0071Event.java
*@FileTitle : Bunker Price Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.08
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.08 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0071 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0071HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JUNGYOONTAE
 * @see ESM_FMS_0071HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0071Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Location 지역코드 */
	private String locCd = "";
	
	/** Duration From 값 */
	private String fromDt = "";
	
	/** Duration To 값 */
	private String toDt = "";
	
	public String getLocCd() {
		return locCd;
	}

	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	public String getFromDt() {
		return fromDt;
	}

	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}

	public String getToDt() {
		return toDt;
	}

	public void setToDt(String toDt) {
		this.toDt = toDt;
	}

}