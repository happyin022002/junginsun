/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DailyBatchConditionVO.java
*@FileTitle : DailyBatchConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.11.23 남궁진호 
* 1.0 Creation
* 
* 2016.01.29 김성욱 [CHM-201539410] BSA System 개선의 건 / 동일 날짜에 서로 다른 항차 BSA 입력 가능 실현
=========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo;

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

public class MultiSupplySwapVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MultiSupplySwapVvdVO> models = new ArrayList<MultiSupplySwapVvdVO>();
	
	/* Column Info */
	private String yyww = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String voyNo = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String carCd = null;
	/* Column Info */
	private String capa = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String mnlFlg = null;
	
	/* Column Info */
	private String headerName = null;
	/* Column Info */
	private String headerValue = null;
	/* Column Info */
	private String dValue = null;

	/* Column Info */
	private String fnlHjsBsaCapa = null;
	/* Column Info */
	private String fnlHjsBsaCapaSc = null;
	/* Column Info */
	private String hjsBsaBfrSubCapa = null;
	/* Column Info */
	private String hjsBsaRto = null;
	/* Column Info */
	private String chtrBasRto = null;
	/* Column Info */
	private String chtOut = null;
	/* Column Info */
	private String year = null;
	/* Column Info */
	private String fmWeek = null;
	/* Column Info */
	private String toWeek = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String tabIndex = null;
	
//	private String hName = null;//수정한 헤더명
	/* Column Info */
