/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SitProBlLdfBlPckVO.java
*@FileTitle : SitProBlLdfBlPckVO
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
public class SitProBlLdfBlPckVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SitProBlLdfBlPckVO> models = new ArrayList<SitProBlLdfBlPckVO>();
	
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
	private String blpol = null;

	/* Column Info */
	private String blpod = null;

	/* Column Info */
	private String blpor = null;

	/* Column Info */
	private String bldel = null;

	/* Column Info */
	private String cntrnbr = null;

	/* Column Info */
	private String dCmdt = null;

	/* Column Info */
	private String dPunit = null;

	/* Column Info */
	private String dPkg = null;

	/* Column Info */
	private String dWgt = null;

	/* Column Info */
	private String dMeas = null;

	/* Column Info */
	private String dDesc = null;

	/* Column Info */
	private String dCtmsRef = null;

	/* Column Info */
	private String dHtsCd = null;

	/* Column Info */
	private String dHsCd = null;

	/* Column Info */
	private String dNcmCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SitProBlLdfBlPckVO() {}

	public SitProBlLdfBlPckVO(String ibflag, String pagerows, String vvd, String ibConVvd, String obConVvd, String port, String blnbr, String blpol, String blpod, String blpor, String bldel, String cntrnbr, String dCmdt, String dPunit, String dPkg, String dWgt, String dMeas, String dDesc, String dCtmsRef, String dHtsCd, String dHsCd, String dNcmCd) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibConVvd = ibConVvd;
		this.obConVvd = obConVvd;
		this.port = port;
		this.blnbr = blnbr;
		this.blpol = blpol;
		this.blpod = blpod;
		this.blpor = blpor;
		this.bldel = bldel;
		this.cntrnbr = cntrnbr;
		this.dCmdt = dCmdt;
		this.dPunit = dPunit;
		this.dPkg = dPkg;
		this.dWgt = dWgt;
		this.dMeas = dMeas;
		this.dDesc = dDesc;
		this.dCtmsRef = dCtmsRef;
		this.dHtsCd = dHtsCd;
		this.dHsCd = dHsCd;
		this.dNcmCd = dNcmCd;
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
		this.hashColumns.put("blpol", getBlpol());
		this.hashColumns.put("blpod", getBlpod());
		this.hashColumns.put("blpor", getBlpor());
		this.hashColumns.put("bldel", getBldel());
		this.hashColumns.put("cntrnbr", getCntrnbr());
		this.hashColumns.put("d_cmdt", getDCmdt());
		this.hashColumns.put("d_punit", getDPunit());
		this.hashColumns.put("d_pkg", getDPkg());
		this.hashColumns.put("d_wgt", getDWgt());
		this.hashColumns.put("d_meas", getDMeas());
		this.hashColumns.put("d_desc", getDDesc());
		this.hashColumns.put("d_ctms_ref", getDCtmsRef());
		this.hashColumns.put("d_hts_cd", getDHtsCd());
		this.hashColumns.put("d_hs_cd", getDHsCd());
		this.hashColumns.put("d_ncm_cd", getDNcmCd());
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
		this.hashFields.put("blpol", "blpol");
		this.hashFields.put("blpod", "blpod");
		this.hashFields.put("blpor", "blpor");
		this.hashFields.put("bldel", "bldel");
		this.hashFields.put("cntrnbr", "cntrnbr");
		this.hashFields.put("d_cmdt", "dCmdt");
		this.hashFields.put("d_punit", "dPunit");
		this.hashFields.put("d_pkg", "dPkg");
		this.hashFields.put("d_wgt", "dWgt");
		this.hashFields.put("d_meas", "dMeas");
		this.hashFields.put("d_desc", "dDesc");
		this.hashFields.put("d_ctms_ref", "dCtmsRef");
		this.hashFields.put("d_hts_cd", "dHtsCd");
		this.hashFields.put("d_hs_cd", "dHsCd");
		this.hashFields.put("d_ncm_cd", "dNcmCd");
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
	 * @param String dCmdt
	 */
	public void setDCmdt(String dCmdt) {
		this.dCmdt = dCmdt;
	}
	
	/**
	 * 
	 * @return String dCmdt
	 */
	public String getDCmdt() {
		return this.dCmdt;
	}
	
	/**
	 *
	 * @param String dPunit
	 */
	public void setDPunit(String dPunit) {
		this.dPunit = dPunit;
	}
	
	/**
	 * 
	 * @return String dPunit
	 */
	public String getDPunit() {
		return this.dPunit;
	}
	
	/**
	 *
	 * @param String dPkg
	 */
	public void setDPkg(String dPkg) {
		this.dPkg = dPkg;
	}
	
	/**
	 * 
	 * @return String dPkg
	 */
	public String getDPkg() {
		return this.dPkg;
	}
	
	/**
	 *
	 * @param String dWgt
	 */
	public void setDWgt(String dWgt) {
		this.dWgt = dWgt;
	}
	
	/**
	 * 
	 * @return String dWgt
	 */
	public String getDWgt() {
		return this.dWgt;
	}
	
	/**
	 *
	 * @param String dMeas
	 */
	public void setDMeas(String dMeas) {
		this.dMeas = dMeas;
	}
	
	/**
	 * 
	 * @return String dMeas
	 */
	public String getDMeas() {
		return this.dMeas;
	}
	
	/**
	 *
	 * @param String dDesc
	 */
	public void setDDesc(String dDesc) {
		this.dDesc = dDesc;
	}
	
	/**
	 * 
	 * @return String dDesc
	 */
	public String getDDesc() {
		return this.dDesc;
	}
	
	/**
	 *
	 * @param String dCtmsRef
	 */
	public void setDCtmsRef(String dCtmsRef) {
		this.dCtmsRef = dCtmsRef;
	}
	
	/**
	 * 
	 * @return String dCtmsRef
	 */
	public String getDCtmsRef() {
		return this.dCtmsRef;
	}
	
	/**
	 *
	 * @param String dHtsCd
	 */
	public void setDHtsCd(String dHtsCd) {
		this.dHtsCd = dHtsCd;
	}
	
	/**
	 * 
	 * @return String dHtsCd
	 */
	public String getDHtsCd() {
		return this.dHtsCd;
	}
	
	/**
	 *
	 * @param String dHsCd
	 */
	public void setDHsCd(String dHsCd) {
		this.dHsCd = dHsCd;
	}
	
	/**
	 * 
	 * @return String dHsCd
	 */
	public String getDHsCd() {
		return this.dHsCd;
	}
	
	/**
	 *
	 * @param String dNcmCd
	 */
	public void setDNcmCd(String dNcmCd) {
		this.dNcmCd = dNcmCd;
	}
	
	/**
	 * 
	 * @return String dNcmCd
	 */
	public String getDNcmCd() {
		return this.dNcmCd;
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
		setBlpol(JSPUtil.getParameter(request, prefix + "blpol", ""));
		setBlpod(JSPUtil.getParameter(request, prefix + "blpod", ""));
		setBlpor(JSPUtil.getParameter(request, prefix + "blpor", ""));
		setBldel(JSPUtil.getParameter(request, prefix + "bldel", ""));
		setCntrnbr(JSPUtil.getParameter(request, prefix + "cntrnbr", ""));
		setDCmdt(JSPUtil.getParameter(request, prefix + "d_cmdt", ""));
		setDPunit(JSPUtil.getParameter(request, prefix + "d_punit", ""));
		setDPkg(JSPUtil.getParameter(request, prefix + "d_pkg", ""));
		setDWgt(JSPUtil.getParameter(request, prefix + "d_wgt", ""));
		setDMeas(JSPUtil.getParameter(request, prefix + "d_meas", ""));
		setDDesc(JSPUtil.getParameter(request, prefix + "d_desc", ""));
		setDCtmsRef(JSPUtil.getParameter(request, prefix + "d_ctms_ref", ""));
		setDHtsCd(JSPUtil.getParameter(request, prefix + "d_hts_cd", ""));
		setDHsCd(JSPUtil.getParameter(request, prefix + "d_hs_cd", ""));
		setDNcmCd(JSPUtil.getParameter(request, prefix + "d_ncm_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SitProBlLdfBlPckVO[]
	 */
	public SitProBlLdfBlPckVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SitProBlLdfBlPckVO[]
	 */
	public SitProBlLdfBlPckVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SitProBlLdfBlPckVO model = null;
		
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
			String[] blpol = (JSPUtil.getParameter(request, prefix	+ "blpol", length));
			String[] blpod = (JSPUtil.getParameter(request, prefix	+ "blpod", length));
			String[] blpor = (JSPUtil.getParameter(request, prefix	+ "blpor", length));
			String[] bldel = (JSPUtil.getParameter(request, prefix	+ "bldel", length));
			String[] cntrnbr = (JSPUtil.getParameter(request, prefix	+ "cntrnbr", length));
			String[] dCmdt = (JSPUtil.getParameter(request, prefix	+ "d_cmdt", length));
			String[] dPunit = (JSPUtil.getParameter(request, prefix	+ "d_punit", length));
			String[] dPkg = (JSPUtil.getParameter(request, prefix	+ "d_pkg", length));
			String[] dWgt = (JSPUtil.getParameter(request, prefix	+ "d_wgt", length));
			String[] dMeas = (JSPUtil.getParameter(request, prefix	+ "d_meas", length));
			String[] dDesc = (JSPUtil.getParameter(request, prefix	+ "d_desc", length));
			String[] dCtmsRef = (JSPUtil.getParameter(request, prefix	+ "d_ctms_ref", length));
			String[] dHtsCd = (JSPUtil.getParameter(request, prefix	+ "d_hts_cd", length));
			String[] dHsCd = (JSPUtil.getParameter(request, prefix	+ "d_hs_cd", length));
			String[] dNcmCd = (JSPUtil.getParameter(request, prefix	+ "d_ncm_cd", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new SitProBlLdfBlPckVO();
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
				if (blpol[i] != null) 
					model.setBlpol(blpol[i]);
				if (blpod[i] != null) 
					model.setBlpod(blpod[i]);
				if (blpor[i] != null) 
					model.setBlpor(blpor[i]);
				if (bldel[i] != null) 
					model.setBldel(bldel[i]);
				if (cntrnbr[i] != null) 
					model.setCntrnbr(cntrnbr[i]);
				if (dCmdt[i] != null) 
					model.setDCmdt(dCmdt[i]);
				if (dPunit[i] != null) 
					model.setDPunit(dPunit[i]);
				if (dPkg[i] != null) 
					model.setDPkg(dPkg[i]);
				if (dWgt[i] != null) 
					model.setDWgt(dWgt[i]);
				if (dMeas[i] != null) 
					model.setDMeas(dMeas[i]);
				if (dDesc[i] != null) 
					model.setDDesc(dDesc[i]);
				if (dCtmsRef[i] != null) 
					model.setDCtmsRef(dCtmsRef[i]);
				if (dHtsCd[i] != null) 
					model.setDHtsCd(dHtsCd[i]);
				if (dHsCd[i] != null) 
					model.setDHsCd(dHsCd[i]);
				if (dNcmCd[i] != null) 
					model.setDNcmCd(dNcmCd[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSitProBlLdfBlPckVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SitProBlLdfBlPckVO[]
	 */
	public SitProBlLdfBlPckVO[] getSitProBlLdfBlPckVOs(){
		SitProBlLdfBlPckVO[] vos = (SitProBlLdfBlPckVO[])models.toArray(new SitProBlLdfBlPckVO[models.size()]);
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
		this.blpol = this.blpol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpod = this.blpod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpor = this.blpor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bldel = this.bldel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrnbr = this.cntrnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCmdt = this.dCmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dPunit = this.dPunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dPkg = this.dPkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dWgt = this.dWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dMeas = this.dMeas .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dDesc = this.dDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCtmsRef = this.dCtmsRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dHtsCd = this.dHtsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dHsCd = this.dHsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dNcmCd = this.dNcmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}