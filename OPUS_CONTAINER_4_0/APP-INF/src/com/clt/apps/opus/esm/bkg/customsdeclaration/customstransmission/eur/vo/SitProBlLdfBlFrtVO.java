/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SitProBlLdfBlFrtVO.java
*@FileTitle : SitProBlLdfBlFrtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SitProBlLdfBlFrtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SitProBlLdfBlFrtVO> models = new ArrayList<SitProBlLdfBlFrtVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String vvd = null;

	/* Column Info */
	private String ibConVvd = null;

	/* Column Info */
	private String obConVvd = null;

	/* Column Info */
	private String port = null;

	/* Column Info */
	private String blnbr = null;

	/* Column Info */
	private String ppdofc = null;

	/* Column Info */
	private String ppdPayer = null;

	/* Column Info */
	private String cctofc = null;

	/* Column Info */
	private String cctPayer = null;

	/* Column Info */
	private String thdofc = null;

	/* Column Info */
	private String scno = null;

	/* Column Info */
	private String rfano = null;

	/* Column Info */
	private String fctype = null;

	/* Column Info */
	private String rate = null;

	/* Column Info */
	private String revenueton = null;

	/* Column Info */
	private String ppd = null;

	/* Column Info */
	private String cct = null;

	/* Column Info */
	private String currencycode = null;

	/* Column Info */
	private String exchrate = null;

	/* Column Info */
	private String tariff = null;

	/* Column Info */
	private String pertype = null;

	/* Column Info */
	private String rateofc = null;

	/* Column Info */
	private String ppdTotal = null;

	/* Column Info */
	private String cctTotal = null;

	/* Column Info */
	private String totalCur = null;

	/* Column Info */
	private String ppdUsd = null;

	/* Column Info */
	private String cctUsd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SitProBlLdfBlFrtVO() {}

	public SitProBlLdfBlFrtVO(String ibflag, String pagerows, String vvd, String ibConVvd, String obConVvd, String port, String blnbr, String ppdofc, String ppdPayer, String cctofc, String cctPayer, String thdofc, String scno, String rfano, String fctype, String rate, String revenueton, String ppd, String cct, String currencycode, String exchrate, String tariff, String pertype, String rateofc, String ppdTotal, String cctTotal, String totalCur, String ppdUsd, String cctUsd) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibConVvd = ibConVvd;
		this.obConVvd = obConVvd;
		this.port = port;
		this.blnbr = blnbr;
		this.ppdofc = ppdofc;
		this.ppdPayer = ppdPayer;
		this.cctofc = cctofc;
		this.cctPayer = cctPayer;
		this.thdofc = thdofc;
		this.scno = scno;
		this.rfano = rfano;
		this.fctype = fctype;
		this.rate = rate;
		this.revenueton = revenueton;
		this.ppd = ppd;
		this.cct = cct;
		this.currencycode = currencycode;
		this.exchrate = exchrate;
		this.tariff = tariff;
		this.pertype = pertype;
		this.rateofc = rateofc;
		this.ppdTotal = ppdTotal;
		this.cctTotal = cctTotal;
		this.totalCur = totalCur;
		this.ppdUsd = ppdUsd;
		this.cctUsd = cctUsd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ib_con_vvd", getIbConVvd());
		this.hashColumns.put("ob_con_vvd", getObConVvd());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("blnbr", getBlnbr());
		this.hashColumns.put("ppdofc", getPpdofc());
		this.hashColumns.put("ppd_payer", getPpdPayer());
		this.hashColumns.put("cctofc", getCctofc());
		this.hashColumns.put("cct_payer", getCctPayer());
		this.hashColumns.put("thdofc", getThdofc());
		this.hashColumns.put("scno", getScno());
		this.hashColumns.put("rfano", getRfano());
		this.hashColumns.put("fctype", getFctype());
		this.hashColumns.put("rate", getRate());
		this.hashColumns.put("revenueton", getRevenueton());
		this.hashColumns.put("ppd", getPpd());
		this.hashColumns.put("cct", getCct());
		this.hashColumns.put("currencycode", getCurrencycode());
		this.hashColumns.put("exchrate", getExchrate());
		this.hashColumns.put("tariff", getTariff());
		this.hashColumns.put("pertype", getPertype());
		this.hashColumns.put("rateofc", getRateofc());
		this.hashColumns.put("ppd_total", getPpdTotal());
		this.hashColumns.put("cct_total", getCctTotal());
		this.hashColumns.put("total_cur", getTotalCur());
		this.hashColumns.put("ppd_usd", getPpdUsd());
		this.hashColumns.put("cct_usd", getCctUsd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ib_con_vvd", "ibConVvd");
		this.hashFields.put("ob_con_vvd", "obConVvd");
		this.hashFields.put("port", "port");
		this.hashFields.put("blnbr", "blnbr");
		this.hashFields.put("ppdofc", "ppdofc");
		this.hashFields.put("ppd_payer", "ppdPayer");
		this.hashFields.put("cctofc", "cctofc");
		this.hashFields.put("cct_payer", "cctPayer");
		this.hashFields.put("thdofc", "thdofc");
		this.hashFields.put("scno", "scno");
		this.hashFields.put("rfano", "rfano");
		this.hashFields.put("fctype", "fctype");
		this.hashFields.put("rate", "rate");
		this.hashFields.put("revenueton", "revenueton");
		this.hashFields.put("ppd", "ppd");
		this.hashFields.put("cct", "cct");
		this.hashFields.put("currencycode", "currencycode");
		this.hashFields.put("exchrate", "exchrate");
		this.hashFields.put("tariff", "tariff");
		this.hashFields.put("pertype", "pertype");
		this.hashFields.put("rateofc", "rateofc");
		this.hashFields.put("ppd_total", "ppdTotal");
		this.hashFields.put("cct_total", "cctTotal");
		this.hashFields.put("total_cur", "totalCur");
		this.hashFields.put("ppd_usd", "ppdUsd");
		this.hashFields.put("cct_usd", "cctUsd");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * 
	 * @return String vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 *
	 * @param String ibConVvd
	 */
	public void setIbConVvd(String ibConVvd) {
		this.ibConVvd = ibConVvd;
	}
	
	/**
	 * 
	 * @return String ibConVvd
	 */
	public String getIbConVvd() {
		return this.ibConVvd;
	}
	
	/**
	 *
	 * @param String obConVvd
	 */
	public void setObConVvd(String obConVvd) {
		this.obConVvd = obConVvd;
	}
	
	/**
	 * 
	 * @return String obConVvd
	 */
	public String getObConVvd() {
		return this.obConVvd;
	}
	
	/**
	 *
	 * @param String port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * 
	 * @return String port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 *
	 * @param String blnbr
	 */
	public void setBlnbr(String blnbr) {
		this.blnbr = blnbr;
	}
	
	/**
	 * 
	 * @return String blnbr
	 */
	public String getBlnbr() {
		return this.blnbr;
	}
	
	/**
	 *
	 * @param String ppdofc
	 */
	public void setPpdofc(String ppdofc) {
		this.ppdofc = ppdofc;
	}
	
	/**
	 * 
	 * @return String ppdofc
	 */
	public String getPpdofc() {
		return this.ppdofc;
	}
	
	/**
	 *
	 * @param String ppdPayer
	 */
	public void setPpdPayer(String ppdPayer) {
		this.ppdPayer = ppdPayer;
	}
	
	/**
	 * 
	 * @return String ppdPayer
	 */
	public String getPpdPayer() {
		return this.ppdPayer;
	}
	
	/**
	 *
	 * @param String cctofc
	 */
	public void setCctofc(String cctofc) {
		this.cctofc = cctofc;
	}
	
	/**
	 * 
	 * @return String cctofc
	 */
	public String getCctofc() {
		return this.cctofc;
	}
	
	/**
	 *
	 * @param String cctPayer
	 */
	public void setCctPayer(String cctPayer) {
		this.cctPayer = cctPayer;
	}
	
	/**
	 * 
	 * @return String cctPayer
	 */
	public String getCctPayer() {
		return this.cctPayer;
	}
	
	/**
	 *
	 * @param String thdofc
	 */
	public void setThdofc(String thdofc) {
		this.thdofc = thdofc;
	}
	
	/**
	 * 
	 * @return String thdofc
	 */
	public String getThdofc() {
		return this.thdofc;
	}
	
	/**
	 *
	 * @param String scno
	 */
	public void setScno(String scno) {
		this.scno = scno;
	}
	
	/**
	 * 
	 * @return String scno
	 */
	public String getScno() {
		return this.scno;
	}
	
	/**
	 *
	 * @param String rfano
	 */
	public void setRfano(String rfano) {
		this.rfano = rfano;
	}
	
	/**
	 * 
	 * @return String rfano
	 */
	public String getRfano() {
		return this.rfano;
	}
	
	/**
	 *
	 * @param String fctype
	 */
	public void setFctype(String fctype) {
		this.fctype = fctype;
	}
	
	/**
	 * 
	 * @return String fctype
	 */
	public String getFctype() {
		return this.fctype;
	}
	
	/**
	 *
	 * @param String rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	/**
	 * 
	 * @return String rate
	 */
	public String getRate() {
		return this.rate;
	}
	
	/**
	 *
	 * @param String revenueton
	 */
	public void setRevenueton(String revenueton) {
		this.revenueton = revenueton;
	}
	
	/**
	 * 
	 * @return String revenueton
	 */
	public String getRevenueton() {
		return this.revenueton;
	}
	
	/**
	 *
	 * @param String ppd
	 */
	public void setPpd(String ppd) {
		this.ppd = ppd;
	}
	
	/**
	 * 
	 * @return String ppd
	 */
	public String getPpd() {
		return this.ppd;
	}
	
	/**
	 *
	 * @param String cct
	 */
	public void setCct(String cct) {
		this.cct = cct;
	}
	
	/**
	 * 
	 * @return String cct
	 */
	public String getCct() {
		return this.cct;
	}
	
	/**
	 *
	 * @param String currencycode
	 */
	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}
	
	/**
	 * 
	 * @return String currencycode
	 */
	public String getCurrencycode() {
		return this.currencycode;
	}
	
	/**
	 *
	 * @param String exchrate
	 */
	public void setExchrate(String exchrate) {
		this.exchrate = exchrate;
	}
	
	/**
	 * 
	 * @return String exchrate
	 */
	public String getExchrate() {
		return this.exchrate;
	}
	
	/**
	 *
	 * @param String tariff
	 */
	public void setTariff(String tariff) {
		this.tariff = tariff;
	}
	
	/**
	 * 
	 * @return String tariff
	 */
	public String getTariff() {
		return this.tariff;
	}
	
	/**
	 *
	 * @param String pertype
	 */
	public void setPertype(String pertype) {
		this.pertype = pertype;
	}
	
	/**
	 * 
	 * @return String pertype
	 */
	public String getPertype() {
		return this.pertype;
	}
	
	/**
	 *
	 * @param String rateofc
	 */
	public void setRateofc(String rateofc) {
		this.rateofc = rateofc;
	}
	
	/**
	 * 
	 * @return String rateofc
	 */
	public String getRateofc() {
		return this.rateofc;
	}
	
	/**
	 *
	 * @param String ppdTotal
	 */
	public void setPpdTotal(String ppdTotal) {
		this.ppdTotal = ppdTotal;
	}
	
	/**
	 * 
	 * @return String ppdTotal
	 */
	public String getPpdTotal() {
		return this.ppdTotal;
	}
	
	/**
	 *
	 * @param String cctTotal
	 */
	public void setCctTotal(String cctTotal) {
		this.cctTotal = cctTotal;
	}
	
	/**
	 * 
	 * @return String cctTotal
	 */
	public String getCctTotal() {
		return this.cctTotal;
	}
	
	/**
	 *
	 * @param String totalCur
	 */
	public void setTotalCur(String totalCur) {
		this.totalCur = totalCur;
	}
	
	/**
	 * 
	 * @return String totalCur
	 */
	public String getTotalCur() {
		return this.totalCur;
	}
	
	/**
	 *
	 * @param String ppdUsd
	 */
	public void setPpdUsd(String ppdUsd) {
		this.ppdUsd = ppdUsd;
	}
	
	/**
	 * 
	 * @return String ppdUsd
	 */
	public String getPpdUsd() {
		return this.ppdUsd;
	}
	
	/**
	 *
	 * @param String cctUsd
	 */
	public void setCctUsd(String cctUsd) {
		this.cctUsd = cctUsd;
	}
	
	/**
	 * 
	 * @return String cctUsd
	 */
	public String getCctUsd() {
		return this.cctUsd;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbConVvd(JSPUtil.getParameter(request, prefix + "ib_con_vvd", ""));
		setObConVvd(JSPUtil.getParameter(request, prefix + "ob_con_vvd", ""));
		setPort(JSPUtil.getParameter(request, prefix + "port", ""));
		setBlnbr(JSPUtil.getParameter(request, prefix + "blnbr", ""));
		setPpdofc(JSPUtil.getParameter(request, prefix + "ppdofc", ""));
		setPpdPayer(JSPUtil.getParameter(request, prefix + "ppd_payer", ""));
		setCctofc(JSPUtil.getParameter(request, prefix + "cctofc", ""));
		setCctPayer(JSPUtil.getParameter(request, prefix + "cct_payer", ""));
		setThdofc(JSPUtil.getParameter(request, prefix + "thdofc", ""));
		setScno(JSPUtil.getParameter(request, prefix + "scno", ""));
		setRfano(JSPUtil.getParameter(request, prefix + "rfano", ""));
		setFctype(JSPUtil.getParameter(request, prefix + "fctype", ""));
		setRate(JSPUtil.getParameter(request, prefix + "rate", ""));
		setRevenueton(JSPUtil.getParameter(request, prefix + "revenueton", ""));
		setPpd(JSPUtil.getParameter(request, prefix + "ppd", ""));
		setCct(JSPUtil.getParameter(request, prefix + "cct", ""));
		setCurrencycode(JSPUtil.getParameter(request, prefix + "currencycode", ""));
		setExchrate(JSPUtil.getParameter(request, prefix + "exchrate", ""));
		setTariff(JSPUtil.getParameter(request, prefix + "tariff", ""));
		setPertype(JSPUtil.getParameter(request, prefix + "pertype", ""));
		setRateofc(JSPUtil.getParameter(request, prefix + "rateofc", ""));
		setPpdTotal(JSPUtil.getParameter(request, prefix + "ppd_total", ""));
		setCctTotal(JSPUtil.getParameter(request, prefix + "cct_total", ""));
		setTotalCur(JSPUtil.getParameter(request, prefix + "total_cur", ""));
		setPpdUsd(JSPUtil.getParameter(request, prefix + "ppd_usd", ""));
		setCctUsd(JSPUtil.getParameter(request, prefix + "cct_usd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SitProBlLdfBlFrtVO[]
	 */
	public SitProBlLdfBlFrtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SitProBlLdfBlFrtVO[]
	 */
	public SitProBlLdfBlFrtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SitProBlLdfBlFrtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibConVvd = (JSPUtil.getParameter(request, prefix	+ "ib_con_vvd", length));
			String[] obConVvd = (JSPUtil.getParameter(request, prefix	+ "ob_con_vvd", length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] blnbr = (JSPUtil.getParameter(request, prefix	+ "blnbr", length));
			String[] ppdofc = (JSPUtil.getParameter(request, prefix	+ "ppdofc", length));
			String[] ppdPayer = (JSPUtil.getParameter(request, prefix	+ "ppd_payer", length));
			String[] cctofc = (JSPUtil.getParameter(request, prefix	+ "cctofc", length));
			String[] cctPayer = (JSPUtil.getParameter(request, prefix	+ "cct_payer", length));
			String[] thdofc = (JSPUtil.getParameter(request, prefix	+ "thdofc", length));
			String[] scno = (JSPUtil.getParameter(request, prefix	+ "scno", length));
			String[] rfano = (JSPUtil.getParameter(request, prefix	+ "rfano", length));
			String[] fctype = (JSPUtil.getParameter(request, prefix	+ "fctype", length));
			String[] rate = (JSPUtil.getParameter(request, prefix	+ "rate", length));
			String[] revenueton = (JSPUtil.getParameter(request, prefix	+ "revenueton", length));
			String[] ppd = (JSPUtil.getParameter(request, prefix	+ "ppd", length));
			String[] cct = (JSPUtil.getParameter(request, prefix	+ "cct", length));
			String[] currencycode = (JSPUtil.getParameter(request, prefix	+ "currencycode", length));
			String[] exchrate = (JSPUtil.getParameter(request, prefix	+ "exchrate", length));
			String[] tariff = (JSPUtil.getParameter(request, prefix	+ "tariff", length));
			String[] pertype = (JSPUtil.getParameter(request, prefix	+ "pertype", length));
			String[] rateofc = (JSPUtil.getParameter(request, prefix	+ "rateofc", length));
			String[] ppdTotal = (JSPUtil.getParameter(request, prefix	+ "ppd_total", length));
			String[] cctTotal = (JSPUtil.getParameter(request, prefix	+ "cct_total", length));
			String[] totalCur = (JSPUtil.getParameter(request, prefix	+ "total_cur", length));
			String[] ppdUsd = (JSPUtil.getParameter(request, prefix	+ "ppd_usd", length));
			String[] cctUsd = (JSPUtil.getParameter(request, prefix	+ "cct_usd", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new SitProBlLdfBlFrtVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null) 
					model.setVvd(vvd[i]);
				if (ibConVvd[i] != null) 
					model.setIbConVvd(ibConVvd[i]);
				if (obConVvd[i] != null) 
					model.setObConVvd(obConVvd[i]);
				if (port[i] != null) 
					model.setPort(port[i]);
				if (blnbr[i] != null) 
					model.setBlnbr(blnbr[i]);
				if (ppdofc[i] != null) 
					model.setPpdofc(ppdofc[i]);
				if (ppdPayer[i] != null) 
					model.setPpdPayer(ppdPayer[i]);
				if (cctofc[i] != null) 
					model.setCctofc(cctofc[i]);
				if (cctPayer[i] != null) 
					model.setCctPayer(cctPayer[i]);
				if (thdofc[i] != null) 
					model.setThdofc(thdofc[i]);
				if (scno[i] != null) 
					model.setScno(scno[i]);
				if (rfano[i] != null) 
					model.setRfano(rfano[i]);
				if (fctype[i] != null) 
					model.setFctype(fctype[i]);
				if (rate[i] != null) 
					model.setRate(rate[i]);
				if (revenueton[i] != null) 
					model.setRevenueton(revenueton[i]);
				if (ppd[i] != null) 
					model.setPpd(ppd[i]);
				if (cct[i] != null) 
					model.setCct(cct[i]);
				if (currencycode[i] != null) 
					model.setCurrencycode(currencycode[i]);
				if (exchrate[i] != null) 
					model.setExchrate(exchrate[i]);
				if (tariff[i] != null) 
					model.setTariff(tariff[i]);
				if (pertype[i] != null) 
					model.setPertype(pertype[i]);
				if (rateofc[i] != null) 
					model.setRateofc(rateofc[i]);
				if (ppdTotal[i] != null) 
					model.setPpdTotal(ppdTotal[i]);
				if (cctTotal[i] != null) 
					model.setCctTotal(cctTotal[i]);
				if (totalCur[i] != null) 
					model.setTotalCur(totalCur[i]);
				if (ppdUsd[i] != null) 
					model.setPpdUsd(ppdUsd[i]);
				if (cctUsd[i] != null) 
					model.setCctUsd(cctUsd[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSitProBlLdfBlFrtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SitProBlLdfBlFrtVO[]
	 */
	public SitProBlLdfBlFrtVO[] getSitProBlLdfBlFrtVOs(){
		SitProBlLdfBlFrtVO[] vos = (SitProBlLdfBlFrtVO[])models.toArray(new SitProBlLdfBlFrtVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibConVvd = this.ibConVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obConVvd = this.obConVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blnbr = this.blnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdofc = this.ppdofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdPayer = this.ppdPayer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctofc = this.cctofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctPayer = this.cctPayer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thdofc = this.thdofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scno = this.scno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfano = this.rfano .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctype = this.fctype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate = this.rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revenueton = this.revenueton .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppd = this.ppd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct = this.cct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currencycode = this.currencycode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exchrate = this.exchrate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tariff = this.tariff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pertype = this.pertype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateofc = this.rateofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdTotal = this.ppdTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctTotal = this.cctTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCur = this.totalCur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdUsd = this.ppdUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctUsd = this.cctUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}