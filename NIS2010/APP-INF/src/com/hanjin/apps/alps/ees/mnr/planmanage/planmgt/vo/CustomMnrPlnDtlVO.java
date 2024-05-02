/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomMnrPlnDtlVO.java
*@FileTitle : CustomMnrPlnDtlVO
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

public class CustomMnrPlnDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrPlnDtlVO> models = new ArrayList<CustomMnrPlnDtlVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mnrPlnDtlSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mnrPlnOfcCd = null;
	/* Column Info */
	private String ctrlOfcCd = null;
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
	private String mnrPlnAmt = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String mnrPlnDtlRmk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ofcTpCd = null;
	/* Column Info */
	private String mnrPlnOfcHdrCd = null;
	/* Column Info */
	private String ofcTpHdrCd = null;
	/* Column Info */
	private String mnrPlnHdrSeq = null;
	/* Column Info */
	private String delall = null;
	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrPlnDtlVO() {}

	public CustomMnrPlnDtlVO(String ibflag, String pagerows, String mnrPlnYr, String creUsrId, String mnrPlnDtlSeq, String mnrPlnSeq, String mnrPlnAmt, String acctCd, String creDt, String mnrPlnOfcCd, String ctrlOfcCd, String eqTpszCd, String eqQty, String updUsrId, String updDt, String mnrPlnDtlRmk, String ofcTpCd, String mnrPlnOfcHdrCd, String ofcTpHdrCd, String mnrPlnHdrSeq, String delall) {
		this.updDt = updDt;
		this.mnrPlnDtlSeq = mnrPlnDtlSeq;
		this.creDt = creDt;
		this.mnrPlnOfcCd = mnrPlnOfcCd;
		this.ctrlOfcCd = ctrlOfcCd;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.mnrPlnYr = mnrPlnYr;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.mnrPlnSeq = mnrPlnSeq;
		this.eqQty = eqQty;
		this.mnrPlnAmt = mnrPlnAmt;
		this.acctCd = acctCd;
		this.mnrPlnDtlRmk = mnrPlnDtlRmk;
		this.updUsrId = updUsrId;
		this.ofcTpCd = ofcTpCd;
		this.mnrPlnOfcHdrCd = mnrPlnOfcHdrCd;
		this.ofcTpHdrCd = ofcTpHdrCd;
		this.mnrPlnHdrSeq = mnrPlnHdrSeq;
		this.delall = delall;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mnr_pln_dtl_seq", getMnrPlnDtlSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mnr_pln_ofc_cd", getMnrPlnOfcCd());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("mnr_pln_yr", getMnrPlnYr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mnr_pln_seq", getMnrPlnSeq());
		this.hashColumns.put("eq_qty", getEqQty());
		this.hashColumns.put("mnr_pln_amt", getMnrPlnAmt());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("mnr_pln_dtl_rmk", getMnrPlnDtlRmk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ofc_tp_cd", getOfcTpCd());
		this.hashColumns.put("mnr_pln_ofc_hdr_cd", getMnrPlnOfcHdrCd());
		this.hashColumns.put("ofc_tp_hdr_cd", getOfcTpHdrCd());
		this.hashColumns.put("mnr_pln_hdr_seq", getMnrPlnHdrSeq());
		this.hashColumns.put("delall", getDelall());




		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mnr_pln_dtl_seq", "mnrPlnDtlSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mnr_pln_ofc_cd", "mnrPlnOfcCd");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("mnr_pln_yr", "mnrPlnYr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mnr_pln_seq", "mnrPlnSeq");
		this.hashFields.put("eq_qty", "eqQty");
		this.hashFields.put("mnr_pln_amt", "mnrPlnAmt");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("mnr_pln_dtl_rmk", "mnrPlnDtlRmk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ofc_tp_cd", "ofcTpCd");
		this.hashFields.put("mnr_pln_ofc_hdr_cd", "mnrPlnOfcHdrCd");
		this.hashFields.put("ofc_tp_hdr_cd", "ofcTpHdrCd");
		this.hashFields.put("mnr_pln_hdr_seq", "mnrPlnHdrSeq");
		this.hashFields.put("delall", "delall");


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
	 * @return mnrPlnDtlSeq
	 */
	public String getMnrPlnDtlSeq() {
		return this.mnrPlnDtlSeq;
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
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
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
	 * @return mnrPlnAmt
	 */
	public String getMnrPlnAmt() {
		return this.mnrPlnAmt;
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
	 * @return mnrPlnDtlRmk
	 */
	public String getMnrPlnDtlRmk() {
		return this.mnrPlnDtlRmk;
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
	 * @return ofcTpCd
	 */
	public String getOfcTpCd() {
		return this.ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @return mnrPlnOfcHdrCd
	 */
	public String getMnrPlnOfcHdrCd() {
		return this.mnrPlnOfcHdrCd;
	}
	
	/**
	 * Column Info
	 * @return ofcTpHdrCd
	 */
	public String getOfcTpHdrCd() {
		return this.ofcTpHdrCd;
	}
	
	/**
	 * Column Info
	 * @return mnrPlnHdrSeq
	 */
	public String getMnrPlnHdrSeq() {
		return this.mnrPlnHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return delall
	 */
	public String getDelall() {
		return this.delall;
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
	 * @param mnrPlnDtlSeq
	 */
	public void setMnrPlnDtlSeq(String mnrPlnDtlSeq) {
		this.mnrPlnDtlSeq = mnrPlnDtlSeq;
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
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
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
	 * @param mnrPlnAmt
	 */
	public void setMnrPlnAmt(String mnrPlnAmt) {
		this.mnrPlnAmt = mnrPlnAmt;
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
	 * @param mnrPlnDtlRmk
	 */
	public void setMnrPlnDtlRmk(String mnrPlnDtlRmk) {
		this.mnrPlnDtlRmk = mnrPlnDtlRmk;
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
	 * @param ofcTpCd
	 */
	public void setOfcTpCd(String ofcTpCd) {
		this.ofcTpCd = ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @param mnrPlnOfcHdrCd
	 */
	public void setMnrPlnOfcHdrCd(String mnrPlnOfcHdrCd) {
		this.mnrPlnOfcHdrCd = mnrPlnOfcHdrCd;
	}
	
	/**
	 * Column Info
	 * @param ofcTpHdrCd
	 */
	public void setOfcTpHdrCd(String ofcTpHdrCd) {
		this.ofcTpHdrCd = ofcTpHdrCd;
	}
	
	/**
	 * Column Info
	 * @param mnrPlnHdrSeq
	 */
	public void setMnrPlnHdrSeq(String mnrPlnHdrSeq) {
		this.mnrPlnHdrSeq = mnrPlnHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param delall
	 */
	public void setDelall(String delall) {
		this.delall = delall;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setMnrPlnDtlSeq(JSPUtil.getParameter(request, "mnr_pln_dtl_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setMnrPlnOfcCd(JSPUtil.getParameter(request, "mnr_pln_ofc_cd", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setMnrPlnYr(JSPUtil.getParameter(request, "mnr_pln_yr", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setMnrPlnSeq(JSPUtil.getParameter(request, "mnr_pln_seq", ""));
		setEqQty(JSPUtil.getParameter(request, "eq_qty", ""));
		setMnrPlnAmt(JSPUtil.getParameter(request, "mnr_pln_amt", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setMnrPlnDtlRmk(JSPUtil.getParameter(request, "mnr_pln_dtl_rmk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setOfcTpCd(JSPUtil.getParameter(request, "ofc_tp_cd", ""));
		setMnrPlnOfcHdrCd(JSPUtil.getParameter(request, "mnr_pln_ofc_hdr_cd", ""));
		setOfcTpHdrCd(JSPUtil.getParameter(request, "ofc_tp_hdr_cd", ""));
		setMnrPlnHdrSeq(JSPUtil.getParameter(request, "mnr_pln_hdr_seq", ""));
		setDelall(JSPUtil.getParameter(request, "delall", ""));


	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrPlnDtlVO[]
	 */
	public CustomMnrPlnDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrPlnDtlVO[]
	 */
	public CustomMnrPlnDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrPlnDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] mnrPlnDtlSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_dtl_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mnrPlnOfcCd = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_ofc_cd", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] mnrPlnYr = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_yr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] mnrPlnSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_seq", length));
			String[] eqQty = (JSPUtil.getParameter(request, prefix	+ "eq_qty", length));
			String[] mnrPlnAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_amt", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] mnrPlnDtlRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_dtl_rmk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ofcTpCd = (JSPUtil.getParameter(request, prefix	+ "ofc_tp_cd", length));
			String[] mnrPlnOfcHdrCd = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_ofc_hdr_cd", length));
			String[] ofcTpHdrCd = (JSPUtil.getParameter(request, prefix	+ "ofc_tp_hdr_cd", length));
			String[] mnrPlnHdrSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_hdr_seq", length));
			String[] delall = (JSPUtil.getParameter(request, prefix	+ "delall", length));


			for (int i = 0; i < length; i++) {
				model = new CustomMnrPlnDtlVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mnrPlnDtlSeq[i] != null)
					model.setMnrPlnDtlSeq(mnrPlnDtlSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mnrPlnOfcCd[i] != null)
					model.setMnrPlnOfcCd(mnrPlnOfcCd[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
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
				if (mnrPlnAmt[i] != null)
					model.setMnrPlnAmt(mnrPlnAmt[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (mnrPlnDtlRmk[i] != null)
					model.setMnrPlnDtlRmk(mnrPlnDtlRmk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ofcTpCd[i] != null)
					model.setOfcTpCd(ofcTpCd[i]);
				if (mnrPlnOfcHdrCd[i] != null)
					model.setMnrPlnOfcHdrCd(mnrPlnOfcHdrCd[i]);
				if (ofcTpHdrCd[i] != null)
					model.setOfcTpHdrCd(ofcTpHdrCd[i]);
				if (mnrPlnHdrSeq[i] != null)
					model.setMnrPlnHdrSeq(mnrPlnHdrSeq[i]);
				if (delall[i] != null)
					model.setDelall(delall[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrPlnDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrPlnDtlVO[]
	 */
	public CustomMnrPlnDtlVO[] getCustomMnrPlnDtlVOs(){
		CustomMnrPlnDtlVO[] vos = (CustomMnrPlnDtlVO[])models.toArray(new CustomMnrPlnDtlVO[models.size()]);
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
		this.mnrPlnDtlSeq = this.mnrPlnDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnOfcCd = this.mnrPlnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnYr = this.mnrPlnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnSeq = this.mnrPlnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqQty = this.eqQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnAmt = this.mnrPlnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnDtlRmk = this.mnrPlnDtlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTpCd = this.ofcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnOfcHdrCd = this.mnrPlnOfcHdrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTpHdrCd = this.ofcTpHdrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnHdrSeq = this.mnrPlnHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delall = this.delall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
