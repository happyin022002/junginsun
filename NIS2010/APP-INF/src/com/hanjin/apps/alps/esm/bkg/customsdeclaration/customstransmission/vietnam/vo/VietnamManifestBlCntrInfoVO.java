/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VietnamManifestBlCntrInfoVO.java
*@FileTitle : VietnamManifestBlCntrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.24
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.08.24 조원주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.vo;

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
 * @author 조원주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VietnamManifestBlCntrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VietnamManifestBlCntrInfoVO> models = new ArrayList<VietnamManifestBlCntrInfoVO>();
	
	/* Column Info */
	private String blPkgQty = null;
	/* Column Info */
	private String blCntrnbr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VietnamManifestBlCntrInfoVO() {}

	public VietnamManifestBlCntrInfoVO(String ibflag, String pagerows, String blCntrnbr, String blPkgQty) {
		this.blPkgQty = blPkgQty;
		this.blCntrnbr = blCntrnbr;
		this.ibflag = ibflag;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_pkg_qty", getBlPkgQty());
		this.hashColumns.put("bl_cntrnbr", getBlCntrnbr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_pkg_qty", "blPkgQty");
		this.hashFields.put("bl_cntrnbr", "blCntrnbr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blPkgQty
	 */
	public String getBlPkgQty() {
		return this.blPkgQty;
	}
	
	/**
	 * Column Info
	 * @return blCntrnbr
	 */
	public String getBlCntrnbr() {
		return this.blCntrnbr;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @param blPkgQty
	 */
	public void setBlPkgQty(String blPkgQty) {
		this.blPkgQty = blPkgQty;
	}
	
	/**
	 * Column Info
	 * @param blCntrnbr
	 */
	public void setBlCntrnbr(String blCntrnbr) {
		this.blCntrnbr = blCntrnbr;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
		setBlPkgQty(JSPUtil.getParameter(request, prefix + "bl_pkg_qty", ""));
		setBlCntrnbr(JSPUtil.getParameter(request, prefix + "bl_cntrnbr", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VietnamManifestBlCntrInfoVO[]
	 */
	public VietnamManifestBlCntrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VietnamManifestBlCntrInfoVO[]
	 */
	public VietnamManifestBlCntrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VietnamManifestBlCntrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blPkgQty = (JSPUtil.getParameter(request, prefix	+ "bl_pkg_qty", length));
			String[] blCntrnbr = (JSPUtil.getParameter(request, prefix	+ "bl_cntrnbr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new VietnamManifestBlCntrInfoVO();
				if (blPkgQty[i] != null)
					model.setBlPkgQty(blPkgQty[i]);
				if (blCntrnbr[i] != null)
					model.setBlCntrnbr(blCntrnbr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVietnamManifestBlCntrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VietnamManifestBlCntrInfoVO[]
	 */
	public VietnamManifestBlCntrInfoVO[] getVietnamManifestBlCntrInfoVOs(){
		VietnamManifestBlCntrInfoVO[] vos = (VietnamManifestBlCntrInfoVO[])models.toArray(new VietnamManifestBlCntrInfoVO[models.size()]);
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
		this.blPkgQty = this.blPkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCntrnbr = this.blCntrnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
