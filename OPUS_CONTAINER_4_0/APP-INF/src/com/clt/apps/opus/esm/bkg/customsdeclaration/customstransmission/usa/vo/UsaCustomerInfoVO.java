/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomerInfoVO.java
*@FileTitle : UsaCustomerInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.07  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

public class UsaCustomerInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaCustomerInfoVO> models = new ArrayList<UsaCustomerInfoVO>();
	
	/* Column Info */
	private String buf26 = null;
	private String buf27 = null;
	/* Column Info */
	private String buf25 = null;
	/* Column Info */
	private String buf24 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String buf23 = null;
	/* Column Info */
	private String buf22 = null;
	/* Column Info */
	private String buf211 = null;
	/* Column Info */
	private String buf21 = null;
	/* Column Info */
	private String buf251 = null;
	/* Column Info */
	private String buf231 = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaCustomerInfoVO() {}

	public UsaCustomerInfoVO(String ibflag, String pagerows, String blNo, String buf21, String buf211, String buf22, String buf23, String buf231, String buf24, String buf25, String buf251, String buf26, String buf27) {
		this.buf26 = buf26;
		this.buf27 = buf27;		
		this.buf25 = buf25;
		this.buf24 = buf24;
		this.ibflag = ibflag;
		this.buf23 = buf23;
		this.buf22 = buf22;
		this.buf211 = buf211;
		this.buf21 = buf21;
		this.buf251 = buf251;
		this.buf231 = buf231;
		this.blNo = blNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("buf26", getBuf26());
		this.hashColumns.put("buf27", getBuf27());		
		this.hashColumns.put("buf25", getBuf25());
		this.hashColumns.put("buf24", getBuf24());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("buf23", getBuf23());
		this.hashColumns.put("buf22", getBuf22());
		this.hashColumns.put("buf21_1", getBuf211());
		this.hashColumns.put("buf21", getBuf21());
		this.hashColumns.put("buf25_1", getBuf251());
		this.hashColumns.put("buf23_1", getBuf231());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("buf26", "buf26");
		this.hashFields.put("buf27", "buf27");		
		this.hashFields.put("buf25", "buf25");
		this.hashFields.put("buf24", "buf24");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("buf23", "buf23");
		this.hashFields.put("buf22", "buf22");
		this.hashFields.put("buf21_1", "buf211");
		this.hashFields.put("buf21", "buf21");
		this.hashFields.put("buf25_1", "buf251");
		this.hashFields.put("buf23_1", "buf231");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return buf26
	 */
	public String getBuf26() {
		return this.buf26;
	}
	
	/**
	 * Column Info
	 * @return buf27
	 */
	public String getBuf27() {
		return this.buf27;
	}
		
	/**
	 * Column Info
	 * @return buf25
	 */
	public String getBuf25() {
		return this.buf25;
	}
	
	/**
	 * Column Info
	 * @return buf24
	 */
	public String getBuf24() {
		return this.buf24;
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
	 * @return buf23
	 */
	public String getBuf23() {
		return this.buf23;
	}
	
	/**
	 * Column Info
	 * @return buf22
	 */
	public String getBuf22() {
		return this.buf22;
	}
	
	/**
	 * Column Info
	 * @return buf211
	 */
	public String getBuf211() {
		return this.buf211;
	}
	
	/**
	 * Column Info
	 * @return buf21
	 */
	public String getBuf21() {
		return this.buf21;
	}
	
	/**
	 * Column Info
	 * @return buf251
	 */
	public String getBuf251() {
		return this.buf251;
	}
	
	/**
	 * Column Info
	 * @return buf231
	 */
	public String getBuf231() {
		return this.buf231;
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
	 * @param buf26
	 */
	public void setBuf26(String buf26) {
		this.buf26 = buf26;
	}
	
	/**
	 * Column Info
	 * @param buf27
	 */
	public void setBuf27(String buf27) {
		this.buf27 = buf27;
	}	
	
	/**
	 * Column Info
	 * @param buf25
	 */
	public void setBuf25(String buf25) {
		this.buf25 = buf25;
	}
	
	/**
	 * Column Info
	 * @param buf24
	 */
	public void setBuf24(String buf24) {
		this.buf24 = buf24;
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
	 * @param buf23
	 */
	public void setBuf23(String buf23) {
		this.buf23 = buf23;
	}
	
	/**
	 * Column Info
	 * @param buf22
	 */
	public void setBuf22(String buf22) {
		this.buf22 = buf22;
	}
	
	/**
	 * Column Info
	 * @param buf211
	 */
	public void setBuf211(String buf211) {
		this.buf211 = buf211;
	}
	
	/**
	 * Column Info
	 * @param buf21
	 */
	public void setBuf21(String buf21) {
		this.buf21 = buf21;
	}
	
	/**
	 * Column Info
	 * @param buf251
	 */
	public void setBuf251(String buf251) {
		this.buf251 = buf251;
	}
	
	/**
	 * Column Info
	 * @param buf231
	 */
	public void setBuf231(String buf231) {
		this.buf231 = buf231;
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
		setBuf26(JSPUtil.getParameter(request, prefix + "buf26", ""));
		setBuf27(JSPUtil.getParameter(request, prefix + "buf27", ""));		
		setBuf25(JSPUtil.getParameter(request, prefix + "buf25", ""));
		setBuf24(JSPUtil.getParameter(request, prefix + "buf24", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBuf23(JSPUtil.getParameter(request, prefix + "buf23", ""));
		setBuf22(JSPUtil.getParameter(request, prefix + "buf22", ""));
		setBuf211(JSPUtil.getParameter(request, prefix + "buf21_1", ""));
		setBuf21(JSPUtil.getParameter(request, prefix + "buf21", ""));
		setBuf251(JSPUtil.getParameter(request, prefix + "buf25_1", ""));
		setBuf231(JSPUtil.getParameter(request, prefix + "buf23_1", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaCustomerInfoVO[]
	 */
	public UsaCustomerInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaCustomerInfoVO[]
	 */
	public UsaCustomerInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaCustomerInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] buf26 = (JSPUtil.getParameter(request, prefix	+ "buf26", length));
			String[] buf27 = (JSPUtil.getParameter(request, prefix	+ "buf27", length));			
			String[] buf25 = (JSPUtil.getParameter(request, prefix	+ "buf25", length));
			String[] buf24 = (JSPUtil.getParameter(request, prefix	+ "buf24", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] buf23 = (JSPUtil.getParameter(request, prefix	+ "buf23", length));
			String[] buf22 = (JSPUtil.getParameter(request, prefix	+ "buf22", length));
			String[] buf211 = (JSPUtil.getParameter(request, prefix	+ "buf21_1", length));
			String[] buf21 = (JSPUtil.getParameter(request, prefix	+ "buf21", length));
			String[] buf251 = (JSPUtil.getParameter(request, prefix	+ "buf25_1", length));
			String[] buf231 = (JSPUtil.getParameter(request, prefix	+ "buf23_1", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaCustomerInfoVO();
				if (buf26[i] != null)
					model.setBuf26(buf26[i]);
				if (buf27[i] != null)
					model.setBuf27(buf27[i]);				
				if (buf25[i] != null)
					model.setBuf25(buf25[i]);
				if (buf24[i] != null)
					model.setBuf24(buf24[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (buf23[i] != null)
					model.setBuf23(buf23[i]);
				if (buf22[i] != null)
					model.setBuf22(buf22[i]);
				if (buf211[i] != null)
					model.setBuf211(buf211[i]);
				if (buf21[i] != null)
					model.setBuf21(buf21[i]);
				if (buf251[i] != null)
					model.setBuf251(buf251[i]);
				if (buf231[i] != null)
					model.setBuf231(buf231[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaCustomerInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaCustomerInfoVO[]
	 */
	public UsaCustomerInfoVO[] getUsaCustomerInfoVOs(){
		UsaCustomerInfoVO[] vos = (UsaCustomerInfoVO[])models.toArray(new UsaCustomerInfoVO[models.size()]);
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
		this.buf26 = this.buf26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buf27 = this.buf27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.buf25 = this.buf25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buf24 = this.buf24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buf23 = this.buf23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buf22 = this.buf22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buf211 = this.buf211 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buf21 = this.buf21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buf251 = this.buf251 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buf231 = this.buf231 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
