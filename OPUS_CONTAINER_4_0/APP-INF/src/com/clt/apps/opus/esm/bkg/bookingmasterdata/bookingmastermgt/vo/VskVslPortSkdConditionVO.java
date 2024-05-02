/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VskVslPortSkdConditionVO.java
*@FileTitle : VskVslPortSkdConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.28
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.05.28 김기종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

import java.lang.reflect.Field;
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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VskVslPortSkdConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VskVslPortSkdConditionVO> models = new ArrayList<VskVslPortSkdConditionVO>();
	
	/* Column Info */
	private String etb = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String etb2Dt = null;
	/* Column Info */
	private String vpsRmk = null;
	/* Column Info */
	private String updTm = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String cctDt = null;
	/* Column Info */
	private String cctTm = null;
	/* Column Info */
	private String cct = null;
	/* Column Info */
	private String pfEtdFromDt = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podClptSeq = null;
	/* Column Info */
	private String clptSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String etb2Tm = null;
	/* Column Info */
	private String terminal = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String etbDt = null;
	/* Column Info */
	private String etbTm = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String pfEtdToDt = null;
	/* Column Info */
	private String terminal2 = null;
	/* Column Info */
	private String podClptIndSeq = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String pfEtbFromDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String vpsPortPol = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String etb2 = null;
	/* Column Info */
	private String vpsPortPod = null;
	/* Column Info */
	private String pfEtbToDt = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String etdTm = null;
	/* Column Info */
	private String obCssmVoyNo = null;
	/* Column Info */
	private String ibCssmVoyNo = null;
	/* Column Info */
	private String lastCyAvail = null;
	/* Column Info */
	private String vslEngNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VskVslPortSkdConditionVO() {}

	public VskVslPortSkdConditionVO(String ibflag, String pagerows, String vvd, String lane, String pol, String clptIndSeq, String clptSeq, String terminal, String cct, String cctDt, String cctTm, String etb, String etbDt, String etbTm, String etd, String etdDt, String etdTm, String pod, String podClptIndSeq, String podClptSeq, String terminal2, String etb2, String etb2Dt, String etb2Tm, String vpsRmk, String updDt, String updTm, String slanCd, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortPol, String pfEtdFromDt, String pfEtdToDt, String pfEtbFromDt, String pfEtbToDt, String vpsPortPod, String obCssmVoyNo, String ibCssmVoyNo, String lastCyAvail, String vslEngNm) {
		this.etb = etb;
		this.vslCd = vslCd;
		this.etb2Dt = etb2Dt;
		this.vpsRmk = vpsRmk;
		this.updTm = updTm;
		this.etd = etd;
		this.cctDt = cctDt;
		this.cctTm = cctTm;
		this.cct = cct;
		this.pfEtdFromDt = pfEtdFromDt;
		this.lane = lane;
		this.pagerows = pagerows;
		this.podClptSeq = podClptSeq;
		this.clptSeq = clptSeq;
		this.ibflag = ibflag;
		this.etb2Tm = etb2Tm;
		this.terminal = terminal;
		this.pol = pol;
		this.etbDt = etbDt;
		this.etbTm = etbTm;
		this.pod = pod;
		this.updDt = updDt;
		this.pfEtdToDt = pfEtdToDt;
		this.terminal2 = terminal2;
		this.podClptIndSeq = podClptIndSeq;
		this.skdVoyNo = skdVoyNo;
		this.etdDt = etdDt;
		this.pfEtbFromDt = pfEtbFromDt;
		this.skdDirCd = skdDirCd;
		this.vpsPortPol = vpsPortPol;
		this.vvd = vvd;
		this.slanCd = slanCd;
		this.etb2 = etb2;
		this.vpsPortPod = vpsPortPod;
		this.pfEtbToDt = pfEtbToDt;
		this.clptIndSeq = clptIndSeq;
		this.etdTm = etdTm;
		this.obCssmVoyNo = obCssmVoyNo;
		this.ibCssmVoyNo = ibCssmVoyNo;
		this.lastCyAvail = lastCyAvail;
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("etb", getEtb());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("etb2_dt", getEtb2Dt());
		this.hashColumns.put("vps_rmk", getVpsRmk());
		this.hashColumns.put("upd_tm", getUpdTm());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("cct_dt", getCctDt());
		this.hashColumns.put("cct_tm", getCctTm());
		this.hashColumns.put("cct", getCct());
		this.hashColumns.put("pf_etd_from_dt", getPfEtdFromDt());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_clpt_seq", getPodClptSeq());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("etb2_tm", getEtb2Tm());
		this.hashColumns.put("terminal", getTerminal());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("etb_dt", getEtbDt());
		this.hashColumns.put("etb_tm", getEtbTm());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("pf_etd_to_dt", getPfEtdToDt());
		this.hashColumns.put("terminal2", getTerminal2());
		this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("pf_etb_from_dt", getPfEtbFromDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vps_port_pol", getVpsPortPol());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("etb2", getEtb2());
		this.hashColumns.put("vps_port_pod", getVpsPortPod());
		this.hashColumns.put("pf_etb_to_dt", getPfEtbToDt());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("etd_tm", getEtdTm());
		this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
		this.hashColumns.put("ib_cssm_voy_no", getIbCssmVoyNo());
		this.hashColumns.put("last_cy_avail", getLastCyAvail());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("etb", "etb");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("etb2_dt", "etb2Dt");
		this.hashFields.put("vps_rmk", "vpsRmk");
		this.hashFields.put("upd_tm", "updTm");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("cct_dt", "cctDt");
		this.hashFields.put("cct_tm", "cctTm");
		this.hashFields.put("cct", "cct");
		this.hashFields.put("pf_etd_from_dt", "pfEtdFromDt");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_clpt_seq", "podClptSeq");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("etb2_tm", "etb2Tm");
		this.hashFields.put("terminal", "terminal");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("etb_dt", "etbDt");
		this.hashFields.put("etb_tm", "etbTm");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("pf_etd_to_dt", "pfEtdToDt");
		this.hashFields.put("terminal2", "terminal2");
		this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("pf_etb_from_dt", "pfEtbFromDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vps_port_pol", "vpsPortPol");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("etb2", "etb2");
		this.hashFields.put("vps_port_pod", "vpsPortPod");
		this.hashFields.put("pf_etb_to_dt", "pfEtbToDt");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("etd_tm", "etdTm");
		this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");
		this.hashFields.put("ib_cssm_voy_no", "ibCssmVoyNo");
		this.hashFields.put("last_cy_avail", "lastCyAvail");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return etb
	 */
	public String getEtb() {
		return this.etb;
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
	 * @return etb2Dt
	 */
	public String getEtb2Dt() {
		return this.etb2Dt;
	}
	
	/**
	 * Column Info
	 * @return vpsRmk
	 */
	public String getVpsRmk() {
		return this.vpsRmk;
	}
	
	/**
	 * Column Info
	 * @return updTm
	 */
	public String getUpdTm() {
		return this.updTm;
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
	 * @return cctDt
	 */
	public String getCctDt() {
		return this.cctDt;
	}
	
	/**
	 * Column Info
	 * @return cctTm
	 */
	public String getCctTm() {
		return this.cctTm;
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
	 * @return pfEtdFromDt
	 */
	public String getPfEtdFromDt() {
		return this.pfEtdFromDt;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return podClptSeq
	 */
	public String getPodClptSeq() {
		return this.podClptSeq;
	}
	
	/**
	 * Column Info
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
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
	 * @return etb2Tm
	 */
	public String getEtb2Tm() {
		return this.etb2Tm;
	}
	
	/**
	 * Column Info
	 * @return terminal
	 */
	public String getTerminal() {
		return this.terminal;
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
	 * @return etbDt
	 */
	public String getEtbDt() {
		return this.etbDt;
	}
	
	/**
	 * Column Info
	 * @return etbTm
	 */
	public String getEtbTm() {
		return this.etbTm;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return pfEtdToDt
	 */
	public String getPfEtdToDt() {
		return this.pfEtdToDt;
	}
	
	/**
	 * Column Info
	 * @return terminal2
	 */
	public String getTerminal2() {
		return this.terminal2;
	}
	
	/**
	 * Column Info
	 * @return podClptIndSeq
	 */
	public String getPodClptIndSeq() {
		return this.podClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
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
	 * @return pfEtbFromDt
	 */
	public String getPfEtbFromDt() {
		return this.pfEtbFromDt;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return vpsPortPol
	 */
	public String getVpsPortPol() {
		return this.vpsPortPol;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return etb2
	 */
	public String getEtb2() {
		return this.etb2;
	}
	
	/**
	 * Column Info
	 * @return vpsPortPod
	 */
	public String getVpsPortPod() {
		return this.vpsPortPod;
	}
	
	/**
	 * Column Info
	 * @return pfEtbToDt
	 */
	public String getPfEtbToDt() {
		return this.pfEtbToDt;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return etdTm
	 */
	public String getEtdTm() {
		return this.etdTm;
	}
	
	/**
	 * Column Info
	 * @return obCssmVoyNo
	 */
	public String getObCssmVoyNo() {
		return this.obCssmVoyNo;
	}
	
	/**
	 * Column Info
	 * @return ibCssmVoyNo
	 */
	public String getIbCssmVoyNo() {
		return this.ibCssmVoyNo;
	}
	
	/**
	 * Column Info
	 * @return lastCyAvail
	 */
	public String getLastCyAvail() {
		return this.lastCyAvail;
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
	 * @param etb
	 */
	public void setEtb(String etb) {
		this.etb = etb;
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
	 * @param etb2Dt
	 */
	public void setEtb2Dt(String etb2Dt) {
		this.etb2Dt = etb2Dt;
	}
	
	/**
	 * Column Info
	 * @param vpsRmk
	 */
	public void setVpsRmk(String vpsRmk) {
		this.vpsRmk = vpsRmk;
	}
	
	/**
	 * Column Info
	 * @param updTm
	 */
	public void setUpdTm(String updTm) {
		this.updTm = updTm;
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
	 * @param cctDt
	 */
	public void setCctDt(String cctDt) {
		this.cctDt = cctDt;
	}
	
	/**
	 * Column Info
	 * @param cctTm
	 */
	public void setCctTm(String cctTm) {
		this.cctTm = cctTm;
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
	 * @param pfEtdFromDt
	 */
	public void setPfEtdFromDt(String pfEtdFromDt) {
		this.pfEtdFromDt = pfEtdFromDt;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param podClptSeq
	 */
	public void setPodClptSeq(String podClptSeq) {
		this.podClptSeq = podClptSeq;
	}
	
	/**
	 * Column Info
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
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
	 * @param etb2Tm
	 */
	public void setEtb2Tm(String etb2Tm) {
		this.etb2Tm = etb2Tm;
	}
	
	/**
	 * Column Info
	 * @param terminal
	 */
	public void setTerminal(String terminal) {
		this.terminal = terminal;
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
	 * @param etbDt
	 */
	public void setEtbDt(String etbDt) {
		this.etbDt = etbDt;
	}
	
	/**
	 * Column Info
	 * @param etbTm
	 */
	public void setEtbTm(String etbTm) {
		this.etbTm = etbTm;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param pfEtdToDt
	 */
	public void setPfEtdToDt(String pfEtdToDt) {
		this.pfEtdToDt = pfEtdToDt;
	}
	
	/**
	 * Column Info
	 * @param terminal2
	 */
	public void setTerminal2(String terminal2) {
		this.terminal2 = terminal2;
	}
	
	/**
	 * Column Info
	 * @param podClptIndSeq
	 */
	public void setPodClptIndSeq(String podClptIndSeq) {
		this.podClptIndSeq = podClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param pfEtbFromDt
	 */
	public void setPfEtbFromDt(String pfEtbFromDt) {
		this.pfEtbFromDt = pfEtbFromDt;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param vpsPortPol
	 */
	public void setVpsPortPol(String vpsPortPol) {
		this.vpsPortPol = vpsPortPol;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param etb2
	 */
	public void setEtb2(String etb2) {
		this.etb2 = etb2;
	}
	
	/**
	 * Column Info
	 * @param vpsPortPod
	 */
	public void setVpsPortPod(String vpsPortPod) {
		this.vpsPortPod = vpsPortPod;
	}
	
	/**
	 * Column Info
	 * @param pfEtbToDt
	 */
	public void setPfEtbToDt(String pfEtbToDt) {
		this.pfEtbToDt = pfEtbToDt;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param etdTm
	 */
	public void setEtdTm(String etdTm) {
		this.etdTm = etdTm;
	}
	
	/**
	 * Column Info
	 * @param obCssmVoyNo
	 */
	public void setObCssmVoyNo(String obCssmVoyNo) {
		this.obCssmVoyNo = obCssmVoyNo;
	}

	/**
	 * Column Info
	 * @param ibCssmVoyNo
	 */
	public void setIbCssmVoyNo(String ibCssmVoyNo) {
		this.etdTm = ibCssmVoyNo;
	}

	/**
	 * Column Info
	 * @param lastCyAvail
	 */
	public void setLastCyAvail(String lastCyAvail) {
		this.lastCyAvail = lastCyAvail;
	}

	/**
	 * Column Info
	 * @param etdTm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
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
		setEtb(JSPUtil.getParameter(request, prefix + "etb", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setEtb2Dt(JSPUtil.getParameter(request, prefix + "etb2_dt", ""));
		setVpsRmk(JSPUtil.getParameter(request, prefix + "vps_rmk", ""));
		setUpdTm(JSPUtil.getParameter(request, prefix + "upd_tm", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setCctDt(JSPUtil.getParameter(request, prefix + "cct_dt", ""));
		setCctTm(JSPUtil.getParameter(request, prefix + "cct_tm", ""));
		setCct(JSPUtil.getParameter(request, prefix + "cct", ""));
		setPfEtdFromDt(JSPUtil.getParameter(request, prefix + "pf_etd_from_dt", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodClptSeq(JSPUtil.getParameter(request, prefix + "pod_clpt_seq", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEtb2Tm(JSPUtil.getParameter(request, prefix + "etb2_tm", ""));
		setTerminal(JSPUtil.getParameter(request, prefix + "terminal", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setEtbDt(JSPUtil.getParameter(request, prefix + "etb_dt", ""));
		setEtbTm(JSPUtil.getParameter(request, prefix + "etb_tm", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPfEtdToDt(JSPUtil.getParameter(request, prefix + "pf_etd_to_dt", ""));
		setTerminal2(JSPUtil.getParameter(request, prefix + "terminal2", ""));
		setPodClptIndSeq(JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setPfEtbFromDt(JSPUtil.getParameter(request, prefix + "pf_etb_from_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setVpsPortPol(JSPUtil.getParameter(request, prefix + "vps_port_pol", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setEtb2(JSPUtil.getParameter(request, prefix + "etb2", ""));
		setVpsPortPod(JSPUtil.getParameter(request, prefix + "vps_port_pod", ""));
		setPfEtbToDt(JSPUtil.getParameter(request, prefix + "pf_etb_to_dt", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setEtdTm(JSPUtil.getParameter(request, prefix + "etd_tm", ""));
		setObCssmVoyNo(JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", ""));
		setIbCssmVoyNo(JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", ""));
		setLastCyAvail(JSPUtil.getParameter(request, prefix + "last_cy_avail", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VskVslPortSkdConditionVO[]
	 */
	public VskVslPortSkdConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VskVslPortSkdConditionVO[]
	 */
	public VskVslPortSkdConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VskVslPortSkdConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] etb = (JSPUtil.getParameter(request, prefix	+ "etb", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] etb2Dt = (JSPUtil.getParameter(request, prefix	+ "etb2_dt", length));
			String[] vpsRmk = (JSPUtil.getParameter(request, prefix	+ "vps_rmk", length));
			String[] updTm = (JSPUtil.getParameter(request, prefix	+ "upd_tm", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] cctDt = (JSPUtil.getParameter(request, prefix	+ "cct_dt", length));
			String[] cctTm = (JSPUtil.getParameter(request, prefix	+ "cct_tm", length));
			String[] cct = (JSPUtil.getParameter(request, prefix	+ "cct", length));
			String[] pfEtdFromDt = (JSPUtil.getParameter(request, prefix	+ "pf_etd_from_dt", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podClptSeq = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_seq", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] etb2Tm = (JSPUtil.getParameter(request, prefix	+ "etb2_tm", length));
			String[] terminal = (JSPUtil.getParameter(request, prefix	+ "terminal", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] etbDt = (JSPUtil.getParameter(request, prefix	+ "etb_dt", length));
			String[] etbTm = (JSPUtil.getParameter(request, prefix	+ "etb_tm", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] pfEtdToDt = (JSPUtil.getParameter(request, prefix	+ "pf_etd_to_dt", length));
			String[] terminal2 = (JSPUtil.getParameter(request, prefix	+ "terminal2", length));
			String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] pfEtbFromDt = (JSPUtil.getParameter(request, prefix	+ "pf_etb_from_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vpsPortPol = (JSPUtil.getParameter(request, prefix	+ "vps_port_pol", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] etb2 = (JSPUtil.getParameter(request, prefix	+ "etb2", length));
			String[] vpsPortPod = (JSPUtil.getParameter(request, prefix	+ "vps_port_pod", length));
			String[] pfEtbToDt = (JSPUtil.getParameter(request, prefix	+ "pf_etb_to_dt", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] etdTm = (JSPUtil.getParameter(request, prefix	+ "etd_tm", length));
			String[] obCssmVoyNo = (JSPUtil.getParameter(request, prefix	+ "ob_cssm_voy_no", length));
			String[] ibCssmVoyNo = (JSPUtil.getParameter(request, prefix	+ "ib_cssm_voy_no", length));
			String[] lastCyAvail = (JSPUtil.getParameter(request, prefix	+ "last_cy_avail", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new VskVslPortSkdConditionVO();
				if (etb[i] != null)
					model.setEtb(etb[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (etb2Dt[i] != null)
					model.setEtb2Dt(etb2Dt[i]);
				if (vpsRmk[i] != null)
					model.setVpsRmk(vpsRmk[i]);
				if (updTm[i] != null)
					model.setUpdTm(updTm[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (cctDt[i] != null)
					model.setCctDt(cctDt[i]);
				if (cctTm[i] != null)
					model.setCctTm(cctTm[i]);
				if (cct[i] != null)
					model.setCct(cct[i]);
				if (pfEtdFromDt[i] != null)
					model.setPfEtdFromDt(pfEtdFromDt[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podClptSeq[i] != null)
					model.setPodClptSeq(podClptSeq[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (etb2Tm[i] != null)
					model.setEtb2Tm(etb2Tm[i]);
				if (terminal[i] != null)
					model.setTerminal(terminal[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (etbDt[i] != null)
					model.setEtbDt(etbDt[i]);
				if (etbTm[i] != null)
					model.setEtbTm(etbTm[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (pfEtdToDt[i] != null)
					model.setPfEtdToDt(pfEtdToDt[i]);
				if (terminal2[i] != null)
					model.setTerminal2(terminal2[i]);
				if (podClptIndSeq[i] != null)
					model.setPodClptIndSeq(podClptIndSeq[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (pfEtbFromDt[i] != null)
					model.setPfEtbFromDt(pfEtbFromDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vpsPortPol[i] != null)
					model.setVpsPortPol(vpsPortPol[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (etb2[i] != null)
					model.setEtb2(etb2[i]);
				if (vpsPortPod[i] != null)
					model.setVpsPortPod(vpsPortPod[i]);
				if (pfEtbToDt[i] != null)
					model.setPfEtbToDt(pfEtbToDt[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (etdTm[i] != null)
					model.setEtdTm(etdTm[i]);
				if (obCssmVoyNo[i] != null)
					model.setObCssmVoyNo(obCssmVoyNo[i]);
				if (ibCssmVoyNo[i] != null)
					model.setIbCssmVoyNo(ibCssmVoyNo[i]);
				if (lastCyAvail[i] != null)
					model.setLastCyAvail(lastCyAvail[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVskVslPortSkdConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VskVslPortSkdConditionVO[]
	 */
	public VskVslPortSkdConditionVO[] getVskVslPortSkdConditionVOs(){
		VskVslPortSkdConditionVO[] vos = (VskVslPortSkdConditionVO[])models.toArray(new VskVslPortSkdConditionVO[models.size()]);
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
		this.etb = this.etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etb2Dt = this.etb2Dt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsRmk = this.vpsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updTm = this.updTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctDt = this.cctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctTm = this.cctTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct = this.cct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtdFromDt = this.pfEtdFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptSeq = this.podClptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etb2Tm = this.etb2Tm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.terminal = this.terminal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDt = this.etbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbTm = this.etbTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtdToDt = this.pfEtdToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.terminal2 = this.terminal2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq = this.podClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtbFromDt = this.pfEtbFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortPol = this.vpsPortPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etb2 = this.etb2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortPod = this.vpsPortPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtbToDt = this.pfEtbToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdTm = this.etdTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCssmVoyNo = this.obCssmVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCssmVoyNo = this.ibCssmVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastCyAvail = this.lastCyAvail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
