/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OutBdMvntStsNtcListInVO.java
*@FileTitle : OutBdMvntStsNtcListInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OutBdMvntStsNtcListInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OutBdMvntStsNtcListInVO> models = new ArrayList<OutBdMvntStsNtcListInVO>();
	
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String emlSndDt = null;
	/* Column Info */
	private String dgSts = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String srepEml = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String srepMphnNo = null;
	/* Column Info */
	private String stwgCd = null;
	/* Column Info */
	private String shprNtcFlg = null;
	/* Column Info */
	private String cntcMphnNo = null;
	/* Column Info */
	private String bkgEml = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String cntrCnt = null;
	/* Column Info */
	private String bkgPic = null;
	/* Column Info */
	private String srepPic = null;
	/* Column Info */
	private String akDesc = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String dgDesc = null;
	/* Column Info */
	private String bkgPicNtcFlg = null;
	/* Column Info */
	private String shprMphnNo = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String bkgMphnNo = null;
	/* Column Info */
	private String shprSmsSndFlg = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String tmlGiSts = null;
	/* Column Info */
	private String ctrtOfcPhnNo = null;
	/* Column Info */
	private String cntcEml = null;
	/* Column Info */
	private String shprEml = null;
	/* Column Info */
	private String emlSndFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String smsSndFlg = null;
	/* Column Info */
	private String srepNtcFlg = null;
	/* Column Info */
	private String delFlg = null;
	/* Column Info */
	private String vslPrePstCd = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String rfSts = null;
	/* Column Info */
	private String smsSndDt = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String ntcExp = null;
	/* Column Info */
	private String shprPic = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String mblSndFlg = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String akSts = null;
	/* Column Info */
	private String rfDesc = null;
	/* Column Info */
	private String trnsMode = null;
	/* Column Info */
	private String obPicNtcFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OutBdMvntStsNtcListInVO() {}

	public OutBdMvntStsNtcListInVO(String ibflag, String pagerows, String bkgCgoTpCd, String emlSndDt, String dgSts, String trdCd, String srepEml, String polCd, String cntrTpszCd, String srepMphnNo, String stwgCd, String shprNtcFlg, String cntcMphnNo, String delCd, String bkgEml, String cnmvEvntDt, String bkgPic, String srepPic, String akDesc, String podCd, String vvd, String bkgNo, String dgDesc, String bkgPicNtcFlg, String shprMphnNo, String subTrdCd, String bkgMphnNo, String porCd, String tmlGiSts, String ctrtOfcPhnNo, String cntcEml, String shprEml, String emlSndFlg, String cnmvStsCd, String smsSndFlg, String srepNtcFlg, String vslPrePstCd, String rcvTermCd, String shprNm, String rfSts, String smsSndDt, String orgYdCd, String ntcExp, String shprPic, String deTermCd, String slanCd, String mblSndFlg, String cntrNo, String polYdCd, String akSts, String rfDesc, String trnsMode, String obPicNtcFlg, String cntrCnt, String delFlg, String shprSmsSndFlg) {
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.emlSndDt = emlSndDt;
		this.dgSts = dgSts;
		this.trdCd = trdCd;
		this.srepEml = srepEml;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.cntrTpszCd = cntrTpszCd;
		this.srepMphnNo = srepMphnNo;
		this.stwgCd = stwgCd;
		this.shprNtcFlg = shprNtcFlg;
		this.cntcMphnNo = cntcMphnNo;
		this.bkgEml = bkgEml;
		this.delCd = delCd;
		this.cnmvEvntDt = cnmvEvntDt;
		this.cntrCnt = cntrCnt;
		this.bkgPic = bkgPic;
		this.srepPic = srepPic;
		this.akDesc = akDesc;
		this.vvd = vvd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.dgDesc = dgDesc;
		this.bkgPicNtcFlg = bkgPicNtcFlg;
		this.shprMphnNo = shprMphnNo;
		this.subTrdCd = subTrdCd;
		this.bkgMphnNo = bkgMphnNo;
		this.shprSmsSndFlg = shprSmsSndFlg;
		this.porCd = porCd;
		this.tmlGiSts = tmlGiSts;
		this.ctrtOfcPhnNo = ctrtOfcPhnNo;
		this.cntcEml = cntcEml;
		this.shprEml = shprEml;
		this.emlSndFlg = emlSndFlg;
		this.ibflag = ibflag;
		this.cnmvStsCd = cnmvStsCd;
		this.smsSndFlg = smsSndFlg;
		this.srepNtcFlg = srepNtcFlg;
		this.delFlg = delFlg;
		this.vslPrePstCd = vslPrePstCd;
		this.rcvTermCd = rcvTermCd;
		this.shprNm = shprNm;
		this.rfSts = rfSts;
		this.smsSndDt = smsSndDt;
		this.orgYdCd = orgYdCd;
		this.ntcExp = ntcExp;
		this.shprPic = shprPic;
		this.deTermCd = deTermCd;
		this.slanCd = slanCd;
		this.mblSndFlg = mblSndFlg;
		this.cntrNo = cntrNo;
		this.polYdCd = polYdCd;
		this.akSts = akSts;
		this.rfDesc = rfDesc;
		this.trnsMode = trnsMode;
		this.obPicNtcFlg = obPicNtcFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("eml_snd_dt", getEmlSndDt());
		this.hashColumns.put("dg_sts", getDgSts());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("srep_eml", getSrepEml());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("srep_mphn_no", getSrepMphnNo());
		this.hashColumns.put("stwg_cd", getStwgCd());
		this.hashColumns.put("shpr_ntc_flg", getShprNtcFlg());
		this.hashColumns.put("cntc_mphn_no", getCntcMphnNo());
		this.hashColumns.put("bkg_eml", getBkgEml());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("cntr_cnt", getCntrCnt());
		this.hashColumns.put("bkg_pic", getBkgPic());
		this.hashColumns.put("srep_pic", getSrepPic());
		this.hashColumns.put("ak_desc", getAkDesc());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("dg_desc", getDgDesc());
		this.hashColumns.put("bkg_pic_ntc_flg", getBkgPicNtcFlg());
		this.hashColumns.put("shpr_mphn_no", getShprMphnNo());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("bkg_mphn_no", getBkgMphnNo());
		this.hashColumns.put("shpr_sms_snd_flg", getShprSmsSndFlg());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("tml_gi_sts", getTmlGiSts());
		this.hashColumns.put("ctrt_ofc_phn_no", getCtrtOfcPhnNo());
		this.hashColumns.put("cntc_eml", getCntcEml());
		this.hashColumns.put("shpr_eml", getShprEml());
		this.hashColumns.put("eml_snd_flg", getEmlSndFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("sms_snd_flg", getSmsSndFlg());
		this.hashColumns.put("srep_ntc_flg", getSrepNtcFlg());
		this.hashColumns.put("del_flg", getDelFlg());
		this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("rf_sts", getRfSts());
		this.hashColumns.put("sms_snd_dt", getSmsSndDt());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("ntc_exp", getNtcExp());
		this.hashColumns.put("shpr_pic", getShprPic());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("mbl_snd_flg", getMblSndFlg());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("ak_sts", getAkSts());
		this.hashColumns.put("rf_desc", getRfDesc());
		this.hashColumns.put("trns_mode", getTrnsMode());
		this.hashColumns.put("ob_pic_ntc_flg", getObPicNtcFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("eml_snd_dt", "emlSndDt");
		this.hashFields.put("dg_sts", "dgSts");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("srep_eml", "srepEml");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("srep_mphn_no", "srepMphnNo");
		this.hashFields.put("stwg_cd", "stwgCd");
		this.hashFields.put("shpr_ntc_flg", "shprNtcFlg");
		this.hashFields.put("cntc_mphn_no", "cntcMphnNo");
		this.hashFields.put("bkg_eml", "bkgEml");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("cntr_cnt", "cntrCnt");
		this.hashFields.put("bkg_pic", "bkgPic");
		this.hashFields.put("srep_pic", "srepPic");
		this.hashFields.put("ak_desc", "akDesc");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("dg_desc", "dgDesc");
		this.hashFields.put("bkg_pic_ntc_flg", "bkgPicNtcFlg");
		this.hashFields.put("shpr_mphn_no", "shprMphnNo");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("bkg_mphn_no", "bkgMphnNo");
		this.hashFields.put("shpr_sms_snd_flg", "shprSmsSndFlg");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("tml_gi_sts", "tmlGiSts");
		this.hashFields.put("ctrt_ofc_phn_no", "ctrtOfcPhnNo");
		this.hashFields.put("cntc_eml", "cntcEml");
		this.hashFields.put("shpr_eml", "shprEml");
		this.hashFields.put("eml_snd_flg", "emlSndFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("sms_snd_flg", "smsSndFlg");
		this.hashFields.put("srep_ntc_flg", "srepNtcFlg");
		this.hashFields.put("del_flg", "delFlg");
		this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("rf_sts", "rfSts");
		this.hashFields.put("sms_snd_dt", "smsSndDt");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("ntc_exp", "ntcExp");
		this.hashFields.put("shpr_pic", "shprPic");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("mbl_snd_flg", "mblSndFlg");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("ak_sts", "akSts");
		this.hashFields.put("rf_desc", "rfDesc");
		this.hashFields.put("trns_mode", "trnsMode");
		this.hashFields.put("ob_pic_ntc_flg", "obPicNtcFlg");
		return this.hashFields;
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
	 * @return emlSndDt
	 */
	public String getEmlSndDt() {
		return this.emlSndDt;
	}
	
	/**
	 * Column Info
	 * @return dgSts
	 */
	public String getDgSts() {
		return this.dgSts;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return srepEml
	 */
	public String getSrepEml() {
		return this.srepEml;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return srepMphnNo
	 */
	public String getSrepMphnNo() {
		return this.srepMphnNo;
	}
	
	/**
	 * Column Info
	 * @return stwgCd
	 */
	public String getStwgCd() {
		return this.stwgCd;
	}
	
	/**
	 * Column Info
	 * @return shprNtcFlg
	 */
	public String getShprNtcFlg() {
		return this.shprNtcFlg;
	}
	
	/**
	 * Column Info
	 * @return cntcMphnNo
	 */
	public String getCntcMphnNo() {
		return this.cntcMphnNo;
	}
	
	/**
	 * Column Info
	 * @return bkgEml
	 */
	public String getBkgEml() {
		return this.bkgEml;
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
	 * @return cnmvEvntDt
	 */
	public String getCnmvEvntDt() {
		return this.cnmvEvntDt;
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
	 * @return bkgPic
	 */
	public String getBkgPic() {
		return this.bkgPic;
	}
	
	/**
	 * Column Info
	 * @return srepPic
	 */
	public String getSrepPic() {
		return this.srepPic;
	}
	
	/**
	 * Column Info
	 * @return akDesc
	 */
	public String getAkDesc() {
		return this.akDesc;
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
	 * @return dgDesc
	 */
	public String getDgDesc() {
		return this.dgDesc;
	}
	
	/**
	 * Column Info
	 * @return bkgPicNtcFlg
	 */
	public String getBkgPicNtcFlg() {
		return this.bkgPicNtcFlg;
	}
	
	/**
	 * Column Info
	 * @return shprMphnNo
	 */
	public String getShprMphnNo() {
		return this.shprMphnNo;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return bkgMphnNo
	 */
	public String getBkgMphnNo() {
		return this.bkgMphnNo;
	}
	
	/**
	 * Column Info
	 * @return shprSmsSndFlg
	 */
	public String getShprSmsSndFlg() {
		return this.shprSmsSndFlg;
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
	 * @return tmlGiSts
	 */
	public String getTmlGiSts() {
		return this.tmlGiSts;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcPhnNo
	 */
	public String getCtrtOfcPhnNo() {
		return this.ctrtOfcPhnNo;
	}
	
	/**
	 * Column Info
	 * @return cntcEml
	 */
	public String getCntcEml() {
		return this.cntcEml;
	}
	
	/**
	 * Column Info
	 * @return shprEml
	 */
	public String getShprEml() {
		return this.shprEml;
	}
	
	/**
	 * Column Info
	 * @return emlSndFlg
	 */
	public String getEmlSndFlg() {
		return this.emlSndFlg;
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
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @return smsSndFlg
	 */
	public String getSmsSndFlg() {
		return this.smsSndFlg;
	}
	
	/**
	 * Column Info
	 * @return srepNtcFlg
	 */
	public String getSrepNtcFlg() {
		return this.srepNtcFlg;
	}
	
	/**
	 * Column Info
	 * @return delFlg
	 */
	public String getDelFlg() {
		return this.delFlg;
	}
	
	/**
	 * Column Info
	 * @return vslPrePstCd
	 */
	public String getVslPrePstCd() {
		return this.vslPrePstCd;
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
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}
	
	/**
	 * Column Info
	 * @return rfSts
	 */
	public String getRfSts() {
		return this.rfSts;
	}
	
	/**
	 * Column Info
	 * @return smsSndDt
	 */
	public String getSmsSndDt() {
		return this.smsSndDt;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	
	/**
	 * Column Info
	 * @return ntcExp
	 */
	public String getNtcExp() {
		return this.ntcExp;
	}
	
	/**
	 * Column Info
	 * @return shprPic
	 */
	public String getShprPic() {
		return this.shprPic;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return mblSndFlg
	 */
	public String getMblSndFlg() {
		return this.mblSndFlg;
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
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return akSts
	 */
	public String getAkSts() {
		return this.akSts;
	}
	
	/**
	 * Column Info
	 * @return rfDesc
	 */
	public String getRfDesc() {
		return this.rfDesc;
	}
	
	/**
	 * Column Info
	 * @return trnsMode
	 */
	public String getTrnsMode() {
		return this.trnsMode;
	}
	
	/**
	 * Column Info
	 * @return obPicNtcFlg
	 */
	public String getObPicNtcFlg() {
		return this.obPicNtcFlg;
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
	 * @param emlSndDt
	 */
	public void setEmlSndDt(String emlSndDt) {
		this.emlSndDt = emlSndDt;
	}
	
	/**
	 * Column Info
	 * @param dgSts
	 */
	public void setDgSts(String dgSts) {
		this.dgSts = dgSts;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param srepEml
	 */
	public void setSrepEml(String srepEml) {
		this.srepEml = srepEml;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param srepMphnNo
	 */
	public void setSrepMphnNo(String srepMphnNo) {
		this.srepMphnNo = srepMphnNo;
	}
	
	/**
	 * Column Info
	 * @param stwgCd
	 */
	public void setStwgCd(String stwgCd) {
		this.stwgCd = stwgCd;
	}
	
	/**
	 * Column Info
	 * @param shprNtcFlg
	 */
	public void setShprNtcFlg(String shprNtcFlg) {
		this.shprNtcFlg = shprNtcFlg;
	}
	
	/**
	 * Column Info
	 * @param cntcMphnNo
	 */
	public void setCntcMphnNo(String cntcMphnNo) {
		this.cntcMphnNo = cntcMphnNo;
	}
	
	/**
	 * Column Info
	 * @param bkgEml
	 */
	public void setBkgEml(String bkgEml) {
		this.bkgEml = bkgEml;
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
	 * @param cnmvEvntDt
	 */
	public void setCnmvEvntDt(String cnmvEvntDt) {
		this.cnmvEvntDt = cnmvEvntDt;
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
	 * @param bkgPic
	 */
	public void setBkgPic(String bkgPic) {
		this.bkgPic = bkgPic;
	}
	
	/**
	 * Column Info
	 * @param srepPic
	 */
	public void setSrepPic(String srepPic) {
		this.srepPic = srepPic;
	}
	
	/**
	 * Column Info
	 * @param akDesc
	 */
	public void setAkDesc(String akDesc) {
		this.akDesc = akDesc;
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
	 * @param dgDesc
	 */
	public void setDgDesc(String dgDesc) {
		this.dgDesc = dgDesc;
	}
	
	/**
	 * Column Info
	 * @param bkgPicNtcFlg
	 */
	public void setBkgPicNtcFlg(String bkgPicNtcFlg) {
		this.bkgPicNtcFlg = bkgPicNtcFlg;
	}
	
	/**
	 * Column Info
	 * @param shprMphnNo
	 */
	public void setShprMphnNo(String shprMphnNo) {
		this.shprMphnNo = shprMphnNo;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param bkgMphnNo
	 */
	public void setBkgMphnNo(String bkgMphnNo) {
		this.bkgMphnNo = bkgMphnNo;
	}
	
	/**
	 * Column Info
	 * @param shprSmsSndFlg
	 */
	public void setShprSmsSndFlg(String shprSmsSndFlg) {
		this.shprSmsSndFlg = shprSmsSndFlg;
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
	 * @param tmlGiSts
	 */
	public void setTmlGiSts(String tmlGiSts) {
		this.tmlGiSts = tmlGiSts;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcPhnNo
	 */
	public void setCtrtOfcPhnNo(String ctrtOfcPhnNo) {
		this.ctrtOfcPhnNo = ctrtOfcPhnNo;
	}
	
	/**
	 * Column Info
	 * @param cntcEml
	 */
	public void setCntcEml(String cntcEml) {
		this.cntcEml = cntcEml;
	}
	
	/**
	 * Column Info
	 * @param shprEml
	 */
	public void setShprEml(String shprEml) {
		this.shprEml = shprEml;
	}
	
	/**
	 * Column Info
	 * @param emlSndFlg
	 */
	public void setEmlSndFlg(String emlSndFlg) {
		this.emlSndFlg = emlSndFlg;
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
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @param smsSndFlg
	 */
	public void setSmsSndFlg(String smsSndFlg) {
		this.smsSndFlg = smsSndFlg;
	}
	
	/**
	 * Column Info
	 * @param srepNtcFlg
	 */
	public void setSrepNtcFlg(String srepNtcFlg) {
		this.srepNtcFlg = srepNtcFlg;
	}
	
	/**
	 * Column Info
	 * @param delFlg
	 */
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}
	
	/**
	 * Column Info
	 * @param vslPrePstCd
	 */
	public void setVslPrePstCd(String vslPrePstCd) {
		this.vslPrePstCd = vslPrePstCd;
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
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * Column Info
	 * @param rfSts
	 */
	public void setRfSts(String rfSts) {
		this.rfSts = rfSts;
	}
	
	/**
	 * Column Info
	 * @param smsSndDt
	 */
	public void setSmsSndDt(String smsSndDt) {
		this.smsSndDt = smsSndDt;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Column Info
	 * @param ntcExp
	 */
	public void setNtcExp(String ntcExp) {
		this.ntcExp = ntcExp;
	}
	
	/**
	 * Column Info
	 * @param shprPic
	 */
	public void setShprPic(String shprPic) {
		this.shprPic = shprPic;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param mblSndFlg
	 */
	public void setMblSndFlg(String mblSndFlg) {
		this.mblSndFlg = mblSndFlg;
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
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param akSts
	 */
	public void setAkSts(String akSts) {
		this.akSts = akSts;
	}
	
	/**
	 * Column Info
	 * @param rfDesc
	 */
	public void setRfDesc(String rfDesc) {
		this.rfDesc = rfDesc;
	}
	
	/**
	 * Column Info
	 * @param trnsMode
	 */
	public void setTrnsMode(String trnsMode) {
		this.trnsMode = trnsMode;
	}
	
	/**
	 * Column Info
	 * @param obPicNtcFlg
	 */
	public void setObPicNtcFlg(String obPicNtcFlg) {
		this.obPicNtcFlg = obPicNtcFlg;
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
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setEmlSndDt(JSPUtil.getParameter(request, prefix + "eml_snd_dt", ""));
		setDgSts(JSPUtil.getParameter(request, prefix + "dg_sts", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setSrepEml(JSPUtil.getParameter(request, prefix + "srep_eml", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setSrepMphnNo(JSPUtil.getParameter(request, prefix + "srep_mphn_no", ""));
		setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));
		setShprNtcFlg(JSPUtil.getParameter(request, prefix + "shpr_ntc_flg", ""));
		setCntcMphnNo(JSPUtil.getParameter(request, prefix + "cntc_mphn_no", ""));
		setBkgEml(JSPUtil.getParameter(request, prefix + "bkg_eml", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, prefix + "cnmv_evnt_dt", ""));
		setCntrCnt(JSPUtil.getParameter(request, prefix + "cntr_cnt", ""));
		setBkgPic(JSPUtil.getParameter(request, prefix + "bkg_pic", ""));
		setSrepPic(JSPUtil.getParameter(request, prefix + "srep_pic", ""));
		setAkDesc(JSPUtil.getParameter(request, prefix + "ak_desc", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setDgDesc(JSPUtil.getParameter(request, prefix + "dg_desc", ""));
		setBkgPicNtcFlg(JSPUtil.getParameter(request, prefix + "bkg_pic_ntc_flg", ""));
		setShprMphnNo(JSPUtil.getParameter(request, prefix + "shpr_mphn_no", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setBkgMphnNo(JSPUtil.getParameter(request, prefix + "bkg_mphn_no", ""));
		setShprSmsSndFlg(JSPUtil.getParameter(request, prefix + "shpr_sms_snd_flg", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setTmlGiSts(JSPUtil.getParameter(request, prefix + "tml_gi_sts", ""));
		setCtrtOfcPhnNo(JSPUtil.getParameter(request, prefix + "ctrt_ofc_phn_no", ""));
		setCntcEml(JSPUtil.getParameter(request, prefix + "cntc_eml", ""));
		setShprEml(JSPUtil.getParameter(request, prefix + "shpr_eml", ""));
		setEmlSndFlg(JSPUtil.getParameter(request, prefix + "eml_snd_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
		setSmsSndFlg(JSPUtil.getParameter(request, prefix + "sms_snd_flg", ""));
		setSrepNtcFlg(JSPUtil.getParameter(request, prefix + "srep_ntc_flg", ""));
		setDelFlg(JSPUtil.getParameter(request, prefix + "del_flg", ""));
		setVslPrePstCd(JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setRfSts(JSPUtil.getParameter(request, prefix + "rf_sts", ""));
		setSmsSndDt(JSPUtil.getParameter(request, prefix + "sms_snd_dt", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setNtcExp(JSPUtil.getParameter(request, prefix + "ntc_exp", ""));
		setShprPic(JSPUtil.getParameter(request, prefix + "shpr_pic", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setMblSndFlg(JSPUtil.getParameter(request, prefix + "mbl_snd_flg", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setAkSts(JSPUtil.getParameter(request, prefix + "ak_sts", ""));
		setRfDesc(JSPUtil.getParameter(request, prefix + "rf_desc", ""));
		setTrnsMode(JSPUtil.getParameter(request, prefix + "trns_mode", ""));
		setObPicNtcFlg(JSPUtil.getParameter(request, prefix + "ob_pic_ntc_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OutBdMvntStsNtcListInVO[]
	 */
	public OutBdMvntStsNtcListInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OutBdMvntStsNtcListInVO[]
	 */
	public OutBdMvntStsNtcListInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OutBdMvntStsNtcListInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] emlSndDt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dt", length));
			String[] dgSts = (JSPUtil.getParameter(request, prefix	+ "dg_sts", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] srepEml = (JSPUtil.getParameter(request, prefix	+ "srep_eml", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] srepMphnNo = (JSPUtil.getParameter(request, prefix	+ "srep_mphn_no", length));
			String[] stwgCd = (JSPUtil.getParameter(request, prefix	+ "stwg_cd", length));
			String[] shprNtcFlg = (JSPUtil.getParameter(request, prefix	+ "shpr_ntc_flg", length));
			String[] cntcMphnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_mphn_no", length));
			String[] bkgEml = (JSPUtil.getParameter(request, prefix	+ "bkg_eml", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] cntrCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_cnt", length));
			String[] bkgPic = (JSPUtil.getParameter(request, prefix	+ "bkg_pic", length));
			String[] srepPic = (JSPUtil.getParameter(request, prefix	+ "srep_pic", length));
			String[] akDesc = (JSPUtil.getParameter(request, prefix	+ "ak_desc", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] dgDesc = (JSPUtil.getParameter(request, prefix	+ "dg_desc", length));
			String[] bkgPicNtcFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_pic_ntc_flg", length));
			String[] shprMphnNo = (JSPUtil.getParameter(request, prefix	+ "shpr_mphn_no", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] bkgMphnNo = (JSPUtil.getParameter(request, prefix	+ "bkg_mphn_no", length));
			String[] shprSmsSndFlg = (JSPUtil.getParameter(request, prefix	+ "shpr_sms_snd_flg", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] tmlGiSts = (JSPUtil.getParameter(request, prefix	+ "tml_gi_sts", length));
			String[] ctrtOfcPhnNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_phn_no", length));
			String[] cntcEml = (JSPUtil.getParameter(request, prefix	+ "cntc_eml", length));
			String[] shprEml = (JSPUtil.getParameter(request, prefix	+ "shpr_eml", length));
			String[] emlSndFlg = (JSPUtil.getParameter(request, prefix	+ "eml_snd_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] smsSndFlg = (JSPUtil.getParameter(request, prefix	+ "sms_snd_flg", length));
			String[] srepNtcFlg = (JSPUtil.getParameter(request, prefix	+ "srep_ntc_flg", length));
			String[] delFlg = (JSPUtil.getParameter(request, prefix	+ "del_flg", length));
			String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_pst_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] rfSts = (JSPUtil.getParameter(request, prefix	+ "rf_sts", length));
			String[] smsSndDt = (JSPUtil.getParameter(request, prefix	+ "sms_snd_dt", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] ntcExp = (JSPUtil.getParameter(request, prefix	+ "ntc_exp", length));
			String[] shprPic = (JSPUtil.getParameter(request, prefix	+ "shpr_pic", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] mblSndFlg = (JSPUtil.getParameter(request, prefix	+ "mbl_snd_flg", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] akSts = (JSPUtil.getParameter(request, prefix	+ "ak_sts", length));
			String[] rfDesc = (JSPUtil.getParameter(request, prefix	+ "rf_desc", length));
			String[] trnsMode = (JSPUtil.getParameter(request, prefix	+ "trns_mode", length));
			String[] obPicNtcFlg = (JSPUtil.getParameter(request, prefix	+ "ob_pic_ntc_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new OutBdMvntStsNtcListInVO();
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (emlSndDt[i] != null)
					model.setEmlSndDt(emlSndDt[i]);
				if (dgSts[i] != null)
					model.setDgSts(dgSts[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (srepEml[i] != null)
					model.setSrepEml(srepEml[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (srepMphnNo[i] != null)
					model.setSrepMphnNo(srepMphnNo[i]);
				if (stwgCd[i] != null)
					model.setStwgCd(stwgCd[i]);
				if (shprNtcFlg[i] != null)
					model.setShprNtcFlg(shprNtcFlg[i]);
				if (cntcMphnNo[i] != null)
					model.setCntcMphnNo(cntcMphnNo[i]);
				if (bkgEml[i] != null)
					model.setBkgEml(bkgEml[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (cntrCnt[i] != null)
					model.setCntrCnt(cntrCnt[i]);
				if (bkgPic[i] != null)
					model.setBkgPic(bkgPic[i]);
				if (srepPic[i] != null)
					model.setSrepPic(srepPic[i]);
				if (akDesc[i] != null)
					model.setAkDesc(akDesc[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (dgDesc[i] != null)
					model.setDgDesc(dgDesc[i]);
				if (bkgPicNtcFlg[i] != null)
					model.setBkgPicNtcFlg(bkgPicNtcFlg[i]);
				if (shprMphnNo[i] != null)
					model.setShprMphnNo(shprMphnNo[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (bkgMphnNo[i] != null)
					model.setBkgMphnNo(bkgMphnNo[i]);
				if (shprSmsSndFlg[i] != null)
					model.setShprSmsSndFlg(shprSmsSndFlg[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (tmlGiSts[i] != null)
					model.setTmlGiSts(tmlGiSts[i]);
				if (ctrtOfcPhnNo[i] != null)
					model.setCtrtOfcPhnNo(ctrtOfcPhnNo[i]);
				if (cntcEml[i] != null)
					model.setCntcEml(cntcEml[i]);
				if (shprEml[i] != null)
					model.setShprEml(shprEml[i]);
				if (emlSndFlg[i] != null)
					model.setEmlSndFlg(emlSndFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (smsSndFlg[i] != null)
					model.setSmsSndFlg(smsSndFlg[i]);
				if (srepNtcFlg[i] != null)
					model.setSrepNtcFlg(srepNtcFlg[i]);
				if (delFlg[i] != null)
					model.setDelFlg(delFlg[i]);
				if (vslPrePstCd[i] != null)
					model.setVslPrePstCd(vslPrePstCd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (rfSts[i] != null)
					model.setRfSts(rfSts[i]);
				if (smsSndDt[i] != null)
					model.setSmsSndDt(smsSndDt[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (ntcExp[i] != null)
					model.setNtcExp(ntcExp[i]);
				if (shprPic[i] != null)
					model.setShprPic(shprPic[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (mblSndFlg[i] != null)
					model.setMblSndFlg(mblSndFlg[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (akSts[i] != null)
					model.setAkSts(akSts[i]);
				if (rfDesc[i] != null)
					model.setRfDesc(rfDesc[i]);
				if (trnsMode[i] != null)
					model.setTrnsMode(trnsMode[i]);
				if (obPicNtcFlg[i] != null)
					model.setObPicNtcFlg(obPicNtcFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOutBdMvntStsNtcListInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OutBdMvntStsNtcListInVO[]
	 */
	public OutBdMvntStsNtcListInVO[] getOutBdMvntStsNtcListInVOs(){
		OutBdMvntStsNtcListInVO[] vos = (OutBdMvntStsNtcListInVO[])models.toArray(new OutBdMvntStsNtcListInVO[models.size()]);
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
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDt = this.emlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgSts = this.dgSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepEml = this.srepEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepMphnNo = this.srepMphnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCd = this.stwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNtcFlg = this.shprNtcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcMphnNo = this.cntcMphnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgEml = this.bkgEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnt = this.cntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPic = this.bkgPic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepPic = this.srepPic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akDesc = this.akDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgDesc = this.dgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPicNtcFlg = this.bkgPicNtcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprMphnNo = this.shprMphnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMphnNo = this.bkgMphnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprSmsSndFlg = this.shprSmsSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlGiSts = this.tmlGiSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcPhnNo = this.ctrtOfcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcEml = this.cntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprEml = this.shprEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg = this.emlSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smsSndFlg = this.smsSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNtcFlg = this.srepNtcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delFlg = this.delFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrePstCd = this.vslPrePstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfSts = this.rfSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smsSndDt = this.smsSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcExp = this.ntcExp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprPic = this.shprPic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mblSndFlg = this.mblSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akSts = this.akSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfDesc = this.rfDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsMode = this.trnsMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obPicNtcFlg = this.obPicNtcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
