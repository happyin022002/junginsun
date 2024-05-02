/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : FDRDGSurchargeVO.java
*@FileTitle : FDRDGSurchargeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.08
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2014.12.08 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FDRDGSurchargeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FDRDGSurchargeVO> models = new ArrayList<FDRDGSurchargeVO>();
	
	/* Column Info */
	private String imdgN1stClssSvcFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String imdgN5thClss20ftScgAmt = null;
	/* Column Info */
	private String imdgN6thClss20ftScgAmt = null;
	/* Column Info */
	private String imdgN8thClss40ftScgAmt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String imdgN1stClss40ftScgAmt = null;
	/* Column Info */
	private String pntLocCd = null;
	/* Column Info */
	private String imdgN7thClssSvcFlg = null;
	/* Column Info */
	private String imdgN3rdClss20ftScgAmt = null;
	/* Column Info */
	private String imdgN4thClssSvcFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pntLocNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String imdgN7thClss40ftScgAmt = null;
	/* Column Info */
	private String imdgN2ndClss20ftScgAmt = null;
	/* Column Info */
	private String imdgN5thClss40ftScgAmt = null;
	/* Column Info */
	private String imdgN6thClss40ftScgAmt = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String imdgN1stClss20ftScgAmt = null;
	/* Column Info */
	private String imdgN9thClss40ftScgAmt = null;
	/* Column Info */
	private String imdgN9thClssSvcFlg = null;
	/* Column Info */
	private String bsePortLocCd = null;
	/* Column Info */
	private String imdgN9thClss20ftScgAmt = null;
	/* Column Info */
	private String imdgN2ndClss40ftScgAmt = null;
	/* Column Info */
	private String imdgN3rdClss40ftScgAmt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String imdgN6thClssSvcFlg = null;
	/* Column Info */
	private String imdgN8thClssSvcFlg = null;
	/* Column Info */
	private String imdgN8thClss20ftScgAmt = null;
	/* Column Info */
	private String imdgN3rdClssSvcFlg = null;
	/* Column Info */
	private String imdgN2ndClssSvcFlg = null;
	/* Column Info */
	private String imdgN4thClss20ftScgAmt = null;
	/* Column Info */
	private String imdgN5thClssSvcFlg = null;
	/* Column Info */
	private String imdgN7thClss20ftScgAmt = null;
	/* Column Info */
	private String imdgN4thClss40ftScgAmt = null;
	/* Column Info */
	private String fdrTrfNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public FDRDGSurchargeVO() {}

	public FDRDGSurchargeVO(String ibflag, String pagerows, String pntLocCd, String pntLocNm, String bsePortLocCd, String rcvDeTermCd, String imdgN1stClssSvcFlg, String imdgN1stClss20ftScgAmt, String imdgN1stClss40ftScgAmt, String imdgN2ndClssSvcFlg, String imdgN2ndClss20ftScgAmt, String imdgN2ndClss40ftScgAmt, String imdgN3rdClssSvcFlg, String imdgN3rdClss20ftScgAmt, String imdgN3rdClss40ftScgAmt, String imdgN4thClssSvcFlg, String imdgN4thClss20ftScgAmt, String imdgN4thClss40ftScgAmt, String imdgN5thClssSvcFlg, String imdgN5thClss20ftScgAmt, String imdgN5thClss40ftScgAmt, String imdgN6thClssSvcFlg, String imdgN6thClss20ftScgAmt, String imdgN6thClss40ftScgAmt, String imdgN7thClssSvcFlg, String imdgN7thClss20ftScgAmt, String imdgN7thClss40ftScgAmt, String imdgN8thClssSvcFlg, String imdgN8thClss20ftScgAmt, String imdgN8thClss40ftScgAmt, String imdgN9thClssSvcFlg, String imdgN9thClss20ftScgAmt, String imdgN9thClss40ftScgAmt, String fdrTrfNo, String svcScpCd, String orgDestTpCd, String rhqCd, String currCd) {
		this.imdgN1stClssSvcFlg = imdgN1stClssSvcFlg;
		this.currCd = currCd;
		this.imdgN5thClss20ftScgAmt = imdgN5thClss20ftScgAmt;
		this.imdgN6thClss20ftScgAmt = imdgN6thClss20ftScgAmt;
		this.imdgN8thClss40ftScgAmt = imdgN8thClss40ftScgAmt;
		this.svcScpCd = svcScpCd;
		this.imdgN1stClss40ftScgAmt = imdgN1stClss40ftScgAmt;
		this.pntLocCd = pntLocCd;
		this.imdgN7thClssSvcFlg = imdgN7thClssSvcFlg;
		this.imdgN3rdClss20ftScgAmt = imdgN3rdClss20ftScgAmt;
		this.imdgN4thClssSvcFlg = imdgN4thClssSvcFlg;
		this.pagerows = pagerows;
		this.pntLocNm = pntLocNm;
		this.ibflag = ibflag;
		this.imdgN7thClss40ftScgAmt = imdgN7thClss40ftScgAmt;
		this.imdgN2ndClss20ftScgAmt = imdgN2ndClss20ftScgAmt;
		this.imdgN5thClss40ftScgAmt = imdgN5thClss40ftScgAmt;
		this.imdgN6thClss40ftScgAmt = imdgN6thClss40ftScgAmt;
		this.rcvDeTermCd = rcvDeTermCd;
		this.imdgN1stClss20ftScgAmt = imdgN1stClss20ftScgAmt;
		this.imdgN9thClss40ftScgAmt = imdgN9thClss40ftScgAmt;
		this.imdgN9thClssSvcFlg = imdgN9thClssSvcFlg;
		this.bsePortLocCd = bsePortLocCd;
		this.imdgN9thClss20ftScgAmt = imdgN9thClss20ftScgAmt;
		this.imdgN2ndClss40ftScgAmt = imdgN2ndClss40ftScgAmt;
		this.imdgN3rdClss40ftScgAmt = imdgN3rdClss40ftScgAmt;
		this.rhqCd = rhqCd;
		this.orgDestTpCd = orgDestTpCd;
		this.imdgN6thClssSvcFlg = imdgN6thClssSvcFlg;
		this.imdgN8thClssSvcFlg = imdgN8thClssSvcFlg;
		this.imdgN8thClss20ftScgAmt = imdgN8thClss20ftScgAmt;
		this.imdgN3rdClssSvcFlg = imdgN3rdClssSvcFlg;
		this.imdgN2ndClssSvcFlg = imdgN2ndClssSvcFlg;
		this.imdgN4thClss20ftScgAmt = imdgN4thClss20ftScgAmt;
		this.imdgN5thClssSvcFlg = imdgN5thClssSvcFlg;
		this.imdgN7thClss20ftScgAmt = imdgN7thClss20ftScgAmt;
		this.imdgN4thClss40ftScgAmt = imdgN4thClss40ftScgAmt;
		this.fdrTrfNo = fdrTrfNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("imdg_n1st_clss_svc_flg", getImdgN1stClssSvcFlg());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("imdg_n5th_clss_20ft_scg_amt", getImdgN5thClss20ftScgAmt());
		this.hashColumns.put("imdg_n6th_clss_20ft_scg_amt", getImdgN6thClss20ftScgAmt());
		this.hashColumns.put("imdg_n8th_clss_40ft_scg_amt", getImdgN8thClss40ftScgAmt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("imdg_n1st_clss_40ft_scg_amt", getImdgN1stClss40ftScgAmt());
		this.hashColumns.put("pnt_loc_cd", getPntLocCd());
		this.hashColumns.put("imdg_n7th_clss_svc_flg", getImdgN7thClssSvcFlg());
		this.hashColumns.put("imdg_n3rd_clss_20ft_scg_amt", getImdgN3rdClss20ftScgAmt());
		this.hashColumns.put("imdg_n4th_clss_svc_flg", getImdgN4thClssSvcFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pnt_loc_nm", getPntLocNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("imdg_n7th_clss_40ft_scg_amt", getImdgN7thClss40ftScgAmt());
		this.hashColumns.put("imdg_n2nd_clss_20ft_scg_amt", getImdgN2ndClss20ftScgAmt());
		this.hashColumns.put("imdg_n5th_clss_40ft_scg_amt", getImdgN5thClss40ftScgAmt());
		this.hashColumns.put("imdg_n6th_clss_40ft_scg_amt", getImdgN6thClss40ftScgAmt());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("imdg_n1st_clss_20ft_scg_amt", getImdgN1stClss20ftScgAmt());
		this.hashColumns.put("imdg_n9th_clss_40ft_scg_amt", getImdgN9thClss40ftScgAmt());
		this.hashColumns.put("imdg_n9th_clss_svc_flg", getImdgN9thClssSvcFlg());
		this.hashColumns.put("bse_port_loc_cd", getBsePortLocCd());
		this.hashColumns.put("imdg_n9th_clss_20ft_scg_amt", getImdgN9thClss20ftScgAmt());
		this.hashColumns.put("imdg_n2nd_clss_40ft_scg_amt", getImdgN2ndClss40ftScgAmt());
		this.hashColumns.put("imdg_n3rd_clss_40ft_scg_amt", getImdgN3rdClss40ftScgAmt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("imdg_n6th_clss_svc_flg", getImdgN6thClssSvcFlg());
		this.hashColumns.put("imdg_n8th_clss_svc_flg", getImdgN8thClssSvcFlg());
		this.hashColumns.put("imdg_n8th_clss_20ft_scg_amt", getImdgN8thClss20ftScgAmt());
		this.hashColumns.put("imdg_n3rd_clss_svc_flg", getImdgN3rdClssSvcFlg());
		this.hashColumns.put("imdg_n2nd_clss_svc_flg", getImdgN2ndClssSvcFlg());
		this.hashColumns.put("imdg_n4th_clss_20ft_scg_amt", getImdgN4thClss20ftScgAmt());
		this.hashColumns.put("imdg_n5th_clss_svc_flg", getImdgN5thClssSvcFlg());
		this.hashColumns.put("imdg_n7th_clss_20ft_scg_amt", getImdgN7thClss20ftScgAmt());
		this.hashColumns.put("imdg_n4th_clss_40ft_scg_amt", getImdgN4thClss40ftScgAmt());
		this.hashColumns.put("fdr_trf_no", getFdrTrfNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("imdg_n1st_clss_svc_flg", "imdgN1stClssSvcFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("imdg_n5th_clss_20ft_scg_amt", "imdgN5thClss20ftScgAmt");
		this.hashFields.put("imdg_n6th_clss_20ft_scg_amt", "imdgN6thClss20ftScgAmt");
		this.hashFields.put("imdg_n8th_clss_40ft_scg_amt", "imdgN8thClss40ftScgAmt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("imdg_n1st_clss_40ft_scg_amt", "imdgN1stClss40ftScgAmt");
		this.hashFields.put("pnt_loc_cd", "pntLocCd");
		this.hashFields.put("imdg_n7th_clss_svc_flg", "imdgN7thClssSvcFlg");
		this.hashFields.put("imdg_n3rd_clss_20ft_scg_amt", "imdgN3rdClss20ftScgAmt");
		this.hashFields.put("imdg_n4th_clss_svc_flg", "imdgN4thClssSvcFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pnt_loc_nm", "pntLocNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("imdg_n7th_clss_40ft_scg_amt", "imdgN7thClss40ftScgAmt");
		this.hashFields.put("imdg_n2nd_clss_20ft_scg_amt", "imdgN2ndClss20ftScgAmt");
		this.hashFields.put("imdg_n5th_clss_40ft_scg_amt", "imdgN5thClss40ftScgAmt");
		this.hashFields.put("imdg_n6th_clss_40ft_scg_amt", "imdgN6thClss40ftScgAmt");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("imdg_n1st_clss_20ft_scg_amt", "imdgN1stClss20ftScgAmt");
		this.hashFields.put("imdg_n9th_clss_40ft_scg_amt", "imdgN9thClss40ftScgAmt");
		this.hashFields.put("imdg_n9th_clss_svc_flg", "imdgN9thClssSvcFlg");
		this.hashFields.put("bse_port_loc_cd", "bsePortLocCd");
		this.hashFields.put("imdg_n9th_clss_20ft_scg_amt", "imdgN9thClss20ftScgAmt");
		this.hashFields.put("imdg_n2nd_clss_40ft_scg_amt", "imdgN2ndClss40ftScgAmt");
		this.hashFields.put("imdg_n3rd_clss_40ft_scg_amt", "imdgN3rdClss40ftScgAmt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("imdg_n6th_clss_svc_flg", "imdgN6thClssSvcFlg");
		this.hashFields.put("imdg_n8th_clss_svc_flg", "imdgN8thClssSvcFlg");
		this.hashFields.put("imdg_n8th_clss_20ft_scg_amt", "imdgN8thClss20ftScgAmt");
		this.hashFields.put("imdg_n3rd_clss_svc_flg", "imdgN3rdClssSvcFlg");
		this.hashFields.put("imdg_n2nd_clss_svc_flg", "imdgN2ndClssSvcFlg");
		this.hashFields.put("imdg_n4th_clss_20ft_scg_amt", "imdgN4thClss20ftScgAmt");
		this.hashFields.put("imdg_n5th_clss_svc_flg", "imdgN5thClssSvcFlg");
		this.hashFields.put("imdg_n7th_clss_20ft_scg_amt", "imdgN7thClss20ftScgAmt");
		this.hashFields.put("imdg_n4th_clss_40ft_scg_amt", "imdgN4thClss40ftScgAmt");
		this.hashFields.put("fdr_trf_no", "fdrTrfNo");
		return this.hashFields;
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
	 * @return imdgN8thClss40ftScgAmt
	 */
	public String getImdgN8thClss40ftScgAmt() {
		return this.imdgN8thClss40ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
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
	 * @return pntLocCd
	 */
	public String getPntLocCd() {
		return this.pntLocCd;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return pntLocNm
	 */
	public String getPntLocNm() {
		return this.pntLocNm;
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
	 * @return imdgN5thClss40ftScgAmt
	 */
	public String getImdgN5thClss40ftScgAmt() {
		return this.imdgN5thClss40ftScgAmt;
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
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
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
	 * @return bsePortLocCd
	 */
	public String getBsePortLocCd() {
		return this.bsePortLocCd;
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
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
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
	 * @return imdgN8thClss20ftScgAmt
	 */
	public String getImdgN8thClss20ftScgAmt() {
		return this.imdgN8thClss20ftScgAmt;
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
	 * @return imdgN7thClss20ftScgAmt
	 */
	public String getImdgN7thClss20ftScgAmt() {
		return this.imdgN7thClss20ftScgAmt;
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
	 * @return fdrTrfNo
	 */
	public String getFdrTrfNo() {
		return this.fdrTrfNo;
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
	 * @param imdgN8thClss40ftScgAmt
	 */
	public void setImdgN8thClss40ftScgAmt(String imdgN8thClss40ftScgAmt) {
		this.imdgN8thClss40ftScgAmt = imdgN8thClss40ftScgAmt;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
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
	 * @param pntLocCd
	 */
	public void setPntLocCd(String pntLocCd) {
		this.pntLocCd = pntLocCd;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param pntLocNm
	 */
	public void setPntLocNm(String pntLocNm) {
		this.pntLocNm = pntLocNm;
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
	 * @param imdgN5thClss40ftScgAmt
	 */
	public void setImdgN5thClss40ftScgAmt(String imdgN5thClss40ftScgAmt) {
		this.imdgN5thClss40ftScgAmt = imdgN5thClss40ftScgAmt;
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
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
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
	 * @param bsePortLocCd
	 */
	public void setBsePortLocCd(String bsePortLocCd) {
		this.bsePortLocCd = bsePortLocCd;
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
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
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
	 * @param imdgN8thClss20ftScgAmt
	 */
	public void setImdgN8thClss20ftScgAmt(String imdgN8thClss20ftScgAmt) {
		this.imdgN8thClss20ftScgAmt = imdgN8thClss20ftScgAmt;
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
	 * @param imdgN7thClss20ftScgAmt
	 */
	public void setImdgN7thClss20ftScgAmt(String imdgN7thClss20ftScgAmt) {
		this.imdgN7thClss20ftScgAmt = imdgN7thClss20ftScgAmt;
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
	 * @param fdrTrfNo
	 */
	public void setFdrTrfNo(String fdrTrfNo) {
		this.fdrTrfNo = fdrTrfNo;
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
		setImdgN1stClssSvcFlg(JSPUtil.getParameter(request, prefix + "imdg_n1st_clss_svc_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setImdgN5thClss20ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n5th_clss_20ft_scg_amt", ""));
		setImdgN6thClss20ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n6th_clss_20ft_scg_amt", ""));
		setImdgN8thClss40ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n8th_clss_40ft_scg_amt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setImdgN1stClss40ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n1st_clss_40ft_scg_amt", ""));
		setPntLocCd(JSPUtil.getParameter(request, prefix + "pnt_loc_cd", ""));
		setImdgN7thClssSvcFlg(JSPUtil.getParameter(request, prefix + "imdg_n7th_clss_svc_flg", ""));
		setImdgN3rdClss20ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n3rd_clss_20ft_scg_amt", ""));
		setImdgN4thClssSvcFlg(JSPUtil.getParameter(request, prefix + "imdg_n4th_clss_svc_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPntLocNm(JSPUtil.getParameter(request, prefix + "pnt_loc_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setImdgN7thClss40ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n7th_clss_40ft_scg_amt", ""));
		setImdgN2ndClss20ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n2nd_clss_20ft_scg_amt", ""));
		setImdgN5thClss40ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n5th_clss_40ft_scg_amt", ""));
		setImdgN6thClss40ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n6th_clss_40ft_scg_amt", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setImdgN1stClss20ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n1st_clss_20ft_scg_amt", ""));
		setImdgN9thClss40ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n9th_clss_40ft_scg_amt", ""));
		setImdgN9thClssSvcFlg(JSPUtil.getParameter(request, prefix + "imdg_n9th_clss_svc_flg", ""));
		setBsePortLocCd(JSPUtil.getParameter(request, prefix + "bse_port_loc_cd", ""));
		setImdgN9thClss20ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n9th_clss_20ft_scg_amt", ""));
		setImdgN2ndClss40ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n2nd_clss_40ft_scg_amt", ""));
		setImdgN3rdClss40ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n3rd_clss_40ft_scg_amt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setImdgN6thClssSvcFlg(JSPUtil.getParameter(request, prefix + "imdg_n6th_clss_svc_flg", ""));
		setImdgN8thClssSvcFlg(JSPUtil.getParameter(request, prefix + "imdg_n8th_clss_svc_flg", ""));
		setImdgN8thClss20ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n8th_clss_20ft_scg_amt", ""));
		setImdgN3rdClssSvcFlg(JSPUtil.getParameter(request, prefix + "imdg_n3rd_clss_svc_flg", ""));
		setImdgN2ndClssSvcFlg(JSPUtil.getParameter(request, prefix + "imdg_n2nd_clss_svc_flg", ""));
		setImdgN4thClss20ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n4th_clss_20ft_scg_amt", ""));
		setImdgN5thClssSvcFlg(JSPUtil.getParameter(request, prefix + "imdg_n5th_clss_svc_flg", ""));
		setImdgN7thClss20ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n7th_clss_20ft_scg_amt", ""));
		setImdgN4thClss40ftScgAmt(JSPUtil.getParameter(request, prefix + "imdg_n4th_clss_40ft_scg_amt", ""));
		setFdrTrfNo(JSPUtil.getParameter(request, prefix + "fdr_trf_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FDRDGSurchargeVO[]
	 */
	public FDRDGSurchargeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FDRDGSurchargeVO[]
	 */
	public FDRDGSurchargeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FDRDGSurchargeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] imdgN1stClssSvcFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_n1st_clss_svc_flg", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] imdgN5thClss20ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n5th_clss_20ft_scg_amt", length));
			String[] imdgN6thClss20ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n6th_clss_20ft_scg_amt", length));
			String[] imdgN8thClss40ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n8th_clss_40ft_scg_amt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] imdgN1stClss40ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n1st_clss_40ft_scg_amt", length));
			String[] pntLocCd = (JSPUtil.getParameter(request, prefix	+ "pnt_loc_cd", length));
			String[] imdgN7thClssSvcFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_n7th_clss_svc_flg", length));
			String[] imdgN3rdClss20ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n3rd_clss_20ft_scg_amt", length));
			String[] imdgN4thClssSvcFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_n4th_clss_svc_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pntLocNm = (JSPUtil.getParameter(request, prefix	+ "pnt_loc_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] imdgN7thClss40ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n7th_clss_40ft_scg_amt", length));
			String[] imdgN2ndClss20ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n2nd_clss_20ft_scg_amt", length));
			String[] imdgN5thClss40ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n5th_clss_40ft_scg_amt", length));
			String[] imdgN6thClss40ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n6th_clss_40ft_scg_amt", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] imdgN1stClss20ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n1st_clss_20ft_scg_amt", length));
			String[] imdgN9thClss40ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n9th_clss_40ft_scg_amt", length));
			String[] imdgN9thClssSvcFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_n9th_clss_svc_flg", length));
			String[] bsePortLocCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_loc_cd", length));
			String[] imdgN9thClss20ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n9th_clss_20ft_scg_amt", length));
			String[] imdgN2ndClss40ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n2nd_clss_40ft_scg_amt", length));
			String[] imdgN3rdClss40ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n3rd_clss_40ft_scg_amt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] imdgN6thClssSvcFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_n6th_clss_svc_flg", length));
			String[] imdgN8thClssSvcFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_n8th_clss_svc_flg", length));
			String[] imdgN8thClss20ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n8th_clss_20ft_scg_amt", length));
			String[] imdgN3rdClssSvcFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_n3rd_clss_svc_flg", length));
			String[] imdgN2ndClssSvcFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_n2nd_clss_svc_flg", length));
			String[] imdgN4thClss20ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n4th_clss_20ft_scg_amt", length));
			String[] imdgN5thClssSvcFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_n5th_clss_svc_flg", length));
			String[] imdgN7thClss20ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n7th_clss_20ft_scg_amt", length));
			String[] imdgN4thClss40ftScgAmt = (JSPUtil.getParameter(request, prefix	+ "imdg_n4th_clss_40ft_scg_amt", length));
			String[] fdrTrfNo = (JSPUtil.getParameter(request, prefix	+ "fdr_trf_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new FDRDGSurchargeVO();
				if (imdgN1stClssSvcFlg[i] != null)
					model.setImdgN1stClssSvcFlg(imdgN1stClssSvcFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (imdgN5thClss20ftScgAmt[i] != null)
					model.setImdgN5thClss20ftScgAmt(imdgN5thClss20ftScgAmt[i]);
				if (imdgN6thClss20ftScgAmt[i] != null)
					model.setImdgN6thClss20ftScgAmt(imdgN6thClss20ftScgAmt[i]);
				if (imdgN8thClss40ftScgAmt[i] != null)
					model.setImdgN8thClss40ftScgAmt(imdgN8thClss40ftScgAmt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (imdgN1stClss40ftScgAmt[i] != null)
					model.setImdgN1stClss40ftScgAmt(imdgN1stClss40ftScgAmt[i]);
				if (pntLocCd[i] != null)
					model.setPntLocCd(pntLocCd[i]);
				if (imdgN7thClssSvcFlg[i] != null)
					model.setImdgN7thClssSvcFlg(imdgN7thClssSvcFlg[i]);
				if (imdgN3rdClss20ftScgAmt[i] != null)
					model.setImdgN3rdClss20ftScgAmt(imdgN3rdClss20ftScgAmt[i]);
				if (imdgN4thClssSvcFlg[i] != null)
					model.setImdgN4thClssSvcFlg(imdgN4thClssSvcFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pntLocNm[i] != null)
					model.setPntLocNm(pntLocNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (imdgN7thClss40ftScgAmt[i] != null)
					model.setImdgN7thClss40ftScgAmt(imdgN7thClss40ftScgAmt[i]);
				if (imdgN2ndClss20ftScgAmt[i] != null)
					model.setImdgN2ndClss20ftScgAmt(imdgN2ndClss20ftScgAmt[i]);
				if (imdgN5thClss40ftScgAmt[i] != null)
					model.setImdgN5thClss40ftScgAmt(imdgN5thClss40ftScgAmt[i]);
				if (imdgN6thClss40ftScgAmt[i] != null)
					model.setImdgN6thClss40ftScgAmt(imdgN6thClss40ftScgAmt[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (imdgN1stClss20ftScgAmt[i] != null)
					model.setImdgN1stClss20ftScgAmt(imdgN1stClss20ftScgAmt[i]);
				if (imdgN9thClss40ftScgAmt[i] != null)
					model.setImdgN9thClss40ftScgAmt(imdgN9thClss40ftScgAmt[i]);
				if (imdgN9thClssSvcFlg[i] != null)
					model.setImdgN9thClssSvcFlg(imdgN9thClssSvcFlg[i]);
				if (bsePortLocCd[i] != null)
					model.setBsePortLocCd(bsePortLocCd[i]);
				if (imdgN9thClss20ftScgAmt[i] != null)
					model.setImdgN9thClss20ftScgAmt(imdgN9thClss20ftScgAmt[i]);
				if (imdgN2ndClss40ftScgAmt[i] != null)
					model.setImdgN2ndClss40ftScgAmt(imdgN2ndClss40ftScgAmt[i]);
				if (imdgN3rdClss40ftScgAmt[i] != null)
					model.setImdgN3rdClss40ftScgAmt(imdgN3rdClss40ftScgAmt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (imdgN6thClssSvcFlg[i] != null)
					model.setImdgN6thClssSvcFlg(imdgN6thClssSvcFlg[i]);
				if (imdgN8thClssSvcFlg[i] != null)
					model.setImdgN8thClssSvcFlg(imdgN8thClssSvcFlg[i]);
				if (imdgN8thClss20ftScgAmt[i] != null)
					model.setImdgN8thClss20ftScgAmt(imdgN8thClss20ftScgAmt[i]);
				if (imdgN3rdClssSvcFlg[i] != null)
					model.setImdgN3rdClssSvcFlg(imdgN3rdClssSvcFlg[i]);
				if (imdgN2ndClssSvcFlg[i] != null)
					model.setImdgN2ndClssSvcFlg(imdgN2ndClssSvcFlg[i]);
				if (imdgN4thClss20ftScgAmt[i] != null)
					model.setImdgN4thClss20ftScgAmt(imdgN4thClss20ftScgAmt[i]);
				if (imdgN5thClssSvcFlg[i] != null)
					model.setImdgN5thClssSvcFlg(imdgN5thClssSvcFlg[i]);
				if (imdgN7thClss20ftScgAmt[i] != null)
					model.setImdgN7thClss20ftScgAmt(imdgN7thClss20ftScgAmt[i]);
				if (imdgN4thClss40ftScgAmt[i] != null)
					model.setImdgN4thClss40ftScgAmt(imdgN4thClss40ftScgAmt[i]);
				if (fdrTrfNo[i] != null)
					model.setFdrTrfNo(fdrTrfNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFDRDGSurchargeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FDRDGSurchargeVO[]
	 */
	public FDRDGSurchargeVO[] getFDRDGSurchargeVOs(){
		FDRDGSurchargeVO[] vos = (FDRDGSurchargeVO[])models.toArray(new FDRDGSurchargeVO[models.size()]);
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
		this.imdgN1stClssSvcFlg = this.imdgN1stClssSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN5thClss20ftScgAmt = this.imdgN5thClss20ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN6thClss20ftScgAmt = this.imdgN6thClss20ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN8thClss40ftScgAmt = this.imdgN8thClss40ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN1stClss40ftScgAmt = this.imdgN1stClss40ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pntLocCd = this.pntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN7thClssSvcFlg = this.imdgN7thClssSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN3rdClss20ftScgAmt = this.imdgN3rdClss20ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN4thClssSvcFlg = this.imdgN4thClssSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pntLocNm = this.pntLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN7thClss40ftScgAmt = this.imdgN7thClss40ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN2ndClss20ftScgAmt = this.imdgN2ndClss20ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN5thClss40ftScgAmt = this.imdgN5thClss40ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN6thClss40ftScgAmt = this.imdgN6thClss40ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN1stClss20ftScgAmt = this.imdgN1stClss20ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN9thClss40ftScgAmt = this.imdgN9thClss40ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN9thClssSvcFlg = this.imdgN9thClssSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortLocCd = this.bsePortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN9thClss20ftScgAmt = this.imdgN9thClss20ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN2ndClss40ftScgAmt = this.imdgN2ndClss40ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN3rdClss40ftScgAmt = this.imdgN3rdClss40ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN6thClssSvcFlg = this.imdgN6thClssSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN8thClssSvcFlg = this.imdgN8thClssSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN8thClss20ftScgAmt = this.imdgN8thClss20ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN3rdClssSvcFlg = this.imdgN3rdClssSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN2ndClssSvcFlg = this.imdgN2ndClssSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN4thClss20ftScgAmt = this.imdgN4thClss20ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN5thClssSvcFlg = this.imdgN5thClssSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN7thClss20ftScgAmt = this.imdgN7thClss20ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgN4thClss40ftScgAmt = this.imdgN4thClss40ftScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrTrfNo = this.fdrTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
