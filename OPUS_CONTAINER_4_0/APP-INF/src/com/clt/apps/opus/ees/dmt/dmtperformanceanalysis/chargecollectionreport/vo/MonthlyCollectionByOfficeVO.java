/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MonthlyCollectionByOfficeVO.java
*@FileTitle : MonthlyCollectionByOfficeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.11.10 황효근 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo;

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
 * @author 황효근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MonthlyCollectionByOfficeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MonthlyCollectionByOfficeVO> models = new ArrayList<MonthlyCollectionByOfficeVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String collAmt = null;
	/* Column Info */
	private String invCntr = null;
	/* Column Info */
	private String invMCntr = null;
	/* Column Info */
	private String ioBnd = null;
	/* Column Info */
	private String billAmt = null;
	/* Column Info */
	private String collOthAmt = null;
	/* Column Info */
	private String collCntr = null;
	/* Column Info */
	private String invMAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String collMCntr = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String collMAmt = null;
	/* Column Info */
	private String tariff = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String billCntr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MonthlyCollectionByOfficeVO() {}

	public MonthlyCollectionByOfficeVO(String ibflag, String pagerows, String ofcCd, String tariff, String ioBnd, String currCd, String billCntr, String billAmt, String invCntr, String invAmt, String invMCntr, String invMAmt, String collCntr, String collAmt, String collMCntr, String collMAmt, String collOthAmt) {
		this.currCd = currCd;
		this.collAmt = collAmt;
		this.invCntr = invCntr;
		this.invMCntr = invMCntr;
		this.ioBnd = ioBnd;
		this.billAmt = billAmt;
		this.collOthAmt = collOthAmt;
		this.collCntr = collCntr;
		this.invMAmt = invMAmt;
		this.pagerows = pagerows;
		this.collMCntr = collMCntr;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.collMAmt = collMAmt;
		this.tariff = tariff;
		this.invAmt = invAmt;
		this.billCntr = billCntr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("coll_amt", getCollAmt());
		this.hashColumns.put("inv_cntr", getInvCntr());
		this.hashColumns.put("inv_m_cntr", getInvMCntr());
		this.hashColumns.put("io_bnd", getIoBnd());
		this.hashColumns.put("bill_amt", getBillAmt());
		this.hashColumns.put("coll_oth_amt", getCollOthAmt());
		this.hashColumns.put("coll_cntr", getCollCntr());
		this.hashColumns.put("inv_m_amt", getInvMAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("coll_m_cntr", getCollMCntr());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("coll_m_amt", getCollMAmt());
		this.hashColumns.put("tariff", getTariff());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("bill_cntr", getBillCntr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("coll_amt", "collAmt");
		this.hashFields.put("inv_cntr", "invCntr");
		this.hashFields.put("inv_m_cntr", "invMCntr");
		this.hashFields.put("io_bnd", "ioBnd");
		this.hashFields.put("bill_amt", "billAmt");
		this.hashFields.put("coll_oth_amt", "collOthAmt");
		this.hashFields.put("coll_cntr", "collCntr");
		this.hashFields.put("inv_m_amt", "invMAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("coll_m_cntr", "collMCntr");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("coll_m_amt", "collMAmt");
		this.hashFields.put("tariff", "tariff");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("bill_cntr", "billCntr");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return collAmt
	 */
	public String getCollAmt() {
		return this.collAmt;
	}
	
	/**
	 * Column Info
	 * @return invCntr
	 */
	public String getInvCntr() {
		return this.invCntr;
	}
	
	/**
	 * Column Info
	 * @return invMCntr
	 */
	public String getInvMCntr() {
		return this.invMCntr;
	}
	
	/**
	 * Column Info
	 * @return ioBnd
	 */
	public String getIoBnd() {
		return this.ioBnd;
	}
	
	/**
	 * Column Info
	 * @return billAmt
	 */
	public String getBillAmt() {
		return this.billAmt;
	}
	
	/**
	 * Column Info
	 * @return collOthAmt
	 */
	public String getCollOthAmt() {
		return this.collOthAmt;
	}
	
	/**
	 * Column Info
	 * @return collCntr
	 */
	public String getCollCntr() {
		return this.collCntr;
	}
	
	/**
	 * Column Info
	 * @return invMAmt
	 */
	public String getInvMAmt() {
		return this.invMAmt;
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
	 * @return collMCntr
	 */
	public String getCollMCntr() {
		return this.collMCntr;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return collMAmt
	 */
	public String getCollMAmt() {
		return this.collMAmt;
	}
	
	/**
	 * Column Info
	 * @return tariff
	 */
	public String getTariff() {
		return this.tariff;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return billCntr
	 */
	public String getBillCntr() {
		return this.billCntr;
	}
	

	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param collAmt
	 */
	public void setCollAmt(String collAmt) {
		this.collAmt = collAmt;
	}
	
	/**
	 * Column Info
	 * @param invCntr
	 */
	public void setInvCntr(String invCntr) {
		this.invCntr = invCntr;
	}
	
	/**
	 * Column Info
	 * @param invMCntr
	 */
	public void setInvMCntr(String invMCntr) {
		this.invMCntr = invMCntr;
	}
	
	/**
	 * Column Info
	 * @param ioBnd
	 */
	public void setIoBnd(String ioBnd) {
		this.ioBnd = ioBnd;
	}
	
	/**
	 * Column Info
	 * @param billAmt
	 */
	public void setBillAmt(String billAmt) {
		this.billAmt = billAmt;
	}
	
	/**
	 * Column Info
	 * @param collOthAmt
	 */
	public void setCollOthAmt(String collOthAmt) {
		this.collOthAmt = collOthAmt;
	}
	
	/**
	 * Column Info
	 * @param collCntr
	 */
	public void setCollCntr(String collCntr) {
		this.collCntr = collCntr;
	}
	
	/**
	 * Column Info
	 * @param invMAmt
	 */
	public void setInvMAmt(String invMAmt) {
		this.invMAmt = invMAmt;
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
	 * @param collMCntr
	 */
	public void setCollMCntr(String collMCntr) {
		this.collMCntr = collMCntr;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param collMAmt
	 */
	public void setCollMAmt(String collMAmt) {
		this.collMAmt = collMAmt;
	}
	
	/**
	 * Column Info
	 * @param tariff
	 */
	public void setTariff(String tariff) {
		this.tariff = tariff;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param billCntr
	 */
	public void setBillCntr(String billCntr) {
		this.billCntr = billCntr;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setCollAmt(JSPUtil.getParameter(request, "coll_amt", ""));
		setInvCntr(JSPUtil.getParameter(request, "inv_cntr", ""));
		setInvMCntr(JSPUtil.getParameter(request, "inv_m_cntr", ""));
		setIoBnd(JSPUtil.getParameter(request, "io_bnd", ""));
		setBillAmt(JSPUtil.getParameter(request, "bill_amt", ""));
		setCollOthAmt(JSPUtil.getParameter(request, "coll_oth_amt", ""));
		setCollCntr(JSPUtil.getParameter(request, "coll_cntr", ""));
		setInvMAmt(JSPUtil.getParameter(request, "inv_m_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCollMCntr(JSPUtil.getParameter(request, "coll_m_cntr", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCollMAmt(JSPUtil.getParameter(request, "coll_m_amt", ""));
		setTariff(JSPUtil.getParameter(request, "tariff", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setBillCntr(JSPUtil.getParameter(request, "bill_cntr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MonthlyCollectionByOfficeVO[]
	 */
	public MonthlyCollectionByOfficeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MonthlyCollectionByOfficeVO[]
	 */
	public MonthlyCollectionByOfficeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MonthlyCollectionByOfficeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] collAmt = (JSPUtil.getParameter(request, prefix	+ "coll_amt", length));
			String[] invCntr = (JSPUtil.getParameter(request, prefix	+ "inv_cntr", length));
			String[] invMCntr = (JSPUtil.getParameter(request, prefix	+ "inv_m_cntr", length));
			String[] ioBnd = (JSPUtil.getParameter(request, prefix	+ "io_bnd", length));
			String[] billAmt = (JSPUtil.getParameter(request, prefix	+ "bill_amt", length));
			String[] collOthAmt = (JSPUtil.getParameter(request, prefix	+ "coll_oth_amt", length));
			String[] collCntr = (JSPUtil.getParameter(request, prefix	+ "coll_cntr", length));
			String[] invMAmt = (JSPUtil.getParameter(request, prefix	+ "inv_m_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] collMCntr = (JSPUtil.getParameter(request, prefix	+ "coll_m_cntr", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] collMAmt = (JSPUtil.getParameter(request, prefix	+ "coll_m_amt", length));
			String[] tariff = (JSPUtil.getParameter(request, prefix	+ "tariff", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] billCntr = (JSPUtil.getParameter(request, prefix	+ "bill_cntr", length));
			
			for (int i = 0; i < length; i++) {
				model = new MonthlyCollectionByOfficeVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (collAmt[i] != null)
					model.setCollAmt(collAmt[i]);
				if (invCntr[i] != null)
					model.setInvCntr(invCntr[i]);
				if (invMCntr[i] != null)
					model.setInvMCntr(invMCntr[i]);
				if (ioBnd[i] != null)
					model.setIoBnd(ioBnd[i]);
				if (billAmt[i] != null)
					model.setBillAmt(billAmt[i]);
				if (collOthAmt[i] != null)
					model.setCollOthAmt(collOthAmt[i]);
				if (collCntr[i] != null)
					model.setCollCntr(collCntr[i]);
				if (invMAmt[i] != null)
					model.setInvMAmt(invMAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (collMCntr[i] != null)
					model.setCollMCntr(collMCntr[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (collMAmt[i] != null)
					model.setCollMAmt(collMAmt[i]);
				if (tariff[i] != null)
					model.setTariff(tariff[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (billCntr[i] != null)
					model.setBillCntr(billCntr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMonthlyCollectionByOfficeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MonthlyCollectionByOfficeVO[]
	 */
	public MonthlyCollectionByOfficeVO[] getMonthlyCollectionByOfficeVOs(){
		MonthlyCollectionByOfficeVO[] vos = (MonthlyCollectionByOfficeVO[])models.toArray(new MonthlyCollectionByOfficeVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collAmt = this.collAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCntr = this.invCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invMCntr = this.invMCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBnd = this.ioBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billAmt = this.billAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collOthAmt = this.collOthAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collCntr = this.collCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invMAmt = this.invMAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collMCntr = this.collMCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collMAmt = this.collMAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tariff = this.tariff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billCntr = this.billCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
