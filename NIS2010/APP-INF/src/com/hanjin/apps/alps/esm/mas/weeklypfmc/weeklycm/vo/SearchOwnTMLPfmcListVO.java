/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchOwnTMLPfmcListVO.java
*@FileTitle : SearchOwnTMLPfmcListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.15
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.07.15 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchOwnTMLPfmcListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOwnTMLPfmcListVO> models = new ArrayList<SearchOwnTMLPfmcListVO>();
	
	/* Column Info */
	private String masCostSrcCdNm = null;
	/* Column Info */
	private String tmlUtCd = null;
	/* Column Info */
	private String tmlUcAmt = null;
	/* Column Info */
	private String ucSlanCd = null;
	/* Column Info */
	private String masCostSrcCd = null;
	/* Column Info */
	private String tmlTrfItmCd = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String tmlCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String tmlTrfDtlCd = null;
	/* Column Info */
	private String tmlTrfDtlDesc = null;
	/* Column Info */
	private String tmlTrfItmDesc = null;
	/* Column Info */
	private String cntrTpszCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchOwnTMLPfmcListVO() {}

	public SearchOwnTMLPfmcListVO(String ibflag, String pagerows, String costYrmon, String tmlCd, String tmlTrfItmCd, String tmlTrfItmDesc, String tmlTrfDtlCd, String tmlTrfDtlDesc, String cntrTpszCd, String masCostSrcCd, String masCostSrcCdNm, String tmlUtCd, String loclCurrCd, String tmlUcAmt, String ucSlanCd) {
		this.masCostSrcCdNm = masCostSrcCdNm;
		this.tmlUtCd = tmlUtCd;
		this.tmlUcAmt = tmlUcAmt;
		this.ucSlanCd = ucSlanCd;
		this.masCostSrcCd = masCostSrcCd;
		this.tmlTrfItmCd = tmlTrfItmCd;
		this.loclCurrCd = loclCurrCd;
		this.tmlCd = tmlCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.tmlTrfDtlCd = tmlTrfDtlCd;
		this.tmlTrfDtlDesc = tmlTrfDtlDesc;
		this.tmlTrfItmDesc = tmlTrfItmDesc;
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mas_cost_src_cd_nm", getMasCostSrcCdNm());
		this.hashColumns.put("tml_ut_cd", getTmlUtCd());
		this.hashColumns.put("tml_uc_amt", getTmlUcAmt());
		this.hashColumns.put("uc_slan_cd", getUcSlanCd());
		this.hashColumns.put("mas_cost_src_cd", getMasCostSrcCd());
		this.hashColumns.put("tml_trf_itm_cd", getTmlTrfItmCd());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("tml_trf_dtl_cd", getTmlTrfDtlCd());
		this.hashColumns.put("tml_trf_dtl_desc", getTmlTrfDtlDesc());
		this.hashColumns.put("tml_trf_itm_desc", getTmlTrfItmDesc());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mas_cost_src_cd_nm", "masCostSrcCdNm");
		this.hashFields.put("tml_ut_cd", "tmlUtCd");
		this.hashFields.put("tml_uc_amt", "tmlUcAmt");
		this.hashFields.put("uc_slan_cd", "ucSlanCd");
		this.hashFields.put("mas_cost_src_cd", "masCostSrcCd");
		this.hashFields.put("tml_trf_itm_cd", "tmlTrfItmCd");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("tml_trf_dtl_cd", "tmlTrfDtlCd");
		this.hashFields.put("tml_trf_dtl_desc", "tmlTrfDtlDesc");
		this.hashFields.put("tml_trf_itm_desc", "tmlTrfItmDesc");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return masCostSrcCdNm
	 */
	public String getMasCostSrcCdNm() {
		return this.masCostSrcCdNm;
	}
	
	/**
	 * Column Info
	 * @return tmlUtCd
	 */
	public String getTmlUtCd() {
		return this.tmlUtCd;
	}
	
	/**
	 * Column Info
	 * @return tmlUcAmt
	 */
	public String getTmlUcAmt() {
		return this.tmlUcAmt;
	}
	
	/**
	 * Column Info
	 * @return ucSlanCd
	 */
	public String getUcSlanCd() {
		return this.ucSlanCd;
	}
	
	/**
	 * Column Info
	 * @return masCostSrcCd
	 */
	public String getMasCostSrcCd() {
		return this.masCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @return tmlTrfItmCd
	 */
	public String getTmlTrfItmCd() {
		return this.tmlTrfItmCd;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
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
	 * @return tmlTrfDtlCd
	 */
	public String getTmlTrfDtlCd() {
		return this.tmlTrfDtlCd;
	}
	
	/**
	 * Column Info
	 * @return tmlTrfDtlDesc
	 */
	public String getTmlTrfDtlDesc() {
		return this.tmlTrfDtlDesc;
	}
	
	/**
	 * Column Info
	 * @return tmlTrfItmDesc
	 */
	public String getTmlTrfItmDesc() {
		return this.tmlTrfItmDesc;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	

	/**
	 * Column Info
	 * @param masCostSrcCdNm
	 */
	public void setMasCostSrcCdNm(String masCostSrcCdNm) {
		this.masCostSrcCdNm = masCostSrcCdNm;
	}
	
	/**
	 * Column Info
	 * @param tmlUtCd
	 */
	public void setTmlUtCd(String tmlUtCd) {
		this.tmlUtCd = tmlUtCd;
	}
	
	/**
	 * Column Info
	 * @param tmlUcAmt
	 */
	public void setTmlUcAmt(String tmlUcAmt) {
		this.tmlUcAmt = tmlUcAmt;
	}
	
	/**
	 * Column Info
	 * @param ucSlanCd
	 */
	public void setUcSlanCd(String ucSlanCd) {
		this.ucSlanCd = ucSlanCd;
	}
	
	/**
	 * Column Info
	 * @param masCostSrcCd
	 */
	public void setMasCostSrcCd(String masCostSrcCd) {
		this.masCostSrcCd = masCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @param tmlTrfItmCd
	 */
	public void setTmlTrfItmCd(String tmlTrfItmCd) {
		this.tmlTrfItmCd = tmlTrfItmCd;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
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
	 * @param tmlTrfDtlCd
	 */
	public void setTmlTrfDtlCd(String tmlTrfDtlCd) {
		this.tmlTrfDtlCd = tmlTrfDtlCd;
	}
	
	/**
	 * Column Info
	 * @param tmlTrfDtlDesc
	 */
	public void setTmlTrfDtlDesc(String tmlTrfDtlDesc) {
		this.tmlTrfDtlDesc = tmlTrfDtlDesc;
	}
	
	/**
	 * Column Info
	 * @param tmlTrfItmDesc
	 */
	public void setTmlTrfItmDesc(String tmlTrfItmDesc) {
		this.tmlTrfItmDesc = tmlTrfItmDesc;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
		setMasCostSrcCdNm(JSPUtil.getParameter(request, prefix + "mas_cost_src_cd_nm", ""));
		setTmlUtCd(JSPUtil.getParameter(request, prefix + "tml_ut_cd", ""));
		setTmlUcAmt(JSPUtil.getParameter(request, prefix + "tml_uc_amt", ""));
		setUcSlanCd(JSPUtil.getParameter(request, prefix + "uc_slan_cd", ""));
		setMasCostSrcCd(JSPUtil.getParameter(request, prefix + "mas_cost_src_cd", ""));
		setTmlTrfItmCd(JSPUtil.getParameter(request, prefix + "tml_trf_itm_cd", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setTmlCd(JSPUtil.getParameter(request, prefix + "tml_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setTmlTrfDtlCd(JSPUtil.getParameter(request, prefix + "tml_trf_dtl_cd", ""));
		setTmlTrfDtlDesc(JSPUtil.getParameter(request, prefix + "tml_trf_dtl_desc", ""));
		setTmlTrfItmDesc(JSPUtil.getParameter(request, prefix + "tml_trf_itm_desc", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOwnTMLPfmcListVO[]
	 */
	public SearchOwnTMLPfmcListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOwnTMLPfmcListVO[]
	 */
	public SearchOwnTMLPfmcListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOwnTMLPfmcListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] masCostSrcCdNm = (JSPUtil.getParameter(request, prefix	+ "mas_cost_src_cd_nm", length));
			String[] tmlUtCd = (JSPUtil.getParameter(request, prefix	+ "tml_ut_cd", length));
			String[] tmlUcAmt = (JSPUtil.getParameter(request, prefix	+ "tml_uc_amt", length));
			String[] ucSlanCd = (JSPUtil.getParameter(request, prefix	+ "uc_slan_cd", length));
			String[] masCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "mas_cost_src_cd", length));
			String[] tmlTrfItmCd = (JSPUtil.getParameter(request, prefix	+ "tml_trf_itm_cd", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] tmlTrfDtlCd = (JSPUtil.getParameter(request, prefix	+ "tml_trf_dtl_cd", length));
			String[] tmlTrfDtlDesc = (JSPUtil.getParameter(request, prefix	+ "tml_trf_dtl_desc", length));
			String[] tmlTrfItmDesc = (JSPUtil.getParameter(request, prefix	+ "tml_trf_itm_desc", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOwnTMLPfmcListVO();
				if (masCostSrcCdNm[i] != null)
					model.setMasCostSrcCdNm(masCostSrcCdNm[i]);
				if (tmlUtCd[i] != null)
					model.setTmlUtCd(tmlUtCd[i]);
				if (tmlUcAmt[i] != null)
					model.setTmlUcAmt(tmlUcAmt[i]);
				if (ucSlanCd[i] != null)
					model.setUcSlanCd(ucSlanCd[i]);
				if (masCostSrcCd[i] != null)
					model.setMasCostSrcCd(masCostSrcCd[i]);
				if (tmlTrfItmCd[i] != null)
					model.setTmlTrfItmCd(tmlTrfItmCd[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (tmlTrfDtlCd[i] != null)
					model.setTmlTrfDtlCd(tmlTrfDtlCd[i]);
				if (tmlTrfDtlDesc[i] != null)
					model.setTmlTrfDtlDesc(tmlTrfDtlDesc[i]);
				if (tmlTrfItmDesc[i] != null)
					model.setTmlTrfItmDesc(tmlTrfItmDesc[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOwnTMLPfmcListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOwnTMLPfmcListVO[]
	 */
	public SearchOwnTMLPfmcListVO[] getSearchOwnTMLPfmcListVOs(){
		SearchOwnTMLPfmcListVO[] vos = (SearchOwnTMLPfmcListVO[])models.toArray(new SearchOwnTMLPfmcListVO[models.size()]);
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
		this.masCostSrcCdNm = this.masCostSrcCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlUtCd = this.tmlUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlUcAmt = this.tmlUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucSlanCd = this.ucSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masCostSrcCd = this.masCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlTrfItmCd = this.tmlTrfItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlTrfDtlCd = this.tmlTrfDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlTrfDtlDesc = this.tmlTrfDtlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlTrfItmDesc = this.tmlTrfItmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
