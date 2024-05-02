/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomMnrDispCancelVO.java
*@FileTitle : CustomMnrDispCancelVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.28
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2011.04.28 김종옥 
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.05.02 김종옥 [CHM-201110180-01] ALPS MNR->Disposal Invoice issue 이전/이후 잘못 Request 또는 재사용 장비 삭제 기능 보완 요청
*                                      - Disposal Request/Invoice issue한 건에 대하여 매각 완료 후, 재사용함에 따라 SLD Cancellation Logic 추가개발
* 2012.01.13 김상수 [CHM-201215565-01] ALPS MNR-Disposal-SLD Management-> SLD Cancellation 보완 요청
*                                      - Disposal Sold Cancelation 화면에서 M.G.Set과 Chassis도 SLD Cancel 가능하도록 CGM연계로직 추가
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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrDispCancelVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrDispCancelVO> models = new ArrayList<CustomMnrDispCancelVO>();
	
	/* Column Info */
	private String dispSoldDt = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String cntrStsCd = null;
	/* Column Info */
	private String dispDtlSeq = null;
	/* Column Info */
	private String eqKndCd = null;
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
	private String buyerCode = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String mnrInvStsCd = null;
	/* Column Info */
	private String lstStsYdCd = null;
	/* Column Info */
	private String eqKndNm = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrDispCancelVO() {}

	public CustomMnrDispCancelVO(String ibflag, String pagerows, String dispSoldDt, String dispNo, String cntrStsCd, String dispDtlSeq, String buyerName, String eqTpszCd, String eqKndCd, String eqKndNm, String invNo, String buyerCode, String cnmvStsCd, String eqNo, String lstStsYdCd, String mnrInvStsCd, String lstmCd, String updUsrId) {
		this.dispSoldDt = dispSoldDt;
		this.dispNo = dispNo;
		this.cntrStsCd = cntrStsCd;
		this.dispDtlSeq = dispDtlSeq;
		this.eqKndCd = eqKndCd;
		this.buyerName = buyerName;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.invNo = invNo;
		this.ibflag = ibflag;
		this.buyerCode = buyerCode;
		this.cnmvStsCd = cnmvStsCd;
		this.eqNo = eqNo;
		this.mnrInvStsCd = mnrInvStsCd;
		this.lstStsYdCd = lstStsYdCd;
		this.eqKndNm = eqKndNm;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("disp_sold_dt", getDispSoldDt());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("cntr_sts_cd", getCntrStsCd());
		this.hashColumns.put("disp_dtl_seq", getDispDtlSeq());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("buyer_name", getBuyerName());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("buyer_code", getBuyerCode());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("mnr_inv_sts_cd", getMnrInvStsCd());
		this.hashColumns.put("lst_sts_yd_cd", getLstStsYdCd());
		this.hashColumns.put("eq_knd_nm", getEqKndNm());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("disp_sold_dt", "dispSoldDt");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("cntr_sts_cd", "cntrStsCd");
		this.hashFields.put("disp_dtl_seq", "dispDtlSeq");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("buyer_name", "buyerName");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("buyer_code", "buyerCode");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("mnr_inv_sts_cd", "mnrInvStsCd");
		this.hashFields.put("lst_sts_yd_cd", "lstStsYdCd");
		this.hashFields.put("eq_knd_nm", "eqKndNm");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dispSoldDt
	 */
	public String getDispSoldDt() {
		return this.dispSoldDt;
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
	 * @return cntrStsCd
	 */
	public String getCntrStsCd() {
		return this.cntrStsCd;
	}
	
	/**
	 * Column Info
	 * @return dispDtlSeq
	 */
	public String getDispDtlSeq() {
		return this.dispDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @return buyerCode
	 */
	public String getBuyerCode() {
		return this.buyerCode;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
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
	 * @return mnrInvStsCd
	 */
	public String getMnrInvStsCd() {
		return this.mnrInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return lstStsYdCd
	 */
	public String getLstStsYdCd() {
		return this.lstStsYdCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndNm
	 */
	public String getEqKndNm() {
		return this.eqKndNm;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param dispSoldDt
	 */
	public void setDispSoldDt(String dispSoldDt) {
		this.dispSoldDt = dispSoldDt;
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
	 * @param cntrStsCd
	 */
	public void setCntrStsCd(String cntrStsCd) {
		this.cntrStsCd = cntrStsCd;
	}
	
	/**
	 * Column Info
	 * @param dispDtlSeq
	 */
	public void setDispDtlSeq(String dispDtlSeq) {
		this.dispDtlSeq = dispDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
	 * @param buyerCode
	 */
	public void setBuyerCode(String buyerCode) {
		this.buyerCode = buyerCode;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
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
	 * @param mnrInvStsCd
	 */
	public void setMnrInvStsCd(String mnrInvStsCd) {
		this.mnrInvStsCd = mnrInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param lstStsYdCd
	 */
	public void setLstStsYdCd(String lstStsYdCd) {
		this.lstStsYdCd = lstStsYdCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndNm
	 */
	public void setEqKndNm(String eqKndNm) {
		this.eqKndNm = eqKndNm;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setDispSoldDt(JSPUtil.getParameter(request, prefix + "disp_sold_dt", ""));
		setDispNo(JSPUtil.getParameter(request, prefix + "disp_no", ""));
		setCntrStsCd(JSPUtil.getParameter(request, prefix + "cntr_sts_cd", ""));
		setDispDtlSeq(JSPUtil.getParameter(request, prefix + "disp_dtl_seq", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setBuyerName(JSPUtil.getParameter(request, prefix + "buyer_name", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBuyerCode(JSPUtil.getParameter(request, prefix + "buyer_code", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setMnrInvStsCd(JSPUtil.getParameter(request, prefix + "mnr_inv_sts_cd", ""));
		setLstStsYdCd(JSPUtil.getParameter(request, prefix + "lst_sts_yd_cd", ""));
		setEqKndNm(JSPUtil.getParameter(request, prefix + "eq_knd_nm", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrDispCancelVO[]
	 */
	public CustomMnrDispCancelVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrDispCancelVO[]
	 */
	public CustomMnrDispCancelVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrDispCancelVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dispSoldDt = (JSPUtil.getParameter(request, prefix	+ "disp_sold_dt", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] cntrStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd", length));
			String[] dispDtlSeq = (JSPUtil.getParameter(request, prefix	+ "disp_dtl_seq", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] buyerName = (JSPUtil.getParameter(request, prefix	+ "buyer_name", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] buyerCode = (JSPUtil.getParameter(request, prefix	+ "buyer_code", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] mnrInvStsCd = (JSPUtil.getParameter(request, prefix	+ "mnr_inv_sts_cd", length));
			String[] lstStsYdCd = (JSPUtil.getParameter(request, prefix	+ "lst_sts_yd_cd", length));
			String[] eqKndNm = (JSPUtil.getParameter(request, prefix	+ "eq_knd_nm", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrDispCancelVO();
				if (dispSoldDt[i] != null)
					model.setDispSoldDt(dispSoldDt[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (cntrStsCd[i] != null)
					model.setCntrStsCd(cntrStsCd[i]);
				if (dispDtlSeq[i] != null)
					model.setDispDtlSeq(dispDtlSeq[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
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
				if (buyerCode[i] != null)
					model.setBuyerCode(buyerCode[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (mnrInvStsCd[i] != null)
					model.setMnrInvStsCd(mnrInvStsCd[i]);
				if (lstStsYdCd[i] != null)
					model.setLstStsYdCd(lstStsYdCd[i]);
				if (eqKndNm[i] != null)
					model.setEqKndNm(eqKndNm[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrDispCancelVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrDispCancelVO[]
	 */
	public CustomMnrDispCancelVO[] getCustomMnrDispCancelVOs(){
		CustomMnrDispCancelVO[] vos = (CustomMnrDispCancelVO[])models.toArray(new CustomMnrDispCancelVO[models.size()]);
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
		this.dispSoldDt = this.dispSoldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCd = this.cntrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispDtlSeq = this.dispDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buyerName = this.buyerName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buyerCode = this.buyerCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvStsCd = this.mnrInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstStsYdCd = this.lstStsYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndNm = this.eqKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
