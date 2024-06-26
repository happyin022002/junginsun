/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EurManifestListCondVO.java
*@FileTitle : EurManifestListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.09
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2014.01.09 김보배 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김보배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EurManifestListCondVO extends ManifestListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<EurManifestListCondVO> models = new ArrayList<EurManifestListCondVO>();
	
	/* Column Info */
	private String pOriAmdCd = null;
	/* Column Info */
	private String pSOfcCd = null;
	/* Column Info */
	private String pErrorCd = null;
	/* Column Info */
	private String pAckStatus = null;
	/* Column Info */
	private String pFiPodYardCd = null;
	/* Column Info */
	private String eu1stPortClptSeq = null;
	/* Column Info */
	private String pBStaff = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pFiPolYardCd = null;
	/* Column Info */
	private String pBlNo = null;
	/* Column Info */
	private String pBOfcCd = null;
	/* Column Info */
	private String pFiLt = null;
	/* Column Info */
	private String pPolCd = null;
	/* Column Info */
	private String pSearchPofeYardCd = null;
	/* Column Info */
	private String pFiPolCd = null;
	/* Column Info */
	private String pFirstOfMultiPofeCd = null;
	/* Column Info */
	private String pSendYn = null;
	/* Column Info */
	private String pPodYardCd = null;
	/* Column Info */
	private String pPolYardCd = null;
	/* Column Info */
	private String pPodCd = null;
	/* Column Info */
	private String pFiAckStatus = null;
	/* Column Info */
	private String pVvdCd = null;
	/* Column Info */
	private String pFiVvdCd = null;
	/* Column Info */
	private String pFiBlNo = null;
	/* Column Info */
	private String pFiPodCd = null;
	/* Column Info */
	private String pDataCd = null;
	/* Column Info */
	private String pLt = null;
	/* Column Info */
	private String pType = null;
	/* Column Info */
	private String toSndFlg = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EurManifestListCondVO() {}

	public EurManifestListCondVO(String ibflag, String pagerows, String pDataCd, String pErrorCd, String pBOfcCd, String pSOfcCd, String pBStaff, String pVvdCd, String pPolCd, String pPolYardCd, String pPodCd, String pPodYardCd, String pOriAmdCd, String pBlNo, String pSendYn, String pAckStatus, String pLt, String pSearchPofeYardCd, String pFirstOfMultiPofeCd, String pType, String pFiVvdCd, String pFiPolCd, String pFiPolYardCd, String pFiPodCd, String pFiPodYardCd, String pFiBlNo, String pFiLt, String pFiAckStatus, String eu1stPortClptSeq, String toSndFlg) {
		this.pOriAmdCd = pOriAmdCd;
		this.pSOfcCd = pSOfcCd;
		this.pErrorCd = pErrorCd;
		this.pAckStatus = pAckStatus;
		this.pFiPodYardCd = pFiPodYardCd;
		this.eu1stPortClptSeq = eu1stPortClptSeq;
		this.pBStaff = pBStaff;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.pFiPolYardCd = pFiPolYardCd;
		this.pBlNo = pBlNo;
		this.pBOfcCd = pBOfcCd;
		this.pFiLt = pFiLt;
		this.pPolCd = pPolCd;
		this.pSearchPofeYardCd = pSearchPofeYardCd;
		this.pFiPolCd = pFiPolCd;
		this.pFirstOfMultiPofeCd = pFirstOfMultiPofeCd;
		this.pSendYn = pSendYn;
		this.pPodYardCd = pPodYardCd;
		this.pPolYardCd = pPolYardCd;
		this.pPodCd = pPodCd;
		this.pFiAckStatus = pFiAckStatus;
		this.pVvdCd = pVvdCd;
		this.pFiVvdCd = pFiVvdCd;
		this.pFiBlNo = pFiBlNo;
		this.pFiPodCd = pFiPodCd;
		this.pDataCd = pDataCd;
		this.pLt = pLt;
		this.pType = pType;
		this.toSndFlg = toSndFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("p_ori_amd_cd", getPOriAmdCd());
		this.hashColumns.put("p_s_ofc_cd", getPSOfcCd());
		this.hashColumns.put("p_error_cd", getPErrorCd());
		this.hashColumns.put("p_ack_status", getPAckStatus());
		this.hashColumns.put("p_fi_pod_yard_cd", getPFiPodYardCd());
		this.hashColumns.put("eu_1st_port_clpt_seq", getEu1stPortClptSeq());
		this.hashColumns.put("p_b_staff", getPBStaff());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("p_fi_pol_yard_cd", getPFiPolYardCd());
		this.hashColumns.put("p_bl_no", getPBlNo());
		this.hashColumns.put("p_b_ofc_cd", getPBOfcCd());
		this.hashColumns.put("p_fi_lt", getPFiLt());
		this.hashColumns.put("p_pol_cd", getPPolCd());
		this.hashColumns.put("p_search_pofe_yard_cd", getPSearchPofeYardCd());
		this.hashColumns.put("p_fi_pol_cd", getPFiPolCd());
		this.hashColumns.put("p_first_of_multi_pofe_cd", getPFirstOfMultiPofeCd());
		this.hashColumns.put("p_send_yn", getPSendYn());
		this.hashColumns.put("p_pod_yard_cd", getPPodYardCd());
		this.hashColumns.put("p_pol_yard_cd", getPPolYardCd());
		this.hashColumns.put("p_pod_cd", getPPodCd());
		this.hashColumns.put("p_fi_ack_status", getPFiAckStatus());
		this.hashColumns.put("p_vvd_cd", getPVvdCd());
		this.hashColumns.put("p_fi_vvd_cd", getPFiVvdCd());
		this.hashColumns.put("p_fi_bl_no", getPFiBlNo());
		this.hashColumns.put("p_fi_pod_cd", getPFiPodCd());
		this.hashColumns.put("p_data_cd", getPDataCd());
		this.hashColumns.put("p_lt", getPLt());
		this.hashColumns.put("p_type", getPType());
		this.hashColumns.put("to_snd_flg", getToSndFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("p_ori_amd_cd", "pOriAmdCd");
		this.hashFields.put("p_s_ofc_cd", "pSOfcCd");
		this.hashFields.put("p_error_cd", "pErrorCd");
		this.hashFields.put("p_ack_status", "pAckStatus");
		this.hashFields.put("p_fi_pod_yard_cd", "pFiPodYardCd");
		this.hashFields.put("eu_1st_port_clpt_seq", "eu1stPortClptSeq");
		this.hashFields.put("p_b_staff", "pBStaff");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("p_fi_pol_yard_cd", "pFiPolYardCd");
		this.hashFields.put("p_bl_no", "pBlNo");
		this.hashFields.put("p_b_ofc_cd", "pBOfcCd");
		this.hashFields.put("p_fi_lt", "pFiLt");
		this.hashFields.put("p_pol_cd", "pPolCd");
		this.hashFields.put("p_search_pofe_yard_cd", "pSearchPofeYardCd");
		this.hashFields.put("p_fi_pol_cd", "pFiPolCd");
		this.hashFields.put("p_first_of_multi_pofe_cd", "pFirstOfMultiPofeCd");
		this.hashFields.put("p_send_yn", "pSendYn");
		this.hashFields.put("p_pod_yard_cd", "pPodYardCd");
		this.hashFields.put("p_pol_yard_cd", "pPolYardCd");
		this.hashFields.put("p_pod_cd", "pPodCd");
		this.hashFields.put("p_fi_ack_status", "pFiAckStatus");
		this.hashFields.put("p_vvd_cd", "pVvdCd");
		this.hashFields.put("p_fi_vvd_cd", "pFiVvdCd");
		this.hashFields.put("p_fi_bl_no", "pFiBlNo");
		this.hashFields.put("p_fi_pod_cd", "pFiPodCd");
		this.hashFields.put("p_data_cd", "pDataCd");
		this.hashFields.put("p_lt", "pLt");
		this.hashFields.put("p_type", "pType");
		this.hashFields.put("to_snd_flg", "toSndFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pOriAmdCd
	 */
	public String getPOriAmdCd() {
		return this.pOriAmdCd;
	}
	
	/**
	 * Column Info
	 * @return pSOfcCd
	 */
	public String getPSOfcCd() {
		return this.pSOfcCd;
	}
	
	/**
	 * Column Info
	 * @return pErrorCd
	 */
	public String getPErrorCd() {
		return this.pErrorCd;
	}
	
	/**
	 * Column Info
	 * @return pAckStatus
	 */
	public String getPAckStatus() {
		return this.pAckStatus;
	}
	
	/**
	 * Column Info
	 * @return pFiPodYardCd
	 */
	public String getPFiPodYardCd() {
		return this.pFiPodYardCd;
	}
	
	/**
	 * Column Info
	 * @return eu1stPortClptSeq
	 */
	public String getEu1stPortClptSeq() {
		return this.eu1stPortClptSeq;
	}
	
	/**
	 * Column Info
	 * @return pBStaff
	 */
	public String getPBStaff() {
		return this.pBStaff;
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
	 * @return pFiPolYardCd
	 */
	public String getPFiPolYardCd() {
		return this.pFiPolYardCd;
	}
	
	/**
	 * Column Info
	 * @return pBlNo
	 */
	public String getPBlNo() {
		return this.pBlNo;
	}
	
	/**
	 * Column Info
	 * @return pBOfcCd
	 */
	public String getPBOfcCd() {
		return this.pBOfcCd;
	}
	
	/**
	 * Column Info
	 * @return pFiLt
	 */
	public String getPFiLt() {
		return this.pFiLt;
	}
	
	/**
	 * Column Info
	 * @return pPolCd
	 */
	public String getPPolCd() {
		return this.pPolCd;
	}
	
	/**
	 * Column Info
	 * @return pSearchPofeYardCd
	 */
	public String getPSearchPofeYardCd() {
		return this.pSearchPofeYardCd;
	}
	
	/**
	 * Column Info
	 * @return pFiPolCd
	 */
	public String getPFiPolCd() {
		return this.pFiPolCd;
	}
	
	/**
	 * Column Info
	 * @return pFirstOfMultiPofeCd
	 */
	public String getPFirstOfMultiPofeCd() {
		return this.pFirstOfMultiPofeCd;
	}
	
	/**
	 * Column Info
	 * @return pSendYn
	 */
	public String getPSendYn() {
		return this.pSendYn;
	}
	
	/**
	 * Column Info
	 * @return pPodYardCd
	 */
	public String getPPodYardCd() {
		return this.pPodYardCd;
	}
	
	/**
	 * Column Info
	 * @return pPolYardCd
	 */
	public String getPPolYardCd() {
		return this.pPolYardCd;
	}
	
	/**
	 * Column Info
	 * @return pPodCd
	 */
	public String getPPodCd() {
		return this.pPodCd;
	}
	
	/**
	 * Column Info
	 * @return pFiAckStatus
	 */
	public String getPFiAckStatus() {
		return this.pFiAckStatus;
	}
	
	/**
	 * Column Info
	 * @return pVvdCd
	 */
	public String getPVvdCd() {
		return this.pVvdCd;
	}
	
	/**
	 * Column Info
	 * @return pFiVvdCd
	 */
	public String getPFiVvdCd() {
		return this.pFiVvdCd;
	}
	
	/**
	 * Column Info
	 * @return pFiBlNo
	 */
	public String getPFiBlNo() {
		return this.pFiBlNo;
	}
	
	/**
	 * Column Info
	 * @return pFiPodCd
	 */
	public String getPFiPodCd() {
		return this.pFiPodCd;
	}
	
	/**
	 * Column Info
	 * @return pDataCd
	 */
	public String getPDataCd() {
		return this.pDataCd;
	}
	
	/**
	 * Column Info
	 * @return pLt
	 */
	public String getPLt() {
		return this.pLt;
	}
	
	/**
	 * Column Info
	 * @return pType
	 */
	public String getPType() {
		return this.pType;
	}
	
	/**
	 * Column Info
	 * @return toSndFlg
	 */
	public String getToSndFlg() {
		return this.toSndFlg;
	}	

	/**
	 * Column Info
	 * @param pOriAmdCd
	 */
	public void setPOriAmdCd(String pOriAmdCd) {
		this.pOriAmdCd = pOriAmdCd;
	}
	
	/**
	 * Column Info
	 * @param pSOfcCd
	 */
	public void setPSOfcCd(String pSOfcCd) {
		this.pSOfcCd = pSOfcCd;
	}
	
	/**
	 * Column Info
	 * @param pErrorCd
	 */
	public void setPErrorCd(String pErrorCd) {
		this.pErrorCd = pErrorCd;
	}
	
	/**
	 * Column Info
	 * @param pAckStatus
	 */
	public void setPAckStatus(String pAckStatus) {
		this.pAckStatus = pAckStatus;
	}
	
	/**
	 * Column Info
	 * @param pFiPodYardCd
	 */
	public void setPFiPodYardCd(String pFiPodYardCd) {
		this.pFiPodYardCd = pFiPodYardCd;
	}
	
	/**
	 * Column Info
	 * @param eu1stPortClptSeq
	 */
	public void setEu1stPortClptSeq(String eu1stPortClptSeq) {
		this.eu1stPortClptSeq = eu1stPortClptSeq;
	}
	
	/**
	 * Column Info
	 * @param pBStaff
	 */
	public void setPBStaff(String pBStaff) {
		this.pBStaff = pBStaff;
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
	 * @param pFiPolYardCd
	 */
	public void setPFiPolYardCd(String pFiPolYardCd) {
		this.pFiPolYardCd = pFiPolYardCd;
	}
	
	/**
	 * Column Info
	 * @param pBlNo
	 */
	public void setPBlNo(String pBlNo) {
		this.pBlNo = pBlNo;
	}
	
	/**
	 * Column Info
	 * @param pBOfcCd
	 */
	public void setPBOfcCd(String pBOfcCd) {
		this.pBOfcCd = pBOfcCd;
	}
	
	/**
	 * Column Info
	 * @param pFiLt
	 */
	public void setPFiLt(String pFiLt) {
		this.pFiLt = pFiLt;
	}
	
	/**
	 * Column Info
	 * @param pPolCd
	 */
	public void setPPolCd(String pPolCd) {
		this.pPolCd = pPolCd;
	}
	
	/**
	 * Column Info
	 * @param pSearchPofeYardCd
	 */
	public void setPSearchPofeYardCd(String pSearchPofeYardCd) {
		this.pSearchPofeYardCd = pSearchPofeYardCd;
	}
	
	/**
	 * Column Info
	 * @param pFiPolCd
	 */
	public void setPFiPolCd(String pFiPolCd) {
		this.pFiPolCd = pFiPolCd;
	}
	
	/**
	 * Column Info
	 * @param pFirstOfMultiPofeCd
	 */
	public void setPFirstOfMultiPofeCd(String pFirstOfMultiPofeCd) {
		this.pFirstOfMultiPofeCd = pFirstOfMultiPofeCd;
	}
	
	/**
	 * Column Info
	 * @param pSendYn
	 */
	public void setPSendYn(String pSendYn) {
		this.pSendYn = pSendYn;
	}
	
	/**
	 * Column Info
	 * @param pPodYardCd
	 */
	public void setPPodYardCd(String pPodYardCd) {
		this.pPodYardCd = pPodYardCd;
	}
	
	/**
	 * Column Info
	 * @param pPolYardCd
	 */
	public void setPPolYardCd(String pPolYardCd) {
		this.pPolYardCd = pPolYardCd;
	}
	
	/**
	 * Column Info
	 * @param pPodCd
	 */
	public void setPPodCd(String pPodCd) {
		this.pPodCd = pPodCd;
	}
	
	/**
	 * Column Info
	 * @param pFiAckStatus
	 */
	public void setPFiAckStatus(String pFiAckStatus) {
		this.pFiAckStatus = pFiAckStatus;
	}
	
	/**
	 * Column Info
	 * @param pVvdCd
	 */
	public void setPVvdCd(String pVvdCd) {
		this.pVvdCd = pVvdCd;
	}
	
	/**
	 * Column Info
	 * @param pFiVvdCd
	 */
	public void setPFiVvdCd(String pFiVvdCd) {
		this.pFiVvdCd = pFiVvdCd;
	}
	
	/**
	 * Column Info
	 * @param pFiBlNo
	 */
	public void setPFiBlNo(String pFiBlNo) {
		this.pFiBlNo = pFiBlNo;
	}
	
	/**
	 * Column Info
	 * @param pFiPodCd
	 */
	public void setPFiPodCd(String pFiPodCd) {
		this.pFiPodCd = pFiPodCd;
	}
	
	/**
	 * Column Info
	 * @param pDataCd
	 */
	public void setPDataCd(String pDataCd) {
		this.pDataCd = pDataCd;
	}
	
	/**
	 * Column Info
	 * @param pLt
	 */
	public void setPLt(String pLt) {
		this.pLt = pLt;
	}
	
	/**
	 * Column Info
	 * @param pType
	 */
	public void setPType(String pType) {
		this.pType = pType;
	}
	
	/**
	 * Column Info
	 * @param toSndFlg
	 */
	public void setToSndFlg(String toSndFlg) {
		this.toSndFlg = toSndFlg;
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
		setPOriAmdCd(JSPUtil.getParameter(request, prefix + "p_ori_amd_cd", ""));
		setPSOfcCd(JSPUtil.getParameter(request, prefix + "p_s_ofc_cd", ""));
		setPErrorCd(JSPUtil.getParameter(request, prefix + "p_error_cd", ""));
		setPAckStatus(JSPUtil.getParameter(request, prefix + "p_ack_status", ""));
		setPFiPodYardCd(JSPUtil.getParameter(request, prefix + "p_fi_pod_yard_cd", ""));
		setEu1stPortClptSeq(JSPUtil.getParameter(request, prefix + "eu_1st_port_clpt_seq", ""));
		setPBStaff(JSPUtil.getParameter(request, prefix + "p_b_staff", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPFiPolYardCd(JSPUtil.getParameter(request, prefix + "p_fi_pol_yard_cd", ""));
		setPBlNo(JSPUtil.getParameter(request, prefix + "p_bl_no", ""));
		setPBOfcCd(JSPUtil.getParameter(request, prefix + "p_b_ofc_cd", ""));
		setPFiLt(JSPUtil.getParameter(request, prefix + "p_fi_lt", ""));
		setPPolCd(JSPUtil.getParameter(request, prefix + "p_pol_cd", ""));
		setPSearchPofeYardCd(JSPUtil.getParameter(request, prefix + "p_search_pofe_yard_cd", ""));
		setPFiPolCd(JSPUtil.getParameter(request, prefix + "p_fi_pol_cd", ""));
		setPFirstOfMultiPofeCd(JSPUtil.getParameter(request, prefix + "p_first_of_multi_pofe_cd", ""));
		setPSendYn(JSPUtil.getParameter(request, prefix + "p_send_yn", ""));
		setPPodYardCd(JSPUtil.getParameter(request, prefix + "p_pod_yard_cd", ""));
		setPPolYardCd(JSPUtil.getParameter(request, prefix + "p_pol_yard_cd", ""));
		setPPodCd(JSPUtil.getParameter(request, prefix + "p_pod_cd", ""));
		setPFiAckStatus(JSPUtil.getParameter(request, prefix + "p_fi_ack_status", ""));
		setPVvdCd(JSPUtil.getParameter(request, prefix + "p_vvd_cd", ""));
		setPFiVvdCd(JSPUtil.getParameter(request, prefix + "p_fi_vvd_cd", ""));
		setPFiBlNo(JSPUtil.getParameter(request, prefix + "p_fi_bl_no", ""));
		setPFiPodCd(JSPUtil.getParameter(request, prefix + "p_fi_pod_cd", ""));
		setPDataCd(JSPUtil.getParameter(request, prefix + "p_data_cd", ""));
		setPLt(JSPUtil.getParameter(request, prefix + "p_lt", ""));
		setPType(JSPUtil.getParameter(request, prefix + "p_type", ""));
		setToSndFlg(JSPUtil.getParameter(request, prefix + "to_snd_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurManifestListCondVO[]
	 */
	public EurManifestListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurManifestListCondVO[]
	 */
	public EurManifestListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EurManifestListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pOriAmdCd = (JSPUtil.getParameter(request, prefix	+ "p_ori_amd_cd", length));
			String[] pSOfcCd = (JSPUtil.getParameter(request, prefix	+ "p_s_ofc_cd", length));
			String[] pErrorCd = (JSPUtil.getParameter(request, prefix	+ "p_error_cd", length));
			String[] pAckStatus = (JSPUtil.getParameter(request, prefix	+ "p_ack_status", length));
			String[] pFiPodYardCd = (JSPUtil.getParameter(request, prefix	+ "p_fi_pod_yard_cd", length));
			String[] eu1stPortClptSeq = (JSPUtil.getParameter(request, prefix	+ "eu_1st_port_clpt_seq", length));
			String[] pBStaff = (JSPUtil.getParameter(request, prefix	+ "p_b_staff", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pFiPolYardCd = (JSPUtil.getParameter(request, prefix	+ "p_fi_pol_yard_cd", length));
			String[] pBlNo = (JSPUtil.getParameter(request, prefix	+ "p_bl_no", length));
			String[] pBOfcCd = (JSPUtil.getParameter(request, prefix	+ "p_b_ofc_cd", length));
			String[] pFiLt = (JSPUtil.getParameter(request, prefix	+ "p_fi_lt", length));
			String[] pPolCd = (JSPUtil.getParameter(request, prefix	+ "p_pol_cd", length));
			String[] pSearchPofeYardCd = (JSPUtil.getParameter(request, prefix	+ "p_search_pofe_yard_cd", length));
			String[] pFiPolCd = (JSPUtil.getParameter(request, prefix	+ "p_fi_pol_cd", length));
			String[] pFirstOfMultiPofeCd = (JSPUtil.getParameter(request, prefix	+ "p_first_of_multi_pofe_cd", length));
			String[] pSendYn = (JSPUtil.getParameter(request, prefix	+ "p_send_yn", length));
			String[] pPodYardCd = (JSPUtil.getParameter(request, prefix	+ "p_pod_yard_cd", length));
			String[] pPolYardCd = (JSPUtil.getParameter(request, prefix	+ "p_pol_yard_cd", length));
			String[] pPodCd = (JSPUtil.getParameter(request, prefix	+ "p_pod_cd", length));
			String[] pFiAckStatus = (JSPUtil.getParameter(request, prefix	+ "p_fi_ack_status", length));
			String[] pVvdCd = (JSPUtil.getParameter(request, prefix	+ "p_vvd_cd", length));
			String[] pFiVvdCd = (JSPUtil.getParameter(request, prefix	+ "p_fi_vvd_cd", length));
			String[] pFiBlNo = (JSPUtil.getParameter(request, prefix	+ "p_fi_bl_no", length));
			String[] pFiPodCd = (JSPUtil.getParameter(request, prefix	+ "p_fi_pod_cd", length));
			String[] pDataCd = (JSPUtil.getParameter(request, prefix	+ "p_data_cd", length));
			String[] pLt = (JSPUtil.getParameter(request, prefix	+ "p_lt", length));
			String[] pType = (JSPUtil.getParameter(request, prefix	+ "p_type", length));
			String[] toSndFlg = (JSPUtil.getParameter(request, prefix	+ "to_snd_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new EurManifestListCondVO();
				if (pOriAmdCd[i] != null)
					model.setPOriAmdCd(pOriAmdCd[i]);
				if (pSOfcCd[i] != null)
					model.setPSOfcCd(pSOfcCd[i]);
				if (pErrorCd[i] != null)
					model.setPErrorCd(pErrorCd[i]);
				if (pAckStatus[i] != null)
					model.setPAckStatus(pAckStatus[i]);
				if (pFiPodYardCd[i] != null)
					model.setPFiPodYardCd(pFiPodYardCd[i]);
				if (eu1stPortClptSeq[i] != null)
					model.setEu1stPortClptSeq(eu1stPortClptSeq[i]);
				if (pBStaff[i] != null)
					model.setPBStaff(pBStaff[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pFiPolYardCd[i] != null)
					model.setPFiPolYardCd(pFiPolYardCd[i]);
				if (pBlNo[i] != null)
					model.setPBlNo(pBlNo[i]);
				if (pBOfcCd[i] != null)
					model.setPBOfcCd(pBOfcCd[i]);
				if (pFiLt[i] != null)
					model.setPFiLt(pFiLt[i]);
				if (pPolCd[i] != null)
					model.setPPolCd(pPolCd[i]);
				if (pSearchPofeYardCd[i] != null)
					model.setPSearchPofeYardCd(pSearchPofeYardCd[i]);
				if (pFiPolCd[i] != null)
					model.setPFiPolCd(pFiPolCd[i]);
				if (pFirstOfMultiPofeCd[i] != null)
					model.setPFirstOfMultiPofeCd(pFirstOfMultiPofeCd[i]);
				if (pSendYn[i] != null)
					model.setPSendYn(pSendYn[i]);
				if (pPodYardCd[i] != null)
					model.setPPodYardCd(pPodYardCd[i]);
				if (pPolYardCd[i] != null)
					model.setPPolYardCd(pPolYardCd[i]);
				if (pPodCd[i] != null)
					model.setPPodCd(pPodCd[i]);
				if (pFiAckStatus[i] != null)
					model.setPFiAckStatus(pFiAckStatus[i]);
				if (pVvdCd[i] != null)
					model.setPVvdCd(pVvdCd[i]);
				if (pFiVvdCd[i] != null)
					model.setPFiVvdCd(pFiVvdCd[i]);
				if (pFiBlNo[i] != null)
					model.setPFiBlNo(pFiBlNo[i]);
				if (pFiPodCd[i] != null)
					model.setPFiPodCd(pFiPodCd[i]);
				if (pDataCd[i] != null)
					model.setPDataCd(pDataCd[i]);
				if (pLt[i] != null)
					model.setPLt(pLt[i]);
				if (pType[i] != null)
					model.setPType(pType[i]);
				if (toSndFlg[i] != null)
					model.setToSndFlg(toSndFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEurManifestListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EurManifestListCondVO[]
	 */
	public EurManifestListCondVO[] getEurManifestListCondVOs(){
		EurManifestListCondVO[] vos = (EurManifestListCondVO[])models.toArray(new EurManifestListCondVO[models.size()]);
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
		this.pOriAmdCd = this.pOriAmdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pSOfcCd = this.pSOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pErrorCd = this.pErrorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pAckStatus = this.pAckStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFiPodYardCd = this.pFiPodYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eu1stPortClptSeq = this.eu1stPortClptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBStaff = this.pBStaff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFiPolYardCd = this.pFiPolYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBlNo = this.pBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBOfcCd = this.pBOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFiLt = this.pFiLt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPolCd = this.pPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pSearchPofeYardCd = this.pSearchPofeYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFiPolCd = this.pFiPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFirstOfMultiPofeCd = this.pFirstOfMultiPofeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pSendYn = this.pSendYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPodYardCd = this.pPodYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPolYardCd = this.pPolYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPodCd = this.pPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFiAckStatus = this.pFiAckStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVvdCd = this.pVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFiVvdCd = this.pFiVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFiBlNo = this.pFiBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFiPodCd = this.pFiPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDataCd = this.pDataCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pLt = this.pLt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pType = this.pType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSndFlg = this.toSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
