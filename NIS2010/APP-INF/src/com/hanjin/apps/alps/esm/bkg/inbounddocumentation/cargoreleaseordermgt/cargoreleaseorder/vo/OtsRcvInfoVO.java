/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OtsRcvInfoVO.java
*@FileTitle : OtsRcvInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.10.26 이진서 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OtsRcvInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OtsRcvInfoVO> models = new ArrayList<OtsRcvInfoVO>();
	
	/* Column Info */
	private String pptRcvOfcCd = null;
	/* Column Info */
	private String cctOtsCurrCd3 = null;
	/* Column Info */
	private String cctOtsCurrCd4 = null;
	/* Column Info */
	private String cctOtsCurrCd1 = null;
	/* Column Info */
	private String cctOtsCurrCd2 = null;
	/* Column Info */
	private String n3ptyCctRcvDt = null;
	/* Column Info */
	private String cctOtsCurrCd5 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cctRcvOfcCd = null;
	/* Column Info */
	private String n3ptyPptOtsCurrCd3 = null;
	/* Column Info */
	private String n3ptyPptOtsCurrCd4 = null;
	/* Column Info */
	private String n3ptyPptOtsCurrCd1 = null;
	/* Column Info */
	private String n3ptyPptOtsCurrCd2 = null;
	/* Column Info */
	private String cctRcvDt = null;
	/* Column Info */
	private String n3ptyCctRcvOfcCd = null;
	/* Column Info */
	private String n3ptyPptOtsCurrCd5 = null;
	/* Column Info */
	private String totOtsCurrCd1 = null;
	/* Column Info */
	private String totOtsCurrCd2 = null;
	/* Column Info */
	private String totOtsCurrCd3 = null;
	/* Column Info */
	private String totOtsCurrCd4 = null;
	/* Column Info */
	private String totOtsCurrCd5 = null;
	/* Column Info */
	private String n3ptyPptRcvDt = null;
	/* Column Info */
	private String n3ptyPptRcvUsrId = null;
	/* Column Info */
	private String n3ptyCctOtsAmt4 = null;
	/* Column Info */
	private String n3ptyCctOtsAmt5 = null;
	/* Column Info */
	private String pptRcvUsrId = null;
	/* Column Info */
	private String n3ptyCctOtsAmt2 = null;
	/* Column Info */
	private String n3ptyCctOtsAmt3 = null;
	/* Column Info */
	private String n3ptyCctStsCd = null;
	/* Column Info */
	private String n3ptyCctOtsAmt1 = null;
	/* Column Info */
	private String pptStsCd = null;
	/* Column Info */
	private String totOtsStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pptRcvDt = null;
	/* Column Info */
	private String pptOtsCurrCd5 = null;
	/* Column Info */
	private String eaiResult = null;
	/* Column Info */
	private String totOtsAmt1 = null;
	/* Column Info */
	private String totOtsAmt2 = null;
	/* Column Info */
	private String pptOtsCurrCd3 = null;
	/* Column Info */
	private String n3ptyPptOtsAmt5 = null;
	/* Column Info */
	private String pptOtsCurrCd4 = null;
	/* Column Info */
	private String n3ptyPptOtsAmt4 = null;
	/* Column Info */
	private String pptOtsAmt1 = null;
	/* Column Info */
	private String pptOtsCurrCd1 = null;
	/* Column Info */
	private String n3ptyPptOtsAmt3 = null;
	/* Column Info */
	private String pptOtsCurrCd2 = null;
	/* Column Info */
	private String n3ptyPptOtsAmt2 = null;
	/* Column Info */
	private String pptOtsAmt3 = null;
	/* Column Info */
	private String n3ptyPptOtsAmt1 = null;
	/* Column Info */
	private String pptOtsAmt2 = null;
	/* Column Info */
	private String pptOtsAmt5 = null;
	/* Column Info */
	private String pptOtsAmt4 = null;
	/* Column Info */
	private String cctStsCd = null;
	/* Column Info */
	private String n3ptyPptRcvOfcCd = null;
	/* Column Info */
	private String n3ptyCctOtsCurrCd5 = null;
	/* Column Info */
	private String cctOtsAmt5 = null;
	/* Column Info */
	private String n3ptyCctOtsCurrCd2 = null;
	/* Column Info */
	private String totOtsAmt5 = null;
	/* Column Info */
	private String cctOtsAmt4 = null;
	/* Column Info */
	private String n3ptyCctOtsCurrCd1 = null;
	/* Column Info */
	private String totOtsAmt4 = null;
	/* Column Info */
	private String cctOtsAmt3 = null;
	/* Column Info */
	private String n3ptyCctOtsCurrCd4 = null;
	/* Column Info */
	private String totOtsAmt3 = null;
	/* Column Info */
	private String cctOtsAmt2 = null;
	/* Column Info */
	private String n3ptyCctOtsCurrCd3 = null;
	/* Column Info */
	private String cctOtsAmt1 = null;
	/* Column Info */
	private String cctRcvUsrId = null;
	/* Column Info */
	private String n3ptyCctRcvUsrId = null;
	/* Column Info */
	private String n3ptyPptStsCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OtsRcvInfoVO() {}

	public OtsRcvInfoVO(String ibflag, String pagerows, String totOtsStsCd, String eaiResult, String totOtsCurrCd1, String totOtsCurrCd2, String totOtsCurrCd3, String totOtsCurrCd4, String totOtsCurrCd5, String totOtsAmt1, String totOtsAmt2, String totOtsAmt3, String totOtsAmt4, String totOtsAmt5, String pptStsCd, String pptRcvOfcCd, String pptRcvUsrId, String pptRcvDt, String cctStsCd, String cctRcvOfcCd, String cctRcvUsrId, String cctRcvDt, String cctOtsCurrCd1, String cctOtsCurrCd2, String cctOtsCurrCd3, String cctOtsCurrCd4, String cctOtsCurrCd5, String cctOtsAmt1, String cctOtsAmt2, String cctOtsAmt3, String cctOtsAmt4, String cctOtsAmt5, String n3ptyPptStsCd, String n3ptyPptRcvOfcCd, String n3ptyPptRcvUsrId, String n3ptyPptRcvDt, String n3ptyCctStsCd, String n3ptyCctRcvOfcCd, String n3ptyCctRcvUsrId, String n3ptyCctRcvDt, String n3ptyCctOtsCurrCd1, String n3ptyCctOtsCurrCd2, String n3ptyCctOtsCurrCd3, String n3ptyCctOtsCurrCd4, String n3ptyCctOtsCurrCd5, String n3ptyCctOtsAmt1, String n3ptyCctOtsAmt2, String n3ptyCctOtsAmt3, String n3ptyCctOtsAmt4, String n3ptyCctOtsAmt5, String n3ptyPptOtsCurrCd1, String n3ptyPptOtsCurrCd2, String n3ptyPptOtsCurrCd3, String n3ptyPptOtsCurrCd4, String n3ptyPptOtsCurrCd5, String n3ptyPptOtsAmt1, String n3ptyPptOtsAmt2, String n3ptyPptOtsAmt3, String n3ptyPptOtsAmt4, String n3ptyPptOtsAmt5, String pptOtsCurrCd1, String pptOtsCurrCd2, String pptOtsCurrCd3, String pptOtsCurrCd4, String pptOtsCurrCd5, String pptOtsAmt1, String pptOtsAmt2, String pptOtsAmt3, String pptOtsAmt4, String pptOtsAmt5) {
		this.pptRcvOfcCd = pptRcvOfcCd;
		this.cctOtsCurrCd3 = cctOtsCurrCd3;
		this.cctOtsCurrCd4 = cctOtsCurrCd4;
		this.cctOtsCurrCd1 = cctOtsCurrCd1;
		this.cctOtsCurrCd2 = cctOtsCurrCd2;
		this.n3ptyCctRcvDt = n3ptyCctRcvDt;
		this.cctOtsCurrCd5 = cctOtsCurrCd5;
		this.pagerows = pagerows;
		this.cctRcvOfcCd = cctRcvOfcCd;
		this.n3ptyPptOtsCurrCd3 = n3ptyPptOtsCurrCd3;
		this.n3ptyPptOtsCurrCd4 = n3ptyPptOtsCurrCd4;
		this.n3ptyPptOtsCurrCd1 = n3ptyPptOtsCurrCd1;
		this.n3ptyPptOtsCurrCd2 = n3ptyPptOtsCurrCd2;
		this.cctRcvDt = cctRcvDt;
		this.n3ptyCctRcvOfcCd = n3ptyCctRcvOfcCd;
		this.n3ptyPptOtsCurrCd5 = n3ptyPptOtsCurrCd5;
		this.totOtsCurrCd1 = totOtsCurrCd1;
		this.totOtsCurrCd2 = totOtsCurrCd2;
		this.totOtsCurrCd3 = totOtsCurrCd3;
		this.totOtsCurrCd4 = totOtsCurrCd4;
		this.totOtsCurrCd5 = totOtsCurrCd5;
		this.n3ptyPptRcvDt = n3ptyPptRcvDt;
		this.n3ptyPptRcvUsrId = n3ptyPptRcvUsrId;
		this.n3ptyCctOtsAmt4 = n3ptyCctOtsAmt4;
		this.n3ptyCctOtsAmt5 = n3ptyCctOtsAmt5;
		this.pptRcvUsrId = pptRcvUsrId;
		this.n3ptyCctOtsAmt2 = n3ptyCctOtsAmt2;
		this.n3ptyCctOtsAmt3 = n3ptyCctOtsAmt3;
		this.n3ptyCctStsCd = n3ptyCctStsCd;
		this.n3ptyCctOtsAmt1 = n3ptyCctOtsAmt1;
		this.pptStsCd = pptStsCd;
		this.totOtsStsCd = totOtsStsCd;
		this.ibflag = ibflag;
		this.pptRcvDt = pptRcvDt;
		this.pptOtsCurrCd5 = pptOtsCurrCd5;
		this.eaiResult = eaiResult;
		this.totOtsAmt1 = totOtsAmt1;
		this.totOtsAmt2 = totOtsAmt2;
		this.pptOtsCurrCd3 = pptOtsCurrCd3;
		this.n3ptyPptOtsAmt5 = n3ptyPptOtsAmt5;
		this.pptOtsCurrCd4 = pptOtsCurrCd4;
		this.n3ptyPptOtsAmt4 = n3ptyPptOtsAmt4;
		this.pptOtsAmt1 = pptOtsAmt1;
		this.pptOtsCurrCd1 = pptOtsCurrCd1;
		this.n3ptyPptOtsAmt3 = n3ptyPptOtsAmt3;
		this.pptOtsCurrCd2 = pptOtsCurrCd2;
		this.n3ptyPptOtsAmt2 = n3ptyPptOtsAmt2;
		this.pptOtsAmt3 = pptOtsAmt3;
		this.n3ptyPptOtsAmt1 = n3ptyPptOtsAmt1;
		this.pptOtsAmt2 = pptOtsAmt2;
		this.pptOtsAmt5 = pptOtsAmt5;
		this.pptOtsAmt4 = pptOtsAmt4;
		this.cctStsCd = cctStsCd;
		this.n3ptyPptRcvOfcCd = n3ptyPptRcvOfcCd;
		this.n3ptyCctOtsCurrCd5 = n3ptyCctOtsCurrCd5;
		this.cctOtsAmt5 = cctOtsAmt5;
		this.n3ptyCctOtsCurrCd2 = n3ptyCctOtsCurrCd2;
		this.totOtsAmt5 = totOtsAmt5;
		this.cctOtsAmt4 = cctOtsAmt4;
		this.n3ptyCctOtsCurrCd1 = n3ptyCctOtsCurrCd1;
		this.totOtsAmt4 = totOtsAmt4;
		this.cctOtsAmt3 = cctOtsAmt3;
		this.n3ptyCctOtsCurrCd4 = n3ptyCctOtsCurrCd4;
		this.totOtsAmt3 = totOtsAmt3;
		this.cctOtsAmt2 = cctOtsAmt2;
		this.n3ptyCctOtsCurrCd3 = n3ptyCctOtsCurrCd3;
		this.cctOtsAmt1 = cctOtsAmt1;
		this.cctRcvUsrId = cctRcvUsrId;
		this.n3ptyCctRcvUsrId = n3ptyCctRcvUsrId;
		this.n3ptyPptStsCd = n3ptyPptStsCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ppt_rcv_ofc_cd", getPptRcvOfcCd());
		this.hashColumns.put("cct_ots_curr_cd3", getCctOtsCurrCd3());
		this.hashColumns.put("cct_ots_curr_cd4", getCctOtsCurrCd4());
		this.hashColumns.put("cct_ots_curr_cd1", getCctOtsCurrCd1());
		this.hashColumns.put("cct_ots_curr_cd2", getCctOtsCurrCd2());
		this.hashColumns.put("n3pty_cct_rcv_dt", getN3ptyCctRcvDt());
		this.hashColumns.put("cct_ots_curr_cd5", getCctOtsCurrCd5());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cct_rcv_ofc_cd", getCctRcvOfcCd());
		this.hashColumns.put("n3pty_ppt_ots_curr_cd3", getN3ptyPptOtsCurrCd3());
		this.hashColumns.put("n3pty_ppt_ots_curr_cd4", getN3ptyPptOtsCurrCd4());
		this.hashColumns.put("n3pty_ppt_ots_curr_cd1", getN3ptyPptOtsCurrCd1());
		this.hashColumns.put("n3pty_ppt_ots_curr_cd2", getN3ptyPptOtsCurrCd2());
		this.hashColumns.put("cct_rcv_dt", getCctRcvDt());
		this.hashColumns.put("n3pty_cct_rcv_ofc_cd", getN3ptyCctRcvOfcCd());
		this.hashColumns.put("n3pty_ppt_ots_curr_cd5", getN3ptyPptOtsCurrCd5());
		this.hashColumns.put("tot_ots_curr_cd1", getTotOtsCurrCd1());
		this.hashColumns.put("tot_ots_curr_cd2", getTotOtsCurrCd2());
		this.hashColumns.put("tot_ots_curr_cd3", getTotOtsCurrCd3());
		this.hashColumns.put("tot_ots_curr_cd4", getTotOtsCurrCd4());
		this.hashColumns.put("tot_ots_curr_cd5", getTotOtsCurrCd5());
		this.hashColumns.put("n3pty_ppt_rcv_dt", getN3ptyPptRcvDt());
		this.hashColumns.put("n3pty_ppt_rcv_usr_id", getN3ptyPptRcvUsrId());
		this.hashColumns.put("n3pty_cct_ots_amt4", getN3ptyCctOtsAmt4());
		this.hashColumns.put("n3pty_cct_ots_amt5", getN3ptyCctOtsAmt5());
		this.hashColumns.put("ppt_rcv_usr_id", getPptRcvUsrId());
		this.hashColumns.put("n3pty_cct_ots_amt2", getN3ptyCctOtsAmt2());
		this.hashColumns.put("n3pty_cct_ots_amt3", getN3ptyCctOtsAmt3());
		this.hashColumns.put("n3pty_cct_sts_cd", getN3ptyCctStsCd());
		this.hashColumns.put("n3pty_cct_ots_amt1", getN3ptyCctOtsAmt1());
		this.hashColumns.put("ppt_sts_cd", getPptStsCd());
		this.hashColumns.put("tot_ots_sts_cd", getTotOtsStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ppt_rcv_dt", getPptRcvDt());
		this.hashColumns.put("ppt_ots_curr_cd5", getPptOtsCurrCd5());
		this.hashColumns.put("eai_result", getEaiResult());
		this.hashColumns.put("tot_ots_amt1", getTotOtsAmt1());
		this.hashColumns.put("tot_ots_amt2", getTotOtsAmt2());
		this.hashColumns.put("ppt_ots_curr_cd3", getPptOtsCurrCd3());
		this.hashColumns.put("n3pty_ppt_ots_amt5", getN3ptyPptOtsAmt5());
		this.hashColumns.put("ppt_ots_curr_cd4", getPptOtsCurrCd4());
		this.hashColumns.put("n3pty_ppt_ots_amt4", getN3ptyPptOtsAmt4());
		this.hashColumns.put("ppt_ots_amt1", getPptOtsAmt1());
		this.hashColumns.put("ppt_ots_curr_cd1", getPptOtsCurrCd1());
		this.hashColumns.put("n3pty_ppt_ots_amt3", getN3ptyPptOtsAmt3());
		this.hashColumns.put("ppt_ots_curr_cd2", getPptOtsCurrCd2());
		this.hashColumns.put("n3pty_ppt_ots_amt2", getN3ptyPptOtsAmt2());
		this.hashColumns.put("ppt_ots_amt3", getPptOtsAmt3());
		this.hashColumns.put("n3pty_ppt_ots_amt1", getN3ptyPptOtsAmt1());
		this.hashColumns.put("ppt_ots_amt2", getPptOtsAmt2());
		this.hashColumns.put("ppt_ots_amt5", getPptOtsAmt5());
		this.hashColumns.put("ppt_ots_amt4", getPptOtsAmt4());
		this.hashColumns.put("cct_sts_cd", getCctStsCd());
		this.hashColumns.put("n3pty_ppt_rcv_ofc_cd", getN3ptyPptRcvOfcCd());
		this.hashColumns.put("n3pty_cct_ots_curr_cd5", getN3ptyCctOtsCurrCd5());
		this.hashColumns.put("cct_ots_amt5", getCctOtsAmt5());
		this.hashColumns.put("n3pty_cct_ots_curr_cd2", getN3ptyCctOtsCurrCd2());
		this.hashColumns.put("tot_ots_amt5", getTotOtsAmt5());
		this.hashColumns.put("cct_ots_amt4", getCctOtsAmt4());
		this.hashColumns.put("n3pty_cct_ots_curr_cd1", getN3ptyCctOtsCurrCd1());
		this.hashColumns.put("tot_ots_amt4", getTotOtsAmt4());
		this.hashColumns.put("cct_ots_amt3", getCctOtsAmt3());
		this.hashColumns.put("n3pty_cct_ots_curr_cd4", getN3ptyCctOtsCurrCd4());
		this.hashColumns.put("tot_ots_amt3", getTotOtsAmt3());
		this.hashColumns.put("cct_ots_amt2", getCctOtsAmt2());
		this.hashColumns.put("n3pty_cct_ots_curr_cd3", getN3ptyCctOtsCurrCd3());
		this.hashColumns.put("cct_ots_amt1", getCctOtsAmt1());
		this.hashColumns.put("cct_rcv_usr_id", getCctRcvUsrId());
		this.hashColumns.put("n3pty_cct_rcv_usr_id", getN3ptyCctRcvUsrId());
		this.hashColumns.put("n3pty_ppt_sts_cd", getN3ptyPptStsCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ppt_rcv_ofc_cd", "pptRcvOfcCd");
		this.hashFields.put("cct_ots_curr_cd3", "cctOtsCurrCd3");
		this.hashFields.put("cct_ots_curr_cd4", "cctOtsCurrCd4");
		this.hashFields.put("cct_ots_curr_cd1", "cctOtsCurrCd1");
		this.hashFields.put("cct_ots_curr_cd2", "cctOtsCurrCd2");
		this.hashFields.put("n3pty_cct_rcv_dt", "n3ptyCctRcvDt");
		this.hashFields.put("cct_ots_curr_cd5", "cctOtsCurrCd5");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cct_rcv_ofc_cd", "cctRcvOfcCd");
		this.hashFields.put("n3pty_ppt_ots_curr_cd3", "n3ptyPptOtsCurrCd3");
		this.hashFields.put("n3pty_ppt_ots_curr_cd4", "n3ptyPptOtsCurrCd4");
		this.hashFields.put("n3pty_ppt_ots_curr_cd1", "n3ptyPptOtsCurrCd1");
		this.hashFields.put("n3pty_ppt_ots_curr_cd2", "n3ptyPptOtsCurrCd2");
		this.hashFields.put("cct_rcv_dt", "cctRcvDt");
		this.hashFields.put("n3pty_cct_rcv_ofc_cd", "n3ptyCctRcvOfcCd");
		this.hashFields.put("n3pty_ppt_ots_curr_cd5", "n3ptyPptOtsCurrCd5");
		this.hashFields.put("tot_ots_curr_cd1", "totOtsCurrCd1");
		this.hashFields.put("tot_ots_curr_cd2", "totOtsCurrCd2");
		this.hashFields.put("tot_ots_curr_cd3", "totOtsCurrCd3");
		this.hashFields.put("tot_ots_curr_cd4", "totOtsCurrCd4");
		this.hashFields.put("tot_ots_curr_cd5", "totOtsCurrCd5");
		this.hashFields.put("n3pty_ppt_rcv_dt", "n3ptyPptRcvDt");
		this.hashFields.put("n3pty_ppt_rcv_usr_id", "n3ptyPptRcvUsrId");
		this.hashFields.put("n3pty_cct_ots_amt4", "n3ptyCctOtsAmt4");
		this.hashFields.put("n3pty_cct_ots_amt5", "n3ptyCctOtsAmt5");
		this.hashFields.put("ppt_rcv_usr_id", "pptRcvUsrId");
		this.hashFields.put("n3pty_cct_ots_amt2", "n3ptyCctOtsAmt2");
		this.hashFields.put("n3pty_cct_ots_amt3", "n3ptyCctOtsAmt3");
		this.hashFields.put("n3pty_cct_sts_cd", "n3ptyCctStsCd");
		this.hashFields.put("n3pty_cct_ots_amt1", "n3ptyCctOtsAmt1");
		this.hashFields.put("ppt_sts_cd", "pptStsCd");
		this.hashFields.put("tot_ots_sts_cd", "totOtsStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ppt_rcv_dt", "pptRcvDt");
		this.hashFields.put("ppt_ots_curr_cd5", "pptOtsCurrCd5");
		this.hashFields.put("eai_result", "eaiResult");
		this.hashFields.put("tot_ots_amt1", "totOtsAmt1");
		this.hashFields.put("tot_ots_amt2", "totOtsAmt2");
		this.hashFields.put("ppt_ots_curr_cd3", "pptOtsCurrCd3");
		this.hashFields.put("n3pty_ppt_ots_amt5", "n3ptyPptOtsAmt5");
		this.hashFields.put("ppt_ots_curr_cd4", "pptOtsCurrCd4");
		this.hashFields.put("n3pty_ppt_ots_amt4", "n3ptyPptOtsAmt4");
		this.hashFields.put("ppt_ots_amt1", "pptOtsAmt1");
		this.hashFields.put("ppt_ots_curr_cd1", "pptOtsCurrCd1");
		this.hashFields.put("n3pty_ppt_ots_amt3", "n3ptyPptOtsAmt3");
		this.hashFields.put("ppt_ots_curr_cd2", "pptOtsCurrCd2");
		this.hashFields.put("n3pty_ppt_ots_amt2", "n3ptyPptOtsAmt2");
		this.hashFields.put("ppt_ots_amt3", "pptOtsAmt3");
		this.hashFields.put("n3pty_ppt_ots_amt1", "n3ptyPptOtsAmt1");
		this.hashFields.put("ppt_ots_amt2", "pptOtsAmt2");
		this.hashFields.put("ppt_ots_amt5", "pptOtsAmt5");
		this.hashFields.put("ppt_ots_amt4", "pptOtsAmt4");
		this.hashFields.put("cct_sts_cd", "cctStsCd");
		this.hashFields.put("n3pty_ppt_rcv_ofc_cd", "n3ptyPptRcvOfcCd");
		this.hashFields.put("n3pty_cct_ots_curr_cd5", "n3ptyCctOtsCurrCd5");
		this.hashFields.put("cct_ots_amt5", "cctOtsAmt5");
		this.hashFields.put("n3pty_cct_ots_curr_cd2", "n3ptyCctOtsCurrCd2");
		this.hashFields.put("tot_ots_amt5", "totOtsAmt5");
		this.hashFields.put("cct_ots_amt4", "cctOtsAmt4");
		this.hashFields.put("n3pty_cct_ots_curr_cd1", "n3ptyCctOtsCurrCd1");
		this.hashFields.put("tot_ots_amt4", "totOtsAmt4");
		this.hashFields.put("cct_ots_amt3", "cctOtsAmt3");
		this.hashFields.put("n3pty_cct_ots_curr_cd4", "n3ptyCctOtsCurrCd4");
		this.hashFields.put("tot_ots_amt3", "totOtsAmt3");
		this.hashFields.put("cct_ots_amt2", "cctOtsAmt2");
		this.hashFields.put("n3pty_cct_ots_curr_cd3", "n3ptyCctOtsCurrCd3");
		this.hashFields.put("cct_ots_amt1", "cctOtsAmt1");
		this.hashFields.put("cct_rcv_usr_id", "cctRcvUsrId");
		this.hashFields.put("n3pty_cct_rcv_usr_id", "n3ptyCctRcvUsrId");
		this.hashFields.put("n3pty_ppt_sts_cd", "n3ptyPptStsCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pptRcvOfcCd
	 */
	public String getPptRcvOfcCd() {
		return this.pptRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cctOtsCurrCd3
	 */
	public String getCctOtsCurrCd3() {
		return this.cctOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @return cctOtsCurrCd4
	 */
	public String getCctOtsCurrCd4() {
		return this.cctOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @return cctOtsCurrCd1
	 */
	public String getCctOtsCurrCd1() {
		return this.cctOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @return cctOtsCurrCd2
	 */
	public String getCctOtsCurrCd2() {
		return this.cctOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctRcvDt
	 */
	public String getN3ptyCctRcvDt() {
		return this.n3ptyCctRcvDt;
	}
	
	/**
	 * Column Info
	 * @return cctOtsCurrCd5
	 */
	public String getCctOtsCurrCd5() {
		return this.cctOtsCurrCd5;
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
	 * @return cctRcvOfcCd
	 */
	public String getCctRcvOfcCd() {
		return this.cctRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsCurrCd3
	 */
	public String getN3ptyPptOtsCurrCd3() {
		return this.n3ptyPptOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsCurrCd4
	 */
	public String getN3ptyPptOtsCurrCd4() {
		return this.n3ptyPptOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsCurrCd1
	 */
	public String getN3ptyPptOtsCurrCd1() {
		return this.n3ptyPptOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsCurrCd2
	 */
	public String getN3ptyPptOtsCurrCd2() {
		return this.n3ptyPptOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @return cctRcvDt
	 */
	public String getCctRcvDt() {
		return this.cctRcvDt;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctRcvOfcCd
	 */
	public String getN3ptyCctRcvOfcCd() {
		return this.n3ptyCctRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsCurrCd5
	 */
	public String getN3ptyPptOtsCurrCd5() {
		return this.n3ptyPptOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @return totOtsCurrCd1
	 */
	public String getTotOtsCurrCd1() {
		return this.totOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @return totOtsCurrCd2
	 */
	public String getTotOtsCurrCd2() {
		return this.totOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @return totOtsCurrCd3
	 */
	public String getTotOtsCurrCd3() {
		return this.totOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @return totOtsCurrCd4
	 */
	public String getTotOtsCurrCd4() {
		return this.totOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @return totOtsCurrCd5
	 */
	public String getTotOtsCurrCd5() {
		return this.totOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptRcvDt
	 */
	public String getN3ptyPptRcvDt() {
		return this.n3ptyPptRcvDt;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptRcvUsrId
	 */
	public String getN3ptyPptRcvUsrId() {
		return this.n3ptyPptRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsAmt4
	 */
	public String getN3ptyCctOtsAmt4() {
		return this.n3ptyCctOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsAmt5
	 */
	public String getN3ptyCctOtsAmt5() {
		return this.n3ptyCctOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @return pptRcvUsrId
	 */
	public String getPptRcvUsrId() {
		return this.pptRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsAmt2
	 */
	public String getN3ptyCctOtsAmt2() {
		return this.n3ptyCctOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsAmt3
	 */
	public String getN3ptyCctOtsAmt3() {
		return this.n3ptyCctOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctStsCd
	 */
	public String getN3ptyCctStsCd() {
		return this.n3ptyCctStsCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsAmt1
	 */
	public String getN3ptyCctOtsAmt1() {
		return this.n3ptyCctOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @return pptStsCd
	 */
	public String getPptStsCd() {
		return this.pptStsCd;
	}
	
	/**
	 * Column Info
	 * @return totOtsStsCd
	 */
	public String getTotOtsStsCd() {
		return this.totOtsStsCd;
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
	 * @return pptRcvDt
	 */
	public String getPptRcvDt() {
		return this.pptRcvDt;
	}
	
	/**
	 * Column Info
	 * @return pptOtsCurrCd5
	 */
	public String getPptOtsCurrCd5() {
		return this.pptOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @return eaiResult
	 */
	public String getEaiResult() {
		return this.eaiResult;
	}
	
	/**
	 * Column Info
	 * @return totOtsAmt1
	 */
	public String getTotOtsAmt1() {
		return this.totOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @return totOtsAmt2
	 */
	public String getTotOtsAmt2() {
		return this.totOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @return pptOtsCurrCd3
	 */
	public String getPptOtsCurrCd3() {
		return this.pptOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsAmt5
	 */
	public String getN3ptyPptOtsAmt5() {
		return this.n3ptyPptOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @return pptOtsCurrCd4
	 */
	public String getPptOtsCurrCd4() {
		return this.pptOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsAmt4
	 */
	public String getN3ptyPptOtsAmt4() {
		return this.n3ptyPptOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @return pptOtsAmt1
	 */
	public String getPptOtsAmt1() {
		return this.pptOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @return pptOtsCurrCd1
	 */
	public String getPptOtsCurrCd1() {
		return this.pptOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsAmt3
	 */
	public String getN3ptyPptOtsAmt3() {
		return this.n3ptyPptOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @return pptOtsCurrCd2
	 */
	public String getPptOtsCurrCd2() {
		return this.pptOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsAmt2
	 */
	public String getN3ptyPptOtsAmt2() {
		return this.n3ptyPptOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @return pptOtsAmt3
	 */
	public String getPptOtsAmt3() {
		return this.pptOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptOtsAmt1
	 */
	public String getN3ptyPptOtsAmt1() {
		return this.n3ptyPptOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @return pptOtsAmt2
	 */
	public String getPptOtsAmt2() {
		return this.pptOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @return pptOtsAmt5
	 */
	public String getPptOtsAmt5() {
		return this.pptOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @return pptOtsAmt4
	 */
	public String getPptOtsAmt4() {
		return this.pptOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @return cctStsCd
	 */
	public String getCctStsCd() {
		return this.cctStsCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptRcvOfcCd
	 */
	public String getN3ptyPptRcvOfcCd() {
		return this.n3ptyPptRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsCurrCd5
	 */
	public String getN3ptyCctOtsCurrCd5() {
		return this.n3ptyCctOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @return cctOtsAmt5
	 */
	public String getCctOtsAmt5() {
		return this.cctOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsCurrCd2
	 */
	public String getN3ptyCctOtsCurrCd2() {
		return this.n3ptyCctOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @return totOtsAmt5
	 */
	public String getTotOtsAmt5() {
		return this.totOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @return cctOtsAmt4
	 */
	public String getCctOtsAmt4() {
		return this.cctOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsCurrCd1
	 */
	public String getN3ptyCctOtsCurrCd1() {
		return this.n3ptyCctOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @return totOtsAmt4
	 */
	public String getTotOtsAmt4() {
		return this.totOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @return cctOtsAmt3
	 */
	public String getCctOtsAmt3() {
		return this.cctOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsCurrCd4
	 */
	public String getN3ptyCctOtsCurrCd4() {
		return this.n3ptyCctOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @return totOtsAmt3
	 */
	public String getTotOtsAmt3() {
		return this.totOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @return cctOtsAmt2
	 */
	public String getCctOtsAmt2() {
		return this.cctOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctOtsCurrCd3
	 */
	public String getN3ptyCctOtsCurrCd3() {
		return this.n3ptyCctOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @return cctOtsAmt1
	 */
	public String getCctOtsAmt1() {
		return this.cctOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @return cctRcvUsrId
	 */
	public String getCctRcvUsrId() {
		return this.cctRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCctRcvUsrId
	 */
	public String getN3ptyCctRcvUsrId() {
		return this.n3ptyCctRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @return n3ptyPptStsCd
	 */
	public String getN3ptyPptStsCd() {
		return this.n3ptyPptStsCd;
	}
	

	/**
	 * Column Info
	 * @param pptRcvOfcCd
	 */
	public void setPptRcvOfcCd(String pptRcvOfcCd) {
		this.pptRcvOfcCd = pptRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cctOtsCurrCd3
	 */
	public void setCctOtsCurrCd3(String cctOtsCurrCd3) {
		this.cctOtsCurrCd3 = cctOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @param cctOtsCurrCd4
	 */
	public void setCctOtsCurrCd4(String cctOtsCurrCd4) {
		this.cctOtsCurrCd4 = cctOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @param cctOtsCurrCd1
	 */
	public void setCctOtsCurrCd1(String cctOtsCurrCd1) {
		this.cctOtsCurrCd1 = cctOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @param cctOtsCurrCd2
	 */
	public void setCctOtsCurrCd2(String cctOtsCurrCd2) {
		this.cctOtsCurrCd2 = cctOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctRcvDt
	 */
	public void setN3ptyCctRcvDt(String n3ptyCctRcvDt) {
		this.n3ptyCctRcvDt = n3ptyCctRcvDt;
	}
	
	/**
	 * Column Info
	 * @param cctOtsCurrCd5
	 */
	public void setCctOtsCurrCd5(String cctOtsCurrCd5) {
		this.cctOtsCurrCd5 = cctOtsCurrCd5;
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
	 * @param cctRcvOfcCd
	 */
	public void setCctRcvOfcCd(String cctRcvOfcCd) {
		this.cctRcvOfcCd = cctRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsCurrCd3
	 */
	public void setN3ptyPptOtsCurrCd3(String n3ptyPptOtsCurrCd3) {
		this.n3ptyPptOtsCurrCd3 = n3ptyPptOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsCurrCd4
	 */
	public void setN3ptyPptOtsCurrCd4(String n3ptyPptOtsCurrCd4) {
		this.n3ptyPptOtsCurrCd4 = n3ptyPptOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsCurrCd1
	 */
	public void setN3ptyPptOtsCurrCd1(String n3ptyPptOtsCurrCd1) {
		this.n3ptyPptOtsCurrCd1 = n3ptyPptOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsCurrCd2
	 */
	public void setN3ptyPptOtsCurrCd2(String n3ptyPptOtsCurrCd2) {
		this.n3ptyPptOtsCurrCd2 = n3ptyPptOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @param cctRcvDt
	 */
	public void setCctRcvDt(String cctRcvDt) {
		this.cctRcvDt = cctRcvDt;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctRcvOfcCd
	 */
	public void setN3ptyCctRcvOfcCd(String n3ptyCctRcvOfcCd) {
		this.n3ptyCctRcvOfcCd = n3ptyCctRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsCurrCd5
	 */
	public void setN3ptyPptOtsCurrCd5(String n3ptyPptOtsCurrCd5) {
		this.n3ptyPptOtsCurrCd5 = n3ptyPptOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @param totOtsCurrCd1
	 */
	public void setTotOtsCurrCd1(String totOtsCurrCd1) {
		this.totOtsCurrCd1 = totOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @param totOtsCurrCd2
	 */
	public void setTotOtsCurrCd2(String totOtsCurrCd2) {
		this.totOtsCurrCd2 = totOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @param totOtsCurrCd3
	 */
	public void setTotOtsCurrCd3(String totOtsCurrCd3) {
		this.totOtsCurrCd3 = totOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @param totOtsCurrCd4
	 */
	public void setTotOtsCurrCd4(String totOtsCurrCd4) {
		this.totOtsCurrCd4 = totOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @param totOtsCurrCd5
	 */
	public void setTotOtsCurrCd5(String totOtsCurrCd5) {
		this.totOtsCurrCd5 = totOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptRcvDt
	 */
	public void setN3ptyPptRcvDt(String n3ptyPptRcvDt) {
		this.n3ptyPptRcvDt = n3ptyPptRcvDt;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptRcvUsrId
	 */
	public void setN3ptyPptRcvUsrId(String n3ptyPptRcvUsrId) {
		this.n3ptyPptRcvUsrId = n3ptyPptRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsAmt4
	 */
	public void setN3ptyCctOtsAmt4(String n3ptyCctOtsAmt4) {
		this.n3ptyCctOtsAmt4 = n3ptyCctOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsAmt5
	 */
	public void setN3ptyCctOtsAmt5(String n3ptyCctOtsAmt5) {
		this.n3ptyCctOtsAmt5 = n3ptyCctOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @param pptRcvUsrId
	 */
	public void setPptRcvUsrId(String pptRcvUsrId) {
		this.pptRcvUsrId = pptRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsAmt2
	 */
	public void setN3ptyCctOtsAmt2(String n3ptyCctOtsAmt2) {
		this.n3ptyCctOtsAmt2 = n3ptyCctOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsAmt3
	 */
	public void setN3ptyCctOtsAmt3(String n3ptyCctOtsAmt3) {
		this.n3ptyCctOtsAmt3 = n3ptyCctOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctStsCd
	 */
	public void setN3ptyCctStsCd(String n3ptyCctStsCd) {
		this.n3ptyCctStsCd = n3ptyCctStsCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsAmt1
	 */
	public void setN3ptyCctOtsAmt1(String n3ptyCctOtsAmt1) {
		this.n3ptyCctOtsAmt1 = n3ptyCctOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @param pptStsCd
	 */
	public void setPptStsCd(String pptStsCd) {
		this.pptStsCd = pptStsCd;
	}
	
	/**
	 * Column Info
	 * @param totOtsStsCd
	 */
	public void setTotOtsStsCd(String totOtsStsCd) {
		this.totOtsStsCd = totOtsStsCd;
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
	 * @param pptRcvDt
	 */
	public void setPptRcvDt(String pptRcvDt) {
		this.pptRcvDt = pptRcvDt;
	}
	
	/**
	 * Column Info
	 * @param pptOtsCurrCd5
	 */
	public void setPptOtsCurrCd5(String pptOtsCurrCd5) {
		this.pptOtsCurrCd5 = pptOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @param eaiResult
	 */
	public void setEaiResult(String eaiResult) {
		this.eaiResult = eaiResult;
	}
	
	/**
	 * Column Info
	 * @param totOtsAmt1
	 */
	public void setTotOtsAmt1(String totOtsAmt1) {
		this.totOtsAmt1 = totOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @param totOtsAmt2
	 */
	public void setTotOtsAmt2(String totOtsAmt2) {
		this.totOtsAmt2 = totOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @param pptOtsCurrCd3
	 */
	public void setPptOtsCurrCd3(String pptOtsCurrCd3) {
		this.pptOtsCurrCd3 = pptOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsAmt5
	 */
	public void setN3ptyPptOtsAmt5(String n3ptyPptOtsAmt5) {
		this.n3ptyPptOtsAmt5 = n3ptyPptOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @param pptOtsCurrCd4
	 */
	public void setPptOtsCurrCd4(String pptOtsCurrCd4) {
		this.pptOtsCurrCd4 = pptOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsAmt4
	 */
	public void setN3ptyPptOtsAmt4(String n3ptyPptOtsAmt4) {
		this.n3ptyPptOtsAmt4 = n3ptyPptOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @param pptOtsAmt1
	 */
	public void setPptOtsAmt1(String pptOtsAmt1) {
		this.pptOtsAmt1 = pptOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @param pptOtsCurrCd1
	 */
	public void setPptOtsCurrCd1(String pptOtsCurrCd1) {
		this.pptOtsCurrCd1 = pptOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsAmt3
	 */
	public void setN3ptyPptOtsAmt3(String n3ptyPptOtsAmt3) {
		this.n3ptyPptOtsAmt3 = n3ptyPptOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @param pptOtsCurrCd2
	 */
	public void setPptOtsCurrCd2(String pptOtsCurrCd2) {
		this.pptOtsCurrCd2 = pptOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsAmt2
	 */
	public void setN3ptyPptOtsAmt2(String n3ptyPptOtsAmt2) {
		this.n3ptyPptOtsAmt2 = n3ptyPptOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @param pptOtsAmt3
	 */
	public void setPptOtsAmt3(String pptOtsAmt3) {
		this.pptOtsAmt3 = pptOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptOtsAmt1
	 */
	public void setN3ptyPptOtsAmt1(String n3ptyPptOtsAmt1) {
		this.n3ptyPptOtsAmt1 = n3ptyPptOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @param pptOtsAmt2
	 */
	public void setPptOtsAmt2(String pptOtsAmt2) {
		this.pptOtsAmt2 = pptOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @param pptOtsAmt5
	 */
	public void setPptOtsAmt5(String pptOtsAmt5) {
		this.pptOtsAmt5 = pptOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @param pptOtsAmt4
	 */
	public void setPptOtsAmt4(String pptOtsAmt4) {
		this.pptOtsAmt4 = pptOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @param cctStsCd
	 */
	public void setCctStsCd(String cctStsCd) {
		this.cctStsCd = cctStsCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptRcvOfcCd
	 */
	public void setN3ptyPptRcvOfcCd(String n3ptyPptRcvOfcCd) {
		this.n3ptyPptRcvOfcCd = n3ptyPptRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsCurrCd5
	 */
	public void setN3ptyCctOtsCurrCd5(String n3ptyCctOtsCurrCd5) {
		this.n3ptyCctOtsCurrCd5 = n3ptyCctOtsCurrCd5;
	}
	
	/**
	 * Column Info
	 * @param cctOtsAmt5
	 */
	public void setCctOtsAmt5(String cctOtsAmt5) {
		this.cctOtsAmt5 = cctOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsCurrCd2
	 */
	public void setN3ptyCctOtsCurrCd2(String n3ptyCctOtsCurrCd2) {
		this.n3ptyCctOtsCurrCd2 = n3ptyCctOtsCurrCd2;
	}
	
	/**
	 * Column Info
	 * @param totOtsAmt5
	 */
	public void setTotOtsAmt5(String totOtsAmt5) {
		this.totOtsAmt5 = totOtsAmt5;
	}
	
	/**
	 * Column Info
	 * @param cctOtsAmt4
	 */
	public void setCctOtsAmt4(String cctOtsAmt4) {
		this.cctOtsAmt4 = cctOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsCurrCd1
	 */
	public void setN3ptyCctOtsCurrCd1(String n3ptyCctOtsCurrCd1) {
		this.n3ptyCctOtsCurrCd1 = n3ptyCctOtsCurrCd1;
	}
	
	/**
	 * Column Info
	 * @param totOtsAmt4
	 */
	public void setTotOtsAmt4(String totOtsAmt4) {
		this.totOtsAmt4 = totOtsAmt4;
	}
	
	/**
	 * Column Info
	 * @param cctOtsAmt3
	 */
	public void setCctOtsAmt3(String cctOtsAmt3) {
		this.cctOtsAmt3 = cctOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsCurrCd4
	 */
	public void setN3ptyCctOtsCurrCd4(String n3ptyCctOtsCurrCd4) {
		this.n3ptyCctOtsCurrCd4 = n3ptyCctOtsCurrCd4;
	}
	
	/**
	 * Column Info
	 * @param totOtsAmt3
	 */
	public void setTotOtsAmt3(String totOtsAmt3) {
		this.totOtsAmt3 = totOtsAmt3;
	}
	
	/**
	 * Column Info
	 * @param cctOtsAmt2
	 */
	public void setCctOtsAmt2(String cctOtsAmt2) {
		this.cctOtsAmt2 = cctOtsAmt2;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctOtsCurrCd3
	 */
	public void setN3ptyCctOtsCurrCd3(String n3ptyCctOtsCurrCd3) {
		this.n3ptyCctOtsCurrCd3 = n3ptyCctOtsCurrCd3;
	}
	
	/**
	 * Column Info
	 * @param cctOtsAmt1
	 */
	public void setCctOtsAmt1(String cctOtsAmt1) {
		this.cctOtsAmt1 = cctOtsAmt1;
	}
	
	/**
	 * Column Info
	 * @param cctRcvUsrId
	 */
	public void setCctRcvUsrId(String cctRcvUsrId) {
		this.cctRcvUsrId = cctRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCctRcvUsrId
	 */
	public void setN3ptyCctRcvUsrId(String n3ptyCctRcvUsrId) {
		this.n3ptyCctRcvUsrId = n3ptyCctRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @param n3ptyPptStsCd
	 */
	public void setN3ptyPptStsCd(String n3ptyPptStsCd) {
		this.n3ptyPptStsCd = n3ptyPptStsCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPptRcvOfcCd(JSPUtil.getParameter(request, "ppt_rcv_ofc_cd", ""));
		setCctOtsCurrCd3(JSPUtil.getParameter(request, "cct_ots_curr_cd3", ""));
		setCctOtsCurrCd4(JSPUtil.getParameter(request, "cct_ots_curr_cd4", ""));
		setCctOtsCurrCd1(JSPUtil.getParameter(request, "cct_ots_curr_cd1", ""));
		setCctOtsCurrCd2(JSPUtil.getParameter(request, "cct_ots_curr_cd2", ""));
		setN3ptyCctRcvDt(JSPUtil.getParameter(request, "n3pty_cct_rcv_dt", ""));
		setCctOtsCurrCd5(JSPUtil.getParameter(request, "cct_ots_curr_cd5", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCctRcvOfcCd(JSPUtil.getParameter(request, "cct_rcv_ofc_cd", ""));
		setN3ptyPptOtsCurrCd3(JSPUtil.getParameter(request, "n3pty_ppt_ots_curr_cd3", ""));
		setN3ptyPptOtsCurrCd4(JSPUtil.getParameter(request, "n3pty_ppt_ots_curr_cd4", ""));
		setN3ptyPptOtsCurrCd1(JSPUtil.getParameter(request, "n3pty_ppt_ots_curr_cd1", ""));
		setN3ptyPptOtsCurrCd2(JSPUtil.getParameter(request, "n3pty_ppt_ots_curr_cd2", ""));
		setCctRcvDt(JSPUtil.getParameter(request, "cct_rcv_dt", ""));
		setN3ptyCctRcvOfcCd(JSPUtil.getParameter(request, "n3pty_cct_rcv_ofc_cd", ""));
		setN3ptyPptOtsCurrCd5(JSPUtil.getParameter(request, "n3pty_ppt_ots_curr_cd5", ""));
		setTotOtsCurrCd1(JSPUtil.getParameter(request, "tot_ots_curr_cd1", ""));
		setTotOtsCurrCd2(JSPUtil.getParameter(request, "tot_ots_curr_cd2", ""));
		setTotOtsCurrCd3(JSPUtil.getParameter(request, "tot_ots_curr_cd3", ""));
		setTotOtsCurrCd4(JSPUtil.getParameter(request, "tot_ots_curr_cd4", ""));
		setTotOtsCurrCd5(JSPUtil.getParameter(request, "tot_ots_curr_cd5", ""));
		setN3ptyPptRcvDt(JSPUtil.getParameter(request, "n3pty_ppt_rcv_dt", ""));
		setN3ptyPptRcvUsrId(JSPUtil.getParameter(request, "n3pty_ppt_rcv_usr_id", ""));
		setN3ptyCctOtsAmt4(JSPUtil.getParameter(request, "n3pty_cct_ots_amt4", ""));
		setN3ptyCctOtsAmt5(JSPUtil.getParameter(request, "n3pty_cct_ots_amt5", ""));
		setPptRcvUsrId(JSPUtil.getParameter(request, "ppt_rcv_usr_id", ""));
		setN3ptyCctOtsAmt2(JSPUtil.getParameter(request, "n3pty_cct_ots_amt2", ""));
		setN3ptyCctOtsAmt3(JSPUtil.getParameter(request, "n3pty_cct_ots_amt3", ""));
		setN3ptyCctStsCd(JSPUtil.getParameter(request, "n3pty_cct_sts_cd", ""));
		setN3ptyCctOtsAmt1(JSPUtil.getParameter(request, "n3pty_cct_ots_amt1", ""));
		setPptStsCd(JSPUtil.getParameter(request, "ppt_sts_cd", ""));
		setTotOtsStsCd(JSPUtil.getParameter(request, "tot_ots_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPptRcvDt(JSPUtil.getParameter(request, "ppt_rcv_dt", ""));
		setPptOtsCurrCd5(JSPUtil.getParameter(request, "ppt_ots_curr_cd5", ""));
		setEaiResult(JSPUtil.getParameter(request, "eai_result", ""));
		setTotOtsAmt1(JSPUtil.getParameter(request, "tot_ots_amt1", ""));
		setTotOtsAmt2(JSPUtil.getParameter(request, "tot_ots_amt2", ""));
		setPptOtsCurrCd3(JSPUtil.getParameter(request, "ppt_ots_curr_cd3", ""));
		setN3ptyPptOtsAmt5(JSPUtil.getParameter(request, "n3pty_ppt_ots_amt5", ""));
		setPptOtsCurrCd4(JSPUtil.getParameter(request, "ppt_ots_curr_cd4", ""));
		setN3ptyPptOtsAmt4(JSPUtil.getParameter(request, "n3pty_ppt_ots_amt4", ""));
		setPptOtsAmt1(JSPUtil.getParameter(request, "ppt_ots_amt1", ""));
		setPptOtsCurrCd1(JSPUtil.getParameter(request, "ppt_ots_curr_cd1", ""));
		setN3ptyPptOtsAmt3(JSPUtil.getParameter(request, "n3pty_ppt_ots_amt3", ""));
		setPptOtsCurrCd2(JSPUtil.getParameter(request, "ppt_ots_curr_cd2", ""));
		setN3ptyPptOtsAmt2(JSPUtil.getParameter(request, "n3pty_ppt_ots_amt2", ""));
		setPptOtsAmt3(JSPUtil.getParameter(request, "ppt_ots_amt3", ""));
		setN3ptyPptOtsAmt1(JSPUtil.getParameter(request, "n3pty_ppt_ots_amt1", ""));
		setPptOtsAmt2(JSPUtil.getParameter(request, "ppt_ots_amt2", ""));
		setPptOtsAmt5(JSPUtil.getParameter(request, "ppt_ots_amt5", ""));
		setPptOtsAmt4(JSPUtil.getParameter(request, "ppt_ots_amt4", ""));
		setCctStsCd(JSPUtil.getParameter(request, "cct_sts_cd", ""));
		setN3ptyPptRcvOfcCd(JSPUtil.getParameter(request, "n3pty_ppt_rcv_ofc_cd", ""));
		setN3ptyCctOtsCurrCd5(JSPUtil.getParameter(request, "n3pty_cct_ots_curr_cd5", ""));
		setCctOtsAmt5(JSPUtil.getParameter(request, "cct_ots_amt5", ""));
		setN3ptyCctOtsCurrCd2(JSPUtil.getParameter(request, "n3pty_cct_ots_curr_cd2", ""));
		setTotOtsAmt5(JSPUtil.getParameter(request, "tot_ots_amt5", ""));
		setCctOtsAmt4(JSPUtil.getParameter(request, "cct_ots_amt4", ""));
		setN3ptyCctOtsCurrCd1(JSPUtil.getParameter(request, "n3pty_cct_ots_curr_cd1", ""));
		setTotOtsAmt4(JSPUtil.getParameter(request, "tot_ots_amt4", ""));
		setCctOtsAmt3(JSPUtil.getParameter(request, "cct_ots_amt3", ""));
		setN3ptyCctOtsCurrCd4(JSPUtil.getParameter(request, "n3pty_cct_ots_curr_cd4", ""));
		setTotOtsAmt3(JSPUtil.getParameter(request, "tot_ots_amt3", ""));
		setCctOtsAmt2(JSPUtil.getParameter(request, "cct_ots_amt2", ""));
		setN3ptyCctOtsCurrCd3(JSPUtil.getParameter(request, "n3pty_cct_ots_curr_cd3", ""));
		setCctOtsAmt1(JSPUtil.getParameter(request, "cct_ots_amt1", ""));
		setCctRcvUsrId(JSPUtil.getParameter(request, "cct_rcv_usr_id", ""));
		setN3ptyCctRcvUsrId(JSPUtil.getParameter(request, "n3pty_cct_rcv_usr_id", ""));
		setN3ptyPptStsCd(JSPUtil.getParameter(request, "n3pty_ppt_sts_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OtsRcvInfoVO[]
	 */
	public OtsRcvInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OtsRcvInfoVO[]
	 */
	public OtsRcvInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OtsRcvInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pptRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "ppt_rcv_ofc_cd", length));
			String[] cctOtsCurrCd3 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_curr_cd3", length));
			String[] cctOtsCurrCd4 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_curr_cd4", length));
			String[] cctOtsCurrCd1 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_curr_cd1", length));
			String[] cctOtsCurrCd2 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_curr_cd2", length));
			String[] n3ptyCctRcvDt = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_rcv_dt", length));
			String[] cctOtsCurrCd5 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_curr_cd5", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cctRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "cct_rcv_ofc_cd", length));
			String[] n3ptyPptOtsCurrCd3 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_curr_cd3", length));
			String[] n3ptyPptOtsCurrCd4 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_curr_cd4", length));
			String[] n3ptyPptOtsCurrCd1 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_curr_cd1", length));
			String[] n3ptyPptOtsCurrCd2 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_curr_cd2", length));
			String[] cctRcvDt = (JSPUtil.getParameter(request, prefix	+ "cct_rcv_dt", length));
			String[] n3ptyCctRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_rcv_ofc_cd", length));
			String[] n3ptyPptOtsCurrCd5 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_curr_cd5", length));
			String[] totOtsCurrCd1 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_curr_cd1", length));
			String[] totOtsCurrCd2 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_curr_cd2", length));
			String[] totOtsCurrCd3 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_curr_cd3", length));
			String[] totOtsCurrCd4 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_curr_cd4", length));
			String[] totOtsCurrCd5 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_curr_cd5", length));
			String[] n3ptyPptRcvDt = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_rcv_dt", length));
			String[] n3ptyPptRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_rcv_usr_id", length));
			String[] n3ptyCctOtsAmt4 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_amt4", length));
			String[] n3ptyCctOtsAmt5 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_amt5", length));
			String[] pptRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "ppt_rcv_usr_id", length));
			String[] n3ptyCctOtsAmt2 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_amt2", length));
			String[] n3ptyCctOtsAmt3 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_amt3", length));
			String[] n3ptyCctStsCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_sts_cd", length));
			String[] n3ptyCctOtsAmt1 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_amt1", length));
			String[] pptStsCd = (JSPUtil.getParameter(request, prefix	+ "ppt_sts_cd", length));
			String[] totOtsStsCd = (JSPUtil.getParameter(request, prefix	+ "tot_ots_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pptRcvDt = (JSPUtil.getParameter(request, prefix	+ "ppt_rcv_dt", length));
			String[] pptOtsCurrCd5 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_curr_cd5", length));
			String[] eaiResult = (JSPUtil.getParameter(request, prefix	+ "eai_result", length));
			String[] totOtsAmt1 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_amt1", length));
			String[] totOtsAmt2 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_amt2", length));
			String[] pptOtsCurrCd3 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_curr_cd3", length));
			String[] n3ptyPptOtsAmt5 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_amt5", length));
			String[] pptOtsCurrCd4 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_curr_cd4", length));
			String[] n3ptyPptOtsAmt4 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_amt4", length));
			String[] pptOtsAmt1 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_amt1", length));
			String[] pptOtsCurrCd1 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_curr_cd1", length));
			String[] n3ptyPptOtsAmt3 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_amt3", length));
			String[] pptOtsCurrCd2 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_curr_cd2", length));
			String[] n3ptyPptOtsAmt2 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_amt2", length));
			String[] pptOtsAmt3 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_amt3", length));
			String[] n3ptyPptOtsAmt1 = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_ots_amt1", length));
			String[] pptOtsAmt2 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_amt2", length));
			String[] pptOtsAmt5 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_amt5", length));
			String[] pptOtsAmt4 = (JSPUtil.getParameter(request, prefix	+ "ppt_ots_amt4", length));
			String[] cctStsCd = (JSPUtil.getParameter(request, prefix	+ "cct_sts_cd", length));
			String[] n3ptyPptRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_rcv_ofc_cd", length));
			String[] n3ptyCctOtsCurrCd5 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_curr_cd5", length));
			String[] cctOtsAmt5 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_amt5", length));
			String[] n3ptyCctOtsCurrCd2 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_curr_cd2", length));
			String[] totOtsAmt5 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_amt5", length));
			String[] cctOtsAmt4 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_amt4", length));
			String[] n3ptyCctOtsCurrCd1 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_curr_cd1", length));
			String[] totOtsAmt4 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_amt4", length));
			String[] cctOtsAmt3 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_amt3", length));
			String[] n3ptyCctOtsCurrCd4 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_curr_cd4", length));
			String[] totOtsAmt3 = (JSPUtil.getParameter(request, prefix	+ "tot_ots_amt3", length));
			String[] cctOtsAmt2 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_amt2", length));
			String[] n3ptyCctOtsCurrCd3 = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_ots_curr_cd3", length));
			String[] cctOtsAmt1 = (JSPUtil.getParameter(request, prefix	+ "cct_ots_amt1", length));
			String[] cctRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "cct_rcv_usr_id", length));
			String[] n3ptyCctRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "n3pty_cct_rcv_usr_id", length));
			String[] n3ptyPptStsCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ppt_sts_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new OtsRcvInfoVO();
				if (pptRcvOfcCd[i] != null)
					model.setPptRcvOfcCd(pptRcvOfcCd[i]);
				if (cctOtsCurrCd3[i] != null)
					model.setCctOtsCurrCd3(cctOtsCurrCd3[i]);
				if (cctOtsCurrCd4[i] != null)
					model.setCctOtsCurrCd4(cctOtsCurrCd4[i]);
				if (cctOtsCurrCd1[i] != null)
					model.setCctOtsCurrCd1(cctOtsCurrCd1[i]);
				if (cctOtsCurrCd2[i] != null)
					model.setCctOtsCurrCd2(cctOtsCurrCd2[i]);
				if (n3ptyCctRcvDt[i] != null)
					model.setN3ptyCctRcvDt(n3ptyCctRcvDt[i]);
				if (cctOtsCurrCd5[i] != null)
					model.setCctOtsCurrCd5(cctOtsCurrCd5[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cctRcvOfcCd[i] != null)
					model.setCctRcvOfcCd(cctRcvOfcCd[i]);
				if (n3ptyPptOtsCurrCd3[i] != null)
					model.setN3ptyPptOtsCurrCd3(n3ptyPptOtsCurrCd3[i]);
				if (n3ptyPptOtsCurrCd4[i] != null)
					model.setN3ptyPptOtsCurrCd4(n3ptyPptOtsCurrCd4[i]);
				if (n3ptyPptOtsCurrCd1[i] != null)
					model.setN3ptyPptOtsCurrCd1(n3ptyPptOtsCurrCd1[i]);
				if (n3ptyPptOtsCurrCd2[i] != null)
					model.setN3ptyPptOtsCurrCd2(n3ptyPptOtsCurrCd2[i]);
				if (cctRcvDt[i] != null)
					model.setCctRcvDt(cctRcvDt[i]);
				if (n3ptyCctRcvOfcCd[i] != null)
					model.setN3ptyCctRcvOfcCd(n3ptyCctRcvOfcCd[i]);
				if (n3ptyPptOtsCurrCd5[i] != null)
					model.setN3ptyPptOtsCurrCd5(n3ptyPptOtsCurrCd5[i]);
				if (totOtsCurrCd1[i] != null)
					model.setTotOtsCurrCd1(totOtsCurrCd1[i]);
				if (totOtsCurrCd2[i] != null)
					model.setTotOtsCurrCd2(totOtsCurrCd2[i]);
				if (totOtsCurrCd3[i] != null)
					model.setTotOtsCurrCd3(totOtsCurrCd3[i]);
				if (totOtsCurrCd4[i] != null)
					model.setTotOtsCurrCd4(totOtsCurrCd4[i]);
				if (totOtsCurrCd5[i] != null)
					model.setTotOtsCurrCd5(totOtsCurrCd5[i]);
				if (n3ptyPptRcvDt[i] != null)
					model.setN3ptyPptRcvDt(n3ptyPptRcvDt[i]);
				if (n3ptyPptRcvUsrId[i] != null)
					model.setN3ptyPptRcvUsrId(n3ptyPptRcvUsrId[i]);
				if (n3ptyCctOtsAmt4[i] != null)
					model.setN3ptyCctOtsAmt4(n3ptyCctOtsAmt4[i]);
				if (n3ptyCctOtsAmt5[i] != null)
					model.setN3ptyCctOtsAmt5(n3ptyCctOtsAmt5[i]);
				if (pptRcvUsrId[i] != null)
					model.setPptRcvUsrId(pptRcvUsrId[i]);
				if (n3ptyCctOtsAmt2[i] != null)
					model.setN3ptyCctOtsAmt2(n3ptyCctOtsAmt2[i]);
				if (n3ptyCctOtsAmt3[i] != null)
					model.setN3ptyCctOtsAmt3(n3ptyCctOtsAmt3[i]);
				if (n3ptyCctStsCd[i] != null)
					model.setN3ptyCctStsCd(n3ptyCctStsCd[i]);
				if (n3ptyCctOtsAmt1[i] != null)
					model.setN3ptyCctOtsAmt1(n3ptyCctOtsAmt1[i]);
				if (pptStsCd[i] != null)
					model.setPptStsCd(pptStsCd[i]);
				if (totOtsStsCd[i] != null)
					model.setTotOtsStsCd(totOtsStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pptRcvDt[i] != null)
					model.setPptRcvDt(pptRcvDt[i]);
				if (pptOtsCurrCd5[i] != null)
					model.setPptOtsCurrCd5(pptOtsCurrCd5[i]);
				if (eaiResult[i] != null)
					model.setEaiResult(eaiResult[i]);
				if (totOtsAmt1[i] != null)
					model.setTotOtsAmt1(totOtsAmt1[i]);
				if (totOtsAmt2[i] != null)
					model.setTotOtsAmt2(totOtsAmt2[i]);
				if (pptOtsCurrCd3[i] != null)
					model.setPptOtsCurrCd3(pptOtsCurrCd3[i]);
				if (n3ptyPptOtsAmt5[i] != null)
					model.setN3ptyPptOtsAmt5(n3ptyPptOtsAmt5[i]);
				if (pptOtsCurrCd4[i] != null)
					model.setPptOtsCurrCd4(pptOtsCurrCd4[i]);
				if (n3ptyPptOtsAmt4[i] != null)
					model.setN3ptyPptOtsAmt4(n3ptyPptOtsAmt4[i]);
				if (pptOtsAmt1[i] != null)
					model.setPptOtsAmt1(pptOtsAmt1[i]);
				if (pptOtsCurrCd1[i] != null)
					model.setPptOtsCurrCd1(pptOtsCurrCd1[i]);
				if (n3ptyPptOtsAmt3[i] != null)
					model.setN3ptyPptOtsAmt3(n3ptyPptOtsAmt3[i]);
				if (pptOtsCurrCd2[i] != null)
					model.setPptOtsCurrCd2(pptOtsCurrCd2[i]);
				if (n3ptyPptOtsAmt2[i] != null)
					model.setN3ptyPptOtsAmt2(n3ptyPptOtsAmt2[i]);
				if (pptOtsAmt3[i] != null)
					model.setPptOtsAmt3(pptOtsAmt3[i]);
				if (n3ptyPptOtsAmt1[i] != null)
					model.setN3ptyPptOtsAmt1(n3ptyPptOtsAmt1[i]);
				if (pptOtsAmt2[i] != null)
					model.setPptOtsAmt2(pptOtsAmt2[i]);
				if (pptOtsAmt5[i] != null)
					model.setPptOtsAmt5(pptOtsAmt5[i]);
				if (pptOtsAmt4[i] != null)
					model.setPptOtsAmt4(pptOtsAmt4[i]);
				if (cctStsCd[i] != null)
					model.setCctStsCd(cctStsCd[i]);
				if (n3ptyPptRcvOfcCd[i] != null)
					model.setN3ptyPptRcvOfcCd(n3ptyPptRcvOfcCd[i]);
				if (n3ptyCctOtsCurrCd5[i] != null)
					model.setN3ptyCctOtsCurrCd5(n3ptyCctOtsCurrCd5[i]);
				if (cctOtsAmt5[i] != null)
					model.setCctOtsAmt5(cctOtsAmt5[i]);
				if (n3ptyCctOtsCurrCd2[i] != null)
					model.setN3ptyCctOtsCurrCd2(n3ptyCctOtsCurrCd2[i]);
				if (totOtsAmt5[i] != null)
					model.setTotOtsAmt5(totOtsAmt5[i]);
				if (cctOtsAmt4[i] != null)
					model.setCctOtsAmt4(cctOtsAmt4[i]);
				if (n3ptyCctOtsCurrCd1[i] != null)
					model.setN3ptyCctOtsCurrCd1(n3ptyCctOtsCurrCd1[i]);
				if (totOtsAmt4[i] != null)
					model.setTotOtsAmt4(totOtsAmt4[i]);
				if (cctOtsAmt3[i] != null)
					model.setCctOtsAmt3(cctOtsAmt3[i]);
				if (n3ptyCctOtsCurrCd4[i] != null)
					model.setN3ptyCctOtsCurrCd4(n3ptyCctOtsCurrCd4[i]);
				if (totOtsAmt3[i] != null)
					model.setTotOtsAmt3(totOtsAmt3[i]);
				if (cctOtsAmt2[i] != null)
					model.setCctOtsAmt2(cctOtsAmt2[i]);
				if (n3ptyCctOtsCurrCd3[i] != null)
					model.setN3ptyCctOtsCurrCd3(n3ptyCctOtsCurrCd3[i]);
				if (cctOtsAmt1[i] != null)
					model.setCctOtsAmt1(cctOtsAmt1[i]);
				if (cctRcvUsrId[i] != null)
					model.setCctRcvUsrId(cctRcvUsrId[i]);
				if (n3ptyCctRcvUsrId[i] != null)
					model.setN3ptyCctRcvUsrId(n3ptyCctRcvUsrId[i]);
				if (n3ptyPptStsCd[i] != null)
					model.setN3ptyPptStsCd(n3ptyPptStsCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOtsRcvInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OtsRcvInfoVO[]
	 */
	public OtsRcvInfoVO[] getOtsRcvInfoVOs(){
		OtsRcvInfoVO[] vos = (OtsRcvInfoVO[])models.toArray(new OtsRcvInfoVO[models.size()]);
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
		this.pptRcvOfcCd = this.pptRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsCurrCd3 = this.cctOtsCurrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsCurrCd4 = this.cctOtsCurrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsCurrCd1 = this.cctOtsCurrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsCurrCd2 = this.cctOtsCurrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctRcvDt = this.n3ptyCctRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsCurrCd5 = this.cctOtsCurrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctRcvOfcCd = this.cctRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsCurrCd3 = this.n3ptyPptOtsCurrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsCurrCd4 = this.n3ptyPptOtsCurrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsCurrCd1 = this.n3ptyPptOtsCurrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsCurrCd2 = this.n3ptyPptOtsCurrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctRcvDt = this.cctRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctRcvOfcCd = this.n3ptyCctRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsCurrCd5 = this.n3ptyPptOtsCurrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsCurrCd1 = this.totOtsCurrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsCurrCd2 = this.totOtsCurrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsCurrCd3 = this.totOtsCurrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsCurrCd4 = this.totOtsCurrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsCurrCd5 = this.totOtsCurrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptRcvDt = this.n3ptyPptRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptRcvUsrId = this.n3ptyPptRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsAmt4 = this.n3ptyCctOtsAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsAmt5 = this.n3ptyCctOtsAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptRcvUsrId = this.pptRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsAmt2 = this.n3ptyCctOtsAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsAmt3 = this.n3ptyCctOtsAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctStsCd = this.n3ptyCctStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsAmt1 = this.n3ptyCctOtsAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptStsCd = this.pptStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsStsCd = this.totOtsStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptRcvDt = this.pptRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsCurrCd5 = this.pptOtsCurrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiResult = this.eaiResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsAmt1 = this.totOtsAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsAmt2 = this.totOtsAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsCurrCd3 = this.pptOtsCurrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsAmt5 = this.n3ptyPptOtsAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsCurrCd4 = this.pptOtsCurrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsAmt4 = this.n3ptyPptOtsAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsAmt1 = this.pptOtsAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsCurrCd1 = this.pptOtsCurrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsAmt3 = this.n3ptyPptOtsAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsCurrCd2 = this.pptOtsCurrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsAmt2 = this.n3ptyPptOtsAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsAmt3 = this.pptOtsAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptOtsAmt1 = this.n3ptyPptOtsAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsAmt2 = this.pptOtsAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsAmt5 = this.pptOtsAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptOtsAmt4 = this.pptOtsAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctStsCd = this.cctStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptRcvOfcCd = this.n3ptyPptRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsCurrCd5 = this.n3ptyCctOtsCurrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsAmt5 = this.cctOtsAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsCurrCd2 = this.n3ptyCctOtsCurrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsAmt5 = this.totOtsAmt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsAmt4 = this.cctOtsAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsCurrCd1 = this.n3ptyCctOtsCurrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsAmt4 = this.totOtsAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsAmt3 = this.cctOtsAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsCurrCd4 = this.n3ptyCctOtsCurrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOtsAmt3 = this.totOtsAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsAmt2 = this.cctOtsAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctOtsCurrCd3 = this.n3ptyCctOtsCurrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOtsAmt1 = this.cctOtsAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctRcvUsrId = this.cctRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCctRcvUsrId = this.n3ptyCctRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPptStsCd = this.n3ptyPptStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
