/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24ManifestInfoVO.java
*@FileTitle : Kor24ManifestInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.05.29 손윤석
* 1.0 Creation
* -------------------------------------------------------
* history
* 2011.03.29 김영철 [CHM-201109637-01] KOR MANIFEST GENERATE 기능 보완  ( 조건 추가 )
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 손윤석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Kor24ManifestInfoVO extends ManifestListDetailVO {


	private static final long serialVersionUID = -5589114781466178797L;

	private Collection<Kor24ManifestInfoVO> models = new ArrayList<Kor24ManifestInfoVO>();

	/* Column Info */
	private String ntfyA = null;
	/* Column Info */
	private String elnoB = null;
	/* Column Info */
	private String elnoA = null;
	/* Column Info */
	private String bz = null;
	/* Column Info */
	private String tr = null;
	/* Column Info */
	private String tp = null;
	/* Column Info */
	private String correction = null;
	/* Column Info */
	private String wgtValue = null;
	/* Column Info */
	private String pkgCode = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cneeN = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String preVvd = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String ntfyN = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String wh = null;
	/* Column Info */
	private String pkgValue = null;
	/* Column Info */
	private String msn = null;
	/* Column Info */
	private String shprN = null;
	/* Column Info */
	private String sc = null;
	/* Column Info */
	private String bac = null;
	/* Column Info */
	private String fe = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String cntr = null;
	/* Column Info */
	private String descCode = null;
	/* Column Info */
	private String bkg_no = null;
	private String a_bkg_no = null;
	private String a_bkg_no_split = null;
	/* Column Info */
	private String hidden3 = null;
	/* Column Info */
	private String cm = null;
	/* Column Info */
	private String hidden2 = null;
	/* Column Info */
	private String hidden5 = null;
	/* Column Info */
	private String hidden6 = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String hidden4 = null;
	/* Column Info */
	private String wgtCode = null;
	/* Column Info */
	private String cneeA = null;
	/* Column Info */
	private String shprA = null;
	/* Column Info */
	private String hidden1 = null;
	/* Column Info */
	private String custName = null;
	/* Column Info */
	private String match = null;

	private String cntr_type = null;
	private String kcd_tp	= null;
	private String frob_check = null;
	private String elno_wgt_check = null;
	private String elno_check = null;

	private String in_bound = null;
	private String in_vvd = null;
	private String in_pol = null;
	private String in_pod = null;
	private String in_pod_tmnl = null;
	private String in_blno = null;
	private String mrn_nbr = null;
	private String kt_port = null;
	private String errchk = null;
	private String cntr_cnt = null;
	/* Column Info */
	private String bkgsts = null;
	/* Column Info */
	private String whouse = null;
	/* Column Info */
	private String whouse_desc = null;
	/* Column Info */
	private String bkg_del = null;
	/* Column Info */
	private String bkg_por = null;
	/* Column Info */
	private String sel = null;
	/* Column Info */
	private String cBlNo = null;
	/* Column Info */
	private String cntrNo = null;
	private String msnBltp = null;
	private String vvdCd = null;
	private String createdType = null;
	private String ffordCd = null;
	private String ibMtyBkgNo = null;
	private String ibMtyBlNo = null;
	private String ibTrnsSeq = null;
	private String ibCstmsDeclTpCd = null;
	private String ibDmstPortCd = null;
	private String ibVslCd = null;
	private String ibSkdVoyNo = null;
	private String	ibSkdDirCd = null;
	private String ibEtaDt = null;
	private String bacNm = null;
	private String dwellDt= null;
	private String ibVvd = null;
	private String downYn = null;
	private String custType = null;
	private String roChk = null;
	private String otherVvd = null;
	private String pckQtyChk = null;
	private String cntrTtlWgtChk = null;
	private String measQtyChk = null;
	private String pckTpCdChk = null;
	private String wgtUtCdChk = null;
	private String measUtCdChk = null;

	private String crsChkRsltFlg = null;
	private String crsChkRmk = null;
	private String mfDlDiffFlg = null;
	private String mfSndFlg = null;
	private String dmstPortCd = null;
	private String	selType = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public Kor24ManifestInfoVO() {
		this.sel = "1";
		this.ibflag = "U";
	}

	public Kor24ManifestInfoVO(String ibflag, String pagerows, String	selType, String dmstPortCd,String mfDlDiffFlg, String mfSndFlg, String crsChkRsltFlg, String crsChkRmk, String blNo, String bkg_no, String msn, String correction, String tp, String fe, String hidden1, String hidden2, String pol, String pod, String pckQty, String pckTpCd, String actWgt, String wgtUtCd, String measQty, String measUtCd, String pkgValue, String pkgCode, String wgtValue, String wgtCode, String match, String preVvd, String shprN, String shprA, String cneeN, String cneeA, String ntfyN, String ntfyA, String cntr, String bac, String wh, String descCode, String tr, String cm, String bz, String elnoA, String elnoB, String sc, String custName, String hidden3, String hidden4, String hidden5, String cBlNo, String cntrNo, String msnBltp, String vvdCd, String createdType, String ffordCd, String bacNm, String dwellDt, String ibVvd, String downYn, String custType, String roChk, String otherVvd, String hidden6, String pckQtyChk, String cntrTtlWgtChk, String measQtyChk, String pckTpCdChk, String wgtUtCdChk, String measUtCdChk) {
		this.ntfyA = ntfyA;
		this.elnoB = elnoB;
		this.elnoA = elnoA;
		this.bz = bz;
		this.tr = tr;
		this.tp = tp;
		this.correction = correction;
		this.wgtValue = wgtValue;
		this.pkgCode = pkgCode;
		this.blNo = blNo;
		this.cneeN = cneeN;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.preVvd = preVvd;
		this.pol = pol;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.ntfyN = ntfyN;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
		this.wh = wh;
		this.pkgValue = pkgValue;
		this.msn = msn;
		this.shprN = shprN;
		this.sc = sc;
		this.bac = bac;
		this.fe = fe;
		this.actWgt = actWgt;
		this.cntr = cntr;
		this.descCode = descCode;
		this.bkg_no = bkg_no;
		this.hidden3 = hidden3;
		this.cm = cm;
		this.hidden2 = hidden2;
		this.hidden5 = hidden5;
		this.pod = pod;
		this.hidden4 = hidden4;
		this.wgtCode = wgtCode;
		this.cneeA = cneeA;
		this.shprA = shprA;
		this.hidden1 = hidden1;
		this.custName = custName;
		this.match = match;
		this.cBlNo = cBlNo;
		this.cntrNo = cntrNo;
		this.msnBltp = msnBltp;
		this.vvdCd = vvdCd;
		this.createdType = createdType;
		this.ffordCd = ffordCd;
		this.bacNm = bacNm;
		this.ibVvd = ibVvd;
		this.dwellDt = dwellDt;
		this.downYn = downYn;
		this.custType = custType;
		this.roChk = roChk;
		this.otherVvd = otherVvd;
		this.hidden6 = hidden6;
		this.pckQtyChk = pckQtyChk;
		this.cntrTtlWgtChk = cntrTtlWgtChk;
		this.measQtyChk = measQtyChk;
		this.pckTpCdChk = pckTpCdChk;
		this.wgtUtCdChk = wgtUtCdChk;
		this.measUtCdChk = measUtCdChk;
		this.crsChkRsltFlg = crsChkRsltFlg;
		this.crsChkRmk = crsChkRmk;
		this.mfDlDiffFlg = mfDlDiffFlg;
		this.mfSndFlg = mfSndFlg;
		this.dmstPortCd = dmstPortCd;
		this.selType = selType;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ntfy_a", getNtfyA());
		this.hashColumns.put("elno_b", getElnoB());
		this.hashColumns.put("elno_a", getElnoA());
		this.hashColumns.put("bz", getBz());
		this.hashColumns.put("tr", getTr());
		this.hashColumns.put("tp", getTp());
		this.hashColumns.put("correction", getCorrection());
		this.hashColumns.put("wgt_value", getWgtValue());
		this.hashColumns.put("pkg_code", getPkgCode());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cnee_n", getCneeN());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pre_vvd", getPreVvd());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("ntfy_n", getNtfyN());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("wh", getWh());
		this.hashColumns.put("pkg_value", getPkgValue());
		this.hashColumns.put("msn", getMsn());
		this.hashColumns.put("shpr_n", getShprN());
		this.hashColumns.put("sc", getSc());
		this.hashColumns.put("bac", getBac());
		this.hashColumns.put("fe", getFe());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("cntr", getCntr());
		this.hashColumns.put("desc_code", getDescCode());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("a_bkg_no", getABkgNo());
		this.hashColumns.put("a_bkg_no_split", getABkgNoSplit());
		this.hashColumns.put("hidden3", getHidden3());
		this.hashColumns.put("cm", getCm());
		this.hashColumns.put("hidden2", getHidden2());
		this.hashColumns.put("hidden5", getHidden5());
		this.hashColumns.put("hidden6", getHidden6());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("hidden4", getHidden4());
		this.hashColumns.put("wgt_code", getWgtCode());
		this.hashColumns.put("cnee_a", getCneeA());
		this.hashColumns.put("shpr_a", getShprA());
		this.hashColumns.put("hidden1", getHidden1());
		this.hashColumns.put("cust_name", getCustName());
		this.hashColumns.put("match", getMatch());
		this.hashColumns.put("cntr_type", getCntrType());
		this.hashColumns.put("kcd_tp", getKcdTp());
		this.hashColumns.put("frob_check", getFrobCheck());
		this.hashColumns.put("elno_wgt_check", getElnoWgtCheck());
		this.hashColumns.put("elno_check", getElNoCheck());
		this.hashColumns.put("in_bound", getInBound());
		this.hashColumns.put("in_vvd", getInVvd());
		this.hashColumns.put("in_pol", getInPol());
		this.hashColumns.put("in_pod", getInPod());
		this.hashColumns.put("in_pod_tmnl", getInPodTmnl());
		this.hashColumns.put("in_blno", getInBlno());
		this.hashColumns.put("mrn_nbr", getMrnNbr());
		this.hashColumns.put("kt_port", getKtPort());
		this.hashColumns.put("errchk", getErrChk());
		this.hashColumns.put("cntr_cnt", getCntrCnt());
		this.hashColumns.put("sel", getSel());
		this.hashColumns.put("bkgsts", getBkgsts());
		this.hashColumns.put("whouse", getWhouse());
		this.hashColumns.put("whouse_desc", getWhouseDesc());
		this.hashColumns.put("bkg_del", getBkgDel());
		this.hashColumns.put("bkg_por", getBkgPor());
		this.hashColumns.put("c_bl_no", getCBlNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("msn_bltp", getMsnBltp());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("created_type", getCreatedType());
		this.hashColumns.put("fford_cd", getFfordCd());

		this.hashColumns.put("ib_mty_bkg_no", getIbMtyBkgNo());
		this.hashColumns.put("ib_mty_bl_no", getIbMtyBlNo());
		this.hashColumns.put("ib_trns_seq", getIbTrnsSeq());
		this.hashColumns.put("ib_cstms_decl_tp_cd", getIbCstmsDeclTpCd());
		this.hashColumns.put("ib_dmst_port_cd", getIbDmstPortCd());
		this.hashColumns.put("ib_vsl_cd", getIbVslCd());
		this.hashColumns.put("ib_skd_voy_no", getIbSkdVoyNo());
		this.hashColumns.put("ib_skd_dir_cd", getIbSkdDirCd());
		this.hashColumns.put("ib_eta_dt", getIbEtaDt());
		this.hashColumns.put("ib_vvd", getIbVvd());
		this.hashColumns.put("dwell_dt", getDwellDt());
		this.hashColumns.put("bac_nm", getBacNm());
		this.hashColumns.put("down_yn", getDownYn());
		this.hashColumns.put("cust_type", getCustType());
		this.hashColumns.put("ro_chk", getRoChk());
		this.hashColumns.put("other_vvd", getOtherVvd());
		this.hashColumns.put("pck_qty_chk", getPckQtyChk());
		this.hashColumns.put("cntr_ttl_wgt_chk", getCntrTtlWgtChk());
		this.hashColumns.put("meas_qty_chk", getMeasQtyChk());
		this.hashColumns.put("pck_tp_cd_chk", getPckTpCdChk());
		this.hashColumns.put("wgt_ut_cd_chk", getWgtUtCdChk());
		this.hashColumns.put("meas_ut_cd_chk", getMeasUtCdChk());

		this.hashColumns.put("crs_chk_rslt_flg", getCrsChkRsltFlg());
		this.hashColumns.put("crs_chk_rmk", getCrsChkRmk());
		this.hashColumns.put("mf_dl_diff_flg", getMfDlDiffFlg());
		this.hashColumns.put("mf_snd_flg", getMfSndFlg());
		this.hashColumns.put("dmst_port_cd", getDmstPortCd());
		this.hashColumns.put("sel_type", getSelType());

		return this.hashColumns;
	}



	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ntfy_a", "ntfyA");
		this.hashFields.put("elno_b", "elnoB");
		this.hashFields.put("elno_a", "elnoA");
		this.hashFields.put("bz", "bz");
		this.hashFields.put("tr", "tr");
		this.hashFields.put("tp", "tp");
		this.hashFields.put("correction", "correction");
		this.hashFields.put("wgt_value", "wgtValue");
		this.hashFields.put("pkg_code", "pkgCode");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cnee_n", "cneeN");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pre_vvd", "preVvd");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("ntfy_n", "ntfyN");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("wh", "wh");
		this.hashFields.put("pkg_value", "pkgValue");
		this.hashFields.put("msn", "msn");
		this.hashFields.put("shpr_n", "shprN");
		this.hashFields.put("sc", "sc");
		this.hashFields.put("bac", "bac");
		this.hashFields.put("fe", "fe");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("cntr", "cntr");
		this.hashFields.put("desc_code", "descCode");
		this.hashFields.put("bkg_no", "bkg_no");
		this.hashFields.put("a_bkg_no", "a_bkg_no");
		this.hashFields.put("a_bkg_no_split", "a_bkg_no_split");
		this.hashFields.put("hidden3", "hidden3");
		this.hashFields.put("cm", "cm");
		this.hashFields.put("hidden2", "hidden2");
		this.hashFields.put("hidden5", "hidden5");
		this.hashFields.put("hidden6", "hidden6");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("hidden4", "hidden4");
		this.hashFields.put("wgt_code", "wgtCode");
		this.hashFields.put("cnee_a", "cneeA");
		this.hashFields.put("shpr_a", "shprA");
		this.hashFields.put("hidden1", "hidden1");
		this.hashFields.put("cust_name", "custName");
		this.hashFields.put("match", "match");
		this.hashFields.put("cntr_type", "cntr_type");
		this.hashFields.put("kcd_tp", "kcd_tp");
		this.hashFields.put("frob_check", "frob_check");
		this.hashFields.put("elno_wgt_check", "elno_wgt_check");
		this.hashFields.put("elno_check", "elno_check");

		this.hashFields.put("in_bound", "in_bound");
		this.hashFields.put("in_vvd", "in_vvd");
		this.hashFields.put("in_pol", "in_pol");
		this.hashFields.put("in_pod", "in_pod");
		this.hashFields.put("in_pod_tmnl", "in_pod_tmnl");
		this.hashFields.put("in_blno", "in_blno");
		this.hashFields.put("mrn_nbr", "mrn_nbr");
		this.hashFields.put("kt_port", "kt_port");
		this.hashFields.put("usrs30", "usrs30");
		this.hashFields.put("errchk", "errchk");
		this.hashFields.put("cntr_cnt", "cntr_cnt");
		this.hashFields.put("sel", "sel");
		this.hashFields.put("bkgsts", "bkgsts");

		this.hashFields.put("whouse", "whouse");
		this.hashFields.put("whouse_desc", "whouse_desc");
		this.hashFields.put("bkg_del", "bkg_del");
		this.hashFields.put("bkg_por", "bkg_por");
		this.hashFields.put("c_bl_no", "cBlNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("msn_bltp", "msnBltp");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("created_type", "createdType");
		this.hashFields.put("fford_cd", "ffordCd");

		this.hashFields.put("ib_mty_bkg_no", "ibMtyBkgNo");
		this.hashFields.put("ib_mty_bl_no", "ibMtyBlNo");
		this.hashFields.put("ib_trns_seq", "ibTrnsSeq");
		this.hashFields.put("ib_cstms_decl_tp_cd", "ibCstmsDeclTpCd");
		this.hashFields.put("ib_dmst_port_cd", "ibDmstPortCd");
		this.hashFields.put("ib_vsl_cd", "ibVslCd");
		this.hashFields.put("ib_skd_voy_no", "ibSkdVoyNo");
		this.hashFields.put("ib_skd_dir_cd", "ibSkdDirCd");
		this.hashFields.put("ib_eta_dt", "ibEtaDt");
		this.hashFields.put("bac_nm", "bacNm");
		this.hashFields.put("ib_vvd", "ibVvd");
		this.hashFields.put("dwell_dt", "dwellDt");
		this.hashFields.put("down_yn", "downYn");
		this.hashFields.put("cust_type", "custType");
		this.hashFields.put("ro_chk", "roChk");
		this.hashFields.put("other_vvd", "otherVvd");
		this.hashFields.put("pck_qty_chk", "pckQtyChk");
		this.hashFields.put("cntr_ttl_wgt_chk", "cntrTtlWgtChk");
		this.hashFields.put("meas_qty_chk", "measQtyChk");
		this.hashFields.put("pck_tp_cd_chk", "pckTpCdChk");
		this.hashFields.put("wgt_ut_cd_chk", "wgtUtCdChk");
		this.hashFields.put("meas_ut_cd_chk", "measUtCdChk");
		this.hashFields.put("crs_chk_rslt_flg", "crsChkRsltFlg");
		this.hashFields.put("crs_chk_rmk", "crsChkRmk");
		this.hashFields.put("mf_dl_diff_flg", "mfDlDiffFlg");
		this.hashFields.put("mf_snd_flg", "mfSndFlg");
		this.hashFields.put("dmst_port_cd", "dmstPortCd");
		this.hashFields.put("sel_type", "selType");

		return this.hashFields;
	}

	/**
	 * @return the hidden6
	 */
	public String getHidden6() {
		return hidden6;
	}

	/**
	 * @param hidden6 the hidden6 to set
	 */
	public void setHidden6(String hidden6) {
		this.hidden6 = hidden6;
	}

	/**
	 * @return the otherVvd
	 */
	public String getOtherVvd() {
		return otherVvd;
	}

	/**
	 * @param otherVvd the otherVvd to set
	 */
	public void setOtherVvd(String otherVvd) {
		this.otherVvd = otherVvd;
	}

	/**
	 * @return the roChk
	 */
	public String getRoChk() {
		return roChk;
	}

	/**
	 * @param roChk the roChk to set
	 */
	public void setRoChk(String roChk) {
		this.roChk = roChk;
	}

	public String getBacNm() {
		return bacNm;
	}

	public void setBacNm(String bacNm) {
		this.bacNm = bacNm;
	}

	public String getDwellDt() {
		return dwellDt;
	}

	public void setDwellDt(String dwellDt) {
		this.dwellDt = dwellDt;
	}

	public String getIbVvd() {
		return ibVvd;
	}

	public void setIbVvd(String ibVvd) {
		this.ibVvd = ibVvd;
	}

	public String getIbMtyBkgNo() {
		return ibMtyBkgNo;
	}

	public void setIbMtyBkgNo(String ibMtyBkgNo) {
		this.ibMtyBkgNo = ibMtyBkgNo;
	}

	public String getIbMtyBlNo() {
		return ibMtyBlNo;
	}

	public void setIbMtyBlNo(String ibMtyBlNo) {
		this.ibMtyBlNo = ibMtyBlNo;
	}

	public String getIbTrnsSeq() {
		return ibTrnsSeq;
	}

	public void setIbTrnsSeq(String ibTrnsSeq) {
		this.ibTrnsSeq = ibTrnsSeq;
	}

	public String getIbCstmsDeclTpCd() {
		return ibCstmsDeclTpCd;
	}

	public void setIbCstmsDeclTpCd(String ibCstmsDeclTpCd) {
		this.ibCstmsDeclTpCd = ibCstmsDeclTpCd;
	}

	public String getIbDmstPortCd() {
		return ibDmstPortCd;
	}

	public void setIbDmstPortCd(String ibDmstPortCd) {
		this.ibDmstPortCd = ibDmstPortCd;
	}

	/**
	 * @return the custType
	 */
	public String getCustType() {
		return custType;
	}

	/**
	 * @param custType the custType to set
	 */
	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getIbVslCd() {
		return ibVslCd;
	}

	public void setIbVslCd(String ibVslCd) {
		this.ibVslCd = ibVslCd;
	}

	public String getIbSkdVoyNo() {
		return ibSkdVoyNo;
	}

	public void setIbSkdVoyNo(String ibSkdVoyNo) {
		this.ibSkdVoyNo = ibSkdVoyNo;
	}

	public String getIbSkdDirCd() {
		return ibSkdDirCd;
	}

	public void setIbSkdDirCd(String ibSkdDirCd) {
		this.ibSkdDirCd = ibSkdDirCd;
	}

	public String getIbEtaDt() {
		return ibEtaDt;
	}

	public void setIbEtaDt(String ibEtaDt) {
		this.ibEtaDt = ibEtaDt;
	}

	public String getMsnBltp() {
		return msnBltp;
	}

	public void setMsnBltp(String msnBltp) {
		this.msnBltp = msnBltp;
	}

	public String getVvdCd() {
		return vvdCd;
	}

	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}

	public String getFfordCd() {
		return ffordCd;
	}

	public void setFfordCd(String ffordCd) {
		this.ffordCd = ffordCd;
	}

	public String getCntrNo() {
		return cntrNo;
	}

	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	public String getCBlNo() {
		return cBlNo;
	}

	public void setCBlNo(String cBlNo) {
		this.cBlNo = cBlNo;
	}

	/**
	 * Column Info
	 * @return ntfyA
	 */
	public String getNtfyA() {
		return this.ntfyA;
	}

	/**
	 * Column Info
	 * @return elnoB
	 */
	public String getElnoB() {
		return this.elnoB;
	}

	/**
	 * Column Info
	 * @return elnoA
	 */
	public String getElnoA() {
		return this.elnoA;
	}

	/**
	 * Column Info
	 * @return bz
	 */
	public String getBz() {
		return this.bz;
	}

	/**
	 * Column Info
	 * @return tr
	 */
	public String getTr() {
		return this.tr;
	}

	/**
	 * Column Info
	 * @return tp
	 */
	public String getTp() {
		return this.tp;
	}

	/**
	 * Column Info
	 * @return correction
	 */
	public String getCorrection() {
		return this.correction;
	}

	/**
	 * Column Info
	 * @return wgtValue
	 */
	public String getWgtValue() {
		return this.wgtValue;
	}

	/**
	 * Column Info
	 * @return pkgCode
	 */
	public String getPkgCode() {
		return this.pkgCode;
	}

	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}

	/**
	 * Column Info
	 * @return cneeN
	 */
	public String getCneeN() {
		return this.cneeN;
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
	 * @return preVvd
	 */
	public String getPreVvd() {
		return this.preVvd;
	}

	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}

	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}

	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}

	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}

	/**
	 * Column Info
	 * @return ntfyN
	 */
	public String getNtfyN() {
		return this.ntfyN;
	}

	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}

	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}

	/**
	 * Column Info
	 * @return wh
	 */
	public String getWh() {
		return this.wh;
	}

	/**
	 * Column Info
	 * @return pkgValue
	 */
	public String getPkgValue() {
		return this.pkgValue;
	}

	/**
	 * Column Info
	 * @return msn
	 */
	public String getMsn() {
		return this.msn;
	}

	/**
	 * Column Info
	 * @return shprN
	 */
	public String getShprN() {
		return this.shprN;
	}

	/**
	 * Column Info
	 * @return sc
	 */
	public String getSc() {
		return this.sc;
	}

	/**
	 * Column Info
	 * @return bac
	 */
	public String getBac() {
		return this.bac;
	}

	/**
	 * Column Info
	 * @return fe
	 */
	public String getFe() {
		return this.fe;
	}

	/**
	 * Column Info
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
	}

	/**
	 * Column Info
	 * @return cntr
	 */
	public String getCntr() {
		return this.cntr;
	}

	/**
	 * Column Info
	 * @return descCode
	 */
	public String getDescCode() {
		return this.descCode;
	}

	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkg_no;
	}

	public String getABkgNo(){
		return this.a_bkg_no;
	}

	public String getABkgNoSplit(){
		return this.a_bkg_no_split;
	}
	/**
	 * Column Info
	 * @return hidden3
	 */
	public String getHidden3() {
		return this.hidden3;
	}

	/**
	 * Column Info
	 * @return cm
	 */
	public String getCm() {
		return this.cm;
	}

	/**
	 * Column Info
	 * @return hidden2
	 */
	public String getHidden2() {
		return this.hidden2;
	}

	/**
	 * Column Info
	 * @return hidden5
	 */
	public String getHidden5() {
		return this.hidden5;
	}

	/**
	 * @return the downYn
	 */
	public String getDownYn() {
		return downYn;
	}

	/**
	 * @param downYn the downYn to set
	 */
	public void setDownYn(String downYn) {
		this.downYn = downYn;
	}

	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}

	public String getBkgPor(){
		return this.bkg_por;
	}

	public String getBkgDel(){
		return this.bkg_del;
	}

	public String getWhouse(){
		return this.whouse;
	}
	public String getWhouseDesc(){
		return this.whouse_desc;
	}

	/**
	 * Column Info
	 * @return hidden4
	 */
	public String getHidden4() {
		return this.hidden4;
	}

	/**
	 * Column Info
	 * @return wgtCode
	 */
	public String getWgtCode() {
		return this.wgtCode;
	}

	/**
	 * Column Info
	 * @return cneeA
	 */
	public String getCneeA() {
		return this.cneeA;
	}

	/**
	 * Column Info
	 * @return shprA
	 */
	public String getShprA() {
		return this.shprA;
	}

	/**
	 * Column Info
	 * @return hidden1
	 */
	public String getHidden1() {
		return this.hidden1;
	}

	/**
	 * Column Info
	 * @return custName
	 */
	public String getCustName() {
		return this.custName;
	}

	/**
	 * Column Info
	 * @return match
	 */
	public String getMatch() {
		return this.match;
	}


	public String getInBound()	{	return this.in_bound;	}
	public String getInVvd()	{ 	return this.in_vvd;		}
	public String getInPol()	{	return this.in_pol;		}
	public String getInPod()	{	return this.in_pod;		}
	public String getInPodTmnl(){	return this.in_pod_tmnl;}
	public String getInBlno()	{	return this.in_blno;	}
	public String getMrnNbr()	{	return this.mrn_nbr;	}

	public String getCreatedType() 	{	return this.createdType;	}
	public String getCntrType()		{	return this.cntr_type;		}
	public String getKcdTp()		{	return this.kcd_tp;			}
	public String getFrobCheck()	{	return this.frob_check;		}
	public String getElnoWgtCheck() {	return this.elno_wgt_check;	}
	public String getElNoCheck()	{   return this.elno_check;		}
	public String getKtPort()		{ 	return this.kt_port;		}
	public String getErrChk()		{	return this.errchk;			}
	public String getCntrCnt()		{	return this.cntr_cnt;		}
	public String getSel()			{	return this.sel;			}

	public String getBkgsts()		{	return this.bkgsts;			}

	/**
	 * Column Info
	 * @return crsChkRsltFlg
	 */
	public String getCrsChkRsltFlg() {
		return this.crsChkRsltFlg;
	}

	/**
	 * Column Info
	 * @return crsChkRmk
	 */
	public String getCrsChkRmk() {
		return this.crsChkRmk;
	}

	/**
	 * Column Info
	 * @return mfDlDiffFlg
	 */
	public String getMfDlDiffFlg() {
		return this.mfDlDiffFlg;
	}

	/**
	 * Column Info
	 * @return mfSndFlg
	 */
	public String getMfSndFlg() {
		return this.mfSndFlg;
	}

	/**
	 * Column Info
	 * @return dmstPortCd
	 */
	public String getDmstPortCd() {
		return this.dmstPortCd;
	}

	public String getSelType	(){
		return this.selType	;
		}

	/**
	 * Column Info
	 * @param ntfyA
	 */
	public void setNtfyA(String ntfyA) {
		this.ntfyA = ntfyA;
	}

	/**
	 * Column Info
	 * @param elnoB
	 */
	public void setElnoB(String elnoB) {
		this.elnoB = elnoB;
	}

	/**
	 * Column Info
	 * @param elnoA
	 */
	public void setElnoA(String elnoA) {
		this.elnoA = elnoA;
	}

	/**
	 * Column Info
	 * @param bz
	 */
	public void setBz(String bz) {
		this.bz = bz;
	}

	/**
	 * Column Info
	 * @param tr
	 */
	public void setTr(String tr) {
		this.tr = tr;
	}

	/**
	 * Column Info
	 * @param tp
	 */
	public void setTp(String tp) {
		this.tp = tp;
	}

	/**
	 * Column Info
	 * @param correction
	 */
	public void setCorrection(String correction) {
		this.correction = correction;
	}

	/**
	 * Column Info
	 * @param wgtValue
	 */
	public void setWgtValue(String wgtValue) {
		this.wgtValue = wgtValue;
	}

	/**
	 * Column Info
	 * @param pkgCode
	 */
	public void setPkgCode(String pkgCode) {
		this.pkgCode = pkgCode;
	}

	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * @param cneeN
	 */
	public void setCneeN(String cneeN) {
		this.cneeN = cneeN;
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
	 * @param preVvd
	 */
	public void setPreVvd(String preVvd) {
		this.preVvd = preVvd;
	}

	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}

	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}

	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}

	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}

	/**
	 * Column Info
	 * @param ntfyN
	 */
	public void setNtfyN(String ntfyN) {
		this.ntfyN = ntfyN;
	}

	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}

	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}

	/**
	 * Column Info
	 * @param wh
	 */
	public void setWh(String wh) {
		this.wh = wh;
	}

	/**
	 * Column Info
	 * @param pkgValue
	 */
	public void setPkgValue(String pkgValue) {
		this.pkgValue = pkgValue;
	}

	/**
	 * Column Info
	 * @param msn
	 */
	public void setMsn(String msn) {
		this.msn = msn;
	}

	/**
	 * Column Info
	 * @param shprN
	 */
	public void setShprN(String shprN) {
		this.shprN = shprN;
	}

	/**
	 * Column Info
	 * @param sc
	 */
	public void setSc(String sc) {
		this.sc = sc;
	}

	/**
	 * Column Info
	 * @param bac
	 */
	public void setBac(String bac) {
		this.bac = bac;
	}

	/**
	 * Column Info
	 * @param fe
	 */
	public void setFe(String fe) {
		this.fe = fe;
	}

	/**
	 * Column Info
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
	}

	/**
	 * Column Info
	 * @param cntr
	 */
	public void setCntr(String cntr) {
		this.cntr = cntr;
	}

	/**
	 * Column Info
	 * @param descCode
	 */
	public void setDescCode(String descCode) {
		this.descCode = descCode;
	}

	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkg_no) {
		this.bkg_no = bkg_no;
	}

	/**
	 * Column Info
	 * @param hidden3
	 */
	public void setHidden3(String hidden3) {
		this.hidden3 = hidden3;
	}

	/**
	 * Column Info
	 * @param cm
	 */
	public void setCm(String cm) {
		this.cm = cm;
	}

	/**
	 * Column Info
	 * @param hidden2
	 */
	public void setHidden2(String hidden2) {
		this.hidden2 = hidden2;
	}

	/**
	 * Column Info
	 * @param hidden5
	 */
	public void setHidden5(String hidden5) {
		this.hidden5 = hidden5;
	}

	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}

	/**
	 * Column Info
	 * @param hidden4
	 */
	public void setHidden4(String hidden4) {
		this.hidden4 = hidden4;
	}

	/**
	 * Column Info
	 * @param wgtCode
	 */
	public void setWgtCode(String wgtCode) {
		this.wgtCode = wgtCode;
	}

	/**
	 * Column Info
	 * @param cneeA
	 */
	public void setCneeA(String cneeA) {
		this.cneeA = cneeA;
	}

	/**
	 * Column Info
	 * @param shprA
	 */
	public void setShprA(String shprA) {
		this.shprA = shprA;
	}

	/**
	 * Column Info
	 * @param hidden1
	 */
	public void setHidden1(String hidden1) {
		this.hidden1 = hidden1;
	}

	/**
	 * Column Info
	 * @param custName
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * Column Info
	 * @param match
	 */
	public void setMatch(String match) {
		this.match = match;
	}
	public void setABkgNo(String p){
		this.a_bkg_no = p;
	}
	public void setABkgNoSplit(String p){
		this.a_bkg_no_split = p;
	}

	public void setInBound(String p)	{	this.in_bound 		= p;	}
	public void setInVvd(String p)		{ 	this.in_vvd 		= p;	}
	public void setInPol(String p)		{	this.in_pol 		= p;	}
	public void setInPod(String p)		{	this.in_pod 		= p;	}
	public void setInPodTmnl(String p)	{	this.in_pod_tmnl 	= p;	}
	public void setInBlno(String p)		{	this.in_blno 		= p;	}
	public void setMrnNbr(String p)		{	this.mrn_nbr 		= p;	}

	public void setCreatedType(String p) 	{	this.createdType = p;	}
	public void setCntrType(String p)		{	this.cntr_type = p;		}
	public void setKcdTp(String p)			{	this.kcd_tp = p;		}
	public void setFrobCheck(String p)		{	this.frob_check = p;	}
	public void setElnoWgtCheck(String p) 	{	this.elno_wgt_check = p;}
	public void setElNoCheck(String p)		{ 	this.elno_check = p;	}
	public void setKtPort(String p)			{	this.kt_port = p;		}

	public void setErrChk(String p)			{	this.errchk = p;		}
	public void setCntrCnt(String p)		{ 	this.cntr_cnt = p;		}
	public void setSel(String p)			{	this.sel = p;			}
	public void setBkgsts(String p)			{ 	this.bkgsts = p;		}
	public void setBkgPor(String p)			{ 	this.bkg_por = p;		}
	public void setBkgDel(String p)			{ 	this.bkg_del = p;		}
	public void setWhouse(String p)			{ 	this.whouse = p;		}
	public void setWhouseDesc(String p)		{	this.whouse_desc = p;	}


	public String getPckQtyChk() {
		return pckQtyChk;
	}

	public void setPckQtyChk(String pckQtyChk) {
		this.pckQtyChk = pckQtyChk;
	}

	public String getCntrTtlWgtChk() {
		return cntrTtlWgtChk;
	}

	public void setCntrTtlWgtChk(String cntrTtlWgtChk) {
		this.cntrTtlWgtChk = cntrTtlWgtChk;
	}

	public String getMeasQtyChk() {
		return measQtyChk;
	}

	public void setMeasQtyChk(String measQtyChk) {
		this.measQtyChk = measQtyChk;
	}

	public String getPckTpCdChk() {
		return pckTpCdChk;
	}

	public void setPckTpCdChk(String pckTpCdChk) {
		this.pckTpCdChk = pckTpCdChk;
	}

	public String getWgtUtCdChk() {
		return wgtUtCdChk;
	}

	public void setWgtUtCdChk(String wgtUtCdChk) {
		this.wgtUtCdChk = wgtUtCdChk;
	}

	public String getMeasUtCdChk() {
		return measUtCdChk;
	}

	public void setMeasUtCdChk(String measUtCdChk) {
		this.measUtCdChk = measUtCdChk;
	}

	/**
	 * Column Info
	 * @param crsChkRsltFlg
	 */
	public void setCrsChkRsltFlg(String crsChkRsltFlg) {
		this.crsChkRsltFlg = crsChkRsltFlg;
	}

	/**
	 * Column Info
	 * @param crsChkRmk
	 */
	public void setCrsChkRmk(String crsChkRmk) {
		this.crsChkRmk = crsChkRmk;
	}

	/**
	 * Column Info
	 * @param mfDlDiffFlg
	 */
	public void setMfDlDiffFlg(String mfDlDiffFlg) {
		this.mfDlDiffFlg = mfDlDiffFlg;
	}

	/**
	 * Column Info
	 * @param mfSndFlg
	 */
	public void setMfSndFlg(String mfSndFlg) {
		this.mfSndFlg = mfSndFlg;
	}

	/**
	 * Column Info
	 * @param dmstPortCd
	 */
	public void setDmstPortCd(String dmstPortCd) {
		this.dmstPortCd = dmstPortCd;
	}

	/**
	 * Column Info
	 * @param selType
	 */
	public void setSelType(String selType) {
		this.selType = selType;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNtfyA(JSPUtil.getParameter(request, "ntfy_a", ""));
		setElnoB(JSPUtil.getParameter(request, "elno_b", ""));
		setElnoA(JSPUtil.getParameter(request, "elno_a", ""));
		setBz(JSPUtil.getParameter(request, "bz", ""));
		setTr(JSPUtil.getParameter(request, "tr", ""));
		setTp(JSPUtil.getParameter(request, "tp", ""));
		setCorrection(JSPUtil.getParameter(request, "correction", ""));
		setWgtValue(JSPUtil.getParameter(request, "wgt_value", ""));
		setPkgCode(JSPUtil.getParameter(request, "pkg_code", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setCneeN(JSPUtil.getParameter(request, "cnee_n", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPreVvd(JSPUtil.getParameter(request, "pre_vvd", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setNtfyN(JSPUtil.getParameter(request, "ntfy_n", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, "meas_ut_cd", ""));
		setWh(JSPUtil.getParameter(request, "wh", ""));
		setPkgValue(JSPUtil.getParameter(request, "pkg_value", ""));
		setMsn(JSPUtil.getParameter(request, "msn", ""));
		setShprN(JSPUtil.getParameter(request, "shpr_n", ""));
		setSc(JSPUtil.getParameter(request, "sc", ""));
		setBac(JSPUtil.getParameter(request, "bac", ""));
		setFe(JSPUtil.getParameter(request, "fe", ""));
		setActWgt(JSPUtil.getParameter(request, "act_wgt", ""));
		setCntr(JSPUtil.getParameter(request, "cntr", ""));
		setDescCode(JSPUtil.getParameter(request, "desc_code", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setABkgNo(JSPUtil.getParameter(request, "a_bkg_no", ""));
		setABkgNoSplit(JSPUtil.getParameter(request, "a_bkg_no_split", ""));
		setHidden3(JSPUtil.getParameter(request, "hidden3", ""));
		setCm(JSPUtil.getParameter(request, "cm", ""));
		setHidden2(JSPUtil.getParameter(request, "hidden2", ""));
		setHidden5(JSPUtil.getParameter(request, "hidden5", ""));
		setHidden6(JSPUtil.getParameter(request, "hidden6", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setHidden4(JSPUtil.getParameter(request, "hidden4", ""));
		setWgtCode(JSPUtil.getParameter(request, "wgt_code", ""));
		setCneeA(JSPUtil.getParameter(request, "cnee_a", ""));
		setShprA(JSPUtil.getParameter(request, "shpr_a", ""));
		setHidden1(JSPUtil.getParameter(request, "hidden1", ""));
		setCustName(JSPUtil.getParameter(request, "cust_name", ""));
		setMatch(JSPUtil.getParameter(request, "match", ""));

		setCreatedType(JSPUtil.getParameter(request, "created_type", ""));
		setCntrType(JSPUtil.getParameter(request, "cntr_type", ""));
		setKcdTp(JSPUtil.getParameter(request, "kcd_tp", ""));
		setFrobCheck(JSPUtil.getParameter(request, "frob_check", ""));
		setElnoWgtCheck(JSPUtil.getParameter(request, "elno_wgt_check", ""));
		setElNoCheck(JSPUtil.getParameter(request, "elno_check", ""));


		setInBound(JSPUtil.getParameter(request, "in_bound", ""));
		setInVvd(JSPUtil.getParameter(request, "in_vvd", ""));
		setInPol(JSPUtil.getParameter(request, "in_pol", ""));
		setInPod(JSPUtil.getParameter(request, "in_pod", ""));
		setInPodTmnl(JSPUtil.getParameter(request, "in_pod_tmnl", ""));
		setInBlno(JSPUtil.getParameter(request, "in_blno", ""));
		setMrnNbr(JSPUtil.getParameter(request, "mrn_nbr", ""));
		setKtPort(JSPUtil.getParameter(request, "kt_port", ""));
		setErrChk(JSPUtil.getParameter(request, "errchk", ""));
		setCntrCnt(JSPUtil.getParameter(request, "cntr_cnt", ""));
		setSel(JSPUtil.getParameter(request, "sel", ""));
		setBkgsts(JSPUtil.getParameter(request, "bkgsts", ""));

		setWhouse(JSPUtil.getParameter(request, "whouse", ""));
		setWhouseDesc(JSPUtil.getParameter(request, "whouse_desc", ""));
		setBkgDel(JSPUtil.getParameter(request, "bkg_del", ""));
		setBkgPor(JSPUtil.getParameter(request, "bkg_por", ""));
		setCBlNo(JSPUtil.getParameter(request, "c_bl_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setMsnBltp(JSPUtil.getParameter(request, "msn_bltp", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setFfordCd(JSPUtil.getParameter(request, "fford_cd", ""));

		setIbMtyBkgNo(JSPUtil.getParameter(request, "ib_mty_bkg_no", ""));
		setIbMtyBlNo(JSPUtil.getParameter(request, "ib_mty_bl_no", ""));
		setIbTrnsSeq(JSPUtil.getParameter(request, "ib_trns_seq", ""));
		setIbCstmsDeclTpCd(JSPUtil.getParameter(request, "ib_cstms_decl_tp_cd", ""));
		setIbDmstPortCd(JSPUtil.getParameter(request, "ib_dmst_port_cd", ""));
		setIbVslCd(JSPUtil.getParameter(request, "ib_vsl_cd", ""));
		setIbSkdVoyNo(JSPUtil.getParameter(request, "ib_skd_voy_no", ""));
		setIbSkdDirCd(JSPUtil.getParameter(request, "ib_skd_dir_cd", ""));
		setIbEtaDt(JSPUtil.getParameter(request, "ib_eta_dt", ""));
		setBacNm(JSPUtil.getParameter(request, "bac_nm", ""));
		setDwellDt(JSPUtil.getParameter(request, "dwell_dt", ""));
		setIbVvd(JSPUtil.getParameter(request, "ib_vvd", ""));
		setDownYn(JSPUtil.getParameter(request, "down_yn", ""));
		setCustType(JSPUtil.getParameter(request, "cust_type", ""));
		setRoChk(JSPUtil.getParameter(request, "ro_chk", ""));
		setOtherVvd(JSPUtil.getParameter(request, "other_vvd", ""));
		setPckQtyChk(JSPUtil.getParameter(request, "pck_qty_chk", ""));
		setCntrTtlWgtChk(JSPUtil.getParameter(request, "cntr_ttl_wgt_chk", ""));
		setMeasQtyChk(JSPUtil.getParameter(request, "meas_qty_chk", ""));
		setPckTpCdChk(JSPUtil.getParameter(request, "pck_tp_cd_chk", ""));
		setWgtUtCdChk(JSPUtil.getParameter(request, "wgt_ut_cd_chk", ""));
		setMeasUtCdChk(JSPUtil.getParameter(request, "meas_ut_cd_chk", ""));
		setCrsChkRsltFlg(JSPUtil.getParameter(request, "crs_chk_rslt_flg", ""));
		setCrsChkRmk(JSPUtil.getParameter(request, "crs_chk_rmk", ""));
		setMfDlDiffFlg(JSPUtil.getParameter(request, "mf_dl_diff_flg", ""));
		setMfSndFlg(JSPUtil.getParameter(request, "mf_snd_flg", ""));
		setDmstPortCd(JSPUtil.getParameter(request, "dmst_port_cd", ""));
		setSelType(JSPUtil.getParameter(request, "sel_type", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchManifestInfoVO[]
	 */
	public Kor24ManifestInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchManifestInfoVO[]
	 */
	public Kor24ManifestInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Kor24ManifestInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ntfyA = (JSPUtil.getParameter(request, prefix	+ "ntfy_a".trim(), length));
			String[] elnoB = (JSPUtil.getParameter(request, prefix	+ "elno_b".trim(), length));
			String[] elnoA = (JSPUtil.getParameter(request, prefix	+ "elno_a".trim(), length));
			String[] bz = (JSPUtil.getParameter(request, prefix	+ "bz".trim(), length));
			String[] tr = (JSPUtil.getParameter(request, prefix	+ "tr".trim(), length));
			String[] tp = (JSPUtil.getParameter(request, prefix	+ "tp".trim(), length));
			String[] correction = (JSPUtil.getParameter(request, prefix	+ "correction".trim(), length));
			String[] wgtValue = (JSPUtil.getParameter(request, prefix	+ "wgt_value".trim(), length));
			String[] pkgCode = (JSPUtil.getParameter(request, prefix	+ "pkg_code".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] cneeN = (JSPUtil.getParameter(request, prefix	+ "cnee_n".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] preVvd = (JSPUtil.getParameter(request, prefix	+ "pre_vvd".trim(), length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol".trim(), length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd".trim(), length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty".trim(), length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty".trim(), length));
			String[] ntfyN = (JSPUtil.getParameter(request, prefix	+ "ntfy_n".trim(), length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd".trim(), length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd".trim(), length));
			String[] wh = (JSPUtil.getParameter(request, prefix	+ "wh".trim(), length));
			String[] pkgValue = (JSPUtil.getParameter(request, prefix	+ "pkg_value".trim(), length));
			String[] msn = (JSPUtil.getParameter(request, prefix	+ "msn".trim(), length));
			String[] shprN = (JSPUtil.getParameter(request, prefix	+ "shpr_n".trim(), length));
			String[] sc = (JSPUtil.getParameter(request, prefix	+ "sc".trim(), length));
			String[] bac = (JSPUtil.getParameter(request, prefix	+ "bac".trim(), length));
			String[] fe = (JSPUtil.getParameter(request, prefix	+ "fe".trim(), length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt".trim(), length));
			String[] cntr = (JSPUtil.getParameter(request, prefix	+ "cntr".trim(), length));
			String[] descCode = (JSPUtil.getParameter(request, prefix	+ "desc_code".trim(), length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no".trim(), length));
			String[] abkgNo = (JSPUtil.getParameter(request, prefix	+ "a_bkg_no".trim(), length));
			String[] abkgNosp = (JSPUtil.getParameter(request, prefix	+ "a_bkg_no_split".trim(), length));
			String[] hidden3 = (JSPUtil.getParameter(request, prefix	+ "hidden3".trim(), length));
			String[] cm = (JSPUtil.getParameter(request, prefix	+ "cm".trim(), length));
			String[] hidden2 = (JSPUtil.getParameter(request, prefix	+ "hidden2".trim(), length));
			String[] hidden5 = (JSPUtil.getParameter(request, prefix	+ "hidden5".trim(), length));
			String[] hidden6 = (JSPUtil.getParameter(request, prefix	+ "hidden6".trim(), length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod".trim(), length));
			String[] hidden4 = (JSPUtil.getParameter(request, prefix	+ "hidden4".trim(), length));
			String[] wgtCode = (JSPUtil.getParameter(request, prefix	+ "wgt_code".trim(), length));
			String[] cneeA = (JSPUtil.getParameter(request, prefix	+ "cnee_a".trim(), length));
			String[] shprA = (JSPUtil.getParameter(request, prefix	+ "shpr_a".trim(), length));
			String[] hidden1 = (JSPUtil.getParameter(request, prefix	+ "hidden1".trim(), length));
			String[] custName = (JSPUtil.getParameter(request, prefix	+ "cust_name".trim(), length));
			String[] match = (JSPUtil.getParameter(request, prefix	+ "match".trim(), length));

			String[] createdtype = (JSPUtil.getParameter(request, prefix	+ "created_type".trim(), length));
			String[] cntrtype = (JSPUtil.getParameter(request, prefix	+ "cntr_type".trim(), length));
			String[] kcdtp = (JSPUtil.getParameter(request, prefix	+ "kcd_tp".trim(), length));
			String[] frobcheck = (JSPUtil.getParameter(request, prefix	+ "frob_check".trim(), length));
			String[] elnowgtcheck = (JSPUtil.getParameter(request, prefix	+ "elno_wgt_check".trim(), length));
			String[] elnocheck = (JSPUtil.getParameter(request, prefix	+ "elno_check".trim(), length));
			String[] abound = (JSPUtil.getParameter(request, prefix	+ "in_bound".trim(), length));
			String[] avvd = (JSPUtil.getParameter(request, prefix	+ "in_vvd".trim(), length));
			String[] apol = (JSPUtil.getParameter(request, prefix	+ "in_pol".trim(), length));
			String[] apod = (JSPUtil.getParameter(request, prefix	+ "in_pod".trim(), length));
			String[] apod_tmnl = (JSPUtil.getParameter(request, prefix	+ "in_pod_tmnl".trim(), length));
			String[] ablno = (JSPUtil.getParameter(request, prefix	+ "in_blno".trim(), length));
			String[] amrn_nbr = (JSPUtil.getParameter(request, prefix	+ "mrn_nbr".trim(), length));
			String[] ktport = (JSPUtil.getParameter(request, prefix	+ "kt_port".trim(), length));
			String[] erchk = (JSPUtil.getParameter(request, prefix + "errchk".trim(), length));
			String[] cntrcnt = (JSPUtil.getParameter(request, prefix + "cntr_cnt".trim(), length));
			String[] asel = (JSPUtil.getParameter(request, prefix + "sel".trim(), length));
			String[] abkgsts = (JSPUtil.getParameter(request, prefix + "bkgsts".trim(), length));

			String[] awhouse = (JSPUtil.getParameter(request, prefix + "whouse".trim(), length));
			String[] awhouse_desc = (JSPUtil.getParameter(request, prefix + "whouse_desc".trim(), length));
			String[] abkg_del = (JSPUtil.getParameter(request, prefix + "bkg_del".trim(), length));
			String[] abkg_por = (JSPUtil.getParameter(request, prefix + "bkg_por".trim(), length));
			String[] cBlNo = (JSPUtil.getParameter(request, prefix + "c_bl_no".trim(), length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no".trim(), length));
			String[] msnBltp = (JSPUtil.getParameter(request, prefix + "msn_bltp".trim(), length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix + "vvd_cd".trim(), length));
			String[] ffordCd = (JSPUtil.getParameter(request, prefix + "fford_cd".trim(), length));

			String[] ibMtyBkgNo = (JSPUtil.getParameter(request, prefix + "ib_mty_bkg_no".trim(), length));
			String[] ibMtyBlNo = (JSPUtil.getParameter(request, prefix + "ib_mty_bl_no".trim(), length));
			String[] ibTrnsSeq = (JSPUtil.getParameter(request, prefix + "ib_trns_seq".trim(), length));
			String[] ibCstmsDeclTpCd = (JSPUtil.getParameter(request, prefix + "ib_cstms_decl_tp_cd".trim(), length));
			String[] ibDmstPortCd = (JSPUtil.getParameter(request, prefix + "ib_dmst_port_cd".trim(), length));
			String[] ibVslCd = (JSPUtil.getParameter(request, prefix + "ib_vsl_cd".trim(), length));
			String[] ibSkdVoyNo = (JSPUtil.getParameter(request, prefix + "ib_skd_voy_no".trim(), length));
			String[] ibSkdDirCd = (JSPUtil.getParameter(request, prefix + "ib_skd_dir_cd".trim(), length));
			String[] ibEtaDt = (JSPUtil.getParameter(request, prefix + "ib_eta_dt".trim(), length));
			String[] bacNm = (JSPUtil.getParameter(request, prefix + "bac_nm".trim(), length));
			String[] dwellDt = (JSPUtil.getParameter(request, prefix + "dwell_dt".trim(), length));
			String[] ibVvd = (JSPUtil.getParameter(request, prefix + "ib_vvd".trim(), length));
			String[] downYn = (JSPUtil.getParameter(request, prefix + "down_yn".trim(), length));
			String[] custType = (JSPUtil.getParameter(request, prefix + "cust_type".trim(), length));
			String[] roChk = (JSPUtil.getParameter(request, prefix + "ro_chk".trim(), length));
			String[] otherVvd = (JSPUtil.getParameter(request, prefix + "other_vvd".trim(), length));
			String[] pckQtyChk = (JSPUtil.getParameter(request, prefix + "pck_qty_chk".trim(), length));
			String[] cntrTtlWgtChk = (JSPUtil.getParameter(request, prefix + "cntr_ttl_wgt_chk".trim(), length));
			String[] measQtyChk = (JSPUtil.getParameter(request, prefix + "meas_qty_chk".trim(), length));
			String[] pckTpCdChk = (JSPUtil.getParameter(request, prefix + "pck_tp_cd_chk".trim(), length));
			String[] wgtUtCdChk = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd_chk".trim(), length));
			String[] measUtCdChk = (JSPUtil.getParameter(request, prefix + "meas_ut_cd_chk".trim(), length));
			String[] crsChkRsltFlg = (JSPUtil.getParameter(request, prefix + "crs_chk_rslt_flg".trim(), length));
			String[] crsChkRmk = (JSPUtil.getParameter(request, prefix + "crs_chk_rmk".trim(), length));

			String[] mfDlDiffFlg = (JSPUtil.getParameter(request, prefix + "mf_dl_diff_flg".trim(), length));
			String[] mfSndFlg = (JSPUtil.getParameter(request, prefix + "mf_snd_flg".trim(), length));
			String[] dmstPortCd = (JSPUtil.getParameter(request, prefix + "dmst_port_cd".trim(), length));
			String[] selType = (JSPUtil.getParameter(request, prefix	+ "sel_type".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new Kor24ManifestInfoVO();
				if (ntfyA[i] != null)				model.setNtfyA(ntfyA[i]);
				if (elnoB[i] != null)				model.setElnoB(elnoB[i]);
				if (elnoA[i] != null)				model.setElnoA(elnoA[i]);
				if (bz[i] != null)					model.setBz(bz[i]);
				if (tr[i] != null)					model.setTr(tr[i]);
				if (tp[i] != null)					model.setTp(tp[i]);
				if (correction[i] != null)			model.setCorrection(correction[i]);
				if (wgtValue[i] != null)			model.setWgtValue(wgtValue[i]);
				if (pkgCode[i] != null)				model.setPkgCode(pkgCode[i]);
				if (blNo[i] != null)				model.setBlNo(blNo[i]);
				if (cneeN[i] != null)				model.setCneeN(cneeN[i]);
				if (pagerows[i] != null)			model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)				model.setIbflag(ibflag[i]);
				if (preVvd[i] != null)				model.setPreVvd(preVvd[i]);
				if (pol[i] != null)					model.setPol(pol[i]);
				if (wgtUtCd[i] != null)				model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)				model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)				model.setPckQty(pckQty[i]);
				if (ntfyN[i] != null)				model.setNtfyN(ntfyN[i]);
				if (pckTpCd[i] != null)				model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)			model.setMeasUtCd(measUtCd[i]);
				if (wh[i] != null)					model.setWh(wh[i]);
				if (pkgValue[i] != null)			model.setPkgValue(pkgValue[i]);
				if (msn[i] != null)					model.setMsn(msn[i]);
				if (shprN[i] != null)				model.setShprN(shprN[i]);
				if (sc[i] != null)					model.setSc(sc[i]);
				if (bac[i] != null)					model.setBac(bac[i]);
				if (fe[i] != null)					model.setFe(fe[i]);
				if (actWgt[i] != null)				model.setActWgt(actWgt[i]);
				if (cntr[i] != null)				model.setCntr(cntr[i]);
				if (descCode[i] != null)			model.setDescCode(descCode[i]);
				if (bkgNo[i] != null)				model.setBkgNo(bkgNo[i]);
				if (abkgNo[i] != null)				model.setABkgNo(abkgNo[i]);
				if (abkgNosp[i] != null)			model.setABkgNoSplit(abkgNosp[i]);
				if (hidden3[i] != null)				model.setHidden3(hidden3[i]);
				if (cm[i] != null)					model.setCm(cm[i]);
				if (hidden2[i] != null)				model.setHidden2(hidden2[i]);
				if (hidden5[i] != null)				model.setHidden5(hidden5[i]);
				if (hidden6[i] != null)				model.setHidden6(hidden6[i]);
				if (pod[i] != null)					model.setPod(pod[i]);
				if (hidden4[i] != null)				model.setHidden4(hidden4[i]);
				if (wgtCode[i] != null)				model.setWgtCode(wgtCode[i]);
				if (cneeA[i] != null)				model.setCneeA(cneeA[i]);
				if (shprA[i] != null)				model.setShprA(shprA[i]);
				if (hidden1[i] != null)				model.setHidden1(hidden1[i]);
				if (custName[i] != null)			model.setCustName(custName[i]);
				if (match[i] != null)				model.setMatch(match[i]);

				if (createdtype[i] != null)			model.setCreatedType(createdtype[i]);
				if (cntrtype[i] != null)			model.setCntrType(cntrtype[i]);
				if (kcdtp[i] != null)				model.setKcdTp(kcdtp[i]);
				if (frobcheck[i] != null)			model.setFrobCheck(frobcheck[i]);
				if (elnowgtcheck[i] != null)		model.setElnoWgtCheck(elnowgtcheck[i]);
				if (elnocheck[i] != null)			model.setElNoCheck(elnocheck[i]);

				if (abound[i] != null)				model.setInBound(abound[i]);
				if (avvd[i] != null)				model.setInVvd(avvd[i]);
				if (apol[i] != null)				model.setInPol(apol[i]);
				if (apod[i] != null)				model.setInPod(apod[i]);
				if (apod_tmnl[i] != null)			model.setInPodTmnl(apod_tmnl[i]);
				if (ablno[i] != null)				model.setInBlno(ablno[i]);
				if (amrn_nbr[i] != null)			model.setMrnNbr(amrn_nbr[i]);
				if (ktport[i] != null)				model.setKtPort(ktport[i]);

				if (erchk[i] != null)				model.setErrChk(erchk[i]);
				if (cntrcnt[i] != null)				model.setCntrCnt(cntrcnt[i]);
				if (asel[i] != null)				model.setSel(asel[i]);
				if (abkgsts[i] != null)				model.setBkgsts(abkgsts[i]);

				if(awhouse[i] != null)				model.setWhouse(awhouse[i]);
				if(awhouse_desc[i] != null)				model.setWhouseDesc(awhouse_desc[i]);
				if(abkg_del[i] != null)				model.setBkgDel(abkg_del[i]);
				if(abkg_por[i] != null)				model.setBkgPor(abkg_por[i]);
				if(cBlNo[i] != null)				model.setCBlNo(cBlNo[i]);
				if(cntrNo[i] != null)				model.setCntrNo(cntrNo[i]);
				if(msnBltp[i] != null)				model.setMsnBltp(msnBltp[i]);
				if(vvdCd[i] != null)				model.setVvdCd(vvdCd[i]);
				if(ffordCd[i] != null)				model.setFfordCd(ffordCd[i]);

				if(ibMtyBkgNo[i] != null)			model.setIbMtyBkgNo(ibMtyBkgNo[i]);
				if(ibMtyBlNo[i] != null)			model.setIbMtyBlNo(ibMtyBlNo[i]);
				if(ibTrnsSeq[i] != null)			model.setIbTrnsSeq(ibTrnsSeq[i]);
				if(ibCstmsDeclTpCd[i] != null)		model.setIbCstmsDeclTpCd(ibCstmsDeclTpCd[i]);
				if(ibDmstPortCd[i] != null)			model.setIbDmstPortCd(ibDmstPortCd[i]);
				if(ibVslCd[i] != null)				model.setIbVslCd(ibVslCd[i]);
				if(ibSkdVoyNo[i] != null)			model.setIbSkdVoyNo(ibSkdVoyNo[i]);
				if(ibSkdDirCd[i] != null)			model.setIbSkdDirCd(ibSkdDirCd[i]);
				if(ibEtaDt[i] != null)				model.setIbEtaDt(ibEtaDt[i]);
				if(bacNm[i] != null)				model.setBacNm(bacNm[i]);
				if(dwellDt[i] != null)				model.setDwellDt(dwellDt[i]);
				if(ibVvd[i] != null)				model.setIbVvd(ibVvd[i]);
				if(downYn[i] != null)				model.setDownYn(downYn[i]);
				if(custType[i] != null)				model.setCustType(custType[i]);
				if(roChk[i] != null)				model.setRoChk(roChk[i]);
				if(otherVvd[i] != null)				model.setOtherVvd(otherVvd[i]);
				if(pckQtyChk[i] != null)			model.setPckQtyChk(pckQtyChk[i]);
				if(cntrTtlWgtChk[i] != null)		model.setCntrTtlWgtChk(cntrTtlWgtChk[i]);
				if(measQtyChk[i] != null)			model.setMeasQtyChk(measQtyChk[i]);
				if(pckTpCdChk[i] != null)			model.setPckTpCdChk(pckTpCdChk[i]);
				if(wgtUtCdChk[i] != null)			model.setWgtUtCdChk(wgtUtCdChk[i]);
				if(measUtCdChk[i] != null)			model.setMeasUtCdChk(measUtCdChk[i]);
				if(crsChkRsltFlg[i] != null)		model.setCrsChkRsltFlg(crsChkRsltFlg[i]);
				if(crsChkRmk[i] != null)			model.setCrsChkRmk(crsChkRmk[i]);
				if(mfDlDiffFlg[i] != null)		model.setMfDlDiffFlg(mfDlDiffFlg[i]);
				if(mfSndFlg[i] != null)			model.setMfSndFlg(mfSndFlg[i]);
				if(dmstPortCd[i] != null)			model.setDmstPortCd(dmstPortCd[i]);
				if (selType[i] != null)              model.setSelType(selType[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchManifestInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchManifestInfoVO[]
	 */
	public Kor24ManifestInfoVO[] getSearchManifestInfoVOs(){
		Kor24ManifestInfoVO[] vos = (Kor24ManifestInfoVO[])models.toArray(new Kor24ManifestInfoVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}

	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.ntfyA = this.ntfyA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elnoB = this.elnoB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elnoA = this.elnoA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bz = this.bz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tr = this.tr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tp = this.tp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.correction = this.correction .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtValue = this.wgtValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgCode = this.pkgCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeN = this.cneeN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVvd = this.preVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyN = this.ntfyN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wh = this.wh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgValue = this.pkgValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msn = this.msn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprN = this.shprN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sc = this.sc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bac = this.bac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fe = this.fe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr = this.cntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.descCode = this.descCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg_no = this.bkg_no .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a_bkg_no = this.a_bkg_no .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a_bkg_no_split = this.a_bkg_no_split .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.hidden3 = this.hidden3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm = this.cm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden2 = this.hidden2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden5 = this.hidden5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden6 = this.hidden6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden4 = this.hidden4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtCode = this.wgtCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeA = this.cneeA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprA = this.shprA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden1 = this.hidden1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custName = this.custName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.match = this.match .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.createdType = this.createdType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr_type = this.cntr_type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcd_tp = this.kcd_tp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frob_check = this.frob_check .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elno_wgt_check = this.elno_wgt_check .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elno_check = this.elno_check .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.in_bound = this.in_bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.in_vvd = this.in_vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.in_pol = this.in_pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.in_pod = this.in_pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.in_pod_tmnl = this.in_pod_tmnl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.in_blno = this.in_blno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrn_nbr = this.mrn_nbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kt_port = this.kt_port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errchk = this.errchk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr_cnt = this.cntr_cnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sel = this.sel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgsts = this.bkgsts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.whouse = this.whouse.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whouse_desc = this.whouse_desc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg_del = this.bkg_del.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg_por = this.bkg_por.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cBlNo = this.cBlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msnBltp = this.msnBltp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffordCd = this.ffordCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.downYn = this.downYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custType = this.custType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.roChk = this.roChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otherVvd = this.otherVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQtyChk = this.pckQtyChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTtlWgtChk = this.cntrTtlWgtChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQtyChk = this.measQtyChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCdChk = this.pckTpCdChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCdChk = this.wgtUtCdChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCdChk = this.measUtCdChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crsChkRsltFlg = this.crsChkRsltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crsChkRmk = this.crsChkRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfDlDiffFlg = this.mfDlDiffFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSndFlg = this.mfSndFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmstPortCd = this.dmstPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selType		= this.selType		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
