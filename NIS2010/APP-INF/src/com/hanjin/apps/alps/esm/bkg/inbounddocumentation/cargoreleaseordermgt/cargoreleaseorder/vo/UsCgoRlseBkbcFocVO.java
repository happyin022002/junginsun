/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsCgoRlseBkbcFocVO.java
*@FileTitle : UsCgoRlseBkbcFocVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.10.22 박성호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 박성호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsCgoRlseBkbcFocVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsCgoRlseBkbcFocVO> models = new ArrayList<UsCgoRlseBkbcFocVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vskVvdCd = null;
	/* Column Info */
	private String sceMsgId = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String ediSnpRtnVal = null;
	/* Column Info */
	private String newOblRdemFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String sceScsCd = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vslSlanNm = null;
	/* Column Info */
	private String ediRcvId = null;
	/* Column Info */
	private String oldOblRdemFlg = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String vpsEtdDtGmt = null;
	/* Column Info */
	private String ediKnd = null;
	/* Column Info */
	private String ediSnpRcvId = null;
	/* Column Info */
	private String initEtdDtGmt = null;
	/* Column Info */
	private String ibdBkgInd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String initEtaDt = null;
	/* Column Info */
	private String ediMsgId = null;
	/* Column Info */
	private String initEtaDtGmt = null;
	/* Column Info */
	private String ediBlCntrInd = null;
	/* Column Info */
	private String ediSndId = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String newFrtCltFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vpsEtaDtGmt = null;
	/* Column Info */
	private String initEtdDt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String cstmsDspoCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String oldCstmsClrCd = null;
	/* Column Info */
	private String finalEtaDtGmt = null;
	/* Column Info */
	private String poNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ediSnpSndId = null;
	/* Column Info */
	private String ediAddInd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String newCstmsClrCd = null;
	/* Column Info */
	private String finalEtaDt = null;
	/* Column Info */
	private String oldFrtCltFlg = null;
	/* Column Info */
	private String newPodCd = null;
	/* Column Info */
	private String ydCd = null;	
	/* Column Info */
	private String bkgPodYdCd = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsCgoRlseBkbcFocVO() {}

	public UsCgoRlseBkbcFocVO(String ibflag, String pagerows, String blNo, String ediMsgId, String ediRcvId, String ediSndId, String ediKnd, String custCntCd, String custSeq, String custCd, String ediBlCntrInd, String ibdBkgInd, String bkgNo, String vskVvdCd, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String polCd, String podCd, String delCd, String ediSnpSndId, String ediSnpRcvId, String ediAddInd, String vpsEtdDt, String vpsEtdDtGmt, String initEtdDt, String initEtdDtGmt, String vpsEtaDt, String vpsEtaDtGmt, String initEtaDt, String initEtaDtGmt, String finalEtaDt, String finalEtaDtGmt, String oldFrtCltFlg, String oldOblRdemFlg, String oldCstmsClrCd, String newFrtCltFlg, String newOblRdemFlg, String newCstmsClrCd, String poNo, String locCd, String vslSlanNm, String ediSnpRtnVal, String hisSeq, String cstmsDspoCd, String sceMsgId, String sceScsCd, String newPodCd, String ydCd, String bkgPodYdCd) {
		this.vslCd = vslCd;
		this.vskVvdCd = vskVvdCd;
		this.sceMsgId = sceMsgId;
		this.vpsEtaDt = vpsEtaDt;
		this.blNo = blNo;
		this.ediSnpRtnVal = ediSnpRtnVal;
		this.newOblRdemFlg = newOblRdemFlg;
		this.pagerows = pagerows;
		this.vpsPortCd = vpsPortCd;
		this.sceScsCd = sceScsCd;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.vslSlanNm = vslSlanNm;
		this.ediRcvId = ediRcvId;
		this.oldOblRdemFlg = oldOblRdemFlg;
		this.hisSeq = hisSeq;
		this.vpsEtdDtGmt = vpsEtdDtGmt;
		this.ediKnd = ediKnd;
		this.ediSnpRcvId = ediSnpRcvId;
		this.initEtdDtGmt = initEtdDtGmt;
		this.ibdBkgInd = ibdBkgInd;
		this.custCntCd = custCntCd;
		this.initEtaDt = initEtaDt;
		this.ediMsgId = ediMsgId;
		this.initEtaDtGmt = initEtaDtGmt;
		this.ediBlCntrInd = ediBlCntrInd;
		this.ediSndId = ediSndId;
		this.vpsEtdDt = vpsEtdDt;
		this.newFrtCltFlg = newFrtCltFlg;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.vpsEtaDtGmt = vpsEtaDtGmt;
		this.initEtdDt = initEtdDt;
		this.custSeq = custSeq;
		this.cstmsDspoCd = cstmsDspoCd;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.oldCstmsClrCd = oldCstmsClrCd;
		this.finalEtaDtGmt = finalEtaDtGmt;
		this.poNo = poNo;
		this.bkgNo = bkgNo;
		this.ediSnpSndId = ediSnpSndId;
		this.ediAddInd = ediAddInd;
		this.custCd = custCd;
		this.newCstmsClrCd = newCstmsClrCd;
		this.finalEtaDt = finalEtaDt;
		this.oldFrtCltFlg = oldFrtCltFlg;
		this.newPodCd = newPodCd;
		this.ydCd = ydCd;	
		this.bkgPodYdCd = bkgPodYdCd;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vsk_vvd_cd", getVskVvdCd());
		this.hashColumns.put("sce_msg_id", getSceMsgId());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("edi_snp_rtn_val", getEdiSnpRtnVal());
		this.hashColumns.put("new_obl_rdem_flg", getNewOblRdemFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("sce_scs_cd", getSceScsCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vsl_slan_nm", getVslSlanNm());
		this.hashColumns.put("edi_rcv_id", getEdiRcvId());
		this.hashColumns.put("old_obl_rdem_flg", getOldOblRdemFlg());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("vps_etd_dt_gmt", getVpsEtdDtGmt());
		this.hashColumns.put("edi_knd", getEdiKnd());
		this.hashColumns.put("edi_snp_rcv_id", getEdiSnpRcvId());
		this.hashColumns.put("init_etd_dt_gmt", getInitEtdDtGmt());
		this.hashColumns.put("ibd_bkg_ind", getIbdBkgInd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("init_eta_dt", getInitEtaDt());
		this.hashColumns.put("edi_msg_id", getEdiMsgId());
		this.hashColumns.put("init_eta_dt_gmt", getInitEtaDtGmt());
		this.hashColumns.put("edi_bl_cntr_ind", getEdiBlCntrInd());
		this.hashColumns.put("edi_snd_id", getEdiSndId());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("new_frt_clt_flg", getNewFrtCltFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vps_eta_dt_gmt", getVpsEtaDtGmt());
		this.hashColumns.put("init_etd_dt", getInitEtdDt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cstms_dspo_cd", getCstmsDspoCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("old_cstms_clr_cd", getOldCstmsClrCd());
		this.hashColumns.put("final_eta_dt_gmt", getFinalEtaDtGmt());
		this.hashColumns.put("po_no", getPoNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("edi_snp_snd_id", getEdiSnpSndId());
		this.hashColumns.put("edi_add_ind", getEdiAddInd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("new_cstms_clr_cd", getNewCstmsClrCd());
		this.hashColumns.put("final_eta_dt", getFinalEtaDt());
		this.hashColumns.put("old_frt_clt_flg", getOldFrtCltFlg());
		this.hashColumns.put("new_pod_cd", getNewPodCd());
		this.hashColumns.put("yd_cd", getYdCd());		
		this.hashColumns.put("bkg_pod_yd_cd", getBkgPodYdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vsk_vvd_cd", "vskVvdCd");
		this.hashFields.put("sce_msg_id", "sceMsgId");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("edi_snp_rtn_val", "ediSnpRtnVal");
		this.hashFields.put("new_obl_rdem_flg", "newOblRdemFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("sce_scs_cd", "sceScsCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vsl_slan_nm", "vslSlanNm");
		this.hashFields.put("edi_rcv_id", "ediRcvId");
		this.hashFields.put("old_obl_rdem_flg", "oldOblRdemFlg");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("vps_etd_dt_gmt", "vpsEtdDtGmt");
		this.hashFields.put("edi_knd", "ediKnd");
		this.hashFields.put("edi_snp_rcv_id", "ediSnpRcvId");
		this.hashFields.put("init_etd_dt_gmt", "initEtdDtGmt");
		this.hashFields.put("ibd_bkg_ind", "ibdBkgInd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("init_eta_dt", "initEtaDt");
		this.hashFields.put("edi_msg_id", "ediMsgId");
		this.hashFields.put("init_eta_dt_gmt", "initEtaDtGmt");
		this.hashFields.put("edi_bl_cntr_ind", "ediBlCntrInd");
		this.hashFields.put("edi_snd_id", "ediSndId");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("new_frt_clt_flg", "newFrtCltFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vps_eta_dt_gmt", "vpsEtaDtGmt");
		this.hashFields.put("init_etd_dt", "initEtdDt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cstms_dspo_cd", "cstmsDspoCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("old_cstms_clr_cd", "oldCstmsClrCd");
		this.hashFields.put("final_eta_dt_gmt", "finalEtaDtGmt");
		this.hashFields.put("po_no", "poNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("edi_snp_snd_id", "ediSnpSndId");
		this.hashFields.put("edi_add_ind", "ediAddInd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("new_cstms_clr_cd", "newCstmsClrCd");
		this.hashFields.put("final_eta_dt", "finalEtaDt");
		this.hashFields.put("old_frt_clt_flg", "oldFrtCltFlg");
		this.hashFields.put("new_pod_cd", newPodCd);
		this.hashFields.put("yd_cd", "ydCd");		
		this.hashFields.put("bkg_pod_yd_cd", "bkgPodYdCd");
		return this.hashFields;
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
	 * @return vskVvdCd
	 */
	public String getVskVvdCd() {
		return this.vskVvdCd;
	}
	
	/**
	 * Column Info
	 * @return sceMsgId
	 */
	public String getSceMsgId() {
		return this.sceMsgId;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return ediSnpRtnVal
	 */
	public String getEdiSnpRtnVal() {
		return this.ediSnpRtnVal;
	}
	
	/**
	 * Column Info
	 * @return newOblRdemFlg
	 */
	public String getNewOblRdemFlg() {
		return this.newOblRdemFlg;
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
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return sceScsCd
	 */
	public String getSceScsCd() {
		return this.sceScsCd;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return vslSlanNm
	 */
	public String getVslSlanNm() {
		return this.vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @return ediRcvId
	 */
	public String getEdiRcvId() {
		return this.ediRcvId;
	}
	
	/**
	 * Column Info
	 * @return oldOblRdemFlg
	 */
	public String getOldOblRdemFlg() {
		return this.oldOblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @return hisSeq
	 */
	public String getHisSeq() {
		return this.hisSeq;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDtGmt
	 */
	public String getVpsEtdDtGmt() {
		return this.vpsEtdDtGmt;
	}
	
	/**
	 * Column Info
	 * @return ediKnd
	 */
	public String getEdiKnd() {
		return this.ediKnd;
	}
	
	/**
	 * Column Info
	 * @return ediSnpRcvId
	 */
	public String getEdiSnpRcvId() {
		return this.ediSnpRcvId;
	}
	
	/**
	 * Column Info
	 * @return initEtdDtGmt
	 */
	public String getInitEtdDtGmt() {
		return this.initEtdDtGmt;
	}
	
	/**
	 * Column Info
	 * @return ibdBkgInd
	 */
	public String getIbdBkgInd() {
		return this.ibdBkgInd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return initEtaDt
	 */
	public String getInitEtaDt() {
		return this.initEtaDt;
	}
	
	/**
	 * Column Info
	 * @return ediMsgId
	 */
	public String getEdiMsgId() {
		return this.ediMsgId;
	}
	
	/**
	 * Column Info
	 * @return initEtaDtGmt
	 */
	public String getInitEtaDtGmt() {
		return this.initEtaDtGmt;
	}
	
	/**
	 * Column Info
	 * @return ediBlCntrInd
	 */
	public String getEdiBlCntrInd() {
		return this.ediBlCntrInd;
	}
	
	/**
	 * Column Info
	 * @return ediSndId
	 */
	public String getEdiSndId() {
		return this.ediSndId;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return newFrtCltFlg
	 */
	public String getNewFrtCltFlg() {
		return this.newFrtCltFlg;
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
	 * @return vpsEtaDtGmt
	 */
	public String getVpsEtaDtGmt() {
		return this.vpsEtaDtGmt;
	}
	
	/**
	 * Column Info
	 * @return initEtdDt
	 */
	public String getInitEtdDt() {
		return this.initEtdDt;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return cstmsDspoCd
	 */
	public String getCstmsDspoCd() {
		return this.cstmsDspoCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return oldCstmsClrCd
	 */
	public String getOldCstmsClrCd() {
		return this.oldCstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @return finalEtaDtGmt
	 */
	public String getFinalEtaDtGmt() {
		return this.finalEtaDtGmt;
	}
	
	/**
	 * Column Info
	 * @return poNo
	 */
	public String getPoNo() {
		return this.poNo;
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
	 * @return ediSnpSndId
	 */
	public String getEdiSnpSndId() {
		return this.ediSnpSndId;
	}
	
	/**
	 * Column Info
	 * @return ediAddInd
	 */
	public String getEdiAddInd() {
		return this.ediAddInd;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return newCstmsClrCd
	 */
	public String getNewCstmsClrCd() {
		return this.newCstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @return finalEtaDt
	 */
	public String getFinalEtaDt() {
		return this.finalEtaDt;
	}
	
	/**
	 * Column Info
	 * @return oldFrtCltFlg
	 */
	public String getOldFrtCltFlg() {
		return this.oldFrtCltFlg;
	}
	/**
	 * Column Info
	 * @return newPodCd
	 */
	public String getNewPodCd() {
		return this.newPodCd;
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
	 * @return bkgPodYdCd
	 */
	public String getBkgPodYdCd() {
		return this.bkgPodYdCd;
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
	 * @param vskVvdCd
	 */
	public void setVskVvdCd(String vskVvdCd) {
		this.vskVvdCd = vskVvdCd;
	}
	
	/**
	 * Column Info
	 * @param sceMsgId
	 */
	public void setSceMsgId(String sceMsgId) {
		this.sceMsgId = sceMsgId;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param ediSnpRtnVal
	 */
	public void setEdiSnpRtnVal(String ediSnpRtnVal) {
		this.ediSnpRtnVal = ediSnpRtnVal;
	}
	
	/**
	 * Column Info
	 * @param newOblRdemFlg
	 */
	public void setNewOblRdemFlg(String newOblRdemFlg) {
		this.newOblRdemFlg = newOblRdemFlg;
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
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param sceScsCd
	 */
	public void setSceScsCd(String sceScsCd) {
		this.sceScsCd = sceScsCd;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param vslSlanNm
	 */
	public void setVslSlanNm(String vslSlanNm) {
		this.vslSlanNm = vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @param ediRcvId
	 */
	public void setEdiRcvId(String ediRcvId) {
		this.ediRcvId = ediRcvId;
	}
	
	/**
	 * Column Info
	 * @param oldOblRdemFlg
	 */
	public void setOldOblRdemFlg(String oldOblRdemFlg) {
		this.oldOblRdemFlg = oldOblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @param hisSeq
	 */
	public void setHisSeq(String hisSeq) {
		this.hisSeq = hisSeq;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDtGmt
	 */
	public void setVpsEtdDtGmt(String vpsEtdDtGmt) {
		this.vpsEtdDtGmt = vpsEtdDtGmt;
	}
	
	/**
	 * Column Info
	 * @param ediKnd
	 */
	public void setEdiKnd(String ediKnd) {
		this.ediKnd = ediKnd;
	}
	
	/**
	 * Column Info
	 * @param ediSnpRcvId
	 */
	public void setEdiSnpRcvId(String ediSnpRcvId) {
		this.ediSnpRcvId = ediSnpRcvId;
	}
	
	/**
	 * Column Info
	 * @param initEtdDtGmt
	 */
	public void setInitEtdDtGmt(String initEtdDtGmt) {
		this.initEtdDtGmt = initEtdDtGmt;
	}
	
	/**
	 * Column Info
	 * @param ibdBkgInd
	 */
	public void setIbdBkgInd(String ibdBkgInd) {
		this.ibdBkgInd = ibdBkgInd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param initEtaDt
	 */
	public void setInitEtaDt(String initEtaDt) {
		this.initEtaDt = initEtaDt;
	}
	
	/**
	 * Column Info
	 * @param ediMsgId
	 */
	public void setEdiMsgId(String ediMsgId) {
		this.ediMsgId = ediMsgId;
	}
	
	/**
	 * Column Info
	 * @param initEtaDtGmt
	 */
	public void setInitEtaDtGmt(String initEtaDtGmt) {
		this.initEtaDtGmt = initEtaDtGmt;
	}
	
	/**
	 * Column Info
	 * @param ediBlCntrInd
	 */
	public void setEdiBlCntrInd(String ediBlCntrInd) {
		this.ediBlCntrInd = ediBlCntrInd;
	}
	
	/**
	 * Column Info
	 * @param ediSndId
	 */
	public void setEdiSndId(String ediSndId) {
		this.ediSndId = ediSndId;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param newFrtCltFlg
	 */
	public void setNewFrtCltFlg(String newFrtCltFlg) {
		this.newFrtCltFlg = newFrtCltFlg;
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
	 * @param vpsEtaDtGmt
	 */
	public void setVpsEtaDtGmt(String vpsEtaDtGmt) {
		this.vpsEtaDtGmt = vpsEtaDtGmt;
	}
	
	/**
	 * Column Info
	 * @param initEtdDt
	 */
	public void setInitEtdDt(String initEtdDt) {
		this.initEtdDt = initEtdDt;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param cstmsDspoCd
	 */
	public void setCstmsDspoCd(String cstmsDspoCd) {
		this.cstmsDspoCd = cstmsDspoCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param oldCstmsClrCd
	 */
	public void setOldCstmsClrCd(String oldCstmsClrCd) {
		this.oldCstmsClrCd = oldCstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @param finalEtaDtGmt
	 */
	public void setFinalEtaDtGmt(String finalEtaDtGmt) {
		this.finalEtaDtGmt = finalEtaDtGmt;
	}
	
	/**
	 * Column Info
	 * @param poNo
	 */
	public void setPoNo(String poNo) {
		this.poNo = poNo;
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
	 * @param ediSnpSndId
	 */
	public void setEdiSnpSndId(String ediSnpSndId) {
		this.ediSnpSndId = ediSnpSndId;
	}
	
	/**
	 * Column Info
	 * @param ediAddInd
	 */
	public void setEdiAddInd(String ediAddInd) {
		this.ediAddInd = ediAddInd;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param newCstmsClrCd
	 */
	public void setNewCstmsClrCd(String newCstmsClrCd) {
		this.newCstmsClrCd = newCstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @param finalEtaDt
	 */
	public void setFinalEtaDt(String finalEtaDt) {
		this.finalEtaDt = finalEtaDt;
	}
	
	/**
	 * Column Info
	 * @param oldFrtCltFlg
	 */
	public void setOldFrtCltFlg(String oldFrtCltFlg) {
		this.oldFrtCltFlg = oldFrtCltFlg;
	}
	
	/**
	 * Column Info
	 * @param newPodCd
	 */
	public void setNewPodCd(String newPodCd) {
		this.newPodCd = newPodCd;
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
	 * @param bkgPodYdCd
	 */
	public void setBkgPodYdCd(String bkgPodYdCd) {
		this.bkgPodYdCd = bkgPodYdCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVskVvdCd(JSPUtil.getParameter(request, "vsk_vvd_cd", ""));
		setSceMsgId(JSPUtil.getParameter(request, "sce_msg_id", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setEdiSnpRtnVal(JSPUtil.getParameter(request, "edi_snp_rtn_val", ""));
		setNewOblRdemFlg(JSPUtil.getParameter(request, "new_obl_rdem_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setSceScsCd(JSPUtil.getParameter(request, "sce_scs_cd", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setVslSlanNm(JSPUtil.getParameter(request, "vsl_slan_nm", ""));
		setEdiRcvId(JSPUtil.getParameter(request, "edi_rcv_id", ""));
		setOldOblRdemFlg(JSPUtil.getParameter(request, "old_obl_rdem_flg", ""));
		setHisSeq(JSPUtil.getParameter(request, "his_seq", ""));
		setVpsEtdDtGmt(JSPUtil.getParameter(request, "vps_etd_dt_gmt", ""));
		setEdiKnd(JSPUtil.getParameter(request, "edi_knd", ""));
		setEdiSnpRcvId(JSPUtil.getParameter(request, "edi_snp_rcv_id", ""));
		setInitEtdDtGmt(JSPUtil.getParameter(request, "init_etd_dt_gmt", ""));
		setIbdBkgInd(JSPUtil.getParameter(request, "ibd_bkg_ind", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setInitEtaDt(JSPUtil.getParameter(request, "init_eta_dt", ""));
		setEdiMsgId(JSPUtil.getParameter(request, "edi_msg_id", ""));
		setInitEtaDtGmt(JSPUtil.getParameter(request, "init_eta_dt_gmt", ""));
		setEdiBlCntrInd(JSPUtil.getParameter(request, "edi_bl_cntr_ind", ""));
		setEdiSndId(JSPUtil.getParameter(request, "edi_snd_id", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setNewFrtCltFlg(JSPUtil.getParameter(request, "new_frt_clt_flg", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVpsEtaDtGmt(JSPUtil.getParameter(request, "vps_eta_dt_gmt", ""));
		setInitEtdDt(JSPUtil.getParameter(request, "init_etd_dt", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCstmsDspoCd(JSPUtil.getParameter(request, "cstms_dspo_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setOldCstmsClrCd(JSPUtil.getParameter(request, "old_cstms_clr_cd", ""));
		setFinalEtaDtGmt(JSPUtil.getParameter(request, "final_eta_dt_gmt", ""));
		setPoNo(JSPUtil.getParameter(request, "po_no", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setEdiSnpSndId(JSPUtil.getParameter(request, "edi_snp_snd_id", ""));
		setEdiAddInd(JSPUtil.getParameter(request, "edi_add_ind", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setNewCstmsClrCd(JSPUtil.getParameter(request, "new_cstms_clr_cd", ""));
		setFinalEtaDt(JSPUtil.getParameter(request, "final_eta_dt", ""));
		setOldFrtCltFlg(JSPUtil.getParameter(request, "old_frt_clt_flg", ""));
		setNewPodCd(JSPUtil.getParameter(request, "new_pod_cd", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));		
		setBkgPodYdCd(JSPUtil.getParameter(request, "bkg_pod_yd_cd", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsCgoRlseBkbcFocVO[]
	 */
	public UsCgoRlseBkbcFocVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsCgoRlseBkbcFocVO[]
	 */
	public UsCgoRlseBkbcFocVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsCgoRlseBkbcFocVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vskVvdCd = (JSPUtil.getParameter(request, prefix	+ "vsk_vvd_cd", length));
			String[] sceMsgId = (JSPUtil.getParameter(request, prefix	+ "sce_msg_id", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] ediSnpRtnVal = (JSPUtil.getParameter(request, prefix	+ "edi_snp_rtn_val", length));
			String[] newOblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "new_obl_rdem_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] sceScsCd = (JSPUtil.getParameter(request, prefix	+ "sce_scs_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vslSlanNm = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_nm", length));
			String[] ediRcvId = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_id", length));
			String[] oldOblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "old_obl_rdem_flg", length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq", length));
			String[] vpsEtdDtGmt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt_gmt", length));
			String[] ediKnd = (JSPUtil.getParameter(request, prefix	+ "edi_knd", length));
			String[] ediSnpRcvId = (JSPUtil.getParameter(request, prefix	+ "edi_snp_rcv_id", length));
			String[] initEtdDtGmt = (JSPUtil.getParameter(request, prefix	+ "init_etd_dt_gmt", length));
			String[] ibdBkgInd = (JSPUtil.getParameter(request, prefix	+ "ibd_bkg_ind", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] initEtaDt = (JSPUtil.getParameter(request, prefix	+ "init_eta_dt", length));
			String[] ediMsgId = (JSPUtil.getParameter(request, prefix	+ "edi_msg_id", length));
			String[] initEtaDtGmt = (JSPUtil.getParameter(request, prefix	+ "init_eta_dt_gmt", length));
			String[] ediBlCntrInd = (JSPUtil.getParameter(request, prefix	+ "edi_bl_cntr_ind", length));
			String[] ediSndId = (JSPUtil.getParameter(request, prefix	+ "edi_snd_id", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] newFrtCltFlg = (JSPUtil.getParameter(request, prefix	+ "new_frt_clt_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vpsEtaDtGmt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt_gmt", length));
			String[] initEtdDt = (JSPUtil.getParameter(request, prefix	+ "init_etd_dt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] cstmsDspoCd = (JSPUtil.getParameter(request, prefix	+ "cstms_dspo_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] oldCstmsClrCd = (JSPUtil.getParameter(request, prefix	+ "old_cstms_clr_cd", length));
			String[] finalEtaDtGmt = (JSPUtil.getParameter(request, prefix	+ "final_eta_dt_gmt", length));
			String[] poNo = (JSPUtil.getParameter(request, prefix	+ "po_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ediSnpSndId = (JSPUtil.getParameter(request, prefix	+ "edi_snp_snd_id", length));
			String[] ediAddInd = (JSPUtil.getParameter(request, prefix	+ "edi_add_ind", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] newCstmsClrCd = (JSPUtil.getParameter(request, prefix	+ "new_cstms_clr_cd", length));
			String[] finalEtaDt = (JSPUtil.getParameter(request, prefix	+ "final_eta_dt", length));
			String[] oldFrtCltFlg = (JSPUtil.getParameter(request, prefix	+ "old_frt_clt_flg", length));
			String[] newPodCd = (JSPUtil.getParameter(request, prefix	+ "new_pod_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] bkgPodYdCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_yd_cd", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new UsCgoRlseBkbcFocVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vskVvdCd[i] != null)
					model.setVskVvdCd(vskVvdCd[i]);
				if (sceMsgId[i] != null)
					model.setSceMsgId(sceMsgId[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (ediSnpRtnVal[i] != null)
					model.setEdiSnpRtnVal(ediSnpRtnVal[i]);
				if (newOblRdemFlg[i] != null)
					model.setNewOblRdemFlg(newOblRdemFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (sceScsCd[i] != null)
					model.setSceScsCd(sceScsCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vslSlanNm[i] != null)
					model.setVslSlanNm(vslSlanNm[i]);
				if (ediRcvId[i] != null)
					model.setEdiRcvId(ediRcvId[i]);
				if (oldOblRdemFlg[i] != null)
					model.setOldOblRdemFlg(oldOblRdemFlg[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (vpsEtdDtGmt[i] != null)
					model.setVpsEtdDtGmt(vpsEtdDtGmt[i]);
				if (ediKnd[i] != null)
					model.setEdiKnd(ediKnd[i]);
				if (ediSnpRcvId[i] != null)
					model.setEdiSnpRcvId(ediSnpRcvId[i]);
				if (initEtdDtGmt[i] != null)
					model.setInitEtdDtGmt(initEtdDtGmt[i]);
				if (ibdBkgInd[i] != null)
					model.setIbdBkgInd(ibdBkgInd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (initEtaDt[i] != null)
					model.setInitEtaDt(initEtaDt[i]);
				if (ediMsgId[i] != null)
					model.setEdiMsgId(ediMsgId[i]);
				if (initEtaDtGmt[i] != null)
					model.setInitEtaDtGmt(initEtaDtGmt[i]);
				if (ediBlCntrInd[i] != null)
					model.setEdiBlCntrInd(ediBlCntrInd[i]);
				if (ediSndId[i] != null)
					model.setEdiSndId(ediSndId[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (newFrtCltFlg[i] != null)
					model.setNewFrtCltFlg(newFrtCltFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vpsEtaDtGmt[i] != null)
					model.setVpsEtaDtGmt(vpsEtaDtGmt[i]);
				if (initEtdDt[i] != null)
					model.setInitEtdDt(initEtdDt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (cstmsDspoCd[i] != null)
					model.setCstmsDspoCd(cstmsDspoCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (oldCstmsClrCd[i] != null)
					model.setOldCstmsClrCd(oldCstmsClrCd[i]);
				if (finalEtaDtGmt[i] != null)
					model.setFinalEtaDtGmt(finalEtaDtGmt[i]);
				if (poNo[i] != null)
					model.setPoNo(poNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ediSnpSndId[i] != null)
					model.setEdiSnpSndId(ediSnpSndId[i]);
				if (ediAddInd[i] != null)
					model.setEdiAddInd(ediAddInd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (newCstmsClrCd[i] != null)
					model.setNewCstmsClrCd(newCstmsClrCd[i]);
				if (finalEtaDt[i] != null)
					model.setFinalEtaDt(finalEtaDt[i]);
				if (oldFrtCltFlg[i] != null)
					model.setOldFrtCltFlg(oldFrtCltFlg[i]);
				if (newPodCd[i] != null)
					model.setNewPodCd(newPodCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);				
				if (bkgPodYdCd[i] != null)
					model.setBkgPodYdCd(bkgPodYdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsCgoRlseBkbcFocVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsCgoRlseBkbcFocVO[]
	 */
	public UsCgoRlseBkbcFocVO[] getUsCgoRlseBkbcFocVOs(){
		UsCgoRlseBkbcFocVO[] vos = (UsCgoRlseBkbcFocVO[])models.toArray(new UsCgoRlseBkbcFocVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vskVvdCd = this.vskVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sceMsgId = this.sceMsgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSnpRtnVal = this.ediSnpRtnVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newOblRdemFlg = this.newOblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sceScsCd = this.sceScsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanNm = this.vslSlanNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvId = this.ediRcvId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldOblRdemFlg = this.oldOblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDtGmt = this.vpsEtdDtGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediKnd = this.ediKnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSnpRcvId = this.ediSnpRcvId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtdDtGmt = this.initEtdDtGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdBkgInd = this.ibdBkgInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtaDt = this.initEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsgId = this.ediMsgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtaDtGmt = this.initEtaDtGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediBlCntrInd = this.ediBlCntrInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndId = this.ediSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newFrtCltFlg = this.newFrtCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDtGmt = this.vpsEtaDtGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtdDt = this.initEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDspoCd = this.cstmsDspoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCstmsClrCd = this.oldCstmsClrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalEtaDtGmt = this.finalEtaDtGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poNo = this.poNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSnpSndId = this.ediSnpSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediAddInd = this.ediAddInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCstmsClrCd = this.newCstmsClrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalEtaDt = this.finalEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldFrtCltFlg = this.oldFrtCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPodCd = this.newPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.bkgPodYdCd = this.bkgPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
	}
}
