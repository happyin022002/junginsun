/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MndVO.java
*@FileTitle : MndVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

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

public class MndVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MndVO> models = new ArrayList<MndVO>();
	
	/* Column Info */
	private String cntrDesc = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String pckCmdtDesc = null;
	/* Column Info */
	private String mfDescPrnFlg = null;
	/* Column Info */
	private String dgCmdtDesc = null;
	/* Column Info */
	private String bkgRefTpMlCd = null;
	/* Column Info */
	private String actWgt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String poMrnUcrCntrFlg = null;
	/* Column Info */
	private String cntrCmdtDesc = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String tVvd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String mkDescPrnFlg = null;
	/* Column Info */
	private String cntrWgtPrnFlg = null;
	/* Column Info */
	private String cntrMeasPrnFlg = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String cstmsClrCd = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String frtTermPrnFlg = null;
	/* Column Info */
	private String xptImpSeq = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String imgFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String measQtyPrnFlg = null;
	/* Column Info */
	private String poCustFlag = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String poRefFlag = null;
	/* Column Info */
	private String mkDesc = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String ttlPckDesc = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String actWgtPrnFlg = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String rPoOtherMdtItm = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String oblIssFlg = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String frtPayOfcPrnFlg = null;
	/* Column Info */
	private String pckNm = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String poRefDtlFlag = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String pckQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MndVO() {}

	public MndVO(String ibflag, String pagerows, String porCd, String vslCd, String bdrFlg, String bkgStsCd, String pckNm, String xptImpSeq, String poRefFlag, String mkDesc, String blNo, String poCustFlag, String polCd, String tVvd, String dgCmdtDesc, String cmdtCd, String cntrCmdtDesc, String cstmsDesc, String actWgtPrnFlg, String measQty, String wgtUtCd, String pckQty, String ttlPckDesc, String rcvTermCd, String measUtCd, String pckTpCd, String updUsrId, String frtTermPrnFlg, String cstmsClrCd, String oblIssFlg, String frtTermCd, String delCd, String skdVoyNo, String skdDirCd, String blTpCd, String actWgt, String podCd, String deTermCd, String creUsrId, String bkgNo, String cntrDesc, String cmdtDesc, String poRefDtlFlag, String pckCmdtDesc, String rcFlg, String repCmdtCd, String imgFlg, String rPoOtherMdtItm, String bkgRefTpMlCd, String poMrnUcrCntrFlg, String measQtyPrnFlg, String cntrWgtPrnFlg, String cntrMeasPrnFlg, String mkDescPrnFlg, String mfDescPrnFlg, String frtPayOfcPrnFlg) {
		this.cntrDesc = cntrDesc;
		this.rcFlg = rcFlg;
		this.blNo = blNo;
		this.bkgNo = bkgNo;
		this.updUsrId = updUsrId;
		this.pckCmdtDesc = pckCmdtDesc;
		this.mfDescPrnFlg = mfDescPrnFlg;
		this.dgCmdtDesc = dgCmdtDesc;
		this.bkgRefTpMlCd = bkgRefTpMlCd;
		this.actWgt = actWgt;
		this.pagerows = pagerows;
		this.bdrFlg = bdrFlg;
		this.poMrnUcrCntrFlg = poMrnUcrCntrFlg;
		this.cntrCmdtDesc = cntrCmdtDesc;
		this.vslCd = vslCd;
		this.tVvd = tVvd;
		this.deTermCd = deTermCd;
		this.mkDescPrnFlg = mkDescPrnFlg;
		this.cntrWgtPrnFlg = cntrWgtPrnFlg;
		this.cntrMeasPrnFlg = cntrMeasPrnFlg;
		this.blTpCd = blTpCd;
		this.cstmsClrCd = cstmsClrCd;
		this.cstmsDesc = cstmsDesc;
		this.frtTermPrnFlg = frtTermPrnFlg;
		this.xptImpSeq = xptImpSeq;
		this.pckTpCd = pckTpCd;
		this.imgFlg = imgFlg;
		this.ibflag = ibflag;
		this.measQtyPrnFlg = measQtyPrnFlg;
		this.poCustFlag = poCustFlag;
		this.porCd = porCd;
		this.poRefFlag = poRefFlag;
		this.mkDesc = mkDesc;
		this.frtTermCd = frtTermCd;
		this.creUsrId = creUsrId;
		this.polCd = polCd;
		this.ttlPckDesc = ttlPckDesc;
		this.skdDirCd = skdDirCd;
		this.actWgtPrnFlg = actWgtPrnFlg;
		this.podCd = podCd;
		this.rPoOtherMdtItm = rPoOtherMdtItm;
		this.measQty = measQty;
		this.skdVoyNo = skdVoyNo;
		this.cmdtCd = cmdtCd;
		this.cmdtDesc = cmdtDesc;
		this.oblIssFlg = oblIssFlg;
		this.bkgStsCd = bkgStsCd;
		this.frtPayOfcPrnFlg = frtPayOfcPrnFlg;
		this.pckNm = pckNm;
		this.measUtCd = measUtCd;
		this.repCmdtCd = repCmdtCd;
		this.wgtUtCd = wgtUtCd;
		this.poRefDtlFlag = poRefDtlFlag;
		this.rcvTermCd = rcvTermCd;
		this.delCd = delCd;
		this.pckQty = pckQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_desc", getCntrDesc());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pck_cmdt_desc", getPckCmdtDesc());
		this.hashColumns.put("mf_desc_prn_flg", getMfDescPrnFlg());
		this.hashColumns.put("dg_cmdt_desc", getDgCmdtDesc());
		this.hashColumns.put("bkg_ref_tp_ml_cd", getBkgRefTpMlCd());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("po_mrn_ucr_cntr_flg", getPoMrnUcrCntrFlg());
		this.hashColumns.put("cntr_cmdt_desc", getCntrCmdtDesc());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("mk_desc_prn_flg", getMkDescPrnFlg());
		this.hashColumns.put("cntr_wgt_prn_flg", getCntrWgtPrnFlg());
		this.hashColumns.put("cntr_meas_prn_flg", getCntrMeasPrnFlg());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("cstms_clr_cd", getCstmsClrCd());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("frt_term_prn_flg", getFrtTermPrnFlg());
		this.hashColumns.put("xpt_imp_seq", getXptImpSeq());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("img_flg", getImgFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("meas_qty_prn_flg", getMeasQtyPrnFlg());
		this.hashColumns.put("po_cust_flag", getPoCustFlag());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("po_ref_flag", getPoRefFlag());
		this.hashColumns.put("mk_desc", getMkDesc());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ttl_pck_desc", getTtlPckDesc());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("act_wgt_prn_flg", getActWgtPrnFlg());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("r_po_other_mdt_itm", getRPoOtherMdtItm());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("obl_iss_flg", getOblIssFlg());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("frt_pay_ofc_prn_flg", getFrtPayOfcPrnFlg());
		this.hashColumns.put("pck_nm", getPckNm());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("po_ref_dtl_flag", getPoRefDtlFlag());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pck_qty", getPckQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_desc", "cntrDesc");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pck_cmdt_desc", "pckCmdtDesc");
		this.hashFields.put("mf_desc_prn_flg", "mfDescPrnFlg");
		this.hashFields.put("dg_cmdt_desc", "dgCmdtDesc");
		this.hashFields.put("bkg_ref_tp_ml_cd", "bkgRefTpMlCd");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("po_mrn_ucr_cntr_flg", "poMrnUcrCntrFlg");
		this.hashFields.put("cntr_cmdt_desc", "cntrCmdtDesc");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("mk_desc_prn_flg", "mkDescPrnFlg");
		this.hashFields.put("cntr_wgt_prn_flg", "cntrWgtPrnFlg");
		this.hashFields.put("cntr_meas_prn_flg", "cntrMeasPrnFlg");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("cstms_clr_cd", "cstmsClrCd");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("frt_term_prn_flg", "frtTermPrnFlg");
		this.hashFields.put("xpt_imp_seq", "xptImpSeq");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("img_flg", "imgFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("meas_qty_prn_flg", "measQtyPrnFlg");
		this.hashFields.put("po_cust_flag", "poCustFlag");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("po_ref_flag", "poRefFlag");
		this.hashFields.put("mk_desc", "mkDesc");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ttl_pck_desc", "ttlPckDesc");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("act_wgt_prn_flg", "actWgtPrnFlg");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("r_po_other_mdt_itm", "rPoOtherMdtItm");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("obl_iss_flg", "oblIssFlg");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("frt_pay_ofc_prn_flg", "frtPayOfcPrnFlg");
		this.hashFields.put("pck_nm", "pckNm");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("po_ref_dtl_flag", "poRefDtlFlag");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pck_qty", "pckQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrDesc
	 */
	public String getCntrDesc() {
		return this.cntrDesc;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return pckCmdtDesc
	 */
	public String getPckCmdtDesc() {
		return this.pckCmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return mfDescPrnFlg
	 */
	public String getMfDescPrnFlg() {
		return this.mfDescPrnFlg;
	}
	
	/**
	 * Column Info
	 * @return dgCmdtDesc
	 */
	public String getDgCmdtDesc() {
		return this.dgCmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return bkgRefTpMlCd
	 */
	public String getBkgRefTpMlCd() {
		return this.bkgRefTpMlCd;
	}
	
	/**
	 * Column Info
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
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
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return poMrnUcrCntrFlg
	 */
	public String getPoMrnUcrCntrFlg() {
		return this.poMrnUcrCntrFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrCmdtDesc
	 */
	public String getCntrCmdtDesc() {
		return this.cntrCmdtDesc;
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
	 * @return tVvd
	 */
	public String getTVvd() {
		return this.tVvd;
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
	 * @return mkDescPrnFlg
	 */
	public String getMkDescPrnFlg() {
		return this.mkDescPrnFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrWgtPrnFlg
	 */
	public String getCntrWgtPrnFlg() {
		return this.cntrWgtPrnFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrMeasPrnFlg
	 */
	public String getCntrMeasPrnFlg() {
		return this.cntrMeasPrnFlg;
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
	 * @return cstmsClrCd
	 */
	public String getCstmsClrCd() {
		return this.cstmsClrCd;
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
	 * @return frtTermPrnFlg
	 */
	public String getFrtTermPrnFlg() {
		return this.frtTermPrnFlg;
	}
	
	/**
	 * Column Info
	 * @return xptImpSeq
	 */
	public String getXptImpSeq() {
		return this.xptImpSeq;
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
	 * @return imgFlg
	 */
	public String getImgFlg() {
		return this.imgFlg;
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
	 * @return measQtyPrnFlg
	 */
	public String getMeasQtyPrnFlg() {
		return this.measQtyPrnFlg;
	}
	
	/**
	 * Column Info
	 * @return poCustFlag
	 */
	public String getPoCustFlag() {
		return this.poCustFlag;
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
	 * @return poRefFlag
	 */
	public String getPoRefFlag() {
		return this.poRefFlag;
	}
	
	/**
	 * Column Info
	 * @return mkDesc
	 */
	public String getMkDesc() {
		return this.mkDesc;
	}
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return ttlPckDesc
	 */
	public String getTtlPckDesc() {
		return this.ttlPckDesc;
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
	 * @return actWgtPrnFlg
	 */
	public String getActWgtPrnFlg() {
		return this.actWgtPrnFlg;
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
	 * @return rPoOtherMdtItm
	 */
	public String getRPoOtherMdtItm() {
		return this.rPoOtherMdtItm;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
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
	 * @return oblIssFlg
	 */
	public String getOblIssFlg() {
		return this.oblIssFlg;
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
	 * @return frtPayOfcPrnFlg
	 */
	public String getFrtPayOfcPrnFlg() {
		return this.frtPayOfcPrnFlg;
	}
	
	/**
	 * Column Info
	 * @return pckNm
	 */
	public String getPckNm() {
		return this.pckNm;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	
	/**
	 * Column Info
	 * @return repCmdtCd
	 */
	public String getRepCmdtCd() {
		return this.repCmdtCd;
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
	 * @return poRefDtlFlag
	 */
	public String getPoRefDtlFlag() {
		return this.poRefDtlFlag;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @param cntrDesc
	 */
	public void setCntrDesc(String cntrDesc) {
		this.cntrDesc = cntrDesc;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param pckCmdtDesc
	 */
	public void setPckCmdtDesc(String pckCmdtDesc) {
		this.pckCmdtDesc = pckCmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param mfDescPrnFlg
	 */
	public void setMfDescPrnFlg(String mfDescPrnFlg) {
		this.mfDescPrnFlg = mfDescPrnFlg;
	}
	
	/**
	 * Column Info
	 * @param dgCmdtDesc
	 */
	public void setDgCmdtDesc(String dgCmdtDesc) {
		this.dgCmdtDesc = dgCmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param bkgRefTpMlCd
	 */
	public void setBkgRefTpMlCd(String bkgRefTpMlCd) {
		this.bkgRefTpMlCd = bkgRefTpMlCd;
	}
	
	/**
	 * Column Info
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
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
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param poMrnUcrCntrFlg
	 */
	public void setPoMrnUcrCntrFlg(String poMrnUcrCntrFlg) {
		this.poMrnUcrCntrFlg = poMrnUcrCntrFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrCmdtDesc
	 */
	public void setCntrCmdtDesc(String cntrCmdtDesc) {
		this.cntrCmdtDesc = cntrCmdtDesc;
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
	 * @param tVvd
	 */
	public void setTVvd(String tVvd) {
		this.tVvd = tVvd;
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
	 * @param mkDescPrnFlg
	 */
	public void setMkDescPrnFlg(String mkDescPrnFlg) {
		this.mkDescPrnFlg = mkDescPrnFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrWgtPrnFlg
	 */
	public void setCntrWgtPrnFlg(String cntrWgtPrnFlg) {
		this.cntrWgtPrnFlg = cntrWgtPrnFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrMeasPrnFlg
	 */
	public void setCntrMeasPrnFlg(String cntrMeasPrnFlg) {
		this.cntrMeasPrnFlg = cntrMeasPrnFlg;
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
	 * @param cstmsClrCd
	 */
	public void setCstmsClrCd(String cstmsClrCd) {
		this.cstmsClrCd = cstmsClrCd;
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
	 * @param frtTermPrnFlg
	 */
	public void setFrtTermPrnFlg(String frtTermPrnFlg) {
		this.frtTermPrnFlg = frtTermPrnFlg;
	}
	
	/**
	 * Column Info
	 * @param xptImpSeq
	 */
	public void setXptImpSeq(String xptImpSeq) {
		this.xptImpSeq = xptImpSeq;
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
	 * @param imgFlg
	 */
	public void setImgFlg(String imgFlg) {
		this.imgFlg = imgFlg;
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
	 * @param measQtyPrnFlg
	 */
	public void setMeasQtyPrnFlg(String measQtyPrnFlg) {
		this.measQtyPrnFlg = measQtyPrnFlg;
	}
	
	/**
	 * Column Info
	 * @param poCustFlag
	 */
	public void setPoCustFlag(String poCustFlag) {
		this.poCustFlag = poCustFlag;
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
	 * @param poRefFlag
	 */
	public void setPoRefFlag(String poRefFlag) {
		this.poRefFlag = poRefFlag;
	}
	
	/**
	 * Column Info
	 * @param mkDesc
	 */
	public void setMkDesc(String mkDesc) {
		this.mkDesc = mkDesc;
	}
	
	/**
	 * Column Info
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param ttlPckDesc
	 */
	public void setTtlPckDesc(String ttlPckDesc) {
		this.ttlPckDesc = ttlPckDesc;
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
	 * @param actWgtPrnFlg
	 */
	public void setActWgtPrnFlg(String actWgtPrnFlg) {
		this.actWgtPrnFlg = actWgtPrnFlg;
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
	 * @param rPoOtherMdtItm
	 */
	public void setRPoOtherMdtItm(String rPoOtherMdtItm) {
		this.rPoOtherMdtItm = rPoOtherMdtItm;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
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
	 * @param oblIssFlg
	 */
	public void setOblIssFlg(String oblIssFlg) {
		this.oblIssFlg = oblIssFlg;
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
	 * @param frtPayOfcPrnFlg
	 */
	public void setFrtPayOfcPrnFlg(String frtPayOfcPrnFlg) {
		this.frtPayOfcPrnFlg = frtPayOfcPrnFlg;
	}
	
	/**
	 * Column Info
	 * @param pckNm
	 */
	public void setPckNm(String pckNm) {
		this.pckNm = pckNm;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
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
	 * @param poRefDtlFlag
	 */
	public void setPoRefDtlFlag(String poRefDtlFlag) {
		this.poRefDtlFlag = poRefDtlFlag;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
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
		setCntrDesc(JSPUtil.getParameter(request, prefix + "cntr_desc", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPckCmdtDesc(JSPUtil.getParameter(request, prefix + "pck_cmdt_desc", ""));
		setMfDescPrnFlg(JSPUtil.getParameter(request, prefix + "mf_desc_prn_flg", ""));
		setDgCmdtDesc(JSPUtil.getParameter(request, prefix + "dg_cmdt_desc", ""));
		setBkgRefTpMlCd(JSPUtil.getParameter(request, prefix + "bkg_ref_tp_ml_cd", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setPoMrnUcrCntrFlg(JSPUtil.getParameter(request, prefix + "po_mrn_ucr_cntr_flg", ""));
		setCntrCmdtDesc(JSPUtil.getParameter(request, prefix + "cntr_cmdt_desc", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setTVvd(JSPUtil.getParameter(request, prefix + "t_vvd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setMkDescPrnFlg(JSPUtil.getParameter(request, prefix + "mk_desc_prn_flg", ""));
		setCntrWgtPrnFlg(JSPUtil.getParameter(request, prefix + "cntr_wgt_prn_flg", ""));
		setCntrMeasPrnFlg(JSPUtil.getParameter(request, prefix + "cntr_meas_prn_flg", ""));
		setBlTpCd(JSPUtil.getParameter(request, prefix + "bl_tp_cd", ""));
		setCstmsClrCd(JSPUtil.getParameter(request, prefix + "cstms_clr_cd", ""));
		setCstmsDesc(JSPUtil.getParameter(request, prefix + "cstms_desc", ""));
		setFrtTermPrnFlg(JSPUtil.getParameter(request, prefix + "frt_term_prn_flg", ""));
		setXptImpSeq(JSPUtil.getParameter(request, prefix + "xpt_imp_seq", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setImgFlg(JSPUtil.getParameter(request, prefix + "img_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMeasQtyPrnFlg(JSPUtil.getParameter(request, prefix + "meas_qty_prn_flg", ""));
		setPoCustFlag(JSPUtil.getParameter(request, prefix + "po_cust_flag", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setPoRefFlag(JSPUtil.getParameter(request, prefix + "po_ref_flag", ""));
		setMkDesc(JSPUtil.getParameter(request, prefix + "mk_desc", ""));
		setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setTtlPckDesc(JSPUtil.getParameter(request, prefix + "ttl_pck_desc", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setActWgtPrnFlg(JSPUtil.getParameter(request, prefix + "act_wgt_prn_flg", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setRPoOtherMdtItm(JSPUtil.getParameter(request, prefix + "r_po_other_mdt_itm", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setOblIssFlg(JSPUtil.getParameter(request, prefix + "obl_iss_flg", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setFrtPayOfcPrnFlg(JSPUtil.getParameter(request, prefix + "frt_pay_ofc_prn_flg", ""));
		setPckNm(JSPUtil.getParameter(request, prefix + "pck_nm", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setPoRefDtlFlag(JSPUtil.getParameter(request, prefix + "po_ref_dtl_flag", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MndVO[]
	 */
	public MndVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MndVO[]
	 */
	public MndVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MndVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_desc", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pckCmdtDesc = (JSPUtil.getParameter(request, prefix	+ "pck_cmdt_desc", length));
			String[] mfDescPrnFlg = (JSPUtil.getParameter(request, prefix	+ "mf_desc_prn_flg", length));
			String[] dgCmdtDesc = (JSPUtil.getParameter(request, prefix	+ "dg_cmdt_desc", length));
			String[] bkgRefTpMlCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ref_tp_ml_cd", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] poMrnUcrCntrFlg = (JSPUtil.getParameter(request, prefix	+ "po_mrn_ucr_cntr_flg", length));
			String[] cntrCmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_cmdt_desc", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix	+ "t_vvd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] mkDescPrnFlg = (JSPUtil.getParameter(request, prefix	+ "mk_desc_prn_flg", length));
			String[] cntrWgtPrnFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt_prn_flg", length));
			String[] cntrMeasPrnFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_meas_prn_flg", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] cstmsClrCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_cd", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] frtTermPrnFlg = (JSPUtil.getParameter(request, prefix	+ "frt_term_prn_flg", length));
			String[] xptImpSeq = (JSPUtil.getParameter(request, prefix	+ "xpt_imp_seq", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] imgFlg = (JSPUtil.getParameter(request, prefix	+ "img_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] measQtyPrnFlg = (JSPUtil.getParameter(request, prefix	+ "meas_qty_prn_flg", length));
			String[] poCustFlag = (JSPUtil.getParameter(request, prefix	+ "po_cust_flag", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] poRefFlag = (JSPUtil.getParameter(request, prefix	+ "po_ref_flag", length));
			String[] mkDesc = (JSPUtil.getParameter(request, prefix	+ "mk_desc", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ttlPckDesc = (JSPUtil.getParameter(request, prefix	+ "ttl_pck_desc", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] actWgtPrnFlg = (JSPUtil.getParameter(request, prefix	+ "act_wgt_prn_flg", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] rPoOtherMdtItm = (JSPUtil.getParameter(request, prefix	+ "r_po_other_mdt_itm", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] oblIssFlg = (JSPUtil.getParameter(request, prefix	+ "obl_iss_flg", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] frtPayOfcPrnFlg = (JSPUtil.getParameter(request, prefix	+ "frt_pay_ofc_prn_flg", length));
			String[] pckNm = (JSPUtil.getParameter(request, prefix	+ "pck_nm", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] poRefDtlFlag = (JSPUtil.getParameter(request, prefix	+ "po_ref_dtl_flag", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new MndVO();
				if (cntrDesc[i] != null)
					model.setCntrDesc(cntrDesc[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pckCmdtDesc[i] != null)
					model.setPckCmdtDesc(pckCmdtDesc[i]);
				if (mfDescPrnFlg[i] != null)
					model.setMfDescPrnFlg(mfDescPrnFlg[i]);
				if (dgCmdtDesc[i] != null)
					model.setDgCmdtDesc(dgCmdtDesc[i]);
				if (bkgRefTpMlCd[i] != null)
					model.setBkgRefTpMlCd(bkgRefTpMlCd[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (poMrnUcrCntrFlg[i] != null)
					model.setPoMrnUcrCntrFlg(poMrnUcrCntrFlg[i]);
				if (cntrCmdtDesc[i] != null)
					model.setCntrCmdtDesc(cntrCmdtDesc[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (mkDescPrnFlg[i] != null)
					model.setMkDescPrnFlg(mkDescPrnFlg[i]);
				if (cntrWgtPrnFlg[i] != null)
					model.setCntrWgtPrnFlg(cntrWgtPrnFlg[i]);
				if (cntrMeasPrnFlg[i] != null)
					model.setCntrMeasPrnFlg(cntrMeasPrnFlg[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (cstmsClrCd[i] != null)
					model.setCstmsClrCd(cstmsClrCd[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (frtTermPrnFlg[i] != null)
					model.setFrtTermPrnFlg(frtTermPrnFlg[i]);
				if (xptImpSeq[i] != null)
					model.setXptImpSeq(xptImpSeq[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (imgFlg[i] != null)
					model.setImgFlg(imgFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (measQtyPrnFlg[i] != null)
					model.setMeasQtyPrnFlg(measQtyPrnFlg[i]);
				if (poCustFlag[i] != null)
					model.setPoCustFlag(poCustFlag[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (poRefFlag[i] != null)
					model.setPoRefFlag(poRefFlag[i]);
				if (mkDesc[i] != null)
					model.setMkDesc(mkDesc[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ttlPckDesc[i] != null)
					model.setTtlPckDesc(ttlPckDesc[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (actWgtPrnFlg[i] != null)
					model.setActWgtPrnFlg(actWgtPrnFlg[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (rPoOtherMdtItm[i] != null)
					model.setRPoOtherMdtItm(rPoOtherMdtItm[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (oblIssFlg[i] != null)
					model.setOblIssFlg(oblIssFlg[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (frtPayOfcPrnFlg[i] != null)
					model.setFrtPayOfcPrnFlg(frtPayOfcPrnFlg[i]);
				if (pckNm[i] != null)
					model.setPckNm(pckNm[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (poRefDtlFlag[i] != null)
					model.setPoRefDtlFlag(poRefDtlFlag[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMndVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MndVO[]
	 */
	public MndVO[] getMndVOs(){
		MndVO[] vos = (MndVO[])models.toArray(new MndVO[models.size()]);
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
		this.cntrDesc = this.cntrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckCmdtDesc = this.pckCmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfDescPrnFlg = this.mfDescPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCmdtDesc = this.dgCmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefTpMlCd = this.bkgRefTpMlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poMrnUcrCntrFlg = this.poMrnUcrCntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCmdtDesc = this.cntrCmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDescPrnFlg = this.mkDescPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgtPrnFlg = this.cntrWgtPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMeasPrnFlg = this.cntrMeasPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrCd = this.cstmsClrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermPrnFlg = this.frtTermPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptImpSeq = this.xptImpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFlg = this.imgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQtyPrnFlg = this.measQtyPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poCustFlag = this.poCustFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poRefFlag = this.poRefFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc = this.mkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPckDesc = this.ttlPckDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgtPrnFlg = this.actWgtPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rPoOtherMdtItm = this.rPoOtherMdtItm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssFlg = this.oblIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtPayOfcPrnFlg = this.frtPayOfcPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckNm = this.pckNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poRefDtlFlag = this.poRefDtlFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
