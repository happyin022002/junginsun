/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaInbondManifestDetailListVO.java
*@FileTitle : UsaInbondManifestDetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.28  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondManifestDetailListVO;
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

public class UsaInbondManifestDetailListVO extends InbondManifestDetailListVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaInbondManifestDetailListVO> models = new ArrayList<UsaInbondManifestDetailListVO>();
	
	/* Column Info */
	private String usaLstLocCd = null;
	/* Column Info */
	private String oldUsa = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String cstmsClrTpCdChg = null;
	/* Column Info */
	private String ibdTrspTpCdChg = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String lclFlg = null;
	/* Column Info */
	private String cstmsClrTpCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String rcvLocCd = null;
	/* Column Info */
	private String ibdTrspTpCd = null;
	/* Column Info */
	private String ibdTrspNo = null;
	/* Column Info */
	private String cstmsLocCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String dspoCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String oldTp = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String loclClrIpiMvmtFlg = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String oldHub = null;
	/* Column Info */
	private String oldEntry = null;
	/* Column Info */
	private String hubLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaInbondManifestDetailListVO() {}

	public UsaInbondManifestDetailListVO(String ibflag, String pagerows, String blNo, String delCd, String usaLstLocCd, String hubLocCd, String ibdTrspNo, String ibdTrspTpCd, String pckQty, String cstmsClrTpCd, String loclClrIpiMvmtFlg, String dspoCd, String rcvLocCd, String rcvTermCd, String deTermCd, String custSeq, String custNm, String cstmsLocCd, String lclFlg, String vvd, String podCd, String polCd, String oldUsa, String oldEntry, String oldTp, String oldHub, String cstmsClrTpCdChg, String ibdTrspTpCdChg) {
		this.usaLstLocCd = usaLstLocCd;
		this.oldUsa = oldUsa;
		this.custNm = custNm;
		this.cstmsClrTpCdChg = cstmsClrTpCdChg;
		this.ibdTrspTpCdChg = ibdTrspTpCdChg;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.lclFlg = lclFlg;
		this.cstmsClrTpCd = cstmsClrTpCd;
		this.pckQty = pckQty;
		this.rcvTermCd = rcvTermCd;
		this.rcvLocCd = rcvLocCd;
		this.ibdTrspTpCd = ibdTrspTpCd;
		this.ibdTrspNo = ibdTrspNo;
		this.cstmsLocCd = cstmsLocCd;
		this.delCd = delCd;
		this.dspoCd = dspoCd;
		this.custSeq = custSeq;
		this.oldTp = oldTp;
		this.vvd = vvd;
		this.podCd = podCd;
		this.loclClrIpiMvmtFlg = loclClrIpiMvmtFlg;
		this.deTermCd = deTermCd;
		this.oldHub = oldHub;
		this.oldEntry = oldEntry;
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("usa_lst_loc_cd", getUsaLstLocCd());
		this.hashColumns.put("old_usa", getOldUsa());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cstms_clr_tp_cd_chg", getCstmsClrTpCdChg());
		this.hashColumns.put("ibd_trsp_tp_cd_chg", getIbdTrspTpCdChg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("lcl_flg", getLclFlg());
		this.hashColumns.put("cstms_clr_tp_cd", getCstmsClrTpCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("rcv_loc_cd", getRcvLocCd());
		this.hashColumns.put("ibd_trsp_tp_cd", getIbdTrspTpCd());
		this.hashColumns.put("ibd_trsp_no", getIbdTrspNo());
		this.hashColumns.put("cstms_loc_cd", getCstmsLocCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("dspo_cd", getDspoCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("old_tp", getOldTp());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("locl_clr_ipi_mvmt_flg", getLoclClrIpiMvmtFlg());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("old_hub", getOldHub());
		this.hashColumns.put("old_entry", getOldEntry());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("usa_lst_loc_cd", "usaLstLocCd");
		this.hashFields.put("old_usa", "oldUsa");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cstms_clr_tp_cd_chg", "cstmsClrTpCdChg");
		this.hashFields.put("ibd_trsp_tp_cd_chg", "ibdTrspTpCdChg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("lcl_flg", "lclFlg");
		this.hashFields.put("cstms_clr_tp_cd", "cstmsClrTpCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("rcv_loc_cd", "rcvLocCd");
		this.hashFields.put("ibd_trsp_tp_cd", "ibdTrspTpCd");
		this.hashFields.put("ibd_trsp_no", "ibdTrspNo");
		this.hashFields.put("cstms_loc_cd", "cstmsLocCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("dspo_cd", "dspoCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("old_tp", "oldTp");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("locl_clr_ipi_mvmt_flg", "loclClrIpiMvmtFlg");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("old_hub", "oldHub");
		this.hashFields.put("old_entry", "oldEntry");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
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
	 * @return oldUsa
	 */
	public String getOldUsa() {
		return this.oldUsa;
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
	 * @return cstmsClrTpCdChg
	 */
	public String getCstmsClrTpCdChg() {
		return this.cstmsClrTpCdChg;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspTpCdChg
	 */
	public String getIbdTrspTpCdChg() {
		return this.ibdTrspTpCdChg;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return lclFlg
	 */
	public String getLclFlg() {
		return this.lclFlg;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrTpCd
	 */
	public String getCstmsClrTpCd() {
		return this.cstmsClrTpCd;
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
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return rcvLocCd
	 */
	public String getRcvLocCd() {
		return this.rcvLocCd;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspTpCd
	 */
	public String getIbdTrspTpCd() {
		return this.ibdTrspTpCd;
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
	 * @return cstmsLocCd
	 */
	public String getCstmsLocCd() {
		return this.cstmsLocCd;
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
	 * @return dspoCd
	 */
	public String getDspoCd() {
		return this.dspoCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return oldTp
	 */
	public String getOldTp() {
		return this.oldTp;
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
	 * @return loclClrIpiMvmtFlg
	 */
	public String getLoclClrIpiMvmtFlg() {
		return this.loclClrIpiMvmtFlg;
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
	 * @return oldHub
	 */
	public String getOldHub() {
		return this.oldHub;
	}
	
	/**
	 * Column Info
	 * @return oldEntry
	 */
	public String getOldEntry() {
		return this.oldEntry;
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
	 * @param usaLstLocCd
	 */
	public void setUsaLstLocCd(String usaLstLocCd) {
		this.usaLstLocCd = usaLstLocCd;
	}
	
	/**
	 * Column Info
	 * @param oldUsa
	 */
	public void setOldUsa(String oldUsa) {
		this.oldUsa = oldUsa;
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
	 * @param cstmsClrTpCdChg
	 */
	public void setCstmsClrTpCdChg(String cstmsClrTpCdChg) {
		this.cstmsClrTpCdChg = cstmsClrTpCdChg;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspTpCdChg
	 */
	public void setIbdTrspTpCdChg(String ibdTrspTpCdChg) {
		this.ibdTrspTpCdChg = ibdTrspTpCdChg;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param lclFlg
	 */
	public void setLclFlg(String lclFlg) {
		this.lclFlg = lclFlg;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrTpCd
	 */
	public void setCstmsClrTpCd(String cstmsClrTpCd) {
		this.cstmsClrTpCd = cstmsClrTpCd;
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
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param rcvLocCd
	 */
	public void setRcvLocCd(String rcvLocCd) {
		this.rcvLocCd = rcvLocCd;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspTpCd
	 */
	public void setIbdTrspTpCd(String ibdTrspTpCd) {
		this.ibdTrspTpCd = ibdTrspTpCd;
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
	 * @param cstmsLocCd
	 */
	public void setCstmsLocCd(String cstmsLocCd) {
		this.cstmsLocCd = cstmsLocCd;
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
	 * @param dspoCd
	 */
	public void setDspoCd(String dspoCd) {
		this.dspoCd = dspoCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param oldTp
	 */
	public void setOldTp(String oldTp) {
		this.oldTp = oldTp;
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
	 * @param loclClrIpiMvmtFlg
	 */
	public void setLoclClrIpiMvmtFlg(String loclClrIpiMvmtFlg) {
		this.loclClrIpiMvmtFlg = loclClrIpiMvmtFlg;
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
	 * @param oldHub
	 */
	public void setOldHub(String oldHub) {
		this.oldHub = oldHub;
	}
	
	/**
	 * Column Info
	 * @param oldEntry
	 */
	public void setOldEntry(String oldEntry) {
		this.oldEntry = oldEntry;
	}
	
	/**
	 * Column Info
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
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
		setOldUsa(JSPUtil.getParameter(request, prefix + "old_usa", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setCstmsClrTpCdChg(JSPUtil.getParameter(request, prefix + "cstms_clr_tp_cd_chg", ""));
		setIbdTrspTpCdChg(JSPUtil.getParameter(request, prefix + "ibd_trsp_tp_cd_chg", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setLclFlg(JSPUtil.getParameter(request, prefix + "lcl_flg", ""));
		setCstmsClrTpCd(JSPUtil.getParameter(request, prefix + "cstms_clr_tp_cd", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setRcvLocCd(JSPUtil.getParameter(request, prefix + "rcv_loc_cd", ""));
		setIbdTrspTpCd(JSPUtil.getParameter(request, prefix + "ibd_trsp_tp_cd", ""));
		setIbdTrspNo(JSPUtil.getParameter(request, prefix + "ibd_trsp_no", ""));
		setCstmsLocCd(JSPUtil.getParameter(request, prefix + "cstms_loc_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setDspoCd(JSPUtil.getParameter(request, prefix + "dspo_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setOldTp(JSPUtil.getParameter(request, prefix + "old_tp", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setLoclClrIpiMvmtFlg(JSPUtil.getParameter(request, prefix + "locl_clr_ipi_mvmt_flg", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setOldHub(JSPUtil.getParameter(request, prefix + "old_hub", ""));
		setOldEntry(JSPUtil.getParameter(request, prefix + "old_entry", ""));
		setHubLocCd(JSPUtil.getParameter(request, prefix + "hub_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaInbondManifestDetailListVO[]
	 */
	public UsaInbondManifestDetailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaInbondManifestDetailListVO[]
	 */
	public UsaInbondManifestDetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaInbondManifestDetailListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] usaLstLocCd = (JSPUtil.getParameter(request, prefix	+ "usa_lst_loc_cd", length));
			String[] oldUsa = (JSPUtil.getParameter(request, prefix	+ "old_usa", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] cstmsClrTpCdChg = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_tp_cd_chg", length));
			String[] ibdTrspTpCdChg = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_tp_cd_chg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] lclFlg = (JSPUtil.getParameter(request, prefix	+ "lcl_flg", length));
			String[] cstmsClrTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_tp_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] rcvLocCd = (JSPUtil.getParameter(request, prefix	+ "rcv_loc_cd", length));
			String[] ibdTrspTpCd = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_tp_cd", length));
			String[] ibdTrspNo = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_no", length));
			String[] cstmsLocCd = (JSPUtil.getParameter(request, prefix	+ "cstms_loc_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] dspoCd = (JSPUtil.getParameter(request, prefix	+ "dspo_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] oldTp = (JSPUtil.getParameter(request, prefix	+ "old_tp", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] loclClrIpiMvmtFlg = (JSPUtil.getParameter(request, prefix	+ "locl_clr_ipi_mvmt_flg", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] oldHub = (JSPUtil.getParameter(request, prefix	+ "old_hub", length));
			String[] oldEntry = (JSPUtil.getParameter(request, prefix	+ "old_entry", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaInbondManifestDetailListVO();
				if (usaLstLocCd[i] != null)
					model.setUsaLstLocCd(usaLstLocCd[i]);
				if (oldUsa[i] != null)
					model.setOldUsa(oldUsa[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (cstmsClrTpCdChg[i] != null)
					model.setCstmsClrTpCdChg(cstmsClrTpCdChg[i]);
				if (ibdTrspTpCdChg[i] != null)
					model.setIbdTrspTpCdChg(ibdTrspTpCdChg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (lclFlg[i] != null)
					model.setLclFlg(lclFlg[i]);
				if (cstmsClrTpCd[i] != null)
					model.setCstmsClrTpCd(cstmsClrTpCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (rcvLocCd[i] != null)
					model.setRcvLocCd(rcvLocCd[i]);
				if (ibdTrspTpCd[i] != null)
					model.setIbdTrspTpCd(ibdTrspTpCd[i]);
				if (ibdTrspNo[i] != null)
					model.setIbdTrspNo(ibdTrspNo[i]);
				if (cstmsLocCd[i] != null)
					model.setCstmsLocCd(cstmsLocCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (dspoCd[i] != null)
					model.setDspoCd(dspoCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (oldTp[i] != null)
					model.setOldTp(oldTp[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (loclClrIpiMvmtFlg[i] != null)
					model.setLoclClrIpiMvmtFlg(loclClrIpiMvmtFlg[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (oldHub[i] != null)
					model.setOldHub(oldHub[i]);
				if (oldEntry[i] != null)
					model.setOldEntry(oldEntry[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaInbondManifestDetailListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaInbondManifestDetailListVO[]
	 */
	public UsaInbondManifestDetailListVO[] getUsaInbondManifestDetailListVOs(){
		UsaInbondManifestDetailListVO[] vos = (UsaInbondManifestDetailListVO[])models.toArray(new UsaInbondManifestDetailListVO[models.size()]);
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
		this.oldUsa = this.oldUsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrTpCdChg = this.cstmsClrTpCdChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspTpCdChg = this.ibdTrspTpCdChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclFlg = this.lclFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrTpCd = this.cstmsClrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvLocCd = this.rcvLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspTpCd = this.ibdTrspTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspNo = this.ibdTrspNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsLocCd = this.cstmsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dspoCd = this.dspoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldTp = this.oldTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclClrIpiMvmtFlg = this.loclClrIpiMvmtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldHub = this.oldHub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldEntry = this.oldEntry .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
