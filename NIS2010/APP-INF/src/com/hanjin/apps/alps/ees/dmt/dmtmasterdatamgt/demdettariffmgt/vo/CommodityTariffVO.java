/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityTariffVO.java
*@FileTitle : CommodityTariffVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.07.28 김태균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo;

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
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CommodityTariffVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CommodityTariffVO> models = new ArrayList<CommodityTariffVO>();
	
	/* Column Info */
	private String xcldSatFlg = null;
	/* Column Info */
	private String xcldSunFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String returnMsg = null;
	/* Column Info */
	private String returnCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cmdtAddDys = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String cmdtTrfSeq = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updName = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String xcldHolFlg = null;
	/* Column Info */
	private String cmdtTtlDys = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String trfSeq = null;
	/* Column Info */
	private String cmdtRmk = null;
	/* Column Info */
	private String picTeam = null;
	/* Column Info */
	private String trfRuleNo = null;
	/* Column Info */
	private String trfMngUsrId = null;
	/* Column Info */
	private String trfMngUsrNm = null;
	/* Column Info */
	private String updDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CommodityTariffVO() {}

	public CommodityTariffVO(String ibflag, String pagerows, String svrId, String dmdtTrfCd, String trfSeq, String cmdtCd, String cmdtNm, String repCmdtCd, String cmdtTrfSeq, String effDt, String expDt, String cmdtAddDys, String cmdtTtlDys, String xcldSatFlg, String xcldSunFlg, String xcldHolFlg, String updOfcCd, String updUsrId, String updName, String cmdtRmk, String deltFlg, String usrId, String ofcCd, String returnCd, String returnMsg, String picTeam, String trfRuleNo, String trfMngUsrId, String trfMngUsrNm, String updDt) {
		this.xcldSatFlg = xcldSatFlg;
		this.xcldSunFlg = xcldSunFlg;
		this.deltFlg = deltFlg;
		this.returnMsg = returnMsg;
		this.returnCd = returnCd;
		this.pagerows = pagerows;
		this.cmdtAddDys = cmdtAddDys;
		this.svrId = svrId;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.usrId = usrId;
		this.expDt = expDt;
		this.cmdtTrfSeq = cmdtTrfSeq;
		this.dmdtTrfCd = dmdtTrfCd;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.updName = updName;
		this.cmdtNm = cmdtNm;
		this.ofcCd = ofcCd;
		this.xcldHolFlg = xcldHolFlg;
		this.cmdtTtlDys = cmdtTtlDys;
		this.repCmdtCd = repCmdtCd;
		this.trfSeq = trfSeq;
		this.cmdtRmk = cmdtRmk;
		this.picTeam = picTeam;
		this.trfRuleNo = trfRuleNo;
		this.trfMngUsrId = trfMngUsrId;
		this.trfMngUsrNm = trfMngUsrNm;
		this.updDt = updDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xcld_sat_flg", getXcldSatFlg());
		this.hashColumns.put("xcld_sun_flg", getXcldSunFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("return_msg", getReturnMsg());
		this.hashColumns.put("return_cd", getReturnCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cmdt_add_dys", getCmdtAddDys());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("cmdt_trf_seq", getCmdtTrfSeq());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_name", getUpdName());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("xcld_hol_flg", getXcldHolFlg());
		this.hashColumns.put("cmdt_ttl_dys", getCmdtTtlDys());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("trf_seq", getTrfSeq());
		this.hashColumns.put("cmdt_rmk", getCmdtRmk());
		this.hashColumns.put("pic_team", getPicTeam());
		this.hashColumns.put("trf_rule_no", getTrfRuleNo());
		this.hashColumns.put("trf_mng_usr_id", getTrfMngUsrId());
		this.hashColumns.put("trf_mng_usr_nm", getTrfMngUsrNm());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xcld_sat_flg", "xcldSatFlg");
		this.hashFields.put("xcld_sun_flg", "xcldSunFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("return_msg", "returnMsg");
		this.hashFields.put("return_cd", "returnCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cmdt_add_dys", "cmdtAddDys");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("cmdt_trf_seq", "cmdtTrfSeq");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_name", "updName");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("xcld_hol_flg", "xcldHolFlg");
		this.hashFields.put("cmdt_ttl_dys", "cmdtTtlDys");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("trf_seq", "trfSeq");
		this.hashFields.put("cmdt_rmk", "cmdtRmk");
		this.hashFields.put("pic_team", "picTeam");
		this.hashFields.put("trf_rule_no", "trfRuleNo");
		this.hashFields.put("trf_mng_usr_id", "trfMngUsrId");
		this.hashFields.put("trf_mng_usr_nm", "trfMngUsrNm");
		this.hashFields.put("upd_dt", "updDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return xcldSatFlg
	 */
	public String getXcldSatFlg() {
		return this.xcldSatFlg;
	}
	
	/**
	 * Column Info
	 * @return xcldSunFlg
	 */
	public String getXcldSunFlg() {
		return this.xcldSunFlg;
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
	 * @return returnMsg
	 */
	public String getReturnMsg() {
		return this.returnMsg;
	}
	
	/**
	 * Column Info
	 * @return returnCd
	 */
	public String getReturnCd() {
		return this.returnCd;
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
	 * @return cmdtAddDys
	 */
	public String getCmdtAddDys() {
		return this.cmdtAddDys;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return cmdtTrfSeq
	 */
	public String getCmdtTrfSeq() {
		return this.cmdtTrfSeq;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
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
	 * @return updName
	 */
	public String getUpdName() {
		return this.updName;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @return xcldHolFlg
	 */
	public String getXcldHolFlg() {
		return this.xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @return cmdtTtlDys
	 */
	public String getCmdtTtlDys() {
		return this.cmdtTtlDys;
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
	 * @return trfSeq
	 */
	public String getTrfSeq() {
		return this.trfSeq;
	}
	
	/**
	 * Column Info
	 * @return cmdtRmk
	 */
	public String getCmdtRmk() {
		return this.cmdtRmk;
	}
	

	/**
	 * Column Info
	 * @param xcldSatFlg
	 */
	public void setXcldSatFlg(String xcldSatFlg) {
		this.xcldSatFlg = xcldSatFlg;
	}
	
	/**
	 * Column Info
	 * @param xcldSunFlg
	 */
	public void setXcldSunFlg(String xcldSunFlg) {
		this.xcldSunFlg = xcldSunFlg;
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
	 * @param returnMsg
	 */
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	
	/**
	 * Column Info
	 * @param returnCd
	 */
	public void setReturnCd(String returnCd) {
		this.returnCd = returnCd;
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
	 * @param cmdtAddDys
	 */
	public void setCmdtAddDys(String cmdtAddDys) {
		this.cmdtAddDys = cmdtAddDys;
	}
	
	/**
	 * Column Info
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param cmdtTrfSeq
	 */
	public void setCmdtTrfSeq(String cmdtTrfSeq) {
		this.cmdtTrfSeq = cmdtTrfSeq;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
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
	 * @param updName
	 */
	public void setUpdName(String updName) {
		this.updName = updName;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param xcldHolFlg
	 */
	public void setXcldHolFlg(String xcldHolFlg) {
		this.xcldHolFlg = xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @param cmdtTtlDys
	 */
	public void setCmdtTtlDys(String cmdtTtlDys) {
		this.cmdtTtlDys = cmdtTtlDys;
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
	 * @param trfSeq
	 */
	public void setTrfSeq(String trfSeq) {
		this.trfSeq = trfSeq;
	}
	
	/**
	 * Column Info
	 * @param cmdtRmk
	 */
	public void setCmdtRmk(String cmdtRmk) {
		this.cmdtRmk = cmdtRmk;
	}
	
	public String getPicTeam() {
		return picTeam;
	}

	public void setPicTeam(String picTeam) {
		this.picTeam = picTeam;
	}

	public String getTrfRuleNo() {
		return trfRuleNo;
	}

	public void setTrfRuleNo(String trfRuleNo) {
		this.trfRuleNo = trfRuleNo;
	}

	public String getTrfMngUsrId() {
		return trfMngUsrId;
	}

	public void setTrfMngUsrId(String trfMngUsrId) {
		this.trfMngUsrId = trfMngUsrId;
	}

	public String getTrfMngUsrNm() {
		return trfMngUsrNm;
	}

	public void setTrfMngUsrNm(String trfMngUsrNm) {
		this.trfMngUsrNm = trfMngUsrNm;
	}

	public String getUpdDt() {
		return updDt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setXcldSatFlg(JSPUtil.getParameter(request, "xcld_sat_flg", ""));
		setXcldSunFlg(JSPUtil.getParameter(request, "xcld_sun_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setReturnMsg(JSPUtil.getParameter(request, "return_msg", ""));
		setReturnCd(JSPUtil.getParameter(request, "return_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCmdtAddDys(JSPUtil.getParameter(request, "cmdt_add_dys", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setCmdtTrfSeq(JSPUtil.getParameter(request, "cmdt_trf_seq", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdName(JSPUtil.getParameter(request, "upd_name", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setXcldHolFlg(JSPUtil.getParameter(request, "xcld_hol_flg", ""));
		setCmdtTtlDys(JSPUtil.getParameter(request, "cmdt_ttl_dys", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, "rep_cmdt_cd", ""));
		setTrfSeq(JSPUtil.getParameter(request, "trf_seq", ""));
		setCmdtRmk(JSPUtil.getParameter(request, "cmdt_rmk", ""));
		setPicTeam(JSPUtil.getParameter(request, "pic_team", ""));
		setTrfRuleNo(JSPUtil.getParameter(request, "trf_rule_no", ""));
		setTrfMngUsrId(JSPUtil.getParameter(request, "trf_mnt_usr_id", ""));
		setTrfMngUsrNm(JSPUtil.getParameter(request, "trf_mnt_usr_nm", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CommodityTariffVO[]
	 */
	public CommodityTariffVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CommodityTariffVO[]
	 */
	public CommodityTariffVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CommodityTariffVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xcldSatFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sat_flg", length));
			String[] xcldSunFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sun_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] returnMsg = (JSPUtil.getParameter(request, prefix	+ "return_msg", length));
			String[] returnCd = (JSPUtil.getParameter(request, prefix	+ "return_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cmdtAddDys = (JSPUtil.getParameter(request, prefix	+ "cmdt_add_dys", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] cmdtTrfSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_trf_seq", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updName = (JSPUtil.getParameter(request, prefix	+ "upd_name", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] xcldHolFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_hol_flg", length));
			String[] cmdtTtlDys = (JSPUtil.getParameter(request, prefix	+ "cmdt_ttl_dys", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] trfSeq = (JSPUtil.getParameter(request, prefix	+ "trf_seq", length));
			String[] cmdtRmk = (JSPUtil.getParameter(request, prefix	+ "cmdt_rmk", length));
			String[] picTeam = (JSPUtil.getParameter(request, prefix	+ "pic_team", length));
			String[] trfRuleNo = (JSPUtil.getParameter(request, prefix	+ "trf_rule_no", length));
			String[] trfMngUsrId = (JSPUtil.getParameter(request, prefix	+ "trf_mng_usr_id", length));
			String[] trfMngUsrNm = (JSPUtil.getParameter(request, prefix	+ "trf_mng_usr_nm", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CommodityTariffVO();
				if (xcldSatFlg[i] != null)
					model.setXcldSatFlg(xcldSatFlg[i]);
				if (xcldSunFlg[i] != null)
					model.setXcldSunFlg(xcldSunFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (returnMsg[i] != null)
					model.setReturnMsg(returnMsg[i]);
				if (returnCd[i] != null)
					model.setReturnCd(returnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cmdtAddDys[i] != null)
					model.setCmdtAddDys(cmdtAddDys[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (cmdtTrfSeq[i] != null)
					model.setCmdtTrfSeq(cmdtTrfSeq[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updName[i] != null)
					model.setUpdName(updName[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (xcldHolFlg[i] != null)
					model.setXcldHolFlg(xcldHolFlg[i]);
				if (cmdtTtlDys[i] != null)
					model.setCmdtTtlDys(cmdtTtlDys[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (trfSeq[i] != null)
					model.setTrfSeq(trfSeq[i]);
				if (cmdtRmk[i] != null)
					model.setCmdtRmk(cmdtRmk[i]);
				if (picTeam[i] != null)
					model.setPicTeam(picTeam[i]);
				if (trfRuleNo[i] != null)
					model.setTrfRuleNo(trfRuleNo[i]);
				if (trfMngUsrId[i] != null)
					model.setTrfMngUsrId(trfMngUsrId[i]);
				if (trfMngUsrNm[i] != null)
					model.setTrfMngUsrNm(trfMngUsrNm[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCommodityTariffVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CommodityTariffVO[]
	 */
	public CommodityTariffVO[] getCommodityTariffVOs(){
		CommodityTariffVO[] vos = (CommodityTariffVO[])models.toArray(new CommodityTariffVO[models.size()]);
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
		this.xcldSatFlg = this.xcldSatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldSunFlg = this.xcldSunFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnMsg = this.returnMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnCd = this.returnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtAddDys = this.cmdtAddDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtTrfSeq = this.cmdtTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updName = this.updName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldHolFlg = this.xcldHolFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtTtlDys = this.cmdtTtlDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfSeq = this.trfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtRmk = this.cmdtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picTeam = this.picTeam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRuleNo = this.trfRuleNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfMngUsrId = this.trfMngUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfMngUsrNm = this.trfMngUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
