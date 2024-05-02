/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MasBnkTrfVO.java
*@FileTitle : MasBnkTrfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.14
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.01.14 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class MasBnkTrfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MasBnkTrfVO> models = new ArrayList<MasBnkTrfVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String oldFoilUcAmt = null;
	/* Column Info */
	private String slanDirCd = null;
	/* Column Info */
	private String foilAmt = null;
	/* Column Info */
	private String wkAvgUcAmt = null;
	/* Column Info */
	private String foilAvgCsm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String foilCsm = null;
	/* Column Info */
	private String foilUcAmt = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String doilUcAmt = null;
	/* Column Info */
	private String vslClssCapa = null;
	/* Column Info */
	private String doilAmt = null;
	/* Column Info */
	private String wkEstmUcAmt = null;
	/* Column Info */
	private String doilCsm = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MasBnkTrfVO() {}

	public MasBnkTrfVO(String ibflag, String pagerows, String costYrmon, String slanCd, String rlaneCd, String slanDirCd, String vslClssCapa, String foilCsm, String foilUcAmt, String foilAmt, String doilCsm, String doilUcAmt, String doilAmt, String creUsrId, String creDt, String updUsrId, String updDt, String costWk, String trdCd, String subTrdCd, String foilAvgCsm, String wkEstmUcAmt, String wkAvgUcAmt, String oldFoilUcAmt) {
		this.updDt = updDt;
		this.oldFoilUcAmt = oldFoilUcAmt;
		this.slanDirCd = slanDirCd;
		this.foilAmt = foilAmt;
		this.wkAvgUcAmt = wkAvgUcAmt;
		this.foilAvgCsm = foilAvgCsm;
		this.creDt = creDt;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.slanCd = slanCd;
		this.foilCsm = foilCsm;
		this.foilUcAmt = foilUcAmt;
		this.costWk = costWk;
		this.doilUcAmt = doilUcAmt;
		this.vslClssCapa = vslClssCapa;
		this.doilAmt = doilAmt;
		this.wkEstmUcAmt = wkEstmUcAmt;
		this.doilCsm = doilCsm;
		this.subTrdCd = subTrdCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("old_foil_uc_amt", getOldFoilUcAmt());
		this.hashColumns.put("slan_dir_cd", getSlanDirCd());
		this.hashColumns.put("foil_amt", getFoilAmt());
		this.hashColumns.put("wk_avg_uc_amt", getWkAvgUcAmt());
		this.hashColumns.put("foil_avg_csm", getFoilAvgCsm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("foil_csm", getFoilCsm());
		this.hashColumns.put("foil_uc_amt", getFoilUcAmt());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("doil_uc_amt", getDoilUcAmt());
		this.hashColumns.put("vsl_clss_capa", getVslClssCapa());
		this.hashColumns.put("doil_amt", getDoilAmt());
		this.hashColumns.put("wk_estm_uc_amt", getWkEstmUcAmt());
		this.hashColumns.put("doil_csm", getDoilCsm());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("old_foil_uc_amt", "oldFoilUcAmt");
		this.hashFields.put("slan_dir_cd", "slanDirCd");
		this.hashFields.put("foil_amt", "foilAmt");
		this.hashFields.put("wk_avg_uc_amt", "wkAvgUcAmt");
		this.hashFields.put("foil_avg_csm", "foilAvgCsm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("foil_csm", "foilCsm");
		this.hashFields.put("foil_uc_amt", "foilUcAmt");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("doil_uc_amt", "doilUcAmt");
		this.hashFields.put("vsl_clss_capa", "vslClssCapa");
		this.hashFields.put("doil_amt", "doilAmt");
		this.hashFields.put("wk_estm_uc_amt", "wkEstmUcAmt");
		this.hashFields.put("doil_csm", "doilCsm");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
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
	 * @return oldFoilUcAmt
	 */
	public String getOldFoilUcAmt() {
		return this.oldFoilUcAmt;
	}
	
	/**
	 * Column Info
	 * @return slanDirCd
	 */
	public String getSlanDirCd() {
		return this.slanDirCd;
	}
	
	/**
	 * Column Info
	 * @return foilAmt
	 */
	public String getFoilAmt() {
		return this.foilAmt;
	}
	
	/**
	 * Column Info
	 * @return wkAvgUcAmt
	 */
	public String getWkAvgUcAmt() {
		return this.wkAvgUcAmt;
	}
	
	/**
	 * Column Info
	 * @return foilAvgCsm
	 */
	public String getFoilAvgCsm() {
		return this.foilAvgCsm;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return foilCsm
	 */
	public String getFoilCsm() {
		return this.foilCsm;
	}
	
	/**
	 * Column Info
	 * @return foilUcAmt
	 */
	public String getFoilUcAmt() {
		return this.foilUcAmt;
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
	 * @return doilUcAmt
	 */
	public String getDoilUcAmt() {
		return this.doilUcAmt;
	}
	
	/**
	 * Column Info
	 * @return vslClssCapa
	 */
	public String getVslClssCapa() {
		return this.vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @return doilAmt
	 */
	public String getDoilAmt() {
		return this.doilAmt;
	}
	
	/**
	 * Column Info
	 * @return wkEstmUcAmt
	 */
	public String getWkEstmUcAmt() {
		return this.wkEstmUcAmt;
	}
	
	/**
	 * Column Info
	 * @return doilCsm
	 */
	public String getDoilCsm() {
		return this.doilCsm;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param oldFoilUcAmt
	 */
	public void setOldFoilUcAmt(String oldFoilUcAmt) {
		this.oldFoilUcAmt = oldFoilUcAmt;
	}
	
	/**
	 * Column Info
	 * @param slanDirCd
	 */
	public void setSlanDirCd(String slanDirCd) {
		this.slanDirCd = slanDirCd;
	}
	
	/**
	 * Column Info
	 * @param foilAmt
	 */
	public void setFoilAmt(String foilAmt) {
		this.foilAmt = foilAmt;
	}
	
	/**
	 * Column Info
	 * @param wkAvgUcAmt
	 */
	public void setWkAvgUcAmt(String wkAvgUcAmt) {
		this.wkAvgUcAmt = wkAvgUcAmt;
	}
	
	/**
	 * Column Info
	 * @param foilAvgCsm
	 */
	public void setFoilAvgCsm(String foilAvgCsm) {
		this.foilAvgCsm = foilAvgCsm;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param foilCsm
	 */
	public void setFoilCsm(String foilCsm) {
		this.foilCsm = foilCsm;
	}
	
	/**
	 * Column Info
	 * @param foilUcAmt
	 */
	public void setFoilUcAmt(String foilUcAmt) {
		this.foilUcAmt = foilUcAmt;
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
	 * @param doilUcAmt
	 */
	public void setDoilUcAmt(String doilUcAmt) {
		this.doilUcAmt = doilUcAmt;
	}
	
	/**
	 * Column Info
	 * @param vslClssCapa
	 */
	public void setVslClssCapa(String vslClssCapa) {
		this.vslClssCapa = vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @param doilAmt
	 */
	public void setDoilAmt(String doilAmt) {
		this.doilAmt = doilAmt;
	}
	
	/**
	 * Column Info
	 * @param wkEstmUcAmt
	 */
	public void setWkEstmUcAmt(String wkEstmUcAmt) {
		this.wkEstmUcAmt = wkEstmUcAmt;
	}
	
	/**
	 * Column Info
	 * @param doilCsm
	 */
	public void setDoilCsm(String doilCsm) {
		this.doilCsm = doilCsm;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setOldFoilUcAmt(JSPUtil.getParameter(request, prefix + "old_foil_uc_amt", ""));
		setSlanDirCd(JSPUtil.getParameter(request, prefix + "slan_dir_cd", ""));
		setFoilAmt(JSPUtil.getParameter(request, prefix + "foil_amt", ""));
		setWkAvgUcAmt(JSPUtil.getParameter(request, prefix + "wk_avg_uc_amt", ""));
		setFoilAvgCsm(JSPUtil.getParameter(request, prefix + "foil_avg_csm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setFoilCsm(JSPUtil.getParameter(request, prefix + "foil_csm", ""));
		setFoilUcAmt(JSPUtil.getParameter(request, prefix + "foil_uc_amt", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setDoilUcAmt(JSPUtil.getParameter(request, prefix + "doil_uc_amt", ""));
		setVslClssCapa(JSPUtil.getParameter(request, prefix + "vsl_clss_capa", ""));
		setDoilAmt(JSPUtil.getParameter(request, prefix + "doil_amt", ""));
		setWkEstmUcAmt(JSPUtil.getParameter(request, prefix + "wk_estm_uc_amt", ""));
		setDoilCsm(JSPUtil.getParameter(request, prefix + "doil_csm", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MasBnkTrfVO[]
	 */
	public MasBnkTrfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MasBnkTrfVO[]
	 */
	public MasBnkTrfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MasBnkTrfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] oldFoilUcAmt = (JSPUtil.getParameter(request, prefix	+ "old_foil_uc_amt", length));
			String[] slanDirCd = (JSPUtil.getParameter(request, prefix	+ "slan_dir_cd", length));
			String[] foilAmt = (JSPUtil.getParameter(request, prefix	+ "foil_amt", length));
			String[] wkAvgUcAmt = (JSPUtil.getParameter(request, prefix	+ "wk_avg_uc_amt", length));
			String[] foilAvgCsm = (JSPUtil.getParameter(request, prefix	+ "foil_avg_csm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] foilCsm = (JSPUtil.getParameter(request, prefix	+ "foil_csm", length));
			String[] foilUcAmt = (JSPUtil.getParameter(request, prefix	+ "foil_uc_amt", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] doilUcAmt = (JSPUtil.getParameter(request, prefix	+ "doil_uc_amt", length));
			String[] vslClssCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_capa", length));
			String[] doilAmt = (JSPUtil.getParameter(request, prefix	+ "doil_amt", length));
			String[] wkEstmUcAmt = (JSPUtil.getParameter(request, prefix	+ "wk_estm_uc_amt", length));
			String[] doilCsm = (JSPUtil.getParameter(request, prefix	+ "doil_csm", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new MasBnkTrfVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (oldFoilUcAmt[i] != null)
					model.setOldFoilUcAmt(oldFoilUcAmt[i]);
				if (slanDirCd[i] != null)
					model.setSlanDirCd(slanDirCd[i]);
				if (foilAmt[i] != null)
					model.setFoilAmt(foilAmt[i]);
				if (wkAvgUcAmt[i] != null)
					model.setWkAvgUcAmt(wkAvgUcAmt[i]);
				if (foilAvgCsm[i] != null)
					model.setFoilAvgCsm(foilAvgCsm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (foilCsm[i] != null)
					model.setFoilCsm(foilCsm[i]);
				if (foilUcAmt[i] != null)
					model.setFoilUcAmt(foilUcAmt[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (doilUcAmt[i] != null)
					model.setDoilUcAmt(doilUcAmt[i]);
				if (vslClssCapa[i] != null)
					model.setVslClssCapa(vslClssCapa[i]);
				if (doilAmt[i] != null)
					model.setDoilAmt(doilAmt[i]);
				if (wkEstmUcAmt[i] != null)
					model.setWkEstmUcAmt(wkEstmUcAmt[i]);
				if (doilCsm[i] != null)
					model.setDoilCsm(doilCsm[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMasBnkTrfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MasBnkTrfVO[]
	 */
	public MasBnkTrfVO[] getMasBnkTrfVOs(){
		MasBnkTrfVO[] vos = (MasBnkTrfVO[])models.toArray(new MasBnkTrfVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldFoilUcAmt = this.oldFoilUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanDirCd = this.slanDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilAmt = this.foilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkAvgUcAmt = this.wkAvgUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilAvgCsm = this.foilAvgCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilCsm = this.foilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilUcAmt = this.foilUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilUcAmt = this.doilUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCapa = this.vslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilAmt = this.doilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkEstmUcAmt = this.wkEstmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilCsm = this.doilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
