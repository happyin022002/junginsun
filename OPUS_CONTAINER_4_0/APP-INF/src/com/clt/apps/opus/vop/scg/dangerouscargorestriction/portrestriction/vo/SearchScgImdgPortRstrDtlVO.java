/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchScgImdgPortRstrDtlVO.java
*@FileTitle : SearchScgImdgPortRstrDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.18 장강철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchScgImdgPortRstrDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchScgImdgPortRstrDtlVO> models = new ArrayList<SearchScgImdgPortRstrDtlVO>();
	
	/* Column Info */
	private String passTonOvrVolQty = null;
	/* Column Info */
	private String loadDysStoFlg = null;
	/* Column Info */
	private String passTmlMaxQty = null;
	/* Column Info */
	private String disObrdMaxQty = null;
	/* Column Info */
	private String tsTxtDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String disTxtDesc = null;
	/* Column Info */
	private String passImdgCmptnAuthCd = null;
	/* Column Info */
	private String disTmlMaxQty = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String disDysStoFlg = null;
	/* Column Info */
	private String loadImdgCmptnAuthCd = null;
	/* Column Info */
	private String ndTmHrs = null;
	/* Column Info */
	private String loadTmlMaxQty = null;
	/* Column Info */
	private String tsOneTmHndlMaxQty = null;
	/* Column Info */
	private String disOneTmHndlMaxQty = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String tmlMaxQty = null;
	/* Column Info */
	private String disNdTmHrs = null;
	/* Column Info */
	private String tsDysStoFlg = null;
	/* Column Info */
	private String disImdgCmptnAuthCd = null;
	/* Column Info */
	private String tsTonOvrVolQty = null;
	/* Column Info */
	private String passTxtDesc = null;
	/* Column Info */
	private String txtDesc = null;
	/* Column Info */
	private String passNdTmHrs = null;
	/* Column Info */
	private String tsStoDys = null;
	/* Column Info */
	private String dysStoFlg = null;
	/* Column Info */
	private String passOneTmHndlMaxQty = null;
	/* Column Info */
	private String disStoDys = null;
	/* Column Info */
	private String loadOneTmHndlMaxQty = null;
	/* Column Info */
	private String obrdMaxQty = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String imdgCmptnAuthCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String loadNdTmHrs = null;
	/* Column Info */
	private String tonOvrVolQty = null;
	/* Column Info */
	private String stoDys = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String loadTonOvrVolQty = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String loadObrdMaxQty = null;
	/* Column Info */
	private String passObrdMaxQty = null;
	/* Column Info */
	private String tsImdgCmptnAuthCd = null;
	/* Column Info */
	private String oneTmHndlMaxQty = null;
	/* Column Info */
	private String disTonOvrVolQty = null;
	/* Column Info */
	private String loadStoDys = null;
	/* Column Info */
	private String portProhiTpCd = null;
	/* Column Info */
	private String imdgPortRstrSeq = null;
	/* Column Info */
	private String tsObrdMaxQty = null;
	/* Column Info */
	private String loadTxtDesc = null;
	/* Column Info */
	private String prohiDesc = null;
	/* Column Info */
	private String tsNdTmHrs = null;
	/* Column Info */
	private String tsTmlMaxQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchScgImdgPortRstrDtlVO() {}

	public SearchScgImdgPortRstrDtlVO(String ibflag, String pagerows, String portCd, String imdgPortRstrSeq, String portProhiTpCd, String imdgCmptnAuthCd, String tonOvrVolQty, String ndTmHrs, String tmlMaxQty, String obrdMaxQty, String oneTmHndlMaxQty, String dysStoFlg, String stoDys, String prohiDesc, String txtDesc, String creUsrId, String creDt, String updUsrId, String updDt, String loadStoDys, String disStoDys, String tsStoDys, String loadDysStoFlg, String disDysStoFlg, String tsDysStoFlg, String loadTxtDesc, String disTxtDesc, String tsTxtDesc, String passTxtDesc, String loadTmlMaxQty, String disTmlMaxQty, String tsTmlMaxQty, String passTmlMaxQty, String loadObrdMaxQty, String disObrdMaxQty, String tsObrdMaxQty, String passObrdMaxQty, String loadOneTmHndlMaxQty, String disOneTmHndlMaxQty, String tsOneTmHndlMaxQty, String passOneTmHndlMaxQty, String loadTonOvrVolQty, String disTonOvrVolQty, String tsTonOvrVolQty, String passTonOvrVolQty, String loadNdTmHrs, String disNdTmHrs, String tsNdTmHrs, String passNdTmHrs, String loadImdgCmptnAuthCd, String disImdgCmptnAuthCd, String tsImdgCmptnAuthCd, String passImdgCmptnAuthCd) {
		this.passTonOvrVolQty = passTonOvrVolQty;
		this.loadDysStoFlg = loadDysStoFlg;
		this.passTmlMaxQty = passTmlMaxQty;
		this.disObrdMaxQty = disObrdMaxQty;
		this.tsTxtDesc = tsTxtDesc;
		this.pagerows = pagerows;
		this.disTxtDesc = disTxtDesc;
		this.passImdgCmptnAuthCd = passImdgCmptnAuthCd;
		this.disTmlMaxQty = disTmlMaxQty;
		this.updUsrId = updUsrId;
		this.disDysStoFlg = disDysStoFlg;
		this.loadImdgCmptnAuthCd = loadImdgCmptnAuthCd;
		this.ndTmHrs = ndTmHrs;
		this.loadTmlMaxQty = loadTmlMaxQty;
		this.tsOneTmHndlMaxQty = tsOneTmHndlMaxQty;
		this.disOneTmHndlMaxQty = disOneTmHndlMaxQty;
		this.creUsrId = creUsrId;
		this.tmlMaxQty = tmlMaxQty;
		this.disNdTmHrs = disNdTmHrs;
		this.tsDysStoFlg = tsDysStoFlg;
		this.disImdgCmptnAuthCd = disImdgCmptnAuthCd;
		this.tsTonOvrVolQty = tsTonOvrVolQty;
		this.passTxtDesc = passTxtDesc;
		this.txtDesc = txtDesc;
		this.passNdTmHrs = passNdTmHrs;
		this.tsStoDys = tsStoDys;
		this.dysStoFlg = dysStoFlg;
		this.passOneTmHndlMaxQty = passOneTmHndlMaxQty;
		this.disStoDys = disStoDys;
		this.loadOneTmHndlMaxQty = loadOneTmHndlMaxQty;
		this.obrdMaxQty = obrdMaxQty;
		this.creDt = creDt;
		this.imdgCmptnAuthCd = imdgCmptnAuthCd;
		this.ibflag = ibflag;
		this.loadNdTmHrs = loadNdTmHrs;
		this.tonOvrVolQty = tonOvrVolQty;
		this.stoDys = stoDys;
		this.portCd = portCd;
		this.loadTonOvrVolQty = loadTonOvrVolQty;
		this.updDt = updDt;
		this.loadObrdMaxQty = loadObrdMaxQty;
		this.passObrdMaxQty = passObrdMaxQty;
		this.tsImdgCmptnAuthCd = tsImdgCmptnAuthCd;
		this.oneTmHndlMaxQty = oneTmHndlMaxQty;
		this.disTonOvrVolQty = disTonOvrVolQty;
		this.loadStoDys = loadStoDys;
		this.portProhiTpCd = portProhiTpCd;
		this.imdgPortRstrSeq = imdgPortRstrSeq;
		this.tsObrdMaxQty = tsObrdMaxQty;
		this.loadTxtDesc = loadTxtDesc;
		this.prohiDesc = prohiDesc;
		this.tsNdTmHrs = tsNdTmHrs;
		this.tsTmlMaxQty = tsTmlMaxQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pass_ton_ovr_vol_qty", getPassTonOvrVolQty());
		this.hashColumns.put("load_dys_sto_flg", getLoadDysStoFlg());
		this.hashColumns.put("pass_tml_max_qty", getPassTmlMaxQty());
		this.hashColumns.put("dis_obrd_max_qty", getDisObrdMaxQty());
		this.hashColumns.put("ts_txt_desc", getTsTxtDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dis_txt_desc", getDisTxtDesc());
		this.hashColumns.put("pass_imdg_cmptn_auth_cd", getPassImdgCmptnAuthCd());
		this.hashColumns.put("dis_tml_max_qty", getDisTmlMaxQty());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dis_dys_sto_flg", getDisDysStoFlg());
		this.hashColumns.put("load_imdg_cmptn_auth_cd", getLoadImdgCmptnAuthCd());
		this.hashColumns.put("nd_tm_hrs", getNdTmHrs());
		this.hashColumns.put("load_tml_max_qty", getLoadTmlMaxQty());
		this.hashColumns.put("ts_one_tm_hndl_max_qty", getTsOneTmHndlMaxQty());
		this.hashColumns.put("dis_one_tm_hndl_max_qty", getDisOneTmHndlMaxQty());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("tml_max_qty", getTmlMaxQty());
		this.hashColumns.put("dis_nd_tm_hrs", getDisNdTmHrs());
		this.hashColumns.put("ts_dys_sto_flg", getTsDysStoFlg());
		this.hashColumns.put("dis_imdg_cmptn_auth_cd", getDisImdgCmptnAuthCd());
		this.hashColumns.put("ts_ton_ovr_vol_qty", getTsTonOvrVolQty());
		this.hashColumns.put("pass_txt_desc", getPassTxtDesc());
		this.hashColumns.put("txt_desc", getTxtDesc());
		this.hashColumns.put("pass_nd_tm_hrs", getPassNdTmHrs());
		this.hashColumns.put("ts_sto_dys", getTsStoDys());
		this.hashColumns.put("dys_sto_flg", getDysStoFlg());
		this.hashColumns.put("pass_one_tm_hndl_max_qty", getPassOneTmHndlMaxQty());
		this.hashColumns.put("dis_sto_dys", getDisStoDys());
		this.hashColumns.put("load_one_tm_hndl_max_qty", getLoadOneTmHndlMaxQty());
		this.hashColumns.put("obrd_max_qty", getObrdMaxQty());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("imdg_cmptn_auth_cd", getImdgCmptnAuthCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("load_nd_tm_hrs", getLoadNdTmHrs());
		this.hashColumns.put("ton_ovr_vol_qty", getTonOvrVolQty());
		this.hashColumns.put("sto_dys", getStoDys());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("load_ton_ovr_vol_qty", getLoadTonOvrVolQty());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("load_obrd_max_qty", getLoadObrdMaxQty());
		this.hashColumns.put("pass_obrd_max_qty", getPassObrdMaxQty());
		this.hashColumns.put("ts_imdg_cmptn_auth_cd", getTsImdgCmptnAuthCd());
		this.hashColumns.put("one_tm_hndl_max_qty", getOneTmHndlMaxQty());
		this.hashColumns.put("dis_ton_ovr_vol_qty", getDisTonOvrVolQty());
		this.hashColumns.put("load_sto_dys", getLoadStoDys());
		this.hashColumns.put("port_prohi_tp_cd", getPortProhiTpCd());
		this.hashColumns.put("imdg_port_rstr_seq", getImdgPortRstrSeq());
		this.hashColumns.put("ts_obrd_max_qty", getTsObrdMaxQty());
		this.hashColumns.put("load_txt_desc", getLoadTxtDesc());
		this.hashColumns.put("prohi_desc", getProhiDesc());
		this.hashColumns.put("ts_nd_tm_hrs", getTsNdTmHrs());
		this.hashColumns.put("ts_tml_max_qty", getTsTmlMaxQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pass_ton_ovr_vol_qty", "passTonOvrVolQty");
		this.hashFields.put("load_dys_sto_flg", "loadDysStoFlg");
		this.hashFields.put("pass_tml_max_qty", "passTmlMaxQty");
		this.hashFields.put("dis_obrd_max_qty", "disObrdMaxQty");
		this.hashFields.put("ts_txt_desc", "tsTxtDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dis_txt_desc", "disTxtDesc");
		this.hashFields.put("pass_imdg_cmptn_auth_cd", "passImdgCmptnAuthCd");
		this.hashFields.put("dis_tml_max_qty", "disTmlMaxQty");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dis_dys_sto_flg", "disDysStoFlg");
		this.hashFields.put("load_imdg_cmptn_auth_cd", "loadImdgCmptnAuthCd");
		this.hashFields.put("nd_tm_hrs", "ndTmHrs");
		this.hashFields.put("load_tml_max_qty", "loadTmlMaxQty");
		this.hashFields.put("ts_one_tm_hndl_max_qty", "tsOneTmHndlMaxQty");
		this.hashFields.put("dis_one_tm_hndl_max_qty", "disOneTmHndlMaxQty");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("tml_max_qty", "tmlMaxQty");
		this.hashFields.put("dis_nd_tm_hrs", "disNdTmHrs");
		this.hashFields.put("ts_dys_sto_flg", "tsDysStoFlg");
		this.hashFields.put("dis_imdg_cmptn_auth_cd", "disImdgCmptnAuthCd");
		this.hashFields.put("ts_ton_ovr_vol_qty", "tsTonOvrVolQty");
		this.hashFields.put("pass_txt_desc", "passTxtDesc");
		this.hashFields.put("txt_desc", "txtDesc");
		this.hashFields.put("pass_nd_tm_hrs", "passNdTmHrs");
		this.hashFields.put("ts_sto_dys", "tsStoDys");
		this.hashFields.put("dys_sto_flg", "dysStoFlg");
		this.hashFields.put("pass_one_tm_hndl_max_qty", "passOneTmHndlMaxQty");
		this.hashFields.put("dis_sto_dys", "disStoDys");
		this.hashFields.put("load_one_tm_hndl_max_qty", "loadOneTmHndlMaxQty");
		this.hashFields.put("obrd_max_qty", "obrdMaxQty");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("imdg_cmptn_auth_cd", "imdgCmptnAuthCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("load_nd_tm_hrs", "loadNdTmHrs");
		this.hashFields.put("ton_ovr_vol_qty", "tonOvrVolQty");
		this.hashFields.put("sto_dys", "stoDys");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("load_ton_ovr_vol_qty", "loadTonOvrVolQty");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("load_obrd_max_qty", "loadObrdMaxQty");
		this.hashFields.put("pass_obrd_max_qty", "passObrdMaxQty");
		this.hashFields.put("ts_imdg_cmptn_auth_cd", "tsImdgCmptnAuthCd");
		this.hashFields.put("one_tm_hndl_max_qty", "oneTmHndlMaxQty");
		this.hashFields.put("dis_ton_ovr_vol_qty", "disTonOvrVolQty");
		this.hashFields.put("load_sto_dys", "loadStoDys");
		this.hashFields.put("port_prohi_tp_cd", "portProhiTpCd");
		this.hashFields.put("imdg_port_rstr_seq", "imdgPortRstrSeq");
		this.hashFields.put("ts_obrd_max_qty", "tsObrdMaxQty");
		this.hashFields.put("load_txt_desc", "loadTxtDesc");
		this.hashFields.put("prohi_desc", "prohiDesc");
		this.hashFields.put("ts_nd_tm_hrs", "tsNdTmHrs");
		this.hashFields.put("ts_tml_max_qty", "tsTmlMaxQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return passTonOvrVolQty
	 */
	public String getPassTonOvrVolQty() {
		return this.passTonOvrVolQty;
	}
	
	/**
	 * Column Info
	 * @return loadDysStoFlg
	 */
	public String getLoadDysStoFlg() {
		return this.loadDysStoFlg;
	}
	
	/**
	 * Column Info
	 * @return passTmlMaxQty
	 */
	public String getPassTmlMaxQty() {
		return this.passTmlMaxQty;
	}
	
	/**
	 * Column Info
	 * @return disObrdMaxQty
	 */
	public String getDisObrdMaxQty() {
		return this.disObrdMaxQty;
	}
	
	/**
	 * Column Info
	 * @return tsTxtDesc
	 */
	public String getTsTxtDesc() {
		return this.tsTxtDesc;
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
	 * @return disTxtDesc
	 */
	public String getDisTxtDesc() {
		return this.disTxtDesc;
	}
	
	/**
	 * Column Info
	 * @return passImdgCmptnAuthCd
	 */
	public String getPassImdgCmptnAuthCd() {
		return this.passImdgCmptnAuthCd;
	}
	
	/**
	 * Column Info
	 * @return disTmlMaxQty
	 */
	public String getDisTmlMaxQty() {
		return this.disTmlMaxQty;
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
	 * @return disDysStoFlg
	 */
	public String getDisDysStoFlg() {
		return this.disDysStoFlg;
	}
	
	/**
	 * Column Info
	 * @return loadImdgCmptnAuthCd
	 */
	public String getLoadImdgCmptnAuthCd() {
		return this.loadImdgCmptnAuthCd;
	}
	
	/**
	 * Column Info
	 * @return ndTmHrs
	 */
	public String getNdTmHrs() {
		return this.ndTmHrs;
	}
	
	/**
	 * Column Info
	 * @return loadTmlMaxQty
	 */
	public String getLoadTmlMaxQty() {
		return this.loadTmlMaxQty;
	}
	
	/**
	 * Column Info
	 * @return tsOneTmHndlMaxQty
	 */
	public String getTsOneTmHndlMaxQty() {
		return this.tsOneTmHndlMaxQty;
	}
	
	/**
	 * Column Info
	 * @return disOneTmHndlMaxQty
	 */
	public String getDisOneTmHndlMaxQty() {
		return this.disOneTmHndlMaxQty;
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
	 * @return tmlMaxQty
	 */
	public String getTmlMaxQty() {
		return this.tmlMaxQty;
	}
	
	/**
	 * Column Info
	 * @return disNdTmHrs
	 */
	public String getDisNdTmHrs() {
		return this.disNdTmHrs;
	}
	
	/**
	 * Column Info
	 * @return tsDysStoFlg
	 */
	public String getTsDysStoFlg() {
		return this.tsDysStoFlg;
	}
	
	/**
	 * Column Info
	 * @return disImdgCmptnAuthCd
	 */
	public String getDisImdgCmptnAuthCd() {
		return this.disImdgCmptnAuthCd;
	}
	
	/**
	 * Column Info
	 * @return tsTonOvrVolQty
	 */
	public String getTsTonOvrVolQty() {
		return this.tsTonOvrVolQty;
	}
	
	/**
	 * Column Info
	 * @return passTxtDesc
	 */
	public String getPassTxtDesc() {
		return this.passTxtDesc;
	}
	
	/**
	 * Column Info
	 * @return txtDesc
	 */
	public String getTxtDesc() {
		return this.txtDesc;
	}
	
	/**
	 * Column Info
	 * @return passNdTmHrs
	 */
	public String getPassNdTmHrs() {
		return this.passNdTmHrs;
	}
	
	/**
	 * Column Info
	 * @return tsStoDys
	 */
	public String getTsStoDys() {
		return this.tsStoDys;
	}
	
	/**
	 * Column Info
	 * @return dysStoFlg
	 */
	public String getDysStoFlg() {
		return this.dysStoFlg;
	}
	
	/**
	 * Column Info
	 * @return passOneTmHndlMaxQty
	 */
	public String getPassOneTmHndlMaxQty() {
		return this.passOneTmHndlMaxQty;
	}
	
	/**
	 * Column Info
	 * @return disStoDys
	 */
	public String getDisStoDys() {
		return this.disStoDys;
	}
	
	/**
	 * Column Info
	 * @return loadOneTmHndlMaxQty
	 */
	public String getLoadOneTmHndlMaxQty() {
		return this.loadOneTmHndlMaxQty;
	}
	
	/**
	 * Column Info
	 * @return obrdMaxQty
	 */
	public String getObrdMaxQty() {
		return this.obrdMaxQty;
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
	 * @return imdgCmptnAuthCd
	 */
	public String getImdgCmptnAuthCd() {
		return this.imdgCmptnAuthCd;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return loadNdTmHrs
	 */
	public String getLoadNdTmHrs() {
		return this.loadNdTmHrs;
	}
	
	/**
	 * Column Info
	 * @return tonOvrVolQty
	 */
	public String getTonOvrVolQty() {
		return this.tonOvrVolQty;
	}
	
	/**
	 * Column Info
	 * @return stoDys
	 */
	public String getStoDys() {
		return this.stoDys;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return loadTonOvrVolQty
	 */
	public String getLoadTonOvrVolQty() {
		return this.loadTonOvrVolQty;
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
	 * @return loadObrdMaxQty
	 */
	public String getLoadObrdMaxQty() {
		return this.loadObrdMaxQty;
	}
	
	/**
	 * Column Info
	 * @return passObrdMaxQty
	 */
	public String getPassObrdMaxQty() {
		return this.passObrdMaxQty;
	}
	
	/**
	 * Column Info
	 * @return tsImdgCmptnAuthCd
	 */
	public String getTsImdgCmptnAuthCd() {
		return this.tsImdgCmptnAuthCd;
	}
	
	/**
	 * Column Info
	 * @return oneTmHndlMaxQty
	 */
	public String getOneTmHndlMaxQty() {
		return this.oneTmHndlMaxQty;
	}
	
	/**
	 * Column Info
	 * @return disTonOvrVolQty
	 */
	public String getDisTonOvrVolQty() {
		return this.disTonOvrVolQty;
	}
	
	/**
	 * Column Info
	 * @return loadStoDys
	 */
	public String getLoadStoDys() {
		return this.loadStoDys;
	}
	
	/**
	 * Column Info
	 * @return portProhiTpCd
	 */
	public String getPortProhiTpCd() {
		return this.portProhiTpCd;
	}
	
	/**
	 * Column Info
	 * @return imdgPortRstrSeq
	 */
	public String getImdgPortRstrSeq() {
		return this.imdgPortRstrSeq;
	}
	
	/**
	 * Column Info
	 * @return tsObrdMaxQty
	 */
	public String getTsObrdMaxQty() {
		return this.tsObrdMaxQty;
	}
	
	/**
	 * Column Info
	 * @return loadTxtDesc
	 */
	public String getLoadTxtDesc() {
		return this.loadTxtDesc;
	}
	
	/**
	 * Column Info
	 * @return prohiDesc
	 */
	public String getProhiDesc() {
		return this.prohiDesc;
	}
	
	/**
	 * Column Info
	 * @return tsNdTmHrs
	 */
	public String getTsNdTmHrs() {
		return this.tsNdTmHrs;
	}
	
	/**
	 * Column Info
	 * @return tsTmlMaxQty
	 */
	public String getTsTmlMaxQty() {
		return this.tsTmlMaxQty;
	}
	

	/**
	 * Column Info
	 * @param passTonOvrVolQty
	 */
	public void setPassTonOvrVolQty(String passTonOvrVolQty) {
		this.passTonOvrVolQty = passTonOvrVolQty;
	}
	
	/**
	 * Column Info
	 * @param loadDysStoFlg
	 */
	public void setLoadDysStoFlg(String loadDysStoFlg) {
		this.loadDysStoFlg = loadDysStoFlg;
	}
	
	/**
	 * Column Info
	 * @param passTmlMaxQty
	 */
	public void setPassTmlMaxQty(String passTmlMaxQty) {
		this.passTmlMaxQty = passTmlMaxQty;
	}
	
	/**
	 * Column Info
	 * @param disObrdMaxQty
	 */
	public void setDisObrdMaxQty(String disObrdMaxQty) {
		this.disObrdMaxQty = disObrdMaxQty;
	}
	
	/**
	 * Column Info
	 * @param tsTxtDesc
	 */
	public void setTsTxtDesc(String tsTxtDesc) {
		this.tsTxtDesc = tsTxtDesc;
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
	 * @param disTxtDesc
	 */
	public void setDisTxtDesc(String disTxtDesc) {
		this.disTxtDesc = disTxtDesc;
	}
	
	/**
	 * Column Info
	 * @param passImdgCmptnAuthCd
	 */
	public void setPassImdgCmptnAuthCd(String passImdgCmptnAuthCd) {
		this.passImdgCmptnAuthCd = passImdgCmptnAuthCd;
	}
	
	/**
	 * Column Info
	 * @param disTmlMaxQty
	 */
	public void setDisTmlMaxQty(String disTmlMaxQty) {
		this.disTmlMaxQty = disTmlMaxQty;
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
	 * @param disDysStoFlg
	 */
	public void setDisDysStoFlg(String disDysStoFlg) {
		this.disDysStoFlg = disDysStoFlg;
	}
	
	/**
	 * Column Info
	 * @param loadImdgCmptnAuthCd
	 */
	public void setLoadImdgCmptnAuthCd(String loadImdgCmptnAuthCd) {
		this.loadImdgCmptnAuthCd = loadImdgCmptnAuthCd;
	}
	
	/**
	 * Column Info
	 * @param ndTmHrs
	 */
	public void setNdTmHrs(String ndTmHrs) {
		this.ndTmHrs = ndTmHrs;
	}
	
	/**
	 * Column Info
	 * @param loadTmlMaxQty
	 */
	public void setLoadTmlMaxQty(String loadTmlMaxQty) {
		this.loadTmlMaxQty = loadTmlMaxQty;
	}
	
	/**
	 * Column Info
	 * @param tsOneTmHndlMaxQty
	 */
	public void setTsOneTmHndlMaxQty(String tsOneTmHndlMaxQty) {
		this.tsOneTmHndlMaxQty = tsOneTmHndlMaxQty;
	}
	
	/**
	 * Column Info
	 * @param disOneTmHndlMaxQty
	 */
	public void setDisOneTmHndlMaxQty(String disOneTmHndlMaxQty) {
		this.disOneTmHndlMaxQty = disOneTmHndlMaxQty;
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
	 * @param tmlMaxQty
	 */
	public void setTmlMaxQty(String tmlMaxQty) {
		this.tmlMaxQty = tmlMaxQty;
	}
	
	/**
	 * Column Info
	 * @param disNdTmHrs
	 */
	public void setDisNdTmHrs(String disNdTmHrs) {
		this.disNdTmHrs = disNdTmHrs;
	}
	
	/**
	 * Column Info
	 * @param tsDysStoFlg
	 */
	public void setTsDysStoFlg(String tsDysStoFlg) {
		this.tsDysStoFlg = tsDysStoFlg;
	}
	
	/**
	 * Column Info
	 * @param disImdgCmptnAuthCd
	 */
	public void setDisImdgCmptnAuthCd(String disImdgCmptnAuthCd) {
		this.disImdgCmptnAuthCd = disImdgCmptnAuthCd;
	}
	
	/**
	 * Column Info
	 * @param tsTonOvrVolQty
	 */
	public void setTsTonOvrVolQty(String tsTonOvrVolQty) {
		this.tsTonOvrVolQty = tsTonOvrVolQty;
	}
	
	/**
	 * Column Info
	 * @param passTxtDesc
	 */
	public void setPassTxtDesc(String passTxtDesc) {
		this.passTxtDesc = passTxtDesc;
	}
	
	/**
	 * Column Info
	 * @param txtDesc
	 */
	public void setTxtDesc(String txtDesc) {
		this.txtDesc = txtDesc;
	}
	
	/**
	 * Column Info
	 * @param passNdTmHrs
	 */
	public void setPassNdTmHrs(String passNdTmHrs) {
		this.passNdTmHrs = passNdTmHrs;
	}
	
	/**
	 * Column Info
	 * @param tsStoDys
	 */
	public void setTsStoDys(String tsStoDys) {
		this.tsStoDys = tsStoDys;
	}
	
	/**
	 * Column Info
	 * @param dysStoFlg
	 */
	public void setDysStoFlg(String dysStoFlg) {
		this.dysStoFlg = dysStoFlg;
	}
	
	/**
	 * Column Info
	 * @param passOneTmHndlMaxQty
	 */
	public void setPassOneTmHndlMaxQty(String passOneTmHndlMaxQty) {
		this.passOneTmHndlMaxQty = passOneTmHndlMaxQty;
	}
	
	/**
	 * Column Info
	 * @param disStoDys
	 */
	public void setDisStoDys(String disStoDys) {
		this.disStoDys = disStoDys;
	}
	
	/**
	 * Column Info
	 * @param loadOneTmHndlMaxQty
	 */
	public void setLoadOneTmHndlMaxQty(String loadOneTmHndlMaxQty) {
		this.loadOneTmHndlMaxQty = loadOneTmHndlMaxQty;
	}
	
	/**
	 * Column Info
	 * @param obrdMaxQty
	 */
	public void setObrdMaxQty(String obrdMaxQty) {
		this.obrdMaxQty = obrdMaxQty;
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
	 * @param imdgCmptnAuthCd
	 */
	public void setImdgCmptnAuthCd(String imdgCmptnAuthCd) {
		this.imdgCmptnAuthCd = imdgCmptnAuthCd;
	}
	
	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param loadNdTmHrs
	 */
	public void setLoadNdTmHrs(String loadNdTmHrs) {
		this.loadNdTmHrs = loadNdTmHrs;
	}
	
	/**
	 * Column Info
	 * @param tonOvrVolQty
	 */
	public void setTonOvrVolQty(String tonOvrVolQty) {
		this.tonOvrVolQty = tonOvrVolQty;
	}
	
	/**
	 * Column Info
	 * @param stoDys
	 */
	public void setStoDys(String stoDys) {
		this.stoDys = stoDys;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param loadTonOvrVolQty
	 */
	public void setLoadTonOvrVolQty(String loadTonOvrVolQty) {
		this.loadTonOvrVolQty = loadTonOvrVolQty;
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
	 * @param loadObrdMaxQty
	 */
	public void setLoadObrdMaxQty(String loadObrdMaxQty) {
		this.loadObrdMaxQty = loadObrdMaxQty;
	}
	
	/**
	 * Column Info
	 * @param passObrdMaxQty
	 */
	public void setPassObrdMaxQty(String passObrdMaxQty) {
		this.passObrdMaxQty = passObrdMaxQty;
	}
	
	/**
	 * Column Info
	 * @param tsImdgCmptnAuthCd
	 */
	public void setTsImdgCmptnAuthCd(String tsImdgCmptnAuthCd) {
		this.tsImdgCmptnAuthCd = tsImdgCmptnAuthCd;
	}
	
	/**
	 * Column Info
	 * @param oneTmHndlMaxQty
	 */
	public void setOneTmHndlMaxQty(String oneTmHndlMaxQty) {
		this.oneTmHndlMaxQty = oneTmHndlMaxQty;
	}
	
	/**
	 * Column Info
	 * @param disTonOvrVolQty
	 */
	public void setDisTonOvrVolQty(String disTonOvrVolQty) {
		this.disTonOvrVolQty = disTonOvrVolQty;
	}
	
	/**
	 * Column Info
	 * @param loadStoDys
	 */
	public void setLoadStoDys(String loadStoDys) {
		this.loadStoDys = loadStoDys;
	}
	
	/**
	 * Column Info
	 * @param portProhiTpCd
	 */
	public void setPortProhiTpCd(String portProhiTpCd) {
		this.portProhiTpCd = portProhiTpCd;
	}
	
	/**
	 * Column Info
	 * @param imdgPortRstrSeq
	 */
	public void setImdgPortRstrSeq(String imdgPortRstrSeq) {
		this.imdgPortRstrSeq = imdgPortRstrSeq;
	}
	
	/**
	 * Column Info
	 * @param tsObrdMaxQty
	 */
	public void setTsObrdMaxQty(String tsObrdMaxQty) {
		this.tsObrdMaxQty = tsObrdMaxQty;
	}
	
	/**
	 * Column Info
	 * @param loadTxtDesc
	 */
	public void setLoadTxtDesc(String loadTxtDesc) {
		this.loadTxtDesc = loadTxtDesc;
	}
	
	/**
	 * Column Info
	 * @param prohiDesc
	 */
	public void setProhiDesc(String prohiDesc) {
		this.prohiDesc = prohiDesc;
	}
	
	/**
	 * Column Info
	 * @param tsNdTmHrs
	 */
	public void setTsNdTmHrs(String tsNdTmHrs) {
		this.tsNdTmHrs = tsNdTmHrs;
	}
	
	/**
	 * Column Info
	 * @param tsTmlMaxQty
	 */
	public void setTsTmlMaxQty(String tsTmlMaxQty) {
		this.tsTmlMaxQty = tsTmlMaxQty;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPassTonOvrVolQty(JSPUtil.getParameter(request, "pass_ton_ovr_vol_qty", ""));
		setLoadDysStoFlg(JSPUtil.getParameter(request, "load_dys_sto_flg", ""));
		setPassTmlMaxQty(JSPUtil.getParameter(request, "pass_tml_max_qty", ""));
		setDisObrdMaxQty(JSPUtil.getParameter(request, "dis_obrd_max_qty", ""));
		setTsTxtDesc(JSPUtil.getParameter(request, "ts_txt_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDisTxtDesc(JSPUtil.getParameter(request, "dis_txt_desc", ""));
		setPassImdgCmptnAuthCd(JSPUtil.getParameter(request, "pass_imdg_cmptn_auth_cd", ""));
		setDisTmlMaxQty(JSPUtil.getParameter(request, "dis_tml_max_qty", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setDisDysStoFlg(JSPUtil.getParameter(request, "dis_dys_sto_flg", ""));
		setLoadImdgCmptnAuthCd(JSPUtil.getParameter(request, "load_imdg_cmptn_auth_cd", ""));
		setNdTmHrs(JSPUtil.getParameter(request, "nd_tm_hrs", ""));
		setLoadTmlMaxQty(JSPUtil.getParameter(request, "load_tml_max_qty", ""));
		setTsOneTmHndlMaxQty(JSPUtil.getParameter(request, "ts_one_tm_hndl_max_qty", ""));
		setDisOneTmHndlMaxQty(JSPUtil.getParameter(request, "dis_one_tm_hndl_max_qty", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setTmlMaxQty(JSPUtil.getParameter(request, "tml_max_qty", ""));
		setDisNdTmHrs(JSPUtil.getParameter(request, "dis_nd_tm_hrs", ""));
		setTsDysStoFlg(JSPUtil.getParameter(request, "ts_dys_sto_flg", ""));
		setDisImdgCmptnAuthCd(JSPUtil.getParameter(request, "dis_imdg_cmptn_auth_cd", ""));
		setTsTonOvrVolQty(JSPUtil.getParameter(request, "ts_ton_ovr_vol_qty", ""));
		setPassTxtDesc(JSPUtil.getParameter(request, "pass_txt_desc", ""));
		setTxtDesc(JSPUtil.getParameter(request, "txt_desc", ""));
		setPassNdTmHrs(JSPUtil.getParameter(request, "pass_nd_tm_hrs", ""));
		setTsStoDys(JSPUtil.getParameter(request, "ts_sto_dys", ""));
		setDysStoFlg(JSPUtil.getParameter(request, "dys_sto_flg", ""));
		setPassOneTmHndlMaxQty(JSPUtil.getParameter(request, "pass_one_tm_hndl_max_qty", ""));
		setDisStoDys(JSPUtil.getParameter(request, "dis_sto_dys", ""));
		setLoadOneTmHndlMaxQty(JSPUtil.getParameter(request, "load_one_tm_hndl_max_qty", ""));
		setObrdMaxQty(JSPUtil.getParameter(request, "obrd_max_qty", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setImdgCmptnAuthCd(JSPUtil.getParameter(request, "imdg_cmptn_auth_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLoadNdTmHrs(JSPUtil.getParameter(request, "load_nd_tm_hrs", ""));
		setTonOvrVolQty(JSPUtil.getParameter(request, "ton_ovr_vol_qty", ""));
		setStoDys(JSPUtil.getParameter(request, "sto_dys", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setLoadTonOvrVolQty(JSPUtil.getParameter(request, "load_ton_ovr_vol_qty", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setLoadObrdMaxQty(JSPUtil.getParameter(request, "load_obrd_max_qty", ""));
		setPassObrdMaxQty(JSPUtil.getParameter(request, "pass_obrd_max_qty", ""));
		setTsImdgCmptnAuthCd(JSPUtil.getParameter(request, "ts_imdg_cmptn_auth_cd", ""));
		setOneTmHndlMaxQty(JSPUtil.getParameter(request, "one_tm_hndl_max_qty", ""));
		setDisTonOvrVolQty(JSPUtil.getParameter(request, "dis_ton_ovr_vol_qty", ""));
		setLoadStoDys(JSPUtil.getParameter(request, "load_sto_dys", ""));
		setPortProhiTpCd(JSPUtil.getParameter(request, "port_prohi_tp_cd", ""));
		setImdgPortRstrSeq(JSPUtil.getParameter(request, "imdg_port_rstr_seq", ""));
		setTsObrdMaxQty(JSPUtil.getParameter(request, "ts_obrd_max_qty", ""));
		setLoadTxtDesc(JSPUtil.getParameter(request, "load_txt_desc", ""));
		setProhiDesc(JSPUtil.getParameter(request, "prohi_desc", ""));
		setTsNdTmHrs(JSPUtil.getParameter(request, "ts_nd_tm_hrs", ""));
		setTsTmlMaxQty(JSPUtil.getParameter(request, "ts_tml_max_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchScgImdgPortRstrDtlVO[]
	 */
	public SearchScgImdgPortRstrDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchScgImdgPortRstrDtlVO[]
	 */
	public SearchScgImdgPortRstrDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchScgImdgPortRstrDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] passTonOvrVolQty = (JSPUtil.getParameter(request, prefix	+ "pass_ton_ovr_vol_qty", length));
			String[] loadDysStoFlg = (JSPUtil.getParameter(request, prefix	+ "load_dys_sto_flg", length));
			String[] passTmlMaxQty = (JSPUtil.getParameter(request, prefix	+ "pass_tml_max_qty", length));
			String[] disObrdMaxQty = (JSPUtil.getParameter(request, prefix	+ "dis_obrd_max_qty", length));
			String[] tsTxtDesc = (JSPUtil.getParameter(request, prefix	+ "ts_txt_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] disTxtDesc = (JSPUtil.getParameter(request, prefix	+ "dis_txt_desc", length));
			String[] passImdgCmptnAuthCd = (JSPUtil.getParameter(request, prefix	+ "pass_imdg_cmptn_auth_cd", length));
			String[] disTmlMaxQty = (JSPUtil.getParameter(request, prefix	+ "dis_tml_max_qty", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] disDysStoFlg = (JSPUtil.getParameter(request, prefix	+ "dis_dys_sto_flg", length));
			String[] loadImdgCmptnAuthCd = (JSPUtil.getParameter(request, prefix	+ "load_imdg_cmptn_auth_cd", length));
			String[] ndTmHrs = (JSPUtil.getParameter(request, prefix	+ "nd_tm_hrs", length));
			String[] loadTmlMaxQty = (JSPUtil.getParameter(request, prefix	+ "load_tml_max_qty", length));
			String[] tsOneTmHndlMaxQty = (JSPUtil.getParameter(request, prefix	+ "ts_one_tm_hndl_max_qty", length));
			String[] disOneTmHndlMaxQty = (JSPUtil.getParameter(request, prefix	+ "dis_one_tm_hndl_max_qty", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] tmlMaxQty = (JSPUtil.getParameter(request, prefix	+ "tml_max_qty", length));
			String[] disNdTmHrs = (JSPUtil.getParameter(request, prefix	+ "dis_nd_tm_hrs", length));
			String[] tsDysStoFlg = (JSPUtil.getParameter(request, prefix	+ "ts_dys_sto_flg", length));
			String[] disImdgCmptnAuthCd = (JSPUtil.getParameter(request, prefix	+ "dis_imdg_cmptn_auth_cd", length));
			String[] tsTonOvrVolQty = (JSPUtil.getParameter(request, prefix	+ "ts_ton_ovr_vol_qty", length));
			String[] passTxtDesc = (JSPUtil.getParameter(request, prefix	+ "pass_txt_desc", length));
			String[] txtDesc = (JSPUtil.getParameter(request, prefix	+ "txt_desc", length));
			String[] passNdTmHrs = (JSPUtil.getParameter(request, prefix	+ "pass_nd_tm_hrs", length));
			String[] tsStoDys = (JSPUtil.getParameter(request, prefix	+ "ts_sto_dys", length));
			String[] dysStoFlg = (JSPUtil.getParameter(request, prefix	+ "dys_sto_flg", length));
			String[] passOneTmHndlMaxQty = (JSPUtil.getParameter(request, prefix	+ "pass_one_tm_hndl_max_qty", length));
			String[] disStoDys = (JSPUtil.getParameter(request, prefix	+ "dis_sto_dys", length));
			String[] loadOneTmHndlMaxQty = (JSPUtil.getParameter(request, prefix	+ "load_one_tm_hndl_max_qty", length));
			String[] obrdMaxQty = (JSPUtil.getParameter(request, prefix	+ "obrd_max_qty", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] imdgCmptnAuthCd = (JSPUtil.getParameter(request, prefix	+ "imdg_cmptn_auth_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] loadNdTmHrs = (JSPUtil.getParameter(request, prefix	+ "load_nd_tm_hrs", length));
			String[] tonOvrVolQty = (JSPUtil.getParameter(request, prefix	+ "ton_ovr_vol_qty", length));
			String[] stoDys = (JSPUtil.getParameter(request, prefix	+ "sto_dys", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] loadTonOvrVolQty = (JSPUtil.getParameter(request, prefix	+ "load_ton_ovr_vol_qty", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] loadObrdMaxQty = (JSPUtil.getParameter(request, prefix	+ "load_obrd_max_qty", length));
			String[] passObrdMaxQty = (JSPUtil.getParameter(request, prefix	+ "pass_obrd_max_qty", length));
			String[] tsImdgCmptnAuthCd = (JSPUtil.getParameter(request, prefix	+ "ts_imdg_cmptn_auth_cd", length));
			String[] oneTmHndlMaxQty = (JSPUtil.getParameter(request, prefix	+ "one_tm_hndl_max_qty", length));
			String[] disTonOvrVolQty = (JSPUtil.getParameter(request, prefix	+ "dis_ton_ovr_vol_qty", length));
			String[] loadStoDys = (JSPUtil.getParameter(request, prefix	+ "load_sto_dys", length));
			String[] portProhiTpCd = (JSPUtil.getParameter(request, prefix	+ "port_prohi_tp_cd", length));
			String[] imdgPortRstrSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_port_rstr_seq", length));
			String[] tsObrdMaxQty = (JSPUtil.getParameter(request, prefix	+ "ts_obrd_max_qty", length));
			String[] loadTxtDesc = (JSPUtil.getParameter(request, prefix	+ "load_txt_desc", length));
			String[] prohiDesc = (JSPUtil.getParameter(request, prefix	+ "prohi_desc", length));
			String[] tsNdTmHrs = (JSPUtil.getParameter(request, prefix	+ "ts_nd_tm_hrs", length));
			String[] tsTmlMaxQty = (JSPUtil.getParameter(request, prefix	+ "ts_tml_max_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchScgImdgPortRstrDtlVO();
				if (passTonOvrVolQty[i] != null)
					model.setPassTonOvrVolQty(passTonOvrVolQty[i]);
				if (loadDysStoFlg[i] != null)
					model.setLoadDysStoFlg(loadDysStoFlg[i]);
				if (passTmlMaxQty[i] != null)
					model.setPassTmlMaxQty(passTmlMaxQty[i]);
				if (disObrdMaxQty[i] != null)
					model.setDisObrdMaxQty(disObrdMaxQty[i]);
				if (tsTxtDesc[i] != null)
					model.setTsTxtDesc(tsTxtDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (disTxtDesc[i] != null)
					model.setDisTxtDesc(disTxtDesc[i]);
				if (passImdgCmptnAuthCd[i] != null)
					model.setPassImdgCmptnAuthCd(passImdgCmptnAuthCd[i]);
				if (disTmlMaxQty[i] != null)
					model.setDisTmlMaxQty(disTmlMaxQty[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (disDysStoFlg[i] != null)
					model.setDisDysStoFlg(disDysStoFlg[i]);
				if (loadImdgCmptnAuthCd[i] != null)
					model.setLoadImdgCmptnAuthCd(loadImdgCmptnAuthCd[i]);
				if (ndTmHrs[i] != null)
					model.setNdTmHrs(ndTmHrs[i]);
				if (loadTmlMaxQty[i] != null)
					model.setLoadTmlMaxQty(loadTmlMaxQty[i]);
				if (tsOneTmHndlMaxQty[i] != null)
					model.setTsOneTmHndlMaxQty(tsOneTmHndlMaxQty[i]);
				if (disOneTmHndlMaxQty[i] != null)
					model.setDisOneTmHndlMaxQty(disOneTmHndlMaxQty[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (tmlMaxQty[i] != null)
					model.setTmlMaxQty(tmlMaxQty[i]);
				if (disNdTmHrs[i] != null)
					model.setDisNdTmHrs(disNdTmHrs[i]);
				if (tsDysStoFlg[i] != null)
					model.setTsDysStoFlg(tsDysStoFlg[i]);
				if (disImdgCmptnAuthCd[i] != null)
					model.setDisImdgCmptnAuthCd(disImdgCmptnAuthCd[i]);
				if (tsTonOvrVolQty[i] != null)
					model.setTsTonOvrVolQty(tsTonOvrVolQty[i]);
				if (passTxtDesc[i] != null)
					model.setPassTxtDesc(passTxtDesc[i]);
				if (txtDesc[i] != null)
					model.setTxtDesc(txtDesc[i]);
				if (passNdTmHrs[i] != null)
					model.setPassNdTmHrs(passNdTmHrs[i]);
				if (tsStoDys[i] != null)
					model.setTsStoDys(tsStoDys[i]);
				if (dysStoFlg[i] != null)
					model.setDysStoFlg(dysStoFlg[i]);
				if (passOneTmHndlMaxQty[i] != null)
					model.setPassOneTmHndlMaxQty(passOneTmHndlMaxQty[i]);
				if (disStoDys[i] != null)
					model.setDisStoDys(disStoDys[i]);
				if (loadOneTmHndlMaxQty[i] != null)
					model.setLoadOneTmHndlMaxQty(loadOneTmHndlMaxQty[i]);
				if (obrdMaxQty[i] != null)
					model.setObrdMaxQty(obrdMaxQty[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (imdgCmptnAuthCd[i] != null)
					model.setImdgCmptnAuthCd(imdgCmptnAuthCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (loadNdTmHrs[i] != null)
					model.setLoadNdTmHrs(loadNdTmHrs[i]);
				if (tonOvrVolQty[i] != null)
					model.setTonOvrVolQty(tonOvrVolQty[i]);
				if (stoDys[i] != null)
					model.setStoDys(stoDys[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (loadTonOvrVolQty[i] != null)
					model.setLoadTonOvrVolQty(loadTonOvrVolQty[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (loadObrdMaxQty[i] != null)
					model.setLoadObrdMaxQty(loadObrdMaxQty[i]);
				if (passObrdMaxQty[i] != null)
					model.setPassObrdMaxQty(passObrdMaxQty[i]);
				if (tsImdgCmptnAuthCd[i] != null)
					model.setTsImdgCmptnAuthCd(tsImdgCmptnAuthCd[i]);
				if (oneTmHndlMaxQty[i] != null)
					model.setOneTmHndlMaxQty(oneTmHndlMaxQty[i]);
				if (disTonOvrVolQty[i] != null)
					model.setDisTonOvrVolQty(disTonOvrVolQty[i]);
				if (loadStoDys[i] != null)
					model.setLoadStoDys(loadStoDys[i]);
				if (portProhiTpCd[i] != null)
					model.setPortProhiTpCd(portProhiTpCd[i]);
				if (imdgPortRstrSeq[i] != null)
					model.setImdgPortRstrSeq(imdgPortRstrSeq[i]);
				if (tsObrdMaxQty[i] != null)
					model.setTsObrdMaxQty(tsObrdMaxQty[i]);
				if (loadTxtDesc[i] != null)
					model.setLoadTxtDesc(loadTxtDesc[i]);
				if (prohiDesc[i] != null)
					model.setProhiDesc(prohiDesc[i]);
				if (tsNdTmHrs[i] != null)
					model.setTsNdTmHrs(tsNdTmHrs[i]);
				if (tsTmlMaxQty[i] != null)
					model.setTsTmlMaxQty(tsTmlMaxQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchScgImdgPortRstrDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchScgImdgPortRstrDtlVO[]
	 */
	public SearchScgImdgPortRstrDtlVO[] getSearchScgImdgPortRstrDtlVOs(){
		SearchScgImdgPortRstrDtlVO[] vos = (SearchScgImdgPortRstrDtlVO[])models.toArray(new SearchScgImdgPortRstrDtlVO[models.size()]);
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
		this.passTonOvrVolQty = this.passTonOvrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadDysStoFlg = this.loadDysStoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.passTmlMaxQty = this.passTmlMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disObrdMaxQty = this.disObrdMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsTxtDesc = this.tsTxtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disTxtDesc = this.disTxtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.passImdgCmptnAuthCd = this.passImdgCmptnAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disTmlMaxQty = this.disTmlMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disDysStoFlg = this.disDysStoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadImdgCmptnAuthCd = this.loadImdgCmptnAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ndTmHrs = this.ndTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadTmlMaxQty = this.loadTmlMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsOneTmHndlMaxQty = this.tsOneTmHndlMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disOneTmHndlMaxQty = this.disOneTmHndlMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlMaxQty = this.tmlMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disNdTmHrs = this.disNdTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsDysStoFlg = this.tsDysStoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disImdgCmptnAuthCd = this.disImdgCmptnAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsTonOvrVolQty = this.tsTonOvrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.passTxtDesc = this.passTxtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtDesc = this.txtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.passNdTmHrs = this.passNdTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsStoDys = this.tsStoDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dysStoFlg = this.dysStoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.passOneTmHndlMaxQty = this.passOneTmHndlMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disStoDys = this.disStoDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadOneTmHndlMaxQty = this.loadOneTmHndlMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obrdMaxQty = this.obrdMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCmptnAuthCd = this.imdgCmptnAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadNdTmHrs = this.loadNdTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tonOvrVolQty = this.tonOvrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoDys = this.stoDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadTonOvrVolQty = this.loadTonOvrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadObrdMaxQty = this.loadObrdMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.passObrdMaxQty = this.passObrdMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsImdgCmptnAuthCd = this.tsImdgCmptnAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oneTmHndlMaxQty = this.oneTmHndlMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disTonOvrVolQty = this.disTonOvrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadStoDys = this.loadStoDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portProhiTpCd = this.portProhiTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPortRstrSeq = this.imdgPortRstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsObrdMaxQty = this.tsObrdMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadTxtDesc = this.loadTxtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prohiDesc = this.prohiDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsNdTmHrs = this.tsNdTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsTmlMaxQty = this.tsTmlMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
