/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MonEstmCsmVO.java
*@FileTitle : MonEstmCsmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.13
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.06.13 서미진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.estimation.estimation.vo;

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
 * @author 서미진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MonEstmCsmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MonEstmCsmVO> models = new ArrayList<MonEstmCsmVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String actStDt = null;
	/* Column Info */
	private String preVvdInvtWgt = null;
	/* Column Info */
	private String itmErrCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String voySeaDys = null;
	/* Column Info */
	private String poRcvWgt = null;
	/* Column Info */
	private String preEstmVvdTpCd = null;
	/* Column Info */
	private String actEndDt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String bodWgt = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String toFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String revDirCd = null;
	/* Column Info */
	private String voyEndCsmWgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actEndPortCd = null;
	/* Column Info */
	private String estmMonCsmWgt = null;
	/* Column Info */
	private String errFlg = null;
	/* Column Info */
	private String actStPortCd = null;
	/* Column Info */
	private String tmpEndDt = null;
	/* Column Info */
	private String estmSeqNo = null;
	/* Column Info */
	private String tmpEndPortCd = null;
	/* Column Info */
	private String estmPortDys = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String monEndCsmWgt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String csmOilTpCd = null;
	/* Column Info */
	private String voyEndRmnWgt = null;
	/* Column Info */
	private String trndLineNo = null;
	/* Column Info */
	private String monBgnInvtWgt = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String exeYrmon = null;
	/* Column Info */
	private String tmpStPortCd = null;
	/* Column Info */
	private String monEndRmnWgt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String estmVvdTpCd = null;
	/* Column Info */
	private String tmpStDt = null;
	/* Column Info */
	private String cntrDznCapa = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String estmSeaDys = null;
	/* Column Info */
	private String trndLineSeq = null;
	/* Column Info */
	private String borWgt = null;
	/* Column Info */
	private String voyPortDys = null;
	/* Column Info */
	private String endClptIndSeq = null;
	/* Column Info */
	private String endSkdDirCd = null;
	/* Column Info */
	private String endSkdVoyNo = null;
	/* Column Info */
	private String bseYrmon = null;
	/* Column Info */
	private String itmErr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MonEstmCsmVO() {}

	public MonEstmCsmVO(String ibflag, String pagerows, String exeYrmon, String revYrmon, String rlaneCd, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String estmVvdTpCd, String csmOilTpCd, String preEstmVvdTpCd, String crrCd, String toFlg, String errFlg, String itmErrCd, String cntrDznCapa, String trndLineSeq, String trndLineNo, String actStPortCd, String actStDt, String actEndPortCd, String actEndDt, String estmSeqNo, String tmpStPortCd, String tmpStDt, String tmpEndPortCd, String tmpEndDt, String monBgnInvtWgt, String preVvdInvtWgt, String poRcvWgt, String bodWgt, String borWgt, String voySeaDys, String voyPortDys, String estmSeaDys, String estmPortDys, String voyEndRmnWgt, String voyEndCsmWgt, String monEndRmnWgt, String monEndCsmWgt, String estmMonCsmWgt, String endClptIndSeq, String endSkdDirCd, String endSkdVoyNo, String creUsrId, String creDt, String updUsrId, String updDt, String bseYrmon, String itmErr) {
		this.vslCd = vslCd;
		this.actStDt = actStDt;
		this.preVvdInvtWgt = preVvdInvtWgt;
		this.itmErrCd = itmErrCd;
		this.creDt = creDt;
		this.voySeaDys = voySeaDys;
		this.poRcvWgt = poRcvWgt;
		this.preEstmVvdTpCd = preEstmVvdTpCd;
		this.actEndDt = actEndDt;
		this.rlaneCd = rlaneCd;
		this.bodWgt = bodWgt;
		this.crrCd = crrCd;
		this.toFlg = toFlg;
		this.pagerows = pagerows;
		this.revDirCd = revDirCd;
		this.voyEndCsmWgt = voyEndCsmWgt;
		this.ibflag = ibflag;
		this.actEndPortCd = actEndPortCd;
		this.estmMonCsmWgt = estmMonCsmWgt;
		this.errFlg = errFlg;
		this.actStPortCd = actStPortCd;
		this.tmpEndDt = tmpEndDt;
		this.estmSeqNo = estmSeqNo;
		this.tmpEndPortCd = tmpEndPortCd;
		this.estmPortDys = estmPortDys;
		this.updUsrId = updUsrId;
		this.monEndCsmWgt = monEndCsmWgt;
		this.updDt = updDt;
		this.csmOilTpCd = csmOilTpCd;
		this.voyEndRmnWgt = voyEndRmnWgt;
		this.trndLineNo = trndLineNo;
		this.monBgnInvtWgt = monBgnInvtWgt;
		this.revYrmon = revYrmon;
		this.exeYrmon = exeYrmon;
		this.tmpStPortCd = tmpStPortCd;
		this.monEndRmnWgt = monEndRmnWgt;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.estmVvdTpCd = estmVvdTpCd;
		this.tmpStDt = tmpStDt;
		this.cntrDznCapa = cntrDznCapa;
		this.creUsrId = creUsrId;
		this.estmSeaDys = estmSeaDys;
		this.trndLineSeq = trndLineSeq;
		this.borWgt = borWgt;
		this.voyPortDys = voyPortDys;
		this.endClptIndSeq = endClptIndSeq;
		this.endSkdDirCd = endSkdDirCd;
		this.endSkdVoyNo = endSkdVoyNo;
		this.bseYrmon = bseYrmon;
		this.itmErr = itmErr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("act_st_dt", getActStDt());
		this.hashColumns.put("pre_vvd_invt_wgt", getPreVvdInvtWgt());
		this.hashColumns.put("itm_err_cd", getItmErrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("voy_sea_dys", getVoySeaDys());
		this.hashColumns.put("po_rcv_wgt", getPoRcvWgt());
		this.hashColumns.put("pre_estm_vvd_tp_cd", getPreEstmVvdTpCd());
		this.hashColumns.put("act_end_dt", getActEndDt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("bod_wgt", getBodWgt());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("to_flg", getToFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("voy_end_csm_wgt", getVoyEndCsmWgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_end_port_cd", getActEndPortCd());
		this.hashColumns.put("estm_mon_csm_wgt", getEstmMonCsmWgt());
		this.hashColumns.put("err_flg", getErrFlg());
		this.hashColumns.put("act_st_port_cd", getActStPortCd());
		this.hashColumns.put("tmp_end_dt", getTmpEndDt());
		this.hashColumns.put("estm_seq_no", getEstmSeqNo());
		this.hashColumns.put("tmp_end_port_cd", getTmpEndPortCd());
		this.hashColumns.put("estm_port_dys", getEstmPortDys());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mon_end_csm_wgt", getMonEndCsmWgt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("csm_oil_tp_cd", getCsmOilTpCd());
		this.hashColumns.put("voy_end_rmn_wgt", getVoyEndRmnWgt());
		this.hashColumns.put("trnd_line_no", getTrndLineNo());
		this.hashColumns.put("mon_bgn_invt_wgt", getMonBgnInvtWgt());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("tmp_st_port_cd", getTmpStPortCd());
		this.hashColumns.put("mon_end_rmn_wgt", getMonEndRmnWgt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("estm_vvd_tp_cd", getEstmVvdTpCd());
		this.hashColumns.put("tmp_st_dt", getTmpStDt());
		this.hashColumns.put("cntr_dzn_capa", getCntrDznCapa());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("estm_sea_dys", getEstmSeaDys());
		this.hashColumns.put("trnd_line_seq", getTrndLineSeq());
		this.hashColumns.put("bor_wgt", getBorWgt());
		this.hashColumns.put("voy_port_dys", getVoyPortDys());
		this.hashColumns.put("end_clpt_ind_seq", getEndClptIndSeq());
		this.hashColumns.put("end_skd_dir_cd", getEndSkdDirCd());
		this.hashColumns.put("end_skd_voy_no", getEndSkdVoyNo());
		this.hashColumns.put("bse_yrmon", getBseYrmon());
		this.hashColumns.put("itm_err", getItmErr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("act_st_dt", "actStDt");
		this.hashFields.put("pre_vvd_invt_wgt", "preVvdInvtWgt");
		this.hashFields.put("itm_err_cd", "itmErrCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("voy_sea_dys", "voySeaDys");
		this.hashFields.put("po_rcv_wgt", "poRcvWgt");
		this.hashFields.put("pre_estm_vvd_tp_cd", "preEstmVvdTpCd");
		this.hashFields.put("act_end_dt", "actEndDt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("bod_wgt", "bodWgt");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("to_flg", "toFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("voy_end_csm_wgt", "voyEndCsmWgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_end_port_cd", "actEndPortCd");
		this.hashFields.put("estm_mon_csm_wgt", "estmMonCsmWgt");
		this.hashFields.put("err_flg", "errFlg");
		this.hashFields.put("act_st_port_cd", "actStPortCd");
		this.hashFields.put("tmp_end_dt", "tmpEndDt");
		this.hashFields.put("estm_seq_no", "estmSeqNo");
		this.hashFields.put("tmp_end_port_cd", "tmpEndPortCd");
		this.hashFields.put("estm_port_dys", "estmPortDys");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mon_end_csm_wgt", "monEndCsmWgt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("csm_oil_tp_cd", "csmOilTpCd");
		this.hashFields.put("voy_end_rmn_wgt", "voyEndRmnWgt");
		this.hashFields.put("trnd_line_no", "trndLineNo");
		this.hashFields.put("mon_bgn_invt_wgt", "monBgnInvtWgt");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("tmp_st_port_cd", "tmpStPortCd");
		this.hashFields.put("mon_end_rmn_wgt", "monEndRmnWgt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("estm_vvd_tp_cd", "estmVvdTpCd");
		this.hashFields.put("tmp_st_dt", "tmpStDt");
		this.hashFields.put("cntr_dzn_capa", "cntrDznCapa");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("estm_sea_dys", "estmSeaDys");
		this.hashFields.put("trnd_line_seq", "trndLineSeq");
		this.hashFields.put("bor_wgt", "borWgt");
		this.hashFields.put("voy_port_dys", "voyPortDys");
		this.hashFields.put("end_clpt_ind_seq", "endClptIndSeq");
		this.hashFields.put("end_skd_dir_cd", "endSkdDirCd");
		this.hashFields.put("end_skd_voy_no", "endSkdVoyNo");
		this.hashFields.put("bse_yrmon", "bseYrmon");
		this.hashFields.put("itm_err", "itmErr");
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
	 * @return actStDt
	 */
	public String getActStDt() {
		return this.actStDt;
	}
	
	/**
	 * Column Info
	 * @return preVvdInvtWgt
	 */
	public String getPreVvdInvtWgt() {
		return this.preVvdInvtWgt;
	}
	
	/**
	 * Column Info
	 * @return itmErrCd
	 */
	public String getItmErrCd() {
		return this.itmErrCd;
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
	 * @return voySeaDys
	 */
	public String getVoySeaDys() {
		return this.voySeaDys;
	}
	
	/**
	 * Column Info
	 * @return poRcvWgt
	 */
	public String getPoRcvWgt() {
		return this.poRcvWgt;
	}
	
	/**
	 * Column Info
	 * @return preEstmVvdTpCd
	 */
	public String getPreEstmVvdTpCd() {
		return this.preEstmVvdTpCd;
	}
	
	/**
	 * Column Info
	 * @return actEndDt
	 */
	public String getActEndDt() {
		return this.actEndDt;
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
	 * @return bodWgt
	 */
	public String getBodWgt() {
		return this.bodWgt;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return toFlg
	 */
	public String getToFlg() {
		return this.toFlg;
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
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
	}
	
	/**
	 * Column Info
	 * @return voyEndCsmWgt
	 */
	public String getVoyEndCsmWgt() {
		return this.voyEndCsmWgt;
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
	 * @return actEndPortCd
	 */
	public String getActEndPortCd() {
		return this.actEndPortCd;
	}
	
	/**
	 * Column Info
	 * @return estmMonCsmWgt
	 */
	public String getEstmMonCsmWgt() {
		return this.estmMonCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return errFlg
	 */
	public String getErrFlg() {
		return this.errFlg;
	}
	
	/**
	 * Column Info
	 * @return actStPortCd
	 */
	public String getActStPortCd() {
		return this.actStPortCd;
	}
	
	/**
	 * Column Info
	 * @return tmpEndDt
	 */
	public String getTmpEndDt() {
		return this.tmpEndDt;
	}
	
	/**
	 * Column Info
	 * @return estmSeqNo
	 */
	public String getEstmSeqNo() {
		return this.estmSeqNo;
	}
	
	/**
	 * Column Info
	 * @return tmpEndPortCd
	 */
	public String getTmpEndPortCd() {
		return this.tmpEndPortCd;
	}
	
	/**
	 * Column Info
	 * @return estmPortDys
	 */
	public String getEstmPortDys() {
		return this.estmPortDys;
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
	 * @return monEndCsmWgt
	 */
	public String getMonEndCsmWgt() {
		return this.monEndCsmWgt;
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
	 * @return csmOilTpCd
	 */
	public String getCsmOilTpCd() {
		return this.csmOilTpCd;
	}
	
	/**
	 * Column Info
	 * @return voyEndRmnWgt
	 */
	public String getVoyEndRmnWgt() {
		return this.voyEndRmnWgt;
	}
	
	/**
	 * Column Info
	 * @return trndLineNo
	 */
	public String getTrndLineNo() {
		return this.trndLineNo;
	}
	
	/**
	 * Column Info
	 * @return monBgnInvtWgt
	 */
	public String getMonBgnInvtWgt() {
		return this.monBgnInvtWgt;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return exeYrmon
	 */
	public String getExeYrmon() {
		return this.exeYrmon;
	}
	
	/**
	 * Column Info
	 * @return tmpStPortCd
	 */
	public String getTmpStPortCd() {
		return this.tmpStPortCd;
	}
	
	/**
	 * Column Info
	 * @return monEndRmnWgt
	 */
	public String getMonEndRmnWgt() {
		return this.monEndRmnWgt;
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
	 * @return estmVvdTpCd
	 */
	public String getEstmVvdTpCd() {
		return this.estmVvdTpCd;
	}
	
	/**
	 * Column Info
	 * @return tmpStDt
	 */
	public String getTmpStDt() {
		return this.tmpStDt;
	}
	
	/**
	 * Column Info
	 * @return cntrDznCapa
	 */
	public String getCntrDznCapa() {
		return this.cntrDznCapa;
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
	 * @return estmSeaDys
	 */
	public String getEstmSeaDys() {
		return this.estmSeaDys;
	}
	
	/**
	 * Column Info
	 * @return trndLineSeq
	 */
	public String getTrndLineSeq() {
		return this.trndLineSeq;
	}
	
	/**
	 * Column Info
	 * @return borWgt
	 */
	public String getBorWgt() {
		return this.borWgt;
	}
	
	/**
	 * Column Info
	 * @return voyPortDys
	 */
	public String getVoyPortDys() {
		return this.voyPortDys;
	}
	
	
	
	/**
	 * Column Info
	 * @return endClptIndSeq
	 */
	public String getEndClptIndSeq() {
		return endClptIndSeq;
	}

	/**
	 * Column Info
	 * @return endSkdDirCd
	 */
	public String getEndSkdDirCd() {
		return endSkdDirCd;
	}

	/**
	 * Column Info
	 * @return endSkdVoyNo
	 */
	public String getEndSkdVoyNo() {
		return endSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return bseYrmon
	 */
	public String getBseYrmon() {
		return bseYrmon;
	}
	
	/**
	 * Column Info
	 * @return itmErr
	 */
	public String getItmErr() {
		return itmErr;
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
	 * @param actStDt
	 */
	public void setActStDt(String actStDt) {
		this.actStDt = actStDt;
	}
	
	/**
	 * Column Info
	 * @param preVvdInvtWgt
	 */
	public void setPreVvdInvtWgt(String preVvdInvtWgt) {
		this.preVvdInvtWgt = preVvdInvtWgt;
	}
	
	/**
	 * Column Info
	 * @param itmErrCd
	 */
	public void setItmErrCd(String itmErrCd) {
		this.itmErrCd = itmErrCd;
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
	 * @param voySeaDys
	 */
	public void setVoySeaDys(String voySeaDys) {
		this.voySeaDys = voySeaDys;
	}
	
	/**
	 * Column Info
	 * @param poRcvWgt
	 */
	public void setPoRcvWgt(String poRcvWgt) {
		this.poRcvWgt = poRcvWgt;
	}
	
	/**
	 * Column Info
	 * @param preEstmVvdTpCd
	 */
	public void setPreEstmVvdTpCd(String preEstmVvdTpCd) {
		this.preEstmVvdTpCd = preEstmVvdTpCd;
	}
	
	/**
	 * Column Info
	 * @param actEndDt
	 */
	public void setActEndDt(String actEndDt) {
		this.actEndDt = actEndDt;
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
	 * @param bodWgt
	 */
	public void setBodWgt(String bodWgt) {
		this.bodWgt = bodWgt;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param toFlg
	 */
	public void setToFlg(String toFlg) {
		this.toFlg = toFlg;
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
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
	}
	
	/**
	 * Column Info
	 * @param voyEndCsmWgt
	 */
	public void setVoyEndCsmWgt(String voyEndCsmWgt) {
		this.voyEndCsmWgt = voyEndCsmWgt;
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
	 * @param actEndPortCd
	 */
	public void setActEndPortCd(String actEndPortCd) {
		this.actEndPortCd = actEndPortCd;
	}
	
	/**
	 * Column Info
	 * @param estmMonCsmWgt
	 */
	public void setEstmMonCsmWgt(String estmMonCsmWgt) {
		this.estmMonCsmWgt = estmMonCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param errFlg
	 */
	public void setErrFlg(String errFlg) {
		this.errFlg = errFlg;
	}
	
	/**
	 * Column Info
	 * @param actStPortCd
	 */
	public void setActStPortCd(String actStPortCd) {
		this.actStPortCd = actStPortCd;
	}
	
	/**
	 * Column Info
	 * @param tmpEndDt
	 */
	public void setTmpEndDt(String tmpEndDt) {
		this.tmpEndDt = tmpEndDt;
	}
	
	/**
	 * Column Info
	 * @param estmSeqNo
	 */
	public void setEstmSeqNo(String estmSeqNo) {
		this.estmSeqNo = estmSeqNo;
	}
	
	/**
	 * Column Info
	 * @param tmpEndPortCd
	 */
	public void setTmpEndPortCd(String tmpEndPortCd) {
		this.tmpEndPortCd = tmpEndPortCd;
	}
	
	/**
	 * Column Info
	 * @param estmPortDys
	 */
	public void setEstmPortDys(String estmPortDys) {
		this.estmPortDys = estmPortDys;
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
	 * @param monEndCsmWgt
	 */
	public void setMonEndCsmWgt(String monEndCsmWgt) {
		this.monEndCsmWgt = monEndCsmWgt;
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
	 * @param csmOilTpCd
	 */
	public void setCsmOilTpCd(String csmOilTpCd) {
		this.csmOilTpCd = csmOilTpCd;
	}
	
	/**
	 * Column Info
	 * @param voyEndRmnWgt
	 */
	public void setVoyEndRmnWgt(String voyEndRmnWgt) {
		this.voyEndRmnWgt = voyEndRmnWgt;
	}
	
	/**
	 * Column Info
	 * @param trndLineNo
	 */
	public void setTrndLineNo(String trndLineNo) {
		this.trndLineNo = trndLineNo;
	}
	
	/**
	 * Column Info
	 * @param monBgnInvtWgt
	 */
	public void setMonBgnInvtWgt(String monBgnInvtWgt) {
		this.monBgnInvtWgt = monBgnInvtWgt;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param exeYrmon
	 */
	public void setExeYrmon(String exeYrmon) {
		this.exeYrmon = exeYrmon;
	}
	
	/**
	 * Column Info
	 * @param tmpStPortCd
	 */
	public void setTmpStPortCd(String tmpStPortCd) {
		this.tmpStPortCd = tmpStPortCd;
	}
	
	/**
	 * Column Info
	 * @param monEndRmnWgt
	 */
	public void setMonEndRmnWgt(String monEndRmnWgt) {
		this.monEndRmnWgt = monEndRmnWgt;
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
	 * @param estmVvdTpCd
	 */
	public void setEstmVvdTpCd(String estmVvdTpCd) {
		this.estmVvdTpCd = estmVvdTpCd;
	}
	
	/**
	 * Column Info
	 * @param tmpStDt
	 */
	public void setTmpStDt(String tmpStDt) {
		this.tmpStDt = tmpStDt;
	}
	
	/**
	 * Column Info
	 * @param cntrDznCapa
	 */
	public void setCntrDznCapa(String cntrDznCapa) {
		this.cntrDznCapa = cntrDznCapa;
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
	 * @param estmSeaDys
	 */
	public void setEstmSeaDys(String estmSeaDys) {
		this.estmSeaDys = estmSeaDys;
	}
	
	/**
	 * Column Info
	 * @param trndLineSeq
	 */
	public void setTrndLineSeq(String trndLineSeq) {
		this.trndLineSeq = trndLineSeq;
	}
	
	/**
	 * Column Info
	 * @param borWgt
	 */
	public void setBorWgt(String borWgt) {
		this.borWgt = borWgt;
	}
	
	/**
	 * Column Info
	 * @param voyPortDys
	 */
	public void setVoyPortDys(String voyPortDys) {
		this.voyPortDys = voyPortDys;
	}
	
	/**
	 * Column Info
	 * @param endSkdVoyNo
	 */
	public void setEndSkdVoyNo(String endSkdVoyNo) {
		this.endSkdVoyNo = endSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param endSkdDirCd
	 */
	public void setEndSkdDirCd(String endSkdDirCd) {
		this.endSkdDirCd = endSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param endClptIndSeq
	 */
	public void setEndClptIndSeq(String endClptIndSeq) {
		this.endClptIndSeq = endClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param bseYrmon
	 */
	public void setBseYrmon(String bseYrmon) {
		this.bseYrmon = bseYrmon;
	}
	
	/**
	 * Column Info
	 * @param itmErr
	 */
	public void setItmErr(String itmErr) {
		this.itmErr = itmErr;
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
		setActStDt(JSPUtil.getParameter(request, prefix + "act_st_dt", ""));
		setPreVvdInvtWgt(JSPUtil.getParameter(request, prefix + "pre_vvd_invt_wgt", ""));
		setItmErrCd(JSPUtil.getParameter(request, prefix + "itm_err_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVoySeaDys(JSPUtil.getParameter(request, prefix + "voy_sea_dys", ""));
		setPoRcvWgt(JSPUtil.getParameter(request, prefix + "po_rcv_wgt", ""));
		setPreEstmVvdTpCd(JSPUtil.getParameter(request, prefix + "pre_estm_vvd_tp_cd", ""));
		setActEndDt(JSPUtil.getParameter(request, prefix + "act_end_dt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setBodWgt(JSPUtil.getParameter(request, prefix + "bod_wgt", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setToFlg(JSPUtil.getParameter(request, prefix + "to_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setVoyEndCsmWgt(JSPUtil.getParameter(request, prefix + "voy_end_csm_wgt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setActEndPortCd(JSPUtil.getParameter(request, prefix + "act_end_port_cd", ""));
		setEstmMonCsmWgt(JSPUtil.getParameter(request, prefix + "estm_mon_csm_wgt", ""));
		setErrFlg(JSPUtil.getParameter(request, prefix + "err_flg", ""));
		setActStPortCd(JSPUtil.getParameter(request, prefix + "act_st_port_cd", ""));
		setTmpEndDt(JSPUtil.getParameter(request, prefix + "tmp_end_dt", ""));
		setEstmSeqNo(JSPUtil.getParameter(request, prefix + "estm_seq_no", ""));
		setTmpEndPortCd(JSPUtil.getParameter(request, prefix + "tmp_end_port_cd", ""));
		setEstmPortDys(JSPUtil.getParameter(request, prefix + "estm_port_dys", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setMonEndCsmWgt(JSPUtil.getParameter(request, prefix + "mon_end_csm_wgt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCsmOilTpCd(JSPUtil.getParameter(request, prefix + "csm_oil_tp_cd", ""));
		setVoyEndRmnWgt(JSPUtil.getParameter(request, prefix + "voy_end_rmn_wgt", ""));
		setTrndLineNo(JSPUtil.getParameter(request, prefix + "trnd_line_no", ""));
		setMonBgnInvtWgt(JSPUtil.getParameter(request, prefix + "mon_bgn_invt_wgt", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setExeYrmon(JSPUtil.getParameter(request, prefix + "exe_yrmon", ""));
		setTmpStPortCd(JSPUtil.getParameter(request, prefix + "tmp_st_port_cd", ""));
		setMonEndRmnWgt(JSPUtil.getParameter(request, prefix + "mon_end_rmn_wgt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setEstmVvdTpCd(JSPUtil.getParameter(request, prefix + "estm_vvd_tp_cd", ""));
		setTmpStDt(JSPUtil.getParameter(request, prefix + "tmp_st_dt", ""));
		setCntrDznCapa(JSPUtil.getParameter(request, prefix + "cntr_dzn_capa", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setEstmSeaDys(JSPUtil.getParameter(request, prefix + "estm_sea_dys", ""));
		setTrndLineSeq(JSPUtil.getParameter(request, prefix + "trnd_line_seq", ""));
		setBorWgt(JSPUtil.getParameter(request, prefix + "bor_wgt", ""));
		setVoyPortDys(JSPUtil.getParameter(request, prefix + "voy_port_dys", ""));
		setEndClptIndSeq(JSPUtil.getParameter(request, prefix + "end_clpt_ind_seq", ""));
		setEndSkdDirCd(JSPUtil.getParameter(request, prefix + "end_skd_dir_cd", ""));
		setEndSkdVoyNo(JSPUtil.getParameter(request, prefix + "end_skd_voy_no", ""));
		setBseYrmon(JSPUtil.getParameter(request, prefix + "bse_yrmon", ""));
		setItmErr(JSPUtil.getParameter(request, prefix + "itm_err", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MonEstmCsmVO[]
	 */
	public MonEstmCsmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MonEstmCsmVO[]
	 */
	public MonEstmCsmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MonEstmCsmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] actStDt = (JSPUtil.getParameter(request, prefix	+ "act_st_dt", length));
			String[] preVvdInvtWgt = (JSPUtil.getParameter(request, prefix	+ "pre_vvd_invt_wgt", length));
			String[] itmErrCd = (JSPUtil.getParameter(request, prefix	+ "itm_err_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] voySeaDys = (JSPUtil.getParameter(request, prefix	+ "voy_sea_dys", length));
			String[] poRcvWgt = (JSPUtil.getParameter(request, prefix	+ "po_rcv_wgt", length));
			String[] preEstmVvdTpCd = (JSPUtil.getParameter(request, prefix	+ "pre_estm_vvd_tp_cd", length));
			String[] actEndDt = (JSPUtil.getParameter(request, prefix	+ "act_end_dt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] bodWgt = (JSPUtil.getParameter(request, prefix	+ "bod_wgt", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] toFlg = (JSPUtil.getParameter(request, prefix	+ "to_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] voyEndCsmWgt = (JSPUtil.getParameter(request, prefix	+ "voy_end_csm_wgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actEndPortCd = (JSPUtil.getParameter(request, prefix	+ "act_end_port_cd", length));
			String[] estmMonCsmWgt = (JSPUtil.getParameter(request, prefix	+ "estm_mon_csm_wgt", length));
			String[] errFlg = (JSPUtil.getParameter(request, prefix	+ "err_flg", length));
			String[] actStPortCd = (JSPUtil.getParameter(request, prefix	+ "act_st_port_cd", length));
			String[] tmpEndDt = (JSPUtil.getParameter(request, prefix	+ "tmp_end_dt", length));
			String[] estmSeqNo = (JSPUtil.getParameter(request, prefix	+ "estm_seq_no", length));
			String[] tmpEndPortCd = (JSPUtil.getParameter(request, prefix	+ "tmp_end_port_cd", length));
			String[] estmPortDys = (JSPUtil.getParameter(request, prefix	+ "estm_port_dys", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] monEndCsmWgt = (JSPUtil.getParameter(request, prefix	+ "mon_end_csm_wgt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] csmOilTpCd = (JSPUtil.getParameter(request, prefix	+ "csm_oil_tp_cd", length));
			String[] voyEndRmnWgt = (JSPUtil.getParameter(request, prefix	+ "voy_end_rmn_wgt", length));
			String[] trndLineNo = (JSPUtil.getParameter(request, prefix	+ "trnd_line_no", length));
			String[] monBgnInvtWgt = (JSPUtil.getParameter(request, prefix	+ "mon_bgn_invt_wgt", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] tmpStPortCd = (JSPUtil.getParameter(request, prefix	+ "tmp_st_port_cd", length));
			String[] monEndRmnWgt = (JSPUtil.getParameter(request, prefix	+ "mon_end_rmn_wgt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] estmVvdTpCd = (JSPUtil.getParameter(request, prefix	+ "estm_vvd_tp_cd", length));
			String[] tmpStDt = (JSPUtil.getParameter(request, prefix	+ "tmp_st_dt", length));
			String[] cntrDznCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_dzn_capa", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] estmSeaDys = (JSPUtil.getParameter(request, prefix	+ "estm_sea_dys", length));
			String[] trndLineSeq = (JSPUtil.getParameter(request, prefix	+ "trnd_line_seq", length));
			String[] borWgt = (JSPUtil.getParameter(request, prefix	+ "bor_wgt", length));
			String[] voyPortDys = (JSPUtil.getParameter(request, prefix	+ "voy_port_dys", length));
			String[] endClptIndSeq = (JSPUtil.getParameter(request, prefix + "end_clpt_ind_seq", length));
			String[] endSkdDirCd = (JSPUtil.getParameter(request, prefix + "end_skd_dir_cd", length));
			String[] endSkdVoyNo = (JSPUtil.getParameter(request, prefix + "end_skd_voy_no", length));
			String[] bseYrmon = (JSPUtil.getParameter(request, prefix + "bse_yrmon", length));
			String[] itmErr = (JSPUtil.getParameter(request, prefix + "itm_err", length));
			
			for (int i = 0; i < length; i++) {
				model = new MonEstmCsmVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (actStDt[i] != null)
					model.setActStDt(actStDt[i]);
				if (preVvdInvtWgt[i] != null)
					model.setPreVvdInvtWgt(preVvdInvtWgt[i]);
				if (itmErrCd[i] != null)
					model.setItmErrCd(itmErrCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (voySeaDys[i] != null)
					model.setVoySeaDys(voySeaDys[i]);
				if (poRcvWgt[i] != null)
					model.setPoRcvWgt(poRcvWgt[i]);
				if (preEstmVvdTpCd[i] != null)
					model.setPreEstmVvdTpCd(preEstmVvdTpCd[i]);
				if (actEndDt[i] != null)
					model.setActEndDt(actEndDt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (bodWgt[i] != null)
					model.setBodWgt(bodWgt[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (toFlg[i] != null)
					model.setToFlg(toFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (voyEndCsmWgt[i] != null)
					model.setVoyEndCsmWgt(voyEndCsmWgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actEndPortCd[i] != null)
					model.setActEndPortCd(actEndPortCd[i]);
				if (estmMonCsmWgt[i] != null)
					model.setEstmMonCsmWgt(estmMonCsmWgt[i]);
				if (errFlg[i] != null)
					model.setErrFlg(errFlg[i]);
				if (actStPortCd[i] != null)
					model.setActStPortCd(actStPortCd[i]);
				if (tmpEndDt[i] != null)
					model.setTmpEndDt(tmpEndDt[i]);
				if (estmSeqNo[i] != null)
					model.setEstmSeqNo(estmSeqNo[i]);
				if (tmpEndPortCd[i] != null)
					model.setTmpEndPortCd(tmpEndPortCd[i]);
				if (estmPortDys[i] != null)
					model.setEstmPortDys(estmPortDys[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (monEndCsmWgt[i] != null)
					model.setMonEndCsmWgt(monEndCsmWgt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (csmOilTpCd[i] != null)
					model.setCsmOilTpCd(csmOilTpCd[i]);
				if (voyEndRmnWgt[i] != null)
					model.setVoyEndRmnWgt(voyEndRmnWgt[i]);
				if (trndLineNo[i] != null)
					model.setTrndLineNo(trndLineNo[i]);
				if (monBgnInvtWgt[i] != null)
					model.setMonBgnInvtWgt(monBgnInvtWgt[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (tmpStPortCd[i] != null)
					model.setTmpStPortCd(tmpStPortCd[i]);
				if (monEndRmnWgt[i] != null)
					model.setMonEndRmnWgt(monEndRmnWgt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (estmVvdTpCd[i] != null)
					model.setEstmVvdTpCd(estmVvdTpCd[i]);
				if (tmpStDt[i] != null)
					model.setTmpStDt(tmpStDt[i]);
				if (cntrDznCapa[i] != null)
					model.setCntrDznCapa(cntrDznCapa[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (estmSeaDys[i] != null)
					model.setEstmSeaDys(estmSeaDys[i]);
				if (trndLineSeq[i] != null)
					model.setTrndLineSeq(trndLineSeq[i]);
				if (borWgt[i] != null)
					model.setBorWgt(borWgt[i]);
				if (voyPortDys[i] != null)
					model.setVoyPortDys(voyPortDys[i]);
				if (endClptIndSeq[i] != null)
					model.setEndClptIndSeq(endClptIndSeq[i]);
				if (endSkdDirCd[i] != null)
					model.setEndSkdDirCd(endSkdDirCd[i]);
				if (endSkdVoyNo[i] != null)
					model.setEndSkdVoyNo(endSkdVoyNo[i]);
				if (bseYrmon[i] != null)
					model.setBseYrmon(bseYrmon[i]);
				if (itmErr[i] != null)
					model.setItmErr(itmErr[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMonEstmCsmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MonEstmCsmVO[]
	 */
	public MonEstmCsmVO[] getMonEstmCsmVOs(){
		MonEstmCsmVO[] vos = (MonEstmCsmVO[])models.toArray(new MonEstmCsmVO[models.size()]);
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
		this.actStDt = this.actStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVvdInvtWgt = this.preVvdInvtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmErrCd = this.itmErrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voySeaDys = this.voySeaDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poRcvWgt = this.poRcvWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preEstmVvdTpCd = this.preEstmVvdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actEndDt = this.actEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bodWgt = this.bodWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toFlg = this.toFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyEndCsmWgt = this.voyEndCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actEndPortCd = this.actEndPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmMonCsmWgt = this.estmMonCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errFlg = this.errFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStPortCd = this.actStPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpEndDt = this.tmpEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmSeqNo = this.estmSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpEndPortCd = this.tmpEndPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmPortDys = this.estmPortDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monEndCsmWgt = this.monEndCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csmOilTpCd = this.csmOilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyEndRmnWgt = this.voyEndRmnWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineNo = this.trndLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monBgnInvtWgt = this.monBgnInvtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpStPortCd = this.tmpStPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monEndRmnWgt = this.monEndRmnWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmVvdTpCd = this.estmVvdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpStDt = this.tmpStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDznCapa = this.cntrDznCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmSeaDys = this.estmSeaDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineSeq = this.trndLineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.borWgt = this.borWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyPortDys = this.voyPortDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endClptIndSeq = this.endClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endSkdDirCd = this.endSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endSkdVoyNo = this.endSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYrmon = this.bseYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmErr = this.itmErr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
