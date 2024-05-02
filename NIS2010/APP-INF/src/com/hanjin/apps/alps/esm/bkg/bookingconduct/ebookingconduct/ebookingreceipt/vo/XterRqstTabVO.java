/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : XterRqstTabVO.java
*@FileTitle : XterRqstTabVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.26  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class XterRqstTabVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<XterRqstTabVO> models = new ArrayList<XterRqstTabVO>();
	
	/* Column Info */
	private String xterBb = null;
	/* Column Info */
	private String xterCust = null;
	/* Column Info */
	private String xterMnd = null;
	/* Column Info */
	private String alpsDg = null;
	/* Column Info */
	private String xterAwk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String alpsCust = null;
	/* Column Info */
	private String xterHbl2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String xterHbl1 = null;
	/* Column Info */
	private String alpsMnd = null;
	/* Column Info */
	private String alpsCntr = null;
	/* Column Info */
	private String alpsBb = null;
	/* Column Info */
	private String alpsAwk = null;
	/* Column Info */
	private String xterDg = null;
	/* Column Info */
	private String xterTro = null;
	/* Column Info */
	private String alpsTro = null;
	/* Column Info */
	private String alpsCm = null;
	/* Column Info */
	private String alpsBkg = null;
	/* Column Info */
	private String xterRf = null;
	/* Column Info */
	private String alpsRf = null;
	/* Column Info */
	private String xterBkg = null;
	/* Column Info */
	private String xterCntr = null;
	/* Column Info */
	private String xterCm = null;
	/* Column Info */
	private String alpsHbl1 = null;
	/* Column Info */
	private String alpsHbl2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public XterRqstTabVO() {}

	public XterRqstTabVO(String ibflag, String pagerows, String alpsBkg, String alpsCust, String alpsCntr, String alpsCm, String alpsMnd, String alpsTro, String alpsRf, String alpsDg, String alpsAwk, String alpsBb, String alpsHbl1, String alpsHbl2, String xterBkg, String xterCust, String xterCntr, String xterCm, String xterMnd, String xterTro, String xterRf, String xterDg, String xterAwk, String xterBb, String xterHbl1, String xterHbl2) {
		this.xterBb = xterBb;
		this.xterCust = xterCust;
		this.xterMnd = xterMnd;
		this.alpsDg = alpsDg;
		this.xterAwk = xterAwk;
		this.pagerows = pagerows;
		this.alpsCust = alpsCust;
		this.xterHbl2 = xterHbl2;
		this.ibflag = ibflag;
		this.xterHbl1 = xterHbl1;
		this.alpsMnd = alpsMnd;
		this.alpsCntr = alpsCntr;
		this.alpsBb = alpsBb;
		this.alpsAwk = alpsAwk;
		this.xterDg = xterDg;
		this.xterTro = xterTro;
		this.alpsTro = alpsTro;
		this.alpsCm = alpsCm;
		this.alpsBkg = alpsBkg;
		this.xterRf = xterRf;
		this.alpsRf = alpsRf;
		this.xterBkg = xterBkg;
		this.xterCntr = xterCntr;
		this.xterCm = xterCm;
		this.alpsHbl1 = alpsHbl1;
		this.alpsHbl2 = alpsHbl2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xter_bb", getXterBb());
		this.hashColumns.put("xter_cust", getXterCust());
		this.hashColumns.put("xter_mnd", getXterMnd());
		this.hashColumns.put("alps_dg", getAlpsDg());
		this.hashColumns.put("xter_awk", getXterAwk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("alps_cust", getAlpsCust());
		this.hashColumns.put("xter_hbl2", getXterHbl2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("xter_hbl1", getXterHbl1());
		this.hashColumns.put("alps_mnd", getAlpsMnd());
		this.hashColumns.put("alps_cntr", getAlpsCntr());
		this.hashColumns.put("alps_bb", getAlpsBb());
		this.hashColumns.put("alps_awk", getAlpsAwk());
		this.hashColumns.put("xter_dg", getXterDg());
		this.hashColumns.put("xter_tro", getXterTro());
		this.hashColumns.put("alps_tro", getAlpsTro());
		this.hashColumns.put("alps_cm", getAlpsCm());
		this.hashColumns.put("alps_bkg", getAlpsBkg());
		this.hashColumns.put("xter_rf", getXterRf());
		this.hashColumns.put("alps_rf", getAlpsRf());
		this.hashColumns.put("xter_bkg", getXterBkg());
		this.hashColumns.put("xter_cntr", getXterCntr());
		this.hashColumns.put("xter_cm", getXterCm());
		this.hashColumns.put("alps_hbl1", getAlpsHbl1());
		this.hashColumns.put("alps_hbl2", getAlpsHbl2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xter_bb", "xterBb");
		this.hashFields.put("xter_cust", "xterCust");
		this.hashFields.put("xter_mnd", "xterMnd");
		this.hashFields.put("alps_dg", "alpsDg");
		this.hashFields.put("xter_awk", "xterAwk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("alps_cust", "alpsCust");
		this.hashFields.put("xter_hbl2", "xterHbl2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("xter_hbl1", "xterHbl1");
		this.hashFields.put("alps_mnd", "alpsMnd");
		this.hashFields.put("alps_cntr", "alpsCntr");
		this.hashFields.put("alps_bb", "alpsBb");
		this.hashFields.put("alps_awk", "alpsAwk");
		this.hashFields.put("xter_dg", "xterDg");
		this.hashFields.put("xter_tro", "xterTro");
		this.hashFields.put("alps_tro", "alpsTro");
		this.hashFields.put("alps_cm", "alpsCm");
		this.hashFields.put("alps_bkg", "alpsBkg");
		this.hashFields.put("xter_rf", "xterRf");
		this.hashFields.put("alps_rf", "alpsRf");
		this.hashFields.put("xter_bkg", "xterBkg");
		this.hashFields.put("xter_cntr", "xterCntr");
		this.hashFields.put("xter_cm", "xterCm");
		this.hashFields.put("alps_hbl1", "alpsHbl1");
		this.hashFields.put("alps_hbl2", "alpsHbl2");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return xterBb
	 */
	public String getXterBb() {
		return this.xterBb;
	}
	
	/**
	 * Column Info
	 * @return xterCust
	 */
	public String getXterCust() {
		return this.xterCust;
	}
	
	/**
	 * Column Info
	 * @return xterMnd
	 */
	public String getXterMnd() {
		return this.xterMnd;
	}
	
	/**
	 * Column Info
	 * @return alpsDg
	 */
	public String getAlpsDg() {
		return this.alpsDg;
	}
	
	/**
	 * Column Info
	 * @return xterAwk
	 */
	public String getXterAwk() {
		return this.xterAwk;
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
	 * @return alpsCust
	 */
	public String getAlpsCust() {
		return this.alpsCust;
	}
	
	/**
	 * Column Info
	 * @return xterHbl2
	 */
	public String getXterHbl2() {
		return this.xterHbl2;
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
	 * @return xterHbl1
	 */
	public String getXterHbl1() {
		return this.xterHbl1;
	}
	
	/**
	 * Column Info
	 * @return alpsMnd
	 */
	public String getAlpsMnd() {
		return this.alpsMnd;
	}
	
	/**
	 * Column Info
	 * @return alpsCntr
	 */
	public String getAlpsCntr() {
		return this.alpsCntr;
	}
	
	/**
	 * Column Info
	 * @return alpsBb
	 */
	public String getAlpsBb() {
		return this.alpsBb;
	}
	
	/**
	 * Column Info
	 * @return alpsAwk
	 */
	public String getAlpsAwk() {
		return this.alpsAwk;
	}
	
	/**
	 * Column Info
	 * @return xterDg
	 */
	public String getXterDg() {
		return this.xterDg;
	}
	
	/**
	 * Column Info
	 * @return xterTro
	 */
	public String getXterTro() {
		return this.xterTro;
	}
	
	/**
	 * Column Info
	 * @return alpsTro
	 */
	public String getAlpsTro() {
		return this.alpsTro;
	}
	
	/**
	 * Column Info
	 * @return alpsCm
	 */
	public String getAlpsCm() {
		return this.alpsCm;
	}
	
	/**
	 * Column Info
	 * @return alpsBkg
	 */
	public String getAlpsBkg() {
		return this.alpsBkg;
	}
	
	/**
	 * Column Info
	 * @return xterRf
	 */
	public String getXterRf() {
		return this.xterRf;
	}
	
	/**
	 * Column Info
	 * @return alpsRf
	 */
	public String getAlpsRf() {
		return this.alpsRf;
	}
	
	/**
	 * Column Info
	 * @return xterBkg
	 */
	public String getXterBkg() {
		return this.xterBkg;
	}
	
	/**
	 * Column Info
	 * @return xterCntr
	 */
	public String getXterCntr() {
		return this.xterCntr;
	}
	
	/**
	 * Column Info
	 * @return xterCm
	 */
	public String getXterCm() {
		return this.xterCm;
	}
	
	/**
	 * Column Info
	 * @return alpsHbl1
	 */
	public String getAlpsHbl1() {
		return this.alpsHbl1;
	}
	
	/**
	 * Column Info
	 * @return alpsHbl2
	 */
	public String getAlpsHbl2() {
		return this.alpsHbl2;
	}
	

	/**
	 * Column Info
	 * @param xterBb
	 */
	public void setXterBb(String xterBb) {
		this.xterBb = xterBb;
	}
	
	/**
	 * Column Info
	 * @param xterCust
	 */
	public void setXterCust(String xterCust) {
		this.xterCust = xterCust;
	}
	
	/**
	 * Column Info
	 * @param xterMnd
	 */
	public void setXterMnd(String xterMnd) {
		this.xterMnd = xterMnd;
	}
	
	/**
	 * Column Info
	 * @param alpsDg
	 */
	public void setAlpsDg(String alpsDg) {
		this.alpsDg = alpsDg;
	}
	
	/**
	 * Column Info
	 * @param xterAwk
	 */
	public void setXterAwk(String xterAwk) {
		this.xterAwk = xterAwk;
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
	 * @param alpsCust
	 */
	public void setAlpsCust(String alpsCust) {
		this.alpsCust = alpsCust;
	}
	
	/**
	 * Column Info
	 * @param xterHbl2
	 */
	public void setXterHbl2(String xterHbl2) {
		this.xterHbl2 = xterHbl2;
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
	 * @param xterHbl1
	 */
	public void setXterHbl1(String xterHbl1) {
		this.xterHbl1 = xterHbl1;
	}
	
	/**
	 * Column Info
	 * @param alpsMnd
	 */
	public void setAlpsMnd(String alpsMnd) {
		this.alpsMnd = alpsMnd;
	}
	
	/**
	 * Column Info
	 * @param alpsCntr
	 */
	public void setAlpsCntr(String alpsCntr) {
		this.alpsCntr = alpsCntr;
	}
	
	/**
	 * Column Info
	 * @param alpsBb
	 */
	public void setAlpsBb(String alpsBb) {
		this.alpsBb = alpsBb;
	}
	
	/**
	 * Column Info
	 * @param alpsAwk
	 */
	public void setAlpsAwk(String alpsAwk) {
		this.alpsAwk = alpsAwk;
	}
	
	/**
	 * Column Info
	 * @param xterDg
	 */
	public void setXterDg(String xterDg) {
		this.xterDg = xterDg;
	}
	
	/**
	 * Column Info
	 * @param xterTro
	 */
	public void setXterTro(String xterTro) {
		this.xterTro = xterTro;
	}
	
	/**
	 * Column Info
	 * @param alpsTro
	 */
	public void setAlpsTro(String alpsTro) {
		this.alpsTro = alpsTro;
	}
	
	/**
	 * Column Info
	 * @param alpsCm
	 */
	public void setAlpsCm(String alpsCm) {
		this.alpsCm = alpsCm;
	}
	
	/**
	 * Column Info
	 * @param alpsBkg
	 */
	public void setAlpsBkg(String alpsBkg) {
		this.alpsBkg = alpsBkg;
	}
	
	/**
	 * Column Info
	 * @param xterRf
	 */
	public void setXterRf(String xterRf) {
		this.xterRf = xterRf;
	}
	
	/**
	 * Column Info
	 * @param alpsRf
	 */
	public void setAlpsRf(String alpsRf) {
		this.alpsRf = alpsRf;
	}
	
	/**
	 * Column Info
	 * @param xterBkg
	 */
	public void setXterBkg(String xterBkg) {
		this.xterBkg = xterBkg;
	}
	
	/**
	 * Column Info
	 * @param xterCntr
	 */
	public void setXterCntr(String xterCntr) {
		this.xterCntr = xterCntr;
	}
	
	/**
	 * Column Info
	 * @param xterCm
	 */
	public void setXterCm(String xterCm) {
		this.xterCm = xterCm;
	}
	
	/**
	 * Column Info
	 * @param alpsHbl1
	 */
	public void setAlpsHbl1(String alpsHbl1) {
		this.alpsHbl1 = alpsHbl1;
	}
	
	/**
	 * Column Info
	 * @param alpsHbl2
	 */
	public void setAlpsHbl2(String alpsHbl2) {
		this.alpsHbl2 = alpsHbl2;
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
		setXterBb(JSPUtil.getParameter(request, prefix + "xter_bb", ""));
		setXterCust(JSPUtil.getParameter(request, prefix + "xter_cust", ""));
		setXterMnd(JSPUtil.getParameter(request, prefix + "xter_mnd", ""));
		setAlpsDg(JSPUtil.getParameter(request, prefix + "alps_dg", ""));
		setXterAwk(JSPUtil.getParameter(request, prefix + "xter_awk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAlpsCust(JSPUtil.getParameter(request, prefix + "alps_cust", ""));
		setXterHbl2(JSPUtil.getParameter(request, prefix + "xter_hbl2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setXterHbl1(JSPUtil.getParameter(request, prefix + "xter_hbl1", ""));
		setAlpsMnd(JSPUtil.getParameter(request, prefix + "alps_mnd", ""));
		setAlpsCntr(JSPUtil.getParameter(request, prefix + "alps_cntr", ""));
		setAlpsBb(JSPUtil.getParameter(request, prefix + "alps_bb", ""));
		setAlpsAwk(JSPUtil.getParameter(request, prefix + "alps_awk", ""));
		setXterDg(JSPUtil.getParameter(request, prefix + "xter_dg", ""));
		setXterTro(JSPUtil.getParameter(request, prefix + "xter_tro", ""));
		setAlpsTro(JSPUtil.getParameter(request, prefix + "alps_tro", ""));
		setAlpsCm(JSPUtil.getParameter(request, prefix + "alps_cm", ""));
		setAlpsBkg(JSPUtil.getParameter(request, prefix + "alps_bkg", ""));
		setXterRf(JSPUtil.getParameter(request, prefix + "xter_rf", ""));
		setAlpsRf(JSPUtil.getParameter(request, prefix + "alps_rf", ""));
		setXterBkg(JSPUtil.getParameter(request, prefix + "xter_bkg", ""));
		setXterCntr(JSPUtil.getParameter(request, prefix + "xter_cntr", ""));
		setXterCm(JSPUtil.getParameter(request, prefix + "xter_cm", ""));
		setAlpsHbl1(JSPUtil.getParameter(request, prefix + "alps_hbl1", ""));
		setAlpsHbl2(JSPUtil.getParameter(request, prefix + "alps_hbl2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XterRqstTabVO[]
	 */
	public XterRqstTabVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return XterRqstTabVO[]
	 */
	public XterRqstTabVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		XterRqstTabVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xterBb = (JSPUtil.getParameter(request, prefix	+ "xter_bb", length));
			String[] xterCust = (JSPUtil.getParameter(request, prefix	+ "xter_cust", length));
			String[] xterMnd = (JSPUtil.getParameter(request, prefix	+ "xter_mnd", length));
			String[] alpsDg = (JSPUtil.getParameter(request, prefix	+ "alps_dg", length));
			String[] xterAwk = (JSPUtil.getParameter(request, prefix	+ "xter_awk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] alpsCust = (JSPUtil.getParameter(request, prefix	+ "alps_cust", length));
			String[] xterHbl2 = (JSPUtil.getParameter(request, prefix	+ "xter_hbl2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] xterHbl1 = (JSPUtil.getParameter(request, prefix	+ "xter_hbl1", length));
			String[] alpsMnd = (JSPUtil.getParameter(request, prefix	+ "alps_mnd", length));
			String[] alpsCntr = (JSPUtil.getParameter(request, prefix	+ "alps_cntr", length));
			String[] alpsBb = (JSPUtil.getParameter(request, prefix	+ "alps_bb", length));
			String[] alpsAwk = (JSPUtil.getParameter(request, prefix	+ "alps_awk", length));
			String[] xterDg = (JSPUtil.getParameter(request, prefix	+ "xter_dg", length));
			String[] xterTro = (JSPUtil.getParameter(request, prefix	+ "xter_tro", length));
			String[] alpsTro = (JSPUtil.getParameter(request, prefix	+ "alps_tro", length));
			String[] alpsCm = (JSPUtil.getParameter(request, prefix	+ "alps_cm", length));
			String[] alpsBkg = (JSPUtil.getParameter(request, prefix	+ "alps_bkg", length));
			String[] xterRf = (JSPUtil.getParameter(request, prefix	+ "xter_rf", length));
			String[] alpsRf = (JSPUtil.getParameter(request, prefix	+ "alps_rf", length));
			String[] xterBkg = (JSPUtil.getParameter(request, prefix	+ "xter_bkg", length));
			String[] xterCntr = (JSPUtil.getParameter(request, prefix	+ "xter_cntr", length));
			String[] xterCm = (JSPUtil.getParameter(request, prefix	+ "xter_cm", length));
			String[] alpsHbl1 = (JSPUtil.getParameter(request, prefix	+ "alps_hbl1", length));
			String[] alpsHbl2 = (JSPUtil.getParameter(request, prefix	+ "alps_hbl2", length));
			
			for (int i = 0; i < length; i++) {
				model = new XterRqstTabVO();
				if (xterBb[i] != null)
					model.setXterBb(xterBb[i]);
				if (xterCust[i] != null)
					model.setXterCust(xterCust[i]);
				if (xterMnd[i] != null)
					model.setXterMnd(xterMnd[i]);
				if (alpsDg[i] != null)
					model.setAlpsDg(alpsDg[i]);
				if (xterAwk[i] != null)
					model.setXterAwk(xterAwk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (alpsCust[i] != null)
					model.setAlpsCust(alpsCust[i]);
				if (xterHbl2[i] != null)
					model.setXterHbl2(xterHbl2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (xterHbl1[i] != null)
					model.setXterHbl1(xterHbl1[i]);
				if (alpsMnd[i] != null)
					model.setAlpsMnd(alpsMnd[i]);
				if (alpsCntr[i] != null)
					model.setAlpsCntr(alpsCntr[i]);
				if (alpsBb[i] != null)
					model.setAlpsBb(alpsBb[i]);
				if (alpsAwk[i] != null)
					model.setAlpsAwk(alpsAwk[i]);
				if (xterDg[i] != null)
					model.setXterDg(xterDg[i]);
				if (xterTro[i] != null)
					model.setXterTro(xterTro[i]);
				if (alpsTro[i] != null)
					model.setAlpsTro(alpsTro[i]);
				if (alpsCm[i] != null)
					model.setAlpsCm(alpsCm[i]);
				if (alpsBkg[i] != null)
					model.setAlpsBkg(alpsBkg[i]);
				if (xterRf[i] != null)
					model.setXterRf(xterRf[i]);
				if (alpsRf[i] != null)
					model.setAlpsRf(alpsRf[i]);
				if (xterBkg[i] != null)
					model.setXterBkg(xterBkg[i]);
				if (xterCntr[i] != null)
					model.setXterCntr(xterCntr[i]);
				if (xterCm[i] != null)
					model.setXterCm(xterCm[i]);
				if (alpsHbl1[i] != null)
					model.setAlpsHbl1(alpsHbl1[i]);
				if (alpsHbl2[i] != null)
					model.setAlpsHbl2(alpsHbl2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getXterRqstTabVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return XterRqstTabVO[]
	 */
	public XterRqstTabVO[] getXterRqstTabVOs(){
		XterRqstTabVO[] vos = (XterRqstTabVO[])models.toArray(new XterRqstTabVO[models.size()]);
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
		this.xterBb = this.xterBb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterCust = this.xterCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterMnd = this.xterMnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alpsDg = this.alpsDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterAwk = this.xterAwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alpsCust = this.alpsCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterHbl2 = this.xterHbl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterHbl1 = this.xterHbl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alpsMnd = this.alpsMnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alpsCntr = this.alpsCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alpsBb = this.alpsBb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alpsAwk = this.alpsAwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterDg = this.xterDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterTro = this.xterTro .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alpsTro = this.alpsTro .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alpsCm = this.alpsCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alpsBkg = this.alpsBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRf = this.xterRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alpsRf = this.alpsRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterBkg = this.xterBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterCntr = this.xterCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterCm = this.xterCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alpsHbl1 = this.alpsHbl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alpsHbl2 = this.alpsHbl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
