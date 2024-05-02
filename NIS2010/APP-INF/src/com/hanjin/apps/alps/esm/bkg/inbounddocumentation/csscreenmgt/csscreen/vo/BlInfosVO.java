/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlInfosVO.java
*@FileTitle : BlInfosVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BlInfosVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlInfosVO> models = new ArrayList<BlInfosVO>();
	
	/* Column Info */
	private String instruction = null;	
	/* Column Info */
	private String splitFlg = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String arrivalVvd = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String csgCustCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String oblRdemDt = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String bkgCreDt = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String shpCustNm = null;
	/* Column Info */
	private String podNm = null;
	/* Column Info */
	private String noyCustNm = null;
	/* Column Info */
	private String delNm = null;
	/* Column Info */
	private String arrivalVvdNm = null;
	/* Column Info */
	private String aoyCustCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String oblRdemFlg = null;
	/* Column Info */
	private String usOblRdemFlg = null;
	/* Column Info */
	private String partial = null;
	/* Column Info */
	private String corrUsrId = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String aoyCustNm = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String shpCustCd = null;
	/* Column Info */
	private String noyCustCd = null;
	/* Column Info */
	private String csgCustNm = null;
	/* Column Info */
	private String oblRdemOfcCd = null;
	/* Column Info */
	private String bbCgoFlg = null;
	
	/* Column Info */
	private String pptRcvOfcCd = null;
	/* Column Info */
	private String cctOtsCurrCd3 = null;
	/* Column Info */
	private String cctOtsCurrCd4 = null;
	/* Column Info */
	private String cctOtsCurrCd1 = null;
	/* Column Info */
	private String cctOtsCurrCd2 = null;
	/* Column Info */
	private String n3ptyCctRcvDt = null;
	/* Column Info */
	private String cctOtsCurrCd5 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cctRcvOfcCd = null;
	/* Column Info */
	private String n3ptyPptOtsCurrCd3 = null;
	/* Column Info */
	private String n3ptyPptOtsCurrCd4 = null;
	/* Column Info */
	private String n3ptyPptOtsCurrCd1 = null;
	/* Column Info */
	private String n3ptyPptOtsCurrCd2 = null;
	/* Column Info */
	private String cctRcvDt = null;
	/* Column Info */
	private String n3ptyCctRcvOfcCd = null;
	/* Column Info */
	private String n3ptyPptOtsCurrCd5 = null;
	/* Column Info */
	private String totOtsCurrCd1 = null;
	/* Column Info */
	private String totOtsCurrCd2 = null;
	/* Column Info */
	private String totOtsCurrCd3 = null;
	/* Column Info */
	private String totOtsCurrCd4 = null;
	/* Column Info */
	private String totOtsCurrCd5 = null;
	/* Column Info */
	private String n3ptyPptRcvDt = null;
	/* Column Info */
	private String n3ptyPptRcvUsrId = null;
	/* Column Info */
	private String n3ptyCctOtsAmt4 = null;
	/* Column Info */
	private String n3ptyCctOtsAmt5 = null;
	/* Column Info */
	private String pptRcvUsrId = null;
	/* Column Info */
	private String n3ptyCctOtsAmt2 = null;
	/* Column Info */
	private String n3ptyCctOtsAmt3 = null;
	/* Column Info */
	private String n3ptyCctStsCd = null;
	/* Column Info */
	private String n3ptyCctOtsAmt1 = null;
	/* Column Info */
	private String pptStsCd = null;
	/* Column Info */
	private String totOtsStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pptRcvDt = null;
	/* Column Info */
	private String pptOtsCurrCd5 = null;
	/* Column Info */
	private String eaiResult = null;
	/* Column Info */
	private String totOtsAmt1 = null;
	/* Column Info */
	private String totOtsAmt2 = null;
	/* Column Info */
	private String pptOtsCurrCd3 = null;
	/* Column Info */
	private String n3ptyPptOtsAmt5 = null;
	/* Column Info */
	private String pptOtsCurrCd4 = null;
	/* Column Info */
	private String n3ptyPptOtsAmt4 = null;
	/* Column Info */
	private String pptOtsAmt1 = null;
	/* Column Info */
	private String pptOtsCurrCd1 = null;
	/* Column Info */
	private String n3ptyPptOtsAmt3 = null;
	/* Column Info */
	private String pptOtsCurrCd2 = null;
	/* Column Info */
	private String n3ptyPptOtsAmt2 = null;
	/* Column Info */
	private String pptOtsAmt3 = null;
	/* Column Info */
	private String n3ptyPptOtsAmt1 = null;
	/* Column Info */
	private String pptOtsAmt2 = null;
	/* Column Info */
	private String pptOtsAmt5 = null;
	/* Column Info */
	private String pptOtsAmt4 = null;
	/* Column Info */
	private String cctStsCd = null;
	/* Column Info */
	private String n3ptyPptRcvOfcCd = null;
	/* Column Info */
	private String n3ptyCctOtsCurrCd5 = null;
	/* Column Info */
	private String cctOtsAmt5 = null;
	/* Column Info */
	private String n3ptyCctOtsCurrCd2 = null;
	/* Column Info */
	private String totOtsAmt5 = null;
	/* Column Info */
	private String cctOtsAmt4 = null;
	/* Column Info */
	private String n3ptyCctOtsCurrCd1 = null;
	/* Column Info */
	private String totOtsAmt4 = null;
	/* Column Info */
	private String cctOtsAmt3 = null;
	/* Column Info */
	private String n3ptyCctOtsCurrCd4 = null;
	/* Column Info */
	private String totOtsAmt3 = null;
	/* Column Info */
	private String cctOtsAmt2 = null;
	/* Column Info */
	private String n3ptyCctOtsCurrCd3 = null;
	/* Column Info */
	private String cctOtsAmt1 = null;
	/* Column Info */
	private String cctRcvUsrId = null;
	/* Column Info */
	private String n3ptyCctRcvUsrId = null;
	/* Column Info */
	private String n3ptyPptStsCd = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String delYdCd = null;
	/* Column Info */
	private String collOfcCd = null;	
	/* Column Info */
	private String dirDeFlg = null;
	/* Column Info */
	private String freeTrdZnFlg = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BlInfosVO() {}

	public BlInfosVO(String instruction, String ibflag, String pagerows, String arrivalVvd, String arrivalVvdNm, String partial, String vpsEtaDt, String vpsEtbDt, String slanCd, String rcvTermCd, String deTermCd, String porCd, String polCd, String podCd, String podNm, String delCd, String delNm, String bkgStsCd, String bdrFlg, String corrUsrId, String pckQty, String pckTpCd, String actWgt, String wgtUtCd, String scNo, String rfaNo, String cstmsDesc, String oblRdemFlg, String usOblRdemFlg, String oblRdemDt, String oblRdemOfcCd, String shpCustCd, String shpCustNm, String csgCustCd, String csgCustNm, String noyCustCd, String noyCustNm, String aoyCustCd, String aoyCustNm, String blNo, String bkgNo, String splitFlg, String bkgCreDt, String bkgOfcCd, String blTpCd, String bkgCgoTpCd, String bbCgoFlg, String totOtsStsCd, String eaiResult, String totOtsCurrCd1, String totOtsCurrCd2, String totOtsCurrCd3, String totOtsCurrCd4, String totOtsCurrCd5, String totOtsAmt1, String totOtsAmt2, String totOtsAmt3, String totOtsAmt4, String totOtsAmt5, String pptStsCd, String pptRcvOfcCd, String pptRcvUsrId, String pptRcvDt, String cctStsCd, String cctRcvOfcCd, String cctRcvUsrId, String cctRcvDt, String cctOtsCurrCd1, String cctOtsCurrCd2, String cctOtsCurrCd3, String cctOtsCurrCd4, String cctOtsCurrCd5, String cctOtsAmt1, String cctOtsAmt2, String cctOtsAmt3, String cctOtsAmt4, String cctOtsAmt5, String n3ptyPptStsCd, String n3ptyPptRcvOfcCd, String n3ptyPptRcvUsrId, String n3ptyPptRcvDt, String n3ptyCctStsCd, String n3ptyCctRcvOfcCd, String n3ptyCctRcvUsrId, String n3ptyCctRcvDt, String n3ptyCctOtsCurrCd1, String n3ptyCctOtsCurrCd2, String n3ptyCctOtsCurrCd3, String n3ptyCctOtsCurrCd4, String n3ptyCctOtsCurrCd5, String n3ptyCctOtsAmt1, String n3ptyCctOtsAmt2, String n3ptyCctOtsAmt3, String n3ptyCctOtsAmt4, String n3ptyCctOtsAmt5, String n3ptyPptOtsCurrCd1, String n3ptyPptOtsCurrCd2, String n3ptyPptOtsCurrCd3, String n3ptyPptOtsCurrCd4, String n3ptyPptOtsCurrCd5, String n3ptyPptOtsAmt1, String n3ptyPptOtsAmt2, String n3ptyPptOtsAmt3, String n3ptyPptOtsAmt4, String n3ptyPptOtsAmt5, String pptOtsCurrCd1, String pptOtsCurrCd2, String pptOtsCurrCd3, String pptOtsCurrCd4, String pptOtsCurrCd5, String pptOtsAmt1, String pptOtsAmt2, String pptOtsAmt3, String pptOtsAmt4, String pptOtsAmt5, String podYdCd, String delYdCd, String collOfcCd, String dirDeFlg, String freeTrdZnFlg) {
		this.instruction = instruction;
		this.splitFlg = splitFlg;
		this.porCd = porCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.vpsEtbDt = vpsEtbDt;
		this.arrivalVvd = arrivalVvd;
		this.bkgStsCd = bkgStsCd;
		this.bdrFlg = bdrFlg;
		this.rfaNo = rfaNo;
		this.csgCustCd = csgCustCd;
		this.blNo = blNo;
		this.vpsEtaDt = vpsEtaDt;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.oblRdemDt = oblRdemDt;
		this.cstmsDesc = cstmsDesc;
		this.scNo = scNo;
		this.wgtUtCd = wgtUtCd;
		this.bkgCreDt = bkgCreDt;
		this.pckQty = pckQty;
		this.rcvTermCd = rcvTermCd;
		this.pckTpCd = pckTpCd;
		this.bkgOfcCd = bkgOfcCd;
		this.shpCustNm = shpCustNm;
		this.podNm = podNm;
		this.noyCustNm = noyCustNm;
		this.delNm = delNm;
		this.arrivalVvdNm = arrivalVvdNm;
		this.aoyCustCd = aoyCustCd;
		this.delCd = delCd;
		this.oblRdemFlg = oblRdemFlg;
		this.usOblRdemFlg = usOblRdemFlg;
		this.partial = partial;
		this.corrUsrId = corrUsrId;
		this.blTpCd = blTpCd;
		this.actWgt = actWgt;
		this.podCd = podCd;
		this.deTermCd = deTermCd;
		this.bkgNo = bkgNo;
		this.aoyCustNm = aoyCustNm;
		this.slanCd = slanCd;
		this.shpCustCd = shpCustCd;
		this.noyCustCd = noyCustCd;
		this.csgCustNm = csgCustNm;
		this.oblRdemOfcCd = oblRdemOfcCd;
		this.bbCgoFlg = bbCgoFlg;

		this.pptRcvOfcCd = pptRcvOfcCd;
		this.cctOtsCurrCd3 = cctOtsCurrCd3;
		this.cctOtsCurrCd4 = cctOtsCurrCd4;
		this.cctOtsCurrCd1 = cctOtsCurrCd1;
		this.cctOtsCurrCd2 = cctOtsCurrCd2;
		this.n3ptyCctRcvDt = n3ptyCctRcvDt;
		this.cctOtsCurrCd5 = cctOtsCurrCd5;
		this.cctRcvOfcCd = cctRcvOfcCd;
		this.n3ptyPptOtsCurrCd3 = n3ptyPptOtsCurrCd3;
		this.n3ptyPptOtsCurrCd4 = n3ptyPptOtsCurrCd4;
		this.n3ptyPptOtsCurrCd1 = n3ptyPptOtsCurrCd1;
		this.n3ptyPptOtsCurrCd2 = n3ptyPptOtsCurrCd2;
		this.cctRcvDt = cctRcvDt;
		this.n3ptyCctRcvOfcCd = n3ptyCctRcvOfcCd;
		this.n3ptyPptOtsCurrCd5 = n3ptyPptOtsCurrCd5;
		this.totOtsCurrCd1 = totOtsCurrCd1;
		this.totOtsCurrCd2 = totOtsCurrCd2;
		this.totOtsCurrCd3 = totOtsCurrCd3;
		this.totOtsCurrCd4 = totOtsCurrCd4;
		this.totOtsCurrCd5 = totOtsCurrCd5;
		this.n3ptyPptRcvDt = n3ptyPptRcvDt;
		this.n3ptyPptRcvUsrId = n3ptyPptRcvUsrId;
		this.n3ptyCctOtsAmt4 = n3ptyCctOtsAmt4;
		this.n3ptyCctOtsAmt5 = n3ptyCctOtsAmt5;
		this.pptRcvUsrId = pptRcvUsrId;
		this.n3ptyCctOtsAmt2 = n3ptyCctOtsAmt2;
		this.n3ptyCctOtsAmt3 = n3ptyCctOtsAmt3;
		this.n3ptyCctStsCd = n3ptyCctStsCd;
		this.n3ptyCctOtsAmt1 = n3ptyCctOtsAmt1;
		this.pptStsCd = pptStsCd;
		this.totOtsStsCd = totOtsStsCd;
		this.pptRcvDt = pptRcvDt;
		this.pptOtsCurrCd5 = pptOtsCurrCd5;
		this.eaiResult = eaiResult;
		this.totOtsAmt1 = totOtsAmt1;
		this.totOtsAmt2 = totOtsAmt2;
		this.pptOtsCurrCd3 = pptOtsCurrCd3;
		this.n3ptyPptOtsAmt5 = n3ptyPptOtsAmt5;
		this.pptOtsCurrCd4 = pptOtsCurrCd4;
		this.n3ptyPptOtsAmt4 = n3ptyPptOtsAmt4;
		this.pptOtsAmt1 = pptOtsAmt1;
		this.pptOtsCurrCd1 = pptOtsCurrCd1;
		this.n3ptyPptOtsAmt3 = n3ptyPptOtsAmt3;
		this.pptOtsCurrCd2 = pptOtsCurrCd2;
		this.n3ptyPptOtsAmt2 = n3ptyPptOtsAmt2;
		this.pptOtsAmt3 = pptOtsAmt3;
		this.n3ptyPptOtsAmt1 = n3ptyPptOtsAmt1;
		this.pptOtsAmt2 = pptOtsAmt2;
		this.pptOtsAmt5 = pptOtsAmt5;
		this.pptOtsAmt4 = pptOtsAmt4;
		this.cctStsCd = cctStsCd;
		this.n3ptyPptRcvOfcCd = n3ptyPptRcvOfcCd;
		this.n3ptyCctOtsCurrCd5 = n3ptyCctOtsCurrCd5;
		this.cctOtsAmt5 = cctOtsAmt5;
		this.n3ptyCctOtsCurrCd2 = n3ptyCctOtsCurrCd2;
		this.totOtsAmt5 = totOtsAmt5;
		this.cctOtsAmt4 = cctOtsAmt4;
		this.n3ptyCctOtsCurrCd1 = n3ptyCctOtsCurrCd1;
		this.totOtsAmt4 = totOtsAmt4;
		this.cctOtsAmt3 = cctOtsAmt3;
		this.n3ptyCctOtsCurrCd4 = n3ptyCctOtsCurrCd4;
		this.totOtsAmt3 = totOtsAmt3;
		this.cctOtsAmt2 = cctOtsAmt2;
		this.n3ptyCctOtsCurrCd3 = n3ptyCctOtsCurrCd3;
		this.cctOtsAmt1 = cctOtsAmt1;
		this.cctRcvUsrId = cctRcvUsrId;
		this.n3ptyCctRcvUsrId = n3ptyCctRcvUsrId;
		this.n3ptyPptStsCd = n3ptyPptStsCd;
		this.podYdCd = podYdCd;
		this.delYdCd = delYdCd;
		this.collOfcCd = collOfcCd;
		
		this.dirDeFlg = dirDeFlg;
		this.freeTrdZnFlg = freeTrdZnFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("instruction", getInstruction());
		this.hashColumns.put("split_flg", getSplitFlg());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("arrival_vvd", getArrivalVvd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("csg_cust_cd", getCsgCustCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("obl_rdem_dt", getOblRdemDt());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("shp_cust_nm", getShpCustNm());
		this.hashColumns.put("pod_nm", getPodNm());
		this.hashColumns.put("noy_cust_nm", getNoyCustNm());
		this.hashColumns.put("del_nm", getDelNm());
		this.hashColumns.put("arrival_vvd_nm", getArrivalVvdNm());
		this.hashColumns.put("aoy_cust_cd", getAoyCustCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("obl_rdem_flg", getOblRdemFlg());
		this.hashColumns.put("us_obl_rdem_flg", getUsOblRdemFlg());
		this.hashColumns.put("partial", getPartial());
		this.hashColumns.put("corr_usr_id", getCorrUsrId());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("aoy_cust_nm", getAoyCustNm());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("shp_cust_cd", getShpCustCd());
		this.hashColumns.put("noy_cust_cd", getNoyCustCd());
		this.hashColumns.put("csg_cust_nm", getCsgCustNm());
		this.hashColumns.put("obl_rdem_ofc_cd", getOblRdemOfcCd());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		
		this.hashColumns.put("ppt_rcv_ofc_cd", getPptRcvOfcCd());
		this.hashColumns.put("cct_ots_curr_cd3", getCctOtsCurrCd3());
		this.hashColumns.put("cct_ots_curr_cd4", getCctOtsCurrCd4());
		this.hashColumns.put("cct_ots_curr_cd1", getCctOtsCurrCd1());
		this.hashColumns.put("cct_ots_curr_cd2", getCctOtsCurrCd2());
		this.hashColumns.put("n3pty_cct_rcv_dt", getN3ptyCctRcvDt());
		this.hashColumns.put("cct_ots_curr_cd5", getCctOtsCurrCd5());
		this.hashColumns.put("cct_rcv_ofc_cd", getCctRcvOfcCd());
		this.hashColumns.put("n3pty_ppt_ots_curr_cd3", getN3ptyPptOtsCurrCd3());
		this.hashColumns.put("n3pty_ppt_ots_curr_cd4", getN3ptyPptOtsCurrCd4());
		this.hashColumns.put("n3pty_ppt_ots_curr_cd1", getN3ptyPptOtsCurrCd1());
		this.hashColumns.put("n3pty_ppt_ots_curr_cd2", getN3ptyPptOtsCurrCd2());
		this.hashColumns.put("cct_rcv_dt", getCctRcvDt());
		this.hashColumns.put("n3pty_cct_rcv_ofc_cd", getN3ptyCctRcvOfcCd());
		this.hashColumns.put("n3pty_ppt_ots_curr_cd5", getN3ptyPptOtsCurrCd5());
		this.hashColumns.put("tot_ots_curr_cd1", getTotOtsCurrCd1());
		this.hashColumns.put("tot_ots_curr_cd2", getTotOtsCurrCd2());
		this.hashColumns.put("tot_ots_curr_cd3", getTotOtsCurrCd3());
		this.hashColumns.put("tot_ots_curr_cd4", getTotOtsCurrCd4());
		this.hashColumns.put("tot_ots_curr_cd5", getTotOtsCurrCd5());
		this.hashColumns.put("n3pty_ppt_rcv_dt", getN3ptyPptRcvDt());
		this.hashColumns.put("n3pty_ppt_rcv_usr_id", getN3ptyPptRcvUsrId());
		this.hashColumns.put("n3pty_cct_ots_amt4", getN3ptyCctOtsAmt4());
		this.hashColumns.put("n3pty_cct_ots_amt5", getN3ptyCctOtsAmt5());
		this.hashColumns.put("ppt_rcv_usr_id", getPptRcvUsrId());
		this.hashColumns.put("n3pty_cct_ots_amt2", getN3ptyCctOtsAmt2());
		this.hashColumns.put("n3pty_cct_ots_amt3", getN3ptyCctOtsAmt3());
		this.hashColumns.put("n3pty_cct_sts_cd", getN3ptyCctStsCd());
		this.hashColumns.put("n3pty_cct_ots_amt1", getN3ptyCctOtsAmt1());
		this.hashColumns.put("ppt_sts_cd", getPptStsCd());
		this.hashColumns.put("tot_ots_sts_cd", getTotOtsStsCd());
		this.hashColumns.put("ppt_rcv_dt", getPptRcvDt());
		this.hashColumns.put("ppt_ots_curr_cd5", getPptOtsCurrCd5());
		this.hashColumns.put("eai_result", getEaiResult());
		this.hashColumns.put("tot_ots_amt1", getTotOtsAmt1());
		this.hashColumns.put("tot_ots_amt2", getTotOtsAmt2());
		this.hashColumns.put("ppt_ots_curr_cd3", getPptOtsCurrCd3());
		this.hashColumns.put("n3pty_ppt_ots_amt5", getN3ptyPptOtsAmt5());
		this.hashColumns.put("ppt_ots_curr_cd4", getPptOtsCurrCd4());
		this.hashColumns.put("n3pty_ppt_ots_amt4", getN3ptyPptOtsAmt4());
		this.hashColumns.put("ppt_ots_amt1", getPptOtsAmt1());
		this.hashColumns.put("ppt_ots_curr_cd1", getPptOtsCurrCd1());
		this.hashColumns.put("n3pty_ppt_ots_amt3", getN3ptyPptOtsAmt3());
		this.hashColumns.put("ppt_ots_curr_cd2", getPptOtsCurrCd2());
		this.hashColumns.put("n3pty_ppt_ots_amt2", getN3ptyPptOtsAmt2());
		this.hashColumns.put("ppt_ots_amt3", getPptOtsAmt3());
		this.hashColumns.put("n3pty_ppt_ots_amt1", getN3ptyPptOtsAmt1());
		this.hashColumns.put("ppt_ots_amt2", getPptOtsAmt2());
		this.hashColumns.put("ppt_ots_amt5", getPptOtsAmt5());
		this.hashColumns.put("ppt_ots_amt4", getPptOtsAmt4());
		this.hashColumns.put("cct_sts_cd", getCctStsCd());
		this.hashColumns.put("n3pty_ppt_rcv_ofc_cd", getN3ptyPptRcvOfcCd());
		this.hashColumns.put("n3pty_cct_ots_curr_cd5", getN3ptyCctOtsCurrCd5());
		this.hashColumns.put("cct_ots_amt5", getCctOtsAmt5());
		this.hashColumns.put("n3pty_cct_ots_curr_cd2", getN3ptyCctOtsCurrCd2());
		this.hashColumns.put("tot_ots_amt5", getTotOtsAmt5());
		this.hashColumns.put("cct_ots_amt4", getCctOtsAmt4());
		this.hashColumns.put("n3pty_cct_ots_curr_cd1", getN3ptyCctOtsCurrCd1());
		this.hashColumns.put("tot_ots_amt4", getTotOtsAmt4());
		this.hashColumns.put("cct_ots_amt3", getCctOtsAmt3());
		this.hashColumns.put("n3pty_cct_ots_curr_cd4", getN3ptyCctOtsCurrCd4());
		this.hashColumns.put("tot_ots_amt3", getTotOtsAmt3());
		this.hashColumns.put("cct_ots_amt2", getCctOtsAmt2());
		this.hashColumns.put("n3pty_cct_ots_curr_cd3", getN3ptyCctOtsCurrCd3());
		this.hashColumns.put("cct_ots_amt1", getCctOtsAmt1());
		this.hashColumns.put("cct_rcv_usr_id", getCctRcvUsrId());
		this.hashColumns.put("n3pty_cct_rcv_usr_id", getN3ptyCctRcvUsrId());
		this.hashColumns.put("n3pty_ppt_sts_cd", getN3ptyPptStsCd());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("del_yd_cd", getDelYdCd());
		this.hashColumns.put("coll_ofc_cd", getCollOfcCd());
		
		this.hashColumns.put("dir_de_flg", getDirDeFlg());
		this.hashColumns.put("free_trd_zn_flg", getFreeTrdZnFlg());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("instruction", "instruction");
		this.hashFields.put("split_flg", "splitFlg");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("arrival_vvd", "arrivalVvd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("csg_cust_cd", "csgCustCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("obl_rdem_dt", "oblRdemDt");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("bkg_cre_dt", "bkgCreDt");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("shp_cust_nm", "shpCustNm");
		this.hashFields.put("pod_nm", "podNm");
		this.hashFields.put("noy_cust_nm", "noyCustNm");
		this.hashFields.put("del_nm", "delNm");
		this.hashFields.put("arrival_vvd_nm", "arrivalVvdNm");
		this.hashFields.put("aoy_cust_cd", "aoyCustCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("obl_rdem_flg", "oblRdemFlg");
		this.hashFields.put("us_obl_rdem_flg", "usOblRdemFlg");
		this.hashFields.put("partial", "partial");
		this.hashFields.put("corr_usr_id", "corrUsrId");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("aoy_cust_nm", "aoyCustNm");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("shp_cust_cd", "shpCustCd");
		this.hashFields.put("noy_cust_cd", "noyCustCd");
		this.hashFields.put("csg_cust_nm", "csgCustNm");
		this.hashFields.put("obl_rdem_ofc_cd", "oblRdemOfcCd");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		
		this.hashFields.put("ppt_rcv_ofc_cd", "pptRcvOfcCd");
		this.hashFields.put("cct_ots_curr_cd3", "cctOtsCurrCd3");
		this.hashFields.put("cct_ots_curr_cd4", "cctOtsCurrCd4");
		this.hashFields.put("cct_ots_curr_cd1", "cctOtsCurrCd1");
		this.hashFields.put("cct_ots_curr_cd2", "cctOtsCurrCd2");
		this.hashFields.put("n3pty_cct_rcv_dt", "n3ptyCctRcvDt");
		this.hashFields.put("cct_ots_curr_cd5", "cctOtsCurrCd5");
		this.hashFields.put("cct_rcv_ofc_cd", "cctRcvOfcCd");
		this.hashFields.put("n3pty_ppt_ots_curr_cd3", "n3ptyPptOtsCurrCd3");
		this.hashFields.put("n3pty_ppt_ots_curr_cd4", "n3ptyPptOtsCurrCd4");
		this.hashFields.put("n3pty_ppt_ots_curr_cd1", "n3ptyPptOtsCurrCd1");
		this.hashFields.put("n3pty_ppt_ots_curr_cd2", "n3ptyPptOtsCurrCd2");
		this.hashFields.put("cct_rcv_dt", "cctRcvDt");
		this.hashFields.put("n3pty_cct_rcv_ofc_cd", "n3ptyCctRcvOfcCd");
		this.hashFields.put("n3pty_ppt_ots_curr_cd5", "n3ptyPptOtsCurrCd5");
		this.hashFields.put("tot_ots_curr_cd1", "totOtsCurrCd1");
		this.hashFields.put("tot_ots_curr_cd2", "totOtsCurrCd2");
		this.hashFields.put("tot_ots_curr_cd3", "totOtsCurrCd3");
		this.hashFields.put("tot_ots_curr_cd4", "totOtsCurrCd4");
		this.hashFields.put("tot_ots_curr_cd5", "totOtsCurrCd5");
		this.hashFields.put("n3pty_ppt_rcv_dt", "n3ptyPptRcvDt");
		this.hashFields.put("n3pty_ppt_rcv_usr_id", "n3ptyPptRcvUsrId");
		this.hashFields.put("n3pty_cct_ots_amt4", "n3ptyCctOtsAmt4");
		this.hashFields.put("n3pty_cct_ots_amt5", "n3ptyCctOtsAmt5");
		this.hashFields.put("ppt_rcv_usr_id", "pptRcvUsrId");
		this.hashFields.put("n3pty_cct_ots_amt2", "n3ptyCctOtsAmt2");
		this.hashFields.put("n3pty_cct_ots_amt3", "n3ptyCctOtsAmt3");
		this.hashFields.put("n3pty_cct_sts_cd", "n3ptyCctStsCd");
		this.hashFields.put("n3pty_cct_ots_amt1", "n3ptyCctOtsAmt1");
		this.hashFields.put("ppt_sts_cd", "pptStsCd");
		this.hashFields.put("tot_ots_sts_cd", "totOtsStsCd");
		this.hashFields.put("ppt_rcv_dt", "pptRcvDt");
		this.hashFields.put("ppt_ots_curr_cd5", "pptOtsCurrCd5");
		this.hashFields.put("eai_result", "eaiResult");
		this.hashFields.put("tot_ots_amt1", "totOtsAmt1");
		this.hashFields.put("tot_ots_amt2", "totOtsAmt2");
		this.hashFields.put("ppt_ots_curr_cd3", "pptOtsCurrCd3");
		this.hashFields.put("n3pty_ppt_ots_amt5", "n3ptyPptOtsAmt5");
		this.hashFields.put("ppt_ots_curr_cd4", "pptOtsCurrCd4");
		this.hashFields.put("n3pty_ppt_ots_amt4", "n3ptyPptOtsAmt4");
		this.hashFields.put("ppt_ots_amt1", "pptOtsAmt1");
		this.hashFields.put("ppt_ots_curr_cd1", "pptOtsCurrCd1");
		this.hashFields.put("n3pty_ppt_ots_amt3", "n3ptyPptOtsAmt3");
		this.hashFields.put("ppt_ots_curr_cd2", "pptOtsCurrCd2");
		this.hashFields.put("n3pty_ppt_ots_amt2", "n3ptyPptOtsAmt2");
		this.hashFields.put("ppt_ots_amt3", "pptOtsAmt3");
		this.hashFields.put("n3pty_ppt_ots_amt1", "n3ptyPptOtsAmt1");
		this.hashFields.put("ppt_ots_amt2", "pptOtsAmt2");
		this.hashFields.put("ppt_ots_amt5", "pptOtsAmt5");
		this.hashFields.put("ppt_ots_amt4", "pptOtsAmt4");
		this.hashFields.put("cct_sts_cd", "cctStsCd");
		this.hashFields.put("n3pty_ppt_rcv_ofc_cd", "n3ptyPptRcvOfcCd");
		this.hashFields.put("n3pty_cct_ots_curr_cd5", "n3ptyCctOtsCurrCd5");
		this.hashFields.put("cct_ots_amt5", "cctOtsAmt5");
		this.hashFields.put("n3pty_cct_ots_curr_cd2", "n3ptyCctOtsCurrCd2");
		this.hashFields.put("tot_ots_amt5", "totOtsAmt5");
		this.hashFields.put("cct_ots_amt4", "cctOtsAmt4");
		this.hashFields.put("n3pty_cct_ots_curr_cd1", "n3ptyCctOtsCurrCd1");
		this.hashFields.put("tot_ots_amt4", "totOtsAmt4");
		this.hashFields.put("cct_ots_amt3", "cctOtsAmt3");
		this.hashFields.put("n3pty_cct_ots_curr_cd4", "n3ptyCctOtsCurrCd4");
		this.hashFields.put("tot_ots_amt3", "totOtsAmt3");
		this.hashFields.put("cct_ots_amt2", "cctOtsAmt2");
		this.hashFields.put("n3pty_cct_ots_curr_cd3", "n3ptyCctOtsCurrCd3");
		this.hashFields.put("cct_ots_amt1", "cctOtsAmt1");
		this.hashFields.put("cct_rcv_usr_id", "cctRcvUsrId");
		this.hashFields.put("n3pty_cct_rcv_usr_id", "n3ptyCctRcvUsrId");
		this.hashFields.put("n3pty_ppt_sts_cd", "n3ptyPptStsCd");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("del_yd_cd", "delYdCd");
		this.hashFields.put("coll_ofc_cd", "collOfcCd");
		
		this.hashFields.put("dir_de_flg", "dirDeFlg");
		this.hashFields.put("free_trd_zn_flg", "freeTrdZnFlg");
		
		return this.hashFields;
	}
	
		
	/**
	 * Column Info
	 * @return instruction
	 */
	public String getInstruction() {
		return this.instruction;
	}

	/**
	 * Column Info
	 * @return splitFlg
	 */
	public String getSplitFlg() {
		return this.splitFlg;
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
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return dirDeFlg
	 */
	public String getDirDeFlg() {
		return this.dirDeFlg;
	}
	
	/**
	 * Column Info
	 * @return freeTrdZnFlg
	 */
	public String getFreeTrdZnFlg() {
		return this.freeTrdZnFlg;
	}
	
	/**
	 * Column Info
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return arrivalVvd
	 */
	public String getArrivalVvd() {
		return this.arrivalVvd;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return csgCustCd
	 */
	public String getCsgCustCd() {
		return this.csgCustCd;
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
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
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
	 * @return oblRdemDt
	 */
	public String getOblRdemDt() {
		return this.oblRdemDt;
	}
	
	/**
	 * Column Info
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCreDt
	 */
	public String getBkgCreDt() {
		return this.bkgCreDt;
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
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
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
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return shpCustNm
	 */
	public String getShpCustNm() {
		return this.shpCustNm;
	}
	
	/**
	 * Column Info
	 * @return podNm
	 */
	public String getPodNm() {
		return this.podNm;
	}
	
	/**
	 * Column Info
	 * @return noyCustNm
	 */
	public String getNoyCustNm() {
		return this.noyCustNm;
	}
	
	/**
	 * Column Info
	 * @return delNm
	 */
	public String getDelNm() {
		return this.delNm;
	}
	
	/**
	 * Column Info
	 * @return arrivalVvdNm
	 */
	public String getArrivalVvdNm() {
		return this.arrivalVvdNm;
	}
	
	/**
	 * Column Info
	 * @return aoyCustCd
	 */
	public String getAoyCustCd() {
		return this.aoyCustCd;
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
	 * @return oblRdemFlg
	 */
	public String getOblRdemFlg() {
		return this.oblRdemFlg;
	}

	/**
	 * Column Info
	 * @return usOblRdemFlg
	 */
	public String getUsOblRdemFlg() {
		return this.usOblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @return partial
	 */
	public String getPartial() {
		return this.partial;
	}
	
	/**
	 * Column Info
	 * @return corrUsrId
	 */
	public String getCorrUsrId() {
		return this.corrUsrId;
	}
	
	/**
	 * Column Info
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return aoyCustNm
	 */
	public String getAoyCustNm() {
		return this.aoyCustNm;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return shpCustCd
	 */
	public String getShpCustCd() {
		return this.shpCustCd;
	}
	
	/**
	 * Column Info
	 * @return noyCustCd
	 */
	public String getNoyCustCd() {
		return this.noyCustCd;
	}
	
	/**
	 * Column Info
	 * @return csgCustNm
	 */
	public String getCsgCustNm() {
		return this.csgCustNm;
	}
	
	/**
	 * Column Info
	 * @return oblRdemOfcCd
	 */
	public String getOblRdemOfcCd() {
		return this.oblRdemOfcCd;
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
	 * @return collOfcCd
	 */
	public String getCollOfcCd() {
		return this.collOfcCd;
	}	
	
	/**
	 * Column Info
	 * @param splitFlg
	 */
	public void setSplitFlg(String splitFlg) {
		this.splitFlg = splitFlg;
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
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param arrivalVvd
	 */
	public void setArrivalVvd(String arrivalVvd) {
		this.arrivalVvd = arrivalVvd;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param csgCustCd
	 */
	public void setCsgCustCd(String csgCustCd) {
		this.csgCustCd = csgCustCd;
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
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
	 * @param oblRdemDt
	 */
	public void setOblRdemDt(String oblRdemDt) {
		this.oblRdemDt = oblRdemDt;
	}
	
	/**
	 * Column Info
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCreDt
	 */
	public void setBkgCreDt(String bkgCreDt) {
		this.bkgCreDt = bkgCreDt;
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
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
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
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param shpCustNm
	 */
	public void setShpCustNm(String shpCustNm) {
		this.shpCustNm = shpCustNm;
	}
	
	/**
	 * Column Info
	 * @param podNm
	 */
	public void setPodNm(String podNm) {
		this.podNm = podNm;
	}
	
	/**
	 * Column Info
	 * @param noyCustNm
	 */
	public void setNoyCustNm(String noyCustNm) {
		this.noyCustNm = noyCustNm;
	}
	
	/**
	 * Column Info
	 * @param delNm
	 */
	public void setDelNm(String delNm) {
		this.delNm = delNm;
	}
	
	/**
	 * Column Info
	 * @param arrivalVvdNm
	 */
	public void setArrivalVvdNm(String arrivalVvdNm) {
		this.arrivalVvdNm = arrivalVvdNm;
	}
	
	/**
	 * Column Info
	 * @param aoyCustCd
	 */
	public void setAoyCustCd(String aoyCustCd) {
		this.aoyCustCd = aoyCustCd;
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
	 * @param oblRdemFlg
	 */
	public void setOblRdemFlg(String oblRdemFlg) {
		this.oblRdemFlg = oblRdemFlg;
	}

	/**
	 * Column Info
	 * @param usOblRdemFlg
	 */
	public void setUsOblRdemFlg(String usOblRdemFlg) {
		this.usOblRdemFlg = usOblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @param partial
	 */
	public void setPartial(String partial) {
		this.partial = partial;
	}
	
	/**
	 * Column Info
	 * @param corrUsrId
	 */
	public void setCorrUsrId(String corrUsrId) {
		this.corrUsrId = corrUsrId;
	}
	
	/**
	 * Column Info
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param aoyCustNm
	 */
	public void setAoyCustNm(String aoyCustNm) {
		this.aoyCustNm = aoyCustNm;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param shpCustCd
	 */
	public void setShpCustCd(String shpCustCd) {
		this.shpCustCd = shpCustCd;
	}
	
	/**
	 * Column Info
	 * @param noyCustCd
	 */
	public void setNoyCustCd(String noyCustCd) {
		this.noyCustCd = noyCustCd;
	}
	
	/**
	 * Column Info
	 * @param csgCustNm
	 */
	public void setCsgCustNm(String csgCustNm) {
		this.csgCustNm = csgCustNm;
	}
	
	/**
	 * Column Info
	 * @param oblRdemOfcCd
	 */
	public void setOblRdemOfcCd(String oblRdemOfcCd) {
		this.oblRdemOfcCd = oblRdemOfcCd;
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
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}
	
	/**
	 * Column Info
	 * @param delYdCd
	 */
	public void setDelYdCd(String delYdCd) {
		this.delYdCd = delYdCd;
	}
	
	/**
	 * Column Info
	 * @return pptRcvOfcCd
	 */
	public String getPptRcvOfcCd() {
		return this.pptRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cctOtsCurrCd3
	 */
	public String getCctOtsCurrCd3() {
		return this.cctOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @return cctOtsCurrCd4
	 */
	public String getCctOtsCurrCd4() {
		return this.cctOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @return cctOtsCurrCd1
	 */
	public String getCctOtsCurrCd1() {
		return this.cctOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @return cctOtsCurrCd2
	 */
	public String getCctOtsCurrCd2() {
		return this.cctOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctRcvDt
	 */
	public String getN3ptyCctRcvDt() {
		return this.n3ptyCctRcvDt;
	}
	
	/**
	 * Column Info
	 * @return cctOtsCurrCd5
	 */
	public String getCctOtsCurrCd5() {
		return this.cctOtsCurrCd5;
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
	 * @return cctRcvOfcCd
	 */
	public String getCctRcvOfcCd() {
		return this.cctRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsCurrCd3
	 */
	public String getN3ptyPptOtsCurrCd3() {
		return this.n3ptyPptOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsCurrCd4
	 */
	public String getN3ptyPptOtsCurrCd4() {
		return this.n3ptyPptOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsCurrCd1
	 */
	public String getN3ptyPptOtsCurrCd1() {
		return this.n3ptyPptOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsCurrCd2
	 */
	public String getN3ptyPptOtsCurrCd2() {
		return this.n3ptyPptOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @return cctRcvDt
	 */
	public String getCctRcvDt() {
		return this.cctRcvDt;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctRcvOfcCd
	 */
	public String getN3ptyCctRcvOfcCd() {
		return this.n3ptyCctRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsCurrCd5
	 */
	public String getN3ptyPptOtsCurrCd5() {
		return this.n3ptyPptOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @return totOtsCurrCd1
	 */
	public String getTotOtsCurrCd1() {
		return this.totOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @return totOtsCurrCd2
	 */
	public String getTotOtsCurrCd2() {
		return this.totOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @return totOtsCurrCd3
	 */
	public String getTotOtsCurrCd3() {
		return this.totOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @return totOtsCurrCd4
	 */
	public String getTotOtsCurrCd4() {
		return this.totOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @return totOtsCurrCd5
	 */
	public String getTotOtsCurrCd5() {
		return this.totOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptRcvDt
	 */
	public String getN3ptyPptRcvDt() {
		return this.n3ptyPptRcvDt;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptRcvUsrId
	 */
	public String getN3ptyPptRcvUsrId() {
		return this.n3ptyPptRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsAmt4
	 */
	public String getN3ptyCctOtsAmt4() {
		return this.n3ptyCctOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsAmt5
	 */
	public String getN3ptyCctOtsAmt5() {
		return this.n3ptyCctOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @return pptRcvUsrId
	 */
	public String getPptRcvUsrId() {
		return this.pptRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsAmt2
	 */
	public String getN3ptyCctOtsAmt2() {
		return this.n3ptyCctOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsAmt3
	 */
	public String getN3ptyCctOtsAmt3() {
		return this.n3ptyCctOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctStsCd
	 */
	public String getN3ptyCctStsCd() {
		return this.n3ptyCctStsCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsAmt1
	 */
	public String getN3ptyCctOtsAmt1() {
		return this.n3ptyCctOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @return pptStsCd
	 */
	public String getPptStsCd() {
		return this.pptStsCd;
	}
	
	/**
	 * Column Info
	 * @return totOtsStsCd
	 */
	public String getTotOtsStsCd() {
		return this.totOtsStsCd;
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
	 * @return pptRcvDt
	 */
	public String getPptRcvDt() {
		return this.pptRcvDt;
	}
	
	/**
	 * Column Info
	 * @return pptOtsCurrCd5
	 */
	public String getPptOtsCurrCd5() {
		return this.pptOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @return eaiResult
	 */
	public String getEaiResult() {
		return this.eaiResult;
	}
	
	/**
	 * Column Info
	 * @return totOtsAmt1
	 */
	public String getTotOtsAmt1() {
		return this.totOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @return totOtsAmt2
	 */
	public String getTotOtsAmt2() {
		return this.totOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @return pptOtsCurrCd3
	 */
	public String getPptOtsCurrCd3() {
		return this.pptOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsAmt5
	 */
	public String getN3ptyPptOtsAmt5() {
		return this.n3ptyPptOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @return pptOtsCurrCd4
	 */
	public String getPptOtsCurrCd4() {
		return this.pptOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsAmt4
	 */
	public String getN3ptyPptOtsAmt4() {
		return this.n3ptyPptOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @return pptOtsAmt1
	 */
	public String getPptOtsAmt1() {
		return this.pptOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @return pptOtsCurrCd1
	 */
	public String getPptOtsCurrCd1() {
		return this.pptOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsAmt3
	 */
	public String getN3ptyPptOtsAmt3() {
		return this.n3ptyPptOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @return pptOtsCurrCd2
	 */
	public String getPptOtsCurrCd2() {
		return this.pptOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsAmt2
	 */
	public String getN3ptyPptOtsAmt2() {
		return this.n3ptyPptOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @return pptOtsAmt3
	 */
	public String getPptOtsAmt3() {
		return this.pptOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsAmt1
	 */
	public String getN3ptyPptOtsAmt1() {
		return this.n3ptyPptOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @return pptOtsAmt2
	 */
	public String getPptOtsAmt2() {
		return this.pptOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @return pptOtsAmt5
	 */
	public String getPptOtsAmt5() {
		return this.pptOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @return pptOtsAmt4
	 */
	public String getPptOtsAmt4() {
		return this.pptOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @return cctStsCd
	 */
	public String getCctStsCd() {
		return this.cctStsCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptRcvOfcCd
	 */
	public String getN3ptyPptRcvOfcCd() {
		return this.n3ptyPptRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsCurrCd5
	 */
	public String getN3ptyCctOtsCurrCd5() {
		return this.n3ptyCctOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @return cctOtsAmt5
	 */
	public String getCctOtsAmt5() {
		return this.cctOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsCurrCd2
	 */
	public String getN3ptyCctOtsCurrCd2() {
		return this.n3ptyCctOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @return totOtsAmt5
	 */
	public String getTotOtsAmt5() {
		return this.totOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @return cctOtsAmt4
	 */
	public String getCctOtsAmt4() {
		return this.cctOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsCurrCd1
	 */
	public String getN3ptyCctOtsCurrCd1() {
		return this.n3ptyCctOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @return totOtsAmt4
	 */
	public String getTotOtsAmt4() {
		return this.totOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @return cctOtsAmt3
	 */
	public String getCctOtsAmt3() {
		return this.cctOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsCurrCd4
	 */
	public String getN3ptyCctOtsCurrCd4() {
		return this.n3ptyCctOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @return totOtsAmt3
	 */
	public String getTotOtsAmt3() {
		return this.totOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @return cctOtsAmt2
	 */
	public String getCctOtsAmt2() {
		return this.cctOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsCurrCd3
	 */
	public String getN3ptyCctOtsCurrCd3() {
		return this.n3ptyCctOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @return cctOtsAmt1
	 */
	public String getCctOtsAmt1() {
		return this.cctOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @return cctRcvUsrId
	 */
	public String getCctRcvUsrId() {
		return this.cctRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctRcvUsrId
	 */
	public String getN3ptyCctRcvUsrId() {
		return this.n3ptyCctRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptStsCd
	 */
	public String getN3ptyPptStsCd() {
		return this.n3ptyPptStsCd;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}

	/**
	 * Column Info
	 * @return delYdCd
	 */
	public String getDelYdCd() {
		return this.delYdCd;
	}
	
	/**
	 * Column Info
	 * @param pptRcvOfcCd
	 */
	public void setPptRcvOfcCd(String pptRcvOfcCd) {
		this.pptRcvOfcCd = pptRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cctOtsCurrCd3
	 */
	public void setCctOtsCurrCd3(String cctOtsCurrCd3) {
		this.cctOtsCurrCd3 = cctOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @param cctOtsCurrCd4
	 */
	public void setCctOtsCurrCd4(String cctOtsCurrCd4) {
		this.cctOtsCurrCd4 = cctOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @param cctOtsCurrCd1
	 */
	public void setCctOtsCurrCd1(String cctOtsCurrCd1) {
		this.cctOtsCurrCd1 = cctOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @param cctOtsCurrCd2
	 */
	public void setCctOtsCurrCd2(String cctOtsCurrCd2) {
		this.cctOtsCurrCd2 = cctOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctRcvDt
	 */
	public void setN3ptyCctRcvDt(String n3ptyCctRcvDt) {
		this.n3ptyCctRcvDt = n3ptyCctRcvDt;
	}
	
	/**
	 * Column Info
	 * @param cctOtsCurrCd5
	 */
	public void setCctOtsCurrCd5(String cctOtsCurrCd5) {
		this.cctOtsCurrCd5 = cctOtsCurrCd5;
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
	 * @param cctRcvOfcCd
	 */
	public void setCctRcvOfcCd(String cctRcvOfcCd) {
		this.cctRcvOfcCd = cctRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsCurrCd3
	 */
	public void setN3ptyPptOtsCurrCd3(String n3ptyPptOtsCurrCd3) {
		this.n3ptyPptOtsCurrCd3 = n3ptyPptOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsCurrCd4
	 */
	public void setN3ptyPptOtsCurrCd4(String n3ptyPptOtsCurrCd4) {
		this.n3ptyPptOtsCurrCd4 = n3ptyPptOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsCurrCd1
	 */
	public void setN3ptyPptOtsCurrCd1(String n3ptyPptOtsCurrCd1) {
		this.n3ptyPptOtsCurrCd1 = n3ptyPptOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsCurrCd2
	 */
	public void setN3ptyPptOtsCurrCd2(String n3ptyPptOtsCurrCd2) {
		this.n3ptyPptOtsCurrCd2 = n3ptyPptOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @param cctRcvDt
	 */
	public void setCctRcvDt(String cctRcvDt) {
		this.cctRcvDt = cctRcvDt;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctRcvOfcCd
	 */
	public void setN3ptyCctRcvOfcCd(String n3ptyCctRcvOfcCd) {
		this.n3ptyCctRcvOfcCd = n3ptyCctRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsCurrCd5
	 */
	public void setN3ptyPptOtsCurrCd5(String n3ptyPptOtsCurrCd5) {
		this.n3ptyPptOtsCurrCd5 = n3ptyPptOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @param totOtsCurrCd1
	 */
	public void setTotOtsCurrCd1(String totOtsCurrCd1) {
		this.totOtsCurrCd1 = totOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @param totOtsCurrCd2
	 */
	public void setTotOtsCurrCd2(String totOtsCurrCd2) {
		this.totOtsCurrCd2 = totOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @param totOtsCurrCd3
	 */
	public void setTotOtsCurrCd3(String totOtsCurrCd3) {
		this.totOtsCurrCd3 = totOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @param totOtsCurrCd4
	 */
	public void setTotOtsCurrCd4(String totOtsCurrCd4) {
		this.totOtsCurrCd4 = totOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @param totOtsCurrCd5
	 */
	public void setTotOtsCurrCd5(String totOtsCurrCd5) {
		this.totOtsCurrCd5 = totOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptRcvDt
	 */
	public void setN3ptyPptRcvDt(String n3ptyPptRcvDt) {
		this.n3ptyPptRcvDt = n3ptyPptRcvDt;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptRcvUsrId
	 */
	public void setN3ptyPptRcvUsrId(String n3ptyPptRcvUsrId) {
		this.n3ptyPptRcvUsrId = n3ptyPptRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsAmt4
	 */
	public void setN3ptyCctOtsAmt4(String n3ptyCctOtsAmt4) {
		this.n3ptyCctOtsAmt4 = n3ptyCctOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsAmt5
	 */
	public void setN3ptyCctOtsAmt5(String n3ptyCctOtsAmt5) {
		this.n3ptyCctOtsAmt5 = n3ptyCctOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @param pptRcvUsrId
	 */
	public void setPptRcvUsrId(String pptRcvUsrId) {
		this.pptRcvUsrId = pptRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsAmt2
	 */
	public void setN3ptyCctOtsAmt2(String n3ptyCctOtsAmt2) {
		this.n3ptyCctOtsAmt2 = n3ptyCctOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsAmt3
	 */
	public void setN3ptyCctOtsAmt3(String n3ptyCctOtsAmt3) {
		this.n3ptyCctOtsAmt3 = n3ptyCctOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctStsCd
	 */
	public void setN3ptyCctStsCd(String n3ptyCctStsCd) {
		this.n3ptyCctStsCd = n3ptyCctStsCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsAmt1
	 */
	public void setN3ptyCctOtsAmt1(String n3ptyCctOtsAmt1) {
		this.n3ptyCctOtsAmt1 = n3ptyCctOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @param pptStsCd
	 */
	public void setPptStsCd(String pptStsCd) {
		this.pptStsCd = pptStsCd;
	}
	
	/**
	 * Column Info
	 * @param totOtsStsCd
	 */
	public void setTotOtsStsCd(String totOtsStsCd) {
		this.totOtsStsCd = totOtsStsCd;
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
	 * @param pptRcvDt
	 */
	public void setPptRcvDt(String pptRcvDt) {
		this.pptRcvDt = pptRcvDt;
	}
	
	/**
	 * Column Info
	 * @param pptOtsCurrCd5
	 */
	public void setPptOtsCurrCd5(String pptOtsCurrCd5) {
		this.pptOtsCurrCd5 = pptOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @param eaiResult
	 */
	public void setEaiResult(String eaiResult) {
		this.eaiResult = eaiResult;
	}
	
	/**
	 * Column Info
	 * @param totOtsAmt1
	 */
	public void setTotOtsAmt1(String totOtsAmt1) {
		this.totOtsAmt1 = totOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @param totOtsAmt2
	 */
	public void setTotOtsAmt2(String totOtsAmt2) {
		this.totOtsAmt2 = totOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @param pptOtsCurrCd3
	 */
	public void setPptOtsCurrCd3(String pptOtsCurrCd3) {
		this.pptOtsCurrCd3 = pptOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsAmt5
	 */
	public void setN3ptyPptOtsAmt5(String n3ptyPptOtsAmt5) {
		this.n3ptyPptOtsAmt5 = n3ptyPptOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @param pptOtsCurrCd4
	 */
	public void setPptOtsCurrCd4(String pptOtsCurrCd4) {
		this.pptOtsCurrCd4 = pptOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsAmt4
	 */
	public void setN3ptyPptOtsAmt4(String n3ptyPptOtsAmt4) {
		this.n3ptyPptOtsAmt4 = n3ptyPptOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @param pptOtsAmt1
	 */
	public void setPptOtsAmt1(String pptOtsAmt1) {
		this.pptOtsAmt1 = pptOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @param pptOtsCurrCd1
	 */
	public void setPptOtsCurrCd1(String pptOtsCurrCd1) {
		this.pptOtsCurrCd1 = pptOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsAmt3
	 */
	public void setN3ptyPptOtsAmt3(String n3ptyPptOtsAmt3) {
		this.n3ptyPptOtsAmt3 = n3ptyPptOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @param pptOtsCurrCd2
	 */
	public void setPptOtsCurrCd2(String pptOtsCurrCd2) {
		this.pptOtsCurrCd2 = pptOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsAmt2
	 */
	public void setN3ptyPptOtsAmt2(String n3ptyPptOtsAmt2) {
		this.n3ptyPptOtsAmt2 = n3ptyPptOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @param pptOtsAmt3
	 */
	public void setPptOtsAmt3(String pptOtsAmt3) {
		this.pptOtsAmt3 = pptOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsAmt1
	 */
	public void setN3ptyPptOtsAmt1(String n3ptyPptOtsAmt1) {
		this.n3ptyPptOtsAmt1 = n3ptyPptOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @param pptOtsAmt2
	 */
	public void setPptOtsAmt2(String pptOtsAmt2) {
		this.pptOtsAmt2 = pptOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @param pptOtsAmt5
	 */
	public void setPptOtsAmt5(String pptOtsAmt5) {
		this.pptOtsAmt5 = pptOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @param pptOtsAmt4
	 */
	public void setPptOtsAmt4(String pptOtsAmt4) {
		this.pptOtsAmt4 = pptOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @param cctStsCd
	 */
	public void setCctStsCd(String cctStsCd) {
		this.cctStsCd = cctStsCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptRcvOfcCd
	 */
	public void setN3ptyPptRcvOfcCd(String n3ptyPptRcvOfcCd) {
		this.n3ptyPptRcvOfcCd = n3ptyPptRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsCurrCd5
	 */
	public void setN3ptyCctOtsCurrCd5(String n3ptyCctOtsCurrCd5) {
		this.n3ptyCctOtsCurrCd5 = n3ptyCctOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @param cctOtsAmt5
	 */
	public void setCctOtsAmt5(String cctOtsAmt5) {
		this.cctOtsAmt5 = cctOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsCurrCd2
	 */
	public void setN3ptyCctOtsCurrCd2(String n3ptyCctOtsCurrCd2) {
		this.n3ptyCctOtsCurrCd2 = n3ptyCctOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @param totOtsAmt5
	 */
	public void setTotOtsAmt5(String totOtsAmt5) {
		this.totOtsAmt5 = totOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @param cctOtsAmt4
	 */
	public void setCctOtsAmt4(String cctOtsAmt4) {
		this.cctOtsAmt4 = cctOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsCurrCd1
	 */
	public void setN3ptyCctOtsCurrCd1(String n3ptyCctOtsCurrCd1) {
		this.n3ptyCctOtsCurrCd1 = n3ptyCctOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @param totOtsAmt4
	 */
	public void setTotOtsAmt4(String totOtsAmt4) {
		this.totOtsAmt4 = totOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @param cctOtsAmt3
	 */
	public void setCctOtsAmt3(String cctOtsAmt3) {
		this.cctOtsAmt3 = cctOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsCurrCd4
	 */
	public void setN3ptyCctOtsCurrCd4(String n3ptyCctOtsCurrCd4) {
		this.n3ptyCctOtsCurrCd4 = n3ptyCctOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @param totOtsAmt3
	 */
	public void setTotOtsAmt3(String totOtsAmt3) {
		this.totOtsAmt3 = totOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @param cctOtsAmt2
	 */
	public void setCctOtsAmt2(String cctOtsAmt2) {
		this.cctOtsAmt2 = cctOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsCurrCd3
	 */
	public void setN3ptyCctOtsCurrCd3(String n3ptyCctOtsCurrCd3) {
		this.n3ptyCctOtsCurrCd3 = n3ptyCctOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @param cctOtsAmt1
	 */
	public void setCctOtsAmt1(String cctOtsAmt1) {
		this.cctOtsAmt1 = cctOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @param cctRcvUsrId
	 */
	public void setCctRcvUsrId(String cctRcvUsrId) {
		this.cctRcvUsrId = cctRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctRcvUsrId
	 */
	public void setN3ptyCctRcvUsrId(String n3ptyCctRcvUsrId) {
		this.n3ptyCctRcvUsrId = n3ptyCctRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptStsCd
	 */
	public void setN3ptyPptStsCd(String n3ptyPptStsCd) {
		this.n3ptyPptStsCd = n3ptyPptStsCd;
	}

	/**
	 * Column Info
	 * @param instruction
	 */
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	/**
	 * Column Info
	 * @param collOfcCd
	 */
	public void setCollOfcCd(String collOfcCd) {
		this.collOfcCd = collOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dirDeFlg
	 */
	public void setDirDeFlg(String dirDeFlg) {
		this.dirDeFlg = dirDeFlg;
	}
	
	/**
	 * Column Info
	 * @param freeTrdZnFlg
	 */
	public void setFreeTrdZnFlg(String freeTrdZnFlg) {
		this.freeTrdZnFlg = freeTrdZnFlg;
	}

	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInstruction(JSPUtil.getParameter(request, "instruction", ""));
		setSplitFlg(JSPUtil.getParameter(request, "split_flg", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, "vps_etb_dt", ""));
		setArrivalVvd(JSPUtil.getParameter(request, "arrival_vvd", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setBdrFlg(JSPUtil.getParameter(request, "bdr_flg", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setCsgCustCd(JSPUtil.getParameter(request, "csg_cust_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOblRdemDt(JSPUtil.getParameter(request, "obl_rdem_dt", ""));
		setCstmsDesc(JSPUtil.getParameter(request, "cstms_desc", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setBkgCreDt(JSPUtil.getParameter(request, "bkg_cre_dt", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setShpCustNm(JSPUtil.getParameter(request, "shp_cust_nm", ""));
		setPodNm(JSPUtil.getParameter(request, "pod_nm", ""));
		setNoyCustNm(JSPUtil.getParameter(request, "noy_cust_nm", ""));
		setDelNm(JSPUtil.getParameter(request, "del_nm", ""));
		setArrivalVvdNm(JSPUtil.getParameter(request, "arrival_vvd_nm", ""));
		setAoyCustCd(JSPUtil.getParameter(request, "aoy_cust_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setOblRdemFlg(JSPUtil.getParameter(request, "obl_rdem_flg", ""));
		setUsOblRdemFlg(JSPUtil.getParameter(request, "us_obl_rdem_flg", ""));
		setPartial(JSPUtil.getParameter(request, "partial", ""));
		setCorrUsrId(JSPUtil.getParameter(request, "corr_usr_id", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setActWgt(JSPUtil.getParameter(request, "act_wgt", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setAoyCustNm(JSPUtil.getParameter(request, "aoy_cust_nm", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setShpCustCd(JSPUtil.getParameter(request, "shp_cust_cd", ""));
		setNoyCustCd(JSPUtil.getParameter(request, "noy_cust_cd", ""));
		setCsgCustNm(JSPUtil.getParameter(request, "csg_cust_nm", ""));
		setOblRdemOfcCd(JSPUtil.getParameter(request, "obl_rdem_ofc_cd", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, "bb_cgo_flg", ""));
		
		setPptRcvOfcCd(JSPUtil.getParameter(request, "ppt_rcv_ofc_cd", ""));
		setCctOtsCurrCd3(JSPUtil.getParameter(request, "cct_ots_curr_cd3", ""));
		setCctOtsCurrCd4(JSPUtil.getParameter(request, "cct_ots_curr_cd4", ""));
		setCctOtsCurrCd1(JSPUtil.getParameter(request, "cct_ots_curr_cd1", ""));
		setCctOtsCurrCd2(JSPUtil.getParameter(request, "cct_ots_curr_cd2", ""));
		setN3ptyCctRcvDt(JSPUtil.getParameter(request, "n3pty_cct_rcv_dt", ""));
		setCctOtsCurrCd5(JSPUtil.getParameter(request, "cct_ots_curr_cd5", ""));
		setCctRcvOfcCd(JSPUtil.getParameter(request, "cct_rcv_ofc_cd", ""));
		setN3ptyPptOtsCurrCd3(JSPUtil.getParameter(request, "n3pty_ppt_ots_curr_cd3", ""));
		setN3ptyPptOtsCurrCd4(JSPUtil.getParameter(request, "n3pty_ppt_ots_curr_cd4", ""));
		setN3ptyPptOtsCurrCd1(JSPUtil.getParameter(request, "n3pty_ppt_ots_curr_cd1", ""));
		setN3ptyPptOtsCurrCd2(JSPUtil.getParameter(request, "n3pty_ppt_ots_curr_cd2", ""));
		setCctRcvDt(JSPUtil.getParameter(request, "cct_rcv_dt", ""));
		setN3ptyCctRcvOfcCd(JSPUtil.getParameter(request, "n3pty_cct_rcv_ofc_cd", ""));
		setN3ptyPptOtsCurrCd5(JSPUtil.getParameter(request, "n3pty_ppt_ots_curr_cd5", ""));
		setTotOtsCurrCd1(JSPUtil.getParameter(request, "tot_ots_curr_cd1", ""));
		setTotOtsCurrCd2(JSPUtil.getParameter(request, "tot_ots_curr_cd2", ""));
		setTotOtsCurrCd3(JSPUtil.getParameter(request, "tot_ots_curr_cd3", ""));
		setTotOtsCurrCd4(JSPUtil.getParameter(request, "tot_ots_curr_cd4", ""));
		setTotOtsCurrCd5(JSPUtil.getParameter(request, "tot_ots_curr_cd5", ""));
		setN3ptyPptRcvDt(JSPUtil.getParameter(request, "n3pty_ppt_rcv_dt", ""));
		setN3ptyPptRcvUsrId(JSPUtil.getParameter(request, "n3pty_ppt_rcv_usr_id", ""));
		setN3ptyCctOtsAmt4(JSPUtil.getParameter(request, "n3pty_cct_ots_amt4", ""));
		setN3ptyCctOtsAmt5(JSPUtil.getParameter(request, "n3pty_cct_ots_amt5", ""));
		setPptRcvUsrId(JSPUtil.getParameter(request, "ppt_rcv_usr_id", ""));
		setN3ptyCctOtsAmt2(JSPUtil.getParameter(request, "n3pty_cct_ots_amt2", ""));
		setN3ptyCctOtsAmt3(JSPUtil.getParameter(request, "n3pty_cct_ots_amt3", ""));
		setN3ptyCctStsCd(JSPUtil.getParameter(request, "n3pty_cct_sts_cd", ""));
		setN3ptyCctOtsAmt1(JSPUtil.getParameter(request, "n3pty_cct_ots_amt1", ""));
		setPptStsCd(JSPUtil.getParameter(request, "ppt_sts_cd", ""));
		setTotOtsStsCd(JSPUtil.getParameter(request, "tot_ots_sts_cd", ""));
		setPptRcvDt(JSPUtil.getParameter(request, "ppt_rcv_dt", ""));
		setPptOtsCurrCd5(JSPUtil.getParameter(request, "ppt_ots_curr_cd5", ""));
		setEaiResult(JSPUtil.getParameter(request, "eai_result", ""));
		setTotOtsAmt1(JSPUtil.getParameter(request, "tot_ots_amt1", ""));
		setTotOtsAmt2(JSPUtil.getParameter(request, "tot_ots_amt2", ""));
		setPptOtsCurrCd3(JSPUtil.getParameter(request, "ppt_ots_curr_cd3", ""));
		setN3ptyPptOtsAmt5(JSPUtil.getParameter(request, "n3pty_ppt_ots_amt5", ""));
		setPptOtsCurrCd4(JSPUtil.getParameter(request, "ppt_ots_curr_cd4", ""));
		setN3ptyPptOtsAmt4(JSPUtil.getParameter(request, "n3pty_ppt_ots_amt4", ""));
		setPptOtsAmt1(JSPUtil.getParameter(request, "ppt_ots_amt1", ""));
		setPptOtsCurrCd1(JSPUtil.getParameter(request, "ppt_ots_curr_cd1", ""));
		setN3ptyPptOtsAmt3(JSPUtil.getParameter(request, "n3pty_ppt_ots_amt3", ""));
		setPptOtsCurrCd2(JSPUtil.getParameter(request, "ppt_ots_curr_cd2", ""));
		setN3ptyPptOtsAmt2(JSPUtil.getParameter(request, "n3pty_ppt_ots_amt2", ""));
		setPptOtsAmt3(JSPUtil.getParameter(request, "ppt_ots_amt3", ""));
		setN3ptyPptOtsAmt1(JSPUtil.getParameter(request, "n3pty_ppt_ots_amt1", ""));
		setPptOtsAmt2(JSPUtil.getParameter(request, "ppt_ots_amt2", ""));
		setPptOtsAmt5(JSPUtil.getParameter(request, "ppt_ots_amt5", ""));
		setPptOtsAmt4(JSPUtil.getParameter(request, "ppt_ots_amt4", ""));
		setCctStsCd(JSPUtil.getParameter(request, "cct_sts_cd", ""));
		setN3ptyPptRcvOfcCd(JSPUtil.getParameter(request, "n3pty_ppt_rcv_ofc_cd", ""));
		setN3ptyCctOtsCurrCd5(JSPUtil.getParameter(request, "n3pty_cct_ots_curr_cd5", ""));
		setCctOtsAmt5(JSPUtil.getParameter(request, "cct_ots_amt5", ""));
		setN3ptyCctOtsCurrCd2(JSPUtil.getParameter(request, "n3pty_cct_ots_curr_cd2", ""));
		setTotOtsAmt5(JSPUtil.getParameter(request, "tot_ots_amt5", ""));
		setCctOtsAmt4(JSPUtil.getParameter(request, "cct_ots_amt4", ""));
		setN3ptyCctOtsCurrCd1(JSPUtil.getParameter(request, "n3pty_cct_ots_curr_cd1", ""));
		setTotOtsAmt4(JSPUtil.getParameter(request, "tot_ots_amt4", ""));
		setCctOtsAmt3(JSPUtil.getParameter(request, "cct_ots_amt3", ""));
		setN3ptyCctOtsCurrCd4(JSPUtil.getParameter(request, "n3pty_cct_ots_curr_cd4", ""));
		setTotOtsAmt3(JSPUtil.getParameter(request, "tot_ots_amt3", ""));
		setCctOtsAmt2(JSPUtil.getParameter(request, "cct_ots_amt2", ""));
		setN3ptyCctOtsCurrCd3(JSPUtil.getParameter(request, "n3pty_cct_ots_curr_cd3", ""));
		setCctOtsAmt1(JSPUtil.getParameter(request, "cct_ots_amt1", ""));
		setCctRcvUsrId(JSPUtil.getParameter(request, "cct_rcv_usr_id", ""));
		setN3ptyCctRcvUsrId(JSPUtil.getParameter(request, "n3pty_cct_rcv_usr_id", ""));
		setN3ptyPptStsCd(JSPUtil.getParameter(request, "n3pty_ppt_sts_cd", ""));
		setPodYdCd(JSPUtil.getParameter(request, "pod_yd_cd", ""));
		setDelYdCd(JSPUtil.getParameter(request, "del_yd_cd", ""));
		setCollOfcCd(JSPUtil.getParameter(request, "coll_ofc_cd", ""));
		
		setDirDeFlg(JSPUtil.getParameter(request, "dir_de_flg", ""));
		setFreeTrdZnFlg(JSPUtil.getParameter(request, "free_trd_zn_flg", ""));
		
	}
	
	

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlInfosVO[]
	 */
	public BlInfosVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlInfosVO[]
	 */
	public BlInfosVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlInfosVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] instruction = (JSPUtil.getParameter(request, prefix	+ "instruction", length));
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "split_flg", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] arrivalVvd = (JSPUtil.getParameter(request, prefix	+ "arrival_vvd", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] csgCustCd = (JSPUtil.getParameter(request, prefix	+ "csg_cust_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oblRdemDt = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_dt", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] bkgCreDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] shpCustNm = (JSPUtil.getParameter(request, prefix	+ "shp_cust_nm", length));
			String[] podNm = (JSPUtil.getParameter(request, prefix	+ "pod_nm", length));
			String[] noyCustNm = (JSPUtil.getParameter(request, prefix	+ "noy_cust_nm", length));
			String[] delNm = (JSPUtil.getParameter(request, prefix	+ "del_nm", length));
			String[] arrivalVvdNm = (JSPUtil.getParameter(request, prefix	+ "arrival_vvd_nm", length));
			String[] aoyCustCd = (JSPUtil.getParameter(request, prefix	+ "aoy_cust_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] oblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_flg", length));
			String[] usOblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "us_obl_rdem_flg", length));
			String[] partial = (JSPUtil.getParameter(request, prefix	+ "partial", length));
			String[] corrUsrId = (JSPUtil.getParameter(request, prefix	+ "corr_usr_id", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] aoyCustNm = (JSPUtil.getParameter(request, prefix	+ "aoy_cust_nm", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] shpCustCd = (JSPUtil.getParameter(request, prefix	+ "shp_cust_cd", length));
			String[] noyCustCd = (JSPUtil.getParameter(request, prefix	+ "noy_cust_cd", length));
			String[] csgCustNm = (JSPUtil.getParameter(request, prefix	+ "csg_cust_nm", length));
			String[] oblRdemOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_ofc_cd", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			
			String[] pptRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "ppt_rcv_ofc_cd", length));
			String[] cctOtsCurrCd3 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_curr_cd3", length));
			String[] cctOtsCurrCd4 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_curr_cd4", length));
			String[] cctOtsCurrCd1 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_curr_cd1", length));
			String[] cctOtsCurrCd2 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_curr_cd2", length));
			String[] n3ptyCctRcvDt = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_rcv_dt", length));
			String[] cctOtsCurrCd5 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_curr_cd5", length));
			String[] cctRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "cct_rcv_ofc_cd", length));
			String[] n3ptyPptOtsCurrCd3 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_curr_cd3", length));
			String[] n3ptyPptOtsCurrCd4 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_curr_cd4", length));
			String[] n3ptyPptOtsCurrCd1 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_curr_cd1", length));
			String[] n3ptyPptOtsCurrCd2 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_curr_cd2", length));
			String[] cctRcvDt = (JSPUtil.getParameter(request, prefix	+ "cct_rcv_dt", length));
			String[] n3ptyCctRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_rcv_ofc_cd", length));
			String[] n3ptyPptOtsCurrCd5 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_curr_cd5", length));
			String[] totOtsCurrCd1 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_curr_cd1", length));
			String[] totOtsCurrCd2 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_curr_cd2", length));
			String[] totOtsCurrCd3 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_curr_cd3", length));
			String[] totOtsCurrCd4 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_curr_cd4", length));
			String[] totOtsCurrCd5 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_curr_cd5", length));
			String[] n3ptyPptRcvDt = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_rcv_dt", length));
			String[] n3ptyPptRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_rcv_usr_id", length));
			String[] n3ptyCctOtsAmt4 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_amt4", length));
			String[] n3ptyCctOtsAmt5 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_amt5", length));
			String[] pptRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "ppt_rcv_usr_id", length));
			String[] n3ptyCctOtsAmt2 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_amt2", length));
			String[] n3ptyCctOtsAmt3 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_amt3", length));
			String[] n3ptyCctStsCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_sts_cd", length));
			String[] n3ptyCctOtsAmt1 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_amt1", length));
			String[] pptStsCd = (JSPUtil.getParameter(request, prefix	+ "ppt_sts_cd", length));
			String[] totOtsStsCd = (JSPUtil.getParameter(request, prefix	+ "tot_ots_sts_cd", length));
			String[] pptRcvDt = (JSPUtil.getParameter(request, prefix	+ "ppt_rcv_dt", length));
			String[] pptOtsCurrCd5 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_curr_cd5", length));
			String[] eaiResult = (JSPUtil.getParameter(request, prefix	+ "eai_result", length));
			String[] totOtsAmt1 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_amt1", length));
			String[] totOtsAmt2 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_amt2", length));
			String[] pptOtsCurrCd3 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_curr_cd3", length));
			String[] n3ptyPptOtsAmt5 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_amt5", length));
			String[] pptOtsCurrCd4 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_curr_cd4", length));
			String[] n3ptyPptOtsAmt4 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_amt4", length));
			String[] pptOtsAmt1 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_amt1", length));
			String[] pptOtsCurrCd1 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_curr_cd1", length));
			String[] n3ptyPptOtsAmt3 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_amt3", length));
			String[] pptOtsCurrCd2 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_curr_cd2", length));
			String[] n3ptyPptOtsAmt2 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_amt2", length));
			String[] pptOtsAmt3 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_amt3", length));
			String[] n3ptyPptOtsAmt1 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_amt1", length));
			String[] pptOtsAmt2 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_amt2", length));
			String[] pptOtsAmt5 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_amt5", length));
			String[] pptOtsAmt4 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_amt4", length));
			String[] cctStsCd = (JSPUtil.getParameter(request, prefix	+ "cct_sts_cd", length));
			String[] n3ptyPptRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_rcv_ofc_cd", length));
			String[] n3ptyCctOtsCurrCd5 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_curr_cd5", length));
			String[] cctOtsAmt5 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_amt5", length));
			String[] n3ptyCctOtsCurrCd2 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_curr_cd2", length));
			String[] totOtsAmt5 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_amt5", length));
			String[] cctOtsAmt4 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_amt4", length));
			String[] n3ptyCctOtsCurrCd1 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_curr_cd1", length));
			String[] totOtsAmt4 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_amt4", length));
			String[] cctOtsAmt3 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_amt3", length));
			String[] n3ptyCctOtsCurrCd4 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_curr_cd4", length));
			String[] totOtsAmt3 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_amt3", length));
			String[] cctOtsAmt2 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_amt2", length));
			String[] n3ptyCctOtsCurrCd3 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_curr_cd3", length));
			String[] cctOtsAmt1 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_amt1", length));
			String[] cctRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "cct_rcv_usr_id", length));
			String[] n3ptyCctRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_rcv_usr_id", length));
			String[] n3ptyPptStsCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_sts_cd", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] delYdCd = (JSPUtil.getParameter(request, prefix	+ "del_yd_cd", length));
			String[] collOfcCd = (JSPUtil.getParameter(request, prefix	+ "coll_ofc_cd", length));
			
			String[] dirDeFlg = (JSPUtil.getParameter(request, prefix	+ "dir_de_flg", length));			
			String[] freeTrdZnFlg = (JSPUtil.getParameter(request, prefix	+ "free_trd_zn_flg", length));			
			
			for (int i = 0; i < length; i++) {
				model = new BlInfosVO();
				if (instruction[i] != null)
					model.setInstruction(instruction[i]);
				if (splitFlg[i] != null)
					model.setSplitFlg(splitFlg[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (arrivalVvd[i] != null)
					model.setArrivalVvd(arrivalVvd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (csgCustCd[i] != null)
					model.setCsgCustCd(csgCustCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oblRdemDt[i] != null)
					model.setOblRdemDt(oblRdemDt[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (bkgCreDt[i] != null)
					model.setBkgCreDt(bkgCreDt[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (shpCustNm[i] != null)
					model.setShpCustNm(shpCustNm[i]);
				if (podNm[i] != null)
					model.setPodNm(podNm[i]);
				if (noyCustNm[i] != null)
					model.setNoyCustNm(noyCustNm[i]);
				if (delNm[i] != null)
					model.setDelNm(delNm[i]);
				if (arrivalVvdNm[i] != null)
					model.setArrivalVvdNm(arrivalVvdNm[i]);
				if (aoyCustCd[i] != null)
					model.setAoyCustCd(aoyCustCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (oblRdemFlg[i] != null)
					model.setOblRdemFlg(oblRdemFlg[i]);
				if (usOblRdemFlg[i] != null)
					model.setUsOblRdemFlg(usOblRdemFlg[i]);
				if (partial[i] != null)
					model.setPartial(partial[i]);
				if (corrUsrId[i] != null)
					model.setCorrUsrId(corrUsrId[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (aoyCustNm[i] != null)
					model.setAoyCustNm(aoyCustNm[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (shpCustCd[i] != null)
					model.setShpCustCd(shpCustCd[i]);
				if (noyCustCd[i] != null)
					model.setNoyCustCd(noyCustCd[i]);
				if (csgCustNm[i] != null)
					model.setCsgCustNm(csgCustNm[i]);
				if (oblRdemOfcCd[i] != null)
					model.setOblRdemOfcCd(oblRdemOfcCd[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);

				if (pptRcvOfcCd[i] != null)
					model.setPptRcvOfcCd(pptRcvOfcCd[i]);
				if (cctOtsCurrCd3[i] != null)
					model.setCctOtsCurrCd3(cctOtsCurrCd3[i]);
				if (cctOtsCurrCd4[i] != null)
					model.setCctOtsCurrCd4(cctOtsCurrCd4[i]);
				if (cctOtsCurrCd1[i] != null)
					model.setCctOtsCurrCd1(cctOtsCurrCd1[i]);
				if (cctOtsCurrCd2[i] != null)
					model.setCctOtsCurrCd2(cctOtsCurrCd2[i]);
				if (n3ptyCctRcvDt[i] != null)
					model.setN3ptyCctRcvDt(n3ptyCctRcvDt[i]);
				if (cctOtsCurrCd5[i] != null)
					model.setCctOtsCurrCd5(cctOtsCurrCd5[i]);
				if (cctRcvOfcCd[i] != null)
					model.setCctRcvOfcCd(cctRcvOfcCd[i]);
				if (n3ptyPptOtsCurrCd3[i] != null)
					model.setN3ptyPptOtsCurrCd3(n3ptyPptOtsCurrCd3[i]);
				if (n3ptyPptOtsCurrCd4[i] != null)
					model.setN3ptyPptOtsCurrCd4(n3ptyPptOtsCurrCd4[i]);
				if (n3ptyPptOtsCurrCd1[i] != null)
					model.setN3ptyPptOtsCurrCd1(n3ptyPptOtsCurrCd1[i]);
				if (n3ptyPptOtsCurrCd2[i] != null)
					model.setN3ptyPptOtsCurrCd2(n3ptyPptOtsCurrCd2[i]);
				if (cctRcvDt[i] != null)
					model.setCctRcvDt(cctRcvDt[i]);
				if (n3ptyCctRcvOfcCd[i] != null)
					model.setN3ptyCctRcvOfcCd(n3ptyCctRcvOfcCd[i]);
				if (n3ptyPptOtsCurrCd5[i] != null)
					model.setN3ptyPptOtsCurrCd5(n3ptyPptOtsCurrCd5[i]);
				if (totOtsCurrCd1[i] != null)
					model.setTotOtsCurrCd1(totOtsCurrCd1[i]);
				if (totOtsCurrCd2[i] != null)
					model.setTotOtsCurrCd2(totOtsCurrCd2[i]);
				if (totOtsCurrCd3[i] != null)
					model.setTotOtsCurrCd3(totOtsCurrCd3[i]);
				if (totOtsCurrCd4[i] != null)
					model.setTotOtsCurrCd4(totOtsCurrCd4[i]);
				if (totOtsCurrCd5[i] != null)
					model.setTotOtsCurrCd5(totOtsCurrCd5[i]);
				if (n3ptyPptRcvDt[i] != null)
					model.setN3ptyPptRcvDt(n3ptyPptRcvDt[i]);
				if (n3ptyPptRcvUsrId[i] != null)
					model.setN3ptyPptRcvUsrId(n3ptyPptRcvUsrId[i]);
				if (n3ptyCctOtsAmt4[i] != null)
					model.setN3ptyCctOtsAmt4(n3ptyCctOtsAmt4[i]);
				if (n3ptyCctOtsAmt5[i] != null)
					model.setN3ptyCctOtsAmt5(n3ptyCctOtsAmt5[i]);
				if (pptRcvUsrId[i] != null)
					model.setPptRcvUsrId(pptRcvUsrId[i]);
				if (n3ptyCctOtsAmt2[i] != null)
					model.setN3ptyCctOtsAmt2(n3ptyCctOtsAmt2[i]);
				if (n3ptyCctOtsAmt3[i] != null)
					model.setN3ptyCctOtsAmt3(n3ptyCctOtsAmt3[i]);
				if (n3ptyCctStsCd[i] != null)
					model.setN3ptyCctStsCd(n3ptyCctStsCd[i]);
				if (n3ptyCctOtsAmt1[i] != null)
					model.setN3ptyCctOtsAmt1(n3ptyCctOtsAmt1[i]);
				if (pptStsCd[i] != null)
					model.setPptStsCd(pptStsCd[i]);
				if (totOtsStsCd[i] != null)
					model.setTotOtsStsCd(totOtsStsCd[i]);
				if (pptRcvDt[i] != null)
					model.setPptRcvDt(pptRcvDt[i]);
				if (pptOtsCurrCd5[i] != null)
					model.setPptOtsCurrCd5(pptOtsCurrCd5[i]);
				if (eaiResult[i] != null)
					model.setEaiResult(eaiResult[i]);
				if (totOtsAmt1[i] != null)
					model.setTotOtsAmt1(totOtsAmt1[i]);
				if (totOtsAmt2[i] != null)
					model.setTotOtsAmt2(totOtsAmt2[i]);
				if (pptOtsCurrCd3[i] != null)
					model.setPptOtsCurrCd3(pptOtsCurrCd3[i]);
				if (n3ptyPptOtsAmt5[i] != null)
					model.setN3ptyPptOtsAmt5(n3ptyPptOtsAmt5[i]);
				if (pptOtsCurrCd4[i] != null)
					model.setPptOtsCurrCd4(pptOtsCurrCd4[i]);
				if (n3ptyPptOtsAmt4[i] != null)
					model.setN3ptyPptOtsAmt4(n3ptyPptOtsAmt4[i]);
				if (pptOtsAmt1[i] != null)
					model.setPptOtsAmt1(pptOtsAmt1[i]);
				if (pptOtsCurrCd1[i] != null)
					model.setPptOtsCurrCd1(pptOtsCurrCd1[i]);
				if (n3ptyPptOtsAmt3[i] != null)
					model.setN3ptyPptOtsAmt3(n3ptyPptOtsAmt3[i]);
				if (pptOtsCurrCd2[i] != null)
					model.setPptOtsCurrCd2(pptOtsCurrCd2[i]);
				if (n3ptyPptOtsAmt2[i] != null)
					model.setN3ptyPptOtsAmt2(n3ptyPptOtsAmt2[i]);
				if (pptOtsAmt3[i] != null)
					model.setPptOtsAmt3(pptOtsAmt3[i]);
				if (n3ptyPptOtsAmt1[i] != null)
					model.setN3ptyPptOtsAmt1(n3ptyPptOtsAmt1[i]);
				if (pptOtsAmt2[i] != null)
					model.setPptOtsAmt2(pptOtsAmt2[i]);
				if (pptOtsAmt5[i] != null)
					model.setPptOtsAmt5(pptOtsAmt5[i]);
				if (pptOtsAmt4[i] != null)
					model.setPptOtsAmt4(pptOtsAmt4[i]);
				if (cctStsCd[i] != null)
					model.setCctStsCd(cctStsCd[i]);
				if (n3ptyPptRcvOfcCd[i] != null)
					model.setN3ptyPptRcvOfcCd(n3ptyPptRcvOfcCd[i]);
				if (n3ptyCctOtsCurrCd5[i] != null)
					model.setN3ptyCctOtsCurrCd5(n3ptyCctOtsCurrCd5[i]);
				if (cctOtsAmt5[i] != null)
					model.setCctOtsAmt5(cctOtsAmt5[i]);
				if (n3ptyCctOtsCurrCd2[i] != null)
					model.setN3ptyCctOtsCurrCd2(n3ptyCctOtsCurrCd2[i]);
				if (totOtsAmt5[i] != null)
					model.setTotOtsAmt5(totOtsAmt5[i]);
				if (cctOtsAmt4[i] != null)
					model.setCctOtsAmt4(cctOtsAmt4[i]);
				if (n3ptyCctOtsCurrCd1[i] != null)
					model.setN3ptyCctOtsCurrCd1(n3ptyCctOtsCurrCd1[i]);
				if (totOtsAmt4[i] != null)
					model.setTotOtsAmt4(totOtsAmt4[i]);
				if (cctOtsAmt3[i] != null)
					model.setCctOtsAmt3(cctOtsAmt3[i]);
				if (n3ptyCctOtsCurrCd4[i] != null)
					model.setN3ptyCctOtsCurrCd4(n3ptyCctOtsCurrCd4[i]);
				if (totOtsAmt3[i] != null)
					model.setTotOtsAmt3(totOtsAmt3[i]);
				if (cctOtsAmt2[i] != null)
					model.setCctOtsAmt2(cctOtsAmt2[i]);
				if (n3ptyCctOtsCurrCd3[i] != null)
					model.setN3ptyCctOtsCurrCd3(n3ptyCctOtsCurrCd3[i]);
				if (cctOtsAmt1[i] != null)
					model.setCctOtsAmt1(cctOtsAmt1[i]);
				if (cctRcvUsrId[i] != null)
					model.setCctRcvUsrId(cctRcvUsrId[i]);
				if (n3ptyCctRcvUsrId[i] != null)
					model.setN3ptyCctRcvUsrId(n3ptyCctRcvUsrId[i]);
				if (n3ptyPptStsCd[i] != null)
					model.setN3ptyPptStsCd(n3ptyPptStsCd[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (delYdCd[i] != null)
					model.setDelYdCd(delYdCd[i]);
				if (collOfcCd[i] != null)
					model.setCollOfcCd(collOfcCd[i]);
				if (delYdCd[i] != null)
					model.setDelYdCd(delYdCd[i]);				
				
				if (dirDeFlg[i] != null)
					model.setDirDeFlg(dirDeFlg[i]);
				if (freeTrdZnFlg[i] != null)
					model.setFreeTrdZnFlg(freeTrdZnFlg[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlInfosVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlInfosVO[]
	 */
	public BlInfosVO[] getBlInfosVOs(){
		BlInfosVO[] vos = (BlInfosVO[])models.toArray(new BlInfosVO[models.size()]);
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
		this.instruction = this.instruction .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrivalVvd = this.arrivalVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csgCustCd = this.csgCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemDt = this.oblRdemDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDt = this.bkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpCustNm = this.shpCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNm = this.podNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noyCustNm = this.noyCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNm = this.delNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrivalVvdNm = this.arrivalVvdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aoyCustCd = this.aoyCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemFlg = this.oblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usOblRdemFlg = this.usOblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partial = this.partial .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrUsrId = this.corrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aoyCustNm = this.aoyCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpCustCd = this.shpCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noyCustCd = this.noyCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csgCustNm = this.csgCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemOfcCd = this.oblRdemOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.pptRcvOfcCd = this.pptRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsCurrCd3 = this.cctOtsCurrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsCurrCd4 = this.cctOtsCurrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsCurrCd1 = this.cctOtsCurrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsCurrCd2 = this.cctOtsCurrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctRcvDt = this.n3ptyCctRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsCurrCd5 = this.cctOtsCurrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctRcvOfcCd = this.cctRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsCurrCd3 = this.n3ptyPptOtsCurrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsCurrCd4 = this.n3ptyPptOtsCurrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsCurrCd1 = this.n3ptyPptOtsCurrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsCurrCd2 = this.n3ptyPptOtsCurrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctRcvDt = this.cctRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctRcvOfcCd = this.n3ptyCctRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsCurrCd5 = this.n3ptyPptOtsCurrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsCurrCd1 = this.totOtsCurrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsCurrCd2 = this.totOtsCurrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsCurrCd3 = this.totOtsCurrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsCurrCd4 = this.totOtsCurrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsCurrCd5 = this.totOtsCurrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptRcvDt = this.n3ptyPptRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptRcvUsrId = this.n3ptyPptRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsAmt4 = this.n3ptyCctOtsAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsAmt5 = this.n3ptyCctOtsAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptRcvUsrId = this.pptRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsAmt2 = this.n3ptyCctOtsAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsAmt3 = this.n3ptyCctOtsAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctStsCd = this.n3ptyCctStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsAmt1 = this.n3ptyCctOtsAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptStsCd = this.pptStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsStsCd = this.totOtsStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptRcvDt = this.pptRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsCurrCd5 = this.pptOtsCurrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiResult = this.eaiResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsAmt1 = this.totOtsAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsAmt2 = this.totOtsAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsCurrCd3 = this.pptOtsCurrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsAmt5 = this.n3ptyPptOtsAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsCurrCd4 = this.pptOtsCurrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsAmt4 = this.n3ptyPptOtsAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsAmt1 = this.pptOtsAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsCurrCd1 = this.pptOtsCurrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsAmt3 = this.n3ptyPptOtsAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsCurrCd2 = this.pptOtsCurrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsAmt2 = this.n3ptyPptOtsAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsAmt3 = this.pptOtsAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsAmt1 = this.n3ptyPptOtsAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsAmt2 = this.pptOtsAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsAmt5 = this.pptOtsAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsAmt4 = this.pptOtsAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctStsCd = this.cctStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptRcvOfcCd = this.n3ptyPptRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsCurrCd5 = this.n3ptyCctOtsCurrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsAmt5 = this.cctOtsAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsCurrCd2 = this.n3ptyCctOtsCurrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsAmt5 = this.totOtsAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsAmt4 = this.cctOtsAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsCurrCd1 = this.n3ptyCctOtsCurrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsAmt4 = this.totOtsAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsAmt3 = this.cctOtsAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsCurrCd4 = this.n3ptyCctOtsCurrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsAmt3 = this.totOtsAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsAmt2 = this.cctOtsAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsCurrCd3 = this.n3ptyCctOtsCurrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsAmt1 = this.cctOtsAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctRcvUsrId = this.cctRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctRcvUsrId = this.n3ptyCctRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptStsCd = this.n3ptyPptStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delYdCd = this.delYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collOfcCd = this.collOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.dirDeFlg = this.dirDeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.freeTrdZnFlg = this.freeTrdZnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
