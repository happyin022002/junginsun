/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EstmPerformanceChangeStatusRsltVO.java
*@FileTitle : EstmPerformanceChangeStatusRsltVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.10
*@LastModifier : 조병연
*@LastVersion : 1.0
* 2012.01.10 조병연 
* 1.0 Creation
* -------------------------------------------------------
* 2012.01.10 조병연[CHM-201215460-01]
* Title : [ALPS JOO] Estimate Performance Change Status I 신규개발 (2011년 12월 4차)
* 내용 :
* 매월 결산 후 "공동운항 선복 용/대선료 실적 현황" 보고 시, 전월 대상항차의 Estimate 변동 현황 분석을 위해 
* 첨부와 같이 신규개발을 요청 드립니다.
* (동일한 대상 기간의 추정실적 Data를 비교하여 변동 건을 포착/분석하는 기능)

* - 기대효과 1 : 기존의 Excel 수작업 업무를 시스템화함으로써 업무 편의성 및 효율성 제고
* - 기대효과 2 : Initial Estimate(ALPS BSA 모듈의 Data) 뿐 아니라 Adjusted Estimate
*   (ALPS JOO 모듈의 추정실적 생성 메뉴에서 User가 Manual로 조정한 Data)까지 자동으로 비교함으로써 변동 현황 
*   분석의 다각화 가능
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo;

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
 * @author 조병연
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EstmPerformanceChangeStatusRsltVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EstmPerformanceChangeStatusRsltVO> models = new ArrayList<EstmPerformanceChangeStatusRsltVO>();

	/* Column Info */
	private String revYrmon = null;

	/* Column Info */
	private String joCrrCd = null;
	
	/* Column Info */
	private String vvd = null;
	
	/* Column Info */
	private String rlaneCd = null;
	
	/* Column Info */
	private String joStlJbCd = null;
	
	/* Column Info */
	private String acctCd = null;
	
	/* Column Info */
	private String estm1BsaQty = null;
	
	/* Column Info */
	private String estm1BsaSltPrc = null;
	
	/* Column Info */
	private String estm1Amt = null;
	
	/* Column Info */
	private String estm2BsaQty = null;
	
	/* Column Info */
	private String estm2BsaSltPrc = null;
	
	/* Column Info */
	private String estm2Amt = null;

	/* Column Info */
	private String calAmt = null;
	
	/* Column Info */
	private String changeItem = null;
	
	/* Column Info */
	private String adjRmk = null;
	
	/* Column Info */
	private String exeYrmon = null;

	/* Column Info */
	private String estmOption = null;
	
	/* Column Info */
	private String creUsrId = null;

	/* Column Info */
	private String upUsrId = null;

	/* Column Info */
	private String jbExeYrmon = null;


	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Column Info */
	private String adjEstm1BsaQty = null;
	
	/* Column Info */
	private String adjEstm1BsaSltPrc = null;
	
	/* Column Info */
	private String adjEstm1Amt = null;
	
	/* Column Info */
	private String adjEstm2BsaQty = null;
	
	/* Column Info */
	private String adjEstm2BsaSltPrc = null;
	
	/* Column Info */
	private String adjEstm2Amt = null;

	/* Column Info */
	private String adjCalAmt = null;

	/* Column Info */
	private String adjChangeItem = null;
	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EstmPerformanceChangeStatusRsltVO() {}

	public EstmPerformanceChangeStatusRsltVO(String jbExeYrmon, String ibflag, String revYrmon, String joCrrCd, String vvd, String rlaneCd, String joStlJbCd, String acctCd, String estm1BsaQty, String estm1BsaSltPrc, String estm1Amt, String estm2BsaQty, String estm2BsaSltPrc, String estm2Amt, String calAmt, String changeItem, String adjRmk, String exeYrmon, String estmOption, String creUsrId, String upUsrId, String adjEstm1BsaQty, String adjEstm1BsaSltPrc, String adjEstm1Amt, String adjEstm2BsaQty, String adjEstm2BsaSltPrc, String adjEstm2Amt, String adjChangeItem, String adjCalAmt) {
		this.revYrmon = revYrmon;
		this.joCrrCd = joCrrCd;
		this.vvd = vvd;
		this.rlaneCd = rlaneCd;
		this.joStlJbCd = joStlJbCd;
		this.acctCd = acctCd;
		
		this.estm1BsaQty = estm1BsaQty;
		this.estm1BsaSltPrc = estm1BsaSltPrc;
		this.estm1Amt = estm1Amt;
		
		this.estm2BsaQty = estm2BsaQty;
		this.estm2BsaSltPrc = estm2BsaSltPrc;
		this.estm2Amt = estm2Amt;
		
		this.calAmt = calAmt;
		this.changeItem = changeItem;
		this.adjRmk = adjRmk;

		this.exeYrmon = exeYrmon;
		this.estmOption = estmOption;
		
		this.creUsrId = creUsrId;
		this.upUsrId = upUsrId;

		this.ibflag = ibflag;
		
		this.jbExeYrmon = jbExeYrmon;
		
		this.adjEstm1BsaQty = adjEstm1BsaQty;
		this.adjEstm1BsaSltPrc = adjEstm1BsaSltPrc;
		this.adjEstm1Amt = adjEstm1Amt;
		
		this.adjEstm2BsaQty = adjEstm2BsaQty;
		this.adjEstm2BsaSltPrc = adjEstm2BsaSltPrc;
		this.adjEstm2Amt = adjEstm2Amt;

		this.adjCalAmt = adjCalAmt;
		this.adjChangeItem = adjChangeItem;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("jo_stl_jb_cd", getJoStlJbCd());
		this.hashColumns.put("acct_cd", getAcctCd());

		this.hashColumns.put("estm1_bsa_qty", getEstm1BsaQty());
		this.hashColumns.put("estm1_bsa_slt_prc", getEstm1BsaSltPrc());
		this.hashColumns.put("estm1_amt", getEstm1Amt());
		
		this.hashColumns.put("estm2_bsa_qty", getEstm2BsaQty());
		this.hashColumns.put("estm2_bsa_slt_prc", getEstm2BsaSltPrc());
		this.hashColumns.put("estm2_amt", getEstm2Amt());
		
		this.hashColumns.put("cal_amt", getCalAmt());
		this.hashColumns.put("change_item", getChangeItem());
		this.hashColumns.put("adj_rmk", getAdjRmk());

		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("estm_option", getEstmOption());
		
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("up_usr_id", getUpUsrId());

		this.hashColumns.put("ibflag", getIbflag());
		
		this.hashColumns.put("jb_exe_yrmon", getJbExeYrmon());
		
		this.hashColumns.put("adj_estm1_bsa_qty", getAdjEstm1BsaQty());
		this.hashColumns.put("adj_estm1_bsa_slt_prc", getAdjEstm1BsaSltPrc());
		this.hashColumns.put("adj_estm1_amt", getAdjEstm1Amt());
		
		this.hashColumns.put("adj_estm2_bsa_qty", getAdjEstm2BsaQty());
		this.hashColumns.put("adj_estm2_bsa_slt_prc", getAdjEstm2BsaSltPrc());
		this.hashColumns.put("adj_estm2_amt", getAdjEstm2Amt());

		this.hashColumns.put("adj_cal_amt", getAdjCalAmt());
		this.hashColumns.put("adj_change_item", getAdjChangeItem());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("jo_stl_jb_cd", "joStlJbCd");
		this.hashFields.put("acct_cd", "acctCd");
		
		this.hashFields.put("estm1_bsa_qty", "estm1BsaQty");
		this.hashFields.put("estm1_bsa_slt_prc", "estm1BsaSltPrc");
		this.hashFields.put("estm1_amt", "estm1Amt");
		
		this.hashFields.put("estm2_bsa_qty", "estm2BsaQty");
		this.hashFields.put("estm2_bsa_slt_prc", "estm2BsaSltPrc");
		this.hashFields.put("estm2_amt", "estm2Amt");
		
		this.hashFields.put("cal_amt", "calAmt");
		this.hashFields.put("change_item", "changeItem");
		this.hashFields.put("adj_rmk", "adjRmk");
		
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("estm_option", "estmOption");

		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("up_usr_id", "UpUsrId");

		this.hashFields.put("ibflag", "ibflag");

		this.hashFields.put("jb_exe_yrmon", "jbExeYrmon");

		this.hashFields.put("adj_estm1_bsa_qty", "adjEstm1BsaQty");
		this.hashFields.put("adj_estm1_bsa_slt_prc", "adjEstm1BsaSltPrc");
		this.hashFields.put("adj_estm1_amt", "adjEstm1Amt");
		
		this.hashFields.put("adj_estm2_bsa_qty", "adjEstm2BsaQty");
		this.hashFields.put("adj_estm2_bsa_slt_prc", "adjEstm2BsaSltPrc");
		this.hashFields.put("adj_estm2_amt", "adjEstm2Amt");

		this.hashFields.put("adj_cal_amt", "adjCalAmt");
		this.hashFields.put("adj_change_item", "adjChangeItem");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}

	/**
	 * Column Info
	 * @return rleanCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}

	/**
	 * Column Info
	 * @return joStlJbCd
	 */
	public String getJoStlJbCd() {
		return this.joStlJbCd;
	}

	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}

	/**
	 * Column Info
	 * @return estm1BsaQty
	 */
	public String getEstm1BsaQty() {
		return this.estm1BsaQty;
	}

	/**
	 * Column Info
	 * @return estm1bsaSltPrc
	 */
	public String getEstm1BsaSltPrc() {
		return this.estm1BsaSltPrc;
	}

	/**
	 * Column Info
	 * @return estm1Amt
	 */
	public String getEstm1Amt() {
		return this.estm1Amt;
	}

	/**
	 * Column Info
	 * @return estm2BsaQty
	 */
	public String getEstm2BsaQty() {
		return this.estm2BsaQty;
	}

	/**
	 * Column Info
	 * @return estm2BsaSltPrc
	 */
	public String getEstm2BsaSltPrc() {
		return this.estm2BsaSltPrc;
	}

	/**
	 * Column Info
	 * @return estm2EstmAmt
	 */
	public String getEstm2Amt() {
		return this.estm2Amt;
	}

	/**
	 * Column Info
	 * @return calAmt
	 */
	public String getCalAmt() {
		return this.calAmt;
	}

	/**
	 * Column Info
	 * @return changeItem
	 */
	public String getChangeItem() {
		return this.changeItem;
	}

	/**
	 * Column Info
	 * @return adjRmk
	 */
	public String getAdjRmk() {
		return this.adjRmk;
	}

	/**
	 * Column Info
	 * @return exeYrmon 
	 */
	public String getExeYrmon() {
		return this.exeYrmon;
	}

	/**
	 * Column Info
	 * @return estmOption 
	 */
	public String getEstmOption() {
		return this.estmOption ;
	}
	
	/**
	 * Column Info
	 * @return creUsrId 
	 */
	public String getCreUsrId() {
		return this.creUsrId ;
	}

	/**
	 * Column Info
	 * @return upUsrId 
	 */
	public String getUpUsrId() {
		return this.upUsrId;
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
	 * @return jbExeYrmon
	 */
	public String getJbExeYrmon() {
		return this.jbExeYrmon;
	}
	
	/**
	 * Column Info
	 * @return adjEstm1BsaQty
	 */
	public String getAdjEstm1BsaQty() {
		return this.adjEstm1BsaQty;
	}

	/**
	 * Column Info
	 * @return adjEstm1bsaSltPrc
	 */
	public String getAdjEstm1BsaSltPrc() {
		return this.adjEstm1BsaSltPrc;
	}

	/**
	 * Column Info
	 * @return adjEstm1Amt
	 */
	public String getAdjEstm1Amt() {
		return this.adjEstm1Amt;
	}

	/**
	 * Column Info
	 * @return adjEstm2BsaQty
	 */
	public String getAdjEstm2BsaQty() {
		return this.adjEstm2BsaQty;
	}

	/**
	 * Column Info
	 * @return adjEstm2BsaSltPrc
	 */
	public String getAdjEstm2BsaSltPrc() {
		return this.adjEstm2BsaSltPrc;
	}

	/**
	 * Column Info
	 * @return adjEstm2EstmAmt
	 */
	public String getAdjEstm2Amt() {
		return this.adjEstm2Amt;
	}

	/**
	 * Column Info
	 * @return adjCalAmt
	 */
	public String getAdjCalAmt() {
		return this.adjCalAmt;
	}

	/**
	 * Column Info
	 * @return adjChangeItem
	 */
	public String getAdjChangeItem() {
		return this.adjChangeItem;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon){
		this.revYrmon = revYrmon;
	}

	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd){
		this.joCrrCd = joCrrCd;
	}

	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd){
		this.vvd = vvd;
	}

	/**
	 * Column Info
	 * @param rleanCd
	 */
	public void setRlaneCd(String rlaneCd){
		this.rlaneCd = rlaneCd;
	}

	/**
	 * Column Info
	 * @param joStlJbCd
	 */
	public void setJoStlJbCd(String joStlJbCd){
		this.joStlJbCd = joStlJbCd;
	}

	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd){
		this.acctCd = acctCd;
	}

	/**
	 * Column Info
	 * @param estm1BsaQty
	 */
	public void setEstm1BsaQty(String estm1BsaQty){
		this.estm1BsaQty = estm1BsaQty;
	}

	/**
	 * Column Info
	 * @param estm1BsaSltPrc
	 */
	public void setEstm1BsaSltPrc(String estm1BsaSltPrc){
		this.estm1BsaSltPrc = estm1BsaSltPrc;
	}

	/**
	 * Column Info
	 * @param estm1Amt
	 */
	public void setEstm1Amt(String estm1Amt){
		this.estm1Amt = estm1Amt;
	}

	/**
	 * Column Info
	 * @param estm2BsaQty
	 */
	public void setEstm2BsaQty(String estm2BsaQty){
		this.estm2BsaQty = estm2BsaQty;
	}

	/**
	 * Column Info
	 * @param estm2BsaSltPrc
	 */
	public void setEstm2BsaSltPrc(String estm2BsaSltPrc){
		this.estm2BsaSltPrc = estm2BsaSltPrc;
	}

	/**
	 * Column Info
	 * @param estm2Amt
	 */
	public void setEstm2Amt(String estm2Amt){
		this.estm2Amt = estm2Amt;
	}

	/**
	 * Column Info
	 * @param calAmt
	 */
	public void setCalAmt(String calAmt){
		this.calAmt = calAmt;
	}

	/**
	 * Column Info
	 * @param changItem
	 */
	public void setChangeItem(String changeItem){
		this.changeItem = changeItem;
	}

	/**
	 * Column Info
	 * @param adjRmk
	 */
	public void setAdjRmk(String adjRmk){
		this.adjRmk = adjRmk;
	}

	/**
	 * Column Info
	 * @param exeYrmon
	 */
	public void setExeYrmon(String exeYrmon){
		this.exeYrmon = exeYrmon;
	}

	/**
	 * Column Info
	 * @param estmOption 
	 */
	public void setEstmOption(String estmOption){
		this.estmOption = estmOption;
	}

	
	/**
	 * Column Info
	 * @param creUsrId 
	 */
	public void setCreUsrId(String creUsrId){
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param upUsrId 
	 */
	public void setUpUsrId(String upUsrId){
		this.upUsrId = upUsrId;
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
	 * @param jbExeYrmon 
	 */
	public void setJbExeYrmon(String jbExeYrmon){
		this.jbExeYrmon = jbExeYrmon;
	}

	/**
	 * Column Info
	 * @param adjEstm1BsaQty
	 */
	public void setAdjEstm1BsaQty(String adjEstm1BsaQty){
		this.adjEstm1BsaQty = adjEstm1BsaQty;
	}

	/**
	 * Column Info
	 * @param adjEstm1BsaSltPrc
	 */
	public void setAdjEstm1BsaSltPrc(String adjEstm1BsaSltPrc){
		this.adjEstm1BsaSltPrc = adjEstm1BsaSltPrc;
	}

	/**
	 * Column Info
	 * @param adjEstm1Amt
	 */
	public void setAdjEstm1Amt(String adjEstm1Amt){
		this.adjEstm1Amt = adjEstm1Amt;
	}

	/**
	 * Column Info
	 * @param adjEstm2BsaQty
	 */
	public void setAdjEstm2BsaQty(String adjEstm2BsaQty){
		this.adjEstm2BsaQty = adjEstm2BsaQty;
	}

	/**
	 * Column Info
	 * @param adjEstm2BsaSltPrc
	 */
	public void setAdjEstm2BsaSltPrc(String adjEstm2BsaSltPrc){
		this.adjEstm2BsaSltPrc = adjEstm2BsaSltPrc;
	}

	/**
	 * Column Info
	 * @param adjEstm2Amt
	 */
	public void setAdjEstm2Amt(String adjEstm2Amt){
		this.adjEstm2Amt = adjEstm2Amt;
	}

	/**
	 * Column Info
	 * @param adjCalAmt
	 */
	public void setAdjCalAmt(String adjCalAmt){
		this.adjCalAmt = adjCalAmt;
	}
	
	/**
	 * Column Info
	 * @param adjChangItem
	 */
	public void setAdjChangeItem(String adjChangeItem){
		this.adjChangeItem = adjChangeItem;
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
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_Cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setJoStlJbCd(JSPUtil.getParameter(request, prefix + "jo_stl_jb_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		
		setEstm1BsaQty(JSPUtil.getParameter(request, prefix + "estm1_bsa_qty", ""));
		setEstm1BsaSltPrc(JSPUtil.getParameter(request, prefix + "estm1_bsa_slt_prc", ""));
		setEstm1Amt(JSPUtil.getParameter(request, prefix + "estm1_amt", ""));
		
		setEstm2BsaQty(JSPUtil.getParameter(request, prefix + "estm2_bsa_qty", ""));
		setEstm2BsaSltPrc(JSPUtil.getParameter(request, prefix + "estm2_bsa_slt_prc", ""));
		setEstm2Amt(JSPUtil.getParameter(request, prefix + "estm2_amt", ""));
		
		setCalAmt(JSPUtil.getParameter(request, prefix + "cal_amt", ""));
		setChangeItem(JSPUtil.getParameter(request, prefix + "change_item", ""));
		setAdjRmk(JSPUtil.getParameter(request, prefix + "adj_rmk", ""));

		setExeYrmon (JSPUtil.getParameter(request, prefix + "exe_yrmon", ""));
		setEstmOption(JSPUtil.getParameter(request, prefix + "estm_option", ""));

		setCreUsrId (JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setUpUsrId(JSPUtil.getParameter(request, prefix + "up_usr_id", ""));

		setJbExeYrmon(JSPUtil.getParameter(request, prefix + "jb_exe_yrmon", ""));
		
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));

		setAdjEstm1BsaQty(JSPUtil.getParameter(request, prefix + "adj_estm1_bsa_qty", ""));
		setAdjEstm1BsaSltPrc(JSPUtil.getParameter(request, prefix + "adj_estm1_bsa_slt_prc", ""));
		setAdjEstm1Amt(JSPUtil.getParameter(request, prefix + "adj_estm1_amt", ""));
		
		setAdjEstm2BsaQty(JSPUtil.getParameter(request, prefix + "adj_estm2_bsa_qty", ""));
		setAdjEstm2BsaSltPrc(JSPUtil.getParameter(request, prefix + "adj_estm2_bsa_slt_prc", ""));
		setAdjEstm2Amt(JSPUtil.getParameter(request, prefix + "adj_estm2_amt", ""));

		setAdjCalAmt(JSPUtil.getParameter(request, prefix + "adj_cal_amt", ""));
		setAdjChangeItem(JSPUtil.getParameter(request, prefix + "adj_change_item", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EstmPerformanceChangeStatusRsltVO[]
	 */
	public EstmPerformanceChangeStatusRsltVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EstmPerformanceChangeStatusRsltVO[]
	 */
	public EstmPerformanceChangeStatusRsltVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EstmPerformanceChangeStatusRsltVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] joStlJbCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_jb_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			
			String[] estm1BsaQty = (JSPUtil.getParameter(request, prefix	+ "estm1_bsa_qty", length));
			String[] estm1BsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "estm1_bsa_slt_prc", length));
			String[] estm1Amt = (JSPUtil.getParameter(request, prefix	+ "estm1_amt", length));
			
			String[] estm2BsaQty = (JSPUtil.getParameter(request, prefix	+ "estm2_bsa_qty", length));
			String[] estm2BsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "estm2_bsa_slt_prc", length));
			String[] estm2Amt = (JSPUtil.getParameter(request, prefix	+ "estm2_amt", length));
			
			String[] calAmt = (JSPUtil.getParameter(request, prefix	+ "cal_amt", length));
			String[] changeItem = (JSPUtil.getParameter(request, prefix	+ "change_item", length));
			String[] adjRmk = (JSPUtil.getParameter(request, prefix	+ "adj_rmk", length));

			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] estmOption = (JSPUtil.getParameter(request, prefix	+ "estm_option", length));

			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] upUsrId = (JSPUtil.getParameter(request, prefix	+ "up_usr_id", length));

			String[] jbExeYrmon = (JSPUtil.getParameter(request, prefix	+ "jb_exe_yrmon", length));
			
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));

			String[] adjEstm1BsaQty = (JSPUtil.getParameter(request, prefix	+ "adj_estm1_bsa_qty", length));
			String[] adjEstm1BsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "adj_estm1_bsa_slt_prc", length));
			String[] adjEstm1Amt = (JSPUtil.getParameter(request, prefix	+ "adj_estm1_amt", length));
			
			String[] adjEstm2BsaQty = (JSPUtil.getParameter(request, prefix	+ "adj_estm2_bsa_qty", length));
			String[] adjEstm2BsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "adj_estm2_bsa_slt_prc", length));
			String[] adjEstm2Amt = (JSPUtil.getParameter(request, prefix	+ "adj_estm2_amt", length));
			
			String[] adjCalAmt = (JSPUtil.getParameter(request, prefix	+ "adj_cal_amt", length));
			String[] adjChangeItem = (JSPUtil.getParameter(request, prefix	+ "adj_change_item", length));
			
			for (int i = 0; i < length; i++) {
				model = new EstmPerformanceChangeStatusRsltVO();
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (joStlJbCd[i] != null)
					model.setJoStlJbCd(joStlJbCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				
				if (estm1BsaQty[i] != null)
					model.setEstm1BsaQty(estm1BsaQty[i]);
				if (estm1BsaSltPrc[i] != null)
					model.setEstm1BsaSltPrc(estm1BsaSltPrc[i]);
				if (estm1Amt[i] != null)
					model.setEstm1Amt(estm1Amt[i]);
				
				if (estm2BsaQty[i] != null)
					model.setEstm2BsaQty(estm2BsaQty[i]);
				if (estm2BsaSltPrc[i] != null)
					model.setEstm2BsaSltPrc(estm2BsaSltPrc[i]);
				if (estm2Amt[i] != null)
					model.setEstm2Amt(estm2Amt[i]);
				
				if (calAmt[i] != null)
					model.setCalAmt(calAmt[i]);
				if (changeItem[i] != null)
					model.setChangeItem(changeItem[i]);
				if (adjRmk[i] != null)
					model.setAdjRmk(adjRmk[i]);
				
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (estmOption[i] != null)
					model.setEstmOption(estmOption[i]);

				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (upUsrId[i] != null)
					model.setUpUsrId(upUsrId[i]);
				
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);

				if (jbExeYrmon[i] != null)
					model.setJbExeYrmon(jbExeYrmon[i]);

				if (adjEstm1BsaQty[i] != null)
					model.setAdjEstm1BsaQty(adjEstm1BsaQty[i]);
				if (adjEstm1BsaSltPrc[i] != null)
					model.setAdjEstm1BsaSltPrc(adjEstm1BsaSltPrc[i]);
				if (adjEstm1Amt[i] != null)
					model.setAdjEstm1Amt(adjEstm1Amt[i]);
				
				if (adjEstm2BsaQty[i] != null)
					model.setAdjEstm2BsaQty(adjEstm2BsaQty[i]);
				if (adjEstm2BsaSltPrc[i] != null)
					model.setAdjEstm2BsaSltPrc(adjEstm2BsaSltPrc[i]);
				if (adjEstm2Amt[i] != null)
					model.setAdjEstm2Amt(adjEstm2Amt[i]);
				
				if (adjCalAmt[i] != null)
					model.setAdjCalAmt(adjCalAmt[i]);
				if (adjChangeItem[i] != null)
					model.setAdjChangeItem(adjChangeItem[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEstmPerformanceChangeStatusRsltVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EstmPerformanceChangeStatusRsltVO[]
	 */
	public EstmPerformanceChangeStatusRsltVO[] getEstmPerformanceChangeStatusRsltVOs(){
		EstmPerformanceChangeStatusRsltVO[] vos = (EstmPerformanceChangeStatusRsltVO[])models.toArray(new EstmPerformanceChangeStatusRsltVO[models.size()]);
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
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlJbCd = this.joStlJbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.estm1BsaQty = this.estm1BsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estm1BsaSltPrc = this.estm1BsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estm1Amt = this.estm1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.estm2BsaQty = this.estm2BsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estm2BsaSltPrc = this.estm2BsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estm2Amt = this.estm2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.calAmt = this.calAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.changeItem = this.changeItem .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjRmk = this.adjRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmOption = this.estmOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upUsrId = this.upUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.jbExeYrmon = this.jbExeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.adjEstm1BsaQty = this.adjEstm1BsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjEstm1BsaSltPrc = this.adjEstm1BsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjEstm1Amt = this.adjEstm1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.adjEstm2BsaQty = this.adjEstm2BsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjEstm2BsaSltPrc = this.adjEstm2BsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjEstm2Amt = this.adjEstm2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.adjCalAmt = this.adjCalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjChangeItem = this.adjChangeItem .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
