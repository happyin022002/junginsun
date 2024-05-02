/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AverageUCVesselUtVO.java
*@FileTitle : AverageUCVesselUtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.20
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.04.20 유제량 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo;

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
 * @author 유제량
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AverageUCVesselUtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AverageUCVesselUtVO> models = new ArrayList<AverageUCVesselUtVO>();
	
	/* Column Info */
	private String fYearweek = null;
	/* Column Info */
	private String insAmt = null;
	/* Column Info */
	private String lubAmt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String sprAmt = null;
	/* Column Info */
	private String canAmt = null;
	/* Column Info */
	private String teuUcAmt = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String telAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String bnkAmt = null;
	/* Column Info */
	private String creAmt = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String stndCostCd = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String depAmt = null;
	/* Column Info */
	private String stoAmt = null;
	/* Column Info */
	private String otrAmt = null;
	/* Column Info */
	private String mnrAmt = null;
	/* Column Info */
	private String porAmt = null;
	/* Column Info */
	private String spcAmt = null;
	/* Column Info */
	private String tgtLodQty = null;
	/* Column Info */
	private String vslAmt = null;
	/* Column Info */
	private String timAmt = null;
	/* Column Info */
	private String effYrmon = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AverageUCVesselUtVO() {}

	public AverageUCVesselUtVO(String ibflag, String pagerows, String hulBndCd, String trdCd, String rlaneCd, String ttlAmt, String teuUcAmt, String costYrmon, String tgtLodQty, String dirCd, String creUsrId, String updUsrId, String subTrdCd, String effYrmon, String stndCostCd, String creAmt, String insAmt, String stoAmt, String lubAmt, String mnrAmt, String depAmt, String telAmt, String vslAmt, String otrAmt, String timAmt, String porAmt, String canAmt, String bnkAmt, String spcAmt, String sprAmt, String fYearweek) {
		this.fYearweek = fYearweek;
		this.insAmt = insAmt;
		this.lubAmt = lubAmt;
		this.trdCd = trdCd;
		this.sprAmt = sprAmt;
		this.canAmt = canAmt;
		this.teuUcAmt = teuUcAmt;
		this.ttlAmt = ttlAmt;
		this.rlaneCd = rlaneCd;
		this.telAmt = telAmt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.bnkAmt = bnkAmt;
		this.creAmt = creAmt;
		this.dirCd = dirCd;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.stndCostCd = stndCostCd;
		this.hulBndCd = hulBndCd;
		this.depAmt = depAmt;
		this.stoAmt = stoAmt;
		this.otrAmt = otrAmt;
		this.mnrAmt = mnrAmt;
		this.porAmt = porAmt;
		this.spcAmt = spcAmt;
		this.tgtLodQty = tgtLodQty;
		this.vslAmt = vslAmt;
		this.timAmt = timAmt;
		this.effYrmon = effYrmon;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_yearweek", getFYearweek());
		this.hashColumns.put("ins_amt", getInsAmt());
		this.hashColumns.put("lub_amt", getLubAmt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("spr_amt", getSprAmt());
		this.hashColumns.put("can_amt", getCanAmt());
		this.hashColumns.put("teu_uc_amt", getTeuUcAmt());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("tel_amt", getTelAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("bnk_amt", getBnkAmt());
		this.hashColumns.put("cre_amt", getCreAmt());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("dep_amt", getDepAmt());
		this.hashColumns.put("sto_amt", getStoAmt());
		this.hashColumns.put("otr_amt", getOtrAmt());
		this.hashColumns.put("mnr_amt", getMnrAmt());
		this.hashColumns.put("por_amt", getPorAmt());
		this.hashColumns.put("spc_amt", getSpcAmt());
		this.hashColumns.put("tgt_lod_qty", getTgtLodQty());
		this.hashColumns.put("vsl_amt", getVslAmt());
		this.hashColumns.put("tim_amt", getTimAmt());
		this.hashColumns.put("eff_yrmon", getEffYrmon());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_yearweek", "fYearweek");
		this.hashFields.put("ins_amt", "insAmt");
		this.hashFields.put("lub_amt", "lubAmt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("spr_amt", "sprAmt");
		this.hashFields.put("can_amt", "canAmt");
		this.hashFields.put("teu_uc_amt", "teuUcAmt");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("tel_amt", "telAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("bnk_amt", "bnkAmt");
		this.hashFields.put("cre_amt", "creAmt");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("dep_amt", "depAmt");
		this.hashFields.put("sto_amt", "stoAmt");
		this.hashFields.put("otr_amt", "otrAmt");
		this.hashFields.put("mnr_amt", "mnrAmt");
		this.hashFields.put("por_amt", "porAmt");
		this.hashFields.put("spc_amt", "spcAmt");
		this.hashFields.put("tgt_lod_qty", "tgtLodQty");
		this.hashFields.put("vsl_amt", "vslAmt");
		this.hashFields.put("tim_amt", "timAmt");
		this.hashFields.put("eff_yrmon", "effYrmon");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fYearweek
	 */
	public String getFYearweek() {
		return this.fYearweek;
	}
	
	/**
	 * Column Info
	 * @return insAmt
	 */
	public String getInsAmt() {
		return this.insAmt;
	}
	
	/**
	 * Column Info
	 * @return lubAmt
	 */
	public String getLubAmt() {
		return this.lubAmt;
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
	 * @return sprAmt
	 */
	public String getSprAmt() {
		return this.sprAmt;
	}
	
	/**
	 * Column Info
	 * @return canAmt
	 */
	public String getCanAmt() {
		return this.canAmt;
	}
	
	/**
	 * Column Info
	 * @return teuUcAmt
	 */
	public String getTeuUcAmt() {
		return this.teuUcAmt;
	}
	
	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return telAmt
	 */
	public String getTelAmt() {
		return this.telAmt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return bnkAmt
	 */
	public String getBnkAmt() {
		return this.bnkAmt;
	}
	
	/**
	 * Column Info
	 * @return creAmt
	 */
	public String getCreAmt() {
		return this.creAmt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return stndCostCd
	 */
	public String getStndCostCd() {
		return this.stndCostCd;
	}

	/**
	 * Column Info
	 * @return hulBndCd
	 */
	public String getHulBndCd() {
		return this.hulBndCd;
	}
	
	/**
	 * Column Info
	 * @return depAmt
	 */
	public String getDepAmt() {
		return this.depAmt;
	}
	
	/**
	 * Column Info
	 * @return stoAmt
	 */
	public String getStoAmt() {
		return this.stoAmt;
	}
	
	/**
	 * Column Info
	 * @return otrAmt
	 */
	public String getOtrAmt() {
		return this.otrAmt;
	}
	
	/**
	 * Column Info
	 * @return mnrAmt
	 */
	public String getMnrAmt() {
		return this.mnrAmt;
	}
	
	/**
	 * Column Info
	 * @return porAmt
	 */
	public String getPorAmt() {
		return this.porAmt;
	}
	
	/**
	 * Column Info
	 * @return spcAmt
	 */
	public String getSpcAmt() {
		return this.spcAmt;
	}
	
	/**
	 * Column Info
	 * @return tgtLodQty
	 */
	public String getTgtLodQty() {
		return this.tgtLodQty;
	}
	
	/**
	 * Column Info
	 * @return vslAmt
	 */
	public String getVslAmt() {
		return this.vslAmt;
	}
	
	/**
	 * Column Info
	 * @return timAmt
	 */
	public String getTimAmt() {
		return this.timAmt;
	}
	
	/**
	 * Column Info
	 * @return effYrmon
	 */
	public String getEffYrmon() {
		return this.effYrmon;
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
	 * @param fYearweek
	 */
	public void setFYearweek(String fYearweek) {
		this.fYearweek = fYearweek;
	}
	
	/**
	 * Column Info
	 * @param insAmt
	 */
	public void setInsAmt(String insAmt) {
		this.insAmt = insAmt;
	}
	
	/**
	 * Column Info
	 * @param lubAmt
	 */
	public void setLubAmt(String lubAmt) {
		this.lubAmt = lubAmt;
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
	 * @param sprAmt
	 */
	public void setSprAmt(String sprAmt) {
		this.sprAmt = sprAmt;
	}
	
	/**
	 * Column Info
	 * @param canAmt
	 */
	public void setCanAmt(String canAmt) {
		this.canAmt = canAmt;
	}
	
	/**
	 * Column Info
	 * @param teuUcAmt
	 */
	public void setTeuUcAmt(String teuUcAmt) {
		this.teuUcAmt = teuUcAmt;
	}
	
	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param telAmt
	 */
	public void setTelAmt(String telAmt) {
		this.telAmt = telAmt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param bnkAmt
	 */
	public void setBnkAmt(String bnkAmt) {
		this.bnkAmt = bnkAmt;
	}
	
	/**
	 * Column Info
	 * @param creAmt
	 */
	public void setCreAmt(String creAmt) {
		this.creAmt = creAmt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param stndCostCd
	 */
	public void setStndCostCd(String stndCostCd) {
		this.stndCostCd = stndCostCd;
	}

	/**
	 * Column Info
	 * @param hulBndCd
	 */
	public void setHulBndCd(String hulBndCd) {
		this.hulBndCd = hulBndCd;
	}
	
	/**
	 * Column Info
	 * @param depAmt
	 */
	public void setDepAmt(String depAmt) {
		this.depAmt = depAmt;
	}
	
	/**
	 * Column Info
	 * @param stoAmt
	 */
	public void setStoAmt(String stoAmt) {
		this.stoAmt = stoAmt;
	}
	
	/**
	 * Column Info
	 * @param otrAmt
	 */
	public void setOtrAmt(String otrAmt) {
		this.otrAmt = otrAmt;
	}
	
	/**
	 * Column Info
	 * @param mnrAmt
	 */
	public void setMnrAmt(String mnrAmt) {
		this.mnrAmt = mnrAmt;
	}
	
	/**
	 * Column Info
	 * @param porAmt
	 */
	public void setPorAmt(String porAmt) {
		this.porAmt = porAmt;
	}
	
	/**
	 * Column Info
	 * @param spcAmt
	 */
	public void setSpcAmt(String spcAmt) {
		this.spcAmt = spcAmt;
	}
	
	/**
	 * Column Info
	 * @param tgtLodQty
	 */
	public void setTgtLodQty(String tgtLodQty) {
		this.tgtLodQty = tgtLodQty;
	}
	
	/**
	 * Column Info
	 * @param vslAmt
	 */
	public void setVslAmt(String vslAmt) {
		this.vslAmt = vslAmt;
	}
	
	/**
	 * Column Info
	 * @param timAmt
	 */
	public void setTimAmt(String timAmt) {
		this.timAmt = timAmt;
	}
	
	/**
	 * Column Info
	 * @param effYrmon
	 */
	public void setEffYrmon(String effYrmon) {
		this.effYrmon = effYrmon;
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
		setFYearweek(JSPUtil.getParameter(request, prefix + "f_yearweek", ""));
		setInsAmt(JSPUtil.getParameter(request, prefix + "ins_amt", ""));
		setLubAmt(JSPUtil.getParameter(request, prefix + "lub_amt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setSprAmt(JSPUtil.getParameter(request, prefix + "spr_amt", ""));
		setCanAmt(JSPUtil.getParameter(request, prefix + "can_amt", ""));
		setTeuUcAmt(JSPUtil.getParameter(request, prefix + "teu_uc_amt", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setTelAmt(JSPUtil.getParameter(request, prefix + "tel_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setBnkAmt(JSPUtil.getParameter(request, prefix + "bnk_amt", ""));
		setCreAmt(JSPUtil.getParameter(request, prefix + "cre_amt", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setStndCostCd(JSPUtil.getParameter(request, prefix + "stnd_cost_cd", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setDepAmt(JSPUtil.getParameter(request, prefix + "dep_amt", ""));
		setStoAmt(JSPUtil.getParameter(request, prefix + "sto_amt", ""));
		setOtrAmt(JSPUtil.getParameter(request, prefix + "otr_amt", ""));
		setMnrAmt(JSPUtil.getParameter(request, prefix + "mnr_amt", ""));
		setPorAmt(JSPUtil.getParameter(request, prefix + "por_amt", ""));
		setSpcAmt(JSPUtil.getParameter(request, prefix + "spc_amt", ""));
		setTgtLodQty(JSPUtil.getParameter(request, prefix + "tgt_lod_qty", ""));
		setVslAmt(JSPUtil.getParameter(request, prefix + "vsl_amt", ""));
		setTimAmt(JSPUtil.getParameter(request, prefix + "tim_amt", ""));
		setEffYrmon(JSPUtil.getParameter(request, prefix + "eff_yrmon", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AverageUCVesselUtVO[]
	 */
	public AverageUCVesselUtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AverageUCVesselUtVO[]
	 */
	public AverageUCVesselUtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AverageUCVesselUtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fYearweek = (JSPUtil.getParameter(request, prefix	+ "f_yearweek", length));
			String[] insAmt = (JSPUtil.getParameter(request, prefix	+ "ins_amt", length));
			String[] lubAmt = (JSPUtil.getParameter(request, prefix	+ "lub_amt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] sprAmt = (JSPUtil.getParameter(request, prefix	+ "spr_amt", length));
			String[] canAmt = (JSPUtil.getParameter(request, prefix	+ "can_amt", length));
			String[] teuUcAmt = (JSPUtil.getParameter(request, prefix	+ "teu_uc_amt", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] telAmt = (JSPUtil.getParameter(request, prefix	+ "tel_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] bnkAmt = (JSPUtil.getParameter(request, prefix	+ "bnk_amt", length));
			String[] creAmt = (JSPUtil.getParameter(request, prefix	+ "cre_amt", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] depAmt = (JSPUtil.getParameter(request, prefix	+ "dep_amt", length));
			String[] stoAmt = (JSPUtil.getParameter(request, prefix	+ "sto_amt", length));
			String[] otrAmt = (JSPUtil.getParameter(request, prefix	+ "otr_amt", length));
			String[] mnrAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_amt", length));
			String[] porAmt = (JSPUtil.getParameter(request, prefix	+ "por_amt", length));
			String[] spcAmt = (JSPUtil.getParameter(request, prefix	+ "spc_amt", length));
			String[] tgtLodQty = (JSPUtil.getParameter(request, prefix	+ "tgt_lod_qty", length));
			String[] vslAmt = (JSPUtil.getParameter(request, prefix	+ "vsl_amt", length));
			String[] timAmt = (JSPUtil.getParameter(request, prefix	+ "tim_amt", length));
			String[] effYrmon = (JSPUtil.getParameter(request, prefix	+ "eff_yrmon", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AverageUCVesselUtVO();
				if (fYearweek[i] != null)
					model.setFYearweek(fYearweek[i]);
				if (insAmt[i] != null)
					model.setInsAmt(insAmt[i]);
				if (lubAmt[i] != null)
					model.setLubAmt(lubAmt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (sprAmt[i] != null)
					model.setSprAmt(sprAmt[i]);
				if (canAmt[i] != null)
					model.setCanAmt(canAmt[i]);
				if (teuUcAmt[i] != null)
					model.setTeuUcAmt(teuUcAmt[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (telAmt[i] != null)
					model.setTelAmt(telAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (bnkAmt[i] != null)
					model.setBnkAmt(bnkAmt[i]);
				if (creAmt[i] != null)
					model.setCreAmt(creAmt[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (depAmt[i] != null)
					model.setDepAmt(depAmt[i]);
				if (stoAmt[i] != null)
					model.setStoAmt(stoAmt[i]);
				if (otrAmt[i] != null)
					model.setOtrAmt(otrAmt[i]);
				if (mnrAmt[i] != null)
					model.setMnrAmt(mnrAmt[i]);
				if (porAmt[i] != null)
					model.setPorAmt(porAmt[i]);
				if (spcAmt[i] != null)
					model.setSpcAmt(spcAmt[i]);
				if (tgtLodQty[i] != null)
					model.setTgtLodQty(tgtLodQty[i]);
				if (vslAmt[i] != null)
					model.setVslAmt(vslAmt[i]);
				if (timAmt[i] != null)
					model.setTimAmt(timAmt[i]);
				if (effYrmon[i] != null)
					model.setEffYrmon(effYrmon[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAverageUCVesselUtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AverageUCVesselUtVO[]
	 */
	public AverageUCVesselUtVO[] getAverageUCVesselUtVOs(){
		AverageUCVesselUtVO[] vos = (AverageUCVesselUtVO[])models.toArray(new AverageUCVesselUtVO[models.size()]);
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
		this.fYearweek = this.fYearweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insAmt = this.insAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lubAmt = this.lubAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprAmt = this.sprAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.canAmt = this.canAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuUcAmt = this.teuUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.telAmt = this.telAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkAmt = this.bnkAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creAmt = this.creAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depAmt = this.depAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoAmt = this.stoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrAmt = this.otrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrAmt = this.mnrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porAmt = this.porAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcAmt = this.spcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tgtLodQty = this.tgtLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslAmt = this.vslAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.timAmt = this.timAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effYrmon = this.effYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
