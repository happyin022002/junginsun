/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0098Event.java
*@FileTitle : Booking Receipt Notice (Fax/E-Mail)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.09.09 전용진
* 1.0 Creation
* -------------------------------------------------------
* History
* 2010.11.15 이일민 [CHM-201006562-01] Booking Receipt Notice Fax & Email Service 수정 (DOC CCT 추가 및 EDI 기능)
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBkgReceiptInputVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0098 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0098HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0098HTMLAction 참조 
 * @since J2EE 1.6
 */ 

public class EsmBkg0098Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgListForBkgReceiptInputVO bkgListForBkgReceiptInputVO = null;
	private BkgBlNoVO[] bkgBlNoVOs = null;
	private String[] fax = null;
	private String[] eml = null;
	private String[] remark = null;
	private String[] rmkChangeFlg = null;
	private String mrdNm = null;
	private String[] cct = null; 
	private String[] cctMnl = null;
	private String[] docCct = null;
	private String[] cargoCctMnl = null;
	private BkgEmlEdtVO bkgEmlEdtVO = null;
	private String custBody = null;
	private String btnTp = null;
	
	public EsmBkg0098Event(){}
	
	public BkgListForBkgReceiptInputVO getBkgListForBkgReceiptInputVO() {
		return bkgListForBkgReceiptInputVO;
	}

	public void setBkgListForBkgReceiptInputVO(
			BkgListForBkgReceiptInputVO bkgListForBkgReceiptInputVO) {
		this.bkgListForBkgReceiptInputVO = bkgListForBkgReceiptInputVO;
	}

	public BkgBlNoVO[] getBkgBlNoVOs(){
		BkgBlNoVO[] tmpVOs = null;
		if (this. bkgBlNoVOs != null) {
			tmpVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs .length);
		}
		return tmpVOs;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs){
		if (bkgBlNoVOs != null) {
			BkgBlNoVO[] tmpVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs .length);
			this. bkgBlNoVOs = tmpVOs;
		}
	}

	public String[] getFax() {
		String[] tmpVOs = null;
		if (this. fax != null) {
			tmpVOs = Arrays.copyOf(fax, fax .length);
		}
		return tmpVOs;
	}

	public void setFax(String[] fax) {
		if (fax != null) {
			String[] tmpVOs = Arrays.copyOf(fax, fax .length);
			this. fax = tmpVOs;
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
	
	public String[] getRmkChangeFlg() {
		String[] tmpVOs = null;
		if (this. rmkChangeFlg != null) {
			tmpVOs = Arrays.copyOf(rmkChangeFlg, rmkChangeFlg .length);
		}
		return tmpVOs;
	}

	public void setRmkChangeFlg(String[] rmkChangeFlg) {
		if (rmkChangeFlg != null) {
			String[] tmpVOs = Arrays.copyOf(rmkChangeFlg, rmkChangeFlg .length);
			this. rmkChangeFlg = tmpVOs;
		}
	}

	public String getMrdNm() {
		return mrdNm;
	}

	public void setMrdNm(String mrdNm) {
		this.mrdNm = mrdNm;
	}

	public String[] getCct() {
		String[] tmpVOs = null;
		if (this. cct != null) {
			tmpVOs = Arrays.copyOf(cct, cct .length);
		}
		return tmpVOs;
	}

	public void setCct(String[] cct) {
		if (cct != null) {
			String[] tmpVOs = Arrays.copyOf(cct, cct .length);
			this. cct = tmpVOs;
		}
	}
	
	public String[] getCctMnl() {
		String[] tmpVOs = null;
		if (this. cctMnl != null) {
			tmpVOs = Arrays.copyOf(cctMnl, cctMnl .length);
		}
		return tmpVOs;
	}

	public void setCctMnl(String[] cctMnl) {
		if (cctMnl != null) {
			String[] tmpVOs = Arrays.copyOf(cctMnl, cctMnl .length);
			this. cctMnl = tmpVOs;
		}
	}
	
	public String[] getDocCct() {
		String[] tmpVOs = null;
		if (this. docCct != null) {
			tmpVOs = Arrays.copyOf(docCct, docCct .length);
		}
		return tmpVOs;
	}

	public void setDocCct(String[] docCct) {
		if (docCct != null) {
			String[] tmpVOs = Arrays.copyOf(docCct, docCct .length);
			this. docCct = tmpVOs;
		}
	}

	public String[] getCargoCctMnl() {
		String[] tmpVOs = null;
		if (this. cargoCctMnl != null) {
			tmpVOs = Arrays.copyOf(cargoCctMnl, cargoCctMnl .length);
		}
		return tmpVOs;
	}

	public void setCargoCctMnl(String[] cargoCctMnl) {
		if (cargoCctMnl != null) {
			String[] tmpVOs = Arrays.copyOf(cargoCctMnl, cargoCctMnl .length);
			this. cargoCctMnl = tmpVOs;
		}
	}
	
	public BkgEmlEdtVO getBkgEmlEdtVO() {
		return bkgEmlEdtVO;
	}

	public void setBkgEmlEdtVO(BkgEmlEdtVO bkgEmlEdtVO) {
		this.bkgEmlEdtVO = bkgEmlEdtVO;
	}

	public String getCustBody() {
		return custBody;
	}

	public void setCustBody(String custBody) {
		this.custBody = custBody;
	}
	public void setBtnTp(String btnTp){
		this.btnTp = btnTp;
	}
	public String getBtnTp(){
		return btnTp;
	}

}