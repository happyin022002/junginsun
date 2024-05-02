/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StlTgtVO.java
*@FileTitle : StlTgtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.21
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.08.21 민정호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo;

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
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class StlTgtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<StlTgtVO> models = new ArrayList<StlTgtVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String bsaQty = null;
	/* Column Info */
	private String fnlBsaQty = null;	
	/* Column Info */
	private String vvdEtdGroup = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String joStlItmCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String actStlAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String joStlTgtItmCd = null;
	/* Column Info */
	private String stlLoclAmt = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String joStlStsCd = null;
	/* Column Info */
	private String rfScgStlTpCd = null;
	/* Column Info */
	private String stlRmk = null;
	/* Column Info */
	private String stlVvdSeq = null;
	/* Column Info */
	private String stlSeq = null;
	/* Column Info */
	private String lev = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String rdrFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String estmStlAmt = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String bsaSltPrc = null;
	/* Column Info */
	private String fnlBsaSltPrc = null;	
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String joStlJbCd = null;
	/* Column Info */
	private String totPageCnt = null;
	/* Column Info */
	private String seqNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String revYrmonSeq = null;
	/* Column Info */
	private String acctYrmon = null;
	/* Column Info */
	private String stlTgtFlg = null;
	/* Column Info */
	private String stlClzFlg = null;	
	/* Column Info */
	private String revDirCd = null;
	/* Column Info */
	private String tml = null;	
	/* Column Info */
	private String revBsaQty = null;
	/* Column Info */
	private String revBsaSltPrc = null;
	/* Column Info */
	private String revEnblFlg = null;
	/* Column Info */
	private String revSeq = null;
	/* Column Info */
	private String revShwFlg = null;
	/* Column Info */
	private String n3rdRevEnblFlg = null;
	/* Column Info */
	private String n3rdRevBsaSltPrc = null;
	/* Column Info */
	private String n2ndRevBsaSltPrc = null;
	/* Column Info */
	private String revCrrCd = null;
	/* Column Info */
	private String n2ndRevChk = null;
	/* Column Info */
	private String n2ndRevBsaQty = null;
	/* Column Info */
	private String n2ndRevCrrCd = null;
	/* Column Info */
	private String n3rdRevBsaQty = null;
	/* Column Info */
	private String revChk = null;
	/* Column Info */
	private String n3rdRevCrrCd = null;
	/* Column Info */
	private String n3rdRevChk = null;
	/* Column Info */
	private String n2ndRevEnblFlg = null;
	/* Column Info */
	private String stlTgtFlg2 = null;
	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public StlTgtVO() {}

	public StlTgtVO(String ibflag, String pagerows, String revYrmon, String stlVvdSeq, String stlSeq, String trdCd, String crrCd, String rlaneCd, String reDivrCd, 
							String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String ydCd, String clptIndSeq, String rdrFlg, String vpsEtdDt, String acctCd, 
							String joStlJbCd, String joStlStsCd, String joStlItmCd, String bsaQty, String fnlBsaQty, String bsaSltPrc, String fnlBsaSltPrc, String loclCurrCd, 
							String stlLoclAmt, String stlRmk, String joStlTgtItmCd, String estmStlAmt, String actStlAmt, String rfScgStlTpCd, String lev, String vvdEtdGroup, 
							String totPageCnt, String seqNo, String updUsrId, String revYrmonSeq, String acctYrmon, String stlTgtFlg, String stlClzFlg, String revDirCd, String tml, 
							String revBsaQty, String revBsaSltPrc, String revEnblFlg, String revSeq, String revShwFlg,
							String revCrrCd, String n2ndRevBsaQty, String n2ndRevBsaSltPrc, String n2ndRevEnblFlg, String n2ndRevCrrCd, String n3rdRevBsaQty, 
							String n3rdRevBsaSltPrc, String n3rdRevEnblFlg, String n3rdRevCrrCd, String revChk, String n2ndRevChk, String n3rdRevChk, String stlTgtFlg2
							) {
		this.vslCd = vslCd;
		this.bsaQty = bsaQty;
		this.fnlBsaQty = fnlBsaQty;		
		this.vvdEtdGroup = vvdEtdGroup;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.crrCd = crrCd;
		this.joStlItmCd = joStlItmCd;
		this.pagerows = pagerows;
		this.vpsPortCd = vpsPortCd;
		this.actStlAmt = actStlAmt;
		this.ibflag = ibflag;
		this.joStlTgtItmCd = joStlTgtItmCd;
		this.stlLoclAmt = stlLoclAmt;
		this.acctCd = acctCd;
		this.joStlStsCd = joStlStsCd;
		this.rfScgStlTpCd = rfScgStlTpCd;
		this.stlRmk = stlRmk;
		this.stlVvdSeq = stlVvdSeq;
		this.stlSeq = stlSeq;
		this.lev = lev;
		this.vpsEtdDt = vpsEtdDt;
		this.revYrmon = revYrmon;
		this.loclCurrCd = loclCurrCd;
		this.skdVoyNo = skdVoyNo;
		this.rdrFlg = rdrFlg;
		this.skdDirCd = skdDirCd;
		this.estmStlAmt = estmStlAmt;
		this.ydCd = ydCd;
		this.bsaSltPrc = bsaSltPrc;
		this.fnlBsaSltPrc = fnlBsaSltPrc;		
		this.reDivrCd = reDivrCd;
		this.clptIndSeq = clptIndSeq;
		this.joStlJbCd = joStlJbCd;
		this.totPageCnt = totPageCnt;
		this.seqNo = seqNo;
		this.updUsrId = updUsrId;
		this.revYrmonSeq = revYrmonSeq;		
		this.acctYrmon = acctYrmon;
		this.stlTgtFlg = stlTgtFlg;
		this.stlClzFlg = stlClzFlg;
		this.revDirCd = revDirCd;
		this.tml = tml;
		this.revBsaQty = revBsaQty;
		this.revBsaSltPrc = revBsaSltPrc;
		this.revEnblFlg = revEnblFlg;		
		this.revSeq = revSeq;		
		this.revShwFlg = revShwFlg;
		
		this.n3rdRevEnblFlg = n3rdRevEnblFlg;
		this.n3rdRevBsaSltPrc = n3rdRevBsaSltPrc;
		this.n2ndRevBsaSltPrc = n2ndRevBsaSltPrc;
		this.revCrrCd = revCrrCd;
		this.n2ndRevChk = n2ndRevChk;
		this.n2ndRevBsaQty = n2ndRevBsaQty;
		this.pagerows = pagerows;
		this.n2ndRevCrrCd = n2ndRevCrrCd;
		this.ibflag = ibflag;
		this.n3rdRevBsaQty = n3rdRevBsaQty;
		this.revChk = revChk;
		this.n3rdRevCrrCd = n3rdRevCrrCd;
		this.n3rdRevChk = n3rdRevChk;
		this.n2ndRevEnblFlg = n2ndRevEnblFlg;		
		this.stlTgtFlg2 = stlTgtFlg2;		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bsa_qty", getBsaQty());
		this.hashColumns.put("fnl_bsa_qty", getFnlBsaQty());		
		this.hashColumns.put("vvd_etd_group", getVvdEtdGroup());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("act_stl_amt", getActStlAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("jo_stl_tgt_itm_cd", getJoStlTgtItmCd());
		this.hashColumns.put("stl_locl_amt", getStlLoclAmt());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("jo_stl_sts_cd", getJoStlStsCd());
		this.hashColumns.put("rf_scg_stl_tp_cd", getRfScgStlTpCd());
		this.hashColumns.put("stl_rmk", getStlRmk());
		this.hashColumns.put("stl_vvd_seq", getStlVvdSeq());
		this.hashColumns.put("stl_seq", getStlSeq());
		this.hashColumns.put("lev", getLev());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("rdr_flg", getRdrFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("estm_stl_amt", getEstmStlAmt());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("bsa_slt_prc", getBsaSltPrc());
		this.hashColumns.put("fnl_bsa_slt_prc", getFnlBsaSltPrc());		
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("jo_stl_jb_cd", getJoStlJbCd());
		this.hashColumns.put("tot_page_cnt", getTotPageCnt());		
		this.hashColumns.put("seq_no", getSeqNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rev_yrmon_seq", getRevYrmonSeq());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());		
		this.hashColumns.put("stl_tgt_flg", getStlTgtFlg());
		this.hashColumns.put("stl_clz_flg", getStlClzFlg());		
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("tml", getTml());
		this.hashColumns.put("rev_bsa_qty", getRevBsaQty());
		this.hashColumns.put("rev_bsa_slt_prc", getRevBsaSltPrc());
		this.hashColumns.put("rev_enbl_flg", getRevEnblFlg());		
		this.hashColumns.put("rev_seq", getRevSeq());		
		this.hashColumns.put("rev_shw_flg", getRevShwFlg());		
		
		this.hashColumns.put("n3rd_rev_enbl_flg", getN3rdRevEnblFlg());
		this.hashColumns.put("n3rd_rev_bsa_slt_prc", getN3rdRevBsaSltPrc());
		this.hashColumns.put("n2nd_rev_bsa_slt_prc", getN2ndRevBsaSltPrc());
		this.hashColumns.put("rev_crr_cd", getRevCrrCd());
		this.hashColumns.put("n2nd_rev_chk", getN2ndRevChk());
		this.hashColumns.put("n2nd_rev_bsa_qty", getN2ndRevBsaQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n2nd_rev_crr_cd", getN2ndRevCrrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n3rd_rev_bsa_qty", getN3rdRevBsaQty());
		this.hashColumns.put("rev_chk", getRevChk());
		this.hashColumns.put("n3rd_rev_crr_cd", getN3rdRevCrrCd());
		this.hashColumns.put("n3rd_rev_chk", getN3rdRevChk());
		this.hashColumns.put("n2nd_rev_enbl_flg", getN2ndRevEnblFlg());
		this.hashColumns.put("stl_tgt_flg2", getStlTgtFlg2());		
					
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bsa_qty", "bsaQty");
		this.hashFields.put("fnl_bsa_qty", "fnlBsaQty");		
		this.hashFields.put("vvd_etd_group", "vvdEtdGroup");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("act_stl_amt", "actStlAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("jo_stl_tgt_itm_cd", "joStlTgtItmCd");
		this.hashFields.put("stl_locl_amt", "stlLoclAmt");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("jo_stl_sts_cd", "joStlStsCd");
		this.hashFields.put("rf_scg_stl_tp_cd", "rfScgStlTpCd");
		this.hashFields.put("stl_rmk", "stlRmk");
		this.hashFields.put("stl_vvd_seq", "stlVvdSeq");
		this.hashFields.put("stl_seq", "stlSeq");
		this.hashFields.put("lev", "lev");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("rdr_flg", "rdrFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("estm_stl_amt", "estmStlAmt");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("bsa_slt_prc", "bsaSltPrc");
		this.hashFields.put("fnl_bsa_slt_prc", "fnlBsaSltPrc");		
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("jo_stl_jb_cd", "joStlJbCd");
		this.hashFields.put("tot_page_cnt", "totPageCnt");
		this.hashFields.put("seq_no", "seqNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rev_yrmon_seq", "revYrmonSeq");		
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("stl_tgt_flg", "stlTgtFlg");
		this.hashFields.put("stl_clz_flg", "stlClzFlg");		
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("tml", "tml");
		this.hashFields.put("rev_bsa_qty", "revBsaQty");
		this.hashFields.put("rev_bsa_slt_prc", "revBsaSltPrc");
		this.hashFields.put("rev_enbl_flg", "revEnblFlg");		
		this.hashFields.put("rev_seq", "revSeq");		
		this.hashFields.put("rev_shw_flg", "revShwFlg");		
		
		this.hashFields.put("n3rd_rev_enbl_flg", "n3rdRevEnblFlg");
		this.hashFields.put("n3rd_rev_bsa_slt_prc", "n3rdRevBsaSltPrc");
		this.hashFields.put("n2nd_rev_bsa_slt_prc", "n2ndRevBsaSltPrc");
		this.hashFields.put("rev_crr_cd", "revCrrCd");
		this.hashFields.put("n2nd_rev_chk", "n2ndRevChk");
		this.hashFields.put("n2nd_rev_bsa_qty", "n2ndRevBsaQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n2nd_rev_crr_cd", "n2ndRevCrrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n3rd_rev_bsa_qty", "n3rdRevBsaQty");
		this.hashFields.put("rev_chk", "revChk");
		this.hashFields.put("n3rd_rev_crr_cd", "n3rdRevCrrCd");
		this.hashFields.put("n3rd_rev_chk", "n3rdRevChk");
		this.hashFields.put("n2nd_rev_enbl_flg", "n2ndRevEnblFlg");
		this.hashFields.put("stl_tgt_flg2", "stlTgtFlg2");		
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
	 * @return bsaQty
	 */
	public String getBsaQty() {
		return this.bsaQty;
	}

	/**
	 * Column Info
	 * @return fnlBsaQty
	 */
	public String getFnlBsaQty() {
		return this.fnlBsaQty;
	}

	
	/**
	 * Column Info
	 * @return vvdEtdGroup
	 */
	public String getVvdEtdGroup() {
		return this.vvdEtdGroup;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return joStlItmCd
	 */
	public String getJoStlItmCd() {
		return this.joStlItmCd;
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
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return actStlAmt
	 */
	public String getActStlAmt() {
		return this.actStlAmt;
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
	 * @return joStlTgtItmCd
	 */
	public String getJoStlTgtItmCd() {
		return this.joStlTgtItmCd;
	}
	
	/**
	 * Column Info
	 * @return stlLoclAmt
	 */
	public String getStlLoclAmt() {
		return this.stlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return joStlStsCd
	 */
	public String getJoStlStsCd() {
		return this.joStlStsCd;
	}
	
	/**
	 * Column Info
	 * @return rfScgStlTpCd
	 */
	public String getRfScgStlTpCd() {
		return this.rfScgStlTpCd;
	}
	
	/**
	 * Column Info
	 * @return stlRmk
	 */
	public String getStlRmk() {
		return this.stlRmk;
	}
	
	/**
	 * Column Info
	 * @return stlVvdSeq
	 */
	public String getStlVvdSeq() {
		return this.stlVvdSeq;
	}
	
	/**
	 * Column Info
	 * @return stlSeq
	 */
	public String getStlSeq() {
		return this.stlSeq;
	}
	
	/**
	 * Column Info
	 * @return lev
	 */
	public String getLev() {
		return this.lev;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
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
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
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
	 * @return rdrFlg
	 */
	public String getRdrFlg() {
		return this.rdrFlg;
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
	 * @return estmStlAmt
	 */
	public String getEstmStlAmt() {
		return this.estmStlAmt;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return bsaSltPrc
	 */
	public String getBsaSltPrc() {
		return this.bsaSltPrc;
	}

	/**
	 * Column Info
	 * @return fnlBsaSltPrc
	 */
	public String getFnlBsaSltPrc() {
		return this.fnlBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return joStlJbCd
	 */
	public String getJoStlJbCd() {
		return this.joStlJbCd;
	}
	
	/**
	 * Column Info
	 * @return totPageCnt
	 */
	public String getTotPageCnt() {
		return this.totPageCnt;
	}

	/**
	 * Column Info
	 * @return seqNo
	 */
	public String getSeqNo() {
		return this.seqNo;
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
	 * @return revYrmonSeq
	 */
	public String getRevYrmonSeq() {
		return this.revYrmonSeq;
	}

	/**
	 * Column Info
	 * @return acctYrmon
	 */
	public String getAcctYrmon() {
		return this.acctYrmon;
	}

	/**
	 * Column Info
	 * @return stlTgtFlg
	 */
	public String getStlTgtFlg() {
		return this.stlTgtFlg;
	}

	/**
	 * Column Info
	 * @return stlClzFlg
	 */
	public String getStlClzFlg() {
		return this.stlClzFlg;
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
	 * @return tml
	 */
	public String getTml() {
		return this.tml;
	}
	
	/**
	 * Column Info
	 * @return revBsaQty
	 */
	public String getRevBsaQty() {
		return this.revBsaQty;
	}	
	
	/**
	 * Column Info
	 * @return revBsaSltPrc
	 */
	public String getRevBsaSltPrc() {
		return this.revBsaSltPrc;
	}	
	
	/**
	 * Column Info
	 * @return revEnblFlg
	 */
	public String getRevEnblFlg() {
		return this.revEnblFlg;
	}		

	/**
	 * Column Info
	 * @return revSeq
	 */
	public String getRevSeq() {
		return this.revSeq;
	}		

	/**
	 * Column Info
	 * @return revShwFlg
	 */
	public String getRevShwFlg() {
		return this.revShwFlg;
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
	 * @param bsaQty
	 */
	public void setBsaQty(String bsaQty) {
		this.bsaQty = bsaQty;
	}
	
	/**
	 * Column Info
	 * @param fnlBsaQty
	 */
	public void setFnlBsaQty(String fnlBsaQty) {
		this.fnlBsaQty = fnlBsaQty;
	}
	
	
	/**
	 * Column Info
	 * @param vvdEtdGroup
	 */
	public void setVvdEtdGroup(String vvdEtdGroup) {
		this.vvdEtdGroup = vvdEtdGroup;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param joStlItmCd
	 */
	public void setJoStlItmCd(String joStlItmCd) {
		this.joStlItmCd = joStlItmCd;
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
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param actStlAmt
	 */
	public void setActStlAmt(String actStlAmt) {
		this.actStlAmt = actStlAmt;
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
	 * @param joStlTgtItmCd
	 */
	public void setJoStlTgtItmCd(String joStlTgtItmCd) {
		this.joStlTgtItmCd = joStlTgtItmCd;
	}
	
	/**
	 * Column Info
	 * @param stlLoclAmt
	 */
	public void setStlLoclAmt(String stlLoclAmt) {
		this.stlLoclAmt = stlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param joStlStsCd
	 */
	public void setJoStlStsCd(String joStlStsCd) {
		this.joStlStsCd = joStlStsCd;
	}
	
	/**
	 * Column Info
	 * @param rfScgStlTpCd
	 */
	public void setRfScgStlTpCd(String rfScgStlTpCd) {
		this.rfScgStlTpCd = rfScgStlTpCd;
	}
	
	/**
	 * Column Info
	 * @param stlRmk
	 */
	public void setStlRmk(String stlRmk) {
		this.stlRmk = stlRmk;
	}
	
	/**
	 * Column Info
	 * @param stlVvdSeq
	 */
	public void setStlVvdSeq(String stlVvdSeq) {
		this.stlVvdSeq = stlVvdSeq;
	}
	
	/**
	 * Column Info
	 * @param stlSeq
	 */
	public void setStlSeq(String stlSeq) {
		this.stlSeq = stlSeq;
	}
	
	/**
	 * Column Info
	 * @param lev
	 */
	public void setLev(String lev) {
		this.lev = lev;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
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
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
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
	 * @param rdrFlg
	 */
	public void setRdrFlg(String rdrFlg) {
		this.rdrFlg = rdrFlg;
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
	 * @param estmStlAmt
	 */
	public void setEstmStlAmt(String estmStlAmt) {
		this.estmStlAmt = estmStlAmt;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param bsaSltPrc
	 */
	public void setBsaSltPrc(String bsaSltPrc) {
		this.bsaSltPrc = bsaSltPrc;
	}

	/**
	 * Column Info
	 * @param fnlBsaSltPrc
	 */
	public void setFnlBsaSltPrc(String fnlBsaSltPrc) {
		this.fnlBsaSltPrc = fnlBsaSltPrc;
	}

	
	/**
	 * Column Info
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param joStlJbCd
	 */
	public void setJoStlJbCd(String joStlJbCd) {
		this.joStlJbCd = joStlJbCd;
	}

	/**
	 * Column Info
	 * @param totPageCnt
	 */
	public void setTotPageCnt(String totPageCnt) {
		this.totPageCnt = totPageCnt;
	}

	/**
	 * Column Info
	 * @param seqNo
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
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
	 * @param revYrmonSeq
	 */
	public void setRevYrmonSeq(String revYrmonSeq) {
		this.revYrmonSeq = revYrmonSeq;
	}
	
	/**
	 * Column Info
	 * @param acctYrmon
	 */
	public void setAcctYrmon(String acctYrmon) {
		this.acctYrmon = acctYrmon;
	}

	/**
	 * Column Info
	 * @param stlTgtFlg
	 */
	public void setStlTgtFlg(String stlTgtFlg) {
		this.stlTgtFlg = stlTgtFlg;
	}

	/**
	 * Column Info
	 * @param stlClzFlg
	 */
	public void setStlClzFlg(String stlClzFlg) {
		this.stlClzFlg = stlClzFlg;
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
	 * @param tml
	 */
	public void setTml(String tml) {
		this.tml = tml;
	}
	
	/**
	 * Column Info
	 * @param revBsaQty
	 */
	public void setRevBsaQty(String revBsaQty) {
		this.revBsaQty = revBsaQty;
	}
	
	/**
	 * Column Info
	 * @param revBsaSltPrc
	 */
	public void setRevBsaSltPrc(String revBsaSltPrc) {
		this.revBsaSltPrc = revBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @param revEnblFlg
	 */
	public void setRevEnblFlg(String revEnblFlg) {
		this.revEnblFlg = revEnblFlg;
	}
	
	/**
	 * Column Info
	 * @param revSeq
	 */
	public void setRevSeq(String revSeq) {
		this.revSeq = revSeq;
	}	
	
	/**
	 * Column Info
	 * @param revShwFlg
	 */
	public void setRevShwFlg(String revShwFlg) {
		this.revShwFlg = revShwFlg;
	}	

	//----------------------------------------	
	/**
	 * Column Info
	 * @return n3rdRevEnblFlg
	 */
	public String getN3rdRevEnblFlg() {
		return this.n3rdRevEnblFlg;
	}
	
	/**
	 * Column Info
	 * @return n3rdRevBsaSltPrc
	 */
	public String getN3rdRevBsaSltPrc() {
		return this.n3rdRevBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @return n2ndRevBsaSltPrc
	 */
	public String getN2ndRevBsaSltPrc() {
		return this.n2ndRevBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @return revCrrCd
	 */
	public String getRevCrrCd() {
		return this.revCrrCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndRevChk
	 */
	public String getN2ndRevChk() {
		return this.n2ndRevChk;
	}
	
	/**
	 * Column Info
	 * @return n2ndRevBsaQty
	 */
	public String getN2ndRevBsaQty() {
		return this.n2ndRevBsaQty;
	}
		
	/**
	 * Column Info
	 * @return n2ndRevCrrCd
	 */
	public String getN2ndRevCrrCd() {
		return this.n2ndRevCrrCd;
	}
		
	/**
	 * Column Info
	 * @return n3rdRevBsaQty
	 */
	public String getN3rdRevBsaQty() {
		return this.n3rdRevBsaQty;
	}
	
	/**
	 * Column Info
	 * @return revChk
	 */
	public String getRevChk() {
		return this.revChk;
	}
	
	/**
	 * Column Info
	 * @return n3rdRevCrrCd
	 */
	public String getN3rdRevCrrCd() {
		return this.n3rdRevCrrCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdRevChk
	 */
	public String getN3rdRevChk() {
		return this.n3rdRevChk;
	}
	
	/**
	 * Column Info
	 * @return n2ndRevEnblFlg
	 */
	public String getN2ndRevEnblFlg() {
		return this.n2ndRevEnblFlg;
	}
		
	/**
	 * Column Info
	 * @return stlTgtFlg2
	 */
	public String getStlTgtFlg2() {
		return this.stlTgtFlg2;
	}
	
	/**
	 * Column Info
	 * @param n3rdRevEnblFlg
	 */
	public void setN3rdRevEnblFlg(String n3rdRevEnblFlg) {
		this.n3rdRevEnblFlg = n3rdRevEnblFlg;
	}
	
	/**
	 * Column Info
	 * @param n3rdRevBsaSltPrc
	 */
	public void setN3rdRevBsaSltPrc(String n3rdRevBsaSltPrc) {
		this.n3rdRevBsaSltPrc = n3rdRevBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @param n2ndRevBsaSltPrc
	 */
	public void setN2ndRevBsaSltPrc(String n2ndRevBsaSltPrc) {
		this.n2ndRevBsaSltPrc = n2ndRevBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @param revCrrCd
	 */
	public void setRevCrrCd(String revCrrCd) {
		this.revCrrCd = revCrrCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndRevChk
	 */
	public void setN2ndRevChk(String n2ndRevChk) {
		this.n2ndRevChk = n2ndRevChk;
	}
	
	/**
	 * Column Info
	 * @param n2ndRevBsaQty
	 */
	public void setN2ndRevBsaQty(String n2ndRevBsaQty) {
		this.n2ndRevBsaQty = n2ndRevBsaQty;
	}
		
	/**
	 * Column Info
	 * @param n2ndRevCrrCd
	 */
	public void setN2ndRevCrrCd(String n2ndRevCrrCd) {
		this.n2ndRevCrrCd = n2ndRevCrrCd;
	}
		
	/**
	 * Column Info
	 * @param n3rdRevBsaQty
	 */
	public void setN3rdRevBsaQty(String n3rdRevBsaQty) {
		this.n3rdRevBsaQty = n3rdRevBsaQty;
	}
	
	/**
	 * Column Info
	 * @param revChk
	 */
	public void setRevChk(String revChk) {
		this.revChk = revChk;
	}
	
	/**
	 * Column Info
	 * @param n3rdRevCrrCd
	 */
	public void setN3rdRevCrrCd(String n3rdRevCrrCd) {
		this.n3rdRevCrrCd = n3rdRevCrrCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdRevChk
	 */
	public void setN3rdRevChk(String n3rdRevChk) {
		this.n3rdRevChk = n3rdRevChk;
	}
	
	/**
	 * Column Info
	 * @param n2ndRevEnblFlg
	 */
	public void setN2ndRevEnblFlg(String n2ndRevEnblFlg) {
		this.n2ndRevEnblFlg = n2ndRevEnblFlg;
	}

	/**
	 * Column Info
	 * @param stlTgtFlg2
	 */
	public void setStlTgtFlg2(String stlTgtFlg2) {
		this.stlTgtFlg2 = stlTgtFlg2;
	}
	
	//----------------------------------------	
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
		setBsaQty(JSPUtil.getParameter(request, prefix + "bsa_qty", ""));
		setFnlBsaQty(JSPUtil.getParameter(request, prefix + "fnl_bsa_qty", ""));		
		setVvdEtdGroup(JSPUtil.getParameter(request, prefix + "vvd_etd_group", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setJoStlItmCd(JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setActStlAmt(JSPUtil.getParameter(request, prefix + "act_stl_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setJoStlTgtItmCd(JSPUtil.getParameter(request, prefix + "jo_stl_tgt_itm_cd", ""));
		setStlLoclAmt(JSPUtil.getParameter(request, prefix + "stl_locl_amt", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setJoStlStsCd(JSPUtil.getParameter(request, prefix + "jo_stl_sts_cd", ""));
		setRfScgStlTpCd(JSPUtil.getParameter(request, prefix + "rf_scg_stl_tp_cd", ""));
		setStlRmk(JSPUtil.getParameter(request, prefix + "stl_rmk", ""));
		setStlVvdSeq(JSPUtil.getParameter(request, prefix + "stl_vvd_seq", ""));
		setStlSeq(JSPUtil.getParameter(request, prefix + "stl_seq", ""));
		setLev(JSPUtil.getParameter(request, prefix + "lev", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setRdrFlg(JSPUtil.getParameter(request, prefix + "rdr_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setEstmStlAmt(JSPUtil.getParameter(request, prefix + "estm_stl_amt", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setBsaSltPrc(JSPUtil.getParameter(request, prefix + "bsa_slt_prc", ""));
		setFnlBsaSltPrc(JSPUtil.getParameter(request, prefix + "fnl_bsa_slt_prc", ""));		
		setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setJoStlJbCd(JSPUtil.getParameter(request, prefix + "jo_stl_jb_cd", ""));
		setTotPageCnt(JSPUtil.getParameter(request, prefix + "tot_page_cnt", ""));
		setSeqNo(JSPUtil.getParameter(request, prefix + "seq_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));		
		setRevYrmonSeq(JSPUtil.getParameter(request, prefix + "rev_yrmon_seq", ""));
		setAcctYrmon(JSPUtil.getParameter(request, prefix + "acct_yrmon", ""));		
		setStlTgtFlg(JSPUtil.getParameter(request, prefix + "stl_tgt_flg", ""));
		setStlClzFlg(JSPUtil.getParameter(request, prefix + "stl_clz_flg", ""));		
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setTml(JSPUtil.getParameter(request, prefix + "tml", ""));		
		setRevBsaQty(JSPUtil.getParameter(request, prefix + "rev_bsa_qty", ""));
		setRevBsaSltPrc(JSPUtil.getParameter(request, prefix + "rev_bsa_slt_prc", ""));
		setRevEnblFlg(JSPUtil.getParameter(request, prefix + "rev_enbl_flg", ""));		
		setRevSeq(JSPUtil.getParameter(request, prefix + "rev_seq", ""));		
		setRevShwFlg(JSPUtil.getParameter(request, prefix + "rev_shw_flg", ""));
		
		setN3rdRevEnblFlg(JSPUtil.getParameter(request, prefix + "n3rd_rev_enbl_flg", ""));
		setN3rdRevBsaSltPrc(JSPUtil.getParameter(request, prefix + "n3rd_rev_bsa_slt_prc", ""));
		setN2ndRevBsaSltPrc(JSPUtil.getParameter(request, prefix + "n2nd_rev_bsa_slt_prc", ""));
		setRevCrrCd(JSPUtil.getParameter(request, prefix + "rev_crr_cd", ""));
		setN2ndRevChk(JSPUtil.getParameter(request, prefix + "n2nd_rev_chk", ""));
		setN2ndRevBsaQty(JSPUtil.getParameter(request, prefix + "n2nd_rev_bsa_qty", ""));
		setN2ndRevCrrCd(JSPUtil.getParameter(request, prefix + "n2nd_rev_crr_cd", ""));
		setN3rdRevBsaQty(JSPUtil.getParameter(request, prefix + "n3rd_rev_bsa_qty", ""));
		setRevChk(JSPUtil.getParameter(request, prefix + "rev_chk", ""));
		setN3rdRevCrrCd(JSPUtil.getParameter(request, prefix + "n3rd_rev_crr_cd", ""));
		setN3rdRevChk(JSPUtil.getParameter(request, prefix + "n3rd_rev_chk", ""));
		setN2ndRevEnblFlg(JSPUtil.getParameter(request, prefix + "n2nd_rev_enbl_flg", ""));		
		setStlTgtFlg2(JSPUtil.getParameter(request, prefix + "stl_tgt_flg2", ""));				
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SltTgtVO[]
	 */
	public StlTgtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StlTgtVO[]
	 */
	public StlTgtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StlTgtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] bsaQty = (JSPUtil.getParameter(request, prefix	+ "bsa_qty", length));
			String[] fnlBsaQty = (JSPUtil.getParameter(request, prefix	+ "fnl_bsa_qty", length));			
			String[] vvdEtdGroup = (JSPUtil.getParameter(request, prefix	+ "vvd_etd_group", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] joStlItmCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_itm_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] actStlAmt = (JSPUtil.getParameter(request, prefix	+ "act_stl_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] joStlTgtItmCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_tgt_itm_cd", length));
			String[] stlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "stl_locl_amt", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] joStlStsCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_sts_cd", length));
			String[] rfScgStlTpCd = (JSPUtil.getParameter(request, prefix	+ "rf_scg_stl_tp_cd", length));
			String[] stlRmk = (JSPUtil.getParameter(request, prefix	+ "stl_rmk", length));
			String[] stlVvdSeq = (JSPUtil.getParameter(request, prefix	+ "stl_vvd_seq", length));
			String[] stlSeq = (JSPUtil.getParameter(request, prefix	+ "stl_seq", length));
			String[] lev = (JSPUtil.getParameter(request, prefix	+ "lev", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] rdrFlg = (JSPUtil.getParameter(request, prefix	+ "rdr_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] estmStlAmt = (JSPUtil.getParameter(request, prefix	+ "estm_stl_amt", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] bsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "bsa_slt_prc", length));
			String[] fnlBsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "fnl_bsa_slt_prc", length));			
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] joStlJbCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_jb_cd", length));
			String[] totPageCnt = (JSPUtil.getParameter(request, prefix	+ "tot_page_cnt", length));
			String[] seqNo = (JSPUtil.getParameter(request, prefix	+ "seq_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));			
			String[] revYrmonSeq = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon_seq", length));		
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));			
			String[] stlTgtFlg = (JSPUtil.getParameter(request, prefix	+ "stl_tgt_flg", length));
			String[] stlClzFlg = (JSPUtil.getParameter(request, prefix	+ "stl_clz_flg", length));		
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] tml = (JSPUtil.getParameter(request, prefix	+ "tml", length));
			String[] revBsaQty = (JSPUtil.getParameter(request, prefix	+ "rev_bsa_qty", length));
			String[] revBsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "rev_bsa_slt_prc", length));
			String[] revEnblFlg = (JSPUtil.getParameter(request, prefix	+ "rev_enbl_flg", length));
			String[] revSeq = (JSPUtil.getParameter(request, prefix	+ "rev_seq", length));			
			String[] revShwFlg = (JSPUtil.getParameter(request, prefix	+ "rev_shw_flg", length));
			
			String[] n3rdRevEnblFlg = (JSPUtil.getParameter(request, prefix	+ "n3rd_rev_enbl_flg", length));
			String[] n3rdRevBsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "n3rd_rev_bsa_slt_prc", length));
			String[] n2ndRevBsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "n2nd_rev_bsa_slt_prc", length));
			String[] revCrrCd = (JSPUtil.getParameter(request, prefix	+ "rev_crr_cd", length));
			String[] n2ndRevChk = (JSPUtil.getParameter(request, prefix	+ "n2nd_rev_chk", length));
			String[] n2ndRevBsaQty = (JSPUtil.getParameter(request, prefix	+ "n2nd_rev_bsa_qty", length));
			String[] n2ndRevCrrCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_rev_crr_cd", length));
			String[] n3rdRevBsaQty = (JSPUtil.getParameter(request, prefix	+ "n3rd_rev_bsa_qty", length));
			String[] revChk = (JSPUtil.getParameter(request, prefix	+ "rev_chk", length));
			String[] n3rdRevCrrCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_rev_crr_cd", length));
			String[] n3rdRevChk = (JSPUtil.getParameter(request, prefix	+ "n3rd_rev_chk", length));
			String[] n2ndRevEnblFlg = (JSPUtil.getParameter(request, prefix	+ "n2nd_rev_enbl_flg", length));
			String[] stlTgtFlg2 = (JSPUtil.getParameter(request, prefix	+ "stl_tgt_flg2", length));			
			
			
			for (int i = 0; i < length; i++) {
				model = new StlTgtVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (bsaQty[i] != null)
					model.setBsaQty(bsaQty[i]);
				if (fnlBsaQty[i] != null)
					model.setFnlBsaQty(fnlBsaQty[i]);				
				if (vvdEtdGroup[i] != null)
					model.setVvdEtdGroup(vvdEtdGroup[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (joStlItmCd[i] != null)
					model.setJoStlItmCd(joStlItmCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (actStlAmt[i] != null)
					model.setActStlAmt(actStlAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (joStlTgtItmCd[i] != null)
					model.setJoStlTgtItmCd(joStlTgtItmCd[i]);
				if (stlLoclAmt[i] != null)
					model.setStlLoclAmt(stlLoclAmt[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (joStlStsCd[i] != null)
					model.setJoStlStsCd(joStlStsCd[i]);
				if (rfScgStlTpCd[i] != null)
					model.setRfScgStlTpCd(rfScgStlTpCd[i]);
				if (stlRmk[i] != null)
					model.setStlRmk(stlRmk[i]);
				if (stlVvdSeq[i] != null)
					model.setStlVvdSeq(stlVvdSeq[i]);
				if (stlSeq[i] != null)
					model.setStlSeq(stlSeq[i]);
				if (lev[i] != null)
					model.setLev(lev[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (rdrFlg[i] != null)
					model.setRdrFlg(rdrFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (estmStlAmt[i] != null)
					model.setEstmStlAmt(estmStlAmt[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (bsaSltPrc[i] != null)
					model.setBsaSltPrc(bsaSltPrc[i]);
				if (fnlBsaSltPrc[i] != null)
					model.setFnlBsaSltPrc(fnlBsaSltPrc[i]);				
				if (fnlBsaQty[i] != null)
					model.setFnlBsaQty(fnlBsaQty[i]);				
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (joStlJbCd[i] != null)
					model.setJoStlJbCd(joStlJbCd[i]);
				if (totPageCnt[i] != null)
					model.setTotPageCnt(totPageCnt[i]);				
				if (seqNo[i] != null)
					model.setSeqNo(seqNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (revYrmonSeq[i] != null)
					model.setRevYrmonSeq(revYrmonSeq[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (stlTgtFlg[i] != null)
					model.setStlTgtFlg(stlTgtFlg[i]);
				if (stlClzFlg[i] != null)
					model.setStlClzFlg(stlClzFlg[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (tml[i] != null)
					model.setTml(tml[i]);
				if (revBsaQty[i] != null)
					model.setRevBsaQty(revBsaQty[i]);
				if (revBsaSltPrc[i] != null)
					model.setRevBsaSltPrc(revBsaSltPrc[i]);
				if (revEnblFlg[i] != null)
					model.setRevEnblFlg(revEnblFlg[i]);
				if (revSeq[i] != null)
					model.setRevSeq(revSeq[i]);
				if (revShwFlg[i] != null)
					model.setRevShwFlg(revShwFlg[i]);
				
				if (n3rdRevEnblFlg[i] != null)
					model.setN3rdRevEnblFlg(n3rdRevEnblFlg[i]);
				if (n3rdRevBsaSltPrc[i] != null)
					model.setN3rdRevBsaSltPrc(n3rdRevBsaSltPrc[i]);
				if (n2ndRevBsaSltPrc[i] != null)
					model.setN2ndRevBsaSltPrc(n2ndRevBsaSltPrc[i]);
				if (revCrrCd[i] != null)
					model.setRevCrrCd(revCrrCd[i]);
				if (n2ndRevChk[i] != null)
					model.setN2ndRevChk(n2ndRevChk[i]);
				if (n2ndRevBsaQty[i] != null)
					model.setN2ndRevBsaQty(n2ndRevBsaQty[i]);
				if (n2ndRevCrrCd[i] != null)
					model.setN2ndRevCrrCd(n2ndRevCrrCd[i]);
				if (n3rdRevBsaQty[i] != null)
					model.setN3rdRevBsaQty(n3rdRevBsaQty[i]);
				if (revChk[i] != null)
					model.setRevChk(revChk[i]);
				if (n3rdRevCrrCd[i] != null)
					model.setN3rdRevCrrCd(n3rdRevCrrCd[i]);
				if (n3rdRevChk[i] != null)
					model.setN3rdRevChk(n3rdRevChk[i]);
				if (n2ndRevEnblFlg[i] != null)
					model.setN2ndRevEnblFlg(n2ndRevEnblFlg[i]);
				if (stlTgtFlg2[i] != null)
					model.setStlTgtFlg2(stlTgtFlg2[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStlTgtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SltTgtVO[]
	 */
	public StlTgtVO[] getStlTgtVOs(){
		StlTgtVO[] vos = (StlTgtVO[])models.toArray(new StlTgtVO[models.size()]);
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
		this.bsaQty = this.bsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBsaQty = this.fnlBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.vvdEtdGroup = this.vvdEtdGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlItmCd = this.joStlItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStlAmt = this.actStlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlTgtItmCd = this.joStlTgtItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlLoclAmt = this.stlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlStsCd = this.joStlStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfScgStlTpCd = this.rfScgStlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlRmk = this.stlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlVvdSeq = this.stlVvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlSeq = this.stlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lev = this.lev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdrFlg = this.rdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmStlAmt = this.estmStlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSltPrc = this.bsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBsaSltPrc = this.fnlBsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlJbCd = this.joStlJbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totPageCnt = this.totPageCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqNo = this.seqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.revYrmonSeq = this.revYrmonSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlTgtFlg = this.stlTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlClzFlg = this.stlClzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml = this.tml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.revBsaQty = this.revBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revBsaSltPrc = this.revBsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revEnblFlg = this.revEnblFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.revSeq = this.revSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.revShwFlg = this.revShwFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.n3rdRevEnblFlg = this.n3rdRevEnblFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdRevBsaSltPrc = this.n3rdRevBsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndRevBsaSltPrc = this.n2ndRevBsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCrrCd = this.revCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndRevChk = this.n2ndRevChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndRevBsaQty = this.n2ndRevBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndRevCrrCd = this.n2ndRevCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdRevBsaQty = this.n3rdRevBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revChk = this.revChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdRevCrrCd = this.n3rdRevCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdRevChk = this.n3rdRevChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndRevEnblFlg = this.n2ndRevEnblFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.stlTgtFlg2 = this.stlTgtFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}
