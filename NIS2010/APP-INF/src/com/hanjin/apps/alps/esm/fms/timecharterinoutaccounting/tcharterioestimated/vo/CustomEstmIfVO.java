/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomEstmIfVO.java
*@FileTitle : CustomEstmIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.21
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2011.12.21 김영오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo;

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
 * 
 * 
 * 
 */

public class CustomEstmIfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomEstmIfVO> models = new ArrayList<CustomEstmIfVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String hireAmt = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String fletCtrtTpCd = null;
	/* Column Info */
	private String exeYrmon = null;
	/* Column Info */
	private String estAmt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String actAmt = null;
	/* Column Info */
	private String slpOfcCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String estmVvdTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vstDt = null;
	/* Column Info */
	private String revDirCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String days = null;
	/* Column Info */
	private String estmSeqNo = null;
	/* Column Info */
	private String accAmt = null;
	/* Column Info */
	private String accOldAmt = null;
	/* Column Info */
	private String vedDt = null;
	/* Column Info */
	private String estmIocDivCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/* Column Info : add 2012.07.23. AcclAmt의 이전 수정값을 저장 */
	private String fletAcclAmt = null;
	

	public CustomEstmIfVO() {}

	public CustomEstmIfVO(String ibflag, String pagerows, String vslCd, String hireAmt, String revYrmon, String fletCtrtTpCd, String exeYrmon, String estAmt, String skdVoyNo, String actAmt, String slpOfcCd, String skdDirCd, String revDirCd, String vstDt, String creUsrId, String days, String vvdCd, String accAmt, String estmSeqNo, String estmIocDivCd, String vedDt, String accOldAmt, String estmVvdTpCd, String fletAcclAmt) {
		this.vslCd = vslCd;
		this.hireAmt = hireAmt;
		this.revYrmon = revYrmon;
		this.fletCtrtTpCd = fletCtrtTpCd;
		this.exeYrmon = exeYrmon;
		this.estAmt = estAmt;
		this.skdVoyNo = skdVoyNo;
		this.actAmt = actAmt;
		this.slpOfcCd = slpOfcCd;
		this.skdDirCd = skdDirCd;
		this.estmVvdTpCd = estmVvdTpCd;
		this.pagerows = pagerows;
		this.vstDt = vstDt;
		this.revDirCd = revDirCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.days = days;
		this.estmSeqNo = estmSeqNo;
		this.accAmt = accAmt;
		this.accOldAmt = accOldAmt;
		this.vedDt = vedDt;
		this.estmIocDivCd = estmIocDivCd;
		this.fletAcclAmt = fletAcclAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("hire_amt", getHireAmt());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("flet_ctrt_tp_cd", getFletCtrtTpCd());
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("est_amt", getEstAmt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("act_amt", getActAmt());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("estm_vvd_tp_cd", getEstmVvdTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vst_dt", getVstDt());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("days", getDays());
		this.hashColumns.put("estm_seq_no", getEstmSeqNo());
		this.hashColumns.put("acc_amt", getAccAmt());
		this.hashColumns.put("acc_old_amt", getAccOldAmt());
		this.hashColumns.put("ved_dt", getVedDt());
		this.hashColumns.put("estm_ioc_div_cd", getEstmIocDivCd());
		this.hashColumns.put("flet_accl_amt", getFletAcclAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("hire_amt", "hireAmt");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("flet_ctrt_tp_cd", "fletCtrtTpCd");
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("est_amt", "estAmt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("act_amt", "actAmt");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("estm_vvd_tp_cd", "estmVvdTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vst_dt", "vstDt");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("days", "days");
		this.hashFields.put("estm_seq_no", "estmSeqNo");
		this.hashFields.put("acc_amt", "accAmt");
		this.hashFields.put("acc_old_amt", "accOldAmt");
		this.hashFields.put("ved_dt", "vedDt");
		this.hashFields.put("estm_ioc_div_cd", "estmIocDivCd");
		this.hashFields.put("flet_accl_amt", "fletAcclAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return hireAmt
	 */
	public String getHireAmt() {
		return this.hireAmt;
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
	 * @return fletCtrtTpCd
	 */
	public String getFletCtrtTpCd() {
		return this.fletCtrtTpCd;
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
	 * @return estAmt
	 */
	public String getEstAmt() {
		return this.estAmt;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return actAmt
	 */
	public String getActAmt() {
		return this.actAmt;
	}
	
	/**
	 * Column Info
	 * @return slpOfcCd
	 */
	public String getSlpOfcCd() {
		return this.slpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return estmVvdTpCd
	 */
	public String getEstmVvdTpCd() {
		return this.estmVvdTpCd;
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
	 * @return vstDt
	 */
	public String getVstDt() {
		return this.vstDt;
	}
	
	/**
	 * Column Info
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return days
	 */
	public String getDays() {
		return this.days;
	}
	
	/**
	 * Column Info
	 * @return estmSeqNo
	 */
	public String getEstmSeqNo() {
		return this.estmSeqNo;
	}
	
	/**
	 * Column Info
	 * @return accAmt
	 */
	public String getAccAmt() {
		return this.accAmt;
	}
	
	/**
	 * Column Info
	 * @return accOldAmt
	 */
	public String getAccOldAmt() {
		return this.accOldAmt;
	}
	
	/**
	 * Column Info
	 * @return vedDt
	 */
	public String getVedDt() {
		return this.vedDt;
	}
	
	/**
	 * Column Info
	 * @return estmIocDivCd
	 */
	public String getEstmIocDivCd() {
		return this.estmIocDivCd;
	}
	


	/**
	 * Column Info
	 * @return fletAcclAmt
	 */
	public String getFletAcclAmt() {
		return fletAcclAmt;
	}

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param hireAmt
	 */
	public void setHireAmt(String hireAmt) {
		this.hireAmt = hireAmt;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param fletCtrtTpCd
	 */
	public void setFletCtrtTpCd(String fletCtrtTpCd) {
		this.fletCtrtTpCd = fletCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param exeYrmon
	 */
	public void setExeYrmon(String exeYrmon) {
		this.exeYrmon = exeYrmon;
	}
	
	/**
	 * Column Info
	 * @param estAmt
	 */
	public void setEstAmt(String estAmt) {
		this.estAmt = estAmt;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param actAmt
	 */
	public void setActAmt(String actAmt) {
		this.actAmt = actAmt;
	}
	
	/**
	 * Column Info
	 * @param slpOfcCd
	 */
	public void setSlpOfcCd(String slpOfcCd) {
		this.slpOfcCd = slpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param estmVvdTpCd
	 */
	public void setEstmVvdTpCd(String estmVvdTpCd) {
		this.estmVvdTpCd = estmVvdTpCd;
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
	 * @param vstDt
	 */
	public void setVstDt(String vstDt) {
		this.vstDt = vstDt;
	}
	
	/**
	 * Column Info
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param days
	 */
	public void setDays(String days) {
		this.days = days;
	}
	
	/**
	 * Column Info
	 * @param estmSeqNo
	 */
	public void setEstmSeqNo(String estmSeqNo) {
		this.estmSeqNo = estmSeqNo;
	}
	
	/**
	 * Column Info
	 * @param accAmt
	 */
	public void setAccAmt(String accAmt) {
		this.accAmt = accAmt;
	}
	
	/**
	 * Column Info
	 * @param accOldAmt
	 */
	public void setAccOldAmt(String accOldAmt) {
		this.accOldAmt = accOldAmt;
	}
	
	/**
	 * Column Info
	 * @param vedDt
	 */
	public void setVedDt(String vedDt) {
		this.vedDt = vedDt;
	}
	
	/**
	 * Column Info
	 * @param estmIocDivCd
	 */
	public void setEstmIocDivCd(String estmIocDivCd) {
		this.estmIocDivCd = estmIocDivCd;
	}
	
	
	
	/**
	 * Column Info
	 * @return fletAcclAmt
	 */
	public void setFletAcclAmt(String fletAcclAmt) {
		this.fletAcclAmt = fletAcclAmt;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setHireAmt(JSPUtil.getParameter(request, prefix + "hire_amt", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setFletCtrtTpCd(JSPUtil.getParameter(request, prefix + "flet_ctrt_tp_cd", ""));
		setExeYrmon(JSPUtil.getParameter(request, prefix + "exe_yrmon", ""));
		setEstAmt(JSPUtil.getParameter(request, prefix + "est_amt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setActAmt(JSPUtil.getParameter(request, prefix + "act_amt", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, prefix + "slp_ofc_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setEstmVvdTpCd(JSPUtil.getParameter(request, prefix + "estm_vvd_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVstDt(JSPUtil.getParameter(request, prefix + "vst_dt", ""));
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setDays(JSPUtil.getParameter(request, prefix + "days", ""));
		setEstmSeqNo(JSPUtil.getParameter(request, prefix + "estm_seq_no", ""));
		setAccAmt(JSPUtil.getParameter(request, prefix + "acc_amt", ""));
		setAccOldAmt(JSPUtil.getParameter(request, prefix + "acc_old_amt", ""));
		setVedDt(JSPUtil.getParameter(request, prefix + "ved_dt", ""));
		setEstmIocDivCd(JSPUtil.getParameter(request, prefix + "estm_ioc_div_cd", ""));
		
		setFletAcclAmt(JSPUtil.getParameter(request, prefix + "flet_accl_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomEstmIfVO[]
	 */
	public CustomEstmIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomEstmIfVO[]
	 */
	public CustomEstmIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomEstmIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] hireAmt = (JSPUtil.getParameter(request, prefix	+ "hire_amt", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] fletCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_tp_cd", length));
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] estAmt = (JSPUtil.getParameter(request, prefix	+ "est_amt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] actAmt = (JSPUtil.getParameter(request, prefix	+ "act_amt", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] estmVvdTpCd = (JSPUtil.getParameter(request, prefix	+ "estm_vvd_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vstDt = (JSPUtil.getParameter(request, prefix	+ "vst_dt", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] days = (JSPUtil.getParameter(request, prefix	+ "days", length));
			String[] estmSeqNo = (JSPUtil.getParameter(request, prefix	+ "estm_seq_no", length));
			String[] accAmt = (JSPUtil.getParameter(request, prefix	+ "acc_amt", length));
			String[] accOldAmt = (JSPUtil.getParameter(request, prefix	+ "acc_old_amt", length));
			String[] vedDt = (JSPUtil.getParameter(request, prefix	+ "ved_dt", length));
			String[] estmIocDivCd = (JSPUtil.getParameter(request, prefix	+ "estm_ioc_div_cd", length));
			
			String[] fletAcclAmt = (JSPUtil.getParameter(request, prefix	+ "flet_accl_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomEstmIfVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (hireAmt[i] != null)
					model.setHireAmt(hireAmt[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (fletCtrtTpCd[i] != null)
					model.setFletCtrtTpCd(fletCtrtTpCd[i]);
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (estAmt[i] != null)
					model.setEstAmt(estAmt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (actAmt[i] != null)
					model.setActAmt(actAmt[i]);
				if (slpOfcCd[i] != null)
					model.setSlpOfcCd(slpOfcCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (estmVvdTpCd[i] != null)
					model.setEstmVvdTpCd(estmVvdTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vstDt[i] != null)
					model.setVstDt(vstDt[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (days[i] != null)
					model.setDays(days[i]);
				if (estmSeqNo[i] != null)
					model.setEstmSeqNo(estmSeqNo[i]);
				if (accAmt[i] != null)
					model.setAccAmt(accAmt[i]);
				if (accOldAmt[i] != null)
					model.setAccOldAmt(accOldAmt[i]);
				if (vedDt[i] != null)
					model.setVedDt(vedDt[i]);
				if (estmIocDivCd[i] != null)
					model.setEstmIocDivCd(estmIocDivCd[i]);
				if (fletAcclAmt[i] != null)
					model.setFletAcclAmt(fletAcclAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomEstmIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomEstmIfVO[]
	 */
	public CustomEstmIfVO[] getCustomEstmIfVOs(){
		CustomEstmIfVO[] vos = (CustomEstmIfVO[])models.toArray(new CustomEstmIfVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hireAmt = this.hireAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtTpCd = this.fletCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estAmt = this.estAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actAmt = this.actAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmVvdTpCd = this.estmVvdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vstDt = this.vstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.days = this.days .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmSeqNo = this.estmSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accAmt = this.accAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accOldAmt = this.accOldAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vedDt = this.vedDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmIocDivCd = this.estmIocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.fletAcclAmt = this.fletAcclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
