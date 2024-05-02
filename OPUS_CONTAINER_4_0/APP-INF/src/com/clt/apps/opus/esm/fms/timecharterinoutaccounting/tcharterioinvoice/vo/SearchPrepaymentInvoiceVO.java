/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchPrepaymentInvoiceVO.java
*@FileTitle : SearchPrepaymentInvoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.05.26 정윤태 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

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
 * @author 정윤태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchPrepaymentInvoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPrepaymentInvoiceVO> models = new ArrayList<SearchPrepaymentInvoiceVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String acmmFlg = null;
	/* Column Info */
	private String acmmRtAmt = null;
	/* Column Info */
	private String fletCtrtTpCd = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String fletBrogRtAmt = null;
	/* Column Info */
	private String fromTime = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String brogFlg = null;
	/* Column Info */
	private String toTime = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String invUsdDys = null;
	/* Column Info */
	private String ownrNm = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String custCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public SearchPrepaymentInvoiceVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String fletCtrtNo, String vslCd, String vslEngNm, String fletCtrtTpCd, String vndrLglEngNm, String custCntCd, String custSeq, String ownrNm, String effDt, String fromTime, String expDt, String toTime, String invUsdDys, String acmmRtAmt, String fletBrogRtAmt, String acmmFlg, String brogFlg, String invSeq
	 * @return 
	 */
	public SearchPrepaymentInvoiceVO(String ibflag, String pagerows, String fletCtrtNo, String vslCd, String vslEngNm, String fletCtrtTpCd, String vndrLglEngNm, String custCntCd, String custSeq, String ownrNm, String effDt, String fromTime, String expDt, String toTime, String invUsdDys, String acmmRtAmt, String fletBrogRtAmt, String acmmFlg, String brogFlg, String invSeq) {
		this.vslCd = vslCd;
		this.acmmFlg = acmmFlg;
		this.acmmRtAmt = acmmRtAmt;
		this.fletCtrtTpCd = fletCtrtTpCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.invSeq = invSeq;
		this.fletBrogRtAmt = fletBrogRtAmt;
		this.fromTime = fromTime;
		this.custSeq = custSeq;
		this.brogFlg = brogFlg;
		this.toTime = toTime;
		this.pagerows = pagerows;
		this.fletCtrtNo = fletCtrtNo;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.vslEngNm = vslEngNm;
		this.invUsdDys = invUsdDys;
		this.ownrNm = ownrNm;
		this.expDt = expDt;
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("acmm_flg", getAcmmFlg());
		this.hashColumns.put("acmm_rt_amt", getAcmmRtAmt());
		this.hashColumns.put("flet_ctrt_tp_cd", getFletCtrtTpCd());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("flet_brog_rt_amt", getFletBrogRtAmt());
		this.hashColumns.put("from_time", getFromTime());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("brog_flg", getBrogFlg());
		this.hashColumns.put("to_time", getToTime());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("inv_usd_dys", getInvUsdDys());
		this.hashColumns.put("ownr_nm", getOwnrNm());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("acmm_flg", "acmmFlg");
		this.hashFields.put("acmm_rt_amt", "acmmRtAmt");
		this.hashFields.put("flet_ctrt_tp_cd", "fletCtrtTpCd");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("flet_brog_rt_amt", "fletBrogRtAmt");
		this.hashFields.put("from_time", "fromTime");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("brog_flg", "brogFlg");
		this.hashFields.put("to_time", "toTime");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("inv_usd_dys", "invUsdDys");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
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
	 * @return acmmFlg
	 */
	public String getAcmmFlg() {
		return this.acmmFlg;
	}
	
	/**
	 * Column Info
	 * @return acmmRtAmt
	 */
	public String getAcmmRtAmt() {
		return this.acmmRtAmt;
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
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return invSeq
	 */
	public String getInvSeq() {
		return this.invSeq;
	}
	
	/**
	 * Column Info
	 * @return fletBrogRtAmt
	 */
	public String getFletBrogRtAmt() {
		return this.fletBrogRtAmt;
	}
	
	/**
	 * Column Info
	 * @return fromTime
	 */
	public String getFromTime() {
		return this.fromTime;
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
	 * @return brogFlg
	 */
	public String getBrogFlg() {
		return this.brogFlg;
	}
	
	/**
	 * Column Info
	 * @return toTime
	 */
	public String getToTime() {
		return this.toTime;
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
	 * @return fletCtrtNo
	 */
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return invUsdDys
	 */
	public String getInvUsdDys() {
		return this.invUsdDys;
	}
	
	/**
	 * Column Info
	 * @return ownrNm
	 */
	public String getOwnrNm() {
		return this.ownrNm;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param acmmFlg
	 */
	public void setAcmmFlg(String acmmFlg) {
		this.acmmFlg = acmmFlg;
	}
	
	/**
	 * Column Info
	 * @param acmmRtAmt
	 */
	public void setAcmmRtAmt(String acmmRtAmt) {
		this.acmmRtAmt = acmmRtAmt;
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
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param invSeq
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}
	
	/**
	 * Column Info
	 * @param fletBrogRtAmt
	 */
	public void setFletBrogRtAmt(String fletBrogRtAmt) {
		this.fletBrogRtAmt = fletBrogRtAmt;
	}
	
	/**
	 * Column Info
	 * @param fromTime
	 */
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
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
	 * @param brogFlg
	 */
	public void setBrogFlg(String brogFlg) {
		this.brogFlg = brogFlg;
	}
	
	/**
	 * Column Info
	 * @param toTime
	 */
	public void setToTime(String toTime) {
		this.toTime = toTime;
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
	 * @param fletCtrtNo
	 */
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param invUsdDys
	 */
	public void setInvUsdDys(String invUsdDys) {
		this.invUsdDys = invUsdDys;
	}
	
	/**
	 * Column Info
	 * @param ownrNm
	 */
	public void setOwnrNm(String ownrNm) {
		this.ownrNm = ownrNm;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setAcmmFlg(JSPUtil.getParameter(request, "acmm_flg", ""));
		setAcmmRtAmt(JSPUtil.getParameter(request, "acmm_rt_amt", ""));
		setFletCtrtTpCd(JSPUtil.getParameter(request, "flet_ctrt_tp_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setInvSeq(JSPUtil.getParameter(request, "inv_seq", ""));
		setFletBrogRtAmt(JSPUtil.getParameter(request, "flet_brog_rt_amt", ""));
		setFromTime(JSPUtil.getParameter(request, "from_time", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setBrogFlg(JSPUtil.getParameter(request, "brog_flg", ""));
		setToTime(JSPUtil.getParameter(request, "to_time", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setInvUsdDys(JSPUtil.getParameter(request, "inv_usd_dys", ""));
		setOwnrNm(JSPUtil.getParameter(request, "ownr_nm", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPrepaymentInvoiceVO[]
	 */
	public SearchPrepaymentInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPrepaymentInvoiceVO[]
	 */
	public SearchPrepaymentInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPrepaymentInvoiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] acmmFlg = (JSPUtil.getParameter(request, prefix	+ "acmm_flg".trim(), length));
			String[] acmmRtAmt = (JSPUtil.getParameter(request, prefix	+ "acmm_rt_amt".trim(), length));
			String[] fletCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_tp_cd".trim(), length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm".trim(), length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq".trim(), length));
			String[] fletBrogRtAmt = (JSPUtil.getParameter(request, prefix	+ "flet_brog_rt_amt".trim(), length));
			String[] fromTime = (JSPUtil.getParameter(request, prefix	+ "from_time".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] brogFlg = (JSPUtil.getParameter(request, prefix	+ "brog_flg".trim(), length));
			String[] toTime = (JSPUtil.getParameter(request, prefix	+ "to_time".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm".trim(), length));
			String[] invUsdDys = (JSPUtil.getParameter(request, prefix	+ "inv_usd_dys".trim(), length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm".trim(), length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt".trim(), length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPrepaymentInvoiceVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (acmmFlg[i] != null)
					model.setAcmmFlg(acmmFlg[i]);
				if (acmmRtAmt[i] != null)
					model.setAcmmRtAmt(acmmRtAmt[i]);
				if (fletCtrtTpCd[i] != null)
					model.setFletCtrtTpCd(fletCtrtTpCd[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (fletBrogRtAmt[i] != null)
					model.setFletBrogRtAmt(fletBrogRtAmt[i]);
				if (fromTime[i] != null)
					model.setFromTime(fromTime[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (brogFlg[i] != null)
					model.setBrogFlg(brogFlg[i]);
				if (toTime[i] != null)
					model.setToTime(toTime[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (invUsdDys[i] != null)
					model.setInvUsdDys(invUsdDys[i]);
				if (ownrNm[i] != null)
					model.setOwnrNm(ownrNm[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPrepaymentInvoiceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPrepaymentInvoiceVO[]
	 */
	public SearchPrepaymentInvoiceVO[] getSearchPrepaymentInvoiceVOs(){
		SearchPrepaymentInvoiceVO[] vos = (SearchPrepaymentInvoiceVO[])models.toArray(new SearchPrepaymentInvoiceVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acmmFlg = this.acmmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acmmRtAmt = this.acmmRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtTpCd = this.fletCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletBrogRtAmt = this.fletBrogRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromTime = this.fromTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogFlg = this.brogFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTime = this.toTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdDys = this.invUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
