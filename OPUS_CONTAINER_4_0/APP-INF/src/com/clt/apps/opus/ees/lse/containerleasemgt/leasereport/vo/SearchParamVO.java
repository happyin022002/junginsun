/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchParamVO.java
*@FileTitle : SearchParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.08.13 장준우
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장준우
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
	private String strEvntDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String endEvntDt = null;
	/* Column Info */
	private String totalFlg = null;
	/* Column Info */
	private String lstmScoTp = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String onhFreeDys = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String coCreFlg = null;
	/* Column Info */
	private String gTtl = null;
	/* Column Info */
	private String lsePayTpCd = null;
	/* Column Info */
	private String cntrOnhAuthNo = null;
	/* Column Info */
	private int iPage = 1;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SearchParamVO() {}

	public SearchParamVO(String ibflag, String pagerows, String coCreFlg, String strEvntDt, String endEvntDt, String lstmCd, String cntrUseCoCd, String vndrSeq, String agmtCtyCd, String agmtSeq, String cntrTpszCd, String cnmvStsCd, String lstStsFlg, String cntrStsCd, String lstmScoTp, String locTp, String locCd, String onhFreeDys, String cntrFullFlg, String totalFlg, String gTtl, String lsePayTpCd, String cntrOnhAuthNo) {
		this.locTp = locTp;
		this.cntrFullFlg = cntrFullFlg;
		this.lstStsFlg = lstStsFlg;
		this.cntrUseCoCd = cntrUseCoCd;
		this.agmtSeq = agmtSeq;
		this.cntrStsCd = cntrStsCd;
		this.strEvntDt = strEvntDt;
		this.pagerows = pagerows;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.cnmvStsCd = cnmvStsCd;
		this.endEvntDt = endEvntDt;
		this.totalFlg = totalFlg; 
		this.lstmScoTp = lstmScoTp;
		this.vndrSeq = vndrSeq;
		this.agmtCtyCd = agmtCtyCd;
		this.cntrTpszCd = cntrTpszCd;
		this.onhFreeDys = onhFreeDys;
		this.lstmCd = lstmCd;
		this.coCreFlg = coCreFlg;
		this.gTtl = gTtl;
		this.lsePayTpCd = lsePayTpCd;
		this.cntrOnhAuthNo = cntrOnhAuthNo;
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
		this.hashColumns.put("str_evnt_dt", getStrEvntDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("end_evnt_dt", getEndEvntDt());
		this.hashColumns.put("total_flg", getTotalFlg());
		this.hashColumns.put("lstm_sco_tp", getLstmScoTp());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("onh_free_dys", getOnhFreeDys());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("co_cre_flg", getCoCreFlg());
		this.hashColumns.put("g_ttl", getGTtl());
		this.hashColumns.put("lse_pay_tp_cd", getLsePayTpCd()); 
		this.hashColumns.put("cntr_onh_auth_no", getCntrOnhAuthNo());
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
		this.hashFields.put("str_evnt_dt", "strEvntDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("end_evnt_dt", "endEvntDt");
		this.hashFields.put("total_flg", "totalFlg");
		this.hashFields.put("lstm_sco_tp", "lstmScoTp");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("onh_free_dys", "onhFreeDys");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("co_cre_flg", "coCreFlg");
		this.hashFields.put("g_ttl", "gTtl");
		this.hashColumns.put("lse_pay_tp_cd", "lsePayTpCd");
		this.hashColumns.put("cntr_onh_auth_no", "cntrOnhAuthNo");
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
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return totalFlg
	 */
	public String getTotalFlg() {
		return this.totalFlg;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getGTtl() {
		return this.gTtl;
	}
	
	/**
	 * Column Info
	 * @return lsePayTpCd
	 */
	public String getLsePayTpCd() {
		return this.lsePayTpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrOnhAuthNo
	 */
	public String getCntrOnhAuthNo() {
		return this.cntrOnhAuthNo;
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
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param totalFlg
	 */
	public void setTotalFlg(String totalFlg) {
		this.totalFlg = totalFlg;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}

	/**
	 * @return the coCreFlg
	 */
	public String getCoCreFlg() {
		return coCreFlg;
	}

	/**
	 * @param coCreFlg the coCreFlg to set
	 */
	public void setCoCreFlg(String coCreFlg) {
		this.coCreFlg = coCreFlg;
	}
	
	/**
	 * @param gTtl the gTtl to set
	 */
	public void setGTtl(String gTtl) {
		this.gTtl = gTtl;
	}
	
	/**
	 * @param lsePayTpCd the lsePayTpCd to set
	 */
	public void setLsePayTpCd(String lsePayTpCd) {
		this.lsePayTpCd = lsePayTpCd;
	}
	
	/**
	 * @param cntrOnhAuthNo the cntrOnhAuthNo to set
	 */
	public void setCntrOnhAuthNo(String cntrOnhAuthNo) {
		this.cntrOnhAuthNo = cntrOnhAuthNo;
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
		setLocTp(JSPUtil.getParameter(request, "loc_tp", ""));
		setCntrFullFlg(JSPUtil.getParameter(request, "cntr_full_flg", ""));
		setLstStsFlg(JSPUtil.getParameter(request, "lst_sts_flg", ""));
		setCntrUseCoCd(JSPUtil.getParameter(request, "cntr_use_co_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setCntrStsCd(JSPUtil.getParameter(request, "cntr_sts_cd", ""));
		setStrEvntDt(JSPUtil.getParameter(request, "str_evnt_dt", "").replaceAll("-", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setEndEvntDt(JSPUtil.getParameter(request, "end_evnt_dt", "").replaceAll("-", ""));
		setTotalFlg(JSPUtil.getParameter(request, "total_flg", ""));
		setLstmScoTp(JSPUtil.getParameter(request, "lstm_sco_tp", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setOnhFreeDys(JSPUtil.getParameter(request, "onh_free_dys", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setCoCreFlg(JSPUtil.getParameter(request, "co_cre_flg", ""));
		setGTtl(JSPUtil.getParameter(request, "g_ttl", ""));
		setLsePayTpCd(JSPUtil.getParameter(request, "lse_pay_tp_cd", ""));
		setCntrOnhAuthNo(JSPUtil.getParameter(request, "cntr_onh_auth_no", ""));
		setIPage(JSPUtil.getParameterAsInt(request, "iPage", 1));
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
			String[] strEvntDt = (JSPUtil.getParameter(request, prefix	+ "str_evnt_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] endEvntDt = (JSPUtil.getParameter(request, prefix	+ "end_evnt_dt", length));
			String[] totalFlg = (JSPUtil.getParameter(request, prefix	+ "total_flg", length));
			String[] lstmScoTp = (JSPUtil.getParameter(request, prefix	+ "lstm_sco_tp", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] onhFreeDys = (JSPUtil.getParameter(request, prefix	+ "onh_free_dys", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] coCreFlg = (JSPUtil.getParameter(request, prefix	+ "co_cre_flg", length));
			String[] gTtl = (JSPUtil.getParameter(request, prefix	+ "g_ttl", length));
			String[] lsePayTpCd = (JSPUtil.getParameter(request, prefix	+ "lse_pay_tp_cd", length));
			String[] cntrOnhAuthNo = (JSPUtil.getParameter(request, prefix	+ "cntr_onh_auth_no", length));

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
				if (strEvntDt[i] != null)
					model.setStrEvntDt(strEvntDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (endEvntDt[i] != null)
					model.setEndEvntDt(endEvntDt[i]);
				if (totalFlg[i] != null)
					model.setTotalFlg(totalFlg[i]);
				if (lstmScoTp[i] != null)
					model.setLstmScoTp(lstmScoTp[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (onhFreeDys[i] != null)
					model.setOnhFreeDys(onhFreeDys[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (coCreFlg[i] != null)
					model.setCoCreFlg(coCreFlg[i]);
				if (gTtl[i] != null)
					model.setGTtl(gTtl[i]);
				if (lsePayTpCd[i] != null)
					model.setLsePayTpCd(lsePayTpCd[i]);
				if (cntrOnhAuthNo[i] != null)
					model.setCntrOnhAuthNo(cntrOnhAuthNo[i]);
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
		this.strEvntDt = this.strEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endEvntDt = this.endEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalFlg = this.totalFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmScoTp = this.lstmScoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhFreeDys = this.onhFreeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCreFlg = this.coCreFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gTtl = this.gTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsePayTpCd = this.lsePayTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOnhAuthNo = this.cntrOnhAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
