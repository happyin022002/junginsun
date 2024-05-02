/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MalaysiaManifestMarkInfoVO.java
*@FileTitle : MalaysiaManifestMarkInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.15  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo;

import java.lang.reflect.Field;
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
 
public class MalaysiaManifestMarkInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MalaysiaManifestMarkInfoVO> models = new ArrayList<MalaysiaManifestMarkInfoVO>();
	
	/* Column Info */
	private String mark10 = null;
	/* Column Info */
	private String mark9 = null;
	/* Column Info */
	private String mark8 = null;
	/* Column Info */
	private String mark7 = null;
	/* Column Info */
	private String mark6 = null;
	/* Column Info */
	private String mark5 = null;
	/* Column Info */
	private String mark4 = null;
	/* Column Info */
	private String mark3 = null;
	/* Column Info */
	private String mark2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mark1 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MalaysiaManifestMarkInfoVO() {}

	public MalaysiaManifestMarkInfoVO(String ibflag, String pagerows, String mark1, String mark2, String mark3, String mark4, String mark5, String mark6, String mark7, String mark8, String mark9, String mark10) {
		this.mark10 = mark10;
		this.mark9 = mark9;
		this.mark8 = mark8;
		this.mark7 = mark7;
		this.mark6 = mark6;
		this.mark5 = mark5;
		this.mark4 = mark4;
		this.mark3 = mark3;
		this.mark2 = mark2;
		this.ibflag = ibflag;
		this.mark1 = mark1;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mark10", getMark10());
		this.hashColumns.put("mark9", getMark9());
		this.hashColumns.put("mark8", getMark8());
		this.hashColumns.put("mark7", getMark7());
		this.hashColumns.put("mark6", getMark6());
		this.hashColumns.put("mark5", getMark5());
		this.hashColumns.put("mark4", getMark4());
		this.hashColumns.put("mark3", getMark3());
		this.hashColumns.put("mark2", getMark2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mark1", getMark1());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mark10", "mark10");
		this.hashFields.put("mark9", "mark9");
		this.hashFields.put("mark8", "mark8");
		this.hashFields.put("mark7", "mark7");
		this.hashFields.put("mark6", "mark6");
		this.hashFields.put("mark5", "mark5");
		this.hashFields.put("mark4", "mark4");
		this.hashFields.put("mark3", "mark3");
		this.hashFields.put("mark2", "mark2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mark1", "mark1");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mark10
	 */
	public String getMark10() {
		return this.mark10;
	}
	
	/**
	 * Column Info
	 * @return mark9
	 */
	public String getMark9() {
		return this.mark9;
	}
	
	/**
	 * Column Info
	 * @return mark8
	 */
	public String getMark8() {
		return this.mark8;
	}
	
	/**
	 * Column Info
	 * @return mark7
	 */
	public String getMark7() {
		return this.mark7;
	}
	
	/**
	 * Column Info
	 * @return mark6
	 */
	public String getMark6() {
		return this.mark6;
	}
	
	/**
	 * Column Info
	 * @return mark5
	 */
	public String getMark5() {
		return this.mark5;
	}
	
	/**
	 * Column Info
	 * @return mark4
	 */
	public String getMark4() {
		return this.mark4;
	}
	
	/**
	 * Column Info
	 * @return mark3
	 */
	public String getMark3() {
		return this.mark3;
	}
	
	/**
	 * Column Info
	 * @return mark2
	 */
	public String getMark2() {
		return this.mark2;
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
	 * @return mark1
	 */
	public String getMark1() {
		return this.mark1;
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
	 * @param mark10
	 */
	public void setMark10(String mark10) {
		this.mark10 = mark10;
	}
	/**
	 * Column Info
	 * @param mark9
	 */
	public void setMark9(String mark9) {
		this.mark9 = mark9;
	}
	/**
	 * Column Info
	 * @param mark8
	 */
	public void setMark8(String mark8) {
		this.mark8 = mark8;
	}
	/**
	 * Column Info
	 * @param mark7
	 */
	public void setMark7(String mark7) {
		this.mark7 = mark7;
	}
	/**
	 * Column Info
	 * @param mark6
	 */
	public void setMark6(String mark6) {
		this.mark6 = mark6;
	}
	/**
	 * Column Info
	 * @param mark5
	 */
	public void setMark5(String mark5) {
		this.mark5 = mark5;
	}

	/**
	 * Column Info
	 * @param mark4
	 */
	public void setMark4(String mark4) {
		this.mark4 = mark4;
	}
	
	/**
	 * Column Info
	 * @param mark3
	 */
	public void setMark3(String mark3) {
		this.mark3 = mark3;
	}
	
	/**
	 * Column Info
	 * @param mark2
	 */
	public void setMark2(String mark2) {
		this.mark2 = mark2;
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
	 * @param mark1
	 */
	public void setMark1(String mark1) {
		this.mark1 = mark1;
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
		setMark10(JSPUtil.getParameter(request, prefix + "mark10", ""));
		setMark9(JSPUtil.getParameter(request, prefix + "mark9", ""));
		setMark8(JSPUtil.getParameter(request, prefix + "mark8", ""));
		setMark7(JSPUtil.getParameter(request, prefix + "mark7", ""));
		setMark6(JSPUtil.getParameter(request, prefix + "mark6", ""));
		setMark5(JSPUtil.getParameter(request, prefix + "mark5", ""));
		setMark4(JSPUtil.getParameter(request, prefix + "mark4", ""));
		setMark3(JSPUtil.getParameter(request, prefix + "mark3", ""));
		setMark2(JSPUtil.getParameter(request, prefix + "mark2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMark1(JSPUtil.getParameter(request, prefix + "mark1", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MalaysiaManifestMarkInfoVO[]
	 */
	public MalaysiaManifestMarkInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MalaysiaManifestMarkInfoVO[]
	 */
	public MalaysiaManifestMarkInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MalaysiaManifestMarkInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mark10 = (JSPUtil.getParameter(request, prefix	+ "mark10", length));
			String[] mark9 = (JSPUtil.getParameter(request, prefix	+ "mark9", length));
			String[] mark8 = (JSPUtil.getParameter(request, prefix	+ "mark8", length));
			String[] mark7 = (JSPUtil.getParameter(request, prefix	+ "mark7", length));
			String[] mark6 = (JSPUtil.getParameter(request, prefix	+ "mark6", length));
			String[] mark5 = (JSPUtil.getParameter(request, prefix	+ "mark5", length));
			String[] mark4 = (JSPUtil.getParameter(request, prefix	+ "mark4", length));
			String[] mark3 = (JSPUtil.getParameter(request, prefix	+ "mark3", length));
			String[] mark2 = (JSPUtil.getParameter(request, prefix	+ "mark2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mark1 = (JSPUtil.getParameter(request, prefix	+ "mark1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MalaysiaManifestMarkInfoVO();
				if (mark10[i] != null)
					model.setMark10(mark10[i]);
				if (mark9[i] != null)
					model.setMark9(mark9[i]);
				if (mark8[i] != null)
					model.setMark8(mark8[i]);
				if (mark7[i] != null)
					model.setMark7(mark7[i]);
				if (mark6[i] != null)
					model.setMark6(mark6[i]);
				if (mark5[i] != null)
					model.setMark5(mark5[i]);
				if (mark4[i] != null)
					model.setMark4(mark4[i]);
				if (mark3[i] != null)
					model.setMark3(mark3[i]);
				if (mark2[i] != null)
					model.setMark2(mark2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mark1[i] != null)
					model.setMark1(mark1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMalaysiaManifestMarkInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MalaysiaManifestMarkInfoVO[]
	 */
	public MalaysiaManifestMarkInfoVO[] getMalaysiaManifestMarkInfoVOs(){
		MalaysiaManifestMarkInfoVO[] vos = (MalaysiaManifestMarkInfoVO[])models.toArray(new MalaysiaManifestMarkInfoVO[models.size()]);
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
		this.mark10 = this.mark10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark9 = this.mark9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark8 = this.mark8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark7 = this.mark7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark6 = this.mark6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark5 = this.mark5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark4 = this.mark4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark3 = this.mark3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark2 = this.mark2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark1 = this.mark1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
