/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StorageCalExcepNodeVO.java
*@FileTitle : StorageCalExcepNodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.27
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2015.08.27 최덕우 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최덕우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class StorageCalExcepNodeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<StorageCalExcepNodeVO> models = new ArrayList<StorageCalExcepNodeVO>();
	
	/* Column Info */
	private String tmpFCtrlOfcCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String expCustCd = null;
	/* Column Info */
	private String ctrlOfcCdOrg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String nodNm = null;
	/* Column Info */
	private String obNodTp = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ibStoFlgOrg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fRdodelflg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ibNodTp = null;
	/* Column Info */
	private String rmk = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ibStoFlg = null;
	/* Column Info */
	private String obStoFlgOrg = null;
	/* Column Info */
	private String masUcFlg = null;
	/* Column Info */
	private String nodCdOrg = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String fCtrlOfcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fNodNm = null;
	/* Column Info */
	private String fExpCustCd = null;
	/* Column Info */
	private String fNodCd = null;
	/* Column Info */
	private String obStoFlg = null;
	/* Column Info */
	private String nodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public StorageCalExcepNodeVO() {}

	public StorageCalExcepNodeVO(String ibflag, String pagerows, String tmpFCtrlOfcCd, String updDt, String ibStoFlg, String deltFlg, String ctrlOfcCdOrg, String expCustCd, String creDt, String obStoFlgOrg, String nodCdOrg, String masUcFlg, String nodNm, String ctrlOfcCd, String ibStoFlgOrg, String fCtrlOfcCd, String creUsrId, String fNodNm, String fExpCustCd, String fRdodelflg, String fNodCd, String obStoFlg, String nodCd, String updUsrId, String ibNodTp, String obNodTp, String rmk) {
		this.tmpFCtrlOfcCd = tmpFCtrlOfcCd;
		this.deltFlg = deltFlg;
		this.expCustCd = expCustCd;
		this.ctrlOfcCdOrg = ctrlOfcCdOrg;
		this.creDt = creDt;
		this.nodNm = nodNm;
		this.obNodTp = obNodTp;
		this.pagerows = pagerows;
		this.ibStoFlgOrg = ibStoFlgOrg;
		this.ibflag = ibflag;
		this.fRdodelflg = fRdodelflg;
		this.updUsrId = updUsrId;
		this.ibNodTp = ibNodTp;
		this.rmk = rmk;
		this.updDt = updDt;
		this.ibStoFlg = ibStoFlg;
		this.obStoFlgOrg = obStoFlgOrg;
		this.masUcFlg = masUcFlg;
		this.nodCdOrg = nodCdOrg;
		this.ctrlOfcCd = ctrlOfcCd;
		this.fCtrlOfcCd = fCtrlOfcCd;
		this.creUsrId = creUsrId;
		this.fNodNm = fNodNm;
		this.fExpCustCd = fExpCustCd;
		this.fNodCd = fNodCd;
		this.obStoFlg = obStoFlg;
		this.nodCd = nodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tmp_f_ctrl_ofc_cd", getTmpFCtrlOfcCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("exp_cust_cd", getExpCustCd());
		this.hashColumns.put("ctrl_ofc_cd_org", getCtrlOfcCdOrg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("nod_nm", getNodNm());
		this.hashColumns.put("ob_nod_tp", getObNodTp());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ib_sto_flg_org", getIbStoFlgOrg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_rdodelflg", getFRdodelflg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ib_nod_tp", getIbNodTp());
		this.hashColumns.put("rmk", getRmk());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ib_sto_flg", getIbStoFlg());
		this.hashColumns.put("ob_sto_flg_org", getObStoFlgOrg());
		this.hashColumns.put("mas_uc_flg", getMasUcFlg());
		this.hashColumns.put("nod_cd_org", getNodCdOrg());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("f_ctrl_ofc_cd", getFCtrlOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("f_nod_nm", getFNodNm());
		this.hashColumns.put("f_exp_cust_cd", getFExpCustCd());
		this.hashColumns.put("f_nod_cd", getFNodCd());
		this.hashColumns.put("ob_sto_flg", getObStoFlg());
		this.hashColumns.put("nod_cd", getNodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tmp_f_ctrl_ofc_cd", "tmpFCtrlOfcCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("exp_cust_cd", "expCustCd");
		this.hashFields.put("ctrl_ofc_cd_org", "ctrlOfcCdOrg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("nod_nm", "nodNm");
		this.hashFields.put("ob_nod_tp", "obNodTp");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ib_sto_flg_org", "ibStoFlgOrg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_rdodelflg", "fRdodelflg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ib_nod_tp", "ibNodTp");
		this.hashFields.put("rmk", "rmk");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ib_sto_flg", "ibStoFlg");
		this.hashFields.put("ob_sto_flg_org", "obStoFlgOrg");
		this.hashFields.put("mas_uc_flg", "masUcFlg");
		this.hashFields.put("nod_cd_org", "nodCdOrg");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("f_ctrl_ofc_cd", "fCtrlOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("f_nod_nm", "fNodNm");
		this.hashFields.put("f_exp_cust_cd", "fExpCustCd");
		this.hashFields.put("f_nod_cd", "fNodCd");
		this.hashFields.put("ob_sto_flg", "obStoFlg");
		this.hashFields.put("nod_cd", "nodCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tmpFCtrlOfcCd
	 */
	public String getTmpFCtrlOfcCd() {
		return this.tmpFCtrlOfcCd;
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
	 * @return expCustCd
	 */
	public String getExpCustCd() {
		return this.expCustCd;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCdOrg
	 */
	public String getCtrlOfcCdOrg() {
		return this.ctrlOfcCdOrg;
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
	 * @return nodNm
	 */
	public String getNodNm() {
		return this.nodNm;
	}
	
	/**
	 * Column Info
	 * @return obNodTp
	 */
	public String getObNodTp() {
		return this.obNodTp;
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
	 * @return ibStoFlgOrg
	 */
	public String getIbStoFlgOrg() {
		return this.ibStoFlgOrg;
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
	 * @return fRdodelflg
	 */
	public String getFRdodelflg() {
		return this.fRdodelflg;
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
	 * @return ibNodTp
	 */
	public String getIbNodTp() {
		return this.ibNodTp;
	}
	
	/**
	 * Column Info
	 * @return rmk
	 */
	public String getRmk() {
		return this.rmk;
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
	 * @return ibStoFlg
	 */
	public String getIbStoFlg() {
		return this.ibStoFlg;
	}
	
	/**
	 * Column Info
	 * @return obStoFlgOrg
	 */
	public String getObStoFlgOrg() {
		return this.obStoFlgOrg;
	}
	
	/**
	 * Column Info
	 * @return masUcFlg
	 */
	public String getMasUcFlg() {
		return this.masUcFlg;
	}
	
	/**
	 * Column Info
	 * @return nodCdOrg
	 */
	public String getNodCdOrg() {
		return this.nodCdOrg;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fCtrlOfcCd
	 */
	public String getFCtrlOfcCd() {
		return this.fCtrlOfcCd;
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
	 * @return fNodNm
	 */
	public String getFNodNm() {
		return this.fNodNm;
	}
	
	/**
	 * Column Info
	 * @return fExpCustCd
	 */
	public String getFExpCustCd() {
		return this.fExpCustCd;
	}
	
	/**
	 * Column Info
	 * @return fNodCd
	 */
	public String getFNodCd() {
		return this.fNodCd;
	}
	
	/**
	 * Column Info
	 * @return obStoFlg
	 */
	public String getObStoFlg() {
		return this.obStoFlg;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	

	/**
	 * Column Info
	 * @param tmpFCtrlOfcCd
	 */
	public void setTmpFCtrlOfcCd(String tmpFCtrlOfcCd) {
		this.tmpFCtrlOfcCd = tmpFCtrlOfcCd;
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
	 * @param expCustCd
	 */
	public void setExpCustCd(String expCustCd) {
		this.expCustCd = expCustCd;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCdOrg
	 */
	public void setCtrlOfcCdOrg(String ctrlOfcCdOrg) {
		this.ctrlOfcCdOrg = ctrlOfcCdOrg;
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
	 * @param nodNm
	 */
	public void setNodNm(String nodNm) {
		this.nodNm = nodNm;
	}
	
	/**
	 * Column Info
	 * @param obNodTp
	 */
	public void setObNodTp(String obNodTp) {
		this.obNodTp = obNodTp;
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
	 * @param ibStoFlgOrg
	 */
	public void setIbStoFlgOrg(String ibStoFlgOrg) {
		this.ibStoFlgOrg = ibStoFlgOrg;
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
	 * @param fRdodelflg
	 */
	public void setFRdodelflg(String fRdodelflg) {
		this.fRdodelflg = fRdodelflg;
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
	 * @param ibNodTp
	 */
	public void setIbNodTp(String ibNodTp) {
		this.ibNodTp = ibNodTp;
	}
	
	/**
	 * Column Info
	 * @param rmk
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
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
	 * @param ibStoFlg
	 */
	public void setIbStoFlg(String ibStoFlg) {
		this.ibStoFlg = ibStoFlg;
	}
	
	/**
	 * Column Info
	 * @param obStoFlgOrg
	 */
	public void setObStoFlgOrg(String obStoFlgOrg) {
		this.obStoFlgOrg = obStoFlgOrg;
	}
	
	/**
	 * Column Info
	 * @param masUcFlg
	 */
	public void setMasUcFlg(String masUcFlg) {
		this.masUcFlg = masUcFlg;
	}
	
	/**
	 * Column Info
	 * @param nodCdOrg
	 */
	public void setNodCdOrg(String nodCdOrg) {
		this.nodCdOrg = nodCdOrg;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fCtrlOfcCd
	 */
	public void setFCtrlOfcCd(String fCtrlOfcCd) {
		this.fCtrlOfcCd = fCtrlOfcCd;
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
	 * @param fNodNm
	 */
	public void setFNodNm(String fNodNm) {
		this.fNodNm = fNodNm;
	}
	
	/**
	 * Column Info
	 * @param fExpCustCd
	 */
	public void setFExpCustCd(String fExpCustCd) {
		this.fExpCustCd = fExpCustCd;
	}
	
	/**
	 * Column Info
	 * @param fNodCd
	 */
	public void setFNodCd(String fNodCd) {
		this.fNodCd = fNodCd;
	}
	
	/**
	 * Column Info
	 * @param obStoFlg
	 */
	public void setObStoFlg(String obStoFlg) {
		this.obStoFlg = obStoFlg;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
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
		setTmpFCtrlOfcCd(JSPUtil.getParameter(request, prefix + "tmp_f_ctrl_ofc_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setExpCustCd(JSPUtil.getParameter(request, prefix + "exp_cust_cd", ""));
		setCtrlOfcCdOrg(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_org", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setNodNm(JSPUtil.getParameter(request, prefix + "nod_nm", ""));
		setObNodTp(JSPUtil.getParameter(request, prefix + "ob_nod_tp", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbStoFlgOrg(JSPUtil.getParameter(request, prefix + "ib_sto_flg_org", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFRdodelflg(JSPUtil.getParameter(request, prefix + "f_rdodelflg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setIbNodTp(JSPUtil.getParameter(request, prefix + "ib_nod_tp", ""));
		setRmk(JSPUtil.getParameter(request, prefix + "rmk", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setIbStoFlg(JSPUtil.getParameter(request, prefix + "ib_sto_flg", ""));
		setObStoFlgOrg(JSPUtil.getParameter(request, prefix + "ob_sto_flg_org", ""));
		setMasUcFlg(JSPUtil.getParameter(request, prefix + "mas_uc_flg", ""));
		setNodCdOrg(JSPUtil.getParameter(request, prefix + "nod_cd_org", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd", ""));
		setFCtrlOfcCd(JSPUtil.getParameter(request, prefix + "f_ctrl_ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFNodNm(JSPUtil.getParameter(request, prefix + "f_nod_nm", ""));
		setFExpCustCd(JSPUtil.getParameter(request, prefix + "f_exp_cust_cd", ""));
		setFNodCd(JSPUtil.getParameter(request, prefix + "f_nod_cd", ""));
		setObStoFlg(JSPUtil.getParameter(request, prefix + "ob_sto_flg", ""));
		setNodCd(JSPUtil.getParameter(request, prefix + "nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StorageCalExcepNodeVO[]
	 */
	public StorageCalExcepNodeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StorageCalExcepNodeVO[]
	 */
	public StorageCalExcepNodeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StorageCalExcepNodeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tmpFCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "tmp_f_ctrl_ofc_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] expCustCd = (JSPUtil.getParameter(request, prefix	+ "exp_cust_cd", length));
			String[] ctrlOfcCdOrg = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_org", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] nodNm = (JSPUtil.getParameter(request, prefix	+ "nod_nm", length));
			String[] obNodTp = (JSPUtil.getParameter(request, prefix	+ "ob_nod_tp", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibStoFlgOrg = (JSPUtil.getParameter(request, prefix	+ "ib_sto_flg_org", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fRdodelflg = (JSPUtil.getParameter(request, prefix	+ "f_rdodelflg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ibNodTp = (JSPUtil.getParameter(request, prefix	+ "ib_nod_tp", length));
			String[] rmk = (JSPUtil.getParameter(request, prefix	+ "rmk", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ibStoFlg = (JSPUtil.getParameter(request, prefix	+ "ib_sto_flg", length));
			String[] obStoFlgOrg = (JSPUtil.getParameter(request, prefix	+ "ob_sto_flg_org", length));
			String[] masUcFlg = (JSPUtil.getParameter(request, prefix	+ "mas_uc_flg", length));
			String[] nodCdOrg = (JSPUtil.getParameter(request, prefix	+ "nod_cd_org", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] fCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_ctrl_ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fNodNm = (JSPUtil.getParameter(request, prefix	+ "f_nod_nm", length));
			String[] fExpCustCd = (JSPUtil.getParameter(request, prefix	+ "f_exp_cust_cd", length));
			String[] fNodCd = (JSPUtil.getParameter(request, prefix	+ "f_nod_cd", length));
			String[] obStoFlg = (JSPUtil.getParameter(request, prefix	+ "ob_sto_flg", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new StorageCalExcepNodeVO();
				if (tmpFCtrlOfcCd[i] != null)
					model.setTmpFCtrlOfcCd(tmpFCtrlOfcCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (expCustCd[i] != null)
					model.setExpCustCd(expCustCd[i]);
				if (ctrlOfcCdOrg[i] != null)
					model.setCtrlOfcCdOrg(ctrlOfcCdOrg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (nodNm[i] != null)
					model.setNodNm(nodNm[i]);
				if (obNodTp[i] != null)
					model.setObNodTp(obNodTp[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibStoFlgOrg[i] != null)
					model.setIbStoFlgOrg(ibStoFlgOrg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fRdodelflg[i] != null)
					model.setFRdodelflg(fRdodelflg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ibNodTp[i] != null)
					model.setIbNodTp(ibNodTp[i]);
				if (rmk[i] != null)
					model.setRmk(rmk[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ibStoFlg[i] != null)
					model.setIbStoFlg(ibStoFlg[i]);
				if (obStoFlgOrg[i] != null)
					model.setObStoFlgOrg(obStoFlgOrg[i]);
				if (masUcFlg[i] != null)
					model.setMasUcFlg(masUcFlg[i]);
				if (nodCdOrg[i] != null)
					model.setNodCdOrg(nodCdOrg[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (fCtrlOfcCd[i] != null)
					model.setFCtrlOfcCd(fCtrlOfcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fNodNm[i] != null)
					model.setFNodNm(fNodNm[i]);
				if (fExpCustCd[i] != null)
					model.setFExpCustCd(fExpCustCd[i]);
				if (fNodCd[i] != null)
					model.setFNodCd(fNodCd[i]);
				if (obStoFlg[i] != null)
					model.setObStoFlg(obStoFlg[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStorageCalExcepNodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return StorageCalExcepNodeVO[]
	 */
	public StorageCalExcepNodeVO[] getStorageCalExcepNodeVOs(){
		StorageCalExcepNodeVO[] vos = (StorageCalExcepNodeVO[])models.toArray(new StorageCalExcepNodeVO[models.size()]);
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
		this.tmpFCtrlOfcCd = this.tmpFCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expCustCd = this.expCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCdOrg = this.ctrlOfcCdOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodNm = this.nodNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obNodTp = this.obNodTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibStoFlgOrg = this.ibStoFlgOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRdodelflg = this.fRdodelflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibNodTp = this.ibNodTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmk = this.rmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibStoFlg = this.ibStoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obStoFlgOrg = this.obStoFlgOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masUcFlg = this.masUcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCdOrg = this.nodCdOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCtrlOfcCd = this.fCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fNodNm = this.fNodNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fExpCustCd = this.fExpCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fNodCd = this.fNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obStoFlg = this.obStoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
