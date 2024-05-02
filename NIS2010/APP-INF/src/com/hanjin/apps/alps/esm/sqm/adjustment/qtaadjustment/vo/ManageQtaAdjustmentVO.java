/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ManageQtaAdjustmentVO.java
*@FileTitle : ManageQtaAdjustmentVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.15
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.03.15 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ManageQtaAdjustmentVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ManageQtaAdjustmentVO> models = new ArrayList<ManageQtaAdjustmentVO>();
	
	/* Column Info */
	private String fBseYr = null;
	/* Column Info */
	private String fTrdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String flag = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String adjVvd = null;
	/* Column Info */
	private String fQtaTgtCd = null;
	/* Column Info */
	private String bseMon = null;
	/* Column Info */
	private String bseTpCd = null;
	/* Column Info */
	private String masPfGrpCd = null;
	/* Column Info */
	private String potnLnk = null;
	/* Column Info */
	private String masVvd = null;
	/* Column Info */
	private String fBseTpCd = null;
	/* Column Info */
	private String pfGrpTp = null;
	/* Column Info */
	private String masSlsYrmon = null;
	/* Column Info */
	private String masGrsRev = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String qtaRlseVerNo = null;
	/* Column Info */
	private String isaRgnCd = null;
	/* Column Info */
	private String fBseQtrCd = null;
	/* Column Info */
	private String fnlBsaCapa = null;
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String grsRev = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String masLodQty = null;
	/* Column Info */
	private String masCostYrmon = null;
	/* Column Info */
	private String qtaTgtCd = null;
	/* Column Info */
	private String splPotn = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String masBseMon = null;
	/* Column Info */
	private String bseWk = null;
	/* Column Info */
	private String fClick = null;
	/* Column Info */
	private String fDirCd = null;
	/* Column Info */
	private String pfGrpCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String masBseWk = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String masFnlBsaCapa = null;
	/* Column Info */
	private String copyVvd = null;
	/* Column Info */
	private String fUsrId = null;
	/* Column Info */
	private String dirCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ManageQtaAdjustmentVO() {}

	public ManageQtaAdjustmentVO(String ibflag, String pagerows, String qtaTgtCd, String fQtaTgtCd, String masBseWk, String fDirCd, String isaRgnCd, String trdCd, String rlaneCd, String masBseMon, String fBseYr, String fnlBsaCapa, String bseQtrCd, String bseMon, String usrId, String potnLnk, String bseTpCd, String dirCd, String fBseQtrCd, String splPotn, String qtaRlseVerNo, String iocCd, String lodQty, String fClick, String masLodQty, String masSlsYrmon, String masCostYrmon, String bseYr, String bseWk, String fBseTpCd, String masVvd, String masFnlBsaCapa, String fUsrId, String vvd, String fTrdCd, String flag, String grsRev, String masGrsRev, String copyVvd, String subTrdCd, String adjVvd, String pfGrpCd, String masPfGrpCd, String pfGrpTp) {
		this.fBseYr = fBseYr;
		this.fTrdCd = fTrdCd;
		this.rlaneCd = rlaneCd;
		this.flag = flag;
		this.ibflag = ibflag;
		this.iocCd = iocCd;
		this.adjVvd = adjVvd;
		this.fQtaTgtCd = fQtaTgtCd;
		this.bseMon = bseMon;
		this.bseTpCd = bseTpCd;
		this.masPfGrpCd = masPfGrpCd;
		this.potnLnk = potnLnk;
		this.masVvd = masVvd;
		this.fBseTpCd = fBseTpCd;
		this.pfGrpTp = pfGrpTp;
		this.masSlsYrmon = masSlsYrmon;
		this.masGrsRev = masGrsRev;
		this.pagerows = pagerows;
		this.qtaRlseVerNo = qtaRlseVerNo;
		this.isaRgnCd = isaRgnCd;
		this.fBseQtrCd = fBseQtrCd;
		this.fnlBsaCapa = fnlBsaCapa;
		this.lodQty = lodQty;
		this.grsRev = grsRev;
		this.vvd = vvd;
		this.usrId = usrId;
		this.masLodQty = masLodQty;
		this.masCostYrmon = masCostYrmon;
		this.qtaTgtCd = qtaTgtCd;
		this.splPotn = splPotn;
		this.trdCd = trdCd;
		this.masBseMon = masBseMon;
		this.bseWk = bseWk;
		this.fClick = fClick;
		this.fDirCd = fDirCd;
		this.pfGrpCd = pfGrpCd;
		this.bseYr = bseYr;
		this.subTrdCd = subTrdCd;
		this.masBseWk = masBseWk;
		this.bseQtrCd = bseQtrCd;
		this.masFnlBsaCapa = masFnlBsaCapa;
		this.copyVvd = copyVvd;
		this.fUsrId = fUsrId;
		this.dirCd = dirCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_bse_yr", getFBseYr());
		this.hashColumns.put("f_trd_cd", getFTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("flag", getFlag());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("adj_vvd", getAdjVvd());
		this.hashColumns.put("f_qta_tgt_cd", getFQtaTgtCd());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("bse_tp_cd", getBseTpCd());
		this.hashColumns.put("mas_pf_grp_cd", getMasPfGrpCd());
		this.hashColumns.put("potn_lnk", getPotnLnk());
		this.hashColumns.put("mas_vvd", getMasVvd());
		this.hashColumns.put("f_bse_tp_cd", getFBseTpCd());
		this.hashColumns.put("pf_grp_tp", getPfGrpTp());
		this.hashColumns.put("mas_sls_yrmon", getMasSlsYrmon());
		this.hashColumns.put("mas_grs_rev", getMasGrsRev());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("qta_rlse_ver_no", getQtaRlseVerNo());
		this.hashColumns.put("isa_rgn_cd", getIsaRgnCd());
		this.hashColumns.put("f_bse_qtr_cd", getFBseQtrCd());
		this.hashColumns.put("fnl_bsa_capa", getFnlBsaCapa());
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("grs_rev", getGrsRev());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("mas_lod_qty", getMasLodQty());
		this.hashColumns.put("mas_cost_yrmon", getMasCostYrmon());
		this.hashColumns.put("qta_tgt_cd", getQtaTgtCd());
		this.hashColumns.put("spl_potn", getSplPotn());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("mas_bse_mon", getMasBseMon());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("f_click", getFClick());
		this.hashColumns.put("f_dir_cd", getFDirCd());
		this.hashColumns.put("pf_grp_cd", getPfGrpCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("mas_bse_wk", getMasBseWk());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("mas_fnl_bsa_capa", getMasFnlBsaCapa());
		this.hashColumns.put("copy_vvd", getCopyVvd());
		this.hashColumns.put("f_usr_id", getFUsrId());
		this.hashColumns.put("dir_cd", getDirCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_bse_yr", "fBseYr");
		this.hashFields.put("f_trd_cd", "fTrdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("flag", "flag");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("adj_vvd", "adjVvd");
		this.hashFields.put("f_qta_tgt_cd", "fQtaTgtCd");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("bse_tp_cd", "bseTpCd");
		this.hashFields.put("mas_pf_grp_cd", "masPfGrpCd");
		this.hashFields.put("potn_lnk", "potnLnk");
		this.hashFields.put("mas_vvd", "masVvd");
		this.hashFields.put("f_bse_tp_cd", "fBseTpCd");
		this.hashFields.put("pf_grp_tp", "pfGrpTp");
		this.hashFields.put("mas_sls_yrmon", "masSlsYrmon");
		this.hashFields.put("mas_grs_rev", "masGrsRev");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("qta_rlse_ver_no", "qtaRlseVerNo");
		this.hashFields.put("isa_rgn_cd", "isaRgnCd");
		this.hashFields.put("f_bse_qtr_cd", "fBseQtrCd");
		this.hashFields.put("fnl_bsa_capa", "fnlBsaCapa");
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("grs_rev", "grsRev");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("mas_lod_qty", "masLodQty");
		this.hashFields.put("mas_cost_yrmon", "masCostYrmon");
		this.hashFields.put("qta_tgt_cd", "qtaTgtCd");
		this.hashFields.put("spl_potn", "splPotn");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("mas_bse_mon", "masBseMon");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("f_click", "fClick");
		this.hashFields.put("f_dir_cd", "fDirCd");
		this.hashFields.put("pf_grp_cd", "pfGrpCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("mas_bse_wk", "masBseWk");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("mas_fnl_bsa_capa", "masFnlBsaCapa");
		this.hashFields.put("copy_vvd", "copyVvd");
		this.hashFields.put("f_usr_id", "fUsrId");
		this.hashFields.put("dir_cd", "dirCd");
		return this.hashFields;
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
	 * @return fTrdCd
	 */
	public String getFTrdCd() {
		return this.fTrdCd;
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
	 * @return flag
	 */
	public String getFlag() {
		return this.flag;
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
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return adjVvd
	 */
	public String getAdjVvd() {
		return this.adjVvd;
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
	 * @return bseMon
	 */
	public String getBseMon() {
		return this.bseMon;
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
	 * @return masPfGrpCd
	 */
	public String getMasPfGrpCd() {
		return this.masPfGrpCd;
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
	 * @return masVvd
	 */
	public String getMasVvd() {
		return this.masVvd;
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
	 * @return pfGrpTp
	 */
	public String getPfGrpTp() {
		return this.pfGrpTp;
	}
	
	/**
	 * Column Info
	 * @return masSlsYrmon
	 */
	public String getMasSlsYrmon() {
		return this.masSlsYrmon;
	}
	
	/**
	 * Column Info
	 * @return masGrsRev
	 */
	public String getMasGrsRev() {
		return this.masGrsRev;
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
	 * @return qtaRlseVerNo
	 */
	public String getQtaRlseVerNo() {
		return this.qtaRlseVerNo;
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
	 * @return fBseQtrCd
	 */
	public String getFBseQtrCd() {
		return this.fBseQtrCd;
	}
	
	/**
	 * Column Info
	 * @return fnlBsaCapa
	 */
	public String getFnlBsaCapa() {
		return this.fnlBsaCapa;
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
	 * @return grsRev
	 */
	public String getGrsRev() {
		return this.grsRev;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return masLodQty
	 */
	public String getMasLodQty() {
		return this.masLodQty;
	}
	
	/**
	 * Column Info
	 * @return masCostYrmon
	 */
	public String getMasCostYrmon() {
		return this.masCostYrmon;
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
	 * @return splPotn
	 */
	public String getSplPotn() {
		return this.splPotn;
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
	 * @return masBseMon
	 */
	public String getMasBseMon() {
		return this.masBseMon;
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
	 * @return fClick
	 */
	public String getFClick() {
		return this.fClick;
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
	 * @return pfGrpCd
	 */
	public String getPfGrpCd() {
		return this.pfGrpCd;
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
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return masBseWk
	 */
	public String getMasBseWk() {
		return this.masBseWk;
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
	 * @return masFnlBsaCapa
	 */
	public String getMasFnlBsaCapa() {
		return this.masFnlBsaCapa;
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
	 * @return fUsrId
	 */
	public String getFUsrId() {
		return this.fUsrId;
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
	 * @param fBseYr
	 */
	public void setFBseYr(String fBseYr) {
		this.fBseYr = fBseYr;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param adjVvd
	 */
	public void setAdjVvd(String adjVvd) {
		this.adjVvd = adjVvd;
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
	 * @param bseMon
	 */
	public void setBseMon(String bseMon) {
		this.bseMon = bseMon;
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
	 * @param masPfGrpCd
	 */
	public void setMasPfGrpCd(String masPfGrpCd) {
		this.masPfGrpCd = masPfGrpCd;
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
	 * @param masVvd
	 */
	public void setMasVvd(String masVvd) {
		this.masVvd = masVvd;
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
	 * @param pfGrpTp
	 */
	public void setPfGrpTp(String pfGrpTp) {
		this.pfGrpTp = pfGrpTp;
	}
	
	/**
	 * Column Info
	 * @param masSlsYrmon
	 */
	public void setMasSlsYrmon(String masSlsYrmon) {
		this.masSlsYrmon = masSlsYrmon;
	}
	
	/**
	 * Column Info
	 * @param masGrsRev
	 */
	public void setMasGrsRev(String masGrsRev) {
		this.masGrsRev = masGrsRev;
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
	 * @param qtaRlseVerNo
	 */
	public void setQtaRlseVerNo(String qtaRlseVerNo) {
		this.qtaRlseVerNo = qtaRlseVerNo;
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
	 * @param fBseQtrCd
	 */
	public void setFBseQtrCd(String fBseQtrCd) {
		this.fBseQtrCd = fBseQtrCd;
	}
	
	/**
	 * Column Info
	 * @param fnlBsaCapa
	 */
	public void setFnlBsaCapa(String fnlBsaCapa) {
		this.fnlBsaCapa = fnlBsaCapa;
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
	 * @param grsRev
	 */
	public void setGrsRev(String grsRev) {
		this.grsRev = grsRev;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param masLodQty
	 */
	public void setMasLodQty(String masLodQty) {
		this.masLodQty = masLodQty;
	}
	
	/**
	 * Column Info
	 * @param masCostYrmon
	 */
	public void setMasCostYrmon(String masCostYrmon) {
		this.masCostYrmon = masCostYrmon;
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
	 * @param splPotn
	 */
	public void setSplPotn(String splPotn) {
		this.splPotn = splPotn;
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
	 * @param masBseMon
	 */
	public void setMasBseMon(String masBseMon) {
		this.masBseMon = masBseMon;
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
	 * @param fClick
	 */
	public void setFClick(String fClick) {
		this.fClick = fClick;
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
	 * @param pfGrpCd
	 */
	public void setPfGrpCd(String pfGrpCd) {
		this.pfGrpCd = pfGrpCd;
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
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param masBseWk
	 */
	public void setMasBseWk(String masBseWk) {
		this.masBseWk = masBseWk;
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
	 * @param masFnlBsaCapa
	 */
	public void setMasFnlBsaCapa(String masFnlBsaCapa) {
		this.masFnlBsaCapa = masFnlBsaCapa;
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
	 * @param fUsrId
	 */
	public void setFUsrId(String fUsrId) {
		this.fUsrId = fUsrId;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
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
		setFBseYr(JSPUtil.getParameter(request, prefix + "f_bse_yr", ""));
		setFTrdCd(JSPUtil.getParameter(request, prefix + "f_trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setFlag(JSPUtil.getParameter(request, prefix + "flag", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setAdjVvd(JSPUtil.getParameter(request, prefix + "adj_vvd", ""));
		setFQtaTgtCd(JSPUtil.getParameter(request, prefix + "f_qta_tgt_cd", ""));
		setBseMon(JSPUtil.getParameter(request, prefix + "bse_mon", ""));
		setBseTpCd(JSPUtil.getParameter(request, prefix + "bse_tp_cd", ""));
		setMasPfGrpCd(JSPUtil.getParameter(request, prefix + "mas_pf_grp_cd", ""));
		setPotnLnk(JSPUtil.getParameter(request, prefix + "potn_lnk", ""));
		setMasVvd(JSPUtil.getParameter(request, prefix + "mas_vvd", ""));
		setFBseTpCd(JSPUtil.getParameter(request, prefix + "f_bse_tp_cd", ""));
		setPfGrpTp(JSPUtil.getParameter(request, prefix + "pf_grp_tp", ""));
		setMasSlsYrmon(JSPUtil.getParameter(request, prefix + "mas_sls_yrmon", ""));
		setMasGrsRev(JSPUtil.getParameter(request, prefix + "mas_grs_rev", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setQtaRlseVerNo(JSPUtil.getParameter(request, prefix + "qta_rlse_ver_no", ""));
		setIsaRgnCd(JSPUtil.getParameter(request, prefix + "isa_rgn_cd", ""));
		setFBseQtrCd(JSPUtil.getParameter(request, prefix + "f_bse_qtr_cd", ""));
		setFnlBsaCapa(JSPUtil.getParameter(request, prefix + "fnl_bsa_capa", ""));
		setLodQty(JSPUtil.getParameter(request, prefix + "lod_qty", ""));
		setGrsRev(JSPUtil.getParameter(request, prefix + "grs_rev", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setMasLodQty(JSPUtil.getParameter(request, prefix + "mas_lod_qty", ""));
		setMasCostYrmon(JSPUtil.getParameter(request, prefix + "mas_cost_yrmon", ""));
		setQtaTgtCd(JSPUtil.getParameter(request, prefix + "qta_tgt_cd", ""));
		setSplPotn(JSPUtil.getParameter(request, prefix + "spl_potn", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setMasBseMon(JSPUtil.getParameter(request, prefix + "mas_bse_mon", ""));
		setBseWk(JSPUtil.getParameter(request, prefix + "bse_wk", ""));
		setFClick(JSPUtil.getParameter(request, prefix + "f_click", ""));
		setFDirCd(JSPUtil.getParameter(request, prefix + "f_dir_cd", ""));
		setPfGrpCd(JSPUtil.getParameter(request, prefix + "pf_grp_cd", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setMasBseWk(JSPUtil.getParameter(request, prefix + "mas_bse_wk", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setMasFnlBsaCapa(JSPUtil.getParameter(request, prefix + "mas_fnl_bsa_capa", ""));
		setCopyVvd(JSPUtil.getParameter(request, prefix + "copy_vvd", ""));
		setFUsrId(JSPUtil.getParameter(request, prefix + "f_usr_id", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
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
			String[] fBseYr = (JSPUtil.getParameter(request, prefix	+ "f_bse_yr", length));
			String[] fTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] flag = (JSPUtil.getParameter(request, prefix	+ "flag", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] adjVvd = (JSPUtil.getParameter(request, prefix	+ "adj_vvd", length));
			String[] fQtaTgtCd = (JSPUtil.getParameter(request, prefix	+ "f_qta_tgt_cd", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] bseTpCd = (JSPUtil.getParameter(request, prefix	+ "bse_tp_cd", length));
			String[] masPfGrpCd = (JSPUtil.getParameter(request, prefix	+ "mas_pf_grp_cd", length));
			String[] potnLnk = (JSPUtil.getParameter(request, prefix	+ "potn_lnk", length));
			String[] masVvd = (JSPUtil.getParameter(request, prefix	+ "mas_vvd", length));
			String[] fBseTpCd = (JSPUtil.getParameter(request, prefix	+ "f_bse_tp_cd", length));
			String[] pfGrpTp = (JSPUtil.getParameter(request, prefix	+ "pf_grp_tp", length));
			String[] masSlsYrmon = (JSPUtil.getParameter(request, prefix	+ "mas_sls_yrmon", length));
			String[] masGrsRev = (JSPUtil.getParameter(request, prefix	+ "mas_grs_rev", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] qtaRlseVerNo = (JSPUtil.getParameter(request, prefix	+ "qta_rlse_ver_no", length));
			String[] isaRgnCd = (JSPUtil.getParameter(request, prefix	+ "isa_rgn_cd", length));
			String[] fBseQtrCd = (JSPUtil.getParameter(request, prefix	+ "f_bse_qtr_cd", length));
			String[] fnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_bsa_capa", length));
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] grsRev = (JSPUtil.getParameter(request, prefix	+ "grs_rev", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] masLodQty = (JSPUtil.getParameter(request, prefix	+ "mas_lod_qty", length));
			String[] masCostYrmon = (JSPUtil.getParameter(request, prefix	+ "mas_cost_yrmon", length));
			String[] qtaTgtCd = (JSPUtil.getParameter(request, prefix	+ "qta_tgt_cd", length));
			String[] splPotn = (JSPUtil.getParameter(request, prefix	+ "spl_potn", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] masBseMon = (JSPUtil.getParameter(request, prefix	+ "mas_bse_mon", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] fClick = (JSPUtil.getParameter(request, prefix	+ "f_click", length));
			String[] fDirCd = (JSPUtil.getParameter(request, prefix	+ "f_dir_cd", length));
			String[] pfGrpCd = (JSPUtil.getParameter(request, prefix	+ "pf_grp_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] masBseWk = (JSPUtil.getParameter(request, prefix	+ "mas_bse_wk", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] masFnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "mas_fnl_bsa_capa", length));
			String[] copyVvd = (JSPUtil.getParameter(request, prefix	+ "copy_vvd", length));
			String[] fUsrId = (JSPUtil.getParameter(request, prefix	+ "f_usr_id", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ManageQtaAdjustmentVO();
				if (fBseYr[i] != null)
					model.setFBseYr(fBseYr[i]);
				if (fTrdCd[i] != null)
					model.setFTrdCd(fTrdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (flag[i] != null)
					model.setFlag(flag[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (adjVvd[i] != null)
					model.setAdjVvd(adjVvd[i]);
				if (fQtaTgtCd[i] != null)
					model.setFQtaTgtCd(fQtaTgtCd[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (bseTpCd[i] != null)
					model.setBseTpCd(bseTpCd[i]);
				if (masPfGrpCd[i] != null)
					model.setMasPfGrpCd(masPfGrpCd[i]);
				if (potnLnk[i] != null)
					model.setPotnLnk(potnLnk[i]);
				if (masVvd[i] != null)
					model.setMasVvd(masVvd[i]);
				if (fBseTpCd[i] != null)
					model.setFBseTpCd(fBseTpCd[i]);
				if (pfGrpTp[i] != null)
					model.setPfGrpTp(pfGrpTp[i]);
				if (masSlsYrmon[i] != null)
					model.setMasSlsYrmon(masSlsYrmon[i]);
				if (masGrsRev[i] != null)
					model.setMasGrsRev(masGrsRev[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (qtaRlseVerNo[i] != null)
					model.setQtaRlseVerNo(qtaRlseVerNo[i]);
				if (isaRgnCd[i] != null)
					model.setIsaRgnCd(isaRgnCd[i]);
				if (fBseQtrCd[i] != null)
					model.setFBseQtrCd(fBseQtrCd[i]);
				if (fnlBsaCapa[i] != null)
					model.setFnlBsaCapa(fnlBsaCapa[i]);
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (grsRev[i] != null)
					model.setGrsRev(grsRev[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (masLodQty[i] != null)
					model.setMasLodQty(masLodQty[i]);
				if (masCostYrmon[i] != null)
					model.setMasCostYrmon(masCostYrmon[i]);
				if (qtaTgtCd[i] != null)
					model.setQtaTgtCd(qtaTgtCd[i]);
				if (splPotn[i] != null)
					model.setSplPotn(splPotn[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (masBseMon[i] != null)
					model.setMasBseMon(masBseMon[i]);
				if (bseWk[i] != null)
					model.setBseWk(bseWk[i]);
				if (fClick[i] != null)
					model.setFClick(fClick[i]);
				if (fDirCd[i] != null)
					model.setFDirCd(fDirCd[i]);
				if (pfGrpCd[i] != null)
					model.setPfGrpCd(pfGrpCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (masBseWk[i] != null)
					model.setMasBseWk(masBseWk[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (masFnlBsaCapa[i] != null)
					model.setMasFnlBsaCapa(masFnlBsaCapa[i]);
				if (copyVvd[i] != null)
					model.setCopyVvd(copyVvd[i]);
				if (fUsrId[i] != null)
					model.setFUsrId(fUsrId[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
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
		this.fBseYr = this.fBseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTrdCd = this.fTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flag = this.flag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjVvd = this.adjVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fQtaTgtCd = this.fQtaTgtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseTpCd = this.bseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masPfGrpCd = this.masPfGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.potnLnk = this.potnLnk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masVvd = this.masVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBseTpCd = this.fBseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfGrpTp = this.pfGrpTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masSlsYrmon = this.masSlsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masGrsRev = this.masGrsRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaRlseVerNo = this.qtaRlseVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isaRgnCd = this.isaRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBseQtrCd = this.fBseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBsaCapa = this.fnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRev = this.grsRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masLodQty = this.masLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masCostYrmon = this.masCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaTgtCd = this.qtaTgtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splPotn = this.splPotn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masBseMon = this.masBseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fClick = this.fClick .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDirCd = this.fDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfGrpCd = this.pfGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masBseWk = this.masBseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masFnlBsaCapa = this.masFnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copyVvd = this.copyVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fUsrId = this.fUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
