/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ManageQtaAdjustmentVO.java
*@FileTitle : ManageQtaAdjustmentVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.07  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ManageQtaAdjustmentVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ManageQtaAdjustmentVO> models = new ArrayList<ManageQtaAdjustmentVO>();
	
	/* Column Info */
	private String fQtaTgtCd = null;
	/* Column Info */
	private String qtaTgtCd = null;
	/* Column Info */
	private String coaBseWk = null;
	/* Column Info */
	private String isaRgnCd = null;
	/* Column Info */
	private String fDirCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String coaBseMon = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String fBseYr = null;
	/* Column Info */
	private String fnlBsaCapa = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String bseMon = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String potnLnk = null;
	/* Column Info */
	private String bseTpCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String fBseQtrCd = null;
	/* Column Info */
	private String splPotn = null;
	/* Column Info */
	private String qtaRlseVerNo = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String fClick = null;
	/* Column Info */
	private String coaLodQty = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String bseWk = null;
	/* Column Info */
	private String coaFnlBsaCapa = null;
	/* Column Info */
	private String coaVvd = null;
	/* Column Info */
	private String fBseTpCd = null;
	/* Column Info */
	private String fUsrId = null;
	/* Column Info */
	private String fTrdCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String flag = null;
	/* Column Info */
	private String coaGrsRev = null;
	/* Column Info */
	private String grsRev = null;
	/* Column Info */
	private String copyVvd = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ManageQtaAdjustmentVO() {}

	public ManageQtaAdjustmentVO(String ibflag, String pagerows, String fBseTpCd, String fUsrId, String fTrdCd, String fQtaTgtCd, String fDirCd, String fBseYr, String fBseQtrCd, String qtaRlseVerNo, String bseTpCd, String bseYr, String bseQtrCd, String qtaTgtCd, String trdCd, String rlaneCd, String dirCd, String subTrdCd, String bseMon, String bseWk, String iocCd, String vvd, String fnlBsaCapa, String grsRev, String lodQty, String coaBseMon, String coaBseWk, String coaVvd, String coaFnlBsaCapa, String coaLodQty, String coaGrsRev, String copyVvd, String fClick, String potnLnk, String splPotn, String flag, String usrId, String isaRgnCd) {
		this.fQtaTgtCd = fQtaTgtCd;
		this.qtaTgtCd = qtaTgtCd;
		this.coaBseWk = coaBseWk;
		this.isaRgnCd = isaRgnCd;
		this.fDirCd = fDirCd;
		this.trdCd = trdCd;
		this.coaBseMon = coaBseMon;
		this.rlaneCd = rlaneCd;
		this.fBseYr = fBseYr;
		this.fnlBsaCapa = fnlBsaCapa;
		this.pagerows = pagerows;
		this.bseQtrCd = bseQtrCd;
		this.bseMon = bseMon;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.potnLnk = potnLnk;
		this.bseTpCd = bseTpCd;
		this.dirCd = dirCd;
		this.fBseQtrCd = fBseQtrCd;
		this.splPotn = splPotn;
		this.qtaRlseVerNo = qtaRlseVerNo;
		this.iocCd = iocCd;
		this.lodQty = lodQty;
		this.fClick = fClick;
		this.coaLodQty = coaLodQty;
		this.bseYr = bseYr;
		this.bseWk = bseWk;
		this.coaFnlBsaCapa = coaFnlBsaCapa;
		this.coaVvd = coaVvd;
		this.fBseTpCd = fBseTpCd;
		this.fUsrId = fUsrId;
		this.fTrdCd = fTrdCd;
		this.vvd = vvd;
		this.flag = flag;
		this.coaGrsRev = coaGrsRev;
		this.grsRev = grsRev;
		this.copyVvd = copyVvd;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_qta_tgt_cd", getFQtaTgtCd());
		this.hashColumns.put("qta_tgt_cd", getQtaTgtCd());
		this.hashColumns.put("coa_bse_wk", getCoaBseWk());
		this.hashColumns.put("isa_rgn_cd", getIsaRgnCd());
		this.hashColumns.put("f_dir_cd", getFDirCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("coa_bse_mon", getCoaBseMon());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("f_bse_yr", getFBseYr());
		this.hashColumns.put("fnl_bsa_capa", getFnlBsaCapa());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("potn_lnk", getPotnLnk());
		this.hashColumns.put("bse_tp_cd", getBseTpCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("f_bse_qtr_cd", getFBseQtrCd());
		this.hashColumns.put("spl_potn", getSplPotn());
		this.hashColumns.put("qta_rlse_ver_no", getQtaRlseVerNo());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("f_click", getFClick());
		this.hashColumns.put("coa_lod_qty", getCoaLodQty());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("coa_fnl_bsa_capa", getCoaFnlBsaCapa());
		this.hashColumns.put("coa_vvd", getCoaVvd());
		this.hashColumns.put("f_bse_tp_cd", getFBseTpCd());
		this.hashColumns.put("f_usr_id", getFUsrId());
		this.hashColumns.put("f_trd_cd", getFTrdCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("flag", getFlag());
		this.hashColumns.put("coa_grs_rev", getCoaGrsRev());
		this.hashColumns.put("grs_rev", getGrsRev());
		this.hashColumns.put("copy_vvd", getCopyVvd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_qta_tgt_cd", "fQtaTgtCd");
		this.hashFields.put("qta_tgt_cd", "qtaTgtCd");
		this.hashFields.put("coa_bse_wk", "coaBseWk");
		this.hashFields.put("isa_rgn_cd", "isaRgnCd");
		this.hashFields.put("f_dir_cd", "fDirCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("coa_bse_mon", "coaBseMon");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("f_bse_yr", "fBseYr");
		this.hashFields.put("fnl_bsa_capa", "fnlBsaCapa");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("potn_lnk", "potnLnk");
		this.hashFields.put("bse_tp_cd", "bseTpCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("f_bse_qtr_cd", "fBseQtrCd");
		this.hashFields.put("spl_potn", "splPotn");
		this.hashFields.put("qta_rlse_ver_no", "qtaRlseVerNo");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("f_click", "fClick");
		this.hashFields.put("coa_lod_qty", "coaLodQty");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("coa_fnl_bsa_capa", "coaFnlBsaCapa");
		this.hashFields.put("coa_vvd", "coaVvd");
		this.hashFields.put("f_bse_tp_cd", "fBseTpCd");
		this.hashFields.put("f_usr_id", "fUsrId");
		this.hashFields.put("f_trd_cd", "fTrdCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("flag", "flag");
		this.hashFields.put("coa_grs_rev", "coaGrsRev");
		this.hashFields.put("grs_rev", "grsRev");
		this.hashFields.put("copy_vvd", "copyVvd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fQtaTgtCd
	 */
	public String getFQtaTgtCd() {
		return this.fQtaTgtCd;
	}
	
	/**
	 * Column Info
	 * @return qtaTgtCd
	 */
	public String getQtaTgtCd() {
		return this.qtaTgtCd;
	}
	
	/**
	 * Column Info
	 * @return coaBseWk
	 */
	public String getCoaBseWk() {
		return this.coaBseWk;
	}
	
	/**
	 * Column Info
	 * @return isaRgnCd
	 */
	public String getIsaRgnCd() {
		return this.isaRgnCd;
	}
	
	/**
	 * Column Info
	 * @return fDirCd
	 */
	public String getFDirCd() {
		return this.fDirCd;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return coaBseMon
	 */
	public String getCoaBseMon() {
		return this.coaBseMon;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return fBseYr
	 */
	public String getFBseYr() {
		return this.fBseYr;
	}
	
	/**
	 * Column Info
	 * @return fnlBsaCapa
	 */
	public String getFnlBsaCapa() {
		return this.fnlBsaCapa;
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
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @return bseMon
	 */
	public String getBseMon() {
		return this.bseMon;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return potnLnk
	 */
	public String getPotnLnk() {
		return this.potnLnk;
	}
	
	/**
	 * Column Info
	 * @return bseTpCd
	 */
	public String getBseTpCd() {
		return this.bseTpCd;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return fBseQtrCd
	 */
	public String getFBseQtrCd() {
		return this.fBseQtrCd;
	}
	
	/**
	 * Column Info
	 * @return splPotn
	 */
	public String getSplPotn() {
		return this.splPotn;
	}
	
	/**
	 * Column Info
	 * @return qtaRlseVerNo
	 */
	public String getQtaRlseVerNo() {
		return this.qtaRlseVerNo;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return lodQty
	 */
	public String getLodQty() {
		return this.lodQty;
	}
	
	/**
	 * Column Info
	 * @return fClick
	 */
	public String getFClick() {
		return this.fClick;
	}
	
	/**
	 * Column Info
	 * @return coaLodQty
	 */
	public String getCoaLodQty() {
		return this.coaLodQty;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return bseWk
	 */
	public String getBseWk() {
		return this.bseWk;
	}
	
	/**
	 * Column Info
	 * @return coaFnlBsaCapa
	 */
	public String getCoaFnlBsaCapa() {
		return this.coaFnlBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return coaVvd
	 */
	public String getCoaVvd() {
		return this.coaVvd;
	}
	
	/**
	 * Column Info
	 * @return fBseTpCd
	 */
	public String getFBseTpCd() {
		return this.fBseTpCd;
	}
	
	/**
	 * Column Info
	 * @return fUsrId
	 */
	public String getFUsrId() {
		return this.fUsrId;
	}
	
	/**
	 * Column Info
	 * @return fTrdCd
	 */
	public String getFTrdCd() {
		return this.fTrdCd;
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
	 * @return flag
	 */
	public String getFlag() {
		return this.flag;
	}
	
	/**
	 * Column Info
	 * @return coaGrsRev
	 */
	public String getCoaGrsRev() {
		return this.coaGrsRev;
	}
	
	/**
	 * Column Info
	 * @return grsRev
	 */
	public String getGrsRev() {
		return this.grsRev;
	}
	
	/**
	 * Column Info
	 * @return copyVvd
	 */
	public String getCopyVvd() {
		return this.copyVvd;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	

	/**
	 * Column Info
	 * @param fQtaTgtCd
	 */
	public void setFQtaTgtCd(String fQtaTgtCd) {
		this.fQtaTgtCd = fQtaTgtCd;
	}
	
	/**
	 * Column Info
	 * @param qtaTgtCd
	 */
	public void setQtaTgtCd(String qtaTgtCd) {
		this.qtaTgtCd = qtaTgtCd;
	}
	
	/**
	 * Column Info
	 * @param coaBseWk
	 */
	public void setCoaBseWk(String coaBseWk) {
		this.coaBseWk = coaBseWk;
	}
	
	/**
	 * Column Info
	 * @param isaRgnCd
	 */
	public void setIsaRgnCd(String isaRgnCd) {
		this.isaRgnCd = isaRgnCd;
	}
	
	/**
	 * Column Info
	 * @param fDirCd
	 */
	public void setFDirCd(String fDirCd) {
		this.fDirCd = fDirCd;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param coaBseMon
	 */
	public void setCoaBseMon(String coaBseMon) {
		this.coaBseMon = coaBseMon;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param fBseYr
	 */
	public void setFBseYr(String fBseYr) {
		this.fBseYr = fBseYr;
	}
	
	/**
	 * Column Info
	 * @param fnlBsaCapa
	 */
	public void setFnlBsaCapa(String fnlBsaCapa) {
		this.fnlBsaCapa = fnlBsaCapa;
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
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @param bseMon
	 */
	public void setBseMon(String bseMon) {
		this.bseMon = bseMon;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param potnLnk
	 */
	public void setPotnLnk(String potnLnk) {
		this.potnLnk = potnLnk;
	}
	
	/**
	 * Column Info
	 * @param bseTpCd
	 */
	public void setBseTpCd(String bseTpCd) {
		this.bseTpCd = bseTpCd;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param fBseQtrCd
	 */
	public void setFBseQtrCd(String fBseQtrCd) {
		this.fBseQtrCd = fBseQtrCd;
	}
	
	/**
	 * Column Info
	 * @param splPotn
	 */
	public void setSplPotn(String splPotn) {
		this.splPotn = splPotn;
	}
	
	/**
	 * Column Info
	 * @param qtaRlseVerNo
	 */
	public void setQtaRlseVerNo(String qtaRlseVerNo) {
		this.qtaRlseVerNo = qtaRlseVerNo;
	}
	
	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param lodQty
	 */
	public void setLodQty(String lodQty) {
		this.lodQty = lodQty;
	}
	
	/**
	 * Column Info
	 * @param fClick
	 */
	public void setFClick(String fClick) {
		this.fClick = fClick;
	}
	
	/**
	 * Column Info
	 * @param coaLodQty
	 */
	public void setCoaLodQty(String coaLodQty) {
		this.coaLodQty = coaLodQty;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param bseWk
	 */
	public void setBseWk(String bseWk) {
		this.bseWk = bseWk;
	}
	
	/**
	 * Column Info
	 * @param coaFnlBsaCapa
	 */
	public void setCoaFnlBsaCapa(String coaFnlBsaCapa) {
		this.coaFnlBsaCapa = coaFnlBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param coaVvd
	 */
	public void setCoaVvd(String coaVvd) {
		this.coaVvd = coaVvd;
	}
	
	/**
	 * Column Info
	 * @param fBseTpCd
	 */
	public void setFBseTpCd(String fBseTpCd) {
		this.fBseTpCd = fBseTpCd;
	}
	
	/**
	 * Column Info
	 * @param fUsrId
	 */
	public void setFUsrId(String fUsrId) {
		this.fUsrId = fUsrId;
	}
	
	/**
	 * Column Info
	 * @param fTrdCd
	 */
	public void setFTrdCd(String fTrdCd) {
		this.fTrdCd = fTrdCd;
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
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	/**
	 * Column Info
	 * @param coaGrsRev
	 */
	public void setCoaGrsRev(String coaGrsRev) {
		this.coaGrsRev = coaGrsRev;
	}
	
	/**
	 * Column Info
	 * @param grsRev
	 */
	public void setGrsRev(String grsRev) {
		this.grsRev = grsRev;
	}
	
	/**
	 * Column Info
	 * @param copyVvd
	 */
	public void setCopyVvd(String copyVvd) {
		this.copyVvd = copyVvd;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
		setFQtaTgtCd(JSPUtil.getParameter(request, prefix + "f_qta_tgt_cd", ""));
		setQtaTgtCd(JSPUtil.getParameter(request, prefix + "qta_tgt_cd", ""));
		setCoaBseWk(JSPUtil.getParameter(request, prefix + "coa_bse_wk", ""));
		setIsaRgnCd(JSPUtil.getParameter(request, prefix + "isa_rgn_cd", ""));
		setFDirCd(JSPUtil.getParameter(request, prefix + "f_dir_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setCoaBseMon(JSPUtil.getParameter(request, prefix + "coa_bse_mon", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setFBseYr(JSPUtil.getParameter(request, prefix + "f_bse_yr", ""));
		setFnlBsaCapa(JSPUtil.getParameter(request, prefix + "fnl_bsa_capa", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setBseMon(JSPUtil.getParameter(request, prefix + "bse_mon", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setPotnLnk(JSPUtil.getParameter(request, prefix + "potn_lnk", ""));
		setBseTpCd(JSPUtil.getParameter(request, prefix + "bse_tp_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setFBseQtrCd(JSPUtil.getParameter(request, prefix + "f_bse_qtr_cd", ""));
		setSplPotn(JSPUtil.getParameter(request, prefix + "spl_potn", ""));
		setQtaRlseVerNo(JSPUtil.getParameter(request, prefix + "qta_rlse_ver_no", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setLodQty(JSPUtil.getParameter(request, prefix + "lod_qty", ""));
		setFClick(JSPUtil.getParameter(request, prefix + "f_click", ""));
		setCoaLodQty(JSPUtil.getParameter(request, prefix + "coa_lod_qty", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setBseWk(JSPUtil.getParameter(request, prefix + "bse_wk", ""));
		setCoaFnlBsaCapa(JSPUtil.getParameter(request, prefix + "coa_fnl_bsa_capa", ""));
		setCoaVvd(JSPUtil.getParameter(request, prefix + "coa_vvd", ""));
		setFBseTpCd(JSPUtil.getParameter(request, prefix + "f_bse_tp_cd", ""));
		setFUsrId(JSPUtil.getParameter(request, prefix + "f_usr_id", ""));
		setFTrdCd(JSPUtil.getParameter(request, prefix + "f_trd_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setFlag(JSPUtil.getParameter(request, prefix + "flag", ""));
		setCoaGrsRev(JSPUtil.getParameter(request, prefix + "coa_grs_rev", ""));
		setGrsRev(JSPUtil.getParameter(request, prefix + "grs_rev", ""));
		setCopyVvd(JSPUtil.getParameter(request, prefix + "copy_vvd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ManageQtaAdjustmentVO[]
	 */
	public ManageQtaAdjustmentVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ManageQtaAdjustmentVO[]
	 */
	public ManageQtaAdjustmentVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ManageQtaAdjustmentVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fQtaTgtCd = (JSPUtil.getParameter(request, prefix	+ "f_qta_tgt_cd", length));
			String[] qtaTgtCd = (JSPUtil.getParameter(request, prefix	+ "qta_tgt_cd", length));
			String[] coaBseWk = (JSPUtil.getParameter(request, prefix	+ "coa_bse_wk", length));
			String[] isaRgnCd = (JSPUtil.getParameter(request, prefix	+ "isa_rgn_cd", length));
			String[] fDirCd = (JSPUtil.getParameter(request, prefix	+ "f_dir_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] coaBseMon = (JSPUtil.getParameter(request, prefix	+ "coa_bse_mon", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] fBseYr = (JSPUtil.getParameter(request, prefix	+ "f_bse_yr", length));
			String[] fnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_bsa_capa", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] potnLnk = (JSPUtil.getParameter(request, prefix	+ "potn_lnk", length));
			String[] bseTpCd = (JSPUtil.getParameter(request, prefix	+ "bse_tp_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] fBseQtrCd = (JSPUtil.getParameter(request, prefix	+ "f_bse_qtr_cd", length));
			String[] splPotn = (JSPUtil.getParameter(request, prefix	+ "spl_potn", length));
			String[] qtaRlseVerNo = (JSPUtil.getParameter(request, prefix	+ "qta_rlse_ver_no", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] fClick = (JSPUtil.getParameter(request, prefix	+ "f_click", length));
			String[] coaLodQty = (JSPUtil.getParameter(request, prefix	+ "coa_lod_qty", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] coaFnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "coa_fnl_bsa_capa", length));
			String[] coaVvd = (JSPUtil.getParameter(request, prefix	+ "coa_vvd", length));
			String[] fBseTpCd = (JSPUtil.getParameter(request, prefix	+ "f_bse_tp_cd", length));
			String[] fUsrId = (JSPUtil.getParameter(request, prefix	+ "f_usr_id", length));
			String[] fTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_trd_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] flag = (JSPUtil.getParameter(request, prefix	+ "flag", length));
			String[] coaGrsRev = (JSPUtil.getParameter(request, prefix	+ "coa_grs_rev", length));
			String[] grsRev = (JSPUtil.getParameter(request, prefix	+ "grs_rev", length));
			String[] copyVvd = (JSPUtil.getParameter(request, prefix	+ "copy_vvd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ManageQtaAdjustmentVO();
				if (fQtaTgtCd[i] != null)
					model.setFQtaTgtCd(fQtaTgtCd[i]);
				if (qtaTgtCd[i] != null)
					model.setQtaTgtCd(qtaTgtCd[i]);
				if (coaBseWk[i] != null)
					model.setCoaBseWk(coaBseWk[i]);
				if (isaRgnCd[i] != null)
					model.setIsaRgnCd(isaRgnCd[i]);
				if (fDirCd[i] != null)
					model.setFDirCd(fDirCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (coaBseMon[i] != null)
					model.setCoaBseMon(coaBseMon[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (fBseYr[i] != null)
					model.setFBseYr(fBseYr[i]);
				if (fnlBsaCapa[i] != null)
					model.setFnlBsaCapa(fnlBsaCapa[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (potnLnk[i] != null)
					model.setPotnLnk(potnLnk[i]);
				if (bseTpCd[i] != null)
					model.setBseTpCd(bseTpCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (fBseQtrCd[i] != null)
					model.setFBseQtrCd(fBseQtrCd[i]);
				if (splPotn[i] != null)
					model.setSplPotn(splPotn[i]);
				if (qtaRlseVerNo[i] != null)
					model.setQtaRlseVerNo(qtaRlseVerNo[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (fClick[i] != null)
					model.setFClick(fClick[i]);
				if (coaLodQty[i] != null)
					model.setCoaLodQty(coaLodQty[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (bseWk[i] != null)
					model.setBseWk(bseWk[i]);
				if (coaFnlBsaCapa[i] != null)
					model.setCoaFnlBsaCapa(coaFnlBsaCapa[i]);
				if (coaVvd[i] != null)
					model.setCoaVvd(coaVvd[i]);
				if (fBseTpCd[i] != null)
					model.setFBseTpCd(fBseTpCd[i]);
				if (fUsrId[i] != null)
					model.setFUsrId(fUsrId[i]);
				if (fTrdCd[i] != null)
					model.setFTrdCd(fTrdCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (flag[i] != null)
					model.setFlag(flag[i]);
				if (coaGrsRev[i] != null)
					model.setCoaGrsRev(coaGrsRev[i]);
				if (grsRev[i] != null)
					model.setGrsRev(grsRev[i]);
				if (copyVvd[i] != null)
					model.setCopyVvd(copyVvd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getManageQtaAdjustmentVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ManageQtaAdjustmentVO[]
	 */
	public ManageQtaAdjustmentVO[] getManageQtaAdjustmentVOs(){
		ManageQtaAdjustmentVO[] vos = (ManageQtaAdjustmentVO[])models.toArray(new ManageQtaAdjustmentVO[models.size()]);
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
		this.fQtaTgtCd = this.fQtaTgtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaTgtCd = this.qtaTgtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaBseWk = this.coaBseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isaRgnCd = this.isaRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDirCd = this.fDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaBseMon = this.coaBseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBseYr = this.fBseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBsaCapa = this.fnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.potnLnk = this.potnLnk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseTpCd = this.bseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBseQtrCd = this.fBseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splPotn = this.splPotn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaRlseVerNo = this.qtaRlseVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fClick = this.fClick .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaLodQty = this.coaLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaFnlBsaCapa = this.coaFnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaVvd = this.coaVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBseTpCd = this.fBseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fUsrId = this.fUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTrdCd = this.fTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flag = this.flag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaGrsRev = this.coaGrsRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRev = this.grsRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copyVvd = this.copyVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
