/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonInitDataINVO.java
*@FileTitle : CommonInitDataINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.10.14 김완규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CommonInitDataINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CommonInitDataINVO> models = new ArrayList<CommonInitDataINVO>();
	
	/* Column Info */
	private String prntColValue = null;
	/* Column Info */
	private String comCodeSearchInd = null;
	/* Column Info */
	private String typeSizeSearchInd = null;
	/* Column Info */
	private String orderByColNm = null;
	/* Column Info */
	private String codeType = null;
	/* Column Info */
	private String prntColNm = null;
	/* Column Info */
	private String tableNm = null;
	/* Column Info */
	private String cdColNm = null;
	/* Column Info */
	private String eqType = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String descColNm = null;
	/* Column Info */
	private String kndCd = null;
	/* Column Info */
	private String totalLossDate = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CommonInitDataINVO() {}

	public CommonInitDataINVO(String ibflag, String pagerows, String prntColValue, String typeSizeSearchInd, String orderByColNm, String prntColNm, String tableNm, String cdColNm, String eqType, String eqNo, String descColNm, String kndCd, String totalLossDate, String comCodeSearchInd, String codeType) {
		this.prntColValue = prntColValue;
		this.comCodeSearchInd = comCodeSearchInd;
		this.typeSizeSearchInd = typeSizeSearchInd;
		this.orderByColNm = orderByColNm;
		this.codeType = codeType;
		this.prntColNm = prntColNm;
		this.tableNm = tableNm;
		this.cdColNm = cdColNm;
		this.eqType = eqType;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.descColNm = descColNm;
		this.kndCd = kndCd;
		this.totalLossDate = totalLossDate;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("prnt_col_value", getPrntColValue());
		this.hashColumns.put("com_code_search_ind", getComCodeSearchInd());
		this.hashColumns.put("type_size_search_ind", getTypeSizeSearchInd());
		this.hashColumns.put("order_by_col_nm", getOrderByColNm());
		this.hashColumns.put("code_type", getCodeType());
		this.hashColumns.put("prnt_col_nm", getPrntColNm());
		this.hashColumns.put("table_nm", getTableNm());
		this.hashColumns.put("cd_col_nm", getCdColNm());
		this.hashColumns.put("eq_type", getEqType());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("desc_col_nm", getDescColNm());
		this.hashColumns.put("knd_cd", getKndCd());
		this.hashColumns.put("total_loss_date", getTotalLossDate());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("prnt_col_value", "prntColValue");
		this.hashFields.put("com_code_search_ind", "comCodeSearchInd");
		this.hashFields.put("type_size_search_ind", "typeSizeSearchInd");
		this.hashFields.put("order_by_col_nm", "orderByColNm");
		this.hashFields.put("code_type", "codeType");
		this.hashFields.put("prnt_col_nm", "prntColNm");
		this.hashFields.put("table_nm", "tableNm");
		this.hashFields.put("cd_col_nm", "cdColNm");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("desc_col_nm", "descColNm");
		this.hashFields.put("knd_cd", "kndCd");
		this.hashFields.put("total_loss_date", "totalLossDate");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return prntColValue
	 */
	public String getPrntColValue() {
		return this.prntColValue;
	}
	
	/**
	 * Column Info
	 * @return comCodeSearchInd
	 */
	public String getComCodeSearchInd() {
		return this.comCodeSearchInd;
	}
	
	/**
	 * Column Info
	 * @return typeSizeSearchInd
	 */
	public String getTypeSizeSearchInd() {
		return this.typeSizeSearchInd;
	}
	
	/**
	 * Column Info
	 * @return orderByColNm
	 */
	public String getOrderByColNm() {
		return this.orderByColNm;
	}
	
	/**
	 * Column Info
	 * @return codeType
	 */
	public String getCodeType() {
		return this.codeType;
	}
	
	/**
	 * Column Info
	 * @return prntColNm
	 */
	public String getPrntColNm() {
		return this.prntColNm;
	}
	
	/**
	 * Column Info
	 * @return tableNm
	 */
	public String getTableNm() {
		return this.tableNm;
	}
	
	/**
	 * Column Info
	 * @return cdColNm
	 */
	public String getCdColNm() {
		return this.cdColNm;
	}
	
	/**
	 * Column Info
	 * @return eqType
	 */
	public String getEqType() {
		return this.eqType;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return descColNm
	 */
	public String getDescColNm() {
		return this.descColNm;
	}
	
	/**
	 * Column Info
	 * @return kndCd
	 */
	public String getKndCd() {
		return this.kndCd;
	}
	
	/**
	 * Column Info
	 * @return totalLossDate
	 */
	public String getTotalLossDate() {
		return this.totalLossDate;
	}
	

	/**
	 * Column Info
	 * @param prntColValue
	 */
	public void setPrntColValue(String prntColValue) {
		this.prntColValue = prntColValue;
	}
	
	/**
	 * Column Info
	 * @param comCodeSearchInd
	 */
	public void setComCodeSearchInd(String comCodeSearchInd) {
		this.comCodeSearchInd = comCodeSearchInd;
	}
	
	/**
	 * Column Info
	 * @param typeSizeSearchInd
	 */
	public void setTypeSizeSearchInd(String typeSizeSearchInd) {
		this.typeSizeSearchInd = typeSizeSearchInd;
	}
	
	/**
	 * Column Info
	 * @param orderByColNm
	 */
	public void setOrderByColNm(String orderByColNm) {
		this.orderByColNm = orderByColNm;
	}
	
	/**
	 * Column Info
	 * @param codeType
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	
	/**
	 * Column Info
	 * @param prntColNm
	 */
	public void setPrntColNm(String prntColNm) {
		this.prntColNm = prntColNm;
	}
	
	/**
	 * Column Info
	 * @param tableNm
	 */
	public void setTableNm(String tableNm) {
		this.tableNm = tableNm;
	}
	
	/**
	 * Column Info
	 * @param cdColNm
	 */
	public void setCdColNm(String cdColNm) {
		this.cdColNm = cdColNm;
	}
	
	/**
	 * Column Info
	 * @param eqType
	 */
	public void setEqType(String eqType) {
		this.eqType = eqType;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param descColNm
	 */
	public void setDescColNm(String descColNm) {
		this.descColNm = descColNm;
	}
	
	/**
	 * Column Info
	 * @param kndCd
	 */
	public void setKndCd(String kndCd) {
		this.kndCd = kndCd;
	}
	
	/**
	 * Column Info
	 * @param totalLossDate
	 */
	public void setTotalLossDate(String totalLossDate) {
		this.totalLossDate = totalLossDate;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPrntColValue(JSPUtil.getParameter(request, "prnt_col_value", ""));
		setComCodeSearchInd(JSPUtil.getParameter(request, "com_code_search_ind", ""));
		setTypeSizeSearchInd(JSPUtil.getParameter(request, "type_size_search_ind", ""));
		setOrderByColNm(JSPUtil.getParameter(request, "order_by_col_nm", ""));
		setCodeType(JSPUtil.getParameter(request, "code_type", ""));
		setPrntColNm(JSPUtil.getParameter(request, "prnt_col_nm", ""));
		setTableNm(JSPUtil.getParameter(request, "table_nm", ""));
		setCdColNm(JSPUtil.getParameter(request, "cd_col_nm", ""));
		setEqType(JSPUtil.getParameter(request, "eq_type", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setDescColNm(JSPUtil.getParameter(request, "desc_col_nm", ""));
		setKndCd(JSPUtil.getParameter(request, "knd_cd", ""));
		setTotalLossDate(JSPUtil.getParameter(request, "total_loss_date", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CommonInitDataINVO[]
	 */
	public CommonInitDataINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CommonInitDataINVO[]
	 */
	public CommonInitDataINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CommonInitDataINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] prntColValue = (JSPUtil.getParameter(request, prefix	+ "prnt_col_value", length));
			String[] comCodeSearchInd = (JSPUtil.getParameter(request, prefix	+ "com_code_search_ind", length));
			String[] typeSizeSearchInd = (JSPUtil.getParameter(request, prefix	+ "type_size_search_ind", length));
			String[] orderByColNm = (JSPUtil.getParameter(request, prefix	+ "order_by_col_nm", length));
			String[] codeType = (JSPUtil.getParameter(request, prefix	+ "code_type", length));
			String[] prntColNm = (JSPUtil.getParameter(request, prefix	+ "prnt_col_nm", length));
			String[] tableNm = (JSPUtil.getParameter(request, prefix	+ "table_nm", length));
			String[] cdColNm = (JSPUtil.getParameter(request, prefix	+ "cd_col_nm", length));
			String[] eqType = (JSPUtil.getParameter(request, prefix	+ "eq_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] descColNm = (JSPUtil.getParameter(request, prefix	+ "desc_col_nm", length));
			String[] kndCd = (JSPUtil.getParameter(request, prefix	+ "knd_cd", length));
			String[] totalLossDate = (JSPUtil.getParameter(request, prefix	+ "total_loss_date", length));
			
			for (int i = 0; i < length; i++) {
				model = new CommonInitDataINVO();
				if (prntColValue[i] != null)
					model.setPrntColValue(prntColValue[i]);
				if (comCodeSearchInd[i] != null)
					model.setComCodeSearchInd(comCodeSearchInd[i]);
				if (typeSizeSearchInd[i] != null)
					model.setTypeSizeSearchInd(typeSizeSearchInd[i]);
				if (orderByColNm[i] != null)
					model.setOrderByColNm(orderByColNm[i]);
				if (codeType[i] != null)
					model.setCodeType(codeType[i]);
				if (prntColNm[i] != null)
					model.setPrntColNm(prntColNm[i]);
				if (tableNm[i] != null)
					model.setTableNm(tableNm[i]);
				if (cdColNm[i] != null)
					model.setCdColNm(cdColNm[i]);
				if (eqType[i] != null)
					model.setEqType(eqType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (descColNm[i] != null)
					model.setDescColNm(descColNm[i]);
				if (kndCd[i] != null)
					model.setKndCd(kndCd[i]);
				if (totalLossDate[i] != null)
					model.setTotalLossDate(totalLossDate[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCommonInitDataINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CommonInitDataINVO[]
	 */
	public CommonInitDataINVO[] getCommonInitDataINVOs(){
		CommonInitDataINVO[] vos = (CommonInitDataINVO[])models.toArray(new CommonInitDataINVO[models.size()]);
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
		this.prntColValue = this.prntColValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comCodeSearchInd = this.comCodeSearchInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeSizeSearchInd = this.typeSizeSearchInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderByColNm = this.orderByColNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeType = this.codeType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntColNm = this.prntColNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tableNm = this.tableNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdColNm = this.cdColNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType = this.eqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.descColNm = this.descColNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kndCd = this.kndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalLossDate = this.totalLossDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
