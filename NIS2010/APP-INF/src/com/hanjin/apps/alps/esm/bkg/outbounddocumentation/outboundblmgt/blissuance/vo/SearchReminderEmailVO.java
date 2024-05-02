/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchReminderEmailVO.java
*@FileTitle : SearchReminderEmailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.09
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.09  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class SearchReminderEmailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchReminderEmailVO> models = new ArrayList<SearchReminderEmailVO>();
	
	/* Column Info */
	private String docClzTm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String docClzDt = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String etaTm = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cntCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchReminderEmailVO() {}

	public SearchReminderEmailVO(String ibflag, String pagerows, String vslNm, String blNo, String docClzDt, String docClzTm, String etdDt, String etaDt, String etaTm, String cntCd) {
		this.docClzTm = docClzTm;
		this.ibflag = ibflag;
		this.docClzDt = docClzDt;
		this.etaDt = etaDt;
		this.vslNm = vslNm;
		this.etdDt = etdDt;
		this.etaTm = etaTm;
		this.blNo = blNo;
		this.cntCd = cntCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("doc_clz_tm", getDocClzTm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("doc_clz_dt", getDocClzDt());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("eta_tm", getEtaTm());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("doc_clz_tm", "docClzTm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("doc_clz_dt", "docClzDt");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("eta_tm", "etaTm");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return docClzTm
	 */
	public String getDocClzTm() {
		return this.docClzTm;
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
	 * @return docClzDt
	 */
	public String getDocClzDt() {
		return this.docClzDt;
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
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @return etaTm
	 */
	public String getEtaTm() {
		return this.etaTm;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	/**
	 * Page Number
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	

	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	
	/**
	 * Column Info
	 * @param docClzTm
	 */
	public void setDocClzTm(String docClzTm) {
		this.docClzTm = docClzTm;
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
	 * @param docClzDt
	 */
	public void setDocClzDt(String docClzDt) {
		this.docClzDt = docClzDt;
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
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	
	/**
	 * Column Info
	 * @param etaTm
	 */
	public void setEtaTm(String etaTm) {
		this.etaTm = etaTm;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
		setDocClzTm(JSPUtil.getParameter(request, prefix + "doc_clz_tm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDocClzDt(JSPUtil.getParameter(request, prefix + "doc_clz_dt", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setEtaTm(JSPUtil.getParameter(request, prefix + "eta_tm", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchReminderEmailVO[]
	 */
	public SearchReminderEmailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchReminderEmailVO[]
	 */
	public SearchReminderEmailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchReminderEmailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] docClzTm = (JSPUtil.getParameter(request, prefix	+ "doc_clz_tm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] docClzDt = (JSPUtil.getParameter(request, prefix	+ "doc_clz_dt", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] etaTm = (JSPUtil.getParameter(request, prefix	+ "eta_tm", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchReminderEmailVO();
				if (docClzTm[i] != null)
					model.setDocClzTm(docClzTm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (docClzDt[i] != null)
					model.setDocClzDt(docClzDt[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (etaTm[i] != null)
					model.setEtaTm(etaTm[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchReminderEmailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchReminderEmailVO[]
	 */
	public SearchReminderEmailVO[] getSearchReminderEmailVOs(){
		SearchReminderEmailVO[] vos = (SearchReminderEmailVO[])models.toArray(new SearchReminderEmailVO[models.size()]);
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
		this.docClzTm = this.docClzTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docClzDt = this.docClzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaTm = this.etaTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
