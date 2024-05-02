/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgReceiptSendVO.java
*@FileTitle : BkgReceiptSendVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.03  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see
 */

public class BkgReceiptSendVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public BkgReceiptSendVO() {}

	private BkgBlNoVO[] bkgBlNoVos  = null;
	private String[]    faxNos      = null;
	private String[]    emlAddrs    = null;
	private String[]    remarks     = null;
	private String      mrdNm       = null;
	private String[]    ccts        = null;
	private String[]    docCcts     = null;
	private BkgEmlEdtVO bkgEmlEdtVo = null;
	private String      ccEmail     = null;

	public BkgBlNoVO[] getBkgBlNoVos() {
		return bkgBlNoVos;
	}
	public void setBkgBlNoVos(BkgBlNoVO[] bkgBlNoVos) {
		this.bkgBlNoVos = bkgBlNoVos;
	}
	public String[] getFaxNos() {
		return faxNos;
	}
	public void setFaxNos(String[] faxNos) {
		this.faxNos = faxNos;
	}
	public String[] getEmlAddrs() {
		return emlAddrs;
	}
	public void setEmlAddrs(String[] emlAddrs) {
		this.emlAddrs = emlAddrs;
	}
	public String[] getRemarks() {
		return remarks;
	}
	public void setRemarks(String[] remarks) {
		this.remarks = remarks;
	}
	public String getMrdNm() {
		return mrdNm;
	}
	public void setMrdNm(String mrdNm) {
		this.mrdNm = mrdNm;
	}
	public String[] getCcts() {
		return ccts;
	}
	public void setCcts(String[] ccts) {
		this.ccts = ccts;
	}
	public String[] getDocCcts() {
		return docCcts;
	}
	public void setDocCcts(String[] docCcts) {
		this.docCcts = docCcts;
	}
	public BkgEmlEdtVO getBkgEmlEdtVo() {
		return bkgEmlEdtVo;
	}
	public void setBkgEmlEdtVo(BkgEmlEdtVO bkgEmlEdtVo) {
		this.bkgEmlEdtVo = bkgEmlEdtVo;
	}
	public String getCcEmail() {
		return ccEmail;
	}
	public void setCcEmail(String ccEmail) {
		this.ccEmail = ccEmail;
	}
}
