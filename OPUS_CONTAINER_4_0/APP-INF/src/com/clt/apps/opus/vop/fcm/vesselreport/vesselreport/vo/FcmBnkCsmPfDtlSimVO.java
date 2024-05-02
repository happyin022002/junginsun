/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FcmBnkCsmPfDtlSimVO.java
*@FileTitle : FcmBnkCsmPfDtlSimVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.02
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.01.02 진마리아 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo;

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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FcmBnkCsmPfDtlSimVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FcmBnkCsmPfDtlSimVO> models = new ArrayList<FcmBnkCsmPfDtlSimVO>();
	
	/* Column Info */
	private String simMnvrFoilCsmWgt = null;
	/* Column Info */
	private String simBufSeaFoilCsmWgt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String simNo = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String simSeaSpd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String clptSeq = null;
	/* Column Info */
	private String vslClssCd = null;
	/* Column Info */
	private String simGnrSeaFoilCsmWgt = null;
	/* Column Info */
	private String simPortFoilCsmWgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pfSvcTpCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String simSeaFoilCsmWgt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String simMaxSpd = null;
	/* Column Info */
	private String simBufTtlFoilCsmWgt = null;
	/* Column Info */
	private String simBufGnrFoilCsmWgt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String simGnrPortFoilCsmWgt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String simRunAuxSpd = null;
	/* Column Info */
	private String simTtlFoilCsmWgt = null;
	/* Column Info */
	private String simMinSpd = null;
	/* Column Info */
	private String simBufSeaSpd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FcmBnkCsmPfDtlSimVO() {}

	public FcmBnkCsmPfDtlSimVO(String ibflag, String pagerows, String simMnvrFoilCsmWgt, String simBufSeaFoilCsmWgt, String creDt, String simNo, String vslSlanCd, String simSeaSpd, String vslClssCd, String clptSeq, String simPortFoilCsmWgt, String simGnrSeaFoilCsmWgt, String pfSvcTpCd, String portCd, String updUsrId, String simSeaFoilCsmWgt, String updDt, String simMaxSpd, String simBufTtlFoilCsmWgt, String simBufGnrFoilCsmWgt, String skdDirCd, String simGnrPortFoilCsmWgt, String creUsrId, String ydCd, String simRunAuxSpd, String simMinSpd, String simTtlFoilCsmWgt, String simBufSeaSpd) {
		this.simMnvrFoilCsmWgt = simMnvrFoilCsmWgt;
		this.simBufSeaFoilCsmWgt = simBufSeaFoilCsmWgt;
		this.creDt = creDt;
		this.simNo = simNo;
		this.vslSlanCd = vslSlanCd;
		this.simSeaSpd = simSeaSpd;
		this.pagerows = pagerows;
		this.clptSeq = clptSeq;
		this.vslClssCd = vslClssCd;
		this.simGnrSeaFoilCsmWgt = simGnrSeaFoilCsmWgt;
		this.simPortFoilCsmWgt = simPortFoilCsmWgt;
		this.ibflag = ibflag;
		this.pfSvcTpCd = pfSvcTpCd;
		this.portCd = portCd;
		this.updUsrId = updUsrId;
		this.simSeaFoilCsmWgt = simSeaFoilCsmWgt;
		this.updDt = updDt;
		this.simMaxSpd = simMaxSpd;
		this.simBufTtlFoilCsmWgt = simBufTtlFoilCsmWgt;
		this.simBufGnrFoilCsmWgt = simBufGnrFoilCsmWgt;
		this.skdDirCd = skdDirCd;
		this.simGnrPortFoilCsmWgt = simGnrPortFoilCsmWgt;
		this.creUsrId = creUsrId;
		this.ydCd = ydCd;
		this.simRunAuxSpd = simRunAuxSpd;
		this.simTtlFoilCsmWgt = simTtlFoilCsmWgt;
		this.simMinSpd = simMinSpd;
		this.simBufSeaSpd = simBufSeaSpd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sim_mnvr_foil_csm_wgt", getSimMnvrFoilCsmWgt());
		this.hashColumns.put("sim_buf_sea_foil_csm_wgt", getSimBufSeaFoilCsmWgt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sim_no", getSimNo());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("sim_sea_spd", getSimSeaSpd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("vsl_clss_cd", getVslClssCd());
		this.hashColumns.put("sim_gnr_sea_foil_csm_wgt", getSimGnrSeaFoilCsmWgt());
		this.hashColumns.put("sim_port_foil_csm_wgt", getSimPortFoilCsmWgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pf_svc_tp_cd", getPfSvcTpCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sim_sea_foil_csm_wgt", getSimSeaFoilCsmWgt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("sim_max_spd", getSimMaxSpd());
		this.hashColumns.put("sim_buf_ttl_foil_csm_wgt", getSimBufTtlFoilCsmWgt());
		this.hashColumns.put("sim_buf_gnr_foil_csm_wgt", getSimBufGnrFoilCsmWgt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("sim_gnr_port_foil_csm_wgt", getSimGnrPortFoilCsmWgt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("sim_run_aux_spd", getSimRunAuxSpd());
		this.hashColumns.put("sim_ttl_foil_csm_wgt", getSimTtlFoilCsmWgt());
		this.hashColumns.put("sim_min_spd", getSimMinSpd());
		this.hashColumns.put("sim_buf_sea_spd", getSimBufSeaSpd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sim_mnvr_foil_csm_wgt", "simMnvrFoilCsmWgt");
		this.hashFields.put("sim_buf_sea_foil_csm_wgt", "simBufSeaFoilCsmWgt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sim_no", "simNo");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("sim_sea_spd", "simSeaSpd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("vsl_clss_cd", "vslClssCd");
		this.hashFields.put("sim_gnr_sea_foil_csm_wgt", "simGnrSeaFoilCsmWgt");
		this.hashFields.put("sim_port_foil_csm_wgt", "simPortFoilCsmWgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pf_svc_tp_cd", "pfSvcTpCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sim_sea_foil_csm_wgt", "simSeaFoilCsmWgt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("sim_max_spd", "simMaxSpd");
		this.hashFields.put("sim_buf_ttl_foil_csm_wgt", "simBufTtlFoilCsmWgt");
		this.hashFields.put("sim_buf_gnr_foil_csm_wgt", "simBufGnrFoilCsmWgt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("sim_gnr_port_foil_csm_wgt", "simGnrPortFoilCsmWgt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("sim_run_aux_spd", "simRunAuxSpd");
		this.hashFields.put("sim_ttl_foil_csm_wgt", "simTtlFoilCsmWgt");
		this.hashFields.put("sim_min_spd", "simMinSpd");
		this.hashFields.put("sim_buf_sea_spd", "simBufSeaSpd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return simMnvrFoilCsmWgt
	 */
	public String getSimMnvrFoilCsmWgt() {
		return this.simMnvrFoilCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return simBufSeaFoilCsmWgt
	 */
	public String getSimBufSeaFoilCsmWgt() {
		return this.simBufSeaFoilCsmWgt;
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
	 * @return simNo
	 */
	public String getSimNo() {
		return this.simNo;
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
	 * @return simSeaSpd
	 */
	public String getSimSeaSpd() {
		return this.simSeaSpd;
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
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
	}
	
	/**
	 * Column Info
	 * @return vslClssCd
	 */
	public String getVslClssCd() {
		return this.vslClssCd;
	}
	
	/**
	 * Column Info
	 * @return simGnrSeaFoilCsmWgt
	 */
	public String getSimGnrSeaFoilCsmWgt() {
		return this.simGnrSeaFoilCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return simPortFoilCsmWgt
	 */
	public String getSimPortFoilCsmWgt() {
		return this.simPortFoilCsmWgt;
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
	 * @return pfSvcTpCd
	 */
	public String getPfSvcTpCd() {
		return this.pfSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
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
	 * @return simSeaFoilCsmWgt
	 */
	public String getSimSeaFoilCsmWgt() {
		return this.simSeaFoilCsmWgt;
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
	 * @return simMaxSpd
	 */
	public String getSimMaxSpd() {
		return this.simMaxSpd;
	}
	
	/**
	 * Column Info
	 * @return simBufTtlFoilCsmWgt
	 */
	public String getSimBufTtlFoilCsmWgt() {
		return this.simBufTtlFoilCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return simBufGnrFoilCsmWgt
	 */
	public String getSimBufGnrFoilCsmWgt() {
		return this.simBufGnrFoilCsmWgt;
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
	 * @return simGnrPortFoilCsmWgt
	 */
	public String getSimGnrPortFoilCsmWgt() {
		return this.simGnrPortFoilCsmWgt;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return simRunAuxSpd
	 */
	public String getSimRunAuxSpd() {
		return this.simRunAuxSpd;
	}
	
	/**
	 * Column Info
	 * @return simTtlFoilCsmWgt
	 */
	public String getSimTtlFoilCsmWgt() {
		return this.simTtlFoilCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return simMinSpd
	 */
	public String getSimMinSpd() {
		return this.simMinSpd;
	}
	
	/**
	 * Column Info
	 * @return simBufSeaSpd
	 */
	public String getSimBufSeaSpd() {
		return this.simBufSeaSpd;
	}
	

	/**
	 * Column Info
	 * @param simMnvrFoilCsmWgt
	 */
	public void setSimMnvrFoilCsmWgt(String simMnvrFoilCsmWgt) {
		this.simMnvrFoilCsmWgt = simMnvrFoilCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param simBufSeaFoilCsmWgt
	 */
	public void setSimBufSeaFoilCsmWgt(String simBufSeaFoilCsmWgt) {
		this.simBufSeaFoilCsmWgt = simBufSeaFoilCsmWgt;
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
	 * @param simNo
	 */
	public void setSimNo(String simNo) {
		this.simNo = simNo;
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
	 * @param simSeaSpd
	 */
	public void setSimSeaSpd(String simSeaSpd) {
		this.simSeaSpd = simSeaSpd;
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
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
	}
	
	/**
	 * Column Info
	 * @param vslClssCd
	 */
	public void setVslClssCd(String vslClssCd) {
		this.vslClssCd = vslClssCd;
	}
	
	/**
	 * Column Info
	 * @param simGnrSeaFoilCsmWgt
	 */
	public void setSimGnrSeaFoilCsmWgt(String simGnrSeaFoilCsmWgt) {
		this.simGnrSeaFoilCsmWgt = simGnrSeaFoilCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param simPortFoilCsmWgt
	 */
	public void setSimPortFoilCsmWgt(String simPortFoilCsmWgt) {
		this.simPortFoilCsmWgt = simPortFoilCsmWgt;
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
	 * @param pfSvcTpCd
	 */
	public void setPfSvcTpCd(String pfSvcTpCd) {
		this.pfSvcTpCd = pfSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
	 * @param simSeaFoilCsmWgt
	 */
	public void setSimSeaFoilCsmWgt(String simSeaFoilCsmWgt) {
		this.simSeaFoilCsmWgt = simSeaFoilCsmWgt;
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
	 * @param simMaxSpd
	 */
	public void setSimMaxSpd(String simMaxSpd) {
		this.simMaxSpd = simMaxSpd;
	}
	
	/**
	 * Column Info
	 * @param simBufTtlFoilCsmWgt
	 */
	public void setSimBufTtlFoilCsmWgt(String simBufTtlFoilCsmWgt) {
		this.simBufTtlFoilCsmWgt = simBufTtlFoilCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param simBufGnrFoilCsmWgt
	 */
	public void setSimBufGnrFoilCsmWgt(String simBufGnrFoilCsmWgt) {
		this.simBufGnrFoilCsmWgt = simBufGnrFoilCsmWgt;
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
	 * @param simGnrPortFoilCsmWgt
	 */
	public void setSimGnrPortFoilCsmWgt(String simGnrPortFoilCsmWgt) {
		this.simGnrPortFoilCsmWgt = simGnrPortFoilCsmWgt;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param simRunAuxSpd
	 */
	public void setSimRunAuxSpd(String simRunAuxSpd) {
		this.simRunAuxSpd = simRunAuxSpd;
	}
	
	/**
	 * Column Info
	 * @param simTtlFoilCsmWgt
	 */
	public void setSimTtlFoilCsmWgt(String simTtlFoilCsmWgt) {
		this.simTtlFoilCsmWgt = simTtlFoilCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param simMinSpd
	 */
	public void setSimMinSpd(String simMinSpd) {
		this.simMinSpd = simMinSpd;
	}
	
	/**
	 * Column Info
	 * @param simBufSeaSpd
	 */
	public void setSimBufSeaSpd(String simBufSeaSpd) {
		this.simBufSeaSpd = simBufSeaSpd;
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
		setSimMnvrFoilCsmWgt(JSPUtil.getParameter(request, prefix + "sim_mnvr_foil_csm_wgt", ""));
		setSimBufSeaFoilCsmWgt(JSPUtil.getParameter(request, prefix + "sim_buf_sea_foil_csm_wgt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSimNo(JSPUtil.getParameter(request, prefix + "sim_no", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setSimSeaSpd(JSPUtil.getParameter(request, prefix + "sim_sea_spd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setVslClssCd(JSPUtil.getParameter(request, prefix + "vsl_clss_cd", ""));
		setSimGnrSeaFoilCsmWgt(JSPUtil.getParameter(request, prefix + "sim_gnr_sea_foil_csm_wgt", ""));
		setSimPortFoilCsmWgt(JSPUtil.getParameter(request, prefix + "sim_port_foil_csm_wgt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPfSvcTpCd(JSPUtil.getParameter(request, prefix + "pf_svc_tp_cd", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setSimSeaFoilCsmWgt(JSPUtil.getParameter(request, prefix + "sim_sea_foil_csm_wgt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSimMaxSpd(JSPUtil.getParameter(request, prefix + "sim_max_spd", ""));
		setSimBufTtlFoilCsmWgt(JSPUtil.getParameter(request, prefix + "sim_buf_ttl_foil_csm_wgt", ""));
		setSimBufGnrFoilCsmWgt(JSPUtil.getParameter(request, prefix + "sim_buf_gnr_foil_csm_wgt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setSimGnrPortFoilCsmWgt(JSPUtil.getParameter(request, prefix + "sim_gnr_port_foil_csm_wgt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setSimRunAuxSpd(JSPUtil.getParameter(request, prefix + "sim_run_aux_spd", ""));
		setSimTtlFoilCsmWgt(JSPUtil.getParameter(request, prefix + "sim_ttl_foil_csm_wgt", ""));
		setSimMinSpd(JSPUtil.getParameter(request, prefix + "sim_min_spd", ""));
		setSimBufSeaSpd(JSPUtil.getParameter(request, prefix + "sim_buf_sea_spd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FcmBnkCsmPfDtlSimVO[]
	 */
	public FcmBnkCsmPfDtlSimVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FcmBnkCsmPfDtlSimVO[]
	 */
	public FcmBnkCsmPfDtlSimVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FcmBnkCsmPfDtlSimVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] simMnvrFoilCsmWgt = (JSPUtil.getParameter(request, prefix	+ "sim_mnvr_foil_csm_wgt", length));
			String[] simBufSeaFoilCsmWgt = (JSPUtil.getParameter(request, prefix	+ "sim_buf_sea_foil_csm_wgt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] simNo = (JSPUtil.getParameter(request, prefix	+ "sim_no", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] simSeaSpd = (JSPUtil.getParameter(request, prefix	+ "sim_sea_spd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] vslClssCd = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_cd", length));
			String[] simGnrSeaFoilCsmWgt = (JSPUtil.getParameter(request, prefix	+ "sim_gnr_sea_foil_csm_wgt", length));
			String[] simPortFoilCsmWgt = (JSPUtil.getParameter(request, prefix	+ "sim_port_foil_csm_wgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pfSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_svc_tp_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] simSeaFoilCsmWgt = (JSPUtil.getParameter(request, prefix	+ "sim_sea_foil_csm_wgt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] simMaxSpd = (JSPUtil.getParameter(request, prefix	+ "sim_max_spd", length));
			String[] simBufTtlFoilCsmWgt = (JSPUtil.getParameter(request, prefix	+ "sim_buf_ttl_foil_csm_wgt", length));
			String[] simBufGnrFoilCsmWgt = (JSPUtil.getParameter(request, prefix	+ "sim_buf_gnr_foil_csm_wgt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] simGnrPortFoilCsmWgt = (JSPUtil.getParameter(request, prefix	+ "sim_gnr_port_foil_csm_wgt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] simRunAuxSpd = (JSPUtil.getParameter(request, prefix	+ "sim_run_aux_spd", length));
			String[] simTtlFoilCsmWgt = (JSPUtil.getParameter(request, prefix	+ "sim_ttl_foil_csm_wgt", length));
			String[] simMinSpd = (JSPUtil.getParameter(request, prefix	+ "sim_min_spd", length));
			String[] simBufSeaSpd = (JSPUtil.getParameter(request, prefix	+ "sim_buf_sea_spd", length));
			
			for (int i = 0; i < length; i++) {
				model = new FcmBnkCsmPfDtlSimVO();
				if (simMnvrFoilCsmWgt[i] != null)
					model.setSimMnvrFoilCsmWgt(simMnvrFoilCsmWgt[i]);
				if (simBufSeaFoilCsmWgt[i] != null)
					model.setSimBufSeaFoilCsmWgt(simBufSeaFoilCsmWgt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (simNo[i] != null)
					model.setSimNo(simNo[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (simSeaSpd[i] != null)
					model.setSimSeaSpd(simSeaSpd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (vslClssCd[i] != null)
					model.setVslClssCd(vslClssCd[i]);
				if (simGnrSeaFoilCsmWgt[i] != null)
					model.setSimGnrSeaFoilCsmWgt(simGnrSeaFoilCsmWgt[i]);
				if (simPortFoilCsmWgt[i] != null)
					model.setSimPortFoilCsmWgt(simPortFoilCsmWgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pfSvcTpCd[i] != null)
					model.setPfSvcTpCd(pfSvcTpCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (simSeaFoilCsmWgt[i] != null)
					model.setSimSeaFoilCsmWgt(simSeaFoilCsmWgt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (simMaxSpd[i] != null)
					model.setSimMaxSpd(simMaxSpd[i]);
				if (simBufTtlFoilCsmWgt[i] != null)
					model.setSimBufTtlFoilCsmWgt(simBufTtlFoilCsmWgt[i]);
				if (simBufGnrFoilCsmWgt[i] != null)
					model.setSimBufGnrFoilCsmWgt(simBufGnrFoilCsmWgt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (simGnrPortFoilCsmWgt[i] != null)
					model.setSimGnrPortFoilCsmWgt(simGnrPortFoilCsmWgt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (simRunAuxSpd[i] != null)
					model.setSimRunAuxSpd(simRunAuxSpd[i]);
				if (simTtlFoilCsmWgt[i] != null)
					model.setSimTtlFoilCsmWgt(simTtlFoilCsmWgt[i]);
				if (simMinSpd[i] != null)
					model.setSimMinSpd(simMinSpd[i]);
				if (simBufSeaSpd[i] != null)
					model.setSimBufSeaSpd(simBufSeaSpd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFcmBnkCsmPfDtlSimVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FcmBnkCsmPfDtlSimVO[]
	 */
	public FcmBnkCsmPfDtlSimVO[] getFcmBnkCsmPfDtlSimVOs(){
		FcmBnkCsmPfDtlSimVO[] vos = (FcmBnkCsmPfDtlSimVO[])models.toArray(new FcmBnkCsmPfDtlSimVO[models.size()]);
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
		this.simMnvrFoilCsmWgt = this.simMnvrFoilCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simBufSeaFoilCsmWgt = this.simBufSeaFoilCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simNo = this.simNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simSeaSpd = this.simSeaSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCd = this.vslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simGnrSeaFoilCsmWgt = this.simGnrSeaFoilCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simPortFoilCsmWgt = this.simPortFoilCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSvcTpCd = this.pfSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simSeaFoilCsmWgt = this.simSeaFoilCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simMaxSpd = this.simMaxSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simBufTtlFoilCsmWgt = this.simBufTtlFoilCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simBufGnrFoilCsmWgt = this.simBufGnrFoilCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simGnrPortFoilCsmWgt = this.simGnrPortFoilCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simRunAuxSpd = this.simRunAuxSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simTtlFoilCsmWgt = this.simTtlFoilCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simMinSpd = this.simMinSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simBufSeaSpd = this.simBufSeaSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
