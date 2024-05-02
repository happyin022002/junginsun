/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FeederCostSpecialCargoVO.java
*@FileTitle : FeederCostSpecialCargoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.22
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.05.22 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FeederCostSpecialCargoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FeederCostSpecialCargoVO> models = new ArrayList<FeederCostSpecialCargoVO>();
	
	/* Column Info */
	private String rfFxRto = null;
	/* Column Info */
	private String dgFxRto = null;
	/* Column Info */
	private String ovrWgtFxRto = null;
	/* Column Info */
	private String costTrfNo = null;
	/* Column Info */
	private String cntrSzCd = null;
	/* Column Info */
	private String dgFxRt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rfFxRt = null;
	/* Column Info */
	private String ovrWgtFxRt = null;
	/* Column Info */
	private String minCgoWgt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String maxCgoWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FeederCostSpecialCargoVO() {}

	public FeederCostSpecialCargoVO(String ibflag, String pagerows, String cntrSzCd, String rfFxRt, String rfFxRto, String dgFxRt, String dgFxRto, String minCgoWgt, String maxCgoWgt, String ovrWgtFxRt, String ovrWgtFxRto, String costTrfNo, String creUsrId, String updUsrId) {
		this.rfFxRto = rfFxRto;
		this.dgFxRto = dgFxRto;
		this.ovrWgtFxRto = ovrWgtFxRto;
		this.costTrfNo = costTrfNo;
		this.cntrSzCd = cntrSzCd;
		this.dgFxRt = dgFxRt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.rfFxRt = rfFxRt;
		this.ovrWgtFxRt = ovrWgtFxRt;
		this.minCgoWgt = minCgoWgt;
		this.updUsrId = updUsrId;
		this.maxCgoWgt = maxCgoWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rf_fx_rto", getRfFxRto());
		this.hashColumns.put("dg_fx_rto", getDgFxRto());
		this.hashColumns.put("ovr_wgt_fx_rto", getOvrWgtFxRto());
		this.hashColumns.put("cost_trf_no", getCostTrfNo());
		this.hashColumns.put("cntr_sz_cd", getCntrSzCd());
		this.hashColumns.put("dg_fx_rt", getDgFxRt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rf_fx_rt", getRfFxRt());
		this.hashColumns.put("ovr_wgt_fx_rt", getOvrWgtFxRt());
		this.hashColumns.put("min_cgo_wgt", getMinCgoWgt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("max_cgo_wgt", getMaxCgoWgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rf_fx_rto", "rfFxRto");
		this.hashFields.put("dg_fx_rto", "dgFxRto");
		this.hashFields.put("ovr_wgt_fx_rto", "ovrWgtFxRto");
		this.hashFields.put("cost_trf_no", "costTrfNo");
		this.hashFields.put("cntr_sz_cd", "cntrSzCd");
		this.hashFields.put("dg_fx_rt", "dgFxRt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rf_fx_rt", "rfFxRt");
		this.hashFields.put("ovr_wgt_fx_rt", "ovrWgtFxRt");
		this.hashFields.put("min_cgo_wgt", "minCgoWgt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("max_cgo_wgt", "maxCgoWgt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rfFxRto
	 */
	public String getRfFxRto() {
		return this.rfFxRto;
	}
	
	/**
	 * Column Info
	 * @return dgFxRto
	 */
	public String getDgFxRto() {
		return this.dgFxRto;
	}
	
	/**
	 * Column Info
	 * @return ovrWgtFxRto
	 */
	public String getOvrWgtFxRto() {
		return this.ovrWgtFxRto;
	}
	
	/**
	 * Column Info
	 * @return costTrfNo
	 */
	public String getCostTrfNo() {
		return this.costTrfNo;
	}
	
	/**
	 * Column Info
	 * @return cntrSzCd
	 */
	public String getCntrSzCd() {
		return this.cntrSzCd;
	}
	
	/**
	 * Column Info
	 * @return dgFxRt
	 */
	public String getDgFxRt() {
		return this.dgFxRt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return rfFxRt
	 */
	public String getRfFxRt() {
		return this.rfFxRt;
	}
	
	/**
	 * Column Info
	 * @return ovrWgtFxRt
	 */
	public String getOvrWgtFxRt() {
		return this.ovrWgtFxRt;
	}
	
	/**
	 * Column Info
	 * @return minCgoWgt
	 */
	public String getMinCgoWgt() {
		return this.minCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return maxCgoWgt
	 */
	public String getMaxCgoWgt() {
		return this.maxCgoWgt;
	}
	

	/**
	 * Column Info
	 * @param rfFxRto
	 */
	public void setRfFxRto(String rfFxRto) {
		this.rfFxRto = rfFxRto;
	}
	
	/**
	 * Column Info
	 * @param dgFxRto
	 */
	public void setDgFxRto(String dgFxRto) {
		this.dgFxRto = dgFxRto;
	}
	
	/**
	 * Column Info
	 * @param ovrWgtFxRto
	 */
	public void setOvrWgtFxRto(String ovrWgtFxRto) {
		this.ovrWgtFxRto = ovrWgtFxRto;
	}
	
	/**
	 * Column Info
	 * @param costTrfNo
	 */
	public void setCostTrfNo(String costTrfNo) {
		this.costTrfNo = costTrfNo;
	}
	
	/**
	 * Column Info
	 * @param cntrSzCd
	 */
	public void setCntrSzCd(String cntrSzCd) {
		this.cntrSzCd = cntrSzCd;
	}
	
	/**
	 * Column Info
	 * @param dgFxRt
	 */
	public void setDgFxRt(String dgFxRt) {
		this.dgFxRt = dgFxRt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param rfFxRt
	 */
	public void setRfFxRt(String rfFxRt) {
		this.rfFxRt = rfFxRt;
	}
	
	/**
	 * Column Info
	 * @param ovrWgtFxRt
	 */
	public void setOvrWgtFxRt(String ovrWgtFxRt) {
		this.ovrWgtFxRt = ovrWgtFxRt;
	}
	
	/**
	 * Column Info
	 * @param minCgoWgt
	 */
	public void setMinCgoWgt(String minCgoWgt) {
		this.minCgoWgt = minCgoWgt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param maxCgoWgt
	 */
	public void setMaxCgoWgt(String maxCgoWgt) {
		this.maxCgoWgt = maxCgoWgt;
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
		setRfFxRto(JSPUtil.getParameter(request, prefix + "rf_fx_rto", ""));
		setDgFxRto(JSPUtil.getParameter(request, prefix + "dg_fx_rto", ""));
		setOvrWgtFxRto(JSPUtil.getParameter(request, prefix + "ovr_wgt_fx_rto", ""));
		setCostTrfNo(JSPUtil.getParameter(request, prefix + "cost_trf_no", ""));
		setCntrSzCd(JSPUtil.getParameter(request, prefix + "cntr_sz_cd", ""));
		setDgFxRt(JSPUtil.getParameter(request, prefix + "dg_fx_rt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setRfFxRt(JSPUtil.getParameter(request, prefix + "rf_fx_rt", ""));
		setOvrWgtFxRt(JSPUtil.getParameter(request, prefix + "ovr_wgt_fx_rt", ""));
		setMinCgoWgt(JSPUtil.getParameter(request, prefix + "min_cgo_wgt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setMaxCgoWgt(JSPUtil.getParameter(request, prefix + "max_cgo_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FeederCostSpecialCargoVO[]
	 */
	public FeederCostSpecialCargoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FeederCostSpecialCargoVO[]
	 */
	public FeederCostSpecialCargoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FeederCostSpecialCargoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rfFxRto = (JSPUtil.getParameter(request, prefix	+ "rf_fx_rto", length));
			String[] dgFxRto = (JSPUtil.getParameter(request, prefix	+ "dg_fx_rto", length));
			String[] ovrWgtFxRto = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_fx_rto", length));
			String[] costTrfNo = (JSPUtil.getParameter(request, prefix	+ "cost_trf_no", length));
			String[] cntrSzCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sz_cd", length));
			String[] dgFxRt = (JSPUtil.getParameter(request, prefix	+ "dg_fx_rt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rfFxRt = (JSPUtil.getParameter(request, prefix	+ "rf_fx_rt", length));
			String[] ovrWgtFxRt = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_fx_rt", length));
			String[] minCgoWgt = (JSPUtil.getParameter(request, prefix	+ "min_cgo_wgt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] maxCgoWgt = (JSPUtil.getParameter(request, prefix	+ "max_cgo_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new FeederCostSpecialCargoVO();
				if (rfFxRto[i] != null)
					model.setRfFxRto(rfFxRto[i]);
				if (dgFxRto[i] != null)
					model.setDgFxRto(dgFxRto[i]);
				if (ovrWgtFxRto[i] != null)
					model.setOvrWgtFxRto(ovrWgtFxRto[i]);
				if (costTrfNo[i] != null)
					model.setCostTrfNo(costTrfNo[i]);
				if (cntrSzCd[i] != null)
					model.setCntrSzCd(cntrSzCd[i]);
				if (dgFxRt[i] != null)
					model.setDgFxRt(dgFxRt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rfFxRt[i] != null)
					model.setRfFxRt(rfFxRt[i]);
				if (ovrWgtFxRt[i] != null)
					model.setOvrWgtFxRt(ovrWgtFxRt[i]);
				if (minCgoWgt[i] != null)
					model.setMinCgoWgt(minCgoWgt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (maxCgoWgt[i] != null)
					model.setMaxCgoWgt(maxCgoWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFeederCostSpecialCargoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FeederCostSpecialCargoVO[]
	 */
	public FeederCostSpecialCargoVO[] getFeederCostSpecialCargoVOs(){
		FeederCostSpecialCargoVO[] vos = (FeederCostSpecialCargoVO[])models.toArray(new FeederCostSpecialCargoVO[models.size()]);
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
		this.rfFxRto = this.rfFxRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgFxRto = this.dgFxRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWgtFxRto = this.ovrWgtFxRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfNo = this.costTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSzCd = this.cntrSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgFxRt = this.dgFxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfFxRt = this.rfFxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWgtFxRt = this.ovrWgtFxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCgoWgt = this.minCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxCgoWgt = this.maxCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
