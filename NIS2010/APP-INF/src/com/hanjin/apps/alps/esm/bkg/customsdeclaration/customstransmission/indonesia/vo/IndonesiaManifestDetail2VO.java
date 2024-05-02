/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndonesiaManifestDetail2VO.java
*@FileTitle : IndonesiaManifestDetail2VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.10.07 민동진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.vo;

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
 * @author 민동진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IndonesiaManifestDetail2VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IndonesiaManifestDetail2VO> models = new ArrayList<IndonesiaManifestDetail2VO>();
	
	/* Column Info */
	private String shprCustNm = null;
	/* Column Info */
	private String cneeCustAddr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ntfyCustAddr = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String cneeCustNm = null;
	/* Column Info */
	private String shprCustAddr = null;
	/* Column Info */
	private String ntfyCustNm = null;
	/* Column Info */
	private String mkDesc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IndonesiaManifestDetail2VO() {}

	public IndonesiaManifestDetail2VO(String ibflag, String pagerows, String shprCustNm, String shprCustAddr, String cneeCustNm, String cneeCustAddr, String ntfyCustNm, String ntfyCustAddr, String mkDesc, String cmdtDesc) {
		this.shprCustNm = shprCustNm;
		this.cneeCustAddr = cneeCustAddr;
		this.ibflag = ibflag;
		this.ntfyCustAddr = ntfyCustAddr;
		this.cmdtDesc = cmdtDesc;
		this.cneeCustNm = cneeCustNm;
		this.shprCustAddr = shprCustAddr;
		this.ntfyCustNm = ntfyCustNm;
		this.mkDesc = mkDesc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("shpr_cust_nm", getShprCustNm());
		this.hashColumns.put("cnee_cust_addr", getCneeCustAddr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ntfy_cust_addr", getNtfyCustAddr());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("cnee_cust_nm", getCneeCustNm());
		this.hashColumns.put("shpr_cust_addr", getShprCustAddr());
		this.hashColumns.put("ntfy_cust_nm", getNtfyCustNm());
		this.hashColumns.put("mk_desc", getMkDesc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("shpr_cust_nm", "shprCustNm");
		this.hashFields.put("cnee_cust_addr", "cneeCustAddr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ntfy_cust_addr", "ntfyCustAddr");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("cnee_cust_nm", "cneeCustNm");
		this.hashFields.put("shpr_cust_addr", "shprCustAddr");
		this.hashFields.put("ntfy_cust_nm", "ntfyCustNm");
		this.hashFields.put("mk_desc", "mkDesc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return shprCustNm
	 */
	public String getShprCustNm() {
		return this.shprCustNm;
	}
	
	/**
	 * Column Info
	 * @return cneeCustAddr
	 */
	public String getCneeCustAddr() {
		return this.cneeCustAddr;
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
	 * @return ntfyCustAddr
	 */
	public String getNtfyCustAddr() {
		return this.ntfyCustAddr;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return cneeCustNm
	 */
	public String getCneeCustNm() {
		return this.cneeCustNm;
	}
	
	/**
	 * Column Info
	 * @return shprCustAddr
	 */
	public String getShprCustAddr() {
		return this.shprCustAddr;
	}
	
	/**
	 * Column Info
	 * @return ntfyCustNm
	 */
	public String getNtfyCustNm() {
		return this.ntfyCustNm;
	}
	
	/**
	 * Column Info
	 * @return mkDesc
	 */
	public String getMkDesc() {
		return this.mkDesc;
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
	 * @param shprCustNm
	 */
	public void setShprCustNm(String shprCustNm) {
		this.shprCustNm = shprCustNm;
	}
	
	/**
	 * Column Info
	 * @param cneeCustAddr
	 */
	public void setCneeCustAddr(String cneeCustAddr) {
		this.cneeCustAddr = cneeCustAddr;
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
	 * @param ntfyCustAddr
	 */
	public void setNtfyCustAddr(String ntfyCustAddr) {
		this.ntfyCustAddr = ntfyCustAddr;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param cneeCustNm
	 */
	public void setCneeCustNm(String cneeCustNm) {
		this.cneeCustNm = cneeCustNm;
	}
	
	/**
	 * Column Info
	 * @param shprCustAddr
	 */
	public void setShprCustAddr(String shprCustAddr) {
		this.shprCustAddr = shprCustAddr;
	}
	
	/**
	 * Column Info
	 * @param ntfyCustNm
	 */
	public void setNtfyCustNm(String ntfyCustNm) {
		this.ntfyCustNm = ntfyCustNm;
	}
	
	/**
	 * Column Info
	 * @param mkDesc
	 */
	public void setMkDesc(String mkDesc) {
		this.mkDesc = mkDesc;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setShprCustNm(JSPUtil.getParameter(request, "shpr_cust_nm", ""));
		setCneeCustAddr(JSPUtil.getParameter(request, "cnee_cust_addr", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setNtfyCustAddr(JSPUtil.getParameter(request, "ntfy_cust_addr", ""));
		setCmdtDesc(JSPUtil.getParameter(request, "cmdt_desc", ""));
		setCneeCustNm(JSPUtil.getParameter(request, "cnee_cust_nm", ""));
		setShprCustAddr(JSPUtil.getParameter(request, "shpr_cust_addr", ""));
		setNtfyCustNm(JSPUtil.getParameter(request, "ntfy_cust_nm", ""));
		setMkDesc(JSPUtil.getParameter(request, "mk_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IndonesiaManifestDetail2VO[]
	 */
	public IndonesiaManifestDetail2VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IndonesiaManifestDetail2VO[]
	 */
	public IndonesiaManifestDetail2VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IndonesiaManifestDetail2VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] shprCustNm = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_nm", length));
			String[] cneeCustAddr = (JSPUtil.getParameter(request, prefix	+ "cnee_cust_addr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ntfyCustAddr = (JSPUtil.getParameter(request, prefix	+ "ntfy_cust_addr", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] cneeCustNm = (JSPUtil.getParameter(request, prefix	+ "cnee_cust_nm", length));
			String[] shprCustAddr = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_addr", length));
			String[] ntfyCustNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_cust_nm", length));
			String[] mkDesc = (JSPUtil.getParameter(request, prefix	+ "mk_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new IndonesiaManifestDetail2VO();
				if (shprCustNm[i] != null)
					model.setShprCustNm(shprCustNm[i]);
				if (cneeCustAddr[i] != null)
					model.setCneeCustAddr(cneeCustAddr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ntfyCustAddr[i] != null)
					model.setNtfyCustAddr(ntfyCustAddr[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (cneeCustNm[i] != null)
					model.setCneeCustNm(cneeCustNm[i]);
				if (shprCustAddr[i] != null)
					model.setShprCustAddr(shprCustAddr[i]);
				if (ntfyCustNm[i] != null)
					model.setNtfyCustNm(ntfyCustNm[i]);
				if (mkDesc[i] != null)
					model.setMkDesc(mkDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIndonesiaManifestDetail2VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IndonesiaManifestDetail2VO[]
	 */
	public IndonesiaManifestDetail2VO[] getIndonesiaManifestDetail2VOs(){
		IndonesiaManifestDetail2VO[] vos = (IndonesiaManifestDetail2VO[])models.toArray(new IndonesiaManifestDetail2VO[models.size()]);
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
		this.shprCustNm = this.shprCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCustAddr = this.cneeCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCustAddr = this.ntfyCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCustNm = this.cneeCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustAddr = this.shprCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCustNm = this.ntfyCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc = this.mkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
