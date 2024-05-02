/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchParamVO.java
*@FileTitle : SearchParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.05  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchParamVO> models = new ArrayList<SearchParamVO>();
	
	/* Column Info */
	private String locTp = null;
	/* Column Info */
	private String cntrFullFlg = null;
	/* Column Info */
	private String lstStsFlg = null;
	/* Column Info */
	private String cntrUseCoCd = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String cntrStsCd = null;
	/* Column Info */
	private String hjsCreFlg = null;
	/* Column Info */
	private String strEvntDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String endEvntDt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String lstmScoTp = null;
	/* Column Info */
	private String totalFlg = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String onhFreeDys = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String ttlFlag = null;
	/* Column Info */
	private String useDay = null;
	
	/* Column Info */
	private int iPage = 1;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchParamVO() {}

	public SearchParamVO(String ibflag, String pagerows, String locTp, String cntrFullFlg, String lstStsFlg, String cntrUseCoCd, String agmtSeq, String cntrStsCd, String strEvntDt, String cntrNo, String locCd, String cnmvStsCd, String endEvntDt, String totalFlg, String lstmScoTp, String vndrSeq, String agmtCtyCd, String cntrTpszCd, String onhFreeDys, String lstmCd, String hjsCreFlg, String ctrtNo, String ttlFlag, String useDay) {
		this.locTp = locTp;
		this.cntrFullFlg = cntrFullFlg;
		this.lstStsFlg = lstStsFlg;
		this.cntrUseCoCd = cntrUseCoCd;
		this.agmtSeq = agmtSeq;
		this.cntrStsCd = cntrStsCd;
		this.hjsCreFlg = hjsCreFlg;
		this.strEvntDt = strEvntDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.cnmvStsCd = cnmvStsCd;
		this.endEvntDt = endEvntDt;
		this.vndrSeq = vndrSeq;
		this.lstmScoTp = lstmScoTp;
		this.totalFlg = totalFlg;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.agmtCtyCd = agmtCtyCd;
		this.lstmCd = lstmCd;
		this.onhFreeDys = onhFreeDys;
		this.ctrtNo = ctrtNo;
		this.ttlFlag = ttlFlag;
		this.useDay = useDay;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("loc_tp", getLocTp());
		this.hashColumns.put("cntr_full_flg", getCntrFullFlg());
		this.hashColumns.put("lst_sts_flg", getLstStsFlg());
		this.hashColumns.put("cntr_use_co_cd", getCntrUseCoCd());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("cntr_sts_cd", getCntrStsCd());
		this.hashColumns.put("hjs_cre_flg", getHjsCreFlg());
		this.hashColumns.put("str_evnt_dt", getStrEvntDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("end_evnt_dt", getEndEvntDt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("lstm_sco_tp", getLstmScoTp());
		this.hashColumns.put("total_flg", getTotalFlg());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("onh_free_dys", getOnhFreeDys());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("ttl_flag", getTtlFlag());
		this.hashColumns.put("use_day", getUseDay());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("loc_tp", "locTp");
		this.hashFields.put("cntr_full_flg", "cntrFullFlg");
		this.hashFields.put("lst_sts_flg", "lstStsFlg");
		this.hashFields.put("cntr_use_co_cd", "cntrUseCoCd");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("cntr_sts_cd", "cntrStsCd");
		this.hashFields.put("hjs_cre_flg", "hjsCreFlg");
		this.hashFields.put("str_evnt_dt", "strEvntDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("end_evnt_dt", "endEvntDt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("lstm_sco_tp", "lstmScoTp");
		this.hashFields.put("total_flg", "totalFlg");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("onh_free_dys", "onhFreeDys");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("ttl_flag", "ttlFlag");
		this.hashFields.put("use_day", "useDay");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return locTp 
	 */
	public String getLocTp() {
		return this.locTp;
	}
	
	/**
	 * Column Info
	 * @return cntrFullFlg
	 */
	public String getCntrFullFlg() {
		return this.cntrFullFlg;
	}
	
	/**
	 * Column Info
	 * @return lstStsFlg
	 */
	public String getLstStsFlg() {
		return this.lstStsFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrUseCoCd
	 */
	public String getCntrUseCoCd() {
		return this.cntrUseCoCd;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrStsCd
	 */
	public String getCntrStsCd() {
		return this.cntrStsCd;
	}
	
	/**
	 * Column Info
	 * @return hjsCreFlg
	 */
	public String getHjsCreFlg() {
		return this.hjsCreFlg;
	}
	
	/**
	 * Column Info
	 * @return strEvntDt
	 */
	public String getStrEvntDt() {
		return this.strEvntDt;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @return endEvntDt
	 */
	public String getEndEvntDt() {
		return this.endEvntDt;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return lstmScoTp
	 */
	public String getLstmScoTp() {
		return this.lstmScoTp;
	}
	
	/**
	 * Column Info
	 * @return totalFlg
	 */
	public String getTotalFlg() {
		return this.totalFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return onhFreeDys
	 */
	public String getOnhFreeDys() {
		return this.onhFreeDys;
	}
	
	/**
	 * Column Info
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
	}
	
	/**
	 * Column Info
	 * @return ttlFlag
	 */
	public String getTtlFlag() {
		return this.ttlFlag;
	}
	
	/**
	 * Column Info
	 * @return useDay
	 */
	public String getUseDay() {
		return this.useDay;
	}
	

	/**
	 * Column Info
	 * @param locTp
	 */
	public void setLocTp(String locTp) {
		this.locTp = locTp;
	}
	
	/**
	 * Column Info
	 * @param cntrFullFlg
	 */
	public void setCntrFullFlg(String cntrFullFlg) {
		this.cntrFullFlg = cntrFullFlg;
	}
	
	/**
	 * Column Info
	 * @param lstStsFlg
	 */
	public void setLstStsFlg(String lstStsFlg) {
		this.lstStsFlg = lstStsFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrUseCoCd
	 */
	public void setCntrUseCoCd(String cntrUseCoCd) {
		this.cntrUseCoCd = cntrUseCoCd;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrStsCd
	 */
	public void setCntrStsCd(String cntrStsCd) {
		this.cntrStsCd = cntrStsCd;
	}
	
	/**
	 * Column Info
	 * @param hjsCreFlg
	 */
	public void setHjsCreFlg(String hjsCreFlg) {
		this.hjsCreFlg = hjsCreFlg;
	}
	
	/**
	 * Column Info
	 * @param strEvntDt
	 */
	public void setStrEvntDt(String strEvntDt) {
		this.strEvntDt = strEvntDt;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @param endEvntDt
	 */
	public void setEndEvntDt(String endEvntDt) {
		this.endEvntDt = endEvntDt;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param lstmScoTp
	 */
	public void setLstmScoTp(String lstmScoTp) {
		this.lstmScoTp = lstmScoTp;
	}
	
	/**
	 * Column Info
	 * @param totalFlg
	 */
	public void setTotalFlg(String totalFlg) {
		this.totalFlg = totalFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param onhFreeDys
	 */
	public void setOnhFreeDys(String onhFreeDys) {
		this.onhFreeDys = onhFreeDys;
	}
	
	/**
	 * Column Info
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}
	
	/**
	 * Column Info
	 * @param ttlFlag
	 */
	public void setTtlFlag(String ttlFlag) {
		this.ttlFlag = ttlFlag;
	}
	
	/**
	 * Column Info
	 * @param useDay
	 */
	public void setUseDay(String useDay) {
		this.useDay = useDay;
	}
	
	/**
	 * Page No
	 * @param iPage
	 */
	public void setIPage(int iPage) {
		this.iPage = iPage;
	}
	/**
	 * Page No
	 * @param iPage
	 */
	public int getIPage() {
		return iPage;
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
		setLocTp(JSPUtil.getParameter(request, prefix + "loc_tp", ""));
		setCntrFullFlg(JSPUtil.getParameter(request, prefix + "cntr_full_flg", ""));
		setLstStsFlg(JSPUtil.getParameter(request, prefix + "lst_sts_flg", ""));
		setCntrUseCoCd(JSPUtil.getParameter(request, prefix + "cntr_use_co_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setCntrStsCd(JSPUtil.getParameter(request, prefix + "cntr_sts_cd", ""));
		setHjsCreFlg(JSPUtil.getParameter(request, prefix + "hjs_cre_flg", ""));
		setStrEvntDt(JSPUtil.getParameter(request, prefix + "str_evnt_dt", "").replaceAll("-", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
		setEndEvntDt(JSPUtil.getParameter(request, prefix + "end_evnt_dt", "").replaceAll("-", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setLstmScoTp(JSPUtil.getParameter(request, prefix + "lstm_sco_tp", ""));
		setTotalFlg(JSPUtil.getParameter(request, prefix + "total_flg", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, prefix + "agmt_cty_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setOnhFreeDys(JSPUtil.getParameter(request, prefix + "onh_free_dys", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setTtlFlag(JSPUtil.getParameter(request, prefix + "ttl_flag", ""));
		setIPage(JSPUtil.getParameterAsInt(request, "iPage", 1));
		setUseDay(JSPUtil.getParameter(request, prefix + "use_day", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchParamVO[]
	 */
	public SearchParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchParamVO[]
	 */
	public SearchParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] locTp = (JSPUtil.getParameter(request, prefix	+ "loc_tp", length));
			String[] cntrFullFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_full_flg", length));
			String[] lstStsFlg = (JSPUtil.getParameter(request, prefix	+ "lst_sts_flg", length));
			String[] cntrUseCoCd = (JSPUtil.getParameter(request, prefix	+ "cntr_use_co_cd", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] cntrStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd", length));
			String[] hjsCreFlg = (JSPUtil.getParameter(request, prefix	+ "hjs_cre_flg", length));
			String[] strEvntDt = (JSPUtil.getParameter(request, prefix	+ "str_evnt_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] endEvntDt = (JSPUtil.getParameter(request, prefix	+ "end_evnt_dt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] lstmScoTp = (JSPUtil.getParameter(request, prefix	+ "lstm_sco_tp", length));
			String[] totalFlg = (JSPUtil.getParameter(request, prefix	+ "total_flg", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] onhFreeDys = (JSPUtil.getParameter(request, prefix	+ "onh_free_dys", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] ttlFlag = (JSPUtil.getParameter(request, prefix	+ "ttl_flag", length));
			String[] useDay = (JSPUtil.getParameter(request, prefix	+ "use_day", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchParamVO();
				if (locTp[i] != null)
					model.setLocTp(locTp[i]);
				if (cntrFullFlg[i] != null)
					model.setCntrFullFlg(cntrFullFlg[i]);
				if (lstStsFlg[i] != null)
					model.setLstStsFlg(lstStsFlg[i]);
				if (cntrUseCoCd[i] != null)
					model.setCntrUseCoCd(cntrUseCoCd[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (cntrStsCd[i] != null)
					model.setCntrStsCd(cntrStsCd[i]);
				if (hjsCreFlg[i] != null)
					model.setHjsCreFlg(hjsCreFlg[i]);
				if (strEvntDt[i] != null)
					model.setStrEvntDt(strEvntDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (endEvntDt[i] != null)
					model.setEndEvntDt(endEvntDt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (lstmScoTp[i] != null)
					model.setLstmScoTp(lstmScoTp[i]);
				if (totalFlg[i] != null)
					model.setTotalFlg(totalFlg[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (onhFreeDys[i] != null)
					model.setOnhFreeDys(onhFreeDys[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (ttlFlag[i] != null)
					model.setTtlFlag(ttlFlag[i]);
				if (useDay[i] != null)
					model.setUseDay(useDay[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchParamVO[]
	 */
	public SearchParamVO[] getSearchParamVOs(){
		SearchParamVO[] vos = (SearchParamVO[])models.toArray(new SearchParamVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.locTp = this.locTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFullFlg = this.cntrFullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstStsFlg = this.lstStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrUseCoCd = this.cntrUseCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCd = this.cntrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsCreFlg = this.hjsCreFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strEvntDt = this.strEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endEvntDt = this.endEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmScoTp = this.lstmScoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalFlg = this.totalFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhFreeDys = this.onhFreeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlFlag = this.ttlFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.useDay = this.useDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
