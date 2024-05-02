/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RehandlingExpenseTorVsTpbVO.java
*@FileTitle : RehandlingExpenseTorVsTpbVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.30  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.expnaud.testoraud.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RehandlingExpenseTorVsTpbVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RehandlingExpenseTorVsTpbVO> models = new ArrayList<RehandlingExpenseTorVsTpbVO>();
	
	/* Column Info */
	private String position = null;
	/* Column Info */
	private String sRhqOfcCd = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String sBkgNo = null;
	/* Column Info */
	private String precell = null;
	/* Column Info */
	private String rhndExpnSeq = null;
	/* Column Info */
	private String party = null;
	/* Column Info */
	private String tpbStsNm = null;
	/* Column Info */
	private String sShiftRsn = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tpbOfc = null;
	/* Column Info */
	private String tpbNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sToDt = null;
	/* Column Info */
	private String sEacIf = null;
	/* Column Info */
	private String eacIfFlg = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String sFmDt = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String tpbPty3rd = null;
	/* Column Info */
	private String sOfcCd = null;
	/* Column Info */
	private String tpbAmtUsd = null;
	/* Column Info */
	private String shiftRsn = null;
	/* Column Info */
	private String sVvd = null;
	/* Column Info */
	private String sCntrNo = null;
	/* Column Info */
	private String sTrmnlCd = null;
	/* Column Info */
	private String sPortCd = null;
	/* Column Info */
	private String sTpbFlg = null;
	/* Column Info */
	private String fileAtch = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String respbCntrNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String actDepDt = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String sztp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RehandlingExpenseTorVsTpbVO() {}

	public RehandlingExpenseTorVsTpbVO(String ibflag, String pagerows, String sRhqOfcCd, String sOfcCd, String sFmDt, String sToDt, String sBkgNo, String sCntrNo, String sVvd, String sShiftRsn, String sTpbFlg, String sEacIf, String chk, String ofcCd, String portCd, String vvd, String clptIndSeq, String laneCd, String actDepDt, String cntrNo, String respbCntrNo, String sztp, String pol, String oprCd, String precell, String position, String shiftRsn, String party, String fileAtch, String tpbNo, String tpbAmtUsd, String tpbOfc, String tpbPty3rd, String tpbStsNm, String bkgNo, String eacIfFlg, String rhndExpnSeq, String sPortCd, String sTrmnlCd) {
		this.position = position;
		this.sRhqOfcCd = sRhqOfcCd;
		this.laneCd = laneCd;
		this.sBkgNo = sBkgNo;
		this.precell = precell;
		this.rhndExpnSeq = rhndExpnSeq;
		this.party = party;
		this.tpbStsNm = tpbStsNm;
		this.sShiftRsn = sShiftRsn;
		this.pagerows = pagerows;
		this.tpbOfc = tpbOfc;
		this.tpbNo = tpbNo;
		this.ibflag = ibflag;
		this.sToDt = sToDt;
		this.sEacIf = sEacIf;
		this.eacIfFlg = eacIfFlg;
		this.pol = pol;
		this.sFmDt = sFmDt;
		this.portCd = portCd;
		this.tpbPty3rd = tpbPty3rd;
		this.sOfcCd = sOfcCd;
		this.tpbAmtUsd = tpbAmtUsd;
		this.shiftRsn = shiftRsn;
		this.sVvd = sVvd;
		this.sCntrNo = sCntrNo;
		this.sTrmnlCd = sTrmnlCd;
		this.sPortCd = sPortCd;
		this.sTpbFlg = sTpbFlg;
		this.fileAtch = fileAtch;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.respbCntrNo = respbCntrNo;
		this.bkgNo = bkgNo;
		this.actDepDt = actDepDt;
		this.chk = chk;
		this.oprCd = oprCd;
		this.cntrNo = cntrNo;
		this.clptIndSeq = clptIndSeq;
		this.sztp = sztp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("position", getPosition());
		this.hashColumns.put("s_rhq_ofc_cd", getSRhqOfcCd());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("s_bkg_no", getSBkgNo());
		this.hashColumns.put("precell", getPrecell());
		this.hashColumns.put("rhnd_expn_seq", getRhndExpnSeq());
		this.hashColumns.put("party", getParty());
		this.hashColumns.put("tpb_sts_nm", getTpbStsNm());
		this.hashColumns.put("s_shift_rsn", getSShiftRsn());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tpb_ofc", getTpbOfc());
		this.hashColumns.put("tpb_no", getTpbNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_to_dt", getSToDt());
		this.hashColumns.put("s_eac_if", getSEacIf());
		this.hashColumns.put("eac_if_flg", getEacIfFlg());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("s_fm_dt", getSFmDt());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("tpb_pty_3rd", getTpbPty3rd());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("tpb_amt_usd", getTpbAmtUsd());
		this.hashColumns.put("shift_rsn", getShiftRsn());
		this.hashColumns.put("s_vvd", getSVvd());
		this.hashColumns.put("s_cntr_no", getSCntrNo());
		this.hashColumns.put("s_trmnl_cd", getSTrmnlCd());
		this.hashColumns.put("s_port_cd", getSPortCd());
		this.hashColumns.put("s_tpb_flg", getSTpbFlg());
		this.hashColumns.put("file_atch", getFileAtch());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("respb_cntr_no", getRespbCntrNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("act_dep_dt", getActDepDt());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("sztp", getSztp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("position", "position");
		this.hashFields.put("s_rhq_ofc_cd", "sRhqOfcCd");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("s_bkg_no", "sBkgNo");
		this.hashFields.put("precell", "precell");
		this.hashFields.put("rhnd_expn_seq", "rhndExpnSeq");
		this.hashFields.put("party", "party");
		this.hashFields.put("tpb_sts_nm", "tpbStsNm");
		this.hashFields.put("s_shift_rsn", "sShiftRsn");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tpb_ofc", "tpbOfc");
		this.hashFields.put("tpb_no", "tpbNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_to_dt", "sToDt");
		this.hashFields.put("s_eac_if", "sEacIf");
		this.hashFields.put("eac_if_flg", "eacIfFlg");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("s_fm_dt", "sFmDt");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("tpb_pty_3rd", "tpbPty3rd");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("tpb_amt_usd", "tpbAmtUsd");
		this.hashFields.put("shift_rsn", "shiftRsn");
		this.hashFields.put("s_vvd", "sVvd");
		this.hashFields.put("s_cntr_no", "sCntrNo");
		this.hashFields.put("s_trmnl_cd", "sTrmnlCd");
		this.hashFields.put("s_port_cd", "sPortCd");
		this.hashFields.put("s_tpb_flg", "sTpbFlg");
		this.hashFields.put("file_atch", "fileAtch");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("respb_cntr_no", "respbCntrNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("act_dep_dt", "actDepDt");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("sztp", "sztp");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return position
	 */
	public String getPosition() {
		return this.position;
	}
	
	/**
	 * Column Info
	 * @return sRhqOfcCd
	 */
	public String getSRhqOfcCd() {
		return this.sRhqOfcCd;
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
	 * @return sBkgNo
	 */
	public String getSBkgNo() {
		return this.sBkgNo;
	}
	
	/**
	 * Column Info
	 * @return precell
	 */
	public String getPrecell() {
		return this.precell;
	}
	
	/**
	 * Column Info
	 * @return rhndExpnSeq
	 */
	public String getRhndExpnSeq() {
		return this.rhndExpnSeq;
	}
	
	/**
	 * Column Info
	 * @return party
	 */
	public String getParty() {
		return this.party;
	}
	
	/**
	 * Column Info
	 * @return tpbStsNm
	 */
	public String getTpbStsNm() {
		return this.tpbStsNm;
	}
	
	/**
	 * Column Info
	 * @return sShiftRsn
	 */
	public String getSShiftRsn() {
		return this.sShiftRsn;
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
	 * @return tpbOfc
	 */
	public String getTpbOfc() {
		return this.tpbOfc;
	}
	
	/**
	 * Column Info
	 * @return tpbNo
	 */
	public String getTpbNo() {
		return this.tpbNo;
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
	 * @return sToDt
	 */
	public String getSToDt() {
		return this.sToDt;
	}
	
	/**
	 * Column Info
	 * @return sEacIf
	 */
	public String getSEacIf() {
		return this.sEacIf;
	}
	
	/**
	 * Column Info
	 * @return eacIfFlg
	 */
	public String getEacIfFlg() {
		return this.eacIfFlg;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return sFmDt
	 */
	public String getSFmDt() {
		return this.sFmDt;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return tpbPty3rd
	 */
	public String getTpbPty3rd() {
		return this.tpbPty3rd;
	}
	
	/**
	 * Column Info
	 * @return sOfcCd
	 */
	public String getSOfcCd() {
		return this.sOfcCd;
	}
	
	/**
	 * Column Info
	 * @return tpbAmtUsd
	 */
	public String getTpbAmtUsd() {
		return this.tpbAmtUsd;
	}
	
	/**
	 * Column Info
	 * @return shiftRsn
	 */
	public String getShiftRsn() {
		return this.shiftRsn;
	}
	
	/**
	 * Column Info
	 * @return sVvd
	 */
	public String getSVvd() {
		return this.sVvd;
	}
	
	/**
	 * Column Info
	 * @return sCntrNo
	 */
	public String getSCntrNo() {
		return this.sCntrNo;
	}
	
	/**
	 * Column Info
	 * @return sTrmnlCd
	 */
	public String getSTrmnlCd() {
		return this.sTrmnlCd;
	}
	
	/**
	 * Column Info
	 * @return sPortCd
	 */
	public String getSPortCd() {
		return this.sPortCd;
	}
	
	/**
	 * Column Info
	 * @return sTpbFlg
	 */
	public String getSTpbFlg() {
		return this.sTpbFlg;
	}
	
	/**
	 * Column Info
	 * @return fileAtch
	 */
	public String getFileAtch() {
		return this.fileAtch;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return respbCntrNo
	 */
	public String getRespbCntrNo() {
		return this.respbCntrNo;
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
	 * @return actDepDt
	 */
	public String getActDepDt() {
		return this.actDepDt;
	}
	
	/**
	 * Column Info
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}
	
	/**
	 * Column Info
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
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
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return sztp
	 */
	public String getSztp() {
		return this.sztp;
	}
	

	/**
	 * Column Info
	 * @param position
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	 * Column Info
	 * @param sRhqOfcCd
	 */
	public void setSRhqOfcCd(String sRhqOfcCd) {
		this.sRhqOfcCd = sRhqOfcCd;
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
	 * @param sBkgNo
	 */
	public void setSBkgNo(String sBkgNo) {
		this.sBkgNo = sBkgNo;
	}
	
	/**
	 * Column Info
	 * @param precell
	 */
	public void setPrecell(String precell) {
		this.precell = precell;
	}
	
	/**
	 * Column Info
	 * @param rhndExpnSeq
	 */
	public void setRhndExpnSeq(String rhndExpnSeq) {
		this.rhndExpnSeq = rhndExpnSeq;
	}
	
	/**
	 * Column Info
	 * @param party
	 */
	public void setParty(String party) {
		this.party = party;
	}
	
	/**
	 * Column Info
	 * @param tpbStsNm
	 */
	public void setTpbStsNm(String tpbStsNm) {
		this.tpbStsNm = tpbStsNm;
	}
	
	/**
	 * Column Info
	 * @param sShiftRsn
	 */
	public void setSShiftRsn(String sShiftRsn) {
		this.sShiftRsn = sShiftRsn;
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
	 * @param tpbOfc
	 */
	public void setTpbOfc(String tpbOfc) {
		this.tpbOfc = tpbOfc;
	}
	
	/**
	 * Column Info
	 * @param tpbNo
	 */
	public void setTpbNo(String tpbNo) {
		this.tpbNo = tpbNo;
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
	 * @param sToDt
	 */
	public void setSToDt(String sToDt) {
		this.sToDt = sToDt;
	}
	
	/**
	 * Column Info
	 * @param sEacIf
	 */
	public void setSEacIf(String sEacIf) {
		this.sEacIf = sEacIf;
	}
	
	/**
	 * Column Info
	 * @param eacIfFlg
	 */
	public void setEacIfFlg(String eacIfFlg) {
		this.eacIfFlg = eacIfFlg;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param sFmDt
	 */
	public void setSFmDt(String sFmDt) {
		this.sFmDt = sFmDt;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param tpbPty3rd
	 */
	public void setTpbPty3rd(String tpbPty3rd) {
		this.tpbPty3rd = tpbPty3rd;
	}
	
	/**
	 * Column Info
	 * @param sOfcCd
	 */
	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
	}
	
	/**
	 * Column Info
	 * @param tpbAmtUsd
	 */
	public void setTpbAmtUsd(String tpbAmtUsd) {
		this.tpbAmtUsd = tpbAmtUsd;
	}
	
	/**
	 * Column Info
	 * @param shiftRsn
	 */
	public void setShiftRsn(String shiftRsn) {
		this.shiftRsn = shiftRsn;
	}
	
	/**
	 * Column Info
	 * @param sVvd
	 */
	public void setSVvd(String sVvd) {
		this.sVvd = sVvd;
	}
	
	/**
	 * Column Info
	 * @param sCntrNo
	 */
	public void setSCntrNo(String sCntrNo) {
		this.sCntrNo = sCntrNo;
	}
	
	/**
	 * Column Info
	 * @param sTrmnlCd
	 */
	public void setSTrmnlCd(String sTrmnlCd) {
		this.sTrmnlCd = sTrmnlCd;
	}
	
	/**
	 * Column Info
	 * @param sPortCd
	 */
	public void setSPortCd(String sPortCd) {
		this.sPortCd = sPortCd;
	}
	
	/**
	 * Column Info
	 * @param sTpbFlg
	 */
	public void setSTpbFlg(String sTpbFlg) {
		this.sTpbFlg = sTpbFlg;
	}
	
	/**
	 * Column Info
	 * @param fileAtch
	 */
	public void setFileAtch(String fileAtch) {
		this.fileAtch = fileAtch;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param respbCntrNo
	 */
	public void setRespbCntrNo(String respbCntrNo) {
		this.respbCntrNo = respbCntrNo;
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
	 * @param actDepDt
	 */
	public void setActDepDt(String actDepDt) {
		this.actDepDt = actDepDt;
	}
	
	/**
	 * Column Info
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	/**
	 * Column Info
	 * @param oprCd
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
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
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param sztp
	 */
	public void setSztp(String sztp) {
		this.sztp = sztp;
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
		setPosition(JSPUtil.getParameter(request, prefix + "position", ""));
		setSRhqOfcCd(JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", ""));
		setLaneCd(JSPUtil.getParameter(request, prefix + "lane_cd", ""));
		setSBkgNo(JSPUtil.getParameter(request, prefix + "s_bkg_no", ""));
		setPrecell(JSPUtil.getParameter(request, prefix + "precell", ""));
		setRhndExpnSeq(JSPUtil.getParameter(request, prefix + "rhnd_expn_seq", ""));
		setParty(JSPUtil.getParameter(request, prefix + "party", ""));
		setTpbStsNm(JSPUtil.getParameter(request, prefix + "tpb_sts_nm", ""));
		setSShiftRsn(JSPUtil.getParameter(request, prefix + "s_shift_rsn", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTpbOfc(JSPUtil.getParameter(request, prefix + "tpb_ofc", ""));
		setTpbNo(JSPUtil.getParameter(request, prefix + "tpb_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSToDt(JSPUtil.getParameter(request, prefix + "s_to_dt", ""));
		setSEacIf(JSPUtil.getParameter(request, prefix + "s_eac_if", ""));
		setEacIfFlg(JSPUtil.getParameter(request, prefix + "eac_if_flg", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setSFmDt(JSPUtil.getParameter(request, prefix + "s_fm_dt", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setTpbPty3rd(JSPUtil.getParameter(request, prefix + "tpb_pty_3rd", ""));
		setSOfcCd(JSPUtil.getParameter(request, prefix + "s_ofc_cd", ""));
		setTpbAmtUsd(JSPUtil.getParameter(request, prefix + "tpb_amt_usd", ""));
		setShiftRsn(JSPUtil.getParameter(request, prefix + "shift_rsn", ""));
		setSVvd(JSPUtil.getParameter(request, prefix + "s_vvd", ""));
		setSCntrNo(JSPUtil.getParameter(request, prefix + "s_cntr_no", ""));
		setSTrmnlCd(JSPUtil.getParameter(request, prefix + "s_trmnl_cd", ""));
		setSPortCd(JSPUtil.getParameter(request, prefix + "s_port_cd", ""));
		setSTpbFlg(JSPUtil.getParameter(request, prefix + "s_tpb_flg", ""));
		setFileAtch(JSPUtil.getParameter(request, prefix + "file_atch", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setRespbCntrNo(JSPUtil.getParameter(request, prefix + "respb_cntr_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setActDepDt(JSPUtil.getParameter(request, prefix + "act_dep_dt", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setOprCd(JSPUtil.getParameter(request, prefix + "opr_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setSztp(JSPUtil.getParameter(request, prefix + "sztp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RehandlingExpenseTorVsTpbVO[]
	 */
	public RehandlingExpenseTorVsTpbVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RehandlingExpenseTorVsTpbVO[]
	 */
	public RehandlingExpenseTorVsTpbVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RehandlingExpenseTorVsTpbVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] position = (JSPUtil.getParameter(request, prefix	+ "position", length));
			String[] sRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_rhq_ofc_cd", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] sBkgNo = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no", length));
			String[] precell = (JSPUtil.getParameter(request, prefix	+ "precell", length));
			String[] rhndExpnSeq = (JSPUtil.getParameter(request, prefix	+ "rhnd_expn_seq", length));
			String[] party = (JSPUtil.getParameter(request, prefix	+ "party", length));
			String[] tpbStsNm = (JSPUtil.getParameter(request, prefix	+ "tpb_sts_nm", length));
			String[] sShiftRsn = (JSPUtil.getParameter(request, prefix	+ "s_shift_rsn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tpbOfc = (JSPUtil.getParameter(request, prefix	+ "tpb_ofc", length));
			String[] tpbNo = (JSPUtil.getParameter(request, prefix	+ "tpb_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sToDt = (JSPUtil.getParameter(request, prefix	+ "s_to_dt", length));
			String[] sEacIf = (JSPUtil.getParameter(request, prefix	+ "s_eac_if", length));
			String[] eacIfFlg = (JSPUtil.getParameter(request, prefix	+ "eac_if_flg", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] sFmDt = (JSPUtil.getParameter(request, prefix	+ "s_fm_dt", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] tpbPty3rd = (JSPUtil.getParameter(request, prefix	+ "tpb_pty_3rd", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] tpbAmtUsd = (JSPUtil.getParameter(request, prefix	+ "tpb_amt_usd", length));
			String[] shiftRsn = (JSPUtil.getParameter(request, prefix	+ "shift_rsn", length));
			String[] sVvd = (JSPUtil.getParameter(request, prefix	+ "s_vvd", length));
			String[] sCntrNo = (JSPUtil.getParameter(request, prefix	+ "s_cntr_no", length));
			String[] sTrmnlCd = (JSPUtil.getParameter(request, prefix	+ "s_trmnl_cd", length));
			String[] sPortCd = (JSPUtil.getParameter(request, prefix	+ "s_port_cd", length));
			String[] sTpbFlg = (JSPUtil.getParameter(request, prefix	+ "s_tpb_flg", length));
			String[] fileAtch = (JSPUtil.getParameter(request, prefix	+ "file_atch", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] respbCntrNo = (JSPUtil.getParameter(request, prefix	+ "respb_cntr_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] actDepDt = (JSPUtil.getParameter(request, prefix	+ "act_dep_dt", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] sztp = (JSPUtil.getParameter(request, prefix	+ "sztp", length));
			
			for (int i = 0; i < length; i++) {
				model = new RehandlingExpenseTorVsTpbVO();
				if (position[i] != null)
					model.setPosition(position[i]);
				if (sRhqOfcCd[i] != null)
					model.setSRhqOfcCd(sRhqOfcCd[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (sBkgNo[i] != null)
					model.setSBkgNo(sBkgNo[i]);
				if (precell[i] != null)
					model.setPrecell(precell[i]);
				if (rhndExpnSeq[i] != null)
					model.setRhndExpnSeq(rhndExpnSeq[i]);
				if (party[i] != null)
					model.setParty(party[i]);
				if (tpbStsNm[i] != null)
					model.setTpbStsNm(tpbStsNm[i]);
				if (sShiftRsn[i] != null)
					model.setSShiftRsn(sShiftRsn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tpbOfc[i] != null)
					model.setTpbOfc(tpbOfc[i]);
				if (tpbNo[i] != null)
					model.setTpbNo(tpbNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sToDt[i] != null)
					model.setSToDt(sToDt[i]);
				if (sEacIf[i] != null)
					model.setSEacIf(sEacIf[i]);
				if (eacIfFlg[i] != null)
					model.setEacIfFlg(eacIfFlg[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (sFmDt[i] != null)
					model.setSFmDt(sFmDt[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (tpbPty3rd[i] != null)
					model.setTpbPty3rd(tpbPty3rd[i]);
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				if (tpbAmtUsd[i] != null)
					model.setTpbAmtUsd(tpbAmtUsd[i]);
				if (shiftRsn[i] != null)
					model.setShiftRsn(shiftRsn[i]);
				if (sVvd[i] != null)
					model.setSVvd(sVvd[i]);
				if (sCntrNo[i] != null)
					model.setSCntrNo(sCntrNo[i]);
				if (sTrmnlCd[i] != null)
					model.setSTrmnlCd(sTrmnlCd[i]);
				if (sPortCd[i] != null)
					model.setSPortCd(sPortCd[i]);
				if (sTpbFlg[i] != null)
					model.setSTpbFlg(sTpbFlg[i]);
				if (fileAtch[i] != null)
					model.setFileAtch(fileAtch[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (respbCntrNo[i] != null)
					model.setRespbCntrNo(respbCntrNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (actDepDt[i] != null)
					model.setActDepDt(actDepDt[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (sztp[i] != null)
					model.setSztp(sztp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRehandlingExpenseTorVsTpbVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RehandlingExpenseTorVsTpbVO[]
	 */
	public RehandlingExpenseTorVsTpbVO[] getRehandlingExpenseTorVsTpbVOs(){
		RehandlingExpenseTorVsTpbVO[] vos = (RehandlingExpenseTorVsTpbVO[])models.toArray(new RehandlingExpenseTorVsTpbVO[models.size()]);
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
		this.position = this.position .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqOfcCd = this.sRhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNo = this.sBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.precell = this.precell .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhndExpnSeq = this.rhndExpnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.party = this.party .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbStsNm = this.tpbStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sShiftRsn = this.sShiftRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbOfc = this.tpbOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbNo = this.tpbNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sToDt = this.sToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacIf = this.sEacIf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacIfFlg = this.eacIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFmDt = this.sFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbPty3rd = this.tpbPty3rd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbAmtUsd = this.tpbAmtUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shiftRsn = this.shiftRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvd = this.sVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntrNo = this.sCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrmnlCd = this.sTrmnlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPortCd = this.sPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTpbFlg = this.sTpbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileAtch = this.fileAtch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbCntrNo = this.respbCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDepDt = this.actDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sztp = this.sztp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
