/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OccurrenceAnalysisByCargoVO.java
*@FileTitle : OccurrenceAnalysisByCargoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2009.12.28 박제성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo;

import java.lang.reflect.Field;
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
 * @author 박제성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OccurrenceAnalysisByCargoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OccurrenceAnalysisByCargoVO> models = new ArrayList<OccurrenceAnalysisByCargoVO>();
	
	/* Column Info */
	private String cargoAmt4 = null;
	/* Column Info */
	private String cargoCase3 = null;
	/* Column Info */
	private String cargoCase2 = null;
	/* Column Info */
	private String cargoCase1 = null;
	/* Column Info */
	private String cargoCase0 = null;
	/* Column Info */
	private String cargoCase4 = null;
	/* Column Info */
	private String cargoPctAmt4 = null;
	/* Column Info */
	private String cargoAmt2 = null;
	/* Column Info */
	private String cargoPctAmt3 = null;
	/* Column Info */
	private String cargoAmt3 = null;
	/* Column Info */
	private String cargoReportByCd = null;
	/* Column Info */
	private String cargoAmt0 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cargoAmt1 = null;
	/* Column Info */
	private String cargoPctAmt0 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cargoReportByNm = null;
	/* Column Info */
	private String cargoPctAmt1 = null;
	/* Column Info */
	private String cargoPctAmt2 = null;
	/* Column Info */
	private String cargoPctCase0 = null;
	/* Column Info */
	private String cargoPctCase1 = null;
	/* Column Info */
	private String cargoPctCase2 = null;
	/* Column Info */
	private String cargoPctCase3 = null;
	/* Column Info */
	private String cargoPctCase4 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OccurrenceAnalysisByCargoVO() {}

	public OccurrenceAnalysisByCargoVO(String ibflag, String pagerows, String cargoReportByCd, String cargoReportByNm, String cargoCase0, String cargoPctCase0, String cargoAmt0, String cargoPctAmt0, String cargoCase1, String cargoPctCase1, String cargoAmt1, String cargoPctAmt1, String cargoCase2, String cargoPctCase2, String cargoAmt2, String cargoPctAmt2, String cargoCase3, String cargoPctCase3, String cargoAmt3, String cargoPctAmt3, String cargoCase4, String cargoPctCase4, String cargoAmt4, String cargoPctAmt4) {
		this.cargoAmt4 = cargoAmt4;
		this.cargoCase3 = cargoCase3;
		this.cargoCase2 = cargoCase2;
		this.cargoCase1 = cargoCase1;
		this.cargoCase0 = cargoCase0;
		this.cargoCase4 = cargoCase4;
		this.cargoPctAmt4 = cargoPctAmt4;
		this.cargoAmt2 = cargoAmt2;
		this.cargoPctAmt3 = cargoPctAmt3;
		this.cargoAmt3 = cargoAmt3;
		this.cargoReportByCd = cargoReportByCd;
		this.cargoAmt0 = cargoAmt0;
		this.pagerows = pagerows;
		this.cargoAmt1 = cargoAmt1;
		this.cargoPctAmt0 = cargoPctAmt0;
		this.ibflag = ibflag;
		this.cargoReportByNm = cargoReportByNm;
		this.cargoPctAmt1 = cargoPctAmt1;
		this.cargoPctAmt2 = cargoPctAmt2;
		this.cargoPctCase0 = cargoPctCase0;
		this.cargoPctCase1 = cargoPctCase1;
		this.cargoPctCase2 = cargoPctCase2;
		this.cargoPctCase3 = cargoPctCase3;
		this.cargoPctCase4 = cargoPctCase4;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cargo_amt4", getCargoAmt4());
		this.hashColumns.put("cargo_case3", getCargoCase3());
		this.hashColumns.put("cargo_case2", getCargoCase2());
		this.hashColumns.put("cargo_case1", getCargoCase1());
		this.hashColumns.put("cargo_case0", getCargoCase0());
		this.hashColumns.put("cargo_case4", getCargoCase4());
		this.hashColumns.put("cargo_pct_amt4", getCargoPctAmt4());
		this.hashColumns.put("cargo_amt2", getCargoAmt2());
		this.hashColumns.put("cargo_pct_amt3", getCargoPctAmt3());
		this.hashColumns.put("cargo_amt3", getCargoAmt3());
		this.hashColumns.put("cargo_report_by_cd", getCargoReportByCd());
		this.hashColumns.put("cargo_amt0", getCargoAmt0());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cargo_amt1", getCargoAmt1());
		this.hashColumns.put("cargo_pct_amt0", getCargoPctAmt0());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cargo_report_by_nm", getCargoReportByNm());
		this.hashColumns.put("cargo_pct_amt1", getCargoPctAmt1());
		this.hashColumns.put("cargo_pct_amt2", getCargoPctAmt2());
		this.hashColumns.put("cargo_pct_case0", getCargoPctCase0());
		this.hashColumns.put("cargo_pct_case1", getCargoPctCase1());
		this.hashColumns.put("cargo_pct_case2", getCargoPctCase2());
		this.hashColumns.put("cargo_pct_case3", getCargoPctCase3());
		this.hashColumns.put("cargo_pct_case4", getCargoPctCase4());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cargo_amt4", "cargoAmt4");
		this.hashFields.put("cargo_case3", "cargoCase3");
		this.hashFields.put("cargo_case2", "cargoCase2");
		this.hashFields.put("cargo_case1", "cargoCase1");
		this.hashFields.put("cargo_case0", "cargoCase0");
		this.hashFields.put("cargo_case4", "cargoCase4");
		this.hashFields.put("cargo_pct_amt4", "cargoPctAmt4");
		this.hashFields.put("cargo_amt2", "cargoAmt2");
		this.hashFields.put("cargo_pct_amt3", "cargoPctAmt3");
		this.hashFields.put("cargo_amt3", "cargoAmt3");
		this.hashFields.put("cargo_report_by_cd", "cargoReportByCd");
		this.hashFields.put("cargo_amt0", "cargoAmt0");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cargo_amt1", "cargoAmt1");
		this.hashFields.put("cargo_pct_amt0", "cargoPctAmt0");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cargo_report_by_nm", "cargoReportByNm");
		this.hashFields.put("cargo_pct_amt1", "cargoPctAmt1");
		this.hashFields.put("cargo_pct_amt2", "cargoPctAmt2");
		this.hashFields.put("cargo_pct_case0", "cargoPctCase0");
		this.hashFields.put("cargo_pct_case1", "cargoPctCase1");
		this.hashFields.put("cargo_pct_case2", "cargoPctCase2");
		this.hashFields.put("cargo_pct_case3", "cargoPctCase3");
		this.hashFields.put("cargo_pct_case4", "cargoPctCase4");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cargoAmt4
	 */
	public String getCargoAmt4() {
		return this.cargoAmt4;
	}
	
	/**
	 * Column Info
	 * @return cargoCase3
	 */
	public String getCargoCase3() {
		return this.cargoCase3;
	}
	
	/**
	 * Column Info
	 * @return cargoCase2
	 */
	public String getCargoCase2() {
		return this.cargoCase2;
	}
	
	/**
	 * Column Info
	 * @return cargoCase1
	 */
	public String getCargoCase1() {
		return this.cargoCase1;
	}
	
	/**
	 * Column Info
	 * @return cargoCase0
	 */
	public String getCargoCase0() {
		return this.cargoCase0;
	}
	
	/**
	 * Column Info
	 * @return cargoCase4
	 */
	public String getCargoCase4() {
		return this.cargoCase4;
	}
	
	/**
	 * Column Info
	 * @return cargoPctAmt4
	 */
	public String getCargoPctAmt4() {
		return this.cargoPctAmt4;
	}
	
	/**
	 * Column Info
	 * @return cargoAmt2
	 */
	public String getCargoAmt2() {
		return this.cargoAmt2;
	}
	
	/**
	 * Column Info
	 * @return cargoPctAmt3
	 */
	public String getCargoPctAmt3() {
		return this.cargoPctAmt3;
	}
	
	/**
	 * Column Info
	 * @return cargoAmt3
	 */
	public String getCargoAmt3() {
		return this.cargoAmt3;
	}
	
	/**
	 * Column Info
	 * @return cargoReportByCd
	 */
	public String getCargoReportByCd() {
		return this.cargoReportByCd;
	}
	
	/**
	 * Column Info
	 * @return cargoAmt0
	 */
	public String getCargoAmt0() {
		return this.cargoAmt0;
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
	 * @return cargoAmt1
	 */
	public String getCargoAmt1() {
		return this.cargoAmt1;
	}
	
	/**
	 * Column Info
	 * @return cargoPctAmt0
	 */
	public String getCargoPctAmt0() {
		return this.cargoPctAmt0;
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
	 * @return cargoReportByNm
	 */
	public String getCargoReportByNm() {
		return this.cargoReportByNm;
	}
	
	/**
	 * Column Info
	 * @return cargoPctAmt1
	 */
	public String getCargoPctAmt1() {
		return this.cargoPctAmt1;
	}
	
	/**
	 * Column Info
	 * @return cargoPctAmt2
	 */
	public String getCargoPctAmt2() {
		return this.cargoPctAmt2;
	}
	
	/**
	 * Column Info
	 * @return cargoPctCase0
	 */
	public String getCargoPctCase0() {
		return this.cargoPctCase0;
	}
	
	/**
	 * Column Info
	 * @return cargoPctCase1
	 */
	public String getCargoPctCase1() {
		return this.cargoPctCase1;
	}
	
	/**
	 * Column Info
	 * @return cargoPctCase2
	 */
	public String getCargoPctCase2() {
		return this.cargoPctCase2;
	}
	
	/**
	 * Column Info
	 * @return cargoPctCase3
	 */
	public String getCargoPctCase3() {
		return this.cargoPctCase3;
	}
	
	/**
	 * Column Info
	 * @return cargoPctCase4
	 */
	public String getCargoPctCase4() {
		return this.cargoPctCase4;
	}
	

	/**
	 * Column Info
	 * @param cargoAmt4
	 */
	public void setCargoAmt4(String cargoAmt4) {
		this.cargoAmt4 = cargoAmt4;
	}
	
	/**
	 * Column Info
	 * @param cargoCase3
	 */
	public void setCargoCase3(String cargoCase3) {
		this.cargoCase3 = cargoCase3;
	}
	
	/**
	 * Column Info
	 * @param cargoCase2
	 */
	public void setCargoCase2(String cargoCase2) {
		this.cargoCase2 = cargoCase2;
	}
	
	/**
	 * Column Info
	 * @param cargoCase1
	 */
	public void setCargoCase1(String cargoCase1) {
		this.cargoCase1 = cargoCase1;
	}
	
	/**
	 * Column Info
	 * @param cargoCase0
	 */
	public void setCargoCase0(String cargoCase0) {
		this.cargoCase0 = cargoCase0;
	}
	
	/**
	 * Column Info
	 * @param cargoCase4
	 */
	public void setCargoCase4(String cargoCase4) {
		this.cargoCase4 = cargoCase4;
	}
	
	/**
	 * Column Info
	 * @param cargoPctAmt4
	 */
	public void setCargoPctAmt4(String cargoPctAmt4) {
		this.cargoPctAmt4 = cargoPctAmt4;
	}
	
	/**
	 * Column Info
	 * @param cargoAmt2
	 */
	public void setCargoAmt2(String cargoAmt2) {
		this.cargoAmt2 = cargoAmt2;
	}
	
	/**
	 * Column Info
	 * @param cargoPctAmt3
	 */
	public void setCargoPctAmt3(String cargoPctAmt3) {
		this.cargoPctAmt3 = cargoPctAmt3;
	}
	
	/**
	 * Column Info
	 * @param cargoAmt3
	 */
	public void setCargoAmt3(String cargoAmt3) {
		this.cargoAmt3 = cargoAmt3;
	}
	
	/**
	 * Column Info
	 * @param cargoReportByCd
	 */
	public void setCargoReportByCd(String cargoReportByCd) {
		this.cargoReportByCd = cargoReportByCd;
	}
	
	/**
	 * Column Info
	 * @param cargoAmt0
	 */
	public void setCargoAmt0(String cargoAmt0) {
		this.cargoAmt0 = cargoAmt0;
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
	 * @param cargoAmt1
	 */
	public void setCargoAmt1(String cargoAmt1) {
		this.cargoAmt1 = cargoAmt1;
	}
	
	/**
	 * Column Info
	 * @param cargoPctAmt0
	 */
	public void setCargoPctAmt0(String cargoPctAmt0) {
		this.cargoPctAmt0 = cargoPctAmt0;
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
	 * @param cargoReportByNm
	 */
	public void setCargoReportByNm(String cargoReportByNm) {
		this.cargoReportByNm = cargoReportByNm;
	}
	
	/**
	 * Column Info
	 * @param cargoPctAmt1
	 */
	public void setCargoPctAmt1(String cargoPctAmt1) {
		this.cargoPctAmt1 = cargoPctAmt1;
	}
	
	/**
	 * Column Info
	 * @param cargoPctAmt2
	 */
	public void setCargoPctAmt2(String cargoPctAmt2) {
		this.cargoPctAmt2 = cargoPctAmt2;
	}
	
	/**
	 * Column Info
	 * @param cargoPctCase0
	 */
	public void setCargoPctCase0(String cargoPctCase0) {
		this.cargoPctCase0 = cargoPctCase0;
	}
	
	/**
	 * Column Info
	 * @param cargoPctCase1
	 */
	public void setCargoPctCase1(String cargoPctCase1) {
		this.cargoPctCase1 = cargoPctCase1;
	}
	
	/**
	 * Column Info
	 * @param cargoPctCase2
	 */
	public void setCargoPctCase2(String cargoPctCase2) {
		this.cargoPctCase2 = cargoPctCase2;
	}
	
	/**
	 * Column Info
	 * @param cargoPctCase3
	 */
	public void setCargoPctCase3(String cargoPctCase3) {
		this.cargoPctCase3 = cargoPctCase3;
	}
	
	/**
	 * Column Info
	 * @param cargoPctCase4
	 */
	public void setCargoPctCase4(String cargoPctCase4) {
		this.cargoPctCase4 = cargoPctCase4;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCargoAmt4(JSPUtil.getParameter(request, "cargo_amt4", ""));
		setCargoCase3(JSPUtil.getParameter(request, "cargo_case3", ""));
		setCargoCase2(JSPUtil.getParameter(request, "cargo_case2", ""));
		setCargoCase1(JSPUtil.getParameter(request, "cargo_case1", ""));
		setCargoCase0(JSPUtil.getParameter(request, "cargo_case0", ""));
		setCargoCase4(JSPUtil.getParameter(request, "cargo_case4", ""));
		setCargoPctAmt4(JSPUtil.getParameter(request, "cargo_pct_amt4", ""));
		setCargoAmt2(JSPUtil.getParameter(request, "cargo_amt2", ""));
		setCargoPctAmt3(JSPUtil.getParameter(request, "cargo_pct_amt3", ""));
		setCargoAmt3(JSPUtil.getParameter(request, "cargo_amt3", ""));
		setCargoReportByCd(JSPUtil.getParameter(request, "cargo_report_by_cd", ""));
		setCargoAmt0(JSPUtil.getParameter(request, "cargo_amt0", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCargoAmt1(JSPUtil.getParameter(request, "cargo_amt1", ""));
		setCargoPctAmt0(JSPUtil.getParameter(request, "cargo_pct_amt0", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCargoReportByNm(JSPUtil.getParameter(request, "cargo_report_by_nm", ""));
		setCargoPctAmt1(JSPUtil.getParameter(request, "cargo_pct_amt1", ""));
		setCargoPctAmt2(JSPUtil.getParameter(request, "cargo_pct_amt2", ""));
		setCargoPctCase0(JSPUtil.getParameter(request, "cargo_pct_case0", ""));
		setCargoPctCase1(JSPUtil.getParameter(request, "cargo_pct_case1", ""));
		setCargoPctCase2(JSPUtil.getParameter(request, "cargo_pct_case2", ""));
		setCargoPctCase3(JSPUtil.getParameter(request, "cargo_pct_case3", ""));
		setCargoPctCase4(JSPUtil.getParameter(request, "cargo_pct_case4", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OccurrenceAnalysisByCargoVO[]
	 */
	public OccurrenceAnalysisByCargoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OccurrenceAnalysisByCargoVO[]
	 */
	public OccurrenceAnalysisByCargoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OccurrenceAnalysisByCargoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cargoAmt4 = (JSPUtil.getParameter(request, prefix	+ "cargo_amt4", length));
			String[] cargoCase3 = (JSPUtil.getParameter(request, prefix	+ "cargo_case3", length));
			String[] cargoCase2 = (JSPUtil.getParameter(request, prefix	+ "cargo_case2", length));
			String[] cargoCase1 = (JSPUtil.getParameter(request, prefix	+ "cargo_case1", length));
			String[] cargoCase0 = (JSPUtil.getParameter(request, prefix	+ "cargo_case0", length));
			String[] cargoCase4 = (JSPUtil.getParameter(request, prefix	+ "cargo_case4", length));
			String[] cargoPctAmt4 = (JSPUtil.getParameter(request, prefix	+ "cargo_pct_amt4", length));
			String[] cargoAmt2 = (JSPUtil.getParameter(request, prefix	+ "cargo_amt2", length));
			String[] cargoPctAmt3 = (JSPUtil.getParameter(request, prefix	+ "cargo_pct_amt3", length));
			String[] cargoAmt3 = (JSPUtil.getParameter(request, prefix	+ "cargo_amt3", length));
			String[] cargoReportByCd = (JSPUtil.getParameter(request, prefix	+ "cargo_report_by_cd", length));
			String[] cargoAmt0 = (JSPUtil.getParameter(request, prefix	+ "cargo_amt0", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cargoAmt1 = (JSPUtil.getParameter(request, prefix	+ "cargo_amt1", length));
			String[] cargoPctAmt0 = (JSPUtil.getParameter(request, prefix	+ "cargo_pct_amt0", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cargoReportByNm = (JSPUtil.getParameter(request, prefix	+ "cargo_report_by_nm", length));
			String[] cargoPctAmt1 = (JSPUtil.getParameter(request, prefix	+ "cargo_pct_amt1", length));
			String[] cargoPctAmt2 = (JSPUtil.getParameter(request, prefix	+ "cargo_pct_amt2", length));
			String[] cargoPctCase0 = (JSPUtil.getParameter(request, prefix	+ "cargo_pct_case0", length));
			String[] cargoPctCase1 = (JSPUtil.getParameter(request, prefix	+ "cargo_pct_case1", length));
			String[] cargoPctCase2 = (JSPUtil.getParameter(request, prefix	+ "cargo_pct_case2", length));
			String[] cargoPctCase3 = (JSPUtil.getParameter(request, prefix	+ "cargo_pct_case3", length));
			String[] cargoPctCase4 = (JSPUtil.getParameter(request, prefix	+ "cargo_pct_case4", length));
			
			for (int i = 0; i < length; i++) {
				model = new OccurrenceAnalysisByCargoVO();
				if (cargoAmt4[i] != null)
					model.setCargoAmt4(cargoAmt4[i]);
				if (cargoCase3[i] != null)
					model.setCargoCase3(cargoCase3[i]);
				if (cargoCase2[i] != null)
					model.setCargoCase2(cargoCase2[i]);
				if (cargoCase1[i] != null)
					model.setCargoCase1(cargoCase1[i]);
				if (cargoCase0[i] != null)
					model.setCargoCase0(cargoCase0[i]);
				if (cargoCase4[i] != null)
					model.setCargoCase4(cargoCase4[i]);
				if (cargoPctAmt4[i] != null)
					model.setCargoPctAmt4(cargoPctAmt4[i]);
				if (cargoAmt2[i] != null)
					model.setCargoAmt2(cargoAmt2[i]);
				if (cargoPctAmt3[i] != null)
					model.setCargoPctAmt3(cargoPctAmt3[i]);
				if (cargoAmt3[i] != null)
					model.setCargoAmt3(cargoAmt3[i]);
				if (cargoReportByCd[i] != null)
					model.setCargoReportByCd(cargoReportByCd[i]);
				if (cargoAmt0[i] != null)
					model.setCargoAmt0(cargoAmt0[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cargoAmt1[i] != null)
					model.setCargoAmt1(cargoAmt1[i]);
				if (cargoPctAmt0[i] != null)
					model.setCargoPctAmt0(cargoPctAmt0[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cargoReportByNm[i] != null)
					model.setCargoReportByNm(cargoReportByNm[i]);
				if (cargoPctAmt1[i] != null)
					model.setCargoPctAmt1(cargoPctAmt1[i]);
				if (cargoPctAmt2[i] != null)
					model.setCargoPctAmt2(cargoPctAmt2[i]);
				if (cargoPctCase0[i] != null)
					model.setCargoPctCase0(cargoPctCase0[i]);
				if (cargoPctCase1[i] != null)
					model.setCargoPctCase1(cargoPctCase1[i]);
				if (cargoPctCase2[i] != null)
					model.setCargoPctCase2(cargoPctCase2[i]);
				if (cargoPctCase3[i] != null)
					model.setCargoPctCase3(cargoPctCase3[i]);
				if (cargoPctCase4[i] != null)
					model.setCargoPctCase4(cargoPctCase4[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOccurrenceAnalysisByCargoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OccurrenceAnalysisByCargoVO[]
	 */
	public OccurrenceAnalysisByCargoVO[] getOccurrenceAnalysisByCargoVOs(){
		OccurrenceAnalysisByCargoVO[] vos = (OccurrenceAnalysisByCargoVO[])models.toArray(new OccurrenceAnalysisByCargoVO[models.size()]);
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
		this.cargoAmt4 = this.cargoAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoCase3 = this.cargoCase3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoCase2 = this.cargoCase2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoCase1 = this.cargoCase1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoCase0 = this.cargoCase0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoCase4 = this.cargoCase4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoPctAmt4 = this.cargoPctAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoAmt2 = this.cargoAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoPctAmt3 = this.cargoPctAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoAmt3 = this.cargoAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoReportByCd = this.cargoReportByCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoAmt0 = this.cargoAmt0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoAmt1 = this.cargoAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoPctAmt0 = this.cargoPctAmt0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoReportByNm = this.cargoReportByNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoPctAmt1 = this.cargoPctAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoPctAmt2 = this.cargoPctAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoPctCase0 = this.cargoPctCase0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoPctCase1 = this.cargoPctCase1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoPctCase2 = this.cargoPctCase2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoPctCase3 = this.cargoPctCase3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoPctCase4 = this.cargoPctCase4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
