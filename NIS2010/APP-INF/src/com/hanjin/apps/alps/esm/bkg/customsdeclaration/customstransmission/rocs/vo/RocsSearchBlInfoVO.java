/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RocsSearchBlInfoVO.java
*@FileTitle : RocsSearchBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.rocs.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RocsSearchBlInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RocsSearchBlInfoVO> models = new ArrayList<RocsSearchBlInfoVO>();
	
	/* Column Info */
	private String cneeAddr = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String shprAddrStr = null;
	/* Column Info */
	private String lloydCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mrnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ntfyAddrCntry = null;
	/* Column Info */
	private String wgt = null;
	/* Column Info */
	private String carrierId = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String carrier = null;
	/* Column Info */
	private String shprAddrCntry = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String shprAddrPlc = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String senderId = null;
	/* Column Info */
	private String cneeAddrPlc = null;
	/* Column Info */
	private String polAtd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String flag = null;
	/* Column Info */
	private String ntfyName = null;
	/* Column Info */
	private String wgtU = null;
	/* Column Info */
	private String shprEori = null;
	/* Column Info */
	private String shprName = null;
	/* Column Info */
	private String ntfyAddrStr = null;
	/* Column Info */
	private String frtOpt = null;
	/* Column Info */
	private String ssRefNo = null;
	/* Column Info */
	private String t1Ind = null;
	/* Column Info */
	private String ntfyAddrPlc = null;
	/* Column Info */
	private String berthCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cneeAddrStr = null;
	/* Column Info */
	private String shprAddr = null;
	/* Column Info */
	private String ntfyEori = null;
	/* Column Info */
	private String ntfyAddrCity = null;
	/* Column Info */
	private String senderCd = null;
	/* Column Info */
	private String ntfyAddr = null;
	/* Column Info */
	private String vslCallRefNo = null;
	/* Column Info */
	private String cneeAddrCntry = null;
	/* Column Info */
	private String post = null;
	/* Column Info */
	private String cneeEori = null;
	/* Column Info */
	private String cneeName = null;
	/* Column Info */
	private String scac = null;
	/* Column Info */
	private String shprAddrCity = null;
	/* Column Info */
	private String pre = null;
	/* Column Info */
	private String headCd = null;
	/* Column Info */
	private String cneeAddrCity = null;
	/* Column Info */
	private String podEta = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RocsSearchBlInfoVO() {}

	public RocsSearchBlInfoVO(String ibflag, String pagerows, String headCd, String vvd, String flag, String wgt, String wgtU, String frtOpt, String blNo, String mrnNo, String t1Ind, String scac, String lloydCd, String pod, String berthCd, String podEta, String pol, String polAtd, String pre, String post, String por, String delCd, String ssRefNo, String senderId, String senderCd, String carrierId, String carrier, String shprEori, String shprName, String shprAddrStr, String shprAddrCity, String shprAddrPlc, String shprAddrCntry, String shprAddr, String cneeEori, String cneeName, String cneeAddrStr, String cneeAddrCity, String cneeAddrPlc, String cneeAddrCntry, String cneeAddr, String ntfyEori, String ntfyName, String ntfyAddrStr, String ntfyAddrCity, String ntfyAddrPlc, String ntfyAddrCntry, String ntfyAddr, String vslCallRefNo, String bkgNo) {
		this.cneeAddr = cneeAddr;
		this.por = por;
		this.shprAddrStr = shprAddrStr;
		this.lloydCd = lloydCd;
		this.blNo = blNo;
		this.mrnNo = mrnNo;
		this.pagerows = pagerows;
		this.ntfyAddrCntry = ntfyAddrCntry;
		this.wgt = wgt;
		this.carrierId = carrierId;
		this.pol = pol;
		this.carrier = carrier;
		this.shprAddrCntry = shprAddrCntry;
		this.pod = pod;
		this.shprAddrPlc = shprAddrPlc;
		this.delCd = delCd;
		this.senderId = senderId;
		this.cneeAddrPlc = cneeAddrPlc;
		this.polAtd = polAtd;
		this.vvd = vvd;
		this.bkgNo = bkgNo;
		this.flag = flag;
		this.ntfyName = ntfyName;
		this.wgtU = wgtU;
		this.shprEori = shprEori;
		this.shprName = shprName;
		this.ntfyAddrStr = ntfyAddrStr;
		this.frtOpt = frtOpt;
		this.ssRefNo = ssRefNo;
		this.t1Ind = t1Ind;
		this.ntfyAddrPlc = ntfyAddrPlc;
		this.berthCd = berthCd;
		this.ibflag = ibflag;
		this.cneeAddrStr = cneeAddrStr;
		this.shprAddr = shprAddr;
		this.ntfyEori = ntfyEori;
		this.ntfyAddrCity = ntfyAddrCity;
		this.senderCd = senderCd;
		this.ntfyAddr = ntfyAddr;
		this.vslCallRefNo = vslCallRefNo;
		this.cneeAddrCntry = cneeAddrCntry;
		this.post = post;
		this.cneeEori = cneeEori;
		this.cneeName = cneeName;
		this.scac = scac;
		this.shprAddrCity = shprAddrCity;
		this.pre = pre;
		this.headCd = headCd;
		this.cneeAddrCity = cneeAddrCity;
		this.podEta = podEta;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnee_addr", getCneeAddr());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("shpr_addr_str", getShprAddrStr());
		this.hashColumns.put("lloyd_cd", getLloydCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ntfy_addr_cntry", getNtfyAddrCntry());
		this.hashColumns.put("wgt", getWgt());
		this.hashColumns.put("carrier_id", getCarrierId());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("carrier", getCarrier());
		this.hashColumns.put("shpr_addr_cntry", getShprAddrCntry());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("shpr_addr_plc", getShprAddrPlc());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("sender_id", getSenderId());
		this.hashColumns.put("cnee_addr_plc", getCneeAddrPlc());
		this.hashColumns.put("pol_atd", getPolAtd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("flag", getFlag());
		this.hashColumns.put("ntfy_name", getNtfyName());
		this.hashColumns.put("wgt_u", getWgtU());
		this.hashColumns.put("shpr_eori", getShprEori());
		this.hashColumns.put("shpr_name", getShprName());
		this.hashColumns.put("ntfy_addr_str", getNtfyAddrStr());
		this.hashColumns.put("frt_opt", getFrtOpt());
		this.hashColumns.put("ss_ref_no", getSsRefNo());
		this.hashColumns.put("t1_ind", getT1Ind());
		this.hashColumns.put("ntfy_addr_plc", getNtfyAddrPlc());
		this.hashColumns.put("berth_cd", getBerthCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnee_addr_str", getCneeAddrStr());
		this.hashColumns.put("shpr_addr", getShprAddr());
		this.hashColumns.put("ntfy_eori", getNtfyEori());
		this.hashColumns.put("ntfy_addr_city", getNtfyAddrCity());
		this.hashColumns.put("sender_cd", getSenderCd());
		this.hashColumns.put("ntfy_addr", getNtfyAddr());
		this.hashColumns.put("vsl_call_ref_no", getVslCallRefNo());
		this.hashColumns.put("cnee_addr_cntry", getCneeAddrCntry());
		this.hashColumns.put("post", getPost());
		this.hashColumns.put("cnee_eori", getCneeEori());
		this.hashColumns.put("cnee_name", getCneeName());
		this.hashColumns.put("scac", getScac());
		this.hashColumns.put("shpr_addr_city", getShprAddrCity());
		this.hashColumns.put("pre", getPre());
		this.hashColumns.put("head_cd", getHeadCd());
		this.hashColumns.put("cnee_addr_city", getCneeAddrCity());
		this.hashColumns.put("pod_eta", getPodEta());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnee_addr", "cneeAddr");
		this.hashFields.put("por", "por");
		this.hashFields.put("shpr_addr_str", "shprAddrStr");
		this.hashFields.put("lloyd_cd", "lloydCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ntfy_addr_cntry", "ntfyAddrCntry");
		this.hashFields.put("wgt", "wgt");
		this.hashFields.put("carrier_id", "carrierId");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("carrier", "carrier");
		this.hashFields.put("shpr_addr_cntry", "shprAddrCntry");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("shpr_addr_plc", "shprAddrPlc");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("sender_id", "senderId");
		this.hashFields.put("cnee_addr_plc", "cneeAddrPlc");
		this.hashFields.put("pol_atd", "polAtd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("flag", "flag");
		this.hashFields.put("ntfy_name", "ntfyName");
		this.hashFields.put("wgt_u", "wgtU");
		this.hashFields.put("shpr_eori", "shprEori");
		this.hashFields.put("shpr_name", "shprName");
		this.hashFields.put("ntfy_addr_str", "ntfyAddrStr");
		this.hashFields.put("frt_opt", "frtOpt");
		this.hashFields.put("ss_ref_no", "ssRefNo");
		this.hashFields.put("t1_ind", "t1Ind");
		this.hashFields.put("ntfy_addr_plc", "ntfyAddrPlc");
		this.hashFields.put("berth_cd", "berthCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnee_addr_str", "cneeAddrStr");
		this.hashFields.put("shpr_addr", "shprAddr");
		this.hashFields.put("ntfy_eori", "ntfyEori");
		this.hashFields.put("ntfy_addr_city", "ntfyAddrCity");
		this.hashFields.put("sender_cd", "senderCd");
		this.hashFields.put("ntfy_addr", "ntfyAddr");
		this.hashFields.put("vsl_call_ref_no", "vslCallRefNo");
		this.hashFields.put("cnee_addr_cntry", "cneeAddrCntry");
		this.hashFields.put("post", "post");
		this.hashFields.put("cnee_eori", "cneeEori");
		this.hashFields.put("cnee_name", "cneeName");
		this.hashFields.put("scac", "scac");
		this.hashFields.put("shpr_addr_city", "shprAddrCity");
		this.hashFields.put("pre", "pre");
		this.hashFields.put("head_cd", "headCd");
		this.hashFields.put("cnee_addr_city", "cneeAddrCity");
		this.hashFields.put("pod_eta", "podEta");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cneeAddr
	 */
	public String getCneeAddr() {
		return this.cneeAddr;
	}
	
	/**
	 * Column Info
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}
	
	/**
	 * Column Info
	 * @return shprAddrStr
	 */
	public String getShprAddrStr() {
		return this.shprAddrStr;
	}
	
	/**
	 * Column Info
	 * @return lloydCd
	 */
	public String getLloydCd() {
		return this.lloydCd;
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
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
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
	 * @return ntfyAddrCntry
	 */
	public String getNtfyAddrCntry() {
		return this.ntfyAddrCntry;
	}
	
	/**
	 * Column Info
	 * @return wgt
	 */
	public String getWgt() {
		return this.wgt;
	}
	
	/**
	 * Column Info
	 * @return carrierId
	 */
	public String getCarrierId() {
		return this.carrierId;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return carrier
	 */
	public String getCarrier() {
		return this.carrier;
	}
	
	/**
	 * Column Info
	 * @return shprAddrCntry
	 */
	public String getShprAddrCntry() {
		return this.shprAddrCntry;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return shprAddrPlc
	 */
	public String getShprAddrPlc() {
		return this.shprAddrPlc;
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
	 * @return senderId
	 */
	public String getSenderId() {
		return this.senderId;
	}
	
	/**
	 * Column Info
	 * @return cneeAddrPlc
	 */
	public String getCneeAddrPlc() {
		return this.cneeAddrPlc;
	}
	
	/**
	 * Column Info
	 * @return polAtd
	 */
	public String getPolAtd() {
		return this.polAtd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return flag
	 */
	public String getFlag() {
		return this.flag;
	}
	
	/**
	 * Column Info
	 * @return ntfyName
	 */
	public String getNtfyName() {
		return this.ntfyName;
	}
	
	/**
	 * Column Info
	 * @return wgtU
	 */
	public String getWgtU() {
		return this.wgtU;
	}
	
	/**
	 * Column Info
	 * @return shprEori
	 */
	public String getShprEori() {
		return this.shprEori;
	}
	
	/**
	 * Column Info
	 * @return shprName
	 */
	public String getShprName() {
		return this.shprName;
	}
	
	/**
	 * Column Info
	 * @return ntfyAddrStr
	 */
	public String getNtfyAddrStr() {
		return this.ntfyAddrStr;
	}
	
	/**
	 * Column Info
	 * @return frtOpt
	 */
	public String getFrtOpt() {
		return this.frtOpt;
	}
	
	/**
	 * Column Info
	 * @return ssRefNo
	 */
	public String getSsRefNo() {
		return this.ssRefNo;
	}
	
	/**
	 * Column Info
	 * @return t1Ind
	 */
	public String getT1Ind() {
		return this.t1Ind;
	}
	
	/**
	 * Column Info
	 * @return ntfyAddrPlc
	 */
	public String getNtfyAddrPlc() {
		return this.ntfyAddrPlc;
	}
	
	/**
	 * Column Info
	 * @return berthCd
	 */
	public String getBerthCd() {
		return this.berthCd;
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
	 * @return cneeAddrStr
	 */
	public String getCneeAddrStr() {
		return this.cneeAddrStr;
	}
	
	/**
	 * Column Info
	 * @return shprAddr
	 */
	public String getShprAddr() {
		return this.shprAddr;
	}
	
	/**
	 * Column Info
	 * @return ntfyEori
	 */
	public String getNtfyEori() {
		return this.ntfyEori;
	}
	
	/**
	 * Column Info
	 * @return ntfyAddrCity
	 */
	public String getNtfyAddrCity() {
		return this.ntfyAddrCity;
	}
	
	/**
	 * Column Info
	 * @return senderCd
	 */
	public String getSenderCd() {
		return this.senderCd;
	}
	
	/**
	 * Column Info
	 * @return ntfyAddr
	 */
	public String getNtfyAddr() {
		return this.ntfyAddr;
	}
	
	/**
	 * Column Info
	 * @return vslCallRefNo
	 */
	public String getVslCallRefNo() {
		return this.vslCallRefNo;
	}
	
	/**
	 * Column Info
	 * @return cneeAddrCntry
	 */
	public String getCneeAddrCntry() {
		return this.cneeAddrCntry;
	}
	
	/**
	 * Column Info
	 * @return post
	 */
	public String getPost() {
		return this.post;
	}
	
	/**
	 * Column Info
	 * @return cneeEori
	 */
	public String getCneeEori() {
		return this.cneeEori;
	}
	
	/**
	 * Column Info
	 * @return cneeName
	 */
	public String getCneeName() {
		return this.cneeName;
	}
	
	/**
	 * Column Info
	 * @return scac
	 */
	public String getScac() {
		return this.scac;
	}
	
	/**
	 * Column Info
	 * @return shprAddrCity
	 */
	public String getShprAddrCity() {
		return this.shprAddrCity;
	}
	
	/**
	 * Column Info
	 * @return pre
	 */
	public String getPre() {
		return this.pre;
	}
	
	/**
	 * Column Info
	 * @return headCd
	 */
	public String getHeadCd() {
		return this.headCd;
	}
	
	/**
	 * Column Info
	 * @return cneeAddrCity
	 */
	public String getCneeAddrCity() {
		return this.cneeAddrCity;
	}
	
	/**
	 * Column Info
	 * @return podEta
	 */
	public String getPodEta() {
		return this.podEta;
	}
	

	/**
	 * Column Info
	 * @param cneeAddr
	 */
	public void setCneeAddr(String cneeAddr) {
		this.cneeAddr = cneeAddr;
	}
	
	/**
	 * Column Info
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}
	
	/**
	 * Column Info
	 * @param shprAddrStr
	 */
	public void setShprAddrStr(String shprAddrStr) {
		this.shprAddrStr = shprAddrStr;
	}
	
	/**
	 * Column Info
	 * @param lloydCd
	 */
	public void setLloydCd(String lloydCd) {
		this.lloydCd = lloydCd;
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
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
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
	 * @param ntfyAddrCntry
	 */
	public void setNtfyAddrCntry(String ntfyAddrCntry) {
		this.ntfyAddrCntry = ntfyAddrCntry;
	}
	
	/**
	 * Column Info
	 * @param wgt
	 */
	public void setWgt(String wgt) {
		this.wgt = wgt;
	}
	
	/**
	 * Column Info
	 * @param carrierId
	 */
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param carrier
	 */
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	
	/**
	 * Column Info
	 * @param shprAddrCntry
	 */
	public void setShprAddrCntry(String shprAddrCntry) {
		this.shprAddrCntry = shprAddrCntry;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param shprAddrPlc
	 */
	public void setShprAddrPlc(String shprAddrPlc) {
		this.shprAddrPlc = shprAddrPlc;
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
	 * @param senderId
	 */
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	
	/**
	 * Column Info
	 * @param cneeAddrPlc
	 */
	public void setCneeAddrPlc(String cneeAddrPlc) {
		this.cneeAddrPlc = cneeAddrPlc;
	}
	
	/**
	 * Column Info
	 * @param polAtd
	 */
	public void setPolAtd(String polAtd) {
		this.polAtd = polAtd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	/**
	 * Column Info
	 * @param ntfyName
	 */
	public void setNtfyName(String ntfyName) {
		this.ntfyName = ntfyName;
	}
	
	/**
	 * Column Info
	 * @param wgtU
	 */
	public void setWgtU(String wgtU) {
		this.wgtU = wgtU;
	}
	
	/**
	 * Column Info
	 * @param shprEori
	 */
	public void setShprEori(String shprEori) {
		this.shprEori = shprEori;
	}
	
	/**
	 * Column Info
	 * @param shprName
	 */
	public void setShprName(String shprName) {
		this.shprName = shprName;
	}
	
	/**
	 * Column Info
	 * @param ntfyAddrStr
	 */
	public void setNtfyAddrStr(String ntfyAddrStr) {
		this.ntfyAddrStr = ntfyAddrStr;
	}
	
	/**
	 * Column Info
	 * @param frtOpt
	 */
	public void setFrtOpt(String frtOpt) {
		this.frtOpt = frtOpt;
	}
	
	/**
	 * Column Info
	 * @param ssRefNo
	 */
	public void setSsRefNo(String ssRefNo) {
		this.ssRefNo = ssRefNo;
	}
	
	/**
	 * Column Info
	 * @param t1Ind
	 */
	public void setT1Ind(String t1Ind) {
		this.t1Ind = t1Ind;
	}
	
	/**
	 * Column Info
	 * @param ntfyAddrPlc
	 */
	public void setNtfyAddrPlc(String ntfyAddrPlc) {
		this.ntfyAddrPlc = ntfyAddrPlc;
	}
	
	/**
	 * Column Info
	 * @param berthCd
	 */
	public void setBerthCd(String berthCd) {
		this.berthCd = berthCd;
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
	 * @param cneeAddrStr
	 */
	public void setCneeAddrStr(String cneeAddrStr) {
		this.cneeAddrStr = cneeAddrStr;
	}
	
	/**
	 * Column Info
	 * @param shprAddr
	 */
	public void setShprAddr(String shprAddr) {
		this.shprAddr = shprAddr;
	}
	
	/**
	 * Column Info
	 * @param ntfyEori
	 */
	public void setNtfyEori(String ntfyEori) {
		this.ntfyEori = ntfyEori;
	}
	
	/**
	 * Column Info
	 * @param ntfyAddrCity
	 */
	public void setNtfyAddrCity(String ntfyAddrCity) {
		this.ntfyAddrCity = ntfyAddrCity;
	}
	
	/**
	 * Column Info
	 * @param senderCd
	 */
	public void setSenderCd(String senderCd) {
		this.senderCd = senderCd;
	}
	
	/**
	 * Column Info
	 * @param ntfyAddr
	 */
	public void setNtfyAddr(String ntfyAddr) {
		this.ntfyAddr = ntfyAddr;
	}
	
	/**
	 * Column Info
	 * @param vslCallRefNo
	 */
	public void setVslCallRefNo(String vslCallRefNo) {
		this.vslCallRefNo = vslCallRefNo;
	}
	
	/**
	 * Column Info
	 * @param cneeAddrCntry
	 */
	public void setCneeAddrCntry(String cneeAddrCntry) {
		this.cneeAddrCntry = cneeAddrCntry;
	}
	
	/**
	 * Column Info
	 * @param post
	 */
	public void setPost(String post) {
		this.post = post;
	}
	
	/**
	 * Column Info
	 * @param cneeEori
	 */
	public void setCneeEori(String cneeEori) {
		this.cneeEori = cneeEori;
	}
	
	/**
	 * Column Info
	 * @param cneeName
	 */
	public void setCneeName(String cneeName) {
		this.cneeName = cneeName;
	}
	
	/**
	 * Column Info
	 * @param scac
	 */
	public void setScac(String scac) {
		this.scac = scac;
	}
	
	/**
	 * Column Info
	 * @param shprAddrCity
	 */
	public void setShprAddrCity(String shprAddrCity) {
		this.shprAddrCity = shprAddrCity;
	}
	
	/**
	 * Column Info
	 * @param pre
	 */
	public void setPre(String pre) {
		this.pre = pre;
	}
	
	/**
	 * Column Info
	 * @param headCd
	 */
	public void setHeadCd(String headCd) {
		this.headCd = headCd;
	}
	
	/**
	 * Column Info
	 * @param cneeAddrCity
	 */
	public void setCneeAddrCity(String cneeAddrCity) {
		this.cneeAddrCity = cneeAddrCity;
	}
	
	/**
	 * Column Info
	 * @param podEta
	 */
	public void setPodEta(String podEta) {
		this.podEta = podEta;
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
		setCneeAddr(JSPUtil.getParameter(request, prefix + "cnee_addr", ""));
		setPor(JSPUtil.getParameter(request, prefix + "por", ""));
		setShprAddrStr(JSPUtil.getParameter(request, prefix + "shpr_addr_str", ""));
		setLloydCd(JSPUtil.getParameter(request, prefix + "lloyd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setMrnNo(JSPUtil.getParameter(request, prefix + "mrn_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNtfyAddrCntry(JSPUtil.getParameter(request, prefix + "ntfy_addr_cntry", ""));
		setWgt(JSPUtil.getParameter(request, prefix + "wgt", ""));
		setCarrierId(JSPUtil.getParameter(request, prefix + "carrier_id", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setCarrier(JSPUtil.getParameter(request, prefix + "carrier", ""));
		setShprAddrCntry(JSPUtil.getParameter(request, prefix + "shpr_addr_cntry", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setShprAddrPlc(JSPUtil.getParameter(request, prefix + "shpr_addr_plc", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSenderId(JSPUtil.getParameter(request, prefix + "sender_id", ""));
		setCneeAddrPlc(JSPUtil.getParameter(request, prefix + "cnee_addr_plc", ""));
		setPolAtd(JSPUtil.getParameter(request, prefix + "pol_atd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setFlag(JSPUtil.getParameter(request, prefix + "flag", ""));
		setNtfyName(JSPUtil.getParameter(request, prefix + "ntfy_name", ""));
		setWgtU(JSPUtil.getParameter(request, prefix + "wgt_u", ""));
		setShprEori(JSPUtil.getParameter(request, prefix + "shpr_eori", ""));
		setShprName(JSPUtil.getParameter(request, prefix + "shpr_name", ""));
		setNtfyAddrStr(JSPUtil.getParameter(request, prefix + "ntfy_addr_str", ""));
		setFrtOpt(JSPUtil.getParameter(request, prefix + "frt_opt", ""));
		setSsRefNo(JSPUtil.getParameter(request, prefix + "ss_ref_no", ""));
		setT1Ind(JSPUtil.getParameter(request, prefix + "t1_ind", ""));
		setNtfyAddrPlc(JSPUtil.getParameter(request, prefix + "ntfy_addr_plc", ""));
		setBerthCd(JSPUtil.getParameter(request, prefix + "berth_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCneeAddrStr(JSPUtil.getParameter(request, prefix + "cnee_addr_str", ""));
		setShprAddr(JSPUtil.getParameter(request, prefix + "shpr_addr", ""));
		setNtfyEori(JSPUtil.getParameter(request, prefix + "ntfy_eori", ""));
		setNtfyAddrCity(JSPUtil.getParameter(request, prefix + "ntfy_addr_city", ""));
		setSenderCd(JSPUtil.getParameter(request, prefix + "sender_cd", ""));
		setNtfyAddr(JSPUtil.getParameter(request, prefix + "ntfy_addr", ""));
		setVslCallRefNo(JSPUtil.getParameter(request, prefix + "vsl_call_ref_no", ""));
		setCneeAddrCntry(JSPUtil.getParameter(request, prefix + "cnee_addr_cntry", ""));
		setPost(JSPUtil.getParameter(request, prefix + "post", ""));
		setCneeEori(JSPUtil.getParameter(request, prefix + "cnee_eori", ""));
		setCneeName(JSPUtil.getParameter(request, prefix + "cnee_name", ""));
		setScac(JSPUtil.getParameter(request, prefix + "scac", ""));
		setShprAddrCity(JSPUtil.getParameter(request, prefix + "shpr_addr_city", ""));
		setPre(JSPUtil.getParameter(request, prefix + "pre", ""));
		setHeadCd(JSPUtil.getParameter(request, prefix + "head_cd", ""));
		setCneeAddrCity(JSPUtil.getParameter(request, prefix + "cnee_addr_city", ""));
		setPodEta(JSPUtil.getParameter(request, prefix + "pod_eta", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RocsSearchBlInfoVO[]
	 */
	public RocsSearchBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RocsSearchBlInfoVO[]
	 */
	public RocsSearchBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RocsSearchBlInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cneeAddr = (JSPUtil.getParameter(request, prefix	+ "cnee_addr", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] shprAddrStr = (JSPUtil.getParameter(request, prefix	+ "shpr_addr_str", length));
			String[] lloydCd = (JSPUtil.getParameter(request, prefix	+ "lloyd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ntfyAddrCntry = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr_cntry", length));
			String[] wgt = (JSPUtil.getParameter(request, prefix	+ "wgt", length));
			String[] carrierId = (JSPUtil.getParameter(request, prefix	+ "carrier_id", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] carrier = (JSPUtil.getParameter(request, prefix	+ "carrier", length));
			String[] shprAddrCntry = (JSPUtil.getParameter(request, prefix	+ "shpr_addr_cntry", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] shprAddrPlc = (JSPUtil.getParameter(request, prefix	+ "shpr_addr_plc", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] senderId = (JSPUtil.getParameter(request, prefix	+ "sender_id", length));
			String[] cneeAddrPlc = (JSPUtil.getParameter(request, prefix	+ "cnee_addr_plc", length));
			String[] polAtd = (JSPUtil.getParameter(request, prefix	+ "pol_atd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] flag = (JSPUtil.getParameter(request, prefix	+ "flag", length));
			String[] ntfyName = (JSPUtil.getParameter(request, prefix	+ "ntfy_name", length));
			String[] wgtU = (JSPUtil.getParameter(request, prefix	+ "wgt_u", length));
			String[] shprEori = (JSPUtil.getParameter(request, prefix	+ "shpr_eori", length));
			String[] shprName = (JSPUtil.getParameter(request, prefix	+ "shpr_name", length));
			String[] ntfyAddrStr = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr_str", length));
			String[] frtOpt = (JSPUtil.getParameter(request, prefix	+ "frt_opt", length));
			String[] ssRefNo = (JSPUtil.getParameter(request, prefix	+ "ss_ref_no", length));
			String[] t1Ind = (JSPUtil.getParameter(request, prefix	+ "t1_ind", length));
			String[] ntfyAddrPlc = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr_plc", length));
			String[] berthCd = (JSPUtil.getParameter(request, prefix	+ "berth_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cneeAddrStr = (JSPUtil.getParameter(request, prefix	+ "cnee_addr_str", length));
			String[] shprAddr = (JSPUtil.getParameter(request, prefix	+ "shpr_addr", length));
			String[] ntfyEori = (JSPUtil.getParameter(request, prefix	+ "ntfy_eori", length));
			String[] ntfyAddrCity = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr_city", length));
			String[] senderCd = (JSPUtil.getParameter(request, prefix	+ "sender_cd", length));
			String[] ntfyAddr = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr", length));
			String[] vslCallRefNo = (JSPUtil.getParameter(request, prefix	+ "vsl_call_ref_no", length));
			String[] cneeAddrCntry = (JSPUtil.getParameter(request, prefix	+ "cnee_addr_cntry", length));
			String[] post = (JSPUtil.getParameter(request, prefix	+ "post", length));
			String[] cneeEori = (JSPUtil.getParameter(request, prefix	+ "cnee_eori", length));
			String[] cneeName = (JSPUtil.getParameter(request, prefix	+ "cnee_name", length));
			String[] scac = (JSPUtil.getParameter(request, prefix	+ "scac", length));
			String[] shprAddrCity = (JSPUtil.getParameter(request, prefix	+ "shpr_addr_city", length));
			String[] pre = (JSPUtil.getParameter(request, prefix	+ "pre", length));
			String[] headCd = (JSPUtil.getParameter(request, prefix	+ "head_cd", length));
			String[] cneeAddrCity = (JSPUtil.getParameter(request, prefix	+ "cnee_addr_city", length));
			String[] podEta = (JSPUtil.getParameter(request, prefix	+ "pod_eta", length));
			
			for (int i = 0; i < length; i++) {
				model = new RocsSearchBlInfoVO();
				if (cneeAddr[i] != null)
					model.setCneeAddr(cneeAddr[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (shprAddrStr[i] != null)
					model.setShprAddrStr(shprAddrStr[i]);
				if (lloydCd[i] != null)
					model.setLloydCd(lloydCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ntfyAddrCntry[i] != null)
					model.setNtfyAddrCntry(ntfyAddrCntry[i]);
				if (wgt[i] != null)
					model.setWgt(wgt[i]);
				if (carrierId[i] != null)
					model.setCarrierId(carrierId[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (carrier[i] != null)
					model.setCarrier(carrier[i]);
				if (shprAddrCntry[i] != null)
					model.setShprAddrCntry(shprAddrCntry[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (shprAddrPlc[i] != null)
					model.setShprAddrPlc(shprAddrPlc[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (senderId[i] != null)
					model.setSenderId(senderId[i]);
				if (cneeAddrPlc[i] != null)
					model.setCneeAddrPlc(cneeAddrPlc[i]);
				if (polAtd[i] != null)
					model.setPolAtd(polAtd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (flag[i] != null)
					model.setFlag(flag[i]);
				if (ntfyName[i] != null)
					model.setNtfyName(ntfyName[i]);
				if (wgtU[i] != null)
					model.setWgtU(wgtU[i]);
				if (shprEori[i] != null)
					model.setShprEori(shprEori[i]);
				if (shprName[i] != null)
					model.setShprName(shprName[i]);
				if (ntfyAddrStr[i] != null)
					model.setNtfyAddrStr(ntfyAddrStr[i]);
				if (frtOpt[i] != null)
					model.setFrtOpt(frtOpt[i]);
				if (ssRefNo[i] != null)
					model.setSsRefNo(ssRefNo[i]);
				if (t1Ind[i] != null)
					model.setT1Ind(t1Ind[i]);
				if (ntfyAddrPlc[i] != null)
					model.setNtfyAddrPlc(ntfyAddrPlc[i]);
				if (berthCd[i] != null)
					model.setBerthCd(berthCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cneeAddrStr[i] != null)
					model.setCneeAddrStr(cneeAddrStr[i]);
				if (shprAddr[i] != null)
					model.setShprAddr(shprAddr[i]);
				if (ntfyEori[i] != null)
					model.setNtfyEori(ntfyEori[i]);
				if (ntfyAddrCity[i] != null)
					model.setNtfyAddrCity(ntfyAddrCity[i]);
				if (senderCd[i] != null)
					model.setSenderCd(senderCd[i]);
				if (ntfyAddr[i] != null)
					model.setNtfyAddr(ntfyAddr[i]);
				if (vslCallRefNo[i] != null)
					model.setVslCallRefNo(vslCallRefNo[i]);
				if (cneeAddrCntry[i] != null)
					model.setCneeAddrCntry(cneeAddrCntry[i]);
				if (post[i] != null)
					model.setPost(post[i]);
				if (cneeEori[i] != null)
					model.setCneeEori(cneeEori[i]);
				if (cneeName[i] != null)
					model.setCneeName(cneeName[i]);
				if (scac[i] != null)
					model.setScac(scac[i]);
				if (shprAddrCity[i] != null)
					model.setShprAddrCity(shprAddrCity[i]);
				if (pre[i] != null)
					model.setPre(pre[i]);
				if (headCd[i] != null)
					model.setHeadCd(headCd[i]);
				if (cneeAddrCity[i] != null)
					model.setCneeAddrCity(cneeAddrCity[i]);
				if (podEta[i] != null)
					model.setPodEta(podEta[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRocsSearchBlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RocsSearchBlInfoVO[]
	 */
	public RocsSearchBlInfoVO[] getRocsSearchBlInfoVOs(){
		RocsSearchBlInfoVO[] vos = (RocsSearchBlInfoVO[])models.toArray(new RocsSearchBlInfoVO[models.size()]);
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
		this.cneeAddr = this.cneeAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddrStr = this.shprAddrStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydCd = this.lloydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddrCntry = this.ntfyAddrCntry .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt = this.wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carrierId = this.carrierId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carrier = this.carrier .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddrCntry = this.shprAddrCntry .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddrPlc = this.shprAddrPlc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderId = this.senderId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddrPlc = this.cneeAddrPlc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAtd = this.polAtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flag = this.flag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyName = this.ntfyName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtU = this.wgtU .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprEori = this.shprEori .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprName = this.shprName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddrStr = this.ntfyAddrStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtOpt = this.frtOpt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ssRefNo = this.ssRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t1Ind = this.t1Ind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddrPlc = this.ntfyAddrPlc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.berthCd = this.berthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddrStr = this.cneeAddrStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr = this.shprAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyEori = this.ntfyEori .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddrCity = this.ntfyAddrCity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderCd = this.senderCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr = this.ntfyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallRefNo = this.vslCallRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddrCntry = this.cneeAddrCntry .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.post = this.post .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeEori = this.cneeEori .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeName = this.cneeName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scac = this.scac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddrCity = this.shprAddrCity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre = this.pre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.headCd = this.headCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddrCity = this.cneeAddrCity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEta = this.podEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
