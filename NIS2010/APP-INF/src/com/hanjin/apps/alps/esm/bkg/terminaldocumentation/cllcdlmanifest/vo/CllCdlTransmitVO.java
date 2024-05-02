/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CllCdlTransmitVO.java
*@FileTitle : CllCdlTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.30  
* 1.0 Creation
* ------------------------------------------------------
* History
* 2012.08.17 김보배 [CHM-201219430] [BKG] COPRAR (Pre-S/O) EDI 보완건
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CllCdlTransmitVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CllCdlTransmitVO> models = new ArrayList<CllCdlTransmitVO>();
	
	/* Column Info */
	private String inRcvId = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String inListType = null;
	/* Column Info */
	private String inLocalIpi = null;
	/* Column Info */
	private String inAreaId = null;
	/* Column Info */
	private String inEtcEuid = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String inYdCd = null;
	/* Column Info */
	private String inEdiMsgFunc = null;
	/* Column Info */
	private String inPodCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ibdTrspNo = null;
	/* Column Info */
	private String inDestSvrCd = null;
	/* Column Info */
	private String repCmdtNm = null;
	/* Column Info */
	private String inWhereGubun = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String custrefNum = null;
	/* Column Info */
	private String inLocNm = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String transMode = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String inPolCd = null;
	/* Column Info */
	private String inSndId = null;
	/* Column Info */
	private String inVvdCd = null;
	/* Column Info */
	private String inTerminalVvdCd = null;
	/* Column Info */
	private String inBkgNo = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String inVvdFlg = null;
	/* Column Info */
	private String inBlFlg = null;
	/* Column Info */
	private String inPolSplitNo = null;
	/* Column Info */
	private String inPodSplitNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CllCdlTransmitVO() {}

	public CllCdlTransmitVO(String ibflag, String pagerows, String inRcvId, String bkgCgoTpCd, String rdCgoFlg, String inListType, String inLocalIpi, String inAreaId, String blNo, String inEtcEuid, String cmdtCd, String bbCgoFlg, String dcgoFlg, String inYdCd, String inEdiMsgFunc, String inPodCd, String updUsrId, String ibdTrspNo, String inDestSvrCd, String repCmdtNm, String awkCgoFlg, String custrefNum, String inLocNm, String cmdtNm, String invNo, String transMode, String bkgNo, String creUsrId, String cmdtDesc, String cntrNo, String inSndId, String inPolCd, String inTerminalVvdCd, String inVvdCd, String rcFlg, String inBkgNo, String inWhereGubun, String inVvdFlg, String inBlFlg, String inPolSplitNo, String inPodSplitNo) {
		this.inRcvId = inRcvId;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.rdCgoFlg = rdCgoFlg;
		this.inListType = inListType;
		this.inLocalIpi = inLocalIpi;
		this.inAreaId = inAreaId;
		this.inEtcEuid = inEtcEuid;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.bbCgoFlg = bbCgoFlg;
		this.dcgoFlg = dcgoFlg;
		this.inYdCd = inYdCd;
		this.inEdiMsgFunc = inEdiMsgFunc;
		this.inPodCd = inPodCd;
		this.updUsrId = updUsrId;
		this.ibdTrspNo = ibdTrspNo;
		this.inDestSvrCd = inDestSvrCd;
		this.repCmdtNm = repCmdtNm;
		this.inWhereGubun = inWhereGubun;
		this.awkCgoFlg = awkCgoFlg;
		this.custrefNum = custrefNum;
		this.inLocNm = inLocNm;
		this.cmdtNm = cmdtNm;
		this.invNo = invNo;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.transMode = transMode;
		this.cmdtDesc = cmdtDesc;
		this.cntrNo = cntrNo;
		this.inPolCd = inPolCd;
		this.inSndId = inSndId;
		this.inVvdCd = inVvdCd;
		this.inTerminalVvdCd = inTerminalVvdCd;
		this.inBkgNo = inBkgNo;
		this.rcFlg = rcFlg;
		this.inVvdFlg = inVvdFlg;
		this.inBlFlg = inBlFlg;
		this.inPolSplitNo = inPolSplitNo;
		this.inPodSplitNo = inPodSplitNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_rcv_id", getInRcvId());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("in_list_type", getInListType());
		this.hashColumns.put("in_local_ipi", getInLocalIpi());
		this.hashColumns.put("in_area_id", getInAreaId());
		this.hashColumns.put("in_etc_euid", getInEtcEuid());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("in_yd_cd", getInYdCd());
		this.hashColumns.put("in_edi_msg_func", getInEdiMsgFunc());
		this.hashColumns.put("in_pod_cd", getInPodCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ibd_trsp_no", getIbdTrspNo());
		this.hashColumns.put("in_dest_svr_cd", getInDestSvrCd());
		this.hashColumns.put("rep_cmdt_nm", getRepCmdtNm());
		this.hashColumns.put("in_where_gubun", getInWhereGubun());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("custref_num", getCustrefNum());
		this.hashColumns.put("in_loc_nm", getInLocNm());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("trans_mode", getTransMode());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("in_pol_cd", getInPolCd());
		this.hashColumns.put("in_snd_id", getInSndId());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		this.hashColumns.put("in_terminal_vvd_cd", getInTerminalVvdCd());
		this.hashColumns.put("in_bkg_no", getInBkgNo());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("in_vvd_flg",getInVvdFlg());
		this.hashColumns.put("in_bl_flg", getInBlFlg());
		this.hashColumns.put("in_pol_split_no", getInPolSplitNo());
		this.hashColumns.put("in_pod_split_no", getInPodSplitNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_rcv_id", "inRcvId");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("in_list_type", "inListType");
		this.hashFields.put("in_local_ipi", "inLocalIpi");
		this.hashFields.put("in_area_id", "inAreaId");
		this.hashFields.put("in_etc_euid", "inEtcEuid");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("in_yd_cd", "inYdCd");
		this.hashFields.put("in_edi_msg_func", "inEdiMsgFunc");
		this.hashFields.put("in_pod_cd", "inPodCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ibd_trsp_no", "ibdTrspNo");
		this.hashFields.put("in_dest_svr_cd", "inDestSvrCd");
		this.hashFields.put("rep_cmdt_nm", "repCmdtNm");
		this.hashFields.put("in_where_gubun", "inWhereGubun");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("custref_num", "custrefNum");
		this.hashFields.put("in_loc_nm", "inLocNm");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("trans_mode", "transMode");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("in_pol_cd", "inPolCd");
		this.hashFields.put("in_snd_id", "inSndId");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("in_terminal_vvd_cd", "inTerminalVvdCd");
		this.hashFields.put("in_bkg_no", "inBkgNo");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("in_vvd_flg", "inVvdFlg");
		this.hashFields.put("in_bl_flg", "inBlFlg");
		this.hashFields.put("in_pol_split_no", "inPolSplitNo");
		this.hashFields.put("in_pod_split_no", "inPodSplitNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inRcvId
	 */
	public String getInRcvId() {
		return this.inRcvId;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return inListType
	 */
	public String getInListType() {
		return this.inListType;
	}
	
	/**
	 * Column Info
	 * @return inLocalIpi
	 */
	public String getInLocalIpi() {
		return this.inLocalIpi;
	}
	
	/**
	 * Column Info
	 * @return inAreaId
	 */
	public String getInAreaId() {
		return this.inAreaId;
	}
	
	/**
	 * Column Info
	 * @return inEtcEuid
	 */
	public String getInEtcEuid() {
		return this.inEtcEuid;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return inYdCd
	 */
	public String getInYdCd() {
		return this.inYdCd;
	}
	
	/**
	 * Column Info
	 * @return inEdiMsgFunc
	 */
	public String getInEdiMsgFunc() {
		return this.inEdiMsgFunc;
	}
	
	/**
	 * Column Info
	 * @return inPodCd
	 */
	public String getInPodCd() {
		return this.inPodCd;
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
	 * @return ibdTrspNo
	 */
	public String getIbdTrspNo() {
		return this.ibdTrspNo;
	}
	
	/**
	 * Column Info
	 * @return inDestSvrCd
	 */
	public String getInDestSvrCd() {
		return this.inDestSvrCd;
	}
	
	/**
	 * Column Info
	 * @return repCmdtNm
	 */
	public String getRepCmdtNm() {
		return this.repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @return inWhereGubun
	 */
	public String getInWhereGubun() {
		return this.inWhereGubun;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return custrefNum
	 */
	public String getCustrefNum() {
		return this.custrefNum;
	}
	
	/**
	 * Column Info
	 * @return inLocNm
	 */
	public String getInLocNm() {
		return this.inLocNm;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return transMode
	 */
	public String getTransMode() {
		return this.transMode;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
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
	 * @return inPolCd
	 */
	public String getInPolCd() {
		return this.inPolCd;
	}
	
	/**
	 * Column Info
	 * @return inSndId
	 */
	public String getInSndId() {
		return this.inSndId;
	}
	
	/**
	 * Column Info
	 * @return inVvdCd
	 */
	public String getInVvdCd() {
		return this.inVvdCd;
	}
	
	/**
	 * Column Info
	 * @return inTerminalVvdCd
	 */
	public String getInTerminalVvdCd() {
		return this.inTerminalVvdCd;
	}
	
	/**
	 * Column Info
	 * @return inBkgNo
	 */
	public String getInBkgNo() {
		return this.inBkgNo;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return inVvdFlg
	 */
	public String getInVvdFlg() {
		return this.inVvdFlg;
	}
	
	/**
	 * Column Info
	 * @return inBlFlg
	 */
	public String getInBlFlg() {
		return this.inBlFlg;
	}
	
	/**
	 * Column Info
	 * @return inPolSplitNo
	 */
	public String getInPolSplitNo() {
		return this.inPolSplitNo;
	}
	
	/**
	 * Column Info
	 * @return inPodSplitNo
	 */
	public String getInPodSplitNo() {
		return this.inPodSplitNo;
	}
	
	/**
	 * Column Info
	 * @param inRcvId
	 */
	public void setInRcvId(String inRcvId) {
		this.inRcvId = inRcvId;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param inListType
	 */
	public void setInListType(String inListType) {
		this.inListType = inListType;
	}
	
	/**
	 * Column Info
	 * @param inLocalIpi
	 */
	public void setInLocalIpi(String inLocalIpi) {
		this.inLocalIpi = inLocalIpi;
	}
	
	/**
	 * Column Info
	 * @param inAreaId
	 */
	public void setInAreaId(String inAreaId) {
		this.inAreaId = inAreaId;
	}
	
	/**
	 * Column Info
	 * @param inEtcEuid
	 */
	public void setInEtcEuid(String inEtcEuid) {
		this.inEtcEuid = inEtcEuid;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param inYdCd
	 */
	public void setInYdCd(String inYdCd) {
		this.inYdCd = inYdCd;
	}
	
	/**
	 * Column Info
	 * @param inEdiMsgFunc
	 */
	public void setInEdiMsgFunc(String inEdiMsgFunc) {
		this.inEdiMsgFunc = inEdiMsgFunc;
	}
	
	/**
	 * Column Info
	 * @param inPodCd
	 */
	public void setInPodCd(String inPodCd) {
		this.inPodCd = inPodCd;
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
	 * @param ibdTrspNo
	 */
	public void setIbdTrspNo(String ibdTrspNo) {
		this.ibdTrspNo = ibdTrspNo;
	}
	
	/**
	 * Column Info
	 * @param inDestSvrCd
	 */
	public void setInDestSvrCd(String inDestSvrCd) {
		this.inDestSvrCd = inDestSvrCd;
	}
	
	/**
	 * Column Info
	 * @param repCmdtNm
	 */
	public void setRepCmdtNm(String repCmdtNm) {
		this.repCmdtNm = repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @param inWhereGubun
	 */
	public void setInWhereGubun(String inWhereGubun) {
		this.inWhereGubun = inWhereGubun;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param custrefNum
	 */
	public void setCustrefNum(String custrefNum) {
		this.custrefNum = custrefNum;
	}
	
	/**
	 * Column Info
	 * @param inLocNm
	 */
	public void setInLocNm(String inLocNm) {
		this.inLocNm = inLocNm;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param transMode
	 */
	public void setTransMode(String transMode) {
		this.transMode = transMode;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
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
	 * @param inPolCd
	 */
	public void setInPolCd(String inPolCd) {
		this.inPolCd = inPolCd;
	}
	
	/**
	 * Column Info
	 * @param inSndId
	 */
	public void setInSndId(String inSndId) {
		this.inSndId = inSndId;
	}
	
	/**
	 * Column Info
	 * @param inVvdCd
	 */
	public void setInVvdCd(String inVvdCd) {
		this.inVvdCd = inVvdCd;
	}
	
	/**
	 * Column Info
	 * @param inTerminalVvdCd
	 */
	public void setInTerminalVvdCd(String inTerminalVvdCd) {
		this.inTerminalVvdCd = inTerminalVvdCd;
	}
	
	/**
	 * Column Info
	 * @param inBkgNo
	 */
	public void setInBkgNo(String inBkgNo) {
		this.inBkgNo = inBkgNo;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param inVvdFlg
	 */
	public void setInVvdFlg(String inVvdFlg){
		this.inVvdFlg = inVvdFlg;
	}
	
	/**
	 * Column Info
	 * @param inBlFlg
	 */
	public void setInBlFlg(String inBlFlg){
		this.inBlFlg = inBlFlg;
	}
	
	/**
	 * Column Info
	 * @param inPolSplitNo
	 */
	public void setInPolSplitNo(String inPolSplitNo){
		this.inPolSplitNo = inPolSplitNo;
	}
	
	/**
	 * Column Info
	 * @param inPodSplitNo
	 */
	public void setInPodSplitNo(String inPodSplitNo){
		this.inPodSplitNo = inPodSplitNo;
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
		setInRcvId(JSPUtil.getParameter(request, prefix + "in_rcv_id", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
		setInListType(JSPUtil.getParameter(request, prefix + "in_list_type", ""));
		setInLocalIpi(JSPUtil.getParameter(request, prefix + "in_local_ipi", ""));
		setInAreaId(JSPUtil.getParameter(request, prefix + "in_area_id", ""));
		setInEtcEuid(JSPUtil.getParameter(request, prefix + "in_etc_euid", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setInYdCd(JSPUtil.getParameter(request, prefix + "in_yd_cd", ""));
		setInEdiMsgFunc(JSPUtil.getParameter(request, prefix + "in_edi_msg_func", ""));
		setInPodCd(JSPUtil.getParameter(request, prefix + "in_pod_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setIbdTrspNo(JSPUtil.getParameter(request, prefix + "ibd_trsp_no", ""));
		setInDestSvrCd(JSPUtil.getParameter(request, prefix + "in_dest_svr_cd", ""));
		setRepCmdtNm(JSPUtil.getParameter(request, prefix + "rep_cmdt_nm", ""));
		setInWhereGubun(JSPUtil.getParameter(request, prefix + "in_where_gubun", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setCustrefNum(JSPUtil.getParameter(request, prefix + "custref_num", ""));
		setInLocNm(JSPUtil.getParameter(request, prefix + "in_loc_nm", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTransMode(JSPUtil.getParameter(request, prefix + "trans_mode", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setInPolCd(JSPUtil.getParameter(request, prefix + "in_pol_cd", ""));
		setInSndId(JSPUtil.getParameter(request, prefix + "in_snd_id", ""));
		setInVvdCd(JSPUtil.getParameter(request, prefix + "in_vvd_cd", ""));
		setInTerminalVvdCd(JSPUtil.getParameter(request, prefix + "in_terminal_vvd_cd", ""));
		setInBkgNo(JSPUtil.getParameter(request, prefix + "in_bkg_no", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setInVvdFlg(JSPUtil.getParameter(request, prefix + "in_vvd_flg", ""));
		setInBlFlg(JSPUtil.getParameter(request, prefix + "in_bl_flg", ""));
		setInPolSplitNo(JSPUtil.getParameter(request, prefix + "in_pol_split_no", ""));
		setInPodSplitNo(JSPUtil.getParameter(request, prefix + "in_pod_split_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CllCdlTransmitVO[]
	 */
	public CllCdlTransmitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CllCdlTransmitVO[]
	 */
	public CllCdlTransmitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CllCdlTransmitVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inRcvId = (JSPUtil.getParameter(request, prefix	+ "in_rcv_id", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] inListType = (JSPUtil.getParameter(request, prefix	+ "in_list_type", length));
			String[] inLocalIpi = (JSPUtil.getParameter(request, prefix	+ "in_local_ipi", length));
			String[] inAreaId = (JSPUtil.getParameter(request, prefix	+ "in_area_id", length));
			String[] inEtcEuid = (JSPUtil.getParameter(request, prefix	+ "in_etc_euid", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] inYdCd = (JSPUtil.getParameter(request, prefix	+ "in_yd_cd", length));
			String[] inEdiMsgFunc = (JSPUtil.getParameter(request, prefix	+ "in_edi_msg_func", length));
			String[] inPodCd = (JSPUtil.getParameter(request, prefix	+ "in_pod_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ibdTrspNo = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_no", length));
			String[] inDestSvrCd = (JSPUtil.getParameter(request, prefix	+ "in_dest_svr_cd", length));
			String[] repCmdtNm = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_nm", length));
			String[] inWhereGubun = (JSPUtil.getParameter(request, prefix	+ "in_where_gubun", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] custrefNum = (JSPUtil.getParameter(request, prefix	+ "custref_num", length));
			String[] inLocNm = (JSPUtil.getParameter(request, prefix	+ "in_loc_nm", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] transMode = (JSPUtil.getParameter(request, prefix	+ "trans_mode", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] inPolCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_cd", length));
			String[] inSndId = (JSPUtil.getParameter(request, prefix	+ "in_snd_id", length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd", length));
			String[] inTerminalVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_terminal_vvd_cd", length));
			String[] inBkgNo = (JSPUtil.getParameter(request, prefix	+ "in_bkg_no", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] inVvdFlg = (JSPUtil.getParameter(request, prefix	+ "in_vvd_flg", length));
			String[] inBlFlg = (JSPUtil.getParameter(request, prefix	+ "in_bl_flg", length));
			String[] inPolSplitNo = (JSPUtil.getParameter(request, prefix	+ "in_pol_split_no", length));
			String[] inPodSplitNo = (JSPUtil.getParameter(request, prefix	+ "in_pod_split_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CllCdlTransmitVO();
				if (inRcvId[i] != null)
					model.setInRcvId(inRcvId[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (inListType[i] != null)
					model.setInListType(inListType[i]);
				if (inLocalIpi[i] != null)
					model.setInLocalIpi(inLocalIpi[i]);
				if (inAreaId[i] != null)
					model.setInAreaId(inAreaId[i]);
				if (inEtcEuid[i] != null)
					model.setInEtcEuid(inEtcEuid[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (inYdCd[i] != null)
					model.setInYdCd(inYdCd[i]);
				if (inEdiMsgFunc[i] != null)
					model.setInEdiMsgFunc(inEdiMsgFunc[i]);
				if (inPodCd[i] != null)
					model.setInPodCd(inPodCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ibdTrspNo[i] != null)
					model.setIbdTrspNo(ibdTrspNo[i]);
				if (inDestSvrCd[i] != null)
					model.setInDestSvrCd(inDestSvrCd[i]);
				if (repCmdtNm[i] != null)
					model.setRepCmdtNm(repCmdtNm[i]);
				if (inWhereGubun[i] != null)
					model.setInWhereGubun(inWhereGubun[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (custrefNum[i] != null)
					model.setCustrefNum(custrefNum[i]);
				if (inLocNm[i] != null)
					model.setInLocNm(inLocNm[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (transMode[i] != null)
					model.setTransMode(transMode[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (inPolCd[i] != null)
					model.setInPolCd(inPolCd[i]);
				if (inSndId[i] != null)
					model.setInSndId(inSndId[i]);
				if (inVvdCd[i] != null)
					model.setInVvdCd(inVvdCd[i]);
				if (inTerminalVvdCd[i] != null)
					model.setInTerminalVvdCd(inTerminalVvdCd[i]);
				if (inBkgNo[i] != null)
					model.setInBkgNo(inBkgNo[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (inVvdFlg[i] != null)
					model.setInVvdFlg(inVvdFlg[i]);
				if (inBlFlg[i] != null)
					model.setInBlFlg(inBlFlg[i]);
				if (inPolSplitNo[i] != null)
					model.setInPolSplitNo(inPolSplitNo[i]);
				if (inPodSplitNo[i] != null)
					model.setInPodSplitNo(inPodSplitNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCllCdlTransmitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CllCdlTransmitVO[]
	 */
	public CllCdlTransmitVO[] getCllCdlTransmitVOs(){
		CllCdlTransmitVO[] vos = (CllCdlTransmitVO[])models.toArray(new CllCdlTransmitVO[models.size()]);
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
		this.inRcvId = this.inRcvId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inListType = this.inListType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inLocalIpi = this.inLocalIpi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inAreaId = this.inAreaId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inEtcEuid = this.inEtcEuid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inYdCd = this.inYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inEdiMsgFunc = this.inEdiMsgFunc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodCd = this.inPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspNo = this.ibdTrspNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDestSvrCd = this.inDestSvrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtNm = this.repCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inWhereGubun = this.inWhereGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custrefNum = this.custrefNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inLocNm = this.inLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transMode = this.transMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolCd = this.inPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSndId = this.inSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inTerminalVvdCd = this.inTerminalVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBkgNo = this.inBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdFlg = this.inVvdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBlFlg = this.inBlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolSplitNo = this.inPolSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodSplitNo = this.inPodSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
