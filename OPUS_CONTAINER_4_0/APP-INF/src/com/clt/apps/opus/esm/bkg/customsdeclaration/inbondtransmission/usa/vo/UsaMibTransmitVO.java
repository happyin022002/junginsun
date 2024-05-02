/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaMibTransmitVO.java
*@FileTitle : UsaMibTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.28  
* 1.0 Creation
* ------------------------------------------------------
* History
* 2012.05.10 김보배 [CHM-201217461] [BKG] [ACE M1] US AMS 전송후 1J 이후 Diversion 요청 기능 추가
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.vo.MibTransmitVO;
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

public class UsaMibTransmitVO extends MibTransmitVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaMibTransmitVO> models = new ArrayList<UsaMibTransmitVO>();
	
	/* Column Info */
	private String usaLstLocCd = null;
	/* Column Info */
	private String xptFlg = null;
	/* Column Info */
	private String arrDt = null;
	/* Column Info */
	private String transGubun = null;
	/* Column Info */
	private String trspIssDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String xptAcptDt = null;
	/* Column Info */
	private String trspIssTime = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String frtCltFlg = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String blCntrFlag = null;
	/* Column Info */
	private String mjrIbdAuthDt = null;
	/* Column Info */
	private String cstmsPodCd = null;
	/* Column Info */
	private String arrTime = null;
	/* Column Info */
	private String xptDt = null;
	/* Column Info */
	private String ibdTrspNo = null;
	/* Column Info */
	private String cstmsClrCd = null;
	/* Column Info */
	private String mjrIbdAuthTime = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String oblRdemFlg = null;
	/* Column Info */
	private String arrFlg = null;
	/* Column Info */
	private String ibdTpCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String avalDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String xptAcptTime = null;
	/* Column Info */
	private String trspAuthDt = null;
	/* Column Info */
	private String hubLocCd = null;
	/* Column Info */
	private String xptTime = null;
	/* Column Info */
	private String trspAuthTime = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String divInd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaMibTransmitVO() {}

	public UsaMibTransmitVO(String ibflag, String pagerows, String usaLstLocCd, String xptFlg, String arrDt, String trspIssDt, String blNo, String trspIssTime, String xptAcptDt, String cnmvStsCd, String frtCltFlg, String blCntrFlag, String mjrIbdAuthDt, String arrTime, String xptDt, String ibdTrspNo, String cstmsClrCd, String mjrIbdAuthTime, String delCd, String oblRdemFlg, String arrFlg, String ibdTpCd, String vvd, String podCd, String avalDt, String ydCd, String cntrNo, String trspAuthDt, String xptAcptTime, String trspAuthTime, String xptTime, String hubLocCd, String pkupNo, String cstmsPodCd, String usrId, String ofcCd, String transGubun, String divInd) {
		this.usaLstLocCd = usaLstLocCd;
		this.xptFlg = xptFlg;
		this.arrDt = arrDt;
		this.transGubun = transGubun;
		this.trspIssDt = trspIssDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.xptAcptDt = xptAcptDt;
		this.trspIssTime = trspIssTime;
		this.cnmvStsCd = cnmvStsCd;
		this.ibflag = ibflag;
		this.frtCltFlg = frtCltFlg;
		this.usrId = usrId;
		this.blCntrFlag = blCntrFlag;
		this.mjrIbdAuthDt = mjrIbdAuthDt;
		this.cstmsPodCd = cstmsPodCd;
		this.arrTime = arrTime;
		this.xptDt = xptDt;
		this.ibdTrspNo = ibdTrspNo;
		this.cstmsClrCd = cstmsClrCd;
		this.mjrIbdAuthTime = mjrIbdAuthTime;
		this.delCd = delCd;
		this.oblRdemFlg = oblRdemFlg;
		this.arrFlg = arrFlg;
		this.ibdTpCd = ibdTpCd;
		this.vvd = vvd;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.ydCd = ydCd;
		this.avalDt = avalDt;
		this.cntrNo = cntrNo;
		this.xptAcptTime = xptAcptTime;
		this.trspAuthDt = trspAuthDt;
		this.hubLocCd = hubLocCd;
		this.xptTime = xptTime;
		this.trspAuthTime = trspAuthTime;
		this.pkupNo = pkupNo;
		this.divInd = divInd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("usa_lst_loc_cd", getUsaLstLocCd());
		this.hashColumns.put("xpt_flg", getXptFlg());
		this.hashColumns.put("arr_dt", getArrDt());
		this.hashColumns.put("trans_gubun", getTransGubun());
		this.hashColumns.put("trsp_iss_dt", getTrspIssDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("xpt_acpt_dt", getXptAcptDt());
		this.hashColumns.put("trsp_iss_time", getTrspIssTime());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frt_clt_flg", getFrtCltFlg());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("bl_cntr_flag", getBlCntrFlag());
		this.hashColumns.put("mjr_ibd_auth_dt", getMjrIbdAuthDt());
		this.hashColumns.put("cstms_pod_cd", getCstmsPodCd());
		this.hashColumns.put("arr_time", getArrTime());
		this.hashColumns.put("xpt_dt", getXptDt());
		this.hashColumns.put("ibd_trsp_no", getIbdTrspNo());
		this.hashColumns.put("cstms_clr_cd", getCstmsClrCd());
		this.hashColumns.put("mjr_ibd_auth_time", getMjrIbdAuthTime());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("obl_rdem_flg", getOblRdemFlg());
		this.hashColumns.put("arr_flg", getArrFlg());
		this.hashColumns.put("ibd_tp_cd", getIbdTpCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("aval_dt", getAvalDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("xpt_acpt_time", getXptAcptTime());
		this.hashColumns.put("trsp_auth_dt", getTrspAuthDt());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		this.hashColumns.put("xpt_time", getXptTime());
		this.hashColumns.put("trsp_auth_time", getTrspAuthTime());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("divInd", getDivInd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("usa_lst_loc_cd", "usaLstLocCd");
		this.hashFields.put("xpt_flg", "xptFlg");
		this.hashFields.put("arr_dt", "arrDt");
		this.hashFields.put("trans_gubun", "transGubun");
		this.hashFields.put("trsp_iss_dt", "trspIssDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("xpt_acpt_dt", "xptAcptDt");
		this.hashFields.put("trsp_iss_time", "trspIssTime");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frt_clt_flg", "frtCltFlg");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("bl_cntr_flag", "blCntrFlag");
		this.hashFields.put("mjr_ibd_auth_dt", "mjrIbdAuthDt");
		this.hashFields.put("cstms_pod_cd", "cstmsPodCd");
		this.hashFields.put("arr_time", "arrTime");
		this.hashFields.put("xpt_dt", "xptDt");
		this.hashFields.put("ibd_trsp_no", "ibdTrspNo");
		this.hashFields.put("cstms_clr_cd", "cstmsClrCd");
		this.hashFields.put("mjr_ibd_auth_time", "mjrIbdAuthTime");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("obl_rdem_flg", "oblRdemFlg");
		this.hashFields.put("arr_flg", "arrFlg");
		this.hashFields.put("ibd_tp_cd", "ibdTpCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("aval_dt", "avalDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("xpt_acpt_time", "xptAcptTime");
		this.hashFields.put("trsp_auth_dt", "trspAuthDt");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		this.hashFields.put("xpt_time", "xptTime");
		this.hashFields.put("trsp_auth_time", "trspAuthTime");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("divInd", "divInd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return usaLstLocCd
	 */
	public String getUsaLstLocCd() {
		return this.usaLstLocCd;
	}
	
	/**
	 * Column Info
	 * @return xptFlg
	 */
	public String getXptFlg() {
		return this.xptFlg;
	}
	
	/**
	 * Column Info
	 * @return arrDt
	 */
	public String getArrDt() {
		return this.arrDt;
	}
	
	/**
	 * Column Info
	 * @return transGubun
	 */
	public String getTransGubun() {
		return this.transGubun;
	}
	
	/**
	 * Column Info
	 * @return trspIssDt
	 */
	public String getTrspIssDt() {
		return this.trspIssDt;
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
	 * @return xptAcptDt
	 */
	public String getXptAcptDt() {
		return this.xptAcptDt;
	}
	
	/**
	 * Column Info
	 * @return trspIssTime
	 */
	public String getTrspIssTime() {
		return this.trspIssTime;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
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
	 * @return frtCltFlg
	 */
	public String getFrtCltFlg() {
		return this.frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return blCntrFlag
	 */
	public String getBlCntrFlag() {
		return this.blCntrFlag;
	}
	
	/**
	 * Column Info
	 * @return mjrIbdAuthDt
	 */
	public String getMjrIbdAuthDt() {
		return this.mjrIbdAuthDt;
	}
	
	/**
	 * Column Info
	 * @return cstmsPodCd
	 */
	public String getCstmsPodCd() {
		return this.cstmsPodCd;
	}
	
	/**
	 * Column Info
	 * @return arrTime
	 */
	public String getArrTime() {
		return this.arrTime;
	}
	
	/**
	 * Column Info
	 * @return xptDt
	 */
	public String getXptDt() {
		return this.xptDt;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspNo
	 */
	public String getIbdTrspNo() {
		return this.ibdTrspNo;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrCd
	 */
	public String getCstmsClrCd() {
		return this.cstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @return mjrIbdAuthTime
	 */
	public String getMjrIbdAuthTime() {
		return this.mjrIbdAuthTime;
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
	 * @return oblRdemFlg
	 */
	public String getOblRdemFlg() {
		return this.oblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @return arrFlg
	 */
	public String getArrFlg() {
		return this.arrFlg;
	}
	
	/**
	 * Column Info
	 * @return ibdTpCd
	 */
	public String getIbdTpCd() {
		return this.ibdTpCd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return avalDt
	 */
	public String getAvalDt() {
		return this.avalDt;
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
	 * @return xptAcptTime
	 */
	public String getXptAcptTime() {
		return this.xptAcptTime;
	}
	
	/**
	 * Column Info
	 * @return trspAuthDt
	 */
	public String getTrspAuthDt() {
		return this.trspAuthDt;
	}
	
	/**
	 * Column Info
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
	}
	
	/**
	 * Column Info
	 * @return xptTime
	 */
	public String getXptTime() {
		return this.xptTime;
	}
	
	/**
	 * Column Info
	 * @return trspAuthTime
	 */
	public String getTrspAuthTime() {
		return this.trspAuthTime;
	}
	
	/**
	 * Column Info
	 * @return pkupNo
	 */
	public String getPkupNo() {
		return this.pkupNo;
	}
	
	/**
	 * Column Info
	 * @return divInd
	 */
	public String getDivInd() {
		return this.divInd;
	}
	

	/**
	 * Column Info
	 * @param usaLstLocCd
	 */
	public void setUsaLstLocCd(String usaLstLocCd) {
		this.usaLstLocCd = usaLstLocCd;
	}
	
	/**
	 * Column Info
	 * @param xptFlg
	 */
	public void setXptFlg(String xptFlg) {
		this.xptFlg = xptFlg;
	}
	
	/**
	 * Column Info
	 * @param arrDt
	 */
	public void setArrDt(String arrDt) {
		this.arrDt = arrDt;
	}
	
	/**
	 * Column Info
	 * @param transGubun
	 */
	public void setTransGubun(String transGubun) {
		this.transGubun = transGubun;
	}
	
	/**
	 * Column Info
	 * @param trspIssDt
	 */
	public void setTrspIssDt(String trspIssDt) {
		this.trspIssDt = trspIssDt;
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
	 * @param xptAcptDt
	 */
	public void setXptAcptDt(String xptAcptDt) {
		this.xptAcptDt = xptAcptDt;
	}
	
	/**
	 * Column Info
	 * @param trspIssTime
	 */
	public void setTrspIssTime(String trspIssTime) {
		this.trspIssTime = trspIssTime;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
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
	 * @param frtCltFlg
	 */
	public void setFrtCltFlg(String frtCltFlg) {
		this.frtCltFlg = frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param blCntrFlag
	 */
	public void setBlCntrFlag(String blCntrFlag) {
		this.blCntrFlag = blCntrFlag;
	}
	
	/**
	 * Column Info
	 * @param mjrIbdAuthDt
	 */
	public void setMjrIbdAuthDt(String mjrIbdAuthDt) {
		this.mjrIbdAuthDt = mjrIbdAuthDt;
	}
	
	/**
	 * Column Info
	 * @param cstmsPodCd
	 */
	public void setCstmsPodCd(String cstmsPodCd) {
		this.cstmsPodCd = cstmsPodCd;
	}
	
	/**
	 * Column Info
	 * @param arrTime
	 */
	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}
	
	/**
	 * Column Info
	 * @param xptDt
	 */
	public void setXptDt(String xptDt) {
		this.xptDt = xptDt;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspNo
	 */
	public void setIbdTrspNo(String ibdTrspNo) {
		this.ibdTrspNo = ibdTrspNo;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrCd
	 */
	public void setCstmsClrCd(String cstmsClrCd) {
		this.cstmsClrCd = cstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @param mjrIbdAuthTime
	 */
	public void setMjrIbdAuthTime(String mjrIbdAuthTime) {
		this.mjrIbdAuthTime = mjrIbdAuthTime;
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
	 * @param oblRdemFlg
	 */
	public void setOblRdemFlg(String oblRdemFlg) {
		this.oblRdemFlg = oblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @param arrFlg
	 */
	public void setArrFlg(String arrFlg) {
		this.arrFlg = arrFlg;
	}
	
	/**
	 * Column Info
	 * @param ibdTpCd
	 */
	public void setIbdTpCd(String ibdTpCd) {
		this.ibdTpCd = ibdTpCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param avalDt
	 */
	public void setAvalDt(String avalDt) {
		this.avalDt = avalDt;
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
	 * @param xptAcptTime
	 */
	public void setXptAcptTime(String xptAcptTime) {
		this.xptAcptTime = xptAcptTime;
	}
	
	/**
	 * Column Info
	 * @param trspAuthDt
	 */
	public void setTrspAuthDt(String trspAuthDt) {
		this.trspAuthDt = trspAuthDt;
	}
	
	/**
	 * Column Info
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * Column Info
	 * @param xptTime
	 */
	public void setXptTime(String xptTime) {
		this.xptTime = xptTime;
	}
	
	/**
	 * Column Info
	 * @param trspAuthTime
	 */
	public void setTrspAuthTime(String trspAuthTime) {
		this.trspAuthTime = trspAuthTime;
	}
	
	/**
	 * Column Info
	 * @param pkupNo
	 */
	public void setPkupNo(String pkupNo) {
		this.pkupNo = pkupNo;
	}
	
	/**
	 * Column Info
	 * @param divInd
	 */
	public void setDivInd (String divInd) {
		this.divInd = divInd;
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
		setUsaLstLocCd(JSPUtil.getParameter(request, prefix + "usa_lst_loc_cd", ""));
		setXptFlg(JSPUtil.getParameter(request, prefix + "xpt_flg", ""));
		setArrDt(JSPUtil.getParameter(request, prefix + "arr_dt", ""));
		setTransGubun(JSPUtil.getParameter(request, prefix + "trans_gubun", ""));
		setTrspIssDt(JSPUtil.getParameter(request, prefix + "trsp_iss_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setXptAcptDt(JSPUtil.getParameter(request, prefix + "xpt_acpt_dt", ""));
		setTrspIssTime(JSPUtil.getParameter(request, prefix + "trsp_iss_time", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFrtCltFlg(JSPUtil.getParameter(request, prefix + "frt_clt_flg", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setBlCntrFlag(JSPUtil.getParameter(request, prefix + "bl_cntr_flag", ""));
		setMjrIbdAuthDt(JSPUtil.getParameter(request, prefix + "mjr_ibd_auth_dt", ""));
		setCstmsPodCd(JSPUtil.getParameter(request, prefix + "cstms_pod_cd", ""));
		setArrTime(JSPUtil.getParameter(request, prefix + "arr_time", ""));
		setXptDt(JSPUtil.getParameter(request, prefix + "xpt_dt", ""));
		setIbdTrspNo(JSPUtil.getParameter(request, prefix + "ibd_trsp_no", ""));
		setCstmsClrCd(JSPUtil.getParameter(request, prefix + "cstms_clr_cd", ""));
		setMjrIbdAuthTime(JSPUtil.getParameter(request, prefix + "mjr_ibd_auth_time", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setOblRdemFlg(JSPUtil.getParameter(request, prefix + "obl_rdem_flg", ""));
		setArrFlg(JSPUtil.getParameter(request, prefix + "arr_flg", ""));
		setIbdTpCd(JSPUtil.getParameter(request, prefix + "ibd_tp_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setAvalDt(JSPUtil.getParameter(request, prefix + "aval_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setXptAcptTime(JSPUtil.getParameter(request, prefix + "xpt_acpt_time", ""));
		setTrspAuthDt(JSPUtil.getParameter(request, prefix + "trsp_auth_dt", ""));
		setHubLocCd(JSPUtil.getParameter(request, prefix + "hub_loc_cd", ""));
		setXptTime(JSPUtil.getParameter(request, prefix + "xpt_time", ""));
		setTrspAuthTime(JSPUtil.getParameter(request, prefix + "trsp_auth_time", ""));
		setPkupNo(JSPUtil.getParameter(request, prefix + "pkup_no", ""));
		setDivInd(JSPUtil.getParameter(request, prefix + "divInd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaMibTransmitVO[]
	 */
	public UsaMibTransmitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaMibTransmitVO[]
	 */
	public UsaMibTransmitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaMibTransmitVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] usaLstLocCd = (JSPUtil.getParameter(request, prefix	+ "usa_lst_loc_cd", length));
			String[] xptFlg = (JSPUtil.getParameter(request, prefix	+ "xpt_flg", length));
			String[] arrDt = (JSPUtil.getParameter(request, prefix	+ "arr_dt", length));
			String[] transGubun = (JSPUtil.getParameter(request, prefix	+ "trans_gubun", length));
			String[] trspIssDt = (JSPUtil.getParameter(request, prefix	+ "trsp_iss_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] xptAcptDt = (JSPUtil.getParameter(request, prefix	+ "xpt_acpt_dt", length));
			String[] trspIssTime = (JSPUtil.getParameter(request, prefix	+ "trsp_iss_time", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] frtCltFlg = (JSPUtil.getParameter(request, prefix	+ "frt_clt_flg", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] blCntrFlag = (JSPUtil.getParameter(request, prefix	+ "bl_cntr_flag", length));
			String[] mjrIbdAuthDt = (JSPUtil.getParameter(request, prefix	+ "mjr_ibd_auth_dt", length));
			String[] cstmsPodCd = (JSPUtil.getParameter(request, prefix	+ "cstms_pod_cd", length));
			String[] arrTime = (JSPUtil.getParameter(request, prefix	+ "arr_time", length));
			String[] xptDt = (JSPUtil.getParameter(request, prefix	+ "xpt_dt", length));
			String[] ibdTrspNo = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_no", length));
			String[] cstmsClrCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_cd", length));
			String[] mjrIbdAuthTime = (JSPUtil.getParameter(request, prefix	+ "mjr_ibd_auth_time", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] oblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_flg", length));
			String[] arrFlg = (JSPUtil.getParameter(request, prefix	+ "arr_flg", length));
			String[] ibdTpCd = (JSPUtil.getParameter(request, prefix	+ "ibd_tp_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] avalDt = (JSPUtil.getParameter(request, prefix	+ "aval_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] xptAcptTime = (JSPUtil.getParameter(request, prefix	+ "xpt_acpt_time", length));
			String[] trspAuthDt = (JSPUtil.getParameter(request, prefix	+ "trsp_auth_dt", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			String[] xptTime = (JSPUtil.getParameter(request, prefix	+ "xpt_time", length));
			String[] trspAuthTime = (JSPUtil.getParameter(request, prefix	+ "trsp_auth_time", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] divInd = (JSPUtil.getParameter(request, prefix	+ "divInd", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaMibTransmitVO();
				if (usaLstLocCd[i] != null)
					model.setUsaLstLocCd(usaLstLocCd[i]);
				if (xptFlg[i] != null)
					model.setXptFlg(xptFlg[i]);
				if (arrDt[i] != null)
					model.setArrDt(arrDt[i]);
				if (transGubun[i] != null)
					model.setTransGubun(transGubun[i]);
				if (trspIssDt[i] != null)
					model.setTrspIssDt(trspIssDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (xptAcptDt[i] != null)
					model.setXptAcptDt(xptAcptDt[i]);
				if (trspIssTime[i] != null)
					model.setTrspIssTime(trspIssTime[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frtCltFlg[i] != null)
					model.setFrtCltFlg(frtCltFlg[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (blCntrFlag[i] != null)
					model.setBlCntrFlag(blCntrFlag[i]);
				if (mjrIbdAuthDt[i] != null)
					model.setMjrIbdAuthDt(mjrIbdAuthDt[i]);
				if (cstmsPodCd[i] != null)
					model.setCstmsPodCd(cstmsPodCd[i]);
				if (arrTime[i] != null)
					model.setArrTime(arrTime[i]);
				if (xptDt[i] != null)
					model.setXptDt(xptDt[i]);
				if (ibdTrspNo[i] != null)
					model.setIbdTrspNo(ibdTrspNo[i]);
				if (cstmsClrCd[i] != null)
					model.setCstmsClrCd(cstmsClrCd[i]);
				if (mjrIbdAuthTime[i] != null)
					model.setMjrIbdAuthTime(mjrIbdAuthTime[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (oblRdemFlg[i] != null)
					model.setOblRdemFlg(oblRdemFlg[i]);
				if (arrFlg[i] != null)
					model.setArrFlg(arrFlg[i]);
				if (ibdTpCd[i] != null)
					model.setIbdTpCd(ibdTpCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (avalDt[i] != null)
					model.setAvalDt(avalDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (xptAcptTime[i] != null)
					model.setXptAcptTime(xptAcptTime[i]);
				if (trspAuthDt[i] != null)
					model.setTrspAuthDt(trspAuthDt[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				if (xptTime[i] != null)
					model.setXptTime(xptTime[i]);
				if (trspAuthTime[i] != null)
					model.setTrspAuthTime(trspAuthTime[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (divInd[i] != null)
					model.setDivInd(divInd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaMibTransmitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaMibTransmitVO[]
	 */
	public UsaMibTransmitVO[] getUsaMibTransmitVOs(){
		UsaMibTransmitVO[] vos = (UsaMibTransmitVO[])models.toArray(new UsaMibTransmitVO[models.size()]);
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
		this.usaLstLocCd = this.usaLstLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptFlg = this.xptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDt = this.arrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transGubun = this.transGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspIssDt = this.trspIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptAcptDt = this.xptAcptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspIssTime = this.trspIssTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltFlg = this.frtCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCntrFlag = this.blCntrFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mjrIbdAuthDt = this.mjrIbdAuthDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPodCd = this.cstmsPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrTime = this.arrTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptDt = this.xptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspNo = this.ibdTrspNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrCd = this.cstmsClrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mjrIbdAuthTime = this.mjrIbdAuthTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemFlg = this.oblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrFlg = this.arrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTpCd = this.ibdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avalDt = this.avalDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptAcptTime = this.xptAcptTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAuthDt = this.trspAuthDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptTime = this.xptTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAuthTime = this.trspAuthTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divInd = this.divInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
