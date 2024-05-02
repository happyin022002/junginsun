/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AfterBookingReasonDescVO.java
*@FileTitle : AfterBookingReasonDescVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo;

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

public class AfterBookingReasonDescVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AfterBookingReasonDescVO> models = new ArrayList<AfterBookingReasonDescVO>();
	
	/* Column Info */
	private String rsnDescFlg = null;
	/* Column Info */
	private String fileLvlNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rsnFileFlg = null;
	/* Column Info */
	private String specRsnCd = null;
	/* Column Info */
	private String specRsnDesc = null;
	/* Column Info */
	private String rsnDesc = null;
	/* Column Info */
	private String dtlRmk = null;
	/* Column Info */
	private String fileLvlValue = null;
	/* Column Info */
	private String rsnBtCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AfterBookingReasonDescVO() {}

	public AfterBookingReasonDescVO(String ibflag, String pagerows, String rsnDesc, String specRsnCd, String specRsnDesc, String rsnBtCd, String rsnDescFlg, String rsnFileFlg, String dtlRmk, String fileLvlNm, String fileLvlValue) {
		this.rsnDescFlg = rsnDescFlg;
		this.fileLvlNm = fileLvlNm;
		this.ibflag = ibflag;
		this.rsnFileFlg = rsnFileFlg;
		this.specRsnCd = specRsnCd;
		this.specRsnDesc = specRsnDesc;
		this.rsnDesc = rsnDesc;
		this.dtlRmk = dtlRmk;
		this.fileLvlValue = fileLvlValue;
		this.rsnBtCd = rsnBtCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rsn_desc_flg", getRsnDescFlg());
		this.hashColumns.put("file_lvl_nm", getFileLvlNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rsn_file_flg", getRsnFileFlg());
		this.hashColumns.put("spec_rsn_cd", getSpecRsnCd());
		this.hashColumns.put("spec_rsn_desc", getSpecRsnDesc());
		this.hashColumns.put("rsn_desc", getRsnDesc());
		this.hashColumns.put("dtl_rmk", getDtlRmk());
		this.hashColumns.put("file_lvl_value", getFileLvlValue());
		this.hashColumns.put("rsn_bt_cd", getRsnBtCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rsn_desc_flg", "rsnDescFlg");
		this.hashFields.put("file_lvl_nm", "fileLvlNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rsn_file_flg", "rsnFileFlg");
		this.hashFields.put("spec_rsn_cd", "specRsnCd");
		this.hashFields.put("spec_rsn_desc", "specRsnDesc");
		this.hashFields.put("rsn_desc", "rsnDesc");
		this.hashFields.put("dtl_rmk", "dtlRmk");
		this.hashFields.put("file_lvl_value", "fileLvlValue");
		this.hashFields.put("rsn_bt_cd", "rsnBtCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rsnDescFlg
	 */
	public String getRsnDescFlg() {
		return this.rsnDescFlg;
	}
	
	/**
	 * Column Info
	 * @return fileLvlNm
	 */
	public String getFileLvlNm() {
		return this.fileLvlNm;
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
	 * @return rsnFileFlg
	 */
	public String getRsnFileFlg() {
		return this.rsnFileFlg;
	}
	
	/**
	 * Column Info
	 * @return specRsnCd
	 */
	public String getSpecRsnCd() {
		return this.specRsnCd;
	}
	
	/**
	 * Column Info
	 * @return specRsnDesc
	 */
	public String getSpecRsnDesc() {
		return this.specRsnDesc;
	}
	
	/**
	 * Column Info
	 * @return rsnDesc
	 */
	public String getRsnDesc() {
		return this.rsnDesc;
	}
	
	/**
	 * Column Info
	 * @return dtlRmk
	 */
	public String getDtlRmk() {
		return this.dtlRmk;
	}
	
	/**
	 * Column Info
	 * @return fileLvlValue
	 */
	public String getFileLvlValue() {
		return this.fileLvlValue;
	}
	
	/**
	 * Column Info
	 * @return rsnBtCd
	 */
	public String getRsnBtCd() {
		return this.rsnBtCd;
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
	 * @param rsnDescFlg
	 */
	public void setRsnDescFlg(String rsnDescFlg) {
		this.rsnDescFlg = rsnDescFlg;
	}
	
	/**
	 * Column Info
	 * @param fileLvlNm
	 */
	public void setFileLvlNm(String fileLvlNm) {
		this.fileLvlNm = fileLvlNm;
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
	 * @param rsnFileFlg
	 */
	public void setRsnFileFlg(String rsnFileFlg) {
		this.rsnFileFlg = rsnFileFlg;
	}
	
	/**
	 * Column Info
	 * @param specRsnCd
	 */
	public void setSpecRsnCd(String specRsnCd) {
		this.specRsnCd = specRsnCd;
	}
	
	/**
	 * Column Info
	 * @param specRsnDesc
	 */
	public void setSpecRsnDesc(String specRsnDesc) {
		this.specRsnDesc = specRsnDesc;
	}
	
	/**
	 * Column Info
	 * @param rsnDesc
	 */
	public void setRsnDesc(String rsnDesc) {
		this.rsnDesc = rsnDesc;
	}
	
	/**
	 * Column Info
	 * @param dtlRmk
	 */
	public void setDtlRmk(String dtlRmk) {
		this.dtlRmk = dtlRmk;
	}
	
	/**
	 * Column Info
	 * @param fileLvlValue
	 */
	public void setFileLvlValue(String fileLvlValue) {
		this.fileLvlValue = fileLvlValue;
	}
	
	/**
	 * Column Info
	 * @param rsnBtCd
	 */
	public void setRsnBtCd(String rsnBtCd) {
		this.rsnBtCd = rsnBtCd;
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
		setRsnDescFlg(JSPUtil.getParameter(request, prefix + "rsn_desc_flg", ""));
		setFileLvlNm(JSPUtil.getParameter(request, prefix + "file_lvl_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRsnFileFlg(JSPUtil.getParameter(request, prefix + "rsn_file_flg", ""));
		setSpecRsnCd(JSPUtil.getParameter(request, prefix + "spec_rsn_cd", ""));
		setSpecRsnDesc(JSPUtil.getParameter(request, prefix + "spec_rsn_desc", ""));
		setRsnDesc(JSPUtil.getParameter(request, prefix + "rsn_desc", ""));
		setDtlRmk(JSPUtil.getParameter(request, prefix + "dtl_rmk", ""));
		setFileLvlValue(JSPUtil.getParameter(request, prefix + "file_lvl_value", ""));
		setRsnBtCd(JSPUtil.getParameter(request, prefix + "rsn_bt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AfterBookingReasonDescVO[]
	 */
	public AfterBookingReasonDescVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AfterBookingReasonDescVO[]
	 */
	public AfterBookingReasonDescVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AfterBookingReasonDescVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rsnDescFlg = (JSPUtil.getParameter(request, prefix	+ "rsn_desc_flg", length));
			String[] fileLvlNm = (JSPUtil.getParameter(request, prefix	+ "file_lvl_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rsnFileFlg = (JSPUtil.getParameter(request, prefix	+ "rsn_file_flg", length));
			String[] specRsnCd = (JSPUtil.getParameter(request, prefix	+ "spec_rsn_cd", length));
			String[] specRsnDesc = (JSPUtil.getParameter(request, prefix	+ "spec_rsn_desc", length));
			String[] rsnDesc = (JSPUtil.getParameter(request, prefix	+ "rsn_desc", length));
			String[] dtlRmk = (JSPUtil.getParameter(request, prefix	+ "dtl_rmk", length));
			String[] fileLvlValue = (JSPUtil.getParameter(request, prefix	+ "file_lvl_value", length));
			String[] rsnBtCd = (JSPUtil.getParameter(request, prefix	+ "rsn_bt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AfterBookingReasonDescVO();
				if (rsnDescFlg[i] != null)
					model.setRsnDescFlg(rsnDescFlg[i]);
				if (fileLvlNm[i] != null)
					model.setFileLvlNm(fileLvlNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rsnFileFlg[i] != null)
					model.setRsnFileFlg(rsnFileFlg[i]);
				if (specRsnCd[i] != null)
					model.setSpecRsnCd(specRsnCd[i]);
				if (specRsnDesc[i] != null)
					model.setSpecRsnDesc(specRsnDesc[i]);
				if (rsnDesc[i] != null)
					model.setRsnDesc(rsnDesc[i]);
				if (dtlRmk[i] != null)
					model.setDtlRmk(dtlRmk[i]);
				if (fileLvlValue[i] != null)
					model.setFileLvlValue(fileLvlValue[i]);
				if (rsnBtCd[i] != null)
					model.setRsnBtCd(rsnBtCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAfterBookingReasonDescVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AfterBookingReasonDescVO[]
	 */
	public AfterBookingReasonDescVO[] getAfterBookingReasonDescVOs(){
		AfterBookingReasonDescVO[] vos = (AfterBookingReasonDescVO[])models.toArray(new AfterBookingReasonDescVO[models.size()]);
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
		this.rsnDescFlg = this.rsnDescFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileLvlNm = this.fileLvlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnFileFlg = this.rsnFileFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.specRsnCd = this.specRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.specRsnDesc = this.specRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnDesc = this.rsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlRmk = this.dtlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileLvlValue = this.fileLvlValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnBtCd = this.rsnBtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
