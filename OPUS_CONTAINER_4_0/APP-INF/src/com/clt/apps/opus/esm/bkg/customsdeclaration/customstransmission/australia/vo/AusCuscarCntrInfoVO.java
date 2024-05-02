/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AusCuscarCntrInfoVO.java
*@FileTitle : AusCuscarCntrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.08  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo;

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

public class AusCuscarCntrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AusCuscarCntrInfoVO> models = new ArrayList<AusCuscarCntrInfoVO>();
	
	/* Column Info */
	private String cntrSuplCd = null;
	/* Column Info */
	private String cntrSz = null;
	/* Column Info */
	private String cntrGWgt = null;
	/* Column Info */
	private String cntrTmp = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrTp = null;
	/* Column Info */
	private String cntrNo = null;
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
	/* Column Info */
	private String cntrTmpUnit = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AusCuscarCntrInfoVO() {}

	public AusCuscarCntrInfoVO(String ibflag, String pagerows, String cntrNo, String cntrSz, String cntrTp, String cntrSuplCd, String cntrFmInd, String cntrGWgt, String cntrGWgtUnit, String cntrTWgt, String cntrTWgtUnit, String cntrTmp, String cntrTmpUnit, String pckQty, String pckTpCd) {
		this.cntrSuplCd = cntrSuplCd;
		this.cntrSz = cntrSz;
		this.cntrGWgt = cntrGWgt;
		this.cntrTmp = cntrTmp;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cntrTp = cntrTp;
		this.cntrNo = cntrNo;
		this.cntrTWgtUnit = cntrTWgtUnit;
		this.pckQty = pckQty;
		this.cntrGWgtUnit = cntrGWgtUnit;
		this.cntrTWgt = cntrTWgt;
		this.pckTpCd = pckTpCd;
		this.cntrFmInd = cntrFmInd;
		this.cntrTmpUnit = cntrTmpUnit;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_supl_cd", getCntrSuplCd());
		this.hashColumns.put("cntr_sz", getCntrSz());
		this.hashColumns.put("cntr_g_wgt", getCntrGWgt());
		this.hashColumns.put("cntr_tmp", getCntrTmp());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tp", getCntrTp());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_t_wgt_unit", getCntrTWgtUnit());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("cntr_g_wgt_unit", getCntrGWgtUnit());
		this.hashColumns.put("cntr_t_wgt", getCntrTWgt());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("cntr_fm_ind", getCntrFmInd());
		this.hashColumns.put("cntr_tmp_unit", getCntrTmpUnit());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_supl_cd", "cntrSuplCd");
		this.hashFields.put("cntr_sz", "cntrSz");
		this.hashFields.put("cntr_g_wgt", "cntrGWgt");
		this.hashFields.put("cntr_tmp", "cntrTmp");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tp", "cntrTp");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_t_wgt_unit", "cntrTWgtUnit");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("cntr_g_wgt_unit", "cntrGWgtUnit");
		this.hashFields.put("cntr_t_wgt", "cntrTWgt");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("cntr_fm_ind", "cntrFmInd");
		this.hashFields.put("cntr_tmp_unit", "cntrTmpUnit");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrSuplCd
	 */
	public String getCntrSuplCd() {
		return this.cntrSuplCd;
	}
	
	/**
	 * Column Info
	 * @return cntrSz
	 */
	public String getCntrSz() {
		return this.cntrSz;
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
	 * @return cntrTp
	 */
	public String getCntrTp() {
		return this.cntrTp;
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
	 * @return cntrTmpUnit
	 */
	public String getCntrTmpUnit() {
		return this.cntrTmpUnit;
	}
	

	/**
	 * Column Info
	 * @param cntrSuplCd
	 */
	public void setCntrSuplCd(String cntrSuplCd) {
		this.cntrSuplCd = cntrSuplCd;
	}
	
	/**
	 * Column Info
	 * @param cntrSz
	 */
	public void setCntrSz(String cntrSz) {
		this.cntrSz = cntrSz;
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
	 * @param cntrTp
	 */
	public void setCntrTp(String cntrTp) {
		this.cntrTp = cntrTp;
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
	 * Column Info
	 * @param cntrTmpUnit
	 */
	public void setCntrTmpUnit(String cntrTmpUnit) {
		this.cntrTmpUnit = cntrTmpUnit;
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
		setCntrSuplCd(JSPUtil.getParameter(request, prefix + "cntr_supl_cd", ""));
		setCntrSz(JSPUtil.getParameter(request, prefix + "cntr_sz", ""));
		setCntrGWgt(JSPUtil.getParameter(request, prefix + "cntr_g_wgt", ""));
		setCntrTmp(JSPUtil.getParameter(request, prefix + "cntr_tmp", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrTp(JSPUtil.getParameter(request, prefix + "cntr_tp", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTWgtUnit(JSPUtil.getParameter(request, prefix + "cntr_t_wgt_unit", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setCntrGWgtUnit(JSPUtil.getParameter(request, prefix + "cntr_g_wgt_unit", ""));
		setCntrTWgt(JSPUtil.getParameter(request, prefix + "cntr_t_wgt", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setCntrFmInd(JSPUtil.getParameter(request, prefix + "cntr_fm_ind", ""));
		setCntrTmpUnit(JSPUtil.getParameter(request, prefix + "cntr_tmp_unit", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AusCuscarCntrInfoVO[]
	 */
	public AusCuscarCntrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AusCuscarCntrInfoVO[]
	 */
	public AusCuscarCntrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AusCuscarCntrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrSuplCd = (JSPUtil.getParameter(request, prefix	+ "cntr_supl_cd", length));
			String[] cntrSz = (JSPUtil.getParameter(request, prefix	+ "cntr_sz", length));
			String[] cntrGWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_g_wgt", length));
			String[] cntrTmp = (JSPUtil.getParameter(request, prefix	+ "cntr_tmp", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrTp = (JSPUtil.getParameter(request, prefix	+ "cntr_tp", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTWgtUnit = (JSPUtil.getParameter(request, prefix	+ "cntr_t_wgt_unit", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] cntrGWgtUnit = (JSPUtil.getParameter(request, prefix	+ "cntr_g_wgt_unit", length));
			String[] cntrTWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_t_wgt", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] cntrFmInd = (JSPUtil.getParameter(request, prefix	+ "cntr_fm_ind", length));
			String[] cntrTmpUnit = (JSPUtil.getParameter(request, prefix	+ "cntr_tmp_unit", length));
			
			for (int i = 0; i < length; i++) {
				model = new AusCuscarCntrInfoVO();
				if (cntrSuplCd[i] != null)
					model.setCntrSuplCd(cntrSuplCd[i]);
				if (cntrSz[i] != null)
					model.setCntrSz(cntrSz[i]);
				if (cntrGWgt[i] != null)
					model.setCntrGWgt(cntrGWgt[i]);
				if (cntrTmp[i] != null)
					model.setCntrTmp(cntrTmp[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTp[i] != null)
					model.setCntrTp(cntrTp[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
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
				if (cntrTmpUnit[i] != null)
					model.setCntrTmpUnit(cntrTmpUnit[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAusCuscarCntrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AusCuscarCntrInfoVO[]
	 */
	public AusCuscarCntrInfoVO[] getAusCuscarCntrInfoVOs(){
		AusCuscarCntrInfoVO[] vos = (AusCuscarCntrInfoVO[])models.toArray(new AusCuscarCntrInfoVO[models.size()]);
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
		this.cntrSuplCd = this.cntrSuplCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSz = this.cntrSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrGWgt = this.cntrGWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTmp = this.cntrTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTp = this.cntrTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTWgtUnit = this.cntrTWgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrGWgtUnit = this.cntrGWgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTWgt = this.cntrTWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFmInd = this.cntrFmInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTmpUnit = this.cntrTmpUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
