/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchExpTypeDetailListForMultiVO.java
*@FileTitle : SearchExpTypeDetailListForMultiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.12 이중환 
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

public class SearchExpTypeDetailListForMultiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchExpTypeDetailListForMultiVO> models = new ArrayList<SearchExpTypeDetailListForMultiVO>();
	
	/* Column Info */
	private String fFmAct = null;
	/* Column Info */
	private String fUsrId = null;
	/* Column Info */
	private String fToExptCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fCopExptTpDtlCd = null;
	/* Column Info */
	private String fCopExptTpDtlNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String fIbflag = null;
	/* Column Info */
	private String fToAct = null;
	/* Column Info */
	private String fActFlg = null;
	/* Column Info */
	private String fFmActNm = null;
	/* Column Info */
	private String fCopExptTpCd = null;
	/* Column Info */
	private String fFmExptCd = null;
	/* Column Info */
	private String fCopExptTpDtlDesc = null;
	/* Column Info */
	private String fToActNm = null;
	/* Column Info */
	private String fUpdDt = null;
	/* Column Info */
	private String exptCdNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchExpTypeDetailListForMultiVO() {}

	public SearchExpTypeDetailListForMultiVO(String fIbflag, String pagerows, String fCopExptTpCd, String exptCdNm, String fCopExptTpDtlCd, String fCopExptTpDtlNm, String fCopExptTpDtlDesc, String fFmExptCd, String fFmAct, String fFmActNm, String fToExptCd, String fToAct, String fToActNm, String fUsrId, String fUpdDt, String fActFlg) {
		this.fFmAct = fFmAct;
		this.fUsrId = fUsrId;
		this.fToExptCd = fToExptCd;
		this.pagerows = pagerows;
		this.fCopExptTpDtlCd = fCopExptTpDtlCd;
		this.fCopExptTpDtlNm = fCopExptTpDtlNm;
		this.fIbflag = fIbflag;
		this.fToAct = fToAct;
		this.fActFlg = fActFlg;
		this.fFmActNm = fFmActNm;
		this.fCopExptTpCd = fCopExptTpCd;
		this.fFmExptCd = fFmExptCd;
		this.fCopExptTpDtlDesc = fCopExptTpDtlDesc;
		this.fToActNm = fToActNm;
		this.fUpdDt = fUpdDt;
		this.exptCdNm = exptCdNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_fm_act", getFFmAct());
		this.hashColumns.put("f_usr_id", getFUsrId());
		this.hashColumns.put("f_to_expt_cd", getFToExptCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_cop_expt_tp_dtl_cd", getFCopExptTpDtlCd());
		this.hashColumns.put("f_cop_expt_tp_dtl_nm", getFCopExptTpDtlNm());
		this.hashColumns.put("f_ibflag", getFIbflag());
		this.hashColumns.put("f_to_act", getFToAct());
		this.hashColumns.put("f_act_flg", getFActFlg());
		this.hashColumns.put("f_fm_act_nm", getFFmActNm());
		this.hashColumns.put("f_cop_expt_tp_cd", getFCopExptTpCd());
		this.hashColumns.put("f_fm_expt_cd", getFFmExptCd());
		this.hashColumns.put("f_cop_expt_tp_dtl_desc", getFCopExptTpDtlDesc());
		this.hashColumns.put("f_to_act_nm", getFToActNm());
		this.hashColumns.put("f_upd_dt", getFUpdDt());
		this.hashColumns.put("expt_cd_nm", getExptCdNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_fm_act", "fFmAct");
		this.hashFields.put("f_usr_id", "fUsrId");
		this.hashFields.put("f_to_expt_cd", "fToExptCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_cop_expt_tp_dtl_cd", "fCopExptTpDtlCd");
		this.hashFields.put("f_cop_expt_tp_dtl_nm", "fCopExptTpDtlNm");
		this.hashFields.put("f_ibflag", "f_ibflag");
		this.hashFields.put("f_to_act", "fToAct");
		this.hashFields.put("f_act_flg", "fActFlg");
		this.hashFields.put("f_fm_act_nm", "fFmActNm");
		this.hashFields.put("f_cop_expt_tp_cd", "fCopExptTpCd");
		this.hashFields.put("f_fm_expt_cd", "fFmExptCd");
		this.hashFields.put("f_cop_expt_tp_dtl_desc", "fCopExptTpDtlDesc");
		this.hashFields.put("f_to_act_nm", "fToActNm");
		this.hashFields.put("f_upd_dt", "fUpdDt");
		this.hashFields.put("expt_cd_nm", "exptCdNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fFmAct
	 */
	public String getFFmAct() {
		return this.fFmAct;
	}
	
	/**
	 * Column Info
	 * @return fUsrId
	 */
	public String getFUsrId() {
		return this.fUsrId;
	}
	
	/**
	 * Column Info
	 * @return fToExptCd
	 */
	public String getFToExptCd() {
		return this.fToExptCd;
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
	 * @return fCopExptTpDtlCd
	 */
	public String getFCopExptTpDtlCd() {
		return this.fCopExptTpDtlCd;
	}
	
	/**
	 * Column Info
	 * @return fCopExptTpDtlNm
	 */
	public String getFCopExptTpDtlNm() {
		return this.fCopExptTpDtlNm;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return fIbflag
	 */
	public String getFIbflag() {
		return this.fIbflag;
	}
	
	/**
	 * Column Info
	 * @return fToAct
	 */
	public String getFToAct() {
		return this.fToAct;
	}
	
	/**
	 * Column Info
	 * @return fActFlg
	 */
	public String getFActFlg() {
		return this.fActFlg;
	}
	
	/**
	 * Column Info
	 * @return fFmActNm
	 */
	public String getFFmActNm() {
		return this.fFmActNm;
	}
	
	/**
	 * Column Info
	 * @return fCopExptTpCd
	 */
	public String getFCopExptTpCd() {
		return this.fCopExptTpCd;
	}
	
	/**
	 * Column Info
	 * @return fFmExptCd
	 */
	public String getFFmExptCd() {
		return this.fFmExptCd;
	}
	
	/**
	 * Column Info
	 * @return fCopExptTpDtlDesc
	 */
	public String getFCopExptTpDtlDesc() {
		return this.fCopExptTpDtlDesc;
	}
	
	/**
	 * Column Info
	 * @return fToActNm
	 */
	public String getFToActNm() {
		return this.fToActNm;
	}
	
	/**
	 * Column Info
	 * @return fUpdDt
	 */
	public String getFUpdDt() {
		return this.fUpdDt;
	}
	
	/**
	 * Column Info
	 * @return exptCdNm
	 */
	public String getExptCdNm() {
		return this.exptCdNm;
	}
	

	/**
	 * Column Info
	 * @param fFmAct
	 */
	public void setFFmAct(String fFmAct) {
		this.fFmAct = fFmAct;
	}
	
	/**
	 * Column Info
	 * @param fUsrId
	 */
	public void setFUsrId(String fUsrId) {
		this.fUsrId = fUsrId;
	}
	
	/**
	 * Column Info
	 * @param fToExptCd
	 */
	public void setFToExptCd(String fToExptCd) {
		this.fToExptCd = fToExptCd;
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
	 * @param fCopExptTpDtlCd
	 */
	public void setFCopExptTpDtlCd(String fCopExptTpDtlCd) {
		this.fCopExptTpDtlCd = fCopExptTpDtlCd;
	}
	
	/**
	 * Column Info
	 * @param fCopExptTpDtlNm
	 */
	public void setFCopExptTpDtlNm(String fCopExptTpDtlNm) {
		this.fCopExptTpDtlNm = fCopExptTpDtlNm;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param fIbflag
	 */
	public void setFIbflag(String fIbflag) {
		this.fIbflag = fIbflag;
	}
	
	/**
	 * Column Info
	 * @param fToAct
	 */
	public void setFToAct(String fToAct) {
		this.fToAct = fToAct;
	}
	
	/**
	 * Column Info
	 * @param fActFlg
	 */
	public void setFActFlg(String fActFlg) {
		this.fActFlg = fActFlg;
	}
	
	/**
	 * Column Info
	 * @param fFmActNm
	 */
	public void setFFmActNm(String fFmActNm) {
		this.fFmActNm = fFmActNm;
	}
	
	/**
	 * Column Info
	 * @param fCopExptTpCd
	 */
	public void setFCopExptTpCd(String fCopExptTpCd) {
		this.fCopExptTpCd = fCopExptTpCd;
	}
	
	/**
	 * Column Info
	 * @param fFmExptCd
	 */
	public void setFFmExptCd(String fFmExptCd) {
		this.fFmExptCd = fFmExptCd;
	}
	
	/**
	 * Column Info
	 * @param fCopExptTpDtlDesc
	 */
	public void setFCopExptTpDtlDesc(String fCopExptTpDtlDesc) {
		this.fCopExptTpDtlDesc = fCopExptTpDtlDesc;
	}
	
	/**
	 * Column Info
	 * @param fToActNm
	 */
	public void setFToActNm(String fToActNm) {
		this.fToActNm = fToActNm;
	}
	
	/**
	 * Column Info
	 * @param fUpdDt
	 */
	public void setFUpdDt(String fUpdDt) {
		this.fUpdDt = fUpdDt;
	}
	
	/**
	 * Column Info
	 * @param exptCdNm
	 */
	public void setExptCdNm(String exptCdNm) {
		this.exptCdNm = exptCdNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFFmAct(JSPUtil.getParameter(request, "f_fm_act", ""));
		setFUsrId(JSPUtil.getParameter(request, "f_usr_id", ""));
		setFToExptCd(JSPUtil.getParameter(request, "f_to_expt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFCopExptTpDtlCd(JSPUtil.getParameter(request, "f_cop_expt_tp_dtl_cd", ""));
		setFCopExptTpDtlNm(JSPUtil.getParameter(request, "f_cop_expt_tp_dtl_nm", ""));
		setFIbflag(JSPUtil.getParameter(request, "f_ibflag", ""));
		setFToAct(JSPUtil.getParameter(request, "f_to_act", ""));
		setFActFlg(JSPUtil.getParameter(request, "f_act_flg", ""));
		setFFmActNm(JSPUtil.getParameter(request, "f_fm_act_nm", ""));
		setFCopExptTpCd(JSPUtil.getParameter(request, "f_cop_expt_tp_cd", ""));
		setFFmExptCd(JSPUtil.getParameter(request, "f_fm_expt_cd", ""));
		setFCopExptTpDtlDesc(JSPUtil.getParameter(request, "f_cop_expt_tp_dtl_desc", ""));
		setFToActNm(JSPUtil.getParameter(request, "f_to_act_nm", ""));
		setFUpdDt(JSPUtil.getParameter(request, "f_upd_dt", ""));
		setExptCdNm(JSPUtil.getParameter(request, "expt_cd_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchExpTypeDetailListForMultiVO[]
	 */
	public SearchExpTypeDetailListForMultiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchExpTypeDetailListForMultiVO[]
	 */
	public SearchExpTypeDetailListForMultiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchExpTypeDetailListForMultiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "f_ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "f_ibflag").length;
  
		try {
			String[] fFmAct = (JSPUtil.getParameter(request, prefix	+ "f_fm_act", length));
			String[] fUsrId = (JSPUtil.getParameter(request, prefix	+ "f_usr_id", length));
			String[] fToExptCd = (JSPUtil.getParameter(request, prefix	+ "f_to_expt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fCopExptTpDtlCd = (JSPUtil.getParameter(request, prefix	+ "f_cop_expt_tp_dtl_cd", length));
			String[] fCopExptTpDtlNm = (JSPUtil.getParameter(request, prefix	+ "f_cop_expt_tp_dtl_nm", length));
			String[] fIbflag = (JSPUtil.getParameter(request, prefix	+ "f_ibflag", length));
			String[] fToAct = (JSPUtil.getParameter(request, prefix	+ "f_to_act", length));
			String[] fActFlg = (JSPUtil.getParameter(request, prefix	+ "f_act_flg", length));
			String[] fFmActNm = (JSPUtil.getParameter(request, prefix	+ "f_fm_act_nm", length));
			String[] fCopExptTpCd = (JSPUtil.getParameter(request, prefix	+ "f_cop_expt_tp_cd", length));
			String[] fFmExptCd = (JSPUtil.getParameter(request, prefix	+ "f_fm_expt_cd", length));
			String[] fCopExptTpDtlDesc = (JSPUtil.getParameter(request, prefix	+ "f_cop_expt_tp_dtl_desc", length));
			String[] fToActNm = (JSPUtil.getParameter(request, prefix	+ "f_to_act_nm", length));
			String[] fUpdDt = (JSPUtil.getParameter(request, prefix	+ "f_upd_dt", length));
			String[] exptCdNm = (JSPUtil.getParameter(request, prefix	+ "expt_cd_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchExpTypeDetailListForMultiVO();
				if (fFmAct[i] != null)
					model.setFFmAct(fFmAct[i]);
				if (fUsrId[i] != null)
					model.setFUsrId(fUsrId[i]);
				if (fToExptCd[i] != null)
					model.setFToExptCd(fToExptCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fCopExptTpDtlCd[i] != null)
					model.setFCopExptTpDtlCd(fCopExptTpDtlCd[i]);
				if (fCopExptTpDtlNm[i] != null)
					model.setFCopExptTpDtlNm(fCopExptTpDtlNm[i]);
				if (fIbflag[i] != null)
					model.setFIbflag(fIbflag[i]);
				if (fToAct[i] != null)
					model.setFToAct(fToAct[i]);
				if (fActFlg[i] != null)
					model.setFActFlg(fActFlg[i]);
				if (fFmActNm[i] != null)
					model.setFFmActNm(fFmActNm[i]);
				if (fCopExptTpCd[i] != null)
					model.setFCopExptTpCd(fCopExptTpCd[i]);
				if (fFmExptCd[i] != null)
					model.setFFmExptCd(fFmExptCd[i]);
				if (fCopExptTpDtlDesc[i] != null)
					model.setFCopExptTpDtlDesc(fCopExptTpDtlDesc[i]);
				if (fToActNm[i] != null)
					model.setFToActNm(fToActNm[i]);
				if (fUpdDt[i] != null)
					model.setFUpdDt(fUpdDt[i]);
				if (exptCdNm[i] != null)
					model.setExptCdNm(exptCdNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchExpTypeDetailListForMultiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchExpTypeDetailListForMultiVO[]
	 */
	public SearchExpTypeDetailListForMultiVO[] getSearchExpTypeDetailListForMultiVOs(){
		SearchExpTypeDetailListForMultiVO[] vos = (SearchExpTypeDetailListForMultiVO[])models.toArray(new SearchExpTypeDetailListForMultiVO[models.size()]);
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
		this.fFmAct = this.fFmAct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fUsrId = this.fUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToExptCd = this.fToExptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCopExptTpDtlCd = this.fCopExptTpDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCopExptTpDtlNm = this.fCopExptTpDtlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIbflag = this.fIbflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToAct = this.fToAct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fActFlg = this.fActFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmActNm = this.fFmActNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCopExptTpCd = this.fCopExptTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmExptCd = this.fFmExptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCopExptTpDtlDesc = this.fCopExptTpDtlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToActNm = this.fToActNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fUpdDt = this.fUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptCdNm = this.exptCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
