/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgIfManagerEdiInputVO.java
*@FileTitle : BkgIfManagerEdiInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.14   
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

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

public class BkgIfManagerEdiInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgIfManagerEdiInputVO> models = new ArrayList<BkgIfManagerEdiInputVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String blOfcCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String ediSentStsCd = null;
	/* Column Info */
	private String ediReceiveNm = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgStfCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String salesRep = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String bkgToDt = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String bkgFromDt = null;
	/* Column Info */
	private String ediGroupId = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String ediReceiveId = null;
	/* Column Info */
	private String custCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgIfManagerEdiInputVO() {}

	public BkgIfManagerEdiInputVO(String ibflag, String pagerows, String bkgOfcCd, String blOfcCd, String custNm, String ediReceiveNm, String custSeq, String blNo, String vvd, String bkgStfCd, String salesRep, String bkgNo, String polCd, String scNo, String bkgToDt, String slsOfcCd, String bkgFromDt, String ediGroupId, String custTpCd, String custCntCd, String ediReceiveId, String ediSentStsCd, String podCd, String delCd) {
		this.bkgOfcCd = bkgOfcCd;
		this.blOfcCd = blOfcCd;
		this.custNm = custNm;
		this.delCd = delCd;
		this.ediSentStsCd = ediSentStsCd;
		this.ediReceiveNm = ediReceiveNm;
		this.custSeq = custSeq;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.vvd = vvd;
		this.bkgStfCd = bkgStfCd;
		this.ibflag = ibflag;
		this.salesRep = salesRep;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.bkgToDt = bkgToDt;
		this.scNo = scNo;
		this.slsOfcCd = slsOfcCd;
		this.bkgFromDt = bkgFromDt;
		this.ediGroupId = ediGroupId;
		this.custTpCd = custTpCd;
		this.ediReceiveId = ediReceiveId;
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("bl_ofc_cd", getBlOfcCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("edi_sent_sts_cd", getEdiSentStsCd());
		this.hashColumns.put("edi_receive_nm", getEdiReceiveNm());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_stf_cd", getBkgStfCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sales_rep", getSalesRep());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bkg_to_dt", getBkgToDt());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("bkg_from_dt", getBkgFromDt());
		this.hashColumns.put("edi_group_id", getEdiGroupId());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("edi_receive_id", getEdiReceiveId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("bl_ofc_cd", "blOfcCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("edi_sent_sts_cd", "ediSentStsCd");
		this.hashFields.put("edi_receive_nm", "ediReceiveNm");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_stf_cd", "bkgStfCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sales_rep", "salesRep");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_to_dt", "bkgToDt");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("bkg_from_dt", "bkgFromDt");
		this.hashFields.put("edi_group_id", "ediGroupId");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("edi_receive_id", "ediReceiveId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return blOfcCd
	 */
	public String getBlOfcCd() {
		return this.blOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return ediSentStsCd
	 */
	public String getEdiSentStsCd() {
		return this.ediSentStsCd;
	}
	
	/**
	 * Column Info
	 * @return ediReceiveNm
	 */
	public String getEdiReceiveNm() {
		return this.ediReceiveNm;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return bkgStfCd
	 */
	public String getBkgStfCd() {
		return this.bkgStfCd;
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
	 * @return salesRep
	 */
	public String getSalesRep() {
		return this.salesRep;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return bkgToDt
	 */
	public String getBkgToDt() {
		return this.bkgToDt;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgFromDt
	 */
	public String getBkgFromDt() {
		return this.bkgFromDt;
	}
	
	/**
	 * Column Info
	 * @return ediGroupId
	 */
	public String getEdiGroupId() {
		return this.ediGroupId;
	}
	
	/**
	 * Column Info
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
	}
	
	/**
	 * Column Info
	 * @return ediReceiveId
	 */
	public String getEdiReceiveId() {
		return this.ediReceiveId;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	

	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param blOfcCd
	 */
	public void setBlOfcCd(String blOfcCd) {
		this.blOfcCd = blOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param ediSentStsCd
	 */
	public void setEdiSentStsCd(String ediSentStsCd) {
		this.ediSentStsCd = ediSentStsCd;
	}
	
	/**
	 * Column Info
	 * @param ediReceiveNm
	 */
	public void setEdiReceiveNm(String ediReceiveNm) {
		this.ediReceiveNm = ediReceiveNm;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param bkgStfCd
	 */
	public void setBkgStfCd(String bkgStfCd) {
		this.bkgStfCd = bkgStfCd;
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
	 * @param salesRep
	 */
	public void setSalesRep(String salesRep) {
		this.salesRep = salesRep;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param bkgToDt
	 */
	public void setBkgToDt(String bkgToDt) {
		this.bkgToDt = bkgToDt;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgFromDt
	 */
	public void setBkgFromDt(String bkgFromDt) {
		this.bkgFromDt = bkgFromDt;
	}
	
	/**
	 * Column Info
	 * @param ediGroupId
	 */
	public void setEdiGroupId(String ediGroupId) {
		this.ediGroupId = ediGroupId;
	}
	
	/**
	 * Column Info
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
	}
	
	/**
	 * Column Info
	 * @param ediReceiveId
	 */
	public void setEdiReceiveId(String ediReceiveId) {
		this.ediReceiveId = ediReceiveId;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setBlOfcCd(JSPUtil.getParameter(request, prefix + "bl_ofc_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setEdiSentStsCd(JSPUtil.getParameter(request, prefix + "edi_sent_sts_cd", ""));
		setEdiReceiveNm(JSPUtil.getParameter(request, prefix + "edi_receive_nm", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBkgStfCd(JSPUtil.getParameter(request, prefix + "bkg_stf_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSalesRep(JSPUtil.getParameter(request, prefix + "sales_rep", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setBkgToDt(JSPUtil.getParameter(request, prefix + "bkg_to_dt", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setBkgFromDt(JSPUtil.getParameter(request, prefix + "bkg_from_dt", ""));
		setEdiGroupId(JSPUtil.getParameter(request, prefix + "edi_group_id", ""));
		setCustTpCd(JSPUtil.getParameter(request, prefix + "cust_tp_cd", ""));
		setEdiReceiveId(JSPUtil.getParameter(request, prefix + "edi_receive_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgIfManagerEdiInputVO[]
	 */
	public BkgIfManagerEdiInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgIfManagerEdiInputVO[]
	 */
	public BkgIfManagerEdiInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgIfManagerEdiInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] blOfcCd = (JSPUtil.getParameter(request, prefix	+ "bl_ofc_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] ediSentStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_sent_sts_cd", length));
			String[] ediReceiveNm = (JSPUtil.getParameter(request, prefix	+ "edi_receive_nm", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgStfCd = (JSPUtil.getParameter(request, prefix	+ "bkg_stf_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] salesRep = (JSPUtil.getParameter(request, prefix	+ "sales_rep", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] bkgToDt = (JSPUtil.getParameter(request, prefix	+ "bkg_to_dt", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] bkgFromDt = (JSPUtil.getParameter(request, prefix	+ "bkg_from_dt", length));
			String[] ediGroupId = (JSPUtil.getParameter(request, prefix	+ "edi_group_id", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] ediReceiveId = (JSPUtil.getParameter(request, prefix	+ "edi_receive_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgIfManagerEdiInputVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (blOfcCd[i] != null)
					model.setBlOfcCd(blOfcCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ediSentStsCd[i] != null)
					model.setEdiSentStsCd(ediSentStsCd[i]);
				if (ediReceiveNm[i] != null)
					model.setEdiReceiveNm(ediReceiveNm[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgStfCd[i] != null)
					model.setBkgStfCd(bkgStfCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (salesRep[i] != null)
					model.setSalesRep(salesRep[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (bkgToDt[i] != null)
					model.setBkgToDt(bkgToDt[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (bkgFromDt[i] != null)
					model.setBkgFromDt(bkgFromDt[i]);
				if (ediGroupId[i] != null)
					model.setEdiGroupId(ediGroupId[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (ediReceiveId[i] != null)
					model.setEdiReceiveId(ediReceiveId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgIfManagerEdiInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgIfManagerEdiInputVO[]
	 */
	public BkgIfManagerEdiInputVO[] getBkgIfManagerEdiInputVOs(){
		BkgIfManagerEdiInputVO[] vos = (BkgIfManagerEdiInputVO[])models.toArray(new BkgIfManagerEdiInputVO[models.size()]);
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
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blOfcCd = this.blOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSentStsCd = this.ediSentStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediReceiveNm = this.ediReceiveNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStfCd = this.bkgStfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesRep = this.salesRep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgToDt = this.bkgToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFromDt = this.bkgFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGroupId = this.ediGroupId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediReceiveId = this.ediReceiveId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