//	private String hValue = null;//수정한 헤더의 값

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MultiSupplySwapVvdVO() {}

	public MultiSupplySwapVvdVO(String yyww, String trdCd, String subTrdCd, String slanCd, String laneCd, String type, String vslCd, String voyNo, String dirCd, String oprCd, String carCd, String capa, String ibflag, String headerName, String headerValue, String mnlFlg
			, String fnlHjsBsaCapa, String hjsBsaBfrSubCapa, String hjsBsaRto, String chtrBasRto, String chtOut, String year, String fmWeek, String toWeek, String iocCd , String tabIndex, String dValue, String fnlHjsBsaCapaSc) {
		this.yyww = yyww;
		this.trdCd = trdCd;
		this.subTrdCd = subTrdCd;
		this.slanCd = slanCd;
		this.laneCd = laneCd;
		this.type = type;
		this.vslCd = vslCd;
		this.voyNo = voyNo;
		this.dirCd = dirCd;
		this.oprCd = oprCd;
		this.carCd = carCd;
		this.capa = capa;
		this.ibflag = ibflag;
		this.mnlFlg = mnlFlg;
		this.headerName = headerName;
		this.headerValue = headerValue;
		this.fnlHjsBsaCapa = fnlHjsBsaCapa;
		this.hjsBsaBfrSubCapa = hjsBsaBfrSubCapa;
		this.hjsBsaRto = hjsBsaRto;
		this.chtrBasRto = chtrBasRto;
		this.chtOut = chtOut;
		this.year = year;
		this.fmWeek = fmWeek;
		this.toWeek = toWeek;
		this.iocCd = iocCd;
		this.tabIndex = tabIndex;
		this.dValue = dValue;
		this.fnlHjsBsaCapaSc = fnlHjsBsaCapaSc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("yyww", getYyww());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("voy_no", getVoyNo());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("car_cd", getCarCd());
		this.hashColumns.put("capa", getCapa());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnl_flg", getMnlFlg());
		this.hashColumns.put("header_name", getHeaderName());
		this.hashColumns.put("header_value", getHeaderValue());
		this.hashColumns.put("fnl_hjs_bsa_capa", getFnlHjsBsaCapa());
		this.hashColumns.put("hjs_bsa_bfr_sub_capa", getHjsBsaBfrSubCapa());
		this.hashColumns.put("hjs_bsa_rto", getHjsBsaRto());
		this.hashColumns.put("chtr_bas_rto", getChtrBasRto());
		this.hashColumns.put("cht_out", getChtOut());
		this.hashColumns.put("year", getYear());
		this.hashColumns.put("fm_week", getFmWeek());
		this.hashColumns.put("to_week", getToWeek());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("tab_index", getTabIndex());
		this.hashColumns.put("d_value", getDValue());
		this.hashColumns.put("fnl_hjs_bsa_capa_sc", getFnlHjsBsaCapaSc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("yyww", "yyww");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("type", "type");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("voy_no", "voyNo");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("car_cd", "carCd");
		this.hashFields.put("capa", "capa");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnl_flg", "mnlFlg");
		this.hashFields.put("header_name", "headerName");
		this.hashFields.put("header_value", "headerValue");
		this.hashFields.put("fnl_hjs_bsa_capa", "fnlHjsBsaCapa");
		this.hashFields.put("hjs_bsa_bfr_sub_capa", "hjsBsaBfrSubCapa");
		this.hashFields.put("hjs_bsa_rto", "hjsBsaRto");
		this.hashFields.put("chtr_bas_rto", "chtrBasRto");
		this.hashFields.put("cht_out", "chtOut");
		this.hashFields.put("year", "year");
		this.hashFields.put("fm_week", "fmWeek");
		this.hashFields.put("to_week", "toWeek");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("tab_index", "tabIndex");
		this.hashFields.put("d_value", "dValue");
		this.hashFields.put("fnl_hjs_bsa_capa_sc", "fnlHjsBsaCapaSc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return yyww
	 */
	public String getYyww() {
		return this.yyww;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}

	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
	}
	
	/**
	 * Column Info
	 * @return type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Column Info
	 * @return pSkdVoyNo
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Page Number
	 * @return voyNo
	 */
	public String getVoyNo() {
		return this.voyNo;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
	}
	
	/**
	 * Column Info
	 * @return carCd
	 */
	public String getCarCd() {
		return this.carCd;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return capa
	 */
	public String getCapa() {
		return this.capa;
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
	 * @return mnlFlg
	 */
	public String getMnlFlg() {
		return this.mnlFlg;
	}

	/**
	 * Column Info
	 * @return headerName
	 */
	public String getHeaderName() {
		return this.headerName;
	}

	/**
	 * Column Info
	 * @return headerValue
	 */
	public String getHeaderValue() {
		return this.headerValue;
	}

	/**
	 * Column Info
	 * @return fnlHjsBsaCapa
	 */
	public String getFnlHjsBsaCapa() {
		return this.fnlHjsBsaCapa;
	}

	/**
	 * Column Info
	 * @return hjsBsaBfrSubCapa
	 */
	public String getHjsBsaBfrSubCapa() {
		return this.hjsBsaBfrSubCapa;
	}

	/**
	 * Column Info
	 * @return hjsBsaRto
	 */
	public String getHjsBsaRto() {
		return this.hjsBsaRto;
	}

	/**
	 * Column Info
	 * @return chtrBasRto
	 */
	public String getChtrBasRto() {
		return this.chtrBasRto;
	}
	
	/**
	 * Column Info
	 * @return chtOut
	 */
	public String getChtOut() {
		return this.chtOut;
	}

	/**
	 * Column Info
	 * @return year
	 */
	public String getYear() {
		return this.year;
	}

	/**
	 * Column Info
	 * @return fmWeek
	 */
	public String getFmWeek() {
		return this.fmWeek;
	}

	/**
	 * Column Info
	 * @return toWeek
	 */
	public String getToWeek() {
		return this.toWeek;
	}

	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}

	/**
	 * Column Info
	 * @return tabIndex
	 */
	public String getTabIndex() {
		return this.tabIndex;
	}
	
	/**
	 * Column Info
	 * @return dValue
	 */
	public String getDValue() {
		return this.dValue;
	}
	
	/**
	 * Column Info
	 * @return fnlHjsBsaCapaSc
	 */
	public String getFnlHjsBsaCapaSc() {
		return this.fnlHjsBsaCapaSc;
	}
	
	/**
	 * Column Info
	 * @return yyww
	 */
	public void setYyww(String yyww) {
		this.yyww = yyww;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}

	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	/**
	 * Column Info
	 * @return type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @return voyNo
	 */
	public void setVoyNo(String voyNo) {
		this.voyNo = voyNo;
	}
	
	/**
	 * Column Info
	 * @return pErrMsg
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @return pOnlyStep
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
	}
	
	/**
	 * Column Info
	 * @return pYear
	 */
	public void setCarCd(String carCd) {
		this.carCd = carCd;
	}
	
	/**
	 * Column Info
	 */
	public void setCapa(String capa) {
		this.capa = capa;
	}

	/**
	 * Column Info
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 */
	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}

	/**
	 * Column Info
	 */
	public void setHeaderValue(String headerValue) {
		this.headerValue = headerValue;
	}

	/**
	 * Column Info
	 */
	public void setMnlFlg(String mnlFlg) {
		this.mnlFlg = mnlFlg;
	}

	/**
	 * Column Info
	 */
	public void setFnlHjsBsaCapa(String fnlHjsBsaCapa) {
		this.fnlHjsBsaCapa = fnlHjsBsaCapa;
	}

	/**
	 * Column Info
	 */
	public void setHjsBsaBfrSubCapa(String hjsBsaBfrSubCapa) {
		this.hjsBsaBfrSubCapa = hjsBsaBfrSubCapa;
	}

	/**
	 * Column Info
	 */
	public void setHjsBsaRto(String hjsBsaRto) {
		this.hjsBsaRto = hjsBsaRto;
	}

	/**
	 * Column Info
	 */
	public void setChtrBasRto(String chtrBasRto) {
		this.chtrBasRto = chtrBasRto;
	}

	/**
	 * Column Info
	 */
	public void setChtOut(String chtOut) {
		this.chtOut = chtOut;
	}
	

	/**
	 * Column Info
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * Column Info
	 */
	public void setFmWeek(String fmWeek) {
		this.fmWeek = fmWeek;
	}

	/**
	 * Column Info
	 */
	public void setToWeek(String toWeek) {
		this.toWeek = toWeek;
	}

	/**
	 * Column Info
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 */
	public void setDValue(String dValue) {
		this.dValue = dValue;
	}

	/**
	 * Column Info
	 */
	public void setTabIndex(String tabIndex) {
		this.tabIndex = tabIndex;
	}
	
	/**
	 * Column Info
	 */
	public void setFnlHjsBsaCapaSc(String fnlHjsBsaCapaSc) {
		this.fnlHjsBsaCapaSc = fnlHjsBsaCapaSc;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setYyww(JSPUtil.getParameter(request, "yyww", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setLaneCd(JSPUtil.getParameter(request, "lane_cd", ""));
		setType(JSPUtil.getParameter(request, "type", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVoyNo(JSPUtil.getParameter(request, "voy_no", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setOprCd(JSPUtil.getParameter(request, "opr_cd", ""));
		setCarCd(JSPUtil.getParameter(request, "car_cd", ""));
		setCapa(JSPUtil.getParameter(request, "capa", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMnlFlg(JSPUtil.getParameter(request, "mnl_flg", ""));
		setHeaderName(JSPUtil.getParameter(request, "header_name", ""));
		setHeaderValue(JSPUtil.getParameter(request, "header_value", ""));
		setChtOut(JSPUtil.getParameter(request, "cht_out", ""));
		setYear(JSPUtil.getParameter(request, "year", ""));
		setFmWeek(JSPUtil.getParameter(request, "fm_week", ""));
		setToWeek(JSPUtil.getParameter(request, "to_week", ""));
		setIocCd(JSPUtil.getParameter(request, "ioc_cd", ""));
		setTabIndex(JSPUtil.getParameter(request, "tab_index", ""));
		setDValue(JSPUtil.getParameter(request, "d_value", ""));
		setFnlHjsBsaCapaSc(JSPUtil.getParameter(request, "fnl_hjs_bsa_capa_sc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DailyBatchConditionVO[]
	 */
	public MultiSupplySwapVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DailyBatchConditionVO[]
	 */
	public MultiSupplySwapVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MultiSupplySwapVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] yyww = (JSPUtil.getParameter(request, prefix	+ "yyww", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] voyNo = (JSPUtil.getParameter(request, prefix	+ "voy_no", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] carCd = (JSPUtil.getParameter(request, prefix	+ "car_cd", length));
			String[] capa = (JSPUtil.getParameter(request, prefix	+ "capa", length));
			String[] mnlFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_flg", length));
			String[] headerName = (JSPUtil.getParameter(request, prefix	+ "header_name", length));
			String[] headerValue = (JSPUtil.getParameter(request, prefix	+ "header_value", length));
			String[] fnlHjsBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_hjs_bsa_capa" , length));
			String[] hjsBsaBfrSubCapa = (JSPUtil.getParameter(request, prefix	+ "hjs_bsa_bfr_sub_capa" ,length));
			String[] hjsBsaRto = (JSPUtil.getParameter(request, prefix	+ "hjs_bsa_rto" ,length));
			String[] chtrBasRto = (JSPUtil.getParameter(request, prefix	+ "chtr_bas_rto" ,length));
			String[] chtOut = (JSPUtil.getParameter(request, prefix	+ "cht_out" ,length));
			String[] year = (JSPUtil.getParameter(request, prefix	+ "year" ,length));
			String[] fmWeek = (JSPUtil.getParameter(request, prefix	+ "fm_week" ,length));
			String[] toWeek = (JSPUtil.getParameter(request, prefix	+ "to_week" ,length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd" ,length));
			String[] tabIndex = (JSPUtil.getParameter(request, prefix	+ "tab_index" ,length));
			String[] dValue = (JSPUtil.getParameter(request, prefix	+ "d_value" ,length));
			String[] fnlHjsBsaCapaSc = (JSPUtil.getParameter(request, prefix	+ "fnl_hjs_bsa_capa_sc" ,length));
			
			for (int i = 0; i < length; i++) {
				model = new MultiSupplySwapVvdVO();
				if (yyww[i] != null)
					model.setYyww(yyww[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (voyNo[i] != null)
					model.setVoyNo(voyNo[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (carCd[i] != null)
					model.setCarCd(carCd[i]);
				if (capa[i] != null)
					model.setCapa(capa[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnlFlg[i] != null)
					model.setMnlFlg(mnlFlg[i]);
				if (headerName[i] != null)
					model.setHeaderName(headerName[i]);
				if (headerValue[i] != null)
					model.setHeaderValue(headerValue[i]);
				if (fnlHjsBsaCapa[i] != null)
					model.setFnlHjsBsaCapa(fnlHjsBsaCapa[i]);
				if (hjsBsaBfrSubCapa[i] != null)
					model.setHjsBsaBfrSubCapa(hjsBsaBfrSubCapa[i]);
				if (hjsBsaRto[i] != null)
					model.setHjsBsaRto(hjsBsaRto[i]);
				if (chtrBasRto[i] != null)
					model.setChtrBasRto(chtrBasRto[i]);
				if (chtOut[i] != null)
					model.setChtOut(chtOut[i]);
				if (year[i] != null)
					model.setYear(year[i]);
				if (fmWeek[i] != null)
					model.setFmWeek(fmWeek[i]);
				if (toWeek[i] != null)
					model.setToWeek(toWeek[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (tabIndex[i] != null)
					model.setTabIndex(tabIndex[i]);
				if (dValue[i] != null)
					model.setDValue(dValue[i]);
				if (fnlHjsBsaCapaSc[i] != null)
					model.setFnlHjsBsaCapaSc(fnlHjsBsaCapaSc[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMultiSupplySwapVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MultiSupplySwapVvdVO[]
	 */
	public MultiSupplySwapVvdVO[] getMultiSupplySwapVvdVOs(){
		MultiSupplySwapVvdVO[] vos = (MultiSupplySwapVvdVO[])models.toArray(new MultiSupplySwapVvdVO[models.size()]);
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
		this.yyww = this.yyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyNo = this.voyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carCd = this.carCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capa = this.capa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlFlg = this.mnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.headerName = this.headerName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlHjsBsaCapa = this.fnlHjsBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsBsaBfrSubCapa = this.hjsBsaBfrSubCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsBsaRto = this.hjsBsaRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chtrBasRto = this.chtrBasRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chtOut = this.chtOut .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year = this.year .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmWeek = this.fmWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWeek = this.toWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tabIndex = this.tabIndex .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.headerValue = this.headerValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dValue = this.dValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlHjsBsaCapaSc = this.fnlHjsBsaCapaSc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
