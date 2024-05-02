/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ARAcctListVO.java
*@FileTitle : ARAcctListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.24  
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

public class ARAcctListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARAcctListVO> models = new ArrayList<ARAcctListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String arAcctCd = null;
	/* Column Info */
	private String acctTpNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ARAcctListVO() {}

	public ARAcctListVO(String ibflag, String pagerows, String arAcctCd, String acctTpNm) {
		this.ibflag = ibflag;
		this.arAcctCd = arAcctCd;
		this.acctTpNm = acctTpNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ar_acct_cd", getArAcctCd());
		this.hashColumns.put("acct_tp_nm", getAcctTpNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ar_acct_cd", "arAcctCd");
		this.hashFields.put("acct_tp_nm", "acctTpNm");
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
	 * @return arAcctCd
	 */
	public String getArAcctCd() {
		return this.arAcctCd;
	}
	
	/**
	 * Column Info
	 * @return acctTpNm
	 */
	public String getAcctTpNm() {
		return this.acctTpNm;
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
	 * @param arAcctCd
	 */
	public void setArAcctCd(String arAcctCd) {
		this.arAcctCd = arAcctCd;
	}
	
	/**
	 * Column Info
	 * @param acctTpNm
	 */
	public void setAcctTpNm(String acctTpNm) {
		this.acctTpNm = acctTpNm;
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
		setArAcctCd(JSPUtil.getParameter(request, prefix + "ar_acct_cd", ""));
		setAcctTpNm(JSPUtil.getParameter(request, prefix + "acct_tp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARAcctListVO[]
	 */
	public ARAcctListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARAcctListVO[]
	 */
	public ARAcctListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARAcctListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] arAcctCd = (JSPUtil.getParameter(request, prefix	+ "ar_acct_cd", length));
			String[] acctTpNm = (JSPUtil.getParameter(request, prefix	+ "acct_tp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ARAcctListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (arAcctCd[i] != null)
					model.setArAcctCd(arAcctCd[i]);
				if (acctTpNm[i] != null)
					model.setAcctTpNm(acctTpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getARAcctListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ARAcctListVO[]
	 */
	public ARAcctListVO[] getARAcctListVOs(){
		ARAcctListVO[] vos = (ARAcctListVO[])models.toArray(new ARAcctListVO[models.size()]);
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
		this.arAcctCd = this.arAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctTpNm = this.acctTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
