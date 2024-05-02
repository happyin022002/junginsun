/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VvdJapanTerminalEdiVO.java
*@FileTitle : VvdJapanTerminalEdiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.29
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.03.29 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VvdJapanTerminalEdiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VvdJapanTerminalEdiVO> models = new ArrayList<VvdJapanTerminalEdiVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String bePorYdCd = null;
	/* Column Info */
	private String ediSndUsrId = null;
	/* Column Info */
	private String batSkdPrdFmDt = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String porYdCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String bePolYdCd = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String ediSndOfcCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDeltFlg = null;
	/* Column Info */
	private String otrNtfyYdCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String delChk = null;
	/* Column Info */
	private String batSkdPrdToDt = null;
	/* Column Info */
	private String saveFlg = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String deltUsrId = null;
	/* Column Info */
	private String chkVslFlg = null;
	/* Column Info */
	private String jpTmlVslNo = null;
	/* Column Info */
	private String createDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VvdJapanTerminalEdiVO() {}

	public VvdJapanTerminalEdiVO(String ibflag, String pagerows, String jpTmlVslNo, String createDt, String chkVslFlg, String porCd, String vslCd, String ediSndUsrId, String batSkdPrdFmDt, String creDt, String porYdCd, String polCd, String vvdCd, String updUsrId, String updDt, String callSgnNo, String ediSndOfcCd, String skdVoyNo, String skdDeltFlg, String otrNtfyYdCd, String skdDirCd, String delChk, String batSkdPrdToDt, String saveFlg, String bkgNo, String creUsrId, String polYdCd, String deltUsrId, String bePolYdCd, String bePorYdCd) {
		this.porCd = porCd;
		this.vslCd = vslCd;
		this.bePorYdCd = bePorYdCd;
		this.ediSndUsrId = ediSndUsrId;
		this.batSkdPrdFmDt = batSkdPrdFmDt;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.porYdCd = porYdCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.bePolYdCd = bePolYdCd;
		this.callSgnNo = callSgnNo;
		this.ediSndOfcCd = ediSndOfcCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDeltFlg = skdDeltFlg;
		this.otrNtfyYdCd = otrNtfyYdCd;
		this.skdDirCd = skdDirCd;
		this.delChk = delChk;
		this.batSkdPrdToDt = batSkdPrdToDt;
		this.saveFlg = saveFlg;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.polYdCd = polYdCd;
		this.deltUsrId = deltUsrId;
		this.chkVslFlg = chkVslFlg;
		this.jpTmlVslNo = jpTmlVslNo;
		this.createDt = createDt;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("be_por_yd_cd", getBePorYdCd());
		this.hashColumns.put("edi_snd_usr_id", getEdiSndUsrId());
		this.hashColumns.put("bat_skd_prd_fm_dt", getBatSkdPrdFmDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("por_yd_cd", getPorYdCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("be_pol_yd_cd", getBePolYdCd());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("edi_snd_ofc_cd", getEdiSndOfcCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_delt_flg", getSkdDeltFlg());
		this.hashColumns.put("otr_ntfy_yd_cd", getOtrNtfyYdCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("del_chk", getDelChk());
		this.hashColumns.put("bat_skd_prd_to_dt", getBatSkdPrdToDt());
		this.hashColumns.put("save_flg", getSaveFlg());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("delt_usr_id", getDeltUsrId());
		this.hashColumns.put("chk_vsl_flg", getChkVslFlg());
		this.hashColumns.put("jp_tml_vsl_no", getJpTmlVslNo());
		this.hashColumns.put("create_dt", getCreateDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("be_por_yd_cd", "bePorYdCd");
		this.hashFields.put("edi_snd_usr_id", "ediSndUsrId");
		this.hashFields.put("bat_skd_prd_fm_dt", "batSkdPrdFmDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("por_yd_cd", "porYdCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("be_pol_yd_cd", "bePolYdCd");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("edi_snd_ofc_cd", "ediSndOfcCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_delt_flg", "skdDeltFlg");
		this.hashFields.put("otr_ntfy_yd_cd", "otrNtfyYdCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("del_chk", "delChk");
		this.hashFields.put("bat_skd_prd_to_dt", "batSkdPrdToDt");
		this.hashFields.put("save_flg", "saveFlg");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("delt_usr_id", "deltUsrId");
		this.hashFields.put("chk_vsl_flg", "chkVslFlg");
		this.hashFields.put("jp_tml_vsl_no", "jpTmlVslNo");
		this.hashFields.put("create_dt", "createDt");
		
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return createDt
	 */
	public String getCreateDt() {
		return this.createDt;
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return bePorYdCd
	 */
	public String getBePorYdCd() {
		return this.bePorYdCd;
	}
	
	/**
	 * Column Info
	 * @return ediSndUsrId
	 */
	public String getEdiSndUsrId() {
		return this.ediSndUsrId;
	}
	
	/**
	 * Column Info
	 * @return batSkdPrdFmDt
	 */
	public String getBatSkdPrdFmDt() {
		return this.batSkdPrdFmDt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return porYdCd
	 */
	public String getPorYdCd() {
		return this.porYdCd;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return bePolYdCd
	 */
	public String getBePolYdCd() {
		return this.bePolYdCd;
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
	 * @return ediSndOfcCd
	 */
	public String getEdiSndOfcCd() {
		return this.ediSndOfcCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return skdDeltFlg
	 */
	public String getSkdDeltFlg() {
		return this.skdDeltFlg;
	}
	
	/**
	 * Column Info
	 * @return otrNtfyYdCd
	 */
	public String getOtrNtfyYdCd() {
		return this.otrNtfyYdCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return delChk
	 */
	public String getDelChk() {
		return this.delChk;
	}
	
	/**
	 * Column Info
	 * @return batSkdPrdToDt
	 */
	public String getBatSkdPrdToDt() {
		return this.batSkdPrdToDt;
	}
	
	/**
	 * Column Info
	 * @return saveFlg
	 */
	public String getSaveFlg() {
		return this.saveFlg;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return deltUsrId
	 */
	public String getDeltUsrId() {
		return this.deltUsrId;
	}
	
	/**
	 * Column Info
	 * @return deltUsrId
	 */
	public String getChkVslFlg() {
		return this.chkVslFlg;
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
	 * @param createDt
	 */
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param bePorYdCd
	 */
	public void setBePorYdCd(String bePorYdCd) {
		this.bePorYdCd = bePorYdCd;
	}
	
	/**
	 * Column Info
	 * @param ediSndUsrId
	 */
	public void setEdiSndUsrId(String ediSndUsrId) {
		this.ediSndUsrId = ediSndUsrId;
	}
	
	/**
	 * Column Info
	 * @param batSkdPrdFmDt
	 */
	public void setBatSkdPrdFmDt(String batSkdPrdFmDt) {
		this.batSkdPrdFmDt = batSkdPrdFmDt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param porYdCd
	 */
	public void setPorYdCd(String porYdCd) {
		this.porYdCd = porYdCd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param bePolYdCd
	 */
	public void setBePolYdCd(String bePolYdCd) {
		this.bePolYdCd = bePolYdCd;
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
	 * @param ediSndOfcCd
	 */
	public void setEdiSndOfcCd(String ediSndOfcCd) {
		this.ediSndOfcCd = ediSndOfcCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param skdDeltFlg
	 */
	public void setSkdDeltFlg(String skdDeltFlg) {
		this.skdDeltFlg = skdDeltFlg;
	}
	
	/**
	 * Column Info
	 * @param otrNtfyYdCd
	 */
	public void setOtrNtfyYdCd(String otrNtfyYdCd) {
		this.otrNtfyYdCd = otrNtfyYdCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param delChk
	 */
	public void setDelChk(String delChk) {
		this.delChk = delChk;
	}
	
	/**
	 * Column Info
	 * @param batSkdPrdToDt
	 */
	public void setBatSkdPrdToDt(String batSkdPrdToDt) {
		this.batSkdPrdToDt = batSkdPrdToDt;
	}
	
	/**
	 * Column Info
	 * @param saveFlg
	 */
	public void setSaveFlg(String saveFlg) {
		this.saveFlg = saveFlg;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param deltUsrId
	 */
	public void setDeltUsrId(String deltUsrId) {
		this.deltUsrId = deltUsrId;
	}
	
	/**
	 * Column Info
	 * @param chkVslFlg
	 */
	public void setChkVslFlg(String chkVslFlg) {
		this.chkVslFlg = chkVslFlg;
	}
	
	/**
	 * Column Info
	 * @param sSkdVoyNo
	 */
	public void setJpTmlVslNo(String jpTmlVslNo) {
		this.jpTmlVslNo = jpTmlVslNo;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setBePorYdCd(JSPUtil.getParameter(request, prefix + "be_por_yd_cd", ""));
		setEdiSndUsrId(JSPUtil.getParameter(request, prefix + "edi_snd_usr_id", ""));
		setBatSkdPrdFmDt(JSPUtil.getParameter(request, prefix + "bat_skd_prd_fm_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPorYdCd(JSPUtil.getParameter(request, prefix + "por_yd_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setBePolYdCd(JSPUtil.getParameter(request, prefix + "be_pol_yd_cd", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setEdiSndOfcCd(JSPUtil.getParameter(request, prefix + "edi_snd_ofc_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDeltFlg(JSPUtil.getParameter(request, prefix + "skd_delt_flg", ""));
		setOtrNtfyYdCd(JSPUtil.getParameter(request, prefix + "otr_ntfy_yd_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setDelChk(JSPUtil.getParameter(request, prefix + "del_chk", ""));
		setBatSkdPrdToDt(JSPUtil.getParameter(request, prefix + "bat_skd_prd_to_dt", ""));
		setSaveFlg(JSPUtil.getParameter(request, prefix + "save_flg", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setDeltUsrId(JSPUtil.getParameter(request, prefix + "delt_usr_id", ""));
		setChkVslFlg(JSPUtil.getParameter(request, prefix + "chk_vsl_flg", ""));
		setJpTmlVslNo(JSPUtil.getParameter(request, prefix + "jp_tml_vsl_no", ""));
		setCreateDt(JSPUtil.getParameter(request, prefix + "create_dt", ""));
		
		
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VvdJapanTerminalEdiVO[]
	 */
	public VvdJapanTerminalEdiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VvdJapanTerminalEdiVO[]
	 */
	public VvdJapanTerminalEdiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VvdJapanTerminalEdiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] bePorYdCd = (JSPUtil.getParameter(request, prefix	+ "be_por_yd_cd", length));
			String[] ediSndUsrId = (JSPUtil.getParameter(request, prefix	+ "edi_snd_usr_id", length));
			String[] batSkdPrdFmDt = (JSPUtil.getParameter(request, prefix	+ "bat_skd_prd_fm_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] porYdCd = (JSPUtil.getParameter(request, prefix	+ "por_yd_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] bePolYdCd = (JSPUtil.getParameter(request, prefix	+ "be_pol_yd_cd", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] ediSndOfcCd = (JSPUtil.getParameter(request, prefix	+ "edi_snd_ofc_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDeltFlg = (JSPUtil.getParameter(request, prefix	+ "skd_delt_flg", length));
			String[] otrNtfyYdCd = (JSPUtil.getParameter(request, prefix	+ "otr_ntfy_yd_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] delChk = (JSPUtil.getParameter(request, prefix	+ "del_chk", length));
			String[] batSkdPrdToDt = (JSPUtil.getParameter(request, prefix	+ "bat_skd_prd_to_dt", length));
			String[] saveFlg = (JSPUtil.getParameter(request, prefix	+ "save_flg", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] deltUsrId = (JSPUtil.getParameter(request, prefix	+ "delt_usr_id", length));
			String[] chkVslFlg = (JSPUtil.getParameter(request, prefix	+ "chk_vsl_flg", length));
			String[] jpTmlVslNo = (JSPUtil.getParameter(request, prefix	+ "jp_tml_vsl_no", length));
			String[] createDt = (JSPUtil.getParameter(request, prefix	+ "create_dt", length));
			
					
			for (int i = 0; i < length; i++) {
				model = new VvdJapanTerminalEdiVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (bePorYdCd[i] != null)
					model.setBePorYdCd(bePorYdCd[i]);
				if (ediSndUsrId[i] != null)
					model.setEdiSndUsrId(ediSndUsrId[i]);
				if (batSkdPrdFmDt[i] != null)
					model.setBatSkdPrdFmDt(batSkdPrdFmDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (porYdCd[i] != null)
					model.setPorYdCd(porYdCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (bePolYdCd[i] != null)
					model.setBePolYdCd(bePolYdCd[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (ediSndOfcCd[i] != null)
					model.setEdiSndOfcCd(ediSndOfcCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDeltFlg[i] != null)
					model.setSkdDeltFlg(skdDeltFlg[i]);
				if (otrNtfyYdCd[i] != null)
					model.setOtrNtfyYdCd(otrNtfyYdCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (delChk[i] != null)
					model.setDelChk(delChk[i]);
				if (batSkdPrdToDt[i] != null)
					model.setBatSkdPrdToDt(batSkdPrdToDt[i]);
				if (saveFlg[i] != null)
					model.setSaveFlg(saveFlg[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (deltUsrId[i] != null)
					model.setDeltUsrId(deltUsrId[i]);
				if (chkVslFlg[i] != null)
					model.setChkVslFlg(chkVslFlg[i]);
				if (jpTmlVslNo[i] != null)
					model.setJpTmlVslNo(jpTmlVslNo[i]);
				if (createDt[i] != null)
					model.setCreateDt(createDt[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVvdJapanTerminalEdiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VvdJapanTerminalEdiVO[]
	 */
	public VvdJapanTerminalEdiVO[] getVvdJapanTerminalEdiVOs(){
		VvdJapanTerminalEdiVO[] vos = (VvdJapanTerminalEdiVO[])models.toArray(new VvdJapanTerminalEdiVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bePorYdCd = this.bePorYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndUsrId = this.ediSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batSkdPrdFmDt = this.batSkdPrdFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porYdCd = this.porYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bePolYdCd = this.bePolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndOfcCd = this.ediSndOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDeltFlg = this.skdDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrNtfyYdCd = this.otrNtfyYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delChk = this.delChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batSkdPrdToDt = this.batSkdPrdToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveFlg = this.saveFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltUsrId = this.deltUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkVslFlg = this.chkVslFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpTmlVslNo = this.jpTmlVslNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.createDt = this.createDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		
	}
}
