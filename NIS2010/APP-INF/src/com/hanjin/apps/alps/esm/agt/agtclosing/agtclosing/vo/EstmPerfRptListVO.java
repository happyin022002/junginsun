/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EstmPerfRptListVO.java
*@FileTitle : EstmPerfRptListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.18
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2010.11.18 이정수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.vo;

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
 * @author 이정수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EstmPerfRptListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EstmPerfRptListVO> models = new ArrayList<EstmPerfRptListVO>();
	
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String sRVvd = null;
	/* Column Info */
	private String revLaneCd = null;
	/* Column Info */
	private String sIeFlg = null;
	/* Column Info */
	private String revYrmonCd = null;
	/* Column Info */
	private String searchDtTo = null;
	/* Column Info */
	private String sOoFlg = null;
	/* Column Info */
	private String estmTtl = null;
	/* Column Info */
	private String actTtl = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sImFlg = null;
	/* Column Info */
	private String sIaFlg = null;
	/* Column Info */
	private String revVvdCd = null;
	/* Column Info */
	private String searchDtFr = null;
	/* Column Info */
	private String vvdTpCd = null;
	/* Column Info */
	private String acclTtl = null;
	/* Column Info */
	private String sXxFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EstmPerfRptListVO() {}

	public EstmPerfRptListVO(String ibflag, String pagerows, String searchDtFr, String searchDtTo, String sRVvd, String sIaFlg, String sIeFlg, String sImFlg, String sOoFlg, String sXxFlg, String revYrmonCd, String revVvdCd, String iocCd, String revLaneCd, String vvdTpCd, String estmTtl, String actTtl, String acclTtl) {
		this.iocCd = iocCd;
		this.sRVvd = sRVvd;
		this.revLaneCd = revLaneCd;
		this.sIeFlg = sIeFlg;
		this.revYrmonCd = revYrmonCd;
		this.searchDtTo = searchDtTo;
		this.sOoFlg = sOoFlg;
		this.estmTtl = estmTtl;
		this.actTtl = actTtl;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.sImFlg = sImFlg;
		this.sIaFlg = sIaFlg;
		this.revVvdCd = revVvdCd;
		this.searchDtFr = searchDtFr;
		this.vvdTpCd = vvdTpCd;
		this.acclTtl = acclTtl;
		this.sXxFlg = sXxFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("s_r_vvd", getSRVvd());
		this.hashColumns.put("rev_lane_cd", getRevLaneCd());
		this.hashColumns.put("s_ie_flg", getSIeFlg());
		this.hashColumns.put("rev_yrmon_cd", getRevYrmonCd());
		this.hashColumns.put("search_dt_to", getSearchDtTo());
		this.hashColumns.put("s_oo_flg", getSOoFlg());
		this.hashColumns.put("estm_ttl", getEstmTtl());
		this.hashColumns.put("act_ttl", getActTtl());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_im_flg", getSImFlg());
		this.hashColumns.put("s_ia_flg", getSIaFlg());
		this.hashColumns.put("rev_vvd_cd", getRevVvdCd());
		this.hashColumns.put("search_dt_fr", getSearchDtFr());
		this.hashColumns.put("vvd_tp_cd", getVvdTpCd());
		this.hashColumns.put("accl_ttl", getAcclTtl());
		this.hashColumns.put("s_xx_flg", getSXxFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("s_r_vvd", "sRVvd");
		this.hashFields.put("rev_lane_cd", "revLaneCd");
		this.hashFields.put("s_ie_flg", "sIeFlg");
		this.hashFields.put("rev_yrmon_cd", "revYrmonCd");
		this.hashFields.put("search_dt_to", "searchDtTo");
		this.hashFields.put("s_oo_flg", "sOoFlg");
		this.hashFields.put("estm_ttl", "estmTtl");
		this.hashFields.put("act_ttl", "actTtl");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_im_flg", "sImFlg");
		this.hashFields.put("s_ia_flg", "sIaFlg");
		this.hashFields.put("rev_vvd_cd", "revVvdCd");
		this.hashFields.put("search_dt_fr", "searchDtFr");
		this.hashFields.put("vvd_tp_cd", "vvdTpCd");
		this.hashFields.put("accl_ttl", "acclTtl");
		this.hashFields.put("s_xx_flg", "sXxFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return sRVvd
	 */
	public String getSRVvd() {
		return this.sRVvd;
	}
	
	/**
	 * Column Info
	 * @return revLaneCd
	 */
	public String getRevLaneCd() {
		return this.revLaneCd;
	}
	
	/**
	 * Column Info
	 * @return sIeFlg
	 */
	public String getSIeFlg() {
		return this.sIeFlg;
	}
	
	/**
	 * Column Info
	 * @return revYrmonCd
	 */
	public String getRevYrmonCd() {
		return this.revYrmonCd;
	}
	
	/**
	 * Column Info
	 * @return searchDtTo
	 */
	public String getSearchDtTo() {
		return this.searchDtTo;
	}
	
	/**
	 * Column Info
	 * @return sOoFlg
	 */
	public String getSOoFlg() {
		return this.sOoFlg;
	}
	
	/**
	 * Column Info
	 * @return estmTtl
	 */
	public String getEstmTtl() {
		return this.estmTtl;
	}
	
	/**
	 * Column Info
	 * @return actTtl
	 */
	public String getActTtl() {
		return this.actTtl;
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
	 * @return sImFlg
	 */
	public String getSImFlg() {
		return this.sImFlg;
	}
	
	/**
	 * Column Info
	 * @return sIaFlg
	 */
	public String getSIaFlg() {
		return this.sIaFlg;
	}
	
	/**
	 * Column Info
	 * @return revVvdCd
	 */
	public String getRevVvdCd() {
		return this.revVvdCd;
	}
	
	/**
	 * Column Info
	 * @return searchDtFr
	 */
	public String getSearchDtFr() {
		return this.searchDtFr;
	}
	
	/**
	 * Column Info
	 * @return vvdTpCd
	 */
	public String getVvdTpCd() {
		return this.vvdTpCd;
	}
	
	/**
	 * Column Info
	 * @return acclTtl
	 */
	public String getAcclTtl() {
		return this.acclTtl;
	}
	
	/**
	 * Column Info
	 * @return sXxFlg
	 */
	public String getSXxFlg() {
		return this.sXxFlg;
	}
	

	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param sRVvd
	 */
	public void setSRVvd(String sRVvd) {
		this.sRVvd = sRVvd;
	}
	
	/**
	 * Column Info
	 * @param revLaneCd
	 */
	public void setRevLaneCd(String revLaneCd) {
		this.revLaneCd = revLaneCd;
	}
	
	/**
	 * Column Info
	 * @param sIeFlg
	 */
	public void setSIeFlg(String sIeFlg) {
		this.sIeFlg = sIeFlg;
	}
	
	/**
	 * Column Info
	 * @param revYrmonCd
	 */
	public void setRevYrmonCd(String revYrmonCd) {
		this.revYrmonCd = revYrmonCd;
	}
	
	/**
	 * Column Info
	 * @param searchDtTo
	 */
	public void setSearchDtTo(String searchDtTo) {
		this.searchDtTo = searchDtTo;
	}
	
	/**
	 * Column Info
	 * @param sOoFlg
	 */
	public void setSOoFlg(String sOoFlg) {
		this.sOoFlg = sOoFlg;
	}
	
	/**
	 * Column Info
	 * @param estmTtl
	 */
	public void setEstmTtl(String estmTtl) {
		this.estmTtl = estmTtl;
	}
	
	/**
	 * Column Info
	 * @param actTtl
	 */
	public void setActTtl(String actTtl) {
		this.actTtl = actTtl;
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
	 * @param sImFlg
	 */
	public void setSImFlg(String sImFlg) {
		this.sImFlg = sImFlg;
	}
	
	/**
	 * Column Info
	 * @param sIaFlg
	 */
	public void setSIaFlg(String sIaFlg) {
		this.sIaFlg = sIaFlg;
	}
	
	/**
	 * Column Info
	 * @param revVvdCd
	 */
	public void setRevVvdCd(String revVvdCd) {
		this.revVvdCd = revVvdCd;
	}
	
	/**
	 * Column Info
	 * @param searchDtFr
	 */
	public void setSearchDtFr(String searchDtFr) {
		this.searchDtFr = searchDtFr;
	}
	
	/**
	 * Column Info
	 * @param vvdTpCd
	 */
	public void setVvdTpCd(String vvdTpCd) {
		this.vvdTpCd = vvdTpCd;
	}
	
	/**
	 * Column Info
	 * @param acclTtl
	 */
	public void setAcclTtl(String acclTtl) {
		this.acclTtl = acclTtl;
	}
	
	/**
	 * Column Info
	 * @param sXxFlg
	 */
	public void setSXxFlg(String sXxFlg) {
		this.sXxFlg = sXxFlg;
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
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setSRVvd(JSPUtil.getParameter(request, prefix + "s_r_vvd", ""));
		setRevLaneCd(JSPUtil.getParameter(request, prefix + "rev_lane_cd", ""));
		setSIeFlg(JSPUtil.getParameter(request, prefix + "s_ie_flg", ""));
		setRevYrmonCd(JSPUtil.getParameter(request, prefix + "rev_yrmon_cd", ""));
		setSearchDtTo(JSPUtil.getParameter(request, prefix + "search_dt_to", ""));
		setSOoFlg(JSPUtil.getParameter(request, prefix + "s_oo_flg", ""));
		setEstmTtl(JSPUtil.getParameter(request, prefix + "estm_ttl", ""));
		setActTtl(JSPUtil.getParameter(request, prefix + "act_ttl", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSImFlg(JSPUtil.getParameter(request, prefix + "s_im_flg", ""));
		setSIaFlg(JSPUtil.getParameter(request, prefix + "s_ia_flg", ""));
		setRevVvdCd(JSPUtil.getParameter(request, prefix + "rev_vvd_cd", ""));
		setSearchDtFr(JSPUtil.getParameter(request, prefix + "search_dt_fr", ""));
		setVvdTpCd(JSPUtil.getParameter(request, prefix + "vvd_tp_cd", ""));
		setAcclTtl(JSPUtil.getParameter(request, prefix + "accl_ttl", ""));
		setSXxFlg(JSPUtil.getParameter(request, prefix + "s_xx_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EstmPerfRptListVO[]
	 */
	public EstmPerfRptListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EstmPerfRptListVO[]
	 */
	public EstmPerfRptListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EstmPerfRptListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] sRVvd = (JSPUtil.getParameter(request, prefix	+ "s_r_vvd", length));
			String[] revLaneCd = (JSPUtil.getParameter(request, prefix	+ "rev_lane_cd", length));
			String[] sIeFlg = (JSPUtil.getParameter(request, prefix	+ "s_ie_flg", length));
			String[] revYrmonCd = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon_cd", length));
			String[] searchDtTo = (JSPUtil.getParameter(request, prefix	+ "search_dt_to", length));
			String[] sOoFlg = (JSPUtil.getParameter(request, prefix	+ "s_oo_flg", length));
			String[] estmTtl = (JSPUtil.getParameter(request, prefix	+ "estm_ttl", length));
			String[] actTtl = (JSPUtil.getParameter(request, prefix	+ "act_ttl", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sImFlg = (JSPUtil.getParameter(request, prefix	+ "s_im_flg", length));
			String[] sIaFlg = (JSPUtil.getParameter(request, prefix	+ "s_ia_flg", length));
			String[] revVvdCd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd_cd", length));
			String[] searchDtFr = (JSPUtil.getParameter(request, prefix	+ "search_dt_fr", length));
			String[] vvdTpCd = (JSPUtil.getParameter(request, prefix	+ "vvd_tp_cd", length));
			String[] acclTtl = (JSPUtil.getParameter(request, prefix	+ "accl_ttl", length));
			String[] sXxFlg = (JSPUtil.getParameter(request, prefix	+ "s_xx_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new EstmPerfRptListVO();
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (sRVvd[i] != null)
					model.setSRVvd(sRVvd[i]);
				if (revLaneCd[i] != null)
					model.setRevLaneCd(revLaneCd[i]);
				if (sIeFlg[i] != null)
					model.setSIeFlg(sIeFlg[i]);
				if (revYrmonCd[i] != null)
					model.setRevYrmonCd(revYrmonCd[i]);
				if (searchDtTo[i] != null)
					model.setSearchDtTo(searchDtTo[i]);
				if (sOoFlg[i] != null)
					model.setSOoFlg(sOoFlg[i]);
				if (estmTtl[i] != null)
					model.setEstmTtl(estmTtl[i]);
				if (actTtl[i] != null)
					model.setActTtl(actTtl[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sImFlg[i] != null)
					model.setSImFlg(sImFlg[i]);
				if (sIaFlg[i] != null)
					model.setSIaFlg(sIaFlg[i]);
				if (revVvdCd[i] != null)
					model.setRevVvdCd(revVvdCd[i]);
				if (searchDtFr[i] != null)
					model.setSearchDtFr(searchDtFr[i]);
				if (vvdTpCd[i] != null)
					model.setVvdTpCd(vvdTpCd[i]);
				if (acclTtl[i] != null)
					model.setAcclTtl(acclTtl[i]);
				if (sXxFlg[i] != null)
					model.setSXxFlg(sXxFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEstmPerfRptListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EstmPerfRptListVO[]
	 */
	public EstmPerfRptListVO[] getEstmPerfRptListVOs(){
		EstmPerfRptListVO[] vos = (EstmPerfRptListVO[])models.toArray(new EstmPerfRptListVO[models.size()]);
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
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRVvd = this.sRVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revLaneCd = this.revLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIeFlg = this.sIeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmonCd = this.revYrmonCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDtTo = this.searchDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOoFlg = this.sOoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmTtl = this.estmTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actTtl = this.actTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sImFlg = this.sImFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIaFlg = this.sIaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvdCd = this.revVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDtFr = this.searchDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdTpCd = this.vvdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclTtl = this.acclTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sXxFlg = this.sXxFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
