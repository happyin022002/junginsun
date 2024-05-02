/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0095Event.java
*@FileTitle : Booking Fax & EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.09.25 전용진
* 1.0 Creation
* -----------------------------------------------------------
* History
* 2011.04.01 김기종 [CHM-201109394-01] DPCS고도화일환으로 BPM호출
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.SendMtyRlseOrdVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0095 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0095HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0095HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0095Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBlNoVO bkgBlNoVO = null;
	private BkgBlNoVO[] bkgBlNoVOs = null;
	private SendMtyRlseOrdVO sendMtyRlseOrdVO = null;
	private SendMtyRlseOrdVO[] sendMtyRlseOrdVOs = null;
	 
	private CustTpIdVO[] custTpIdVOs = null;

	private String[] ntcKndCd = null;
	private String[] faxNo = null;
	private String[] eml = null;
	private String[] remark = null;
	private String receiveType = null; 	
	private String mrdNm = null;
	private String polCd = null;
	private String[] frtTerm = null;
	private String[] frtCltFlg = null;
	private String docType=null;
	private String signFlag=null;
	private String dpcsSrNo=null;
	private String dpcsSrKndCd=null;
	private String fileKey=null;
	
	private BkgEmlEdtVO bkgEmlEdtVO = null;

	public EsmBkg0095Event(){}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public BkgBlNoVO[] getBkgBlNoVOs() {
		return bkgBlNoVOs;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs) {
		this.bkgBlNoVOs = bkgBlNoVOs;
	}

	public String[] getNtcKndCd() {
		return ntcKndCd;
	}

	public void setNtcKndCd(String[] ntcKndCd) {
		this.ntcKndCd = ntcKndCd;
	}

	public String[] getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String[] faxNo) {
		this.faxNo = faxNo;
	}

	public String[] getEml() {
		return eml;
	}

	public void setEml(String[] eml) {
		this.eml = eml;
	}

	public String[] getRemark() {
		return remark;
	}

	public void setRemark(String[] remark) {
		this.remark = remark;
	}

	public String getReceiveType(){
		return receiveType;
	}

	public void setReceiveType(String receiveType) {
		this.receiveType = receiveType;
	}
	public String getMrdNm() {
		return mrdNm;
	}

	public void setMrdNm(String mrdNm) {
		this.mrdNm = mrdNm;
	}
	public String getFileKey() {
		return fileKey;
	}

	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}
	public SendMtyRlseOrdVO getSendMtyRlseOrdVO() {
		return sendMtyRlseOrdVO;
	}

	public void setSendMtyRlseOrdVO(SendMtyRlseOrdVO sendMtyRlseOrdVO) {
		this.sendMtyRlseOrdVO = sendMtyRlseOrdVO;
	}

	public SendMtyRlseOrdVO[] getSendMtyRlseOrdVOs() {
		return sendMtyRlseOrdVOs;
	}

	public void setSendMtyRlseOrdVOs(SendMtyRlseOrdVO[] sendMtyRlseOrdVOs) {
		this.sendMtyRlseOrdVOs = sendMtyRlseOrdVOs;
	}


	public CustTpIdVO[] getCustTpIdVOs() {
		return custTpIdVOs;
	}

	public void setCustTpIdVOs(CustTpIdVO[] custTpIdVOs) {
		this.custTpIdVOs = custTpIdVOs;
	}

	public String getPolCd() {
		return polCd;
	}

	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	public String[] getFrtTerm() {
		return frtTerm;
	}

	public void setFrtTerm(String[] frtTerm) {
		this.frtTerm = frtTerm;
	}

	public String[] getFrtCltFlg() {
		return frtCltFlg;
	}

	public void setFrtCltFlg(String[] frtCltFlg) {
		this.frtCltFlg = frtCltFlg;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getSignFlag() {
		return signFlag;
	}

	public void setSignFlag(String signFlag) {
		this.signFlag = signFlag;
	}

	public BkgEmlEdtVO getBkgEmlEdtVO() {
		return bkgEmlEdtVO;
	}

	public void setBkgEmlEdtVO(BkgEmlEdtVO bkgEmlEdtVO) {
		this.bkgEmlEdtVO = bkgEmlEdtVO;
	}

	public String getDpcsSrNo() {
		return dpcsSrNo;
	}

	public void setDpcsSrNo(String dpcsSrNo) {
		this.dpcsSrNo = dpcsSrNo;
	}

	public String getDpcsSrKndCd() {
		return dpcsSrKndCd;
	}

	public void setDpcsSrKndCd(String dpcsSrKndCd) {
		this.dpcsSrKndCd = dpcsSrKndCd;
	}
	
}