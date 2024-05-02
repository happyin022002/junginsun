/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustCdInfoVO.java
*@FileTitle : CustCdInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.09.15 함대성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo;

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
 * @author 함대성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustCdInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustCdInfoVO> models = new ArrayList<CustCdInfoVO>();
	
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String bzetAddr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String svcInChgNm = null;
	/* Column Info */
	private String joCntcFaxNo = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String customerCode = null;
	/* Column Info */
	private String crrCntcSeq = null;
	/* Column Info */
	private String joCntcEml = null;
	/* Column Info */
	private String joCntcPhnNo = null;
	/* Column Info */
	private String joCntcOfcAddr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustCdInfoVO() {}

	public CustCdInfoVO(String ibflag, String pagerows, String custLglEngNm, String bzetAddr, String customerCode, String joCrrCd, String crrCntcSeq, String cntcPsonNm, String svcInChgNm, String joCntcPhnNo, String joCntcFaxNo, String joCntcEml, String joCntcOfcAddr) {
		this.joCrrCd = joCrrCd;
		this.bzetAddr = bzetAddr;
		this.pagerows = pagerows;
		this.custLglEngNm = custLglEngNm;
		this.ibflag = ibflag;
		this.svcInChgNm = svcInChgNm;
		this.joCntcFaxNo = joCntcFaxNo;
		this.cntcPsonNm = cntcPsonNm;
		this.customerCode = customerCode;
		this.crrCntcSeq = crrCntcSeq;
		this.joCntcEml = joCntcEml;
		this.joCntcPhnNo = joCntcPhnNo;
		this.joCntcOfcAddr = joCntcOfcAddr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("bzet_addr", getBzetAddr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("svc_in_chg_nm", getSvcInChgNm());
		this.hashColumns.put("jo_cntc_fax_no", getJoCntcFaxNo());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("customer_code", getCustomerCode());
		this.hashColumns.put("crr_cntc_seq", getCrrCntcSeq());
		this.hashColumns.put("jo_cntc_eml", getJoCntcEml());
		this.hashColumns.put("jo_cntc_phn_no", getJoCntcPhnNo());
		this.hashColumns.put("jo_cntc_ofc_addr", getJoCntcOfcAddr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("bzet_addr", "bzetAddr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("svc_in_chg_nm", "svcInChgNm");
		this.hashFields.put("jo_cntc_fax_no", "joCntcFaxNo");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("customer_code", "customerCode");
		this.hashFields.put("crr_cntc_seq", "crrCntcSeq");
		this.hashFields.put("jo_cntc_eml", "joCntcEml");
		this.hashFields.put("jo_cntc_phn_no", "joCntcPhnNo");
		this.hashFields.put("jo_cntc_ofc_addr", "joCntcOfcAddr");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 * Column Info
	 * @return bzetAddr
	 */
	public String getBzetAddr() {
		return this.bzetAddr;
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
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
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
	 * @return svcInChgNm
	 */
	public String getSvcInChgNm() {
		return this.svcInChgNm;
	}
	
	/**
	 * Column Info
	 * @return joCntcFaxNo
	 */
	public String getJoCntcFaxNo() {
		return this.joCntcFaxNo;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return customerCode
	 */
	public String getCustomerCode() {
		return this.customerCode;
	}
	
	/**
	 * Column Info
	 * @return crrCntcSeq
	 */
	public String getCrrCntcSeq() {
		return this.crrCntcSeq;
	}
	
	/**
	 * Column Info
	 * @return joCntcEml
	 */
	public String getJoCntcEml() {
		return this.joCntcEml;
	}
	
	/**
	 * Column Info
	 * @return joCntcPhnNo
	 */
	public String getJoCntcPhnNo() {
		return this.joCntcPhnNo;
	}
	
	/**
	 * Column Info
	 * @return joCntcOfcAddr
	 */
	public String getJoCntcOfcAddr() {
		return this.joCntcOfcAddr;
	}
	

	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * Column Info
	 * @param bzetAddr
	 */
	public void setBzetAddr(String bzetAddr) {
		this.bzetAddr = bzetAddr;
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
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
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
	 * @param svcInChgNm
	 */
	public void setSvcInChgNm(String svcInChgNm) {
		this.svcInChgNm = svcInChgNm;
	}
	
	/**
	 * Column Info
	 * @param joCntcFaxNo
	 */
	public void setJoCntcFaxNo(String joCntcFaxNo) {
		this.joCntcFaxNo = joCntcFaxNo;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param customerCode
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	
	/**
	 * Column Info
	 * @param crrCntcSeq
	 */
	public void setCrrCntcSeq(String crrCntcSeq) {
		this.crrCntcSeq = crrCntcSeq;
	}
	
	/**
	 * Column Info
	 * @param joCntcEml
	 */
	public void setJoCntcEml(String joCntcEml) {
		this.joCntcEml = joCntcEml;
	}
	
	/**
	 * Column Info
	 * @param joCntcPhnNo
	 */
	public void setJoCntcPhnNo(String joCntcPhnNo) {
		this.joCntcPhnNo = joCntcPhnNo;
	}
	
	/**
	 * Column Info
	 * @param joCntcOfcAddr
	 */
	public void setJoCntcOfcAddr(String joCntcOfcAddr) {
		this.joCntcOfcAddr = joCntcOfcAddr;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setJoCrrCd(JSPUtil.getParameter(request, "jo_crr_cd", ""));
		setBzetAddr(JSPUtil.getParameter(request, "bzet_addr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, "cust_lgl_eng_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSvcInChgNm(JSPUtil.getParameter(request, "svc_in_chg_nm", ""));
		setJoCntcFaxNo(JSPUtil.getParameter(request, "jo_cntc_fax_no", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, "cntc_pson_nm", ""));
		setCustomerCode(JSPUtil.getParameter(request, "customer_code", ""));
		setCrrCntcSeq(JSPUtil.getParameter(request, "crr_cntc_seq", ""));
		setJoCntcEml(JSPUtil.getParameter(request, "jo_cntc_eml", ""));
		setJoCntcPhnNo(JSPUtil.getParameter(request, "jo_cntc_phn_no", ""));
		setJoCntcOfcAddr(JSPUtil.getParameter(request, "jo_cntc_ofc_addr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustCdInfoVO[]
	 */
	public CustCdInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustCdInfoVO[]
	 */
	public CustCdInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustCdInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] bzetAddr = (JSPUtil.getParameter(request, prefix	+ "bzet_addr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] svcInChgNm = (JSPUtil.getParameter(request, prefix	+ "svc_in_chg_nm", length));
			String[] joCntcFaxNo = (JSPUtil.getParameter(request, prefix	+ "jo_cntc_fax_no", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] customerCode = (JSPUtil.getParameter(request, prefix	+ "customer_code", length));
			String[] crrCntcSeq = (JSPUtil.getParameter(request, prefix	+ "crr_cntc_seq", length));
			String[] joCntcEml = (JSPUtil.getParameter(request, prefix	+ "jo_cntc_eml", length));
			String[] joCntcPhnNo = (JSPUtil.getParameter(request, prefix	+ "jo_cntc_phn_no", length));
			String[] joCntcOfcAddr = (JSPUtil.getParameter(request, prefix	+ "jo_cntc_ofc_addr", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustCdInfoVO();
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (bzetAddr[i] != null)
					model.setBzetAddr(bzetAddr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (svcInChgNm[i] != null)
					model.setSvcInChgNm(svcInChgNm[i]);
				if (joCntcFaxNo[i] != null)
					model.setJoCntcFaxNo(joCntcFaxNo[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (customerCode[i] != null)
					model.setCustomerCode(customerCode[i]);
				if (crrCntcSeq[i] != null)
					model.setCrrCntcSeq(crrCntcSeq[i]);
				if (joCntcEml[i] != null)
					model.setJoCntcEml(joCntcEml[i]);
				if (joCntcPhnNo[i] != null)
					model.setJoCntcPhnNo(joCntcPhnNo[i]);
				if (joCntcOfcAddr[i] != null)
					model.setJoCntcOfcAddr(joCntcOfcAddr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustCdInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustCdInfoVO[]
	 */
	public CustCdInfoVO[] getCustCdInfoVOs(){
		CustCdInfoVO[] vos = (CustCdInfoVO[])models.toArray(new CustCdInfoVO[models.size()]);
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
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetAddr = this.bzetAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcInChgNm = this.svcInChgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCntcFaxNo = this.joCntcFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerCode = this.customerCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCntcSeq = this.crrCntcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCntcEml = this.joCntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCntcPhnNo = this.joCntcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCntcOfcAddr = this.joCntcOfcAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
