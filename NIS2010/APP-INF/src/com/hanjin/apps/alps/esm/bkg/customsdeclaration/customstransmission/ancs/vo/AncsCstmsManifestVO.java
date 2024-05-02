/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsCstmsManifestVO.java
*@FileTitle : AncsCstmsManifestVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.10.29 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.syscommon.common.table.BkgCstmsAnrBlLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsAnrCntrLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsAnrEdiHisVO;
import com.hanjin.syscommon.common.table.BkgCstmsAnrEdiMsgVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AncsCstmsManifestVO extends CstmsManifestVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<AncsCstmsManifestVO> models = new ArrayList<AncsCstmsManifestVO>();
	
	private List<BkgCstmsAnrEdiHisVO> bkgCstmsAnrEdiHisVOs = null;
	private BkgCstmsAnrEdiHisVO       bkgCstmsAnrEdiHisVO  = null;
	private List<BkgCstmsAnrEdiMsgVO> bkgCstmsAnrEdiMsgVOs = null;
	private BkgCstmsAnrEdiMsgVO       bkgCstmsAnrEdiMsgVO  = null;
	private List<BkgCstmsAnrBlLogVO>  bkgCstmsAnrBlLogVOs = null;
	private BkgCstmsAnrBlLogVO        bkgCstmsAnrBlLogVO  = null;
	private List<BkgCstmsAnrCntrLogVO> bkgCstmsAnrCntrLogVOs = null;
	private BkgCstmsAnrCntrLogVO       bkgCstmsAnrCntrLogVO  = null;
	private List<List<BkgCstmsAnrEdiMsgVO>> bkgCstmsAnrEdiMsgVOss = null;
	
	/* Column Info */
	private String svcRqstNo = null;
	/* Column Info */
	private String cneeAddr = null;
	/* Column Info */
	private String blAck = null;
	/* Column Info */
	private String prevDocno = null;
	/* Column Info */
	private String cmPckQty = null;
	/* Column Info */
	private String blAck2 = null;
	/* Column Info */
	private String anrMsgStsCd = null;
	/* Column Info */
	private String lloydCd = null;
	/* Column Info */
	private String cntrMfWgt = null;
	/* Column Info */
	private String lstEdiMsg = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cntrAck2 = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String brthDesc = null;
	/* Column Info */
	private String cntrSeq = null;
	/* Column Info */
	private String cntrWgtUtCd = null;
	/* Column Info */
	private String cntrAck = null;
	/* Column Info */
	private String itemDesc = null;
	/* Column Info */
	private String mfDesc = null;
	/* Column Info */
	private String vvdSeq = null;
	/* Column Info */
	private String cntrPckTpCd = null;
	/* Column Info */
	private String itemNo = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String msgTpCd = null;
	/* Column Info */
	private String rdTerm = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ntfyName = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String pstRlyPortCd = null;
	/* Column Info */
	private String declFlg = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String shprName = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String msgSeq = null;
	/* Column Info */
	private String kind = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actWgtUtCd = null;
	/* Column Info */
	private String shprAddr = null;
	/* Column Info */
	private String cntrMfDesc = null;
	/* Column Info */
	private String cmCntrNo = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String newEdiMsg = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String blLastEdi = null;
	/* Column Info */
	private String anrDeclNo = null;
	/* Column Info */
	private String blLastEdi2 = null;
	/* Column Info */
	private String cntrLastEdi2 = null;
	/* Column Info */
	private String cntrAnrMsgStsCd = null;
	/* Column Info */
	private String ntfyAddr = null;
	/* Column Info */
	private String cngFlg = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String ntfyEml = null;
	/* Column Info */
	private String cmPckTpCd = null;
	/* Column Info */
	private String cneeName = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String sequence = null;
	/* Column Info */
	private String cntrPckQty = null;
	/* Column Info */
	private String cntrLastEdi = null;
	/* Column Info */
	private String cntrFm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AncsCstmsManifestVO() {}

	public AncsCstmsManifestVO(String ibflag, String pagerows, String svcRqstNo, String cneeAddr, String blAck, String prevDocno, String cmPckQty, String blAck2, String anrMsgStsCd, String lloydCd, String cntrMfWgt, String blNo, String polCd, String cntrWgtUtCd, String cntrSeq, String brthDesc, String wgtUtCd, String cntrTpszCd, String cntrAck2, String cntrAck, String mfDesc, String vvdSeq, String cntrPckTpCd, String preRlyPortCd, String delCd, String rdTerm, String vvd, String podCd, String bkgNo, String ntfyName, String pstRlyPortCd, String declFlg, String porCd, String bdrFlg, String kind, String actWgtUtCd, String shprAddr, String cntrMfDesc, String cmCntrNo, String pckQty, String pckTpCd, String blLastEdi, String anrDeclNo, String blLastEdi2, String cntrLastEdi2, String cntrAnrMsgStsCd, String ntfyAddr, String actWgt, String cmPckTpCd, String sequence, String cntrNo, String cntrPckQty, String cntrFm, String cntrLastEdi, String msgTpCd, String msgSeq, String shprName, String cneeName, String faxNo, String ntfyEml, String itemNo, String cngFlg, String newEdiMsg, String lstEdiMsg, String itemDesc) {
		this.svcRqstNo = svcRqstNo;
		this.cneeAddr = cneeAddr;
		this.blAck = blAck;
		this.prevDocno = prevDocno;
		this.cmPckQty = cmPckQty;
		this.blAck2 = blAck2;
		this.anrMsgStsCd = anrMsgStsCd;
		this.lloydCd = lloydCd;
		this.cntrMfWgt = cntrMfWgt;
		this.lstEdiMsg = lstEdiMsg;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.cntrAck2 = cntrAck2;
		this.cntrTpszCd = cntrTpszCd;
		this.wgtUtCd = wgtUtCd;
		this.brthDesc = brthDesc;
		this.cntrSeq = cntrSeq;
		this.cntrWgtUtCd = cntrWgtUtCd;
		this.cntrAck = cntrAck;
		this.itemDesc = itemDesc;
		this.mfDesc = mfDesc;
		this.vvdSeq = vvdSeq;
		this.cntrPckTpCd = cntrPckTpCd;
		this.itemNo = itemNo;
		this.preRlyPortCd = preRlyPortCd;
		this.delCd = delCd;
		this.msgTpCd = msgTpCd;
		this.rdTerm = rdTerm;
		this.vvd = vvd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.ntfyName = ntfyName;
		this.faxNo = faxNo;
		this.pstRlyPortCd = pstRlyPortCd;
		this.declFlg = declFlg;
		this.porCd = porCd;
		this.shprName = shprName;
		this.bdrFlg = bdrFlg;
		this.msgSeq = msgSeq;
		this.kind = kind;
		this.ibflag = ibflag;
		this.actWgtUtCd = actWgtUtCd;
		this.shprAddr = shprAddr;
		this.cntrMfDesc = cntrMfDesc;
		this.cmCntrNo = cmCntrNo;
		this.pckQty = pckQty;
		this.newEdiMsg = newEdiMsg;
		this.pckTpCd = pckTpCd;
		this.blLastEdi = blLastEdi;
		this.anrDeclNo = anrDeclNo;
		this.blLastEdi2 = blLastEdi2;
		this.cntrLastEdi2 = cntrLastEdi2;
		this.cntrAnrMsgStsCd = cntrAnrMsgStsCd;
		this.ntfyAddr = ntfyAddr;
		this.cngFlg = cngFlg;
		this.actWgt = actWgt;
		this.ntfyEml = ntfyEml;
		this.cmPckTpCd = cmPckTpCd;
		this.cneeName = cneeName;
		this.cntrNo = cntrNo;
		this.sequence = sequence;
		this.cntrPckQty = cntrPckQty;
		this.cntrLastEdi = cntrLastEdi;
		this.cntrFm = cntrFm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("svc_rqst_no", getSvcRqstNo());
		this.hashColumns.put("cnee_addr", getCneeAddr());
		this.hashColumns.put("bl_ack", getBlAck());
		this.hashColumns.put("prev_docno", getPrevDocno());
		this.hashColumns.put("cm_pck_qty", getCmPckQty());
		this.hashColumns.put("bl_ack2", getBlAck2());
		this.hashColumns.put("anr_msg_sts_cd", getAnrMsgStsCd());
		this.hashColumns.put("lloyd_cd", getLloydCd());
		this.hashColumns.put("cntr_mf_wgt", getCntrMfWgt());
		this.hashColumns.put("lst_edi_msg", getLstEdiMsg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cntr_ack2", getCntrAck2());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("brth_desc", getBrthDesc());
		this.hashColumns.put("cntr_seq", getCntrSeq());
		this.hashColumns.put("cntr_wgt_ut_cd", getCntrWgtUtCd());
		this.hashColumns.put("cntr_ack", getCntrAck());
		this.hashColumns.put("item_desc", getItemDesc());
		this.hashColumns.put("mf_desc", getMfDesc());
		this.hashColumns.put("vvd_seq", getVvdSeq());
		this.hashColumns.put("cntr_pck_tp_cd", getCntrPckTpCd());
		this.hashColumns.put("item_no", getItemNo());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("msg_tp_cd", getMsgTpCd());
		this.hashColumns.put("rd_term", getRdTerm());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ntfy_name", getNtfyName());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
		this.hashColumns.put("decl_flg", getDeclFlg());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("shpr_name", getShprName());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("msg_seq", getMsgSeq());
		this.hashColumns.put("kind", getKind());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_wgt_ut_cd", getActWgtUtCd());
		this.hashColumns.put("shpr_addr", getShprAddr());
		this.hashColumns.put("cntr_mf_desc", getCntrMfDesc());
		this.hashColumns.put("cm_cntr_no", getCmCntrNo());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("new_edi_msg", getNewEdiMsg());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("bl_last_edi", getBlLastEdi());
		this.hashColumns.put("anr_decl_no", getAnrDeclNo());
		this.hashColumns.put("bl_last_edi2", getBlLastEdi2());
		this.hashColumns.put("cntr_last_edi2", getCntrLastEdi2());
		this.hashColumns.put("cntr_anr_msg_sts_cd", getCntrAnrMsgStsCd());
		this.hashColumns.put("ntfy_addr", getNtfyAddr());
		this.hashColumns.put("cng_flg", getCngFlg());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("ntfy_eml", getNtfyEml());
		this.hashColumns.put("cm_pck_tp_cd", getCmPckTpCd());
		this.hashColumns.put("cnee_name", getCneeName());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("sequence", getSequence());
		this.hashColumns.put("cntr_pck_qty", getCntrPckQty());
		this.hashColumns.put("cntr_last_edi", getCntrLastEdi());
		this.hashColumns.put("cntr_fm", getCntrFm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("svc_rqst_no", "svcRqstNo");
		this.hashFields.put("cnee_addr", "cneeAddr");
		this.hashFields.put("bl_ack", "blAck");
		this.hashFields.put("prev_docno", "prevDocno");
		this.hashFields.put("cm_pck_qty", "cmPckQty");
		this.hashFields.put("bl_ack2", "blAck2");
		this.hashFields.put("anr_msg_sts_cd", "anrMsgStsCd");
		this.hashFields.put("lloyd_cd", "lloydCd");
		this.hashFields.put("cntr_mf_wgt", "cntrMfWgt");
		this.hashFields.put("lst_edi_msg", "lstEdiMsg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cntr_ack2", "cntrAck2");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("brth_desc", "brthDesc");
		this.hashFields.put("cntr_seq", "cntrSeq");
		this.hashFields.put("cntr_wgt_ut_cd", "cntrWgtUtCd");
		this.hashFields.put("cntr_ack", "cntrAck");
		this.hashFields.put("item_desc", "itemDesc");
		this.hashFields.put("mf_desc", "mfDesc");
		this.hashFields.put("vvd_seq", "vvdSeq");
		this.hashFields.put("cntr_pck_tp_cd", "cntrPckTpCd");
		this.hashFields.put("item_no", "itemNo");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("msg_tp_cd", "msgTpCd");
		this.hashFields.put("rd_term", "rdTerm");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ntfy_name", "ntfyName");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
		this.hashFields.put("decl_flg", "declFlg");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("shpr_name", "shprName");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("msg_seq", "msgSeq");
		this.hashFields.put("kind", "kind");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_wgt_ut_cd", "actWgtUtCd");
		this.hashFields.put("shpr_addr", "shprAddr");
		this.hashFields.put("cntr_mf_desc", "cntrMfDesc");
		this.hashFields.put("cm_cntr_no", "cmCntrNo");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("new_edi_msg", "newEdiMsg");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("bl_last_edi", "blLastEdi");
		this.hashFields.put("anr_decl_no", "anrDeclNo");
		this.hashFields.put("bl_last_edi2", "blLastEdi2");
		this.hashFields.put("cntr_last_edi2", "cntrLastEdi2");
		this.hashFields.put("cntr_anr_msg_sts_cd", "cntrAnrMsgStsCd");
		this.hashFields.put("ntfy_addr", "ntfyAddr");
		this.hashFields.put("cng_flg", "cngFlg");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("ntfy_eml", "ntfyEml");
		this.hashFields.put("cm_pck_tp_cd", "cmPckTpCd");
		this.hashFields.put("cnee_name", "cneeName");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("sequence", "sequence");
		this.hashFields.put("cntr_pck_qty", "cntrPckQty");
		this.hashFields.put("cntr_last_edi", "cntrLastEdi");
		this.hashFields.put("cntr_fm", "cntrFm");
		return this.hashFields;
	}
	
	public List<List<BkgCstmsAnrEdiMsgVO>> getBkgCstmsAnrEdiMsgVOss() {
		return bkgCstmsAnrEdiMsgVOss;
	}

	public void setBkgCstmsAnrEdiMsgVOss(
			List<List<BkgCstmsAnrEdiMsgVO>> bkgCstmsAnrEdiMsgVOss) {
		this.bkgCstmsAnrEdiMsgVOss = bkgCstmsAnrEdiMsgVOss;
	}

	public List<BkgCstmsAnrEdiHisVO> getBkgCstmsAnrEdiHisVOs() {
		return bkgCstmsAnrEdiHisVOs;
	}

	public void setBkgCstmsAnrEdiHisVOs(List<BkgCstmsAnrEdiHisVO> bkgCstmsAnrEdiHisVOs) {
		this.bkgCstmsAnrEdiHisVOs = bkgCstmsAnrEdiHisVOs;
	}

	public BkgCstmsAnrEdiHisVO getBkgCstmsAnrEdiHisVO() {
		return bkgCstmsAnrEdiHisVO;
	}

	public void setBkgCstmsAnrEdiHisVO(BkgCstmsAnrEdiHisVO bkgCstmsAnrEdiHisVO) {
		this.bkgCstmsAnrEdiHisVO = bkgCstmsAnrEdiHisVO;
	}

	public List<BkgCstmsAnrEdiMsgVO> getBkgCstmsAnrEdiMsgVOs() {
		return bkgCstmsAnrEdiMsgVOs;
	}

	public void setBkgCstmsAnrEdiMsgVOs(List<BkgCstmsAnrEdiMsgVO> bkgCstmsAnrEdiMsgVOs) {
		this.bkgCstmsAnrEdiMsgVOs = bkgCstmsAnrEdiMsgVOs;
	}

	public BkgCstmsAnrEdiMsgVO getBkgCstmsAnrEdiMsgVO() {
		return bkgCstmsAnrEdiMsgVO;
	}

	public void setBkgCstmsAnrEdiMsgVO(BkgCstmsAnrEdiMsgVO bkgCstmsAnrEdiMsgVO) {
		this.bkgCstmsAnrEdiMsgVO = bkgCstmsAnrEdiMsgVO;
	}

	public List<BkgCstmsAnrBlLogVO> getBkgCstmsAnrBlLogVOs() {
		return bkgCstmsAnrBlLogVOs;
	}

	public void setBkgCstmsAnrBlLogVOs(List<BkgCstmsAnrBlLogVO> bkgCstmsAnrBlLogVOs) {
		this.bkgCstmsAnrBlLogVOs = bkgCstmsAnrBlLogVOs;
	}

	public BkgCstmsAnrBlLogVO getBkgCstmsAnrBlLogVO() {
		return bkgCstmsAnrBlLogVO;
	}

	public void setBkgCstmsAnrBlLogVO(BkgCstmsAnrBlLogVO bkgCstmsAnrBlLogVO) {
		this.bkgCstmsAnrBlLogVO = bkgCstmsAnrBlLogVO;
	}

	public List<BkgCstmsAnrCntrLogVO> getBkgCstmsAnrCntrLogVOs() {
		return bkgCstmsAnrCntrLogVOs;
	}

	public void setBkgCstmsAnrCntrLogVOs(List<BkgCstmsAnrCntrLogVO> bkgCstmsAnrCntrLogVOs) {
		this.bkgCstmsAnrCntrLogVOs = bkgCstmsAnrCntrLogVOs;
	}

	public BkgCstmsAnrCntrLogVO getBkgCstmsAnrCntrLogVO() {
		return bkgCstmsAnrCntrLogVO;
	}

	public void setBkgCstmsAnrCntrLogVO(BkgCstmsAnrCntrLogVO bkgCstmsAnrCntrLogVO) {
		this.bkgCstmsAnrCntrLogVO = bkgCstmsAnrCntrLogVO;
	}

	/**
	 * Column Info
	 * @return svcRqstNo
	 */
	public String getSvcRqstNo() {
		return this.svcRqstNo;
	}
	
	/**
	 * Column Info
	 * @return cneeAddr
	 */
	public String getCneeAddr() {
		return this.cneeAddr;
	}
	
	/**
	 * Column Info
	 * @return blAck
	 */
	public String getBlAck() {
		return this.blAck;
	}
	
	/**
	 * Column Info
	 * @return prevDocno
	 */
	public String getPrevDocno() {
		return this.prevDocno;
	}
	
	/**
	 * Column Info
	 * @return cmPckQty
	 */
	public String getCmPckQty() {
		return this.cmPckQty;
	}
	
	/**
	 * Column Info
	 * @return blAck2
	 */
	public String getBlAck2() {
		return this.blAck2;
	}
	
	/**
	 * Column Info
	 * @return anrMsgStsCd
	 */
	public String getAnrMsgStsCd() {
		return this.anrMsgStsCd;
	}
	
	/**
	 * Column Info
	 * @return lloydCd
	 */
	public String getLloydCd() {
		return this.lloydCd;
	}
	
	/**
	 * Column Info
	 * @return cntrMfWgt
	 */
	public String getCntrMfWgt() {
		return this.cntrMfWgt;
	}
	
	/**
	 * Column Info
	 * @return lstEdiMsg
	 */
	public String getLstEdiMsg() {
		return this.lstEdiMsg;
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
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return cntrAck2
	 */
	public String getCntrAck2() {
		return this.cntrAck2;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return brthDesc
	 */
	public String getBrthDesc() {
		return this.brthDesc;
	}
	
	/**
	 * Column Info
	 * @return cntrSeq
	 */
	public String getCntrSeq() {
		return this.cntrSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrWgtUtCd
	 */
	public String getCntrWgtUtCd() {
		return this.cntrWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return cntrAck
	 */
	public String getCntrAck() {
		return this.cntrAck;
	}
	
	/**
	 * Column Info
	 * @return itemDesc
	 */
	public String getItemDesc() {
		return this.itemDesc;
	}
	
	/**
	 * Column Info
	 * @return mfDesc
	 */
	public String getMfDesc() {
		return this.mfDesc;
	}
	
	/**
	 * Column Info
	 * @return vvdSeq
	 */
	public String getVvdSeq() {
		return this.vvdSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrPckTpCd
	 */
	public String getCntrPckTpCd() {
		return this.cntrPckTpCd;
	}
	
	/**
	 * Column Info
	 * @return itemNo
	 */
	public String getItemNo() {
		return this.itemNo;
	}
	
	/**
	 * Column Info
	 * @return preRlyPortCd
	 */
	public String getPreRlyPortCd() {
		return this.preRlyPortCd;
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
	 * @return msgTpCd
	 */
	public String getMsgTpCd() {
		return this.msgTpCd;
	}
	
	/**
	 * Column Info
	 * @return rdTerm
	 */
	public String getRdTerm() {
		return this.rdTerm;
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
	 * @return ntfyName
	 */
	public String getNtfyName() {
		return this.ntfyName;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return pstRlyPortCd
	 */
	public String getPstRlyPortCd() {
		return this.pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return declFlg
	 */
	public String getDeclFlg() {
		return this.declFlg;
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
	 * @return shprName
	 */
	public String getShprName() {
		return this.shprName;
	}
	
	/**
	 * Column Info
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return msgSeq
	 */
	public String getMsgSeq() {
		return this.msgSeq;
	}
	
	/**
	 * Column Info
	 * @return kind
	 */
	public String getKind() {
		return this.kind;
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
	 * @return actWgtUtCd
	 */
	public String getActWgtUtCd() {
		return this.actWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return shprAddr
	 */
	public String getShprAddr() {
		return this.shprAddr;
	}
	
	/**
	 * Column Info
	 * @return cntrMfDesc
	 */
	public String getCntrMfDesc() {
		return this.cntrMfDesc;
	}
	
	/**
	 * Column Info
	 * @return cmCntrNo
	 */
	public String getCmCntrNo() {
		return this.cmCntrNo;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return newEdiMsg
	 */
	public String getNewEdiMsg() {
		return this.newEdiMsg;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return blLastEdi
	 */
	public String getBlLastEdi() {
		return this.blLastEdi;
	}
	
	/**
	 * Column Info
	 * @return anrDeclNo
	 */
	public String getAnrDeclNo() {
		return this.anrDeclNo;
	}
	
	/**
	 * Column Info
	 * @return blLastEdi2
	 */
	public String getBlLastEdi2() {
		return this.blLastEdi2;
	}
	
	/**
	 * Column Info
	 * @return cntrLastEdi2
	 */
	public String getCntrLastEdi2() {
		return this.cntrLastEdi2;
	}
	
	/**
	 * Column Info
	 * @return cntrAnrMsgStsCd
	 */
	public String getCntrAnrMsgStsCd() {
		return this.cntrAnrMsgStsCd;
	}
	
	/**
	 * Column Info
	 * @return ntfyAddr
	 */
	public String getNtfyAddr() {
		return this.ntfyAddr;
	}
	
	/**
	 * Column Info
	 * @return cngFlg
	 */
	public String getCngFlg() {
		return this.cngFlg;
	}
	
	/**
	 * Column Info
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
	}
	
	/**
	 * Column Info
	 * @return ntfyEml
	 */
	public String getNtfyEml() {
		return this.ntfyEml;
	}
	
	/**
	 * Column Info
	 * @return cmPckTpCd
	 */
	public String getCmPckTpCd() {
		return this.cmPckTpCd;
	}
	
	/**
	 * Column Info
	 * @return cneeName
	 */
	public String getCneeName() {
		return this.cneeName;
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
	 * @return sequence
	 */
	public String getSequence() {
		return this.sequence;
	}
	
	/**
	 * Column Info
	 * @return cntrPckQty
	 */
	public String getCntrPckQty() {
		return this.cntrPckQty;
	}
	
	/**
	 * Column Info
	 * @return cntrLastEdi
	 */
	public String getCntrLastEdi() {
		return this.cntrLastEdi;
	}
	
	/**
	 * Column Info
	 * @return cntrFm
	 */
	public String getCntrFm() {
		return this.cntrFm;
	}
	

	/**
	 * Column Info
	 * @param svcRqstNo
	 */
	public void setSvcRqstNo(String svcRqstNo) {
		this.svcRqstNo = svcRqstNo;
	}
	
	/**
	 * Column Info
	 * @param cneeAddr
	 */
	public void setCneeAddr(String cneeAddr) {
		this.cneeAddr = cneeAddr;
	}
	
	/**
	 * Column Info
	 * @param blAck
	 */
	public void setBlAck(String blAck) {
		this.blAck = blAck;
	}
	
	/**
	 * Column Info
	 * @param prevDocno
	 */
	public void setPrevDocno(String prevDocno) {
		this.prevDocno = prevDocno;
	}
	
	/**
	 * Column Info
	 * @param cmPckQty
	 */
	public void setCmPckQty(String cmPckQty) {
		this.cmPckQty = cmPckQty;
	}
	
	/**
	 * Column Info
	 * @param blAck2
	 */
	public void setBlAck2(String blAck2) {
		this.blAck2 = blAck2;
	}
	
	/**
	 * Column Info
	 * @param anrMsgStsCd
	 */
	public void setAnrMsgStsCd(String anrMsgStsCd) {
		this.anrMsgStsCd = anrMsgStsCd;
	}
	
	/**
	 * Column Info
	 * @param lloydCd
	 */
	public void setLloydCd(String lloydCd) {
		this.lloydCd = lloydCd;
	}
	
	/**
	 * Column Info
	 * @param cntrMfWgt
	 */
	public void setCntrMfWgt(String cntrMfWgt) {
		this.cntrMfWgt = cntrMfWgt;
	}
	
	/**
	 * Column Info
	 * @param lstEdiMsg
	 */
	public void setLstEdiMsg(String lstEdiMsg) {
		this.lstEdiMsg = lstEdiMsg;
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
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param cntrAck2
	 */
	public void setCntrAck2(String cntrAck2) {
		this.cntrAck2 = cntrAck2;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param brthDesc
	 */
	public void setBrthDesc(String brthDesc) {
		this.brthDesc = brthDesc;
	}
	
	/**
	 * Column Info
	 * @param cntrSeq
	 */
	public void setCntrSeq(String cntrSeq) {
		this.cntrSeq = cntrSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrWgtUtCd
	 */
	public void setCntrWgtUtCd(String cntrWgtUtCd) {
		this.cntrWgtUtCd = cntrWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param cntrAck
	 */
	public void setCntrAck(String cntrAck) {
		this.cntrAck = cntrAck;
	}
	
	/**
	 * Column Info
	 * @param itemDesc
	 */
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	
	/**
	 * Column Info
	 * @param mfDesc
	 */
	public void setMfDesc(String mfDesc) {
		this.mfDesc = mfDesc;
	}
	
	/**
	 * Column Info
	 * @param vvdSeq
	 */
	public void setVvdSeq(String vvdSeq) {
		this.vvdSeq = vvdSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrPckTpCd
	 */
	public void setCntrPckTpCd(String cntrPckTpCd) {
		this.cntrPckTpCd = cntrPckTpCd;
	}
	
	/**
	 * Column Info
	 * @param itemNo
	 */
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	
	/**
	 * Column Info
	 * @param preRlyPortCd
	 */
	public void setPreRlyPortCd(String preRlyPortCd) {
		this.preRlyPortCd = preRlyPortCd;
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
	 * @param msgTpCd
	 */
	public void setMsgTpCd(String msgTpCd) {
		this.msgTpCd = msgTpCd;
	}
	
	/**
	 * Column Info
	 * @param rdTerm
	 */
	public void setRdTerm(String rdTerm) {
		this.rdTerm = rdTerm;
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
	 * @param ntfyName
	 */
	public void setNtfyName(String ntfyName) {
		this.ntfyName = ntfyName;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param pstRlyPortCd
	 */
	public void setPstRlyPortCd(String pstRlyPortCd) {
		this.pstRlyPortCd = pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param declFlg
	 */
	public void setDeclFlg(String declFlg) {
		this.declFlg = declFlg;
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
	 * @param shprName
	 */
	public void setShprName(String shprName) {
		this.shprName = shprName;
	}
	
	/**
	 * Column Info
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param msgSeq
	 */
	public void setMsgSeq(String msgSeq) {
		this.msgSeq = msgSeq;
	}
	
	/**
	 * Column Info
	 * @param kind
	 */
	public void setKind(String kind) {
		this.kind = kind;
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
	 * @param actWgtUtCd
	 */
	public void setActWgtUtCd(String actWgtUtCd) {
		this.actWgtUtCd = actWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param shprAddr
	 */
	public void setShprAddr(String shprAddr) {
		this.shprAddr = shprAddr;
	}
	
	/**
	 * Column Info
	 * @param cntrMfDesc
	 */
	public void setCntrMfDesc(String cntrMfDesc) {
		this.cntrMfDesc = cntrMfDesc;
	}
	
	/**
	 * Column Info
	 * @param cmCntrNo
	 */
	public void setCmCntrNo(String cmCntrNo) {
		this.cmCntrNo = cmCntrNo;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param newEdiMsg
	 */
	public void setNewEdiMsg(String newEdiMsg) {
		this.newEdiMsg = newEdiMsg;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param blLastEdi
	 */
	public void setBlLastEdi(String blLastEdi) {
		this.blLastEdi = blLastEdi;
	}
	
	/**
	 * Column Info
	 * @param anrDeclNo
	 */
	public void setAnrDeclNo(String anrDeclNo) {
		this.anrDeclNo = anrDeclNo;
	}
	
	/**
	 * Column Info
	 * @param blLastEdi2
	 */
	public void setBlLastEdi2(String blLastEdi2) {
		this.blLastEdi2 = blLastEdi2;
	}
	
	/**
	 * Column Info
	 * @param cntrLastEdi2
	 */
	public void setCntrLastEdi2(String cntrLastEdi2) {
		this.cntrLastEdi2 = cntrLastEdi2;
	}
	
	/**
	 * Column Info
	 * @param cntrAnrMsgStsCd
	 */
	public void setCntrAnrMsgStsCd(String cntrAnrMsgStsCd) {
		this.cntrAnrMsgStsCd = cntrAnrMsgStsCd;
	}
	
	/**
	 * Column Info
	 * @param ntfyAddr
	 */
	public void setNtfyAddr(String ntfyAddr) {
		this.ntfyAddr = ntfyAddr;
	}
	
	/**
	 * Column Info
	 * @param cngFlg
	 */
	public void setCngFlg(String cngFlg) {
		this.cngFlg = cngFlg;
	}
	
	/**
	 * Column Info
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
	}
	
	/**
	 * Column Info
	 * @param ntfyEml
	 */
	public void setNtfyEml(String ntfyEml) {
		this.ntfyEml = ntfyEml;
	}
	
	/**
	 * Column Info
	 * @param cmPckTpCd
	 */
	public void setCmPckTpCd(String cmPckTpCd) {
		this.cmPckTpCd = cmPckTpCd;
	}
	
	/**
	 * Column Info
	 * @param cneeName
	 */
	public void setCneeName(String cneeName) {
		this.cneeName = cneeName;
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
	 * @param sequence
	 */
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	
	/**
	 * Column Info
	 * @param cntrPckQty
	 */
	public void setCntrPckQty(String cntrPckQty) {
		this.cntrPckQty = cntrPckQty;
	}
	
	/**
	 * Column Info
	 * @param cntrLastEdi
	 */
	public void setCntrLastEdi(String cntrLastEdi) {
		this.cntrLastEdi = cntrLastEdi;
	}
	
	/**
	 * Column Info
	 * @param cntrFm
	 */
	public void setCntrFm(String cntrFm) {
		this.cntrFm = cntrFm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSvcRqstNo(JSPUtil.getParameter(request, "svc_rqst_no", ""));
		setCneeAddr(JSPUtil.getParameter(request, "cnee_addr", ""));
		setBlAck(JSPUtil.getParameter(request, "bl_ack", ""));
		setPrevDocno(JSPUtil.getParameter(request, "prev_docno", ""));
		setCmPckQty(JSPUtil.getParameter(request, "cm_pck_qty", ""));
		setBlAck2(JSPUtil.getParameter(request, "bl_ack2", ""));
		setAnrMsgStsCd(JSPUtil.getParameter(request, "anr_msg_sts_cd", ""));
		setLloydCd(JSPUtil.getParameter(request, "lloyd_cd", ""));
		setCntrMfWgt(JSPUtil.getParameter(request, "cntr_mf_wgt", ""));
		setLstEdiMsg(JSPUtil.getParameter(request, "lst_edi_msg", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCntrAck2(JSPUtil.getParameter(request, "cntr_ack2", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setBrthDesc(JSPUtil.getParameter(request, "brth_desc", ""));
		setCntrSeq(JSPUtil.getParameter(request, "cntr_seq", ""));
		setCntrWgtUtCd(JSPUtil.getParameter(request, "cntr_wgt_ut_cd", ""));
		setCntrAck(JSPUtil.getParameter(request, "cntr_ack", ""));
		setItemDesc(JSPUtil.getParameter(request, "item_desc", ""));
		setMfDesc(JSPUtil.getParameter(request, "mf_desc", ""));
		setVvdSeq(JSPUtil.getParameter(request, "vvd_seq", ""));
		setCntrPckTpCd(JSPUtil.getParameter(request, "cntr_pck_tp_cd", ""));
		setItemNo(JSPUtil.getParameter(request, "item_no", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, "pre_rly_port_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setMsgTpCd(JSPUtil.getParameter(request, "msg_tp_cd", ""));
		setRdTerm(JSPUtil.getParameter(request, "rd_term", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setNtfyName(JSPUtil.getParameter(request, "ntfy_name", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setPstRlyPortCd(JSPUtil.getParameter(request, "pst_rly_port_cd", ""));
		setDeclFlg(JSPUtil.getParameter(request, "decl_flg", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setShprName(JSPUtil.getParameter(request, "shpr_name", ""));
		setBdrFlg(JSPUtil.getParameter(request, "bdr_flg", ""));
		setMsgSeq(JSPUtil.getParameter(request, "msg_seq", ""));
		setKind(JSPUtil.getParameter(request, "kind", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setActWgtUtCd(JSPUtil.getParameter(request, "act_wgt_ut_cd", ""));
		setShprAddr(JSPUtil.getParameter(request, "shpr_addr", ""));
		setCntrMfDesc(JSPUtil.getParameter(request, "cntr_mf_desc", ""));
		setCmCntrNo(JSPUtil.getParameter(request, "cm_cntr_no", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setNewEdiMsg(JSPUtil.getParameter(request, "new_edi_msg", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setBlLastEdi(JSPUtil.getParameter(request, "bl_last_edi", ""));
		setAnrDeclNo(JSPUtil.getParameter(request, "anr_decl_no", ""));
		setBlLastEdi2(JSPUtil.getParameter(request, "bl_last_edi2", ""));
		setCntrLastEdi2(JSPUtil.getParameter(request, "cntr_last_edi2", ""));
		setCntrAnrMsgStsCd(JSPUtil.getParameter(request, "cntr_anr_msg_sts_cd", ""));
		setNtfyAddr(JSPUtil.getParameter(request, "ntfy_addr", ""));
		setCngFlg(JSPUtil.getParameter(request, "cng_flg", ""));
		setActWgt(JSPUtil.getParameter(request, "act_wgt", ""));
		setNtfyEml(JSPUtil.getParameter(request, "ntfy_eml", ""));
		setCmPckTpCd(JSPUtil.getParameter(request, "cm_pck_tp_cd", ""));
		setCneeName(JSPUtil.getParameter(request, "cnee_name", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setSequence(JSPUtil.getParameter(request, "sequence", ""));
		setCntrPckQty(JSPUtil.getParameter(request, "cntr_pck_qty", ""));
		setCntrLastEdi(JSPUtil.getParameter(request, "cntr_last_edi", ""));
		setCntrFm(JSPUtil.getParameter(request, "cntr_fm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AncsCstmsManifestVO[]
	 */
	public AncsCstmsManifestVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AncsCstmsManifestVO[]
	 */
	public AncsCstmsManifestVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AncsCstmsManifestVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] svcRqstNo = (JSPUtil.getParameter(request, prefix	+ "svc_rqst_no", length));
			String[] cneeAddr = (JSPUtil.getParameter(request, prefix	+ "cnee_addr", length));
			String[] blAck = (JSPUtil.getParameter(request, prefix	+ "bl_ack", length));
			String[] prevDocno = (JSPUtil.getParameter(request, prefix	+ "prev_docno", length));
			String[] cmPckQty = (JSPUtil.getParameter(request, prefix	+ "cm_pck_qty", length));
			String[] blAck2 = (JSPUtil.getParameter(request, prefix	+ "bl_ack2", length));
			String[] anrMsgStsCd = (JSPUtil.getParameter(request, prefix	+ "anr_msg_sts_cd", length));
			String[] lloydCd = (JSPUtil.getParameter(request, prefix	+ "lloyd_cd", length));
			String[] cntrMfWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_wgt", length));
			String[] lstEdiMsg = (JSPUtil.getParameter(request, prefix	+ "lst_edi_msg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cntrAck2 = (JSPUtil.getParameter(request, prefix	+ "cntr_ack2", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] brthDesc = (JSPUtil.getParameter(request, prefix	+ "brth_desc", length));
			String[] cntrSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_seq", length));
			String[] cntrWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt_ut_cd", length));
			String[] cntrAck = (JSPUtil.getParameter(request, prefix	+ "cntr_ack", length));
			String[] itemDesc = (JSPUtil.getParameter(request, prefix	+ "item_desc", length));
			String[] mfDesc = (JSPUtil.getParameter(request, prefix	+ "mf_desc", length));
			String[] vvdSeq = (JSPUtil.getParameter(request, prefix	+ "vvd_seq", length));
			String[] cntrPckTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_pck_tp_cd", length));
			String[] itemNo = (JSPUtil.getParameter(request, prefix	+ "item_no", length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] msgTpCd = (JSPUtil.getParameter(request, prefix	+ "msg_tp_cd", length));
			String[] rdTerm = (JSPUtil.getParameter(request, prefix	+ "rd_term", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ntfyName = (JSPUtil.getParameter(request, prefix	+ "ntfy_name", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_cd", length));
			String[] declFlg = (JSPUtil.getParameter(request, prefix	+ "decl_flg", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] shprName = (JSPUtil.getParameter(request, prefix	+ "shpr_name", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] msgSeq = (JSPUtil.getParameter(request, prefix	+ "msg_seq", length));
			String[] kind = (JSPUtil.getParameter(request, prefix	+ "kind", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "act_wgt_ut_cd", length));
			String[] shprAddr = (JSPUtil.getParameter(request, prefix	+ "shpr_addr", length));
			String[] cntrMfDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_desc", length));
			String[] cmCntrNo = (JSPUtil.getParameter(request, prefix	+ "cm_cntr_no", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] newEdiMsg = (JSPUtil.getParameter(request, prefix	+ "new_edi_msg", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] blLastEdi = (JSPUtil.getParameter(request, prefix	+ "bl_last_edi", length));
			String[] anrDeclNo = (JSPUtil.getParameter(request, prefix	+ "anr_decl_no", length));
			String[] blLastEdi2 = (JSPUtil.getParameter(request, prefix	+ "bl_last_edi2", length));
			String[] cntrLastEdi2 = (JSPUtil.getParameter(request, prefix	+ "cntr_last_edi2", length));
			String[] cntrAnrMsgStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_anr_msg_sts_cd", length));
			String[] ntfyAddr = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr", length));
			String[] cngFlg = (JSPUtil.getParameter(request, prefix	+ "cng_flg", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] ntfyEml = (JSPUtil.getParameter(request, prefix	+ "ntfy_eml", length));
			String[] cmPckTpCd = (JSPUtil.getParameter(request, prefix	+ "cm_pck_tp_cd", length));
			String[] cneeName = (JSPUtil.getParameter(request, prefix	+ "cnee_name", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] sequence = (JSPUtil.getParameter(request, prefix	+ "sequence", length));
			String[] cntrPckQty = (JSPUtil.getParameter(request, prefix	+ "cntr_pck_qty", length));
			String[] cntrLastEdi = (JSPUtil.getParameter(request, prefix	+ "cntr_last_edi", length));
			String[] cntrFm = (JSPUtil.getParameter(request, prefix	+ "cntr_fm", length));
			
			for (int i = 0; i < length; i++) {
				model = new AncsCstmsManifestVO();
				if (svcRqstNo[i] != null)
					model.setSvcRqstNo(svcRqstNo[i]);
				if (cneeAddr[i] != null)
					model.setCneeAddr(cneeAddr[i]);
				if (blAck[i] != null)
					model.setBlAck(blAck[i]);
				if (prevDocno[i] != null)
					model.setPrevDocno(prevDocno[i]);
				if (cmPckQty[i] != null)
					model.setCmPckQty(cmPckQty[i]);
				if (blAck2[i] != null)
					model.setBlAck2(blAck2[i]);
				if (anrMsgStsCd[i] != null)
					model.setAnrMsgStsCd(anrMsgStsCd[i]);
				if (lloydCd[i] != null)
					model.setLloydCd(lloydCd[i]);
				if (cntrMfWgt[i] != null)
					model.setCntrMfWgt(cntrMfWgt[i]);
				if (lstEdiMsg[i] != null)
					model.setLstEdiMsg(lstEdiMsg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cntrAck2[i] != null)
					model.setCntrAck2(cntrAck2[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (brthDesc[i] != null)
					model.setBrthDesc(brthDesc[i]);
				if (cntrSeq[i] != null)
					model.setCntrSeq(cntrSeq[i]);
				if (cntrWgtUtCd[i] != null)
					model.setCntrWgtUtCd(cntrWgtUtCd[i]);
				if (cntrAck[i] != null)
					model.setCntrAck(cntrAck[i]);
				if (itemDesc[i] != null)
					model.setItemDesc(itemDesc[i]);
				if (mfDesc[i] != null)
					model.setMfDesc(mfDesc[i]);
				if (vvdSeq[i] != null)
					model.setVvdSeq(vvdSeq[i]);
				if (cntrPckTpCd[i] != null)
					model.setCntrPckTpCd(cntrPckTpCd[i]);
				if (itemNo[i] != null)
					model.setItemNo(itemNo[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (msgTpCd[i] != null)
					model.setMsgTpCd(msgTpCd[i]);
				if (rdTerm[i] != null)
					model.setRdTerm(rdTerm[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ntfyName[i] != null)
					model.setNtfyName(ntfyName[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (pstRlyPortCd[i] != null)
					model.setPstRlyPortCd(pstRlyPortCd[i]);
				if (declFlg[i] != null)
					model.setDeclFlg(declFlg[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (shprName[i] != null)
					model.setShprName(shprName[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (msgSeq[i] != null)
					model.setMsgSeq(msgSeq[i]);
				if (kind[i] != null)
					model.setKind(kind[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actWgtUtCd[i] != null)
					model.setActWgtUtCd(actWgtUtCd[i]);
				if (shprAddr[i] != null)
					model.setShprAddr(shprAddr[i]);
				if (cntrMfDesc[i] != null)
					model.setCntrMfDesc(cntrMfDesc[i]);
				if (cmCntrNo[i] != null)
					model.setCmCntrNo(cmCntrNo[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (newEdiMsg[i] != null)
					model.setNewEdiMsg(newEdiMsg[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (blLastEdi[i] != null)
					model.setBlLastEdi(blLastEdi[i]);
				if (anrDeclNo[i] != null)
					model.setAnrDeclNo(anrDeclNo[i]);
				if (blLastEdi2[i] != null)
					model.setBlLastEdi2(blLastEdi2[i]);
				if (cntrLastEdi2[i] != null)
					model.setCntrLastEdi2(cntrLastEdi2[i]);
				if (cntrAnrMsgStsCd[i] != null)
					model.setCntrAnrMsgStsCd(cntrAnrMsgStsCd[i]);
				if (ntfyAddr[i] != null)
					model.setNtfyAddr(ntfyAddr[i]);
				if (cngFlg[i] != null)
					model.setCngFlg(cngFlg[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (ntfyEml[i] != null)
					model.setNtfyEml(ntfyEml[i]);
				if (cmPckTpCd[i] != null)
					model.setCmPckTpCd(cmPckTpCd[i]);
				if (cneeName[i] != null)
					model.setCneeName(cneeName[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (sequence[i] != null)
					model.setSequence(sequence[i]);
				if (cntrPckQty[i] != null)
					model.setCntrPckQty(cntrPckQty[i]);
				if (cntrLastEdi[i] != null)
					model.setCntrLastEdi(cntrLastEdi[i]);
				if (cntrFm[i] != null)
					model.setCntrFm(cntrFm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAncsCstmsManifestVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AncsCstmsManifestVO[]
	 */
	public AncsCstmsManifestVO[] getAncsCstmsManifestVOs(){
		AncsCstmsManifestVO[] vos = (AncsCstmsManifestVO[])models.toArray(new AncsCstmsManifestVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.svcRqstNo = this.svcRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr = this.cneeAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blAck = this.blAck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevDocno = this.prevDocno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPckQty = this.cmPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blAck2 = this.blAck2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anrMsgStsCd = this.anrMsgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydCd = this.lloydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfWgt = this.cntrMfWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstEdiMsg = this.lstEdiMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrAck2 = this.cntrAck2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brthDesc = this.brthDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSeq = this.cntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgtUtCd = this.cntrWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrAck = this.cntrAck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemDesc = this.itemDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfDesc = this.mfDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSeq = this.vvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPckTpCd = this.cntrPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemNo = this.itemNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgTpCd = this.msgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdTerm = this.rdTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyName = this.ntfyName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortCd = this.pstRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.declFlg = this.declFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprName = this.shprName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSeq = this.msgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind = this.kind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgtUtCd = this.actWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr = this.shprAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfDesc = this.cntrMfDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmCntrNo = this.cmCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newEdiMsg = this.newEdiMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blLastEdi = this.blLastEdi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anrDeclNo = this.anrDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blLastEdi2 = this.blLastEdi2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLastEdi2 = this.cntrLastEdi2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrAnrMsgStsCd = this.cntrAnrMsgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr = this.ntfyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngFlg = this.cngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyEml = this.ntfyEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPckTpCd = this.cmPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeName = this.cneeName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sequence = this.sequence .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPckQty = this.cntrPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLastEdi = this.cntrLastEdi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFm = this.cntrFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
