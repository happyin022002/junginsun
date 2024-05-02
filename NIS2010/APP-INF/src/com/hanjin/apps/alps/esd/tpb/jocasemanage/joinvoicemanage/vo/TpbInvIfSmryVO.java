/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TpbInvIfSmryVO.java
*@FileTitle : TpbInvIfSmryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2010.04.15 최 선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo;

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
 * @author 최 선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TpbInvIfSmryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TpbInvIfSmryVO> models = new ArrayList<TpbInvIfSmryVO>();
	
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String monXchRt = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String invIfNo = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String ifOfcCd = null;
	/* Column Info */
	private String invIfDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String n3ptyInvNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String invCustCntCd = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String invIfFlg = null;
	/* Column Info */
	private String fincDirCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String invIfCtyCd = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String invIfOfcCd = null;
	/* Column Info */
	private String invIfDesc = null;
	/* Column Info */
	private String invCustSeq = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String invIfUsdAmt = null;
	/* Column Info */
	private String ifBlNo = null;
	/* Column Info */
	private String ifRhqCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rcvDueDt = null;
	/* Column Info */
	private String invIfLoclAmt = null;
	/* Column Info */
	private String vndrCustRefRmk = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TpbInvIfSmryVO() {}

	public TpbInvIfSmryVO(String ibflag, String pagerows, String monXchRt, String porCd, String invIfNo, String vslCd, String laneCd, String glDt, String currCd, String ifOfcCd, String invIfDt, String creDt, String blNo, String sailArrDt, String n3ptyInvNo, String polCd, String vvdCd, String invCustCntCd, String arIfNo, String invIfFlg, String fincDirCd, String updUsrId, String updDt, String invIfCtyCd, String csrNo, String invIfOfcCd, String invIfDesc, String invCustSeq, String delCd, String skdVoyNo, String ifBlNo, String invIfUsdAmt, String ifRhqCd, String podCd, String creUsrId, String bkgNo, String rcvDueDt, String invIfLoclAmt, String userId, String userOfcCd, String vndrCustRefRmk) {
		this.userOfcCd = userOfcCd;
		this.porCd = porCd;
		this.monXchRt = monXchRt;
		this.laneCd = laneCd;
		this.vslCd = vslCd;
		this.invIfNo = invIfNo;
		this.glDt = glDt;
		this.currCd = currCd;
		this.ifOfcCd = ifOfcCd;
		this.invIfDt = invIfDt;
		this.creDt = creDt;
		this.blNo = blNo;
		this.sailArrDt = sailArrDt;
		this.n3ptyInvNo = n3ptyInvNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.vvdCd = vvdCd;
		this.invCustCntCd = invCustCntCd;
		this.arIfNo = arIfNo;
		this.userId = userId;
		this.invIfFlg = invIfFlg;
		this.fincDirCd = fincDirCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.invIfCtyCd = invIfCtyCd;
		this.csrNo = csrNo;
		this.invIfOfcCd = invIfOfcCd;
		this.invIfDesc = invIfDesc;
		this.invCustSeq = invCustSeq;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.invIfUsdAmt = invIfUsdAmt;
		this.ifBlNo = ifBlNo;
		this.ifRhqCd = ifRhqCd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.rcvDueDt = rcvDueDt;
		this.invIfLoclAmt = invIfLoclAmt;
		this.vndrCustRefRmk = vndrCustRefRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("mon_xch_rt", getMonXchRt());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("inv_if_no", getInvIfNo());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("if_ofc_cd", getIfOfcCd());
		this.hashColumns.put("inv_if_dt", getInvIfDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("n3pty_inv_no", getN3ptyInvNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("inv_cust_cnt_cd", getInvCustCntCd());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("inv_if_flg", getInvIfFlg());
		this.hashColumns.put("finc_dir_cd", getFincDirCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("inv_if_cty_cd", getInvIfCtyCd());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("inv_if_ofc_cd", getInvIfOfcCd());
		this.hashColumns.put("inv_if_desc", getInvIfDesc());
		this.hashColumns.put("inv_cust_seq", getInvCustSeq());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("inv_if_usd_amt", getInvIfUsdAmt());
		this.hashColumns.put("if_bl_no", getIfBlNo());
		this.hashColumns.put("if_rhq_cd", getIfRhqCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rcv_due_dt", getRcvDueDt());
		this.hashColumns.put("inv_if_locl_amt", getInvIfLoclAmt());
		this.hashColumns.put("vndr_cust_ref_rmk", getVndrCustRefRmk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("mon_xch_rt", "monXchRt");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("inv_if_no", "invIfNo");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("if_ofc_cd", "ifOfcCd");
		this.hashFields.put("inv_if_dt", "invIfDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("n3pty_inv_no", "n3ptyInvNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("inv_cust_cnt_cd", "invCustCntCd");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("inv_if_flg", "invIfFlg");
		this.hashFields.put("finc_dir_cd", "fincDirCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("inv_if_cty_cd", "invIfCtyCd");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("inv_if_ofc_cd", "invIfOfcCd");
		this.hashFields.put("inv_if_desc", "invIfDesc");
		this.hashFields.put("inv_cust_seq", "invCustSeq");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("inv_if_usd_amt", "invIfUsdAmt");
		this.hashFields.put("if_bl_no", "ifBlNo");
		this.hashFields.put("if_rhq_cd", "ifRhqCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rcv_due_dt", "rcvDueDt");
		this.hashFields.put("inv_if_locl_amt", "invIfLoclAmt");
		this.hashFields.put("vndr_cust_ref_rmk", "vndrCustRefRmk");
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
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return monXchRt
	 */
	public String getMonXchRt() {
		return this.monXchRt;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
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
	 * @return ifOfcCd
	 */
	public String getIfOfcCd() {
		return this.ifOfcCd;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
	}
	
	/**
	 * Column Info
	 * @return n3ptyInvNo
	 */
	public String getN3ptyInvNo() {
		return this.n3ptyInvNo;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return invCustCntCd
	 */
	public String getInvCustCntCd() {
		return this.invCustCntCd;
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
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
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
	 * @return fincDirCd
	 */
	public String getFincDirCd() {
		return this.fincDirCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return invIfCtyCd
	 */
	public String getInvIfCtyCd() {
		return this.invIfCtyCd;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
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
	 * @return invIfDesc
	 */
	public String getInvIfDesc() {
		return this.invIfDesc;
	}
	
	/**
	 * Column Info
	 * @return invCustSeq
	 */
	public String getInvCustSeq() {
		return this.invCustSeq;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return invIfUsdAmt
	 */
	public String getInvIfUsdAmt() {
		return this.invIfUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return ifBlNo
	 */
	public String getIfBlNo() {
		return this.ifBlNo;
	}
	
	/**
	 * Column Info
	 * @return ifRhqCd
	 */
	public String getIfRhqCd() {
		return this.ifRhqCd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return rcvDueDt
	 */
	public String getRcvDueDt() {
		return this.rcvDueDt;
	}
	
	/**
	 * Column Info
	 * @return invIfLoclAmt
	 */
	public String getInvIfLoclAmt() {
		return this.invIfLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return vndrCustRefRmk
	 */
	public String getVndrCustRefRmk() {
		return this.vndrCustRefRmk;
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
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param monXchRt
	 */
	public void setMonXchRt(String monXchRt) {
		this.monXchRt = monXchRt;
	}
	
	/**
	 * Column Info
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
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
	 * @param ifOfcCd
	 */
	public void setIfOfcCd(String ifOfcCd) {
		this.ifOfcCd = ifOfcCd;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}
	
	/**
	 * Column Info
	 * @param n3ptyInvNo
	 */
	public void setN3ptyInvNo(String n3ptyInvNo) {
		this.n3ptyInvNo = n3ptyInvNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param invCustCntCd
	 */
	public void setInvCustCntCd(String invCustCntCd) {
		this.invCustCntCd = invCustCntCd;
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @param fincDirCd
	 */
	public void setFincDirCd(String fincDirCd) {
		this.fincDirCd = fincDirCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param invIfCtyCd
	 */
	public void setInvIfCtyCd(String invIfCtyCd) {
		this.invIfCtyCd = invIfCtyCd;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
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
	 * @param invIfDesc
	 */
	public void setInvIfDesc(String invIfDesc) {
		this.invIfDesc = invIfDesc;
	}
	
	/**
	 * Column Info
	 * @param invCustSeq
	 */
	public void setInvCustSeq(String invCustSeq) {
		this.invCustSeq = invCustSeq;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param invIfUsdAmt
	 */
	public void setInvIfUsdAmt(String invIfUsdAmt) {
		this.invIfUsdAmt = invIfUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param ifBlNo
	 */
	public void setIfBlNo(String ifBlNo) {
		this.ifBlNo = ifBlNo;
	}
	
	/**
	 * Column Info
	 * @param ifRhqCd
	 */
	public void setIfRhqCd(String ifRhqCd) {
		this.ifRhqCd = ifRhqCd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param rcvDueDt
	 */
	public void setRcvDueDt(String rcvDueDt) {
		this.rcvDueDt = rcvDueDt;
	}
	
	/**
	 * Column Info
	 * @param invIfLoclAmt
	 */
	public void setInvIfLoclAmt(String invIfLoclAmt) {
		this.invIfLoclAmt = invIfLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param vndrCustRefRmk
	 */
	public void setVndrCustRefRmk(String vndrCustRefRmk) {
		this.vndrCustRefRmk = vndrCustRefRmk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setMonXchRt(JSPUtil.getParameter(request, "mon_xch_rt", ""));
		setLaneCd(JSPUtil.getParameter(request, "lane_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setInvIfNo(JSPUtil.getParameter(request, "inv_if_no", ""));
		setGlDt(JSPUtil.getParameter(request, "gl_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setIfOfcCd(JSPUtil.getParameter(request, "if_ofc_cd", ""));
		setInvIfDt(JSPUtil.getParameter(request, "inv_if_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setSailArrDt(JSPUtil.getParameter(request, "sail_arr_dt", ""));
		setN3ptyInvNo(JSPUtil.getParameter(request, "n3pty_inv_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setInvCustCntCd(JSPUtil.getParameter(request, "inv_cust_cnt_cd", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setInvIfFlg(JSPUtil.getParameter(request, "inv_if_flg", ""));
		setFincDirCd(JSPUtil.getParameter(request, "finc_dir_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setInvIfCtyCd(JSPUtil.getParameter(request, "inv_if_cty_cd", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setInvIfOfcCd(JSPUtil.getParameter(request, "inv_if_ofc_cd", ""));
		setInvIfDesc(JSPUtil.getParameter(request, "inv_if_desc", ""));
		setInvCustSeq(JSPUtil.getParameter(request, "inv_cust_seq", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setInvIfUsdAmt(JSPUtil.getParameter(request, "inv_if_usd_amt", ""));
		setIfBlNo(JSPUtil.getParameter(request, "if_bl_no", ""));
		setIfRhqCd(JSPUtil.getParameter(request, "if_rhq_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setRcvDueDt(JSPUtil.getParameter(request, "rcv_due_dt", ""));
		setInvIfLoclAmt(JSPUtil.getParameter(request, "inv_if_locl_amt", ""));
		setVndrCustRefRmk(JSPUtil.getParameter(request, "vndr_cust_ref_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TpbInvIfSmryVO[]
	 */
	public TpbInvIfSmryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TpbInvIfSmryVO[]
	 */
	public TpbInvIfSmryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TpbInvIfSmryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] monXchRt = (JSPUtil.getParameter(request, prefix	+ "mon_xch_rt", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] invIfNo = (JSPUtil.getParameter(request, prefix	+ "inv_if_no", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] ifOfcCd = (JSPUtil.getParameter(request, prefix	+ "if_ofc_cd", length));
			String[] invIfDt = (JSPUtil.getParameter(request, prefix	+ "inv_if_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] n3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] invCustCntCd = (JSPUtil.getParameter(request, prefix	+ "inv_cust_cnt_cd", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] invIfFlg = (JSPUtil.getParameter(request, prefix	+ "inv_if_flg", length));
			String[] fincDirCd = (JSPUtil.getParameter(request, prefix	+ "finc_dir_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] invIfCtyCd = (JSPUtil.getParameter(request, prefix	+ "inv_if_cty_cd", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] invIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_if_ofc_cd", length));
			String[] invIfDesc = (JSPUtil.getParameter(request, prefix	+ "inv_if_desc", length));
			String[] invCustSeq = (JSPUtil.getParameter(request, prefix	+ "inv_cust_seq", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] invIfUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inv_if_usd_amt", length));
			String[] ifBlNo = (JSPUtil.getParameter(request, prefix	+ "if_bl_no", length));
			String[] ifRhqCd = (JSPUtil.getParameter(request, prefix	+ "if_rhq_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rcvDueDt = (JSPUtil.getParameter(request, prefix	+ "rcv_due_dt", length));
			String[] invIfLoclAmt = (JSPUtil.getParameter(request, prefix	+ "inv_if_locl_amt", length));
			String[] vndrCustRefRmk = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_ref_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new TpbInvIfSmryVO();
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (monXchRt[i] != null)
					model.setMonXchRt(monXchRt[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (invIfNo[i] != null)
					model.setInvIfNo(invIfNo[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (ifOfcCd[i] != null)
					model.setIfOfcCd(ifOfcCd[i]);
				if (invIfDt[i] != null)
					model.setInvIfDt(invIfDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (n3ptyInvNo[i] != null)
					model.setN3ptyInvNo(n3ptyInvNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (invCustCntCd[i] != null)
					model.setInvCustCntCd(invCustCntCd[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (invIfFlg[i] != null)
					model.setInvIfFlg(invIfFlg[i]);
				if (fincDirCd[i] != null)
					model.setFincDirCd(fincDirCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (invIfCtyCd[i] != null)
					model.setInvIfCtyCd(invIfCtyCd[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (invIfOfcCd[i] != null)
					model.setInvIfOfcCd(invIfOfcCd[i]);
				if (invIfDesc[i] != null)
					model.setInvIfDesc(invIfDesc[i]);
				if (invCustSeq[i] != null)
					model.setInvCustSeq(invCustSeq[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (invIfUsdAmt[i] != null)
					model.setInvIfUsdAmt(invIfUsdAmt[i]);
				if (ifBlNo[i] != null)
					model.setIfBlNo(ifBlNo[i]);
				if (ifRhqCd[i] != null)
					model.setIfRhqCd(ifRhqCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rcvDueDt[i] != null)
					model.setRcvDueDt(rcvDueDt[i]);
				if (invIfLoclAmt[i] != null)
					model.setInvIfLoclAmt(invIfLoclAmt[i]);
				if (vndrCustRefRmk[i] != null)
					model.setVndrCustRefRmk(vndrCustRefRmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTpbInvIfSmryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TpbInvIfSmryVO[]
	 */
	public TpbInvIfSmryVO[] getTpbInvIfSmryVOs(){
		TpbInvIfSmryVO[] vos = (TpbInvIfSmryVO[])models.toArray(new TpbInvIfSmryVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monXchRt = this.monXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfNo = this.invIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifOfcCd = this.ifOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfDt = this.invIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvNo = this.n3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustCntCd = this.invCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfFlg = this.invIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincDirCd = this.fincDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfCtyCd = this.invIfCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfOfcCd = this.invIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfDesc = this.invIfDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustSeq = this.invCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfUsdAmt = this.invIfUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifBlNo = this.ifBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifRhqCd = this.ifRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDueDt = this.rcvDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfLoclAmt = this.invIfLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustRefRmk = this.vndrCustRefRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
