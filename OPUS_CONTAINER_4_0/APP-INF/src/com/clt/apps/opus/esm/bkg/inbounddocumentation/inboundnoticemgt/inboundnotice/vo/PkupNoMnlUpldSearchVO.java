/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PkupNoMnlUpldSearchVO.java
*@FileTitle : PkupNoMnlUpldSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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

public class PkupNoMnlUpldSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PkupNoMnlUpldSearchVO> models = new ArrayList<PkupNoMnlUpldSearchVO>();
	
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blNos = null;
	/* Column Info */
	private String excelFlg = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String schTpCd = null;
	/* Column Info */
	private String dtE = null;
	/* Column Info */
	private String dtS = null;
	/* Column Info */
	private String eqOfc = null;
	/* Column Info */
	private String podCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PkupNoMnlUpldSearchVO() {}

	public PkupNoMnlUpldSearchVO(String ibflag, String pagerows, String blNos, String cntrNo, String dtE, String dtS, String eqOfc, String excelFlg, String pageNo, String schTpCd, String vvd, String podCd) {
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.blNos = blNos;
		this.excelFlg = excelFlg;
		this.pageNo = pageNo;
		this.cntrNo = cntrNo;
		this.schTpCd = schTpCd;
		this.dtE = dtE;
		this.dtS = dtS;
		this.eqOfc = eqOfc;
		this.pagerows = pagerows;
		this.podCd = podCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_nos", getBlNos());
		this.hashColumns.put("excel_flg", getExcelFlg());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("sch_tp_cd", getSchTpCd());
		this.hashColumns.put("dt_e", getDtE());
		this.hashColumns.put("dt_s", getDtS());
		this.hashColumns.put("eq_ofc", getEqOfc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_nos", "blNos");
		this.hashFields.put("excel_flg", "excelFlg");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("sch_tp_cd", "schTpCd");
		this.hashFields.put("dt_e", "dtE");
		this.hashFields.put("dt_s", "dtS");
		this.hashFields.put("eq_ofc", "eqOfc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return blNos
	 */
	public String getBlNos() {
		return this.blNos;
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
	 * @return schTpCd
	 */
	public String getSchTpCd() {
		return this.schTpCd;
	}
	
	/**
	 * Column Info
	 * @return dtE
	 */
	public String getDtE() {
		return this.dtE;
	}
	
	/**
	 * Column Info
	 * @return dtS
	 */
	public String getDtS() {
		return this.dtS;
	}
	
	/**
	 * Column Info
	 * @return eqOfc
	 */
	public String getEqOfc() {
		return this.eqOfc;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Page Number
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	

	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param blNos
	 */
	public void setBlNos(String blNos) {
		this.blNos = blNos;
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
	 * @param schTpCd
	 */
	public void setSchTpCd(String schTpCd) {
		this.schTpCd = schTpCd;
	}
	
	/**
	 * Column Info
	 * @param dtE
	 */
	public void setDtE(String dtE) {
		this.dtE = dtE;
	}
	
	/**
	 * Column Info
	 * @param dtS
	 */
	public void setDtS(String dtS) {
		this.dtS = dtS;
	}
	
	/**
	 * Column Info
	 * @param eqOfc
	 */
	public void setEqOfc(String eqOfc) {
		this.eqOfc = eqOfc;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Page Number
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBlNos(JSPUtil.getParameter(request, prefix + "bl_nos", ""));
		setExcelFlg(JSPUtil.getParameter(request, prefix + "excel_flg", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setSchTpCd(JSPUtil.getParameter(request, prefix + "sch_tp_cd", ""));
		setDtE(JSPUtil.getParameter(request, prefix + "dt_e", ""));
		setDtS(JSPUtil.getParameter(request, prefix + "dt_s", ""));
		setEqOfc(JSPUtil.getParameter(request, prefix + "eq_ofc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PkupNoMnlUpldSearchVO[]
	 */
	public PkupNoMnlUpldSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PkupNoMnlUpldSearchVO[]
	 */
	public PkupNoMnlUpldSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PkupNoMnlUpldSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blNos = (JSPUtil.getParameter(request, prefix	+ "bl_nos", length));
			String[] excelFlg = (JSPUtil.getParameter(request, prefix	+ "excel_flg", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] schTpCd = (JSPUtil.getParameter(request, prefix	+ "sch_tp_cd", length));
			String[] dtE = (JSPUtil.getParameter(request, prefix	+ "dt_e", length));
			String[] dtS = (JSPUtil.getParameter(request, prefix	+ "dt_s", length));
			String[] eqOfc = (JSPUtil.getParameter(request, prefix	+ "eq_ofc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PkupNoMnlUpldSearchVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blNos[i] != null)
					model.setBlNos(blNos[i]);
				if (excelFlg[i] != null)
					model.setExcelFlg(excelFlg[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (schTpCd[i] != null)
					model.setSchTpCd(schTpCd[i]);
				if (dtE[i] != null)
					model.setDtE(dtE[i]);
				if (dtS[i] != null)
					model.setDtS(dtS[i]);
				if (eqOfc[i] != null)
					model.setEqOfc(eqOfc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPkupNoMnlUpldSearchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PkupNoMnlUpldSearchVO[]
	 */
	public PkupNoMnlUpldSearchVO[] getPkupNoMnlUpldSearchVOs(){
		PkupNoMnlUpldSearchVO[] vos = (PkupNoMnlUpldSearchVO[])models.toArray(new PkupNoMnlUpldSearchVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNos = this.blNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelFlg = this.excelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schTpCd = this.schTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtE = this.dtE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtS = this.dtS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOfc = this.eqOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
