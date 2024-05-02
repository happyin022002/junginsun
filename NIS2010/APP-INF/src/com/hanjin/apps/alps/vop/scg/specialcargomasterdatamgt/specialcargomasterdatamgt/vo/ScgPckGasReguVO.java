/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScgPckGasReguVO.java
*@FileTitle : ScgPckGasReguVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.05
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.06.05 원종규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo;

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
 * @author 원종규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgPckGasReguVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgPckGasReguVO> models = new ArrayList<ScgPckGasReguVO>();
	
	/* Column Info */
	private String clndChkFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String imdgPckInstrSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String maxWrkPrss = null;
	/* Column Info */
	private String refDivNo = null;
	/* Column Info */
	private String tubeChkFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pckRefCd = null;
	/* Column Info */
	private String imdgPckInstrCd = null;
	/* Column Info */
	private String testPrdYr = null;
	/* Column Info */
	private String gasSpclPckProviN1stCtnt = null;
	/* Column Info */
	private String clndBdlChkFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String gasTpCd = null;
	/* Column Info */
	private String gasSpclPckProviN3rdCtnt = null;
	/* Column Info */
	private String gasFillRto = null;
	/* Column Info */
	private String lc50Val = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String tstPrss = null;
	/* Column Info */
	private String gasSpclPckProviN4thCtnt = null;
	/* Column Info */
	private String gasSpclPckProviN2ndCtnt = null;
	/* Column Info */
	private String prssDrmChkFlg = null;
	/* Column Info */
	private String prpShpNm = null;
	/* Column Info */
	private String megcChkFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgPckGasReguVO() {}

	public ScgPckGasReguVO(String ibflag, String pagerows, String gasTpCd, String imdgPckInstrCd, String imdgPckInstrSeq, String imdgUnNo, String clndBdlChkFlg, String clndChkFlg, String gasFillRto, String gasSpclPckProviN1stCtnt, String gasSpclPckProviN2ndCtnt, String gasSpclPckProviN3rdCtnt, String gasSpclPckProviN4thCtnt, String lc50Val, String maxWrkPrss, String megcChkFlg, String pckRefCd, String prssDrmChkFlg, String refDivNo, String testPrdYr, String tstPrss, String tubeChkFlg, String prpShpNm, String deltFlg, String creDt, String creUsrId, String updDt, String updUsrId) {
		this.clndChkFlg = clndChkFlg;
		this.deltFlg = deltFlg;
		this.imdgPckInstrSeq = imdgPckInstrSeq;
		this.creDt = creDt;
		this.maxWrkPrss = maxWrkPrss;
		this.refDivNo = refDivNo;
		this.tubeChkFlg = tubeChkFlg;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.pckRefCd = pckRefCd;
		this.imdgPckInstrCd = imdgPckInstrCd;
		this.testPrdYr = testPrdYr;
		this.gasSpclPckProviN1stCtnt = gasSpclPckProviN1stCtnt;
		this.clndBdlChkFlg = clndBdlChkFlg;
		this.updUsrId = updUsrId;
		this.imdgUnNo = imdgUnNo;
		this.updDt = updDt;
		this.gasTpCd = gasTpCd;
		this.gasSpclPckProviN3rdCtnt = gasSpclPckProviN3rdCtnt;
		this.gasFillRto = gasFillRto;
		this.lc50Val = lc50Val;
		this.creUsrId = creUsrId;
		this.tstPrss = tstPrss;
		this.gasSpclPckProviN4thCtnt = gasSpclPckProviN4thCtnt;
		this.gasSpclPckProviN2ndCtnt = gasSpclPckProviN2ndCtnt;
		this.prssDrmChkFlg = prssDrmChkFlg;
		this.prpShpNm = prpShpNm;
		this.megcChkFlg = megcChkFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("clnd_chk_flg", getClndChkFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("imdg_pck_instr_seq", getImdgPckInstrSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("max_wrk_prss", getMaxWrkPrss());
		this.hashColumns.put("ref_div_no", getRefDivNo());
		this.hashColumns.put("tube_chk_flg", getTubeChkFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pck_ref_cd", getPckRefCd());
		this.hashColumns.put("imdg_pck_instr_cd", getImdgPckInstrCd());
		this.hashColumns.put("test_prd_yr", getTestPrdYr());
		this.hashColumns.put("gas_spcl_pck_provi_n1st_ctnt", getGasSpclPckProviN1stCtnt());
		this.hashColumns.put("clnd_bdl_chk_flg", getClndBdlChkFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("gas_tp_cd", getGasTpCd());
		this.hashColumns.put("gas_spcl_pck_provi_n3rd_ctnt", getGasSpclPckProviN3rdCtnt());
		this.hashColumns.put("gas_fill_rto", getGasFillRto());
		this.hashColumns.put("lc50_val", getLc50Val());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("tst_prss", getTstPrss());
		this.hashColumns.put("gas_spcl_pck_provi_n4th_ctnt", getGasSpclPckProviN4thCtnt());
		this.hashColumns.put("gas_spcl_pck_provi_n2nd_ctnt", getGasSpclPckProviN2ndCtnt());
		this.hashColumns.put("prss_drm_chk_flg", getPrssDrmChkFlg());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("megc_chk_flg", getMegcChkFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("clnd_chk_flg", "clndChkFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("imdg_pck_instr_seq", "imdgPckInstrSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("max_wrk_prss", "maxWrkPrss");
		this.hashFields.put("ref_div_no", "refDivNo");
		this.hashFields.put("tube_chk_flg", "tubeChkFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pck_ref_cd", "pckRefCd");
		this.hashFields.put("imdg_pck_instr_cd", "imdgPckInstrCd");
		this.hashFields.put("test_prd_yr", "testPrdYr");
		this.hashFields.put("gas_spcl_pck_provi_n1st_ctnt", "gasSpclPckProviN1stCtnt");
		this.hashFields.put("clnd_bdl_chk_flg", "clndBdlChkFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("gas_tp_cd", "gasTpCd");
		this.hashFields.put("gas_spcl_pck_provi_n3rd_ctnt", "gasSpclPckProviN3rdCtnt");
		this.hashFields.put("gas_fill_rto", "gasFillRto");
		this.hashFields.put("lc50_val", "lc50Val");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("tst_prss", "tstPrss");
		this.hashFields.put("gas_spcl_pck_provi_n4th_ctnt", "gasSpclPckProviN4thCtnt");
		this.hashFields.put("gas_spcl_pck_provi_n2nd_ctnt", "gasSpclPckProviN2ndCtnt");
		this.hashFields.put("prss_drm_chk_flg", "prssDrmChkFlg");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("megc_chk_flg", "megcChkFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return clndChkFlg
	 */
	public String getClndChkFlg() {
		return this.clndChkFlg;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgPckInstrSeq
	 */
	public String getImdgPckInstrSeq() {
		return this.imdgPckInstrSeq;
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
	 * @return maxWrkPrss
	 */
	public String getMaxWrkPrss() {
		return this.maxWrkPrss;
	}
	
	/**
	 * Column Info
	 * @return refDivNo
	 */
	public String getRefDivNo() {
		return this.refDivNo;
	}
	
	/**
	 * Column Info
	 * @return tubeChkFlg
	 */
	public String getTubeChkFlg() {
		return this.tubeChkFlg;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return pckRefCd
	 */
	public String getPckRefCd() {
		return this.pckRefCd;
	}
	
	/**
	 * Column Info
	 * @return imdgPckInstrCd
	 */
	public String getImdgPckInstrCd() {
		return this.imdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @return testPrdYr
	 */
	public String getTestPrdYr() {
		return this.testPrdYr;
	}
	
	/**
	 * Column Info
	 * @return gasSpclPckProviN1stCtnt
	 */
	public String getGasSpclPckProviN1stCtnt() {
		return this.gasSpclPckProviN1stCtnt;
	}
	
	/**
	 * Column Info
	 * @return clndBdlChkFlg
	 */
	public String getClndBdlChkFlg() {
		return this.clndBdlChkFlg;
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
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
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
	 * @return gasTpCd
	 */
	public String getGasTpCd() {
		return this.gasTpCd;
	}
	
	/**
	 * Column Info
	 * @return gasSpclPckProviN3rdCtnt
	 */
	public String getGasSpclPckProviN3rdCtnt() {
		return this.gasSpclPckProviN3rdCtnt;
	}
	
	/**
	 * Column Info
	 * @return gasFillRto
	 */
	public String getGasFillRto() {
		return this.gasFillRto;
	}
	
	/**
	 * Column Info
	 * @return lc50Val
	 */
	public String getLc50Val() {
		return this.lc50Val;
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
	 * @return tstPrss
	 */
	public String getTstPrss() {
		return this.tstPrss;
	}
	
	/**
	 * Column Info
	 * @return gasSpclPckProviN4thCtnt
	 */
	public String getGasSpclPckProviN4thCtnt() {
		return this.gasSpclPckProviN4thCtnt;
	}
	
	/**
	 * Column Info
	 * @return gasSpclPckProviN2ndCtnt
	 */
	public String getGasSpclPckProviN2ndCtnt() {
		return this.gasSpclPckProviN2ndCtnt;
	}
	
	/**
	 * Column Info
	 * @return prssDrmChkFlg
	 */
	public String getPrssDrmChkFlg() {
		return this.prssDrmChkFlg;
	}
	
	/**
	 * Column Info
	 * @return prpShpNm
	 */
	public String getPrpShpNm() {
		return this.prpShpNm;
	}
	
	/**
	 * Column Info
	 * @return megcChkFlg
	 */
	public String getMegcChkFlg() {
		return this.megcChkFlg;
	}
	

	/**
	 * Column Info
	 * @param clndChkFlg
	 */
	public void setClndChkFlg(String clndChkFlg) {
		this.clndChkFlg = clndChkFlg;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgPckInstrSeq
	 */
	public void setImdgPckInstrSeq(String imdgPckInstrSeq) {
		this.imdgPckInstrSeq = imdgPckInstrSeq;
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
	 * @param maxWrkPrss
	 */
	public void setMaxWrkPrss(String maxWrkPrss) {
		this.maxWrkPrss = maxWrkPrss;
	}
	
	/**
	 * Column Info
	 * @param refDivNo
	 */
	public void setRefDivNo(String refDivNo) {
		this.refDivNo = refDivNo;
	}
	
	/**
	 * Column Info
	 * @param tubeChkFlg
	 */
	public void setTubeChkFlg(String tubeChkFlg) {
		this.tubeChkFlg = tubeChkFlg;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param pckRefCd
	 */
	public void setPckRefCd(String pckRefCd) {
		this.pckRefCd = pckRefCd;
	}
	
	/**
	 * Column Info
	 * @param imdgPckInstrCd
	 */
	public void setImdgPckInstrCd(String imdgPckInstrCd) {
		this.imdgPckInstrCd = imdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @param testPrdYr
	 */
	public void setTestPrdYr(String testPrdYr) {
		this.testPrdYr = testPrdYr;
	}
	
	/**
	 * Column Info
	 * @param gasSpclPckProviN1stCtnt
	 */
	public void setGasSpclPckProviN1stCtnt(String gasSpclPckProviN1stCtnt) {
		this.gasSpclPckProviN1stCtnt = gasSpclPckProviN1stCtnt;
	}
	
	/**
	 * Column Info
	 * @param clndBdlChkFlg
	 */
	public void setClndBdlChkFlg(String clndBdlChkFlg) {
		this.clndBdlChkFlg = clndBdlChkFlg;
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
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
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
	 * @param gasTpCd
	 */
	public void setGasTpCd(String gasTpCd) {
		this.gasTpCd = gasTpCd;
	}
	
	/**
	 * Column Info
	 * @param gasSpclPckProviN3rdCtnt
	 */
	public void setGasSpclPckProviN3rdCtnt(String gasSpclPckProviN3rdCtnt) {
		this.gasSpclPckProviN3rdCtnt = gasSpclPckProviN3rdCtnt;
	}
	
	/**
	 * Column Info
	 * @param gasFillRto
	 */
	public void setGasFillRto(String gasFillRto) {
		this.gasFillRto = gasFillRto;
	}
	
	/**
	 * Column Info
	 * @param lc50Val
	 */
	public void setLc50Val(String lc50Val) {
		this.lc50Val = lc50Val;
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
	 * @param tstPrss
	 */
	public void setTstPrss(String tstPrss) {
		this.tstPrss = tstPrss;
	}
	
	/**
	 * Column Info
	 * @param gasSpclPckProviN4thCtnt
	 */
	public void setGasSpclPckProviN4thCtnt(String gasSpclPckProviN4thCtnt) {
		this.gasSpclPckProviN4thCtnt = gasSpclPckProviN4thCtnt;
	}
	
	/**
	 * Column Info
	 * @param gasSpclPckProviN2ndCtnt
	 */
	public void setGasSpclPckProviN2ndCtnt(String gasSpclPckProviN2ndCtnt) {
		this.gasSpclPckProviN2ndCtnt = gasSpclPckProviN2ndCtnt;
	}
	
	/**
	 * Column Info
	 * @param prssDrmChkFlg
	 */
	public void setPrssDrmChkFlg(String prssDrmChkFlg) {
		this.prssDrmChkFlg = prssDrmChkFlg;
	}
	
	/**
	 * Column Info
	 * @param prpShpNm
	 */
	public void setPrpShpNm(String prpShpNm) {
		this.prpShpNm = prpShpNm;
	}
	
	/**
	 * Column Info
	 * @param megcChkFlg
	 */
	public void setMegcChkFlg(String megcChkFlg) {
		this.megcChkFlg = megcChkFlg;
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
		setClndChkFlg(JSPUtil.getParameter(request, prefix + "clnd_chk_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setImdgPckInstrSeq(JSPUtil.getParameter(request, prefix + "imdg_pck_instr_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMaxWrkPrss(JSPUtil.getParameter(request, prefix + "max_wrk_prss", ""));
		setRefDivNo(JSPUtil.getParameter(request, prefix + "ref_div_no", ""));
		setTubeChkFlg(JSPUtil.getParameter(request, prefix + "tube_chk_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPckRefCd(JSPUtil.getParameter(request, prefix + "pck_ref_cd", ""));
		setImdgPckInstrCd(JSPUtil.getParameter(request, prefix + "imdg_pck_instr_cd", ""));
		setTestPrdYr(JSPUtil.getParameter(request, prefix + "test_prd_yr", ""));
		setGasSpclPckProviN1stCtnt(JSPUtil.getParameter(request, prefix + "gas_spcl_pck_provi_n1st_ctnt", ""));
		setClndBdlChkFlg(JSPUtil.getParameter(request, prefix + "clnd_bdl_chk_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setGasTpCd(JSPUtil.getParameter(request, prefix + "gas_tp_cd", ""));
		setGasSpclPckProviN3rdCtnt(JSPUtil.getParameter(request, prefix + "gas_spcl_pck_provi_n3rd_ctnt", ""));
		setGasFillRto(JSPUtil.getParameter(request, prefix + "gas_fill_rto", ""));
		setLc50Val(JSPUtil.getParameter(request, prefix + "lc50_val", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTstPrss(JSPUtil.getParameter(request, prefix + "tst_prss", ""));
		setGasSpclPckProviN4thCtnt(JSPUtil.getParameter(request, prefix + "gas_spcl_pck_provi_n4th_ctnt", ""));
		setGasSpclPckProviN2ndCtnt(JSPUtil.getParameter(request, prefix + "gas_spcl_pck_provi_n2nd_ctnt", ""));
		setPrssDrmChkFlg(JSPUtil.getParameter(request, prefix + "prss_drm_chk_flg", ""));
		setPrpShpNm(JSPUtil.getParameter(request, prefix + "prp_shp_nm", ""));
		setMegcChkFlg(JSPUtil.getParameter(request, prefix + "megc_chk_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPckGasReguVO[]
	 */
	public ScgPckGasReguVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgPckGasReguVO[]
	 */
	public ScgPckGasReguVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgPckGasReguVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] clndChkFlg = (JSPUtil.getParameter(request, prefix	+ "clnd_chk_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] imdgPckInstrSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_instr_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] maxWrkPrss = (JSPUtil.getParameter(request, prefix	+ "max_wrk_prss", length));
			String[] refDivNo = (JSPUtil.getParameter(request, prefix	+ "ref_div_no", length));
			String[] tubeChkFlg = (JSPUtil.getParameter(request, prefix	+ "tube_chk_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pckRefCd = (JSPUtil.getParameter(request, prefix	+ "pck_ref_cd", length));
			String[] imdgPckInstrCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_instr_cd", length));
			String[] testPrdYr = (JSPUtil.getParameter(request, prefix	+ "test_prd_yr", length));
			String[] gasSpclPckProviN1stCtnt = (JSPUtil.getParameter(request, prefix	+ "gas_spcl_pck_provi_n1st_ctnt", length));
			String[] clndBdlChkFlg = (JSPUtil.getParameter(request, prefix	+ "clnd_bdl_chk_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] gasTpCd = (JSPUtil.getParameter(request, prefix	+ "gas_tp_cd", length));
			String[] gasSpclPckProviN3rdCtnt = (JSPUtil.getParameter(request, prefix	+ "gas_spcl_pck_provi_n3rd_ctnt", length));
			String[] gasFillRto = (JSPUtil.getParameter(request, prefix	+ "gas_fill_rto", length));
			String[] lc50Val = (JSPUtil.getParameter(request, prefix	+ "lc50_val", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] tstPrss = (JSPUtil.getParameter(request, prefix	+ "tst_prss", length));
			String[] gasSpclPckProviN4thCtnt = (JSPUtil.getParameter(request, prefix	+ "gas_spcl_pck_provi_n4th_ctnt", length));
			String[] gasSpclPckProviN2ndCtnt = (JSPUtil.getParameter(request, prefix	+ "gas_spcl_pck_provi_n2nd_ctnt", length));
			String[] prssDrmChkFlg = (JSPUtil.getParameter(request, prefix	+ "prss_drm_chk_flg", length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm", length));
			String[] megcChkFlg = (JSPUtil.getParameter(request, prefix	+ "megc_chk_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgPckGasReguVO();
				if (clndChkFlg[i] != null)
					model.setClndChkFlg(clndChkFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (imdgPckInstrSeq[i] != null)
					model.setImdgPckInstrSeq(imdgPckInstrSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (maxWrkPrss[i] != null)
					model.setMaxWrkPrss(maxWrkPrss[i]);
				if (refDivNo[i] != null)
					model.setRefDivNo(refDivNo[i]);
				if (tubeChkFlg[i] != null)
					model.setTubeChkFlg(tubeChkFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pckRefCd[i] != null)
					model.setPckRefCd(pckRefCd[i]);
				if (imdgPckInstrCd[i] != null)
					model.setImdgPckInstrCd(imdgPckInstrCd[i]);
				if (testPrdYr[i] != null)
					model.setTestPrdYr(testPrdYr[i]);
				if (gasSpclPckProviN1stCtnt[i] != null)
					model.setGasSpclPckProviN1stCtnt(gasSpclPckProviN1stCtnt[i]);
				if (clndBdlChkFlg[i] != null)
					model.setClndBdlChkFlg(clndBdlChkFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (gasTpCd[i] != null)
					model.setGasTpCd(gasTpCd[i]);
				if (gasSpclPckProviN3rdCtnt[i] != null)
					model.setGasSpclPckProviN3rdCtnt(gasSpclPckProviN3rdCtnt[i]);
				if (gasFillRto[i] != null)
					model.setGasFillRto(gasFillRto[i]);
				if (lc50Val[i] != null)
					model.setLc50Val(lc50Val[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (tstPrss[i] != null)
					model.setTstPrss(tstPrss[i]);
				if (gasSpclPckProviN4thCtnt[i] != null)
					model.setGasSpclPckProviN4thCtnt(gasSpclPckProviN4thCtnt[i]);
				if (gasSpclPckProviN2ndCtnt[i] != null)
					model.setGasSpclPckProviN2ndCtnt(gasSpclPckProviN2ndCtnt[i]);
				if (prssDrmChkFlg[i] != null)
					model.setPrssDrmChkFlg(prssDrmChkFlg[i]);
				if (prpShpNm[i] != null)
					model.setPrpShpNm(prpShpNm[i]);
				if (megcChkFlg[i] != null)
					model.setMegcChkFlg(megcChkFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgPckGasReguVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgPckGasReguVO[]
	 */
	public ScgPckGasReguVO[] getScgPckGasReguVOs(){
		ScgPckGasReguVO[] vos = (ScgPckGasReguVO[])models.toArray(new ScgPckGasReguVO[models.size()]);
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
		this.clndChkFlg = this.clndChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckInstrSeq = this.imdgPckInstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxWrkPrss = this.maxWrkPrss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refDivNo = this.refDivNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tubeChkFlg = this.tubeChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckRefCd = this.pckRefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckInstrCd = this.imdgPckInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.testPrdYr = this.testPrdYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gasSpclPckProviN1stCtnt = this.gasSpclPckProviN1stCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clndBdlChkFlg = this.clndBdlChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gasTpCd = this.gasTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gasSpclPckProviN3rdCtnt = this.gasSpclPckProviN3rdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gasFillRto = this.gasFillRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lc50Val = this.lc50Val .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tstPrss = this.tstPrss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gasSpclPckProviN4thCtnt = this.gasSpclPckProviN4thCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gasSpclPckProviN2ndCtnt = this.gasSpclPckProviN2ndCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prssDrmChkFlg = this.prssDrmChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.megcChkFlg = this.megcChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
