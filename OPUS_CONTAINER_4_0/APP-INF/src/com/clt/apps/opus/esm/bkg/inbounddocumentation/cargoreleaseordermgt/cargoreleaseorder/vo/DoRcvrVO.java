/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DoRcvrVO.java
*@FileTitle : DoRcvrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.08  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

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

public class DoRcvrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DoRcvrVO> models = new ArrayList<DoRcvrVO>();
	
	/* Column Info */
	private String doNo = null;
	/* Column Info */
	private String doNoSplit = null;
	/* Column Info */
	private String rcvrEml = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rcvrPhnNo = null;
	/* Column Info */
	private String hblNo = null;
	/* Column Info */
	private String rcvrCoNm = null;
	/* Column Info */
	private String picNm = null;
	/* Column Info */
	private String custToOrdFlg = null;
	/* Column Info */
	private String rcvrCneeNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rcvrFaxNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DoRcvrVO() {}

	public DoRcvrVO(String ibflag, String pagerows, String bkgNo, String doNo, String doNoSplit, String hblNo, String rcvrCneeNm, String rcvrCoNm, String rcvrPhnNo, String picNm, String rcvrEml, String custToOrdFlg, String rcvrFaxNo) {
		this.doNo = doNo;
		this.doNoSplit = doNoSplit;
		this.rcvrEml = rcvrEml;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.rcvrPhnNo = rcvrPhnNo;
		this.hblNo = hblNo;
		this.rcvrCoNm = rcvrCoNm;
		this.picNm = picNm;
		this.custToOrdFlg = custToOrdFlg;
		this.rcvrCneeNm = rcvrCneeNm;
		this.pagerows = pagerows;
		this.rcvrFaxNo = rcvrFaxNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("do_no", getDoNo());
		this.hashColumns.put("do_no_split", getDoNoSplit());
		this.hashColumns.put("rcvr_eml", getRcvrEml());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rcvr_phn_no", getRcvrPhnNo());
		this.hashColumns.put("hbl_no", getHblNo());
		this.hashColumns.put("rcvr_co_nm", getRcvrCoNm());
		this.hashColumns.put("pic_nm", getPicNm());
		this.hashColumns.put("cust_to_ord_flg", getCustToOrdFlg());
		this.hashColumns.put("rcvr_cnee_nm", getRcvrCneeNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rcvr_fax_no", getRcvrFaxNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("do_no_split", "doNoSplit");
		this.hashFields.put("rcvr_eml", "rcvrEml");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rcvr_phn_no", "rcvrPhnNo");
		this.hashFields.put("hbl_no", "hblNo");
		this.hashFields.put("rcvr_co_nm", "rcvrCoNm");
		this.hashFields.put("pic_nm", "picNm");
		this.hashFields.put("cust_to_ord_flg", "custToOrdFlg");
		this.hashFields.put("rcvr_cnee_nm", "rcvrCneeNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rcvr_fax_no", "rcvrFaxNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return doNo
	 */
	public String getDoNo() {
		return this.doNo;
	}
	
	/**
	 * Column Info
	 * @return doNoSplit
	 */
	public String getDoNoSplit() {
		return this.doNoSplit;
	}
	
	/**
	 * Column Info
	 * @return rcvrEml
	 */
	public String getRcvrEml() {
		return this.rcvrEml;
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
	 * @return rcvrPhnNo
	 */
	public String getRcvrPhnNo() {
		return this.rcvrPhnNo;
	}
	
	/**
	 * Column Info
	 * @return hblNo
	 */
	public String getHblNo() {
		return this.hblNo;
	}
	
	/**
	 * Column Info
	 * @return rcvrCoNm
	 */
	public String getRcvrCoNm() {
		return this.rcvrCoNm;
	}
	
	/**
	 * Column Info
	 * @return picNm
	 */
	public String getPicNm() {
		return this.picNm;
	}
	
	/**
	 * Column Info
	 * @return custToOrdFlg
	 */
	public String getCustToOrdFlg() {
		return this.custToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @return rcvrCneeNm
	 */
	public String getRcvrCneeNm() {
		return this.rcvrCneeNm;
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
	 * @return rcvrFaxNo
	 */
	public String getRcvrFaxNo() {
		return this.rcvrFaxNo;
	}

	/**
	 * Column Info
	 * @param doNo
	 */
	public void setDoNo(String doNo) {
		this.doNo = doNo;
	}
	
	/**
	 * Column Info
	 * @param doNoSplit
	 */
	public void setDoNoSplit(String doNoSplit) {
		this.doNoSplit = doNoSplit;
	}
	
	/**
	 * Column Info
	 * @param rcvrEml
	 */
	public void setRcvrEml(String rcvrEml) {
		this.rcvrEml = rcvrEml;
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
	 * @param rcvrPhnNo
	 */
	public void setRcvrPhnNo(String rcvrPhnNo) {
		this.rcvrPhnNo = rcvrPhnNo;
	}
	
	/**
	 * Column Info
	 * @param hblNo
	 */
	public void setHblNo(String hblNo) {
		this.hblNo = hblNo;
	}
	
	/**
	 * Column Info
	 * @param rcvrCoNm
	 */
	public void setRcvrCoNm(String rcvrCoNm) {
		this.rcvrCoNm = rcvrCoNm;
	}
	
	/**
	 * Column Info
	 * @param picNm
	 */
	public void setPicNm(String picNm) {
		this.picNm = picNm;
	}
	
	/**
	 * Column Info
	 * @param custToOrdFlg
	 */
	public void setCustToOrdFlg(String custToOrdFlg) {
		this.custToOrdFlg = custToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @param rcvrCneeNm
	 */
	public void setRcvrCneeNm(String rcvrCneeNm) {
		this.rcvrCneeNm = rcvrCneeNm;
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
	 * @param rcvrFaxNo
	 */
	public void setRcvrFaxNo(String rcvrFaxNo) {
		this.rcvrFaxNo = rcvrFaxNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDoNo(JSPUtil.getParameter(request, "do_no", ""));
		setDoNoSplit(JSPUtil.getParameter(request, "do_no_split", ""));
		setRcvrEml(JSPUtil.getParameter(request, "rcvr_eml", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRcvrPhnNo(JSPUtil.getParameter(request, "rcvr_phn_no", ""));
		setHblNo(JSPUtil.getParameter(request, "hbl_no", ""));
		setRcvrCoNm(JSPUtil.getParameter(request, "rcvr_co_nm", ""));
		setPicNm(JSPUtil.getParameter(request, "pic_nm", ""));
		setCustToOrdFlg(JSPUtil.getParameter(request, "cust_to_ord_flg", ""));
		setRcvrCneeNm(JSPUtil.getParameter(request, "rcvr_cnee_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRcvrFaxNo(JSPUtil.getParameter(request, "rcvr_fax_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DoRcvrVO[]
	 */
	public DoRcvrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DoRcvrVO[]
	 */
	public DoRcvrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DoRcvrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] doNo = (JSPUtil.getParameter(request, prefix	+ "do_no", length));
			String[] doNoSplit = (JSPUtil.getParameter(request, prefix	+ "do_no_split", length));
			String[] rcvrEml = (JSPUtil.getParameter(request, prefix	+ "rcvr_eml", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rcvrPhnNo = (JSPUtil.getParameter(request, prefix	+ "rcvr_phn_no", length));
			String[] hblNo = (JSPUtil.getParameter(request, prefix	+ "hbl_no", length));
			String[] rcvrCoNm = (JSPUtil.getParameter(request, prefix	+ "rcvr_co_nm", length));
			String[] picNm = (JSPUtil.getParameter(request, prefix	+ "pic_nm", length));
			String[] custToOrdFlg = (JSPUtil.getParameter(request, prefix	+ "cust_to_ord_flg", length));
			String[] rcvrCneeNm = (JSPUtil.getParameter(request, prefix	+ "rcvr_cnee_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rcvrFaxNo = (JSPUtil.getParameter(request, prefix	+ "rcvr_fax_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new DoRcvrVO();
				if (doNo[i] != null)
					model.setDoNo(doNo[i]);
				if (doNoSplit[i] != null)
					model.setDoNoSplit(doNoSplit[i]);
				if (rcvrEml[i] != null)
					model.setRcvrEml(rcvrEml[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rcvrPhnNo[i] != null)
					model.setRcvrPhnNo(rcvrPhnNo[i]);
				if (hblNo[i] != null)
					model.setHblNo(hblNo[i]);
				if (rcvrCoNm[i] != null)
					model.setRcvrCoNm(rcvrCoNm[i]);
				if (picNm[i] != null)
					model.setPicNm(picNm[i]);
				if (custToOrdFlg[i] != null)
					model.setCustToOrdFlg(custToOrdFlg[i]);
				if (rcvrCneeNm[i] != null)
					model.setRcvrCneeNm(rcvrCneeNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rcvrFaxNo[i] != null)
					model.setRcvrFaxNo(rcvrFaxNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDoRcvrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DoRcvrVO[]
	 */
	public DoRcvrVO[] getDoRcvrVOs(){
		DoRcvrVO[] vos = (DoRcvrVO[])models.toArray(new DoRcvrVO[models.size()]);
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
		this.doNo = this.doNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNoSplit = this.doNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrEml = this.rcvrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrPhnNo = this.rcvrPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblNo = this.hblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrCoNm = this.rcvrCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picNm = this.picNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custToOrdFlg = this.custToOrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrCneeNm = this.rcvrCneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrFaxNo = this.rcvrFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
