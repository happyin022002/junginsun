/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrLotVO.java
*@FileTitle : CntrLotVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.19
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.19 이호선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo;

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
 * @author 이호선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrLotVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrLotVO> models = new ArrayList<CntrLotVO>();
	
	/* Column Info */
	private String lotSeq = null;
	/* Column Info */
	private String minTemp = null;
	/* Column Info */
	private String lotLocCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String orgMftVndrSeq = null;
	/* Column Info */
	private String orgRfMdlNm = null;
	/* Column Info */
	private String orgRfMkrSeq = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String orgRfRfrNo = null;
	/* Column Info */
	private String aproTirNo = null;
	/* Column Info */
	private String toSerNo = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String unitType = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String hjsCreFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String orgMinTemp = null;
	/* Column Info */
	private String rfRfrNo = null;
	/* Column Info */
	private String cntrHngrRckCd = null;
	/* Column Info */
	private String orgAgmtNo = null;
	/* Column Info */
	private String cntrSpecNo = null;
	/* Column Info */
	private String orgCertiNo = null;
	/* Column Info */
	private String fmSerNo = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String lotPlnYr = null;
	/* Column Info */
	private String orgDeYrmon = null;
	/* Column Info */
	private String rfMdlNm = null;
	/* Column Info */
	private String lotNo2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String certiNo = null;
	/* Column Info */
	private String lotCntrPfxCd = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String aproUicNo = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String orgPlstFlrFlg = null;
	/* Column Info */
	private String rangeCount = null;
	/* Column Info */
	private String mftVndrSeq = null;
	/* Column Info */
	private String orgFctrySpecNo = null;
	/* Column Info */
	private String lotNo = null;
	/* Column Info */
	private String orgCntrHngrRckCd = null;
	/* Column Info */
	private String aproTctNo = null;
	/* Column Info */
	private String plstFlrFlg = null;
	/* Column Info */
	private String deYrmon = null;
	/* Column Info */
	private String maxTemp = null;
	/* Column Info */
	private String mftDt = null;
	/* Column Info */
	private String faIfGrpStsCd = null;
	/* Column Info */
	private String rfMkrSeq = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String orgMftDt = null;
	/* Column Info */
	private String fctrySpecNo = null;
	/* Column Info */
	private String aproCscNo = null;
	/* Column Info */
	private String cntrMtrlCd = null;
	/* Column Info */
	private String orgMaxTemp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrLotVO() {}

	public CntrLotVO(String ibflag, String pagerows, String orgAgmtNo, String cntrSpecNo, String orgCertiNo, String fmSerNo, String vndrLglEngNm, String lotPlnYr, String orgDeYrmon, String lotSeq, String lotLocCd, String lotNo2, String effDt, String orgMftVndrSeq, String lotCntrPfxCd, String certiNo, String agmtCtyCd, String cntrTpszCd, String aproTirNo, String aproUicNo, String orgPlstFlrFlg, String expDt, String lstmCd, String toSerNo, String rangeCount, String mftVndrSeq, String updUsrId, String orgFctrySpecNo, String lotNo, String orgCntrHngrRckCd, String agmtSeq, String agmtNo, String hjsCreFlg, String aproTctNo, String plstFlrFlg, String deYrmon, String mftDt, String faIfGrpStsCd, String ofcCd, String creUsrId, String diffRmk, String orgMftDt, String vndrSeq, String fctrySpecNo, String aproCscNo, String vndrAbbrNm, String cntrMtrlCd, String cntrHngrRckCd, String unitType, String rfMkrSeq, String rfMdlNm, String rfRfrNo, String minTemp, String maxTemp, String orgRfMkrSeq, String orgRfMdlNm, String orgRfRfrNo, String orgMinTemp, String orgMaxTemp) {
		this.lotSeq = lotSeq;
		this.minTemp = minTemp;
		this.lotLocCd = lotLocCd;
		this.pagerows = pagerows;
		this.effDt = effDt;
		this.orgMftVndrSeq = orgMftVndrSeq;
		this.orgRfMdlNm = orgRfMdlNm;
		this.orgRfMkrSeq = orgRfMkrSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.orgRfRfrNo = orgRfRfrNo;
		this.aproTirNo = aproTirNo;
		this.toSerNo = toSerNo;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
		this.unitType = unitType;
		this.agmtSeq = agmtSeq;
		this.agmtNo = agmtNo;
		this.hjsCreFlg = hjsCreFlg;
		this.creUsrId = creUsrId;
		this.vndrSeq = vndrSeq;
		this.vndrAbbrNm = vndrAbbrNm;
		this.orgMinTemp = orgMinTemp;
		this.rfRfrNo = rfRfrNo;
		this.cntrHngrRckCd = cntrHngrRckCd;
		this.orgAgmtNo = orgAgmtNo;
		this.cntrSpecNo = cntrSpecNo;
		this.orgCertiNo = orgCertiNo;
		this.fmSerNo = fmSerNo;
		this.vndrLglEngNm = vndrLglEngNm;
		this.lotPlnYr = lotPlnYr;
		this.orgDeYrmon = orgDeYrmon;
		this.rfMdlNm = rfMdlNm;
		this.lotNo2 = lotNo2;
		this.ibflag = ibflag;
		this.certiNo = certiNo;
		this.lotCntrPfxCd = lotCntrPfxCd;
		this.agmtCtyCd = agmtCtyCd;
		this.aproUicNo = aproUicNo;
		this.expDt = expDt;
		this.orgPlstFlrFlg = orgPlstFlrFlg;
		this.rangeCount = rangeCount;
		this.mftVndrSeq = mftVndrSeq;
		this.orgFctrySpecNo = orgFctrySpecNo;
		this.lotNo = lotNo;
		this.orgCntrHngrRckCd = orgCntrHngrRckCd;
		this.aproTctNo = aproTctNo;
		this.plstFlrFlg = plstFlrFlg;
		this.deYrmon = deYrmon;
		this.maxTemp = maxTemp;
		this.mftDt = mftDt;
		this.faIfGrpStsCd = faIfGrpStsCd;
		this.rfMkrSeq = rfMkrSeq;
		this.ofcCd = ofcCd;
		this.diffRmk = diffRmk;
		this.orgMftDt = orgMftDt;
		this.fctrySpecNo = fctrySpecNo;
		this.aproCscNo = aproCscNo;
		this.cntrMtrlCd = cntrMtrlCd;
		this.orgMaxTemp = orgMaxTemp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lot_seq", getLotSeq());
		this.hashColumns.put("min_temp", getMinTemp());
		this.hashColumns.put("lot_loc_cd", getLotLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("org_mft_vndr_seq", getOrgMftVndrSeq());
		this.hashColumns.put("org_rf_mdl_nm", getOrgRfMdlNm());
		this.hashColumns.put("org_rf_mkr_seq", getOrgRfMkrSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("org_rf_rfr_no", getOrgRfRfrNo());
		this.hashColumns.put("apro_tir_no", getAproTirNo());
		this.hashColumns.put("to_ser_no", getToSerNo());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("unit_type", getUnitType());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("hjs_cre_flg", getHjsCreFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("org_min_temp", getOrgMinTemp());
		this.hashColumns.put("rf_rfr_no", getRfRfrNo());
		this.hashColumns.put("cntr_hngr_rck_cd", getCntrHngrRckCd());
		this.hashColumns.put("org_agmt_no", getOrgAgmtNo());
		this.hashColumns.put("cntr_spec_no", getCntrSpecNo());
		this.hashColumns.put("org_certi_no", getOrgCertiNo());
		this.hashColumns.put("fm_ser_no", getFmSerNo());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("lot_pln_yr", getLotPlnYr());
		this.hashColumns.put("org_de_yrmon", getOrgDeYrmon());
		this.hashColumns.put("rf_mdl_nm", getRfMdlNm());
		this.hashColumns.put("lot_no2", getLotNo2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("certi_no", getCertiNo());
		this.hashColumns.put("lot_cntr_pfx_cd", getLotCntrPfxCd());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("apro_uic_no", getAproUicNo());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("org_plst_flr_flg", getOrgPlstFlrFlg());
		this.hashColumns.put("range_count", getRangeCount());
		this.hashColumns.put("mft_vndr_seq", getMftVndrSeq());
		this.hashColumns.put("org_fctry_spec_no", getOrgFctrySpecNo());
		this.hashColumns.put("lot_no", getLotNo());
		this.hashColumns.put("org_cntr_hngr_rck_cd", getOrgCntrHngrRckCd());
		this.hashColumns.put("apro_tct_no", getAproTctNo());
		this.hashColumns.put("plst_flr_flg", getPlstFlrFlg());
		this.hashColumns.put("de_yrmon", getDeYrmon());
		this.hashColumns.put("max_temp", getMaxTemp());
		this.hashColumns.put("mft_dt", getMftDt());
		this.hashColumns.put("fa_if_grp_sts_cd", getFaIfGrpStsCd());
		this.hashColumns.put("rf_mkr_seq", getRfMkrSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("org_mft_dt", getOrgMftDt());
		this.hashColumns.put("fctry_spec_no", getFctrySpecNo());
		this.hashColumns.put("apro_csc_no", getAproCscNo());
		this.hashColumns.put("cntr_mtrl_cd", getCntrMtrlCd());
		this.hashColumns.put("org_max_temp", getOrgMaxTemp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lot_seq", "lotSeq");
		this.hashFields.put("min_temp", "minTemp");
		this.hashFields.put("lot_loc_cd", "lotLocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("org_mft_vndr_seq", "orgMftVndrSeq");
		this.hashFields.put("org_rf_mdl_nm", "orgRfMdlNm");
		this.hashFields.put("org_rf_mkr_seq", "orgRfMkrSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("org_rf_rfr_no", "orgRfRfrNo");
		this.hashFields.put("apro_tir_no", "aproTirNo");
		this.hashFields.put("to_ser_no", "toSerNo");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("unit_type", "unitType");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("hjs_cre_flg", "hjsCreFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("org_min_temp", "orgMinTemp");
		this.hashFields.put("rf_rfr_no", "rfRfrNo");
		this.hashFields.put("cntr_hngr_rck_cd", "cntrHngrRckCd");
		this.hashFields.put("org_agmt_no", "orgAgmtNo");
		this.hashFields.put("cntr_spec_no", "cntrSpecNo");
		this.hashFields.put("org_certi_no", "orgCertiNo");
		this.hashFields.put("fm_ser_no", "fmSerNo");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("lot_pln_yr", "lotPlnYr");
		this.hashFields.put("org_de_yrmon", "orgDeYrmon");
		this.hashFields.put("rf_mdl_nm", "rfMdlNm");
		this.hashFields.put("lot_no2", "lotNo2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("certi_no", "certiNo");
		this.hashFields.put("lot_cntr_pfx_cd", "lotCntrPfxCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("apro_uic_no", "aproUicNo");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("org_plst_flr_flg", "orgPlstFlrFlg");
		this.hashFields.put("range_count", "rangeCount");
		this.hashFields.put("mft_vndr_seq", "mftVndrSeq");
		this.hashFields.put("org_fctry_spec_no", "orgFctrySpecNo");
		this.hashFields.put("lot_no", "lotNo");
		this.hashFields.put("org_cntr_hngr_rck_cd", "orgCntrHngrRckCd");
		this.hashFields.put("apro_tct_no", "aproTctNo");
		this.hashFields.put("plst_flr_flg", "plstFlrFlg");
		this.hashFields.put("de_yrmon", "deYrmon");
		this.hashFields.put("max_temp", "maxTemp");
		this.hashFields.put("mft_dt", "mftDt");
		this.hashFields.put("fa_if_grp_sts_cd", "faIfGrpStsCd");
		this.hashFields.put("rf_mkr_seq", "rfMkrSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("org_mft_dt", "orgMftDt");
		this.hashFields.put("fctry_spec_no", "fctrySpecNo");
		this.hashFields.put("apro_csc_no", "aproCscNo");
		this.hashFields.put("cntr_mtrl_cd", "cntrMtrlCd");
		this.hashFields.put("org_max_temp", "orgMaxTemp");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lotSeq
	 */
	public String getLotSeq() {
		return this.lotSeq;
	}
	
	/**
	 * Column Info
	 * @return minTemp
	 */
	public String getMinTemp() {
		return this.minTemp;
	}
	
	/**
	 * Column Info
	 * @return lotLocCd
	 */
	public String getLotLocCd() {
		return this.lotLocCd;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return orgMftVndrSeq
	 */
	public String getOrgMftVndrSeq() {
		return this.orgMftVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return orgRfMdlNm
	 */
	public String getOrgRfMdlNm() {
		return this.orgRfMdlNm;
	}
	
	/**
	 * Column Info
	 * @return orgRfMkrSeq
	 */
	public String getOrgRfMkrSeq() {
		return this.orgRfMkrSeq;
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
	 * @return orgRfRfrNo
	 */
	public String getOrgRfRfrNo() {
		return this.orgRfRfrNo;
	}
	
	/**
	 * Column Info
	 * @return aproTirNo
	 */
	public String getAproTirNo() {
		return this.aproTirNo;
	}
	
	/**
	 * Column Info
	 * @return toSerNo
	 */
	public String getToSerNo() {
		return this.toSerNo;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
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
	 * @return unitType
	 */
	public String getUnitType() {
		return this.unitType;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return hjsCreFlg
	 */
	public String getHjsCreFlg() {
		return this.hjsCreFlg;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return orgMinTemp
	 */
	public String getOrgMinTemp() {
		return this.orgMinTemp;
	}
	
	/**
	 * Column Info
	 * @return rfRfrNo
	 */
	public String getRfRfrNo() {
		return this.rfRfrNo;
	}
	
	/**
	 * Column Info
	 * @return cntrHngrRckCd
	 */
	public String getCntrHngrRckCd() {
		return this.cntrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @return orgAgmtNo
	 */
	public String getOrgAgmtNo() {
		return this.orgAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return cntrSpecNo
	 */
	public String getCntrSpecNo() {
		return this.cntrSpecNo;
	}
	
	/**
	 * Column Info
	 * @return orgCertiNo
	 */
	public String getOrgCertiNo() {
		return this.orgCertiNo;
	}
	
	/**
	 * Column Info
	 * @return fmSerNo
	 */
	public String getFmSerNo() {
		return this.fmSerNo;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return lotPlnYr
	 */
	public String getLotPlnYr() {
		return this.lotPlnYr;
	}
	
	/**
	 * Column Info
	 * @return orgDeYrmon
	 */
	public String getOrgDeYrmon() {
		return this.orgDeYrmon;
	}
	
	/**
	 * Column Info
	 * @return rfMdlNm
	 */
	public String getRfMdlNm() {
		return this.rfMdlNm;
	}
	
	/**
	 * Column Info
	 * @return lotNo2
	 */
	public String getLotNo2() {
		return this.lotNo2;
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
	 * @return certiNo
	 */
	public String getCertiNo() {
		return this.certiNo;
	}
	
	/**
	 * Column Info
	 * @return lotCntrPfxCd
	 */
	public String getLotCntrPfxCd() {
		return this.lotCntrPfxCd;
	}
	
	/**
	 * Column Info
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @return aproUicNo
	 */
	public String getAproUicNo() {
		return this.aproUicNo;
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
	 * @return orgPlstFlrFlg
	 */
	public String getOrgPlstFlrFlg() {
		return this.orgPlstFlrFlg;
	}
	
	/**
	 * Column Info
	 * @return rangeCount
	 */
	public String getRangeCount() {
		return this.rangeCount;
	}
	
	/**
	 * Column Info
	 * @return mftVndrSeq
	 */
	public String getMftVndrSeq() {
		return this.mftVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return orgFctrySpecNo
	 */
	public String getOrgFctrySpecNo() {
		return this.orgFctrySpecNo;
	}
	
	/**
	 * Column Info
	 * @return lotNo
	 */
	public String getLotNo() {
		return this.lotNo;
	}
	
	/**
	 * Column Info
	 * @return orgCntrHngrRckCd
	 */
	public String getOrgCntrHngrRckCd() {
		return this.orgCntrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @return aproTctNo
	 */
	public String getAproTctNo() {
		return this.aproTctNo;
	}
	
	/**
	 * Column Info
	 * @return plstFlrFlg
	 */
	public String getPlstFlrFlg() {
		return this.plstFlrFlg;
	}
	
	/**
	 * Column Info
	 * @return deYrmon
	 */
	public String getDeYrmon() {
		return this.deYrmon;
	}
	
	/**
	 * Column Info
	 * @return maxTemp
	 */
	public String getMaxTemp() {
		return this.maxTemp;
	}
	
	/**
	 * Column Info
	 * @return mftDt
	 */
	public String getMftDt() {
		return this.mftDt;
	}
	
	/**
	 * Column Info
	 * @return faIfGrpStsCd
	 */
	public String getFaIfGrpStsCd() {
		return this.faIfGrpStsCd;
	}
	
	/**
	 * Column Info
	 * @return rfMkrSeq
	 */
	public String getRfMkrSeq() {
		return this.rfMkrSeq;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return orgMftDt
	 */
	public String getOrgMftDt() {
		return this.orgMftDt;
	}
	
	/**
	 * Column Info
	 * @return fctrySpecNo
	 */
	public String getFctrySpecNo() {
		return this.fctrySpecNo;
	}
	
	/**
	 * Column Info
	 * @return aproCscNo
	 */
	public String getAproCscNo() {
		return this.aproCscNo;
	}
	
	/**
	 * Column Info
	 * @return cntrMtrlCd
	 */
	public String getCntrMtrlCd() {
		return this.cntrMtrlCd;
	}
	
	/**
	 * Column Info
	 * @return orgMaxTemp
	 */
	public String getOrgMaxTemp() {
		return this.orgMaxTemp;
	}
	

	/**
	 * Column Info
	 * @param lotSeq
	 */
	public void setLotSeq(String lotSeq) {
		this.lotSeq = lotSeq;
	}
	
	/**
	 * Column Info
	 * @param minTemp
	 */
	public void setMinTemp(String minTemp) {
		this.minTemp = minTemp;
	}
	
	/**
	 * Column Info
	 * @param lotLocCd
	 */
	public void setLotLocCd(String lotLocCd) {
		this.lotLocCd = lotLocCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param orgMftVndrSeq
	 */
	public void setOrgMftVndrSeq(String orgMftVndrSeq) {
		this.orgMftVndrSeq = orgMftVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param orgRfMdlNm
	 */
	public void setOrgRfMdlNm(String orgRfMdlNm) {
		this.orgRfMdlNm = orgRfMdlNm;
	}
	
	/**
	 * Column Info
	 * @param orgRfMkrSeq
	 */
	public void setOrgRfMkrSeq(String orgRfMkrSeq) {
		this.orgRfMkrSeq = orgRfMkrSeq;
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
	 * @param orgRfRfrNo
	 */
	public void setOrgRfRfrNo(String orgRfRfrNo) {
		this.orgRfRfrNo = orgRfRfrNo;
	}
	
	/**
	 * Column Info
	 * @param aproTirNo
	 */
	public void setAproTirNo(String aproTirNo) {
		this.aproTirNo = aproTirNo;
	}
	
	/**
	 * Column Info
	 * @param toSerNo
	 */
	public void setToSerNo(String toSerNo) {
		this.toSerNo = toSerNo;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
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
	 * @param unitType
	 */
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param hjsCreFlg
	 */
	public void setHjsCreFlg(String hjsCreFlg) {
		this.hjsCreFlg = hjsCreFlg;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param orgMinTemp
	 */
	public void setOrgMinTemp(String orgMinTemp) {
		this.orgMinTemp = orgMinTemp;
	}
	
	/**
	 * Column Info
	 * @param rfRfrNo
	 */
	public void setRfRfrNo(String rfRfrNo) {
		this.rfRfrNo = rfRfrNo;
	}
	
	/**
	 * Column Info
	 * @param cntrHngrRckCd
	 */
	public void setCntrHngrRckCd(String cntrHngrRckCd) {
		this.cntrHngrRckCd = cntrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @param orgAgmtNo
	 */
	public void setOrgAgmtNo(String orgAgmtNo) {
		this.orgAgmtNo = orgAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param cntrSpecNo
	 */
	public void setCntrSpecNo(String cntrSpecNo) {
		this.cntrSpecNo = cntrSpecNo;
	}
	
	/**
	 * Column Info
	 * @param orgCertiNo
	 */
	public void setOrgCertiNo(String orgCertiNo) {
		this.orgCertiNo = orgCertiNo;
	}
	
	/**
	 * Column Info
	 * @param fmSerNo
	 */
	public void setFmSerNo(String fmSerNo) {
		this.fmSerNo = fmSerNo;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param lotPlnYr
	 */
	public void setLotPlnYr(String lotPlnYr) {
		this.lotPlnYr = lotPlnYr;
	}
	
	/**
	 * Column Info
	 * @param orgDeYrmon
	 */
	public void setOrgDeYrmon(String orgDeYrmon) {
		this.orgDeYrmon = orgDeYrmon;
	}
	
	/**
	 * Column Info
	 * @param rfMdlNm
	 */
	public void setRfMdlNm(String rfMdlNm) {
		this.rfMdlNm = rfMdlNm;
	}
	
	/**
	 * Column Info
	 * @param lotNo2
	 */
	public void setLotNo2(String lotNo2) {
		this.lotNo2 = lotNo2;
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
	 * @param certiNo
	 */
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
	}
	
	/**
	 * Column Info
	 * @param lotCntrPfxCd
	 */
	public void setLotCntrPfxCd(String lotCntrPfxCd) {
		this.lotCntrPfxCd = lotCntrPfxCd;
	}
	
	/**
	 * Column Info
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @param aproUicNo
	 */
	public void setAproUicNo(String aproUicNo) {
		this.aproUicNo = aproUicNo;
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
	 * @param orgPlstFlrFlg
	 */
	public void setOrgPlstFlrFlg(String orgPlstFlrFlg) {
		this.orgPlstFlrFlg = orgPlstFlrFlg;
	}
	
	/**
	 * Column Info
	 * @param rangeCount
	 */
	public void setRangeCount(String rangeCount) {
		this.rangeCount = rangeCount;
	}
	
	/**
	 * Column Info
	 * @param mftVndrSeq
	 */
	public void setMftVndrSeq(String mftVndrSeq) {
		this.mftVndrSeq = mftVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param orgFctrySpecNo
	 */
	public void setOrgFctrySpecNo(String orgFctrySpecNo) {
		this.orgFctrySpecNo = orgFctrySpecNo;
	}
	
	/**
	 * Column Info
	 * @param lotNo
	 */
	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}
	
	/**
	 * Column Info
	 * @param orgCntrHngrRckCd
	 */
	public void setOrgCntrHngrRckCd(String orgCntrHngrRckCd) {
		this.orgCntrHngrRckCd = orgCntrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @param aproTctNo
	 */
	public void setAproTctNo(String aproTctNo) {
		this.aproTctNo = aproTctNo;
	}
	
	/**
	 * Column Info
	 * @param plstFlrFlg
	 */
	public void setPlstFlrFlg(String plstFlrFlg) {
		this.plstFlrFlg = plstFlrFlg;
	}
	
	/**
	 * Column Info
	 * @param deYrmon
	 */
	public void setDeYrmon(String deYrmon) {
		this.deYrmon = deYrmon;
	}
	
	/**
	 * Column Info
	 * @param maxTemp
	 */
	public void setMaxTemp(String maxTemp) {
		this.maxTemp = maxTemp;
	}
	
	/**
	 * Column Info
	 * @param mftDt
	 */
	public void setMftDt(String mftDt) {
		this.mftDt = mftDt;
	}
	
	/**
	 * Column Info
	 * @param faIfGrpStsCd
	 */
	public void setFaIfGrpStsCd(String faIfGrpStsCd) {
		this.faIfGrpStsCd = faIfGrpStsCd;
	}
	
	/**
	 * Column Info
	 * @param rfMkrSeq
	 */
	public void setRfMkrSeq(String rfMkrSeq) {
		this.rfMkrSeq = rfMkrSeq;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param orgMftDt
	 */
	public void setOrgMftDt(String orgMftDt) {
		this.orgMftDt = orgMftDt;
	}
	
	/**
	 * Column Info
	 * @param fctrySpecNo
	 */
	public void setFctrySpecNo(String fctrySpecNo) {
		this.fctrySpecNo = fctrySpecNo;
	}
	
	/**
	 * Column Info
	 * @param aproCscNo
	 */
	public void setAproCscNo(String aproCscNo) {
		this.aproCscNo = aproCscNo;
	}
	
	/**
	 * Column Info
	 * @param cntrMtrlCd
	 */
	public void setCntrMtrlCd(String cntrMtrlCd) {
		this.cntrMtrlCd = cntrMtrlCd;
	}
	
	/**
	 * Column Info
	 * @param orgMaxTemp
	 */
	public void setOrgMaxTemp(String orgMaxTemp) {
		this.orgMaxTemp = orgMaxTemp;
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
		setLotSeq(JSPUtil.getParameter(request, prefix + "lot_seq", ""));
		setMinTemp(JSPUtil.getParameter(request, prefix + "min_temp", ""));
		setLotLocCd(JSPUtil.getParameter(request, prefix + "lot_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setOrgMftVndrSeq(JSPUtil.getParameter(request, prefix + "org_mft_vndr_seq", ""));
		setOrgRfMdlNm(JSPUtil.getParameter(request, prefix + "org_rf_mdl_nm", ""));
		setOrgRfMkrSeq(JSPUtil.getParameter(request, prefix + "org_rf_mkr_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setOrgRfRfrNo(JSPUtil.getParameter(request, prefix + "org_rf_rfr_no", ""));
		setAproTirNo(JSPUtil.getParameter(request, prefix + "apro_tir_no", ""));
		setToSerNo(JSPUtil.getParameter(request, prefix + "to_ser_no", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUnitType(JSPUtil.getParameter(request, prefix + "unit_type", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setHjsCreFlg(JSPUtil.getParameter(request, prefix + "hjs_cre_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", ""));
		setOrgMinTemp(JSPUtil.getParameter(request, prefix + "org_min_temp", ""));
		setRfRfrNo(JSPUtil.getParameter(request, prefix + "rf_rfr_no", ""));
		setCntrHngrRckCd(JSPUtil.getParameter(request, prefix + "cntr_hngr_rck_cd", ""));
		setOrgAgmtNo(JSPUtil.getParameter(request, prefix + "org_agmt_no", ""));
		setCntrSpecNo(JSPUtil.getParameter(request, prefix + "cntr_spec_no", ""));
		setOrgCertiNo(JSPUtil.getParameter(request, prefix + "org_certi_no", ""));
		setFmSerNo(JSPUtil.getParameter(request, prefix + "fm_ser_no", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setLotPlnYr(JSPUtil.getParameter(request, prefix + "lot_pln_yr", ""));
		setOrgDeYrmon(JSPUtil.getParameter(request, prefix + "org_de_yrmon", ""));
		setRfMdlNm(JSPUtil.getParameter(request, prefix + "rf_mdl_nm", ""));
		setLotNo2(JSPUtil.getParameter(request, prefix + "lot_no2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCertiNo(JSPUtil.getParameter(request, prefix + "certi_no", ""));
		setLotCntrPfxCd(JSPUtil.getParameter(request, prefix + "lot_cntr_pfx_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, prefix + "agmt_cty_cd", ""));
		setAproUicNo(JSPUtil.getParameter(request, prefix + "apro_uic_no", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setOrgPlstFlrFlg(JSPUtil.getParameter(request, prefix + "org_plst_flr_flg", ""));
		setRangeCount(JSPUtil.getParameter(request, prefix + "range_count", ""));
		setMftVndrSeq(JSPUtil.getParameter(request, prefix + "mft_vndr_seq", ""));
		setOrgFctrySpecNo(JSPUtil.getParameter(request, prefix + "org_fctry_spec_no", ""));
		setLotNo(JSPUtil.getParameter(request, prefix + "lot_no", ""));
		setOrgCntrHngrRckCd(JSPUtil.getParameter(request, prefix + "org_cntr_hngr_rck_cd", ""));
		setAproTctNo(JSPUtil.getParameter(request, prefix + "apro_tct_no", ""));
		setPlstFlrFlg(JSPUtil.getParameter(request, prefix + "plst_flr_flg", ""));
		setDeYrmon(JSPUtil.getParameter(request, prefix + "de_yrmon", ""));
		setMaxTemp(JSPUtil.getParameter(request, prefix + "max_temp", ""));
		setMftDt(JSPUtil.getParameter(request, prefix + "mft_dt", ""));
		setFaIfGrpStsCd(JSPUtil.getParameter(request, prefix + "fa_if_grp_sts_cd", ""));
		setRfMkrSeq(JSPUtil.getParameter(request, prefix + "rf_mkr_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setOrgMftDt(JSPUtil.getParameter(request, prefix + "org_mft_dt", ""));
		setFctrySpecNo(JSPUtil.getParameter(request, prefix + "fctry_spec_no", ""));
		setAproCscNo(JSPUtil.getParameter(request, prefix + "apro_csc_no", ""));
		setCntrMtrlCd(JSPUtil.getParameter(request, prefix + "cntr_mtrl_cd", ""));
		setOrgMaxTemp(JSPUtil.getParameter(request, prefix + "org_max_temp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrLotVO[]
	 */
	public CntrLotVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrLotVO[]
	 */
	public CntrLotVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrLotVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lotSeq = (JSPUtil.getParameter(request, prefix	+ "lot_seq", length));
			String[] minTemp = (JSPUtil.getParameter(request, prefix	+ "min_temp", length));
			String[] lotLocCd = (JSPUtil.getParameter(request, prefix	+ "lot_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] orgMftVndrSeq = (JSPUtil.getParameter(request, prefix	+ "org_mft_vndr_seq", length));
			String[] orgRfMdlNm = (JSPUtil.getParameter(request, prefix	+ "org_rf_mdl_nm", length));
			String[] orgRfMkrSeq = (JSPUtil.getParameter(request, prefix	+ "org_rf_mkr_seq", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] orgRfRfrNo = (JSPUtil.getParameter(request, prefix	+ "org_rf_rfr_no", length));
			String[] aproTirNo = (JSPUtil.getParameter(request, prefix	+ "apro_tir_no", length));
			String[] toSerNo = (JSPUtil.getParameter(request, prefix	+ "to_ser_no", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] unitType = (JSPUtil.getParameter(request, prefix	+ "unit_type", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] hjsCreFlg = (JSPUtil.getParameter(request, prefix	+ "hjs_cre_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] orgMinTemp = (JSPUtil.getParameter(request, prefix	+ "org_min_temp", length));
			String[] rfRfrNo = (JSPUtil.getParameter(request, prefix	+ "rf_rfr_no", length));
			String[] cntrHngrRckCd = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_rck_cd", length));
			String[] orgAgmtNo = (JSPUtil.getParameter(request, prefix	+ "org_agmt_no", length));
			String[] cntrSpecNo = (JSPUtil.getParameter(request, prefix	+ "cntr_spec_no", length));
			String[] orgCertiNo = (JSPUtil.getParameter(request, prefix	+ "org_certi_no", length));
			String[] fmSerNo = (JSPUtil.getParameter(request, prefix	+ "fm_ser_no", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] lotPlnYr = (JSPUtil.getParameter(request, prefix	+ "lot_pln_yr", length));
			String[] orgDeYrmon = (JSPUtil.getParameter(request, prefix	+ "org_de_yrmon", length));
			String[] rfMdlNm = (JSPUtil.getParameter(request, prefix	+ "rf_mdl_nm", length));
			String[] lotNo2 = (JSPUtil.getParameter(request, prefix	+ "lot_no2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] certiNo = (JSPUtil.getParameter(request, prefix	+ "certi_no", length));
			String[] lotCntrPfxCd = (JSPUtil.getParameter(request, prefix	+ "lot_cntr_pfx_cd", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] aproUicNo = (JSPUtil.getParameter(request, prefix	+ "apro_uic_no", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] orgPlstFlrFlg = (JSPUtil.getParameter(request, prefix	+ "org_plst_flr_flg", length));
			String[] rangeCount = (JSPUtil.getParameter(request, prefix	+ "range_count", length));
			String[] mftVndrSeq = (JSPUtil.getParameter(request, prefix	+ "mft_vndr_seq", length));
			String[] orgFctrySpecNo = (JSPUtil.getParameter(request, prefix	+ "org_fctry_spec_no", length));
			String[] lotNo = (JSPUtil.getParameter(request, prefix	+ "lot_no", length));
			String[] orgCntrHngrRckCd = (JSPUtil.getParameter(request, prefix	+ "org_cntr_hngr_rck_cd", length));
			String[] aproTctNo = (JSPUtil.getParameter(request, prefix	+ "apro_tct_no", length));
			String[] plstFlrFlg = (JSPUtil.getParameter(request, prefix	+ "plst_flr_flg", length));
			String[] deYrmon = (JSPUtil.getParameter(request, prefix	+ "de_yrmon", length));
			String[] maxTemp = (JSPUtil.getParameter(request, prefix	+ "max_temp", length));
			String[] mftDt = (JSPUtil.getParameter(request, prefix	+ "mft_dt", length));
			String[] faIfGrpStsCd = (JSPUtil.getParameter(request, prefix	+ "fa_if_grp_sts_cd", length));
			String[] rfMkrSeq = (JSPUtil.getParameter(request, prefix	+ "rf_mkr_seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] orgMftDt = (JSPUtil.getParameter(request, prefix	+ "org_mft_dt", length));
			String[] fctrySpecNo = (JSPUtil.getParameter(request, prefix	+ "fctry_spec_no", length));
			String[] aproCscNo = (JSPUtil.getParameter(request, prefix	+ "apro_csc_no", length));
			String[] cntrMtrlCd = (JSPUtil.getParameter(request, prefix	+ "cntr_mtrl_cd", length));
			String[] orgMaxTemp = (JSPUtil.getParameter(request, prefix	+ "org_max_temp", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrLotVO();
				if (lotSeq[i] != null)
					model.setLotSeq(lotSeq[i]);
				if (minTemp[i] != null)
					model.setMinTemp(minTemp[i]);
				if (lotLocCd[i] != null)
					model.setLotLocCd(lotLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (orgMftVndrSeq[i] != null)
					model.setOrgMftVndrSeq(orgMftVndrSeq[i]);
				if (orgRfMdlNm[i] != null)
					model.setOrgRfMdlNm(orgRfMdlNm[i]);
				if (orgRfMkrSeq[i] != null)
					model.setOrgRfMkrSeq(orgRfMkrSeq[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (orgRfRfrNo[i] != null)
					model.setOrgRfRfrNo(orgRfRfrNo[i]);
				if (aproTirNo[i] != null)
					model.setAproTirNo(aproTirNo[i]);
				if (toSerNo[i] != null)
					model.setToSerNo(toSerNo[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (unitType[i] != null)
					model.setUnitType(unitType[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (hjsCreFlg[i] != null)
					model.setHjsCreFlg(hjsCreFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (orgMinTemp[i] != null)
					model.setOrgMinTemp(orgMinTemp[i]);
				if (rfRfrNo[i] != null)
					model.setRfRfrNo(rfRfrNo[i]);
				if (cntrHngrRckCd[i] != null)
					model.setCntrHngrRckCd(cntrHngrRckCd[i]);
				if (orgAgmtNo[i] != null)
					model.setOrgAgmtNo(orgAgmtNo[i]);
				if (cntrSpecNo[i] != null)
					model.setCntrSpecNo(cntrSpecNo[i]);
				if (orgCertiNo[i] != null)
					model.setOrgCertiNo(orgCertiNo[i]);
				if (fmSerNo[i] != null)
					model.setFmSerNo(fmSerNo[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (lotPlnYr[i] != null)
					model.setLotPlnYr(lotPlnYr[i]);
				if (orgDeYrmon[i] != null)
					model.setOrgDeYrmon(orgDeYrmon[i]);
				if (rfMdlNm[i] != null)
					model.setRfMdlNm(rfMdlNm[i]);
				if (lotNo2[i] != null)
					model.setLotNo2(lotNo2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (certiNo[i] != null)
					model.setCertiNo(certiNo[i]);
				if (lotCntrPfxCd[i] != null)
					model.setLotCntrPfxCd(lotCntrPfxCd[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (aproUicNo[i] != null)
					model.setAproUicNo(aproUicNo[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (orgPlstFlrFlg[i] != null)
					model.setOrgPlstFlrFlg(orgPlstFlrFlg[i]);
				if (rangeCount[i] != null)
					model.setRangeCount(rangeCount[i]);
				if (mftVndrSeq[i] != null)
					model.setMftVndrSeq(mftVndrSeq[i]);
				if (orgFctrySpecNo[i] != null)
					model.setOrgFctrySpecNo(orgFctrySpecNo[i]);
				if (lotNo[i] != null)
					model.setLotNo(lotNo[i]);
				if (orgCntrHngrRckCd[i] != null)
					model.setOrgCntrHngrRckCd(orgCntrHngrRckCd[i]);
				if (aproTctNo[i] != null)
					model.setAproTctNo(aproTctNo[i]);
				if (plstFlrFlg[i] != null)
					model.setPlstFlrFlg(plstFlrFlg[i]);
				if (deYrmon[i] != null)
					model.setDeYrmon(deYrmon[i]);
				if (maxTemp[i] != null)
					model.setMaxTemp(maxTemp[i]);
				if (mftDt[i] != null)
					model.setMftDt(mftDt[i]);
				if (faIfGrpStsCd[i] != null)
					model.setFaIfGrpStsCd(faIfGrpStsCd[i]);
				if (rfMkrSeq[i] != null)
					model.setRfMkrSeq(rfMkrSeq[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (orgMftDt[i] != null)
					model.setOrgMftDt(orgMftDt[i]);
				if (fctrySpecNo[i] != null)
					model.setFctrySpecNo(fctrySpecNo[i]);
				if (aproCscNo[i] != null)
					model.setAproCscNo(aproCscNo[i]);
				if (cntrMtrlCd[i] != null)
					model.setCntrMtrlCd(cntrMtrlCd[i]);
				if (orgMaxTemp[i] != null)
					model.setOrgMaxTemp(orgMaxTemp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrLotVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrLotVO[]
	 */
	public CntrLotVO[] getCntrLotVOs(){
		CntrLotVO[] vos = (CntrLotVO[])models.toArray(new CntrLotVO[models.size()]);
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
		this.lotSeq = this.lotSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minTemp = this.minTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotLocCd = this.lotLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgMftVndrSeq = this.orgMftVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRfMdlNm = this.orgRfMdlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRfMkrSeq = this.orgRfMkrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRfRfrNo = this.orgRfRfrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproTirNo = this.aproTirNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSerNo = this.toSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unitType = this.unitType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsCreFlg = this.hjsCreFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgMinTemp = this.orgMinTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRfrNo = this.rfRfrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCd = this.cntrHngrRckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgAgmtNo = this.orgAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSpecNo = this.cntrSpecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCertiNo = this.orgCertiNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmSerNo = this.fmSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotPlnYr = this.lotPlnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDeYrmon = this.orgDeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMdlNm = this.rfMdlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotNo2 = this.lotNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certiNo = this.certiNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotCntrPfxCd = this.lotCntrPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUicNo = this.aproUicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPlstFlrFlg = this.orgPlstFlrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rangeCount = this.rangeCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftVndrSeq = this.mftVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgFctrySpecNo = this.orgFctrySpecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotNo = this.lotNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCntrHngrRckCd = this.orgCntrHngrRckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproTctNo = this.aproTctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plstFlrFlg = this.plstFlrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deYrmon = this.deYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxTemp = this.maxTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt = this.mftDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faIfGrpStsCd = this.faIfGrpStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMkrSeq = this.rfMkrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgMftDt = this.orgMftDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctrySpecNo = this.fctrySpecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproCscNo = this.aproCscNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMtrlCd = this.cntrMtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgMaxTemp = this.orgMaxTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
