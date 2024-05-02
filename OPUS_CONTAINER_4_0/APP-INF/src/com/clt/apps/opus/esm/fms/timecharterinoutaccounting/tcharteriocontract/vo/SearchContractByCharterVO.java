/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchContractByCharterVO.java
*@FileTitle : SearchContractByCharterVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.14
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.14 정윤태
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
 * @see ESM_FMS_0001HTMLAction
 */
 
public class SearchContractByCharterVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchContractByCharterVO> models = new ArrayList<SearchContractByCharterVO>();
	
	/* 而щ읆 �ㅻ챸 */
	private String vslCd = null;
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String vslEngNm = null;
	/* 而щ읆 �ㅻ챸 */
	private String fletCtrtTpCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String vndrLglEngNm = null;
	/* 而щ읆 �ㅻ챸 */
	private String ownrNm = null;
	/* 而щ읆 �ㅻ챸 */
	private String custSeq = null;
	/* 而щ읆 �ㅻ챸 */
	private String custCntCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String fletCtrtNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public SearchContractByCharterVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String fletCtrtNo, String vslCd, String vslEngNm, String fletCtrtTpCd, String vndrLglEngNm, String custCntCd, String custSeq, String ownrNm
	 * @return 
	 */
	public SearchContractByCharterVO(String ibflag, String pagerows, String fletCtrtNo, String vslCd, String vslEngNm, String fletCtrtTpCd, String vndrLglEngNm, String custCntCd, String custSeq, String ownrNm) {
		this.vslCd = vslCd;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.fletCtrtTpCd = fletCtrtTpCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.ownrNm = ownrNm;
		this.custSeq = custSeq;
		this.custCntCd = custCntCd;
		this.fletCtrtNo = fletCtrtNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("flet_ctrt_tp_cd", getFletCtrtTpCd());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("ownr_nm", getOwnrNm());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("flet_ctrt_tp_cd", "fletCtrtTpCd");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getVslCd() {
		return this.vslCd;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	public String getFletCtrtTpCd() {
		return this.fletCtrtTpCd;
	}
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	public String getOwnrNm() {
		return this.ownrNm;
	}
	public String getCustSeq() {
		return this.custSeq;
	}
	public String getCustCntCd() {
		return this.custCntCd;
	}
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
		//this.vslEngNm=true;
	}
	public void setFletCtrtTpCd(String fletCtrtTpCd) {
		this.fletCtrtTpCd = fletCtrtTpCd;
		//this.fletCtrtTpCd=true;
	}
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
		//this.vndrLglEngNm=true;
	}
	public void setOwnrNm(String ownrNm) {
		this.ownrNm = ownrNm;
		//this.ownrNm=true;
	}
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
		//this.custSeq=true;
	}
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
		//this.custCntCd=true;
	}
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
		//this.fletCtrtNo=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setFletCtrtTpCd(JSPUtil.getParameter(request, "flet_ctrt_tp_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setOwnrNm(JSPUtil.getParameter(request, "ownr_nm", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public SearchContractByCharterVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchContractByCharterVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchContractByCharterVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm".trim(), length));
			String[] fletCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_tp_cd".trim(), length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm".trim(), length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd".trim(), length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchContractByCharterVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (fletCtrtTpCd[i] != null)
					model.setFletCtrtTpCd(fletCtrtTpCd[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (ownrNm[i] != null)
					model.setOwnrNm(ownrNm[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchContractByCharterVOs();
	}

	public SearchContractByCharterVO[] getSearchContractByCharterVOs(){
		SearchContractByCharterVO[] vos = (SearchContractByCharterVO[])models.toArray(new SearchContractByCharterVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtTpCd = this.fletCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
