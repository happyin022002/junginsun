/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DmtScExptVerVO.java
*@FileTitle : DmtScExptVerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.11.19 공백진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo;

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
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DmtScExptVerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtScExptVerVO> models = new ArrayList<DmtScExptVerVO>();
	
	/* Column Info */
	private String exCnt = null;
	/* Column Info */
	private String allCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String taCnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtScExptVerVO() {}

	public DmtScExptVerVO(String ibflag, String pagerows, String exCnt, String taCnt, String allCnt) {
		this.exCnt = exCnt;
		this.allCnt = allCnt;
		this.ibflag = ibflag;
		this.taCnt = taCnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ex_cnt", getExCnt());
		this.hashColumns.put("all_cnt", getAllCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ta_cnt", getTaCnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ex_cnt", "exCnt");
		this.hashFields.put("all_cnt", "allCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ta_cnt", "taCnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return exCnt
	 */
	public String getExCnt() {
		return this.exCnt;
	}
	
	/**
	 * Column Info
	 * @return allCnt
	 */
	public String getAllCnt() {
		return this.allCnt;
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
	 * @return taCnt
	 */
	public String getTaCnt() {
		return this.taCnt;
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
	 * @param exCnt
	 */
	public void setExCnt(String exCnt) {
		this.exCnt = exCnt;
	}
	
	/**
	 * Column Info
	 * @param allCnt
	 */
	public void setAllCnt(String allCnt) {
		this.allCnt = allCnt;
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
	 * @param taCnt
	 */
	public void setTaCnt(String taCnt) {
		this.taCnt = taCnt;
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
		setExCnt(JSPUtil.getParameter(request, "ex_cnt", ""));
		setAllCnt(JSPUtil.getParameter(request, "all_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTaCnt(JSPUtil.getParameter(request, "ta_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DmtScExptVerVO[]
	 */
	public DmtScExptVerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtScExptVerVO[]
	 */
	public DmtScExptVerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtScExptVerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] exCnt = (JSPUtil.getParameter(request, prefix	+ "ex_cnt", length));
			String[] allCnt = (JSPUtil.getParameter(request, prefix	+ "all_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] taCnt = (JSPUtil.getParameter(request, prefix	+ "ta_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtScExptVerVO();
				if (exCnt[i] != null)
					model.setExCnt(exCnt[i]);
				if (allCnt[i] != null)
					model.setAllCnt(allCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (taCnt[i] != null)
					model.setTaCnt(taCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtScExptVerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DmtScExptVerVO[]
	 */
	public DmtScExptVerVO[] getDmtScExptVerVOs(){
		DmtScExptVerVO[] vos = (DmtScExptVerVO[])models.toArray(new DmtScExptVerVO[models.size()]);
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
		this.exCnt = this.exCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allCnt = this.allCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taCnt = this.taCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
