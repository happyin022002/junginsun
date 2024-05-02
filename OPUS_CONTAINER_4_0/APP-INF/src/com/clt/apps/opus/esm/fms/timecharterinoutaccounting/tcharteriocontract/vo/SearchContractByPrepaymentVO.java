/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchContractByPrepaymentVO.java
*@FileTitle : SearchContractByPrepaymentVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.05.21 정윤태 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 정윤태
 * @since J2EE 1.5
 * @see ESM_FMS_0012HTMLAction
 */
 
public class SearchContractByPrepaymentVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchContractByPrepaymentVO> models = new ArrayList<SearchContractByPrepaymentVO>();
	
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
	private String payHirNo = null;
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
	/* Column Info */
	private String fromTime = null;
	/* Status */
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

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public SearchContractByPrepaymentVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String fletCtrtNo, String vslCd, String vslEngNm, String fletCtrtTpCd, String vndrLglEngNm, String custCntCd, String custSeq, String ownrNm, String effDt, String fromTime, String expDt, String toTime, String invUsdDys, String acmmRtAmt, String fletBrogRtAmt, String acmmFlg, String brogFlg, String invSeq, String payHirNo
	 * @return 
	 */
	public SearchContractByPrepaymentVO(String ibflag, String pagerows, String fletCtrtNo, String vslCd, String vslEngNm, String fletCtrtTpCd, String vndrLglEngNm, String custCntCd, String custSeq, String ownrNm, String effDt, String fromTime, String expDt, String toTime, String invUsdDys, String acmmRtAmt, String fletBrogRtAmt, String acmmFlg, String brogFlg, String invSeq, String payHirNo) {
		this.vslCd = vslCd;
		this.acmmFlg = acmmFlg;
		this.acmmRtAmt = acmmRtAmt;
		this.fletCtrtTpCd = fletCtrtTpCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.invSeq = invSeq;
		this.fletBrogRtAmt = fletBrogRtAmt;
		this.payHirNo = payHirNo;
		this.custSeq = custSeq;
		this.brogFlg = brogFlg;
		this.toTime = toTime;
		this.pagerows = pagerows;
		this.fletCtrtNo = fletCtrtNo;
		this.fromTime = fromTime;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.vslEngNm = vslEngNm;
		this.invUsdDys = invUsdDys;
		this.ownrNm = ownrNm;
		this.expDt = expDt;
		this.custCntCd = custCntCd;
	}
	
	/**
	 * hashColumnInpo
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
		this.hashColumns.put("pay_hir_no", getPayHirNo());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("brog_flg", getBrogFlg());
		this.hashColumns.put("to_time", getToTime());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("from_time", getFromTime());
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
	 * hashFildInpo
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
		this.hashFields.put("pay_hir_no", "payHirNo");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("brog_flg", "brogFlg");
		this.hashFields.put("to_time", "toTime");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("from_time", "fromTime");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("inv_usd_dys", "invUsdDys");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		return this.hashFields;
	}
	
	public String getVslCd() {
		return this.vslCd;
	}
	public String getAcmmFlg() {
		return this.acmmFlg;
	}
	public String getAcmmRtAmt() {
		return this.acmmRtAmt;
	}
	public String getFletCtrtTpCd() {
		return this.fletCtrtTpCd;
	}
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	public String getInvSeq() {
		return this.invSeq;
	}
	public String getFletBrogRtAmt() {
		return this.fletBrogRtAmt;
	}
	public String getPayHirNo() {
		return this.payHirNo;
	}
	public String getCustSeq() {
		return this.custSeq;
	}
	public String getBrogFlg() {
		return this.brogFlg;
	}
	public String getToTime() {
		return this.toTime;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
	}
	public String getFromTime() {
		return this.fromTime;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getEffDt() {
		return this.effDt;
	}
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	public String getInvUsdDys() {
		return this.invUsdDys;
	}
	public String getOwnrNm() {
		return this.ownrNm;
	}
	public String getExpDt() {
		return this.expDt;
	}
	public String getCustCntCd() {
		return this.custCntCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	public void setAcmmFlg(String acmmFlg) {
		this.acmmFlg = acmmFlg;
		//this.acmmFlg=true;
	}
	public void setAcmmRtAmt(String acmmRtAmt) {
		this.acmmRtAmt = acmmRtAmt;
		//this.acmmRtAmt=true;
	}
	public void setFletCtrtTpCd(String fletCtrtTpCd) {
		this.fletCtrtTpCd = fletCtrtTpCd;
		//this.fletCtrtTpCd=true;
	}
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
		//this.vndrLglEngNm=true;
	}
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
		//this.invSeq=true;
	}
	public void setFletBrogRtAmt(String fletBrogRtAmt) {
		this.fletBrogRtAmt = fletBrogRtAmt;
		//this.fletBrogRtAmt=true;
	}
	public void setPayHirNo(String payHirNo) {
		this.payHirNo = payHirNo;
		//this.payHirNo=true;
	}
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
		//this.custSeq=true;
	}
	public void setBrogFlg(String brogFlg) {
		this.brogFlg = brogFlg;
		//this.brogFlg=true;
	}
	public void setToTime(String toTime) {
		this.toTime = toTime;
		//this.toTime=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
		//this.fletCtrtNo=true;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
		//this.fromTime=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setEffDt(String effDt) {
		this.effDt = effDt;
		//this.effDt=true;
	}
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
		//this.vslEngNm=true;
	}
	public void setInvUsdDys(String invUsdDys) {
		this.invUsdDys = invUsdDys;
		//this.invUsdDys=true;
	}
	public void setOwnrNm(String ownrNm) {
		this.ownrNm = ownrNm;
		//this.ownrNm=true;
	}
	public void setExpDt(String expDt) {
		this.expDt = expDt;
		//this.expDt=true;
	}
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
		//this.custCntCd=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setAcmmFlg(JSPUtil.getParameter(request, "acmm_flg", ""));
		setAcmmRtAmt(JSPUtil.getParameter(request, "acmm_rt_amt", ""));
		setFletCtrtTpCd(JSPUtil.getParameter(request, "flet_ctrt_tp_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setInvSeq(JSPUtil.getParameter(request, "inv_seq", ""));
		setFletBrogRtAmt(JSPUtil.getParameter(request, "flet_brog_rt_amt", ""));
		setPayHirNo(JSPUtil.getParameter(request, "pay_hir_no", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setBrogFlg(JSPUtil.getParameter(request, "brog_flg", ""));
		setToTime(JSPUtil.getParameter(request, "to_time", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setFromTime(JSPUtil.getParameter(request, "from_time", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setInvUsdDys(JSPUtil.getParameter(request, "inv_usd_dys", ""));
		setOwnrNm(JSPUtil.getParameter(request, "ownr_nm", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
	}

	public SearchContractByPrepaymentVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchContractByPrepaymentVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchContractByPrepaymentVO model = null;
		
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
			String[] payHirNo = (JSPUtil.getParameter(request, prefix	+ "pay_hir_no".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] brogFlg = (JSPUtil.getParameter(request, prefix	+ "brog_flg".trim(), length));
			String[] toTime = (JSPUtil.getParameter(request, prefix	+ "to_time".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no".trim(), length));
			String[] fromTime = (JSPUtil.getParameter(request, prefix	+ "from_time".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm".trim(), length));
			String[] invUsdDys = (JSPUtil.getParameter(request, prefix	+ "inv_usd_dys".trim(), length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm".trim(), length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt".trim(), length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchContractByPrepaymentVO();
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
				if (payHirNo[i] != null)
					model.setPayHirNo(payHirNo[i]);
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
				if (fromTime[i] != null)
					model.setFromTime(fromTime[i]);
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

		} catch (Exception e) {}
		return getSearchContractByPrepaymentVOs();
	}

	public SearchContractByPrepaymentVO[] getSearchContractByPrepaymentVOs(){
		SearchContractByPrepaymentVO[] vos = (SearchContractByPrepaymentVO[])models.toArray(new SearchContractByPrepaymentVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acmmFlg = this.acmmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acmmRtAmt = this.acmmRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtTpCd = this.fletCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletBrogRtAmt = this.fletBrogRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payHirNo = this.payHirNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogFlg = this.brogFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTime = this.toTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromTime = this.fromTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdDys = this.invUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
