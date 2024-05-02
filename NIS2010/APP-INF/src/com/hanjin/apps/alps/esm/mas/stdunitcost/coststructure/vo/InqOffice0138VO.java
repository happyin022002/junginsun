/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InqOffice0138VO.java
*@FileTitle : InqOffice0138VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.11.19 송호진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 송호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InqOffice0138VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InqOffice0138VO> models = new ArrayList<InqOffice0138VO>();
	
	/* Column Info */
	private String root5 = null;
	/* Column Info */
	private String root4 = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String root3 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String root2 = null;
	/* Column Info */
	private String root7 = null;
	/* Column Info */
	private String root6 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InqOffice0138VO() {}

	public InqOffice0138VO(String ibflag, String pagerows, String ofcCd, String root2, String root3, String root4, String root5, String root6, String root7) {
		this.root5 = root5;
		this.root4 = root4;
		this.ofcCd = ofcCd;
		this.root3 = root3;
		this.ibflag = ibflag;
		this.root2 = root2;
		this.root7 = root7;
		this.root6 = root6;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("root5", getRoot5());
		this.hashColumns.put("root4", getRoot4());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("root3", getRoot3());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("root2", getRoot2());
		this.hashColumns.put("root7", getRoot7());
		this.hashColumns.put("root6", getRoot6());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("root5", "root5");
		this.hashFields.put("root4", "root4");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("root3", "root3");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("root2", "root2");
		this.hashFields.put("root7", "root7");
		this.hashFields.put("root6", "root6");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return root5
	 */
	public String getRoot5() {
		return this.root5;
	}
	
	/**
	 * Column Info
	 * @return root4
	 */
	public String getRoot4() {
		return this.root4;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return root3
	 */
	public String getRoot3() {
		return this.root3;
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
	 * @return root2
	 */
	public String getRoot2() {
		return this.root2;
	}
	
	/**
	 * Column Info
	 * @return root7
	 */
	public String getRoot7() {
		return this.root7;
	}
	
	/**
	 * Column Info
	 * @return root6
	 */
	public String getRoot6() {
		return this.root6;
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
	 * @param root5
	 */
	public void setRoot5(String root5) {
		this.root5 = root5;
	}
	
	/**
	 * Column Info
	 * @param root4
	 */
	public void setRoot4(String root4) {
		this.root4 = root4;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param root3
	 */
	public void setRoot3(String root3) {
		this.root3 = root3;
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
	 * @param root2
	 */
	public void setRoot2(String root2) {
		this.root2 = root2;
	}
	
	/**
	 * Column Info
	 * @param root7
	 */
	public void setRoot7(String root7) {
		this.root7 = root7;
	}
	
	/**
	 * Column Info
	 * @param root6
	 */
	public void setRoot6(String root6) {
		this.root6 = root6;
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
		setRoot5(JSPUtil.getParameter(request, "root5", ""));
		setRoot4(JSPUtil.getParameter(request, "root4", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setRoot3(JSPUtil.getParameter(request, "root3", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRoot2(JSPUtil.getParameter(request, "root2", ""));
		setRoot7(JSPUtil.getParameter(request, "root7", ""));
		setRoot6(JSPUtil.getParameter(request, "root6", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InqOffice0138VO[]
	 */
	public InqOffice0138VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InqOffice0138VO[]
	 */
	public InqOffice0138VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InqOffice0138VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] root5 = (JSPUtil.getParameter(request, prefix	+ "root5", length));
			String[] root4 = (JSPUtil.getParameter(request, prefix	+ "root4", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] root3 = (JSPUtil.getParameter(request, prefix	+ "root3", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] root2 = (JSPUtil.getParameter(request, prefix	+ "root2", length));
			String[] root7 = (JSPUtil.getParameter(request, prefix	+ "root7", length));
			String[] root6 = (JSPUtil.getParameter(request, prefix	+ "root6", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InqOffice0138VO();
				if (root5[i] != null)
					model.setRoot5(root5[i]);
				if (root4[i] != null)
					model.setRoot4(root4[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (root3[i] != null)
					model.setRoot3(root3[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (root2[i] != null)
					model.setRoot2(root2[i]);
				if (root7[i] != null)
					model.setRoot7(root7[i]);
				if (root6[i] != null)
					model.setRoot6(root6[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInqOffice0138VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InqOffice0138VO[]
	 */
	public InqOffice0138VO[] getInqOffice0138VOs(){
		InqOffice0138VO[] vos = (InqOffice0138VO[])models.toArray(new InqOffice0138VO[models.size()]);
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
		this.root5 = this.root5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.root4 = this.root4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.root3 = this.root3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.root2 = this.root2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.root7 = this.root7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.root6 = this.root6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
