/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchCOPDetailDtInfoVO.java
*@FileTitle : SearchCOPDetailDtInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2010.02.04 오현경 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo;

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
 * @author 오현경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCOPDetailDtInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCOPDetailDtInfoVO> models = new ArrayList<SearchCOPDetailDtInfoVO>();
	
	/* Column Info */
	private String actCd = null;
	/* Column Info */
	private String totTransDts = null;
	/* Column Info */
	private String dlvPlnDate = null;
	/* Column Info */
	private String stsNm = null;
	/* Column Info */
	private String dlvEstmDate = null;
	/* Column Info */
	private String obDorArrDt = null;
	/* Column Info */
	private String dlvDts = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String deDueDt = null;
	/* Column Info */
	private String totTransEstmDate = null;
	/* Column Info */
	private String apntDt = null;
	/* Column Info */
	private String copSubStsCd = null;
	/* Column Info */
	private String copStsCd = null;
	/* Column Info */
	private String totTransPlnDate = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCOPDetailDtInfoVO() {}

	public SearchCOPDetailDtInfoVO(String ibflag, String pagerows, String deDueDt, String apntDt, String obDorArrDt, String stsNm, String dlvPlnDate, String dlvEstmDate, String dlvDts, String totTransPlnDate, String totTransEstmDate, String totTransDts, String copStsCd, String copSubStsCd, String actCd) {
		this.actCd = actCd;
		this.totTransDts = totTransDts;
		this.dlvPlnDate = dlvPlnDate;
		this.stsNm = stsNm;
		this.dlvEstmDate = dlvEstmDate;
		this.obDorArrDt = obDorArrDt;
		this.dlvDts = dlvDts;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.deDueDt = deDueDt;
		this.totTransEstmDate = totTransEstmDate;
		this.apntDt = apntDt;
		this.copSubStsCd = copSubStsCd;
		this.copStsCd = copStsCd;
		this.totTransPlnDate = totTransPlnDate;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("act_cd", getActCd());
		this.hashColumns.put("tot_trans_dts", getTotTransDts());
		this.hashColumns.put("dlv_pln_date", getDlvPlnDate());
		this.hashColumns.put("sts_nm", getStsNm());
		this.hashColumns.put("dlv_estm_date", getDlvEstmDate());
		this.hashColumns.put("ob_dor_arr_dt", getObDorArrDt());
		this.hashColumns.put("dlv_dts", getDlvDts());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("de_due_dt", getDeDueDt());
		this.hashColumns.put("tot_trans_estm_date", getTotTransEstmDate());
		this.hashColumns.put("apnt_dt", getApntDt());
		this.hashColumns.put("cop_sub_sts_cd", getCopSubStsCd());
		this.hashColumns.put("cop_sts_cd", getCopStsCd());
		this.hashColumns.put("tot_trans_pln_date", getTotTransPlnDate());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("act_cd", "actCd");
		this.hashFields.put("tot_trans_dts", "totTransDts");
		this.hashFields.put("dlv_pln_date", "dlvPlnDate");
		this.hashFields.put("sts_nm", "stsNm");
		this.hashFields.put("dlv_estm_date", "dlvEstmDate");
		this.hashFields.put("ob_dor_arr_dt", "obDorArrDt");
		this.hashFields.put("dlv_dts", "dlvDts");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("de_due_dt", "deDueDt");
		this.hashFields.put("tot_trans_estm_date", "totTransEstmDate");
		this.hashFields.put("apnt_dt", "apntDt");
		this.hashFields.put("cop_sub_sts_cd", "copSubStsCd");
		this.hashFields.put("cop_sts_cd", "copStsCd");
		this.hashFields.put("tot_trans_pln_date", "totTransPlnDate");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return actCd
	 */
	public String getActCd() {
		return this.actCd;
	}
	
	/**
	 * Column Info
	 * @return totTransDts
	 */
	public String getTotTransDts() {
		return this.totTransDts;
	}
	
	/**
	 * Column Info
	 * @return dlvPlnDate
	 */
	public String getDlvPlnDate() {
		return this.dlvPlnDate;
	}
	
	/**
	 * Column Info
	 * @return stsNm
	 */
	public String getStsNm() {
		return this.stsNm;
	}
	
	/**
	 * Column Info
	 * @return dlvEstmDate
	 */
	public String getDlvEstmDate() {
		return this.dlvEstmDate;
	}
	
	/**
	 * Column Info
	 * @return obDorArrDt
	 */
	public String getObDorArrDt() {
		return this.obDorArrDt;
	}
	
	/**
	 * Column Info
	 * @return dlvDts
	 */
	public String getDlvDts() {
		return this.dlvDts;
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
	 * @return deDueDt
	 */
	public String getDeDueDt() {
		return this.deDueDt;
	}
	
	/**
	 * Column Info
	 * @return totTransEstmDate
	 */
	public String getTotTransEstmDate() {
		return this.totTransEstmDate;
	}
	
	/**
	 * Column Info
	 * @return apntDt
	 */
	public String getApntDt() {
		return this.apntDt;
	}
	
	/**
	 * Column Info
	 * @return copSubStsCd
	 */
	public String getCopSubStsCd() {
		return this.copSubStsCd;
	}
	
	/**
	 * Column Info
	 * @return copStsCd
	 */
	public String getCopStsCd() {
		return this.copStsCd;
	}
	
	/**
	 * Column Info
	 * @return totTransPlnDate
	 */
	public String getTotTransPlnDate() {
		return this.totTransPlnDate;
	}
	

	/**
	 * Column Info
	 * @param actCd
	 */
	public void setActCd(String actCd) {
		this.actCd = actCd;
	}
	
	/**
	 * Column Info
	 * @param totTransDts
	 */
	public void setTotTransDts(String totTransDts) {
		this.totTransDts = totTransDts;
	}
	
	/**
	 * Column Info
	 * @param dlvPlnDate
	 */
	public void setDlvPlnDate(String dlvPlnDate) {
		this.dlvPlnDate = dlvPlnDate;
	}
	
	/**
	 * Column Info
	 * @param stsNm
	 */
	public void setStsNm(String stsNm) {
		this.stsNm = stsNm;
	}
	
	/**
	 * Column Info
	 * @param dlvEstmDate
	 */
	public void setDlvEstmDate(String dlvEstmDate) {
		this.dlvEstmDate = dlvEstmDate;
	}
	
	/**
	 * Column Info
	 * @param obDorArrDt
	 */
	public void setObDorArrDt(String obDorArrDt) {
		this.obDorArrDt = obDorArrDt;
	}
	
	/**
	 * Column Info
	 * @param dlvDts
	 */
	public void setDlvDts(String dlvDts) {
		this.dlvDts = dlvDts;
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
	 * @param deDueDt
	 */
	public void setDeDueDt(String deDueDt) {
		this.deDueDt = deDueDt;
	}
	
	/**
	 * Column Info
	 * @param totTransEstmDate
	 */
	public void setTotTransEstmDate(String totTransEstmDate) {
		this.totTransEstmDate = totTransEstmDate;
	}
	
	/**
	 * Column Info
	 * @param apntDt
	 */
	public void setApntDt(String apntDt) {
		this.apntDt = apntDt;
	}
	
	/**
	 * Column Info
	 * @param copSubStsCd
	 */
	public void setCopSubStsCd(String copSubStsCd) {
		this.copSubStsCd = copSubStsCd;
	}
	
	/**
	 * Column Info
	 * @param copStsCd
	 */
	public void setCopStsCd(String copStsCd) {
		this.copStsCd = copStsCd;
	}
	
	/**
	 * Column Info
	 * @param totTransPlnDate
	 */
	public void setTotTransPlnDate(String totTransPlnDate) {
		this.totTransPlnDate = totTransPlnDate;
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
		setActCd(JSPUtil.getParameter(request, prefix + "act_cd", ""));
		setTotTransDts(JSPUtil.getParameter(request, prefix + "tot_trans_dts", ""));
		setDlvPlnDate(JSPUtil.getParameter(request, prefix + "dlv_pln_date", ""));
		setStsNm(JSPUtil.getParameter(request, prefix + "sts_nm", ""));
		setDlvEstmDate(JSPUtil.getParameter(request, prefix + "dlv_estm_date", ""));
		setObDorArrDt(JSPUtil.getParameter(request, prefix + "ob_dor_arr_dt", ""));
		setDlvDts(JSPUtil.getParameter(request, prefix + "dlv_dts", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDeDueDt(JSPUtil.getParameter(request, prefix + "de_due_dt", ""));
		setTotTransEstmDate(JSPUtil.getParameter(request, prefix + "tot_trans_estm_date", ""));
		setApntDt(JSPUtil.getParameter(request, prefix + "apnt_dt", ""));
		setCopSubStsCd(JSPUtil.getParameter(request, prefix + "cop_sub_sts_cd", ""));
		setCopStsCd(JSPUtil.getParameter(request, prefix + "cop_sts_cd", ""));
		setTotTransPlnDate(JSPUtil.getParameter(request, prefix + "tot_trans_pln_date", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCOPDetailDtInfoVO[]
	 */
	public SearchCOPDetailDtInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCOPDetailDtInfoVO[]
	 */
	public SearchCOPDetailDtInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCOPDetailDtInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] actCd = (JSPUtil.getParameter(request, prefix	+ "act_cd", length));
			String[] totTransDts = (JSPUtil.getParameter(request, prefix	+ "tot_trans_dts", length));
			String[] dlvPlnDate = (JSPUtil.getParameter(request, prefix	+ "dlv_pln_date", length));
			String[] stsNm = (JSPUtil.getParameter(request, prefix	+ "sts_nm", length));
			String[] dlvEstmDate = (JSPUtil.getParameter(request, prefix	+ "dlv_estm_date", length));
			String[] obDorArrDt = (JSPUtil.getParameter(request, prefix	+ "ob_dor_arr_dt", length));
			String[] dlvDts = (JSPUtil.getParameter(request, prefix	+ "dlv_dts", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] deDueDt = (JSPUtil.getParameter(request, prefix	+ "de_due_dt", length));
			String[] totTransEstmDate = (JSPUtil.getParameter(request, prefix	+ "tot_trans_estm_date", length));
			String[] apntDt = (JSPUtil.getParameter(request, prefix	+ "apnt_dt", length));
			String[] copSubStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_sub_sts_cd", length));
			String[] copStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_sts_cd", length));
			String[] totTransPlnDate = (JSPUtil.getParameter(request, prefix	+ "tot_trans_pln_date", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCOPDetailDtInfoVO();
				if (actCd[i] != null)
					model.setActCd(actCd[i]);
				if (totTransDts[i] != null)
					model.setTotTransDts(totTransDts[i]);
				if (dlvPlnDate[i] != null)
					model.setDlvPlnDate(dlvPlnDate[i]);
				if (stsNm[i] != null)
					model.setStsNm(stsNm[i]);
				if (dlvEstmDate[i] != null)
					model.setDlvEstmDate(dlvEstmDate[i]);
				if (obDorArrDt[i] != null)
					model.setObDorArrDt(obDorArrDt[i]);
				if (dlvDts[i] != null)
					model.setDlvDts(dlvDts[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (deDueDt[i] != null)
					model.setDeDueDt(deDueDt[i]);
				if (totTransEstmDate[i] != null)
					model.setTotTransEstmDate(totTransEstmDate[i]);
				if (apntDt[i] != null)
					model.setApntDt(apntDt[i]);
				if (copSubStsCd[i] != null)
					model.setCopSubStsCd(copSubStsCd[i]);
				if (copStsCd[i] != null)
					model.setCopStsCd(copStsCd[i]);
				if (totTransPlnDate[i] != null)
					model.setTotTransPlnDate(totTransPlnDate[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCOPDetailDtInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCOPDetailDtInfoVO[]
	 */
	public SearchCOPDetailDtInfoVO[] getSearchCOPDetailDtInfoVOs(){
		SearchCOPDetailDtInfoVO[] vos = (SearchCOPDetailDtInfoVO[])models.toArray(new SearchCOPDetailDtInfoVO[models.size()]);
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
		this.actCd = this.actCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totTransDts = this.totTransDts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlvPlnDate = this.dlvPlnDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsNm = this.stsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlvEstmDate = this.dlvEstmDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obDorArrDt = this.obDorArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlvDts = this.dlvDts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deDueDt = this.deDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totTransEstmDate = this.totTransEstmDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apntDt = this.apntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copSubStsCd = this.copSubStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copStsCd = this.copStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totTransPlnDate = this.totTransPlnDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
