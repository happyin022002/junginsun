/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceManageVO.java
*@FileTitle : MarineTerminalStorageInvoiceManageVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.10.27 이정혜 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이정혜
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MarineTerminalStorageInvoiceManageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MarineTerminalStorageInvoiceManageVO> models = new ArrayList<MarineTerminalStorageInvoiceManageVO>();
	
	/* Column Info */
	private String dtlByDayOnlyMode = null;
	/* Column Info */
	private String dtlByEqOnlyMode = null;
	/* Column Info */
	private String paramCntrTpszCd = null;
	/* Column Info */
	private String paramLgsCostCd = null;
	/* Column Info */
	private String paramCntrNo = null;
	/* Column Info */
	private String delIfSeq = null;
	/* Column Info */
	private String calcCostGrpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String calcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String delCntrSeq = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String dtlByPoolOnlyMode = null;
	/* Column Info */
	private String tmlSoCntrListSeq = null;
	/* Column Info */
	private String tmlSoSeq = null;
	/* Column Info */
	private String tmlSoOfcCtyCd = null;
	/* Column Info */
	private String tmlSoDtlSeq = null;
	/* Column Info */
	private String tmpDtlSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MarineTerminalStorageInvoiceManageVO() {}

	public MarineTerminalStorageInvoiceManageVO(String ibflag, String pagerows, String tmlSoOfcCtyCd, String tmlSoSeq, String tmlSoDtlSeq, String tmpDtlSeq, String tmlSoCntrListSeq, String calcTpCd, String calcCostGrpCd, String paramCntrNo, String paramCntrTpszCd, String paramLgsCostCd, String dtlByDayOnlyMode, String dtlByPoolOnlyMode, String dtlByEqOnlyMode, String delIfSeq, String delCntrSeq, String invNo, String ydCd) {
		this.dtlByDayOnlyMode = dtlByDayOnlyMode;
		this.dtlByEqOnlyMode = dtlByEqOnlyMode;
		this.paramCntrTpszCd = paramCntrTpszCd;
		this.paramLgsCostCd = paramLgsCostCd;
		this.paramCntrNo = paramCntrNo;
		this.delIfSeq = delIfSeq;
		this.calcCostGrpCd = calcCostGrpCd;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.calcTpCd = calcTpCd;
		this.ibflag = ibflag;
		this.delCntrSeq = delCntrSeq;
		this.ydCd = ydCd;
		this.dtlByPoolOnlyMode = dtlByPoolOnlyMode;
		this.tmlSoCntrListSeq = tmlSoCntrListSeq;
		this.tmlSoSeq = tmlSoSeq;
		this.tmlSoOfcCtyCd = tmlSoOfcCtyCd;
		this.tmlSoDtlSeq = tmlSoDtlSeq;
		this.tmpDtlSeq = tmpDtlSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dtl_by_day_only_mode", getDtlByDayOnlyMode());
		this.hashColumns.put("dtl_by_eq_only_mode", getDtlByEqOnlyMode());
		this.hashColumns.put("param_cntr_tpsz_cd", getParamCntrTpszCd());
		this.hashColumns.put("param_lgs_cost_cd", getParamLgsCostCd());
		this.hashColumns.put("param_cntr_no", getParamCntrNo());
		this.hashColumns.put("del_if_seq", getDelIfSeq());
		this.hashColumns.put("calc_cost_grp_cd", getCalcCostGrpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("calc_tp_cd", getCalcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("del_cntr_seq", getDelCntrSeq());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("dtl_by_pool_only_mode", getDtlByPoolOnlyMode());
		this.hashColumns.put("tml_so_cntr_list_seq", getTmlSoCntrListSeq());
		this.hashColumns.put("tml_so_seq", getTmlSoSeq());
		this.hashColumns.put("tml_so_ofc_cty_cd", getTmlSoOfcCtyCd());
		this.hashColumns.put("tml_so_dtl_seq", getTmlSoDtlSeq());
		this.hashColumns.put("tmp_dtl_seq", getTmpDtlSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dtl_by_day_only_mode", "dtlByDayOnlyMode");
		this.hashFields.put("dtl_by_eq_only_mode", "dtlByEqOnlyMode");
		this.hashFields.put("param_cntr_tpsz_cd", "paramCntrTpszCd");
		this.hashFields.put("param_lgs_cost_cd", "paramLgsCostCd");
		this.hashFields.put("param_cntr_no", "paramCntrNo");
		this.hashFields.put("del_if_seq", "delIfSeq");
		this.hashFields.put("calc_cost_grp_cd", "calcCostGrpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("calc_tp_cd", "calcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("del_cntr_seq", "delCntrSeq");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("dtl_by_pool_only_mode", "dtlByPoolOnlyMode");
		this.hashFields.put("tml_so_cntr_list_seq", "tmlSoCntrListSeq");
		this.hashFields.put("tml_so_seq", "tmlSoSeq");
		this.hashFields.put("tml_so_ofc_cty_cd", "tmlSoOfcCtyCd");
		this.hashFields.put("tml_so_dtl_seq", "tmlSoDtlSeq");
		this.hashFields.put("tmp_dtl_seq", "tmpDtlSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dtlByDayOnlyMode
	 */
	public String getDtlByDayOnlyMode() {
		return this.dtlByDayOnlyMode;
	}
	
	/**
	 * Column Info
	 * @return dtlByEqOnlyMode
	 */
	public String getDtlByEqOnlyMode() {
		return this.dtlByEqOnlyMode;
	}	
	
	/**
	 * Column Info
	 * @return paramCntrTpszCd
	 */
	public String getParamCntrTpszCd() {
		return this.paramCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return paramLgsCostCd
	 */
	public String getParamLgsCostCd() {
		return this.paramLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return paramCntrNo
	 */
	public String getParamCntrNo() {
		return this.paramCntrNo;
	}
	
	/**
	 * Column Info
	 * @return delIfSeq
	 */
	public String getDelIfSeq() {
		return this.delIfSeq;
	}
	
	/**
	 * Column Info
	 * @return calcCostGrpCd
	 */
	public String getCalcCostGrpCd() {
		return this.calcCostGrpCd;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return calcTpCd
	 */
	public String getCalcTpCd() {
		return this.calcTpCd;
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
	 * @return delCntrSeq
	 */
	public String getDelCntrSeq() {
		return this.delCntrSeq;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return dtlByPoolOnlyMode
	 */
	public String getDtlByPoolOnlyMode() {
		return this.dtlByPoolOnlyMode;
	}
	
	/**
	 * Column Info
	 * @return tmlSoCntrListSeq
	 */
	public String getTmlSoCntrListSeq() {
		return this.tmlSoCntrListSeq;
	}
	
	/**
	 * Column Info
	 * @return tmlSoSeq
	 */
	public String getTmlSoSeq() {
		return this.tmlSoSeq;
	}
	
	/**
	 * Column Info
	 * @return tmlSoOfcCtyCd
	 */
	public String getTmlSoOfcCtyCd() {
		return this.tmlSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return tmlSoDtlSeq
	 */
	public String getTmlSoDtlSeq() {
		return this.tmlSoDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return tmpDtlSeq
	 */
	public String getTmpDtlSeq() {
		return this.tmpDtlSeq;
	}
	

	/**
	 * Column Info
	 * @param dtlByDayOnlyMode
	 */
	public void setDtlByDayOnlyMode(String dtlByDayOnlyMode) {
		this.dtlByDayOnlyMode = dtlByDayOnlyMode;
	}
	
	/**
	 * Column Info
	 * @param dtlByEqOnlyMode
	 */
	public void setDtlByEqOnlyMode(String dtlByEqOnlyMode) {
		this.dtlByEqOnlyMode = dtlByEqOnlyMode;
	}
	
	/**
	 * Column Info
	 * @param paramCntrTpszCd
	 */
	public void setParamCntrTpszCd(String paramCntrTpszCd) {
		this.paramCntrTpszCd = paramCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param paramLgsCostCd
	 */
	public void setParamLgsCostCd(String paramLgsCostCd) {
		this.paramLgsCostCd = paramLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param paramCntrNo
	 */
	public void setParamCntrNo(String paramCntrNo) {
		this.paramCntrNo = paramCntrNo;
	}
	
	/**
	 * Column Info
	 * @param delIfSeq
	 */
	public void setDelIfSeq(String delIfSeq) {
		this.delIfSeq = delIfSeq;
	}
	
	/**
	 * Column Info
	 * @param calcCostGrpCd
	 */
	public void setCalcCostGrpCd(String calcCostGrpCd) {
		this.calcCostGrpCd = calcCostGrpCd;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param calcTpCd
	 */
	public void setCalcTpCd(String calcTpCd) {
		this.calcTpCd = calcTpCd;
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
	 * @param delCntrSeq
	 */
	public void setDelCntrSeq(String delCntrSeq) {
		this.delCntrSeq = delCntrSeq;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param dtlByPoolOnlyMode
	 */
	public void setDtlByPoolOnlyMode(String dtlByPoolOnlyMode) {
		this.dtlByPoolOnlyMode = dtlByPoolOnlyMode;
	}
	
	/**
	 * Column Info
	 * @param tmlSoCntrListSeq
	 */
	public void setTmlSoCntrListSeq(String tmlSoCntrListSeq) {
		this.tmlSoCntrListSeq = tmlSoCntrListSeq;
	}
	
	/**
	 * Column Info
	 * @param tmlSoSeq
	 */
	public void setTmlSoSeq(String tmlSoSeq) {
		this.tmlSoSeq = tmlSoSeq;
	}
	
	/**
	 * Column Info
	 * @param tmlSoOfcCtyCd
	 */
	public void setTmlSoOfcCtyCd(String tmlSoOfcCtyCd) {
		this.tmlSoOfcCtyCd = tmlSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param tmlSoDtlSeq
	 */
	public void setTmlSoDtlSeq(String tmlSoDtlSeq) {
		this.tmlSoDtlSeq = tmlSoDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param tmpDtlSeq
	 */
	public void setTmpDtlSeq(String tmpDtlSeq) {
		this.tmpDtlSeq = tmpDtlSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDtlByDayOnlyMode(JSPUtil.getParameter(request, "dtl_by_day_only_mode", ""));
		setDtlByEqOnlyMode(JSPUtil.getParameter(request, "dtl_by_eq_only_mode", ""));
		setParamCntrTpszCd(JSPUtil.getParameter(request, "param_cntr_tpsz_cd", ""));
		setParamLgsCostCd(JSPUtil.getParameter(request, "param_lgs_cost_cd", ""));
		setParamCntrNo(JSPUtil.getParameter(request, "param_cntr_no", ""));
		setDelIfSeq(JSPUtil.getParameter(request, "del_if_seq", ""));
		setCalcCostGrpCd(JSPUtil.getParameter(request, "calc_cost_grp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setCalcTpCd(JSPUtil.getParameter(request, "calc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDelCntrSeq(JSPUtil.getParameter(request, "del_cntr_seq", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setDtlByPoolOnlyMode(JSPUtil.getParameter(request, "dtl_by_pool_only_mode", ""));
		setTmlSoCntrListSeq(JSPUtil.getParameter(request, "tml_so_cntr_list_seq", ""));
		setTmlSoSeq(JSPUtil.getParameter(request, "tml_so_seq", ""));
		setTmlSoOfcCtyCd(JSPUtil.getParameter(request, "tml_so_ofc_cty_cd", ""));
		setTmlSoDtlSeq(JSPUtil.getParameter(request, "tml_so_dtl_seq", ""));
		setTmpDtlSeq(JSPUtil.getParameter(request, "tmp_dtl_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MarineTerminalStorageInvoiceManageVO[]
	 */
	public MarineTerminalStorageInvoiceManageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MarineTerminalStorageInvoiceManageVO[]
	 */
	public MarineTerminalStorageInvoiceManageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MarineTerminalStorageInvoiceManageVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dtlByDayOnlyMode = (JSPUtil.getParameter(request, prefix	+ "dtl_by_day_only_mode", length));
			String[] dtlByEqOnlyMode = (JSPUtil.getParameter(request, prefix	+ "dtl_by_eq_only_mode", length));
			String[] paramCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "param_cntr_tpsz_cd", length));
			String[] paramLgsCostCd = (JSPUtil.getParameter(request, prefix	+ "param_lgs_cost_cd", length));
			String[] paramCntrNo = (JSPUtil.getParameter(request, prefix	+ "param_cntr_no", length));
			String[] delIfSeq = (JSPUtil.getParameter(request, prefix	+ "del_if_seq", length));
			String[] calcCostGrpCd = (JSPUtil.getParameter(request, prefix	+ "calc_cost_grp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] calcTpCd = (JSPUtil.getParameter(request, prefix	+ "calc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] delCntrSeq = (JSPUtil.getParameter(request, prefix	+ "del_cntr_seq", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] dtlByPoolOnlyMode = (JSPUtil.getParameter(request, prefix	+ "dtl_by_pool_only_mode", length));
			String[] tmlSoCntrListSeq = (JSPUtil.getParameter(request, prefix	+ "tml_so_cntr_list_seq", length));
			String[] tmlSoSeq = (JSPUtil.getParameter(request, prefix	+ "tml_so_seq", length));
			String[] tmlSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "tml_so_ofc_cty_cd", length));
			String[] tmlSoDtlSeq = (JSPUtil.getParameter(request, prefix	+ "tml_so_dtl_seq", length));
			String[] tmpDtlSeq = (JSPUtil.getParameter(request, prefix	+ "tmp_dtl_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new MarineTerminalStorageInvoiceManageVO();
				if (dtlByDayOnlyMode[i] != null)
					model.setDtlByDayOnlyMode(dtlByDayOnlyMode[i]);
				if (dtlByEqOnlyMode[i] != null)
					model.setDtlByEqOnlyMode(dtlByEqOnlyMode[i]);
				if (paramCntrTpszCd[i] != null)
					model.setParamCntrTpszCd(paramCntrTpszCd[i]);
				if (paramLgsCostCd[i] != null)
					model.setParamLgsCostCd(paramLgsCostCd[i]);
				if (paramCntrNo[i] != null)
					model.setParamCntrNo(paramCntrNo[i]);
				if (delIfSeq[i] != null)
					model.setDelIfSeq(delIfSeq[i]);
				if (calcCostGrpCd[i] != null)
					model.setCalcCostGrpCd(calcCostGrpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (calcTpCd[i] != null)
					model.setCalcTpCd(calcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (delCntrSeq[i] != null)
					model.setDelCntrSeq(delCntrSeq[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (dtlByPoolOnlyMode[i] != null)
					model.setDtlByPoolOnlyMode(dtlByPoolOnlyMode[i]);
				if (tmlSoCntrListSeq[i] != null)
					model.setTmlSoCntrListSeq(tmlSoCntrListSeq[i]);
				if (tmlSoSeq[i] != null)
					model.setTmlSoSeq(tmlSoSeq[i]);
				if (tmlSoOfcCtyCd[i] != null)
					model.setTmlSoOfcCtyCd(tmlSoOfcCtyCd[i]);
				if (tmlSoDtlSeq[i] != null)
					model.setTmlSoDtlSeq(tmlSoDtlSeq[i]);
				if (tmpDtlSeq[i] != null)
					model.setTmpDtlSeq(tmpDtlSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMarineTerminalStorageInvoiceManageVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MarineTerminalStorageInvoiceManageVO[]
	 */
	public MarineTerminalStorageInvoiceManageVO[] getMarineTerminalStorageInvoiceManageVOs(){
		MarineTerminalStorageInvoiceManageVO[] vos = (MarineTerminalStorageInvoiceManageVO[])models.toArray(new MarineTerminalStorageInvoiceManageVO[models.size()]);
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
		this.dtlByDayOnlyMode = this.dtlByDayOnlyMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlByEqOnlyMode = this.dtlByEqOnlyMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paramCntrTpszCd = this.paramCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paramLgsCostCd = this.paramLgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paramCntrNo = this.paramCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delIfSeq = this.delIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcCostGrpCd = this.calcCostGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcTpCd = this.calcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCntrSeq = this.delCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlByPoolOnlyMode = this.dtlByPoolOnlyMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoCntrListSeq = this.tmlSoCntrListSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoSeq = this.tmlSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoOfcCtyCd = this.tmlSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoDtlSeq = this.tmlSoDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpDtlSeq = this.tmpDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
