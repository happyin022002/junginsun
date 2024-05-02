/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IdaDoRlseSearchVO.java
*@FileTitle : IdaDoRlseSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.08.18 박만건 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 박만건
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IdaDoRlseSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IdaDoRlseSearchVO> models = new ArrayList<IdaDoRlseSearchVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String evntOfcCd = null;
	/* Column Info */
	private String evntDtYm = null;
	/* Column Info */
	private String excelFlg = null;
	/* Column Info */
	private String evntDtTo = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String rdFlag = null;
	/* Column Info */
	private String evntDtFm = null;
	/* Column Info */
	private String dmdtPayTpCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IdaDoRlseSearchVO() {}

	public IdaDoRlseSearchVO(String ibflag, String pagerows, String evntOfcCd, String dmdtPayTpCd, String evntDtFm, String evntDtTo, String evntDtYm, String blNo, String cntrNo, String rdFlag, String excelFlg, String pageNo) {
		this.ibflag = ibflag;
		this.evntOfcCd = evntOfcCd;
		this.evntDtYm = evntDtYm;
		this.excelFlg = excelFlg;
		this.evntDtTo = evntDtTo;
		this.pageNo = pageNo;
		this.cntrNo = cntrNo;
		this.rdFlag = rdFlag;
		this.evntDtFm = evntDtFm;
		this.dmdtPayTpCd = dmdtPayTpCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());
		this.hashColumns.put("evnt_dt_ym", getEvntDtYm());
		this.hashColumns.put("excel_flg", getExcelFlg());
		this.hashColumns.put("evnt_dt_to", getEvntDtTo());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("rd_flag", getRdFlag());
		this.hashColumns.put("evnt_dt_fm", getEvntDtFm());
		this.hashColumns.put("dmdt_pay_tp_cd", getDmdtPayTpCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("evnt_dt_ym", "evntDtYm");
		this.hashFields.put("excel_flg", "excelFlg");
		this.hashFields.put("evnt_dt_to", "evntDtTo");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("rd_flag", "rdFlag");
		this.hashFields.put("evnt_dt_fm", "evntDtFm");
		this.hashFields.put("dmdt_pay_tp_cd", "dmdtPayTpCd");
		this.hashFields.put("bl_no", "blNo");
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
	 * @return evntOfcCd
	 */
	public String getEvntOfcCd() {
		return this.evntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return evntDtYm
	 */
	public String getEvntDtYm() {
		return this.evntDtYm;
	}
	
	/**
	 * Column Info
	 * @return excelFlg
	 */
	public String getExcelFlg() {
		return this.excelFlg;
	}
	
	/**
	 * Column Info
	 * @return evntDtTo
	 */
	public String getEvntDtTo() {
		return this.evntDtTo;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return rdFlag
	 */
	public String getRdFlag() {
		return this.rdFlag;
	}
	
	/**
	 * Column Info
	 * @return evntDtFm
	 */
	public String getEvntDtFm() {
		return this.evntDtFm;
	}
	
	/**
	 * Column Info
	 * @return dmdtPayTpCd
	 */
	public String getDmdtPayTpCd() {
		return this.dmdtPayTpCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @param evntOfcCd
	 */
	public void setEvntOfcCd(String evntOfcCd) {
		this.evntOfcCd = evntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param evntDtYm
	 */
	public void setEvntDtYm(String evntDtYm) {
		this.evntDtYm = evntDtYm;
	}
	
	/**
	 * Column Info
	 * @param excelFlg
	 */
	public void setExcelFlg(String excelFlg) {
		this.excelFlg = excelFlg;
	}
	
	/**
	 * Column Info
	 * @param evntDtTo
	 */
	public void setEvntDtTo(String evntDtTo) {
		this.evntDtTo = evntDtTo;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param rdFlag
	 */
	public void setRdFlag(String rdFlag) {
		this.rdFlag = rdFlag;
	}
	
	/**
	 * Column Info
	 * @param evntDtFm
	 */
	public void setEvntDtFm(String evntDtFm) {
		this.evntDtFm = evntDtFm;
	}
	
	/**
	 * Column Info
	 * @param dmdtPayTpCd
	 */
	public void setDmdtPayTpCd(String dmdtPayTpCd) {
		this.dmdtPayTpCd = dmdtPayTpCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
		setEvntOfcCd(JSPUtil.getParameter(request, "evnt_ofc_cd", ""));
		setEvntDtYm(JSPUtil.getParameter(request, "evnt_dt_ym", ""));
		setExcelFlg(JSPUtil.getParameter(request, "excel_flg", ""));
		setEvntDtTo(JSPUtil.getParameter(request, "evnt_dt_to", ""));
		setPageNo(JSPUtil.getParameter(request, "page_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setRdFlag(JSPUtil.getParameter(request, "rd_flag", ""));
		setEvntDtFm(JSPUtil.getParameter(request, "evnt_dt_fm", ""));
		setDmdtPayTpCd(JSPUtil.getParameter(request, "dmdt_pay_tp_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IdaDoRlseSearchVO[]
	 */
	public IdaDoRlseSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IdaDoRlseSearchVO[]
	 */
	public IdaDoRlseSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IdaDoRlseSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] evntOfcCd = (JSPUtil.getParameter(request, prefix	+ "evnt_ofc_cd", length));
			String[] evntDtYm = (JSPUtil.getParameter(request, prefix	+ "evnt_dt_ym", length));
			String[] excelFlg = (JSPUtil.getParameter(request, prefix	+ "excel_flg", length));
			String[] evntDtTo = (JSPUtil.getParameter(request, prefix	+ "evnt_dt_to", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] rdFlag = (JSPUtil.getParameter(request, prefix	+ "rd_flag", length));
			String[] evntDtFm = (JSPUtil.getParameter(request, prefix	+ "evnt_dt_fm", length));
			String[] dmdtPayTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_pay_tp_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new IdaDoRlseSearchVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (evntOfcCd[i] != null)
					model.setEvntOfcCd(evntOfcCd[i]);
				if (evntDtYm[i] != null)
					model.setEvntDtYm(evntDtYm[i]);
				if (excelFlg[i] != null)
					model.setExcelFlg(excelFlg[i]);
				if (evntDtTo[i] != null)
					model.setEvntDtTo(evntDtTo[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (rdFlag[i] != null)
					model.setRdFlag(rdFlag[i]);
				if (evntDtFm[i] != null)
					model.setEvntDtFm(evntDtFm[i]);
				if (dmdtPayTpCd[i] != null)
					model.setDmdtPayTpCd(dmdtPayTpCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIdaDoRlseSearchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IdaDoRlseSearchVO[]
	 */
	public IdaDoRlseSearchVO[] getIdaDoRlseSearchVOs(){
		IdaDoRlseSearchVO[] vos = (IdaDoRlseSearchVO[])models.toArray(new IdaDoRlseSearchVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntOfcCd = this.evntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDtYm = this.evntDtYm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelFlg = this.excelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDtTo = this.evntDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFlag = this.rdFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDtFm = this.evntDtFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayTpCd = this.dmdtPayTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
