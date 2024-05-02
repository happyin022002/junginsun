/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DrwSkdSearchVO.java
*@FileTitle : DrwSkdSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.syscommon.common.table.VskVslSkdRsltVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DrwSkdSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DrwSkdSearchVO> models = new ArrayList<DrwSkdSearchVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String podActBrthDt = null;
	/* Column Info */
	private String drwPodCd = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podClptSeq = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podActArrDt = null;
	/* Column Info */
	private String polClptIndSeq = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String opt = null;
	/* Column Info */
	private String drwTeu = null;
	/* Column Info */
	private String drwSlanCd = null;
	/* Column Info */
	private String polClptSeq = null;
	/* Column Info */
	private String podClptIndSeq = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String drwToDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String polActDepDt = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String podVpsEtaDt = null;
	/* Column Info */
	private String teu = null;
	/* Column Info */
	private String drwFmDt = null;
	/* Column Info */
	private String podVpsEtbDt = null;
	/* Column Info */
	private String drwCrrCd = null;
	/* Column Info */
	private String drwPolCd = null;
	/* Column Info */
	private String polActAtdInpDt = null;
	
	/* Column Info */
	private String drwInpYrmon = null;

	
	private List<DrwSkdSearchVO> 	drwSkdSaveVOs 	= null;

	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DrwSkdSearchVO() {}

	public DrwSkdSearchVO(String ibflag, String pagerows, String polCd, String polYdCd, String polClptIndSeq, String polClptSeq, String podCd, String podYdCd, String podClptIndSeq, String podClptSeq, String slanCd, String vvd, String vslCd, String skdVoyNo, String skdDirCd, String crrCd, String teu, String polActDepDt, String polActAtdInpDt, String podVpsEtaDt, String podVpsEtbDt, String podActArrDt, String podActBrthDt, String drwFmDt, String drwToDt, String opt, String creUsrId, String updUsrId, String drwPolCd, String drwPodCd, String drwSlanCd, String drwCrrCd, String drwTeu, String drwInpYrmon) {
		this.vslCd = vslCd;
		this.podActBrthDt = podActBrthDt;
		this.drwPodCd = drwPodCd;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.podClptSeq = podClptSeq;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.podActArrDt = podActArrDt;
		this.polClptIndSeq = polClptIndSeq;
		this.podYdCd = podYdCd;
		this.updUsrId = updUsrId;
		this.opt = opt;
		this.drwTeu = drwTeu;
		this.drwSlanCd = drwSlanCd;
		this.polClptSeq = polClptSeq;
		this.podClptIndSeq = podClptIndSeq;
		this.skdVoyNo = skdVoyNo;
		this.drwToDt = drwToDt;
		this.skdDirCd = skdDirCd;
		this.vvd = vvd;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.polActDepDt = polActDepDt;
		this.slanCd = slanCd;
		this.polYdCd = polYdCd;
		this.podVpsEtaDt = podVpsEtaDt;
		this.teu = teu;
		this.drwFmDt = drwFmDt;
		this.podVpsEtbDt = podVpsEtbDt;
		this.drwCrrCd = drwCrrCd;
		this.drwPolCd = drwPolCd;
		this.polActAtdInpDt = polActAtdInpDt;
		this.drwInpYrmon = drwInpYrmon;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("pod_act_brth_dt", getPodActBrthDt());
		this.hashColumns.put("drw_pod_cd", getDrwPodCd());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_clpt_seq", getPodClptSeq());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_act_arr_dt", getPodActArrDt());
		this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("opt", getOpt());
		this.hashColumns.put("drw_teu", getDrwTeu());
		this.hashColumns.put("drw_slan_cd", getDrwSlanCd());
		this.hashColumns.put("pol_clpt_seq", getPolClptSeq());
		this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("drw_to_dt", getDrwToDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pol_act_dep_dt", getPolActDepDt());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("pod_vps_eta_dt", getPodVpsEtaDt());
		this.hashColumns.put("teu", getTeu());
		this.hashColumns.put("drw_fm_dt", getDrwFmDt());
		this.hashColumns.put("pod_vps_etb_dt", getPodVpsEtbDt());
		this.hashColumns.put("drw_crr_cd", getDrwCrrCd());
		this.hashColumns.put("drw_pol_cd", getDrwPolCd());
		this.hashColumns.put("pol_act_atd_inp_dt", getPolActAtdInpDt());
		this.hashColumns.put("drw_inp_yrmon", getDrwInpYrmon());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("pod_act_brth_dt", "podActBrthDt");
		this.hashFields.put("drw_pod_cd", "drwPodCd");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_clpt_seq", "podClptSeq");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_act_arr_dt", "podActArrDt");
		this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("opt", "opt");
		this.hashFields.put("drw_teu", "drwTeu");
		this.hashFields.put("drw_slan_cd", "drwSlanCd");
		this.hashFields.put("pol_clpt_seq", "polClptSeq");
		this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("drw_to_dt", "drwToDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pol_act_dep_dt", "polActDepDt");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("pod_vps_eta_dt", "podVpsEtaDt");
		this.hashFields.put("teu", "teu");
		this.hashFields.put("drw_fm_dt", "drwFmDt");
		this.hashFields.put("pod_vps_etb_dt", "podVpsEtbDt");
		this.hashFields.put("drw_crr_cd", "drwCrrCd");
		this.hashFields.put("drw_pol_cd", "drwPolCd");
		this.hashFields.put("pol_act_atd_inp_dt", "polActAtdInpDt");
		this.hashFields.put("drw_inp_yrmon", "drwInpYrmon");

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
	 * @return podActBrthDt
	 */
	public String getPodActBrthDt() {
		return this.podActBrthDt;
	}
	
	/**
	 * Column Info
	 * @return drwPodCd
	 */
	public String getDrwPodCd() {
		return this.drwPodCd;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return podActArrDt
	 */
	public String getPodActArrDt() {
		return this.podActArrDt;
	}
	
	/**
	 * Column Info
	 * @return polClptIndSeq
	 */
	public String getPolClptIndSeq() {
		return this.polClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
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
	 * @return opt
	 */
	public String getOpt() {
		return this.opt;
	}
	
	/**
	 * Column Info
	 * @return drwTeu
	 */
	public String getDrwTeu() {
		return this.drwTeu;
	}
	
	/**
	 * Column Info
	 * @return drwSlanCd
	 */
	public String getDrwSlanCd() {
		return this.drwSlanCd;
	}
	
	/**
	 * Column Info
	 * @return polClptSeq
	 */
	public String getPolClptSeq() {
		return this.polClptSeq;
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
	 * @return drwToDt
	 */
	public String getDrwToDt() {
		return this.drwToDt;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return polActDepDt
	 */
	public String getPolActDepDt() {
		return this.polActDepDt;
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
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return podVpsEtaDt
	 */
	public String getPodVpsEtaDt() {
		return this.podVpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return teu
	 */
	public String getTeu() {
		return this.teu;
	}
	
	/**
	 * Column Info
	 * @return drwFmDt
	 */
	public String getDrwFmDt() {
		return this.drwFmDt;
	}
	
	/**
	 * Column Info
	 * @return podVpsEtbDt
	 */
	public String getPodVpsEtbDt() {
		return this.podVpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return drwCrrCd
	 */
	public String getDrwCrrCd() {
		return this.drwCrrCd;
	}
	
	/**
	 * Column Info
	 * @return drwPolCd
	 */
	public String getDrwPolCd() {
		return this.drwPolCd;
	}
	
	/**
	 * Column Info
	 * @return polActAtdInpDt
	 */
	public String getPolActAtdInpDt() {
		return this.polActAtdInpDt;
	}
	
	/**
	 * Column Info
	 * @return drwInpYrmon
	 */
	public String getDrwInpYrmon() {
		return this.drwInpYrmon;
	}
	

	/**
	 * @return List<DrwSkdSearchVO>
	 */
	public List<DrwSkdSearchVO> getdrwSkdSaveVOs() {
		return drwSkdSaveVOs;
	}

	/**
	 * @param List<DrwSkdSearchVO> drwSkdSaveVOs
	 */
	public void setdrwSkdSaveVOs(List<DrwSkdSearchVO> drwSkdSaveVOs) {
		this.drwSkdSaveVOs = drwSkdSaveVOs;
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
	 * @param podActBrthDt
	 */
	public void setPodActBrthDt(String podActBrthDt) {
		this.podActBrthDt = podActBrthDt;
	}
	
	/**
	 * Column Info
	 * @param drwPodCd
	 */
	public void setDrwPodCd(String drwPodCd) {
		this.drwPodCd = drwPodCd;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param podActArrDt
	 */
	public void setPodActArrDt(String podActArrDt) {
		this.podActArrDt = podActArrDt;
	}
	
	/**
	 * Column Info
	 * @param polClptIndSeq
	 */
	public void setPolClptIndSeq(String polClptIndSeq) {
		this.polClptIndSeq = polClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
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
	 * @param opt
	 */
	public void setOpt(String opt) {
		this.opt = opt;
	}
	
	/**
	 * Column Info
	 * @param drwTeu
	 */
	public void setDrwTeu(String drwTeu) {
		this.drwTeu = drwTeu;
	}
	
	/**
	 * Column Info
	 * @param drwSlanCd
	 */
	public void setDrwSlanCd(String drwSlanCd) {
		this.drwSlanCd = drwSlanCd;
	}
	
	/**
	 * Column Info
	 * @param polClptSeq
	 */
	public void setPolClptSeq(String polClptSeq) {
		this.polClptSeq = polClptSeq;
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
	 * @param drwToDt
	 */
	public void setDrwToDt(String drwToDt) {
		this.drwToDt = drwToDt;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param polActDepDt
	 */
	public void setPolActDepDt(String polActDepDt) {
		this.polActDepDt = polActDepDt;
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
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param podVpsEtaDt
	 */
	public void setPodVpsEtaDt(String podVpsEtaDt) {
		this.podVpsEtaDt = podVpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param teu
	 */
	public void setTeu(String teu) {
		this.teu = teu;
	}
	
	/**
	 * Column Info
	 * @param drwFmDt
	 */
	public void setDrwFmDt(String drwFmDt) {
		this.drwFmDt = drwFmDt;
	}
	
	/**
	 * Column Info
	 * @param podVpsEtbDt
	 */
	public void setPodVpsEtbDt(String podVpsEtbDt) {
		this.podVpsEtbDt = podVpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param drwCrrCd
	 */
	public void setDrwCrrCd(String drwCrrCd) {
		this.drwCrrCd = drwCrrCd;
	}
	
	/**
	 * Column Info
	 * @param drwPolCd
	 */
	public void setDrwPolCd(String drwPolCd) {
		this.drwPolCd = drwPolCd;
	}
	
	/**
	 * Column Info
	 * @param polActAtdInpDt
	 */
	public void setPolActAtdInpDt(String polActAtdInpDt) {
		this.polActAtdInpDt = polActAtdInpDt;
	}
	
	/**
	 * Column Info
	 * @param drwInpYrmon
	 */
	public void setDrwInpYrmon(String drwInpYrmon) {
		this.drwInpYrmon = drwInpYrmon;
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
		setPodActBrthDt(JSPUtil.getParameter(request, prefix + "pod_act_brth_dt", ""));
		setDrwPodCd(JSPUtil.getParameter(request, prefix + "drw_pod_cd", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodClptSeq(JSPUtil.getParameter(request, prefix + "pod_clpt_seq", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPodActArrDt(JSPUtil.getParameter(request, prefix + "pod_act_arr_dt", ""));
		setPolClptIndSeq(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setOpt(JSPUtil.getParameter(request, prefix + "opt", ""));
		setDrwTeu(JSPUtil.getParameter(request, prefix + "drw_teu", ""));
		setDrwSlanCd(JSPUtil.getParameter(request, prefix + "drw_slan_cd", ""));
		setPolClptSeq(JSPUtil.getParameter(request, prefix + "pol_clpt_seq", ""));
		setPodClptIndSeq(JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setDrwToDt(JSPUtil.getParameter(request, prefix + "drw_to_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPolActDepDt(JSPUtil.getParameter(request, prefix + "pol_act_dep_dt", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setPodVpsEtaDt(JSPUtil.getParameter(request, prefix + "pod_vps_eta_dt", ""));
		setTeu(JSPUtil.getParameter(request, prefix + "teu", ""));
		setDrwFmDt(JSPUtil.getParameter(request, prefix + "drw_fm_dt", ""));
		setPodVpsEtbDt(JSPUtil.getParameter(request, prefix + "pod_vps_etb_dt", ""));
		setDrwCrrCd(JSPUtil.getParameter(request, prefix + "drw_crr_cd", ""));
		setDrwPolCd(JSPUtil.getParameter(request, prefix + "drw_pol_cd", ""));
		setPolActAtdInpDt(JSPUtil.getParameter(request, prefix + "pol_act_atd_inp_dt", ""));
		setDrwInpYrmon(JSPUtil.getParameter(request, prefix + "drw_inp_yrmon", ""));

	}

	/**
	 * 
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DrwSkdSearchVO[]
	 */
	public DrwSkdSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DrwSkdSearchVO[]
	 */
	public DrwSkdSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DrwSkdSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] podActBrthDt = (JSPUtil.getParameter(request, prefix	+ "pod_act_brth_dt", length));
			String[] drwPodCd = (JSPUtil.getParameter(request, prefix	+ "drw_pod_cd", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podClptSeq = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_seq", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podActArrDt = (JSPUtil.getParameter(request, prefix	+ "pod_act_arr_dt", length));
			String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pol_clpt_ind_seq", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] opt = (JSPUtil.getParameter(request, prefix	+ "opt", length));
			String[] drwTeu = (JSPUtil.getParameter(request, prefix	+ "drw_teu", length));
			String[] drwSlanCd = (JSPUtil.getParameter(request, prefix	+ "drw_slan_cd", length));
			String[] polClptSeq = (JSPUtil.getParameter(request, prefix	+ "pol_clpt_seq", length));
			String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] drwToDt = (JSPUtil.getParameter(request, prefix	+ "drw_to_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] polActDepDt = (JSPUtil.getParameter(request, prefix	+ "pol_act_dep_dt", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] podVpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "pod_vps_eta_dt", length));
			String[] teu = (JSPUtil.getParameter(request, prefix	+ "teu", length));
			String[] drwFmDt = (JSPUtil.getParameter(request, prefix	+ "drw_fm_dt", length));
			String[] podVpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "pod_vps_etb_dt", length));
			String[] drwCrrCd = (JSPUtil.getParameter(request, prefix	+ "drw_crr_cd", length));
			String[] drwPolCd = (JSPUtil.getParameter(request, prefix	+ "drw_pol_cd", length));
			String[] polActAtdInpDt = (JSPUtil.getParameter(request, prefix	+ "pol_act_atd_inp_dt", length));
			String[] drwInpYrmon = (JSPUtil.getParameter(request, prefix	+ "drw_inp_yrmon", length));

			
			for (int i = 0; i < length; i++) {
				model = new DrwSkdSearchVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (podActBrthDt[i] != null)
					model.setPodActBrthDt(podActBrthDt[i]);
				if (drwPodCd[i] != null)
					model.setDrwPodCd(drwPodCd[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podClptSeq[i] != null)
					model.setPodClptSeq(podClptSeq[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podActArrDt[i] != null)
					model.setPodActArrDt(podActArrDt[i]);
				if (polClptIndSeq[i] != null)
					model.setPolClptIndSeq(polClptIndSeq[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (opt[i] != null)
					model.setOpt(opt[i]);
				if (drwTeu[i] != null)
					model.setDrwTeu(drwTeu[i]);
				if (drwSlanCd[i] != null)
					model.setDrwSlanCd(drwSlanCd[i]);
				if (polClptSeq[i] != null)
					model.setPolClptSeq(polClptSeq[i]);
				if (podClptIndSeq[i] != null)
					model.setPodClptIndSeq(podClptIndSeq[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (drwToDt[i] != null)
					model.setDrwToDt(drwToDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (polActDepDt[i] != null)
					model.setPolActDepDt(polActDepDt[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (podVpsEtaDt[i] != null)
					model.setPodVpsEtaDt(podVpsEtaDt[i]);
				if (teu[i] != null)
					model.setTeu(teu[i]);
				if (drwFmDt[i] != null)
					model.setDrwFmDt(drwFmDt[i]);
				if (podVpsEtbDt[i] != null)
					model.setPodVpsEtbDt(podVpsEtbDt[i]);
				if (drwCrrCd[i] != null)
					model.setDrwCrrCd(drwCrrCd[i]);
				if (drwPolCd[i] != null)
					model.setDrwPolCd(drwPolCd[i]);
				if (polActAtdInpDt[i] != null)
					model.setPolActAtdInpDt(polActAtdInpDt[i]);
				if (drwInpYrmon[i] != null)
					model.setDrwInpYrmon(drwInpYrmon[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDrwSkdSearchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DrwSkdSearchVO[]
	 */
	public DrwSkdSearchVO[] getDrwSkdSearchVOs(){
		DrwSkdSearchVO[] vos = (DrwSkdSearchVO[])models.toArray(new DrwSkdSearchVO[models.size()]);
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
		this.podActBrthDt = this.podActBrthDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drwPodCd = this.drwPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptSeq = this.podClptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podActArrDt = this.podActArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polClptIndSeq = this.polClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opt = this.opt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drwTeu = this.drwTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drwSlanCd = this.drwSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polClptSeq = this.polClptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq = this.podClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drwToDt = this.drwToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polActDepDt = this.polActDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podVpsEtaDt = this.podVpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu = this.teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drwFmDt = this.drwFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podVpsEtbDt = this.podVpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drwCrrCd = this.drwCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drwPolCd = this.drwPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polActAtdInpDt = this.polActAtdInpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drwInpYrmon = this.drwInpYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
