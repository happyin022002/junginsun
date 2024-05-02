/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaOldInbondModiVO.java
*@FileTitle : UsaOldInbondModiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

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

public class UsaOldInbondModiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaOldInbondModiVO> models = new ArrayList<UsaOldInbondModiVO>();
	
	/* Column Info */
	private String ibdTrspXptAcptDt = null;
	/* Column Info */
	private String ibdTrspTpCd = null;
	/* Column Info */
	private String ibdTrspNo = null;
	/* Column Info */
	private String ibdTrspArrDt = null;
	/* Column Info */
	private String ablUsaLstLocCd = null;
	/* Column Info */
	private String ibdTrspXptDt = null;
	/* Column Info */
	private String ibdTrspArrAcptDt = null;
	/* Column Info */
	private String ibdTrspArrSndFlg = null;
	/* Column Info */
	private String clrCntrTpCd = null;
	/* Column Info */
	private String clrFreeTrdZnFlg = null;
	/* Column Info */
	private String ibdClrTpCd = null;
	/* Column Info */
	private String ibdTrspXptSndFlg = null;
	/* Column Info */
	private String pttFrmCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ibdFreeTrdZnFlg = null;
	/* Column Info */
	private String clrClrTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ablHubLocCd = null;
	/* Column Info */
	private String cntCntrTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String clrHubLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UsaOldInbondModiVO() {}

	public UsaOldInbondModiVO(String ibflag, String pagerows, String ablHubLocCd, String ablUsaLstLocCd, String blNo, String clrClrTpCd, String clrCntrTpCd, String clrFreeTrdZnFlg, String clrHubLocCd, String cntCntrTpCd, String creUsrId, String ibdClrTpCd, String ibdFreeTrdZnFlg, String ibdTrspArrAcptDt, String ibdTrspArrDt, String ibdTrspArrSndFlg, String ibdTrspNo, String ibdTrspTpCd, String ibdTrspXptAcptDt, String ibdTrspXptDt, String ibdTrspXptSndFlg, String pttFrmCd, String updUsrId) {
		this.ibdTrspXptAcptDt = ibdTrspXptAcptDt;
		this.ibdTrspTpCd = ibdTrspTpCd;
		this.ibdTrspNo = ibdTrspNo;
		this.ibdTrspArrDt = ibdTrspArrDt;
		this.ablUsaLstLocCd = ablUsaLstLocCd;
		this.ibdTrspXptDt = ibdTrspXptDt;
		this.ibdTrspArrAcptDt = ibdTrspArrAcptDt;
		this.ibdTrspArrSndFlg = ibdTrspArrSndFlg;
		this.clrCntrTpCd = clrCntrTpCd;
		this.clrFreeTrdZnFlg = clrFreeTrdZnFlg;
		this.ibdClrTpCd = ibdClrTpCd;
		this.ibdTrspXptSndFlg = ibdTrspXptSndFlg;
		this.pttFrmCd = pttFrmCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibdFreeTrdZnFlg = ibdFreeTrdZnFlg;
		this.clrClrTpCd = clrClrTpCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.ablHubLocCd = ablHubLocCd;
		this.cntCntrTpCd = cntCntrTpCd;
		this.updUsrId = updUsrId;
		this.clrHubLocCd = clrHubLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibd_trsp_xpt_acpt_dt", getIbdTrspXptAcptDt());
		this.hashColumns.put("ibd_trsp_tp_cd", getIbdTrspTpCd());
		this.hashColumns.put("ibd_trsp_no", getIbdTrspNo());
		this.hashColumns.put("ibd_trsp_arr_dt", getIbdTrspArrDt());
		this.hashColumns.put("abl_usa_lst_loc_cd", getAblUsaLstLocCd());
		this.hashColumns.put("ibd_trsp_xpt_dt", getIbdTrspXptDt());
		this.hashColumns.put("ibd_trsp_arr_acpt_dt", getIbdTrspArrAcptDt());
		this.hashColumns.put("ibd_trsp_arr_snd_flg", getIbdTrspArrSndFlg());
		this.hashColumns.put("clr_cntr_tp_cd", getClrCntrTpCd());
		this.hashColumns.put("clr_free_trd_zn_flg", getClrFreeTrdZnFlg());
		this.hashColumns.put("ibd_clr_tp_cd", getIbdClrTpCd());
		this.hashColumns.put("ibd_trsp_xpt_snd_flg", getIbdTrspXptSndFlg());
		this.hashColumns.put("ptt_frm_cd", getPttFrmCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibd_free_trd_zn_flg", getIbdFreeTrdZnFlg());
		this.hashColumns.put("clr_clr_tp_cd", getClrClrTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("abl_hub_loc_cd", getAblHubLocCd());
		this.hashColumns.put("cnt_cntr_tp_cd", getCntCntrTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("clr_hub_loc_cd", getClrHubLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibd_trsp_xpt_acpt_dt", "ibdTrspXptAcptDt");
		this.hashFields.put("ibd_trsp_tp_cd", "ibdTrspTpCd");
		this.hashFields.put("ibd_trsp_no", "ibdTrspNo");
		this.hashFields.put("ibd_trsp_arr_dt", "ibdTrspArrDt");
		this.hashFields.put("abl_usa_lst_loc_cd", "ablUsaLstLocCd");
		this.hashFields.put("ibd_trsp_xpt_dt", "ibdTrspXptDt");
		this.hashFields.put("ibd_trsp_arr_acpt_dt", "ibdTrspArrAcptDt");
		this.hashFields.put("ibd_trsp_arr_snd_flg", "ibdTrspArrSndFlg");
		this.hashFields.put("clr_cntr_tp_cd", "clrCntrTpCd");
		this.hashFields.put("clr_free_trd_zn_flg", "clrFreeTrdZnFlg");
		this.hashFields.put("ibd_clr_tp_cd", "ibdClrTpCd");
		this.hashFields.put("ibd_trsp_xpt_snd_flg", "ibdTrspXptSndFlg");
		this.hashFields.put("ptt_frm_cd", "pttFrmCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibd_free_trd_zn_flg", "ibdFreeTrdZnFlg");
		this.hashFields.put("clr_clr_tp_cd", "clrClrTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("abl_hub_loc_cd", "ablHubLocCd");
		this.hashFields.put("cnt_cntr_tp_cd", "cntCntrTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("clr_hub_loc_cd", "clrHubLocCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspXptAcptDt
	 */
	public String getIbdTrspXptAcptDt() {
		return this.ibdTrspXptAcptDt;
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
	 * @return ibdTrspArrDt
	 */
	public String getIbdTrspArrDt() {
		return this.ibdTrspArrDt;
	}
	
	/**
	 * Column Info
	 * @return ablUsaLstLocCd
	 */
	public String getAblUsaLstLocCd() {
		return this.ablUsaLstLocCd;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspXptDt
	 */
	public String getIbdTrspXptDt() {
		return this.ibdTrspXptDt;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspArrAcptDt
	 */
	public String getIbdTrspArrAcptDt() {
		return this.ibdTrspArrAcptDt;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspArrSndFlg
	 */
	public String getIbdTrspArrSndFlg() {
		return this.ibdTrspArrSndFlg;
	}
	
	/**
	 * Column Info
	 * @return clrCntrTpCd
	 */
	public String getClrCntrTpCd() {
		return this.clrCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return clrFreeTrdZnFlg
	 */
	public String getClrFreeTrdZnFlg() {
		return this.clrFreeTrdZnFlg;
	}
	
	/**
	 * Column Info
	 * @return ibdClrTpCd
	 */
	public String getIbdClrTpCd() {
		return this.ibdClrTpCd;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspXptSndFlg
	 */
	public String getIbdTrspXptSndFlg() {
		return this.ibdTrspXptSndFlg;
	}
	
	/**
	 * Column Info
	 * @return pttFrmCd
	 */
	public String getPttFrmCd() {
		return this.pttFrmCd;
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
	 * @return ibdFreeTrdZnFlg
	 */
	public String getIbdFreeTrdZnFlg() {
		return this.ibdFreeTrdZnFlg;
	}
	
	/**
	 * Column Info
	 * @return clrClrTpCd
	 */
	public String getClrClrTpCd() {
		return this.clrClrTpCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return ablHubLocCd
	 */
	public String getAblHubLocCd() {
		return this.ablHubLocCd;
	}
	
	/**
	 * Column Info
	 * @return cntCntrTpCd
	 */
	public String getCntCntrTpCd() {
		return this.cntCntrTpCd;
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
	 * @return clrHubLocCd
	 */
	public String getClrHubLocCd() {
		return this.clrHubLocCd;
	}
	

	/**
	 * Column Info
	 * @param ibdTrspXptAcptDt
	 */
	public void setIbdTrspXptAcptDt(String ibdTrspXptAcptDt) {
		this.ibdTrspXptAcptDt = ibdTrspXptAcptDt;
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
	 * @param ibdTrspArrDt
	 */
	public void setIbdTrspArrDt(String ibdTrspArrDt) {
		this.ibdTrspArrDt = ibdTrspArrDt;
	}
	
	/**
	 * Column Info
	 * @param ablUsaLstLocCd
	 */
	public void setAblUsaLstLocCd(String ablUsaLstLocCd) {
		this.ablUsaLstLocCd = ablUsaLstLocCd;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspXptDt
	 */
	public void setIbdTrspXptDt(String ibdTrspXptDt) {
		this.ibdTrspXptDt = ibdTrspXptDt;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspArrAcptDt
	 */
	public void setIbdTrspArrAcptDt(String ibdTrspArrAcptDt) {
		this.ibdTrspArrAcptDt = ibdTrspArrAcptDt;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspArrSndFlg
	 */
	public void setIbdTrspArrSndFlg(String ibdTrspArrSndFlg) {
		this.ibdTrspArrSndFlg = ibdTrspArrSndFlg;
	}
	
	/**
	 * Column Info
	 * @param clrCntrTpCd
	 */
	public void setClrCntrTpCd(String clrCntrTpCd) {
		this.clrCntrTpCd = clrCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param clrFreeTrdZnFlg
	 */
	public void setClrFreeTrdZnFlg(String clrFreeTrdZnFlg) {
		this.clrFreeTrdZnFlg = clrFreeTrdZnFlg;
	}
	
	/**
	 * Column Info
	 * @param ibdClrTpCd
	 */
	public void setIbdClrTpCd(String ibdClrTpCd) {
		this.ibdClrTpCd = ibdClrTpCd;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspXptSndFlg
	 */
	public void setIbdTrspXptSndFlg(String ibdTrspXptSndFlg) {
		this.ibdTrspXptSndFlg = ibdTrspXptSndFlg;
	}
	
	/**
	 * Column Info
	 * @param pttFrmCd
	 */
	public void setPttFrmCd(String pttFrmCd) {
		this.pttFrmCd = pttFrmCd;
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
	 * @param ibdFreeTrdZnFlg
	 */
	public void setIbdFreeTrdZnFlg(String ibdFreeTrdZnFlg) {
		this.ibdFreeTrdZnFlg = ibdFreeTrdZnFlg;
	}
	
	/**
	 * Column Info
	 * @param clrClrTpCd
	 */
	public void setClrClrTpCd(String clrClrTpCd) {
		this.clrClrTpCd = clrClrTpCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param ablHubLocCd
	 */
	public void setAblHubLocCd(String ablHubLocCd) {
		this.ablHubLocCd = ablHubLocCd;
	}
	
	/**
	 * Column Info
	 * @param cntCntrTpCd
	 */
	public void setCntCntrTpCd(String cntCntrTpCd) {
		this.cntCntrTpCd = cntCntrTpCd;
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
	 * @param clrHubLocCd
	 */
	public void setClrHubLocCd(String clrHubLocCd) {
		this.clrHubLocCd = clrHubLocCd;
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
		setIbdTrspXptAcptDt(JSPUtil.getParameter(request, prefix + "ibd_trsp_xpt_acpt_dt", ""));
		setIbdTrspTpCd(JSPUtil.getParameter(request, prefix + "ibd_trsp_tp_cd", ""));
		setIbdTrspNo(JSPUtil.getParameter(request, prefix + "ibd_trsp_no", ""));
		setIbdTrspArrDt(JSPUtil.getParameter(request, prefix + "ibd_trsp_arr_dt", ""));
		setAblUsaLstLocCd(JSPUtil.getParameter(request, prefix + "abl_usa_lst_loc_cd", ""));
		setIbdTrspXptDt(JSPUtil.getParameter(request, prefix + "ibd_trsp_xpt_dt", ""));
		setIbdTrspArrAcptDt(JSPUtil.getParameter(request, prefix + "ibd_trsp_arr_acpt_dt", ""));
		setIbdTrspArrSndFlg(JSPUtil.getParameter(request, prefix + "ibd_trsp_arr_snd_flg", ""));
		setClrCntrTpCd(JSPUtil.getParameter(request, prefix + "clr_cntr_tp_cd", ""));
		setClrFreeTrdZnFlg(JSPUtil.getParameter(request, prefix + "clr_free_trd_zn_flg", ""));
		setIbdClrTpCd(JSPUtil.getParameter(request, prefix + "ibd_clr_tp_cd", ""));
		setIbdTrspXptSndFlg(JSPUtil.getParameter(request, prefix + "ibd_trsp_xpt_snd_flg", ""));
		setPttFrmCd(JSPUtil.getParameter(request, prefix + "ptt_frm_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbdFreeTrdZnFlg(JSPUtil.getParameter(request, prefix + "ibd_free_trd_zn_flg", ""));
		setClrClrTpCd(JSPUtil.getParameter(request, prefix + "clr_clr_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setAblHubLocCd(JSPUtil.getParameter(request, prefix + "abl_hub_loc_cd", ""));
		setCntCntrTpCd(JSPUtil.getParameter(request, prefix + "cnt_cntr_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setClrHubLocCd(JSPUtil.getParameter(request, prefix + "clr_hub_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaOldInbondModiVO[]
	 */
	public UsaOldInbondModiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaOldInbondModiVO[]
	 */
	public UsaOldInbondModiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaOldInbondModiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibdTrspXptAcptDt = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_xpt_acpt_dt", length));
			String[] ibdTrspTpCd = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_tp_cd", length));
			String[] ibdTrspNo = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_no", length));
			String[] ibdTrspArrDt = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_arr_dt", length));
			String[] ablUsaLstLocCd = (JSPUtil.getParameter(request, prefix	+ "abl_usa_lst_loc_cd", length));
			String[] ibdTrspXptDt = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_xpt_dt", length));
			String[] ibdTrspArrAcptDt = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_arr_acpt_dt", length));
			String[] ibdTrspArrSndFlg = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_arr_snd_flg", length));
			String[] clrCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "clr_cntr_tp_cd", length));
			String[] clrFreeTrdZnFlg = (JSPUtil.getParameter(request, prefix	+ "clr_free_trd_zn_flg", length));
			String[] ibdClrTpCd = (JSPUtil.getParameter(request, prefix	+ "ibd_clr_tp_cd", length));
			String[] ibdTrspXptSndFlg = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_xpt_snd_flg", length));
			String[] pttFrmCd = (JSPUtil.getParameter(request, prefix	+ "ptt_frm_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibdFreeTrdZnFlg = (JSPUtil.getParameter(request, prefix	+ "ibd_free_trd_zn_flg", length));
			String[] clrClrTpCd = (JSPUtil.getParameter(request, prefix	+ "clr_clr_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ablHubLocCd = (JSPUtil.getParameter(request, prefix	+ "abl_hub_loc_cd", length));
			String[] cntCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cntr_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] clrHubLocCd = (JSPUtil.getParameter(request, prefix	+ "clr_hub_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaOldInbondModiVO();
				if (ibdTrspXptAcptDt[i] != null)
					model.setIbdTrspXptAcptDt(ibdTrspXptAcptDt[i]);
				if (ibdTrspTpCd[i] != null)
					model.setIbdTrspTpCd(ibdTrspTpCd[i]);
				if (ibdTrspNo[i] != null)
					model.setIbdTrspNo(ibdTrspNo[i]);
				if (ibdTrspArrDt[i] != null)
					model.setIbdTrspArrDt(ibdTrspArrDt[i]);
				if (ablUsaLstLocCd[i] != null)
					model.setAblUsaLstLocCd(ablUsaLstLocCd[i]);
				if (ibdTrspXptDt[i] != null)
					model.setIbdTrspXptDt(ibdTrspXptDt[i]);
				if (ibdTrspArrAcptDt[i] != null)
					model.setIbdTrspArrAcptDt(ibdTrspArrAcptDt[i]);
				if (ibdTrspArrSndFlg[i] != null)
					model.setIbdTrspArrSndFlg(ibdTrspArrSndFlg[i]);
				if (clrCntrTpCd[i] != null)
					model.setClrCntrTpCd(clrCntrTpCd[i]);
				if (clrFreeTrdZnFlg[i] != null)
					model.setClrFreeTrdZnFlg(clrFreeTrdZnFlg[i]);
				if (ibdClrTpCd[i] != null)
					model.setIbdClrTpCd(ibdClrTpCd[i]);
				if (ibdTrspXptSndFlg[i] != null)
					model.setIbdTrspXptSndFlg(ibdTrspXptSndFlg[i]);
				if (pttFrmCd[i] != null)
					model.setPttFrmCd(pttFrmCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibdFreeTrdZnFlg[i] != null)
					model.setIbdFreeTrdZnFlg(ibdFreeTrdZnFlg[i]);
				if (clrClrTpCd[i] != null)
					model.setClrClrTpCd(clrClrTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ablHubLocCd[i] != null)
					model.setAblHubLocCd(ablHubLocCd[i]);
				if (cntCntrTpCd[i] != null)
					model.setCntCntrTpCd(cntCntrTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (clrHubLocCd[i] != null)
					model.setClrHubLocCd(clrHubLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaOldInbondModiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaOldInbondModiVO[]
	 */
	public UsaOldInbondModiVO[] getUsaOldInbondModiVOs(){
		UsaOldInbondModiVO[] vos = (UsaOldInbondModiVO[])models.toArray(new UsaOldInbondModiVO[models.size()]);
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
		this.ibdTrspXptAcptDt = this.ibdTrspXptAcptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspTpCd = this.ibdTrspTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspNo = this.ibdTrspNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspArrDt = this.ibdTrspArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ablUsaLstLocCd = this.ablUsaLstLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspXptDt = this.ibdTrspXptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspArrAcptDt = this.ibdTrspArrAcptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspArrSndFlg = this.ibdTrspArrSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clrCntrTpCd = this.clrCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clrFreeTrdZnFlg = this.clrFreeTrdZnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdClrTpCd = this.ibdClrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspXptSndFlg = this.ibdTrspXptSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pttFrmCd = this.pttFrmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdFreeTrdZnFlg = this.ibdFreeTrdZnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clrClrTpCd = this.clrClrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ablHubLocCd = this.ablHubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCntrTpCd = this.cntCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clrHubLocCd = this.clrHubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
