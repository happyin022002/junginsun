/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ExportReferencesVO.java
*@FileTitle : ExportReferencesVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.19  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class ExportReferencesVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExportReferencesVO> models = new ArrayList<ExportReferencesVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgRefTpNm = null;
	/* Column Info */
	private String bkgRefTpCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String custRefNoCtnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ExportReferencesVO() {}

	public ExportReferencesVO(String ibflag, String pagerows, String bkgRefTpCd, String bkgRefTpNm, String cntrNo, String custRefNoCtnt, String bkgNo) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.bkgRefTpNm = bkgRefTpNm;
		this.bkgRefTpCd = bkgRefTpCd;
		this.cntrNo = cntrNo;
		this.custRefNoCtnt = custRefNoCtnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_ref_tp_nm", getBkgRefTpNm());
		this.hashColumns.put("bkg_ref_tp_cd", getBkgRefTpCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cust_ref_no_ctnt", getCustRefNoCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_ref_tp_nm", "bkgRefTpNm");
		this.hashFields.put("bkg_ref_tp_cd", "bkgRefTpCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cust_ref_no_ctnt", "custRefNoCtnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return bkgRefTpNm
	 */
	public String getBkgRefTpNm() {
		return this.bkgRefTpNm;
	}
	
	/**
	 * Column Info
	 * @return bkgRefTpCd
	 */
	public String getBkgRefTpCd() {
		return this.bkgRefTpCd;
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
	 * @return custRefNoCtnt
	 */
	public String getCustRefNoCtnt() {
		return this.custRefNoCtnt;
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
	 * @param bkgRefTpNm
	 */
	public void setBkgRefTpNm(String bkgRefTpNm) {
		this.bkgRefTpNm = bkgRefTpNm;
	}
	
	/**
	 * Column Info
	 * @param bkgRefTpCd
	 */
	public void setBkgRefTpCd(String bkgRefTpCd) {
		this.bkgRefTpCd = bkgRefTpCd;
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
	 * @param custRefNoCtnt
	 */
	public void setCustRefNoCtnt(String custRefNoCtnt) {
		this.custRefNoCtnt = custRefNoCtnt;
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
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgRefTpNm(JSPUtil.getParameter(request, prefix + "bkg_ref_tp_nm", ""));
		setBkgRefTpCd(JSPUtil.getParameter(request, prefix + "bkg_ref_tp_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCustRefNoCtnt(JSPUtil.getParameter(request, prefix + "cust_ref_no_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExportReferencesVO[]
	 */
	public ExportReferencesVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ExportReferencesVO[]
	 */
	public ExportReferencesVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExportReferencesVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgRefTpNm = (JSPUtil.getParameter(request, prefix	+ "bkg_ref_tp_nm", length));
			String[] bkgRefTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ref_tp_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] custRefNoCtnt = (JSPUtil.getParameter(request, prefix	+ "cust_ref_no_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ExportReferencesVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgRefTpNm[i] != null)
					model.setBkgRefTpNm(bkgRefTpNm[i]);
				if (bkgRefTpCd[i] != null)
					model.setBkgRefTpCd(bkgRefTpCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (custRefNoCtnt[i] != null)
					model.setCustRefNoCtnt(custRefNoCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExportReferencesVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ExportReferencesVO[]
	 */
	public ExportReferencesVO[] getExportReferencesVOs(){
		ExportReferencesVO[] vos = (ExportReferencesVO[])models.toArray(new ExportReferencesVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefTpNm = this.bkgRefTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefTpCd = this.bkgRefTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefNoCtnt = this.custRefNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
