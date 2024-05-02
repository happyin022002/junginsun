/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TpbInvIfDtlVO.java
*@FileTitle : TpbInvIfDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.12  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TpbInvIfDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TpbInvIfDtlVO> models = new ArrayList<TpbInvIfDtlVO>();
	
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String invIfNo = null;
	/* Column Info */
	private String invIfOfcCd = null;
	/* Column Info */
	private String addAmt = null;
	/* Column Info */
	private String chgFullNm = null;
	/* Column Info */
	private String invIfDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String chgSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chgCurrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String revAcctCd = null;
	/* Column Info */
	private String n3ptyInvChgTpCd = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String invIfFlg = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TpbInvIfDtlVO() {}

	public TpbInvIfDtlVO(String ibflag, String pagerows, String userOfcCd, String updDt, String invIfNo, String invIfOfcCd, String addAmt, String chgFullNm, String invIfDt, String creDt, String chgSeq, String chgCurrCd, String creUsrId, String n3ptyInvChgTpCd, String revAcctCd, String arIfNo, String userId, String invIfFlg, String acctCd, String chgAmt, String updUsrId, String trfNo) {
		this.userOfcCd = userOfcCd;
		this.updDt = updDt;
		this.invIfNo = invIfNo;
		this.invIfOfcCd = invIfOfcCd;
		this.addAmt = addAmt;
		this.chgFullNm = chgFullNm;
		this.invIfDt = invIfDt;
		this.creDt = creDt;
		this.chgSeq = chgSeq;
		this.pagerows = pagerows;
		this.chgCurrCd = chgCurrCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.revAcctCd = revAcctCd;
		this.n3ptyInvChgTpCd = n3ptyInvChgTpCd;
		this.trfNo = trfNo;
		this.arIfNo = arIfNo;
		this.chgAmt = chgAmt;
		this.acctCd = acctCd;
		this.invIfFlg = invIfFlg;
		this.userId = userId;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("inv_if_no", getInvIfNo());
		this.hashColumns.put("inv_if_ofc_cd", getInvIfOfcCd());
		this.hashColumns.put("add_amt", getAddAmt());
		this.hashColumns.put("chg_full_nm", getChgFullNm());
		this.hashColumns.put("inv_if_dt", getInvIfDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chg_curr_cd", getChgCurrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rev_acct_cd", getRevAcctCd());
		this.hashColumns.put("n3pty_inv_chg_tp_cd", getN3ptyInvChgTpCd());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("inv_if_flg", getInvIfFlg());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("inv_if_no", "invIfNo");
		this.hashFields.put("inv_if_ofc_cd", "invIfOfcCd");
		this.hashFields.put("add_amt", "addAmt");
		this.hashFields.put("chg_full_nm", "chgFullNm");
		this.hashFields.put("inv_if_dt", "invIfDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chg_curr_cd", "chgCurrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rev_acct_cd", "revAcctCd");
		this.hashFields.put("n3pty_inv_chg_tp_cd", "n3ptyInvChgTpCd");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("inv_if_flg", "invIfFlg");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return this.userOfcCd;
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
	 * @return invIfNo
	 */
	public String getInvIfNo() {
		return this.invIfNo;
	}
	
	/**
	 * Column Info
	 * @return invIfOfcCd
	 */
	public String getInvIfOfcCd() {
		return this.invIfOfcCd;
	}
	
	/**
	 * Column Info
	 * @return addAmt
	 */
	public String getAddAmt() {
		return this.addAmt;
	}
	
	/**
	 * Column Info
	 * @return chgFullNm
	 */
	public String getChgFullNm() {
		return this.chgFullNm;
	}
	
	/**
	 * Column Info
	 * @return invIfDt
	 */
	public String getInvIfDt() {
		return this.invIfDt;
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
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
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
	 * @return chgCurrCd
	 */
	public String getChgCurrCd() {
		return this.chgCurrCd;
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
	 * @return revAcctCd
	 */
	public String getRevAcctCd() {
		return this.revAcctCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyInvChgTpCd
	 */
	public String getN3ptyInvChgTpCd() {
		return this.n3ptyInvChgTpCd;
	}
	
	/**
	 * Column Info
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
	}
	
	/**
	 * Column Info
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
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
	 * @return invIfFlg
	 */
	public String getInvIfFlg() {
		return this.invIfFlg;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
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
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
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
	 * @param invIfNo
	 */
	public void setInvIfNo(String invIfNo) {
		this.invIfNo = invIfNo;
	}
	
	/**
	 * Column Info
	 * @param invIfOfcCd
	 */
	public void setInvIfOfcCd(String invIfOfcCd) {
		this.invIfOfcCd = invIfOfcCd;
	}
	
	/**
	 * Column Info
	 * @param addAmt
	 */
	public void setAddAmt(String addAmt) {
		this.addAmt = addAmt;
	}
	
	/**
	 * Column Info
	 * @param chgFullNm
	 */
	public void setChgFullNm(String chgFullNm) {
		this.chgFullNm = chgFullNm;
	}
	
	/**
	 * Column Info
	 * @param invIfDt
	 */
	public void setInvIfDt(String invIfDt) {
		this.invIfDt = invIfDt;
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
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
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
	 * @param chgCurrCd
	 */
	public void setChgCurrCd(String chgCurrCd) {
		this.chgCurrCd = chgCurrCd;
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
	 * @param revAcctCd
	 */
	public void setRevAcctCd(String revAcctCd) {
		this.revAcctCd = revAcctCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyInvChgTpCd
	 */
	public void setN3ptyInvChgTpCd(String n3ptyInvChgTpCd) {
		this.n3ptyInvChgTpCd = n3ptyInvChgTpCd;
	}
	
	/**
	 * Column Info
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
	}
	
	/**
	 * Column Info
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
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
	 * @param invIfFlg
	 */
	public void setInvIfFlg(String invIfFlg) {
		this.invIfFlg = invIfFlg;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
		setUserOfcCd(JSPUtil.getParameter(request, prefix + "user_ofc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setInvIfNo(JSPUtil.getParameter(request, prefix + "inv_if_no", ""));
		setInvIfOfcCd(JSPUtil.getParameter(request, prefix + "inv_if_ofc_cd", ""));
		setAddAmt(JSPUtil.getParameter(request, prefix + "add_amt", ""));
		setChgFullNm(JSPUtil.getParameter(request, prefix + "chg_full_nm", ""));
		setInvIfDt(JSPUtil.getParameter(request, prefix + "inv_if_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setChgSeq(JSPUtil.getParameter(request, prefix + "chg_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setChgCurrCd(JSPUtil.getParameter(request, prefix + "chg_curr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setRevAcctCd(JSPUtil.getParameter(request, prefix + "rev_acct_cd", ""));
		setN3ptyInvChgTpCd(JSPUtil.getParameter(request, prefix + "n3pty_inv_chg_tp_cd", ""));
		setTrfNo(JSPUtil.getParameter(request, prefix + "trf_no", ""));
		setArIfNo(JSPUtil.getParameter(request, prefix + "ar_if_no", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setInvIfFlg(JSPUtil.getParameter(request, prefix + "inv_if_flg", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TpbInvIfDtlVO[]
	 */
	public TpbInvIfDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TpbInvIfDtlVO[]
	 */
	public TpbInvIfDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TpbInvIfDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] invIfNo = (JSPUtil.getParameter(request, prefix	+ "inv_if_no", length));
			String[] invIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_if_ofc_cd", length));
			String[] addAmt = (JSPUtil.getParameter(request, prefix	+ "add_amt", length));
			String[] chgFullNm = (JSPUtil.getParameter(request, prefix	+ "chg_full_nm", length));
			String[] invIfDt = (JSPUtil.getParameter(request, prefix	+ "inv_if_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chgCurrCd = (JSPUtil.getParameter(request, prefix	+ "chg_curr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] revAcctCd = (JSPUtil.getParameter(request, prefix	+ "rev_acct_cd", length));
			String[] n3ptyInvChgTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_chg_tp_cd", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] invIfFlg = (JSPUtil.getParameter(request, prefix	+ "inv_if_flg", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new TpbInvIfDtlVO();
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (invIfNo[i] != null)
					model.setInvIfNo(invIfNo[i]);
				if (invIfOfcCd[i] != null)
					model.setInvIfOfcCd(invIfOfcCd[i]);
				if (addAmt[i] != null)
					model.setAddAmt(addAmt[i]);
				if (chgFullNm[i] != null)
					model.setChgFullNm(chgFullNm[i]);
				if (invIfDt[i] != null)
					model.setInvIfDt(invIfDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chgCurrCd[i] != null)
					model.setChgCurrCd(chgCurrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (revAcctCd[i] != null)
					model.setRevAcctCd(revAcctCd[i]);
				if (n3ptyInvChgTpCd[i] != null)
					model.setN3ptyInvChgTpCd(n3ptyInvChgTpCd[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (invIfFlg[i] != null)
					model.setInvIfFlg(invIfFlg[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTpbInvIfDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TpbInvIfDtlVO[]
	 */
	public TpbInvIfDtlVO[] getTpbInvIfDtlVOs(){
		TpbInvIfDtlVO[] vos = (TpbInvIfDtlVO[])models.toArray(new TpbInvIfDtlVO[models.size()]);
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
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfNo = this.invIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfOfcCd = this.invIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addAmt = this.addAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgFullNm = this.chgFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfDt = this.invIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCurrCd = this.chgCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAcctCd = this.revAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvChgTpCd = this.n3ptyInvChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfFlg = this.invIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
