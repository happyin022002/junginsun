/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24BlCntrListVO.java
*@FileTitle : Eur24BlCntrListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.15
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.09.15 김경섭 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Eur24BlCntrListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Eur24BlCntrListVO> models = new ArrayList<Eur24BlCntrListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cstmsPortCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cntrgwgt = null;
	/* Column Info */
	private String fmInd = null;
	/* Column Info */
	private String cntrnbr = null;
	/* Column Info */
	private String pkg = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String cntrwgt = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrtype = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String punit = null;
	/* Column Info */
	private String cntrWgtUnit = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String cmdtcd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Eur24BlCntrListVO() {}

	public Eur24BlCntrListVO(String ibflag, String pagerows, String cntrnbr, String fmInd, String punit, String pkg, String cntrwgt, String cntrgwgt, String cntrWgtUnit, String cntrtype, String cmdtDesc, String cmdtcd, String vslCd, String skdVoyNo, String skdDirCd, String blNo, String cstmsPortCd, String cntrNo, String fullMtyCd, String pckQty, String pckTpCd, String measQty, String measUtCd, String actWgt, String wgtUtCd, String cntrTpszCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.vslCd = vslCd;
		this.creDt = creDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cntrTpszCd = cntrTpszCd;
		this.measQty = measQty;
		this.wgtUtCd = wgtUtCd;
		this.pckQty = pckQty;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
		this.updUsrId = updUsrId;
		this.cstmsPortCd = cstmsPortCd;
		this.updDt = updDt;
		this.cntrgwgt = cntrgwgt;
		this.fmInd = fmInd;
		this.cntrnbr = cntrnbr;
		this.pkg = pkg;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.cntrwgt = cntrwgt;
		this.actWgt = actWgt;
		this.creUsrId = creUsrId;
		this.cntrtype = cntrtype;
		this.cmdtDesc = cmdtDesc;
		this.cntrNo = cntrNo;
		this.punit = punit;
		this.cntrWgtUnit = cntrWgtUnit;
		this.fullMtyCd = fullMtyCd;
		this.cmdtcd = cmdtcd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cntrgwgt", getCntrgwgt());
		this.hashColumns.put("fm_ind", getFmInd());
		this.hashColumns.put("cntrnbr", getCntrnbr());
		this.hashColumns.put("pkg", getPkg());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cntrwgt", getCntrwgt());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntrtype", getCntrtype());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("punit", getPunit());
		this.hashColumns.put("cntr_wgt_unit", getCntrWgtUnit());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("cmdtcd", getCmdtcd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cntrgwgt", "cntrgwgt");
		this.hashFields.put("fm_ind", "fmInd");
		this.hashFields.put("cntrnbr", "cntrnbr");
		this.hashFields.put("pkg", "pkg");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cntrwgt", "cntrwgt");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntrtype", "cntrtype");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("punit", "punit");
		this.hashFields.put("cntr_wgt_unit", "cntrWgtUnit");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("cmdtcd", "cmdtcd");
		return this.hashFields;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
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
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
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
	 * @return cstmsPortCd
	 */
	public String getCstmsPortCd() {
		return this.cstmsPortCd;
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
	 * @return cntrgwgt
	 */
	public String getCntrgwgt() {
		return this.cntrgwgt;
	}
	
	/**
	 * Column Info
	 * @return fmInd
	 */
	public String getFmInd() {
		return this.fmInd;
	}
	
	/**
	 * Column Info
	 * @return cntrnbr
	 */
	public String getCntrnbr() {
		return this.cntrnbr;
	}
	
	/**
	 * Column Info
	 * @return pkg
	 */
	public String getPkg() {
		return this.pkg;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return cntrwgt
	 */
	public String getCntrwgt() {
		return this.cntrwgt;
	}
	
	/**
	 * Column Info
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
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
	 * @return cntrtype
	 */
	public String getCntrtype() {
		return this.cntrtype;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
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
	 * @return punit
	 */
	public String getPunit() {
		return this.punit;
	}
	
	/**
	 * Column Info
	 * @return cntrWgtUnit
	 */
	public String getCntrWgtUnit() {
		return this.cntrWgtUnit;
	}
	
	/**
	 * Column Info
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtcd
	 */
	public String getCmdtcd() {
		return this.cmdtcd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
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
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
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
	 * @param cstmsPortCd
	 */
	public void setCstmsPortCd(String cstmsPortCd) {
		this.cstmsPortCd = cstmsPortCd;
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
	 * @param cntrgwgt
	 */
	public void setCntrgwgt(String cntrgwgt) {
		this.cntrgwgt = cntrgwgt;
	}
	
	/**
	 * Column Info
	 * @param fmInd
	 */
	public void setFmInd(String fmInd) {
		this.fmInd = fmInd;
	}
	
	/**
	 * Column Info
	 * @param cntrnbr
	 */
	public void setCntrnbr(String cntrnbr) {
		this.cntrnbr = cntrnbr;
	}
	
	/**
	 * Column Info
	 * @param pkg
	 */
	public void setPkg(String pkg) {
		this.pkg = pkg;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param cntrwgt
	 */
	public void setCntrwgt(String cntrwgt) {
		this.cntrwgt = cntrwgt;
	}
	
	/**
	 * Column Info
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
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
	 * @param cntrtype
	 */
	public void setCntrtype(String cntrtype) {
		this.cntrtype = cntrtype;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
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
	 * @param punit
	 */
	public void setPunit(String punit) {
		this.punit = punit;
	}
	
	/**
	 * Column Info
	 * @param cntrWgtUnit
	 */
	public void setCntrWgtUnit(String cntrWgtUnit) {
		this.cntrWgtUnit = cntrWgtUnit;
	}
	
	/**
	 * Column Info
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtcd
	 */
	public void setCmdtcd(String cmdtcd) {
		this.cmdtcd = cmdtcd;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCntrgwgt(JSPUtil.getParameter(request, prefix + "cntrgwgt", ""));
		setFmInd(JSPUtil.getParameter(request, prefix + "fm_ind", ""));
		setCntrnbr(JSPUtil.getParameter(request, prefix + "cntrnbr", ""));
		setPkg(JSPUtil.getParameter(request, prefix + "pkg", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCntrwgt(JSPUtil.getParameter(request, prefix + "cntrwgt", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCntrtype(JSPUtil.getParameter(request, prefix + "cntrtype", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setPunit(JSPUtil.getParameter(request, prefix + "punit", ""));
		setCntrWgtUnit(JSPUtil.getParameter(request, prefix + "cntr_wgt_unit", ""));
		setFullMtyCd(JSPUtil.getParameter(request, prefix + "full_mty_cd", ""));
		setCmdtcd(JSPUtil.getParameter(request, prefix + "cmdtcd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Eur24BlCntrListVO[]
	 */
	public Eur24BlCntrListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Eur24BlCntrListVO[]
	 */
	public Eur24BlCntrListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Eur24BlCntrListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cntrgwgt = (JSPUtil.getParameter(request, prefix	+ "cntrgwgt", length));
			String[] fmInd = (JSPUtil.getParameter(request, prefix	+ "fm_ind", length));
			String[] cntrnbr = (JSPUtil.getParameter(request, prefix	+ "cntrnbr", length));
			String[] pkg = (JSPUtil.getParameter(request, prefix	+ "pkg", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] cntrwgt = (JSPUtil.getParameter(request, prefix	+ "cntrwgt", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrtype = (JSPUtil.getParameter(request, prefix	+ "cntrtype", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] punit = (JSPUtil.getParameter(request, prefix	+ "punit", length));
			String[] cntrWgtUnit = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt_unit", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] cmdtcd = (JSPUtil.getParameter(request, prefix	+ "cmdtcd", length));
			
			for (int i = 0; i < length; i++) {
				model = new Eur24BlCntrListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cntrgwgt[i] != null)
					model.setCntrgwgt(cntrgwgt[i]);
				if (fmInd[i] != null)
					model.setFmInd(fmInd[i]);
				if (cntrnbr[i] != null)
					model.setCntrnbr(cntrnbr[i]);
				if (pkg[i] != null)
					model.setPkg(pkg[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (cntrwgt[i] != null)
					model.setCntrwgt(cntrwgt[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrtype[i] != null)
					model.setCntrtype(cntrtype[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (punit[i] != null)
					model.setPunit(punit[i]);
				if (cntrWgtUnit[i] != null)
					model.setCntrWgtUnit(cntrWgtUnit[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (cmdtcd[i] != null)
					model.setCmdtcd(cmdtcd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEur24BlCntrListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Eur24BlCntrListVO[]
	 */
	public Eur24BlCntrListVO[] getEur24BlCntrListVOs(){
		Eur24BlCntrListVO[] vos = (Eur24BlCntrListVO[])models.toArray(new Eur24BlCntrListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrgwgt = this.cntrgwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmInd = this.fmInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrnbr = this.cntrnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkg = this.pkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrwgt = this.cntrwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtype = this.cntrtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.punit = this.punit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgtUnit = this.cntrWgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtcd = this.cmdtcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
