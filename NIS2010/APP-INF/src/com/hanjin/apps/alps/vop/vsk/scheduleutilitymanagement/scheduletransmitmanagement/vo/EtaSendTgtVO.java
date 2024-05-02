/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EtaSendTgtVO.java
*@FileTitle : EtaSendTgtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.24
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.12.24 진마리아 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.vo;

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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EtaSendTgtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EtaSendTgtVO> models = new ArrayList<EtaSendTgtVO>();
	
	/* Column Info */
	private String trsmDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String autoFaxPop = null;
	/* Column Info */
	private String crntRpmPwr = null;
	
	/* Column Info */
	private String sndrEml 		= null;
	/* Column Info */
	private String sndrNm 		= null;
	/* Column Info */
	private String sndrPhnNo	= null;
	/* Column Info */
	private String lanePicEml	= null;	
	
	/* Column Info */
	private String dfltFaxImstCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String portNm = null;
	/* Column Info */
	private String skdTrsmStsNm = null;
	/* Column Info */
	private String toEtaDt = null;
	/* Column Info */
	private String vslTlxTrsmEml = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String dfltImstCd = null;
	/* Column Info */
	private String ntcEtdDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String dfltTlxImstCd = null;
	/* Column Info */
	private String orgRpmPwr = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String faxImstCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String loclUpdDt = null;
	/* Column Info */
	private String trsmLoclDt = null;
	/* Column Info */
	private String fbEml = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String vslEml = null;
	/* Column Info */
	private String trsmOwnrCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vslFaxNo = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String rpmAdjDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String trsmMzdCd = null;
	/* Column Info */
	private String ntcEtaDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String tlxImstCd = null;
	/* Column Info */
	private String vslFaxTrsmEml = null;
	/* Column Info */
	private String ntcEtbDt = null;
	/* Column Info */
	private String skdTrsmStsCd = null;
	/* Column Info */
	private String loclCreDt = null;
	/* Column Info */
	private String emlSndNo = null;
	/* Column Info */
	private String vslTlxNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String fmEtaDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String actCrrCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String emlSeq = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String trsmRsn = null;
	/* Column Info */
	private String imstCd = null;
	/* Column Info */
	private String trsmPurpCd = null;	
	/* Column Info */
	private String trsmHisSeq = null;
	/* Column Info */
	private String esvcVndrSeq = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EtaSendTgtVO() {}

	public EtaSendTgtVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String clptIndSeq, String trsmPurpCd, String trsmHisSeq, String ydCd, String trsmMzdCd, String trsmOwnrCd, String slanCd, String actCrrCd, String vpsEtaDt, String vpsEtbDt, String vpsEtdDt, String ntcEtaDt, String ntcEtbDt, String ntcEtdDt, String trsmRsn, String vslFaxNo, String vslTlxNo, String vslEml, String imstCd, String vslFaxTrsmEml, String vslTlxTrsmEml, String trsmLoclDt, String trsmDt, String skdTrsmStsCd, String rpmAdjDt, String orgRpmPwr, String crntRpmPwr, String esvcVndrSeq, String creUsrId, String loclCreDt, String creDt, String updUsrId, String loclUpdDt, String updDt, String emlSeq, String usrEml, String fmEtaDt, String toEtaDt, String vvd, String ydNm, String vslEngNm, String portNm, String autoFaxPop, String dfltImstCd, String ofcCd, String skdTrsmStsNm, String faxImstCd, String tlxImstCd, String dfltFaxImstCd, String dfltTlxImstCd, String sndrEml, String sndrNm, String sndrPhnNo, String lanePicEml, String emlSndNo, String fbEml) {
		this.trsmDt = trsmDt;
		this.vslCd = vslCd;
		this.autoFaxPop = autoFaxPop;
		this.crntRpmPwr = crntRpmPwr;
		
		this.sndrEml 	= sndrEml;
		this.sndrNm  	= sndrNm;
		this.sndrPhnNo 	= sndrPhnNo;
		this.lanePicEml = lanePicEml;
		
		this.dfltFaxImstCd = dfltFaxImstCd;
		this.pagerows = pagerows;
		this.vpsPortCd = vpsPortCd;
		this.portNm = portNm;
		this.skdTrsmStsNm = skdTrsmStsNm;
		this.toEtaDt = toEtaDt;
		this.vslTlxTrsmEml = vslTlxTrsmEml;
		this.usrEml = usrEml;
		this.dfltImstCd = dfltImstCd;
		this.ntcEtdDt = ntcEtdDt;
		this.updUsrId = updUsrId;
		this.vpsEtdDt = vpsEtdDt;
		this.dfltTlxImstCd = dfltTlxImstCd;
		this.orgRpmPwr = orgRpmPwr;
		this.skdVoyNo = skdVoyNo;
		this.faxImstCd = faxImstCd;
		this.vvd = vvd;
		this.creUsrId = creUsrId;
		this.ydNm = ydNm;
		this.loclUpdDt = loclUpdDt;
		this.trsmLoclDt = trsmLoclDt;
		this.fbEml = fbEml;
		this.vpsEtbDt = vpsEtbDt;
		this.vslEml = vslEml;
		this.trsmOwnrCd = trsmOwnrCd;
		this.creDt = creDt;
		this.vslFaxNo = vslFaxNo;
		this.vpsEtaDt = vpsEtaDt;
		this.rpmAdjDt = rpmAdjDt;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.trsmMzdCd = trsmMzdCd;
		this.ntcEtaDt = ntcEtaDt;
		this.updDt = updDt;
		this.tlxImstCd = tlxImstCd;
		this.vslFaxTrsmEml = vslFaxTrsmEml;
		this.ntcEtbDt = ntcEtbDt;
		this.skdTrsmStsCd = skdTrsmStsCd;
		this.loclCreDt = loclCreDt;
		this.emlSndNo = emlSndNo;
		this.vslTlxNo = vslTlxNo;
		this.skdDirCd = skdDirCd;
		this.fmEtaDt = fmEtaDt;
		this.ofcCd = ofcCd;
		this.actCrrCd = actCrrCd;
		this.slanCd = slanCd;
		this.ydCd = ydCd;
		this.emlSeq = emlSeq;
		this.clptIndSeq = clptIndSeq;
		this.trsmRsn = trsmRsn;
		this.imstCd = imstCd;
		
		this.trsmPurpCd = trsmPurpCd;		
		this.trsmHisSeq = trsmHisSeq;
		this.esvcVndrSeq = esvcVndrSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trsm_dt", getTrsmDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("auto_fax_pop", getAutoFaxPop());
		this.hashColumns.put("crnt_rpm_pwr", getCrntRpmPwr());
		
		this.hashColumns.put("sndr_eml"		, getSndrEml	());
		this.hashColumns.put("sndr_nm"		, getSndrNm		());
		this.hashColumns.put("sndr_phn_no"	, getSndrPhnNo	());
		this.hashColumns.put("lane_pic_eml"	, getLanePicEml	());
		
		this.hashColumns.put("dflt_fax_imst_cd", getDfltFaxImstCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("port_nm", getPortNm());
		this.hashColumns.put("skd_trsm_sts_nm", getSkdTrsmStsNm());
		this.hashColumns.put("to_eta_dt", getToEtaDt());
		this.hashColumns.put("vsl_tlx_trsm_eml", getVslTlxTrsmEml());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("dflt_imst_cd", getDfltImstCd());
		this.hashColumns.put("ntc_etd_dt", getNtcEtdDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("dflt_tlx_imst_cd", getDfltTlxImstCd());
		this.hashColumns.put("org_rpm_pwr", getOrgRpmPwr());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("fax_imst_cd", getFaxImstCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("locl_upd_dt", getLoclUpdDt());
		this.hashColumns.put("trsm_locl_dt", getTrsmLoclDt());
		this.hashColumns.put("fb_eml", getFbEml());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("vsl_eml", getVslEml());
		this.hashColumns.put("trsm_ownr_cd", getTrsmOwnrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vsl_fax_no", getVslFaxNo());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("rpm_adj_dt", getRpmAdjDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("trsm_mzd_cd", getTrsmMzdCd());
		this.hashColumns.put("ntc_eta_dt", getNtcEtaDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("tlx_imst_cd", getTlxImstCd());
		this.hashColumns.put("vsl_fax_trsm_eml", getVslFaxTrsmEml());
		this.hashColumns.put("ntc_etb_dt", getNtcEtbDt());
		this.hashColumns.put("skd_trsm_sts_cd", getSkdTrsmStsCd());
		this.hashColumns.put("locl_cre_dt", getLoclCreDt());
		this.hashColumns.put("eml_snd_no", getEmlSndNo());
		this.hashColumns.put("vsl_tlx_no", getVslTlxNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("fm_eta_dt", getFmEtaDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("act_crr_cd", getActCrrCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("eml_seq", getEmlSeq());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("trsm_rsn", getTrsmRsn());
		this.hashColumns.put("imst_cd", getImstCd());
		
		this.hashColumns.put("trsm_purp_cd", getTrsmPurpCd());
		this.hashColumns.put("trsm_his_seq", getTrsmHisSeq());
		this.hashColumns.put("esvc_vndr_seq", getEsvcVndrSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trsm_dt", "trsmDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("auto_fax_pop", "autoFaxPop");
		this.hashFields.put("crnt_rpm_pwr", "crntRpmPwr");
		
		this.hashFields.put("sndr_eml"		, "sndrEml"		);
		this.hashFields.put("sndr_nm"		, "sndrNm"		);
		this.hashFields.put("sndr_phn_no"	, "sndrPhnNo"	);
		this.hashFields.put("lane_pic_eml"	, "lanePicEml"	);
		
		this.hashFields.put("dflt_fax_imst_cd", "dfltFaxImstCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("port_nm", "portNm");
		this.hashFields.put("skd_trsm_sts_nm", "skdTrsmStsNm");
		this.hashFields.put("to_eta_dt", "toEtaDt");
		this.hashFields.put("vsl_tlx_trsm_eml", "vslTlxTrsmEml");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("dflt_imst_cd", "dfltImstCd");
		this.hashFields.put("ntc_etd_dt", "ntcEtdDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("dflt_tlx_imst_cd", "dfltTlxImstCd");
		this.hashFields.put("org_rpm_pwr", "orgRpmPwr");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("fax_imst_cd", "faxImstCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("locl_upd_dt", "loclUpdDt");
		this.hashFields.put("trsm_locl_dt", "trsmLoclDt");
		this.hashFields.put("fb_eml", "fbEml");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("vsl_eml", "vslEml");
		this.hashFields.put("trsm_ownr_cd", "trsmOwnrCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vsl_fax_no", "vslFaxNo");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("rpm_adj_dt", "rpmAdjDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("trsm_mzd_cd", "trsmMzdCd");
		this.hashFields.put("ntc_eta_dt", "ntcEtaDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("tlx_imst_cd", "tlxImstCd");
		this.hashFields.put("vsl_fax_trsm_eml", "vslFaxTrsmEml");
		this.hashFields.put("ntc_etb_dt", "ntcEtbDt");
		this.hashFields.put("skd_trsm_sts_cd", "skdTrsmStsCd");
		this.hashFields.put("locl_cre_dt", "loclCreDt");
		this.hashFields.put("eml_snd_no", "emlSndNo");
		this.hashFields.put("vsl_tlx_no", "vslTlxNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("fm_eta_dt", "fmEtaDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("act_crr_cd", "actCrrCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("eml_seq", "emlSeq");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("trsm_rsn", "trsmRsn");
		this.hashFields.put("imst_cd", "imstCd");
		
		this.hashFields.put("trsm_purp_cd", "trsmPurpCd");
		this.hashFields.put("trsm_his_seq", "trsmHisSeq");
		this.hashFields.put("esvc_vndr_seq", "esvcVndrSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return trsmDt
	 */
	public String getTrsmDt() {
		return this.trsmDt;
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
	 * @return autoFaxPop
	 */
	public String getAutoFaxPop() {
		return this.autoFaxPop;
	}
	
	/**
	 * Column Info
	 * @return crntRpmPwr
	 */
	public String getCrntRpmPwr() {
		return this.crntRpmPwr;
	}
	
	/**
	 * Column Info
	 * @return sndrEml
	 */
	public String getSndrEml() {
		return this.sndrEml;
	}
	/**
	 * Column Info
	 * @return sndrNm
	 */
	public String getSndrNm() {
		return this.sndrNm;
	}	
	/**
	 * Column Info
	 * @return sndrPhnNo
	 */
	public String getSndrPhnNo() {
		return this.sndrPhnNo;
	}
	/**
	 * Column Info
	 * @return lanePicEml
	 */
	public String getLanePicEml() {
		return this.lanePicEml;
	}
	
	/**
	 * Column Info
	 * @return dfltFaxImstCd
	 */
	public String getDfltFaxImstCd() {
		return this.dfltFaxImstCd;
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
	 * @return portNm
	 */
	public String getPortNm() {
		return this.portNm;
	}
	
	/**
	 * Column Info
	 * @return skdTrsmStsNm
	 */
	public String getSkdTrsmStsNm() {
		return this.skdTrsmStsNm;
	}
	
	/**
	 * Column Info
	 * @return toEtaDt
	 */
	public String getToEtaDt() {
		return this.toEtaDt;
	}
	
	/**
	 * Column Info
	 * @return vslTlxTrsmEml
	 */
	public String getVslTlxTrsmEml() {
		return this.vslTlxTrsmEml;
	}
	
	/**
	 * Column Info
	 * @return usrEml
	 */
	public String getUsrEml() {
		return this.usrEml;
	}
	
	/**
	 * Column Info
	 * @return dfltImstCd
	 */
	public String getDfltImstCd() {
		return this.dfltImstCd;
	}
	
	/**
	 * Column Info
	 * @return ntcEtdDt
	 */
	public String getNtcEtdDt() {
		return this.ntcEtdDt;
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
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return dfltTlxImstCd
	 */
	public String getDfltTlxImstCd() {
		return this.dfltTlxImstCd;
	}
	
	/**
	 * Column Info
	 * @return orgRpmPwr
	 */
	public String getOrgRpmPwr() {
		return this.orgRpmPwr;
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
	 * @return faxImstCd
	 */
	public String getFaxImstCd() {
		return this.faxImstCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
	}
	
	/**
	 * Column Info
	 * @return loclUpdDt
	 */
	public String getLoclUpdDt() {
		return this.loclUpdDt;
	}
	
	/**
	 * Column Info
	 * @return trsmLoclDt
	 */
	public String getTrsmLoclDt() {
		return this.trsmLoclDt;
	}
	
	/**
	 * Column Info
	 * @return fbEml
	 */
	public String getFbEml() {
		return this.fbEml;
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
	 * @return vslEml
	 */
	public String getVslEml() {
		return this.vslEml;
	}
	
	/**
	 * Column Info
	 * @return trsmOwnrCd
	 */
	public String getTrsmOwnrCd() {
		return this.trsmOwnrCd;
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
	 * @return vslFaxNo
	 */
	public String getVslFaxNo() {
		return this.vslFaxNo;
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
	 * @return rpmAdjDt
	 */
	public String getRpmAdjDt() {
		return this.rpmAdjDt;
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
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return trsmMzdCd
	 */
	public String getTrsmMzdCd() {
		return this.trsmMzdCd;
	}
	
	/**
	 * Column Info
	 * @return ntcEtaDt
	 */
	public String getNtcEtaDt() {
		return this.ntcEtaDt;
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
	 * @return tlxImstCd
	 */
	public String getTlxImstCd() {
		return this.tlxImstCd;
	}
	
	/**
	 * Column Info
	 * @return vslFaxTrsmEml
	 */
	public String getVslFaxTrsmEml() {
		return this.vslFaxTrsmEml;
	}
	
	/**
	 * Column Info
	 * @return ntcEtbDt
	 */
	public String getNtcEtbDt() {
		return this.ntcEtbDt;
	}
	
	/**
	 * Column Info
	 * @return skdTrsmStsCd
	 */
	public String getSkdTrsmStsCd() {
		return this.skdTrsmStsCd;
	}
	
	/**
	 * Column Info
	 * @return loclCreDt
	 */
	public String getLoclCreDt() {
		return this.loclCreDt;
	}
	
	/**
	 * Column Info
	 * @return emlSndNo
	 */
	public String getEmlSndNo() {
		return this.emlSndNo;
	}
	
	/**
	 * Column Info
	 * @return vslTlxNo
	 */
	public String getVslTlxNo() {
		return this.vslTlxNo;
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
	 * @return fmEtaDt
	 */
	public String getFmEtaDt() {
		return this.fmEtaDt;
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
	 * @return actCrrCd
	 */
	public String getActCrrCd() {
		return this.actCrrCd;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return emlSeq
	 */
	public String getEmlSeq() {
		return this.emlSeq;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return trsmRsn
	 */
	public String getTrsmRsn() {
		return this.trsmRsn;
	}
	
	/**
	 * Column Info
	 * @return imstCd
	 */
	public String getImstCd() {
		return this.imstCd;
	}
	
	/**
	 * Column Info
	 * @return trsmPurpCd
	 */
	public String getTrsmPurpCd() {
		return this.trsmPurpCd;
	}
	
	/**
	 * Column Info
	 * @return trsmHisSeq
	 */
	public String getTrsmHisSeq() {
		return this.trsmHisSeq;
	}
	
	/**
	 * Column Info
	 * @return esvcVndrSeq
	 */
	public String getEsvcVndrSeq() {
		return this.esvcVndrSeq;
	}
	

	/**
	 * Column Info
	 * @param trsmDt
	 */
	public void setTrsmDt(String trsmDt) {
		this.trsmDt = trsmDt;
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
	 * @param autoFaxPop
	 */
	public void setAutoFaxPop(String autoFaxPop) {
		this.autoFaxPop = autoFaxPop;
	}
	
	/**
	 * Column Info
	 * @param crntRpmPwr
	 */
	public void setCrntRpmPwr(String crntRpmPwr) {
		this.crntRpmPwr = crntRpmPwr;
	}
	
	/**
	 * Column Info
	 * @param sndrEml
	 */
	public void setSndrEml	(String sndrEml) {
		this.sndrEml 		= sndrEml;
	}
	/**
	 * Column Info
	 * @param sndrNm
	 */
	public void setSndrNm	(String sndrNm) {
		this.sndrNm 		= sndrNm;
	}	/**
	 * Column Info
	 * @param sndrPhnNo
	 */
	public void setSndrPhnNo(String sndrPhnNo) {
		this.sndrPhnNo 		= sndrPhnNo;
	}
	/**
	 * Column Info
	 * @param lanePicEml
	 */
	public void setLanePicEml	(String lanePicEml) {
		this.lanePicEml 	= lanePicEml;
	}
	
	/**
	 * Column Info
	 * @param dfltFaxImstCd
	 */
	public void setDfltFaxImstCd(String dfltFaxImstCd) {
		this.dfltFaxImstCd = dfltFaxImstCd;
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
	 * @param portNm
	 */
	public void setPortNm(String portNm) {
		this.portNm = portNm;
	}
	
	/**
	 * Column Info
	 * @param skdTrsmStsNm
	 */
	public void setSkdTrsmStsNm(String skdTrsmStsNm) {
		this.skdTrsmStsNm = skdTrsmStsNm;
	}
	
	/**
	 * Column Info
	 * @param toEtaDt
	 */
	public void setToEtaDt(String toEtaDt) {
		this.toEtaDt = toEtaDt;
	}
	
	/**
	 * Column Info
	 * @param vslTlxTrsmEml
	 */
	public void setVslTlxTrsmEml(String vslTlxTrsmEml) {
		this.vslTlxTrsmEml = vslTlxTrsmEml;
	}
	
	/**
	 * Column Info
	 * @param usrEml
	 */
	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}
	
	/**
	 * Column Info
	 * @param dfltImstCd
	 */
	public void setDfltImstCd(String dfltImstCd) {
		this.dfltImstCd = dfltImstCd;
	}
	
	/**
	 * Column Info
	 * @param ntcEtdDt
	 */
	public void setNtcEtdDt(String ntcEtdDt) {
		this.ntcEtdDt = ntcEtdDt;
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
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param dfltTlxImstCd
	 */
	public void setDfltTlxImstCd(String dfltTlxImstCd) {
		this.dfltTlxImstCd = dfltTlxImstCd;
	}
	
	/**
	 * Column Info
	 * @param orgRpmPwr
	 */
	public void setOrgRpmPwr(String orgRpmPwr) {
		this.orgRpmPwr = orgRpmPwr;
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
	 * @param faxImstCd
	 */
	public void setFaxImstCd(String faxImstCd) {
		this.faxImstCd = faxImstCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
	}
	
	/**
	 * Column Info
	 * @param loclUpdDt
	 */
	public void setLoclUpdDt(String loclUpdDt) {
		this.loclUpdDt = loclUpdDt;
	}
	
	/**
	 * Column Info
	 * @param trsmLoclDt
	 */
	public void setTrsmLoclDt(String trsmLoclDt) {
		this.trsmLoclDt = trsmLoclDt;
	}
	
	/**
	 * Column Info
	 * @param fbEml
	 */
	public void setFbEml(String fbEml) {
		this.fbEml = fbEml;
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
	 * @param vslEml
	 */
	public void setVslEml(String vslEml) {
		this.vslEml = vslEml;
	}
	
	/**
	 * Column Info
	 * @param trsmOwnrCd
	 */
	public void setTrsmOwnrCd(String trsmOwnrCd) {
		this.trsmOwnrCd = trsmOwnrCd;
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
	 * @param vslFaxNo
	 */
	public void setVslFaxNo(String vslFaxNo) {
		this.vslFaxNo = vslFaxNo;
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
	 * @param rpmAdjDt
	 */
	public void setRpmAdjDt(String rpmAdjDt) {
		this.rpmAdjDt = rpmAdjDt;
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
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param trsmMzdCd
	 */
	public void setTrsmMzdCd(String trsmMzdCd) {
		this.trsmMzdCd = trsmMzdCd;
	}
	
	/**
	 * Column Info
	 * @param ntcEtaDt
	 */
	public void setNtcEtaDt(String ntcEtaDt) {
		this.ntcEtaDt = ntcEtaDt;
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
	 * @param tlxImstCd
	 */
	public void setTlxImstCd(String tlxImstCd) {
		this.tlxImstCd = tlxImstCd;
	}
	
	/**
	 * Column Info
	 * @param vslFaxTrsmEml
	 */
	public void setVslFaxTrsmEml(String vslFaxTrsmEml) {
		this.vslFaxTrsmEml = vslFaxTrsmEml;
	}
	
	/**
	 * Column Info
	 * @param ntcEtbDt
	 */
	public void setNtcEtbDt(String ntcEtbDt) {
		this.ntcEtbDt = ntcEtbDt;
	}
	
	/**
	 * Column Info
	 * @param skdTrsmStsCd
	 */
	public void setSkdTrsmStsCd(String skdTrsmStsCd) {
		this.skdTrsmStsCd = skdTrsmStsCd;
	}
	
	/**
	 * Column Info
	 * @param loclCreDt
	 */
	public void setLoclCreDt(String loclCreDt) {
		this.loclCreDt = loclCreDt;
	}
	
	/**
	 * Column Info
	 * @param emlSndNo
	 */
	public void setEmlSndNo(String emlSndNo) {
		this.emlSndNo = emlSndNo;
	}
	
	/**
	 * Column Info
	 * @param vslTlxNo
	 */
	public void setVslTlxNo(String vslTlxNo) {
		this.vslTlxNo = vslTlxNo;
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
	 * @param fmEtaDt
	 */
	public void setFmEtaDt(String fmEtaDt) {
		this.fmEtaDt = fmEtaDt;
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
	 * @param actCrrCd
	 */
	public void setActCrrCd(String actCrrCd) {
		this.actCrrCd = actCrrCd;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param emlSeq
	 */
	public void setEmlSeq(String emlSeq) {
		this.emlSeq = emlSeq;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param trsmRsn
	 */
	public void setTrsmRsn(String trsmRsn) {
		this.trsmRsn = trsmRsn;
	}
	
	/**
	 * Column Info
	 * @param imstCd
	 */
	public void setImstCd(String imstCd) {
		this.imstCd = imstCd;
	}
	
	/**
	 * Column Info
	 * @param trsmPurpCd
	 */
	public void setTrsmPurpCd(String trsmPurpCd) {
		this.trsmPurpCd = trsmPurpCd;
	}
	
	/**
	 * Column Info
	 * @param trsmHisSeq
	 */
	public void setTrsmHisSeq(String trsmHisSeq) {
		this.trsmHisSeq = trsmHisSeq;
	}
	
	/**
	 * Column Info
	 * @param esvcVndrSeq
	 */
	public void setEsvcVndrSeq(String esvcVndrSeq) {
		this.esvcVndrSeq = esvcVndrSeq;
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
		setTrsmDt(JSPUtil.getParameter(request, prefix + "trsm_dt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setAutoFaxPop(JSPUtil.getParameter(request, prefix + "auto_fax_pop", ""));
		setCrntRpmPwr(JSPUtil.getParameter(request, prefix + "crnt_rpm_pwr", ""));
		
		setSndrEml		(JSPUtil.getParameter(request, prefix + "sndr_eml"		, ""));
		setSndrNm		(JSPUtil.getParameter(request, prefix + "sndr_nm"		, ""));
		setSndrPhnNo	(JSPUtil.getParameter(request, prefix + "sndr_phn_no"	, ""));
		setLanePicEml	(JSPUtil.getParameter(request, prefix + "lane_pic_eml"	, ""));
		
		setDfltFaxImstCd(JSPUtil.getParameter(request, prefix + "dflt_fax_imst_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setPortNm(JSPUtil.getParameter(request, prefix + "port_nm", ""));
		setSkdTrsmStsNm(JSPUtil.getParameter(request, prefix + "skd_trsm_sts_nm", ""));
		setToEtaDt(JSPUtil.getParameter(request, prefix + "to_eta_dt", ""));
		setVslTlxTrsmEml(JSPUtil.getParameter(request, prefix + "vsl_tlx_trsm_eml", ""));
		setUsrEml(JSPUtil.getParameter(request, prefix + "usr_eml", ""));
		setDfltImstCd(JSPUtil.getParameter(request, prefix + "dflt_imst_cd", ""));
		setNtcEtdDt(JSPUtil.getParameter(request, prefix + "ntc_etd_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setDfltTlxImstCd(JSPUtil.getParameter(request, prefix + "dflt_tlx_imst_cd", ""));
		setOrgRpmPwr(JSPUtil.getParameter(request, prefix + "org_rpm_pwr", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setFaxImstCd(JSPUtil.getParameter(request, prefix + "fax_imst_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setLoclUpdDt(JSPUtil.getParameter(request, prefix + "locl_upd_dt", ""));
		setTrsmLoclDt(JSPUtil.getParameter(request, prefix + "trsm_locl_dt", ""));
		setFbEml(JSPUtil.getParameter(request, prefix + "fb_eml", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setVslEml(JSPUtil.getParameter(request, prefix + "vsl_eml", ""));
		setTrsmOwnrCd(JSPUtil.getParameter(request, prefix + "trsm_ownr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVslFaxNo(JSPUtil.getParameter(request, prefix + "vsl_fax_no", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setRpmAdjDt(JSPUtil.getParameter(request, prefix + "rpm_adj_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setTrsmMzdCd(JSPUtil.getParameter(request, prefix + "trsm_mzd_cd", ""));
		setNtcEtaDt(JSPUtil.getParameter(request, prefix + "ntc_eta_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTlxImstCd(JSPUtil.getParameter(request, prefix + "tlx_imst_cd", ""));
		setVslFaxTrsmEml(JSPUtil.getParameter(request, prefix + "vsl_fax_trsm_eml", ""));
		setNtcEtbDt(JSPUtil.getParameter(request, prefix + "ntc_etb_dt", ""));
		setSkdTrsmStsCd(JSPUtil.getParameter(request, prefix + "skd_trsm_sts_cd", ""));
		setLoclCreDt(JSPUtil.getParameter(request, prefix + "locl_cre_dt", ""));
		setEmlSndNo(JSPUtil.getParameter(request, prefix + "eml_snd_no", ""));
		setVslTlxNo(JSPUtil.getParameter(request, prefix + "vsl_tlx_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setFmEtaDt(JSPUtil.getParameter(request, prefix + "fm_eta_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setActCrrCd(JSPUtil.getParameter(request, prefix + "act_crr_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setEmlSeq(JSPUtil.getParameter(request, prefix + "eml_seq", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setTrsmRsn(JSPUtil.getParameter(request, prefix + "trsm_rsn", ""));
		setImstCd(JSPUtil.getParameter(request, prefix + "imst_cd", ""));
		
		setTrsmPurpCd(JSPUtil.getParameter(request, prefix + "trsm_purp_cd", ""));
		setTrsmHisSeq(JSPUtil.getParameter(request, prefix + "trsm_his_seq", ""));
		setEsvcVndrSeq(JSPUtil.getParameter(request, prefix + "esvc_vndr_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EtaSendTgtVO[]
	 */
	public EtaSendTgtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EtaSendTgtVO[]
	 */
	public EtaSendTgtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EtaSendTgtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trsmDt = (JSPUtil.getParameter(request, prefix	+ "trsm_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] autoFaxPop = (JSPUtil.getParameter(request, prefix	+ "auto_fax_pop", length));
			String[] crntRpmPwr = (JSPUtil.getParameter(request, prefix	+ "crnt_rpm_pwr", length));
			
			String[] sndrEml 	= (JSPUtil.getParameter(request, prefix	+ "sndr_eml"	, length));
			String[] sndrNm  	= (JSPUtil.getParameter(request, prefix	+ "sndr_nm"		, length));
			String[] sndrPhnNo	= (JSPUtil.getParameter(request, prefix	+ "sndr_phn_no"	, length));
			String[] lanePicEml	= (JSPUtil.getParameter(request, prefix	+ "lane_pic_eml", length));

			String[] dfltFaxImstCd = (JSPUtil.getParameter(request, prefix	+ "dflt_fax_imst_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] portNm = (JSPUtil.getParameter(request, prefix	+ "port_nm", length));
			String[] skdTrsmStsNm = (JSPUtil.getParameter(request, prefix	+ "skd_trsm_sts_nm", length));
			String[] toEtaDt = (JSPUtil.getParameter(request, prefix	+ "to_eta_dt", length));
			String[] vslTlxTrsmEml = (JSPUtil.getParameter(request, prefix	+ "vsl_tlx_trsm_eml", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] dfltImstCd = (JSPUtil.getParameter(request, prefix	+ "dflt_imst_cd", length));
			String[] ntcEtdDt = (JSPUtil.getParameter(request, prefix	+ "ntc_etd_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] dfltTlxImstCd = (JSPUtil.getParameter(request, prefix	+ "dflt_tlx_imst_cd", length));
			String[] orgRpmPwr = (JSPUtil.getParameter(request, prefix	+ "org_rpm_pwr", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] faxImstCd = (JSPUtil.getParameter(request, prefix	+ "fax_imst_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] loclUpdDt = (JSPUtil.getParameter(request, prefix	+ "locl_upd_dt", length));
			String[] trsmLoclDt = (JSPUtil.getParameter(request, prefix	+ "trsm_locl_dt", length));
			String[] fbEml = (JSPUtil.getParameter(request, prefix	+ "fb_eml", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] vslEml = (JSPUtil.getParameter(request, prefix	+ "vsl_eml", length));
			String[] trsmOwnrCd = (JSPUtil.getParameter(request, prefix	+ "trsm_ownr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vslFaxNo = (JSPUtil.getParameter(request, prefix	+ "vsl_fax_no", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] rpmAdjDt = (JSPUtil.getParameter(request, prefix	+ "rpm_adj_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] trsmMzdCd = (JSPUtil.getParameter(request, prefix	+ "trsm_mzd_cd", length));
			String[] ntcEtaDt = (JSPUtil.getParameter(request, prefix	+ "ntc_eta_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] tlxImstCd = (JSPUtil.getParameter(request, prefix	+ "tlx_imst_cd", length));
			String[] vslFaxTrsmEml = (JSPUtil.getParameter(request, prefix	+ "vsl_fax_trsm_eml", length));
			String[] ntcEtbDt = (JSPUtil.getParameter(request, prefix	+ "ntc_etb_dt", length));
			String[] skdTrsmStsCd = (JSPUtil.getParameter(request, prefix	+ "skd_trsm_sts_cd", length));
			String[] loclCreDt = (JSPUtil.getParameter(request, prefix	+ "locl_cre_dt", length));
			String[] emlSndNo = (JSPUtil.getParameter(request, prefix	+ "eml_snd_no", length));
			String[] vslTlxNo = (JSPUtil.getParameter(request, prefix	+ "vsl_tlx_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] fmEtaDt = (JSPUtil.getParameter(request, prefix	+ "fm_eta_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] actCrrCd = (JSPUtil.getParameter(request, prefix	+ "act_crr_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] emlSeq = (JSPUtil.getParameter(request, prefix	+ "eml_seq", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] trsmRsn = (JSPUtil.getParameter(request, prefix	+ "trsm_rsn", length));
			String[] imstCd = (JSPUtil.getParameter(request, prefix	+ "imst_cd", length));
			
			String[] trsmPurpCd = (JSPUtil.getParameter(request, prefix	+ "trsm_purp_cd", length));
			String[] trsmHisSeq = (JSPUtil.getParameter(request, prefix	+ "trsm_his_seq", length));
			String[] esvcVndrSeq = (JSPUtil.getParameter(request, prefix	+ "esvc_vndr_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new EtaSendTgtVO();
				if (trsmDt[i] != null)
					model.setTrsmDt(trsmDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (autoFaxPop[i] != null)
					model.setAutoFaxPop(autoFaxPop[i]);
				if (crntRpmPwr[i] != null)
					model.setCrntRpmPwr(crntRpmPwr[i]);
				
				if (sndrEml[i] 		!= null)
					model.setSndrEml	(sndrEml	[i]);
				if (sndrNm[i] 		!= null)
					model.setSndrNm		(sndrNm		[i]);
				if (sndrPhnNo[i] 	!= null)
					model.setSndrPhnNo	(sndrPhnNo	[i]);
				if (lanePicEml[i] 	!= null)
					model.setLanePicEml	(lanePicEml	[i]);
				
				if (dfltFaxImstCd[i] != null)
					model.setDfltFaxImstCd(dfltFaxImstCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (portNm[i] != null)
					model.setPortNm(portNm[i]);
				if (skdTrsmStsNm[i] != null)
					model.setSkdTrsmStsNm(skdTrsmStsNm[i]);
				if (toEtaDt[i] != null)
					model.setToEtaDt(toEtaDt[i]);
				if (vslTlxTrsmEml[i] != null)
					model.setVslTlxTrsmEml(vslTlxTrsmEml[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (dfltImstCd[i] != null)
					model.setDfltImstCd(dfltImstCd[i]);
				if (ntcEtdDt[i] != null)
					model.setNtcEtdDt(ntcEtdDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (dfltTlxImstCd[i] != null)
					model.setDfltTlxImstCd(dfltTlxImstCd[i]);
				if (orgRpmPwr[i] != null)
					model.setOrgRpmPwr(orgRpmPwr[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (faxImstCd[i] != null)
					model.setFaxImstCd(faxImstCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (loclUpdDt[i] != null)
					model.setLoclUpdDt(loclUpdDt[i]);
				if (trsmLoclDt[i] != null)
					model.setTrsmLoclDt(trsmLoclDt[i]);
				if (fbEml[i] != null)
					model.setFbEml(fbEml[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (vslEml[i] != null)
					model.setVslEml(vslEml[i]);
				if (trsmOwnrCd[i] != null)
					model.setTrsmOwnrCd(trsmOwnrCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vslFaxNo[i] != null)
					model.setVslFaxNo(vslFaxNo[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (rpmAdjDt[i] != null)
					model.setRpmAdjDt(rpmAdjDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (trsmMzdCd[i] != null)
					model.setTrsmMzdCd(trsmMzdCd[i]);
				if (ntcEtaDt[i] != null)
					model.setNtcEtaDt(ntcEtaDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (tlxImstCd[i] != null)
					model.setTlxImstCd(tlxImstCd[i]);
				if (vslFaxTrsmEml[i] != null)
					model.setVslFaxTrsmEml(vslFaxTrsmEml[i]);
				if (ntcEtbDt[i] != null)
					model.setNtcEtbDt(ntcEtbDt[i]);
				if (skdTrsmStsCd[i] != null)
					model.setSkdTrsmStsCd(skdTrsmStsCd[i]);
				if (loclCreDt[i] != null)
					model.setLoclCreDt(loclCreDt[i]);
				if (emlSndNo[i] != null)
					model.setEmlSndNo(emlSndNo[i]);
				if (vslTlxNo[i] != null)
					model.setVslTlxNo(vslTlxNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (fmEtaDt[i] != null)
					model.setFmEtaDt(fmEtaDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (actCrrCd[i] != null)
					model.setActCrrCd(actCrrCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (emlSeq[i] != null)
					model.setEmlSeq(emlSeq[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (trsmRsn[i] != null)
					model.setTrsmRsn(trsmRsn[i]);
				if (imstCd[i] != null)
					model.setImstCd(imstCd[i]);
				
				if (trsmPurpCd[i] != null)
					model.setTrsmPurpCd(trsmPurpCd[i]);				
				if (trsmHisSeq[i] != null)
					model.setTrsmHisSeq(trsmHisSeq[i]);
				if (esvcVndrSeq[i] != null)
					model.setEsvcVndrSeq(esvcVndrSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEtaSendTgtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EtaSendTgtVO[]
	 */
	public EtaSendTgtVO[] getEtaSendTgtVOs(){
		EtaSendTgtVO[] vos = (EtaSendTgtVO[])models.toArray(new EtaSendTgtVO[models.size()]);
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
		this.trsmDt = this.trsmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoFaxPop = this.autoFaxPop .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntRpmPwr = this.crntRpmPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.sndrEml 	= this.sndrEml 		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrNm  	= this.sndrNm   	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrPhnNo 	= this.sndrPhnNo	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lanePicEml	= this.lanePicEml	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.dfltFaxImstCd = this.dfltFaxImstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portNm = this.portNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdTrsmStsNm = this.skdTrsmStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEtaDt = this.toEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslTlxTrsmEml = this.vslTlxTrsmEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltImstCd = this.dfltImstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEtdDt = this.ntcEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltTlxImstCd = this.dfltTlxImstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRpmPwr = this.orgRpmPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxImstCd = this.faxImstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclUpdDt = this.loclUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmLoclDt = this.trsmLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fbEml = this.fbEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEml = this.vslEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmOwnrCd = this.trsmOwnrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFaxNo = this.vslFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rpmAdjDt = this.rpmAdjDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmMzdCd = this.trsmMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEtaDt = this.ntcEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tlxImstCd = this.tlxImstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFaxTrsmEml = this.vslFaxTrsmEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEtbDt = this.ntcEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdTrsmStsCd = this.skdTrsmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCreDt = this.loclCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndNo = this.emlSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslTlxNo = this.vslTlxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEtaDt = this.fmEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCrrCd = this.actCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSeq = this.emlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmRsn = this.trsmRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imstCd = this.imstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.trsmPurpCd = this.trsmPurpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmHisSeq = this.trsmHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esvcVndrSeq = this.esvcVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
