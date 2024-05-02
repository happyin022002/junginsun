/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchClosingTPBListVO.java
*@FileTitle : SearchClosingTPBListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.10.19 박성진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchClosingTPBListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchClosingTPBListVO> models = new ArrayList<SearchClosingTPBListVO>();
	
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String amtA = null;
	/* Column Info */
	private String amtB = null;
	/* Column Info */
	private String amtC = null;
	/* Column Info */
	private String amtD = null;
	/* Column Info */
	private String ifOfcCd = null;
	/* Column Info */
	private String amtE = null;
	/* Column Info */
	private String amtF = null;
	/* Column Info */
	private String cntAbc = null;
	/* Column Info */
	private String sIfCtrlCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntD = null;
	/* Column Info */
	private String cntC = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntB = null;
	/* Column Info */
	private String cntA = null;
	/* Column Info */
	private String cntF = null;
	/* Column Info */
	private String cntE = null;
	/* Column Info */
	private String sOfficeLevel = null;
	/* Column Info */
	private String sExcludeJo = null;
	/* Column Info */
	private String sEdate = null;
	/* Column Info */
	private String cntTot = null;
	/* Column Info */
	private String sStatus = null;
	/* Column Info */
	private String sSdate = null;
	/* Column Info */
	private String sIfOfcCd = null;
	/* Column Info */
	private String amtTot = null;
	/* Column Info */
	private String ifRhqCd = null;
	/* Column Info */
	private String sOfcCdForRhq = null;
	/* Column Info */
	private String sRhqCdForRhq = null;
	/* Column Info */
	private String sExcludeRoc = null;
	/* Column Info */
	private String sIfRhqCd = null;
	/* Column Info */
	private String sIfType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchClosingTPBListVO() {}

	public SearchClosingTPBListVO(String ibflag, String pagerows, String sOfficeLevel, String sRhqCdForRhq, String sOfcCdForRhq, String sSdate, String sEdate, String sIfRhqCd, String sIfCtrlCd, String sIfOfcCd, String sExcludeJo, String sExcludeRoc, String sStatus, String userOfcCd, String ifRhqCd, String ifOfcCd, String cntAbc, String amtA, String amtB, String amtC, String amtD, String amtE, String amtF, String cntA, String cntB, String cntC, String cntD, String cntE, String cntF, String cntTot, String amtTot, String sIfType) {
		this.userOfcCd = userOfcCd;
		this.amtA = amtA;
		this.amtB = amtB;
		this.amtC = amtC;
		this.amtD = amtD;
		this.ifOfcCd = ifOfcCd;
		this.amtE = amtE;
		this.amtF = amtF;
		this.cntAbc = cntAbc;
		this.sIfCtrlCd = sIfCtrlCd;
		this.pagerows = pagerows;
		this.cntD = cntD;
		this.cntC = cntC;
		this.ibflag = ibflag;
		this.cntB = cntB;
		this.cntA = cntA;
		this.cntF = cntF;
		this.cntE = cntE;
		this.sOfficeLevel = sOfficeLevel;
		this.sExcludeJo = sExcludeJo;
		this.sEdate = sEdate;
		this.cntTot = cntTot;
		this.sStatus = sStatus;
		this.sSdate = sSdate;
		this.sIfOfcCd = sIfOfcCd;
		this.amtTot = amtTot;
		this.ifRhqCd = ifRhqCd;
		this.sOfcCdForRhq = sOfcCdForRhq;
		this.sRhqCdForRhq = sRhqCdForRhq;
		this.sExcludeRoc = sExcludeRoc;
		this.sIfRhqCd = sIfRhqCd;
		this.sIfType = sIfType;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("amt_a", getAmtA());
		this.hashColumns.put("amt_b", getAmtB());
		this.hashColumns.put("amt_c", getAmtC());
		this.hashColumns.put("amt_d", getAmtD());
		this.hashColumns.put("if_ofc_cd", getIfOfcCd());
		this.hashColumns.put("amt_e", getAmtE());
		this.hashColumns.put("amt_f", getAmtF());
		this.hashColumns.put("cnt_abc", getCntAbc());
		this.hashColumns.put("s_if_ctrl_cd", getSIfCtrlCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnt_d", getCntD());
		this.hashColumns.put("cnt_c", getCntC());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_b", getCntB());
		this.hashColumns.put("cnt_a", getCntA());
		this.hashColumns.put("cnt_f", getCntF());
		this.hashColumns.put("cnt_e", getCntE());
		this.hashColumns.put("s_office_level", getSOfficeLevel());
		this.hashColumns.put("s_exclude_jo", getSExcludeJo());
		this.hashColumns.put("s_edate", getSEdate());
		this.hashColumns.put("cnt_tot", getCntTot());
		this.hashColumns.put("s_status", getSStatus());
		this.hashColumns.put("s_sdate", getSSdate());
		this.hashColumns.put("s_if_ofc_cd", getSIfOfcCd());
		this.hashColumns.put("amt_tot", getAmtTot());
		this.hashColumns.put("if_rhq_cd", getIfRhqCd());
		this.hashColumns.put("s_ofc_cd_for_rhq", getSOfcCdForRhq());
		this.hashColumns.put("s_rhq_cd_for_rhq", getSRhqCdForRhq());
		this.hashColumns.put("s_exclude_roc", getSExcludeRoc());
		this.hashColumns.put("s_if_rhq_cd", getSIfRhqCd());
		this.hashColumns.put("s_if_type", getSIfType());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("amt_a", "amtA");
		this.hashFields.put("amt_b", "amtB");
		this.hashFields.put("amt_c", "amtC");
		this.hashFields.put("amt_d", "amtD");
		this.hashFields.put("if_ofc_cd", "ifOfcCd");
		this.hashFields.put("amt_e", "amtE");
		this.hashFields.put("amt_f", "amtF");
		this.hashFields.put("cnt_abc", "cntAbc");
		this.hashFields.put("s_if_ctrl_cd", "sIfCtrlCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnt_d", "cntD");
		this.hashFields.put("cnt_c", "cntC");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_b", "cntB");
		this.hashFields.put("cnt_a", "cntA");
		this.hashFields.put("cnt_f", "cntF");
		this.hashFields.put("cnt_e", "cntE");
		this.hashFields.put("s_office_level", "sOfficeLevel");
		this.hashFields.put("s_exclude_jo", "sExcludeJo");
		this.hashFields.put("s_edate", "sEdate");
		this.hashFields.put("cnt_tot", "cntTot");
		this.hashFields.put("s_status", "sStatus");
		this.hashFields.put("s_sdate", "sSdate");
		this.hashFields.put("s_if_ofc_cd", "sIfOfcCd");
		this.hashFields.put("amt_tot", "amtTot");
		this.hashFields.put("if_rhq_cd", "ifRhqCd");
		this.hashFields.put("s_ofc_cd_for_rhq", "sOfcCdForRhq");
		this.hashFields.put("s_rhq_cd_for_rhq", "sRhqCdForRhq");
		this.hashFields.put("s_exclude_roc", "sExcludeRoc");
		this.hashFields.put("s_if_rhq_cd", "sIfRhqCd");
		this.hashFields.put("s_if_type", "sIfType");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return this.userOfcCd;
	}
	
	/**
	 * Column Info
	 * @return amtA
	 */
	public String getAmtA() {
		return this.amtA;
	}
	
	/**
	 * Column Info
	 * @return amtB
	 */
	public String getAmtB() {
		return this.amtB;
	}
	
	/**
	 * Column Info
	 * @return amtC
	 */
	public String getAmtC() {
		return this.amtC;
	}
	
	/**
	 * Column Info
	 * @return amtD
	 */
	public String getAmtD() {
		return this.amtD;
	}
	
	/**
	 * Column Info
	 * @return ifOfcCd
	 */
	public String getIfOfcCd() {
		return this.ifOfcCd;
	}
	
	/**
	 * Column Info
	 * @return amtE
	 */
	public String getAmtE() {
		return this.amtE;
	}
	
	/**
	 * Column Info
	 * @return amtF
	 */
	public String getAmtF() {
		return this.amtF;
	}
	
	/**
	 * Column Info
	 * @return cntAbc
	 */
	public String getCntAbc() {
		return this.cntAbc;
	}
	
	/**
	 * Column Info
	 * @return sIfCtrlCd
	 */
	public String getSIfCtrlCd() {
		return this.sIfCtrlCd;
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
	 * @return cntD
	 */
	public String getCntD() {
		return this.cntD;
	}
	
	/**
	 * Column Info
	 * @return cntC
	 */
	public String getCntC() {
		return this.cntC;
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
	 * @return cntB
	 */
	public String getCntB() {
		return this.cntB;
	}
	
	/**
	 * Column Info
	 * @return cntA
	 */
	public String getCntA() {
		return this.cntA;
	}
	
	/**
	 * Column Info
	 * @return cntF
	 */
	public String getCntF() {
		return this.cntF;
	}
	
	/**
	 * Column Info
	 * @return cntE
	 */
	public String getCntE() {
		return this.cntE;
	}
	
	/**
	 * Column Info
	 * @return sOfficeLevel
	 */
	public String getSOfficeLevel() {
		return this.sOfficeLevel;
	}
	
	/**
	 * Column Info
	 * @return sExcludeJo
	 */
	public String getSExcludeJo() {
		return this.sExcludeJo;
	}
	
	/**
	 * Column Info
	 * @return sEdate
	 */
	public String getSEdate() {
		return this.sEdate;
	}
	
	/**
	 * Column Info
	 * @return cntTot
	 */
	public String getCntTot() {
		return this.cntTot;
	}
	
	/**
	 * Column Info
	 * @return sStatus
	 */
	public String getSStatus() {
		return this.sStatus;
	}
	
	/**
	 * Column Info
	 * @return sSdate
	 */
	public String getSSdate() {
		return this.sSdate;
	}
	
	/**
	 * Column Info
	 * @return sIfOfcCd
	 */
	public String getSIfOfcCd() {
		return this.sIfOfcCd;
	}
	
	/**
	 * Column Info
	 * @return amtTot
	 */
	public String getAmtTot() {
		return this.amtTot;
	}
	
	/**
	 * Column Info
	 * @return ifRhqCd
	 */
	public String getIfRhqCd() {
		return this.ifRhqCd;
	}
	
	/**
	 * Column Info
	 * @return sOfcCdForRhq
	 */
	public String getSOfcCdForRhq() {
		return this.sOfcCdForRhq;
	}
	
	/**
	 * Column Info
	 * @return sRhqCdForRhq
	 */
	public String getSRhqCdForRhq() {
		return this.sRhqCdForRhq;
	}
	
	/**
	 * Column Info
	 * @return sExcludeRoc
	 */
	public String getSExcludeRoc() {
		return this.sExcludeRoc;
	}
	
	/**
	 * Column Info
	 * @return sIfRhqCd
	 */
	public String getSIfRhqCd() {
		return this.sIfRhqCd;
	}
	
	/**
	 * Column Info
	 * @return sIfType
	 */
	public String getSIfType() {
		return this.sIfType;
	}
	
	/**
	 * Column Info
	 * @param sIfType
	 */
	public void setSIfType(String sIfType) {
		this.sIfType = sIfType;
	}
	
	/**
	 * Column Info
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}
	
	/**
	 * Column Info
	 * @param amtA
	 */
	public void setAmtA(String amtA) {
		this.amtA = amtA;
	}
	
	/**
	 * Column Info
	 * @param amtB
	 */
	public void setAmtB(String amtB) {
		this.amtB = amtB;
	}
	
	/**
	 * Column Info
	 * @param amtC
	 */
	public void setAmtC(String amtC) {
		this.amtC = amtC;
	}
	
	/**
	 * Column Info
	 * @param amtD
	 */
	public void setAmtD(String amtD) {
		this.amtD = amtD;
	}
	
	/**
	 * Column Info
	 * @param ifOfcCd
	 */
	public void setIfOfcCd(String ifOfcCd) {
		this.ifOfcCd = ifOfcCd;
	}
	
	/**
	 * Column Info
	 * @param amtE
	 */
	public void setAmtE(String amtE) {
		this.amtE = amtE;
	}
	
	/**
	 * Column Info
	 * @param amtF
	 */
	public void setAmtF(String amtF) {
		this.amtF = amtF;
	}
	
	/**
	 * Column Info
	 * @param cntAbc
	 */
	public void setCntAbc(String cntAbc) {
		this.cntAbc = cntAbc;
	}
	
	/**
	 * Column Info
	 * @param sIfCtrlCd
	 */
	public void setSIfCtrlCd(String sIfCtrlCd) {
		this.sIfCtrlCd = sIfCtrlCd;
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
	 * @param cntD
	 */
	public void setCntD(String cntD) {
		this.cntD = cntD;
	}
	
	/**
	 * Column Info
	 * @param cntC
	 */
	public void setCntC(String cntC) {
		this.cntC = cntC;
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
	 * @param cntB
	 */
	public void setCntB(String cntB) {
		this.cntB = cntB;
	}
	
	/**
	 * Column Info
	 * @param cntA
	 */
	public void setCntA(String cntA) {
		this.cntA = cntA;
	}
	
	/**
	 * Column Info
	 * @param cntF
	 */
	public void setCntF(String cntF) {
		this.cntF = cntF;
	}
	
	/**
	 * Column Info
	 * @param cntE
	 */
	public void setCntE(String cntE) {
		this.cntE = cntE;
	}
	
	/**
	 * Column Info
	 * @param sOfficeLevel
	 */
	public void setSOfficeLevel(String sOfficeLevel) {
		this.sOfficeLevel = sOfficeLevel;
	}
	
	/**
	 * Column Info
	 * @param sExcludeJo
	 */
	public void setSExcludeJo(String sExcludeJo) {
		this.sExcludeJo = sExcludeJo;
	}
	
	/**
	 * Column Info
	 * @param sEdate
	 */
	public void setSEdate(String sEdate) {
		this.sEdate = sEdate;
	}
	
	/**
	 * Column Info
	 * @param cntTot
	 */
	public void setCntTot(String cntTot) {
		this.cntTot = cntTot;
	}
	
	/**
	 * Column Info
	 * @param sStatus
	 */
	public void setSStatus(String sStatus) {
		this.sStatus = sStatus;
	}
	
	/**
	 * Column Info
	 * @param sSdate
	 */
	public void setSSdate(String sSdate) {
		this.sSdate = sSdate;
	}
	
	/**
	 * Column Info
	 * @param sIfOfcCd
	 */
	public void setSIfOfcCd(String sIfOfcCd) {
		this.sIfOfcCd = sIfOfcCd;
	}
	
	/**
	 * Column Info
	 * @param amtTot
	 */
	public void setAmtTot(String amtTot) {
		this.amtTot = amtTot;
	}
	
	/**
	 * Column Info
	 * @param ifRhqCd
	 */
	public void setIfRhqCd(String ifRhqCd) {
		this.ifRhqCd = ifRhqCd;
	}
	
	/**
	 * Column Info
	 * @param sOfcCdForRhq
	 */
	public void setSOfcCdForRhq(String sOfcCdForRhq) {
		this.sOfcCdForRhq = sOfcCdForRhq;
	}
	
	/**
	 * Column Info
	 * @param sRhqCdForRhq
	 */
	public void setSRhqCdForRhq(String sRhqCdForRhq) {
		this.sRhqCdForRhq = sRhqCdForRhq;
	}
	
	/**
	 * Column Info
	 * @param sExcludeRoc
	 */
	public void setSExcludeRoc(String sExcludeRoc) {
		this.sExcludeRoc = sExcludeRoc;
	}
	
	/**
	 * Column Info
	 * @param sIfRhqCd
	 */
	public void setSIfRhqCd(String sIfRhqCd) {
		this.sIfRhqCd = sIfRhqCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
		setAmtA(JSPUtil.getParameter(request, "amt_a", ""));
		setAmtB(JSPUtil.getParameter(request, "amt_b", ""));
		setAmtC(JSPUtil.getParameter(request, "amt_c", ""));
		setAmtD(JSPUtil.getParameter(request, "amt_d", ""));
		setIfOfcCd(JSPUtil.getParameter(request, "if_ofc_cd", ""));
		setAmtE(JSPUtil.getParameter(request, "amt_e", ""));
		setAmtF(JSPUtil.getParameter(request, "amt_f", ""));
		setCntAbc(JSPUtil.getParameter(request, "cnt_abc", ""));
		setSIfCtrlCd(JSPUtil.getParameter(request, "s_if_ctrl_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntD(JSPUtil.getParameter(request, "cnt_d", ""));
		setCntC(JSPUtil.getParameter(request, "cnt_c", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntB(JSPUtil.getParameter(request, "cnt_b", ""));
		setCntA(JSPUtil.getParameter(request, "cnt_a", ""));
		setCntF(JSPUtil.getParameter(request, "cnt_f", ""));
		setCntE(JSPUtil.getParameter(request, "cnt_e", ""));
		setSOfficeLevel(JSPUtil.getParameter(request, "s_office_level", ""));
		setSExcludeJo(JSPUtil.getParameter(request, "s_exclude_jo", ""));
		setSEdate(JSPUtil.getParameter(request, "s_edate", ""));
		setCntTot(JSPUtil.getParameter(request, "cnt_tot", ""));
		setSStatus(JSPUtil.getParameter(request, "s_status", ""));
		setSSdate(JSPUtil.getParameter(request, "s_sdate", ""));
		setSIfOfcCd(JSPUtil.getParameter(request, "s_if_ofc_cd", ""));
		setAmtTot(JSPUtil.getParameter(request, "amt_tot", ""));
		setIfRhqCd(JSPUtil.getParameter(request, "if_rhq_cd", ""));
		setSOfcCdForRhq(JSPUtil.getParameter(request, "s_ofc_cd_for_rhq", ""));
		setSRhqCdForRhq(JSPUtil.getParameter(request, "s_rhq_cd_for_rhq", ""));
		setSExcludeRoc(JSPUtil.getParameter(request, "s_exclude_roc", ""));
		setSIfRhqCd(JSPUtil.getParameter(request, "s_if_rhq_cd", ""));
		setSIfType(JSPUtil.getParameter(request,  "s_if_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchClosingTPBListVO[]
	 */
	public SearchClosingTPBListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchClosingTPBListVO[]
	 */
	public SearchClosingTPBListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchClosingTPBListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] amtA = (JSPUtil.getParameter(request, prefix	+ "amt_a", length));
			String[] amtB = (JSPUtil.getParameter(request, prefix	+ "amt_b", length));
			String[] amtC = (JSPUtil.getParameter(request, prefix	+ "amt_c", length));
			String[] amtD = (JSPUtil.getParameter(request, prefix	+ "amt_d", length));
			String[] ifOfcCd = (JSPUtil.getParameter(request, prefix	+ "if_ofc_cd", length));
			String[] amtE = (JSPUtil.getParameter(request, prefix	+ "amt_e", length));
			String[] amtF = (JSPUtil.getParameter(request, prefix	+ "amt_f", length));
			String[] cntAbc = (JSPUtil.getParameter(request, prefix	+ "cnt_abc", length));
			String[] sIfCtrlCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ctrl_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntD = (JSPUtil.getParameter(request, prefix	+ "cnt_d", length));
			String[] cntC = (JSPUtil.getParameter(request, prefix	+ "cnt_c", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntB = (JSPUtil.getParameter(request, prefix	+ "cnt_b", length));
			String[] cntA = (JSPUtil.getParameter(request, prefix	+ "cnt_a", length));
			String[] cntF = (JSPUtil.getParameter(request, prefix	+ "cnt_f", length));
			String[] cntE = (JSPUtil.getParameter(request, prefix	+ "cnt_e", length));
			String[] sOfficeLevel = (JSPUtil.getParameter(request, prefix	+ "s_office_level", length));
			String[] sExcludeJo = (JSPUtil.getParameter(request, prefix	+ "s_exclude_jo", length));
			String[] sEdate = (JSPUtil.getParameter(request, prefix	+ "s_edate", length));
			String[] cntTot = (JSPUtil.getParameter(request, prefix	+ "cnt_tot", length));
			String[] sStatus = (JSPUtil.getParameter(request, prefix	+ "s_status", length));
			String[] sSdate = (JSPUtil.getParameter(request, prefix	+ "s_sdate", length));
			String[] sIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ofc_cd", length));
			String[] amtTot = (JSPUtil.getParameter(request, prefix	+ "amt_tot", length));
			String[] ifRhqCd = (JSPUtil.getParameter(request, prefix	+ "if_rhq_cd", length));
			String[] sOfcCdForRhq = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd_for_rhq", length));
			String[] sRhqCdForRhq = (JSPUtil.getParameter(request, prefix	+ "s_rhq_cd_for_rhq", length));
			String[] sExcludeRoc = (JSPUtil.getParameter(request, prefix	+ "s_exclude_roc", length));
			String[] sIfRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_if_rhq_cd", length));
			String[] sIfType = (JSPUtil.getParameter(request, prefix	+ "s_if_type", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchClosingTPBListVO();
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (amtA[i] != null)
					model.setAmtA(amtA[i]);
				if (amtB[i] != null)
					model.setAmtB(amtB[i]);
				if (amtC[i] != null)
					model.setAmtC(amtC[i]);
				if (amtD[i] != null)
					model.setAmtD(amtD[i]);
				if (ifOfcCd[i] != null)
					model.setIfOfcCd(ifOfcCd[i]);
				if (amtE[i] != null)
					model.setAmtE(amtE[i]);
				if (amtF[i] != null)
					model.setAmtF(amtF[i]);
				if (cntAbc[i] != null)
					model.setCntAbc(cntAbc[i]);
				if (sIfCtrlCd[i] != null)
					model.setSIfCtrlCd(sIfCtrlCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntD[i] != null)
					model.setCntD(cntD[i]);
				if (cntC[i] != null)
					model.setCntC(cntC[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntB[i] != null)
					model.setCntB(cntB[i]);
				if (cntA[i] != null)
					model.setCntA(cntA[i]);
				if (cntF[i] != null)
					model.setCntF(cntF[i]);
				if (cntE[i] != null)
					model.setCntE(cntE[i]);
				if (sOfficeLevel[i] != null)
					model.setSOfficeLevel(sOfficeLevel[i]);
				if (sExcludeJo[i] != null)
					model.setSExcludeJo(sExcludeJo[i]);
				if (sEdate[i] != null)
					model.setSEdate(sEdate[i]);
				if (cntTot[i] != null)
					model.setCntTot(cntTot[i]);
				if (sStatus[i] != null)
					model.setSStatus(sStatus[i]);
				if (sSdate[i] != null)
					model.setSSdate(sSdate[i]);
				if (sIfOfcCd[i] != null)
					model.setSIfOfcCd(sIfOfcCd[i]);
				if (amtTot[i] != null)
					model.setAmtTot(amtTot[i]);
				if (ifRhqCd[i] != null)
					model.setIfRhqCd(ifRhqCd[i]);
				if (sOfcCdForRhq[i] != null)
					model.setSOfcCdForRhq(sOfcCdForRhq[i]);
				if (sRhqCdForRhq[i] != null)
					model.setSRhqCdForRhq(sRhqCdForRhq[i]);
				if (sExcludeRoc[i] != null)
					model.setSExcludeRoc(sExcludeRoc[i]);
				if (sIfRhqCd[i] != null)
					model.setSIfRhqCd(sIfRhqCd[i]);
				if (sIfType[i] != null)
					model.setSIfType(sIfType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchClosingTPBListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchClosingTPBListVO[]
	 */
	public SearchClosingTPBListVO[] getSearchClosingTPBListVOs(){
		SearchClosingTPBListVO[] vos = (SearchClosingTPBListVO[])models.toArray(new SearchClosingTPBListVO[models.size()]);
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
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtA = this.amtA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtB = this.amtB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtC = this.amtC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtD = this.amtD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifOfcCd = this.ifOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtE = this.amtE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtF = this.amtF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntAbc = this.cntAbc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfCtrlCd = this.sIfCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntD = this.cntD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntC = this.cntC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntB = this.cntB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntA = this.cntA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntF = this.cntF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntE = this.cntE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfficeLevel = this.sOfficeLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sExcludeJo = this.sExcludeJo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEdate = this.sEdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntTot = this.cntTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sStatus = this.sStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSdate = this.sSdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfOfcCd = this.sIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtTot = this.amtTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifRhqCd = this.ifRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCdForRhq = this.sOfcCdForRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqCdForRhq = this.sRhqCdForRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sExcludeRoc = this.sExcludeRoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfRhqCd = this.sIfRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfType = this.sIfType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
