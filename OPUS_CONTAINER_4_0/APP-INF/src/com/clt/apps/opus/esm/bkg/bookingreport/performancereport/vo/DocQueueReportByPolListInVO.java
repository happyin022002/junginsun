/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DocQueueReportByPolListInVO.java
*@FileTitle : DocQueueReportByPolListInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.17 김경섭 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocQueueReportByPolListInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocQueueReportByPolListInVO> models = new ArrayList<DocQueueReportByPolListInVO>();
	
	/* Column Info */
	private String etdFromDt = null;
	/* Column Info */
	private String queueSource = null;
	/* Column Info */
	private String bstMatch = null;
	/* Column Info */
	private String pctFromDt = null;
	/* Column Info */
	private String totalVvd = null;
	/* Column Info */
	private String etdToDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rowsPerPage = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String currPage = null;
	/* Column Info */
	private String bkgOfc = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String srFromDt = null;
	/* Column Info */
	private String uiId = null;
	/* Column Info */
	private String srToDt = null;
	/* Column Info */
	private String periodGubun = null;
	/* Column Info */
	private String pctToDt = null;
	/* Column Info */
	private String listByQueue = null;
	/* Column Info */
	private String docPart = null;
	/* Column Info */
	private String docPartEu = null;
	/* Column Info */
	private String docPartJp = null;
	/* Column Info */
	private String docPartSw = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocQueueReportByPolListInVO() {}

	public DocQueueReportByPolListInVO(String ibflag, String pagerows, String periodGubun, String etdFromDt, String etdToDt, String polCd, String totalVvd, String bstMatch, String srFromDt, String srToDt, String bkgOfc, String listByQueue, String pctFromDt, String pctToDt, String queueSource, String uiId, String usrId, String currPage, String rowsPerPage, String docPart, String docPartEu, String docPartJp,String docPartSw) {
		this.etdFromDt = etdFromDt;
		this.queueSource = queueSource;
		this.bstMatch = bstMatch;
		this.pctFromDt = pctFromDt;
		this.totalVvd = totalVvd;
		this.etdToDt = etdToDt;
		this.pagerows = pagerows;
		this.rowsPerPage = rowsPerPage;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.currPage = currPage;
		this.bkgOfc = bkgOfc;
		this.usrId = usrId;
		this.srFromDt = srFromDt;
		this.uiId = uiId;
		this.srToDt = srToDt;
		this.periodGubun = periodGubun;
		this.pctToDt = pctToDt;
		this.listByQueue = listByQueue;
		this.docPart = docPart;
		this.docPartEu = docPartEu;
		this.docPartJp = docPartJp;
		this.docPartSw = docPartSw;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("etd_from_dt", getEtdFromDt());
		this.hashColumns.put("queue_source", getQueueSource());
		this.hashColumns.put("bst_match", getBstMatch());
		this.hashColumns.put("pct_from_dt", getPctFromDt());
		this.hashColumns.put("total_vvd", getTotalVvd());
		this.hashColumns.put("etd_to_dt", getEtdToDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rows_per_page", getRowsPerPage());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("curr_page", getCurrPage());
		this.hashColumns.put("bkg_ofc", getBkgOfc());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("sr_from_dt", getSrFromDt());
		this.hashColumns.put("ui_id", getUiId());
		this.hashColumns.put("sr_to_dt", getSrToDt());
		this.hashColumns.put("period_gubun", getPeriodGubun());
		this.hashColumns.put("pct_to_dt", getPctToDt());
		this.hashColumns.put("list_by_queue", getListByQueue());
		this.hashColumns.put("doc_part", getDocPart());
		this.hashColumns.put("doc_part_eu", getDocPartEu());
		this.hashColumns.put("doc_part_jp", getDocPartJp());
		this.hashColumns.put("doc_part_sw", getDocPartSw());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("etd_from_dt", "etdFromDt");
		this.hashFields.put("queue_source", "queueSource");
		this.hashFields.put("bst_match", "bstMatch");
		this.hashFields.put("pct_from_dt", "pctFromDt");
		this.hashFields.put("total_vvd", "totalVvd");
		this.hashFields.put("etd_to_dt", "etdToDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rows_per_page", "rowsPerPage");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("curr_page", "currPage");
		this.hashFields.put("bkg_ofc", "bkgOfc");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("sr_from_dt", "srFromDt");
		this.hashFields.put("ui_id", "uiId");
		this.hashFields.put("sr_to_dt", "srToDt");
		this.hashFields.put("period_gubun", "periodGubun");
		this.hashFields.put("pct_to_dt", "pctToDt");
		this.hashFields.put("list_by_queue", "listByQueue");
		this.hashFields.put("doc_part", "docPart");
		this.hashFields.put("doc_part_eu", "docPartEu");
		this.hashFields.put("doc_part_jp", "docPartJp");
		this.hashFields.put("doc_part_sw", "docPartSw");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return etdFromDt
	 */
	public String getEtdFromDt() {
		return this.etdFromDt;
	}
	
	/**
	 * Column Info
	 * @return queueSource
	 */
	public String getQueueSource() {
		return this.queueSource;
	}
	
	/**
	 * Column Info
	 * @return bstMatch
	 */
	public String getBstMatch() {
		return this.bstMatch;
	}
	
	/**
	 * Column Info
	 * @return pctFromDt
	 */
	public String getPctFromDt() {
		return this.pctFromDt;
	}
	
	/**
	 * Column Info
	 * @return totalVvd
	 */
	public String getTotalVvd() {
		return this.totalVvd;
	}
	
	/**
	 * Column Info
	 * @return etdToDt
	 */
	public String getEtdToDt() {
		return this.etdToDt;
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
	 * @return rowsPerPage
	 */
	public String getRowsPerPage() {
		return this.rowsPerPage;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return currPage
	 */
	public String getCurrPage() {
		return this.currPage;
	}
	
	/**
	 * Column Info
	 * @return bkgOfc
	 */
	public String getBkgOfc() {
		return this.bkgOfc;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return srFromDt
	 */
	public String getSrFromDt() {
		return this.srFromDt;
	}
	
	/**
	 * Column Info
	 * @return uiId
	 */
	public String getUiId() {
		return this.uiId;
	}
	
	/**
	 * Column Info
	 * @return srToDt
	 */
	public String getSrToDt() {
		return this.srToDt;
	}
	
	/**
	 * Column Info
	 * @return periodGubun
	 */
	public String getPeriodGubun() {
		return this.periodGubun;
	}
	
	/**
	 * Column Info
	 * @return pctToDt
	 */
	public String getPctToDt() {
		return this.pctToDt;
	}
	
	/**
	 * Column Info
	 * @return listByQueue
	 */
	public String getListByQueue() {
		return this.listByQueue;
	}
	/**
	 * Column Info
	 * @return docPart
	 */
	public String getDocPart() {
		return this.docPart;
	}
	
	/**
	 * Column Info
	 * @return docPartEu
	 */
	public String getDocPartEu() {
		return this.docPartEu;
	}
	
	/**
	 * Column Info
	 * @return docPartJp
	 */
	public String getDocPartJp() {
		return this.docPartJp;
	}
	
	/**
	 * Column Info
	 * @return docPartSw
	 */
	public String getDocPartSw() {
		return this.docPartSw;
	}

	/**
	 * Column Info
	 * @param etdFromDt
	 */
	public void setEtdFromDt(String etdFromDt) {
		this.etdFromDt = etdFromDt;
	}
	
	/**
	 * Column Info
	 * @param queueSource
	 */
	public void setQueueSource(String queueSource) {
		this.queueSource = queueSource;
	}
	
	/**
	 * Column Info
	 * @param bstMatch
	 */
	public void setBstMatch(String bstMatch) {
		this.bstMatch = bstMatch;
	}
	
	/**
	 * Column Info
	 * @param pctFromDt
	 */
	public void setPctFromDt(String pctFromDt) {
		this.pctFromDt = pctFromDt;
	}
	
	/**
	 * Column Info
	 * @param totalVvd
	 */
	public void setTotalVvd(String totalVvd) {
		this.totalVvd = totalVvd;
	}
	
	/**
	 * Column Info
	 * @param etdToDt
	 */
	public void setEtdToDt(String etdToDt) {
		this.etdToDt = etdToDt;
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
	 * @param rowsPerPage
	 */
	public void setRowsPerPage(String rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param currPage
	 */
	public void setCurrPage(String currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * Column Info
	 * @param bkgOfc
	 */
	public void setBkgOfc(String bkgOfc) {
		this.bkgOfc = bkgOfc;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param srFromDt
	 */
	public void setSrFromDt(String srFromDt) {
		this.srFromDt = srFromDt;
	}
	
	/**
	 * Column Info
	 * @param uiId
	 */
	public void setUiId(String uiId) {
		this.uiId = uiId;
	}
	
	/**
	 * Column Info
	 * @param srToDt
	 */
	public void setSrToDt(String srToDt) {
		this.srToDt = srToDt;
	}
	
	/**
	 * Column Info
	 * @param periodGubun
	 */
	public void setPeriodGubun(String periodGubun) {
		this.periodGubun = periodGubun;
	}
	
	/**
	 * Column Info
	 * @param pctToDt
	 */
	public void setPctToDt(String pctToDt) {
		this.pctToDt = pctToDt;
	}
	
	/**
	 * Column Info
	 * @param listByQueue
	 */
	public void setListByQueue(String listByQueue) {
		this.listByQueue = listByQueue;
	}
	/**
	 * Column Info
	 * @param docPart
	 */
	public void setDocPart(String docPart) {
		this.docPart = docPart;
	}
	
	/**
	 * Column Info
	 * @param docPartEu
	 */
	public void setDocPartEu(String docPartEu) {
		this.docPartEu = docPartEu;
	}
	
	/**
	 * Column Info
	 * @param docPartJp
	 */
	public void setDocPartJp(String docPartJp) {
		this.docPartJp = docPartJp;
	}
	
	/**
	 * Column Info
	 * @param docPartSw
	 */
	public void setDocPartSw(String docPartSw) {
		this.docPartSw = docPartSw;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEtdFromDt(JSPUtil.getParameter(request, "etd_from_dt", ""));
		setQueueSource(JSPUtil.getParameter(request, "queue_source", ""));
		setBstMatch(JSPUtil.getParameter(request, "bst_match", ""));
		setPctFromDt(JSPUtil.getParameter(request, "pct_from_dt", ""));
		setTotalVvd(JSPUtil.getParameter(request, "total_vvd", ""));
		setEtdToDt(JSPUtil.getParameter(request, "etd_to_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRowsPerPage(JSPUtil.getParameter(request, "rows_per_page", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCurrPage(JSPUtil.getParameter(request, "curr_page", ""));
		setBkgOfc(JSPUtil.getParameter(request, "bkg_ofc", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setSrFromDt(JSPUtil.getParameter(request, "sr_from_dt", ""));
		setUiId(JSPUtil.getParameter(request, "ui_id", ""));
		setSrToDt(JSPUtil.getParameter(request, "sr_to_dt", ""));
		setPeriodGubun(JSPUtil.getParameter(request, "period_gubun", ""));
		setPctToDt(JSPUtil.getParameter(request, "pct_to_dt", ""));
		setListByQueue(JSPUtil.getParameter(request, "list_by_queue", ""));
		setDocPart(JSPUtil.getParameter(request, "doc_part", ""));
		setDocPartEu(JSPUtil.getParameter(request, "doc_part_eu", ""));
		setDocPartJp(JSPUtil.getParameter(request, "doc_part_jp", ""));
		setDocPartSw(JSPUtil.getParameter(request, "doc_part_sw", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocQueueReportByPolListInVO[]
	 */
	public DocQueueReportByPolListInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocQueueReportByPolListInVO[]
	 */
	public DocQueueReportByPolListInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocQueueReportByPolListInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] etdFromDt = (JSPUtil.getParameter(request, prefix	+ "etd_from_dt", length));
			String[] queueSource = (JSPUtil.getParameter(request, prefix	+ "queue_source", length));
			String[] bstMatch = (JSPUtil.getParameter(request, prefix	+ "bst_match", length));
			String[] pctFromDt = (JSPUtil.getParameter(request, prefix	+ "pct_from_dt", length));
			String[] totalVvd = (JSPUtil.getParameter(request, prefix	+ "total_vvd", length));
			String[] etdToDt = (JSPUtil.getParameter(request, prefix	+ "etd_to_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rowsPerPage = (JSPUtil.getParameter(request, prefix	+ "rows_per_page", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] currPage = (JSPUtil.getParameter(request, prefix	+ "curr_page", length));
			String[] bkgOfc = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] srFromDt = (JSPUtil.getParameter(request, prefix	+ "sr_from_dt", length));
			String[] uiId = (JSPUtil.getParameter(request, prefix	+ "ui_id", length));
			String[] srToDt = (JSPUtil.getParameter(request, prefix	+ "sr_to_dt", length));
			String[] periodGubun = (JSPUtil.getParameter(request, prefix	+ "period_gubun", length));
			String[] pctToDt = (JSPUtil.getParameter(request, prefix	+ "pct_to_dt", length));
			String[] listByQueue = (JSPUtil.getParameter(request, prefix	+ "list_by_queue", length));
			String[] docPart = (JSPUtil.getParameter(request, prefix	+ "doc_part", length));
			String[] docPartEu = (JSPUtil.getParameter(request, prefix	+ "doc_part_eu", length));
			String[] docPartJp = (JSPUtil.getParameter(request, prefix	+ "doc_part_jp", length));
			String[] docPartSw = (JSPUtil.getParameter(request, prefix	+ "doc_part_sw", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocQueueReportByPolListInVO();
				if (etdFromDt[i] != null)
					model.setEtdFromDt(etdFromDt[i]);
				if (queueSource[i] != null)
					model.setQueueSource(queueSource[i]);
				if (bstMatch[i] != null)
					model.setBstMatch(bstMatch[i]);
				if (pctFromDt[i] != null)
					model.setPctFromDt(pctFromDt[i]);
				if (totalVvd[i] != null)
					model.setTotalVvd(totalVvd[i]);
				if (etdToDt[i] != null)
					model.setEtdToDt(etdToDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rowsPerPage[i] != null)
					model.setRowsPerPage(rowsPerPage[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (currPage[i] != null)
					model.setCurrPage(currPage[i]);
				if (bkgOfc[i] != null)
					model.setBkgOfc(bkgOfc[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (srFromDt[i] != null)
					model.setSrFromDt(srFromDt[i]);
				if (uiId[i] != null)
					model.setUiId(uiId[i]);
				if (srToDt[i] != null)
					model.setSrToDt(srToDt[i]);
				if (periodGubun[i] != null)
					model.setPeriodGubun(periodGubun[i]);
				if (pctToDt[i] != null)
					model.setPctToDt(pctToDt[i]);
				if (listByQueue[i] != null)
					model.setListByQueue(listByQueue[i]);
				if (docPart[i] != null)
					model.setDocPart(docPart[i]);
				if (docPartEu[i] != null)
					model.setDocPartEu(docPartEu[i]);
				if (docPartJp[i] != null)
					model.setDocPartJp(docPartJp[i]);
				if (docPartSw[i] != null)
					model.setDocPartSw(docPartSw[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocQueueReportByPolListInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocQueueReportByPolListInVO[]
	 */
	public DocQueueReportByPolListInVO[] getDocQueueReportByPolListInVOs(){
		DocQueueReportByPolListInVO[] vos = (DocQueueReportByPolListInVO[])models.toArray(new DocQueueReportByPolListInVO[models.size()]);
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
		this.etdFromDt = this.etdFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.queueSource = this.queueSource .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bstMatch = this.bstMatch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctFromDt = this.pctFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalVvd = this.totalVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdToDt = this.etdToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowsPerPage = this.rowsPerPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currPage = this.currPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfc = this.bkgOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srFromDt = this.srFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uiId = this.uiId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srToDt = this.srToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodGubun = this.periodGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctToDt = this.pctToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.listByQueue = this.listByQueue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPart = this.docPart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartEu = this.docPartEu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartJp = this.docPartJp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartSw = this.docPartSw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
