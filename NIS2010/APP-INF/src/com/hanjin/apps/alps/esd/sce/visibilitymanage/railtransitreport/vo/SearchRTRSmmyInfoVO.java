/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchRTRSmmyInfoVO.java
*@FileTitle : SearchRTRSmmyInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.08  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchRTRSmmyInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchRTRSmmyInfoVO> models = new ArrayList<SearchRTRSmmyInfoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cFmNodCd = null;
	/* Column Info */
	private String cToNodCd = null;
	/* Column Info */
	private String cTrspBndCd = null;
	/* Column Info */
	private String cCgoTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchRTRSmmyInfoVO() {}

	public SearchRTRSmmyInfoVO(String ibflag, String pagerows, String cFmNodCd, String cToNodCd, String cCgoTpCd, String cTrspBndCd) {
		this.ibflag = ibflag;
		this.cFmNodCd = cFmNodCd;
		this.cToNodCd = cToNodCd;
		this.cTrspBndCd = cTrspBndCd;
		this.cCgoTpCd = cCgoTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("c_fm_nod_cd", getCFmNodCd());
		this.hashColumns.put("c_to_nod_cd", getCToNodCd());
		this.hashColumns.put("c_trsp_bnd_cd", getCTrspBndCd());
		this.hashColumns.put("c_cgo_tp_cd", getCCgoTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("c_fm_nod_cd", "cFmNodCd");
		this.hashFields.put("c_to_nod_cd", "cToNodCd");
		this.hashFields.put("c_trsp_bnd_cd", "cTrspBndCd");
		this.hashFields.put("c_cgo_tp_cd", "cCgoTpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return cFmNodCd
	 */
	public String getCFmNodCd() {
		return this.cFmNodCd;
	}
	
	/**
	 * Column Info
	 * @return cToNodCd
	 */
	public String getCToNodCd() {
		return this.cToNodCd;
	}
	
	/**
	 * Column Info
	 * @return cTrspBndCd
	 */
	public String getCTrspBndCd() {
		return this.cTrspBndCd;
	}
	
	/**
	 * Column Info
	 * @return cCgoTpCd
	 */
	public String getCCgoTpCd() {
		return this.cCgoTpCd;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param cFmNodCd
	 */
	public void setCFmNodCd(String cFmNodCd) {
		this.cFmNodCd = cFmNodCd;
	}
	
	/**
	 * Column Info
	 * @param cToNodCd
	 */
	public void setCToNodCd(String cToNodCd) {
		this.cToNodCd = cToNodCd;
	}
	
	/**
	 * Column Info
	 * @param cTrspBndCd
	 */
	public void setCTrspBndCd(String cTrspBndCd) {
		this.cTrspBndCd = cTrspBndCd;
	}
	
	/**
	 * Column Info
	 * @param cCgoTpCd
	 */
	public void setCCgoTpCd(String cCgoTpCd) {
		this.cCgoTpCd = cCgoTpCd;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCFmNodCd(JSPUtil.getParameter(request, prefix + "c_fm_nod_cd", ""));
		setCToNodCd(JSPUtil.getParameter(request, prefix + "c_to_nod_cd", ""));
		setCTrspBndCd(JSPUtil.getParameter(request, prefix + "c_trsp_bnd_cd", ""));
		setCCgoTpCd(JSPUtil.getParameter(request, prefix + "c_cgo_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRTRSmmyInfoVO[]
	 */
	public SearchRTRSmmyInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRTRSmmyInfoVO[]
	 */
	public SearchRTRSmmyInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRTRSmmyInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cFmNodCd = (JSPUtil.getParameter(request, prefix	+ "c_fm_nod_cd", length));
			String[] cToNodCd = (JSPUtil.getParameter(request, prefix	+ "c_to_nod_cd", length));
			String[] cTrspBndCd = (JSPUtil.getParameter(request, prefix	+ "c_trsp_bnd_cd", length));
			String[] cCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "c_cgo_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchRTRSmmyInfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cFmNodCd[i] != null)
					model.setCFmNodCd(cFmNodCd[i]);
				if (cToNodCd[i] != null)
					model.setCToNodCd(cToNodCd[i]);
				if (cTrspBndCd[i] != null)
					model.setCTrspBndCd(cTrspBndCd[i]);
				if (cCgoTpCd[i] != null)
					model.setCCgoTpCd(cCgoTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRTRSmmyInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchRTRSmmyInfoVO[]
	 */
	public SearchRTRSmmyInfoVO[] getSearchRTRSmmyInfoVOs(){
		SearchRTRSmmyInfoVO[] vos = (SearchRTRSmmyInfoVO[])models.toArray(new SearchRTRSmmyInfoVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cFmNodCd = this.cFmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cToNodCd = this.cToNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cTrspBndCd = this.cTrspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCgoTpCd = this.cCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
