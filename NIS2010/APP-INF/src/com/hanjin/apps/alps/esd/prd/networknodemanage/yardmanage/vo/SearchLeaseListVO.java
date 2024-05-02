/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchLeaseListVO.java
*@FileTitle : SearchLeaseListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.07.27 김귀진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo;

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
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchLeaseListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchLeaseListVO> models = new ArrayList<SearchLeaseListVO>();
	
	/* Column Info */
	private String tel = null;
	/* Column Info */
	private String comCode10 = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String comName10 = null;
	/* Column Info */
	private String yardCode = null;
	/* Column Info */
	private String nodeCode = null;
	/* Column Info */
	private String comName1 = null;
	/* Column Info */
	private String comName2 = null;
	/* Column Info */
	private String fax = null;
	/* Column Info */
	private String comName3 = null;
	/* Column Info */
	private String comCode8 = null;
	/* Column Info */
	private String comCode9 = null;
	/* Column Info */
	private String comCode6 = null;
	/* Column Info */
	private String comCode7 = null;
	/* Column Info */
	private String countryCode = null;
	/* Column Info */
	private String comCode4 = null;
	/* Column Info */
	private String comName8 = null;
	/* Column Info */
	private String comName9 = null;
	/* Column Info */
	private String comCode5 = null;
	/* Column Info */
	private String comCode2 = null;
	/* Column Info */
	private String pic = null;
	/* Column Info */
	private String comCode3 = null;
	/* Column Info */
	private String comName4 = null;
	/* Column Info */
	private String comCode1 = null;
	/* Column Info */
	private String comName5 = null;
	/* Column Info */
	private String comName6 = null;
	/* Column Info */
	private String comName7 = null;
	/* Column Info */
	private String locationCode = null;
	/* Column Info */
	private String email = null;
	/* Column Info */
	private String address = null;
	/* Column Info */
	private String yardName = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchLeaseListVO() {}

	public SearchLeaseListVO(String ibflag, String pagerows, String yardCode, String yardName, String address, String pic, String tel, String fax, String email, String comCode1, String comName1, String comCode2, String comName2, String comCode3, String comName3, String comCode4, String comName4, String comCode5, String comName5, String comCode6, String comName6, String comCode7, String comName7, String comCode8, String comName8, String comCode9, String comName9, String comCode10, String comName10, String nodeCode, String countryCode, String locationCode) {
		this.tel = tel;
		this.comCode10 = comCode10;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.comName10 = comName10;
		this.yardCode = yardCode;
		this.nodeCode = nodeCode;
		this.comName1 = comName1;
		this.comName2 = comName2;
		this.fax = fax;
		this.comName3 = comName3;
		this.comCode8 = comCode8;
		this.comCode9 = comCode9;
		this.comCode6 = comCode6;
		this.comCode7 = comCode7;
		this.countryCode = countryCode;
		this.comCode4 = comCode4;
		this.comName8 = comName8;
		this.comName9 = comName9;
		this.comCode5 = comCode5;
		this.comCode2 = comCode2;
		this.pic = pic;
		this.comCode3 = comCode3;
		this.comName4 = comName4;
		this.comCode1 = comCode1;
		this.comName5 = comName5;
		this.comName6 = comName6;
		this.comName7 = comName7;
		this.locationCode = locationCode;
		this.email = email;
		this.address = address;
		this.yardName = yardName;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tel", getTel());
		this.hashColumns.put("com_code10", getComCode10());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("com_name10", getComName10());
		this.hashColumns.put("yard_code", getYardCode());
		this.hashColumns.put("node_code", getNodeCode());
		this.hashColumns.put("com_name1", getComName1());
		this.hashColumns.put("com_name2", getComName2());
		this.hashColumns.put("fax", getFax());
		this.hashColumns.put("com_name3", getComName3());
		this.hashColumns.put("com_code8", getComCode8());
		this.hashColumns.put("com_code9", getComCode9());
		this.hashColumns.put("com_code6", getComCode6());
		this.hashColumns.put("com_code7", getComCode7());
		this.hashColumns.put("country_code", getCountryCode());
		this.hashColumns.put("com_code4", getComCode4());
		this.hashColumns.put("com_name8", getComName8());
		this.hashColumns.put("com_name9", getComName9());
		this.hashColumns.put("com_code5", getComCode5());
		this.hashColumns.put("com_code2", getComCode2());
		this.hashColumns.put("pic", getPic());
		this.hashColumns.put("com_code3", getComCode3());
		this.hashColumns.put("com_name4", getComName4());
		this.hashColumns.put("com_code1", getComCode1());
		this.hashColumns.put("com_name5", getComName5());
		this.hashColumns.put("com_name6", getComName6());
		this.hashColumns.put("com_name7", getComName7());
		this.hashColumns.put("location_code", getLocationCode());
		this.hashColumns.put("email", getEmail());
		this.hashColumns.put("address", getAddress());
		this.hashColumns.put("yard_name", getYardName());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tel", "tel");
		this.hashFields.put("com_code10", "comCode10");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("com_name10", "comName10");
		this.hashFields.put("yard_code", "yardCode");
		this.hashFields.put("node_code", "nodeCode");
		this.hashFields.put("com_name1", "comName1");
		this.hashFields.put("com_name2", "comName2");
		this.hashFields.put("fax", "fax");
		this.hashFields.put("com_name3", "comName3");
		this.hashFields.put("com_code8", "comCode8");
		this.hashFields.put("com_code9", "comCode9");
		this.hashFields.put("com_code6", "comCode6");
		this.hashFields.put("com_code7", "comCode7");
		this.hashFields.put("country_code", "countryCode");
		this.hashFields.put("com_code4", "comCode4");
		this.hashFields.put("com_name8", "comName8");
		this.hashFields.put("com_name9", "comName9");
		this.hashFields.put("com_code5", "comCode5");
		this.hashFields.put("com_code2", "comCode2");
		this.hashFields.put("pic", "pic");
		this.hashFields.put("com_code3", "comCode3");
		this.hashFields.put("com_name4", "comName4");
		this.hashFields.put("com_code1", "comCode1");
		this.hashFields.put("com_name5", "comName5");
		this.hashFields.put("com_name6", "comName6");
		this.hashFields.put("com_name7", "comName7");
		this.hashFields.put("location_code", "locationCode");
		this.hashFields.put("email", "email");
		this.hashFields.put("address", "address");
		this.hashFields.put("yard_name", "yardName");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tel
	 */
	public String getTel() {
		return this.tel;
	}
	
	/**
	 * Column Info
	 * @return comCode10
	 */
	public String getComCode10() {
		return this.comCode10;
	}
	
	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return comName10
	 */
	public String getComName10() {
		return this.comName10;
	}
	
	/**
	 * Column Info
	 * @return yardCode
	 */
	public String getYardCode() {
		return this.yardCode;
	}
	
	/**
	 * Column Info
	 * @return nodeCode
	 */
	public String getNodeCode() {
		return this.nodeCode;
	}
	
	/**
	 * Column Info
	 * @return comName1
	 */
	public String getComName1() {
		return this.comName1;
	}
	
	/**
	 * Column Info
	 * @return comName2
	 */
	public String getComName2() {
		return this.comName2;
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
	 * @return comName3
	 */
	public String getComName3() {
		return this.comName3;
	}
	
	/**
	 * Column Info
	 * @return comCode8
	 */
	public String getComCode8() {
		return this.comCode8;
	}
	
	/**
	 * Column Info
	 * @return comCode9
	 */
	public String getComCode9() {
		return this.comCode9;
	}
	
	/**
	 * Column Info
	 * @return comCode6
	 */
	public String getComCode6() {
		return this.comCode6;
	}
	
	/**
	 * Column Info
	 * @return comCode7
	 */
	public String getComCode7() {
		return this.comCode7;
	}
	
	/**
	 * Column Info
	 * @return countryCode
	 */
	public String getCountryCode() {
		return this.countryCode;
	}
	
	/**
	 * Column Info
	 * @return comCode4
	 */
	public String getComCode4() {
		return this.comCode4;
	}
	
	/**
	 * Column Info
	 * @return comName8
	 */
	public String getComName8() {
		return this.comName8;
	}
	
	/**
	 * Column Info
	 * @return comName9
	 */
	public String getComName9() {
		return this.comName9;
	}
	
	/**
	 * Column Info
	 * @return comCode5
	 */
	public String getComCode5() {
		return this.comCode5;
	}
	
	/**
	 * Column Info
	 * @return comCode2
	 */
	public String getComCode2() {
		return this.comCode2;
	}
	
	/**
	 * Column Info
	 * @return pic
	 */
	public String getPic() {
		return this.pic;
	}
	
	/**
	 * Column Info
	 * @return comCode3
	 */
	public String getComCode3() {
		return this.comCode3;
	}
	
	/**
	 * Column Info
	 * @return comName4
	 */
	public String getComName4() {
		return this.comName4;
	}
	
	/**
	 * Column Info
	 * @return comCode1
	 */
	public String getComCode1() {
		return this.comCode1;
	}
	
	/**
	 * Column Info
	 * @return comName5
	 */
	public String getComName5() {
		return this.comName5;
	}
	
	/**
	 * Column Info
	 * @return comName6
	 */
	public String getComName6() {
		return this.comName6;
	}
	
	/**
	 * Column Info
	 * @return comName7
	 */
	public String getComName7() {
		return this.comName7;
	}
	
	/**
	 * Column Info
	 * @return locationCode
	 */
	public String getLocationCode() {
		return this.locationCode;
	}
	
	/**
	 * Column Info
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Column Info
	 * @return address
	 */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * Column Info
	 * @return yardName
	 */
	public String getYardName() {
		return this.yardName;
	}
	

	/**
	 * Column Info
	 * @param tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	/**
	 * Column Info
	 * @param comCode10
	 */
	public void setComCode10(String comCode10) {
		this.comCode10 = comCode10;
	}
	
	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param comName10
	 */
	public void setComName10(String comName10) {
		this.comName10 = comName10;
	}
	
	/**
	 * Column Info
	 * @param yardCode
	 */
	public void setYardCode(String yardCode) {
		this.yardCode = yardCode;
	}
	
	/**
	 * Column Info
	 * @param nodeCode
	 */
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}
	
	/**
	 * Column Info
	 * @param comName1
	 */
	public void setComName1(String comName1) {
		this.comName1 = comName1;
	}
	
	/**
	 * Column Info
	 * @param comName2
	 */
	public void setComName2(String comName2) {
		this.comName2 = comName2;
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
	 * @param comName3
	 */
	public void setComName3(String comName3) {
		this.comName3 = comName3;
	}
	
	/**
	 * Column Info
	 * @param comCode8
	 */
	public void setComCode8(String comCode8) {
		this.comCode8 = comCode8;
	}
	
	/**
	 * Column Info
	 * @param comCode9
	 */
	public void setComCode9(String comCode9) {
		this.comCode9 = comCode9;
	}
	
	/**
	 * Column Info
	 * @param comCode6
	 */
	public void setComCode6(String comCode6) {
		this.comCode6 = comCode6;
	}
	
	/**
	 * Column Info
	 * @param comCode7
	 */
	public void setComCode7(String comCode7) {
		this.comCode7 = comCode7;
	}
	
	/**
	 * Column Info
	 * @param countryCode
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	/**
	 * Column Info
	 * @param comCode4
	 */
	public void setComCode4(String comCode4) {
		this.comCode4 = comCode4;
	}
	
	/**
	 * Column Info
	 * @param comName8
	 */
	public void setComName8(String comName8) {
		this.comName8 = comName8;
	}
	
	/**
	 * Column Info
	 * @param comName9
	 */
	public void setComName9(String comName9) {
		this.comName9 = comName9;
	}
	
	/**
	 * Column Info
	 * @param comCode5
	 */
	public void setComCode5(String comCode5) {
		this.comCode5 = comCode5;
	}
	
	/**
	 * Column Info
	 * @param comCode2
	 */
	public void setComCode2(String comCode2) {
		this.comCode2 = comCode2;
	}
	
	/**
	 * Column Info
	 * @param pic
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	/**
	 * Column Info
	 * @param comCode3
	 */
	public void setComCode3(String comCode3) {
		this.comCode3 = comCode3;
	}
	
	/**
	 * Column Info
	 * @param comName4
	 */
	public void setComName4(String comName4) {
		this.comName4 = comName4;
	}
	
	/**
	 * Column Info
	 * @param comCode1
	 */
	public void setComCode1(String comCode1) {
		this.comCode1 = comCode1;
	}
	
	/**
	 * Column Info
	 * @param comName5
	 */
	public void setComName5(String comName5) {
		this.comName5 = comName5;
	}
	
	/**
	 * Column Info
	 * @param comName6
	 */
	public void setComName6(String comName6) {
		this.comName6 = comName6;
	}
	
	/**
	 * Column Info
	 * @param comName7
	 */
	public void setComName7(String comName7) {
		this.comName7 = comName7;
	}
	
	/**
	 * Column Info
	 * @param locationCode
	 */
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	
	/**
	 * Column Info
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Column Info
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Column Info
	 * @param yardName
	 */
	public void setYardName(String yardName) {
		this.yardName = yardName;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTel(JSPUtil.getParameter(request, "tel", ""));
		setComCode10(JSPUtil.getParameter(request, "com_code10", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setComName10(JSPUtil.getParameter(request, "com_name10", ""));
		setYardCode(JSPUtil.getParameter(request, "yard_code", ""));
		setNodeCode(JSPUtil.getParameter(request, "node_code", ""));
		setComName1(JSPUtil.getParameter(request, "com_name1", ""));
		setComName2(JSPUtil.getParameter(request, "com_name2", ""));
		setFax(JSPUtil.getParameter(request, "fax", ""));
		setComName3(JSPUtil.getParameter(request, "com_name3", ""));
		setComCode8(JSPUtil.getParameter(request, "com_code8", ""));
		setComCode9(JSPUtil.getParameter(request, "com_code9", ""));
		setComCode6(JSPUtil.getParameter(request, "com_code6", ""));
		setComCode7(JSPUtil.getParameter(request, "com_code7", ""));
		setCountryCode(JSPUtil.getParameter(request, "country_code", ""));
		setComCode4(JSPUtil.getParameter(request, "com_code4", ""));
		setComName8(JSPUtil.getParameter(request, "com_name8", ""));
		setComName9(JSPUtil.getParameter(request, "com_name9", ""));
		setComCode5(JSPUtil.getParameter(request, "com_code5", ""));
		setComCode2(JSPUtil.getParameter(request, "com_code2", ""));
		setPic(JSPUtil.getParameter(request, "pic", ""));
		setComCode3(JSPUtil.getParameter(request, "com_code3", ""));
		setComName4(JSPUtil.getParameter(request, "com_name4", ""));
		setComCode1(JSPUtil.getParameter(request, "com_code1", ""));
		setComName5(JSPUtil.getParameter(request, "com_name5", ""));
		setComName6(JSPUtil.getParameter(request, "com_name6", ""));
		setComName7(JSPUtil.getParameter(request, "com_name7", ""));
		setLocationCode(JSPUtil.getParameter(request, "location_code", ""));
		setEmail(JSPUtil.getParameter(request, "email", ""));
		setAddress(JSPUtil.getParameter(request, "address", ""));
		setYardName(JSPUtil.getParameter(request, "yard_name", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchLeaseListVO[]
	 */
	public SearchLeaseListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchLeaseListVO[]
	 */
	public SearchLeaseListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchLeaseListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tel = (JSPUtil.getParameter(request, prefix	+ "tel", length));
			String[] comCode10 = (JSPUtil.getParameter(request, prefix	+ "com_code10", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] comName10 = (JSPUtil.getParameter(request, prefix	+ "com_name10", length));
			String[] yardCode = (JSPUtil.getParameter(request, prefix	+ "yard_code", length));
			String[] nodeCode = (JSPUtil.getParameter(request, prefix	+ "node_code", length));
			String[] comName1 = (JSPUtil.getParameter(request, prefix	+ "com_name1", length));
			String[] comName2 = (JSPUtil.getParameter(request, prefix	+ "com_name2", length));
			String[] fax = (JSPUtil.getParameter(request, prefix	+ "fax", length));
			String[] comName3 = (JSPUtil.getParameter(request, prefix	+ "com_name3", length));
			String[] comCode8 = (JSPUtil.getParameter(request, prefix	+ "com_code8", length));
			String[] comCode9 = (JSPUtil.getParameter(request, prefix	+ "com_code9", length));
			String[] comCode6 = (JSPUtil.getParameter(request, prefix	+ "com_code6", length));
			String[] comCode7 = (JSPUtil.getParameter(request, prefix	+ "com_code7", length));
			String[] countryCode = (JSPUtil.getParameter(request, prefix	+ "country_code", length));
			String[] comCode4 = (JSPUtil.getParameter(request, prefix	+ "com_code4", length));
			String[] comName8 = (JSPUtil.getParameter(request, prefix	+ "com_name8", length));
			String[] comName9 = (JSPUtil.getParameter(request, prefix	+ "com_name9", length));
			String[] comCode5 = (JSPUtil.getParameter(request, prefix	+ "com_code5", length));
			String[] comCode2 = (JSPUtil.getParameter(request, prefix	+ "com_code2", length));
			String[] pic = (JSPUtil.getParameter(request, prefix	+ "pic", length));
			String[] comCode3 = (JSPUtil.getParameter(request, prefix	+ "com_code3", length));
			String[] comName4 = (JSPUtil.getParameter(request, prefix	+ "com_name4", length));
			String[] comCode1 = (JSPUtil.getParameter(request, prefix	+ "com_code1", length));
			String[] comName5 = (JSPUtil.getParameter(request, prefix	+ "com_name5", length));
			String[] comName6 = (JSPUtil.getParameter(request, prefix	+ "com_name6", length));
			String[] comName7 = (JSPUtil.getParameter(request, prefix	+ "com_name7", length));
			String[] locationCode = (JSPUtil.getParameter(request, prefix	+ "location_code", length));
			String[] email = (JSPUtil.getParameter(request, prefix	+ "email", length));
			String[] address = (JSPUtil.getParameter(request, prefix	+ "address", length));
			String[] yardName = (JSPUtil.getParameter(request, prefix	+ "yard_name", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchLeaseListVO();
				if (tel[i] != null)
					model.setTel(tel[i]);
				if (comCode10[i] != null)
					model.setComCode10(comCode10[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (comName10[i] != null)
					model.setComName10(comName10[i]);
				if (yardCode[i] != null)
					model.setYardCode(yardCode[i]);
				if (nodeCode[i] != null)
					model.setNodeCode(nodeCode[i]);
				if (comName1[i] != null)
					model.setComName1(comName1[i]);
				if (comName2[i] != null)
					model.setComName2(comName2[i]);
				if (fax[i] != null)
					model.setFax(fax[i]);
				if (comName3[i] != null)
					model.setComName3(comName3[i]);
				if (comCode8[i] != null)
					model.setComCode8(comCode8[i]);
				if (comCode9[i] != null)
					model.setComCode9(comCode9[i]);
				if (comCode6[i] != null)
					model.setComCode6(comCode6[i]);
				if (comCode7[i] != null)
					model.setComCode7(comCode7[i]);
				if (countryCode[i] != null)
					model.setCountryCode(countryCode[i]);
				if (comCode4[i] != null)
					model.setComCode4(comCode4[i]);
				if (comName8[i] != null)
					model.setComName8(comName8[i]);
				if (comName9[i] != null)
					model.setComName9(comName9[i]);
				if (comCode5[i] != null)
					model.setComCode5(comCode5[i]);
				if (comCode2[i] != null)
					model.setComCode2(comCode2[i]);
				if (pic[i] != null)
					model.setPic(pic[i]);
				if (comCode3[i] != null)
					model.setComCode3(comCode3[i]);
				if (comName4[i] != null)
					model.setComName4(comName4[i]);
				if (comCode1[i] != null)
					model.setComCode1(comCode1[i]);
				if (comName5[i] != null)
					model.setComName5(comName5[i]);
				if (comName6[i] != null)
					model.setComName6(comName6[i]);
				if (comName7[i] != null)
					model.setComName7(comName7[i]);
				if (locationCode[i] != null)
					model.setLocationCode(locationCode[i]);
				if (email[i] != null)
					model.setEmail(email[i]);
				if (address[i] != null)
					model.setAddress(address[i]);
				if (yardName[i] != null)
					model.setYardName(yardName[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchLeaseListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchLeaseListVO[]
	 */
	public SearchLeaseListVO[] getSearchLeaseListVOs(){
		SearchLeaseListVO[] vos = (SearchLeaseListVO[])models.toArray(new SearchLeaseListVO[models.size()]);
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
		this.tel = this.tel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comCode10 = this.comCode10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comName10 = this.comName10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardCode = this.yardCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodeCode = this.nodeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comName1 = this.comName1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comName2 = this.comName2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fax = this.fax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comName3 = this.comName3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comCode8 = this.comCode8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comCode9 = this.comCode9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comCode6 = this.comCode6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comCode7 = this.comCode7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.countryCode = this.countryCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comCode4 = this.comCode4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comName8 = this.comName8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comName9 = this.comName9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comCode5 = this.comCode5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comCode2 = this.comCode2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic = this.pic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comCode3 = this.comCode3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comName4 = this.comName4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comCode1 = this.comCode1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comName5 = this.comName5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comName6 = this.comName6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comName7 = this.comName7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationCode = this.locationCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.email = this.email .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.address = this.address .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardName = this.yardName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
