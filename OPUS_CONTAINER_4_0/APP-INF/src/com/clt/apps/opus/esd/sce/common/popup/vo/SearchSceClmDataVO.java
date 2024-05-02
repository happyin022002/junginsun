/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSceClmDataVO.java
*@FileTitle : SearchSceClmDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.09.09 이중환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.common.popup.vo;

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
 * @author 이중환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSceClmDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSceClmDataVO> models = new ArrayList<SearchSceClmDataVO>();
	
	/* Column Info */
	private String updDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String etaTp = null;
	/* Column Info */
	private String rr = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSceClmDataVO() {}

	public SearchSceClmDataVO(String ibflag, String pagerows, String cntrNo, String etaDt, String rr, String updDt, String etaTp) {
		this.updDt = updDt;
		this.ibflag = ibflag;
		this.etaDt = etaDt;
		this.cntrNo = cntrNo;
		this.etaTp = etaTp;
		this.rr = rr;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("eta_tp", getEtaTp());
		this.hashColumns.put("rr", getRr());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("eta_tp", "etaTp");
		this.hashFields.put("rr", "rr");
		this.hashFields.put("pagerows", "pagerows");
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return etaTp
	 */
	public String getEtaTp() {
		return this.etaTp;
	}
	
	/**
	 * Column Info
	 * @return rr
	 */
	public String getRr() {
		return this.rr;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param etaTp
	 */
	public void setEtaTp(String etaTp) {
		this.etaTp = etaTp;
	}
	
	/**
	 * Column Info
	 * @param rr
	 */
	public void setRr(String rr) {
		this.rr = rr;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setEtaTp(JSPUtil.getParameter(request, "eta_tp", ""));
		setRr(JSPUtil.getParameter(request, "rr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSceClmDataVO[]
	 */
	public SearchSceClmDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSceClmDataVO[]
	 */
	public SearchSceClmDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSceClmDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] etaTp = (JSPUtil.getParameter(request, prefix	+ "eta_tp", length));
			String[] rr = (JSPUtil.getParameter(request, prefix	+ "rr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSceClmDataVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (etaTp[i] != null)
					model.setEtaTp(etaTp[i]);
				if (rr[i] != null)
					model.setRr(rr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSceClmDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSceClmDataVO[]
	 */
	public SearchSceClmDataVO[] getSearchSceClmDataVOs(){
		SearchSceClmDataVO[] vos = (SearchSceClmDataVO[])models.toArray(new SearchSceClmDataVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaTp = this.etaTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rr = this.rr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
