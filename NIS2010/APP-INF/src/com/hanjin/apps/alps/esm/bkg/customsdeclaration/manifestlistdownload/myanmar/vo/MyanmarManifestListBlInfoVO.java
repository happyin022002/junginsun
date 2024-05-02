/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MyanmarManifestListBlInfoVO.java
*@FileTitle : MyanmarManifestListBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.15
*@LastModifier : 윤태승
*@LastVersion : 1.0
* 2012.11.15 윤태승 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤태승
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MyanmarManifestListBlInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MyanmarManifestListBlInfoVO> models = new ArrayList<MyanmarManifestListBlInfoVO>();
	
	/* Column Info */
	private String tpszTotChk = null;
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String inputPolCd = null;
	/* Column Info */
	private String bPor = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String ls = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String frmPodCd = null;
	/* Column Info */
	private String description2 = null;
	/* Column Info */
	private String rf = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String rd = null;
	/* Column Info */
	private String vPol = null;
	/* Column Info */
	private String bDelCd = null;
	/* Column Info */
	private String bDel = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String frmPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vPod = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String blKnt = null;
	/* Column Info */
	private String sDate = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String inputPodCd = null;
	/* Column Info */
	private String frmPolCd = null;
	/* Column Info */
	private String tpsz40Chk = null;
	/* Column Info */
	private String vslCallsign = null;
	/* Column Info */
	private String vPodCd = null;
	/* Column Info */
	private String ttlCntrKnt = null;
	/* Column Info */
	private String trsmSts = null;
	/* Column Info */
	private String sf = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String polGubun = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String counting = null;
	/* Column Info */
	private String tpsz20Chk = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cnee = null;
	/* Column Info */
	private String freight = null;
	/* Column Info */
	private String seq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MyanmarManifestListBlInfoVO() {}

	public MyanmarManifestListBlInfoVO(String ibflag, String pagerows, String vslNm, String vslCallsign, String etd, String eta, String seq, String vvd, String bkgNo, String blNo, String cntrNo, String cntrTpszCd, String sf, String rd, String ls, String bPor, String vPol, String vPod, String vPodCd, String bDel, String bDelCd, String actWgt, String wgtUtCd, String measQty, String measUtCd, String pckQty, String pckTpCd, String freight, String rf, String sDate, String counting, String tpsz20Chk, String tpsz40Chk, String tpszTotChk, String frmPodCd, String frmPolCd, String frmPortCd, String cnee, String custNm, String trsmSts, String usrId, String polGubun, String description2, String inputPolCd, String inputPodCd, String blKnt, String ttlCntrKnt) {
		this.tpszTotChk = tpszTotChk;
		this.eta = eta;
		this.inputPolCd = inputPolCd;
		this.bPor = bPor;
		this.custNm = custNm;
		this.ls = ls;
		this.etd = etd;
		this.frmPodCd = frmPodCd;
		this.description2 = description2;
		this.rf = rf;
		this.blNo = blNo;
		this.rd = rd;
		this.vPol = vPol;
		this.bDelCd = bDelCd;
		this.bDel = bDel;
		this.pagerows = pagerows;
		this.frmPortCd = frmPortCd;
		this.ibflag = ibflag;
		this.vPod = vPod;
		this.usrId = usrId;
		this.cntrTpszCd = cntrTpszCd;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.blKnt = blKnt;
		this.sDate = sDate;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
		this.inputPodCd = inputPodCd;
		this.frmPolCd = frmPolCd;
		this.tpsz40Chk = tpsz40Chk;
		this.vslCallsign = vslCallsign;
		this.vPodCd = vPodCd;
		this.ttlCntrKnt = ttlCntrKnt;
		this.trsmSts = trsmSts;
		this.sf = sf;
		this.vslNm = vslNm;
		this.polGubun = polGubun;
		this.actWgt = actWgt;
		this.vvd = vvd;
		this.bkgNo = bkgNo;
		this.counting = counting;
		this.tpsz20Chk = tpsz20Chk;
		this.cntrNo = cntrNo;
		this.cnee = cnee;
		this.freight = freight;
		this.seq = seq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tpsz_tot_chk", getTpszTotChk());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("input_pol_cd", getInputPolCd());
		this.hashColumns.put("b_por", getBPor());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("ls", getLs());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("frm_pod_cd", getFrmPodCd());
		this.hashColumns.put("description2", getDescription2());
		this.hashColumns.put("rf", getRf());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("rd", getRd());
		this.hashColumns.put("v_pol", getVPol());
		this.hashColumns.put("b_del_cd", getBDelCd());
		this.hashColumns.put("b_del", getBDel());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("frm_port_cd", getFrmPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("v_pod", getVPod());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("bl_knt", getBlKnt());
		this.hashColumns.put("s_date", getSDate());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("input_pod_cd", getInputPodCd());
		this.hashColumns.put("frm_pol_cd", getFrmPolCd());
		this.hashColumns.put("tpsz_40_chk", getTpsz40Chk());
		this.hashColumns.put("vsl_callsign", getVslCallsign());
		this.hashColumns.put("v_pod_cd", getVPodCd());
		this.hashColumns.put("ttl_cntr_knt", getTtlCntrKnt());
		this.hashColumns.put("trsm_sts", getTrsmSts());
		this.hashColumns.put("sf", getSf());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("pol_gubun", getPolGubun());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("counting", getCounting());
		this.hashColumns.put("tpsz_20_chk", getTpsz20Chk());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("freight", getFreight());
		this.hashColumns.put("seq", getSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tpsz_tot_chk", "tpszTotChk");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("input_pol_cd", "inputPolCd");
		this.hashFields.put("b_por", "bPor");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("ls", "ls");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("frm_pod_cd", "frmPodCd");
		this.hashFields.put("description2", "description2");
		this.hashFields.put("rf", "rf");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("rd", "rd");
		this.hashFields.put("v_pol", "vPol");
		this.hashFields.put("b_del_cd", "bDelCd");
		this.hashFields.put("b_del", "bDel");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("frm_port_cd", "frmPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("v_pod", "vPod");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("bl_knt", "blKnt");
		this.hashFields.put("s_date", "sDate");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("input_pod_cd", "inputPodCd");
		this.hashFields.put("frm_pol_cd", "frmPolCd");
		this.hashFields.put("tpsz_40_chk", "tpsz40Chk");
		this.hashFields.put("vsl_callsign", "vslCallsign");
		this.hashFields.put("v_pod_cd", "vPodCd");
		this.hashFields.put("ttl_cntr_knt", "ttlCntrKnt");
		this.hashFields.put("trsm_sts", "trsmSts");
		this.hashFields.put("sf", "sf");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("pol_gubun", "polGubun");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("counting", "counting");
		this.hashFields.put("tpsz_20_chk", "tpsz20Chk");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("freight", "freight");
		this.hashFields.put("seq", "seq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tpszTotChk
	 */
	public String getTpszTotChk() {
		return this.tpszTotChk;
	}
	
	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
	}
	
	/**
	 * Column Info
	 * @return inputPolCd
	 */
	public String getInputPolCd() {
		return this.inputPolCd;
	}
	
	/**
	 * Column Info
	 * @return bPor
	 */
	public String getBPor() {
		return this.bPor;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return ls
	 */
	public String getLs() {
		return this.ls;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return frmPodCd
	 */
	public String getFrmPodCd() {
		return this.frmPodCd;
	}
	
	/**
	 * Column Info
	 * @return description2
	 */
	public String getDescription2() {
		return this.description2;
	}
	
	/**
	 * Column Info
	 * @return rf
	 */
	public String getRf() {
		return this.rf;
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
	 * @return rd
	 */
	public String getRd() {
		return this.rd;
	}
	
	/**
	 * Column Info
	 * @return vPol
	 */
	public String getVPol() {
		return this.vPol;
	}
	
	/**
	 * Column Info
	 * @return bDelCd
	 */
	public String getBDelCd() {
		return this.bDelCd;
	}
	
	/**
	 * Column Info
	 * @return bDel
	 */
	public String getBDel() {
		return this.bDel;
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
	 * @return frmPortCd
	 */
	public String getFrmPortCd() {
		return this.frmPortCd;
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
	 * @return vPod
	 */
	public String getVPod() {
		return this.vPod;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return blKnt
	 */
	public String getBlKnt() {
		return this.blKnt;
	}
	
	/**
	 * Column Info
	 * @return sDate
	 */
	public String getSDate() {
		return this.sDate;
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
	 * @return inputPodCd
	 */
	public String getInputPodCd() {
		return this.inputPodCd;
	}
	
	/**
	 * Column Info
	 * @return frmPolCd
	 */
	public String getFrmPolCd() {
		return this.frmPolCd;
	}
	
	/**
	 * Column Info
	 * @return tpsz40Chk
	 */
	public String getTpsz40Chk() {
		return this.tpsz40Chk;
	}
	
	/**
	 * Column Info
	 * @return vslCallsign
	 */
	public String getVslCallsign() {
		return this.vslCallsign;
	}
	
	/**
	 * Column Info
	 * @return vPodCd
	 */
	public String getVPodCd() {
		return this.vPodCd;
	}
	
	/**
	 * Column Info
	 * @return ttlCntrKnt
	 */
	public String getTtlCntrKnt() {
		return this.ttlCntrKnt;
	}
	
	/**
	 * Column Info
	 * @return trsmSts
	 */
	public String getTrsmSts() {
		return this.trsmSts;
	}
	
	/**
	 * Column Info
	 * @return sf
	 */
	public String getSf() {
		return this.sf;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return polGubun
	 */
	public String getPolGubun() {
		return this.polGubun;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return counting
	 */
	public String getCounting() {
		return this.counting;
	}
	
	/**
	 * Column Info
	 * @return tpsz20Chk
	 */
	public String getTpsz20Chk() {
		return this.tpsz20Chk;
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
	 * @return cnee
	 */
	public String getCnee() {
		return this.cnee;
	}
	
	/**
	 * Column Info
	 * @return freight
	 */
	public String getFreight() {
		return this.freight;
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
	 * @param tpszTotChk
	 */
	public void setTpszTotChk(String tpszTotChk) {
		this.tpszTotChk = tpszTotChk;
	}
	
	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}
	
	/**
	 * Column Info
	 * @param inputPolCd
	 */
	public void setInputPolCd(String inputPolCd) {
		this.inputPolCd = inputPolCd;
	}
	
	/**
	 * Column Info
	 * @param bPor
	 */
	public void setBPor(String bPor) {
		this.bPor = bPor;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param ls
	 */
	public void setLs(String ls) {
		this.ls = ls;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param frmPodCd
	 */
	public void setFrmPodCd(String frmPodCd) {
		this.frmPodCd = frmPodCd;
	}
	
	/**
	 * Column Info
	 * @param description2
	 */
	public void setDescription2(String description2) {
		this.description2 = description2;
	}
	
	/**
	 * Column Info
	 * @param rf
	 */
	public void setRf(String rf) {
		this.rf = rf;
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
	 * @param rd
	 */
	public void setRd(String rd) {
		this.rd = rd;
	}
	
	/**
	 * Column Info
	 * @param vPol
	 */
	public void setVPol(String vPol) {
		this.vPol = vPol;
	}
	
	/**
	 * Column Info
	 * @param bDelCd
	 */
	public void setBDelCd(String bDelCd) {
		this.bDelCd = bDelCd;
	}
	
	/**
	 * Column Info
	 * @param bDel
	 */
	public void setBDel(String bDel) {
		this.bDel = bDel;
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
	 * @param frmPortCd
	 */
	public void setFrmPortCd(String frmPortCd) {
		this.frmPortCd = frmPortCd;
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
	 * @param vPod
	 */
	public void setVPod(String vPod) {
		this.vPod = vPod;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param blKnt
	 */
	public void setBlKnt(String blKnt) {
		this.blKnt = blKnt;
	}
	
	/**
	 * Column Info
	 * @param sDate
	 */
	public void setSDate(String sDate) {
		this.sDate = sDate;
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
	 * @param inputPodCd
	 */
	public void setInputPodCd(String inputPodCd) {
		this.inputPodCd = inputPodCd;
	}
	
	/**
	 * Column Info
	 * @param frmPolCd
	 */
	public void setFrmPolCd(String frmPolCd) {
		this.frmPolCd = frmPolCd;
	}
	
	/**
	 * Column Info
	 * @param tpsz40Chk
	 */
	public void setTpsz40Chk(String tpsz40Chk) {
		this.tpsz40Chk = tpsz40Chk;
	}
	
	/**
	 * Column Info
	 * @param vslCallsign
	 */
	public void setVslCallsign(String vslCallsign) {
		this.vslCallsign = vslCallsign;
	}
	
	/**
	 * Column Info
	 * @param vPodCd
	 */
	public void setVPodCd(String vPodCd) {
		this.vPodCd = vPodCd;
	}
	
	/**
	 * Column Info
	 * @param ttlCntrKnt
	 */
	public void setTtlCntrKnt(String ttlCntrKnt) {
		this.ttlCntrKnt = ttlCntrKnt;
	}
	
	/**
	 * Column Info
	 * @param trsmSts
	 */
	public void setTrsmSts(String trsmSts) {
		this.trsmSts = trsmSts;
	}
	
	/**
	 * Column Info
	 * @param sf
	 */
	public void setSf(String sf) {
		this.sf = sf;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param polGubun
	 */
	public void setPolGubun(String polGubun) {
		this.polGubun = polGubun;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param counting
	 */
	public void setCounting(String counting) {
		this.counting = counting;
	}
	
	/**
	 * Column Info
	 * @param tpsz20Chk
	 */
	public void setTpsz20Chk(String tpsz20Chk) {
		this.tpsz20Chk = tpsz20Chk;
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
	 * @param cnee
	 */
	public void setCnee(String cnee) {
		this.cnee = cnee;
	}
	
	/**
	 * Column Info
	 * @param freight
	 */
	public void setFreight(String freight) {
		this.freight = freight;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
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
		setTpszTotChk(JSPUtil.getParameter(request, prefix + "tpsz_tot_chk", ""));
		setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
		setInputPolCd(JSPUtil.getParameter(request, prefix + "input_pol_cd", ""));
		setBPor(JSPUtil.getParameter(request, prefix + "b_por", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setLs(JSPUtil.getParameter(request, prefix + "ls", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setFrmPodCd(JSPUtil.getParameter(request, prefix + "frm_pod_cd", ""));
		setDescription2(JSPUtil.getParameter(request, prefix + "description2", ""));
		setRf(JSPUtil.getParameter(request, prefix + "rf", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setRd(JSPUtil.getParameter(request, prefix + "rd", ""));
		setVPol(JSPUtil.getParameter(request, prefix + "v_pol", ""));
		setBDelCd(JSPUtil.getParameter(request, prefix + "b_del_cd", ""));
		setBDel(JSPUtil.getParameter(request, prefix + "b_del", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFrmPortCd(JSPUtil.getParameter(request, prefix + "frm_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVPod(JSPUtil.getParameter(request, prefix + "v_pod", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setBlKnt(JSPUtil.getParameter(request, prefix + "bl_knt", ""));
		setSDate(JSPUtil.getParameter(request, prefix + "s_date", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setInputPodCd(JSPUtil.getParameter(request, prefix + "input_pod_cd", ""));
		setFrmPolCd(JSPUtil.getParameter(request, prefix + "frm_pol_cd", ""));
		setTpsz40Chk(JSPUtil.getParameter(request, prefix + "tpsz_40_chk", ""));
		setVslCallsign(JSPUtil.getParameter(request, prefix + "vsl_callsign", ""));
		setVPodCd(JSPUtil.getParameter(request, prefix + "v_pod_cd", ""));
		setTtlCntrKnt(JSPUtil.getParameter(request, prefix + "ttl_cntr_knt", ""));
		setTrsmSts(JSPUtil.getParameter(request, prefix + "trsm_sts", ""));
		setSf(JSPUtil.getParameter(request, prefix + "sf", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setPolGubun(JSPUtil.getParameter(request, prefix + "pol_gubun", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCounting(JSPUtil.getParameter(request, prefix + "counting", ""));
		setTpsz20Chk(JSPUtil.getParameter(request, prefix + "tpsz_20_chk", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCnee(JSPUtil.getParameter(request, prefix + "cnee", ""));
		setFreight(JSPUtil.getParameter(request, prefix + "freight", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MyanmarManifestListBlInfoVO[]
	 */
	public MyanmarManifestListBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MyanmarManifestListBlInfoVO[]
	 */
	public MyanmarManifestListBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MyanmarManifestListBlInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tpszTotChk = (JSPUtil.getParameter(request, prefix	+ "tpsz_tot_chk", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] inputPolCd = (JSPUtil.getParameter(request, prefix	+ "input_pol_cd", length));
			String[] bPor = (JSPUtil.getParameter(request, prefix	+ "b_por", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] ls = (JSPUtil.getParameter(request, prefix	+ "ls", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] frmPodCd = (JSPUtil.getParameter(request, prefix	+ "frm_pod_cd", length));
			String[] description2 = (JSPUtil.getParameter(request, prefix	+ "description2", length));
			String[] rf = (JSPUtil.getParameter(request, prefix	+ "rf", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] rd = (JSPUtil.getParameter(request, prefix	+ "rd", length));
			String[] vPol = (JSPUtil.getParameter(request, prefix	+ "v_pol", length));
			String[] bDelCd = (JSPUtil.getParameter(request, prefix	+ "b_del_cd", length));
			String[] bDel = (JSPUtil.getParameter(request, prefix	+ "b_del", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] frmPortCd = (JSPUtil.getParameter(request, prefix	+ "frm_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vPod = (JSPUtil.getParameter(request, prefix	+ "v_pod", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] blKnt = (JSPUtil.getParameter(request, prefix	+ "bl_knt", length));
			String[] sDate = (JSPUtil.getParameter(request, prefix	+ "s_date", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] inputPodCd = (JSPUtil.getParameter(request, prefix	+ "input_pod_cd", length));
			String[] frmPolCd = (JSPUtil.getParameter(request, prefix	+ "frm_pol_cd", length));
			String[] tpsz40Chk = (JSPUtil.getParameter(request, prefix	+ "tpsz_40_chk", length));
			String[] vslCallsign = (JSPUtil.getParameter(request, prefix	+ "vsl_callsign", length));
			String[] vPodCd = (JSPUtil.getParameter(request, prefix	+ "v_pod_cd", length));
			String[] ttlCntrKnt = (JSPUtil.getParameter(request, prefix	+ "ttl_cntr_knt", length));
			String[] trsmSts = (JSPUtil.getParameter(request, prefix	+ "trsm_sts", length));
			String[] sf = (JSPUtil.getParameter(request, prefix	+ "sf", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] polGubun = (JSPUtil.getParameter(request, prefix	+ "pol_gubun", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] counting = (JSPUtil.getParameter(request, prefix	+ "counting", length));
			String[] tpsz20Chk = (JSPUtil.getParameter(request, prefix	+ "tpsz_20_chk", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix	+ "cnee", length));
			String[] freight = (JSPUtil.getParameter(request, prefix	+ "freight", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new MyanmarManifestListBlInfoVO();
				if (tpszTotChk[i] != null)
					model.setTpszTotChk(tpszTotChk[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (inputPolCd[i] != null)
					model.setInputPolCd(inputPolCd[i]);
				if (bPor[i] != null)
					model.setBPor(bPor[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (ls[i] != null)
					model.setLs(ls[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (frmPodCd[i] != null)
					model.setFrmPodCd(frmPodCd[i]);
				if (description2[i] != null)
					model.setDescription2(description2[i]);
				if (rf[i] != null)
					model.setRf(rf[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (rd[i] != null)
					model.setRd(rd[i]);
				if (vPol[i] != null)
					model.setVPol(vPol[i]);
				if (bDelCd[i] != null)
					model.setBDelCd(bDelCd[i]);
				if (bDel[i] != null)
					model.setBDel(bDel[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (frmPortCd[i] != null)
					model.setFrmPortCd(frmPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vPod[i] != null)
					model.setVPod(vPod[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (blKnt[i] != null)
					model.setBlKnt(blKnt[i]);
				if (sDate[i] != null)
					model.setSDate(sDate[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (inputPodCd[i] != null)
					model.setInputPodCd(inputPodCd[i]);
				if (frmPolCd[i] != null)
					model.setFrmPolCd(frmPolCd[i]);
				if (tpsz40Chk[i] != null)
					model.setTpsz40Chk(tpsz40Chk[i]);
				if (vslCallsign[i] != null)
					model.setVslCallsign(vslCallsign[i]);
				if (vPodCd[i] != null)
					model.setVPodCd(vPodCd[i]);
				if (ttlCntrKnt[i] != null)
					model.setTtlCntrKnt(ttlCntrKnt[i]);
				if (trsmSts[i] != null)
					model.setTrsmSts(trsmSts[i]);
				if (sf[i] != null)
					model.setSf(sf[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (polGubun[i] != null)
					model.setPolGubun(polGubun[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (counting[i] != null)
					model.setCounting(counting[i]);
				if (tpsz20Chk[i] != null)
					model.setTpsz20Chk(tpsz20Chk[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cnee[i] != null)
					model.setCnee(cnee[i]);
				if (freight[i] != null)
					model.setFreight(freight[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMyanmarManifestListBlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MyanmarManifestListBlInfoVO[]
	 */
	public MyanmarManifestListBlInfoVO[] getMyanmarManifestListBlInfoVOs(){
		MyanmarManifestListBlInfoVO[] vos = (MyanmarManifestListBlInfoVO[])models.toArray(new MyanmarManifestListBlInfoVO[models.size()]);
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
		this.tpszTotChk = this.tpszTotChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputPolCd = this.inputPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bPor = this.bPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ls = this.ls .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmPodCd = this.frmPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.description2 = this.description2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf = this.rf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rd = this.rd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vPol = this.vPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bDelCd = this.bDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bDel = this.bDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmPortCd = this.frmPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vPod = this.vPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blKnt = this.blKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDate = this.sDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputPodCd = this.inputPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmPolCd = this.frmPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz40Chk = this.tpsz40Chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallsign = this.vslCallsign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vPodCd = this.vPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCntrKnt = this.ttlCntrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmSts = this.trsmSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sf = this.sf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polGubun = this.polGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.counting = this.counting .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz20Chk = this.tpsz20Chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freight = this.freight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
