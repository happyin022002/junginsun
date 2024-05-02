/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgBlNoVO.java
*@FileTitle : BkgBlNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.06.18 김경섭
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchActualCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SearchActualCustomerVO> models = new ArrayList<SearchActualCustomerVO>();

	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String fromDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String appDt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String code = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String bkgUpldFlg = null;
	
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SearchActualCustomerVO() {}

	public SearchActualCustomerVO(String ibflag, String pagerows, String custCntCd, String custSeq, String code, String custLglEngNm, String fromDt, String toDt, String scNo, String rfaNo, String bkgNo, String svcScpCd, String appDt, String porCd, String delCd, String cmdtCd, String bkgUpldFlg) {
		this.toDt = toDt;
		this.rfaNo = rfaNo;
		this.bkgNo = bkgNo;
		this.fromDt = fromDt;
		this.ibflag = ibflag;
		this.appDt = appDt;
		this.svcScpCd = svcScpCd;
		this.scNo = scNo;
		this.code = code;
		this.custSeq = custSeq;
		this.custCntCd = custCntCd;
		this.custLglEngNm = custLglEngNm;
		this.porCd = porCd;
		this.delCd = delCd;
		this.cmdtCd = cmdtCd;
		this.bkgUpldFlg = bkgUpldFlg;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("app_dt", getAppDt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("bkg_upld_flg", getBkgUpldFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("app_dt", "appDt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("code", "code");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("bkg_upld_flg", "bkgUpldFlg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}

	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
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
	 * @return appDt
	 */
	public String getAppDt() {
		return this.appDt;
	}

	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}

	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}

	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}

	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}

	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}

	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
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
	 * @param appDt
	 */
	public void setAppDt(String appDt) {
		this.appDt = appDt;
	}

	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}

	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}

	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}	
	

	public String getPorCd() {
		return porCd;
	}

	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}

	public String getDelCd() {
		return delCd;
	}

	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}

	public String getCmdtCd() {
		return cmdtCd;
	}

	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}

	public String getBkgUpldFlg() {
		return bkgUpldFlg;
	}

	public void setBkgUpldFlg(String bkgUpldFlg) {
		this.bkgUpldFlg = bkgUpldFlg;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setFromDt(JSPUtil.getParameter(request, "from_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAppDt(JSPUtil.getParameter(request, "app_dt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setCode(JSPUtil.getParameter(request, "code", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, "cust_lgl_eng_nm", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setBkgUpldFlg(JSPUtil.getParameter(request, "bkg_upld_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgBlNoVO[]
	 */
	public SearchActualCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgBlNoVO[]
	 */
	public SearchActualCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchActualCustomerVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt".trim(), length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no".trim(), length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no".trim(), length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] appDt = (JSPUtil.getParameter(request, prefix	+ "app_dt".trim(), length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd".trim(), length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no".trim(), length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd".trim(), length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm".trim(), length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd".trim(), length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd".trim(), length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd".trim(), length));
			String[] bkgUpldFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_upld_flg".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new SearchActualCustomerVO();
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (appDt[i] != null)
					model.setAppDt(appDt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (bkgUpldFlg[i] != null)
					model.setBkgUpldFlg(bkgUpldFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgBlNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgBlNoVO[]
	 */
	public SearchActualCustomerVO[] getBkgBlNoVOs(){
		SearchActualCustomerVO[] vos = (SearchActualCustomerVO[])models.toArray(new SearchActualCustomerVO[models.size()]);
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
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.appDt = this.appDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgUpldFlg = this.bkgUpldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
