/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SitProCmInfoVO.java
*@FileTitle : SitProCmInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.05
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.05  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo;

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

public class SitProCmInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SitProCmInfoVO> models = new ArrayList<SitProCmInfoVO>();
	
	/* Column Info */
	private String dMark = null;
	/* Column Info */
	private String dHtsCd = null;
	/* Column Info */
	private String dCtmsRef = null;
	/* Column Info */
	private String dNcmCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dMeas = null;
	/* Column Info */
	private String dHsCd = null;
	/* Column Info */
	private String dDesc = null;
	/* Column Info */
	private String dPunit = null;
	/* Column Info */
	private String dPkg = null;
	/* Column Info */
	private String dWgt = null;
	/* Column Info */
	private String dCmdt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SitProCmInfoVO() {}

	public SitProCmInfoVO(String ibflag, String pagerows, String dMark, String dMeas, String dHsCd, String dDesc, String dPunit, String dPkg, String dCtmsRef, String dWgt, String dCmdt, String dHtsCd, String dNcmCd) {
		this.dMark = dMark;
		this.dHtsCd = dHtsCd;
		this.dCtmsRef = dCtmsRef;
		this.dNcmCd = dNcmCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.dMeas = dMeas;
		this.dHsCd = dHsCd;
		this.dDesc = dDesc;
		this.dPunit = dPunit;
		this.dPkg = dPkg;
		this.dWgt = dWgt;
		this.dCmdt = dCmdt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("d_mark", getDMark());
		this.hashColumns.put("d_hts_cd", getDHtsCd());
		this.hashColumns.put("d_ctms_ref", getDCtmsRef());
		this.hashColumns.put("d_ncm_cd", getDNcmCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("d_meas", getDMeas());
		this.hashColumns.put("d_hs_cd", getDHsCd());
		this.hashColumns.put("d_desc", getDDesc());
		this.hashColumns.put("d_punit", getDPunit());
		this.hashColumns.put("d_pkg", getDPkg());
		this.hashColumns.put("d_wgt", getDWgt());
		this.hashColumns.put("d_cmdt", getDCmdt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("d_mark", "dMark");
		this.hashFields.put("d_hts_cd", "dHtsCd");
		this.hashFields.put("d_ctms_ref", "dCtmsRef");
		this.hashFields.put("d_ncm_cd", "dNcmCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("d_meas", "dMeas");
		this.hashFields.put("d_hs_cd", "dHsCd");
		this.hashFields.put("d_desc", "dDesc");
		this.hashFields.put("d_punit", "dPunit");
		this.hashFields.put("d_pkg", "dPkg");
		this.hashFields.put("d_wgt", "dWgt");
		this.hashFields.put("d_cmdt", "dCmdt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dMark
	 */
	public String getDMark() {
		return this.dMark;
	}
	
	/**
	 * Column Info
	 * @return dHtsCd
	 */
	public String getDHtsCd() {
		return this.dHtsCd;
	}
	
	/**
	 * Column Info
	 * @return dCtmsRef
	 */
	public String getDCtmsRef() {
		return this.dCtmsRef;
	}
	
	/**
	 * Column Info
	 * @return dNcmCd
	 */
	public String getDNcmCd() {
		return this.dNcmCd;
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
	 * @return dMeas
	 */
	public String getDMeas() {
		return this.dMeas;
	}
	
	/**
	 * Column Info
	 * @return dHsCd
	 */
	public String getDHsCd() {
		return this.dHsCd;
	}
	
	/**
	 * Column Info
	 * @return dDesc
	 */
	public String getDDesc() {
		return this.dDesc;
	}
	
	/**
	 * Column Info
	 * @return dPunit
	 */
	public String getDPunit() {
		return this.dPunit;
	}
	
	/**
	 * Column Info
	 * @return dPkg
	 */
	public String getDPkg() {
		return this.dPkg;
	}
	
	/**
	 * Column Info
	 * @return dWgt
	 */
	public String getDWgt() {
		return this.dWgt;
	}
	
	/**
	 * Column Info
	 * @return dCmdt
	 */
	public String getDCmdt() {
		return this.dCmdt;
	}
	

	/**
	 * Column Info
	 * @param dMark
	 */
	public void setDMark(String dMark) {
		this.dMark = dMark;
	}
	
	/**
	 * Column Info
	 * @param dHtsCd
	 */
	public void setDHtsCd(String dHtsCd) {
		this.dHtsCd = dHtsCd;
	}
	
	/**
	 * Column Info
	 * @param dCtmsRef
	 */
	public void setDCtmsRef(String dCtmsRef) {
		this.dCtmsRef = dCtmsRef;
	}
	
	/**
	 * Column Info
	 * @param dNcmCd
	 */
	public void setDNcmCd(String dNcmCd) {
		this.dNcmCd = dNcmCd;
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
	 * @param dMeas
	 */
	public void setDMeas(String dMeas) {
		this.dMeas = dMeas;
	}
	
	/**
	 * Column Info
	 * @param dHsCd
	 */
	public void setDHsCd(String dHsCd) {
		this.dHsCd = dHsCd;
	}
	
	/**
	 * Column Info
	 * @param dDesc
	 */
	public void setDDesc(String dDesc) {
		this.dDesc = dDesc;
	}
	
	/**
	 * Column Info
	 * @param dPunit
	 */
	public void setDPunit(String dPunit) {
		this.dPunit = dPunit;
	}
	
	/**
	 * Column Info
	 * @param dPkg
	 */
	public void setDPkg(String dPkg) {
		this.dPkg = dPkg;
	}
	
	/**
	 * Column Info
	 * @param dWgt
	 */
	public void setDWgt(String dWgt) {
		this.dWgt = dWgt;
	}
	
	/**
	 * Column Info
	 * @param dCmdt
	 */
	public void setDCmdt(String dCmdt) {
		this.dCmdt = dCmdt;
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
		setDMark(JSPUtil.getParameter(request, prefix + "d_mark", ""));
		setDHtsCd(JSPUtil.getParameter(request, prefix + "d_hts_cd", ""));
		setDCtmsRef(JSPUtil.getParameter(request, prefix + "d_ctms_ref", ""));
		setDNcmCd(JSPUtil.getParameter(request, prefix + "d_ncm_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDMeas(JSPUtil.getParameter(request, prefix + "d_meas", ""));
		setDHsCd(JSPUtil.getParameter(request, prefix + "d_hs_cd", ""));
		setDDesc(JSPUtil.getParameter(request, prefix + "d_desc", ""));
		setDPunit(JSPUtil.getParameter(request, prefix + "d_punit", ""));
		setDPkg(JSPUtil.getParameter(request, prefix + "d_pkg", ""));
		setDWgt(JSPUtil.getParameter(request, prefix + "d_wgt", ""));
		setDCmdt(JSPUtil.getParameter(request, prefix + "d_cmdt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SitProCmInfoVO[]
	 */
	public SitProCmInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SitProCmInfoVO[]
	 */
	public SitProCmInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SitProCmInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dMark = (JSPUtil.getParameter(request, prefix	+ "d_mark", length));
			String[] dHtsCd = (JSPUtil.getParameter(request, prefix	+ "d_hts_cd", length));
			String[] dCtmsRef = (JSPUtil.getParameter(request, prefix	+ "d_ctms_ref", length));
			String[] dNcmCd = (JSPUtil.getParameter(request, prefix	+ "d_ncm_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dMeas = (JSPUtil.getParameter(request, prefix	+ "d_meas", length));
			String[] dHsCd = (JSPUtil.getParameter(request, prefix	+ "d_hs_cd", length));
			String[] dDesc = (JSPUtil.getParameter(request, prefix	+ "d_desc", length));
			String[] dPunit = (JSPUtil.getParameter(request, prefix	+ "d_punit", length));
			String[] dPkg = (JSPUtil.getParameter(request, prefix	+ "d_pkg", length));
			String[] dWgt = (JSPUtil.getParameter(request, prefix	+ "d_wgt", length));
			String[] dCmdt = (JSPUtil.getParameter(request, prefix	+ "d_cmdt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SitProCmInfoVO();
				if (dMark[i] != null)
					model.setDMark(dMark[i]);
				if (dHtsCd[i] != null)
					model.setDHtsCd(dHtsCd[i]);
				if (dCtmsRef[i] != null)
					model.setDCtmsRef(dCtmsRef[i]);
				if (dNcmCd[i] != null)
					model.setDNcmCd(dNcmCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dMeas[i] != null)
					model.setDMeas(dMeas[i]);
				if (dHsCd[i] != null)
					model.setDHsCd(dHsCd[i]);
				if (dDesc[i] != null)
					model.setDDesc(dDesc[i]);
				if (dPunit[i] != null)
					model.setDPunit(dPunit[i]);
				if (dPkg[i] != null)
					model.setDPkg(dPkg[i]);
				if (dWgt[i] != null)
					model.setDWgt(dWgt[i]);
				if (dCmdt[i] != null)
					model.setDCmdt(dCmdt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSitProCmInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SitProCmInfoVO[]
	 */
	public SitProCmInfoVO[] getSitProCmInfoVOs(){
		SitProCmInfoVO[] vos = (SitProCmInfoVO[])models.toArray(new SitProCmInfoVO[models.size()]);
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
		this.dMark = this.dMark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dHtsCd = this.dHtsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCtmsRef = this.dCtmsRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dNcmCd = this.dNcmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dMeas = this.dMeas .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dHsCd = this.dHsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dDesc = this.dDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dPunit = this.dPunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dPkg = this.dPkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dWgt = this.dWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCmdt = this.dCmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
