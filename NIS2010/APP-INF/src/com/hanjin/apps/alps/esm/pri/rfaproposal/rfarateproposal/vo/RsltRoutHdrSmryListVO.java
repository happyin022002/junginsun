/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : RsltRoutHdrSmryListVO.java
*@FileTitle : RsltRoutHdrSmryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.31
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.08.31 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltRoutHdrSmryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltRoutHdrSmryListVO> models = new ArrayList<RsltRoutHdrSmryListVO>();
	
	/* Column Info */
	private String orgRoutPntLocDefCd = null;
	/* Column Info */
	private String destRoutPntLocDefCdProp = null;
	/* Column Info */
	private String bkgDirCallFlg = null;
	/* Column Info */
	private String prevD5Dg = null;
	/* Column Info */
	private String newPropNo = null;
	/* Column Info */
	private String naCnt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mstRfaNo = null;
	/* Column Info */
	private String destRoutPntLocDefCd = null;
	/* Column Info */
	private String orgRoutViaPortDefCd = null;
	/* Column Info */
	private String destRoutViaPortDefCd = null;
	/* Column Info */
	private String bkgSlanCd = null;
	/* Column Info */
	private String orgN1stCmncAmdtSeq = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String destRoutViaPortDefCdProp = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgVvdCd = null;
	/* Column Info */
	private String newAmdtSeq = null;
	/* Column Info */
	private String rcvDeTermCdOri = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rcvDeTermCdDest = null;
	/* Column Info */
	private String ficRtUseStsCd = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String currD4 = null;
	/* Column Info */
	private String currD5 = null;
	/* Column Info */
	private String currD2 = null;
	/* Column Info */
	private String currD5Dg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String destBsePortLocCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String prevD4Dg = null;
	/* Column Info */
	private String prevD2Dg = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String noteDpSeq = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String orgRoutViaPortDefCdProp = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String mstRoutId = null;
	/* Column Info */
	private String noteConvChgCd = null;
	/* Column Info */
	private String destCyDorRtTpCd = null;
	/* Column Info */
	private String noteConvSeq = null;
	/* Column Info */
	private String acCnt = null;
	/* Column Info */
	private String rowProperties = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String upCnt = null;
	/* Column Info */
	private String newRoutSeq = null;
	/* Column Info */
	private String ndCnt = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String bkgTsPortDefCd = null;
	/* Column Info */
	private String prevD5 = null;
	/* Column Info */
	private String orgCyDorRtTpCd = null;
	/* Column Info */
	private String orgBsePortLocCd = null;
	/* Column Info */
	private String orgRoutPntLocDefCdProp = null;
	/* Column Info */
	private String isExists = null;
	/* Column Info */
	private String prevD2 = null;
	/* Column Info */
	private String prevD4 = null;
	/* Column Info */
	private String currD4Dg = null;
	/* Column Info */
	private String routSeqProp = null;
	/* Column Info */
	private String n1stCmncAmdtSeq = null;
	/* Column Info */
	private String currD2Dg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RsltRoutHdrSmryListVO() {}

	public RsltRoutHdrSmryListVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String cmdtHdrSeq, String routSeq, String orgRoutPntLocDefCd, String orgRoutPntLocDefCdProp, String rcvDeTermCdOri, String orgRoutViaPortDefCd, String orgRoutViaPortDefCdProp, String destRoutViaPortDefCd, String destRoutViaPortDefCdProp, String destRoutPntLocDefCd, String destRoutPntLocDefCdProp, String rcvDeTermCdDest, String noteConvSeq, String effDt, String expDt, String bkgDirCallFlg, String bkgTsPortDefCd, String bkgSlanCd, String bkgVvdCd, String noteConvChgCd, String ndCnt, String naCnt, String acCnt, String upCnt, String rowProperties, String routSeqProp, String noteDpSeq, String prevD2, String prevD4, String prevD5, String currD2, String currD4, String currD5, String prevD2Dg, String prevD4Dg, String prevD5Dg, String currD2Dg, String currD4Dg, String currD5Dg, String n1stCmncAmdtSeq, String orgN1stCmncAmdtSeq, String creUsrId, String creDt, String updUsrId, String updDt, String ficRtUseStsCd, String orgCyDorRtTpCd, String destCyDorRtTpCd, String orgBsePortLocCd, String destBsePortLocCd, String mstRfaNo, String mstRoutId, String newPropNo, String newAmdtSeq, String ofcCd, String isExists, String newRoutSeq) {
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
		this.destRoutPntLocDefCdProp = destRoutPntLocDefCdProp;
		this.bkgDirCallFlg = bkgDirCallFlg;
		this.prevD5Dg = prevD5Dg;
		this.newPropNo = newPropNo;
		this.naCnt = naCnt;
		this.updUsrId = updUsrId;
		this.mstRfaNo = mstRfaNo;
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
		this.bkgSlanCd = bkgSlanCd;
		this.orgN1stCmncAmdtSeq = orgN1stCmncAmdtSeq;
		this.propNo = propNo;
		this.destRoutViaPortDefCdProp = destRoutViaPortDefCdProp;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.bkgVvdCd = bkgVvdCd;
		this.newAmdtSeq = newAmdtSeq;
		this.rcvDeTermCdOri = rcvDeTermCdOri;
		this.creDt = creDt;
		this.rcvDeTermCdDest = rcvDeTermCdDest;
		this.ficRtUseStsCd = ficRtUseStsCd;
		this.routSeq = routSeq;
		this.currD4 = currD4;
		this.currD5 = currD5;
		this.currD2 = currD2;
		this.currD5Dg = currD5Dg;
		this.updDt = updDt;
		this.destBsePortLocCd = destBsePortLocCd;
		this.ibflag = ibflag;
		this.prevD4Dg = prevD4Dg;
		this.prevD2Dg = prevD2Dg;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.noteDpSeq = noteDpSeq;
		this.expDt = expDt;
		this.orgRoutViaPortDefCdProp = orgRoutViaPortDefCdProp;
		this.creUsrId = creUsrId;
		this.svcScpCd = svcScpCd;
		this.mstRoutId = mstRoutId;
		this.noteConvChgCd = noteConvChgCd;
		this.destCyDorRtTpCd = destCyDorRtTpCd;
		this.noteConvSeq = noteConvSeq;
		this.acCnt = acCnt;
		this.rowProperties = rowProperties;
		this.effDt = effDt;
		this.upCnt = upCnt;
		this.newRoutSeq = newRoutSeq;
		this.ndCnt = ndCnt;
		this.amdtSeq = amdtSeq;
		this.bkgTsPortDefCd = bkgTsPortDefCd;
		this.prevD5 = prevD5;
		this.orgCyDorRtTpCd = orgCyDorRtTpCd;
		this.orgBsePortLocCd = orgBsePortLocCd;
		this.orgRoutPntLocDefCdProp = orgRoutPntLocDefCdProp;
		this.isExists = isExists;
		this.prevD2 = prevD2;
		this.prevD4 = prevD4;
		this.currD4Dg = currD4Dg;
		this.routSeqProp = routSeqProp;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.currD2Dg = currD2Dg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("org_rout_pnt_loc_def_cd", getOrgRoutPntLocDefCd());
		this.hashColumns.put("dest_rout_pnt_loc_def_cd_prop", getDestRoutPntLocDefCdProp());
		this.hashColumns.put("bkg_dir_call_flg", getBkgDirCallFlg());
		this.hashColumns.put("prev_d5_dg", getPrevD5Dg());
		this.hashColumns.put("new_prop_no", getNewPropNo());
		this.hashColumns.put("na_cnt", getNaCnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mst_rfa_no", getMstRfaNo());
		this.hashColumns.put("dest_rout_pnt_loc_def_cd", getDestRoutPntLocDefCd());
		this.hashColumns.put("org_rout_via_port_def_cd", getOrgRoutViaPortDefCd());
		this.hashColumns.put("dest_rout_via_port_def_cd", getDestRoutViaPortDefCd());
		this.hashColumns.put("bkg_slan_cd", getBkgSlanCd());
		this.hashColumns.put("org_n1st_cmnc_amdt_seq", getOrgN1stCmncAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("dest_rout_via_port_def_cd_prop", getDestRoutViaPortDefCdProp());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_vvd_cd", getBkgVvdCd());
		this.hashColumns.put("new_amdt_seq", getNewAmdtSeq());
		this.hashColumns.put("rcv_de_term_cd_ori", getRcvDeTermCdOri());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rcv_de_term_cd_dest", getRcvDeTermCdDest());
		this.hashColumns.put("fic_rt_use_sts_cd", getFicRtUseStsCd());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("curr_d4", getCurrD4());
		this.hashColumns.put("curr_d5", getCurrD5());
		this.hashColumns.put("curr_d2", getCurrD2());
		this.hashColumns.put("curr_d5_dg", getCurrD5Dg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dest_bse_port_loc_cd", getDestBsePortLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prev_d4_dg", getPrevD4Dg());
		this.hashColumns.put("prev_d2_dg", getPrevD2Dg());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("note_dp_seq", getNoteDpSeq());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("org_rout_via_port_def_cd_prop", getOrgRoutViaPortDefCdProp());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("mst_rout_id", getMstRoutId());
		this.hashColumns.put("note_conv_chg_cd", getNoteConvChgCd());
		this.hashColumns.put("dest_cy_dor_rt_tp_cd", getDestCyDorRtTpCd());
		this.hashColumns.put("note_conv_seq", getNoteConvSeq());
		this.hashColumns.put("ac_cnt", getAcCnt());
		this.hashColumns.put("row_properties", getRowProperties());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("up_cnt", getUpCnt());
		this.hashColumns.put("new_rout_seq", getNewRoutSeq());
		this.hashColumns.put("nd_cnt", getNdCnt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("bkg_ts_port_def_cd", getBkgTsPortDefCd());
		this.hashColumns.put("prev_d5", getPrevD5());
		this.hashColumns.put("org_cy_dor_rt_tp_cd", getOrgCyDorRtTpCd());
		this.hashColumns.put("org_bse_port_loc_cd", getOrgBsePortLocCd());
		this.hashColumns.put("org_rout_pnt_loc_def_cd_prop", getOrgRoutPntLocDefCdProp());
		this.hashColumns.put("is_exists", getIsExists());
		this.hashColumns.put("prev_d2", getPrevD2());
		this.hashColumns.put("prev_d4", getPrevD4());
		this.hashColumns.put("curr_d4_dg", getCurrD4Dg());
		this.hashColumns.put("rout_seq_prop", getRoutSeqProp());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("curr_d2_dg", getCurrD2Dg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("org_rout_pnt_loc_def_cd", "orgRoutPntLocDefCd");
		this.hashFields.put("dest_rout_pnt_loc_def_cd_prop", "destRoutPntLocDefCdProp");
		this.hashFields.put("bkg_dir_call_flg", "bkgDirCallFlg");
		this.hashFields.put("prev_d5_dg", "prevD5Dg");
		this.hashFields.put("new_prop_no", "newPropNo");
		this.hashFields.put("na_cnt", "naCnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mst_rfa_no", "mstRfaNo");
		this.hashFields.put("dest_rout_pnt_loc_def_cd", "destRoutPntLocDefCd");
		this.hashFields.put("org_rout_via_port_def_cd", "orgRoutViaPortDefCd");
		this.hashFields.put("dest_rout_via_port_def_cd", "destRoutViaPortDefCd");
		this.hashFields.put("bkg_slan_cd", "bkgSlanCd");
		this.hashFields.put("org_n1st_cmnc_amdt_seq", "orgN1stCmncAmdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("dest_rout_via_port_def_cd_prop", "destRoutViaPortDefCdProp");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_vvd_cd", "bkgVvdCd");
		this.hashFields.put("new_amdt_seq", "newAmdtSeq");
		this.hashFields.put("rcv_de_term_cd_ori", "rcvDeTermCdOri");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rcv_de_term_cd_dest", "rcvDeTermCdDest");
		this.hashFields.put("fic_rt_use_sts_cd", "ficRtUseStsCd");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("curr_d4", "currD4");
		this.hashFields.put("curr_d5", "currD5");
		this.hashFields.put("curr_d2", "currD2");
		this.hashFields.put("curr_d5_dg", "currD5Dg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dest_bse_port_loc_cd", "destBsePortLocCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prev_d4_dg", "prevD4Dg");
		this.hashFields.put("prev_d2_dg", "prevD2Dg");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("note_dp_seq", "noteDpSeq");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("org_rout_via_port_def_cd_prop", "orgRoutViaPortDefCdProp");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("mst_rout_id", "mstRoutId");
		this.hashFields.put("note_conv_chg_cd", "noteConvChgCd");
		this.hashFields.put("dest_cy_dor_rt_tp_cd", "destCyDorRtTpCd");
		this.hashFields.put("note_conv_seq", "noteConvSeq");
		this.hashFields.put("ac_cnt", "acCnt");
		this.hashFields.put("row_properties", "rowProperties");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("up_cnt", "upCnt");
		this.hashFields.put("new_rout_seq", "newRoutSeq");
		this.hashFields.put("nd_cnt", "ndCnt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("bkg_ts_port_def_cd", "bkgTsPortDefCd");
		this.hashFields.put("prev_d5", "prevD5");
		this.hashFields.put("org_cy_dor_rt_tp_cd", "orgCyDorRtTpCd");
		this.hashFields.put("org_bse_port_loc_cd", "orgBsePortLocCd");
		this.hashFields.put("org_rout_pnt_loc_def_cd_prop", "orgRoutPntLocDefCdProp");
		this.hashFields.put("is_exists", "isExists");
		this.hashFields.put("prev_d2", "prevD2");
		this.hashFields.put("prev_d4", "prevD4");
		this.hashFields.put("curr_d4_dg", "currD4Dg");
		this.hashFields.put("rout_seq_prop", "routSeqProp");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("curr_d2_dg", "currD2Dg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return orgRoutPntLocDefCd
	 */
	public String getOrgRoutPntLocDefCd() {
		return this.orgRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return destRoutPntLocDefCdProp
	 */
	public String getDestRoutPntLocDefCdProp() {
		return this.destRoutPntLocDefCdProp;
	}
	
	/**
	 * Column Info
	 * @return bkgDirCallFlg
	 */
	public String getBkgDirCallFlg() {
		return this.bkgDirCallFlg;
	}
	
	/**
	 * Column Info
	 * @return prevD5Dg
	 */
	public String getPrevD5Dg() {
		return this.prevD5Dg;
	}
	
	/**
	 * Column Info
	 * @return newPropNo
	 */
	public String getNewPropNo() {
		return this.newPropNo;
	}
	
	/**
	 * Column Info
	 * @return naCnt
	 */
	public String getNaCnt() {
		return this.naCnt;
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
	 * @return mstRfaNo
	 */
	public String getMstRfaNo() {
		return this.mstRfaNo;
	}
	
	/**
	 * Column Info
	 * @return destRoutPntLocDefCd
	 */
	public String getDestRoutPntLocDefCd() {
		return this.destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return orgRoutViaPortDefCd
	 */
	public String getOrgRoutViaPortDefCd() {
		return this.orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return destRoutViaPortDefCd
	 */
	public String getDestRoutViaPortDefCd() {
		return this.destRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return bkgSlanCd
	 */
	public String getBkgSlanCd() {
		return this.bkgSlanCd;
	}
	
	/**
	 * Column Info
	 * @return orgN1stCmncAmdtSeq
	 */
	public String getOrgN1stCmncAmdtSeq() {
		return this.orgN1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return destRoutViaPortDefCdProp
	 */
	public String getDestRoutViaPortDefCdProp() {
		return this.destRoutViaPortDefCdProp;
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
	 * @return bkgVvdCd
	 */
	public String getBkgVvdCd() {
		return this.bkgVvdCd;
	}
	
	/**
	 * Column Info
	 * @return newAmdtSeq
	 */
	public String getNewAmdtSeq() {
		return this.newAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return rcvDeTermCdOri
	 */
	public String getRcvDeTermCdOri() {
		return this.rcvDeTermCdOri;
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
	 * @return rcvDeTermCdDest
	 */
	public String getRcvDeTermCdDest() {
		return this.rcvDeTermCdDest;
	}
	
	/**
	 * Column Info
	 * @return ficRtUseStsCd
	 */
	public String getFicRtUseStsCd() {
		return this.ficRtUseStsCd;
	}
	
	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
	}
	
	/**
	 * Column Info
	 * @return currD4
	 */
	public String getCurrD4() {
		return this.currD4;
	}
	
	/**
	 * Column Info
	 * @return currD5
	 */
	public String getCurrD5() {
		return this.currD5;
	}
	
	/**
	 * Column Info
	 * @return currD2
	 */
	public String getCurrD2() {
		return this.currD2;
	}
	
	/**
	 * Column Info
	 * @return currD5Dg
	 */
	public String getCurrD5Dg() {
		return this.currD5Dg;
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
	 * @return destBsePortLocCd
	 */
	public String getDestBsePortLocCd() {
		return this.destBsePortLocCd;
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
	 * @return prevD4Dg
	 */
	public String getPrevD4Dg() {
		return this.prevD4Dg;
	}
	
	/**
	 * Column Info
	 * @return prevD2Dg
	 */
	public String getPrevD2Dg() {
		return this.prevD2Dg;
	}
	
	/**
	 * Column Info
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return noteDpSeq
	 */
	public String getNoteDpSeq() {
		return this.noteDpSeq;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return orgRoutViaPortDefCdProp
	 */
	public String getOrgRoutViaPortDefCdProp() {
		return this.orgRoutViaPortDefCdProp;
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return mstRoutId
	 */
	public String getMstRoutId() {
		return this.mstRoutId;
	}
	
	/**
	 * Column Info
	 * @return noteConvChgCd
	 */
	public String getNoteConvChgCd() {
		return this.noteConvChgCd;
	}
	
	/**
	 * Column Info
	 * @return destCyDorRtTpCd
	 */
	public String getDestCyDorRtTpCd() {
		return this.destCyDorRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return noteConvSeq
	 */
	public String getNoteConvSeq() {
		return this.noteConvSeq;
	}
	
	/**
	 * Column Info
	 * @return acCnt
	 */
	public String getAcCnt() {
		return this.acCnt;
	}
	
	/**
	 * Column Info
	 * @return rowProperties
	 */
	public String getRowProperties() {
		return this.rowProperties;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return upCnt
	 */
	public String getUpCnt() {
		return this.upCnt;
	}
	
	/**
	 * Column Info
	 * @return newRoutSeq
	 */
	public String getNewRoutSeq() {
		return this.newRoutSeq;
	}
	
	/**
	 * Column Info
	 * @return ndCnt
	 */
	public String getNdCnt() {
		return this.ndCnt;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgTsPortDefCd
	 */
	public String getBkgTsPortDefCd() {
		return this.bkgTsPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return prevD5
	 */
	public String getPrevD5() {
		return this.prevD5;
	}
	
	/**
	 * Column Info
	 * @return orgCyDorRtTpCd
	 */
	public String getOrgCyDorRtTpCd() {
		return this.orgCyDorRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return orgBsePortLocCd
	 */
	public String getOrgBsePortLocCd() {
		return this.orgBsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @return orgRoutPntLocDefCdProp
	 */
	public String getOrgRoutPntLocDefCdProp() {
		return this.orgRoutPntLocDefCdProp;
	}
	
	/**
	 * Column Info
	 * @return isExists
	 */
	public String getIsExists() {
		return this.isExists;
	}
	
	/**
	 * Column Info
	 * @return prevD2
	 */
	public String getPrevD2() {
		return this.prevD2;
	}
	
	/**
	 * Column Info
	 * @return prevD4
	 */
	public String getPrevD4() {
		return this.prevD4;
	}
	
	/**
	 * Column Info
	 * @return currD4Dg
	 */
	public String getCurrD4Dg() {
		return this.currD4Dg;
	}
	
	/**
	 * Column Info
	 * @return routSeqProp
	 */
	public String getRoutSeqProp() {
		return this.routSeqProp;
	}
	
	/**
	 * Column Info
	 * @return n1stCmncAmdtSeq
	 */
	public String getN1stCmncAmdtSeq() {
		return this.n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return currD2Dg
	 */
	public String getCurrD2Dg() {
		return this.currD2Dg;
	}
	

	/**
	 * Column Info
	 * @param orgRoutPntLocDefCd
	 */
	public void setOrgRoutPntLocDefCd(String orgRoutPntLocDefCd) {
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param destRoutPntLocDefCdProp
	 */
	public void setDestRoutPntLocDefCdProp(String destRoutPntLocDefCdProp) {
		this.destRoutPntLocDefCdProp = destRoutPntLocDefCdProp;
	}
	
	/**
	 * Column Info
	 * @param bkgDirCallFlg
	 */
	public void setBkgDirCallFlg(String bkgDirCallFlg) {
		this.bkgDirCallFlg = bkgDirCallFlg;
	}
	
	/**
	 * Column Info
	 * @param prevD5Dg
	 */
	public void setPrevD5Dg(String prevD5Dg) {
		this.prevD5Dg = prevD5Dg;
	}
	
	/**
	 * Column Info
	 * @param newPropNo
	 */
	public void setNewPropNo(String newPropNo) {
		this.newPropNo = newPropNo;
	}
	
	/**
	 * Column Info
	 * @param naCnt
	 */
	public void setNaCnt(String naCnt) {
		this.naCnt = naCnt;
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
	 * @param mstRfaNo
	 */
	public void setMstRfaNo(String mstRfaNo) {
		this.mstRfaNo = mstRfaNo;
	}
	
	/**
	 * Column Info
	 * @param destRoutPntLocDefCd
	 */
	public void setDestRoutPntLocDefCd(String destRoutPntLocDefCd) {
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param orgRoutViaPortDefCd
	 */
	public void setOrgRoutViaPortDefCd(String orgRoutViaPortDefCd) {
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param destRoutViaPortDefCd
	 */
	public void setDestRoutViaPortDefCd(String destRoutViaPortDefCd) {
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param bkgSlanCd
	 */
	public void setBkgSlanCd(String bkgSlanCd) {
		this.bkgSlanCd = bkgSlanCd;
	}
	
	/**
	 * Column Info
	 * @param orgN1stCmncAmdtSeq
	 */
	public void setOrgN1stCmncAmdtSeq(String orgN1stCmncAmdtSeq) {
		this.orgN1stCmncAmdtSeq = orgN1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param destRoutViaPortDefCdProp
	 */
	public void setDestRoutViaPortDefCdProp(String destRoutViaPortDefCdProp) {
		this.destRoutViaPortDefCdProp = destRoutViaPortDefCdProp;
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
	 * @param bkgVvdCd
	 */
	public void setBkgVvdCd(String bkgVvdCd) {
		this.bkgVvdCd = bkgVvdCd;
	}
	
	/**
	 * Column Info
	 * @param newAmdtSeq
	 */
	public void setNewAmdtSeq(String newAmdtSeq) {
		this.newAmdtSeq = newAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param rcvDeTermCdOri
	 */
	public void setRcvDeTermCdOri(String rcvDeTermCdOri) {
		this.rcvDeTermCdOri = rcvDeTermCdOri;
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
	 * @param rcvDeTermCdDest
	 */
	public void setRcvDeTermCdDest(String rcvDeTermCdDest) {
		this.rcvDeTermCdDest = rcvDeTermCdDest;
	}
	
	/**
	 * Column Info
	 * @param ficRtUseStsCd
	 */
	public void setFicRtUseStsCd(String ficRtUseStsCd) {
		this.ficRtUseStsCd = ficRtUseStsCd;
	}
	
	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}
	
	/**
	 * Column Info
	 * @param currD4
	 */
	public void setCurrD4(String currD4) {
		this.currD4 = currD4;
	}
	
	/**
	 * Column Info
	 * @param currD5
	 */
	public void setCurrD5(String currD5) {
		this.currD5 = currD5;
	}
	
	/**
	 * Column Info
	 * @param currD2
	 */
	public void setCurrD2(String currD2) {
		this.currD2 = currD2;
	}
	
	/**
	 * Column Info
	 * @param currD5Dg
	 */
	public void setCurrD5Dg(String currD5Dg) {
		this.currD5Dg = currD5Dg;
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
	 * @param destBsePortLocCd
	 */
	public void setDestBsePortLocCd(String destBsePortLocCd) {
		this.destBsePortLocCd = destBsePortLocCd;
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
	 * @param prevD4Dg
	 */
	public void setPrevD4Dg(String prevD4Dg) {
		this.prevD4Dg = prevD4Dg;
	}
	
	/**
	 * Column Info
	 * @param prevD2Dg
	 */
	public void setPrevD2Dg(String prevD2Dg) {
		this.prevD2Dg = prevD2Dg;
	}
	
	/**
	 * Column Info
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param noteDpSeq
	 */
	public void setNoteDpSeq(String noteDpSeq) {
		this.noteDpSeq = noteDpSeq;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param orgRoutViaPortDefCdProp
	 */
	public void setOrgRoutViaPortDefCdProp(String orgRoutViaPortDefCdProp) {
		this.orgRoutViaPortDefCdProp = orgRoutViaPortDefCdProp;
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
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param mstRoutId
	 */
	public void setMstRoutId(String mstRoutId) {
		this.mstRoutId = mstRoutId;
	}
	
	/**
	 * Column Info
	 * @param noteConvChgCd
	 */
	public void setNoteConvChgCd(String noteConvChgCd) {
		this.noteConvChgCd = noteConvChgCd;
	}
	
	/**
	 * Column Info
	 * @param destCyDorRtTpCd
	 */
	public void setDestCyDorRtTpCd(String destCyDorRtTpCd) {
		this.destCyDorRtTpCd = destCyDorRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param noteConvSeq
	 */
	public void setNoteConvSeq(String noteConvSeq) {
		this.noteConvSeq = noteConvSeq;
	}
	
	/**
	 * Column Info
	 * @param acCnt
	 */
	public void setAcCnt(String acCnt) {
		this.acCnt = acCnt;
	}
	
	/**
	 * Column Info
	 * @param rowProperties
	 */
	public void setRowProperties(String rowProperties) {
		this.rowProperties = rowProperties;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param upCnt
	 */
	public void setUpCnt(String upCnt) {
		this.upCnt = upCnt;
	}
	
	/**
	 * Column Info
	 * @param newRoutSeq
	 */
	public void setNewRoutSeq(String newRoutSeq) {
		this.newRoutSeq = newRoutSeq;
	}
	
	/**
	 * Column Info
	 * @param ndCnt
	 */
	public void setNdCnt(String ndCnt) {
		this.ndCnt = ndCnt;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgTsPortDefCd
	 */
	public void setBkgTsPortDefCd(String bkgTsPortDefCd) {
		this.bkgTsPortDefCd = bkgTsPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param prevD5
	 */
	public void setPrevD5(String prevD5) {
		this.prevD5 = prevD5;
	}
	
	/**
	 * Column Info
	 * @param orgCyDorRtTpCd
	 */
	public void setOrgCyDorRtTpCd(String orgCyDorRtTpCd) {
		this.orgCyDorRtTpCd = orgCyDorRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param orgBsePortLocCd
	 */
	public void setOrgBsePortLocCd(String orgBsePortLocCd) {
		this.orgBsePortLocCd = orgBsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @param orgRoutPntLocDefCdProp
	 */
	public void setOrgRoutPntLocDefCdProp(String orgRoutPntLocDefCdProp) {
		this.orgRoutPntLocDefCdProp = orgRoutPntLocDefCdProp;
	}
	
	/**
	 * Column Info
	 * @param isExists
	 */
	public void setIsExists(String isExists) {
		this.isExists = isExists;
	}
	
	/**
	 * Column Info
	 * @param prevD2
	 */
	public void setPrevD2(String prevD2) {
		this.prevD2 = prevD2;
	}
	
	/**
	 * Column Info
	 * @param prevD4
	 */
	public void setPrevD4(String prevD4) {
		this.prevD4 = prevD4;
	}
	
	/**
	 * Column Info
	 * @param currD4Dg
	 */
	public void setCurrD4Dg(String currD4Dg) {
		this.currD4Dg = currD4Dg;
	}
	
	/**
	 * Column Info
	 * @param routSeqProp
	 */
	public void setRoutSeqProp(String routSeqProp) {
		this.routSeqProp = routSeqProp;
	}
	
	/**
	 * Column Info
	 * @param n1stCmncAmdtSeq
	 */
	public void setN1stCmncAmdtSeq(String n1stCmncAmdtSeq) {
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param currD2Dg
	 */
	public void setCurrD2Dg(String currD2Dg) {
		this.currD2Dg = currD2Dg;
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
		setOrgRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_cd", ""));
		setDestRoutPntLocDefCdProp(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_cd_prop", ""));
		setBkgDirCallFlg(JSPUtil.getParameter(request, prefix + "bkg_dir_call_flg", ""));
		setPrevD5Dg(JSPUtil.getParameter(request, prefix + "prev_d5_dg", ""));
		setNewPropNo(JSPUtil.getParameter(request, prefix + "new_prop_no", ""));
		setNaCnt(JSPUtil.getParameter(request, prefix + "na_cnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setMstRfaNo(JSPUtil.getParameter(request, prefix + "mst_rfa_no", ""));
		setDestRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_cd", ""));
		setOrgRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "org_rout_via_port_def_cd", ""));
		setDestRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_via_port_def_cd", ""));
		setBkgSlanCd(JSPUtil.getParameter(request, prefix + "bkg_slan_cd", ""));
		setOrgN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "org_n1st_cmnc_amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setDestRoutViaPortDefCdProp(JSPUtil.getParameter(request, prefix + "dest_rout_via_port_def_cd_prop", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBkgVvdCd(JSPUtil.getParameter(request, prefix + "bkg_vvd_cd", ""));
		setNewAmdtSeq(JSPUtil.getParameter(request, prefix + "new_amdt_seq", ""));
		setRcvDeTermCdOri(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd_ori", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRcvDeTermCdDest(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd_dest", ""));
		setFicRtUseStsCd(JSPUtil.getParameter(request, prefix + "fic_rt_use_sts_cd", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setCurrD4(JSPUtil.getParameter(request, prefix + "curr_d4", ""));
		setCurrD5(JSPUtil.getParameter(request, prefix + "curr_d5", ""));
		setCurrD2(JSPUtil.getParameter(request, prefix + "curr_d2", ""));
		setCurrD5Dg(JSPUtil.getParameter(request, prefix + "curr_d5_dg", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDestBsePortLocCd(JSPUtil.getParameter(request, prefix + "dest_bse_port_loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPrevD4Dg(JSPUtil.getParameter(request, prefix + "prev_d4_dg", ""));
		setPrevD2Dg(JSPUtil.getParameter(request, prefix + "prev_d2_dg", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq", ""));
		setNoteDpSeq(JSPUtil.getParameter(request, prefix + "note_dp_seq", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setOrgRoutViaPortDefCdProp(JSPUtil.getParameter(request, prefix + "org_rout_via_port_def_cd_prop", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setMstRoutId(JSPUtil.getParameter(request, prefix + "mst_rout_id", ""));
		setNoteConvChgCd(JSPUtil.getParameter(request, prefix + "note_conv_chg_cd", ""));
		setDestCyDorRtTpCd(JSPUtil.getParameter(request, prefix + "dest_cy_dor_rt_tp_cd", ""));
		setNoteConvSeq(JSPUtil.getParameter(request, prefix + "note_conv_seq", ""));
		setAcCnt(JSPUtil.getParameter(request, prefix + "ac_cnt", ""));
		setRowProperties(JSPUtil.getParameter(request, prefix + "row_properties", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setUpCnt(JSPUtil.getParameter(request, prefix + "up_cnt", ""));
		setNewRoutSeq(JSPUtil.getParameter(request, prefix + "new_rout_seq", ""));
		setNdCnt(JSPUtil.getParameter(request, prefix + "nd_cnt", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setBkgTsPortDefCd(JSPUtil.getParameter(request, prefix + "bkg_ts_port_def_cd", ""));
		setPrevD5(JSPUtil.getParameter(request, prefix + "prev_d5", ""));
		setOrgCyDorRtTpCd(JSPUtil.getParameter(request, prefix + "org_cy_dor_rt_tp_cd", ""));
		setOrgBsePortLocCd(JSPUtil.getParameter(request, prefix + "org_bse_port_loc_cd", ""));
		setOrgRoutPntLocDefCdProp(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_cd_prop", ""));
		setIsExists(JSPUtil.getParameter(request, prefix + "is_exists", ""));
		setPrevD2(JSPUtil.getParameter(request, prefix + "prev_d2", ""));
		setPrevD4(JSPUtil.getParameter(request, prefix + "prev_d4", ""));
		setCurrD4Dg(JSPUtil.getParameter(request, prefix + "curr_d4_dg", ""));
		setRoutSeqProp(JSPUtil.getParameter(request, prefix + "rout_seq_prop", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "n1st_cmnc_amdt_seq", ""));
		setCurrD2Dg(JSPUtil.getParameter(request, prefix + "curr_d2_dg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltRoutHdrSmryListVO[]
	 */
	public RsltRoutHdrSmryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltRoutHdrSmryListVO[]
	 */
	public RsltRoutHdrSmryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRoutHdrSmryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] orgRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_cd", length));
			String[] destRoutPntLocDefCdProp = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_cd_prop", length));
			String[] bkgDirCallFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_dir_call_flg", length));
			String[] prevD5Dg = (JSPUtil.getParameter(request, prefix	+ "prev_d5_dg", length));
			String[] newPropNo = (JSPUtil.getParameter(request, prefix	+ "new_prop_no", length));
			String[] naCnt = (JSPUtil.getParameter(request, prefix	+ "na_cnt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mstRfaNo = (JSPUtil.getParameter(request, prefix	+ "mst_rfa_no", length));
			String[] destRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_cd", length));
			String[] orgRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_def_cd", length));
			String[] destRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_def_cd", length));
			String[] bkgSlanCd = (JSPUtil.getParameter(request, prefix	+ "bkg_slan_cd", length));
			String[] orgN1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "org_n1st_cmnc_amdt_seq", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] destRoutViaPortDefCdProp = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_def_cd_prop", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgVvdCd = (JSPUtil.getParameter(request, prefix	+ "bkg_vvd_cd", length));
			String[] newAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "new_amdt_seq", length));
			String[] rcvDeTermCdOri = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd_ori", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rcvDeTermCdDest = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd_dest", length));
			String[] ficRtUseStsCd = (JSPUtil.getParameter(request, prefix	+ "fic_rt_use_sts_cd", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] currD4 = (JSPUtil.getParameter(request, prefix	+ "curr_d4", length));
			String[] currD5 = (JSPUtil.getParameter(request, prefix	+ "curr_d5", length));
			String[] currD2 = (JSPUtil.getParameter(request, prefix	+ "curr_d2", length));
			String[] currD5Dg = (JSPUtil.getParameter(request, prefix	+ "curr_d5_dg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] destBsePortLocCd = (JSPUtil.getParameter(request, prefix	+ "dest_bse_port_loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] prevD4Dg = (JSPUtil.getParameter(request, prefix	+ "prev_d4_dg", length));
			String[] prevD2Dg = (JSPUtil.getParameter(request, prefix	+ "prev_d2_dg", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] noteDpSeq = (JSPUtil.getParameter(request, prefix	+ "note_dp_seq", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] orgRoutViaPortDefCdProp = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_def_cd_prop", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] mstRoutId = (JSPUtil.getParameter(request, prefix	+ "mst_rout_id", length));
			String[] noteConvChgCd = (JSPUtil.getParameter(request, prefix	+ "note_conv_chg_cd", length));
			String[] destCyDorRtTpCd = (JSPUtil.getParameter(request, prefix	+ "dest_cy_dor_rt_tp_cd", length));
			String[] noteConvSeq = (JSPUtil.getParameter(request, prefix	+ "note_conv_seq", length));
			String[] acCnt = (JSPUtil.getParameter(request, prefix	+ "ac_cnt", length));
			String[] rowProperties = (JSPUtil.getParameter(request, prefix	+ "row_properties", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] upCnt = (JSPUtil.getParameter(request, prefix	+ "up_cnt", length));
			String[] newRoutSeq = (JSPUtil.getParameter(request, prefix	+ "new_rout_seq", length));
			String[] ndCnt = (JSPUtil.getParameter(request, prefix	+ "nd_cnt", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] bkgTsPortDefCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ts_port_def_cd", length));
			String[] prevD5 = (JSPUtil.getParameter(request, prefix	+ "prev_d5", length));
			String[] orgCyDorRtTpCd = (JSPUtil.getParameter(request, prefix	+ "org_cy_dor_rt_tp_cd", length));
			String[] orgBsePortLocCd = (JSPUtil.getParameter(request, prefix	+ "org_bse_port_loc_cd", length));
			String[] orgRoutPntLocDefCdProp = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_cd_prop", length));
			String[] isExists = (JSPUtil.getParameter(request, prefix	+ "is_exists", length));
			String[] prevD2 = (JSPUtil.getParameter(request, prefix	+ "prev_d2", length));
			String[] prevD4 = (JSPUtil.getParameter(request, prefix	+ "prev_d4", length));
			String[] currD4Dg = (JSPUtil.getParameter(request, prefix	+ "curr_d4_dg", length));
			String[] routSeqProp = (JSPUtil.getParameter(request, prefix	+ "rout_seq_prop", length));
			String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
			String[] currD2Dg = (JSPUtil.getParameter(request, prefix	+ "curr_d2_dg", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltRoutHdrSmryListVO();
				if (orgRoutPntLocDefCd[i] != null)
					model.setOrgRoutPntLocDefCd(orgRoutPntLocDefCd[i]);
				if (destRoutPntLocDefCdProp[i] != null)
					model.setDestRoutPntLocDefCdProp(destRoutPntLocDefCdProp[i]);
				if (bkgDirCallFlg[i] != null)
					model.setBkgDirCallFlg(bkgDirCallFlg[i]);
				if (prevD5Dg[i] != null)
					model.setPrevD5Dg(prevD5Dg[i]);
				if (newPropNo[i] != null)
					model.setNewPropNo(newPropNo[i]);
				if (naCnt[i] != null)
					model.setNaCnt(naCnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mstRfaNo[i] != null)
					model.setMstRfaNo(mstRfaNo[i]);
				if (destRoutPntLocDefCd[i] != null)
					model.setDestRoutPntLocDefCd(destRoutPntLocDefCd[i]);
				if (orgRoutViaPortDefCd[i] != null)
					model.setOrgRoutViaPortDefCd(orgRoutViaPortDefCd[i]);
				if (destRoutViaPortDefCd[i] != null)
					model.setDestRoutViaPortDefCd(destRoutViaPortDefCd[i]);
				if (bkgSlanCd[i] != null)
					model.setBkgSlanCd(bkgSlanCd[i]);
				if (orgN1stCmncAmdtSeq[i] != null)
					model.setOrgN1stCmncAmdtSeq(orgN1stCmncAmdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (destRoutViaPortDefCdProp[i] != null)
					model.setDestRoutViaPortDefCdProp(destRoutViaPortDefCdProp[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgVvdCd[i] != null)
					model.setBkgVvdCd(bkgVvdCd[i]);
				if (newAmdtSeq[i] != null)
					model.setNewAmdtSeq(newAmdtSeq[i]);
				if (rcvDeTermCdOri[i] != null)
					model.setRcvDeTermCdOri(rcvDeTermCdOri[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rcvDeTermCdDest[i] != null)
					model.setRcvDeTermCdDest(rcvDeTermCdDest[i]);
				if (ficRtUseStsCd[i] != null)
					model.setFicRtUseStsCd(ficRtUseStsCd[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (currD4[i] != null)
					model.setCurrD4(currD4[i]);
				if (currD5[i] != null)
					model.setCurrD5(currD5[i]);
				if (currD2[i] != null)
					model.setCurrD2(currD2[i]);
				if (currD5Dg[i] != null)
					model.setCurrD5Dg(currD5Dg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (destBsePortLocCd[i] != null)
					model.setDestBsePortLocCd(destBsePortLocCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (prevD4Dg[i] != null)
					model.setPrevD4Dg(prevD4Dg[i]);
				if (prevD2Dg[i] != null)
					model.setPrevD2Dg(prevD2Dg[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (noteDpSeq[i] != null)
					model.setNoteDpSeq(noteDpSeq[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (orgRoutViaPortDefCdProp[i] != null)
					model.setOrgRoutViaPortDefCdProp(orgRoutViaPortDefCdProp[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (mstRoutId[i] != null)
					model.setMstRoutId(mstRoutId[i]);
				if (noteConvChgCd[i] != null)
					model.setNoteConvChgCd(noteConvChgCd[i]);
				if (destCyDorRtTpCd[i] != null)
					model.setDestCyDorRtTpCd(destCyDorRtTpCd[i]);
				if (noteConvSeq[i] != null)
					model.setNoteConvSeq(noteConvSeq[i]);
				if (acCnt[i] != null)
					model.setAcCnt(acCnt[i]);
				if (rowProperties[i] != null)
					model.setRowProperties(rowProperties[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (upCnt[i] != null)
					model.setUpCnt(upCnt[i]);
				if (newRoutSeq[i] != null)
					model.setNewRoutSeq(newRoutSeq[i]);
				if (ndCnt[i] != null)
					model.setNdCnt(ndCnt[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (bkgTsPortDefCd[i] != null)
					model.setBkgTsPortDefCd(bkgTsPortDefCd[i]);
				if (prevD5[i] != null)
					model.setPrevD5(prevD5[i]);
				if (orgCyDorRtTpCd[i] != null)
					model.setOrgCyDorRtTpCd(orgCyDorRtTpCd[i]);
				if (orgBsePortLocCd[i] != null)
					model.setOrgBsePortLocCd(orgBsePortLocCd[i]);
				if (orgRoutPntLocDefCdProp[i] != null)
					model.setOrgRoutPntLocDefCdProp(orgRoutPntLocDefCdProp[i]);
				if (isExists[i] != null)
					model.setIsExists(isExists[i]);
				if (prevD2[i] != null)
					model.setPrevD2(prevD2[i]);
				if (prevD4[i] != null)
					model.setPrevD4(prevD4[i]);
				if (currD4Dg[i] != null)
					model.setCurrD4Dg(currD4Dg[i]);
				if (routSeqProp[i] != null)
					model.setRoutSeqProp(routSeqProp[i]);
				if (n1stCmncAmdtSeq[i] != null)
					model.setN1stCmncAmdtSeq(n1stCmncAmdtSeq[i]);
				if (currD2Dg[i] != null)
					model.setCurrD2Dg(currD2Dg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRoutHdrSmryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltRoutHdrSmryListVO[]
	 */
	public RsltRoutHdrSmryListVO[] getRsltRoutHdrSmryListVOs(){
		RsltRoutHdrSmryListVO[] vos = (RsltRoutHdrSmryListVO[])models.toArray(new RsltRoutHdrSmryListVO[models.size()]);
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
		this.orgRoutPntLocDefCd = this.orgRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefCdProp = this.destRoutPntLocDefCdProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDirCallFlg = this.bkgDirCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevD5Dg = this.prevD5Dg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPropNo = this.newPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.naCnt = this.naCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstRfaNo = this.mstRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefCd = this.destRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortDefCd = this.orgRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutViaPortDefCd = this.destRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSlanCd = this.bkgSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgN1stCmncAmdtSeq = this.orgN1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutViaPortDefCdProp = this.destRoutViaPortDefCdProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVvdCd = this.bkgVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newAmdtSeq = this.newAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCdOri = this.rcvDeTermCdOri .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCdDest = this.rcvDeTermCdDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRtUseStsCd = this.ficRtUseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currD4 = this.currD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currD5 = this.currD5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currD2 = this.currD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currD5Dg = this.currD5Dg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destBsePortLocCd = this.destBsePortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevD4Dg = this.prevD4Dg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevD2Dg = this.prevD2Dg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteDpSeq = this.noteDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortDefCdProp = this.orgRoutViaPortDefCdProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstRoutId = this.mstRoutId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvChgCd = this.noteConvChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destCyDorRtTpCd = this.destCyDorRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvSeq = this.noteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acCnt = this.acCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowProperties = this.rowProperties .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upCnt = this.upCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newRoutSeq = this.newRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ndCnt = this.ndCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTsPortDefCd = this.bkgTsPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevD5 = this.prevD5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCyDorRtTpCd = this.orgCyDorRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgBsePortLocCd = this.orgBsePortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefCdProp = this.orgRoutPntLocDefCdProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isExists = this.isExists .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevD2 = this.prevD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevD4 = this.prevD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currD4Dg = this.currD4Dg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeqProp = this.routSeqProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currD2Dg = this.currD2Dg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
