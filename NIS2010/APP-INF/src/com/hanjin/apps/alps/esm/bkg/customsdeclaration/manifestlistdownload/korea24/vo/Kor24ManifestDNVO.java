/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24ManifestDNVO.java
*@FileTitle : Kor24ManifestDNVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.06.10 손윤석
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

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

public class Kor24ManifestDNVO extends AbstractValueObject {


	private static final long serialVersionUID = -3109744671757559687L;

	private Collection<Kor24ManifestDNVO> models = new ArrayList<Kor24ManifestDNVO>();

	/* Column Info */
	private String ntfyA = null;
	/* Column Info */
	private String elnoB = null;
	/* Column Info */
	private String elnoA = null;
	/* Column Info */
	private String tr = null;
	/* Column Info */
	private String bz = null;
	/* Column Info */
	private String tp = null;
	/* Column Info */
	private String wgtValue = null;
	/* Column Info */
	private String bkgPor = null;
	/* Column Info */
	private String pkgCode = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cneeN = null;
	/* Column Info */
	private String aBkgNoSplit = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String preVvd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String msnBltp = null;
	/* Column Info */
	private String ntfyN = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String wh = null;
	/* Column Info */
	private String msn = null;
	/* Column Info */
	private String vvdPodTmnlCd = null;
	/* Column Info */
	private String ffordCd = null;
	/* Column Info */
	private String sc = null;
	/* Column Info */
	private String bac = null;
	/* Column Info */
	private String createdType = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String descCode = null;
	/* Column Info */
	private String cm = null;
	/* Column Info */
	private String hidden3 = null;
	/* Column Info */
	private String hidden2 = null;
	/* Column Info */
	private String hidden5 = null;
	/* Column Info */
	private String hidden4 = null;
	/* Column Info */
	private String wgtCode = null;
	/* Column Info */
	private String cneeA = null;
	/* Column Info */
	private String hidden1 = null;
	/* Column Info */
	private String match = null;
	/* Column Info */
	private String custName = null;
	/* Column Info */
	private String ktSts = null;
	/* Column Info */
	private String correction = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String aBkgNo = null;
	/* Column Info */
	private String pkgValue = null;
	/* Column Info */
	private String shprN = null;
	/* Column Info */
	private String whdesc = null;
	/* Column Info */
	private String bkgDel = null;
	/* Column Info */
	private String fe = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String cntr = null;
	/* Column Info */
	private String shprA = null;
	private String a_imo_class1 = null;
	private String a_imo_class2 = null;
	private String a_imo_class3 = null;
	private String expt_kcd_tp = null;
	private String desc1 = null;
	private String desc2 = null;
	private String kt_seq = null;
	private String kcd_tp = null;

	private String bkg_pol = null;
	private String bkg_pod = null;
	private String msn_nbr = null;
	private String vvd_pol = null;
	private String vvd_pod = null;
	private String bkg_pkg_qty = null;
	private String bkgPkgCd = null;
	private String bkg_actwgt_qty = null;
	private String bkg_actwgt_tp = null;
	private String bkg_mea_qty = null;
	private String bkg_mea_tp = null;
	private String bond_area_code = null;
	private String whouse = null;
	private String whouse_desc = null;
	private String username = null;
	private String bkg_cgo_tp = null;
	private String us_bound = null;
	private String kt_port = null;
	private String cmdt_rep = null;
	private String	cntrNo = null;
	private String	cBlNo = null;
	private String etaDt = null;
	private String etdDt = null;
	private String ibMtyBkgNo = null;
	private String ibMtyBlNo = null;
	private String ibTrnsSeq = null;
	private String ibCstmsDeclTpCd = null;
	private String ibDmstPortCd = null;
	private String ibVslCd = null;
	private String ibSkdVoyNo = null;
	private String ibSkdDirCd = null;
	private String	ibEtaDt = null;
	private String	selType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public Kor24ManifestDNVO() {}

