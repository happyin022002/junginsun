/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomMnrCdRltVO.java
*@FileTitle : CustomMnrCdRltVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.31
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.08.31 박명신 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo;

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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrCdRltVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrCdRltVO> models = new ArrayList<CustomMnrCdRltVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mnrRltCdDesc = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String eqCedexRltTpCd = null;
	/* Column Info */
	private String eqRprCd = null;
	/* Column Info */
	private String fmRltCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String costGrpCd = null;
	/* Column Info */
	private String toRltCd = null;
	/* Column Info */
	private String rprLbrHrs = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String eqCmpoCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomMnrCdRltVO() {}

	public CustomMnrCdRltVO(String ibflag, String pagerows, String updDt, String mnrRltCdDesc, String creDt, String eqCedexRltTpCd, String eqRprCd, String fmRltCd, String creUsrId, String costGrpCd, String toRltCd, String updUsrId, String eqCmpoCd, String rprLbrHrs) {
		this.updDt = updDt;
		this.mnrRltCdDesc = mnrRltCdDesc;
		this.creDt = creDt;
		this.eqCedexRltTpCd = eqCedexRltTpCd;
		this.eqRprCd = eqRprCd;
		this.fmRltCd = fmRltCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.costGrpCd = costGrpCd;
		this.toRltCd = toRltCd;
		this.rprLbrHrs = rprLbrHrs;
		this.updUsrId = updUsrId;
		this.eqCmpoCd = eqCmpoCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mnr_rlt_cd_desc", getMnrRltCdDesc());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eq_cedex_rlt_tp_cd", getEqCedexRltTpCd());
		this.hashColumns.put("eq_rpr_cd", getEqRprCd());
		this.hashColumns.put("fm_rlt_cd", getFmRltCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cost_grp_cd", getCostGrpCd());
		this.hashColumns.put("to_rlt_cd", getToRltCd());
		this.hashColumns.put("rpr_lbr_hrs", getRprLbrHrs());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("eq_cmpo_cd", getEqCmpoCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mnr_rlt_cd_desc", "mnrRltCdDesc");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eq_cedex_rlt_tp_cd", "eqCedexRltTpCd");
		this.hashFields.put("eq_rpr_cd", "eqRprCd");
		this.hashFields.put("fm_rlt_cd", "fmRltCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cost_grp_cd", "costGrpCd");
		this.hashFields.put("to_rlt_cd", "toRltCd");
		this.hashFields.put("rpr_lbr_hrs", "rprLbrHrs");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("eq_cmpo_cd", "eqCmpoCd");
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
	 * @return mnrRltCdDesc
	 */
	public String getMnrRltCdDesc() {
		return this.mnrRltCdDesc;
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
	 * @return eqCedexRltTpCd
	 */
	public String getEqCedexRltTpCd() {
		return this.eqCedexRltTpCd;
	}
	
	/**
	 * Column Info
	 * @return eqRprCd
	 */
	public String getEqRprCd() {
		return this.eqRprCd;
	}
	
	/**
	 * Column Info
	 * @return fmRltCd
	 */
	public String getFmRltCd() {
		return this.fmRltCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return costGrpCd
	 */
	public String getCostGrpCd() {
		return this.costGrpCd;
	}
	
	/**
	 * Column Info
	 * @return toRltCd
	 */
	public String getToRltCd() {
		return this.toRltCd;
	}
	
	/**
	 * Column Info
	 * @return rprLbrHrs
	 */
	public String getRprLbrHrs() {
		return this.rprLbrHrs;
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
	 * @return eqCmpoCd
	 */
	public String getEqCmpoCd() {
		return this.eqCmpoCd;
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
	 * @param mnrRltCdDesc
	 */
	public void setMnrRltCdDesc(String mnrRltCdDesc) {
		this.mnrRltCdDesc = mnrRltCdDesc;
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
	 * @param eqCedexRltTpCd
	 */
	public void setEqCedexRltTpCd(String eqCedexRltTpCd) {
		this.eqCedexRltTpCd = eqCedexRltTpCd;
	}
	
	/**
	 * Column Info
	 * @param eqRprCd
	 */
	public void setEqRprCd(String eqRprCd) {
		this.eqRprCd = eqRprCd;
	}
	
	/**
	 * Column Info
	 * @param fmRltCd
	 */
	public void setFmRltCd(String fmRltCd) {
		this.fmRltCd = fmRltCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param costGrpCd
	 */
	public void setCostGrpCd(String costGrpCd) {
		this.costGrpCd = costGrpCd;
	}
	
	/**
	 * Column Info
	 * @param toRltCd
	 */
	public void setToRltCd(String toRltCd) {
		this.toRltCd = toRltCd;
	}
	
	/**
	 * Column Info
	 * @param rprLbrHrs
	 */
	public void setRprLbrHrs(String rprLbrHrs) {
		this.rprLbrHrs = rprLbrHrs;
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
	 * @param eqCmpoCd
	 */
	public void setEqCmpoCd(String eqCmpoCd) {
		this.eqCmpoCd = eqCmpoCd;
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
		setMnrRltCdDesc(JSPUtil.getParameter(request, prefix + "mnr_rlt_cd_desc", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEqCedexRltTpCd(JSPUtil.getParameter(request, prefix + "eq_cedex_rlt_tp_cd", ""));
		setEqRprCd(JSPUtil.getParameter(request, prefix + "eq_rpr_cd", ""));
		setFmRltCd(JSPUtil.getParameter(request, prefix + "fm_rlt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCostGrpCd(JSPUtil.getParameter(request, prefix + "cost_grp_cd", ""));
		setToRltCd(JSPUtil.getParameter(request, prefix + "to_rlt_cd", ""));
		setRprLbrHrs(JSPUtil.getParameter(request, prefix + "rpr_lbr_hrs", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEqCmpoCd(JSPUtil.getParameter(request, prefix + "eq_cmpo_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrCdRltVO[]
	 */
	public CustomMnrCdRltVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrCdRltVO[]
	 */
	public CustomMnrCdRltVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrCdRltVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] mnrRltCdDesc = (JSPUtil.getParameter(request, prefix	+ "mnr_rlt_cd_desc", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] eqCedexRltTpCd = (JSPUtil.getParameter(request, prefix	+ "eq_cedex_rlt_tp_cd", length));
			String[] eqRprCd = (JSPUtil.getParameter(request, prefix	+ "eq_rpr_cd", length));
			String[] fmRltCd = (JSPUtil.getParameter(request, prefix	+ "fm_rlt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] costGrpCd = (JSPUtil.getParameter(request, prefix	+ "cost_grp_cd", length));
			String[] toRltCd = (JSPUtil.getParameter(request, prefix	+ "to_rlt_cd", length));
			String[] rprLbrHrs = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_hrs", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] eqCmpoCd = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrCdRltVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mnrRltCdDesc[i] != null)
					model.setMnrRltCdDesc(mnrRltCdDesc[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (eqCedexRltTpCd[i] != null)
					model.setEqCedexRltTpCd(eqCedexRltTpCd[i]);
				if (eqRprCd[i] != null)
					model.setEqRprCd(eqRprCd[i]);
				if (fmRltCd[i] != null)
					model.setFmRltCd(fmRltCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (costGrpCd[i] != null)
					model.setCostGrpCd(costGrpCd[i]);
				if (toRltCd[i] != null)
					model.setToRltCd(toRltCd[i]);
				if (rprLbrHrs[i] != null)
					model.setRprLbrHrs(rprLbrHrs[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (eqCmpoCd[i] != null)
					model.setEqCmpoCd(eqCmpoCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrCdRltVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrCdRltVO[]
	 */
	public CustomMnrCdRltVO[] getCustomMnrCdRltVOs(){
		CustomMnrCdRltVO[] vos = (CustomMnrCdRltVO[])models.toArray(new CustomMnrCdRltVO[models.size()]);
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
		this.mnrRltCdDesc = this.mnrRltCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCedexRltTpCd = this.eqCedexRltTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRprCd = this.eqRprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRltCd = this.fmRltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costGrpCd = this.costGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRltCd = this.toRltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLbrHrs = this.rprLbrHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoCd = this.eqCmpoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
