/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchContractByInvoiceVO.java
*@FileTitle : SearchContractByInvoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.05.07 정윤태 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo;
 
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 정윤태
 * @since J2EE 1.5
 * @see ESM_FMS_0001HTMLAction
 */
 
public class SearchContractByInvoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchContractByInvoiceVO> models = new ArrayList<SearchContractByInvoiceVO>();
	
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
	private String fletBrogRtAmt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String brogFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String ownrNm = null;
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
	public SearchContractByInvoiceVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String fletCtrtNo, String vslCd, String vslEngNm, String fletCtrtTpCd, String vndrLglEngNm, String custCntCd, String custSeq, String ownrNm, String acmmRtAmt, String fletBrogRtAmt, String acmmFlg, String brogFlg
	 * @return 
	 */
	public SearchContractByInvoiceVO(String ibflag, String pagerows, String fletCtrtNo, String vslCd, String vslEngNm, String fletCtrtTpCd, String vndrLglEngNm, String custCntCd, String custSeq, String ownrNm, String acmmRtAmt, String fletBrogRtAmt, String acmmFlg, String brogFlg) {
		this.vslCd = vslCd;
		this.acmmFlg = acmmFlg;
		this.acmmRtAmt = acmmRtAmt;
		this.fletCtrtTpCd = fletCtrtTpCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.fletBrogRtAmt = fletBrogRtAmt;
		this.custSeq = custSeq;
		this.brogFlg = brogFlg;
		this.pagerows = pagerows;
		this.fletCtrtNo = fletCtrtNo;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.ownrNm = ownrNm;
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
		this.hashColumns.put("flet_brog_rt_amt", getFletBrogRtAmt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("brog_flg", getBrogFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("ownr_nm", getOwnrNm());
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
		this.hashFields.put("flet_brog_rt_amt", "fletBrogRtAmt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("brog_flg", "brogFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("ownr_nm", "ownrNm");
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
	public String getFletBrogRtAmt() {
		return this.fletBrogRtAmt;
	}
	public String getCustSeq() {
		return this.custSeq;
	}
	public String getBrogFlg() {
		return this.brogFlg;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	public String getOwnrNm() {
		return this.ownrNm;
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
	public void setFletBrogRtAmt(String fletBrogRtAmt) {
		this.fletBrogRtAmt = fletBrogRtAmt;
		//this.fletBrogRtAmt=true;
	}
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
		//this.custSeq=true;
	}
	public void setBrogFlg(String brogFlg) {
		this.brogFlg = brogFlg;
		//this.brogFlg=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
		//this.fletCtrtNo=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
		//this.vslEngNm=true;
	}
	public void setOwnrNm(String ownrNm) {
		this.ownrNm = ownrNm;
		//this.ownrNm=true;
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
		setFletBrogRtAmt(JSPUtil.getParameter(request, "flet_brog_rt_amt", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setBrogFlg(JSPUtil.getParameter(request, "brog_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setOwnrNm(JSPUtil.getParameter(request, "ownr_nm", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
	}

	public SearchContractByInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchContractByInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchContractByInvoiceVO model = null;
		
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
			String[] fletBrogRtAmt = (JSPUtil.getParameter(request, prefix	+ "flet_brog_rt_amt".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] brogFlg = (JSPUtil.getParameter(request, prefix	+ "brog_flg".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm".trim(), length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm".trim(), length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchContractByInvoiceVO();
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
				if (fletBrogRtAmt[i] != null)
					model.setFletBrogRtAmt(fletBrogRtAmt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (brogFlg[i] != null)
					model.setBrogFlg(brogFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (ownrNm[i] != null)
					model.setOwnrNm(ownrNm[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchContractByInvoiceVOs();
	}

	public SearchContractByInvoiceVO[] getSearchContractByInvoiceVOs(){
		SearchContractByInvoiceVO[] vos = (SearchContractByInvoiceVO[])models.toArray(new SearchContractByInvoiceVO[models.size()]);
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
		this.fletBrogRtAmt = this.fletBrogRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogFlg = this.brogFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
