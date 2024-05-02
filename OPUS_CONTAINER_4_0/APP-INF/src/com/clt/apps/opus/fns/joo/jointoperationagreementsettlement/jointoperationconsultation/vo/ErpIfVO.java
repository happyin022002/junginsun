/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ErpIfVO.java
*@FileTitle : ErpIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.19 박희동 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo;

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
 * @author 박희동
 * @since J2EE 1.5
 */

public class ErpIfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ErpIfVO> models = new ArrayList<ErpIfVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String rowno = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String ifErrRsn = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String issDt = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String vndrNo = null;
	/* Column Info */
	private String erpIfFlg = null;
	/* Column Info */
	private String aproFlg = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String invDt = null;
	/* Column Info */
	private String ftuUseCtnt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String loclAmt = null;
	/* Column Info */
	private String ifFlg = null;
	/* Column Info */
	private String slpNo = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String sailDt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String invTermDt = null;
	/* Column Info */
	private String csrAmt = null;
	/* Column Info */
	private String csrOffstNo = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ErpIfVO() {}

	public ErpIfVO(String ibflag, String pagerows, String rowno, String slpNo, String issDt, String sailDt, String dueDt, String rlaneCd, String vvd, String loclAmt, String blNo, String custSeq, String porCd, String csrOffstNo, String erpIfFlg, String csrNo, String invDt, String invTermDt, String glDt, String vndrNo, String csrAmt, String ftuUseCtnt, String aproFlg, String ifFlg, String ifErrRsn) {
		this.porCd = porCd;
		this.glDt = glDt;
		this.rowno = rowno;
		this.rlaneCd = rlaneCd;
		this.blNo = blNo;
		this.ifErrRsn = ifErrRsn;
		this.pagerows = pagerows;
		this.issDt = issDt;
		this.ibflag = ibflag;
		this.vndrNo = vndrNo;
		this.erpIfFlg = erpIfFlg;
		this.aproFlg = aproFlg;
		this.dueDt = dueDt;
		this.invDt = invDt;
		this.ftuUseCtnt = ftuUseCtnt;
		this.csrNo = csrNo;
		this.loclAmt = loclAmt;
		this.ifFlg = ifFlg;
		this.slpNo = slpNo;
		this.custSeq = custSeq;
		this.sailDt = sailDt;
		this.vvd = vvd;
		this.invTermDt = invTermDt;
		this.csrAmt = csrAmt;
		this.csrOffstNo = csrOffstNo;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("rowno", getRowno());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("if_err_rsn", getIfErrRsn());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_no", getVndrNo());
		this.hashColumns.put("erp_if_flg", getErpIfFlg());
		this.hashColumns.put("apro_flg", getAproFlg());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("inv_dt", getInvDt());
		this.hashColumns.put("ftu_use_ctnt", getFtuUseCtnt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("locl_amt", getLoclAmt());
		this.hashColumns.put("if_flg", getIfFlg());
		this.hashColumns.put("slp_no", getSlpNo());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("sail_dt", getSailDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("inv_term_dt", getInvTermDt());
		this.hashColumns.put("csr_amt", getCsrAmt());
		this.hashColumns.put("csr_offst_no", getCsrOffstNo());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("rowno", "rowno");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("if_err_rsn", "ifErrRsn");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("erp_if_flg", "erpIfFlg");
		this.hashFields.put("apro_flg", "aproFlg");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("ftu_use_ctnt", "ftuUseCtnt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("locl_amt", "loclAmt");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("slp_no", "slpNo");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("sail_dt", "sailDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("inv_term_dt", "invTermDt");
		this.hashFields.put("csr_amt", "csrAmt");
		this.hashFields.put("csr_offst_no", "csrOffstNo");
		return this.hashFields;
	}
	
	public String getPorCd() {
		return this.porCd;
	}
	public String getGlDt() {
		return this.glDt;
	}
	public String getRowno() {
		return this.rowno;
	}
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	public String getBlNo() {
		return this.blNo;
	}
	public String getIfErrRsn() {
		return this.ifErrRsn;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getIssDt() {
		return this.issDt;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getVndrNo() {
		return this.vndrNo;
	}
	public String getErpIfFlg() {
		return this.erpIfFlg;
	}
	public String getAproFlg() {
		return this.aproFlg;
	}
	public String getDueDt() {
		return this.dueDt;
	}
	public String getInvDt() {
		return this.invDt;
	}
	public String getFtuUseCtnt() {
		return this.ftuUseCtnt;
	}
	public String getCsrNo() {
		return this.csrNo;
	}
	public String getLoclAmt() {
		return this.loclAmt;
	}
	public String getIfFlg() {
		return this.ifFlg;
	}
	public String getSlpNo() {
		return this.slpNo;
	}
	public String getCustSeq() {
		return this.custSeq;
	}
	public String getSailDt() {
		return this.sailDt;
	}
	public String getVvd() {
		return this.vvd;
	}
	public String getInvTermDt() {
		return this.invTermDt;
	}
	public String getCsrAmt() {
		return this.csrAmt;
	}
	public String getCsrOffstNo() {
		return this.csrOffstNo;
	}

	public void setPorCd(String porCd) {
		this.porCd = porCd;
		//this.porCd=true;
	}
	public void setGlDt(String glDt) {
		this.glDt = glDt;
		//this.glDt=true;
	}
	public void setRowno(String rowno) {
		this.rowno = rowno;
		//this.rowno=true;
	}
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
		//this.rlaneCd=true;
	}
	public void setBlNo(String blNo) {
		this.blNo = blNo;
		//this.blNo=true;
	}
	public void setIfErrRsn(String ifErrRsn) {
		this.ifErrRsn = ifErrRsn;
		//this.ifErrRsn=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setIssDt(String issDt) {
		this.issDt = issDt;
		//this.issDt=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
		//this.vndrNo=true;
	}
	public void setErpIfFlg(String erpIfFlg) {
		this.erpIfFlg = erpIfFlg;
		//this.erpIfFlg=true;
	}
	public void setAproFlg(String aproFlg) {
		this.aproFlg = aproFlg;
		//this.aproFlg=true;
	}
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
		//this.dueDt=true;
	}
	public void setInvDt(String invDt) {
		this.invDt = invDt;
		//this.invDt=true;
	}
	public void setFtuUseCtnt(String ftuUseCtnt) {
		this.ftuUseCtnt = ftuUseCtnt;
		//this.ftuUseCtnt=true;
	}
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
		//this.csrNo=true;
	}
	public void setLoclAmt(String loclAmt) {
		this.loclAmt = loclAmt;
		//this.loclAmt=true;
	}
	public void setIfFlg(String ifFlg) {
		this.ifFlg = ifFlg;
		//this.ifFlg=true;
	}
	public void setSlpNo(String slpNo) {
		this.slpNo = slpNo;
		//this.slpNo=true;
	}
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
		//this.custSeq=true;
	}
	public void setSailDt(String sailDt) {
		this.sailDt = sailDt;
		//this.sailDt=true;
	}
	public void setVvd(String vvd) {
		this.vvd = vvd;
		//this.vvd=true;
	}
	public void setInvTermDt(String invTermDt) {
		this.invTermDt = invTermDt;
		//this.invTermDt=true;
	}
	public void setCsrAmt(String csrAmt) {
		this.csrAmt = csrAmt;
		//this.csrAmt=true;
	}
	public void setCsrOffstNo(String csrOffstNo) {
		this.csrOffstNo = csrOffstNo;
		//this.csrOffstNo=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setGlDt(JSPUtil.getParameter(request, "gl_dt", ""));
		setRowno(JSPUtil.getParameter(request, "rowno", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setIfErrRsn(JSPUtil.getParameter(request, "if_err_rsn", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIssDt(JSPUtil.getParameter(request, "iss_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVndrNo(JSPUtil.getParameter(request, "vndr_no", ""));
		setErpIfFlg(JSPUtil.getParameter(request, "erp_if_flg", ""));
		setAproFlg(JSPUtil.getParameter(request, "apro_flg", ""));
		setDueDt(JSPUtil.getParameter(request, "due_dt", ""));
		setInvDt(JSPUtil.getParameter(request, "inv_dt", ""));
		setFtuUseCtnt(JSPUtil.getParameter(request, "ftu_use_ctnt", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setLoclAmt(JSPUtil.getParameter(request, "locl_amt", ""));
		setIfFlg(JSPUtil.getParameter(request, "if_flg", ""));
		setSlpNo(JSPUtil.getParameter(request, "slp_no", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setSailDt(JSPUtil.getParameter(request, "sail_dt", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setInvTermDt(JSPUtil.getParameter(request, "inv_term_dt", ""));
		setCsrAmt(JSPUtil.getParameter(request, "csr_amt", ""));
		setCsrOffstNo(JSPUtil.getParameter(request, "csr_offst_no", ""));
	}

	public ErpIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public ErpIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ErpIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd".trim(), length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt".trim(), length));
			String[] rowno = (JSPUtil.getParameter(request, prefix	+ "rowno".trim(), length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] ifErrRsn = (JSPUtil.getParameter(request, prefix	+ "if_err_rsn".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no".trim(), length));
			String[] erpIfFlg = (JSPUtil.getParameter(request, prefix	+ "erp_if_flg".trim(), length));
			String[] aproFlg = (JSPUtil.getParameter(request, prefix	+ "apro_flg".trim(), length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt".trim(), length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt".trim(), length));
			String[] ftuUseCtnt = (JSPUtil.getParameter(request, prefix	+ "ftu_use_ctnt".trim(), length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no".trim(), length));
			String[] loclAmt = (JSPUtil.getParameter(request, prefix	+ "locl_amt".trim(), length));
			String[] ifFlg = (JSPUtil.getParameter(request, prefix	+ "if_flg".trim(), length));
			String[] slpNo = (JSPUtil.getParameter(request, prefix	+ "slp_no".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] sailDt = (JSPUtil.getParameter(request, prefix	+ "sail_dt".trim(), length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] invTermDt = (JSPUtil.getParameter(request, prefix	+ "inv_term_dt".trim(), length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt".trim(), length));
			String[] csrOffstNo = (JSPUtil.getParameter(request, prefix	+ "csr_offst_no".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ErpIfVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (rowno[i] != null)
					model.setRowno(rowno[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (ifErrRsn[i] != null)
					model.setIfErrRsn(ifErrRsn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				if (erpIfFlg[i] != null)
					model.setErpIfFlg(erpIfFlg[i]);
				if (aproFlg[i] != null)
					model.setAproFlg(aproFlg[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				if (ftuUseCtnt[i] != null)
					model.setFtuUseCtnt(ftuUseCtnt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (loclAmt[i] != null)
					model.setLoclAmt(loclAmt[i]);
				if (ifFlg[i] != null)
					model.setIfFlg(ifFlg[i]);
				if (slpNo[i] != null)
					model.setSlpNo(slpNo[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (sailDt[i] != null)
					model.setSailDt(sailDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (invTermDt[i] != null)
					model.setInvTermDt(invTermDt[i]);
				if (csrAmt[i] != null)
					model.setCsrAmt(csrAmt[i]);
				if (csrOffstNo[i] != null)
					model.setCsrOffstNo(csrOffstNo[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getErpIfVOs();
	}

	public ErpIfVO[] getErpIfVOs(){
		ErpIfVO[] vos = (ErpIfVO[])models.toArray(new ErpIfVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowno = this.rowno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifErrRsn = this.ifErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpIfFlg = this.erpIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFlg = this.aproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftuUseCtnt = this.ftuUseCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAmt = this.loclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg = this.ifFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpNo = this.slpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailDt = this.sailDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTermDt = this.invTermDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrOffstNo = this.csrOffstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
