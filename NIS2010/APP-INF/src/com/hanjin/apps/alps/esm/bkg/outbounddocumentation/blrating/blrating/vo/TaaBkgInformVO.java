/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TaaBkgInformVO.java
*@FileTitle : TaaBkgInformVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.03
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.09.28 김태경
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

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
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TaaBkgInformVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TaaBkgInformVO> models = new ArrayList<TaaBkgInformVO>();
	
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String bkgPorCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String bdrCngFlg = null;
	/* Column Info */
	private String vvPodCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String vvPolCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgPodCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrCdrDt = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String special = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String repCmdtNm = null;
	/* Column Info */
	private String fTaaNo = null;
	/* Column Info */
	private String srepEml = null;
	/* Column Info */
	private String obSrepEml = null; 
	/* Column Info */
	private String scpCd = null; 
	/* Column Info */
	private String aplyTp = null; 
	/* Column Info */
	private String cgoRcvDt = null; 
	/* Column Info */
	private String etdDt = null; 
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TaaBkgInformVO() {}

	public TaaBkgInformVO(String ibflag, String pagerows, String bkgNo, String svcScpCd, String bdrCngFlg, String cntrCdrDt, String bkgCgoTpCd, String cmdtCd, String cmdtNm, String repCmdtCd, String actWgt, String measQty, String measUtCd, String bkgPorCd, String bkgPolCd, String bkgPodCd, String delCd, String vvPolCd, String vvPodCd, String rcvTermCd, String deTermCd, String special, String frtTermCd, String repCmdtNm, String fTaaNo, String srepEml, String obSrepEml, String scpCd, String etdDt, String aplyTp, String cgoRcvDt) {
		this.bkgPolCd = bkgPolCd;
		this.bkgPorCd = bkgPorCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.bdrCngFlg = bdrCngFlg;
		this.vvPodCd = vvPodCd;
		this.svcScpCd = svcScpCd;
		this.frtTermCd = frtTermCd;
		this.vvPolCd = vvPolCd;
		this.delCd = delCd;
		this.cmdtNm = cmdtNm;
		this.pagerows = pagerows;
		this.actWgt = actWgt;
		this.deTermCd = deTermCd;
		this.bkgPodCd = bkgPodCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cntrCdrDt = cntrCdrDt;
		this.cmdtCd = cmdtCd;
		this.measQty = measQty;
		this.special = special;
		this.rcvTermCd = rcvTermCd;
		this.measUtCd = measUtCd;
		this.repCmdtCd = repCmdtCd;
		this.repCmdtNm = repCmdtNm;
		this.fTaaNo = fTaaNo;
		this.srepEml = srepEml;
		this.obSrepEml = obSrepEml;
		this.scpCd = scpCd;
		this.aplyTp = aplyTp;
		this.cgoRcvDt = cgoRcvDt;
		this.etdDt = etdDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("bkg_por_cd", getBkgPorCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("bdr_cng_flg", getBdrCngFlg());
		this.hashColumns.put("vv_pod_cd", getVvPodCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("vv_pol_cd", getVvPolCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_cdr_dt", getCntrCdrDt());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("special", getSpecial());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("rep_cmdt_nm", getRepCmdtNm());
		this.hashColumns.put("ftaa_no", getFTaaNo());
		this.hashColumns.put("srep_eml", getSrepEml());
		this.hashColumns.put("ob_srep_eml", getObSrepEml());
		this.hashColumns.put("scp_cd", getScpCd());
		this.hashColumns.put("aply_tp", getAplyTp());
		this.hashColumns.put("cgo_rcv_dt", getCgoRcvDt());
		this.hashColumns.put("etd_dt", getEtdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("bkg_por_cd", "bkgPorCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("bdr_cng_flg", "bdrCngFlg");
		this.hashFields.put("vv_pod_cd", "vvPodCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("vv_pol_cd", "vvPolCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_cdr_dt", "cntrCdrDt");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("special", "special");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("rep_cmdt_nm", "repCmdtNm");
		this.hashFields.put("ftaa_no", "fTaaNo");
		this.hashFields.put("srep_eml", "srepEml");
		this.hashFields.put("ob_srep_eml", "obSrepEml");
		this.hashFields.put("scp_cd", "scpCd");
		this.hashFields.put("aply_tp", "aplyTp");
		this.hashFields.put("cgo_rcv_dt", "cgoRcvDt");
		this.hashFields.put("etd_dt", "etdDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgPolCd
	 */
	public String getBkgPolCd() {
		return this.bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPorCd
	 */
	public String getBkgPorCd() {
		return this.bkgPorCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return bdrCngFlg
	 */
	public String getBdrCngFlg() {
		return this.bdrCngFlg;
	}
	
	/**
	 * Column Info
	 * @return vvPodCd
	 */
	public String getVvPodCd() {
		return this.vvPodCd;
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
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
	}
	
	/**
	 * Column Info
	 * @return vvPolCd
	 */
	public String getVvPolCd() {
		return this.vvPolCd;
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
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPodCd
	 */
	public String getBkgPodCd() {
		return this.bkgPodCd;
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
	 * @return cntrCdrDt
	 */
	public String getCntrCdrDt() {
		return this.cntrCdrDt;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return special
	 */
	public String getSpecial() {
		return this.special;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	
	/**
	 * Column Info
	 * @return repCmdtCd
	 */
	public String getRepCmdtCd() {
		return this.repCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return repCmdtNm
	 */
	public String getRepCmdtNm() {
		return this.repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @return fTaaNo
	 */
	public String getFTaaNo() {
		return this.fTaaNo;
	}

	/**
	 * Column Info
	 * @return srepEml
	 */
	public String getSrepEml() {
		return this.srepEml;
	}
	
	/**
	 * Column Info
	 * @return obSrepEml
	 */
	public String getObSrepEml() {
		return this.obSrepEml;
	}
	

	/**
	 * Column Info
	 * @return scpCd
	 */
	public String getScpCd() {
		return this.scpCd;
	}
	
	/**
	 * Column Info
	 * @return aplyTp
	 */
	public String getAplyTp() {
		return this.aplyTp;
	}
	
	/**
	 * Column Info
	 * @return cgoRcvDt
	 */
	public String getCgoRcvDt() {
		return this.cgoRcvDt;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @param bkgPolCd
	 */
	public void setBkgPolCd(String bkgPolCd) {
		this.bkgPolCd = bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPorCd
	 */
	public void setBkgPorCd(String bkgPorCd) {
		this.bkgPorCd = bkgPorCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param bdrCngFlg
	 */
	public void setBdrCngFlg(String bdrCngFlg) {
		this.bdrCngFlg = bdrCngFlg;
	}
	
	/**
	 * Column Info
	 * @param vvPodCd
	 */
	public void setVvPodCd(String vvPodCd) {
		this.vvPodCd = vvPodCd;
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
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
	}
	
	/**
	 * Column Info
	 * @param vvPolCd
	 */
	public void setVvPolCd(String vvPolCd) {
		this.vvPolCd = vvPolCd;
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
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPodCd
	 */
	public void setBkgPodCd(String bkgPodCd) {
		this.bkgPodCd = bkgPodCd;
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
	 * @param cntrCdrDt
	 */
	public void setCntrCdrDt(String cntrCdrDt) {
		this.cntrCdrDt = cntrCdrDt;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param special
	 */
	public void setSpecial(String special) {
		this.special = special;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param repCmdtNm
	 */
	public void setRepCmdtNm(String repCmdtNm) {
		this.repCmdtNm = repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @param fTaaNo
	 */
	public void setFTaaNo(String fTaaNo) {
		this.fTaaNo = fTaaNo;
	}
	
	/**
	 * Column Info
	 * @param srepEml
	 */
	public void setSrepEml(String srepEml) {
		this.srepEml = srepEml;
	}	
	
	/**
	 * Column Info
	 * @param obSrepEml
	 */
	public void setObSrepEml(String obSrepEml) {
		this.obSrepEml = obSrepEml;
	}
	
	/**
	 * Column Info
	 * @param scpCd
	 */
	public void setScpCd(String scpCd) {
		this.scpCd = scpCd;
	}
	
	/**
	 * Column Info
	 * @param aplyTp
	 */
	public void setAplyTp(String aplyTp) {
		this.aplyTp = aplyTp;
	}
	
	/**
	 * Column Info
	 * @param cgoRcvDt
	 */
	public void setCgoRcvDt(String cgoRcvDt) {
		this.cgoRcvDt = cgoRcvDt;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgPolCd(JSPUtil.getParameter(request, "bkg_pol_cd", ""));
		setBkgPorCd(JSPUtil.getParameter(request, "bkg_por_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setBdrCngFlg(JSPUtil.getParameter(request, "bdr_cng_flg", ""));
		setVvPodCd(JSPUtil.getParameter(request, "vv_pod_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setFrtTermCd(JSPUtil.getParameter(request, "frt_term_cd", ""));
		setVvPolCd(JSPUtil.getParameter(request, "vv_pol_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setActWgt(JSPUtil.getParameter(request, "act_wgt", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setBkgPodCd(JSPUtil.getParameter(request, "bkg_pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCntrCdrDt(JSPUtil.getParameter(request, "cntr_cdr_dt", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setSpecial(JSPUtil.getParameter(request, "special", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, "meas_ut_cd", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, "rep_cmdt_cd", ""));
		setRepCmdtNm(JSPUtil.getParameter(request, "rep_cmdt_nm", ""));
		setFTaaNo(JSPUtil.getParameter(request, "ftaa_no",""));
		setSrepEml(JSPUtil.getParameter(request, "srep_eml", ""));
		setObSrepEml(JSPUtil.getParameter(request, "ob_srep_eml", ""));
		setScpCd(JSPUtil.getParameter(request, "scp_cd", ""));
		setAplyTp(JSPUtil.getParameter(request, "aply_tp", ""));
		setCgoRcvDt(JSPUtil.getParameter(request, "cgo_rcv_dt", ""));
		setEtdDt(JSPUtil.getParameter(request, "etd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TaaBkgInformVO[]
	 */
	public TaaBkgInformVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TaaBkgInformVO[]
	 */
	public TaaBkgInformVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TaaBkgInformVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] bkgPorCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] bdrCngFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_cng_flg", length));
			String[] vvPodCd = (JSPUtil.getParameter(request, prefix	+ "vv_pod_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] vvPolCd = (JSPUtil.getParameter(request, prefix	+ "vv_pol_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgPodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrCdrDt = (JSPUtil.getParameter(request, prefix	+ "cntr_cdr_dt", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] special = (JSPUtil.getParameter(request, prefix	+ "special", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] repCmdtNm = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_nm", length));
			String[] fTaaNo = (JSPUtil.getParameter(request, prefix	+ "ftaa_no", length));
			String[] srepEml = (JSPUtil.getParameter(request, prefix	+ "srep_eml", length));
			String[] obSrepEml = (JSPUtil.getParameter(request, prefix	+ "ob_srep_eml", length));
			String[] scpCd = (JSPUtil.getParameter(request, prefix	+ "scp_cd", length));
			String[] aplyTp = (JSPUtil.getParameter(request, prefix	+ "aply_tp", length));
			String[] cgoRcvDt = (JSPUtil.getParameter(request, prefix	+ "cgo_rcv_dt", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new TaaBkgInformVO();
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (bkgPorCd[i] != null)
					model.setBkgPorCd(bkgPorCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (bdrCngFlg[i] != null)
					model.setBdrCngFlg(bdrCngFlg[i]);
				if (vvPodCd[i] != null)
					model.setVvPodCd(vvPodCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (vvPolCd[i] != null)
					model.setVvPolCd(vvPolCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgPodCd[i] != null)
					model.setBkgPodCd(bkgPodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrCdrDt[i] != null)
					model.setCntrCdrDt(cntrCdrDt[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (special[i] != null)
					model.setSpecial(special[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (repCmdtNm[i] != null)
					model.setRepCmdtNm(repCmdtNm[i]);
				if (fTaaNo[i] != null)
					model.setFTaaNo(fTaaNo[i]);
				if (srepEml[i] != null)
					model.setSrepEml(srepEml[i]);
				if (obSrepEml[i] != null)
					model.setObSrepEml(obSrepEml[i]);
				if (scpCd[i] != null)
					model.setScpCd(scpCd[i]);
				if (aplyTp[i] != null)
					model.setAplyTp(aplyTp[i]);
				if (cgoRcvDt[i] != null)
					model.setCgoRcvDt(cgoRcvDt[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTaaBkgInformVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TaaBkgInformVO[]
	 */
	public TaaBkgInformVO[] getTaaBkgInformVOs(){
		TaaBkgInformVO[] vos = (TaaBkgInformVO[])models.toArray(new TaaBkgInformVO[models.size()]);
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
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorCd = this.bkgPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrCngFlg = this.bdrCngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvPodCd = this.vvPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvPolCd = this.vvPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd = this.bkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCdrDt = this.cntrCdrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.special = this.special .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtNm = this.repCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTaaNo = this.fTaaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepEml = this.srepEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepEml = this.obSrepEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyTp = this.aplyTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoRcvDt = this.cgoRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
