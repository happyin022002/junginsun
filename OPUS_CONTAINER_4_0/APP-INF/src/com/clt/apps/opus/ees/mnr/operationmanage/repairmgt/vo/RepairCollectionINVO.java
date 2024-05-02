/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepairCollectionINVO.java
*@FileTitle : RepairCollectionINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.07
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.04.07 박명신 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo;
	
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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepairCollectionINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RepairCollectionINVO> models = new ArrayList<RepairCollectionINVO>();
	
	/* Column Info */
	private String curOfcCd = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String toEstDt = null;
	/* Column Info */
	private String rqstRefNo = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ediErrorOnly = null;
	/* Column Info */
	private String tpbOnly = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String woType = null;
	/* Column Info */
	private String statusCd = null;
	/* Column Info */
	private String rqstEqNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String fmEstDt = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String screenFlag = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String newPortOnly = null;
	/* Column Info */
	private String solOnly = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RepairCollectionINVO() {}

	public RepairCollectionINVO(String ibflag, String pagerows, String curOfcCd, String costOfcCd, String toEstDt, String rqstRefNo, String eqKndCd, String ediErrorOnly, String tpbOnly, String woType, String statusCd, String rqstEqNo, String vndrSeq, String fmEstDt, String woNo, String screenFlag, String costCd, String newPortOnly, String solOnly) {
		this.curOfcCd = curOfcCd;
		this.costOfcCd = costOfcCd;
		this.toEstDt = toEstDt;
		this.rqstRefNo = rqstRefNo;
		this.eqKndCd = eqKndCd;
		this.pagerows = pagerows;
		this.ediErrorOnly = ediErrorOnly;
		this.tpbOnly = tpbOnly;
		this.ibflag = ibflag;
		this.woType = woType;
		this.statusCd = statusCd;
		this.rqstEqNo = rqstEqNo;
		this.vndrSeq = vndrSeq;
		this.fmEstDt = fmEstDt;
		this.woNo = woNo;
		this.screenFlag = screenFlag;
		this.costCd = costCd;
		this.newPortOnly = newPortOnly;
		this.solOnly = solOnly;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cur_ofc_cd", getCurOfcCd());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("to_est_dt", getToEstDt());
		this.hashColumns.put("rqst_ref_no", getRqstRefNo());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("edi_error_only", getEdiErrorOnly());
		this.hashColumns.put("tpb_only", getTpbOnly());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wo_type", getWoType());
		this.hashColumns.put("status_cd", getStatusCd());
		this.hashColumns.put("rqst_eq_no", getRqstEqNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("fm_est_dt", getFmEstDt());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("screen_flag", getScreenFlag());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("new_port_only", getNewPortOnly());
		this.hashColumns.put("sol_only", getSolOnly());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cur_ofc_cd", "curOfcCd");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("to_est_dt", "toEstDt");
		this.hashFields.put("rqst_ref_no", "rqstRefNo");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("edi_error_only", "ediErrorOnly");
		this.hashFields.put("tpb_only", "tpbOnly");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wo_type", "woType");
		this.hashFields.put("status_cd", "statusCd");
		this.hashFields.put("rqst_eq_no", "rqstEqNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("fm_est_dt", "fmEstDt");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("screen_flag", "screenFlag");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("new_port_only", "newPortOnly");
		this.hashFields.put("sol_only", "solOnly");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return curOfcCd
	 */
	public String getCurOfcCd() {
		return this.curOfcCd;
	}
	
	/**
	 * Column Info
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return toEstDt
	 */
	public String getToEstDt() {
		return this.toEstDt;
	}
	
	/**
	 * Column Info
	 * @return rqstRefNo
	 */
	public String getRqstRefNo() {
		return this.rqstRefNo;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @return ediErrorOnly
	 */
	public String getEdiErrorOnly() {
		return this.ediErrorOnly;
	}
	
	/**
	 * Column Info
	 * @return tpbOnly
	 */
	public String getTpbOnly() {
		return this.tpbOnly;
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
	 * @return woType
	 */
	public String getWoType() {
		return this.woType;
	}
	
	/**
	 * Column Info
	 * @return statusCd
	 */
	public String getStatusCd() {
		return this.statusCd;
	}
	
	/**
	 * Column Info
	 * @return rqstEqNo
	 */
	public String getRqstEqNo() {
		return this.rqstEqNo;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return fmEstDt
	 */
	public String getFmEstDt() {
		return this.fmEstDt;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return screenFlag
	 */
	public String getScreenFlag() {
		return this.screenFlag;
	}
	
	/**
	 * Column Info
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
	}

	/**
	 * Column Info
	 * @return newPortOnly
	 */
	public String getNewPortOnly() {
		return this.newPortOnly;
	}
	
	/**
	 * Column Info
	 * @return solOnly
	 */
	public String getSolOnly() {
		return this.solOnly;
	}

	/**
	 * Column Info
	 * @param curOfcCd
	 */
	public void setCurOfcCd(String curOfcCd) {
		this.curOfcCd = curOfcCd;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param toEstDt
	 */
	public void setToEstDt(String toEstDt) {
		this.toEstDt = toEstDt;
	}
	
	/**
	 * Column Info
	 * @param rqstRefNo
	 */
	public void setRqstRefNo(String rqstRefNo) {
		this.rqstRefNo = rqstRefNo;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
	 * @param ediErrorOnly
	 */
	public void setEdiErrorOnly(String ediErrorOnly) {
		this.ediErrorOnly = ediErrorOnly;
	}
	
	/**
	 * Column Info
	 * @param tpbOnly
	 */
	public void setTpbOnly(String tpbOnly) {
		this.tpbOnly = tpbOnly;
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
	 * @param woType
	 */
	public void setWoType(String woType) {
		this.woType = woType;
	}
	
	/**
	 * Column Info
	 * @param statusCd
	 */
	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}
	
	/**
	 * Column Info
	 * @param rqstEqNo
	 */
	public void setRqstEqNo(String rqstEqNo) {
		this.rqstEqNo = rqstEqNo;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param fmEstDt
	 */
	public void setFmEstDt(String fmEstDt) {
		this.fmEstDt = fmEstDt;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param screenFlag
	 */
	public void setScreenFlag(String screenFlag) {
		this.screenFlag = screenFlag;
	}
	
	/**
	 * Column Info
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	
	/**
	 * Column Info
	 * @param newPortOnly
	 */
	public void setNewPortOnly(String newPortOnly) {
		this.newPortOnly = newPortOnly;
	}
	
	/**
	 * Column Info
	 * @param solOnly
	 */
	public void setSolOnly(String solOnly) {
		this.solOnly = solOnly;
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
		setCurOfcCd(JSPUtil.getParameter(request, prefix + "cur_ofc_cd", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setToEstDt(JSPUtil.getParameter(request, prefix + "to_est_dt", ""));
		setRqstRefNo(JSPUtil.getParameter(request, prefix + "rqst_ref_no", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEdiErrorOnly(JSPUtil.getParameter(request, prefix + "edi_error_only", ""));
		setTpbOnly(JSPUtil.getParameter(request, prefix + "tpb_only", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setWoType(JSPUtil.getParameter(request, prefix + "wo_type", ""));
		setStatusCd(JSPUtil.getParameter(request, prefix + "status_cd", ""));
		setRqstEqNo(JSPUtil.getParameter(request, prefix + "rqst_eq_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setFmEstDt(JSPUtil.getParameter(request, prefix + "fm_est_dt", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setScreenFlag(JSPUtil.getParameter(request, prefix + "screen_flag", ""));
		setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
		setNewPortOnly(JSPUtil.getParameter(request, prefix + "new_port_only", ""));
		setSolOnly(JSPUtil.getParameter(request, prefix + "sol_only", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RepairCollectionINVO[]
	 */
	public RepairCollectionINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RepairCollectionINVO[]
	 */
	public RepairCollectionINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RepairCollectionINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] curOfcCd = (JSPUtil.getParameter(request, prefix	+ "cur_ofc_cd", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] toEstDt = (JSPUtil.getParameter(request, prefix	+ "to_est_dt", length));
			String[] rqstRefNo = (JSPUtil.getParameter(request, prefix	+ "rqst_ref_no", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ediErrorOnly = (JSPUtil.getParameter(request, prefix	+ "edi_error_only", length));
			String[] tpbOnly = (JSPUtil.getParameter(request, prefix	+ "tpb_only", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] woType = (JSPUtil.getParameter(request, prefix	+ "wo_type", length));
			String[] statusCd = (JSPUtil.getParameter(request, prefix	+ "status_cd", length));
			String[] rqstEqNo = (JSPUtil.getParameter(request, prefix	+ "rqst_eq_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] fmEstDt = (JSPUtil.getParameter(request, prefix	+ "fm_est_dt", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] screenFlag = (JSPUtil.getParameter(request, prefix	+ "screen_flag", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] newPortOnly = (JSPUtil.getParameter(request, prefix	+ "new_port_only", length));
			String[] solOnly = (JSPUtil.getParameter(request, prefix	+ "sol_only", length));
			
			for (int i = 0; i < length; i++) {
				model = new RepairCollectionINVO();
				if (curOfcCd[i] != null)
					model.setCurOfcCd(curOfcCd[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (toEstDt[i] != null)
					model.setToEstDt(toEstDt[i]);
				if (rqstRefNo[i] != null)
					model.setRqstRefNo(rqstRefNo[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ediErrorOnly[i] != null)
					model.setEdiErrorOnly(ediErrorOnly[i]);
				if (tpbOnly[i] != null)
					model.setTpbOnly(tpbOnly[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (woType[i] != null)
					model.setWoType(woType[i]);
				if (statusCd[i] != null)
					model.setStatusCd(statusCd[i]);
				if (rqstEqNo[i] != null)
					model.setRqstEqNo(rqstEqNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (fmEstDt[i] != null)
					model.setFmEstDt(fmEstDt[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (screenFlag[i] != null)
					model.setScreenFlag(screenFlag[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (newPortOnly[i] != null)
					model.setNewPortOnly(newPortOnly[i]);
				if (solOnly[i] != null)
					model.setSolOnly(solOnly[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRepairCollectionINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RepairCollectionINVO[]
	 */
	public RepairCollectionINVO[] getRepairCollectionINVOs(){
		RepairCollectionINVO[] vos = (RepairCollectionINVO[])models.toArray(new RepairCollectionINVO[models.size()]);
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
		this.curOfcCd = this.curOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEstDt = this.toEstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstRefNo = this.rqstRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediErrorOnly = this.ediErrorOnly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbOnly = this.tpbOnly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woType = this.woType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusCd = this.statusCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstEqNo = this.rqstEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEstDt = this.fmEstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.screenFlag = this.screenFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPortOnly = this.newPortOnly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.solOnly = this.solOnly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
