/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EqrCtrlObFcastRtoVO.java
*@FileTitle : EqrCtrlObFcastRtoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.26  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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
 
public class EqrCtrlObFcastRtoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqrCtrlObFcastRtoVO> models = new ArrayList<EqrCtrlObFcastRtoVO>();
	
	/* Column Info */
	private String d2FcastQty = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String otrFcastRto = null;
	/* Column Info */
	private String eqFcastRtoLvlCd = null;
	/* Column Info */
	private String d7FcastQty = null;
	/* Column Info */
	private String avgTtDys = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String d5FcastQty = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String polEccCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseDt = null;
	/* Column Info */
	private String d5FcastRto = null;
	/* Column Info */
	private String d4FcastQty = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */ 
	private String fcastYrwk = null;
	/* Column Info */
	private String otrFcastQty = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String d4FcastRto = null;
	/* Column Info */
	private String d2FcastRto = null;
	/* Column Info */
	private String cntrPkupSccCd = null;
	/* Column Info */
	private String d7FcastRto = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EqrCtrlObFcastRtoVO() {}

	public EqrCtrlObFcastRtoVO(String ibflag, String pagerows, String fcastYrwk, String bseDt, String rlaneCd, String slsOfcCd, String polEccCd, String cntrPkupSccCd, String avgTtDys, String d2FcastRto, String d4FcastRto, String d5FcastRto, String d7FcastRto, String otrFcastRto, String creUsrId, String creDt, String updUsrId, String updDt, String d2FcastQty, String d4FcastQty, String d5FcastQty, String d7FcastQty, String otrFcastQty, String eqFcastRtoLvlCd) {
		this.d2FcastQty = d2FcastQty;
		this.updDt = updDt;
		this.otrFcastRto = otrFcastRto;
		this.eqFcastRtoLvlCd = eqFcastRtoLvlCd;
		this.d7FcastQty = d7FcastQty;
		this.avgTtDys = avgTtDys;
		this.creDt = creDt;
		this.d5FcastQty = d5FcastQty;
		this.rlaneCd = rlaneCd;
		this.polEccCd = polEccCd;
		this.pagerows = pagerows;
		this.bseDt = bseDt;
		this.d5FcastRto = d5FcastRto;
		this.d4FcastQty = d4FcastQty;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.fcastYrwk = fcastYrwk;
		this.otrFcastQty = otrFcastQty;
		this.slsOfcCd = slsOfcCd;
		this.d4FcastRto = d4FcastRto;
		this.d2FcastRto = d2FcastRto;
		this.cntrPkupSccCd = cntrPkupSccCd;
		this.d7FcastRto = d7FcastRto;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("d2_fcast_qty", getD2FcastQty());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("otr_fcast_rto", getOtrFcastRto());
		this.hashColumns.put("eq_fcast_rto_lvl_cd", getEqFcastRtoLvlCd());
		this.hashColumns.put("d7_fcast_qty", getD7FcastQty());
		this.hashColumns.put("avg_tt_dys", getAvgTtDys());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("d5_fcast_qty", getD5FcastQty());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pol_ecc_cd", getPolEccCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_dt", getBseDt());
		this.hashColumns.put("d5_fcast_rto", getD5FcastRto());
		this.hashColumns.put("d4_fcast_qty", getD4FcastQty());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fcast_yrwk", getFcastYrwk());
		this.hashColumns.put("otr_fcast_qty", getOtrFcastQty());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("d4_fcast_rto", getD4FcastRto());
		this.hashColumns.put("d2_fcast_rto", getD2FcastRto());
		this.hashColumns.put("cntr_pkup_scc_cd", getCntrPkupSccCd());
		this.hashColumns.put("d7_fcast_rto", getD7FcastRto());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("d2_fcast_qty", "d2FcastQty");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("otr_fcast_rto", "otrFcastRto");
		this.hashFields.put("eq_fcast_rto_lvl_cd", "eqFcastRtoLvlCd");
		this.hashFields.put("d7_fcast_qty", "d7FcastQty");
		this.hashFields.put("avg_tt_dys", "avgTtDys");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("d5_fcast_qty", "d5FcastQty");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pol_ecc_cd", "polEccCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_dt", "bseDt");
		this.hashFields.put("d5_fcast_rto", "d5FcastRto");
		this.hashFields.put("d4_fcast_qty", "d4FcastQty");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fcast_yrwk", "fcastYrwk");
		this.hashFields.put("otr_fcast_qty", "otrFcastQty");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("d4_fcast_rto", "d4FcastRto");
		this.hashFields.put("d2_fcast_rto", "d2FcastRto");
		this.hashFields.put("cntr_pkup_scc_cd", "cntrPkupSccCd");
		this.hashFields.put("d7_fcast_rto", "d7FcastRto");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return d2FcastQty
	 */
	public String getD2FcastQty() {
		return this.d2FcastQty;
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
	 * @return otrFcastRto
	 */
	public String getOtrFcastRto() {
		return this.otrFcastRto;
	}
	
	/**
	 * Column Info
	 * @return eqFcastRtoLvlCd
	 */
	public String getEqFcastRtoLvlCd() {
		return this.eqFcastRtoLvlCd;
	}
	
	/**
	 * Column Info
	 * @return d7FcastQty
	 */
	public String getD7FcastQty() {
		return this.d7FcastQty;
	}
	
	/**
	 * Column Info
	 * @return avgTtDys
	 */
	public String getAvgTtDys() {
		return this.avgTtDys;
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
	 * @return d5FcastQty
	 */
	public String getD5FcastQty() {
		return this.d5FcastQty;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return polEccCd
	 */
	public String getPolEccCd() {
		return this.polEccCd;
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
	 * @return bseDt
	 */
	public String getBseDt() {
		return this.bseDt;
	}
	
	/**
	 * Column Info
	 * @return d5FcastRto
	 */
	public String getD5FcastRto() {
		return this.d5FcastRto;
	}
	
	/**
	 * Column Info
	 * @return d4FcastQty
	 */
	public String getD4FcastQty() {
		return this.d4FcastQty;
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
	 * @return fcastYrwk
	 */
	public String getFcastYrwk() {
		return this.fcastYrwk;
	}
	
	/**
	 * Column Info
	 * @return otrFcastQty
	 */
	public String getOtrFcastQty() {
		return this.otrFcastQty;
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
	 * @return d4FcastRto
	 */
	public String getD4FcastRto() {
		return this.d4FcastRto;
	}
	
	/**
	 * Column Info
	 * @return d2FcastRto
	 */
	public String getD2FcastRto() {
		return this.d2FcastRto;
	}
	
	/**
	 * Column Info
	 * @return cntrPkupSccCd
	 */
	public String getCntrPkupSccCd() {
		return this.cntrPkupSccCd;
	}
	
	/**
	 * Column Info
	 * @return d7FcastRto
	 */
	public String getD7FcastRto() {
		return this.d7FcastRto;
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
	 * @param d2FcastQty
	 */
	public void setD2FcastQty(String d2FcastQty) {
		this.d2FcastQty = d2FcastQty;
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
	 * @param otrFcastRto
	 */
	public void setOtrFcastRto(String otrFcastRto) {
		this.otrFcastRto = otrFcastRto;
	}
	
	/**
	 * Column Info
	 * @param eqFcastRtoLvlCd
	 */
	public void setEqFcastRtoLvlCd(String eqFcastRtoLvlCd) {
		this.eqFcastRtoLvlCd = eqFcastRtoLvlCd;
	}
	
	/**
	 * Column Info
	 * @param d7FcastQty
	 */
	public void setD7FcastQty(String d7FcastQty) {
		this.d7FcastQty = d7FcastQty;
	}
	
	/**
	 * Column Info
	 * @param avgTtDys
	 */
	public void setAvgTtDys(String avgTtDys) {
		this.avgTtDys = avgTtDys;
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
	 * @param d5FcastQty
	 */
	public void setD5FcastQty(String d5FcastQty) {
		this.d5FcastQty = d5FcastQty;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param polEccCd
	 */
	public void setPolEccCd(String polEccCd) {
		this.polEccCd = polEccCd;
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
	 * @param bseDt
	 */
	public void setBseDt(String bseDt) {
		this.bseDt = bseDt;
	}
	
	/**
	 * Column Info
	 * @param d5FcastRto
	 */
	public void setD5FcastRto(String d5FcastRto) {
		this.d5FcastRto = d5FcastRto;
	}
	
	/**
	 * Column Info
	 * @param d4FcastQty
	 */
	public void setD4FcastQty(String d4FcastQty) {
		this.d4FcastQty = d4FcastQty;
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
	 * @param fcastYrwk
	 */
	public void setFcastYrwk(String fcastYrwk) {
		this.fcastYrwk = fcastYrwk;
	}
	
	/**
	 * Column Info
	 * @param otrFcastQty
	 */
	public void setOtrFcastQty(String otrFcastQty) {
		this.otrFcastQty = otrFcastQty;
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
	 * @param d4FcastRto
	 */
	public void setD4FcastRto(String d4FcastRto) {
		this.d4FcastRto = d4FcastRto;
	}
	
	/**
	 * Column Info
	 * @param d2FcastRto
	 */
	public void setD2FcastRto(String d2FcastRto) {
		this.d2FcastRto = d2FcastRto;
	}
	
	/**
	 * Column Info
	 * @param cntrPkupSccCd
	 */
	public void setCntrPkupSccCd(String cntrPkupSccCd) {
		this.cntrPkupSccCd = cntrPkupSccCd;
	}
	
	/**
	 * Column Info
	 * @param d7FcastRto
	 */
	public void setD7FcastRto(String d7FcastRto) {
		this.d7FcastRto = d7FcastRto;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setD2FcastQty(JSPUtil.getParameter(request, prefix + "d2_fcast_qty", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setOtrFcastRto(JSPUtil.getParameter(request, prefix + "otr_fcast_rto", ""));
		setEqFcastRtoLvlCd(JSPUtil.getParameter(request, prefix + "eq_fcast_rto_lvl_cd", ""));
		setD7FcastQty(JSPUtil.getParameter(request, prefix + "d7_fcast_qty", ""));
		setAvgTtDys(JSPUtil.getParameter(request, prefix + "avg_tt_dys", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setD5FcastQty(JSPUtil.getParameter(request, prefix + "d5_fcast_qty", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPolEccCd(JSPUtil.getParameter(request, prefix + "pol_ecc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBseDt(JSPUtil.getParameter(request, prefix + "bse_dt", ""));
		setD5FcastRto(JSPUtil.getParameter(request, prefix + "d5_fcast_rto", ""));
		setD4FcastQty(JSPUtil.getParameter(request, prefix + "d4_fcast_qty", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFcastYrwk(JSPUtil.getParameter(request, prefix + "fcast_yrwk", ""));
		setOtrFcastQty(JSPUtil.getParameter(request, prefix + "otr_fcast_qty", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setD4FcastRto(JSPUtil.getParameter(request, prefix + "d4_fcast_rto", ""));
		setD2FcastRto(JSPUtil.getParameter(request, prefix + "d2_fcast_rto", ""));
		setCntrPkupSccCd(JSPUtil.getParameter(request, prefix + "cntr_pkup_scc_cd", ""));
		setD7FcastRto(JSPUtil.getParameter(request, prefix + "d7_fcast_rto", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EqrCtrlObFcastRtoVO[]
	 */
	public EqrCtrlObFcastRtoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqrCtrlObFcastRtoVO[]
	 */
	public EqrCtrlObFcastRtoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqrCtrlObFcastRtoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] d2FcastQty = (JSPUtil.getParameter(request, prefix	+ "d2_fcast_qty", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] otrFcastRto = (JSPUtil.getParameter(request, prefix	+ "otr_fcast_rto", length));
			String[] eqFcastRtoLvlCd = (JSPUtil.getParameter(request, prefix	+ "eq_fcast_rto_lvl_cd", length));
			String[] d7FcastQty = (JSPUtil.getParameter(request, prefix	+ "d7_fcast_qty", length));
			String[] avgTtDys = (JSPUtil.getParameter(request, prefix	+ "avg_tt_dys", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] d5FcastQty = (JSPUtil.getParameter(request, prefix	+ "d5_fcast_qty", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] polEccCd = (JSPUtil.getParameter(request, prefix	+ "pol_ecc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseDt = (JSPUtil.getParameter(request, prefix	+ "bse_dt", length));
			String[] d5FcastRto = (JSPUtil.getParameter(request, prefix	+ "d5_fcast_rto", length));
			String[] d4FcastQty = (JSPUtil.getParameter(request, prefix	+ "d4_fcast_qty", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fcastYrwk = (JSPUtil.getParameter(request, prefix	+ "fcast_yrwk", length));
			String[] otrFcastQty = (JSPUtil.getParameter(request, prefix	+ "otr_fcast_qty", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] d4FcastRto = (JSPUtil.getParameter(request, prefix	+ "d4_fcast_rto", length));
			String[] d2FcastRto = (JSPUtil.getParameter(request, prefix	+ "d2_fcast_rto", length));
			String[] cntrPkupSccCd = (JSPUtil.getParameter(request, prefix	+ "cntr_pkup_scc_cd", length));
			String[] d7FcastRto = (JSPUtil.getParameter(request, prefix	+ "d7_fcast_rto", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new EqrCtrlObFcastRtoVO();
				if (d2FcastQty[i] != null)
					model.setD2FcastQty(d2FcastQty[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (otrFcastRto[i] != null)
					model.setOtrFcastRto(otrFcastRto[i]);
				if (eqFcastRtoLvlCd[i] != null)
					model.setEqFcastRtoLvlCd(eqFcastRtoLvlCd[i]);
				if (d7FcastQty[i] != null)
					model.setD7FcastQty(d7FcastQty[i]);
				if (avgTtDys[i] != null)
					model.setAvgTtDys(avgTtDys[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (d5FcastQty[i] != null)
					model.setD5FcastQty(d5FcastQty[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (polEccCd[i] != null)
					model.setPolEccCd(polEccCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseDt[i] != null)
					model.setBseDt(bseDt[i]);
				if (d5FcastRto[i] != null)
					model.setD5FcastRto(d5FcastRto[i]);
				if (d4FcastQty[i] != null)
					model.setD4FcastQty(d4FcastQty[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fcastYrwk[i] != null)
					model.setFcastYrwk(fcastYrwk[i]);
				if (otrFcastQty[i] != null)
					model.setOtrFcastQty(otrFcastQty[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (d4FcastRto[i] != null)
					model.setD4FcastRto(d4FcastRto[i]);
				if (d2FcastRto[i] != null)
					model.setD2FcastRto(d2FcastRto[i]);
				if (cntrPkupSccCd[i] != null)
					model.setCntrPkupSccCd(cntrPkupSccCd[i]);
				if (d7FcastRto[i] != null)
					model.setD7FcastRto(d7FcastRto[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEqrCtrlObFcastRtoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EqrCtrlObFcastRtoVO[]
	 */
	public EqrCtrlObFcastRtoVO[] getEqrCtrlObFcastRtoVOs(){
		EqrCtrlObFcastRtoVO[] vos = (EqrCtrlObFcastRtoVO[])models.toArray(new EqrCtrlObFcastRtoVO[models.size()]);
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
		this.d2FcastQty = this.d2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrFcastRto = this.otrFcastRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqFcastRtoLvlCd = this.eqFcastRtoLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7FcastQty = this.d7FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgTtDys = this.avgTtDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5FcastQty = this.d5FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEccCd = this.polEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseDt = this.bseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5FcastRto = this.d5FcastRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4FcastQty = this.d4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastYrwk = this.fcastYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrFcastQty = this.otrFcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4FcastRto = this.d4FcastRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2FcastRto = this.d2FcastRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupSccCd = this.cntrPkupSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7FcastRto = this.d7FcastRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
