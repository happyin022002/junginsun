/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepairResultINVO.java
*@FileTitle : RepairResultINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.26  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepairResultINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RepairResultINVO> models = new ArrayList<RepairResultINVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String mnrGrpTpCd = null;
	/* Column Info */
	private String rqstRefNo = null;
	/* Column Info */
	private String fGubuns = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String mnrRtTpCd = null;
	/* Column Info */
	private String costDtlCd = null;
	/* Column Info */
	private String mnrWoTpCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ordHdrRmk = null;
	/* Column Info */
	private String tocal = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String mnrOrdSeq = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String rprQty = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String fromcal = null;
	/* Column Info */
	private String rprRsltSts = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RepairResultINVO() {}

	public RepairResultINVO(String ibflag, String pagerows, String currCd, String costOfcCd, String mnrGrpTpCd, String fGubuns, String agmtSeq, String mnrRtTpCd, String costDtlCd, String mnrWoTpCd, String eqKndCd, String ordHdrRmk, String costCd, String mnrOrdSeq, String vndrSeq, String agmtOfcCtyCd, String fileSeq, String rprQty, String agmtVerNo, String fromcal, String tocal, String rqstRefNo, String eqNo, String rprRsltSts) {
		this.currCd = currCd;
		this.costOfcCd = costOfcCd;
		this.mnrGrpTpCd = mnrGrpTpCd;
		this.rqstRefNo = rqstRefNo;
		this.fGubuns = fGubuns;
		this.agmtSeq = agmtSeq;
		this.mnrRtTpCd = mnrRtTpCd;
		this.costDtlCd = costDtlCd;
		this.mnrWoTpCd = mnrWoTpCd;
		this.eqKndCd = eqKndCd;
		this.pagerows = pagerows;
		this.ordHdrRmk = ordHdrRmk;
		this.tocal = tocal;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.costCd = costCd;
		this.mnrOrdSeq = mnrOrdSeq;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.vndrSeq = vndrSeq;
		this.rprQty = rprQty;
		this.fileSeq = fileSeq;
		this.agmtVerNo = agmtVerNo;
		this.fromcal = fromcal;
		this.rprRsltSts = rprRsltSts;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("mnr_grp_tp_cd", getMnrGrpTpCd());
		this.hashColumns.put("rqst_ref_no", getRqstRefNo());
		this.hashColumns.put("f_gubuns", getFGubuns());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("mnr_rt_tp_cd", getMnrRtTpCd());
		this.hashColumns.put("cost_dtl_cd", getCostDtlCd());
		this.hashColumns.put("mnr_wo_tp_cd", getMnrWoTpCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ord_hdr_rmk", getOrdHdrRmk());
		this.hashColumns.put("tocal", getTocal());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("rpr_qty", getRprQty());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("fromcal", getFromcal());
		this.hashColumns.put("rpr_rslt_sts", getRprRsltSts());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("mnr_grp_tp_cd", "mnrGrpTpCd");
		this.hashFields.put("rqst_ref_no", "rqstRefNo");
		this.hashFields.put("f_gubuns", "fGubuns");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("mnr_rt_tp_cd", "mnrRtTpCd");
		this.hashFields.put("cost_dtl_cd", "costDtlCd");
		this.hashFields.put("mnr_wo_tp_cd", "mnrWoTpCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ord_hdr_rmk", "ordHdrRmk");
		this.hashFields.put("tocal", "tocal");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("rpr_qty", "rprQty");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("fromcal", "fromcal");
		this.hashFields.put("rpr_rslt_sts", "rprRsltSts");
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
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mnrGrpTpCd
	 */
	public String getMnrGrpTpCd() {
		return this.mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return rqstRefNo
	 */
	public String getRqstRefNo() {
		return this.rqstRefNo;
	}
	
	/**
	 * Column Info
	 * @return fGubuns
	 */
	public String getFGubuns() {
		return this.fGubuns;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return mnrRtTpCd
	 */
	public String getMnrRtTpCd() {
		return this.mnrRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return costDtlCd
	 */
	public String getCostDtlCd() {
		return this.costDtlCd;
	}
	
	/**
	 * Column Info
	 * @return mnrWoTpCd
	 */
	public String getMnrWoTpCd() {
		return this.mnrWoTpCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @return ordHdrRmk
	 */
	public String getOrdHdrRmk() {
		return this.ordHdrRmk;
	}
	
	/**
	 * Column Info
	 * @return tocal
	 */
	public String getTocal() {
		return this.tocal;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
	}
	
	/**
	 * Column Info
	 * @return mnrOrdSeq
	 */
	public String getMnrOrdSeq() {
		return this.mnrOrdSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return rprQty
	 */
	public String getRprQty() {
		return this.rprQty;
	}
	
	/**
	 * Column Info
	 * @return fileSeq
	 */
	public String getFileSeq() {
		return this.fileSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtVerNo
	 */
	public String getAgmtVerNo() {
		return this.agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @return fromcal
	 */
	public String getFromcal() {
		return this.fromcal;
	}
	
	/**
	 * Column Info
	 * @return rprRsltSts
	 */
	public String getRprRsltSts() {
		return this.rprRsltSts;
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
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mnrGrpTpCd
	 */
	public void setMnrGrpTpCd(String mnrGrpTpCd) {
		this.mnrGrpTpCd = mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param rqstRefNo
	 */
	public void setRqstRefNo(String rqstRefNo) {
		this.rqstRefNo = rqstRefNo;
	}
	
	/**
	 * Column Info
	 * @param fGubuns
	 */
	public void setFGubuns(String fGubuns) {
		this.fGubuns = fGubuns;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param mnrRtTpCd
	 */
	public void setMnrRtTpCd(String mnrRtTpCd) {
		this.mnrRtTpCd = mnrRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param costDtlCd
	 */
	public void setCostDtlCd(String costDtlCd) {
		this.costDtlCd = costDtlCd;
	}
	
	/**
	 * Column Info
	 * @param mnrWoTpCd
	 */
	public void setMnrWoTpCd(String mnrWoTpCd) {
		this.mnrWoTpCd = mnrWoTpCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
	 * @param ordHdrRmk
	 */
	public void setOrdHdrRmk(String ordHdrRmk) {
		this.ordHdrRmk = ordHdrRmk;
	}
	
	/**
	 * Column Info
	 * @param tocal
	 */
	public void setTocal(String tocal) {
		this.tocal = tocal;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	
	/**
	 * Column Info
	 * @param mnrOrdSeq
	 */
	public void setMnrOrdSeq(String mnrOrdSeq) {
		this.mnrOrdSeq = mnrOrdSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param rprQty
	 */
	public void setRprQty(String rprQty) {
		this.rprQty = rprQty;
	}
	
	/**
	 * Column Info
	 * @param fileSeq
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtVerNo
	 */
	public void setAgmtVerNo(String agmtVerNo) {
		this.agmtVerNo = agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @param fromcal
	 */
	public void setFromcal(String fromcal) {
		this.fromcal = fromcal;
	}
	
	/**
	 * Column Info
	 * @param rprRsltSts
	 */
	public void setRprRsltSts(String rprRsltSts) {
		this.rprRsltSts = rprRsltSts;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setCostOfcCd(JSPUtil.getParameter(request, "cost_ofc_cd", ""));
		setMnrGrpTpCd(JSPUtil.getParameter(request, "mnr_grp_tp_cd", ""));
		setRqstRefNo(JSPUtil.getParameter(request, "rqst_ref_no", ""));
		setFGubuns(JSPUtil.getParameter(request, "f_gubuns", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setMnrRtTpCd(JSPUtil.getParameter(request, "mnr_rt_tp_cd", ""));
		setCostDtlCd(JSPUtil.getParameter(request, "cost_dtl_cd", ""));
		setMnrWoTpCd(JSPUtil.getParameter(request, "mnr_wo_tp_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOrdHdrRmk(JSPUtil.getParameter(request, "ord_hdr_rmk", ""));
		setTocal(JSPUtil.getParameter(request, "tocal", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setCostCd(JSPUtil.getParameter(request, "cost_cd", ""));
		setMnrOrdSeq(JSPUtil.getParameter(request, "mnr_ord_seq", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setRprQty(JSPUtil.getParameter(request, "rpr_qty", ""));
		setFileSeq(JSPUtil.getParameter(request, "file_seq", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, "agmt_ver_no", ""));
		setFromcal(JSPUtil.getParameter(request, "fromcal", ""));
		setRprRsltSts(JSPUtil.getParameter(request, "rpr_rslt_sts", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RepairResultINVO[]
	 */
	public RepairResultINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RepairResultINVO[]
	 */
	public RepairResultINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RepairResultINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] mnrGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_grp_tp_cd", length));
			String[] rqstRefNo = (JSPUtil.getParameter(request, prefix	+ "rqst_ref_no", length));
			String[] fGubuns = (JSPUtil.getParameter(request, prefix	+ "f_gubuns", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] mnrRtTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_rt_tp_cd", length));
			String[] costDtlCd = (JSPUtil.getParameter(request, prefix	+ "cost_dtl_cd", length));
			String[] mnrWoTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_wo_tp_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ordHdrRmk = (JSPUtil.getParameter(request, prefix	+ "ord_hdr_rmk", length));
			String[] tocal = (JSPUtil.getParameter(request, prefix	+ "tocal", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] mnrOrdSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_seq", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] rprQty = (JSPUtil.getParameter(request, prefix	+ "rpr_qty", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] fromcal = (JSPUtil.getParameter(request, prefix	+ "fromcal", length));
			String[] rprRsltSts = (JSPUtil.getParameter(request, prefix	+ "rpr_rslt_sts", length));
			
			for (int i = 0; i < length; i++) {
				model = new RepairResultINVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (mnrGrpTpCd[i] != null)
					model.setMnrGrpTpCd(mnrGrpTpCd[i]);
				if (rqstRefNo[i] != null)
					model.setRqstRefNo(rqstRefNo[i]);
				if (fGubuns[i] != null)
					model.setFGubuns(fGubuns[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (mnrRtTpCd[i] != null)
					model.setMnrRtTpCd(mnrRtTpCd[i]);
				if (costDtlCd[i] != null)
					model.setCostDtlCd(costDtlCd[i]);
				if (mnrWoTpCd[i] != null)
					model.setMnrWoTpCd(mnrWoTpCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ordHdrRmk[i] != null)
					model.setOrdHdrRmk(ordHdrRmk[i]);
				if (tocal[i] != null)
					model.setTocal(tocal[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (mnrOrdSeq[i] != null)
					model.setMnrOrdSeq(mnrOrdSeq[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (rprQty[i] != null)
					model.setRprQty(rprQty[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (fromcal[i] != null)
					model.setFromcal(fromcal[i]);
				if (rprRsltSts[i] != null)
					model.setRprRsltSts(rprRsltSts[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRepairResultINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RepairResultINVO[]
	 */
	public RepairResultINVO[] getRepairResultINVOs(){
		RepairResultINVO[] vos = (RepairResultINVO[])models.toArray(new RepairResultINVO[models.size()]);
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
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrGrpTpCd = this.mnrGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstRefNo = this.rqstRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fGubuns = this.fGubuns .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrRtTpCd = this.mnrRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDtlCd = this.costDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrWoTpCd = this.mnrWoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordHdrRmk = this.ordHdrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tocal = this.tocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSeq = this.mnrOrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprQty = this.rprQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromcal = this.fromcal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRsltSts = this.rprRsltSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
