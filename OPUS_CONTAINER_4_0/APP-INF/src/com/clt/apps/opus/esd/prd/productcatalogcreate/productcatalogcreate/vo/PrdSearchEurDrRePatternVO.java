/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PrdSearchEurDrRePatternVO.java
*@FileTitle : PrdSearchEurDrRePatternVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 조용인
*@LastVersion : 1.0
* 2010.03.24 조용인 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 조용인
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PrdSearchEurDrRePatternVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PrdSearchEurDrRePatternVO> models = new ArrayList<PrdSearchEurDrRePatternVO>();
	
	/* Column Info */
	private String orgLocCd = null;
	/* Column Info */
	private String destLocCd = null;
	/* Column Info */
	private String n3PolClptSeq = null;
	/* Column Info */
	private String obContent = null;
	/* Column Info */
	private String n2PolClptSeq = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String n3PodClptSeq = null;
	/* Column Info */
	private String mtyPkupYdCd = null;
	/* Column Info */
	private String bkgRcvTermCd = null;
	/* Column Info */
	private String polT = null;
	/* Column Info */
	private String ibTrspMod = null;
	/* Column Info */
	private String cct = null;
	/* Column Info */
	private String copPattOrdNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podT = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tVvd = null;
	/* Column Info */
	private String n2PodClptSeq = null;
	/* Column Info */
	private String n1PolClptSeq = null;
	/* Column Info */
	private String obTrspMod = null;
	/* Column Info */
	private String fullPkupYdCd = null;
	/* Column Info */
	private String ocnContent = null;
	/* Column Info */
	private String n1PodClptSeq = null;
	/* Column Info */
	private String n4PolClptSeq = null;
	/* Column Info */
	private String eurObFlg = null;
	/* Column Info */
	private String newPor = null;
	/* Column Info */
	private String ocnSeq = null;
	/* Column Info */
	private String newPctlNo = null;
	/* Column Info */
	private String eurIbFlg = null;
	/* Column Info */
	private String vvd2 = null;
	/* Column Info */
	private String fullRtnYdCd = null;
	/* Column Info */
	private String vvd3 = null;
	/* Column Info */
	private String vvd1 = null;
	/* Column Info */
	private String podTmlDiffFlg = null;
	/* Column Info */
	private String vvd4 = null;
	/* Column Info */
	private String newPod = null;
	/* Column Info */
	private String n4PodClptSeq = null;
	/* Column Info */
	private String obUnconfirmFlg = null;
	/* Column Info */
	private String oldPctlNo = null;
	/* Column Info */
	private String mtyRtnYdCd = null;
	/* Column Info */
	private String polTmlDiffFlg = null;
	/* Column Info */
	private String newPol = null;
	/* Column Info */
	private String bkgDeTermCd = null;
	/* Column Info */
	private String ibUnconfirmFlg = null;
	/* Column Info */
	private String newDel = null;
	/* Column Info */
	private String ibContent = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PrdSearchEurDrRePatternVO() {}

	public PrdSearchEurDrRePatternVO(String ibflag, String pagerows, String copNo, String copPattOrdNo, String newPctlNo, String oldPctlNo, String eurObFlg, String bkgRcvTermCd, String obUnconfirmFlg, String polTmlDiffFlg, String newPor, String newPol, String mtyPkupYdCd, String fullRtnYdCd, String obTrspMod, String eurIbFlg, String bkgDeTermCd, String ibUnconfirmFlg, String podTmlDiffFlg, String newPod, String newDel, String fullPkupYdCd, String mtyRtnYdCd, String ibTrspMod, String obContent, String ibContent, String ocnContent, String cct, String polT, String podT, String tVvd, String orgLocCd, String destLocCd, String ocnSeq, String vvd1, String vvd2, String vvd3, String vvd4, String n1PolClptSeq, String n1PodClptSeq, String n2PolClptSeq, String n2PodClptSeq, String n3PolClptSeq, String n3PodClptSeq, String n4PolClptSeq, String n4PodClptSeq) {
		this.orgLocCd = orgLocCd;
		this.destLocCd = destLocCd;
		this.n3PolClptSeq = n3PolClptSeq;
		this.obContent = obContent;
		this.n2PolClptSeq = n2PolClptSeq;
		this.copNo = copNo;
		this.n3PodClptSeq = n3PodClptSeq;
		this.mtyPkupYdCd = mtyPkupYdCd;
		this.bkgRcvTermCd = bkgRcvTermCd;
		this.polT = polT;
		this.ibTrspMod = ibTrspMod;
		this.cct = cct;
		this.copPattOrdNo = copPattOrdNo;
		this.pagerows = pagerows;
		this.podT = podT;
		this.ibflag = ibflag;
		this.tVvd = tVvd;
		this.n2PodClptSeq = n2PodClptSeq;
		this.n1PolClptSeq = n1PolClptSeq;
		this.obTrspMod = obTrspMod;
		this.fullPkupYdCd = fullPkupYdCd;
		this.ocnContent = ocnContent;
		this.n1PodClptSeq = n1PodClptSeq;
		this.n4PolClptSeq = n4PolClptSeq;
		this.eurObFlg = eurObFlg;
		this.newPor = newPor;
		this.ocnSeq = ocnSeq;
		this.newPctlNo = newPctlNo;
		this.eurIbFlg = eurIbFlg;
		this.vvd2 = vvd2;
		this.fullRtnYdCd = fullRtnYdCd;
		this.vvd3 = vvd3;
		this.vvd1 = vvd1;
		this.podTmlDiffFlg = podTmlDiffFlg;
		this.vvd4 = vvd4;
		this.newPod = newPod;
		this.n4PodClptSeq = n4PodClptSeq;
		this.obUnconfirmFlg = obUnconfirmFlg;
		this.oldPctlNo = oldPctlNo;
		this.mtyRtnYdCd = mtyRtnYdCd;
		this.polTmlDiffFlg = polTmlDiffFlg;
		this.newPol = newPol;
		this.bkgDeTermCd = bkgDeTermCd;
		this.ibUnconfirmFlg = ibUnconfirmFlg;
		this.newDel = newDel;
		this.ibContent = ibContent;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("org_loc_cd", getOrgLocCd());
		this.hashColumns.put("dest_loc_cd", getDestLocCd());
		this.hashColumns.put("n3_pol_clpt_seq", getN3PolClptSeq());
		this.hashColumns.put("ob_content", getObContent());
		this.hashColumns.put("n2_pol_clpt_seq", getN2PolClptSeq());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("n3_pod_clpt_seq", getN3PodClptSeq());
		this.hashColumns.put("mty_pkup_yd_cd", getMtyPkupYdCd());
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
		this.hashColumns.put("pol_t", getPolT());
		this.hashColumns.put("ib_trsp_mod", getIbTrspMod());
		this.hashColumns.put("cct", getCct());
		this.hashColumns.put("cop_patt_ord_no", getCopPattOrdNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_t", getPodT());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("n2_pod_clpt_seq", getN2PodClptSeq());
		this.hashColumns.put("n1_pol_clpt_seq", getN1PolClptSeq());
		this.hashColumns.put("ob_trsp_mod", getObTrspMod());
		this.hashColumns.put("full_pkup_yd_cd", getFullPkupYdCd());
		this.hashColumns.put("ocn_content", getOcnContent());
		this.hashColumns.put("n1_pod_clpt_seq", getN1PodClptSeq());
		this.hashColumns.put("n4_pol_clpt_seq", getN4PolClptSeq());
		this.hashColumns.put("eur_ob_flg", getEurObFlg());
		this.hashColumns.put("new_por", getNewPor());
		this.hashColumns.put("ocn_seq", getOcnSeq());
		this.hashColumns.put("new_pctl_no", getNewPctlNo());
		this.hashColumns.put("eur_ib_flg", getEurIbFlg());
		this.hashColumns.put("vvd2", getVvd2());
		this.hashColumns.put("full_rtn_yd_cd", getFullRtnYdCd());
		this.hashColumns.put("vvd3", getVvd3());
		this.hashColumns.put("vvd1", getVvd1());
		this.hashColumns.put("pod_tml_diff_flg", getPodTmlDiffFlg());
		this.hashColumns.put("vvd4", getVvd4());
		this.hashColumns.put("new_pod", getNewPod());
		this.hashColumns.put("n4_pod_clpt_seq", getN4PodClptSeq());
		this.hashColumns.put("ob_unconfirm_flg", getObUnconfirmFlg());
		this.hashColumns.put("old_pctl_no", getOldPctlNo());
		this.hashColumns.put("mty_rtn_yd_cd", getMtyRtnYdCd());
		this.hashColumns.put("pol_tml_diff_flg", getPolTmlDiffFlg());
		this.hashColumns.put("new_pol", getNewPol());
		this.hashColumns.put("bkg_de_term_cd", getBkgDeTermCd());
		this.hashColumns.put("ib_unconfirm_flg", getIbUnconfirmFlg());
		this.hashColumns.put("new_del", getNewDel());
		this.hashColumns.put("ib_content", getIbContent());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("org_loc_cd", "orgLocCd");
		this.hashFields.put("dest_loc_cd", "destLocCd");
		this.hashFields.put("n3_pol_clpt_seq", "n3PolClptSeq");
		this.hashFields.put("ob_content", "obContent");
		this.hashFields.put("n2_pol_clpt_seq", "n2PolClptSeq");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("n3_pod_clpt_seq", "n3PodClptSeq");
		this.hashFields.put("mty_pkup_yd_cd", "mtyPkupYdCd");
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("pol_t", "polT");
		this.hashFields.put("ib_trsp_mod", "ibTrspMod");
		this.hashFields.put("cct", "cct");
		this.hashFields.put("cop_patt_ord_no", "copPattOrdNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_t", "podT");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("n2_pod_clpt_seq", "n2PodClptSeq");
		this.hashFields.put("n1_pol_clpt_seq", "n1PolClptSeq");
		this.hashFields.put("ob_trsp_mod", "obTrspMod");
		this.hashFields.put("full_pkup_yd_cd", "fullPkupYdCd");
		this.hashFields.put("ocn_content", "ocnContent");
		this.hashFields.put("n1_pod_clpt_seq", "n1PodClptSeq");
		this.hashFields.put("n4_pol_clpt_seq", "n4PolClptSeq");
		this.hashFields.put("eur_ob_flg", "eurObFlg");
		this.hashFields.put("new_por", "newPor");
		this.hashFields.put("ocn_seq", "ocnSeq");
		this.hashFields.put("new_pctl_no", "newPctlNo");
		this.hashFields.put("eur_ib_flg", "eurIbFlg");
		this.hashFields.put("vvd2", "vvd2");
		this.hashFields.put("full_rtn_yd_cd", "fullRtnYdCd");
		this.hashFields.put("vvd3", "vvd3");
		this.hashFields.put("vvd1", "vvd1");
		this.hashFields.put("pod_tml_diff_flg", "podTmlDiffFlg");
		this.hashFields.put("vvd4", "vvd4");
		this.hashFields.put("new_pod", "newPod");
		this.hashFields.put("n4_pod_clpt_seq", "n4PodClptSeq");
		this.hashFields.put("ob_unconfirm_flg", "obUnconfirmFlg");
		this.hashFields.put("old_pctl_no", "oldPctlNo");
		this.hashFields.put("mty_rtn_yd_cd", "mtyRtnYdCd");
		this.hashFields.put("pol_tml_diff_flg", "polTmlDiffFlg");
		this.hashFields.put("new_pol", "newPol");
		this.hashFields.put("bkg_de_term_cd", "bkgDeTermCd");
		this.hashFields.put("ib_unconfirm_flg", "ibUnconfirmFlg");
		this.hashFields.put("new_del", "newDel");
		this.hashFields.put("ib_content", "ibContent");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return orgLocCd
	 */
	public String getOrgLocCd() {
		return this.orgLocCd;
	}
	
	/**
	 * Column Info
	 * @return destLocCd
	 */
	public String getDestLocCd() {
		return this.destLocCd;
	}
	
	/**
	 * Column Info
	 * @return n3PolClptSeq
	 */
	public String getN3PolClptSeq() {
		return this.n3PolClptSeq;
	}
	
	/**
	 * Column Info
	 * @return obContent
	 */
	public String getObContent() {
		return this.obContent;
	}
	
	/**
	 * Column Info
	 * @return n2PolClptSeq
	 */
	public String getN2PolClptSeq() {
		return this.n2PolClptSeq;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return n3PodClptSeq
	 */
	public String getN3PodClptSeq() {
		return this.n3PodClptSeq;
	}
	
	/**
	 * Column Info
	 * @return mtyPkupYdCd
	 */
	public String getMtyPkupYdCd() {
		return this.mtyPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @return bkgRcvTermCd
	 */
	public String getBkgRcvTermCd() {
		return this.bkgRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return polT
	 */
	public String getPolT() {
		return this.polT;
	}
	
	/**
	 * Column Info
	 * @return ibTrspMod
	 */
	public String getIbTrspMod() {
		return this.ibTrspMod;
	}
	
	/**
	 * Column Info
	 * @return cct
	 */
	public String getCct() {
		return this.cct;
	}
	
	/**
	 * Column Info
	 * @return copPattOrdNo
	 */
	public String getCopPattOrdNo() {
		return this.copPattOrdNo;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return podT
	 */
	public String getPodT() {
		return this.podT;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return tVvd
	 */
	public String getTVvd() {
		return this.tVvd;
	}
	
	/**
	 * Column Info
	 * @return n2PodClptSeq
	 */
	public String getN2PodClptSeq() {
		return this.n2PodClptSeq;
	}
	
	/**
	 * Column Info
	 * @return n1PolClptSeq
	 */
	public String getN1PolClptSeq() {
		return this.n1PolClptSeq;
	}
	
	/**
	 * Column Info
	 * @return obTrspMod
	 */
	public String getObTrspMod() {
		return this.obTrspMod;
	}
	
	/**
	 * Column Info
	 * @return fullPkupYdCd
	 */
	public String getFullPkupYdCd() {
		return this.fullPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @return ocnContent
	 */
	public String getOcnContent() {
		return this.ocnContent;
	}
	
	/**
	 * Column Info
	 * @return n1PodClptSeq
	 */
	public String getN1PodClptSeq() {
		return this.n1PodClptSeq;
	}
	
	/**
	 * Column Info
	 * @return n4PolClptSeq
	 */
	public String getN4PolClptSeq() {
		return this.n4PolClptSeq;
	}
	
	/**
	 * Column Info
	 * @return eurObFlg
	 */
	public String getEurObFlg() {
		return this.eurObFlg;
	}
	
	/**
	 * Column Info
	 * @return newPor
	 */
	public String getNewPor() {
		return this.newPor;
	}
	
	/**
	 * Column Info
	 * @return ocnSeq
	 */
	public String getOcnSeq() {
		return this.ocnSeq;
	}
	
	/**
	 * Column Info
	 * @return newPctlNo
	 */
	public String getNewPctlNo() {
		return this.newPctlNo;
	}
	
	/**
	 * Column Info
	 * @return eurIbFlg
	 */
	public String getEurIbFlg() {
		return this.eurIbFlg;
	}
	
	/**
	 * Column Info
	 * @return vvd2
	 */
	public String getVvd2() {
		return this.vvd2;
	}
	
	/**
	 * Column Info
	 * @return fullRtnYdCd
	 */
	public String getFullRtnYdCd() {
		return this.fullRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return vvd3
	 */
	public String getVvd3() {
		return this.vvd3;
	}
	
	/**
	 * Column Info
	 * @return vvd1
	 */
	public String getVvd1() {
		return this.vvd1;
	}
	
	/**
	 * Column Info
	 * @return podTmlDiffFlg
	 */
	public String getPodTmlDiffFlg() {
		return this.podTmlDiffFlg;
	}
	
	/**
	 * Column Info
	 * @return vvd4
	 */
	public String getVvd4() {
		return this.vvd4;
	}
	
	/**
	 * Column Info
	 * @return newPod
	 */
	public String getNewPod() {
		return this.newPod;
	}
	
	/**
	 * Column Info
	 * @return n4PodClptSeq
	 */
	public String getN4PodClptSeq() {
		return this.n4PodClptSeq;
	}
	
	/**
	 * Column Info
	 * @return obUnconfirmFlg
	 */
	public String getObUnconfirmFlg() {
		return this.obUnconfirmFlg;
	}
	
	/**
	 * Column Info
	 * @return oldPctlNo
	 */
	public String getOldPctlNo() {
		return this.oldPctlNo;
	}
	
	/**
	 * Column Info
	 * @return mtyRtnYdCd
	 */
	public String getMtyRtnYdCd() {
		return this.mtyRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return polTmlDiffFlg
	 */
	public String getPolTmlDiffFlg() {
		return this.polTmlDiffFlg;
	}
	
	/**
	 * Column Info
	 * @return newPol
	 */
	public String getNewPol() {
		return this.newPol;
	}
	
	/**
	 * Column Info
	 * @return bkgDeTermCd
	 */
	public String getBkgDeTermCd() {
		return this.bkgDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return ibUnconfirmFlg
	 */
	public String getIbUnconfirmFlg() {
		return this.ibUnconfirmFlg;
	}
	
	/**
	 * Column Info
	 * @return newDel
	 */
	public String getNewDel() {
		return this.newDel;
	}
	
	/**
	 * Column Info
	 * @return ibContent
	 */
	public String getIbContent() {
		return this.ibContent;
	}
	

	/**
	 * Column Info
	 * @param orgLocCd
	 */
	public void setOrgLocCd(String orgLocCd) {
		this.orgLocCd = orgLocCd;
	}
	
	/**
	 * Column Info
	 * @param destLocCd
	 */
	public void setDestLocCd(String destLocCd) {
		this.destLocCd = destLocCd;
	}
	
	/**
	 * Column Info
	 * @param n3PolClptSeq
	 */
	public void setN3PolClptSeq(String n3PolClptSeq) {
		this.n3PolClptSeq = n3PolClptSeq;
	}
	
	/**
	 * Column Info
	 * @param obContent
	 */
	public void setObContent(String obContent) {
		this.obContent = obContent;
	}
	
	/**
	 * Column Info
	 * @param n2PolClptSeq
	 */
	public void setN2PolClptSeq(String n2PolClptSeq) {
		this.n2PolClptSeq = n2PolClptSeq;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param n3PodClptSeq
	 */
	public void setN3PodClptSeq(String n3PodClptSeq) {
		this.n3PodClptSeq = n3PodClptSeq;
	}
	
	/**
	 * Column Info
	 * @param mtyPkupYdCd
	 */
	public void setMtyPkupYdCd(String mtyPkupYdCd) {
		this.mtyPkupYdCd = mtyPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @param bkgRcvTermCd
	 */
	public void setBkgRcvTermCd(String bkgRcvTermCd) {
		this.bkgRcvTermCd = bkgRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param polT
	 */
	public void setPolT(String polT) {
		this.polT = polT;
	}
	
	/**
	 * Column Info
	 * @param ibTrspMod
	 */
	public void setIbTrspMod(String ibTrspMod) {
		this.ibTrspMod = ibTrspMod;
	}
	
	/**
	 * Column Info
	 * @param cct
	 */
	public void setCct(String cct) {
		this.cct = cct;
	}
	
	/**
	 * Column Info
	 * @param copPattOrdNo
	 */
	public void setCopPattOrdNo(String copPattOrdNo) {
		this.copPattOrdNo = copPattOrdNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param podT
	 */
	public void setPodT(String podT) {
		this.podT = podT;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param tVvd
	 */
	public void setTVvd(String tVvd) {
		this.tVvd = tVvd;
	}
	
	/**
	 * Column Info
	 * @param n2PodClptSeq
	 */
	public void setN2PodClptSeq(String n2PodClptSeq) {
		this.n2PodClptSeq = n2PodClptSeq;
	}
	
	/**
	 * Column Info
	 * @param n1PolClptSeq
	 */
	public void setN1PolClptSeq(String n1PolClptSeq) {
		this.n1PolClptSeq = n1PolClptSeq;
	}
	
	/**
	 * Column Info
	 * @param obTrspMod
	 */
	public void setObTrspMod(String obTrspMod) {
		this.obTrspMod = obTrspMod;
	}
	
	/**
	 * Column Info
	 * @param fullPkupYdCd
	 */
	public void setFullPkupYdCd(String fullPkupYdCd) {
		this.fullPkupYdCd = fullPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @param ocnContent
	 */
	public void setOcnContent(String ocnContent) {
		this.ocnContent = ocnContent;
	}
	
	/**
	 * Column Info
	 * @param n1PodClptSeq
	 */
	public void setN1PodClptSeq(String n1PodClptSeq) {
		this.n1PodClptSeq = n1PodClptSeq;
	}
	
	/**
	 * Column Info
	 * @param n4PolClptSeq
	 */
	public void setN4PolClptSeq(String n4PolClptSeq) {
		this.n4PolClptSeq = n4PolClptSeq;
	}
	
	/**
	 * Column Info
	 * @param eurObFlg
	 */
	public void setEurObFlg(String eurObFlg) {
		this.eurObFlg = eurObFlg;
	}
	
	/**
	 * Column Info
	 * @param newPor
	 */
	public void setNewPor(String newPor) {
		this.newPor = newPor;
	}
	
	/**
	 * Column Info
	 * @param ocnSeq
	 */
	public void setOcnSeq(String ocnSeq) {
		this.ocnSeq = ocnSeq;
	}
	
	/**
	 * Column Info
	 * @param newPctlNo
	 */
	public void setNewPctlNo(String newPctlNo) {
		this.newPctlNo = newPctlNo;
	}
	
	/**
	 * Column Info
	 * @param eurIbFlg
	 */
	public void setEurIbFlg(String eurIbFlg) {
		this.eurIbFlg = eurIbFlg;
	}
	
	/**
	 * Column Info
	 * @param vvd2
	 */
	public void setVvd2(String vvd2) {
		this.vvd2 = vvd2;
	}
	
	/**
	 * Column Info
	 * @param fullRtnYdCd
	 */
	public void setFullRtnYdCd(String fullRtnYdCd) {
		this.fullRtnYdCd = fullRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param vvd3
	 */
	public void setVvd3(String vvd3) {
		this.vvd3 = vvd3;
	}
	
	/**
	 * Column Info
	 * @param vvd1
	 */
	public void setVvd1(String vvd1) {
		this.vvd1 = vvd1;
	}
	
	/**
	 * Column Info
	 * @param podTmlDiffFlg
	 */
	public void setPodTmlDiffFlg(String podTmlDiffFlg) {
		this.podTmlDiffFlg = podTmlDiffFlg;
	}
	
	/**
	 * Column Info
	 * @param vvd4
	 */
	public void setVvd4(String vvd4) {
		this.vvd4 = vvd4;
	}
	
	/**
	 * Column Info
	 * @param newPod
	 */
	public void setNewPod(String newPod) {
		this.newPod = newPod;
	}
	
	/**
	 * Column Info
	 * @param n4PodClptSeq
	 */
	public void setN4PodClptSeq(String n4PodClptSeq) {
		this.n4PodClptSeq = n4PodClptSeq;
	}
	
	/**
	 * Column Info
	 * @param obUnconfirmFlg
	 */
	public void setObUnconfirmFlg(String obUnconfirmFlg) {
		this.obUnconfirmFlg = obUnconfirmFlg;
	}
	
	/**
	 * Column Info
	 * @param oldPctlNo
	 */
	public void setOldPctlNo(String oldPctlNo) {
		this.oldPctlNo = oldPctlNo;
	}
	
	/**
	 * Column Info
	 * @param mtyRtnYdCd
	 */
	public void setMtyRtnYdCd(String mtyRtnYdCd) {
		this.mtyRtnYdCd = mtyRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param polTmlDiffFlg
	 */
	public void setPolTmlDiffFlg(String polTmlDiffFlg) {
		this.polTmlDiffFlg = polTmlDiffFlg;
	}
	
	/**
	 * Column Info
	 * @param newPol
	 */
	public void setNewPol(String newPol) {
		this.newPol = newPol;
	}
	
	/**
	 * Column Info
	 * @param bkgDeTermCd
	 */
	public void setBkgDeTermCd(String bkgDeTermCd) {
		this.bkgDeTermCd = bkgDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param ibUnconfirmFlg
	 */
	public void setIbUnconfirmFlg(String ibUnconfirmFlg) {
		this.ibUnconfirmFlg = ibUnconfirmFlg;
	}
	
	/**
	 * Column Info
	 * @param newDel
	 */
	public void setNewDel(String newDel) {
		this.newDel = newDel;
	}
	
	/**
	 * Column Info
	 * @param ibContent
	 */
	public void setIbContent(String ibContent) {
		this.ibContent = ibContent;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setOrgLocCd(JSPUtil.getParameter(request, prefix + "org_loc_cd", ""));
		setDestLocCd(JSPUtil.getParameter(request, prefix + "dest_loc_cd", ""));
		setN3PolClptSeq(JSPUtil.getParameter(request, prefix + "n3_pol_clpt_seq", ""));
		setObContent(JSPUtil.getParameter(request, prefix + "ob_content", ""));
		setN2PolClptSeq(JSPUtil.getParameter(request, prefix + "n2_pol_clpt_seq", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setN3PodClptSeq(JSPUtil.getParameter(request, prefix + "n3_pod_clpt_seq", ""));
		setMtyPkupYdCd(JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", ""));
		setBkgRcvTermCd(JSPUtil.getParameter(request, prefix + "bkg_rcv_term_cd", ""));
		setPolT(JSPUtil.getParameter(request, prefix + "pol_t", ""));
		setIbTrspMod(JSPUtil.getParameter(request, prefix + "ib_trsp_mod", ""));
		setCct(JSPUtil.getParameter(request, prefix + "cct", ""));
		setCopPattOrdNo(JSPUtil.getParameter(request, prefix + "cop_patt_ord_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodT(JSPUtil.getParameter(request, prefix + "pod_t", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTVvd(JSPUtil.getParameter(request, prefix + "t_vvd", ""));
		setN2PodClptSeq(JSPUtil.getParameter(request, prefix + "n2_pod_clpt_seq", ""));
		setN1PolClptSeq(JSPUtil.getParameter(request, prefix + "n1_pol_clpt_seq", ""));
		setObTrspMod(JSPUtil.getParameter(request, prefix + "ob_trsp_mod", ""));
		setFullPkupYdCd(JSPUtil.getParameter(request, prefix + "full_pkup_yd_cd", ""));
		setOcnContent(JSPUtil.getParameter(request, prefix + "ocn_content", ""));
		setN1PodClptSeq(JSPUtil.getParameter(request, prefix + "n1_pod_clpt_seq", ""));
		setN4PolClptSeq(JSPUtil.getParameter(request, prefix + "n4_pol_clpt_seq", ""));
		setEurObFlg(JSPUtil.getParameter(request, prefix + "eur_ob_flg", ""));
		setNewPor(JSPUtil.getParameter(request, prefix + "new_por", ""));
		setOcnSeq(JSPUtil.getParameter(request, prefix + "ocn_seq", ""));
		setNewPctlNo(JSPUtil.getParameter(request, prefix + "new_pctl_no", ""));
		setEurIbFlg(JSPUtil.getParameter(request, prefix + "eur_ib_flg", ""));
		setVvd2(JSPUtil.getParameter(request, prefix + "vvd2", ""));
		setFullRtnYdCd(JSPUtil.getParameter(request, prefix + "full_rtn_yd_cd", ""));
		setVvd3(JSPUtil.getParameter(request, prefix + "vvd3", ""));
		setVvd1(JSPUtil.getParameter(request, prefix + "vvd1", ""));
		setPodTmlDiffFlg(JSPUtil.getParameter(request, prefix + "pod_tml_diff_flg", ""));
		setVvd4(JSPUtil.getParameter(request, prefix + "vvd4", ""));
		setNewPod(JSPUtil.getParameter(request, prefix + "new_pod", ""));
		setN4PodClptSeq(JSPUtil.getParameter(request, prefix + "n4_pod_clpt_seq", ""));
		setObUnconfirmFlg(JSPUtil.getParameter(request, prefix + "ob_unconfirm_flg", ""));
		setOldPctlNo(JSPUtil.getParameter(request, prefix + "old_pctl_no", ""));
		setMtyRtnYdCd(JSPUtil.getParameter(request, prefix + "mty_rtn_yd_cd", ""));
		setPolTmlDiffFlg(JSPUtil.getParameter(request, prefix + "pol_tml_diff_flg", ""));
		setNewPol(JSPUtil.getParameter(request, prefix + "new_pol", ""));
		setBkgDeTermCd(JSPUtil.getParameter(request, prefix + "bkg_de_term_cd", ""));
		setIbUnconfirmFlg(JSPUtil.getParameter(request, prefix + "ib_unconfirm_flg", ""));
		setNewDel(JSPUtil.getParameter(request, prefix + "new_del", ""));
		setIbContent(JSPUtil.getParameter(request, prefix + "ib_content", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PrdSearchEurDrRePatternVO[]
	 */
	public PrdSearchEurDrRePatternVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PrdSearchEurDrRePatternVO[]
	 */
	public PrdSearchEurDrRePatternVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PrdSearchEurDrRePatternVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] orgLocCd = (JSPUtil.getParameter(request, prefix	+ "org_loc_cd", length));
			String[] destLocCd = (JSPUtil.getParameter(request, prefix	+ "dest_loc_cd", length));
			String[] n3PolClptSeq = (JSPUtil.getParameter(request, prefix	+ "n3_pol_clpt_seq", length));
			String[] obContent = (JSPUtil.getParameter(request, prefix	+ "ob_content", length));
			String[] n2PolClptSeq = (JSPUtil.getParameter(request, prefix	+ "n2_pol_clpt_seq", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] n3PodClptSeq = (JSPUtil.getParameter(request, prefix	+ "n3_pod_clpt_seq", length));
			String[] mtyPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_yd_cd", length));
			String[] bkgRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_term_cd", length));
			String[] polT = (JSPUtil.getParameter(request, prefix	+ "pol_t", length));
			String[] ibTrspMod = (JSPUtil.getParameter(request, prefix	+ "ib_trsp_mod", length));
			String[] cct = (JSPUtil.getParameter(request, prefix	+ "cct", length));
			String[] copPattOrdNo = (JSPUtil.getParameter(request, prefix	+ "cop_patt_ord_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podT = (JSPUtil.getParameter(request, prefix	+ "pod_t", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix	+ "t_vvd", length));
			String[] n2PodClptSeq = (JSPUtil.getParameter(request, prefix	+ "n2_pod_clpt_seq", length));
			String[] n1PolClptSeq = (JSPUtil.getParameter(request, prefix	+ "n1_pol_clpt_seq", length));
			String[] obTrspMod = (JSPUtil.getParameter(request, prefix	+ "ob_trsp_mod", length));
			String[] fullPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "full_pkup_yd_cd", length));
			String[] ocnContent = (JSPUtil.getParameter(request, prefix	+ "ocn_content", length));
			String[] n1PodClptSeq = (JSPUtil.getParameter(request, prefix	+ "n1_pod_clpt_seq", length));
			String[] n4PolClptSeq = (JSPUtil.getParameter(request, prefix	+ "n4_pol_clpt_seq", length));
			String[] eurObFlg = (JSPUtil.getParameter(request, prefix	+ "eur_ob_flg", length));
			String[] newPor = (JSPUtil.getParameter(request, prefix	+ "new_por", length));
			String[] ocnSeq = (JSPUtil.getParameter(request, prefix	+ "ocn_seq", length));
			String[] newPctlNo = (JSPUtil.getParameter(request, prefix	+ "new_pctl_no", length));
			String[] eurIbFlg = (JSPUtil.getParameter(request, prefix	+ "eur_ib_flg", length));
			String[] vvd2 = (JSPUtil.getParameter(request, prefix	+ "vvd2", length));
			String[] fullRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "full_rtn_yd_cd", length));
			String[] vvd3 = (JSPUtil.getParameter(request, prefix	+ "vvd3", length));
			String[] vvd1 = (JSPUtil.getParameter(request, prefix	+ "vvd1", length));
			String[] podTmlDiffFlg = (JSPUtil.getParameter(request, prefix	+ "pod_tml_diff_flg", length));
			String[] vvd4 = (JSPUtil.getParameter(request, prefix	+ "vvd4", length));
			String[] newPod = (JSPUtil.getParameter(request, prefix	+ "new_pod", length));
			String[] n4PodClptSeq = (JSPUtil.getParameter(request, prefix	+ "n4_pod_clpt_seq", length));
			String[] obUnconfirmFlg = (JSPUtil.getParameter(request, prefix	+ "ob_unconfirm_flg", length));
			String[] oldPctlNo = (JSPUtil.getParameter(request, prefix	+ "old_pctl_no", length));
			String[] mtyRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_rtn_yd_cd", length));
			String[] polTmlDiffFlg = (JSPUtil.getParameter(request, prefix	+ "pol_tml_diff_flg", length));
			String[] newPol = (JSPUtil.getParameter(request, prefix	+ "new_pol", length));
			String[] bkgDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_de_term_cd", length));
			String[] ibUnconfirmFlg = (JSPUtil.getParameter(request, prefix	+ "ib_unconfirm_flg", length));
			String[] newDel = (JSPUtil.getParameter(request, prefix	+ "new_del", length));
			String[] ibContent = (JSPUtil.getParameter(request, prefix	+ "ib_content", length));
			
			for (int i = 0; i < length; i++) {
				model = new PrdSearchEurDrRePatternVO();
				if (orgLocCd[i] != null)
					model.setOrgLocCd(orgLocCd[i]);
				if (destLocCd[i] != null)
					model.setDestLocCd(destLocCd[i]);
				if (n3PolClptSeq[i] != null)
					model.setN3PolClptSeq(n3PolClptSeq[i]);
				if (obContent[i] != null)
					model.setObContent(obContent[i]);
				if (n2PolClptSeq[i] != null)
					model.setN2PolClptSeq(n2PolClptSeq[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (n3PodClptSeq[i] != null)
					model.setN3PodClptSeq(n3PodClptSeq[i]);
				if (mtyPkupYdCd[i] != null)
					model.setMtyPkupYdCd(mtyPkupYdCd[i]);
				if (bkgRcvTermCd[i] != null)
					model.setBkgRcvTermCd(bkgRcvTermCd[i]);
				if (polT[i] != null)
					model.setPolT(polT[i]);
				if (ibTrspMod[i] != null)
					model.setIbTrspMod(ibTrspMod[i]);
				if (cct[i] != null)
					model.setCct(cct[i]);
				if (copPattOrdNo[i] != null)
					model.setCopPattOrdNo(copPattOrdNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podT[i] != null)
					model.setPodT(podT[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (n2PodClptSeq[i] != null)
					model.setN2PodClptSeq(n2PodClptSeq[i]);
				if (n1PolClptSeq[i] != null)
					model.setN1PolClptSeq(n1PolClptSeq[i]);
				if (obTrspMod[i] != null)
					model.setObTrspMod(obTrspMod[i]);
				if (fullPkupYdCd[i] != null)
					model.setFullPkupYdCd(fullPkupYdCd[i]);
				if (ocnContent[i] != null)
					model.setOcnContent(ocnContent[i]);
				if (n1PodClptSeq[i] != null)
					model.setN1PodClptSeq(n1PodClptSeq[i]);
				if (n4PolClptSeq[i] != null)
					model.setN4PolClptSeq(n4PolClptSeq[i]);
				if (eurObFlg[i] != null)
					model.setEurObFlg(eurObFlg[i]);
				if (newPor[i] != null)
					model.setNewPor(newPor[i]);
				if (ocnSeq[i] != null)
					model.setOcnSeq(ocnSeq[i]);
				if (newPctlNo[i] != null)
					model.setNewPctlNo(newPctlNo[i]);
				if (eurIbFlg[i] != null)
					model.setEurIbFlg(eurIbFlg[i]);
				if (vvd2[i] != null)
					model.setVvd2(vvd2[i]);
				if (fullRtnYdCd[i] != null)
					model.setFullRtnYdCd(fullRtnYdCd[i]);
				if (vvd3[i] != null)
					model.setVvd3(vvd3[i]);
				if (vvd1[i] != null)
					model.setVvd1(vvd1[i]);
				if (podTmlDiffFlg[i] != null)
					model.setPodTmlDiffFlg(podTmlDiffFlg[i]);
				if (vvd4[i] != null)
					model.setVvd4(vvd4[i]);
				if (newPod[i] != null)
					model.setNewPod(newPod[i]);
				if (n4PodClptSeq[i] != null)
					model.setN4PodClptSeq(n4PodClptSeq[i]);
				if (obUnconfirmFlg[i] != null)
					model.setObUnconfirmFlg(obUnconfirmFlg[i]);
				if (oldPctlNo[i] != null)
					model.setOldPctlNo(oldPctlNo[i]);
				if (mtyRtnYdCd[i] != null)
					model.setMtyRtnYdCd(mtyRtnYdCd[i]);
				if (polTmlDiffFlg[i] != null)
					model.setPolTmlDiffFlg(polTmlDiffFlg[i]);
				if (newPol[i] != null)
					model.setNewPol(newPol[i]);
				if (bkgDeTermCd[i] != null)
					model.setBkgDeTermCd(bkgDeTermCd[i]);
				if (ibUnconfirmFlg[i] != null)
					model.setIbUnconfirmFlg(ibUnconfirmFlg[i]);
				if (newDel[i] != null)
					model.setNewDel(newDel[i]);
				if (ibContent[i] != null)
					model.setIbContent(ibContent[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPrdSearchEurDrRePatternVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PrdSearchEurDrRePatternVO[]
	 */
	public PrdSearchEurDrRePatternVO[] getPrdSearchEurDrRePatternVOs(){
		PrdSearchEurDrRePatternVO[] vos = (PrdSearchEurDrRePatternVO[])models.toArray(new PrdSearchEurDrRePatternVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.orgLocCd = this.orgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocCd = this.destLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3PolClptSeq = this.n3PolClptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obContent = this.obContent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2PolClptSeq = this.n2PolClptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3PodClptSeq = this.n3PodClptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupYdCd = this.mtyPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermCd = this.bkgRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polT = this.polT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibTrspMod = this.ibTrspMod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct = this.cct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copPattOrdNo = this.copPattOrdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podT = this.podT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2PodClptSeq = this.n2PodClptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1PolClptSeq = this.n1PolClptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obTrspMod = this.obTrspMod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullPkupYdCd = this.fullPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocnContent = this.ocnContent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1PodClptSeq = this.n1PodClptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4PolClptSeq = this.n4PolClptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurObFlg = this.eurObFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPor = this.newPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocnSeq = this.ocnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPctlNo = this.newPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurIbFlg = this.eurIbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2 = this.vvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullRtnYdCd = this.fullRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd3 = this.vvd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1 = this.vvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podTmlDiffFlg = this.podTmlDiffFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd4 = this.vvd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPod = this.newPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4PodClptSeq = this.n4PodClptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obUnconfirmFlg = this.obUnconfirmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPctlNo = this.oldPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRtnYdCd = this.mtyRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polTmlDiffFlg = this.polTmlDiffFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPol = this.newPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDeTermCd = this.bkgDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibUnconfirmFlg = this.ibUnconfirmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newDel = this.newDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibContent = this.ibContent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
