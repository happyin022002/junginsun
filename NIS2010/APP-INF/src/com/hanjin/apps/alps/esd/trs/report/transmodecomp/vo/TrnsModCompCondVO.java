/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TrnsModCompCondVO.java
*@FileTitle : TrnsModCompCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.13  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.report.transmodecomp.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TrnsModCompCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TrnsModCompCondVO> models = new ArrayList<TrnsModCompCondVO>();
	
	/* Column Info */
	private String selCtrtNo = null;
	/* Column Info */
	private String selBkgNo = null;
	/* Column Info */
	private String searchViaNode = null;
	/* Column Info */
	private String selBkgTrnsMod = null;
	/* Column Info */
	private String soWoNo = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String searchFmNode = null;
	/* Column Info */
	private String selResult = null;
	/* Column Info */
	private String selPnl = null;
	/* Column Info */
	private String selSoWo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String searchToNode = null;
	/* Column Info */
	private String selCntrNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String selSoTrnsMod = null;
	/* Column Info */
	private String fromDate = null;
	/* Column Info */
	private String ioBound = null;
	/* Column Info */
	private String selWo = null;
	/* Column Info */
	private String searchDoorNode = null;
	/* Column Info */
	private String inputOffice = null;
	/* Column Info */
	private String selDate = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TrnsModCompCondVO() {}

	public TrnsModCompCondVO(String ibflag, String pagerows, String selDate, String fromDate, String toDate, String inputOffice, String ioBound, String selWo, String selSoTrnsMod, String selBkgTrnsMod, String selResult, String selPnl, String selSoWo, String soWoNo, String selCtrtNo, String selBkgNo, String selCntrNo, String searchFmNode, String searchViaNode, String searchToNode, String searchDoorNode) {
		this.selCtrtNo = selCtrtNo;
		this.selBkgNo = selBkgNo;
		this.searchViaNode = searchViaNode;
		this.selBkgTrnsMod = selBkgTrnsMod;
		this.soWoNo = soWoNo;
		this.toDate = toDate;
		this.searchFmNode = searchFmNode;
		this.selResult = selResult;
		this.selPnl = selPnl;
		this.selSoWo = selSoWo;
		this.pagerows = pagerows;
		this.searchToNode = searchToNode;
		this.selCntrNo = selCntrNo;
		this.ibflag = ibflag;
		this.selSoTrnsMod = selSoTrnsMod;
		this.fromDate = fromDate;
		this.ioBound = ioBound;
		this.selWo = selWo;
		this.searchDoorNode = searchDoorNode;
		this.inputOffice = inputOffice;
		this.selDate = selDate;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sel_ctrt_no", getSelCtrtNo());
		this.hashColumns.put("sel_bkg_no", getSelBkgNo());
		this.hashColumns.put("search_via_node", getSearchViaNode());
		this.hashColumns.put("sel_bkg_trns_mod", getSelBkgTrnsMod());
		this.hashColumns.put("so_wo_no", getSoWoNo());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("search_fm_node", getSearchFmNode());
		this.hashColumns.put("sel_result", getSelResult());
		this.hashColumns.put("sel_pnl", getSelPnl());
		this.hashColumns.put("sel_so_wo", getSelSoWo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("search_to_node", getSearchToNode());
		this.hashColumns.put("sel_cntr_no", getSelCntrNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sel_so_trns_mod", getSelSoTrnsMod());
		this.hashColumns.put("from_date", getFromDate());
		this.hashColumns.put("io_bound", getIoBound());
		this.hashColumns.put("sel_wo", getSelWo());
		this.hashColumns.put("search_door_node", getSearchDoorNode());
		this.hashColumns.put("input_office", getInputOffice());
		this.hashColumns.put("sel_date", getSelDate());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sel_ctrt_no", "selCtrtNo");
		this.hashFields.put("sel_bkg_no", "selBkgNo");
		this.hashFields.put("search_via_node", "searchViaNode");
		this.hashFields.put("sel_bkg_trns_mod", "selBkgTrnsMod");
		this.hashFields.put("so_wo_no", "soWoNo");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("search_fm_node", "searchFmNode");
		this.hashFields.put("sel_result", "selResult");
		this.hashFields.put("sel_pnl", "selPnl");
		this.hashFields.put("sel_so_wo", "selSoWo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("search_to_node", "searchToNode");
		this.hashFields.put("sel_cntr_no", "selCntrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sel_so_trns_mod", "selSoTrnsMod");
		this.hashFields.put("from_date", "fromDate");
		this.hashFields.put("io_bound", "ioBound");
		this.hashFields.put("sel_wo", "selWo");
		this.hashFields.put("search_door_node", "searchDoorNode");
		this.hashFields.put("input_office", "inputOffice");
		this.hashFields.put("sel_date", "selDate");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return selCtrtNo
	 */
	public String getSelCtrtNo() {
		return this.selCtrtNo;
	}
	
	/**
	 * Column Info
	 * @return selBkgNo
	 */
	public String getSelBkgNo() {
		return this.selBkgNo;
	}
	
	/**
	 * Column Info
	 * @return searchViaNode
	 */
	public String getSearchViaNode() {
		return this.searchViaNode;
	}
	
	/**
	 * Column Info
	 * @return selBkgTrnsMod
	 */
	public String getSelBkgTrnsMod() {
		return this.selBkgTrnsMod;
	}
	
	/**
	 * Column Info
	 * @return soWoNo
	 */
	public String getSoWoNo() {
		return this.soWoNo;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
	}
	
	/**
	 * Column Info
	 * @return searchFmNode
	 */
	public String getSearchFmNode() {
		return this.searchFmNode;
	}
	
	/**
	 * Column Info
	 * @return selResult
	 */
	public String getSelResult() {
		return this.selResult;
	}
	
	/**
	 * Column Info
	 * @return selPnl
	 */
	public String getSelPnl() {
		return this.selPnl;
	}
	
	/**
	 * Column Info
	 * @return selSoWo
	 */
	public String getSelSoWo() {
		return this.selSoWo;
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
	 * @return searchToNode
	 */
	public String getSearchToNode() {
		return this.searchToNode;
	}
	
	/**
	 * Column Info
	 * @return selCntrNo
	 */
	public String getSelCntrNo() {
		return this.selCntrNo;
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
	 * @return selSoTrnsMod
	 */
	public String getSelSoTrnsMod() {
		return this.selSoTrnsMod;
	}
	
	/**
	 * Column Info
	 * @return fromDate
	 */
	public String getFromDate() {
		return this.fromDate;
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
	 * @return selWo
	 */
	public String getSelWo() {
		return this.selWo;
	}
	
	/**
	 * Column Info
	 * @return searchDoorNode
	 */
	public String getSearchDoorNode() {
		return this.searchDoorNode;
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
	 * @return selDate
	 */
	public String getSelDate() {
		return this.selDate;
	}
	

	/**
	 * Column Info
	 * @param selCtrtNo
	 */
	public void setSelCtrtNo(String selCtrtNo) {
		this.selCtrtNo = selCtrtNo;
	}
	
	/**
	 * Column Info
	 * @param selBkgNo
	 */
	public void setSelBkgNo(String selBkgNo) {
		this.selBkgNo = selBkgNo;
	}
	
	/**
	 * Column Info
	 * @param searchViaNode
	 */
	public void setSearchViaNode(String searchViaNode) {
		this.searchViaNode = searchViaNode;
	}
	
	/**
	 * Column Info
	 * @param selBkgTrnsMod
	 */
	public void setSelBkgTrnsMod(String selBkgTrnsMod) {
		this.selBkgTrnsMod = selBkgTrnsMod;
	}
	
	/**
	 * Column Info
	 * @param soWoNo
	 */
	public void setSoWoNo(String soWoNo) {
		this.soWoNo = soWoNo;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * Column Info
	 * @param searchFmNode
	 */
	public void setSearchFmNode(String searchFmNode) {
		this.searchFmNode = searchFmNode;
	}
	
	/**
	 * Column Info
	 * @param selResult
	 */
	public void setSelResult(String selResult) {
		this.selResult = selResult;
	}
	
	/**
	 * Column Info
	 * @param selPnl
	 */
	public void setSelPnl(String selPnl) {
		this.selPnl = selPnl;
	}
	
	/**
	 * Column Info
	 * @param selSoWo
	 */
	public void setSelSoWo(String selSoWo) {
		this.selSoWo = selSoWo;
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
	 * @param searchToNode
	 */
	public void setSearchToNode(String searchToNode) {
		this.searchToNode = searchToNode;
	}
	
	/**
	 * Column Info
	 * @param selCntrNo
	 */
	public void setSelCntrNo(String selCntrNo) {
		this.selCntrNo = selCntrNo;
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
	 * @param selSoTrnsMod
	 */
	public void setSelSoTrnsMod(String selSoTrnsMod) {
		this.selSoTrnsMod = selSoTrnsMod;
	}
	
	/**
	 * Column Info
	 * @param fromDate
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
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
	 * @param selWo
	 */
	public void setSelWo(String selWo) {
		this.selWo = selWo;
	}
	
	/**
	 * Column Info
	 * @param searchDoorNode
	 */
	public void setSearchDoorNode(String searchDoorNode) {
		this.searchDoorNode = searchDoorNode;
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
	 * @param selDate
	 */
	public void setSelDate(String selDate) {
		this.selDate = selDate;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setSelCtrtNo(JSPUtil.getParameter(request, prefix + "sel_ctrt_no", ""));
		setSelBkgNo(JSPUtil.getParameter(request, prefix + "sel_bkg_no", ""));
		setSearchViaNode(JSPUtil.getParameter(request, prefix + "search_via_node", ""));
		setSelBkgTrnsMod(JSPUtil.getParameter(request, prefix + "sel_bkg_trns_mod", ""));
		setSoWoNo(JSPUtil.getParameter(request, prefix + "so_wo_no", ""));
		setToDate(JSPUtil.getParameter(request, prefix + "to_date", ""));
		setSearchFmNode(JSPUtil.getParameter(request, prefix + "search_fm_node", ""));
		setSelResult(JSPUtil.getParameter(request, prefix + "sel_result", ""));
		setSelPnl(JSPUtil.getParameter(request, prefix + "sel_pnl", ""));
		setSelSoWo(JSPUtil.getParameter(request, prefix + "sel_so_wo", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSearchToNode(JSPUtil.getParameter(request, prefix + "search_to_node", ""));
		setSelCntrNo(JSPUtil.getParameter(request, prefix + "sel_cntr_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSelSoTrnsMod(JSPUtil.getParameter(request, prefix + "sel_so_trns_mod", ""));
		setFromDate(JSPUtil.getParameter(request, prefix + "from_date", ""));
		setIoBound(JSPUtil.getParameter(request, prefix + "io_bound", ""));
		setSelWo(JSPUtil.getParameter(request, prefix + "sel_wo", ""));
		setSearchDoorNode(JSPUtil.getParameter(request, prefix + "search_door_node", ""));
		setInputOffice(JSPUtil.getParameter(request, prefix + "input_office", ""));
		setSelDate(JSPUtil.getParameter(request, prefix + "sel_date", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrnsModCompCondVO[]
	 */
	public TrnsModCompCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrnsModCompCondVO[]
	 */
	public TrnsModCompCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrnsModCompCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] selCtrtNo = (JSPUtil.getParameter(request, prefix	+ "sel_ctrt_no", length));
			String[] selBkgNo = (JSPUtil.getParameter(request, prefix	+ "sel_bkg_no", length));
			String[] searchViaNode = (JSPUtil.getParameter(request, prefix	+ "search_via_node", length));
			String[] selBkgTrnsMod = (JSPUtil.getParameter(request, prefix	+ "sel_bkg_trns_mod", length));
			String[] soWoNo = (JSPUtil.getParameter(request, prefix	+ "so_wo_no", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] searchFmNode = (JSPUtil.getParameter(request, prefix	+ "search_fm_node", length));
			String[] selResult = (JSPUtil.getParameter(request, prefix	+ "sel_result", length));
			String[] selPnl = (JSPUtil.getParameter(request, prefix	+ "sel_pnl", length));
			String[] selSoWo = (JSPUtil.getParameter(request, prefix	+ "sel_so_wo", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] searchToNode = (JSPUtil.getParameter(request, prefix	+ "search_to_node", length));
			String[] selCntrNo = (JSPUtil.getParameter(request, prefix	+ "sel_cntr_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] selSoTrnsMod = (JSPUtil.getParameter(request, prefix	+ "sel_so_trns_mod", length));
			String[] fromDate = (JSPUtil.getParameter(request, prefix	+ "from_date", length));
			String[] ioBound = (JSPUtil.getParameter(request, prefix	+ "io_bound", length));
			String[] selWo = (JSPUtil.getParameter(request, prefix	+ "sel_wo", length));
			String[] searchDoorNode = (JSPUtil.getParameter(request, prefix	+ "search_door_node", length));
			String[] inputOffice = (JSPUtil.getParameter(request, prefix	+ "input_office", length));
			String[] selDate = (JSPUtil.getParameter(request, prefix	+ "sel_date", length));
			
			for (int i = 0; i < length; i++) {
				model = new TrnsModCompCondVO();
				if (selCtrtNo[i] != null)
					model.setSelCtrtNo(selCtrtNo[i]);
				if (selBkgNo[i] != null)
					model.setSelBkgNo(selBkgNo[i]);
				if (searchViaNode[i] != null)
					model.setSearchViaNode(searchViaNode[i]);
				if (selBkgTrnsMod[i] != null)
					model.setSelBkgTrnsMod(selBkgTrnsMod[i]);
				if (soWoNo[i] != null)
					model.setSoWoNo(soWoNo[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (searchFmNode[i] != null)
					model.setSearchFmNode(searchFmNode[i]);
				if (selResult[i] != null)
					model.setSelResult(selResult[i]);
				if (selPnl[i] != null)
					model.setSelPnl(selPnl[i]);
				if (selSoWo[i] != null)
					model.setSelSoWo(selSoWo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (searchToNode[i] != null)
					model.setSearchToNode(searchToNode[i]);
				if (selCntrNo[i] != null)
					model.setSelCntrNo(selCntrNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (selSoTrnsMod[i] != null)
					model.setSelSoTrnsMod(selSoTrnsMod[i]);
				if (fromDate[i] != null)
					model.setFromDate(fromDate[i]);
				if (ioBound[i] != null)
					model.setIoBound(ioBound[i]);
				if (selWo[i] != null)
					model.setSelWo(selWo[i]);
				if (searchDoorNode[i] != null)
					model.setSearchDoorNode(searchDoorNode[i]);
				if (inputOffice[i] != null)
					model.setInputOffice(inputOffice[i]);
				if (selDate[i] != null)
					model.setSelDate(selDate[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrnsModCompCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TrnsModCompCondVO[]
	 */
	public TrnsModCompCondVO[] getTrnsModCompCondVOs(){
		TrnsModCompCondVO[] vos = (TrnsModCompCondVO[])models.toArray(new TrnsModCompCondVO[models.size()]);
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
		this.selCtrtNo = this.selCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selBkgNo = this.selBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchViaNode = this.searchViaNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selBkgTrnsMod = this.selBkgTrnsMod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soWoNo = this.soWoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchFmNode = this.searchFmNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selResult = this.selResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selPnl = this.selPnl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selSoWo = this.selSoWo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchToNode = this.searchToNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selCntrNo = this.selCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selSoTrnsMod = this.selSoTrnsMod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDate = this.fromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBound = this.ioBound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selWo = this.selWo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDoorNode = this.searchDoorNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputOffice = this.inputOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selDate = this.selDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
