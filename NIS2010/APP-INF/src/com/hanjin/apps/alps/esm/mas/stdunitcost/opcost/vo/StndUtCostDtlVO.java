/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StndUtCostDtlVO.java
*@FileTitle : StndUtCostDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.01.05 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.vo;

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

public class StndUtCostDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<StndUtCostDtlVO> models = new ArrayList<StndUtCostDtlVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String fnlTtlAmt = null;
	/* Column Info */
	private String ownSlsRto = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String teuUcAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String vslTp = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String stndCostCd = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String dhirAmt = null;
	/* Column Info */
	private String rlaneDir = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String tgtLodQty = null;
	/* Column Info */
	private String ttlTzDys = null;
	/* Column Info */
	private String vvdBsaCapa = null;
	/* Column Info */
	private String effYrmon = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public StndUtCostDtlVO() {}

	public StndUtCostDtlVO(String ibflag, String pagerows, String costYrmon, String costWk, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String rlaneDir, String hulBndCd, String vvd, String effYrmon, String ttlAmt, String ownSlsRto, String fnlTtlAmt, String tgtLodQty, String teuUcAmt, String vvdBsaCapa, String dhirAmt, String vslCd, String skdVoyNo, String stndCostCd, String updUsrId, String ttlTzDys, String vslTp) {
		this.vslCd = vslCd;
		this.fnlTtlAmt = fnlTtlAmt;
		this.ownSlsRto = ownSlsRto;
		this.trdCd = trdCd;
		this.ttlAmt = ttlAmt;
		this.rlaneCd = rlaneCd;
		this.teuUcAmt = teuUcAmt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.vslTp = vslTp;
		this.dirCd = dirCd;
		this.updUsrId = updUsrId;
		this.stndCostCd = stndCostCd;
		this.hulBndCd = hulBndCd;
		this.skdVoyNo = skdVoyNo;
		this.vvd = vvd;
		this.dhirAmt = dhirAmt;
		this.rlaneDir = rlaneDir;
		this.costWk = costWk;
		this.tgtLodQty = tgtLodQty;
		this.ttlTzDys = ttlTzDys;
		this.vvdBsaCapa = vvdBsaCapa;
		this.effYrmon = effYrmon;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("fnl_ttl_amt", getFnlTtlAmt());
		this.hashColumns.put("own_sls_rto", getOwnSlsRto());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("teu_uc_amt", getTeuUcAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("vsl_tp", getVslTp());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("dhir_amt", getDhirAmt());
		this.hashColumns.put("rlane_dir", getRlaneDir());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("tgt_lod_qty", getTgtLodQty());
		this.hashColumns.put("ttl_tz_dys", getTtlTzDys());
		this.hashColumns.put("vvd_bsa_capa", getVvdBsaCapa());
		this.hashColumns.put("eff_yrmon", getEffYrmon());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("fnl_ttl_amt", "fnlTtlAmt");
		this.hashFields.put("own_sls_rto", "ownSlsRto");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("teu_uc_amt", "teuUcAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("vsl_tp", "vslTp");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("dhir_amt", "dhirAmt");
		this.hashFields.put("rlane_dir", "rlaneDir");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("tgt_lod_qty", "tgtLodQty");
		this.hashFields.put("ttl_tz_dys", "ttlTzDys");
		this.hashFields.put("vvd_bsa_capa", "vvdBsaCapa");
		this.hashFields.put("eff_yrmon", "effYrmon");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
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
	 * @return fnlTtlAmt
	 */
	public String getFnlTtlAmt() {
		return this.fnlTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return ownSlsRto
	 */
	public String getOwnSlsRto() {
		return this.ownSlsRto;
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
	 * @return teuUcAmt
	 */
	public String getTeuUcAmt() {
		return this.teuUcAmt;
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
	 * @return vslTp
	 */
	public String getVslTp() {
		return this.vslTp;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
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
	 * @return dhirAmt
	 */
	public String getDhirAmt() {
		return this.dhirAmt;
	}
	
	/**
	 * Column Info
	 * @return rlaneDir
	 */
	public String getRlaneDir() {
		return this.rlaneDir;
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
	 * @return tgtLodQty
	 */
	public String getTgtLodQty() {
		return this.tgtLodQty;
	}
	
	/**
	 * Column Info
	 * @return ttlTzDys
	 */
	public String getTtlTzDys() {
		return this.ttlTzDys;
	}
	
	/**
	 * Column Info
	 * @return vvdBsaCapa
	 */
	public String getVvdBsaCapa() {
		return this.vvdBsaCapa;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param fnlTtlAmt
	 */
	public void setFnlTtlAmt(String fnlTtlAmt) {
		this.fnlTtlAmt = fnlTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param ownSlsRto
	 */
	public void setOwnSlsRto(String ownSlsRto) {
		this.ownSlsRto = ownSlsRto;
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
	 * @param teuUcAmt
	 */
	public void setTeuUcAmt(String teuUcAmt) {
		this.teuUcAmt = teuUcAmt;
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
	 * @param vslTp
	 */
	public void setVslTp(String vslTp) {
		this.vslTp = vslTp;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param dhirAmt
	 */
	public void setDhirAmt(String dhirAmt) {
		this.dhirAmt = dhirAmt;
	}
	
	/**
	 * Column Info
	 * @param rlaneDir
	 */
	public void setRlaneDir(String rlaneDir) {
		this.rlaneDir = rlaneDir;
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
	 * @param tgtLodQty
	 */
	public void setTgtLodQty(String tgtLodQty) {
		this.tgtLodQty = tgtLodQty;
	}
	
	/**
	 * Column Info
	 * @param ttlTzDys
	 */
	public void setTtlTzDys(String ttlTzDys) {
		this.ttlTzDys = ttlTzDys;
	}
	
	/**
	 * Column Info
	 * @param vvdBsaCapa
	 */
	public void setVvdBsaCapa(String vvdBsaCapa) {
		this.vvdBsaCapa = vvdBsaCapa;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setFnlTtlAmt(JSPUtil.getParameter(request, prefix + "fnl_ttl_amt", ""));
		setOwnSlsRto(JSPUtil.getParameter(request, prefix + "own_sls_rto", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setTeuUcAmt(JSPUtil.getParameter(request, prefix + "teu_uc_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setVslTp(JSPUtil.getParameter(request, prefix + "vsl_tp", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setStndCostCd(JSPUtil.getParameter(request, prefix + "stnd_cost_cd", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setDhirAmt(JSPUtil.getParameter(request, prefix + "dhir_amt", ""));
		setRlaneDir(JSPUtil.getParameter(request, prefix + "rlane_dir", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setTgtLodQty(JSPUtil.getParameter(request, prefix + "tgt_lod_qty", ""));
		setTtlTzDys(JSPUtil.getParameter(request, prefix + "ttl_tz_dys", ""));
		setVvdBsaCapa(JSPUtil.getParameter(request, prefix + "vvd_bsa_capa", ""));
		setEffYrmon(JSPUtil.getParameter(request, prefix + "eff_yrmon", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StndUtCostDtlVO[]
	 */
	public StndUtCostDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StndUtCostDtlVO[]
	 */
	public StndUtCostDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StndUtCostDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] fnlTtlAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_ttl_amt", length));
			String[] ownSlsRto = (JSPUtil.getParameter(request, prefix	+ "own_sls_rto", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] teuUcAmt = (JSPUtil.getParameter(request, prefix	+ "teu_uc_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] vslTp = (JSPUtil.getParameter(request, prefix	+ "vsl_tp", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] dhirAmt = (JSPUtil.getParameter(request, prefix	+ "dhir_amt", length));
			String[] rlaneDir = (JSPUtil.getParameter(request, prefix	+ "rlane_dir", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] tgtLodQty = (JSPUtil.getParameter(request, prefix	+ "tgt_lod_qty", length));
			String[] ttlTzDys = (JSPUtil.getParameter(request, prefix	+ "ttl_tz_dys", length));
			String[] vvdBsaCapa = (JSPUtil.getParameter(request, prefix	+ "vvd_bsa_capa", length));
			String[] effYrmon = (JSPUtil.getParameter(request, prefix	+ "eff_yrmon", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new StndUtCostDtlVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (fnlTtlAmt[i] != null)
					model.setFnlTtlAmt(fnlTtlAmt[i]);
				if (ownSlsRto[i] != null)
					model.setOwnSlsRto(ownSlsRto[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (teuUcAmt[i] != null)
					model.setTeuUcAmt(teuUcAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (vslTp[i] != null)
					model.setVslTp(vslTp[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (dhirAmt[i] != null)
					model.setDhirAmt(dhirAmt[i]);
				if (rlaneDir[i] != null)
					model.setRlaneDir(rlaneDir[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (tgtLodQty[i] != null)
					model.setTgtLodQty(tgtLodQty[i]);
				if (ttlTzDys[i] != null)
					model.setTtlTzDys(ttlTzDys[i]);
				if (vvdBsaCapa[i] != null)
					model.setVvdBsaCapa(vvdBsaCapa[i]);
				if (effYrmon[i] != null)
					model.setEffYrmon(effYrmon[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStndUtCostDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return StndUtCostDtlVO[]
	 */
	public StndUtCostDtlVO[] getStndUtCostDtlVOs(){
		StndUtCostDtlVO[] vos = (StndUtCostDtlVO[])models.toArray(new StndUtCostDtlVO[models.size()]);
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
		this.fnlTtlAmt = this.fnlTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownSlsRto = this.ownSlsRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuUcAmt = this.teuUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslTp = this.vslTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dhirAmt = this.dhirAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneDir = this.rlaneDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tgtLodQty = this.tgtLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTzDys = this.ttlTzDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdBsaCapa = this.vvdBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effYrmon = this.effYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
