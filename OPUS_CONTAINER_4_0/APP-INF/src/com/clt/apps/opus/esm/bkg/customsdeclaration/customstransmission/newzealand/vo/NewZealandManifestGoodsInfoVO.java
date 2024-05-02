/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NewZealandManifestGoodsInfoVO.java
*@FileTitle : NewZealandManifestGoodsInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.19  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo;

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

public class NewZealandManifestGoodsInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NewZealandManifestGoodsInfoVO> models = new ArrayList<NewZealandManifestGoodsInfoVO>();
	
	/* Column Info */
	private String blmeaUnit = null;
	/* Column Info */
	private String blwgtUnit = null;
	/* Column Info */
	private String blpkg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmSeq = null;
	/* Column Info */
	private String blmea = null;
	/* Column Info */
	private String blwgt = null;
	/* Column Info */
	private String blpkgu = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public NewZealandManifestGoodsInfoVO() {}

	public NewZealandManifestGoodsInfoVO(String ibflag, String pagerows, String cmSeq, String blpkg, String blpkgu, String blwgt, String blwgtUnit, String blmea, String blmeaUnit) {
		this.blmeaUnit = blmeaUnit;
		this.blwgtUnit = blwgtUnit;
		this.blpkg = blpkg;
		this.ibflag = ibflag;
		this.cmSeq = cmSeq;
		this.blmea = blmea;
		this.blwgt = blwgt;
		this.blpkgu = blpkgu;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("blmea_unit", getBlmeaUnit());
		this.hashColumns.put("blwgt_unit", getBlwgtUnit());
		this.hashColumns.put("blpkg", getBlpkg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cm_seq", getCmSeq());
		this.hashColumns.put("blmea", getBlmea());
		this.hashColumns.put("blwgt", getBlwgt());
		this.hashColumns.put("blpkgu", getBlpkgu());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("blmea_unit", "blmeaUnit");
		this.hashFields.put("blwgt_unit", "blwgtUnit");
		this.hashFields.put("blpkg", "blpkg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cm_seq", "cmSeq");
		this.hashFields.put("blmea", "blmea");
		this.hashFields.put("blwgt", "blwgt");
		this.hashFields.put("blpkgu", "blpkgu");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blmeaUnit
	 */
	public String getBlmeaUnit() {
		return this.blmeaUnit;
	}
	
	/**
	 * Column Info
	 * @return blwgtUnit
	 */
	public String getBlwgtUnit() {
		return this.blwgtUnit;
	}
	
	/**
	 * Column Info
	 * @return blpkg
	 */
	public String getBlpkg() {
		return this.blpkg;
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
	 * @return cmSeq
	 */
	public String getCmSeq() {
		return this.cmSeq;
	}
	
	/**
	 * Column Info
	 * @return blmea
	 */
	public String getBlmea() {
		return this.blmea;
	}
	
	/**
	 * Column Info
	 * @return blwgt
	 */
	public String getBlwgt() {
		return this.blwgt;
	}
	
	/**
	 * Column Info
	 * @return blpkgu
	 */
	public String getBlpkgu() {
		return this.blpkgu;
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
	 * @param blmeaUnit
	 */
	public void setBlmeaUnit(String blmeaUnit) {
		this.blmeaUnit = blmeaUnit;
	}
	
	/**
	 * Column Info
	 * @param blwgtUnit
	 */
	public void setBlwgtUnit(String blwgtUnit) {
		this.blwgtUnit = blwgtUnit;
	}
	
	/**
	 * Column Info
	 * @param blpkg
	 */
	public void setBlpkg(String blpkg) {
		this.blpkg = blpkg;
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
	 * @param cmSeq
	 */
	public void setCmSeq(String cmSeq) {
		this.cmSeq = cmSeq;
	}
	
	/**
	 * Column Info
	 * @param blmea
	 */
	public void setBlmea(String blmea) {
		this.blmea = blmea;
	}
	
	/**
	 * Column Info
	 * @param blwgt
	 */
	public void setBlwgt(String blwgt) {
		this.blwgt = blwgt;
	}
	
	/**
	 * Column Info
	 * @param blpkgu
	 */
	public void setBlpkgu(String blpkgu) {
		this.blpkgu = blpkgu;
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
		setBlmeaUnit(JSPUtil.getParameter(request, prefix + "blmea_unit", ""));
		setBlwgtUnit(JSPUtil.getParameter(request, prefix + "blwgt_unit", ""));
		setBlpkg(JSPUtil.getParameter(request, prefix + "blpkg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmSeq(JSPUtil.getParameter(request, prefix + "cm_seq", ""));
		setBlmea(JSPUtil.getParameter(request, prefix + "blmea", ""));
		setBlwgt(JSPUtil.getParameter(request, prefix + "blwgt", ""));
		setBlpkgu(JSPUtil.getParameter(request, prefix + "blpkgu", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NewZealandManifestGoodsInfoVO[]
	 */
	public NewZealandManifestGoodsInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NewZealandManifestGoodsInfoVO[]
	 */
	public NewZealandManifestGoodsInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NewZealandManifestGoodsInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blmeaUnit = (JSPUtil.getParameter(request, prefix	+ "blmea_unit", length));
			String[] blwgtUnit = (JSPUtil.getParameter(request, prefix	+ "blwgt_unit", length));
			String[] blpkg = (JSPUtil.getParameter(request, prefix	+ "blpkg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmSeq = (JSPUtil.getParameter(request, prefix	+ "cm_seq", length));
			String[] blmea = (JSPUtil.getParameter(request, prefix	+ "blmea", length));
			String[] blwgt = (JSPUtil.getParameter(request, prefix	+ "blwgt", length));
			String[] blpkgu = (JSPUtil.getParameter(request, prefix	+ "blpkgu", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new NewZealandManifestGoodsInfoVO();
				if (blmeaUnit[i] != null)
					model.setBlmeaUnit(blmeaUnit[i]);
				if (blwgtUnit[i] != null)
					model.setBlwgtUnit(blwgtUnit[i]);
				if (blpkg[i] != null)
					model.setBlpkg(blpkg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmSeq[i] != null)
					model.setCmSeq(cmSeq[i]);
				if (blmea[i] != null)
					model.setBlmea(blmea[i]);
				if (blwgt[i] != null)
					model.setBlwgt(blwgt[i]);
				if (blpkgu[i] != null)
					model.setBlpkgu(blpkgu[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNewZealandManifestGoodsInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NewZealandManifestGoodsInfoVO[]
	 */
	public NewZealandManifestGoodsInfoVO[] getNewZealandManifestGoodsInfoVOs(){
		NewZealandManifestGoodsInfoVO[] vos = (NewZealandManifestGoodsInfoVO[])models.toArray(new NewZealandManifestGoodsInfoVO[models.size()]);
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
		this.blmeaUnit = this.blmeaUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blwgtUnit = this.blwgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpkg = this.blpkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmSeq = this.cmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blmea = this.blmea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blwgt = this.blwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpkgu = this.blpkgu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
