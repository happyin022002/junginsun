/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomHandlingCostVO.java
*@FileTitle : CustomHandlingCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.11.04 윤세영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.codemgt.codemgt.vo;

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

public class CustomHandlingCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomHandlingCostVO> models = new ArrayList<CustomHandlingCostVO>();
	
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String invUsdAmt = null;
	/* Column Info */
	private String seqNo = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String costSeq = null;
	/* Column Info */
	private String costDesc = null;
	/* Column Info */
	private String clmCostTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String clmPtyNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String clmPtyNm = null;
	/* Column Info */
	private String invRmk = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String dwClmNo = null;
	/* Column Info */
	private String invDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomHandlingCostVO() {}

	public CustomHandlingCostVO(String ibflag, String pagerows, String dwClmNo, String costSeq, String clmCostTpCd, String clmPtyNo, String clmPtyNm, String costDesc, String invDt, String payDt, String loclCurrCd, String invAmt, String invUsdAmt, String invXchRt, String invRmk, String seqNo, String creUsrId, String updUsrId) {
		this.payDt = payDt;
		this.invUsdAmt = invUsdAmt;
		this.seqNo = seqNo;
		this.loclCurrCd = loclCurrCd;
		this.costSeq = costSeq;
		this.costDesc = costDesc;
		this.clmCostTpCd = clmCostTpCd;
		this.pagerows = pagerows;
		this.clmPtyNo = clmPtyNo;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.clmPtyNm = clmPtyNm;
		this.invRmk = invRmk;
		this.invAmt = invAmt;
		this.updUsrId = updUsrId;
		this.invXchRt = invXchRt;
		this.dwClmNo = dwClmNo;
		this.invDt = invDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("inv_usd_amt", getInvUsdAmt());
		this.hashColumns.put("seq_no", getSeqNo());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("cost_seq", getCostSeq());
		this.hashColumns.put("cost_desc", getCostDesc());
		this.hashColumns.put("clm_cost_tp_cd", getClmCostTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("clm_pty_no", getClmPtyNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("clm_pty_nm", getClmPtyNm());
		this.hashColumns.put("inv_rmk", getInvRmk());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("dw_clm_no", getDwClmNo());
		this.hashColumns.put("inv_dt", getInvDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("inv_usd_amt", "invUsdAmt");
		this.hashFields.put("seq_no", "seqNo");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("cost_seq", "costSeq");
		this.hashFields.put("cost_desc", "costDesc");
		this.hashFields.put("clm_cost_tp_cd", "clmCostTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("clm_pty_no", "clmPtyNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("clm_pty_nm", "clmPtyNm");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("dw_clm_no", "dwClmNo");
		this.hashFields.put("inv_dt", "invDt");
		return this.hashFields;
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
	 * @return invUsdAmt
	 */
	public String getInvUsdAmt() {
		return this.invUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return seqNo
	 */
	public String getSeqNo() {
		return this.seqNo;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return costSeq
	 */
	public String getCostSeq() {
		return this.costSeq;
	}
	
	/**
	 * Column Info
	 * @return costDesc
	 */
	public String getCostDesc() {
		return this.costDesc;
	}
	
	/**
	 * Column Info
	 * @return clmCostTpCd
	 */
	public String getClmCostTpCd() {
		return this.clmCostTpCd;
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
	 * @return clmPtyNo
	 */
	public String getClmPtyNo() {
		return this.clmPtyNo;
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
	 * @return clmPtyNm
	 */
	public String getClmPtyNm() {
		return this.clmPtyNm;
	}
	
	/**
	 * Column Info
	 * @return invRmk
	 */
	public String getInvRmk() {
		return this.invRmk;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
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
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	
	/**
	 * Column Info
	 * @return dwClmNo
	 */
	public String getDwClmNo() {
		return this.dwClmNo;
	}
	
	/**
	 * Column Info
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
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
	 * @param invUsdAmt
	 */
	public void setInvUsdAmt(String invUsdAmt) {
		this.invUsdAmt = invUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param seqNo
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param costSeq
	 */
	public void setCostSeq(String costSeq) {
		this.costSeq = costSeq;
	}
	
	/**
	 * Column Info
	 * @param costDesc
	 */
	public void setCostDesc(String costDesc) {
		this.costDesc = costDesc;
	}
	
	/**
	 * Column Info
	 * @param clmCostTpCd
	 */
	public void setClmCostTpCd(String clmCostTpCd) {
		this.clmCostTpCd = clmCostTpCd;
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
	 * @param clmPtyNo
	 */
	public void setClmPtyNo(String clmPtyNo) {
		this.clmPtyNo = clmPtyNo;
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
	 * @param clmPtyNm
	 */
	public void setClmPtyNm(String clmPtyNm) {
		this.clmPtyNm = clmPtyNm;
	}
	
	/**
	 * Column Info
	 * @param invRmk
	 */
	public void setInvRmk(String invRmk) {
		this.invRmk = invRmk;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
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
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
	/**
	 * Column Info
	 * @param dwClmNo
	 */
	public void setDwClmNo(String dwClmNo) {
		this.dwClmNo = dwClmNo;
	}
	
	/**
	 * Column Info
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPayDt(JSPUtil.getParameter(request, "pay_dt", ""));
		setInvUsdAmt(JSPUtil.getParameter(request, "inv_usd_amt", ""));
		setSeqNo(JSPUtil.getParameter(request, "seq_no", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setCostSeq(JSPUtil.getParameter(request, "cost_seq", ""));
		setCostDesc(JSPUtil.getParameter(request, "cost_desc", ""));
		setClmCostTpCd(JSPUtil.getParameter(request, "clm_cost_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setClmPtyNo(JSPUtil.getParameter(request, "clm_pty_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setClmPtyNm(JSPUtil.getParameter(request, "clm_pty_nm", ""));
		setInvRmk(JSPUtil.getParameter(request, "inv_rmk", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setInvXchRt(JSPUtil.getParameter(request, "inv_xch_rt", ""));
		setDwClmNo(JSPUtil.getParameter(request, "dw_clm_no", ""));
		setInvDt(JSPUtil.getParameter(request, "inv_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomHandlingCostVO[]
	 */
	public CustomHandlingCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomHandlingCostVO[]
	 */
	public CustomHandlingCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomHandlingCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] invUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inv_usd_amt", length));
			String[] seqNo = (JSPUtil.getParameter(request, prefix	+ "seq_no", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] costSeq = (JSPUtil.getParameter(request, prefix	+ "cost_seq", length));
			String[] costDesc = (JSPUtil.getParameter(request, prefix	+ "cost_desc", length));
			String[] clmCostTpCd = (JSPUtil.getParameter(request, prefix	+ "clm_cost_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] clmPtyNo = (JSPUtil.getParameter(request, prefix	+ "clm_pty_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] clmPtyNm = (JSPUtil.getParameter(request, prefix	+ "clm_pty_nm", length));
			String[] invRmk = (JSPUtil.getParameter(request, prefix	+ "inv_rmk", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] dwClmNo = (JSPUtil.getParameter(request, prefix	+ "dw_clm_no", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomHandlingCostVO();
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (invUsdAmt[i] != null)
					model.setInvUsdAmt(invUsdAmt[i]);
				if (seqNo[i] != null)
					model.setSeqNo(seqNo[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (costSeq[i] != null)
					model.setCostSeq(costSeq[i]);
				if (costDesc[i] != null)
					model.setCostDesc(costDesc[i]);
				if (clmCostTpCd[i] != null)
					model.setClmCostTpCd(clmCostTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (clmPtyNo[i] != null)
					model.setClmPtyNo(clmPtyNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (clmPtyNm[i] != null)
					model.setClmPtyNm(clmPtyNm[i]);
				if (invRmk[i] != null)
					model.setInvRmk(invRmk[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (dwClmNo[i] != null)
					model.setDwClmNo(dwClmNo[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomHandlingCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomHandlingCostVO[]
	 */
	public CustomHandlingCostVO[] getCustomHandlingCostVOs(){
		CustomHandlingCostVO[] vos = (CustomHandlingCostVO[])models.toArray(new CustomHandlingCostVO[models.size()]);
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
		this.payDt = this.payDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdAmt = this.invUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqNo = this.seqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costSeq = this.costSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDesc = this.costDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCostTpCd = this.clmCostTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyNo = this.clmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyNm = this.clmPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk = this.invRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmNo = this.dwClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
