/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MdmChgTaxFlgVO.java
*@FileTitle : MdmChgTaxFlgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.11  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo;

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

public class MdmChgTaxFlgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MdmChgTaxFlgVO> models = new ArrayList<MdmChgTaxFlgVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String chgNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String taxFlg = null;
	/* Column Info */
	private String taxCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MdmChgTaxFlgVO() {}

	public MdmChgTaxFlgVO(String ibflag, String pagerows, String chgCd, String chgNm, String taxFlg, String taxCntCd) {
		this.pagerows = pagerows;
		this.chgCd = chgCd;
		this.chgNm = chgNm;
		this.ibflag = ibflag;
		this.taxFlg = taxFlg;
		this.taxCntCd = taxCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("chg_nm", getChgNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tax_flg", getTaxFlg());
		this.hashColumns.put("tax_cnt_cd", getTaxCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("chg_nm", "chgNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tax_flg", "taxFlg");
		this.hashFields.put("tax_cnt_cd", "taxCntCd");
		return this.hashFields;
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
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Column Info
	 * @return chgNm
	 */
	public String getChgNm() {
		return this.chgNm;
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
	 * @return taxFlg
	 */
	public String getTaxFlg() {
		return this.taxFlg;
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
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @param chgNm
	 */
	public void setChgNm(String chgNm) {
		this.chgNm = chgNm;
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
	 * @param taxFlg
	 */
	public void setTaxFlg(String taxFlg) {
		this.taxFlg = taxFlg;
	}
	
	/**
	 * @return the taxCntCd
	 */
	public String getTaxCntCd() {
		return taxCntCd;
	}

	/**
	 * @param taxCntCd the taxCntCd to set
	 */
	public void setTaxCntCd(String taxCntCd) {
		this.taxCntCd = taxCntCd;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setChgNm(JSPUtil.getParameter(request, prefix + "chg_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTaxFlg(JSPUtil.getParameter(request, prefix + "tax_flg", ""));
		setTaxCntCd(JSPUtil.getParameter(request, prefix + "tax_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MdmChgTaxFlgVO[]
	 */
	public MdmChgTaxFlgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MdmChgTaxFlgVO[]
	 */
	public MdmChgTaxFlgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MdmChgTaxFlgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] chgNm = (JSPUtil.getParameter(request, prefix	+ "chg_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] taxFlg = (JSPUtil.getParameter(request, prefix	+ "tax_flg", length));
			String[] taxCntCd = (JSPUtil.getParameter(request, prefix	+ "tax_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new MdmChgTaxFlgVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (chgNm[i] != null)
					model.setChgNm(chgNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (taxFlg[i] != null)
					model.setTaxFlg(taxFlg[i]);
				if (taxCntCd[i] != null)
					model.setTaxCntCd(taxCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMdmChgTaxFlgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MdmChgTaxFlgVO[]
	 */
	public MdmChgTaxFlgVO[] getMdmChgTaxFlgVOs(){
		MdmChgTaxFlgVO[] vos = (MdmChgTaxFlgVO[])models.toArray(new MdmChgTaxFlgVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgNm = this.chgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxFlg = this.taxFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxCntCd = this.taxCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
