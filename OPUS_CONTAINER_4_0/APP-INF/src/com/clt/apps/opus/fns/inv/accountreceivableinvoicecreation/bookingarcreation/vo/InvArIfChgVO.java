/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvArIfChgVO.java
*@FileTitle : InvArIfChgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.07 최도순 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvArIfChgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvArIfChgVO> models = new ArrayList<InvArIfChgVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String srcIfSeq = null;
	/* Column Info */
	private String repChgCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String perTpCd = null;
	/* Column Info */
	private String chgFullNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trfRtAmt = null;
	/* Column Info */
	private String srcIfDt = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String ratAsCntrQty = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String tvaFlg = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String chgRmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvArIfChgVO() {}

	public InvArIfChgVO(String ibflag, String pagerows, String srcIfDt, String srcIfSeq, String chgSeq, String chgCd, String currCd, String perTpCd, String trfRtAmt, String ratAsCntrQty, String chgAmt, String invXchRt, String chgFullNm, String trfNo, String tvaFlg, String repChgCd, String chgRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.srcIfSeq = srcIfSeq;
		this.repChgCd = repChgCd;
		this.currCd = currCd;
		this.perTpCd = perTpCd;
		this.chgFullNm = chgFullNm;
		this.creDt = creDt;
		this.trfRtAmt = trfRtAmt;
		this.srcIfDt = srcIfDt;
		this.chgSeq = chgSeq;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.trfNo = trfNo;
		this.chgAmt = chgAmt;
		this.ratAsCntrQty = ratAsCntrQty;
		this.updUsrId = updUsrId;
		this.tvaFlg = tvaFlg;
		this.invXchRt = invXchRt;
		this.chgRmk = chgRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("src_if_seq", getSrcIfSeq());
		this.hashColumns.put("rep_chg_cd", getRepChgCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("per_tp_cd", getPerTpCd());
		this.hashColumns.put("chg_full_nm", getChgFullNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trf_rt_amt", getTrfRtAmt());
		this.hashColumns.put("src_if_dt", getSrcIfDt());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("rat_as_cntr_qty", getRatAsCntrQty());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("tva_flg", getTvaFlg());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("chg_rmk", getChgRmk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("src_if_seq", "srcIfSeq");
		this.hashFields.put("rep_chg_cd", "repChgCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("per_tp_cd", "perTpCd");
		this.hashFields.put("chg_full_nm", "chgFullNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trf_rt_amt", "trfRtAmt");
		this.hashFields.put("src_if_dt", "srcIfDt");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("rat_as_cntr_qty", "ratAsCntrQty");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("tva_flg", "tvaFlg");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("chg_rmk", "chgRmk");
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
	 * @return srcIfSeq
	 */
	public String getSrcIfSeq() {
		return this.srcIfSeq;
	}
	
	/**
	 * Column Info
	 * @return repChgCd
	 */
	public String getRepChgCd() {
		return this.repChgCd;
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
	 * @return perTpCd
	 */
	public String getPerTpCd() {
		return this.perTpCd;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return trfRtAmt
	 */
	public String getTrfRtAmt() {
		return this.trfRtAmt;
	}
	
	/**
	 * Column Info
	 * @return srcIfDt
	 */
	public String getSrcIfDt() {
		return this.srcIfDt;
	}
	
	/**
	 * Column Info
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
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
	 * @return ratAsCntrQty
	 */
	public String getRatAsCntrQty() {
		return this.ratAsCntrQty;
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
	 * @return tvaFlg
	 */
	public String getTvaFlg() {
		return this.tvaFlg;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	
	/**
	 * Column Info
	 * @return chgRmk
	 */
	public String getChgRmk() {
		return this.chgRmk;
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
	 * @param srcIfSeq
	 */
	public void setSrcIfSeq(String srcIfSeq) {
		this.srcIfSeq = srcIfSeq;
	}
	
	/**
	 * Column Info
	 * @param repChgCd
	 */
	public void setRepChgCd(String repChgCd) {
		this.repChgCd = repChgCd;
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
	 * @param perTpCd
	 */
	public void setPerTpCd(String perTpCd) {
		this.perTpCd = perTpCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param trfRtAmt
	 */
	public void setTrfRtAmt(String trfRtAmt) {
		this.trfRtAmt = trfRtAmt;
	}
	
	/**
	 * Column Info
	 * @param srcIfDt
	 */
	public void setSrcIfDt(String srcIfDt) {
		this.srcIfDt = srcIfDt;
	}
	
	/**
	 * Column Info
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
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
	 * @param ratAsCntrQty
	 */
	public void setRatAsCntrQty(String ratAsCntrQty) {
		this.ratAsCntrQty = ratAsCntrQty;
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
	 * @param tvaFlg
	 */
	public void setTvaFlg(String tvaFlg) {
		this.tvaFlg = tvaFlg;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
	/**
	 * Column Info
	 * @param chgRmk
	 */
	public void setChgRmk(String chgRmk) {
		this.chgRmk = chgRmk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setSrcIfSeq(JSPUtil.getParameter(request, "src_if_seq", ""));
		setRepChgCd(JSPUtil.getParameter(request, "rep_chg_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setPerTpCd(JSPUtil.getParameter(request, "per_tp_cd", ""));
		setChgFullNm(JSPUtil.getParameter(request, "chg_full_nm", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setTrfRtAmt(JSPUtil.getParameter(request, "trf_rt_amt", ""));
		setSrcIfDt(JSPUtil.getParameter(request, "src_if_dt", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTrfNo(JSPUtil.getParameter(request, "trf_no", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
		setRatAsCntrQty(JSPUtil.getParameter(request, "rat_as_cntr_qty", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setTvaFlg(JSPUtil.getParameter(request, "tva_flg", ""));
		setInvXchRt(JSPUtil.getParameter(request, "inv_xch_rt", ""));
		setChgRmk(JSPUtil.getParameter(request, "chg_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvArIfChgVO[]
	 */
	public InvArIfChgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvArIfChgVO[]
	 */
	public InvArIfChgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvArIfChgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] srcIfSeq = (JSPUtil.getParameter(request, prefix	+ "src_if_seq", length));
			String[] repChgCd = (JSPUtil.getParameter(request, prefix	+ "rep_chg_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] perTpCd = (JSPUtil.getParameter(request, prefix	+ "per_tp_cd", length));
			String[] chgFullNm = (JSPUtil.getParameter(request, prefix	+ "chg_full_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trfRtAmt = (JSPUtil.getParameter(request, prefix	+ "trf_rt_amt", length));
			String[] srcIfDt = (JSPUtil.getParameter(request, prefix	+ "src_if_dt", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] ratAsCntrQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_cntr_qty", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] tvaFlg = (JSPUtil.getParameter(request, prefix	+ "tva_flg", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] chgRmk = (JSPUtil.getParameter(request, prefix	+ "chg_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvArIfChgVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (srcIfSeq[i] != null)
					model.setSrcIfSeq(srcIfSeq[i]);
				if (repChgCd[i] != null)
					model.setRepChgCd(repChgCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (perTpCd[i] != null)
					model.setPerTpCd(perTpCd[i]);
				if (chgFullNm[i] != null)
					model.setChgFullNm(chgFullNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trfRtAmt[i] != null)
					model.setTrfRtAmt(trfRtAmt[i]);
				if (srcIfDt[i] != null)
					model.setSrcIfDt(srcIfDt[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (ratAsCntrQty[i] != null)
					model.setRatAsCntrQty(ratAsCntrQty[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (tvaFlg[i] != null)
					model.setTvaFlg(tvaFlg[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (chgRmk[i] != null)
					model.setChgRmk(chgRmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvArIfChgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvArIfChgVO[]
	 */
	public InvArIfChgVO[] getInvArIfChgVOs(){
		InvArIfChgVO[] vos = (InvArIfChgVO[])models.toArray(new InvArIfChgVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcIfSeq = this.srcIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repChgCd = this.repChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perTpCd = this.perTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgFullNm = this.chgFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRtAmt = this.trfRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcIfDt = this.srcIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsCntrQty = this.ratAsCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvaFlg = this.tvaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRmk = this.chgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
