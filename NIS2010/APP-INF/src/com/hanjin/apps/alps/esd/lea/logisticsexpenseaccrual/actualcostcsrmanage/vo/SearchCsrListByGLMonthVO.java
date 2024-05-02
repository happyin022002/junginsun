/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchCsrListByGLMonthVO.java
*@FileTitle : SearchCsrListByGLMonthVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo;

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

public class SearchCsrListByGLMonthVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCsrListByGLMonthVO> models = new ArrayList<SearchCsrListByGLMonthVO>();
	
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String fCsrNo = null;
	/* Column Info */
	private String coaCostSrcCd = null;
	/* Column Info */
	private String exeYrmon = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String invSysId = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String fRhqCd = null;
	/* Column Info */
	private String costDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fCtrlOfcCd = null;
	/* Column Info */
	private String fCoaCostSrcCd = null;
	/* Column Info */
	private String fSysId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usdAmt = null;
	/* Column Info */
	private String xchRtYrmon = null;
	/* Column Info */
	private String fAcbmFlag = null;
	/* Column Info */
	private String costAmt = null;
	/* Column Info */
	private String glMonFrom = null;
	/* Column Info */
	private String invDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchCsrListByGLMonthVO() {}

	public SearchCsrListByGLMonthVO(String ibflag, String pagerows, String exeYrmon, String csrNo, String invSysId, String ctrlOfcCd, String invDt, String coaCostSrcCd, String costDesc, String loclCurrCd, String costAmt, String usdAmt, String xchRtYrmon, String glMonFrom, String fSysId, String fCoaCostSrcCd, String fCsrNo, String fRhqCd, String fCtrlOfcCd, String fAcbmFlag) {
		this.csrNo = csrNo;
		this.fCsrNo = fCsrNo;
		this.coaCostSrcCd = coaCostSrcCd;
		this.exeYrmon = exeYrmon;
		this.loclCurrCd = loclCurrCd;
		this.invSysId = invSysId;
		this.ctrlOfcCd = ctrlOfcCd;
		this.fRhqCd = fRhqCd;
		this.costDesc = costDesc;
		this.pagerows = pagerows;
		this.fCtrlOfcCd = fCtrlOfcCd;
		this.fCoaCostSrcCd = fCoaCostSrcCd;
		this.fSysId = fSysId;
		this.ibflag = ibflag;
		this.usdAmt = usdAmt;
		this.xchRtYrmon = xchRtYrmon;
		this.fAcbmFlag = fAcbmFlag;
		this.costAmt = costAmt;
		this.glMonFrom = glMonFrom;
		this.invDt = invDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("f_csr_no", getFCsrNo());
		this.hashColumns.put("coa_cost_src_cd", getCoaCostSrcCd());
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("inv_sys_id", getInvSysId());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("f_rhq_cd", getFRhqCd());
		this.hashColumns.put("cost_desc", getCostDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_ctrl_ofc_cd", getFCtrlOfcCd());
		this.hashColumns.put("f_coa_cost_src_cd", getFCoaCostSrcCd());
		this.hashColumns.put("f_sys_id", getFSysId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("xch_rt_yrmon", getXchRtYrmon());
		this.hashColumns.put("f_acbm_flag", getFAcbmFlag());
		this.hashColumns.put("cost_amt", getCostAmt());
		this.hashColumns.put("gl_mon_from", getGlMonFrom());
		this.hashColumns.put("inv_dt", getInvDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("f_csr_no", "fCsrNo");
		this.hashFields.put("coa_cost_src_cd", "coaCostSrcCd");
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("inv_sys_id", "invSysId");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("f_rhq_cd", "fRhqCd");
		this.hashFields.put("cost_desc", "costDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_ctrl_ofc_cd", "fCtrlOfcCd");
		this.hashFields.put("f_coa_cost_src_cd", "fCoaCostSrcCd");
		this.hashFields.put("f_sys_id", "fSysId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("xch_rt_yrmon", "xchRtYrmon");
		this.hashFields.put("f_acbm_flag", "fAcbmFlag");
		this.hashFields.put("cost_amt", "costAmt");
		this.hashFields.put("gl_mon_from", "glMonFrom");
		this.hashFields.put("inv_dt", "invDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return fCsrNo
	 */
	public String getFCsrNo() {
		return this.fCsrNo;
	}
	
	/**
	 * Column Info
	 * @return coaCostSrcCd
	 */
	public String getCoaCostSrcCd() {
		return this.coaCostSrcCd;
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
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return invSysId
	 */
	public String getInvSysId() {
		return this.invSysId;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fRhqCd
	 */
	public String getFRhqCd() {
		return this.fRhqCd;
	}
	
	/**
	 * Column Info
	 * @return costDesc
	 */
	public String getCostDesc() {
		return this.costDesc;
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
	 * @return fCtrlOfcCd
	 */
	public String getFCtrlOfcCd() {
		return this.fCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fCoaCostSrcCd
	 */
	public String getFCoaCostSrcCd() {
		return this.fCoaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @return fSysId
	 */
	public String getFSysId() {
		return this.fSysId;
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
	 * @return usdAmt
	 */
	public String getUsdAmt() {
		return this.usdAmt;
	}
	
	/**
	 * Column Info
	 * @return xchRtYrmon
	 */
	public String getXchRtYrmon() {
		return this.xchRtYrmon;
	}
	
	/**
	 * Column Info
	 * @return fAcbmFlag
	 */
	public String getFAcbmFlag() {
		return this.fAcbmFlag;
	}
	
	/**
	 * Column Info
	 * @return costAmt
	 */
	public String getCostAmt() {
		return this.costAmt;
	}
	
	/**
	 * Column Info
	 * @return glMonFrom
	 */
	public String getGlMonFrom() {
		return this.glMonFrom;
	}
	
	/**
	 * Column Info
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
	}
	

	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param fCsrNo
	 */
	public void setFCsrNo(String fCsrNo) {
		this.fCsrNo = fCsrNo;
	}
	
	/**
	 * Column Info
	 * @param coaCostSrcCd
	 */
	public void setCoaCostSrcCd(String coaCostSrcCd) {
		this.coaCostSrcCd = coaCostSrcCd;
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
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param invSysId
	 */
	public void setInvSysId(String invSysId) {
		this.invSysId = invSysId;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fRhqCd
	 */
	public void setFRhqCd(String fRhqCd) {
		this.fRhqCd = fRhqCd;
	}
	
	/**
	 * Column Info
	 * @param costDesc
	 */
	public void setCostDesc(String costDesc) {
		this.costDesc = costDesc;
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
	 * @param fCtrlOfcCd
	 */
	public void setFCtrlOfcCd(String fCtrlOfcCd) {
		this.fCtrlOfcCd = fCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fCoaCostSrcCd
	 */
	public void setFCoaCostSrcCd(String fCoaCostSrcCd) {
		this.fCoaCostSrcCd = fCoaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @param fSysId
	 */
	public void setFSysId(String fSysId) {
		this.fSysId = fSysId;
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
	 * @param usdAmt
	 */
	public void setUsdAmt(String usdAmt) {
		this.usdAmt = usdAmt;
	}
	
	/**
	 * Column Info
	 * @param xchRtYrmon
	 */
	public void setXchRtYrmon(String xchRtYrmon) {
		this.xchRtYrmon = xchRtYrmon;
	}
	
	/**
	 * Column Info
	 * @param fAcbmFlag
	 */
	public void setFAcbmFlag(String fAcbmFlag) {
		this.fAcbmFlag = fAcbmFlag;
	}
	
	/**
	 * Column Info
	 * @param costAmt
	 */
	public void setCostAmt(String costAmt) {
		this.costAmt = costAmt;
	}
	
	/**
	 * Column Info
	 * @param glMonFrom
	 */
	public void setGlMonFrom(String glMonFrom) {
		this.glMonFrom = glMonFrom;
	}
	
	/**
	 * Column Info
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
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
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setFCsrNo(JSPUtil.getParameter(request, prefix + "f_csr_no", ""));
		setCoaCostSrcCd(JSPUtil.getParameter(request, prefix + "coa_cost_src_cd", ""));
		setExeYrmon(JSPUtil.getParameter(request, prefix + "exe_yrmon", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setInvSysId(JSPUtil.getParameter(request, prefix + "inv_sys_id", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd", ""));
		setFRhqCd(JSPUtil.getParameter(request, prefix + "f_rhq_cd", ""));
		setCostDesc(JSPUtil.getParameter(request, prefix + "cost_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFCtrlOfcCd(JSPUtil.getParameter(request, prefix + "f_ctrl_ofc_cd", ""));
		setFCoaCostSrcCd(JSPUtil.getParameter(request, prefix + "f_coa_cost_src_cd", ""));
		setFSysId(JSPUtil.getParameter(request, prefix + "f_sys_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsdAmt(JSPUtil.getParameter(request, prefix + "usd_amt", ""));
		setXchRtYrmon(JSPUtil.getParameter(request, prefix + "xch_rt_yrmon", ""));
		setFAcbmFlag(JSPUtil.getParameter(request, prefix + "f_acbm_flag", ""));
		setCostAmt(JSPUtil.getParameter(request, prefix + "cost_amt", ""));
		setGlMonFrom(JSPUtil.getParameter(request, prefix + "gl_mon_from", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCsrListByGLMonthVO[]
	 */
	public SearchCsrListByGLMonthVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCsrListByGLMonthVO[]
	 */
	public SearchCsrListByGLMonthVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCsrListByGLMonthVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] fCsrNo = (JSPUtil.getParameter(request, prefix	+ "f_csr_no", length));
			String[] coaCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_cd", length));
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] invSysId = (JSPUtil.getParameter(request, prefix	+ "inv_sys_id", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] fRhqCd = (JSPUtil.getParameter(request, prefix	+ "f_rhq_cd", length));
			String[] costDesc = (JSPUtil.getParameter(request, prefix	+ "cost_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_ctrl_ofc_cd", length));
			String[] fCoaCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "f_coa_cost_src_cd", length));
			String[] fSysId = (JSPUtil.getParameter(request, prefix	+ "f_sys_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] xchRtYrmon = (JSPUtil.getParameter(request, prefix	+ "xch_rt_yrmon", length));
			String[] fAcbmFlag = (JSPUtil.getParameter(request, prefix	+ "f_acbm_flag", length));
			String[] costAmt = (JSPUtil.getParameter(request, prefix	+ "cost_amt", length));
			String[] glMonFrom = (JSPUtil.getParameter(request, prefix	+ "gl_mon_from", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCsrListByGLMonthVO();
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (fCsrNo[i] != null)
					model.setFCsrNo(fCsrNo[i]);
				if (coaCostSrcCd[i] != null)
					model.setCoaCostSrcCd(coaCostSrcCd[i]);
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (invSysId[i] != null)
					model.setInvSysId(invSysId[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (fRhqCd[i] != null)
					model.setFRhqCd(fRhqCd[i]);
				if (costDesc[i] != null)
					model.setCostDesc(costDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fCtrlOfcCd[i] != null)
					model.setFCtrlOfcCd(fCtrlOfcCd[i]);
				if (fCoaCostSrcCd[i] != null)
					model.setFCoaCostSrcCd(fCoaCostSrcCd[i]);
				if (fSysId[i] != null)
					model.setFSysId(fSysId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (xchRtYrmon[i] != null)
					model.setXchRtYrmon(xchRtYrmon[i]);
				if (fAcbmFlag[i] != null)
					model.setFAcbmFlag(fAcbmFlag[i]);
				if (costAmt[i] != null)
					model.setCostAmt(costAmt[i]);
				if (glMonFrom[i] != null)
					model.setGlMonFrom(glMonFrom[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCsrListByGLMonthVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCsrListByGLMonthVO[]
	 */
	public SearchCsrListByGLMonthVO[] getSearchCsrListByGLMonthVOs(){
		SearchCsrListByGLMonthVO[] vos = (SearchCsrListByGLMonthVO[])models.toArray(new SearchCsrListByGLMonthVO[models.size()]);
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
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCsrNo = this.fCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaCostSrcCd = this.coaCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSysId = this.invSysId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRhqCd = this.fRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDesc = this.costDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCtrlOfcCd = this.fCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCoaCostSrcCd = this.fCoaCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSysId = this.fSysId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtYrmon = this.xchRtYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAcbmFlag = this.fAcbmFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAmt = this.costAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glMonFrom = this.glMonFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
