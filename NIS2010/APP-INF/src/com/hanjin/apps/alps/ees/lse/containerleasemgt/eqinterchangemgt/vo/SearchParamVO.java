/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchParamVO.java
*@FileTitle : SearchParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.02  
* 1.0 Creation
* 2015-07-09 [CHM-201536018] EQ INTERCHANGE WORK module 신규 개발 제안
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo;

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

public class SearchParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchParamVO> models = new ArrayList<SearchParamVO>();
	
	/* Column Info */
	private String authSeq = null;
	/* Column Info */
	private String locTp = null;
	/* Column Info */
	private String lstStsFlg = null;
	/* Column Info */
	private String cntrStsCd = null;
	/* Column Info */
	private String authNo = null;
	/* Column Info */
	private String ipage = null;
	/* Column Info */
	private String locTp2 = null;
	/* Column Info */
	private String lstmSocTp = null;
	/* Column Info */
	private String strEvntDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lstStsFlg1 = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String endEvntDt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String locCd2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchParamVO() {}

	public SearchParamVO(String ibflag, String pagerows, String cntrStsCd, String lstStsFlg, String lstStsFlg1, String lstmSocTp, String locTp, String locCd, String locTp2, String locCd2, String cntrTpszCd, String strEvntDt, String endEvntDt, String vndrSeq, String ipage, String authNo, String authSeq) {
		this.authSeq = authSeq;
		this.locTp = locTp;
		this.lstStsFlg = lstStsFlg;
		this.cntrStsCd = cntrStsCd;
		this.authNo = authNo;
		this.ipage = ipage;
		this.locTp2 = locTp2;
		this.lstmSocTp = lstmSocTp;
		this.strEvntDt = strEvntDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.lstStsFlg1 = lstStsFlg1;
		this.locCd = locCd;
		this.endEvntDt = endEvntDt;
		this.vndrSeq = vndrSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.locCd2 = locCd2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("auth_seq", getAuthSeq());
		this.hashColumns.put("loc_tp", getLocTp());
		this.hashColumns.put("lst_sts_flg", getLstStsFlg());
		this.hashColumns.put("cntr_sts_cd", getCntrStsCd());
		this.hashColumns.put("auth_no", getAuthNo());
		this.hashColumns.put("ipage", getIpage());
		this.hashColumns.put("loc_tp2", getLocTp2());
		this.hashColumns.put("lstm_soc_tp", getLstmSocTp());
		this.hashColumns.put("str_evnt_dt", getStrEvntDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lst_sts_flg1", getLstStsFlg1());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("end_evnt_dt", getEndEvntDt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("loc_cd2", getLocCd2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("auth_seq", "authSeq");
		this.hashFields.put("loc_tp", "locTp");
		this.hashFields.put("lst_sts_flg", "lstStsFlg");
		this.hashFields.put("cntr_sts_cd", "cntrStsCd");
		this.hashFields.put("auth_no", "authNo");
		this.hashFields.put("ipage", "ipage");
		this.hashFields.put("loc_tp2", "locTp2");
		this.hashFields.put("lstm_soc_tp", "lstmSocTp");
		this.hashFields.put("str_evnt_dt", "strEvntDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lst_sts_flg1", "lstStsFlg1");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("end_evnt_dt", "endEvntDt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("loc_cd2", "locCd2");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return authSeq
	 */
	public String getAuthSeq() {
		return this.authSeq;
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
	 * @return lstStsFlg
	 */
	public String getLstStsFlg() {
		return this.lstStsFlg;
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
	 * @return authNo
	 */
	public String getAuthNo() {
		return this.authNo;
	}
	
	/**
	 * Column Info
	 * @return ipage
	 */
	public String getIpage() {
		return this.ipage;
	}
	
	/**
	 * Column Info
	 * @return locTp2
	 */
	public String getLocTp2() {
		return this.locTp2;
	}
	
	/**
	 * Column Info
	 * @return lstmSocTp
	 */
	public String getLstmSocTp() {
		return this.lstmSocTp;
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
	 * @return lstStsFlg1
	 */
	public String getLstStsFlg1() {
		return this.lstStsFlg1;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return locCd2
	 */
	public String getLocCd2() {
		return this.locCd2;
	}
	

	/**
	 * Column Info
	 * @param authSeq
	 */
	public void setAuthSeq(String authSeq) {
		this.authSeq = authSeq;
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
	 * @param lstStsFlg
	 */
	public void setLstStsFlg(String lstStsFlg) {
		this.lstStsFlg = lstStsFlg;
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
	 * @param authNo
	 */
	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}
	
	/**
	 * Column Info
	 * @param ipage
	 */
	public void setIpage(String ipage) {
		this.ipage = ipage;
	}
	
	/**
	 * Column Info
	 * @param locTp2
	 */
	public void setLocTp2(String locTp2) {
		this.locTp2 = locTp2;
	}
	
	/**
	 * Column Info
	 * @param lstmSocTp
	 */
	public void setLstmSocTp(String lstmSocTp) {
		this.lstmSocTp = lstmSocTp;
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
	 * @param lstStsFlg1
	 */
	public void setLstStsFlg1(String lstStsFlg1) {
		this.lstStsFlg1 = lstStsFlg1;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param locCd2
	 */
	public void setLocCd2(String locCd2) {
		this.locCd2 = locCd2;
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
		setAuthSeq(JSPUtil.getParameter(request, prefix + "auth_seq", ""));
		setLocTp(JSPUtil.getParameter(request, prefix + "loc_tp", ""));
		setLstStsFlg(JSPUtil.getParameter(request, prefix + "lst_sts_flg", ""));
		setCntrStsCd(JSPUtil.getParameter(request, prefix + "cntr_sts_cd", ""));
		setAuthNo(JSPUtil.getParameter(request, prefix + "auth_no", ""));
		setIpage(JSPUtil.getParameter(request, prefix + "ipage", ""));
		setLocTp2(JSPUtil.getParameter(request, prefix + "loc_tp2", ""));
		setLstmSocTp(JSPUtil.getParameter(request, prefix + "lstm_soc_tp", ""));
		setStrEvntDt(JSPUtil.getParameter(request, prefix + "str_evnt_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLstStsFlg1(JSPUtil.getParameter(request, prefix + "lst_sts_flg1", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setEndEvntDt(JSPUtil.getParameter(request, prefix + "end_evnt_dt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setLocCd2(JSPUtil.getParameter(request, prefix + "loc_cd2", ""));
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
			String[] authSeq = (JSPUtil.getParameter(request, prefix	+ "auth_seq", length));
			String[] locTp = (JSPUtil.getParameter(request, prefix	+ "loc_tp", length));
			String[] lstStsFlg = (JSPUtil.getParameter(request, prefix	+ "lst_sts_flg", length));
			String[] cntrStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd", length));
			String[] authNo = (JSPUtil.getParameter(request, prefix	+ "auth_no", length));
			String[] ipage = (JSPUtil.getParameter(request, prefix	+ "ipage", length));
			String[] locTp2 = (JSPUtil.getParameter(request, prefix	+ "loc_tp2", length));
			String[] lstmSocTp = (JSPUtil.getParameter(request, prefix	+ "lstm_soc_tp", length));
			String[] strEvntDt = (JSPUtil.getParameter(request, prefix	+ "str_evnt_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lstStsFlg1 = (JSPUtil.getParameter(request, prefix	+ "lst_sts_flg1", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] endEvntDt = (JSPUtil.getParameter(request, prefix	+ "end_evnt_dt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] locCd2 = (JSPUtil.getParameter(request, prefix	+ "loc_cd2", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchParamVO();
				if (authSeq[i] != null)
					model.setAuthSeq(authSeq[i]);
				if (locTp[i] != null)
					model.setLocTp(locTp[i]);
				if (lstStsFlg[i] != null)
					model.setLstStsFlg(lstStsFlg[i]);
				if (cntrStsCd[i] != null)
					model.setCntrStsCd(cntrStsCd[i]);
				if (authNo[i] != null)
					model.setAuthNo(authNo[i]);
				if (ipage[i] != null)
					model.setIpage(ipage[i]);
				if (locTp2[i] != null)
					model.setLocTp2(locTp2[i]);
				if (lstmSocTp[i] != null)
					model.setLstmSocTp(lstmSocTp[i]);
				if (strEvntDt[i] != null)
					model.setStrEvntDt(strEvntDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lstStsFlg1[i] != null)
					model.setLstStsFlg1(lstStsFlg1[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (endEvntDt[i] != null)
					model.setEndEvntDt(endEvntDt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (locCd2[i] != null)
					model.setLocCd2(locCd2[i]);
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
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.authSeq = this.authSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTp = this.locTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstStsFlg = this.lstStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCd = this.cntrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authNo = this.authNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ipage = this.ipage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTp2 = this.locTp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmSocTp = this.lstmSocTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strEvntDt = this.strEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstStsFlg1 = this.lstStsFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endEvntDt = this.endEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd2 = this.locCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
