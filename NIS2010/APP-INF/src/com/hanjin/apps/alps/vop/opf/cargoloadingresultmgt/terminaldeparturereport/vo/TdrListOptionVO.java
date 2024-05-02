/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TdrListOptionVO.java
*@FileTitle : TdrListOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.08.24 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TdrListOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TdrListOptionVO> models = new ArrayList<TdrListOptionVO>();
	
	/* Column Info */
	private String etb = null;
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String dda = null;
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String ado = null;
	/* Column Info */
	private String dlsfo = null;
	/* Column Info */
	private String bcddo = null;
	/* Column Info */
	private String afo = null;
	/* Column Info */
	private String dlsdo = null;
	/* Column Info */
	private String bcdfo = null;
	/* Column Info */
	private String ddf = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String bsdo = null;
	/* Column Info */
	private String bsfo = null;
	/* Column Info */
	private String adf = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ddo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bcdo = null;
	/* Column Info */
	private String bcfo = null;
	/* Column Info */
	private String bd = null;
	/* Column Info */
	private String bclsfo = null;
	/* Column Info */
	private String bclsdo = null;
	/* Column Info */
	private String ba = null;
	/* Column Info */
	private String sd = null;
	/* Column Info */
	private String bcdlsdo = null;
	/* Column Info */
	private String bcdlsfo = null;
	/* Column Info */
	private String ada = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String alsfo = null;
	/* Column Info */
	private String sa = null;
	/* Column Info */
	private String alsdo = null;
	/* Column Info */
	private String bslsdo = null;
	/* Column Info */
	private String bslsfo = null;
	/* Column Info */
	private String dfo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TdrListOptionVO() {}

	public TdrListOptionVO(String ibflag, String pagerows, String lane, String vvd, String port, String eta, String etb, String etd, String ada, String adf, String dda, String ddf, String ba, String bd, String sa, String sd, String afo, String ado, String alsfo, String alsdo, String dfo, String ddo, String dlsfo, String dlsdo, String bsfo, String bsdo, String bslsfo, String bslsdo, String bcfo, String bcdo, String bclsfo, String bclsdo, String bcdfo, String bcddo, String bcdlsfo, String bcdlsdo) {
		this.etb = etb;
		this.port = port;
		this.dda = dda;
		this.eta = eta;
		this.ado = ado;
		this.dlsfo = dlsfo;
		this.bcddo = bcddo;
		this.afo = afo;
		this.dlsdo = dlsdo;
		this.bcdfo = bcdfo;
		this.ddf = ddf;
		this.etd = etd;
		this.bsdo = bsdo;
		this.bsfo = bsfo;
		this.adf = adf;
		this.lane = lane;
		this.pagerows = pagerows;
		this.ddo = ddo;
		this.ibflag = ibflag;
		this.bcdo = bcdo;
		this.bcfo = bcfo;
		this.bd = bd;
		this.bclsfo = bclsfo;
		this.bclsdo = bclsdo;
		this.ba = ba;
		this.sd = sd;
		this.bcdlsdo = bcdlsdo;
		this.bcdlsfo = bcdlsfo;
		this.ada = ada;
		this.vvd = vvd;
		this.alsfo = alsfo;
		this.sa = sa;
		this.alsdo = alsdo;
		this.bslsdo = bslsdo;
		this.bslsfo = bslsfo;
		this.dfo = dfo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("etb", getEtb());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("dda", getDda());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("ado", getAdo());
		this.hashColumns.put("dlsfo", getDlsfo());
		this.hashColumns.put("bcddo", getBcddo());
		this.hashColumns.put("afo", getAfo());
		this.hashColumns.put("dlsdo", getDlsdo());
		this.hashColumns.put("bcdfo", getBcdfo());
		this.hashColumns.put("ddf", getDdf());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("bsdo", getBsdo());
		this.hashColumns.put("bsfo", getBsfo());
		this.hashColumns.put("adf", getAdf());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ddo", getDdo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bcdo", getBcdo());
		this.hashColumns.put("bcfo", getBcfo());
		this.hashColumns.put("bd", getBd());
		this.hashColumns.put("bclsfo", getBclsfo());
		this.hashColumns.put("bclsdo", getBclsdo());
		this.hashColumns.put("ba", getBa());
		this.hashColumns.put("sd", getSd());
		this.hashColumns.put("bcdlsdo", getBcdlsdo());
		this.hashColumns.put("bcdlsfo", getBcdlsfo());
		this.hashColumns.put("ada", getAda());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("alsfo", getAlsfo());
		this.hashColumns.put("sa", getSa());
		this.hashColumns.put("alsdo", getAlsdo());
		this.hashColumns.put("bslsdo", getBslsdo());
		this.hashColumns.put("bslsfo", getBslsfo());
		this.hashColumns.put("dfo", getDfo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("etb", "etb");
		this.hashFields.put("port", "port");
		this.hashFields.put("dda", "dda");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("ado", "ado");
		this.hashFields.put("dlsfo", "dlsfo");
		this.hashFields.put("bcddo", "bcddo");
		this.hashFields.put("afo", "afo");
		this.hashFields.put("dlsdo", "dlsdo");
		this.hashFields.put("bcdfo", "bcdfo");
		this.hashFields.put("ddf", "ddf");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("bsdo", "bsdo");
		this.hashFields.put("bsfo", "bsfo");
		this.hashFields.put("adf", "adf");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ddo", "ddo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bcdo", "bcdo");
		this.hashFields.put("bcfo", "bcfo");
		this.hashFields.put("bd", "bd");
		this.hashFields.put("bclsfo", "bclsfo");
		this.hashFields.put("bclsdo", "bclsdo");
		this.hashFields.put("ba", "ba");
		this.hashFields.put("sd", "sd");
		this.hashFields.put("bcdlsdo", "bcdlsdo");
		this.hashFields.put("bcdlsfo", "bcdlsfo");
		this.hashFields.put("ada", "ada");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("alsfo", "alsfo");
		this.hashFields.put("sa", "sa");
		this.hashFields.put("alsdo", "alsdo");
		this.hashFields.put("bslsdo", "bslsdo");
		this.hashFields.put("bslsfo", "bslsfo");
		this.hashFields.put("dfo", "dfo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return etb
	 */
	public String getEtb() {
		return this.etb;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return dda
	 */
	public String getDda() {
		return this.dda;
	}
	
	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
	}
	
	/**
	 * Column Info
	 * @return ado
	 */
	public String getAdo() {
		return this.ado;
	}
	
	/**
	 * Column Info
	 * @return dlsfo
	 */
	public String getDlsfo() {
		return this.dlsfo;
	}
	
	/**
	 * Column Info
	 * @return bcddo
	 */
	public String getBcddo() {
		return this.bcddo;
	}
	
	/**
	 * Column Info
	 * @return afo
	 */
	public String getAfo() {
		return this.afo;
	}
	
	/**
	 * Column Info
	 * @return dlsdo
	 */
	public String getDlsdo() {
		return this.dlsdo;
	}
	
	/**
	 * Column Info
	 * @return bcdfo
	 */
	public String getBcdfo() {
		return this.bcdfo;
	}
	
	/**
	 * Column Info
	 * @return ddf
	 */
	public String getDdf() {
		return this.ddf;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return bsdo
	 */
	public String getBsdo() {
		return this.bsdo;
	}
	
	/**
	 * Column Info
	 * @return bsfo
	 */
	public String getBsfo() {
		return this.bsfo;
	}
	
	/**
	 * Column Info
	 * @return adf
	 */
	public String getAdf() {
		return this.adf;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return ddo
	 */
	public String getDdo() {
		return this.ddo;
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
	 * @return bcdo
	 */
	public String getBcdo() {
		return this.bcdo;
	}
	
	/**
	 * Column Info
	 * @return bcfo
	 */
	public String getBcfo() {
		return this.bcfo;
	}
	
	/**
	 * Column Info
	 * @return bd
	 */
	public String getBd() {
		return this.bd;
	}
	
	/**
	 * Column Info
	 * @return bclsfo
	 */
	public String getBclsfo() {
		return this.bclsfo;
	}
	
	/**
	 * Column Info
	 * @return bclsdo
	 */
	public String getBclsdo() {
		return this.bclsdo;
	}
	
	/**
	 * Column Info
	 * @return ba
	 */
	public String getBa() {
		return this.ba;
	}
	
	/**
	 * Column Info
	 * @return sd
	 */
	public String getSd() {
		return this.sd;
	}
	
	/**
	 * Column Info
	 * @return bcdlsdo
	 */
	public String getBcdlsdo() {
		return this.bcdlsdo;
	}
	
	/**
	 * Column Info
	 * @return bcdlsfo
	 */
	public String getBcdlsfo() {
		return this.bcdlsfo;
	}
	
	/**
	 * Column Info
	 * @return ada
	 */
	public String getAda() {
		return this.ada;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return alsfo
	 */
	public String getAlsfo() {
		return this.alsfo;
	}
	
	/**
	 * Column Info
	 * @return sa
	 */
	public String getSa() {
		return this.sa;
	}
	
	/**
	 * Column Info
	 * @return alsdo
	 */
	public String getAlsdo() {
		return this.alsdo;
	}
	
	/**
	 * Column Info
	 * @return bslsdo
	 */
	public String getBslsdo() {
		return this.bslsdo;
	}
	
	/**
	 * Column Info
	 * @return bslsfo
	 */
	public String getBslsfo() {
		return this.bslsfo;
	}
	
	/**
	 * Column Info
	 * @return dfo
	 */
	public String getDfo() {
		return this.dfo;
	}
	

	/**
	 * Column Info
	 * @param etb
	 */
	public void setEtb(String etb) {
		this.etb = etb;
	}
	
	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param dda
	 */
	public void setDda(String dda) {
		this.dda = dda;
	}
	
	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}
	
	/**
	 * Column Info
	 * @param ado
	 */
	public void setAdo(String ado) {
		this.ado = ado;
	}
	
	/**
	 * Column Info
	 * @param dlsfo
	 */
	public void setDlsfo(String dlsfo) {
		this.dlsfo = dlsfo;
	}
	
	/**
	 * Column Info
	 * @param bcddo
	 */
	public void setBcddo(String bcddo) {
		this.bcddo = bcddo;
	}
	
	/**
	 * Column Info
	 * @param afo
	 */
	public void setAfo(String afo) {
		this.afo = afo;
	}
	
	/**
	 * Column Info
	 * @param dlsdo
	 */
	public void setDlsdo(String dlsdo) {
		this.dlsdo = dlsdo;
	}
	
	/**
	 * Column Info
	 * @param bcdfo
	 */
	public void setBcdfo(String bcdfo) {
		this.bcdfo = bcdfo;
	}
	
	/**
	 * Column Info
	 * @param ddf
	 */
	public void setDdf(String ddf) {
		this.ddf = ddf;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param bsdo
	 */
	public void setBsdo(String bsdo) {
		this.bsdo = bsdo;
	}
	
	/**
	 * Column Info
	 * @param bsfo
	 */
	public void setBsfo(String bsfo) {
		this.bsfo = bsfo;
	}
	
	/**
	 * Column Info
	 * @param adf
	 */
	public void setAdf(String adf) {
		this.adf = adf;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param ddo
	 */
	public void setDdo(String ddo) {
		this.ddo = ddo;
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
	 * @param bcdo
	 */
	public void setBcdo(String bcdo) {
		this.bcdo = bcdo;
	}
	
	/**
	 * Column Info
	 * @param bcfo
	 */
	public void setBcfo(String bcfo) {
		this.bcfo = bcfo;
	}
	
	/**
	 * Column Info
	 * @param bd
	 */
	public void setBd(String bd) {
		this.bd = bd;
	}
	
	/**
	 * Column Info
	 * @param bclsfo
	 */
	public void setBclsfo(String bclsfo) {
		this.bclsfo = bclsfo;
	}
	
	/**
	 * Column Info
	 * @param bclsdo
	 */
	public void setBclsdo(String bclsdo) {
		this.bclsdo = bclsdo;
	}
	
	/**
	 * Column Info
	 * @param ba
	 */
	public void setBa(String ba) {
		this.ba = ba;
	}
	
	/**
	 * Column Info
	 * @param sd
	 */
	public void setSd(String sd) {
		this.sd = sd;
	}
	
	/**
	 * Column Info
	 * @param bcdlsdo
	 */
	public void setBcdlsdo(String bcdlsdo) {
		this.bcdlsdo = bcdlsdo;
	}
	
	/**
	 * Column Info
	 * @param bcdlsfo
	 */
	public void setBcdlsfo(String bcdlsfo) {
		this.bcdlsfo = bcdlsfo;
	}
	
	/**
	 * Column Info
	 * @param ada
	 */
	public void setAda(String ada) {
		this.ada = ada;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param alsfo
	 */
	public void setAlsfo(String alsfo) {
		this.alsfo = alsfo;
	}
	
	/**
	 * Column Info
	 * @param sa
	 */
	public void setSa(String sa) {
		this.sa = sa;
	}
	
	/**
	 * Column Info
	 * @param alsdo
	 */
	public void setAlsdo(String alsdo) {
		this.alsdo = alsdo;
	}
	
	/**
	 * Column Info
	 * @param bslsdo
	 */
	public void setBslsdo(String bslsdo) {
		this.bslsdo = bslsdo;
	}
	
	/**
	 * Column Info
	 * @param bslsfo
	 */
	public void setBslsfo(String bslsfo) {
		this.bslsfo = bslsfo;
	}
	
	/**
	 * Column Info
	 * @param dfo
	 */
	public void setDfo(String dfo) {
		this.dfo = dfo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEtb(JSPUtil.getParameter(request, "etb", ""));
		setPort(JSPUtil.getParameter(request, "port", ""));
		setDda(JSPUtil.getParameter(request, "dda", ""));
		setEta(JSPUtil.getParameter(request, "eta", ""));
		setAdo(JSPUtil.getParameter(request, "ado", ""));
		setDlsfo(JSPUtil.getParameter(request, "dlsfo", ""));
		setBcddo(JSPUtil.getParameter(request, "bcddo", ""));
		setAfo(JSPUtil.getParameter(request, "afo", ""));
		setDlsdo(JSPUtil.getParameter(request, "dlsdo", ""));
		setBcdfo(JSPUtil.getParameter(request, "bcdfo", ""));
		setDdf(JSPUtil.getParameter(request, "ddf", ""));
		setEtd(JSPUtil.getParameter(request, "etd", ""));
		setBsdo(JSPUtil.getParameter(request, "bsdo", ""));
		setBsfo(JSPUtil.getParameter(request, "bsfo", ""));
		setAdf(JSPUtil.getParameter(request, "adf", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDdo(JSPUtil.getParameter(request, "ddo", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBcdo(JSPUtil.getParameter(request, "bcdo", ""));
		setBcfo(JSPUtil.getParameter(request, "bcfo", ""));
		setBd(JSPUtil.getParameter(request, "bd", ""));
		setBclsfo(JSPUtil.getParameter(request, "bclsfo", ""));
		setBclsdo(JSPUtil.getParameter(request, "bclsdo", ""));
		setBa(JSPUtil.getParameter(request, "ba", ""));
		setSd(JSPUtil.getParameter(request, "sd", ""));
		setBcdlsdo(JSPUtil.getParameter(request, "bcdlsdo", ""));
		setBcdlsfo(JSPUtil.getParameter(request, "bcdlsfo", ""));
		setAda(JSPUtil.getParameter(request, "ada", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setAlsfo(JSPUtil.getParameter(request, "alsfo", ""));
		setSa(JSPUtil.getParameter(request, "sa", ""));
		setAlsdo(JSPUtil.getParameter(request, "alsdo", ""));
		setBslsdo(JSPUtil.getParameter(request, "bslsdo", ""));
		setBslsfo(JSPUtil.getParameter(request, "bslsfo", ""));
		setDfo(JSPUtil.getParameter(request, "dfo", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TdrListOptionVO[]
	 */
	public TdrListOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TdrListOptionVO[]
	 */
	public TdrListOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TdrListOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] etb = (JSPUtil.getParameter(request, prefix	+ "etb", length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] dda = (JSPUtil.getParameter(request, prefix	+ "dda", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] ado = (JSPUtil.getParameter(request, prefix	+ "ado", length));
			String[] dlsfo = (JSPUtil.getParameter(request, prefix	+ "dlsfo", length));
			String[] bcddo = (JSPUtil.getParameter(request, prefix	+ "bcddo", length));
			String[] afo = (JSPUtil.getParameter(request, prefix	+ "afo", length));
			String[] dlsdo = (JSPUtil.getParameter(request, prefix	+ "dlsdo", length));
			String[] bcdfo = (JSPUtil.getParameter(request, prefix	+ "bcdfo", length));
			String[] ddf = (JSPUtil.getParameter(request, prefix	+ "ddf", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] bsdo = (JSPUtil.getParameter(request, prefix	+ "bsdo", length));
			String[] bsfo = (JSPUtil.getParameter(request, prefix	+ "bsfo", length));
			String[] adf = (JSPUtil.getParameter(request, prefix	+ "adf", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ddo = (JSPUtil.getParameter(request, prefix	+ "ddo", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bcdo = (JSPUtil.getParameter(request, prefix	+ "bcdo", length));
			String[] bcfo = (JSPUtil.getParameter(request, prefix	+ "bcfo", length));
			String[] bd = (JSPUtil.getParameter(request, prefix	+ "bd", length));
			String[] bclsfo = (JSPUtil.getParameter(request, prefix	+ "bclsfo", length));
			String[] bclsdo = (JSPUtil.getParameter(request, prefix	+ "bclsdo", length));
			String[] ba = (JSPUtil.getParameter(request, prefix	+ "ba", length));
			String[] sd = (JSPUtil.getParameter(request, prefix	+ "sd", length));
			String[] bcdlsdo = (JSPUtil.getParameter(request, prefix	+ "bcdlsdo", length));
			String[] bcdlsfo = (JSPUtil.getParameter(request, prefix	+ "bcdlsfo", length));
			String[] ada = (JSPUtil.getParameter(request, prefix	+ "ada", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] alsfo = (JSPUtil.getParameter(request, prefix	+ "alsfo", length));
			String[] sa = (JSPUtil.getParameter(request, prefix	+ "sa", length));
			String[] alsdo = (JSPUtil.getParameter(request, prefix	+ "alsdo", length));
			String[] bslsdo = (JSPUtil.getParameter(request, prefix	+ "bslsdo", length));
			String[] bslsfo = (JSPUtil.getParameter(request, prefix	+ "bslsfo", length));
			String[] dfo = (JSPUtil.getParameter(request, prefix	+ "dfo", length));
			
			for (int i = 0; i < length; i++) {
				model = new TdrListOptionVO();
				if (etb[i] != null)
					model.setEtb(etb[i]);
				if (port[i] != null)
					model.setPort(port[i]);
				if (dda[i] != null)
					model.setDda(dda[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (ado[i] != null)
					model.setAdo(ado[i]);
				if (dlsfo[i] != null)
					model.setDlsfo(dlsfo[i]);
				if (bcddo[i] != null)
					model.setBcddo(bcddo[i]);
				if (afo[i] != null)
					model.setAfo(afo[i]);
				if (dlsdo[i] != null)
					model.setDlsdo(dlsdo[i]);
				if (bcdfo[i] != null)
					model.setBcdfo(bcdfo[i]);
				if (ddf[i] != null)
					model.setDdf(ddf[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (bsdo[i] != null)
					model.setBsdo(bsdo[i]);
				if (bsfo[i] != null)
					model.setBsfo(bsfo[i]);
				if (adf[i] != null)
					model.setAdf(adf[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ddo[i] != null)
					model.setDdo(ddo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bcdo[i] != null)
					model.setBcdo(bcdo[i]);
				if (bcfo[i] != null)
					model.setBcfo(bcfo[i]);
				if (bd[i] != null)
					model.setBd(bd[i]);
				if (bclsfo[i] != null)
					model.setBclsfo(bclsfo[i]);
				if (bclsdo[i] != null)
					model.setBclsdo(bclsdo[i]);
				if (ba[i] != null)
					model.setBa(ba[i]);
				if (sd[i] != null)
					model.setSd(sd[i]);
				if (bcdlsdo[i] != null)
					model.setBcdlsdo(bcdlsdo[i]);
				if (bcdlsfo[i] != null)
					model.setBcdlsfo(bcdlsfo[i]);
				if (ada[i] != null)
					model.setAda(ada[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (alsfo[i] != null)
					model.setAlsfo(alsfo[i]);
				if (sa[i] != null)
					model.setSa(sa[i]);
				if (alsdo[i] != null)
					model.setAlsdo(alsdo[i]);
				if (bslsdo[i] != null)
					model.setBslsdo(bslsdo[i]);
				if (bslsfo[i] != null)
					model.setBslsfo(bslsfo[i]);
				if (dfo[i] != null)
					model.setDfo(dfo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTdrListOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TdrListOptionVO[]
	 */
	public TdrListOptionVO[] getTdrListOptionVOs(){
		TdrListOptionVO[] vos = (TdrListOptionVO[])models.toArray(new TdrListOptionVO[models.size()]);
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
		this.etb = this.etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dda = this.dda .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ado = this.ado .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlsfo = this.dlsfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bcddo = this.bcddo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.afo = this.afo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlsdo = this.dlsdo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bcdfo = this.bcdfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddf = this.ddf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsdo = this.bsdo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsfo = this.bsfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adf = this.adf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddo = this.ddo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bcdo = this.bcdo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bcfo = this.bcfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bd = this.bd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bclsfo = this.bclsfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bclsdo = this.bclsdo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ba = this.ba .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sd = this.sd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bcdlsdo = this.bcdlsdo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bcdlsfo = this.bcdlsfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ada = this.ada .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alsfo = this.alsfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sa = this.sa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alsdo = this.alsdo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bslsdo = this.bslsdo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bslsfo = this.bslsfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfo = this.dfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
