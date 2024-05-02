/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MyanmarManifestListCntrInfoVO.java
*@FileTitle : MyanmarManifestListCntrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.19
*@LastModifier : 윤태승
*@LastVersion : 1.0
* 2012.11.19 윤태승 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.myanmar.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤태승
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MyanmarManifestListCntrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MyanmarManifestListCntrInfoVO> models = new ArrayList<MyanmarManifestListCntrInfoVO>();
	
	/* Column Info */
	private String cntrStatus = null;
	/* Column Info */
	private String cntrNbr = null;
	/* Column Info */
	private String cgoTmpUnit = null;
	/* Column Info */
	private String cntrGWgt = null;
	/* Column Info */
	private String cntrTmp = null;
	/* Column Info */
	private String cntrEqSupCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrType = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrMvmtType = null;
	/* Column Info */
	private String cntrTWgtUnit = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String cntrGWgtUnit = null;
	/* Column Info */
	private String cntrTWgt = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String cntrFmInd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MyanmarManifestListCntrInfoVO() {}

	public MyanmarManifestListCntrInfoVO(String ibflag, String pagerows, String cntrNbr, String cntrType, String cntrStatus, String cntrFmInd, String cntrGWgt, String cntrGWgtUnit, String cntrTWgt, String cntrTWgtUnit, String cntrTmp, String cgoTmpUnit, String cntrMvmtType, String pckQty, String pckTpCd, String cntrEqSupCd) {
		this.cntrStatus = cntrStatus;
		this.cntrNbr = cntrNbr;
		this.cgoTmpUnit = cgoTmpUnit;
		this.cntrGWgt = cntrGWgt;
		this.cntrTmp = cntrTmp;
		this.cntrEqSupCd = cntrEqSupCd;
		this.pagerows = pagerows;
		this.cntrType = cntrType;
		this.ibflag = ibflag;
		this.cntrMvmtType = cntrMvmtType;
		this.cntrTWgtUnit = cntrTWgtUnit;
		this.pckQty = pckQty;
		this.cntrGWgtUnit = cntrGWgtUnit;
		this.cntrTWgt = cntrTWgt;
		this.pckTpCd = pckTpCd;
		this.cntrFmInd = cntrFmInd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_status", getCntrStatus());
		this.hashColumns.put("cntr_nbr", getCntrNbr());
		this.hashColumns.put("cgo_tmp_unit", getCgoTmpUnit());
		this.hashColumns.put("cntr_g_wgt", getCntrGWgt());
		this.hashColumns.put("cntr_tmp", getCntrTmp());
		this.hashColumns.put("cntr_eq_sup_cd", getCntrEqSupCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_type", getCntrType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_mvmt_type", getCntrMvmtType());
		this.hashColumns.put("cntr_t_wgt_unit", getCntrTWgtUnit());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("cntr_g_wgt_unit", getCntrGWgtUnit());
		this.hashColumns.put("cntr_t_wgt", getCntrTWgt());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("cntr_fm_ind", getCntrFmInd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_status", "cntrStatus");
		this.hashFields.put("cntr_nbr", "cntrNbr");
		this.hashFields.put("cgo_tmp_unit", "cgoTmpUnit");
		this.hashFields.put("cntr_g_wgt", "cntrGWgt");
		this.hashFields.put("cntr_tmp", "cntrTmp");
		this.hashFields.put("cntr_eq_sup_cd", "cntrEqSupCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_type", "cntrType");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_mvmt_type", "cntrMvmtType");
		this.hashFields.put("cntr_t_wgt_unit", "cntrTWgtUnit");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("cntr_g_wgt_unit", "cntrGWgtUnit");
		this.hashFields.put("cntr_t_wgt", "cntrTWgt");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("cntr_fm_ind", "cntrFmInd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrStatus
	 */
	public String getCntrStatus() {
		return this.cntrStatus;
	}
	
	/**
	 * Column Info
	 * @return cntrNbr
	 */
	public String getCntrNbr() {
		return this.cntrNbr;
	}
	
	/**
	 * Column Info
	 * @return cgoTmpUnit
	 */
	public String getCgoTmpUnit() {
		return this.cgoTmpUnit;
	}
	
	/**
	 * Column Info
	 * @return cntrGWgt
	 */
	public String getCntrGWgt() {
		return this.cntrGWgt;
	}
	
	/**
	 * Column Info
	 * @return cntrTmp
	 */
	public String getCntrTmp() {
		return this.cntrTmp;
	}
	
	/**
	 * Column Info
	 * @return cntrEqSupCd
	 */
	public String getCntrEqSupCd() {
		return this.cntrEqSupCd;
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
	 * @return cntrType
	 */
	public String getCntrType() {
		return this.cntrType;
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
	 * @return cntrMvmtType
	 */
	public String getCntrMvmtType() {
		return this.cntrMvmtType;
	}
	
	/**
	 * Column Info
	 * @return cntrTWgtUnit
	 */
	public String getCntrTWgtUnit() {
		return this.cntrTWgtUnit;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return cntrGWgtUnit
	 */
	public String getCntrGWgtUnit() {
		return this.cntrGWgtUnit;
	}
	
	/**
	 * Column Info
	 * @return cntrTWgt
	 */
	public String getCntrTWgt() {
		return this.cntrTWgt;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrFmInd
	 */
	public String getCntrFmInd() {
		return this.cntrFmInd;
	}
	

	/**
	 * Column Info
	 * @param cntrStatus
	 */
	public void setCntrStatus(String cntrStatus) {
		this.cntrStatus = cntrStatus;
	}
	
	/**
	 * Column Info
	 * @param cntrNbr
	 */
	public void setCntrNbr(String cntrNbr) {
		this.cntrNbr = cntrNbr;
	}
	
	/**
	 * Column Info
	 * @param cgoTmpUnit
	 */
	public void setCgoTmpUnit(String cgoTmpUnit) {
		this.cgoTmpUnit = cgoTmpUnit;
	}
	
	/**
	 * Column Info
	 * @param cntrGWgt
	 */
	public void setCntrGWgt(String cntrGWgt) {
		this.cntrGWgt = cntrGWgt;
	}
	
	/**
	 * Column Info
	 * @param cntrTmp
	 */
	public void setCntrTmp(String cntrTmp) {
		this.cntrTmp = cntrTmp;
	}
	
	/**
	 * Column Info
	 * @param cntrEqSupCd
	 */
	public void setCntrEqSupCd(String cntrEqSupCd) {
		this.cntrEqSupCd = cntrEqSupCd;
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
	 * @param cntrType
	 */
	public void setCntrType(String cntrType) {
		this.cntrType = cntrType;
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
	 * @param cntrMvmtType
	 */
	public void setCntrMvmtType(String cntrMvmtType) {
		this.cntrMvmtType = cntrMvmtType;
	}
	
	/**
	 * Column Info
	 * @param cntrTWgtUnit
	 */
	public void setCntrTWgtUnit(String cntrTWgtUnit) {
		this.cntrTWgtUnit = cntrTWgtUnit;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param cntrGWgtUnit
	 */
	public void setCntrGWgtUnit(String cntrGWgtUnit) {
		this.cntrGWgtUnit = cntrGWgtUnit;
	}
	
	/**
	 * Column Info
	 * @param cntrTWgt
	 */
	public void setCntrTWgt(String cntrTWgt) {
		this.cntrTWgt = cntrTWgt;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param cntrFmInd
	 */
	public void setCntrFmInd(String cntrFmInd) {
		this.cntrFmInd = cntrFmInd;
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
		setCntrStatus(JSPUtil.getParameter(request, prefix + "cntr_status", ""));
		setCntrNbr(JSPUtil.getParameter(request, prefix + "cntr_nbr", ""));
		setCgoTmpUnit(JSPUtil.getParameter(request, prefix + "cgo_tmp_unit", ""));
		setCntrGWgt(JSPUtil.getParameter(request, prefix + "cntr_g_wgt", ""));
		setCntrTmp(JSPUtil.getParameter(request, prefix + "cntr_tmp", ""));
		setCntrEqSupCd(JSPUtil.getParameter(request, prefix + "cntr_eq_sup_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntrType(JSPUtil.getParameter(request, prefix + "cntr_type", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrMvmtType(JSPUtil.getParameter(request, prefix + "cntr_mvmt_type", ""));
		setCntrTWgtUnit(JSPUtil.getParameter(request, prefix + "cntr_t_wgt_unit", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setCntrGWgtUnit(JSPUtil.getParameter(request, prefix + "cntr_g_wgt_unit", ""));
		setCntrTWgt(JSPUtil.getParameter(request, prefix + "cntr_t_wgt", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setCntrFmInd(JSPUtil.getParameter(request, prefix + "cntr_fm_ind", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MyanmarManifestListCntrInfoVO[]
	 */
	public MyanmarManifestListCntrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MyanmarManifestListCntrInfoVO[]
	 */
	public MyanmarManifestListCntrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MyanmarManifestListCntrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrStatus = (JSPUtil.getParameter(request, prefix	+ "cntr_status", length));
			String[] cntrNbr = (JSPUtil.getParameter(request, prefix	+ "cntr_nbr", length));
			String[] cgoTmpUnit = (JSPUtil.getParameter(request, prefix	+ "cgo_tmp_unit", length));
			String[] cntrGWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_g_wgt", length));
			String[] cntrTmp = (JSPUtil.getParameter(request, prefix	+ "cntr_tmp", length));
			String[] cntrEqSupCd = (JSPUtil.getParameter(request, prefix	+ "cntr_eq_sup_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrType = (JSPUtil.getParameter(request, prefix	+ "cntr_type", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrMvmtType = (JSPUtil.getParameter(request, prefix	+ "cntr_mvmt_type", length));
			String[] cntrTWgtUnit = (JSPUtil.getParameter(request, prefix	+ "cntr_t_wgt_unit", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] cntrGWgtUnit = (JSPUtil.getParameter(request, prefix	+ "cntr_g_wgt_unit", length));
			String[] cntrTWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_t_wgt", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] cntrFmInd = (JSPUtil.getParameter(request, prefix	+ "cntr_fm_ind", length));
			
			for (int i = 0; i < length; i++) {
				model = new MyanmarManifestListCntrInfoVO();
				if (cntrStatus[i] != null)
					model.setCntrStatus(cntrStatus[i]);
				if (cntrNbr[i] != null)
					model.setCntrNbr(cntrNbr[i]);
				if (cgoTmpUnit[i] != null)
					model.setCgoTmpUnit(cgoTmpUnit[i]);
				if (cntrGWgt[i] != null)
					model.setCntrGWgt(cntrGWgt[i]);
				if (cntrTmp[i] != null)
					model.setCntrTmp(cntrTmp[i]);
				if (cntrEqSupCd[i] != null)
					model.setCntrEqSupCd(cntrEqSupCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrType[i] != null)
					model.setCntrType(cntrType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrMvmtType[i] != null)
					model.setCntrMvmtType(cntrMvmtType[i]);
				if (cntrTWgtUnit[i] != null)
					model.setCntrTWgtUnit(cntrTWgtUnit[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (cntrGWgtUnit[i] != null)
					model.setCntrGWgtUnit(cntrGWgtUnit[i]);
				if (cntrTWgt[i] != null)
					model.setCntrTWgt(cntrTWgt[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (cntrFmInd[i] != null)
					model.setCntrFmInd(cntrFmInd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMyanmarManifestListCntrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MyanmarManifestListCntrInfoVO[]
	 */
	public MyanmarManifestListCntrInfoVO[] getMyanmarManifestListCntrInfoVOs(){
		MyanmarManifestListCntrInfoVO[] vos = (MyanmarManifestListCntrInfoVO[])models.toArray(new MyanmarManifestListCntrInfoVO[models.size()]);
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
		this.cntrStatus = this.cntrStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNbr = this.cntrNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTmpUnit = this.cgoTmpUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrGWgt = this.cntrGWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTmp = this.cntrTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrEqSupCd = this.cntrEqSupCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrType = this.cntrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMvmtType = this.cntrMvmtType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTWgtUnit = this.cntrTWgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrGWgtUnit = this.cntrGWgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTWgt = this.cntrTWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFmInd = this.cntrFmInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
