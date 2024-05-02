/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProcurementDetailVO.java
*@FileTitle : ProcurementDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.09.17 민정호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo;

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
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ProcurementDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ProcurementDetailVO> models = new ArrayList<ProcurementDetailVO>();
	
	/* Column Info */
	private String inputPlnYr = null;
	/* Column Info */
	private String f2Qty = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String inputBseYrmon = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseYrmon = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String plnYr = null;
	/* Column Info */
	private String d2Qty = null;
	/* Column Info */
	private String o4Qty = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String hBseYrmon = null;
	/* Column Info */
	private String cntrProcuPlnCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String d7Qty = null;
	/* Column Info */
	private String r2Qty = null;
	/* Column Info */
	private String r4Qty = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String inputSw = null;
	/* Column Info */
	private String o2Qty = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String d4Qty = null;
	/* Column Info */
	private String r5Qty = null;
	/* Column Info */
	private String d5Qty = null;
	/* Column Info */
	private String f4Qty = null;
	/* Column Info */	
	private String gTotal = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ProcurementDetailVO() {}

	public ProcurementDetailVO(String ibflag, String pagerows, String plnYr, String cntrProcuPlnCd, String bseYrmon, String d2Qty, String d4Qty, String d5Qty, String d7Qty, String r2Qty, String r4Qty, String r5Qty, String o2Qty, String o4Qty, String f2Qty, String f4Qty, String diffRmk, String creUsrId, String creDt, String updUsrId, String updDt, String inputPlnYr, String inputBseYrmon, String inputSw, String hBseYrmon, String gTotal) {
		this.inputPlnYr = inputPlnYr;
		this.f2Qty = f2Qty;
		this.creDt = creDt;
		this.inputBseYrmon = inputBseYrmon;
		this.pagerows = pagerows;
		this.bseYrmon = bseYrmon;
		this.ibflag = ibflag;
		this.plnYr = plnYr;
		this.d2Qty = d2Qty;
		this.o4Qty = o4Qty;
		this.updUsrId = updUsrId;
		this.hBseYrmon = hBseYrmon;
		this.cntrProcuPlnCd = cntrProcuPlnCd;
		this.updDt = updDt;
		this.d7Qty = d7Qty;
		this.r2Qty = r2Qty;
		this.r4Qty = r4Qty;
		this.creUsrId = creUsrId;
		this.inputSw = inputSw;
		this.o2Qty = o2Qty;
		this.diffRmk = diffRmk;
		this.d4Qty = d4Qty;
		this.r5Qty = r5Qty;
		this.d5Qty = d5Qty;
		this.f4Qty = f4Qty;
		this.gTotal = gTotal;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("input_pln_yr", getInputPlnYr());
		this.hashColumns.put("f2_qty", getF2Qty());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("input_bse_yrmon", getInputBseYrmon());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_yrmon", getBseYrmon());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pln_yr", getPlnYr());
		this.hashColumns.put("d2_qty", getD2Qty());
		this.hashColumns.put("o4_qty", getO4Qty());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("h_bse_yrmon", getHBseYrmon());
		this.hashColumns.put("cntr_procu_pln_cd", getCntrProcuPlnCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("d7_qty", getD7Qty());
		this.hashColumns.put("r2_qty", getR2Qty());
		this.hashColumns.put("r4_qty", getR4Qty());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("input_sw", getInputSw());
		this.hashColumns.put("o2_qty", getO2Qty());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("d4_qty", getD4Qty());
		this.hashColumns.put("r5_qty", getR5Qty());
		this.hashColumns.put("d5_qty", getD5Qty());
		this.hashColumns.put("f4_qty", getF4Qty());
		this.hashColumns.put("g_total", getGTotal());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("input_pln_yr", "inputPlnYr");
		this.hashFields.put("f2_qty", "f2Qty");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("input_bse_yrmon", "inputBseYrmon");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_yrmon", "bseYrmon");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pln_yr", "plnYr");
		this.hashFields.put("d2_qty", "d2Qty");
		this.hashFields.put("o4_qty", "o4Qty");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("h_bse_yrmon", "hBseYrmon");
		this.hashFields.put("cntr_procu_pln_cd", "cntrProcuPlnCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("d7_qty", "d7Qty");
		this.hashFields.put("r2_qty", "r2Qty");
		this.hashFields.put("r4_qty", "r4Qty");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("input_sw", "inputSw");
		this.hashFields.put("o2_qty", "o2Qty");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("d4_qty", "d4Qty");
		this.hashFields.put("r5_qty", "r5Qty");
		this.hashFields.put("d5_qty", "d5Qty");
		this.hashFields.put("f4_qty", "f4Qty");
		this.hashFields.put("g_total", "gTotal");		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inputPlnYr
	 */
	public String getInputPlnYr() {
		return this.inputPlnYr;
	}
	
	/**
	 * Column Info
	 * @return f2Qty
	 */
	public String getF2Qty() {
		return this.f2Qty;
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
	 * @return inputBseYrmon
	 */
	public String getInputBseYrmon() {
		return this.inputBseYrmon;
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
	 * @return bseYrmon
	 */
	public String getBseYrmon() {
		return this.bseYrmon;
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
	 * @return plnYr
	 */
	public String getPlnYr() {
		return this.plnYr;
	}
	
	/**
	 * Column Info
	 * @return d2Qty
	 */
	public String getD2Qty() {
		return this.d2Qty;
	}
	
	/**
	 * Column Info
	 * @return o4Qty
	 */
	public String getO4Qty() {
		return this.o4Qty;
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
	 * @return hBseYrmon
	 */
	public String getHBseYrmon() {
		return this.hBseYrmon;
	}
	
	/**
	 * Column Info
	 * @return cntrProcuPlnCd
	 */
	public String getCntrProcuPlnCd() {
		return this.cntrProcuPlnCd;
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
	 * @return d7Qty
	 */
	public String getD7Qty() {
		return this.d7Qty;
	}
	
	/**
	 * Column Info
	 * @return r2Qty
	 */
	public String getR2Qty() {
		return this.r2Qty;
	}
	
	/**
	 * Column Info
	 * @return r4Qty
	 */
	public String getR4Qty() {
		return this.r4Qty;
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
	 * @return inputSw
	 */
	public String getInputSw() {
		return this.inputSw;
	}
	
	/**
	 * Column Info
	 * @return o2Qty
	 */
	public String getO2Qty() {
		return this.o2Qty;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return d4Qty
	 */
	public String getD4Qty() {
		return this.d4Qty;
	}
	
	/**
	 * Column Info
	 * @return r5Qty
	 */
	public String getR5Qty() {
		return this.r5Qty;
	}
	
	/**
	 * Column Info
	 * @return d5Qty
	 */
	public String getD5Qty() {
		return this.d5Qty;
	}
	
	/**
	 * Column Info
	 * @return f4Qty
	 */
	public String getF4Qty() {
		return this.f4Qty;
	}
	
	/**
	 * Column Info
	 * @return gTotal
	 */
	public String getGTotal() {
		return this.gTotal;
	}	

	/**
	 * Column Info
	 * @param inputPlnYr
	 */
	public void setInputPlnYr(String inputPlnYr) {
		this.inputPlnYr = inputPlnYr;
	}
	
	/**
	 * Column Info
	 * @param f2Qty
	 */
	public void setF2Qty(String f2Qty) {
		this.f2Qty = f2Qty;
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
	 * @param inputBseYrmon
	 */
	public void setInputBseYrmon(String inputBseYrmon) {
		this.inputBseYrmon = inputBseYrmon;
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
	 * @param bseYrmon
	 */
	public void setBseYrmon(String bseYrmon) {
		this.bseYrmon = bseYrmon;
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
	 * @param plnYr
	 */
	public void setPlnYr(String plnYr) {
		this.plnYr = plnYr;
	}
	
	/**
	 * Column Info
	 * @param d2Qty
	 */
	public void setD2Qty(String d2Qty) {
		this.d2Qty = d2Qty;
	}
	
	/**
	 * Column Info
	 * @param o4Qty
	 */
	public void setO4Qty(String o4Qty) {
		this.o4Qty = o4Qty;
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
	 * @param hBseYrmon
	 */
	public void setHBseYrmon(String hBseYrmon) {
		this.hBseYrmon = hBseYrmon;
	}
	
	/**
	 * Column Info
	 * @param cntrProcuPlnCd
	 */
	public void setCntrProcuPlnCd(String cntrProcuPlnCd) {
		this.cntrProcuPlnCd = cntrProcuPlnCd;
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
	 * @param d7Qty
	 */
	public void setD7Qty(String d7Qty) {
		this.d7Qty = d7Qty;
	}
	
	/**
	 * Column Info
	 * @param r2Qty
	 */
	public void setR2Qty(String r2Qty) {
		this.r2Qty = r2Qty;
	}
	
	/**
	 * Column Info
	 * @param r4Qty
	 */
	public void setR4Qty(String r4Qty) {
		this.r4Qty = r4Qty;
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
	 * @param inputSw
	 */
	public void setInputSw(String inputSw) {
		this.inputSw = inputSw;
	}
	
	/**
	 * Column Info
	 * @param o2Qty
	 */
	public void setO2Qty(String o2Qty) {
		this.o2Qty = o2Qty;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param d4Qty
	 */
	public void setD4Qty(String d4Qty) {
		this.d4Qty = d4Qty;
	}
	
	/**
	 * Column Info
	 * @param r5Qty
	 */
	public void setR5Qty(String r5Qty) {
		this.r5Qty = r5Qty;
	}
	
	/**
	 * Column Info
	 * @param d5Qty
	 */
	public void setD5Qty(String d5Qty) {
		this.d5Qty = d5Qty;
	}
	
	/**
	 * Column Info
	 * @param f4Qty
	 */
	public void setF4Qty(String f4Qty) {
		this.f4Qty = f4Qty;
	}
	
	/**
	 * Column Info
	 * @param gTotal
	 */
	public void setGTotal(String gTotal) {
		this.gTotal = gTotal;
	}	
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInputPlnYr(JSPUtil.getParameter(request, "input_pln_yr", ""));
		setF2Qty(JSPUtil.getParameter(request, "f2_qty", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setInputBseYrmon(JSPUtil.getParameter(request, "input_bse_yrmon", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBseYrmon(JSPUtil.getParameter(request, "bse_yrmon", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPlnYr(JSPUtil.getParameter(request, "pln_yr", ""));
		setD2Qty(JSPUtil.getParameter(request, "d2_qty", ""));
		setO4Qty(JSPUtil.getParameter(request, "o4_qty", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setHBseYrmon(JSPUtil.getParameter(request, "h_bse_yrmon", ""));
		setCntrProcuPlnCd(JSPUtil.getParameter(request, "cntr_procu_pln_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setD7Qty(JSPUtil.getParameter(request, "d7_qty", ""));
		setR2Qty(JSPUtil.getParameter(request, "r2_qty", ""));
		setR4Qty(JSPUtil.getParameter(request, "r4_qty", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setInputSw(JSPUtil.getParameter(request, "input_sw", ""));
		setO2Qty(JSPUtil.getParameter(request, "o2_qty", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setD4Qty(JSPUtil.getParameter(request, "d4_qty", ""));
		setR5Qty(JSPUtil.getParameter(request, "r5_qty", ""));
		setD5Qty(JSPUtil.getParameter(request, "d5_qty", ""));
		setF4Qty(JSPUtil.getParameter(request, "f4_qty", ""));
		setGTotal(JSPUtil.getParameter(request, "g_total", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ProcurementDetailVO[]
	 */
	public ProcurementDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ProcurementDetailVO[]
	 */
	public ProcurementDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ProcurementDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inputPlnYr = (JSPUtil.getParameter(request, prefix	+ "input_pln_yr", length));
			String[] f2Qty = (JSPUtil.getParameter(request, prefix	+ "f2_qty", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] inputBseYrmon = (JSPUtil.getParameter(request, prefix	+ "input_bse_yrmon", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseYrmon = (JSPUtil.getParameter(request, prefix	+ "bse_yrmon", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] plnYr = (JSPUtil.getParameter(request, prefix	+ "pln_yr", length));
			String[] d2Qty = (JSPUtil.getParameter(request, prefix	+ "d2_qty", length));
			String[] o4Qty = (JSPUtil.getParameter(request, prefix	+ "o4_qty", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] hBseYrmon = (JSPUtil.getParameter(request, prefix	+ "h_bse_yrmon", length));
			String[] cntrProcuPlnCd = (JSPUtil.getParameter(request, prefix	+ "cntr_procu_pln_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] d7Qty = (JSPUtil.getParameter(request, prefix	+ "d7_qty", length));
			String[] r2Qty = (JSPUtil.getParameter(request, prefix	+ "r2_qty", length));
			String[] r4Qty = (JSPUtil.getParameter(request, prefix	+ "r4_qty", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] inputSw = (JSPUtil.getParameter(request, prefix	+ "input_sw", length));
			String[] o2Qty = (JSPUtil.getParameter(request, prefix	+ "o2_qty", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] d4Qty = (JSPUtil.getParameter(request, prefix	+ "d4_qty", length));
			String[] r5Qty = (JSPUtil.getParameter(request, prefix	+ "r5_qty", length));
			String[] d5Qty = (JSPUtil.getParameter(request, prefix	+ "d5_qty", length));
			String[] f4Qty = (JSPUtil.getParameter(request, prefix	+ "f4_qty", length));
			String[] gTotal = (JSPUtil.getParameter(request, prefix	+ "g_total", length));			
			
			for (int i = 0; i < length; i++) {
				model = new ProcurementDetailVO();
				if (inputPlnYr[i] != null)
					model.setInputPlnYr(inputPlnYr[i]);
				if (f2Qty[i] != null)
					model.setF2Qty(f2Qty[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (inputBseYrmon[i] != null)
					model.setInputBseYrmon(inputBseYrmon[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseYrmon[i] != null)
					model.setBseYrmon(bseYrmon[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (plnYr[i] != null)
					model.setPlnYr(plnYr[i]);
				if (d2Qty[i] != null)
					model.setD2Qty(d2Qty[i]);
				if (o4Qty[i] != null)
					model.setO4Qty(o4Qty[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (hBseYrmon[i] != null)
					model.setHBseYrmon(hBseYrmon[i]);
				if (cntrProcuPlnCd[i] != null)
					model.setCntrProcuPlnCd(cntrProcuPlnCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (d7Qty[i] != null)
					model.setD7Qty(d7Qty[i]);
				if (r2Qty[i] != null)
					model.setR2Qty(r2Qty[i]);
				if (r4Qty[i] != null)
					model.setR4Qty(r4Qty[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (inputSw[i] != null)
					model.setInputSw(inputSw[i]);
				if (o2Qty[i] != null)
					model.setO2Qty(o2Qty[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (d4Qty[i] != null)
					model.setD4Qty(d4Qty[i]);
				if (r5Qty[i] != null)
					model.setR5Qty(r5Qty[i]);
				if (d5Qty[i] != null)
					model.setD5Qty(d5Qty[i]);
				if (f4Qty[i] != null)
					model.setF4Qty(f4Qty[i]);
				if (gTotal[i] != null)
					model.setGTotal(gTotal[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getProcurementDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ProcurementDetailVO[]
	 */
	public ProcurementDetailVO[] getProcurementDetailVOs(){
		ProcurementDetailVO[] vos = (ProcurementDetailVO[])models.toArray(new ProcurementDetailVO[models.size()]);
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
		this.inputPlnYr = this.inputPlnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2Qty = this.f2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputBseYrmon = this.inputBseYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYrmon = this.bseYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYr = this.plnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2Qty = this.d2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4Qty = this.o4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hBseYrmon = this.hBseYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrProcuPlnCd = this.cntrProcuPlnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7Qty = this.d7Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2Qty = this.r2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r4Qty = this.r4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputSw = this.inputSw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2Qty = this.o2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4Qty = this.d4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5Qty = this.r5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5Qty = this.d5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4Qty = this.f4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gTotal = this.gTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}
