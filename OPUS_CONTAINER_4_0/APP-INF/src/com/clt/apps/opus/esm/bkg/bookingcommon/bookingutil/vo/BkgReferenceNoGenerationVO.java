/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgReferenceNoGenerationVO.java
*@FileTitle : BkgReferenceNoGenerationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.14
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.12.14 김기종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgReferenceNoGenerationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgReferenceNoGenerationVO> models = new ArrayList<BkgReferenceNoGenerationVO>();
	
	/* Column Info */
	private String dmyBkgNoForCustom = null;
	/* Column Info */
	private String usdNo = null;
	/* Column Info */
	private String cadNo = null;
	/* Column Info */
	private String rptNo = null;
	/* Column Info */
	private String krWhfDeclNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fsrNo = null;
	/* Column Info */
	private String uitNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String krWhfCsrNo = null;
	/* Column Info */
	private String caNo = null;
	/* Column Info */
	private String dnoNo = null;
	/* Column Info */
	private String srNo = null;
	/* Column Info */
	private String jpdNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgReferenceNoGenerationVO() {}

	public BkgReferenceNoGenerationVO(String ibflag, String pagerows, String rptNo, String jpdNo, String dnoNo, String caNo, String dmyBkgNoForCustom, String uitNo, String cadNo, String srNo, String krWhfDeclNo, String krWhfCsrNo, String fsrNo, String usdNo) {
		this.dmyBkgNoForCustom = dmyBkgNoForCustom;
		this.usdNo = usdNo;
		this.cadNo = cadNo;
		this.rptNo = rptNo;
		this.krWhfDeclNo = krWhfDeclNo;
		this.pagerows = pagerows;
		this.fsrNo = fsrNo;
		this.uitNo = uitNo;
		this.ibflag = ibflag;
		this.krWhfCsrNo = krWhfCsrNo;
		this.caNo = caNo;
		this.dnoNo = dnoNo;
		this.srNo = srNo;
		this.jpdNo = jpdNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dmy_bkg_no_for_custom", getDmyBkgNoForCustom());
		this.hashColumns.put("usd_no", getUsdNo());
		this.hashColumns.put("cad_no", getCadNo());
		this.hashColumns.put("rpt_no", getRptNo());
		this.hashColumns.put("kr_whf_decl_no", getKrWhfDeclNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fsr_no", getFsrNo());
		this.hashColumns.put("uit_no", getUitNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("kr_whf_csr_no", getKrWhfCsrNo());
		this.hashColumns.put("ca_no", getCaNo());
		this.hashColumns.put("dno_no", getDnoNo());
		this.hashColumns.put("sr_no", getSrNo());
		this.hashColumns.put("jpd_no", getJpdNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dmy_bkg_no_for_custom", "dmyBkgNoForCustom");
		this.hashFields.put("usd_no", "usdNo");
		this.hashFields.put("cad_no", "cadNo");
		this.hashFields.put("rpt_no", "rptNo");
		this.hashFields.put("kr_whf_decl_no", "krWhfDeclNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fsr_no", "fsrNo");
		this.hashFields.put("uit_no", "uitNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("kr_whf_csr_no", "krWhfCsrNo");
		this.hashFields.put("ca_no", "caNo");
		this.hashFields.put("dno_no", "dnoNo");
		this.hashFields.put("sr_no", "srNo");
		this.hashFields.put("jpd_no", "jpdNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dmyBkgNoForCustom
	 */
	public String getDmyBkgNoForCustom() {
		return this.dmyBkgNoForCustom;
	}
	
	/**
	 * Column Info
	 * @return usdNo
	 */
	public String getUsdNo() {
		return this.usdNo;
	}
	
	/**
	 * Column Info
	 * @return cadNo
	 */
	public String getCadNo() {
		return this.cadNo;
	}
	
	/**
	 * Column Info
	 * @return rptNo
	 */
	public String getRptNo() {
		return this.rptNo;
	}
	
	/**
	 * Column Info
	 * @return krWhfDeclNo
	 */
	public String getKrWhfDeclNo() {
		return this.krWhfDeclNo;
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
	 * @return fsrNo
	 */
	public String getFsrNo() {
		return this.fsrNo;
	}
	
	/**
	 * Column Info
	 * @return uitNo
	 */
	public String getUitNo() {
		return this.uitNo;
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
	 * @return krWhfCsrNo
	 */
	public String getKrWhfCsrNo() {
		return this.krWhfCsrNo;
	}
	
	/**
	 * Column Info
	 * @return caNo
	 */
	public String getCaNo() {
		return this.caNo;
	}
	
	/**
	 * Column Info
	 * @return dnoNo
	 */
	public String getDnoNo() {
		return this.dnoNo;
	}
	
	/**
	 * Column Info
	 * @return srNo
	 */
	public String getSrNo() {
		return this.srNo;
	}
	
	/**
	 * Column Info
	 * @return jpdNo
	 */
	public String getJpdNo() {
		return this.jpdNo;
	}
	

	/**
	 * Column Info
	 * @param dmyBkgNoForCustom
	 */
	public void setDmyBkgNoForCustom(String dmyBkgNoForCustom) {
		this.dmyBkgNoForCustom = dmyBkgNoForCustom;
	}
	
	/**
	 * Column Info
	 * @param usdNo
	 */
	public void setUsdNo(String usdNo) {
		this.usdNo = usdNo;
	}
	
	/**
	 * Column Info
	 * @param cadNo
	 */
	public void setCadNo(String cadNo) {
		this.cadNo = cadNo;
	}
	
	/**
	 * Column Info
	 * @param rptNo
	 */
	public void setRptNo(String rptNo) {
		this.rptNo = rptNo;
	}
	
	/**
	 * Column Info
	 * @param krWhfDeclNo
	 */
	public void setKrWhfDeclNo(String krWhfDeclNo) {
		this.krWhfDeclNo = krWhfDeclNo;
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
	 * @param fsrNo
	 */
	public void setFsrNo(String fsrNo) {
		this.fsrNo = fsrNo;
	}
	
	/**
	 * Column Info
	 * @param uitNo
	 */
	public void setUitNo(String uitNo) {
		this.uitNo = uitNo;
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
	 * @param krWhfCsrNo
	 */
	public void setKrWhfCsrNo(String krWhfCsrNo) {
		this.krWhfCsrNo = krWhfCsrNo;
	}
	
	/**
	 * Column Info
	 * @param caNo
	 */
	public void setCaNo(String caNo) {
		this.caNo = caNo;
	}
	
	/**
	 * Column Info
	 * @param dnoNo
	 */
	public void setDnoNo(String dnoNo) {
		this.dnoNo = dnoNo;
	}
	
	/**
	 * Column Info
	 * @param srNo
	 */
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	
	/**
	 * Column Info
	 * @param jpdNo
	 */
	public void setJpdNo(String jpdNo) {
		this.jpdNo = jpdNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDmyBkgNoForCustom(JSPUtil.getParameter(request, "dmy_bkg_no_for_custom", ""));
		setUsdNo(JSPUtil.getParameter(request, "usd_no", ""));
		setCadNo(JSPUtil.getParameter(request, "cad_no", ""));
		setRptNo(JSPUtil.getParameter(request, "rpt_no", ""));
		setKrWhfDeclNo(JSPUtil.getParameter(request, "kr_whf_decl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFsrNo(JSPUtil.getParameter(request, "fsr_no", ""));
		setUitNo(JSPUtil.getParameter(request, "uit_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setKrWhfCsrNo(JSPUtil.getParameter(request, "kr_whf_csr_no", ""));
		setCaNo(JSPUtil.getParameter(request, "ca_no", ""));
		setDnoNo(JSPUtil.getParameter(request, "dno_no", ""));
		setSrNo(JSPUtil.getParameter(request, "sr_no", ""));
		setJpdNo(JSPUtil.getParameter(request, "jpd_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgReferenceNoGenerationVO[]
	 */
	public BkgReferenceNoGenerationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgReferenceNoGenerationVO[]
	 */
	public BkgReferenceNoGenerationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgReferenceNoGenerationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dmyBkgNoForCustom = (JSPUtil.getParameter(request, prefix	+ "dmy_bkg_no_for_custom", length));
			String[] usdNo = (JSPUtil.getParameter(request, prefix	+ "usd_no", length));
			String[] cadNo = (JSPUtil.getParameter(request, prefix	+ "cad_no", length));
			String[] rptNo = (JSPUtil.getParameter(request, prefix	+ "rpt_no", length));
			String[] krWhfDeclNo = (JSPUtil.getParameter(request, prefix	+ "kr_whf_decl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fsrNo = (JSPUtil.getParameter(request, prefix	+ "fsr_no", length));
			String[] uitNo = (JSPUtil.getParameter(request, prefix	+ "uit_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] krWhfCsrNo = (JSPUtil.getParameter(request, prefix	+ "kr_whf_csr_no", length));
			String[] caNo = (JSPUtil.getParameter(request, prefix	+ "ca_no", length));
			String[] dnoNo = (JSPUtil.getParameter(request, prefix	+ "dno_no", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			String[] jpdNo = (JSPUtil.getParameter(request, prefix	+ "jpd_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgReferenceNoGenerationVO();
				if (dmyBkgNoForCustom[i] != null)
					model.setDmyBkgNoForCustom(dmyBkgNoForCustom[i]);
				if (usdNo[i] != null)
					model.setUsdNo(usdNo[i]);
				if (cadNo[i] != null)
					model.setCadNo(cadNo[i]);
				if (rptNo[i] != null)
					model.setRptNo(rptNo[i]);
				if (krWhfDeclNo[i] != null)
					model.setKrWhfDeclNo(krWhfDeclNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fsrNo[i] != null)
					model.setFsrNo(fsrNo[i]);
				if (uitNo[i] != null)
					model.setUitNo(uitNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (krWhfCsrNo[i] != null)
					model.setKrWhfCsrNo(krWhfCsrNo[i]);
				if (caNo[i] != null)
					model.setCaNo(caNo[i]);
				if (dnoNo[i] != null)
					model.setDnoNo(dnoNo[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				if (jpdNo[i] != null)
					model.setJpdNo(jpdNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgReferenceNoGenerationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgReferenceNoGenerationVO[]
	 */
	public BkgReferenceNoGenerationVO[] getBkgReferenceNoGenerationVOs(){
		BkgReferenceNoGenerationVO[] vos = (BkgReferenceNoGenerationVO[])models.toArray(new BkgReferenceNoGenerationVO[models.size()]);
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
		this.dmyBkgNoForCustom = this.dmyBkgNoForCustom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdNo = this.usdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cadNo = this.cadNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptNo = this.rptNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krWhfDeclNo = this.krWhfDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fsrNo = this.fsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uitNo = this.uitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krWhfCsrNo = this.krWhfCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caNo = this.caNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dnoNo = this.dnoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpdNo = this.jpdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
