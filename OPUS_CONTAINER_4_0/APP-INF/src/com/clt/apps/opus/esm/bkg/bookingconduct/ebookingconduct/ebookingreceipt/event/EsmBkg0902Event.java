/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0902Event.java
*@FileTitle : e-Booking & S/I Reject
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.07.06 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0902 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0902HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0902HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0902Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private XterRqstNoVO xterRqstNoVO= null;
	private String cntcEml= null;
	private String usrEml= null;
	private String emlSndYn= null;
	private String rjctRsnRmk= null;
	private String xterRjctRsnCd= null;
	private String blPrfShprFlg = null;
	private String rqstNo = null;
	private String rqstSeq = null;
	private String docTpCd = null;
	private String xterBkgRqstStsCd = null;
	
	public EsmBkg0902Event(){}

	public XterRqstNoVO getXterRqstNoVO() {
		return xterRqstNoVO;
	}

	public void setXterRqstNoVO(XterRqstNoVO xterRqstNoVO) {
		this.xterRqstNoVO = xterRqstNoVO;
	}

	public String getCntcEml() {
		return cntcEml;
	}

	public void setCntcEml(String cntcEml) {
		this.cntcEml = cntcEml;
	}

	public String getRjctRsnRmk() {
		return rjctRsnRmk;
	}

	public void setRjctRsnRmk(String rjctRsnRmk) {
		this.rjctRsnRmk = rjctRsnRmk;
	}

	public String getXterRjctRsnCd() {
		return xterRjctRsnCd;
	}

	public void setXterRjctRsnCd(String xterRjctRsnCd) {
		this.xterRjctRsnCd = xterRjctRsnCd;
	}

	public String getUsrEml() {
		return usrEml;
	}

	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}

	public String getEmlSndYn() {
		return emlSndYn;
	}

	public void setEmlSndYn(String emlSndYn) {
		this.emlSndYn = emlSndYn;
	}

	public String getBlPrfShprFlg() {
		return blPrfShprFlg;
	}

	public void setBlPrfShprFlg(String blPrfShprFlg) {
		this.blPrfShprFlg = blPrfShprFlg;
	}

	public String getRqstNo() {
		return rqstNo;
	}

	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}

	public String getRqstSeq() {
		return rqstSeq;
	}

	public void setRqstSeq(String rqstSeq) {
		this.rqstSeq = rqstSeq;
	}

	public String getDocTpCd() {
		return docTpCd;
	}

	public void setDocTpCd(String docTpCd) {
		this.docTpCd = docTpCd;
	}

	public String getXterBkgRqstStsCd() {
		return xterBkgRqstStsCd;
	}

	public void setXterBkgRqstStsCd(String xterBkgRqstStsCd) {
		this.xterBkgRqstStsCd = xterBkgRqstStsCd;
	}
	
}