/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24VesselArrivalNoticeDetailVO.java
*@FileTitle : Eur24VesselArrivalNoticeDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.15  
* 1.0 Creation
* -------------------------------------------------------
* History
* 2014.04.23 김보배 [CHM-201429518] ENS - Arrival Notice 화면 관련 시스템 보완요청
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
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

public class Eur24VesselArrivalNoticeDetailVO extends VesselArrivalDetailVO {
	private static final long serialVersionUID = 1L;
	private Collection<Eur24VesselArrivalNoticeDetailVO> models = new ArrayList<Eur24VesselArrivalNoticeDetailVO>();
	
	/* Column Info */
	private String ediRcvDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String rvisN1stClptCd = null;
	/* Column Info */
	private String ediRcvSeq = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String tmlCd = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cstmsPortCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String rgstDt = null;
	/* Column Info */
	private String initEtaDt = null;
	/* Column Info */
	private String cstmsYdCd = null;
	/* Column Info */
	private String rgstPortCd = null;
	/* Column Info */
	private String n1stClptCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String grsRgstTongWgt = null;
	/* Column Info */
	private String nxtClptCd = null;
	/* Column Info */
	private String cvyRefNo = null;
	/* Column Info */
	private String piclbDesc = null;
	/* Column Info */
	private String ediRcvDtGmt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String rvisCstmsYdCd = null;
	/* Column Info */
	private String rgstNo = null;
	/* Column Info */
	private String tmlNm = null;
	/* Column Info */
	private String result = null;
	/* Column Info */
	private String anEdiSvcFlg = null;
	/* Column Info */
	private String edi = null;
	/* Column Info */
	private String ediRcvDtMsg = null;
	/* Column Info */
	private String arrPortCd = null;
	/* Column Info */
	private String sndDtGmt = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String n1stPortOfcCdNew = null;
	/* Column Info */
	private String ataDt = null;
	/* Column Info */
	private String updDtGmt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String netRgstTongWgt = null;
	/* Column Info */
	private String dvsRqstEdiSvcFlg = null;
	/* Column Info */
	private String ack = null;
	/* Column Info */
	private String sndOfcCd = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String lstClptCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String cvyRefNoHidden = null;
	/* Column Info */
	private String n1stPortOfcCd = null;
	/* Column Info */
	private String dvsRqstSmtFlg = null;
	/* Column Info */
	private String euStfFlg = null;
	/* Column Info */
	private String initEtaDtModiFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Eur24VesselArrivalNoticeDetailVO() {}

