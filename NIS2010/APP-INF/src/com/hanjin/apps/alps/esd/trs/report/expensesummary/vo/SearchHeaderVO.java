/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchHeaderVO.java
*@FileTitle : SearchHeaderVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.09.30 손은주(TRS) 
* 1.0 Creation
* 
* 2011.07.26 민정호 [CHM-201112196] Expense Summary Report에 Invoice 상태코드를 조회조건에 추가
=========================================================*/

package com.hanjin.apps.alps.esd.trs.report.expensesummary.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 손은주(TRS)
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchHeaderVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchHeaderVO> models = new ArrayList<SearchHeaderVO>();
	
	/* Column Info */
	private String selTransmode = null;
	/* Column Info */
	private String hidToDate = null;
	/* Column Info */
	private String spTp = null;
	/* Column Info */
	private String chkPrntProvider = null;
	/* Column Info */
	private String hidToNode = null;
	/* Column Info */
	private String hidViaNode = null;
	/* Column Info */
	private String selCostmode = null;
	/* Column Info */
	private String ioBound = null;
	/* Column Info */
	private String hidPeriod = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String comboSvcProviderPrnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String comboSvcProviderChld = null;
	/* Column Info */
	private String hidFromNode = null;
	/* Column Info */
	private String selBkgterm = null;
	/* Column Info */
	private String radioOffice = null;
	/* Column Info */
	private String selSotype = null;
	/* Column Info */
	private String hidDoorNode = null;
	/* Column Info */
	private String inputOffice = null;
	/* Column Info */
	private String hidFromDate = null;
	/* Column Info */
	private String nodeDiv = null;
	private String statusCd = null;
	
	private String etsYn = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchHeaderVO() {}

	public SearchHeaderVO(String ibflag, String pagerows, String hidPeriod, String hidFromDate, String hidToDate, String radioOffice, String inputOffice, String selCostmode, String selTransmode, String selSotype, String ioBound, String selBkgterm, String spTp, String nodeDiv, String hidFromNode, String hidViaNode, String hidToNode, String hidDoorNode, String comboSvcProviderChld, String comboSvcProviderPrnt, String chkPrntProvider, String statusCd, String etsYn) {
		this.selTransmode = selTransmode;
		this.hidToDate = hidToDate;
		this.spTp = spTp;
		this.chkPrntProvider = chkPrntProvider;
		this.hidToNode = hidToNode;
		this.hidViaNode = hidViaNode;
		this.selCostmode = selCostmode;
		this.ioBound = ioBound;
		this.hidPeriod = hidPeriod;
		this.pagerows = pagerows;
		this.comboSvcProviderPrnt = comboSvcProviderPrnt;
		this.ibflag = ibflag;
		this.comboSvcProviderChld = comboSvcProviderChld;
		this.hidFromNode = hidFromNode;
		this.selBkgterm = selBkgterm;
		this.radioOffice = radioOffice;
		this.selSotype = selSotype;
		this.hidDoorNode = hidDoorNode;
		this.inputOffice = inputOffice;
		this.hidFromDate = hidFromDate;
		this.nodeDiv = nodeDiv;
		this.statusCd = statusCd;
		this.etsYn = etsYn;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sel_transmode", getSelTransmode());
		this.hashColumns.put("hid_to_date", getHidToDate());
		this.hashColumns.put("sp_tp", getSpTp());
		this.hashColumns.put("chk_prnt_provider", getChkPrntProvider());
		this.hashColumns.put("hid_to_node", getHidToNode());
		this.hashColumns.put("hid_via_node", getHidViaNode());
		this.hashColumns.put("sel_costmode", getSelCostmode());
		this.hashColumns.put("io_bound", getIoBound());
		this.hashColumns.put("hid_period", getHidPeriod());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("combo_svc_provider_prnt", getComboSvcProviderPrnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("combo_svc_provider_chld", getComboSvcProviderChld());
		this.hashColumns.put("hid_from_node", getHidFromNode());
		this.hashColumns.put("sel_bkgterm", getSelBkgterm());
		this.hashColumns.put("radio_office", getRadioOffice());
		this.hashColumns.put("sel_sotype", getSelSotype());
		this.hashColumns.put("hid_door_node", getHidDoorNode());
		this.hashColumns.put("input_office", getInputOffice());
		this.hashColumns.put("hid_from_date", getHidFromDate());
		this.hashColumns.put("node_div", getNodeDiv());
		this.hashColumns.put("status_cd", getStatusCd());
		this.hashColumns.put("ets_yn", getEtsYn());	
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sel_transmode", "selTransmode");
		this.hashFields.put("hid_to_date", "hidToDate");
		this.hashFields.put("sp_tp", "spTp");
		this.hashFields.put("chk_prnt_provider", "chkPrntProvider");
		this.hashFields.put("hid_to_node", "hidToNode");
		this.hashFields.put("hid_via_node", "hidViaNode");
		this.hashFields.put("sel_costmode", "selCostmode");
		this.hashFields.put("io_bound", "ioBound");
		this.hashFields.put("hid_period", "hidPeriod");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("combo_svc_provider_prnt", "comboSvcProviderPrnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("combo_svc_provider_chld", "comboSvcProviderChld");
		this.hashFields.put("hid_from_node", "hidFromNode");
		this.hashFields.put("sel_bkgterm", "selBkgterm");
		this.hashFields.put("radio_office", "radioOffice");
		this.hashFields.put("sel_sotype", "selSotype");
		this.hashFields.put("hid_door_node", "hidDoorNode");
		this.hashFields.put("input_office", "inputOffice");
		this.hashFields.put("hid_from_date", "hidFromDate");
		this.hashFields.put("node_div", "nodeDiv");
		this.hashFields.put("status_cd", "statusCd");
		this.hashFields.put("ets_yn", "etsYn");	
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return selTransmode
	 */
	public String getSelTransmode() {
		return this.selTransmode;
	}
	
	/**
	 * Column Info
	 * @return hidToDate
	 */
	public String getHidToDate() {
		return this.hidToDate;
	}
	
	/**
	 * Column Info
	 * @return spTp
	 */
	public String getSpTp() {
		return this.spTp;
	}
	
	/**
	 * Column Info
	 * @return chkPrntProvider
	 */
	public String getChkPrntProvider() {
		return this.chkPrntProvider;
	}
	
	/**
	 * Column Info
	 * @return hidToNode
	 */
	public String getHidToNode() {
		return this.hidToNode;
	}
	
	/**
	 * Column Info
	 * @return hidViaNode
	 */
	public String getHidViaNode() {
		return this.hidViaNode;
	}
	
	/**
	 * Column Info
	 * @return selCostmode
	 */
	public String getSelCostmode() {
		return this.selCostmode;
	}
	
	/**
	 * Column Info
	 * @return ioBound
	 */
	public String getIoBound() {
		return this.ioBound;
	}
	
	/**
	 * Column Info
	 * @return hidPeriod
	 */
	public String getHidPeriod() {
		return this.hidPeriod;
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
	 * @return comboSvcProviderPrnt
	 */
	public String getComboSvcProviderPrnt() {
		return this.comboSvcProviderPrnt;
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
	 * @return comboSvcProviderChld
	 */
	public String getComboSvcProviderChld() {
		return this.comboSvcProviderChld;
	}
	
	/**
	 * Column Info
	 * @return hidFromNode
	 */
	public String getHidFromNode() {
		return this.hidFromNode;
	}
	
	/**
	 * Column Info
	 * @return selBkgterm
	 */
	public String getSelBkgterm() {
		return this.selBkgterm;
	}
	
	/**
	 * Column Info
	 * @return radioOffice
	 */
	public String getRadioOffice() {
		return this.radioOffice;
	}
	
	/**
	 * Column Info
	 * @return selSotype
	 */
	public String getSelSotype() {
		return this.selSotype;
	}
	
	/**
	 * Column Info
	 * @return hidDoorNode
	 */
	public String getHidDoorNode() {
		return this.hidDoorNode;
	}
	
	/**
	 * Column Info
	 * @return inputOffice
	 */
	public String getInputOffice() {
		return this.inputOffice;
	}
	
	/**
	 * Column Info
	 * @return hidFromDate
	 */
	public String getHidFromDate() {
		return this.hidFromDate;
	}
	
	/**
	 * Column Info
	 * @return nodeDiv
	 */
	public String getNodeDiv() {
		return this.nodeDiv;
	}
	
	/**
	 * Column Info
	 * @return statusCd
	 */
	public String getStatusCd() {
		return this.statusCd;
	}
	
	
	
	public String getEtsYn() {
		return etsYn;
	}

	public void setEtsYn(String etsYn) {
		this.etsYn = etsYn;
	}

	/**
	 * Column Info
	 * @param selTransmode
	 */
	public void setSelTransmode(String selTransmode) {
		this.selTransmode = selTransmode;
	}
	
	/**
	 * Column Info
	 * @param hidToDate
	 */
	public void setHidToDate(String hidToDate) {
		this.hidToDate = hidToDate;
	}
	
	/**
	 * Column Info
	 * @param spTp
	 */
	public void setSpTp(String spTp) {
		this.spTp = spTp;
	}
	
	/**
	 * Column Info
	 * @param chkPrntProvider
	 */
	public void setChkPrntProvider(String chkPrntProvider) {
		this.chkPrntProvider = chkPrntProvider;
	}
	
	/**
	 * Column Info
	 * @param hidToNode
	 */
	public void setHidToNode(String hidToNode) {
		this.hidToNode = hidToNode;
	}
	
	/**
	 * Column Info
	 * @param hidViaNode
	 */
	public void setHidViaNode(String hidViaNode) {
		this.hidViaNode = hidViaNode;
	}
	
	/**
	 * Column Info
	 * @param selCostmode
	 */
	public void setSelCostmode(String selCostmode) {
		this.selCostmode = selCostmode;
	}
	
	/**
	 * Column Info
	 * @param ioBound
	 */
	public void setIoBound(String ioBound) {
		this.ioBound = ioBound;
	}
	
	/**
	 * Column Info
	 * @param hidPeriod
	 */
	public void setHidPeriod(String hidPeriod) {
		this.hidPeriod = hidPeriod;
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
	 * @param comboSvcProviderPrnt
	 */
	public void setComboSvcProviderPrnt(String comboSvcProviderPrnt) {
		this.comboSvcProviderPrnt = comboSvcProviderPrnt;
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
	 * @param comboSvcProviderChld
	 */
	public void setComboSvcProviderChld(String comboSvcProviderChld) {
		this.comboSvcProviderChld = comboSvcProviderChld;
	}
	
	/**
	 * Column Info
	 * @param hidFromNode
	 */
	public void setHidFromNode(String hidFromNode) {
		this.hidFromNode = hidFromNode;
	}
	
	/**
	 * Column Info
	 * @param selBkgterm
	 */
	public void setSelBkgterm(String selBkgterm) {
		this.selBkgterm = selBkgterm;
	}
	
	/**
	 * Column Info
	 * @param radioOffice
	 */
	public void setRadioOffice(String radioOffice) {
		this.radioOffice = radioOffice;
	}
	
	/**
	 * Column Info
	 * @param selSotype
	 */
	public void setSelSotype(String selSotype) {
		this.selSotype = selSotype;
	}
	
	/**
	 * Column Info
	 * @param hidDoorNode
	 */
	public void setHidDoorNode(String hidDoorNode) {
		this.hidDoorNode = hidDoorNode;
	}
	
	/**
	 * Column Info
	 * @param inputOffice
	 */
	public void setInputOffice(String inputOffice) {
		this.inputOffice = inputOffice;
	}
	
	/**
	 * Column Info
	 * @param hidFromDate
	 */
	public void setHidFromDate(String hidFromDate) {
		this.hidFromDate = hidFromDate;
	}
	
	/**
	 * Column Info
	 * @param nodeDiv
	 */
	public void setNodeDiv(String nodeDiv) {
		this.nodeDiv = nodeDiv;
	}
	
	/**
	 * Column Info
	 * @param statusCd
	 */
	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}	
		
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSelTransmode(JSPUtil.getParameter(request, "sel_transmode", ""));
		setHidToDate(JSPUtil.getParameter(request, "hid_to_date", ""));
		setSpTp(JSPUtil.getParameter(request, "sp_tp", ""));
		setChkPrntProvider(JSPUtil.getParameter(request, "chk_prnt_provider", ""));
		setHidToNode(JSPUtil.getParameter(request, "hid_to_node", ""));
		setHidViaNode(JSPUtil.getParameter(request, "hid_via_node", ""));
		setSelCostmode(JSPUtil.getParameter(request, "sel_costmode", ""));
		setIoBound(JSPUtil.getParameter(request, "io_bound", ""));
		setHidPeriod(JSPUtil.getParameter(request, "hid_period", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setComboSvcProviderPrnt(JSPUtil.getParameter(request, "combo_svc_provider_prnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setComboSvcProviderChld(JSPUtil.getParameter(request, "combo_svc_provider_chld", ""));
		setHidFromNode(JSPUtil.getParameter(request, "hid_from_node", ""));
		setSelBkgterm(JSPUtil.getParameter(request, "sel_bkgterm", ""));
		setRadioOffice(JSPUtil.getParameter(request, "radio_office", ""));
		setSelSotype(JSPUtil.getParameter(request, "sel_sotype", ""));
		setHidDoorNode(JSPUtil.getParameter(request, "hid_door_node", ""));
		setInputOffice(JSPUtil.getParameter(request, "input_office", ""));
		setHidFromDate(JSPUtil.getParameter(request, "hid_from_date", ""));
		setNodeDiv(JSPUtil.getParameter(request, "node_div", ""));
		setStatusCd(JSPUtil.getParameter(request, "status_cd", ""));
		setEtsYn(JSPUtil.getParameter(request, "ets_yn", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchHeaderVO[]
	 */
	public SearchHeaderVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchHeaderVO[]
	 */
	public SearchHeaderVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchHeaderVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] selTransmode = (JSPUtil.getParameter(request, prefix	+ "sel_transmode", length));
			String[] hidToDate = (JSPUtil.getParameter(request, prefix	+ "hid_to_date", length));
			String[] spTp = (JSPUtil.getParameter(request, prefix	+ "sp_tp", length));
			String[] chkPrntProvider = (JSPUtil.getParameter(request, prefix	+ "chk_prnt_provider", length));
			String[] hidToNode = (JSPUtil.getParameter(request, prefix	+ "hid_to_node", length));
			String[] hidViaNode = (JSPUtil.getParameter(request, prefix	+ "hid_via_node", length));
			String[] selCostmode = (JSPUtil.getParameter(request, prefix	+ "sel_costmode", length));
			String[] ioBound = (JSPUtil.getParameter(request, prefix	+ "io_bound", length));
			String[] hidPeriod = (JSPUtil.getParameter(request, prefix	+ "hid_period", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] comboSvcProviderPrnt = (JSPUtil.getParameter(request, prefix	+ "combo_svc_provider_prnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] comboSvcProviderChld = (JSPUtil.getParameter(request, prefix	+ "combo_svc_provider_chld", length));
			String[] hidFromNode = (JSPUtil.getParameter(request, prefix	+ "hid_from_node", length));
			String[] selBkgterm = (JSPUtil.getParameter(request, prefix	+ "sel_bkgterm", length));
			String[] radioOffice = (JSPUtil.getParameter(request, prefix	+ "radio_office", length));
			String[] selSotype = (JSPUtil.getParameter(request, prefix	+ "sel_sotype", length));
			String[] hidDoorNode = (JSPUtil.getParameter(request, prefix	+ "hid_door_node", length));
			String[] inputOffice = (JSPUtil.getParameter(request, prefix	+ "input_office", length));
			String[] hidFromDate = (JSPUtil.getParameter(request, prefix	+ "hid_from_date", length));
			String[] nodeDiv = (JSPUtil.getParameter(request, prefix	+ "node_div", length));
			String[] statusCd = (JSPUtil.getParameter(request, prefix	+ "status_cd", length));
			String[] etsYn = (JSPUtil.getParameter(request, prefix	+ "ets_yn", length));
						
			for (int i = 0; i < length; i++) {
				model = new SearchHeaderVO();
				if (selTransmode[i] != null)
					model.setSelTransmode(selTransmode[i]);
				if (hidToDate[i] != null)
					model.setHidToDate(hidToDate[i]);
				if (spTp[i] != null)
					model.setSpTp(spTp[i]);
				if (chkPrntProvider[i] != null)
					model.setChkPrntProvider(chkPrntProvider[i]);
				if (hidToNode[i] != null)
					model.setHidToNode(hidToNode[i]);
				if (hidViaNode[i] != null)
					model.setHidViaNode(hidViaNode[i]);
				if (selCostmode[i] != null)
					model.setSelCostmode(selCostmode[i]);
				if (ioBound[i] != null)
					model.setIoBound(ioBound[i]);
				if (hidPeriod[i] != null)
					model.setHidPeriod(hidPeriod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (comboSvcProviderPrnt[i] != null)
					model.setComboSvcProviderPrnt(comboSvcProviderPrnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (comboSvcProviderChld[i] != null)
					model.setComboSvcProviderChld(comboSvcProviderChld[i]);
				if (hidFromNode[i] != null)
					model.setHidFromNode(hidFromNode[i]);
				if (selBkgterm[i] != null)
					model.setSelBkgterm(selBkgterm[i]);
				if (radioOffice[i] != null)
					model.setRadioOffice(radioOffice[i]);
				if (selSotype[i] != null)
					model.setSelSotype(selSotype[i]);
				if (hidDoorNode[i] != null)
					model.setHidDoorNode(hidDoorNode[i]);
				if (inputOffice[i] != null)
					model.setInputOffice(inputOffice[i]);
				if (hidFromDate[i] != null)
					model.setHidFromDate(hidFromDate[i]);
				if (nodeDiv[i] != null)
					model.setNodeDiv(nodeDiv[i]);
				if (statusCd[i] != null)
					model.setStatusCd(statusCd[i]);
				if (etsYn[i] != null)
					model.setStatusCd(etsYn[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchHeaderVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchHeaderVO[]
	 */
	public SearchHeaderVO[] getSearchHeaderVOs(){
		SearchHeaderVO[] vos = (SearchHeaderVO[])models.toArray(new SearchHeaderVO[models.size()]);
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
		this.selTransmode = this.selTransmode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidToDate = this.hidToDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spTp = this.spTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkPrntProvider = this.chkPrntProvider .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidToNode = this.hidToNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidViaNode = this.hidViaNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selCostmode = this.selCostmode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBound = this.ioBound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidPeriod = this.hidPeriod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comboSvcProviderPrnt = this.comboSvcProviderPrnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comboSvcProviderChld = this.comboSvcProviderChld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidFromNode = this.hidFromNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selBkgterm = this.selBkgterm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.radioOffice = this.radioOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selSotype = this.selSotype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidDoorNode = this.hidDoorNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputOffice = this.inputOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidFromDate = this.hidFromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodeDiv = this.nodeDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusCd = this.statusCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.etsYn = this.etsYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		
	}
}
