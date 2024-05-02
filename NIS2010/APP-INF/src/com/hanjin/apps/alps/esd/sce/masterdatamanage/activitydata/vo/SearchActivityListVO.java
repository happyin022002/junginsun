/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchActivityListVO.java
*@FileTitle : SearchActivityListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.10.06 오현경 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.vo;

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

public class SearchActivityListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchActivityListVO> models = new ArrayList<SearchActivityListVO>();
	
	/* Column Info */
	private String actCd = null;
	/* Column Info */
	private String bzcVisFlg = null;
	/* Column Info */
	private String actTpNm = null;
	/* Column Info */
	private String custVisFlg = null;
	/* Column Info */
	private String actStsMapgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actFlg = null;
	/* Column Info */
	private String actNm = null;
	/* Column Info */
	private String vndrEvTolHrs = null;
	/* Column Info */
	private String actStndEdiStsCd = null;
	/* Column Info */
	private String vndrEvSvcCateCd = null;
	/* Column Info */
	private String copSkdLgcNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchActivityListVO() {}

	public SearchActivityListVO(String ibflag, String pagerows, String actTpNm, String actCd, String actNm, String copSkdLgcNo, String actStsMapgCd, String actStndEdiStsCd, String custVisFlg, String vndrEvTolHrs, String vndrEvSvcCateCd, String bzcVisFlg, String actFlg) {
		this.actCd = actCd;
		this.bzcVisFlg = bzcVisFlg;
		this.actTpNm = actTpNm;
		this.custVisFlg = custVisFlg;
		this.actStsMapgCd = actStsMapgCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.actFlg = actFlg;
		this.actNm = actNm;
		this.vndrEvTolHrs = vndrEvTolHrs;
		this.actStndEdiStsCd = actStndEdiStsCd;
		this.vndrEvSvcCateCd = vndrEvSvcCateCd;
		this.copSkdLgcNo = copSkdLgcNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("act_cd", getActCd());
		this.hashColumns.put("bzc_vis_flg", getBzcVisFlg());
		this.hashColumns.put("act_tp_nm", getActTpNm());
		this.hashColumns.put("cust_vis_flg", getCustVisFlg());
		this.hashColumns.put("act_sts_mapg_cd", getActStsMapgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_flg", getActFlg());
		this.hashColumns.put("act_nm", getActNm());
		this.hashColumns.put("vndr_ev_tol_hrs", getVndrEvTolHrs());
		this.hashColumns.put("act_stnd_edi_sts_cd", getActStndEdiStsCd());
		this.hashColumns.put("vndr_ev_svc_cate_cd", getVndrEvSvcCateCd());
		this.hashColumns.put("cop_skd_lgc_no", getCopSkdLgcNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("act_cd", "actCd");
		this.hashFields.put("bzc_vis_flg", "bzcVisFlg");
		this.hashFields.put("act_tp_nm", "actTpNm");
		this.hashFields.put("cust_vis_flg", "custVisFlg");
		this.hashFields.put("act_sts_mapg_cd", "actStsMapgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_flg", "actFlg");
		this.hashFields.put("act_nm", "actNm");
		this.hashFields.put("vndr_ev_tol_hrs", "vndrEvTolHrs");
		this.hashFields.put("act_stnd_edi_sts_cd", "actStndEdiStsCd");
		this.hashFields.put("vndr_ev_svc_cate_cd", "vndrEvSvcCateCd");
		this.hashFields.put("cop_skd_lgc_no", "copSkdLgcNo");
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
	 * @return bzcVisFlg
	 */
	public String getBzcVisFlg() {
		return this.bzcVisFlg;
	}
	
	/**
	 * Column Info
	 * @return actTpNm
	 */
	public String getActTpNm() {
		return this.actTpNm;
	}
	
	/**
	 * Column Info
	 * @return custVisFlg
	 */
	public String getCustVisFlg() {
		return this.custVisFlg;
	}
	
	/**
	 * Column Info
	 * @return actStsMapgCd
	 */
	public String getActStsMapgCd() {
		return this.actStsMapgCd;
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
	 * @return actFlg
	 */
	public String getActFlg() {
		return this.actFlg;
	}
	
	/**
	 * Column Info
	 * @return actNm
	 */
	public String getActNm() {
		return this.actNm;
	}
	
	/**
	 * Column Info
	 * @return vndrEvTolHrs
	 */
	public String getVndrEvTolHrs() {
		return this.vndrEvTolHrs;
	}
	
	/**
	 * Column Info
	 * @return actStndEdiStsCd
	 */
	public String getActStndEdiStsCd() {
		return this.actStndEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @return vndrEvSvcCateCd
	 */
	public String getVndrEvSvcCateCd() {
		return this.vndrEvSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @return copSkdLgcNo
	 */
	public String getCopSkdLgcNo() {
		return this.copSkdLgcNo;
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
	 * @param bzcVisFlg
	 */
	public void setBzcVisFlg(String bzcVisFlg) {
		this.bzcVisFlg = bzcVisFlg;
	}
	
	/**
	 * Column Info
	 * @param actTpNm
	 */
	public void setActTpNm(String actTpNm) {
		this.actTpNm = actTpNm;
	}
	
	/**
	 * Column Info
	 * @param custVisFlg
	 */
	public void setCustVisFlg(String custVisFlg) {
		this.custVisFlg = custVisFlg;
	}
	
	/**
	 * Column Info
	 * @param actStsMapgCd
	 */
	public void setActStsMapgCd(String actStsMapgCd) {
		this.actStsMapgCd = actStsMapgCd;
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
	 * @param actFlg
	 */
	public void setActFlg(String actFlg) {
		this.actFlg = actFlg;
	}
	
	/**
	 * Column Info
	 * @param actNm
	 */
	public void setActNm(String actNm) {
		this.actNm = actNm;
	}
	
	/**
	 * Column Info
	 * @param vndrEvTolHrs
	 */
	public void setVndrEvTolHrs(String vndrEvTolHrs) {
		this.vndrEvTolHrs = vndrEvTolHrs;
	}
	
	/**
	 * Column Info
	 * @param actStndEdiStsCd
	 */
	public void setActStndEdiStsCd(String actStndEdiStsCd) {
		this.actStndEdiStsCd = actStndEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @param vndrEvSvcCateCd
	 */
	public void setVndrEvSvcCateCd(String vndrEvSvcCateCd) {
		this.vndrEvSvcCateCd = vndrEvSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @param copSkdLgcNo
	 */
	public void setCopSkdLgcNo(String copSkdLgcNo) {
		this.copSkdLgcNo = copSkdLgcNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setActCd(JSPUtil.getParameter(request, "act_cd", ""));
		setBzcVisFlg(JSPUtil.getParameter(request, "bzc_vis_flg", ""));
		setActTpNm(JSPUtil.getParameter(request, "act_tp_nm", ""));
		setCustVisFlg(JSPUtil.getParameter(request, "cust_vis_flg", ""));
		setActStsMapgCd(JSPUtil.getParameter(request, "act_sts_mapg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setActFlg(JSPUtil.getParameter(request, "act_flg", ""));
		setActNm(JSPUtil.getParameter(request, "act_nm", ""));
		setVndrEvTolHrs(JSPUtil.getParameter(request, "vndr_ev_tol_hrs", ""));
		setActStndEdiStsCd(JSPUtil.getParameter(request, "act_stnd_edi_sts_cd", ""));
		setVndrEvSvcCateCd(JSPUtil.getParameter(request, "vndr_ev_svc_cate_cd", ""));
		setCopSkdLgcNo(JSPUtil.getParameter(request, "cop_skd_lgc_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchActivityListVO[]
	 */
	public SearchActivityListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchActivityListVO[]
	 */
	public SearchActivityListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchActivityListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] actCd = (JSPUtil.getParameter(request, prefix	+ "act_cd", length));
			String[] bzcVisFlg = (JSPUtil.getParameter(request, prefix	+ "bzc_vis_flg", length));
			String[] actTpNm = (JSPUtil.getParameter(request, prefix	+ "act_tp_nm", length));
			String[] custVisFlg = (JSPUtil.getParameter(request, prefix	+ "cust_vis_flg", length));
			String[] actStsMapgCd = (JSPUtil.getParameter(request, prefix	+ "act_sts_mapg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actFlg = (JSPUtil.getParameter(request, prefix	+ "act_flg", length));
			String[] actNm = (JSPUtil.getParameter(request, prefix	+ "act_nm", length));
			String[] vndrEvTolHrs = (JSPUtil.getParameter(request, prefix	+ "vndr_ev_tol_hrs", length));
			String[] actStndEdiStsCd = (JSPUtil.getParameter(request, prefix	+ "act_stnd_edi_sts_cd", length));
			String[] vndrEvSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "vndr_ev_svc_cate_cd", length));
			String[] copSkdLgcNo = (JSPUtil.getParameter(request, prefix	+ "cop_skd_lgc_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchActivityListVO();
				if (actCd[i] != null)
					model.setActCd(actCd[i]);
				if (bzcVisFlg[i] != null)
					model.setBzcVisFlg(bzcVisFlg[i]);
				if (actTpNm[i] != null)
					model.setActTpNm(actTpNm[i]);
				if (custVisFlg[i] != null)
					model.setCustVisFlg(custVisFlg[i]);
				if (actStsMapgCd[i] != null)
					model.setActStsMapgCd(actStsMapgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actFlg[i] != null)
					model.setActFlg(actFlg[i]);
				if (actNm[i] != null)
					model.setActNm(actNm[i]);
				if (vndrEvTolHrs[i] != null)
					model.setVndrEvTolHrs(vndrEvTolHrs[i]);
				if (actStndEdiStsCd[i] != null)
					model.setActStndEdiStsCd(actStndEdiStsCd[i]);
				if (vndrEvSvcCateCd[i] != null)
					model.setVndrEvSvcCateCd(vndrEvSvcCateCd[i]);
				if (copSkdLgcNo[i] != null)
					model.setCopSkdLgcNo(copSkdLgcNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchActivityListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchActivityListVO[]
	 */
	public SearchActivityListVO[] getSearchActivityListVOs(){
		SearchActivityListVO[] vos = (SearchActivityListVO[])models.toArray(new SearchActivityListVO[models.size()]);
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
		this.bzcVisFlg = this.bzcVisFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actTpNm = this.actTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custVisFlg = this.custVisFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStsMapgCd = this.actStsMapgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFlg = this.actFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actNm = this.actNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrEvTolHrs = this.vndrEvTolHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStndEdiStsCd = this.actStndEdiStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrEvSvcCateCd = this.vndrEvSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copSkdLgcNo = this.copSkdLgcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
