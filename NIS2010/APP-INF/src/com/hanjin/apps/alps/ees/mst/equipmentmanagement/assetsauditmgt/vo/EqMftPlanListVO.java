/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchEqManufacturePlanListVO.java
*@FileTitle : SearchEqManufacturePlanListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.22
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.03.22 남궁진호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EqMftPlanListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqMftPlanListVO> models = new ArrayList<EqMftPlanListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fmSerNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cntrFlrMtrlCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String plnYr = null;
	/* Column Info */
	private String lotCntrPfxCd = null;
	/* Column Info */
	private String eqTpCd = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String toSerNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rfTpCd = null;
	/* Column Info */
	private String cntrHngrRckCd = null;
	/* Column Info */
	private String serTmp = null;
	/* Column Info */
	private String plnSeq = null;
	/* Column Info */
	private String rmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EqMftPlanListVO() {}

	public EqMftPlanListVO(String ibflag, String pagerows, String plnYr, String eqTpCd, String eqTpszCd, 
								   String cntrHngrRckCd, String cntrFlrMtrlCd, String rfTpCd, String lotCntrPfxCd, 
								   String fmSerNo, String toSerNo, String cntrQty, String creUsrId, String creDt, 
								   String updUsrId, String updDt, String serTmp, String plnSeq, String rmk) {
		this.updDt = updDt;
		this.fmSerNo = fmSerNo;
		this.creDt = creDt;
		this.cntrFlrMtrlCd = cntrFlrMtrlCd;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.plnYr = plnYr;
		this.lotCntrPfxCd = lotCntrPfxCd;
		this.eqTpCd = eqTpCd;
		this.cntrQty = cntrQty;
		this.toSerNo = toSerNo;
		this.updUsrId = updUsrId;
		this.rfTpCd = rfTpCd;
		this.cntrHngrRckCd = cntrHngrRckCd;
		this.serTmp = serTmp;
		this.plnSeq = plnSeq;
		this.rmk = rmk;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("fm_ser_no", getFmSerNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cntr_flr_mtrl_cd", getCntrFlrMtrlCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pln_yr", getPlnYr());
		this.hashColumns.put("lot_cntr_pfx_cd", getLotCntrPfxCd());
		this.hashColumns.put("eq_tp_cd", getEqTpCd());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("to_ser_no", getToSerNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rf_tp_cd", getRfTpCd());
		this.hashColumns.put("cntr_hngr_rck_cd", getCntrHngrRckCd());
		this.hashColumns.put("ser_tmp", getSerTmp());
		this.hashColumns.put("pln_seq", getPlnSeq());
		this.hashColumns.put("rmk", getRmk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("fm_ser_no", "fmSerNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cntr_flr_mtrl_cd", "cntrFlrMtrlCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pln_yr", "plnYr");
		this.hashFields.put("lot_cntr_pfx_cd", "lotCntrPfxCd");
		this.hashFields.put("eq_tp_cd", "eqTpCd");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("to_ser_no", "toSerNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rf_tp_cd", "rfTpCd");
		this.hashFields.put("cntr_hngr_rck_cd", "cntrHngrRckCd");
		this.hashFields.put("ser_tmp", "serTmp");
		this.hashFields.put("pln_seq", "plnSeq");
		this.hashFields.put("rmk", "rmk");
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
	 * @return fmSerNo
	 */
	public String getFmSerNo() {
		return this.fmSerNo;
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
	 * @return cntrFlrMtrlCd
	 */
	public String getCntrFlrMtrlCd() {
		return this.cntrFlrMtrlCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return plnYr
	 */
	public String getPlnYr() {
		return this.plnYr;
	}
	
	/**
	 * Column Info
	 * @return lotCntrPfxCd
	 */
	public String getLotCntrPfxCd() {
		return this.lotCntrPfxCd;
	}
	
	/**
	 * Column Info
	 * @return eqTpCd
	 */
	public String getEqTpCd() {
		return this.eqTpCd;
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
	 * @return toSerNo
	 */
	public String getToSerNo() {
		return this.toSerNo;
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
	 * @return rfTpCd
	 */
	public String getRfTpCd() {
		return this.rfTpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrHngrRckCd
	 */
	public String getCntrHngrRckCd() {
		return this.cntrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @return serTmp
	 */
	public String getSerTmp() {
		return this.serTmp;
	}
	
	/**
	 * Column Info
	 * @return plnSeq
	 */
	public String getPlnSeq() {
		return this.plnSeq;
	}
	
	/**
	 * Column Info
	 * @return rmk
	 */
	public String getRmk() {
		return this.rmk;
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
	 * @param fmSerNo
	 */
	public void setFmSerNo(String fmSerNo) {
		this.fmSerNo = fmSerNo;
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
	 * @param cntrFlrMtrlCd
	 */
	public void setCntrFlrMtrlCd(String cntrFlrMtrlCd) {
		this.cntrFlrMtrlCd = cntrFlrMtrlCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param plnYr
	 */
	public void setPlnYr(String plnYr) {
		this.plnYr = plnYr;
	}
	
	/**
	 * Column Info
	 * @param lotCntrPfxCd
	 */
	public void setLotCntrPfxCd(String lotCntrPfxCd) {
		this.lotCntrPfxCd = lotCntrPfxCd;
	}
	
	/**
	 * Column Info
	 * @param eqTpCd
	 */
	public void setEqTpCd(String eqTpCd) {
		this.eqTpCd = eqTpCd;
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
	 * @param toSerNo
	 */
	public void setToSerNo(String toSerNo) {
		this.toSerNo = toSerNo;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param rfTpCd
	 */
	public void setRfTpCd(String rfTpCd) {
		this.rfTpCd = rfTpCd;
	}
	
	/**
	 * Column Info
	 * @param cntrHngrRckCd
	 */
	public void setCntrHngrRckCd(String cntrHngrRckCd) {
		this.cntrHngrRckCd = cntrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @param serTmp
	 */
	public void setSerTmp(String serTmp) {
		this.serTmp = serTmp;
	}

	/**
	 * Column Info
	 * @param plnSeq
	 */
	public void setPlnSeq(String plnSeq) {
		this.plnSeq = plnSeq;
	}
	
	/**
	 * Column Info
	 * @param rmk
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
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
		setFmSerNo(JSPUtil.getParameter(request, prefix + "fm_ser_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCntrFlrMtrlCd(JSPUtil.getParameter(request, prefix + "cntr_flr_mtrl_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPlnYr(JSPUtil.getParameter(request, prefix + "pln_yr", ""));
		setLotCntrPfxCd(JSPUtil.getParameter(request, prefix + "lot_cntr_pfx_cd", ""));
		setEqTpCd(JSPUtil.getParameter(request, prefix + "eq_tp_cd", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setToSerNo(JSPUtil.getParameter(request, prefix + "to_ser_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRfTpCd(JSPUtil.getParameter(request, prefix + "rf_tp_cd", ""));
		setPlnSeq(JSPUtil.getParameter(request, prefix + "pln_seq", ""));
		setCntrHngrRckCd(JSPUtil.getParameter(request, prefix + "cntr_hngr_rck_cd", ""));
		setRmk(JSPUtil.getParameter(request, prefix + "rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEqManufacturePlanListVO[]
	 */
	public EqMftPlanListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEqManufacturePlanListVO[]
	 */
	public EqMftPlanListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqMftPlanListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] fmSerNo = (JSPUtil.getParameter(request, prefix	+ "fm_ser_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cntrFlrMtrlCd = (JSPUtil.getParameter(request, prefix	+ "cntr_flr_mtrl_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] plnYr = (JSPUtil.getParameter(request, prefix	+ "pln_yr", length));
			String[] plnSeq = (JSPUtil.getParameter(request, prefix	+ "pln_seq", length));
			String[] lotCntrPfxCd = (JSPUtil.getParameter(request, prefix	+ "lot_cntr_pfx_cd", length));
			String[] eqTpCd = (JSPUtil.getParameter(request, prefix	+ "eq_tp_cd", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] toSerNo = (JSPUtil.getParameter(request, prefix	+ "to_ser_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rfTpCd = (JSPUtil.getParameter(request, prefix	+ "rf_tp_cd", length));
			String[] cntrHngrRckCd = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_rck_cd", length));
			String[] rmk = (JSPUtil.getParameter(request, prefix	+ "rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new EqMftPlanListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fmSerNo[i] != null)
					model.setFmSerNo(fmSerNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cntrFlrMtrlCd[i] != null)
					model.setCntrFlrMtrlCd(cntrFlrMtrlCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (plnYr[i] != null)
					model.setPlnYr(plnYr[i]);
				if (plnSeq[i] != null)
					model.setPlnSeq(plnSeq[i]);
				if (lotCntrPfxCd[i] != null)
					model.setLotCntrPfxCd(lotCntrPfxCd[i]);
				if (eqTpCd[i] != null)
					model.setEqTpCd(eqTpCd[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (toSerNo[i] != null)
					model.setToSerNo(toSerNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rfTpCd[i] != null)
					model.setRfTpCd(rfTpCd[i]);
				if (cntrHngrRckCd[i] != null)
					model.setCntrHngrRckCd(cntrHngrRckCd[i]);
				if (rmk[i] != null)
					model.setRmk(rmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEqManufacturePlanListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEqManufacturePlanListVO[]
	 */
	public EqMftPlanListVO[] getSearchEqManufacturePlanListVOs(){
		EqMftPlanListVO[] vos = (EqMftPlanListVO[])models.toArray(new EqMftPlanListVO[models.size()]);
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
		this.fmSerNo = this.fmSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFlrMtrlCd = this.cntrFlrMtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYr = this.plnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnSeq = this.plnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotCntrPfxCd = this.lotCntrPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpCd = this.eqTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSerNo = this.toSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCd = this.rfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCd = this.cntrHngrRckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
