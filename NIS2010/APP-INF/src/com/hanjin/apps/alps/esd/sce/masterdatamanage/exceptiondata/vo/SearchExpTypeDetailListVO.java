/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchExpTypeDetailListVO.java
*@FileTitle : SearchExpTypeDetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.07 이중환 
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

public class SearchExpTypeDetailListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchExpTypeDetailListVO> models = new ArrayList<SearchExpTypeDetailListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String copExptTpDtlCd = null;
	/* Column Info */
	private String fmActNm = null;
	/* Column Info */
	private String toAct = null;
	/* Column Info */
	private String copExptTpDtlDesc = null;
	/* Column Info */
	private String fmAct = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmExptCd = null;
	/* Column Info */
	private String toActNm = null;
	/* Column Info */
	private String actFlg = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String toExptCd = null;
	/* Column Info */
	private String copExptTpCd = null;
	/* Column Info */
	private String copExptTpDtlNm = null;
	/* Column Info */
	private String exptCdNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchExpTypeDetailListVO() {}

	public SearchExpTypeDetailListVO(String ibflag, String pagerows, String copExptTpCd, String exptCdNm, String copExptTpDtlCd, String copExptTpDtlNm, String copExptTpDtlDesc, String fmExptCd, String fmAct, String fmActNm, String toExptCd, String toAct, String toActNm, String usrId, String updDt, String actFlg) {
		this.updDt = updDt;
		this.copExptTpDtlCd = copExptTpDtlCd;
		this.fmActNm = fmActNm;
		this.toAct = toAct;
		this.copExptTpDtlDesc = copExptTpDtlDesc;
		this.fmAct = fmAct;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.fmExptCd = fmExptCd;
		this.toActNm = toActNm;
		this.actFlg = actFlg;
		this.usrId = usrId;
		this.toExptCd = toExptCd;
		this.copExptTpCd = copExptTpCd;
		this.copExptTpDtlNm = copExptTpDtlNm;
		this.exptCdNm = exptCdNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cop_expt_tp_dtl_cd", getCopExptTpDtlCd());
		this.hashColumns.put("fm_act_nm", getFmActNm());
		this.hashColumns.put("to_act", getToAct());
		this.hashColumns.put("cop_expt_tp_dtl_desc", getCopExptTpDtlDesc());
		this.hashColumns.put("fm_act", getFmAct());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_expt_cd", getFmExptCd());
		this.hashColumns.put("to_act_nm", getToActNm());
		this.hashColumns.put("act_flg", getActFlg());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("to_expt_cd", getToExptCd());
		this.hashColumns.put("cop_expt_tp_cd", getCopExptTpCd());
		this.hashColumns.put("cop_expt_tp_dtl_nm", getCopExptTpDtlNm());
		this.hashColumns.put("expt_cd_nm", getExptCdNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cop_expt_tp_dtl_cd", "copExptTpDtlCd");
		this.hashFields.put("fm_act_nm", "fmActNm");
		this.hashFields.put("to_act", "toAct");
		this.hashFields.put("cop_expt_tp_dtl_desc", "copExptTpDtlDesc");
		this.hashFields.put("fm_act", "fmAct");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_expt_cd", "fmExptCd");
		this.hashFields.put("to_act_nm", "toActNm");
		this.hashFields.put("act_flg", "actFlg");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("to_expt_cd", "toExptCd");
		this.hashFields.put("cop_expt_tp_cd", "copExptTpCd");
		this.hashFields.put("cop_expt_tp_dtl_nm", "copExptTpDtlNm");
		this.hashFields.put("expt_cd_nm", "exptCdNm");
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
	 * @return copExptTpDtlCd
	 */
	public String getCopExptTpDtlCd() {
		return this.copExptTpDtlCd;
	}
	
	/**
	 * Column Info
	 * @return fmActNm
	 */
	public String getFmActNm() {
		return this.fmActNm;
	}
	
	/**
	 * Column Info
	 * @return toAct
	 */
	public String getToAct() {
		return this.toAct;
	}
	
	/**
	 * Column Info
	 * @return copExptTpDtlDesc
	 */
	public String getCopExptTpDtlDesc() {
		return this.copExptTpDtlDesc;
	}
	
	/**
	 * Column Info
	 * @return fmAct
	 */
	public String getFmAct() {
		return this.fmAct;
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
	 * @return fmExptCd
	 */
	public String getFmExptCd() {
		return this.fmExptCd;
	}
	
	/**
	 * Column Info
	 * @return toActNm
	 */
	public String getToActNm() {
		return this.toActNm;
	}
	
	/**
	 * Column Info
	 * @return actFlg
	 */
	public String getActFlg() {
		return this.actFlg;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return toExptCd
	 */
	public String getToExptCd() {
		return this.toExptCd;
	}
	
	/**
	 * Column Info
	 * @return copExptTpCd
	 */
	public String getCopExptTpCd() {
		return this.copExptTpCd;
	}
	
	/**
	 * Column Info
	 * @return copExptTpDtlNm
	 */
	public String getCopExptTpDtlNm() {
		return this.copExptTpDtlNm;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param copExptTpDtlCd
	 */
	public void setCopExptTpDtlCd(String copExptTpDtlCd) {
		this.copExptTpDtlCd = copExptTpDtlCd;
	}
	
	/**
	 * Column Info
	 * @param fmActNm
	 */
	public void setFmActNm(String fmActNm) {
		this.fmActNm = fmActNm;
	}
	
	/**
	 * Column Info
	 * @param toAct
	 */
	public void setToAct(String toAct) {
		this.toAct = toAct;
	}
	
	/**
	 * Column Info
	 * @param copExptTpDtlDesc
	 */
	public void setCopExptTpDtlDesc(String copExptTpDtlDesc) {
		this.copExptTpDtlDesc = copExptTpDtlDesc;
	}
	
	/**
	 * Column Info
	 * @param fmAct
	 */
	public void setFmAct(String fmAct) {
		this.fmAct = fmAct;
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
	 * @param fmExptCd
	 */
	public void setFmExptCd(String fmExptCd) {
		this.fmExptCd = fmExptCd;
	}
	
	/**
	 * Column Info
	 * @param toActNm
	 */
	public void setToActNm(String toActNm) {
		this.toActNm = toActNm;
	}
	
	/**
	 * Column Info
	 * @param actFlg
	 */
	public void setActFlg(String actFlg) {
		this.actFlg = actFlg;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param toExptCd
	 */
	public void setToExptCd(String toExptCd) {
		this.toExptCd = toExptCd;
	}
	
	/**
	 * Column Info
	 * @param copExptTpCd
	 */
	public void setCopExptTpCd(String copExptTpCd) {
		this.copExptTpCd = copExptTpCd;
	}
	
	/**
	 * Column Info
	 * @param copExptTpDtlNm
	 */
	public void setCopExptTpDtlNm(String copExptTpDtlNm) {
		this.copExptTpDtlNm = copExptTpDtlNm;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCopExptTpDtlCd(JSPUtil.getParameter(request, "cop_expt_tp_dtl_cd", ""));
		setFmActNm(JSPUtil.getParameter(request, "fm_act_nm", ""));
		setToAct(JSPUtil.getParameter(request, "to_act", ""));
		setCopExptTpDtlDesc(JSPUtil.getParameter(request, "cop_expt_tp_dtl_desc", ""));
		setFmAct(JSPUtil.getParameter(request, "fm_act", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFmExptCd(JSPUtil.getParameter(request, "fm_expt_cd", ""));
		setToActNm(JSPUtil.getParameter(request, "to_act_nm", ""));
		setActFlg(JSPUtil.getParameter(request, "act_flg", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setToExptCd(JSPUtil.getParameter(request, "to_expt_cd", ""));
		setCopExptTpCd(JSPUtil.getParameter(request, "cop_expt_tp_cd", ""));
		setCopExptTpDtlNm(JSPUtil.getParameter(request, "cop_expt_tp_dtl_nm", ""));
		setExptCdNm(JSPUtil.getParameter(request, "expt_cd_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchExpTypeDetailListVO[]
	 */
	public SearchExpTypeDetailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchExpTypeDetailListVO[]
	 */
	public SearchExpTypeDetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchExpTypeDetailListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] copExptTpDtlCd = (JSPUtil.getParameter(request, prefix	+ "cop_expt_tp_dtl_cd", length));
			String[] fmActNm = (JSPUtil.getParameter(request, prefix	+ "fm_act_nm", length));
			String[] toAct = (JSPUtil.getParameter(request, prefix	+ "to_act", length));
			String[] copExptTpDtlDesc = (JSPUtil.getParameter(request, prefix	+ "cop_expt_tp_dtl_desc", length));
			String[] fmAct = (JSPUtil.getParameter(request, prefix	+ "fm_act", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmExptCd = (JSPUtil.getParameter(request, prefix	+ "fm_expt_cd", length));
			String[] toActNm = (JSPUtil.getParameter(request, prefix	+ "to_act_nm", length));
			String[] actFlg = (JSPUtil.getParameter(request, prefix	+ "act_flg", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] toExptCd = (JSPUtil.getParameter(request, prefix	+ "to_expt_cd", length));
			String[] copExptTpCd = (JSPUtil.getParameter(request, prefix	+ "cop_expt_tp_cd", length));
			String[] copExptTpDtlNm = (JSPUtil.getParameter(request, prefix	+ "cop_expt_tp_dtl_nm", length));
			String[] exptCdNm = (JSPUtil.getParameter(request, prefix	+ "expt_cd_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchExpTypeDetailListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (copExptTpDtlCd[i] != null)
					model.setCopExptTpDtlCd(copExptTpDtlCd[i]);
				if (fmActNm[i] != null)
					model.setFmActNm(fmActNm[i]);
				if (toAct[i] != null)
					model.setToAct(toAct[i]);
				if (copExptTpDtlDesc[i] != null)
					model.setCopExptTpDtlDesc(copExptTpDtlDesc[i]);
				if (fmAct[i] != null)
					model.setFmAct(fmAct[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmExptCd[i] != null)
					model.setFmExptCd(fmExptCd[i]);
				if (toActNm[i] != null)
					model.setToActNm(toActNm[i]);
				if (actFlg[i] != null)
					model.setActFlg(actFlg[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (toExptCd[i] != null)
					model.setToExptCd(toExptCd[i]);
				if (copExptTpCd[i] != null)
					model.setCopExptTpCd(copExptTpCd[i]);
				if (copExptTpDtlNm[i] != null)
					model.setCopExptTpDtlNm(copExptTpDtlNm[i]);
				if (exptCdNm[i] != null)
					model.setExptCdNm(exptCdNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchExpTypeDetailListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchExpTypeDetailListVO[]
	 */
	public SearchExpTypeDetailListVO[] getSearchExpTypeDetailListVOs(){
		SearchExpTypeDetailListVO[] vos = (SearchExpTypeDetailListVO[])models.toArray(new SearchExpTypeDetailListVO[models.size()]);
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
		this.copExptTpDtlCd = this.copExptTpDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmActNm = this.fmActNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAct = this.toAct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copExptTpDtlDesc = this.copExptTpDtlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAct = this.fmAct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmExptCd = this.fmExptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toActNm = this.toActNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFlg = this.actFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toExptCd = this.toExptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copExptTpCd = this.copExptTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copExptTpDtlNm = this.copExptTpDtlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptCdNm = this.exptCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
