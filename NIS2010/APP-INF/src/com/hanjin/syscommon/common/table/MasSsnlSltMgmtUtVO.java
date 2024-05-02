/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MasSsnlSltMgmtUtVO.java
*@FileTitle : MasSsnlSltMgmtUtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.29
*@LastModifier : 김성훈
*@LastVersion : 1.0
* 2012.05.29 김성훈 
* 1.0 Creation
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
 * @author 김성훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class MasSsnlSltMgmtUtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MasSsnlSltMgmtUtVO> models = new ArrayList<MasSsnlSltMgmtUtVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vopVarFxAmt = null;
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String ssnlDiffAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String plcyPrcUtAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String vslSlanDirCd = null;
	/* Column Info */
	private String cmCostAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MasSsnlSltMgmtUtVO() {}

	public MasSsnlSltMgmtUtVO(String ibflag, String pagerows, String costYrmon, String trdCd, String rlaneCd, String vslSlanDirCd, String subTrdCd, String vopVarFxAmt, String cmCostAmt, String lodQty, String plcyPrcUtAmt, String ssnlDiffAmt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.vopVarFxAmt = vopVarFxAmt;
		this.lodQty = lodQty;
		this.ssnlDiffAmt = ssnlDiffAmt;
		this.creDt = creDt;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.plcyPrcUtAmt = plcyPrcUtAmt;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.costYrmon = costYrmon;
		this.vslSlanDirCd = vslSlanDirCd;
		this.cmCostAmt = cmCostAmt;
		this.updUsrId = updUsrId;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vop_var_fx_amt", getVopVarFxAmt());
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("ssnl_diff_amt", getSsnlDiffAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("plcy_prc_ut_amt", getPlcyPrcUtAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("vsl_slan_dir_cd", getVslSlanDirCd());
		this.hashColumns.put("cm_cost_amt", getCmCostAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vop_var_fx_amt", "vopVarFxAmt");
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("ssnl_diff_amt", "ssnlDiffAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("plcy_prc_ut_amt", "plcyPrcUtAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("vsl_slan_dir_cd", "vslSlanDirCd");
		this.hashFields.put("cm_cost_amt", "cmCostAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
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
	 * @return vopVarFxAmt
	 */
	public String getVopVarFxAmt() {
		return this.vopVarFxAmt;
	}
	
	/**
	 * Column Info
	 * @return lodQty
	 */
	public String getLodQty() {
		return this.lodQty;
	}
	
	/**
	 * Column Info
	 * @return ssnlDiffAmt
	 */
	public String getSsnlDiffAmt() {
		return this.ssnlDiffAmt;
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
	 * @return plcyPrcUtAmt
	 */
	public String getPlcyPrcUtAmt() {
		return this.plcyPrcUtAmt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return vslSlanDirCd
	 */
	public String getVslSlanDirCd() {
		return this.vslSlanDirCd;
	}
	
	/**
	 * Column Info
	 * @return cmCostAmt
	 */
	public String getCmCostAmt() {
		return this.cmCostAmt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param vopVarFxAmt
	 */
	public void setVopVarFxAmt(String vopVarFxAmt) {
		this.vopVarFxAmt = vopVarFxAmt;
	}
	
	/**
	 * Column Info
	 * @param lodQty
	 */
	public void setLodQty(String lodQty) {
		this.lodQty = lodQty;
	}
	
	/**
	 * Column Info
	 * @param ssnlDiffAmt
	 */
	public void setSsnlDiffAmt(String ssnlDiffAmt) {
		this.ssnlDiffAmt = ssnlDiffAmt;
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
	 * @param plcyPrcUtAmt
	 */
	public void setPlcyPrcUtAmt(String plcyPrcUtAmt) {
		this.plcyPrcUtAmt = plcyPrcUtAmt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param vslSlanDirCd
	 */
	public void setVslSlanDirCd(String vslSlanDirCd) {
		this.vslSlanDirCd = vslSlanDirCd;
	}
	
	/**
	 * Column Info
	 * @param cmCostAmt
	 */
	public void setCmCostAmt(String cmCostAmt) {
		this.cmCostAmt = cmCostAmt;
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
		setVopVarFxAmt(JSPUtil.getParameter(request, prefix + "vop_var_fx_amt", ""));
		setLodQty(JSPUtil.getParameter(request, prefix + "lod_qty", ""));
		setSsnlDiffAmt(JSPUtil.getParameter(request, prefix + "ssnl_diff_amt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPlcyPrcUtAmt(JSPUtil.getParameter(request, prefix + "plcy_prc_ut_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setVslSlanDirCd(JSPUtil.getParameter(request, prefix + "vsl_slan_dir_cd", ""));
		setCmCostAmt(JSPUtil.getParameter(request, prefix + "cm_cost_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MasSsnlSltMgmtUtVO[]
	 */
	public MasSsnlSltMgmtUtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MasSsnlSltMgmtUtVO[]
	 */
	public MasSsnlSltMgmtUtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MasSsnlSltMgmtUtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vopVarFxAmt = (JSPUtil.getParameter(request, prefix	+ "vop_var_fx_amt", length));
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] ssnlDiffAmt = (JSPUtil.getParameter(request, prefix	+ "ssnl_diff_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] plcyPrcUtAmt = (JSPUtil.getParameter(request, prefix	+ "plcy_prc_ut_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] vslSlanDirCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_dir_cd", length));
			String[] cmCostAmt = (JSPUtil.getParameter(request, prefix	+ "cm_cost_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new MasSsnlSltMgmtUtVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vopVarFxAmt[i] != null)
					model.setVopVarFxAmt(vopVarFxAmt[i]);
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (ssnlDiffAmt[i] != null)
					model.setSsnlDiffAmt(ssnlDiffAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (plcyPrcUtAmt[i] != null)
					model.setPlcyPrcUtAmt(plcyPrcUtAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (vslSlanDirCd[i] != null)
					model.setVslSlanDirCd(vslSlanDirCd[i]);
				if (cmCostAmt[i] != null)
					model.setCmCostAmt(cmCostAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMasSsnlSltMgmtUtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MasSsnlSltMgmtUtVO[]
	 */
	public MasSsnlSltMgmtUtVO[] getMasSsnlSltMgmtUtVOs(){
		MasSsnlSltMgmtUtVO[] vos = (MasSsnlSltMgmtUtVO[])models.toArray(new MasSsnlSltMgmtUtVO[models.size()]);
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
		this.vopVarFxAmt = this.vopVarFxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ssnlDiffAmt = this.ssnlDiffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plcyPrcUtAmt = this.plcyPrcUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanDirCd = this.vslSlanDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmCostAmt = this.cmCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
