/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SelectPrdOcnRoutVO.java
*@FileTitle : SelectPrdOcnRoutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2010.02.10 정선용 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo;

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
 * @author 정선용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SelectPrdOcnRoutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SelectPrdOcnRoutVO> models = new ArrayList<SelectPrdOcnRoutVO>();
	
	/* Column Info */
	private String n1stPodDc = null;
	/* Column Info */
	private String ttlExpnAmt = null;
	/* Column Info */
	private String orgTztmHrs = null;
	/* Column Info */
	private String no = null;
	/* Column Info */
	private String n2ndPodN = null;
	/* Column Info */
	private String n3rdPodN = null;
	/* Column Info */
	private String n2ndTvvdFlag = null;
	/* Column Info */
	private String n4thPolDc = null;
	/* Column Info */
	private String tztmHrs = null;
	/* Column Info */
	private String n2ndSpace = null;
	/* Column Info */
	private String n4thPod = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pctlNo = null;
	/* Column Info */
	private String n4thTvvdFlag = null;
	/* Column Info */
	private String n4thPodN = null;
	/* Column Info */
	private String n4thPol = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String n2ndVvd = null;
	/* Column Info */
	private String n2ndPolDc = null;
	/* Column Info */
	private String n3rdTvvdFlag = null;
	/* Column Info */
	private String n1stTvvdFlag = null;
	/* Column Info */
	private String n4thSpace = null;
	/* Column Info */
	private String n1stPolDc = null;
	/* Column Info */
	private String vvdLnkNo = null;
	/* Column Info */
	private String n2ndSlanCd = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String n4thSlanCd = null;
	/* Column Info */
	private String n1stVvd = null;
	/* Column Info */
	private String orgLocCd = null;
	/* Column Info */
	private String destLocCd = null;
	/* Column Info */
	private String n3rdPolN = null;
	/* Column Info */
	private String n3rdVvd = null;
	/* Column Info */
	private String n3rdSlanCd = null;
	/* Column Info */
	private String n1stPol = null;
	/* Column Info */
	private String rk = null;
	/* Column Info */
	private String ord = null;
	/* Column Info */
	private String n1stPodN = null;
	/* Column Info */
	private String n1stVslSlanCd = null;
	/* Column Info */
	private String n1stPolN = null;
	/* Column Info */
	private String n1stPod = null;
	/* Column Info */
	private String n3rdPodDc = null;
	/* Column Info */
	private String lnkKnt = null;
	/* Column Info */
	private String updIndCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String n2ndPod = null;
	/* Column Info */
	private String n2ndPodDc = null;
	/* Column Info */
	private String n4thVvd = null;
	/* Column Info */
	private String n3rdVslSlanCd = null;
	/* Column Info */
	private String n3rdPod = null;
	/* Column Info */
	private String n4thPodDc = null;
	/* Column Info */
	private String ocnRoutPrioCd = null;
	/* Column Info */
	private String n1stSpace = null;
	/* Column Info */
	private String n3rdSpace = null;
	/* Column Info */
	private String n4thVslSlanCd = null;
	/* Column Info */
	private String n2ndVslSlanCd = null;
	/* Column Info */
	private String n3rdPolDc = null;
	/* Column Info */
	private String n1stSlanCd = null;
	/* Column Info */
	private String n4thPolN = null;
	/* Column Info */
	private String n2ndPol = null;
	/* Column Info */
	private String n3rdPol = null;
	/* Column Info */
	private String n2ndPolN = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SelectPrdOcnRoutVO() {}

	public SelectPrdOcnRoutVO(String ibflag, String pagerows, String chk, String no, String pctlNo, String slsOfcCd, String orgLocCd, String destLocCd, String routSeq, String updIndCd, String ord, String rk, String vvdLnkNo, String tztmHrs, String orgTztmHrs, String lnkKnt, String ocnRoutPrioCd, String n1stVslSlanCd, String n1stSlanCd, String n1stVvd, String n1stPol, String n1stPod, String n1stPolN, String n1stPodN, String n1stPolDc, String n1stPodDc, String n1stTvvdFlag, String n1stSpace, String n2ndVslSlanCd, String n2ndSlanCd, String n2ndVvd, String n2ndPol, String n2ndPod, String n2ndPolN, String n2ndPodN, String n2ndPolDc, String n2ndPodDc, String n2ndTvvdFlag, String n2ndSpace, String n3rdVslSlanCd, String n3rdSlanCd, String n3rdVvd, String n3rdPol, String n3rdPod, String n3rdPolN, String n3rdPodN, String n3rdPolDc, String n3rdPodDc, String n3rdTvvdFlag, String n3rdSpace, String n4thVslSlanCd, String n4thSlanCd, String n4thVvd, String n4thPol, String n4thPod, String n4thPolN, String n4thPodN, String n4thPolDc, String n4thPodDc, String n4thTvvdFlag, String n4thSpace, String ttlExpnAmt) {
		this.n1stPodDc = n1stPodDc;
		this.ttlExpnAmt = ttlExpnAmt;
		this.orgTztmHrs = orgTztmHrs;
		this.no = no;
		this.n2ndPodN = n2ndPodN;
		this.n3rdPodN = n3rdPodN;
		this.n2ndTvvdFlag = n2ndTvvdFlag;
		this.n4thPolDc = n4thPolDc;
		this.tztmHrs = tztmHrs;
		this.n2ndSpace = n2ndSpace;
		this.n4thPod = n4thPod;
		this.pagerows = pagerows;
		this.pctlNo = pctlNo;
		this.n4thTvvdFlag = n4thTvvdFlag;
		this.n4thPodN = n4thPodN;
		this.n4thPol = n4thPol;
		this.slsOfcCd = slsOfcCd;
		this.n2ndVvd = n2ndVvd;
		this.n2ndPolDc = n2ndPolDc;
		this.n3rdTvvdFlag = n3rdTvvdFlag;
		this.n1stTvvdFlag = n1stTvvdFlag;
		this.n4thSpace = n4thSpace;
		this.n1stPolDc = n1stPolDc;
		this.vvdLnkNo = vvdLnkNo;
		this.n2ndSlanCd = n2ndSlanCd;
		this.routSeq = routSeq;
		this.chk = chk;
		this.n4thSlanCd = n4thSlanCd;
		this.n1stVvd = n1stVvd;
		this.orgLocCd = orgLocCd;
		this.destLocCd = destLocCd;
		this.n3rdPolN = n3rdPolN;
		this.n3rdVvd = n3rdVvd;
		this.n3rdSlanCd = n3rdSlanCd;
		this.n1stPol = n1stPol;
		this.rk = rk;
		this.ord = ord;
		this.n1stPodN = n1stPodN;
		this.n1stVslSlanCd = n1stVslSlanCd;
		this.n1stPolN = n1stPolN;
		this.n1stPod = n1stPod;
		this.n3rdPodDc = n3rdPodDc;
		this.lnkKnt = lnkKnt;
		this.updIndCd = updIndCd;
		this.ibflag = ibflag;
		this.n2ndPod = n2ndPod;
		this.n2ndPodDc = n2ndPodDc;
		this.n4thVvd = n4thVvd;
		this.n3rdVslSlanCd = n3rdVslSlanCd;
		this.n3rdPod = n3rdPod;
		this.n4thPodDc = n4thPodDc;
		this.ocnRoutPrioCd = ocnRoutPrioCd;
		this.n1stSpace = n1stSpace;
		this.n3rdSpace = n3rdSpace;
		this.n4thVslSlanCd = n4thVslSlanCd;
		this.n2ndVslSlanCd = n2ndVslSlanCd;
		this.n3rdPolDc = n3rdPolDc;
		this.n1stSlanCd = n1stSlanCd;
		this.n4thPolN = n4thPolN;
		this.n2ndPol = n2ndPol;
		this.n3rdPol = n3rdPol;
		this.n2ndPolN = n2ndPolN;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n1st_pod_dc", getN1stPodDc());
		this.hashColumns.put("ttl_expn_amt", getTtlExpnAmt());
		this.hashColumns.put("org_tztm_hrs", getOrgTztmHrs());
		this.hashColumns.put("no", getNo());
		this.hashColumns.put("n2nd_pod_n", getN2ndPodN());
		this.hashColumns.put("n3rd_pod_n", getN3rdPodN());
		this.hashColumns.put("n2nd_tvvd_flag", getN2ndTvvdFlag());
		this.hashColumns.put("n4th_pol_dc", getN4thPolDc());
		this.hashColumns.put("tztm_hrs", getTztmHrs());
		this.hashColumns.put("n2nd_space", getN2ndSpace());
		this.hashColumns.put("n4th_pod", getN4thPod());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("n4th_tvvd_flag", getN4thTvvdFlag());
		this.hashColumns.put("n4th_pod_n", getN4thPodN());
		this.hashColumns.put("n4th_pol", getN4thPol());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("n2nd_vvd", getN2ndVvd());
		this.hashColumns.put("n2nd_pol_dc", getN2ndPolDc());
		this.hashColumns.put("n3rd_tvvd_flag", getN3rdTvvdFlag());
		this.hashColumns.put("n1st_tvvd_flag", getN1stTvvdFlag());
		this.hashColumns.put("n4th_space", getN4thSpace());
		this.hashColumns.put("n1st_pol_dc", getN1stPolDc());
		this.hashColumns.put("vvd_lnk_no", getVvdLnkNo());
		this.hashColumns.put("n2nd_slan_cd", getN2ndSlanCd());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("n4th_slan_cd", getN4thSlanCd());
		this.hashColumns.put("n1st_vvd", getN1stVvd());
		this.hashColumns.put("org_loc_cd", getOrgLocCd());
		this.hashColumns.put("dest_loc_cd", getDestLocCd());
		this.hashColumns.put("n3rd_pol_n", getN3rdPolN());
		this.hashColumns.put("n3rd_vvd", getN3rdVvd());
		this.hashColumns.put("n3rd_slan_cd", getN3rdSlanCd());
		this.hashColumns.put("n1st_pol", getN1stPol());
		this.hashColumns.put("rk", getRk());
		this.hashColumns.put("ord", getOrd());
		this.hashColumns.put("n1st_pod_n", getN1stPodN());
		this.hashColumns.put("n1st_vsl_slan_cd", getN1stVslSlanCd());
		this.hashColumns.put("n1st_pol_n", getN1stPolN());
		this.hashColumns.put("n1st_pod", getN1stPod());
		this.hashColumns.put("n3rd_pod_dc", getN3rdPodDc());
		this.hashColumns.put("lnk_knt", getLnkKnt());
		this.hashColumns.put("upd_ind_cd", getUpdIndCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n2nd_pod", getN2ndPod());
		this.hashColumns.put("n2nd_pod_dc", getN2ndPodDc());
		this.hashColumns.put("n4th_vvd", getN4thVvd());
		this.hashColumns.put("n3rd_vsl_slan_cd", getN3rdVslSlanCd());
		this.hashColumns.put("n3rd_pod", getN3rdPod());
		this.hashColumns.put("n4th_pod_dc", getN4thPodDc());
		this.hashColumns.put("ocn_rout_prio_cd", getOcnRoutPrioCd());
		this.hashColumns.put("n1st_space", getN1stSpace());
		this.hashColumns.put("n3rd_space", getN3rdSpace());
		this.hashColumns.put("n4th_vsl_slan_cd", getN4thVslSlanCd());
		this.hashColumns.put("n2nd_vsl_slan_cd", getN2ndVslSlanCd());
		this.hashColumns.put("n3rd_pol_dc", getN3rdPolDc());
		this.hashColumns.put("n1st_slan_cd", getN1stSlanCd());
		this.hashColumns.put("n4th_pol_n", getN4thPolN());
		this.hashColumns.put("n2nd_pol", getN2ndPol());
		this.hashColumns.put("n3rd_pol", getN3rdPol());
		this.hashColumns.put("n2nd_pol_n", getN2ndPolN());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n1st_pod_dc", "n1stPodDc");
		this.hashFields.put("ttl_expn_amt", "ttlExpnAmt");
		this.hashFields.put("org_tztm_hrs", "orgTztmHrs");
		this.hashFields.put("no", "no");
		this.hashFields.put("n2nd_pod_n", "n2ndPodN");
		this.hashFields.put("n3rd_pod_n", "n3rdPodN");
		this.hashFields.put("n2nd_tvvd_flag", "n2ndTvvdFlag");
		this.hashFields.put("n4th_pol_dc", "n4thPolDc");
		this.hashFields.put("tztm_hrs", "tztmHrs");
		this.hashFields.put("n2nd_space", "n2ndSpace");
		this.hashFields.put("n4th_pod", "n4thPod");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("n4th_tvvd_flag", "n4thTvvdFlag");
		this.hashFields.put("n4th_pod_n", "n4thPodN");
		this.hashFields.put("n4th_pol", "n4thPol");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("n2nd_vvd", "n2ndVvd");
		this.hashFields.put("n2nd_pol_dc", "n2ndPolDc");
		this.hashFields.put("n3rd_tvvd_flag", "n3rdTvvdFlag");
		this.hashFields.put("n1st_tvvd_flag", "n1stTvvdFlag");
		this.hashFields.put("n4th_space", "n4thSpace");
		this.hashFields.put("n1st_pol_dc", "n1stPolDc");
		this.hashFields.put("vvd_lnk_no", "vvdLnkNo");
		this.hashFields.put("n2nd_slan_cd", "n2ndSlanCd");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("n4th_slan_cd", "n4thSlanCd");
		this.hashFields.put("n1st_vvd", "n1stVvd");
		this.hashFields.put("org_loc_cd", "orgLocCd");
		this.hashFields.put("dest_loc_cd", "destLocCd");
		this.hashFields.put("n3rd_pol_n", "n3rdPolN");
		this.hashFields.put("n3rd_vvd", "n3rdVvd");
		this.hashFields.put("n3rd_slan_cd", "n3rdSlanCd");
		this.hashFields.put("n1st_pol", "n1stPol");
		this.hashFields.put("rk", "rk");
		this.hashFields.put("ord", "ord");
		this.hashFields.put("n1st_pod_n", "n1stPodN");
		this.hashFields.put("n1st_vsl_slan_cd", "n1stVslSlanCd");
		this.hashFields.put("n1st_pol_n", "n1stPolN");
		this.hashFields.put("n1st_pod", "n1stPod");
		this.hashFields.put("n3rd_pod_dc", "n3rdPodDc");
		this.hashFields.put("lnk_knt", "lnkKnt");
		this.hashFields.put("upd_ind_cd", "updIndCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n2nd_pod", "n2ndPod");
		this.hashFields.put("n2nd_pod_dc", "n2ndPodDc");
		this.hashFields.put("n4th_vvd", "n4thVvd");
		this.hashFields.put("n3rd_vsl_slan_cd", "n3rdVslSlanCd");
		this.hashFields.put("n3rd_pod", "n3rdPod");
		this.hashFields.put("n4th_pod_dc", "n4thPodDc");
		this.hashFields.put("ocn_rout_prio_cd", "ocnRoutPrioCd");
		this.hashFields.put("n1st_space", "n1stSpace");
		this.hashFields.put("n3rd_space", "n3rdSpace");
		this.hashFields.put("n4th_vsl_slan_cd", "n4thVslSlanCd");
		this.hashFields.put("n2nd_vsl_slan_cd", "n2ndVslSlanCd");
		this.hashFields.put("n3rd_pol_dc", "n3rdPolDc");
		this.hashFields.put("n1st_slan_cd", "n1stSlanCd");
		this.hashFields.put("n4th_pol_n", "n4thPolN");
		this.hashFields.put("n2nd_pol", "n2ndPol");
		this.hashFields.put("n3rd_pol", "n3rdPol");
		this.hashFields.put("n2nd_pol_n", "n2ndPolN");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return n1stPodDc
	 */
	public String getN1stPodDc() {
		return this.n1stPodDc;
	}
	
	/**
	 * Column Info
	 * @return ttlExpnAmt
	 */
	public String getTtlExpnAmt() {
		return this.ttlExpnAmt;
	}
	
	/**
	 * Column Info
	 * @return orgTztmHrs
	 */
	public String getOrgTztmHrs() {
		return this.orgTztmHrs;
	}
	
	/**
	 * Column Info
	 * @return no
	 */
	public String getNo() {
		return this.no;
	}
	
	/**
	 * Column Info
	 * @return n2ndPodN
	 */
	public String getN2ndPodN() {
		return this.n2ndPodN;
	}
	
	/**
	 * Column Info
	 * @return n3rdPodN
	 */
	public String getN3rdPodN() {
		return this.n3rdPodN;
	}
	
	/**
	 * Column Info
	 * @return n2ndTvvdFlag
	 */
	public String getN2ndTvvdFlag() {
		return this.n2ndTvvdFlag;
	}
	
	/**
	 * Column Info
	 * @return n4thPolDc
	 */
	public String getN4thPolDc() {
		return this.n4thPolDc;
	}
	
	/**
	 * Column Info
	 * @return tztmHrs
	 */
	public String getTztmHrs() {
		return this.tztmHrs;
	}
	
	/**
	 * Column Info
	 * @return n2ndSpace
	 */
	public String getN2ndSpace() {
		return this.n2ndSpace;
	}
	
	/**
	 * Column Info
	 * @return n4thPod
	 */
	public String getN4thPod() {
		return this.n4thPod;
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
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
	}
	
	/**
	 * Column Info
	 * @return n4thTvvdFlag
	 */
	public String getN4thTvvdFlag() {
		return this.n4thTvvdFlag;
	}
	
	/**
	 * Column Info
	 * @return n4thPodN
	 */
	public String getN4thPodN() {
		return this.n4thPodN;
	}
	
	/**
	 * Column Info
	 * @return n4thPol
	 */
	public String getN4thPol() {
		return this.n4thPol;
	}
	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndVvd
	 */
	public String getN2ndVvd() {
		return this.n2ndVvd;
	}
	
	/**
	 * Column Info
	 * @return n2ndPolDc
	 */
	public String getN2ndPolDc() {
		return this.n2ndPolDc;
	}
	
	/**
	 * Column Info
	 * @return n3rdTvvdFlag
	 */
	public String getN3rdTvvdFlag() {
		return this.n3rdTvvdFlag;
	}
	
	/**
	 * Column Info
	 * @return n1stTvvdFlag
	 */
	public String getN1stTvvdFlag() {
		return this.n1stTvvdFlag;
	}
	
	/**
	 * Column Info
	 * @return n4thSpace
	 */
	public String getN4thSpace() {
		return this.n4thSpace;
	}
	
	/**
	 * Column Info
	 * @return n1stPolDc
	 */
	public String getN1stPolDc() {
		return this.n1stPolDc;
	}
	
	/**
	 * Column Info
	 * @return vvdLnkNo
	 */
	public String getVvdLnkNo() {
		return this.vvdLnkNo;
	}
	
	/**
	 * Column Info
	 * @return n2ndSlanCd
	 */
	public String getN2ndSlanCd() {
		return this.n2ndSlanCd;
	}
	
	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
	}
	
	/**
	 * Column Info
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}
	
	/**
	 * Column Info
	 * @return n4thSlanCd
	 */
	public String getN4thSlanCd() {
		return this.n4thSlanCd;
	}
	
	/**
	 * Column Info
	 * @return n1stVvd
	 */
	public String getN1stVvd() {
		return this.n1stVvd;
	}
	
	/**
	 * Column Info
	 * @return orgLocCd
	 */
	public String getOrgLocCd() {
		return this.orgLocCd;
	}
	
	/**
	 * Column Info
	 * @return destLocCd
	 */
	public String getDestLocCd() {
		return this.destLocCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdPolN
	 */
	public String getN3rdPolN() {
		return this.n3rdPolN;
	}
	
	/**
	 * Column Info
	 * @return n3rdVvd
	 */
	public String getN3rdVvd() {
		return this.n3rdVvd;
	}
	
	/**
	 * Column Info
	 * @return n3rdSlanCd
	 */
	public String getN3rdSlanCd() {
		return this.n3rdSlanCd;
	}
	
	/**
	 * Column Info
	 * @return n1stPol
	 */
	public String getN1stPol() {
		return this.n1stPol;
	}
	
	/**
	 * Column Info
	 * @return rk
	 */
	public String getRk() {
		return this.rk;
	}
	
	/**
	 * Column Info
	 * @return ord
	 */
	public String getOrd() {
		return this.ord;
	}
	
	/**
	 * Column Info
	 * @return n1stPodN
	 */
	public String getN1stPodN() {
		return this.n1stPodN;
	}
	
	/**
	 * Column Info
	 * @return n1stVslSlanCd
	 */
	public String getN1stVslSlanCd() {
		return this.n1stVslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return n1stPolN
	 */
	public String getN1stPolN() {
		return this.n1stPolN;
	}
	
	/**
	 * Column Info
	 * @return n1stPod
	 */
	public String getN1stPod() {
		return this.n1stPod;
	}
	
	/**
	 * Column Info
	 * @return n3rdPodDc
	 */
	public String getN3rdPodDc() {
		return this.n3rdPodDc;
	}
	
	/**
	 * Column Info
	 * @return lnkKnt
	 */
	public String getLnkKnt() {
		return this.lnkKnt;
	}
	
	/**
	 * Column Info
	 * @return updIndCd
	 */
	public String getUpdIndCd() {
		return this.updIndCd;
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
	 * @return n2ndPod
	 */
	public String getN2ndPod() {
		return this.n2ndPod;
	}
	
	/**
	 * Column Info
	 * @return n2ndPodDc
	 */
	public String getN2ndPodDc() {
		return this.n2ndPodDc;
	}
	
	/**
	 * Column Info
	 * @return n4thVvd
	 */
	public String getN4thVvd() {
		return this.n4thVvd;
	}
	
	/**
	 * Column Info
	 * @return n3rdVslSlanCd
	 */
	public String getN3rdVslSlanCd() {
		return this.n3rdVslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdPod
	 */
	public String getN3rdPod() {
		return this.n3rdPod;
	}
	
	/**
	 * Column Info
	 * @return n4thPodDc
	 */
	public String getN4thPodDc() {
		return this.n4thPodDc;
	}
	
	/**
	 * Column Info
	 * @return ocnRoutPrioCd
	 */
	public String getOcnRoutPrioCd() {
		return this.ocnRoutPrioCd;
	}
	
	/**
	 * Column Info
	 * @return n1stSpace
	 */
	public String getN1stSpace() {
		return this.n1stSpace;
	}
	
	/**
	 * Column Info
	 * @return n3rdSpace
	 */
	public String getN3rdSpace() {
		return this.n3rdSpace;
	}
	
	/**
	 * Column Info
	 * @return n4thVslSlanCd
	 */
	public String getN4thVslSlanCd() {
		return this.n4thVslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndVslSlanCd
	 */
	public String getN2ndVslSlanCd() {
		return this.n2ndVslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdPolDc
	 */
	public String getN3rdPolDc() {
		return this.n3rdPolDc;
	}
	
	/**
	 * Column Info
	 * @return n1stSlanCd
	 */
	public String getN1stSlanCd() {
		return this.n1stSlanCd;
	}
	
	/**
	 * Column Info
	 * @return n4thPolN
	 */
	public String getN4thPolN() {
		return this.n4thPolN;
	}
	
	/**
	 * Column Info
	 * @return n2ndPol
	 */
	public String getN2ndPol() {
		return this.n2ndPol;
	}
	
	/**
	 * Column Info
	 * @return n3rdPol
	 */
	public String getN3rdPol() {
		return this.n3rdPol;
	}
	
	/**
	 * Column Info
	 * @return n2ndPolN
	 */
	public String getN2ndPolN() {
		return this.n2ndPolN;
	}
	

	/**
	 * Column Info
	 * @param n1stPodDc
	 */
	public void setN1stPodDc(String n1stPodDc) {
		this.n1stPodDc = n1stPodDc;
	}
	
	/**
	 * Column Info
	 * @param ttlExpnAmt
	 */
	public void setTtlExpnAmt(String ttlExpnAmt) {
		this.ttlExpnAmt = ttlExpnAmt;
	}
	
	/**
	 * Column Info
	 * @param orgTztmHrs
	 */
	public void setOrgTztmHrs(String orgTztmHrs) {
		this.orgTztmHrs = orgTztmHrs;
	}
	
	/**
	 * Column Info
	 * @param no
	 */
	public void setNo(String no) {
		this.no = no;
	}
	
	/**
	 * Column Info
	 * @param n2ndPodN
	 */
	public void setN2ndPodN(String n2ndPodN) {
		this.n2ndPodN = n2ndPodN;
	}
	
	/**
	 * Column Info
	 * @param n3rdPodN
	 */
	public void setN3rdPodN(String n3rdPodN) {
		this.n3rdPodN = n3rdPodN;
	}
	
	/**
	 * Column Info
	 * @param n2ndTvvdFlag
	 */
	public void setN2ndTvvdFlag(String n2ndTvvdFlag) {
		this.n2ndTvvdFlag = n2ndTvvdFlag;
	}
	
	/**
	 * Column Info
	 * @param n4thPolDc
	 */
	public void setN4thPolDc(String n4thPolDc) {
		this.n4thPolDc = n4thPolDc;
	}
	
	/**
	 * Column Info
	 * @param tztmHrs
	 */
	public void setTztmHrs(String tztmHrs) {
		this.tztmHrs = tztmHrs;
	}
	
	/**
	 * Column Info
	 * @param n2ndSpace
	 */
	public void setN2ndSpace(String n2ndSpace) {
		this.n2ndSpace = n2ndSpace;
	}
	
	/**
	 * Column Info
	 * @param n4thPod
	 */
	public void setN4thPod(String n4thPod) {
		this.n4thPod = n4thPod;
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
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
	}
	
	/**
	 * Column Info
	 * @param n4thTvvdFlag
	 */
	public void setN4thTvvdFlag(String n4thTvvdFlag) {
		this.n4thTvvdFlag = n4thTvvdFlag;
	}
	
	/**
	 * Column Info
	 * @param n4thPodN
	 */
	public void setN4thPodN(String n4thPodN) {
		this.n4thPodN = n4thPodN;
	}
	
	/**
	 * Column Info
	 * @param n4thPol
	 */
	public void setN4thPol(String n4thPol) {
		this.n4thPol = n4thPol;
	}
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndVvd
	 */
	public void setN2ndVvd(String n2ndVvd) {
		this.n2ndVvd = n2ndVvd;
	}
	
	/**
	 * Column Info
	 * @param n2ndPolDc
	 */
	public void setN2ndPolDc(String n2ndPolDc) {
		this.n2ndPolDc = n2ndPolDc;
	}
	
	/**
	 * Column Info
	 * @param n3rdTvvdFlag
	 */
	public void setN3rdTvvdFlag(String n3rdTvvdFlag) {
		this.n3rdTvvdFlag = n3rdTvvdFlag;
	}
	
	/**
	 * Column Info
	 * @param n1stTvvdFlag
	 */
	public void setN1stTvvdFlag(String n1stTvvdFlag) {
		this.n1stTvvdFlag = n1stTvvdFlag;
	}
	
	/**
	 * Column Info
	 * @param n4thSpace
	 */
	public void setN4thSpace(String n4thSpace) {
		this.n4thSpace = n4thSpace;
	}
	
	/**
	 * Column Info
	 * @param n1stPolDc
	 */
	public void setN1stPolDc(String n1stPolDc) {
		this.n1stPolDc = n1stPolDc;
	}
	
	/**
	 * Column Info
	 * @param vvdLnkNo
	 */
	public void setVvdLnkNo(String vvdLnkNo) {
		this.vvdLnkNo = vvdLnkNo;
	}
	
	/**
	 * Column Info
	 * @param n2ndSlanCd
	 */
	public void setN2ndSlanCd(String n2ndSlanCd) {
		this.n2ndSlanCd = n2ndSlanCd;
	}
	
	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}
	
	/**
	 * Column Info
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	/**
	 * Column Info
	 * @param n4thSlanCd
	 */
	public void setN4thSlanCd(String n4thSlanCd) {
		this.n4thSlanCd = n4thSlanCd;
	}
	
	/**
	 * Column Info
	 * @param n1stVvd
	 */
	public void setN1stVvd(String n1stVvd) {
		this.n1stVvd = n1stVvd;
	}
	
	/**
	 * Column Info
	 * @param orgLocCd
	 */
	public void setOrgLocCd(String orgLocCd) {
		this.orgLocCd = orgLocCd;
	}
	
	/**
	 * Column Info
	 * @param destLocCd
	 */
	public void setDestLocCd(String destLocCd) {
		this.destLocCd = destLocCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdPolN
	 */
	public void setN3rdPolN(String n3rdPolN) {
		this.n3rdPolN = n3rdPolN;
	}
	
	/**
	 * Column Info
	 * @param n3rdVvd
	 */
	public void setN3rdVvd(String n3rdVvd) {
		this.n3rdVvd = n3rdVvd;
	}
	
	/**
	 * Column Info
	 * @param n3rdSlanCd
	 */
	public void setN3rdSlanCd(String n3rdSlanCd) {
		this.n3rdSlanCd = n3rdSlanCd;
	}
	
	/**
	 * Column Info
	 * @param n1stPol
	 */
	public void setN1stPol(String n1stPol) {
		this.n1stPol = n1stPol;
	}
	
	/**
	 * Column Info
	 * @param rk
	 */
	public void setRk(String rk) {
		this.rk = rk;
	}
	
	/**
	 * Column Info
	 * @param ord
	 */
	public void setOrd(String ord) {
		this.ord = ord;
	}
	
	/**
	 * Column Info
	 * @param n1stPodN
	 */
	public void setN1stPodN(String n1stPodN) {
		this.n1stPodN = n1stPodN;
	}
	
	/**
	 * Column Info
	 * @param n1stVslSlanCd
	 */
	public void setN1stVslSlanCd(String n1stVslSlanCd) {
		this.n1stVslSlanCd = n1stVslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param n1stPolN
	 */
	public void setN1stPolN(String n1stPolN) {
		this.n1stPolN = n1stPolN;
	}
	
	/**
	 * Column Info
	 * @param n1stPod
	 */
	public void setN1stPod(String n1stPod) {
		this.n1stPod = n1stPod;
	}
	
	/**
	 * Column Info
	 * @param n3rdPodDc
	 */
	public void setN3rdPodDc(String n3rdPodDc) {
		this.n3rdPodDc = n3rdPodDc;
	}
	
	/**
	 * Column Info
	 * @param lnkKnt
	 */
	public void setLnkKnt(String lnkKnt) {
		this.lnkKnt = lnkKnt;
	}
	
	/**
	 * Column Info
	 * @param updIndCd
	 */
	public void setUpdIndCd(String updIndCd) {
		this.updIndCd = updIndCd;
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
	 * @param n2ndPod
	 */
	public void setN2ndPod(String n2ndPod) {
		this.n2ndPod = n2ndPod;
	}
	
	/**
	 * Column Info
	 * @param n2ndPodDc
	 */
	public void setN2ndPodDc(String n2ndPodDc) {
		this.n2ndPodDc = n2ndPodDc;
	}
	
	/**
	 * Column Info
	 * @param n4thVvd
	 */
	public void setN4thVvd(String n4thVvd) {
		this.n4thVvd = n4thVvd;
	}
	
	/**
	 * Column Info
	 * @param n3rdVslSlanCd
	 */
	public void setN3rdVslSlanCd(String n3rdVslSlanCd) {
		this.n3rdVslSlanCd = n3rdVslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdPod
	 */
	public void setN3rdPod(String n3rdPod) {
		this.n3rdPod = n3rdPod;
	}
	
	/**
	 * Column Info
	 * @param n4thPodDc
	 */
	public void setN4thPodDc(String n4thPodDc) {
		this.n4thPodDc = n4thPodDc;
	}
	
	/**
	 * Column Info
	 * @param ocnRoutPrioCd
	 */
	public void setOcnRoutPrioCd(String ocnRoutPrioCd) {
		this.ocnRoutPrioCd = ocnRoutPrioCd;
	}
	
	/**
	 * Column Info
	 * @param n1stSpace
	 */
	public void setN1stSpace(String n1stSpace) {
		this.n1stSpace = n1stSpace;
	}
	
	/**
	 * Column Info
	 * @param n3rdSpace
	 */
	public void setN3rdSpace(String n3rdSpace) {
		this.n3rdSpace = n3rdSpace;
	}
	
	/**
	 * Column Info
	 * @param n4thVslSlanCd
	 */
	public void setN4thVslSlanCd(String n4thVslSlanCd) {
		this.n4thVslSlanCd = n4thVslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndVslSlanCd
	 */
	public void setN2ndVslSlanCd(String n2ndVslSlanCd) {
		this.n2ndVslSlanCd = n2ndVslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdPolDc
	 */
	public void setN3rdPolDc(String n3rdPolDc) {
		this.n3rdPolDc = n3rdPolDc;
	}
	
	/**
	 * Column Info
	 * @param n1stSlanCd
	 */
	public void setN1stSlanCd(String n1stSlanCd) {
		this.n1stSlanCd = n1stSlanCd;
	}
	
	/**
	 * Column Info
	 * @param n4thPolN
	 */
	public void setN4thPolN(String n4thPolN) {
		this.n4thPolN = n4thPolN;
	}
	
	/**
	 * Column Info
	 * @param n2ndPol
	 */
	public void setN2ndPol(String n2ndPol) {
		this.n2ndPol = n2ndPol;
	}
	
	/**
	 * Column Info
	 * @param n3rdPol
	 */
	public void setN3rdPol(String n3rdPol) {
		this.n3rdPol = n3rdPol;
	}
	
	/**
	 * Column Info
	 * @param n2ndPolN
	 */
	public void setN2ndPolN(String n2ndPolN) {
		this.n2ndPolN = n2ndPolN;
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
		setN1stPodDc(JSPUtil.getParameter(request, prefix + "n1st_pod_dc", ""));
		setTtlExpnAmt(JSPUtil.getParameter(request, prefix + "ttl_expn_amt", ""));
		setOrgTztmHrs(JSPUtil.getParameter(request, prefix + "org_tztm_hrs", ""));
		setNo(JSPUtil.getParameter(request, prefix + "no", ""));
		setN2ndPodN(JSPUtil.getParameter(request, prefix + "n2nd_pod_n", ""));
		setN3rdPodN(JSPUtil.getParameter(request, prefix + "n3rd_pod_n", ""));
		setN2ndTvvdFlag(JSPUtil.getParameter(request, prefix + "n2nd_tvvd_flag", ""));
		setN4thPolDc(JSPUtil.getParameter(request, prefix + "n4th_pol_dc", ""));
		setTztmHrs(JSPUtil.getParameter(request, prefix + "tztm_hrs", ""));
		setN2ndSpace(JSPUtil.getParameter(request, prefix + "n2nd_space", ""));
		setN4thPod(JSPUtil.getParameter(request, prefix + "n4th_pod", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
		setN4thTvvdFlag(JSPUtil.getParameter(request, prefix + "n4th_tvvd_flag", ""));
		setN4thPodN(JSPUtil.getParameter(request, prefix + "n4th_pod_n", ""));
		setN4thPol(JSPUtil.getParameter(request, prefix + "n4th_pol", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setN2ndVvd(JSPUtil.getParameter(request, prefix + "n2nd_vvd", ""));
		setN2ndPolDc(JSPUtil.getParameter(request, prefix + "n2nd_pol_dc", ""));
		setN3rdTvvdFlag(JSPUtil.getParameter(request, prefix + "n3rd_tvvd_flag", ""));
		setN1stTvvdFlag(JSPUtil.getParameter(request, prefix + "n1st_tvvd_flag", ""));
		setN4thSpace(JSPUtil.getParameter(request, prefix + "n4th_space", ""));
		setN1stPolDc(JSPUtil.getParameter(request, prefix + "n1st_pol_dc", ""));
		setVvdLnkNo(JSPUtil.getParameter(request, prefix + "vvd_lnk_no", ""));
		setN2ndSlanCd(JSPUtil.getParameter(request, prefix + "n2nd_slan_cd", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setN4thSlanCd(JSPUtil.getParameter(request, prefix + "n4th_slan_cd", ""));
		setN1stVvd(JSPUtil.getParameter(request, prefix + "n1st_vvd", ""));
		setOrgLocCd(JSPUtil.getParameter(request, prefix + "org_loc_cd", ""));
		setDestLocCd(JSPUtil.getParameter(request, prefix + "dest_loc_cd", ""));
		setN3rdPolN(JSPUtil.getParameter(request, prefix + "n3rd_pol_n", ""));
		setN3rdVvd(JSPUtil.getParameter(request, prefix + "n3rd_vvd", ""));
		setN3rdSlanCd(JSPUtil.getParameter(request, prefix + "n3rd_slan_cd", ""));
		setN1stPol(JSPUtil.getParameter(request, prefix + "n1st_pol", ""));
		setRk(JSPUtil.getParameter(request, prefix + "rk", ""));
		setOrd(JSPUtil.getParameter(request, prefix + "ord", ""));
		setN1stPodN(JSPUtil.getParameter(request, prefix + "n1st_pod_n", ""));
		setN1stVslSlanCd(JSPUtil.getParameter(request, prefix + "n1st_vsl_slan_cd", ""));
		setN1stPolN(JSPUtil.getParameter(request, prefix + "n1st_pol_n", ""));
		setN1stPod(JSPUtil.getParameter(request, prefix + "n1st_pod", ""));
		setN3rdPodDc(JSPUtil.getParameter(request, prefix + "n3rd_pod_dc", ""));
		setLnkKnt(JSPUtil.getParameter(request, prefix + "lnk_knt", ""));
		setUpdIndCd(JSPUtil.getParameter(request, prefix + "upd_ind_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setN2ndPod(JSPUtil.getParameter(request, prefix + "n2nd_pod", ""));
		setN2ndPodDc(JSPUtil.getParameter(request, prefix + "n2nd_pod_dc", ""));
		setN4thVvd(JSPUtil.getParameter(request, prefix + "n4th_vvd", ""));
		setN3rdVslSlanCd(JSPUtil.getParameter(request, prefix + "n3rd_vsl_slan_cd", ""));
		setN3rdPod(JSPUtil.getParameter(request, prefix + "n3rd_pod", ""));
		setN4thPodDc(JSPUtil.getParameter(request, prefix + "n4th_pod_dc", ""));
		setOcnRoutPrioCd(JSPUtil.getParameter(request, prefix + "ocn_rout_prio_cd", ""));
		setN1stSpace(JSPUtil.getParameter(request, prefix + "n1st_space", ""));
		setN3rdSpace(JSPUtil.getParameter(request, prefix + "n3rd_space", ""));
		setN4thVslSlanCd(JSPUtil.getParameter(request, prefix + "n4th_vsl_slan_cd", ""));
		setN2ndVslSlanCd(JSPUtil.getParameter(request, prefix + "n2nd_vsl_slan_cd", ""));
		setN3rdPolDc(JSPUtil.getParameter(request, prefix + "n3rd_pol_dc", ""));
		setN1stSlanCd(JSPUtil.getParameter(request, prefix + "n1st_slan_cd", ""));
		setN4thPolN(JSPUtil.getParameter(request, prefix + "n4th_pol_n", ""));
		setN2ndPol(JSPUtil.getParameter(request, prefix + "n2nd_pol", ""));
		setN3rdPol(JSPUtil.getParameter(request, prefix + "n3rd_pol", ""));
		setN2ndPolN(JSPUtil.getParameter(request, prefix + "n2nd_pol_n", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SelectPrdOcnRoutVO[]
	 */
	public SelectPrdOcnRoutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SelectPrdOcnRoutVO[]
	 */
	public SelectPrdOcnRoutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SelectPrdOcnRoutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] n1stPodDc = (JSPUtil.getParameter(request, prefix	+ "n1st_pod_dc", length));
			String[] ttlExpnAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_expn_amt", length));
			String[] orgTztmHrs = (JSPUtil.getParameter(request, prefix	+ "org_tztm_hrs", length));
			String[] no = (JSPUtil.getParameter(request, prefix	+ "no", length));
			String[] n2ndPodN = (JSPUtil.getParameter(request, prefix	+ "n2nd_pod_n", length));
			String[] n3rdPodN = (JSPUtil.getParameter(request, prefix	+ "n3rd_pod_n", length));
			String[] n2ndTvvdFlag = (JSPUtil.getParameter(request, prefix	+ "n2nd_tvvd_flag", length));
			String[] n4thPolDc = (JSPUtil.getParameter(request, prefix	+ "n4th_pol_dc", length));
			String[] tztmHrs = (JSPUtil.getParameter(request, prefix	+ "tztm_hrs", length));
			String[] n2ndSpace = (JSPUtil.getParameter(request, prefix	+ "n2nd_space", length));
			String[] n4thPod = (JSPUtil.getParameter(request, prefix	+ "n4th_pod", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] n4thTvvdFlag = (JSPUtil.getParameter(request, prefix	+ "n4th_tvvd_flag", length));
			String[] n4thPodN = (JSPUtil.getParameter(request, prefix	+ "n4th_pod_n", length));
			String[] n4thPol = (JSPUtil.getParameter(request, prefix	+ "n4th_pol", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] n2ndVvd = (JSPUtil.getParameter(request, prefix	+ "n2nd_vvd", length));
			String[] n2ndPolDc = (JSPUtil.getParameter(request, prefix	+ "n2nd_pol_dc", length));
			String[] n3rdTvvdFlag = (JSPUtil.getParameter(request, prefix	+ "n3rd_tvvd_flag", length));
			String[] n1stTvvdFlag = (JSPUtil.getParameter(request, prefix	+ "n1st_tvvd_flag", length));
			String[] n4thSpace = (JSPUtil.getParameter(request, prefix	+ "n4th_space", length));
			String[] n1stPolDc = (JSPUtil.getParameter(request, prefix	+ "n1st_pol_dc", length));
			String[] vvdLnkNo = (JSPUtil.getParameter(request, prefix	+ "vvd_lnk_no", length));
			String[] n2ndSlanCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_slan_cd", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] n4thSlanCd = (JSPUtil.getParameter(request, prefix	+ "n4th_slan_cd", length));
			String[] n1stVvd = (JSPUtil.getParameter(request, prefix	+ "n1st_vvd", length));
			String[] orgLocCd = (JSPUtil.getParameter(request, prefix	+ "org_loc_cd", length));
			String[] destLocCd = (JSPUtil.getParameter(request, prefix	+ "dest_loc_cd", length));
			String[] n3rdPolN = (JSPUtil.getParameter(request, prefix	+ "n3rd_pol_n", length));
			String[] n3rdVvd = (JSPUtil.getParameter(request, prefix	+ "n3rd_vvd", length));
			String[] n3rdSlanCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_slan_cd", length));
			String[] n1stPol = (JSPUtil.getParameter(request, prefix	+ "n1st_pol", length));
			String[] rk = (JSPUtil.getParameter(request, prefix	+ "rk", length));
			String[] ord = (JSPUtil.getParameter(request, prefix	+ "ord", length));
			String[] n1stPodN = (JSPUtil.getParameter(request, prefix	+ "n1st_pod_n", length));
			String[] n1stVslSlanCd = (JSPUtil.getParameter(request, prefix	+ "n1st_vsl_slan_cd", length));
			String[] n1stPolN = (JSPUtil.getParameter(request, prefix	+ "n1st_pol_n", length));
			String[] n1stPod = (JSPUtil.getParameter(request, prefix	+ "n1st_pod", length));
			String[] n3rdPodDc = (JSPUtil.getParameter(request, prefix	+ "n3rd_pod_dc", length));
			String[] lnkKnt = (JSPUtil.getParameter(request, prefix	+ "lnk_knt", length));
			String[] updIndCd = (JSPUtil.getParameter(request, prefix	+ "upd_ind_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] n2ndPod = (JSPUtil.getParameter(request, prefix	+ "n2nd_pod", length));
			String[] n2ndPodDc = (JSPUtil.getParameter(request, prefix	+ "n2nd_pod_dc", length));
			String[] n4thVvd = (JSPUtil.getParameter(request, prefix	+ "n4th_vvd", length));
			String[] n3rdVslSlanCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_vsl_slan_cd", length));
			String[] n3rdPod = (JSPUtil.getParameter(request, prefix	+ "n3rd_pod", length));
			String[] n4thPodDc = (JSPUtil.getParameter(request, prefix	+ "n4th_pod_dc", length));
			String[] ocnRoutPrioCd = (JSPUtil.getParameter(request, prefix	+ "ocn_rout_prio_cd", length));
			String[] n1stSpace = (JSPUtil.getParameter(request, prefix	+ "n1st_space", length));
			String[] n3rdSpace = (JSPUtil.getParameter(request, prefix	+ "n3rd_space", length));
			String[] n4thVslSlanCd = (JSPUtil.getParameter(request, prefix	+ "n4th_vsl_slan_cd", length));
			String[] n2ndVslSlanCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_vsl_slan_cd", length));
			String[] n3rdPolDc = (JSPUtil.getParameter(request, prefix	+ "n3rd_pol_dc", length));
			String[] n1stSlanCd = (JSPUtil.getParameter(request, prefix	+ "n1st_slan_cd", length));
			String[] n4thPolN = (JSPUtil.getParameter(request, prefix	+ "n4th_pol_n", length));
			String[] n2ndPol = (JSPUtil.getParameter(request, prefix	+ "n2nd_pol", length));
			String[] n3rdPol = (JSPUtil.getParameter(request, prefix	+ "n3rd_pol", length));
			String[] n2ndPolN = (JSPUtil.getParameter(request, prefix	+ "n2nd_pol_n", length));
			
			for (int i = 0; i < length; i++) {
				model = new SelectPrdOcnRoutVO();
				if (n1stPodDc[i] != null)
					model.setN1stPodDc(n1stPodDc[i]);
				if (ttlExpnAmt[i] != null)
					model.setTtlExpnAmt(ttlExpnAmt[i]);
				if (orgTztmHrs[i] != null)
					model.setOrgTztmHrs(orgTztmHrs[i]);
				if (no[i] != null)
					model.setNo(no[i]);
				if (n2ndPodN[i] != null)
					model.setN2ndPodN(n2ndPodN[i]);
				if (n3rdPodN[i] != null)
					model.setN3rdPodN(n3rdPodN[i]);
				if (n2ndTvvdFlag[i] != null)
					model.setN2ndTvvdFlag(n2ndTvvdFlag[i]);
				if (n4thPolDc[i] != null)
					model.setN4thPolDc(n4thPolDc[i]);
				if (tztmHrs[i] != null)
					model.setTztmHrs(tztmHrs[i]);
				if (n2ndSpace[i] != null)
					model.setN2ndSpace(n2ndSpace[i]);
				if (n4thPod[i] != null)
					model.setN4thPod(n4thPod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (n4thTvvdFlag[i] != null)
					model.setN4thTvvdFlag(n4thTvvdFlag[i]);
				if (n4thPodN[i] != null)
					model.setN4thPodN(n4thPodN[i]);
				if (n4thPol[i] != null)
					model.setN4thPol(n4thPol[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (n2ndVvd[i] != null)
					model.setN2ndVvd(n2ndVvd[i]);
				if (n2ndPolDc[i] != null)
					model.setN2ndPolDc(n2ndPolDc[i]);
				if (n3rdTvvdFlag[i] != null)
					model.setN3rdTvvdFlag(n3rdTvvdFlag[i]);
				if (n1stTvvdFlag[i] != null)
					model.setN1stTvvdFlag(n1stTvvdFlag[i]);
				if (n4thSpace[i] != null)
					model.setN4thSpace(n4thSpace[i]);
				if (n1stPolDc[i] != null)
					model.setN1stPolDc(n1stPolDc[i]);
				if (vvdLnkNo[i] != null)
					model.setVvdLnkNo(vvdLnkNo[i]);
				if (n2ndSlanCd[i] != null)
					model.setN2ndSlanCd(n2ndSlanCd[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (n4thSlanCd[i] != null)
					model.setN4thSlanCd(n4thSlanCd[i]);
				if (n1stVvd[i] != null)
					model.setN1stVvd(n1stVvd[i]);
				if (orgLocCd[i] != null)
					model.setOrgLocCd(orgLocCd[i]);
				if (destLocCd[i] != null)
					model.setDestLocCd(destLocCd[i]);
				if (n3rdPolN[i] != null)
					model.setN3rdPolN(n3rdPolN[i]);
				if (n3rdVvd[i] != null)
					model.setN3rdVvd(n3rdVvd[i]);
				if (n3rdSlanCd[i] != null)
					model.setN3rdSlanCd(n3rdSlanCd[i]);
				if (n1stPol[i] != null)
					model.setN1stPol(n1stPol[i]);
				if (rk[i] != null)
					model.setRk(rk[i]);
				if (ord[i] != null)
					model.setOrd(ord[i]);
				if (n1stPodN[i] != null)
					model.setN1stPodN(n1stPodN[i]);
				if (n1stVslSlanCd[i] != null)
					model.setN1stVslSlanCd(n1stVslSlanCd[i]);
				if (n1stPolN[i] != null)
					model.setN1stPolN(n1stPolN[i]);
				if (n1stPod[i] != null)
					model.setN1stPod(n1stPod[i]);
				if (n3rdPodDc[i] != null)
					model.setN3rdPodDc(n3rdPodDc[i]);
				if (lnkKnt[i] != null)
					model.setLnkKnt(lnkKnt[i]);
				if (updIndCd[i] != null)
					model.setUpdIndCd(updIndCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (n2ndPod[i] != null)
					model.setN2ndPod(n2ndPod[i]);
				if (n2ndPodDc[i] != null)
					model.setN2ndPodDc(n2ndPodDc[i]);
				if (n4thVvd[i] != null)
					model.setN4thVvd(n4thVvd[i]);
				if (n3rdVslSlanCd[i] != null)
					model.setN3rdVslSlanCd(n3rdVslSlanCd[i]);
				if (n3rdPod[i] != null)
					model.setN3rdPod(n3rdPod[i]);
				if (n4thPodDc[i] != null)
					model.setN4thPodDc(n4thPodDc[i]);
				if (ocnRoutPrioCd[i] != null)
					model.setOcnRoutPrioCd(ocnRoutPrioCd[i]);
				if (n1stSpace[i] != null)
					model.setN1stSpace(n1stSpace[i]);
				if (n3rdSpace[i] != null)
					model.setN3rdSpace(n3rdSpace[i]);
				if (n4thVslSlanCd[i] != null)
					model.setN4thVslSlanCd(n4thVslSlanCd[i]);
				if (n2ndVslSlanCd[i] != null)
					model.setN2ndVslSlanCd(n2ndVslSlanCd[i]);
				if (n3rdPolDc[i] != null)
					model.setN3rdPolDc(n3rdPolDc[i]);
				if (n1stSlanCd[i] != null)
					model.setN1stSlanCd(n1stSlanCd[i]);
				if (n4thPolN[i] != null)
					model.setN4thPolN(n4thPolN[i]);
				if (n2ndPol[i] != null)
					model.setN2ndPol(n2ndPol[i]);
				if (n3rdPol[i] != null)
					model.setN3rdPol(n3rdPol[i]);
				if (n2ndPolN[i] != null)
					model.setN2ndPolN(n2ndPolN[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSelectPrdOcnRoutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SelectPrdOcnRoutVO[]
	 */
	public SelectPrdOcnRoutVO[] getSelectPrdOcnRoutVOs(){
		SelectPrdOcnRoutVO[] vos = (SelectPrdOcnRoutVO[])models.toArray(new SelectPrdOcnRoutVO[models.size()]);
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
		this.n1stPodDc = this.n1stPodDc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlExpnAmt = this.ttlExpnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTztmHrs = this.orgTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.no = this.no .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPodN = this.n2ndPodN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPodN = this.n3rdPodN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTvvdFlag = this.n2ndTvvdFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPolDc = this.n4thPolDc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tztmHrs = this.tztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndSpace = this.n2ndSpace .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPod = this.n4thPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thTvvdFlag = this.n4thTvvdFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPodN = this.n4thPodN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPol = this.n4thPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVvd = this.n2ndVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPolDc = this.n2ndPolDc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdTvvdFlag = this.n3rdTvvdFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTvvdFlag = this.n1stTvvdFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thSpace = this.n4thSpace .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPolDc = this.n1stPolDc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdLnkNo = this.vvdLnkNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndSlanCd = this.n2ndSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thSlanCd = this.n4thSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVvd = this.n1stVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLocCd = this.orgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocCd = this.destLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPolN = this.n3rdPolN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdVvd = this.n3rdVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdSlanCd = this.n3rdSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPol = this.n1stPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rk = this.rk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ord = this.ord .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPodN = this.n1stPodN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVslSlanCd = this.n1stVslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPolN = this.n1stPolN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPod = this.n1stPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPodDc = this.n3rdPodDc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkKnt = this.lnkKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updIndCd = this.updIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPod = this.n2ndPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPodDc = this.n2ndPodDc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thVvd = this.n4thVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdVslSlanCd = this.n3rdVslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPod = this.n3rdPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPodDc = this.n4thPodDc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocnRoutPrioCd = this.ocnRoutPrioCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stSpace = this.n1stSpace .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdSpace = this.n3rdSpace .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thVslSlanCd = this.n4thVslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVslSlanCd = this.n2ndVslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPolDc = this.n3rdPolDc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stSlanCd = this.n1stSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPolN = this.n4thPolN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPol = this.n2ndPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPol = this.n3rdPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPolN = this.n2ndPolN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}