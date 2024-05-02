/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PreventionCondVO.java
*@FileTitle : PreventionCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.03.12 진윤오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.vo;

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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PreventionCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PreventionCondVO> models = new ArrayList<PreventionCondVO>();
	
	/* Column Info */
	private String usrRoles = null;
	/* Column Info */
	private String condSearchText = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creDtStart = null;
	/* Column Info */
	private String curDt = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String clmPrveDivCd = null;
	/* Column Info */
	private String clmPrveNo = null;
	/* Column Info */
	private String clmAreaCd = null;
	/* Column Info */
	private String creDtEnd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PreventionCondVO() {}

	public PreventionCondVO(String ibflag, String pagerows, String condSearchText, String clmPrveDivCd, String creDtStart, String creDtEnd, String clmAreaCd, String creOfcCd, String creUsrId, String curDt, String clmPrveNo, String usrRoles) {
		this.usrRoles = usrRoles;
		this.condSearchText = condSearchText;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.creDtStart = creDtStart;
		this.curDt = curDt;
		this.creOfcCd = creOfcCd;
		this.clmPrveDivCd = clmPrveDivCd;
		this.clmPrveNo = clmPrveNo;
		this.clmAreaCd = clmAreaCd;
		this.creDtEnd = creDtEnd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("usr_roles", getUsrRoles());
		this.hashColumns.put("cond_search_text", getCondSearchText());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_dt_start", getCreDtStart());
		this.hashColumns.put("cur_dt", getCurDt());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("clm_prve_div_cd", getClmPrveDivCd());
		this.hashColumns.put("clm_prve_no", getClmPrveNo());
		this.hashColumns.put("clm_area_cd", getClmAreaCd());
		this.hashColumns.put("cre_dt_end", getCreDtEnd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("usr_roles", "usrRoles");
		this.hashFields.put("cond_search_text", "condSearchText");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_dt_start", "creDtStart");
		this.hashFields.put("cur_dt", "curDt");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("clm_prve_div_cd", "clmPrveDivCd");
		this.hashFields.put("clm_prve_no", "clmPrveNo");
		this.hashFields.put("clm_area_cd", "clmAreaCd");
		this.hashFields.put("cre_dt_end", "creDtEnd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return usrRoles
	 */
	public String getUsrRoles() {
		return this.usrRoles;
	}
	
	/**
	 * Column Info
	 * @return condSearchText
	 */
	public String getCondSearchText() {
		return this.condSearchText;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return creDtStart
	 */
	public String getCreDtStart() {
		return this.creDtStart;
	}
	
	/**
	 * Column Info
	 * @return curDt
	 */
	public String getCurDt() {
		return this.curDt;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return clmPrveDivCd
	 */
	public String getClmPrveDivCd() {
		return this.clmPrveDivCd;
	}
	
	/**
	 * Column Info
	 * @return clmPrveNo
	 */
	public String getClmPrveNo() {
		return this.clmPrveNo;
	}
	
	/**
	 * Column Info
	 * @return clmAreaCd
	 */
	public String getClmAreaCd() {
		return this.clmAreaCd;
	}
	
	/**
	 * Column Info
	 * @return creDtEnd
	 */
	public String getCreDtEnd() {
		return this.creDtEnd;
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
	 * @param usrRoles
	 */
	public void setUsrRoles(String usrRoles) {
		this.usrRoles = usrRoles;
	}
	
	/**
	 * Column Info
	 * @param condSearchText
	 */
	public void setCondSearchText(String condSearchText) {
		this.condSearchText = condSearchText;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param creDtStart
	 */
	public void setCreDtStart(String creDtStart) {
		this.creDtStart = creDtStart;
	}
	
	/**
	 * Column Info
	 * @param curDt
	 */
	public void setCurDt(String curDt) {
		this.curDt = curDt;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param clmPrveDivCd
	 */
	public void setClmPrveDivCd(String clmPrveDivCd) {
		this.clmPrveDivCd = clmPrveDivCd;
	}
	
	/**
	 * Column Info
	 * @param clmPrveNo
	 */
	public void setClmPrveNo(String clmPrveNo) {
		this.clmPrveNo = clmPrveNo;
	}
	
	/**
	 * Column Info
	 * @param clmAreaCd
	 */
	public void setClmAreaCd(String clmAreaCd) {
		this.clmAreaCd = clmAreaCd;
	}
	
	/**
	 * Column Info
	 * @param creDtEnd
	 */
	public void setCreDtEnd(String creDtEnd) {
		this.creDtEnd = creDtEnd;
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
		setUsrRoles(JSPUtil.getParameter(request, prefix + "usr_roles", ""));
		setCondSearchText(JSPUtil.getParameter(request, prefix + "cond_search_text", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreDtStart(JSPUtil.getParameter(request, prefix + "cre_dt_start", ""));
		setCurDt(JSPUtil.getParameter(request, prefix + "cur_dt", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setClmPrveDivCd(JSPUtil.getParameter(request, prefix + "clm_prve_div_cd", ""));
		setClmPrveNo(JSPUtil.getParameter(request, prefix + "clm_prve_no", ""));
		setClmAreaCd(JSPUtil.getParameter(request, prefix + "clm_area_cd", ""));
		setCreDtEnd(JSPUtil.getParameter(request, prefix + "cre_dt_end", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PreventionCondVO[]
	 */
	public PreventionCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PreventionCondVO[]
	 */
	public PreventionCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PreventionCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] usrRoles = (JSPUtil.getParameter(request, prefix	+ "usr_roles", length));
			String[] condSearchText = (JSPUtil.getParameter(request, prefix	+ "cond_search_text", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creDtStart = (JSPUtil.getParameter(request, prefix	+ "cre_dt_start", length));
			String[] curDt = (JSPUtil.getParameter(request, prefix	+ "cur_dt", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] clmPrveDivCd = (JSPUtil.getParameter(request, prefix	+ "clm_prve_div_cd", length));
			String[] clmPrveNo = (JSPUtil.getParameter(request, prefix	+ "clm_prve_no", length));
			String[] clmAreaCd = (JSPUtil.getParameter(request, prefix	+ "clm_area_cd", length));
			String[] creDtEnd = (JSPUtil.getParameter(request, prefix	+ "cre_dt_end", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PreventionCondVO();
				if (usrRoles[i] != null)
					model.setUsrRoles(usrRoles[i]);
				if (condSearchText[i] != null)
					model.setCondSearchText(condSearchText[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creDtStart[i] != null)
					model.setCreDtStart(creDtStart[i]);
				if (curDt[i] != null)
					model.setCurDt(curDt[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (clmPrveDivCd[i] != null)
					model.setClmPrveDivCd(clmPrveDivCd[i]);
				if (clmPrveNo[i] != null)
					model.setClmPrveNo(clmPrveNo[i]);
				if (clmAreaCd[i] != null)
					model.setClmAreaCd(clmAreaCd[i]);
				if (creDtEnd[i] != null)
					model.setCreDtEnd(creDtEnd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPreventionCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PreventionCondVO[]
	 */
	public PreventionCondVO[] getPreventionCondVOs(){
		PreventionCondVO[] vos = (PreventionCondVO[])models.toArray(new PreventionCondVO[models.size()]);
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
		this.usrRoles = this.usrRoles .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condSearchText = this.condSearchText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDtStart = this.creDtStart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curDt = this.curDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPrveDivCd = this.clmPrveDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPrveNo = this.clmPrveNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAreaCd = this.clmAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDtEnd = this.creDtEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
