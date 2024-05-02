/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RejectEdiCustVO.java
*@FileTitle : RejectEdiCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.03 전용진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RejectEdiCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RejectEdiCustVO> models = new ArrayList<RejectEdiCustVO>();
	
	/* Column Info */
	private String ibcsCTp = null;
	/* Column Info */
	private String ibcsTp = null;
	/* Column Info */
	private String ibcsLocCd = null;
	/* Column Info */
	private String ibcsCNm1 = null;
	/* Column Info */
	private String ibcsLocNm = null;
	/* Column Info */
	private String ibcsCNm2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ibcsCustLoc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ibcsCEmail = null;
	/* Column Info */
	private String ibcsAddr3 = null;
	/* Column Info */
	private String ibcsAddr2 = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String ibcsAddr1 = null;
	/* Column Info */
	private String ibcsCFax = null;
	/* Column Info */
	private String ibcsNm2 = null;
	/* Column Info */
	private String ibcsCTel = null;
	/* Column Info */
	private String ibcsStreet = null;
	/* Column Info */
	private String ibcsZipCd = null;
	/* Column Info */
	private String ibcsNm1 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RejectEdiCustVO() {}

	public RejectEdiCustVO(String ibflag, String pagerows, String ibcsTp, String ibcsNm1, String ibcsNm2, String ibcsAddr1, String ibcsAddr2, String ibcsAddr3, String ibcsCNm1, String ibcsCNm2, String cntCd, String custCd, String ibcsCustLoc, String ibcsStreet, String ibcsLocCd, String ibcsLocNm, String ibcsZipCd, String ibcsCTp, String ibcsCTel, String ibcsCFax, String ibcsCEmail) {
		this.ibcsCTp = ibcsCTp;
		this.ibcsTp = ibcsTp;
		this.ibcsLocCd = ibcsLocCd;
		this.ibcsCNm1 = ibcsCNm1;
		this.ibcsLocNm = ibcsLocNm;
		this.ibcsCNm2 = ibcsCNm2;
		this.pagerows = pagerows;
		this.ibcsCustLoc = ibcsCustLoc;
		this.ibflag = ibflag;
		this.ibcsCEmail = ibcsCEmail;
		this.ibcsAddr3 = ibcsAddr3;
		this.ibcsAddr2 = ibcsAddr2;
		this.custCd = custCd;
		this.cntCd = cntCd;
		this.ibcsAddr1 = ibcsAddr1;
		this.ibcsCFax = ibcsCFax;
		this.ibcsNm2 = ibcsNm2;
		this.ibcsCTel = ibcsCTel;
		this.ibcsStreet = ibcsStreet;
		this.ibcsZipCd = ibcsZipCd;
		this.ibcsNm1 = ibcsNm1;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibcs_c_tp", getIbcsCTp());
		this.hashColumns.put("ibcs_tp", getIbcsTp());
		this.hashColumns.put("ibcs_loc_cd", getIbcsLocCd());
		this.hashColumns.put("ibcs_c_nm1", getIbcsCNm1());
		this.hashColumns.put("ibcs_loc_nm", getIbcsLocNm());
		this.hashColumns.put("ibcs_c_nm2", getIbcsCNm2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibcs_cust_loc", getIbcsCustLoc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ibcs_c_email", getIbcsCEmail());
		this.hashColumns.put("ibcs_addr3", getIbcsAddr3());
		this.hashColumns.put("ibcs_addr2", getIbcsAddr2());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("ibcs_addr1", getIbcsAddr1());
		this.hashColumns.put("ibcs_c_fax", getIbcsCFax());
		this.hashColumns.put("ibcs_nm2", getIbcsNm2());
		this.hashColumns.put("ibcs_c_tel", getIbcsCTel());
		this.hashColumns.put("ibcs_street", getIbcsStreet());
		this.hashColumns.put("ibcs_zip_cd", getIbcsZipCd());
		this.hashColumns.put("ibcs_nm1", getIbcsNm1());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibcs_c_tp", "ibcsCTp");
		this.hashFields.put("ibcs_tp", "ibcsTp");
		this.hashFields.put("ibcs_loc_cd", "ibcsLocCd");
		this.hashFields.put("ibcs_c_nm1", "ibcsCNm1");
		this.hashFields.put("ibcs_loc_nm", "ibcsLocNm");
		this.hashFields.put("ibcs_c_nm2", "ibcsCNm2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibcs_cust_loc", "ibcsCustLoc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ibcs_c_email", "ibcsCEmail");
		this.hashFields.put("ibcs_addr3", "ibcsAddr3");
		this.hashFields.put("ibcs_addr2", "ibcsAddr2");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("ibcs_addr1", "ibcsAddr1");
		this.hashFields.put("ibcs_c_fax", "ibcsCFax");
		this.hashFields.put("ibcs_nm2", "ibcsNm2");
		this.hashFields.put("ibcs_c_tel", "ibcsCTel");
		this.hashFields.put("ibcs_street", "ibcsStreet");
		this.hashFields.put("ibcs_zip_cd", "ibcsZipCd");
		this.hashFields.put("ibcs_nm1", "ibcsNm1");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ibcsCTp
	 */
	public String getIbcsCTp() {
		return this.ibcsCTp;
	}
	
	/**
	 * Column Info
	 * @return ibcsTp
	 */
	public String getIbcsTp() {
		return this.ibcsTp;
	}
	
	/**
	 * Column Info
	 * @return ibcsLocCd
	 */
	public String getIbcsLocCd() {
		return this.ibcsLocCd;
	}
	
	/**
	 * Column Info
	 * @return ibcsCNm1
	 */
	public String getIbcsCNm1() {
		return this.ibcsCNm1;
	}
	
	/**
	 * Column Info
	 * @return ibcsLocNm
	 */
	public String getIbcsLocNm() {
		return this.ibcsLocNm;
	}
	
	/**
	 * Column Info
	 * @return ibcsCNm2
	 */
	public String getIbcsCNm2() {
		return this.ibcsCNm2;
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
	 * @return ibcsCustLoc
	 */
	public String getIbcsCustLoc() {
		return this.ibcsCustLoc;
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
	 * @return ibcsCEmail
	 */
	public String getIbcsCEmail() {
		return this.ibcsCEmail;
	}
	
	/**
	 * Column Info
	 * @return ibcsAddr3
	 */
	public String getIbcsAddr3() {
		return this.ibcsAddr3;
	}
	
	/**
	 * Column Info
	 * @return ibcsAddr2
	 */
	public String getIbcsAddr2() {
		return this.ibcsAddr2;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return ibcsAddr1
	 */
	public String getIbcsAddr1() {
		return this.ibcsAddr1;
	}
	
	/**
	 * Column Info
	 * @return ibcsCFax
	 */
	public String getIbcsCFax() {
		return this.ibcsCFax;
	}
	
	/**
	 * Column Info
	 * @return ibcsNm2
	 */
	public String getIbcsNm2() {
		return this.ibcsNm2;
	}
	
	/**
	 * Column Info
	 * @return ibcsCTel
	 */
	public String getIbcsCTel() {
		return this.ibcsCTel;
	}
	
	/**
	 * Column Info
	 * @return ibcsStreet
	 */
	public String getIbcsStreet() {
		return this.ibcsStreet;
	}
	
	/**
	 * Column Info
	 * @return ibcsZipCd
	 */
	public String getIbcsZipCd() {
		return this.ibcsZipCd;
	}
	
	/**
	 * Column Info
	 * @return ibcsNm1
	 */
	public String getIbcsNm1() {
		return this.ibcsNm1;
	}
	

	/**
	 * Column Info
	 * @param ibcsCTp
	 */
	public void setIbcsCTp(String ibcsCTp) {
		this.ibcsCTp = ibcsCTp;
	}
	
	/**
	 * Column Info
	 * @param ibcsTp
	 */
	public void setIbcsTp(String ibcsTp) {
		this.ibcsTp = ibcsTp;
	}
	
	/**
	 * Column Info
	 * @param ibcsLocCd
	 */
	public void setIbcsLocCd(String ibcsLocCd) {
		this.ibcsLocCd = ibcsLocCd;
	}
	
	/**
	 * Column Info
	 * @param ibcsCNm1
	 */
	public void setIbcsCNm1(String ibcsCNm1) {
		this.ibcsCNm1 = ibcsCNm1;
	}
	
	/**
	 * Column Info
	 * @param ibcsLocNm
	 */
	public void setIbcsLocNm(String ibcsLocNm) {
		this.ibcsLocNm = ibcsLocNm;
	}
	
	/**
	 * Column Info
	 * @param ibcsCNm2
	 */
	public void setIbcsCNm2(String ibcsCNm2) {
		this.ibcsCNm2 = ibcsCNm2;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param ibcsCustLoc
	 */
	public void setIbcsCustLoc(String ibcsCustLoc) {
		this.ibcsCustLoc = ibcsCustLoc;
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
	 * @param ibcsCEmail
	 */
	public void setIbcsCEmail(String ibcsCEmail) {
		this.ibcsCEmail = ibcsCEmail;
	}
	
	/**
	 * Column Info
	 * @param ibcsAddr3
	 */
	public void setIbcsAddr3(String ibcsAddr3) {
		this.ibcsAddr3 = ibcsAddr3;
	}
	
	/**
	 * Column Info
	 * @param ibcsAddr2
	 */
	public void setIbcsAddr2(String ibcsAddr2) {
		this.ibcsAddr2 = ibcsAddr2;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
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
	 * @param ibcsAddr1
	 */
	public void setIbcsAddr1(String ibcsAddr1) {
		this.ibcsAddr1 = ibcsAddr1;
	}
	
	/**
	 * Column Info
	 * @param ibcsCFax
	 */
	public void setIbcsCFax(String ibcsCFax) {
		this.ibcsCFax = ibcsCFax;
	}
	
	/**
	 * Column Info
	 * @param ibcsNm2
	 */
	public void setIbcsNm2(String ibcsNm2) {
		this.ibcsNm2 = ibcsNm2;
	}
	
	/**
	 * Column Info
	 * @param ibcsCTel
	 */
	public void setIbcsCTel(String ibcsCTel) {
		this.ibcsCTel = ibcsCTel;
	}
	
	/**
	 * Column Info
	 * @param ibcsStreet
	 */
	public void setIbcsStreet(String ibcsStreet) {
		this.ibcsStreet = ibcsStreet;
	}
	
	/**
	 * Column Info
	 * @param ibcsZipCd
	 */
	public void setIbcsZipCd(String ibcsZipCd) {
		this.ibcsZipCd = ibcsZipCd;
	}
	
	/**
	 * Column Info
	 * @param ibcsNm1
	 */
	public void setIbcsNm1(String ibcsNm1) {
		this.ibcsNm1 = ibcsNm1;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbcsCTp(JSPUtil.getParameter(request, "ibcs_c_tp", ""));
		setIbcsTp(JSPUtil.getParameter(request, "ibcs_tp", ""));
		setIbcsLocCd(JSPUtil.getParameter(request, "ibcs_loc_cd", ""));
		setIbcsCNm1(JSPUtil.getParameter(request, "ibcs_c_nm1", ""));
		setIbcsLocNm(JSPUtil.getParameter(request, "ibcs_loc_nm", ""));
		setIbcsCNm2(JSPUtil.getParameter(request, "ibcs_c_nm2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbcsCustLoc(JSPUtil.getParameter(request, "ibcs_cust_loc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIbcsCEmail(JSPUtil.getParameter(request, "ibcs_c_email", ""));
		setIbcsAddr3(JSPUtil.getParameter(request, "ibcs_addr3", ""));
		setIbcsAddr2(JSPUtil.getParameter(request, "ibcs_addr2", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setIbcsAddr1(JSPUtil.getParameter(request, "ibcs_addr1", ""));
		setIbcsCFax(JSPUtil.getParameter(request, "ibcs_c_fax", ""));
		setIbcsNm2(JSPUtil.getParameter(request, "ibcs_nm2", ""));
		setIbcsCTel(JSPUtil.getParameter(request, "ibcs_c_tel", ""));
		setIbcsStreet(JSPUtil.getParameter(request, "ibcs_street", ""));
		setIbcsZipCd(JSPUtil.getParameter(request, "ibcs_zip_cd", ""));
		setIbcsNm1(JSPUtil.getParameter(request, "ibcs_nm1", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RejectEdiCustVO[]
	 */
	public RejectEdiCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RejectEdiCustVO[]
	 */
	public RejectEdiCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RejectEdiCustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibcsCTp = (JSPUtil.getParameter(request, prefix	+ "ibcs_c_tp", length));
			String[] ibcsTp = (JSPUtil.getParameter(request, prefix	+ "ibcs_tp", length));
			String[] ibcsLocCd = (JSPUtil.getParameter(request, prefix	+ "ibcs_loc_cd", length));
			String[] ibcsCNm1 = (JSPUtil.getParameter(request, prefix	+ "ibcs_c_nm1", length));
			String[] ibcsLocNm = (JSPUtil.getParameter(request, prefix	+ "ibcs_loc_nm", length));
			String[] ibcsCNm2 = (JSPUtil.getParameter(request, prefix	+ "ibcs_c_nm2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibcsCustLoc = (JSPUtil.getParameter(request, prefix	+ "ibcs_cust_loc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ibcsCEmail = (JSPUtil.getParameter(request, prefix	+ "ibcs_c_email", length));
			String[] ibcsAddr3 = (JSPUtil.getParameter(request, prefix	+ "ibcs_addr3", length));
			String[] ibcsAddr2 = (JSPUtil.getParameter(request, prefix	+ "ibcs_addr2", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] ibcsAddr1 = (JSPUtil.getParameter(request, prefix	+ "ibcs_addr1", length));
			String[] ibcsCFax = (JSPUtil.getParameter(request, prefix	+ "ibcs_c_fax", length));
			String[] ibcsNm2 = (JSPUtil.getParameter(request, prefix	+ "ibcs_nm2", length));
			String[] ibcsCTel = (JSPUtil.getParameter(request, prefix	+ "ibcs_c_tel", length));
			String[] ibcsStreet = (JSPUtil.getParameter(request, prefix	+ "ibcs_street", length));
			String[] ibcsZipCd = (JSPUtil.getParameter(request, prefix	+ "ibcs_zip_cd", length));
			String[] ibcsNm1 = (JSPUtil.getParameter(request, prefix	+ "ibcs_nm1", length));
			
			for (int i = 0; i < length; i++) {
				model = new RejectEdiCustVO();
				if (ibcsCTp[i] != null)
					model.setIbcsCTp(ibcsCTp[i]);
				if (ibcsTp[i] != null)
					model.setIbcsTp(ibcsTp[i]);
				if (ibcsLocCd[i] != null)
					model.setIbcsLocCd(ibcsLocCd[i]);
				if (ibcsCNm1[i] != null)
					model.setIbcsCNm1(ibcsCNm1[i]);
				if (ibcsLocNm[i] != null)
					model.setIbcsLocNm(ibcsLocNm[i]);
				if (ibcsCNm2[i] != null)
					model.setIbcsCNm2(ibcsCNm2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibcsCustLoc[i] != null)
					model.setIbcsCustLoc(ibcsCustLoc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ibcsCEmail[i] != null)
					model.setIbcsCEmail(ibcsCEmail[i]);
				if (ibcsAddr3[i] != null)
					model.setIbcsAddr3(ibcsAddr3[i]);
				if (ibcsAddr2[i] != null)
					model.setIbcsAddr2(ibcsAddr2[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (ibcsAddr1[i] != null)
					model.setIbcsAddr1(ibcsAddr1[i]);
				if (ibcsCFax[i] != null)
					model.setIbcsCFax(ibcsCFax[i]);
				if (ibcsNm2[i] != null)
					model.setIbcsNm2(ibcsNm2[i]);
				if (ibcsCTel[i] != null)
					model.setIbcsCTel(ibcsCTel[i]);
				if (ibcsStreet[i] != null)
					model.setIbcsStreet(ibcsStreet[i]);
				if (ibcsZipCd[i] != null)
					model.setIbcsZipCd(ibcsZipCd[i]);
				if (ibcsNm1[i] != null)
					model.setIbcsNm1(ibcsNm1[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRejectEdiCustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RejectEdiCustVO[]
	 */
	public RejectEdiCustVO[] getRejectEdiCustVOs(){
		RejectEdiCustVO[] vos = (RejectEdiCustVO[])models.toArray(new RejectEdiCustVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.ibcsCTp = this.ibcsCTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibcsTp = this.ibcsTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibcsLocCd = this.ibcsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibcsCNm1 = this.ibcsCNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibcsLocNm = this.ibcsLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibcsCNm2 = this.ibcsCNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibcsCustLoc = this.ibcsCustLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibcsCEmail = this.ibcsCEmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibcsAddr3 = this.ibcsAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibcsAddr2 = this.ibcsAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibcsAddr1 = this.ibcsAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibcsCFax = this.ibcsCFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibcsNm2 = this.ibcsNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibcsCTel = this.ibcsCTel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibcsStreet = this.ibcsStreet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibcsZipCd = this.ibcsZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibcsNm1 = this.ibcsNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
