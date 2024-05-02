/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorExportNoVO.java
*@FileTitle : KorExportNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.10
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.05.10 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorExportNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorExportNoVO> models = new ArrayList<KorExportNoVO>();
	
	/* Column Info */
	private String elnoCheck = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String elnoWgt = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String xptLicNo = null;
	/* Column Info */
	private String mfWgt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorExportNoVO() {}

	public KorExportNoVO(String ibflag, String pagerows, String elnoCheck, String elnoWgt, String pckQty, String mfWgt, String xptLicNo) {
		this.elnoCheck = elnoCheck;
		this.ibflag = ibflag;
		this.elnoWgt = elnoWgt;
		this.pckQty = pckQty;
		this.xptLicNo = xptLicNo;
		this.mfWgt = mfWgt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("elno_check", getElnoCheck());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("elno_wgt", getElnoWgt());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("xpt_lic_no", getXptLicNo());
		this.hashColumns.put("mf_wgt", getMfWgt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("elno_check", "elnoCheck");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("elno_wgt", "elnoWgt");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("xpt_lic_no", "xptLicNo");
		this.hashFields.put("mf_wgt", "mfWgt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return elnoCheck
	 */
	public String getElnoCheck() {
		return this.elnoCheck;
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
	 * @return elnoWgt
	 */
	public String getElnoWgt() {
		return this.elnoWgt;
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
	 * @return xptLicNo
	 */
	public String getXptLicNo() {
		return this.xptLicNo;
	}
	
	/**
	 * Column Info
	 * @return mfWgt
	 */
	public String getMfWgt() {
		return this.mfWgt;
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
	 * @param elnoCheck
	 */
	public void setElnoCheck(String elnoCheck) {
		this.elnoCheck = elnoCheck;
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
	 * @param elnoWgt
	 */
	public void setElnoWgt(String elnoWgt) {
		this.elnoWgt = elnoWgt;
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
	 * @param xptLicNo
	 */
	public void setXptLicNo(String xptLicNo) {
		this.xptLicNo = xptLicNo;
	}
	
	/**
	 * Column Info
	 * @param mfWgt
	 */
	public void setMfWgt(String mfWgt) {
		this.mfWgt = mfWgt;
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
		setElnoCheck(JSPUtil.getParameter(request, prefix + "elno_check", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setElnoWgt(JSPUtil.getParameter(request, prefix + "elno_wgt", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setXptLicNo(JSPUtil.getParameter(request, prefix + "xpt_lic_no", ""));
		setMfWgt(JSPUtil.getParameter(request, prefix + "mf_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorExportNoVO[]
	 */
	public KorExportNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorExportNoVO[]
	 */
	public KorExportNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorExportNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] elnoCheck = (JSPUtil.getParameter(request, prefix	+ "elno_check", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] elnoWgt = (JSPUtil.getParameter(request, prefix	+ "elno_wgt", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] xptLicNo = (JSPUtil.getParameter(request, prefix	+ "xpt_lic_no", length));
			String[] mfWgt = (JSPUtil.getParameter(request, prefix	+ "mf_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorExportNoVO();
				if (elnoCheck[i] != null)
					model.setElnoCheck(elnoCheck[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (elnoWgt[i] != null)
					model.setElnoWgt(elnoWgt[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (xptLicNo[i] != null)
					model.setXptLicNo(xptLicNo[i]);
				if (mfWgt[i] != null)
					model.setMfWgt(mfWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorExportNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorExportNoVO[]
	 */
	public KorExportNoVO[] getKorExportNoVOs(){
		KorExportNoVO[] vos = (KorExportNoVO[])models.toArray(new KorExportNoVO[models.size()]);
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
		this.elnoCheck = this.elnoCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elnoWgt = this.elnoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptLicNo = this.xptLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfWgt = this.mfWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
