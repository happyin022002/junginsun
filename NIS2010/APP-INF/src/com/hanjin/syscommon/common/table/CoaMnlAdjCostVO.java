/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CoaMnlAdjCostVO.java
*@FileTitle : CoaMnlAdjCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.04
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2012.10.04 최성민 
* 1.0 Creation
* 2012.10.15 이석준 [CHM-201220161-01] 실시간 영업현황 관련 UI
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CoaMnlAdjCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CoaMnlAdjCostVO> models = new ArrayList<CoaMnlAdjCostVO>();
	
	/* Column Info */
	private String mcntrStvgAmt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String mcntrStvgAdjAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bizActAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String mcntrStvgFnlAmt = null;
	/* Column Info */
	private String mcntrTrspAmt = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String mcntrTrspAdjAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String bizActFnlAmt = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mcntrTrspFnlAmt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String bizActAdjAmt = null;
	/* Column Info */
	private String slsYrmon = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CoaMnlAdjCostVO() {}

	public CoaMnlAdjCostVO(String ibflag, String pagerows, String costYrmon, String costWk, String trdCd, String rlaneCd, String iocCd, String vslCd, String skdVoyNo, String dirCd, String subTrdCd, String slsYrmon, String mcntrStvgAmt, String mcntrStvgAdjAmt, String mcntrStvgFnlAmt, String mcntrTrspAmt, String mcntrTrspAdjAmt, String mcntrTrspFnlAmt, String bizActAmt, String bizActAdjAmt, String bizActFnlAmt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.mcntrStvgAmt = mcntrStvgAmt;
		this.vslCd = vslCd;
		this.mcntrStvgAdjAmt = mcntrStvgAdjAmt;
		this.creDt = creDt;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.bizActAmt = bizActAmt;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.mcntrStvgFnlAmt = mcntrStvgFnlAmt;
		this.mcntrTrspAmt = mcntrTrspAmt;
		this.dirCd = dirCd;
		this.mcntrTrspAdjAmt = mcntrTrspAdjAmt;
		this.updUsrId = updUsrId;
		this.bizActFnlAmt = bizActFnlAmt;
		this.iocCd = iocCd;
		this.updDt = updDt;
		this.mcntrTrspFnlAmt = mcntrTrspFnlAmt;
		this.skdVoyNo = skdVoyNo;
		this.bizActAdjAmt = bizActAdjAmt;
		this.slsYrmon = slsYrmon;
		this.creUsrId = creUsrId;
		this.costWk = costWk;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mcntr_stvg_amt", getMcntrStvgAmt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("mcntr_stvg_adj_amt", getMcntrStvgAdjAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("biz_act_amt", getBizActAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("mcntr_stvg_fnl_amt", getMcntrStvgFnlAmt());
		this.hashColumns.put("mcntr_trsp_amt", getMcntrTrspAmt());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("mcntr_trsp_adj_amt", getMcntrTrspAdjAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("biz_act_fnl_amt", getBizActFnlAmt());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mcntr_trsp_fnl_amt", getMcntrTrspFnlAmt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("biz_act_adj_amt", getBizActAdjAmt());
		this.hashColumns.put("sls_yrmon", getSlsYrmon());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mcntr_stvg_amt", "mcntrStvgAmt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("mcntr_stvg_adj_amt", "mcntrStvgAdjAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("biz_act_amt", "bizActAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("mcntr_stvg_fnl_amt", "mcntrStvgFnlAmt");
		this.hashFields.put("mcntr_trsp_amt", "mcntrTrspAmt");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("mcntr_trsp_adj_amt", "mcntrTrspAdjAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("biz_act_fnl_amt", "bizActFnlAmt");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mcntr_trsp_fnl_amt", "mcntrTrspFnlAmt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("biz_act_adj_amt", "bizActAdjAmt");
		this.hashFields.put("sls_yrmon", "slsYrmon");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mcntrStvgAmt
	 */
	public String getMcntrStvgAmt() {
		return this.mcntrStvgAmt;
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
	 * @return mcntrStvgAdjAmt
	 */
	public String getMcntrStvgAdjAmt() {
		return this.mcntrStvgAdjAmt;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return bizActAmt
	 */
	public String getBizActAmt() {
		return this.bizActAmt;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return mcntrStvgFnlAmt
	 */
	public String getMcntrStvgFnlAmt() {
		return this.mcntrStvgFnlAmt;
	}
	
	/**
	 * Column Info
	 * @return mcntrTrspAmt
	 */
	public String getMcntrTrspAmt() {
		return this.mcntrTrspAmt;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return mcntrTrspAdjAmt
	 */
	public String getMcntrTrspAdjAmt() {
		return this.mcntrTrspAdjAmt;
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
	 * @return bizActFnlAmt
	 */
	public String getBizActFnlAmt() {
		return this.bizActFnlAmt;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
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
	 * @return mcntrTrspFnlAmt
	 */
	public String getMcntrTrspFnlAmt() {
		return this.mcntrTrspFnlAmt;
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
	 * @return bizActAdjAmt
	 */
	public String getBizActAdjAmt() {
		return this.bizActAdjAmt;
	}
	
	/**
	 * Column Info
	 * @return slsYrmon
	 */
	public String getSlsYrmon() {
		return this.slsYrmon;
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
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	

	/**
	 * Column Info
	 * @param mcntrStvgAmt
	 */
	public void setMcntrStvgAmt(String mcntrStvgAmt) {
		this.mcntrStvgAmt = mcntrStvgAmt;
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
	 * @param mcntrStvgAdjAmt
	 */
	public void setMcntrStvgAdjAmt(String mcntrStvgAdjAmt) {
		this.mcntrStvgAdjAmt = mcntrStvgAdjAmt;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param bizActAmt
	 */
	public void setBizActAmt(String bizActAmt) {
		this.bizActAmt = bizActAmt;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param mcntrStvgFnlAmt
	 */
	public void setMcntrStvgFnlAmt(String mcntrStvgFnlAmt) {
		this.mcntrStvgFnlAmt = mcntrStvgFnlAmt;
	}
	
	/**
	 * Column Info
	 * @param mcntrTrspAmt
	 */
	public void setMcntrTrspAmt(String mcntrTrspAmt) {
		this.mcntrTrspAmt = mcntrTrspAmt;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param mcntrTrspAdjAmt
	 */
	public void setMcntrTrspAdjAmt(String mcntrTrspAdjAmt) {
		this.mcntrTrspAdjAmt = mcntrTrspAdjAmt;
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
	 * @param bizActFnlAmt
	 */
	public void setBizActFnlAmt(String bizActFnlAmt) {
		this.bizActFnlAmt = bizActFnlAmt;
	}
	
	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
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
	 * @param mcntrTrspFnlAmt
	 */
	public void setMcntrTrspFnlAmt(String mcntrTrspFnlAmt) {
		this.mcntrTrspFnlAmt = mcntrTrspFnlAmt;
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
	 * @param bizActAdjAmt
	 */
	public void setBizActAdjAmt(String bizActAdjAmt) {
		this.bizActAdjAmt = bizActAdjAmt;
	}
	
	/**
	 * Column Info
	 * @param slsYrmon
	 */
	public void setSlsYrmon(String slsYrmon) {
		this.slsYrmon = slsYrmon;
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
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
		setMcntrStvgAmt(JSPUtil.getParameter(request, prefix + "mcntr_stvg_amt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setMcntrStvgAdjAmt(JSPUtil.getParameter(request, prefix + "mcntr_stvg_adj_amt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBizActAmt(JSPUtil.getParameter(request, prefix + "biz_act_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setMcntrStvgFnlAmt(JSPUtil.getParameter(request, prefix + "mcntr_stvg_fnl_amt", ""));
		setMcntrTrspAmt(JSPUtil.getParameter(request, prefix + "mcntr_trsp_amt", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setMcntrTrspAdjAmt(JSPUtil.getParameter(request, prefix + "mcntr_trsp_adj_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setBizActFnlAmt(JSPUtil.getParameter(request, prefix + "biz_act_fnl_amt", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setMcntrTrspFnlAmt(JSPUtil.getParameter(request, prefix + "mcntr_trsp_fnl_amt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setBizActAdjAmt(JSPUtil.getParameter(request, prefix + "biz_act_adj_amt", ""));
		setSlsYrmon(JSPUtil.getParameter(request, prefix + "sls_yrmon", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CoaMnlAdjCostVO[]
	 */
	public CoaMnlAdjCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CoaMnlAdjCostVO[]
	 */
	public CoaMnlAdjCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CoaMnlAdjCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mcntrStvgAmt = (JSPUtil.getParameter(request, prefix	+ "mcntr_stvg_amt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] mcntrStvgAdjAmt = (JSPUtil.getParameter(request, prefix	+ "mcntr_stvg_adj_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bizActAmt = (JSPUtil.getParameter(request, prefix	+ "biz_act_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] mcntrStvgFnlAmt = (JSPUtil.getParameter(request, prefix	+ "mcntr_stvg_fnl_amt", length));
			String[] mcntrTrspAmt = (JSPUtil.getParameter(request, prefix	+ "mcntr_trsp_amt", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] mcntrTrspAdjAmt = (JSPUtil.getParameter(request, prefix	+ "mcntr_trsp_adj_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] bizActFnlAmt = (JSPUtil.getParameter(request, prefix	+ "biz_act_fnl_amt", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] mcntrTrspFnlAmt = (JSPUtil.getParameter(request, prefix	+ "mcntr_trsp_fnl_amt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] bizActAdjAmt = (JSPUtil.getParameter(request, prefix	+ "biz_act_adj_amt", length));
			String[] slsYrmon = (JSPUtil.getParameter(request, prefix	+ "sls_yrmon", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CoaMnlAdjCostVO();
				if (mcntrStvgAmt[i] != null)
					model.setMcntrStvgAmt(mcntrStvgAmt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (mcntrStvgAdjAmt[i] != null)
					model.setMcntrStvgAdjAmt(mcntrStvgAdjAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bizActAmt[i] != null)
					model.setBizActAmt(bizActAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (mcntrStvgFnlAmt[i] != null)
					model.setMcntrStvgFnlAmt(mcntrStvgFnlAmt[i]);
				if (mcntrTrspAmt[i] != null)
					model.setMcntrTrspAmt(mcntrTrspAmt[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (mcntrTrspAdjAmt[i] != null)
					model.setMcntrTrspAdjAmt(mcntrTrspAdjAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (bizActFnlAmt[i] != null)
					model.setBizActFnlAmt(bizActFnlAmt[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mcntrTrspFnlAmt[i] != null)
					model.setMcntrTrspFnlAmt(mcntrTrspFnlAmt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (bizActAdjAmt[i] != null)
					model.setBizActAdjAmt(bizActAdjAmt[i]);
				if (slsYrmon[i] != null)
					model.setSlsYrmon(slsYrmon[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCoaMnlAdjCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CoaMnlAdjCostVO[]
	 */
	public CoaMnlAdjCostVO[] getCoaMnlAdjCostVOs(){
		CoaMnlAdjCostVO[] vos = (CoaMnlAdjCostVO[])models.toArray(new CoaMnlAdjCostVO[models.size()]);
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
		this.mcntrStvgAmt = this.mcntrStvgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mcntrStvgAdjAmt = this.mcntrStvgAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizActAmt = this.bizActAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mcntrStvgFnlAmt = this.mcntrStvgFnlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mcntrTrspAmt = this.mcntrTrspAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mcntrTrspAdjAmt = this.mcntrTrspAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizActFnlAmt = this.bizActFnlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mcntrTrspFnlAmt = this.mcntrTrspFnlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizActAdjAmt = this.bizActAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsYrmon = this.slsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
