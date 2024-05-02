/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AttentionCustomerVO.java
*@FileTitle : AttentionCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.12  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

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

public class AttentionCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AttentionCustomerVO> models = new ArrayList<AttentionCustomerVO>();
	
	/* Column Info */
	private String payrCntcPntPhnNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String payrCntcPntEml = null;
	/* Column Info */
	private String payrCntcPntFaxNo = null;
	/* Column Info */
	private String dmdtPayrCntcPntNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AttentionCustomerVO() {}

	public AttentionCustomerVO(String ibflag, String pagerows, String dmdtPayrCntcPntNm, String payrCntcPntPhnNo, String payrCntcPntFaxNo, String payrCntcPntEml) {
		this.payrCntcPntPhnNo = payrCntcPntPhnNo;
		this.ibflag = ibflag;
		this.payrCntcPntEml = payrCntcPntEml;
		this.payrCntcPntFaxNo = payrCntcPntFaxNo;
		this.dmdtPayrCntcPntNm = dmdtPayrCntcPntNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("payr_cntc_pnt_phn_no", getPayrCntcPntPhnNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("payr_cntc_pnt_eml", getPayrCntcPntEml());
		this.hashColumns.put("payr_cntc_pnt_fax_no", getPayrCntcPntFaxNo());
		this.hashColumns.put("dmdt_payr_cntc_pnt_nm", getDmdtPayrCntcPntNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("payr_cntc_pnt_phn_no", "payrCntcPntPhnNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("payr_cntc_pnt_eml", "payrCntcPntEml");
		this.hashFields.put("payr_cntc_pnt_fax_no", "payrCntcPntFaxNo");
		this.hashFields.put("dmdt_payr_cntc_pnt_nm", "dmdtPayrCntcPntNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return payrCntcPntPhnNo
	 */
	public String getPayrCntcPntPhnNo() {
		return this.payrCntcPntPhnNo;
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
	 * @return payrCntcPntEml
	 */
	public String getPayrCntcPntEml() {
		return this.payrCntcPntEml;
	}
	
	/**
	 * Column Info
	 * @return payrCntcPntFaxNo
	 */
	public String getPayrCntcPntFaxNo() {
		return this.payrCntcPntFaxNo;
	}
	
	/**
	 * Column Info
	 * @return dmdtPayrCntcPntNm
	 */
	public String getDmdtPayrCntcPntNm() {
		return this.dmdtPayrCntcPntNm;
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
	 * @param payrCntcPntPhnNo
	 */
	public void setPayrCntcPntPhnNo(String payrCntcPntPhnNo) {
		this.payrCntcPntPhnNo = payrCntcPntPhnNo;
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
	 * @param payrCntcPntEml
	 */
	public void setPayrCntcPntEml(String payrCntcPntEml) {
		this.payrCntcPntEml = payrCntcPntEml;
	}
	
	/**
	 * Column Info
	 * @param payrCntcPntFaxNo
	 */
	public void setPayrCntcPntFaxNo(String payrCntcPntFaxNo) {
		this.payrCntcPntFaxNo = payrCntcPntFaxNo;
	}
	
	/**
	 * Column Info
	 * @param dmdtPayrCntcPntNm
	 */
	public void setDmdtPayrCntcPntNm(String dmdtPayrCntcPntNm) {
		this.dmdtPayrCntcPntNm = dmdtPayrCntcPntNm;
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
		setPayrCntcPntPhnNo(JSPUtil.getParameter(request, "payr_cntc_pnt_phn_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPayrCntcPntEml(JSPUtil.getParameter(request, "payr_cntc_pnt_eml", ""));
		setPayrCntcPntFaxNo(JSPUtil.getParameter(request, "payr_cntc_pnt_fax_no", ""));
		setDmdtPayrCntcPntNm(JSPUtil.getParameter(request, "dmdt_payr_cntc_pnt_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AttentionCustomerVO[]
	 */
	public AttentionCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AttentionCustomerVO[]
	 */
	public AttentionCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AttentionCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] payrCntcPntPhnNo = (JSPUtil.getParameter(request, prefix	+ "payr_cntc_pnt_phn_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] payrCntcPntEml = (JSPUtil.getParameter(request, prefix	+ "payr_cntc_pnt_eml", length));
			String[] payrCntcPntFaxNo = (JSPUtil.getParameter(request, prefix	+ "payr_cntc_pnt_fax_no", length));
			String[] dmdtPayrCntcPntNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_payr_cntc_pnt_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AttentionCustomerVO();
				if (payrCntcPntPhnNo[i] != null)
					model.setPayrCntcPntPhnNo(payrCntcPntPhnNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (payrCntcPntEml[i] != null)
					model.setPayrCntcPntEml(payrCntcPntEml[i]);
				if (payrCntcPntFaxNo[i] != null)
					model.setPayrCntcPntFaxNo(payrCntcPntFaxNo[i]);
				if (dmdtPayrCntcPntNm[i] != null)
					model.setDmdtPayrCntcPntNm(dmdtPayrCntcPntNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAttentionCustomerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AttentionCustomerVO[]
	 */
	public AttentionCustomerVO[] getAttentionCustomerVOs(){
		AttentionCustomerVO[] vos = (AttentionCustomerVO[])models.toArray(new AttentionCustomerVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.payrCntcPntPhnNo = this.payrCntcPntPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrCntcPntEml = this.payrCntcPntEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrCntcPntFaxNo = this.payrCntcPntFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayrCntcPntNm = this.dmdtPayrCntcPntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
