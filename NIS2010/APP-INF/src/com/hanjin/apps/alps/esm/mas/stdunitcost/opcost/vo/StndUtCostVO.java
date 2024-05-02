/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StndUtCostVO.java
*@FileTitle : StndUtCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.19
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.01.19 김종옥 
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

public class StndUtCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<StndUtCostVO> models = new ArrayList<StndUtCostVO>();
	
	/* Column Info */
	private String dayCostAmt = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String fnlTtlAmt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String teuUcAmt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String costYrQtr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYr = null;
	/* Column Info */
	private String tgtLodQty = null;
	/* Column Info */
	private String costQtrCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String effYrmon = null;
	/* Column Info */
	private String stndCostCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public StndUtCostVO() {}

	public StndUtCostVO(String ibflag, String pagerows, String costYrQtr, String costYr, String costQtrCd, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String hulBndCd, String effYrmon, String ttlAmt, String fnlTtlAmt, String dayCostAmt, String tgtLodQty, String teuUcAmt, String stndCostCd, String updUsrId) {
		this.dayCostAmt = dayCostAmt;
		this.hulBndCd = hulBndCd;
		this.fnlTtlAmt = fnlTtlAmt;
		this.trdCd = trdCd;
		this.teuUcAmt = teuUcAmt;
		this.rlaneCd = rlaneCd;
		this.ttlAmt = ttlAmt;
		this.pagerows = pagerows;
		this.costYrQtr = costYrQtr;
		this.ibflag = ibflag;
		this.costYr = costYr;
		this.tgtLodQty = tgtLodQty;
		this.costQtrCd = costQtrCd;
		this.dirCd = dirCd;
		this.updUsrId = updUsrId;
		this.subTrdCd = subTrdCd;
		this.effYrmon = effYrmon;
		this.stndCostCd = stndCostCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("day_cost_amt", getDayCostAmt());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("fnl_ttl_amt", getFnlTtlAmt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("teu_uc_amt", getTeuUcAmt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cost_yr_qtr", getCostYrQtr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yr", getCostYr());
		this.hashColumns.put("tgt_lod_qty", getTgtLodQty());
		this.hashColumns.put("cost_qtr_cd", getCostQtrCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("eff_yrmon", getEffYrmon());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("day_cost_amt", "dayCostAmt");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("fnl_ttl_amt", "fnlTtlAmt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("teu_uc_amt", "teuUcAmt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cost_yr_qtr", "costYrQtr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yr", "costYr");
		this.hashFields.put("tgt_lod_qty", "tgtLodQty");
		this.hashFields.put("cost_qtr_cd", "costQtrCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("eff_yrmon", "effYrmon");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dayCostAmt
	 */
	public String getDayCostAmt() {
		return this.dayCostAmt;
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
	 * @return fnlTtlAmt
	 */
	public String getFnlTtlAmt() {
		return this.fnlTtlAmt;
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
	 * @return teuUcAmt
	 */
	public String getTeuUcAmt() {
		return this.teuUcAmt;
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
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
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
	 * @return costYrQtr
	 */
	public String getCostYrQtr() {
		return this.costYrQtr;
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
	 * @return costYr
	 */
	public String getCostYr() {
		return this.costYr;
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
	 * @return costQtrCd
	 */
	public String getCostQtrCd() {
		return this.costQtrCd;
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
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
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
	 * @return stndCostCd
	 */
	public String getStndCostCd() {
		return this.stndCostCd;
	}
	

	/**
	 * Column Info
	 * @param dayCostAmt
	 */
	public void setDayCostAmt(String dayCostAmt) {
		this.dayCostAmt = dayCostAmt;
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
	 * @param fnlTtlAmt
	 */
	public void setFnlTtlAmt(String fnlTtlAmt) {
		this.fnlTtlAmt = fnlTtlAmt;
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
	 * @param teuUcAmt
	 */
	public void setTeuUcAmt(String teuUcAmt) {
		this.teuUcAmt = teuUcAmt;
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
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
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
	 * @param costYrQtr
	 */
	public void setCostYrQtr(String costYrQtr) {
		this.costYrQtr = costYrQtr;
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
	 * @param costYr
	 */
	public void setCostYr(String costYr) {
		this.costYr = costYr;
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
	 * @param costQtrCd
	 */
	public void setCostQtrCd(String costQtrCd) {
		this.costQtrCd = costQtrCd;
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
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
	 * @param stndCostCd
	 */
	public void setStndCostCd(String stndCostCd) {
		this.stndCostCd = stndCostCd;
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
		setDayCostAmt(JSPUtil.getParameter(request, prefix + "day_cost_amt", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setFnlTtlAmt(JSPUtil.getParameter(request, prefix + "fnl_ttl_amt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setTeuUcAmt(JSPUtil.getParameter(request, prefix + "teu_uc_amt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCostYrQtr(JSPUtil.getParameter(request, prefix + "cost_yr_qtr", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYr(JSPUtil.getParameter(request, prefix + "cost_yr", ""));
		setTgtLodQty(JSPUtil.getParameter(request, prefix + "tgt_lod_qty", ""));
		setCostQtrCd(JSPUtil.getParameter(request, prefix + "cost_qtr_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setEffYrmon(JSPUtil.getParameter(request, prefix + "eff_yrmon", ""));
		setStndCostCd(JSPUtil.getParameter(request, prefix + "stnd_cost_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StndUtCostVO[]
	 */
	public StndUtCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StndUtCostVO[]
	 */
	public StndUtCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StndUtCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dayCostAmt = (JSPUtil.getParameter(request, prefix	+ "day_cost_amt", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] fnlTtlAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_ttl_amt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] teuUcAmt = (JSPUtil.getParameter(request, prefix	+ "teu_uc_amt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] costYrQtr = (JSPUtil.getParameter(request, prefix	+ "cost_yr_qtr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYr = (JSPUtil.getParameter(request, prefix	+ "cost_yr", length));
			String[] tgtLodQty = (JSPUtil.getParameter(request, prefix	+ "tgt_lod_qty", length));
			String[] costQtrCd = (JSPUtil.getParameter(request, prefix	+ "cost_qtr_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] effYrmon = (JSPUtil.getParameter(request, prefix	+ "eff_yrmon", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new StndUtCostVO();
				if (dayCostAmt[i] != null)
					model.setDayCostAmt(dayCostAmt[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (fnlTtlAmt[i] != null)
					model.setFnlTtlAmt(fnlTtlAmt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (teuUcAmt[i] != null)
					model.setTeuUcAmt(teuUcAmt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (costYrQtr[i] != null)
					model.setCostYrQtr(costYrQtr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYr[i] != null)
					model.setCostYr(costYr[i]);
				if (tgtLodQty[i] != null)
					model.setTgtLodQty(tgtLodQty[i]);
				if (costQtrCd[i] != null)
					model.setCostQtrCd(costQtrCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (effYrmon[i] != null)
					model.setEffYrmon(effYrmon[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStndUtCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return StndUtCostVO[]
	 */
	public StndUtCostVO[] getStndUtCostVOs(){
		StndUtCostVO[] vos = (StndUtCostVO[])models.toArray(new StndUtCostVO[models.size()]);
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
		this.dayCostAmt = this.dayCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlTtlAmt = this.fnlTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuUcAmt = this.teuUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrQtr = this.costYrQtr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYr = this.costYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tgtLodQty = this.tgtLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costQtrCd = this.costQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effYrmon = this.effYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
