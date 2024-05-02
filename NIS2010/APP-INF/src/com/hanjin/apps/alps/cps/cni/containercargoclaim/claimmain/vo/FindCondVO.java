/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FindCondVO.java
*@FileTitle : FindCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2009.10.13 양정란 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo;

import java.lang.reflect.Field;
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
 * @author 양정란
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FindCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FindCondVO> models = new ArrayList<FindCondVO>();
	
	/* Column Info */
	private String miscCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String schCond = null;
	/* Column Info */
	private String vt = null;
	/* Column Info */
	private String schStr = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FindCondVO() {}

	public FindCondVO(String ibflag, String pagerows, String schCond, String schStr, String pageNo, String miscCd, String vt) {
		this.miscCd = miscCd;
		this.ibflag = ibflag;
		this.pageNo = pageNo;
		this.schCond = schCond;
		this.vt = vt;
		this.schStr = schStr;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("misc_cd", getMiscCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("sch_cond", getSchCond());
		this.hashColumns.put("vt", getVt());
		this.hashColumns.put("sch_str", getSchStr());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("misc_cd", "miscCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("sch_cond", "schCond");
		this.hashFields.put("vt", "vt");
		this.hashFields.put("sch_str", "schStr");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return miscCd
	 */
	public String getMiscCd() {
		return this.miscCd;
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
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return schCond
	 */
	public String getSchCond() {
		return this.schCond;
	}
	
	/**
	 * Column Info
	 * @return vt
	 */
	public String getVt() {
		return this.vt;
	}
	
	/**
	 * Column Info
	 * @return schStr
	 */
	public String getSchStr() {
		return this.schStr;
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
	 * @param miscCd
	 */
	public void setMiscCd(String miscCd) {
		this.miscCd = miscCd;
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
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param schCond
	 */
	public void setSchCond(String schCond) {
		this.schCond = schCond;
	}
	
	/**
	 * Column Info
	 * @param vt
	 */
	public void setVt(String vt) {
		this.vt = vt;
	}
	
	/**
	 * Column Info
	 * @param schStr
	 */
	public void setSchStr(String schStr) {
		this.schStr = schStr;
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
		setMiscCd(JSPUtil.getParameter(request, "misc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPageNo(JSPUtil.getParameter(request, "page_no", ""));
		setSchCond(JSPUtil.getParameter(request, "sch_cond", ""));
		setVt(JSPUtil.getParameter(request, "vt", ""));
		setSchStr(JSPUtil.getParameter(request, "sch_str", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FindCondVO[]
	 */
	public FindCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FindCondVO[]
	 */
	public FindCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FindCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] miscCd = (JSPUtil.getParameter(request, prefix	+ "misc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] schCond = (JSPUtil.getParameter(request, prefix	+ "sch_cond", length));
			String[] vt = (JSPUtil.getParameter(request, prefix	+ "vt", length));
			String[] schStr = (JSPUtil.getParameter(request, prefix	+ "sch_str", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new FindCondVO();
				if (miscCd[i] != null)
					model.setMiscCd(miscCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (schCond[i] != null)
					model.setSchCond(schCond[i]);
				if (vt[i] != null)
					model.setVt(vt[i]);
				if (schStr[i] != null)
					model.setSchStr(schStr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFindCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FindCondVO[]
	 */
	public FindCondVO[] getFindCondVOs(){
		FindCondVO[] vos = (FindCondVO[])models.toArray(new FindCondVO[models.size()]);
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
		this.miscCd = this.miscCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schCond = this.schCond .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vt = this.vt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schStr = this.schStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
