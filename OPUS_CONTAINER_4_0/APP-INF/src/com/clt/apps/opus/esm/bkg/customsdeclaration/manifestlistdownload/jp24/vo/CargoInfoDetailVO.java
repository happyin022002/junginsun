/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoInfoDetailVO.java
*@FileTitle : CargoInfoDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.29  
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

public class CargoInfoDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CargoInfoDetailVO> models = new ArrayList<CargoInfoDetailVO>();
	
	/* Column Info */
	private String cneeAddr = null;
	/* Column Info */
	private String errInfo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String sc108Rst = null;
	/* Column Info */
	private String sDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cneeCntCd = null;
	/* Column Info */
	private String rvisCntrCustTpCd = null;
	/* Column Info */
	private String bkgPodCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String cmdtHsCd = null;
	/* Column Info */
	private String ntfyPhnNo = null;
	/* Column Info */
	private String ntfyCntCd = null;
	/* Column Info */
	private String podDiv = null;
	/* Column Info */
	private String shprCntCd = null;
	/* Column Info */
	private String unNo = null;
	/* Column Info */
	private String sc108Dt = null;
	/* Column Info */
	private String tCmrKind = null;
	/* Column Info */
	private String tSType = null;
	/* Column Info */
	private String vvdPodCd = null;
	/* Column Info */
	private String mstBl = null;
	/* Column Info */
	private String scmrRst = null;
	/* Column Info */
	private String mkDesc = null;
	/* Column Info */
	private String cneePhnNo = null;
	/* Column Info */
	private String samrRst = null;
	/* Column Info */
	private String samrDt = null;
	/* Column Info */
	private String sc108RstDtl = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String shprAddr = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String bkgDelCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String sa111Dt = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String sInfo = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String aCmrKind = null;
	/* Column Info */
	private String ntfyAddr = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String shprPhnNo = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String imdgCls = null;
	/* Column Info */
	private String vvdPolCd = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String sa111Rst = null;
	/* Column Info */
	private String tamrRst = null;
	/* Column Info */
	private String scmrDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String aSType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CargoInfoDetailVO() {}

	public CargoInfoDetailVO(String ibflag, String pagerows, String seq, String blNo, String mstBl, String bkgPolCd, String vvdPolCd, String bkgPodCd, String vvdPodCd, String bkgDelCd, String aSType, String aCmrKind, String tSType, String tCmrKind, String sDt, String samrRst, String tamrRst, String samrDt, String sa111Rst, String sa111Dt, String scmrRst, String scmrDt, String sc108Rst, String sc108RstDtl, String sc108Dt, String shprNm, String shprAddr, String shprCntCd, String shprPhnNo, String cneeNm, String cneeAddr, String cneeCntCd, String cneePhnNo, String ntfyNm, String ntfyAddr, String ntfyCntCd, String ntfyPhnNo, String cmdtCd, String cmdtHsCd, String mkDesc, String pckQty, String pckTpCd, String actWgt, String wgtUtCd, String measQty, String measUtCd, String imdgCls, String unNo, String cntrNo, String podDiv, String rvisCntrCustTpCd, String errInfo, String sInfo, String usrId) {
		this.cneeAddr = cneeAddr;
		this.errInfo = errInfo;
		this.blNo = blNo;
		this.sc108Rst = sc108Rst;
		this.sDt = sDt;
		this.pagerows = pagerows;
		this.cneeCntCd = cneeCntCd;
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
		this.bkgPodCd = bkgPodCd;
		this.wgtUtCd = wgtUtCd;
		this.cmdtHsCd = cmdtHsCd;
		this.ntfyPhnNo = ntfyPhnNo;
		this.ntfyCntCd = ntfyCntCd;
		this.podDiv = podDiv;
		this.shprCntCd = shprCntCd;
		this.unNo = unNo;
		this.sc108Dt = sc108Dt;
		this.tCmrKind = tCmrKind;
		this.tSType = tSType;
		this.vvdPodCd = vvdPodCd;
		this.mstBl = mstBl;
		this.scmrRst = scmrRst;
		this.mkDesc = mkDesc;
		this.cneePhnNo = cneePhnNo;
		this.samrRst = samrRst;
		this.samrDt = samrDt;
		this.sc108RstDtl = sc108RstDtl;
		this.ibflag = ibflag;
		this.shprAddr = shprAddr;
		this.usrId = usrId;
		this.bkgDelCd = bkgDelCd;
		this.cmdtCd = cmdtCd;
		this.measQty = measQty;
		this.sa111Dt = sa111Dt;
		this.pckQty = pckQty;
		this.shprNm = shprNm;
		this.sInfo = sInfo;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
		this.aCmrKind = aCmrKind;
		this.ntfyAddr = ntfyAddr;
		this.bkgPolCd = bkgPolCd;
		this.shprPhnNo = shprPhnNo;
		this.ntfyNm = ntfyNm;
		this.imdgCls = imdgCls;
		this.vvdPolCd = vvdPolCd;
		this.actWgt = actWgt;
		this.cneeNm = cneeNm;
		this.sa111Rst = sa111Rst;
		this.tamrRst = tamrRst;
		this.scmrDt = scmrDt;
		this.cntrNo = cntrNo;
		this.seq = seq;
		this.aSType = aSType;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnee_addr", getCneeAddr());
		this.hashColumns.put("err_info", getErrInfo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("sc108_rst", getSc108Rst());
		this.hashColumns.put("s_dt", getSDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnee_cnt_cd", getCneeCntCd());
		this.hashColumns.put("rvis_cntr_cust_tp_cd", getRvisCntrCustTpCd());
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("cmdt_hs_cd", getCmdtHsCd());
		this.hashColumns.put("ntfy_phn_no", getNtfyPhnNo());
		this.hashColumns.put("ntfy_cnt_cd", getNtfyCntCd());
		this.hashColumns.put("pod_div", getPodDiv());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("un_no", getUnNo());
		this.hashColumns.put("sc108_dt", getSc108Dt());
		this.hashColumns.put("t_cmr_kind", getTCmrKind());
		this.hashColumns.put("t_s_type", getTSType());
		this.hashColumns.put("vvd_pod_cd", getVvdPodCd());
		this.hashColumns.put("mst_bl", getMstBl());
		this.hashColumns.put("scmr_rst", getScmrRst());
		this.hashColumns.put("mk_desc", getMkDesc());
		this.hashColumns.put("cnee_phn_no", getCneePhnNo());
		this.hashColumns.put("samr_rst", getSamrRst());
		this.hashColumns.put("samr_dt", getSamrDt());
		this.hashColumns.put("sc108_rst_dtl", getSc108RstDtl());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("shpr_addr", getShprAddr());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("bkg_del_cd", getBkgDelCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("sa111_dt", getSa111Dt());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("s_info", getSInfo());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("a_cmr_kind", getACmrKind());
		this.hashColumns.put("ntfy_addr", getNtfyAddr());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("shpr_phn_no", getShprPhnNo());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("imdg_cls", getImdgCls());
		this.hashColumns.put("vvd_pol_cd", getVvdPolCd());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("sa111_rst", getSa111Rst());
		this.hashColumns.put("tamr_rst", getTamrRst());
		this.hashColumns.put("scmr_dt", getScmrDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("a_s_type", getASType());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnee_addr", "cneeAddr");
		this.hashFields.put("err_info", "errInfo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("sc108_rst", "sc108Rst");
		this.hashFields.put("s_dt", "sDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnee_cnt_cd", "cneeCntCd");
		this.hashFields.put("rvis_cntr_cust_tp_cd", "rvisCntrCustTpCd");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("cmdt_hs_cd", "cmdtHsCd");
		this.hashFields.put("ntfy_phn_no", "ntfyPhnNo");
		this.hashFields.put("ntfy_cnt_cd", "ntfyCntCd");
		this.hashFields.put("pod_div", "podDiv");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("un_no", "unNo");
		this.hashFields.put("sc108_dt", "sc108Dt");
		this.hashFields.put("t_cmr_kind", "tCmrKind");
		this.hashFields.put("t_s_type", "tSType");
		this.hashFields.put("vvd_pod_cd", "vvdPodCd");
		this.hashFields.put("mst_bl", "mstBl");
		this.hashFields.put("scmr_rst", "scmrRst");
		this.hashFields.put("mk_desc", "mkDesc");
		this.hashFields.put("cnee_phn_no", "cneePhnNo");
		this.hashFields.put("samr_rst", "samrRst");
		this.hashFields.put("samr_dt", "samrDt");
		this.hashFields.put("sc108_rst_dtl", "sc108RstDtl");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("shpr_addr", "shprAddr");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("bkg_del_cd", "bkgDelCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("sa111_dt", "sa111Dt");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("s_info", "sInfo");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("a_cmr_kind", "aCmrKind");
		this.hashFields.put("ntfy_addr", "ntfyAddr");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("shpr_phn_no", "shprPhnNo");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("imdg_cls", "imdgCls");
		this.hashFields.put("vvd_pol_cd", "vvdPolCd");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("sa111_rst", "sa111Rst");
		this.hashFields.put("tamr_rst", "tamrRst");
		this.hashFields.put("scmr_dt", "scmrDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("a_s_type", "aSType");
		return this.hashFields;
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
	 * @return errInfo
	 */
	public String getErrInfo() {
		return this.errInfo;
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
	 * @return sc108Rst
	 */
	public String getSc108Rst() {
		return this.sc108Rst;
	}
	
	/**
	 * Column Info
	 * @return sDt
	 */
	public String getSDt() {
		return this.sDt;
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
	 * @return bkgPodCd
	 */
	public String getBkgPodCd() {
		return this.bkgPodCd;
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
	 * @return cmdtHsCd
	 */
	public String getCmdtHsCd() {
		return this.cmdtHsCd;
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
	 * @return unNo
	 */
	public String getUnNo() {
		return this.unNo;
	}
	
	/**
	 * Column Info
	 * @return sc108Dt
	 */
	public String getSc108Dt() {
		return this.sc108Dt;
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
	 * @return tSType
	 */
	public String getTSType() {
		return this.tSType;
	}
	
	/**
	 * Column Info
	 * @return vvdPodCd
	 */
	public String getVvdPodCd() {
		return this.vvdPodCd;
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
	 * @return scmrRst
	 */
	public String getScmrRst() {
		return this.scmrRst;
	}
	
	/**
	 * Column Info
	 * @return mkDesc
	 */
	public String getMkDesc() {
		return this.mkDesc;
	}
	
	/**
	 * Column Info
	 * @return cneePhnNo
	 */
	public String getCneePhnNo() {
		return this.cneePhnNo;
	}
	
	/**
	 * Column Info
	 * @return samrRst
	 */
	public String getSamrRst() {
		return this.samrRst;
	}
	
	/**
	 * Column Info
	 * @return samrDt
	 */
	public String getSamrDt() {
		return this.samrDt;
	}
	
	/**
	 * Column Info
	 * @return sc108RstDtl
	 */
	public String getSc108RstDtl() {
		return this.sc108RstDtl;
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
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return sa111Dt
	 */
	public String getSa111Dt() {
		return this.sa111Dt;
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
	 * @return sInfo
	 */
	public String getSInfo() {
		return this.sInfo;
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
	 * @return aCmrKind
	 */
	public String getACmrKind() {
		return this.aCmrKind;
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
	 * @return ntfyNm
	 */
	public String getNtfyNm() {
		return this.ntfyNm;
	}
	
	/**
	 * Column Info
	 * @return imdgCls
	 */
	public String getImdgCls() {
		return this.imdgCls;
	}
	
	/**
	 * Column Info
	 * @return vvdPolCd
	 */
	public String getVvdPolCd() {
		return this.vvdPolCd;
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
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return sa111Rst
	 */
	public String getSa111Rst() {
		return this.sa111Rst;
	}
	
	/**
	 * Column Info
	 * @return tamrRst
	 */
	public String getTamrRst() {
		return this.tamrRst;
	}
	
	/**
	 * Column Info
	 * @return scmrDt
	 */
	public String getScmrDt() {
		return this.scmrDt;
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
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return aSType
	 */
	public String getASType() {
		return this.aSType;
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
	 * @param errInfo
	 */
	public void setErrInfo(String errInfo) {
		this.errInfo = errInfo;
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
	 * @param sc108Rst
	 */
	public void setSc108Rst(String sc108Rst) {
		this.sc108Rst = sc108Rst;
	}
	
	/**
	 * Column Info
	 * @param sDt
	 */
	public void setSDt(String sDt) {
		this.sDt = sDt;
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
	 * @param bkgPodCd
	 */
	public void setBkgPodCd(String bkgPodCd) {
		this.bkgPodCd = bkgPodCd;
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
	 * @param cmdtHsCd
	 */
	public void setCmdtHsCd(String cmdtHsCd) {
		this.cmdtHsCd = cmdtHsCd;
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
	 * @param unNo
	 */
	public void setUnNo(String unNo) {
		this.unNo = unNo;
	}
	
	/**
	 * Column Info
	 * @param sc108Dt
	 */
	public void setSc108Dt(String sc108Dt) {
		this.sc108Dt = sc108Dt;
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
	 * @param tSType
	 */
	public void setTSType(String tSType) {
		this.tSType = tSType;
	}
	
	/**
	 * Column Info
	 * @param vvdPodCd
	 */
	public void setVvdPodCd(String vvdPodCd) {
		this.vvdPodCd = vvdPodCd;
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
	 * @param scmrRst
	 */
	public void setScmrRst(String scmrRst) {
		this.scmrRst = scmrRst;
	}
	
	/**
	 * Column Info
	 * @param mkDesc
	 */
	public void setMkDesc(String mkDesc) {
		this.mkDesc = mkDesc;
	}
	
	/**
	 * Column Info
	 * @param cneePhnNo
	 */
	public void setCneePhnNo(String cneePhnNo) {
		this.cneePhnNo = cneePhnNo;
	}
	
	/**
	 * Column Info
	 * @param samrRst
	 */
	public void setSamrRst(String samrRst) {
		this.samrRst = samrRst;
	}
	
	/**
	 * Column Info
	 * @param samrDt
	 */
	public void setSamrDt(String samrDt) {
		this.samrDt = samrDt;
	}
	
	/**
	 * Column Info
	 * @param sc108RstDtl
	 */
	public void setSc108RstDtl(String sc108RstDtl) {
		this.sc108RstDtl = sc108RstDtl;
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
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param sa111Dt
	 */
	public void setSa111Dt(String sa111Dt) {
		this.sa111Dt = sa111Dt;
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
	 * @param sInfo
	 */
	public void setSInfo(String sInfo) {
		this.sInfo = sInfo;
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
	 * @param aCmrKind
	 */
	public void setACmrKind(String aCmrKind) {
		this.aCmrKind = aCmrKind;
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
	 * @param ntfyNm
	 */
	public void setNtfyNm(String ntfyNm) {
		this.ntfyNm = ntfyNm;
	}
	
	/**
	 * Column Info
	 * @param imdgCls
	 */
	public void setImdgCls(String imdgCls) {
		this.imdgCls = imdgCls;
	}
	
	/**
	 * Column Info
	 * @param vvdPolCd
	 */
	public void setVvdPolCd(String vvdPolCd) {
		this.vvdPolCd = vvdPolCd;
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
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param sa111Rst
	 */
	public void setSa111Rst(String sa111Rst) {
		this.sa111Rst = sa111Rst;
	}
	
	/**
	 * Column Info
	 * @param tamrRst
	 */
	public void setTamrRst(String tamrRst) {
		this.tamrRst = tamrRst;
	}
	
	/**
	 * Column Info
	 * @param scmrDt
	 */
	public void setScmrDt(String scmrDt) {
		this.scmrDt = scmrDt;
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
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param aSType
	 */
	public void setASType(String aSType) {
		this.aSType = aSType;
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
		setCneeAddr(JSPUtil.getParameter(request, prefix + "cnee_addr", ""));
		setErrInfo(JSPUtil.getParameter(request, prefix + "err_info", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setSc108Rst(JSPUtil.getParameter(request, prefix + "sc108_rst", ""));
		setSDt(JSPUtil.getParameter(request, prefix + "s_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCneeCntCd(JSPUtil.getParameter(request, prefix + "cnee_cnt_cd", ""));
		setRvisCntrCustTpCd(JSPUtil.getParameter(request, prefix + "rvis_cntr_cust_tp_cd", ""));
		setBkgPodCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setCmdtHsCd(JSPUtil.getParameter(request, prefix + "cmdt_hs_cd", ""));
		setNtfyPhnNo(JSPUtil.getParameter(request, prefix + "ntfy_phn_no", ""));
		setNtfyCntCd(JSPUtil.getParameter(request, prefix + "ntfy_cnt_cd", ""));
		setPodDiv(JSPUtil.getParameter(request, prefix + "pod_div", ""));
		setShprCntCd(JSPUtil.getParameter(request, prefix + "shpr_cnt_cd", ""));
		setUnNo(JSPUtil.getParameter(request, prefix + "un_no", ""));
		setSc108Dt(JSPUtil.getParameter(request, prefix + "sc108_dt", ""));
		setTCmrKind(JSPUtil.getParameter(request, prefix + "t_cmr_kind", ""));
		setTSType(JSPUtil.getParameter(request, prefix + "t_s_type", ""));
		setVvdPodCd(JSPUtil.getParameter(request, prefix + "vvd_pod_cd", ""));
		setMstBl(JSPUtil.getParameter(request, prefix + "mst_bl", ""));
		setScmrRst(JSPUtil.getParameter(request, prefix + "scmr_rst", ""));
		setMkDesc(JSPUtil.getParameter(request, prefix + "mk_desc", ""));
		setCneePhnNo(JSPUtil.getParameter(request, prefix + "cnee_phn_no", ""));
		setSamrRst(JSPUtil.getParameter(request, prefix + "samr_rst", ""));
		setSamrDt(JSPUtil.getParameter(request, prefix + "samr_dt", ""));
		setSc108RstDtl(JSPUtil.getParameter(request, prefix + "sc108_rst_dtl", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setShprAddr(JSPUtil.getParameter(request, prefix + "shpr_addr", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setBkgDelCd(JSPUtil.getParameter(request, prefix + "bkg_del_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setSa111Dt(JSPUtil.getParameter(request, prefix + "sa111_dt", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setSInfo(JSPUtil.getParameter(request, prefix + "s_info", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setACmrKind(JSPUtil.getParameter(request, prefix + "a_cmr_kind", ""));
		setNtfyAddr(JSPUtil.getParameter(request, prefix + "ntfy_addr", ""));
		setBkgPolCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cd", ""));
		setShprPhnNo(JSPUtil.getParameter(request, prefix + "shpr_phn_no", ""));
		setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
		setImdgCls(JSPUtil.getParameter(request, prefix + "imdg_cls", ""));
		setVvdPolCd(JSPUtil.getParameter(request, prefix + "vvd_pol_cd", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setSa111Rst(JSPUtil.getParameter(request, prefix + "sa111_rst", ""));
		setTamrRst(JSPUtil.getParameter(request, prefix + "tamr_rst", ""));
		setScmrDt(JSPUtil.getParameter(request, prefix + "scmr_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setASType(JSPUtil.getParameter(request, prefix + "a_s_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CargoInfoDetailVO[]
	 */
	public CargoInfoDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CargoInfoDetailVO[]
	 */
	public CargoInfoDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CargoInfoDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cneeAddr = (JSPUtil.getParameter(request, prefix	+ "cnee_addr", length));
			String[] errInfo = (JSPUtil.getParameter(request, prefix	+ "err_info", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] sc108Rst = (JSPUtil.getParameter(request, prefix	+ "sc108_rst", length));
			String[] sDt = (JSPUtil.getParameter(request, prefix	+ "s_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cneeCntCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cnt_cd", length));
			String[] rvisCntrCustTpCd = (JSPUtil.getParameter(request, prefix	+ "rvis_cntr_cust_tp_cd", length));
			String[] bkgPodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] cmdtHsCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_hs_cd", length));
			String[] ntfyPhnNo = (JSPUtil.getParameter(request, prefix	+ "ntfy_phn_no", length));
			String[] ntfyCntCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_cnt_cd", length));
			String[] podDiv = (JSPUtil.getParameter(request, prefix	+ "pod_div", length));
			String[] shprCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd", length));
			String[] unNo = (JSPUtil.getParameter(request, prefix	+ "un_no", length));
			String[] sc108Dt = (JSPUtil.getParameter(request, prefix	+ "sc108_dt", length));
			String[] tCmrKind = (JSPUtil.getParameter(request, prefix	+ "t_cmr_kind", length));
			String[] tSType = (JSPUtil.getParameter(request, prefix	+ "t_s_type", length));
			String[] vvdPodCd = (JSPUtil.getParameter(request, prefix	+ "vvd_pod_cd", length));
			String[] mstBl = (JSPUtil.getParameter(request, prefix	+ "mst_bl", length));
			String[] scmrRst = (JSPUtil.getParameter(request, prefix	+ "scmr_rst", length));
			String[] mkDesc = (JSPUtil.getParameter(request, prefix	+ "mk_desc", length));
			String[] cneePhnNo = (JSPUtil.getParameter(request, prefix	+ "cnee_phn_no", length));
			String[] samrRst = (JSPUtil.getParameter(request, prefix	+ "samr_rst", length));
			String[] samrDt = (JSPUtil.getParameter(request, prefix	+ "samr_dt", length));
			String[] sc108RstDtl = (JSPUtil.getParameter(request, prefix	+ "sc108_rst_dtl", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] shprAddr = (JSPUtil.getParameter(request, prefix	+ "shpr_addr", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] bkgDelCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] sa111Dt = (JSPUtil.getParameter(request, prefix	+ "sa111_dt", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] sInfo = (JSPUtil.getParameter(request, prefix	+ "s_info", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] aCmrKind = (JSPUtil.getParameter(request, prefix	+ "a_cmr_kind", length));
			String[] ntfyAddr = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] shprPhnNo = (JSPUtil.getParameter(request, prefix	+ "shpr_phn_no", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] imdgCls = (JSPUtil.getParameter(request, prefix	+ "imdg_cls", length));
			String[] vvdPolCd = (JSPUtil.getParameter(request, prefix	+ "vvd_pol_cd", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] sa111Rst = (JSPUtil.getParameter(request, prefix	+ "sa111_rst", length));
			String[] tamrRst = (JSPUtil.getParameter(request, prefix	+ "tamr_rst", length));
			String[] scmrDt = (JSPUtil.getParameter(request, prefix	+ "scmr_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] aSType = (JSPUtil.getParameter(request, prefix	+ "a_s_type", length));
			
			for (int i = 0; i < length; i++) {
				model = new CargoInfoDetailVO();
				if (cneeAddr[i] != null)
					model.setCneeAddr(cneeAddr[i]);
				if (errInfo[i] != null)
					model.setErrInfo(errInfo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (sc108Rst[i] != null)
					model.setSc108Rst(sc108Rst[i]);
				if (sDt[i] != null)
					model.setSDt(sDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cneeCntCd[i] != null)
					model.setCneeCntCd(cneeCntCd[i]);
				if (rvisCntrCustTpCd[i] != null)
					model.setRvisCntrCustTpCd(rvisCntrCustTpCd[i]);
				if (bkgPodCd[i] != null)
					model.setBkgPodCd(bkgPodCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (cmdtHsCd[i] != null)
					model.setCmdtHsCd(cmdtHsCd[i]);
				if (ntfyPhnNo[i] != null)
					model.setNtfyPhnNo(ntfyPhnNo[i]);
				if (ntfyCntCd[i] != null)
					model.setNtfyCntCd(ntfyCntCd[i]);
				if (podDiv[i] != null)
					model.setPodDiv(podDiv[i]);
				if (shprCntCd[i] != null)
					model.setShprCntCd(shprCntCd[i]);
				if (unNo[i] != null)
					model.setUnNo(unNo[i]);
				if (sc108Dt[i] != null)
					model.setSc108Dt(sc108Dt[i]);
				if (tCmrKind[i] != null)
					model.setTCmrKind(tCmrKind[i]);
				if (tSType[i] != null)
					model.setTSType(tSType[i]);
				if (vvdPodCd[i] != null)
					model.setVvdPodCd(vvdPodCd[i]);
				if (mstBl[i] != null)
					model.setMstBl(mstBl[i]);
				if (scmrRst[i] != null)
					model.setScmrRst(scmrRst[i]);
				if (mkDesc[i] != null)
					model.setMkDesc(mkDesc[i]);
				if (cneePhnNo[i] != null)
					model.setCneePhnNo(cneePhnNo[i]);
				if (samrRst[i] != null)
					model.setSamrRst(samrRst[i]);
				if (samrDt[i] != null)
					model.setSamrDt(samrDt[i]);
				if (sc108RstDtl[i] != null)
					model.setSc108RstDtl(sc108RstDtl[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (shprAddr[i] != null)
					model.setShprAddr(shprAddr[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (bkgDelCd[i] != null)
					model.setBkgDelCd(bkgDelCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (sa111Dt[i] != null)
					model.setSa111Dt(sa111Dt[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (sInfo[i] != null)
					model.setSInfo(sInfo[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (aCmrKind[i] != null)
					model.setACmrKind(aCmrKind[i]);
				if (ntfyAddr[i] != null)
					model.setNtfyAddr(ntfyAddr[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (shprPhnNo[i] != null)
					model.setShprPhnNo(shprPhnNo[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (imdgCls[i] != null)
					model.setImdgCls(imdgCls[i]);
				if (vvdPolCd[i] != null)
					model.setVvdPolCd(vvdPolCd[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (sa111Rst[i] != null)
					model.setSa111Rst(sa111Rst[i]);
				if (tamrRst[i] != null)
					model.setTamrRst(tamrRst[i]);
				if (scmrDt[i] != null)
					model.setScmrDt(scmrDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (aSType[i] != null)
					model.setASType(aSType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCargoInfoDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CargoInfoDetailVO[]
	 */
	public CargoInfoDetailVO[] getCargoInfoDetailVOs(){
		CargoInfoDetailVO[] vos = (CargoInfoDetailVO[])models.toArray(new CargoInfoDetailVO[models.size()]);
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
		this.cneeAddr = this.cneeAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errInfo = this.errInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sc108Rst = this.sc108Rst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDt = this.sDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCntCd = this.cneeCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCntrCustTpCd = this.rvisCntrCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd = this.bkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHsCd = this.cmdtHsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyPhnNo = this.ntfyPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCntCd = this.ntfyCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podDiv = this.podDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd = this.shprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unNo = this.unNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sc108Dt = this.sc108Dt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tCmrKind = this.tCmrKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tSType = this.tSType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPodCd = this.vvdPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBl = this.mstBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scmrRst = this.scmrRst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc = this.mkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneePhnNo = this.cneePhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.samrRst = this.samrRst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.samrDt = this.samrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sc108RstDtl = this.sc108RstDtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr = this.shprAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCd = this.bkgDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sa111Dt = this.sa111Dt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInfo = this.sInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCmrKind = this.aCmrKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr = this.ntfyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprPhnNo = this.shprPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCls = this.imdgCls .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPolCd = this.vvdPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sa111Rst = this.sa111Rst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tamrRst = this.tamrRst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scmrDt = this.scmrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aSType = this.aSType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
