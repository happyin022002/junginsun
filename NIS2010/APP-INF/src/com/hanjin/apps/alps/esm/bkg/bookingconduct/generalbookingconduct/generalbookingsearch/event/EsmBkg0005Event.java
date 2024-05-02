/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0005Event.java
*@FileTitle : Customer Advisory History
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.19
*@LastModifier : LeeInYoung
*@LastVersion : 1.0
* 2011.10.19 LeeInYoung
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSndHisSchVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LeeInYoung
 * @see ESM_BKG_0005HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String custCntCd = null;
	private String custSeq = null;
	private String urlPath = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCustAvcNtcSndHisSchVO bkgCustAvcNtcSndHisSchVO = null;

	public String getCustCntCd() {
		return custCntCd;
	}

	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	public String getCustSeq() {
		return custSeq;
	}

	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}


	public BkgCustAvcNtcSndHisSchVO getBkgCustAvcNtcSndHisSchVO() {
		return bkgCustAvcNtcSndHisSchVO;
	}

	public void setBkgCustAvcNtcSndHisSchVO(
			BkgCustAvcNtcSndHisSchVO bkgCustAvcNtcSndHisSchVO) {
		this.bkgCustAvcNtcSndHisSchVO = bkgCustAvcNtcSndHisSchVO;
	}
}