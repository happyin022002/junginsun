/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustLineInfoVO.java
*@FileTitle : CustLineInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.17  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo;

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

public class CustLineInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustLineInfoVO> models = new ArrayList<CustLineInfoVO>();
	
	/* Column Info */
	private String n03 = null;
	/* Column Info */
	private String n02 = null;
	/* Column Info */
	private String u02 = null;
	/* Column Info */
	private String u01 = null;
	/* Column Info */
	private String u03 = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String orzPty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String s03 = null;
	/* Column Info */
	private String s01 = null;
	/* Column Info */
	private String s02 = null;
	/* Column Info */
	private String n01 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustLineInfoVO() {}

	public CustLineInfoVO(String ibflag, String pagerows, String blNo, String s01, String s02, String s03, String u01, String u02, String u03, String n01, String n02, String n03, String orzPty) {
		this.n03 = n03;
		this.n02 = n02;
		this.u02 = u02;
		this.u01 = u01;
		this.u03 = u03;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.orzPty = orzPty;
		this.ibflag = ibflag;
		this.s03 = s03;
		this.s01 = s01;
		this.s02 = s02;
		this.n01 = n01;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n03", getN03());
		this.hashColumns.put("n02", getN02());
		this.hashColumns.put("u02", getU02());
		this.hashColumns.put("u01", getU01());
		this.hashColumns.put("u03", getU03());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("orz_pty", getOrzPty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s03", getS03());
		this.hashColumns.put("s01", getS01());
		this.hashColumns.put("s02", getS02());
		this.hashColumns.put("n01", getN01());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n03", "n03");
		this.hashFields.put("n02", "n02");
		this.hashFields.put("u02", "u02");
		this.hashFields.put("u01", "u01");
		this.hashFields.put("u03", "u03");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("orz_pty", "orzPty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s03", "s03");
		this.hashFields.put("s01", "s01");
		this.hashFields.put("s02", "s02");
		this.hashFields.put("n01", "n01");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return n03
	 */
	public String getN03() {
		return this.n03;
	}
	
	/**
	 * Column Info
	 * @return n02
	 */
	public String getN02() {
		return this.n02;
	}
	
	/**
	 * Column Info
	 * @return u02
	 */
	public String getU02() {
		return this.u02;
	}
	
	/**
	 * Column Info
	 * @return u01
	 */
	public String getU01() {
		return this.u01;
	}
	
	/**
	 * Column Info
	 * @return u03
	 */
	public String getU03() {
		return this.u03;
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
	 * Column Info
	 * @return orzPty
	 */
	public String getOrzPty() {
		return this.orzPty;
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
	 * @return s03
	 */
	public String getS03() {
		return this.s03;
	}
	
	/**
	 * Column Info
	 * @return s01
	 */
	public String getS01() {
		return this.s01;
	}
	
	/**
	 * Column Info
	 * @return s02
	 */
	public String getS02() {
		return this.s02;
	}
	
	/**
	 * Column Info
	 * @return n01
	 */
	public String getN01() {
		return this.n01;
	}
	

	/**
	 * Column Info
	 * @param n03
	 */
	public void setN03(String n03) {
		this.n03 = n03;
	}
	
	/**
	 * Column Info
	 * @param n02
	 */
	public void setN02(String n02) {
		this.n02 = n02;
	}
	
	/**
	 * Column Info
	 * @param u02
	 */
	public void setU02(String u02) {
		this.u02 = u02;
	}
	
	/**
	 * Column Info
	 * @param u01
	 */
	public void setU01(String u01) {
		this.u01 = u01;
	}
	
	/**
	 * Column Info
	 * @param u03
	 */
	public void setU03(String u03) {
		this.u03 = u03;
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
	 * Column Info
	 * @param orzPty
	 */
	public void setOrzPty(String orzPty) {
		this.orzPty = orzPty;
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
	 * @param s03
	 */
	public void setS03(String s03) {
		this.s03 = s03;
	}
	
	/**
	 * Column Info
	 * @param s01
	 */
	public void setS01(String s01) {
		this.s01 = s01;
	}
	
	/**
	 * Column Info
	 * @param s02
	 */
	public void setS02(String s02) {
		this.s02 = s02;
	}
	
	/**
	 * Column Info
	 * @param n01
	 */
	public void setN01(String n01) {
		this.n01 = n01;
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
		setN03(JSPUtil.getParameter(request, prefix + "n03", ""));
		setN02(JSPUtil.getParameter(request, prefix + "n02", ""));
		setU02(JSPUtil.getParameter(request, prefix + "u02", ""));
		setU01(JSPUtil.getParameter(request, prefix + "u01", ""));
		setU03(JSPUtil.getParameter(request, prefix + "u03", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOrzPty(JSPUtil.getParameter(request, prefix + "orz_pty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setS03(JSPUtil.getParameter(request, prefix + "s03", ""));
		setS01(JSPUtil.getParameter(request, prefix + "s01", ""));
		setS02(JSPUtil.getParameter(request, prefix + "s02", ""));
		setN01(JSPUtil.getParameter(request, prefix + "n01", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustLineInfoVO[]
	 */
	public CustLineInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustLineInfoVO[]
	 */
	public CustLineInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustLineInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] n03 = (JSPUtil.getParameter(request, prefix	+ "n03", length));
			String[] n02 = (JSPUtil.getParameter(request, prefix	+ "n02", length));
			String[] u02 = (JSPUtil.getParameter(request, prefix	+ "u02", length));
			String[] u01 = (JSPUtil.getParameter(request, prefix	+ "u01", length));
			String[] u03 = (JSPUtil.getParameter(request, prefix	+ "u03", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] orzPty = (JSPUtil.getParameter(request, prefix	+ "orz_pty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] s03 = (JSPUtil.getParameter(request, prefix	+ "s03", length));
			String[] s01 = (JSPUtil.getParameter(request, prefix	+ "s01", length));
			String[] s02 = (JSPUtil.getParameter(request, prefix	+ "s02", length));
			String[] n01 = (JSPUtil.getParameter(request, prefix	+ "n01", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustLineInfoVO();
				if (n03[i] != null)
					model.setN03(n03[i]);
				if (n02[i] != null)
					model.setN02(n02[i]);
				if (u02[i] != null)
					model.setU02(u02[i]);
				if (u01[i] != null)
					model.setU01(u01[i]);
				if (u03[i] != null)
					model.setU03(u03[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (orzPty[i] != null)
					model.setOrzPty(orzPty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (s03[i] != null)
					model.setS03(s03[i]);
				if (s01[i] != null)
					model.setS01(s01[i]);
				if (s02[i] != null)
					model.setS02(s02[i]);
				if (n01[i] != null)
					model.setN01(n01[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustLineInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustLineInfoVO[]
	 */
	public CustLineInfoVO[] getCustLineInfoVOs(){
		CustLineInfoVO[] vos = (CustLineInfoVO[])models.toArray(new CustLineInfoVO[models.size()]);
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
		this.n03 = this.n03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n02 = this.n02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.u02 = this.u02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.u01 = this.u01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.u03 = this.u03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orzPty = this.orzPty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s03 = this.s03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s01 = this.s01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s02 = this.s02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n01 = this.n01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
