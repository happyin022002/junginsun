/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LOADVO.java
*@FileTitle : LOADVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.19
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.08.19 민정호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo;

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
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class LOADVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LOADVO> models = new ArrayList<LOADVO>();
	
	/* Column Info */
	private String rf20ftCntrStlTeuCapa = null;
	/* Column Info */
	private String rf40ftCntrStlPrc = null;
	/* Column Info */
	private String dgCntrStlRmk = null;
	/* Column Info */
	private String rf20ftCntrStlRmk = null;
	/* Column Info */
	private String dgCntrStlAmt = null;
	/* Column Info */
	private String rf40ftCntrStlTeuCapa = null;
	/* Column Info */
	private String tmlCd = null;
	/* Column Info */
	private String ovrUsdSltRmk = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rf40ftCntrStlRmk = null;
	/* Column Info */
	private String dgCntrStlTeuCapa = null;
	/* Column Info */
	private String rf20ftCntrStlAmt = null;
	/* Column Info */
	private String ovrUsdSltPrc = null;
	/* Column Info */
	private String rf20ftCntrStlPrc = null;
	/* Column Info */
	private String dgCntrStlPrc = null;
	/* Column Info */
	private String rf40ftCntrStlAmt = null;
	/* Column Info */
	private String ovrUsdSltTeuCapa = null;
	/* Column Info */
	private String ovrUsdSltAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public LOADVO() {}

	public LOADVO(String ibflag, String pagerows, String ovrUsdSltTeuCapa, String ovrUsdSltPrc, String ovrUsdSltAmt, String ovrUsdSltRmk, String rf20ftCntrStlTeuCapa, String rf20ftCntrStlPrc, String rf20ftCntrStlAmt, String rf20ftCntrStlRmk, String rf40ftCntrStlTeuCapa, String rf40ftCntrStlPrc, String rf40ftCntrStlAmt, String rf40ftCntrStlRmk, String dgCntrStlTeuCapa, String dgCntrStlPrc, String dgCntrStlAmt, String dgCntrStlRmk, String tmlCd) {
		this.rf20ftCntrStlTeuCapa = rf20ftCntrStlTeuCapa;
		this.rf40ftCntrStlPrc = rf40ftCntrStlPrc;
		this.dgCntrStlRmk = dgCntrStlRmk;
		this.rf20ftCntrStlRmk = rf20ftCntrStlRmk;
		this.dgCntrStlAmt = dgCntrStlAmt;
		this.rf40ftCntrStlTeuCapa = rf40ftCntrStlTeuCapa;
		this.tmlCd = tmlCd;
		this.ovrUsdSltRmk = ovrUsdSltRmk;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.rf40ftCntrStlRmk = rf40ftCntrStlRmk;
		this.dgCntrStlTeuCapa = dgCntrStlTeuCapa;
		this.rf20ftCntrStlAmt = rf20ftCntrStlAmt;
		this.ovrUsdSltPrc = ovrUsdSltPrc;
		this.rf20ftCntrStlPrc = rf20ftCntrStlPrc;
		this.dgCntrStlPrc = dgCntrStlPrc;
		this.rf40ftCntrStlAmt = rf40ftCntrStlAmt;
		this.ovrUsdSltTeuCapa = ovrUsdSltTeuCapa;
		this.ovrUsdSltAmt = ovrUsdSltAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rf_20ft_cntr_stl_teu_capa", getRf20ftCntrStlTeuCapa());
		this.hashColumns.put("rf_40ft_cntr_stl_prc", getRf40ftCntrStlPrc());
		this.hashColumns.put("dg_cntr_stl_rmk", getDgCntrStlRmk());
		this.hashColumns.put("rf_20ft_cntr_stl_rmk", getRf20ftCntrStlRmk());
		this.hashColumns.put("dg_cntr_stl_amt", getDgCntrStlAmt());
		this.hashColumns.put("rf_40ft_cntr_stl_teu_capa", getRf40ftCntrStlTeuCapa());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("ovr_usd_slt_rmk", getOvrUsdSltRmk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rf_40ft_cntr_stl_rmk", getRf40ftCntrStlRmk());
		this.hashColumns.put("dg_cntr_stl_teu_capa", getDgCntrStlTeuCapa());
		this.hashColumns.put("rf_20ft_cntr_stl_amt", getRf20ftCntrStlAmt());
		this.hashColumns.put("ovr_usd_slt_prc", getOvrUsdSltPrc());
		this.hashColumns.put("rf_20ft_cntr_stl_prc", getRf20ftCntrStlPrc());
		this.hashColumns.put("dg_cntr_stl_prc", getDgCntrStlPrc());
		this.hashColumns.put("rf_40ft_cntr_stl_amt", getRf40ftCntrStlAmt());
		this.hashColumns.put("ovr_usd_slt_teu_capa", getOvrUsdSltTeuCapa());
		this.hashColumns.put("ovr_usd_slt_amt", getOvrUsdSltAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rf_20ft_cntr_stl_teu_capa", "rf20ftCntrStlTeuCapa");
		this.hashFields.put("rf_40ft_cntr_stl_prc", "rf40ftCntrStlPrc");
		this.hashFields.put("dg_cntr_stl_rmk", "dgCntrStlRmk");
		this.hashFields.put("rf_20ft_cntr_stl_rmk", "rf20ftCntrStlRmk");
		this.hashFields.put("dg_cntr_stl_amt", "dgCntrStlAmt");
		this.hashFields.put("rf_40ft_cntr_stl_teu_capa", "rf40ftCntrStlTeuCapa");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("ovr_usd_slt_rmk", "ovrUsdSltRmk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rf_40ft_cntr_stl_rmk", "rf40ftCntrStlRmk");
		this.hashFields.put("dg_cntr_stl_teu_capa", "dgCntrStlTeuCapa");
		this.hashFields.put("rf_20ft_cntr_stl_amt", "rf20ftCntrStlAmt");
		this.hashFields.put("ovr_usd_slt_prc", "ovrUsdSltPrc");
		this.hashFields.put("rf_20ft_cntr_stl_prc", "rf20ftCntrStlPrc");
		this.hashFields.put("dg_cntr_stl_prc", "dgCntrStlPrc");
		this.hashFields.put("rf_40ft_cntr_stl_amt", "rf40ftCntrStlAmt");
		this.hashFields.put("ovr_usd_slt_teu_capa", "ovrUsdSltTeuCapa");
		this.hashFields.put("ovr_usd_slt_amt", "ovrUsdSltAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rf20ftCntrStlTeuCapa
	 */
	public String getRf20ftCntrStlTeuCapa() {
		return this.rf20ftCntrStlTeuCapa;
	}
	
	/**
	 * Column Info
	 * @return rf40ftCntrStlPrc
	 */
	public String getRf40ftCntrStlPrc() {
		return this.rf40ftCntrStlPrc;
	}
	
	/**
	 * Column Info
	 * @return dgCntrStlRmk
	 */
	public String getDgCntrStlRmk() {
		return this.dgCntrStlRmk;
	}
	
	/**
	 * Column Info
	 * @return rf20ftCntrStlRmk
	 */
	public String getRf20ftCntrStlRmk() {
		return this.rf20ftCntrStlRmk;
	}
	
	/**
	 * Column Info
	 * @return dgCntrStlAmt
	 */
	public String getDgCntrStlAmt() {
		return this.dgCntrStlAmt;
	}
	
	/**
	 * Column Info
	 * @return rf40ftCntrStlTeuCapa
	 */
	public String getRf40ftCntrStlTeuCapa() {
		return this.rf40ftCntrStlTeuCapa;
	}
	
	/**
	 * Column Info
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
	}
	
	/**
	 * Column Info
	 * @return ovrUsdSltRmk
	 */
	public String getOvrUsdSltRmk() {
		return this.ovrUsdSltRmk;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return rf40ftCntrStlRmk
	 */
	public String getRf40ftCntrStlRmk() {
		return this.rf40ftCntrStlRmk;
	}
	
	/**
	 * Column Info
	 * @return dgCntrStlTeuCapa
	 */
	public String getDgCntrStlTeuCapa() {
		return this.dgCntrStlTeuCapa;
	}
	
	/**
	 * Column Info
	 * @return rf20ftCntrStlAmt
	 */
	public String getRf20ftCntrStlAmt() {
		return this.rf20ftCntrStlAmt;
	}
	
	/**
	 * Column Info
	 * @return ovrUsdSltPrc
	 */
	public String getOvrUsdSltPrc() {
		return this.ovrUsdSltPrc;
	}
	
	/**
	 * Column Info
	 * @return rf20ftCntrStlPrc
	 */
	public String getRf20ftCntrStlPrc() {
		return this.rf20ftCntrStlPrc;
	}
	
	/**
	 * Column Info
	 * @return dgCntrStlPrc
	 */
	public String getDgCntrStlPrc() {
		return this.dgCntrStlPrc;
	}
	
	/**
	 * Column Info
	 * @return rf40ftCntrStlAmt
	 */
	public String getRf40ftCntrStlAmt() {
		return this.rf40ftCntrStlAmt;
	}
	
	/**
	 * Column Info
	 * @return ovrUsdSltTeuCapa
	 */
	public String getOvrUsdSltTeuCapa() {
		return this.ovrUsdSltTeuCapa;
	}
	
	/**
	 * Column Info
	 * @return ovrUsdSltAmt
	 */
	public String getOvrUsdSltAmt() {
		return this.ovrUsdSltAmt;
	}
	

	/**
	 * Column Info
	 * @param rf20ftCntrStlTeuCapa
	 */
	public void setRf20ftCntrStlTeuCapa(String rf20ftCntrStlTeuCapa) {
		this.rf20ftCntrStlTeuCapa = rf20ftCntrStlTeuCapa;
	}
	
	/**
	 * Column Info
	 * @param rf40ftCntrStlPrc
	 */
	public void setRf40ftCntrStlPrc(String rf40ftCntrStlPrc) {
		this.rf40ftCntrStlPrc = rf40ftCntrStlPrc;
	}
	
	/**
	 * Column Info
	 * @param dgCntrStlRmk
	 */
	public void setDgCntrStlRmk(String dgCntrStlRmk) {
		this.dgCntrStlRmk = dgCntrStlRmk;
	}
	
	/**
	 * Column Info
	 * @param rf20ftCntrStlRmk
	 */
	public void setRf20ftCntrStlRmk(String rf20ftCntrStlRmk) {
		this.rf20ftCntrStlRmk = rf20ftCntrStlRmk;
	}
	
	/**
	 * Column Info
	 * @param dgCntrStlAmt
	 */
	public void setDgCntrStlAmt(String dgCntrStlAmt) {
		this.dgCntrStlAmt = dgCntrStlAmt;
	}
	
	/**
	 * Column Info
	 * @param rf40ftCntrStlTeuCapa
	 */
	public void setRf40ftCntrStlTeuCapa(String rf40ftCntrStlTeuCapa) {
		this.rf40ftCntrStlTeuCapa = rf40ftCntrStlTeuCapa;
	}
	
	/**
	 * Column Info
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
	}
	
	/**
	 * Column Info
	 * @param ovrUsdSltRmk
	 */
	public void setOvrUsdSltRmk(String ovrUsdSltRmk) {
		this.ovrUsdSltRmk = ovrUsdSltRmk;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param rf40ftCntrStlRmk
	 */
	public void setRf40ftCntrStlRmk(String rf40ftCntrStlRmk) {
		this.rf40ftCntrStlRmk = rf40ftCntrStlRmk;
	}
	
	/**
	 * Column Info
	 * @param dgCntrStlTeuCapa
	 */
	public void setDgCntrStlTeuCapa(String dgCntrStlTeuCapa) {
		this.dgCntrStlTeuCapa = dgCntrStlTeuCapa;
	}
	
	/**
	 * Column Info
	 * @param rf20ftCntrStlAmt
	 */
	public void setRf20ftCntrStlAmt(String rf20ftCntrStlAmt) {
		this.rf20ftCntrStlAmt = rf20ftCntrStlAmt;
	}
	
	/**
	 * Column Info
	 * @param ovrUsdSltPrc
	 */
	public void setOvrUsdSltPrc(String ovrUsdSltPrc) {
		this.ovrUsdSltPrc = ovrUsdSltPrc;
	}
	
	/**
	 * Column Info
	 * @param rf20ftCntrStlPrc
	 */
	public void setRf20ftCntrStlPrc(String rf20ftCntrStlPrc) {
		this.rf20ftCntrStlPrc = rf20ftCntrStlPrc;
	}
	
	/**
	 * Column Info
	 * @param dgCntrStlPrc
	 */
	public void setDgCntrStlPrc(String dgCntrStlPrc) {
		this.dgCntrStlPrc = dgCntrStlPrc;
	}
	
	/**
	 * Column Info
	 * @param rf40ftCntrStlAmt
	 */
	public void setRf40ftCntrStlAmt(String rf40ftCntrStlAmt) {
		this.rf40ftCntrStlAmt = rf40ftCntrStlAmt;
	}
	
	/**
	 * Column Info
	 * @param ovrUsdSltTeuCapa
	 */
	public void setOvrUsdSltTeuCapa(String ovrUsdSltTeuCapa) {
		this.ovrUsdSltTeuCapa = ovrUsdSltTeuCapa;
	}
	
	/**
	 * Column Info
	 * @param ovrUsdSltAmt
	 */
	public void setOvrUsdSltAmt(String ovrUsdSltAmt) {
		this.ovrUsdSltAmt = ovrUsdSltAmt;
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
		setRf20ftCntrStlTeuCapa(JSPUtil.getParameter(request, prefix + "rf_20ft_cntr_stl_teu_capa", ""));
		setRf40ftCntrStlPrc(JSPUtil.getParameter(request, prefix + "rf_40ft_cntr_stl_prc", ""));
		setDgCntrStlRmk(JSPUtil.getParameter(request, prefix + "dg_cntr_stl_rmk", ""));
		setRf20ftCntrStlRmk(JSPUtil.getParameter(request, prefix + "rf_20ft_cntr_stl_rmk", ""));
		setDgCntrStlAmt(JSPUtil.getParameter(request, prefix + "dg_cntr_stl_amt", ""));
		setRf40ftCntrStlTeuCapa(JSPUtil.getParameter(request, prefix + "rf_40ft_cntr_stl_teu_capa", ""));
		setTmlCd(JSPUtil.getParameter(request, prefix + "tml_cd", ""));
		setOvrUsdSltRmk(JSPUtil.getParameter(request, prefix + "ovr_usd_slt_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRf40ftCntrStlRmk(JSPUtil.getParameter(request, prefix + "rf_40ft_cntr_stl_rmk", ""));
		setDgCntrStlTeuCapa(JSPUtil.getParameter(request, prefix + "dg_cntr_stl_teu_capa", ""));
		setRf20ftCntrStlAmt(JSPUtil.getParameter(request, prefix + "rf_20ft_cntr_stl_amt", ""));
		setOvrUsdSltPrc(JSPUtil.getParameter(request, prefix + "ovr_usd_slt_prc", ""));
		setRf20ftCntrStlPrc(JSPUtil.getParameter(request, prefix + "rf_20ft_cntr_stl_prc", ""));
		setDgCntrStlPrc(JSPUtil.getParameter(request, prefix + "dg_cntr_stl_prc", ""));
		setRf40ftCntrStlAmt(JSPUtil.getParameter(request, prefix + "rf_40ft_cntr_stl_amt", ""));
		setOvrUsdSltTeuCapa(JSPUtil.getParameter(request, prefix + "ovr_usd_slt_teu_capa", ""));
		setOvrUsdSltAmt(JSPUtil.getParameter(request, prefix + "ovr_usd_slt_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LOADVO[]
	 */
	public LOADVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LOADVO[]
	 */
	public LOADVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LOADVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rf20ftCntrStlTeuCapa = (JSPUtil.getParameter(request, prefix	+ "rf_20ft_cntr_stl_teu_capa", length));
			String[] rf40ftCntrStlPrc = (JSPUtil.getParameter(request, prefix	+ "rf_40ft_cntr_stl_prc", length));
			String[] dgCntrStlRmk = (JSPUtil.getParameter(request, prefix	+ "dg_cntr_stl_rmk", length));
			String[] rf20ftCntrStlRmk = (JSPUtil.getParameter(request, prefix	+ "rf_20ft_cntr_stl_rmk", length));
			String[] dgCntrStlAmt = (JSPUtil.getParameter(request, prefix	+ "dg_cntr_stl_amt", length));
			String[] rf40ftCntrStlTeuCapa = (JSPUtil.getParameter(request, prefix	+ "rf_40ft_cntr_stl_teu_capa", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] ovrUsdSltRmk = (JSPUtil.getParameter(request, prefix	+ "ovr_usd_slt_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rf40ftCntrStlRmk = (JSPUtil.getParameter(request, prefix	+ "rf_40ft_cntr_stl_rmk", length));
			String[] dgCntrStlTeuCapa = (JSPUtil.getParameter(request, prefix	+ "dg_cntr_stl_teu_capa", length));
			String[] rf20ftCntrStlAmt = (JSPUtil.getParameter(request, prefix	+ "rf_20ft_cntr_stl_amt", length));
			String[] ovrUsdSltPrc = (JSPUtil.getParameter(request, prefix	+ "ovr_usd_slt_prc", length));
			String[] rf20ftCntrStlPrc = (JSPUtil.getParameter(request, prefix	+ "rf_20ft_cntr_stl_prc", length));
			String[] dgCntrStlPrc = (JSPUtil.getParameter(request, prefix	+ "dg_cntr_stl_prc", length));
			String[] rf40ftCntrStlAmt = (JSPUtil.getParameter(request, prefix	+ "rf_40ft_cntr_stl_amt", length));
			String[] ovrUsdSltTeuCapa = (JSPUtil.getParameter(request, prefix	+ "ovr_usd_slt_teu_capa", length));
			String[] ovrUsdSltAmt = (JSPUtil.getParameter(request, prefix	+ "ovr_usd_slt_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new LOADVO();
				if (rf20ftCntrStlTeuCapa[i] != null)
					model.setRf20ftCntrStlTeuCapa(rf20ftCntrStlTeuCapa[i]);
				if (rf40ftCntrStlPrc[i] != null)
					model.setRf40ftCntrStlPrc(rf40ftCntrStlPrc[i]);
				if (dgCntrStlRmk[i] != null)
					model.setDgCntrStlRmk(dgCntrStlRmk[i]);
				if (rf20ftCntrStlRmk[i] != null)
					model.setRf20ftCntrStlRmk(rf20ftCntrStlRmk[i]);
				if (dgCntrStlAmt[i] != null)
					model.setDgCntrStlAmt(dgCntrStlAmt[i]);
				if (rf40ftCntrStlTeuCapa[i] != null)
					model.setRf40ftCntrStlTeuCapa(rf40ftCntrStlTeuCapa[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (ovrUsdSltRmk[i] != null)
					model.setOvrUsdSltRmk(ovrUsdSltRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rf40ftCntrStlRmk[i] != null)
					model.setRf40ftCntrStlRmk(rf40ftCntrStlRmk[i]);
				if (dgCntrStlTeuCapa[i] != null)
					model.setDgCntrStlTeuCapa(dgCntrStlTeuCapa[i]);
				if (rf20ftCntrStlAmt[i] != null)
					model.setRf20ftCntrStlAmt(rf20ftCntrStlAmt[i]);
				if (ovrUsdSltPrc[i] != null)
					model.setOvrUsdSltPrc(ovrUsdSltPrc[i]);
				if (rf20ftCntrStlPrc[i] != null)
					model.setRf20ftCntrStlPrc(rf20ftCntrStlPrc[i]);
				if (dgCntrStlPrc[i] != null)
					model.setDgCntrStlPrc(dgCntrStlPrc[i]);
				if (rf40ftCntrStlAmt[i] != null)
					model.setRf40ftCntrStlAmt(rf40ftCntrStlAmt[i]);
				if (ovrUsdSltTeuCapa[i] != null)
					model.setOvrUsdSltTeuCapa(ovrUsdSltTeuCapa[i]);
				if (ovrUsdSltAmt[i] != null)
					model.setOvrUsdSltAmt(ovrUsdSltAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLOADVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LOADVO[]
	 */
	public LOADVO[] getLOADVOs(){
		LOADVO[] vos = (LOADVO[])models.toArray(new LOADVO[models.size()]);
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
		this.rf20ftCntrStlTeuCapa = this.rf20ftCntrStlTeuCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40ftCntrStlPrc = this.rf40ftCntrStlPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCntrStlRmk = this.dgCntrStlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20ftCntrStlRmk = this.rf20ftCntrStlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCntrStlAmt = this.dgCntrStlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40ftCntrStlTeuCapa = this.rf40ftCntrStlTeuCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrUsdSltRmk = this.ovrUsdSltRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40ftCntrStlRmk = this.rf40ftCntrStlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCntrStlTeuCapa = this.dgCntrStlTeuCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20ftCntrStlAmt = this.rf20ftCntrStlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrUsdSltPrc = this.ovrUsdSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20ftCntrStlPrc = this.rf20ftCntrStlPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCntrStlPrc = this.dgCntrStlPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40ftCntrStlAmt = this.rf40ftCntrStlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrUsdSltTeuCapa = this.ovrUsdSltTeuCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrUsdSltAmt = this.ovrUsdSltAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
