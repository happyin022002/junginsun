/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CniLiablePartyVO.java
*@FileTitle : CniLiablePartyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2009.10.23 박제성 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.containercargoclaim.indemnityclaim.vo;

import java.lang.reflect.Field;
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
 * @author 박제성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CniLiablePartyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CniLiablePartyVO> models = new ArrayList<CniLiablePartyVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String lablPtyRcvrLoclAmt = null;
	/* Column Info */
	private String lablPtyRcvrDt = null;
	/* Column Info */
	private String lablPtyRcvrUsdAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String lablPtyXchRt = null;
	/* Column Info */
	private String lablPtyDmndUsdAmt = null;
	/* Column Info */
	private String hndlOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String clmPtyNo = null;
	/* Column Info */
	private String lablPtyClmRmk = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lablPtyDmndCurrCd = null;
	/* Column Info */
	private String tmBarDt = null;
	/* Column Info */
	private String lablPtyPrlmClmNtfyDt = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String lablPtyDmndAmt = null;
	/* Column Info */
	private String lablPtyRcvrLoclCurrCd = null;
	/* Column Info */
	private String lablPtyFmalClmDt = null;
	/* Column Info */
	private String lablPtyRcvrLoclXchRt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CniLiablePartyVO() {}

	public CniLiablePartyVO(String ibflag, String pagerows, String cgoClmNo, String tmBarDt, String lablPtyFmalClmDt, String lablPtyDmndUsdAmt, String lablPtyDmndAmt, String lablPtyDmndCurrCd, String lablPtyXchRt, String hndlOfcCd, String lablPtyPrlmClmNtfyDt, String lablPtyRcvrDt, String lablPtyRcvrUsdAmt, String lablPtyRcvrLoclCurrCd, String lablPtyRcvrLoclAmt, String lablPtyRcvrLoclXchRt, String lablPtyClmRmk, String clmPtyNo, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.lablPtyRcvrLoclAmt = lablPtyRcvrLoclAmt;
		this.lablPtyRcvrDt = lablPtyRcvrDt;
		this.lablPtyRcvrUsdAmt = lablPtyRcvrUsdAmt;
		this.creDt = creDt;
		this.lablPtyXchRt = lablPtyXchRt;
		this.lablPtyDmndUsdAmt = lablPtyDmndUsdAmt;
		this.hndlOfcCd = hndlOfcCd;
		this.pagerows = pagerows;
		this.clmPtyNo = clmPtyNo;
		this.lablPtyClmRmk = lablPtyClmRmk;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.lablPtyDmndCurrCd = lablPtyDmndCurrCd;
		this.tmBarDt = tmBarDt;
		this.lablPtyPrlmClmNtfyDt = lablPtyPrlmClmNtfyDt;
		this.cgoClmNo = cgoClmNo;
		this.lablPtyDmndAmt = lablPtyDmndAmt;
		this.lablPtyRcvrLoclCurrCd = lablPtyRcvrLoclCurrCd;
		this.lablPtyFmalClmDt = lablPtyFmalClmDt;
		this.lablPtyRcvrLoclXchRt = lablPtyRcvrLoclXchRt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("labl_pty_rcvr_locl_amt", getLablPtyRcvrLoclAmt());
		this.hashColumns.put("labl_pty_rcvr_dt", getLablPtyRcvrDt());
		this.hashColumns.put("labl_pty_rcvr_usd_amt", getLablPtyRcvrUsdAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("labl_pty_xch_rt", getLablPtyXchRt());
		this.hashColumns.put("labl_pty_dmnd_usd_amt", getLablPtyDmndUsdAmt());
		this.hashColumns.put("hndl_ofc_cd", getHndlOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("clm_pty_no", getClmPtyNo());
		this.hashColumns.put("labl_pty_clm_rmk", getLablPtyClmRmk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("labl_pty_dmnd_curr_cd", getLablPtyDmndCurrCd());
		this.hashColumns.put("tm_bar_dt", getTmBarDt());
		this.hashColumns.put("labl_pty_prlm_clm_ntfy_dt", getLablPtyPrlmClmNtfyDt());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("labl_pty_dmnd_amt", getLablPtyDmndAmt());
		this.hashColumns.put("labl_pty_rcvr_locl_curr_cd", getLablPtyRcvrLoclCurrCd());
		this.hashColumns.put("labl_pty_fmal_clm_dt", getLablPtyFmalClmDt());
		this.hashColumns.put("labl_pty_rcvr_locl_xch_rt", getLablPtyRcvrLoclXchRt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("labl_pty_rcvr_locl_amt", "lablPtyRcvrLoclAmt");
		this.hashFields.put("labl_pty_rcvr_dt", "lablPtyRcvrDt");
		this.hashFields.put("labl_pty_rcvr_usd_amt", "lablPtyRcvrUsdAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("labl_pty_xch_rt", "lablPtyXchRt");
		this.hashFields.put("labl_pty_dmnd_usd_amt", "lablPtyDmndUsdAmt");
		this.hashFields.put("hndl_ofc_cd", "hndlOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("clm_pty_no", "clmPtyNo");
		this.hashFields.put("labl_pty_clm_rmk", "lablPtyClmRmk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("labl_pty_dmnd_curr_cd", "lablPtyDmndCurrCd");
		this.hashFields.put("tm_bar_dt", "tmBarDt");
		this.hashFields.put("labl_pty_prlm_clm_ntfy_dt", "lablPtyPrlmClmNtfyDt");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("labl_pty_dmnd_amt", "lablPtyDmndAmt");
		this.hashFields.put("labl_pty_rcvr_locl_curr_cd", "lablPtyRcvrLoclCurrCd");
		this.hashFields.put("labl_pty_fmal_clm_dt", "lablPtyFmalClmDt");
		this.hashFields.put("labl_pty_rcvr_locl_xch_rt", "lablPtyRcvrLoclXchRt");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return lablPtyRcvrLoclAmt
	 */
	public String getLablPtyRcvrLoclAmt() {
		return this.lablPtyRcvrLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyRcvrDt
	 */
	public String getLablPtyRcvrDt() {
		return this.lablPtyRcvrDt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyRcvrUsdAmt
	 */
	public String getLablPtyRcvrUsdAmt() {
		return this.lablPtyRcvrUsdAmt;
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
	 * @return lablPtyXchRt
	 */
	public String getLablPtyXchRt() {
		return this.lablPtyXchRt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyDmndUsdAmt
	 */
	public String getLablPtyDmndUsdAmt() {
		return this.lablPtyDmndUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return hndlOfcCd
	 */
	public String getHndlOfcCd() {
		return this.hndlOfcCd;
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
	 * @return lablPtyClmRmk
	 */
	public String getLablPtyClmRmk() {
		return this.lablPtyClmRmk;
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
	 * @return lablPtyDmndCurrCd
	 */
	public String getLablPtyDmndCurrCd() {
		return this.lablPtyDmndCurrCd;
	}
	
	/**
	 * Column Info
	 * @return tmBarDt
	 */
	public String getTmBarDt() {
		return this.tmBarDt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyPrlmClmNtfyDt
	 */
	public String getLablPtyPrlmClmNtfyDt() {
		return this.lablPtyPrlmClmNtfyDt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmNo
	 */
	public String getCgoClmNo() {
		return this.cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @return lablPtyDmndAmt
	 */
	public String getLablPtyDmndAmt() {
		return this.lablPtyDmndAmt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyRcvrLoclCurrCd
	 */
	public String getLablPtyRcvrLoclCurrCd() {
		return this.lablPtyRcvrLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return lablPtyFmalClmDt
	 */
	public String getLablPtyFmalClmDt() {
		return this.lablPtyFmalClmDt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyRcvrLoclXchRt
	 */
	public String getLablPtyRcvrLoclXchRt() {
		return this.lablPtyRcvrLoclXchRt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyRcvrLoclAmt
	 */
	public void setLablPtyRcvrLoclAmt(String lablPtyRcvrLoclAmt) {
		this.lablPtyRcvrLoclAmt = lablPtyRcvrLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyRcvrDt
	 */
	public void setLablPtyRcvrDt(String lablPtyRcvrDt) {
		this.lablPtyRcvrDt = lablPtyRcvrDt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyRcvrUsdAmt
	 */
	public void setLablPtyRcvrUsdAmt(String lablPtyRcvrUsdAmt) {
		this.lablPtyRcvrUsdAmt = lablPtyRcvrUsdAmt;
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
	 * @param lablPtyXchRt
	 */
	public void setLablPtyXchRt(String lablPtyXchRt) {
		this.lablPtyXchRt = lablPtyXchRt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyDmndUsdAmt
	 */
	public void setLablPtyDmndUsdAmt(String lablPtyDmndUsdAmt) {
		this.lablPtyDmndUsdAmt = lablPtyDmndUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param hndlOfcCd
	 */
	public void setHndlOfcCd(String hndlOfcCd) {
		this.hndlOfcCd = hndlOfcCd;
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
	 * @param lablPtyClmRmk
	 */
	public void setLablPtyClmRmk(String lablPtyClmRmk) {
		this.lablPtyClmRmk = lablPtyClmRmk;
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
	 * @param lablPtyDmndCurrCd
	 */
	public void setLablPtyDmndCurrCd(String lablPtyDmndCurrCd) {
		this.lablPtyDmndCurrCd = lablPtyDmndCurrCd;
	}
	
	/**
	 * Column Info
	 * @param tmBarDt
	 */
	public void setTmBarDt(String tmBarDt) {
		this.tmBarDt = tmBarDt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyPrlmClmNtfyDt
	 */
	public void setLablPtyPrlmClmNtfyDt(String lablPtyPrlmClmNtfyDt) {
		this.lablPtyPrlmClmNtfyDt = lablPtyPrlmClmNtfyDt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmNo
	 */
	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @param lablPtyDmndAmt
	 */
	public void setLablPtyDmndAmt(String lablPtyDmndAmt) {
		this.lablPtyDmndAmt = lablPtyDmndAmt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyRcvrLoclCurrCd
	 */
	public void setLablPtyRcvrLoclCurrCd(String lablPtyRcvrLoclCurrCd) {
		this.lablPtyRcvrLoclCurrCd = lablPtyRcvrLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param lablPtyFmalClmDt
	 */
	public void setLablPtyFmalClmDt(String lablPtyFmalClmDt) {
		this.lablPtyFmalClmDt = lablPtyFmalClmDt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyRcvrLoclXchRt
	 */
	public void setLablPtyRcvrLoclXchRt(String lablPtyRcvrLoclXchRt) {
		this.lablPtyRcvrLoclXchRt = lablPtyRcvrLoclXchRt;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setLablPtyRcvrLoclAmt(JSPUtil.getParameter(request, "labl_pty_rcvr_locl_amt", ""));
		setLablPtyRcvrDt(JSPUtil.getParameter(request, "labl_pty_rcvr_dt", ""));
		setLablPtyRcvrUsdAmt(JSPUtil.getParameter(request, "labl_pty_rcvr_usd_amt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setLablPtyXchRt(JSPUtil.getParameter(request, "labl_pty_xch_rt", ""));
		setLablPtyDmndUsdAmt(JSPUtil.getParameter(request, "labl_pty_dmnd_usd_amt", ""));
		setHndlOfcCd(JSPUtil.getParameter(request, "hndl_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setClmPtyNo(JSPUtil.getParameter(request, "clm_pty_no", ""));
		setLablPtyClmRmk(JSPUtil.getParameter(request, "labl_pty_clm_rmk", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLablPtyDmndCurrCd(JSPUtil.getParameter(request, "labl_pty_dmnd_curr_cd", ""));
		setTmBarDt(JSPUtil.getParameter(request, "tm_bar_dt", ""));
		setLablPtyPrlmClmNtfyDt(JSPUtil.getParameter(request, "labl_pty_prlm_clm_ntfy_dt", ""));
		setCgoClmNo(JSPUtil.getParameter(request, "cgo_clm_no", ""));
		setLablPtyDmndAmt(JSPUtil.getParameter(request, "labl_pty_dmnd_amt", ""));
		setLablPtyRcvrLoclCurrCd(JSPUtil.getParameter(request, "labl_pty_rcvr_locl_curr_cd", ""));
		setLablPtyFmalClmDt(JSPUtil.getParameter(request, "labl_pty_fmal_clm_dt", ""));
		setLablPtyRcvrLoclXchRt(JSPUtil.getParameter(request, "labl_pty_rcvr_locl_xch_rt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CniLiablePartyVO[]
	 */
	public CniLiablePartyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CniLiablePartyVO[]
	 */
	public CniLiablePartyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CniLiablePartyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] lablPtyRcvrLoclAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_locl_amt", length));
			String[] lablPtyRcvrDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_dt", length));
			String[] lablPtyRcvrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_usd_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] lablPtyXchRt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_xch_rt", length));
			String[] lablPtyDmndUsdAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_dmnd_usd_amt", length));
			String[] hndlOfcCd = (JSPUtil.getParameter(request, prefix	+ "hndl_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] clmPtyNo = (JSPUtil.getParameter(request, prefix	+ "clm_pty_no", length));
			String[] lablPtyClmRmk = (JSPUtil.getParameter(request, prefix	+ "labl_pty_clm_rmk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lablPtyDmndCurrCd = (JSPUtil.getParameter(request, prefix	+ "labl_pty_dmnd_curr_cd", length));
			String[] tmBarDt = (JSPUtil.getParameter(request, prefix	+ "tm_bar_dt", length));
			String[] lablPtyPrlmClmNtfyDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_prlm_clm_ntfy_dt", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] lablPtyDmndAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_dmnd_amt", length));
			String[] lablPtyRcvrLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_locl_curr_cd", length));
			String[] lablPtyFmalClmDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_fmal_clm_dt", length));
			String[] lablPtyRcvrLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_locl_xch_rt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CniLiablePartyVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (lablPtyRcvrLoclAmt[i] != null)
					model.setLablPtyRcvrLoclAmt(lablPtyRcvrLoclAmt[i]);
				if (lablPtyRcvrDt[i] != null)
					model.setLablPtyRcvrDt(lablPtyRcvrDt[i]);
				if (lablPtyRcvrUsdAmt[i] != null)
					model.setLablPtyRcvrUsdAmt(lablPtyRcvrUsdAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (lablPtyXchRt[i] != null)
					model.setLablPtyXchRt(lablPtyXchRt[i]);
				if (lablPtyDmndUsdAmt[i] != null)
					model.setLablPtyDmndUsdAmt(lablPtyDmndUsdAmt[i]);
				if (hndlOfcCd[i] != null)
					model.setHndlOfcCd(hndlOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (clmPtyNo[i] != null)
					model.setClmPtyNo(clmPtyNo[i]);
				if (lablPtyClmRmk[i] != null)
					model.setLablPtyClmRmk(lablPtyClmRmk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lablPtyDmndCurrCd[i] != null)
					model.setLablPtyDmndCurrCd(lablPtyDmndCurrCd[i]);
				if (tmBarDt[i] != null)
					model.setTmBarDt(tmBarDt[i]);
				if (lablPtyPrlmClmNtfyDt[i] != null)
					model.setLablPtyPrlmClmNtfyDt(lablPtyPrlmClmNtfyDt[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (lablPtyDmndAmt[i] != null)
					model.setLablPtyDmndAmt(lablPtyDmndAmt[i]);
				if (lablPtyRcvrLoclCurrCd[i] != null)
					model.setLablPtyRcvrLoclCurrCd(lablPtyRcvrLoclCurrCd[i]);
				if (lablPtyFmalClmDt[i] != null)
					model.setLablPtyFmalClmDt(lablPtyFmalClmDt[i]);
				if (lablPtyRcvrLoclXchRt[i] != null)
					model.setLablPtyRcvrLoclXchRt(lablPtyRcvrLoclXchRt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCniLiablePartyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CniLiablePartyVO[]
	 */
	public CniLiablePartyVO[] getCniLiablePartyVOs(){
		CniLiablePartyVO[] vos = (CniLiablePartyVO[])models.toArray(new CniLiablePartyVO[models.size()]);
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
		this.lablPtyRcvrLoclAmt = this.lablPtyRcvrLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrDt = this.lablPtyRcvrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrUsdAmt = this.lablPtyRcvrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyXchRt = this.lablPtyXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyDmndUsdAmt = this.lablPtyDmndUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlOfcCd = this.hndlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyNo = this.clmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyClmRmk = this.lablPtyClmRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyDmndCurrCd = this.lablPtyDmndCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmBarDt = this.tmBarDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyPrlmClmNtfyDt = this.lablPtyPrlmClmNtfyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyDmndAmt = this.lablPtyDmndAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrLoclCurrCd = this.lablPtyRcvrLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyFmalClmDt = this.lablPtyFmalClmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrLoclXchRt = this.lablPtyRcvrLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
