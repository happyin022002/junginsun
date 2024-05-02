/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorBlInqInfoVO.java
*@FileTitle : KorBlInqInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.22 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorBlInqInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorBlInqInfoVO> models = new ArrayList<KorBlInqInfoVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String msnNo = null;
	/* Column Info */
	private String usaBndFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mode = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String krWhCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cgoTrspCd = null;
	/* Column Info */
	private String cstmsDeclTpCd = null;
	/* Column Info */
	private String cgoDesc2 = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String oldCstmsDeclTpCd = null;
	/* Column Info */
	private String cgoDesc1 = null;
	/* Column Info */
	private String krCstmsBlTpCd = null;
	/* Column Info */
	private String krCstmsWhTpCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String fldrCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String krCstmsBndCd = null;
	/* Column Info */
	private String tsPolCd = null;
	/* Column Info */
	private String bbCgoMeasQty = null;
	/* Column Info */
	private String trnsSeq = null;
	/* Column Info */
	private String bbCgoWgt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String n2ndImdgClssCd = null;
	/* Column Info */
	private String taxCode1 = null;
	/* Column Info */
	private String taxCode2 = null;
	/* Column Info */
	private String bdAreaCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String krMeasUtCd = null;
	/* Column Info */
	private String blMeasUtCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String n3rdImdgClssCd = null;
	/* Column Info */
	private String bizRgstNo = null;
	/* Column Info */
	private String cntrTtlWgt = null;
	/* Column Info */
	private String tsPodCd = null;
	/* Column Info */
	private String transTp = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String podTmlCd = null;
	/* Column Info */
	private String cstmsCrrInLocWhCd = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorBlInqInfoVO() {}

	public KorBlInqInfoVO(String ibflag, String pagerows, String bkgNo, String bkgCgoTpCd, String cgoTrspCd, String porCd, String polCd, String podCd, String delCd, String vvd, String msnNo, String krCstmsBlTpCd, String fldrCd, String pckQty, String pckTpCd, String cntrTtlWgt, String wgtUtCd, String measQty, String blMeasUtCd, String taxCode1, String taxCode2, String bdAreaCd, String krCstmsWhTpCd, String krWhCd, String imdgClssCd, String n2ndImdgClssCd, String n3rdImdgClssCd, String cmdtCd, String krMeasUtCd, String bizRgstNo, String bbCgoWgt, String bbCgoMeasQty, String cgoDesc1, String cgoDesc2, String krCstmsBndCd, String trnsSeq, String blNo, String transTp, String cstmsDeclTpCd, String oldCstmsDeclTpCd, String portCd, String userId, String mode, String usaBndFlg, String tsPolCd, String tsPodCd, String podTmlCd, String cstmsCrrInLocWhCd) {
		this.porCd = porCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.msnNo = msnNo;
		this.usaBndFlg = usaBndFlg;
		this.blNo = blNo;
		this.mode = mode;
		this.pagerows = pagerows;
		this.krWhCd = krWhCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cgoTrspCd = cgoTrspCd;
		this.cstmsDeclTpCd = cstmsDeclTpCd;
		this.cgoDesc2 = cgoDesc2;
		this.cmdtCd = cmdtCd;
		this.oldCstmsDeclTpCd = oldCstmsDeclTpCd;
		this.cgoDesc1 = cgoDesc1;
		this.krCstmsBlTpCd = krCstmsBlTpCd;
		this.krCstmsWhTpCd = krCstmsWhTpCd;
		this.userId = userId;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.fldrCd = fldrCd;
		this.portCd = portCd;
		this.pckTpCd = pckTpCd;
		this.krCstmsBndCd = krCstmsBndCd;
		this.tsPolCd = tsPolCd;
		this.bbCgoMeasQty = bbCgoMeasQty;
		this.trnsSeq = trnsSeq;
		this.bbCgoWgt = bbCgoWgt;
		this.delCd = delCd;
		this.n2ndImdgClssCd = n2ndImdgClssCd;
		this.taxCode1 = taxCode1;
		this.taxCode2 = taxCode2;
		this.bdAreaCd = bdAreaCd;
		this.vvd = vvd;
		this.podCd = podCd;
		this.krMeasUtCd = krMeasUtCd;
		this.blMeasUtCd = blMeasUtCd;
		this.bkgNo = bkgNo;
		this.n3rdImdgClssCd = n3rdImdgClssCd;
		this.bizRgstNo = bizRgstNo;
		this.cntrTtlWgt = cntrTtlWgt;
		this.tsPodCd = tsPodCd;
		this.transTp = transTp;
		this.imdgClssCd = imdgClssCd;
		this.podTmlCd = podTmlCd;
		this.cstmsCrrInLocWhCd = cstmsCrrInLocWhCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("msn_no", getMsnNo());
		this.hashColumns.put("usa_bnd_flg", getUsaBndFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mode", getMode());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("kr_wh_cd", getKrWhCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cgo_trsp_cd", getCgoTrspCd());
		this.hashColumns.put("cstms_decl_tp_cd", getCstmsDeclTpCd());
		this.hashColumns.put("cgo_desc2", getCgoDesc2());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("old_cstms_decl_tp_cd", getOldCstmsDeclTpCd());
		this.hashColumns.put("cgo_desc1", getCgoDesc1());
		this.hashColumns.put("kr_cstms_bl_tp_cd", getKrCstmsBlTpCd());
		this.hashColumns.put("kr_cstms_wh_tp_cd", getKrCstmsWhTpCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("fldr_cd", getFldrCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("kr_cstms_bnd_cd", getKrCstmsBndCd());
		this.hashColumns.put("ts_pol_cd", getTsPolCd());
		this.hashColumns.put("bb_cgo_meas_qty", getBbCgoMeasQty());
		this.hashColumns.put("trns_seq", getTrnsSeq());
		this.hashColumns.put("bb_cgo_wgt", getBbCgoWgt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("n2nd_imdg_clss_cd", getN2ndImdgClssCd());
		this.hashColumns.put("tax_code1", getTaxCode1());
		this.hashColumns.put("tax_code2", getTaxCode2());
		this.hashColumns.put("bd_area_cd", getBdAreaCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("kr_meas_ut_cd", getKrMeasUtCd());
		this.hashColumns.put("bl_meas_ut_cd", getBlMeasUtCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("n3rd_imdg_clss_cd", getN3rdImdgClssCd());
		this.hashColumns.put("biz_rgst_no", getBizRgstNo());
		this.hashColumns.put("cntr_ttl_wgt", getCntrTtlWgt());
		this.hashColumns.put("ts_pod_cd", getTsPodCd());
		this.hashColumns.put("trans_tp", getTransTp());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("pod_tml_cd", getPodTmlCd());
		this.hashColumns.put("cstms_crr_in_loc_wh_cd", getCstmsCrrInLocWhCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("msn_no", "msnNo");
		this.hashFields.put("usa_bnd_flg", "usaBndFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mode", "mode");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("kr_wh_cd", "krWhCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cgo_trsp_cd", "cgoTrspCd");
		this.hashFields.put("cstms_decl_tp_cd", "cstmsDeclTpCd");
		this.hashFields.put("cgo_desc2", "cgoDesc2");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("old_cstms_decl_tp_cd", "oldCstmsDeclTpCd");
		this.hashFields.put("cgo_desc1", "cgoDesc1");
		this.hashFields.put("kr_cstms_bl_tp_cd", "krCstmsBlTpCd");
		this.hashFields.put("kr_cstms_wh_tp_cd", "krCstmsWhTpCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("fldr_cd", "fldrCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("kr_cstms_bnd_cd", "krCstmsBndCd");
		this.hashFields.put("ts_pol_cd", "tsPolCd");
		this.hashFields.put("bb_cgo_meas_qty", "bbCgoMeasQty");
		this.hashFields.put("trns_seq", "trnsSeq");
		this.hashFields.put("bb_cgo_wgt", "bbCgoWgt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("n2nd_imdg_clss_cd", "n2ndImdgClssCd");
		this.hashFields.put("tax_code1", "taxCode1");
		this.hashFields.put("tax_code2", "taxCode2");
		this.hashFields.put("bd_area_cd", "bdAreaCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("kr_meas_ut_cd", "krMeasUtCd");
		this.hashFields.put("bl_meas_ut_cd", "blMeasUtCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("n3rd_imdg_clss_cd", "n3rdImdgClssCd");
		this.hashFields.put("biz_rgst_no", "bizRgstNo");
		this.hashFields.put("cntr_ttl_wgt", "cntrTtlWgt");
		this.hashFields.put("ts_pod_cd", "tsPodCd");
		this.hashFields.put("trans_tp", "transTp");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("pod_tml_cd", "podTmlCd");
		this.hashFields.put("cstms_crr_in_loc_wh_cd", "cstmsCrrInLocWhCd");
		return this.hashFields;
	}
	
	/**
	 * @return the podTmlCd
	 */
	public String getPodTmlCd() {
		return podTmlCd;
	}

	/**
	 * @param podTmlCd the podTmlCd to set
	 */
	public void setPodTmlCd(String podTmlCd) {
		this.podTmlCd = podTmlCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsCrrInLocWhCd
	 */
	public String getCstmsCrrInLocWhCd() {
		return this.cstmsCrrInLocWhCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsCrrInLocWhCd
	 */
	public void setCstmsCrrInLocWhCd(String cstmsCrrInLocWhCd) {
		this.cstmsCrrInLocWhCd = cstmsCrrInLocWhCd;
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
	 * @return msnNo
	 */
	public String getMsnNo() {
		return this.msnNo;
	}
	
	/**
	 * Column Info
	 * @return usaBndFlg
	 */
	public String getUsaBndFlg() {
		return this.usaBndFlg;
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
	 * @return mode
	 */
	public String getMode() {
		return this.mode;
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
	 * @return krWhCd
	 */
	public String getKrWhCd() {
		return this.krWhCd;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return cgoTrspCd
	 */
	public String getCgoTrspCd() {
		return this.cgoTrspCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsDeclTpCd
	 */
	public String getCstmsDeclTpCd() {
		return this.cstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @return cgoDesc2
	 */
	public String getCgoDesc2() {
		return this.cgoDesc2;
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
	 * @return oldCstmsDeclTpCd
	 */
	public String getOldCstmsDeclTpCd() {
		return this.oldCstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @return cgoDesc1
	 */
	public String getCgoDesc1() {
		return this.cgoDesc1;
	}
	
	/**
	 * Column Info
	 * @return krCstmsBlTpCd
	 */
	public String getKrCstmsBlTpCd() {
		return this.krCstmsBlTpCd;
	}
	
	/**
	 * Column Info
	 * @return krCstmsWhTpCd
	 */
	public String getKrCstmsWhTpCd() {
		return this.krCstmsWhTpCd;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
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
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
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
	 * @return fldrCd
	 */
	public String getFldrCd() {
		return this.fldrCd;
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
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return krCstmsBndCd
	 */
	public String getKrCstmsBndCd() {
		return this.krCstmsBndCd;
	}
	
	/**
	 * Column Info
	 * @return tsPolCd
	 */
	public String getTsPolCd() {
		return this.tsPolCd;
	}
	
	/**
	 * Column Info
	 * @return bbCgoMeasQty
	 */
	public String getBbCgoMeasQty() {
		return this.bbCgoMeasQty;
	}
	
	/**
	 * Column Info
	 * @return trnsSeq
	 */
	public String getTrnsSeq() {
		return this.trnsSeq;
	}
	
	/**
	 * Column Info
	 * @return bbCgoWgt
	 */
	public String getBbCgoWgt() {
		return this.bbCgoWgt;
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
	 * @return n2ndImdgClssCd
	 */
	public String getN2ndImdgClssCd() {
		return this.n2ndImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return taxCode1
	 */
	public String getTaxCode1() {
		return this.taxCode1;
	}
	
	/**
	 * Column Info
	 * @return taxCode2
	 */
	public String getTaxCode2() {
		return this.taxCode2;
	}
	
	/**
	 * Column Info
	 * @return bdAreaCd
	 */
	public String getBdAreaCd() {
		return this.bdAreaCd;
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
	 * @return krMeasUtCd
	 */
	public String getKrMeasUtCd() {
		return this.krMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @return blMeasUtCd
	 */
	public String getBlMeasUtCd() {
		return this.blMeasUtCd;
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
	 * @return n3rdImdgClssCd
	 */
	public String getN3rdImdgClssCd() {
		return this.n3rdImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return bizRgstNo
	 */
	public String getBizRgstNo() {
		return this.bizRgstNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTtlWgt
	 */
	public String getCntrTtlWgt() {
		return this.cntrTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return tsPodCd
	 */
	public String getTsPodCd() {
		return this.tsPodCd;
	}
	
	/**
	 * Column Info
	 * @return transTp
	 */
	public String getTransTp() {
		return this.transTp;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
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
	 * @param msnNo
	 */
	public void setMsnNo(String msnNo) {
		this.msnNo = msnNo;
	}
	
	/**
	 * Column Info
	 * @param usaBndFlg
	 */
	public void setUsaBndFlg(String usaBndFlg) {
		this.usaBndFlg = usaBndFlg;
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
	 * @param mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
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
	 * @param krWhCd
	 */
	public void setKrWhCd(String krWhCd) {
		this.krWhCd = krWhCd;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param cgoTrspCd
	 */
	public void setCgoTrspCd(String cgoTrspCd) {
		this.cgoTrspCd = cgoTrspCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsDeclTpCd
	 */
	public void setCstmsDeclTpCd(String cstmsDeclTpCd) {
		this.cstmsDeclTpCd = cstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @param cgoDesc2
	 */
	public void setCgoDesc2(String cgoDesc2) {
		this.cgoDesc2 = cgoDesc2;
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
	 * @param oldCstmsDeclTpCd
	 */
	public void setOldCstmsDeclTpCd(String oldCstmsDeclTpCd) {
		this.oldCstmsDeclTpCd = oldCstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @param cgoDesc1
	 */
	public void setCgoDesc1(String cgoDesc1) {
		this.cgoDesc1 = cgoDesc1;
	}
	
	/**
	 * Column Info
	 * @param krCstmsBlTpCd
	 */
	public void setKrCstmsBlTpCd(String krCstmsBlTpCd) {
		this.krCstmsBlTpCd = krCstmsBlTpCd;
	}
	
	/**
	 * Column Info
	 * @param krCstmsWhTpCd
	 */
	public void setKrCstmsWhTpCd(String krCstmsWhTpCd) {
		this.krCstmsWhTpCd = krCstmsWhTpCd;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
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
	 * @param fldrCd
	 */
	public void setFldrCd(String fldrCd) {
		this.fldrCd = fldrCd;
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
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param krCstmsBndCd
	 */
	public void setKrCstmsBndCd(String krCstmsBndCd) {
		this.krCstmsBndCd = krCstmsBndCd;
	}
	
	/**
	 * Column Info
	 * @param tsPolCd
	 */
	public void setTsPolCd(String tsPolCd) {
		this.tsPolCd = tsPolCd;
	}
	
	/**
	 * Column Info
	 * @param bbCgoMeasQty
	 */
	public void setBbCgoMeasQty(String bbCgoMeasQty) {
		this.bbCgoMeasQty = bbCgoMeasQty;
	}
	
	/**
	 * Column Info
	 * @param trnsSeq
	 */
	public void setTrnsSeq(String trnsSeq) {
		this.trnsSeq = trnsSeq;
	}
	
	/**
	 * Column Info
	 * @param bbCgoWgt
	 */
	public void setBbCgoWgt(String bbCgoWgt) {
		this.bbCgoWgt = bbCgoWgt;
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
	 * @param n2ndImdgClssCd
	 */
	public void setN2ndImdgClssCd(String n2ndImdgClssCd) {
		this.n2ndImdgClssCd = n2ndImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param taxCode1
	 */
	public void setTaxCode1(String taxCode1) {
		this.taxCode1 = taxCode1;
	}
	
	/**
	 * Column Info
	 * @param taxCode2
	 */
	public void setTaxCode2(String taxCode2) {
		this.taxCode2 = taxCode2;
	}
	
	/**
	 * Column Info
	 * @param bdAreaCd
	 */
	public void setBdAreaCd(String bdAreaCd) {
		this.bdAreaCd = bdAreaCd;
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
	 * @param krMeasUtCd
	 */
	public void setKrMeasUtCd(String krMeasUtCd) {
		this.krMeasUtCd = krMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param blMeasUtCd
	 */
	public void setBlMeasUtCd(String blMeasUtCd) {
		this.blMeasUtCd = blMeasUtCd;
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
	 * @param n3rdImdgClssCd
	 */
	public void setN3rdImdgClssCd(String n3rdImdgClssCd) {
		this.n3rdImdgClssCd = n3rdImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param bizRgstNo
	 */
	public void setBizRgstNo(String bizRgstNo) {
		this.bizRgstNo = bizRgstNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTtlWgt
	 */
	public void setCntrTtlWgt(String cntrTtlWgt) {
		this.cntrTtlWgt = cntrTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param tsPodCd
	 */
	public void setTsPodCd(String tsPodCd) {
		this.tsPodCd = tsPodCd;
	}
	
	/**
	 * Column Info
	 * @param transTp
	 */
	public void setTransTp(String transTp) {
		this.transTp = transTp;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setMsnNo(JSPUtil.getParameter(request, "msn_no", ""));
		setUsaBndFlg(JSPUtil.getParameter(request, "usa_bnd_flg", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setMode(JSPUtil.getParameter(request, "mode", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setKrWhCd(JSPUtil.getParameter(request, "kr_wh_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCgoTrspCd(JSPUtil.getParameter(request, "cgo_trsp_cd", ""));
		setCstmsDeclTpCd(JSPUtil.getParameter(request, "cstms_decl_tp_cd", ""));
		setCgoDesc2(JSPUtil.getParameter(request, "cgo_desc2", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setOldCstmsDeclTpCd(JSPUtil.getParameter(request, "old_cstms_decl_tp_cd", ""));
		setCgoDesc1(JSPUtil.getParameter(request, "cgo_desc1", ""));
		setKrCstmsBlTpCd(JSPUtil.getParameter(request, "kr_cstms_bl_tp_cd", ""));
		setKrCstmsWhTpCd(JSPUtil.getParameter(request, "kr_cstms_wh_tp_cd", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setFldrCd(JSPUtil.getParameter(request, "fldr_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setKrCstmsBndCd(JSPUtil.getParameter(request, "kr_cstms_bnd_cd", ""));
		setTsPolCd(JSPUtil.getParameter(request, "ts_pol_cd", ""));
		setBbCgoMeasQty(JSPUtil.getParameter(request, "bb_cgo_meas_qty", ""));
		setTrnsSeq(JSPUtil.getParameter(request, "trns_seq", ""));
		setBbCgoWgt(JSPUtil.getParameter(request, "bb_cgo_wgt", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setN2ndImdgClssCd(JSPUtil.getParameter(request, "n2nd_imdg_clss_cd", ""));
		setTaxCode1(JSPUtil.getParameter(request, "tax_code1", ""));
		setTaxCode2(JSPUtil.getParameter(request, "tax_code2", ""));
		setBdAreaCd(JSPUtil.getParameter(request, "bd_area_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setKrMeasUtCd(JSPUtil.getParameter(request, "kr_meas_ut_cd", ""));
		setBlMeasUtCd(JSPUtil.getParameter(request, "bl_meas_ut_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setN3rdImdgClssCd(JSPUtil.getParameter(request, "n3rd_imdg_clss_cd", ""));
		setBizRgstNo(JSPUtil.getParameter(request, "biz_rgst_no", ""));
		setCntrTtlWgt(JSPUtil.getParameter(request, "cntr_ttl_wgt", ""));
		setTsPodCd(JSPUtil.getParameter(request, "ts_pod_cd", ""));
		setTransTp(JSPUtil.getParameter(request, "trans_tp", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
		setPodTmlCd(JSPUtil.getParameter(request, "pod_tml_cd", ""));
		setCstmsCrrInLocWhCd(JSPUtil.getParameter(request, "cstms_crr_in_loc_wh_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorBlInqInfoVO[]
	 */
	public KorBlInqInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorBlInqInfoVO[]
	 */
	public KorBlInqInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorBlInqInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] msnNo = (JSPUtil.getParameter(request, prefix	+ "msn_no", length));
			String[] usaBndFlg = (JSPUtil.getParameter(request, prefix	+ "usa_bnd_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mode = (JSPUtil.getParameter(request, prefix	+ "mode", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] krWhCd = (JSPUtil.getParameter(request, prefix	+ "kr_wh_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cgoTrspCd = (JSPUtil.getParameter(request, prefix	+ "cgo_trsp_cd", length));
			String[] cstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_tp_cd", length));
			String[] cgoDesc2 = (JSPUtil.getParameter(request, prefix	+ "cgo_desc2", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] oldCstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "old_cstms_decl_tp_cd", length));
			String[] cgoDesc1 = (JSPUtil.getParameter(request, prefix	+ "cgo_desc1", length));
			String[] krCstmsBlTpCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_bl_tp_cd", length));
			String[] krCstmsWhTpCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_wh_tp_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] fldrCd = (JSPUtil.getParameter(request, prefix	+ "fldr_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] krCstmsBndCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_bnd_cd", length));
			String[] tsPolCd = (JSPUtil.getParameter(request, prefix	+ "ts_pol_cd", length));
			String[] bbCgoMeasQty = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_meas_qty", length));
			String[] trnsSeq = (JSPUtil.getParameter(request, prefix	+ "trns_seq", length));
			String[] bbCgoWgt = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_wgt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] n2ndImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_clss_cd", length));
			String[] taxCode1 = (JSPUtil.getParameter(request, prefix	+ "tax_code1", length));
			String[] taxCode2 = (JSPUtil.getParameter(request, prefix	+ "tax_code2", length));
			String[] bdAreaCd = (JSPUtil.getParameter(request, prefix	+ "bd_area_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] krMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "kr_meas_ut_cd", length));
			String[] blMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "bl_meas_ut_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] n3rdImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_clss_cd", length));
			String[] bizRgstNo = (JSPUtil.getParameter(request, prefix	+ "biz_rgst_no", length));
			String[] cntrTtlWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_ttl_wgt", length));
			String[] tsPodCd = (JSPUtil.getParameter(request, prefix	+ "ts_pod_cd", length));
			String[] transTp = (JSPUtil.getParameter(request, prefix	+ "trans_tp", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] podTmlCd = (JSPUtil.getParameter(request, prefix	+ "pod_tml_cd", length));
			String[] cstmsCrrInLocWhCd = (JSPUtil.getParameter(request, prefix	+ "cstms_crr_in_loc_wh_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorBlInqInfoVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (msnNo[i] != null)
					model.setMsnNo(msnNo[i]);
				if (usaBndFlg[i] != null)
					model.setUsaBndFlg(usaBndFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mode[i] != null)
					model.setMode(mode[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (krWhCd[i] != null)
					model.setKrWhCd(krWhCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cgoTrspCd[i] != null)
					model.setCgoTrspCd(cgoTrspCd[i]);
				if (cstmsDeclTpCd[i] != null)
					model.setCstmsDeclTpCd(cstmsDeclTpCd[i]);
				if (cgoDesc2[i] != null)
					model.setCgoDesc2(cgoDesc2[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (oldCstmsDeclTpCd[i] != null)
					model.setOldCstmsDeclTpCd(oldCstmsDeclTpCd[i]);
				if (cgoDesc1[i] != null)
					model.setCgoDesc1(cgoDesc1[i]);
				if (krCstmsBlTpCd[i] != null)
					model.setKrCstmsBlTpCd(krCstmsBlTpCd[i]);
				if (krCstmsWhTpCd[i] != null)
					model.setKrCstmsWhTpCd(krCstmsWhTpCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (fldrCd[i] != null)
					model.setFldrCd(fldrCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (krCstmsBndCd[i] != null)
					model.setKrCstmsBndCd(krCstmsBndCd[i]);
				if (tsPolCd[i] != null)
					model.setTsPolCd(tsPolCd[i]);
				if (bbCgoMeasQty[i] != null)
					model.setBbCgoMeasQty(bbCgoMeasQty[i]);
				if (trnsSeq[i] != null)
					model.setTrnsSeq(trnsSeq[i]);
				if (bbCgoWgt[i] != null)
					model.setBbCgoWgt(bbCgoWgt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (n2ndImdgClssCd[i] != null)
					model.setN2ndImdgClssCd(n2ndImdgClssCd[i]);
				if (taxCode1[i] != null)
					model.setTaxCode1(taxCode1[i]);
				if (taxCode2[i] != null)
					model.setTaxCode2(taxCode2[i]);
				if (bdAreaCd[i] != null)
					model.setBdAreaCd(bdAreaCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (krMeasUtCd[i] != null)
					model.setKrMeasUtCd(krMeasUtCd[i]);
				if (blMeasUtCd[i] != null)
					model.setBlMeasUtCd(blMeasUtCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (n3rdImdgClssCd[i] != null)
					model.setN3rdImdgClssCd(n3rdImdgClssCd[i]);
				if (bizRgstNo[i] != null)
					model.setBizRgstNo(bizRgstNo[i]);
				if (cntrTtlWgt[i] != null)
					model.setCntrTtlWgt(cntrTtlWgt[i]);
				if (tsPodCd[i] != null)
					model.setTsPodCd(tsPodCd[i]);
				if (transTp[i] != null)
					model.setTransTp(transTp[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (podTmlCd[i]!=null)
					model.setPodTmlCd(podTmlCd[i]);
				if (cstmsCrrInLocWhCd[i] != null)
					model.setCstmsCrrInLocWhCd(cstmsCrrInLocWhCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorBlInqInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorBlInqInfoVO[]
	 */
	public KorBlInqInfoVO[] getKorBlInqInfoVOs(){
		KorBlInqInfoVO[] vos = (KorBlInqInfoVO[])models.toArray(new KorBlInqInfoVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msnNo = this.msnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaBndFlg = this.usaBndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mode = this.mode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krWhCd = this.krWhCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTrspCd = this.cgoTrspCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclTpCd = this.cstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDesc2 = this.cgoDesc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCstmsDeclTpCd = this.oldCstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDesc1 = this.cgoDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsBlTpCd = this.krCstmsBlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsWhTpCd = this.krCstmsWhTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fldrCd = this.fldrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsBndCd = this.krCstmsBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPolCd = this.tsPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoMeasQty = this.bbCgoMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsSeq = this.trnsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoWgt = this.bbCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgClssCd = this.n2ndImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxCode1 = this.taxCode1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxCode2 = this.taxCode2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdAreaCd = this.bdAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krMeasUtCd = this.krMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blMeasUtCd = this.blMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgClssCd = this.n3rdImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizRgstNo = this.bizRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTtlWgt = this.cntrTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPodCd = this.tsPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transTp = this.transTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podTmlCd = this.podTmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.cstmsCrrInLocWhCd = this.cstmsCrrInLocWhCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
	}
}
