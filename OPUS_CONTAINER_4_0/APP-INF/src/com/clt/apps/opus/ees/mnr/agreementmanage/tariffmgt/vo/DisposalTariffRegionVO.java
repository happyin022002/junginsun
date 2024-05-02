/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DisposalTariffRegionVO.java
*@FileTitle : DisposalTariffRegionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.15
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.09.15 장준우
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DisposalTariffRegionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<DisposalTariffRegionVO> models = new ArrayList<DisposalTariffRegionVO>();

	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String trfEffYr = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String mnrDispTrfSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trfEffQtrNo = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String pTrfEffYr = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String mnrTrfRmk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String mnrDispTrfAmt = null;
	/* Column Info */
	private String pEqKndCd = null;
	/* Column Info */
	private String pTrfEffQtrNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Sequence Number */
	private String insertSeq = null;
	/* Column Info */
	private String complexPk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public DisposalTariffRegionVO() {}

	public DisposalTariffRegionVO(String ibflag, String insertSeq, String complexPk, String pagerows, String pEqKndCd, String pTrfEffYr, String pTrfEffQtrNo, String trfEffYr, String trfEffQtrNo, String mnrDispTrfSeq, String eqKndCd, String eqTpszCd, String locCd, String currCd, String mnrDispTrfAmt, String mnrTrfRmk, String creOfcCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.trfEffYr = trfEffYr;
		this.currCd = currCd;
		this.mnrDispTrfSeq = mnrDispTrfSeq;
		this.creDt = creDt;
		this.trfEffQtrNo = trfEffQtrNo;
		this.eqKndCd = eqKndCd;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.pTrfEffYr = pTrfEffYr;
		this.creUsrId = creUsrId;
		this.mnrTrfRmk = mnrTrfRmk;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.creOfcCd = creOfcCd;
		this.mnrDispTrfAmt = mnrDispTrfAmt;
		this.pEqKndCd = pEqKndCd;
		this.pTrfEffQtrNo = pTrfEffQtrNo;
		this.updUsrId = updUsrId;
		this.insertSeq = insertSeq;
		this.complexPk = complexPk;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("trf_eff_yr", getTrfEffYr());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("mnr_disp_trf_seq", getMnrDispTrfSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trf_eff_qtr_no", getTrfEffQtrNo());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("p_trf_eff_yr", getPTrfEffYr());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mnr_trf_rmk", getMnrTrfRmk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("mnr_disp_trf_amt", getMnrDispTrfAmt());
		this.hashColumns.put("p_eq_knd_cd", getPEqKndCd());
		this.hashColumns.put("p_trf_eff_qtr_no", getPTrfEffQtrNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("insert_seq", getInsertSeq());
		this.hashColumns.put("complex_pk", getComplexPk());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("trf_eff_yr", "trfEffYr");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("mnr_disp_trf_seq", "mnrDispTrfSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trf_eff_qtr_no", "trfEffQtrNo");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("p_trf_eff_yr", "pTrfEffYr");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mnr_trf_rmk", "mnrTrfRmk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("mnr_disp_trf_amt", "mnrDispTrfAmt");
		this.hashFields.put("p_eq_knd_cd", "pEqKndCd");
		this.hashFields.put("p_trf_eff_qtr_no", "pTrfEffQtrNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("insert_seq", "insertSeq");
		this.hashFields.put("complex_pk", "complexPk");
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
	 * @return trfEffYr
	 */
	public String getTrfEffYr() {
		return this.trfEffYr;
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
	 * @return mnrDispTrfSeq
	 */
	public String getMnrDispTrfSeq() {
		return this.mnrDispTrfSeq;
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
	 * @return trfEffQtrNo
	 */
	public String getTrfEffQtrNo() {
		return this.trfEffQtrNo;
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
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}

	/**
	 * Column Info
	 * @return pTrfEffYr
	 */
	public String getPTrfEffYr() {
		return this.pTrfEffYr;
	}

	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}

	/**
	 * Column Info
	 * @return mnrTrfRmk
	 */
	public String getMnrTrfRmk() {
		return this.mnrTrfRmk;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}

	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}

	/**
	 * Column Info
	 * @return mnrDispTrfAmt
	 */
	public String getMnrDispTrfAmt() {
		return this.mnrDispTrfAmt;
	}

	/**
	 * Column Info
	 * @return pEqKndCd
	 */
	public String getPEqKndCd() {
		return this.pEqKndCd;
	}

	/**
	 * Column Info
	 * @return pTrfEffQtrNo
	 */
	public String getPTrfEffQtrNo() {
		return this.pTrfEffQtrNo;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Column Info
	 * @param trfEffYr
	 */
	public void setTrfEffYr(String trfEffYr) {
		this.trfEffYr = trfEffYr;
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
	 * @param mnrDispTrfSeq
	 */
	public void setMnrDispTrfSeq(String mnrDispTrfSeq) {
		this.mnrDispTrfSeq = mnrDispTrfSeq;
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
	 * @param trfEffQtrNo
	 */
	public void setTrfEffQtrNo(String trfEffQtrNo) {
		this.trfEffQtrNo = trfEffQtrNo;
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
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}

	/**
	 * Column Info
	 * @param pTrfEffYr
	 */
	public void setPTrfEffYr(String pTrfEffYr) {
		this.pTrfEffYr = pTrfEffYr;
	}

	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * Column Info
	 * @param mnrTrfRmk
	 */
	public void setMnrTrfRmk(String mnrTrfRmk) {
		this.mnrTrfRmk = mnrTrfRmk;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}

	/**
	 * Column Info
	 * @param mnrDispTrfAmt
	 */
	public void setMnrDispTrfAmt(String mnrDispTrfAmt) {
		this.mnrDispTrfAmt = mnrDispTrfAmt;
	}

	/**
	 * Column Info
	 * @param pEqKndCd
	 */
	public void setPEqKndCd(String pEqKndCd) {
		this.pEqKndCd = pEqKndCd;
	}

	/**
	 * Column Info
	 * @param pTrfEffQtrNo
	 */
	public void setPTrfEffQtrNo(String pTrfEffQtrNo) {
		this.pTrfEffQtrNo = pTrfEffQtrNo;
	}

	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * @return the insertSeq
	 */
	public String getInsertSeq() {
		return insertSeq;
	}

	/**
	 * @param insertSeq the insertSeq to set
	 */
	public void setInsertSeq(String insertSeq) {
		this.insertSeq = insertSeq;
	}

	/**
	 * @return the complexPk
	 */
	public String getComplexPk() {
		return complexPk;
	}

	/**
	 * @param complexPk the complexPk to set
	 */
	public void setComplexPk(String complexPk) {
		this.complexPk = complexPk;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTrfEffYr(JSPUtil.getParameter(request, prefix + "trf_eff_yr", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setMnrDispTrfSeq(JSPUtil.getParameter(request, prefix + "mnr_disp_trf_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrfEffQtrNo(JSPUtil.getParameter(request, prefix + "trf_eff_qtr_no", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setPTrfEffYr(JSPUtil.getParameter(request, prefix + "p_trf_eff_yr", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setMnrTrfRmk(JSPUtil.getParameter(request, prefix + "mnr_trf_rmk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setMnrDispTrfAmt(JSPUtil.getParameter(request, prefix + "mnr_disp_trf_amt", ""));
		setPEqKndCd(JSPUtil.getParameter(request, prefix + "p_eq_knd_cd", ""));
		setPTrfEffQtrNo(JSPUtil.getParameter(request, prefix + "p_trf_eff_qtr_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setInsertSeq(JSPUtil.getParameter(request, prefix + "insert_seq", ""));
		setComplexPk(JSPUtil.getParameter(request, prefix + "complex_pk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DisposalTariffRegionVO[]
	 */
	public DisposalTariffRegionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return DisposalTariffRegionVO[]
	 */
	public DisposalTariffRegionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DisposalTariffRegionVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] trfEffYr = (JSPUtil.getParameter(request, prefix	+ "trf_eff_yr", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] mnrDispTrfSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trfEffQtrNo = (JSPUtil.getParameter(request, prefix	+ "trf_eff_qtr_no", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] pTrfEffYr = (JSPUtil.getParameter(request, prefix	+ "p_trf_eff_yr", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] mnrTrfRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_trf_rmk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] mnrDispTrfAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_amt", length));
			String[] pEqKndCd = (JSPUtil.getParameter(request, prefix	+ "p_eq_knd_cd", length));
			String[] pTrfEffQtrNo = (JSPUtil.getParameter(request, prefix	+ "p_trf_eff_qtr_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] insertSeq = (JSPUtil.getParameter(request, prefix	+ "insert_seq", length));
			String[] complexPk = (JSPUtil.getParameter(request, prefix	+ "complex_pk", length));

			for (int i = 0; i < length; i++) {
				model = new DisposalTariffRegionVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (trfEffYr[i] != null)
					model.setTrfEffYr(trfEffYr[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (mnrDispTrfSeq[i] != null)
					model.setMnrDispTrfSeq(mnrDispTrfSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trfEffQtrNo[i] != null)
					model.setTrfEffQtrNo(trfEffQtrNo[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (pTrfEffYr[i] != null)
					model.setPTrfEffYr(pTrfEffYr[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (mnrTrfRmk[i] != null)
					model.setMnrTrfRmk(mnrTrfRmk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (mnrDispTrfAmt[i] != null)
					model.setMnrDispTrfAmt(mnrDispTrfAmt[i]);
				if (pEqKndCd[i] != null)
					model.setPEqKndCd(pEqKndCd[i]);
				if (pTrfEffQtrNo[i] != null)
					model.setPTrfEffQtrNo(pTrfEffQtrNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (insertSeq[i] != null)
					model.setInsertSeq(insertSeq[i]);
				if (complexPk[i] != null)
					model.setComplexPk(complexPk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDisposalTariffRegionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DisposalTariffRegionVO[]
	 */
	public DisposalTariffRegionVO[] getDisposalTariffRegionVOs(){
		DisposalTariffRegionVO[] vos = (DisposalTariffRegionVO[])models.toArray(new DisposalTariffRegionVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfEffYr = this.trfEffYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispTrfSeq = this.mnrDispTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfEffQtrNo = this.trfEffQtrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pTrfEffYr = this.pTrfEffYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTrfRmk = this.mnrTrfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispTrfAmt = this.mnrDispTrfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pEqKndCd = this.pEqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pTrfEffQtrNo = this.pTrfEffQtrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insertSeq = this.insertSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk = this.complexPk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
