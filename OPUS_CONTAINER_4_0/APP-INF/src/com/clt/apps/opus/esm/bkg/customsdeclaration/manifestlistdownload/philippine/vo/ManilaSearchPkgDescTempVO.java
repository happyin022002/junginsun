/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManilaSearchPkgDescTempVO.java
*@FileTitle : ManilaSearchPkgDescTempVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.21 임재택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo;

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
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 임재택
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class ManilaSearchPkgDescTempVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ManilaSearchPkgDescVO> models = new ArrayList<ManilaSearchPkgDescVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String packageType = null;
	/* Column Info */
	private String regNumber4 = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String blNo3 = null;
	/* Column Info */
	private String mark = null;
	/* Column Info */
	private String seq2 = null;
	/* Column Info */
	private String descGood = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ManilaSearchPkgDescTempVO() {}

	public ManilaSearchPkgDescTempVO(String ibflag, String pagerows, String regNumber4, String blNo3, String packageType, String pckQty, String descGood, String mark, String seq, String seq2) {
		this.ibflag = ibflag;
		this.packageType = packageType;
		this.regNumber4 = regNumber4;
		this.seq = seq;
		this.pckQty = pckQty;
		this.blNo3 = blNo3;
		this.mark = mark;
		this.seq2 = seq2;
		this.descGood = descGood;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("package_type", getPackageType());
		this.hashColumns.put("reg_number4", getRegNumber4());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("bl_no3", getBlNo3());
		this.hashColumns.put("mark", getMark());
		this.hashColumns.put("seq2", getSeq2());
		this.hashColumns.put("desc_good", getDescGood());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("package_type", "packageType");
		this.hashFields.put("reg_number4", "regNumber4");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("bl_no3", "blNo3");
		this.hashFields.put("mark", "mark");
		this.hashFields.put("seq2", "seq2");
		this.hashFields.put("desc_good", "descGood");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return packageType
	 */
	public String getPackageType() {
		return this.packageType;
	}
	
	/**
	 * Column Info
	 * @return regNumber4
	 */
	public String getRegNumber4() {
		return this.regNumber4;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
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
	 * @return blNo3
	 */
	public String getBlNo3() {
		return this.blNo3;
	}
	
	/**
	 * Column Info
	 * @return mark
	 */
	public String getMark() {
		return this.mark;
	}
	
	/**
	 * Column Info
	 * @return seq2
	 */
	public String getSeq2() {
		return this.seq2;
	}
	
	/**
	 * Column Info
	 * @return descGood
	 */
	public String getDescGood() {
		return this.descGood;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param packageType
	 */
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	
	/**
	 * Column Info
	 * @param regNumber4
	 */
	public void setRegNumber4(String regNumber4) {
		this.regNumber4 = regNumber4;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
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
	 * @param blNo3
	 */
	public void setBlNo3(String blNo3) {
		this.blNo3 = blNo3;
	}
	
	/**
	 * Column Info
	 * @param mark
	 */
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	/**
	 * Column Info
	 * @param seq2
	 */
	public void setSeq2(String seq2) {
		this.seq2 = seq2;
	}
	
	/**
	 * Column Info
	 * @param descGood
	 */
	public void setDescGood(String descGood) {
		this.descGood = descGood;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPackageType(JSPUtil.getParameter(request, "package_type", ""));
		setRegNumber4(JSPUtil.getParameter(request, "reg_number4", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setBlNo3(JSPUtil.getParameter(request, "bl_no3", ""));
		setMark(JSPUtil.getParameter(request, "mark", ""));
		setSeq2(JSPUtil.getParameter(request, "seq2", ""));
		setDescGood(JSPUtil.getParameter(request, "desc_good", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ManilaSearchPkgDescVO[]
	 */
	public ManilaSearchPkgDescVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ManilaSearchPkgDescVO[]
	 */
	public ManilaSearchPkgDescVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ManilaSearchPkgDescVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] packageType = (JSPUtil.getParameter(request, prefix	+ "package_type", length));
			String[] regNumber4 = (JSPUtil.getParameter(request, prefix	+ "reg_number4", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] blNo3 = (JSPUtil.getParameter(request, prefix	+ "bl_no3", length));
			String[] mark = (JSPUtil.getParameter(request, prefix	+ "mark", length));
			String[] seq2 = (JSPUtil.getParameter(request, prefix	+ "seq2", length));
			String[] descGood = (JSPUtil.getParameter(request, prefix	+ "desc_good", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ManilaSearchPkgDescVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (packageType[i] != null)
					model.setPackageType(packageType[i]);
				if (regNumber4[i] != null)
					model.setRegNumber4(regNumber4[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (blNo3[i] != null)
					model.setBlNo3(blNo3[i]);
				if (mark[i] != null)
					model.setMark(mark[i]);
				if (seq2[i] != null)
					model.setSeq2(seq2[i]);
				if (descGood[i] != null)
					model.setDescGood(descGood[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getManilaSearchPkgDescVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ManilaSearchPkgDescVO[]
	 */
	public ManilaSearchPkgDescVO[] getManilaSearchPkgDescVOs(){
		ManilaSearchPkgDescVO[] vos = (ManilaSearchPkgDescVO[])models.toArray(new ManilaSearchPkgDescVO[models.size()]);
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
		this.packageType = this.packageType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regNumber4 = this.regNumber4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo3 = this.blNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark = this.mark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq2 = this.seq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.descGood = this.descGood .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
