/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VslSkdXchEdiDtlVO.java
*@FileTitle : VslSkdXchEdiDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.29  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VslSkdXchEdiDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslSkdXchEdiDtlVO> models = new ArrayList<VslSkdXchEdiDtlVO>();
	
	/* Column Info */
	private String vpsEtbDtCtnt = null;
	/* Column Info */
	private String vpsEtdDtCtnt = null;
	/* Column Info */
	private String vpsPortCdCtnt = null;
	/* Column Info */
	private String turnClptIndSeqCtnt = null;
	/* Column Info */
	private String clptIndSeqCtnt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String actArrDtCtnt = null;
	/* Column Info */
	private String turnPortIndCdCtnt = null;
	/* Column Info */
	private String ydCdCtnt = null;
	/* Column Info */
	private String vpsPortNm = null;
	/* Column Info */
	private String actBrthDtCtnt = null;
	/* Column Info */
	private String vslCdCtnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String turnPortFlgCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vpsEtaDtCtnt = null;
	/* Column Info */
	private String callYdIndSeqCtnt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String actDepDtCtnt = null;
	/* Column Info */
	private String skdDirCdCtnt = null;
	/* Column Info */
	private String ediXchLogSeq = null;
	/* Column Info */
	private String skdVoyNoCtnt = null;
	/* Column Info */
	private String turnSkdDirCdCtnt = null;
	/* Column Info */
	private String turnSkdVoyNoCtnt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String skdEdiRcvSeq = null;
	/* Column Info */
	private String locIndCdCtnt = null;
	/* Column Info */
	private String skdEdiRcvDt = null;
	/* Column Info */
	private String clptSeqCtnt = null;
	/* Column Info */
	private String sndRcvKndCd = null;
	
	/* Column Info */
	private String vslSlanCdCtnt = null;
	

	private String clptSeq = null;
	private String ydCd = null;
	private String callYdIndSeq = null;
	private String tmlCd = null;
	
	private String turnPortFlg = null;
	private String turnPortIndCd = null;
	private String turnSkdVoyNo = null;
	private String turnSkdDirCd = null;
	private String turnClptIndSeq = null;	
	
	/* Column Info */
	private String coCdCtnt = null;
	/* Column Info */
	private String allnPortCdCtnt = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VslSkdXchEdiDtlVO() {}

	public VslSkdXchEdiDtlVO(String ibflag, String pagerows, String sndRcvKndCd, String skdEdiRcvDt, String skdEdiRcvSeq, String ediXchLogSeq, String vpsPortCdCtnt, String vpsPortNm, String ydCdCtnt, String clptIndSeqCtnt, String clptSeqCtnt, String locIndCdCtnt, String callYdIndSeqCtnt, String vpsEtaDtCtnt, String vpsEtbDtCtnt, String vpsEtdDtCtnt, String actArrDtCtnt, String actBrthDtCtnt, String actDepDtCtnt, String turnPortFlgCtnt, String turnPortIndCdCtnt, String turnSkdVoyNoCtnt, String turnSkdDirCdCtnt, String turnClptIndSeqCtnt, String creUsrId, String creDt, String updUsrId, String updDt, String vslCdCtnt, String skdVoyNoCtnt, String skdDirCdCtnt) {
		this.vpsEtbDtCtnt = vpsEtbDtCtnt;
		this.vpsEtdDtCtnt = vpsEtdDtCtnt;
		this.vpsPortCdCtnt = vpsPortCdCtnt;
		this.turnClptIndSeqCtnt = turnClptIndSeqCtnt;
		this.clptIndSeqCtnt = clptIndSeqCtnt;
		this.creDt = creDt;
		this.actArrDtCtnt = actArrDtCtnt;
		this.turnPortIndCdCtnt = turnPortIndCdCtnt;
		this.ydCdCtnt = ydCdCtnt;
		this.vpsPortNm = vpsPortNm;
		this.actBrthDtCtnt = actBrthDtCtnt;
		this.vslCdCtnt = vslCdCtnt;
		this.pagerows = pagerows;
		this.turnPortFlgCtnt = turnPortFlgCtnt;
		this.ibflag = ibflag;
		this.vpsEtaDtCtnt = vpsEtaDtCtnt;
		this.callYdIndSeqCtnt = callYdIndSeqCtnt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.actDepDtCtnt = actDepDtCtnt;
		this.skdDirCdCtnt = skdDirCdCtnt;
		this.ediXchLogSeq = ediXchLogSeq;
		this.skdVoyNoCtnt = skdVoyNoCtnt;
		this.turnSkdDirCdCtnt = turnSkdDirCdCtnt;
		this.turnSkdVoyNoCtnt = turnSkdVoyNoCtnt;
		this.creUsrId = creUsrId;
		this.skdEdiRcvSeq = skdEdiRcvSeq;
		this.locIndCdCtnt = locIndCdCtnt;
		this.skdEdiRcvDt = skdEdiRcvDt;
		this.clptSeqCtnt = clptSeqCtnt;
		this.sndRcvKndCd = sndRcvKndCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vps_etb_dt_ctnt", getVpsEtbDtCtnt());
		this.hashColumns.put("vps_etd_dt_ctnt", getVpsEtdDtCtnt());
		this.hashColumns.put("vps_port_cd_ctnt", getVpsPortCdCtnt());
		this.hashColumns.put("turn_clpt_ind_seq_ctnt", getTurnClptIndSeqCtnt());
		this.hashColumns.put("clpt_ind_seq_ctnt", getClptIndSeqCtnt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("act_arr_dt_ctnt", getActArrDtCtnt());
		this.hashColumns.put("turn_port_ind_cd_ctnt", getTurnPortIndCdCtnt());
		this.hashColumns.put("yd_cd_ctnt", getYdCdCtnt());
		this.hashColumns.put("vps_port_nm", getVpsPortNm());
		this.hashColumns.put("act_brth_dt_ctnt", getActBrthDtCtnt());
		this.hashColumns.put("vsl_cd_ctnt", getVslCdCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("turn_port_flg_ctnt", getTurnPortFlgCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vps_eta_dt_ctnt", getVpsEtaDtCtnt());
		this.hashColumns.put("call_yd_ind_seq_ctnt", getCallYdIndSeqCtnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("act_dep_dt_ctnt", getActDepDtCtnt());
		this.hashColumns.put("skd_dir_cd_ctnt", getSkdDirCdCtnt());
		this.hashColumns.put("edi_xch_log_seq", getEdiXchLogSeq());
		this.hashColumns.put("skd_voy_no_ctnt", getSkdVoyNoCtnt());
		this.hashColumns.put("turn_skd_dir_cd_ctnt", getTurnSkdDirCdCtnt());
		this.hashColumns.put("turn_skd_voy_no_ctnt", getTurnSkdVoyNoCtnt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("skd_edi_rcv_seq", getSkdEdiRcvSeq());
		this.hashColumns.put("loc_ind_cd_ctnt", getLocIndCdCtnt());
		this.hashColumns.put("skd_edi_rcv_dt", getSkdEdiRcvDt());
		this.hashColumns.put("clpt_seq_ctnt", getClptSeqCtnt());
		this.hashColumns.put("snd_rcv_knd_cd", getSndRcvKndCd());
		
		this.hashColumns.put("vsl_slan_cd_ctnt", getVslSlanCdCtnt());
		
		this.hashColumns.put("co_cd_ctnt", getCoCdCtnt());
		this.hashColumns.put("alln_port_cd_ctnt", getAllnPortCdCtnt());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vps_etb_dt_ctnt", "vpsEtbDtCtnt");
		this.hashFields.put("vps_etd_dt_ctnt", "vpsEtdDtCtnt");
		this.hashFields.put("vps_port_cd_ctnt", "vpsPortCdCtnt");
		this.hashFields.put("turn_clpt_ind_seq_ctnt", "turnClptIndSeqCtnt");
		this.hashFields.put("clpt_ind_seq_ctnt", "clptIndSeqCtnt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("act_arr_dt_ctnt", "actArrDtCtnt");
		this.hashFields.put("turn_port_ind_cd_ctnt", "turnPortIndCdCtnt");
		this.hashFields.put("yd_cd_ctnt", "ydCdCtnt");
		this.hashFields.put("vps_port_nm", "vpsPortNm");
		this.hashFields.put("act_brth_dt_ctnt", "actBrthDtCtnt");
		this.hashFields.put("vsl_cd_ctnt", "vslCdCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("turn_port_flg_ctnt", "turnPortFlgCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vps_eta_dt_ctnt", "vpsEtaDtCtnt");
		this.hashFields.put("call_yd_ind_seq_ctnt", "callYdIndSeqCtnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("act_dep_dt_ctnt", "actDepDtCtnt");
		this.hashFields.put("skd_dir_cd_ctnt", "skdDirCdCtnt");
		this.hashFields.put("edi_xch_log_seq", "ediXchLogSeq");
		this.hashFields.put("skd_voy_no_ctnt", "skdVoyNoCtnt");
		this.hashFields.put("turn_skd_dir_cd_ctnt", "turnSkdDirCdCtnt");
		this.hashFields.put("turn_skd_voy_no_ctnt", "turnSkdVoyNoCtnt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("skd_edi_rcv_seq", "skdEdiRcvSeq");
		this.hashFields.put("loc_ind_cd_ctnt", "locIndCdCtnt");
		this.hashFields.put("skd_edi_rcv_dt", "skdEdiRcvDt");
		this.hashFields.put("clpt_seq_ctnt", "clptSeqCtnt");
		this.hashFields.put("snd_rcv_knd_cd", "sndRcvKndCd");
		
		this.hashFields.put("vsl_slan_cd_ctnt", "vslSlanCdCtnt");
		
		this.hashFields.put("clpt_seq", "clptSeq");                
		this.hashFields.put("yd_cd", "ydCd");                      
		this.hashFields.put("call_yd_ind_seq", "callYdIndSeq");    
		this.hashFields.put("tml_cd", "tmlCd");                    
		this.hashFields.put("turn_port_flg", "turnPortFlg");       
		this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");  
		this.hashFields.put("turn_skd_voy_no", "turnSkdVoyNo");    
		this.hashFields.put("turn_skd_dir_cd", "turnSkdDirCd");    
		this.hashFields.put("turn_clpt_ind_seq", "turnClptIndSeq");

		this.hashFields.put("co_cd_ctnt", "coCdCtnt");
		this.hashFields.put("alln_port_cd_ctnt", "allnPortCdCtnt");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vpsEtbDtCtnt
	 */
	public String getVpsEtbDtCtnt() {
		return this.vpsEtbDtCtnt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDtCtnt
	 */
	public String getVpsEtdDtCtnt() {
		return this.vpsEtdDtCtnt;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCdCtnt
	 */
	public String getVpsPortCdCtnt() {
		return this.vpsPortCdCtnt;
	}
	
	/**
	 * Column Info
	 * @return turnClptIndSeqCtnt
	 */
	public String getTurnClptIndSeqCtnt() {
		return this.turnClptIndSeqCtnt;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeqCtnt
	 */
	public String getClptIndSeqCtnt() {
		return this.clptIndSeqCtnt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return actArrDtCtnt
	 */
	public String getActArrDtCtnt() {
		return this.actArrDtCtnt;
	}
	
	/**
	 * Column Info
	 * @return turnPortIndCdCtnt
	 */
	public String getTurnPortIndCdCtnt() {
		return this.turnPortIndCdCtnt;
	}
	
	/**
	 * Column Info
	 * @return ydCdCtnt
	 */
	public String getYdCdCtnt() {
		return this.ydCdCtnt;
	}
	
	/**
	 * Column Info
	 * @return vpsPortNm
	 */
	public String getVpsPortNm() {
		return this.vpsPortNm;
	}
	
	/**
	 * Column Info
	 * @return actBrthDtCtnt
	 */
	public String getActBrthDtCtnt() {
		return this.actBrthDtCtnt;
	}
	
	/**
	 * Column Info
	 * @return vslCdCtnt
	 */
	public String getVslCdCtnt() {
		return this.vslCdCtnt;
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
	 * @return turnPortFlgCtnt
	 */
	public String getTurnPortFlgCtnt() {
		return this.turnPortFlgCtnt;
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
	 * @return vpsEtaDtCtnt
	 */
	public String getVpsEtaDtCtnt() {
		return this.vpsEtaDtCtnt;
	}
	
	/**
	 * Column Info
	 * @return callYdIndSeqCtnt
	 */
	public String getCallYdIndSeqCtnt() {
		return this.callYdIndSeqCtnt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return actDepDtCtnt
	 */
	public String getActDepDtCtnt() {
		return this.actDepDtCtnt;
	}
	
	/**
	 * Column Info
	 * @return skdDirCdCtnt
	 */
	public String getSkdDirCdCtnt() {
		return this.skdDirCdCtnt;
	}
	
	/**
	 * Column Info
	 * @return ediXchLogSeq
	 */
	public String getEdiXchLogSeq() {
		return this.ediXchLogSeq;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNoCtnt
	 */
	public String getSkdVoyNoCtnt() {
		return this.skdVoyNoCtnt;
	}
	
	/**
	 * Column Info
	 * @return turnSkdDirCdCtnt
	 */
	public String getTurnSkdDirCdCtnt() {
		return this.turnSkdDirCdCtnt;
	}
	
	/**
	 * Column Info
	 * @return turnSkdVoyNoCtnt
	 */
	public String getTurnSkdVoyNoCtnt() {
		return this.turnSkdVoyNoCtnt;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return skdEdiRcvSeq
	 */
	public String getSkdEdiRcvSeq() {
		return this.skdEdiRcvSeq;
	}
	
	/**
	 * Column Info
	 * @return locIndCdCtnt
	 */
	public String getLocIndCdCtnt() {
		return this.locIndCdCtnt;
	}
	
	/**
	 * Column Info
	 * @return skdEdiRcvDt
	 */
	public String getSkdEdiRcvDt() {
		return this.skdEdiRcvDt;
	}
	
	/**
	 * Column Info
	 * @return clptSeqCtnt
	 */
	public String getClptSeqCtnt() {
		return this.clptSeqCtnt;
	}
	
	/**
	 * Column Info
	 * @return sndRcvKndCd
	 */
	public String getSndRcvKndCd() {
		return this.sndRcvKndCd;
	}
	
	
	/**
	 * Column Info
	 * @return vslSlanCdCtnt
	 */
	public String getVslSlanCdCtnt() {
		return this.vslSlanCdCtnt;
	}

	/**
	 * Column Info
	 * @return coCdCtnt
	 */
	public String getCoCdCtnt() {
		return this.coCdCtnt;
	}
	
	/**
	 * Column Info
	 * @return allnPortCdCtnt
	 */
	public String getAllnPortCdCtnt() {
		return this.allnPortCdCtnt;
	}
	
	
	/**
	 * Column Info
	 * @param vpsEtbDtCtnt
	 */
	public void setVpsEtbDtCtnt(String vpsEtbDtCtnt) {
		this.vpsEtbDtCtnt = vpsEtbDtCtnt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDtCtnt
	 */
	public void setVpsEtdDtCtnt(String vpsEtdDtCtnt) {
		this.vpsEtdDtCtnt = vpsEtdDtCtnt;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCdCtnt
	 */
	public void setVpsPortCdCtnt(String vpsPortCdCtnt) {
		this.vpsPortCdCtnt = vpsPortCdCtnt;
	}
	
	/**
	 * Column Info
	 * @param turnClptIndSeqCtnt
	 */
	public void setTurnClptIndSeqCtnt(String turnClptIndSeqCtnt) {
		this.turnClptIndSeqCtnt = turnClptIndSeqCtnt;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeqCtnt
	 */
	public void setClptIndSeqCtnt(String clptIndSeqCtnt) {
		this.clptIndSeqCtnt = clptIndSeqCtnt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param actArrDtCtnt
	 */
	public void setActArrDtCtnt(String actArrDtCtnt) {
		this.actArrDtCtnt = actArrDtCtnt;
	}
	
	/**
	 * Column Info
	 * @param turnPortIndCdCtnt
	 */
	public void setTurnPortIndCdCtnt(String turnPortIndCdCtnt) {
		this.turnPortIndCdCtnt = turnPortIndCdCtnt;
	}
	
	/**
	 * Column Info
	 * @param ydCdCtnt
	 */
	public void setYdCdCtnt(String ydCdCtnt) {
		this.ydCdCtnt = ydCdCtnt;
	}
	
	/**
	 * Column Info
	 * @param vpsPortNm
	 */
	public void setVpsPortNm(String vpsPortNm) {
		this.vpsPortNm = vpsPortNm;
	}
	
	/**
	 * Column Info
	 * @param actBrthDtCtnt
	 */
	public void setActBrthDtCtnt(String actBrthDtCtnt) {
		this.actBrthDtCtnt = actBrthDtCtnt;
	}
	
	/**
	 * Column Info
	 * @param vslCdCtnt
	 */
	public void setVslCdCtnt(String vslCdCtnt) {
		this.vslCdCtnt = vslCdCtnt;
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
	 * @param turnPortFlgCtnt
	 */
	public void setTurnPortFlgCtnt(String turnPortFlgCtnt) {
		this.turnPortFlgCtnt = turnPortFlgCtnt;
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
	 * @param vpsEtaDtCtnt
	 */
	public void setVpsEtaDtCtnt(String vpsEtaDtCtnt) {
		this.vpsEtaDtCtnt = vpsEtaDtCtnt;
	}
	
	/**
	 * Column Info
	 * @param callYdIndSeqCtnt
	 */
	public void setCallYdIndSeqCtnt(String callYdIndSeqCtnt) {
		this.callYdIndSeqCtnt = callYdIndSeqCtnt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param actDepDtCtnt
	 */
	public void setActDepDtCtnt(String actDepDtCtnt) {
		this.actDepDtCtnt = actDepDtCtnt;
	}
	
	/**
	 * Column Info
	 * @param skdDirCdCtnt
	 */
	public void setSkdDirCdCtnt(String skdDirCdCtnt) {
		this.skdDirCdCtnt = skdDirCdCtnt;
	}
	
	/**
	 * Column Info
	 * @param ediXchLogSeq
	 */
	public void setEdiXchLogSeq(String ediXchLogSeq) {
		this.ediXchLogSeq = ediXchLogSeq;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNoCtnt
	 */
	public void setSkdVoyNoCtnt(String skdVoyNoCtnt) {
		this.skdVoyNoCtnt = skdVoyNoCtnt;
	}
	
	/**
	 * Column Info
	 * @param turnSkdDirCdCtnt
	 */
	public void setTurnSkdDirCdCtnt(String turnSkdDirCdCtnt) {
		this.turnSkdDirCdCtnt = turnSkdDirCdCtnt;
	}
	
	/**
	 * Column Info
	 * @param turnSkdVoyNoCtnt
	 */
	public void setTurnSkdVoyNoCtnt(String turnSkdVoyNoCtnt) {
		this.turnSkdVoyNoCtnt = turnSkdVoyNoCtnt;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param skdEdiRcvSeq
	 */
	public void setSkdEdiRcvSeq(String skdEdiRcvSeq) {
		this.skdEdiRcvSeq = skdEdiRcvSeq;
	}
	
	/**
	 * Column Info
	 * @param locIndCdCtnt
	 */
	public void setLocIndCdCtnt(String locIndCdCtnt) {
		this.locIndCdCtnt = locIndCdCtnt;
	}
	
	/**
	 * Column Info
	 * @param skdEdiRcvDt
	 */
	public void setSkdEdiRcvDt(String skdEdiRcvDt) {
		this.skdEdiRcvDt = skdEdiRcvDt;
	}
	
	/**
	 * Column Info
	 * @param clptSeqCtnt
	 */
	public void setClptSeqCtnt(String clptSeqCtnt) {
		this.clptSeqCtnt = clptSeqCtnt;
	}
	
	/**
	 * Column Info
	 * @param sndRcvKndCd
	 */
	public void setSndRcvKndCd(String sndRcvKndCd) {
		this.sndRcvKndCd = sndRcvKndCd;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCdCtnt
	 */
	public void setVslSlanCdCtnt(String vslSlanCdCtnt) {
		this.vslSlanCdCtnt = vslSlanCdCtnt;
	}
	
	/**
	 * Column Info
	 * @param coCdCtnt
	 */
	public void setCoCdCtnt(String coCdCtnt) {
		this.coCdCtnt = coCdCtnt;
	}
	
	/**
	 * Column Info
	 * @param allnPortCdCtnt
	 */
	public void setAllnPortCdCtnt(String allnPortCdCtnt) {
		this.allnPortCdCtnt = allnPortCdCtnt;
	}
	
	
	//================================================================================
	/**
	 * Column Info
	 * @return turnPortIndCd
	 */
	public String getTurnPortIndCd() {
		return this.turnPortIndCd;
	}
	/**
	 * Column Info
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
	}
	/**
	 * Column Info
	 * @return turnPortFlg
	 */
	public String getTurnPortFlg() {
		return this.turnPortFlg;
	}
	/**
	 * Column Info
	 * @return turnSkdDirCd
	 */
	public String getTurnSkdDirCd() {
		return this.turnSkdDirCd;
	}
	/**
	 * Column Info
	 * @return turnClptIndSeq
	 */
	public String getTurnClptIndSeq() {
		return this.turnClptIndSeq;
	}
	/**
	 * Column Info
	 * @return turnSkdVoyNo
	 */
	public String getTurnSkdVoyNo() {
		return this.turnSkdVoyNo;
	}
	/**
	 * Column Info
	 * @return callYdIndSeq
	 */
	public String getCallYdIndSeq() {
		return this.callYdIndSeq;
	}
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	/**
	 * Column Info
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
	}
	
	//----------------------------------------------------------------------------
	
	/**
	 * Column Info
	 * @param turnSkdVoyNo
	 */
	public void setTurnSkdVoyNo(String turnSkdVoyNo) {
		this.turnSkdVoyNo = turnSkdVoyNo;
	}
	/**
	 * Column Info
	 * @param turnPortIndCd
	 */
	public void setTurnPortIndCd(String turnPortIndCd) {
		this.turnPortIndCd = turnPortIndCd;
	}
	/**
	 * Column Info
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
	}
	/**
	 * Column Info
	 * @param turnClptIndSeq
	 */
	public void setTurnClptIndSeq(String turnClptIndSeq) {
		this.turnClptIndSeq = turnClptIndSeq;
	}
	/**
	 * Column Info
	 * @param turnPortFlg
	 */
	public void setTurnPortFlg(String turnPortFlg) {
		this.turnPortFlg = turnPortFlg;
	}
	/**
	 * Column Info
	 * @param turnSkdDirCd
	 */
	public void setTurnSkdDirCd(String turnSkdDirCd) {
		this.turnSkdDirCd = turnSkdDirCd;
	}
	/**
	 * Column Info
	 * @param callYdIndSeq
	 */
	public void setCallYdIndSeq(String callYdIndSeq) {
		this.callYdIndSeq = callYdIndSeq;
	}
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	/**
	 * Column Info
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
	}
	//================================================================================
	
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
		setVpsEtbDtCtnt(JSPUtil.getParameter(request, prefix + "vps_etb_dt_ctnt", ""));
		setVpsEtdDtCtnt(JSPUtil.getParameter(request, prefix + "vps_etd_dt_ctnt", ""));
		setVpsPortCdCtnt(JSPUtil.getParameter(request, prefix + "vps_port_cd_ctnt", ""));
		setTurnClptIndSeqCtnt(JSPUtil.getParameter(request, prefix + "turn_clpt_ind_seq_ctnt", ""));
		setClptIndSeqCtnt(JSPUtil.getParameter(request, prefix + "clpt_ind_seq_ctnt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setActArrDtCtnt(JSPUtil.getParameter(request, prefix + "act_arr_dt_ctnt", ""));
		setTurnPortIndCdCtnt(JSPUtil.getParameter(request, prefix + "turn_port_ind_cd_ctnt", ""));
		setYdCdCtnt(JSPUtil.getParameter(request, prefix + "yd_cd_ctnt", ""));
		setVpsPortNm(JSPUtil.getParameter(request, prefix + "vps_port_nm", ""));
		setActBrthDtCtnt(JSPUtil.getParameter(request, prefix + "act_brth_dt_ctnt", ""));
		setVslCdCtnt(JSPUtil.getParameter(request, prefix + "vsl_cd_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTurnPortFlgCtnt(JSPUtil.getParameter(request, prefix + "turn_port_flg_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVpsEtaDtCtnt(JSPUtil.getParameter(request, prefix + "vps_eta_dt_ctnt", ""));
		setCallYdIndSeqCtnt(JSPUtil.getParameter(request, prefix + "call_yd_ind_seq_ctnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setActDepDtCtnt(JSPUtil.getParameter(request, prefix + "act_dep_dt_ctnt", ""));
		setSkdDirCdCtnt(JSPUtil.getParameter(request, prefix + "skd_dir_cd_ctnt", ""));
		setEdiXchLogSeq(JSPUtil.getParameter(request, prefix + "edi_xch_log_seq", ""));
		setSkdVoyNoCtnt(JSPUtil.getParameter(request, prefix + "skd_voy_no_ctnt", ""));
		setTurnSkdDirCdCtnt(JSPUtil.getParameter(request, prefix + "turn_skd_dir_cd_ctnt", ""));
		setTurnSkdVoyNoCtnt(JSPUtil.getParameter(request, prefix + "turn_skd_voy_no_ctnt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSkdEdiRcvSeq(JSPUtil.getParameter(request, prefix + "skd_edi_rcv_seq", ""));
		setLocIndCdCtnt(JSPUtil.getParameter(request, prefix + "loc_ind_cd_ctnt", ""));
		setSkdEdiRcvDt(JSPUtil.getParameter(request, prefix + "skd_edi_rcv_dt", ""));
		setClptSeqCtnt(JSPUtil.getParameter(request, prefix + "clpt_seq_ctnt", ""));
		setSndRcvKndCd(JSPUtil.getParameter(request, prefix + "snd_rcv_knd_cd", ""));
		
		setVslSlanCdCtnt(JSPUtil.getParameter(request, prefix + "vsl_slan_cd_ctnt", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslSkdXchEdiDtlVO[]
	 */
	public VslSkdXchEdiDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslSkdXchEdiDtlVO[]
	 */
	public VslSkdXchEdiDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslSkdXchEdiDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vpsEtbDtCtnt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt_ctnt", length));
			String[] vpsEtdDtCtnt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt_ctnt", length));
			String[] vpsPortCdCtnt = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd_ctnt", length));
			String[] turnClptIndSeqCtnt = (JSPUtil.getParameter(request, prefix	+ "turn_clpt_ind_seq_ctnt", length));
			String[] clptIndSeqCtnt = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq_ctnt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] actArrDtCtnt = (JSPUtil.getParameter(request, prefix	+ "act_arr_dt_ctnt", length));
			String[] turnPortIndCdCtnt = (JSPUtil.getParameter(request, prefix	+ "turn_port_ind_cd_ctnt", length));
			String[] ydCdCtnt = (JSPUtil.getParameter(request, prefix	+ "yd_cd_ctnt", length));
			String[] vpsPortNm = (JSPUtil.getParameter(request, prefix	+ "vps_port_nm", length));
			String[] actBrthDtCtnt = (JSPUtil.getParameter(request, prefix	+ "act_brth_dt_ctnt", length));
			String[] vslCdCtnt = (JSPUtil.getParameter(request, prefix	+ "vsl_cd_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] turnPortFlgCtnt = (JSPUtil.getParameter(request, prefix	+ "turn_port_flg_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vpsEtaDtCtnt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt_ctnt", length));
			String[] callYdIndSeqCtnt = (JSPUtil.getParameter(request, prefix	+ "call_yd_ind_seq_ctnt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] actDepDtCtnt = (JSPUtil.getParameter(request, prefix	+ "act_dep_dt_ctnt", length));
			String[] skdDirCdCtnt = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd_ctnt", length));
			String[] ediXchLogSeq = (JSPUtil.getParameter(request, prefix	+ "edi_xch_log_seq", length));
			String[] skdVoyNoCtnt = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no_ctnt", length));
			String[] turnSkdDirCdCtnt = (JSPUtil.getParameter(request, prefix	+ "turn_skd_dir_cd_ctnt", length));
			String[] turnSkdVoyNoCtnt = (JSPUtil.getParameter(request, prefix	+ "turn_skd_voy_no_ctnt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] skdEdiRcvSeq = (JSPUtil.getParameter(request, prefix	+ "skd_edi_rcv_seq", length));
			String[] locIndCdCtnt = (JSPUtil.getParameter(request, prefix	+ "loc_ind_cd_ctnt", length));
			String[] skdEdiRcvDt = (JSPUtil.getParameter(request, prefix	+ "skd_edi_rcv_dt", length));
			String[] clptSeqCtnt = (JSPUtil.getParameter(request, prefix	+ "clpt_seq_ctnt", length));
			String[] sndRcvKndCd = (JSPUtil.getParameter(request, prefix	+ "snd_rcv_knd_cd", length));
			
			String[] vslSlanCdCtnt = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd_ctnt", length));
			
			String[] clptSeq 			 = (JSPUtil.getParameter(request, prefix	+ "clptSeq", length));          
			String[] ydCd 			     = (JSPUtil.getParameter(request, prefix	+ "ydCd", length));             
			String[] callYdIndSeq 	     = (JSPUtil.getParameter(request, prefix	+ "callYdIndSeq", length));     
			String[] tmlCd 			     = (JSPUtil.getParameter(request, prefix	+ "tmlCd", length));            
			String[] turnPortFlg 		 = (JSPUtil.getParameter(request, prefix	+ "turnPortFlg", length));      
			String[] turnPortIndCd 	     = (JSPUtil.getParameter(request, prefix	+ "turnPortIndCd", length));    
			String[] turnSkdVoyNo 	     = (JSPUtil.getParameter(request, prefix	+ "turnSkdVoyNo", length));     
			String[] turnSkdDirCd 	     = (JSPUtil.getParameter(request, prefix	+ "turnSkdDirCd", length));	    
			String[] turnClptIndSeq 	 = (JSPUtil.getParameter(request, prefix	+ "turnClptIndSeq", length));	
			
			for (int i = 0; i < length; i++) {
				model = new VslSkdXchEdiDtlVO();
				if (vpsEtbDtCtnt[i] != null)
					model.setVpsEtbDtCtnt(vpsEtbDtCtnt[i]);
				if (vpsEtdDtCtnt[i] != null)
					model.setVpsEtdDtCtnt(vpsEtdDtCtnt[i]);
				if (vpsPortCdCtnt[i] != null)
					model.setVpsPortCdCtnt(vpsPortCdCtnt[i]);
				if (turnClptIndSeqCtnt[i] != null)
					model.setTurnClptIndSeqCtnt(turnClptIndSeqCtnt[i]);
				if (clptIndSeqCtnt[i] != null)
					model.setClptIndSeqCtnt(clptIndSeqCtnt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (actArrDtCtnt[i] != null)
					model.setActArrDtCtnt(actArrDtCtnt[i]);
				if (turnPortIndCdCtnt[i] != null)
					model.setTurnPortIndCdCtnt(turnPortIndCdCtnt[i]);
				if (ydCdCtnt[i] != null)
					model.setYdCdCtnt(ydCdCtnt[i]);
				if (vpsPortNm[i] != null)
					model.setVpsPortNm(vpsPortNm[i]);
				if (actBrthDtCtnt[i] != null)
					model.setActBrthDtCtnt(actBrthDtCtnt[i]);
				if (vslCdCtnt[i] != null)
					model.setVslCdCtnt(vslCdCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (turnPortFlgCtnt[i] != null)
					model.setTurnPortFlgCtnt(turnPortFlgCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vpsEtaDtCtnt[i] != null)
					model.setVpsEtaDtCtnt(vpsEtaDtCtnt[i]);
				if (callYdIndSeqCtnt[i] != null)
					model.setCallYdIndSeqCtnt(callYdIndSeqCtnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (actDepDtCtnt[i] != null)
					model.setActDepDtCtnt(actDepDtCtnt[i]);
				if (skdDirCdCtnt[i] != null)
					model.setSkdDirCdCtnt(skdDirCdCtnt[i]);
				if (ediXchLogSeq[i] != null)
					model.setEdiXchLogSeq(ediXchLogSeq[i]);
				if (skdVoyNoCtnt[i] != null)
					model.setSkdVoyNoCtnt(skdVoyNoCtnt[i]);
				if (turnSkdDirCdCtnt[i] != null)
					model.setTurnSkdDirCdCtnt(turnSkdDirCdCtnt[i]);
				if (turnSkdVoyNoCtnt[i] != null)
					model.setTurnSkdVoyNoCtnt(turnSkdVoyNoCtnt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (skdEdiRcvSeq[i] != null)
					model.setSkdEdiRcvSeq(skdEdiRcvSeq[i]);
				if (locIndCdCtnt[i] != null)
					model.setLocIndCdCtnt(locIndCdCtnt[i]);
				if (skdEdiRcvDt[i] != null)
					model.setSkdEdiRcvDt(skdEdiRcvDt[i]);
				if (clptSeqCtnt[i] != null)
					model.setClptSeqCtnt(clptSeqCtnt[i]);
				if (sndRcvKndCd[i] != null)
					model.setSndRcvKndCd(sndRcvKndCd[i]);
				
				if (vslSlanCdCtnt[i] != null)
					model.setVslSlanCdCtnt(vslSlanCdCtnt[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (callYdIndSeq[i] != null)
					model.setCallYdIndSeq(callYdIndSeq[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (turnPortFlg[i] != null)
					model.setTurnPortFlg(turnPortFlg[i]);
				if (turnPortIndCd[i] != null)
					model.setTurnPortIndCd(turnPortIndCd[i]);
				if (turnSkdVoyNo[i] != null)
					model.setTurnSkdVoyNo(turnSkdVoyNo[i]);
				if (turnSkdDirCd[i] != null)
					model.setTurnSkdDirCd(turnSkdDirCd[i]);
				if (turnClptIndSeq[i] != null)
					model.setTurnClptIndSeq(turnClptIndSeq[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslSkdXchEdiDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VslSkdXchEdiDtlVO[]
	 */
	public VslSkdXchEdiDtlVO[] getVslSkdXchEdiDtlVOs(){
		VslSkdXchEdiDtlVO[] vos = (VslSkdXchEdiDtlVO[])models.toArray(new VslSkdXchEdiDtlVO[models.size()]);
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
		this.vpsEtbDtCtnt = this.vpsEtbDtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDtCtnt = this.vpsEtdDtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCdCtnt = this.vpsPortCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnClptIndSeqCtnt = this.turnClptIndSeqCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeqCtnt = this.clptIndSeqCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actArrDtCtnt = this.actArrDtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortIndCdCtnt = this.turnPortIndCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCdCtnt = this.ydCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortNm = this.vpsPortNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actBrthDtCtnt = this.actBrthDtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCdCtnt = this.vslCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortFlgCtnt = this.turnPortFlgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDtCtnt = this.vpsEtaDtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYdIndSeqCtnt = this.callYdIndSeqCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDepDtCtnt = this.actDepDtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCdCtnt = this.skdDirCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediXchLogSeq = this.ediXchLogSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNoCtnt = this.skdVoyNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnSkdDirCdCtnt = this.turnSkdDirCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnSkdVoyNoCtnt = this.turnSkdVoyNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdEdiRcvSeq = this.skdEdiRcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locIndCdCtnt = this.locIndCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdEdiRcvDt = this.skdEdiRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeqCtnt = this.clptSeqCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndRcvKndCd = this.sndRcvKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
