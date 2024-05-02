/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BzcAgmtCrrVO.java
*@FileTitle : BzcAgmtCrrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.17
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.01.17 김영오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo;

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
 * @author 김영오 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BzcAgmtCrrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BzcAgmtCrrVO> models = new ArrayList<BzcAgmtCrrVO>();
	
	/* Column Info */
	private String joCrrCd9 = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String joCrrCd7 = null;
	/* Column Info */
	private String joCrrCd8 = null;
	/* Column Info */
	private String joRepCrrCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String joCrrCd1 = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String joCrrCd2 = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Column Info */
	private String joCrrCd5 = null;
	/* Column Info */
	private String joCrrCd6 = null;
	/* Column Info */
	private String joCrrCd3 = null;
	/* Column Info */
	private String joCrrCd10 = null;
	/* Column Info */
	private String joCrrCd4 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String oldJoCrrCd2 = null;
	/* Column Info */
	private String oldJoCrrCd3 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String oldJoCrrCd1 = null;
	/* Column Info */
	private String iudFlag = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String joRefNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BzcAgmtCrrVO() {}

	public BzcAgmtCrrVO(String ibflag, String pagerows, String updDt, String creUsrId, String joRepCrrCd, String creDt, String joCrrCd, String rlaneCd, String creUsrNm, String updUsrId, String joCrrCd1, String joCrrCd2, String joCrrCd3, String joCrrCd4, String joCrrCd5, String joCrrCd6, String joCrrCd7, String joCrrCd8, String joCrrCd9, String joCrrCd10, String oldJoCrrCd1, String oldJoCrrCd2, String oldJoCrrCd3, String iudFlag, String joRefNo) {
		this.joCrrCd9 = joCrrCd9;
		this.updDt = updDt;
		this.joCrrCd7 = joCrrCd7;
		this.joCrrCd8 = joCrrCd8;
		this.joRepCrrCd = joRepCrrCd;
		this.creDt = creDt;
		this.joCrrCd1 = joCrrCd1;
		this.joCrrCd = joCrrCd;
		this.joCrrCd2 = joCrrCd2;
		this.rlaneCd = rlaneCd;
		this.creUsrNm = creUsrNm;
		this.joCrrCd5 = joCrrCd5;
		this.joCrrCd6 = joCrrCd6;
		this.joCrrCd3 = joCrrCd3;
		this.joCrrCd10 = joCrrCd10;
		this.joCrrCd4 = joCrrCd4;
		this.pagerows = pagerows;
		this.oldJoCrrCd2 = oldJoCrrCd2;
		this.oldJoCrrCd3 = oldJoCrrCd3;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.oldJoCrrCd1 = oldJoCrrCd1;
		this.iudFlag = iudFlag;
		this.updUsrId = updUsrId;
		this.joRefNo = joRefNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("jo_crr_cd9", getJoCrrCd9());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("jo_crr_cd7", getJoCrrCd7());
		this.hashColumns.put("jo_crr_cd8", getJoCrrCd8());
		this.hashColumns.put("jo_rep_crr_cd", getJoRepCrrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("jo_crr_cd1", getJoCrrCd1());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("jo_crr_cd2", getJoCrrCd2());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("jo_crr_cd5", getJoCrrCd5());
		this.hashColumns.put("jo_crr_cd6", getJoCrrCd6());
		this.hashColumns.put("jo_crr_cd3", getJoCrrCd3());
		this.hashColumns.put("jo_crr_cd10", getJoCrrCd10());
		this.hashColumns.put("jo_crr_cd4", getJoCrrCd4());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("old_jo_crr_cd2", getOldJoCrrCd2());
		this.hashColumns.put("old_jo_crr_cd3", getOldJoCrrCd3());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("old_jo_crr_cd1", getOldJoCrrCd1());
		this.hashColumns.put("iud_flag", getIudFlag());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("jo_ref_no", getJoRefNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("jo_crr_cd9", "joCrrCd9");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("jo_crr_cd7", "joCrrCd7");
		this.hashFields.put("jo_crr_cd8", "joCrrCd8");
		this.hashFields.put("jo_rep_crr_cd", "joRepCrrCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("jo_crr_cd1", "joCrrCd1");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("jo_crr_cd2", "joCrrCd2");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("jo_crr_cd5", "joCrrCd5");
		this.hashFields.put("jo_crr_cd6", "joCrrCd6");
		this.hashFields.put("jo_crr_cd3", "joCrrCd3");
		this.hashFields.put("jo_crr_cd10", "joCrrCd10");
		this.hashFields.put("jo_crr_cd4", "joCrrCd4");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("old_jo_crr_cd2", "oldJoCrrCd2");
		this.hashFields.put("old_jo_crr_cd3", "oldJoCrrCd3");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("old_jo_crr_cd1", "oldJoCrrCd1");
		this.hashFields.put("iud_flag", "iudFlag");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("jo_ref_no", "joRefNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd9
	 */
	public String getJoCrrCd9() {
		return this.joCrrCd9;
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
	 * @return joCrrCd7
	 */
	public String getJoCrrCd7() {
		return this.joCrrCd7;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd8
	 */
	public String getJoCrrCd8() {
		return this.joCrrCd8;
	}
	
	/**
	 * Column Info
	 * @return joRepCrrCd
	 */
	public String getJoRepCrrCd() {
		return this.joRepCrrCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd1
	 */
	public String getJoCrrCd1() {
		return this.joCrrCd1;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd2
	 */
	public String getJoCrrCd2() {
		return this.joCrrCd2;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd5
	 */
	public String getJoCrrCd5() {
		return this.joCrrCd5;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd6
	 */
	public String getJoCrrCd6() {
		return this.joCrrCd6;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd3
	 */
	public String getJoCrrCd3() {
		return this.joCrrCd3;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd10
	 */
	public String getJoCrrCd10() {
		return this.joCrrCd10;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd4
	 */
	public String getJoCrrCd4() {
		return this.joCrrCd4;
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
	 * @return oldJoCrrCd2
	 */
	public String getOldJoCrrCd2() {
		return this.oldJoCrrCd2;
	}
	
	/**
	 * Column Info
	 * @return oldJoCrrCd3
	 */
	public String getOldJoCrrCd3() {
		return this.oldJoCrrCd3;
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
	 * @return oldJoCrrCd1
	 */
	public String getOldJoCrrCd1() {
		return this.oldJoCrrCd1;
	}
	
	/**
	 * Column Info
	 * @return iudFlag
	 */
	public String getIudFlag() {
		return this.iudFlag;
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
	 * @return joRefNo
	 */
	public String getJoRefNo() {
		return this.joRefNo;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd9
	 */
	public void setJoCrrCd9(String joCrrCd9) {
		this.joCrrCd9 = joCrrCd9;
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
	 * @param joCrrCd7
	 */
	public void setJoCrrCd7(String joCrrCd7) {
		this.joCrrCd7 = joCrrCd7;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd8
	 */
	public void setJoCrrCd8(String joCrrCd8) {
		this.joCrrCd8 = joCrrCd8;
	}
	
	/**
	 * Column Info
	 * @param joRepCrrCd
	 */
	public void setJoRepCrrCd(String joRepCrrCd) {
		this.joRepCrrCd = joRepCrrCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd1
	 */
	public void setJoCrrCd1(String joCrrCd1) {
		this.joCrrCd1 = joCrrCd1;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd2
	 */
	public void setJoCrrCd2(String joCrrCd2) {
		this.joCrrCd2 = joCrrCd2;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd5
	 */
	public void setJoCrrCd5(String joCrrCd5) {
		this.joCrrCd5 = joCrrCd5;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd6
	 */
	public void setJoCrrCd6(String joCrrCd6) {
		this.joCrrCd6 = joCrrCd6;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd3
	 */
	public void setJoCrrCd3(String joCrrCd3) {
		this.joCrrCd3 = joCrrCd3;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd10
	 */
	public void setJoCrrCd10(String joCrrCd10) {
		this.joCrrCd10 = joCrrCd10;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd4
	 */
	public void setJoCrrCd4(String joCrrCd4) {
		this.joCrrCd4 = joCrrCd4;
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
	 * @param oldJoCrrCd2
	 */
	public void setOldJoCrrCd2(String oldJoCrrCd2) {
		this.oldJoCrrCd2 = oldJoCrrCd2;
	}
	
	/**
	 * Column Info
	 * @param oldJoCrrCd3
	 */
	public void setOldJoCrrCd3(String oldJoCrrCd3) {
		this.oldJoCrrCd3 = oldJoCrrCd3;
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
	 * @param oldJoCrrCd1
	 */
	public void setOldJoCrrCd1(String oldJoCrrCd1) {
		this.oldJoCrrCd1 = oldJoCrrCd1;
	}
	
	/**
	 * Column Info
	 * @param iudFlag
	 */
	public void setIudFlag(String iudFlag) {
		this.iudFlag = iudFlag;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * @param joRefNo
	 */
	public void setJoRefNo(String joRefNo) {
		this.joRefNo = joRefNo;
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
		setJoCrrCd9(JSPUtil.getParameter(request, prefix + "jo_crr_cd9", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setJoCrrCd7(JSPUtil.getParameter(request, prefix + "jo_crr_cd7", ""));
		setJoCrrCd8(JSPUtil.getParameter(request, prefix + "jo_crr_cd8", ""));
		setJoRepCrrCd(JSPUtil.getParameter(request, prefix + "jo_rep_crr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setJoCrrCd1(JSPUtil.getParameter(request, prefix + "jo_crr_cd1", ""));
		setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
		setJoCrrCd2(JSPUtil.getParameter(request, prefix + "jo_crr_cd2", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
		setJoCrrCd5(JSPUtil.getParameter(request, prefix + "jo_crr_cd5", ""));
		setJoCrrCd6(JSPUtil.getParameter(request, prefix + "jo_crr_cd6", ""));
		setJoCrrCd3(JSPUtil.getParameter(request, prefix + "jo_crr_cd3", ""));
		setJoCrrCd10(JSPUtil.getParameter(request, prefix + "jo_crr_cd10", ""));
		setJoCrrCd4(JSPUtil.getParameter(request, prefix + "jo_crr_cd4", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOldJoCrrCd2(JSPUtil.getParameter(request, prefix + "old_jo_crr_cd2", ""));
		setOldJoCrrCd3(JSPUtil.getParameter(request, prefix + "old_jo_crr_cd3", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setOldJoCrrCd1(JSPUtil.getParameter(request, prefix + "old_jo_crr_cd1", ""));
		setIudFlag(JSPUtil.getParameter(request, prefix + "iud_flag", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setJoRefNo(JSPUtil.getParameter(request, prefix + "jo_ref_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BzcAgmtCrrVO[]
	 */
	public BzcAgmtCrrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BzcAgmtCrrVO[]
	 */
	public BzcAgmtCrrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BzcAgmtCrrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] joCrrCd9 = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd9", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] joCrrCd7 = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd7", length));
			String[] joCrrCd8 = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd8", length));
			String[] joRepCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_rep_crr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] joCrrCd1 = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd1", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] joCrrCd2 = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd2", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] joCrrCd5 = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd5", length));
			String[] joCrrCd6 = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd6", length));
			String[] joCrrCd3 = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd3", length));
			String[] joCrrCd10 = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd10", length));
			String[] joCrrCd4 = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd4", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] oldJoCrrCd2 = (JSPUtil.getParameter(request, prefix	+ "old_jo_crr_cd2", length));
			String[] oldJoCrrCd3 = (JSPUtil.getParameter(request, prefix	+ "old_jo_crr_cd3", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] oldJoCrrCd1 = (JSPUtil.getParameter(request, prefix	+ "old_jo_crr_cd1", length));
			String[] iudFlag = (JSPUtil.getParameter(request, prefix	+ "iud_flag", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] joRefNo = (JSPUtil.getParameter(request, prefix	+ "jo_ref_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new BzcAgmtCrrVO();
				if (joCrrCd9[i] != null)
					model.setJoCrrCd9(joCrrCd9[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (joCrrCd7[i] != null)
					model.setJoCrrCd7(joCrrCd7[i]);
				if (joCrrCd8[i] != null)
					model.setJoCrrCd8(joCrrCd8[i]);
				if (joRepCrrCd[i] != null)
					model.setJoRepCrrCd(joRepCrrCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (joCrrCd1[i] != null)
					model.setJoCrrCd1(joCrrCd1[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (joCrrCd2[i] != null)
					model.setJoCrrCd2(joCrrCd2[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (joCrrCd5[i] != null)
					model.setJoCrrCd5(joCrrCd5[i]);
				if (joCrrCd6[i] != null)
					model.setJoCrrCd6(joCrrCd6[i]);
				if (joCrrCd3[i] != null)
					model.setJoCrrCd3(joCrrCd3[i]);
				if (joCrrCd10[i] != null)
					model.setJoCrrCd10(joCrrCd10[i]);
				if (joCrrCd4[i] != null)
					model.setJoCrrCd4(joCrrCd4[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (oldJoCrrCd2[i] != null)
					model.setOldJoCrrCd2(oldJoCrrCd2[i]);
				if (oldJoCrrCd3[i] != null)
					model.setOldJoCrrCd3(oldJoCrrCd3[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (oldJoCrrCd1[i] != null)
					model.setOldJoCrrCd1(oldJoCrrCd1[i]);
				if (iudFlag[i] != null)
					model.setIudFlag(iudFlag[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (joRefNo[i] != null)
					model.setJoRefNo(joRefNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBzcAgmtCrrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BzcAgmtCrrVO[]
	 */
	public BzcAgmtCrrVO[] getBzcAgmtCrrVOs(){
		BzcAgmtCrrVO[] vos = (BzcAgmtCrrVO[])models.toArray(new BzcAgmtCrrVO[models.size()]);
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
		this.joCrrCd9 = this.joCrrCd9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd7 = this.joCrrCd7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd8 = this.joCrrCd8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRepCrrCd = this.joRepCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd1 = this.joCrrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd2 = this.joCrrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd5 = this.joCrrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd6 = this.joCrrCd6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd3 = this.joCrrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd10 = this.joCrrCd10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd4 = this.joCrrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldJoCrrCd2 = this.oldJoCrrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldJoCrrCd3 = this.oldJoCrrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldJoCrrCd1 = this.oldJoCrrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iudFlag = this.iudFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRefNo = this.joRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
