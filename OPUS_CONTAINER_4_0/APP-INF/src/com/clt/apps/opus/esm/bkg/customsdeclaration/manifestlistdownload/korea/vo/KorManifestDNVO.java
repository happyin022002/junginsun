/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManifestDNVO.java
*@FileTitle : KorManifestDNVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.11  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class KorManifestDNVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorManifestDNVO> models = new ArrayList<KorManifestDNVO>();
	
	/* Column Info */
	private String ntfyA = null;
	/* Column Info */
	private String elnoB = null;
	/* Column Info */
	private String elnoA = null;
	/* Column Info */
	private String vvdPol = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String bkgPor = null;
	/* Column Info */
	private String vvdPod = null;
	/* Column Info */
	private String pkgCode = null;
	/* Column Info */
	private String desc1 = null;
	/* Column Info */
	private String desc2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String aBkgNoSplit = null;
	/* Column Info */
	private String bkgPol = null;
	/* Column Info */
	private String username = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String bkgPod = null;
	/* Column Info */
	private String msnBltp = null;
	/* Column Info */
	private String ntfyN = null;
	/* Column Info */
	private String ktPort = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String bkgCgoTp = null;
	/* Column Info */
	private String wh = null;
	/* Column Info */
	private String vvdPodTmnlCd = null;
	/* Column Info */
	private String bondAreaCode = null;
	/* Column Info */
	private String ibSkdVoyNo = null;
	/* Column Info */
	private String bac = null;
	/* Column Info */
	private String ibCstmsDeclTpCd = null;
	/* Column Info */
	private String ibMtyBlNo = null;
	/* Column Info */
	private String bkgMeaTp = null;
	/* Column Info */
	private String bkgNo = null;
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
	private String hidden1 = null;
	/* Column Info */
	private String custName = null;
	/* Column Info */
	private String ibSkdDirCd = null;
	/* Column Info */
	private String bkgActwgtQty = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String pkgValue = null;
	/* Column Info */
	private String vvdPolTmnlCd = null;
	/* Column Info */
	private String bkgDel = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String fe = null;
	/* Column Info */
	private String cntr = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String bkgPkgQty = null;
	/* Column Info */
	private String ibVslCd = null;
	/* Column Info */
	private String cmdtRep = null;
	/* Column Info */
	private String whouseDesc = null;
	/* Column Info */
	private String bz = null;
	/* Column Info */
	private String ibEtaDt = null;
	/* Column Info */
	private String tr = null;
	/* Column Info */
	private String tp = null;
	/* Column Info */
	private String wgtValue = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cneeN = null;
	/* Column Info */
	private String ktSeq = null;
	/* Column Info */
	private String usBound = null;
	/* Column Info */
	private String preVvd = null;
	/* Column Info */
	private String bkgActwgtTp = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String msnNbr = null;
	/* Column Info */
	private String msn = null;
	/* Column Info */
	private String ffordCd = null;
	/* Column Info */
	private String whouse = null;
	/* Column Info */
	private String sc = null;
	/* Column Info */
	private String exptKcdTp = null;
	/* Column Info */
	private String createdType = null;
	/* Column Info */
	private String descCode = null;
	/* Column Info */
	private String cm = null;
	/* Column Info */
	private String ibTrnsSeq = null;
	/* Column Info */
	private String cneeA = null;
	/* Column Info */
	private String aImoClass1 = null;
	/* Column Info */
	private String match = null;
	/* Column Info */
	private String aImoClass2 = null;
	/* Column Info */
	private String aImoClass3 = null;
	/* Column Info */
	private String ktSts = null;
	/* Column Info */
	private String correction = null;
	/* Column Info */
	private String kcdTp = null;
	/* Column Info */
	private String bkgMeaQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgPkgCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String ibDmstPortCd = null;
	/* Column Info */
	private String aBkgNo = null;
	/* Column Info */
	private String selType = null;
	/* Column Info */
	private String shprN = null;
	/* Column Info */
	private String whdesc = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String ibMtyBkgNo = null;
	/* Column Info */
	private String shprA = null;
	/* Column Info */
	private String cBlNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public KorManifestDNVO() {}

	public KorManifestDNVO(String ibflag, String pagerows, String actWgt, String aBkgNo, String aBkgNoSplit, String aImoClass1, String aImoClass2, String aImoClass3, String bac, String bkgActwgtQty, String bkgActwgtTp, String bkgCgoTp, String bkgDel, String bkgMeaQty, String bkgMeaTp, String bkgNo, String bkgPkgCd, String bkgPkgQty, String bkgPod, String bkgPol, String bkgPor, String blNo, String bondAreaCode, String bz, String cm, String cmdtRep, String cneeA, String cneeN, String cntr, String cntrNo, String correction, String createdType, String custName, String cBlNo, String desc1, String desc2, String descCode, String elnoA, String elnoB, String etaDt, String etdDt, String exptKcdTp, String fe, String ffordCd, String hidden1, String hidden2, String hidden3, String hidden4, String hidden5, String ibCstmsDeclTpCd, String ibDmstPortCd, String ibEtaDt, String ibMtyBkgNo, String ibMtyBlNo, String ibSkdDirCd, String ibSkdVoyNo, String ibTrnsSeq, String ibVslCd, String kcdTp, String ktPort, String ktSeq, String ktSts, String match, String measQty, String measUtCd, String msn, String msnBltp, String msnNbr, String ntfyA, String ntfyN, String pckQty, String pckTpCd, String pkgCode, String pkgValue, String pod, String pol, String preVvd, String sc, String selType, String shprA, String shprN, String tp, String tr, String username, String usBound, String vvdCd, String vvdPod, String vvdPodTmnlCd, String vvdPol, String vvdPolTmnlCd, String wgtCode, String wgtUtCd, String wgtValue, String wh, String whdesc, String whouse, String whouseDesc) {
		this.ntfyA = ntfyA;
		this.elnoB = elnoB;
		this.elnoA = elnoA;
		this.vvdPol = vvdPol;
		this.etaDt = etaDt;
		this.bkgPor = bkgPor;
		this.vvdPod = vvdPod;
		this.pkgCode = pkgCode;
		this.desc1 = desc1;
		this.desc2 = desc2;
		this.pagerows = pagerows;
		this.aBkgNoSplit = aBkgNoSplit;
		this.bkgPol = bkgPol;
		this.username = username;
		this.vvdCd = vvdCd;
		this.pol = pol;
		this.bkgPod = bkgPod;
		this.msnBltp = msnBltp;
		this.ntfyN = ntfyN;
		this.ktPort = ktPort;
		this.pod = pod;
		this.bkgCgoTp = bkgCgoTp;
		this.wh = wh;
		this.vvdPodTmnlCd = vvdPodTmnlCd;
		this.bondAreaCode = bondAreaCode;
		this.ibSkdVoyNo = ibSkdVoyNo;
		this.bac = bac;
		this.ibCstmsDeclTpCd = ibCstmsDeclTpCd;
		this.ibMtyBlNo = ibMtyBlNo;
		this.bkgMeaTp = bkgMeaTp;
		this.bkgNo = bkgNo;
		this.hidden3 = hidden3;
		this.hidden2 = hidden2;
		this.hidden5 = hidden5;
		this.hidden4 = hidden4;
		this.wgtCode = wgtCode;
		this.hidden1 = hidden1;
		this.custName = custName;
		this.ibSkdDirCd = ibSkdDirCd;
		this.bkgActwgtQty = bkgActwgtQty;
		this.measUtCd = measUtCd;
		this.pckTpCd = pckTpCd;
		this.pkgValue = pkgValue;
		this.vvdPolTmnlCd = vvdPolTmnlCd;
		this.bkgDel = bkgDel;
		this.etdDt = etdDt;
		this.fe = fe;
		this.cntr = cntr;
		this.cntrNo = cntrNo;
		this.bkgPkgQty = bkgPkgQty;
		this.ibVslCd = ibVslCd;
		this.cmdtRep = cmdtRep;
		this.whouseDesc = whouseDesc;
		this.bz = bz;
		this.ibEtaDt = ibEtaDt;
		this.tr = tr;
		this.tp = tp;
		this.wgtValue = wgtValue;
		this.blNo = blNo;
		this.cneeN = cneeN;
		this.ktSeq = ktSeq;
		this.usBound = usBound;
		this.preVvd = preVvd;
		this.bkgActwgtTp = bkgActwgtTp;
		this.wgtUtCd = wgtUtCd;
		this.msnNbr = msnNbr;
		this.msn = msn;
		this.ffordCd = ffordCd;
		this.whouse = whouse;
		this.sc = sc;
		this.exptKcdTp = exptKcdTp;
		this.createdType = createdType;
		this.descCode = descCode;
		this.cm = cm;
		this.ibTrnsSeq = ibTrnsSeq;
		this.cneeA = cneeA;
		this.aImoClass1 = aImoClass1;
		this.match = match;
		this.aImoClass2 = aImoClass2;
		this.aImoClass3 = aImoClass3;
		this.ktSts = ktSts;
		this.correction = correction;
		this.kcdTp = kcdTp;
		this.bkgMeaQty = bkgMeaQty;
		this.ibflag = ibflag;
		this.bkgPkgCd = bkgPkgCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.ibDmstPortCd = ibDmstPortCd;
		this.aBkgNo = aBkgNo;
		this.selType = selType;
		this.shprN = shprN;
		this.whdesc = whdesc;
		this.actWgt = actWgt;
		this.ibMtyBkgNo = ibMtyBkgNo;
		this.shprA = shprA;
		this.cBlNo = cBlNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ntfy_a", getNtfyA());
		this.hashColumns.put("elno_b", getElnoB());
		this.hashColumns.put("elno_a", getElnoA());
		this.hashColumns.put("vvd_pol", getVvdPol());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("bkg_por", getBkgPor());
		this.hashColumns.put("vvd_pod", getVvdPod());
		this.hashColumns.put("pkg_code", getPkgCode());
		this.hashColumns.put("desc1", getDesc1());
		this.hashColumns.put("desc2", getDesc2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("a_bkg_no_split", getABkgNoSplit());
		this.hashColumns.put("bkg_pol", getBkgPol());
		this.hashColumns.put("username", getUsername());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("bkg_pod", getBkgPod());
		this.hashColumns.put("msn_bltp", getMsnBltp());
		this.hashColumns.put("ntfy_n", getNtfyN());
		this.hashColumns.put("kt_port", getKtPort());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("bkg_cgo_tp", getBkgCgoTp());
		this.hashColumns.put("wh", getWh());
		this.hashColumns.put("vvd_pod_tmnl_cd", getVvdPodTmnlCd());
		this.hashColumns.put("bond_area_code", getBondAreaCode());
		this.hashColumns.put("ib_skd_voy_no", getIbSkdVoyNo());
		this.hashColumns.put("bac", getBac());
		this.hashColumns.put("ib_cstms_decl_tp_cd", getIbCstmsDeclTpCd());
		this.hashColumns.put("ib_mty_bl_no", getIbMtyBlNo());
		this.hashColumns.put("bkg_mea_tp", getBkgMeaTp());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("hidden3", getHidden3());
		this.hashColumns.put("hidden2", getHidden2());
		this.hashColumns.put("hidden5", getHidden5());
		this.hashColumns.put("hidden4", getHidden4());
		this.hashColumns.put("wgt_code", getWgtCode());
		this.hashColumns.put("hidden1", getHidden1());
		this.hashColumns.put("cust_name", getCustName());
		this.hashColumns.put("ib_skd_dir_cd", getIbSkdDirCd());
		this.hashColumns.put("bkg_actwgt_qty", getBkgActwgtQty());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("pkg_value", getPkgValue());
		this.hashColumns.put("vvd_pol_tmnl_cd", getVvdPolTmnlCd());
		this.hashColumns.put("bkg_del", getBkgDel());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("fe", getFe());
		this.hashColumns.put("cntr", getCntr());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("bkg_pkg_qty", getBkgPkgQty());
		this.hashColumns.put("ib_vsl_cd", getIbVslCd());
		this.hashColumns.put("cmdt_rep", getCmdtRep());
		this.hashColumns.put("whouse_desc", getWhouseDesc());
		this.hashColumns.put("bz", getBz());
		this.hashColumns.put("ib_eta_dt", getIbEtaDt());
		this.hashColumns.put("tr", getTr());
		this.hashColumns.put("tp", getTp());
		this.hashColumns.put("wgt_value", getWgtValue());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cnee_n", getCneeN());
		this.hashColumns.put("kt_seq", getKtSeq());
		this.hashColumns.put("us_bound", getUsBound());
		this.hashColumns.put("pre_vvd", getPreVvd());
		this.hashColumns.put("bkg_actwgt_tp", getBkgActwgtTp());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("msn_nbr", getMsnNbr());
		this.hashColumns.put("msn", getMsn());
		this.hashColumns.put("fford_cd", getFfordCd());
		this.hashColumns.put("whouse", getWhouse());
		this.hashColumns.put("sc", getSc());
		this.hashColumns.put("expt_kcd_tp", getExptKcdTp());
		this.hashColumns.put("created_type", getCreatedType());
		this.hashColumns.put("desc_code", getDescCode());
		this.hashColumns.put("cm", getCm());
		this.hashColumns.put("ib_trns_seq", getIbTrnsSeq());
		this.hashColumns.put("cnee_a", getCneeA());
		this.hashColumns.put("a_imo_class1", getAImoClass1());
		this.hashColumns.put("match", getMatch());
		this.hashColumns.put("a_imo_class2", getAImoClass2());
		this.hashColumns.put("a_imo_class3", getAImoClass3());
		this.hashColumns.put("kt_sts", getKtSts());
		this.hashColumns.put("correction", getCorrection());
		this.hashColumns.put("kcd_tp", getKcdTp());
		this.hashColumns.put("bkg_mea_qty", getBkgMeaQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_pkg_cd", getBkgPkgCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("ib_dmst_port_cd", getIbDmstPortCd());
		this.hashColumns.put("a_bkg_no", getABkgNo());
		this.hashColumns.put("sel_type", getSelType());
		this.hashColumns.put("shpr_n", getShprN());
		this.hashColumns.put("whdesc", getWhdesc());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("ib_mty_bkg_no", getIbMtyBkgNo());
		this.hashColumns.put("shpr_a", getShprA());
		this.hashColumns.put("c_bl_no", getCBlNo());
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
		this.hashFields.put("vvd_pol", "vvdPol");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("bkg_por", "bkgPor");
		this.hashFields.put("vvd_pod", "vvdPod");
		this.hashFields.put("pkg_code", "pkgCode");
		this.hashFields.put("desc1", "desc1");
		this.hashFields.put("desc2", "desc2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("a_bkg_no_split", "aBkgNoSplit");
		this.hashFields.put("bkg_pol", "bkgPol");
		this.hashFields.put("username", "username");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("bkg_pod", "bkgPod");
		this.hashFields.put("msn_bltp", "msnBltp");
		this.hashFields.put("ntfy_n", "ntfyN");
		this.hashFields.put("kt_port", "ktPort");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("bkg_cgo_tp", "bkgCgoTp");
		this.hashFields.put("wh", "wh");
		this.hashFields.put("vvd_pod_tmnl_cd", "vvdPodTmnlCd");
		this.hashFields.put("bond_area_code", "bondAreaCode");
		this.hashFields.put("ib_skd_voy_no", "ibSkdVoyNo");
		this.hashFields.put("bac", "bac");
		this.hashFields.put("ib_cstms_decl_tp_cd", "ibCstmsDeclTpCd");
		this.hashFields.put("ib_mty_bl_no", "ibMtyBlNo");
		this.hashFields.put("bkg_mea_tp", "bkgMeaTp");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("hidden3", "hidden3");
		this.hashFields.put("hidden2", "hidden2");
		this.hashFields.put("hidden5", "hidden5");
		this.hashFields.put("hidden4", "hidden4");
		this.hashFields.put("wgt_code", "wgtCode");
		this.hashFields.put("hidden1", "hidden1");
		this.hashFields.put("cust_name", "custName");
		this.hashFields.put("ib_skd_dir_cd", "ibSkdDirCd");
		this.hashFields.put("bkg_actwgt_qty", "bkgActwgtQty");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("pkg_value", "pkgValue");
		this.hashFields.put("vvd_pol_tmnl_cd", "vvdPolTmnlCd");
		this.hashFields.put("bkg_del", "bkgDel");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("fe", "fe");
		this.hashFields.put("cntr", "cntr");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bkg_pkg_qty", "bkgPkgQty");
		this.hashFields.put("ib_vsl_cd", "ibVslCd");
		this.hashFields.put("cmdt_rep", "cmdtRep");
		this.hashFields.put("whouse_desc", "whouseDesc");
		this.hashFields.put("bz", "bz");
		this.hashFields.put("ib_eta_dt", "ibEtaDt");
		this.hashFields.put("tr", "tr");
		this.hashFields.put("tp", "tp");
		this.hashFields.put("wgt_value", "wgtValue");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cnee_n", "cneeN");
		this.hashFields.put("kt_seq", "ktSeq");
		this.hashFields.put("us_bound", "usBound");
		this.hashFields.put("pre_vvd", "preVvd");
		this.hashFields.put("bkg_actwgt_tp", "bkgActwgtTp");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("msn_nbr", "msnNbr");
		this.hashFields.put("msn", "msn");
		this.hashFields.put("fford_cd", "ffordCd");
		this.hashFields.put("whouse", "whouse");
		this.hashFields.put("sc", "sc");
		this.hashFields.put("expt_kcd_tp", "exptKcdTp");
		this.hashFields.put("created_type", "createdType");
		this.hashFields.put("desc_code", "descCode");
		this.hashFields.put("cm", "cm");
		this.hashFields.put("ib_trns_seq", "ibTrnsSeq");
		this.hashFields.put("cnee_a", "cneeA");
		this.hashFields.put("a_imo_class1", "aImoClass1");
		this.hashFields.put("match", "match");
		this.hashFields.put("a_imo_class2", "aImoClass2");
		this.hashFields.put("a_imo_class3", "aImoClass3");
		this.hashFields.put("kt_sts", "ktSts");
		this.hashFields.put("correction", "correction");
		this.hashFields.put("kcd_tp", "kcdTp");
		this.hashFields.put("bkg_mea_qty", "bkgMeaQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_pkg_cd", "bkgPkgCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("ib_dmst_port_cd", "ibDmstPortCd");
		this.hashFields.put("a_bkg_no", "aBkgNo");
		this.hashFields.put("sel_type", "selType");
		this.hashFields.put("shpr_n", "shprN");
		this.hashFields.put("whdesc", "whdesc");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("ib_mty_bkg_no", "ibMtyBkgNo");
		this.hashFields.put("shpr_a", "shprA");
		this.hashFields.put("c_bl_no", "cBlNo");
		return this.hashFields;
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
	 * @return vvdPol
	 */
	public String getVvdPol() {
		return this.vvdPol;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
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
	 * @return vvdPod
	 */
	public String getVvdPod() {
		return this.vvdPod;
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
	 * @return desc1
	 */
	public String getDesc1() {
		return this.desc1;
	}
	
	/**
	 * Column Info
	 * @return desc2
	 */
	public String getDesc2() {
		return this.desc2;
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
	 * @return aBkgNoSplit
	 */
	public String getABkgNoSplit() {
		return this.aBkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @return bkgPol
	 */
	public String getBkgPol() {
		return this.bkgPol;
	}
	
	/**
	 * Column Info
	 * @return username
	 */
	public String getUsername() {
		return this.username;
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
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return bkgPod
	 */
	public String getBkgPod() {
		return this.bkgPod;
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
	 * @return ktPort
	 */
	public String getKtPort() {
		return this.ktPort;
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
	 * @return bkgCgoTp
	 */
	public String getBkgCgoTp() {
		return this.bkgCgoTp;
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
	 * @return vvdPodTmnlCd
	 */
	public String getVvdPodTmnlCd() {
		return this.vvdPodTmnlCd;
	}
	
	/**
	 * Column Info
	 * @return bondAreaCode
	 */
	public String getBondAreaCode() {
		return this.bondAreaCode;
	}
	
	/**
	 * Column Info
	 * @return ibSkdVoyNo
	 */
	public String getIbSkdVoyNo() {
		return this.ibSkdVoyNo;
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
	 * @return ibCstmsDeclTpCd
	 */
	public String getIbCstmsDeclTpCd() {
		return this.ibCstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @return ibMtyBlNo
	 */
	public String getIbMtyBlNo() {
		return this.ibMtyBlNo;
	}
	
	/**
	 * Column Info
	 * @return bkgMeaTp
	 */
	public String getBkgMeaTp() {
		return this.bkgMeaTp;
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
	 * @return ibSkdDirCd
	 */
	public String getIbSkdDirCd() {
		return this.ibSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return bkgActwgtQty
	 */
	public String getBkgActwgtQty() {
		return this.bkgActwgtQty;
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
	 * @return pkgValue
	 */
	public String getPkgValue() {
		return this.pkgValue;
	}
	
	/**
	 * Column Info
	 * @return vvdPolTmnlCd
	 */
	public String getVvdPolTmnlCd() {
		return this.vvdPolTmnlCd;
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
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
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
	 * @return cntr
	 */
	public String getCntr() {
		return this.cntr;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return bkgPkgQty
	 */
	public String getBkgPkgQty() {
		return this.bkgPkgQty;
	}
	
	/**
	 * Column Info
	 * @return ibVslCd
	 */
	public String getIbVslCd() {
		return this.ibVslCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtRep
	 */
	public String getCmdtRep() {
		return this.cmdtRep;
	}
	
	/**
	 * Column Info
	 * @return whouseDesc
	 */
	public String getWhouseDesc() {
		return this.whouseDesc;
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
	 * @return ibEtaDt
	 */
	public String getIbEtaDt() {
		return this.ibEtaDt;
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
	 * @return wgtValue
	 */
	public String getWgtValue() {
		return this.wgtValue;
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
	 * Column Info
	 * @return ktSeq
	 */
	public String getKtSeq() {
		return this.ktSeq;
	}
	
	/**
	 * Column Info
	 * @return usBound
	 */
	public String getUsBound() {
		return this.usBound;
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
	 * @return bkgActwgtTp
	 */
	public String getBkgActwgtTp() {
		return this.bkgActwgtTp;
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
	 * @return msnNbr
	 */
	public String getMsnNbr() {
		return this.msnNbr;
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
	 * @return ffordCd
	 */
	public String getFfordCd() {
		return this.ffordCd;
	}
	
	/**
	 * Column Info
	 * @return whouse
	 */
	public String getWhouse() {
		return this.whouse;
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
	 * @return exptKcdTp
	 */
	public String getExptKcdTp() {
		return this.exptKcdTp;
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
	 * @return ibTrnsSeq
	 */
	public String getIbTrnsSeq() {
		return this.ibTrnsSeq;
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
	 * @return aImoClass1
	 */
	public String getAImoClass1() {
		return this.aImoClass1;
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
	 * @return aImoClass2
	 */
	public String getAImoClass2() {
		return this.aImoClass2;
	}
	
	/**
	 * Column Info
	 * @return aImoClass3
	 */
	public String getAImoClass3() {
		return this.aImoClass3;
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
	 * Column Info
	 * @return kcdTp
	 */
	public String getKcdTp() {
		return this.kcdTp;
	}
	
	/**
	 * Column Info
	 * @return bkgMeaQty
	 */
	public String getBkgMeaQty() {
		return this.bkgMeaQty;
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
	 * @return bkgPkgCd
	 */
	public String getBkgPkgCd() {
		return this.bkgPkgCd;
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
	 * @return ibDmstPortCd
	 */
	public String getIbDmstPortCd() {
		return this.ibDmstPortCd;
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
	 * @return selType
	 */
	public String getSelType() {
		return this.selType;
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
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
	}
	
	/**
	 * Column Info
	 * @return ibMtyBkgNo
	 */
	public String getIbMtyBkgNo() {
		return this.ibMtyBkgNo;
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
	 * @return cBlNo
	 */
	public String getCBlNo() {
		return this.cBlNo;
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
	 * @param vvdPol
	 */
	public void setVvdPol(String vvdPol) {
		this.vvdPol = vvdPol;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
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
	 * @param vvdPod
	 */
	public void setVvdPod(String vvdPod) {
		this.vvdPod = vvdPod;
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
	 * @param desc1
	 */
	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}
	
	/**
	 * Column Info
	 * @param desc2
	 */
	public void setDesc2(String desc2) {
		this.desc2 = desc2;
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
	 * @param aBkgNoSplit
	 */
	public void setABkgNoSplit(String aBkgNoSplit) {
		this.aBkgNoSplit = aBkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @param bkgPol
	 */
	public void setBkgPol(String bkgPol) {
		this.bkgPol = bkgPol;
	}
	
	/**
	 * Column Info
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param bkgPod
	 */
	public void setBkgPod(String bkgPod) {
		this.bkgPod = bkgPod;
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
	 * @param ktPort
	 */
	public void setKtPort(String ktPort) {
		this.ktPort = ktPort;
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
	 * @param bkgCgoTp
	 */
	public void setBkgCgoTp(String bkgCgoTp) {
		this.bkgCgoTp = bkgCgoTp;
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
	 * @param vvdPodTmnlCd
	 */
	public void setVvdPodTmnlCd(String vvdPodTmnlCd) {
		this.vvdPodTmnlCd = vvdPodTmnlCd;
	}
	
	/**
	 * Column Info
	 * @param bondAreaCode
	 */
	public void setBondAreaCode(String bondAreaCode) {
		this.bondAreaCode = bondAreaCode;
	}
	
	/**
	 * Column Info
	 * @param ibSkdVoyNo
	 */
	public void setIbSkdVoyNo(String ibSkdVoyNo) {
		this.ibSkdVoyNo = ibSkdVoyNo;
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
	 * @param ibCstmsDeclTpCd
	 */
	public void setIbCstmsDeclTpCd(String ibCstmsDeclTpCd) {
		this.ibCstmsDeclTpCd = ibCstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @param ibMtyBlNo
	 */
	public void setIbMtyBlNo(String ibMtyBlNo) {
		this.ibMtyBlNo = ibMtyBlNo;
	}
	
	/**
	 * Column Info
	 * @param bkgMeaTp
	 */
	public void setBkgMeaTp(String bkgMeaTp) {
		this.bkgMeaTp = bkgMeaTp;
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
	 * @param ibSkdDirCd
	 */
	public void setIbSkdDirCd(String ibSkdDirCd) {
		this.ibSkdDirCd = ibSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param bkgActwgtQty
	 */
	public void setBkgActwgtQty(String bkgActwgtQty) {
		this.bkgActwgtQty = bkgActwgtQty;
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
	 * @param pkgValue
	 */
	public void setPkgValue(String pkgValue) {
		this.pkgValue = pkgValue;
	}
	
	/**
	 * Column Info
	 * @param vvdPolTmnlCd
	 */
	public void setVvdPolTmnlCd(String vvdPolTmnlCd) {
		this.vvdPolTmnlCd = vvdPolTmnlCd;
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
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
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
	 * @param cntr
	 */
	public void setCntr(String cntr) {
		this.cntr = cntr;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param bkgPkgQty
	 */
	public void setBkgPkgQty(String bkgPkgQty) {
		this.bkgPkgQty = bkgPkgQty;
	}
	
	/**
	 * Column Info
	 * @param ibVslCd
	 */
	public void setIbVslCd(String ibVslCd) {
		this.ibVslCd = ibVslCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtRep
	 */
	public void setCmdtRep(String cmdtRep) {
		this.cmdtRep = cmdtRep;
	}
	
	/**
	 * Column Info
	 * @param whouseDesc
	 */
	public void setWhouseDesc(String whouseDesc) {
		this.whouseDesc = whouseDesc;
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
	 * @param ibEtaDt
	 */
	public void setIbEtaDt(String ibEtaDt) {
		this.ibEtaDt = ibEtaDt;
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
	 * @param wgtValue
	 */
	public void setWgtValue(String wgtValue) {
		this.wgtValue = wgtValue;
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
	 * Column Info
	 * @param ktSeq
	 */
	public void setKtSeq(String ktSeq) {
		this.ktSeq = ktSeq;
	}
	
	/**
	 * Column Info
	 * @param usBound
	 */
	public void setUsBound(String usBound) {
		this.usBound = usBound;
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
	 * @param bkgActwgtTp
	 */
	public void setBkgActwgtTp(String bkgActwgtTp) {
		this.bkgActwgtTp = bkgActwgtTp;
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
	 * @param msnNbr
	 */
	public void setMsnNbr(String msnNbr) {
		this.msnNbr = msnNbr;
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
	 * @param ffordCd
	 */
	public void setFfordCd(String ffordCd) {
		this.ffordCd = ffordCd;
	}
	
	/**
	 * Column Info
	 * @param whouse
	 */
	public void setWhouse(String whouse) {
		this.whouse = whouse;
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
	 * @param exptKcdTp
	 */
	public void setExptKcdTp(String exptKcdTp) {
		this.exptKcdTp = exptKcdTp;
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
	 * @param ibTrnsSeq
	 */
	public void setIbTrnsSeq(String ibTrnsSeq) {
		this.ibTrnsSeq = ibTrnsSeq;
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
	 * @param aImoClass1
	 */
	public void setAImoClass1(String aImoClass1) {
		this.aImoClass1 = aImoClass1;
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
	 * @param aImoClass2
	 */
	public void setAImoClass2(String aImoClass2) {
		this.aImoClass2 = aImoClass2;
	}
	
	/**
	 * Column Info
	 * @param aImoClass3
	 */
	public void setAImoClass3(String aImoClass3) {
		this.aImoClass3 = aImoClass3;
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
	 * Column Info
	 * @param kcdTp
	 */
	public void setKcdTp(String kcdTp) {
		this.kcdTp = kcdTp;
	}
	
	/**
	 * Column Info
	 * @param bkgMeaQty
	 */
	public void setBkgMeaQty(String bkgMeaQty) {
		this.bkgMeaQty = bkgMeaQty;
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
	 * @param bkgPkgCd
	 */
	public void setBkgPkgCd(String bkgPkgCd) {
		this.bkgPkgCd = bkgPkgCd;
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
	 * @param ibDmstPortCd
	 */
	public void setIbDmstPortCd(String ibDmstPortCd) {
		this.ibDmstPortCd = ibDmstPortCd;
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
	 * @param selType
	 */
	public void setSelType(String selType) {
		this.selType = selType;
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
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
	}
	
	/**
	 * Column Info
	 * @param ibMtyBkgNo
	 */
	public void setIbMtyBkgNo(String ibMtyBkgNo) {
		this.ibMtyBkgNo = ibMtyBkgNo;
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
	 * @param cBlNo
	 */
	public void setCBlNo(String cBlNo) {
		this.cBlNo = cBlNo;
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
		setNtfyA(JSPUtil.getParameter(request, prefix + "ntfy_a", ""));
		setElnoB(JSPUtil.getParameter(request, prefix + "elno_b", ""));
		setElnoA(JSPUtil.getParameter(request, prefix + "elno_a", ""));
		setVvdPol(JSPUtil.getParameter(request, prefix + "vvd_pol", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setBkgPor(JSPUtil.getParameter(request, prefix + "bkg_por", ""));
		setVvdPod(JSPUtil.getParameter(request, prefix + "vvd_pod", ""));
		setPkgCode(JSPUtil.getParameter(request, prefix + "pkg_code", ""));
		setDesc1(JSPUtil.getParameter(request, prefix + "desc1", ""));
		setDesc2(JSPUtil.getParameter(request, prefix + "desc2", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setABkgNoSplit(JSPUtil.getParameter(request, prefix + "a_bkg_no_split", ""));
		setBkgPol(JSPUtil.getParameter(request, prefix + "bkg_pol", ""));
		setUsername(JSPUtil.getParameter(request, prefix + "username", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setBkgPod(JSPUtil.getParameter(request, prefix + "bkg_pod", ""));
		setMsnBltp(JSPUtil.getParameter(request, prefix + "msn_bltp", ""));
		setNtfyN(JSPUtil.getParameter(request, prefix + "ntfy_n", ""));
		setKtPort(JSPUtil.getParameter(request, prefix + "kt_port", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setBkgCgoTp(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp", ""));
		setWh(JSPUtil.getParameter(request, prefix + "wh", ""));
		setVvdPodTmnlCd(JSPUtil.getParameter(request, prefix + "vvd_pod_tmnl_cd", ""));
		setBondAreaCode(JSPUtil.getParameter(request, prefix + "bond_area_code", ""));
		setIbSkdVoyNo(JSPUtil.getParameter(request, prefix + "ib_skd_voy_no", ""));
		setBac(JSPUtil.getParameter(request, prefix + "bac", ""));
		setIbCstmsDeclTpCd(JSPUtil.getParameter(request, prefix + "ib_cstms_decl_tp_cd", ""));
		setIbMtyBlNo(JSPUtil.getParameter(request, prefix + "ib_mty_bl_no", ""));
		setBkgMeaTp(JSPUtil.getParameter(request, prefix + "bkg_mea_tp", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setHidden3(JSPUtil.getParameter(request, prefix + "hidden3", ""));
		setHidden2(JSPUtil.getParameter(request, prefix + "hidden2", ""));
		setHidden5(JSPUtil.getParameter(request, prefix + "hidden5", ""));
		setHidden4(JSPUtil.getParameter(request, prefix + "hidden4", ""));
		setWgtCode(JSPUtil.getParameter(request, prefix + "wgt_code", ""));
		setHidden1(JSPUtil.getParameter(request, prefix + "hidden1", ""));
		setCustName(JSPUtil.getParameter(request, prefix + "cust_name", ""));
		setIbSkdDirCd(JSPUtil.getParameter(request, prefix + "ib_skd_dir_cd", ""));
		setBkgActwgtQty(JSPUtil.getParameter(request, prefix + "bkg_actwgt_qty", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setPkgValue(JSPUtil.getParameter(request, prefix + "pkg_value", ""));
		setVvdPolTmnlCd(JSPUtil.getParameter(request, prefix + "vvd_pol_tmnl_cd", ""));
		setBkgDel(JSPUtil.getParameter(request, prefix + "bkg_del", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setFe(JSPUtil.getParameter(request, prefix + "fe", ""));
		setCntr(JSPUtil.getParameter(request, prefix + "cntr", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setBkgPkgQty(JSPUtil.getParameter(request, prefix + "bkg_pkg_qty", ""));
		setIbVslCd(JSPUtil.getParameter(request, prefix + "ib_vsl_cd", ""));
		setCmdtRep(JSPUtil.getParameter(request, prefix + "cmdt_rep", ""));
		setWhouseDesc(JSPUtil.getParameter(request, prefix + "whouse_desc", ""));
		setBz(JSPUtil.getParameter(request, prefix + "bz", ""));
		setIbEtaDt(JSPUtil.getParameter(request, prefix + "ib_eta_dt", ""));
		setTr(JSPUtil.getParameter(request, prefix + "tr", ""));
		setTp(JSPUtil.getParameter(request, prefix + "tp", ""));
		setWgtValue(JSPUtil.getParameter(request, prefix + "wgt_value", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCneeN(JSPUtil.getParameter(request, prefix + "cnee_n", ""));
		setKtSeq(JSPUtil.getParameter(request, prefix + "kt_seq", ""));
		setUsBound(JSPUtil.getParameter(request, prefix + "us_bound", ""));
		setPreVvd(JSPUtil.getParameter(request, prefix + "pre_vvd", ""));
		setBkgActwgtTp(JSPUtil.getParameter(request, prefix + "bkg_actwgt_tp", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setMsnNbr(JSPUtil.getParameter(request, prefix + "msn_nbr", ""));
		setMsn(JSPUtil.getParameter(request, prefix + "msn", ""));
		setFfordCd(JSPUtil.getParameter(request, prefix + "fford_cd", ""));
		setWhouse(JSPUtil.getParameter(request, prefix + "whouse", ""));
		setSc(JSPUtil.getParameter(request, prefix + "sc", ""));
		setExptKcdTp(JSPUtil.getParameter(request, prefix + "expt_kcd_tp", ""));
		setCreatedType(JSPUtil.getParameter(request, prefix + "created_type", ""));
		setDescCode(JSPUtil.getParameter(request, prefix + "desc_code", ""));
		setCm(JSPUtil.getParameter(request, prefix + "cm", ""));
		setIbTrnsSeq(JSPUtil.getParameter(request, prefix + "ib_trns_seq", ""));
		setCneeA(JSPUtil.getParameter(request, prefix + "cnee_a", ""));
		setAImoClass1(JSPUtil.getParameter(request, prefix + "a_imo_class1", ""));
		setMatch(JSPUtil.getParameter(request, prefix + "match", ""));
		setAImoClass2(JSPUtil.getParameter(request, prefix + "a_imo_class2", ""));
		setAImoClass3(JSPUtil.getParameter(request, prefix + "a_imo_class3", ""));
		setKtSts(JSPUtil.getParameter(request, prefix + "kt_sts", ""));
		setCorrection(JSPUtil.getParameter(request, prefix + "correction", ""));
		setKcdTp(JSPUtil.getParameter(request, prefix + "kcd_tp", ""));
		setBkgMeaQty(JSPUtil.getParameter(request, prefix + "bkg_mea_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgPkgCd(JSPUtil.getParameter(request, prefix + "bkg_pkg_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setIbDmstPortCd(JSPUtil.getParameter(request, prefix + "ib_dmst_port_cd", ""));
		setABkgNo(JSPUtil.getParameter(request, prefix + "a_bkg_no", ""));
		setSelType(JSPUtil.getParameter(request, prefix + "sel_type", ""));
		setShprN(JSPUtil.getParameter(request, prefix + "shpr_n", ""));
		setWhdesc(JSPUtil.getParameter(request, prefix + "whdesc", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setIbMtyBkgNo(JSPUtil.getParameter(request, prefix + "ib_mty_bkg_no", ""));
		setShprA(JSPUtil.getParameter(request, prefix + "shpr_a", ""));
		setCBlNo(JSPUtil.getParameter(request, prefix + "c_bl_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorManifestDNVO[]
	 */
	public KorManifestDNVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorManifestDNVO[]
	 */
	public KorManifestDNVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorManifestDNVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ntfyA = (JSPUtil.getParameter(request, prefix	+ "ntfy_a", length));
			String[] elnoB = (JSPUtil.getParameter(request, prefix	+ "elno_b", length));
			String[] elnoA = (JSPUtil.getParameter(request, prefix	+ "elno_a", length));
			String[] vvdPol = (JSPUtil.getParameter(request, prefix	+ "vvd_pol", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] bkgPor = (JSPUtil.getParameter(request, prefix	+ "bkg_por", length));
			String[] vvdPod = (JSPUtil.getParameter(request, prefix	+ "vvd_pod", length));
			String[] pkgCode = (JSPUtil.getParameter(request, prefix	+ "pkg_code", length));
			String[] desc1 = (JSPUtil.getParameter(request, prefix	+ "desc1", length));
			String[] desc2 = (JSPUtil.getParameter(request, prefix	+ "desc2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] aBkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "a_bkg_no_split", length));
			String[] bkgPol = (JSPUtil.getParameter(request, prefix	+ "bkg_pol", length));
			String[] username = (JSPUtil.getParameter(request, prefix	+ "username", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] bkgPod = (JSPUtil.getParameter(request, prefix	+ "bkg_pod", length));
			String[] msnBltp = (JSPUtil.getParameter(request, prefix	+ "msn_bltp", length));
			String[] ntfyN = (JSPUtil.getParameter(request, prefix	+ "ntfy_n", length));
			String[] ktPort = (JSPUtil.getParameter(request, prefix	+ "kt_port", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] bkgCgoTp = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp", length));
			String[] wh = (JSPUtil.getParameter(request, prefix	+ "wh", length));
			String[] vvdPodTmnlCd = (JSPUtil.getParameter(request, prefix	+ "vvd_pod_tmnl_cd", length));
			String[] bondAreaCode = (JSPUtil.getParameter(request, prefix	+ "bond_area_code", length));
			String[] ibSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "ib_skd_voy_no", length));
			String[] bac = (JSPUtil.getParameter(request, prefix	+ "bac", length));
			String[] ibCstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "ib_cstms_decl_tp_cd", length));
			String[] ibMtyBlNo = (JSPUtil.getParameter(request, prefix	+ "ib_mty_bl_no", length));
			String[] bkgMeaTp = (JSPUtil.getParameter(request, prefix	+ "bkg_mea_tp", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] hidden3 = (JSPUtil.getParameter(request, prefix	+ "hidden3", length));
			String[] hidden2 = (JSPUtil.getParameter(request, prefix	+ "hidden2", length));
			String[] hidden5 = (JSPUtil.getParameter(request, prefix	+ "hidden5", length));
			String[] hidden4 = (JSPUtil.getParameter(request, prefix	+ "hidden4", length));
			String[] wgtCode = (JSPUtil.getParameter(request, prefix	+ "wgt_code", length));
			String[] hidden1 = (JSPUtil.getParameter(request, prefix	+ "hidden1", length));
			String[] custName = (JSPUtil.getParameter(request, prefix	+ "cust_name", length));
			String[] ibSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "ib_skd_dir_cd", length));
			String[] bkgActwgtQty = (JSPUtil.getParameter(request, prefix	+ "bkg_actwgt_qty", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] pkgValue = (JSPUtil.getParameter(request, prefix	+ "pkg_value", length));
			String[] vvdPolTmnlCd = (JSPUtil.getParameter(request, prefix	+ "vvd_pol_tmnl_cd", length));
			String[] bkgDel = (JSPUtil.getParameter(request, prefix	+ "bkg_del", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] fe = (JSPUtil.getParameter(request, prefix	+ "fe", length));
			String[] cntr = (JSPUtil.getParameter(request, prefix	+ "cntr", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] bkgPkgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_pkg_qty", length));
			String[] ibVslCd = (JSPUtil.getParameter(request, prefix	+ "ib_vsl_cd", length));
			String[] cmdtRep = (JSPUtil.getParameter(request, prefix	+ "cmdt_rep", length));
			String[] whouseDesc = (JSPUtil.getParameter(request, prefix	+ "whouse_desc", length));
			String[] bz = (JSPUtil.getParameter(request, prefix	+ "bz", length));
			String[] ibEtaDt = (JSPUtil.getParameter(request, prefix	+ "ib_eta_dt", length));
			String[] tr = (JSPUtil.getParameter(request, prefix	+ "tr", length));
			String[] tp = (JSPUtil.getParameter(request, prefix	+ "tp", length));
			String[] wgtValue = (JSPUtil.getParameter(request, prefix	+ "wgt_value", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cneeN = (JSPUtil.getParameter(request, prefix	+ "cnee_n", length));
			String[] ktSeq = (JSPUtil.getParameter(request, prefix	+ "kt_seq", length));
			String[] usBound = (JSPUtil.getParameter(request, prefix	+ "us_bound", length));
			String[] preVvd = (JSPUtil.getParameter(request, prefix	+ "pre_vvd", length));
			String[] bkgActwgtTp = (JSPUtil.getParameter(request, prefix	+ "bkg_actwgt_tp", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] msnNbr = (JSPUtil.getParameter(request, prefix	+ "msn_nbr", length));
			String[] msn = (JSPUtil.getParameter(request, prefix	+ "msn", length));
			String[] ffordCd = (JSPUtil.getParameter(request, prefix	+ "fford_cd", length));
			String[] whouse = (JSPUtil.getParameter(request, prefix	+ "whouse", length));
			String[] sc = (JSPUtil.getParameter(request, prefix	+ "sc", length));
			String[] exptKcdTp = (JSPUtil.getParameter(request, prefix	+ "expt_kcd_tp", length));
			String[] createdType = (JSPUtil.getParameter(request, prefix	+ "created_type", length));
			String[] descCode = (JSPUtil.getParameter(request, prefix	+ "desc_code", length));
			String[] cm = (JSPUtil.getParameter(request, prefix	+ "cm", length));
			String[] ibTrnsSeq = (JSPUtil.getParameter(request, prefix	+ "ib_trns_seq", length));
			String[] cneeA = (JSPUtil.getParameter(request, prefix	+ "cnee_a", length));
			String[] aImoClass1 = (JSPUtil.getParameter(request, prefix	+ "a_imo_class1", length));
			String[] match = (JSPUtil.getParameter(request, prefix	+ "match", length));
			String[] aImoClass2 = (JSPUtil.getParameter(request, prefix	+ "a_imo_class2", length));
			String[] aImoClass3 = (JSPUtil.getParameter(request, prefix	+ "a_imo_class3", length));
			String[] ktSts = (JSPUtil.getParameter(request, prefix	+ "kt_sts", length));
			String[] correction = (JSPUtil.getParameter(request, prefix	+ "correction", length));
			String[] kcdTp = (JSPUtil.getParameter(request, prefix	+ "kcd_tp", length));
			String[] bkgMeaQty = (JSPUtil.getParameter(request, prefix	+ "bkg_mea_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgPkgCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pkg_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] ibDmstPortCd = (JSPUtil.getParameter(request, prefix	+ "ib_dmst_port_cd", length));
			String[] aBkgNo = (JSPUtil.getParameter(request, prefix	+ "a_bkg_no", length));
			String[] selType = (JSPUtil.getParameter(request, prefix	+ "sel_type", length));
			String[] shprN = (JSPUtil.getParameter(request, prefix	+ "shpr_n", length));
			String[] whdesc = (JSPUtil.getParameter(request, prefix	+ "whdesc", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] ibMtyBkgNo = (JSPUtil.getParameter(request, prefix	+ "ib_mty_bkg_no", length));
			String[] shprA = (JSPUtil.getParameter(request, prefix	+ "shpr_a", length));
			String[] cBlNo = (JSPUtil.getParameter(request, prefix	+ "c_bl_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorManifestDNVO();
				if (ntfyA[i] != null)
					model.setNtfyA(ntfyA[i]);
				if (elnoB[i] != null)
					model.setElnoB(elnoB[i]);
				if (elnoA[i] != null)
					model.setElnoA(elnoA[i]);
				if (vvdPol[i] != null)
					model.setVvdPol(vvdPol[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (bkgPor[i] != null)
					model.setBkgPor(bkgPor[i]);
				if (vvdPod[i] != null)
					model.setVvdPod(vvdPod[i]);
				if (pkgCode[i] != null)
					model.setPkgCode(pkgCode[i]);
				if (desc1[i] != null)
					model.setDesc1(desc1[i]);
				if (desc2[i] != null)
					model.setDesc2(desc2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (aBkgNoSplit[i] != null)
					model.setABkgNoSplit(aBkgNoSplit[i]);
				if (bkgPol[i] != null)
					model.setBkgPol(bkgPol[i]);
				if (username[i] != null)
					model.setUsername(username[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (bkgPod[i] != null)
					model.setBkgPod(bkgPod[i]);
				if (msnBltp[i] != null)
					model.setMsnBltp(msnBltp[i]);
				if (ntfyN[i] != null)
					model.setNtfyN(ntfyN[i]);
				if (ktPort[i] != null)
					model.setKtPort(ktPort[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (bkgCgoTp[i] != null)
					model.setBkgCgoTp(bkgCgoTp[i]);
				if (wh[i] != null)
					model.setWh(wh[i]);
				if (vvdPodTmnlCd[i] != null)
					model.setVvdPodTmnlCd(vvdPodTmnlCd[i]);
				if (bondAreaCode[i] != null)
					model.setBondAreaCode(bondAreaCode[i]);
				if (ibSkdVoyNo[i] != null)
					model.setIbSkdVoyNo(ibSkdVoyNo[i]);
				if (bac[i] != null)
					model.setBac(bac[i]);
				if (ibCstmsDeclTpCd[i] != null)
					model.setIbCstmsDeclTpCd(ibCstmsDeclTpCd[i]);
				if (ibMtyBlNo[i] != null)
					model.setIbMtyBlNo(ibMtyBlNo[i]);
				if (bkgMeaTp[i] != null)
					model.setBkgMeaTp(bkgMeaTp[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
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
				if (hidden1[i] != null)
					model.setHidden1(hidden1[i]);
				if (custName[i] != null)
					model.setCustName(custName[i]);
				if (ibSkdDirCd[i] != null)
					model.setIbSkdDirCd(ibSkdDirCd[i]);
				if (bkgActwgtQty[i] != null)
					model.setBkgActwgtQty(bkgActwgtQty[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (pkgValue[i] != null)
					model.setPkgValue(pkgValue[i]);
				if (vvdPolTmnlCd[i] != null)
					model.setVvdPolTmnlCd(vvdPolTmnlCd[i]);
				if (bkgDel[i] != null)
					model.setBkgDel(bkgDel[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (fe[i] != null)
					model.setFe(fe[i]);
				if (cntr[i] != null)
					model.setCntr(cntr[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (bkgPkgQty[i] != null)
					model.setBkgPkgQty(bkgPkgQty[i]);
				if (ibVslCd[i] != null)
					model.setIbVslCd(ibVslCd[i]);
				if (cmdtRep[i] != null)
					model.setCmdtRep(cmdtRep[i]);
				if (whouseDesc[i] != null)
					model.setWhouseDesc(whouseDesc[i]);
				if (bz[i] != null)
					model.setBz(bz[i]);
				if (ibEtaDt[i] != null)
					model.setIbEtaDt(ibEtaDt[i]);
				if (tr[i] != null)
					model.setTr(tr[i]);
				if (tp[i] != null)
					model.setTp(tp[i]);
				if (wgtValue[i] != null)
					model.setWgtValue(wgtValue[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cneeN[i] != null)
					model.setCneeN(cneeN[i]);
				if (ktSeq[i] != null)
					model.setKtSeq(ktSeq[i]);
				if (usBound[i] != null)
					model.setUsBound(usBound[i]);
				if (preVvd[i] != null)
					model.setPreVvd(preVvd[i]);
				if (bkgActwgtTp[i] != null)
					model.setBkgActwgtTp(bkgActwgtTp[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (msnNbr[i] != null)
					model.setMsnNbr(msnNbr[i]);
				if (msn[i] != null)
					model.setMsn(msn[i]);
				if (ffordCd[i] != null)
					model.setFfordCd(ffordCd[i]);
				if (whouse[i] != null)
					model.setWhouse(whouse[i]);
				if (sc[i] != null)
					model.setSc(sc[i]);
				if (exptKcdTp[i] != null)
					model.setExptKcdTp(exptKcdTp[i]);
				if (createdType[i] != null)
					model.setCreatedType(createdType[i]);
				if (descCode[i] != null)
					model.setDescCode(descCode[i]);
				if (cm[i] != null)
					model.setCm(cm[i]);
				if (ibTrnsSeq[i] != null)
					model.setIbTrnsSeq(ibTrnsSeq[i]);
				if (cneeA[i] != null)
					model.setCneeA(cneeA[i]);
				if (aImoClass1[i] != null)
					model.setAImoClass1(aImoClass1[i]);
				if (match[i] != null)
					model.setMatch(match[i]);
				if (aImoClass2[i] != null)
					model.setAImoClass2(aImoClass2[i]);
				if (aImoClass3[i] != null)
					model.setAImoClass3(aImoClass3[i]);
				if (ktSts[i] != null)
					model.setKtSts(ktSts[i]);
				if (correction[i] != null)
					model.setCorrection(correction[i]);
				if (kcdTp[i] != null)
					model.setKcdTp(kcdTp[i]);
				if (bkgMeaQty[i] != null)
					model.setBkgMeaQty(bkgMeaQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgPkgCd[i] != null)
					model.setBkgPkgCd(bkgPkgCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (ibDmstPortCd[i] != null)
					model.setIbDmstPortCd(ibDmstPortCd[i]);
				if (aBkgNo[i] != null)
					model.setABkgNo(aBkgNo[i]);
				if (selType[i] != null)
					model.setSelType(selType[i]);
				if (shprN[i] != null)
					model.setShprN(shprN[i]);
				if (whdesc[i] != null)
					model.setWhdesc(whdesc[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (ibMtyBkgNo[i] != null)
					model.setIbMtyBkgNo(ibMtyBkgNo[i]);
				if (shprA[i] != null)
					model.setShprA(shprA[i]);
				if (cBlNo[i] != null)
					model.setCBlNo(cBlNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorManifestDNVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorManifestDNVO[]
	 */
	public KorManifestDNVO[] getKorManifestDNVOs(){
		KorManifestDNVO[] vos = (KorManifestDNVO[])models.toArray(new KorManifestDNVO[models.size()]);
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
		this.ntfyA = this.ntfyA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elnoB = this.elnoB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elnoA = this.elnoA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPol = this.vvdPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPor = this.bkgPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPod = this.vvdPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgCode = this.pkgCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc1 = this.desc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc2 = this.desc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aBkgNoSplit = this.aBkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPol = this.bkgPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.username = this.username .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPod = this.bkgPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msnBltp = this.msnBltp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyN = this.ntfyN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktPort = this.ktPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTp = this.bkgCgoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wh = this.wh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPodTmnlCd = this.vvdPodTmnlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bondAreaCode = this.bondAreaCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSkdVoyNo = this.ibSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bac = this.bac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCstmsDeclTpCd = this.ibCstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibMtyBlNo = this.ibMtyBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMeaTp = this.bkgMeaTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden3 = this.hidden3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden2 = this.hidden2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden5 = this.hidden5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden4 = this.hidden4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtCode = this.wgtCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden1 = this.hidden1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custName = this.custName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSkdDirCd = this.ibSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgActwgtQty = this.bkgActwgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgValue = this.pkgValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPolTmnlCd = this.vvdPolTmnlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDel = this.bkgDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fe = this.fe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr = this.cntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPkgQty = this.bkgPkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibVslCd = this.ibVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtRep = this.cmdtRep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whouseDesc = this.whouseDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bz = this.bz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibEtaDt = this.ibEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tr = this.tr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tp = this.tp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtValue = this.wgtValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeN = this.cneeN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktSeq = this.ktSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usBound = this.usBound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVvd = this.preVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgActwgtTp = this.bkgActwgtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msnNbr = this.msnNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msn = this.msn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffordCd = this.ffordCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whouse = this.whouse .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sc = this.sc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptKcdTp = this.exptKcdTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.createdType = this.createdType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.descCode = this.descCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm = this.cm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibTrnsSeq = this.ibTrnsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeA = this.cneeA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aImoClass1 = this.aImoClass1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.match = this.match .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aImoClass2 = this.aImoClass2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aImoClass3 = this.aImoClass3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktSts = this.ktSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.correction = this.correction .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcdTp = this.kcdTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMeaQty = this.bkgMeaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPkgCd = this.bkgPkgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibDmstPortCd = this.ibDmstPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aBkgNo = this.aBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selType = this.selType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprN = this.shprN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whdesc = this.whdesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibMtyBkgNo = this.ibMtyBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprA = this.shprA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cBlNo = this.cBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
