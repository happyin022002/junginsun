/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomMnrPlnHdrVO.java
*@FileTitle : CustomMnrPlnHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.08.24 김완규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrPlnHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrPlnHdrVO> models = new ArrayList<CustomMnrPlnHdrVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String mnrGrpTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mnrPlnOfcCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String mnrPlnFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String mnrPlnYr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String mnrPlnSeq = null;
	/* Column Info */
	private String eqQty = null;
	/* Column Info */
	private String mnrPlnGrpNo = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String mnrPlnAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mnrPlnRmk = null;
	/* Column Info */
	private String ofcTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrPlnHdrVO() {}

	public CustomMnrPlnHdrVO(String ibflag, String pagerows, String mnrPlnYr, String creUsrId, String mnrPlnSeq, String acctCd, String mnrPlnAmt, String creDt, String mnrPlnOfcCd, String ctrlOfcCd, String mnrPlnFlg, String eqTpszCd, String eqQty, String eqKndCd, String mnrGrpTpCd, String mnrPlnGrpNo, String mnrPlnRmk, String updUsrId, String updDt, String currCd, String ofcTpCd) {
		this.updDt = updDt;
		this.currCd = currCd;
		this.mnrGrpTpCd = mnrGrpTpCd;
		this.creDt = creDt;
		this.mnrPlnOfcCd = mnrPlnOfcCd;
		this.eqKndCd = eqKndCd;
		this.ctrlOfcCd = ctrlOfcCd;
		this.mnrPlnFlg = mnrPlnFlg;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.mnrPlnYr = mnrPlnYr;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.mnrPlnSeq = mnrPlnSeq;
		this.eqQty = eqQty;
		this.mnrPlnGrpNo = mnrPlnGrpNo;
		this.acctCd = acctCd;
		this.mnrPlnAmt = mnrPlnAmt;
		this.updUsrId = updUsrId;
		this.mnrPlnRmk = mnrPlnRmk;
		this.ofcTpCd = ofcTpCd;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("mnr_grp_tp_cd", getMnrGrpTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mnr_pln_ofc_cd", getMnrPlnOfcCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("mnr_pln_flg", getMnrPlnFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("mnr_pln_yr", getMnrPlnYr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mnr_pln_seq", getMnrPlnSeq());
		this.hashColumns.put("eq_qty", getEqQty());
		this.hashColumns.put("mnr_pln_grp_no", getMnrPlnGrpNo());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("mnr_pln_amt", getMnrPlnAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mnr_pln_rmk", getMnrPlnRmk());
		this.hashColumns.put("ofc_tp_cd", getOfcTpCd());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("mnr_grp_tp_cd", "mnrGrpTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mnr_pln_ofc_cd", "mnrPlnOfcCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("mnr_pln_flg", "mnrPlnFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("mnr_pln_yr", "mnrPlnYr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mnr_pln_seq", "mnrPlnSeq");
		this.hashFields.put("eq_qty", "eqQty");
		this.hashFields.put("mnr_pln_grp_no", "mnrPlnGrpNo");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("mnr_pln_amt", "mnrPlnAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mnr_pln_rmk", "mnrPlnRmk");
		this.hashFields.put("ofc_tp_cd", "ofcTpCd");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return mnrGrpTpCd
	 */
	public String getMnrGrpTpCd() {
		return this.mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return mnrPlnOfcCd
	 */
	public String getMnrPlnOfcCd() {
		return this.mnrPlnOfcCd;
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
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mnrPlnFlg
	 */
	public String getMnrPlnFlg() {
		return this.mnrPlnFlg;
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
	 * @return mnrPlnYr
	 */
	public String getMnrPlnYr() {
		return this.mnrPlnYr;
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
	 * @return mnrPlnSeq
	 */
	public String getMnrPlnSeq() {
		return this.mnrPlnSeq;
	}
	
	/**
	 * Column Info
	 * @return eqQty
	 */
	public String getEqQty() {
		return this.eqQty;
	}
	
	/**
	 * Column Info
	 * @return mnrPlnGrpNo
	 */
	public String getMnrPlnGrpNo() {
		return this.mnrPlnGrpNo;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return mnrPlnAmt
	 */
	public String getMnrPlnAmt() {
		return this.mnrPlnAmt;
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
	 * @return mnrPlnRmk
	 */
	public String getMnrPlnRmk() {
		return this.mnrPlnRmk;
	}
	
	/**
	 * Column Info
	 * @return ofcTpCd
	 */
	public String getOfcTpCd() {
		return this.ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param mnrGrpTpCd
	 */
	public void setMnrGrpTpCd(String mnrGrpTpCd) {
		this.mnrGrpTpCd = mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param mnrPlnOfcCd
	 */
	public void setMnrPlnOfcCd(String mnrPlnOfcCd) {
		this.mnrPlnOfcCd = mnrPlnOfcCd;
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
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mnrPlnFlg
	 */
	public void setMnrPlnFlg(String mnrPlnFlg) {
		this.mnrPlnFlg = mnrPlnFlg;
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
	 * @param mnrPlnYr
	 */
	public void setMnrPlnYr(String mnrPlnYr) {
		this.mnrPlnYr = mnrPlnYr;
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
	 * @param mnrPlnSeq
	 */
	public void setMnrPlnSeq(String mnrPlnSeq) {
		this.mnrPlnSeq = mnrPlnSeq;
	}
	
	/**
	 * Column Info
	 * @param eqQty
	 */
	public void setEqQty(String eqQty) {
		this.eqQty = eqQty;
	}
	
	/**
	 * Column Info
	 * @param mnrPlnGrpNo
	 */
	public void setMnrPlnGrpNo(String mnrPlnGrpNo) {
		this.mnrPlnGrpNo = mnrPlnGrpNo;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param mnrPlnAmt
	 */
	public void setMnrPlnAmt(String mnrPlnAmt) {
		this.mnrPlnAmt = mnrPlnAmt;
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
	 * @param mnrPlnRmk
	 */
	public void setMnrPlnRmk(String mnrPlnRmk) {
		this.mnrPlnRmk = mnrPlnRmk;
	}
	
	/**
	 * Column Info
	 * @param ofcTpCd
	 */
	public void setOfcTpCd(String ofcTpCd) {
		this.ofcTpCd = ofcTpCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setMnrGrpTpCd(JSPUtil.getParameter(request, "mnr_grp_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setMnrPlnOfcCd(JSPUtil.getParameter(request, "mnr_pln_ofc_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		setMnrPlnFlg(JSPUtil.getParameter(request, "mnr_pln_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setMnrPlnYr(JSPUtil.getParameter(request, "mnr_pln_yr", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setMnrPlnSeq(JSPUtil.getParameter(request, "mnr_pln_seq", ""));
		setEqQty(JSPUtil.getParameter(request, "eq_qty", ""));
		setMnrPlnGrpNo(JSPUtil.getParameter(request, "mnr_pln_grp_no", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setMnrPlnAmt(JSPUtil.getParameter(request, "mnr_pln_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setMnrPlnRmk(JSPUtil.getParameter(request, "mnr_pln_rmk", ""));
		setOfcTpCd(JSPUtil.getParameter(request, "ofc_tp_cd", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrPlnHdrVO[]
	 */
	public CustomMnrPlnHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrPlnHdrVO[]
	 */
	public CustomMnrPlnHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrPlnHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] mnrGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_grp_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mnrPlnOfcCd = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_ofc_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] mnrPlnFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] mnrPlnYr = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_yr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] mnrPlnSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_seq", length));
			String[] eqQty = (JSPUtil.getParameter(request, prefix	+ "eq_qty", length));
			String[] mnrPlnGrpNo = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_grp_no", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] mnrPlnAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mnrPlnRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_rmk", length));
			String[] ofcTpCd = (JSPUtil.getParameter(request, prefix	+ "ofc_tp_cd", length));

			for (int i = 0; i < length; i++) {
				model = new CustomMnrPlnHdrVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (mnrGrpTpCd[i] != null)
					model.setMnrGrpTpCd(mnrGrpTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mnrPlnOfcCd[i] != null)
					model.setMnrPlnOfcCd(mnrPlnOfcCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (mnrPlnFlg[i] != null)
					model.setMnrPlnFlg(mnrPlnFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (mnrPlnYr[i] != null)
					model.setMnrPlnYr(mnrPlnYr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (mnrPlnSeq[i] != null)
					model.setMnrPlnSeq(mnrPlnSeq[i]);
				if (eqQty[i] != null)
					model.setEqQty(eqQty[i]);
				if (mnrPlnGrpNo[i] != null)
					model.setMnrPlnGrpNo(mnrPlnGrpNo[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (mnrPlnAmt[i] != null)
					model.setMnrPlnAmt(mnrPlnAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mnrPlnRmk[i] != null)
					model.setMnrPlnRmk(mnrPlnRmk[i]);
				if (ofcTpCd[i] != null)
					model.setOfcTpCd(ofcTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrPlnHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrPlnHdrVO[]
	 */
	public CustomMnrPlnHdrVO[] getCustomMnrPlnHdrVOs(){
		CustomMnrPlnHdrVO[] vos = (CustomMnrPlnHdrVO[])models.toArray(new CustomMnrPlnHdrVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrGrpTpCd = this.mnrGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnOfcCd = this.mnrPlnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnFlg = this.mnrPlnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnYr = this.mnrPlnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnSeq = this.mnrPlnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqQty = this.eqQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnGrpNo = this.mnrPlnGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnAmt = this.mnrPlnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnRmk = this.mnrPlnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTpCd = this.ofcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
