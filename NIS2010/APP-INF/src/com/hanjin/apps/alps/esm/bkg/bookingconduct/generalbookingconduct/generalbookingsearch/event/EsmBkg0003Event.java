/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0003Event.java
*@FileTitle : Customer Advisory Send
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.20
*@LastModifier : LeeInYoung
*@LastVersion : 1.0
* 2011.07.20 LeeInYoung
* 1.0 Creation
* -------------------------------------------------------
* History
* 2012.04.02 변종건 [CHM-201216424-01] ALPS Customer Advisory 기능 보완 검토 요청 (Template 문서 첨부 등)
* 2012.09.17 김보배 [CHM-201220181] [BKG] ALPS Bkg/Doc Customer Advisory Send 기능 보완 요청 (30초룰 해제)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSchVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSndVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcUploadVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LeeInYoung
 * @see ESM_BKG_0003HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmBkg0003Event(){}

	private String custCntCd = null;
	private String custSeq = null;
	private String urlPath = null;
	private String ofcCd = null;
	
	private String key = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCustAvcNtcSndVO bkgCustAvcNtcSndVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgCustAvcNtcSndVO[] bkgCustAvcNtcSndVOs = null;
	
	/** Table Value Object Multi Data 처리(Upload) */
	private BkgCustAvcNtcUploadVO[] bkgCustAvcNtcUploadVOs = null;

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

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public BkgCustAvcNtcSchVO getBkgCustAvcNtcSchVO() {
		return bkgCustAvcNtcSchVO;
	}

	public void setBkgCustAvcNtcSchVO(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO) {
		this.bkgCustAvcNtcSchVO = bkgCustAvcNtcSchVO;
	}

	public BkgCustAvcNtcSndVO getBkgCustAvcNtcSndVO() {
		return bkgCustAvcNtcSndVO;
	}

	public void setBkgCustAvcNtcSndVO(BkgCustAvcNtcSndVO bkgCustAvcNtcSndVO) {
		this.bkgCustAvcNtcSndVO = bkgCustAvcNtcSndVO;
	}

	public BkgCustAvcNtcSndVO[] getBkgCustAvcNtcSndVOs() {
		return bkgCustAvcNtcSndVOs;
	}

	public void setBkgCustAvcNtcSndVOs(BkgCustAvcNtcSndVO[] bkgCustAvcNtcSndVOs) {
		this.bkgCustAvcNtcSndVOs = bkgCustAvcNtcSndVOs;
	}

	public BkgCustAvcNtcUploadVO[] getBkgCustAvcNtcUploadVOs() {
		return bkgCustAvcNtcUploadVOs;
	}

	public void setBkgCustAvcNtcUploadVOs(
			BkgCustAvcNtcUploadVO[] bkgCustAvcNtcUploadVOs) {
		this.bkgCustAvcNtcUploadVOs = bkgCustAvcNtcUploadVOs;
	}

}