/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SitProBlLdfBlMkNoVO.java
*@FileTitle : SitProBlLdfBlMkNoVO
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
public class SitProBlLdfBlMkNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SitProBlLdfBlMkNoVO> models = new ArrayList<SitProBlLdfBlMkNoVO>();
	
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
	private String blnbr = null;

	/* Column Info */
	private String blpol = null;

	/* Column Info */
	private String blpod = null;

	/* Column Info */
	private String blpor = null;

	/* Column Info */
	private String bldel = null;

	/* Column Info */
	private String cmdesc = null;

	/* Column Info */
	private String localIpi = null;

	/* Column Info */
	private String eqrel = null;

	/* Column Info */
	private String eqpickdt = null;

	/* Column Info */
	private String eqrtn = null;

	/* Column Info */
	private String cntrnbr = null;

	/* Column Info */
	private String dMark = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SitProBlLdfBlMkNoVO() {}

	public SitProBlLdfBlMkNoVO(String ibflag, String pagerows, String vvd, String ibConVvd, String obConVvd, String blnbr, String blpol, String blpod, String blpor, String bldel, String cmdesc, String localIpi, String eqrel, String eqpickdt, String eqrtn, String cntrnbr, String dMark) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibConVvd = ibConVvd;
		this.obConVvd = obConVvd;
		this.blnbr = blnbr;
		this.blpol = blpol;
		this.blpod = blpod;
		this.blpor = blpor;
		this.bldel = bldel;
		this.cmdesc = cmdesc;
		this.localIpi = localIpi;
		this.eqrel = eqrel;
		this.eqpickdt = eqpickdt;
		this.eqrtn = eqrtn;
		this.cntrnbr = cntrnbr;
		this.dMark = dMark;
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
		this.hashColumns.put("blnbr", getBlnbr());
		this.hashColumns.put("blpol", getBlpol());
		this.hashColumns.put("blpod", getBlpod());
		this.hashColumns.put("blpor", getBlpor());
		this.hashColumns.put("bldel", getBldel());
		this.hashColumns.put("cmdesc", getCmdesc());
		this.hashColumns.put("local_ipi", getLocalIpi());
		this.hashColumns.put("eqrel", getEqrel());
		this.hashColumns.put("eqpickdt", getEqpickdt());
		this.hashColumns.put("eqrtn", getEqrtn());
		this.hashColumns.put("cntrnbr", getCntrnbr());
		this.hashColumns.put("d_mark", getDMark());
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
		this.hashFields.put("blnbr", "blnbr");
		this.hashFields.put("blpol", "blpol");
		this.hashFields.put("blpod", "blpod");
		this.hashFields.put("blpor", "blpor");
		this.hashFields.put("bldel", "bldel");
		this.hashFields.put("cmdesc", "cmdesc");
		this.hashFields.put("local_ipi", "localIpi");
		this.hashFields.put("eqrel", "eqrel");
		this.hashFields.put("eqpickdt", "eqpickdt");
		this.hashFields.put("eqrtn", "eqrtn");
		this.hashFields.put("cntrnbr", "cntrnbr");
		this.hashFields.put("d_mark", "dMark");
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
	 * @param String blpol
	 */
	public void setBlpol(String blpol) {
		this.blpol = blpol;
	}
	
	/**
	 * 
	 * @return String blpol
	 */
	public String getBlpol() {
		return this.blpol;
	}
	
	/**
	 *
	 * @param String blpod
	 */
	public void setBlpod(String blpod) {
		this.blpod = blpod;
	}
	
	/**
	 * 
	 * @return String blpod
	 */
	public String getBlpod() {
		return this.blpod;
	}
	
	/**
	 *
	 * @param String blpor
	 */
	public void setBlpor(String blpor) {
		this.blpor = blpor;
	}
	
	/**
	 * 
	 * @return String blpor
	 */
	public String getBlpor() {
		return this.blpor;
	}
	
	/**
	 *
	 * @param String bldel
	 */
	public void setBldel(String bldel) {
		this.bldel = bldel;
	}
	
	/**
	 * 
	 * @return String bldel
	 */
	public String getBldel() {
		return this.bldel;
	}
	
	/**
	 *
	 * @param String cmdesc
	 */
	public void setCmdesc(String cmdesc) {
		this.cmdesc = cmdesc;
	}
	
	/**
	 * 
	 * @return String cmdesc
	 */
	public String getCmdesc() {
		return this.cmdesc;
	}
	
	/**
	 *
	 * @param String localIpi
	 */
	public void setLocalIpi(String localIpi) {
		this.localIpi = localIpi;
	}
	
	/**
	 * 
	 * @return String localIpi
	 */
	public String getLocalIpi() {
		return this.localIpi;
	}
	
	/**
	 *
	 * @param String eqrel
	 */
	public void setEqrel(String eqrel) {
		this.eqrel = eqrel;
	}
	
	/**
	 * 
	 * @return String eqrel
	 */
	public String getEqrel() {
		return this.eqrel;
	}
	
	/**
	 *
	 * @param String eqpickdt
	 */
	public void setEqpickdt(String eqpickdt) {
		this.eqpickdt = eqpickdt;
	}
	
	/**
	 * 
	 * @return String eqpickdt
	 */
	public String getEqpickdt() {
		return this.eqpickdt;
	}
	
	/**
	 *
	 * @param String eqrtn
	 */
	public void setEqrtn(String eqrtn) {
		this.eqrtn = eqrtn;
	}
	
	/**
	 * 
	 * @return String eqrtn
	 */
	public String getEqrtn() {
		return this.eqrtn;
	}
	
	/**
	 *
	 * @param String cntrnbr
	 */
	public void setCntrnbr(String cntrnbr) {
		this.cntrnbr = cntrnbr;
	}
	
	/**
	 * 
	 * @return String cntrnbr
	 */
	public String getCntrnbr() {
		return this.cntrnbr;
	}
	
	/**
	 *
	 * @param String dMark
	 */
	public void setDMark(String dMark) {
		this.dMark = dMark;
	}
	
	/**
	 * 
	 * @return String dMark
	 */
	public String getDMark() {
		return this.dMark;
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
		setBlnbr(JSPUtil.getParameter(request, prefix + "blnbr", ""));
		setBlpol(JSPUtil.getParameter(request, prefix + "blpol", ""));
		setBlpod(JSPUtil.getParameter(request, prefix + "blpod", ""));
		setBlpor(JSPUtil.getParameter(request, prefix + "blpor", ""));
		setBldel(JSPUtil.getParameter(request, prefix + "bldel", ""));
		setCmdesc(JSPUtil.getParameter(request, prefix + "cmdesc", ""));
		setLocalIpi(JSPUtil.getParameter(request, prefix + "local_ipi", ""));
		setEqrel(JSPUtil.getParameter(request, prefix + "eqrel", ""));
		setEqpickdt(JSPUtil.getParameter(request, prefix + "eqpickdt", ""));
		setEqrtn(JSPUtil.getParameter(request, prefix + "eqrtn", ""));
		setCntrnbr(JSPUtil.getParameter(request, prefix + "cntrnbr", ""));
		setDMark(JSPUtil.getParameter(request, prefix + "d_mark", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SitProBlLdfBlMkNoVO[]
	 */
	public SitProBlLdfBlMkNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SitProBlLdfBlMkNoVO[]
	 */
	public SitProBlLdfBlMkNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SitProBlLdfBlMkNoVO model = null;
		
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
			String[] blnbr = (JSPUtil.getParameter(request, prefix	+ "blnbr", length));
			String[] blpol = (JSPUtil.getParameter(request, prefix	+ "blpol", length));
			String[] blpod = (JSPUtil.getParameter(request, prefix	+ "blpod", length));
			String[] blpor = (JSPUtil.getParameter(request, prefix	+ "blpor", length));
			String[] bldel = (JSPUtil.getParameter(request, prefix	+ "bldel", length));
			String[] cmdesc = (JSPUtil.getParameter(request, prefix	+ "cmdesc", length));
			String[] localIpi = (JSPUtil.getParameter(request, prefix	+ "local_ipi", length));
			String[] eqrel = (JSPUtil.getParameter(request, prefix	+ "eqrel", length));
			String[] eqpickdt = (JSPUtil.getParameter(request, prefix	+ "eqpickdt", length));
			String[] eqrtn = (JSPUtil.getParameter(request, prefix	+ "eqrtn", length));
			String[] cntrnbr = (JSPUtil.getParameter(request, prefix	+ "cntrnbr", length));
			String[] dMark = (JSPUtil.getParameter(request, prefix	+ "d_mark", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new SitProBlLdfBlMkNoVO();
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
				if (blnbr[i] != null) 
					model.setBlnbr(blnbr[i]);
				if (blpol[i] != null) 
					model.setBlpol(blpol[i]);
				if (blpod[i] != null) 
					model.setBlpod(blpod[i]);
				if (blpor[i] != null) 
					model.setBlpor(blpor[i]);
				if (bldel[i] != null) 
					model.setBldel(bldel[i]);
				if (cmdesc[i] != null) 
					model.setCmdesc(cmdesc[i]);
				if (localIpi[i] != null) 
					model.setLocalIpi(localIpi[i]);
				if (eqrel[i] != null) 
					model.setEqrel(eqrel[i]);
				if (eqpickdt[i] != null) 
					model.setEqpickdt(eqpickdt[i]);
				if (eqrtn[i] != null) 
					model.setEqrtn(eqrtn[i]);
				if (cntrnbr[i] != null) 
					model.setCntrnbr(cntrnbr[i]);
				if (dMark[i] != null) 
					model.setDMark(dMark[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSitProBlLdfBlMkNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SitProBlLdfBlMkNoVO[]
	 */
	public SitProBlLdfBlMkNoVO[] getSitProBlLdfBlMkNoVOs(){
		SitProBlLdfBlMkNoVO[] vos = (SitProBlLdfBlMkNoVO[])models.toArray(new SitProBlLdfBlMkNoVO[models.size()]);
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
		this.blnbr = this.blnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpol = this.blpol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpod = this.blpod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpor = this.blpor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bldel = this.bldel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdesc = this.cmdesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localIpi = this.localIpi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqrel = this.eqrel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqpickdt = this.eqpickdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqrtn = this.eqrtn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrnbr = this.cntrnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dMark = this.dMark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}