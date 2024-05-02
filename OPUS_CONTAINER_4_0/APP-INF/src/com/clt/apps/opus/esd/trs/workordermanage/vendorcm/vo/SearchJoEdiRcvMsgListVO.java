/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchJoEdiRcvMsgListVO.java
*@FileTitle : SearchJoEdiRcvMsgListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.17  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.workordermanage.vendorcm.vo;

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

public class SearchJoEdiRcvMsgListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchJoEdiRcvMsgListVO> models = new ArrayList<SearchJoEdiRcvMsgListVO>();
	
	/* Column Info */
	private String rcvMsgTpCd = null;
	/* Column Info */
	private String nCurrCd = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String oLgsCostCd = null;
	/* Column Info */
	private String vndCmGroup = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String oFuelRto = null;
	/* Column Info */
	private String rcvMsg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String maxRcvMsgSeq = null;
	/* Column Info */
	private String oLgsCostCdNm = null;
	/* Column Info */
	private String nRcvAmt = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String ibcheck = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String oCurrCd = null;
	/* Column Info */
	private String rcvMsgTpCdNm = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String intgCdValDpSeq = null;
	/* Column Info */
	private String trspWoSeq = null;
	/* Column Info */
	private String nLgsCostCdNm = null;
	/* Column Info */
	private String loclCreDt = null;
	/* Column Info */
	private String rcvMsgSeq = null;
	/* Column Info */
	private String rcvMsgStsCd = null;
	/* Column Info */
	private String ediRjctRsnCd = null;
	/* Column Info */
	private String ediRjctRsnCdNm = null;
	/* Column Info */
	private String nFuelRto = null;
	/* Column Info */
	private String trspWoOfcCtyCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String nLgsCostCd = null;
	/* Column Info */
	private String oRcvAmt = null;
	/* Column Info */
	private String eqCopNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchJoEdiRcvMsgListVO() {}

	public SearchJoEdiRcvMsgListVO(String ibflag, String pagerows, String vndCmGroup, String trspWoOfcCtyCd, String trspWoSeq, String woNo, String trspSoOfcCtyCd, String trspSoSeq, String soNo, String eqCopNo, String rcvMsgSeq, String rcvMsgTpCd, String rcvMsgTpCdNm, String rcvMsg, String ediRjctRsnCd, String ediRjctRsnCdNm, String nLgsCostCd, String nLgsCostCdNm, String nCurrCd, String nRcvAmt, String nFuelRto, String oLgsCostCd, String oLgsCostCdNm, String oCurrCd, String oRcvAmt, String oFuelRto, String rcvMsgStsCd, String loclCreDt, String creUsrId, String creDt, String updUsrId, String updDt, String maxRcvMsgSeq, String intgCdValDpSeq, String ibcheck) {
		this.rcvMsgTpCd = rcvMsgTpCd;
		this.nCurrCd = nCurrCd;
		this.trspSoSeq = trspSoSeq;
		this.creDt = creDt;
		this.oLgsCostCd = oLgsCostCd;
		this.vndCmGroup = vndCmGroup;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.pagerows = pagerows;
		this.oFuelRto = oFuelRto;
		this.rcvMsg = rcvMsg;
		this.ibflag = ibflag;
		this.maxRcvMsgSeq = maxRcvMsgSeq;
		this.oLgsCostCdNm = oLgsCostCdNm;
		this.nRcvAmt = nRcvAmt;
		this.woNo = woNo;
		this.ibcheck = ibcheck;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.oCurrCd = oCurrCd;
		this.rcvMsgTpCdNm = rcvMsgTpCdNm;
		this.soNo = soNo;
		this.intgCdValDpSeq = intgCdValDpSeq;
		this.trspWoSeq = trspWoSeq;
		this.nLgsCostCdNm = nLgsCostCdNm;
		this.loclCreDt = loclCreDt;
		this.rcvMsgSeq = rcvMsgSeq;
		this.rcvMsgStsCd = rcvMsgStsCd;
		this.ediRjctRsnCd = ediRjctRsnCd;
		this.ediRjctRsnCdNm = ediRjctRsnCdNm;
		this.nFuelRto = nFuelRto;
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
		this.creUsrId = creUsrId;
		this.nLgsCostCd = nLgsCostCd;
		this.oRcvAmt = oRcvAmt;
		this.eqCopNo = eqCopNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rcv_msg_tp_cd", getRcvMsgTpCd());
		this.hashColumns.put("n_curr_cd", getNCurrCd());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("o_lgs_cost_cd", getOLgsCostCd());
		this.hashColumns.put("vnd_cm_group", getVndCmGroup());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("o_fuel_rto", getOFuelRto());
		this.hashColumns.put("rcv_msg", getRcvMsg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("max_rcv_msg_seq", getMaxRcvMsgSeq());
		this.hashColumns.put("o_lgs_cost_cd_nm", getOLgsCostCdNm());
		this.hashColumns.put("n_rcv_amt", getNRcvAmt());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("ibcheck", getIbcheck());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("o_curr_cd", getOCurrCd());
		this.hashColumns.put("rcv_msg_tp_cd_nm", getRcvMsgTpCdNm());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("intg_cd_val_dp_seq", getIntgCdValDpSeq());
		this.hashColumns.put("trsp_wo_seq", getTrspWoSeq());
		this.hashColumns.put("n_lgs_cost_cd_nm", getNLgsCostCdNm());
		this.hashColumns.put("locl_cre_dt", getLoclCreDt());
		this.hashColumns.put("rcv_msg_seq", getRcvMsgSeq());
		this.hashColumns.put("rcv_msg_sts_cd", getRcvMsgStsCd());
		this.hashColumns.put("edi_rjct_rsn_cd", getEdiRjctRsnCd());
		this.hashColumns.put("edi_rjct_rsn_cd_nm", getEdiRjctRsnCdNm());
		this.hashColumns.put("n_fuel_rto", getNFuelRto());
		this.hashColumns.put("trsp_wo_ofc_cty_cd", getTrspWoOfcCtyCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("n_lgs_cost_cd", getNLgsCostCd());
		this.hashColumns.put("o_rcv_amt", getORcvAmt());
		this.hashColumns.put("eq_cop_no", getEqCopNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rcv_msg_tp_cd", "rcvMsgTpCd");
		this.hashFields.put("n_curr_cd", "nCurrCd");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("o_lgs_cost_cd", "oLgsCostCd");
		this.hashFields.put("vnd_cm_group", "vndCmGroup");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("o_fuel_rto", "oFuelRto");
		this.hashFields.put("rcv_msg", "rcvMsg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("max_rcv_msg_seq", "maxRcvMsgSeq");
		this.hashFields.put("o_lgs_cost_cd_nm", "oLgsCostCdNm");
		this.hashFields.put("n_rcv_amt", "nRcvAmt");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("ibcheck", "ibcheck");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("o_curr_cd", "oCurrCd");
		this.hashFields.put("rcv_msg_tp_cd_nm", "rcvMsgTpCdNm");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("intg_cd_val_dp_seq", "intgCdValDpSeq");
		this.hashFields.put("trsp_wo_seq", "trspWoSeq");
		this.hashFields.put("n_lgs_cost_cd_nm", "nLgsCostCdNm");
		this.hashFields.put("locl_cre_dt", "loclCreDt");
		this.hashFields.put("rcv_msg_seq", "rcvMsgSeq");
		this.hashFields.put("rcv_msg_sts_cd", "rcvMsgStsCd");
		this.hashFields.put("edi_rjct_rsn_cd", "ediRjctRsnCd");
		this.hashFields.put("edi_rjct_rsn_cd_nm", "ediRjctRsnCdNm");
		this.hashFields.put("n_fuel_rto", "nFuelRto");
		this.hashFields.put("trsp_wo_ofc_cty_cd", "trspWoOfcCtyCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("n_lgs_cost_cd", "nLgsCostCd");
		this.hashFields.put("o_rcv_amt", "oRcvAmt");
		this.hashFields.put("eq_cop_no", "eqCopNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rcvMsgTpCd
	 */
	public String getRcvMsgTpCd() {
		return this.rcvMsgTpCd;
	}
	
	/**
	 * Column Info
	 * @return nCurrCd
	 */
	public String getNCurrCd() {
		return this.nCurrCd;
	}
	
	/**
	 * Column Info
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
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
	 * @return oLgsCostCd
	 */
	public String getOLgsCostCd() {
		return this.oLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return vndCmGroup
	 */
	public String getVndCmGroup() {
		return this.vndCmGroup;
	}
	
	/**
	 * Column Info
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
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
	 * @return oFuelRto
	 */
	public String getOFuelRto() {
		return this.oFuelRto;
	}
	
	/**
	 * Column Info
	 * @return rcvMsg
	 */
	public String getRcvMsg() {
		return this.rcvMsg;
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
	 * @return maxRcvMsgSeq
	 */
	public String getMaxRcvMsgSeq() {
		return this.maxRcvMsgSeq;
	}
	
	/**
	 * Column Info
	 * @return oLgsCostCdNm
	 */
	public String getOLgsCostCdNm() {
		return this.oLgsCostCdNm;
	}
	
	/**
	 * Column Info
	 * @return nRcvAmt
	 */
	public String getNRcvAmt() {
		return this.nRcvAmt;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return ibcheck
	 */
	public String getIbcheck() {
		return this.ibcheck;
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
	 * @return oCurrCd
	 */
	public String getOCurrCd() {
		return this.oCurrCd;
	}
	
	/**
	 * Column Info
	 * @return rcvMsgTpCdNm
	 */
	public String getRcvMsgTpCdNm() {
		return this.rcvMsgTpCdNm;
	}
	
	/**
	 * Column Info
	 * @return soNo
	 */
	public String getSoNo() {
		return this.soNo;
	}
	
	/**
	 * Column Info
	 * @return intgCdValDpSeq
	 */
	public String getIntgCdValDpSeq() {
		return this.intgCdValDpSeq;
	}
	
	/**
	 * Column Info
	 * @return trspWoSeq
	 */
	public String getTrspWoSeq() {
		return this.trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @return nLgsCostCdNm
	 */
	public String getNLgsCostCdNm() {
		return this.nLgsCostCdNm;
	}
	
	/**
	 * Column Info
	 * @return loclCreDt
	 */
	public String getLoclCreDt() {
		return this.loclCreDt;
	}
	
	/**
	 * Column Info
	 * @return rcvMsgSeq
	 */
	public String getRcvMsgSeq() {
		return this.rcvMsgSeq;
	}
	
	/**
	 * Column Info
	 * @return rcvMsgStsCd
	 */
	public String getRcvMsgStsCd() {
		return this.rcvMsgStsCd;
	}
	
	/**
	 * Column Info
	 * @return ediRjctRsnCd
	 */
	public String getEdiRjctRsnCd() {
		return this.ediRjctRsnCd;
	}
	
	/**
	 * Column Info
	 * @return ediRjctRsnCdNm
	 */
	public String getEdiRjctRsnCdNm() {
		return this.ediRjctRsnCdNm;
	}
	
	/**
	 * Column Info
	 * @return nFuelRto
	 */
	public String getNFuelRto() {
		return this.nFuelRto;
	}
	
	/**
	 * Column Info
	 * @return trspWoOfcCtyCd
	 */
	public String getTrspWoOfcCtyCd() {
		return this.trspWoOfcCtyCd;
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
	 * @return nLgsCostCd
	 */
	public String getNLgsCostCd() {
		return this.nLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return oRcvAmt
	 */
	public String getORcvAmt() {
		return this.oRcvAmt;
	}
	
	/**
	 * Column Info
	 * @return eqCopNo
	 */
	public String getEqCopNo() {
		return this.eqCopNo;
	}
	

	/**
	 * Column Info
	 * @param rcvMsgTpCd
	 */
	public void setRcvMsgTpCd(String rcvMsgTpCd) {
		this.rcvMsgTpCd = rcvMsgTpCd;
	}
	
	/**
	 * Column Info
	 * @param nCurrCd
	 */
	public void setNCurrCd(String nCurrCd) {
		this.nCurrCd = nCurrCd;
	}
	
	/**
	 * Column Info
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
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
	 * @param oLgsCostCd
	 */
	public void setOLgsCostCd(String oLgsCostCd) {
		this.oLgsCostCd = oLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param vndCmGroup
	 */
	public void setVndCmGroup(String vndCmGroup) {
		this.vndCmGroup = vndCmGroup;
	}
	
	/**
	 * Column Info
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
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
	 * @param oFuelRto
	 */
	public void setOFuelRto(String oFuelRto) {
		this.oFuelRto = oFuelRto;
	}
	
	/**
	 * Column Info
	 * @param rcvMsg
	 */
	public void setRcvMsg(String rcvMsg) {
		this.rcvMsg = rcvMsg;
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
	 * @param maxRcvMsgSeq
	 */
	public void setMaxRcvMsgSeq(String maxRcvMsgSeq) {
		this.maxRcvMsgSeq = maxRcvMsgSeq;
	}
	
	/**
	 * Column Info
	 * @param oLgsCostCdNm
	 */
	public void setOLgsCostCdNm(String oLgsCostCdNm) {
		this.oLgsCostCdNm = oLgsCostCdNm;
	}
	
	/**
	 * Column Info
	 * @param nRcvAmt
	 */
	public void setNRcvAmt(String nRcvAmt) {
		this.nRcvAmt = nRcvAmt;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param ibcheck
	 */
	public void setIbcheck(String ibcheck) {
		this.ibcheck = ibcheck;
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
	 * @param oCurrCd
	 */
	public void setOCurrCd(String oCurrCd) {
		this.oCurrCd = oCurrCd;
	}
	
	/**
	 * Column Info
	 * @param rcvMsgTpCdNm
	 */
	public void setRcvMsgTpCdNm(String rcvMsgTpCdNm) {
		this.rcvMsgTpCdNm = rcvMsgTpCdNm;
	}
	
	/**
	 * Column Info
	 * @param soNo
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}
	
	/**
	 * Column Info
	 * @param intgCdValDpSeq
	 */
	public void setIntgCdValDpSeq(String intgCdValDpSeq) {
		this.intgCdValDpSeq = intgCdValDpSeq;
	}
	
	/**
	 * Column Info
	 * @param trspWoSeq
	 */
	public void setTrspWoSeq(String trspWoSeq) {
		this.trspWoSeq = trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @param nLgsCostCdNm
	 */
	public void setNLgsCostCdNm(String nLgsCostCdNm) {
		this.nLgsCostCdNm = nLgsCostCdNm;
	}
	
	/**
	 * Column Info
	 * @param loclCreDt
	 */
	public void setLoclCreDt(String loclCreDt) {
		this.loclCreDt = loclCreDt;
	}
	
	/**
	 * Column Info
	 * @param rcvMsgSeq
	 */
	public void setRcvMsgSeq(String rcvMsgSeq) {
		this.rcvMsgSeq = rcvMsgSeq;
	}
	
	/**
	 * Column Info
	 * @param rcvMsgStsCd
	 */
	public void setRcvMsgStsCd(String rcvMsgStsCd) {
		this.rcvMsgStsCd = rcvMsgStsCd;
	}
	
	/**
	 * Column Info
	 * @param ediRjctRsnCd
	 */
	public void setEdiRjctRsnCd(String ediRjctRsnCd) {
		this.ediRjctRsnCd = ediRjctRsnCd;
	}
	
	/**
	 * Column Info
	 * @param ediRjctRsnCdNm
	 */
	public void setEdiRjctRsnCdNm(String ediRjctRsnCdNm) {
		this.ediRjctRsnCdNm = ediRjctRsnCdNm;
	}
	
	/**
	 * Column Info
	 * @param nFuelRto
	 */
	public void setNFuelRto(String nFuelRto) {
		this.nFuelRto = nFuelRto;
	}
	
	/**
	 * Column Info
	 * @param trspWoOfcCtyCd
	 */
	public void setTrspWoOfcCtyCd(String trspWoOfcCtyCd) {
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
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
	 * @param nLgsCostCd
	 */
	public void setNLgsCostCd(String nLgsCostCd) {
		this.nLgsCostCd = nLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param oRcvAmt
	 */
	public void setORcvAmt(String oRcvAmt) {
		this.oRcvAmt = oRcvAmt;
	}
	
	/**
	 * Column Info
	 * @param eqCopNo
	 */
	public void setEqCopNo(String eqCopNo) {
		this.eqCopNo = eqCopNo;
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
		setRcvMsgTpCd(JSPUtil.getParameter(request, prefix + "rcv_msg_tp_cd", ""));
		setNCurrCd(JSPUtil.getParameter(request, prefix + "n_curr_cd", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, prefix + "trsp_so_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setOLgsCostCd(JSPUtil.getParameter(request, prefix + "o_lgs_cost_cd", ""));
		setVndCmGroup(JSPUtil.getParameter(request, prefix + "vnd_cm_group", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOFuelRto(JSPUtil.getParameter(request, prefix + "o_fuel_rto", ""));
		setRcvMsg(JSPUtil.getParameter(request, prefix + "rcv_msg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMaxRcvMsgSeq(JSPUtil.getParameter(request, prefix + "max_rcv_msg_seq", ""));
		setOLgsCostCdNm(JSPUtil.getParameter(request, prefix + "o_lgs_cost_cd_nm", ""));
		setNRcvAmt(JSPUtil.getParameter(request, prefix + "n_rcv_amt", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setIbcheck(JSPUtil.getParameter(request, prefix + "ibcheck", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setOCurrCd(JSPUtil.getParameter(request, prefix + "o_curr_cd", ""));
		setRcvMsgTpCdNm(JSPUtil.getParameter(request, prefix + "rcv_msg_tp_cd_nm", ""));
		setSoNo(JSPUtil.getParameter(request, prefix + "so_no", ""));
		setIntgCdValDpSeq(JSPUtil.getParameter(request, prefix + "intg_cd_val_dp_seq", ""));
		setTrspWoSeq(JSPUtil.getParameter(request, prefix + "trsp_wo_seq", ""));
		setNLgsCostCdNm(JSPUtil.getParameter(request, prefix + "n_lgs_cost_cd_nm", ""));
		setLoclCreDt(JSPUtil.getParameter(request, prefix + "locl_cre_dt", ""));
		setRcvMsgSeq(JSPUtil.getParameter(request, prefix + "rcv_msg_seq", ""));
		setRcvMsgStsCd(JSPUtil.getParameter(request, prefix + "rcv_msg_sts_cd", ""));
		setEdiRjctRsnCd(JSPUtil.getParameter(request, prefix + "edi_rjct_rsn_cd", ""));
		setEdiRjctRsnCdNm(JSPUtil.getParameter(request, prefix + "edi_rjct_rsn_cd_nm", ""));
		setNFuelRto(JSPUtil.getParameter(request, prefix + "n_fuel_rto", ""));
		setTrspWoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_wo_ofc_cty_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setNLgsCostCd(JSPUtil.getParameter(request, prefix + "n_lgs_cost_cd", ""));
		setORcvAmt(JSPUtil.getParameter(request, prefix + "o_rcv_amt", ""));
		setEqCopNo(JSPUtil.getParameter(request, prefix + "eq_cop_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchJoEdiRcvMsgListVO[]
	 */
	public SearchJoEdiRcvMsgListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchJoEdiRcvMsgListVO[]
	 */
	public SearchJoEdiRcvMsgListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchJoEdiRcvMsgListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rcvMsgTpCd = (JSPUtil.getParameter(request, prefix	+ "rcv_msg_tp_cd", length));
			String[] nCurrCd = (JSPUtil.getParameter(request, prefix	+ "n_curr_cd", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] oLgsCostCd = (JSPUtil.getParameter(request, prefix	+ "o_lgs_cost_cd", length));
			String[] vndCmGroup = (JSPUtil.getParameter(request, prefix	+ "vnd_cm_group", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] oFuelRto = (JSPUtil.getParameter(request, prefix	+ "o_fuel_rto", length));
			String[] rcvMsg = (JSPUtil.getParameter(request, prefix	+ "rcv_msg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] maxRcvMsgSeq = (JSPUtil.getParameter(request, prefix	+ "max_rcv_msg_seq", length));
			String[] oLgsCostCdNm = (JSPUtil.getParameter(request, prefix	+ "o_lgs_cost_cd_nm", length));
			String[] nRcvAmt = (JSPUtil.getParameter(request, prefix	+ "n_rcv_amt", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] ibcheck = (JSPUtil.getParameter(request, prefix	+ "ibcheck", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] oCurrCd = (JSPUtil.getParameter(request, prefix	+ "o_curr_cd", length));
			String[] rcvMsgTpCdNm = (JSPUtil.getParameter(request, prefix	+ "rcv_msg_tp_cd_nm", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] intgCdValDpSeq = (JSPUtil.getParameter(request, prefix	+ "intg_cd_val_dp_seq", length));
			String[] trspWoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_seq", length));
			String[] nLgsCostCdNm = (JSPUtil.getParameter(request, prefix	+ "n_lgs_cost_cd_nm", length));
			String[] loclCreDt = (JSPUtil.getParameter(request, prefix	+ "locl_cre_dt", length));
			String[] rcvMsgSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_msg_seq", length));
			String[] rcvMsgStsCd = (JSPUtil.getParameter(request, prefix	+ "rcv_msg_sts_cd", length));
			String[] ediRjctRsnCd = (JSPUtil.getParameter(request, prefix	+ "edi_rjct_rsn_cd", length));
			String[] ediRjctRsnCdNm = (JSPUtil.getParameter(request, prefix	+ "edi_rjct_rsn_cd_nm", length));
			String[] nFuelRto = (JSPUtil.getParameter(request, prefix	+ "n_fuel_rto", length));
			String[] trspWoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_ofc_cty_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] nLgsCostCd = (JSPUtil.getParameter(request, prefix	+ "n_lgs_cost_cd", length));
			String[] oRcvAmt = (JSPUtil.getParameter(request, prefix	+ "o_rcv_amt", length));
			String[] eqCopNo = (JSPUtil.getParameter(request, prefix	+ "eq_cop_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchJoEdiRcvMsgListVO();
				if (rcvMsgTpCd[i] != null)
					model.setRcvMsgTpCd(rcvMsgTpCd[i]);
				if (nCurrCd[i] != null)
					model.setNCurrCd(nCurrCd[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (oLgsCostCd[i] != null)
					model.setOLgsCostCd(oLgsCostCd[i]);
				if (vndCmGroup[i] != null)
					model.setVndCmGroup(vndCmGroup[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (oFuelRto[i] != null)
					model.setOFuelRto(oFuelRto[i]);
				if (rcvMsg[i] != null)
					model.setRcvMsg(rcvMsg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (maxRcvMsgSeq[i] != null)
					model.setMaxRcvMsgSeq(maxRcvMsgSeq[i]);
				if (oLgsCostCdNm[i] != null)
					model.setOLgsCostCdNm(oLgsCostCdNm[i]);
				if (nRcvAmt[i] != null)
					model.setNRcvAmt(nRcvAmt[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (ibcheck[i] != null)
					model.setIbcheck(ibcheck[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (oCurrCd[i] != null)
					model.setOCurrCd(oCurrCd[i]);
				if (rcvMsgTpCdNm[i] != null)
					model.setRcvMsgTpCdNm(rcvMsgTpCdNm[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (intgCdValDpSeq[i] != null)
					model.setIntgCdValDpSeq(intgCdValDpSeq[i]);
				if (trspWoSeq[i] != null)
					model.setTrspWoSeq(trspWoSeq[i]);
				if (nLgsCostCdNm[i] != null)
					model.setNLgsCostCdNm(nLgsCostCdNm[i]);
				if (loclCreDt[i] != null)
					model.setLoclCreDt(loclCreDt[i]);
				if (rcvMsgSeq[i] != null)
					model.setRcvMsgSeq(rcvMsgSeq[i]);
				if (rcvMsgStsCd[i] != null)
					model.setRcvMsgStsCd(rcvMsgStsCd[i]);
				if (ediRjctRsnCd[i] != null)
					model.setEdiRjctRsnCd(ediRjctRsnCd[i]);
				if (ediRjctRsnCdNm[i] != null)
					model.setEdiRjctRsnCdNm(ediRjctRsnCdNm[i]);
				if (nFuelRto[i] != null)
					model.setNFuelRto(nFuelRto[i]);
				if (trspWoOfcCtyCd[i] != null)
					model.setTrspWoOfcCtyCd(trspWoOfcCtyCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (nLgsCostCd[i] != null)
					model.setNLgsCostCd(nLgsCostCd[i]);
				if (oRcvAmt[i] != null)
					model.setORcvAmt(oRcvAmt[i]);
				if (eqCopNo[i] != null)
					model.setEqCopNo(eqCopNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchJoEdiRcvMsgListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchJoEdiRcvMsgListVO[]
	 */
	public SearchJoEdiRcvMsgListVO[] getSearchJoEdiRcvMsgListVOs(){
		SearchJoEdiRcvMsgListVO[] vos = (SearchJoEdiRcvMsgListVO[])models.toArray(new SearchJoEdiRcvMsgListVO[models.size()]);
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
		this.rcvMsgTpCd = this.rcvMsgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCurrCd = this.nCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oLgsCostCd = this.oLgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndCmGroup = this.vndCmGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oFuelRto = this.oFuelRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvMsg = this.rcvMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxRcvMsgSeq = this.maxRcvMsgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oLgsCostCdNm = this.oLgsCostCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nRcvAmt = this.nRcvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibcheck = this.ibcheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oCurrCd = this.oCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvMsgTpCdNm = this.rcvMsgTpCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdValDpSeq = this.intgCdValDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoSeq = this.trspWoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nLgsCostCdNm = this.nLgsCostCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCreDt = this.loclCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvMsgSeq = this.rcvMsgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvMsgStsCd = this.rcvMsgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRjctRsnCd = this.ediRjctRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRjctRsnCdNm = this.ediRjctRsnCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nFuelRto = this.nFuelRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCd = this.trspWoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nLgsCostCd = this.nLgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oRcvAmt = this.oRcvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCopNo = this.eqCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
