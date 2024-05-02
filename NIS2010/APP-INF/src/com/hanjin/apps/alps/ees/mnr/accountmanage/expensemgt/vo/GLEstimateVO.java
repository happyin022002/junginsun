/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GLEstimateVO.java
*@FileTitle : GLEstimateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.11.23 권영법 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.vo;

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
 * @author 권영법
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GLEstimateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GLEstimateVO> models = new ArrayList<GLEstimateVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String actuAmt = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String exeYrmon = null;
	/* Column Info */
	private String estmAmt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String estmVvdTpCd = null;
	/* Column Info */
	private String revDirCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String estmBcDivCd = null;
	/* Column Info */
	private String mnrInpDt = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String bizUtId = null;
	/* Column Info */
	private String acclAmt = null;
	/* Column Info */
	private String estmIocDivCd = null;
	/* Column Info */
	private String sysSrcId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GLEstimateVO() {}

	public GLEstimateVO(String ibflag, String pagerows, String vslCd, String actuAmt, String revYrmon, String exeYrmon, String estmAmt, String skdVoyNo, String skdDirCd, String estmVvdTpCd, String revDirCd, String locCd, String estmBcDivCd, String cntrTpszCd, String acctCd, String bizUtId, String cntrQty, String acclAmt, String sysSrcId, String estmIocDivCd, String woNo, String mnrInpDt) {
		this.vslCd = vslCd;
		this.actuAmt = actuAmt;
		this.revYrmon = revYrmon;
		this.exeYrmon = exeYrmon;
		this.estmAmt = estmAmt;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.estmVvdTpCd = estmVvdTpCd;
		this.revDirCd = revDirCd;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.estmBcDivCd = estmBcDivCd;
		this.mnrInpDt = mnrInpDt;
		this.acctCd = acctCd;
		this.cntrTpszCd = cntrTpszCd;
		this.woNo = woNo;
		this.cntrQty = cntrQty;
		this.bizUtId = bizUtId;
		this.acclAmt = acclAmt;
		this.estmIocDivCd = estmIocDivCd;
		this.sysSrcId = sysSrcId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("actu_amt", getActuAmt());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("estm_amt", getEstmAmt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("estm_vvd_tp_cd", getEstmVvdTpCd());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("estm_bc_div_cd", getEstmBcDivCd());
		this.hashColumns.put("mnr_inp_dt", getMnrInpDt());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("biz_ut_id", getBizUtId());
		this.hashColumns.put("accl_amt", getAcclAmt());
		this.hashColumns.put("estm_ioc_div_cd", getEstmIocDivCd());
		this.hashColumns.put("sys_src_id", getSysSrcId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("actu_amt", "actuAmt");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("estm_amt", "estmAmt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("estm_vvd_tp_cd", "estmVvdTpCd");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("estm_bc_div_cd", "estmBcDivCd");
		this.hashFields.put("mnr_inp_dt", "mnrInpDt");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("biz_ut_id", "bizUtId");
		this.hashFields.put("accl_amt", "acclAmt");
		this.hashFields.put("estm_ioc_div_cd", "estmIocDivCd");
		this.hashFields.put("sys_src_id", "sysSrcId");
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
	 * @return actuAmt
	 */
	public String getActuAmt() {
		return this.actuAmt;
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
	 * @return exeYrmon
	 */
	public String getExeYrmon() {
		return this.exeYrmon;
	}
	
	/**
	 * Column Info
	 * @return estmAmt
	 */
	public String getEstmAmt() {
		return this.estmAmt;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return estmVvdTpCd
	 */
	public String getEstmVvdTpCd() {
		return this.estmVvdTpCd;
	}
	
	/**
	 * Column Info
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return estmBcDivCd
	 */
	public String getEstmBcDivCd() {
		return this.estmBcDivCd;
	}
	
	/**
	 * Column Info
	 * @return mnrInpDt
	 */
	public String getMnrInpDt() {
		return this.mnrInpDt;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}
	
	/**
	 * Column Info
	 * @return bizUtId
	 */
	public String getBizUtId() {
		return this.bizUtId;
	}
	
	/**
	 * Column Info
	 * @return acclAmt
	 */
	public String getAcclAmt() {
		return this.acclAmt;
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
	 * @return sysSrcId
	 */
	public String getSysSrcId() {
		return this.sysSrcId;
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
	 * @param actuAmt
	 */
	public void setActuAmt(String actuAmt) {
		this.actuAmt = actuAmt;
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
	 * @param exeYrmon
	 */
	public void setExeYrmon(String exeYrmon) {
		this.exeYrmon = exeYrmon;
	}
	
	/**
	 * Column Info
	 * @param estmAmt
	 */
	public void setEstmAmt(String estmAmt) {
		this.estmAmt = estmAmt;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param estmVvdTpCd
	 */
	public void setEstmVvdTpCd(String estmVvdTpCd) {
		this.estmVvdTpCd = estmVvdTpCd;
	}
	
	/**
	 * Column Info
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param estmBcDivCd
	 */
	public void setEstmBcDivCd(String estmBcDivCd) {
		this.estmBcDivCd = estmBcDivCd;
	}
	
	/**
	 * Column Info
	 * @param mnrInpDt
	 */
	public void setMnrInpDt(String mnrInpDt) {
		this.mnrInpDt = mnrInpDt;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}
	
	/**
	 * Column Info
	 * @param bizUtId
	 */
	public void setBizUtId(String bizUtId) {
		this.bizUtId = bizUtId;
	}
	
	/**
	 * Column Info
	 * @param acclAmt
	 */
	public void setAcclAmt(String acclAmt) {
		this.acclAmt = acclAmt;
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
	 * @param sysSrcId
	 */
	public void setSysSrcId(String sysSrcId) {
		this.sysSrcId = sysSrcId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setActuAmt(JSPUtil.getParameter(request, "actu_amt", ""));
		setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
		setExeYrmon(JSPUtil.getParameter(request, "exe_yrmon", ""));
		setEstmAmt(JSPUtil.getParameter(request, "estm_amt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEstmVvdTpCd(JSPUtil.getParameter(request, "estm_vvd_tp_cd", ""));
		setRevDirCd(JSPUtil.getParameter(request, "rev_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setEstmBcDivCd(JSPUtil.getParameter(request, "estm_bc_div_cd", ""));
		setMnrInpDt(JSPUtil.getParameter(request, "mnr_inp_dt", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setWoNo(JSPUtil.getParameter(request, "wo_no", ""));
		setCntrQty(JSPUtil.getParameter(request, "cntr_qty", ""));
		setBizUtId(JSPUtil.getParameter(request, "biz_ut_id", ""));
		setAcclAmt(JSPUtil.getParameter(request, "accl_amt", ""));
		setEstmIocDivCd(JSPUtil.getParameter(request, "estm_ioc_div_cd", ""));
		setSysSrcId(JSPUtil.getParameter(request, "sys_src_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GLEstimateVO[]
	 */
	public GLEstimateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GLEstimateVO[]
	 */
	public GLEstimateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GLEstimateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] actuAmt = (JSPUtil.getParameter(request, prefix	+ "actu_amt", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] estmAmt = (JSPUtil.getParameter(request, prefix	+ "estm_amt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] estmVvdTpCd = (JSPUtil.getParameter(request, prefix	+ "estm_vvd_tp_cd", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] estmBcDivCd = (JSPUtil.getParameter(request, prefix	+ "estm_bc_div_cd", length));
			String[] mnrInpDt = (JSPUtil.getParameter(request, prefix	+ "mnr_inp_dt", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] bizUtId = (JSPUtil.getParameter(request, prefix	+ "biz_ut_id", length));
			String[] acclAmt = (JSPUtil.getParameter(request, prefix	+ "accl_amt", length));
			String[] estmIocDivCd = (JSPUtil.getParameter(request, prefix	+ "estm_ioc_div_cd", length));
			String[] sysSrcId = (JSPUtil.getParameter(request, prefix	+ "sys_src_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new GLEstimateVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (actuAmt[i] != null)
					model.setActuAmt(actuAmt[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (estmAmt[i] != null)
					model.setEstmAmt(estmAmt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (estmVvdTpCd[i] != null)
					model.setEstmVvdTpCd(estmVvdTpCd[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (estmBcDivCd[i] != null)
					model.setEstmBcDivCd(estmBcDivCd[i]);
				if (mnrInpDt[i] != null)
					model.setMnrInpDt(mnrInpDt[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (bizUtId[i] != null)
					model.setBizUtId(bizUtId[i]);
				if (acclAmt[i] != null)
					model.setAcclAmt(acclAmt[i]);
				if (estmIocDivCd[i] != null)
					model.setEstmIocDivCd(estmIocDivCd[i]);
				if (sysSrcId[i] != null)
					model.setSysSrcId(sysSrcId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGLEstimateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GLEstimateVO[]
	 */
	public GLEstimateVO[] getGLEstimateVOs(){
		GLEstimateVO[] vos = (GLEstimateVO[])models.toArray(new GLEstimateVO[models.size()]);
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
		this.actuAmt = this.actuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmAmt = this.estmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmVvdTpCd = this.estmVvdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmBcDivCd = this.estmBcDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInpDt = this.mnrInpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizUtId = this.bizUtId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclAmt = this.acclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmIocDivCd = this.estmIocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysSrcId = this.sysSrcId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