	public Kor24ManifestDNVO(String ibflag, String pagerows, String selType, String blNo, String aBkgNo, String aBkgNoSplit, String bkgNo, String msn, String correction, String tp, String fe, String hidden1, String hidden2, String pol, String pod, String pckQty, String pckTpCd, String actWgt, String wgtUtCd, String measQty, String measUtCd, String pkgValue, String pkgCode, String wgtValue, String wgtCode, String match, String preVvd, String shprN, String shprA, String cneeN, String cneeA, String ntfyN, String ntfyA, String cntr, String bac, String wh, String whdesc, String descCode, String tr, String cm, String bz, String elnoA, String elnoB, String sc, String custName, String hidden3, String hidden4, String hidden5, String ktSts, String msnBltp, String vvdCd, String vvdPodTmnlCd, String createdType, String ffordCd, String bkgDel, String bkgPor) {
		this.ntfyA = ntfyA;
		this.elnoB = elnoB;
		this.elnoA = elnoA;
		this.tr = tr;
		this.bz = bz;
		this.tp = tp;
		this.wgtValue = wgtValue;
		this.bkgPor = bkgPor;
		this.pkgCode = pkgCode;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.cneeN = cneeN;
		this.aBkgNoSplit = aBkgNoSplit;
		this.vvdCd = vvdCd;
		this.preVvd = preVvd;
		this.wgtUtCd = wgtUtCd;
		this.pol = pol;
		this.msnBltp = msnBltp;
		this.ntfyN = ntfyN;
		this.pod = pod;
		this.wh = wh;
		this.msn = msn;
		this.vvdPodTmnlCd = vvdPodTmnlCd;
		this.ffordCd = ffordCd;
		this.sc = sc;
		this.bac = bac;
		this.createdType = createdType;
		this.bkgNo = bkgNo;
		this.descCode = descCode;
		this.cm = cm;
		this.hidden3 = hidden3;
		this.hidden2 = hidden2;
		this.hidden5 = hidden5;
		this.hidden4 = hidden4;
		this.wgtCode = wgtCode;
		this.cneeA = cneeA;
		this.hidden1 = hidden1;
		this.match = match;
		this.custName = custName;
		this.ktSts = ktSts;
		this.correction = correction;
		this.ibflag = ibflag;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.measUtCd = measUtCd;
		this.pckTpCd = pckTpCd;
		this.aBkgNo = aBkgNo;
		this.pkgValue = pkgValue;
		this.shprN = shprN;
		this.whdesc = whdesc;
		this.bkgDel = bkgDel;
		this.fe = fe;
		this.actWgt = actWgt;
		this.cntr = cntr;
		this.shprA = shprA;
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
		this.hashColumns.put("tr", getTr());
		this.hashColumns.put("bz", getBz());
		this.hashColumns.put("tp", getTp());
		this.hashColumns.put("wgt_value", getWgtValue());
		this.hashColumns.put("bkg_por", getBkgPor());
		this.hashColumns.put("pkg_code", getPkgCode());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnee_n", getCneeN());
		this.hashColumns.put("a_bkg_no_split", getABkgNoSplit());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("pre_vvd", getPreVvd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("msn_bltp", getMsnBltp());
		this.hashColumns.put("ntfy_n", getNtfyN());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("wh", getWh());
		this.hashColumns.put("msn", getMsn());
		this.hashColumns.put("vvd_pod_tmnl_cd", getVvdPodTmnlCd());
		this.hashColumns.put("fford_cd", getFfordCd());
		this.hashColumns.put("sc", getSc());
		this.hashColumns.put("bac", getBac());
		this.hashColumns.put("created_type", getCreatedType());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("desc_code", getDescCode());
		this.hashColumns.put("cm", getCm());
		this.hashColumns.put("hidden3", getHidden3());
		this.hashColumns.put("hidden2", getHidden2());
		this.hashColumns.put("hidden5", getHidden5());
		this.hashColumns.put("hidden4", getHidden4());
		this.hashColumns.put("wgt_code", getWgtCode());
		this.hashColumns.put("cnee_a", getCneeA());
		this.hashColumns.put("hidden1", getHidden1());
		this.hashColumns.put("match", getMatch());
		this.hashColumns.put("cust_name", getCustName());
		this.hashColumns.put("kt_sts", getKtSts());
		this.hashColumns.put("correction", getCorrection());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("a_bkg_no", getABkgNo());
		this.hashColumns.put("pkg_value", getPkgValue());
		this.hashColumns.put("shpr_n", getShprN());
		this.hashColumns.put("whdesc", getWhdesc());
		this.hashColumns.put("bkg_del", getBkgDel());
		this.hashColumns.put("fe", getFe());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("cntr", getCntr());
		this.hashColumns.put("shpr_a", getShprA());

		this.hashColumns.put("a_imo_class1", getAImoClass1());
		this.hashColumns.put("a_imo_class2", getAImoClass2());
		this.hashColumns.put("a_imo_class3", getAImoClass3());
		this.hashColumns.put("expt_kcd_tp", getExptKcdTp());
		this.hashColumns.put("desc1", getDesc1());
		this.hashColumns.put("desc2", getDesc2());
		this.hashColumns.put("kt_seq", getKtSeq());
		this.hashColumns.put("kcd_tp",getKcdTp());

		this.hashColumns.put("bkg_pol",	getBkgPol());
		this.hashColumns.put("bkg_pod", getBkgPod());
		this.hashColumns.put("msn_nbr", getMsnNbr());
		this.hashColumns.put("vvd_pol", getVvdPol());
		this.hashColumns.put("vvd_pod", getVvdPod());
		this.hashColumns.put("bkg_pkg_qty", getBkgPkgQty());
		this.hashColumns.put("bkg_pkg_cd", getBkgPkgCd());
		this.hashColumns.put("bkg_actwgt_qty", getBkgActwgtQty());
		this.hashColumns.put("bkg_actwgt_tp", getBkgActwgtTp());
		this.hashColumns.put("bkg_mea_qty", getBkgMeaQty());
		this.hashColumns.put("bkg_mea_tp", getBkgMeaTp());
		this.hashColumns.put("bond_area_code", getBondAreaCode());
		this.hashColumns.put("whouse", getWhouse());
		this.hashColumns.put("whouse_desc", getWhouseDesc());
		this.hashColumns.put("username", getUsername());
		this.hashColumns.put("bkg_cgo_tp", getBkgCgoTp());
		this.hashColumns.put("us_bound", getUsBound());
		this.hashColumns.put("kt_port", getKtPort());
		this.hashColumns.put("cmdt_rep", getCmdtRep());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("c_bl_no", getCBlNo());

		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("ib_mty_bkg_no", getIbMtyBkgNo());
		this.hashColumns.put("ib_mty_bl_no", getIbMtyBlNo());
		this.hashColumns.put("ib_trns_seq", getIbTrnsSeq());
		this.hashColumns.put("ib_cstms_decl_tp_cd", getIbCstmsDeclTpCd());
		this.hashColumns.put("ib_dmst_port_cd", getIbDmstPortCd());
		this.hashColumns.put("ib_vsl_cd", getIbVslCd());
		this.hashColumns.put("ib_skd_voy_no", getIbSkdVoyNo());
		this.hashColumns.put("ib_skd_dir_cd", getIbSkdDirCd());
		this.hashColumns.put("ib_eta_dt", getIbEtaDt());
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
		this.hashFields.put("tr", "tr");
		this.hashFields.put("bz", "bz");
		this.hashFields.put("tp", "tp");
		this.hashFields.put("wgt_value", "wgtValue");
		this.hashFields.put("bkg_por", "bkgPor");
		this.hashFields.put("pkg_code", "pkgCode");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnee_n", "cneeN");
		this.hashFields.put("a_bkg_no_split", "aBkgNoSplit");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("pre_vvd", "preVvd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("msn_bltp", "msnBltp");
		this.hashFields.put("ntfy_n", "ntfyN");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("wh", "wh");
		this.hashFields.put("msn", "msn");
		this.hashFields.put("vvd_pod_tmnl_cd", "vvdPodTmnlCd");
		this.hashFields.put("fford_cd", "ffordCd");
		this.hashFields.put("sc", "sc");
		this.hashFields.put("bac", "bac");
		this.hashFields.put("created_type", "createdType");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("desc_code", "descCode");
		this.hashFields.put("cm", "cm");
		this.hashFields.put("hidden3", "hidden3");
		this.hashFields.put("hidden2", "hidden2");
		this.hashFields.put("hidden5", "hidden5");
		this.hashFields.put("hidden4", "hidden4");
		this.hashFields.put("wgt_code", "wgtCode");
		this.hashFields.put("cnee_a", "cneeA");
		this.hashFields.put("hidden1", "hidden1");
		this.hashFields.put("match", "match");
		this.hashFields.put("cust_name", "custName");
		this.hashFields.put("kt_sts", "ktSts");
		this.hashFields.put("correction", "correction");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("a_bkg_no", "aBkgNo");
		this.hashFields.put("pkg_value", "pkgValue");
		this.hashFields.put("shpr_n", "shprN");
		this.hashFields.put("whdesc", "whdesc");
		this.hashFields.put("bkg_del", "bkgDel");
		this.hashFields.put("fe", "fe");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("cntr", "cntr");
		this.hashFields.put("shpr_a", "shprA");

		this.hashFields.put("a_imo_class1", "a_imo_class1");
		this.hashFields.put("a_imo_class2", "a_imo_class2");
		this.hashFields.put("a_imo_class3", "a_imo_class3");
		this.hashFields.put("expt_kcd_tp", "expt_kcd_tp");
		this.hashFields.put("desc1", "desc1");
		this.hashFields.put("desc2", "desc2");
		this.hashFields.put("kt_seq", "kt_seq");
		this.hashFields.put("kcd_tp", "kcd_tp");

		this.hashFields.put("bkg_pol", "bkg_pol");
		this.hashFields.put("bkg_pod", "bkg_pod");
		this.hashFields.put("msn_nbr", "msn_nbr");
		this.hashFields.put("vvd_pol", "vvd_pol");
		this.hashFields.put("vvd_pod", "vvd_pod");
		this.hashFields.put("bkg_pkg_qty", "bkg_pkg_qty");
		this.hashFields.put("bkg_pkg_cd", "bkgPkgCd");
		this.hashFields.put("bkg_actwgt_qty", "bkg_actwgt_qty");
		this.hashFields.put("bkg_actwgt_tp", "bkg_actwgt_tp");
		this.hashFields.put("bkg_mea_qty", "bkg_mea_qty");
		this.hashFields.put("bkg_mea_tp", "bkg_mea_tp");
		this.hashFields.put("bond_area_code", "bond_area_code");
		this.hashFields.put("whouse", "whouse");
		this.hashFields.put("whouse_desc", "whouse_desc");
		this.hashFields.put("username", "username");
		this.hashFields.put("bkg_cgo_tp", "bkg_cgo_tp");
		this.hashFields.put("us_bound", "us_bound");
		this.hashFields.put("kt_port", "kt_port");
		this.hashFields.put("cmdt_rep", "cmdt_rep");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("c_bl_no", "cBlNo");

		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("ib_mty_bkg_no", "ibMtyBkgNo");
		this.hashFields.put("ib_mty_bl_no", "ibMtyBlNo");
		this.hashFields.put("ib_trns_seq", "ibTransSeq");
		this.hashFields.put("ib_cstms_decl_tp_cd", "ibCstmsDeclTpCd");
		this.hashFields.put("ib_dmst_port_cd", "ibDmstPortCd");
		this.hashFields.put("ib_vsl_cd", "ibVslCd");
		this.hashFields.put("ib_skd_voy_no", "ibSkdVoyNo");
		this.hashFields.put("ib_skd_dir_cd", "ibSkdDirCd");
		this.hashFields.put("ib_eta_dt", "ibEtaDt");
		this.hashFields.put("sel_type", "selType");


		return this.hashFields;
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

	public String getEtaDt() {
		return etaDt;
	}

	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}

	public String getEtdDt() {
		return etdDt;
	}

	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
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

	public void setCBlNo(String blNo) {
		cBlNo = blNo;
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
	 * @return tr
	 */
	public String getTr() {
		return this.tr;
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
	 * @return tp
	 */
	public String getTp() {
		return this.tp;
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
	 * @return bkgPor
	 */
	public String getBkgPor() {
		return this.bkgPor;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * @return cneeN
	 */
	public String getCneeN() {
		return this.cneeN;
	}

	/**
	 * Column Info
	 * @return aBkgNoSplit
	 */
	public String getABkgNoSplit() {
		return this.aBkgNoSplit;
	}

	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
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
	 * @return msnBltp
	 */
	public String getMsnBltp() {
		return this.msnBltp;
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
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
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
	 * @return msn
	 */
	public String getMsn() {
		return this.msn;
	}

	/**
	 * Column Info
	 * @return vvdPodTmnlCd
	 */
	public String getVvdPodTmnlCd() {
		return this.vvdPodTmnlCd;
	}

	/**
	 * Column Info
	 * @return ffordCd
	 */
	public String getFfordCd() {
		return this.ffordCd;
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
	 * @return createdType
	 */
	public String getCreatedType() {
		return this.createdType;
	}

	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return cm
	 */
	public String getCm() {
		return this.cm;
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
	 * @return hidden1
	 */
	public String getHidden1() {
		return this.hidden1;
	}

	/**
	 * Column Info
	 * @return match
	 */
	public String getMatch() {
		return this.match;
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
	 * @return ktSts
	 */
	public String getKtSts() {
		return this.ktSts;
	}

	/**
	 * Column Info
	 * @return correction
	 */
	public String getCorrection() {
		return this.correction;
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
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
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
	 * @return aBkgNo
	 */
	public String getABkgNo() {
		return this.aBkgNo;
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
	 * @return shprN
	 */
	public String getShprN() {
		return this.shprN;
	}

	/**
	 * Column Info
	 * @return whdesc
	 */
	public String getWhdesc() {
		return this.whdesc;
	}

	/**
	 * Column Info
	 * @return bkgDel
	 */
	public String getBkgDel() {
		return this.bkgDel;
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
	 * @return shprA
	 */
	public String getShprA() {
		return this.shprA;
	}


	public String getAImoClass1()	{ return this.a_imo_class1;	}
	public String getAImoClass2()	{ return this.a_imo_class2;	}
	public String getAImoClass3()	{ return this.a_imo_class3;	}
	public String getExptKcdTp()	{ return this.expt_kcd_tp;	}
	public String getDesc1()	{ return this.desc1;	}
	public String getDesc2()	{ return this.desc2;	}
	public String getKtSeq()	{	return this.kt_seq;	}
	public String getKcdTp()	{ return this.kcd_tp;	}

	public String getBkgPol	(){	return this.	bkg_pol		;	}
	public String getBkgPod	(){	return this.	bkg_pod		;	}
	public String getMsnNbr	(){	return this.	msn_nbr		;	}
	public String getVvdPol	(){	return this.	vvd_pol		;	}
	public String getVvdPod	(){	return this.	vvd_pod		;	}
	public String getBkgPkgQty	(){	return this.	bkg_pkg_qty	;	}
	public String getBkgPkgCd	(){	return this.	bkgPkgCd	;	}
	public String getBkgActwgtQty	(){	return this.	bkg_actwgt_qty	;	}
	public String getBkgActwgtTp	(){	return this.	bkg_actwgt_tp	;	}
	public String getBkgMeaQty	(){	return this.	bkg_mea_qty	;	}
	public String getBkgMeaTp	(){	return this.	bkg_mea_tp	;	}
	public String getBondAreaCode	(){	return this.	bond_area_code	;	}
	public String getWhouse	(){	return this.	whouse		;	}
	public String getWhouseDesc	(){	return this.	whouse_desc	;	}
	public String getUsername	(){	return this.	username	;	}
	public String getBkgCgoTp	(){	return this.	bkg_cgo_tp	;	}
	public String getUsBound	(){	return this.	us_bound	;	}
	public String getKtPort	(){	return this.	kt_port		;	}
	public String getCmdtRep	(){	return this.	cmdt_rep	;	}

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
	 * @param tr
	 */
	public void setTr(String tr) {
		this.tr = tr;
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
	 * @param tp
	 */
	public void setTp(String tp) {
		this.tp = tp;
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
	 * @param bkgPor
	 */
	public void setBkgPor(String bkgPor) {
		this.bkgPor = bkgPor;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * @param cneeN
	 */
	public void setCneeN(String cneeN) {
		this.cneeN = cneeN;
	}

	/**
	 * Column Info
	 * @param aBkgNoSplit
	 */
	public void setABkgNoSplit(String aBkgNoSplit) {
		this.aBkgNoSplit = aBkgNoSplit;
	}

	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
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
	 * @param msnBltp
	 */
	public void setMsnBltp(String msnBltp) {
		this.msnBltp = msnBltp;
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
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
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
	 * @param msn
	 */
	public void setMsn(String msn) {
		this.msn = msn;
	}

	/**
	 * Column Info
	 * @param vvdPodTmnlCd
	 */
	public void setVvdPodTmnlCd(String vvdPodTmnlCd) {
		this.vvdPodTmnlCd = vvdPodTmnlCd;
	}

	/**
	 * Column Info
	 * @param ffordCd
	 */
	public void setFfordCd(String ffordCd) {
		this.ffordCd = ffordCd;
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
	 * @param createdType
	 */
	public void setCreatedType(String createdType) {
		this.createdType = createdType;
	}

	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param cm
	 */
	public void setCm(String cm) {
		this.cm = cm;
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
	 * @param hidden1
	 */
	public void setHidden1(String hidden1) {
		this.hidden1 = hidden1;
	}

	/**
	 * Column Info
	 * @param match
	 */
	public void setMatch(String match) {
		this.match = match;
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
	 * @param ktSts
	 */
	public void setKtSts(String ktSts) {
		this.ktSts = ktSts;
	}

	/**
	 * Column Info
	 * @param correction
	 */
	public void setCorrection(String correction) {
		this.correction = correction;
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
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
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
	 * @param aBkgNo
	 */
	public void setABkgNo(String aBkgNo) {
		this.aBkgNo = aBkgNo;
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
	 * @param shprN
	 */
	public void setShprN(String shprN) {
		this.shprN = shprN;
	}

	/**
	 * Column Info
	 * @param whdesc
	 */
	public void setWhdesc(String whdesc) {
		this.whdesc = whdesc;
	}

	/**
	 * Column Info
	 * @param bkgDel
	 */
	public void setBkgDel(String bkgDel) {
		this.bkgDel = bkgDel;
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
	 * @param shprA
	 */
	public void setShprA(String shprA) {
		this.shprA = shprA;
	}

	/**
	 * Column Info
	 * @param selType
	 */
	public void setSelType(String selType) {
		this.selType = selType;
	}

	public void setAImoClass1(String p)	{  this.a_imo_class1 = p;	}
	public void setAImoClass2(String p)	{  this.a_imo_class2 = p;	}
	public void setAImoClass3(String p)	{  this.a_imo_class3 = p;	}
	public void setExptKcdTp(String p)	{  this.expt_kcd_tp = p;	}
	public void setDesc1(String p)	{  this.desc1 = p;	}
	public void setDesc2(String p)	{  this.desc2 = p;	}
	public void setKtSeq(String p)	{	this.kt_seq = p;	}
	public void setKcdTp(String p)	{ this.kcd_tp = p;	}

	public void setBkgPol	(String p){	this.bkg_pol		=p;	}
	public void setBkgPod	(String p){	this.bkg_pod		=p;	}
	public void setMsnNbr	(String p){	this.msn_nbr		=p;	}
	public void setVvdPol	(String p){	this.vvd_pol		=p;	}
	public void setVvdPod	(String p){	this.vvd_pod		=p;	}
	public void setBkgPkgQty(String p){	this.bkg_pkg_qty	=p;	}
	public void setBkgPkgCd	(String p){	this.bkgPkgCd	=p;	}
	public void setBkgActwgtQty	(String p){	this.bkg_actwgt_qty	=p;	}
	public void setBkgActwgtTp	(String p){	this.bkg_actwgt_tp	=p;	}
	public void setBkgMeaQty	(String p){	this.bkg_mea_qty	=p;	}
	public void setBkgMeaTp	(String p){	this.	bkg_mea_tp=p;	}
	public void setBondAreaCode	(String p){	this.bond_area_code	=p;	}
	public void setWhouse	(String p){	this.	whouse=p;	}
	public void setWhouseDesc	(String p){	this.whouse_desc	=p;	}
	public void setUsername	(String p){	this.username	=p;	}
	public void setBkgCgoTp	(String p){	this.bkg_cgo_tp	=p;	}
	public void setUsBound	(String p){	this.us_bound	=p;	}
	public void setKtPort	(String p){	this.kt_port		=p;	}
	public void setCmdtRep	(String p){	this.cmdt_rep	=p;	}



	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNtfyA(JSPUtil.getParameter(request, "ntfy_a", ""));
		setElnoB(JSPUtil.getParameter(request, "elno_b", ""));
		setElnoA(JSPUtil.getParameter(request, "elno_a", ""));
		setTr(JSPUtil.getParameter(request, "tr", ""));
		setBz(JSPUtil.getParameter(request, "bz", ""));
		setTp(JSPUtil.getParameter(request, "tp", ""));
		setWgtValue(JSPUtil.getParameter(request, "wgt_value", ""));
		setBkgPor(JSPUtil.getParameter(request, "bkg_por", ""));
		setPkgCode(JSPUtil.getParameter(request, "pkg_code", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCneeN(JSPUtil.getParameter(request, "cnee_n", ""));
		setABkgNoSplit(JSPUtil.getParameter(request, "a_bkg_no_split", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setPreVvd(JSPUtil.getParameter(request, "pre_vvd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setMsnBltp(JSPUtil.getParameter(request, "msn_bltp", ""));
		setNtfyN(JSPUtil.getParameter(request, "ntfy_n", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setWh(JSPUtil.getParameter(request, "wh", ""));
		setMsn(JSPUtil.getParameter(request, "msn", ""));
		setVvdPodTmnlCd(JSPUtil.getParameter(request, "vvd_pod_tmnl_cd", ""));
		setFfordCd(JSPUtil.getParameter(request, "fford_cd", ""));
		setSc(JSPUtil.getParameter(request, "sc", ""));
		setBac(JSPUtil.getParameter(request, "bac", ""));
		setCreatedType(JSPUtil.getParameter(request, "created_type", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setDescCode(JSPUtil.getParameter(request, "desc_code", ""));
		setCm(JSPUtil.getParameter(request, "cm", ""));
		setHidden3(JSPUtil.getParameter(request, "hidden3", ""));
		setHidden2(JSPUtil.getParameter(request, "hidden2", ""));
		setHidden5(JSPUtil.getParameter(request, "hidden5", ""));
		setHidden4(JSPUtil.getParameter(request, "hidden4", ""));
		setWgtCode(JSPUtil.getParameter(request, "wgt_code", ""));
		setCneeA(JSPUtil.getParameter(request, "cnee_a", ""));
		setHidden1(JSPUtil.getParameter(request, "hidden1", ""));
		setMatch(JSPUtil.getParameter(request, "match", ""));
		setCustName(JSPUtil.getParameter(request, "cust_name", ""));
		setKtSts(JSPUtil.getParameter(request, "kt_sts", ""));
		setCorrection(JSPUtil.getParameter(request, "correction", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setMeasUtCd(JSPUtil.getParameter(request, "meas_ut_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setABkgNo(JSPUtil.getParameter(request, "a_bkg_no", ""));
		setPkgValue(JSPUtil.getParameter(request, "pkg_value", ""));
		setShprN(JSPUtil.getParameter(request, "shpr_n", ""));
		setWhdesc(JSPUtil.getParameter(request, "whdesc", ""));
		setBkgDel(JSPUtil.getParameter(request, "bkg_del", ""));
		setFe(JSPUtil.getParameter(request, "fe", ""));
		setActWgt(JSPUtil.getParameter(request, "act_wgt", ""));
		setCntr(JSPUtil.getParameter(request, "cntr", ""));
		setShprA(JSPUtil.getParameter(request, "shpr_a", ""));

		setAImoClass1(JSPUtil.getParameter(request, "a_imo_class1", ""));
		setAImoClass2(JSPUtil.getParameter(request, "a_imo_class2", ""));
		setAImoClass3(JSPUtil.getParameter(request, "a_imo_class3", ""));
		setExptKcdTp(JSPUtil.getParameter(request, "expt_kcd_tp", ""));
		setDesc1(JSPUtil.getParameter(request, "desc1", ""));
		setDesc2(JSPUtil.getParameter(request, "desc2", ""));
		setKtSeq(JSPUtil.getParameter(request, "kt_seq", ""));
		setKcdTp(JSPUtil.getParameter(request, "kcd_tp", ""));

		setBkgPol(JSPUtil.getParameter(request, "bkg_pol", ""));
		setBkgPod(JSPUtil.getParameter(request, "bkg_pod", ""));
		setMsnNbr(JSPUtil.getParameter(request, "msn_nbr", ""));
		setVvdPol(JSPUtil.getParameter(request, "vvd_pol", ""));
		setVvdPod(JSPUtil.getParameter(request, "vvd_pod", ""));
		setBkgPkgQty(JSPUtil.getParameter(request, "bkg_pkg_qty", ""));
		setBkgPkgCd(JSPUtil.getParameter(request, "bkg_pkg_cd", ""));
		setBkgActwgtQty	(JSPUtil.getParameter(request, "bkg_actwgt_qty", ""));
		setBkgActwgtTp(JSPUtil.getParameter(request, "bkg_actwgt_tp", ""));
		setBkgMeaQty(JSPUtil.getParameter(request, "bkg_mea_qty", ""));
		setBkgMeaTp(JSPUtil.getParameter(request, "bkg_mea_tp", ""));
		setBondAreaCode	(JSPUtil.getParameter(request, "bond_area_code", ""));
		setWhouse(JSPUtil.getParameter(request, "whouse", ""));
		setWhouseDesc(JSPUtil.getParameter(request, "whouse_desc", ""));
		setUsername(JSPUtil.getParameter(request, "username", ""));
		setBkgCgoTp(JSPUtil.getParameter(request, "bkg_cgo_tp", ""));
		setUsBound(JSPUtil.getParameter(request, "us_bound", ""));
		setKtPort(JSPUtil.getParameter(request, "kt_port", ""));
		setCmdtRep(JSPUtil.getParameter(request, "cmdt_rep", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCBlNo(JSPUtil.getParameter(request, "c_bl_no", ""));
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setEtdDt(JSPUtil.getParameter(request, "etd_dt", ""));
		setIbMtyBkgNo(JSPUtil.getParameter(request, "ib_mty_bkg_no", ""));
		setIbMtyBlNo(JSPUtil.getParameter(request, "ib_mty_bl_no", ""));
		setIbTrnsSeq(JSPUtil.getParameter(request, "ib_trns_seq", ""));
		setIbCstmsDeclTpCd(JSPUtil.getParameter(request, "ib_cstms_decl_tp_cd", ""));
		setIbDmstPortCd(JSPUtil.getParameter(request, "ib_dmst_port_cd", ""));
		setIbVslCd(JSPUtil.getParameter(request, "ib_vsl_cd", ""));
		setIbSkdVoyNo(JSPUtil.getParameter(request, "ib_skd_voy_no", ""));
		setIbSkdDirCd(JSPUtil.getParameter(request, "ib_skd_dir_cd", ""));
		setIbEtaDt(JSPUtil.getParameter(request, "ib_eta_dt", ""));
		setSelType(JSPUtil.getParameter(request, "sel_type", ""));



	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Kor24ManifestDNVO[]
	 */
	public Kor24ManifestDNVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return Kor24ManifestDNVO[]
	 */
	public Kor24ManifestDNVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Kor24ManifestDNVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ntfyA = (JSPUtil.getParameter(request, prefix	+ "ntfy_a".trim(), length));
			String[] elnoB = (JSPUtil.getParameter(request, prefix	+ "elno_b".trim(), length));
			String[] elnoA = (JSPUtil.getParameter(request, prefix	+ "elno_a".trim(), length));
			String[] tr = (JSPUtil.getParameter(request, prefix	+ "tr".trim(), length));
			String[] bz = (JSPUtil.getParameter(request, prefix	+ "bz".trim(), length));
			String[] tp = (JSPUtil.getParameter(request, prefix	+ "tp".trim(), length));
			String[] wgtValue = (JSPUtil.getParameter(request, prefix	+ "wgt_value".trim(), length));
			String[] bkgPor = (JSPUtil.getParameter(request, prefix	+ "bkg_por".trim(), length));
			String[] pkgCode = (JSPUtil.getParameter(request, prefix	+ "pkg_code".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] cneeN = (JSPUtil.getParameter(request, prefix	+ "cnee_n".trim(), length));
			String[] aBkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "a_bkg_no_split".trim(), length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd".trim(), length));
			String[] preVvd = (JSPUtil.getParameter(request, prefix	+ "pre_vvd".trim(), length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd".trim(), length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol".trim(), length));
			String[] msnBltp = (JSPUtil.getParameter(request, prefix	+ "msn_bltp".trim(), length));
			String[] ntfyN = (JSPUtil.getParameter(request, prefix	+ "ntfy_n".trim(), length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod".trim(), length));
			String[] wh = (JSPUtil.getParameter(request, prefix	+ "wh".trim(), length));
			String[] msn = (JSPUtil.getParameter(request, prefix	+ "msn".trim(), length));
			String[] vvdPodTmnlCd = (JSPUtil.getParameter(request, prefix	+ "vvd_pod_tmnl_cd".trim(), length));
			String[] ffordCd = (JSPUtil.getParameter(request, prefix	+ "fford_cd".trim(), length));
			String[] sc = (JSPUtil.getParameter(request, prefix	+ "sc".trim(), length));
			String[] bac = (JSPUtil.getParameter(request, prefix	+ "bac".trim(), length));
			String[] createdType = (JSPUtil.getParameter(request, prefix	+ "created_type".trim(), length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no".trim(), length));
			String[] descCode = (JSPUtil.getParameter(request, prefix	+ "desc_code".trim(), length));
			String[] cm = (JSPUtil.getParameter(request, prefix	+ "cm".trim(), length));
			String[] hidden3 = (JSPUtil.getParameter(request, prefix	+ "hidden3".trim(), length));
			String[] hidden2 = (JSPUtil.getParameter(request, prefix	+ "hidden2".trim(), length));
			String[] hidden5 = (JSPUtil.getParameter(request, prefix	+ "hidden5".trim(), length));
			String[] hidden4 = (JSPUtil.getParameter(request, prefix	+ "hidden4".trim(), length));
			String[] wgtCode = (JSPUtil.getParameter(request, prefix	+ "wgt_code".trim(), length));
			String[] cneeA = (JSPUtil.getParameter(request, prefix	+ "cnee_a".trim(), length));
			String[] hidden1 = (JSPUtil.getParameter(request, prefix	+ "hidden1".trim(), length));
			String[] match = (JSPUtil.getParameter(request, prefix	+ "match".trim(), length));
			String[] custName = (JSPUtil.getParameter(request, prefix	+ "cust_name".trim(), length));
			String[] ktSts = (JSPUtil.getParameter(request, prefix	+ "kt_sts".trim(), length));
			String[] correction = (JSPUtil.getParameter(request, prefix	+ "correction".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty".trim(), length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty".trim(), length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd".trim(), length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd".trim(), length));
			String[] aBkgNo = (JSPUtil.getParameter(request, prefix	+ "a_bkg_no".trim(), length));
			String[] pkgValue = (JSPUtil.getParameter(request, prefix	+ "pkg_value".trim(), length));
			String[] shprN = (JSPUtil.getParameter(request, prefix	+ "shpr_n".trim(), length));
			String[] whdesc = (JSPUtil.getParameter(request, prefix	+ "whdesc".trim(), length));
			String[] bkgDel = (JSPUtil.getParameter(request, prefix	+ "bkg_del".trim(), length));
			String[] fe = (JSPUtil.getParameter(request, prefix	+ "fe".trim(), length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt".trim(), length));
			String[] cntr = (JSPUtil.getParameter(request, prefix	+ "cntr".trim(), length));
			String[] shprA = (JSPUtil.getParameter(request, prefix	+ "shpr_a".trim(), length));

			String[] AImoClass1 = (JSPUtil.getParameter(request, prefix	+ "a_imo_class1".trim(), length));
			String[] AImoClass2 = (JSPUtil.getParameter(request, prefix	+ "a_imo_class2".trim(), length));
			String[] AImoClass3 = (JSPUtil.getParameter(request, prefix	+ "a_imo_class3".trim(), length));
			String[] ExptKcdTp = (JSPUtil.getParameter(request, prefix	+ "expt_kcd_tp".trim(), length));
			String[] Desc1 = (JSPUtil.getParameter(request, prefix	+ "desc1".trim(), length));
			String[] Desc2 = (JSPUtil.getParameter(request, prefix	+ "desc2".trim(), length));
			String[] KtSeq = (JSPUtil.getParameter(request, prefix	+ "kt_seq".trim(), length));
			String[] kcdtp = (JSPUtil.getParameter(request, prefix	+ "kcd_tp".trim(), length));

			String[] tbkg_pol	 = (JSPUtil.getParameter(request, prefix	+ "bkg_pol".trim(), length));
			String[] tbkg_pod	 = (JSPUtil.getParameter(request, prefix	+ "bkg_pod".trim(), length));
			String[] tmsn_nbr	 = (JSPUtil.getParameter(request, prefix	+ "msn_nbr".trim(), length));
			String[] tvvd_pol	 = (JSPUtil.getParameter(request, prefix	+ "vvd_pol".trim(), length));
			String[] tvvd_pod	 = (JSPUtil.getParameter(request, prefix	+ "vvd_pod".trim(), length));
			String[] tbkg_pkg_qty	 = (JSPUtil.getParameter(request, prefix	+ "bkg_pkg_qty".trim(), length));
			String[] tbkg_pkg_cd	 = (JSPUtil.getParameter(request, prefix	+ "bkg_pkg_cd".trim(), length));
			String[] tbkg_actwgt_qty = (JSPUtil.getParameter(request, prefix	+ "bkg_actwgt_qty".trim(), length));
			String[] tbkg_actwgt_tp	 = (JSPUtil.getParameter(request, prefix	+ "bkg_actwgt_tp".trim(), length));
			String[] tbkg_mea_qty	 = (JSPUtil.getParameter(request, prefix	+ "bkg_mea_qty".trim(), length));
			String[] tbkg_mea_tp	 = (JSPUtil.getParameter(request, prefix	+ "bkg_mea_tp".trim(), length));
			String[] tbond_area_code = (JSPUtil.getParameter(request, prefix	+ "bond_area_code".trim(), length));
			String[] twhouse	 = (JSPUtil.getParameter(request, prefix	+ "whouse".trim(), length));
			String[] twhouse_desc	 = (JSPUtil.getParameter(request, prefix	+ "whouse_desc".trim(), length));
			String[] tusername	 = (JSPUtil.getParameter(request, prefix	+ "username".trim(), length));
			String[] tbkg_cgo_tp	 = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp".trim(), length));
			String[] tus_bound	 = (JSPUtil.getParameter(request, prefix	+ "us_bound".trim(), length));
			String[] tkt_port	 = (JSPUtil.getParameter(request, prefix	+ "kt_port".trim(), length));
			String[] tcmdt_rep	 = (JSPUtil.getParameter(request, prefix	+ "cmdt_rep".trim(), length));
			String[] cntrNo	 = (JSPUtil.getParameter(request, prefix	+ "cntr_no".trim(), length));
			String[] cBlNo = (JSPUtil.getParameter(request, prefix	+ "c_bl_no".trim(), length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt".trim(), length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt".trim(), length));
			String[] ibMtyBkgNo = (JSPUtil.getParameter(request, prefix	+ "ib_mty_bkg_no".trim(), length));
			String[] ibMtyBlNo = (JSPUtil.getParameter(request, prefix	+ "ib_mty_bl_no".trim(), length));
			String[] ibTrnsSeq = (JSPUtil.getParameter(request, prefix	+ "ib_trns_seq".trim(), length));
			String[] ibCstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "ib_cstms_decl_tp_cd".trim(), length));
			String[] ibDmstPortCd = (JSPUtil.getParameter(request, prefix	+ "ib_dmst_port_cd".trim(), length));
			String[] ibVslCd = (JSPUtil.getParameter(request, prefix	+ "ib_vsl_cd".trim(), length));
			String[] ibSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "ib_skd_voy_no".trim(), length));
			String[] ibSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "ib_skd_dir_cd".trim(), length));
			String[] ibEtaDt = (JSPUtil.getParameter(request, prefix	+ "ib_eta_dt".trim(), length));
			String[] selType = (JSPUtil.getParameter(request, prefix	+ "sel_type".trim(), length));



			for (int i = 0; i < length; i++) {
				model = new Kor24ManifestDNVO();
				if (ntfyA[i] != null)
					model.setNtfyA(ntfyA[i]);
				if (elnoB[i] != null)
					model.setElnoB(elnoB[i]);
				if (elnoA[i] != null)
					model.setElnoA(elnoA[i]);
				if (tr[i] != null)
					model.setTr(tr[i]);
				if (bz[i] != null)
					model.setBz(bz[i]);
				if (tp[i] != null)
					model.setTp(tp[i]);
				if (wgtValue[i] != null)
					model.setWgtValue(wgtValue[i]);
				if (bkgPor[i] != null)
					model.setBkgPor(bkgPor[i]);
				if (pkgCode[i] != null)
					model.setPkgCode(pkgCode[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cneeN[i] != null)
					model.setCneeN(cneeN[i]);
				if (aBkgNoSplit[i] != null)
					model.setABkgNoSplit(aBkgNoSplit[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (preVvd[i] != null)
					model.setPreVvd(preVvd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (msnBltp[i] != null)
					model.setMsnBltp(msnBltp[i]);
				if (ntfyN[i] != null)
					model.setNtfyN(ntfyN[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (wh[i] != null)
					model.setWh(wh[i]);
				if (msn[i] != null)
					model.setMsn(msn[i]);
				if (vvdPodTmnlCd[i] != null)
					model.setVvdPodTmnlCd(vvdPodTmnlCd[i]);
				if (ffordCd[i] != null)
					model.setFfordCd(ffordCd[i]);
				if (sc[i] != null)
					model.setSc(sc[i]);
				if (bac[i] != null)
					model.setBac(bac[i]);
				if (createdType[i] != null)
					model.setCreatedType(createdType[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (descCode[i] != null)
					model.setDescCode(descCode[i]);
				if (cm[i] != null)
					model.setCm(cm[i]);
				if (hidden3[i] != null)
					model.setHidden3(hidden3[i]);
				if (hidden2[i] != null)
					model.setHidden2(hidden2[i]);
				if (hidden5[i] != null)
					model.setHidden5(hidden5[i]);
				if (hidden4[i] != null)
					model.setHidden4(hidden4[i]);
				if (wgtCode[i] != null)
					model.setWgtCode(wgtCode[i]);
				if (cneeA[i] != null)
					model.setCneeA(cneeA[i]);
				if (hidden1[i] != null)
					model.setHidden1(hidden1[i]);
				if (match[i] != null)
					model.setMatch(match[i]);
				if (custName[i] != null)
					model.setCustName(custName[i]);
				if (ktSts[i] != null)
					model.setKtSts(ktSts[i]);
				if (correction[i] != null)
					model.setCorrection(correction[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (aBkgNo[i] != null)
					model.setABkgNo(aBkgNo[i]);
				if (pkgValue[i] != null)
					model.setPkgValue(pkgValue[i]);
				if (shprN[i] != null)
					model.setShprN(shprN[i]);
				if (whdesc[i] != null)
					model.setWhdesc(whdesc[i]);
				if (bkgDel[i] != null)
					model.setBkgDel(bkgDel[i]);
				if (fe[i] != null)
					model.setFe(fe[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (cntr[i] != null)
					model.setCntr(cntr[i]);
				if (shprA[i] != null)
					model.setShprA(shprA[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (selType[i] != null)
					model.setSelType(selType[i]);


				if (cBlNo[i] != null) model.setCBlNo(cBlNo[i]);

				if (etaDt[i] != null) model.setEtaDt(etaDt[i]);
				if (etdDt[i] != null) model.setEtdDt(etdDt[i]);
				if (ibMtyBkgNo[i] != null) model.setIbMtyBkgNo(ibMtyBkgNo[i]);
				if (ibMtyBlNo[i] != null) model.setIbMtyBlNo(ibMtyBlNo[i]);
				if (ibTrnsSeq[i] != null) model.setIbTrnsSeq(ibTrnsSeq[i]);
				if (ibCstmsDeclTpCd[i] != null) model.setIbCstmsDeclTpCd(ibCstmsDeclTpCd[i]);
				if (ibDmstPortCd[i] != null) model.setIbDmstPortCd(ibDmstPortCd[i]);
				if (ibVslCd[i] != null) model.setIbVslCd(ibVslCd[i]);
				if (ibSkdVoyNo[i] != null) model.setIbSkdVoyNo(ibSkdVoyNo[i]);
				if (ibSkdDirCd[i] != null) model.setIbSkdDirCd(ibSkdDirCd[i]);
				if (ibEtaDt[i] != null) model.setIbEtaDt(ibEtaDt[i]);

				if ( AImoClass1[i] != null) model.setAImoClass1(AImoClass1[i]);
				if ( AImoClass2[i] != null) model.setAImoClass2(AImoClass2[i]);
				if ( AImoClass3[i] != null) model.setAImoClass3(AImoClass3[i]);
				if ( ExptKcdTp[i] != null) model.setExptKcdTp(ExptKcdTp[i]);
				if ( Desc1[i] != null) model.setDesc1(Desc1[i]);
				if ( Desc2[i] != null) model.setDesc2(Desc1[i]);
				if ( KtSeq[i] != null) model.setKtSeq(KtSeq[i]);
				if ( kcdtp[i] != null) model.setKcdTp(kcdtp[i]);

				if( tbkg_pol[i]		!= null)	model.setBkgPol		(	tbkg_pol[i]	);
				if( tbkg_pod[i]		!= null)	model.setBkgPod	(	tbkg_pod[i]	);
				if( tmsn_nbr[i]		!= null)	model.setMsnNbr	(	tmsn_nbr[i]	);
				if( tvvd_pol[i]		!= null)	model.setVvdPol	(	tvvd_pol[i]	);
				if( tvvd_pod[i]		!= null)	model.setVvdPod	(	tvvd_pod[i]	);
				if( tbkg_pkg_qty[i]	 != null)	model.setBkgPkgQty	(	tbkg_pkg_qty[i]	);
				if( tbkg_pkg_cd[i]	 != null)	model.setBkgPkgCd	(	tbkg_pkg_cd[i]	);
				if( tbkg_actwgt_qty[i]	!= null)	model.setBkgActwgtQty	(	tbkg_actwgt_qty[i]);
				if( tbkg_actwgt_tp[i]	 != null)	model.setBkgActwgtTp	(	tbkg_actwgt_tp[i]);
				if( tbkg_mea_qty[i]	 != null)	model.setBkgMeaQty	(	tbkg_mea_qty[i]	);
				if( tbkg_mea_tp[i]	 != null)	model.setBkgMeaTp	(	tbkg_mea_tp[i]	);
				if( tbond_area_code[i]	!= null)	model.setBondAreaCode	(	tbond_area_code[i]);
				if( twhouse[i]		!= null)	model.setWhouse	(	twhouse[i]	);
				if( twhouse_desc[i]	 != null)	model.setWhouseDesc	(	twhouse_desc[i]	);
				if( tusername[i]	 != null)	model.setUsername	(	tusername[i]	);
				if( tbkg_cgo_tp[i]	 != null)	model.setBkgCgoTp	(	tbkg_cgo_tp[i]	);
				if( tus_bound[i]	 != null)	model.setUsBound	(	tus_bound[i]	);
				if( tkt_port[i]		!= null)	model.setKtPort	(	tkt_port[i]	);
				if( tcmdt_rep[i]	 != null)	model.setCmdtRep	(	tcmdt_rep[i]	);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKor24ManifestDNVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Kor24ManifestDNVO[]
	 */
	public Kor24ManifestDNVO[] getKor24ManifestDNVOs(){
		Kor24ManifestDNVO[] vos = (Kor24ManifestDNVO[])models.toArray(new Kor24ManifestDNVO[models.size()]);
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
		this.tr = this.tr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bz = this.bz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tp = this.tp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtValue = this.wgtValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPor = this.bkgPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgCode = this.pkgCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeN = this.cneeN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aBkgNoSplit = this.aBkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVvd = this.preVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msnBltp = this.msnBltp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyN = this.ntfyN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wh = this.wh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msn = this.msn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPodTmnlCd = this.vvdPodTmnlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffordCd = this.ffordCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sc = this.sc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bac = this.bac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.createdType = this.createdType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.descCode = this.descCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm = this.cm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden3 = this.hidden3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden2 = this.hidden2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden5 = this.hidden5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden4 = this.hidden4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtCode = this.wgtCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeA = this.cneeA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden1 = this.hidden1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.match = this.match .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custName = this.custName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktSts = this.ktSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.correction = this.correction .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aBkgNo = this.aBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgValue = this.pkgValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprN = this.shprN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whdesc = this.whdesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDel = this.bkgDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fe = this.fe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr = this.cntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprA = this.shprA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.a_imo_class1 = this.a_imo_class1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a_imo_class2 = this.a_imo_class2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a_imo_class3 = this.a_imo_class3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expt_kcd_tp = this.expt_kcd_tp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc1 = this.desc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc2 = this.desc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kt_seq = this.kt_seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcd_tp = this.kcd_tp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.bkg_pol		= this.bkg_pol		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg_pod		= this.bkg_pod		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msn_nbr		= this.msn_nbr		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.vvd_pol		= this.vvd_pol		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd_pod		= this.vvd_pod		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg_pkg_qty	= this.bkg_pkg_qty	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPkgCd		= this.bkgPkgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg_actwgt_qty	= this.bkg_actwgt_qty	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg_actwgt_tp	= this.bkg_actwgt_tp	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg_mea_qty	= this.bkg_mea_qty	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg_mea_tp		= this.bkg_mea_tp	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bond_area_code	= this.bond_area_code	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whouse		= this.whouse		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whouse_desc	= this.whouse_desc	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.username		= this.username		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg_cgo_tp		= this.bkg_cgo_tp	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.us_bound		= this.us_bound		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kt_port		= this.kt_port		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdt_rep		= this.cmdt_rep		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo			= this.cntrNo		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cBlNo			= this.cBlNo		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selType		= this.selType		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");


	}
}
