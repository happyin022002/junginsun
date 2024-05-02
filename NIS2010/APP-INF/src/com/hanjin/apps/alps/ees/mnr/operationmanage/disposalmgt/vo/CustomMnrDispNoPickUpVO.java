/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomMnrDispNoPickUpVO.java
*@FileTitle : CustomMnrDispNoPickUpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.12  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrDispNoPickUpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrDispNoPickUpVO> models = new ArrayList<CustomMnrDispNoPickUpVO>();
	
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String dispPkupStDt = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String mvmtCd = null;
	/* Column Info */
	private String dispPkupEndDt = null;
	/* Column Info */
	private String dispBultnDt = null;
	/* Column Info */
	private String buyerName = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String invNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dispStDt = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String dispYdCd = null;
	/* Column Info */
	private String partAmt = null;
	/* Column Info */
	private String dispEndDt = null;
	/* Column Info */
	private String lstmCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrDispNoPickUpVO() {}

	public CustomMnrDispNoPickUpVO(String ibflag, String pagerows, String dispNo, String invNo, String buyerName, String eqNo, String eqTpszCd, String lstmCd, String mvmtCd, String dispYdCd, String rqstDt, String dispBultnDt, String dispStDt, String dispEndDt, String dispPkupStDt, String dispPkupEndDt, String partAmt) {
		this.rqstDt = rqstDt;
		this.dispPkupStDt = dispPkupStDt;
		this.dispNo = dispNo;
		this.mvmtCd = mvmtCd;
		this.dispPkupEndDt = dispPkupEndDt;
		this.dispBultnDt = dispBultnDt;
		this.buyerName = buyerName;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.invNo = invNo;
		this.ibflag = ibflag;
		this.dispStDt = dispStDt;
		this.eqNo = eqNo;
		this.dispYdCd = dispYdCd;
		this.partAmt = partAmt;
		this.dispEndDt = dispEndDt;
		this.lstmCd = lstmCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("disp_pkup_st_dt", getDispPkupStDt());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("mvmt_cd", getMvmtCd());
		this.hashColumns.put("disp_pkup_end_dt", getDispPkupEndDt());
		this.hashColumns.put("disp_bultn_dt", getDispBultnDt());
		this.hashColumns.put("buyer_name", getBuyerName());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("disp_st_dt", getDispStDt());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("disp_yd_cd", getDispYdCd());
		this.hashColumns.put("part_amt", getPartAmt());
		this.hashColumns.put("disp_end_dt", getDispEndDt());
		this.hashColumns.put("lstm_cd", getLstmCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("disp_pkup_st_dt", "dispPkupStDt");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("mvmt_cd", "mvmtCd");
		this.hashFields.put("disp_pkup_end_dt", "dispPkupEndDt");
		this.hashFields.put("disp_bultn_dt", "dispBultnDt");
		this.hashFields.put("buyer_name", "buyerName");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("disp_st_dt", "dispStDt");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("disp_yd_cd", "dispYdCd");
		this.hashFields.put("part_amt", "partAmt");
		this.hashFields.put("disp_end_dt", "dispEndDt");
		this.hashFields.put("lstm_cd", "lstmCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return dispPkupStDt
	 */
	public String getDispPkupStDt() {
		return this.dispPkupStDt;
	}
	
	/**
	 * Column Info
	 * @return dispNo
	 */
	public String getDispNo() {
		return this.dispNo;
	}
	
	/**
	 * Column Info
	 * @return mvmtCd
	 */
	public String getMvmtCd() {
		return this.mvmtCd;
	}
	
	/**
	 * Column Info
	 * @return dispPkupEndDt
	 */
	public String getDispPkupEndDt() {
		return this.dispPkupEndDt;
	}
	
	/**
	 * Column Info
	 * @return dispBultnDt
	 */
	public String getDispBultnDt() {
		return this.dispBultnDt;
	}
	
	/**
	 * Column Info
	 * @return buyerName
	 */
	public String getBuyerName() {
		return this.buyerName;
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
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return dispStDt
	 */
	public String getDispStDt() {
		return this.dispStDt;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return dispYdCd
	 */
	public String getDispYdCd() {
		return this.dispYdCd;
	}
	
	/**
	 * Column Info
	 * @return partAmt
	 */
	public String getPartAmt() {
		return this.partAmt;
	}
	
	/**
	 * Column Info
	 * @return dispEndDt
	 */
	public String getDispEndDt() {
		return this.dispEndDt;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	

	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param dispPkupStDt
	 */
	public void setDispPkupStDt(String dispPkupStDt) {
		this.dispPkupStDt = dispPkupStDt;
	}
	
	/**
	 * Column Info
	 * @param dispNo
	 */
	public void setDispNo(String dispNo) {
		this.dispNo = dispNo;
	}
	
	/**
	 * Column Info
	 * @param mvmtCd
	 */
	public void setMvmtCd(String mvmtCd) {
		this.mvmtCd = mvmtCd;
	}
	
	/**
	 * Column Info
	 * @param dispPkupEndDt
	 */
	public void setDispPkupEndDt(String dispPkupEndDt) {
		this.dispPkupEndDt = dispPkupEndDt;
	}
	
	/**
	 * Column Info
	 * @param dispBultnDt
	 */
	public void setDispBultnDt(String dispBultnDt) {
		this.dispBultnDt = dispBultnDt;
	}
	
	/**
	 * Column Info
	 * @param buyerName
	 */
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
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
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param dispStDt
	 */
	public void setDispStDt(String dispStDt) {
		this.dispStDt = dispStDt;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param dispYdCd
	 */
	public void setDispYdCd(String dispYdCd) {
		this.dispYdCd = dispYdCd;
	}
	
	/**
	 * Column Info
	 * @param partAmt
	 */
	public void setPartAmt(String partAmt) {
		this.partAmt = partAmt;
	}
	
	/**
	 * Column Info
	 * @param dispEndDt
	 */
	public void setDispEndDt(String dispEndDt) {
		this.dispEndDt = dispEndDt;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
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
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setDispPkupStDt(JSPUtil.getParameter(request, prefix + "disp_pkup_st_dt", ""));
		setDispNo(JSPUtil.getParameter(request, prefix + "disp_no", ""));
		setMvmtCd(JSPUtil.getParameter(request, prefix + "mvmt_cd", ""));
		setDispPkupEndDt(JSPUtil.getParameter(request, prefix + "disp_pkup_end_dt", ""));
		setDispBultnDt(JSPUtil.getParameter(request, prefix + "disp_bultn_dt", ""));
		setBuyerName(JSPUtil.getParameter(request, prefix + "buyer_name", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDispStDt(JSPUtil.getParameter(request, prefix + "disp_st_dt", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setDispYdCd(JSPUtil.getParameter(request, prefix + "disp_yd_cd", ""));
		setPartAmt(JSPUtil.getParameter(request, prefix + "part_amt", ""));
		setDispEndDt(JSPUtil.getParameter(request, prefix + "disp_end_dt", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrDispNoPickUpVO[]
	 */
	public CustomMnrDispNoPickUpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrDispNoPickUpVO[]
	 */
	public CustomMnrDispNoPickUpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrDispNoPickUpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] dispPkupStDt = (JSPUtil.getParameter(request, prefix	+ "disp_pkup_st_dt", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] mvmtCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cd", length));
			String[] dispPkupEndDt = (JSPUtil.getParameter(request, prefix	+ "disp_pkup_end_dt", length));
			String[] dispBultnDt = (JSPUtil.getParameter(request, prefix	+ "disp_bultn_dt", length));
			String[] buyerName = (JSPUtil.getParameter(request, prefix	+ "buyer_name", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dispStDt = (JSPUtil.getParameter(request, prefix	+ "disp_st_dt", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] dispYdCd = (JSPUtil.getParameter(request, prefix	+ "disp_yd_cd", length));
			String[] partAmt = (JSPUtil.getParameter(request, prefix	+ "part_amt", length));
			String[] dispEndDt = (JSPUtil.getParameter(request, prefix	+ "disp_end_dt", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrDispNoPickUpVO();
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (dispPkupStDt[i] != null)
					model.setDispPkupStDt(dispPkupStDt[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (mvmtCd[i] != null)
					model.setMvmtCd(mvmtCd[i]);
				if (dispPkupEndDt[i] != null)
					model.setDispPkupEndDt(dispPkupEndDt[i]);
				if (dispBultnDt[i] != null)
					model.setDispBultnDt(dispBultnDt[i]);
				if (buyerName[i] != null)
					model.setBuyerName(buyerName[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dispStDt[i] != null)
					model.setDispStDt(dispStDt[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (dispYdCd[i] != null)
					model.setDispYdCd(dispYdCd[i]);
				if (partAmt[i] != null)
					model.setPartAmt(partAmt[i]);
				if (dispEndDt[i] != null)
					model.setDispEndDt(dispEndDt[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrDispNoPickUpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrDispNoPickUpVO[]
	 */
	public CustomMnrDispNoPickUpVO[] getCustomMnrDispNoPickUpVOs(){
		CustomMnrDispNoPickUpVO[] vos = (CustomMnrDispNoPickUpVO[])models.toArray(new CustomMnrDispNoPickUpVO[models.size()]);
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
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispPkupStDt = this.dispPkupStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCd = this.mvmtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispPkupEndDt = this.dispPkupEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispBultnDt = this.dispBultnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buyerName = this.buyerName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispStDt = this.dispStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispYdCd = this.dispYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partAmt = this.partAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispEndDt = this.dispEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
