/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomPremiumInstallmentVO.java
*@FileTitle : CustomPremiumInstallmentVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2010.01.13 윤세영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.insurance.insurance.vo;

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
 * @author 윤세영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomPremiumInstallmentVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomPremiumInstallmentVO> models = new ArrayList<CustomPremiumInstallmentVO>();
	
	/* Column Info */
	private String insurTpCd = null;
	/* Column Info */
	private String instLoclAmt = null;
	/* Column Info */
	private String instUsdAmt = null;
	/* Column Info */
	private String instSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String instPayDt = null;
	/* Column Info */
	private String insurPrmTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String instXchRt = null;
	/* Column Info */
	private String instDueDt = null;
	/* Column Info */
	private String instCurrCd = null;
	/* Column Info */
	private String insurPlcyYr = null;
	/* Column Info */
	private String insurClmPtyNo = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomPremiumInstallmentVO() {}

	public CustomPremiumInstallmentVO(String ibflag, String pagerows, String insurTpCd, String insurPlcyYr, String insurClmPtyNo, String insurPrmTpCd, String instSeq, String instLoclAmt, String instCurrCd, String instXchRt, String instUsdAmt, String instDueDt, String instPayDt, String creUsrId, String updUsrId) {
		this.insurTpCd = insurTpCd;
		this.instLoclAmt = instLoclAmt;
		this.instUsdAmt = instUsdAmt;
		this.instSeq = instSeq;
		this.pagerows = pagerows;
		this.instPayDt = instPayDt;
		this.insurPrmTpCd = insurPrmTpCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.instXchRt = instXchRt;
		this.instDueDt = instDueDt;
		this.instCurrCd = instCurrCd;
		this.insurPlcyYr = insurPlcyYr;
		this.insurClmPtyNo = insurClmPtyNo;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("insur_tp_cd", getInsurTpCd());
		this.hashColumns.put("inst_locl_amt", getInstLoclAmt());
		this.hashColumns.put("inst_usd_amt", getInstUsdAmt());
		this.hashColumns.put("inst_seq", getInstSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inst_pay_dt", getInstPayDt());
		this.hashColumns.put("insur_prm_tp_cd", getInsurPrmTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inst_xch_rt", getInstXchRt());
		this.hashColumns.put("inst_due_dt", getInstDueDt());
		this.hashColumns.put("inst_curr_cd", getInstCurrCd());
		this.hashColumns.put("insur_plcy_yr", getInsurPlcyYr());
		this.hashColumns.put("insur_clm_pty_no", getInsurClmPtyNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("insur_tp_cd", "insurTpCd");
		this.hashFields.put("inst_locl_amt", "instLoclAmt");
		this.hashFields.put("inst_usd_amt", "instUsdAmt");
		this.hashFields.put("inst_seq", "instSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inst_pay_dt", "instPayDt");
		this.hashFields.put("insur_prm_tp_cd", "insurPrmTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inst_xch_rt", "instXchRt");
		this.hashFields.put("inst_due_dt", "instDueDt");
		this.hashFields.put("inst_curr_cd", "instCurrCd");
		this.hashFields.put("insur_plcy_yr", "insurPlcyYr");
		this.hashFields.put("insur_clm_pty_no", "insurClmPtyNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return insurTpCd
	 */
	public String getInsurTpCd() {
		return this.insurTpCd;
	}
	
	/**
	 * Column Info
	 * @return instLoclAmt
	 */
	public String getInstLoclAmt() {
		return this.instLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return instUsdAmt
	 */
	public String getInstUsdAmt() {
		return this.instUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return instSeq
	 */
	public String getInstSeq() {
		return this.instSeq;
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
	 * @return instPayDt
	 */
	public String getInstPayDt() {
		return this.instPayDt;
	}
	
	/**
	 * Column Info
	 * @return insurPrmTpCd
	 */
	public String getInsurPrmTpCd() {
		return this.insurPrmTpCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return instXchRt
	 */
	public String getInstXchRt() {
		return this.instXchRt;
	}
	
	/**
	 * Column Info
	 * @return instDueDt
	 */
	public String getInstDueDt() {
		return this.instDueDt;
	}
	
	/**
	 * Column Info
	 * @return instCurrCd
	 */
	public String getInstCurrCd() {
		return this.instCurrCd;
	}
	
	/**
	 * Column Info
	 * @return insurPlcyYr
	 */
	public String getInsurPlcyYr() {
		return this.insurPlcyYr;
	}
	
	/**
	 * Column Info
	 * @return insurClmPtyNo
	 */
	public String getInsurClmPtyNo() {
		return this.insurClmPtyNo;
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
	 * @param insurTpCd
	 */
	public void setInsurTpCd(String insurTpCd) {
		this.insurTpCd = insurTpCd;
	}
	
	/**
	 * Column Info
	 * @param instLoclAmt
	 */
	public void setInstLoclAmt(String instLoclAmt) {
		this.instLoclAmt = instLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param instUsdAmt
	 */
	public void setInstUsdAmt(String instUsdAmt) {
		this.instUsdAmt = instUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param instSeq
	 */
	public void setInstSeq(String instSeq) {
		this.instSeq = instSeq;
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
	 * @param instPayDt
	 */
	public void setInstPayDt(String instPayDt) {
		this.instPayDt = instPayDt;
	}
	
	/**
	 * Column Info
	 * @param insurPrmTpCd
	 */
	public void setInsurPrmTpCd(String insurPrmTpCd) {
		this.insurPrmTpCd = insurPrmTpCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param instXchRt
	 */
	public void setInstXchRt(String instXchRt) {
		this.instXchRt = instXchRt;
	}
	
	/**
	 * Column Info
	 * @param instDueDt
	 */
	public void setInstDueDt(String instDueDt) {
		this.instDueDt = instDueDt;
	}
	
	/**
	 * Column Info
	 * @param instCurrCd
	 */
	public void setInstCurrCd(String instCurrCd) {
		this.instCurrCd = instCurrCd;
	}
	
	/**
	 * Column Info
	 * @param insurPlcyYr
	 */
	public void setInsurPlcyYr(String insurPlcyYr) {
		this.insurPlcyYr = insurPlcyYr;
	}
	
	/**
	 * Column Info
	 * @param insurClmPtyNo
	 */
	public void setInsurClmPtyNo(String insurClmPtyNo) {
		this.insurClmPtyNo = insurClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInsurTpCd(JSPUtil.getParameter(request, "insur_tp_cd", ""));
		setInstLoclAmt(JSPUtil.getParameter(request, "inst_locl_amt", ""));
		setInstUsdAmt(JSPUtil.getParameter(request, "inst_usd_amt", ""));
		setInstSeq(JSPUtil.getParameter(request, "inst_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInstPayDt(JSPUtil.getParameter(request, "inst_pay_dt", ""));
		setInsurPrmTpCd(JSPUtil.getParameter(request, "insur_prm_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInstXchRt(JSPUtil.getParameter(request, "inst_xch_rt", ""));
		setInstDueDt(JSPUtil.getParameter(request, "inst_due_dt", ""));
		setInstCurrCd(JSPUtil.getParameter(request, "inst_curr_cd", ""));
		setInsurPlcyYr(JSPUtil.getParameter(request, "insur_plcy_yr", ""));
		setInsurClmPtyNo(JSPUtil.getParameter(request, "insur_clm_pty_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomPremiumInstallmentVO[]
	 */
	public CustomPremiumInstallmentVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomPremiumInstallmentVO[]
	 */
	public CustomPremiumInstallmentVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomPremiumInstallmentVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] insurTpCd = (JSPUtil.getParameter(request, prefix	+ "insur_tp_cd", length));
			String[] instLoclAmt = (JSPUtil.getParameter(request, prefix	+ "inst_locl_amt", length));
			String[] instUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inst_usd_amt", length));
			String[] instSeq = (JSPUtil.getParameter(request, prefix	+ "inst_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] instPayDt = (JSPUtil.getParameter(request, prefix	+ "inst_pay_dt", length));
			String[] insurPrmTpCd = (JSPUtil.getParameter(request, prefix	+ "insur_prm_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] instXchRt = (JSPUtil.getParameter(request, prefix	+ "inst_xch_rt", length));
			String[] instDueDt = (JSPUtil.getParameter(request, prefix	+ "inst_due_dt", length));
			String[] instCurrCd = (JSPUtil.getParameter(request, prefix	+ "inst_curr_cd", length));
			String[] insurPlcyYr = (JSPUtil.getParameter(request, prefix	+ "insur_plcy_yr", length));
			String[] insurClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomPremiumInstallmentVO();
				if (insurTpCd[i] != null)
					model.setInsurTpCd(insurTpCd[i]);
				if (instLoclAmt[i] != null)
					model.setInstLoclAmt(instLoclAmt[i]);
				if (instUsdAmt[i] != null)
					model.setInstUsdAmt(instUsdAmt[i]);
				if (instSeq[i] != null)
					model.setInstSeq(instSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (instPayDt[i] != null)
					model.setInstPayDt(instPayDt[i]);
				if (insurPrmTpCd[i] != null)
					model.setInsurPrmTpCd(insurPrmTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (instXchRt[i] != null)
					model.setInstXchRt(instXchRt[i]);
				if (instDueDt[i] != null)
					model.setInstDueDt(instDueDt[i]);
				if (instCurrCd[i] != null)
					model.setInstCurrCd(instCurrCd[i]);
				if (insurPlcyYr[i] != null)
					model.setInsurPlcyYr(insurPlcyYr[i]);
				if (insurClmPtyNo[i] != null)
					model.setInsurClmPtyNo(insurClmPtyNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomPremiumInstallmentVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomPremiumInstallmentVO[]
	 */
	public CustomPremiumInstallmentVO[] getCustomPremiumInstallmentVOs(){
		CustomPremiumInstallmentVO[] vos = (CustomPremiumInstallmentVO[])models.toArray(new CustomPremiumInstallmentVO[models.size()]);
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
		this.insurTpCd = this.insurTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.instLoclAmt = this.instLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.instUsdAmt = this.instUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.instSeq = this.instSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.instPayDt = this.instPayDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurPrmTpCd = this.insurPrmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.instXchRt = this.instXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.instDueDt = this.instDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.instCurrCd = this.instCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurPlcyYr = this.insurPlcyYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyNo = this.insurClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
