/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorAmdBlInfoVO.java
*@FileTitle : KorAmdBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.01.18 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorAmdBlInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorAmdBlInfoVO> models = new ArrayList<KorAmdBlInfoVO>();
	
	/* Column Info */
	private String elnoB = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String elnoA = null;
	/* Column Info */
	private String tr = null;
	/* Column Info */
	private String cAddr = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String errorCheck = null;
	/* Column Info */
	private String krBlAmdtStsCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cgoDesc1 = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String ibVvd = null;
	/* Column Info */
	private String wh = null;
	/* Column Info */
	private String trnsSeq = null;
	/* Column Info */
	private String cntrCnt = null;
	/* Column Info */
	private String dwellDt = null;
	/* Column Info */
	private String sAddr = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String blMeasUtCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String yardCd = null;
	/* Column Info */
	private String bizRgstNo = null;
	/* Column Info */
	private String cNm = null;
	/* Column Info */
	private String mstBlSeqNo = null;
	/* Column Info */
	private String cntrTtlWgt = null;
	/* Column Info */
	private String ibCBlNo = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String blSeqNo = null;
	/* Column Info */
	private String cntrChkWgt = null;
	/* Column Info */
	private String bacNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cstmsDeclTpCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String krCstmsBlTpCd = null;
	/* Column Info */
	private String mfSndDt = null;
	/* Column Info */
	private String ibBkgNo = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String ibPort = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String krCstmsBndCd = null;
	/* Column Info */
	private String ibSeq = null;
	/* Column Info */
	private String sNm = null;
	/* Column Info */
	private String ibEta = null;
	/* Column Info */
	private String nAddr = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String bdAreaCd = null;
	/* Column Info */
	private String ibType = null;
	/* Column Info */
	private String nNm = null;
	/* Column Info */
	private String cBlNo = null;
	
	private String dmstPortCd = null;
	/* Column Info */
	private String cTrnsSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorAmdBlInfoVO() {}

	public KorAmdBlInfoVO(String ibflag, String pagerows, String cTrnsSeq, String dmstPortCd,String elnoB, String bkgCgoTpCd, String elnoA, String custNm, String blSeqNo, String tr, String cAddr, String cntrChkWgt, String blNo, String errorCheck, String krBlAmdtStsCd, String polCd, String cstmsDeclTpCd, String cmdtCd, String mfSndDt, String cgoDesc1, String krCstmsBlTpCd, String wgtUtCd, String measQty, String pckQty, String portCd, String pckTpCd, String krCstmsBndCd, String wh, String sNm, String nAddr, String trnsSeq, String cntrCnt, String ioBndCd, String bdAreaCd, String sAddr, String vvd, String podCd, String blMeasUtCd, String bkgNo, String yardCd, String bizRgstNo, String nNm, String cNm, String mstBlSeqNo, String cntrTtlWgt, String cBlNo, String ibBkgNo, String ibCBlNo, String ibSeq, String ibType, String ibPort, String ibVvd, String dwellDt, String ibEta, String bacNm) {
		this.elnoB = elnoB;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.elnoA = elnoA;
		this.tr = tr;
		this.cAddr = cAddr;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.errorCheck = errorCheck;
		this.krBlAmdtStsCd = krBlAmdtStsCd;
		this.polCd = polCd;
		this.cgoDesc1 = cgoDesc1;
		this.wgtUtCd = wgtUtCd;
		this.ibVvd = ibVvd;
		this.wh = wh;
		this.trnsSeq = trnsSeq;
		this.cntrCnt = cntrCnt;
		this.dwellDt = dwellDt;
		this.sAddr = sAddr;
		this.vvd = vvd;
		this.podCd = podCd;
		this.blMeasUtCd = blMeasUtCd;
		this.bkgNo = bkgNo;
		this.yardCd = yardCd;
		this.bizRgstNo = bizRgstNo;
		this.cNm = cNm;
		this.mstBlSeqNo = mstBlSeqNo;
		this.cntrTtlWgt = cntrTtlWgt;
		this.ibCBlNo = ibCBlNo;
		this.custNm = custNm;
		this.blSeqNo = blSeqNo;
		this.cntrChkWgt = cntrChkWgt;
		this.bacNm = bacNm;
		this.ibflag = ibflag;
		this.cstmsDeclTpCd = cstmsDeclTpCd;
		this.cmdtCd = cmdtCd;
		this.krCstmsBlTpCd = krCstmsBlTpCd;
		this.mfSndDt = mfSndDt;
		this.ibBkgNo = ibBkgNo;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.ibPort = ibPort;
		this.portCd = portCd;
		this.pckTpCd = pckTpCd;
		this.krCstmsBndCd = krCstmsBndCd;
		this.ibSeq = ibSeq;
		this.sNm = sNm;
		this.ibEta = ibEta;
		this.nAddr = nAddr;
		this.ioBndCd = ioBndCd;
		this.bdAreaCd = bdAreaCd;
		this.ibType = ibType;
		this.nNm = nNm;
		this.cBlNo = cBlNo;
		this.dmstPortCd = dmstPortCd;
		this.cTrnsSeq = cTrnsSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("elno_b", getElnoB());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("elno_a", getElnoA());
		this.hashColumns.put("tr", getTr());
		this.hashColumns.put("c_addr", getCAddr());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("error_check", getErrorCheck());
		this.hashColumns.put("kr_bl_amdt_sts_cd", getKrBlAmdtStsCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cgo_desc1", getCgoDesc1());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("ib_vvd", getIbVvd());
		this.hashColumns.put("wh", getWh());
		this.hashColumns.put("trns_seq", getTrnsSeq());
		this.hashColumns.put("cntr_cnt", getCntrCnt());
		this.hashColumns.put("dwell_dt", getDwellDt());
		this.hashColumns.put("s_addr", getSAddr());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bl_meas_ut_cd", getBlMeasUtCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("yard_cd", getYardCd());
		this.hashColumns.put("biz_rgst_no", getBizRgstNo());
		this.hashColumns.put("c_nm", getCNm());
		this.hashColumns.put("mst_bl_seq_no", getMstBlSeqNo());
		this.hashColumns.put("cntr_ttl_wgt", getCntrTtlWgt());
		this.hashColumns.put("ib_c_bl_no", getIbCBlNo());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("bl_seq_no", getBlSeqNo());
		this.hashColumns.put("cntr_chk_wgt", getCntrChkWgt());
		this.hashColumns.put("bac_nm", getBacNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cstms_decl_tp_cd", getCstmsDeclTpCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("kr_cstms_bl_tp_cd", getKrCstmsBlTpCd());
		this.hashColumns.put("mf_snd_dt", getMfSndDt());
		this.hashColumns.put("ib_bkg_no", getIbBkgNo());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("ib_port", getIbPort());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("kr_cstms_bnd_cd", getKrCstmsBndCd());
		this.hashColumns.put("ib_seq", getIbSeq());
		this.hashColumns.put("s_nm", getSNm());
		this.hashColumns.put("ib_eta", getIbEta());
		this.hashColumns.put("n_addr", getNAddr());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("bd_area_cd", getBdAreaCd());
		this.hashColumns.put("ib_type", getIbType());
		this.hashColumns.put("n_nm", getNNm());
		this.hashColumns.put("c_bl_no", getCBlNo());
		this.hashColumns.put("dmst_port_cd",getDmstPortCd());
		this.hashColumns.put("c_trns_seq",getCTrnsSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("elno_b", "elnoB");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("elno_a", "elnoA");
		this.hashFields.put("tr", "tr");
		this.hashFields.put("c_addr", "cAddr");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("error_check", "errorCheck");
		this.hashFields.put("kr_bl_amdt_sts_cd", "krBlAmdtStsCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cgo_desc1", "cgoDesc1");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("ib_vvd", "ibVvd");
		this.hashFields.put("wh", "wh");
		this.hashFields.put("trns_seq", "trnsSeq");
		this.hashFields.put("cntr_cnt", "cntrCnt");
		this.hashFields.put("dwell_dt", "dwellDt");
		this.hashFields.put("s_addr", "sAddr");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bl_meas_ut_cd", "blMeasUtCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("yard_cd", "yardCd");
		this.hashFields.put("biz_rgst_no", "bizRgstNo");
		this.hashFields.put("c_nm", "cNm");
		this.hashFields.put("mst_bl_seq_no", "mstBlSeqNo");
		this.hashFields.put("cntr_ttl_wgt", "cntrTtlWgt");
		this.hashFields.put("ib_c_bl_no", "ibCBlNo");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("bl_seq_no", "blSeqNo");
		this.hashFields.put("cntr_chk_wgt", "cntrChkWgt");
		this.hashFields.put("bac_nm", "bacNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cstms_decl_tp_cd", "cstmsDeclTpCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("kr_cstms_bl_tp_cd", "krCstmsBlTpCd");
		this.hashFields.put("mf_snd_dt", "mfSndDt");
		this.hashFields.put("ib_bkg_no", "ibBkgNo");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("ib_port", "ibPort");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("kr_cstms_bnd_cd", "krCstmsBndCd");
		this.hashFields.put("ib_seq", "ibSeq");
		this.hashFields.put("s_nm", "sNm");
		this.hashFields.put("ib_eta", "ibEta");
		this.hashFields.put("n_addr", "nAddr");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("bd_area_cd", "bdAreaCd");
		this.hashFields.put("ib_type", "ibType");
		this.hashFields.put("n_nm", "nNm");
		this.hashFields.put("c_bl_no", "cBlNo");
		this.hashFields.put("dmst_port_cd", "dmstPortCd");
		this.hashFields.put("c_trns_seq", "cTrnsSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return elnoB
	 */
	public String getElnoB() {
		return this.elnoB;
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
	 * @return elnoA
	 */
	public String getElnoA() {
		return this.elnoA;
	}
	
	/**
	 * Column Info
	 * @return tr
	 */
	public String getTr() {
		return this.tr;
	}
	
	/**
	 * Column Info
	 * @return cAddr
	 */
	public String getCAddr() {
		return this.cAddr;
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
	 * @return errorCheck
	 */
	public String getErrorCheck() {
		return this.errorCheck;
	}
	
	/**
	 * Column Info
	 * @return krBlAmdtStsCd
	 */
	public String getKrBlAmdtStsCd() {
		return this.krBlAmdtStsCd;
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
	 * @return cgoDesc1
	 */
	public String getCgoDesc1() {
		return this.cgoDesc1;
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
	 * @return ibVvd
	 */
	public String getIbVvd() {
		return this.ibVvd;
	}
	
	/**
	 * Column Info
	 * @return wh
	 */
	public String getWh() {
		return this.wh;
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
	 * @return cntrCnt
	 */
	public String getCntrCnt() {
		return this.cntrCnt;
	}
	
	/**
	 * Column Info
	 * @return dwellDt
	 */
	public String getDwellDt() {
		return this.dwellDt;
	}
	
	/**
	 * Column Info
	 * @return sAddr
	 */
	public String getSAddr() {
		return this.sAddr;
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
	 * @return yardCd
	 */
	public String getYardCd() {
		return this.yardCd;
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
	 * @return cNm
	 */
	public String getCNm() {
		return this.cNm;
	}
	
	/**
	 * Column Info
	 * @return mstBlSeqNo
	 */
	public String getMstBlSeqNo() {
		return this.mstBlSeqNo;
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
	 * @return ibCBlNo
	 */
	public String getIbCBlNo() {
		return this.ibCBlNo;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return blSeqNo
	 */
	public String getBlSeqNo() {
		return this.blSeqNo;
	}
	
	/**
	 * Column Info
	 * @return cntrChkWgt
	 */
	public String getCntrChkWgt() {
		return this.cntrChkWgt;
	}
	
	/**
	 * Column Info
	 * @return bacNm
	 */
	public String getBacNm() {
		return this.bacNm;
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
	 * @return cstmsDeclTpCd
	 */
	public String getCstmsDeclTpCd() {
		return this.cstmsDeclTpCd;
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
	 * @return krCstmsBlTpCd
	 */
	public String getKrCstmsBlTpCd() {
		return this.krCstmsBlTpCd;
	}
	
	/**
	 * Column Info
	 * @return mfSndDt
	 */
	public String getMfSndDt() {
		return this.mfSndDt;
	}
	
	/**
	 * Column Info
	 * @return ibBkgNo
	 */
	public String getIbBkgNo() {
		return this.ibBkgNo;
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
	 * @return ibPort
	 */
	public String getIbPort() {
		return this.ibPort;
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
	 * @return ibSeq
	 */
	public String getIbSeq() {
		return this.ibSeq;
	}
	
	/**
	 * Column Info
	 * @return sNm
	 */
	public String getSNm() {
		return this.sNm;
	}
	
	/**
	 * Column Info
	 * @return ibEta
	 */
	public String getIbEta() {
		return this.ibEta;
	}
	
	/**
	 * Column Info
	 * @return nAddr
	 */
	public String getNAddr() {
		return this.nAddr;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return ibType
	 */
	public String getIbType() {
		return this.ibType;
	}
	
	/**
	 * Column Info
	 * @return nNm
	 */
	public String getNNm() {
		return this.nNm;
	}
	
	/**
	 * Column Info
	 * @return cBlNo
	 */
	public String getCBlNo() {
		return this.cBlNo;
	}
	
	/**
	 * Column Info
	 * @return dmstPortCd
	 */
	public String getDmstPortCd() {
		return this.dmstPortCd;
	}
	
	/**
	 * Column Info
	 * @return cTrnsSeq
	 */
	public String getCTrnsSeq() {
		return this.cTrnsSeq;
	}
	

	/**
	 * Column Info
	 * @param elnoB
	 */
	public void setElnoB(String elnoB) {
		this.elnoB = elnoB;
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
	 * @param elnoA
	 */
	public void setElnoA(String elnoA) {
		this.elnoA = elnoA;
	}
	
	/**
	 * Column Info
	 * @param tr
	 */
	public void setTr(String tr) {
		this.tr = tr;
	}
	
	/**
	 * Column Info
	 * @param cAddr
	 */
	public void setCAddr(String cAddr) {
		this.cAddr = cAddr;
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
	 * @param errorCheck
	 */
	public void setErrorCheck(String errorCheck) {
		this.errorCheck = errorCheck;
	}
	
	/**
	 * Column Info
	 * @param krBlAmdtStsCd
	 */
	public void setKrBlAmdtStsCd(String krBlAmdtStsCd) {
		this.krBlAmdtStsCd = krBlAmdtStsCd;
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
	 * @param cgoDesc1
	 */
	public void setCgoDesc1(String cgoDesc1) {
		this.cgoDesc1 = cgoDesc1;
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
	 * @param ibVvd
	 */
	public void setIbVvd(String ibVvd) {
		this.ibVvd = ibVvd;
	}
	
	/**
	 * Column Info
	 * @param wh
	 */
	public void setWh(String wh) {
		this.wh = wh;
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
	 * @param cntrCnt
	 */
	public void setCntrCnt(String cntrCnt) {
		this.cntrCnt = cntrCnt;
	}
	
	/**
	 * Column Info
	 * @param dwellDt
	 */
	public void setDwellDt(String dwellDt) {
		this.dwellDt = dwellDt;
	}
	
	/**
	 * Column Info
	 * @param sAddr
	 */
	public void setSAddr(String sAddr) {
		this.sAddr = sAddr;
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
	 * @param yardCd
	 */
	public void setYardCd(String yardCd) {
		this.yardCd = yardCd;
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
	 * @param cNm
	 */
	public void setCNm(String cNm) {
		this.cNm = cNm;
	}
	
	/**
	 * Column Info
	 * @param mstBlSeqNo
	 */
	public void setMstBlSeqNo(String mstBlSeqNo) {
		this.mstBlSeqNo = mstBlSeqNo;
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
	 * @param ibCBlNo
	 */
	public void setIbCBlNo(String ibCBlNo) {
		this.ibCBlNo = ibCBlNo;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param blSeqNo
	 */
	public void setBlSeqNo(String blSeqNo) {
		this.blSeqNo = blSeqNo;
	}
	
	/**
	 * Column Info
	 * @param cntrChkWgt
	 */
	public void setCntrChkWgt(String cntrChkWgt) {
		this.cntrChkWgt = cntrChkWgt;
	}
	
	/**
	 * Column Info
	 * @param bacNm
	 */
	public void setBacNm(String bacNm) {
		this.bacNm = bacNm;
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
	 * @param cstmsDeclTpCd
	 */
	public void setCstmsDeclTpCd(String cstmsDeclTpCd) {
		this.cstmsDeclTpCd = cstmsDeclTpCd;
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
	 * @param krCstmsBlTpCd
	 */
	public void setKrCstmsBlTpCd(String krCstmsBlTpCd) {
		this.krCstmsBlTpCd = krCstmsBlTpCd;
	}
	
	/**
	 * Column Info
	 * @param mfSndDt
	 */
	public void setMfSndDt(String mfSndDt) {
		this.mfSndDt = mfSndDt;
	}
	
	/**
	 * Column Info
	 * @param ibBkgNo
	 */
	public void setIbBkgNo(String ibBkgNo) {
		this.ibBkgNo = ibBkgNo;
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
	 * @param ibPort
	 */
	public void setIbPort(String ibPort) {
		this.ibPort = ibPort;
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
	 * @param ibSeq
	 */
	public void setIbSeq(String ibSeq) {
		this.ibSeq = ibSeq;
	}
	
	/**
	 * Column Info
	 * @param sNm
	 */
	public void setSNm(String sNm) {
		this.sNm = sNm;
	}
	
	/**
	 * Column Info
	 * @param ibEta
	 */
	public void setIbEta(String ibEta) {
		this.ibEta = ibEta;
	}
	
	/**
	 * Column Info
	 * @param nAddr
	 */
	public void setNAddr(String nAddr) {
		this.nAddr = nAddr;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param ibType
	 */
	public void setIbType(String ibType) {
		this.ibType = ibType;
	}
	
	/**
	 * Column Info
	 * @param nNm
	 */
	public void setNNm(String nNm) {
		this.nNm = nNm;
	}
	
	/**
	 * Column Info
	 * @param cBlNo
	 */
	public void setCBlNo(String cBlNo) {
		this.cBlNo = cBlNo;
	}
	
	/**
	 * Column Info
	 * @param dmstPortCd
	 */
	public void setDmstPortCd(String dmstPortCd) {
		this.dmstPortCd = dmstPortCd;
	}
	
	/**
	 * Column Info
	 * @param cTrnsSeq
	 */
	public void setCTrnsSeq(String cTrnsSeq) {
		this.cTrnsSeq = cTrnsSeq;
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
		setElnoB(JSPUtil.getParameter(request, prefix + "elno_b", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setElnoA(JSPUtil.getParameter(request, prefix + "elno_a", ""));
		setTr(JSPUtil.getParameter(request, prefix + "tr", ""));
		setCAddr(JSPUtil.getParameter(request, prefix + "c_addr", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setErrorCheck(JSPUtil.getParameter(request, prefix + "error_check", ""));
		setKrBlAmdtStsCd(JSPUtil.getParameter(request, prefix + "kr_bl_amdt_sts_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCgoDesc1(JSPUtil.getParameter(request, prefix + "cgo_desc1", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setIbVvd(JSPUtil.getParameter(request, prefix + "ib_vvd", ""));
		setWh(JSPUtil.getParameter(request, prefix + "wh", ""));
		setTrnsSeq(JSPUtil.getParameter(request, prefix + "trns_seq", ""));
		setCntrCnt(JSPUtil.getParameter(request, prefix + "cntr_cnt", ""));
		setDwellDt(JSPUtil.getParameter(request, prefix + "dwell_dt", ""));
		setSAddr(JSPUtil.getParameter(request, prefix + "s_addr", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBlMeasUtCd(JSPUtil.getParameter(request, prefix + "bl_meas_ut_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setYardCd(JSPUtil.getParameter(request, prefix + "yard_cd", ""));
		setBizRgstNo(JSPUtil.getParameter(request, prefix + "biz_rgst_no", ""));
		setCNm(JSPUtil.getParameter(request, prefix + "c_nm", ""));
		setMstBlSeqNo(JSPUtil.getParameter(request, prefix + "mst_bl_seq_no", ""));
		setCntrTtlWgt(JSPUtil.getParameter(request, prefix + "cntr_ttl_wgt", ""));
		setIbCBlNo(JSPUtil.getParameter(request, prefix + "ib_c_bl_no", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setBlSeqNo(JSPUtil.getParameter(request, prefix + "bl_seq_no", ""));
		setCntrChkWgt(JSPUtil.getParameter(request, prefix + "cntr_chk_wgt", ""));
		setBacNm(JSPUtil.getParameter(request, prefix + "bac_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCstmsDeclTpCd(JSPUtil.getParameter(request, prefix + "cstms_decl_tp_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setKrCstmsBlTpCd(JSPUtil.getParameter(request, prefix + "kr_cstms_bl_tp_cd", ""));
		setMfSndDt(JSPUtil.getParameter(request, prefix + "mf_snd_dt", ""));
		setIbBkgNo(JSPUtil.getParameter(request, prefix + "ib_bkg_no", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setIbPort(JSPUtil.getParameter(request, prefix + "ib_port", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setKrCstmsBndCd(JSPUtil.getParameter(request, prefix + "kr_cstms_bnd_cd", ""));
		setIbSeq(JSPUtil.getParameter(request, prefix + "ib_seq", ""));
		setSNm(JSPUtil.getParameter(request, prefix + "s_nm", ""));
		setIbEta(JSPUtil.getParameter(request, prefix + "ib_eta", ""));
		setNAddr(JSPUtil.getParameter(request, prefix + "n_addr", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setBdAreaCd(JSPUtil.getParameter(request, prefix + "bd_area_cd", ""));
		setIbType(JSPUtil.getParameter(request, prefix + "ib_type", ""));
		setNNm(JSPUtil.getParameter(request, prefix + "n_nm", ""));
		setCBlNo(JSPUtil.getParameter(request, prefix + "c_bl_no", ""));
		setDmstPortCd(JSPUtil.getParameter(request, prefix +"dmst_port_cd", ""));
		setCTrnsSeq(JSPUtil.getParameter(request, prefix +"c_trns_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorAmdBlInfoVO[]
	 */
	public KorAmdBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorAmdBlInfoVO[]
	 */
	public KorAmdBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorAmdBlInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] elnoB = (JSPUtil.getParameter(request, prefix	+ "elno_b", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] elnoA = (JSPUtil.getParameter(request, prefix	+ "elno_a", length));
			String[] tr = (JSPUtil.getParameter(request, prefix	+ "tr", length));
			String[] cAddr = (JSPUtil.getParameter(request, prefix	+ "c_addr", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] errorCheck = (JSPUtil.getParameter(request, prefix	+ "error_check", length));
			String[] krBlAmdtStsCd = (JSPUtil.getParameter(request, prefix	+ "kr_bl_amdt_sts_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cgoDesc1 = (JSPUtil.getParameter(request, prefix	+ "cgo_desc1", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] ibVvd = (JSPUtil.getParameter(request, prefix	+ "ib_vvd", length));
			String[] wh = (JSPUtil.getParameter(request, prefix	+ "wh", length));
			String[] trnsSeq = (JSPUtil.getParameter(request, prefix	+ "trns_seq", length));
			String[] cntrCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_cnt", length));
			String[] dwellDt = (JSPUtil.getParameter(request, prefix	+ "dwell_dt", length));
			String[] sAddr = (JSPUtil.getParameter(request, prefix	+ "s_addr", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] blMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "bl_meas_ut_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] yardCd = (JSPUtil.getParameter(request, prefix	+ "yard_cd", length));
			String[] bizRgstNo = (JSPUtil.getParameter(request, prefix	+ "biz_rgst_no", length));
			String[] cNm = (JSPUtil.getParameter(request, prefix	+ "c_nm", length));
			String[] mstBlSeqNo = (JSPUtil.getParameter(request, prefix	+ "mst_bl_seq_no", length));
			String[] cntrTtlWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_ttl_wgt", length));
			String[] ibCBlNo = (JSPUtil.getParameter(request, prefix	+ "ib_c_bl_no", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] blSeqNo = (JSPUtil.getParameter(request, prefix	+ "bl_seq_no", length));
			String[] cntrChkWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_chk_wgt", length));
			String[] bacNm = (JSPUtil.getParameter(request, prefix	+ "bac_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_tp_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] krCstmsBlTpCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_bl_tp_cd", length));
			String[] mfSndDt = (JSPUtil.getParameter(request, prefix	+ "mf_snd_dt", length));
			String[] ibBkgNo = (JSPUtil.getParameter(request, prefix	+ "ib_bkg_no", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] ibPort = (JSPUtil.getParameter(request, prefix	+ "ib_port", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] krCstmsBndCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_bnd_cd", length));
			String[] ibSeq = (JSPUtil.getParameter(request, prefix	+ "ib_seq", length));
			String[] sNm = (JSPUtil.getParameter(request, prefix	+ "s_nm", length));
			String[] ibEta = (JSPUtil.getParameter(request, prefix	+ "ib_eta", length));
			String[] nAddr = (JSPUtil.getParameter(request, prefix	+ "n_addr", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] bdAreaCd = (JSPUtil.getParameter(request, prefix	+ "bd_area_cd", length));
			String[] ibType = (JSPUtil.getParameter(request, prefix	+ "ib_type", length));
			String[] nNm = (JSPUtil.getParameter(request, prefix	+ "n_nm", length));
			String[] cBlNo = (JSPUtil.getParameter(request, prefix	+ "c_bl_no", length));
			String[] dmstPortCd = (JSPUtil.getParameter(request, prefix + "dmst_port_cd".trim(), length));
			String[] cTrnsSeq = (JSPUtil.getParameter(request, prefix + "c_trns_seq".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new KorAmdBlInfoVO();
				if (elnoB[i] != null)
					model.setElnoB(elnoB[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (elnoA[i] != null)
					model.setElnoA(elnoA[i]);
				if (tr[i] != null)
					model.setTr(tr[i]);
				if (cAddr[i] != null)
					model.setCAddr(cAddr[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (errorCheck[i] != null)
					model.setErrorCheck(errorCheck[i]);
				if (krBlAmdtStsCd[i] != null)
					model.setKrBlAmdtStsCd(krBlAmdtStsCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cgoDesc1[i] != null)
					model.setCgoDesc1(cgoDesc1[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (ibVvd[i] != null)
					model.setIbVvd(ibVvd[i]);
				if (wh[i] != null)
					model.setWh(wh[i]);
				if (trnsSeq[i] != null)
					model.setTrnsSeq(trnsSeq[i]);
				if (cntrCnt[i] != null)
					model.setCntrCnt(cntrCnt[i]);
				if (dwellDt[i] != null)
					model.setDwellDt(dwellDt[i]);
				if (sAddr[i] != null)
					model.setSAddr(sAddr[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (blMeasUtCd[i] != null)
					model.setBlMeasUtCd(blMeasUtCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (yardCd[i] != null)
					model.setYardCd(yardCd[i]);
				if (bizRgstNo[i] != null)
					model.setBizRgstNo(bizRgstNo[i]);
				if (cNm[i] != null)
					model.setCNm(cNm[i]);
				if (mstBlSeqNo[i] != null)
					model.setMstBlSeqNo(mstBlSeqNo[i]);
				if (cntrTtlWgt[i] != null)
					model.setCntrTtlWgt(cntrTtlWgt[i]);
				if (ibCBlNo[i] != null)
					model.setIbCBlNo(ibCBlNo[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (blSeqNo[i] != null)
					model.setBlSeqNo(blSeqNo[i]);
				if (cntrChkWgt[i] != null)
					model.setCntrChkWgt(cntrChkWgt[i]);
				if (bacNm[i] != null)
					model.setBacNm(bacNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cstmsDeclTpCd[i] != null)
					model.setCstmsDeclTpCd(cstmsDeclTpCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (krCstmsBlTpCd[i] != null)
					model.setKrCstmsBlTpCd(krCstmsBlTpCd[i]);
				if (mfSndDt[i] != null)
					model.setMfSndDt(mfSndDt[i]);
				if (ibBkgNo[i] != null)
					model.setIbBkgNo(ibBkgNo[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (ibPort[i] != null)
					model.setIbPort(ibPort[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (krCstmsBndCd[i] != null)
					model.setKrCstmsBndCd(krCstmsBndCd[i]);
				if (ibSeq[i] != null)
					model.setIbSeq(ibSeq[i]);
				if (sNm[i] != null)
					model.setSNm(sNm[i]);
				if (ibEta[i] != null)
					model.setIbEta(ibEta[i]);
				if (nAddr[i] != null)
					model.setNAddr(nAddr[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (bdAreaCd[i] != null)
					model.setBdAreaCd(bdAreaCd[i]);
				if (ibType[i] != null)
					model.setIbType(ibType[i]);
				if (nNm[i] != null)
					model.setNNm(nNm[i]);
				if (cBlNo[i] != null)
					model.setCBlNo(cBlNo[i]);
				if(dmstPortCd[i] != null)			
					model.setDmstPortCd(dmstPortCd[i]);
				if(cTrnsSeq[i] != null)			
					model.setCTrnsSeq(cTrnsSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorAmdBlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorAmdBlInfoVO[]
	 */
	public KorAmdBlInfoVO[] getKorAmdBlInfoVOs(){
		KorAmdBlInfoVO[] vos = (KorAmdBlInfoVO[])models.toArray(new KorAmdBlInfoVO[models.size()]);
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
		this.elnoB = this.elnoB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elnoA = this.elnoA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tr = this.tr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cAddr = this.cAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errorCheck = this.errorCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krBlAmdtStsCd = this.krBlAmdtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDesc1 = this.cgoDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibVvd = this.ibVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wh = this.wh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsSeq = this.trnsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnt = this.cntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwellDt = this.dwellDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAddr = this.sAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blMeasUtCd = this.blMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardCd = this.yardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizRgstNo = this.bizRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cNm = this.cNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBlSeqNo = this.mstBlSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTtlWgt = this.cntrTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCBlNo = this.ibCBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSeqNo = this.blSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrChkWgt = this.cntrChkWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bacNm = this.bacNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclTpCd = this.cstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsBlTpCd = this.krCstmsBlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSndDt = this.mfSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibBkgNo = this.ibBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibPort = this.ibPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsBndCd = this.krCstmsBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSeq = this.ibSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sNm = this.sNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibEta = this.ibEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nAddr = this.nAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdAreaCd = this.bdAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibType = this.ibType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nNm = this.nNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cBlNo = this.cBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmstPortCd = this.dmstPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cTrnsSeq = this.cTrnsSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
