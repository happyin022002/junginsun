/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchToleranceMultiInfoVO.java
*@FileTitle : SearchToleranceMultiInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.20 이중환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo;

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
 * @author 이중환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchToleranceMultiInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchToleranceMultiInfoVO> models = new ArrayList<SearchToleranceMultiInfoVO>();
	
	/* Column Info */
	private String rFomlTmMin = null;
	/* Column Info */
	private String rActFlg = null;
	/* Column Info */
	private String rExptTpDtl = null;
	/* Column Info */
	private String rToAct = null;
	/* Column Info */
	private String rFomlTmHrs = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rFmAct = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rExptTp = null;
	/* Column Info */
	private String rUsrId = null;
	/* Column Info */
	private String rFmActNm = null;
	/* Column Info */
	private String rToActNm = null;
	/* Column Info */
	private String rFomlTmDys = null;
	/* Column Info */
	private String rIbflag = null;
	/* Column Info */
	private String rNodCd = null;
	/* Column Info */
	private String rUpdDt = null;
	/* Column Info */
	private String rLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchToleranceMultiInfoVO() {}

	public SearchToleranceMultiInfoVO(String ibflag, String pagerows, String rIbflag, String rExptTp, String rExptTpDtl, String rFmAct, String rFmActNm, String rToAct, String rToActNm, String rLocCd, String rNodCd, String rFomlTmDys, String rFomlTmHrs, String rFomlTmMin, String rUsrId, String rUpdDt, String rActFlg) {
		this.rFomlTmMin = rFomlTmMin;
		this.rActFlg = rActFlg;
		this.rExptTpDtl = rExptTpDtl;
		this.rToAct = rToAct;
		this.rFomlTmHrs = rFomlTmHrs;
		this.pagerows = pagerows;
		this.rFmAct = rFmAct;
		this.ibflag = ibflag;
		this.rExptTp = rExptTp;
		this.rUsrId = rUsrId;
		this.rFmActNm = rFmActNm;
		this.rToActNm = rToActNm;
		this.rFomlTmDys = rFomlTmDys;
		this.rIbflag = rIbflag;
		this.rNodCd = rNodCd;
		this.rUpdDt = rUpdDt;
		this.rLocCd = rLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("r_foml_tm_min", getRFomlTmMin());
		this.hashColumns.put("r_act_flg", getRActFlg());
		this.hashColumns.put("r_expt_tp_dtl", getRExptTpDtl());
		this.hashColumns.put("r_to_act", getRToAct());
		this.hashColumns.put("r_foml_tm_hrs", getRFomlTmHrs());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("r_fm_act", getRFmAct());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("r_expt_tp", getRExptTp());
		this.hashColumns.put("r_usr_id", getRUsrId());
		this.hashColumns.put("r_fm_act_nm", getRFmActNm());
		this.hashColumns.put("r_to_act_nm", getRToActNm());
		this.hashColumns.put("r_foml_tm_dys", getRFomlTmDys());
		this.hashColumns.put("r_ibflag", getRIbflag());
		this.hashColumns.put("r_nod_cd", getRNodCd());
		this.hashColumns.put("r_upd_dt", getRUpdDt());
		this.hashColumns.put("r_loc_cd", getRLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("r_foml_tm_min", "rFomlTmMin");
		this.hashFields.put("r_act_flg", "rActFlg");
		this.hashFields.put("r_expt_tp_dtl", "rExptTpDtl");
		this.hashFields.put("r_to_act", "rToAct");
		this.hashFields.put("r_foml_tm_hrs", "rFomlTmHrs");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("r_fm_act", "rFmAct");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("r_expt_tp", "rExptTp");
		this.hashFields.put("r_usr_id", "rUsrId");
		this.hashFields.put("r_fm_act_nm", "rFmActNm");
		this.hashFields.put("r_to_act_nm", "rToActNm");
		this.hashFields.put("r_foml_tm_dys", "rFomlTmDys");
		this.hashFields.put("r_ibflag", "rIbflag");
		this.hashFields.put("r_nod_cd", "rNodCd");
		this.hashFields.put("r_upd_dt", "rUpdDt");
		this.hashFields.put("r_loc_cd", "rLocCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rFomlTmMin
	 */
	public String getRFomlTmMin() {
		return this.rFomlTmMin;
	}
	
	/**
	 * Column Info
	 * @return rActFlg
	 */
	public String getRActFlg() {
		return this.rActFlg;
	}
	
	/**
	 * Column Info
	 * @return rExptTpDtl
	 */
	public String getRExptTpDtl() {
		return this.rExptTpDtl;
	}
	
	/**
	 * Column Info
	 * @return rToAct
	 */
	public String getRToAct() {
		return this.rToAct;
	}
	
	/**
	 * Column Info
	 * @return rFomlTmHrs
	 */
	public String getRFomlTmHrs() {
		return this.rFomlTmHrs;
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
	 * @return rFmAct
	 */
	public String getRFmAct() {
		return this.rFmAct;
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
	 * @return rExptTp
	 */
	public String getRExptTp() {
		return this.rExptTp;
	}
	
	/**
	 * Column Info
	 * @return rUsrId
	 */
	public String getRUsrId() {
		return this.rUsrId;
	}
	
	/**
	 * Column Info
	 * @return rFmActNm
	 */
	public String getRFmActNm() {
		return this.rFmActNm;
	}
	
	/**
	 * Column Info
	 * @return rToActNm
	 */
	public String getRToActNm() {
		return this.rToActNm;
	}
	
	/**
	 * Column Info
	 * @return rFomlTmDys
	 */
	public String getRFomlTmDys() {
		return this.rFomlTmDys;
	}
	
	/**
	 * Column Info
	 * @return rIbflag
	 */
	public String getRIbflag() {
		return this.rIbflag;
	}
	
	/**
	 * Column Info
	 * @return rNodCd
	 */
	public String getRNodCd() {
		return this.rNodCd;
	}
	
	/**
	 * Column Info
	 * @return rUpdDt
	 */
	public String getRUpdDt() {
		return this.rUpdDt;
	}
	
	/**
	 * Column Info
	 * @return rLocCd
	 */
	public String getRLocCd() {
		return this.rLocCd;
	}
	

	/**
	 * Column Info
	 * @param rFomlTmMin
	 */
	public void setRFomlTmMin(String rFomlTmMin) {
		this.rFomlTmMin = rFomlTmMin;
	}
	
	/**
	 * Column Info
	 * @param rActFlg
	 */
	public void setRActFlg(String rActFlg) {
		this.rActFlg = rActFlg;
	}
	
	/**
	 * Column Info
	 * @param rExptTpDtl
	 */
	public void setRExptTpDtl(String rExptTpDtl) {
		this.rExptTpDtl = rExptTpDtl;
	}
	
	/**
	 * Column Info
	 * @param rToAct
	 */
	public void setRToAct(String rToAct) {
		this.rToAct = rToAct;
	}
	
	/**
	 * Column Info
	 * @param rFomlTmHrs
	 */
	public void setRFomlTmHrs(String rFomlTmHrs) {
		this.rFomlTmHrs = rFomlTmHrs;
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
	 * @param rFmAct
	 */
	public void setRFmAct(String rFmAct) {
		this.rFmAct = rFmAct;
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
	 * @param rExptTp
	 */
	public void setRExptTp(String rExptTp) {
		this.rExptTp = rExptTp;
	}
	
	/**
	 * Column Info
	 * @param rUsrId
	 */
	public void setRUsrId(String rUsrId) {
		this.rUsrId = rUsrId;
	}
	
	/**
	 * Column Info
	 * @param rFmActNm
	 */
	public void setRFmActNm(String rFmActNm) {
		this.rFmActNm = rFmActNm;
	}
	
	/**
	 * Column Info
	 * @param rToActNm
	 */
	public void setRToActNm(String rToActNm) {
		this.rToActNm = rToActNm;
	}
	
	/**
	 * Column Info
	 * @param rFomlTmDys
	 */
	public void setRFomlTmDys(String rFomlTmDys) {
		this.rFomlTmDys = rFomlTmDys;
	}
	
	/**
	 * Column Info
	 * @param rIbflag
	 */
	public void setRIbflag(String rIbflag) {
		this.rIbflag = rIbflag;
	}
	
	/**
	 * Column Info
	 * @param rNodCd
	 */
	public void setRNodCd(String rNodCd) {
		this.rNodCd = rNodCd;
	}
	
	/**
	 * Column Info
	 * @param rUpdDt
	 */
	public void setRUpdDt(String rUpdDt) {
		this.rUpdDt = rUpdDt;
	}
	
	/**
	 * Column Info
	 * @param rLocCd
	 */
	public void setRLocCd(String rLocCd) {
		this.rLocCd = rLocCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRFomlTmMin(JSPUtil.getParameter(request, "r_foml_tm_min", ""));
		setRActFlg(JSPUtil.getParameter(request, "r_act_flg", ""));
		setRExptTpDtl(JSPUtil.getParameter(request, "r_expt_tp_dtl", ""));
		setRToAct(JSPUtil.getParameter(request, "r_to_act", ""));
		setRFomlTmHrs(JSPUtil.getParameter(request, "r_foml_tm_hrs", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRFmAct(JSPUtil.getParameter(request, "r_fm_act", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRExptTp(JSPUtil.getParameter(request, "r_expt_tp", ""));
		setRUsrId(JSPUtil.getParameter(request, "r_usr_id", ""));
		setRFmActNm(JSPUtil.getParameter(request, "r_fm_act_nm", ""));
		setRToActNm(JSPUtil.getParameter(request, "r_to_act_nm", ""));
		setRFomlTmDys(JSPUtil.getParameter(request, "r_foml_tm_dys", ""));
		setRIbflag(JSPUtil.getParameter(request, "r_ibflag", ""));
		setRNodCd(JSPUtil.getParameter(request, "r_nod_cd", ""));
		setRUpdDt(JSPUtil.getParameter(request, "r_upd_dt", ""));
		setRLocCd(JSPUtil.getParameter(request, "r_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchToleranceMultiInfoVO[]
	 */
	public SearchToleranceMultiInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchToleranceMultiInfoVO[]
	 */
	public SearchToleranceMultiInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchToleranceMultiInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "r_ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "r_ibflag").length;
  
		try {
			String[] rFomlTmMin = (JSPUtil.getParameter(request, prefix	+ "r_foml_tm_min", length));
			String[] rActFlg = (JSPUtil.getParameter(request, prefix	+ "r_act_flg", length));
			String[] rExptTpDtl = (JSPUtil.getParameter(request, prefix	+ "r_expt_tp_dtl", length));
			String[] rToAct = (JSPUtil.getParameter(request, prefix	+ "r_to_act", length));
			String[] rFomlTmHrs = (JSPUtil.getParameter(request, prefix	+ "r_foml_tm_hrs", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rFmAct = (JSPUtil.getParameter(request, prefix	+ "r_fm_act", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rExptTp = (JSPUtil.getParameter(request, prefix	+ "r_expt_tp", length));
			String[] rUsrId = (JSPUtil.getParameter(request, prefix	+ "r_usr_id", length));
			String[] rFmActNm = (JSPUtil.getParameter(request, prefix	+ "r_fm_act_nm", length));
			String[] rToActNm = (JSPUtil.getParameter(request, prefix	+ "r_to_act_nm", length));
			String[] rFomlTmDys = (JSPUtil.getParameter(request, prefix	+ "r_foml_tm_dys", length));
			String[] rIbflag = (JSPUtil.getParameter(request, prefix	+ "r_ibflag", length));
			String[] rNodCd = (JSPUtil.getParameter(request, prefix	+ "r_nod_cd", length));
			String[] rUpdDt = (JSPUtil.getParameter(request, prefix	+ "r_upd_dt", length));
			String[] rLocCd = (JSPUtil.getParameter(request, prefix	+ "r_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchToleranceMultiInfoVO();
				if (rFomlTmMin[i] != null)
					model.setRFomlTmMin(rFomlTmMin[i]);
				if (rActFlg[i] != null)
					model.setRActFlg(rActFlg[i]);
				if (rExptTpDtl[i] != null)
					model.setRExptTpDtl(rExptTpDtl[i]);
				if (rToAct[i] != null)
					model.setRToAct(rToAct[i]);
				if (rFomlTmHrs[i] != null)
					model.setRFomlTmHrs(rFomlTmHrs[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rFmAct[i] != null)
					model.setRFmAct(rFmAct[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rExptTp[i] != null)
					model.setRExptTp(rExptTp[i]);
				if (rUsrId[i] != null)
					model.setRUsrId(rUsrId[i]);
				if (rFmActNm[i] != null)
					model.setRFmActNm(rFmActNm[i]);
				if (rToActNm[i] != null)
					model.setRToActNm(rToActNm[i]);
				if (rFomlTmDys[i] != null)
					model.setRFomlTmDys(rFomlTmDys[i]);
				if (rIbflag[i] != null)
					model.setRIbflag(rIbflag[i]);
				if (rNodCd[i] != null)
					model.setRNodCd(rNodCd[i]);
				if (rUpdDt[i] != null)
					model.setRUpdDt(rUpdDt[i]);
				if (rLocCd[i] != null)
					model.setRLocCd(rLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchToleranceMultiInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchToleranceMultiInfoVO[]
	 */
	public SearchToleranceMultiInfoVO[] getSearchToleranceMultiInfoVOs(){
		SearchToleranceMultiInfoVO[] vos = (SearchToleranceMultiInfoVO[])models.toArray(new SearchToleranceMultiInfoVO[models.size()]);
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
		this.rFomlTmMin = this.rFomlTmMin .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rActFlg = this.rActFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rExptTpDtl = this.rExptTpDtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rToAct = this.rToAct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rFomlTmHrs = this.rFomlTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rFmAct = this.rFmAct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rExptTp = this.rExptTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rUsrId = this.rUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rFmActNm = this.rFmActNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rToActNm = this.rToActNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rFomlTmDys = this.rFomlTmDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rIbflag = this.rIbflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rNodCd = this.rNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rUpdDt = this.rUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rLocCd = this.rLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
