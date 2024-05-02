/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchBunkerInterfaceVO.java
*@FileTitle : SearchBunkerInterfaceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.06
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.06 정윤태
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo;

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
 * @see ESM_FMS_0050HTMLAction
 */

public class SearchBunkerInterfaceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBunkerInterfaceVO> models = new ArrayList<SearchBunkerInterfaceVO>();
	
	/* 而щ읆 �ㅻ챸 */
	private String acctItmNm = null;
	/* 而щ읆 �ㅻ챸 */
	private String vslCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String bunkerVvd = null;
	/* 而щ읆 �ㅻ챸 */
	private String fletMeasUtCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String skdVoyNo = null;
	/* 而щ읆 �ㅻ챸 */
	private String bnkPrcAmt = null;
	/* 而щ읆 �ㅻ챸 */
	private String totalAmt = null;
	/* 而щ읆 �ㅻ챸 */
	private String bnkYrmon = null;
	/* 而щ읆 �ㅻ챸 */
	private String bnkSeq = null;
	/* 而щ읆 �ㅻ챸 */
	private String bnkTpCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String bnkDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* 而щ읆 �ㅻ챸 */
	private String fletCtrtNo = null;
	/* 而щ읆 �ㅻ챸 */
	private String revDirCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String acctItmSeq = null;
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String acctCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String bnkQty = null;
	/* 而щ읆 �ㅻ챸 */
	private String portCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String ifDt = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public SearchBunkerInterfaceVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String fletCtrtNo, String bnkSeq, String bnkYrmon, String bnkTpCd, String acctCd, String acctItmSeq, String acctItmNm, String bnkDt, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String portCd, String totalAmt, String bunkerVvd, String fletMeasUtCd, String bnkQty, String bnkPrcAmt, String ifDt
	 * @return 
	 */
	public SearchBunkerInterfaceVO(String ibflag, String pagerows, String fletCtrtNo, String bnkSeq, String bnkYrmon, String bnkTpCd, String acctCd, String acctItmSeq, String acctItmNm, String bnkDt, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String portCd, String totalAmt, String bunkerVvd, String fletMeasUtCd, String bnkQty, String bnkPrcAmt, String ifDt) {
		this.acctItmNm = acctItmNm;
		this.vslCd = vslCd;
		this.bunkerVvd = bunkerVvd;
		this.fletMeasUtCd = fletMeasUtCd;
		this.skdVoyNo = skdVoyNo;
		this.bnkPrcAmt = bnkPrcAmt;
		this.totalAmt = totalAmt;
		this.bnkYrmon = bnkYrmon;
		this.bnkSeq = bnkSeq;
		this.bnkTpCd = bnkTpCd;
		this.bnkDt = bnkDt;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.fletCtrtNo = fletCtrtNo;
		this.revDirCd = revDirCd;
		this.acctItmSeq = acctItmSeq;
		this.ibflag = ibflag;
		this.acctCd = acctCd;
		this.bnkQty = bnkQty;
		this.portCd = portCd;
		this.ifDt = ifDt;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("acct_itm_nm", getAcctItmNm());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bunker_vvd", getBunkerVvd());
		this.hashColumns.put("flet_meas_ut_cd", getFletMeasUtCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("bnk_prc_amt", getBnkPrcAmt());
		this.hashColumns.put("total_amt", getTotalAmt());
		this.hashColumns.put("bnk_yrmon", getBnkYrmon());
		this.hashColumns.put("bnk_seq", getBnkSeq());
		this.hashColumns.put("bnk_tp_cd", getBnkTpCd());
		this.hashColumns.put("bnk_dt", getBnkDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("acct_itm_seq", getAcctItmSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("bnk_qty", getBnkQty());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("if_dt", getIfDt());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("acct_itm_nm", "acctItmNm");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bunker_vvd", "bunkerVvd");
		this.hashFields.put("flet_meas_ut_cd", "fletMeasUtCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("bnk_prc_amt", "bnkPrcAmt");
		this.hashFields.put("total_amt", "totalAmt");
		this.hashFields.put("bnk_yrmon", "bnkYrmon");
		this.hashFields.put("bnk_seq", "bnkSeq");
		this.hashFields.put("bnk_tp_cd", "bnkTpCd");
		this.hashFields.put("bnk_dt", "bnkDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("acct_itm_seq", "acctItmSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("bnk_qty", "bnkQty");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("if_dt", "ifDt");
		return this.hashFields;
	}
	
	public String getAcctItmNm() {
		return this.acctItmNm;
	}
	public String getVslCd() {
		return this.vslCd;
	}
	public String getBunkerVvd() {
		return this.bunkerVvd;
	}
	public String getFletMeasUtCd() {
		return this.fletMeasUtCd;
	}
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	public String getBnkPrcAmt() {
		return this.bnkPrcAmt;
	}
	public String getTotalAmt() {
		return this.totalAmt;
	}
	public String getBnkYrmon() {
		return this.bnkYrmon;
	}
	public String getBnkSeq() {
		return this.bnkSeq;
	}
	public String getBnkTpCd() {
		return this.bnkTpCd;
	}
	public String getBnkDt() {
		return this.bnkDt;
	}
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
	}
	public String getRevDirCd() {
		return this.revDirCd;
	}
	public String getAcctItmSeq() {
		return this.acctItmSeq;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getAcctCd() {
		return this.acctCd;
	}
	public String getBnkQty() {
		return this.bnkQty;
	}
	public String getPortCd() {
		return this.portCd;
	}
	public String getIfDt() {
		return this.ifDt;
	}

	public void setAcctItmNm(String acctItmNm) {
		this.acctItmNm = acctItmNm;
		//this.acctItmNm=true;
	}
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	public void setBunkerVvd(String bunkerVvd) {
		this.bunkerVvd = bunkerVvd;
		//this.bunkerVvd=true;
	}
	public void setFletMeasUtCd(String fletMeasUtCd) {
		this.fletMeasUtCd = fletMeasUtCd;
		//this.fletMeasUtCd=true;
	}
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
		//this.skdVoyNo=true;
	}
	public void setBnkPrcAmt(String bnkPrcAmt) {
		this.bnkPrcAmt = bnkPrcAmt;
		//this.bnkPrcAmt=true;
	}
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
		//this.totalAmt=true;
	}
	public void setBnkYrmon(String bnkYrmon) {
		this.bnkYrmon = bnkYrmon;
		//this.bnkYrmon=true;
	}
	public void setBnkSeq(String bnkSeq) {
		this.bnkSeq = bnkSeq;
		//this.bnkSeq=true;
	}
	public void setBnkTpCd(String bnkTpCd) {
		this.bnkTpCd = bnkTpCd;
		//this.bnkTpCd=true;
	}
	public void setBnkDt(String bnkDt) {
		this.bnkDt = bnkDt;
		//this.bnkDt=true;
	}
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
		//this.skdDirCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
		//this.fletCtrtNo=true;
	}
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
		//this.revDirCd=true;
	}
	public void setAcctItmSeq(String acctItmSeq) {
		this.acctItmSeq = acctItmSeq;
		//this.acctItmSeq=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
		//this.acctCd=true;
	}
	public void setBnkQty(String bnkQty) {
		this.bnkQty = bnkQty;
		//this.bnkQty=true;
	}
	public void setPortCd(String portCd) {
		this.portCd = portCd;
		//this.portCd=true;
	}
	public void setIfDt(String ifDt) {
		this.ifDt = ifDt;
		//this.ifDt=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setAcctItmNm(JSPUtil.getParameter(request, "acct_itm_nm", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setBunkerVvd(JSPUtil.getParameter(request, "bunker_vvd", ""));
		setFletMeasUtCd(JSPUtil.getParameter(request, "flet_meas_ut_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setBnkPrcAmt(JSPUtil.getParameter(request, "bnk_prc_amt", ""));
		setTotalAmt(JSPUtil.getParameter(request, "total_amt", ""));
		setBnkYrmon(JSPUtil.getParameter(request, "bnk_yrmon", ""));
		setBnkSeq(JSPUtil.getParameter(request, "bnk_seq", ""));
		setBnkTpCd(JSPUtil.getParameter(request, "bnk_tp_cd", ""));
		setBnkDt(JSPUtil.getParameter(request, "bnk_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setRevDirCd(JSPUtil.getParameter(request, "rev_dir_cd", ""));
		setAcctItmSeq(JSPUtil.getParameter(request, "acct_itm_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setBnkQty(JSPUtil.getParameter(request, "bnk_qty", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setIfDt(JSPUtil.getParameter(request, "if_dt", ""));
	}

	public SearchBunkerInterfaceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchBunkerInterfaceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBunkerInterfaceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] acctItmNm = (JSPUtil.getParameter(request, prefix	+ "acct_itm_nm".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] bunkerVvd = (JSPUtil.getParameter(request, prefix	+ "bunker_vvd".trim(), length));
			String[] fletMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "flet_meas_ut_cd".trim(), length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no".trim(), length));
			String[] bnkPrcAmt = (JSPUtil.getParameter(request, prefix	+ "bnk_prc_amt".trim(), length));
			String[] totalAmt = (JSPUtil.getParameter(request, prefix	+ "total_amt".trim(), length));
			String[] bnkYrmon = (JSPUtil.getParameter(request, prefix	+ "bnk_yrmon".trim(), length));
			String[] bnkSeq = (JSPUtil.getParameter(request, prefix	+ "bnk_seq".trim(), length));
			String[] bnkTpCd = (JSPUtil.getParameter(request, prefix	+ "bnk_tp_cd".trim(), length));
			String[] bnkDt = (JSPUtil.getParameter(request, prefix	+ "bnk_dt".trim(), length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no".trim(), length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd".trim(), length));
			String[] acctItmSeq = (JSPUtil.getParameter(request, prefix	+ "acct_itm_seq".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd".trim(), length));
			String[] bnkQty = (JSPUtil.getParameter(request, prefix	+ "bnk_qty".trim(), length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd".trim(), length));
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBunkerInterfaceVO();
				if (acctItmNm[i] != null)
					model.setAcctItmNm(acctItmNm[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (bunkerVvd[i] != null)
					model.setBunkerVvd(bunkerVvd[i]);
				if (fletMeasUtCd[i] != null)
					model.setFletMeasUtCd(fletMeasUtCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (bnkPrcAmt[i] != null)
					model.setBnkPrcAmt(bnkPrcAmt[i]);
				if (totalAmt[i] != null)
					model.setTotalAmt(totalAmt[i]);
				if (bnkYrmon[i] != null)
					model.setBnkYrmon(bnkYrmon[i]);
				if (bnkSeq[i] != null)
					model.setBnkSeq(bnkSeq[i]);
				if (bnkTpCd[i] != null)
					model.setBnkTpCd(bnkTpCd[i]);
				if (bnkDt[i] != null)
					model.setBnkDt(bnkDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (acctItmSeq[i] != null)
					model.setAcctItmSeq(acctItmSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (bnkQty[i] != null)
					model.setBnkQty(bnkQty[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchBunkerInterfaceVOs();
	}

	public SearchBunkerInterfaceVO[] getSearchBunkerInterfaceVOs(){
		SearchBunkerInterfaceVO[] vos = (SearchBunkerInterfaceVO[])models.toArray(new SearchBunkerInterfaceVO[models.size()]);
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
		this.acctItmNm = this.acctItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bunkerVvd = this.bunkerVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletMeasUtCd = this.fletMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkPrcAmt = this.bnkPrcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAmt = this.totalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkYrmon = this.bnkYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkSeq = this.bnkSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkTpCd = this.bnkTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkDt = this.bnkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctItmSeq = this.acctItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkQty = this.bnkQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifDt = this.ifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
