/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AddOnTariffListVO.java
*@FileTitle : AddOnTariffListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.15
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.05.15 이은섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo;

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
 * @author 이은섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AddOnTariffListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AddOnTariffListVO> models = new ArrayList<AddOnTariffListVO>();
	
	/* Column Info */
	private String ovrWgtRtAmt = null;
	/* Column Info */
	private String dgRtRto = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String dgFltPctTpCd = null;
	/* Column Info */
	private String rfRtRto = null;
	/* Column Info */
	private String ovrWgtFltPctTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prcInlndTrfCntrTpszCd = null;
	/* Column Info */
	private String rfFltPctTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ovrWgtRtRto = null;
	/* Column Info */
	private String minCgoWgt = null;
	/* Column Info */
	private String verMapgSeq = null;
	/* Column Info */
	private String dgRtAmt = null;
	/* Column Info */
	private String fdrTrfNo = null;
	/* Column Info */
	private String rfRtAmt = null;
	/* Column Info */
	private String maxCgoWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AddOnTariffListVO() {}

	public AddOnTariffListVO(String ibflag, String pagerows, String svcScpCd, String fdrTrfNo, String verMapgSeq, String prcInlndTrfCntrTpszCd, String rfFltPctTpCd, String rfRtAmt, String rfRtRto, String dgFltPctTpCd, String dgRtAmt, String dgRtRto, String minCgoWgt, String maxCgoWgt, String ovrWgtFltPctTpCd, String ovrWgtRtAmt, String ovrWgtRtRto) {
		this.ovrWgtRtAmt = ovrWgtRtAmt;
		this.dgRtRto = dgRtRto;
		this.svcScpCd = svcScpCd;
		this.dgFltPctTpCd = dgFltPctTpCd;
		this.rfRtRto = rfRtRto;
		this.ovrWgtFltPctTpCd = ovrWgtFltPctTpCd;
		this.pagerows = pagerows;
		this.prcInlndTrfCntrTpszCd = prcInlndTrfCntrTpszCd;
		this.rfFltPctTpCd = rfFltPctTpCd;
		this.ibflag = ibflag;
		this.ovrWgtRtRto = ovrWgtRtRto;
		this.minCgoWgt = minCgoWgt;
		this.verMapgSeq = verMapgSeq;
		this.dgRtAmt = dgRtAmt;
		this.fdrTrfNo = fdrTrfNo;
		this.rfRtAmt = rfRtAmt;
		this.maxCgoWgt = maxCgoWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ovr_wgt_rt_amt", getOvrWgtRtAmt());
		this.hashColumns.put("dg_rt_rto", getDgRtRto());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("dg_flt_pct_tp_cd", getDgFltPctTpCd());
		this.hashColumns.put("rf_rt_rto", getRfRtRto());
		this.hashColumns.put("ovr_wgt_flt_pct_tp_cd", getOvrWgtFltPctTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prc_inlnd_trf_cntr_tpsz_cd", getPrcInlndTrfCntrTpszCd());
		this.hashColumns.put("rf_flt_pct_tp_cd", getRfFltPctTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ovr_wgt_rt_rto", getOvrWgtRtRto());
		this.hashColumns.put("min_cgo_wgt", getMinCgoWgt());
		this.hashColumns.put("ver_mapg_seq", getVerMapgSeq());
		this.hashColumns.put("dg_rt_amt", getDgRtAmt());
		this.hashColumns.put("fdr_trf_no", getFdrTrfNo());
		this.hashColumns.put("rf_rt_amt", getRfRtAmt());
		this.hashColumns.put("max_cgo_wgt", getMaxCgoWgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ovr_wgt_rt_amt", "ovrWgtRtAmt");
		this.hashFields.put("dg_rt_rto", "dgRtRto");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("dg_flt_pct_tp_cd", "dgFltPctTpCd");
		this.hashFields.put("rf_rt_rto", "rfRtRto");
		this.hashFields.put("ovr_wgt_flt_pct_tp_cd", "ovrWgtFltPctTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prc_inlnd_trf_cntr_tpsz_cd", "prcInlndTrfCntrTpszCd");
		this.hashFields.put("rf_flt_pct_tp_cd", "rfFltPctTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ovr_wgt_rt_rto", "ovrWgtRtRto");
		this.hashFields.put("min_cgo_wgt", "minCgoWgt");
		this.hashFields.put("ver_mapg_seq", "verMapgSeq");
		this.hashFields.put("dg_rt_amt", "dgRtAmt");
		this.hashFields.put("fdr_trf_no", "fdrTrfNo");
		this.hashFields.put("rf_rt_amt", "rfRtAmt");
		this.hashFields.put("max_cgo_wgt", "maxCgoWgt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ovrWgtRtAmt
	 */
	public String getOvrWgtRtAmt() {
		return this.ovrWgtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return dgRtRto
	 */
	public String getDgRtRto() {
		return this.dgRtRto;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return dgFltPctTpCd
	 */
	public String getDgFltPctTpCd() {
		return this.dgFltPctTpCd;
	}
	
	/**
	 * Column Info
	 * @return rfRtRto
	 */
	public String getRfRtRto() {
		return this.rfRtRto;
	}
	
	/**
	 * Column Info
	 * @return ovrWgtFltPctTpCd
	 */
	public String getOvrWgtFltPctTpCd() {
		return this.ovrWgtFltPctTpCd;
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
	 * @return prcInlndTrfCntrTpszCd
	 */
	public String getPrcInlndTrfCntrTpszCd() {
		return this.prcInlndTrfCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return rfFltPctTpCd
	 */
	public String getRfFltPctTpCd() {
		return this.rfFltPctTpCd;
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
	 * @return ovrWgtRtRto
	 */
	public String getOvrWgtRtRto() {
		return this.ovrWgtRtRto;
	}
	
	/**
	 * Column Info
	 * @return minCgoWgt
	 */
	public String getMinCgoWgt() {
		return this.minCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return verMapgSeq
	 */
	public String getVerMapgSeq() {
		return this.verMapgSeq;
	}
	
	/**
	 * Column Info
	 * @return dgRtAmt
	 */
	public String getDgRtAmt() {
		return this.dgRtAmt;
	}
	
	/**
	 * Column Info
	 * @return fdrTrfNo
	 */
	public String getFdrTrfNo() {
		return this.fdrTrfNo;
	}
	
	/**
	 * Column Info
	 * @return rfRtAmt
	 */
	public String getRfRtAmt() {
		return this.rfRtAmt;
	}
	
	/**
	 * Column Info
	 * @return maxCgoWgt
	 */
	public String getMaxCgoWgt() {
		return this.maxCgoWgt;
	}
	

	/**
	 * Column Info
	 * @param ovrWgtRtAmt
	 */
	public void setOvrWgtRtAmt(String ovrWgtRtAmt) {
		this.ovrWgtRtAmt = ovrWgtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param dgRtRto
	 */
	public void setDgRtRto(String dgRtRto) {
		this.dgRtRto = dgRtRto;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param dgFltPctTpCd
	 */
	public void setDgFltPctTpCd(String dgFltPctTpCd) {
		this.dgFltPctTpCd = dgFltPctTpCd;
	}
	
	/**
	 * Column Info
	 * @param rfRtRto
	 */
	public void setRfRtRto(String rfRtRto) {
		this.rfRtRto = rfRtRto;
	}
	
	/**
	 * Column Info
	 * @param ovrWgtFltPctTpCd
	 */
	public void setOvrWgtFltPctTpCd(String ovrWgtFltPctTpCd) {
		this.ovrWgtFltPctTpCd = ovrWgtFltPctTpCd;
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
	 * @param prcInlndTrfCntrTpszCd
	 */
	public void setPrcInlndTrfCntrTpszCd(String prcInlndTrfCntrTpszCd) {
		this.prcInlndTrfCntrTpszCd = prcInlndTrfCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param rfFltPctTpCd
	 */
	public void setRfFltPctTpCd(String rfFltPctTpCd) {
		this.rfFltPctTpCd = rfFltPctTpCd;
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
	 * @param ovrWgtRtRto
	 */
	public void setOvrWgtRtRto(String ovrWgtRtRto) {
		this.ovrWgtRtRto = ovrWgtRtRto;
	}
	
	/**
	 * Column Info
	 * @param minCgoWgt
	 */
	public void setMinCgoWgt(String minCgoWgt) {
		this.minCgoWgt = minCgoWgt;
	}
	
	/**
	 * Column Info
	 * @param verMapgSeq
	 */
	public void setVerMapgSeq(String verMapgSeq) {
		this.verMapgSeq = verMapgSeq;
	}
	
	/**
	 * Column Info
	 * @param dgRtAmt
	 */
	public void setDgRtAmt(String dgRtAmt) {
		this.dgRtAmt = dgRtAmt;
	}
	
	/**
	 * Column Info
	 * @param fdrTrfNo
	 */
	public void setFdrTrfNo(String fdrTrfNo) {
		this.fdrTrfNo = fdrTrfNo;
	}
	
	/**
	 * Column Info
	 * @param rfRtAmt
	 */
	public void setRfRtAmt(String rfRtAmt) {
		this.rfRtAmt = rfRtAmt;
	}
	
	/**
	 * Column Info
	 * @param maxCgoWgt
	 */
	public void setMaxCgoWgt(String maxCgoWgt) {
		this.maxCgoWgt = maxCgoWgt;
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
		setOvrWgtRtAmt(JSPUtil.getParameter(request, prefix + "ovr_wgt_rt_amt", ""));
		setDgRtRto(JSPUtil.getParameter(request, prefix + "dg_rt_rto", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setDgFltPctTpCd(JSPUtil.getParameter(request, prefix + "dg_flt_pct_tp_cd", ""));
		setRfRtRto(JSPUtil.getParameter(request, prefix + "rf_rt_rto", ""));
		setOvrWgtFltPctTpCd(JSPUtil.getParameter(request, prefix + "ovr_wgt_flt_pct_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPrcInlndTrfCntrTpszCd(JSPUtil.getParameter(request, prefix + "prc_inlnd_trf_cntr_tpsz_cd", ""));
		setRfFltPctTpCd(JSPUtil.getParameter(request, prefix + "rf_flt_pct_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOvrWgtRtRto(JSPUtil.getParameter(request, prefix + "ovr_wgt_rt_rto", ""));
		setMinCgoWgt(JSPUtil.getParameter(request, prefix + "min_cgo_wgt", ""));
		setVerMapgSeq(JSPUtil.getParameter(request, prefix + "ver_mapg_seq", ""));
		setDgRtAmt(JSPUtil.getParameter(request, prefix + "dg_rt_amt", ""));
		setFdrTrfNo(JSPUtil.getParameter(request, prefix + "fdr_trf_no", ""));
		setRfRtAmt(JSPUtil.getParameter(request, prefix + "rf_rt_amt", ""));
		setMaxCgoWgt(JSPUtil.getParameter(request, prefix + "max_cgo_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AddOnTariffListVO[]
	 */
	public AddOnTariffListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AddOnTariffListVO[]
	 */
	public AddOnTariffListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AddOnTariffListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ovrWgtRtAmt = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_rt_amt", length));
			String[] dgRtRto = (JSPUtil.getParameter(request, prefix	+ "dg_rt_rto", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] dgFltPctTpCd = (JSPUtil.getParameter(request, prefix	+ "dg_flt_pct_tp_cd", length));
			String[] rfRtRto = (JSPUtil.getParameter(request, prefix	+ "rf_rt_rto", length));
			String[] ovrWgtFltPctTpCd = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_flt_pct_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prcInlndTrfCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "prc_inlnd_trf_cntr_tpsz_cd", length));
			String[] rfFltPctTpCd = (JSPUtil.getParameter(request, prefix	+ "rf_flt_pct_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ovrWgtRtRto = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_rt_rto", length));
			String[] minCgoWgt = (JSPUtil.getParameter(request, prefix	+ "min_cgo_wgt", length));
			String[] verMapgSeq = (JSPUtil.getParameter(request, prefix	+ "ver_mapg_seq", length));
			String[] dgRtAmt = (JSPUtil.getParameter(request, prefix	+ "dg_rt_amt", length));
			String[] fdrTrfNo = (JSPUtil.getParameter(request, prefix	+ "fdr_trf_no", length));
			String[] rfRtAmt = (JSPUtil.getParameter(request, prefix	+ "rf_rt_amt", length));
			String[] maxCgoWgt = (JSPUtil.getParameter(request, prefix	+ "max_cgo_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new AddOnTariffListVO();
				if (ovrWgtRtAmt[i] != null)
					model.setOvrWgtRtAmt(ovrWgtRtAmt[i]);
				if (dgRtRto[i] != null)
					model.setDgRtRto(dgRtRto[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (dgFltPctTpCd[i] != null)
					model.setDgFltPctTpCd(dgFltPctTpCd[i]);
				if (rfRtRto[i] != null)
					model.setRfRtRto(rfRtRto[i]);
				if (ovrWgtFltPctTpCd[i] != null)
					model.setOvrWgtFltPctTpCd(ovrWgtFltPctTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prcInlndTrfCntrTpszCd[i] != null)
					model.setPrcInlndTrfCntrTpszCd(prcInlndTrfCntrTpszCd[i]);
				if (rfFltPctTpCd[i] != null)
					model.setRfFltPctTpCd(rfFltPctTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ovrWgtRtRto[i] != null)
					model.setOvrWgtRtRto(ovrWgtRtRto[i]);
				if (minCgoWgt[i] != null)
					model.setMinCgoWgt(minCgoWgt[i]);
				if (verMapgSeq[i] != null)
					model.setVerMapgSeq(verMapgSeq[i]);
				if (dgRtAmt[i] != null)
					model.setDgRtAmt(dgRtAmt[i]);
				if (fdrTrfNo[i] != null)
					model.setFdrTrfNo(fdrTrfNo[i]);
				if (rfRtAmt[i] != null)
					model.setRfRtAmt(rfRtAmt[i]);
				if (maxCgoWgt[i] != null)
					model.setMaxCgoWgt(maxCgoWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAddOnTariffListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AddOnTariffListVO[]
	 */
	public AddOnTariffListVO[] getAddOnTariffListVOs(){
		AddOnTariffListVO[] vos = (AddOnTariffListVO[])models.toArray(new AddOnTariffListVO[models.size()]);
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
		this.ovrWgtRtAmt = this.ovrWgtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgRtRto = this.dgRtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgFltPctTpCd = this.dgFltPctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRtRto = this.rfRtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWgtFltPctTpCd = this.ovrWgtFltPctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcInlndTrfCntrTpszCd = this.prcInlndTrfCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfFltPctTpCd = this.rfFltPctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWgtRtRto = this.ovrWgtRtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCgoWgt = this.minCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verMapgSeq = this.verMapgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgRtAmt = this.dgRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrTrfNo = this.fdrTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRtAmt = this.rfRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxCgoWgt = this.maxCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
