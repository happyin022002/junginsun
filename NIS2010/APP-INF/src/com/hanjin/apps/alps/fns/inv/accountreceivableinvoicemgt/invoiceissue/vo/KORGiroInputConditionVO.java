/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KORGiroInputConditionVO.java
*@FileTitle : KORGiroInputConditionVO
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

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 정휘택
 * @since J2EE 1.5
 */

public class KORGiroInputConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KORGiroInputConditionVO> models = new ArrayList<KORGiroInputConditionVO>();
	
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String issDt1 = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custCntCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String issDt2 = null;
	/* Column Info */
	private String giroNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String arOfcCd = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KORGiroInputConditionVO() {}

	public KORGiroInputConditionVO(String ibflag, String pagerows, String arOfcCd, String blSrcNo, String giroNo, String issDt1, String issDt2, String custCntCd, String custSeq) {
		this.blSrcNo = blSrcNo;
		this.issDt1 = issDt1;
		this.custSeq = custSeq;
		this.custCntCd = custCntCd;
		this.ibflag = ibflag;
		this.issDt2 = issDt2;
		this.giroNo = giroNo;
		this.pagerows = pagerows;
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("iss_dt1", getIssDt1());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("iss_dt2", getIssDt2());
		this.hashColumns.put("giro_no", getGiroNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ar_ofc_cd2", getArOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("iss_dt1", "issDt1");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("iss_dt2", "issDt2");
		this.hashFields.put("giro_no", "giroNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ar_ofc_cd2", "arOfcCd");
		return this.hashFields;
	}
	
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	public String getIssDt1() {
		return this.issDt1;
	}
	public String getCustSeq() {
		return this.custSeq;
	}
	public String getCustCntCd() {
		return this.custCntCd;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getIssDt2() {
		return this.issDt2;
	}
	public String getGiroNo() {
		return this.giroNo;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getArOfcCd() {
		return this.arOfcCd;
	}

	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
		//this.blSrcNo=true;
	}
	public void setIssDt1(String issDt1) {
		this.issDt1 = issDt1;
		//this.issDt1=true;
	}
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
		//this.custSeq=true;
	}
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
		//this.custCntCd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setIssDt2(String issDt2) {
		this.issDt2 = issDt2;
		//this.issDt2=true;
	}
	public void setGiroNo(String giroNo) {
		this.giroNo = giroNo;
		//this.giroNo=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
		//this.arOfcCd=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setIssDt1(JSPUtil.getParameter(request, "iss_dt1", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIssDt2(JSPUtil.getParameter(request, "iss_dt2", ""));
		setGiroNo(JSPUtil.getParameter(request, "giro_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd2", ""));
	}

	public KORGiroInputConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public KORGiroInputConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KORGiroInputConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no".trim(), length));
			String[] issDt1 = (JSPUtil.getParameter(request, prefix	+ "iss_dt1".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] issDt2 = (JSPUtil.getParameter(request, prefix	+ "iss_dt2".trim(), length));
			String[] giroNo = (JSPUtil.getParameter(request, prefix	+ "giro_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd2".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new KORGiroInputConditionVO();
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (issDt1[i] != null)
					model.setIssDt1(issDt1[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (issDt2[i] != null)
					model.setIssDt2(issDt2[i]);
				if (giroNo[i] != null)
					model.setGiroNo(giroNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getKORGiroInputConditionVOs();
	}

	public KORGiroInputConditionVO[] getKORGiroInputConditionVOs(){
		KORGiroInputConditionVO[] vos = (KORGiroInputConditionVO[])models.toArray(new KORGiroInputConditionVO[models.size()]);
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
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt1 = this.issDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		//System.out.println(" ########## this.issDt1 = "+this.issDt1);
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt2 = this.issDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.giroNo = this.giroNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
