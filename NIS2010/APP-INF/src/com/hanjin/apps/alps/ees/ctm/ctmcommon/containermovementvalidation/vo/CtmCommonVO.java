/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CtmCommonVO.java
*@FileTitle : CtmCommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.07.09 김상수
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CtmCommonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CtmCommonVO> models = new ArrayList<CtmCommonVO>();

	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String columnNm = null;
	/* Column Info */
	private String pVender = null;
	/* Column Info */
	private String pBkgNoSplit = null;
	/* Column Info */
	private String tableNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pCntrno = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String codeValue = null;
	/* Column Info */
	private String vvdcode = null;
	/* Column Info */
	private String pYard1 = null;
	/* Column Info */
	private String pChassisNo = null;
	/* Column Info */
	private String returnNm = null;
	/* Column Info */
	private String pVvdType = null;
	/* Column Info */
	private String pBkgNo = null;
	/* Column Info */
	private String pMGSet = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CtmCommonVO() {}

	public CtmCommonVO(String ibflag, String pagerows, String pCntrno, String pYard1, String vvdcode, String pVvdType, String bkgCgoTpCd, String mvmtStsCd, String pVender, String pBkgNo, String pBkgNoSplit, String pChassisNo, String tableNm, String columnNm, String returnNm, String codeValue, String pMGSet) {
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.columnNm = columnNm;
		this.pVender = pVender;
		this.pBkgNoSplit = pBkgNoSplit;
		this.tableNm = tableNm;
		this.pagerows = pagerows;
		this.pCntrno = pCntrno;
		this.ibflag = ibflag;
		this.mvmtStsCd = mvmtStsCd;
		this.codeValue = codeValue;
		this.vvdcode = vvdcode;
		this.pYard1 = pYard1;
		this.pChassisNo = pChassisNo;
		this.returnNm = returnNm;
		this.pVvdType = pVvdType;
		this.pBkgNo = pBkgNo;
		this.pMGSet = pMGSet;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("column_nm", getColumnNm());
		this.hashColumns.put("p_vender", getPVender());
		this.hashColumns.put("p_bkg_no_split", getPBkgNoSplit());
		this.hashColumns.put("table_nm", getTableNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("p_cntrno", getPCntrno());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("code_value", getCodeValue());
		this.hashColumns.put("vvdcode", getVvdcode());
		this.hashColumns.put("p_yard1", getPYard1());
		this.hashColumns.put("p_chassis_no", getPChassisNo());
		this.hashColumns.put("return_nm", getReturnNm());
		this.hashColumns.put("p_vvd_type", getPVvdType());
		this.hashColumns.put("p_bkg_no", getPBkgNo());
		this.hashColumns.put("p_mgset", getPMGSet());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("column_nm", "columnNm");
		this.hashFields.put("p_vender", "pVender");
		this.hashFields.put("p_bkg_no_split", "pBkgNoSplit");
		this.hashFields.put("table_nm", "tableNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("p_cntrno", "pCntrno");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("code_value", "codeValue");
		this.hashFields.put("vvdcode", "vvdcode");
		this.hashFields.put("p_yard1", "pYard1");
		this.hashFields.put("p_chassis_no", "pChassisNo");
		this.hashFields.put("return_nm", "returnNm");
		this.hashFields.put("p_vvd_type", "pVvdType");
		this.hashFields.put("p_bkg_no", "pBkgNo");
		this.hashFields.put("p_mgset", "pMGSet");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}

	/**
	 * Column Info
	 * @return columnNm
	 */
	public String getColumnNm() {
		return this.columnNm;
	}

	/**
	 * Column Info
	 * @return pVender
	 */
	public String getPVender() {
		return this.pVender;
	}

	/**
	 * Column Info
	 * @return pBkgNoSplit
	 */
	public String getPBkgNoSplit() {
		return this.pBkgNoSplit;
	}

	/**
	 * Column Info
	 * @return tableNm
	 */
	public String getTableNm() {
		return this.tableNm;
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
	 * @return pCntrno
	 */
	public String getPCntrno() {
		return this.pCntrno;
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
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
	}

	/**
	 * Column Info
	 * @return codeValue
	 */
	public String getCodeValue() {
		return this.codeValue;
	}

	/**
	 * Column Info
	 * @return vvdcode
	 */
	public String getVvdcode() {
		return this.vvdcode;
	}

	/**
	 * Column Info
	 * @return pYard1
	 */
	public String getPYard1() {
		return this.pYard1;
	}

	/**
	 * Column Info
	 * @return pChassisNo
	 */
	public String getPChassisNo() {
		return this.pChassisNo;
	}

	/**
	 * Column Info
	 * @return returnNm
	 */
	public String getReturnNm() {
		return this.returnNm;
	}

	/**
	 * Column Info
	 * @return pVvdType
	 */
	public String getPVvdType() {
		return this.pVvdType;
	}

	/**
	 * Column Info
	 * @return pBkgNo
	 */
	public String getPBkgNo() {
		return this.pBkgNo;
	}

	/**
	 * Column Info
	 * @return pMGSet
	 */
	public String getPMGSet() {
		return this.pMGSet;
	}

	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}

	/**
	 * Column Info
	 * @param columnNm
	 */
	public void setColumnNm(String columnNm) {
		this.columnNm = columnNm;
	}

	/**
	 * Column Info
	 * @param pVender
	 */
	public void setPVender(String pVender) {
		this.pVender = pVender;
	}

	/**
	 * Column Info
	 * @param pBkgNoSplit
	 */
	public void setPBkgNoSplit(String pBkgNoSplit) {
		this.pBkgNoSplit = pBkgNoSplit;
	}

	/**
	 * Column Info
	 * @param tableNm
	 */
	public void setTableNm(String tableNm) {
		this.tableNm = tableNm;
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
	 * @param pCntrno
	 */
	public void setPCntrno(String pCntrno) {
		this.pCntrno = pCntrno;
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
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
	}

	/**
	 * Column Info
	 * @param codeValue
	 */
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	/**
	 * Column Info
	 * @param vvdcode
	 */
	public void setVvdcode(String vvdcode) {
		this.vvdcode = vvdcode;
	}

	/**
	 * Column Info
	 * @param pYard1
	 */
	public void setPYard1(String pYard1) {
		this.pYard1 = pYard1;
	}

	/**
	 * Column Info
	 * @param pChassisNo
	 */
	public void setPChassisNo(String pChassisNo) {
		this.pChassisNo = pChassisNo;
	}

	/**
	 * Column Info
	 * @param returnNm
	 */
	public void setReturnNm(String returnNm) {
		this.returnNm = returnNm;
	}

	/**
	 * Column Info
	 * @param pVvdType
	 */
	public void setPVvdType(String pVvdType) {
		this.pVvdType = pVvdType;
	}

	/**
	 * Column Info
	 * @param pBkgNo
	 */
	public void setPBkgNo(String pBkgNo) {
		this.pBkgNo = pBkgNo;
	}

	/**
	 * Column Info
	 * @param pMGSet
	 */
	public void setPMGSet(String pMGSet) {
		this.pMGSet = pMGSet;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setColumnNm(JSPUtil.getParameter(request, "column_nm", ""));
		setPVender(JSPUtil.getParameter(request, "p_vender", ""));
		setPBkgNoSplit(JSPUtil.getParameter(request, "p_bkg_no_split", ""));
		setTableNm(JSPUtil.getParameter(request, "table_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPCntrno(JSPUtil.getParameter(request, "p_cntrno", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, "mvmt_sts_cd", ""));
		setCodeValue(JSPUtil.getParameter(request, "code_value", ""));
		setVvdcode(JSPUtil.getParameter(request, "vvdcode", ""));
		setPYard1(JSPUtil.getParameter(request, "p_yard1", ""));
		setPChassisNo(JSPUtil.getParameter(request, "p_chassis_no", ""));
		setReturnNm(JSPUtil.getParameter(request, "return_nm", ""));
		setPVvdType(JSPUtil.getParameter(request, "p_vvd_type", ""));
		setPBkgNo(JSPUtil.getParameter(request, "p_bkg_no", ""));
		setPMGSet(JSPUtil.getParameter(request, "p_mgset", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CtmCommonVO[]
	 */
	public CtmCommonVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CtmCommonVO[]
	 */
	public CtmCommonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CtmCommonVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] columnNm = (JSPUtil.getParameter(request, prefix	+ "column_nm", length));
			String[] pVender = (JSPUtil.getParameter(request, prefix	+ "p_vender", length));
			String[] pBkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "p_bkg_no_split", length));
			String[] tableNm = (JSPUtil.getParameter(request, prefix	+ "table_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pCntrno = (JSPUtil.getParameter(request, prefix	+ "p_cntrno", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] codeValue = (JSPUtil.getParameter(request, prefix	+ "code_value", length));
			String[] vvdcode = (JSPUtil.getParameter(request, prefix	+ "vvdcode", length));
			String[] pYard1 = (JSPUtil.getParameter(request, prefix	+ "p_yard1", length));
			String[] pChassisNo = (JSPUtil.getParameter(request, prefix	+ "p_chassis_no", length));
			String[] returnNm = (JSPUtil.getParameter(request, prefix	+ "return_nm", length));
			String[] pVvdType = (JSPUtil.getParameter(request, prefix	+ "p_vvd_type", length));
			String[] pBkgNo = (JSPUtil.getParameter(request, prefix	+ "p_bkg_no", length));
			String[] pMGSet = (JSPUtil.getParameter(request, prefix	+ "p_mgset", length));
			
			for (int i = 0; i < length; i++) {
				model = new CtmCommonVO();
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (columnNm[i] != null)
					model.setColumnNm(columnNm[i]);
				if (pVender[i] != null)
					model.setPVender(pVender[i]);
				if (pBkgNoSplit[i] != null)
					model.setPBkgNoSplit(pBkgNoSplit[i]);
				if (tableNm[i] != null)
					model.setTableNm(tableNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pCntrno[i] != null)
					model.setPCntrno(pCntrno[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (codeValue[i] != null)
					model.setCodeValue(codeValue[i]);
				if (vvdcode[i] != null)
					model.setVvdcode(vvdcode[i]);
				if (pYard1[i] != null)
					model.setPYard1(pYard1[i]);
				if (pChassisNo[i] != null)
					model.setPChassisNo(pChassisNo[i]);
				if (returnNm[i] != null)
					model.setReturnNm(returnNm[i]);
				if (pVvdType[i] != null)
					model.setPVvdType(pVvdType[i]);
				if (pBkgNo[i] != null)
					model.setPBkgNo(pBkgNo[i]);
				if (pMGSet[i] != null)
					model.setPMGSet(pMGSet[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCtmCommonVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CtmCommonVO[]
	 */
	public CtmCommonVO[] getCtmCommonVOs(){
		CtmCommonVO[] vos = (CtmCommonVO[])models.toArray(new CtmCommonVO[models.size()]);
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
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.columnNm = this.columnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVender = this.pVender .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBkgNoSplit = this.pBkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tableNm = this.tableNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntrno = this.pCntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeValue = this.codeValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdcode = this.vvdcode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard1 = this.pYard1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pChassisNo = this.pChassisNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnNm = this.returnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVvdType = this.pVvdType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBkgNo = this.pBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
