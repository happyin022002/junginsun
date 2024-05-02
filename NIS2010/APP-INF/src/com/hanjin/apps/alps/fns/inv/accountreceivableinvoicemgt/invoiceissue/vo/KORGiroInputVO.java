/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KORGiroInputVO.java
*@FileTitle : KORGiroInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.04.28 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

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
 * @author 정휘택
 * @since J2EE 1.5
 */

public class KORGiroInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KORGiroInputVO> models = new ArrayList<KORGiroInputVO>();
	
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String totGiroAmt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String giroNo = null;
	/* Column Info */
	private String splGiroAmt = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String tvaGiroAmt = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String arOfcCd2 = null;
	
	/* Column Info */
	private String issDt1 = null;
	/* Column Info */
	private String issDt2 = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custCntCd = null;
	
	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KORGiroInputVO() {}

	public KORGiroInputVO(String ibflag, String pagerows, String arOfcCd, String custCd, String issDt, String blSrcNo, String splGiroAmt, String totGiroAmt, String dueDt, String custLglEngNm, String vvd, String giroNo, String tvaGiroAmt, String deltFlg, String issDt1, String issDt2, String custSeq, String custCntCd, String arOfcCd2) {
		this.custCd = custCd;
		this.blSrcNo = blSrcNo;
		this.ibflag = ibflag;
		this.custLglEngNm = custLglEngNm;
		this.totGiroAmt = totGiroAmt;
		this.vvd = vvd;
		this.giroNo = giroNo;
		this.splGiroAmt = splGiroAmt;
		this.dueDt = dueDt;
		this.tvaGiroAmt = tvaGiroAmt;
		this.issDt = issDt;
		this.deltFlg = deltFlg;
		this.pagerows = pagerows;
		this.arOfcCd = arOfcCd;
		this.arOfcCd2 = arOfcCd2;
		this.issDt1 = issDt1;
		this.issDt2 = issDt2;
		this.custSeq = custSeq;
		this.custCntCd = custCntCd;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("tot_giro_amt", getTotGiroAmt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("giro_no", getGiroNo());
		this.hashColumns.put("spl_giro_amt", getSplGiroAmt());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("tva_giro_amt", getTvaGiroAmt());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("ar_ofc_cd2", getArOfcCd2());
		this.hashColumns.put("iss_dt1", getIssDt1());
		this.hashColumns.put("iss_dt2", getIssDt2());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("tot_giro_amt", "totGiroAmt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("giro_no", "giroNo");
		this.hashFields.put("spl_giro_amt", "splGiroAmt");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("tva_giro_amt", "tvaGiroAmt");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("ar_ofc_cd2", "arOfcCd2");
		this.hashFields.put("iss_dt1", "issDt1");
		this.hashFields.put("iss_dt2", "issDt2");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		
		return this.hashFields;
	}
	
	public String getCustCd() {
		return this.custCd;
	}
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	public String getTotGiroAmt() {
		return this.totGiroAmt;
	}
	public String getVvd() {
		return this.vvd;
	}
	public String getGiroNo() {
		return this.giroNo;
	}
	public String getSplGiroAmt() {
		return this.splGiroAmt;
	}
	public String getDueDt() {
		return this.dueDt;
	}
	public String getTvaGiroAmt() {
		return this.tvaGiroAmt;
	}
	public String getIssDt() {
		return this.issDt;
	}
	public String getDeltFlg() {
		return this.deltFlg;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getArOfcCd() {
		return this.arOfcCd;
	}

	public void setCustCd(String custCd) {
		this.custCd = custCd;
		//this.custCd=true;
	}
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
		//this.blSrcNo=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
		//this.custLglEngNm=true;
	}
	public void setTotGiroAmt(String totGiroAmt) {
		this.totGiroAmt = totGiroAmt;
		//this.totGiroAmt=true;
	}
	public void setVvd(String vvd) {
		this.vvd = vvd;
		//this.vvd=true;
	}
	public void setGiroNo(String giroNo) {
		this.giroNo = giroNo;
		//this.giroNo=true;
	}
	public void setSplGiroAmt(String splGiroAmt) {
		this.splGiroAmt = splGiroAmt;
		//this.splGiroAmt=true;
	}
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
		//this.dueDt=true;
	}
	public void setTvaGiroAmt(String tvaGiroAmt) {
		this.tvaGiroAmt = tvaGiroAmt;
		//this.tvaGiroAmt=true;
	}
	public void setIssDt(String issDt) {
		this.issDt = issDt;
		//this.issDt=true;
	}
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
		//this.deltFlg=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
		//this.arOfcCd=true;
	}
		
	/**
	 * @return the issDt1
	 */
	public String getIssDt1() {
		return issDt1;
	}

	/**
	 * @param issDt1 the issDt1 to set
	 */
	public void setIssDt1(String issDt1) {
		this.issDt1 = issDt1;
	}

	/**
	 * @return the issDt2
	 */
	public String getIssDt2() {
		return issDt2;
	}

	/**
	 * @param issDt2 the issDt2 to set
	 */
	public void setIssDt2(String issDt2) {
		this.issDt2 = issDt2;
	}

	/**
	 * @return the custSeq
	 */
	public String getCustSeq() {
		return custSeq;
	}

	/**
	 * @param custSeq the custSeq to set
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	/**
	 * @return the custCntCd
	 */
	public String getCustCntCd() {
		return custCntCd;
	}

	/**
	 * @param custCntCd the custCntCd to set
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	/**
	 * @return the arOfcCd2
	 */
	public String getArOfcCd2() {
		return arOfcCd2;
	}

	/**
	 * @param arOfcCd2 the arOfcCd2 to set
	 */
	public void setArOfcCd2(String arOfcCd2) {
		this.arOfcCd2 = arOfcCd2;
	}

	public void fromRequest(HttpServletRequest request) {
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, "cust_lgl_eng_nm", ""));
		setTotGiroAmt(JSPUtil.getParameter(request, "tot_giro_amt", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setGiroNo(JSPUtil.getParameter(request, "giro_no", ""));
		setSplGiroAmt(JSPUtil.getParameter(request, "spl_giro_amt", ""));
		setDueDt(JSPUtil.getParameter(request, "due_dt", ""));
		setTvaGiroAmt(JSPUtil.getParameter(request, "tva_giro_amt", ""));
		setIssDt(JSPUtil.getParameter(request, "iss_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setArOfcCd2(JSPUtil.getParameter(request, "ar_ofc_cd2", ""));
		setIssDt1(JSPUtil.getParameter(request, "iss_dt1", ""));
		setIssDt2(JSPUtil.getParameter(request, "iss_dt2", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
	}

	public KORGiroInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public KORGiroInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KORGiroInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd".trim(), length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm".trim(), length));
			String[] totGiroAmt = (JSPUtil.getParameter(request, prefix	+ "tot_giro_amt".trim(), length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] giroNo = (JSPUtil.getParameter(request, prefix	+ "giro_no".trim(), length));
			String[] splGiroAmt = (JSPUtil.getParameter(request, prefix	+ "spl_giro_amt".trim(), length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt".trim(), length));
			String[] tvaGiroAmt = (JSPUtil.getParameter(request, prefix	+ "tva_giro_amt".trim(), length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt".trim(), length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd".trim(), length));
			String[] arOfcCd2 = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd2".trim(), length));
			String[] issDt1 = (JSPUtil.getParameter(request, prefix	+ "iss_dt1".trim(), length));
			String[] issDt2 = (JSPUtil.getParameter(request, prefix	+ "iss_dt2".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd".trim(), length));
						
			for (int i = 0; i < length; i++) {
				model = new KORGiroInputVO();
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (totGiroAmt[i] != null)
					model.setTotGiroAmt(totGiroAmt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (giroNo[i] != null)
					model.setGiroNo(giroNo[i]);
				if (splGiroAmt[i] != null)
					model.setSplGiroAmt(splGiroAmt[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (tvaGiroAmt[i] != null)
					model.setTvaGiroAmt(tvaGiroAmt[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (arOfcCd2[i] != null)
					model.setArOfcCd2(arOfcCd2[i]);
				if (issDt1[i] != null)
					model.setIssDt1(issDt1[i]);
				if (issDt2[i] != null)
					model.setIssDt2(issDt2[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getKORGiroInputVOs();
	}

	public KORGiroInputVO[] getKORGiroInputVOs(){
		KORGiroInputVO[] vos = (KORGiroInputVO[])models.toArray(new KORGiroInputVO[models.size()]);
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
	 * @exception IllegalAccessException
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
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totGiroAmt = this.totGiroAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.giroNo = this.giroNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splGiroAmt = this.splGiroAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvaGiroAmt = this.tvaGiroAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd2 = this.arOfcCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt1 = this.issDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt2 = this.issDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
