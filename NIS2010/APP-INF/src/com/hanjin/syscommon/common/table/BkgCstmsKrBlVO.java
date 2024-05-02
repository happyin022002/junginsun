/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCstmsKrBlVO.java
*@FileTitle : BkgCstmsKrBlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.06.29 손윤석 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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

public class BkgCstmsKrBlVO extends AbstractValueObject {

private static final long serialVersionUID = 1L;

private Collection<BkgCstmsKrBlVO> models = new ArrayList<BkgCstmsKrBlVO>();

/* Column Info */
private String ntfyA = null;
/* Column Info */
private String vslCd = null;
/* Column Info */
private String elnoB = null;
/* Column Info */
private String elnoA = null;
/* Column Info */
private String tr = null;
/* Column Info */
private String inBound = null;
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
/* Column Info */
private String krBlAmdtStsCd = null;
/* Column Info */
private String ktSeq = null;
/* Column Info */
private String username = null;
/* Column Info */
private String polCd = null;
/* Column Info */
private String bkgTpCd = null;
/* Column Info */
private String preVvd = null;
/* Column Info */
private String wgtUtCd = null;
/* Column Info */
private String tpCd = null;
/* Column Info */
private String cusName = null;
/* Column Info */
private String ntfyN = null;
/* Column Info */
private String ktPort = null;
/* Column Info */
private String wh = null;
/* Column Info */
private String bondAreaCode = null;
/* Column Info */
private String trnsSeq = null;
/* Column Info */
private String sc = null;
/* Column Info */
private String bac = null;
/* Column Info */
private String podLoc = null;
/* Column Info */
private String exptKcdTp = null;
/* Column Info */
private String podCd = null;
/* Column Info */
private String blMeasUtCd = null;
/* Column Info */
private String transType = null;
/* Column Info */
private String descCode = null;
/* Column Info */
private String bkgNo = null;
/* Column Info */
private String ktSndDtChk = null;
/* Column Info */
private String bizRgstNo = null;
/* Column Info */
private String wgtCode = null;
/* Column Info */
private String cneeA = null;
/* Column Info */
private String obType = null;
/* Column Info */
private String match = null;
/* Column Info */
private String cntrTtlWgt = null;
/* Column Info */
private String tsPodCd = null;
/* Column Info */
private String ktSts = null;
/* Column Info */
private String polLoc = null;
/* Column Info */
private String sumBl1 = null;
/* Column Info */
private String sumBl2 = null;
/* Column Info */
private String sumBl3 = null;
/* Column Info */
private String sumBl4 = null;
/* Column Info */
private String correction = null;
/* Column Info */
private String kcdTp = null;
/* Column Info */
private String mrnType = null;
/* VO Data Value( C:Creation, U:Update, D:Delete ) */
private String ibflag = null;
/* Column Info */
private String usrId = null;
/* Column Info */
private String cmdtCd = null;
/* Column Info */
private String sumBl10 = null;
/* Column Info */
private String mfSndDt = null;
/* Column Info */
private String sumBl11 = null;
/* Column Info */
private String measQty = null;
/* Column Info */
private String pckQty = null;
/* Column Info */
private String bizNo = null;
/* Column Info */
private String pckTpCd = null;
/* Column Info */
private String krCstmsBndCd = null;
/* Column Info */
private String tsPolCd = null;
/* Column Info */
private String pkgValue = null;
/* Column Info */
private String cnt = null;
/* Column Info */
private String shprN = null;
/* Column Info */
private String bkgNoSplit = null;
/* Column Info */
private String mstBlSeq = null;
/* Column Info */
private String cntr = null;
/* Column Info */
private String sumBl8 = null;
/* Column Info */
private String shprA = null;
/* Column Info */
private String sumBl7 = null;
/* Column Info */
private String sumBl6 = null;
/* Column Info */
private String podTml = null;
/* Column Info */
private String sumBl5 = null;
/* Column Info */
private String bKtSeq = null;
/* Column Info */
private String sumBl9 = null;
/* Column Info */
private String cBlNo = null;


/*	테이블 컬럼의 값을 저장하는 Hashtable */
private HashMap<String, String> hashColumns = new HashMap<String, String>();

/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
private HashMap<String, String> hashFields = new HashMap<String, String>();

public BkgCstmsKrBlVO() {}

public BkgCstmsKrBlVO(String ibflag, String pagerows, String ntfyA, String sumBl1, String sumBl2, String sumBl3, String sumBl4, String sumBl5, String sumBl6, String sumBl7, String sumBl8, String sumBl9, String sumBl10, String sumBl11, String elnoB, String elnoA, String tr, String inBound, String correction, String wgtValue, String krCstmsBndCd, String pkgCode, String blNo, String cneeN, String polCd, String bkgTpCd, String preVvd, String cmdtCd, String mfSndDt, String wgtUtCd, String measQty, String pckQty, String tpCd, String cusName, String ntfyN, String pckTpCd, String wh, String pkgValue, String shprN, String trnsSeq, String mstBlSeq, String sc, String bac, String cntr, String podCd, String blMeasUtCd, String descCode, String bkgNo, String bizRgstNo, String wgtCode, String cneeA, String shprA, String match, String cntrTtlWgt, String bkgNoSplit, String kcdTp, String ktPort, String ktSeq, String ktSndDtChk, String transType, String bizNo, String tsPodCd, String tsPolCd, String vslCd, String krBlAmdtStsCd, String ktSts, String bKtSeq, String exptKcdTp, String obType, String mrnType, String podTml, String podLoc, String polLoc, String cnt, String username, String bondAreaCode, String usrId, String cBlNo) {
	this.ntfyA = ntfyA;
	this.vslCd = vslCd;
	this.elnoB = elnoB;
	this.elnoA = elnoA;
	this.tr = tr;
	this.inBound = inBound;
	this.wgtValue = wgtValue;
	this.pkgCode = pkgCode;
	this.blNo = blNo;
	this.cneeN = cneeN;
	this.pagerows = pagerows;
	this.krBlAmdtStsCd = krBlAmdtStsCd;
	this.ktSeq = ktSeq;
	this.username = username;
	this.polCd = polCd;
	this.bkgTpCd = bkgTpCd;
	this.preVvd = preVvd;
	this.wgtUtCd = wgtUtCd;
	this.tpCd = tpCd;
	this.cusName = cusName;
	this.ntfyN = ntfyN;
	this.ktPort = ktPort;
	this.wh = wh;
	this.bondAreaCode = bondAreaCode;
	this.trnsSeq = trnsSeq;
	this.sc = sc;
	this.bac = bac;
	this.podLoc = podLoc;
	this.exptKcdTp = exptKcdTp;
	this.podCd = podCd;
	this.blMeasUtCd = blMeasUtCd;
	this.transType = transType;
	this.descCode = descCode;
	this.bkgNo = bkgNo;
	this.ktSndDtChk = ktSndDtChk;
	this.bizRgstNo = bizRgstNo;
	this.wgtCode = wgtCode;
	this.cneeA = cneeA;
	this.obType = obType;
	this.match = match;
	this.cntrTtlWgt = cntrTtlWgt;
	this.tsPodCd = tsPodCd;
	this.ktSts = ktSts;
	this.polLoc = polLoc;
	this.sumBl1 = sumBl1;
	this.sumBl2 = sumBl2;
	this.sumBl3 = sumBl3;
	this.sumBl4 = sumBl4;
	this.correction = correction;
	this.kcdTp = kcdTp;
	this.mrnType = mrnType;
	this.ibflag = ibflag;
	this.usrId = usrId;
	this.cmdtCd = cmdtCd;
	this.sumBl10 = sumBl10;
	this.mfSndDt = mfSndDt;
	this.sumBl11 = sumBl11;
	this.measQty = measQty;
	this.pckQty = pckQty;
	this.bizNo = bizNo;
	this.pckTpCd = pckTpCd;
	this.krCstmsBndCd = krCstmsBndCd;
	this.tsPolCd = tsPolCd;
	this.pkgValue = pkgValue;
	this.cnt = cnt;
	this.shprN = shprN;
	this.bkgNoSplit = bkgNoSplit;
	this.mstBlSeq = mstBlSeq;
	this.cntr = cntr;
	this.sumBl8 = sumBl8;
	this.shprA = shprA;
	this.sumBl7 = sumBl7;
	this.sumBl6 = sumBl6;
	this.podTml = podTml;
	this.sumBl5 = sumBl5;
	this.bKtSeq = bKtSeq;
	this.sumBl9 = sumBl9;
	this.cBlNo = cBlNo;
}

/**
 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
 * @return HashMap
 */
public HashMap<String, String> getColumnValues(){
	this.hashColumns.put("ntfy_a", getNtfyA());
	this.hashColumns.put("vsl_cd", getVslCd());
	this.hashColumns.put("elno_b", getElnoB());
	this.hashColumns.put("elno_a", getElnoA());
	this.hashColumns.put("tr", getTr());
	this.hashColumns.put("in_bound", getInBound());
	this.hashColumns.put("wgt_value", getWgtValue());
	this.hashColumns.put("pkg_code", getPkgCode());
	this.hashColumns.put("bl_no", getBlNo());
	this.hashColumns.put("cnee_n", getCneeN());
	this.hashColumns.put("pagerows", getPagerows());
	this.hashColumns.put("kr_bl_amdt_sts_cd", getKrBlAmdtStsCd());
	this.hashColumns.put("kt_seq", getKtSeq());
	this.hashColumns.put("username", getUsername());
	this.hashColumns.put("pol_cd", getPolCd());
	this.hashColumns.put("bkg_tp_cd", getBkgTpCd());
	this.hashColumns.put("pre_vvd", getPreVvd());
	this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
	this.hashColumns.put("tp_cd", getTpCd());
	this.hashColumns.put("cus_name", getCusName());
	this.hashColumns.put("ntfy_n", getNtfyN());
	this.hashColumns.put("kt_port", getKtPort());
	this.hashColumns.put("wh", getWh());
	this.hashColumns.put("bond_area_code", getBondAreaCode());
	this.hashColumns.put("trns_seq", getTrnsSeq());
	this.hashColumns.put("sc", getSc());
	this.hashColumns.put("bac", getBac());
	this.hashColumns.put("pod_loc", getPodLoc());
	this.hashColumns.put("expt_kcd_tp", getExptKcdTp());
	this.hashColumns.put("pod_cd", getPodCd());
	this.hashColumns.put("bl_meas_ut_cd", getBlMeasUtCd());
	this.hashColumns.put("trans_type", getTransType());
	this.hashColumns.put("desc_code", getDescCode());
	this.hashColumns.put("bkg_no", getBkgNo());
	this.hashColumns.put("kt_snd_dt_chk", getKtSndDtChk());
	this.hashColumns.put("biz_rgst_no", getBizRgstNo());
	this.hashColumns.put("wgt_code", getWgtCode());
	this.hashColumns.put("cnee_a", getCneeA());
	this.hashColumns.put("ob_type", getObType());
	this.hashColumns.put("match", getMatch());
	this.hashColumns.put("cntr_ttl_wgt", getCntrTtlWgt());
	this.hashColumns.put("ts_pod_cd", getTsPodCd());
	this.hashColumns.put("kt_sts", getKtSts());
	this.hashColumns.put("pol_loc", getPolLoc());
	this.hashColumns.put("sum_bl1", getSumBl1());
	this.hashColumns.put("sum_bl2", getSumBl2());
	this.hashColumns.put("sum_bl3", getSumBl3());
	this.hashColumns.put("sum_bl4", getSumBl4());
	this.hashColumns.put("correction", getCorrection());
	this.hashColumns.put("kcd_tp", getKcdTp());
	this.hashColumns.put("mrn_type", getMrnType());
	this.hashColumns.put("ibflag", getIbflag());
	this.hashColumns.put("usr_id", getUsrId());
	this.hashColumns.put("cmdt_cd", getCmdtCd());
	this.hashColumns.put("sum_bl10", getSumBl10());
	this.hashColumns.put("mf_snd_dt", getMfSndDt());
	this.hashColumns.put("sum_bl11", getSumBl11());
	this.hashColumns.put("meas_qty", getMeasQty());
	this.hashColumns.put("pck_qty", getPckQty());
	this.hashColumns.put("biz_no", getBizNo());
	this.hashColumns.put("pck_tp_cd", getPckTpCd());
	this.hashColumns.put("kr_cstms_bnd_cd", getKrCstmsBndCd());
	this.hashColumns.put("ts_pol_cd", getTsPolCd());
	this.hashColumns.put("pkg_value", getPkgValue());
	this.hashColumns.put("cnt", getCnt());
	this.hashColumns.put("shpr_n", getShprN());
	this.hashColumns.put("bkg_no_split", getBkgNoSplit());
	this.hashColumns.put("mst_bl_seq", getMstBlSeq());
	this.hashColumns.put("cntr", getCntr());
	this.hashColumns.put("sum_bl8", getSumBl8());
	this.hashColumns.put("shpr_a", getShprA());
	this.hashColumns.put("sum_bl7", getSumBl7());
	this.hashColumns.put("sum_bl6", getSumBl6());
	this.hashColumns.put("pod_tml", getPodTml());
	this.hashColumns.put("sum_bl5", getSumBl5());
	this.hashColumns.put("b_kt_seq", getBKtSeq());
	this.hashColumns.put("sum_bl9", getSumBl9());
	this.hashColumns.put("c_bl_no", getCBlNo());
	return this.hashColumns;
}

/**
 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
 * @return
 */
public HashMap<String, String> getFieldNames(){
	this.hashFields.put("ntfy_a", "ntfyA");
	this.hashFields.put("vsl_cd", "vslCd");
	this.hashFields.put("elno_b", "elnoB");
	this.hashFields.put("elno_a", "elnoA");
	this.hashFields.put("tr", "tr");
	this.hashFields.put("in_bound", "inBound");
	this.hashFields.put("wgt_value", "wgtValue");
	this.hashFields.put("pkg_code", "pkgCode");
	this.hashFields.put("bl_no", "blNo");
	this.hashFields.put("cnee_n", "cneeN");
	this.hashFields.put("pagerows", "pagerows");
	this.hashFields.put("kr_bl_amdt_sts_cd", "krBlAmdtStsCd");
	this.hashFields.put("kt_seq", "ktSeq");
	this.hashFields.put("username", "username");
	this.hashFields.put("pol_cd", "polCd");
	this.hashFields.put("bkg_tp_cd", "bkgTpCd");
	this.hashFields.put("pre_vvd", "preVvd");
	this.hashFields.put("wgt_ut_cd", "wgtUtCd");
	this.hashFields.put("tp_cd", "tpCd");
	this.hashFields.put("cus_name", "cusName");
	this.hashFields.put("ntfy_n", "ntfyN");
	this.hashFields.put("kt_port", "ktPort");
	this.hashFields.put("wh", "wh");
	this.hashFields.put("bond_area_code", "bondAreaCode");
	this.hashFields.put("trns_seq", "trnsSeq");
	this.hashFields.put("sc", "sc");
	this.hashFields.put("bac", "bac");
	this.hashFields.put("pod_loc", "podLoc");
	this.hashFields.put("expt_kcd_tp", "exptKcdTp");
	this.hashFields.put("pod_cd", "podCd");
	this.hashFields.put("bl_meas_ut_cd", "blMeasUtCd");
	this.hashFields.put("trans_type", "transType");
	this.hashFields.put("desc_code", "descCode");
	this.hashFields.put("bkg_no", "bkgNo");
	this.hashFields.put("kt_snd_dt_chk", "ktSndDtChk");
	this.hashFields.put("biz_rgst_no", "bizRgstNo");
	this.hashFields.put("wgt_code", "wgtCode");
	this.hashFields.put("cnee_a", "cneeA");
	this.hashFields.put("ob_type", "obType");
	this.hashFields.put("match", "match");
	this.hashFields.put("cntr_ttl_wgt", "cntrTtlWgt");
	this.hashFields.put("ts_pod_cd", "tsPodCd");
	this.hashFields.put("kt_sts", "ktSts");
	this.hashFields.put("pol_loc", "polLoc");
	this.hashFields.put("sum_bl1", "sumBl1");
	this.hashFields.put("sum_bl2", "sumBl2");
	this.hashFields.put("sum_bl3", "sumBl3");
	this.hashFields.put("sum_bl4", "sumBl4");
	this.hashFields.put("correction", "correction");
	this.hashFields.put("kcd_tp", "kcdTp");
	this.hashFields.put("mrn_type", "mrnType");
	this.hashFields.put("ibflag", "ibflag");
	this.hashFields.put("usr_id", "usrId");
	this.hashFields.put("cmdt_cd", "cmdtCd");
	this.hashFields.put("sum_bl10", "sumBl10");
	this.hashFields.put("mf_snd_dt", "mfSndDt");
	this.hashFields.put("sum_bl11", "sumBl11");
	this.hashFields.put("meas_qty", "measQty");
	this.hashFields.put("pck_qty", "pckQty");
	this.hashFields.put("biz_no", "bizNo");
	this.hashFields.put("pck_tp_cd", "pckTpCd");
	this.hashFields.put("kr_cstms_bnd_cd", "krCstmsBndCd");
	this.hashFields.put("ts_pol_cd", "tsPolCd");
	this.hashFields.put("pkg_value", "pkgValue");
	this.hashFields.put("cnt", "cnt");
	this.hashFields.put("shpr_n", "shprN");
	this.hashFields.put("bkg_no_split", "bkgNoSplit");
	this.hashFields.put("mst_bl_seq", "mstBlSeq");
	this.hashFields.put("cntr", "cntr");
	this.hashFields.put("sum_bl8", "sumBl8");
	this.hashFields.put("shpr_a", "shprA");
	this.hashFields.put("sum_bl7", "sumBl7");
	this.hashFields.put("sum_bl6", "sumBl6");
	this.hashFields.put("pod_tml", "podTml");
	this.hashFields.put("sum_bl5", "sumBl5");
	this.hashFields.put("b_kt_seq", "bKtSeq");
	this.hashFields.put("sum_bl9", "sumBl9");
	this.hashFields.put("c_bl_no", "cBlNo");
	return this.hashFields;
}

public String getCBlNo() {
	return this.cBlNo;
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
 * @return vslCd
 */
public String getVslCd() {
	return this.vslCd;
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
 * @return inBound
 */
public String getInBound() {
	return this.inBound;
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
 * Column Info
 * @return krBlAmdtStsCd
 */
public String getKrBlAmdtStsCd() {
	return this.krBlAmdtStsCd;
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
 * @return username
 */
public String getUsername() {
	return this.username;
}

/**
 * Column Info
 * @return polCd
 */
public String getPolCd() {
	return this.polCd;
}

/**
 * Column Info
 * @return bkgTpCd
 */
public String getBkgTpCd() {
	return this.bkgTpCd;
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
 * @return tpCd
 */
public String getTpCd() {
	return this.tpCd;
}

/**
 * Column Info
 * @return cusName
 */
public String getCusName() {
	return this.cusName;
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
 * @return wh
 */
public String getWh() {
	return this.wh;
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
 * @return trnsSeq
 */
public String getTrnsSeq() {
	return this.trnsSeq;
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
 * @return podLoc
 */
public String getPodLoc() {
	return this.podLoc;
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
 * @return podCd
 */
public String getPodCd() {
	return this.podCd;
}

/**
 * Column Info
 * @return blMeasUtCd
 */
public String getBlMeasUtCd() {
	return this.blMeasUtCd;
}

/**
 * Column Info
 * @return transType
 */
public String getTransType() {
	return this.transType;
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
	return this.bkgNo;
}

/**
 * Column Info
 * @return ktSndDtChk
 */
public String getKtSndDtChk() {
	return this.ktSndDtChk;
}

/**
 * Column Info
 * @return bizRgstNo
 */
public String getBizRgstNo() {
	return this.bizRgstNo;
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
 * @return obType
 */
public String getObType() {
	return this.obType;
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
 * @return cntrTtlWgt
 */
public String getCntrTtlWgt() {
	return this.cntrTtlWgt;
}

/**
 * Column Info
 * @return tsPodCd
 */
public String getTsPodCd() {
	return this.tsPodCd;
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
 * @return polLoc
 */
public String getPolLoc() {
	return this.polLoc;
}

/**
 * Column Info
 * @return sumBl1
 */
public String getSumBl1() {
	return this.sumBl1;
}

/**
 * Column Info
 * @return sumBl2
 */
public String getSumBl2() {
	return this.sumBl2;
}

/**
 * Column Info
 * @return sumBl3
 */
public String getSumBl3() {
	return this.sumBl3;
}

/**
 * Column Info
 * @return sumBl4
 */
public String getSumBl4() {
	return this.sumBl4;
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
 * @return mrnType
 */
public String getMrnType() {
	return this.mrnType;
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
 * @return usrId
 */
public String getUsrId() {
	return this.usrId;
}

/**
 * Column Info
 * @return cmdtCd
 */
public String getCmdtCd() {
	return this.cmdtCd;
}

/**
 * Column Info
 * @return sumBl10
 */
public String getSumBl10() {
	return this.sumBl10;
}

/**
 * Column Info
 * @return mfSndDt
 */
public String getMfSndDt() {
	return this.mfSndDt;
}

/**
 * Column Info
 * @return sumBl11
 */
public String getSumBl11() {
	return this.sumBl11;
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
 * @return bizNo
 */
public String getBizNo() {
	return this.bizNo;
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
 * @return krCstmsBndCd
 */
public String getKrCstmsBndCd() {
	return this.krCstmsBndCd;
}

/**
 * Column Info
 * @return tsPolCd
 */
public String getTsPolCd() {
	return this.tsPolCd;
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
 * @return cnt
 */
public String getCnt() {
	return this.cnt;
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
 * @return bkgNoSplit
 */
public String getBkgNoSplit() {
	return this.bkgNoSplit;
}

/**
 * Column Info
 * @return mstBlSeq
 */
public String getMstBlSeq() {
	return this.mstBlSeq;
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
 * @return sumBl8
 */
public String getSumBl8() {
	return this.sumBl8;
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
 * @return sumBl7
 */
public String getSumBl7() {
	return this.sumBl7;
}

/**
 * Column Info
 * @return sumBl6
 */
public String getSumBl6() {
	return this.sumBl6;
}

/**
 * Column Info
 * @return podTml
 */
public String getPodTml() {
	return this.podTml;
}

/**
 * Column Info
 * @return sumBl5
 */
public String getSumBl5() {
	return this.sumBl5;
}

/**
 * Column Info
 * @return bKtSeq
 */
public String getBKtSeq() {
	return this.bKtSeq;
}

/**
 * Column Info
 * @return sumBl9
 */
public String getSumBl9() {
	return this.sumBl9;
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
 * @param vslCd
 */
public void setVslCd(String vslCd) {
	this.vslCd = vslCd;
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
 * @param inBound
 */
public void setInBound(String inBound) {
	this.inBound = inBound;
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
 * Column Info
 * @param krBlAmdtStsCd
 */
public void setKrBlAmdtStsCd(String krBlAmdtStsCd) {
	this.krBlAmdtStsCd = krBlAmdtStsCd;
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
 * @param username
 */
public void setUsername(String username) {
	this.username = username;
}

/**
 * Column Info
 * @param polCd
 */
public void setPolCd(String polCd) {
	this.polCd = polCd;
}

/**
 * Column Info
 * @param bkgTpCd
 */
public void setBkgTpCd(String bkgTpCd) {
	this.bkgTpCd = bkgTpCd;
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
 * @param tpCd
 */
public void setTpCd(String tpCd) {
	this.tpCd = tpCd;
}

/**
 * Column Info
 * @param cusName
 */
public void setCusName(String cusName) {
	this.cusName = cusName;
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
 * @param wh
 */
public void setWh(String wh) {
	this.wh = wh;
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
 * @param trnsSeq
 */
public void setTrnsSeq(String trnsSeq) {
	this.trnsSeq = trnsSeq;
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
 * @param podLoc
 */
public void setPodLoc(String podLoc) {
	this.podLoc = podLoc;
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
 * @param podCd
 */
public void setPodCd(String podCd) {
	this.podCd = podCd;
}

/**
 * Column Info
 * @param blMeasUtCd
 */
public void setBlMeasUtCd(String blMeasUtCd) {
	this.blMeasUtCd = blMeasUtCd;
}

/**
 * Column Info
 * @param transType
 */
public void setTransType(String transType) {
	this.transType = transType;
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
public void setBkgNo(String bkgNo) {
	this.bkgNo = bkgNo;
}

/**
 * Column Info
 * @param ktSndDtChk
 */
public void setKtSndDtChk(String ktSndDtChk) {
	this.ktSndDtChk = ktSndDtChk;
}

/**
 * Column Info
 * @param bizRgstNo
 */
public void setBizRgstNo(String bizRgstNo) {
	this.bizRgstNo = bizRgstNo;
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
 * @param obType
 */
public void setObType(String obType) {
	this.obType = obType;
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
 * @param cntrTtlWgt
 */
public void setCntrTtlWgt(String cntrTtlWgt) {
	this.cntrTtlWgt = cntrTtlWgt;
}

/**
 * Column Info
 * @param tsPodCd
 */
public void setTsPodCd(String tsPodCd) {
	this.tsPodCd = tsPodCd;
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
 * @param polLoc
 */
public void setPolLoc(String polLoc) {
	this.polLoc = polLoc;
}

/**
 * Column Info
 * @param sumBl1
 */
public void setSumBl1(String sumBl1) {
	this.sumBl1 = sumBl1;
}

/**
 * Column Info
 * @param sumBl2
 */
public void setSumBl2(String sumBl2) {
	this.sumBl2 = sumBl2;
}

/**
 * Column Info
 * @param sumBl3
 */
public void setSumBl3(String sumBl3) {
	this.sumBl3 = sumBl3;
}

/**
 * Column Info
 * @param sumBl4
 */
public void setSumBl4(String sumBl4) {
	this.sumBl4 = sumBl4;
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
 * @param mrnType
 */
public void setMrnType(String mrnType) {
	this.mrnType = mrnType;
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
 * @param usrId
 */
public void setUsrId(String usrId) {
	this.usrId = usrId;
}

/**
 * Column Info
 * @param cmdtCd
 */
public void setCmdtCd(String cmdtCd) {
	this.cmdtCd = cmdtCd;
}

/**
 * Column Info
 * @param sumBl10
 */
public void setSumBl10(String sumBl10) {
	this.sumBl10 = sumBl10;
}

/**
 * Column Info
 * @param mfSndDt
 */
public void setMfSndDt(String mfSndDt) {
	this.mfSndDt = mfSndDt;
}

/**
 * Column Info
 * @param sumBl11
 */
public void setSumBl11(String sumBl11) {
	this.sumBl11 = sumBl11;
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
 * @param bizNo
 */
public void setBizNo(String bizNo) {
	this.bizNo = bizNo;
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
 * @param krCstmsBndCd
 */
public void setKrCstmsBndCd(String krCstmsBndCd) {
	this.krCstmsBndCd = krCstmsBndCd;
}

/**
 * Column Info
 * @param tsPolCd
 */
public void setTsPolCd(String tsPolCd) {
	this.tsPolCd = tsPolCd;
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
 * @param cnt
 */
public void setCnt(String cnt) {
	this.cnt = cnt;
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
 * @param bkgNoSplit
 */
public void setBkgNoSplit(String bkgNoSplit) {
	this.bkgNoSplit = bkgNoSplit;
}

/**
 * Column Info
 * @param mstBlSeq
 */
public void setMstBlSeq(String mstBlSeq) {
	this.mstBlSeq = mstBlSeq;
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
 * @param sumBl8
 */
public void setSumBl8(String sumBl8) {
	this.sumBl8 = sumBl8;
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
 * @param sumBl7
 */
public void setSumBl7(String sumBl7) {
	this.sumBl7 = sumBl7;
}

/**
 * Column Info
 * @param sumBl6
 */
public void setSumBl6(String sumBl6) {
	this.sumBl6 = sumBl6;
}

/**
 * Column Info
 * @param podTml
 */
public void setPodTml(String podTml) {
	this.podTml = podTml;
}

/**
 * Column Info
 * @param sumBl5
 */
public void setSumBl5(String sumBl5) {
	this.sumBl5 = sumBl5;
}

/**
 * Column Info
 * @param bKtSeq
 */
public void setBKtSeq(String bKtSeq) {
	this.bKtSeq = bKtSeq;
}

/**
 * Column Info
 * @param sumBl9
 */
public void setSumBl9(String sumBl9) {
	this.sumBl9 = sumBl9;
}

/**
 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
 * @param request
 */
public void fromRequest(HttpServletRequest request) {
	setNtfyA(JSPUtil.getParameter(request, "ntfy_a", ""));
	setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
	setElnoB(JSPUtil.getParameter(request, "elno_b", ""));
	setElnoA(JSPUtil.getParameter(request, "elno_a", ""));
	setTr(JSPUtil.getParameter(request, "tr", ""));
	setInBound(JSPUtil.getParameter(request, "in_bound", ""));
	setWgtValue(JSPUtil.getParameter(request, "wgt_value", ""));
	setPkgCode(JSPUtil.getParameter(request, "pkg_code", ""));
	setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
	setCneeN(JSPUtil.getParameter(request, "cnee_n", ""));
	setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	setKrBlAmdtStsCd(JSPUtil.getParameter(request, "kr_bl_amdt_sts_cd", ""));
	setKtSeq(JSPUtil.getParameter(request, "kt_seq", ""));
	setUsername(JSPUtil.getParameter(request, "username", ""));
	setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
	setBkgTpCd(JSPUtil.getParameter(request, "bkg_tp_cd", ""));
	setPreVvd(JSPUtil.getParameter(request, "pre_vvd", ""));
	setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
	setTpCd(JSPUtil.getParameter(request, "tp_cd", ""));
	setCusName(JSPUtil.getParameter(request, "cus_name", ""));
	setNtfyN(JSPUtil.getParameter(request, "ntfy_n", ""));
	setKtPort(JSPUtil.getParameter(request, "kt_port", ""));
	setWh(JSPUtil.getParameter(request, "wh", ""));
	setBondAreaCode(JSPUtil.getParameter(request, "bond_area_code", ""));
	setTrnsSeq(JSPUtil.getParameter(request, "trns_seq", ""));
	setSc(JSPUtil.getParameter(request, "sc", ""));
	setBac(JSPUtil.getParameter(request, "bac", ""));
	setPodLoc(JSPUtil.getParameter(request, "pod_loc", ""));
	setExptKcdTp(JSPUtil.getParameter(request, "expt_kcd_tp", ""));
	setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
	setBlMeasUtCd(JSPUtil.getParameter(request, "bl_meas_ut_cd", ""));
	setTransType(JSPUtil.getParameter(request, "trans_type", ""));
	setDescCode(JSPUtil.getParameter(request, "desc_code", ""));
	setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
	setKtSndDtChk(JSPUtil.getParameter(request, "kt_snd_dt_chk", ""));
	setBizRgstNo(JSPUtil.getParameter(request, "biz_rgst_no", ""));
	setWgtCode(JSPUtil.getParameter(request, "wgt_code", ""));
	setCneeA(JSPUtil.getParameter(request, "cnee_a", ""));
	setObType(JSPUtil.getParameter(request, "ob_type", ""));
	setMatch(JSPUtil.getParameter(request, "match", ""));
	setCntrTtlWgt(JSPUtil.getParameter(request, "cntr_ttl_wgt", ""));
	setTsPodCd(JSPUtil.getParameter(request, "ts_pod_cd", ""));
	setKtSts(JSPUtil.getParameter(request, "kt_sts", ""));
	setPolLoc(JSPUtil.getParameter(request, "pol_loc", ""));
	setSumBl1(JSPUtil.getParameter(request, "sum_bl1", ""));
	setSumBl2(JSPUtil.getParameter(request, "sum_bl2", ""));
	setSumBl3(JSPUtil.getParameter(request, "sum_bl3", ""));
	setSumBl4(JSPUtil.getParameter(request, "sum_bl4", ""));
	setCorrection(JSPUtil.getParameter(request, "correction", ""));
	setKcdTp(JSPUtil.getParameter(request, "kcd_tp", ""));
	setMrnType(JSPUtil.getParameter(request, "mrn_type", ""));
	setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
	setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
	setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
	setSumBl10(JSPUtil.getParameter(request, "sum_bl10", ""));
	setMfSndDt(JSPUtil.getParameter(request, "mf_snd_dt", ""));
	setSumBl11(JSPUtil.getParameter(request, "sum_bl11", ""));
	setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
	setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
	setBizNo(JSPUtil.getParameter(request, "biz_no", ""));
	setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
	setKrCstmsBndCd(JSPUtil.getParameter(request, "kr_cstms_bnd_cd", ""));
	setTsPolCd(JSPUtil.getParameter(request, "ts_pol_cd", ""));
	setPkgValue(JSPUtil.getParameter(request, "pkg_value", ""));
	setCnt(JSPUtil.getParameter(request, "cnt", ""));
	setShprN(JSPUtil.getParameter(request, "shpr_n", ""));
	setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
	setMstBlSeq(JSPUtil.getParameter(request, "mst_bl_seq", ""));
	setCntr(JSPUtil.getParameter(request, "cntr", ""));
	setSumBl8(JSPUtil.getParameter(request, "sum_bl8", ""));
	setShprA(JSPUtil.getParameter(request, "shpr_a", ""));
	setSumBl7(JSPUtil.getParameter(request, "sum_bl7", ""));
	setSumBl6(JSPUtil.getParameter(request, "sum_bl6", ""));
	setPodTml(JSPUtil.getParameter(request, "pod_tml", ""));
	setSumBl5(JSPUtil.getParameter(request, "sum_bl5", ""));
	setBKtSeq(JSPUtil.getParameter(request, "b_kt_seq", ""));
	setSumBl9(JSPUtil.getParameter(request, "sum_bl9", ""));
	setCBlNo(JSPUtil.getParameter(request, "c_bl_no", ""));
}

/**
 * Request 의 데이터를 VO 배열로 변환하여 반환.
 * @param request
 * @return BkgCstmsKrBlVO[]
 */
public BkgCstmsKrBlVO[] fromRequestGrid(HttpServletRequest request) {
	return fromRequestGrid(request, "");
}

/**
 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
 * @param request
 * @param prefix
 * @return BkgCstmsKrBlVO[]
 */
public BkgCstmsKrBlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
	BkgCstmsKrBlVO model = null;
	
	String[] tmp = request.getParameterValues(prefix + "ibflag");
		if(tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

	try {
		String[] ntfyA = (JSPUtil.getParameter(request, prefix	+ "ntfy_a", length));
		String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
		String[] elnoB = (JSPUtil.getParameter(request, prefix	+ "elno_b", length));
		String[] elnoA = (JSPUtil.getParameter(request, prefix	+ "elno_a", length));
		String[] tr = (JSPUtil.getParameter(request, prefix	+ "tr", length));
		String[] inBound = (JSPUtil.getParameter(request, prefix	+ "in_bound", length));
		String[] wgtValue = (JSPUtil.getParameter(request, prefix	+ "wgt_value", length));
		String[] pkgCode = (JSPUtil.getParameter(request, prefix	+ "pkg_code", length));
		String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
		String[] cneeN = (JSPUtil.getParameter(request, prefix	+ "cnee_n", length));
		String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
		String[] krBlAmdtStsCd = (JSPUtil.getParameter(request, prefix	+ "kr_bl_amdt_sts_cd", length));
		String[] ktSeq = (JSPUtil.getParameter(request, prefix	+ "kt_seq", length));
		String[] username = (JSPUtil.getParameter(request, prefix	+ "username", length));
		String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
		String[] bkgTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_tp_cd", length));
		String[] preVvd = (JSPUtil.getParameter(request, prefix	+ "pre_vvd", length));
		String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
		String[] tpCd = (JSPUtil.getParameter(request, prefix	+ "tp_cd", length));
		String[] cusName = (JSPUtil.getParameter(request, prefix	+ "cus_name", length));
		String[] ntfyN = (JSPUtil.getParameter(request, prefix	+ "ntfy_n", length));
		String[] ktPort = (JSPUtil.getParameter(request, prefix	+ "kt_port", length));
		String[] wh = (JSPUtil.getParameter(request, prefix	+ "wh", length));
		String[] bondAreaCode = (JSPUtil.getParameter(request, prefix	+ "bond_area_code", length));
		String[] trnsSeq = (JSPUtil.getParameter(request, prefix	+ "trns_seq", length));
		String[] sc = (JSPUtil.getParameter(request, prefix	+ "sc", length));
		String[] bac = (JSPUtil.getParameter(request, prefix	+ "bac", length));
		String[] podLoc = (JSPUtil.getParameter(request, prefix	+ "pod_loc", length));
		String[] exptKcdTp = (JSPUtil.getParameter(request, prefix	+ "expt_kcd_tp", length));
		String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
		String[] blMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "bl_meas_ut_cd", length));
		String[] transType = (JSPUtil.getParameter(request, prefix	+ "trans_type", length));
		String[] descCode = (JSPUtil.getParameter(request, prefix	+ "desc_code", length));
		String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
		String[] ktSndDtChk = (JSPUtil.getParameter(request, prefix	+ "kt_snd_dt_chk", length));
		String[] bizRgstNo = (JSPUtil.getParameter(request, prefix	+ "biz_rgst_no", length));
		String[] wgtCode = (JSPUtil.getParameter(request, prefix	+ "wgt_code", length));
		String[] cneeA = (JSPUtil.getParameter(request, prefix	+ "cnee_a", length));
		String[] obType = (JSPUtil.getParameter(request, prefix	+ "ob_type", length));
		String[] match = (JSPUtil.getParameter(request, prefix	+ "match", length));
		String[] cntrTtlWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_ttl_wgt", length));
		String[] tsPodCd = (JSPUtil.getParameter(request, prefix	+ "ts_pod_cd", length));
		String[] ktSts = (JSPUtil.getParameter(request, prefix	+ "kt_sts", length));
		String[] polLoc = (JSPUtil.getParameter(request, prefix	+ "pol_loc", length));
		String[] sumBl1 = (JSPUtil.getParameter(request, prefix	+ "sum_bl1", length));
		String[] sumBl2 = (JSPUtil.getParameter(request, prefix	+ "sum_bl2", length));
		String[] sumBl3 = (JSPUtil.getParameter(request, prefix	+ "sum_bl3", length));
		String[] sumBl4 = (JSPUtil.getParameter(request, prefix	+ "sum_bl4", length));
		String[] correction = (JSPUtil.getParameter(request, prefix	+ "correction", length));
		String[] kcdTp = (JSPUtil.getParameter(request, prefix	+ "kcd_tp", length));
		String[] mrnType = (JSPUtil.getParameter(request, prefix	+ "mrn_type", length));
		String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
		String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
		String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
		String[] sumBl10 = (JSPUtil.getParameter(request, prefix	+ "sum_bl10", length));
		String[] mfSndDt = (JSPUtil.getParameter(request, prefix	+ "mf_snd_dt", length));
		String[] sumBl11 = (JSPUtil.getParameter(request, prefix	+ "sum_bl11", length));
		String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
		String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
		String[] bizNo = (JSPUtil.getParameter(request, prefix	+ "biz_no", length));
		String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
		String[] krCstmsBndCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_bnd_cd", length));
		String[] tsPolCd = (JSPUtil.getParameter(request, prefix	+ "ts_pol_cd", length));
		String[] pkgValue = (JSPUtil.getParameter(request, prefix	+ "pkg_value", length));
		String[] cnt = (JSPUtil.getParameter(request, prefix	+ "cnt", length));
		String[] shprN = (JSPUtil.getParameter(request, prefix	+ "shpr_n", length));
		String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split", length));
		String[] mstBlSeq = (JSPUtil.getParameter(request, prefix	+ "mst_bl_seq", length));
		String[] cntr = (JSPUtil.getParameter(request, prefix	+ "cntr", length));
		String[] sumBl8 = (JSPUtil.getParameter(request, prefix	+ "sum_bl8", length));
		String[] shprA = (JSPUtil.getParameter(request, prefix	+ "shpr_a", length));
		String[] sumBl7 = (JSPUtil.getParameter(request, prefix	+ "sum_bl7", length));
		String[] sumBl6 = (JSPUtil.getParameter(request, prefix	+ "sum_bl6", length));
		String[] podTml = (JSPUtil.getParameter(request, prefix	+ "pod_tml", length));
		String[] sumBl5 = (JSPUtil.getParameter(request, prefix	+ "sum_bl5", length));
		String[] bKtSeq = (JSPUtil.getParameter(request, prefix	+ "b_kt_seq", length));
		String[] sumBl9 = (JSPUtil.getParameter(request, prefix	+ "sum_bl9", length));
		String[] cBlNo = (JSPUtil.getParameter(request, prefix	+ "c_bl_no", length));
		
		for (int i = 0; i < length; i++) {
			model = new BkgCstmsKrBlVO();
			if (ntfyA[i] != null)
				model.setNtfyA(ntfyA[i]);
			if (vslCd[i] != null)
				model.setVslCd(vslCd[i]);
			if (elnoB[i] != null)
				model.setElnoB(elnoB[i]);
			if (elnoA[i] != null)
				model.setElnoA(elnoA[i]);
			if (tr[i] != null)
				model.setTr(tr[i]);
			if (inBound[i] != null)
				model.setInBound(inBound[i]);
			if (wgtValue[i] != null)
				model.setWgtValue(wgtValue[i]);
			if (pkgCode[i] != null)
				model.setPkgCode(pkgCode[i]);
			if (blNo[i] != null)
				model.setBlNo(blNo[i]);
			if (cneeN[i] != null)
				model.setCneeN(cneeN[i]);
			if (pagerows[i] != null)
				model.setPagerows(pagerows[i]);
			if (krBlAmdtStsCd[i] != null)
				model.setKrBlAmdtStsCd(krBlAmdtStsCd[i]);
			if (ktSeq[i] != null)
				model.setKtSeq(ktSeq[i]);
			if (username[i] != null)
				model.setUsername(username[i]);
			if (polCd[i] != null)
				model.setPolCd(polCd[i]);
			if (bkgTpCd[i] != null)
				model.setBkgTpCd(bkgTpCd[i]);
			if (preVvd[i] != null)
				model.setPreVvd(preVvd[i]);
			if (wgtUtCd[i] != null)
				model.setWgtUtCd(wgtUtCd[i]);
			if (tpCd[i] != null)
				model.setTpCd(tpCd[i]);
			if (cusName[i] != null)
				model.setCusName(cusName[i]);
			if (ntfyN[i] != null)
				model.setNtfyN(ntfyN[i]);
			if (ktPort[i] != null)
				model.setKtPort(ktPort[i]);
			if (wh[i] != null)
				model.setWh(wh[i]);
			if (bondAreaCode[i] != null)
				model.setBondAreaCode(bondAreaCode[i]);
			if (trnsSeq[i] != null)
				model.setTrnsSeq(trnsSeq[i]);
			if (sc[i] != null)
				model.setSc(sc[i]);
			if (bac[i] != null)
				model.setBac(bac[i]);
			if (podLoc[i] != null)
				model.setPodLoc(podLoc[i]);
			if (exptKcdTp[i] != null)
				model.setExptKcdTp(exptKcdTp[i]);
			if (podCd[i] != null)
				model.setPodCd(podCd[i]);
			if (blMeasUtCd[i] != null)
				model.setBlMeasUtCd(blMeasUtCd[i]);
			if (transType[i] != null)
				model.setTransType(transType[i]);
			if (descCode[i] != null)
				model.setDescCode(descCode[i]);
			if (bkgNo[i] != null)
				model.setBkgNo(bkgNo[i]);
			if (ktSndDtChk[i] != null)
				model.setKtSndDtChk(ktSndDtChk[i]);
			if (bizRgstNo[i] != null)
				model.setBizRgstNo(bizRgstNo[i]);
			if (wgtCode[i] != null)
				model.setWgtCode(wgtCode[i]);
			if (cneeA[i] != null)
				model.setCneeA(cneeA[i]);
			if (obType[i] != null)
				model.setObType(obType[i]);
			if (match[i] != null)
				model.setMatch(match[i]);
			if (cntrTtlWgt[i] != null)
				model.setCntrTtlWgt(cntrTtlWgt[i]);
			if (tsPodCd[i] != null)
				model.setTsPodCd(tsPodCd[i]);
			if (ktSts[i] != null)
				model.setKtSts(ktSts[i]);
			if (polLoc[i] != null)
				model.setPolLoc(polLoc[i]);
			if (sumBl1[i] != null)
				model.setSumBl1(sumBl1[i]);
			if (sumBl2[i] != null)
				model.setSumBl2(sumBl2[i]);
			if (sumBl3[i] != null)
				model.setSumBl3(sumBl3[i]);
			if (sumBl4[i] != null)
				model.setSumBl4(sumBl4[i]);
			if (correction[i] != null)
				model.setCorrection(correction[i]);
			if (kcdTp[i] != null)
				model.setKcdTp(kcdTp[i]);
			if (mrnType[i] != null)
				model.setMrnType(mrnType[i]);
			if (ibflag[i] != null)
				model.setIbflag(ibflag[i]);
			if (usrId[i] != null)
				model.setUsrId(usrId[i]);
			if (cmdtCd[i] != null)
				model.setCmdtCd(cmdtCd[i]);
			if (sumBl10[i] != null)
				model.setSumBl10(sumBl10[i]);
			if (mfSndDt[i] != null)
				model.setMfSndDt(mfSndDt[i]);
			if (sumBl11[i] != null)
				model.setSumBl11(sumBl11[i]);
			if (measQty[i] != null)
				model.setMeasQty(measQty[i]);
			if (pckQty[i] != null)
				model.setPckQty(pckQty[i]);
			if (bizNo[i] != null)
				model.setBizNo(bizNo[i]);
			if (pckTpCd[i] != null)
				model.setPckTpCd(pckTpCd[i]);
			if (krCstmsBndCd[i] != null)
				model.setKrCstmsBndCd(krCstmsBndCd[i]);
			if (tsPolCd[i] != null)
				model.setTsPolCd(tsPolCd[i]);
			if (pkgValue[i] != null)
				model.setPkgValue(pkgValue[i]);
			if (cnt[i] != null)
				model.setCnt(cnt[i]);
			if (shprN[i] != null)
				model.setShprN(shprN[i]);
			if (bkgNoSplit[i] != null)
				model.setBkgNoSplit(bkgNoSplit[i]);
			if (mstBlSeq[i] != null)
				model.setMstBlSeq(mstBlSeq[i]);
			if (cntr[i] != null)
				model.setCntr(cntr[i]);
			if (sumBl8[i] != null)
				model.setSumBl8(sumBl8[i]);
			if (shprA[i] != null)
				model.setShprA(shprA[i]);
			if (sumBl7[i] != null)
				model.setSumBl7(sumBl7[i]);
			if (sumBl6[i] != null)
				model.setSumBl6(sumBl6[i]);
			if (podTml[i] != null)
				model.setPodTml(podTml[i]);
			if (sumBl5[i] != null)
				model.setSumBl5(sumBl5[i]);
			if (bKtSeq[i] != null)
				model.setBKtSeq(bKtSeq[i]);
			if (sumBl9[i] != null)
				model.setSumBl9(sumBl9[i]);
			if (cBlNo[i] != null)
				model.setCBlNo(cBlNo[i]);
			models.add(model);
		}

	} catch (Exception e) {
		return null;
	}
	return getBkgCstmsKrBlVOs();
}

/**
 * VO 배열을 반환
 * @return BkgCstmsKrBlVO[]
 */
public BkgCstmsKrBlVO[] getBkgCstmsKrBlVOs(){
	BkgCstmsKrBlVO[] vos = (BkgCstmsKrBlVO[])models.toArray(new BkgCstmsKrBlVO[models.size()]);
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
	this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.elnoB = this.elnoB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.elnoA = this.elnoA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.tr = this.tr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.inBound = this.inBound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.wgtValue = this.wgtValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.pkgCode = this.pkgCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.cneeN = this.cneeN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.krBlAmdtStsCd = this.krBlAmdtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.ktSeq = this.ktSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.username = this.username .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.bkgTpCd = this.bkgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.preVvd = this.preVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.tpCd = this.tpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.cusName = this.cusName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.ntfyN = this.ntfyN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.ktPort = this.ktPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.wh = this.wh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.bondAreaCode = this.bondAreaCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.trnsSeq = this.trnsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.sc = this.sc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.bac = this.bac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.podLoc = this.podLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.exptKcdTp = this.exptKcdTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.blMeasUtCd = this.blMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.transType = this.transType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.descCode = this.descCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.ktSndDtChk = this.ktSndDtChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.bizRgstNo = this.bizRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.wgtCode = this.wgtCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.cneeA = this.cneeA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.obType = this.obType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.match = this.match .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.cntrTtlWgt = this.cntrTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.tsPodCd = this.tsPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.ktSts = this.ktSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.polLoc = this.polLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.sumBl1 = this.sumBl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.sumBl2 = this.sumBl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.sumBl3 = this.sumBl3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.sumBl4 = this.sumBl4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.correction = this.correction .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.kcdTp = this.kcdTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.mrnType = this.mrnType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.sumBl10 = this.sumBl10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.mfSndDt = this.mfSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.sumBl11 = this.sumBl11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.bizNo = this.bizNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.krCstmsBndCd = this.krCstmsBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.tsPolCd = this.tsPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.pkgValue = this.pkgValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.cnt = this.cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.shprN = this.shprN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.mstBlSeq = this.mstBlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.cntr = this.cntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.sumBl8 = this.sumBl8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.shprA = this.shprA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.sumBl7 = this.sumBl7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.sumBl6 = this.sumBl6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.podTml = this.podTml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.sumBl5 = this.sumBl5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.bKtSeq = this.bKtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.sumBl9 = this.sumBl9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	this.cBlNo = this.cBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
}
}
