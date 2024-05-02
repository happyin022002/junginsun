/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManifestInfoVO.java
*@FileTitle : KorManifestInfoVO
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

public class KorManifestInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorManifestInfoVO> models = new ArrayList<KorManifestInfoVO>();
	
	/* Column Info */
	private String crsChkRsltFlg = null;
	/* Column Info */
	private String inVvd = null;
	/* Column Info */
	private String ntfyA = null;
	/* Column Info */
	private String elnoB = null;
	/* Column Info */
	private String inPod = null;
	/* Column Info */
	private String elnoA = null;
	/* Column Info */
	private String bkgPor = null;
	/* Column Info */
	private String inPol = null;
	/* Column Info */
	private String elnoWgtCheck = null;
	/* Column Info */
	private String crsChkRmk = null;
	/* Column Info */
	private String pkgCode = null;
	/* Column Info */
	private String mfSndFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dmstPortCd = null;
	/* Column Info */
	private String aBkgNoSplit = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String msnBltp = null;
	/* Column Info */
	private String pckTpCdChk = null;
	/* Column Info */
	private String ntfyN = null;
	/* Column Info */
	private String ktPort = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String wh = null;
	/* Column Info */
	private String measUtCdChk = null;
	/* Column Info */
	private String wgtUtCdChk = null;
	/* Column Info */
	private String ibSkdVoyNo = null;
	/* Column Info */
	private String bac = null;
	/* Column Info */
	private String cntrCnt = null;
	/* Column Info */
	private String ibCstmsDeclTpCd = null;
	/* Column Info */
	private String ibMtyBlNo = null;
	/* Column Info */
	private String hidden6 = null;
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
	private String pckQtyChk = null;
	/* Column Info */
	private String errChk = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String cntrTtlWgtChk = null;
	/* Column Info */
	private String pkgValue = null;
	/* Column Info */
	private String bkgDel = null;
	/* Column Info */
	private String fe = null;
	/* Column Info */
	private String cntrType = null;
	/* Column Info */
	private String cntr = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String mfDlDiffFlg = null;
	/* Column Info */
	private String elNoCheck = null;
	/* Column Info */
	private String downYn = null;
	/* Column Info */
	private String ibVslCd = null;
	/* Column Info */
	private String whouseDesc = null;
	/* Column Info */
	private String ibEtaDt = null;
	/* Column Info */
	private String bz = null;
	/* Column Info */
	private String tr = null;
	/* Column Info */
	private String inBound = null;
	/* Column Info */
	private String tp = null;
	/* Column Info */
	private String wgtValue = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cneeN = null;
	/* Column Info */
	private String preVvd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String ibVvd = null;
	/* Column Info */
	private String inPodTmnl = null;
	/* Column Info */
	private String msn = null;
	/* Column Info */
	private String ffordCd = null;
	/* Column Info */
	private String whouse = null;
	/* Column Info */
	private String sc = null;
	/* Column Info */
	private String inPolTmnl = null;
	/* Column Info */
	private String dwellDt = null;
	/* Column Info */
	private String frobCheck = null;
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
	private String mrnNbr = null;
	/* Column Info */
	private String match = null;
	/* Column Info */
	private String correction = null;
	/* Column Info */
	private String kcdTp = null;
	/* Column Info */
	private String bacNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String roChk = null;
	/* Column Info */
	private String ibDmstPortCd = null;
	/* Column Info */
	private String custType = null;
	/* Column Info */
	private String aBkgNo = null;
	/* Column Info */
	private String otherVvd = null;
	/* Column Info */
	private String selType = null;
	/* Column Info */
	private String shprN = null;
	/* Column Info */
	private String bkgsts = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String ibMtyBkgNo = null;
	/* Column Info */
	private String measQtyChk = null;
	/* Column Info */
	private String shprA = null;
	/* Column Info */
	private String inBlno = null;
	/* Column Info */
	private String sel = null;
	/* Column Info */
	private String cBlNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public KorManifestInfoVO() {}

	public KorManifestInfoVO(String ibflag, String pagerows, String actWgt, String aBkgNo, String aBkgNoSplit, String bac, String bacNm, String bkgsts, String bkgDel, String bkgNo, String bkgPor, String blNo, String bz, String cm, String cneeA, String cneeN, String cntr, String cntrCnt, String cntrNo, String cntrTtlWgtChk, String cntrType, String correction, String createdType, String crsChkRmk, String crsChkRsltFlg, String custName, String custType, String cBlNo, String descCode, String dmstPortCd, String downYn, String dwellDt, String elnoA, String elnoB, String elNoCheck, String elnoWgtCheck, String errChk, String fe, String ffordCd, String frobCheck, String hidden1, String hidden2, String hidden3, String hidden4, String hidden5, String hidden6, String ibCstmsDeclTpCd, String ibDmstPortCd, String ibEtaDt, String ibMtyBkgNo, String ibMtyBlNo, String ibSkdDirCd, String ibSkdVoyNo, String ibTrnsSeq, String ibVslCd, String ibVvd, String inBlno, String inBound, String inPod, String inPodTmnl, String inPol, String inPolTmnl, String inVvd, String kcdTp, String ktPort, String match, String measQty, String measQtyChk, String measUtCd, String measUtCdChk, String mfDlDiffFlg, String mfSndFlg, String mrnNbr, String msn, String msnBltp, String ntfyA, String ntfyN, String otherVvd, String pckQty, String pckQtyChk, String pckTpCd, String pckTpCdChk, String pkgCode, String pkgValue, String pod, String pol, String preVvd, String roChk, String sc, String sel, String selType, String shprA, String shprN, String tp, String tr, String vvdCd, String wgtCode, String wgtUtCd, String wgtUtCdChk, String wgtValue, String wh, String whouse, String whouseDesc) {
		this.crsChkRsltFlg = crsChkRsltFlg;
		this.inVvd = inVvd;
		this.ntfyA = ntfyA;
		this.elnoB = elnoB;
		this.inPod = inPod;
		this.elnoA = elnoA;
		this.bkgPor = bkgPor;
		this.inPol = inPol;
		this.elnoWgtCheck = elnoWgtCheck;
		this.crsChkRmk = crsChkRmk;
		this.pkgCode = pkgCode;
		this.mfSndFlg = mfSndFlg;
		this.pagerows = pagerows;
		this.dmstPortCd = dmstPortCd;
		this.aBkgNoSplit = aBkgNoSplit;
		this.vvdCd = vvdCd;
		this.pol = pol;
		this.msnBltp = msnBltp;
		this.pckTpCdChk = pckTpCdChk;
		this.ntfyN = ntfyN;
		this.ktPort = ktPort;
		this.pod = pod;
		this.wh = wh;
		this.measUtCdChk = measUtCdChk;
		this.wgtUtCdChk = wgtUtCdChk;
		this.ibSkdVoyNo = ibSkdVoyNo;
		this.bac = bac;
		this.cntrCnt = cntrCnt;
		this.ibCstmsDeclTpCd = ibCstmsDeclTpCd;
		this.ibMtyBlNo = ibMtyBlNo;
		this.hidden6 = hidden6;
		this.bkgNo = bkgNo;
		this.hidden3 = hidden3;
		this.hidden2 = hidden2;
		this.hidden5 = hidden5;
		this.hidden4 = hidden4;
		this.wgtCode = wgtCode;
		this.hidden1 = hidden1;
		this.custName = custName;
		this.ibSkdDirCd = ibSkdDirCd;
		this.pckQtyChk = pckQtyChk;
		this.errChk = errChk;
		this.measUtCd = measUtCd;
		this.pckTpCd = pckTpCd;
		this.cntrTtlWgtChk = cntrTtlWgtChk;
		this.pkgValue = pkgValue;
		this.bkgDel = bkgDel;
		this.fe = fe;
		this.cntrType = cntrType;
		this.cntr = cntr;
		this.cntrNo = cntrNo;
		this.mfDlDiffFlg = mfDlDiffFlg;
		this.elNoCheck = elNoCheck;
		this.downYn = downYn;
		this.ibVslCd = ibVslCd;
		this.whouseDesc = whouseDesc;
		this.ibEtaDt = ibEtaDt;
		this.bz = bz;
		this.tr = tr;
		this.inBound = inBound;
		this.tp = tp;
		this.wgtValue = wgtValue;
		this.blNo = blNo;
		this.cneeN = cneeN;
		this.preVvd = preVvd;
		this.wgtUtCd = wgtUtCd;
		this.ibVvd = ibVvd;
		this.inPodTmnl = inPodTmnl;
		this.msn = msn;
		this.ffordCd = ffordCd;
		this.whouse = whouse;
		this.sc = sc;
		this.inPolTmnl = inPolTmnl;
		this.dwellDt = dwellDt;
		this.frobCheck = frobCheck;
		this.createdType = createdType;
		this.descCode = descCode;
		this.cm = cm;
		this.ibTrnsSeq = ibTrnsSeq;
		this.cneeA = cneeA;
		this.mrnNbr = mrnNbr;
		this.match = match;
		this.correction = correction;
		this.kcdTp = kcdTp;
		this.bacNm = bacNm;
		this.ibflag = ibflag;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.roChk = roChk;
		this.ibDmstPortCd = ibDmstPortCd;
		this.custType = custType;
		this.aBkgNo = aBkgNo;
		this.otherVvd = otherVvd;
		this.selType = selType;
		this.shprN = shprN;
		this.bkgsts = bkgsts;
		this.actWgt = actWgt;
		this.ibMtyBkgNo = ibMtyBkgNo;
		this.measQtyChk = measQtyChk;
		this.shprA = shprA;
		this.inBlno = inBlno;
		this.sel = sel;
		this.cBlNo = cBlNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("crs_chk_rslt_flg", getCrsChkRsltFlg());
		this.hashColumns.put("in_vvd", getInVvd());
		this.hashColumns.put("ntfy_a", getNtfyA());
		this.hashColumns.put("elno_b", getElnoB());
		this.hashColumns.put("in_pod", getInPod());
		this.hashColumns.put("elno_a", getElnoA());
		this.hashColumns.put("bkg_por", getBkgPor());
		this.hashColumns.put("in_pol", getInPol());
		this.hashColumns.put("elno_wgt_check", getElnoWgtCheck());
		this.hashColumns.put("crs_chk_rmk", getCrsChkRmk());
		this.hashColumns.put("pkg_code", getPkgCode());
		this.hashColumns.put("mf_snd_flg", getMfSndFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dmst_port_cd", getDmstPortCd());
		this.hashColumns.put("a_bkg_no_split", getABkgNoSplit());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("msn_bltp", getMsnBltp());
		this.hashColumns.put("pck_tp_cd_chk", getPckTpCdChk());
		this.hashColumns.put("ntfy_n", getNtfyN());
		this.hashColumns.put("kt_port", getKtPort());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("wh", getWh());
		this.hashColumns.put("meas_ut_cd_chk", getMeasUtCdChk());
		this.hashColumns.put("wgt_ut_cd_chk", getWgtUtCdChk());
		this.hashColumns.put("ib_skd_voy_no", getIbSkdVoyNo());
		this.hashColumns.put("bac", getBac());
		this.hashColumns.put("cntr_cnt", getCntrCnt());
		this.hashColumns.put("ib_cstms_decl_tp_cd", getIbCstmsDeclTpCd());
		this.hashColumns.put("ib_mty_bl_no", getIbMtyBlNo());
		this.hashColumns.put("hidden6", getHidden6());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("hidden3", getHidden3());
		this.hashColumns.put("hidden2", getHidden2());
		this.hashColumns.put("hidden5", getHidden5());
		this.hashColumns.put("hidden4", getHidden4());
		this.hashColumns.put("wgt_code", getWgtCode());
		this.hashColumns.put("hidden1", getHidden1());
		this.hashColumns.put("cust_name", getCustName());
		this.hashColumns.put("ib_skd_dir_cd", getIbSkdDirCd());
		this.hashColumns.put("pck_qty_chk", getPckQtyChk());
		this.hashColumns.put("err_chk", getErrChk());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("cntr_ttl_wgt_chk", getCntrTtlWgtChk());
		this.hashColumns.put("pkg_value", getPkgValue());
		this.hashColumns.put("bkg_del", getBkgDel());
		this.hashColumns.put("fe", getFe());
		this.hashColumns.put("cntr_type", getCntrType());
		this.hashColumns.put("cntr", getCntr());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("mf_dl_diff_flg", getMfDlDiffFlg());
		this.hashColumns.put("el_no_check", getElNoCheck());
		this.hashColumns.put("down_yn", getDownYn());
		this.hashColumns.put("ib_vsl_cd", getIbVslCd());
		this.hashColumns.put("whouse_desc", getWhouseDesc());
		this.hashColumns.put("ib_eta_dt", getIbEtaDt());
		this.hashColumns.put("bz", getBz());
		this.hashColumns.put("tr", getTr());
		this.hashColumns.put("in_bound", getInBound());
		this.hashColumns.put("tp", getTp());
		this.hashColumns.put("wgt_value", getWgtValue());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cnee_n", getCneeN());
		this.hashColumns.put("pre_vvd", getPreVvd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("ib_vvd", getIbVvd());
		this.hashColumns.put("in_pod_tmnl", getInPodTmnl());
		this.hashColumns.put("msn", getMsn());
		this.hashColumns.put("fford_cd", getFfordCd());
		this.hashColumns.put("whouse", getWhouse());
		this.hashColumns.put("sc", getSc());
		this.hashColumns.put("in_pol_tmnl", getInPolTmnl());
		this.hashColumns.put("dwell_dt", getDwellDt());
		this.hashColumns.put("frob_check", getFrobCheck());
		this.hashColumns.put("created_type", getCreatedType());
		this.hashColumns.put("desc_code", getDescCode());
		this.hashColumns.put("cm", getCm());
		this.hashColumns.put("ib_trns_seq", getIbTrnsSeq());
		this.hashColumns.put("cnee_a", getCneeA());
		this.hashColumns.put("mrn_nbr", getMrnNbr());
		this.hashColumns.put("match", getMatch());
		this.hashColumns.put("correction", getCorrection());
		this.hashColumns.put("kcd_tp", getKcdTp());
		this.hashColumns.put("bac_nm", getBacNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("ro_chk", getRoChk());
		this.hashColumns.put("ib_dmst_port_cd", getIbDmstPortCd());
		this.hashColumns.put("cust_type", getCustType());
		this.hashColumns.put("a_bkg_no", getABkgNo());
		this.hashColumns.put("other_vvd", getOtherVvd());
		this.hashColumns.put("sel_type", getSelType());
		this.hashColumns.put("shpr_n", getShprN());
		this.hashColumns.put("bkgsts", getBkgsts());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("ib_mty_bkg_no", getIbMtyBkgNo());
		this.hashColumns.put("meas_qty_chk", getMeasQtyChk());
		this.hashColumns.put("shpr_a", getShprA());
		this.hashColumns.put("in_blno", getInBlno());
		this.hashColumns.put("sel", getSel());
		this.hashColumns.put("c_bl_no", getCBlNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("crs_chk_rslt_flg", "crsChkRsltFlg");
		this.hashFields.put("in_vvd", "inVvd");
		this.hashFields.put("ntfy_a", "ntfyA");
		this.hashFields.put("elno_b", "elnoB");
		this.hashFields.put("in_pod", "inPod");
		this.hashFields.put("elno_a", "elnoA");
		this.hashFields.put("bkg_por", "bkgPor");
		this.hashFields.put("in_pol", "inPol");
		this.hashFields.put("elno_wgt_check", "elnoWgtCheck");
		this.hashFields.put("crs_chk_rmk", "crsChkRmk");
		this.hashFields.put("pkg_code", "pkgCode");
		this.hashFields.put("mf_snd_flg", "mfSndFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dmst_port_cd", "dmstPortCd");
		this.hashFields.put("a_bkg_no_split", "aBkgNoSplit");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("msn_bltp", "msnBltp");
		this.hashFields.put("pck_tp_cd_chk", "pckTpCdChk");
		this.hashFields.put("ntfy_n", "ntfyN");
		this.hashFields.put("kt_port", "ktPort");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("wh", "wh");
		this.hashFields.put("meas_ut_cd_chk", "measUtCdChk");
		this.hashFields.put("wgt_ut_cd_chk", "wgtUtCdChk");
		this.hashFields.put("ib_skd_voy_no", "ibSkdVoyNo");
		this.hashFields.put("bac", "bac");
		this.hashFields.put("cntr_cnt", "cntrCnt");
		this.hashFields.put("ib_cstms_decl_tp_cd", "ibCstmsDeclTpCd");
		this.hashFields.put("ib_mty_bl_no", "ibMtyBlNo");
		this.hashFields.put("hidden6", "hidden6");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("hidden3", "hidden3");
		this.hashFields.put("hidden2", "hidden2");
		this.hashFields.put("hidden5", "hidden5");
		this.hashFields.put("hidden4", "hidden4");
		this.hashFields.put("wgt_code", "wgtCode");
		this.hashFields.put("hidden1", "hidden1");
		this.hashFields.put("cust_name", "custName");
		this.hashFields.put("ib_skd_dir_cd", "ibSkdDirCd");
		this.hashFields.put("pck_qty_chk", "pckQtyChk");
		this.hashFields.put("err_chk", "errChk");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("cntr_ttl_wgt_chk", "cntrTtlWgtChk");
		this.hashFields.put("pkg_value", "pkgValue");
		this.hashFields.put("bkg_del", "bkgDel");
		this.hashFields.put("fe", "fe");
		this.hashFields.put("cntr_type", "cntrType");
		this.hashFields.put("cntr", "cntr");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("mf_dl_diff_flg", "mfDlDiffFlg");
		this.hashFields.put("el_no_check", "elNoCheck");
		this.hashFields.put("down_yn", "downYn");
		this.hashFields.put("ib_vsl_cd", "ibVslCd");
		this.hashFields.put("whouse_desc", "whouseDesc");
		this.hashFields.put("ib_eta_dt", "ibEtaDt");
		this.hashFields.put("bz", "bz");
		this.hashFields.put("tr", "tr");
		this.hashFields.put("in_bound", "inBound");
		this.hashFields.put("tp", "tp");
		this.hashFields.put("wgt_value", "wgtValue");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cnee_n", "cneeN");
		this.hashFields.put("pre_vvd", "preVvd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("ib_vvd", "ibVvd");
		this.hashFields.put("in_pod_tmnl", "inPodTmnl");
		this.hashFields.put("msn", "msn");
		this.hashFields.put("fford_cd", "ffordCd");
		this.hashFields.put("whouse", "whouse");
		this.hashFields.put("sc", "sc");
		this.hashFields.put("in_pol_tmnl", "inPolTmnl");
		this.hashFields.put("dwell_dt", "dwellDt");
		this.hashFields.put("frob_check", "frobCheck");
		this.hashFields.put("created_type", "createdType");
		this.hashFields.put("desc_code", "descCode");
		this.hashFields.put("cm", "cm");
		this.hashFields.put("ib_trns_seq", "ibTrnsSeq");
		this.hashFields.put("cnee_a", "cneeA");
		this.hashFields.put("mrn_nbr", "mrnNbr");
		this.hashFields.put("match", "match");
		this.hashFields.put("correction", "correction");
		this.hashFields.put("kcd_tp", "kcdTp");
		this.hashFields.put("bac_nm", "bacNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("ro_chk", "roChk");
		this.hashFields.put("ib_dmst_port_cd", "ibDmstPortCd");
		this.hashFields.put("cust_type", "custType");
		this.hashFields.put("a_bkg_no", "aBkgNo");
		this.hashFields.put("other_vvd", "otherVvd");
		this.hashFields.put("sel_type", "selType");
		this.hashFields.put("shpr_n", "shprN");
		this.hashFields.put("bkgsts", "bkgsts");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("ib_mty_bkg_no", "ibMtyBkgNo");
		this.hashFields.put("meas_qty_chk", "measQtyChk");
		this.hashFields.put("shpr_a", "shprA");
		this.hashFields.put("in_blno", "inBlno");
		this.hashFields.put("sel", "sel");
		this.hashFields.put("c_bl_no", "cBlNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return crsChkRsltFlg
	 */
	public String getCrsChkRsltFlg() {
		return this.crsChkRsltFlg;
	}
	
	/**
	 * Column Info
	 * @return inVvd
	 */
	public String getInVvd() {
		return this.inVvd;
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
	 * @return inPod
	 */
	public String getInPod() {
		return this.inPod;
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
	 * @return bkgPor
	 */
	public String getBkgPor() {
		return this.bkgPor;
	}
	
	/**
	 * Column Info
	 * @return inPol
	 */
	public String getInPol() {
		return this.inPol;
	}
	
	/**
	 * Column Info
	 * @return elnoWgtCheck
	 */
	public String getElnoWgtCheck() {
		return this.elnoWgtCheck;
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
	 * @return pkgCode
	 */
	public String getPkgCode() {
		return this.pkgCode;
	}
	
	/**
	 * Column Info
	 * @return mfSndFlg
	 */
	public String getMfSndFlg() {
		return this.mfSndFlg;
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
	 * @return dmstPortCd
	 */
	public String getDmstPortCd() {
		return this.dmstPortCd;
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
	 * @return pckTpCdChk
	 */
	public String getPckTpCdChk() {
		return this.pckTpCdChk;
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
	 * @return wh
	 */
	public String getWh() {
		return this.wh;
	}
	
	/**
	 * Column Info
	 * @return measUtCdChk
	 */
	public String getMeasUtCdChk() {
		return this.measUtCdChk;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCdChk
	 */
	public String getWgtUtCdChk() {
		return this.wgtUtCdChk;
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
	 * @return cntrCnt
	 */
	public String getCntrCnt() {
		return this.cntrCnt;
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
	 * @return hidden6
	 */
	public String getHidden6() {
		return this.hidden6;
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
	 * @return pckQtyChk
	 */
	public String getPckQtyChk() {
		return this.pckQtyChk;
	}
	
	/**
	 * Column Info
	 * @return errChk
	 */
	public String getErrChk() {
		return this.errChk;
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
	 * @return cntrTtlWgtChk
	 */
	public String getCntrTtlWgtChk() {
		return this.cntrTtlWgtChk;
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
	 * @return cntrType
	 */
	public String getCntrType() {
		return this.cntrType;
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
	 * @return mfDlDiffFlg
	 */
	public String getMfDlDiffFlg() {
		return this.mfDlDiffFlg;
	}
	
	/**
	 * Column Info
	 * @return elNoCheck
	 */
	public String getElNoCheck() {
		return this.elNoCheck;
	}
	
	/**
	 * Column Info
	 * @return downYn
	 */
	public String getDownYn() {
		return this.downYn;
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
	 * @return whouseDesc
	 */
	public String getWhouseDesc() {
		return this.whouseDesc;
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
	 * @return inBound
	 */
	public String getInBound() {
		return this.inBound;
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
	 * @return ibVvd
	 */
	public String getIbVvd() {
		return this.ibVvd;
	}
	
	/**
	 * Column Info
	 * @return inPodTmnl
	 */
	public String getInPodTmnl() {
		return this.inPodTmnl;
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
	 * @return inPolTmnl
	 */
	public String getInPolTmnl() {
		return this.inPolTmnl;
	}
	
	/**
	 * Column Info
	 * @return dwellDt
	 */
	public String getDwellDt() {
		return this.dwellDt;
	}
	
	/**
	 * Column Info
	 * @return frobCheck
	 */
	public String getFrobCheck() {
		return this.frobCheck;
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
	 * @return mrnNbr
	 */
	public String getMrnNbr() {
		return this.mrnNbr;
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
	 * @return bacNm
	 */
	public String getBacNm() {
		return this.bacNm;
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
	 * @return roChk
	 */
	public String getRoChk() {
		return this.roChk;
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
	 * @return custType
	 */
	public String getCustType() {
		return this.custType;
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
	 * @return otherVvd
	 */
	public String getOtherVvd() {
		return this.otherVvd;
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
	 * @return bkgsts
	 */
	public String getBkgsts() {
		return this.bkgsts;
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
	 * @return measQtyChk
	 */
	public String getMeasQtyChk() {
		return this.measQtyChk;
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
	 * @return inBlno
	 */
	public String getInBlno() {
		return this.inBlno;
	}
	
	/**
	 * Column Info
	 * @return sel
	 */
	public String getSel() {
		return this.sel;
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
	 * @param crsChkRsltFlg
	 */
	public void setCrsChkRsltFlg(String crsChkRsltFlg) {
		this.crsChkRsltFlg = crsChkRsltFlg;
	}
	
	/**
	 * Column Info
	 * @param inVvd
	 */
	public void setInVvd(String inVvd) {
		this.inVvd = inVvd;
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
	 * @param inPod
	 */
	public void setInPod(String inPod) {
		this.inPod = inPod;
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
	 * @param bkgPor
	 */
	public void setBkgPor(String bkgPor) {
		this.bkgPor = bkgPor;
	}
	
	/**
	 * Column Info
	 * @param inPol
	 */
	public void setInPol(String inPol) {
		this.inPol = inPol;
	}
	
	/**
	 * Column Info
	 * @param elnoWgtCheck
	 */
	public void setElnoWgtCheck(String elnoWgtCheck) {
		this.elnoWgtCheck = elnoWgtCheck;
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
	 * @param pkgCode
	 */
	public void setPkgCode(String pkgCode) {
		this.pkgCode = pkgCode;
	}
	
	/**
	 * Column Info
	 * @param mfSndFlg
	 */
	public void setMfSndFlg(String mfSndFlg) {
		this.mfSndFlg = mfSndFlg;
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
	 * @param dmstPortCd
	 */
	public void setDmstPortCd(String dmstPortCd) {
		this.dmstPortCd = dmstPortCd;
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
	 * @param pckTpCdChk
	 */
	public void setPckTpCdChk(String pckTpCdChk) {
		this.pckTpCdChk = pckTpCdChk;
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
	 * @param wh
	 */
	public void setWh(String wh) {
		this.wh = wh;
	}
	
	/**
	 * Column Info
	 * @param measUtCdChk
	 */
	public void setMeasUtCdChk(String measUtCdChk) {
		this.measUtCdChk = measUtCdChk;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCdChk
	 */
	public void setWgtUtCdChk(String wgtUtCdChk) {
		this.wgtUtCdChk = wgtUtCdChk;
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
	 * @param cntrCnt
	 */
	public void setCntrCnt(String cntrCnt) {
		this.cntrCnt = cntrCnt;
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
	 * @param hidden6
	 */
	public void setHidden6(String hidden6) {
		this.hidden6 = hidden6;
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
	 * @param pckQtyChk
	 */
	public void setPckQtyChk(String pckQtyChk) {
		this.pckQtyChk = pckQtyChk;
	}
	
	/**
	 * Column Info
	 * @param errChk
	 */
	public void setErrChk(String errChk) {
		this.errChk = errChk;
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
	 * @param cntrTtlWgtChk
	 */
	public void setCntrTtlWgtChk(String cntrTtlWgtChk) {
		this.cntrTtlWgtChk = cntrTtlWgtChk;
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
	 * @param cntrType
	 */
	public void setCntrType(String cntrType) {
		this.cntrType = cntrType;
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
	 * @param mfDlDiffFlg
	 */
	public void setMfDlDiffFlg(String mfDlDiffFlg) {
		this.mfDlDiffFlg = mfDlDiffFlg;
	}
	
	/**
	 * Column Info
	 * @param elNoCheck
	 */
	public void setElNoCheck(String elNoCheck) {
		this.elNoCheck = elNoCheck;
	}
	
	/**
	 * Column Info
	 * @param downYn
	 */
	public void setDownYn(String downYn) {
		this.downYn = downYn;
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
	 * @param whouseDesc
	 */
	public void setWhouseDesc(String whouseDesc) {
		this.whouseDesc = whouseDesc;
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
	 * @param inBound
	 */
	public void setInBound(String inBound) {
		this.inBound = inBound;
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
	 * @param ibVvd
	 */
	public void setIbVvd(String ibVvd) {
		this.ibVvd = ibVvd;
	}
	
	/**
	 * Column Info
	 * @param inPodTmnl
	 */
	public void setInPodTmnl(String inPodTmnl) {
		this.inPodTmnl = inPodTmnl;
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
	 * @param inPolTmnl
	 */
	public void setInPolTmnl(String inPolTmnl) {
		this.inPolTmnl = inPolTmnl;
	}
	
	/**
	 * Column Info
	 * @param dwellDt
	 */
	public void setDwellDt(String dwellDt) {
		this.dwellDt = dwellDt;
	}
	
	/**
	 * Column Info
	 * @param frobCheck
	 */
	public void setFrobCheck(String frobCheck) {
		this.frobCheck = frobCheck;
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
	 * @param mrnNbr
	 */
	public void setMrnNbr(String mrnNbr) {
		this.mrnNbr = mrnNbr;
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
	 * @param bacNm
	 */
	public void setBacNm(String bacNm) {
		this.bacNm = bacNm;
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
	 * @param roChk
	 */
	public void setRoChk(String roChk) {
		this.roChk = roChk;
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
	 * @param custType
	 */
	public void setCustType(String custType) {
		this.custType = custType;
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
	 * @param otherVvd
	 */
	public void setOtherVvd(String otherVvd) {
		this.otherVvd = otherVvd;
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
	 * @param bkgsts
	 */
	public void setBkgsts(String bkgsts) {
		this.bkgsts = bkgsts;
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
	 * @param measQtyChk
	 */
	public void setMeasQtyChk(String measQtyChk) {
		this.measQtyChk = measQtyChk;
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
	 * @param inBlno
	 */
	public void setInBlno(String inBlno) {
		this.inBlno = inBlno;
	}
	
	/**
	 * Column Info
	 * @param sel
	 */
	public void setSel(String sel) {
		this.sel = sel;
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
		setCrsChkRsltFlg(JSPUtil.getParameter(request, prefix + "crs_chk_rslt_flg", ""));
		setInVvd(JSPUtil.getParameter(request, prefix + "in_vvd", ""));
		setNtfyA(JSPUtil.getParameter(request, prefix + "ntfy_a", ""));
		setElnoB(JSPUtil.getParameter(request, prefix + "elno_b", ""));
		setInPod(JSPUtil.getParameter(request, prefix + "in_pod", ""));
		setElnoA(JSPUtil.getParameter(request, prefix + "elno_a", ""));
		setBkgPor(JSPUtil.getParameter(request, prefix + "bkg_por", ""));
		setInPol(JSPUtil.getParameter(request, prefix + "in_pol", ""));
		setElnoWgtCheck(JSPUtil.getParameter(request, prefix + "elno_wgt_check", ""));
		setCrsChkRmk(JSPUtil.getParameter(request, prefix + "crs_chk_rmk", ""));
		setPkgCode(JSPUtil.getParameter(request, prefix + "pkg_code", ""));
		setMfSndFlg(JSPUtil.getParameter(request, prefix + "mf_snd_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDmstPortCd(JSPUtil.getParameter(request, prefix + "dmst_port_cd", ""));
		setABkgNoSplit(JSPUtil.getParameter(request, prefix + "a_bkg_no_split", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setMsnBltp(JSPUtil.getParameter(request, prefix + "msn_bltp", ""));
		setPckTpCdChk(JSPUtil.getParameter(request, prefix + "pck_tp_cd_chk", ""));
		setNtfyN(JSPUtil.getParameter(request, prefix + "ntfy_n", ""));
		setKtPort(JSPUtil.getParameter(request, prefix + "kt_port", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setWh(JSPUtil.getParameter(request, prefix + "wh", ""));
		setMeasUtCdChk(JSPUtil.getParameter(request, prefix + "meas_ut_cd_chk", ""));
		setWgtUtCdChk(JSPUtil.getParameter(request, prefix + "wgt_ut_cd_chk", ""));
		setIbSkdVoyNo(JSPUtil.getParameter(request, prefix + "ib_skd_voy_no", ""));
		setBac(JSPUtil.getParameter(request, prefix + "bac", ""));
		setCntrCnt(JSPUtil.getParameter(request, prefix + "cntr_cnt", ""));
		setIbCstmsDeclTpCd(JSPUtil.getParameter(request, prefix + "ib_cstms_decl_tp_cd", ""));
		setIbMtyBlNo(JSPUtil.getParameter(request, prefix + "ib_mty_bl_no", ""));
		setHidden6(JSPUtil.getParameter(request, prefix + "hidden6", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setHidden3(JSPUtil.getParameter(request, prefix + "hidden3", ""));
		setHidden2(JSPUtil.getParameter(request, prefix + "hidden2", ""));
		setHidden5(JSPUtil.getParameter(request, prefix + "hidden5", ""));
		setHidden4(JSPUtil.getParameter(request, prefix + "hidden4", ""));
		setWgtCode(JSPUtil.getParameter(request, prefix + "wgt_code", ""));
		setHidden1(JSPUtil.getParameter(request, prefix + "hidden1", ""));
		setCustName(JSPUtil.getParameter(request, prefix + "cust_name", ""));
		setIbSkdDirCd(JSPUtil.getParameter(request, prefix + "ib_skd_dir_cd", ""));
		setPckQtyChk(JSPUtil.getParameter(request, prefix + "pck_qty_chk", ""));
		setErrChk(JSPUtil.getParameter(request, prefix + "err_chk", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setCntrTtlWgtChk(JSPUtil.getParameter(request, prefix + "cntr_ttl_wgt_chk", ""));
		setPkgValue(JSPUtil.getParameter(request, prefix + "pkg_value", ""));
		setBkgDel(JSPUtil.getParameter(request, prefix + "bkg_del", ""));
		setFe(JSPUtil.getParameter(request, prefix + "fe", ""));
		setCntrType(JSPUtil.getParameter(request, prefix + "cntr_type", ""));
		setCntr(JSPUtil.getParameter(request, prefix + "cntr", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setMfDlDiffFlg(JSPUtil.getParameter(request, prefix + "mf_dl_diff_flg", ""));
		setElNoCheck(JSPUtil.getParameter(request, prefix + "el_no_check", ""));
		setDownYn(JSPUtil.getParameter(request, prefix + "down_yn", ""));
		setIbVslCd(JSPUtil.getParameter(request, prefix + "ib_vsl_cd", ""));
		setWhouseDesc(JSPUtil.getParameter(request, prefix + "whouse_desc", ""));
		setIbEtaDt(JSPUtil.getParameter(request, prefix + "ib_eta_dt", ""));
		setBz(JSPUtil.getParameter(request, prefix + "bz", ""));
		setTr(JSPUtil.getParameter(request, prefix + "tr", ""));
		setInBound(JSPUtil.getParameter(request, prefix + "in_bound", ""));
		setTp(JSPUtil.getParameter(request, prefix + "tp", ""));
		setWgtValue(JSPUtil.getParameter(request, prefix + "wgt_value", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCneeN(JSPUtil.getParameter(request, prefix + "cnee_n", ""));
		setPreVvd(JSPUtil.getParameter(request, prefix + "pre_vvd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setIbVvd(JSPUtil.getParameter(request, prefix + "ib_vvd", ""));
		setInPodTmnl(JSPUtil.getParameter(request, prefix + "in_pod_tmnl", ""));
		setMsn(JSPUtil.getParameter(request, prefix + "msn", ""));
		setFfordCd(JSPUtil.getParameter(request, prefix + "fford_cd", ""));
		setWhouse(JSPUtil.getParameter(request, prefix + "whouse", ""));
		setSc(JSPUtil.getParameter(request, prefix + "sc", ""));
		setInPolTmnl(JSPUtil.getParameter(request, prefix + "in_pol_tmnl", ""));
		setDwellDt(JSPUtil.getParameter(request, prefix + "dwell_dt", ""));
		setFrobCheck(JSPUtil.getParameter(request, prefix + "frob_check", ""));
		setCreatedType(JSPUtil.getParameter(request, prefix + "created_type", ""));
		setDescCode(JSPUtil.getParameter(request, prefix + "desc_code", ""));
		setCm(JSPUtil.getParameter(request, prefix + "cm", ""));
		setIbTrnsSeq(JSPUtil.getParameter(request, prefix + "ib_trns_seq", ""));
		setCneeA(JSPUtil.getParameter(request, prefix + "cnee_a", ""));
		setMrnNbr(JSPUtil.getParameter(request, prefix + "mrn_nbr", ""));
		setMatch(JSPUtil.getParameter(request, prefix + "match", ""));
		setCorrection(JSPUtil.getParameter(request, prefix + "correction", ""));
		setKcdTp(JSPUtil.getParameter(request, prefix + "kcd_tp", ""));
		setBacNm(JSPUtil.getParameter(request, prefix + "bac_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setRoChk(JSPUtil.getParameter(request, prefix + "ro_chk", ""));
		setIbDmstPortCd(JSPUtil.getParameter(request, prefix + "ib_dmst_port_cd", ""));
		setCustType(JSPUtil.getParameter(request, prefix + "cust_type", ""));
		setABkgNo(JSPUtil.getParameter(request, prefix + "a_bkg_no", ""));
		setOtherVvd(JSPUtil.getParameter(request, prefix + "other_vvd", ""));
		setSelType(JSPUtil.getParameter(request, prefix + "sel_type", ""));
		setShprN(JSPUtil.getParameter(request, prefix + "shpr_n", ""));
		setBkgsts(JSPUtil.getParameter(request, prefix + "bkgsts", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setIbMtyBkgNo(JSPUtil.getParameter(request, prefix + "ib_mty_bkg_no", ""));
		setMeasQtyChk(JSPUtil.getParameter(request, prefix + "meas_qty_chk", ""));
		setShprA(JSPUtil.getParameter(request, prefix + "shpr_a", ""));
		setInBlno(JSPUtil.getParameter(request, prefix + "in_blno", ""));
		setSel(JSPUtil.getParameter(request, prefix + "sel", ""));
		setCBlNo(JSPUtil.getParameter(request, prefix + "c_bl_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorManifestInfoVO[]
	 */
	public KorManifestInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorManifestInfoVO[]
	 */
	public KorManifestInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorManifestInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] crsChkRsltFlg = (JSPUtil.getParameter(request, prefix	+ "crs_chk_rslt_flg", length));
			String[] inVvd = (JSPUtil.getParameter(request, prefix	+ "in_vvd", length));
			String[] ntfyA = (JSPUtil.getParameter(request, prefix	+ "ntfy_a", length));
			String[] elnoB = (JSPUtil.getParameter(request, prefix	+ "elno_b", length));
			String[] inPod = (JSPUtil.getParameter(request, prefix	+ "in_pod", length));
			String[] elnoA = (JSPUtil.getParameter(request, prefix	+ "elno_a", length));
			String[] bkgPor = (JSPUtil.getParameter(request, prefix	+ "bkg_por", length));
			String[] inPol = (JSPUtil.getParameter(request, prefix	+ "in_pol", length));
			String[] elnoWgtCheck = (JSPUtil.getParameter(request, prefix	+ "elno_wgt_check", length));
			String[] crsChkRmk = (JSPUtil.getParameter(request, prefix	+ "crs_chk_rmk", length));
			String[] pkgCode = (JSPUtil.getParameter(request, prefix	+ "pkg_code", length));
			String[] mfSndFlg = (JSPUtil.getParameter(request, prefix	+ "mf_snd_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dmstPortCd = (JSPUtil.getParameter(request, prefix	+ "dmst_port_cd", length));
			String[] aBkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "a_bkg_no_split", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] msnBltp = (JSPUtil.getParameter(request, prefix	+ "msn_bltp", length));
			String[] pckTpCdChk = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd_chk", length));
			String[] ntfyN = (JSPUtil.getParameter(request, prefix	+ "ntfy_n", length));
			String[] ktPort = (JSPUtil.getParameter(request, prefix	+ "kt_port", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] wh = (JSPUtil.getParameter(request, prefix	+ "wh", length));
			String[] measUtCdChk = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd_chk", length));
			String[] wgtUtCdChk = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd_chk", length));
			String[] ibSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "ib_skd_voy_no", length));
			String[] bac = (JSPUtil.getParameter(request, prefix	+ "bac", length));
			String[] cntrCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_cnt", length));
			String[] ibCstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "ib_cstms_decl_tp_cd", length));
			String[] ibMtyBlNo = (JSPUtil.getParameter(request, prefix	+ "ib_mty_bl_no", length));
			String[] hidden6 = (JSPUtil.getParameter(request, prefix	+ "hidden6", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] hidden3 = (JSPUtil.getParameter(request, prefix	+ "hidden3", length));
			String[] hidden2 = (JSPUtil.getParameter(request, prefix	+ "hidden2", length));
			String[] hidden5 = (JSPUtil.getParameter(request, prefix	+ "hidden5", length));
			String[] hidden4 = (JSPUtil.getParameter(request, prefix	+ "hidden4", length));
			String[] wgtCode = (JSPUtil.getParameter(request, prefix	+ "wgt_code", length));
			String[] hidden1 = (JSPUtil.getParameter(request, prefix	+ "hidden1", length));
			String[] custName = (JSPUtil.getParameter(request, prefix	+ "cust_name", length));
			String[] ibSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "ib_skd_dir_cd", length));
			String[] pckQtyChk = (JSPUtil.getParameter(request, prefix	+ "pck_qty_chk", length));
			String[] errChk = (JSPUtil.getParameter(request, prefix	+ "err_chk", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] cntrTtlWgtChk = (JSPUtil.getParameter(request, prefix	+ "cntr_ttl_wgt_chk", length));
			String[] pkgValue = (JSPUtil.getParameter(request, prefix	+ "pkg_value", length));
			String[] bkgDel = (JSPUtil.getParameter(request, prefix	+ "bkg_del", length));
			String[] fe = (JSPUtil.getParameter(request, prefix	+ "fe", length));
			String[] cntrType = (JSPUtil.getParameter(request, prefix	+ "cntr_type", length));
			String[] cntr = (JSPUtil.getParameter(request, prefix	+ "cntr", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] mfDlDiffFlg = (JSPUtil.getParameter(request, prefix	+ "mf_dl_diff_flg", length));
			String[] elNoCheck = (JSPUtil.getParameter(request, prefix	+ "el_no_check", length));
			String[] downYn = (JSPUtil.getParameter(request, prefix	+ "down_yn", length));
			String[] ibVslCd = (JSPUtil.getParameter(request, prefix	+ "ib_vsl_cd", length));
			String[] whouseDesc = (JSPUtil.getParameter(request, prefix	+ "whouse_desc", length));
			String[] ibEtaDt = (JSPUtil.getParameter(request, prefix	+ "ib_eta_dt", length));
			String[] bz = (JSPUtil.getParameter(request, prefix	+ "bz", length));
			String[] tr = (JSPUtil.getParameter(request, prefix	+ "tr", length));
			String[] inBound = (JSPUtil.getParameter(request, prefix	+ "in_bound", length));
			String[] tp = (JSPUtil.getParameter(request, prefix	+ "tp", length));
			String[] wgtValue = (JSPUtil.getParameter(request, prefix	+ "wgt_value", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cneeN = (JSPUtil.getParameter(request, prefix	+ "cnee_n", length));
			String[] preVvd = (JSPUtil.getParameter(request, prefix	+ "pre_vvd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] ibVvd = (JSPUtil.getParameter(request, prefix	+ "ib_vvd", length));
			String[] inPodTmnl = (JSPUtil.getParameter(request, prefix	+ "in_pod_tmnl", length));
			String[] msn = (JSPUtil.getParameter(request, prefix	+ "msn", length));
			String[] ffordCd = (JSPUtil.getParameter(request, prefix	+ "fford_cd", length));
			String[] whouse = (JSPUtil.getParameter(request, prefix	+ "whouse", length));
			String[] sc = (JSPUtil.getParameter(request, prefix	+ "sc", length));
			String[] inPolTmnl = (JSPUtil.getParameter(request, prefix	+ "in_pol_tmnl", length));
			String[] dwellDt = (JSPUtil.getParameter(request, prefix	+ "dwell_dt", length));
			String[] frobCheck = (JSPUtil.getParameter(request, prefix	+ "frob_check", length));
			String[] createdType = (JSPUtil.getParameter(request, prefix	+ "created_type", length));
			String[] descCode = (JSPUtil.getParameter(request, prefix	+ "desc_code", length));
			String[] cm = (JSPUtil.getParameter(request, prefix	+ "cm", length));
			String[] ibTrnsSeq = (JSPUtil.getParameter(request, prefix	+ "ib_trns_seq", length));
			String[] cneeA = (JSPUtil.getParameter(request, prefix	+ "cnee_a", length));
			String[] mrnNbr = (JSPUtil.getParameter(request, prefix	+ "mrn_nbr", length));
			String[] match = (JSPUtil.getParameter(request, prefix	+ "match", length));
			String[] correction = (JSPUtil.getParameter(request, prefix	+ "correction", length));
			String[] kcdTp = (JSPUtil.getParameter(request, prefix	+ "kcd_tp", length));
			String[] bacNm = (JSPUtil.getParameter(request, prefix	+ "bac_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] roChk = (JSPUtil.getParameter(request, prefix	+ "ro_chk", length));
			String[] ibDmstPortCd = (JSPUtil.getParameter(request, prefix	+ "ib_dmst_port_cd", length));
			String[] custType = (JSPUtil.getParameter(request, prefix	+ "cust_type", length));
			String[] aBkgNo = (JSPUtil.getParameter(request, prefix	+ "a_bkg_no", length));
			String[] otherVvd = (JSPUtil.getParameter(request, prefix	+ "other_vvd", length));
			String[] selType = (JSPUtil.getParameter(request, prefix	+ "sel_type", length));
			String[] shprN = (JSPUtil.getParameter(request, prefix	+ "shpr_n", length));
			String[] bkgsts = (JSPUtil.getParameter(request, prefix	+ "bkgsts", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] ibMtyBkgNo = (JSPUtil.getParameter(request, prefix	+ "ib_mty_bkg_no", length));
			String[] measQtyChk = (JSPUtil.getParameter(request, prefix	+ "meas_qty_chk", length));
			String[] shprA = (JSPUtil.getParameter(request, prefix	+ "shpr_a", length));
			String[] inBlno = (JSPUtil.getParameter(request, prefix	+ "in_blno", length));
			String[] sel = (JSPUtil.getParameter(request, prefix	+ "sel", length));
			String[] cBlNo = (JSPUtil.getParameter(request, prefix	+ "c_bl_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorManifestInfoVO();
				if (crsChkRsltFlg[i] != null)
					model.setCrsChkRsltFlg(crsChkRsltFlg[i]);
				if (inVvd[i] != null)
					model.setInVvd(inVvd[i]);
				if (ntfyA[i] != null)
					model.setNtfyA(ntfyA[i]);
				if (elnoB[i] != null)
					model.setElnoB(elnoB[i]);
				if (inPod[i] != null)
					model.setInPod(inPod[i]);
				if (elnoA[i] != null)
					model.setElnoA(elnoA[i]);
				if (bkgPor[i] != null)
					model.setBkgPor(bkgPor[i]);
				if (inPol[i] != null)
					model.setInPol(inPol[i]);
				if (elnoWgtCheck[i] != null)
					model.setElnoWgtCheck(elnoWgtCheck[i]);
				if (crsChkRmk[i] != null)
					model.setCrsChkRmk(crsChkRmk[i]);
				if (pkgCode[i] != null)
					model.setPkgCode(pkgCode[i]);
				if (mfSndFlg[i] != null)
					model.setMfSndFlg(mfSndFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dmstPortCd[i] != null)
					model.setDmstPortCd(dmstPortCd[i]);
				if (aBkgNoSplit[i] != null)
					model.setABkgNoSplit(aBkgNoSplit[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (msnBltp[i] != null)
					model.setMsnBltp(msnBltp[i]);
				if (pckTpCdChk[i] != null)
					model.setPckTpCdChk(pckTpCdChk[i]);
				if (ntfyN[i] != null)
					model.setNtfyN(ntfyN[i]);
				if (ktPort[i] != null)
					model.setKtPort(ktPort[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (wh[i] != null)
					model.setWh(wh[i]);
				if (measUtCdChk[i] != null)
					model.setMeasUtCdChk(measUtCdChk[i]);
				if (wgtUtCdChk[i] != null)
					model.setWgtUtCdChk(wgtUtCdChk[i]);
				if (ibSkdVoyNo[i] != null)
					model.setIbSkdVoyNo(ibSkdVoyNo[i]);
				if (bac[i] != null)
					model.setBac(bac[i]);
				if (cntrCnt[i] != null)
					model.setCntrCnt(cntrCnt[i]);
				if (ibCstmsDeclTpCd[i] != null)
					model.setIbCstmsDeclTpCd(ibCstmsDeclTpCd[i]);
				if (ibMtyBlNo[i] != null)
					model.setIbMtyBlNo(ibMtyBlNo[i]);
				if (hidden6[i] != null)
					model.setHidden6(hidden6[i]);
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
				if (pckQtyChk[i] != null)
					model.setPckQtyChk(pckQtyChk[i]);
				if (errChk[i] != null)
					model.setErrChk(errChk[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (cntrTtlWgtChk[i] != null)
					model.setCntrTtlWgtChk(cntrTtlWgtChk[i]);
				if (pkgValue[i] != null)
					model.setPkgValue(pkgValue[i]);
				if (bkgDel[i] != null)
					model.setBkgDel(bkgDel[i]);
				if (fe[i] != null)
					model.setFe(fe[i]);
				if (cntrType[i] != null)
					model.setCntrType(cntrType[i]);
				if (cntr[i] != null)
					model.setCntr(cntr[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (mfDlDiffFlg[i] != null)
					model.setMfDlDiffFlg(mfDlDiffFlg[i]);
				if (elNoCheck[i] != null)
					model.setElNoCheck(elNoCheck[i]);
				if (downYn[i] != null)
					model.setDownYn(downYn[i]);
				if (ibVslCd[i] != null)
					model.setIbVslCd(ibVslCd[i]);
				if (whouseDesc[i] != null)
					model.setWhouseDesc(whouseDesc[i]);
				if (ibEtaDt[i] != null)
					model.setIbEtaDt(ibEtaDt[i]);
				if (bz[i] != null)
					model.setBz(bz[i]);
				if (tr[i] != null)
					model.setTr(tr[i]);
				if (inBound[i] != null)
					model.setInBound(inBound[i]);
				if (tp[i] != null)
					model.setTp(tp[i]);
				if (wgtValue[i] != null)
					model.setWgtValue(wgtValue[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cneeN[i] != null)
					model.setCneeN(cneeN[i]);
				if (preVvd[i] != null)
					model.setPreVvd(preVvd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (ibVvd[i] != null)
					model.setIbVvd(ibVvd[i]);
				if (inPodTmnl[i] != null)
					model.setInPodTmnl(inPodTmnl[i]);
				if (msn[i] != null)
					model.setMsn(msn[i]);
				if (ffordCd[i] != null)
					model.setFfordCd(ffordCd[i]);
				if (whouse[i] != null)
					model.setWhouse(whouse[i]);
				if (sc[i] != null)
					model.setSc(sc[i]);
				if (inPolTmnl[i] != null)
					model.setInPolTmnl(inPolTmnl[i]);
				if (dwellDt[i] != null)
					model.setDwellDt(dwellDt[i]);
				if (frobCheck[i] != null)
					model.setFrobCheck(frobCheck[i]);
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
				if (mrnNbr[i] != null)
					model.setMrnNbr(mrnNbr[i]);
				if (match[i] != null)
					model.setMatch(match[i]);
				if (correction[i] != null)
					model.setCorrection(correction[i]);
				if (kcdTp[i] != null)
					model.setKcdTp(kcdTp[i]);
				if (bacNm[i] != null)
					model.setBacNm(bacNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (roChk[i] != null)
					model.setRoChk(roChk[i]);
				if (ibDmstPortCd[i] != null)
					model.setIbDmstPortCd(ibDmstPortCd[i]);
				if (custType[i] != null)
					model.setCustType(custType[i]);
				if (aBkgNo[i] != null)
					model.setABkgNo(aBkgNo[i]);
				if (otherVvd[i] != null)
					model.setOtherVvd(otherVvd[i]);
				if (selType[i] != null)
					model.setSelType(selType[i]);
				if (shprN[i] != null)
					model.setShprN(shprN[i]);
				if (bkgsts[i] != null)
					model.setBkgsts(bkgsts[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (ibMtyBkgNo[i] != null)
					model.setIbMtyBkgNo(ibMtyBkgNo[i]);
				if (measQtyChk[i] != null)
					model.setMeasQtyChk(measQtyChk[i]);
				if (shprA[i] != null)
					model.setShprA(shprA[i]);
				if (inBlno[i] != null)
					model.setInBlno(inBlno[i]);
				if (sel[i] != null)
					model.setSel(sel[i]);
				if (cBlNo[i] != null)
					model.setCBlNo(cBlNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorManifestInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorManifestInfoVO[]
	 */
	public KorManifestInfoVO[] getKorManifestInfoVOs(){
		KorManifestInfoVO[] vos = (KorManifestInfoVO[])models.toArray(new KorManifestInfoVO[models.size()]);
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
		this.crsChkRsltFlg = this.crsChkRsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvd = this.inVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyA = this.ntfyA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elnoB = this.elnoB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPod = this.inPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elnoA = this.elnoA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPor = this.bkgPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPol = this.inPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elnoWgtCheck = this.elnoWgtCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crsChkRmk = this.crsChkRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgCode = this.pkgCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSndFlg = this.mfSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmstPortCd = this.dmstPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aBkgNoSplit = this.aBkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msnBltp = this.msnBltp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCdChk = this.pckTpCdChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyN = this.ntfyN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktPort = this.ktPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wh = this.wh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCdChk = this.measUtCdChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCdChk = this.wgtUtCdChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSkdVoyNo = this.ibSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bac = this.bac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnt = this.cntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCstmsDeclTpCd = this.ibCstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibMtyBlNo = this.ibMtyBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden6 = this.hidden6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden3 = this.hidden3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden2 = this.hidden2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden5 = this.hidden5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden4 = this.hidden4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtCode = this.wgtCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden1 = this.hidden1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custName = this.custName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSkdDirCd = this.ibSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQtyChk = this.pckQtyChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errChk = this.errChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTtlWgtChk = this.cntrTtlWgtChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgValue = this.pkgValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDel = this.bkgDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fe = this.fe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrType = this.cntrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr = this.cntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfDlDiffFlg = this.mfDlDiffFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elNoCheck = this.elNoCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.downYn = this.downYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibVslCd = this.ibVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whouseDesc = this.whouseDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibEtaDt = this.ibEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bz = this.bz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tr = this.tr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBound = this.inBound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tp = this.tp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtValue = this.wgtValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeN = this.cneeN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVvd = this.preVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibVvd = this.ibVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodTmnl = this.inPodTmnl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msn = this.msn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffordCd = this.ffordCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whouse = this.whouse .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sc = this.sc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolTmnl = this.inPolTmnl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwellDt = this.dwellDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frobCheck = this.frobCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.createdType = this.createdType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.descCode = this.descCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm = this.cm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibTrnsSeq = this.ibTrnsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeA = this.cneeA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNbr = this.mrnNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.match = this.match .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.correction = this.correction .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcdTp = this.kcdTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bacNm = this.bacNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.roChk = this.roChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibDmstPortCd = this.ibDmstPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custType = this.custType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aBkgNo = this.aBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otherVvd = this.otherVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selType = this.selType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprN = this.shprN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgsts = this.bkgsts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibMtyBkgNo = this.ibMtyBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQtyChk = this.measQtyChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprA = this.shprA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBlno = this.inBlno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sel = this.sel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cBlNo = this.cBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
