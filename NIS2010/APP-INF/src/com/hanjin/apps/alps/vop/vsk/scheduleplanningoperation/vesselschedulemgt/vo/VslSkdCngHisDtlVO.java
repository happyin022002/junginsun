/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VslSkdCngHisDtlVO.java
*@FileTitle : VslSkdCngHisDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.30
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2013.07.30 정상기 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

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
 * @author 정상기
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VslSkdCngHisDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslSkdCngHisDtlVO> models = new ArrayList<VslSkdCngHisDtlVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String turnPortFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String phsIoRsnCd = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String turnSkdVoyNo = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String turnSkdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pairRvsPortCd = null;
	/* Column Info */
	private String turnPortIndCd = null;
	/* Column Info */
	private String portSkpTpCd = null;
	/* Column Info */
	private String clptSeq = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ntfcTrsmCmplFlg = null;
	/* Column Info */
	private String vskdTmlCngTpCd = null;
	/* Column Info */
	private String pairRvsClptIndSeq = null;
	/* Column Info */
	private String hisDtlSeq = null;
	/* Column Info */
	private String callYdIndSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String initEtaDt = null;
	/* Column Info */
	private String vvdHisSeq = null;
	/* Column Info */
	private String pfEtdDt = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String initEtbDt = null;
	/* Column Info */
	private String bfrYdCd = null;
	/* Column Info */
	private String portSkpRsnCd = null;
	/* Column Info */
	private String pfEtaDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String pfEtbDt = null;
	/* Column Info */
	private String initEtdDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String skdCngStsCd = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String turnClptIndSeq = null;
	
	/* Column Info */
	private String hisCreUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VslSkdCngHisDtlVO() {}

	public VslSkdCngHisDtlVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vvdHisSeq, String vpsPortCd, String clptIndSeq, String hisDtlSeq, String vslSlanCd, String clptSeq, String bfrYdCd, String crntYdCd, String callYdIndSeq, String vskdTmlCngTpCd, String skdCngStsCd, String pfEtaDt, String pfEtbDt, String pfEtdDt, String initEtaDt, String initEtbDt, String initEtdDt, String vpsEtaDt, String vpsEtbDt, String vpsEtdDt, String turnPortFlg, String turnPortIndCd, String turnSkdVoyNo, String turnSkdDirCd, String turnClptIndSeq, String pairRvsPortCd, String pairRvsClptIndSeq, String portSkpTpCd, String portSkpRsnCd, String phsIoRsnCd, String ntfcTrsmCmplFlg, String creUsrId, String creDt, String updUsrId, String updDt, String hisCreUsrId) {
		this.vslCd = vslCd;
		this.vpsEtbDt = vpsEtbDt;
		this.turnPortFlg = turnPortFlg;
		this.creDt = creDt;
		this.phsIoRsnCd = phsIoRsnCd;
		this.crntYdCd = crntYdCd;
		this.turnSkdVoyNo = turnSkdVoyNo;
		this.vslSlanCd = vslSlanCd;
		this.vpsEtaDt = vpsEtaDt;
		this.turnSkdDirCd = turnSkdDirCd;
		this.pagerows = pagerows;
		this.pairRvsPortCd = pairRvsPortCd;
		this.turnPortIndCd = turnPortIndCd;
		this.portSkpTpCd = portSkpTpCd;
		this.clptSeq = clptSeq;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.ntfcTrsmCmplFlg = ntfcTrsmCmplFlg;
		this.vskdTmlCngTpCd = vskdTmlCngTpCd;
		this.pairRvsClptIndSeq = pairRvsClptIndSeq;
		this.hisDtlSeq = hisDtlSeq;
		this.callYdIndSeq = callYdIndSeq;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.initEtaDt = initEtaDt;
		this.vvdHisSeq = vvdHisSeq;
		this.pfEtdDt = pfEtdDt;
		this.vpsEtdDt = vpsEtdDt;
		this.initEtbDt = initEtbDt;
		this.bfrYdCd = bfrYdCd;
		this.portSkpRsnCd = portSkpRsnCd;
		this.pfEtaDt = pfEtaDt;
		this.skdVoyNo = skdVoyNo;
		this.pfEtbDt = pfEtbDt;
		this.initEtdDt = initEtdDt;
		this.skdDirCd = skdDirCd;
		this.creUsrId = creUsrId;
		this.skdCngStsCd = skdCngStsCd;
		this.clptIndSeq = clptIndSeq;
		this.turnClptIndSeq = turnClptIndSeq;
		
		this.hisCreUsrId = hisCreUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("turn_port_flg", getTurnPortFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("phs_io_rsn_cd", getPhsIoRsnCd());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("turn_skd_voy_no", getTurnSkdVoyNo());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("turn_skd_dir_cd", getTurnSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pair_rvs_port_cd", getPairRvsPortCd());
		this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());
		this.hashColumns.put("port_skp_tp_cd", getPortSkpTpCd());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ntfc_trsm_cmpl_flg", getNtfcTrsmCmplFlg());
		this.hashColumns.put("vskd_tml_cng_tp_cd", getVskdTmlCngTpCd());
		this.hashColumns.put("pair_rvs_clpt_ind_seq", getPairRvsClptIndSeq());
		this.hashColumns.put("his_dtl_seq", getHisDtlSeq());
		this.hashColumns.put("call_yd_ind_seq", getCallYdIndSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("init_eta_dt", getInitEtaDt());
		this.hashColumns.put("vvd_his_seq", getVvdHisSeq());
		this.hashColumns.put("pf_etd_dt", getPfEtdDt());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("init_etb_dt", getInitEtbDt());
		this.hashColumns.put("bfr_yd_cd", getBfrYdCd());
		this.hashColumns.put("port_skp_rsn_cd", getPortSkpRsnCd());
		this.hashColumns.put("pf_eta_dt", getPfEtaDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("pf_etb_dt", getPfEtbDt());
		this.hashColumns.put("init_etd_dt", getInitEtdDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("skd_cng_sts_cd", getSkdCngStsCd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("turn_clpt_ind_seq", getTurnClptIndSeq());
		
		this.hashColumns.put("his_cre_usr_id", getHisCreUsrId());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("turn_port_flg", "turnPortFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("phs_io_rsn_cd", "phsIoRsnCd");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("turn_skd_voy_no", "turnSkdVoyNo");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("turn_skd_dir_cd", "turnSkdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pair_rvs_port_cd", "pairRvsPortCd");
		this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
		this.hashFields.put("port_skp_tp_cd", "portSkpTpCd");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ntfc_trsm_cmpl_flg", "ntfcTrsmCmplFlg");
		this.hashFields.put("vskd_tml_cng_tp_cd", "vskdTmlCngTpCd");
		this.hashFields.put("pair_rvs_clpt_ind_seq", "pairRvsClptIndSeq");
		this.hashFields.put("his_dtl_seq", "hisDtlSeq");
		this.hashFields.put("call_yd_ind_seq", "callYdIndSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("init_eta_dt", "initEtaDt");
		this.hashFields.put("vvd_his_seq", "vvdHisSeq");
		this.hashFields.put("pf_etd_dt", "pfEtdDt");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("init_etb_dt", "initEtbDt");
		this.hashFields.put("bfr_yd_cd", "bfrYdCd");
		this.hashFields.put("port_skp_rsn_cd", "portSkpRsnCd");
		this.hashFields.put("pf_eta_dt", "pfEtaDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pf_etb_dt", "pfEtbDt");
		this.hashFields.put("init_etd_dt", "initEtdDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("skd_cng_sts_cd", "skdCngStsCd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("turn_clpt_ind_seq", "turnClptIndSeq");
		
		this.hashFields.put("his_cre_usr_id", "hisCreUsrId");
		
		return this.hashFields;
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
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return phsIoRsnCd
	 */
	public String getPhsIoRsnCd() {
		return this.phsIoRsnCd;
	}
	
	/**
	 * Column Info
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
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
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return turnSkdDirCd
	 */
	public String getTurnSkdDirCd() {
		return this.turnSkdDirCd;
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
	 * @return pairRvsPortCd
	 */
	public String getPairRvsPortCd() {
		return this.pairRvsPortCd;
	}
	
	/**
	 * Column Info
	 * @return turnPortIndCd
	 */
	public String getTurnPortIndCd() {
		return this.turnPortIndCd;
	}
	
	/**
	 * Column Info
	 * @return portSkpTpCd
	 */
	public String getPortSkpTpCd() {
		return this.portSkpTpCd;
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
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return ntfcTrsmCmplFlg
	 */
	public String getNtfcTrsmCmplFlg() {
		return this.ntfcTrsmCmplFlg;
	}
	
	/**
	 * Column Info
	 * @return vskdTmlCngTpCd
	 */
	public String getVskdTmlCngTpCd() {
		return this.vskdTmlCngTpCd;
	}
	
	/**
	 * Column Info
	 * @return pairRvsClptIndSeq
	 */
	public String getPairRvsClptIndSeq() {
		return this.pairRvsClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return hisDtlSeq
	 */
	public String getHisDtlSeq() {
		return this.hisDtlSeq;
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
	 * @return initEtaDt
	 */
	public String getInitEtaDt() {
		return this.initEtaDt;
	}
	
	/**
	 * Column Info
	 * @return vvdHisSeq
	 */
	public String getVvdHisSeq() {
		return this.vvdHisSeq;
	}
	
	/**
	 * Column Info
	 * @return pfEtdDt
	 */
	public String getPfEtdDt() {
		return this.pfEtdDt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return initEtbDt
	 */
	public String getInitEtbDt() {
		return this.initEtbDt;
	}
	
	/**
	 * Column Info
	 * @return bfrYdCd
	 */
	public String getBfrYdCd() {
		return this.bfrYdCd;
	}
	
	/**
	 * Column Info
	 * @return portSkpRsnCd
	 */
	public String getPortSkpRsnCd() {
		return this.portSkpRsnCd;
	}
	
	/**
	 * Column Info
	 * @return pfEtaDt
	 */
	public String getPfEtaDt() {
		return this.pfEtaDt;
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
	 * @return pfEtbDt
	 */
	public String getPfEtbDt() {
		return this.pfEtbDt;
	}
	
	/**
	 * Column Info
	 * @return initEtdDt
	 */
	public String getInitEtdDt() {
		return this.initEtdDt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return skdCngStsCd
	 */
	public String getSkdCngStsCd() {
		return this.skdCngStsCd;
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
	 * @return turnClptIndSeq
	 */
	public String getTurnClptIndSeq() {
		return this.turnClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return hisCreUsrId
	 */
	public String getHisCreUsrId() {
		return this.hisCreUsrId;
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
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param phsIoRsnCd
	 */
	public void setPhsIoRsnCd(String phsIoRsnCd) {
		this.phsIoRsnCd = phsIoRsnCd;
	}
	
	/**
	 * Column Info
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}
	
	/**
	 * Column Info
	 * @param turnSkdVoyNo
	 */
	public void setTurnSkdVoyNo(String turnSkdVoyNo) {
		this.turnSkdVoyNo = turnSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param turnSkdDirCd
	 */
	public void setTurnSkdDirCd(String turnSkdDirCd) {
		this.turnSkdDirCd = turnSkdDirCd;
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
	 * @param pairRvsPortCd
	 */
	public void setPairRvsPortCd(String pairRvsPortCd) {
		this.pairRvsPortCd = pairRvsPortCd;
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
	 * @param portSkpTpCd
	 */
	public void setPortSkpTpCd(String portSkpTpCd) {
		this.portSkpTpCd = portSkpTpCd;
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
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param ntfcTrsmCmplFlg
	 */
	public void setNtfcTrsmCmplFlg(String ntfcTrsmCmplFlg) {
		this.ntfcTrsmCmplFlg = ntfcTrsmCmplFlg;
	}
	
	/**
	 * Column Info
	 * @param vskdTmlCngTpCd
	 */
	public void setVskdTmlCngTpCd(String vskdTmlCngTpCd) {
		this.vskdTmlCngTpCd = vskdTmlCngTpCd;
	}
	
	/**
	 * Column Info
	 * @param pairRvsClptIndSeq
	 */
	public void setPairRvsClptIndSeq(String pairRvsClptIndSeq) {
		this.pairRvsClptIndSeq = pairRvsClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param hisDtlSeq
	 */
	public void setHisDtlSeq(String hisDtlSeq) {
		this.hisDtlSeq = hisDtlSeq;
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
	 * @param initEtaDt
	 */
	public void setInitEtaDt(String initEtaDt) {
		this.initEtaDt = initEtaDt;
	}
	
	/**
	 * Column Info
	 * @param vvdHisSeq
	 */
	public void setVvdHisSeq(String vvdHisSeq) {
		this.vvdHisSeq = vvdHisSeq;
	}
	
	/**
	 * Column Info
	 * @param pfEtdDt
	 */
	public void setPfEtdDt(String pfEtdDt) {
		this.pfEtdDt = pfEtdDt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param initEtbDt
	 */
	public void setInitEtbDt(String initEtbDt) {
		this.initEtbDt = initEtbDt;
	}
	
	/**
	 * Column Info
	 * @param bfrYdCd
	 */
	public void setBfrYdCd(String bfrYdCd) {
		this.bfrYdCd = bfrYdCd;
	}
	
	/**
	 * Column Info
	 * @param portSkpRsnCd
	 */
	public void setPortSkpRsnCd(String portSkpRsnCd) {
		this.portSkpRsnCd = portSkpRsnCd;
	}
	
	/**
	 * Column Info
	 * @param pfEtaDt
	 */
	public void setPfEtaDt(String pfEtaDt) {
		this.pfEtaDt = pfEtaDt;
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
	 * @param pfEtbDt
	 */
	public void setPfEtbDt(String pfEtbDt) {
		this.pfEtbDt = pfEtbDt;
	}
	
	/**
	 * Column Info
	 * @param initEtdDt
	 */
	public void setInitEtdDt(String initEtdDt) {
		this.initEtdDt = initEtdDt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param skdCngStsCd
	 */
	public void setSkdCngStsCd(String skdCngStsCd) {
		this.skdCngStsCd = skdCngStsCd;
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
	 * @param turnClptIndSeq
	 */
	public void setTurnClptIndSeq(String turnClptIndSeq) {
		this.turnClptIndSeq = turnClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param hisCreUsrId
	 */
	public void setHisCreUsrId(String hisCreUsrId) {
		this.hisCreUsrId = hisCreUsrId;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setTurnPortFlg(JSPUtil.getParameter(request, prefix + "turn_port_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPhsIoRsnCd(JSPUtil.getParameter(request, prefix + "phs_io_rsn_cd", ""));
		setCrntYdCd(JSPUtil.getParameter(request, prefix + "crnt_yd_cd", ""));
		setTurnSkdVoyNo(JSPUtil.getParameter(request, prefix + "turn_skd_voy_no", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setTurnSkdDirCd(JSPUtil.getParameter(request, prefix + "turn_skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPairRvsPortCd(JSPUtil.getParameter(request, prefix + "pair_rvs_port_cd", ""));
		setTurnPortIndCd(JSPUtil.getParameter(request, prefix + "turn_port_ind_cd", ""));
		setPortSkpTpCd(JSPUtil.getParameter(request, prefix + "port_skp_tp_cd", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNtfcTrsmCmplFlg(JSPUtil.getParameter(request, prefix + "ntfc_trsm_cmpl_flg", ""));
		setVskdTmlCngTpCd(JSPUtil.getParameter(request, prefix + "vskd_tml_cng_tp_cd", ""));
		setPairRvsClptIndSeq(JSPUtil.getParameter(request, prefix + "pair_rvs_clpt_ind_seq", ""));
		setHisDtlSeq(JSPUtil.getParameter(request, prefix + "his_dtl_seq", ""));
		setCallYdIndSeq(JSPUtil.getParameter(request, prefix + "call_yd_ind_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setInitEtaDt(JSPUtil.getParameter(request, prefix + "init_eta_dt", ""));
		setVvdHisSeq(JSPUtil.getParameter(request, prefix + "vvd_his_seq", ""));
		setPfEtdDt(JSPUtil.getParameter(request, prefix + "pf_etd_dt", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setInitEtbDt(JSPUtil.getParameter(request, prefix + "init_etb_dt", ""));
		setBfrYdCd(JSPUtil.getParameter(request, prefix + "bfr_yd_cd", ""));
		setPortSkpRsnCd(JSPUtil.getParameter(request, prefix + "port_skp_rsn_cd", ""));
		setPfEtaDt(JSPUtil.getParameter(request, prefix + "pf_eta_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setPfEtbDt(JSPUtil.getParameter(request, prefix + "pf_etb_dt", ""));
		setInitEtdDt(JSPUtil.getParameter(request, prefix + "init_etd_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSkdCngStsCd(JSPUtil.getParameter(request, prefix + "skd_cng_sts_cd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setTurnClptIndSeq(JSPUtil.getParameter(request, prefix + "turn_clpt_ind_seq", ""));
		
		setHisCreUsrId(JSPUtil.getParameter(request, prefix + "his_cre_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslSkdCngHisDtlVO[]
	 */
	public VslSkdCngHisDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslSkdCngHisDtlVO[]
	 */
	public VslSkdCngHisDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslSkdCngHisDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] turnPortFlg = (JSPUtil.getParameter(request, prefix	+ "turn_port_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] phsIoRsnCd = (JSPUtil.getParameter(request, prefix	+ "phs_io_rsn_cd", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] turnSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "turn_skd_voy_no", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] turnSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "turn_skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pairRvsPortCd = (JSPUtil.getParameter(request, prefix	+ "pair_rvs_port_cd", length));
			String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix	+ "turn_port_ind_cd", length));
			String[] portSkpTpCd = (JSPUtil.getParameter(request, prefix	+ "port_skp_tp_cd", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ntfcTrsmCmplFlg = (JSPUtil.getParameter(request, prefix	+ "ntfc_trsm_cmpl_flg", length));
			String[] vskdTmlCngTpCd = (JSPUtil.getParameter(request, prefix	+ "vskd_tml_cng_tp_cd", length));
			String[] pairRvsClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pair_rvs_clpt_ind_seq", length));
			String[] hisDtlSeq = (JSPUtil.getParameter(request, prefix	+ "his_dtl_seq", length));
			String[] callYdIndSeq = (JSPUtil.getParameter(request, prefix	+ "call_yd_ind_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] initEtaDt = (JSPUtil.getParameter(request, prefix	+ "init_eta_dt", length));
			String[] vvdHisSeq = (JSPUtil.getParameter(request, prefix	+ "vvd_his_seq", length));
			String[] pfEtdDt = (JSPUtil.getParameter(request, prefix	+ "pf_etd_dt", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] initEtbDt = (JSPUtil.getParameter(request, prefix	+ "init_etb_dt", length));
			String[] bfrYdCd = (JSPUtil.getParameter(request, prefix	+ "bfr_yd_cd", length));
			String[] portSkpRsnCd = (JSPUtil.getParameter(request, prefix	+ "port_skp_rsn_cd", length));
			String[] pfEtaDt = (JSPUtil.getParameter(request, prefix	+ "pf_eta_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] pfEtbDt = (JSPUtil.getParameter(request, prefix	+ "pf_etb_dt", length));
			String[] initEtdDt = (JSPUtil.getParameter(request, prefix	+ "init_etd_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] skdCngStsCd = (JSPUtil.getParameter(request, prefix	+ "skd_cng_sts_cd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] turnClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "turn_clpt_ind_seq", length));
			
			String[] hisCreUsrId = (JSPUtil.getParameter(request, prefix	+ "his_cre_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new VslSkdCngHisDtlVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (turnPortFlg[i] != null)
					model.setTurnPortFlg(turnPortFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (phsIoRsnCd[i] != null)
					model.setPhsIoRsnCd(phsIoRsnCd[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (turnSkdVoyNo[i] != null)
					model.setTurnSkdVoyNo(turnSkdVoyNo[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (turnSkdDirCd[i] != null)
					model.setTurnSkdDirCd(turnSkdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pairRvsPortCd[i] != null)
					model.setPairRvsPortCd(pairRvsPortCd[i]);
				if (turnPortIndCd[i] != null)
					model.setTurnPortIndCd(turnPortIndCd[i]);
				if (portSkpTpCd[i] != null)
					model.setPortSkpTpCd(portSkpTpCd[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ntfcTrsmCmplFlg[i] != null)
					model.setNtfcTrsmCmplFlg(ntfcTrsmCmplFlg[i]);
				if (vskdTmlCngTpCd[i] != null)
					model.setVskdTmlCngTpCd(vskdTmlCngTpCd[i]);
				if (pairRvsClptIndSeq[i] != null)
					model.setPairRvsClptIndSeq(pairRvsClptIndSeq[i]);
				if (hisDtlSeq[i] != null)
					model.setHisDtlSeq(hisDtlSeq[i]);
				if (callYdIndSeq[i] != null)
					model.setCallYdIndSeq(callYdIndSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (initEtaDt[i] != null)
					model.setInitEtaDt(initEtaDt[i]);
				if (vvdHisSeq[i] != null)
					model.setVvdHisSeq(vvdHisSeq[i]);
				if (pfEtdDt[i] != null)
					model.setPfEtdDt(pfEtdDt[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (initEtbDt[i] != null)
					model.setInitEtbDt(initEtbDt[i]);
				if (bfrYdCd[i] != null)
					model.setBfrYdCd(bfrYdCd[i]);
				if (portSkpRsnCd[i] != null)
					model.setPortSkpRsnCd(portSkpRsnCd[i]);
				if (pfEtaDt[i] != null)
					model.setPfEtaDt(pfEtaDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (pfEtbDt[i] != null)
					model.setPfEtbDt(pfEtbDt[i]);
				if (initEtdDt[i] != null)
					model.setInitEtdDt(initEtdDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (skdCngStsCd[i] != null)
					model.setSkdCngStsCd(skdCngStsCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (turnClptIndSeq[i] != null)
					model.setTurnClptIndSeq(turnClptIndSeq[i]);
				
				if (hisCreUsrId[i] != null)
					model.setHisCreUsrId(hisCreUsrId[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslSkdCngHisDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VslSkdCngHisDtlVO[]
	 */
	public VslSkdCngHisDtlVO[] getVslSkdCngHisDtlVOs(){
		VslSkdCngHisDtlVO[] vos = (VslSkdCngHisDtlVO[])models.toArray(new VslSkdCngHisDtlVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortFlg = this.turnPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phsIoRsnCd = this.phsIoRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnSkdVoyNo = this.turnSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnSkdDirCd = this.turnSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pairRvsPortCd = this.pairRvsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortIndCd = this.turnPortIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSkpTpCd = this.portSkpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfcTrsmCmplFlg = this.ntfcTrsmCmplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vskdTmlCngTpCd = this.vskdTmlCngTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pairRvsClptIndSeq = this.pairRvsClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisDtlSeq = this.hisDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYdIndSeq = this.callYdIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtaDt = this.initEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdHisSeq = this.vvdHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtdDt = this.pfEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtbDt = this.initEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrYdCd = this.bfrYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSkpRsnCd = this.portSkpRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtaDt = this.pfEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtbDt = this.pfEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtdDt = this.initEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdCngStsCd = this.skdCngStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnClptIndSeq = this.turnClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.hisCreUsrId = this.hisCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