	public Eur24VesselArrivalNoticeDetailVO(String ibflag, String pagerows, String vvd, String vslCd, String skdVoyNo, String skdDirCd, String updDt, String updDtGmt, String updUsrId, String updOfcCd, String cvyRefNo, String cvyRefNoHidden, String vslEngNm, String crrCd, String lloydNo, String piclbDesc, String n1stClptCd, String etaDt, String etdDt, String ataDt, String initEtaDt, String cstmsPortCd, String cstmsYdCd, String rvisCstmsYdCd, String rvisN1stClptCd, String dvsRqstSmtFlg, String anEdiSvcFlg, String dvsRqstEdiSvcFlg, String n1stPortOfcCd, String n1stPortOfcCdNew, String tmlCd, String tmlNm, String lstClptCd, String nxtClptCd, String arrPortCd, String rgstNo, String rgstDt, String rgstPortCd, String grsRgstTongWgt, String netRgstTongWgt, String edi, String ediRcvDt, String ediRcvDtGmt, String ediRcvDtMsg, String ediRcvSeq, String ack, String result, String sndUsrId, String sndDt, String sndDtGmt, String sndOfcCd, String euStfFlg, String initEtaDtModiFlg) {
		this.ediRcvDt = ediRcvDt;
		this.vslCd = vslCd;
		this.etaDt = etaDt;
		this.rvisN1stClptCd = rvisN1stClptCd;
		this.ediRcvSeq = ediRcvSeq;
		this.sndDt = sndDt;
		this.tmlCd = tmlCd;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.cstmsPortCd = cstmsPortCd;
		this.updUsrId = updUsrId;
		this.updOfcCd = updOfcCd;
		this.rgstDt = rgstDt;
		this.initEtaDt = initEtaDt;
		this.cstmsYdCd = cstmsYdCd;
		this.rgstPortCd = rgstPortCd;
		this.n1stClptCd = n1stClptCd;
		this.skdVoyNo = skdVoyNo;
		this.grsRgstTongWgt = grsRgstTongWgt;
		this.nxtClptCd = nxtClptCd;
		this.cvyRefNo = cvyRefNo;
		this.piclbDesc = piclbDesc;
		this.ediRcvDtGmt = ediRcvDtGmt;
		this.vvd = vvd;
		this.sndUsrId = sndUsrId;
		this.lloydNo = lloydNo;
		this.rvisCstmsYdCd = rvisCstmsYdCd;
		this.rgstNo = rgstNo;
		this.tmlNm = tmlNm;
		this.result = result;
		this.anEdiSvcFlg = anEdiSvcFlg;
		this.edi = edi;
		this.ediRcvDtMsg = ediRcvDtMsg;
		this.arrPortCd = arrPortCd;
		this.sndDtGmt = sndDtGmt;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.n1stPortOfcCdNew = n1stPortOfcCdNew;
		this.ataDt = ataDt;
		this.updDtGmt = updDtGmt;
		this.updDt = updDt;
		this.netRgstTongWgt = netRgstTongWgt;
		this.dvsRqstEdiSvcFlg = dvsRqstEdiSvcFlg;
		this.ack = ack;
		this.sndOfcCd = sndOfcCd;
		this.etdDt = etdDt;
		this.lstClptCd = lstClptCd;
		this.skdDirCd = skdDirCd;
		this.cvyRefNoHidden = cvyRefNoHidden;
		this.n1stPortOfcCd = n1stPortOfcCd;
		this.dvsRqstSmtFlg = dvsRqstSmtFlg;
		this.euStfFlg = euStfFlg;
		this.initEtaDtModiFlg = initEtaDtModiFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("edi_rcv_dt", getEdiRcvDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("rvis_n1st_clpt_cd", getRvisN1stClptCd());
		this.hashColumns.put("edi_rcv_seq", getEdiRcvSeq());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("rgst_dt", getRgstDt());
		this.hashColumns.put("init_eta_dt", getInitEtaDt());
		this.hashColumns.put("cstms_yd_cd", getCstmsYdCd());
		this.hashColumns.put("rgst_port_cd", getRgstPortCd());
		this.hashColumns.put("n1st_clpt_cd", getN1stClptCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("grs_rgst_tong_wgt", getGrsRgstTongWgt());
		this.hashColumns.put("nxt_clpt_cd", getNxtClptCd());
		this.hashColumns.put("cvy_ref_no", getCvyRefNo());
		this.hashColumns.put("piclb_desc", getPiclbDesc());
		this.hashColumns.put("edi_rcv_dt_gmt", getEdiRcvDtGmt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("rvis_cstms_yd_cd", getRvisCstmsYdCd());
		this.hashColumns.put("rgst_no", getRgstNo());
		this.hashColumns.put("tml_nm", getTmlNm());
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("an_edi_svc_flg", getAnEdiSvcFlg());
		this.hashColumns.put("edi", getEdi());
		this.hashColumns.put("edi_rcv_dt_msg", getEdiRcvDtMsg());
		this.hashColumns.put("arr_port_cd", getArrPortCd());
		this.hashColumns.put("snd_dt_gmt", getSndDtGmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("n1st_port_ofc_cd_new", getN1stPortOfcCdNew());
		this.hashColumns.put("ata_dt", getAtaDt());
		this.hashColumns.put("upd_dt_gmt", getUpdDtGmt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("net_rgst_tong_wgt", getNetRgstTongWgt());
		this.hashColumns.put("dvs_rqst_edi_svc_flg", getDvsRqstEdiSvcFlg());
		this.hashColumns.put("ack", getAck());
		this.hashColumns.put("snd_ofc_cd", getSndOfcCd());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("lst_clpt_cd", getLstClptCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cvy_ref_no_hidden", getCvyRefNoHidden());
		this.hashColumns.put("n1st_port_ofc_cd", getN1stPortOfcCd());
		this.hashColumns.put("dvs_rqst_smt_flg", getDvsRqstSmtFlg());
		this.hashColumns.put("eu_stf_flg", getEuStfFlg());
		this.hashColumns.put("init_eta_dt_modi_flg", getInitEtaDtModiFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("edi_rcv_dt", "ediRcvDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("rvis_n1st_clpt_cd", "rvisN1stClptCd");
		this.hashFields.put("edi_rcv_seq", "ediRcvSeq");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("rgst_dt", "rgstDt");
		this.hashFields.put("init_eta_dt", "initEtaDt");
		this.hashFields.put("cstms_yd_cd", "cstmsYdCd");
		this.hashFields.put("rgst_port_cd", "rgstPortCd");
		this.hashFields.put("n1st_clpt_cd", "n1stClptCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("grs_rgst_tong_wgt", "grsRgstTongWgt");
		this.hashFields.put("nxt_clpt_cd", "nxtClptCd");
		this.hashFields.put("cvy_ref_no", "cvyRefNo");
		this.hashFields.put("piclb_desc", "piclbDesc");
		this.hashFields.put("edi_rcv_dt_gmt", "ediRcvDtGmt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("rvis_cstms_yd_cd", "rvisCstmsYdCd");
		this.hashFields.put("rgst_no", "rgstNo");
		this.hashFields.put("tml_nm", "tmlNm");
		this.hashFields.put("result", "result");
		this.hashFields.put("an_edi_svc_flg", "anEdiSvcFlg");
		this.hashFields.put("edi", "edi");
		this.hashFields.put("edi_rcv_dt_msg", "ediRcvDtMsg");
		this.hashFields.put("arr_port_cd", "arrPortCd");
		this.hashFields.put("snd_dt_gmt", "sndDtGmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("n1st_port_ofc_cd_new", "n1stPortOfcCdNew");
		this.hashFields.put("ata_dt", "ataDt");
		this.hashFields.put("upd_dt_gmt", "updDtGmt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("net_rgst_tong_wgt", "netRgstTongWgt");
		this.hashFields.put("dvs_rqst_edi_svc_flg", "dvsRqstEdiSvcFlg");
		this.hashFields.put("ack", "ack");
		this.hashFields.put("snd_ofc_cd", "sndOfcCd");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("lst_clpt_cd", "lstClptCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cvy_ref_no_hidden", "cvyRefNoHidden");
		this.hashFields.put("n1st_port_ofc_cd", "n1stPortOfcCd");
		this.hashFields.put("dvs_rqst_smt_flg", "dvsRqstSmtFlg");
		this.hashFields.put("eu_stf_flg", "euStfFlg");
		this.hashFields.put("init_eta_dt_modi_flg", "initEtaDtModiFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ediRcvDt
	 */
	public String getEdiRcvDt() {
		return this.ediRcvDt;
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
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return rvisN1stClptCd
	 */
	public String getRvisN1stClptCd() {
		return this.rvisN1stClptCd;
	}
	
	/**
	 * Column Info
	 * @return ediRcvSeq
	 */
	public String getEdiRcvSeq() {
		return this.ediRcvSeq;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
	}
	
	/**
	 * Column Info
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return cstmsPortCd
	 */
	public String getCstmsPortCd() {
		return this.cstmsPortCd;
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
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rgstDt
	 */
	public String getRgstDt() {
		return this.rgstDt;
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
	 * @return cstmsYdCd
	 */
	public String getCstmsYdCd() {
		return this.cstmsYdCd;
	}
	
	/**
	 * Column Info
	 * @return rgstPortCd
	 */
	public String getRgstPortCd() {
		return this.rgstPortCd;
	}
	
	/**
	 * Column Info
	 * @return n1stClptCd
	 */
	public String getN1stClptCd() {
		return this.n1stClptCd;
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
	 * @return grsRgstTongWgt
	 */
	public String getGrsRgstTongWgt() {
		return this.grsRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @return nxtClptCd
	 */
	public String getNxtClptCd() {
		return this.nxtClptCd;
	}
	
	/**
	 * Column Info
	 * @return cvyRefNo
	 */
	public String getCvyRefNo() {
		return this.cvyRefNo;
	}
	
	/**
	 * Column Info
	 * @return piclbDesc
	 */
	public String getPiclbDesc() {
		return this.piclbDesc;
	}
	
	/**
	 * Column Info
	 * @return ediRcvDtGmt
	 */
	public String getEdiRcvDtGmt() {
		return this.ediRcvDtGmt;
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
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
	}
	
	/**
	 * Column Info
	 * @return lloydNo
	 */
	public String getLloydNo() {
		return this.lloydNo;
	}
	
	/**
	 * Column Info
	 * @return rvisCstmsYdCd
	 */
	public String getRvisCstmsYdCd() {
		return this.rvisCstmsYdCd;
	}
	
	/**
	 * Column Info
	 * @return rgstNo
	 */
	public String getRgstNo() {
		return this.rgstNo;
	}
	
	/**
	 * Column Info
	 * @return tmlNm
	 */
	public String getTmlNm() {
		return this.tmlNm;
	}
	
	/**
	 * Column Info
	 * @return result
	 */
	public String getResult() {
		return this.result;
	}
	
	/**
	 * Column Info
	 * @return anEdiSvcFlg
	 */
	public String getAnEdiSvcFlg() {
		return this.anEdiSvcFlg;
	}
	
	/**
	 * Column Info
	 * @return edi
	 */
	public String getEdi() {
		return this.edi;
	}
	
	/**
	 * Column Info
	 * @return ediRcvDtMsg
	 */
	public String getEdiRcvDtMsg() {
		return this.ediRcvDtMsg;
	}
	
	/**
	 * Column Info
	 * @return arrPortCd
	 */
	public String getArrPortCd() {
		return this.arrPortCd;
	}
	
	/**
	 * Column Info
	 * @return sndDtGmt
	 */
	public String getSndDtGmt() {
		return this.sndDtGmt;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return n1stPortOfcCdNew
	 */
	public String getN1stPortOfcCdNew() {
		return this.n1stPortOfcCdNew;
	}
	
	/**
	 * Column Info
	 * @return ataDt
	 */
	public String getAtaDt() {
		return this.ataDt;
	}
	
	/**
	 * Column Info
	 * @return updDtGmt
	 */
	public String getUpdDtGmt() {
		return this.updDtGmt;
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
	 * @return netRgstTongWgt
	 */
	public String getNetRgstTongWgt() {
		return this.netRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @return dvsRqstEdiSvcFlg
	 */
	public String getDvsRqstEdiSvcFlg() {
		return this.dvsRqstEdiSvcFlg;
	}
	
	/**
	 * Column Info
	 * @return ack
	 */
	public String getAck() {
		return this.ack;
	}
	
	/**
	 * Column Info
	 * @return sndOfcCd
	 */
	public String getSndOfcCd() {
		return this.sndOfcCd;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @return lstClptCd
	 */
	public String getLstClptCd() {
		return this.lstClptCd;
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
	 * @return cvyRefNoHidden
	 */
	public String getCvyRefNoHidden() {
		return this.cvyRefNoHidden;
	}
	
	/**
	 * Column Info
	 * @return n1stPortOfcCd
	 */
	public String getN1stPortOfcCd() {
		return this.n1stPortOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dvsRqstSmtFlg
	 */
	public String getDvsRqstSmtFlg() {
		return this.dvsRqstSmtFlg;
	}
	
	/**
	 * Column Info
	 * @return euStfFlg
	 */
	public String getEuStfFlg() {
		return this.euStfFlg;
	}
	
	/**
	 * Column Info
	 * @return initEtaDtModiFlg
	 */
	public String getInitEtaDtModiFlg() {
		return this.initEtaDtModiFlg;
	}
	

	/**
	 * Column Info
	 * @param ediRcvDt
	 */
	public void setEdiRcvDt(String ediRcvDt) {
		this.ediRcvDt = ediRcvDt;
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
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param rvisN1stClptCd
	 */
	public void setRvisN1stClptCd(String rvisN1stClptCd) {
		this.rvisN1stClptCd = rvisN1stClptCd;
	}
	
	/**
	 * Column Info
	 * @param ediRcvSeq
	 */
	public void setEdiRcvSeq(String ediRcvSeq) {
		this.ediRcvSeq = ediRcvSeq;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
	}
	
	/**
	 * Column Info
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param cstmsPortCd
	 */
	public void setCstmsPortCd(String cstmsPortCd) {
		this.cstmsPortCd = cstmsPortCd;
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
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rgstDt
	 */
	public void setRgstDt(String rgstDt) {
		this.rgstDt = rgstDt;
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
	 * @param cstmsYdCd
	 */
	public void setCstmsYdCd(String cstmsYdCd) {
		this.cstmsYdCd = cstmsYdCd;
	}
	
	/**
	 * Column Info
	 * @param rgstPortCd
	 */
	public void setRgstPortCd(String rgstPortCd) {
		this.rgstPortCd = rgstPortCd;
	}
	
	/**
	 * Column Info
	 * @param n1stClptCd
	 */
	public void setN1stClptCd(String n1stClptCd) {
		this.n1stClptCd = n1stClptCd;
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
	 * @param grsRgstTongWgt
	 */
	public void setGrsRgstTongWgt(String grsRgstTongWgt) {
		this.grsRgstTongWgt = grsRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @param nxtClptCd
	 */
	public void setNxtClptCd(String nxtClptCd) {
		this.nxtClptCd = nxtClptCd;
	}
	
	/**
	 * Column Info
	 * @param cvyRefNo
	 */
	public void setCvyRefNo(String cvyRefNo) {
		this.cvyRefNo = cvyRefNo;
	}
	
	/**
	 * Column Info
	 * @param piclbDesc
	 */
	public void setPiclbDesc(String piclbDesc) {
		this.piclbDesc = piclbDesc;
	}
	
	/**
	 * Column Info
	 * @param ediRcvDtGmt
	 */
	public void setEdiRcvDtGmt(String ediRcvDtGmt) {
		this.ediRcvDtGmt = ediRcvDtGmt;
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
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
	}
	
	/**
	 * Column Info
	 * @param lloydNo
	 */
	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
	}
	
	/**
	 * Column Info
	 * @param rvisCstmsYdCd
	 */
	public void setRvisCstmsYdCd(String rvisCstmsYdCd) {
		this.rvisCstmsYdCd = rvisCstmsYdCd;
	}
	
	/**
	 * Column Info
	 * @param rgstNo
	 */
	public void setRgstNo(String rgstNo) {
		this.rgstNo = rgstNo;
	}
	
	/**
	 * Column Info
	 * @param tmlNm
	 */
	public void setTmlNm(String tmlNm) {
		this.tmlNm = tmlNm;
	}
	
	/**
	 * Column Info
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * Column Info
	 * @param anEdiSvcFlg
	 */
	public void setAnEdiSvcFlg(String anEdiSvcFlg) {
		this.anEdiSvcFlg = anEdiSvcFlg;
	}
	
	/**
	 * Column Info
	 * @param edi
	 */
	public void setEdi(String edi) {
		this.edi = edi;
	}
	
	/**
	 * Column Info
	 * @param ediRcvDtMsg
	 */
	public void setEdiRcvDtMsg(String ediRcvDtMsg) {
		this.ediRcvDtMsg = ediRcvDtMsg;
	}
	
	/**
	 * Column Info
	 * @param arrPortCd
	 */
	public void setArrPortCd(String arrPortCd) {
		this.arrPortCd = arrPortCd;
	}
	
	/**
	 * Column Info
	 * @param sndDtGmt
	 */
	public void setSndDtGmt(String sndDtGmt) {
		this.sndDtGmt = sndDtGmt;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param n1stPortOfcCdNew
	 */
	public void setN1stPortOfcCdNew(String n1stPortOfcCdNew) {
		this.n1stPortOfcCdNew = n1stPortOfcCdNew;
	}
	
	/**
	 * Column Info
	 * @param ataDt
	 */
	public void setAtaDt(String ataDt) {
		this.ataDt = ataDt;
	}
	
	/**
	 * Column Info
	 * @param updDtGmt
	 */
	public void setUpdDtGmt(String updDtGmt) {
		this.updDtGmt = updDtGmt;
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
	 * @param netRgstTongWgt
	 */
	public void setNetRgstTongWgt(String netRgstTongWgt) {
		this.netRgstTongWgt = netRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @param dvsRqstEdiSvcFlg
	 */
	public void setDvsRqstEdiSvcFlg(String dvsRqstEdiSvcFlg) {
		this.dvsRqstEdiSvcFlg = dvsRqstEdiSvcFlg;
	}
	
	/**
	 * Column Info
	 * @param ack
	 */
	public void setAck(String ack) {
		this.ack = ack;
	}
	
	/**
	 * Column Info
	 * @param sndOfcCd
	 */
	public void setSndOfcCd(String sndOfcCd) {
		this.sndOfcCd = sndOfcCd;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	
	/**
	 * Column Info
	 * @param lstClptCd
	 */
	public void setLstClptCd(String lstClptCd) {
		this.lstClptCd = lstClptCd;
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
	 * @param cvyRefNoHidden
	 */
	public void setCvyRefNoHidden(String cvyRefNoHidden) {
		this.cvyRefNoHidden = cvyRefNoHidden;
	}
	
	/**
	 * Column Info
	 * @param n1stPortOfcCd
	 */
	public void setN1stPortOfcCd(String n1stPortOfcCd) {
		this.n1stPortOfcCd = n1stPortOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dvsRqstSmtFlg
	 */
	public void setDvsRqstSmtFlg(String dvsRqstSmtFlg) {
		this.dvsRqstSmtFlg = dvsRqstSmtFlg;
	}
	
	/**
	 * Column Info
	 * @param euStfFlg
	 */
	public void setEuStfFlg (String euStfFlg){
		this.euStfFlg = euStfFlg;
	}
	
	/**
	 * Column Info
	 * @param initEtaDtModiFlg
	 */
	public void setInitEtaDtModiFlg(String initEtaDtModiFlg){
		this.initEtaDtModiFlg = initEtaDtModiFlg;
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
		setEdiRcvDt(JSPUtil.getParameter(request, prefix + "edi_rcv_dt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setRvisN1stClptCd(JSPUtil.getParameter(request, prefix + "rvis_n1st_clpt_cd", ""));
		setEdiRcvSeq(JSPUtil.getParameter(request, prefix + "edi_rcv_seq", ""));
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		setTmlCd(JSPUtil.getParameter(request, prefix + "tml_cd", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setRgstDt(JSPUtil.getParameter(request, prefix + "rgst_dt", ""));
		setInitEtaDt(JSPUtil.getParameter(request, prefix + "init_eta_dt", ""));
		setCstmsYdCd(JSPUtil.getParameter(request, prefix + "cstms_yd_cd", ""));
		setRgstPortCd(JSPUtil.getParameter(request, prefix + "rgst_port_cd", ""));
		setN1stClptCd(JSPUtil.getParameter(request, prefix + "n1st_clpt_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setGrsRgstTongWgt(JSPUtil.getParameter(request, prefix + "grs_rgst_tong_wgt", ""));
		setNxtClptCd(JSPUtil.getParameter(request, prefix + "nxt_clpt_cd", ""));
		setCvyRefNo(JSPUtil.getParameter(request, prefix + "cvy_ref_no", ""));
		setPiclbDesc(JSPUtil.getParameter(request, prefix + "piclb_desc", ""));
		setEdiRcvDtGmt(JSPUtil.getParameter(request, prefix + "edi_rcv_dt_gmt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setSndUsrId(JSPUtil.getParameter(request, prefix + "snd_usr_id", ""));
		setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
		setRvisCstmsYdCd(JSPUtil.getParameter(request, prefix + "rvis_cstms_yd_cd", ""));
		setRgstNo(JSPUtil.getParameter(request, prefix + "rgst_no", ""));
		setTmlNm(JSPUtil.getParameter(request, prefix + "tml_nm", ""));
		setResult(JSPUtil.getParameter(request, prefix + "result", ""));
		setAnEdiSvcFlg(JSPUtil.getParameter(request, prefix + "an_edi_svc_flg", ""));
		setEdi(JSPUtil.getParameter(request, prefix + "edi", ""));
		setEdiRcvDtMsg(JSPUtil.getParameter(request, prefix + "edi_rcv_dt_msg", ""));
		setArrPortCd(JSPUtil.getParameter(request, prefix + "arr_port_cd", ""));
		setSndDtGmt(JSPUtil.getParameter(request, prefix + "snd_dt_gmt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setN1stPortOfcCdNew(JSPUtil.getParameter(request, prefix + "n1st_port_ofc_cd_new", ""));
		setAtaDt(JSPUtil.getParameter(request, prefix + "ata_dt", ""));
		setUpdDtGmt(JSPUtil.getParameter(request, prefix + "upd_dt_gmt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setNetRgstTongWgt(JSPUtil.getParameter(request, prefix + "net_rgst_tong_wgt", ""));
		setDvsRqstEdiSvcFlg(JSPUtil.getParameter(request, prefix + "dvs_rqst_edi_svc_flg", ""));
		setAck(JSPUtil.getParameter(request, prefix + "ack", ""));
		setSndOfcCd(JSPUtil.getParameter(request, prefix + "snd_ofc_cd", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setLstClptCd(JSPUtil.getParameter(request, prefix + "lst_clpt_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCvyRefNoHidden(JSPUtil.getParameter(request, prefix + "cvy_ref_no_hidden", ""));
		setN1stPortOfcCd(JSPUtil.getParameter(request, prefix + "n1st_port_ofc_cd", ""));
		setDvsRqstSmtFlg(JSPUtil.getParameter(request, prefix + "dvs_rqst_smt_flg", ""));
		setEuStfFlg(JSPUtil.getParameter(request, prefix + "eu_stf_flg", ""));
		setInitEtaDtModiFlg(JSPUtil.getParameter(request, prefix + "init_eta_dt_modi_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Eur24VesselArrivalNoticeDetailVO[]
	 */
	public Eur24VesselArrivalNoticeDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Eur24VesselArrivalNoticeDetailVO[]
	 */
	public Eur24VesselArrivalNoticeDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Eur24VesselArrivalNoticeDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ediRcvDt = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] rvisN1stClptCd = (JSPUtil.getParameter(request, prefix	+ "rvis_n1st_clpt_cd", length));
			String[] ediRcvSeq = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_seq", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] rgstDt = (JSPUtil.getParameter(request, prefix	+ "rgst_dt", length));
			String[] initEtaDt = (JSPUtil.getParameter(request, prefix	+ "init_eta_dt", length));
			String[] cstmsYdCd = (JSPUtil.getParameter(request, prefix	+ "cstms_yd_cd", length));
			String[] rgstPortCd = (JSPUtil.getParameter(request, prefix	+ "rgst_port_cd", length));
			String[] n1stClptCd = (JSPUtil.getParameter(request, prefix	+ "n1st_clpt_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] grsRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "grs_rgst_tong_wgt", length));
			String[] nxtClptCd = (JSPUtil.getParameter(request, prefix	+ "nxt_clpt_cd", length));
			String[] cvyRefNo = (JSPUtil.getParameter(request, prefix	+ "cvy_ref_no", length));
			String[] piclbDesc = (JSPUtil.getParameter(request, prefix	+ "piclb_desc", length));
			String[] ediRcvDtGmt = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_dt_gmt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] rvisCstmsYdCd = (JSPUtil.getParameter(request, prefix	+ "rvis_cstms_yd_cd", length));
			String[] rgstNo = (JSPUtil.getParameter(request, prefix	+ "rgst_no", length));
			String[] tmlNm = (JSPUtil.getParameter(request, prefix	+ "tml_nm", length));
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] anEdiSvcFlg = (JSPUtil.getParameter(request, prefix	+ "an_edi_svc_flg", length));
			String[] edi = (JSPUtil.getParameter(request, prefix	+ "edi", length));
			String[] ediRcvDtMsg = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_dt_msg", length));
			String[] arrPortCd = (JSPUtil.getParameter(request, prefix	+ "arr_port_cd", length));
			String[] sndDtGmt = (JSPUtil.getParameter(request, prefix	+ "snd_dt_gmt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] n1stPortOfcCdNew = (JSPUtil.getParameter(request, prefix	+ "n1st_port_ofc_cd_new", length));
			String[] ataDt = (JSPUtil.getParameter(request, prefix	+ "ata_dt", length));
			String[] updDtGmt = (JSPUtil.getParameter(request, prefix	+ "upd_dt_gmt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] netRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "net_rgst_tong_wgt", length));
			String[] dvsRqstEdiSvcFlg = (JSPUtil.getParameter(request, prefix	+ "dvs_rqst_edi_svc_flg", length));
			String[] ack = (JSPUtil.getParameter(request, prefix	+ "ack", length));
			String[] sndOfcCd = (JSPUtil.getParameter(request, prefix	+ "snd_ofc_cd", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] lstClptCd = (JSPUtil.getParameter(request, prefix	+ "lst_clpt_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] cvyRefNoHidden = (JSPUtil.getParameter(request, prefix	+ "cvy_ref_no_hidden", length));
			String[] n1stPortOfcCd = (JSPUtil.getParameter(request, prefix	+ "n1st_port_ofc_cd", length));
			String[] dvsRqstSmtFlg = (JSPUtil.getParameter(request, prefix	+ "dvs_rqst_smt_flg", length));
			String[] euStfFlg = (JSPUtil.getParameter(request, prefix	+ "eu_stf_flg", length));
			String[] initEtaDtModiFlg = (JSPUtil.getParameter(request, prefix	+ "init_eta_dt_modi_flg", length));

			
			for (int i = 0; i < length; i++) {
				model = new Eur24VesselArrivalNoticeDetailVO();
				if (ediRcvDt[i] != null)
					model.setEdiRcvDt(ediRcvDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (rvisN1stClptCd[i] != null)
					model.setRvisN1stClptCd(rvisN1stClptCd[i]);
				if (ediRcvSeq[i] != null)
					model.setEdiRcvSeq(ediRcvSeq[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (rgstDt[i] != null)
					model.setRgstDt(rgstDt[i]);
				if (initEtaDt[i] != null)
					model.setInitEtaDt(initEtaDt[i]);
				if (cstmsYdCd[i] != null)
					model.setCstmsYdCd(cstmsYdCd[i]);
				if (rgstPortCd[i] != null)
					model.setRgstPortCd(rgstPortCd[i]);
				if (n1stClptCd[i] != null)
					model.setN1stClptCd(n1stClptCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (grsRgstTongWgt[i] != null)
					model.setGrsRgstTongWgt(grsRgstTongWgt[i]);
				if (nxtClptCd[i] != null)
					model.setNxtClptCd(nxtClptCd[i]);
				if (cvyRefNo[i] != null)
					model.setCvyRefNo(cvyRefNo[i]);
				if (piclbDesc[i] != null)
					model.setPiclbDesc(piclbDesc[i]);
				if (ediRcvDtGmt[i] != null)
					model.setEdiRcvDtGmt(ediRcvDtGmt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (rvisCstmsYdCd[i] != null)
					model.setRvisCstmsYdCd(rvisCstmsYdCd[i]);
				if (rgstNo[i] != null)
					model.setRgstNo(rgstNo[i]);
				if (tmlNm[i] != null)
					model.setTmlNm(tmlNm[i]);
				if (result[i] != null)
					model.setResult(result[i]);
				if (anEdiSvcFlg[i] != null)
					model.setAnEdiSvcFlg(anEdiSvcFlg[i]);
				if (edi[i] != null)
					model.setEdi(edi[i]);
				if (ediRcvDtMsg[i] != null)
					model.setEdiRcvDtMsg(ediRcvDtMsg[i]);
				if (arrPortCd[i] != null)
					model.setArrPortCd(arrPortCd[i]);
				if (sndDtGmt[i] != null)
					model.setSndDtGmt(sndDtGmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (n1stPortOfcCdNew[i] != null)
					model.setN1stPortOfcCdNew(n1stPortOfcCdNew[i]);
				if (ataDt[i] != null)
					model.setAtaDt(ataDt[i]);
				if (updDtGmt[i] != null)
					model.setUpdDtGmt(updDtGmt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (netRgstTongWgt[i] != null)
					model.setNetRgstTongWgt(netRgstTongWgt[i]);
				if (dvsRqstEdiSvcFlg[i] != null)
					model.setDvsRqstEdiSvcFlg(dvsRqstEdiSvcFlg[i]);
				if (ack[i] != null)
					model.setAck(ack[i]);
				if (sndOfcCd[i] != null)
					model.setSndOfcCd(sndOfcCd[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (lstClptCd[i] != null)
					model.setLstClptCd(lstClptCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (cvyRefNoHidden[i] != null)
					model.setCvyRefNoHidden(cvyRefNoHidden[i]);
				if (n1stPortOfcCd[i] != null)
					model.setN1stPortOfcCd(n1stPortOfcCd[i]);
				if (dvsRqstSmtFlg[i] != null)
					model.setDvsRqstSmtFlg(dvsRqstSmtFlg[i]);
				if (euStfFlg[i] != null)
					model.setEuStfFlg(euStfFlg[i]);
				if(initEtaDtModiFlg[i] != null)
					model.setInitEtaDtModiFlg(initEtaDtModiFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEur24VesselArrivalNoticeDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Eur24VesselArrivalNoticeDetailVO[]
	 */
	public Eur24VesselArrivalNoticeDetailVO[] getEur24VesselArrivalNoticeDetailVOs(){
		Eur24VesselArrivalNoticeDetailVO[] vos = (Eur24VesselArrivalNoticeDetailVO[])models.toArray(new Eur24VesselArrivalNoticeDetailVO[models.size()]);
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
		this.ediRcvDt = this.ediRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisN1stClptCd = this.rvisN1stClptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvSeq = this.ediRcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstDt = this.rgstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtaDt = this.initEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsYdCd = this.cstmsYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstPortCd = this.rgstPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stClptCd = this.n1stClptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRgstTongWgt = this.grsRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtClptCd = this.nxtClptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvyRefNo = this.cvyRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.piclbDesc = this.piclbDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvDtGmt = this.ediRcvDtGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCstmsYdCd = this.rvisCstmsYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstNo = this.rgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlNm = this.tmlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anEdiSvcFlg = this.anEdiSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edi = this.edi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvDtMsg = this.ediRcvDtMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrPortCd = this.arrPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDtGmt = this.sndDtGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPortOfcCdNew = this.n1stPortOfcCdNew .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ataDt = this.ataDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDtGmt = this.updDtGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netRgstTongWgt = this.netRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvsRqstEdiSvcFlg = this.dvsRqstEdiSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ack = this.ack .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndOfcCd = this.sndOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstClptCd = this.lstClptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvyRefNoHidden = this.cvyRefNoHidden .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPortOfcCd = this.n1stPortOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvsRqstSmtFlg = this.dvsRqstSmtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.euStfFlg = this.euStfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtaDtModiFlg = this.initEtaDtModiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
