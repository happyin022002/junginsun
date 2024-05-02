/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SendInvoiceEdiItemVO.java
*@FileTitle : SendInvoiceEdiItemVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.19
*@LastModifier : JS
*@LastVersion : 1.0
* 2013.04.19 JS 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * 
 * @author JS
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SendInvoiceEdiItemVO extends AbstractValueObject {

	private static final long serialVersionUID = -7459224002269522720L;

	private Collection<SendInvoiceEdiItemVO> models = new ArrayList<SendInvoiceEdiItemVO>();
	
	private String typeCode="";
	private String n3ptyBilTpNm="";
	private String seqno="";
	private String eqkind="";
	private String eqNo="";
	private String eqtype="";
	private String bkgno="";
	private String blno="";
	private String vvd="";
	private String yard="";
	private String route="";
	private String newEqno="";
	private String newSeal="";
	private String lastfreeDate="";
	private String amtItem="";
	private String amtItemVat="";
	private String pickupDate="";
	private String freetimeOver="";
	private String citation="";
	private String cntrWgt="";
	private String cntrWunit="";
	private String waitHrs="";
	private String occurDate="";
	private String newVvd="";
	private String newBkgno="";
	private String acct="";
	private String logCost="";
	private String sono="";
	private String csrno="";
	private String glDate="";
	private String vvdCd="";
	private String atdInputDate="";
	private String terminal="";
	private String accountCd="";
	private String loadId = "";

	/**
	 * @return the typeCode
	 */
	public String getTypeCode() {
		return typeCode;
	}

	/**
	 * @param typeCode the typeCode to set
	 */
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	/**
	 * @return the n3ptyBilTpNm
	 */
	public String getN3ptyBilTpNm() {
		return n3ptyBilTpNm;
	}

	/**
	 * @param bilTpNm the n3ptyBilTpNm to set
	 */
	public void setN3ptyBilTpNm(String bilTpNm) {
		n3ptyBilTpNm = bilTpNm;
	}

	/**
	 * @return the seqno
	 */
	public String getSeqno() {
		return seqno;
	}

	/**
	 * @param seqno the seqno to set
	 */
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}

	/**
	 * @return the eqkind
	 */
	public String getEqkind() {
		return eqkind;
	}

	/**
	 * @param eqkind the eqkind to set
	 */
	public void setEqkind(String eqkind) {
		this.eqkind = eqkind;
	}

	/**
	 * @return the eqNo
	 */
	public String getEqNo() {
		return eqNo;
	}

	/**
	 * @param eqNo the eqNo to set
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}

	/**
	 * @return the eqtype
	 */
	public String getEqtype() {
		return eqtype;
	}

	/**
	 * @param eqtype the eqtype to set
	 */
	public void setEqtype(String eqtype) {
		this.eqtype = eqtype;
	}

	/**
	 * @return the bkgno
	 */
	public String getBkgno() {
		return bkgno;
	}

	/**
	 * @param bkgno the bkgno to set
	 */
	public void setBkgno(String bkgno) {
		this.bkgno = bkgno;
	}

	/**
	 * @return the blno
	 */
	public String getBlno() {
		return blno;
	}

	/**
	 * @param blno the blno to set
	 */
	public void setBlno(String blno) {
		this.blno = blno;
	}

	/**
	 * @return the vvd
	 */
	public String getVvd() {
		return vvd;
	}

	/**
	 * @param vvd the vvd to set
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * @return the yard
	 */
	public String getYard() {
		return yard;
	}

	/**
	 * @param yard the yard to set
	 */
	public void setYard(String yard) {
		this.yard = yard;
	}

	/**
	 * @return the route
	 */
	public String getRoute() {
		return route;
	}

	/**
	 * @param route the route to set
	 */
	public void setRoute(String route) {
		this.route = route;
	}

	/**
	 * @return the newEqno
	 */
	public String getNewEqno() {
		return newEqno;
	}

	/**
	 * @param newEqno the newEqno to set
	 */
	public void setNewEqno(String newEqno) {
		this.newEqno = newEqno;
	}

	/**
	 * @return the newSeal
	 */
	public String getNewSeal() {
		return newSeal;
	}

	/**
	 * @param newSeal the newSeal to set
	 */
	public void setNewSeal(String newSeal) {
		this.newSeal = newSeal;
	}

	/**
	 * @return the lastfreeDate
	 */
	public String getLastfreeDate() {
		return lastfreeDate;
	}

	/**
	 * @param lastfreeDate the lastfreeDate to set
	 */
	public void setLastfreeDate(String lastfreeDate) {
		this.lastfreeDate = lastfreeDate;
	}

	/**
	 * @return the amtItem
	 */
	public String getAmtItem() {
		return amtItem;
	}

	/**
	 * @param amtItem the amtItem to set
	 */
	public void setAmtItem(String amtItem) {
		this.amtItem = amtItem;
	}

	/**
	 * @return the amtItemVat
	 */
	public String getAmtItemVat() {
		return amtItemVat;
	}

	/**
	 * @param amtItemVat the amtItemVat to set
	 */
	public void setAmtItemVat(String amtItemVat) {
		this.amtItemVat = amtItemVat;
	}

	/**
	 * @return the pickupDate
	 */
	public String getPickupDate() {
		return pickupDate;
	}

	/**
	 * @param pickupDate the pickupDate to set
	 */
	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}

	/**
	 * @return the freetimeOver
	 */
	public String getFreetimeOver() {
		return freetimeOver;
	}

	/**
	 * @param freetimeOver the freetimeOver to set
	 */
	public void setFreetimeOver(String freetimeOver) {
		this.freetimeOver = freetimeOver;
	}

	/**
	 * @return the citation
	 */
	public String getCitation() {
		return citation;
	}

	/**
	 * @param citation the citation to set
	 */
	public void setCitation(String citation) {
		this.citation = citation;
	}

	/**
	 * @return the cntrWgt
	 */
	public String getCntrWgt() {
		return cntrWgt;
	}

	/**
	 * @param cntrWgt the cntrWgt to set
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}

	/**
	 * @return the cntrWunit
	 */
	public String getCntrWunit() {
		return cntrWunit;
	}

	/**
	 * @param cntrWunit the cntrWunit to set
	 */
	public void setCntrWunit(String cntrWunit) {
		this.cntrWunit = cntrWunit;
	}

	/**
	 * @return the waitHrs
	 */
	public String getWaitHrs() {
		return waitHrs;
	}

	/**
	 * @param waitHrs the waitHrs to set
	 */
	public void setWaitHrs(String waitHrs) {
		this.waitHrs = waitHrs;
	}

	/**
	 * @return the occurDate
	 */
	public String getOccurDate() {
		return occurDate;
	}

	/**
	 * @param occurDate the occurDate to set
	 */
	public void setOccurDate(String occurDate) {
		this.occurDate = occurDate;
	}

	/**
	 * @return the newVvd
	 */
	public String getNewVvd() {
		return newVvd;
	}

	/**
	 * @param newVvd the newVvd to set
	 */
	public void setNewVvd(String newVvd) {
		this.newVvd = newVvd;
	}

	/**
	 * @return the newBkgno
	 */
	public String getNewBkgno() {
		return newBkgno;
	}

	/**
	 * @param newBkgno the newBkgno to set
	 */
	public void setNewBkgno(String newBkgno) {
		this.newBkgno = newBkgno;
	}

	/**
	 * @return the acct
	 */
	public String getAcct() {
		return acct;
	}

	/**
	 * @param acct the acct to set
	 */
	public void setAcct(String acct) {
		this.acct = acct;
	}

	/**
	 * @return the logCost
	 */
	public String getLogCost() {
		return logCost;
	}

	/**
	 * @param logCost the logCost to set
	 */
	public void setLogCost(String logCost) {
		this.logCost = logCost;
	}

	/**
	 * @return the sono
	 */
	public String getSono() {
		return sono;
	}

	/**
	 * @param sono the sono to set
	 */
	public void setSono(String sono) {
		this.sono = sono;
	}

	/**
	 * @return the csrno
	 */
	public String getCsrno() {
		return csrno;
	}

	/**
	 * @param csrno the csrno to set
	 */
	public void setCsrno(String csrno) {
		this.csrno = csrno;
	}

	/**
	 * @return the glDate
	 */
	public String getGlDate() {
		return glDate;
	}

	/**
	 * @param glDate the glDate to set
	 */
	public void setGlDate(String glDate) {
		this.glDate = glDate;
	}

	/**
	 * @return the vvdCd
	 */
	public String getVvdCd() {
		return vvdCd;
	}

	/**
	 * @param vvdCd the vvdCd to set
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}

	/**
	 * @return the atdInputDate
	 */
	public String getAtdInputDate() {
		return atdInputDate;
	}

	/**
	 * @param atdInputDate the atdInputDate to set
	 */
	public void setAtdInputDate(String atdInputDate) {
		this.atdInputDate = atdInputDate;
	}

	/**
	 * @return the terminal
	 */
	public String getTerminal() {
		return terminal;
	}

	/**
	 * @param terminal the terminal to set
	 */
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	/**
	 * @return the accountCd
	 */
	public String getAccountCd() {
		return accountCd;
	}

	/**
	 * @param accountCd the accountCd to set
	 */
	public void setAccountCd(String accountCd) {
		this.accountCd = accountCd;
	} 
	
	public String getLoadId() {
		return loadId;
	}
	
	public void setLoadId(String loadId) {
		this.loadId = loadId;
	}
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	
	
	public SendInvoiceEdiItemVO() {}

	public SendInvoiceEdiItemVO(String typeCode,String n3ptyBilTpNm,String seqno,String eqkind,String eqNo,String eqtype,String bkgno,String blno,String vvd,String yard,String route,String newEqno,String newSeal,String lastfreeDate,String amtItem,String amtItemVat,String pickupDate,String freetimeOver,String citation,String cntrWgt,String cntrWunit,String waitHrs,String occurDate,String newVvd,String newBkgno,String acct,String logCost,String sono,String csrno,String glDate,String vvdCd,String atdInputDate,String terminal,String accountCd, String loadId){
		this.typeCode = typeCode;
		this.n3ptyBilTpNm = n3ptyBilTpNm;
		this.seqno = seqno;
		this.eqkind = eqkind;
		this.eqNo = eqNo;
		this.eqtype = eqtype;
		this.bkgno = bkgno;
		this.blno = blno;
		this.vvd = vvd;
		this.yard = yard;
		this.route = route;
		this.newEqno = newEqno;
		this.newSeal = newSeal;
		this.lastfreeDate = lastfreeDate;
		this.amtItem = amtItem;
		this.amtItemVat = amtItemVat;
		this.pickupDate = pickupDate;
		this.freetimeOver = freetimeOver;
		this.citation = citation;
		this.cntrWgt = cntrWgt;
		this.cntrWunit = cntrWunit;
		this.waitHrs = waitHrs;
		this.occurDate = occurDate;
		this.newVvd = newVvd;
		this.newBkgno = newBkgno;
		this.acct = acct;
		this.logCost = logCost;
		this.sono = sono;
		this.csrno = csrno;
		this.glDate = glDate;
		this.vvdCd = vvdCd;
		this.atdInputDate = atdInputDate;
		this.terminal = terminal;
		this.accountCd = accountCd;
		this.loadId = loadId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("type_code", getTypeCode());
		this.hashColumns.put("n3pty_bil_tp_nm", getN3ptyBilTpNm());
		this.hashColumns.put("seqno", getSeqno());
		this.hashColumns.put("eqkind", getEqkind());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("eqtype", getEqtype());
		this.hashColumns.put("bkgno", getBkgno());
		this.hashColumns.put("blno", getBlno());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("yard", getYard());
		this.hashColumns.put("route", getRoute());
		this.hashColumns.put("new_eqno", getNewEqno());
		this.hashColumns.put("new_seal", getNewSeal());
		this.hashColumns.put("lastfree_date", getLastfreeDate());
		this.hashColumns.put("amt_item", getAmtItem());
		this.hashColumns.put("amt_item_vat", getAmtItemVat());
		this.hashColumns.put("pickup_date", getPickupDate());
		this.hashColumns.put("freetime_over", getFreetimeOver());
		this.hashColumns.put("citation", getCitation());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("cntr_wunit", getCntrWunit());
		this.hashColumns.put("wait_hrs", getWaitHrs());
		this.hashColumns.put("occur_date", getOccurDate());
		this.hashColumns.put("new_vvd", getNewVvd());
		this.hashColumns.put("new_bkgno", getNewBkgno());
		this.hashColumns.put("acct", getAcct());
		this.hashColumns.put("log_cost", getLogCost());
		this.hashColumns.put("sono", getSono());
		this.hashColumns.put("csrno", getCsrno());
		this.hashColumns.put("gl_date", getGlDate());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("atd_input_date", getAtdInputDate());
		this.hashColumns.put("terminal", getTerminal());
		this.hashColumns.put("account_cd", getAccountCd());
		this.hashColumns.put("load_id", getLoadId());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("type_code", "typeCode");
		this.hashFields.put("n3pty_bil_tp_nm", "n3ptyBilTpNm");
		this.hashFields.put("seqno", "seqno");
		this.hashFields.put("eqkind", "eqkind");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("eqtype", "eqtype");
		this.hashFields.put("bkgno", "bkgno");
		this.hashFields.put("blno", "blno");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("yard", "yard");
		this.hashFields.put("route", "route");
		this.hashFields.put("new_eqno", "newEqno");
		this.hashFields.put("new_seal", "newSeal");
		this.hashFields.put("lastfree_date", "lastfreeDate");
		this.hashFields.put("amt_item", "amtItem");
		this.hashFields.put("amt_item_vat", "amtItemVat");
		this.hashFields.put("pickup_date", "pickupDate");
		this.hashFields.put("freetime_over", "freetimeOver");
		this.hashFields.put("citation", "citation");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("cntr_wunit", "cntrWunit");
		this.hashFields.put("wait_hrs", "waitHrs");
		this.hashFields.put("occur_date", "occurDate");
		this.hashFields.put("new_vvd", "newVvd");
		this.hashFields.put("new_bkgno", "newBkgno");
		this.hashFields.put("acct", "acct");
		this.hashFields.put("log_cost", "logCost");
		this.hashFields.put("sono", "sono");
		this.hashFields.put("csrno", "csrno");
		this.hashFields.put("gl_date", "glDate");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("atd_input_date", "atdInputDate");
		this.hashFields.put("terminal", "terminal");
		this.hashFields.put("account_cd", "accountCd");
		this.hashFields.put("load_id", "loadId");

		return this.hashFields;
	}
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTypeCode(JSPUtil.getParameter(request, "type_code", ""));
		setN3ptyBilTpNm(JSPUtil.getParameter(request, "n3pty_bil_tp_nm", ""));
		setSeqno(JSPUtil.getParameter(request, "seqno", ""));
		setEqkind(JSPUtil.getParameter(request, "eqkind", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setEqtype(JSPUtil.getParameter(request, "eqtype", ""));
		setBkgno(JSPUtil.getParameter(request, "bkgno", ""));
		setBlno(JSPUtil.getParameter(request, "blno", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setYard(JSPUtil.getParameter(request, "yard", ""));
		setRoute(JSPUtil.getParameter(request, "route", ""));
		setNewEqno(JSPUtil.getParameter(request, "new_eqno", ""));
		setNewSeal(JSPUtil.getParameter(request, "new_seal", ""));
		setLastfreeDate(JSPUtil.getParameter(request, "lastfree_date", ""));
		setAmtItem(JSPUtil.getParameter(request, "amt_item", ""));
		setAmtItemVat(JSPUtil.getParameter(request, "amt_item_vat", ""));
		setPickupDate(JSPUtil.getParameter(request, "pickup_date", ""));
		setFreetimeOver(JSPUtil.getParameter(request, "freetime_over", ""));
		setCitation(JSPUtil.getParameter(request, "citation", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setCntrWunit(JSPUtil.getParameter(request, "cntr_wunit", ""));
		setWaitHrs(JSPUtil.getParameter(request, "wait_hrs", ""));
		setOccurDate(JSPUtil.getParameter(request, "occur_date", ""));
		setNewVvd(JSPUtil.getParameter(request, "new_vvd", ""));
		setNewBkgno(JSPUtil.getParameter(request, "new_bkgno", ""));
		setAcct(JSPUtil.getParameter(request, "acct", ""));		
		setLogCost(JSPUtil.getParameter(request, "log_cost", ""));
		setSono(JSPUtil.getParameter(request, "sono", ""));
		setCsrno(JSPUtil.getParameter(request, "csrno", ""));
		setGlDate(JSPUtil.getParameter(request, "gl_date", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setAtdInputDate(JSPUtil.getParameter(request, "atd_input_date", ""));
		setTerminal(JSPUtil.getParameter(request, "terminal", ""));
		setAccountCd(JSPUtil.getParameter(request, "account_cd", ""));
		setLoadId(JSPUtil.getParameter(request,  "load_id", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SendInvoiceEdiItemVO[]
	 */
	public SendInvoiceEdiItemVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SendInvoiceEdiItemVO[]
	 */
	public SendInvoiceEdiItemVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SendInvoiceEdiItemVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
  
		try {
			String[] typeCode = (JSPUtil.getParameter(request, prefix	+ "type_code", length));
			String[] n3ptyBilTpNm = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_nm", length));
			String[] seqno = (JSPUtil.getParameter(request, prefix	+ "seqno", length));
			String[] eqkind = (JSPUtil.getParameter(request, prefix	+ "eqkind", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] eqtype = (JSPUtil.getParameter(request, prefix	+ "eqtype", length));
			String[] bkgno = (JSPUtil.getParameter(request, prefix	+ "bkgno", length));
			String[] blno = (JSPUtil.getParameter(request, prefix	+ "blno", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] yard = (JSPUtil.getParameter(request, prefix	+ "yard", length));
			String[] route = (JSPUtil.getParameter(request, prefix	+ "route", length));
			String[] newEqno = (JSPUtil.getParameter(request, prefix	+ "new_eqno", length));
			String[] newSeal = (JSPUtil.getParameter(request, prefix	+ "new_seal", length));
			String[] lastfreeDate = (JSPUtil.getParameter(request, prefix	+ "lastfree_date", length));
			String[] amtItem = (JSPUtil.getParameter(request, prefix	+ "amt_item", length));
			String[] amtItemVat = (JSPUtil.getParameter(request, prefix	+ "amt_item_vat", length));
			String[] pickupDate = (JSPUtil.getParameter(request, prefix	+ "pickup_date", length));
			String[] freetimeOver = (JSPUtil.getParameter(request, prefix	+ "freetime_over", length));
			String[] citation = (JSPUtil.getParameter(request, prefix	+ "citation", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] cntrWunit = (JSPUtil.getParameter(request, prefix	+ "cntr_wunit", length));
			String[] waitHrs = (JSPUtil.getParameter(request, prefix	+ "wait_hrs", length));
			String[] occurDate = (JSPUtil.getParameter(request, prefix	+ "occur_date", length));
			String[] newVvd = (JSPUtil.getParameter(request, prefix	+ "new_vvd", length));
			String[] newBkgno = (JSPUtil.getParameter(request, prefix	+ "new_bkgno", length));
			String[] acct = (JSPUtil.getParameter(request, prefix	+ "acct", length));
			String[] logCost = (JSPUtil.getParameter(request, prefix	+ "log_cost", length));
			String[] sono = (JSPUtil.getParameter(request, prefix	+ "sono", length));
			String[] csrno = (JSPUtil.getParameter(request, prefix	+ "csrno", length));
			String[] glDate = (JSPUtil.getParameter(request, prefix	+ "gl_date", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] atdInputDate = (JSPUtil.getParameter(request, prefix	+ "atd_input_date", length));
			String[] terminal = (JSPUtil.getParameter(request, prefix	+ "terminal", length));
			String[] accountCd = (JSPUtil.getParameter(request, prefix	+ "account_cd", length));
			String[] loadId = (JSPUtil.getParameter(request, prefix	+ "load_id", length));

			
			for (int i = 0; i < length; i++) {
				model = new SendInvoiceEdiItemVO();
				if (typeCode[i] != null)
					model.setTypeCode(typeCode[i]);
				if (n3ptyBilTpNm[i] != null)
					model.setN3ptyBilTpNm(n3ptyBilTpNm[i]);
				if (seqno[i] != null)
					model.setSeqno(seqno[i]);
				if (eqkind[i] != null)
					model.setEqkind(eqkind[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (eqtype[i] != null)
					model.setEqtype(eqtype[i]);
				if (bkgno[i] != null)
					model.setBkgno(bkgno[i]);
				if (blno[i] != null)
					model.setBlno(blno[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (yard[i] != null)
					model.setYard(yard[i]);
				if (route[i] != null)
					model.setRoute(route[i]);
				if (newEqno[i] != null)
					model.setNewEqno(newEqno[i]);
				if (newSeal[i] != null)
					model.setNewSeal(newSeal[i]);
				if (lastfreeDate[i] != null)
					model.setLastfreeDate(lastfreeDate[i]);
				if (amtItem[i] != null)
					model.setAmtItem(amtItem[i]);
				if (amtItemVat[i] != null)
					model.setAmtItemVat(amtItemVat[i]);
				if (pickupDate[i] != null)
					model.setPickupDate(pickupDate[i]);
				if (freetimeOver[i] != null)
					model.setFreetimeOver(freetimeOver[i]);
				if (citation[i] != null)
					model.setCitation(citation[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (cntrWunit[i] != null)
					model.setCntrWunit(cntrWunit[i]);
				if (waitHrs[i] != null)
					model.setWaitHrs(waitHrs[i]);
				if (occurDate[i] != null)
					model.setOccurDate(occurDate[i]);
				if (newVvd[i] != null)
					model.setNewVvd(newVvd[i]);
				if (newBkgno[i] != null)
					model.setNewBkgno(newBkgno[i]);
				if (acct[i] != null)
					model.setAcct(acct[i]);
				if (logCost[i] != null)
					model.setLogCost(logCost[i]);
				if (sono[i] != null)
					model.setSono(sono[i]);
				if (csrno[i] != null)
					model.setCsrno(csrno[i]);
				if (glDate[i] != null)
					model.setGlDate(glDate[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (atdInputDate[i] != null)
					model.setAtdInputDate(atdInputDate[i]);
				if (csrno[i] != null)
					model.setCsrno(csrno[i]);
				if (csrno[i] != null)
					model.setCsrno(csrno[i]);
				if (loadId[i] != null)
					model.setLoadId(loadId[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSendInvoiceEdiItemVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SendInvoiceEdiItemVO[]
	 */
	public SendInvoiceEdiItemVO[] getSendInvoiceEdiItemVOs(){
		SendInvoiceEdiItemVO[] vos = (SendInvoiceEdiItemVO[])models.toArray(new SendInvoiceEdiItemVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.typeCode = this.typeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpNm = this.n3ptyBilTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqno = this.seqno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqkind = this.eqkind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqtype = this.eqtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgno = this.bkgno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blno = this.blno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yard = this.yard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.route = this.route .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newEqno = this.newEqno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newSeal = this.newSeal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastfreeDate = this.lastfreeDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtItem = this.amtItem .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtItemVat = this.amtItemVat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pickupDate = this.pickupDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freetimeOver = this.freetimeOver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.citation = this.citation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWunit = this.cntrWunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.waitHrs = this.waitHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.occurDate = this.occurDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVvd = this.newVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newBkgno = this.newBkgno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acct = this.acct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logCost = this.logCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sono = this.sono .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrno = this.csrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDate = this.glDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atdInputDate = this.atdInputDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.terminal = this.terminal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accountCd = this.accountCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadId = this.loadId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}	
	
	
		
	
}
