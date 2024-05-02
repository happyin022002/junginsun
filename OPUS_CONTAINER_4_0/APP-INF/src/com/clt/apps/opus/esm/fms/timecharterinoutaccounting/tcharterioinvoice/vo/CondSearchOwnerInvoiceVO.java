/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CondSearchOwnerInvoiceVO.java
*@FileTitle : CondSearchOwnerInvoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.04 최우석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 최우석
 * @see
 * @since J2EE 1.5
 */

public class CondSearchOwnerInvoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CondSearchOwnerInvoiceVO> models = new ArrayList<CondSearchOwnerInvoiceVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String sheetNo = null;
	/* Column Info */
	private String effDt1 = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String stlFlg = null;
	/* Column Info */
	private String aproFlg = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String effDt2 = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CondSearchOwnerInvoiceVO() {}

	public CondSearchOwnerInvoiceVO(String ibflag, String pagerows, String sheetNo, String vslCd, String effDt1, String aproFlg, String stlFlg, String locCd, String effDt2) {
		this.ibflag = ibflag;
		this.sheetNo = sheetNo;
		this.effDt1 = effDt1;
		this.vslCd = vslCd;
		this.stlFlg = stlFlg;
		this.aproFlg = aproFlg;
		this.locCd = locCd;
		this.effDt2 = effDt2;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sheet_no", getSheetNo());
		this.hashColumns.put("eff_dt1", getEffDt1());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("stl_flg", getStlFlg());
		this.hashColumns.put("apro_flg", getAproFlg());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("eff_dt2", getEffDt2());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sheet_no", "sheetNo");
		this.hashFields.put("eff_dt1", "effDt1");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("stl_flg", "stlFlg");
		this.hashFields.put("apro_flg", "aproFlg");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("eff_dt2", "effDt2");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getSheetNo() {
		return this.sheetNo;
	}
	public String getEffDt1() {
		return this.effDt1;
	}
	public String getVslCd() {
		return this.vslCd;
	}
	public String getStlFlg() {
		return this.stlFlg;
	}
	public String getAproFlg() {
		return this.aproFlg;
	}
	public String getLocCd() {
		return this.locCd;
	}
	public String getEffDt2() {
		return this.effDt2;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setSheetNo(String sheetNo) {
		this.sheetNo = sheetNo;
		//this.sheetNo=true;
	}
	public void setEffDt1(String effDt1) {
		this.effDt1 = effDt1;
		//this.effDt1=true;
	}
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	public void setStlFlg(String stlFlg) {
		this.stlFlg = stlFlg;
		//this.stlFlg=true;
	}
	public void setAproFlg(String aproFlg) {
		this.aproFlg = aproFlg;
		//this.aproFlg=true;
	}
	public void setLocCd(String locCd) {
		this.locCd = locCd;
		//this.locCd=true;
	}
	public void setEffDt2(String effDt2) {
		this.effDt2 = effDt2;
		//this.effDt2=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSheetNo(JSPUtil.getParameter(request, "sheet_no", ""));
		setEffDt1(JSPUtil.getParameter(request, "eff_dt1", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setStlFlg(JSPUtil.getParameter(request, "stlFlg", ""));
		setAproFlg(JSPUtil.getParameter(request, "aproFlg", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setEffDt2(JSPUtil.getParameter(request, "eff_dt2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public CondSearchOwnerInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CondSearchOwnerInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CondSearchOwnerInvoiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] sheetNo = (JSPUtil.getParameter(request, prefix	+ "sheet_no".trim(), length));
			String[] effDt1 = (JSPUtil.getParameter(request, prefix	+ "eff_dt1".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] stlFlg = (JSPUtil.getParameter(request, prefix	+ "stl_flg".trim(), length));
			String[] aproFlg = (JSPUtil.getParameter(request, prefix	+ "apro_flg".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] effDt2 = (JSPUtil.getParameter(request, prefix	+ "eff_dt2".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CondSearchOwnerInvoiceVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sheetNo[i] != null)
					model.setSheetNo(sheetNo[i]);
				if (effDt1[i] != null)
					model.setEffDt1(effDt1[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (stlFlg[i] != null)
					model.setStlFlg(stlFlg[i]);
				if (aproFlg[i] != null)
					model.setAproFlg(aproFlg[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (effDt2[i] != null)
					model.setEffDt2(effDt2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getCondSearchOwnerInvoiceVOs();
	}

	public CondSearchOwnerInvoiceVO[] getCondSearchOwnerInvoiceVOs(){
		CondSearchOwnerInvoiceVO[] vos = (CondSearchOwnerInvoiceVO[])models.toArray(new CondSearchOwnerInvoiceVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetNo = this.sheetNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt1 = this.effDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlFlg = this.stlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFlg = this.aproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt2 = this.effDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
