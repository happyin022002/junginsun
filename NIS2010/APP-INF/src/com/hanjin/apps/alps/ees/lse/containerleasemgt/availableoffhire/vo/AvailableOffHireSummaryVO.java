/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AvailableOffHireSummaryVO.java
*@FileTitle : AvailableOffHireSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.09.29 장준우
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AvailableOffHireSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<AvailableOffHireSummaryVO> models = new ArrayList<AvailableOffHireSummaryVO>();

	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vlQty = null;
	/* Column Info */
	private String balQty = null;
	/* Column Info */
	private String pfmcQty = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String totQty = null;
	/* Column Info */
	private String mtQty = null;
	/* Column Info */
	private String icQty = null;
	/* Column Info */
	private String idQty = null;
	/* Column Info */
	private String etnQty = null;
	/* Column Info */
	private String resQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String dolQty = null;
	/* Column Info */
	private String remQty = null;
	/* Column Info */
	private String hldQty = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String refNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public AvailableOffHireSummaryVO() {}

	public AvailableOffHireSummaryVO(String ibflag, String pagerows, String hldQty, String sccCd, String agmtCtyCd, String agmtSeq, String etnQty, String agmtNo, String vndrSeq, String vndrAbbrNm, String lstmCd, String cntrTpszCd, String dolQty, String pfmcQty, String balQty, String resQty, String remQty, String vlQty, String icQty, String idQty, String mtQty, String totQty, String cntrQty, String creUsrId, String creDt, String updUsrId, String updDt, String vndrLglEngNm, String refNo) {
		this.updDt = updDt;
		this.vlQty = vlQty;
		this.balQty = balQty;
		this.pfmcQty = pfmcQty;
		this.agmtSeq = agmtSeq;
		this.creDt = creDt;
		this.agmtNo = agmtNo;
		this.totQty = totQty;
		this.mtQty = mtQty;
		this.icQty = icQty;
		this.idQty = idQty;
		this.etnQty = etnQty;
		this.resQty = resQty;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.sccCd = sccCd;
		this.dolQty = dolQty;
		this.remQty = remQty;
		this.hldQty = hldQty;
		this.vndrSeq = vndrSeq;
		this.agmtCtyCd = agmtCtyCd;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrQty = cntrQty;
		this.vndrAbbrNm = vndrAbbrNm;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
		this.vndrLglEngNm = vndrLglEngNm;
		this.refNo = refNo;
		
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vl_qty", getVlQty());
		this.hashColumns.put("bal_qty", getBalQty());
		this.hashColumns.put("pfmc_qty", getPfmcQty());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("tot_qty", getTotQty());
		this.hashColumns.put("mt_qty", getMtQty());
		this.hashColumns.put("ic_qty", getIcQty());
		this.hashColumns.put("id_qty", getIdQty());
		this.hashColumns.put("etn_qty", getEtnQty());
		this.hashColumns.put("res_qty", getResQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("dol_qty", getDolQty());
		this.hashColumns.put("rem_qty", getRemQty());
		this.hashColumns.put("hld_qty", getHldQty());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("ref_no", getRefNo());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vl_qty", "vlQty");
		this.hashFields.put("bal_qty", "balQty");
		this.hashFields.put("pfmc_qty", "pfmcQty");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("tot_qty", "totQty");
		this.hashFields.put("mt_qty", "mtQty");
		this.hashFields.put("ic_qty", "icQty");
		this.hashFields.put("id_qty", "idQty");
		this.hashFields.put("etn_qty", "etnQty");
		this.hashFields.put("res_qty", "resQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("dol_qty", "dolQty");
		this.hashFields.put("rem_qty", "remQty");
		this.hashFields.put("hld_qty", "hldQty");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("ref_no", "refNo");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}

	/**
	 * Column Info
	 * @return vlQty
	 */
	public String getVlQty() {
		return this.vlQty;
	}

	/**
	 * Column Info
	 * @return balQty
	 */
	public String getBalQty() {
		return this.balQty;
	}

	/**
	 * Column Info
	 * @return pfmcQty
	 */
	public String getPfmcQty() {
		return this.pfmcQty;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}

	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}

	/**
	 * Column Info
	 * @return totQty
	 */
	public String getTotQty() {
		return this.totQty;
	}

	/**
	 * Column Info
	 * @return mtQty
	 */
	public String getMtQty() {
		return this.mtQty;
	}

	/**
	 * Column Info
	 * @return icQty
	 */
	public String getIcQty() {
		return this.icQty;
	}

	/**
	 * Column Info
	 * @return idQty
	 */
	public String getIdQty() {
		return this.idQty;
	}

	/**
	 * Column Info
	 * @return resQty
	 */
	public String getResQty() {
		return this.resQty;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}

	/**
	 * Column Info
	 * @return dolQty
	 */
	public String getDolQty() {
		return this.dolQty;
	}

	/**
	 * Column Info
	 * @return remQty
	 */
	public String getRemQty() {
		return this.remQty;
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
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}

	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}

	/**
	 * Column Info
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}

	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}

	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}

	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Column Info
	 * @param vlQty
	 */
	public void setVlQty(String vlQty) {
		this.vlQty = vlQty;
	}

	/**
	 * Column Info
	 * @param balQty
	 */
	public void setBalQty(String balQty) {
		this.balQty = balQty;
	}

	/**
	 * Column Info
	 * @param pfmcQty
	 */
	public void setPfmcQty(String pfmcQty) {
		this.pfmcQty = pfmcQty;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}

	/**
	 * Column Info
	 * @param totQty
	 */
	public void setTotQty(String totQty) {
		this.totQty = totQty;
	}

	/**
	 * Column Info
	 * @param mtQty
	 */
	public void setMtQty(String mtQty) {
		this.mtQty = mtQty;
	}

	/**
	 * Column Info
	 * @param icQty
	 */
	public void setIcQty(String icQty) {
		this.icQty = icQty;
	}

	/**
	 * Column Info
	 * @param idQty
	 */
	public void setIdQty(String idQty) {
		this.idQty = idQty;
	}

	/**
	 * Column Info
	 * @param resQty
	 */
	public void setResQty(String resQty) {
		this.resQty = resQty;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}

	/**
	 * Column Info
	 * @param dolQty
	 */
	public void setDolQty(String dolQty) {
		this.dolQty = dolQty;
	}

	/**
	 * Column Info
	 * @param remQty
	 */
	public void setRemQty(String remQty) {
		this.remQty = remQty;
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
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}

	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}

	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}

	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}

	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * @return the vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return vndrLglEngNm;
	}

	/**
	 * @param vndrLglEngNm the vndrLglEngNm to set
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}

	/**
	 * @return the etnQty
	 */
	public String getEtnQty() {
		return etnQty;
	}

	/**
	 * @param etnQty the etnQty to set
	 */
	public void setEtnQty(String etnQty) {
		this.etnQty = etnQty;
	}

	/**
	 * @return the hldQty
	 */
	public String getHldQty() {
		return hldQty;
	}

	/**
	 * @param hldQty the hldQty to set
	 */
	public void setHldQty(String hldQty) {
		this.hldQty = hldQty;
	}
	
	/**
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setVlQty(JSPUtil.getParameter(request, "vl_qty", ""));
		setBalQty(JSPUtil.getParameter(request, "bal_qty", ""));
		setPfmcQty(JSPUtil.getParameter(request, "pfmc_qty", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setTotQty(JSPUtil.getParameter(request, "tot_qty", ""));
		setMtQty(JSPUtil.getParameter(request, "mt_qty", ""));
		setIcQty(JSPUtil.getParameter(request, "ic_qty", ""));
		setIdQty(JSPUtil.getParameter(request, "id_qty", ""));
		setEtnQty(JSPUtil.getParameter(request, "etn_qty", ""));
		setResQty(JSPUtil.getParameter(request, "res_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setDolQty(JSPUtil.getParameter(request, "dol_qty", ""));
		setRemQty(JSPUtil.getParameter(request, "rem_qty", ""));
		setHldQty(JSPUtil.getParameter(request, "hld_qty", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCntrQty(JSPUtil.getParameter(request, "cntr_qty", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AvailableOffHireSummaryVO[]
	 */
	public AvailableOffHireSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AvailableOffHireSummaryVO[]
	 */
	public AvailableOffHireSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AvailableOffHireSummaryVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vlQty = (JSPUtil.getParameter(request, prefix	+ "vl_qty", length));
			String[] balQty = (JSPUtil.getParameter(request, prefix	+ "bal_qty", length));
			String[] pfmcQty = (JSPUtil.getParameter(request, prefix	+ "pfmc_qty", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] totQty = (JSPUtil.getParameter(request, prefix	+ "tot_qty", length));
			String[] mtQty = (JSPUtil.getParameter(request, prefix	+ "mt_qty", length));
			String[] icQty = (JSPUtil.getParameter(request, prefix	+ "ic_qty", length));
			String[] idQty = (JSPUtil.getParameter(request, prefix	+ "id_qty", length));
			String[] etnQty = (JSPUtil.getParameter(request, prefix	+ "etn_qty", length));
			String[] resQty = (JSPUtil.getParameter(request, prefix	+ "res_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] dolQty = (JSPUtil.getParameter(request, prefix	+ "dol_qty", length));
			String[] remQty = (JSPUtil.getParameter(request, prefix	+ "rem_qty", length));
			String[] hldQty = (JSPUtil.getParameter(request, prefix	+ "hld_qty", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));

			for (int i = 0; i < length; i++) {
				model = new AvailableOffHireSummaryVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vlQty[i] != null)
					model.setVlQty(vlQty[i]);
				if (balQty[i] != null)
					model.setBalQty(balQty[i]);
				if (pfmcQty[i] != null)
					model.setPfmcQty(pfmcQty[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (totQty[i] != null)
					model.setTotQty(totQty[i]);
				if (mtQty[i] != null)
					model.setMtQty(mtQty[i]);
				if (icQty[i] != null)
					model.setIcQty(icQty[i]);
				if (idQty[i] != null)
					model.setIdQty(idQty[i]);
				if (etnQty[i] != null)
					model.setEtnQty(etnQty[i]);
				if (resQty[i] != null)
					model.setResQty(resQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (dolQty[i] != null)
					model.setDolQty(dolQty[i]);
				if (remQty[i] != null)
					model.setRemQty(remQty[i]);
				if (hldQty[i] != null)
					model.setHldQty(hldQty[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAvailableOffHireSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AvailableOffHireSummaryVO[]
	 */
	public AvailableOffHireSummaryVO[] getAvailableOffHireSummaryVOs(){
		AvailableOffHireSummaryVO[] vos = (AvailableOffHireSummaryVO[])models.toArray(new AvailableOffHireSummaryVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vlQty = this.vlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balQty = this.balQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcQty = this.pfmcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totQty = this.totQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtQty = this.mtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.icQty = this.icQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idQty = this.idQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etnQty = this.etnQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.resQty = this.resQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dolQty = this.dolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remQty = this.remQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldQty = this.hldQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
