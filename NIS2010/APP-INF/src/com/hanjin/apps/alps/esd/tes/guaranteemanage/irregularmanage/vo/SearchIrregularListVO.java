/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchIrregularListVO.java
*@FileTitle : SearchIrregularListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.24
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.12.24 yOng hO lEE 
* 1.0 Creation
2012.02.03 박성호 [CHM-201215762] [TES] US Irregular/Guarantee 보완 사항 구현
=========================================================*/

package com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.vo;

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
 * @author yOng hO lEE
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchIrregularListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchIrregularListVO> models = new ArrayList<SearchIrregularListVO>();
	
	/* Column Info */
	private String irrCxlWoFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String irrLateDisFlg = null;
	/* Column Info */
	private String irrStfErrFlg = null;
	/* Column Info */
	private String irrLackOfFlwFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String gnteNo = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String irrOtrFlg = null;
	/* Column Info */
	private String opCostSptgIcrzFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String irrNo = null;
	/* Column Info */
	private String gnteTpCd = null;
	/* Column Info */
	private String opCostMnrFlg = null;
	/* Column Info */
	private String opCostTriAxlFlg = null;
	/* Column Info */
	private String opCostOcpFlg = null;
	/* Column Info */
	private String opCostXtraFtFlg = null;
	/* Column Info */
	private String opCostTnkOrdFlg = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String irrEqShtgFlg = null;
	/* Column Info */
	private String opCostOtrTmlChssFlg = null;
	/* Column Info */
	private String opCostTeamTrkgFlg = null;
	/* Column Info */
	private String gnteAmt = null;
	/* Column Info */
	private String irrSysErrFlg = null;
	/* Column Info */
	private String dmyFlg = null;
	/* Column Info */
	private String irrChssShtgFlg = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String tmlGnteCntrListSeq = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String irrTpCd = null;
	/* Column Info */
	private String irrRsnRmk = null;
	/* Column Info */
	private String chkTpbIf = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchIrregularListVO() {}

	public SearchIrregularListVO(String ibflag, String pagerows, String irrNo, String gnteNo, String dmyFlg, String tmlGnteCntrListSeq, String cntrNo, String cntrTpszCd, String gnteTpCd, String bkgNo, String blNo, String scNo, String fmDt, String toDt, String gnteAmt, String creUsrId, String usrNm, String creDt, String irrStfErrFlg, String irrSysErrFlg, String irrChssShtgFlg, String irrOtrFlg, String irrLateDisFlg, String irrLackOfFlwFlg, String irrCxlWoFlg, String irrEqShtgFlg, String opCostOcpFlg, String opCostTnkOrdFlg, String opCostTeamTrkgFlg, String opCostXtraFtFlg, String opCostSptgIcrzFlg, String opCostOtrTmlChssFlg, String opCostMnrFlg, String opCostTriAxlFlg, String chkTpbIf) {
		this.irrCxlWoFlg = irrCxlWoFlg;
		this.creDt = creDt;
		this.irrLateDisFlg = irrLateDisFlg;
		this.irrStfErrFlg = irrStfErrFlg;
		this.irrLackOfFlwFlg = irrLackOfFlwFlg;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.gnteNo = gnteNo;
		this.usrNm = usrNm;
		this.scNo = scNo;
		this.irrOtrFlg = irrOtrFlg;
		this.opCostSptgIcrzFlg = opCostSptgIcrzFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.irrNo = irrNo;
		this.gnteTpCd = gnteTpCd;
		this.opCostMnrFlg = opCostMnrFlg;
		this.opCostTriAxlFlg = opCostTriAxlFlg;
		this.opCostOcpFlg = opCostOcpFlg;
		this.opCostXtraFtFlg = opCostXtraFtFlg;
		this.opCostTnkOrdFlg = opCostTnkOrdFlg;
		this.fmDt = fmDt;
		this.irrEqShtgFlg = irrEqShtgFlg;
		this.opCostOtrTmlChssFlg = opCostOtrTmlChssFlg;
		this.opCostTeamTrkgFlg = opCostTeamTrkgFlg;
		this.gnteAmt = gnteAmt;
		this.irrSysErrFlg = irrSysErrFlg;
		this.dmyFlg = dmyFlg;
		this.irrChssShtgFlg = irrChssShtgFlg;
		this.toDt = toDt;
		this.tmlGnteCntrListSeq = tmlGnteCntrListSeq;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.cntrNo = cntrNo;
		this.irrTpCd = irrTpCd;
		this.irrRsnRmk = irrRsnRmk;
		this.chkTpbIf = chkTpbIf;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("irr_cxl_wo_flg", getIrrCxlWoFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("irr_late_dis_flg", getIrrLateDisFlg());
		this.hashColumns.put("irr_stf_err_flg", getIrrStfErrFlg());
		this.hashColumns.put("irr_lack_of_flw_flg", getIrrLackOfFlwFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gnte_no", getGnteNo());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("irr_otr_flg", getIrrOtrFlg());
		this.hashColumns.put("op_cost_sptg_icrz_flg", getOpCostSptgIcrzFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("irr_no", getIrrNo());
		this.hashColumns.put("gnte_tp_cd", getGnteTpCd());
		this.hashColumns.put("op_cost_mnr_flg", getOpCostMnrFlg());
		this.hashColumns.put("op_cost_tri_axl_flg", getOpCostTriAxlFlg());
		this.hashColumns.put("op_cost_ocp_flg", getOpCostOcpFlg());
		this.hashColumns.put("op_cost_xtra_ft_flg", getOpCostXtraFtFlg());
		this.hashColumns.put("op_cost_tnk_ord_flg", getOpCostTnkOrdFlg());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("irr_eq_shtg_flg", getIrrEqShtgFlg());
		this.hashColumns.put("op_cost_otr_tml_chss_flg", getOpCostOtrTmlChssFlg());
		this.hashColumns.put("op_cost_team_trkg_flg", getOpCostTeamTrkgFlg());
		this.hashColumns.put("gnte_amt", getGnteAmt());
		this.hashColumns.put("irr_sys_err_flg", getIrrSysErrFlg());
		this.hashColumns.put("dmy_flg", getDmyFlg());
		this.hashColumns.put("irr_chss_shtg_flg", getIrrChssShtgFlg());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("tml_gnte_cntr_list_seq", getTmlGnteCntrListSeq());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("irr_tp_cd", getIrrTpCd());
		this.hashColumns.put("irr_rsn_rmk", getIrrRsnRmk());
		this.hashColumns.put("chk_tpb_if", getChkTpbIf());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("irr_cxl_wo_flg", "irrCxlWoFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("irr_late_dis_flg", "irrLateDisFlg");
		this.hashFields.put("irr_stf_err_flg", "irrStfErrFlg");
		this.hashFields.put("irr_lack_of_flw_flg", "irrLackOfFlwFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gnte_no", "gnteNo");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("irr_otr_flg", "irrOtrFlg");
		this.hashFields.put("op_cost_sptg_icrz_flg", "opCostSptgIcrzFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("irr_no", "irrNo");
		this.hashFields.put("gnte_tp_cd", "gnteTpCd");
		this.hashFields.put("op_cost_mnr_flg", "opCostMnrFlg");
		this.hashFields.put("op_cost_tri_axl_flg", "opCostTriAxlFlg");
		this.hashFields.put("op_cost_ocp_flg", "opCostOcpFlg");
		this.hashFields.put("op_cost_xtra_ft_flg", "opCostXtraFtFlg");
		this.hashFields.put("op_cost_tnk_ord_flg", "opCostTnkOrdFlg");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("irr_eq_shtg_flg", "irrEqShtgFlg");
		this.hashFields.put("op_cost_otr_tml_chss_flg", "opCostOtrTmlChssFlg");
		this.hashFields.put("op_cost_team_trkg_flg", "opCostTeamTrkgFlg");
		this.hashFields.put("gnte_amt", "gnteAmt");
		this.hashFields.put("irr_sys_err_flg", "irrSysErrFlg");
		this.hashFields.put("dmy_flg", "dmyFlg");
		this.hashFields.put("irr_chss_shtg_flg", "irrChssShtgFlg");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("tml_gnte_cntr_list_seq", "tmlGnteCntrListSeq");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("irr_tp_cd", "irrTpCd");
		this.hashFields.put("irr_rsn_rmk", "irrRsnRmk");
		this.hashFields.put("chk_tpb_if", "chkTpbIf");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return irrCxlWoFlg
	 */
	public String getIrrCxlWoFlg() {
		return this.irrCxlWoFlg;
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
	 * @return irrLateDisFlg
	 */
	public String getIrrLateDisFlg() {
		return this.irrLateDisFlg;
	}
	
	/**
	 * Column Info
	 * @return irrStfErrFlg
	 */
	public String getIrrStfErrFlg() {
		return this.irrStfErrFlg;
	}
	
	/**
	 * Column Info
	 * @return irrLackOfFlwFlg
	 */
	public String getIrrLackOfFlwFlg() {
		return this.irrLackOfFlwFlg;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return gnteNo
	 */
	public String getGnteNo() {
		return this.gnteNo;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return irrOtrFlg
	 */
	public String getIrrOtrFlg() {
		return this.irrOtrFlg;
	}
	
	/**
	 * Column Info
	 * @return opCostSptgIcrzFlg
	 */
	public String getOpCostSptgIcrzFlg() {
		return this.opCostSptgIcrzFlg;
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
	 * @return irrNo
	 */
	public String getIrrNo() {
		return this.irrNo;
	}
	
	/**
	 * Column Info
	 * @return gnteTpCd
	 */
	public String getGnteTpCd() {
		return this.gnteTpCd;
	}
	
	/**
	 * Column Info
	 * @return opCostMnrFlg
	 */
	public String getOpCostMnrFlg() {
		return this.opCostMnrFlg;
	}
	
	/**
	 * Column Info
	 * @return opCostTriAxlFlg
	 */
	public String getOpCostTriAxlFlg() {
		return this.opCostTriAxlFlg;
	}
	
	/**
	 * Column Info
	 * @return opCostOcpFlg
	 */
	public String getOpCostOcpFlg() {
		return this.opCostOcpFlg;
	}
	
	/**
	 * Column Info
	 * @return opCostXtraFtFlg
	 */
	public String getOpCostXtraFtFlg() {
		return this.opCostXtraFtFlg;
	}
	
	/**
	 * Column Info
	 * @return opCostTnkOrdFlg
	 */
	public String getOpCostTnkOrdFlg() {
		return this.opCostTnkOrdFlg;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return irrEqShtgFlg
	 */
	public String getIrrEqShtgFlg() {
		return this.irrEqShtgFlg;
	}
	
	/**
	 * Column Info
	 * @return opCostOtrTmlChssFlg
	 */
	public String getOpCostOtrTmlChssFlg() {
		return this.opCostOtrTmlChssFlg;
	}
	
	/**
	 * Column Info
	 * @return opCostTeamTrkgFlg
	 */
	public String getOpCostTeamTrkgFlg() {
		return this.opCostTeamTrkgFlg;
	}
	
	/**
	 * Column Info
	 * @return gnteAmt
	 */
	public String getGnteAmt() {
		return this.gnteAmt;
	}
	
	/**
	 * Column Info
	 * @return irrSysErrFlg
	 */
	public String getIrrSysErrFlg() {
		return this.irrSysErrFlg;
	}
	
	/**
	 * Column Info
	 * @return dmyFlg
	 */
	public String getDmyFlg() {
		return this.dmyFlg;
	}
	
	/**
	 * Column Info
	 * @return irrChssShtgFlg
	 */
	public String getIrrChssShtgFlg() {
		return this.irrChssShtgFlg;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return tmlGnteCntrListSeq
	 */
	public String getTmlGnteCntrListSeq() {
		return this.tmlGnteCntrListSeq;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return irrRsnRmk
	 */
	public String getIrrRsnRmk() {
		return this.irrRsnRmk;
	}
	
	/**
	 * Column Info
	 * @return irrTpCd
	 */
	public String getIrrTpCd() {
		return this.irrTpCd;
	}
	
	/**
	 * Column Info
	 * @return chkTpbIf
	 */
	public String getChkTpbIf() {
		return this.chkTpbIf;
	}

	
	/**
	 * Column Info
	 * @param chkTpbIf
	 */
	public void setChkTpbIf(String chkTpbIf) {
		this.chkTpbIf = chkTpbIf;
	}
	
	/**
	 * Column Info
	 * @param irrCxlWoFlg
	 */
	public void setIrrCxlWoFlg(String irrCxlWoFlg) {
		this.irrCxlWoFlg = irrCxlWoFlg;
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
	 * @param irrLateDisFlg
	 */
	public void setIrrLateDisFlg(String irrLateDisFlg) {
		this.irrLateDisFlg = irrLateDisFlg;
	}
	
	/**
	 * Column Info
	 * @param irrStfErrFlg
	 */
	public void setIrrStfErrFlg(String irrStfErrFlg) {
		this.irrStfErrFlg = irrStfErrFlg;
	}
	
	/**
	 * Column Info
	 * @param irrLackOfFlwFlg
	 */
	public void setIrrLackOfFlwFlg(String irrLackOfFlwFlg) {
		this.irrLackOfFlwFlg = irrLackOfFlwFlg;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param gnteNo
	 */
	public void setGnteNo(String gnteNo) {
		this.gnteNo = gnteNo;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param irrOtrFlg
	 */
	public void setIrrOtrFlg(String irrOtrFlg) {
		this.irrOtrFlg = irrOtrFlg;
	}
	
	/**
	 * Column Info
	 * @param opCostSptgIcrzFlg
	 */
	public void setOpCostSptgIcrzFlg(String opCostSptgIcrzFlg) {
		this.opCostSptgIcrzFlg = opCostSptgIcrzFlg;
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
	 * @param irrNo
	 */
	public void setIrrNo(String irrNo) {
		this.irrNo = irrNo;
	}
	
	/**
	 * Column Info
	 * @param gnteTpCd
	 */
	public void setGnteTpCd(String gnteTpCd) {
		this.gnteTpCd = gnteTpCd;
	}
	
	/**
	 * Column Info
	 * @param opCostMnrFlg
	 */
	public void setOpCostMnrFlg(String opCostMnrFlg) {
		this.opCostMnrFlg = opCostMnrFlg;
	}
	
	/**
	 * Column Info
	 * @param opCostTriAxlFlg
	 */
	public void setOpCostTriAxlFlg(String opCostTriAxlFlg) {
		this.opCostTriAxlFlg = opCostTriAxlFlg;
	}
	
	/**
	 * Column Info
	 * @param opCostOcpFlg
	 */
	public void setOpCostOcpFlg(String opCostOcpFlg) {
		this.opCostOcpFlg = opCostOcpFlg;
	}
	
	/**
	 * Column Info
	 * @param opCostXtraFtFlg
	 */
	public void setOpCostXtraFtFlg(String opCostXtraFtFlg) {
		this.opCostXtraFtFlg = opCostXtraFtFlg;
	}
	
	/**
	 * Column Info
	 * @param opCostTnkOrdFlg
	 */
	public void setOpCostTnkOrdFlg(String opCostTnkOrdFlg) {
		this.opCostTnkOrdFlg = opCostTnkOrdFlg;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param irrEqShtgFlg
	 */
	public void setIrrEqShtgFlg(String irrEqShtgFlg) {
		this.irrEqShtgFlg = irrEqShtgFlg;
	}
	
	/**
	 * Column Info
	 * @param opCostOtrTmlChssFlg
	 */
	public void setOpCostOtrTmlChssFlg(String opCostOtrTmlChssFlg) {
		this.opCostOtrTmlChssFlg = opCostOtrTmlChssFlg;
	}
	
	/**
	 * Column Info
	 * @param opCostTeamTrkgFlg
	 */
	public void setOpCostTeamTrkgFlg(String opCostTeamTrkgFlg) {
		this.opCostTeamTrkgFlg = opCostTeamTrkgFlg;
	}
	
	/**
	 * Column Info
	 * @param gnteAmt
	 */
	public void setGnteAmt(String gnteAmt) {
		this.gnteAmt = gnteAmt;
	}
	
	/**
	 * Column Info
	 * @param irrSysErrFlg
	 */
	public void setIrrSysErrFlg(String irrSysErrFlg) {
		this.irrSysErrFlg = irrSysErrFlg;
	}
	
	/**
	 * Column Info
	 * @param dmyFlg
	 */
	public void setDmyFlg(String dmyFlg) {
		this.dmyFlg = dmyFlg;
	}
	
	/**
	 * Column Info
	 * @param irrChssShtgFlg
	 */
	public void setIrrChssShtgFlg(String irrChssShtgFlg) {
		this.irrChssShtgFlg = irrChssShtgFlg;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param tmlGnteCntrListSeq
	 */
	public void setTmlGnteCntrListSeq(String tmlGnteCntrListSeq) {
		this.tmlGnteCntrListSeq = tmlGnteCntrListSeq;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param irrRsnRmk
	 */
	public void setIrrRsnRmk(String irrRsnRmk) {
		this.irrRsnRmk = irrRsnRmk;
	}
	
	/**
	 * Column Info
	 * @param irrTpCd
	 */
	public void setIrrTpCd(String irrTpCd) {
		this.irrTpCd = irrTpCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIrrCxlWoFlg(JSPUtil.getParameter(request, "irr_cxl_wo_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setIrrLateDisFlg(JSPUtil.getParameter(request, "irr_late_dis_flg", ""));
		setIrrStfErrFlg(JSPUtil.getParameter(request, "irr_stf_err_flg", ""));
		setIrrLackOfFlwFlg(JSPUtil.getParameter(request, "irr_lack_of_flw_flg", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGnteNo(JSPUtil.getParameter(request, "gnte_no", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setIrrOtrFlg(JSPUtil.getParameter(request, "irr_otr_flg", ""));
		setOpCostSptgIcrzFlg(JSPUtil.getParameter(request, "op_cost_sptg_icrz_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setIrrNo(JSPUtil.getParameter(request, "irr_no", ""));
		setGnteTpCd(JSPUtil.getParameter(request, "gnte_tp_cd", ""));
		setOpCostMnrFlg(JSPUtil.getParameter(request, "op_cost_mnr_flg", ""));
		setOpCostTriAxlFlg(JSPUtil.getParameter(request, "op_cost_tri_axl_flg", ""));
		setOpCostOcpFlg(JSPUtil.getParameter(request, "op_cost_ocp_flg", ""));
		setOpCostXtraFtFlg(JSPUtil.getParameter(request, "op_cost_xtra_ft_flg", ""));
		setOpCostTnkOrdFlg(JSPUtil.getParameter(request, "op_cost_tnk_ord_flg", ""));
		setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
		setIrrEqShtgFlg(JSPUtil.getParameter(request, "irr_eq_shtg_flg", ""));
		setOpCostOtrTmlChssFlg(JSPUtil.getParameter(request, "op_cost_otr_tml_chss_flg", ""));
		setOpCostTeamTrkgFlg(JSPUtil.getParameter(request, "op_cost_team_trkg_flg", ""));
		setGnteAmt(JSPUtil.getParameter(request, "gnte_amt", ""));
		setIrrSysErrFlg(JSPUtil.getParameter(request, "irr_sys_err_flg", ""));
		setDmyFlg(JSPUtil.getParameter(request, "dmy_flg", ""));
		setIrrChssShtgFlg(JSPUtil.getParameter(request, "irr_chss_shtg_flg", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setTmlGnteCntrListSeq(JSPUtil.getParameter(request, "tml_gnte_cntr_list_seq", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setIrrTpCd(JSPUtil.getParameter(request, "irr_tp_cd", ""));
		setIrrRsnRmk(JSPUtil.getParameter(request, "irr_rsn_rmk", ""));
		setChkTpbIf(JSPUtil.getParameter(request, "chk_tpb_if", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchIrregularListVO[]
	 */
	public SearchIrregularListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchIrregularListVO[]
	 */
	public SearchIrregularListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchIrregularListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] irrCxlWoFlg = (JSPUtil.getParameter(request, prefix	+ "irr_cxl_wo_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] irrLateDisFlg = (JSPUtil.getParameter(request, prefix	+ "irr_late_dis_flg", length));
			String[] irrStfErrFlg = (JSPUtil.getParameter(request, prefix	+ "irr_stf_err_flg", length));
			String[] irrLackOfFlwFlg = (JSPUtil.getParameter(request, prefix	+ "irr_lack_of_flw_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] gnteNo = (JSPUtil.getParameter(request, prefix	+ "gnte_no", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] irrOtrFlg = (JSPUtil.getParameter(request, prefix	+ "irr_otr_flg", length));
			String[] opCostSptgIcrzFlg = (JSPUtil.getParameter(request, prefix	+ "op_cost_sptg_icrz_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] irrNo = (JSPUtil.getParameter(request, prefix	+ "irr_no", length));
			String[] gnteTpCd = (JSPUtil.getParameter(request, prefix	+ "gnte_tp_cd", length));
			String[] opCostMnrFlg = (JSPUtil.getParameter(request, prefix	+ "op_cost_mnr_flg", length));
			String[] opCostTriAxlFlg = (JSPUtil.getParameter(request, prefix	+ "op_cost_tri_axl_flg", length));
			String[] opCostOcpFlg = (JSPUtil.getParameter(request, prefix	+ "op_cost_ocp_flg", length));
			String[] opCostXtraFtFlg = (JSPUtil.getParameter(request, prefix	+ "op_cost_xtra_ft_flg", length));
			String[] opCostTnkOrdFlg = (JSPUtil.getParameter(request, prefix	+ "op_cost_tnk_ord_flg", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] irrEqShtgFlg = (JSPUtil.getParameter(request, prefix	+ "irr_eq_shtg_flg", length));
			String[] opCostOtrTmlChssFlg = (JSPUtil.getParameter(request, prefix	+ "op_cost_otr_tml_chss_flg", length));
			String[] opCostTeamTrkgFlg = (JSPUtil.getParameter(request, prefix	+ "op_cost_team_trkg_flg", length));
			String[] gnteAmt = (JSPUtil.getParameter(request, prefix	+ "gnte_amt", length));
			String[] irrSysErrFlg = (JSPUtil.getParameter(request, prefix	+ "irr_sys_err_flg", length));
			String[] dmyFlg = (JSPUtil.getParameter(request, prefix	+ "dmy_flg", length));
			String[] irrChssShtgFlg = (JSPUtil.getParameter(request, prefix	+ "irr_chss_shtg_flg", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] tmlGnteCntrListSeq = (JSPUtil.getParameter(request, prefix	+ "tml_gnte_cntr_list_seq", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] irrTpCd = (JSPUtil.getParameter(request, prefix	+ "irr_tp_cd", length));
			String[] irrRsnRmk = (JSPUtil.getParameter(request, prefix	+ "irr_rsn_rmk", length));
			String[] chkTpbIf = (JSPUtil.getParameter(request, prefix + "chk_tpb_if", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchIrregularListVO();
				if (irrCxlWoFlg[i] != null)
					model.setIrrCxlWoFlg(irrCxlWoFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (irrLateDisFlg[i] != null)
					model.setIrrLateDisFlg(irrLateDisFlg[i]);
				if (irrStfErrFlg[i] != null)
					model.setIrrStfErrFlg(irrStfErrFlg[i]);
				if (irrLackOfFlwFlg[i] != null)
					model.setIrrLackOfFlwFlg(irrLackOfFlwFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (gnteNo[i] != null)
					model.setGnteNo(gnteNo[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (irrOtrFlg[i] != null)
					model.setIrrOtrFlg(irrOtrFlg[i]);
				if (opCostSptgIcrzFlg[i] != null)
					model.setOpCostSptgIcrzFlg(opCostSptgIcrzFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (irrNo[i] != null)
					model.setIrrNo(irrNo[i]);
				if (gnteTpCd[i] != null)
					model.setGnteTpCd(gnteTpCd[i]);
				if (opCostMnrFlg[i] != null)
					model.setOpCostMnrFlg(opCostMnrFlg[i]);
				if (opCostTriAxlFlg[i] != null)
					model.setOpCostTriAxlFlg(opCostTriAxlFlg[i]);
				if (opCostOcpFlg[i] != null)
					model.setOpCostOcpFlg(opCostOcpFlg[i]);
				if (opCostXtraFtFlg[i] != null)
					model.setOpCostXtraFtFlg(opCostXtraFtFlg[i]);
				if (opCostTnkOrdFlg[i] != null)
					model.setOpCostTnkOrdFlg(opCostTnkOrdFlg[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (irrEqShtgFlg[i] != null)
					model.setIrrEqShtgFlg(irrEqShtgFlg[i]);
				if (opCostOtrTmlChssFlg[i] != null)
					model.setOpCostOtrTmlChssFlg(opCostOtrTmlChssFlg[i]);
				if (opCostTeamTrkgFlg[i] != null)
					model.setOpCostTeamTrkgFlg(opCostTeamTrkgFlg[i]);
				if (gnteAmt[i] != null)
					model.setGnteAmt(gnteAmt[i]);
				if (irrSysErrFlg[i] != null)
					model.setIrrSysErrFlg(irrSysErrFlg[i]);
				if (dmyFlg[i] != null)
					model.setDmyFlg(dmyFlg[i]);
				if (irrChssShtgFlg[i] != null)
					model.setIrrChssShtgFlg(irrChssShtgFlg[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (tmlGnteCntrListSeq[i] != null)
					model.setTmlGnteCntrListSeq(tmlGnteCntrListSeq[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (irrTpCd[i] != null)
					model.setIrrTpCd(irrTpCd[i]);
				if (irrRsnRmk[i] != null)
					model.setIrrRsnRmk(irrRsnRmk[i]);
				if (chkTpbIf[i] != null)
					model.setChkTpbIf(chkTpbIf[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchIrregularListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchIrregularListVO[]
	 */
	public SearchIrregularListVO[] getSearchIrregularListVOs(){
		SearchIrregularListVO[] vos = (SearchIrregularListVO[])models.toArray(new SearchIrregularListVO[models.size()]);
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
		this.irrCxlWoFlg = this.irrCxlWoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irrLateDisFlg = this.irrLateDisFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irrStfErrFlg = this.irrStfErrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irrLackOfFlwFlg = this.irrLackOfFlwFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnteNo = this.gnteNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irrOtrFlg = this.irrOtrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCostSptgIcrzFlg = this.opCostSptgIcrzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irrNo = this.irrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnteTpCd = this.gnteTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCostMnrFlg = this.opCostMnrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCostTriAxlFlg = this.opCostTriAxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCostOcpFlg = this.opCostOcpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCostXtraFtFlg = this.opCostXtraFtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCostTnkOrdFlg = this.opCostTnkOrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irrEqShtgFlg = this.irrEqShtgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCostOtrTmlChssFlg = this.opCostOtrTmlChssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCostTeamTrkgFlg = this.opCostTeamTrkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnteAmt = this.gnteAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irrSysErrFlg = this.irrSysErrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmyFlg = this.dmyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irrChssShtgFlg = this.irrChssShtgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlGnteCntrListSeq = this.tmlGnteCntrListSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irrTpCd = this.irrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irrRsnRmk = this.irrRsnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkTpbIf = this.chkTpbIf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
