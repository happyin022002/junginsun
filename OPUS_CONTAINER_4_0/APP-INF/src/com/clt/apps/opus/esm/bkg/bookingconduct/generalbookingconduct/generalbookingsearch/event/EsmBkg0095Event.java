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
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.SendMtyRlseOrdVO;
import com.clt.framework.support.layer.event.EventSupport;


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
	private String fileDownPath=null;

	private BkgEmlEdtVO bkgEmlEdtVO = null;

	public EsmBkg0095Event(){}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public BkgBlNoVO[] getBkgBlNoVOs() {
		BkgBlNoVO[] tmpVOs = null;
		if (this. bkgBlNoVOs != null) {
			tmpVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs .length);
		}
		return tmpVOs;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs) {
		if (bkgBlNoVOs != null) {
			BkgBlNoVO[] tmpVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs .length);
			this. bkgBlNoVOs = tmpVOs;
		}
	}

	public String[] getNtcKndCd() {
		String[] tmpVOs = null;
		if (this. ntcKndCd != null) {
			tmpVOs = Arrays.copyOf(ntcKndCd, ntcKndCd .length);
		}
		return tmpVOs;
	}

	public void setNtcKndCd(String[] ntcKndCd) {
		if (ntcKndCd != null) {
			String[] tmpVOs = Arrays.copyOf(ntcKndCd, ntcKndCd .length);
			this. ntcKndCd = tmpVOs;
		}
	}

	public String[] getFaxNo() {
		String[] tmpVOs = null;
		if (this. faxNo != null) {
			tmpVOs = Arrays.copyOf(faxNo, faxNo .length);
		}
		return tmpVOs;
	}

	public void setFaxNo(String[] faxNo) {
		if (faxNo != null) {
			String[] tmpVOs = Arrays.copyOf(faxNo, faxNo .length);
			this. faxNo = tmpVOs;
		}
	}

	public String[] getEml() {
		String[] tmpVOs = null;
		if (this. eml != null) {
			tmpVOs = Arrays.copyOf(eml, eml .length);
		}
		return tmpVOs;
	}

	public void setEml(String[] eml) {
		if (eml != null) {
			String[] tmpVOs = Arrays.copyOf(eml, eml .length);
			this. eml = tmpVOs;
		}
	}

	public String[] getRemark() {
		String[] tmpVOs = null;
		if (this. remark != null) {
			tmpVOs = Arrays.copyOf(remark, remark .length);
		}
		return tmpVOs;
	}

	public void setRemark(String[] remark) {
		if (remark != null) {
			String[] tmpVOs = Arrays.copyOf(remark, remark .length);
			this. remark = tmpVOs;
		}
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

	public SendMtyRlseOrdVO getSendMtyRlseOrdVO() {
		return sendMtyRlseOrdVO;
	}

	public void setSendMtyRlseOrdVO(SendMtyRlseOrdVO sendMtyRlseOrdVO) {
		this.sendMtyRlseOrdVO = sendMtyRlseOrdVO;
	}

	public SendMtyRlseOrdVO[] getSendMtyRlseOrdVOs() {
		SendMtyRlseOrdVO[] tmpVOs = null;
		if (this. sendMtyRlseOrdVOs != null) {
			tmpVOs = Arrays.copyOf(sendMtyRlseOrdVOs, sendMtyRlseOrdVOs .length);
		}
		return tmpVOs;
	}

	public void setSendMtyRlseOrdVOs(SendMtyRlseOrdVO[] sendMtyRlseOrdVOs) {
		if (sendMtyRlseOrdVOs != null) {
			SendMtyRlseOrdVO[] tmpVOs = Arrays.copyOf(sendMtyRlseOrdVOs, sendMtyRlseOrdVOs .length);
			this. sendMtyRlseOrdVOs = tmpVOs;
		}
	}


	public CustTpIdVO[] getCustTpIdVOs() {
		CustTpIdVO[] tmpVOs = null;
		if (this. custTpIdVOs != null) {
			tmpVOs = Arrays.copyOf(custTpIdVOs, custTpIdVOs .length);
		}
		return tmpVOs;
	}

	public void setCustTpIdVOs(CustTpIdVO[] custTpIdVOs) {
		if (custTpIdVOs != null) {
			CustTpIdVO[] tmpVOs = Arrays.copyOf(custTpIdVOs, custTpIdVOs .length);
			this. custTpIdVOs = tmpVOs;
		}
	}

	public String getPolCd() {
		return polCd;
	}

	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	public String[] getFrtTerm() {
		String[] tmpVOs = null;
		if (this. frtTerm != null) {
			tmpVOs = Arrays.copyOf(frtTerm, frtTerm .length);
		}
		return tmpVOs;
	}

	public void setFrtTerm(String[] frtTerm) {
		if (frtTerm != null) {
			String[] tmpVOs = Arrays.copyOf(frtTerm, frtTerm .length);
			this. frtTerm = tmpVOs;
		}
	}

	public String[] getFrtCltFlg() {
		String[] tmpVOs = null;
		if (this. frtCltFlg != null) {
			tmpVOs = Arrays.copyOf(frtCltFlg, frtCltFlg .length);
		}
		return tmpVOs;
	}

	public void setFrtCltFlg(String[] frtCltFlg) {
		if (frtCltFlg != null) {
			String[] tmpVOs = Arrays.copyOf(frtCltFlg, frtCltFlg .length);
			this. frtCltFlg = tmpVOs;
		}
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

	public String getFileDownPath() {
		return fileDownPath;
	}

	public void setFileDownPath(String fileDownPath) {
		this.fileDownPath = fileDownPath;
	}

}