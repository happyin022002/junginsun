/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchNWCreRStatusListVO.java
*@FileTitle : SearchNWCreRStatusListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.06  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchNWCreRStatusListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchNWCreRStatusListVO> models = new ArrayList<SearchNWCreRStatusListVO>();
	
	/* Column Info */
	private String creSlctFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vopCd = null;
	/* Column Info */
	private String vslOshpCd = null;
	/* Column Info */
	private String creStsCd = null;
	/* Column Info */
	private String stndCostNm = null;
	/* Column Info */
	private String stndCostCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchNWCreRStatusListVO() {}

	public SearchNWCreRStatusListVO(String ibflag, String pagerows, String stndCostCd, String stndCostNm, String vslOshpCd, String vopCd, String creStsCd, String creSlctFlg) {
		this.creSlctFlg = creSlctFlg;
		this.ibflag = ibflag;
		this.vopCd = vopCd;
		this.vslOshpCd = vslOshpCd;
		this.creStsCd = creStsCd;
		this.stndCostNm = stndCostNm;
		this.stndCostCd = stndCostCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_slct_flg", getCreSlctFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vop_cd", getVopCd());
		this.hashColumns.put("vsl_oshp_cd", getVslOshpCd());
		this.hashColumns.put("cre_sts_cd", getCreStsCd());
		this.hashColumns.put("stnd_cost_nm", getStndCostNm());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_slct_flg", "creSlctFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vop_cd", "vopCd");
		this.hashFields.put("vsl_oshp_cd", "vslOshpCd");
		this.hashFields.put("cre_sts_cd", "creStsCd");
		this.hashFields.put("stnd_cost_nm", "stndCostNm");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return creSlctFlg
	 */
	public String getCreSlctFlg() {
		return this.creSlctFlg;
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
	 * @return vopCd
	 */
	public String getVopCd() {
		return this.vopCd;
	}
	
	/**
	 * Column Info
	 * @return vslOshpCd
	 */
	public String getVslOshpCd() {
		return this.vslOshpCd;
	}
	
	/**
	 * Column Info
	 * @return creStsCd
	 */
	public String getCreStsCd() {
		return this.creStsCd;
	}
	
	/**
	 * Column Info
	 * @return stndCostNm
	 */
	public String getStndCostNm() {
		return this.stndCostNm;
	}
	
	/**
	 * Column Info
	 * @return stndCostCd
	 */
	public String getStndCostCd() {
		return this.stndCostCd;
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
	 * @param creSlctFlg
	 */
	public void setCreSlctFlg(String creSlctFlg) {
		this.creSlctFlg = creSlctFlg;
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
	 * @param vopCd
	 */
	public void setVopCd(String vopCd) {
		this.vopCd = vopCd;
	}
	
	/**
	 * Column Info
	 * @param vslOshpCd
	 */
	public void setVslOshpCd(String vslOshpCd) {
		this.vslOshpCd = vslOshpCd;
	}
	
	/**
	 * Column Info
	 * @param creStsCd
	 */
	public void setCreStsCd(String creStsCd) {
		this.creStsCd = creStsCd;
	}
	
	/**
	 * Column Info
	 * @param stndCostNm
	 */
	public void setStndCostNm(String stndCostNm) {
		this.stndCostNm = stndCostNm;
	}
	
	/**
	 * Column Info
	 * @param stndCostCd
	 */
	public void setStndCostCd(String stndCostCd) {
		this.stndCostCd = stndCostCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCreSlctFlg(JSPUtil.getParameter(request, "cre_slct_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVopCd(JSPUtil.getParameter(request, "vop_cd", ""));
		setVslOshpCd(JSPUtil.getParameter(request, "vsl_oshp_cd", ""));
		setCreStsCd(JSPUtil.getParameter(request, "cre_sts_cd", ""));
		setStndCostNm(JSPUtil.getParameter(request, "stnd_cost_nm", ""));
		setStndCostCd(JSPUtil.getParameter(request, "stnd_cost_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchNWCreRStatusListVO[]
	 */
	public SearchNWCreRStatusListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchNWCreRStatusListVO[]
	 */
	public SearchNWCreRStatusListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchNWCreRStatusListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creSlctFlg = (JSPUtil.getParameter(request, prefix	+ "cre_slct_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vopCd = (JSPUtil.getParameter(request, prefix	+ "vop_cd", length));
			String[] vslOshpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_oshp_cd", length));
			String[] creStsCd = (JSPUtil.getParameter(request, prefix	+ "cre_sts_cd", length));
			String[] stndCostNm = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_nm", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchNWCreRStatusListVO();
				if (creSlctFlg[i] != null)
					model.setCreSlctFlg(creSlctFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vopCd[i] != null)
					model.setVopCd(vopCd[i]);
				if (vslOshpCd[i] != null)
					model.setVslOshpCd(vslOshpCd[i]);
				if (creStsCd[i] != null)
					model.setCreStsCd(creStsCd[i]);
				if (stndCostNm[i] != null)
					model.setStndCostNm(stndCostNm[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchNWCreRStatusListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchNWCreRStatusListVO[]
	 */
	public SearchNWCreRStatusListVO[] getSearchNWCreRStatusListVOs(){
		SearchNWCreRStatusListVO[] vos = (SearchNWCreRStatusListVO[])models.toArray(new SearchNWCreRStatusListVO[models.size()]);
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
		this.creSlctFlg = this.creSlctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopCd = this.vopCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOshpCd = this.vslOshpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creStsCd = this.creStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostNm = this.stndCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
