/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TroMultiCancelFrustVO.java
*@FileTitle : TroMultiCancelFrustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.12.30 류대영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TroMultiCancelFrustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TroMultiCancelFrustVO> models = new ArrayList<TroMultiCancelFrustVO>();
	
	/* Column Info */
	private String cfmUpdDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String soFlg = null;
	/* Column Info */
	private String frustrateChk = null;
	/* Column Info */
	private String troSeq = null;
	/* Column Info */
	private String trnsRevAmt = null;
	/* Column Info */
	private String nonTrnsRevAmt = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String cxlFlg = null;
	/* Column Info */
	private String corrNo = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actCntCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String woFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cfmUsrId = null;
	/* Column Info */
	private String frustrate = null;
	/* Column Info */
	private String hlgTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cxlFlgChk = null;
	/* Column Info */
	private String addRevAmt = null;
	/* Column Info */
	private String addRevChgCd = null;
	/* Column Info */
	private String troSubSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TroMultiCancelFrustVO() {}

	public TroMultiCancelFrustVO(String ibflag, String pagerows, String troSeq, String cntrNo, String cntrTpszCd, String soFlg, String woFlg, String cxlFlg, String cxlFlgChk, String frustrate, String frustrateChk, String currCd, String trnsRevAmt, String nonTrnsRevAmt, String bkgNo, String ioBndCd, String actCntCd, String actCustSeq, String hlgTpCd, String cfmUsrId, String ofcCd, String cfmUpdDt, String corrNo, String updUsrId, String addRevAmt, String addRevChgCd, String troSubSeq) {
		this.cfmUpdDt = cfmUpdDt;
		this.currCd = currCd;
		this.soFlg = soFlg;
		this.frustrateChk = frustrateChk;
		this.troSeq = troSeq;
		this.trnsRevAmt = trnsRevAmt;
		this.nonTrnsRevAmt = nonTrnsRevAmt;
		this.actCustSeq = actCustSeq;
		this.cxlFlg = cxlFlg;
		this.corrNo = corrNo;
		this.ioBndCd = ioBndCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.actCntCd = actCntCd;
		this.cntrNo = cntrNo;
		this.woFlg = woFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.cfmUsrId = cfmUsrId;
		this.frustrate = frustrate;
		this.hlgTpCd = hlgTpCd;
		this.updUsrId = updUsrId;
		this.cxlFlgChk = cxlFlgChk;
		this.addRevAmt = addRevAmt;
		this.addRevChgCd = addRevChgCd;
		this.troSubSeq = troSubSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cfm_upd_dt", getCfmUpdDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("so_flg", getSoFlg());
		this.hashColumns.put("frustrate_chk", getFrustrateChk());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("trns_rev_amt", getTrnsRevAmt());
		this.hashColumns.put("non_trns_rev_amt",getNonTrnsRevAmt());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("cxl_flg", getCxlFlg());
		this.hashColumns.put("corr_no", getCorrNo());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_cnt_cd", getActCntCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("wo_flg", getWoFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cfm_usr_id", getCfmUsrId());
		this.hashColumns.put("frustrate", getFrustrate());
		this.hashColumns.put("hlg_tp_cd", getHlgTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("add_rev_amt", getAddRevAmt());
		this.hashColumns.put("add_rev_chg_cd", getAddRevChgCd());
		this.hashColumns.put("tro_sub_seq", getTroSubSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cfm_upd_dt", "cfmUpdDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("so_flg", "soFlg");
		this.hashFields.put("frustrate_chk", "frustrateChk");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("trns_rev_amt", "trnsRevAmt");
		this.hashFields.put("non_trns_rev_amt", "nonTrnsRevAmt");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("corr_no", "corrNo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_cnt_cd", "actCntCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("wo_flg", "woFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cfm_usr_id", "cfmUsrId");
		this.hashFields.put("frustrate", "frustrate");
		this.hashFields.put("hlg_tp_cd", "hlgTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cxl_flg_chk", "cxlFlgChk");
		this.hashFields.put("add_rev_amt", "addRevAmt");
		this.hashFields.put("add_rev_chg_cd", "addRevChgCd");
		this.hashFields.put("tro_sub_seq", "troSubSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cfmUpdDt
	 */
	public String getCfmUpdDt() {
		return this.cfmUpdDt;
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
	 * @return soFlg
	 */
	public String getSoFlg() {
		return this.soFlg;
	}
	
	/**
	 * Column Info
	 * @return frustrateChk
	 */
	public String getFrustrateChk() {
		return this.frustrateChk;
	}
	
	/**
	 * Column Info
	 * @return troSeq
	 */
	public String getTroSeq() {
		return this.troSeq;
	}
	
	/**
	 * Column Info
	 * @return trnsRevAmt
	 */
	public String getTrnsRevAmt() {
		return this.trnsRevAmt;
	}
	
	/**
	 * Column Info
	 * @return nonTrnsRevAmt
	 */
	public String getNonTrnsRevAmt() {
		return this.nonTrnsRevAmt;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 * Column Info
	 * @return cxlFlg
	 */
	public String getCxlFlg() {
		return this.cxlFlg;
	}
	
	/**
	 * Column Info
	 * @return corrNo
	 */
	public String getCorrNo() {
		return this.corrNo;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return actCntCd
	 */
	public String getActCntCd() {
		return this.actCntCd;
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
	 * @return woFlg
	 */
	public String getWoFlg() {
		return this.woFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cfmUsrId
	 */
	public String getCfmUsrId() {
		return this.cfmUsrId;
	}
	
	/**
	 * Column Info
	 * @return frustrate
	 */
	public String getFrustrate() {
		return this.frustrate;
	}
	
	/**
	 * Column Info
	 * @return hlgTpCd
	 */
	public String getHlgTpCd() {
		return this.hlgTpCd;
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
	 * @return cxlFlgChk
	 */
	public String getCxlFlgChk() {
		return this.cxlFlgChk;
	}
	
	/**
	 * Column Info
	 * @return addRevAmt
	 */
	public String getAddRevAmt() {
		return this.addRevAmt;
	}
	
	/**
	 * Column Info
	 * @return addRevChgCd
	 */
	public String getAddRevChgCd() {
		return this.addRevChgCd;
	}

	/**
	 * Column Info
	 * @return troSubSeq
	 */
	public String getTroSubSeq() {
		return this.troSubSeq;
	}

	/**
	 * Column Info
	 * @param cfmUpdDt
	 */
	public void setCfmUpdDt(String cfmUpdDt) {
		this.cfmUpdDt = cfmUpdDt;
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
	 * @param soFlg
	 */
	public void setSoFlg(String soFlg) {
		this.soFlg = soFlg;
	}
	
	/**
	 * Column Info
	 * @param frustrateChk
	 */
	public void setFrustrateChk(String frustrateChk) {
		this.frustrateChk = frustrateChk;
	}
	
	/**
	 * Column Info
	 * @param troSeq
	 */
	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
	}
	
	/**
	 * Column Info
	 * @param trnsRevAmt
	 */
	public void setTrnsRevAmt(String trnsRevAmt) {
		this.trnsRevAmt = trnsRevAmt;
	}

	/**
	 * Column Info
	 * @param nonTrnsRevAmt
	 */
	public void setNonTrnsRevAmt(String nonTrnsRevAmt) {
		this.nonTrnsRevAmt = nonTrnsRevAmt;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * Column Info
	 * @param cxlFlg
	 */
	public void setCxlFlg(String cxlFlg) {
		this.cxlFlg = cxlFlg;
	}
	
	/**
	 * Column Info
	 * @param corrNo
	 */
	public void setCorrNo(String corrNo) {
		this.corrNo = corrNo;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param actCntCd
	 */
	public void setActCntCd(String actCntCd) {
		this.actCntCd = actCntCd;
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
	 * @param woFlg
	 */
	public void setWoFlg(String woFlg) {
		this.woFlg = woFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cfmUsrId
	 */
	public void setCfmUsrId(String cfmUsrId) {
		this.cfmUsrId = cfmUsrId;
	}
	
	/**
	 * Column Info
	 * @param frustrate
	 */
	public void setFrustrate(String frustrate) {
		this.frustrate = frustrate;
	}
	
	/**
	 * Column Info
	 * @param hlgTpCd
	 */
	public void setHlgTpCd(String hlgTpCd) {
		this.hlgTpCd = hlgTpCd;
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
	 * @param cxlFlgChk
	 */
	public void setCxlFlgChk(String cxlFlgChk) {
		this.cxlFlgChk = cxlFlgChk;
	}
	
	/**
	 * Column Info
	 * @param addRevAmt
	 */
	public void setAddRevAmt(String addRevAmt) {
		this.addRevAmt = addRevAmt;
	}
	
	/**
	 * Column Info
	 * @param addRevChgCd
	 */
	public void setAddRevChgCd(String addRevChgCd) {
		this.addRevChgCd = addRevChgCd;
	}

	/**
	 * Column Info
	 * @param troSubSeq
	 */
	public void setTroSubSeq(String troSubSeq) {
		this.troSubSeq = troSubSeq;
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
		setCfmUpdDt(JSPUtil.getParameter(request, prefix + "cfm_upd_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setSoFlg(JSPUtil.getParameter(request, prefix + "so_flg", ""));
		setFrustrateChk(JSPUtil.getParameter(request, prefix + "frustrate_chk", ""));
		setTroSeq(JSPUtil.getParameter(request, prefix + "tro_seq", ""));
		setTrnsRevAmt(JSPUtil.getParameter(request, prefix + "trns_rev_amt", ""));
		setNonTrnsRevAmt(JSPUtil.getParameter(request, prefix + "non_trns_rev_amt", ""));
		setActCustSeq(JSPUtil.getParameter(request, prefix + "act_cust_seq", ""));
		setCxlFlg(JSPUtil.getParameter(request, prefix + "cxl_flg", ""));
		setCorrNo(JSPUtil.getParameter(request, prefix + "corr_no", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setActCntCd(JSPUtil.getParameter(request, prefix + "act_cnt_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setWoFlg(JSPUtil.getParameter(request, prefix + "wo_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCfmUsrId(JSPUtil.getParameter(request, prefix + "cfm_usr_id", ""));
		setFrustrate(JSPUtil.getParameter(request, prefix + "frustrate", ""));
		setHlgTpCd(JSPUtil.getParameter(request, prefix + "hlg_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCxlFlgChk(JSPUtil.getParameter(request, prefix + "cxl_flg_chk", ""));
		setAddRevAmt(JSPUtil.getParameter(request, prefix + "add_rev_amt", ""));
		setAddRevChgCd(JSPUtil.getParameter(request, prefix + "add_rev_chg_cd", ""));
		setTroSubSeq(JSPUtil.getParameter(request, prefix + "tro_sub_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TroMultiCancelFrustVO[]
	 */
	public TroMultiCancelFrustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TroMultiCancelFrustVO[]
	 */
	public TroMultiCancelFrustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TroMultiCancelFrustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cfmUpdDt = (JSPUtil.getParameter(request, prefix	+ "cfm_upd_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] soFlg = (JSPUtil.getParameter(request, prefix	+ "so_flg", length));
			String[] frustrateChk = (JSPUtil.getParameter(request, prefix	+ "frustrate_chk", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix	+ "tro_seq", length));
			String[] trnsRevAmt = (JSPUtil.getParameter(request, prefix	+ "trns_rev_amt", length));
			String[] nonTrnsRevAmt = (JSPUtil.getParameter(request, prefix	+ "non_trns_rev_amt", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] cxlFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_flg", length));
			String[] corrNo = (JSPUtil.getParameter(request, prefix	+ "corr_no", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cnt_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] woFlg = (JSPUtil.getParameter(request, prefix	+ "wo_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cfmUsrId = (JSPUtil.getParameter(request, prefix	+ "cfm_usr_id", length));
			String[] frustrate = (JSPUtil.getParameter(request, prefix	+ "frustrate", length));
			String[] hlgTpCd = (JSPUtil.getParameter(request, prefix	+ "hlg_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cxlFlgChk = (JSPUtil.getParameter(request, prefix	+ "cxl_flg_chk", length));
			String[] addRevAmt = (JSPUtil.getParameter(request, prefix	+ "add_rev_amt", length));
			String[] addRevChgCd = (JSPUtil.getParameter(request, prefix	+ "add_rev_chg_cd", length));
			String[] troSubSeq = (JSPUtil.getParameter(request, prefix	+ "tro_sub_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new TroMultiCancelFrustVO();
				if (cfmUpdDt[i] != null)
					model.setCfmUpdDt(cfmUpdDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (soFlg[i] != null)
					model.setSoFlg(soFlg[i]);
				if (frustrateChk[i] != null)
					model.setFrustrateChk(frustrateChk[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (trnsRevAmt[i] != null)
					model.setTrnsRevAmt(trnsRevAmt[i]);
				if (nonTrnsRevAmt[i] != null)
					model.setNonTrnsRevAmt(nonTrnsRevAmt[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (cxlFlg[i] != null)
					model.setCxlFlg(cxlFlg[i]);
				if (corrNo[i] != null)
					model.setCorrNo(corrNo[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actCntCd[i] != null)
					model.setActCntCd(actCntCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (woFlg[i] != null)
					model.setWoFlg(woFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cfmUsrId[i] != null)
					model.setCfmUsrId(cfmUsrId[i]);
				if (frustrate[i] != null)
					model.setFrustrate(frustrate[i]);
				if (hlgTpCd[i] != null)
					model.setHlgTpCd(hlgTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cxlFlgChk[i] != null)
					model.setCxlFlgChk(cxlFlgChk[i]);
				if (addRevAmt[i] != null)
					model.setAddRevAmt(addRevAmt[i]);
				if (addRevChgCd[i] != null)
					model.setAddRevChgCd(addRevChgCd[i]);
				if (troSubSeq[i] != null)
					model.setTroSubSeq(troSubSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTroMultiCancelFrustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TroMultiCancelFrustVO[]
	 */
	public TroMultiCancelFrustVO[] getTroMultiCancelFrustVOs(){
		TroMultiCancelFrustVO[] vos = (TroMultiCancelFrustVO[])models.toArray(new TroMultiCancelFrustVO[models.size()]);
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
		this.cfmUpdDt = this.cfmUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soFlg = this.soFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frustrateChk = this.frustrateChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsRevAmt = this.trnsRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonTrnsRevAmt = this.nonTrnsRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg = this.cxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrNo = this.corrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCntCd = this.actCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woFlg = this.woFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsrId = this.cfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frustrate = this.frustrate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hlgTpCd = this.hlgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlgChk = this.cxlFlgChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addRevAmt = this.addRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addRevChgCd = this.addRevChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSubSeq = this.troSubSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
