/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomSdmsSettlementVO.java
*@FileTitle : CustomSdmsSettlementVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.09.10 정윤태 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정윤태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomSdmsSettlementVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomSdmsSettlementVO> models = new ArrayList<CustomSdmsSettlementVO>();
	
	/* Column Info */
	private String stvDmgRmk = null;
	/* Column Info */
	private String payCurrCd = null;
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String payLoclAmt = null;
	/* Column Info */
	private String bilInvNo = null;
	/* Column Info */
	private String stvDmgStlProcStsCd = null;
	/* Column Info */
	private String shpOwnrCoNm = null;
	/* Column Info */
	private String stvDmgNo = null;
	/* Column Info */
	private String payAcctNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomSdmsSettlementVO() {}

	public CustomSdmsSettlementVO(String ibflag, String pagerows, String stvDmgNo, String stvDmgStlProcStsCd, String shpOwnrCoNm, String bilInvNo, String payDt, String payCurrCd, String payLoclAmt, String payAcctNo, String stvDmgRmk, String creUsrId) {
		this.stvDmgRmk = stvDmgRmk;
		this.payCurrCd = payCurrCd;
		this.payDt = payDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.payLoclAmt = payLoclAmt;
		this.bilInvNo = bilInvNo;
		this.stvDmgStlProcStsCd = stvDmgStlProcStsCd;
		this.shpOwnrCoNm = shpOwnrCoNm;
		this.stvDmgNo = stvDmgNo;
		this.payAcctNo = payAcctNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("stv_dmg_rmk", getStvDmgRmk());
		this.hashColumns.put("pay_curr_cd", getPayCurrCd());
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pay_locl_amt", getPayLoclAmt());
		this.hashColumns.put("bil_inv_no", getBilInvNo());
		this.hashColumns.put("stv_dmg_stl_proc_sts_cd", getStvDmgStlProcStsCd());
		this.hashColumns.put("shp_ownr_co_nm", getShpOwnrCoNm());
		this.hashColumns.put("stv_dmg_no", getStvDmgNo());
		this.hashColumns.put("pay_acct_no", getPayAcctNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("stv_dmg_rmk", "stvDmgRmk");
		this.hashFields.put("pay_curr_cd", "payCurrCd");
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pay_locl_amt", "payLoclAmt");
		this.hashFields.put("bil_inv_no", "bilInvNo");
		this.hashFields.put("stv_dmg_stl_proc_sts_cd", "stvDmgStlProcStsCd");
		this.hashFields.put("shp_ownr_co_nm", "shpOwnrCoNm");
		this.hashFields.put("stv_dmg_no", "stvDmgNo");
		this.hashFields.put("pay_acct_no", "payAcctNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return stvDmgRmk
	 */
	public String getStvDmgRmk() {
		return this.stvDmgRmk;
	}
	
	/**
	 * Column Info
	 * @return payCurrCd
	 */
	public String getPayCurrCd() {
		return this.payCurrCd;
	}
	
	/**
	 * Column Info
	 * @return payDt
	 */
	public String getPayDt() {
		return this.payDt;
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
	 * @return payLoclAmt
	 */
	public String getPayLoclAmt() {
		return this.payLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return bilInvNo
	 */
	public String getBilInvNo() {
		return this.bilInvNo;
	}
	
	/**
	 * Column Info
	 * @return stvDmgStlProcStsCd
	 */
	public String getStvDmgStlProcStsCd() {
		return this.stvDmgStlProcStsCd;
	}
	
	/**
	 * Column Info
	 * @return shpOwnrCoNm
	 */
	public String getShpOwnrCoNm() {
		return this.shpOwnrCoNm;
	}
	
	/**
	 * Column Info
	 * @return stvDmgNo
	 */
	public String getStvDmgNo() {
		return this.stvDmgNo;
	}
	
	/**
	 * Column Info
	 * @return payAcctNo
	 */
	public String getPayAcctNo() {
		return this.payAcctNo;
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
	 * @param stvDmgRmk
	 */
	public void setStvDmgRmk(String stvDmgRmk) {
		this.stvDmgRmk = stvDmgRmk;
	}
	
	/**
	 * Column Info
	 * @param payCurrCd
	 */
	public void setPayCurrCd(String payCurrCd) {
		this.payCurrCd = payCurrCd;
	}
	
	/**
	 * Column Info
	 * @param payDt
	 */
	public void setPayDt(String payDt) {
		this.payDt = payDt;
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
	 * @param payLoclAmt
	 */
	public void setPayLoclAmt(String payLoclAmt) {
		this.payLoclAmt = payLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param bilInvNo
	 */
	public void setBilInvNo(String bilInvNo) {
		this.bilInvNo = bilInvNo;
	}
	
	/**
	 * Column Info
	 * @param stvDmgStlProcStsCd
	 */
	public void setStvDmgStlProcStsCd(String stvDmgStlProcStsCd) {
		this.stvDmgStlProcStsCd = stvDmgStlProcStsCd;
	}
	
	/**
	 * Column Info
	 * @param shpOwnrCoNm
	 */
	public void setShpOwnrCoNm(String shpOwnrCoNm) {
		this.shpOwnrCoNm = shpOwnrCoNm;
	}
	
	/**
	 * Column Info
	 * @param stvDmgNo
	 */
	public void setStvDmgNo(String stvDmgNo) {
		this.stvDmgNo = stvDmgNo;
	}
	
	/**
	 * Column Info
	 * @param payAcctNo
	 */
	public void setPayAcctNo(String payAcctNo) {
		this.payAcctNo = payAcctNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setStvDmgRmk(JSPUtil.getParameter(request, "stv_dmg_rmk", ""));
		setPayCurrCd(JSPUtil.getParameter(request, "pay_curr_cd", ""));
		setPayDt(JSPUtil.getParameter(request, "pay_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPayLoclAmt(JSPUtil.getParameter(request, "pay_locl_amt", ""));
		setBilInvNo(JSPUtil.getParameter(request, "bil_inv_no", ""));
		setStvDmgStlProcStsCd(JSPUtil.getParameter(request, "stv_dmg_stl_proc_sts_cd", ""));
		setShpOwnrCoNm(JSPUtil.getParameter(request, "shp_ownr_co_nm", ""));
		setStvDmgNo(JSPUtil.getParameter(request, "stv_dmg_no", ""));
		setPayAcctNo(JSPUtil.getParameter(request, "pay_acct_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomSdmsSettlementVO[]
	 */
	public CustomSdmsSettlementVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomSdmsSettlementVO[]
	 */
	public CustomSdmsSettlementVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomSdmsSettlementVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] stvDmgRmk = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_rmk", length));
			String[] payCurrCd = (JSPUtil.getParameter(request, prefix	+ "pay_curr_cd", length));
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] payLoclAmt = (JSPUtil.getParameter(request, prefix	+ "pay_locl_amt", length));
			String[] bilInvNo = (JSPUtil.getParameter(request, prefix	+ "bil_inv_no", length));
			String[] stvDmgStlProcStsCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_stl_proc_sts_cd", length));
			String[] shpOwnrCoNm = (JSPUtil.getParameter(request, prefix	+ "shp_ownr_co_nm", length));
			String[] stvDmgNo = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_no", length));
			String[] payAcctNo = (JSPUtil.getParameter(request, prefix	+ "pay_acct_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomSdmsSettlementVO();
				if (stvDmgRmk[i] != null)
					model.setStvDmgRmk(stvDmgRmk[i]);
				if (payCurrCd[i] != null)
					model.setPayCurrCd(payCurrCd[i]);
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (payLoclAmt[i] != null)
					model.setPayLoclAmt(payLoclAmt[i]);
				if (bilInvNo[i] != null)
					model.setBilInvNo(bilInvNo[i]);
				if (stvDmgStlProcStsCd[i] != null)
					model.setStvDmgStlProcStsCd(stvDmgStlProcStsCd[i]);
				if (shpOwnrCoNm[i] != null)
					model.setShpOwnrCoNm(shpOwnrCoNm[i]);
				if (stvDmgNo[i] != null)
					model.setStvDmgNo(stvDmgNo[i]);
				if (payAcctNo[i] != null)
					model.setPayAcctNo(payAcctNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomSdmsSettlementVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomSdmsSettlementVO[]
	 */
	public CustomSdmsSettlementVO[] getCustomSdmsSettlementVOs(){
		CustomSdmsSettlementVO[] vos = (CustomSdmsSettlementVO[])models.toArray(new CustomSdmsSettlementVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.stvDmgRmk = this.stvDmgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payCurrCd = this.payCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDt = this.payDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payLoclAmt = this.payLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilInvNo = this.bilInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgStlProcStsCd = this.stvDmgStlProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpOwnrCoNm = this.shpOwnrCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgNo = this.stvDmgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAcctNo = this.payAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
