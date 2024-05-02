/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgContainerInfoVO.java
*@FileTitle : BkgContainerInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.08.20 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgContainerInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgContainerInfoVO> models = new ArrayList<BkgContainerInfoVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String delRgnCd = null;
	/* Column Info */
	private String salRhq = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String yrdCntCd = null;
	/* Column Info */
	private String advShtgCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String yrdRgnCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polSteCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String yrdSteCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String polRgnCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String yrdCd = null;
	/* Column Info */
	private String porCntCd = null;
	/* Column Info */
	private String delSteCd = null;
	/* Column Info */
	private String cntrPrtFlg = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String bbDeTermCd = null;
	/* Column Info */
	private String delCntCd = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String bbRcvTermCd = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String polCntCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String polContiCd = null;
	/* Column Info */
	private String porSteCd = null;
	/* Column Info */
	private String yrdContiCd = null;
	/* Column Info */
	private String porRgnCd = null;
	/* Column Info */
	private String delContiCd = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String pstRlyPortCd = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String porContiCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgContainerInfoVO() {}

	public BkgContainerInfoVO(String ibflag, String pagerows, String blNo, String porCd, String porContiCd, String porCntCd, String porRgnCd, String porSteCd, String podCd, String polCd, String polContiCd, String polCntCd, String polRgnCd, String polSteCd, String delCd, String delContiCd, String delCntCd, String delRgnCd, String delSteCd, String yrdCd, String yrdContiCd, String yrdCntCd, String yrdRgnCd, String yrdSteCd, String dcgoFlg, String rcFlg, String awkCgoFlg, String rdCgoFlg, String bbCgoFlg, String socFlg, String cntrPrtFlg, String advShtgCd, String obSlsOfcCd, String salRhq, String scNo, String rfaNo, String cmdtCd, String repCmdtCd, String pstRlyPortCd, String deTermCd, String preRlyPortCd, String bbRcvTermCd, String bbDeTermCd, String rcvTermCd) {
		this.porCd = porCd;
		this.delRgnCd = delRgnCd;
		this.salRhq = salRhq;
		this.rdCgoFlg = rdCgoFlg;
		this.yrdCntCd = yrdCntCd;
		this.advShtgCd = advShtgCd;
		this.blNo = blNo;
		this.yrdRgnCd = yrdRgnCd;
		this.pagerows = pagerows;
		this.polSteCd = polSteCd;
		this.rfaNo = rfaNo;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.yrdSteCd = yrdSteCd;
		this.scNo = scNo;
		this.bbCgoFlg = bbCgoFlg;
		this.polRgnCd = polRgnCd;
		this.dcgoFlg = dcgoFlg;
		this.obSlsOfcCd = obSlsOfcCd;
		this.yrdCd = yrdCd;
		this.porCntCd = porCntCd;
		this.delSteCd = delSteCd;
		this.cntrPrtFlg = cntrPrtFlg;
		this.preRlyPortCd = preRlyPortCd;
		this.bbDeTermCd = bbDeTermCd;
		this.delCntCd = delCntCd;
		this.awkCgoFlg = awkCgoFlg;
		this.delCd = delCd;
		this.bbRcvTermCd = bbRcvTermCd;
		this.socFlg = socFlg;
		this.polCntCd = polCntCd;
		this.podCd = podCd;
		this.deTermCd = deTermCd;
		this.polContiCd = polContiCd;
		this.porSteCd = porSteCd;
		this.yrdContiCd = yrdContiCd;
		this.porRgnCd = porRgnCd;
		this.delContiCd = delContiCd;
		this.rcFlg = rcFlg;
		this.pstRlyPortCd = pstRlyPortCd;
		this.repCmdtCd = repCmdtCd;
		this.porContiCd = porContiCd;
		this.rcvTermCd =  rcvTermCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("del_rgn_cd", getDelRgnCd());
		this.hashColumns.put("sal_rhq", getSalRhq());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("yrd_cnt_cd", getYrdCntCd());
		this.hashColumns.put("adv_shtg_cd", getAdvShtgCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("yrd_rgn_cd", getYrdRgnCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_ste_cd", getPolSteCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("yrd_ste_cd", getYrdSteCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("pol_rgn_cd", getPolRgnCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("yrd_cd", getYrdCd());
		this.hashColumns.put("por_cnt_cd", getPorCntCd());
		this.hashColumns.put("del_ste_cd", getDelSteCd());
		this.hashColumns.put("cntr_prt_flg", getCntrPrtFlg());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("bb_de_term_cd", getBbDeTermCd());
		this.hashColumns.put("del_cnt_cd", getDelCntCd());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bb_rcv_term_cd", getBbRcvTermCd());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("pol_cnt_cd", getPolCntCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("pol_conti_cd", getPolContiCd());
		this.hashColumns.put("por_ste_cd", getPorSteCd());
		this.hashColumns.put("yrd_conti_cd", getYrdContiCd());
		this.hashColumns.put("por_rgn_cd", getPorRgnCd());
		this.hashColumns.put("del_conti_cd", getDelContiCd());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("por_conti_cd", getPorContiCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("del_rgn_cd", "delRgnCd");
		this.hashFields.put("sal_rhq", "salRhq");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("yrd_cnt_cd", "yrdCntCd");
		this.hashFields.put("adv_shtg_cd", "advShtgCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("yrd_rgn_cd", "yrdRgnCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_ste_cd", "polSteCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("yrd_ste_cd", "yrdSteCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("pol_rgn_cd", "polRgnCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("yrd_cd", "yrdCd");
		this.hashFields.put("por_cnt_cd", "porCntCd");
		this.hashFields.put("del_ste_cd", "delSteCd");
		this.hashFields.put("cntr_prt_flg", "cntrPrtFlg");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("bb_de_term_cd", "bbDeTermCd");
		this.hashFields.put("del_cnt_cd", "delCntCd");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bb_rcv_term_cd", "bbRcvTermCd");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("pol_cnt_cd", "polCntCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("pol_conti_cd", "polContiCd");
		this.hashFields.put("por_ste_cd", "porSteCd");
		this.hashFields.put("yrd_conti_cd", "yrdContiCd");
		this.hashFields.put("por_rgn_cd", "porRgnCd");
		this.hashFields.put("del_conti_cd", "delContiCd");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("por_conti_cd", "porContiCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		return this.hashFields;
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
	 * @return delRgnCd
	 */
	public String getDelRgnCd() {
		return this.delRgnCd;
	}
	
	/**
	 * Column Info
	 * @return salRhq
	 */
	public String getSalRhq() {
		return this.salRhq;
	}
	
	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return yrdCntCd
	 */
	public String getYrdCntCd() {
		return this.yrdCntCd;
	}
	
	/**
	 * Column Info
	 * @return advShtgCd
	 */
	public String getAdvShtgCd() {
		return this.advShtgCd;
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
	 * @return yrdRgnCd
	 */
	public String getYrdRgnCd() {
		return this.yrdRgnCd;
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
	 * @return polSteCd
	 */
	public String getPolSteCd() {
		return this.polSteCd;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return yrdSteCd
	 */
	public String getYrdSteCd() {
		return this.yrdSteCd;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return polRgnCd
	 */
	public String getPolRgnCd() {
		return this.polRgnCd;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return yrdCd
	 */
	public String getYrdCd() {
		return this.yrdCd;
	}
	
	/**
	 * Column Info
	 * @return porCntCd
	 */
	public String getPorCntCd() {
		return this.porCntCd;
	}
	
	/**
	 * Column Info
	 * @return delSteCd
	 */
	public String getDelSteCd() {
		return this.delSteCd;
	}
	
	/**
	 * Column Info
	 * @return cntrPrtFlg
	 */
	public String getCntrPrtFlg() {
		return this.cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @return preRlyPortCd
	 */
	public String getPreRlyPortCd() {
		return this.preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return bbDeTermCd
	 */
	public String getBbDeTermCd() {
		return this.bbDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return delCntCd
	 */
	public String getDelCntCd() {
		return this.delCntCd;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
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
	 * @return bbRcvTermCd
	 */
	public String getBbRcvTermCd() {
		return this.bbRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
	}
	
	/**
	 * Column Info
	 * @return polCntCd
	 */
	public String getPolCntCd() {
		return this.polCntCd;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return polContiCd
	 */
	public String getPolContiCd() {
		return this.polContiCd;
	}
	
	/**
	 * Column Info
	 * @return porSteCd
	 */
	public String getPorSteCd() {
		return this.porSteCd;
	}
	
	/**
	 * Column Info
	 * @return yrdContiCd
	 */
	public String getYrdContiCd() {
		return this.yrdContiCd;
	}
	
	/**
	 * Column Info
	 * @return porRgnCd
	 */
	public String getPorRgnCd() {
		return this.porRgnCd;
	}
	
	/**
	 * Column Info
	 * @return delContiCd
	 */
	public String getDelContiCd() {
		return this.delContiCd;
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
	 * @return pstRlyPortCd
	 */
	public String getPstRlyPortCd() {
		return this.pstRlyPortCd;
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
	 * @return porContiCd
	 */
	public String getPorContiCd() {
		return this.porContiCd;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return rcvTermCd;
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
	 * @param delRgnCd
	 */
	public void setDelRgnCd(String delRgnCd) {
		this.delRgnCd = delRgnCd;
	}
	
	/**
	 * Column Info
	 * @param salRhq
	 */
	public void setSalRhq(String salRhq) {
		this.salRhq = salRhq;
	}
	
	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param yrdCntCd
	 */
	public void setYrdCntCd(String yrdCntCd) {
		this.yrdCntCd = yrdCntCd;
	}
	
	/**
	 * Column Info
	 * @param advShtgCd
	 */
	public void setAdvShtgCd(String advShtgCd) {
		this.advShtgCd = advShtgCd;
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
	 * @param yrdRgnCd
	 */
	public void setYrdRgnCd(String yrdRgnCd) {
		this.yrdRgnCd = yrdRgnCd;
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
	 * @param polSteCd
	 */
	public void setPolSteCd(String polSteCd) {
		this.polSteCd = polSteCd;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param yrdSteCd
	 */
	public void setYrdSteCd(String yrdSteCd) {
		this.yrdSteCd = yrdSteCd;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param polRgnCd
	 */
	public void setPolRgnCd(String polRgnCd) {
		this.polRgnCd = polRgnCd;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param yrdCd
	 */
	public void setYrdCd(String yrdCd) {
		this.yrdCd = yrdCd;
	}
	
	/**
	 * Column Info
	 * @param porCntCd
	 */
	public void setPorCntCd(String porCntCd) {
		this.porCntCd = porCntCd;
	}
	
	/**
	 * Column Info
	 * @param delSteCd
	 */
	public void setDelSteCd(String delSteCd) {
		this.delSteCd = delSteCd;
	}
	
	/**
	 * Column Info
	 * @param cntrPrtFlg
	 */
	public void setCntrPrtFlg(String cntrPrtFlg) {
		this.cntrPrtFlg = cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @param preRlyPortCd
	 */
	public void setPreRlyPortCd(String preRlyPortCd) {
		this.preRlyPortCd = preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param bbDeTermCd
	 */
	public void setBbDeTermCd(String bbDeTermCd) {
		this.bbDeTermCd = bbDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param delCntCd
	 */
	public void setDelCntCd(String delCntCd) {
		this.delCntCd = delCntCd;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
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
	 * @param bbRcvTermCd
	 */
	public void setBbRcvTermCd(String bbRcvTermCd) {
		this.bbRcvTermCd = bbRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}
	
	/**
	 * Column Info
	 * @param polCntCd
	 */
	public void setPolCntCd(String polCntCd) {
		this.polCntCd = polCntCd;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param polContiCd
	 */
	public void setPolContiCd(String polContiCd) {
		this.polContiCd = polContiCd;
	}
	
	/**
	 * Column Info
	 * @param porSteCd
	 */
	public void setPorSteCd(String porSteCd) {
		this.porSteCd = porSteCd;
	}
	
	/**
	 * Column Info
	 * @param yrdContiCd
	 */
	public void setYrdContiCd(String yrdContiCd) {
		this.yrdContiCd = yrdContiCd;
	}
	
	/**
	 * Column Info
	 * @param porRgnCd
	 */
	public void setPorRgnCd(String porRgnCd) {
		this.porRgnCd = porRgnCd;
	}
	
	/**
	 * Column Info
	 * @param delContiCd
	 */
	public void setDelContiCd(String delContiCd) {
		this.delContiCd = delContiCd;
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
	 * @param pstRlyPortCd
	 */
	public void setPstRlyPortCd(String pstRlyPortCd) {
		this.pstRlyPortCd = pstRlyPortCd;
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
	 * @param porContiCd
	 */
	public void setPorContiCd(String porContiCd) {
		this.porContiCd = porContiCd;
	}

	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}

	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setDelRgnCd(JSPUtil.getParameter(request, "del_rgn_cd", ""));
		setSalRhq(JSPUtil.getParameter(request, "sal_rhq", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, "rd_cgo_flg", ""));
		setYrdCntCd(JSPUtil.getParameter(request, "yrd_cnt_cd", ""));
		setAdvShtgCd(JSPUtil.getParameter(request, "adv_shtg_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setYrdRgnCd(JSPUtil.getParameter(request, "yrd_rgn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolSteCd(JSPUtil.getParameter(request, "pol_ste_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setYrdSteCd(JSPUtil.getParameter(request, "yrd_ste_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, "bb_cgo_flg", ""));
		setPolRgnCd(JSPUtil.getParameter(request, "pol_rgn_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, "dcgo_flg", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, "ob_sls_ofc_cd", ""));
		setYrdCd(JSPUtil.getParameter(request, "yrd_cd", ""));
		setPorCntCd(JSPUtil.getParameter(request, "por_cnt_cd", ""));
		setDelSteCd(JSPUtil.getParameter(request, "del_ste_cd", ""));
		setCntrPrtFlg(JSPUtil.getParameter(request, "cntr_prt_flg", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, "pre_rly_port_cd", ""));
		setBbDeTermCd(JSPUtil.getParameter(request, "bb_de_term_cd", ""));
		setDelCntCd(JSPUtil.getParameter(request, "del_cnt_cd", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, "awk_cgo_flg", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setBbRcvTermCd(JSPUtil.getParameter(request, "bb_rcv_term_cd", ""));
		setSocFlg(JSPUtil.getParameter(request, "soc_flg", ""));
		setPolCntCd(JSPUtil.getParameter(request, "pol_cnt_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setPolContiCd(JSPUtil.getParameter(request, "pol_conti_cd", ""));
		setPorSteCd(JSPUtil.getParameter(request, "por_ste_cd", ""));
		setYrdContiCd(JSPUtil.getParameter(request, "yrd_conti_cd", ""));
		setPorRgnCd(JSPUtil.getParameter(request, "por_rgn_cd", ""));
		setDelContiCd(JSPUtil.getParameter(request, "del_conti_cd", ""));
		setRcFlg(JSPUtil.getParameter(request, "rc_flg", ""));
		setPstRlyPortCd(JSPUtil.getParameter(request, "pst_rly_port_cd", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, "rep_cmdt_cd", ""));
		setPorContiCd(JSPUtil.getParameter(request, "por_conti_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgContainerInfoVO[]
	 */
	public BkgContainerInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgContainerInfoVO[]
	 */
	public BkgContainerInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgContainerInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] delRgnCd = (JSPUtil.getParameter(request, prefix	+ "del_rgn_cd", length));
			String[] salRhq = (JSPUtil.getParameter(request, prefix	+ "sal_rhq", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] yrdCntCd = (JSPUtil.getParameter(request, prefix	+ "yrd_cnt_cd", length));
			String[] advShtgCd = (JSPUtil.getParameter(request, prefix	+ "adv_shtg_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] yrdRgnCd = (JSPUtil.getParameter(request, prefix	+ "yrd_rgn_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polSteCd = (JSPUtil.getParameter(request, prefix	+ "pol_ste_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] yrdSteCd = (JSPUtil.getParameter(request, prefix	+ "yrd_ste_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] polRgnCd = (JSPUtil.getParameter(request, prefix	+ "pol_rgn_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] yrdCd = (JSPUtil.getParameter(request, prefix	+ "yrd_cd", length));
			String[] porCntCd = (JSPUtil.getParameter(request, prefix	+ "por_cnt_cd", length));
			String[] delSteCd = (JSPUtil.getParameter(request, prefix	+ "del_ste_cd", length));
			String[] cntrPrtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_prt_flg", length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd", length));
			String[] bbDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bb_de_term_cd", length));
			String[] delCntCd = (JSPUtil.getParameter(request, prefix	+ "del_cnt_cd", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] bbRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "bb_rcv_term_cd", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] polCntCd = (JSPUtil.getParameter(request, prefix	+ "pol_cnt_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] polContiCd = (JSPUtil.getParameter(request, prefix	+ "pol_conti_cd", length));
			String[] porSteCd = (JSPUtil.getParameter(request, prefix	+ "por_ste_cd", length));
			String[] yrdContiCd = (JSPUtil.getParameter(request, prefix	+ "yrd_conti_cd", length));
			String[] porRgnCd = (JSPUtil.getParameter(request, prefix	+ "por_rgn_cd", length));
			String[] delContiCd = (JSPUtil.getParameter(request, prefix	+ "del_conti_cd", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_cd", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] porContiCd = (JSPUtil.getParameter(request, prefix	+ "por_conti_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgContainerInfoVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (delRgnCd[i] != null)
					model.setDelRgnCd(delRgnCd[i]);
				if (salRhq[i] != null)
					model.setSalRhq(salRhq[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (yrdCntCd[i] != null)
					model.setYrdCntCd(yrdCntCd[i]);
				if (advShtgCd[i] != null)
					model.setAdvShtgCd(advShtgCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (yrdRgnCd[i] != null)
					model.setYrdRgnCd(yrdRgnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polSteCd[i] != null)
					model.setPolSteCd(polSteCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (yrdSteCd[i] != null)
					model.setYrdSteCd(yrdSteCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (polRgnCd[i] != null)
					model.setPolRgnCd(polRgnCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (yrdCd[i] != null)
					model.setYrdCd(yrdCd[i]);
				if (porCntCd[i] != null)
					model.setPorCntCd(porCntCd[i]);
				if (delSteCd[i] != null)
					model.setDelSteCd(delSteCd[i]);
				if (cntrPrtFlg[i] != null)
					model.setCntrPrtFlg(cntrPrtFlg[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (bbDeTermCd[i] != null)
					model.setBbDeTermCd(bbDeTermCd[i]);
				if (delCntCd[i] != null)
					model.setDelCntCd(delCntCd[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (bbRcvTermCd[i] != null)
					model.setBbRcvTermCd(bbRcvTermCd[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (polCntCd[i] != null)
					model.setPolCntCd(polCntCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (polContiCd[i] != null)
					model.setPolContiCd(polContiCd[i]);
				if (porSteCd[i] != null)
					model.setPorSteCd(porSteCd[i]);
				if (yrdContiCd[i] != null)
					model.setYrdContiCd(yrdContiCd[i]);
				if (porRgnCd[i] != null)
					model.setPorRgnCd(porRgnCd[i]);
				if (delContiCd[i] != null)
					model.setDelContiCd(delContiCd[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (pstRlyPortCd[i] != null)
					model.setPstRlyPortCd(pstRlyPortCd[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (porContiCd[i] != null)
					model.setPorContiCd(porContiCd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgContainerInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgContainerInfoVO[]
	 */
	public BkgContainerInfoVO[] getBkgContainerInfoVOs(){
		BkgContainerInfoVO[] vos = (BkgContainerInfoVO[])models.toArray(new BkgContainerInfoVO[models.size()]);
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
		this.delRgnCd = this.delRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salRhq = this.salRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrdCntCd = this.yrdCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.advShtgCd = this.advShtgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrdRgnCd = this.yrdRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polSteCd = this.polSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrdSteCd = this.yrdSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polRgnCd = this.polRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrdCd = this.yrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCntCd = this.porCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delSteCd = this.delSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPrtFlg = this.cntrPrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbDeTermCd = this.bbDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCntCd = this.delCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbRcvTermCd = this.bbRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCntCd = this.polCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polContiCd = this.polContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porSteCd = this.porSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrdContiCd = this.yrdContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porRgnCd = this.porRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delContiCd = this.delContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortCd = this.pstRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porContiCd = this.porContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
