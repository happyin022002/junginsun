/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortRestrictonOptionVO.java
*@FileTitle : PortRestrictonOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.30 장강철 
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

public class PortRestrictonOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortRestrictonOptionVO> models = new ArrayList<PortRestrictonOptionVO>();
	
	/* Column Info */
	private String rstrRmk = null;
	/* Column Info */
	private String tsStoDys = null;
	/* Column Info */
	private String kepSftDistIhbFlg = null;
	/* Column Info */
	private String loadDysStoFlg = null;
	/* Column Info */
	private String savTypeClassLabel = null;
	/* Column Info */
	private String disStoDys = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String optclass = null;
	/* Column Info */
	private String prohiPassFlg = null;
	/* Column Info */
	private String prohiPinspFlg = null;
	/* Column Info */
	private String dirDchgFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String updDtF = null;
	/* Column Info */
	private String prohiTsFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String stoDys = null;
	/* Column Info */
	private String kepSftDistIhbDist = null;
	/* Column Info */
	private String prohiDchgFlg = null;
	/* Column Info */
	private String passImdgCmptnAuthCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String dirTsFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String disDysStoFlg = null;
	/* Column Info */
	private String prohiLodFlg = null;
	/* Column Info */
	private String imdgPortRstrExptFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String loadImdgCmptnAuthCd = null;
	/* Column Info */
	private String sftGadFlg = null;
	/* Column Info */
	private String dirLodFlg = null;
	/* Column Info */
	private String savTypeClassFlag = null;
	/* Column Info */
	private String tsImdgCmptnAuthCd = null;
	/* Column Info */
	private String loadStoDys = null;
	/* Column Info */
	private String prohiNgtFlg = null;
	/* Column Info */
	private String savTypeUnnoFlag = null;
	/* Column Info */
	private String xtraHndlChgFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String imdgPortRstrSeq = null;
	/* Column Info */
	private String tsDysStoFlg = null;
	/* Column Info */
	private String disImdgCmptnAuthCd = null;
	/* Column Info */
	private String imdgClssCdTxt = null;
	/* Column Info */
	private String savTypeUnnoLabel = null;
	/* Column Info */
	private String prohiDyTmOpFlg = null;
	/* Column Info */
	private String prohiPortFlg = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String prohiDyTmInlndTzFlg = null;
	/* Column Info */
	private String portCdNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PortRestrictonOptionVO() {}

	public PortRestrictonOptionVO(String ibflag, String pagerows, String optclass, String portCd, String portCdNm, String imdgPortRstrSeq, String imdgPortRstrExptFlg, String imdgUnNo, String imdgUnNoSeq, String imdgClssCd, String prohiLodFlg, String prohiDchgFlg, String prohiTsFlg, String prohiPassFlg, String prohiDyTmOpFlg, String prohiDyTmInlndTzFlg, String prohiPortFlg, String prohiPinspFlg, String xtraHndlChgFlg, String sftGadFlg, String kepSftDistIhbFlg, String kepSftDistIhbDist, String rstrRmk, String prohiNgtFlg, String dirLodFlg, String dirDchgFlg, String dirTsFlg, String creUsrId, String creDt, String updUsrId, String updDt, String updDtF, String stoDys, String loadImdgCmptnAuthCd, String disImdgCmptnAuthCd, String tsImdgCmptnAuthCd, String passImdgCmptnAuthCd, String loadStoDys, String disStoDys, String tsStoDys, String loadDysStoFlg, String disDysStoFlg, String tsDysStoFlg, String savTypeClassFlag, String savTypeClassLabel, String savTypeUnnoFlag, String savTypeUnnoLabel, String imdgClssCdTxt) {
		this.rstrRmk = rstrRmk;
		this.tsStoDys = tsStoDys;
		this.kepSftDistIhbFlg = kepSftDistIhbFlg;
		this.loadDysStoFlg = loadDysStoFlg;
		this.savTypeClassLabel = savTypeClassLabel;
		this.disStoDys = disStoDys;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.creDt = creDt;
		this.optclass = optclass;
		this.prohiPassFlg = prohiPassFlg;
		this.prohiPinspFlg = prohiPinspFlg;
		this.dirDchgFlg = dirDchgFlg;
		this.pagerows = pagerows;
		this.updDtF = updDtF;
		this.prohiTsFlg = prohiTsFlg;
		this.ibflag = ibflag;
		this.stoDys = stoDys;
		this.kepSftDistIhbDist = kepSftDistIhbDist;
		this.prohiDchgFlg = prohiDchgFlg;
		this.passImdgCmptnAuthCd = passImdgCmptnAuthCd;
		this.portCd = portCd;
		this.dirTsFlg = dirTsFlg;
		this.updUsrId = updUsrId;
		this.imdgUnNo = imdgUnNo;
		this.disDysStoFlg = disDysStoFlg;
		this.prohiLodFlg = prohiLodFlg;
		this.imdgPortRstrExptFlg = imdgPortRstrExptFlg;
		this.updDt = updDt;
		this.loadImdgCmptnAuthCd = loadImdgCmptnAuthCd;
		this.sftGadFlg = sftGadFlg;
		this.dirLodFlg = dirLodFlg;
		this.savTypeClassFlag = savTypeClassFlag;
		this.tsImdgCmptnAuthCd = tsImdgCmptnAuthCd;
		this.loadStoDys = loadStoDys;
		this.prohiNgtFlg = prohiNgtFlg;
		this.savTypeUnnoFlag = savTypeUnnoFlag;
		this.xtraHndlChgFlg = xtraHndlChgFlg;
		this.creUsrId = creUsrId;
		this.imdgPortRstrSeq = imdgPortRstrSeq;
		this.tsDysStoFlg = tsDysStoFlg;
		this.disImdgCmptnAuthCd = disImdgCmptnAuthCd;
		this.imdgClssCdTxt = imdgClssCdTxt;
		this.savTypeUnnoLabel = savTypeUnnoLabel;
		this.prohiDyTmOpFlg = prohiDyTmOpFlg;
		this.prohiPortFlg = prohiPortFlg;
		this.imdgClssCd = imdgClssCd;
		this.prohiDyTmInlndTzFlg = prohiDyTmInlndTzFlg;
		this.portCdNm = portCdNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rstr_rmk", getRstrRmk());
		this.hashColumns.put("ts_sto_dys", getTsStoDys());
		this.hashColumns.put("kep_sft_dist_ihb_flg", getKepSftDistIhbFlg());
		this.hashColumns.put("load_dys_sto_flg", getLoadDysStoFlg());
		this.hashColumns.put("sav_type_class_label", getSavTypeClassLabel());
		this.hashColumns.put("dis_sto_dys", getDisStoDys());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("optclass", getOptclass());
		this.hashColumns.put("prohi_pass_flg", getProhiPassFlg());
		this.hashColumns.put("prohi_pinsp_flg", getProhiPinspFlg());
		this.hashColumns.put("dir_dchg_flg", getDirDchgFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("upd_dt_f", getUpdDtF());
		this.hashColumns.put("prohi_ts_flg", getProhiTsFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sto_dys", getStoDys());
		this.hashColumns.put("kep_sft_dist_ihb_dist", getKepSftDistIhbDist());
		this.hashColumns.put("prohi_dchg_flg", getProhiDchgFlg());
		this.hashColumns.put("pass_imdg_cmptn_auth_cd", getPassImdgCmptnAuthCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("dir_ts_flg", getDirTsFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("dis_dys_sto_flg", getDisDysStoFlg());
		this.hashColumns.put("prohi_lod_flg", getProhiLodFlg());
		this.hashColumns.put("imdg_port_rstr_expt_flg", getImdgPortRstrExptFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("load_imdg_cmptn_auth_cd", getLoadImdgCmptnAuthCd());
		this.hashColumns.put("sft_gad_flg", getSftGadFlg());
		this.hashColumns.put("dir_lod_flg", getDirLodFlg());
		this.hashColumns.put("sav_type_class_flag", getSavTypeClassFlag());
		this.hashColumns.put("ts_imdg_cmptn_auth_cd", getTsImdgCmptnAuthCd());
		this.hashColumns.put("load_sto_dys", getLoadStoDys());
		this.hashColumns.put("prohi_ngt_flg", getProhiNgtFlg());
		this.hashColumns.put("sav_type_unno_flag", getSavTypeUnnoFlag());
		this.hashColumns.put("xtra_hndl_chg_flg", getXtraHndlChgFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("imdg_port_rstr_seq", getImdgPortRstrSeq());
		this.hashColumns.put("ts_dys_sto_flg", getTsDysStoFlg());
		this.hashColumns.put("dis_imdg_cmptn_auth_cd", getDisImdgCmptnAuthCd());
		this.hashColumns.put("imdg_clss_cd_txt", getImdgClssCdTxt());
		this.hashColumns.put("sav_type_unno_label", getSavTypeUnnoLabel());
		this.hashColumns.put("prohi_dy_tm_op_flg", getProhiDyTmOpFlg());
		this.hashColumns.put("prohi_port_flg", getProhiPortFlg());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("prohi_dy_tm_inlnd_tz_flg", getProhiDyTmInlndTzFlg());
		this.hashColumns.put("port_cd_nm", getPortCdNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rstr_rmk", "rstrRmk");
		this.hashFields.put("ts_sto_dys", "tsStoDys");
		this.hashFields.put("kep_sft_dist_ihb_flg", "kepSftDistIhbFlg");
		this.hashFields.put("load_dys_sto_flg", "loadDysStoFlg");
		this.hashFields.put("sav_type_class_label", "savTypeClassLabel");
		this.hashFields.put("dis_sto_dys", "disStoDys");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("optclass", "optclass");
		this.hashFields.put("prohi_pass_flg", "prohiPassFlg");
		this.hashFields.put("prohi_pinsp_flg", "prohiPinspFlg");
		this.hashFields.put("dir_dchg_flg", "dirDchgFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("upd_dt_f", "updDtF");
		this.hashFields.put("prohi_ts_flg", "prohiTsFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sto_dys", "stoDys");
		this.hashFields.put("kep_sft_dist_ihb_dist", "kepSftDistIhbDist");
		this.hashFields.put("prohi_dchg_flg", "prohiDchgFlg");
		this.hashFields.put("pass_imdg_cmptn_auth_cd", "passImdgCmptnAuthCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("dir_ts_flg", "dirTsFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("dis_dys_sto_flg", "disDysStoFlg");
		this.hashFields.put("prohi_lod_flg", "prohiLodFlg");
		this.hashFields.put("imdg_port_rstr_expt_flg", "imdgPortRstrExptFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("load_imdg_cmptn_auth_cd", "loadImdgCmptnAuthCd");
		this.hashFields.put("sft_gad_flg", "sftGadFlg");
		this.hashFields.put("dir_lod_flg", "dirLodFlg");
		this.hashFields.put("sav_type_class_flag", "savTypeClassFlag");
		this.hashFields.put("ts_imdg_cmptn_auth_cd", "tsImdgCmptnAuthCd");
		this.hashFields.put("load_sto_dys", "loadStoDys");
		this.hashFields.put("prohi_ngt_flg", "prohiNgtFlg");
		this.hashFields.put("sav_type_unno_flag", "savTypeUnnoFlag");
		this.hashFields.put("xtra_hndl_chg_flg", "xtraHndlChgFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("imdg_port_rstr_seq", "imdgPortRstrSeq");
		this.hashFields.put("ts_dys_sto_flg", "tsDysStoFlg");
		this.hashFields.put("dis_imdg_cmptn_auth_cd", "disImdgCmptnAuthCd");
		this.hashFields.put("imdg_clss_cd_txt", "imdgClssCdTxt");
		this.hashFields.put("sav_type_unno_label", "savTypeUnnoLabel");
		this.hashFields.put("prohi_dy_tm_op_flg", "prohiDyTmOpFlg");
		this.hashFields.put("prohi_port_flg", "prohiPortFlg");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("prohi_dy_tm_inlnd_tz_flg", "prohiDyTmInlndTzFlg");
		this.hashFields.put("port_cd_nm", "portCdNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rstrRmk
	 */
	public String getRstrRmk() {
		return this.rstrRmk;
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
	 * @return kepSftDistIhbFlg
	 */
	public String getKepSftDistIhbFlg() {
		return this.kepSftDistIhbFlg;
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
	 * @return savTypeClassLabel
	 */
	public String getSavTypeClassLabel() {
		return this.savTypeClassLabel;
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
	 * @return imdgUnNoSeq
	 */
	public String getImdgUnNoSeq() {
		return this.imdgUnNoSeq;
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
	 * @return optclass
	 */
	public String getOptclass() {
		return this.optclass;
	}
	
	/**
	 * Column Info
	 * @return prohiPassFlg
	 */
	public String getProhiPassFlg() {
		return this.prohiPassFlg;
	}
	
	/**
	 * Column Info
	 * @return prohiPinspFlg
	 */
	public String getProhiPinspFlg() {
		return this.prohiPinspFlg;
	}
	
	/**
	 * Column Info
	 * @return dirDchgFlg
	 */
	public String getDirDchgFlg() {
		return this.dirDchgFlg;
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
	 * @return updDtF
	 */
	public String getUpdDtF() {
		return this.updDtF;
	}
	
	/**
	 * Column Info
	 * @return prohiTsFlg
	 */
	public String getProhiTsFlg() {
		return this.prohiTsFlg;
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
	 * @return stoDys
	 */
	public String getStoDys() {
		return this.stoDys;
	}
	
	/**
	 * Column Info
	 * @return kepSftDistIhbDist
	 */
	public String getKepSftDistIhbDist() {
		return this.kepSftDistIhbDist;
	}
	
	/**
	 * Column Info
	 * @return prohiDchgFlg
	 */
	public String getProhiDchgFlg() {
		return this.prohiDchgFlg;
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
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return dirTsFlg
	 */
	public String getDirTsFlg() {
		return this.dirTsFlg;
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
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
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
	 * @return prohiLodFlg
	 */
	public String getProhiLodFlg() {
		return this.prohiLodFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgPortRstrExptFlg
	 */
	public String getImdgPortRstrExptFlg() {
		return this.imdgPortRstrExptFlg;
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
	 * @return loadImdgCmptnAuthCd
	 */
	public String getLoadImdgCmptnAuthCd() {
		return this.loadImdgCmptnAuthCd;
	}
	
	/**
	 * Column Info
	 * @return sftGadFlg
	 */
	public String getSftGadFlg() {
		return this.sftGadFlg;
	}
	
	/**
	 * Column Info
	 * @return dirLodFlg
	 */
	public String getDirLodFlg() {
		return this.dirLodFlg;
	}
	
	/**
	 * Column Info
	 * @return savTypeClassFlag
	 */
	public String getSavTypeClassFlag() {
		return this.savTypeClassFlag;
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
	 * @return loadStoDys
	 */
	public String getLoadStoDys() {
		return this.loadStoDys;
	}
	
	/**
	 * Column Info
	 * @return prohiNgtFlg
	 */
	public String getProhiNgtFlg() {
		return this.prohiNgtFlg;
	}
	
	/**
	 * Column Info
	 * @return savTypeUnnoFlag
	 */
	public String getSavTypeUnnoFlag() {
		return this.savTypeUnnoFlag;
	}
	
	/**
	 * Column Info
	 * @return xtraHndlChgFlg
	 */
	public String getXtraHndlChgFlg() {
		return this.xtraHndlChgFlg;
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
	 * @return imdgPortRstrSeq
	 */
	public String getImdgPortRstrSeq() {
		return this.imdgPortRstrSeq;
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
	 * @return imdgClssCdTxt
	 */
	public String getImdgClssCdTxt() {
		return this.imdgClssCdTxt;
	}
	
	/**
	 * Column Info
	 * @return savTypeUnnoLabel
	 */
	public String getSavTypeUnnoLabel() {
		return this.savTypeUnnoLabel;
	}
	
	/**
	 * Column Info
	 * @return prohiDyTmOpFlg
	 */
	public String getProhiDyTmOpFlg() {
		return this.prohiDyTmOpFlg;
	}
	
	/**
	 * Column Info
	 * @return prohiPortFlg
	 */
	public String getProhiPortFlg() {
		return this.prohiPortFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return prohiDyTmInlndTzFlg
	 */
	public String getProhiDyTmInlndTzFlg() {
		return this.prohiDyTmInlndTzFlg;
	}
	
	/**
	 * Column Info
	 * @return portCdNm
	 */
	public String getPortCdNm() {
		return this.portCdNm;
	}
	

	/**
	 * Column Info
	 * @param rstrRmk
	 */
	public void setRstrRmk(String rstrRmk) {
		this.rstrRmk = rstrRmk;
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
	 * @param kepSftDistIhbFlg
	 */
	public void setKepSftDistIhbFlg(String kepSftDistIhbFlg) {
		this.kepSftDistIhbFlg = kepSftDistIhbFlg;
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
	 * @param savTypeClassLabel
	 */
	public void setSavTypeClassLabel(String savTypeClassLabel) {
		this.savTypeClassLabel = savTypeClassLabel;
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
	 * @param imdgUnNoSeq
	 */
	public void setImdgUnNoSeq(String imdgUnNoSeq) {
		this.imdgUnNoSeq = imdgUnNoSeq;
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
	 * @param optclass
	 */
	public void setOptclass(String optclass) {
		this.optclass = optclass;
	}
	
	/**
	 * Column Info
	 * @param prohiPassFlg
	 */
	public void setProhiPassFlg(String prohiPassFlg) {
		this.prohiPassFlg = prohiPassFlg;
	}
	
	/**
	 * Column Info
	 * @param prohiPinspFlg
	 */
	public void setProhiPinspFlg(String prohiPinspFlg) {
		this.prohiPinspFlg = prohiPinspFlg;
	}
	
	/**
	 * Column Info
	 * @param dirDchgFlg
	 */
	public void setDirDchgFlg(String dirDchgFlg) {
		this.dirDchgFlg = dirDchgFlg;
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
	 * @param updDtF
	 */
	public void setUpdDtF(String updDtF) {
		this.updDtF = updDtF;
	}
	
	/**
	 * Column Info
	 * @param prohiTsFlg
	 */
	public void setProhiTsFlg(String prohiTsFlg) {
		this.prohiTsFlg = prohiTsFlg;
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
	 * @param stoDys
	 */
	public void setStoDys(String stoDys) {
		this.stoDys = stoDys;
	}
	
	/**
	 * Column Info
	 * @param kepSftDistIhbDist
	 */
	public void setKepSftDistIhbDist(String kepSftDistIhbDist) {
		this.kepSftDistIhbDist = kepSftDistIhbDist;
	}
	
	/**
	 * Column Info
	 * @param prohiDchgFlg
	 */
	public void setProhiDchgFlg(String prohiDchgFlg) {
		this.prohiDchgFlg = prohiDchgFlg;
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
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param dirTsFlg
	 */
	public void setDirTsFlg(String dirTsFlg) {
		this.dirTsFlg = dirTsFlg;
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
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
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
	 * @param prohiLodFlg
	 */
	public void setProhiLodFlg(String prohiLodFlg) {
		this.prohiLodFlg = prohiLodFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgPortRstrExptFlg
	 */
	public void setImdgPortRstrExptFlg(String imdgPortRstrExptFlg) {
		this.imdgPortRstrExptFlg = imdgPortRstrExptFlg;
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
	 * @param loadImdgCmptnAuthCd
	 */
	public void setLoadImdgCmptnAuthCd(String loadImdgCmptnAuthCd) {
		this.loadImdgCmptnAuthCd = loadImdgCmptnAuthCd;
	}
	
	/**
	 * Column Info
	 * @param sftGadFlg
	 */
	public void setSftGadFlg(String sftGadFlg) {
		this.sftGadFlg = sftGadFlg;
	}
	
	/**
	 * Column Info
	 * @param dirLodFlg
	 */
	public void setDirLodFlg(String dirLodFlg) {
		this.dirLodFlg = dirLodFlg;
	}
	
	/**
	 * Column Info
	 * @param savTypeClassFlag
	 */
	public void setSavTypeClassFlag(String savTypeClassFlag) {
		this.savTypeClassFlag = savTypeClassFlag;
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
	 * @param loadStoDys
	 */
	public void setLoadStoDys(String loadStoDys) {
		this.loadStoDys = loadStoDys;
	}
	
	/**
	 * Column Info
	 * @param prohiNgtFlg
	 */
	public void setProhiNgtFlg(String prohiNgtFlg) {
		this.prohiNgtFlg = prohiNgtFlg;
	}
	
	/**
	 * Column Info
	 * @param savTypeUnnoFlag
	 */
	public void setSavTypeUnnoFlag(String savTypeUnnoFlag) {
		this.savTypeUnnoFlag = savTypeUnnoFlag;
	}
	
	/**
	 * Column Info
	 * @param xtraHndlChgFlg
	 */
	public void setXtraHndlChgFlg(String xtraHndlChgFlg) {
		this.xtraHndlChgFlg = xtraHndlChgFlg;
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
	 * @param imdgPortRstrSeq
	 */
	public void setImdgPortRstrSeq(String imdgPortRstrSeq) {
		this.imdgPortRstrSeq = imdgPortRstrSeq;
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
	 * @param imdgClssCdTxt
	 */
	public void setImdgClssCdTxt(String imdgClssCdTxt) {
		this.imdgClssCdTxt = imdgClssCdTxt;
	}
	
	/**
	 * Column Info
	 * @param savTypeUnnoLabel
	 */
	public void setSavTypeUnnoLabel(String savTypeUnnoLabel) {
		this.savTypeUnnoLabel = savTypeUnnoLabel;
	}
	
	/**
	 * Column Info
	 * @param prohiDyTmOpFlg
	 */
	public void setProhiDyTmOpFlg(String prohiDyTmOpFlg) {
		this.prohiDyTmOpFlg = prohiDyTmOpFlg;
	}
	
	/**
	 * Column Info
	 * @param prohiPortFlg
	 */
	public void setProhiPortFlg(String prohiPortFlg) {
		this.prohiPortFlg = prohiPortFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param prohiDyTmInlndTzFlg
	 */
	public void setProhiDyTmInlndTzFlg(String prohiDyTmInlndTzFlg) {
		this.prohiDyTmInlndTzFlg = prohiDyTmInlndTzFlg;
	}
	
	/**
	 * Column Info
	 * @param portCdNm
	 */
	public void setPortCdNm(String portCdNm) {
		this.portCdNm = portCdNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRstrRmk(JSPUtil.getParameter(request, "rstr_rmk", ""));
		setTsStoDys(JSPUtil.getParameter(request, "ts_sto_dys", ""));
		setKepSftDistIhbFlg(JSPUtil.getParameter(request, "kep_sft_dist_ihb_flg", ""));
		setLoadDysStoFlg(JSPUtil.getParameter(request, "load_dys_sto_flg", ""));
		setSavTypeClassLabel(JSPUtil.getParameter(request, "sav_type_class_label", ""));
		setDisStoDys(JSPUtil.getParameter(request, "dis_sto_dys", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, "imdg_un_no_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setOptclass(JSPUtil.getParameter(request, "optclass", ""));
		setProhiPassFlg(JSPUtil.getParameter(request, "prohi_pass_flg", ""));
		setProhiPinspFlg(JSPUtil.getParameter(request, "prohi_pinsp_flg", ""));
		setDirDchgFlg(JSPUtil.getParameter(request, "dir_dchg_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setUpdDtF(JSPUtil.getParameter(request, "upd_dt_f", ""));
		setProhiTsFlg(JSPUtil.getParameter(request, "prohi_ts_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setStoDys(JSPUtil.getParameter(request, "sto_dys", ""));
		setKepSftDistIhbDist(JSPUtil.getParameter(request, "kep_sft_dist_ihb_dist", ""));
		setProhiDchgFlg(JSPUtil.getParameter(request, "prohi_dchg_flg", ""));
		setPassImdgCmptnAuthCd(JSPUtil.getParameter(request, "pass_imdg_cmptn_auth_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setDirTsFlg(JSPUtil.getParameter(request, "dir_ts_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setDisDysStoFlg(JSPUtil.getParameter(request, "dis_dys_sto_flg", ""));
		setProhiLodFlg(JSPUtil.getParameter(request, "prohi_lod_flg", ""));
		setImdgPortRstrExptFlg(JSPUtil.getParameter(request, "imdg_port_rstr_expt_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setLoadImdgCmptnAuthCd(JSPUtil.getParameter(request, "load_imdg_cmptn_auth_cd", ""));
		setSftGadFlg(JSPUtil.getParameter(request, "sft_gad_flg", ""));
		setDirLodFlg(JSPUtil.getParameter(request, "dir_lod_flg", ""));
		setSavTypeClassFlag(JSPUtil.getParameter(request, "sav_type_class_flag", ""));
		setTsImdgCmptnAuthCd(JSPUtil.getParameter(request, "ts_imdg_cmptn_auth_cd", ""));
		setLoadStoDys(JSPUtil.getParameter(request, "load_sto_dys", ""));
		setProhiNgtFlg(JSPUtil.getParameter(request, "prohi_ngt_flg", ""));
		setSavTypeUnnoFlag(JSPUtil.getParameter(request, "sav_type_unno_flag", ""));
		setXtraHndlChgFlg(JSPUtil.getParameter(request, "xtra_hndl_chg_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setImdgPortRstrSeq(JSPUtil.getParameter(request, "imdg_port_rstr_seq", ""));
		setTsDysStoFlg(JSPUtil.getParameter(request, "ts_dys_sto_flg", ""));
		setDisImdgCmptnAuthCd(JSPUtil.getParameter(request, "dis_imdg_cmptn_auth_cd", ""));
		setImdgClssCdTxt(JSPUtil.getParameter(request, "imdg_clss_cd_txt", ""));
		setSavTypeUnnoLabel(JSPUtil.getParameter(request, "sav_type_unno_label", ""));
		setProhiDyTmOpFlg(JSPUtil.getParameter(request, "prohi_dy_tm_op_flg", ""));
		setProhiPortFlg(JSPUtil.getParameter(request, "prohi_port_flg", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
		setProhiDyTmInlndTzFlg(JSPUtil.getParameter(request, "prohi_dy_tm_inlnd_tz_flg", ""));
		setPortCdNm(JSPUtil.getParameter(request, "port_cd_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortRestrictonOptionVO[]
	 */
	public PortRestrictonOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortRestrictonOptionVO[]
	 */
	public PortRestrictonOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortRestrictonOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rstrRmk = (JSPUtil.getParameter(request, prefix	+ "rstr_rmk", length));
			String[] tsStoDys = (JSPUtil.getParameter(request, prefix	+ "ts_sto_dys", length));
			String[] kepSftDistIhbFlg = (JSPUtil.getParameter(request, prefix	+ "kep_sft_dist_ihb_flg", length));
			String[] loadDysStoFlg = (JSPUtil.getParameter(request, prefix	+ "load_dys_sto_flg", length));
			String[] savTypeClassLabel = (JSPUtil.getParameter(request, prefix	+ "sav_type_class_label", length));
			String[] disStoDys = (JSPUtil.getParameter(request, prefix	+ "dis_sto_dys", length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] optclass = (JSPUtil.getParameter(request, prefix	+ "optclass", length));
			String[] prohiPassFlg = (JSPUtil.getParameter(request, prefix	+ "prohi_pass_flg", length));
			String[] prohiPinspFlg = (JSPUtil.getParameter(request, prefix	+ "prohi_pinsp_flg", length));
			String[] dirDchgFlg = (JSPUtil.getParameter(request, prefix	+ "dir_dchg_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] updDtF = (JSPUtil.getParameter(request, prefix	+ "upd_dt_f", length));
			String[] prohiTsFlg = (JSPUtil.getParameter(request, prefix	+ "prohi_ts_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] stoDys = (JSPUtil.getParameter(request, prefix	+ "sto_dys", length));
			String[] kepSftDistIhbDist = (JSPUtil.getParameter(request, prefix	+ "kep_sft_dist_ihb_dist", length));
			String[] prohiDchgFlg = (JSPUtil.getParameter(request, prefix	+ "prohi_dchg_flg", length));
			String[] passImdgCmptnAuthCd = (JSPUtil.getParameter(request, prefix	+ "pass_imdg_cmptn_auth_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] dirTsFlg = (JSPUtil.getParameter(request, prefix	+ "dir_ts_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] disDysStoFlg = (JSPUtil.getParameter(request, prefix	+ "dis_dys_sto_flg", length));
			String[] prohiLodFlg = (JSPUtil.getParameter(request, prefix	+ "prohi_lod_flg", length));
			String[] imdgPortRstrExptFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_port_rstr_expt_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] loadImdgCmptnAuthCd = (JSPUtil.getParameter(request, prefix	+ "load_imdg_cmptn_auth_cd", length));
			String[] sftGadFlg = (JSPUtil.getParameter(request, prefix	+ "sft_gad_flg", length));
			String[] dirLodFlg = (JSPUtil.getParameter(request, prefix	+ "dir_lod_flg", length));
			String[] savTypeClassFlag = (JSPUtil.getParameter(request, prefix	+ "sav_type_class_flag", length));
			String[] tsImdgCmptnAuthCd = (JSPUtil.getParameter(request, prefix	+ "ts_imdg_cmptn_auth_cd", length));
			String[] loadStoDys = (JSPUtil.getParameter(request, prefix	+ "load_sto_dys", length));
			String[] prohiNgtFlg = (JSPUtil.getParameter(request, prefix	+ "prohi_ngt_flg", length));
			String[] savTypeUnnoFlag = (JSPUtil.getParameter(request, prefix	+ "sav_type_unno_flag", length));
			String[] xtraHndlChgFlg = (JSPUtil.getParameter(request, prefix	+ "xtra_hndl_chg_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] imdgPortRstrSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_port_rstr_seq", length));
			String[] tsDysStoFlg = (JSPUtil.getParameter(request, prefix	+ "ts_dys_sto_flg", length));
			String[] disImdgCmptnAuthCd = (JSPUtil.getParameter(request, prefix	+ "dis_imdg_cmptn_auth_cd", length));
			String[] imdgClssCdTxt = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd_txt", length));
			String[] savTypeUnnoLabel = (JSPUtil.getParameter(request, prefix	+ "sav_type_unno_label", length));
			String[] prohiDyTmOpFlg = (JSPUtil.getParameter(request, prefix	+ "prohi_dy_tm_op_flg", length));
			String[] prohiPortFlg = (JSPUtil.getParameter(request, prefix	+ "prohi_port_flg", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] prohiDyTmInlndTzFlg = (JSPUtil.getParameter(request, prefix	+ "prohi_dy_tm_inlnd_tz_flg", length));
			String[] portCdNm = (JSPUtil.getParameter(request, prefix	+ "port_cd_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new PortRestrictonOptionVO();
				if (rstrRmk[i] != null)
					model.setRstrRmk(rstrRmk[i]);
				if (tsStoDys[i] != null)
					model.setTsStoDys(tsStoDys[i]);
				if (kepSftDistIhbFlg[i] != null)
					model.setKepSftDistIhbFlg(kepSftDistIhbFlg[i]);
				if (loadDysStoFlg[i] != null)
					model.setLoadDysStoFlg(loadDysStoFlg[i]);
				if (savTypeClassLabel[i] != null)
					model.setSavTypeClassLabel(savTypeClassLabel[i]);
				if (disStoDys[i] != null)
					model.setDisStoDys(disStoDys[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (optclass[i] != null)
					model.setOptclass(optclass[i]);
				if (prohiPassFlg[i] != null)
					model.setProhiPassFlg(prohiPassFlg[i]);
				if (prohiPinspFlg[i] != null)
					model.setProhiPinspFlg(prohiPinspFlg[i]);
				if (dirDchgFlg[i] != null)
					model.setDirDchgFlg(dirDchgFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (updDtF[i] != null)
					model.setUpdDtF(updDtF[i]);
				if (prohiTsFlg[i] != null)
					model.setProhiTsFlg(prohiTsFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (stoDys[i] != null)
					model.setStoDys(stoDys[i]);
				if (kepSftDistIhbDist[i] != null)
					model.setKepSftDistIhbDist(kepSftDistIhbDist[i]);
				if (prohiDchgFlg[i] != null)
					model.setProhiDchgFlg(prohiDchgFlg[i]);
				if (passImdgCmptnAuthCd[i] != null)
					model.setPassImdgCmptnAuthCd(passImdgCmptnAuthCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (dirTsFlg[i] != null)
					model.setDirTsFlg(dirTsFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (disDysStoFlg[i] != null)
					model.setDisDysStoFlg(disDysStoFlg[i]);
				if (prohiLodFlg[i] != null)
					model.setProhiLodFlg(prohiLodFlg[i]);
				if (imdgPortRstrExptFlg[i] != null)
					model.setImdgPortRstrExptFlg(imdgPortRstrExptFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (loadImdgCmptnAuthCd[i] != null)
					model.setLoadImdgCmptnAuthCd(loadImdgCmptnAuthCd[i]);
				if (sftGadFlg[i] != null)
					model.setSftGadFlg(sftGadFlg[i]);
				if (dirLodFlg[i] != null)
					model.setDirLodFlg(dirLodFlg[i]);
				if (savTypeClassFlag[i] != null)
					model.setSavTypeClassFlag(savTypeClassFlag[i]);
				if (tsImdgCmptnAuthCd[i] != null)
					model.setTsImdgCmptnAuthCd(tsImdgCmptnAuthCd[i]);
				if (loadStoDys[i] != null)
					model.setLoadStoDys(loadStoDys[i]);
				if (prohiNgtFlg[i] != null)
					model.setProhiNgtFlg(prohiNgtFlg[i]);
				if (savTypeUnnoFlag[i] != null)
					model.setSavTypeUnnoFlag(savTypeUnnoFlag[i]);
				if (xtraHndlChgFlg[i] != null)
					model.setXtraHndlChgFlg(xtraHndlChgFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (imdgPortRstrSeq[i] != null)
					model.setImdgPortRstrSeq(imdgPortRstrSeq[i]);
				if (tsDysStoFlg[i] != null)
					model.setTsDysStoFlg(tsDysStoFlg[i]);
				if (disImdgCmptnAuthCd[i] != null)
					model.setDisImdgCmptnAuthCd(disImdgCmptnAuthCd[i]);
				if (imdgClssCdTxt[i] != null)
					model.setImdgClssCdTxt(imdgClssCdTxt[i]);
				if (savTypeUnnoLabel[i] != null)
					model.setSavTypeUnnoLabel(savTypeUnnoLabel[i]);
				if (prohiDyTmOpFlg[i] != null)
					model.setProhiDyTmOpFlg(prohiDyTmOpFlg[i]);
				if (prohiPortFlg[i] != null)
					model.setProhiPortFlg(prohiPortFlg[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (prohiDyTmInlndTzFlg[i] != null)
					model.setProhiDyTmInlndTzFlg(prohiDyTmInlndTzFlg[i]);
				if (portCdNm[i] != null)
					model.setPortCdNm(portCdNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortRestrictonOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PortRestrictonOptionVO[]
	 */
	public PortRestrictonOptionVO[] getPortRestrictonOptionVOs(){
		PortRestrictonOptionVO[] vos = (PortRestrictonOptionVO[])models.toArray(new PortRestrictonOptionVO[models.size()]);
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
		this.rstrRmk = this.rstrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsStoDys = this.tsStoDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kepSftDistIhbFlg = this.kepSftDistIhbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadDysStoFlg = this.loadDysStoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savTypeClassLabel = this.savTypeClassLabel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disStoDys = this.disStoDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optclass = this.optclass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prohiPassFlg = this.prohiPassFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prohiPinspFlg = this.prohiPinspFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirDchgFlg = this.dirDchgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDtF = this.updDtF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prohiTsFlg = this.prohiTsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoDys = this.stoDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kepSftDistIhbDist = this.kepSftDistIhbDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prohiDchgFlg = this.prohiDchgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.passImdgCmptnAuthCd = this.passImdgCmptnAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirTsFlg = this.dirTsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disDysStoFlg = this.disDysStoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prohiLodFlg = this.prohiLodFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPortRstrExptFlg = this.imdgPortRstrExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadImdgCmptnAuthCd = this.loadImdgCmptnAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sftGadFlg = this.sftGadFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirLodFlg = this.dirLodFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savTypeClassFlag = this.savTypeClassFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsImdgCmptnAuthCd = this.tsImdgCmptnAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadStoDys = this.loadStoDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prohiNgtFlg = this.prohiNgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savTypeUnnoFlag = this.savTypeUnnoFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xtraHndlChgFlg = this.xtraHndlChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPortRstrSeq = this.imdgPortRstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsDysStoFlg = this.tsDysStoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disImdgCmptnAuthCd = this.disImdgCmptnAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCdTxt = this.imdgClssCdTxt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savTypeUnnoLabel = this.savTypeUnnoLabel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prohiDyTmOpFlg = this.prohiDyTmOpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prohiPortFlg = this.prohiPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prohiDyTmInlndTzFlg = this.prohiDyTmInlndTzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCdNm = this.portCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
