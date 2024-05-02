/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VskPortCnlTrScgListVO.java
*@FileTitle : VskPortCnlTrScgListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.03
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.11.03 김종옥 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Object<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VskPortCnlTrScgListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VskPortCnlTrScgListVO> models = new ArrayList<VskPortCnlTrScgListVO>();
	
	/* Column Info */
	private String vslTrNo2 = null;
	/* Column Info */
	private String vslTrNo3 = null;
	/* Column Info */
	private String vslTrNo4 = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslTrNo5 = null;
	/* Column Info */
	private String vslTrNo1 = null;
	/* Column Info */
	private String vslTrNo6 = null;
	/* Column Info */
	private String vslTrNo7 = null;
	/* Column Info */
	private String vslTrNo8 = null;
	/* Column Info */
	private String vslTrNo9 = null;
	/* Page Number */
	private String pagerows = null;

	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VskPortCnlTrScgListVO() {}

	public VskPortCnlTrScgListVO( String ibflag, String pagerows, String locCd, String vslTrNo1, String vslTrNo2, String vslTrNo3, String vslTrNo4, String vslTrNo5, String vslTrNo6, String vslTrNo7, String vslTrNo8, String vslTrNo9) {
		this.vslTrNo2 = vslTrNo2;
		this.vslTrNo3 = vslTrNo3;
		this.vslTrNo4 = vslTrNo4;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.vslTrNo5 = vslTrNo5;
		this.vslTrNo1 = vslTrNo1;
		this.vslTrNo6 = vslTrNo6;
		this.vslTrNo7 = vslTrNo7;
		this.vslTrNo8 = vslTrNo8;
		this.vslTrNo9 = vslTrNo9;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_tr_no2", getVslTrNo2());
		this.hashColumns.put("vsl_tr_no3", getVslTrNo3());
		this.hashColumns.put("vsl_tr_no4", getVslTrNo4());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_tr_no5", getVslTrNo5());
		this.hashColumns.put("vsl_tr_no1", getVslTrNo1());
		this.hashColumns.put("vsl_tr_no6", getVslTrNo6());
		this.hashColumns.put("vsl_tr_no7", getVslTrNo7());
		this.hashColumns.put("vsl_tr_no8", getVslTrNo8());
		this.hashColumns.put("vsl_tr_no9", getVslTrNo9());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_tr_no2", "vslTrNo2");
		this.hashFields.put("vsl_tr_no3", "vslTrNo3");
		this.hashFields.put("vsl_tr_no4", "vslTrNo4");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_tr_no5", "vslTrNo5");
		this.hashFields.put("vsl_tr_no1", "vslTrNo1");
		this.hashFields.put("vsl_tr_no6", "vslTrNo6");
		this.hashFields.put("vsl_tr_no7", "vslTrNo7");
		this.hashFields.put("vsl_tr_no8", "vslTrNo8");
		this.hashFields.put("vsl_tr_no9", "vslTrNo9");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslTrNo2
	 */
	public String getVslTrNo2() {
		return this.vslTrNo2;
	}
	
	/**
	 * Column Info
	 * @return vslTrNo3
	 */
	public String getVslTrNo3() {
		return this.vslTrNo3;
	}
	
	/**
	 * Column Info
	 * @return vslTrNo4
	 */
	public String getVslTrNo4() {
		return this.vslTrNo4;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return vslTrNo5
	 */
	public String getVslTrNo5() {
		return this.vslTrNo5;
	}
	
	/**
	 * Column Info
	 * @return vslTrNo1
	 */
	public String getVslTrNo1() {
		return this.vslTrNo1;
	}
	
	/**
	 * Column Info
	 * @return vslTrNo6
	 */
	public String getVslTrNo6() {
		return this.vslTrNo6;
	}
	
	/**
	 * Column Info
	 * @return vslTrNo7
	 */
	public String getVslTrNo7() {
		return this.vslTrNo7;
	}
	
	/**
	 * Column Info
	 * @return vslTrNo8
	 */
	public String getVslTrNo8() {
		return this.vslTrNo8;
	}
	
	/**
	 * Column Info
	 * @return vslTrNo9
	 */
	public String getVslTrNo9() {
		return this.vslTrNo9;
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
	 * @param vslTrNo2
	 */
	public void setVslTrNo2(String vslTrNo2) {
		this.vslTrNo2 = vslTrNo2;
	}
	
	/**
	 * Column Info
	 * @param vslTrNo3
	 */
	public void setVslTrNo3(String vslTrNo3) {
		this.vslTrNo3 = vslTrNo3;
	}
	
	/**
	 * Column Info
	 * @param vslTrNo4
	 */
	public void setVslTrNo4(String vslTrNo4) {
		this.vslTrNo4 = vslTrNo4;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param vslTrNo5
	 */
	public void setVslTrNo5(String vslTrNo5) {
		this.vslTrNo5 = vslTrNo5;
	}
	
	/**
	 * Column Info
	 * @param vslTrNo1
	 */
	public void setVslTrNo1(String vslTrNo1) {
		this.vslTrNo1 = vslTrNo1;
	}
	
	/**
	 * Column Info
	 * @param vslTrNo6
	 */
	public void setVslTrNo6(String vslTrNo6) {
		this.vslTrNo6 = vslTrNo6;
	}
	
	/**
	 * Column Info
	 * @param vslTrNo7
	 */
	public void setVslTrNo7(String vslTrNo7) {
		this.vslTrNo7 = vslTrNo7;
	}
	
	/**
	 * Column Info
	 * @param vslTrNo8
	 */
	public void setVslTrNo8(String vslTrNo8) {
		this.vslTrNo8 = vslTrNo8;
	}
	
	/**
	 * Column Info
	 * @param vslTrNo9
	 */
	public void setVslTrNo9(String vslTrNo9) {
		this.vslTrNo9 = vslTrNo9;
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
		setVslTrNo2(JSPUtil.getParameter(request, "vsl_tr_no2", ""));
		setVslTrNo3(JSPUtil.getParameter(request, "vsl_tr_no3", ""));
		setVslTrNo4(JSPUtil.getParameter(request, "vsl_tr_no4", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslTrNo5(JSPUtil.getParameter(request, "vsl_tr_no5", ""));
		setVslTrNo1(JSPUtil.getParameter(request, "vsl_tr_no1", ""));
		setVslTrNo6(JSPUtil.getParameter(request, "vsl_tr_no6", ""));
		setVslTrNo7(JSPUtil.getParameter(request, "vsl_tr_no7", ""));
		setVslTrNo8(JSPUtil.getParameter(request, "vsl_tr_no8", ""));
		setVslTrNo9(JSPUtil.getParameter(request, "vsl_tr_no9", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VskPortCnlTrScgListVO[]
	 */
	public VskPortCnlTrScgListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VskPortCnlTrScgListVO[]
	 */
	public VskPortCnlTrScgListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VskPortCnlTrScgListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslTrNo2 = (JSPUtil.getParameter(request, prefix	+ "vsl_tr_no2", length));
			String[] vslTrNo3 = (JSPUtil.getParameter(request, prefix	+ "vsl_tr_no3", length));
			String[] vslTrNo4 = (JSPUtil.getParameter(request, prefix	+ "vsl_tr_no4", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslTrNo5 = (JSPUtil.getParameter(request, prefix	+ "vsl_tr_no5", length));
			String[] vslTrNo1 = (JSPUtil.getParameter(request, prefix	+ "vsl_tr_no1", length));
			String[] vslTrNo6 = (JSPUtil.getParameter(request, prefix	+ "vsl_tr_no6", length));
			String[] vslTrNo7 = (JSPUtil.getParameter(request, prefix	+ "vsl_tr_no7", length));
			String[] vslTrNo8 = (JSPUtil.getParameter(request, prefix	+ "vsl_tr_no8", length));
			String[] vslTrNo9 = (JSPUtil.getParameter(request, prefix	+ "vsl_tr_no9", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new VskPortCnlTrScgListVO();
				if (vslTrNo2[i] != null)
					model.setVslTrNo2(vslTrNo2[i]);
				if (vslTrNo3[i] != null)
					model.setVslTrNo3(vslTrNo3[i]);
				if (vslTrNo4[i] != null)
					model.setVslTrNo4(vslTrNo4[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslTrNo5[i] != null)
					model.setVslTrNo5(vslTrNo5[i]);
				if (vslTrNo1[i] != null)
					model.setVslTrNo1(vslTrNo1[i]);
				if (vslTrNo6[i] != null)
					model.setVslTrNo6(vslTrNo6[i]);
				if (vslTrNo7[i] != null)
					model.setVslTrNo7(vslTrNo7[i]);
				if (vslTrNo8[i] != null)
					model.setVslTrNo8(vslTrNo8[i]);
				if (vslTrNo9[i] != null)
					model.setVslTrNo9(vslTrNo9[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVskPortCnlTrScgListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VskPortCnlTrScgListVO[]
	 */
	public VskPortCnlTrScgListVO[] getVskPortCnlTrScgListVOs(){
		VskPortCnlTrScgListVO[] vos = (VskPortCnlTrScgListVO[])models.toArray(new VskPortCnlTrScgListVO[models.size()]);
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
		this.vslTrNo2 = this.vslTrNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslTrNo3 = this.vslTrNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslTrNo4 = this.vslTrNo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslTrNo5 = this.vslTrNo5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslTrNo1 = this.vslTrNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslTrNo6 = this.vslTrNo6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslTrNo7 = this.vslTrNo7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslTrNo8 = this.vslTrNo8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslTrNo9 = this.vslTrNo9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
