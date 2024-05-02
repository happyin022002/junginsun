/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CtmCommonVO.java
*@FileTitle : CtmCommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.02  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.vo;

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

public class CtmCommonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CtmCommonVO> models = new ArrayList<CtmCommonVO>();
	
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String oscaBkgFlg = null;
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
	private String pMgset = null;
	/* Column Info */
	private String codeValue = null;
	/* Column Info */
	private String vvdcode = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String pYard1 = null;
	/* Column Info */
	private String pChassisNo = null;
	/* Column Info */
	private String returnNm = null;
	/* Column Info */
	private String pBkgNo = null;
	/* Column Info */
	private String pVvdType = null;
	/* Column Info */
	private String mtyPlnNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CtmCommonVO() {}

	public CtmCommonVO(String ibflag, String pagerows, String bkgCgoTpCd, String columnNm, String pVender, String pBkgNoSplit, String tableNm, String pCntrno, String mvmtStsCd, String codeValue, String vvdcode, String slanCd, String pYard1, String pChassisNo, String returnNm, String pVvdType, String pBkgNo, String pMgset, String oscaBkgFlg, String mtyPlnNo) {
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.oscaBkgFlg = oscaBkgFlg;
		this.columnNm = columnNm;
		this.pVender = pVender;
		this.pBkgNoSplit = pBkgNoSplit;
		this.tableNm = tableNm;
		this.pagerows = pagerows;
		this.pCntrno = pCntrno;
		this.ibflag = ibflag;
		this.mvmtStsCd = mvmtStsCd;
		this.pMgset = pMgset;
		this.codeValue = codeValue;
		this.vvdcode = vvdcode;
		this.slanCd = slanCd;
		this.pYard1 = pYard1;
		this.pChassisNo = pChassisNo;
		this.returnNm = returnNm;
		this.pBkgNo = pBkgNo;
		this.pVvdType = pVvdType;
		this.mtyPlnNo = mtyPlnNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("osca_bkg_flg", getOscaBkgFlg());
		this.hashColumns.put("column_nm", getColumnNm());
		this.hashColumns.put("p_vender", getPVender());
		this.hashColumns.put("p_bkg_no_split", getPBkgNoSplit());
		this.hashColumns.put("table_nm", getTableNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("p_cntrno", getPCntrno());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("p_mgset", getPMgset());
		this.hashColumns.put("code_value", getCodeValue());
		this.hashColumns.put("vvdcode", getVvdcode());
		this.hashColumns.put("slanCd", getSlanCd());
		this.hashColumns.put("p_yard1", getPYard1());
		this.hashColumns.put("p_chassis_no", getPChassisNo());
		this.hashColumns.put("return_nm", getReturnNm());
		this.hashColumns.put("p_bkg_no", getPBkgNo());
		this.hashColumns.put("p_vvd_type", getPVvdType());
		this.hashColumns.put("mty_pln_no", getMtyPlnNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("osca_bkg_flg", "oscaBkgFlg");
		this.hashFields.put("column_nm", "columnNm");
		this.hashFields.put("p_vender", "pVender");
		this.hashFields.put("p_bkg_no_split", "pBkgNoSplit");
		this.hashFields.put("table_nm", "tableNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("p_cntrno", "pCntrno");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("p_mgset", "pMgset");
		this.hashFields.put("code_value", "codeValue");
		this.hashFields.put("vvdcode", "vvdcode");
		this.hashFields.put("slanCd", "slanCd");
		this.hashFields.put("p_yard1", "pYard1");
		this.hashFields.put("p_chassis_no", "pChassisNo");
		this.hashFields.put("return_nm", "returnNm");
		this.hashFields.put("p_bkg_no", "pBkgNo");
		this.hashFields.put("p_vvd_type", "pVvdType");
		this.hashFields.put("mty_pln_no", "mtyPlnNo");
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
	 * @return oscaBkgFlg
	 */
	public String getOscaBkgFlg() {
		return this.oscaBkgFlg;
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
	 * @return pMgset
	 */
	public String getPMgset() {
		return this.pMgset;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
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
	 * @return pBkgNo
	 */
	public String getPBkgNo() {
		return this.pBkgNo;
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
	 * @return mtyPlnNo
	 */
	public String getMtyPlnNo() {
		return this.mtyPlnNo;
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
	 * @param oscaBkgFlg
	 */
	public void setOscaBkgFlg(String oscaBkgFlg) {
		this.oscaBkgFlg = oscaBkgFlg;
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
	 * @param pMgset
	 */
	public void setPMgset(String pMgset) {
		this.pMgset = pMgset;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
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
	 * @param pBkgNo
	 */
	public void setPBkgNo(String pBkgNo) {
		this.pBkgNo = pBkgNo;
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
	 * @param mtyPlnNo
	 */
	public void setMtyPlnNo(String mtyPlnNo) {
		this.mtyPlnNo = mtyPlnNo;
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
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setOscaBkgFlg(JSPUtil.getParameter(request, prefix + "osca_bkg_flg", ""));
		setColumnNm(JSPUtil.getParameter(request, prefix + "column_nm", ""));
		setPVender(JSPUtil.getParameter(request, prefix + "p_vender", ""));
		setPBkgNoSplit(JSPUtil.getParameter(request, prefix + "p_bkg_no_split", ""));
		setTableNm(JSPUtil.getParameter(request, prefix + "table_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPCntrno(JSPUtil.getParameter(request, prefix + "p_cntrno", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setPMgset(JSPUtil.getParameter(request, prefix + "p_mgset", ""));
		setCodeValue(JSPUtil.getParameter(request, prefix + "code_value", ""));
		setVvdcode(JSPUtil.getParameter(request, prefix + "vvdcode", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slanCd", ""));
		setPYard1(JSPUtil.getParameter(request, prefix + "p_yard1", ""));
		setPChassisNo(JSPUtil.getParameter(request, prefix + "p_chassis_no", ""));
		setReturnNm(JSPUtil.getParameter(request, prefix + "return_nm", ""));
		setPBkgNo(JSPUtil.getParameter(request, prefix + "p_bkg_no", ""));
		setPVvdType(JSPUtil.getParameter(request, prefix + "p_vvd_type", ""));
		setMtyPlnNo(JSPUtil.getParameter(request, prefix + "mty_pln_no", ""));
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
			String[] oscaBkgFlg = (JSPUtil.getParameter(request, prefix	+ "osca_bkg_flg", length));
			String[] columnNm = (JSPUtil.getParameter(request, prefix	+ "column_nm", length));
			String[] pVender = (JSPUtil.getParameter(request, prefix	+ "p_vender", length));
			String[] pBkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "p_bkg_no_split", length));
			String[] tableNm = (JSPUtil.getParameter(request, prefix	+ "table_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pCntrno = (JSPUtil.getParameter(request, prefix	+ "p_cntrno", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] pMgset = (JSPUtil.getParameter(request, prefix	+ "p_mgset", length));
			String[] codeValue = (JSPUtil.getParameter(request, prefix	+ "code_value", length));
			String[] vvdcode = (JSPUtil.getParameter(request, prefix	+ "vvdcode", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slanCd", length));
			String[] pYard1 = (JSPUtil.getParameter(request, prefix	+ "p_yard1", length));
			String[] pChassisNo = (JSPUtil.getParameter(request, prefix	+ "p_chassis_no", length));
			String[] returnNm = (JSPUtil.getParameter(request, prefix	+ "return_nm", length));
			String[] pBkgNo = (JSPUtil.getParameter(request, prefix	+ "p_bkg_no", length));
			String[] pVvdType = (JSPUtil.getParameter(request, prefix	+ "p_vvd_type", length));
			String[] mtyPlnNo = (JSPUtil.getParameter(request, prefix	+ "mty_pln_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CtmCommonVO();
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (oscaBkgFlg[i] != null)
					model.setOscaBkgFlg(oscaBkgFlg[i]);
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
				if (pMgset[i] != null)
					model.setPMgset(pMgset[i]);
				if (codeValue[i] != null)
					model.setCodeValue(codeValue[i]);
				if (vvdcode[i] != null)
					model.setVvdcode(vvdcode[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (pYard1[i] != null)
					model.setPYard1(pYard1[i]);
				if (pChassisNo[i] != null)
					model.setPChassisNo(pChassisNo[i]);
				if (returnNm[i] != null)
					model.setReturnNm(returnNm[i]);
				if (pBkgNo[i] != null)
					model.setPBkgNo(pBkgNo[i]);
				if (pVvdType[i] != null)
					model.setPVvdType(pVvdType[i]);
				if (mtyPlnNo[i] != null)
					model.setMtyPlnNo(mtyPlnNo[i]);
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
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oscaBkgFlg = this.oscaBkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.columnNm = this.columnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVender = this.pVender .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBkgNoSplit = this.pBkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tableNm = this.tableNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntrno = this.pCntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pMgset = this.pMgset .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeValue = this.codeValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdcode = this.vvdcode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard1 = this.pYard1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pChassisNo = this.pChassisNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnNm = this.returnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBkgNo = this.pBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVvdType = this.pVvdType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPlnNo = this.mtyPlnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
