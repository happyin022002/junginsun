/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : XterRqstTabVO.java
*@FileTitle : XterRqstTabVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.11.26 민동진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 민동진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class XterRqstTabVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<XterRqstTabVO> models = new ArrayList<XterRqstTabVO>();
	
	/* Column Info */
	private String xterTro = null;
	/* Column Info */
	private String opusTro = null;
	/* Column Info */
	private String opusCm = null;
	/* Column Info */
	private String opusBkg = null;
	/* Column Info */
	private String xterCust = null;
	/* Column Info */
	private String xterRf = null;
	/* Column Info */
	private String xterMnd = null;
	/* Column Info */
	private String xterAwk = null;
	/* Column Info */
	private String opusDg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String opusCust = null;
	/* Column Info */
	private String xterHbl2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String xterHbl1 = null;
	/* Column Info */
	private String opusRf = null;
	/* Column Info */
	private String xterBkg = null;
	/* Column Info */
	private String xterCntr = null;
	/* Column Info */
	private String opusCntr = null;
	/* Column Info */
	private String opusMnd = null;
	/* Column Info */
	private String xterCm = null;
	/* Column Info */
	private String opusHbl1 = null;
	/* Column Info */
	private String opusHbl2 = null;
	/* Column Info */
	private String opusAwk = null;
	/* Column Info */
	private String xterDg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public XterRqstTabVO() {}

	public XterRqstTabVO(String ibflag, String pagerows, String opusBkg, String xterBkg, String opusCust, String xterCust, String opusCntr, String xterCntr, String opusCm, String xterCm, String opusMnd, String xterMnd, String opusTro, String xterTro, String opusRf, String xterRf, String opusDg, String xterDg, String opusAwk, String xterAwk, String opusHbl1, String xterHbl1, String opusHbl2, String xterHbl2) {
		this.xterTro = xterTro;
		this.opusTro = opusTro;
		this.opusCm = opusCm;
		this.opusBkg = opusBkg;
		this.xterCust = xterCust;
		this.xterRf = xterRf;
		this.xterMnd = xterMnd;
		this.xterAwk = xterAwk;
		this.opusDg = opusDg;
		this.pagerows = pagerows;
		this.opusCust = opusCust;
		this.xterHbl2 = xterHbl2;
		this.ibflag = ibflag;
		this.xterHbl1 = xterHbl1;
		this.opusRf = opusRf;
		this.xterBkg = xterBkg;
		this.xterCntr = xterCntr;
		this.opusCntr = opusCntr;
		this.opusMnd = opusMnd;
		this.xterCm = xterCm;
		this.opusHbl1 = opusHbl1;
		this.opusHbl2 = opusHbl2;
		this.opusAwk = opusAwk;
		this.xterDg = xterDg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xter_tro", getXterTro());
		this.hashColumns.put("opus_tro", getOpusTro());
		this.hashColumns.put("opus_cm", getOpusCm());
		this.hashColumns.put("opus_bkg", getOpusBkg());
		this.hashColumns.put("xter_cust", getXterCust());
		this.hashColumns.put("xter_rf", getXterRf());
		this.hashColumns.put("xter_mnd", getXterMnd());
		this.hashColumns.put("xter_awk", getXterAwk());
		this.hashColumns.put("opus_dg", getOpusDg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("opus_cust", getOpusCust());
		this.hashColumns.put("xter_hbl2", getXterHbl2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("xter_hbl1", getXterHbl1());
		this.hashColumns.put("opus_rf", getOpusRf());
		this.hashColumns.put("xter_bkg", getXterBkg());
		this.hashColumns.put("xter_cntr", getXterCntr());
		this.hashColumns.put("opus_cntr", getOpusCntr());
		this.hashColumns.put("opus_mnd", getOpusMnd());
		this.hashColumns.put("xter_cm", getXterCm());
		this.hashColumns.put("opus_hbl1", getOpusHbl1());
		this.hashColumns.put("opus_hbl2", getOpusHbl2());
		this.hashColumns.put("opus_awk", getOpusAwk());
		this.hashColumns.put("xter_dg", getXterDg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xter_tro", "xterTro");
		this.hashFields.put("opus_tro", "opusTro");
		this.hashFields.put("opus_cm", "opusCm");
		this.hashFields.put("opus_bkg", "opusBkg");
		this.hashFields.put("xter_cust", "xterCust");
		this.hashFields.put("xter_rf", "xterRf");
		this.hashFields.put("xter_mnd", "xterMnd");
		this.hashFields.put("xter_awk", "xterAwk");
		this.hashFields.put("opus_dg", "opusDg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("opus_cust", "opusCust");
		this.hashFields.put("xter_hbl2", "xterHbl2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("xter_hbl1", "xterHbl1");
		this.hashFields.put("opus_rf", "opusRf");
		this.hashFields.put("xter_bkg", "xterBkg");
		this.hashFields.put("xter_cntr", "xterCntr");
		this.hashFields.put("opus_cntr", "opusCntr");
		this.hashFields.put("opus_mnd", "opusMnd");
		this.hashFields.put("xter_cm", "xterCm");
		this.hashFields.put("opus_hbl1", "opusHbl1");
		this.hashFields.put("opus_hbl2", "opusHbl2");
		this.hashFields.put("opus_awk", "opusAwk");
		this.hashFields.put("xter_dg", "xterDg");
		return this.hashFields;
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
	 * @return opusTro
	 */
	public String getOpusTro() {
		return this.opusTro;
	}
	
	/**
	 * Column Info
	 * @return opusCm
	 */
	public String getOpusCm() {
		return this.opusCm;
	}
	
	/**
	 * Column Info
	 * @return opusBkg
	 */
	public String getOpusBkg() {
		return this.opusBkg;
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
	 * @return xterRf
	 */
	public String getXterRf() {
		return this.xterRf;
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
	 * @return xterAwk
	 */
	public String getXterAwk() {
		return this.xterAwk;
	}
	
	/**
	 * Column Info
	 * @return opusDg
	 */
	public String getOpusDg() {
		return this.opusDg;
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
	 * @return opusCust
	 */
	public String getOpusCust() {
		return this.opusCust;
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
	 * @return opusRf
	 */
	public String getOpusRf() {
		return this.opusRf;
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
	 * @return opusCntr
	 */
	public String getOpusCntr() {
		return this.opusCntr;
	}
	
	/**
	 * Column Info
	 * @return opusMnd
	 */
	public String getOpusMnd() {
		return this.opusMnd;
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
	 * @return opusHbl1
	 */
	public String getOpusHbl1() {
		return this.opusHbl1;
	}
	
	/**
	 * Column Info
	 * @return opusHbl2
	 */
	public String getOpusHbl2() {
		return this.opusHbl2;
	}
	
	/**
	 * Column Info
	 * @return opusAwk
	 */
	public String getOpusAwk() {
		return this.opusAwk;
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
	 * @param xterTro
	 */
	public void setXterTro(String xterTro) {
		this.xterTro = xterTro;
	}
	
	/**
	 * Column Info
	 * @param opusTro
	 */
	public void setOpusTro(String opusTro) {
		this.opusTro = opusTro;
	}
	
	/**
	 * Column Info
	 * @param opusCm
	 */
	public void setOpusCm(String opusCm) {
		this.opusCm = opusCm;
	}
	
	/**
	 * Column Info
	 * @param opusBkg
	 */
	public void setOpusBkg(String opusBkg) {
		this.opusBkg = opusBkg;
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
	 * @param xterRf
	 */
	public void setXterRf(String xterRf) {
		this.xterRf = xterRf;
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
	 * @param xterAwk
	 */
	public void setXterAwk(String xterAwk) {
		this.xterAwk = xterAwk;
	}
	
	/**
	 * Column Info
	 * @param opusDg
	 */
	public void setOpusDg(String opusDg) {
		this.opusDg = opusDg;
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
	 * @param opusCust
	 */
	public void setOpusCust(String opusCust) {
		this.opusCust = opusCust;
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
	 * @param opusRf
	 */
	public void setOpusRf(String opusRf) {
		this.opusRf = opusRf;
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
	 * @param opusCntr
	 */
	public void setOpusCntr(String opusCntr) {
		this.opusCntr = opusCntr;
	}
	
	/**
	 * Column Info
	 * @param opusMnd
	 */
	public void setOpusMnd(String opusMnd) {
		this.opusMnd = opusMnd;
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
	 * @param opusHbl1
	 */
	public void setOpusHbl1(String opusHbl1) {
		this.opusHbl1 = opusHbl1;
	}
	
	/**
	 * Column Info
	 * @param opusHbl2
	 */
	public void setOpusHbl2(String opusHbl2) {
		this.opusHbl2 = opusHbl2;
	}
	
	/**
	 * Column Info
	 * @param opusAwk
	 */
	public void setOpusAwk(String opusAwk) {
		this.opusAwk = opusAwk;
	}
	
	/**
	 * Column Info
	 * @param xterDg
	 */
	public void setXterDg(String xterDg) {
		this.xterDg = xterDg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setXterTro(JSPUtil.getParameter(request, "xter_tro", ""));
		setOpusTro(JSPUtil.getParameter(request, "opus_tro", ""));
		setOpusCm(JSPUtil.getParameter(request, "opus_cm", ""));
		setOpusBkg(JSPUtil.getParameter(request, "opus_bkg", ""));
		setXterCust(JSPUtil.getParameter(request, "xter_cust", ""));
		setXterRf(JSPUtil.getParameter(request, "xter_rf", ""));
		setXterMnd(JSPUtil.getParameter(request, "xter_mnd", ""));
		setXterAwk(JSPUtil.getParameter(request, "xter_awk", ""));
		setOpusDg(JSPUtil.getParameter(request, "opus_dg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOpusCust(JSPUtil.getParameter(request, "opus_cust", ""));
		setXterHbl2(JSPUtil.getParameter(request, "xter_hbl2", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setXterHbl1(JSPUtil.getParameter(request, "xter_hbl1", ""));
		setOpusRf(JSPUtil.getParameter(request, "opus_rf", ""));
		setXterBkg(JSPUtil.getParameter(request, "xter_bkg", ""));
		setXterCntr(JSPUtil.getParameter(request, "xter_cntr", ""));
		setOpusCntr(JSPUtil.getParameter(request, "opus_cntr", ""));
		setOpusMnd(JSPUtil.getParameter(request, "opus_mnd", ""));
		setXterCm(JSPUtil.getParameter(request, "xter_cm", ""));
		setOpusHbl1(JSPUtil.getParameter(request, "opus_hbl1", ""));
		setOpusHbl2(JSPUtil.getParameter(request, "opus_hbl2", ""));
		setOpusAwk(JSPUtil.getParameter(request, "opus_awk", ""));
		setXterDg(JSPUtil.getParameter(request, "xter_dg", ""));
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
			String[] xterTro = (JSPUtil.getParameter(request, prefix	+ "xter_tro", length));
			String[] opusTro = (JSPUtil.getParameter(request, prefix	+ "opus_tro", length));
			String[] opusCm = (JSPUtil.getParameter(request, prefix	+ "opus_cm", length));
			String[] opusBkg = (JSPUtil.getParameter(request, prefix	+ "opus_bkg", length));
			String[] xterCust = (JSPUtil.getParameter(request, prefix	+ "xter_cust", length));
			String[] xterRf = (JSPUtil.getParameter(request, prefix	+ "xter_rf", length));
			String[] xterMnd = (JSPUtil.getParameter(request, prefix	+ "xter_mnd", length));
			String[] xterAwk = (JSPUtil.getParameter(request, prefix	+ "xter_awk", length));
			String[] opusDg = (JSPUtil.getParameter(request, prefix	+ "opus_dg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] opusCust = (JSPUtil.getParameter(request, prefix	+ "opus_cust", length));
			String[] xterHbl2 = (JSPUtil.getParameter(request, prefix	+ "xter_hbl2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] xterHbl1 = (JSPUtil.getParameter(request, prefix	+ "xter_hbl1", length));
			String[] opusRf = (JSPUtil.getParameter(request, prefix	+ "opus_rf", length));
			String[] xterBkg = (JSPUtil.getParameter(request, prefix	+ "xter_bkg", length));
			String[] xterCntr = (JSPUtil.getParameter(request, prefix	+ "xter_cntr", length));
			String[] opusCntr = (JSPUtil.getParameter(request, prefix	+ "opus_cntr", length));
			String[] opusMnd = (JSPUtil.getParameter(request, prefix	+ "opus_mnd", length));
			String[] xterCm = (JSPUtil.getParameter(request, prefix	+ "xter_cm", length));
			String[] opusHbl1 = (JSPUtil.getParameter(request, prefix	+ "opus_hbl1", length));
			String[] opusHbl2 = (JSPUtil.getParameter(request, prefix	+ "opus_hbl2", length));
			String[] opusAwk = (JSPUtil.getParameter(request, prefix	+ "opus_awk", length));
			String[] xterDg = (JSPUtil.getParameter(request, prefix	+ "xter_dg", length));
			
			for (int i = 0; i < length; i++) {
				model = new XterRqstTabVO();
				if (xterTro[i] != null)
					model.setXterTro(xterTro[i]);
				if (opusTro[i] != null)
					model.setOpusTro(opusTro[i]);
				if (opusCm[i] != null)
					model.setOpusCm(opusCm[i]);
				if (opusBkg[i] != null)
					model.setOpusBkg(opusBkg[i]);
				if (xterCust[i] != null)
					model.setXterCust(xterCust[i]);
				if (xterRf[i] != null)
					model.setXterRf(xterRf[i]);
				if (xterMnd[i] != null)
					model.setXterMnd(xterMnd[i]);
				if (xterAwk[i] != null)
					model.setXterAwk(xterAwk[i]);
				if (opusDg[i] != null)
					model.setOpusDg(opusDg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (opusCust[i] != null)
					model.setOpusCust(opusCust[i]);
				if (xterHbl2[i] != null)
					model.setXterHbl2(xterHbl2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (xterHbl1[i] != null)
					model.setXterHbl1(xterHbl1[i]);
				if (opusRf[i] != null)
					model.setOpusRf(opusRf[i]);
				if (xterBkg[i] != null)
					model.setXterBkg(xterBkg[i]);
				if (xterCntr[i] != null)
					model.setXterCntr(xterCntr[i]);
				if (opusCntr[i] != null)
					model.setOpusCntr(opusCntr[i]);
				if (opusMnd[i] != null)
					model.setOpusMnd(opusMnd[i]);
				if (xterCm[i] != null)
					model.setXterCm(xterCm[i]);
				if (opusHbl1[i] != null)
					model.setOpusHbl1(opusHbl1[i]);
				if (opusHbl2[i] != null)
					model.setOpusHbl2(opusHbl2[i]);
				if (opusAwk[i] != null)
					model.setOpusAwk(opusAwk[i]);
				if (xterDg[i] != null)
					model.setXterDg(xterDg[i]);
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
		this.xterTro = this.xterTro .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opusTro = this.opusTro .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opusCm = this.opusCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opusBkg = this.opusBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterCust = this.xterCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRf = this.xterRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterMnd = this.xterMnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterAwk = this.xterAwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opusDg = this.opusDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opusCust = this.opusCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterHbl2 = this.xterHbl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterHbl1 = this.xterHbl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opusRf = this.opusRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterBkg = this.xterBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterCntr = this.xterCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opusCntr = this.opusCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opusMnd = this.opusMnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterCm = this.xterCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opusHbl1 = this.opusHbl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opusHbl2 = this.opusHbl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opusAwk = this.opusAwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterDg = this.xterDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
