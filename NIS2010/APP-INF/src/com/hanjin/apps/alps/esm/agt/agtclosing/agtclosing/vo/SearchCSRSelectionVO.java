/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchCSRSelectionVO.java
*@FileTitle : SearchCSRSelectionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.13
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.01.13 박성진 
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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCSRSelectionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCSRSelectionVO> models = new ArrayList<SearchCSRSelectionVO>();
	
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String des = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slipLoc = null;
	/* Column Info */
	private String offCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCSRSelectionVO() {}

	public SearchCSRSelectionVO(String ibflag, String pagerows, String csrNo, String des, String glDt, String offCd, String slipLoc) {
		this.csrNo = csrNo;
		this.glDt = glDt;
		this.des = des;
		this.ibflag = ibflag;
		this.slipLoc = slipLoc;
		this.offCd = offCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("des", getDes());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slip_loc", getSlipLoc());
		this.hashColumns.put("off_cd", getOffCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("des", "des");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slip_loc", "slipLoc");
		this.hashFields.put("off_cd", "offCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
	}
	
	/**
	 * Column Info
	 * @return des
	 */
	public String getDes() {
		return this.des;
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
	 * @return slipLoc
	 */
	public String getSlipLoc() {
		return this.slipLoc;
	}
	
	/**
	 * Column Info
	 * @return offCd
	 */
	public String getOffCd() {
		return this.offCd;
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
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
	}
	
	/**
	 * Column Info
	 * @param des
	 */
	public void setDes(String des) {
		this.des = des;
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
	 * @param slipLoc
	 */
	public void setSlipLoc(String slipLoc) {
		this.slipLoc = slipLoc;
	}
	
	/**
	 * Column Info
	 * @param offCd
	 */
	public void setOffCd(String offCd) {
		this.offCd = offCd;
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
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setGlDt(JSPUtil.getParameter(request, prefix + "gl_dt", ""));
		setDes(JSPUtil.getParameter(request, prefix + "des", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSlipLoc(JSPUtil.getParameter(request, prefix + "slip_loc", ""));
		setOffCd(JSPUtil.getParameter(request, prefix + "off_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCSRSelectionVO[]
	 */
	public SearchCSRSelectionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCSRSelectionVO[]
	 */
	public SearchCSRSelectionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCSRSelectionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] des = (JSPUtil.getParameter(request, prefix	+ "des", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slipLoc = (JSPUtil.getParameter(request, prefix	+ "slip_loc", length));
			String[] offCd = (JSPUtil.getParameter(request, prefix	+ "off_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCSRSelectionVO();
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (des[i] != null)
					model.setDes(des[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slipLoc[i] != null)
					model.setSlipLoc(slipLoc[i]);
				if (offCd[i] != null)
					model.setOffCd(offCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCSRSelectionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCSRSelectionVO[]
	 */
	public SearchCSRSelectionVO[] getSearchCSRSelectionVOs(){
		SearchCSRSelectionVO[] vos = (SearchCSRSelectionVO[])models.toArray(new SearchCSRSelectionVO[models.size()]);
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
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.des = this.des .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slipLoc = this.slipLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offCd = this.offCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
