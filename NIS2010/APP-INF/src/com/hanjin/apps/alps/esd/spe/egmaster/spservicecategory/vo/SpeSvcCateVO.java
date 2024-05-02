/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpeSvcCateVO.java
*@FileTitle : SpeSvcCateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.23
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.23 백형인 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.vo;

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
 * @author 백형인
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpeSvcCateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpeSvcCateVO> models = new ArrayList<SpeSvcCateVO>();
	
	/* Column Info */
	private String spName = null;
	/* Column Info */
	private String isflag = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String saveScVal = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String sChkUnmap = null;
	/* Column Info */
	private String spSeq = null;
	/* Column Info */
	private String inpDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sCtrtOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spSvcCateHisSeq = null;
	/* Column Info */
	private String sVndrNm = null;
	/* Column Info */
	private String evSvcCateCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String spGrpOfcCd = null;
	/* Column Info */
	private String spCtrtOfcCd = null;
	/* Column Info */
	private String sSpSeq = null;
	/* Column Info */
	private String maptype = null;
	/* Column Info */
	private String sChkAll = null;
	/* Column Info */
	private String spRgnGrpOfcCd = null;
	/* Column Info */
	private String pluscol = null;
	/* Column Info */
	private String sEgOfcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sChkMap = null;
	/* Column Info */
	private String sEgRhqCd = null;
	/* Column Info */
	private String spCtrlOfcCd = null;
	/* Column Info */
	private String sRegGp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SpeSvcCateVO() {}

	public SpeSvcCateVO(String ibflag, String pagerows, String sRegGp, String sCtrtOfcCd, String sEgRhqCd, String sEgOfcCd, String sSpSeq, String sVndrNm, String spSeq, String spName, String spGrpOfcCd, String spCtrlOfcCd, String evSvcCateCd, String spSvcCateHisSeq, String spRgnGrpOfcCd, String inpDt, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String saveScVal, String sChkAll, String sChkMap, String sChkUnmap, String maptype, String pluscol, String spCtrtOfcCd, String isflag) {
		this.spName = spName;
		this.isflag = isflag;
		this.deltFlg = deltFlg;
		this.saveScVal = saveScVal;
		this.creDt = creDt;
		this.sChkUnmap = sChkUnmap;
		this.spSeq = spSeq;
		this.inpDt = inpDt;
		this.pagerows = pagerows;
		this.sCtrtOfcCd = sCtrtOfcCd;
		this.ibflag = ibflag;
		this.spSvcCateHisSeq = spSvcCateHisSeq;
		this.sVndrNm = sVndrNm;
		this.evSvcCateCd = evSvcCateCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.spGrpOfcCd = spGrpOfcCd;
		this.spCtrtOfcCd = spCtrtOfcCd;
		this.sSpSeq = sSpSeq;
		this.maptype = maptype;
		this.sChkAll = sChkAll;
		this.spRgnGrpOfcCd = spRgnGrpOfcCd;
		this.pluscol = pluscol;
		this.sEgOfcCd = sEgOfcCd;
		this.creUsrId = creUsrId;
		this.sChkMap = sChkMap;
		this.sEgRhqCd = sEgRhqCd;
		this.spCtrlOfcCd = spCtrlOfcCd;
		this.sRegGp = sRegGp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sp_name", getSpName());
		this.hashColumns.put("isflag", getIsflag());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("save_sc_val", getSaveScVal());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("s_chk_unmap", getSChkUnmap());
		this.hashColumns.put("sp_seq", getSpSeq());
		this.hashColumns.put("inp_dt", getInpDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_ctrt_ofc_cd", getSCtrtOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sp_svc_cate_his_seq", getSpSvcCateHisSeq());
		this.hashColumns.put("s_vndr_nm", getSVndrNm());
		this.hashColumns.put("ev_svc_cate_cd", getEvSvcCateCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("sp_grp_ofc_cd", getSpGrpOfcCd());
		this.hashColumns.put("sp_ctrt_ofc_cd", getSpCtrtOfcCd());
		this.hashColumns.put("s_sp_seq", getSSpSeq());
		this.hashColumns.put("maptype", getMaptype());
		this.hashColumns.put("s_chk_all", getSChkAll());
		this.hashColumns.put("sp_rgn_grp_ofc_cd", getSpRgnGrpOfcCd());
		this.hashColumns.put("pluscol", getPluscol());
		this.hashColumns.put("s_eg_ofc_cd", getSEgOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("s_chk_map", getSChkMap());
		this.hashColumns.put("s_eg_rhq_cd", getSEgRhqCd());
		this.hashColumns.put("sp_ctrl_ofc_cd", getSpCtrlOfcCd());
		this.hashColumns.put("s_reg_gp", getSRegGp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sp_name", "spName");
		this.hashFields.put("isflag", "isflag");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("save_sc_val", "saveScVal");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("s_chk_unmap", "sChkUnmap");
		this.hashFields.put("sp_seq", "spSeq");
		this.hashFields.put("inp_dt", "inpDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_ctrt_ofc_cd", "sCtrtOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sp_svc_cate_his_seq", "spSvcCateHisSeq");
		this.hashFields.put("s_vndr_nm", "sVndrNm");
		this.hashFields.put("ev_svc_cate_cd", "evSvcCateCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("sp_grp_ofc_cd", "spGrpOfcCd");
		this.hashFields.put("sp_ctrt_ofc_cd", "spCtrtOfcCd");
		this.hashFields.put("s_sp_seq", "sSpSeq");
		this.hashFields.put("maptype", "maptype");
		this.hashFields.put("s_chk_all", "sChkAll");
		this.hashFields.put("sp_rgn_grp_ofc_cd", "spRgnGrpOfcCd");
		this.hashFields.put("pluscol", "pluscol");
		this.hashFields.put("s_eg_ofc_cd", "sEgOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("s_chk_map", "sChkMap");
		this.hashFields.put("s_eg_rhq_cd", "sEgRhqCd");
		this.hashFields.put("sp_ctrl_ofc_cd", "spCtrlOfcCd");
		this.hashFields.put("s_reg_gp", "sRegGp");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return spName
	 */
	public String getSpName() {
		return this.spName;
	}
	
	/**
	 * Column Info
	 * @return isflag
	 */
	public String getIsflag() {
		return this.isflag;
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
	 * @return saveScVal
	 */
	public String getSaveScVal() {
		return this.saveScVal;
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
	 * @return sChkUnmap
	 */
	public String getSChkUnmap() {
		return this.sChkUnmap;
	}
	
	/**
	 * Column Info
	 * @return spSeq
	 */
	public String getSpSeq() {
		return this.spSeq;
	}
	
	/**
	 * Column Info
	 * @return inpDt
	 */
	public String getInpDt() {
		return this.inpDt;
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
	 * @return sCtrtOfcCd
	 */
	public String getSCtrtOfcCd() {
		return this.sCtrtOfcCd;
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
	 * @return spSvcCateHisSeq
	 */
	public String getSpSvcCateHisSeq() {
		return this.spSvcCateHisSeq;
	}
	
	/**
	 * Column Info
	 * @return sVndrNm
	 */
	public String getSVndrNm() {
		return this.sVndrNm;
	}
	
	/**
	 * Column Info
	 * @return evSvcCateCd
	 */
	public String getEvSvcCateCd() {
		return this.evSvcCateCd;
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
	 * @return spGrpOfcCd
	 */
	public String getSpGrpOfcCd() {
		return this.spGrpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return spCtrtOfcCd
	 */
	public String getSpCtrtOfcCd() {
		return this.spCtrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sSpSeq
	 */
	public String getSSpSeq() {
		return this.sSpSeq;
	}
	
	/**
	 * Column Info
	 * @return maptype
	 */
	public String getMaptype() {
		return this.maptype;
	}
	
	/**
	 * Column Info
	 * @return sChkAll
	 */
	public String getSChkAll() {
		return this.sChkAll;
	}
	
	/**
	 * Column Info
	 * @return spRgnGrpOfcCd
	 */
	public String getSpRgnGrpOfcCd() {
		return this.spRgnGrpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return pluscol
	 */
	public String getPluscol() {
		return this.pluscol;
	}
	
	/**
	 * Column Info
	 * @return sEgOfcCd
	 */
	public String getSEgOfcCd() {
		return this.sEgOfcCd;
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
	 * @return sChkMap
	 */
	public String getSChkMap() {
		return this.sChkMap;
	}
	
	/**
	 * Column Info
	 * @return sEgRhqCd
	 */
	public String getSEgRhqCd() {
		return this.sEgRhqCd;
	}
	
	/**
	 * Column Info
	 * @return spCtrlOfcCd
	 */
	public String getSpCtrlOfcCd() {
		return this.spCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sRegGp
	 */
	public String getSRegGp() {
		return this.sRegGp;
	}
	

	/**
	 * Column Info
	 * @param spName
	 */
	public void setSpName(String spName) {
		this.spName = spName;
	}
	
	/**
	 * Column Info
	 * @param isflag
	 */
	public void setIsflag(String isflag) {
		this.isflag = isflag;
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
	 * @param saveScVal
	 */
	public void setSaveScVal(String saveScVal) {
		this.saveScVal = saveScVal;
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
	 * @param sChkUnmap
	 */
	public void setSChkUnmap(String sChkUnmap) {
		this.sChkUnmap = sChkUnmap;
	}
	
	/**
	 * Column Info
	 * @param spSeq
	 */
	public void setSpSeq(String spSeq) {
		this.spSeq = spSeq;
	}
	
	/**
	 * Column Info
	 * @param inpDt
	 */
	public void setInpDt(String inpDt) {
		this.inpDt = inpDt;
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
	 * @param sCtrtOfcCd
	 */
	public void setSCtrtOfcCd(String sCtrtOfcCd) {
		this.sCtrtOfcCd = sCtrtOfcCd;
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
	 * @param spSvcCateHisSeq
	 */
	public void setSpSvcCateHisSeq(String spSvcCateHisSeq) {
		this.spSvcCateHisSeq = spSvcCateHisSeq;
	}
	
	/**
	 * Column Info
	 * @param sVndrNm
	 */
	public void setSVndrNm(String sVndrNm) {
		this.sVndrNm = sVndrNm;
	}
	
	/**
	 * Column Info
	 * @param evSvcCateCd
	 */
	public void setEvSvcCateCd(String evSvcCateCd) {
		this.evSvcCateCd = evSvcCateCd;
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
	 * @param spGrpOfcCd
	 */
	public void setSpGrpOfcCd(String spGrpOfcCd) {
		this.spGrpOfcCd = spGrpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param spCtrtOfcCd
	 */
	public void setSpCtrtOfcCd(String spCtrtOfcCd) {
		this.spCtrtOfcCd = spCtrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sSpSeq
	 */
	public void setSSpSeq(String sSpSeq) {
		this.sSpSeq = sSpSeq;
	}
	
	/**
	 * Column Info
	 * @param maptype
	 */
	public void setMaptype(String maptype) {
		this.maptype = maptype;
	}
	
	/**
	 * Column Info
	 * @param sChkAll
	 */
	public void setSChkAll(String sChkAll) {
		this.sChkAll = sChkAll;
	}
	
	/**
	 * Column Info
	 * @param spRgnGrpOfcCd
	 */
	public void setSpRgnGrpOfcCd(String spRgnGrpOfcCd) {
		this.spRgnGrpOfcCd = spRgnGrpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param pluscol
	 */
	public void setPluscol(String pluscol) {
		this.pluscol = pluscol;
	}
	
	/**
	 * Column Info
	 * @param sEgOfcCd
	 */
	public void setSEgOfcCd(String sEgOfcCd) {
		this.sEgOfcCd = sEgOfcCd;
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
	 * @param sChkMap
	 */
	public void setSChkMap(String sChkMap) {
		this.sChkMap = sChkMap;
	}
	
	/**
	 * Column Info
	 * @param sEgRhqCd
	 */
	public void setSEgRhqCd(String sEgRhqCd) {
		this.sEgRhqCd = sEgRhqCd;
	}
	
	/**
	 * Column Info
	 * @param spCtrlOfcCd
	 */
	public void setSpCtrlOfcCd(String spCtrlOfcCd) {
		this.spCtrlOfcCd = spCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sRegGp
	 */
	public void setSRegGp(String sRegGp) {
		this.sRegGp = sRegGp;
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
		setSpName(JSPUtil.getParameter(request, prefix + "sp_name", ""));
		setIsflag(JSPUtil.getParameter(request, prefix + "isflag", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setSaveScVal(JSPUtil.getParameter(request, prefix + "save_sc_val", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSChkUnmap(JSPUtil.getParameter(request, prefix + "s_chk_unmap", ""));
		setSpSeq(JSPUtil.getParameter(request, prefix + "sp_seq", ""));
		setInpDt(JSPUtil.getParameter(request, prefix + "inp_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSCtrtOfcCd(JSPUtil.getParameter(request, prefix + "s_ctrt_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSpSvcCateHisSeq(JSPUtil.getParameter(request, prefix + "sp_svc_cate_his_seq", ""));
		setSVndrNm(JSPUtil.getParameter(request, prefix + "s_vndr_nm", ""));
		setEvSvcCateCd(JSPUtil.getParameter(request, prefix + "ev_svc_cate_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSpGrpOfcCd(JSPUtil.getParameter(request, prefix + "sp_grp_ofc_cd", ""));
		setSpCtrtOfcCd(JSPUtil.getParameter(request, prefix + "sp_ctrt_ofc_cd", ""));
		setSSpSeq(JSPUtil.getParameter(request, prefix + "s_sp_seq", ""));
		setMaptype(JSPUtil.getParameter(request, prefix + "maptype", ""));
		setSChkAll(JSPUtil.getParameter(request, prefix + "s_chk_all", ""));
		setSpRgnGrpOfcCd(JSPUtil.getParameter(request, prefix + "sp_rgn_grp_ofc_cd", ""));
		setPluscol(JSPUtil.getParameter(request, prefix + "pluscol", ""));
		setSEgOfcCd(JSPUtil.getParameter(request, prefix + "s_eg_ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSChkMap(JSPUtil.getParameter(request, prefix + "s_chk_map", ""));
		setSEgRhqCd(JSPUtil.getParameter(request, prefix + "s_eg_rhq_cd", ""));
		setSpCtrlOfcCd(JSPUtil.getParameter(request, prefix + "sp_ctrl_ofc_cd", ""));
		setSRegGp(JSPUtil.getParameter(request, prefix + "s_reg_gp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpeSvcCateVO[]
	 */
	public SpeSvcCateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpeSvcCateVO[]
	 */
	public SpeSvcCateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpeSvcCateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] spName = (JSPUtil.getParameter(request, prefix	+ "sp_name", length));
			String[] isflag = (JSPUtil.getParameter(request, prefix	+ "isflag", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] saveScVal = (JSPUtil.getParameter(request, prefix	+ "save_sc_val", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] sChkUnmap = (JSPUtil.getParameter(request, prefix	+ "s_chk_unmap", length));
			String[] spSeq = (JSPUtil.getParameter(request, prefix	+ "sp_seq", length));
			String[] inpDt = (JSPUtil.getParameter(request, prefix	+ "inp_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sCtrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ctrt_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spSvcCateHisSeq = (JSPUtil.getParameter(request, prefix	+ "sp_svc_cate_his_seq", length));
			String[] sVndrNm = (JSPUtil.getParameter(request, prefix	+ "s_vndr_nm", length));
			String[] evSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "ev_svc_cate_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] spGrpOfcCd = (JSPUtil.getParameter(request, prefix	+ "sp_grp_ofc_cd", length));
			String[] spCtrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "sp_ctrt_ofc_cd", length));
			String[] sSpSeq = (JSPUtil.getParameter(request, prefix	+ "s_sp_seq", length));
			String[] maptype = (JSPUtil.getParameter(request, prefix	+ "maptype", length));
			String[] sChkAll = (JSPUtil.getParameter(request, prefix	+ "s_chk_all", length));
			String[] spRgnGrpOfcCd = (JSPUtil.getParameter(request, prefix	+ "sp_rgn_grp_ofc_cd", length));
			String[] pluscol = (JSPUtil.getParameter(request, prefix	+ "pluscol", length));
			String[] sEgOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] sChkMap = (JSPUtil.getParameter(request, prefix	+ "s_chk_map", length));
			String[] sEgRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_rhq_cd", length));
			String[] spCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "sp_ctrl_ofc_cd", length));
			String[] sRegGp = (JSPUtil.getParameter(request, prefix	+ "s_reg_gp", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpeSvcCateVO();
				if (spName[i] != null)
					model.setSpName(spName[i]);
				if (isflag[i] != null)
					model.setIsflag(isflag[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (saveScVal[i] != null)
					model.setSaveScVal(saveScVal[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (sChkUnmap[i] != null)
					model.setSChkUnmap(sChkUnmap[i]);
				if (spSeq[i] != null)
					model.setSpSeq(spSeq[i]);
				if (inpDt[i] != null)
					model.setInpDt(inpDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sCtrtOfcCd[i] != null)
					model.setSCtrtOfcCd(sCtrtOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spSvcCateHisSeq[i] != null)
					model.setSpSvcCateHisSeq(spSvcCateHisSeq[i]);
				if (sVndrNm[i] != null)
					model.setSVndrNm(sVndrNm[i]);
				if (evSvcCateCd[i] != null)
					model.setEvSvcCateCd(evSvcCateCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (spGrpOfcCd[i] != null)
					model.setSpGrpOfcCd(spGrpOfcCd[i]);
				if (spCtrtOfcCd[i] != null)
					model.setSpCtrtOfcCd(spCtrtOfcCd[i]);
				if (sSpSeq[i] != null)
					model.setSSpSeq(sSpSeq[i]);
				if (maptype[i] != null)
					model.setMaptype(maptype[i]);
				if (sChkAll[i] != null)
					model.setSChkAll(sChkAll[i]);
				if (spRgnGrpOfcCd[i] != null)
					model.setSpRgnGrpOfcCd(spRgnGrpOfcCd[i]);
				if (pluscol[i] != null)
					model.setPluscol(pluscol[i]);
				if (sEgOfcCd[i] != null)
					model.setSEgOfcCd(sEgOfcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sChkMap[i] != null)
					model.setSChkMap(sChkMap[i]);
				if (sEgRhqCd[i] != null)
					model.setSEgRhqCd(sEgRhqCd[i]);
				if (spCtrlOfcCd[i] != null)
					model.setSpCtrlOfcCd(spCtrlOfcCd[i]);
				if (sRegGp[i] != null)
					model.setSRegGp(sRegGp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpeSvcCateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpeSvcCateVO[]
	 */
	public SpeSvcCateVO[] getSpeSvcCateVOs(){
		SpeSvcCateVO[] vos = (SpeSvcCateVO[])models.toArray(new SpeSvcCateVO[models.size()]);
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
		this.spName = this.spName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isflag = this.isflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveScVal = this.saveScVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChkUnmap = this.sChkUnmap .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spSeq = this.spSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpDt = this.inpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCtrtOfcCd = this.sCtrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spSvcCateHisSeq = this.spSvcCateHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrNm = this.sVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evSvcCateCd = this.evSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spGrpOfcCd = this.spGrpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCtrtOfcCd = this.spCtrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSpSeq = this.sSpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maptype = this.maptype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChkAll = this.sChkAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spRgnGrpOfcCd = this.spRgnGrpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pluscol = this.pluscol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgOfcCd = this.sEgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChkMap = this.sChkMap .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgRhqCd = this.sEgRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCtrlOfcCd = this.spCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRegGp = this.sRegGp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
