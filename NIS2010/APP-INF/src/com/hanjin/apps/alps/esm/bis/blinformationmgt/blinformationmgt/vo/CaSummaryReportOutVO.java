/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CaSummaryReportOutVO.java
*@FileTitle : CaSummaryReportOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2010.01.15 강동윤 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo;

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
 * @author 강동윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CaSummaryReportOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CaSummaryReportOutVO> models = new ArrayList<CaSummaryReportOutVO>();
	
	/* Column Info */
	private String corrDt = null;
	/* Column Info */
	private String cntHlgC = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cxlModiFlg = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cntHlgM = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String corrUsrId = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cntCaTtl = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String blObrdDt = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String creDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntClassN = null;
	/* Column Info */
	private String cntRsnA = null;
	/* Column Info */
	private String cntRsnC = null;
	/* Column Info */
	private String cntExempt = null;
	/* Column Info */
	private String cntClassE = null;
	/* Column Info */
	private String corrOfcCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String caRsnCd = null;
	/* Column Info */
	private String cntRsnM = null;
	/* Column Info */
	private String bkgSplitModiFlg = null;
	/* Column Info */
	private String cntBlTtl = null;
	/* Column Info */
	private String cntRsnR = null;
	/* Column Info */
	private String corrNo = null;
	/* Column Info */
	private String cntRsnG = null;
	/* Column Info */
	private String cntClassR = null;
	/* Column Info */
	private String cntKindA = null;
	/* Column Info */
	private String cntKindB = null;
	/* Column Info */
	private String cntKindC = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String cntKindD = null;
	/* Column Info */
	private String cntKindI = null;
	/* Column Info */
	private String cntKindJ = null;
	/* Column Info */
	private String cntKindK = null;
	/* Column Info */
	private String cntKindE = null;
	/* Column Info */
	private String cntKindF = null;
	/* Column Info */
	private String cntKindG = null;
	/* Column Info */
	private String cntKindH = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CaSummaryReportOutVO() {}

	public CaSummaryReportOutVO(String ibflag, String pagerows, String blNo, String bkgNo, String vvd, String blObrdDt, String bkgOfcCd, String slsRhqCd, String ctrtOfcCd, String porCd, String polCd, String podCd, String delCd, String corrNo, String corrDt, String corrOfcCd, String corrUsrId, String caRsnCd, String bkgSplitModiFlg, String cxlModiFlg, String creDt, String updDt, String updUsrId, String custNm, String diffRmk, String cntKindA, String cntKindB, String cntKindC, String cntKindD, String cntKindE, String cntKindF, String cntKindG, String cntKindH, String cntKindI, String cntKindJ, String cntKindK, String cntRsnM, String cntRsnC, String cntRsnG, String cntRsnA, String cntRsnR, String cntBlTtl, String cntCaTtl, String cntClassR, String cntClassN, String cntClassE, String cntHlgC, String cntHlgM, String cntExempt) {
		this.corrDt = corrDt;
		this.cntHlgC = cntHlgC;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.cxlModiFlg = cxlModiFlg;
		this.polCd = polCd;
		this.cntHlgM = cntHlgM;
		this.ctrtOfcCd = ctrtOfcCd;
		this.updUsrId = updUsrId;
		this.bkgOfcCd = bkgOfcCd;
		this.delCd = delCd;
		this.corrUsrId = corrUsrId;
		this.slsRhqCd = slsRhqCd;
		this.vvd = vvd;
		this.podCd = podCd;
		this.cntCaTtl = cntCaTtl;
		this.bkgNo = bkgNo;
		this.blObrdDt = blObrdDt;
		this.porCd = porCd;
		this.custNm = custNm;
		this.creDt = creDt;
		this.ibflag = ibflag;
		this.cntClassN = cntClassN;
		this.cntRsnA = cntRsnA;
		this.cntRsnC = cntRsnC;
		this.cntExempt = cntExempt;
		this.cntClassE = cntClassE;
		this.corrOfcCd = corrOfcCd;
		this.updDt = updDt;
		this.caRsnCd = caRsnCd;
		this.cntRsnM = cntRsnM;
		this.bkgSplitModiFlg = bkgSplitModiFlg;
		this.cntBlTtl = cntBlTtl;
		this.cntRsnR = cntRsnR;
		this.corrNo = corrNo;
		this.cntRsnG = cntRsnG;
		this.cntClassR = cntClassR;
		this.cntKindA = cntKindA;
		this.cntKindB = cntKindB;
		this.cntKindC = cntKindC;
		this.diffRmk = diffRmk;
		this.cntKindD = cntKindD;
		this.cntKindI = cntKindI;
		this.cntKindJ = cntKindJ;
		this.cntKindK = cntKindK;
		this.cntKindE = cntKindE;
		this.cntKindF = cntKindF;
		this.cntKindG = cntKindG;
		this.cntKindH = cntKindH;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("corr_dt", getCorrDt());
		this.hashColumns.put("cnt_hlg_c", getCntHlgC());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cxl_modi_flg", getCxlModiFlg());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cnt_hlg_m", getCntHlgM());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("corr_usr_id", getCorrUsrId());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cnt_ca_ttl", getCntCaTtl());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bl_obrd_dt", getBlObrdDt());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_class_n", getCntClassN());
		this.hashColumns.put("cnt_rsn_a", getCntRsnA());
		this.hashColumns.put("cnt_rsn_c", getCntRsnC());
		this.hashColumns.put("cnt_exempt", getCntExempt());
		this.hashColumns.put("cnt_class_e", getCntClassE());
		this.hashColumns.put("corr_ofc_cd", getCorrOfcCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ca_rsn_cd", getCaRsnCd());
		this.hashColumns.put("cnt_rsn_m", getCntRsnM());
		this.hashColumns.put("bkg_split_modi_flg", getBkgSplitModiFlg());
		this.hashColumns.put("cnt_bl_ttl", getCntBlTtl());
		this.hashColumns.put("cnt_rsn_r", getCntRsnR());
		this.hashColumns.put("corr_no", getCorrNo());
		this.hashColumns.put("cnt_rsn_g", getCntRsnG());
		this.hashColumns.put("cnt_class_r", getCntClassR());
		this.hashColumns.put("cnt_kind_a", getCntKindA());
		this.hashColumns.put("cnt_kind_b", getCntKindB());
		this.hashColumns.put("cnt_kind_c", getCntKindC());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("cnt_kind_d", getCntKindD());
		this.hashColumns.put("cnt_kind_i", getCntKindI());
		this.hashColumns.put("cnt_kind_j", getCntKindJ());
		this.hashColumns.put("cnt_kind_k", getCntKindK());
		this.hashColumns.put("cnt_kind_e", getCntKindE());
		this.hashColumns.put("cnt_kind_f", getCntKindF());
		this.hashColumns.put("cnt_kind_g", getCntKindG());
		this.hashColumns.put("cnt_kind_h", getCntKindH());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("corr_dt", "corrDt");
		this.hashFields.put("cnt_hlg_c", "cntHlgC");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cxl_modi_flg", "cxlModiFlg");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cnt_hlg_m", "cntHlgM");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("corr_usr_id", "corrUsrId");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cnt_ca_ttl", "cntCaTtl");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bl_obrd_dt", "blObrdDt");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_class_n", "cntClassN");
		this.hashFields.put("cnt_rsn_a", "cntRsnA");
		this.hashFields.put("cnt_rsn_c", "cntRsnC");
		this.hashFields.put("cnt_exempt", "cntExempt");
		this.hashFields.put("cnt_class_e", "cntClassE");
		this.hashFields.put("corr_ofc_cd", "corrOfcCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ca_rsn_cd", "caRsnCd");
		this.hashFields.put("cnt_rsn_m", "cntRsnM");
		this.hashFields.put("bkg_split_modi_flg", "bkgSplitModiFlg");
		this.hashFields.put("cnt_bl_ttl", "cntBlTtl");
		this.hashFields.put("cnt_rsn_r", "cntRsnR");
		this.hashFields.put("corr_no", "corrNo");
		this.hashFields.put("cnt_rsn_g", "cntRsnG");
		this.hashFields.put("cnt_class_r", "cntClassR");
		this.hashFields.put("cnt_kind_a", "cntKindA");
		this.hashFields.put("cnt_kind_b", "cntKindB");
		this.hashFields.put("cnt_kind_c", "cntKindC");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("cnt_kind_d", "cntKindD");
		this.hashFields.put("cnt_kind_i", "cntKindI");
		this.hashFields.put("cnt_kind_j", "cntKindJ");
		this.hashFields.put("cnt_kind_k", "cntKindK");
		this.hashFields.put("cnt_kind_e", "cntKindE");
		this.hashFields.put("cnt_kind_f", "cntKindF");
		this.hashFields.put("cnt_kind_g", "cntKindG");
		this.hashFields.put("cnt_kind_h", "cntKindH");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return corrDt
	 */
	public String getCorrDt() {
		return this.corrDt;
	}
	
	/**
	 * Column Info
	 * @return cntHlgC
	 */
	public String getCntHlgC() {
		return this.cntHlgC;
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
	 * @return cxlModiFlg
	 */
	public String getCxlModiFlg() {
		return this.cxlModiFlg;
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
	 * @return cntHlgM
	 */
	public String getCntHlgM() {
		return this.cntHlgM;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
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
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
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
	 * @return corrUsrId
	 */
	public String getCorrUsrId() {
		return this.corrUsrId;
	}
	
	/**
	 * Column Info
	 * @return slsRhqCd
	 */
	public String getSlsRhqCd() {
		return this.slsRhqCd;
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
	 * @return cntCaTtl
	 */
	public String getCntCaTtl() {
		return this.cntCaTtl;
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
	 * @return blObrdDt
	 */
	public String getBlObrdDt() {
		return this.blObrdDt;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return cntClassN
	 */
	public String getCntClassN() {
		return this.cntClassN;
	}
	
	/**
	 * Column Info
	 * @return cntRsnA
	 */
	public String getCntRsnA() {
		return this.cntRsnA;
	}
	
	/**
	 * Column Info
	 * @return cntRsnC
	 */
	public String getCntRsnC() {
		return this.cntRsnC;
	}
	
	/**
	 * Column Info
	 * @return cntExempt
	 */
	public String getCntExempt() {
		return this.cntExempt;
	}
	
	/**
	 * Column Info
	 * @return cntClassE
	 */
	public String getCntClassE() {
		return this.cntClassE;
	}
	
	/**
	 * Column Info
	 * @return corrOfcCd
	 */
	public String getCorrOfcCd() {
		return this.corrOfcCd;
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
	 * @return caRsnCd
	 */
	public String getCaRsnCd() {
		return this.caRsnCd;
	}
	
	/**
	 * Column Info
	 * @return cntRsnM
	 */
	public String getCntRsnM() {
		return this.cntRsnM;
	}
	
	/**
	 * Column Info
	 * @return bkgSplitModiFlg
	 */
	public String getBkgSplitModiFlg() {
		return this.bkgSplitModiFlg;
	}
	
	/**
	 * Column Info
	 * @return cntBlTtl
	 */
	public String getCntBlTtl() {
		return this.cntBlTtl;
	}
	
	/**
	 * Column Info
	 * @return cntRsnR
	 */
	public String getCntRsnR() {
		return this.cntRsnR;
	}
	
	/**
	 * Column Info
	 * @return corrNo
	 */
	public String getCorrNo() {
		return this.corrNo;
	}
	
	/**
	 * Column Info
	 * @return cntRsnG
	 */
	public String getCntRsnG() {
		return this.cntRsnG;
	}
	
	/**
	 * Column Info
	 * @return cntClassR
	 */
	public String getCntClassR() {
		return this.cntClassR;
	}
	
	/**
	 * Column Info
	 * @return cntKindA
	 */
	public String getCntKindA() {
		return this.cntKindA;
	}
	
	/**
	 * Column Info
	 * @return cntKindB
	 */
	public String getCntKindB() {
		return this.cntKindB;
	}
	
	/**
	 * Column Info
	 * @return cntKindC
	 */
	public String getCntKindC() {
		return this.cntKindC;
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
	 * @return cntKindD
	 */
	public String getCntKindD() {
		return this.cntKindD;
	}
	
	/**
	 * Column Info
	 * @return cntKindI
	 */
	public String getCntKindI() {
		return this.cntKindI;
	}
	
	/**
	 * Column Info
	 * @return cntKindJ
	 */
	public String getCntKindJ() {
		return this.cntKindJ;
	}
	
	/**
	 * Column Info
	 * @return cntKindK
	 */
	public String getCntKindK() {
		return this.cntKindK;
	}
	
	/**
	 * Column Info
	 * @return cntKindE
	 */
	public String getCntKindE() {
		return this.cntKindE;
	}
	
	/**
	 * Column Info
	 * @return cntKindF
	 */
	public String getCntKindF() {
		return this.cntKindF;
	}
	
	/**
	 * Column Info
	 * @return cntKindG
	 */
	public String getCntKindG() {
		return this.cntKindG;
	}
	
	/**
	 * Column Info
	 * @return cntKindH
	 */
	public String getCntKindH() {
		return this.cntKindH;
	}
	

	/**
	 * Column Info
	 * @param corrDt
	 */
	public void setCorrDt(String corrDt) {
		this.corrDt = corrDt;
	}
	
	/**
	 * Column Info
	 * @param cntHlgC
	 */
	public void setCntHlgC(String cntHlgC) {
		this.cntHlgC = cntHlgC;
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
	 * @param cxlModiFlg
	 */
	public void setCxlModiFlg(String cxlModiFlg) {
		this.cxlModiFlg = cxlModiFlg;
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
	 * @param cntHlgM
	 */
	public void setCntHlgM(String cntHlgM) {
		this.cntHlgM = cntHlgM;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
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
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
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
	 * @param corrUsrId
	 */
	public void setCorrUsrId(String corrUsrId) {
		this.corrUsrId = corrUsrId;
	}
	
	/**
	 * Column Info
	 * @param slsRhqCd
	 */
	public void setSlsRhqCd(String slsRhqCd) {
		this.slsRhqCd = slsRhqCd;
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
	 * @param cntCaTtl
	 */
	public void setCntCaTtl(String cntCaTtl) {
		this.cntCaTtl = cntCaTtl;
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
	 * @param blObrdDt
	 */
	public void setBlObrdDt(String blObrdDt) {
		this.blObrdDt = blObrdDt;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param cntClassN
	 */
	public void setCntClassN(String cntClassN) {
		this.cntClassN = cntClassN;
	}
	
	/**
	 * Column Info
	 * @param cntRsnA
	 */
	public void setCntRsnA(String cntRsnA) {
		this.cntRsnA = cntRsnA;
	}
	
	/**
	 * Column Info
	 * @param cntRsnC
	 */
	public void setCntRsnC(String cntRsnC) {
		this.cntRsnC = cntRsnC;
	}
	
	/**
	 * Column Info
	 * @param cntExempt
	 */
	public void setCntExempt(String cntExempt) {
		this.cntExempt = cntExempt;
	}
	
	/**
	 * Column Info
	 * @param cntClassE
	 */
	public void setCntClassE(String cntClassE) {
		this.cntClassE = cntClassE;
	}
	
	/**
	 * Column Info
	 * @param corrOfcCd
	 */
	public void setCorrOfcCd(String corrOfcCd) {
		this.corrOfcCd = corrOfcCd;
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
	 * @param caRsnCd
	 */
	public void setCaRsnCd(String caRsnCd) {
		this.caRsnCd = caRsnCd;
	}
	
	/**
	 * Column Info
	 * @param cntRsnM
	 */
	public void setCntRsnM(String cntRsnM) {
		this.cntRsnM = cntRsnM;
	}
	
	/**
	 * Column Info
	 * @param bkgSplitModiFlg
	 */
	public void setBkgSplitModiFlg(String bkgSplitModiFlg) {
		this.bkgSplitModiFlg = bkgSplitModiFlg;
	}
	
	/**
	 * Column Info
	 * @param cntBlTtl
	 */
	public void setCntBlTtl(String cntBlTtl) {
		this.cntBlTtl = cntBlTtl;
	}
	
	/**
	 * Column Info
	 * @param cntRsnR
	 */
	public void setCntRsnR(String cntRsnR) {
		this.cntRsnR = cntRsnR;
	}
	
	/**
	 * Column Info
	 * @param corrNo
	 */
	public void setCorrNo(String corrNo) {
		this.corrNo = corrNo;
	}
	
	/**
	 * Column Info
	 * @param cntRsnG
	 */
	public void setCntRsnG(String cntRsnG) {
		this.cntRsnG = cntRsnG;
	}
	
	/**
	 * Column Info
	 * @param cntClassR
	 */
	public void setCntClassR(String cntClassR) {
		this.cntClassR = cntClassR;
	}
	
	/**
	 * Column Info
	 * @param cntKindA
	 */
	public void setCntKindA(String cntKindA) {
		this.cntKindA = cntKindA;
	}
	
	/**
	 * Column Info
	 * @param cntKindB
	 */
	public void setCntKindB(String cntKindB) {
		this.cntKindB = cntKindB;
	}
	
	/**
	 * Column Info
	 * @param cntKindC
	 */
	public void setCntKindC(String cntKindC) {
		this.cntKindC = cntKindC;
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
	 * @param cntKindD
	 */
	public void setCntKindD(String cntKindD) {
		this.cntKindD = cntKindD;
	}
	
	/**
	 * Column Info
	 * @param cntKindI
	 */
	public void setCntKindI(String cntKindI) {
		this.cntKindI = cntKindI;
	}
	
	/**
	 * Column Info
	 * @param cntKindJ
	 */
	public void setCntKindJ(String cntKindJ) {
		this.cntKindJ = cntKindJ;
	}
	
	/**
	 * Column Info
	 * @param cntKindK
	 */
	public void setCntKindK(String cntKindK) {
		this.cntKindK = cntKindK;
	}
	
	/**
	 * Column Info
	 * @param cntKindE
	 */
	public void setCntKindE(String cntKindE) {
		this.cntKindE = cntKindE;
	}
	
	/**
	 * Column Info
	 * @param cntKindF
	 */
	public void setCntKindF(String cntKindF) {
		this.cntKindF = cntKindF;
	}
	
	/**
	 * Column Info
	 * @param cntKindG
	 */
	public void setCntKindG(String cntKindG) {
		this.cntKindG = cntKindG;
	}
	
	/**
	 * Column Info
	 * @param cntKindH
	 */
	public void setCntKindH(String cntKindH) {
		this.cntKindH = cntKindH;
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
		setCorrDt(JSPUtil.getParameter(request, prefix + "corr_dt", ""));
		setCntHlgC(JSPUtil.getParameter(request, prefix + "cnt_hlg_c", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCxlModiFlg(JSPUtil.getParameter(request, prefix + "cxl_modi_flg", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCntHlgM(JSPUtil.getParameter(request, prefix + "cnt_hlg_m", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCorrUsrId(JSPUtil.getParameter(request, prefix + "corr_usr_id", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, prefix + "sls_rhq_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCntCaTtl(JSPUtil.getParameter(request, prefix + "cnt_ca_ttl", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setBlObrdDt(JSPUtil.getParameter(request, prefix + "bl_obrd_dt", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntClassN(JSPUtil.getParameter(request, prefix + "cnt_class_n", ""));
		setCntRsnA(JSPUtil.getParameter(request, prefix + "cnt_rsn_a", ""));
		setCntRsnC(JSPUtil.getParameter(request, prefix + "cnt_rsn_c", ""));
		setCntExempt(JSPUtil.getParameter(request, prefix + "cnt_exempt", ""));
		setCntClassE(JSPUtil.getParameter(request, prefix + "cnt_class_e", ""));
		setCorrOfcCd(JSPUtil.getParameter(request, prefix + "corr_ofc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCaRsnCd(JSPUtil.getParameter(request, prefix + "ca_rsn_cd", ""));
		setCntRsnM(JSPUtil.getParameter(request, prefix + "cnt_rsn_m", ""));
		setBkgSplitModiFlg(JSPUtil.getParameter(request, prefix + "bkg_split_modi_flg", ""));
		setCntBlTtl(JSPUtil.getParameter(request, prefix + "cnt_bl_ttl", ""));
		setCntRsnR(JSPUtil.getParameter(request, prefix + "cnt_rsn_r", ""));
		setCorrNo(JSPUtil.getParameter(request, prefix + "corr_no", ""));
		setCntRsnG(JSPUtil.getParameter(request, prefix + "cnt_rsn_g", ""));
		setCntClassR(JSPUtil.getParameter(request, prefix + "cnt_class_r", ""));
		setCntKindA(JSPUtil.getParameter(request, prefix + "cnt_kind_a", ""));
		setCntKindB(JSPUtil.getParameter(request, prefix + "cnt_kind_b", ""));
		setCntKindC(JSPUtil.getParameter(request, prefix + "cnt_kind_c", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setCntKindD(JSPUtil.getParameter(request, prefix + "cnt_kind_d", ""));
		setCntKindI(JSPUtil.getParameter(request, prefix + "cnt_kind_i", ""));
		setCntKindJ(JSPUtil.getParameter(request, prefix + "cnt_kind_j", ""));
		setCntKindK(JSPUtil.getParameter(request, prefix + "cnt_kind_k", ""));
		setCntKindE(JSPUtil.getParameter(request, prefix + "cnt_kind_e", ""));
		setCntKindF(JSPUtil.getParameter(request, prefix + "cnt_kind_f", ""));
		setCntKindG(JSPUtil.getParameter(request, prefix + "cnt_kind_g", ""));
		setCntKindH(JSPUtil.getParameter(request, prefix + "cnt_kind_h", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CaSummaryReportOutVO[]
	 */
	public CaSummaryReportOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CaSummaryReportOutVO[]
	 */
	public CaSummaryReportOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CaSummaryReportOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] corrDt = (JSPUtil.getParameter(request, prefix	+ "corr_dt", length));
			String[] cntHlgC = (JSPUtil.getParameter(request, prefix	+ "cnt_hlg_c", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cxlModiFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_modi_flg", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cntHlgM = (JSPUtil.getParameter(request, prefix	+ "cnt_hlg_m", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] corrUsrId = (JSPUtil.getParameter(request, prefix	+ "corr_usr_id", length));
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cntCaTtl = (JSPUtil.getParameter(request, prefix	+ "cnt_ca_ttl", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] blObrdDt = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntClassN = (JSPUtil.getParameter(request, prefix	+ "cnt_class_n", length));
			String[] cntRsnA = (JSPUtil.getParameter(request, prefix	+ "cnt_rsn_a", length));
			String[] cntRsnC = (JSPUtil.getParameter(request, prefix	+ "cnt_rsn_c", length));
			String[] cntExempt = (JSPUtil.getParameter(request, prefix	+ "cnt_exempt", length));
			String[] cntClassE = (JSPUtil.getParameter(request, prefix	+ "cnt_class_e", length));
			String[] corrOfcCd = (JSPUtil.getParameter(request, prefix	+ "corr_ofc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] caRsnCd = (JSPUtil.getParameter(request, prefix	+ "ca_rsn_cd", length));
			String[] cntRsnM = (JSPUtil.getParameter(request, prefix	+ "cnt_rsn_m", length));
			String[] bkgSplitModiFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_split_modi_flg", length));
			String[] cntBlTtl = (JSPUtil.getParameter(request, prefix	+ "cnt_bl_ttl", length));
			String[] cntRsnR = (JSPUtil.getParameter(request, prefix	+ "cnt_rsn_r", length));
			String[] corrNo = (JSPUtil.getParameter(request, prefix	+ "corr_no", length));
			String[] cntRsnG = (JSPUtil.getParameter(request, prefix	+ "cnt_rsn_g", length));
			String[] cntClassR = (JSPUtil.getParameter(request, prefix	+ "cnt_class_r", length));
			String[] cntKindA = (JSPUtil.getParameter(request, prefix	+ "cnt_kind_a", length));
			String[] cntKindB = (JSPUtil.getParameter(request, prefix	+ "cnt_kind_b", length));
			String[] cntKindC = (JSPUtil.getParameter(request, prefix	+ "cnt_kind_c", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] cntKindD = (JSPUtil.getParameter(request, prefix	+ "cnt_kind_d", length));
			String[] cntKindI = (JSPUtil.getParameter(request, prefix	+ "cnt_kind_i", length));
			String[] cntKindJ = (JSPUtil.getParameter(request, prefix	+ "cnt_kind_j", length));
			String[] cntKindK = (JSPUtil.getParameter(request, prefix	+ "cnt_kind_k", length));
			String[] cntKindE = (JSPUtil.getParameter(request, prefix	+ "cnt_kind_e", length));
			String[] cntKindF = (JSPUtil.getParameter(request, prefix	+ "cnt_kind_f", length));
			String[] cntKindG = (JSPUtil.getParameter(request, prefix	+ "cnt_kind_g", length));
			String[] cntKindH = (JSPUtil.getParameter(request, prefix	+ "cnt_kind_h", length));
			
			for (int i = 0; i < length; i++) {
				model = new CaSummaryReportOutVO();
				if (corrDt[i] != null)
					model.setCorrDt(corrDt[i]);
				if (cntHlgC[i] != null)
					model.setCntHlgC(cntHlgC[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cxlModiFlg[i] != null)
					model.setCxlModiFlg(cxlModiFlg[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cntHlgM[i] != null)
					model.setCntHlgM(cntHlgM[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (corrUsrId[i] != null)
					model.setCorrUsrId(corrUsrId[i]);
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cntCaTtl[i] != null)
					model.setCntCaTtl(cntCaTtl[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (blObrdDt[i] != null)
					model.setBlObrdDt(blObrdDt[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntClassN[i] != null)
					model.setCntClassN(cntClassN[i]);
				if (cntRsnA[i] != null)
					model.setCntRsnA(cntRsnA[i]);
				if (cntRsnC[i] != null)
					model.setCntRsnC(cntRsnC[i]);
				if (cntExempt[i] != null)
					model.setCntExempt(cntExempt[i]);
				if (cntClassE[i] != null)
					model.setCntClassE(cntClassE[i]);
				if (corrOfcCd[i] != null)
					model.setCorrOfcCd(corrOfcCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (caRsnCd[i] != null)
					model.setCaRsnCd(caRsnCd[i]);
				if (cntRsnM[i] != null)
					model.setCntRsnM(cntRsnM[i]);
				if (bkgSplitModiFlg[i] != null)
					model.setBkgSplitModiFlg(bkgSplitModiFlg[i]);
				if (cntBlTtl[i] != null)
					model.setCntBlTtl(cntBlTtl[i]);
				if (cntRsnR[i] != null)
					model.setCntRsnR(cntRsnR[i]);
				if (corrNo[i] != null)
					model.setCorrNo(corrNo[i]);
				if (cntRsnG[i] != null)
					model.setCntRsnG(cntRsnG[i]);
				if (cntClassR[i] != null)
					model.setCntClassR(cntClassR[i]);
				if (cntKindA[i] != null)
					model.setCntKindA(cntKindA[i]);
				if (cntKindB[i] != null)
					model.setCntKindB(cntKindB[i]);
				if (cntKindC[i] != null)
					model.setCntKindC(cntKindC[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (cntKindD[i] != null)
					model.setCntKindD(cntKindD[i]);
				if (cntKindI[i] != null)
					model.setCntKindI(cntKindI[i]);
				if (cntKindJ[i] != null)
					model.setCntKindJ(cntKindJ[i]);
				if (cntKindK[i] != null)
					model.setCntKindK(cntKindK[i]);
				if (cntKindE[i] != null)
					model.setCntKindE(cntKindE[i]);
				if (cntKindF[i] != null)
					model.setCntKindF(cntKindF[i]);
				if (cntKindG[i] != null)
					model.setCntKindG(cntKindG[i]);
				if (cntKindH[i] != null)
					model.setCntKindH(cntKindH[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCaSummaryReportOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CaSummaryReportOutVO[]
	 */
	public CaSummaryReportOutVO[] getCaSummaryReportOutVOs(){
		CaSummaryReportOutVO[] vos = (CaSummaryReportOutVO[])models.toArray(new CaSummaryReportOutVO[models.size()]);
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
		this.corrDt = this.corrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntHlgC = this.cntHlgC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlModiFlg = this.cxlModiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntHlgM = this.cntHlgM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrUsrId = this.corrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCaTtl = this.cntCaTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDt = this.blObrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntClassN = this.cntClassN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntRsnA = this.cntRsnA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntRsnC = this.cntRsnC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntExempt = this.cntExempt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntClassE = this.cntClassE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrOfcCd = this.corrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caRsnCd = this.caRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntRsnM = this.cntRsnM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSplitModiFlg = this.bkgSplitModiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntBlTtl = this.cntBlTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntRsnR = this.cntRsnR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrNo = this.corrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntRsnG = this.cntRsnG .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntClassR = this.cntClassR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntKindA = this.cntKindA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntKindB = this.cntKindB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntKindC = this.cntKindC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntKindD = this.cntKindD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntKindI = this.cntKindI .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntKindJ = this.cntKindJ .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntKindK = this.cntKindK .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntKindE = this.cntKindE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntKindF = this.cntKindF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntKindG = this.cntKindG .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntKindH = this.cntKindH .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
