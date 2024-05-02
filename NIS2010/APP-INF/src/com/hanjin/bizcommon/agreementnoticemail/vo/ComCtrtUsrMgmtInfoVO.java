/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ComCtrtUsrMgmtInfoVO.java
*@FileTitle : ComCtrtUsrMgmtInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.20  
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.agreementnoticemail.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ComCtrtUsrMgmtInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComCtrtUsrMgmtInfoVO> models = new ArrayList<ComCtrtUsrMgmtInfoVO>();
	
	/* Column Info */
	private String ntcUsrNm1 = null;
	/* Column Info */
	private String ntcUsrNm2 = null;
	/* Column Info */
	private String ntcUsrNm3 = null;
	/* Column Info */
	private String ntcUsrNm4 = null;
	/* Column Info */
	private String ntcUsrNm5 = null;
	/* Column Info */
	private String ofcTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String usrEmlCtnt = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String ntcUsrEml7 = null;
	/* Column Info */
	private String ntcUsrEml6 = null;
	/* Column Info */
	private String ntcUsrEml5 = null;
	/* Column Info */
	private String ntcUsrId2 = null;
	/* Column Info */
	private String sysCd = null;
	/* Column Info */
	private String ntcUsrEml4 = null;
	/* Column Info */
	private String ntcUsrId3 = null;
	/* Column Info */
	private String ntcUsrEml3 = null;
	/* Column Info */
	private String ntcUsrId4 = null;
	/* Column Info */
	private String ntcUsrNm7 = null;
	/* Column Info */
	private String ntcUsrEml2 = null;
	/* Column Info */
	private String ntcUsrId5 = null;
	/* Column Info */
	private String ntcUsrNm6 = null;
	/* Column Info */
	private String ntcUsrEml1 = null;
	/* Column Info */
	private String ntcUsrId6 = null;
	/* Column Info */
	private String ntcUsrId7 = null;
	/* Column Info */
	private String ntcUsrId1 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ComCtrtUsrMgmtInfoVO() {}

	public ComCtrtUsrMgmtInfoVO(String ibflag, String pagerows, String usrEmlCtnt, String ntcUsrNm1, String ntcUsrNm2, String ntcUsrNm3, String ntcUsrNm4, String ntcUsrNm5, String ofcTpCd, String ctrtOfcCd, String agmtNo, String ntcUsrEml7, String ntcUsrEml6, String ntcUsrEml5, String ntcUsrId2, String sysCd, String ntcUsrEml4, String ntcUsrId3, String ntcUsrEml3, String ntcUsrId4, String ntcUsrNm7, String ntcUsrEml2, String ntcUsrId5, String ntcUsrNm6, String ntcUsrEml1, String ntcUsrId6, String ntcUsrId7, String ntcUsrId1) {
		this.ntcUsrNm1 = ntcUsrNm1;
		this.ntcUsrNm2 = ntcUsrNm2;
		this.ntcUsrNm3 = ntcUsrNm3;
		this.ntcUsrNm4 = ntcUsrNm4;
		this.ntcUsrNm5 = ntcUsrNm5;
		this.ofcTpCd = ofcTpCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.ctrtOfcCd = ctrtOfcCd;
		this.usrEmlCtnt = usrEmlCtnt;
		this.agmtNo = agmtNo;
		this.ntcUsrEml7 = ntcUsrEml7;
		this.ntcUsrEml6 = ntcUsrEml6;
		this.ntcUsrEml5 = ntcUsrEml5;
		this.ntcUsrId2 = ntcUsrId2;
		this.sysCd = sysCd;
		this.ntcUsrEml4 = ntcUsrEml4;
		this.ntcUsrId3 = ntcUsrId3;
		this.ntcUsrEml3 = ntcUsrEml3;
		this.ntcUsrId4 = ntcUsrId4;
		this.ntcUsrNm7 = ntcUsrNm7;
		this.ntcUsrEml2 = ntcUsrEml2;
		this.ntcUsrId5 = ntcUsrId5;
		this.ntcUsrNm6 = ntcUsrNm6;
		this.ntcUsrEml1 = ntcUsrEml1;
		this.ntcUsrId6 = ntcUsrId6;
		this.ntcUsrId7 = ntcUsrId7;
		this.ntcUsrId1 = ntcUsrId1;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ntc_usr_nm1", getNtcUsrNm1());
		this.hashColumns.put("ntc_usr_nm2", getNtcUsrNm2());
		this.hashColumns.put("ntc_usr_nm3", getNtcUsrNm3());
		this.hashColumns.put("ntc_usr_nm4", getNtcUsrNm4());
		this.hashColumns.put("ntc_usr_nm5", getNtcUsrNm5());
		this.hashColumns.put("ofc_tp_cd", getOfcTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("usr_eml_ctnt", getUsrEmlCtnt());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("ntc_usr_eml7", getNtcUsrEml7());
		this.hashColumns.put("ntc_usr_eml6", getNtcUsrEml6());
		this.hashColumns.put("ntc_usr_eml5", getNtcUsrEml5());
		this.hashColumns.put("ntc_usr_id2", getNtcUsrId2());
		this.hashColumns.put("sys_cd", getSysCd());
		this.hashColumns.put("ntc_usr_eml4", getNtcUsrEml4());
		this.hashColumns.put("ntc_usr_id3", getNtcUsrId3());
		this.hashColumns.put("ntc_usr_eml3", getNtcUsrEml3());
		this.hashColumns.put("ntc_usr_id4", getNtcUsrId4());
		this.hashColumns.put("ntc_usr_nm7", getNtcUsrNm7());
		this.hashColumns.put("ntc_usr_eml2", getNtcUsrEml2());
		this.hashColumns.put("ntc_usr_id5", getNtcUsrId5());
		this.hashColumns.put("ntc_usr_nm6", getNtcUsrNm6());
		this.hashColumns.put("ntc_usr_eml1", getNtcUsrEml1());
		this.hashColumns.put("ntc_usr_id6", getNtcUsrId6());
		this.hashColumns.put("ntc_usr_id7", getNtcUsrId7());
		this.hashColumns.put("ntc_usr_id1", getNtcUsrId1());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ntc_usr_nm1", "ntcUsrNm1");
		this.hashFields.put("ntc_usr_nm2", "ntcUsrNm2");
		this.hashFields.put("ntc_usr_nm3", "ntcUsrNm3");
		this.hashFields.put("ntc_usr_nm4", "ntcUsrNm4");
		this.hashFields.put("ntc_usr_nm5", "ntcUsrNm5");
		this.hashFields.put("ofc_tp_cd", "ofcTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("usr_eml_ctnt", "usrEmlCtnt");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("ntc_usr_eml7", "ntcUsrEml7");
		this.hashFields.put("ntc_usr_eml6", "ntcUsrEml6");
		this.hashFields.put("ntc_usr_eml5", "ntcUsrEml5");
		this.hashFields.put("ntc_usr_id2", "ntcUsrId2");
		this.hashFields.put("sys_cd", "sysCd");
		this.hashFields.put("ntc_usr_eml4", "ntcUsrEml4");
		this.hashFields.put("ntc_usr_id3", "ntcUsrId3");
		this.hashFields.put("ntc_usr_eml3", "ntcUsrEml3");
		this.hashFields.put("ntc_usr_id4", "ntcUsrId4");
		this.hashFields.put("ntc_usr_nm7", "ntcUsrNm7");
		this.hashFields.put("ntc_usr_eml2", "ntcUsrEml2");
		this.hashFields.put("ntc_usr_id5", "ntcUsrId5");
		this.hashFields.put("ntc_usr_nm6", "ntcUsrNm6");
		this.hashFields.put("ntc_usr_eml1", "ntcUsrEml1");
		this.hashFields.put("ntc_usr_id6", "ntcUsrId6");
		this.hashFields.put("ntc_usr_id7", "ntcUsrId7");
		this.hashFields.put("ntc_usr_id1", "ntcUsrId1");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrNm1
	 */
	public String getNtcUsrNm1() {
		return this.ntcUsrNm1;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrNm2
	 */
	public String getNtcUsrNm2() {
		return this.ntcUsrNm2;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrNm3
	 */
	public String getNtcUsrNm3() {
		return this.ntcUsrNm3;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrNm4
	 */
	public String getNtcUsrNm4() {
		return this.ntcUsrNm4;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrNm5
	 */
	public String getNtcUsrNm5() {
		return this.ntcUsrNm5;
	}
	
	/**
	 * Column Info
	 * @return ofcTpCd
	 */
	public String getOfcTpCd() {
		return this.ofcTpCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return usrEmlCtnt
	 */
	public String getUsrEmlCtnt() {
		return this.usrEmlCtnt;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrEml7
	 */
	public String getNtcUsrEml7() {
		return this.ntcUsrEml7;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrEml6
	 */
	public String getNtcUsrEml6() {
		return this.ntcUsrEml6;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrEml5
	 */
	public String getNtcUsrEml5() {
		return this.ntcUsrEml5;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrId2
	 */
	public String getNtcUsrId2() {
		return this.ntcUsrId2;
	}
	
	/**
	 * Column Info
	 * @return sysCd
	 */
	public String getSysCd() {
		return this.sysCd;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrEml4
	 */
	public String getNtcUsrEml4() {
		return this.ntcUsrEml4;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrId3
	 */
	public String getNtcUsrId3() {
		return this.ntcUsrId3;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrEml3
	 */
	public String getNtcUsrEml3() {
		return this.ntcUsrEml3;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrId4
	 */
	public String getNtcUsrId4() {
		return this.ntcUsrId4;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrNm7
	 */
	public String getNtcUsrNm7() {
		return this.ntcUsrNm7;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrEml2
	 */
	public String getNtcUsrEml2() {
		return this.ntcUsrEml2;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrId5
	 */
	public String getNtcUsrId5() {
		return this.ntcUsrId5;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrNm6
	 */
	public String getNtcUsrNm6() {
		return this.ntcUsrNm6;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrEml1
	 */
	public String getNtcUsrEml1() {
		return this.ntcUsrEml1;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrId6
	 */
	public String getNtcUsrId6() {
		return this.ntcUsrId6;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrId7
	 */
	public String getNtcUsrId7() {
		return this.ntcUsrId7;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrId1
	 */
	public String getNtcUsrId1() {
		return this.ntcUsrId1;
	}
	

	/**
	 * Column Info
	 * @param ntcUsrNm1
	 */
	public void setNtcUsrNm1(String ntcUsrNm1) {
		this.ntcUsrNm1 = ntcUsrNm1;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrNm2
	 */
	public void setNtcUsrNm2(String ntcUsrNm2) {
		this.ntcUsrNm2 = ntcUsrNm2;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrNm3
	 */
	public void setNtcUsrNm3(String ntcUsrNm3) {
		this.ntcUsrNm3 = ntcUsrNm3;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrNm4
	 */
	public void setNtcUsrNm4(String ntcUsrNm4) {
		this.ntcUsrNm4 = ntcUsrNm4;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrNm5
	 */
	public void setNtcUsrNm5(String ntcUsrNm5) {
		this.ntcUsrNm5 = ntcUsrNm5;
	}
	
	/**
	 * Column Info
	 * @param ofcTpCd
	 */
	public void setOfcTpCd(String ofcTpCd) {
		this.ofcTpCd = ofcTpCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param usrEmlCtnt
	 */
	public void setUsrEmlCtnt(String usrEmlCtnt) {
		this.usrEmlCtnt = usrEmlCtnt;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrEml7
	 */
	public void setNtcUsrEml7(String ntcUsrEml7) {
		this.ntcUsrEml7 = ntcUsrEml7;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrEml6
	 */
	public void setNtcUsrEml6(String ntcUsrEml6) {
		this.ntcUsrEml6 = ntcUsrEml6;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrEml5
	 */
	public void setNtcUsrEml5(String ntcUsrEml5) {
		this.ntcUsrEml5 = ntcUsrEml5;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrId2
	 */
	public void setNtcUsrId2(String ntcUsrId2) {
		this.ntcUsrId2 = ntcUsrId2;
	}
	
	/**
	 * Column Info
	 * @param sysCd
	 */
	public void setSysCd(String sysCd) {
		this.sysCd = sysCd;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrEml4
	 */
	public void setNtcUsrEml4(String ntcUsrEml4) {
		this.ntcUsrEml4 = ntcUsrEml4;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrId3
	 */
	public void setNtcUsrId3(String ntcUsrId3) {
		this.ntcUsrId3 = ntcUsrId3;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrEml3
	 */
	public void setNtcUsrEml3(String ntcUsrEml3) {
		this.ntcUsrEml3 = ntcUsrEml3;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrId4
	 */
	public void setNtcUsrId4(String ntcUsrId4) {
		this.ntcUsrId4 = ntcUsrId4;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrNm7
	 */
	public void setNtcUsrNm7(String ntcUsrNm7) {
		this.ntcUsrNm7 = ntcUsrNm7;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrEml2
	 */
	public void setNtcUsrEml2(String ntcUsrEml2) {
		this.ntcUsrEml2 = ntcUsrEml2;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrId5
	 */
	public void setNtcUsrId5(String ntcUsrId5) {
		this.ntcUsrId5 = ntcUsrId5;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrNm6
	 */
	public void setNtcUsrNm6(String ntcUsrNm6) {
		this.ntcUsrNm6 = ntcUsrNm6;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrEml1
	 */
	public void setNtcUsrEml1(String ntcUsrEml1) {
		this.ntcUsrEml1 = ntcUsrEml1;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrId6
	 */
	public void setNtcUsrId6(String ntcUsrId6) {
		this.ntcUsrId6 = ntcUsrId6;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrId7
	 */
	public void setNtcUsrId7(String ntcUsrId7) {
		this.ntcUsrId7 = ntcUsrId7;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrId1
	 */
	public void setNtcUsrId1(String ntcUsrId1) {
		this.ntcUsrId1 = ntcUsrId1;
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
		setNtcUsrNm1(JSPUtil.getParameter(request, prefix + "ntc_usr_nm1", ""));
		setNtcUsrNm2(JSPUtil.getParameter(request, prefix + "ntc_usr_nm2", ""));
		setNtcUsrNm3(JSPUtil.getParameter(request, prefix + "ntc_usr_nm3", ""));
		setNtcUsrNm4(JSPUtil.getParameter(request, prefix + "ntc_usr_nm4", ""));
		setNtcUsrNm5(JSPUtil.getParameter(request, prefix + "ntc_usr_nm5", ""));
		setOfcTpCd(JSPUtil.getParameter(request, prefix + "ofc_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setUsrEmlCtnt(JSPUtil.getParameter(request, prefix + "usr_eml_ctnt", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setNtcUsrEml7(JSPUtil.getParameter(request, prefix + "ntc_usr_eml7", ""));
		setNtcUsrEml6(JSPUtil.getParameter(request, prefix + "ntc_usr_eml6", ""));
		setNtcUsrEml5(JSPUtil.getParameter(request, prefix + "ntc_usr_eml5", ""));
		setNtcUsrId2(JSPUtil.getParameter(request, prefix + "ntc_usr_id2", ""));
		setSysCd(JSPUtil.getParameter(request, prefix + "sys_cd", ""));
		setNtcUsrEml4(JSPUtil.getParameter(request, prefix + "ntc_usr_eml4", ""));
		setNtcUsrId3(JSPUtil.getParameter(request, prefix + "ntc_usr_id3", ""));
		setNtcUsrEml3(JSPUtil.getParameter(request, prefix + "ntc_usr_eml3", ""));
		setNtcUsrId4(JSPUtil.getParameter(request, prefix + "ntc_usr_id4", ""));
		setNtcUsrNm7(JSPUtil.getParameter(request, prefix + "ntc_usr_nm7", ""));
		setNtcUsrEml2(JSPUtil.getParameter(request, prefix + "ntc_usr_eml2", ""));
		setNtcUsrId5(JSPUtil.getParameter(request, prefix + "ntc_usr_id5", ""));
		setNtcUsrNm6(JSPUtil.getParameter(request, prefix + "ntc_usr_nm6", ""));
		setNtcUsrEml1(JSPUtil.getParameter(request, prefix + "ntc_usr_eml1", ""));
		setNtcUsrId6(JSPUtil.getParameter(request, prefix + "ntc_usr_id6", ""));
		setNtcUsrId7(JSPUtil.getParameter(request, prefix + "ntc_usr_id7", ""));
		setNtcUsrId1(JSPUtil.getParameter(request, prefix + "ntc_usr_id1", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ComCtrtUsrMgmtInfoVO[]
	 */
	public ComCtrtUsrMgmtInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ComCtrtUsrMgmtInfoVO[]
	 */
	public ComCtrtUsrMgmtInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComCtrtUsrMgmtInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ntcUsrNm1 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_nm1", length));
			String[] ntcUsrNm2 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_nm2", length));
			String[] ntcUsrNm3 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_nm3", length));
			String[] ntcUsrNm4 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_nm4", length));
			String[] ntcUsrNm5 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_nm5", length));
			String[] ofcTpCd = (JSPUtil.getParameter(request, prefix	+ "ofc_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] usrEmlCtnt = (JSPUtil.getParameter(request, prefix	+ "usr_eml_ctnt", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] ntcUsrEml7 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_eml7", length));
			String[] ntcUsrEml6 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_eml6", length));
			String[] ntcUsrEml5 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_eml5", length));
			String[] ntcUsrId2 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id2", length));
			String[] sysCd = (JSPUtil.getParameter(request, prefix	+ "sys_cd", length));
			String[] ntcUsrEml4 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_eml4", length));
			String[] ntcUsrId3 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id3", length));
			String[] ntcUsrEml3 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_eml3", length));
			String[] ntcUsrId4 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id4", length));
			String[] ntcUsrNm7 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_nm7", length));
			String[] ntcUsrEml2 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_eml2", length));
			String[] ntcUsrId5 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id5", length));
			String[] ntcUsrNm6 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_nm6", length));
			String[] ntcUsrEml1 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_eml1", length));
			String[] ntcUsrId6 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id6", length));
			String[] ntcUsrId7 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id7", length));
			String[] ntcUsrId1 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id1", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComCtrtUsrMgmtInfoVO();
				if (ntcUsrNm1[i] != null)
					model.setNtcUsrNm1(ntcUsrNm1[i]);
				if (ntcUsrNm2[i] != null)
					model.setNtcUsrNm2(ntcUsrNm2[i]);
				if (ntcUsrNm3[i] != null)
					model.setNtcUsrNm3(ntcUsrNm3[i]);
				if (ntcUsrNm4[i] != null)
					model.setNtcUsrNm4(ntcUsrNm4[i]);
				if (ntcUsrNm5[i] != null)
					model.setNtcUsrNm5(ntcUsrNm5[i]);
				if (ofcTpCd[i] != null)
					model.setOfcTpCd(ofcTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (usrEmlCtnt[i] != null)
					model.setUsrEmlCtnt(usrEmlCtnt[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (ntcUsrEml7[i] != null)
					model.setNtcUsrEml7(ntcUsrEml7[i]);
				if (ntcUsrEml6[i] != null)
					model.setNtcUsrEml6(ntcUsrEml6[i]);
				if (ntcUsrEml5[i] != null)
					model.setNtcUsrEml5(ntcUsrEml5[i]);
				if (ntcUsrId2[i] != null)
					model.setNtcUsrId2(ntcUsrId2[i]);
				if (sysCd[i] != null)
					model.setSysCd(sysCd[i]);
				if (ntcUsrEml4[i] != null)
					model.setNtcUsrEml4(ntcUsrEml4[i]);
				if (ntcUsrId3[i] != null)
					model.setNtcUsrId3(ntcUsrId3[i]);
				if (ntcUsrEml3[i] != null)
					model.setNtcUsrEml3(ntcUsrEml3[i]);
				if (ntcUsrId4[i] != null)
					model.setNtcUsrId4(ntcUsrId4[i]);
				if (ntcUsrNm7[i] != null)
					model.setNtcUsrNm7(ntcUsrNm7[i]);
				if (ntcUsrEml2[i] != null)
					model.setNtcUsrEml2(ntcUsrEml2[i]);
				if (ntcUsrId5[i] != null)
					model.setNtcUsrId5(ntcUsrId5[i]);
				if (ntcUsrNm6[i] != null)
					model.setNtcUsrNm6(ntcUsrNm6[i]);
				if (ntcUsrEml1[i] != null)
					model.setNtcUsrEml1(ntcUsrEml1[i]);
				if (ntcUsrId6[i] != null)
					model.setNtcUsrId6(ntcUsrId6[i]);
				if (ntcUsrId7[i] != null)
					model.setNtcUsrId7(ntcUsrId7[i]);
				if (ntcUsrId1[i] != null)
					model.setNtcUsrId1(ntcUsrId1[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getComCtrtUsrMgmtInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ComCtrtUsrMgmtInfoVO[]
	 */
	public ComCtrtUsrMgmtInfoVO[] getComCtrtUsrMgmtInfoVOs(){
		ComCtrtUsrMgmtInfoVO[] vos = (ComCtrtUsrMgmtInfoVO[])models.toArray(new ComCtrtUsrMgmtInfoVO[models.size()]);
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
		this.ntcUsrNm1 = this.ntcUsrNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrNm2 = this.ntcUsrNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrNm3 = this.ntcUsrNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrNm4 = this.ntcUsrNm4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrNm5 = this.ntcUsrNm5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTpCd = this.ofcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEmlCtnt = this.usrEmlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrEml7 = this.ntcUsrEml7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrEml6 = this.ntcUsrEml6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrEml5 = this.ntcUsrEml5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId2 = this.ntcUsrId2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysCd = this.sysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrEml4 = this.ntcUsrEml4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId3 = this.ntcUsrId3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrEml3 = this.ntcUsrEml3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId4 = this.ntcUsrId4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrNm7 = this.ntcUsrNm7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrEml2 = this.ntcUsrEml2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId5 = this.ntcUsrId5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrNm6 = this.ntcUsrNm6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrEml1 = this.ntcUsrEml1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId6 = this.ntcUsrId6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId7 = this.ntcUsrId7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId1 = this.ntcUsrId1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
