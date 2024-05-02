/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0235Event.java
*@FileTitle : OPUS Container Office Setup
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RerouteOfcVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0235 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0235HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_BKG_0235HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0235Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RerouteOfcVO rerouteOfcVO= null;
	private String ofcCd = null;
	private String ofcNm = null;

	public EsmBkg0235Event(){}

	public RerouteOfcVO getRerouteOfcVO() {
		return rerouteOfcVO;
	}

	public void setRerouteOfcVO(RerouteOfcVO rerouteOfcVO) {
		this.rerouteOfcVO = rerouteOfcVO;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getOfcNm() {
		return ofcNm;
	}

	public void setOfcNm(String ofcNm) {
		this.ofcNm = ofcNm;
	}



	
}