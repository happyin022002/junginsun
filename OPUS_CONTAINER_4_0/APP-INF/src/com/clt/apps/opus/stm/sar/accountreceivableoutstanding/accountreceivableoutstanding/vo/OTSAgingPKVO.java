/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OTSAgingPKVO.java
*@FileTitle : OTSAgingPKVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.11  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo;

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

public class OTSAgingPKVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OTSAgingPKVO> models = new ArrayList<OTSAgingPKVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custNum = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String primaryKey = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String cltOfcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OTSAgingPKVO() {}

	public OTSAgingPKVO(String ibflag, String pagerows, String primaryKey, String cltOfcCd, String custNum, String custNm, String arHdQtrOfcCd) {
		this.ibflag = ibflag;
		this.custNum = custNum;
		this.custNm = custNm;
		this.primaryKey = primaryKey;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.cltOfcCd = cltOfcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_num", getCustNum());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("primary_key", getPrimaryKey());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("clt_ofc_cd", getCltOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_num", "custNum");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("primary_key", "primaryKey");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("clt_ofc_cd", "cltOfcCd");
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
	 * @return custNum
	 */
	public String getCustNum() {
		return this.custNum;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return primaryKey
	 */
	public String getPrimaryKey() {
		return this.primaryKey;
	}
	
	/**
	 * Column Info
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cltOfcCd
	 */
	public String getCltOfcCd() {
		return this.cltOfcCd;
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
	 * @param custNum
	 */
	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param primaryKey
	 */
	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	/**
	 * Column Info
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cltOfcCd
	 */
	public void setCltOfcCd(String cltOfcCd) {
		this.cltOfcCd = cltOfcCd;
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
		setCustNum(JSPUtil.getParameter(request, prefix + "cust_num", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setPrimaryKey(JSPUtil.getParameter(request, prefix + "primary_key", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", ""));
		setCltOfcCd(JSPUtil.getParameter(request, prefix + "clt_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OTSAgingPKVO[]
	 */
	public OTSAgingPKVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OTSAgingPKVO[]
	 */
	public OTSAgingPKVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OTSAgingPKVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custNum = (JSPUtil.getParameter(request, prefix	+ "cust_num", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] primaryKey = (JSPUtil.getParameter(request, prefix	+ "primary_key", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] cltOfcCd = (JSPUtil.getParameter(request, prefix	+ "clt_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new OTSAgingPKVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custNum[i] != null)
					model.setCustNum(custNum[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (primaryKey[i] != null)
					model.setPrimaryKey(primaryKey[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (cltOfcCd[i] != null)
					model.setCltOfcCd(cltOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOTSAgingPKVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OTSAgingPKVO[]
	 */
	public OTSAgingPKVO[] getOTSAgingPKVOs(){
		OTSAgingPKVO[] vos = (OTSAgingPKVO[])models.toArray(new OTSAgingPKVO[models.size()]);
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
		this.custNum = this.custNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.primaryKey = this.primaryKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd = this.cltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
