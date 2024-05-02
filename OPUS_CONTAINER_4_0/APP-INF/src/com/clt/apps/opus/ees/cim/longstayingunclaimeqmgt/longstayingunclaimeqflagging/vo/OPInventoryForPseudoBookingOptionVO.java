/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OPInventoryForPseudoBookingOptionVO.java
*@FileTitle : OPInventoryForPseudoBookingOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.09
*@LastModifier : 이영두
*@LastVersion : 1.0
* 2013.07.09 이영두
* 1.0 Creation
* --------------------------------------------------------
* History
* 2013.07.09 이영두 신규
=========================================================*/

package com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이영두
 * @since J2EE 1.6
 * @see AbstractValueObject
 */ 

public class OPInventoryForPseudoBookingOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OPInventoryForPseudoBookingOptionVO> models = new ArrayList<OPInventoryForPseudoBookingOptionVO>();
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String queryStr = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String opLocCd = null;
	/* Column Info */
	private String stayDays = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OPInventoryForPseudoBookingOptionVO() {}

	public OPInventoryForPseudoBookingOptionVO(String ibflag, String queryStr,String rhqCd, String bkgOfcCd, String bkgNo, String custCd, String custNm, String opLocCd, String stayDays ) {
		this.rhqCd = rhqCd;
		this.bkgOfcCd = bkgOfcCd;
		this.bkgNo = bkgNo;
		this.custCd = custCd;
		this.custNm = custNm;
		this.opLocCd = opLocCd;
		this.stayDays = stayDays;
		this.queryStr = queryStr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("op_loc_cd", getOpLocCd());
		this.hashColumns.put("stay_days", getStayDays());
		this.hashColumns.put("query_str", getQueryStr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("op_loc_cd", "opLocCd");
		this.hashFields.put("stay_days", "stayDays");
		this.hashFields.put("query_str", "queryStr");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd13
	 */
	public String getOpLocCd() {
		return this.opLocCd;
	}
	
	/**
	 * Column Info
	 * @return stayDays
	 */
	public String getStayDays() {
		return this.stayDays;
	}
	
	/**
	 * Column Info
	 * @return queryStr
	 */
	public String getQueryStr() {
		return this.queryStr;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param opLocCd
	 */
	public void setOpLocCd(String opLocCd) {
		this.opLocCd = opLocCd;
	}
	
	/**
	 * Column Info
	 * @param stayDays
	 */
	public void setStayDays(String stayDays) {
		this.stayDays = stayDays;
	}
	
	/**
	 * Column Info
	 * @param queryStr
	 */
	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRhqCd(JSPUtil.getParameter(request, "rhq_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setOpLocCd(JSPUtil.getParameter(request, "op_loc_cd", ""));
		setStayDays(JSPUtil.getParameter(request, "stay_days", ""));
		setQueryStr(JSPUtil.getParameter(request, "query_str", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OPInventoryForPseudoBookingOptionVO[]
	 */
	public OPInventoryForPseudoBookingOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FlaggingSDaysOptionVO[]
	 */
	public OPInventoryForPseudoBookingOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OPInventoryForPseudoBookingOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] opLocCd = (JSPUtil.getParameter(request, prefix	+ "op_loc_cd", length));
			String[] stayDays = (JSPUtil.getParameter(request, prefix	+ "stay_days", length));
			String[] queryStr = (JSPUtil.getParameter(request, prefix	+ "query_str", length));
		
			for (int i = 0; i < length; i++) {
				model = new OPInventoryForPseudoBookingOptionVO();
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (opLocCd[i] != null)
					model.setOpLocCd(opLocCd[i]);
				if (stayDays[i] != null)
					model.setStayDays(stayDays[i]);
				if (queryStr[i] != null)
					model.setQueryStr(queryStr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOPInventoryForPseudoBookingOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OPInventoryForPseudoBookingOptionVO[]
	 */
	public OPInventoryForPseudoBookingOptionVO[] getOPInventoryForPseudoBookingOptionVOs(){
		OPInventoryForPseudoBookingOptionVO[] vos = (OPInventoryForPseudoBookingOptionVO[])models.toArray(new OPInventoryForPseudoBookingOptionVO[models.size()]);
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
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opLocCd = this.opLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays = this.stayDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.queryStr = this.queryStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
