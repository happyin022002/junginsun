/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VendorInfoVO.java
*@FileTitle : VendorInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.11  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo;

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

public class VendorInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VendorInfoVO> models = new ArrayList<VendorInfoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String genPayTermCd = null;
	/* Column Info */
	private String apPayMzdLuCd = null;
	/* Column Info */
	private String interCoCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VendorInfoVO() {}

	public VendorInfoVO(String ibflag, String pagerows, String genPayTermCd, String interCoCd, String apPayMzdLuCd) {
		this.ibflag = ibflag;
		this.genPayTermCd = genPayTermCd;
		this.apPayMzdLuCd = apPayMzdLuCd;
		this.interCoCd = interCoCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gen_pay_term_cd", getGenPayTermCd());
		this.hashColumns.put("ap_pay_mzd_lu_cd", getApPayMzdLuCd());
		this.hashColumns.put("inter_co_cd", getInterCoCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gen_pay_term_cd", "genPayTermCd");
		this.hashFields.put("ap_pay_mzd_lu_cd", "apPayMzdLuCd");
		this.hashFields.put("inter_co_cd", "interCoCd");
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
	 * @return genPayTermCd
	 */
	public String getGenPayTermCd() {
		return this.genPayTermCd;
	}
	
	/**
	 * Column Info
	 * @return apPayMzdLuCd
	 */
	public String getApPayMzdLuCd() {
		return this.apPayMzdLuCd;
	}
	
	/**
	 * Column Info
	 * @return interCoCd
	 */
	public String getInterCoCd() {
		return this.interCoCd;
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
	 * @param genPayTermCd
	 */
	public void setGenPayTermCd(String genPayTermCd) {
		this.genPayTermCd = genPayTermCd;
	}
	
	/**
	 * Column Info
	 * @param apPayMzdLuCd
	 */
	public void setApPayMzdLuCd(String apPayMzdLuCd) {
		this.apPayMzdLuCd = apPayMzdLuCd;
	}
	
	/**
	 * Column Info
	 * @param interCoCd
	 */
	public void setInterCoCd(String interCoCd) {
		this.interCoCd = interCoCd;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGenPayTermCd(JSPUtil.getParameter(request, prefix + "gen_pay_term_cd", ""));
		setApPayMzdLuCd(JSPUtil.getParameter(request, prefix + "ap_pay_mzd_lu_cd", ""));
		setInterCoCd(JSPUtil.getParameter(request, prefix + "inter_co_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VendorInfoVO[]
	 */
	public VendorInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VendorInfoVO[]
	 */
	public VendorInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VendorInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] genPayTermCd = (JSPUtil.getParameter(request, prefix	+ "gen_pay_term_cd", length));
			String[] apPayMzdLuCd = (JSPUtil.getParameter(request, prefix	+ "ap_pay_mzd_lu_cd", length));
			String[] interCoCd = (JSPUtil.getParameter(request, prefix	+ "inter_co_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new VendorInfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (genPayTermCd[i] != null)
					model.setGenPayTermCd(genPayTermCd[i]);
				if (apPayMzdLuCd[i] != null)
					model.setApPayMzdLuCd(apPayMzdLuCd[i]);
				if (interCoCd[i] != null)
					model.setInterCoCd(interCoCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVendorInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VendorInfoVO[]
	 */
	public VendorInfoVO[] getVendorInfoVOs(){
		VendorInfoVO[] vos = (VendorInfoVO[])models.toArray(new VendorInfoVO[models.size()]);
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
		this.genPayTermCd = this.genPayTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apPayMzdLuCd = this.apPayMzdLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interCoCd = this.interCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
