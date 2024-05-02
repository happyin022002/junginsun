/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSAMainPartiesVO.java
*@FileTitle : PSAMainPartiesVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.03
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo;

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

public class PSAMainPartiesVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<PSAMainPartiesVO> models = new ArrayList<PSAMainPartiesVO>();

	/* Column Info */
	private String authorized = null;
	/* Column Info */
	private String phone = null;
	/* Column Info */
	private String partyType = null;
	/* Column Info */
	private String fax = null;
	/* Column Info */
	private String address1 = null;
	/* Column Info */
	private String address2 = null;
	/* Column Info */
	private String address3 = null;
	/* Column Info */
	private String contact = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String address5 = null;
	/* Column Info */
	private String address4 = null;
	/* Column Info */
	private String partyId = null;
	/* Column Info */
	private String ref1 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public PSAMainPartiesVO() {}

	public PSAMainPartiesVO(String ibflag, String pagerows, String partyType, String partyId, String authorized, String address1, String address2, String address3, String address4, String address5, String contact, String phone, String fax, String ref1) {
		this.authorized = authorized;
		this.phone = phone;
		this.partyType = partyType;
		this.fax = fax;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.contact = contact;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.address5 = address5;
		this.address4 = address4;
		this.partyId = partyId;
		this.ref1 = ref1;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("authorized", getAuthorized());
		this.hashColumns.put("phone", getPhone());
		this.hashColumns.put("party_type", getPartyType());
		this.hashColumns.put("fax", getFax());
		this.hashColumns.put("address1", getAddress1());
		this.hashColumns.put("address2", getAddress2());
		this.hashColumns.put("address3", getAddress3());
		this.hashColumns.put("contact", getContact());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("address5", getAddress5());
		this.hashColumns.put("address4", getAddress4());
		this.hashColumns.put("party_id", getPartyId());
		this.hashColumns.put("ref1", getRef1());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("authorized", "authorized");
		this.hashFields.put("phone", "phone");
		this.hashFields.put("party_type", "partyType");
		this.hashFields.put("fax", "fax");
		this.hashFields.put("address1", "address1");
		this.hashFields.put("address2", "address2");
		this.hashFields.put("address3", "address3");
		this.hashFields.put("contact", "contact");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("address5", "address5");
		this.hashFields.put("address4", "address4");
		this.hashFields.put("party_id", "partyId");
		this.hashFields.put("ref1", "ref1");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return authorized
	 */
	public String getAuthorized() {
		return this.authorized;
	}

	/**
	 * Column Info
	 * @return phone
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * Column Info
	 * @return partyType
	 */
	public String getPartyType() {
		return this.partyType;
	}

	/**
	 * Column Info
	 * @return fax
	 */
	public String getFax() {
		return this.fax;
	}

	/**
	 * Column Info
	 * @return address1
	 */
	public String getAddress1() {
		return this.address1;
	}

	/**
	 * Column Info
	 * @return address2
	 */
	public String getAddress2() {
		return this.address2;
	}

	/**
	 * Column Info
	 * @return address3
	 */
	public String getAddress3() {
		return this.address3;
	}

	/**
	 * Column Info
	 * @return contact
	 */
	public String getContact() {
		return this.contact;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * @return address5
	 */
	public String getAddress5() {
		return this.address5;
	}

	/**
	 * Column Info
	 * @return address4
	 */
	public String getAddress4() {
		return this.address4;
	}

	/**
	 * Column Info
	 * @return partyId
	 */
	public String getPartyId() {
		return this.partyId;
	}

	/**
	 * Column Info
	 * @return ref1
	 */
	public String getRef1() {
		return this.ref1;
	}


	/**
	 * Column Info
	 * @param authorized
	 */
	public void setAuthorized(String authorized) {
		this.authorized = authorized;
	}

	/**
	 * Column Info
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Column Info
	 * @param partyType
	 */
	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}

	/**
	 * Column Info
	 * @param fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * Column Info
	 * @param address1
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * Column Info
	 * @param address2
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * Column Info
	 * @param address3
	 */
	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	/**
	 * Column Info
	 * @param contact
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param address5
	 */
	public void setAddress5(String address5) {
		this.address5 = address5;
	}

	/**
	 * Column Info
	 * @param address4
	 */
	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	/**
	 * Column Info
	 * @param partyId
	 */
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	/**
	 * Column Info
	 * @param ref1
	 */
	public void setRef1(String ref1) {
		this.ref1 = ref1;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAuthorized(JSPUtil.getParameter(request, "authorized", ""));
		setPhone(JSPUtil.getParameter(request, "phone", ""));
		setPartyType(JSPUtil.getParameter(request, "party_type", ""));
		setFax(JSPUtil.getParameter(request, "fax", ""));
		setAddress1(JSPUtil.getParameter(request, "address1", ""));
		setAddress2(JSPUtil.getParameter(request, "address2", ""));
		setAddress3(JSPUtil.getParameter(request, "address3", ""));
		setContact(JSPUtil.getParameter(request, "contact", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAddress5(JSPUtil.getParameter(request, "address5", ""));
		setAddress4(JSPUtil.getParameter(request, "address4", ""));
		setPartyId(JSPUtil.getParameter(request, "party_id", ""));
		setRef1(JSPUtil.getParameter(request, "ref1", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PSAMainPartiesVO[]
	 */
	public PSAMainPartiesVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PSAMainPartiesVO[]
	 */
	public PSAMainPartiesVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PSAMainPartiesVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] authorized = (JSPUtil.getParameter(request, prefix	+ "authorized", length));
			String[] phone = (JSPUtil.getParameter(request, prefix	+ "phone", length));
			String[] partyType = (JSPUtil.getParameter(request, prefix	+ "party_type", length));
			String[] fax = (JSPUtil.getParameter(request, prefix	+ "fax", length));
			String[] address1 = (JSPUtil.getParameter(request, prefix	+ "address1", length));
			String[] address2 = (JSPUtil.getParameter(request, prefix	+ "address2", length));
			String[] address3 = (JSPUtil.getParameter(request, prefix	+ "address3", length));
			String[] contact = (JSPUtil.getParameter(request, prefix	+ "contact", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] address5 = (JSPUtil.getParameter(request, prefix	+ "address5", length));
			String[] address4 = (JSPUtil.getParameter(request, prefix	+ "address4", length));
			String[] partyId = (JSPUtil.getParameter(request, prefix	+ "party_id", length));
			String[] ref1 = (JSPUtil.getParameter(request, prefix	+ "ref1", length));

			for (int i = 0; i < length; i++) {
				model = new PSAMainPartiesVO();
				if (authorized[i] != null)
					model.setAuthorized(authorized[i]);
				if (phone[i] != null)
					model.setPhone(phone[i]);
				if (partyType[i] != null)
					model.setPartyType(partyType[i]);
				if (fax[i] != null)
					model.setFax(fax[i]);
				if (address1[i] != null)
					model.setAddress1(address1[i]);
				if (address2[i] != null)
					model.setAddress2(address2[i]);
				if (address3[i] != null)
					model.setAddress3(address3[i]);
				if (contact[i] != null)
					model.setContact(contact[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (address5[i] != null)
					model.setAddress5(address5[i]);
				if (address4[i] != null)
					model.setAddress4(address4[i]);
				if (partyId[i] != null)
					model.setPartyId(partyId[i]);
				if (ref1[i] != null)
					model.setRef1(ref1[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPSAMainPartiesVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PSAMainPartiesVO[]
	 */
	public PSAMainPartiesVO[] getPSAMainPartiesVOs(){
		PSAMainPartiesVO[] vos = (PSAMainPartiesVO[])models.toArray(new PSAMainPartiesVO[models.size()]);
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
		this.authorized = this.authorized .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phone = this.phone .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partyType = this.partyType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fax = this.fax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.address1 = this.address1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.address2 = this.address2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.address3 = this.address3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contact = this.contact .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.address5 = this.address5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.address4 = this.address4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partyId = this.partyId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ref1 = this.ref1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
