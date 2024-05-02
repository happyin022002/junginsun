/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : UserInquiryVO.java
*@FileTitle : UserInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.03
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.06.03 최덕우 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.management.alps.jobcodemanagement.vo;

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
 * @author 최덕우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UserInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UserInquiryVO> models = new ArrayList<UserInquiryVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String checkVal = null;
	/* Column Info */
	private String usrRoleCd = null;
	/* Column Info */
	private String ofcEngNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String usrLoclNm = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String ofcKrnNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String level = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UserInquiryVO() {}

	public UserInquiryVO(String ibflag, String level, String pagerows, String usrRoleCd, String ofcCd, String ofcEngNm, String ofcKrnNm, String checkVal, String usrId, String usrNm, String usrLoclNm, String creUsrId, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.checkVal = checkVal;
		this.usrRoleCd = usrRoleCd;
		this.ofcEngNm = ofcEngNm;
		this.pagerows = pagerows;
		this.usrLoclNm = usrLoclNm;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.usrId = usrId;
		this.usrNm = usrNm;
		this.ofcKrnNm = ofcKrnNm;
		this.updUsrId = updUsrId;
		this.level = level;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("check_val", getCheckVal());
		this.hashColumns.put("usr_role_cd", getUsrRoleCd());
		this.hashColumns.put("ofc_eng_nm", getOfcEngNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("usr_locl_nm", getUsrLoclNm());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("ofc_krn_nm", getOfcKrnNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("level", getLevel());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("check_val", "checkVal");
		this.hashFields.put("usr_role_cd", "usrRoleCd");
		this.hashFields.put("ofc_eng_nm", "ofcEngNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("usr_locl_nm", "usrLoclNm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("ofc_krn_nm", "ofcKrnNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("level", "level");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return checkVal
	 */
	public String getCheckVal() {
		return this.checkVal;
	}
	
	/**
	 * Column Info
	 * @return usrRoleCd
	 */
	public String getUsrRoleCd() {
		return this.usrRoleCd;
	}
	
	/**
	 * Column Info
	 * @return ofcEngNm
	 */
	public String getOfcEngNm() {
		return this.ofcEngNm;
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
	 * @return usrLoclNm
	 */
	public String getUsrLoclNm() {
		return this.usrLoclNm;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return ofcKrnNm
	 */
	public String getOfcKrnNm() {
		return this.ofcKrnNm;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param checkVal
	 */
	public void setCheckVal(String checkVal) {
		this.checkVal = checkVal;
	}
	
	/**
	 * Column Info
	 * @param usrRoleCd
	 */
	public void setUsrRoleCd(String usrRoleCd) {
		this.usrRoleCd = usrRoleCd;
	}
	
	/**
	 * Column Info
	 * @param ofcEngNm
	 */
	public void setOfcEngNm(String ofcEngNm) {
		this.ofcEngNm = ofcEngNm;
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
	 * @param usrLoclNm
	 */
	public void setUsrLoclNm(String usrLoclNm) {
		this.usrLoclNm = usrLoclNm;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param ofcKrnNm
	 */
	public void setOfcKrnNm(String ofcKrnNm) {
		this.ofcKrnNm = ofcKrnNm;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
		
	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCheckVal(JSPUtil.getParameter(request, prefix + "check_val", ""));
		setUsrRoleCd(JSPUtil.getParameter(request, prefix + "usr_role_cd", ""));
		setOfcEngNm(JSPUtil.getParameter(request, prefix + "ofc_eng_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setUsrLoclNm(JSPUtil.getParameter(request, prefix + "usr_locl_nm", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setOfcKrnNm(JSPUtil.getParameter(request, prefix + "ofc_krn_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setLevel(JSPUtil.getParameter(request, prefix + "level", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UserInquiryVO[]
	 */
	public UserInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UserInquiryVO[]
	 */
	public UserInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UserInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] checkVal = (JSPUtil.getParameter(request, prefix	+ "check_val", length));
			String[] usrRoleCd = (JSPUtil.getParameter(request, prefix	+ "usr_role_cd", length));
			String[] ofcEngNm = (JSPUtil.getParameter(request, prefix	+ "ofc_eng_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] usrLoclNm = (JSPUtil.getParameter(request, prefix	+ "usr_locl_nm", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] ofcKrnNm = (JSPUtil.getParameter(request, prefix	+ "ofc_krn_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] level = (JSPUtil.getParameter(request, prefix	+ "level", length));
			
			for (int i = 0; i < length; i++) {
				model = new UserInquiryVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (checkVal[i] != null)
					model.setCheckVal(checkVal[i]);
				if (usrRoleCd[i] != null)
					model.setUsrRoleCd(usrRoleCd[i]);
				if (ofcEngNm[i] != null)
					model.setOfcEngNm(ofcEngNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (usrLoclNm[i] != null)
					model.setUsrLoclNm(usrLoclNm[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (ofcKrnNm[i] != null)
					model.setOfcKrnNm(ofcKrnNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (level[i] != null)
					model.setLevel(level[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUserInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UserInquiryVO[]
	 */
	public UserInquiryVO[] getUserInquiryVOs(){
		UserInquiryVO[] vos = (UserInquiryVO[])models.toArray(new UserInquiryVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkVal = this.checkVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRoleCd = this.usrRoleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEngNm = this.ofcEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrLoclNm = this.usrLoclNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcKrnNm = this.ofcKrnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.level = this.level .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
