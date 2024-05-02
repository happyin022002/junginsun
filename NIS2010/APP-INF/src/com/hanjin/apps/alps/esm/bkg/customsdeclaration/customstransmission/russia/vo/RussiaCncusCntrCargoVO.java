/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RussiaCncusCntrCargoVO.java
*@FileTitle : RussiaCncusCntrCargoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class RussiaCncusCntrCargoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RussiaCncusCntrCargoVO> models = new ArrayList<RussiaCncusCntrCargoVO>();
	
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String pckNm = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrCmdtDesc = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String pckCmdtDesc = null;
	/* Column Info */
	private String cntrMfGdsDesc = null;
	/* Column Info */
	private String tareWgt = null;
	/* Column Info */
	private String pkgQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RussiaCncusCntrCargoVO() {}

	public RussiaCncusCntrCargoVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String cntrSealNo, String cntrWgt, String tareWgt, String pkgQty, String pckCmdtDesc, String cntrCmdtDesc, String cntrMfGdsDesc, String pckQty, String pckNm) {
		this.cntrWgt = cntrWgt;
		this.pckNm = pckNm;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.cntrCmdtDesc = cntrCmdtDesc;
		this.pckQty = pckQty;
		this.cntrSealNo = cntrSealNo;
		this.pckCmdtDesc = pckCmdtDesc;
		this.cntrMfGdsDesc = cntrMfGdsDesc;
		this.tareWgt = tareWgt;
		this.pkgQty = pkgQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("pck_nm", getPckNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_cmdt_desc", getCntrCmdtDesc());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("pck_cmdt_desc", getPckCmdtDesc());
		this.hashColumns.put("cntr_mf_gds_desc", getCntrMfGdsDesc());
		this.hashColumns.put("tare_wgt", getTareWgt());
		this.hashColumns.put("pkg_qty", getPkgQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("pck_nm", "pckNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_cmdt_desc", "cntrCmdtDesc");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("pck_cmdt_desc", "pckCmdtDesc");
		this.hashFields.put("cntr_mf_gds_desc", "cntrMfGdsDesc");
		this.hashFields.put("tare_wgt", "tareWgt");
		this.hashFields.put("pkg_qty", "pkgQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return pckNm
	 */
	public String getPckNm() {
		return this.pckNm;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return cntrCmdtDesc
	 */
	public String getCntrCmdtDesc() {
		return this.cntrCmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return pckCmdtDesc
	 */
	public String getPckCmdtDesc() {
		return this.pckCmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return cntrMfGdsDesc
	 */
	public String getCntrMfGdsDesc() {
		return this.cntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @return tareWgt
	 */
	public String getTareWgt() {
		return this.tareWgt;
	}
	
	/**
	 * Column Info
	 * @return pkgQty
	 */
	public String getPkgQty() {
		return this.pkgQty;
	}
	

	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param pckNm
	 */
	public void setPckNm(String pckNm) {
		this.pckNm = pckNm;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cntrCmdtDesc
	 */
	public void setCntrCmdtDesc(String cntrCmdtDesc) {
		this.cntrCmdtDesc = cntrCmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param pckCmdtDesc
	 */
	public void setPckCmdtDesc(String pckCmdtDesc) {
		this.pckCmdtDesc = pckCmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param cntrMfGdsDesc
	 */
	public void setCntrMfGdsDesc(String cntrMfGdsDesc) {
		this.cntrMfGdsDesc = cntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @param tareWgt
	 */
	public void setTareWgt(String tareWgt) {
		this.tareWgt = tareWgt;
	}
	
	/**
	 * Column Info
	 * @param pkgQty
	 */
	public void setPkgQty(String pkgQty) {
		this.pkgQty = pkgQty;
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
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setPckNm(JSPUtil.getParameter(request, prefix + "pck_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrCmdtDesc(JSPUtil.getParameter(request, prefix + "cntr_cmdt_desc", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setPckCmdtDesc(JSPUtil.getParameter(request, prefix + "pck_cmdt_desc", ""));
		setCntrMfGdsDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_gds_desc", ""));
		setTareWgt(JSPUtil.getParameter(request, prefix + "tare_wgt", ""));
		setPkgQty(JSPUtil.getParameter(request, prefix + "pkg_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RussiaCncusCntrCargoVO[]
	 */
	public RussiaCncusCntrCargoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RussiaCncusCntrCargoVO[]
	 */
	public RussiaCncusCntrCargoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RussiaCncusCntrCargoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] pckNm = (JSPUtil.getParameter(request, prefix	+ "pck_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrCmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_cmdt_desc", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] pckCmdtDesc = (JSPUtil.getParameter(request, prefix	+ "pck_cmdt_desc", length));
			String[] cntrMfGdsDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_gds_desc", length));
			String[] tareWgt = (JSPUtil.getParameter(request, prefix	+ "tare_wgt", length));
			String[] pkgQty = (JSPUtil.getParameter(request, prefix	+ "pkg_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new RussiaCncusCntrCargoVO();
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (pckNm[i] != null)
					model.setPckNm(pckNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrCmdtDesc[i] != null)
					model.setCntrCmdtDesc(cntrCmdtDesc[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (pckCmdtDesc[i] != null)
					model.setPckCmdtDesc(pckCmdtDesc[i]);
				if (cntrMfGdsDesc[i] != null)
					model.setCntrMfGdsDesc(cntrMfGdsDesc[i]);
				if (tareWgt[i] != null)
					model.setTareWgt(tareWgt[i]);
				if (pkgQty[i] != null)
					model.setPkgQty(pkgQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRussiaCncusCntrCargoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RussiaCncusCntrCargoVO[]
	 */
	public RussiaCncusCntrCargoVO[] getRussiaCncusCntrCargoVOs(){
		RussiaCncusCntrCargoVO[] vos = (RussiaCncusCntrCargoVO[])models.toArray(new RussiaCncusCntrCargoVO[models.size()]);
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
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckNm = this.pckNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCmdtDesc = this.cntrCmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckCmdtDesc = this.pckCmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfGdsDesc = this.cntrMfGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tareWgt = this.tareWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgQty = this.pkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
