/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchRevVVDListVO.java
*@FileTitle : SearchRevVVDListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.02.04 yOng hO lEE 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tes.guaranteemanage.tpbinterfacemanage.vo;

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
 * @author yOng hO lEE
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchRevVVDListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchRevVVDListVO> models = new ArrayList<SearchRevVVDListVO>();
	
	/* Column Info */
	private String tmlGnteCntrListSeq = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String gnteNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String revVvd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchRevVVDListVO() {}

	public SearchRevVVDListVO(String ibflag, String pagerows, String gnteNo, String tmlGnteCntrListSeq, String cntrNo, String bkgNo, String revVvd) {
		this.tmlGnteCntrListSeq = tmlGnteCntrListSeq;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.gnteNo = gnteNo;
		this.cntrNo = cntrNo;
		this.revVvd = revVvd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tml_gnte_cntr_list_seq", getTmlGnteCntrListSeq());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gnte_no", getGnteNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("rev_vvd", getRevVvd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tml_gnte_cntr_list_seq", "tmlGnteCntrListSeq");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gnte_no", "gnteNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("rev_vvd", "revVvd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tmlGnteCntrListSeq
	 */
	public String getTmlGnteCntrListSeq() {
		return this.tmlGnteCntrListSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return gnteNo
	 */
	public String getGnteNo() {
		return this.gnteNo;
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
	 * @return revVvd
	 */
	public String getRevVvd() {
		return this.revVvd;
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
	 * @param tmlGnteCntrListSeq
	 */
	public void setTmlGnteCntrListSeq(String tmlGnteCntrListSeq) {
		this.tmlGnteCntrListSeq = tmlGnteCntrListSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param gnteNo
	 */
	public void setGnteNo(String gnteNo) {
		this.gnteNo = gnteNo;
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
	 * @param revVvd
	 */
	public void setRevVvd(String revVvd) {
		this.revVvd = revVvd;
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
		setTmlGnteCntrListSeq(JSPUtil.getParameter(request, "tml_gnte_cntr_list_seq", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGnteNo(JSPUtil.getParameter(request, "gnte_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setRevVvd(JSPUtil.getParameter(request, "rev_vvd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRevVVDListVO[]
	 */
	public SearchRevVVDListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRevVVDListVO[]
	 */
	public SearchRevVVDListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRevVVDListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tmlGnteCntrListSeq = (JSPUtil.getParameter(request, prefix	+ "tml_gnte_cntr_list_seq", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] gnteNo = (JSPUtil.getParameter(request, prefix	+ "gnte_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] revVvd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchRevVVDListVO();
				if (tmlGnteCntrListSeq[i] != null)
					model.setTmlGnteCntrListSeq(tmlGnteCntrListSeq[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (gnteNo[i] != null)
					model.setGnteNo(gnteNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (revVvd[i] != null)
					model.setRevVvd(revVvd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRevVVDListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchRevVVDListVO[]
	 */
	public SearchRevVVDListVO[] getSearchRevVVDListVOs(){
		SearchRevVVDListVO[] vos = (SearchRevVVDListVO[])models.toArray(new SearchRevVVDListVO[models.size()]);
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
		this.tmlGnteCntrListSeq = this.tmlGnteCntrListSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnteNo = this.gnteNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvd = this.revVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
