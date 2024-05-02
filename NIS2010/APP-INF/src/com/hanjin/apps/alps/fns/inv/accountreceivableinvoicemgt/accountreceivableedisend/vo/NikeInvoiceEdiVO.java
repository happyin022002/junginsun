/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : NikeInvoiceEdiVO.java
*@FileTitle : NikeInvoiceEdiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.09
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.02.09 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

import java.lang.reflect.Field;
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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class NikeInvoiceEdiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NikeInvoiceEdiVO> models = new ArrayList<NikeInvoiceEdiVO>();
	
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String ttlTrfRtAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String nikeFrtModId = null;
	/* Column Info */
	private String mergeChk = null;
	/* Column Info */
	private String trfRtAmt = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String invSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String issDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ackRsltCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String nikeCrrId = null;
	/* Column Info */
	private String ediSndFlg = null;
	/* Column Info */
	private String nikeChgTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public NikeInvoiceEdiVO() {}

	public NikeInvoiceEdiVO(String ibflag, String pagerows, String issDt, String cntrNo, String blSrcNo, String invNo, String invSeq, String currCd, String ttlTrfRtAmt, String nikeChgTpCd, String trfRtAmt, String nikeFrtModId, String nikeCrrId, String ediSndFlg, String chgSeq, String mergeChk, String ackRsltCd) {
		this.blSrcNo = blSrcNo;
		this.ttlTrfRtAmt = ttlTrfRtAmt;
		this.currCd = currCd;
		this.nikeFrtModId = nikeFrtModId;
		this.mergeChk = mergeChk;
		this.trfRtAmt = trfRtAmt;
		this.chgSeq = chgSeq;
		this.invSeq = invSeq;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.issDt = issDt;
		this.ibflag = ibflag;
		this.ackRsltCd = ackRsltCd;
		this.cntrNo = cntrNo;
		this.nikeCrrId = nikeCrrId;
		this.ediSndFlg = ediSndFlg;
		this.nikeChgTpCd = nikeChgTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("ttl_trf_rt_amt", getTtlTrfRtAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("nike_frt_mod_id", getNikeFrtModId());
		this.hashColumns.put("merge_chk", getMergeChk());
		this.hashColumns.put("trf_rt_amt", getTrfRtAmt());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ack_rslt_cd", getAckRsltCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("nike_crr_id", getNikeCrrId());
		this.hashColumns.put("edi_snd_flg", getEdiSndFlg());
		this.hashColumns.put("nike_chg_tp_cd", getNikeChgTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("ttl_trf_rt_amt", "ttlTrfRtAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("nike_frt_mod_id", "nikeFrtModId");
		this.hashFields.put("merge_chk", "mergeChk");
		this.hashFields.put("trf_rt_amt", "trfRtAmt");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ack_rslt_cd", "ackRsltCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("nike_crr_id", "nikeCrrId");
		this.hashFields.put("edi_snd_flg", "ediSndFlg");
		this.hashFields.put("nike_chg_tp_cd", "nikeChgTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return ttlTrfRtAmt
	 */
	public String getTtlTrfRtAmt() {
		return this.ttlTrfRtAmt;
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
	 * @return nikeFrtModId
	 */
	public String getNikeFrtModId() {
		return this.nikeFrtModId;
	}
	
	/**
	 * Column Info
	 * @return mergeChk
	 */
	public String getMergeChk() {
		return this.mergeChk;
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
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
	}
	
	/**
	 * Column Info
	 * @return invSeq
	 */
	public String getInvSeq() {
		return this.invSeq;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
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
	 * @return ackRsltCd
	 */
	public String getAckRsltCd() {
		return this.ackRsltCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return nikeCrrId
	 */
	public String getNikeCrrId() {
		return this.nikeCrrId;
	}
	
	/**
	 * Column Info
	 * @return ediSndFlg
	 */
	public String getEdiSndFlg() {
		return this.ediSndFlg;
	}
	
	/**
	 * Column Info
	 * @return nikeChgTpCd
	 */
	public String getNikeChgTpCd() {
		return this.nikeChgTpCd;
	}
	

	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param ttlTrfRtAmt
	 */
	public void setTtlTrfRtAmt(String ttlTrfRtAmt) {
		this.ttlTrfRtAmt = ttlTrfRtAmt;
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
	 * @param nikeFrtModId
	 */
	public void setNikeFrtModId(String nikeFrtModId) {
		this.nikeFrtModId = nikeFrtModId;
	}
	
	/**
	 * Column Info
	 * @param mergeChk
	 */
	public void setMergeChk(String mergeChk) {
		this.mergeChk = mergeChk;
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
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Column Info
	 * @param invSeq
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
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
	 * @param ackRsltCd
	 */
	public void setAckRsltCd(String ackRsltCd) {
		this.ackRsltCd = ackRsltCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param nikeCrrId
	 */
	public void setNikeCrrId(String nikeCrrId) {
		this.nikeCrrId = nikeCrrId;
	}
	
	/**
	 * Column Info
	 * @param ediSndFlg
	 */
	public void setEdiSndFlg(String ediSndFlg) {
		this.ediSndFlg = ediSndFlg;
	}
	
	/**
	 * Column Info
	 * @param nikeChgTpCd
	 */
	public void setNikeChgTpCd(String nikeChgTpCd) {
		this.nikeChgTpCd = nikeChgTpCd;
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
		setBlSrcNo(JSPUtil.getParameter(request, prefix + "bl_src_no", ""));
		setTtlTrfRtAmt(JSPUtil.getParameter(request, prefix + "ttl_trf_rt_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setNikeFrtModId(JSPUtil.getParameter(request, prefix + "nike_frt_mod_id", ""));
		setMergeChk(JSPUtil.getParameter(request, prefix + "merge_chk", ""));
		setTrfRtAmt(JSPUtil.getParameter(request, prefix + "trf_rt_amt", ""));
		setChgSeq(JSPUtil.getParameter(request, prefix + "chg_seq", ""));
		setInvSeq(JSPUtil.getParameter(request, prefix + "inv_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAckRsltCd(JSPUtil.getParameter(request, prefix + "ack_rslt_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setNikeCrrId(JSPUtil.getParameter(request, prefix + "nike_crr_id", ""));
		setEdiSndFlg(JSPUtil.getParameter(request, prefix + "edi_snd_flg", ""));
		setNikeChgTpCd(JSPUtil.getParameter(request, prefix + "nike_chg_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NikeInvoiceEdiVO[]
	 */
	public NikeInvoiceEdiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NikeInvoiceEdiVO[]
	 */
	public NikeInvoiceEdiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NikeInvoiceEdiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] ttlTrfRtAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_trf_rt_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] nikeFrtModId = (JSPUtil.getParameter(request, prefix	+ "nike_frt_mod_id", length));
			String[] mergeChk = (JSPUtil.getParameter(request, prefix	+ "merge_chk", length));
			String[] trfRtAmt = (JSPUtil.getParameter(request, prefix	+ "trf_rt_amt", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ackRsltCd = (JSPUtil.getParameter(request, prefix	+ "ack_rslt_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] nikeCrrId = (JSPUtil.getParameter(request, prefix	+ "nike_crr_id", length));
			String[] ediSndFlg = (JSPUtil.getParameter(request, prefix	+ "edi_snd_flg", length));
			String[] nikeChgTpCd = (JSPUtil.getParameter(request, prefix	+ "nike_chg_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new NikeInvoiceEdiVO();
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (ttlTrfRtAmt[i] != null)
					model.setTtlTrfRtAmt(ttlTrfRtAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (nikeFrtModId[i] != null)
					model.setNikeFrtModId(nikeFrtModId[i]);
				if (mergeChk[i] != null)
					model.setMergeChk(mergeChk[i]);
				if (trfRtAmt[i] != null)
					model.setTrfRtAmt(trfRtAmt[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ackRsltCd[i] != null)
					model.setAckRsltCd(ackRsltCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (nikeCrrId[i] != null)
					model.setNikeCrrId(nikeCrrId[i]);
				if (ediSndFlg[i] != null)
					model.setEdiSndFlg(ediSndFlg[i]);
				if (nikeChgTpCd[i] != null)
					model.setNikeChgTpCd(nikeChgTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNikeInvoiceEdiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NikeInvoiceEdiVO[]
	 */
	public NikeInvoiceEdiVO[] getNikeInvoiceEdiVOs(){
		NikeInvoiceEdiVO[] vos = (NikeInvoiceEdiVO[])models.toArray(new NikeInvoiceEdiVO[models.size()]);
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
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTrfRtAmt = this.ttlTrfRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nikeFrtModId = this.nikeFrtModId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mergeChk = this.mergeChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRtAmt = this.trfRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRsltCd = this.ackRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nikeCrrId = this.nikeCrrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndFlg = this.ediSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nikeChgTpCd = this.nikeChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
