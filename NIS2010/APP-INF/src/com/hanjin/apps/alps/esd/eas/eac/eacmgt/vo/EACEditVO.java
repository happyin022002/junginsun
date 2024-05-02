/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EACEditVO.java
*@FileTitle : EACEditVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.14
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.07.14 신동일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 신동일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EACEditVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EACEditVO> models = new ArrayList<EACEditVO>();
	
	/* Column Info */
	private String eacUsrNm = null;
	/* Column Info */
	private String audrOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eacStsNm = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String eacAproTpNm = null;
	/* Column Info */
	private String rjctDesc = null;
	/* Column Info */
	private String n3ptySrcDt = null;
	/* Column Info */
	private String eacUsrCode = null;
	/* Column Info */
	private String cmplUsrNm = null;
	/* Column Info */
	private String eacBilTpNm = null;
	/* Column Info */
	private String eacTpNm = null;
	/* Column Info */
	private String stlAmt = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* Column Info */
	private String eacCmplNm = null;
	/* Column Info */
	private String n3ptyStsNm = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String eacEvidDesc = null;
	/* Column Info */
	private String rjctUsrNm = null;
	/* Column Info */
	private String eacUsrId = null;
	/* Column Info */
	private String rhqCnfmUsrNm = null;
	/* Column Info */
	private String eacCostDesc = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String eacRsnNm = null;
	/* Column Info */
	private String eacRsnDesc = null;
	/* Column Info */
	private String eacStsDt = null;
	/* Column Info */
	private String expnEvidDesc = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String n3ptyAmt = null;
	/* Column Info */
	private String hqCnfmUsrNm = null;
	/* Column Info */
	private String eacInpDt = null;
	/* Column Info */
	private String vvdCdCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eacCmplDt = null;
	/* Column Info */
	private String invAudUsdAmt = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String eacDesc = null;
	/* Column Info */
	private String kpiOfcCd = null;
	/* Column Info */
	private String eacExpnTpNm = null;
	/* Column Info */
	private String invCngAmt = null;
	/* Column Info */
	private String eacSysIfCd = null;
	/* Column Info */
	private String eacYrmon = null;
	/* Column Info */
	private String deltUsrNm = null;
	/* Column Info */
	private String eacNo = null;
	/* Column Info */
	private String audrUsrNm = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String eacInterRmk = null;
	/* Column Info */
	private String respbOfcCd = null;
	/* Column Info */
	private String woNoCtnt = null;
	/* Column Info */
	private String n3ptySrcNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EACEditVO() {}

	public EACEditVO(String ibflag, String pagerows, String eacStsDt, String eacUsrNm, String audrOfcCd, String eacStsNm, String vndrNm, String eacAproTpNm, String rjctDesc, String n3ptySrcDt, String eacUsrCode, String cmplUsrNm, String eacBilTpNm, String stlAmt, String eacTpNm, String rhqOfcCd, String n3ptyStsNm, String eacCmplNm, String rjctUsrNm, String eacEvidDesc, String bkgNo, String eacUsrId, String vndrSeq, String eacCostDesc, String rhqCnfmUsrNm, String eacRsnNm, String eacRsnDesc, String expnEvidDesc, String currCd, String n3ptyAmt, String hqCnfmUsrNm, String eacInpDt, String vvdCdCtnt, String eacCmplDt, String invAudUsdAmt, String n3ptyNo, String invAmt, String eacDesc, String kpiOfcCd, String eacExpnTpNm, String invCngAmt, String eacSysIfCd, String eacYrmon, String deltUsrNm, String eacNo, String audrUsrNm, String ydCd, String eacInterRmk, String respbOfcCd, String woNoCtnt, String n3ptySrcNo) {
		this.eacUsrNm = eacUsrNm;
		this.audrOfcCd = audrOfcCd;
		this.pagerows = pagerows;
		this.eacStsNm = eacStsNm;
		this.vndrNm = vndrNm;
		this.eacAproTpNm = eacAproTpNm;
		this.rjctDesc = rjctDesc;
		this.n3ptySrcDt = n3ptySrcDt;
		this.eacUsrCode = eacUsrCode;
		this.cmplUsrNm = cmplUsrNm;
		this.eacBilTpNm = eacBilTpNm;
		this.eacTpNm = eacTpNm;
		this.stlAmt = stlAmt;
		this.rhqOfcCd = rhqOfcCd;
		this.eacCmplNm = eacCmplNm;
		this.n3ptyStsNm = n3ptyStsNm;
		this.bkgNo = bkgNo;
		this.eacEvidDesc = eacEvidDesc;
		this.rjctUsrNm = rjctUsrNm;
		this.eacUsrId = eacUsrId;
		this.rhqCnfmUsrNm = rhqCnfmUsrNm;
		this.eacCostDesc = eacCostDesc;
		this.vndrSeq = vndrSeq;
		this.eacRsnNm = eacRsnNm;
		this.eacRsnDesc = eacRsnDesc;
		this.eacStsDt = eacStsDt;
		this.expnEvidDesc = expnEvidDesc;
		this.currCd = currCd;
		this.n3ptyAmt = n3ptyAmt;
		this.hqCnfmUsrNm = hqCnfmUsrNm;
		this.eacInpDt = eacInpDt;
		this.vvdCdCtnt = vvdCdCtnt;
		this.ibflag = ibflag;
		this.eacCmplDt = eacCmplDt;
		this.invAudUsdAmt = invAudUsdAmt;
		this.n3ptyNo = n3ptyNo;
		this.invAmt = invAmt;
		this.eacDesc = eacDesc;
		this.kpiOfcCd = kpiOfcCd;
		this.eacExpnTpNm = eacExpnTpNm;
		this.invCngAmt = invCngAmt;
		this.eacSysIfCd = eacSysIfCd;
		this.eacYrmon = eacYrmon;
		this.deltUsrNm = deltUsrNm;
		this.eacNo = eacNo;
		this.audrUsrNm = audrUsrNm;
		this.ydCd = ydCd;
		this.eacInterRmk = eacInterRmk;
		this.respbOfcCd = respbOfcCd;
		this.woNoCtnt = woNoCtnt;
		this.n3ptySrcNo = n3ptySrcNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eac_usr_nm", getEacUsrNm());
		this.hashColumns.put("audr_ofc_cd", getAudrOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eac_sts_nm", getEacStsNm());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("eac_apro_tp_nm", getEacAproTpNm());
		this.hashColumns.put("rjct_desc", getRjctDesc());
		this.hashColumns.put("n3pty_src_dt", getN3ptySrcDt());
		this.hashColumns.put("eac_usr_code", getEacUsrCode());
		this.hashColumns.put("cmpl_usr_nm", getCmplUsrNm());
		this.hashColumns.put("eac_bil_tp_nm", getEacBilTpNm());
		this.hashColumns.put("eac_tp_nm", getEacTpNm());
		this.hashColumns.put("stl_amt", getStlAmt());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("eac_cmpl_nm", getEacCmplNm());
		this.hashColumns.put("n3pty_sts_nm", getN3ptyStsNm());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("eac_evid_desc", getEacEvidDesc());
		this.hashColumns.put("rjct_usr_nm", getRjctUsrNm());
		this.hashColumns.put("eac_usr_id", getEacUsrId());
		this.hashColumns.put("rhq_cnfm_usr_nm", getRhqCnfmUsrNm());
		this.hashColumns.put("eac_cost_desc", getEacCostDesc());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("eac_rsn_nm", getEacRsnNm());
		this.hashColumns.put("eac_rsn_desc", getEacRsnDesc());
		this.hashColumns.put("eac_sts_dt", getEacStsDt());
		this.hashColumns.put("expn_evid_desc", getExpnEvidDesc());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("n3pty_amt", getN3ptyAmt());
		this.hashColumns.put("hq_cnfm_usr_nm", getHqCnfmUsrNm());
		this.hashColumns.put("eac_inp_dt", getEacInpDt());
		this.hashColumns.put("vvd_cd_ctnt", getVvdCdCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eac_cmpl_dt", getEacCmplDt());
		this.hashColumns.put("inv_aud_usd_amt", getInvAudUsdAmt());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("eac_desc", getEacDesc());
		this.hashColumns.put("kpi_ofc_cd", getKpiOfcCd());
		this.hashColumns.put("eac_expn_tp_nm", getEacExpnTpNm());
		this.hashColumns.put("inv_cng_amt", getInvCngAmt());
		this.hashColumns.put("eac_sys_if_cd", getEacSysIfCd());
		this.hashColumns.put("eac_yrmon", getEacYrmon());
		this.hashColumns.put("delt_usr_nm", getDeltUsrNm());
		this.hashColumns.put("eac_no", getEacNo());
		this.hashColumns.put("audr_usr_nm", getAudrUsrNm());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("eac_inter_rmk", getEacInterRmk());
		this.hashColumns.put("respb_ofc_cd", getRespbOfcCd());
		this.hashColumns.put("wo_no_ctnt", getWoNoCtnt());
		this.hashColumns.put("n3pty_src_no", getN3ptySrcNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eac_usr_nm", "eacUsrNm");
		this.hashFields.put("audr_ofc_cd", "audrOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eac_sts_nm", "eacStsNm");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("eac_apro_tp_nm", "eacAproTpNm");
		this.hashFields.put("rjct_desc", "rjctDesc");
		this.hashFields.put("n3pty_src_dt", "n3ptySrcDt");
		this.hashFields.put("eac_usr_code", "eacUsrCode");
		this.hashFields.put("cmpl_usr_nm", "cmplUsrNm");
		this.hashFields.put("eac_bil_tp_nm", "eacBilTpNm");
		this.hashFields.put("eac_tp_nm", "eacTpNm");
		this.hashFields.put("stl_amt", "stlAmt");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("eac_cmpl_nm", "eacCmplNm");
		this.hashFields.put("n3pty_sts_nm", "n3ptyStsNm");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("eac_evid_desc", "eacEvidDesc");
		this.hashFields.put("rjct_usr_nm", "rjctUsrNm");
		this.hashFields.put("eac_usr_id", "eacUsrId");
		this.hashFields.put("rhq_cnfm_usr_nm", "rhqCnfmUsrNm");
		this.hashFields.put("eac_cost_desc", "eacCostDesc");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("eac_rsn_nm", "eacRsnNm");
		this.hashFields.put("eac_rsn_desc", "eacRsnDesc");
		this.hashFields.put("eac_sts_dt", "eacStsDt");
		this.hashFields.put("expn_evid_desc", "expnEvidDesc");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("n3pty_amt", "n3ptyAmt");
		this.hashFields.put("hq_cnfm_usr_nm", "hqCnfmUsrNm");
		this.hashFields.put("eac_inp_dt", "eacInpDt");
		this.hashFields.put("vvd_cd_ctnt", "vvdCdCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eac_cmpl_dt", "eacCmplDt");
		this.hashFields.put("inv_aud_usd_amt", "invAudUsdAmt");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("eac_desc", "eacDesc");
		this.hashFields.put("kpi_ofc_cd", "kpiOfcCd");
		this.hashFields.put("eac_expn_tp_nm", "eacExpnTpNm");
		this.hashFields.put("inv_cng_amt", "invCngAmt");
		this.hashFields.put("eac_sys_if_cd", "eacSysIfCd");
		this.hashFields.put("eac_yrmon", "eacYrmon");
		this.hashFields.put("delt_usr_nm", "deltUsrNm");
		this.hashFields.put("eac_no", "eacNo");
		this.hashFields.put("audr_usr_nm", "audrUsrNm");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("eac_inter_rmk", "eacInterRmk");
		this.hashFields.put("respb_ofc_cd", "respbOfcCd");
		this.hashFields.put("wo_no_ctnt", "woNoCtnt");
		this.hashFields.put("n3pty_src_no", "n3ptySrcNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eacUsrNm
	 */
	public String getEacUsrNm() {
		return this.eacUsrNm;
	}
	
	/**
	 * Column Info
	 * @return audrOfcCd
	 */
	public String getAudrOfcCd() {
		return this.audrOfcCd;
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
	 * @return eacStsNm
	 */
	public String getEacStsNm() {
		return this.eacStsNm;
	}
	
	/**
	 * Column Info
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return eacAproTpNm
	 */
	public String getEacAproTpNm() {
		return this.eacAproTpNm;
	}
	
	/**
	 * Column Info
	 * @return rjctDesc
	 */
	public String getRjctDesc() {
		return this.rjctDesc;
	}
	
	/**
	 * Column Info
	 * @return n3ptySrcDt
	 */
	public String getN3ptySrcDt() {
		return this.n3ptySrcDt;
	}
	
	/**
	 * Column Info
	 * @return eacUsrCode
	 */
	public String getEacUsrCode() {
		return this.eacUsrCode;
	}
	
	/**
	 * Column Info
	 * @return cmplUsrNm
	 */
	public String getCmplUsrNm() {
		return this.cmplUsrNm;
	}
	
	/**
	 * Column Info
	 * @return eacBilTpNm
	 */
	public String getEacBilTpNm() {
		return this.eacBilTpNm;
	}
	
	/**
	 * Column Info
	 * @return eacTpNm
	 */
	public String getEacTpNm() {
		return this.eacTpNm;
	}
	
	/**
	 * Column Info
	 * @return stlAmt
	 */
	public String getStlAmt() {
		return this.stlAmt;
	}
	
	/**
	 * Column Info
	 * @return rhqOfcCd
	 */
	public String getRhqOfcCd() {
		return this.rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return eacCmplNm
	 */
	public String getEacCmplNm() {
		return this.eacCmplNm;
	}
	
	/**
	 * Column Info
	 * @return n3ptyStsNm
	 */
	public String getN3ptyStsNm() {
		return this.n3ptyStsNm;
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
	 * @return eacEvidDesc
	 */
	public String getEacEvidDesc() {
		return this.eacEvidDesc;
	}
	
	/**
	 * Column Info
	 * @return rjctUsrNm
	 */
	public String getRjctUsrNm() {
		return this.rjctUsrNm;
	}
	
	/**
	 * Column Info
	 * @return eacUsrId
	 */
	public String getEacUsrId() {
		return this.eacUsrId;
	}
	
	/**
	 * Column Info
	 * @return rhqCnfmUsrNm
	 */
	public String getRhqCnfmUsrNm() {
		return this.rhqCnfmUsrNm;
	}
	
	/**
	 * Column Info
	 * @return eacCostDesc
	 */
	public String getEacCostDesc() {
		return this.eacCostDesc;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return eacRsnNm
	 */
	public String getEacRsnNm() {
		return this.eacRsnNm;
	}
	
	/**
	 * Column Info
	 * @return eacRsnDesc
	 */
	public String getEacRsnDesc() {
		return this.eacRsnDesc;
	}
	
	/**
	 * Column Info
	 * @return eacStsDt
	 */
	public String getEacStsDt() {
		return this.eacStsDt;
	}
	
	/**
	 * Column Info
	 * @return expnEvidDesc
	 */
	public String getExpnEvidDesc() {
		return this.expnEvidDesc;
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
	 * @return n3ptyAmt
	 */
	public String getN3ptyAmt() {
		return this.n3ptyAmt;
	}
	
	/**
	 * Column Info
	 * @return hqCnfmUsrNm
	 */
	public String getHqCnfmUsrNm() {
		return this.hqCnfmUsrNm;
	}
	
	/**
	 * Column Info
	 * @return eacInpDt
	 */
	public String getEacInpDt() {
		return this.eacInpDt;
	}
	
	/**
	 * Column Info
	 * @return vvdCdCtnt
	 */
	public String getVvdCdCtnt() {
		return this.vvdCdCtnt;
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
	 * @return eacCmplDt
	 */
	public String getEacCmplDt() {
		return this.eacCmplDt;
	}
	
	/**
	 * Column Info
	 * @return invAudUsdAmt
	 */
	public String getInvAudUsdAmt() {
		return this.invAudUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNo
	 */
	public String getN3ptyNo() {
		return this.n3ptyNo;
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
	 * @return eacDesc
	 */
	public String getEacDesc() {
		return this.eacDesc;
	}
	
	/**
	 * Column Info
	 * @return kpiOfcCd
	 */
	public String getKpiOfcCd() {
		return this.kpiOfcCd;
	}
	
	/**
	 * Column Info
	 * @return eacExpnTpNm
	 */
	public String getEacExpnTpNm() {
		return this.eacExpnTpNm;
	}
	
	/**
	 * Column Info
	 * @return invCngAmt
	 */
	public String getInvCngAmt() {
		return this.invCngAmt;
	}
	
	/**
	 * Column Info
	 * @return eacSysIfCd
	 */
	public String getEacSysIfCd() {
		return this.eacSysIfCd;
	}
	
	/**
	 * Column Info
	 * @return eacYrmon
	 */
	public String getEacYrmon() {
		return this.eacYrmon;
	}
	
	/**
	 * Column Info
	 * @return deltUsrNm
	 */
	public String getDeltUsrNm() {
		return this.deltUsrNm;
	}
	
	/**
	 * Column Info
	 * @return eacNo
	 */
	public String getEacNo() {
		return this.eacNo;
	}
	
	/**
	 * Column Info
	 * @return audrUsrNm
	 */
	public String getAudrUsrNm() {
		return this.audrUsrNm;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return eacInterRmk
	 */
	public String getEacInterRmk() {
		return this.eacInterRmk;
	}
	
	/**
	 * Column Info
	 * @return respbOfcCd
	 */
	public String getRespbOfcCd() {
		return this.respbOfcCd;
	}
	
	/**
	 * Column Info
	 * @return woNoCtnt
	 */
	public String getWoNoCtnt() {
		return this.woNoCtnt;
	}
	
	/**
	 * Column Info
	 * @return n3ptySrcNo
	 */
	public String getN3ptySrcNo() {
		return this.n3ptySrcNo;
	}
	

	/**
	 * Column Info
	 * @param eacUsrNm
	 */
	public void setEacUsrNm(String eacUsrNm) {
		this.eacUsrNm = eacUsrNm;
	}
	
	/**
	 * Column Info
	 * @param audrOfcCd
	 */
	public void setAudrOfcCd(String audrOfcCd) {
		this.audrOfcCd = audrOfcCd;
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
	 * @param eacStsNm
	 */
	public void setEacStsNm(String eacStsNm) {
		this.eacStsNm = eacStsNm;
	}
	
	/**
	 * Column Info
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param eacAproTpNm
	 */
	public void setEacAproTpNm(String eacAproTpNm) {
		this.eacAproTpNm = eacAproTpNm;
	}
	
	/**
	 * Column Info
	 * @param rjctDesc
	 */
	public void setRjctDesc(String rjctDesc) {
		this.rjctDesc = rjctDesc;
	}
	
	/**
	 * Column Info
	 * @param n3ptySrcDt
	 */
	public void setN3ptySrcDt(String n3ptySrcDt) {
		this.n3ptySrcDt = n3ptySrcDt;
	}
	
	/**
	 * Column Info
	 * @param eacUsrCode
	 */
	public void setEacUsrCode(String eacUsrCode) {
		this.eacUsrCode = eacUsrCode;
	}
	
	/**
	 * Column Info
	 * @param cmplUsrNm
	 */
	public void setCmplUsrNm(String cmplUsrNm) {
		this.cmplUsrNm = cmplUsrNm;
	}
	
	/**
	 * Column Info
	 * @param eacBilTpNm
	 */
	public void setEacBilTpNm(String eacBilTpNm) {
		this.eacBilTpNm = eacBilTpNm;
	}
	
	/**
	 * Column Info
	 * @param eacTpNm
	 */
	public void setEacTpNm(String eacTpNm) {
		this.eacTpNm = eacTpNm;
	}
	
	/**
	 * Column Info
	 * @param stlAmt
	 */
	public void setStlAmt(String stlAmt) {
		this.stlAmt = stlAmt;
	}
	
	/**
	 * Column Info
	 * @param rhqOfcCd
	 */
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param eacCmplNm
	 */
	public void setEacCmplNm(String eacCmplNm) {
		this.eacCmplNm = eacCmplNm;
	}
	
	/**
	 * Column Info
	 * @param n3ptyStsNm
	 */
	public void setN3ptyStsNm(String n3ptyStsNm) {
		this.n3ptyStsNm = n3ptyStsNm;
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
	 * @param eacEvidDesc
	 */
	public void setEacEvidDesc(String eacEvidDesc) {
		this.eacEvidDesc = eacEvidDesc;
	}
	
	/**
	 * Column Info
	 * @param rjctUsrNm
	 */
	public void setRjctUsrNm(String rjctUsrNm) {
		this.rjctUsrNm = rjctUsrNm;
	}
	
	/**
	 * Column Info
	 * @param eacUsrId
	 */
	public void setEacUsrId(String eacUsrId) {
		this.eacUsrId = eacUsrId;
	}
	
	/**
	 * Column Info
	 * @param rhqCnfmUsrNm
	 */
	public void setRhqCnfmUsrNm(String rhqCnfmUsrNm) {
		this.rhqCnfmUsrNm = rhqCnfmUsrNm;
	}
	
	/**
	 * Column Info
	 * @param eacCostDesc
	 */
	public void setEacCostDesc(String eacCostDesc) {
		this.eacCostDesc = eacCostDesc;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param eacRsnNm
	 */
	public void setEacRsnNm(String eacRsnNm) {
		this.eacRsnNm = eacRsnNm;
	}
	
	/**
	 * Column Info
	 * @param eacRsnDesc
	 */
	public void setEacRsnDesc(String eacRsnDesc) {
		this.eacRsnDesc = eacRsnDesc;
	}
	
	/**
	 * Column Info
	 * @param eacStsDt
	 */
	public void setEacStsDt(String eacStsDt) {
		this.eacStsDt = eacStsDt;
	}
	
	/**
	 * Column Info
	 * @param expnEvidDesc
	 */
	public void setExpnEvidDesc(String expnEvidDesc) {
		this.expnEvidDesc = expnEvidDesc;
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
	 * @param n3ptyAmt
	 */
	public void setN3ptyAmt(String n3ptyAmt) {
		this.n3ptyAmt = n3ptyAmt;
	}
	
	/**
	 * Column Info
	 * @param hqCnfmUsrNm
	 */
	public void setHqCnfmUsrNm(String hqCnfmUsrNm) {
		this.hqCnfmUsrNm = hqCnfmUsrNm;
	}
	
	/**
	 * Column Info
	 * @param eacInpDt
	 */
	public void setEacInpDt(String eacInpDt) {
		this.eacInpDt = eacInpDt;
	}
	
	/**
	 * Column Info
	 * @param vvdCdCtnt
	 */
	public void setVvdCdCtnt(String vvdCdCtnt) {
		this.vvdCdCtnt = vvdCdCtnt;
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
	 * @param eacCmplDt
	 */
	public void setEacCmplDt(String eacCmplDt) {
		this.eacCmplDt = eacCmplDt;
	}
	
	/**
	 * Column Info
	 * @param invAudUsdAmt
	 */
	public void setInvAudUsdAmt(String invAudUsdAmt) {
		this.invAudUsdAmt = invAudUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNo
	 */
	public void setN3ptyNo(String n3ptyNo) {
		this.n3ptyNo = n3ptyNo;
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
	 * @param eacDesc
	 */
	public void setEacDesc(String eacDesc) {
		this.eacDesc = eacDesc;
	}
	
	/**
	 * Column Info
	 * @param kpiOfcCd
	 */
	public void setKpiOfcCd(String kpiOfcCd) {
		this.kpiOfcCd = kpiOfcCd;
	}
	
	/**
	 * Column Info
	 * @param eacExpnTpNm
	 */
	public void setEacExpnTpNm(String eacExpnTpNm) {
		this.eacExpnTpNm = eacExpnTpNm;
	}
	
	/**
	 * Column Info
	 * @param invCngAmt
	 */
	public void setInvCngAmt(String invCngAmt) {
		this.invCngAmt = invCngAmt;
	}
	
	/**
	 * Column Info
	 * @param eacSysIfCd
	 */
	public void setEacSysIfCd(String eacSysIfCd) {
		this.eacSysIfCd = eacSysIfCd;
	}
	
	/**
	 * Column Info
	 * @param eacYrmon
	 */
	public void setEacYrmon(String eacYrmon) {
		this.eacYrmon = eacYrmon;
	}
	
	/**
	 * Column Info
	 * @param deltUsrNm
	 */
	public void setDeltUsrNm(String deltUsrNm) {
		this.deltUsrNm = deltUsrNm;
	}
	
	/**
	 * Column Info
	 * @param eacNo
	 */
	public void setEacNo(String eacNo) {
		this.eacNo = eacNo;
	}
	
	/**
	 * Column Info
	 * @param audrUsrNm
	 */
	public void setAudrUsrNm(String audrUsrNm) {
		this.audrUsrNm = audrUsrNm;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param eacInterRmk
	 */
	public void setEacInterRmk(String eacInterRmk) {
		this.eacInterRmk = eacInterRmk;
	}
	
	/**
	 * Column Info
	 * @param respbOfcCd
	 */
	public void setRespbOfcCd(String respbOfcCd) {
		this.respbOfcCd = respbOfcCd;
	}
	
	/**
	 * Column Info
	 * @param woNoCtnt
	 */
	public void setWoNoCtnt(String woNoCtnt) {
		this.woNoCtnt = woNoCtnt;
	}
	
	/**
	 * Column Info
	 * @param n3ptySrcNo
	 */
	public void setN3ptySrcNo(String n3ptySrcNo) {
		this.n3ptySrcNo = n3ptySrcNo;
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
		setEacUsrNm(JSPUtil.getParameter(request, prefix + "eac_usr_nm", ""));
		setAudrOfcCd(JSPUtil.getParameter(request, prefix + "audr_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEacStsNm(JSPUtil.getParameter(request, prefix + "eac_sts_nm", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setEacAproTpNm(JSPUtil.getParameter(request, prefix + "eac_apro_tp_nm", ""));
		setRjctDesc(JSPUtil.getParameter(request, prefix + "rjct_desc", ""));
		setN3ptySrcDt(JSPUtil.getParameter(request, prefix + "n3pty_src_dt", ""));
		setEacUsrCode(JSPUtil.getParameter(request, prefix + "eac_usr_code", ""));
		setCmplUsrNm(JSPUtil.getParameter(request, prefix + "cmpl_usr_nm", ""));
		setEacBilTpNm(JSPUtil.getParameter(request, prefix + "eac_bil_tp_nm", ""));
		setEacTpNm(JSPUtil.getParameter(request, prefix + "eac_tp_nm", ""));
		setStlAmt(JSPUtil.getParameter(request, prefix + "stl_amt", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setEacCmplNm(JSPUtil.getParameter(request, prefix + "eac_cmpl_nm", ""));
		setN3ptyStsNm(JSPUtil.getParameter(request, prefix + "n3pty_sts_nm", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setEacEvidDesc(JSPUtil.getParameter(request, prefix + "eac_evid_desc", ""));
		setRjctUsrNm(JSPUtil.getParameter(request, prefix + "rjct_usr_nm", ""));
		setEacUsrId(JSPUtil.getParameter(request, prefix + "eac_usr_id", ""));
		setRhqCnfmUsrNm(JSPUtil.getParameter(request, prefix + "rhq_cnfm_usr_nm", ""));
		setEacCostDesc(JSPUtil.getParameter(request, prefix + "eac_cost_desc", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setEacRsnNm(JSPUtil.getParameter(request, prefix + "eac_rsn_nm", ""));
		setEacRsnDesc(JSPUtil.getParameter(request, prefix + "eac_rsn_desc", ""));
		setEacStsDt(JSPUtil.getParameter(request, prefix + "eac_sts_dt", ""));
		setExpnEvidDesc(JSPUtil.getParameter(request, prefix + "expn_evid_desc", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setN3ptyAmt(JSPUtil.getParameter(request, prefix + "n3pty_amt", ""));
		setHqCnfmUsrNm(JSPUtil.getParameter(request, prefix + "hq_cnfm_usr_nm", ""));
		setEacInpDt(JSPUtil.getParameter(request, prefix + "eac_inp_dt", ""));
		setVvdCdCtnt(JSPUtil.getParameter(request, prefix + "vvd_cd_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEacCmplDt(JSPUtil.getParameter(request, prefix + "eac_cmpl_dt", ""));
		setInvAudUsdAmt(JSPUtil.getParameter(request, prefix + "inv_aud_usd_amt", ""));
		setN3ptyNo(JSPUtil.getParameter(request, prefix + "n3pty_no", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setEacDesc(JSPUtil.getParameter(request, prefix + "eac_desc", ""));
		setKpiOfcCd(JSPUtil.getParameter(request, prefix + "kpi_ofc_cd", ""));
		setEacExpnTpNm(JSPUtil.getParameter(request, prefix + "eac_expn_tp_nm", ""));
		setInvCngAmt(JSPUtil.getParameter(request, prefix + "inv_cng_amt", ""));
		setEacSysIfCd(JSPUtil.getParameter(request, prefix + "eac_sys_if_cd", ""));
		setEacYrmon(JSPUtil.getParameter(request, prefix + "eac_yrmon", ""));
		setDeltUsrNm(JSPUtil.getParameter(request, prefix + "delt_usr_nm", ""));
		setEacNo(JSPUtil.getParameter(request, prefix + "eac_no", ""));
		setAudrUsrNm(JSPUtil.getParameter(request, prefix + "audr_usr_nm", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setEacInterRmk(JSPUtil.getParameter(request, prefix + "eac_inter_rmk", ""));
		setRespbOfcCd(JSPUtil.getParameter(request, prefix + "respb_ofc_cd", ""));
		setWoNoCtnt(JSPUtil.getParameter(request, prefix + "wo_no_ctnt", ""));
		setN3ptySrcNo(JSPUtil.getParameter(request, prefix + "n3pty_src_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EACEditVO[]
	 */
	public EACEditVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EACEditVO[]
	 */
	public EACEditVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EACEditVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eacUsrNm = (JSPUtil.getParameter(request, prefix	+ "eac_usr_nm", length));
			String[] audrOfcCd = (JSPUtil.getParameter(request, prefix	+ "audr_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eacStsNm = (JSPUtil.getParameter(request, prefix	+ "eac_sts_nm", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] eacAproTpNm = (JSPUtil.getParameter(request, prefix	+ "eac_apro_tp_nm", length));
			String[] rjctDesc = (JSPUtil.getParameter(request, prefix	+ "rjct_desc", length));
			String[] n3ptySrcDt = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_dt", length));
			String[] eacUsrCode = (JSPUtil.getParameter(request, prefix	+ "eac_usr_code", length));
			String[] cmplUsrNm = (JSPUtil.getParameter(request, prefix	+ "cmpl_usr_nm", length));
			String[] eacBilTpNm = (JSPUtil.getParameter(request, prefix	+ "eac_bil_tp_nm", length));
			String[] eacTpNm = (JSPUtil.getParameter(request, prefix	+ "eac_tp_nm", length));
			String[] stlAmt = (JSPUtil.getParameter(request, prefix	+ "stl_amt", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] eacCmplNm = (JSPUtil.getParameter(request, prefix	+ "eac_cmpl_nm", length));
			String[] n3ptyStsNm = (JSPUtil.getParameter(request, prefix	+ "n3pty_sts_nm", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] eacEvidDesc = (JSPUtil.getParameter(request, prefix	+ "eac_evid_desc", length));
			String[] rjctUsrNm = (JSPUtil.getParameter(request, prefix	+ "rjct_usr_nm", length));
			String[] eacUsrId = (JSPUtil.getParameter(request, prefix	+ "eac_usr_id", length));
			String[] rhqCnfmUsrNm = (JSPUtil.getParameter(request, prefix	+ "rhq_cnfm_usr_nm", length));
			String[] eacCostDesc = (JSPUtil.getParameter(request, prefix	+ "eac_cost_desc", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] eacRsnNm = (JSPUtil.getParameter(request, prefix	+ "eac_rsn_nm", length));
			String[] eacRsnDesc = (JSPUtil.getParameter(request, prefix	+ "eac_rsn_desc", length));
			String[] eacStsDt = (JSPUtil.getParameter(request, prefix	+ "eac_sts_dt", length));
			String[] expnEvidDesc = (JSPUtil.getParameter(request, prefix	+ "expn_evid_desc", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] n3ptyAmt = (JSPUtil.getParameter(request, prefix	+ "n3pty_amt", length));
			String[] hqCnfmUsrNm = (JSPUtil.getParameter(request, prefix	+ "hq_cnfm_usr_nm", length));
			String[] eacInpDt = (JSPUtil.getParameter(request, prefix	+ "eac_inp_dt", length));
			String[] vvdCdCtnt = (JSPUtil.getParameter(request, prefix	+ "vvd_cd_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eacCmplDt = (JSPUtil.getParameter(request, prefix	+ "eac_cmpl_dt", length));
			String[] invAudUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inv_aud_usd_amt", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] eacDesc = (JSPUtil.getParameter(request, prefix	+ "eac_desc", length));
			String[] kpiOfcCd = (JSPUtil.getParameter(request, prefix	+ "kpi_ofc_cd", length));
			String[] eacExpnTpNm = (JSPUtil.getParameter(request, prefix	+ "eac_expn_tp_nm", length));
			String[] invCngAmt = (JSPUtil.getParameter(request, prefix	+ "inv_cng_amt", length));
			String[] eacSysIfCd = (JSPUtil.getParameter(request, prefix	+ "eac_sys_if_cd", length));
			String[] eacYrmon = (JSPUtil.getParameter(request, prefix	+ "eac_yrmon", length));
			String[] deltUsrNm = (JSPUtil.getParameter(request, prefix	+ "delt_usr_nm", length));
			String[] eacNo = (JSPUtil.getParameter(request, prefix	+ "eac_no", length));
			String[] audrUsrNm = (JSPUtil.getParameter(request, prefix	+ "audr_usr_nm", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] eacInterRmk = (JSPUtil.getParameter(request, prefix	+ "eac_inter_rmk", length));
			String[] respbOfcCd = (JSPUtil.getParameter(request, prefix	+ "respb_ofc_cd", length));
			String[] woNoCtnt = (JSPUtil.getParameter(request, prefix	+ "wo_no_ctnt", length));
			String[] n3ptySrcNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new EACEditVO();
				if (eacUsrNm[i] != null)
					model.setEacUsrNm(eacUsrNm[i]);
				if (audrOfcCd[i] != null)
					model.setAudrOfcCd(audrOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eacStsNm[i] != null)
					model.setEacStsNm(eacStsNm[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (eacAproTpNm[i] != null)
					model.setEacAproTpNm(eacAproTpNm[i]);
				if (rjctDesc[i] != null)
					model.setRjctDesc(rjctDesc[i]);
				if (n3ptySrcDt[i] != null)
					model.setN3ptySrcDt(n3ptySrcDt[i]);
				if (eacUsrCode[i] != null)
					model.setEacUsrCode(eacUsrCode[i]);
				if (cmplUsrNm[i] != null)
					model.setCmplUsrNm(cmplUsrNm[i]);
				if (eacBilTpNm[i] != null)
					model.setEacBilTpNm(eacBilTpNm[i]);
				if (eacTpNm[i] != null)
					model.setEacTpNm(eacTpNm[i]);
				if (stlAmt[i] != null)
					model.setStlAmt(stlAmt[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (eacCmplNm[i] != null)
					model.setEacCmplNm(eacCmplNm[i]);
				if (n3ptyStsNm[i] != null)
					model.setN3ptyStsNm(n3ptyStsNm[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (eacEvidDesc[i] != null)
					model.setEacEvidDesc(eacEvidDesc[i]);
				if (rjctUsrNm[i] != null)
					model.setRjctUsrNm(rjctUsrNm[i]);
				if (eacUsrId[i] != null)
					model.setEacUsrId(eacUsrId[i]);
				if (rhqCnfmUsrNm[i] != null)
					model.setRhqCnfmUsrNm(rhqCnfmUsrNm[i]);
				if (eacCostDesc[i] != null)
					model.setEacCostDesc(eacCostDesc[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (eacRsnNm[i] != null)
					model.setEacRsnNm(eacRsnNm[i]);
				if (eacRsnDesc[i] != null)
					model.setEacRsnDesc(eacRsnDesc[i]);
				if (eacStsDt[i] != null)
					model.setEacStsDt(eacStsDt[i]);
				if (expnEvidDesc[i] != null)
					model.setExpnEvidDesc(expnEvidDesc[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (n3ptyAmt[i] != null)
					model.setN3ptyAmt(n3ptyAmt[i]);
				if (hqCnfmUsrNm[i] != null)
					model.setHqCnfmUsrNm(hqCnfmUsrNm[i]);
				if (eacInpDt[i] != null)
					model.setEacInpDt(eacInpDt[i]);
				if (vvdCdCtnt[i] != null)
					model.setVvdCdCtnt(vvdCdCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eacCmplDt[i] != null)
					model.setEacCmplDt(eacCmplDt[i]);
				if (invAudUsdAmt[i] != null)
					model.setInvAudUsdAmt(invAudUsdAmt[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (eacDesc[i] != null)
					model.setEacDesc(eacDesc[i]);
				if (kpiOfcCd[i] != null)
					model.setKpiOfcCd(kpiOfcCd[i]);
				if (eacExpnTpNm[i] != null)
					model.setEacExpnTpNm(eacExpnTpNm[i]);
				if (invCngAmt[i] != null)
					model.setInvCngAmt(invCngAmt[i]);
				if (eacSysIfCd[i] != null)
					model.setEacSysIfCd(eacSysIfCd[i]);
				if (eacYrmon[i] != null)
					model.setEacYrmon(eacYrmon[i]);
				if (deltUsrNm[i] != null)
					model.setDeltUsrNm(deltUsrNm[i]);
				if (eacNo[i] != null)
					model.setEacNo(eacNo[i]);
				if (audrUsrNm[i] != null)
					model.setAudrUsrNm(audrUsrNm[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (eacInterRmk[i] != null)
					model.setEacInterRmk(eacInterRmk[i]);
				if (respbOfcCd[i] != null)
					model.setRespbOfcCd(respbOfcCd[i]);
				if (woNoCtnt[i] != null)
					model.setWoNoCtnt(woNoCtnt[i]);
				if (n3ptySrcNo[i] != null)
					model.setN3ptySrcNo(n3ptySrcNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEACEditVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EACEditVO[]
	 */
	public EACEditVO[] getEACEditVOs(){
		EACEditVO[] vos = (EACEditVO[])models.toArray(new EACEditVO[models.size()]);
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
		this.eacUsrNm = this.eacUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audrOfcCd = this.audrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacStsNm = this.eacStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacAproTpNm = this.eacAproTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rjctDesc = this.rjctDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcDt = this.n3ptySrcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacUsrCode = this.eacUsrCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmplUsrNm = this.cmplUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacBilTpNm = this.eacBilTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacTpNm = this.eacTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlAmt = this.stlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacCmplNm = this.eacCmplNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyStsNm = this.n3ptyStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacEvidDesc = this.eacEvidDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rjctUsrNm = this.rjctUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacUsrId = this.eacUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCnfmUsrNm = this.rhqCnfmUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacCostDesc = this.eacCostDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacRsnNm = this.eacRsnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacRsnDesc = this.eacRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacStsDt = this.eacStsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnEvidDesc = this.expnEvidDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyAmt = this.n3ptyAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hqCnfmUsrNm = this.hqCnfmUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacInpDt = this.eacInpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCdCtnt = this.vvdCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacCmplDt = this.eacCmplDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAudUsdAmt = this.invAudUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacDesc = this.eacDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiOfcCd = this.kpiOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacExpnTpNm = this.eacExpnTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCngAmt = this.invCngAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacSysIfCd = this.eacSysIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacYrmon = this.eacYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltUsrNm = this.deltUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacNo = this.eacNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audrUsrNm = this.audrUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacInterRmk = this.eacInterRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbOfcCd = this.respbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNoCtnt = this.woNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcNo = this.n3ptySrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
