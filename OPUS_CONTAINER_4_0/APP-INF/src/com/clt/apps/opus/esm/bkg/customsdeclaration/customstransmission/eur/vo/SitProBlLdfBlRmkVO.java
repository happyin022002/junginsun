/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SitProBlLdfBlRmkVO.java
*@FileTitle : SitProBlLdfBlRmkVO
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
public class SitProBlLdfBlRmkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SitProBlLdfBlRmkVO> models = new ArrayList<SitProBlLdfBlRmkVO>();
	
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
	private String desc = null;

	/* Column Info */
	private String markno = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SitProBlLdfBlRmkVO() {}

	public SitProBlLdfBlRmkVO(String ibflag, String pagerows, String vvd, String ibConVvd, String obConVvd, String blnbr, String blpol, String blpod, String blpor, String bldel, String desc, String markno) {
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
		this.desc = desc;
		this.markno = markno;
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
		this.hashColumns.put("desc", getDesc());
		this.hashColumns.put("markno", getMarkno());
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
		this.hashFields.put("desc", "desc");
		this.hashFields.put("markno", "markno");
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
	 * @param String desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	/**
	 * 
	 * @return String desc
	 */
	public String getDesc() {
		return this.desc;
	}
	
	/**
	 *
	 * @param String markno
	 */
	public void setMarkno(String markno) {
		this.markno = markno;
	}
	
	/**
	 * 
	 * @return String markno
	 */
	public String getMarkno() {
		return this.markno;
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
		setDesc(JSPUtil.getParameter(request, prefix + "desc", ""));
		setMarkno(JSPUtil.getParameter(request, prefix + "markno", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SitProBlLdfBlRmkVO[]
	 */
	public SitProBlLdfBlRmkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SitProBlLdfBlRmkVO[]
	 */
	public SitProBlLdfBlRmkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SitProBlLdfBlRmkVO model = null;
		
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
			String[] desc = (JSPUtil.getParameter(request, prefix	+ "desc", length));
			String[] markno = (JSPUtil.getParameter(request, prefix	+ "markno", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new SitProBlLdfBlRmkVO();
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
				if (desc[i] != null) 
					model.setDesc(desc[i]);
				if (markno[i] != null) 
					model.setMarkno(markno[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSitProBlLdfBlRmkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SitProBlLdfBlRmkVO[]
	 */
	public SitProBlLdfBlRmkVO[] getSitProBlLdfBlRmkVOs(){
		SitProBlLdfBlRmkVO[] vos = (SitProBlLdfBlRmkVO[])models.toArray(new SitProBlLdfBlRmkVO[models.size()]);
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
		this.desc = this.desc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.markno = this.markno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}