/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JapanManifestListMfsDetailVO.java
*@FileTitle : JapanManifestListMfsDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.25  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo;

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

public class JapanManifestListMfsDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JapanManifestListMfsDetailVO> models = new ArrayList<JapanManifestListMfsDetailVO>();
	
	/* Column Info */
	private String appFlg = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String cyOprCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String pstRlyPodCd = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String pstVslCd = null;
	/* Column Info */
	private String trspModCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blNumber = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bdTr = null;
	/* Column Info */
	private String bkgDelCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String blNumber2 = null;
	/* Column Info */
	private String loclTsFlg = null;
	/* Column Info */
	private String msgTp = null;
	/* Column Info */
	private String aproNo = null;
	/* Column Info */
	private String custAddr3 = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String custAddr2 = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String custAddr = null;
	/* Column Info */
	private String blDesc = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String podBnd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String delBnd = null;
	/* Column Info */
	private String custNm3 = null;
	/* Column Info */
	private String custNm2 = null;
	/* Column Info */
	private String jpTmlVslNo = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String preVslCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public JapanManifestListMfsDetailVO() {}

	public JapanManifestListMfsDetailVO(String ibflag, String pagerows, String cyOprCd, String custNm, String pstRlyPodCd, String etaDt, String pstVslCd, String blNumber, String polCd, String bkgDelCd, String measQty, String wgtUtCd, String pckQty, String measUtCd, String pckTpCd, String blNumber2, String loclTsFlg, String custAddr3, String custAddr2, String callSgnNo, String custAddr, String blDesc, String diffRmk, String cntrNo, String seq, String fullMtyCd, String cntrSealNo, String custNm3, String custNm2, String grsWgt, String jpTmlVslNo, String msgTp, String preRlyPortCd, String preVslCd, String appFlg, String bdTr, String aproNo, String podBnd, String delBnd, String trspModCd, String deltFlg) {
		this.appFlg = appFlg;
		this.custNm = custNm;
		this.cyOprCd = cyOprCd;
		this.deltFlg = deltFlg;
		this.pstRlyPodCd = pstRlyPodCd;
		this.etaDt = etaDt;
		this.pstVslCd = pstVslCd;
		this.trspModCd = trspModCd;
		this.pagerows = pagerows;
		this.blNumber = blNumber;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.bdTr = bdTr;
		this.bkgDelCd = bkgDelCd;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.measUtCd = measUtCd;
		this.pckTpCd = pckTpCd;
		this.blNumber2 = blNumber2;
		this.loclTsFlg = loclTsFlg;
		this.msgTp = msgTp;
		this.aproNo = aproNo;
		this.custAddr3 = custAddr3;
		this.preRlyPortCd = preRlyPortCd;
		this.custAddr2 = custAddr2;
		this.callSgnNo = callSgnNo;
		this.custAddr = custAddr;
		this.blDesc = blDesc;
		this.diffRmk = diffRmk;
		this.cntrNo = cntrNo;
		this.podBnd = podBnd;
		this.seq = seq;
		this.fullMtyCd = fullMtyCd;
		this.cntrSealNo = cntrSealNo;
		this.delBnd = delBnd;
		this.custNm3 = custNm3;
		this.custNm2 = custNm2;
		this.jpTmlVslNo = jpTmlVslNo;
		this.grsWgt = grsWgt;
		this.preVslCd = preVslCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("app_flg", getAppFlg());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cy_opr_cd", getCyOprCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("pst_rly_pod_cd", getPstRlyPodCd());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("pst_vsl_cd", getPstVslCd());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_number", getBlNumber());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bd_tr", getBdTr());
		this.hashColumns.put("bkg_del_cd", getBkgDelCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("bl_number2", getBlNumber2());
		this.hashColumns.put("locl_ts_flg", getLoclTsFlg());
		this.hashColumns.put("msg_tp", getMsgTp());
		this.hashColumns.put("apro_no", getAproNo());
		this.hashColumns.put("cust_addr3", getCustAddr3());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("cust_addr2", getCustAddr2());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("cust_addr", getCustAddr());
		this.hashColumns.put("bl_desc", getBlDesc());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pod_bnd", getPodBnd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("del_bnd", getDelBnd());
		this.hashColumns.put("cust_nm3", getCustNm3());
		this.hashColumns.put("cust_nm2", getCustNm2());
		this.hashColumns.put("jp_tml_vsl_no", getJpTmlVslNo());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("pre_vsl_cd", getPreVslCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("app_flg", "appFlg");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cy_opr_cd", "cyOprCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("pst_rly_pod_cd", "pstRlyPodCd");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("pst_vsl_cd", "pstVslCd");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_number", "blNumber");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bd_tr", "bdTr");
		this.hashFields.put("bkg_del_cd", "bkgDelCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("bl_number2", "blNumber2");
		this.hashFields.put("locl_ts_flg", "loclTsFlg");
		this.hashFields.put("msg_tp", "msgTp");
		this.hashFields.put("apro_no", "aproNo");
		this.hashFields.put("cust_addr3", "custAddr3");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("cust_addr2", "custAddr2");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("cust_addr", "custAddr");
		this.hashFields.put("bl_desc", "blDesc");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pod_bnd", "podBnd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("del_bnd", "delBnd");
		this.hashFields.put("cust_nm3", "custNm3");
		this.hashFields.put("cust_nm2", "custNm2");
		this.hashFields.put("jp_tml_vsl_no", "jpTmlVslNo");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("pre_vsl_cd", "preVslCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return appFlg
	 */
	public String getAppFlg() {
		return this.appFlg;
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
	 * @return cyOprCd
	 */
	public String getCyOprCd() {
		return this.cyOprCd;
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
	 * @return pstRlyPodCd
	 */
	public String getPstRlyPodCd() {
		return this.pstRlyPodCd;
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
	 * @return pstVslCd
	 */
	public String getPstVslCd() {
		return this.pstVslCd;
	}
	
	/**
	 * Column Info
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
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
	 * @return blNumber
	 */
	public String getBlNumber() {
		return this.blNumber;
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
	 * @return bdTr
	 */
	public String getBdTr() {
		return this.bdTr;
	}
	
	/**
	 * Column Info
	 * @return bkgDelCd
	 */
	public String getBkgDelCd() {
		return this.bkgDelCd;
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
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
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
	 * @return blNumber2
	 */
	public String getBlNumber2() {
		return this.blNumber2;
	}
	
	/**
	 * Column Info
	 * @return loclTsFlg
	 */
	public String getLoclTsFlg() {
		return this.loclTsFlg;
	}
	
	/**
	 * Column Info
	 * @return msgTp
	 */
	public String getMsgTp() {
		return this.msgTp;
	}
	
	/**
	 * Column Info
	 * @return aproNo
	 */
	public String getAproNo() {
		return this.aproNo;
	}
	
	/**
	 * Column Info
	 * @return custAddr3
	 */
	public String getCustAddr3() {
		return this.custAddr3;
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
	 * @return custAddr2
	 */
	public String getCustAddr2() {
		return this.custAddr2;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return custAddr
	 */
	public String getCustAddr() {
		return this.custAddr;
	}
	
	/**
	 * Column Info
	 * @return blDesc
	 */
	public String getBlDesc() {
		return this.blDesc;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return podBnd
	 */
	public String getPodBnd() {
		return this.podBnd;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return delBnd
	 */
	public String getDelBnd() {
		return this.delBnd;
	}
	
	/**
	 * Column Info
	 * @return custNm3
	 */
	public String getCustNm3() {
		return this.custNm3;
	}
	
	/**
	 * Column Info
	 * @return custNm2
	 */
	public String getCustNm2() {
		return this.custNm2;
	}
	
	/**
	 * Column Info
	 * @return jpTmlVslNo
	 */
	public String getJpTmlVslNo() {
		return this.jpTmlVslNo;
	}
	
	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
	}
	
	/**
	 * Column Info
	 * @return preVslCd
	 */
	public String getPreVslCd() {
		return this.preVslCd;
	}
	

	/**
	 * Column Info
	 * @param appFlg
	 */
	public void setAppFlg(String appFlg) {
		this.appFlg = appFlg;
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
	 * @param cyOprCd
	 */
	public void setCyOprCd(String cyOprCd) {
		this.cyOprCd = cyOprCd;
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
	 * @param pstRlyPodCd
	 */
	public void setPstRlyPodCd(String pstRlyPodCd) {
		this.pstRlyPodCd = pstRlyPodCd;
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
	 * @param pstVslCd
	 */
	public void setPstVslCd(String pstVslCd) {
		this.pstVslCd = pstVslCd;
	}
	
	/**
	 * Column Info
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
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
	 * @param blNumber
	 */
	public void setBlNumber(String blNumber) {
		this.blNumber = blNumber;
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
	 * @param bdTr
	 */
	public void setBdTr(String bdTr) {
		this.bdTr = bdTr;
	}
	
	/**
	 * Column Info
	 * @param bkgDelCd
	 */
	public void setBkgDelCd(String bkgDelCd) {
		this.bkgDelCd = bkgDelCd;
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
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
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
	 * @param blNumber2
	 */
	public void setBlNumber2(String blNumber2) {
		this.blNumber2 = blNumber2;
	}
	
	/**
	 * Column Info
	 * @param loclTsFlg
	 */
	public void setLoclTsFlg(String loclTsFlg) {
		this.loclTsFlg = loclTsFlg;
	}
	
	/**
	 * Column Info
	 * @param msgTp
	 */
	public void setMsgTp(String msgTp) {
		this.msgTp = msgTp;
	}
	
	/**
	 * Column Info
	 * @param aproNo
	 */
	public void setAproNo(String aproNo) {
		this.aproNo = aproNo;
	}
	
	/**
	 * Column Info
	 * @param custAddr3
	 */
	public void setCustAddr3(String custAddr3) {
		this.custAddr3 = custAddr3;
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
	 * @param custAddr2
	 */
	public void setCustAddr2(String custAddr2) {
		this.custAddr2 = custAddr2;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param custAddr
	 */
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	
	/**
	 * Column Info
	 * @param blDesc
	 */
	public void setBlDesc(String blDesc) {
		this.blDesc = blDesc;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param podBnd
	 */
	public void setPodBnd(String podBnd) {
		this.podBnd = podBnd;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param delBnd
	 */
	public void setDelBnd(String delBnd) {
		this.delBnd = delBnd;
	}
	
	/**
	 * Column Info
	 * @param custNm3
	 */
	public void setCustNm3(String custNm3) {
		this.custNm3 = custNm3;
	}
	
	/**
	 * Column Info
	 * @param custNm2
	 */
	public void setCustNm2(String custNm2) {
		this.custNm2 = custNm2;
	}
	
	/**
	 * Column Info
	 * @param jpTmlVslNo
	 */
	public void setJpTmlVslNo(String jpTmlVslNo) {
		this.jpTmlVslNo = jpTmlVslNo;
	}
	
	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
	}
	
	/**
	 * Column Info
	 * @param preVslCd
	 */
	public void setPreVslCd(String preVslCd) {
		this.preVslCd = preVslCd;
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
		setAppFlg(JSPUtil.getParameter(request, prefix + "app_flg", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setCyOprCd(JSPUtil.getParameter(request, prefix + "cy_opr_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setPstRlyPodCd(JSPUtil.getParameter(request, prefix + "pst_rly_pod_cd", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setPstVslCd(JSPUtil.getParameter(request, prefix + "pst_vsl_cd", ""));
		setTrspModCd(JSPUtil.getParameter(request, prefix + "trsp_mod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBlNumber(JSPUtil.getParameter(request, prefix + "bl_number", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBdTr(JSPUtil.getParameter(request, prefix + "bd_tr", ""));
		setBkgDelCd(JSPUtil.getParameter(request, prefix + "bkg_del_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setBlNumber2(JSPUtil.getParameter(request, prefix + "bl_number2", ""));
		setLoclTsFlg(JSPUtil.getParameter(request, prefix + "locl_ts_flg", ""));
		setMsgTp(JSPUtil.getParameter(request, prefix + "msg_tp", ""));
		setAproNo(JSPUtil.getParameter(request, prefix + "apro_no", ""));
		setCustAddr3(JSPUtil.getParameter(request, prefix + "cust_addr3", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, prefix + "pre_rly_port_cd", ""));
		setCustAddr2(JSPUtil.getParameter(request, prefix + "cust_addr2", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setCustAddr(JSPUtil.getParameter(request, prefix + "cust_addr", ""));
		setBlDesc(JSPUtil.getParameter(request, prefix + "bl_desc", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setPodBnd(JSPUtil.getParameter(request, prefix + "pod_bnd", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setFullMtyCd(JSPUtil.getParameter(request, prefix + "full_mty_cd", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setDelBnd(JSPUtil.getParameter(request, prefix + "del_bnd", ""));
		setCustNm3(JSPUtil.getParameter(request, prefix + "cust_nm3", ""));
		setCustNm2(JSPUtil.getParameter(request, prefix + "cust_nm2", ""));
		setJpTmlVslNo(JSPUtil.getParameter(request, prefix + "jp_tml_vsl_no", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setPreVslCd(JSPUtil.getParameter(request, prefix + "pre_vsl_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestListMfsDetailVO[]
	 */
	public JapanManifestListMfsDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapanManifestListMfsDetailVO[]
	 */
	public JapanManifestListMfsDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanManifestListMfsDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] appFlg = (JSPUtil.getParameter(request, prefix	+ "app_flg", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] cyOprCd = (JSPUtil.getParameter(request, prefix	+ "cy_opr_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] pstRlyPodCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_pod_cd", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] pstVslCd = (JSPUtil.getParameter(request, prefix	+ "pst_vsl_cd", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blNumber = (JSPUtil.getParameter(request, prefix	+ "bl_number", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bdTr = (JSPUtil.getParameter(request, prefix	+ "bd_tr", length));
			String[] bkgDelCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] blNumber2 = (JSPUtil.getParameter(request, prefix	+ "bl_number2", length));
			String[] loclTsFlg = (JSPUtil.getParameter(request, prefix	+ "locl_ts_flg", length));
			String[] msgTp = (JSPUtil.getParameter(request, prefix	+ "msg_tp", length));
			String[] aproNo = (JSPUtil.getParameter(request, prefix	+ "apro_no", length));
			String[] custAddr3 = (JSPUtil.getParameter(request, prefix	+ "cust_addr3", length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd", length));
			String[] custAddr2 = (JSPUtil.getParameter(request, prefix	+ "cust_addr2", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] custAddr = (JSPUtil.getParameter(request, prefix	+ "cust_addr", length));
			String[] blDesc = (JSPUtil.getParameter(request, prefix	+ "bl_desc", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] podBnd = (JSPUtil.getParameter(request, prefix	+ "pod_bnd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] delBnd = (JSPUtil.getParameter(request, prefix	+ "del_bnd", length));
			String[] custNm3 = (JSPUtil.getParameter(request, prefix	+ "cust_nm3", length));
			String[] custNm2 = (JSPUtil.getParameter(request, prefix	+ "cust_nm2", length));
			String[] jpTmlVslNo = (JSPUtil.getParameter(request, prefix	+ "jp_tml_vsl_no", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] preVslCd = (JSPUtil.getParameter(request, prefix	+ "pre_vsl_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new JapanManifestListMfsDetailVO();
				if (appFlg[i] != null)
					model.setAppFlg(appFlg[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (cyOprCd[i] != null)
					model.setCyOprCd(cyOprCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (pstRlyPodCd[i] != null)
					model.setPstRlyPodCd(pstRlyPodCd[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (pstVslCd[i] != null)
					model.setPstVslCd(pstVslCd[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blNumber[i] != null)
					model.setBlNumber(blNumber[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bdTr[i] != null)
					model.setBdTr(bdTr[i]);
				if (bkgDelCd[i] != null)
					model.setBkgDelCd(bkgDelCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (blNumber2[i] != null)
					model.setBlNumber2(blNumber2[i]);
				if (loclTsFlg[i] != null)
					model.setLoclTsFlg(loclTsFlg[i]);
				if (msgTp[i] != null)
					model.setMsgTp(msgTp[i]);
				if (aproNo[i] != null)
					model.setAproNo(aproNo[i]);
				if (custAddr3[i] != null)
					model.setCustAddr3(custAddr3[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (custAddr2[i] != null)
					model.setCustAddr2(custAddr2[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (custAddr[i] != null)
					model.setCustAddr(custAddr[i]);
				if (blDesc[i] != null)
					model.setBlDesc(blDesc[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (podBnd[i] != null)
					model.setPodBnd(podBnd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (delBnd[i] != null)
					model.setDelBnd(delBnd[i]);
				if (custNm3[i] != null)
					model.setCustNm3(custNm3[i]);
				if (custNm2[i] != null)
					model.setCustNm2(custNm2[i]);
				if (jpTmlVslNo[i] != null)
					model.setJpTmlVslNo(jpTmlVslNo[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (preVslCd[i] != null)
					model.setPreVslCd(preVslCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanManifestListMfsDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanManifestListMfsDetailVO[]
	 */
	public JapanManifestListMfsDetailVO[] getJapanManifestListMfsDetailVOs(){
		JapanManifestListMfsDetailVO[] vos = (JapanManifestListMfsDetailVO[])models.toArray(new JapanManifestListMfsDetailVO[models.size()]);
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
		this.appFlg = this.appFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cyOprCd = this.cyOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPodCd = this.pstRlyPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstVslCd = this.pstVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNumber = this.blNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdTr = this.bdTr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCd = this.bkgDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNumber2 = this.blNumber2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTsFlg = this.loclTsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgTp = this.msgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproNo = this.aproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr3 = this.custAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr2 = this.custAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr = this.custAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDesc = this.blDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podBnd = this.podBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delBnd = this.delBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm3 = this.custNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm2 = this.custNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpTmlVslNo = this.jpTmlVslNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVslCd = this.preVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
