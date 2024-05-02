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
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBkgReceiptInputVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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
	private String mrdNm = null;
	private String[] cct = null;
	private String[] docCct = null;
	private String[] mnlRailFromCct = null;
	private String[] mnlRailToCct = null;
	private String[] mnlVgmCct = null;
	private BkgEmlEdtVO bkgEmlEdtVO = null;
	private String fileKey = null;

	public EsmBkg0098Event(){}
	
	public BkgListForBkgReceiptInputVO getBkgListForBkgReceiptInputVO() {
		return bkgListForBkgReceiptInputVO;
	}

	public void setBkgListForBkgReceiptInputVO(
			BkgListForBkgReceiptInputVO bkgListForBkgReceiptInputVO) {
		this.bkgListForBkgReceiptInputVO = bkgListForBkgReceiptInputVO;
	}

	public BkgBlNoVO[] getBkgBlNoVOs() {
		BkgBlNoVO[] rtnVOs = null;
		if (this.bkgBlNoVOs != null) {
			rtnVOs = new BkgBlNoVO[bkgBlNoVOs.length];
			System.arraycopy(bkgBlNoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs){
		if(bkgBlNoVOs != null){
			BkgBlNoVO[] tmpVOs = new BkgBlNoVO[bkgBlNoVOs.length];
			System.arraycopy(bkgBlNoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgBlNoVOs = tmpVOs;
		}
	}

	public String[] getFax() {
		String[] rtnVOs = null;
		if (this.fax != null) {
			rtnVOs = new String[fax.length];
			System.arraycopy(fax, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setFax(String[] fax){
		if(fax != null){
			String[] tmpVOs = new String[fax.length];
			System.arraycopy(fax, 0, tmpVOs, 0, tmpVOs.length);
			this.fax = tmpVOs;
		}
	}

	public String[] getEml() {
		String[] rtnVOs = null;
		if (this.eml != null) {
			rtnVOs = new String[eml.length];
			System.arraycopy(eml, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setEml(String[] eml){
		if(eml != null){
			String[] tmpVOs = new String[eml.length];
			System.arraycopy(eml, 0, tmpVOs, 0, tmpVOs.length);
			this.eml = tmpVOs;
		}
	}

	public String[] getRemark() {
		String[] rtnVOs = null;
		if (this.remark != null) {
			rtnVOs = new String[remark.length];
			System.arraycopy(remark, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setRemark(String[] remark){
		if(remark != null){
			String[] tmpVOs = new String[remark.length];
			System.arraycopy(remark, 0, tmpVOs, 0, tmpVOs.length);
			this.remark = tmpVOs;
		}
	}

	public String getMrdNm() {
		return mrdNm;
	}

	public void setMrdNm(String mrdNm) {
		this.mrdNm = mrdNm;
	}

	public String[] getCct() {
		String[] rtnVOs = null;
		if (this.cct != null) {
			rtnVOs = new String[cct.length];
			System.arraycopy(cct, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setCct(String[] cct){
		if(cct != null){
			String[] tmpVOs = new String[cct.length];
			System.arraycopy(cct, 0, tmpVOs, 0, tmpVOs.length);
			this.cct = tmpVOs;
		}
	}

	public String[] getDocCct() {
		String[] rtnVOs = null;
		if (this.docCct != null) {
			rtnVOs = new String[docCct.length];
			System.arraycopy(docCct, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setDocCct(String[] docCct){
		if(docCct != null){
			String[] tmpVOs = new String[docCct.length];
			System.arraycopy(docCct, 0, tmpVOs, 0, tmpVOs.length);
			this.docCct = tmpVOs;
		}
	}
	
	public String[] getMnlRailFromCct() {
		String[] rtnVOs = null;
		if (this.mnlRailFromCct != null) {
			rtnVOs = new String[mnlRailFromCct.length];
			System.arraycopy(mnlRailFromCct, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setMnlRailFromCct(String[] mnlRailFromCct){
		if(mnlRailFromCct != null){
			String[] tmpVOs = new String[mnlRailFromCct.length];
			System.arraycopy(mnlRailFromCct, 0, tmpVOs, 0, tmpVOs.length);
			this.mnlRailFromCct = tmpVOs;
		}
	}
	
	public String[] getMnlRailToCct() {
		String[] rtnVOs = null;
		if (this.mnlRailToCct != null) {
			rtnVOs = new String[mnlRailToCct.length];
			System.arraycopy(mnlRailToCct, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setMnlRailToCct(String[] mnlRailToCct){
		if(mnlRailToCct != null){
			String[] tmpVOs = new String[mnlRailToCct.length];
			System.arraycopy(mnlRailToCct, 0, tmpVOs, 0, tmpVOs.length);
			this.mnlRailToCct = tmpVOs;
		}
	}

	public String[] getMnlVgmCct() {
		String[] rtnVOs = null;
		if (this.mnlVgmCct != null) {
			rtnVOs = new String[mnlVgmCct.length];
			System.arraycopy(mnlVgmCct, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
 
	public void setMnlVgmCct(String[] mnlVgmCct){
		if(mnlVgmCct != null){
			String[] tmpVOs = new String[mnlVgmCct.length];
			System.arraycopy(mnlVgmCct, 0, tmpVOs, 0, tmpVOs.length);
			this.mnlVgmCct = tmpVOs;
		}
	}
	
	public BkgEmlEdtVO getBkgEmlEdtVO() {
		return bkgEmlEdtVO;
	}

	public void setBkgEmlEdtVO(BkgEmlEdtVO bkgEmlEdtVO) {
		this.bkgEmlEdtVO = bkgEmlEdtVO;
	}
	public String getFileKey() {
		return fileKey;
	}

	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}

}