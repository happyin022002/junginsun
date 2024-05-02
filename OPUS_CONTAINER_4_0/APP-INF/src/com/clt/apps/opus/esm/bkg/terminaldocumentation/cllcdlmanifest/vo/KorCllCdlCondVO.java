/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCllCdlCondVO.java
*@FileTitle : KorCllCdlCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.20
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorCllCdlCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorCllCdlCondVO> models = new ArrayList<KorCllCdlCondVO>();

	/* Column Info */
	private String inRcFlg = null;
	/* Column Info */
	private String inStwgCd = null;
	/* Column Info */
	private String inPorCd = null;
	/* Column Info */
	private String inListType = null;
	/* Column Info */
	private String inBkgStsCd = null;
	/* Column Info */
	private String inPodYdCd = null;
	/* Column Info */
	private String inDelCd = null;
	/* Column Info */
	private String inCntrNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inAwkCgoFlg = null;
	/* Column Info */
	private String inSccCd = null;
	/* Column Info */
	private String inOfcCd = null;
	/* Column Info */
	private String inPrctFlg = null;
	/* Column Info */
	private String inRdCgoFlg = null;
	/* Column Info */
	private String inSpclCgoType = null;
	/* Column Info */
	private String inPodCd = null;
	/* Column Info */
	private String inBbCgoFlg = null;
	/* Column Info */
	private String inPodTs = null;
	/* Column Info */
	private String inOfcCdType = null;
	/* Column Info */
	private String inOrgTrnsSvdModCd = null;
	/* Column Info */
	private String inRcvTermCd = null;
	/* Column Info */
	private String inOrderByType = null;
	/* Column Info */
	private String inPolYdCd = null;
	/* Column Info */
	private String inCntrCfmFlg = null;
	/* Column Info */
	private String inDeTermCd = null;
	/* Column Info */
	private String inDcgoFlg = null;
	/* Column Info */
	private String inPolTs = null;
	/* Column Info */
	private String inCntrTpszCd = null;
	/* Column Info */
	private String inPolCd = null;
	/* Column Info */
	private String inVvdCd = null;
	/* Column Info */
	private String inBkgCgoTpCd = null;
	/* Column Info */
	private String inHotDeFlg = null;
	/* Column Info */
	private String backgroundJobKey = null;
	/* Column Info */
	private String inBkgNo = null;
	/* Column Info */
	private String inSocFlg = null;
	/* Column Info */
	private String inDestTrnsSvcModCd = null;
	/* Column Info */
	private String inCntrMatch = null;
	/* Column Info */
	private String inIncludingType = null;
	/* Column Info */
	private String inHngrFlg = null;
	/* Column Info */
	private String inPkupNodCd = null;
	/* Column Info */
	private String bkgNoList = null;
	/* Column Info */
	private String popMode = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorCllCdlCondVO() {}

	public KorCllCdlCondVO(String ibflag, String pagerows, String inRcFlg, String inStwgCd, String inBkgStsCd, String inListType, String inPorCd, String inPodYdCd, String inDelCd, String inCntrNo, String inAwkCgoFlg, String inSccCd, String inOfcCd, String inPrctFlg, String inRdCgoFlg, String inSpclCgoType, String inPodCd, String inBbCgoFlg, String inPodTs, String inOfcCdType, String inOrgTrnsSvdModCd, String inRcvTermCd, String inOrderByType, String inPolYdCd, String inCntrCfmFlg, String inDeTermCd, String inPolTs, String inDcgoFlg, String inPolCd, String inCntrTpszCd, String inVvdCd, String inHotDeFlg, String inBkgCgoTpCd, String inBkgNo, String inSocFlg, String inCntrMatch, String inDestTrnsSvcModCd, String backgroundJobKey, String inIncludingType, String inHngrFlg, String inPkupNodCd, String bkgNoList, String popMode) {
		this.inRcFlg = inRcFlg;
		this.inStwgCd = inStwgCd;
		this.inPorCd = inPorCd;
		this.inListType = inListType;
		this.inBkgStsCd = inBkgStsCd;
		this.inPodYdCd = inPodYdCd;
		this.inDelCd = inDelCd;
		this.inCntrNo = inCntrNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.inAwkCgoFlg = inAwkCgoFlg;
		this.inSccCd = inSccCd;
		this.inOfcCd = inOfcCd;
		this.inPrctFlg = inPrctFlg;
		this.inRdCgoFlg = inRdCgoFlg;
		this.inSpclCgoType = inSpclCgoType;
		this.inPodCd = inPodCd;
		this.inBbCgoFlg = inBbCgoFlg;
		this.inPodTs = inPodTs;
		this.inOfcCdType = inOfcCdType;
		this.inOrgTrnsSvdModCd = inOrgTrnsSvdModCd;
		this.inRcvTermCd = inRcvTermCd;
		this.inOrderByType = inOrderByType;
		this.inPolYdCd = inPolYdCd;
		this.inCntrCfmFlg = inCntrCfmFlg;
		this.inDeTermCd = inDeTermCd;
		this.inDcgoFlg = inDcgoFlg;
		this.inPolTs = inPolTs;
		this.inCntrTpszCd = inCntrTpszCd;
		this.inPolCd = inPolCd;
		this.inVvdCd = inVvdCd;
		this.inBkgCgoTpCd = inBkgCgoTpCd;
		this.inHotDeFlg = inHotDeFlg;
		this.backgroundJobKey = backgroundJobKey;
		this.inBkgNo = inBkgNo;
		this.inSocFlg = inSocFlg;
		this.inDestTrnsSvcModCd = inDestTrnsSvcModCd;
		this.inCntrMatch = inCntrMatch;
		this.inIncludingType = inIncludingType;
		this.inHngrFlg = inHngrFlg;
		this.inPkupNodCd = inPkupNodCd;
		this.bkgNoList = bkgNoList;
		this.popMode = popMode;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_rc_flg", getInRcFlg());
		this.hashColumns.put("in_stwg_cd", getInStwgCd());
		this.hashColumns.put("in_por_cd", getInPorCd());
		this.hashColumns.put("in_list_type", getInListType());
		this.hashColumns.put("in_bkg_sts_cd", getInBkgStsCd());
		this.hashColumns.put("in_pod_yd_cd", getInPodYdCd());
		this.hashColumns.put("in_del_cd", getInDelCd());
		this.hashColumns.put("in_cntr_no", getInCntrNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_awk_cgo_flg", getInAwkCgoFlg());
		this.hashColumns.put("in_scc_cd", getInSccCd());
		this.hashColumns.put("in_ofc_cd", getInOfcCd());
		this.hashColumns.put("in_prct_flg", getInPrctFlg());
		this.hashColumns.put("in_rd_cgo_flg", getInRdCgoFlg());
		this.hashColumns.put("in_spcl_cgo_type", getInSpclCgoType());
		this.hashColumns.put("in_pod_cd", getInPodCd());
		this.hashColumns.put("in_bb_cgo_flg", getInBbCgoFlg());
		this.hashColumns.put("in_pod_ts", getInPodTs());
		this.hashColumns.put("in_ofc_cd_type", getInOfcCdType());
		this.hashColumns.put("in_org_trns_svd_mod_cd", getInOrgTrnsSvdModCd());
		this.hashColumns.put("in_rcv_term_cd", getInRcvTermCd());
		this.hashColumns.put("in_order_by_type", getInOrderByType());
		this.hashColumns.put("in_pol_yd_cd", getInPolYdCd());
		this.hashColumns.put("in_cntr_cfm_flg", getInCntrCfmFlg());
		this.hashColumns.put("in_de_term_cd", getInDeTermCd());
		this.hashColumns.put("in_dcgo_flg", getInDcgoFlg());
		this.hashColumns.put("in_pol_ts", getInPolTs());
		this.hashColumns.put("in_cntr_tpsz_cd", getInCntrTpszCd());
		this.hashColumns.put("in_pol_cd", getInPolCd());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		this.hashColumns.put("in_bkg_cgo_tp_cd", getInBkgCgoTpCd());
		this.hashColumns.put("in_hot_de_flg", getInHotDeFlg());
		this.hashColumns.put("background_job_key", getBackgroundJobKey());
		this.hashColumns.put("in_bkg_no", getInBkgNo());
		this.hashColumns.put("in_soc_flg", getInSocFlg());
		this.hashColumns.put("in_dest_trns_svc_mod_cd", getInDestTrnsSvcModCd());
		this.hashColumns.put("in_cntr_match", getInCntrMatch());
		this.hashColumns.put("in_including_type", getInIncludingType());
		this.hashColumns.put("in_hngr_flg", getInHngrFlg());
		this.hashColumns.put("in_pkup_nod_cd", getInPkupNodCd());
		this.hashColumns.put("bkg_no_list", getBkgNoList());
		this.hashColumns.put("pop_mode", getPopMode());

		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_rc_flg", "inRcFlg");
		this.hashFields.put("in_stwg_cd", "inStwgCd");
		this.hashFields.put("in_por_cd", "inPorCd");
		this.hashFields.put("in_list_type", "inListType");
		this.hashFields.put("in_bkg_sts_cd", "inBkgStsCd");
		this.hashFields.put("in_pod_yd_cd", "inPodYdCd");
		this.hashFields.put("in_del_cd", "inDelCd");
		this.hashFields.put("in_cntr_no", "inCntrNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_awk_cgo_flg", "inAwkCgoFlg");
		this.hashFields.put("in_scc_cd", "inSccCd");
		this.hashFields.put("in_ofc_cd", "inOfcCd");
		this.hashFields.put("in_prct_flg", "inPrctFlg");
		this.hashFields.put("in_rd_cgo_flg", "inRdCgoFlg");
		this.hashFields.put("in_spcl_cgo_type", "inSpclCgoType");
		this.hashFields.put("in_pod_cd", "inPodCd");
		this.hashFields.put("in_bb_cgo_flg", "inBbCgoFlg");
		this.hashFields.put("in_pod_ts", "inPodTs");
		this.hashFields.put("in_ofc_cd_type", "inOfcCdType");
		this.hashFields.put("in_org_trns_svd_mod_cd", "inOrgTrnsSvdModCd");
		this.hashFields.put("in_rcv_term_cd", "inRcvTermCd");
		this.hashFields.put("in_order_by_type", "inOrderByType");
		this.hashFields.put("in_pol_yd_cd", "inPolYdCd");
		this.hashFields.put("in_cntr_cfm_flg", "inCntrCfmFlg");
		this.hashFields.put("in_de_term_cd", "inDeTermCd");
		this.hashFields.put("in_dcgo_flg", "inDcgoFlg");
		this.hashFields.put("in_pol_ts", "inPolTs");
		this.hashFields.put("in_cntr_tpsz_cd", "inCntrTpszCd");
		this.hashFields.put("in_pol_cd", "inPolCd");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("in_bkg_cgo_tp_cd", "inBkgCgoTpCd");
		this.hashFields.put("in_hot_de_flg", "inHotDeFlg");
		this.hashFields.put("background_job_key", "backgroundJobKey");
		this.hashFields.put("in_bkg_no", "inBkgNo");
		this.hashFields.put("in_soc_flg", "inSocFlg");
		this.hashFields.put("in_dest_trns_svc_mod_cd", "inDestTrnsSvcModCd");
		this.hashFields.put("in_cntr_match", "inCntrMatch");
		this.hashFields.put("in_including_type", "inIncludingType");
		this.hashFields.put("in_hngr_flg", "inHngrFlg");
		this.hashFields.put("in_pkup_nod_cd", "inPkupNodCd");
		this.hashFields.put("bkg_no_list", "bkgNoList");
		this.hashFields.put("pop_mode", "popMode");

		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return inRcFlg
	 */
	public String getInRcFlg() {
		return this.inRcFlg;
	}

	/**
	 * Column Info
	 * @return inStwgCd
	 */
	public String getInStwgCd() {
		return this.inStwgCd;
	}

	/**
	 * Column Info
	 * @return inPorCd
	 */
	public String getInPorCd() {
		return this.inPorCd;
	}

	/**
	 * Column Info
	 * @return inListType
	 */
	public String getInListType() {
		return this.inListType;
	}

	/**
	 * Column Info
	 * @return inBkgStsCd
	 */
	public String getInBkgStsCd() {
		return this.inBkgStsCd;
	}

	/**
	 * Column Info
	 * @return inPodYdCd
	 */
	public String getInPodYdCd() {
		return this.inPodYdCd;
	}

	/**
	 * Column Info
	 * @return inDelCd
	 */
	public String getInDelCd() {
		return this.inDelCd;
	}

	/**
	 * Column Info
	 * @return inCntrNo
	 */
	public String getInCntrNo() {
		return this.inCntrNo;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return inAwkCgoFlg
	 */
	public String getInAwkCgoFlg() {
		return this.inAwkCgoFlg;
	}

	/**
	 * Column Info
	 * @return inSccCd
	 */
	public String getInSccCd() {
		return this.inSccCd;
	}

	/**
	 * Column Info
	 * @return inOfcCd
	 */
	public String getInOfcCd() {
		return this.inOfcCd;
	}

	/**
	 * Column Info
	 * @return inPrctFlg
	 */
	public String getInPrctFlg() {
		return this.inPrctFlg;
	}

	/**
	 * Column Info
	 * @return inRdCgoFlg
	 */
	public String getInRdCgoFlg() {
		return this.inRdCgoFlg;
	}

	/**
	 * Column Info
	 * @return inSpclCgoType
	 */
	public String getInSpclCgoType() {
		return this.inSpclCgoType;
	}

	/**
	 * Column Info
	 * @return inPodCd
	 */
	public String getInPodCd() {
		return this.inPodCd;
	}

	/**
	 * Column Info
	 * @return inBbCgoFlg
	 */
	public String getInBbCgoFlg() {
		return this.inBbCgoFlg;
	}

	/**
	 * Column Info
	 * @return inPodTs
	 */
	public String getInPodTs() {
		return this.inPodTs;
	}

	/**
	 * Column Info
	 * @return inOfcCdType
	 */
	public String getInOfcCdType() {
		return this.inOfcCdType;
	}

	/**
	 * Column Info
	 * @return inOrgTrnsSvdModCd
	 */
	public String getInOrgTrnsSvdModCd() {
		return this.inOrgTrnsSvdModCd;
	}

	/**
	 * Column Info
	 * @return inRcvTermCd
	 */
	public String getInRcvTermCd() {
		return this.inRcvTermCd;
	}

	/**
	 * Column Info
	 * @return inOrderByType
	 */
	public String getInOrderByType() {
		return this.inOrderByType;
	}

	/**
	 * Column Info
	 * @return inPolYdCd
	 */
	public String getInPolYdCd() {
		return this.inPolYdCd;
	}

	/**
	 * Column Info
	 * @return inCntrCfmFlg
	 */
	public String getInCntrCfmFlg() {
		return this.inCntrCfmFlg;
	}

	/**
	 * Column Info
	 * @return inDeTermCd
	 */
	public String getInDeTermCd() {
		return this.inDeTermCd;
	}

	/**
	 * Column Info
	 * @return inDcgoFlg
	 */
	public String getInDcgoFlg() {
		return this.inDcgoFlg;
	}

	/**
	 * Column Info
	 * @return inPolTs
	 */
	public String getInPolTs() {
		return this.inPolTs;
	}

	/**
	 * Column Info
	 * @return inCntrTpszCd
	 */
	public String getInCntrTpszCd() {
		return this.inCntrTpszCd;
	}

	/**
	 * Column Info
	 * @return inPolCd
	 */
	public String getInPolCd() {
		return this.inPolCd;
	}

	/**
	 * Column Info
	 * @return inVvdCd
	 */
	public String getInVvdCd() {
		return this.inVvdCd;
	}

	/**
	 * Column Info
	 * @return inBkgCgoTpCd
	 */
	public String getInBkgCgoTpCd() {
		return this.inBkgCgoTpCd;
	}

	/**
	 * Column Info
	 * @return inHotDeFlg
	 */
	public String getInHotDeFlg() {
		return this.inHotDeFlg;
	}

	/**
	 * Column Info
	 * @return backgroundJobKey
	 */
	public String getBackgroundJobKey() {
		return this.backgroundJobKey;
	}

	/**
	 * Column Info
	 * @return inBkgNo
	 */
	public String getInBkgNo() {
		return this.inBkgNo;
	}

	/**
	 * Column Info
	 * @return inSocFlg
	 */
	public String getInSocFlg() {
		return this.inSocFlg;
	}

	/**
	 * Column Info
	 * @return inDestTrnsSvcModCd
	 */
	public String getInDestTrnsSvcModCd() {
		return this.inDestTrnsSvcModCd;
	}

	/**
	 * Column Info
	 * @return inCntrMatch
	 */
	public String getInCntrMatch() {
		return this.inCntrMatch;
	}

	/**
	 * Column Info
	 * @return inIncludingType
	 */
	public String getInIncludingType() {
		return this.inIncludingType;
	}

	/**
	 * Column Info
	 * @return bkgNoList
	 */
	public String getBkgNoList() {
		return this.bkgNoList;
	}
	
	/**
	 * Column Info
	 * @return popMode
	 */
	public String getPopMode() {
		return this.popMode;
	}

	/**
	 * Column Info
	 * @param inRcFlg
	 */
	public void setInRcFlg(String inRcFlg) {
		this.inRcFlg = inRcFlg;
	}

	/**
	 * Column Info
	 * @param inStwgCd
	 */
	public void setInStwgCd(String inStwgCd) {
		this.inStwgCd = inStwgCd;
	}

	/**
	 * Column Info
	 * @param inPorCd
	 */
	public void setInPorCd(String inPorCd) {
		this.inPorCd = inPorCd;
	}

	/**
	 * Column Info
	 * @param inListType
	 */
	public void setInListType(String inListType) {
		this.inListType = inListType;
	}

	/**
	 * Column Info
	 * @param inBkgStsCd
	 */
	public void setInBkgStsCd(String inBkgStsCd) {
		this.inBkgStsCd = inBkgStsCd;
	}

	/**
	 * Column Info
	 * @param inPodYdCd
	 */
	public void setInPodYdCd(String inPodYdCd) {
		this.inPodYdCd = inPodYdCd;
	}

	/**
	 * Column Info
	 * @param inDelCd
	 */
	public void setInDelCd(String inDelCd) {
		this.inDelCd = inDelCd;
	}

	/**
	 * Column Info
	 * @param inCntrNo
	 */
	public void setInCntrNo(String inCntrNo) {
		this.inCntrNo = inCntrNo;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param inAwkCgoFlg
	 */
	public void setInAwkCgoFlg(String inAwkCgoFlg) {
		this.inAwkCgoFlg = inAwkCgoFlg;
	}

	/**
	 * Column Info
	 * @param inSccCd
	 */
	public void setInSccCd(String inSccCd) {
		this.inSccCd = inSccCd;
	}

	/**
	 * Column Info
	 * @param inOfcCd
	 */
	public void setInOfcCd(String inOfcCd) {
		this.inOfcCd = inOfcCd;
	}

	/**
	 * Column Info
	 * @param inPrctFlg
	 */
	public void setInPrctFlg(String inPrctFlg) {
		this.inPrctFlg = inPrctFlg;
	}

	/**
	 * Column Info
	 * @param inRdCgoFlg
	 */
	public void setInRdCgoFlg(String inRdCgoFlg) {
		this.inRdCgoFlg = inRdCgoFlg;
	}

	/**
	 * Column Info
	 * @param inSpclCgoType
	 */
	public void setInSpclCgoType(String inSpclCgoType) {
		this.inSpclCgoType = inSpclCgoType;
	}

	/**
	 * Column Info
	 * @param inPodCd
	 */
	public void setInPodCd(String inPodCd) {
		this.inPodCd = inPodCd;
	}

	/**
	 * Column Info
	 * @param inBbCgoFlg
	 */
	public void setInBbCgoFlg(String inBbCgoFlg) {
		this.inBbCgoFlg = inBbCgoFlg;
	}

	/**
	 * Column Info
	 * @param inPodTs
	 */
	public void setInPodTs(String inPodTs) {
		this.inPodTs = inPodTs;
	}

	/**
	 * Column Info
	 * @param inOfcCdType
	 */
	public void setInOfcCdType(String inOfcCdType) {
		this.inOfcCdType = inOfcCdType;
	}

	/**
	 * Column Info
	 * @param inOrgTrnsSvdModCd
	 */
	public void setInOrgTrnsSvdModCd(String inOrgTrnsSvdModCd) {
		this.inOrgTrnsSvdModCd = inOrgTrnsSvdModCd;
	}

	/**
	 * Column Info
	 * @param inRcvTermCd
	 */
	public void setInRcvTermCd(String inRcvTermCd) {
		this.inRcvTermCd = inRcvTermCd;
	}

	/**
	 * Column Info
	 * @param inOrderByType
	 */
	public void setInOrderByType(String inOrderByType) {
		this.inOrderByType = inOrderByType;
	}

	/**
	 * Column Info
	 * @param inPolYdCd
	 */
	public void setInPolYdCd(String inPolYdCd) {
		this.inPolYdCd = inPolYdCd;
	}

	/**
	 * Column Info
	 * @param inCntrCfmFlg
	 */
	public void setInCntrCfmFlg(String inCntrCfmFlg) {
		this.inCntrCfmFlg = inCntrCfmFlg;
	}

	/**
	 * Column Info
	 * @param inDeTermCd
	 */
	public void setInDeTermCd(String inDeTermCd) {
		this.inDeTermCd = inDeTermCd;
	}

	/**
	 * Column Info
	 * @param inDcgoFlg
	 */
	public void setInDcgoFlg(String inDcgoFlg) {
		this.inDcgoFlg = inDcgoFlg;
	}

	/**
	 * Column Info
	 * @param inPolTs
	 */
	public void setInPolTs(String inPolTs) {
		this.inPolTs = inPolTs;
	}

	/**
	 * Column Info
	 * @param inCntrTpszCd
	 */
	public void setInCntrTpszCd(String inCntrTpszCd) {
		this.inCntrTpszCd = inCntrTpszCd;
	}

	/**
	 * Column Info
	 * @param inPolCd
	 */
	public void setInPolCd(String inPolCd) {
		this.inPolCd = inPolCd;
	}

	/**
	 * Column Info
	 * @param inVvdCd
	 */
	public void setInVvdCd(String inVvdCd) {
		this.inVvdCd = inVvdCd;
	}

	/**
	 * Column Info
	 * @param inBkgCgoTpCd
	 */
	public void setInBkgCgoTpCd(String inBkgCgoTpCd) {
		this.inBkgCgoTpCd = inBkgCgoTpCd;
	}

	/**
	 * Column Info
	 * @param inHotDeFlg
	 */
	public void setInHotDeFlg(String inHotDeFlg) {
		this.inHotDeFlg = inHotDeFlg;
	}

	/**
	 * Column Info
	 * @param backgroundJobKey
	 */
	public void setBackgroundJobKey(String backgroundJobKey) {
		this.backgroundJobKey = backgroundJobKey;
	}

	/**
	 * Column Info
	 * @param inBkgNo
	 */
	public void setInBkgNo(String inBkgNo) {
		this.inBkgNo = inBkgNo;
	}

	/**
	 * Column Info
	 * @param inSocFlg
	 */
	public void setInSocFlg(String inSocFlg) {
		this.inSocFlg = inSocFlg;
	}

	/**
	 * Column Info
	 * @param inDestTrnsSvcModCd
	 */
	public void setInDestTrnsSvcModCd(String inDestTrnsSvcModCd) {
		this.inDestTrnsSvcModCd = inDestTrnsSvcModCd;
	}

	/**
	 * Column Info
	 * @param inCntrMatch
	 */
	public void setInCntrMatch(String inCntrMatch) {
		this.inCntrMatch = inCntrMatch;
	}

	/**
	 * Column Info
	 * @param inIncludingType
	 */
	public void setInIncludingType(String inIncludingType) {
		this.inIncludingType = inIncludingType;
	}

	public String getInHngrFlg() {
		return inHngrFlg;
	}

	public void setInHngrFlg(String inHngrFlg) {
		this.inHngrFlg = inHngrFlg;
	}
	
	public String getInPkupNodCd() {
		return inPkupNodCd;
	}
	
	public void setInPkupNodCd(String inPkupNodCd) {
		this.inPkupNodCd = inPkupNodCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNoList
	 */
	public void setBkgNoList(String bkgNoList) {
		this.bkgNoList = bkgNoList;
	}
	
	/**
	 * Column Info
	 * @param popMode
	 */
	public void setPopMode(String popMode) {
		this.popMode = popMode;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInRcFlg(JSPUtil.getParameter(request, "in_rc_flg", ""));
		setInStwgCd(JSPUtil.getParameter(request, "in_stwg_cd", ""));
		setInPorCd(JSPUtil.getParameter(request, "in_por_cd", ""));
		setInListType(JSPUtil.getParameter(request, "in_list_type", ""));
		setInBkgStsCd(JSPUtil.getParameter(request, "in_bkg_sts_cd", ""));
		setInPodYdCd(JSPUtil.getParameter(request, "in_pod_yd_cd", ""));
		setInDelCd(JSPUtil.getParameter(request, "in_del_cd", ""));
		setInCntrNo(JSPUtil.getParameter(request, "in_cntr_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInAwkCgoFlg(JSPUtil.getParameter(request, "in_awk_cgo_flg", ""));
		setInSccCd(JSPUtil.getParameter(request, "in_scc_cd", ""));
		setInOfcCd(JSPUtil.getParameter(request, "in_ofc_cd", ""));
		setInPrctFlg(JSPUtil.getParameter(request, "in_prct_flg", ""));
		setInRdCgoFlg(JSPUtil.getParameter(request, "in_rd_cgo_flg", ""));
		setInSpclCgoType(JSPUtil.getParameter(request, "in_spcl_cgo_type", ""));
		setInPodCd(JSPUtil.getParameter(request, "in_pod_cd", ""));
		setInBbCgoFlg(JSPUtil.getParameter(request, "in_bb_cgo_flg", ""));
		setInPodTs(JSPUtil.getParameter(request, "in_pod_ts", ""));
		setInOfcCdType(JSPUtil.getParameter(request, "in_ofc_cd_type", ""));
		setInOrgTrnsSvdModCd(JSPUtil.getParameter(request, "in_org_trns_svd_mod_cd", ""));
		setInRcvTermCd(JSPUtil.getParameter(request, "in_rcv_term_cd", ""));
		setInOrderByType(JSPUtil.getParameter(request, "in_order_by_type", ""));
		setInPolYdCd(JSPUtil.getParameter(request, "in_pol_yd_cd", ""));
		setInCntrCfmFlg(JSPUtil.getParameter(request, "in_cntr_cfm_flg", ""));
		setInDeTermCd(JSPUtil.getParameter(request, "in_de_term_cd", ""));
		setInDcgoFlg(JSPUtil.getParameter(request, "in_dcgo_flg", ""));
		setInPolTs(JSPUtil.getParameter(request, "in_pol_ts", ""));
		setInCntrTpszCd(JSPUtil.getParameter(request, "in_cntr_tpsz_cd", ""));
		setInPolCd(JSPUtil.getParameter(request, "in_pol_cd", ""));
		setInVvdCd(JSPUtil.getParameter(request, "in_vvd_cd", ""));
		setInBkgCgoTpCd(JSPUtil.getParameter(request, "in_bkg_cgo_tp_cd", ""));
		setInHotDeFlg(JSPUtil.getParameter(request, "in_hot_de_flg", ""));
		setBackgroundJobKey(JSPUtil.getParameter(request, "background_job_key", ""));
		setInBkgNo(JSPUtil.getParameter(request, "in_bkg_no", ""));
		setInSocFlg(JSPUtil.getParameter(request, "in_soc_flg", ""));
		setInDestTrnsSvcModCd(JSPUtil.getParameter(request, "in_dest_trns_svc_mod_cd", ""));
		setInCntrMatch(JSPUtil.getParameter(request, "in_cntr_match", ""));
		setInIncludingType(JSPUtil.getParameter(request, "in_including_type", ""));
		setInHngrFlg(JSPUtil.getParameter(request, "in_hngr_flg", ""));
		setInPkupNodCd(JSPUtil.getParameter(request, "in_pkup_nod_cd", ""));
		setBkgNoList(JSPUtil.getParameter(request, "bkg_no_list", ""));
		setPopMode(JSPUtil.getParameter(request, "pop_mode", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCllCdlCondVO[]
	 */
	public KorCllCdlCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorCllCdlCondVO[]
	 */
	public KorCllCdlCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCllCdlCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] inRcFlg = (JSPUtil.getParameter(request, prefix	+ "in_rc_flg", length));
			String[] inStwgCd = (JSPUtil.getParameter(request, prefix	+ "in_stwg_cd", length));
			String[] inPorCd = (JSPUtil.getParameter(request, prefix	+ "in_por_cd", length));
			String[] inListType = (JSPUtil.getParameter(request, prefix	+ "in_list_type", length));
			String[] inBkgStsCd = (JSPUtil.getParameter(request, prefix	+ "in_bkg_sts_cd", length));
			String[] inPodYdCd = (JSPUtil.getParameter(request, prefix	+ "in_pod_yd_cd", length));
			String[] inDelCd = (JSPUtil.getParameter(request, prefix	+ "in_del_cd", length));
			String[] inCntrNo = (JSPUtil.getParameter(request, prefix	+ "in_cntr_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inAwkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "in_awk_cgo_flg", length));
			String[] inSccCd = (JSPUtil.getParameter(request, prefix	+ "in_scc_cd", length));
			String[] inOfcCd = (JSPUtil.getParameter(request, prefix	+ "in_ofc_cd", length));
			String[] inPrctFlg = (JSPUtil.getParameter(request, prefix	+ "in_prct_flg", length));
			String[] inRdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "in_rd_cgo_flg", length));
			String[] inSpclCgoType = (JSPUtil.getParameter(request, prefix	+ "in_spcl_cgo_type", length));
			String[] inPodCd = (JSPUtil.getParameter(request, prefix	+ "in_pod_cd", length));
			String[] inBbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "in_bb_cgo_flg", length));
			String[] inPodTs = (JSPUtil.getParameter(request, prefix	+ "in_pod_ts", length));
			String[] inOfcCdType = (JSPUtil.getParameter(request, prefix	+ "in_ofc_cd_type", length));
			String[] inOrgTrnsSvdModCd = (JSPUtil.getParameter(request, prefix	+ "in_org_trns_svd_mod_cd", length));
			String[] inRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "in_rcv_term_cd", length));
			String[] inOrderByType = (JSPUtil.getParameter(request, prefix	+ "in_order_by_type", length));
			String[] inPolYdCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_yd_cd", length));
			String[] inCntrCfmFlg = (JSPUtil.getParameter(request, prefix	+ "in_cntr_cfm_flg", length));
			String[] inDeTermCd = (JSPUtil.getParameter(request, prefix	+ "in_de_term_cd", length));
			String[] inDcgoFlg = (JSPUtil.getParameter(request, prefix	+ "in_dcgo_flg", length));
			String[] inPolTs = (JSPUtil.getParameter(request, prefix	+ "in_pol_ts", length));
			String[] inCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "in_cntr_tpsz_cd", length));
			String[] inPolCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_cd", length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd", length));
			String[] inBkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "in_bkg_cgo_tp_cd", length));
			String[] inHotDeFlg = (JSPUtil.getParameter(request, prefix	+ "in_hot_de_flg", length));
			String[] backgroundJobKey = (JSPUtil.getParameter(request, prefix	+ "background_job_key", length));
			String[] inBkgNo = (JSPUtil.getParameter(request, prefix	+ "in_bkg_no", length));
			String[] inSocFlg = (JSPUtil.getParameter(request, prefix	+ "in_soc_flg", length));
			String[] inDestTrnsSvcModCd = (JSPUtil.getParameter(request, prefix	+ "in_dest_trns_svc_mod_cd", length));
			String[] inCntrMatch = (JSPUtil.getParameter(request, prefix	+ "in_cntr_match", length));
			String[] inIncludingType = (JSPUtil.getParameter(request, prefix	+ "in_including_type", length));
			String[] inHngrFlg = (JSPUtil.getParameter(request, prefix	+ "in_hngr_flg", length));
			String[] inPkupNodCd = (JSPUtil.getParameter(request, prefix	+ "in_pkup_nod_cd", length));
			String[] bkgNoList = (JSPUtil.getParameter(request, prefix	+ "bkg_no_list", length));
			String[] popMode = (JSPUtil.getParameter(request, prefix	+ "pop_mode", length));

			for (int i = 0; i < length; i++) {
				model = new KorCllCdlCondVO();
				if (inRcFlg[i] != null)
					model.setInRcFlg(inRcFlg[i]);
				if (inStwgCd[i] != null)
					model.setInStwgCd(inStwgCd[i]);
				if (inPorCd[i] != null)
					model.setInPorCd(inPorCd[i]);
				if (inListType[i] != null)
					model.setInListType(inListType[i]);
				if (inBkgStsCd[i] != null)
					model.setInBkgStsCd(inBkgStsCd[i]);
				if (inPodYdCd[i] != null)
					model.setInPodYdCd(inPodYdCd[i]);
				if (inDelCd[i] != null)
					model.setInDelCd(inDelCd[i]);
				if (inCntrNo[i] != null)
					model.setInCntrNo(inCntrNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inAwkCgoFlg[i] != null)
					model.setInAwkCgoFlg(inAwkCgoFlg[i]);
				if (inSccCd[i] != null)
					model.setInSccCd(inSccCd[i]);
				if (inOfcCd[i] != null)
					model.setInOfcCd(inOfcCd[i]);
				if (inPrctFlg[i] != null)
					model.setInPrctFlg(inPrctFlg[i]);
				if (inRdCgoFlg[i] != null)
					model.setInRdCgoFlg(inRdCgoFlg[i]);
				if (inSpclCgoType[i] != null)
					model.setInSpclCgoType(inSpclCgoType[i]);
				if (inPodCd[i] != null)
					model.setInPodCd(inPodCd[i]);
				if (inBbCgoFlg[i] != null)
					model.setInBbCgoFlg(inBbCgoFlg[i]);
				if (inPodTs[i] != null)
					model.setInPodTs(inPodTs[i]);
				if (inOfcCdType[i] != null)
					model.setInOfcCdType(inOfcCdType[i]);
				if (inOrgTrnsSvdModCd[i] != null)
					model.setInOrgTrnsSvdModCd(inOrgTrnsSvdModCd[i]);
				if (inRcvTermCd[i] != null)
					model.setInRcvTermCd(inRcvTermCd[i]);
				if (inOrderByType[i] != null)
					model.setInOrderByType(inOrderByType[i]);
				if (inPolYdCd[i] != null)
					model.setInPolYdCd(inPolYdCd[i]);
				if (inCntrCfmFlg[i] != null)
					model.setInCntrCfmFlg(inCntrCfmFlg[i]);
				if (inDeTermCd[i] != null)
					model.setInDeTermCd(inDeTermCd[i]);
				if (inDcgoFlg[i] != null)
					model.setInDcgoFlg(inDcgoFlg[i]);
				if (inPolTs[i] != null)
					model.setInPolTs(inPolTs[i]);
				if (inCntrTpszCd[i] != null)
					model.setInCntrTpszCd(inCntrTpszCd[i]);
				if (inPolCd[i] != null)
					model.setInPolCd(inPolCd[i]);
				if (inVvdCd[i] != null)
					model.setInVvdCd(inVvdCd[i]);
				if (inBkgCgoTpCd[i] != null)
					model.setInBkgCgoTpCd(inBkgCgoTpCd[i]);
				if (inHotDeFlg[i] != null)
					model.setInHotDeFlg(inHotDeFlg[i]);
				if (backgroundJobKey[i] != null)
					model.setBackgroundJobKey(backgroundJobKey[i]);
				if (inBkgNo[i] != null)
					model.setInBkgNo(inBkgNo[i]);
				if (inSocFlg[i] != null)
					model.setInSocFlg(inSocFlg[i]);
				if (inDestTrnsSvcModCd[i] != null)
					model.setInDestTrnsSvcModCd(inDestTrnsSvcModCd[i]);
				if (inCntrMatch[i] != null)
					model.setInCntrMatch(inCntrMatch[i]);
				if (inIncludingType[i] != null)
					model.setInIncludingType(inIncludingType[i]);
				if (inHngrFlg[i] != null)
					model.setInHngrFlg(inHngrFlg[i]);
				if (inPkupNodCd[i] != null)
					model.setInPkupNodCd(inPkupNodCd[i]);
				if (bkgNoList[i] != null)
					model.setBkgNoList(bkgNoList[i]);
				if (popMode[i] != null)
					model.setPopMode(popMode[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorCllCdlCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorCllCdlCondVO[]
	 */
	public KorCllCdlCondVO[] getKorCllCdlCondVOs(){
		KorCllCdlCondVO[] vos = (KorCllCdlCondVO[])models.toArray(new KorCllCdlCondVO[models.size()]);
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
		this.inRcFlg = this.inRcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inStwgCd = this.inStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPorCd = this.inPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inListType = this.inListType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBkgStsCd = this.inBkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodYdCd = this.inPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDelCd = this.inDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCntrNo = this.inCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inAwkCgoFlg = this.inAwkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSccCd = this.inSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inOfcCd = this.inOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPrctFlg = this.inPrctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inRdCgoFlg = this.inRdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSpclCgoType = this.inSpclCgoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodCd = this.inPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBbCgoFlg = this.inBbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodTs = this.inPodTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inOfcCdType = this.inOfcCdType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inOrgTrnsSvdModCd = this.inOrgTrnsSvdModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inRcvTermCd = this.inRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inOrderByType = this.inOrderByType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolYdCd = this.inPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCntrCfmFlg = this.inCntrCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDeTermCd = this.inDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDcgoFlg = this.inDcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolTs = this.inPolTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCntrTpszCd = this.inCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolCd = this.inPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBkgCgoTpCd = this.inBkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inHotDeFlg = this.inHotDeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.backgroundJobKey = this.backgroundJobKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBkgNo = this.inBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSocFlg = this.inSocFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDestTrnsSvcModCd = this.inDestTrnsSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCntrMatch = this.inCntrMatch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inIncludingType = this.inIncludingType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inHngrFlg = this.inHngrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPkupNodCd = this.inPkupNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoList = this.bkgNoList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.popMode = this.popMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
