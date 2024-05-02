/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0708HTMLAction.java
*@FileTitle : C/A Issue Reason Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.31 이남경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0708 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0708HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Nam Kyung
 * @see ESM_BKG_0708HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0708Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBlNoVO bkgBlNoVO = null;
	private String modeCd       = null; 
	private String caRsnCD      = null;
	private String bkgCorrRmk   = null;
	private String rdnNo       = null;
	private String rvisSeq     = null;
	private String rdnAcptFlg = null;
	private String umchSubTpCd = null;
	
	public EsmBkg0708Event(){}

	/**
	 * @return the bkgBlNoVO
	 */
	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	/**
	 * @param bkgBlNoVO the bkgBlNoVO to set
	 */
	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	/**
	 * @return the caRsnCD
	 */
	public String getCaRsnCD() {
		return caRsnCD;
	}

	/**
	 * @param caRsnCD the caRsnCD to set
	 */
	public void setCaRsnCD(String caRsnCD) {
		this.caRsnCD = caRsnCD;
	}

	/**
	 * @return the bkgCorrRmk
	 */
	public String getBkgCorrRmk() {
		return bkgCorrRmk;
	}

	/**
	 * @param bkgCorrRmk the bkgCorrRmk to set
	 */
	public void setBkgCorrRmk(String bkgCorrRmk) {
		this.bkgCorrRmk = bkgCorrRmk;
	}

	/**
	 * @return the modeCd
	 */
	public String getModeCd() {
		return modeCd;
	}

	/**
	 * @param modeCd the modeCd to set
	 */
	public void setModeCd(String modeCd) {
		this.modeCd = modeCd;
	}

	/**
	 * @return the rdn_no
	 */
	public String getRdnNo() {
		return rdnNo;
	}

	/**
	 * @param rdn_no the rdn_no to set
	 */
	public void setRdnNo(String rdnNo) {
		this.rdnNo = rdnNo;
	}

	/**
	 * @return the rvis_seq
	 */
	public String getRvisSeq() {
		return rvisSeq;
	}

	/**
	 * @param rvis_seq the rvis_seq to set
	 */
	public void setRvisSeq(String rvisSeq) {
		this.rvisSeq = rvisSeq;
	}

	/**
	 * @return the rdn_acpt_flg
	 */
	public String getRdnAcptFlg() {
		return rdnAcptFlg;
	}

	/**
	 * @param rdn_acpt_flg the rdn_acpt_flg to set
	 */
	public void setRdnAcptFlg(String rdnAcptFlg) {
		this.rdnAcptFlg = rdnAcptFlg;
	}

	/**
	 * @param umchSubTpCd the umchSubTpCd to set
	 */
	public void setUmchSubTpCd(String umchSubTpCd) {
		this.umchSubTpCd = umchSubTpCd;
	}

	/**
	 * @return the umchSubTpCd
	 */
	public String getUmchSubTpCd() {
		return umchSubTpCd;
	}
}