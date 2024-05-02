/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TotalLossLessorReportVO.java
*@FileTitle : TotalLossLessorReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.06 민정호
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TotalLossLessorReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<TotalLossLessorReportVO> models = new ArrayList<TotalLossLessorReportVO>();

	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String tllDt = null;
	/* Column Info */
	private String lessorCd = null;
	/* Column Info */
	private String eqType = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dvValue = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String crAmt = null;
	/* Column Info */
	private String payAmt = null;
	/* Column Info */
	private String paySts = null;
	/* Column Info */
	private String crNo = null;
	/* Column Info */
	private String lessorNm = null;
	/* Column Info */
	private String crEndDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String convCurrCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public TotalLossLessorReportVO() {}

	public TotalLossLessorReportVO(String ibflag, String pagerows, String lessorCd, String lessorNm, String eqType, String eqNo, String tllDt, String dvValue, String payAmt, String payDt, String paySts, String crNo, String crAmt, String crEndDt, String currCd, String convCurrCd) {
		this.payDt = payDt;
		this.tllDt = tllDt;
		this.lessorCd = lessorCd;
		this.eqType = eqType;
		this.pagerows = pagerows;
		this.dvValue = dvValue;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.crAmt = crAmt;
		this.payAmt = payAmt;
		this.paySts = paySts;
		this.crNo = crNo;
		this.lessorNm = lessorNm;
		this.crEndDt = crEndDt;
		this.currCd = currCd;
		this.convCurrCd = convCurrCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("tll_dt", getTllDt());
		this.hashColumns.put("lessor_cd", getLessorCd());
		this.hashColumns.put("eq_type", getEqType());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dv_value", getDvValue());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cr_amt", getCrAmt());
		this.hashColumns.put("pay_amt", getPayAmt());
		this.hashColumns.put("pay_sts", getPaySts());
		this.hashColumns.put("cr_no", getCrNo());
		this.hashColumns.put("lessor_nm", getLessorNm());
		this.hashColumns.put("cr_end_dt", getCrEndDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("conv_curr_cd", getConvCurrCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("tll_dt", "tllDt");
		this.hashFields.put("lessor_cd", "lessorCd");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dv_value", "dvValue");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("pay_amt", "payAmt");
		this.hashFields.put("pay_sts", "paySts");
		this.hashFields.put("cr_no", "crNo");
		this.hashFields.put("lessor_nm", "lessorNm");
		this.hashFields.put("cr_end_dt", "crEndDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("conv_curr_cd", "convCurrCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return payDt
	 */
	public String getPayDt() {
		return this.payDt;
	}

	/**
	 * Column Info
	 * @return tllDt
	 */
	public String getTllDt() {
		return this.tllDt;
	}

	/**
	 * Column Info
	 * @return lessorCd
	 */
	public String getLessorCd() {
		return this.lessorCd;
	}

	/**
	 * Column Info
	 * @return eqType
	 */
	public String getEqType() {
		return this.eqType;
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
	 * @return dvValue
	 */
	public String getDvValue() {
		return this.dvValue;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}

	/**
	 * Column Info
	 * @return crAmt
	 */
	public String getCrAmt() {
		return this.crAmt;
	}

	/**
	 * Column Info
	 * @return payAmt
	 */
	public String getPayAmt() {
		return this.payAmt;
	}

	/**
	 * Column Info
	 * @return paySts
	 */
	public String getPaySts() {
		return this.paySts;
	}

	/**
	 * Column Info
	 * @return crNo
	 */
	public String getCrNo() {
		return this.crNo;
	}

	/**
	 * Column Info
	 * @return lessorNm
	 */
	public String getLessorNm() {
		return this.lessorNm;
	}

	/**
	 * Column Info
	 * @return crEndDt
	 */
	public String getCrEndDt() {
		return this.crEndDt;
	}


	/**
	 * Column Info
	 * @param payDt
	 */
	public void setPayDt(String payDt) {
		this.payDt = payDt;
	}

	/**
	 * Column Info
	 * @param tllDt
	 */
	public void setTllDt(String tllDt) {
		this.tllDt = tllDt;
	}

	/**
	 * Column Info
	 * @param lessorCd
	 */
	public void setLessorCd(String lessorCd) {
		this.lessorCd = lessorCd;
	}

	/**
	 * Column Info
	 * @param eqType
	 */
	public void setEqType(String eqType) {
		this.eqType = eqType;
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
	 * @param dvValue
	 */
	public void setDvValue(String dvValue) {
		this.dvValue = dvValue;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}

	/**
	 * Column Info
	 * @param crAmt
	 */
	public void setCrAmt(String crAmt) {
		this.crAmt = crAmt;
	}

	/**
	 * Column Info
	 * @param payAmt
	 */
	public void setPayAmt(String payAmt) {
		this.payAmt = payAmt;
	}

	/**
	 * Column Info
	 * @param paySts
	 */
	public void setPaySts(String paySts) {
		this.paySts = paySts;
	}

	/**
	 * Column Info
	 * @param crNo
	 */
	public void setCrNo(String crNo) {
		this.crNo = crNo;
	}

	/**
	 * Column Info
	 * @param lessorNm
	 */
	public void setLessorNm(String lessorNm) {
		this.lessorNm = lessorNm;
	}

	/**
	 * Column Info
	 * @param crEndDt
	 */
	public void setCrEndDt(String crEndDt) {
		this.crEndDt = crEndDt;
	}

	public String getCurrCd() {
		return currCd;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	public String getConvCurrCd() {
		return convCurrCd;
	}

	public void setConvCurrCd(String convCurrCd) {
		this.convCurrCd = convCurrCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPayDt(JSPUtil.getParameter(request, "pay_dt", ""));
		setTllDt(JSPUtil.getParameter(request, "tll_dt", ""));
		setLessorCd(JSPUtil.getParameter(request, "lessor_cd", ""));
		setEqType(JSPUtil.getParameter(request, "eq_type", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDvValue(JSPUtil.getParameter(request, "dv_value", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setCrAmt(JSPUtil.getParameter(request, "cr_amt", ""));
		setPayAmt(JSPUtil.getParameter(request, "pay_amt", ""));
		setPaySts(JSPUtil.getParameter(request, "pay_sts", ""));
		setCrNo(JSPUtil.getParameter(request, "cr_no", ""));
		setLessorNm(JSPUtil.getParameter(request, "lessor_nm", ""));
		setCrEndDt(JSPUtil.getParameter(request, "cr_end_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setConvCurrCd(JSPUtil.getParameter(request, "conv_curr_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TotalLossLessorReportVO[]
	 */
	public TotalLossLessorReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return TotalLossLessorReportVO[]
	 */
	public TotalLossLessorReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TotalLossLessorReportVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] tllDt = (JSPUtil.getParameter(request, prefix	+ "tll_dt", length));
			String[] lessorCd = (JSPUtil.getParameter(request, prefix	+ "lessor_cd", length));
			String[] eqType = (JSPUtil.getParameter(request, prefix	+ "eq_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dvValue = (JSPUtil.getParameter(request, prefix	+ "dv_value", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] crAmt = (JSPUtil.getParameter(request, prefix	+ "cr_amt", length));
			String[] payAmt = (JSPUtil.getParameter(request, prefix	+ "pay_amt", length));
			String[] paySts = (JSPUtil.getParameter(request, prefix	+ "pay_sts", length));
			String[] crNo = (JSPUtil.getParameter(request, prefix	+ "cr_no", length));
			String[] lessorNm = (JSPUtil.getParameter(request, prefix	+ "lessor_nm", length));
			String[] crEndDt = (JSPUtil.getParameter(request, prefix	+ "cr_end_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] convCurrCd = (JSPUtil.getParameter(request, prefix	+ "conv_curr_cd", length));

			for (int i = 0; i < length; i++) {
				model = new TotalLossLessorReportVO();
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (tllDt[i] != null)
					model.setTllDt(tllDt[i]);
				if (lessorCd[i] != null)
					model.setLessorCd(lessorCd[i]);
				if (eqType[i] != null)
					model.setEqType(eqType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dvValue[i] != null)
					model.setDvValue(dvValue[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (crAmt[i] != null)
					model.setCrAmt(crAmt[i]);
				if (payAmt[i] != null)
					model.setPayAmt(payAmt[i]);
				if (paySts[i] != null)
					model.setPaySts(paySts[i]);
				if (crNo[i] != null)
					model.setCrNo(crNo[i]);
				if (lessorNm[i] != null)
					model.setLessorNm(lessorNm[i]);
				if (crEndDt[i] != null)
					model.setCrEndDt(crEndDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (convCurrCd[i] != null)
					model.setConvCurrCd(convCurrCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTotalLossLessorReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TotalLossLessorReportVO[]
	 */
	public TotalLossLessorReportVO[] getTotalLossLessorReportVOs(){
		TotalLossLessorReportVO[] vos = (TotalLossLessorReportVO[])models.toArray(new TotalLossLessorReportVO[models.size()]);
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
		this.payDt = this.payDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tllDt = this.tllDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessorCd = this.lessorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType = this.eqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvValue = this.dvValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt = this.crAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAmt = this.payAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paySts = this.paySts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crNo = this.crNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessorNm = this.lessorNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crEndDt = this.crEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convCurrCd = this.convCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
