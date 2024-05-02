/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EurCmVO.java
*@FileTitle : EurCmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.27
*@LastModifier : 윤태승
*@LastVersion : 1.0
* 2012.09.27 윤태승 
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
 * @author 윤태승
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EurCmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EurCmVO> models = new ArrayList<EurCmVO>();
	
	/* Column Info */
	private String dMark = null;
	/* Column Info */
	private String dHtsCd = null;
	/* Column Info */
	private String mfItmNo = null;
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
	private String dCmdt = null;
	/* Column Info */
	private String dWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EurCmVO() {}

	public EurCmVO(String ibflag, String pagerows, String dCmdt, String dPunit, String dPkg, String dWgt, String dMeas, String dDesc, String dMark, String mfItmNo, String dHtsCd, String dHsCd, String dNcmCd) {
		this.dMark = dMark;
		this.dHtsCd = dHtsCd;
		this.mfItmNo = mfItmNo;
		this.dNcmCd = dNcmCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.dMeas = dMeas;
		this.dHsCd = dHsCd;
		this.dDesc = dDesc;
		this.dPunit = dPunit;
		this.dPkg = dPkg;
		this.dCmdt = dCmdt;
		this.dWgt = dWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("d_mark", getDMark());
		this.hashColumns.put("d_hts_cd", getDHtsCd());
		this.hashColumns.put("mf_itm_no", getMfItmNo());
		this.hashColumns.put("d_ncm_cd", getDNcmCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("d_meas", getDMeas());
		this.hashColumns.put("d_hs_cd", getDHsCd());
		this.hashColumns.put("d_desc", getDDesc());
		this.hashColumns.put("d_punit", getDPunit());
		this.hashColumns.put("d_pkg", getDPkg());
		this.hashColumns.put("d_cmdt", getDCmdt());
		this.hashColumns.put("d_wgt", getDWgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("d_mark", "dMark");
		this.hashFields.put("d_hts_cd", "dHtsCd");
		this.hashFields.put("mf_itm_no", "mfItmNo");
		this.hashFields.put("d_ncm_cd", "dNcmCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("d_meas", "dMeas");
		this.hashFields.put("d_hs_cd", "dHsCd");
		this.hashFields.put("d_desc", "dDesc");
		this.hashFields.put("d_punit", "dPunit");
		this.hashFields.put("d_pkg", "dPkg");
		this.hashFields.put("d_cmdt", "dCmdt");
		this.hashFields.put("d_wgt", "dWgt");
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
	 * @return mfItmNo
	 */
	public String getMfItmNo() {
		return this.mfItmNo;
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
	 * @return dCmdt
	 */
	public String getDCmdt() {
		return this.dCmdt;
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
	 * @param mfItmNo
	 */
	public void setMfItmNo(String mfItmNo) {
		this.mfItmNo = mfItmNo;
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
	 * @param dCmdt
	 */
	public void setDCmdt(String dCmdt) {
		this.dCmdt = dCmdt;
	}
	
	/**
	 * Column Info
	 * @param dWgt
	 */
	public void setDWgt(String dWgt) {
		this.dWgt = dWgt;
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
		setMfItmNo(JSPUtil.getParameter(request, prefix + "mf_itm_no", ""));
		setDNcmCd(JSPUtil.getParameter(request, prefix + "d_ncm_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDMeas(JSPUtil.getParameter(request, prefix + "d_meas", ""));
		setDHsCd(JSPUtil.getParameter(request, prefix + "d_hs_cd", ""));
		setDDesc(JSPUtil.getParameter(request, prefix + "d_desc", ""));
		setDPunit(JSPUtil.getParameter(request, prefix + "d_punit", ""));
		setDPkg(JSPUtil.getParameter(request, prefix + "d_pkg", ""));
		setDCmdt(JSPUtil.getParameter(request, prefix + "d_cmdt", ""));
		setDWgt(JSPUtil.getParameter(request, prefix + "d_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurCmVO[]
	 */
	public EurCmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurCmVO[]
	 */
	public EurCmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EurCmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dMark = (JSPUtil.getParameter(request, prefix	+ "d_mark", length));
			String[] dHtsCd = (JSPUtil.getParameter(request, prefix	+ "d_hts_cd", length));
			String[] mfItmNo = (JSPUtil.getParameter(request, prefix	+ "mf_itm_no", length));
			String[] dNcmCd = (JSPUtil.getParameter(request, prefix	+ "d_ncm_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dMeas = (JSPUtil.getParameter(request, prefix	+ "d_meas", length));
			String[] dHsCd = (JSPUtil.getParameter(request, prefix	+ "d_hs_cd", length));
			String[] dDesc = (JSPUtil.getParameter(request, prefix	+ "d_desc", length));
			String[] dPunit = (JSPUtil.getParameter(request, prefix	+ "d_punit", length));
			String[] dPkg = (JSPUtil.getParameter(request, prefix	+ "d_pkg", length));
			String[] dCmdt = (JSPUtil.getParameter(request, prefix	+ "d_cmdt", length));
			String[] dWgt = (JSPUtil.getParameter(request, prefix	+ "d_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new EurCmVO();
				if (dMark[i] != null)
					model.setDMark(dMark[i]);
				if (dHtsCd[i] != null)
					model.setDHtsCd(dHtsCd[i]);
				if (mfItmNo[i] != null)
					model.setMfItmNo(mfItmNo[i]);
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
				if (dCmdt[i] != null)
					model.setDCmdt(dCmdt[i]);
				if (dWgt[i] != null)
					model.setDWgt(dWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEurCmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EurCmVO[]
	 */
	public EurCmVO[] getEurCmVOs(){
		EurCmVO[] vos = (EurCmVO[])models.toArray(new EurCmVO[models.size()]);
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
		this.mfItmNo = this.mfItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dNcmCd = this.dNcmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dMeas = this.dMeas .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dHsCd = this.dHsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dDesc = this.dDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dPunit = this.dPunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dPkg = this.dPkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCmdt = this.dCmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dWgt = this.dWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
