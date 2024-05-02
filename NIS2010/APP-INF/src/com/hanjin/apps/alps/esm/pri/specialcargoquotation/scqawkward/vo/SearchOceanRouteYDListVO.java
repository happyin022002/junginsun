/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchOceanRouteYDListVO.java
*@FileTitle : SearchOceanRouteYDListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.02
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.03.02 송호진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo;

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
 * @author 송호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchOceanRouteYDListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOceanRouteYDListVO> models = new ArrayList<SearchOceanRouteYDListVO>();
	
	/* Column Info */
	private String pol4Yd = null;
	/* Column Info */
	private String pol2Yd = null;
	/* Column Info */
	private String cUser = null;
	/* Column Info */
	private String tztmHrs = null;
	/* Column Info */
	private String tsIndCd = null;
	/* Column Info */
	private String fmtStHrs = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n2ndStayTmHrs = null;
	/* Column Info */
	private String pol1Yd = null;
	/* Column Info */
	private String fUsed = null;
	/* Column Info */
	private String pol3Yd = null;
	/* Column Info */
	private String n3rdStayTmHrs = null;
	/* Column Info */
	private String uDate = null;
	/* Column Info */
	private String n3rdTztmHrs = null;
	/* Column Info */
	private String cDate = null;
	/* Column Info */
	private String pol4 = null;
	/* Column Info */
	private String pol3 = null;
	/* Column Info */
	private String pol2 = null;
	/* Column Info */
	private String pol1 = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String pod2 = null;
	/* Column Info */
	private String uUser = null;
	/* Column Info */
	private String pod1 = null;
	/* Column Info */
	private String pod4 = null;
	/* Column Info */
	private String pod3 = null;
	/* Column Info */
	private String ocnRoutTmpFlg = null;
	/* Column Info */
	private String sRouteNote = null;
	/* Column Info */
	private String n1stStayTmHrs = null;
	/* Column Info */
	private String prio = null;
	/* Column Info */
	private String stHrs = null;
	/* Column Info */
	private String orgLocCd = null;
	/* Column Info */
	private String n1stTztmHrs = null;
	/* Column Info */
	private String destLocCd = null;
	/* Column Info */
	private String ord = null;
	/* Column Info */
	private String pod4Yd = null;
	/* Column Info */
	private String dir3 = null;
	/* Column Info */
	private String dir4 = null;
	/* Column Info */
	private String updIndCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dir1 = null;
	/* Column Info */
	private String dir2 = null;
	/* Column Info */
	private String fdrFlg1 = null;
	/* Column Info */
	private String fdrFlg2 = null;
	/* Column Info */
	private String fdrFlg3 = null;
	/* Column Info */
	private String fdrFlg4 = null;
	/* Column Info */
	private String pod1Yd = null;
	/* Column Info */
	private String rmk = null;
	/* Column Info */
	private String lane4 = null;
	/* Column Info */
	private String svcTp4 = null;
	/* Column Info */
	private String lnkCnt = null;
	/* Column Info */
	private String fmtTztmHrs = null;
	/* Column Info */
	private String pod2Yd = null;
	/* Column Info */
	private String pod3Yd = null;
	/* Column Info */
	private String svcTp2 = null;
	/* Column Info */
	private String lane2 = null;
	/* Column Info */
	private String svcTp3 = null;
	/* Column Info */
	private String lane3 = null;
	/* Column Info */
	private String lane1 = null;
	/* Column Info */
	private String svcTp1 = null;
	/* Column Info */
	private String n2ndTztmHrs = null;
	/* Column Info */
	private String n4thTztmHrs = null;
	/* Column Info */
	private String ocnRoutTmpExpDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchOceanRouteYDListVO() {}

	public SearchOceanRouteYDListVO(String ibflag, String pagerows, String orgLocCd, String destLocCd, String routSeq, String pol1, String pod1, String lane1, String dir1, String fdrFlg1, String svcTp1, String pol2, String pod2, String lane2, String dir2, String fdrFlg2, String svcTp2, String pol3, String pod3, String lane3, String dir3, String fdrFlg3, String svcTp3, String pol4, String pod4, String lane4, String dir4, String fdrFlg4, String svcTp4, String prio, String rmk, String tztmHrs, String fmtTztmHrs, String n1stTztmHrs, String n2ndTztmHrs, String n3rdTztmHrs, String n4thTztmHrs, String stHrs, String fmtStHrs, String n1stStayTmHrs, String n2ndStayTmHrs, String n3rdStayTmHrs, String tsIndCd, String fUsed, String lnkCnt, String updIndCd, String cDate, String cUser, String uDate, String uUser, String ord, String ocnRoutTmpFlg, String ocnRoutTmpExpDt, String sRouteNote, String pol1Yd, String pod1Yd, String pol2Yd, String pod2Yd, String pol3Yd, String pod3Yd, String pol4Yd, String pod4Yd) {
		this.pol4Yd = pol4Yd;
		this.pol2Yd = pol2Yd;
		this.cUser = cUser;
		this.tztmHrs = tztmHrs;
		this.tsIndCd = tsIndCd;
		this.fmtStHrs = fmtStHrs;
		this.pagerows = pagerows;
		this.n2ndStayTmHrs = n2ndStayTmHrs;
		this.pol1Yd = pol1Yd;
		this.fUsed = fUsed;
		this.pol3Yd = pol3Yd;
		this.n3rdStayTmHrs = n3rdStayTmHrs;
		this.uDate = uDate;
		this.n3rdTztmHrs = n3rdTztmHrs;
		this.cDate = cDate;
		this.pol4 = pol4;
		this.pol3 = pol3;
		this.pol2 = pol2;
		this.pol1 = pol1;
		this.routSeq = routSeq;
		this.pod2 = pod2;
		this.uUser = uUser;
		this.pod1 = pod1;
		this.pod4 = pod4;
		this.pod3 = pod3;
		this.ocnRoutTmpFlg = ocnRoutTmpFlg;
		this.sRouteNote = sRouteNote;
		this.n1stStayTmHrs = n1stStayTmHrs;
		this.prio = prio;
		this.stHrs = stHrs;
		this.orgLocCd = orgLocCd;
		this.n1stTztmHrs = n1stTztmHrs;
		this.destLocCd = destLocCd;
		this.ord = ord;
		this.pod4Yd = pod4Yd;
		this.dir3 = dir3;
		this.dir4 = dir4;
		this.updIndCd = updIndCd;
		this.ibflag = ibflag;
		this.dir1 = dir1;
		this.dir2 = dir2;
		this.fdrFlg1 = fdrFlg1;
		this.fdrFlg2 = fdrFlg2;
		this.fdrFlg3 = fdrFlg3;
		this.fdrFlg4 = fdrFlg4;
		this.pod1Yd = pod1Yd;
		this.rmk = rmk;
		this.lane4 = lane4;
		this.svcTp4 = svcTp4;
		this.lnkCnt = lnkCnt;
		this.fmtTztmHrs = fmtTztmHrs;
		this.pod2Yd = pod2Yd;
		this.pod3Yd = pod3Yd;
		this.svcTp2 = svcTp2;
		this.lane2 = lane2;
		this.svcTp3 = svcTp3;
		this.lane3 = lane3;
		this.lane1 = lane1;
		this.svcTp1 = svcTp1;
		this.n2ndTztmHrs = n2ndTztmHrs;
		this.n4thTztmHrs = n4thTztmHrs;
		this.ocnRoutTmpExpDt = ocnRoutTmpExpDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pol4_yd", getPol4Yd());
		this.hashColumns.put("pol2_yd", getPol2Yd());
		this.hashColumns.put("c_user", getCUser());
		this.hashColumns.put("tztm_hrs", getTztmHrs());
		this.hashColumns.put("ts_ind_cd", getTsIndCd());
		this.hashColumns.put("fmt_st_hrs", getFmtStHrs());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n2nd_stay_tm_hrs", getN2ndStayTmHrs());
		this.hashColumns.put("pol1_yd", getPol1Yd());
		this.hashColumns.put("f_used", getFUsed());
		this.hashColumns.put("pol3_yd", getPol3Yd());
		this.hashColumns.put("n3rd_stay_tm_hrs", getN3rdStayTmHrs());
		this.hashColumns.put("u_date", getUDate());
		this.hashColumns.put("n3rd_tztm_hrs", getN3rdTztmHrs());
		this.hashColumns.put("c_date", getCDate());
		this.hashColumns.put("pol4", getPol4());
		this.hashColumns.put("pol3", getPol3());
		this.hashColumns.put("pol2", getPol2());
		this.hashColumns.put("pol1", getPol1());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("pod2", getPod2());
		this.hashColumns.put("u_user", getUUser());
		this.hashColumns.put("pod1", getPod1());
		this.hashColumns.put("pod4", getPod4());
		this.hashColumns.put("pod3", getPod3());
		this.hashColumns.put("ocn_rout_tmp_flg", getOcnRoutTmpFlg());
		this.hashColumns.put("s_route_note", getSRouteNote());
		this.hashColumns.put("n1st_stay_tm_hrs", getN1stStayTmHrs());
		this.hashColumns.put("prio", getPrio());
		this.hashColumns.put("st_hrs", getStHrs());
		this.hashColumns.put("org_loc_cd", getOrgLocCd());
		this.hashColumns.put("n1st_tztm_hrs", getN1stTztmHrs());
		this.hashColumns.put("dest_loc_cd", getDestLocCd());
		this.hashColumns.put("ord", getOrd());
		this.hashColumns.put("pod4_yd", getPod4Yd());
		this.hashColumns.put("dir3", getDir3());
		this.hashColumns.put("dir4", getDir4());
		this.hashColumns.put("upd_ind_cd", getUpdIndCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dir1", getDir1());
		this.hashColumns.put("dir2", getDir2());
		this.hashColumns.put("fdr_flg1", getFdrFlg1());
		this.hashColumns.put("fdr_flg2", getFdrFlg2());
		this.hashColumns.put("fdr_flg3", getFdrFlg3());
		this.hashColumns.put("fdr_flg4", getFdrFlg4());
		this.hashColumns.put("pod1_yd", getPod1Yd());
		this.hashColumns.put("rmk", getRmk());
		this.hashColumns.put("lane4", getLane4());
		this.hashColumns.put("svc_tp4", getSvcTp4());
		this.hashColumns.put("lnk_cnt", getLnkCnt());
		this.hashColumns.put("fmt_tztm_hrs", getFmtTztmHrs());
		this.hashColumns.put("pod2_yd", getPod2Yd());
		this.hashColumns.put("pod3_yd", getPod3Yd());
		this.hashColumns.put("svc_tp2", getSvcTp2());
		this.hashColumns.put("lane2", getLane2());
		this.hashColumns.put("svc_tp3", getSvcTp3());
		this.hashColumns.put("lane3", getLane3());
		this.hashColumns.put("lane1", getLane1());
		this.hashColumns.put("svc_tp1", getSvcTp1());
		this.hashColumns.put("n2nd_tztm_hrs", getN2ndTztmHrs());
		this.hashColumns.put("n4th_tztm_hrs", getN4thTztmHrs());
		this.hashColumns.put("ocn_rout_tmp_exp_dt", getOcnRoutTmpExpDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pol4_yd", "pol4Yd");
		this.hashFields.put("pol2_yd", "pol2Yd");
		this.hashFields.put("c_user", "cUser");
		this.hashFields.put("tztm_hrs", "tztmHrs");
		this.hashFields.put("ts_ind_cd", "tsIndCd");
		this.hashFields.put("fmt_st_hrs", "fmtStHrs");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n2nd_stay_tm_hrs", "n2ndStayTmHrs");
		this.hashFields.put("pol1_yd", "pol1Yd");
		this.hashFields.put("f_used", "fUsed");
		this.hashFields.put("pol3_yd", "pol3Yd");
		this.hashFields.put("n3rd_stay_tm_hrs", "n3rdStayTmHrs");
		this.hashFields.put("u_date", "uDate");
		this.hashFields.put("n3rd_tztm_hrs", "n3rdTztmHrs");
		this.hashFields.put("c_date", "cDate");
		this.hashFields.put("pol4", "pol4");
		this.hashFields.put("pol3", "pol3");
		this.hashFields.put("pol2", "pol2");
		this.hashFields.put("pol1", "pol1");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("pod2", "pod2");
		this.hashFields.put("u_user", "uUser");
		this.hashFields.put("pod1", "pod1");
		this.hashFields.put("pod4", "pod4");
		this.hashFields.put("pod3", "pod3");
		this.hashFields.put("ocn_rout_tmp_flg", "ocnRoutTmpFlg");
		this.hashFields.put("s_route_note", "sRouteNote");
		this.hashFields.put("n1st_stay_tm_hrs", "n1stStayTmHrs");
		this.hashFields.put("prio", "prio");
		this.hashFields.put("st_hrs", "stHrs");
		this.hashFields.put("org_loc_cd", "orgLocCd");
		this.hashFields.put("n1st_tztm_hrs", "n1stTztmHrs");
		this.hashFields.put("dest_loc_cd", "destLocCd");
		this.hashFields.put("ord", "ord");
		this.hashFields.put("pod4_yd", "pod4Yd");
		this.hashFields.put("dir3", "dir3");
		this.hashFields.put("dir4", "dir4");
		this.hashFields.put("upd_ind_cd", "updIndCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dir1", "dir1");
		this.hashFields.put("dir2", "dir2");
		this.hashFields.put("fdr_flg1", "fdrFlg1");
		this.hashFields.put("fdr_flg2", "fdrFlg2");
		this.hashFields.put("fdr_flg3", "fdrFlg3");
		this.hashFields.put("fdr_flg4", "fdrFlg4");
		this.hashFields.put("pod1_yd", "pod1Yd");
		this.hashFields.put("rmk", "rmk");
		this.hashFields.put("lane4", "lane4");
		this.hashFields.put("svc_tp4", "svcTp4");
		this.hashFields.put("lnk_cnt", "lnkCnt");
		this.hashFields.put("fmt_tztm_hrs", "fmtTztmHrs");
		this.hashFields.put("pod2_yd", "pod2Yd");
		this.hashFields.put("pod3_yd", "pod3Yd");
		this.hashFields.put("svc_tp2", "svcTp2");
		this.hashFields.put("lane2", "lane2");
		this.hashFields.put("svc_tp3", "svcTp3");
		this.hashFields.put("lane3", "lane3");
		this.hashFields.put("lane1", "lane1");
		this.hashFields.put("svc_tp1", "svcTp1");
		this.hashFields.put("n2nd_tztm_hrs", "n2ndTztmHrs");
		this.hashFields.put("n4th_tztm_hrs", "n4thTztmHrs");
		this.hashFields.put("ocn_rout_tmp_exp_dt", "ocnRoutTmpExpDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pol4Yd
	 */
	public String getPol4Yd() {
		return this.pol4Yd;
	}
	
	/**
	 * Column Info
	 * @return pol2Yd
	 */
	public String getPol2Yd() {
		return this.pol2Yd;
	}
	
	/**
	 * Column Info
	 * @return cUser
	 */
	public String getCUser() {
		return this.cUser;
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
	 * @return tsIndCd
	 */
	public String getTsIndCd() {
		return this.tsIndCd;
	}
	
	/**
	 * Column Info
	 * @return fmtStHrs
	 */
	public String getFmtStHrs() {
		return this.fmtStHrs;
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
	 * @return n2ndStayTmHrs
	 */
	public String getN2ndStayTmHrs() {
		return this.n2ndStayTmHrs;
	}
	
	/**
	 * Column Info
	 * @return pol1Yd
	 */
	public String getPol1Yd() {
		return this.pol1Yd;
	}
	
	/**
	 * Column Info
	 * @return fUsed
	 */
	public String getFUsed() {
		return this.fUsed;
	}
	
	/**
	 * Column Info
	 * @return pol3Yd
	 */
	public String getPol3Yd() {
		return this.pol3Yd;
	}
	
	/**
	 * Column Info
	 * @return n3rdStayTmHrs
	 */
	public String getN3rdStayTmHrs() {
		return this.n3rdStayTmHrs;
	}
	
	/**
	 * Column Info
	 * @return uDate
	 */
	public String getUDate() {
		return this.uDate;
	}
	
	/**
	 * Column Info
	 * @return n3rdTztmHrs
	 */
	public String getN3rdTztmHrs() {
		return this.n3rdTztmHrs;
	}
	
	/**
	 * Column Info
	 * @return cDate
	 */
	public String getCDate() {
		return this.cDate;
	}
	
	/**
	 * Column Info
	 * @return pol4
	 */
	public String getPol4() {
		return this.pol4;
	}
	
	/**
	 * Column Info
	 * @return pol3
	 */
	public String getPol3() {
		return this.pol3;
	}
	
	/**
	 * Column Info
	 * @return pol2
	 */
	public String getPol2() {
		return this.pol2;
	}
	
	/**
	 * Column Info
	 * @return pol1
	 */
	public String getPol1() {
		return this.pol1;
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
	 * @return pod2
	 */
	public String getPod2() {
		return this.pod2;
	}
	
	/**
	 * Column Info
	 * @return uUser
	 */
	public String getUUser() {
		return this.uUser;
	}
	
	/**
	 * Column Info
	 * @return pod1
	 */
	public String getPod1() {
		return this.pod1;
	}
	
	/**
	 * Column Info
	 * @return pod4
	 */
	public String getPod4() {
		return this.pod4;
	}
	
	/**
	 * Column Info
	 * @return pod3
	 */
	public String getPod3() {
		return this.pod3;
	}
	
	/**
	 * Column Info
	 * @return ocnRoutTmpFlg
	 */
	public String getOcnRoutTmpFlg() {
		return this.ocnRoutTmpFlg;
	}
	
	/**
	 * Column Info
	 * @return sRouteNote
	 */
	public String getSRouteNote() {
		return this.sRouteNote;
	}
	
	/**
	 * Column Info
	 * @return n1stStayTmHrs
	 */
	public String getN1stStayTmHrs() {
		return this.n1stStayTmHrs;
	}
	
	/**
	 * Column Info
	 * @return prio
	 */
	public String getPrio() {
		return this.prio;
	}
	
	/**
	 * Column Info
	 * @return stHrs
	 */
	public String getStHrs() {
		return this.stHrs;
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
	 * @return n1stTztmHrs
	 */
	public String getN1stTztmHrs() {
		return this.n1stTztmHrs;
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
	 * @return ord
	 */
	public String getOrd() {
		return this.ord;
	}
	
	/**
	 * Column Info
	 * @return pod4Yd
	 */
	public String getPod4Yd() {
		return this.pod4Yd;
	}
	
	/**
	 * Column Info
	 * @return dir3
	 */
	public String getDir3() {
		return this.dir3;
	}
	
	/**
	 * Column Info
	 * @return dir4
	 */
	public String getDir4() {
		return this.dir4;
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
	 * @return dir1
	 */
	public String getDir1() {
		return this.dir1;
	}
	
	/**
	 * Column Info
	 * @return dir2
	 */
	public String getDir2() {
		return this.dir2;
	}
	
	/**
	 * Column Info
	 * @return fdrFlg1
	 */
	public String getFdrFlg1() {
		return this.fdrFlg1;
	}
	
	/**
	 * Column Info
	 * @return fdrFlg2
	 */
	public String getFdrFlg2() {
		return this.fdrFlg2;
	}
	
	/**
	 * Column Info
	 * @return fdrFlg3
	 */
	public String getFdrFlg3() {
		return this.fdrFlg3;
	}
	
	/**
	 * Column Info
	 * @return fdrFlg4
	 */
	public String getFdrFlg4() {
		return this.fdrFlg4;
	}
	
	/**
	 * Column Info
	 * @return pod1Yd
	 */
	public String getPod1Yd() {
		return this.pod1Yd;
	}
	
	/**
	 * Column Info
	 * @return rmk
	 */
	public String getRmk() {
		return this.rmk;
	}
	
	/**
	 * Column Info
	 * @return lane4
	 */
	public String getLane4() {
		return this.lane4;
	}
	
	/**
	 * Column Info
	 * @return svcTp4
	 */
	public String getSvcTp4() {
		return this.svcTp4;
	}
	
	/**
	 * Column Info
	 * @return lnkCnt
	 */
	public String getLnkCnt() {
		return this.lnkCnt;
	}
	
	/**
	 * Column Info
	 * @return fmtTztmHrs
	 */
	public String getFmtTztmHrs() {
		return this.fmtTztmHrs;
	}
	
	/**
	 * Column Info
	 * @return pod2Yd
	 */
	public String getPod2Yd() {
		return this.pod2Yd;
	}
	
	/**
	 * Column Info
	 * @return pod3Yd
	 */
	public String getPod3Yd() {
		return this.pod3Yd;
	}
	
	/**
	 * Column Info
	 * @return svcTp2
	 */
	public String getSvcTp2() {
		return this.svcTp2;
	}
	
	/**
	 * Column Info
	 * @return lane2
	 */
	public String getLane2() {
		return this.lane2;
	}
	
	/**
	 * Column Info
	 * @return svcTp3
	 */
	public String getSvcTp3() {
		return this.svcTp3;
	}
	
	/**
	 * Column Info
	 * @return lane3
	 */
	public String getLane3() {
		return this.lane3;
	}
	
	/**
	 * Column Info
	 * @return lane1
	 */
	public String getLane1() {
		return this.lane1;
	}
	
	/**
	 * Column Info
	 * @return svcTp1
	 */
	public String getSvcTp1() {
		return this.svcTp1;
	}
	
	/**
	 * Column Info
	 * @return n2ndTztmHrs
	 */
	public String getN2ndTztmHrs() {
		return this.n2ndTztmHrs;
	}
	
	/**
	 * Column Info
	 * @return n4thTztmHrs
	 */
	public String getN4thTztmHrs() {
		return this.n4thTztmHrs;
	}
	
	/**
	 * Column Info
	 * @return ocnRoutTmpExpDt
	 */
	public String getOcnRoutTmpExpDt() {
		return this.ocnRoutTmpExpDt;
	}
	

	/**
	 * Column Info
	 * @param pol4Yd
	 */
	public void setPol4Yd(String pol4Yd) {
		this.pol4Yd = pol4Yd;
	}
	
	/**
	 * Column Info
	 * @param pol2Yd
	 */
	public void setPol2Yd(String pol2Yd) {
		this.pol2Yd = pol2Yd;
	}
	
	/**
	 * Column Info
	 * @param cUser
	 */
	public void setCUser(String cUser) {
		this.cUser = cUser;
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
	 * @param tsIndCd
	 */
	public void setTsIndCd(String tsIndCd) {
		this.tsIndCd = tsIndCd;
	}
	
	/**
	 * Column Info
	 * @param fmtStHrs
	 */
	public void setFmtStHrs(String fmtStHrs) {
		this.fmtStHrs = fmtStHrs;
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
	 * @param n2ndStayTmHrs
	 */
	public void setN2ndStayTmHrs(String n2ndStayTmHrs) {
		this.n2ndStayTmHrs = n2ndStayTmHrs;
	}
	
	/**
	 * Column Info
	 * @param pol1Yd
	 */
	public void setPol1Yd(String pol1Yd) {
		this.pol1Yd = pol1Yd;
	}
	
	/**
	 * Column Info
	 * @param fUsed
	 */
	public void setFUsed(String fUsed) {
		this.fUsed = fUsed;
	}
	
	/**
	 * Column Info
	 * @param pol3Yd
	 */
	public void setPol3Yd(String pol3Yd) {
		this.pol3Yd = pol3Yd;
	}
	
	/**
	 * Column Info
	 * @param n3rdStayTmHrs
	 */
	public void setN3rdStayTmHrs(String n3rdStayTmHrs) {
		this.n3rdStayTmHrs = n3rdStayTmHrs;
	}
	
	/**
	 * Column Info
	 * @param uDate
	 */
	public void setUDate(String uDate) {
		this.uDate = uDate;
	}
	
	/**
	 * Column Info
	 * @param n3rdTztmHrs
	 */
	public void setN3rdTztmHrs(String n3rdTztmHrs) {
		this.n3rdTztmHrs = n3rdTztmHrs;
	}
	
	/**
	 * Column Info
	 * @param cDate
	 */
	public void setCDate(String cDate) {
		this.cDate = cDate;
	}
	
	/**
	 * Column Info
	 * @param pol4
	 */
	public void setPol4(String pol4) {
		this.pol4 = pol4;
	}
	
	/**
	 * Column Info
	 * @param pol3
	 */
	public void setPol3(String pol3) {
		this.pol3 = pol3;
	}
	
	/**
	 * Column Info
	 * @param pol2
	 */
	public void setPol2(String pol2) {
		this.pol2 = pol2;
	}
	
	/**
	 * Column Info
	 * @param pol1
	 */
	public void setPol1(String pol1) {
		this.pol1 = pol1;
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
	 * @param pod2
	 */
	public void setPod2(String pod2) {
		this.pod2 = pod2;
	}
	
	/**
	 * Column Info
	 * @param uUser
	 */
	public void setUUser(String uUser) {
		this.uUser = uUser;
	}
	
	/**
	 * Column Info
	 * @param pod1
	 */
	public void setPod1(String pod1) {
		this.pod1 = pod1;
	}
	
	/**
	 * Column Info
	 * @param pod4
	 */
	public void setPod4(String pod4) {
		this.pod4 = pod4;
	}
	
	/**
	 * Column Info
	 * @param pod3
	 */
	public void setPod3(String pod3) {
		this.pod3 = pod3;
	}
	
	/**
	 * Column Info
	 * @param ocnRoutTmpFlg
	 */
	public void setOcnRoutTmpFlg(String ocnRoutTmpFlg) {
		this.ocnRoutTmpFlg = ocnRoutTmpFlg;
	}
	
	/**
	 * Column Info
	 * @param sRouteNote
	 */
	public void setSRouteNote(String sRouteNote) {
		this.sRouteNote = sRouteNote;
	}
	
	/**
	 * Column Info
	 * @param n1stStayTmHrs
	 */
	public void setN1stStayTmHrs(String n1stStayTmHrs) {
		this.n1stStayTmHrs = n1stStayTmHrs;
	}
	
	/**
	 * Column Info
	 * @param prio
	 */
	public void setPrio(String prio) {
		this.prio = prio;
	}
	
	/**
	 * Column Info
	 * @param stHrs
	 */
	public void setStHrs(String stHrs) {
		this.stHrs = stHrs;
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
	 * @param n1stTztmHrs
	 */
	public void setN1stTztmHrs(String n1stTztmHrs) {
		this.n1stTztmHrs = n1stTztmHrs;
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
	 * @param ord
	 */
	public void setOrd(String ord) {
		this.ord = ord;
	}
	
	/**
	 * Column Info
	 * @param pod4Yd
	 */
	public void setPod4Yd(String pod4Yd) {
		this.pod4Yd = pod4Yd;
	}
	
	/**
	 * Column Info
	 * @param dir3
	 */
	public void setDir3(String dir3) {
		this.dir3 = dir3;
	}
	
	/**
	 * Column Info
	 * @param dir4
	 */
	public void setDir4(String dir4) {
		this.dir4 = dir4;
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
	 * @param dir1
	 */
	public void setDir1(String dir1) {
		this.dir1 = dir1;
	}
	
	/**
	 * Column Info
	 * @param dir2
	 */
	public void setDir2(String dir2) {
		this.dir2 = dir2;
	}
	
	/**
	 * Column Info
	 * @param fdrFlg1
	 */
	public void setFdrFlg1(String fdrFlg1) {
		this.fdrFlg1 = fdrFlg1;
	}
	
	/**
	 * Column Info
	 * @param fdrFlg2
	 */
	public void setFdrFlg2(String fdrFlg2) {
		this.fdrFlg2 = fdrFlg2;
	}
	
	/**
	 * Column Info
	 * @param fdrFlg3
	 */
	public void setFdrFlg3(String fdrFlg3) {
		this.fdrFlg3 = fdrFlg3;
	}
	
	/**
	 * Column Info
	 * @param fdrFlg4
	 */
	public void setFdrFlg4(String fdrFlg4) {
		this.fdrFlg4 = fdrFlg4;
	}
	
	/**
	 * Column Info
	 * @param pod1Yd
	 */
	public void setPod1Yd(String pod1Yd) {
		this.pod1Yd = pod1Yd;
	}
	
	/**
	 * Column Info
	 * @param rmk
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	
	/**
	 * Column Info
	 * @param lane4
	 */
	public void setLane4(String lane4) {
		this.lane4 = lane4;
	}
	
	/**
	 * Column Info
	 * @param svcTp4
	 */
	public void setSvcTp4(String svcTp4) {
		this.svcTp4 = svcTp4;
	}
	
	/**
	 * Column Info
	 * @param lnkCnt
	 */
	public void setLnkCnt(String lnkCnt) {
		this.lnkCnt = lnkCnt;
	}
	
	/**
	 * Column Info
	 * @param fmtTztmHrs
	 */
	public void setFmtTztmHrs(String fmtTztmHrs) {
		this.fmtTztmHrs = fmtTztmHrs;
	}
	
	/**
	 * Column Info
	 * @param pod2Yd
	 */
	public void setPod2Yd(String pod2Yd) {
		this.pod2Yd = pod2Yd;
	}
	
	/**
	 * Column Info
	 * @param pod3Yd
	 */
	public void setPod3Yd(String pod3Yd) {
		this.pod3Yd = pod3Yd;
	}
	
	/**
	 * Column Info
	 * @param svcTp2
	 */
	public void setSvcTp2(String svcTp2) {
		this.svcTp2 = svcTp2;
	}
	
	/**
	 * Column Info
	 * @param lane2
	 */
	public void setLane2(String lane2) {
		this.lane2 = lane2;
	}
	
	/**
	 * Column Info
	 * @param svcTp3
	 */
	public void setSvcTp3(String svcTp3) {
		this.svcTp3 = svcTp3;
	}
	
	/**
	 * Column Info
	 * @param lane3
	 */
	public void setLane3(String lane3) {
		this.lane3 = lane3;
	}
	
	/**
	 * Column Info
	 * @param lane1
	 */
	public void setLane1(String lane1) {
		this.lane1 = lane1;
	}
	
	/**
	 * Column Info
	 * @param svcTp1
	 */
	public void setSvcTp1(String svcTp1) {
		this.svcTp1 = svcTp1;
	}
	
	/**
	 * Column Info
	 * @param n2ndTztmHrs
	 */
	public void setN2ndTztmHrs(String n2ndTztmHrs) {
		this.n2ndTztmHrs = n2ndTztmHrs;
	}
	
	/**
	 * Column Info
	 * @param n4thTztmHrs
	 */
	public void setN4thTztmHrs(String n4thTztmHrs) {
		this.n4thTztmHrs = n4thTztmHrs;
	}
	
	/**
	 * Column Info
	 * @param ocnRoutTmpExpDt
	 */
	public void setOcnRoutTmpExpDt(String ocnRoutTmpExpDt) {
		this.ocnRoutTmpExpDt = ocnRoutTmpExpDt;
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
		setPol4Yd(JSPUtil.getParameter(request, prefix + "pol4_yd", ""));
		setPol2Yd(JSPUtil.getParameter(request, prefix + "pol2_yd", ""));
		setCUser(JSPUtil.getParameter(request, prefix + "c_user", ""));
		setTztmHrs(JSPUtil.getParameter(request, prefix + "tztm_hrs", ""));
		setTsIndCd(JSPUtil.getParameter(request, prefix + "ts_ind_cd", ""));
		setFmtStHrs(JSPUtil.getParameter(request, prefix + "fmt_st_hrs", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setN2ndStayTmHrs(JSPUtil.getParameter(request, prefix + "n2nd_stay_tm_hrs", ""));
		setPol1Yd(JSPUtil.getParameter(request, prefix + "pol1_yd", ""));
		setFUsed(JSPUtil.getParameter(request, prefix + "f_used", ""));
		setPol3Yd(JSPUtil.getParameter(request, prefix + "pol3_yd", ""));
		setN3rdStayTmHrs(JSPUtil.getParameter(request, prefix + "n3rd_stay_tm_hrs", ""));
		setUDate(JSPUtil.getParameter(request, prefix + "u_date", ""));
		setN3rdTztmHrs(JSPUtil.getParameter(request, prefix + "n3rd_tztm_hrs", ""));
		setCDate(JSPUtil.getParameter(request, prefix + "c_date", ""));
		setPol4(JSPUtil.getParameter(request, prefix + "pol4", ""));
		setPol3(JSPUtil.getParameter(request, prefix + "pol3", ""));
		setPol2(JSPUtil.getParameter(request, prefix + "pol2", ""));
		setPol1(JSPUtil.getParameter(request, prefix + "pol1", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setPod2(JSPUtil.getParameter(request, prefix + "pod2", ""));
		setUUser(JSPUtil.getParameter(request, prefix + "u_user", ""));
		setPod1(JSPUtil.getParameter(request, prefix + "pod1", ""));
		setPod4(JSPUtil.getParameter(request, prefix + "pod4", ""));
		setPod3(JSPUtil.getParameter(request, prefix + "pod3", ""));
		setOcnRoutTmpFlg(JSPUtil.getParameter(request, prefix + "ocn_rout_tmp_flg", ""));
		setSRouteNote(JSPUtil.getParameter(request, prefix + "s_route_note", ""));
		setN1stStayTmHrs(JSPUtil.getParameter(request, prefix + "n1st_stay_tm_hrs", ""));
		setPrio(JSPUtil.getParameter(request, prefix + "prio", ""));
		setStHrs(JSPUtil.getParameter(request, prefix + "st_hrs", ""));
		setOrgLocCd(JSPUtil.getParameter(request, prefix + "org_loc_cd", ""));
		setN1stTztmHrs(JSPUtil.getParameter(request, prefix + "n1st_tztm_hrs", ""));
		setDestLocCd(JSPUtil.getParameter(request, prefix + "dest_loc_cd", ""));
		setOrd(JSPUtil.getParameter(request, prefix + "ord", ""));
		setPod4Yd(JSPUtil.getParameter(request, prefix + "pod4_yd", ""));
		setDir3(JSPUtil.getParameter(request, prefix + "dir3", ""));
		setDir4(JSPUtil.getParameter(request, prefix + "dir4", ""));
		setUpdIndCd(JSPUtil.getParameter(request, prefix + "upd_ind_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDir1(JSPUtil.getParameter(request, prefix + "dir1", ""));
		setDir2(JSPUtil.getParameter(request, prefix + "dir2", ""));
		setFdrFlg1(JSPUtil.getParameter(request, prefix + "fdr_flg1", ""));
		setFdrFlg2(JSPUtil.getParameter(request, prefix + "fdr_flg2", ""));
		setFdrFlg3(JSPUtil.getParameter(request, prefix + "fdr_flg3", ""));
		setFdrFlg4(JSPUtil.getParameter(request, prefix + "fdr_flg4", ""));
		setPod1Yd(JSPUtil.getParameter(request, prefix + "pod1_yd", ""));
		setRmk(JSPUtil.getParameter(request, prefix + "rmk", ""));
		setLane4(JSPUtil.getParameter(request, prefix + "lane4", ""));
		setSvcTp4(JSPUtil.getParameter(request, prefix + "svc_tp4", ""));
		setLnkCnt(JSPUtil.getParameter(request, prefix + "lnk_cnt", ""));
		setFmtTztmHrs(JSPUtil.getParameter(request, prefix + "fmt_tztm_hrs", ""));
		setPod2Yd(JSPUtil.getParameter(request, prefix + "pod2_yd", ""));
		setPod3Yd(JSPUtil.getParameter(request, prefix + "pod3_yd", ""));
		setSvcTp2(JSPUtil.getParameter(request, prefix + "svc_tp2", ""));
		setLane2(JSPUtil.getParameter(request, prefix + "lane2", ""));
		setSvcTp3(JSPUtil.getParameter(request, prefix + "svc_tp3", ""));
		setLane3(JSPUtil.getParameter(request, prefix + "lane3", ""));
		setLane1(JSPUtil.getParameter(request, prefix + "lane1", ""));
		setSvcTp1(JSPUtil.getParameter(request, prefix + "svc_tp1", ""));
		setN2ndTztmHrs(JSPUtil.getParameter(request, prefix + "n2nd_tztm_hrs", ""));
		setN4thTztmHrs(JSPUtil.getParameter(request, prefix + "n4th_tztm_hrs", ""));
		setOcnRoutTmpExpDt(JSPUtil.getParameter(request, prefix + "ocn_rout_tmp_exp_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOceanRouteYDListVO[]
	 */
	public SearchOceanRouteYDListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOceanRouteYDListVO[]
	 */
	public SearchOceanRouteYDListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOceanRouteYDListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pol4Yd = (JSPUtil.getParameter(request, prefix	+ "pol4_yd", length));
			String[] pol2Yd = (JSPUtil.getParameter(request, prefix	+ "pol2_yd", length));
			String[] cUser = (JSPUtil.getParameter(request, prefix	+ "c_user", length));
			String[] tztmHrs = (JSPUtil.getParameter(request, prefix	+ "tztm_hrs", length));
			String[] tsIndCd = (JSPUtil.getParameter(request, prefix	+ "ts_ind_cd", length));
			String[] fmtStHrs = (JSPUtil.getParameter(request, prefix	+ "fmt_st_hrs", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n2ndStayTmHrs = (JSPUtil.getParameter(request, prefix	+ "n2nd_stay_tm_hrs", length));
			String[] pol1Yd = (JSPUtil.getParameter(request, prefix	+ "pol1_yd", length));
			String[] fUsed = (JSPUtil.getParameter(request, prefix	+ "f_used", length));
			String[] pol3Yd = (JSPUtil.getParameter(request, prefix	+ "pol3_yd", length));
			String[] n3rdStayTmHrs = (JSPUtil.getParameter(request, prefix	+ "n3rd_stay_tm_hrs", length));
			String[] uDate = (JSPUtil.getParameter(request, prefix	+ "u_date", length));
			String[] n3rdTztmHrs = (JSPUtil.getParameter(request, prefix	+ "n3rd_tztm_hrs", length));
			String[] cDate = (JSPUtil.getParameter(request, prefix	+ "c_date", length));
			String[] pol4 = (JSPUtil.getParameter(request, prefix	+ "pol4", length));
			String[] pol3 = (JSPUtil.getParameter(request, prefix	+ "pol3", length));
			String[] pol2 = (JSPUtil.getParameter(request, prefix	+ "pol2", length));
			String[] pol1 = (JSPUtil.getParameter(request, prefix	+ "pol1", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] pod2 = (JSPUtil.getParameter(request, prefix	+ "pod2", length));
			String[] uUser = (JSPUtil.getParameter(request, prefix	+ "u_user", length));
			String[] pod1 = (JSPUtil.getParameter(request, prefix	+ "pod1", length));
			String[] pod4 = (JSPUtil.getParameter(request, prefix	+ "pod4", length));
			String[] pod3 = (JSPUtil.getParameter(request, prefix	+ "pod3", length));
			String[] ocnRoutTmpFlg = (JSPUtil.getParameter(request, prefix	+ "ocn_rout_tmp_flg", length));
			String[] sRouteNote = (JSPUtil.getParameter(request, prefix	+ "s_route_note", length));
			String[] n1stStayTmHrs = (JSPUtil.getParameter(request, prefix	+ "n1st_stay_tm_hrs", length));
			String[] prio = (JSPUtil.getParameter(request, prefix	+ "prio", length));
			String[] stHrs = (JSPUtil.getParameter(request, prefix	+ "st_hrs", length));
			String[] orgLocCd = (JSPUtil.getParameter(request, prefix	+ "org_loc_cd", length));
			String[] n1stTztmHrs = (JSPUtil.getParameter(request, prefix	+ "n1st_tztm_hrs", length));
			String[] destLocCd = (JSPUtil.getParameter(request, prefix	+ "dest_loc_cd", length));
			String[] ord = (JSPUtil.getParameter(request, prefix	+ "ord", length));
			String[] pod4Yd = (JSPUtil.getParameter(request, prefix	+ "pod4_yd", length));
			String[] dir3 = (JSPUtil.getParameter(request, prefix	+ "dir3", length));
			String[] dir4 = (JSPUtil.getParameter(request, prefix	+ "dir4", length));
			String[] updIndCd = (JSPUtil.getParameter(request, prefix	+ "upd_ind_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dir1 = (JSPUtil.getParameter(request, prefix	+ "dir1", length));
			String[] dir2 = (JSPUtil.getParameter(request, prefix	+ "dir2", length));
			String[] fdrFlg1 = (JSPUtil.getParameter(request, prefix	+ "fdr_flg1", length));
			String[] fdrFlg2 = (JSPUtil.getParameter(request, prefix	+ "fdr_flg2", length));
			String[] fdrFlg3 = (JSPUtil.getParameter(request, prefix	+ "fdr_flg3", length));
			String[] fdrFlg4 = (JSPUtil.getParameter(request, prefix	+ "fdr_flg4", length));
			String[] pod1Yd = (JSPUtil.getParameter(request, prefix	+ "pod1_yd", length));
			String[] rmk = (JSPUtil.getParameter(request, prefix	+ "rmk", length));
			String[] lane4 = (JSPUtil.getParameter(request, prefix	+ "lane4", length));
			String[] svcTp4 = (JSPUtil.getParameter(request, prefix	+ "svc_tp4", length));
			String[] lnkCnt = (JSPUtil.getParameter(request, prefix	+ "lnk_cnt", length));
			String[] fmtTztmHrs = (JSPUtil.getParameter(request, prefix	+ "fmt_tztm_hrs", length));
			String[] pod2Yd = (JSPUtil.getParameter(request, prefix	+ "pod2_yd", length));
			String[] pod3Yd = (JSPUtil.getParameter(request, prefix	+ "pod3_yd", length));
			String[] svcTp2 = (JSPUtil.getParameter(request, prefix	+ "svc_tp2", length));
			String[] lane2 = (JSPUtil.getParameter(request, prefix	+ "lane2", length));
			String[] svcTp3 = (JSPUtil.getParameter(request, prefix	+ "svc_tp3", length));
			String[] lane3 = (JSPUtil.getParameter(request, prefix	+ "lane3", length));
			String[] lane1 = (JSPUtil.getParameter(request, prefix	+ "lane1", length));
			String[] svcTp1 = (JSPUtil.getParameter(request, prefix	+ "svc_tp1", length));
			String[] n2ndTztmHrs = (JSPUtil.getParameter(request, prefix	+ "n2nd_tztm_hrs", length));
			String[] n4thTztmHrs = (JSPUtil.getParameter(request, prefix	+ "n4th_tztm_hrs", length));
			String[] ocnRoutTmpExpDt = (JSPUtil.getParameter(request, prefix	+ "ocn_rout_tmp_exp_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOceanRouteYDListVO();
				if (pol4Yd[i] != null)
					model.setPol4Yd(pol4Yd[i]);
				if (pol2Yd[i] != null)
					model.setPol2Yd(pol2Yd[i]);
				if (cUser[i] != null)
					model.setCUser(cUser[i]);
				if (tztmHrs[i] != null)
					model.setTztmHrs(tztmHrs[i]);
				if (tsIndCd[i] != null)
					model.setTsIndCd(tsIndCd[i]);
				if (fmtStHrs[i] != null)
					model.setFmtStHrs(fmtStHrs[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n2ndStayTmHrs[i] != null)
					model.setN2ndStayTmHrs(n2ndStayTmHrs[i]);
				if (pol1Yd[i] != null)
					model.setPol1Yd(pol1Yd[i]);
				if (fUsed[i] != null)
					model.setFUsed(fUsed[i]);
				if (pol3Yd[i] != null)
					model.setPol3Yd(pol3Yd[i]);
				if (n3rdStayTmHrs[i] != null)
					model.setN3rdStayTmHrs(n3rdStayTmHrs[i]);
				if (uDate[i] != null)
					model.setUDate(uDate[i]);
				if (n3rdTztmHrs[i] != null)
					model.setN3rdTztmHrs(n3rdTztmHrs[i]);
				if (cDate[i] != null)
					model.setCDate(cDate[i]);
				if (pol4[i] != null)
					model.setPol4(pol4[i]);
				if (pol3[i] != null)
					model.setPol3(pol3[i]);
				if (pol2[i] != null)
					model.setPol2(pol2[i]);
				if (pol1[i] != null)
					model.setPol1(pol1[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (pod2[i] != null)
					model.setPod2(pod2[i]);
				if (uUser[i] != null)
					model.setUUser(uUser[i]);
				if (pod1[i] != null)
					model.setPod1(pod1[i]);
				if (pod4[i] != null)
					model.setPod4(pod4[i]);
				if (pod3[i] != null)
					model.setPod3(pod3[i]);
				if (ocnRoutTmpFlg[i] != null)
					model.setOcnRoutTmpFlg(ocnRoutTmpFlg[i]);
				if (sRouteNote[i] != null)
					model.setSRouteNote(sRouteNote[i]);
				if (n1stStayTmHrs[i] != null)
					model.setN1stStayTmHrs(n1stStayTmHrs[i]);
				if (prio[i] != null)
					model.setPrio(prio[i]);
				if (stHrs[i] != null)
					model.setStHrs(stHrs[i]);
				if (orgLocCd[i] != null)
					model.setOrgLocCd(orgLocCd[i]);
				if (n1stTztmHrs[i] != null)
					model.setN1stTztmHrs(n1stTztmHrs[i]);
				if (destLocCd[i] != null)
					model.setDestLocCd(destLocCd[i]);
				if (ord[i] != null)
					model.setOrd(ord[i]);
				if (pod4Yd[i] != null)
					model.setPod4Yd(pod4Yd[i]);
				if (dir3[i] != null)
					model.setDir3(dir3[i]);
				if (dir4[i] != null)
					model.setDir4(dir4[i]);
				if (updIndCd[i] != null)
					model.setUpdIndCd(updIndCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dir1[i] != null)
					model.setDir1(dir1[i]);
				if (dir2[i] != null)
					model.setDir2(dir2[i]);
				if (fdrFlg1[i] != null)
					model.setFdrFlg1(fdrFlg1[i]);
				if (fdrFlg2[i] != null)
					model.setFdrFlg2(fdrFlg2[i]);
				if (fdrFlg3[i] != null)
					model.setFdrFlg3(fdrFlg3[i]);
				if (fdrFlg4[i] != null)
					model.setFdrFlg4(fdrFlg4[i]);
				if (pod1Yd[i] != null)
					model.setPod1Yd(pod1Yd[i]);
				if (rmk[i] != null)
					model.setRmk(rmk[i]);
				if (lane4[i] != null)
					model.setLane4(lane4[i]);
				if (svcTp4[i] != null)
					model.setSvcTp4(svcTp4[i]);
				if (lnkCnt[i] != null)
					model.setLnkCnt(lnkCnt[i]);
				if (fmtTztmHrs[i] != null)
					model.setFmtTztmHrs(fmtTztmHrs[i]);
				if (pod2Yd[i] != null)
					model.setPod2Yd(pod2Yd[i]);
				if (pod3Yd[i] != null)
					model.setPod3Yd(pod3Yd[i]);
				if (svcTp2[i] != null)
					model.setSvcTp2(svcTp2[i]);
				if (lane2[i] != null)
					model.setLane2(lane2[i]);
				if (svcTp3[i] != null)
					model.setSvcTp3(svcTp3[i]);
				if (lane3[i] != null)
					model.setLane3(lane3[i]);
				if (lane1[i] != null)
					model.setLane1(lane1[i]);
				if (svcTp1[i] != null)
					model.setSvcTp1(svcTp1[i]);
				if (n2ndTztmHrs[i] != null)
					model.setN2ndTztmHrs(n2ndTztmHrs[i]);
				if (n4thTztmHrs[i] != null)
					model.setN4thTztmHrs(n4thTztmHrs[i]);
				if (ocnRoutTmpExpDt[i] != null)
					model.setOcnRoutTmpExpDt(ocnRoutTmpExpDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOceanRouteYDListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOceanRouteYDListVO[]
	 */
	public SearchOceanRouteYDListVO[] getSearchOceanRouteYDListVOs(){
		SearchOceanRouteYDListVO[] vos = (SearchOceanRouteYDListVO[])models.toArray(new SearchOceanRouteYDListVO[models.size()]);
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
		this.pol4Yd = this.pol4Yd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol2Yd = this.pol2Yd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cUser = this.cUser .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tztmHrs = this.tztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsIndCd = this.tsIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtStHrs = this.fmtStHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndStayTmHrs = this.n2ndStayTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol1Yd = this.pol1Yd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fUsed = this.fUsed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol3Yd = this.pol3Yd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdStayTmHrs = this.n3rdStayTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uDate = this.uDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdTztmHrs = this.n3rdTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cDate = this.cDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol4 = this.pol4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol3 = this.pol3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol2 = this.pol2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol1 = this.pol1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod2 = this.pod2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uUser = this.uUser .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod1 = this.pod1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod4 = this.pod4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod3 = this.pod3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocnRoutTmpFlg = this.ocnRoutTmpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRouteNote = this.sRouteNote .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stStayTmHrs = this.n1stStayTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prio = this.prio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stHrs = this.stHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLocCd = this.orgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTztmHrs = this.n1stTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocCd = this.destLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ord = this.ord .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod4Yd = this.pod4Yd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dir3 = this.dir3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dir4 = this.dir4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updIndCd = this.updIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dir1 = this.dir1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dir2 = this.dir2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrFlg1 = this.fdrFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrFlg2 = this.fdrFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrFlg3 = this.fdrFlg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrFlg4 = this.fdrFlg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod1Yd = this.pod1Yd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmk = this.rmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane4 = this.lane4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcTp4 = this.svcTp4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkCnt = this.lnkCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtTztmHrs = this.fmtTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod2Yd = this.pod2Yd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod3Yd = this.pod3Yd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcTp2 = this.svcTp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane2 = this.lane2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcTp3 = this.svcTp3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane3 = this.lane3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane1 = this.lane1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcTp1 = this.svcTp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTztmHrs = this.n2ndTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thTztmHrs = this.n4thTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocnRoutTmpExpDt = this.ocnRoutTmpExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
