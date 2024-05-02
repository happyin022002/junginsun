/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CollectionSummaryReportByOfficeVO.java
*@FileTitle : CollectionSummaryReportByOfficeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.22 황효근 
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

public class CollectionSummaryReportByOfficeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CollectionSummaryReportByOfficeVO> models = new ArrayList<CollectionSummaryReportByOfficeVO>();
	
	/* Column Info */
	private String incrCntr = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String exptCntr = null;
	/* Column Info */
	private String collAmt = null;
	/* Column Info */
	private String cmdtAmt = null;
	/* Column Info */
	private String exptAmt = null;
	/* Column Info */
	private String invCntr = null;
	/* Column Info */
	private String incrAmt = null;
	/* Column Info */
	private String billAmt = null;
	/* Column Info */
	private String collCntr = null;
	/* Column Info */
	private String collRtoC = null;
	/* Column Info */
	private String collRtoB = null;
	/* Column Info */
	private String collRtoA = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String dcAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCntr = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String ttlCntr = null;
	/* Column Info */
	private String billCntr = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String dcCntr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CollectionSummaryReportByOfficeVO() {}

	public CollectionSummaryReportByOfficeVO(String ibflag, String pagerows, String ofcCd, String dmdtTrfCd, String ttlCntr, String currCd, String incrCntr, String incrAmt, String cmdtCntr, String cmdtAmt, String exptCntr, String exptAmt, String dcCntr, String dcAmt, String billCntr, String billAmt, String invCntr, String invAmt, String collCntr, String collAmt, String collRtoA, String collRtoB, String collRtoC) {
		this.incrCntr = incrCntr;
		this.currCd = currCd;
		this.exptCntr = exptCntr;
		this.collAmt = collAmt;
		this.cmdtAmt = cmdtAmt;
		this.exptAmt = exptAmt;
		this.invCntr = invCntr;
		this.incrAmt = incrAmt;
		this.billAmt = billAmt;
		this.collCntr = collCntr;
		this.collRtoC = collRtoC;
		this.collRtoB = collRtoB;
		this.collRtoA = collRtoA;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.dcAmt = dcAmt;
		this.ibflag = ibflag;
		this.cmdtCntr = cmdtCntr;
		this.invAmt = invAmt;
		this.ttlCntr = ttlCntr;
		this.billCntr = billCntr;
		this.dmdtTrfCd = dmdtTrfCd;
		this.dcCntr = dcCntr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("incr_cntr", getIncrCntr());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("expt_cntr", getExptCntr());
		this.hashColumns.put("coll_amt", getCollAmt());
		this.hashColumns.put("cmdt_amt", getCmdtAmt());
		this.hashColumns.put("expt_amt", getExptAmt());
		this.hashColumns.put("inv_cntr", getInvCntr());
		this.hashColumns.put("incr_amt", getIncrAmt());
		this.hashColumns.put("bill_amt", getBillAmt());
		this.hashColumns.put("coll_cntr", getCollCntr());
		this.hashColumns.put("coll_rto_c", getCollRtoC());
		this.hashColumns.put("coll_rto_b", getCollRtoB());
		this.hashColumns.put("coll_rto_a", getCollRtoA());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("dc_amt", getDcAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cntr", getCmdtCntr());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("ttl_cntr", getTtlCntr());
		this.hashColumns.put("bill_cntr", getBillCntr());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("dc_cntr", getDcCntr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("incr_cntr", "incrCntr");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("expt_cntr", "exptCntr");
		this.hashFields.put("coll_amt", "collAmt");
		this.hashFields.put("cmdt_amt", "cmdtAmt");
		this.hashFields.put("expt_amt", "exptAmt");
		this.hashFields.put("inv_cntr", "invCntr");
		this.hashFields.put("incr_amt", "incrAmt");
		this.hashFields.put("bill_amt", "billAmt");
		this.hashFields.put("coll_cntr", "collCntr");
		this.hashFields.put("coll_rto_c", "collRtoC");
		this.hashFields.put("coll_rto_b", "collRtoB");
		this.hashFields.put("coll_rto_a", "collRtoA");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("dc_amt", "dcAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cntr", "cmdtCntr");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("ttl_cntr", "ttlCntr");
		this.hashFields.put("bill_cntr", "billCntr");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("dc_cntr", "dcCntr");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return incrCntr
	 */
	public String getIncrCntr() {
		return this.incrCntr;
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
	 * @return exptCntr
	 */
	public String getExptCntr() {
		return this.exptCntr;
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
	 * @return cmdtAmt
	 */
	public String getCmdtAmt() {
		return this.cmdtAmt;
	}
	
	/**
	 * Column Info
	 * @return exptAmt
	 */
	public String getExptAmt() {
		return this.exptAmt;
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
	 * @return incrAmt
	 */
	public String getIncrAmt() {
		return this.incrAmt;
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
	 * @return collCntr
	 */
	public String getCollCntr() {
		return this.collCntr;
	}
	
	/**
	 * Column Info
	 * @return collRtoC
	 */
	public String getCollRtoC() {
		return this.collRtoC;
	}
	
	/**
	 * Column Info
	 * @return collRtoB
	 */
	public String getCollRtoB() {
		return this.collRtoB;
	}
	
	/**
	 * Column Info
	 * @return collRtoA
	 */
	public String getCollRtoA() {
		return this.collRtoA;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return dcAmt
	 */
	public String getDcAmt() {
		return this.dcAmt;
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
	 * @return cmdtCntr
	 */
	public String getCmdtCntr() {
		return this.cmdtCntr;
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
	 * @return ttlCntr
	 */
	public String getTtlCntr() {
		return this.ttlCntr;
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
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return dcCntr
	 */
	public String getDcCntr() {
		return this.dcCntr;
	}
	

	/**
	 * Column Info
	 * @param incrCntr
	 */
	public void setIncrCntr(String incrCntr) {
		this.incrCntr = incrCntr;
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
	 * @param exptCntr
	 */
	public void setExptCntr(String exptCntr) {
		this.exptCntr = exptCntr;
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
	 * @param cmdtAmt
	 */
	public void setCmdtAmt(String cmdtAmt) {
		this.cmdtAmt = cmdtAmt;
	}
	
	/**
	 * Column Info
	 * @param exptAmt
	 */
	public void setExptAmt(String exptAmt) {
		this.exptAmt = exptAmt;
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
	 * @param incrAmt
	 */
	public void setIncrAmt(String incrAmt) {
		this.incrAmt = incrAmt;
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
	 * @param collCntr
	 */
	public void setCollCntr(String collCntr) {
		this.collCntr = collCntr;
	}
	
	/**
	 * Column Info
	 * @param collRtoC
	 */
	public void setCollRtoC(String collRtoC) {
		this.collRtoC = collRtoC;
	}
	
	/**
	 * Column Info
	 * @param collRtoB
	 */
	public void setCollRtoB(String collRtoB) {
		this.collRtoB = collRtoB;
	}
	
	/**
	 * Column Info
	 * @param collRtoA
	 */
	public void setCollRtoA(String collRtoA) {
		this.collRtoA = collRtoA;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param dcAmt
	 */
	public void setDcAmt(String dcAmt) {
		this.dcAmt = dcAmt;
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
	 * @param cmdtCntr
	 */
	public void setCmdtCntr(String cmdtCntr) {
		this.cmdtCntr = cmdtCntr;
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
	 * @param ttlCntr
	 */
	public void setTtlCntr(String ttlCntr) {
		this.ttlCntr = ttlCntr;
	}
	
	/**
	 * Column Info
	 * @param billCntr
	 */
	public void setBillCntr(String billCntr) {
		this.billCntr = billCntr;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param dcCntr
	 */
	public void setDcCntr(String dcCntr) {
		this.dcCntr = dcCntr;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIncrCntr(JSPUtil.getParameter(request, "incr_cntr", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setExptCntr(JSPUtil.getParameter(request, "expt_cntr", ""));
		setCollAmt(JSPUtil.getParameter(request, "coll_amt", ""));
		setCmdtAmt(JSPUtil.getParameter(request, "cmdt_amt", ""));
		setExptAmt(JSPUtil.getParameter(request, "expt_amt", ""));
		setInvCntr(JSPUtil.getParameter(request, "inv_cntr", ""));
		setIncrAmt(JSPUtil.getParameter(request, "incr_amt", ""));
		setBillAmt(JSPUtil.getParameter(request, "bill_amt", ""));
		setCollCntr(JSPUtil.getParameter(request, "coll_cntr", ""));
		setCollRtoC(JSPUtil.getParameter(request, "coll_rto_c", ""));
		setCollRtoB(JSPUtil.getParameter(request, "coll_rto_b", ""));
		setCollRtoA(JSPUtil.getParameter(request, "coll_rto_a", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setDcAmt(JSPUtil.getParameter(request, "dc_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCmdtCntr(JSPUtil.getParameter(request, "cmdt_cntr", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setTtlCntr(JSPUtil.getParameter(request, "ttl_cntr", ""));
		setBillCntr(JSPUtil.getParameter(request, "bill_cntr", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setDcCntr(JSPUtil.getParameter(request, "dc_cntr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CollectionSummaryReportByOfficeVO[]
	 */
	public CollectionSummaryReportByOfficeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CollectionSummaryReportByOfficeVO[]
	 */
	public CollectionSummaryReportByOfficeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CollectionSummaryReportByOfficeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] incrCntr = (JSPUtil.getParameter(request, prefix	+ "incr_cntr", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] exptCntr = (JSPUtil.getParameter(request, prefix	+ "expt_cntr", length));
			String[] collAmt = (JSPUtil.getParameter(request, prefix	+ "coll_amt", length));
			String[] cmdtAmt = (JSPUtil.getParameter(request, prefix	+ "cmdt_amt", length));
			String[] exptAmt = (JSPUtil.getParameter(request, prefix	+ "expt_amt", length));
			String[] invCntr = (JSPUtil.getParameter(request, prefix	+ "inv_cntr", length));
			String[] incrAmt = (JSPUtil.getParameter(request, prefix	+ "incr_amt", length));
			String[] billAmt = (JSPUtil.getParameter(request, prefix	+ "bill_amt", length));
			String[] collCntr = (JSPUtil.getParameter(request, prefix	+ "coll_cntr", length));
			String[] collRtoC = (JSPUtil.getParameter(request, prefix	+ "coll_rto_c", length));
			String[] collRtoB = (JSPUtil.getParameter(request, prefix	+ "coll_rto_b", length));
			String[] collRtoA = (JSPUtil.getParameter(request, prefix	+ "coll_rto_a", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] dcAmt = (JSPUtil.getParameter(request, prefix	+ "dc_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCntr = (JSPUtil.getParameter(request, prefix	+ "cmdt_cntr", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] ttlCntr = (JSPUtil.getParameter(request, prefix	+ "ttl_cntr", length));
			String[] billCntr = (JSPUtil.getParameter(request, prefix	+ "bill_cntr", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] dcCntr = (JSPUtil.getParameter(request, prefix	+ "dc_cntr", length));
			
			for (int i = 0; i < length; i++) {
				model = new CollectionSummaryReportByOfficeVO();
				if (incrCntr[i] != null)
					model.setIncrCntr(incrCntr[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (exptCntr[i] != null)
					model.setExptCntr(exptCntr[i]);
				if (collAmt[i] != null)
					model.setCollAmt(collAmt[i]);
				if (cmdtAmt[i] != null)
					model.setCmdtAmt(cmdtAmt[i]);
				if (exptAmt[i] != null)
					model.setExptAmt(exptAmt[i]);
				if (invCntr[i] != null)
					model.setInvCntr(invCntr[i]);
				if (incrAmt[i] != null)
					model.setIncrAmt(incrAmt[i]);
				if (billAmt[i] != null)
					model.setBillAmt(billAmt[i]);
				if (collCntr[i] != null)
					model.setCollCntr(collCntr[i]);
				if (collRtoC[i] != null)
					model.setCollRtoC(collRtoC[i]);
				if (collRtoB[i] != null)
					model.setCollRtoB(collRtoB[i]);
				if (collRtoA[i] != null)
					model.setCollRtoA(collRtoA[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (dcAmt[i] != null)
					model.setDcAmt(dcAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCntr[i] != null)
					model.setCmdtCntr(cmdtCntr[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (ttlCntr[i] != null)
					model.setTtlCntr(ttlCntr[i]);
				if (billCntr[i] != null)
					model.setBillCntr(billCntr[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (dcCntr[i] != null)
					model.setDcCntr(dcCntr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCollectionSummaryReportByOfficeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CollectionSummaryReportByOfficeVO[]
	 */
	public CollectionSummaryReportByOfficeVO[] getCollectionSummaryReportByOfficeVOs(){
		CollectionSummaryReportByOfficeVO[] vos = (CollectionSummaryReportByOfficeVO[])models.toArray(new CollectionSummaryReportByOfficeVO[models.size()]);
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
		this.incrCntr = this.incrCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptCntr = this.exptCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collAmt = this.collAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtAmt = this.cmdtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptAmt = this.exptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCntr = this.invCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incrAmt = this.incrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billAmt = this.billAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collCntr = this.collCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collRtoC = this.collRtoC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collRtoB = this.collRtoB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collRtoA = this.collRtoA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcAmt = this.dcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCntr = this.cmdtCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCntr = this.ttlCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billCntr = this.billCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcCntr = this.dcCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
