/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RocsSearchDgCntrInfoVO.java
*@FileTitle : RocsSearchDgCntrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.25  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.vo;

import java.lang.reflect.Field;
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

public class RocsSearchDgCntrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RocsSearchDgCntrInfoVO> models = new ArrayList<RocsSearchDgCntrInfoVO>();
	
	/* Column Info */
	private String pkggrp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dgFlashPnt = null;
	/* Column Info */
	private String dgImoClass = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String dgPkgDesc = null;
	/* Column Info */
	private String dgUnno = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RocsSearchDgCntrInfoVO() {}

	public RocsSearchDgCntrInfoVO(String ibflag, String pagerows, String cntrNo, String dgImoClass, String dgUnno, String dgFlashPnt, String dgPkgDesc, String pkggrp) {
		this.pkggrp = pkggrp;
		this.ibflag = ibflag;
		this.dgFlashPnt = dgFlashPnt;
		this.dgImoClass = dgImoClass;
		this.cntrNo = cntrNo;
		this.dgPkgDesc = dgPkgDesc;
		this.dgUnno = dgUnno;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pkggrp", getPkggrp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dg_flash_pnt", getDgFlashPnt());
		this.hashColumns.put("dg_imo_class", getDgImoClass());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("dg_pkg_desc", getDgPkgDesc());
		this.hashColumns.put("dg_unno", getDgUnno());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pkggrp", "pkggrp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dg_flash_pnt", "dgFlashPnt");
		this.hashFields.put("dg_imo_class", "dgImoClass");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("dg_pkg_desc", "dgPkgDesc");
		this.hashFields.put("dg_unno", "dgUnno");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pkggrp
	 */
	public String getPkggrp() {
		return this.pkggrp;
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
	 * @return dgFlashPnt
	 */
	public String getDgFlashPnt() {
		return this.dgFlashPnt;
	}
	
	/**
	 * Column Info
	 * @return dgImoClass
	 */
	public String getDgImoClass() {
		return this.dgImoClass;
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
	 * @return dgPkgDesc
	 */
	public String getDgPkgDesc() {
		return this.dgPkgDesc;
	}
	
	/**
	 * Column Info
	 * @return dgUnno
	 */
	public String getDgUnno() {
		return this.dgUnno;
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
	 * @param pkggrp
	 */
	public void setPkggrp(String pkggrp) {
		this.pkggrp = pkggrp;
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
	 * @param dgFlashPnt
	 */
	public void setDgFlashPnt(String dgFlashPnt) {
		this.dgFlashPnt = dgFlashPnt;
	}
	
	/**
	 * Column Info
	 * @param dgImoClass
	 */
	public void setDgImoClass(String dgImoClass) {
		this.dgImoClass = dgImoClass;
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
	 * @param dgPkgDesc
	 */
	public void setDgPkgDesc(String dgPkgDesc) {
		this.dgPkgDesc = dgPkgDesc;
	}
	
	/**
	 * Column Info
	 * @param dgUnno
	 */
	public void setDgUnno(String dgUnno) {
		this.dgUnno = dgUnno;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setPkggrp(JSPUtil.getParameter(request, prefix + "pkggrp", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDgFlashPnt(JSPUtil.getParameter(request, prefix + "dg_flash_pnt", ""));
		setDgImoClass(JSPUtil.getParameter(request, prefix + "dg_imo_class", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setDgPkgDesc(JSPUtil.getParameter(request, prefix + "dg_pkg_desc", ""));
		setDgUnno(JSPUtil.getParameter(request, prefix + "dg_unno", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RocsSearchDgCntrInfoVO[]
	 */
	public RocsSearchDgCntrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RocsSearchDgCntrInfoVO[]
	 */
	public RocsSearchDgCntrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RocsSearchDgCntrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pkggrp = (JSPUtil.getParameter(request, prefix	+ "pkggrp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dgFlashPnt = (JSPUtil.getParameter(request, prefix	+ "dg_flash_pnt", length));
			String[] dgImoClass = (JSPUtil.getParameter(request, prefix	+ "dg_imo_class", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] dgPkgDesc = (JSPUtil.getParameter(request, prefix	+ "dg_pkg_desc", length));
			String[] dgUnno = (JSPUtil.getParameter(request, prefix	+ "dg_unno", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RocsSearchDgCntrInfoVO();
				if (pkggrp[i] != null)
					model.setPkggrp(pkggrp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dgFlashPnt[i] != null)
					model.setDgFlashPnt(dgFlashPnt[i]);
				if (dgImoClass[i] != null)
					model.setDgImoClass(dgImoClass[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (dgPkgDesc[i] != null)
					model.setDgPkgDesc(dgPkgDesc[i]);
				if (dgUnno[i] != null)
					model.setDgUnno(dgUnno[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRocsSearchDgCntrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RocsSearchDgCntrInfoVO[]
	 */
	public RocsSearchDgCntrInfoVO[] getRocsSearchDgCntrInfoVOs(){
		RocsSearchDgCntrInfoVO[] vos = (RocsSearchDgCntrInfoVO[])models.toArray(new RocsSearchDgCntrInfoVO[models.size()]);
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
		this.pkggrp = this.pkggrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgFlashPnt = this.dgFlashPnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgImoClass = this.dgImoClass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgPkgDesc = this.dgPkgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgUnno = this.dgUnno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
