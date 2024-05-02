/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VskVipsIfDtlVO.java
*@FileTitle : VskVipsIfDtlVO
*Open Issues :
*Change history :
*@LastModifyDt : 2015.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo;


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
public class VskVipsIfDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VskVipsIfDtlVO> models = new ArrayList<VskVipsIfDtlVO>();
	
	/* VO Data Value( C:Creation, U:Upd, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String vslCd = null;

	/* Column Info */
	private String skdVoyNo = null;

	/* Column Info */
	private String skdDirCd = null;

	/* Column Info */
	private String vipsIfSeq = null;

	/* Column Info */
	private String vpsPortCd = null;

	/* Column Info */
	private String clptIndSeq = null;

	/* Column Info */
	private String clptSeq = null;

	/* Column Info */
	private String portSkdStsCd = null;

	/* Column Info */
	private String ydCd = null;

	/* Column Info */
	private String callYdIndSeq = null;

	/* Column Info */
	private String skdCngStsCd = null;

	/* Column Info */
	private String modiVopTpCd = null;

	/* Column Info */
	private String modiVipTeamCd = null;

	/* Column Info */
	private String vipsModiLocCd = null;

	/* Column Info */
	private String vipsVslEngNm = null;

	/* Column Info */
	private String vipsCallSgnNo = null;

	/* Column Info */
	private String vipsIbConsortiumVoyNo = null;

	/* Column Info */
	private String vipsObConsortiumVoyNo = null;

	/* Column Info */
	private String pfEtaDt = null;

	/* Column Info */
	private String pfEtbDt = null;

	/* Column Info */
	private String pfEtdDt = null;

	/* Column Info */
	private String initEtaDt = null;

	/* Column Info */
	private String initEtbDt = null;

	/* Column Info */
	private String initEtdDt = null;

	/* Column Info */
	private String vipsVpsEtaDt = null;

	/* Column Info */
	private String vipsVpsEtbDt = null;

	/* Column Info */
	private String vipsVpsEtdDt = null;

	/* Column Info */
	private String vipsActArrDt = null;

	/* Column Info */
	private String vipsActBrthDt = null;

	/* Column Info */
	private String vipsActDepDt = null;

	/* Column Info */
	private String turnPortFlg = null;

	/* Column Info */
	private String turnPortIndCd = null;

	/* Column Info */
	private String turnSkdVoyNo = null;

	/* Column Info */
	private String turnSkdDirCd = null;

	/* Column Info */
	private String turnClptIndSeq = null;

	/* Column Info */
	private String vipsLodIndCd = null;

	/* Column Info */
	private String vipsDchgIndCd = null;

	/* Column Info */
	private String vipsPassIndCd = null;

	/* Column Info */
	private String skdUpdUsrId = null;

	/* Column Info */
	private String skdUpdUsrNm = null;

	/* Column Info */
	private String skdUpdDt = null;

	/* Column Info */
	private String addCallFlg = null;

	/* Column Info */
	private String vtAddCallFlg = null;

	/* Column Info */
	private String creUsrId = null;

	/* Column Info */
	private String creDt = null;

	/* Column Info */
	private String updUsrId = null;

	/* Column Info */
	private String updDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VskVipsIfDtlVO() {}

	public VskVipsIfDtlVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vipsIfSeq, String vpsPortCd, String clptIndSeq, String clptSeq, String portSkdStsCd, String ydCd, String callYdIndSeq, String skdCngStsCd, String modiVopTpCd, String modiVipTeamCd, String vipsModiLocCd, String vipsVslEngNm, String vipsCallSgnNo, String vipsIbConsortiumVoyNo, String vipsObConsortiumVoyNo, String pfEtaDt, String pfEtbDt, String pfEtdDt, String initEtaDt, String initEtbDt, String initEtdDt, String vipsVpsEtaDt, String vipsVpsEtbDt, String vipsVpsEtdDt, String vipsActArrDt, String vipsActBrthDt, String vipsActDepDt, String turnPortFlg, String turnPortIndCd, String turnSkdVoyNo, String turnSkdDirCd, String turnClptIndSeq, String vipsLodIndCd, String vipsDchgIndCd, String vipsPassIndCd, String skdUpdUsrId, String skdUpdUsrNm, String skdUpdDt, String addCallFlg, String vtAddCallFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.vslCd = vslCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.vipsIfSeq = vipsIfSeq;
		this.vpsPortCd = vpsPortCd;
		this.clptIndSeq = clptIndSeq;
		this.clptSeq = clptSeq;
		this.portSkdStsCd = portSkdStsCd;
		this.ydCd = ydCd;
		this.callYdIndSeq = callYdIndSeq;
		this.skdCngStsCd = skdCngStsCd;
		this.modiVopTpCd = modiVopTpCd;
		this.modiVipTeamCd = modiVipTeamCd;
		this.vipsModiLocCd = vipsModiLocCd;
		this.vipsVslEngNm = vipsVslEngNm;
		this.vipsCallSgnNo = vipsCallSgnNo;
		this.vipsIbConsortiumVoyNo = vipsIbConsortiumVoyNo;
		this.vipsObConsortiumVoyNo = vipsObConsortiumVoyNo;
		this.pfEtaDt = pfEtaDt;
		this.pfEtbDt = pfEtbDt;
		this.pfEtdDt = pfEtdDt;
		this.initEtaDt = initEtaDt;
		this.initEtbDt = initEtbDt;
		this.initEtdDt = initEtdDt;
		this.vipsVpsEtaDt = vipsVpsEtaDt;
		this.vipsVpsEtbDt = vipsVpsEtbDt;
		this.vipsVpsEtdDt = vipsVpsEtdDt;
		this.vipsActArrDt = vipsActArrDt;
		this.vipsActBrthDt = vipsActBrthDt;
		this.vipsActDepDt = vipsActDepDt;
		this.turnPortFlg = turnPortFlg;
		this.turnPortIndCd = turnPortIndCd;
		this.turnSkdVoyNo = turnSkdVoyNo;
		this.turnSkdDirCd = turnSkdDirCd;
		this.turnClptIndSeq = turnClptIndSeq;
		this.vipsLodIndCd = vipsLodIndCd;
		this.vipsDchgIndCd = vipsDchgIndCd;
		this.vipsPassIndCd = vipsPassIndCd;
		this.skdUpdUsrId = skdUpdUsrId;
		this.skdUpdUsrNm = skdUpdUsrNm;
		this.skdUpdDt = skdUpdDt;
		this.addCallFlg = addCallFlg;
		this.vtAddCallFlg = vtAddCallFlg;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vips_if_seq", getVipsIfSeq());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("port_skd_sts_cd", getPortSkdStsCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("call_yd_ind_seq", getCallYdIndSeq());
		this.hashColumns.put("skd_cng_sts_cd", getSkdCngStsCd());
		this.hashColumns.put("modi_vop_tp_cd", getModiVopTpCd());
		this.hashColumns.put("modi_vip_team_cd", getModiVipTeamCd());
		this.hashColumns.put("vips_modi_loc_cd", getVipsModiLocCd());
		this.hashColumns.put("vips_vsl_eng_nm", getVipsVslEngNm());
		this.hashColumns.put("vips_call_sgn_no", getVipsCallSgnNo());
		this.hashColumns.put("vips_ib_consortium_voy_no", getVipsIbConsortiumVoyNo());
		this.hashColumns.put("vips_ob_consortium_voy_no", getVipsObConsortiumVoyNo());
		this.hashColumns.put("pf_eta_dt", getPfEtaDt());
		this.hashColumns.put("pf_etb_dt", getPfEtbDt());
		this.hashColumns.put("pf_etd_dt", getPfEtdDt());
		this.hashColumns.put("init_eta_dt", getInitEtaDt());
		this.hashColumns.put("init_etb_dt", getInitEtbDt());
		this.hashColumns.put("init_etd_dt", getInitEtdDt());
		this.hashColumns.put("vips_vps_eta_dt", getVipsVpsEtaDt());
		this.hashColumns.put("vips_vps_etb_dt", getVipsVpsEtbDt());
		this.hashColumns.put("vips_vps_etd_dt", getVipsVpsEtdDt());
		this.hashColumns.put("vips_act_arr_dt", getVipsActArrDt());
		this.hashColumns.put("vips_act_brth_dt", getVipsActBrthDt());
		this.hashColumns.put("vips_act_dep_dt", getVipsActDepDt());
		this.hashColumns.put("turn_port_flg", getTurnPortFlg());
		this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());
		this.hashColumns.put("turn_skd_voy_no", getTurnSkdVoyNo());
		this.hashColumns.put("turn_skd_dir_cd", getTurnSkdDirCd());
		this.hashColumns.put("turn_clpt_ind_seq", getTurnClptIndSeq());
		this.hashColumns.put("vips_lod_ind_cd", getVipsLodIndCd());
		this.hashColumns.put("vips_dchg_ind_cd", getVipsDchgIndCd());
		this.hashColumns.put("vips_pass_ind_cd", getVipsPassIndCd());
		this.hashColumns.put("skd_upd_usr_id", getSkdUpdUsrId());
		this.hashColumns.put("skd_upd_usr_nm", getSkdUpdUsrNm());
		this.hashColumns.put("skd_upd_dt", getSkdUpdDt());
		this.hashColumns.put("add_call_flg", getAddCallFlg());
		this.hashColumns.put("vt_add_call_flg", getVtAddCallFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vips_if_seq", "vipsIfSeq");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("port_skd_sts_cd", "portSkdStsCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("call_yd_ind_seq", "callYdIndSeq");
		this.hashFields.put("skd_cng_sts_cd", "skdCngStsCd");
		this.hashFields.put("modi_vop_tp_cd", "modiVopTpCd");
		this.hashFields.put("modi_vip_team_cd", "modiVipTeamCd");
		this.hashFields.put("vips_modi_loc_cd", "vipsModiLocCd");
		this.hashFields.put("vips_vsl_eng_nm", "vipsVslEngNm");
		this.hashFields.put("vips_call_sgn_no", "vipsCallSgnNo");
		this.hashFields.put("vips_ib_consortium_voy_no", "vipsIbConsortiumVoyNo");
		this.hashFields.put("vips_ob_consortium_voy_no", "vipsObConsortiumVoyNo");
		this.hashFields.put("pf_eta_dt", "pfEtaDt");
		this.hashFields.put("pf_etb_dt", "pfEtbDt");
		this.hashFields.put("pf_etd_dt", "pfEtdDt");
		this.hashFields.put("init_eta_dt", "initEtaDt");
		this.hashFields.put("init_etb_dt", "initEtbDt");
		this.hashFields.put("init_etd_dt", "initEtdDt");
		this.hashFields.put("vips_vps_eta_dt", "vipsVpsEtaDt");
		this.hashFields.put("vips_vps_etb_dt", "vipsVpsEtbDt");
		this.hashFields.put("vips_vps_etd_dt", "vipsVpsEtdDt");
		this.hashFields.put("vips_act_arr_dt", "vipsActArrDt");
		this.hashFields.put("vips_act_brth_dt", "vipsActBrthDt");
		this.hashFields.put("vips_act_dep_dt", "vipsActDepDt");
		this.hashFields.put("turn_port_flg", "turnPortFlg");
		this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
		this.hashFields.put("turn_skd_voy_no", "turnSkdVoyNo");
		this.hashFields.put("turn_skd_dir_cd", "turnSkdDirCd");
		this.hashFields.put("turn_clpt_ind_seq", "turnClptIndSeq");
		this.hashFields.put("vips_lod_ind_cd", "vipsLodIndCd");
		this.hashFields.put("vips_dchg_ind_cd", "vipsDchgIndCd");
		this.hashFields.put("vips_pass_ind_cd", "vipsPassIndCd");
		this.hashFields.put("skd_upd_usr_id", "skdUpdUsrId");
		this.hashFields.put("skd_upd_usr_nm", "skdUpdUsrNm");
		this.hashFields.put("skd_upd_dt", "skdUpdDt");
		this.hashFields.put("add_call_flg", "addCallFlg");
		this.hashFields.put("vt_add_call_flg", "vtAddCallFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * 
	 * @return String vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 *
	 * @param String skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * 
	 * @return String skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 *
	 * @param String skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * 
	 * @return String skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 *
	 * @param String vipsIfSeq
	 */
	public void setVipsIfSeq(String vipsIfSeq) {
		this.vipsIfSeq = vipsIfSeq;
	}
	
	/**
	 * 
	 * @return String vipsIfSeq
	 */
	public String getVipsIfSeq() {
		return this.vipsIfSeq;
	}
	
	/**
	 *
	 * @param String vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * 
	 * @return String vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 *
	 * @param String clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * 
	 * @return String clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 *
	 * @param String clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
	}
	
	/**
	 * 
	 * @return String clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
	}
	
	/**
	 *
	 * @param String portSkdStsCd
	 */
	public void setPortSkdStsCd(String portSkdStsCd) {
		this.portSkdStsCd = portSkdStsCd;
	}
	
	/**
	 * 
	 * @return String portSkdStsCd
	 */
	public String getPortSkdStsCd() {
		return this.portSkdStsCd;
	}
	
	/**
	 *
	 * @param String ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * 
	 * @return String ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 *
	 * @param String callYdIndSeq
	 */
	public void setCallYdIndSeq(String callYdIndSeq) {
		this.callYdIndSeq = callYdIndSeq;
	}
	
	/**
	 * 
	 * @return String callYdIndSeq
	 */
	public String getCallYdIndSeq() {
		return this.callYdIndSeq;
	}
	
	/**
	 *
	 * @param String skdCngStsCd
	 */
	public void setSkdCngStsCd(String skdCngStsCd) {
		this.skdCngStsCd = skdCngStsCd;
	}
	
	/**
	 * 
	 * @return String skdCngStsCd
	 */
	public String getSkdCngStsCd() {
		return this.skdCngStsCd;
	}
	
	/**
	 *
	 * @param String modiVopTpCd
	 */
	public void setModiVopTpCd(String modiVopTpCd) {
		this.modiVopTpCd = modiVopTpCd;
	}
	
	/**
	 * 
	 * @return String modiVopTpCd
	 */
	public String getModiVopTpCd() {
		return this.modiVopTpCd;
	}
	
	/**
	 *
	 * @param String modiVipTeamCd
	 */
	public void setModiVipTeamCd(String modiVipTeamCd) {
		this.modiVipTeamCd = modiVipTeamCd;
	}
	
	/**
	 * 
	 * @return String modiVipTeamCd
	 */
	public String getModiVipTeamCd() {
		return this.modiVipTeamCd;
	}
	
	/**
	 *
	 * @param String vipsModiLocCd
	 */
	public void setVipsModiLocCd(String vipsModiLocCd) {
		this.vipsModiLocCd = vipsModiLocCd;
	}
	
	/**
	 * 
	 * @return String vipsModiLocCd
	 */
	public String getVipsModiLocCd() {
		return this.vipsModiLocCd;
	}
	
	/**
	 *
	 * @param String vipsVslEngNm
	 */
	public void setVipsVslEngNm(String vipsVslEngNm) {
		this.vipsVslEngNm = vipsVslEngNm;
	}
	
	/**
	 * 
	 * @return String vipsVslEngNm
	 */
	public String getVipsVslEngNm() {
		return this.vipsVslEngNm;
	}
	
	/**
	 *
	 * @param String vipsCallSgnNo
	 */
	public void setVipsCallSgnNo(String vipsCallSgnNo) {
		this.vipsCallSgnNo = vipsCallSgnNo;
	}
	
	/**
	 * 
	 * @return String vipsCallSgnNo
	 */
	public String getVipsCallSgnNo() {
		return this.vipsCallSgnNo;
	}
	
	/**
	 *
	 * @param String vipsIbConsortiumVoyNo
	 */
	public void setVipsIbConsortiumVoyNo(String vipsIbConsortiumVoyNo) {
		this.vipsIbConsortiumVoyNo = vipsIbConsortiumVoyNo;
	}
	
	/**
	 * 
	 * @return String vipsIbConsortiumVoyNo
	 */
	public String getVipsIbConsortiumVoyNo() {
		return this.vipsIbConsortiumVoyNo;
	}
	
	/**
	 *
	 * @param String vipsObConsortiumVoyNo
	 */
	public void setVipsObConsortiumVoyNo(String vipsObConsortiumVoyNo) {
		this.vipsObConsortiumVoyNo = vipsObConsortiumVoyNo;
	}
	
	/**
	 * 
	 * @return String vipsObConsortiumVoyNo
	 */
	public String getVipsObConsortiumVoyNo() {
		return this.vipsObConsortiumVoyNo;
	}
	
	/**
	 *
	 * @param String pfEtaDt
	 */
	public void setPfEtaDt(String pfEtaDt) {
		this.pfEtaDt = pfEtaDt;
	}
	
	/**
	 * 
	 * @return String pfEtaDt
	 */
	public String getPfEtaDt() {
		return this.pfEtaDt;
	}
	
	/**
	 *
	 * @param String pfEtbDt
	 */
	public void setPfEtbDt(String pfEtbDt) {
		this.pfEtbDt = pfEtbDt;
	}
	
	/**
	 * 
	 * @return String pfEtbDt
	 */
	public String getPfEtbDt() {
		return this.pfEtbDt;
	}
	
	/**
	 *
	 * @param String pfEtdDt
	 */
	public void setPfEtdDt(String pfEtdDt) {
		this.pfEtdDt = pfEtdDt;
	}
	
	/**
	 * 
	 * @return String pfEtdDt
	 */
	public String getPfEtdDt() {
		return this.pfEtdDt;
	}
	
	/**
	 *
	 * @param String initEtaDt
	 */
	public void setInitEtaDt(String initEtaDt) {
		this.initEtaDt = initEtaDt;
	}
	
	/**
	 * 
	 * @return String initEtaDt
	 */
	public String getInitEtaDt() {
		return this.initEtaDt;
	}
	
	/**
	 *
	 * @param String initEtbDt
	 */
	public void setInitEtbDt(String initEtbDt) {
		this.initEtbDt = initEtbDt;
	}
	
	/**
	 * 
	 * @return String initEtbDt
	 */
	public String getInitEtbDt() {
		return this.initEtbDt;
	}
	
	/**
	 *
	 * @param String initEtdDt
	 */
	public void setInitEtdDt(String initEtdDt) {
		this.initEtdDt = initEtdDt;
	}
	
	/**
	 * 
	 * @return String initEtdDt
	 */
	public String getInitEtdDt() {
		return this.initEtdDt;
	}
	
	/**
	 *
	 * @param String vipsVpsEtaDt
	 */
	public void setVipsVpsEtaDt(String vipsVpsEtaDt) {
		this.vipsVpsEtaDt = vipsVpsEtaDt;
	}
	
	/**
	 * 
	 * @return String vipsVpsEtaDt
	 */
	public String getVipsVpsEtaDt() {
		return this.vipsVpsEtaDt;
	}
	
	/**
	 *
	 * @param String vipsVpsEtbDt
	 */
	public void setVipsVpsEtbDt(String vipsVpsEtbDt) {
		this.vipsVpsEtbDt = vipsVpsEtbDt;
	}
	
	/**
	 * 
	 * @return String vipsVpsEtbDt
	 */
	public String getVipsVpsEtbDt() {
		return this.vipsVpsEtbDt;
	}
	
	/**
	 *
	 * @param String vipsVpsEtdDt
	 */
	public void setVipsVpsEtdDt(String vipsVpsEtdDt) {
		this.vipsVpsEtdDt = vipsVpsEtdDt;
	}
	
	/**
	 * 
	 * @return String vipsVpsEtdDt
	 */
	public String getVipsVpsEtdDt() {
		return this.vipsVpsEtdDt;
	}
	
	/**
	 *
	 * @param String vipsActArrDt
	 */
	public void setVipsActArrDt(String vipsActArrDt) {
		this.vipsActArrDt = vipsActArrDt;
	}
	
	/**
	 * 
	 * @return String vipsActArrDt
	 */
	public String getVipsActArrDt() {
		return this.vipsActArrDt;
	}
	
	/**
	 *
	 * @param String vipsActBrthDt
	 */
	public void setVipsActBrthDt(String vipsActBrthDt) {
		this.vipsActBrthDt = vipsActBrthDt;
	}
	
	/**
	 * 
	 * @return String vipsActBrthDt
	 */
	public String getVipsActBrthDt() {
		return this.vipsActBrthDt;
	}
	
	/**
	 *
	 * @param String vipsActDepDt
	 */
	public void setVipsActDepDt(String vipsActDepDt) {
		this.vipsActDepDt = vipsActDepDt;
	}
	
	/**
	 * 
	 * @return String vipsActDepDt
	 */
	public String getVipsActDepDt() {
		return this.vipsActDepDt;
	}
	
	/**
	 *
	 * @param String turnPortFlg
	 */
	public void setTurnPortFlg(String turnPortFlg) {
		this.turnPortFlg = turnPortFlg;
	}
	
	/**
	 * 
	 * @return String turnPortFlg
	 */
	public String getTurnPortFlg() {
		return this.turnPortFlg;
	}
	
	/**
	 *
	 * @param String turnPortIndCd
	 */
	public void setTurnPortIndCd(String turnPortIndCd) {
		this.turnPortIndCd = turnPortIndCd;
	}
	
	/**
	 * 
	 * @return String turnPortIndCd
	 */
	public String getTurnPortIndCd() {
		return this.turnPortIndCd;
	}
	
	/**
	 *
	 * @param String turnSkdVoyNo
	 */
	public void setTurnSkdVoyNo(String turnSkdVoyNo) {
		this.turnSkdVoyNo = turnSkdVoyNo;
	}
	
	/**
	 * 
	 * @return String turnSkdVoyNo
	 */
	public String getTurnSkdVoyNo() {
		return this.turnSkdVoyNo;
	}
	
	/**
	 *
	 * @param String turnSkdDirCd
	 */
	public void setTurnSkdDirCd(String turnSkdDirCd) {
		this.turnSkdDirCd = turnSkdDirCd;
	}
	
	/**
	 * 
	 * @return String turnSkdDirCd
	 */
	public String getTurnSkdDirCd() {
		return this.turnSkdDirCd;
	}
	
	/**
	 *
	 * @param String turnClptIndSeq
	 */
	public void setTurnClptIndSeq(String turnClptIndSeq) {
		this.turnClptIndSeq = turnClptIndSeq;
	}
	
	/**
	 * 
	 * @return String turnClptIndSeq
	 */
	public String getTurnClptIndSeq() {
		return this.turnClptIndSeq;
	}
	
	/**
	 *
	 * @param String vipsLodIndCd
	 */
	public void setVipsLodIndCd(String vipsLodIndCd) {
		this.vipsLodIndCd = vipsLodIndCd;
	}
	
	/**
	 * 
	 * @return String vipsLodIndCd
	 */
	public String getVipsLodIndCd() {
		return this.vipsLodIndCd;
	}
	
	/**
	 *
	 * @param String vipsDchgIndCd
	 */
	public void setVipsDchgIndCd(String vipsDchgIndCd) {
		this.vipsDchgIndCd = vipsDchgIndCd;
	}
	
	/**
	 * 
	 * @return String vipsDchgIndCd
	 */
	public String getVipsDchgIndCd() {
		return this.vipsDchgIndCd;
	}
	
	/**
	 *
	 * @param String vipsPassIndCd
	 */
	public void setVipsPassIndCd(String vipsPassIndCd) {
		this.vipsPassIndCd = vipsPassIndCd;
	}
	
	/**
	 * 
	 * @return String vipsPassIndCd
	 */
	public String getVipsPassIndCd() {
		return this.vipsPassIndCd;
	}
	
	/**
	 *
	 * @param String skdUpdUsrId
	 */
	public void setSkdUpdUsrId(String skdUpdUsrId) {
		this.skdUpdUsrId = skdUpdUsrId;
	}
	
	/**
	 * 
	 * @return String skdUpdUsrId
	 */
	public String getSkdUpdUsrId() {
		return this.skdUpdUsrId;
	}
	
	/**
	 *
	 * @param String skdUpdUsrNm
	 */
	public void setSkdUpdUsrNm(String skdUpdUsrNm) {
		this.skdUpdUsrNm = skdUpdUsrNm;
	}
	
	/**
	 * 
	 * @return String skdUpdUsrNm
	 */
	public String getSkdUpdUsrNm() {
		return this.skdUpdUsrNm;
	}
	
	/**
	 *
	 * @param String skdUpdDt
	 */
	public void setSkdUpdDt(String skdUpdDt) {
		this.skdUpdDt = skdUpdDt;
	}
	
	/**
	 * 
	 * @return String skdUpdDt
	 */
	public String getSkdUpdDt() {
		return this.skdUpdDt;
	}
	
	/**
	 *
	 * @param String addCallFlg
	 */
	public void setAddCallFlg(String addCallFlg) {
		this.addCallFlg = addCallFlg;
	}
	
	/**
	 * 
	 * @return String addCallFlg
	 */
	public String getAddCallFlg() {
		return this.addCallFlg;
	}
	
	/**
	 *
	 * @param String vtAddCallFlg
	 */
	public void setVtAddCallFlg(String vtAddCallFlg) {
		this.vtAddCallFlg = vtAddCallFlg;
	}
	
	/**
	 * 
	 * @return String vtAddCallFlg
	 */
	public String getVtAddCallFlg() {
		return this.vtAddCallFlg;
	}
	
	/**
	 *
	 * @param String creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * 
	 * @return String creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 *
	 * @param String creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * 
	 * @return String creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 *
	 * @param String updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 
	 * @return String updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 *
	 * @param String updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * 
	 * @return String updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setVipsIfSeq(JSPUtil.getParameter(request, prefix + "vips_if_seq", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setPortSkdStsCd(JSPUtil.getParameter(request, prefix + "port_skd_sts_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setCallYdIndSeq(JSPUtil.getParameter(request, prefix + "call_yd_ind_seq", ""));
		setSkdCngStsCd(JSPUtil.getParameter(request, prefix + "skd_cng_sts_cd", ""));
		setModiVopTpCd(JSPUtil.getParameter(request, prefix + "modi_vop_tp_cd", ""));
		setModiVipTeamCd(JSPUtil.getParameter(request, prefix + "modi_vip_team_cd", ""));
		setVipsModiLocCd(JSPUtil.getParameter(request, prefix + "vips_modi_loc_cd", ""));
		setVipsVslEngNm(JSPUtil.getParameter(request, prefix + "vips_vsl_eng_nm", ""));
		setVipsCallSgnNo(JSPUtil.getParameter(request, prefix + "vips_call_sgn_no", ""));
		setVipsIbConsortiumVoyNo(JSPUtil.getParameter(request, prefix + "vips_ib_consortium_voy_no", ""));
		setVipsObConsortiumVoyNo(JSPUtil.getParameter(request, prefix + "vips_ob_consortium_voy_no", ""));
		setPfEtaDt(JSPUtil.getParameter(request, prefix + "pf_eta_dt", ""));
		setPfEtbDt(JSPUtil.getParameter(request, prefix + "pf_etb_dt", ""));
		setPfEtdDt(JSPUtil.getParameter(request, prefix + "pf_etd_dt", ""));
		setInitEtaDt(JSPUtil.getParameter(request, prefix + "init_eta_dt", ""));
		setInitEtbDt(JSPUtil.getParameter(request, prefix + "init_etb_dt", ""));
		setInitEtdDt(JSPUtil.getParameter(request, prefix + "init_etd_dt", ""));
		setVipsVpsEtaDt(JSPUtil.getParameter(request, prefix + "vips_vps_eta_dt", ""));
		setVipsVpsEtbDt(JSPUtil.getParameter(request, prefix + "vips_vps_etb_dt", ""));
		setVipsVpsEtdDt(JSPUtil.getParameter(request, prefix + "vips_vps_etd_dt", ""));
		setVipsActArrDt(JSPUtil.getParameter(request, prefix + "vips_act_arr_dt", ""));
		setVipsActBrthDt(JSPUtil.getParameter(request, prefix + "vips_act_brth_dt", ""));
		setVipsActDepDt(JSPUtil.getParameter(request, prefix + "vips_act_dep_dt", ""));
		setTurnPortFlg(JSPUtil.getParameter(request, prefix + "turn_port_flg", ""));
		setTurnPortIndCd(JSPUtil.getParameter(request, prefix + "turn_port_ind_cd", ""));
		setTurnSkdVoyNo(JSPUtil.getParameter(request, prefix + "turn_skd_voy_no", ""));
		setTurnSkdDirCd(JSPUtil.getParameter(request, prefix + "turn_skd_dir_cd", ""));
		setTurnClptIndSeq(JSPUtil.getParameter(request, prefix + "turn_clpt_ind_seq", ""));
		setVipsLodIndCd(JSPUtil.getParameter(request, prefix + "vips_lod_ind_cd", ""));
		setVipsDchgIndCd(JSPUtil.getParameter(request, prefix + "vips_dchg_ind_cd", ""));
		setVipsPassIndCd(JSPUtil.getParameter(request, prefix + "vips_pass_ind_cd", ""));
		setSkdUpdUsrId(JSPUtil.getParameter(request, prefix + "skd_upd_usr_id", ""));
		setSkdUpdUsrNm(JSPUtil.getParameter(request, prefix + "skd_upd_usr_nm", ""));
		setSkdUpdDt(JSPUtil.getParameter(request, prefix + "skd_upd_dt", ""));
		setAddCallFlg(JSPUtil.getParameter(request, prefix + "add_call_flg", ""));
		setVtAddCallFlg(JSPUtil.getParameter(request, prefix + "vt_add_call_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VskVipsIfDtlVO[]
	 */
	public VskVipsIfDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VskVipsIfDtlVO[]
	 */
	public VskVipsIfDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VskVipsIfDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vipsIfSeq = (JSPUtil.getParameter(request, prefix	+ "vips_if_seq", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] portSkdStsCd = (JSPUtil.getParameter(request, prefix	+ "port_skd_sts_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] callYdIndSeq = (JSPUtil.getParameter(request, prefix	+ "call_yd_ind_seq", length));
			String[] skdCngStsCd = (JSPUtil.getParameter(request, prefix	+ "skd_cng_sts_cd", length));
			String[] modiVopTpCd = (JSPUtil.getParameter(request, prefix	+ "modi_vop_tp_cd", length));
			String[] modiVipTeamCd = (JSPUtil.getParameter(request, prefix	+ "modi_vip_team_cd", length));
			String[] vipsModiLocCd = (JSPUtil.getParameter(request, prefix	+ "vips_modi_loc_cd", length));
			String[] vipsVslEngNm = (JSPUtil.getParameter(request, prefix	+ "vips_vsl_eng_nm", length));
			String[] vipsCallSgnNo = (JSPUtil.getParameter(request, prefix	+ "vips_call_sgn_no", length));
			String[] vipsIbConsortiumVoyNo = (JSPUtil.getParameter(request, prefix	+ "vips_ib_consortium_voy_no", length));
			String[] vipsObConsortiumVoyNo = (JSPUtil.getParameter(request, prefix	+ "vips_ob_consortium_voy_no", length));
			String[] pfEtaDt = (JSPUtil.getParameter(request, prefix	+ "pf_eta_dt", length));
			String[] pfEtbDt = (JSPUtil.getParameter(request, prefix	+ "pf_etb_dt", length));
			String[] pfEtdDt = (JSPUtil.getParameter(request, prefix	+ "pf_etd_dt", length));
			String[] initEtaDt = (JSPUtil.getParameter(request, prefix	+ "init_eta_dt", length));
			String[] initEtbDt = (JSPUtil.getParameter(request, prefix	+ "init_etb_dt", length));
			String[] initEtdDt = (JSPUtil.getParameter(request, prefix	+ "init_etd_dt", length));
			String[] vipsVpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vips_vps_eta_dt", length));
			String[] vipsVpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vips_vps_etb_dt", length));
			String[] vipsVpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vips_vps_etd_dt", length));
			String[] vipsActArrDt = (JSPUtil.getParameter(request, prefix	+ "vips_act_arr_dt", length));
			String[] vipsActBrthDt = (JSPUtil.getParameter(request, prefix	+ "vips_act_brth_dt", length));
			String[] vipsActDepDt = (JSPUtil.getParameter(request, prefix	+ "vips_act_dep_dt", length));
			String[] turnPortFlg = (JSPUtil.getParameter(request, prefix	+ "turn_port_flg", length));
			String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix	+ "turn_port_ind_cd", length));
			String[] turnSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "turn_skd_voy_no", length));
			String[] turnSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "turn_skd_dir_cd", length));
			String[] turnClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "turn_clpt_ind_seq", length));
			String[] vipsLodIndCd = (JSPUtil.getParameter(request, prefix	+ "vips_lod_ind_cd", length));
			String[] vipsDchgIndCd = (JSPUtil.getParameter(request, prefix	+ "vips_dchg_ind_cd", length));
			String[] vipsPassIndCd = (JSPUtil.getParameter(request, prefix	+ "vips_pass_ind_cd", length));
			String[] skdUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "skd_upd_usr_id", length));
			String[] skdUpdUsrNm = (JSPUtil.getParameter(request, prefix	+ "skd_upd_usr_nm", length));
			String[] skdUpdDt = (JSPUtil.getParameter(request, prefix	+ "skd_upd_dt", length));
			String[] addCallFlg = (JSPUtil.getParameter(request, prefix	+ "add_call_flg", length));
			String[] vtAddCallFlg = (JSPUtil.getParameter(request, prefix	+ "vt_add_call_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new VskVipsIfDtlVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (vslCd[i] != null) 
					model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null) 
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null) 
					model.setSkdDirCd(skdDirCd[i]);
				if (vipsIfSeq[i] != null) 
					model.setVipsIfSeq(vipsIfSeq[i]);
				if (vpsPortCd[i] != null) 
					model.setVpsPortCd(vpsPortCd[i]);
				if (clptIndSeq[i] != null) 
					model.setClptIndSeq(clptIndSeq[i]);
				if (clptSeq[i] != null) 
					model.setClptSeq(clptSeq[i]);
				if (portSkdStsCd[i] != null) 
					model.setPortSkdStsCd(portSkdStsCd[i]);
				if (ydCd[i] != null) 
					model.setYdCd(ydCd[i]);
				if (callYdIndSeq[i] != null) 
					model.setCallYdIndSeq(callYdIndSeq[i]);
				if (skdCngStsCd[i] != null) 
					model.setSkdCngStsCd(skdCngStsCd[i]);
				if (modiVopTpCd[i] != null) 
					model.setModiVopTpCd(modiVopTpCd[i]);
				if (modiVipTeamCd[i] != null) 
					model.setModiVipTeamCd(modiVipTeamCd[i]);
				if (vipsModiLocCd[i] != null) 
					model.setVipsModiLocCd(vipsModiLocCd[i]);
				if (vipsVslEngNm[i] != null) 
					model.setVipsVslEngNm(vipsVslEngNm[i]);
				if (vipsCallSgnNo[i] != null) 
					model.setVipsCallSgnNo(vipsCallSgnNo[i]);
				if (vipsIbConsortiumVoyNo[i] != null) 
					model.setVipsIbConsortiumVoyNo(vipsIbConsortiumVoyNo[i]);
				if (vipsObConsortiumVoyNo[i] != null) 
					model.setVipsObConsortiumVoyNo(vipsObConsortiumVoyNo[i]);
				if (pfEtaDt[i] != null) 
					model.setPfEtaDt(pfEtaDt[i]);
				if (pfEtbDt[i] != null) 
					model.setPfEtbDt(pfEtbDt[i]);
				if (pfEtdDt[i] != null) 
					model.setPfEtdDt(pfEtdDt[i]);
				if (initEtaDt[i] != null) 
					model.setInitEtaDt(initEtaDt[i]);
				if (initEtbDt[i] != null) 
					model.setInitEtbDt(initEtbDt[i]);
				if (initEtdDt[i] != null) 
					model.setInitEtdDt(initEtdDt[i]);
				if (vipsVpsEtaDt[i] != null) 
					model.setVipsVpsEtaDt(vipsVpsEtaDt[i]);
				if (vipsVpsEtbDt[i] != null) 
					model.setVipsVpsEtbDt(vipsVpsEtbDt[i]);
				if (vipsVpsEtdDt[i] != null) 
					model.setVipsVpsEtdDt(vipsVpsEtdDt[i]);
				if (vipsActArrDt[i] != null) 
					model.setVipsActArrDt(vipsActArrDt[i]);
				if (vipsActBrthDt[i] != null) 
					model.setVipsActBrthDt(vipsActBrthDt[i]);
				if (vipsActDepDt[i] != null) 
					model.setVipsActDepDt(vipsActDepDt[i]);
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
				if (vipsLodIndCd[i] != null) 
					model.setVipsLodIndCd(vipsLodIndCd[i]);
				if (vipsDchgIndCd[i] != null) 
					model.setVipsDchgIndCd(vipsDchgIndCd[i]);
				if (vipsPassIndCd[i] != null) 
					model.setVipsPassIndCd(vipsPassIndCd[i]);
				if (skdUpdUsrId[i] != null) 
					model.setSkdUpdUsrId(skdUpdUsrId[i]);
				if (skdUpdUsrNm[i] != null) 
					model.setSkdUpdUsrNm(skdUpdUsrNm[i]);
				if (skdUpdDt[i] != null) 
					model.setSkdUpdDt(skdUpdDt[i]);
				if (addCallFlg[i] != null) 
					model.setAddCallFlg(addCallFlg[i]);
				if (vtAddCallFlg[i] != null) 
					model.setVtAddCallFlg(vtAddCallFlg[i]);
				if (creUsrId[i] != null) 
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null) 
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null) 
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null) 
					model.setUpdDt(updDt[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVskVipsIfDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VskVipsIfDtlVO[]
	 */
	public VskVipsIfDtlVO[] getVskVipsIfDtlVOs(){
		VskVipsIfDtlVO[] vos = (VskVipsIfDtlVO[])models.toArray(new VskVipsIfDtlVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipsIfSeq = this.vipsIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSkdStsCd = this.portSkdStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYdIndSeq = this.callYdIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdCngStsCd = this.skdCngStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiVopTpCd = this.modiVopTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiVipTeamCd = this.modiVipTeamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipsModiLocCd = this.vipsModiLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipsVslEngNm = this.vipsVslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipsCallSgnNo = this.vipsCallSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipsIbConsortiumVoyNo = this.vipsIbConsortiumVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipsObConsortiumVoyNo = this.vipsObConsortiumVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtaDt = this.pfEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtbDt = this.pfEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtdDt = this.pfEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtaDt = this.initEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtbDt = this.initEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtdDt = this.initEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipsVpsEtaDt = this.vipsVpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipsVpsEtbDt = this.vipsVpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipsVpsEtdDt = this.vipsVpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipsActArrDt = this.vipsActArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipsActBrthDt = this.vipsActBrthDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipsActDepDt = this.vipsActDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortFlg = this.turnPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortIndCd = this.turnPortIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnSkdVoyNo = this.turnSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnSkdDirCd = this.turnSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnClptIndSeq = this.turnClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipsLodIndCd = this.vipsLodIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipsDchgIndCd = this.vipsDchgIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipsPassIndCd = this.vipsPassIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdUpdUsrId = this.skdUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdUpdUsrNm = this.skdUpdUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdUpdDt = this.skdUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addCallFlg = this.addCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vtAddCallFlg = this.vtAddCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}