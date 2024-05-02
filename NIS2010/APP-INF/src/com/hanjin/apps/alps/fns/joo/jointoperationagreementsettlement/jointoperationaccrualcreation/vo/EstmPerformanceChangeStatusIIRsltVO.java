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
* 2012.02.13 조병연[CHM-201215990-01]
* Title : [ALPS JOO] Estimate Performance Change Status II 신규개발 (2012년 1월 2차)
* 내용 :
* - ALPS JOO 전월 대상항차 Estimate 변동 현황 분석기능 개발		
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

public class EstmPerformanceChangeStatusIIRsltVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EstmPerformanceChangeStatusIIRsltVO> models = new ArrayList<EstmPerformanceChangeStatusIIRsltVO>();

	/* Column Info */
	private String exeYrmon = null;
	
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
	private String creUsrId = null;

	/* Column Info */
	private String upUsrId = null;

	/* Column Info */
	private String changeItem = null;
	
	/* Column Info */
	private String jbExeYrmon = null;
	

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EstmPerformanceChangeStatusIIRsltVO() {}

	public EstmPerformanceChangeStatusIIRsltVO(String exeYrmon, String jbExeYrmon, String ibflag, String revYrmon, String joCrrCd, String vvd, String rlaneCd, String joStlJbCd, String acctCd, String estm1BsaQty, String estm1BsaSltPrc, String estm1Amt, String estm2BsaQty, String estm2BsaSltPrc, String estm2Amt, String calAmt, String changeItem, String creUsrId, String upUsrId) {
		this.exeYrmon = exeYrmon;
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
		this.creUsrId = creUsrId;
		this.upUsrId = upUsrId;

		this.jbExeYrmon = jbExeYrmon;
		
		this.ibflag = ibflag;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("exe_yrmon", getExeYrmon());
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

		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("up_usr_id", getUpUsrId());

		this.hashColumns.put("ibflag", getIbflag());

		this.hashColumns.put("jb_exe_yrmon", getJbExeYrmon());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("exe_yrmon", "exeYrmon");
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
		
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("up_usr_id", "UpUsrId");

		this.hashFields.put("ibflag", "ibflag");

		this.hashFields.put("jb_exe_yrmon", "jbExeYrmon");

		return this.hashFields;
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
	 * @param exeYrmon
	 */
	public void setExeYrmon(String exeYrmon){
		this.exeYrmon = exeYrmon;
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
	 * @param changeItem
	 */
	public void setChangeItem(String changeItem){
		this.changeItem = changeItem;
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
	 * Column Info
	 * @param jbExeYrmon
	 */
	public void setJbExeYrmon(String jbExeYrmon){
		this.jbExeYrmon = jbExeYrmon;
	}

	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
		setExeYrmon(JSPUtil.getParameter(request, prefix + "exe_yrmon", ""));
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
				
		setCreUsrId (JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setUpUsrId(JSPUtil.getParameter(request, prefix + "up_usr_id", ""));

		setJbExeYrmon(JSPUtil.getParameter(request, prefix + "jb_exe_yrmon", ""));
		
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EstmPerformanceChangeStatusRsltVO[]
	 */
	public EstmPerformanceChangeStatusIIRsltVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EstmPerformanceChangeStatusRsltVO[]
	 */
	public EstmPerformanceChangeStatusIIRsltVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EstmPerformanceChangeStatusIIRsltVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
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

			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] upUsrId = (JSPUtil.getParameter(request, prefix	+ "up_usr_id", length));

			String[] jbExeYrmon = (JSPUtil.getParameter(request, prefix	+ "jb_exe_yrmon", length));

			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));

			for (int i = 0; i < length; i++) {
				model = new EstmPerformanceChangeStatusIIRsltVO();
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
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

				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (upUsrId[i] != null)
					model.setUpUsrId(upUsrId[i]);

				if (jbExeYrmon[i] != null)
					model.setJbExeYrmon(jbExeYrmon[i]);
				
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);

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
	public EstmPerformanceChangeStatusIIRsltVO[] getEstmPerformanceChangeStatusRsltVOs(){
		EstmPerformanceChangeStatusIIRsltVO[] vos = (EstmPerformanceChangeStatusIIRsltVO[])models.toArray(new EstmPerformanceChangeStatusIIRsltVO[models.size()]);
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
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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

		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upUsrId = this.upUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.jbExeYrmon = this.jbExeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
