/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvArBankListVO.java
*@FileTitle : InvArBankListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.05.06 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 정휘택
 * @since J2EE 1.5
 */

public class InvArBankListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvArBankListVO> models = new ArrayList<InvArBankListVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String bankAcctRmk = null;
	/* Column Info */
	private String bankNm = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String bankShrtNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bankAcctCurrCd = null;
	/* Column Info */
	private String bankAcctNo = null;
	/* Column Info */
	private String bankAddr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String arOfcCd = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvArBankListVO() {}

	public InvArBankListVO(String ibflag, String pagerows, String bankAcctNo, String bankNm, String bankShrtNm, String ofcCd, String bankAcctCurrCd, String bankAddr, String bankAcctRmk, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String arOfcCd) {
		this.ibflag = ibflag;
		this.bankAcctRmk = bankAcctRmk;
		this.bankNm = bankNm;
		this.ofcCd = ofcCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.bankShrtNm = bankShrtNm;
		this.creDt = creDt;
		this.deltFlg = deltFlg;
		this.creUsrId = creUsrId;
		this.bankAcctCurrCd = bankAcctCurrCd;
		this.bankAcctNo = bankAcctNo;
		this.bankAddr = bankAddr;
		this.pagerows = pagerows;
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bank_acct_rmk", getBankAcctRmk());
		this.hashColumns.put("bank_nm", getBankNm());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bank_shrt_nm", getBankShrtNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bank_acct_curr_cd", getBankAcctCurrCd());
		this.hashColumns.put("bank_acct_no", getBankAcctNo());
		this.hashColumns.put("bank_addr", getBankAddr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bank_acct_rmk", "bankAcctRmk");
		this.hashFields.put("bank_nm", "bankNm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bank_shrt_nm", "bankShrtNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bank_acct_curr_cd", "bankAcctCurrCd");
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("bank_addr", "bankAddr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getBankAcctRmk() {
		return this.bankAcctRmk;
	}
	public String getBankNm() {
		return this.bankNm;
	}
	public String getOfcCd() {
		return this.ofcCd;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getUpdDt() {
		return this.updDt;
	}
	public String getBankShrtNm() {
		return this.bankShrtNm;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getDeltFlg() {
		return this.deltFlg;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getBankAcctCurrCd() {
		return this.bankAcctCurrCd;
	}
	public String getBankAcctNo() {
		return this.bankAcctNo;
	}
	public String getBankAddr() {
		return this.bankAddr;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getArOfcCd() {
		return this.arOfcCd;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setBankAcctRmk(String bankAcctRmk) {
		this.bankAcctRmk = bankAcctRmk;
		//this.bankAcctRmk=true;
	}
	public void setBankNm(String bankNm) {
		this.bankNm = bankNm;
		//this.bankNm=true;
	}
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
		//this.ofcCd=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setBankShrtNm(String bankShrtNm) {
		this.bankShrtNm = bankShrtNm;
		//this.bankShrtNm=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
		//this.deltFlg=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setBankAcctCurrCd(String bankAcctCurrCd) {
		this.bankAcctCurrCd = bankAcctCurrCd;
		//this.bankAcctCurrCd=true;
	}
	public void setBankAcctNo(String bankAcctNo) {
		this.bankAcctNo = bankAcctNo;
		//this.bankAcctNo=true;
	}
	public void setBankAddr(String bankAddr) {
		this.bankAddr = bankAddr;
		//this.bankAddr=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
		//this.ofcCd=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBankAcctRmk(JSPUtil.getParameter(request, "bank_acct_rmk", ""));
		setBankNm(JSPUtil.getParameter(request, "bank_nm", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setBankShrtNm(JSPUtil.getParameter(request, "bank_shrt_nm", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBankAcctCurrCd(JSPUtil.getParameter(request, "bank_acct_curr_cd", ""));
		setBankAcctNo(JSPUtil.getParameter(request, "bank_acct_no", ""));
		setBankAddr(JSPUtil.getParameter(request, "bank_addr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
	}

	public InvArBankListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public InvArBankListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvArBankListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] bankAcctRmk = (JSPUtil.getParameter(request, prefix	+ "bank_acct_rmk".trim(), length));
			String[] bankNm = (JSPUtil.getParameter(request, prefix	+ "bank_nm".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] bankShrtNm = (JSPUtil.getParameter(request, prefix	+ "bank_shrt_nm".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] bankAcctCurrCd = (JSPUtil.getParameter(request, prefix	+ "bank_acct_curr_cd".trim(), length));
			String[] bankAcctNo = (JSPUtil.getParameter(request, prefix	+ "bank_acct_no".trim(), length));
			String[] bankAddr = (JSPUtil.getParameter(request, prefix	+ "bank_addr".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd".trim(), length));
			
			
			for (int i = 0; i < length; i++) {
				model = new InvArBankListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bankAcctRmk[i] != null)
					model.setBankAcctRmk(bankAcctRmk[i]);
				if (bankNm[i] != null)
					model.setBankNm(bankNm[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (bankShrtNm[i] != null)
					model.setBankShrtNm(bankShrtNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bankAcctCurrCd[i] != null)
					model.setBankAcctCurrCd(bankAcctCurrCd[i]);
				if (bankAcctNo[i] != null)
					model.setBankAcctNo(bankAcctNo[i]);
				if (bankAddr[i] != null)
					model.setBankAddr(bankAddr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getInvArBankListVOs();
	}

	public InvArBankListVO[] getInvArBankListVOs(){
		InvArBankListVO[] vos = (InvArBankListVO[])models.toArray(new InvArBankListVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @exception IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctRmk = this.bankAcctRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankNm = this.bankNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankShrtNm = this.bankShrtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctCurrCd = this.bankAcctCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNo = this.bankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAddr = this.bankAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
