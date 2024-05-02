/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EurFeederDgCostVO.java
*@FileTitle : EurFeederDgCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EurFeederDgCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EurFeederDgCostVO> models = new ArrayList<EurFeederDgCostVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String imdgN1stClssSvcFlg = null;
	/* Column Info */
	private String imdgN8thClss40ftScgAmt = null;
	/* Column Info */
	private String imdgN7thClssSvcFlg = null;
	/* Column Info */
	private String imdgN3rdClss20ftScgAmt = null;
	/* Column Info */
	private String imdgN4thClssSvcFlg = null;
	/* Column Info */
	private String costTrfRoutSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String imdgN1stClss40ftTtlAmt = null;
	/* Column Info */
	private String imdgN7thClss40ftScgAmt = null;
	/* Column Info */
	private String imdgN2ndClss20ftScgAmt = null;
	/* Column Info */
	private String fdr20ftTtlAmt = null;
	/* Column Info */
	private String imdgN6thClss40ftScgAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String imdgN9thClss20ftScgAmt = null;
	/* Column Info */
	private String costTrfNo = null;
	/* Column Info */
	private String imdgN7thClss20ftTtlAmt = null;
	/* Column Info */
	private String imdgN3rdClss20ftTtlAmt = null;
	/* Column Info */
	private String imdgN6thClssSvcFlg = null;
	/* Column Info */
	private String imdgN8thClssSvcFlg = null;
	/* Column Info */
	private String imdgN3rdClss40ftTtlAmt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String imdgN7thClss20ftScgAmt = null;
	/* Column Info */
	private String imdgN2ndClss40ftTtlAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String imdgN5thClss20ftScgAmt = null;
	/* Column Info */
	private String imdgN6thClss20ftScgAmt = null;
	/* Column Info */
	private String imdgN1stClss40ftScgAmt = null;
	/* Column Info */
	private String imdgN5thClss40ftTtlAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String imdgN5thClss40ftScgAmt = null;
	/* Column Info */
	private String wtrRcvTermCd = null;
	/* Column Info */
	private String imdgN8thClss40ftTtlAmt = null;
	/* Column Info */
	private String imdgN5thClss20ftTtlAmt = null;
	/* Column Info */
	private String imdgN6thClss20ftTtlAmt = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String wtrDeTermCd = null;
	/* Column Info */
	private String imdgN1stClss20ftScgAmt = null;
	/* Column Info */
	private String imdgN9thClss40ftScgAmt = null;
	/* Column Info */
	private String imdgN9thClssSvcFlg = null;
	/* Column Info */
	private String pctlIoBndCd = null;
	/* Column Info */
	private String imdgN2ndClss40ftScgAmt = null;
	/* Column Info */
	private String imdgN3rdClss40ftScgAmt = null;
	/* Column Info */
	private String imdgN9thClss40ftTtlAmt = null;
	/* Column Info */
	private String imdgN8thClss20ftTtlAmt = null;
	/* Column Info */
	private String fdr40ftTtlAmt = null;
	/* Column Info */
	private String imdgN7thClss40ftTtlAmt = null;
	/* Column Info */
	private String imdgN1stClss20ftTtlAmt = null;
	/* Column Info */
	private String pctlIoBndNm = null;
	/* Column Info */
	private String imdgN3rdClssSvcFlg = null;
	/* Column Info */
	private String imdgN8thClss20ftScgAmt = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String imdgN2ndClss20ftTtlAmt = null;
	/* Column Info */
	private String imdgN4thClss20ftTtlAmt = null;
	/* Column Info */
	private String imdgN2ndClssSvcFlg = null;
	/* Column Info */
	private String imdgN4thClss20ftScgAmt = null;
	/* Column Info */
	private String imdgN5thClssSvcFlg = null;
	/* Column Info */
	private String imdgN4thClss40ftTtlAmt = null;
	/* Column Info */
	private String imdgN4thClss40ftScgAmt = null;
	/* Column Info */
	private String agmtOldFlg = null;
	/* Column Info */
	private String imdgN9thClss20ftTtlAmt = null;
	/* Column Info */
	private String imdgN6thClss40ftTtlAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EurFeederDgCostVO() {}

	public EurFeederDgCostVO(String ibflag, String pagerows, String toNodCd, String imdgN1stClssSvcFlg, String imdgN7thClssSvcFlg, String imdgN4thClssSvcFlg, String imdgN1stClss20ftScgAmt, String imdgN2ndClss20ftScgAmt, String imdgN3rdClss20ftScgAmt, String imdgN4thClss20ftScgAmt, String imdgN5thClss20ftScgAmt, String imdgN6thClss20ftScgAmt, String imdgN7thClss20ftScgAmt, String imdgN8thClss20ftScgAmt, String imdgN9thClss20ftScgAmt, String imdgN1stClss40ftScgAmt, String imdgN2ndClss40ftScgAmt, String imdgN3rdClss40ftScgAmt, String imdgN4thClss40ftScgAmt, String imdgN5thClss40ftScgAmt, String imdgN6thClss40ftScgAmt, String imdgN7thClss40ftScgAmt, String imdgN8thClss40ftScgAmt, String imdgN9thClss40ftScgAmt, String costTrfRoutSeq, String vndrNm, String imdgN1stClss40ftTtlAmt, String fdr20ftTtlAmt, String updUsrId, String costTrfNo, String imdgN7thClss20ftTtlAmt, String imdgN3rdClss20ftTtlAmt, String imdgN6thClssSvcFlg, String imdgN8thClssSvcFlg, String imdgN3rdClss40ftTtlAmt, String vndrSeq, String imdgN2ndClss40ftTtlAmt, String imdgN5thClss40ftTtlAmt, String wtrRcvTermCd, String imdgN8thClss40ftTtlAmt, String imdgN5thClss20ftTtlAmt, String imdgN6thClss20ftTtlAmt, String dirCd, String wtrDeTermCd, String imdgN9thClssSvcFlg, String pctlIoBndCd, String imdgN9thClss40ftTtlAmt, String imdgN8thClss20ftTtlAmt, String fdr40ftTtlAmt, String imdgN1stClss20ftTtlAmt, String imdgN7thClss40ftTtlAmt, String pctlIoBndNm, String imdgN3rdClssSvcFlg, String imdgN2ndClss20ftTtlAmt, String fmNodCd, String imdgN2ndClssSvcFlg, String imdgN4thClss20ftTtlAmt, String imdgN5thClssSvcFlg, String imdgN4thClss40ftTtlAmt, String agmtOldFlg, String imdgN9thClss20ftTtlAmt, String imdgN6thClss40ftTtlAmt, String currCd) {
		this.toNodCd = toNodCd;
		this.imdgN1stClssSvcFlg = imdgN1stClssSvcFlg;
		this.imdgN8thClss40ftScgAmt = imdgN8thClss40ftScgAmt;
		this.imdgN7thClssSvcFlg = imdgN7thClssSvcFlg;
		this.imdgN3rdClss20ftScgAmt = imdgN3rdClss20ftScgAmt;
		this.imdgN4thClssSvcFlg = imdgN4thClssSvcFlg;
		this.costTrfRoutSeq = costTrfRoutSeq;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.imdgN1stClss40ftTtlAmt = imdgN1stClss40ftTtlAmt;
		this.imdgN7thClss40ftScgAmt = imdgN7thClss40ftScgAmt;
		this.imdgN2ndClss20ftScgAmt = imdgN2ndClss20ftScgAmt;
		this.fdr20ftTtlAmt = fdr20ftTtlAmt;
		this.imdgN6thClss40ftScgAmt = imdgN6thClss40ftScgAmt;
		this.updUsrId = updUsrId;
		this.imdgN9thClss20ftScgAmt = imdgN9thClss20ftScgAmt;
		this.costTrfNo = costTrfNo;
		this.imdgN7thClss20ftTtlAmt = imdgN7thClss20ftTtlAmt;
		this.imdgN3rdClss20ftTtlAmt = imdgN3rdClss20ftTtlAmt;
		this.imdgN6thClssSvcFlg = imdgN6thClssSvcFlg;
		this.imdgN8thClssSvcFlg = imdgN8thClssSvcFlg;
		this.imdgN3rdClss40ftTtlAmt = imdgN3rdClss40ftTtlAmt;
		this.vndrSeq = vndrSeq;
		this.imdgN7thClss20ftScgAmt = imdgN7thClss20ftScgAmt;
		this.imdgN2ndClss40ftTtlAmt = imdgN2ndClss40ftTtlAmt;
		this.currCd = currCd;
		this.imdgN5thClss20ftScgAmt = imdgN5thClss20ftScgAmt;
		this.imdgN6thClss20ftScgAmt = imdgN6thClss20ftScgAmt;
		this.imdgN1stClss40ftScgAmt = imdgN1stClss40ftScgAmt;
		this.imdgN5thClss40ftTtlAmt = imdgN5thClss40ftTtlAmt;
		this.ibflag = ibflag;
		this.imdgN5thClss40ftScgAmt = imdgN5thClss40ftScgAmt;
		this.wtrRcvTermCd = wtrRcvTermCd;
		this.imdgN8thClss40ftTtlAmt = imdgN8thClss40ftTtlAmt;
		this.imdgN5thClss20ftTtlAmt = imdgN5thClss20ftTtlAmt;
		this.imdgN6thClss20ftTtlAmt = imdgN6thClss20ftTtlAmt;
		this.dirCd = dirCd;
		this.wtrDeTermCd = wtrDeTermCd;
		this.imdgN1stClss20ftScgAmt = imdgN1stClss20ftScgAmt;
		this.imdgN9thClss40ftScgAmt = imdgN9thClss40ftScgAmt;
		this.imdgN9thClssSvcFlg = imdgN9thClssSvcFlg;
		this.pctlIoBndCd = pctlIoBndCd;
		this.imdgN2ndClss40ftScgAmt = imdgN2ndClss40ftScgAmt;
		this.imdgN3rdClss40ftScgAmt = imdgN3rdClss40ftScgAmt;
		this.imdgN9thClss40ftTtlAmt = imdgN9thClss40ftTtlAmt;
		this.imdgN8thClss20ftTtlAmt = imdgN8thClss20ftTtlAmt;
		this.fdr40ftTtlAmt = fdr40ftTtlAmt;
		this.imdgN7thClss40ftTtlAmt = imdgN7thClss40ftTtlAmt;
		this.imdgN1stClss20ftTtlAmt = imdgN1stClss20ftTtlAmt;
		this.pctlIoBndNm = pctlIoBndNm;
		this.imdgN3rdClssSvcFlg = imdgN3rdClssSvcFlg;
		this.imdgN8thClss20ftScgAmt = imdgN8thClss20ftScgAmt;
		this.fmNodCd = fmNodCd;
		this.imdgN2ndClss20ftTtlAmt = imdgN2ndClss20ftTtlAmt;
		this.imdgN4thClss20ftTtlAmt = imdgN4thClss20ftTtlAmt;
		this.imdgN2ndClssSvcFlg = imdgN2ndClssSvcFlg;
		this.imdgN4thClss20ftScgAmt = imdgN4thClss20ftScgAmt;
		this.imdgN5thClssSvcFlg = imdgN5thClssSvcFlg;
		this.imdgN4thClss40ftTtlAmt = imdgN4thClss40ftTtlAmt;
		this.imdgN4thClss40ftScgAmt = imdgN4thClss40ftScgAmt;
		this.agmtOldFlg = agmtOldFlg;
		this.imdgN9thClss20ftTtlAmt = imdgN9thClss20ftTtlAmt;
		this.imdgN6thClss40ftTtlAmt = imdgN6thClss40ftTtlAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("imdg_n1st_clss_svc_flg", getImdgN1stClssSvcFlg());
		this.hashColumns.put("imdg_n8th_clss_40ft_scg_amt", getImdgN8thClss40ftScgAmt());
		this.hashColumns.put("imdg_n7th_clss_svc_flg", getImdgN7thClssSvcFlg());
		this.hashColumns.put("imdg_n3rd_clss_20ft_scg_amt", getImdgN3rdClss20ftScgAmt());
		this.hashColumns.put("imdg_n4th_clss_svc_flg", getImdgN4thClssSvcFlg());
		this.hashColumns.put("cost_trf_rout_seq", getCostTrfRoutSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("imdg_n1st_clss_40ft_ttl_amt", getImdgN1stClss40ftTtlAmt());
		this.hashColumns.put("imdg_n7th_clss_40ft_scg_amt", getImdgN7thClss40ftScgAmt());
		this.hashColumns.put("imdg_n2nd_clss_20ft_scg_amt", getImdgN2ndClss20ftScgAmt());
		this.hashColumns.put("fdr_20ft_ttl_amt", getFdr20ftTtlAmt());
		this.hashColumns.put("imdg_n6th_clss_40ft_scg_amt", getImdgN6thClss40ftScgAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("imdg_n9th_clss_20ft_scg_amt", getImdgN9thClss20ftScgAmt());
		this.hashColumns.put("cost_trf_no", getCostTrfNo());
		this.hashColumns.put("imdg_n7th_clss_20ft_ttl_amt", getImdgN7thClss20ftTtlAmt());
		this.hashColumns.put("imdg_n3rd_clss_20ft_ttl_amt", getImdgN3rdClss20ftTtlAmt());
		this.hashColumns.put("imdg_n6th_clss_svc_flg", getImdgN6thClssSvcFlg());
		this.hashColumns.put("imdg_n8th_clss_svc_flg", getImdgN8thClssSvcFlg());
		this.hashColumns.put("imdg_n3rd_clss_40ft_ttl_amt", getImdgN3rdClss40ftTtlAmt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("imdg_n7th_clss_20ft_scg_amt", getImdgN7thClss20ftScgAmt());
		this.hashColumns.put("imdg_n2nd_clss_40ft_ttl_amt", getImdgN2ndClss40ftTtlAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("imdg_n5th_clss_20ft_scg_amt", getImdgN5thClss20ftScgAmt());
		this.hashColumns.put("imdg_n6th_clss_20ft_scg_amt", getImdgN6thClss20ftScgAmt());
		this.hashColumns.put("imdg_n1st_clss_40ft_scg_amt", getImdgN1stClss40ftScgAmt());
		this.hashColumns.put("imdg_n5th_clss_40ft_ttl_amt", getImdgN5thClss40ftTtlAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("imdg_n5th_clss_40ft_scg_amt", getImdgN5thClss40ftScgAmt());
		this.hashColumns.put("wtr_rcv_term_cd", getWtrRcvTermCd());
		this.hashColumns.put("imdg_n8th_clss_40ft_ttl_amt", getImdgN8thClss40ftTtlAmt());
		this.hashColumns.put("imdg_n5th_clss_20ft_ttl_amt", getImdgN5thClss20ftTtlAmt());
		this.hashColumns.put("imdg_n6th_clss_20ft_ttl_amt", getImdgN6thClss20ftTtlAmt());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("wtr_de_term_cd", getWtrDeTermCd());
		this.hashColumns.put("imdg_n1st_clss_20ft_scg_amt", getImdgN1stClss20ftScgAmt());
		this.hashColumns.put("imdg_n9th_clss_40ft_scg_amt", getImdgN9thClss40ftScgAmt());
		this.hashColumns.put("imdg_n9th_clss_svc_flg", getImdgN9thClssSvcFlg());
		this.hashColumns.put("pctl_io_bnd_cd", getPctlIoBndCd());
		this.hashColumns.put("imdg_n2nd_clss_40ft_scg_amt", getImdgN2ndClss40ftScgAmt());
		this.hashColumns.put("imdg_n3rd_clss_40ft_scg_amt", getImdgN3rdClss40ftScgAmt());
		this.hashColumns.put("imdg_n9th_clss_40ft_ttl_amt", getImdgN9thClss40ftTtlAmt());
		this.hashColumns.put("imdg_n8th_clss_20ft_ttl_amt", getImdgN8thClss20ftTtlAmt());
		this.hashColumns.put("fdr_40ft_ttl_amt", getFdr40ftTtlAmt());
		this.hashColumns.put("imdg_n7th_clss_40ft_ttl_amt", getImdgN7thClss40ftTtlAmt());
		this.hashColumns.put("imdg_n1st_clss_20ft_ttl_amt", getImdgN1stClss20ftTtlAmt());
		this.hashColumns.put("pctl_io_bnd_nm", getPctlIoBndNm());
		this.hashColumns.put("imdg_n3rd_clss_svc_flg", getImdgN3rdClssSvcFlg());
		this.hashColumns.put("imdg_n8th_clss_20ft_scg_amt", getImdgN8thClss20ftScgAmt());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("imdg_n2nd_clss_20ft_ttl_amt", getImdgN2ndClss20ftTtlAmt());
		this.hashColumns.put("imdg_n4th_clss_20ft_ttl_amt", getImdgN4thClss20ftTtlAmt());
		this.hashColumns.put("imdg_n2nd_clss_svc_flg", getImdgN2ndClssSvcFlg());
		this.hashColumns.put("imdg_n4th_clss_20ft_scg_amt", getImdgN4thClss20ftScgAmt());
		this.hashColumns.put("imdg_n5th_clss_svc_flg", getImdgN5thClssSvcFlg());
		this.hashColumns.put("imdg_n4th_clss_40ft_ttl_amt", getImdgN4thClss40ftTtlAmt());
		this.hashColumns.put("imdg_n4th_clss_40ft_scg_amt", getImdgN4thClss40ftScgAmt());
		this.hashColumns.put("agmt_old_flg", getAgmtOldFlg());
		this.hashColumns.put("imdg_n9th_clss_20ft_ttl_amt", getImdgN9thClss20ftTtlAmt());
		this.hashColumns.put("imdg_n6th_clss_40ft_ttl_amt", getImdgN6thClss40ftTtlAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("imdg_n1st_clss_svc_flg", "imdgN1stClssSvcFlg");
		this.hashFields.put("imdg_n8th_clss_40ft_scg_amt", "imdgN8thClss40ftScgAmt");
		this.hashFields.put("imdg_n7th_clss_svc_flg", "imdgN7thClssSvcFlg");
		this.hashFields.put("imdg_n3rd_clss_20ft_scg_amt", "imdgN3rdClss20ftScgAmt");
		this.hashFields.put("imdg_n4th_clss_svc_flg", "imdgN4thClssSvcFlg");
		this.hashFields.put("cost_trf_rout_seq", "costTrfRoutSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("imdg_n1st_clss_40ft_ttl_amt", "imdgN1stClss40ftTtlAmt");
		this.hashFields.put("imdg_n7th_clss_40ft_scg_amt", "imdgN7thClss40ftScgAmt");
		this.hashFields.put("imdg_n2nd_clss_20ft_scg_amt", "imdgN2ndClss20ftScgAmt");
		this.hashFields.put("fdr_20ft_ttl_amt", "fdr20ftTtlAmt");
		this.hashFields.put("imdg_n6th_clss_40ft_scg_amt", "imdgN6thClss40ftScgAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("imdg_n9th_clss_20ft_scg_amt", "imdgN9thClss20ftScgAmt");
		this.hashFields.put("cost_trf_no", "costTrfNo");
		this.hashFields.put("imdg_n7th_clss_20ft_ttl_amt", "imdgN7thClss20ftTtlAmt");
		this.hashFields.put("imdg_n3rd_clss_20ft_ttl_amt", "imdgN3rdClss20ftTtlAmt");
		this.hashFields.put("imdg_n6th_clss_svc_flg", "imdgN6thClssSvcFlg");
		this.hashFields.put("imdg_n8th_clss_svc_flg", "imdgN8thClssSvcFlg");
		this.hashFields.put("imdg_n3rd_clss_40ft_ttl_amt", "imdgN3rdClss40ftTtlAmt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("imdg_n7th_clss_20ft_scg_amt", "imdgN7thClss20ftScgAmt");
		this.hashFields.put("imdg_n2nd_clss_40ft_ttl_amt", "imdgN2ndClss40ftTtlAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("imdg_n5th_clss_20ft_scg_amt", "imdgN5thClss20ftScgAmt");
		this.hashFields.put("imdg_n6th_clss_20ft_scg_amt", "imdgN6thClss20ftScgAmt");
		this.hashFields.put("imdg_n1st_clss_40ft_scg_amt", "imdgN1stClss40ftScgAmt");
		this.hashFields.put("imdg_n5th_clss_40ft_ttl_amt", "imdgN5thClss40ftTtlAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("imdg_n5th_clss_40ft_scg_amt", "imdgN5thClss40ftScgAmt");
		this.hashFields.put("wtr_rcv_term_cd", "wtrRcvTermCd");
		this.hashFields.put("imdg_n8th_clss_40ft_ttl_amt", "imdgN8thClss40ftTtlAmt");
		this.hashFields.put("imdg_n5th_clss_20ft_ttl_amt", "imdgN5thClss20ftTtlAmt");
		this.hashFields.put("imdg_n6th_clss_20ft_ttl_amt", "imdgN6thClss20ftTtlAmt");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("wtr_de_term_cd", "wtrDeTermCd");
		this.hashFields.put("imdg_n1st_clss_20ft_scg_amt", "imdgN1stClss20ftScgAmt");
		this.hashFields.put("imdg_n9th_clss_40ft_scg_amt", "imdgN9thClss40ftScgAmt");
		this.hashFields.put("imdg_n9th_clss_svc_flg", "imdgN9thClssSvcFlg");
		this.hashFields.put("pctl_io_bnd_cd", "pctlIoBndCd");
		this.hashFields.put("imdg_n2nd_clss_40ft_scg_amt", "imdgN2ndClss40ftScgAmt");
		this.hashFields.put("imdg_n3rd_clss_40ft_scg_amt", "imdgN3rdClss40ftScgAmt");
		this.hashFields.put("imdg_n9th_clss_40ft_ttl_amt", "imdgN9thClss40ftTtlAmt");
		this.hashFields.put("imdg_n8th_clss_20ft_ttl_amt", "imdgN8thClss20ftTtlAmt");
		this.hashFields.put("fdr_40ft_ttl_amt", "fdr40ftTtlAmt");
		this.hashFields.put("imdg_n7th_clss_40ft_ttl_amt", "imdgN7thClss40ftTtlAmt");
		this.hashFields.put("imdg_n1st_clss_20ft_ttl_amt", "imdgN1stClss20ftTtlAmt");
		this.hashFields.put("pctl_io_bnd_nm", "pctlIoBndNm");
		this.hashFields.put("imdg_n3rd_clss_svc_flg", "imdgN3rdClssSvcFlg");
		this.hashFields.put("imdg_n8th_clss_20ft_scg_amt", "imdgN8thClss20ftScgAmt");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("imdg_n2nd_clss_20ft_ttl_amt", "imdgN2ndClss20ftTtlAmt");
		this.hashFields.put("imdg_n4th_clss_20ft_ttl_amt", "imdgN4thClss20ftTtlAmt");
		this.hashFields.put("imdg_n2nd_clss_svc_flg", "imdgN2ndClssSvcFlg");
		this.hashFields.put("imdg_n4th_clss_20ft_scg_amt", "imdgN4thClss20ftScgAmt");
		this.hashFields.put("imdg_n5th_clss_svc_flg", "imdgN5thClssSvcFlg");
		this.hashFields.put("imdg_n4th_clss_40ft_ttl_amt", "imdgN4thClss40ftTtlAmt");
		this.hashFields.put("imdg_n4th_clss_40ft_scg_amt", "imdgN4thClss40ftScgAmt");
		this.hashFields.put("agmt_old_flg", "agmtOldFlg");
		this.hashFields.put("imdg_n9th_clss_20ft_ttl_amt", "imdgN9thClss20ftTtlAmt");
		this.hashFields.put("imdg_n6th_clss_40ft_ttl_amt", "imdgN6thClss40ftTtlAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return imdgN1stClssSvcFlg
	 */
	public String getImdgN1stClssSvcFlg() {
		return this.imdgN1stClssSvcFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgN8thClss40ftScgAmt
	 */
	public String getImdgN8thClss40ftScgAmt() {
		return this.imdgN8thClss40ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN7thClssSvcFlg
	 */
	public String getImdgN7thClssSvcFlg() {
		return this.imdgN7thClssSvcFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgN3rdClss20ftScgAmt
	 */
	public String getImdgN3rdClss20ftScgAmt() {
		return this.imdgN3rdClss20ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN4thClssSvcFlg
	 */
	public String getImdgN4thClssSvcFlg() {
		return this.imdgN4thClssSvcFlg;
	}
	
	/**
	 * Column Info
	 * @return costTrfRoutSeq
	 */
	public String getCostTrfRoutSeq() {
		return this.costTrfRoutSeq;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return imdgN1stClss40ftTtlAmt
	 */
	public String getImdgN1stClss40ftTtlAmt() {
		return this.imdgN1stClss40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN7thClss40ftScgAmt
	 */
	public String getImdgN7thClss40ftScgAmt() {
		return this.imdgN7thClss40ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN2ndClss20ftScgAmt
	 */
	public String getImdgN2ndClss20ftScgAmt() {
		return this.imdgN2ndClss20ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @return fdr20ftTtlAmt
	 */
	public String getFdr20ftTtlAmt() {
		return this.fdr20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN6thClss40ftScgAmt
	 */
	public String getImdgN6thClss40ftScgAmt() {
		return this.imdgN6thClss40ftScgAmt;
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
	 * @return imdgN9thClss20ftScgAmt
	 */
	public String getImdgN9thClss20ftScgAmt() {
		return this.imdgN9thClss20ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @return costTrfNo
	 */
	public String getCostTrfNo() {
		return this.costTrfNo;
	}
	
	/**
	 * Column Info
	 * @return imdgN7thClss20ftTtlAmt
	 */
	public String getImdgN7thClss20ftTtlAmt() {
		return this.imdgN7thClss20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN3rdClss20ftTtlAmt
	 */
	public String getImdgN3rdClss20ftTtlAmt() {
		return this.imdgN3rdClss20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN6thClssSvcFlg
	 */
	public String getImdgN6thClssSvcFlg() {
		return this.imdgN6thClssSvcFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgN8thClssSvcFlg
	 */
	public String getImdgN8thClssSvcFlg() {
		return this.imdgN8thClssSvcFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgN3rdClss40ftTtlAmt
	 */
	public String getImdgN3rdClss40ftTtlAmt() {
		return this.imdgN3rdClss40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return imdgN7thClss20ftScgAmt
	 */
	public String getImdgN7thClss20ftScgAmt() {
		return this.imdgN7thClss20ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN2ndClss40ftTtlAmt
	 */
	public String getImdgN2ndClss40ftTtlAmt() {
		return this.imdgN2ndClss40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return imdgN5thClss20ftScgAmt
	 */
	public String getImdgN5thClss20ftScgAmt() {
		return this.imdgN5thClss20ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN6thClss20ftScgAmt
	 */
	public String getImdgN6thClss20ftScgAmt() {
		return this.imdgN6thClss20ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN1stClss40ftScgAmt
	 */
	public String getImdgN1stClss40ftScgAmt() {
		return this.imdgN1stClss40ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN5thClss40ftTtlAmt
	 */
	public String getImdgN5thClss40ftTtlAmt() {
		return this.imdgN5thClss40ftTtlAmt;
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
	 * @return imdgN5thClss40ftScgAmt
	 */
	public String getImdgN5thClss40ftScgAmt() {
		return this.imdgN5thClss40ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @return wtrRcvTermCd
	 */
	public String getWtrRcvTermCd() {
		return this.wtrRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return imdgN8thClss40ftTtlAmt
	 */
	public String getImdgN8thClss40ftTtlAmt() {
		return this.imdgN8thClss40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN5thClss20ftTtlAmt
	 */
	public String getImdgN5thClss20ftTtlAmt() {
		return this.imdgN5thClss20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN6thClss20ftTtlAmt
	 */
	public String getImdgN6thClss20ftTtlAmt() {
		return this.imdgN6thClss20ftTtlAmt;
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
	 * @return wtrDeTermCd
	 */
	public String getWtrDeTermCd() {
		return this.wtrDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return imdgN1stClss20ftScgAmt
	 */
	public String getImdgN1stClss20ftScgAmt() {
		return this.imdgN1stClss20ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN9thClss40ftScgAmt
	 */
	public String getImdgN9thClss40ftScgAmt() {
		return this.imdgN9thClss40ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN9thClssSvcFlg
	 */
	public String getImdgN9thClssSvcFlg() {
		return this.imdgN9thClssSvcFlg;
	}
	
	/**
	 * Column Info
	 * @return pctlIoBndCd
	 */
	public String getPctlIoBndCd() {
		return this.pctlIoBndCd;
	}
	
	/**
	 * Column Info
	 * @return imdgN2ndClss40ftScgAmt
	 */
	public String getImdgN2ndClss40ftScgAmt() {
		return this.imdgN2ndClss40ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN3rdClss40ftScgAmt
	 */
	public String getImdgN3rdClss40ftScgAmt() {
		return this.imdgN3rdClss40ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN9thClss40ftTtlAmt
	 */
	public String getImdgN9thClss40ftTtlAmt() {
		return this.imdgN9thClss40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN8thClss20ftTtlAmt
	 */
	public String getImdgN8thClss20ftTtlAmt() {
		return this.imdgN8thClss20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return fdr40ftTtlAmt
	 */
	public String getFdr40ftTtlAmt() {
		return this.fdr40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN7thClss40ftTtlAmt
	 */
	public String getImdgN7thClss40ftTtlAmt() {
		return this.imdgN7thClss40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN1stClss20ftTtlAmt
	 */
	public String getImdgN1stClss20ftTtlAmt() {
		return this.imdgN1stClss20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return pctlIoBndNm
	 */
	public String getPctlIoBndNm() {
		return this.pctlIoBndNm;
	}
	
	/**
	 * Column Info
	 * @return imdgN3rdClssSvcFlg
	 */
	public String getImdgN3rdClssSvcFlg() {
		return this.imdgN3rdClssSvcFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgN8thClss20ftScgAmt
	 */
	public String getImdgN8thClss20ftScgAmt() {
		return this.imdgN8thClss20ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	
	/**
	 * Column Info
	 * @return imdgN2ndClss20ftTtlAmt
	 */
	public String getImdgN2ndClss20ftTtlAmt() {
		return this.imdgN2ndClss20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN4thClss20ftTtlAmt
	 */
	public String getImdgN4thClss20ftTtlAmt() {
		return this.imdgN4thClss20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN2ndClssSvcFlg
	 */
	public String getImdgN2ndClssSvcFlg() {
		return this.imdgN2ndClssSvcFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgN4thClss20ftScgAmt
	 */
	public String getImdgN4thClss20ftScgAmt() {
		return this.imdgN4thClss20ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN5thClssSvcFlg
	 */
	public String getImdgN5thClssSvcFlg() {
		return this.imdgN5thClssSvcFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgN4thClss40ftTtlAmt
	 */
	public String getImdgN4thClss40ftTtlAmt() {
		return this.imdgN4thClss40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN4thClss40ftScgAmt
	 */
	public String getImdgN4thClss40ftScgAmt() {
		return this.imdgN4thClss40ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @return agmtOldFlg
	 */
	public String getAgmtOldFlg() {
		return this.agmtOldFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgN9thClss20ftTtlAmt
	 */
	public String getImdgN9thClss20ftTtlAmt() {
		return this.imdgN9thClss20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return imdgN6thClss40ftTtlAmt
	 */
	public String getImdgN6thClss40ftTtlAmt() {
		return this.imdgN6thClss40ftTtlAmt;
	}
	

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param imdgN1stClssSvcFlg
	 */
	public void setImdgN1stClssSvcFlg(String imdgN1stClssSvcFlg) {
		this.imdgN1stClssSvcFlg = imdgN1stClssSvcFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgN8thClss40ftScgAmt
	 */
	public void setImdgN8thClss40ftScgAmt(String imdgN8thClss40ftScgAmt) {
		this.imdgN8thClss40ftScgAmt = imdgN8thClss40ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN7thClssSvcFlg
	 */
	public void setImdgN7thClssSvcFlg(String imdgN7thClssSvcFlg) {
		this.imdgN7thClssSvcFlg = imdgN7thClssSvcFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgN3rdClss20ftScgAmt
	 */
	public void setImdgN3rdClss20ftScgAmt(String imdgN3rdClss20ftScgAmt) {
		this.imdgN3rdClss20ftScgAmt = imdgN3rdClss20ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN4thClssSvcFlg
	 */
	public void setImdgN4thClssSvcFlg(String imdgN4thClssSvcFlg) {
		this.imdgN4thClssSvcFlg = imdgN4thClssSvcFlg;
	}
	
	/**
	 * Column Info
	 * @param costTrfRoutSeq
	 */
	public void setCostTrfRoutSeq(String costTrfRoutSeq) {
		this.costTrfRoutSeq = costTrfRoutSeq;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param imdgN1stClss40ftTtlAmt
	 */
	public void setImdgN1stClss40ftTtlAmt(String imdgN1stClss40ftTtlAmt) {
		this.imdgN1stClss40ftTtlAmt = imdgN1stClss40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN7thClss40ftScgAmt
	 */
	public void setImdgN7thClss40ftScgAmt(String imdgN7thClss40ftScgAmt) {
		this.imdgN7thClss40ftScgAmt = imdgN7thClss40ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN2ndClss20ftScgAmt
	 */
	public void setImdgN2ndClss20ftScgAmt(String imdgN2ndClss20ftScgAmt) {
		this.imdgN2ndClss20ftScgAmt = imdgN2ndClss20ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @param fdr20ftTtlAmt
	 */
	public void setFdr20ftTtlAmt(String fdr20ftTtlAmt) {
		this.fdr20ftTtlAmt = fdr20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN6thClss40ftScgAmt
	 */
	public void setImdgN6thClss40ftScgAmt(String imdgN6thClss40ftScgAmt) {
		this.imdgN6thClss40ftScgAmt = imdgN6thClss40ftScgAmt;
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
	 * @param imdgN9thClss20ftScgAmt
	 */
	public void setImdgN9thClss20ftScgAmt(String imdgN9thClss20ftScgAmt) {
		this.imdgN9thClss20ftScgAmt = imdgN9thClss20ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @param costTrfNo
	 */
	public void setCostTrfNo(String costTrfNo) {
		this.costTrfNo = costTrfNo;
	}
	
	/**
	 * Column Info
	 * @param imdgN7thClss20ftTtlAmt
	 */
	public void setImdgN7thClss20ftTtlAmt(String imdgN7thClss20ftTtlAmt) {
		this.imdgN7thClss20ftTtlAmt = imdgN7thClss20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN3rdClss20ftTtlAmt
	 */
	public void setImdgN3rdClss20ftTtlAmt(String imdgN3rdClss20ftTtlAmt) {
		this.imdgN3rdClss20ftTtlAmt = imdgN3rdClss20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN6thClssSvcFlg
	 */
	public void setImdgN6thClssSvcFlg(String imdgN6thClssSvcFlg) {
		this.imdgN6thClssSvcFlg = imdgN6thClssSvcFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgN8thClssSvcFlg
	 */
	public void setImdgN8thClssSvcFlg(String imdgN8thClssSvcFlg) {
		this.imdgN8thClssSvcFlg = imdgN8thClssSvcFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgN3rdClss40ftTtlAmt
	 */
	public void setImdgN3rdClss40ftTtlAmt(String imdgN3rdClss40ftTtlAmt) {
		this.imdgN3rdClss40ftTtlAmt = imdgN3rdClss40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param imdgN7thClss20ftScgAmt
	 */
	public void setImdgN7thClss20ftScgAmt(String imdgN7thClss20ftScgAmt) {
		this.imdgN7thClss20ftScgAmt = imdgN7thClss20ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN2ndClss40ftTtlAmt
	 */
	public void setImdgN2ndClss40ftTtlAmt(String imdgN2ndClss40ftTtlAmt) {
		this.imdgN2ndClss40ftTtlAmt = imdgN2ndClss40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param imdgN5thClss20ftScgAmt
	 */
	public void setImdgN5thClss20ftScgAmt(String imdgN5thClss20ftScgAmt) {
		this.imdgN5thClss20ftScgAmt = imdgN5thClss20ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN6thClss20ftScgAmt
	 */
	public void setImdgN6thClss20ftScgAmt(String imdgN6thClss20ftScgAmt) {
		this.imdgN6thClss20ftScgAmt = imdgN6thClss20ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN1stClss40ftScgAmt
	 */
	public void setImdgN1stClss40ftScgAmt(String imdgN1stClss40ftScgAmt) {
		this.imdgN1stClss40ftScgAmt = imdgN1stClss40ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN5thClss40ftTtlAmt
	 */
	public void setImdgN5thClss40ftTtlAmt(String imdgN5thClss40ftTtlAmt) {
		this.imdgN5thClss40ftTtlAmt = imdgN5thClss40ftTtlAmt;
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
	 * @param imdgN5thClss40ftScgAmt
	 */
	public void setImdgN5thClss40ftScgAmt(String imdgN5thClss40ftScgAmt) {
		this.imdgN5thClss40ftScgAmt = imdgN5thClss40ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @param wtrRcvTermCd
	 */
	public void setWtrRcvTermCd(String wtrRcvTermCd) {
		this.wtrRcvTermCd = wtrRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param imdgN8thClss40ftTtlAmt
	 */
	public void setImdgN8thClss40ftTtlAmt(String imdgN8thClss40ftTtlAmt) {
		this.imdgN8thClss40ftTtlAmt = imdgN8thClss40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN5thClss20ftTtlAmt
	 */
	public void setImdgN5thClss20ftTtlAmt(String imdgN5thClss20ftTtlAmt) {
		this.imdgN5thClss20ftTtlAmt = imdgN5thClss20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN6thClss20ftTtlAmt
	 */
	public void setImdgN6thClss20ftTtlAmt(String imdgN6thClss20ftTtlAmt) {
		this.imdgN6thClss20ftTtlAmt = imdgN6thClss20ftTtlAmt;
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
	 * @param wtrDeTermCd
	 */
	public void setWtrDeTermCd(String wtrDeTermCd) {
		this.wtrDeTermCd = wtrDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param imdgN1stClss20ftScgAmt
	 */
	public void setImdgN1stClss20ftScgAmt(String imdgN1stClss20ftScgAmt) {
		this.imdgN1stClss20ftScgAmt = imdgN1stClss20ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN9thClss40ftScgAmt
	 */
	public void setImdgN9thClss40ftScgAmt(String imdgN9thClss40ftScgAmt) {
		this.imdgN9thClss40ftScgAmt = imdgN9thClss40ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN9thClssSvcFlg
	 */
	public void setImdgN9thClssSvcFlg(String imdgN9thClssSvcFlg) {
		this.imdgN9thClssSvcFlg = imdgN9thClssSvcFlg;
	}
	
	/**
	 * Column Info
	 * @param pctlIoBndCd
	 */
	public void setPctlIoBndCd(String pctlIoBndCd) {
		this.pctlIoBndCd = pctlIoBndCd;
	}
	
	/**
	 * Column Info
	 * @param imdgN2ndClss40ftScgAmt
	 */
	public void setImdgN2ndClss40ftScgAmt(String imdgN2ndClss40ftScgAmt) {
		this.imdgN2ndClss40ftScgAmt = imdgN2ndClss40ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN3rdClss40ftScgAmt
	 */
	public void setImdgN3rdClss40ftScgAmt(String imdgN3rdClss40ftScgAmt) {
		this.imdgN3rdClss40ftScgAmt = imdgN3rdClss40ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN9thClss40ftTtlAmt
	 */
	public void setImdgN9thClss40ftTtlAmt(String imdgN9thClss40ftTtlAmt) {
		this.imdgN9thClss40ftTtlAmt = imdgN9thClss40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN8thClss20ftTtlAmt
	 */
	public void setImdgN8thClss20ftTtlAmt(String imdgN8thClss20ftTtlAmt) {
		this.imdgN8thClss20ftTtlAmt = imdgN8thClss20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param fdr40ftTtlAmt
	 */
	public void setFdr40ftTtlAmt(String fdr40ftTtlAmt) {
		this.fdr40ftTtlAmt = fdr40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN7thClss40ftTtlAmt
	 */
	public void setImdgN7thClss40ftTtlAmt(String imdgN7thClss40ftTtlAmt) {
		this.imdgN7thClss40ftTtlAmt = imdgN7thClss40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN1stClss20ftTtlAmt
	 */
	public void setImdgN1stClss20ftTtlAmt(String imdgN1stClss20ftTtlAmt) {
		this.imdgN1stClss20ftTtlAmt = imdgN1stClss20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param pctlIoBndNm
	 */
	public void setPctlIoBndNm(String pctlIoBndNm) {
		this.pctlIoBndNm = pctlIoBndNm;
	}
	
	/**
	 * Column Info
	 * @param imdgN3rdClssSvcFlg
	 */
	public void setImdgN3rdClssSvcFlg(String imdgN3rdClssSvcFlg) {
		this.imdgN3rdClssSvcFlg = imdgN3rdClssSvcFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgN8thClss20ftScgAmt
	 */
	public void setImdgN8thClss20ftScgAmt(String imdgN8thClss20ftScgAmt) {
		this.imdgN8thClss20ftScgAmt = imdgN8thClss20ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * Column Info
	 * @param imdgN2ndClss20ftTtlAmt
	 */
	public void setImdgN2ndClss20ftTtlAmt(String imdgN2ndClss20ftTtlAmt) {
		this.imdgN2ndClss20ftTtlAmt = imdgN2ndClss20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN4thClss20ftTtlAmt
	 */
	public void setImdgN4thClss20ftTtlAmt(String imdgN4thClss20ftTtlAmt) {
		this.imdgN4thClss20ftTtlAmt = imdgN4thClss20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN2ndClssSvcFlg
	 */
	public void setImdgN2ndClssSvcFlg(String imdgN2ndClssSvcFlg) {
		this.imdgN2ndClssSvcFlg = imdgN2ndClssSvcFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgN4thClss20ftScgAmt
	 */
	public void setImdgN4thClss20ftScgAmt(String imdgN4thClss20ftScgAmt) {
		this.imdgN4thClss20ftScgAmt = imdgN4thClss20ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN5thClssSvcFlg
	 */
	public void setImdgN5thClssSvcFlg(String imdgN5thClssSvcFlg) {
		this.imdgN5thClssSvcFlg = imdgN5thClssSvcFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgN4thClss40ftTtlAmt
	 */
	public void setImdgN4thClss40ftTtlAmt(String imdgN4thClss40ftTtlAmt) {
		this.imdgN4thClss40ftTtlAmt = imdgN4thClss40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN4thClss40ftScgAmt
	 */
	public void setImdgN4thClss40ftScgAmt(String imdgN4thClss40ftScgAmt) {
		this.imdgN4thClss40ftScgAmt = imdgN4thClss40ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @param agmtOldFlg
	 */
	public void setAgmtOldFlg(String agmtOldFlg) {
		this.agmtOldFlg = agmtOldFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgN9thClss20ftTtlAmt
	 */
	public void setImdgN9thClss20ftTtlAmt(String imdgN9thClss20ftTtlAmt) {
		this.imdgN9thClss20ftTtlAmt = imdgN9thClss20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param imdgN6thClss40ftTtlAmt
	 */
	public void setImdgN6thClss40ftTtlAmt(String imdgN6thClss40ftTtlAmt) {
		this.imdgN6thClss40ftTtlAmt = imdgN6thClss40ftTtlAmt;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setImdgN1stClssSvcFlg(JSPUtil.getParameter(request, prefix + "imdg_n1st_clss_svc_flg", ""));
		setImdgN8thClss40ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n8th_clss_40ft_scg_amt", ""));
		setImdgN7thClssSvcFlg(JSPUtil.getParameter(request, prefix + "imdg_n7th_clss_svc_flg", ""));
		setImdgN3rdClss20ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n3rd_clss_20ft_scg_amt", ""));
		setImdgN4thClssSvcFlg(JSPUtil.getParameter(request, prefix + "imdg_n4th_clss_svc_flg", ""));
		setCostTrfRoutSeq(JSPUtil.getParameter(request, prefix + "cost_trf_rout_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setImdgN1stClss40ftTtlAmt(JSPUtil.getParameter(request, prefix + "imdg_n1st_clss_40ft_ttl_amt", ""));
		setImdgN7thClss40ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n7th_clss_40ft_scg_amt", ""));
		setImdgN2ndClss20ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n2nd_clss_20ft_scg_amt", ""));
		setFdr20ftTtlAmt(JSPUtil.getParameter(request, prefix + "fdr_20ft_ttl_amt", ""));
		setImdgN6thClss40ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n6th_clss_40ft_scg_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setImdgN9thClss20ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n9th_clss_20ft_scg_amt", ""));
		setCostTrfNo(JSPUtil.getParameter(request, prefix + "cost_trf_no", ""));
		setImdgN7thClss20ftTtlAmt(JSPUtil.getParameter(request, prefix + "imdg_n7th_clss_20ft_ttl_amt", ""));
		setImdgN3rdClss20ftTtlAmt(JSPUtil.getParameter(request, prefix + "imdg_n3rd_clss_20ft_ttl_amt", ""));
		setImdgN6thClssSvcFlg(JSPUtil.getParameter(request, prefix + "imdg_n6th_clss_svc_flg", ""));
		setImdgN8thClssSvcFlg(JSPUtil.getParameter(request, prefix + "imdg_n8th_clss_svc_flg", ""));
		setImdgN3rdClss40ftTtlAmt(JSPUtil.getParameter(request, prefix + "imdg_n3rd_clss_40ft_ttl_amt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setImdgN7thClss20ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n7th_clss_20ft_scg_amt", ""));
		setImdgN2ndClss40ftTtlAmt(JSPUtil.getParameter(request, prefix + "imdg_n2nd_clss_40ft_ttl_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setImdgN5thClss20ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n5th_clss_20ft_scg_amt", ""));
		setImdgN6thClss20ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n6th_clss_20ft_scg_amt", ""));
		setImdgN1stClss40ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n1st_clss_40ft_scg_amt", ""));
		setImdgN5thClss40ftTtlAmt(JSPUtil.getParameter(request, prefix + "imdg_n5th_clss_40ft_ttl_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setImdgN5thClss40ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n5th_clss_40ft_scg_amt", ""));
		setWtrRcvTermCd(JSPUtil.getParameter(request, prefix + "wtr_rcv_term_cd", ""));
		setImdgN8thClss40ftTtlAmt(JSPUtil.getParameter(request, prefix + "imdg_n8th_clss_40ft_ttl_amt", ""));
		setImdgN5thClss20ftTtlAmt(JSPUtil.getParameter(request, prefix + "imdg_n5th_clss_20ft_ttl_amt", ""));
		setImdgN6thClss20ftTtlAmt(JSPUtil.getParameter(request, prefix + "imdg_n6th_clss_20ft_ttl_amt", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setWtrDeTermCd(JSPUtil.getParameter(request, prefix + "wtr_de_term_cd", ""));
		setImdgN1stClss20ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n1st_clss_20ft_scg_amt", ""));
		setImdgN9thClss40ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n9th_clss_40ft_scg_amt", ""));
		setImdgN9thClssSvcFlg(JSPUtil.getParameter(request, prefix + "imdg_n9th_clss_svc_flg", ""));
		setPctlIoBndCd(JSPUtil.getParameter(request, prefix + "pctl_io_bnd_cd", ""));
		setImdgN2ndClss40ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n2nd_clss_40ft_scg_amt", ""));
		setImdgN3rdClss40ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n3rd_clss_40ft_scg_amt", ""));
		setImdgN9thClss40ftTtlAmt(JSPUtil.getParameter(request, prefix + "imdg_n9th_clss_40ft_ttl_amt", ""));
		setImdgN8thClss20ftTtlAmt(JSPUtil.getParameter(request, prefix + "imdg_n8th_clss_20ft_ttl_amt", ""));
		setFdr40ftTtlAmt(JSPUtil.getParameter(request, prefix + "fdr_40ft_ttl_amt", ""));
		setImdgN7thClss40ftTtlAmt(JSPUtil.getParameter(request, prefix + "imdg_n7th_clss_40ft_ttl_amt", ""));
		setImdgN1stClss20ftTtlAmt(JSPUtil.getParameter(request, prefix + "imdg_n1st_clss_20ft_ttl_amt", ""));
		setPctlIoBndNm(JSPUtil.getParameter(request, prefix + "pctl_io_bnd_nm", ""));
		setImdgN3rdClssSvcFlg(JSPUtil.getParameter(request, prefix + "imdg_n3rd_clss_svc_flg", ""));
		setImdgN8thClss20ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n8th_clss_20ft_scg_amt", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setImdgN2ndClss20ftTtlAmt(JSPUtil.getParameter(request, prefix + "imdg_n2nd_clss_20ft_ttl_amt", ""));
		setImdgN4thClss20ftTtlAmt(JSPUtil.getParameter(request, prefix + "imdg_n4th_clss_20ft_ttl_amt", ""));
		setImdgN2ndClssSvcFlg(JSPUtil.getParameter(request, prefix + "imdg_n2nd_clss_svc_flg", ""));
		setImdgN4thClss20ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n4th_clss_20ft_scg_amt", ""));
		setImdgN5thClssSvcFlg(JSPUtil.getParameter(request, prefix + "imdg_n5th_clss_svc_flg", ""));
		setImdgN4thClss40ftTtlAmt(JSPUtil.getParameter(request, prefix + "imdg_n4th_clss_40ft_ttl_amt", ""));
		setImdgN4thClss40ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n4th_clss_40ft_scg_amt", ""));
		setAgmtOldFlg(JSPUtil.getParameter(request, prefix + "agmt_old_flg", ""));
		setImdgN9thClss20ftTtlAmt(JSPUtil.getParameter(request, prefix + "imdg_n9th_clss_20ft_ttl_amt", ""));
		setImdgN6thClss40ftTtlAmt(JSPUtil.getParameter(request, prefix + "imdg_n6th_clss_40ft_ttl_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurFeederDgCostVO[]
	 */
	public EurFeederDgCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurFeederDgCostVO[]
	 */
	public EurFeederDgCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EurFeederDgCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] imdgN1stClssSvcFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_n1st_clss_svc_flg", length));
			String[] imdgN8thClss40ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n8th_clss_40ft_scg_amt", length));
			String[] imdgN7thClssSvcFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_n7th_clss_svc_flg", length));
			String[] imdgN3rdClss20ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n3rd_clss_20ft_scg_amt", length));
			String[] imdgN4thClssSvcFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_n4th_clss_svc_flg", length));
			String[] costTrfRoutSeq = (JSPUtil.getParameter(request, prefix	+ "cost_trf_rout_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] imdgN1stClss40ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n1st_clss_40ft_ttl_amt", length));
			String[] imdgN7thClss40ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n7th_clss_40ft_scg_amt", length));
			String[] imdgN2ndClss20ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n2nd_clss_20ft_scg_amt", length));
			String[] fdr20ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "fdr_20ft_ttl_amt", length));
			String[] imdgN6thClss40ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n6th_clss_40ft_scg_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] imdgN9thClss20ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n9th_clss_20ft_scg_amt", length));
			String[] costTrfNo = (JSPUtil.getParameter(request, prefix	+ "cost_trf_no", length));
			String[] imdgN7thClss20ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n7th_clss_20ft_ttl_amt", length));
			String[] imdgN3rdClss20ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n3rd_clss_20ft_ttl_amt", length));
			String[] imdgN6thClssSvcFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_n6th_clss_svc_flg", length));
			String[] imdgN8thClssSvcFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_n8th_clss_svc_flg", length));
			String[] imdgN3rdClss40ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n3rd_clss_40ft_ttl_amt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] imdgN7thClss20ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n7th_clss_20ft_scg_amt", length));
			String[] imdgN2ndClss40ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n2nd_clss_40ft_ttl_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] imdgN5thClss20ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n5th_clss_20ft_scg_amt", length));
			String[] imdgN6thClss20ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n6th_clss_20ft_scg_amt", length));
			String[] imdgN1stClss40ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n1st_clss_40ft_scg_amt", length));
			String[] imdgN5thClss40ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n5th_clss_40ft_ttl_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] imdgN5thClss40ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n5th_clss_40ft_scg_amt", length));
			String[] wtrRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "wtr_rcv_term_cd", length));
			String[] imdgN8thClss40ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n8th_clss_40ft_ttl_amt", length));
			String[] imdgN5thClss20ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n5th_clss_20ft_ttl_amt", length));
			String[] imdgN6thClss20ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n6th_clss_20ft_ttl_amt", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] wtrDeTermCd = (JSPUtil.getParameter(request, prefix	+ "wtr_de_term_cd", length));
			String[] imdgN1stClss20ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n1st_clss_20ft_scg_amt", length));
			String[] imdgN9thClss40ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n9th_clss_40ft_scg_amt", length));
			String[] imdgN9thClssSvcFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_n9th_clss_svc_flg", length));
			String[] pctlIoBndCd = (JSPUtil.getParameter(request, prefix	+ "pctl_io_bnd_cd", length));
			String[] imdgN2ndClss40ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n2nd_clss_40ft_scg_amt", length));
			String[] imdgN3rdClss40ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n3rd_clss_40ft_scg_amt", length));
			String[] imdgN9thClss40ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n9th_clss_40ft_ttl_amt", length));
			String[] imdgN8thClss20ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n8th_clss_20ft_ttl_amt", length));
			String[] fdr40ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "fdr_40ft_ttl_amt", length));
			String[] imdgN7thClss40ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n7th_clss_40ft_ttl_amt", length));
			String[] imdgN1stClss20ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n1st_clss_20ft_ttl_amt", length));
			String[] pctlIoBndNm = (JSPUtil.getParameter(request, prefix	+ "pctl_io_bnd_nm", length));
			String[] imdgN3rdClssSvcFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_n3rd_clss_svc_flg", length));
			String[] imdgN8thClss20ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n8th_clss_20ft_scg_amt", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] imdgN2ndClss20ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n2nd_clss_20ft_ttl_amt", length));
			String[] imdgN4thClss20ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n4th_clss_20ft_ttl_amt", length));
			String[] imdgN2ndClssSvcFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_n2nd_clss_svc_flg", length));
			String[] imdgN4thClss20ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n4th_clss_20ft_scg_amt", length));
			String[] imdgN5thClssSvcFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_n5th_clss_svc_flg", length));
			String[] imdgN4thClss40ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n4th_clss_40ft_ttl_amt", length));
			String[] imdgN4thClss40ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n4th_clss_40ft_scg_amt", length));
			String[] agmtOldFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_old_flg", length));
			String[] imdgN9thClss20ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n9th_clss_20ft_ttl_amt", length));
			String[] imdgN6thClss40ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n6th_clss_40ft_ttl_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new EurFeederDgCostVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (imdgN1stClssSvcFlg[i] != null)
					model.setImdgN1stClssSvcFlg(imdgN1stClssSvcFlg[i]);
				if (imdgN8thClss40ftScgAmt[i] != null)
					model.setImdgN8thClss40ftScgAmt(imdgN8thClss40ftScgAmt[i]);
				if (imdgN7thClssSvcFlg[i] != null)
					model.setImdgN7thClssSvcFlg(imdgN7thClssSvcFlg[i]);
				if (imdgN3rdClss20ftScgAmt[i] != null)
					model.setImdgN3rdClss20ftScgAmt(imdgN3rdClss20ftScgAmt[i]);
				if (imdgN4thClssSvcFlg[i] != null)
					model.setImdgN4thClssSvcFlg(imdgN4thClssSvcFlg[i]);
				if (costTrfRoutSeq[i] != null)
					model.setCostTrfRoutSeq(costTrfRoutSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (imdgN1stClss40ftTtlAmt[i] != null)
					model.setImdgN1stClss40ftTtlAmt(imdgN1stClss40ftTtlAmt[i]);
				if (imdgN7thClss40ftScgAmt[i] != null)
					model.setImdgN7thClss40ftScgAmt(imdgN7thClss40ftScgAmt[i]);
				if (imdgN2ndClss20ftScgAmt[i] != null)
					model.setImdgN2ndClss20ftScgAmt(imdgN2ndClss20ftScgAmt[i]);
				if (fdr20ftTtlAmt[i] != null)
					model.setFdr20ftTtlAmt(fdr20ftTtlAmt[i]);
				if (imdgN6thClss40ftScgAmt[i] != null)
					model.setImdgN6thClss40ftScgAmt(imdgN6thClss40ftScgAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (imdgN9thClss20ftScgAmt[i] != null)
					model.setImdgN9thClss20ftScgAmt(imdgN9thClss20ftScgAmt[i]);
				if (costTrfNo[i] != null)
					model.setCostTrfNo(costTrfNo[i]);
				if (imdgN7thClss20ftTtlAmt[i] != null)
					model.setImdgN7thClss20ftTtlAmt(imdgN7thClss20ftTtlAmt[i]);
				if (imdgN3rdClss20ftTtlAmt[i] != null)
					model.setImdgN3rdClss20ftTtlAmt(imdgN3rdClss20ftTtlAmt[i]);
				if (imdgN6thClssSvcFlg[i] != null)
					model.setImdgN6thClssSvcFlg(imdgN6thClssSvcFlg[i]);
				if (imdgN8thClssSvcFlg[i] != null)
					model.setImdgN8thClssSvcFlg(imdgN8thClssSvcFlg[i]);
				if (imdgN3rdClss40ftTtlAmt[i] != null)
					model.setImdgN3rdClss40ftTtlAmt(imdgN3rdClss40ftTtlAmt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (imdgN7thClss20ftScgAmt[i] != null)
					model.setImdgN7thClss20ftScgAmt(imdgN7thClss20ftScgAmt[i]);
				if (imdgN2ndClss40ftTtlAmt[i] != null)
					model.setImdgN2ndClss40ftTtlAmt(imdgN2ndClss40ftTtlAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (imdgN5thClss20ftScgAmt[i] != null)
					model.setImdgN5thClss20ftScgAmt(imdgN5thClss20ftScgAmt[i]);
				if (imdgN6thClss20ftScgAmt[i] != null)
					model.setImdgN6thClss20ftScgAmt(imdgN6thClss20ftScgAmt[i]);
				if (imdgN1stClss40ftScgAmt[i] != null)
					model.setImdgN1stClss40ftScgAmt(imdgN1stClss40ftScgAmt[i]);
				if (imdgN5thClss40ftTtlAmt[i] != null)
					model.setImdgN5thClss40ftTtlAmt(imdgN5thClss40ftTtlAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (imdgN5thClss40ftScgAmt[i] != null)
					model.setImdgN5thClss40ftScgAmt(imdgN5thClss40ftScgAmt[i]);
				if (wtrRcvTermCd[i] != null)
					model.setWtrRcvTermCd(wtrRcvTermCd[i]);
				if (imdgN8thClss40ftTtlAmt[i] != null)
					model.setImdgN8thClss40ftTtlAmt(imdgN8thClss40ftTtlAmt[i]);
				if (imdgN5thClss20ftTtlAmt[i] != null)
					model.setImdgN5thClss20ftTtlAmt(imdgN5thClss20ftTtlAmt[i]);
				if (imdgN6thClss20ftTtlAmt[i] != null)
					model.setImdgN6thClss20ftTtlAmt(imdgN6thClss20ftTtlAmt[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (wtrDeTermCd[i] != null)
					model.setWtrDeTermCd(wtrDeTermCd[i]);
				if (imdgN1stClss20ftScgAmt[i] != null)
					model.setImdgN1stClss20ftScgAmt(imdgN1stClss20ftScgAmt[i]);
				if (imdgN9thClss40ftScgAmt[i] != null)
					model.setImdgN9thClss40ftScgAmt(imdgN9thClss40ftScgAmt[i]);
				if (imdgN9thClssSvcFlg[i] != null)
					model.setImdgN9thClssSvcFlg(imdgN9thClssSvcFlg[i]);
				if (pctlIoBndCd[i] != null)
					model.setPctlIoBndCd(pctlIoBndCd[i]);
				if (imdgN2ndClss40ftScgAmt[i] != null)
					model.setImdgN2ndClss40ftScgAmt(imdgN2ndClss40ftScgAmt[i]);
				if (imdgN3rdClss40ftScgAmt[i] != null)
					model.setImdgN3rdClss40ftScgAmt(imdgN3rdClss40ftScgAmt[i]);
				if (imdgN9thClss40ftTtlAmt[i] != null)
					model.setImdgN9thClss40ftTtlAmt(imdgN9thClss40ftTtlAmt[i]);
				if (imdgN8thClss20ftTtlAmt[i] != null)
					model.setImdgN8thClss20ftTtlAmt(imdgN8thClss20ftTtlAmt[i]);
				if (fdr40ftTtlAmt[i] != null)
					model.setFdr40ftTtlAmt(fdr40ftTtlAmt[i]);
				if (imdgN7thClss40ftTtlAmt[i] != null)
					model.setImdgN7thClss40ftTtlAmt(imdgN7thClss40ftTtlAmt[i]);
				if (imdgN1stClss20ftTtlAmt[i] != null)
					model.setImdgN1stClss20ftTtlAmt(imdgN1stClss20ftTtlAmt[i]);
				if (pctlIoBndNm[i] != null)
					model.setPctlIoBndNm(pctlIoBndNm[i]);
				if (imdgN3rdClssSvcFlg[i] != null)
					model.setImdgN3rdClssSvcFlg(imdgN3rdClssSvcFlg[i]);
				if (imdgN8thClss20ftScgAmt[i] != null)
					model.setImdgN8thClss20ftScgAmt(imdgN8thClss20ftScgAmt[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (imdgN2ndClss20ftTtlAmt[i] != null)
					model.setImdgN2ndClss20ftTtlAmt(imdgN2ndClss20ftTtlAmt[i]);
				if (imdgN4thClss20ftTtlAmt[i] != null)
					model.setImdgN4thClss20ftTtlAmt(imdgN4thClss20ftTtlAmt[i]);
				if (imdgN2ndClssSvcFlg[i] != null)
					model.setImdgN2ndClssSvcFlg(imdgN2ndClssSvcFlg[i]);
				if (imdgN4thClss20ftScgAmt[i] != null)
					model.setImdgN4thClss20ftScgAmt(imdgN4thClss20ftScgAmt[i]);
				if (imdgN5thClssSvcFlg[i] != null)
					model.setImdgN5thClssSvcFlg(imdgN5thClssSvcFlg[i]);
				if (imdgN4thClss40ftTtlAmt[i] != null)
					model.setImdgN4thClss40ftTtlAmt(imdgN4thClss40ftTtlAmt[i]);
				if (imdgN4thClss40ftScgAmt[i] != null)
					model.setImdgN4thClss40ftScgAmt(imdgN4thClss40ftScgAmt[i]);
				if (agmtOldFlg[i] != null)
					model.setAgmtOldFlg(agmtOldFlg[i]);
				if (imdgN9thClss20ftTtlAmt[i] != null)
					model.setImdgN9thClss20ftTtlAmt(imdgN9thClss20ftTtlAmt[i]);
				if (imdgN6thClss40ftTtlAmt[i] != null)
					model.setImdgN6thClss40ftTtlAmt(imdgN6thClss40ftTtlAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEurFeederDgCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EurFeederDgCostVO[]
	 */
	public EurFeederDgCostVO[] getEurFeederDgCostVOs(){
		EurFeederDgCostVO[] vos = (EurFeederDgCostVO[])models.toArray(new EurFeederDgCostVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN1stClssSvcFlg = this.imdgN1stClssSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN8thClss40ftScgAmt = this.imdgN8thClss40ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN7thClssSvcFlg = this.imdgN7thClssSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN3rdClss20ftScgAmt = this.imdgN3rdClss20ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN4thClssSvcFlg = this.imdgN4thClssSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfRoutSeq = this.costTrfRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN1stClss40ftTtlAmt = this.imdgN1stClss40ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN7thClss40ftScgAmt = this.imdgN7thClss40ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN2ndClss20ftScgAmt = this.imdgN2ndClss20ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdr20ftTtlAmt = this.fdr20ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN6thClss40ftScgAmt = this.imdgN6thClss40ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN9thClss20ftScgAmt = this.imdgN9thClss20ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfNo = this.costTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN7thClss20ftTtlAmt = this.imdgN7thClss20ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN3rdClss20ftTtlAmt = this.imdgN3rdClss20ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN6thClssSvcFlg = this.imdgN6thClssSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN8thClssSvcFlg = this.imdgN8thClssSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN3rdClss40ftTtlAmt = this.imdgN3rdClss40ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN7thClss20ftScgAmt = this.imdgN7thClss20ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN2ndClss40ftTtlAmt = this.imdgN2ndClss40ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN5thClss20ftScgAmt = this.imdgN5thClss20ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN6thClss20ftScgAmt = this.imdgN6thClss20ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN1stClss40ftScgAmt = this.imdgN1stClss40ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN5thClss40ftTtlAmt = this.imdgN5thClss40ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN5thClss40ftScgAmt = this.imdgN5thClss40ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrRcvTermCd = this.wtrRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN8thClss40ftTtlAmt = this.imdgN8thClss40ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN5thClss20ftTtlAmt = this.imdgN5thClss20ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN6thClss20ftTtlAmt = this.imdgN6thClss20ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrDeTermCd = this.wtrDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN1stClss20ftScgAmt = this.imdgN1stClss20ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN9thClss40ftScgAmt = this.imdgN9thClss40ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN9thClssSvcFlg = this.imdgN9thClssSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlIoBndCd = this.pctlIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN2ndClss40ftScgAmt = this.imdgN2ndClss40ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN3rdClss40ftScgAmt = this.imdgN3rdClss40ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN9thClss40ftTtlAmt = this.imdgN9thClss40ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN8thClss20ftTtlAmt = this.imdgN8thClss20ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdr40ftTtlAmt = this.fdr40ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN7thClss40ftTtlAmt = this.imdgN7thClss40ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN1stClss20ftTtlAmt = this.imdgN1stClss20ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlIoBndNm = this.pctlIoBndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN3rdClssSvcFlg = this.imdgN3rdClssSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN8thClss20ftScgAmt = this.imdgN8thClss20ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN2ndClss20ftTtlAmt = this.imdgN2ndClss20ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN4thClss20ftTtlAmt = this.imdgN4thClss20ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN2ndClssSvcFlg = this.imdgN2ndClssSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN4thClss20ftScgAmt = this.imdgN4thClss20ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN5thClssSvcFlg = this.imdgN5thClssSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN4thClss40ftTtlAmt = this.imdgN4thClss40ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN4thClss40ftScgAmt = this.imdgN4thClss40ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOldFlg = this.agmtOldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN9thClss20ftTtlAmt = this.imdgN9thClss20ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN6thClss40ftTtlAmt = this.imdgN6thClss40ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
