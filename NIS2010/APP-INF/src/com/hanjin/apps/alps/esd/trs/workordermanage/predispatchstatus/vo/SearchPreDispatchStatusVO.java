/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchPreDispatchStatusVO.java
*@FileTitle : SearchPreDispatchStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 최진오
*@LastVersion : 1.0
* 2009.09.17 최진오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.workordermanage.predispatchstatus.vo;

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
 * @author 최진오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchPreDispatchStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPreDispatchStatusVO> models = new ArrayList<SearchPreDispatchStatusVO>();
	
	/* Column Info */
	private String woIssOfcCd = null;
	/* Column Info */
	private String comboSvcProvider = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String radWonotic = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String hidFrmdate = null;
	/* Column Info */
	private String hidTodate = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String billNo = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String referenceNo = null;

	// USE IN search01PreDispatchStatus
	private String trspSoOfcCtyCd = null;
	private String trspSoSeq      = null;
	private String trspWoSeq      = null;
	private String trspWoOfcCtyCd = null;
	private String woIssKnt       = null;
	
	private String queryParam     = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchPreDispatchStatusVO() {}

	public SearchPreDispatchStatusVO(String ibflag, String pagerows, String radWonotic, String hidFrmdate, String hidTodate, String woNo, String bkgNo, String cntrNo, String billNo, String ctrlOfcCd, String referenceNo, String woIssOfcCd, String comboSvcProvider, String trspSoOfcCtyCd, String trspSoSeq, String trspWoSeq, String trspWoOfcCtyCd, String woIssKnt, String queryParam) {
		this.woIssOfcCd = woIssOfcCd;
		this.comboSvcProvider = comboSvcProvider;
		this.ctrlOfcCd = ctrlOfcCd;
		this.radWonotic = radWonotic;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.hidFrmdate = hidFrmdate;
		this.hidTodate = hidTodate;
		this.cntrNo = cntrNo;
		this.billNo = billNo;
		this.woNo = woNo;
		this.referenceNo = referenceNo;
		// USE IN search01PreDispatchStatus
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.trspSoSeq      = trspSoSeq     ;
		this.trspWoSeq      = trspWoSeq     ;
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
		this.woIssKnt       = woIssKnt      ;
		
		this.queryParam     = queryParam    ;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("wo_iss_ofc_cd", getWoIssOfcCd());
		this.hashColumns.put("combo_svc_provider", getComboSvcProvider());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("rad_wonotic", getRadWonotic());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("hid_frmdate", getHidFrmdate());
		this.hashColumns.put("hid_todate", getHidTodate());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("bill_no", getBillNo());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("reference_no", getReferenceNo());
		// USE IN search01PreDispatchStatus
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("trsp_wo_seq", getTrspWoSeq());
		this.hashColumns.put("trsp_wo_ofc_cty_cd", getTrspWoOfcCtyCd());
		this.hashColumns.put("wo_iss_knt", getWoIssKnt());
		
		this.hashColumns.put("queryParam", getQueryParam());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("wo_iss_ofc_cd", "woIssOfcCd");
		this.hashFields.put("combo_svc_provider", "comboSvcProvider");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("rad_wonotic", "radWonotic");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("hid_frmdate", "hidFrmdate");
		this.hashFields.put("hid_todate", "hidTodate");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bill_no", "billNo");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("reference_no", "referenceNo");
		
		// USE IN search01PreDispatchStatus
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("trsp_wo_seq", "trspWoSeq");
		this.hashFields.put("trsp_wo_ofc_cty_cd", "trspWoOfcCtyCd");
		this.hashFields.put("wo_iss_knt", "woIssKnt");
		
		this.hashFields.put("queryParam", "queryParam");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return woIssOfcCd
	 */
	public String getWoIssOfcCd() {
		return this.woIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @return comboSvcProvider
	 */
	public String getComboSvcProvider() {
		return this.comboSvcProvider;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return radWonotic
	 */
	public String getRadWonotic() {
		return this.radWonotic;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return hidFrmdate
	 */
	public String getHidFrmdate() {
		return this.hidFrmdate;
	}
	
	/**
	 * Column Info
	 * @return hidTodate
	 */
	public String getHidTodate() {
		return this.hidTodate;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return billNo
	 */
	public String getBillNo() {
		return this.billNo;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return referenceNo
	 */
	public String getReferenceNo() {
		return this.referenceNo;
	}
	
	
	
	/**
	 * Column Info
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return trspSoOfcCtyCd;
	}

	/**
	 * Column Info
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return trspSoSeq;
	}

	/**
	 * Column Info
	 * @return trspWoSeq
	 */
	public String getTrspWoSeq() {
		return trspWoSeq;
	}

	/**
	 * Column Info
	 * @return trspWoOfcCtyCd
	 */
	public String getTrspWoOfcCtyCd() {
		return trspWoOfcCtyCd;
	}

	/**
	 * Column Info
	 * @return woIssKnt
	 */
	public String getWoIssKnt() {
		return woIssKnt;
	}
		
	public String getQueryParam() {
		return queryParam;
	}

	/**
	 * Column Info
	 * @param woIssOfcCd
	 */
	public void setWoIssOfcCd(String woIssOfcCd) {
		this.woIssOfcCd = woIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @param comboSvcProvider
	 */
	public void setComboSvcProvider(String comboSvcProvider) {
		this.comboSvcProvider = comboSvcProvider;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param radWonotic
	 */
	public void setRadWonotic(String radWonotic) {
		this.radWonotic = radWonotic;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param hidFrmdate
	 */
	public void setHidFrmdate(String hidFrmdate) {
		this.hidFrmdate = hidFrmdate;
	}
	
	/**
	 * Column Info
	 * @param hidTodate
	 */
	public void setHidTodate(String hidTodate) {
		this.hidTodate = hidTodate;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param billNo
	 */
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param referenceNo
	 */
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	/**
	 * Column Info
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}

	/**
	 * Column Info
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}

	/**
	 * Column Info
	 * @param trspWoSeq
	 */
	public void setTrspWoSeq(String trspWoSeq) {
		this.trspWoSeq = trspWoSeq;
	}

	/**
	 * Column Info
	 * @param trspWoOfcCtyCd
	 */
	public void setTrspWoOfcCtyCd(String trspWoOfcCtyCd) {
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
	}

	/**
	 * Column Info
	 * @param woIssKnt
	 */
	public void setWoIssKnt(String woIssKnt) {
		this.woIssKnt = woIssKnt;
	}

	public void setQueryParam(String queryParam) {
		this.queryParam = queryParam;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setWoIssOfcCd(JSPUtil.getParameter(request, "wo_iss_ofc_cd", ""));
		setComboSvcProvider(JSPUtil.getParameter(request, "combo_svc_provider", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		setRadWonotic(JSPUtil.getParameter(request, "rad_wonotic", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setHidFrmdate(JSPUtil.getParameter(request, "hid_frmdate", ""));
		setHidTodate(JSPUtil.getParameter(request, "hid_todate", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setBillNo(JSPUtil.getParameter(request, "bill_no", ""));
		setWoNo(JSPUtil.getParameter(request, "wo_no", ""));
		setReferenceNo(JSPUtil.getParameter(request, "reference_no", ""));
		// USE IN search01PreDispatchStatus
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, "trsp_so_ofc_cty_cd", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, "trsp_so_seq", ""));
		setTrspWoSeq(JSPUtil.getParameter(request, "trsp_wo_seq", ""));
		setTrspWoOfcCtyCd(JSPUtil.getParameter(request, "trsp_wo_ofc_cty_cd", ""));
		setWoIssKnt(JSPUtil.getParameter(request, "wo_iss_knt", ""));
		setQueryParam(JSPUtil.getParameter(request, "queryParam", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPreDispatchStatusVO[]
	 */
	public SearchPreDispatchStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPreDispatchStatusVO[]
	 */
	public SearchPreDispatchStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPreDispatchStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] woIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "wo_iss_ofc_cd", length));
			String[] comboSvcProvider = (JSPUtil.getParameter(request, prefix	+ "combo_svc_provider", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] radWonotic = (JSPUtil.getParameter(request, prefix	+ "rad_wonotic", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] hidFrmdate = (JSPUtil.getParameter(request, prefix	+ "hid_frmdate", length));
			String[] hidTodate = (JSPUtil.getParameter(request, prefix	+ "hid_todate", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] billNo = (JSPUtil.getParameter(request, prefix	+ "bill_no", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] referenceNo = (JSPUtil.getParameter(request, prefix	+ "reference_no", length));
			
			//USE IN
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] trspSoSeq      = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] trspWoSeq      = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_seq", length));
			String[] trspWoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_ofc_cty_cd", length));
			String[] woIssKnt       = (JSPUtil.getParameter(request, prefix	+ "wo_iss_knt", length));
			
			String[] queryParam     = (JSPUtil.getParameter(request, prefix	+ "queryParam", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPreDispatchStatusVO();
				if (woIssOfcCd[i] != null)
					model.setWoIssOfcCd(woIssOfcCd[i]);
				if (comboSvcProvider[i] != null)
					model.setComboSvcProvider(comboSvcProvider[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (radWonotic[i] != null)
					model.setRadWonotic(radWonotic[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (hidFrmdate[i] != null)
					model.setHidFrmdate(hidFrmdate[i]);
				if (hidTodate[i] != null)
					model.setHidTodate(hidTodate[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (billNo[i] != null)
					model.setBillNo(billNo[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (referenceNo[i] != null)
					model.setReferenceNo(referenceNo[i]);
				
				// USE IN search01PreDispatchStatus
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);		
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (trspWoSeq[i] != null)
					model.setTrspWoSeq(trspWoSeq[i]);
				if (trspWoOfcCtyCd[i] != null)
					model.setTrspWoOfcCtyCd(trspWoOfcCtyCd[i]);
				if (woIssKnt[i] != null)
					model.setWoIssKnt(woIssKnt[i]);
				if (queryParam[i] != null)
					model.setQueryParam(queryParam[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPreDispatchStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPreDispatchStatusVO[]
	 */
	public SearchPreDispatchStatusVO[] getSearchPreDispatchStatusVOs(){
		SearchPreDispatchStatusVO[] vos = (SearchPreDispatchStatusVO[])models.toArray(new SearchPreDispatchStatusVO[models.size()]);
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
		this.woIssOfcCd = this.woIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comboSvcProvider = this.comboSvcProvider .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.radWonotic = this.radWonotic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidFrmdate = this.hidFrmdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidTodate = this.hidTodate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billNo = this.billNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.referenceNo = this.referenceNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		//USE IN search01PreDispatchStatus
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq      = this.trspSoSeq      .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoSeq      = this.trspWoSeq      .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCd = this.trspWoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssKnt       = this.woIssKnt       .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.queryParam     = this.queryParam     .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
