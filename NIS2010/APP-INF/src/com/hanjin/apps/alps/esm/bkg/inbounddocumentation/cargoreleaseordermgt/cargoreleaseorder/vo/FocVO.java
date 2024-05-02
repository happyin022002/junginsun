/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgFocVO.java
*@FileTitle : BkgFocVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.06.08 임진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 임진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FocVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FocVO> models = new ArrayList<FocVO>();
	
	/* Column Info */
	private String mrnTmlEdiSndCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String inlndYdEdiLstMsgId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cstmsClrLstDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blNoChk = null;
	/* Column Info */
	private String frtCltFlg = null;
	/* Column Info */
	private String mrnTmlEdiRcvId = null;
	/* Column Info */
	private String mrnTmlEdiLstScsFlg = null;
	/* Column Info */
	private String mrnTmlEdiLstSndDt = null;
	/* Column Info */
	private String mrnTmlEdiLstMsgId = null;
	/* Column Info */
	private String blNoTp = null;
	/* Column Info */
	private String frtCltLstDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String hblFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String inlndYdEdiSndCd = null;
	/* Column Info */
	private String inlndYdEdiSndFlg = null;
	/* Column Info */
	private String oblRdemLstDt = null;
	/* Column Info */
	private String cstmsClrCd = null;
	/* Column Info */
	private String mrnTmlEdiSndFlg = null;
	/* Column Info */
	private String oblRdemFlg = null;
	/* Column Info */
	private String cstmsDspoCd = null;
	/* Column Info */
	private String inlndYdEdiRcvId = null;
	/* Column Info */
	private String inlndYdEdiLstScsFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String inlndYdEdiLstSndDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FocVO() {}

	public FocVO(String ibflag, String pagerows, String mrnTmlEdiLstScsFlg, String inlndYdEdiSndFlg, String inlndYdEdiSndCd, String inlndYdEdiLstSndDt, String inlndYdEdiRcvId, String inlndYdEdiLstMsgId, String inlndYdEdiLstScsFlg, String creUsrId, String creDt, String updUsrId, String updDt, String blNo, String blNoTp, String blNoChk, String hblFlg, String frtCltFlg, String frtCltLstDt, String oblRdemFlg, String oblRdemLstDt, String cstmsClrCd, String cstmsClrLstDt, String cstmsDspoCd, String mrnTmlEdiSndFlg, String mrnTmlEdiSndCd, String mrnTmlEdiLstSndDt, String mrnTmlEdiRcvId, String mrnTmlEdiLstMsgId) {
		this.mrnTmlEdiSndCd = mrnTmlEdiSndCd;
		this.creDt = creDt;
		this.blNo = blNo;
		this.inlndYdEdiLstMsgId = inlndYdEdiLstMsgId;
		this.pagerows = pagerows;
		this.cstmsClrLstDt = cstmsClrLstDt;
		this.ibflag = ibflag;
		this.blNoChk = blNoChk;
		this.frtCltFlg = frtCltFlg;
		this.mrnTmlEdiRcvId = mrnTmlEdiRcvId;
		this.mrnTmlEdiLstScsFlg = mrnTmlEdiLstScsFlg;
		this.mrnTmlEdiLstSndDt = mrnTmlEdiLstSndDt;
		this.mrnTmlEdiLstMsgId = mrnTmlEdiLstMsgId;
		this.blNoTp = blNoTp;
		this.frtCltLstDt = frtCltLstDt;
		this.updUsrId = updUsrId;
		this.hblFlg = hblFlg;
		this.updDt = updDt;
		this.inlndYdEdiSndCd = inlndYdEdiSndCd;
		this.inlndYdEdiSndFlg = inlndYdEdiSndFlg;
		this.oblRdemLstDt = oblRdemLstDt;
		this.cstmsClrCd = cstmsClrCd;
		this.mrnTmlEdiSndFlg = mrnTmlEdiSndFlg;
		this.oblRdemFlg = oblRdemFlg;
		this.cstmsDspoCd = cstmsDspoCd;
		this.inlndYdEdiRcvId = inlndYdEdiRcvId;
		this.inlndYdEdiLstScsFlg = inlndYdEdiLstScsFlg;
		this.creUsrId = creUsrId;
		this.inlndYdEdiLstSndDt = inlndYdEdiLstSndDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mrn_tml_edi_snd_cd", getMrnTmlEdiSndCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("inlnd_yd_edi_lst_msg_id", getInlndYdEdiLstMsgId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cstms_clr_lst_dt", getCstmsClrLstDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_no_chk", getBlNoChk());
		this.hashColumns.put("frt_clt_flg", getFrtCltFlg());
		this.hashColumns.put("mrn_tml_edi_rcv_id", getMrnTmlEdiRcvId());
		this.hashColumns.put("mrn_tml_edi_lst_scs_flg", getMrnTmlEdiLstScsFlg());
		this.hashColumns.put("mrn_tml_edi_lst_snd_dt", getMrnTmlEdiLstSndDt());
		this.hashColumns.put("mrn_tml_edi_lst_msg_id", getMrnTmlEdiLstMsgId());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("frt_clt_lst_dt", getFrtCltLstDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("hbl_flg", getHblFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("inlnd_yd_edi_snd_cd", getInlndYdEdiSndCd());
		this.hashColumns.put("inlnd_yd_edi_snd_flg", getInlndYdEdiSndFlg());
		this.hashColumns.put("obl_rdem_lst_dt", getOblRdemLstDt());
		this.hashColumns.put("cstms_clr_cd", getCstmsClrCd());
		this.hashColumns.put("mrn_tml_edi_snd_flg", getMrnTmlEdiSndFlg());
		this.hashColumns.put("obl_rdem_flg", getOblRdemFlg());
		this.hashColumns.put("cstms_dspo_cd", getCstmsDspoCd());
		this.hashColumns.put("inlnd_yd_edi_rcv_id", getInlndYdEdiRcvId());
		this.hashColumns.put("inlnd_yd_edi_lst_scs_flg", getInlndYdEdiLstScsFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("inlnd_yd_edi_lst_snd_dt", getInlndYdEdiLstSndDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mrn_tml_edi_snd_cd", "mrnTmlEdiSndCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("inlnd_yd_edi_lst_msg_id", "inlndYdEdiLstMsgId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cstms_clr_lst_dt", "cstmsClrLstDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_no_chk", "blNoChk");
		this.hashFields.put("frt_clt_flg", "frtCltFlg");
		this.hashFields.put("mrn_tml_edi_rcv_id", "mrnTmlEdiRcvId");
		this.hashFields.put("mrn_tml_edi_lst_scs_flg", "mrnTmlEdiLstScsFlg");
		this.hashFields.put("mrn_tml_edi_lst_snd_dt", "mrnTmlEdiLstSndDt");
		this.hashFields.put("mrn_tml_edi_lst_msg_id", "mrnTmlEdiLstMsgId");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("frt_clt_lst_dt", "frtCltLstDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("hbl_flg", "hblFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("inlnd_yd_edi_snd_cd", "inlndYdEdiSndCd");
		this.hashFields.put("inlnd_yd_edi_snd_flg", "inlndYdEdiSndFlg");
		this.hashFields.put("obl_rdem_lst_dt", "oblRdemLstDt");
		this.hashFields.put("cstms_clr_cd", "cstmsClrCd");
		this.hashFields.put("mrn_tml_edi_snd_flg", "mrnTmlEdiSndFlg");
		this.hashFields.put("obl_rdem_flg", "oblRdemFlg");
		this.hashFields.put("cstms_dspo_cd", "cstmsDspoCd");
		this.hashFields.put("inlnd_yd_edi_rcv_id", "inlndYdEdiRcvId");
		this.hashFields.put("inlnd_yd_edi_lst_scs_flg", "inlndYdEdiLstScsFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("inlnd_yd_edi_lst_snd_dt", "inlndYdEdiLstSndDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mrnTmlEdiSndCd
	 */
	public String getMrnTmlEdiSndCd() {
		return this.mrnTmlEdiSndCd;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return inlndYdEdiLstMsgId
	 */
	public String getInlndYdEdiLstMsgId() {
		return this.inlndYdEdiLstMsgId;
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
	 * @return cstmsClrLstDt
	 */
	public String getCstmsClrLstDt() {
		return this.cstmsClrLstDt;
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
	 * @return blNoChk
	 */
	public String getBlNoChk() {
		return this.blNoChk;
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
	 * @return mrnTmlEdiRcvId
	 */
	public String getMrnTmlEdiRcvId() {
		return this.mrnTmlEdiRcvId;
	}
	
	/**
	 * Column Info
	 * @return mrnTmlEdiLstScsFlg
	 */
	public String getMrnTmlEdiLstScsFlg() {
		return this.mrnTmlEdiLstScsFlg;
	}
	
	/**
	 * Column Info
	 * @return mrnTmlEdiLstSndDt
	 */
	public String getMrnTmlEdiLstSndDt() {
		return this.mrnTmlEdiLstSndDt;
	}
	
	/**
	 * Column Info
	 * @return mrnTmlEdiLstMsgId
	 */
	public String getMrnTmlEdiLstMsgId() {
		return this.mrnTmlEdiLstMsgId;
	}
	
	/**
	 * Column Info
	 * @return blNoTp
	 */
	public String getBlNoTp() {
		return this.blNoTp;
	}
	
	/**
	 * Column Info
	 * @return frtCltLstDt
	 */
	public String getFrtCltLstDt() {
		return this.frtCltLstDt;
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
	 * @return hblFlg
	 */
	public String getHblFlg() {
		return this.hblFlg;
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
	 * @return inlndYdEdiSndCd
	 */
	public String getInlndYdEdiSndCd() {
		return this.inlndYdEdiSndCd;
	}
	
	/**
	 * Column Info
	 * @return inlndYdEdiSndFlg
	 */
	public String getInlndYdEdiSndFlg() {
		return this.inlndYdEdiSndFlg;
	}
	
	/**
	 * Column Info
	 * @return oblRdemLstDt
	 */
	public String getOblRdemLstDt() {
		return this.oblRdemLstDt;
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
	 * @return mrnTmlEdiSndFlg
	 */
	public String getMrnTmlEdiSndFlg() {
		return this.mrnTmlEdiSndFlg;
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
	 * @return cstmsDspoCd
	 */
	public String getCstmsDspoCd() {
		return this.cstmsDspoCd;
	}
	
	/**
	 * Column Info
	 * @return inlndYdEdiRcvId
	 */
	public String getInlndYdEdiRcvId() {
		return this.inlndYdEdiRcvId;
	}
	
	/**
	 * Column Info
	 * @return inlndYdEdiLstScsFlg
	 */
	public String getInlndYdEdiLstScsFlg() {
		return this.inlndYdEdiLstScsFlg;
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
	 * @return inlndYdEdiLstSndDt
	 */
	public String getInlndYdEdiLstSndDt() {
		return this.inlndYdEdiLstSndDt;
	}
	

	/**
	 * Column Info
	 * @param mrnTmlEdiSndCd
	 */
	public void setMrnTmlEdiSndCd(String mrnTmlEdiSndCd) {
		this.mrnTmlEdiSndCd = mrnTmlEdiSndCd;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param inlndYdEdiLstMsgId
	 */
	public void setInlndYdEdiLstMsgId(String inlndYdEdiLstMsgId) {
		this.inlndYdEdiLstMsgId = inlndYdEdiLstMsgId;
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
	 * @param cstmsClrLstDt
	 */
	public void setCstmsClrLstDt(String cstmsClrLstDt) {
		this.cstmsClrLstDt = cstmsClrLstDt;
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
	 * @param blNoChk
	 */
	public void setBlNoChk(String blNoChk) {
		this.blNoChk = blNoChk;
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
	 * @param mrnTmlEdiRcvId
	 */
	public void setMrnTmlEdiRcvId(String mrnTmlEdiRcvId) {
		this.mrnTmlEdiRcvId = mrnTmlEdiRcvId;
	}
	
	/**
	 * Column Info
	 * @param mrnTmlEdiLstScsFlg
	 */
	public void setMrnTmlEdiLstScsFlg(String mrnTmlEdiLstScsFlg) {
		this.mrnTmlEdiLstScsFlg = mrnTmlEdiLstScsFlg;
	}
	
	/**
	 * Column Info
	 * @param mrnTmlEdiLstSndDt
	 */
	public void setMrnTmlEdiLstSndDt(String mrnTmlEdiLstSndDt) {
		this.mrnTmlEdiLstSndDt = mrnTmlEdiLstSndDt;
	}
	
	/**
	 * Column Info
	 * @param mrnTmlEdiLstMsgId
	 */
	public void setMrnTmlEdiLstMsgId(String mrnTmlEdiLstMsgId) {
		this.mrnTmlEdiLstMsgId = mrnTmlEdiLstMsgId;
	}
	
	/**
	 * Column Info
	 * @param blNoTp
	 */
	public void setBlNoTp(String blNoTp) {
		this.blNoTp = blNoTp;
	}
	
	/**
	 * Column Info
	 * @param frtCltLstDt
	 */
	public void setFrtCltLstDt(String frtCltLstDt) {
		this.frtCltLstDt = frtCltLstDt;
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
	 * @param hblFlg
	 */
	public void setHblFlg(String hblFlg) {
		this.hblFlg = hblFlg;
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
	 * @param inlndYdEdiSndCd
	 */
	public void setInlndYdEdiSndCd(String inlndYdEdiSndCd) {
		this.inlndYdEdiSndCd = inlndYdEdiSndCd;
	}
	
	/**
	 * Column Info
	 * @param inlndYdEdiSndFlg
	 */
	public void setInlndYdEdiSndFlg(String inlndYdEdiSndFlg) {
		this.inlndYdEdiSndFlg = inlndYdEdiSndFlg;
	}
	
	/**
	 * Column Info
	 * @param oblRdemLstDt
	 */
	public void setOblRdemLstDt(String oblRdemLstDt) {
		this.oblRdemLstDt = oblRdemLstDt;
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
	 * @param mrnTmlEdiSndFlg
	 */
	public void setMrnTmlEdiSndFlg(String mrnTmlEdiSndFlg) {
		this.mrnTmlEdiSndFlg = mrnTmlEdiSndFlg;
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
	 * @param cstmsDspoCd
	 */
	public void setCstmsDspoCd(String cstmsDspoCd) {
		this.cstmsDspoCd = cstmsDspoCd;
	}
	
	/**
	 * Column Info
	 * @param inlndYdEdiRcvId
	 */
	public void setInlndYdEdiRcvId(String inlndYdEdiRcvId) {
		this.inlndYdEdiRcvId = inlndYdEdiRcvId;
	}
	
	/**
	 * Column Info
	 * @param inlndYdEdiLstScsFlg
	 */
	public void setInlndYdEdiLstScsFlg(String inlndYdEdiLstScsFlg) {
		this.inlndYdEdiLstScsFlg = inlndYdEdiLstScsFlg;
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
	 * @param inlndYdEdiLstSndDt
	 */
	public void setInlndYdEdiLstSndDt(String inlndYdEdiLstSndDt) {
		this.inlndYdEdiLstSndDt = inlndYdEdiLstSndDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMrnTmlEdiSndCd(JSPUtil.getParameter(request, "mrn_tml_edi_snd_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setInlndYdEdiLstMsgId(JSPUtil.getParameter(request, "inlnd_yd_edi_lst_msg_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCstmsClrLstDt(JSPUtil.getParameter(request, "cstms_clr_lst_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBlNoChk(JSPUtil.getParameter(request, "bl_no_chk", ""));
		setFrtCltFlg(JSPUtil.getParameter(request, "frt_clt_flg", ""));
		setMrnTmlEdiRcvId(JSPUtil.getParameter(request, "mrn_tml_edi_rcv_id", ""));
		setMrnTmlEdiLstScsFlg(JSPUtil.getParameter(request, "mrn_tml_edi_lst_scs_flg", ""));
		setMrnTmlEdiLstSndDt(JSPUtil.getParameter(request, "mrn_tml_edi_lst_snd_dt", ""));
		setMrnTmlEdiLstMsgId(JSPUtil.getParameter(request, "mrn_tml_edi_lst_msg_id", ""));
		setBlNoTp(JSPUtil.getParameter(request, "bl_no_tp", ""));
		setFrtCltLstDt(JSPUtil.getParameter(request, "frt_clt_lst_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setHblFlg(JSPUtil.getParameter(request, "hbl_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setInlndYdEdiSndCd(JSPUtil.getParameter(request, "inlnd_yd_edi_snd_cd", ""));
		setInlndYdEdiSndFlg(JSPUtil.getParameter(request, "inlnd_yd_edi_snd_flg", ""));
		setOblRdemLstDt(JSPUtil.getParameter(request, "obl_rdem_lst_dt", ""));
		setCstmsClrCd(JSPUtil.getParameter(request, "cstms_clr_cd", ""));
		setMrnTmlEdiSndFlg(JSPUtil.getParameter(request, "mrn_tml_edi_snd_flg", ""));
		setOblRdemFlg(JSPUtil.getParameter(request, "obl_rdem_flg", ""));
		setCstmsDspoCd(JSPUtil.getParameter(request, "cstms_dspo_cd", ""));
		setInlndYdEdiRcvId(JSPUtil.getParameter(request, "inlnd_yd_edi_rcv_id", ""));
		setInlndYdEdiLstScsFlg(JSPUtil.getParameter(request, "inlnd_yd_edi_lst_scs_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setInlndYdEdiLstSndDt(JSPUtil.getParameter(request, "inlnd_yd_edi_lst_snd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgFocVO[]
	 */
	public FocVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgFocVO[]
	 */
	public FocVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FocVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mrnTmlEdiSndCd = (JSPUtil.getParameter(request, prefix	+ "mrn_tml_edi_snd_cd".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] inlndYdEdiLstMsgId = (JSPUtil.getParameter(request, prefix	+ "inlnd_yd_edi_lst_msg_id".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] cstmsClrLstDt = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_lst_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] blNoChk = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk".trim(), length));
			String[] frtCltFlg = (JSPUtil.getParameter(request, prefix	+ "frt_clt_flg".trim(), length));
			String[] mrnTmlEdiRcvId = (JSPUtil.getParameter(request, prefix	+ "mrn_tml_edi_rcv_id".trim(), length));
			String[] mrnTmlEdiLstScsFlg = (JSPUtil.getParameter(request, prefix	+ "mrn_tml_edi_lst_scs_flg".trim(), length));
			String[] mrnTmlEdiLstSndDt = (JSPUtil.getParameter(request, prefix	+ "mrn_tml_edi_lst_snd_dt".trim(), length));
			String[] mrnTmlEdiLstMsgId = (JSPUtil.getParameter(request, prefix	+ "mrn_tml_edi_lst_msg_id".trim(), length));
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp".trim(), length));
			String[] frtCltLstDt = (JSPUtil.getParameter(request, prefix	+ "frt_clt_lst_dt".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] hblFlg = (JSPUtil.getParameter(request, prefix	+ "hbl_flg".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] inlndYdEdiSndCd = (JSPUtil.getParameter(request, prefix	+ "inlnd_yd_edi_snd_cd".trim(), length));
			String[] inlndYdEdiSndFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_yd_edi_snd_flg".trim(), length));
			String[] oblRdemLstDt = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_lst_dt".trim(), length));
			String[] cstmsClrCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_cd".trim(), length));
			String[] mrnTmlEdiSndFlg = (JSPUtil.getParameter(request, prefix	+ "mrn_tml_edi_snd_flg".trim(), length));
			String[] oblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_flg".trim(), length));
			String[] cstmsDspoCd = (JSPUtil.getParameter(request, prefix	+ "cstms_dspo_cd".trim(), length));
			String[] inlndYdEdiRcvId = (JSPUtil.getParameter(request, prefix	+ "inlnd_yd_edi_rcv_id".trim(), length));
			String[] inlndYdEdiLstScsFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_yd_edi_lst_scs_flg".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] inlndYdEdiLstSndDt = (JSPUtil.getParameter(request, prefix	+ "inlnd_yd_edi_lst_snd_dt".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new FocVO();
				if (mrnTmlEdiSndCd[i] != null)
					model.setMrnTmlEdiSndCd(mrnTmlEdiSndCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (inlndYdEdiLstMsgId[i] != null)
					model.setInlndYdEdiLstMsgId(inlndYdEdiLstMsgId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cstmsClrLstDt[i] != null)
					model.setCstmsClrLstDt(cstmsClrLstDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blNoChk[i] != null)
					model.setBlNoChk(blNoChk[i]);
				if (frtCltFlg[i] != null)
					model.setFrtCltFlg(frtCltFlg[i]);
				if (mrnTmlEdiRcvId[i] != null)
					model.setMrnTmlEdiRcvId(mrnTmlEdiRcvId[i]);
				if (mrnTmlEdiLstScsFlg[i] != null)
					model.setMrnTmlEdiLstScsFlg(mrnTmlEdiLstScsFlg[i]);
				if (mrnTmlEdiLstSndDt[i] != null)
					model.setMrnTmlEdiLstSndDt(mrnTmlEdiLstSndDt[i]);
				if (mrnTmlEdiLstMsgId[i] != null)
					model.setMrnTmlEdiLstMsgId(mrnTmlEdiLstMsgId[i]);
				if (blNoTp[i] != null)
					model.setBlNoTp(blNoTp[i]);
				if (frtCltLstDt[i] != null)
					model.setFrtCltLstDt(frtCltLstDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (hblFlg[i] != null)
					model.setHblFlg(hblFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (inlndYdEdiSndCd[i] != null)
					model.setInlndYdEdiSndCd(inlndYdEdiSndCd[i]);
				if (inlndYdEdiSndFlg[i] != null)
					model.setInlndYdEdiSndFlg(inlndYdEdiSndFlg[i]);
				if (oblRdemLstDt[i] != null)
					model.setOblRdemLstDt(oblRdemLstDt[i]);
				if (cstmsClrCd[i] != null)
					model.setCstmsClrCd(cstmsClrCd[i]);
				if (mrnTmlEdiSndFlg[i] != null)
					model.setMrnTmlEdiSndFlg(mrnTmlEdiSndFlg[i]);
				if (oblRdemFlg[i] != null)
					model.setOblRdemFlg(oblRdemFlg[i]);
				if (cstmsDspoCd[i] != null)
					model.setCstmsDspoCd(cstmsDspoCd[i]);
				if (inlndYdEdiRcvId[i] != null)
					model.setInlndYdEdiRcvId(inlndYdEdiRcvId[i]);
				if (inlndYdEdiLstScsFlg[i] != null)
					model.setInlndYdEdiLstScsFlg(inlndYdEdiLstScsFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (inlndYdEdiLstSndDt[i] != null)
					model.setInlndYdEdiLstSndDt(inlndYdEdiLstSndDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgFocVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgFocVO[]
	 */
	public FocVO[] getBkgFocVOs(){
		FocVO[] vos = (FocVO[])models.toArray(new FocVO[models.size()]);
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
		this.mrnTmlEdiSndCd = this.mrnTmlEdiSndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndYdEdiLstMsgId = this.inlndYdEdiLstMsgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrLstDt = this.cstmsClrLstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoChk = this.blNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltFlg = this.frtCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnTmlEdiRcvId = this.mrnTmlEdiRcvId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnTmlEdiLstScsFlg = this.mrnTmlEdiLstScsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnTmlEdiLstSndDt = this.mrnTmlEdiLstSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnTmlEdiLstMsgId = this.mrnTmlEdiLstMsgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltLstDt = this.frtCltLstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblFlg = this.hblFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndYdEdiSndCd = this.inlndYdEdiSndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndYdEdiSndFlg = this.inlndYdEdiSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemLstDt = this.oblRdemLstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrCd = this.cstmsClrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnTmlEdiSndFlg = this.mrnTmlEdiSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemFlg = this.oblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDspoCd = this.cstmsDspoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndYdEdiRcvId = this.inlndYdEdiRcvId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndYdEdiLstScsFlg = this.inlndYdEdiLstScsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndYdEdiLstSndDt = this.inlndYdEdiLstSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
