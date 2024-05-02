/*========================================================= 
*Copyright(c) 2016 CyberLogitec
*@FileName : AdvJpBlVO.java
*@FileTitle : AdvJpBlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.29  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo;

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

public class AdvJpBlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AdvJpBlVO> models = new ArrayList<AdvJpBlVO>();
	
	/* Column Info */
	private String corrRsnCd = null;
	/* Column Info */
	private String cyOprId = null;
	/* Column Info */
	private String cneeAddr = null;
	/* Column Info */
	private String ntfyFaxNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cneeCntCd = null;
	/* Column Info */
	private String rvisCntrCustTpCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String shprFaxNo = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String ntfyPhnNo = null;
	/* Column Info */
	private String bkgPorCd = null;
	/* Column Info */
	private String ntfyCntCd = null;
	/* Column Info */
	private String podDiv = null;
	/* Column Info */
	private String shprCntCd = null;
	/* Column Info */
	private String podSplitNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String tCmrKind = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String loclTsIndCd = null;
	/* Column Info */
	private String tSType = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String shprSeq = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String mstBl = null;
	/* Column Info */
	private String ntfySeq = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String lmtNo = null;
	/* Column Info */
	private String cneePhnNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String shprAddr = null;
	/* Column Info */
	private String corrRsn = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String bkgDelCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String podPostfix = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String bdrDt = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String blSplitNo = null;
	/* Column Info */
	private String loclTsFlg = null;
	/* Column Info */
	private String ntfyAddr = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String shprPhnNo = null;
	/* Column Info */
	private String cneeFaxNo = null;
	/* Column Info */
	private String polSplitNo = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String cneeSeq = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String jpCstmsTrnsCd = null;
	/* Column Info */
	private String onchangeFlag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AdvJpBlVO() {}

	public AdvJpBlVO(String ibflag, String pagerows, String bdrDt, String bdrFlg, String bkgCustTpCd, String bkgDelCd, String bkgPolCd, String bkgPorCd, String blNo, String blSplitNo, String cmdtCd, String cneeAddr, String cneeCntCd, String cneeFaxNo, String cneeNm, String cneePhnNo, String cneeSeq, String corrRsn, String corrRsnCd, String cyOprId, String dcgoFlg, String deTermCd, String fullMtyCd, String grsWgt, String imdgClssCd, String imdgUnNo, String jpCstmsTrnsCd, String lmtNo, String loclTsFlg, String loclTsIndCd, String measQty, String measUtCd, String mstBl, String ntfyAddr, String ntfyCntCd, String ntfyFaxNo, String ntfyNm, String ntfyPhnNo, String ntfySeq, String onchangeFlag, String pckQty, String pckTpCd, String podCd, String podDiv, String podPostfix, String podSplitNo, String polCd, String polSplitNo, String rcvTermCd, String rvisCntrCustTpCd, String shprAddr, String shprCntCd, String shprFaxNo, String shprNm, String shprPhnNo, String shprSeq, String tCmrKind, String tSType, String usrId, String vslEngNm, String vvd, String wgtUtCd) {
		this.corrRsnCd = corrRsnCd;
		this.cyOprId = cyOprId;
		this.cneeAddr = cneeAddr;
		this.ntfyFaxNo = ntfyFaxNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.cneeCntCd = cneeCntCd;
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
		this.polCd = polCd;
		this.wgtUtCd = wgtUtCd;
		this.shprFaxNo = shprFaxNo;
		this.bkgCustTpCd = bkgCustTpCd;
		this.imdgUnNo = imdgUnNo;
		this.ntfyPhnNo = ntfyPhnNo;
		this.bkgPorCd = bkgPorCd;
		this.ntfyCntCd = ntfyCntCd;
		this.podDiv = podDiv;
		this.shprCntCd = shprCntCd;
		this.podSplitNo = podSplitNo;
		this.vvd = vvd;
		this.tCmrKind = tCmrKind;
		this.podCd = podCd;
		this.loclTsIndCd = loclTsIndCd;
		this.tSType = tSType;
		this.fullMtyCd = fullMtyCd;
		this.shprSeq = shprSeq;
		this.imdgClssCd = imdgClssCd;
		this.grsWgt = grsWgt;
		this.mstBl = mstBl;
		this.ntfySeq = ntfySeq;
		this.bdrFlg = bdrFlg;
		this.lmtNo = lmtNo;
		this.cneePhnNo = cneePhnNo;
		this.ibflag = ibflag;
		this.shprAddr = shprAddr;
		this.corrRsn = corrRsn;
		this.vslEngNm = vslEngNm;
		this.usrId = usrId;
		this.bkgDelCd = bkgDelCd;
		this.cmdtCd = cmdtCd;
		this.podPostfix = podPostfix;
		this.dcgoFlg = dcgoFlg;
		this.measQty = measQty;
		this.bdrDt = bdrDt;
		this.pckQty = pckQty;
		this.shprNm = shprNm;
		this.rcvTermCd = rcvTermCd;
		this.measUtCd = measUtCd;
		this.pckTpCd = pckTpCd;
		this.blSplitNo = blSplitNo;
		this.loclTsFlg = loclTsFlg;
		this.ntfyAddr = ntfyAddr;
		this.bkgPolCd = bkgPolCd;
		this.shprPhnNo = shprPhnNo;
		this.cneeFaxNo = cneeFaxNo;
		this.polSplitNo = polSplitNo;
		this.ntfyNm = ntfyNm;
		this.deTermCd = deTermCd;
		this.cneeSeq = cneeSeq;
		this.cneeNm = cneeNm;
		this.jpCstmsTrnsCd = jpCstmsTrnsCd;
		this.onchangeFlag = onchangeFlag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("corr_rsn_cd", getCorrRsnCd());
		this.hashColumns.put("cy_opr_id", getCyOprId());
		this.hashColumns.put("cnee_addr", getCneeAddr());
		this.hashColumns.put("ntfy_fax_no", getNtfyFaxNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnee_cnt_cd", getCneeCntCd());
		this.hashColumns.put("rvis_cntr_cust_tp_cd", getRvisCntrCustTpCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("shpr_fax_no", getShprFaxNo());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("ntfy_phn_no", getNtfyPhnNo());
		this.hashColumns.put("bkg_por_cd", getBkgPorCd());
		this.hashColumns.put("ntfy_cnt_cd", getNtfyCntCd());
		this.hashColumns.put("pod_div", getPodDiv());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("pod_split_no", getPodSplitNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("t_cmr_kind", getTCmrKind());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("locl_ts_ind_cd", getLoclTsIndCd());
		this.hashColumns.put("t_s_type", getTSType());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("shpr_seq", getShprSeq());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("mst_bl", getMstBl());
		this.hashColumns.put("ntfy_seq", getNtfySeq());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("lmt_no", getLmtNo());
		this.hashColumns.put("cnee_phn_no", getCneePhnNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("shpr_addr", getShprAddr());
		this.hashColumns.put("corr_rsn", getCorrRsn());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("bkg_del_cd", getBkgDelCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("pod_postfix", getPodPostfix());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("bdr_dt", getBdrDt());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("bl_split_no", getBlSplitNo());
		this.hashColumns.put("locl_ts_flg", getLoclTsFlg());
		this.hashColumns.put("ntfy_addr", getNtfyAddr());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("shpr_phn_no", getShprPhnNo());
		this.hashColumns.put("cnee_fax_no", getCneeFaxNo());
		this.hashColumns.put("pol_split_no", getPolSplitNo());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("cnee_seq", getCneeSeq());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("jp_cstms_trns_cd", getJpCstmsTrnsCd());
		this.hashColumns.put("onchange_flag", getOnchangeFlag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("corr_rsn_cd", "corrRsnCd");
		this.hashFields.put("cy_opr_id", "cyOprId");
		this.hashFields.put("cnee_addr", "cneeAddr");
		this.hashFields.put("ntfy_fax_no", "ntfyFaxNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnee_cnt_cd", "cneeCntCd");
		this.hashFields.put("rvis_cntr_cust_tp_cd", "rvisCntrCustTpCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("shpr_fax_no", "shprFaxNo");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("ntfy_phn_no", "ntfyPhnNo");
		this.hashFields.put("bkg_por_cd", "bkgPorCd");
		this.hashFields.put("ntfy_cnt_cd", "ntfyCntCd");
		this.hashFields.put("pod_div", "podDiv");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("pod_split_no", "podSplitNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("t_cmr_kind", "tCmrKind");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("locl_ts_ind_cd", "loclTsIndCd");
		this.hashFields.put("t_s_type", "tSType");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("shpr_seq", "shprSeq");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("mst_bl", "mstBl");
		this.hashFields.put("ntfy_seq", "ntfySeq");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("lmt_no", "lmtNo");
		this.hashFields.put("cnee_phn_no", "cneePhnNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("shpr_addr", "shprAddr");
		this.hashFields.put("corr_rsn", "corrRsn");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("bkg_del_cd", "bkgDelCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("pod_postfix", "podPostfix");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("bdr_dt", "bdrDt");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("bl_split_no", "blSplitNo");
		this.hashFields.put("locl_ts_flg", "loclTsFlg");
		this.hashFields.put("ntfy_addr", "ntfyAddr");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("shpr_phn_no", "shprPhnNo");
		this.hashFields.put("cnee_fax_no", "cneeFaxNo");
		this.hashFields.put("pol_split_no", "polSplitNo");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("cnee_seq", "cneeSeq");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("jp_cstms_trns_cd", "jpCstmsTrnsCd");
		this.hashFields.put("onchange_flag", "onchangeFlag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return corrRsnCd
	 */
	public String getCorrRsnCd() {
		return this.corrRsnCd;
	}
	
	/**
	 * Column Info
	 * @return cyOprId
	 */
	public String getCyOprId() {
		return this.cyOprId;
	}
	
	/**
	 * Column Info
	 * @return cneeAddr
	 */
	public String getCneeAddr() {
		return this.cneeAddr;
	}
	
	/**
	 * Column Info
	 * @return ntfyFaxNo
	 */
	public String getNtfyFaxNo() {
		return this.ntfyFaxNo;
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
	 * @return cneeCntCd
	 */
	public String getCneeCntCd() {
		return this.cneeCntCd;
	}
	
	/**
	 * Column Info
	 * @return rvisCntrCustTpCd
	 */
	public String getRvisCntrCustTpCd() {
		return this.rvisCntrCustTpCd;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return shprFaxNo
	 */
	public String getShprFaxNo() {
		return this.shprFaxNo;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return ntfyPhnNo
	 */
	public String getNtfyPhnNo() {
		return this.ntfyPhnNo;
	}
	
	/**
	 * Column Info
	 * @return bkgPorCd
	 */
	public String getBkgPorCd() {
		return this.bkgPorCd;
	}
	
	/**
	 * Column Info
	 * @return ntfyCntCd
	 */
	public String getNtfyCntCd() {
		return this.ntfyCntCd;
	}
	
	/**
	 * Column Info
	 * @return podDiv
	 */
	public String getPodDiv() {
		return this.podDiv;
	}
	
	/**
	 * Column Info
	 * @return shprCntCd
	 */
	public String getShprCntCd() {
		return this.shprCntCd;
	}
	
	/**
	 * Column Info
	 * @return podSplitNo
	 */
	public String getPodSplitNo() {
		return this.podSplitNo;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return tCmrKind
	 */
	public String getTCmrKind() {
		return this.tCmrKind;
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
	 * @return loclTsIndCd
	 */
	public String getLoclTsIndCd() {
		return this.loclTsIndCd;
	}
	
	/**
	 * Column Info
	 * @return tSType
	 */
	public String getTSType() {
		return this.tSType;
	}
	
	/**
	 * Column Info
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @return shprSeq
	 */
	public String getShprSeq() {
		return this.shprSeq;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
	}
	
	/**
	 * Column Info
	 * @return mstBl
	 */
	public String getMstBl() {
		return this.mstBl;
	}
	
	/**
	 * Column Info
	 * @return ntfySeq
	 */
	public String getNtfySeq() {
		return this.ntfySeq;
	}
	
	/**
	 * Column Info
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return lmtNo
	 */
	public String getLmtNo() {
		return this.lmtNo;
	}
	
	/**
	 * Column Info
	 * @return cneePhnNo
	 */
	public String getCneePhnNo() {
		return this.cneePhnNo;
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
	 * @return shprAddr
	 */
	public String getShprAddr() {
		return this.shprAddr;
	}
	
	/**
	 * Column Info
	 * @return corrRsn
	 */
	public String getCorrRsn() {
		return this.corrRsn;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
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
	 * @return bkgDelCd
	 */
	public String getBkgDelCd() {
		return this.bkgDelCd;
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
	 * @return podPostfix
	 */
	public String getPodPostfix() {
		return this.podPostfix;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
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
	 * @return bdrDt
	 */
	public String getBdrDt() {
		return this.bdrDt;
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
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
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
	 * @return blSplitNo
	 */
	public String getBlSplitNo() {
		return this.blSplitNo;
	}
	
	/**
	 * Column Info
	 * @return loclTsFlg
	 */
	public String getLoclTsFlg() {
		return this.loclTsFlg;
	}
	
	/**
	 * Column Info
	 * @return ntfyAddr
	 */
	public String getNtfyAddr() {
		return this.ntfyAddr;
	}
	
	/**
	 * Column Info
	 * @return bkgPolCd
	 */
	public String getBkgPolCd() {
		return this.bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @return shprPhnNo
	 */
	public String getShprPhnNo() {
		return this.shprPhnNo;
	}
	
	/**
	 * Column Info
	 * @return cneeFaxNo
	 */
	public String getCneeFaxNo() {
		return this.cneeFaxNo;
	}
	
	/**
	 * Column Info
	 * @return polSplitNo
	 */
	public String getPolSplitNo() {
		return this.polSplitNo;
	}
	
	/**
	 * Column Info
	 * @return ntfyNm
	 */
	public String getNtfyNm() {
		return this.ntfyNm;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return cneeSeq
	 */
	public String getCneeSeq() {
		return this.cneeSeq;
	}
	
	/**
	 * Column Info
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return jpCstmsTrnsCd
	 */
	public String getJpCstmsTrnsCd() {
		return this.jpCstmsTrnsCd;
	}
	
	/**
	 * Column Info
	 * @return onchangeFlag
	 */
	public String getOnchangeFlag() {
		return this.onchangeFlag;
	}
	

	/**
	 * Column Info
	 * @param corrRsnCd
	 */
	public void setCorrRsnCd(String corrRsnCd) {
		this.corrRsnCd = corrRsnCd;
	}
	
	/**
	 * Column Info
	 * @param cyOprId
	 */
	public void setCyOprId(String cyOprId) {
		this.cyOprId = cyOprId;
	}
	
	/**
	 * Column Info
	 * @param cneeAddr
	 */
	public void setCneeAddr(String cneeAddr) {
		this.cneeAddr = cneeAddr;
	}
	
	/**
	 * Column Info
	 * @param ntfyFaxNo
	 */
	public void setNtfyFaxNo(String ntfyFaxNo) {
		this.ntfyFaxNo = ntfyFaxNo;
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
	 * @param cneeCntCd
	 */
	public void setCneeCntCd(String cneeCntCd) {
		this.cneeCntCd = cneeCntCd;
	}
	
	/**
	 * Column Info
	 * @param rvisCntrCustTpCd
	 */
	public void setRvisCntrCustTpCd(String rvisCntrCustTpCd) {
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param shprFaxNo
	 */
	public void setShprFaxNo(String shprFaxNo) {
		this.shprFaxNo = shprFaxNo;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param ntfyPhnNo
	 */
	public void setNtfyPhnNo(String ntfyPhnNo) {
		this.ntfyPhnNo = ntfyPhnNo;
	}
	
	/**
	 * Column Info
	 * @param bkgPorCd
	 */
	public void setBkgPorCd(String bkgPorCd) {
		this.bkgPorCd = bkgPorCd;
	}
	
	/**
	 * Column Info
	 * @param ntfyCntCd
	 */
	public void setNtfyCntCd(String ntfyCntCd) {
		this.ntfyCntCd = ntfyCntCd;
	}
	
	/**
	 * Column Info
	 * @param podDiv
	 */
	public void setPodDiv(String podDiv) {
		this.podDiv = podDiv;
	}
	
	/**
	 * Column Info
	 * @param shprCntCd
	 */
	public void setShprCntCd(String shprCntCd) {
		this.shprCntCd = shprCntCd;
	}
	
	/**
	 * Column Info
	 * @param podSplitNo
	 */
	public void setPodSplitNo(String podSplitNo) {
		this.podSplitNo = podSplitNo;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param tCmrKind
	 */
	public void setTCmrKind(String tCmrKind) {
		this.tCmrKind = tCmrKind;
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
	 * @param loclTsIndCd
	 */
	public void setLoclTsIndCd(String loclTsIndCd) {
		this.loclTsIndCd = loclTsIndCd;
	}
	
	/**
	 * Column Info
	 * @param tSType
	 */
	public void setTSType(String tSType) {
		this.tSType = tSType;
	}
	
	/**
	 * Column Info
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @param shprSeq
	 */
	public void setShprSeq(String shprSeq) {
		this.shprSeq = shprSeq;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
	}
	
	/**
	 * Column Info
	 * @param mstBl
	 */
	public void setMstBl(String mstBl) {
		this.mstBl = mstBl;
	}
	
	/**
	 * Column Info
	 * @param ntfySeq
	 */
	public void setNtfySeq(String ntfySeq) {
		this.ntfySeq = ntfySeq;
	}
	
	/**
	 * Column Info
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param lmtNo
	 */
	public void setLmtNo(String lmtNo) {
		this.lmtNo = lmtNo;
	}
	
	/**
	 * Column Info
	 * @param cneePhnNo
	 */
	public void setCneePhnNo(String cneePhnNo) {
		this.cneePhnNo = cneePhnNo;
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
	 * @param shprAddr
	 */
	public void setShprAddr(String shprAddr) {
		this.shprAddr = shprAddr;
	}
	
	/**
	 * Column Info
	 * @param corrRsn
	 */
	public void setCorrRsn(String corrRsn) {
		this.corrRsn = corrRsn;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
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
	 * @param bkgDelCd
	 */
	public void setBkgDelCd(String bkgDelCd) {
		this.bkgDelCd = bkgDelCd;
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
	 * @param podPostfix
	 */
	public void setPodPostfix(String podPostfix) {
		this.podPostfix = podPostfix;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
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
	 * @param bdrDt
	 */
	public void setBdrDt(String bdrDt) {
		this.bdrDt = bdrDt;
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
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
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
	 * @param blSplitNo
	 */
	public void setBlSplitNo(String blSplitNo) {
		this.blSplitNo = blSplitNo;
	}
	
	/**
	 * Column Info
	 * @param loclTsFlg
	 */
	public void setLoclTsFlg(String loclTsFlg) {
		this.loclTsFlg = loclTsFlg;
	}
	
	/**
	 * Column Info
	 * @param ntfyAddr
	 */
	public void setNtfyAddr(String ntfyAddr) {
		this.ntfyAddr = ntfyAddr;
	}
	
	/**
	 * Column Info
	 * @param bkgPolCd
	 */
	public void setBkgPolCd(String bkgPolCd) {
		this.bkgPolCd = bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @param shprPhnNo
	 */
	public void setShprPhnNo(String shprPhnNo) {
		this.shprPhnNo = shprPhnNo;
	}
	
	/**
	 * Column Info
	 * @param cneeFaxNo
	 */
	public void setCneeFaxNo(String cneeFaxNo) {
		this.cneeFaxNo = cneeFaxNo;
	}
	
	/**
	 * Column Info
	 * @param polSplitNo
	 */
	public void setPolSplitNo(String polSplitNo) {
		this.polSplitNo = polSplitNo;
	}
	
	/**
	 * Column Info
	 * @param ntfyNm
	 */
	public void setNtfyNm(String ntfyNm) {
		this.ntfyNm = ntfyNm;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param cneeSeq
	 */
	public void setCneeSeq(String cneeSeq) {
		this.cneeSeq = cneeSeq;
	}
	
	/**
	 * Column Info
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param jpCstmsTrnsCd
	 */
	public void setJpCstmsTrnsCd(String jpCstmsTrnsCd) {
		this.jpCstmsTrnsCd = jpCstmsTrnsCd;
	}
	
	/**
	 * Column Info
	 * @param onchangeFlag
	 */
	public void setOnchangeFlag(String onchangeFlag) {
		this.onchangeFlag = onchangeFlag;
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
		setCorrRsnCd(JSPUtil.getParameter(request, prefix + "corr_rsn_cd", ""));
		setCyOprId(JSPUtil.getParameter(request, prefix + "cy_opr_id", ""));
		setCneeAddr(JSPUtil.getParameter(request, prefix + "cnee_addr", ""));
		setNtfyFaxNo(JSPUtil.getParameter(request, prefix + "ntfy_fax_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCneeCntCd(JSPUtil.getParameter(request, prefix + "cnee_cnt_cd", ""));
		setRvisCntrCustTpCd(JSPUtil.getParameter(request, prefix + "rvis_cntr_cust_tp_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setShprFaxNo(JSPUtil.getParameter(request, prefix + "shpr_fax_no", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setNtfyPhnNo(JSPUtil.getParameter(request, prefix + "ntfy_phn_no", ""));
		setBkgPorCd(JSPUtil.getParameter(request, prefix + "bkg_por_cd", ""));
		setNtfyCntCd(JSPUtil.getParameter(request, prefix + "ntfy_cnt_cd", ""));
		setPodDiv(JSPUtil.getParameter(request, prefix + "pod_div", ""));
		setShprCntCd(JSPUtil.getParameter(request, prefix + "shpr_cnt_cd", ""));
		setPodSplitNo(JSPUtil.getParameter(request, prefix + "pod_split_no", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setTCmrKind(JSPUtil.getParameter(request, prefix + "t_cmr_kind", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setLoclTsIndCd(JSPUtil.getParameter(request, prefix + "locl_ts_ind_cd", ""));
		setTSType(JSPUtil.getParameter(request, prefix + "t_s_type", ""));
		setFullMtyCd(JSPUtil.getParameter(request, prefix + "full_mty_cd", ""));
		setShprSeq(JSPUtil.getParameter(request, prefix + "shpr_seq", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setMstBl(JSPUtil.getParameter(request, prefix + "mst_bl", ""));
		setNtfySeq(JSPUtil.getParameter(request, prefix + "ntfy_seq", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setLmtNo(JSPUtil.getParameter(request, prefix + "lmt_no", ""));
		setCneePhnNo(JSPUtil.getParameter(request, prefix + "cnee_phn_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setShprAddr(JSPUtil.getParameter(request, prefix + "shpr_addr", ""));
		setCorrRsn(JSPUtil.getParameter(request, prefix + "corr_rsn", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setBkgDelCd(JSPUtil.getParameter(request, prefix + "bkg_del_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setPodPostfix(JSPUtil.getParameter(request, prefix + "pod_postfix", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setBdrDt(JSPUtil.getParameter(request, prefix + "bdr_dt", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setBlSplitNo(JSPUtil.getParameter(request, prefix + "bl_split_no", ""));
		setLoclTsFlg(JSPUtil.getParameter(request, prefix + "locl_ts_flg", ""));
		setNtfyAddr(JSPUtil.getParameter(request, prefix + "ntfy_addr", ""));
		setBkgPolCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cd", ""));
		setShprPhnNo(JSPUtil.getParameter(request, prefix + "shpr_phn_no", ""));
		setCneeFaxNo(JSPUtil.getParameter(request, prefix + "cnee_fax_no", ""));
		setPolSplitNo(JSPUtil.getParameter(request, prefix + "pol_split_no", ""));
		setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setCneeSeq(JSPUtil.getParameter(request, prefix + "cnee_seq", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setJpCstmsTrnsCd(JSPUtil.getParameter(request, prefix + "jp_cstms_trns_cd", ""));
		setOnchangeFlag(JSPUtil.getParameter(request, prefix + "onchange_flag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AdvJpBlVO[]
	 */
	public AdvJpBlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AdvJpBlVO[]
	 */
	public AdvJpBlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AdvJpBlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] corrRsnCd = (JSPUtil.getParameter(request, prefix	+ "corr_rsn_cd", length));
			String[] cyOprId = (JSPUtil.getParameter(request, prefix	+ "cy_opr_id", length));
			String[] cneeAddr = (JSPUtil.getParameter(request, prefix	+ "cnee_addr", length));
			String[] ntfyFaxNo = (JSPUtil.getParameter(request, prefix	+ "ntfy_fax_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cneeCntCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cnt_cd", length));
			String[] rvisCntrCustTpCd = (JSPUtil.getParameter(request, prefix	+ "rvis_cntr_cust_tp_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] shprFaxNo = (JSPUtil.getParameter(request, prefix	+ "shpr_fax_no", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] ntfyPhnNo = (JSPUtil.getParameter(request, prefix	+ "ntfy_phn_no", length));
			String[] bkgPorCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_cd", length));
			String[] ntfyCntCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_cnt_cd", length));
			String[] podDiv = (JSPUtil.getParameter(request, prefix	+ "pod_div", length));
			String[] shprCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd", length));
			String[] podSplitNo = (JSPUtil.getParameter(request, prefix	+ "pod_split_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] tCmrKind = (JSPUtil.getParameter(request, prefix	+ "t_cmr_kind", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] loclTsIndCd = (JSPUtil.getParameter(request, prefix	+ "locl_ts_ind_cd", length));
			String[] tSType = (JSPUtil.getParameter(request, prefix	+ "t_s_type", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] shprSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_seq", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] mstBl = (JSPUtil.getParameter(request, prefix	+ "mst_bl", length));
			String[] ntfySeq = (JSPUtil.getParameter(request, prefix	+ "ntfy_seq", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] lmtNo = (JSPUtil.getParameter(request, prefix	+ "lmt_no", length));
			String[] cneePhnNo = (JSPUtil.getParameter(request, prefix	+ "cnee_phn_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] shprAddr = (JSPUtil.getParameter(request, prefix	+ "shpr_addr", length));
			String[] corrRsn = (JSPUtil.getParameter(request, prefix	+ "corr_rsn", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] bkgDelCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] podPostfix = (JSPUtil.getParameter(request, prefix	+ "pod_postfix", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] bdrDt = (JSPUtil.getParameter(request, prefix	+ "bdr_dt", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] blSplitNo = (JSPUtil.getParameter(request, prefix	+ "bl_split_no", length));
			String[] loclTsFlg = (JSPUtil.getParameter(request, prefix	+ "locl_ts_flg", length));
			String[] ntfyAddr = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] shprPhnNo = (JSPUtil.getParameter(request, prefix	+ "shpr_phn_no", length));
			String[] cneeFaxNo = (JSPUtil.getParameter(request, prefix	+ "cnee_fax_no", length));
			String[] polSplitNo = (JSPUtil.getParameter(request, prefix	+ "pol_split_no", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] cneeSeq = (JSPUtil.getParameter(request, prefix	+ "cnee_seq", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] jpCstmsTrnsCd = (JSPUtil.getParameter(request, prefix	+ "jp_cstms_trns_cd", length));
			String[] onchangeFlag = (JSPUtil.getParameter(request, prefix	+ "onchange_flag", length));
			
			for (int i = 0; i < length; i++) {
				model = new AdvJpBlVO();
				if (corrRsnCd[i] != null)
					model.setCorrRsnCd(corrRsnCd[i]);
				if (cyOprId[i] != null)
					model.setCyOprId(cyOprId[i]);
				if (cneeAddr[i] != null)
					model.setCneeAddr(cneeAddr[i]);
				if (ntfyFaxNo[i] != null)
					model.setNtfyFaxNo(ntfyFaxNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cneeCntCd[i] != null)
					model.setCneeCntCd(cneeCntCd[i]);
				if (rvisCntrCustTpCd[i] != null)
					model.setRvisCntrCustTpCd(rvisCntrCustTpCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (shprFaxNo[i] != null)
					model.setShprFaxNo(shprFaxNo[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (ntfyPhnNo[i] != null)
					model.setNtfyPhnNo(ntfyPhnNo[i]);
				if (bkgPorCd[i] != null)
					model.setBkgPorCd(bkgPorCd[i]);
				if (ntfyCntCd[i] != null)
					model.setNtfyCntCd(ntfyCntCd[i]);
				if (podDiv[i] != null)
					model.setPodDiv(podDiv[i]);
				if (shprCntCd[i] != null)
					model.setShprCntCd(shprCntCd[i]);
				if (podSplitNo[i] != null)
					model.setPodSplitNo(podSplitNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (tCmrKind[i] != null)
					model.setTCmrKind(tCmrKind[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (loclTsIndCd[i] != null)
					model.setLoclTsIndCd(loclTsIndCd[i]);
				if (tSType[i] != null)
					model.setTSType(tSType[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (shprSeq[i] != null)
					model.setShprSeq(shprSeq[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (mstBl[i] != null)
					model.setMstBl(mstBl[i]);
				if (ntfySeq[i] != null)
					model.setNtfySeq(ntfySeq[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (lmtNo[i] != null)
					model.setLmtNo(lmtNo[i]);
				if (cneePhnNo[i] != null)
					model.setCneePhnNo(cneePhnNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (shprAddr[i] != null)
					model.setShprAddr(shprAddr[i]);
				if (corrRsn[i] != null)
					model.setCorrRsn(corrRsn[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (bkgDelCd[i] != null)
					model.setBkgDelCd(bkgDelCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (podPostfix[i] != null)
					model.setPodPostfix(podPostfix[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (bdrDt[i] != null)
					model.setBdrDt(bdrDt[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (blSplitNo[i] != null)
					model.setBlSplitNo(blSplitNo[i]);
				if (loclTsFlg[i] != null)
					model.setLoclTsFlg(loclTsFlg[i]);
				if (ntfyAddr[i] != null)
					model.setNtfyAddr(ntfyAddr[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (shprPhnNo[i] != null)
					model.setShprPhnNo(shprPhnNo[i]);
				if (cneeFaxNo[i] != null)
					model.setCneeFaxNo(cneeFaxNo[i]);
				if (polSplitNo[i] != null)
					model.setPolSplitNo(polSplitNo[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (cneeSeq[i] != null)
					model.setCneeSeq(cneeSeq[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (jpCstmsTrnsCd[i] != null)
					model.setJpCstmsTrnsCd(jpCstmsTrnsCd[i]);
				if (onchangeFlag[i] != null)
					model.setOnchangeFlag(onchangeFlag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAdvJpBlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AdvJpBlVO[]
	 */
	public AdvJpBlVO[] getAdvJpBlVOs(){
		AdvJpBlVO[] vos = (AdvJpBlVO[])models.toArray(new AdvJpBlVO[models.size()]);
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
		this.corrRsnCd = this.corrRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cyOprId = this.cyOprId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr = this.cneeAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyFaxNo = this.ntfyFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCntCd = this.cneeCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCntrCustTpCd = this.rvisCntrCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprFaxNo = this.shprFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyPhnNo = this.ntfyPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorCd = this.bkgPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCntCd = this.ntfyCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podDiv = this.podDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd = this.shprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podSplitNo = this.podSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tCmrKind = this.tCmrKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTsIndCd = this.loclTsIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tSType = this.tSType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprSeq = this.shprSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBl = this.mstBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfySeq = this.ntfySeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmtNo = this.lmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneePhnNo = this.cneePhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr = this.shprAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrRsn = this.corrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCd = this.bkgDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podPostfix = this.podPostfix .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrDt = this.bdrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSplitNo = this.blSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTsFlg = this.loclTsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr = this.ntfyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprPhnNo = this.shprPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeFaxNo = this.cneeFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polSplitNo = this.polSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeSeq = this.cneeSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpCstmsTrnsCd = this.jpCstmsTrnsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onchangeFlag = this.onchangeFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
