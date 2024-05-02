/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TotalLossPerformanceINVO.java
*@FileTitle : TotalLossPerformanceINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.02
*@LastModifier : 신혜정
*@LastVersion : 1.0
* 2010.07.16 박명신 
* 1.0 Creation
* --------------------------------------------------------
* 2012.02.27 신혜정 [CHM-201216419] 검색 조건 Payer Type, Payer Code 추가
* 2012.04.24 신혜정 [CHM-201217368-01] 조회조건 SCAC code 추가 및 결과 리스트 SCAC code 추가
* 2012.05.02 신혜정 [CHM-201217379] 검색조건 buyer Code 추가, 그리드 buyer name 항목 추가    
* 2013.02.13 조경완 [CHM-201322896-01] ALPS MNR-Total Loss Logic 검토 및 수정 요청
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

public class TotalLossPerformanceINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TotalLossPerformanceINVO> models = new ArrayList<TotalLossPerformanceINVO>();
	
	/* Column Info */
	private String payerCode = null;
	/* Column Info */
	private String ttlLssCmplCd = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String inStatusTp = null;
	/* Column Info */
	private String rsnCd = null;
	/* Column Info */
	private String payerType = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String totalLossNo = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String buyerCode = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String inSearchDtTp = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String usaEdiCd = null;
	/* Column Info */
	private String ttlLssDtlRsnCd = null;
	/* Column Info */
	private String eqKind = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String inOfficeTp = null;
	/* Column Info */
	private String inDays = null;
	/* Column Info */
	private String rsnCdAllFlg = null;
	/* Column Info */
	private String closeTpAllFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TotalLossPerformanceINVO() {}

	public TotalLossPerformanceINVO(String ibflag, String pagerows, String payerCode, String ttlLssCmplCd, String fmDt, String inStatusTp, String rsnCd, String payerType, String toDt, String totalLossNo, String ofcCd, String eqNo, String inSearchDtTp, String usaEdiCd, String vndrSeq, String ttlLssDtlRsnCd, String eqKind, String rhq, String buyerCode, String inOfficeTp, String inDays, String rsnCdAllFlg, String closeTpAllFlg) {
		this.payerCode = payerCode;
		this.ttlLssCmplCd = ttlLssCmplCd;
		this.fmDt = fmDt;
		this.inStatusTp = inStatusTp;
		this.rsnCd = rsnCd;
		this.payerType = payerType;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.totalLossNo = totalLossNo;
		this.ofcCd = ofcCd;
		this.buyerCode = buyerCode;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.inSearchDtTp = inSearchDtTp;
		this.vndrSeq = vndrSeq;
		this.usaEdiCd = usaEdiCd;
		this.ttlLssDtlRsnCd = ttlLssDtlRsnCd;
		this.eqKind = eqKind;
		this.rhq = rhq;
		this.inOfficeTp = inOfficeTp;
		this.inDays = inDays;
		this.rsnCdAllFlg = rsnCdAllFlg;
		this.closeTpAllFlg = closeTpAllFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("payer_code", getPayerCode());
		this.hashColumns.put("ttl_lss_cmpl_cd", getTtlLssCmplCd());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("in_status_tp", getInStatusTp());
		this.hashColumns.put("rsn_cd", getRsnCd());
		this.hashColumns.put("payer_type", getPayerType());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("total_loss_no", getTotalLossNo());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("buyer_code", getBuyerCode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("in_search_dt_tp", getInSearchDtTp());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("usa_edi_cd", getUsaEdiCd());
		this.hashColumns.put("ttl_lss_dtl_rsn_cd", getTtlLssDtlRsnCd());
		this.hashColumns.put("eq_kind", getEqKind());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("in_office_tp", getInOfficeTp());
		this.hashColumns.put("in_days", getInDays());
		this.hashColumns.put("rsn_cd_all_flg", getRsnCdAllFlg());
		this.hashColumns.put("close_tp_all_flg", getCloseTpAllFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("payer_code", "payerCode");
		this.hashFields.put("ttl_lss_cmpl_cd", "ttlLssCmplCd");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("in_status_tp", "inStatusTp");
		this.hashFields.put("rsn_cd", "rsnCd");
		this.hashFields.put("payer_type", "payerType");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("total_loss_no", "totalLossNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("buyer_code", "buyerCode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("in_search_dt_tp", "inSearchDtTp");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("usa_edi_cd", "usaEdiCd");
		this.hashFields.put("ttl_lss_dtl_rsn_cd", "ttlLssDtlRsnCd");
		this.hashFields.put("eq_kind", "eqKind");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("in_office_tp", "inOfficeTp");
		this.hashFields.put("in_days", "inDays");
		this.hashFields.put("rsn_cd_all_flg", "rsnCdAllFlg");
		this.hashFields.put("close_tp_all_flg", "closeTpAllFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return payerCode
	 */
	public String getPayerCode() {
		return this.payerCode;
	}
	
	/**
	 * Column Info
	 * @return ttlLssCmplCd
	 */
	public String getTtlLssCmplCd() {
		return this.ttlLssCmplCd;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return inStatusTp
	 */
	public String getInStatusTp() {
		return this.inStatusTp;
	}
	
	/**
	 * Column Info
	 * @return rsnCd
	 */
	public String getRsnCd() {
		return this.rsnCd;
	}
	
	/**
	 * Column Info
	 * @return payerType
	 */
	public String getPayerType() {
		return this.payerType;
	}
	
	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return totalLossNo
	 */
	public String getTotalLossNo() {
		return this.totalLossNo;
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
	 * @return buyerCode
	 */
	public String getBuyerCode() {
		return this.buyerCode;
	}
	
	/**
	 * Column Info
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
	 * @return inSearchDtTp
	 */
	public String getInSearchDtTp() {
		return this.inSearchDtTp;
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
	 * @return usaEdiCd
	 */
	public String getUsaEdiCd() {
		return this.usaEdiCd;
	}
	
	/**
	 * Column Info
	 * @return ttlLssDtlRsnCd
	 */
	public String getTtlLssDtlRsnCd() {
		return this.ttlLssDtlRsnCd;
	}
	
	/**
	 * Column Info
	 * @return eqKind
	 */
	public String getEqKind() {
		return this.eqKind;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	
	/**
	 * Column Info
	 * @return rsnCdAllFlg
	 */
	public String getRsnCdAllFlg() {
		return this.rsnCdAllFlg;
	}
	
	/**
	 * Column Info
	 * @return closeTpAllFlg
	 */
	public String getCloseTpAllFlg() {
		return this.closeTpAllFlg;
	}
	

	/**
	 * Column Info
	 * @param payerCode
	 */
	public void setPayerCode(String payerCode) {
		this.payerCode = payerCode;
	}
	
	/**
	 * Column Info
	 * @param ttlLssCmplCd
	 */
	public void setTtlLssCmplCd(String ttlLssCmplCd) {
		this.ttlLssCmplCd = ttlLssCmplCd;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param inStatusTp
	 */
	public void setInStatusTp(String inStatusTp) {
		this.inStatusTp = inStatusTp;
	}
	
	/**
	 * Column Info
	 * @param rsnCd
	 */
	public void setRsnCd(String rsnCd) {
		this.rsnCd = rsnCd;
	}
	
	/**
	 * Column Info
	 * @param payerType
	 */
	public void setPayerType(String payerType) {
		this.payerType = payerType;
	}
	
	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param totalLossNo
	 */
	public void setTotalLossNo(String totalLossNo) {
		this.totalLossNo = totalLossNo;
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
	 * @param buyerCode
	 */
	public void setBuyerCode(String buyerCode) {
		this.buyerCode = buyerCode;
	}
	
	/**
	 * Column Info
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
	 * @param inSearchDtTp
	 */
	public void setInSearchDtTp(String inSearchDtTp) {
		this.inSearchDtTp = inSearchDtTp;
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
	 * @param usaEdiCd
	 */
	public void setUsaEdiCd(String usaEdiCd) {
		this.usaEdiCd = usaEdiCd;
	}
	
	/**
	 * Column Info
	 * @param ttlLssDtlRsnCd
	 */
	public void setTtlLssDtlRsnCd(String ttlLssDtlRsnCd) {
		this.ttlLssDtlRsnCd = ttlLssDtlRsnCd;
	}
	
	/**
	 * Column Info
	 * @param eqKind
	 */
	public void setEqKind(String eqKind) {
		this.eqKind = eqKind;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Column Info
	 * @return inOfficeTp
	 */
	public String getInOfficeTp() {
		return inOfficeTp;
	}

	/**
	 * Column Info
	 * @return inDays
	 */
	public String getInDays() {
		return inDays;
	}

	/**
	 * Column Info
	 * @param inOfficeTp
	 */
	public void setInOfficeTp(String inOfficeTp) {
		this.inOfficeTp = inOfficeTp;
	}

	/**
	 * Column Info
	 * @param inDays
	 */
	public void setInDays(String inDays) {
		this.inDays = inDays;
	}
	
	/**
	 * Column Info
	 * @param rsnCdAllFlg
	 */
	public void setRsnCdAllFlg(String rsnCdAllFlg) {
		this.rsnCdAllFlg = rsnCdAllFlg;
	}

	
	/**
	 * Column Info
	 * @param closeTpAllFlg
	 */
	public void setCloseTpAllFlg(String closeTpAllFlg) {
		this.closeTpAllFlg = closeTpAllFlg;
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
		setPayerCode(JSPUtil.getParameter(request, prefix + "payer_code", ""));
		setTtlLssCmplCd(JSPUtil.getParameter(request, prefix + "ttl_lss_cmpl_cd", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setInStatusTp(JSPUtil.getParameter(request, prefix + "in_status_tp", ""));
		setRsnCd(JSPUtil.getParameter(request, prefix + "rsn_cd", ""));
		setPayerType(JSPUtil.getParameter(request, prefix + "payer_type", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setTotalLossNo(JSPUtil.getParameter(request, prefix + "total_loss_no", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBuyerCode(JSPUtil.getParameter(request, prefix + "buyer_code", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setInSearchDtTp(JSPUtil.getParameter(request, prefix + "in_search_dt_tp", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setUsaEdiCd(JSPUtil.getParameter(request, prefix + "usa_edi_cd", ""));
		setTtlLssDtlRsnCd(JSPUtil.getParameter(request, prefix + "ttl_lss_dtl_rsn_cd", ""));
		setEqKind(JSPUtil.getParameter(request, prefix + "eq_kind", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setInOfficeTp(JSPUtil.getParameter(request, prefix + "in_office_tp", ""));
		setInDays(JSPUtil.getParameter(request, prefix + "in_days", ""));
		setRsnCdAllFlg(JSPUtil.getParameter(request, prefix + "rsn_cd_all_flg", ""));
		setCloseTpAllFlg(JSPUtil.getParameter(request, prefix + "close_tp_all_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TotalLossPerformanceINVO[]
	 */
	public TotalLossPerformanceINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TotalLossPerformanceINVO[]
	 */
	public TotalLossPerformanceINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TotalLossPerformanceINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] payerCode = (JSPUtil.getParameter(request, prefix	+ "payer_code", length));
			String[] ttlLssCmplCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_cmpl_cd", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] inStatusTp = (JSPUtil.getParameter(request, prefix	+ "in_status_tp", length));
			String[] rsnCd = (JSPUtil.getParameter(request, prefix	+ "rsn_cd", length));
			String[] payerType = (JSPUtil.getParameter(request, prefix	+ "payer_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] totalLossNo = (JSPUtil.getParameter(request, prefix	+ "total_loss_no", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] buyerCode = (JSPUtil.getParameter(request, prefix	+ "buyer_code", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] inSearchDtTp = (JSPUtil.getParameter(request, prefix	+ "in_search_dt_tp", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] usaEdiCd = (JSPUtil.getParameter(request, prefix	+ "usa_edi_cd", length));
			String[] ttlLssDtlRsnCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_dtl_rsn_cd", length));
			String[] eqKind = (JSPUtil.getParameter(request, prefix	+ "eq_kind", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] inOfficeTp = (JSPUtil.getParameter(request, prefix	+ "in_office_tp", length));
			String[] inDays = (JSPUtil.getParameter(request, prefix	+ "in_days", length));
			String[] rsnCdAllFlg = (JSPUtil.getParameter(request, prefix	+ "rsn_cd_all_flg", length));
			String[] closeTpAllFlg = (JSPUtil.getParameter(request, prefix	+ "close_tp_all_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new TotalLossPerformanceINVO();
				if (payerCode[i] != null)
					model.setPayerCode(payerCode[i]);
				if (ttlLssCmplCd[i] != null)
					model.setTtlLssCmplCd(ttlLssCmplCd[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (inStatusTp[i] != null)
					model.setInStatusTp(inStatusTp[i]);
				if (rsnCd[i] != null)
					model.setRsnCd(rsnCd[i]);
				if (payerType[i] != null)
					model.setPayerType(payerType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (totalLossNo[i] != null)
					model.setTotalLossNo(totalLossNo[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (buyerCode[i] != null)
					model.setBuyerCode(buyerCode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (inSearchDtTp[i] != null)
					model.setInSearchDtTp(inSearchDtTp[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (usaEdiCd[i] != null)
					model.setUsaEdiCd(usaEdiCd[i]);
				if (ttlLssDtlRsnCd[i] != null)
					model.setTtlLssDtlRsnCd(ttlLssDtlRsnCd[i]);
				if (eqKind[i] != null)
					model.setEqKind(eqKind[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (inOfficeTp[i] != null)
					model.setInOfficeTp(inOfficeTp[i]);
				if (inDays[i] != null)
					model.setInDays(inDays[i]);
				if (rsnCdAllFlg[i] != null)
					model.setRsnCdAllFlg(rsnCdAllFlg[i]);
				if (closeTpAllFlg[i] != null)
					model.setCloseTpAllFlg(closeTpAllFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTotalLossPerformanceINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TotalLossPerformanceINVO[]
	 */
	public TotalLossPerformanceINVO[] getTotalLossPerformanceINVOs(){
		TotalLossPerformanceINVO[] vos = (TotalLossPerformanceINVO[])models.toArray(new TotalLossPerformanceINVO[models.size()]);
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
		this.payerCode = this.payerCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssCmplCd = this.ttlLssCmplCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inStatusTp = this.inStatusTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnCd = this.rsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerType = this.payerType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalLossNo = this.totalLossNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buyerCode = this.buyerCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSearchDtTp = this.inSearchDtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaEdiCd = this.usaEdiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDtlRsnCd = this.ttlLssDtlRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKind = this.eqKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inOfficeTp = this.inOfficeTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDays = this.inDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnCdAllFlg = this.rsnCdAllFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.closeTpAllFlg = this.closeTpAllFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
