/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchOceanRouteSingleCreationVO.java
*@FileTitle : SearchOceanRouteSingleCreationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.16  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo;

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

public class SearchOceanRouteSingleCreationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOceanRouteSingleCreationVO> models = new ArrayList<SearchOceanRouteSingleCreationVO>();
	
	/* Column Info */
	private String sTs3Lane = null;
	/* Column Info */
	private String p1 = null;
	/* Column Info */
	private String fmtTotTt = null;
	/* Column Info */
	private String cUser = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tsInd = null;
	/* Column Info */
	private String st = null;
	/* Column Info */
	private String linkValidFlg = null;
	/* Column Info */
	private String pol2etb = null;
	/* Column Info */
	private String cDate = null;
	/* Column Info */
	private String sTs2Port = null;
	/* Column Info */
	private String pol4 = null;
	/* Column Info */
	private String pol3 = null;
	/* Column Info */
	private String pol2 = null;
	/* Column Info */
	private String fmtTotSt = null;
	/* Column Info */
	private String bkgCnt = null;
	/* Column Info */
	private String pol1 = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String pod2 = null;
	/* Column Info */
	private String sTs1Port = null;
	/* Column Info */
	private String pod1 = null;
	/* Column Info */
	private String tt4 = null;
	/* Column Info */
	private String pod4 = null;
	/* Column Info */
	private String pod3 = null;
	/* Column Info */
	private String tt1 = null;
	/* Column Info */
	private String sPod = null;
	/* Column Info */
	private String tt3 = null;
	/* Column Info */
	private String linkCount = null;
	/* Column Info */
	private String tt2 = null;
	/* Column Info */
	private String prio = null;
	/* Column Info */
	private String sTs1Lane = null;
	/* Column Info */
	private String sPol = null;
	/* Column Info */
	private String tgExist = null;
	/* Column Info */
	private String orgLocCd = null;
	/* Column Info */
	private String destLocCd = null;
	/* Column Info */
	private String pol3etb = null;
	/* Column Info */
	private String st3 = null;
	/* Column Info */
	private String st1 = null;
	/* Column Info */
	private String st2 = null;
	/* Column Info */
	private String dir3 = null;
	/* Column Info */
	private String updIndCd = null;
	/* Column Info */
	private String dir4 = null;
	/* Column Info */
	private String pod2etb = null;
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
	private String pod1etb = null;
	/* Column Info */
	private String fdrFlg4 = null;
	/* Column Info */
	private String totTt = null;
	/* Column Info */
	private String pod3etb = null;
	/* Column Info */
	private String sTs2Lane = null;
	/* Column Info */
	private String bkgInd = null;
	/* Column Info */
	private String rmk = null;
	/* Column Info */
	private String lane4 = null;
	/* Column Info */
	private String svcTp4 = null;
	/* Column Info */
	private String fmtTt = null;
	/* Column Info */
	private String sTs3Port = null;
	/* Column Info */
	private String sTs4Lane = null;
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
	private String fdrUsd = null;
	/* Column Info */
	private String pol4etb = null;
	/* Column Info */
	private String totSt = null;
	/* Column Info */
	private String fullRout = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchOceanRouteSingleCreationVO() {}

	public SearchOceanRouteSingleCreationVO(String ibflag, String pagerows, String st, String orgLocCd, String destLocCd, String pol1, String pod1, String lane1, String dir1, String fdrFlg1, String svcTp1, String pol2, String pod2, String lane2, String dir2, String fdrFlg2, String svcTp2, String pol3, String pod3, String lane3, String dir3, String fdrFlg3, String svcTp3, String pol4, String pod4, String lane4, String dir4, String fdrFlg4, String svcTp4, String prio, String rmk, String totTt, String fmtTotTt, String tt1, String tt2, String tt3, String tt4, String totSt, String fmtTotSt, String st1, String st2, String st3, String tsInd, String fdrUsd, String pod1etb, String pol2etb, String pod2etb, String pol3etb, String pod3etb, String pol4etb, String linkCount, String p1, String bkgInd, String tgExist, String bkgCnt, String updIndCd, String cDate, String cUser, String routSeq, String linkValidFlg, String fmtTt, String sPol, String sPod, String sTs1Port, String sTs2Port, String sTs3Port, String sTs1Lane, String sTs2Lane, String sTs3Lane, String sTs4Lane, String fullRout) {
		this.sTs3Lane = sTs3Lane;
		this.p1 = p1;
		this.fmtTotTt = fmtTotTt;
		this.cUser = cUser;
		this.pagerows = pagerows;
		this.tsInd = tsInd;
		this.st = st;
		this.linkValidFlg = linkValidFlg;
		this.pol2etb = pol2etb;
		this.cDate = cDate;
		this.sTs2Port = sTs2Port;
		this.pol4 = pol4;
		this.pol3 = pol3;
		this.pol2 = pol2;
		this.fmtTotSt = fmtTotSt;
		this.bkgCnt = bkgCnt;
		this.pol1 = pol1;
		this.routSeq = routSeq;
		this.pod2 = pod2;
		this.sTs1Port = sTs1Port;
		this.pod1 = pod1;
		this.tt4 = tt4;
		this.pod4 = pod4;
		this.pod3 = pod3;
		this.tt1 = tt1;
		this.sPod = sPod;
		this.tt3 = tt3;
		this.linkCount = linkCount;
		this.tt2 = tt2;
		this.prio = prio;
		this.sTs1Lane = sTs1Lane;
		this.sPol = sPol;
		this.tgExist = tgExist;
		this.orgLocCd = orgLocCd;
		this.destLocCd = destLocCd;
		this.pol3etb = pol3etb;
		this.st3 = st3;
		this.st1 = st1;
		this.st2 = st2;
		this.dir3 = dir3;
		this.updIndCd = updIndCd;
		this.dir4 = dir4;
		this.pod2etb = pod2etb;
		this.ibflag = ibflag;
		this.dir1 = dir1;
		this.dir2 = dir2;
		this.fdrFlg1 = fdrFlg1;
		this.fdrFlg2 = fdrFlg2;
		this.fdrFlg3 = fdrFlg3;
		this.pod1etb = pod1etb;
		this.fdrFlg4 = fdrFlg4;
		this.totTt = totTt;
		this.pod3etb = pod3etb;
		this.sTs2Lane = sTs2Lane;
		this.bkgInd = bkgInd;
		this.rmk = rmk;
		this.lane4 = lane4;
		this.svcTp4 = svcTp4;
		this.fmtTt = fmtTt;
		this.sTs3Port = sTs3Port;
		this.sTs4Lane = sTs4Lane;
		this.svcTp2 = svcTp2;
		this.lane2 = lane2;
		this.svcTp3 = svcTp3;
		this.lane3 = lane3;
		this.lane1 = lane1;
		this.svcTp1 = svcTp1;
		this.fdrUsd = fdrUsd;
		this.pol4etb = pol4etb;
		this.totSt = totSt;
		this.fullRout = fullRout;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_ts3_lane", getSTs3Lane());
		this.hashColumns.put("p1", getP1());
		this.hashColumns.put("fmt_tot_tt", getFmtTotTt());
		this.hashColumns.put("c_user", getCUser());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ts_ind", getTsInd());
		this.hashColumns.put("st", getSt());
		this.hashColumns.put("link_valid_flg", getLinkValidFlg());
		this.hashColumns.put("pol2etb", getPol2etb());
		this.hashColumns.put("c_date", getCDate());
		this.hashColumns.put("s_ts2_port", getSTs2Port());
		this.hashColumns.put("pol4", getPol4());
		this.hashColumns.put("pol3", getPol3());
		this.hashColumns.put("pol2", getPol2());
		this.hashColumns.put("fmt_tot_st", getFmtTotSt());
		this.hashColumns.put("bkg_cnt", getBkgCnt());
		this.hashColumns.put("pol1", getPol1());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("pod2", getPod2());
		this.hashColumns.put("s_ts1_port", getSTs1Port());
		this.hashColumns.put("pod1", getPod1());
		this.hashColumns.put("tt4", getTt4());
		this.hashColumns.put("pod4", getPod4());
		this.hashColumns.put("pod3", getPod3());
		this.hashColumns.put("tt1", getTt1());
		this.hashColumns.put("s_pod", getSPod());
		this.hashColumns.put("tt3", getTt3());
		this.hashColumns.put("link_count", getLinkCount());
		this.hashColumns.put("tt2", getTt2());
		this.hashColumns.put("prio", getPrio());
		this.hashColumns.put("s_ts1_lane", getSTs1Lane());
		this.hashColumns.put("s_pol", getSPol());
		this.hashColumns.put("tg_exist", getTgExist());
		this.hashColumns.put("org_loc_cd", getOrgLocCd());
		this.hashColumns.put("dest_loc_cd", getDestLocCd());
		this.hashColumns.put("pol3etb", getPol3etb());
		this.hashColumns.put("st3", getSt3());
		this.hashColumns.put("st1", getSt1());
		this.hashColumns.put("st2", getSt2());
		this.hashColumns.put("dir3", getDir3());
		this.hashColumns.put("upd_ind_cd", getUpdIndCd());
		this.hashColumns.put("dir4", getDir4());
		this.hashColumns.put("pod2etb", getPod2etb());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dir1", getDir1());
		this.hashColumns.put("dir2", getDir2());
		this.hashColumns.put("fdr_flg1", getFdrFlg1());
		this.hashColumns.put("fdr_flg2", getFdrFlg2());
		this.hashColumns.put("fdr_flg3", getFdrFlg3());
		this.hashColumns.put("pod1etb", getPod1etb());
		this.hashColumns.put("fdr_flg4", getFdrFlg4());
		this.hashColumns.put("tot_tt", getTotTt());
		this.hashColumns.put("pod3etb", getPod3etb());
		this.hashColumns.put("s_ts2_lane", getSTs2Lane());
		this.hashColumns.put("bkg_ind", getBkgInd());
		this.hashColumns.put("rmk", getRmk());
		this.hashColumns.put("lane4", getLane4());
		this.hashColumns.put("svc_tp4", getSvcTp4());
		this.hashColumns.put("fmt_tt", getFmtTt());
		this.hashColumns.put("s_ts3_port", getSTs3Port());
		this.hashColumns.put("s_ts4_lane", getSTs4Lane());
		this.hashColumns.put("svc_tp2", getSvcTp2());
		this.hashColumns.put("lane2", getLane2());
		this.hashColumns.put("svc_tp3", getSvcTp3());
		this.hashColumns.put("lane3", getLane3());
		this.hashColumns.put("lane1", getLane1());
		this.hashColumns.put("svc_tp1", getSvcTp1());
		this.hashColumns.put("fdr_usd", getFdrUsd());
		this.hashColumns.put("pol4etb", getPol4etb());
		this.hashColumns.put("tot_st", getTotSt());
		this.hashColumns.put("full_rout", getFullRout());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_ts3_lane", "sTs3Lane");
		this.hashFields.put("p1", "p1");
		this.hashFields.put("fmt_tot_tt", "fmtTotTt");
		this.hashFields.put("c_user", "cUser");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ts_ind", "tsInd");
		this.hashFields.put("st", "st");
		this.hashFields.put("link_valid_flg", "linkValidFlg");
		this.hashFields.put("pol2etb", "pol2etb");
		this.hashFields.put("c_date", "cDate");
		this.hashFields.put("s_ts2_port", "sTs2Port");
		this.hashFields.put("pol4", "pol4");
		this.hashFields.put("pol3", "pol3");
		this.hashFields.put("pol2", "pol2");
		this.hashFields.put("fmt_tot_st", "fmtTotSt");
		this.hashFields.put("bkg_cnt", "bkgCnt");
		this.hashFields.put("pol1", "pol1");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("pod2", "pod2");
		this.hashFields.put("s_ts1_port", "sTs1Port");
		this.hashFields.put("pod1", "pod1");
		this.hashFields.put("tt4", "tt4");
		this.hashFields.put("pod4", "pod4");
		this.hashFields.put("pod3", "pod3");
		this.hashFields.put("tt1", "tt1");
		this.hashFields.put("s_pod", "sPod");
		this.hashFields.put("tt3", "tt3");
		this.hashFields.put("link_count", "linkCount");
		this.hashFields.put("tt2", "tt2");
		this.hashFields.put("prio", "prio");
		this.hashFields.put("s_ts1_lane", "sTs1Lane");
		this.hashFields.put("s_pol", "sPol");
		this.hashFields.put("tg_exist", "tgExist");
		this.hashFields.put("org_loc_cd", "orgLocCd");
		this.hashFields.put("dest_loc_cd", "destLocCd");
		this.hashFields.put("pol3etb", "pol3etb");
		this.hashFields.put("st3", "st3");
		this.hashFields.put("st1", "st1");
		this.hashFields.put("st2", "st2");
		this.hashFields.put("dir3", "dir3");
		this.hashFields.put("upd_ind_cd", "updIndCd");
		this.hashFields.put("dir4", "dir4");
		this.hashFields.put("pod2etb", "pod2etb");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dir1", "dir1");
		this.hashFields.put("dir2", "dir2");
		this.hashFields.put("fdr_flg1", "fdrFlg1");
		this.hashFields.put("fdr_flg2", "fdrFlg2");
		this.hashFields.put("fdr_flg3", "fdrFlg3");
		this.hashFields.put("pod1etb", "pod1etb");
		this.hashFields.put("fdr_flg4", "fdrFlg4");
		this.hashFields.put("tot_tt", "totTt");
		this.hashFields.put("pod3etb", "pod3etb");
		this.hashFields.put("s_ts2_lane", "sTs2Lane");
		this.hashFields.put("bkg_ind", "bkgInd");
		this.hashFields.put("rmk", "rmk");
		this.hashFields.put("lane4", "lane4");
		this.hashFields.put("svc_tp4", "svcTp4");
		this.hashFields.put("fmt_tt", "fmtTt");
		this.hashFields.put("s_ts3_port", "sTs3Port");
		this.hashFields.put("s_ts4_lane", "sTs4Lane");
		this.hashFields.put("svc_tp2", "svcTp2");
		this.hashFields.put("lane2", "lane2");
		this.hashFields.put("svc_tp3", "svcTp3");
		this.hashFields.put("lane3", "lane3");
		this.hashFields.put("lane1", "lane1");
		this.hashFields.put("svc_tp1", "svcTp1");
		this.hashFields.put("fdr_usd", "fdrUsd");
		this.hashFields.put("pol4etb", "pol4etb");
		this.hashFields.put("tot_st", "totSt");
		this.hashFields.put("full_rout", "fullRout");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sTs3Lane
	 */
	public String getSTs3Lane() {
		return this.sTs3Lane;
	}
	
	/**
	 * Column Info
	 * @return p1
	 */
	public String getP1() {
		return this.p1;
	}
	
	/**
	 * Column Info
	 * @return fmtTotTt
	 */
	public String getFmtTotTt() {
		return this.fmtTotTt;
	}
	
	/**
	 * Column Info
	 * @return cUser
	 */
	public String getCUser() {
		return this.cUser;
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
	 * @return tsInd
	 */
	public String getTsInd() {
		return this.tsInd;
	}
	
	/**
	 * Column Info
	 * @return st
	 */
	public String getSt() {
		return this.st;
	}
	
	/**
	 * Column Info
	 * @return linkValidFlg
	 */
	public String getLinkValidFlg() {
		return this.linkValidFlg;
	}
	
	/**
	 * Column Info
	 * @return pol2etb
	 */
	public String getPol2etb() {
		return this.pol2etb;
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
	 * @return sTs2Port
	 */
	public String getSTs2Port() {
		return this.sTs2Port;
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
	 * @return fmtTotSt
	 */
	public String getFmtTotSt() {
		return this.fmtTotSt;
	}
	
	/**
	 * Column Info
	 * @return bkgCnt
	 */
	public String getBkgCnt() {
		return this.bkgCnt;
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
	 * @return sTs1Port
	 */
	public String getSTs1Port() {
		return this.sTs1Port;
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
	 * @return tt4
	 */
	public String getTt4() {
		return this.tt4;
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
	 * @return tt1
	 */
	public String getTt1() {
		return this.tt1;
	}
	
	/**
	 * Column Info
	 * @return sPod
	 */
	public String getSPod() {
		return this.sPod;
	}
	
	/**
	 * Column Info
	 * @return tt3
	 */
	public String getTt3() {
		return this.tt3;
	}
	
	/**
	 * Column Info
	 * @return linkCount
	 */
	public String getLinkCount() {
		return this.linkCount;
	}
	
	/**
	 * Column Info
	 * @return tt2
	 */
	public String getTt2() {
		return this.tt2;
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
	 * @return sTs1Lane
	 */
	public String getSTs1Lane() {
		return this.sTs1Lane;
	}
	
	/**
	 * Column Info
	 * @return sPol
	 */
	public String getSPol() {
		return this.sPol;
	}
	
	/**
	 * Column Info
	 * @return tgExist
	 */
	public String getTgExist() {
		return this.tgExist;
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
	 * @return pol3etb
	 */
	public String getPol3etb() {
		return this.pol3etb;
	}
	
	/**
	 * Column Info
	 * @return st3
	 */
	public String getSt3() {
		return this.st3;
	}
	
	/**
	 * Column Info
	 * @return st1
	 */
	public String getSt1() {
		return this.st1;
	}
	
	/**
	 * Column Info
	 * @return st2
	 */
	public String getSt2() {
		return this.st2;
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
	 * @return updIndCd
	 */
	public String getUpdIndCd() {
		return this.updIndCd;
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
	 * @return pod2etb
	 */
	public String getPod2etb() {
		return this.pod2etb;
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
	 * @return pod1etb
	 */
	public String getPod1etb() {
		return this.pod1etb;
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
	 * @return totTt
	 */
	public String getTotTt() {
		return this.totTt;
	}
	
	/**
	 * Column Info
	 * @return pod3etb
	 */
	public String getPod3etb() {
		return this.pod3etb;
	}
	
	/**
	 * Column Info
	 * @return sTs2Lane
	 */
	public String getSTs2Lane() {
		return this.sTs2Lane;
	}
	
	/**
	 * Column Info
	 * @return bkgInd
	 */
	public String getBkgInd() {
		return this.bkgInd;
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
	 * @return fmtTt
	 */
	public String getFmtTt() {
		return this.fmtTt;
	}
	
	/**
	 * Column Info
	 * @return sTs3Port
	 */
	public String getSTs3Port() {
		return this.sTs3Port;
	}
	
	/**
	 * Column Info
	 * @return sTs4Lane
	 */
	public String getSTs4Lane() {
		return this.sTs4Lane;
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
	 * @return fdrUsd
	 */
	public String getFdrUsd() {
		return this.fdrUsd;
	}
	
	/**
	 * Column Info
	 * @return pol4etb
	 */
	public String getPol4etb() {
		return this.pol4etb;
	}
	
	/**
	 * Column Info
	 * @return totSt
	 */
	public String getTotSt() {
		return this.totSt;
	}
	
	/**
	 * Column Info
	 * @return fullRout
	 */
	public String getFullRout() {
		return this.fullRout;
	}
	

	/**
	 * Column Info
	 * @param sTs3Lane
	 */
	public void setSTs3Lane(String sTs3Lane) {
		this.sTs3Lane = sTs3Lane;
	}
	
	/**
	 * Column Info
	 * @param p1
	 */
	public void setP1(String p1) {
		this.p1 = p1;
	}
	
	/**
	 * Column Info
	 * @param fmtTotTt
	 */
	public void setFmtTotTt(String fmtTotTt) {
		this.fmtTotTt = fmtTotTt;
	}
	
	/**
	 * Column Info
	 * @param cUser
	 */
	public void setCUser(String cUser) {
		this.cUser = cUser;
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
	 * @param tsInd
	 */
	public void setTsInd(String tsInd) {
		this.tsInd = tsInd;
	}
	
	/**
	 * Column Info
	 * @param st
	 */
	public void setSt(String st) {
		this.st = st;
	}
	
	/**
	 * Column Info
	 * @param linkValidFlg
	 */
	public void setLinkValidFlg(String linkValidFlg) {
		this.linkValidFlg = linkValidFlg;
	}
	
	/**
	 * Column Info
	 * @param pol2etb
	 */
	public void setPol2etb(String pol2etb) {
		this.pol2etb = pol2etb;
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
	 * @param sTs2Port
	 */
	public void setSTs2Port(String sTs2Port) {
		this.sTs2Port = sTs2Port;
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
	 * @param fmtTotSt
	 */
	public void setFmtTotSt(String fmtTotSt) {
		this.fmtTotSt = fmtTotSt;
	}
	
	/**
	 * Column Info
	 * @param bkgCnt
	 */
	public void setBkgCnt(String bkgCnt) {
		this.bkgCnt = bkgCnt;
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
	 * @param sTs1Port
	 */
	public void setSTs1Port(String sTs1Port) {
		this.sTs1Port = sTs1Port;
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
	 * @param tt4
	 */
	public void setTt4(String tt4) {
		this.tt4 = tt4;
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
	 * @param tt1
	 */
	public void setTt1(String tt1) {
		this.tt1 = tt1;
	}
	
	/**
	 * Column Info
	 * @param sPod
	 */
	public void setSPod(String sPod) {
		this.sPod = sPod;
	}
	
	/**
	 * Column Info
	 * @param tt3
	 */
	public void setTt3(String tt3) {
		this.tt3 = tt3;
	}
	
	/**
	 * Column Info
	 * @param linkCount
	 */
	public void setLinkCount(String linkCount) {
		this.linkCount = linkCount;
	}
	
	/**
	 * Column Info
	 * @param tt2
	 */
	public void setTt2(String tt2) {
		this.tt2 = tt2;
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
	 * @param sTs1Lane
	 */
	public void setSTs1Lane(String sTs1Lane) {
		this.sTs1Lane = sTs1Lane;
	}
	
	/**
	 * Column Info
	 * @param sPol
	 */
	public void setSPol(String sPol) {
		this.sPol = sPol;
	}
	
	/**
	 * Column Info
	 * @param tgExist
	 */
	public void setTgExist(String tgExist) {
		this.tgExist = tgExist;
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
	 * @param pol3etb
	 */
	public void setPol3etb(String pol3etb) {
		this.pol3etb = pol3etb;
	}
	
	/**
	 * Column Info
	 * @param st3
	 */
	public void setSt3(String st3) {
		this.st3 = st3;
	}
	
	/**
	 * Column Info
	 * @param st1
	 */
	public void setSt1(String st1) {
		this.st1 = st1;
	}
	
	/**
	 * Column Info
	 * @param st2
	 */
	public void setSt2(String st2) {
		this.st2 = st2;
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
	 * @param updIndCd
	 */
	public void setUpdIndCd(String updIndCd) {
		this.updIndCd = updIndCd;
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
	 * @param pod2etb
	 */
	public void setPod2etb(String pod2etb) {
		this.pod2etb = pod2etb;
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
	 * @param pod1etb
	 */
	public void setPod1etb(String pod1etb) {
		this.pod1etb = pod1etb;
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
	 * @param totTt
	 */
	public void setTotTt(String totTt) {
		this.totTt = totTt;
	}
	
	/**
	 * Column Info
	 * @param pod3etb
	 */
	public void setPod3etb(String pod3etb) {
		this.pod3etb = pod3etb;
	}
	
	/**
	 * Column Info
	 * @param sTs2Lane
	 */
	public void setSTs2Lane(String sTs2Lane) {
		this.sTs2Lane = sTs2Lane;
	}
	
	/**
	 * Column Info
	 * @param bkgInd
	 */
	public void setBkgInd(String bkgInd) {
		this.bkgInd = bkgInd;
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
	 * @param fmtTt
	 */
	public void setFmtTt(String fmtTt) {
		this.fmtTt = fmtTt;
	}
	
	/**
	 * Column Info
	 * @param sTs3Port
	 */
	public void setSTs3Port(String sTs3Port) {
		this.sTs3Port = sTs3Port;
	}
	
	/**
	 * Column Info
	 * @param sTs4Lane
	 */
	public void setSTs4Lane(String sTs4Lane) {
		this.sTs4Lane = sTs4Lane;
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
	 * @param fdrUsd
	 */
	public void setFdrUsd(String fdrUsd) {
		this.fdrUsd = fdrUsd;
	}
	
	/**
	 * Column Info
	 * @param pol4etb
	 */
	public void setPol4etb(String pol4etb) {
		this.pol4etb = pol4etb;
	}
	
	/**
	 * Column Info
	 * @param totSt
	 */
	public void setTotSt(String totSt) {
		this.totSt = totSt;
	}
	
	/**
	 * Column Info
	 * @param fullRout
	 */
	public void setFullRout(String fullRout) {
		this.fullRout = fullRout;
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
		setSTs3Lane(JSPUtil.getParameter(request, prefix + "s_ts3_lane", ""));
		setP1(JSPUtil.getParameter(request, prefix + "p1", ""));
		setFmtTotTt(JSPUtil.getParameter(request, prefix + "fmt_tot_tt", ""));
		setCUser(JSPUtil.getParameter(request, prefix + "c_user", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTsInd(JSPUtil.getParameter(request, prefix + "ts_ind", ""));
		setSt(JSPUtil.getParameter(request, prefix + "st", ""));
		setLinkValidFlg(JSPUtil.getParameter(request, prefix + "link_valid_flg", ""));
		setPol2etb(JSPUtil.getParameter(request, prefix + "pol2etb", ""));
		setCDate(JSPUtil.getParameter(request, prefix + "c_date", ""));
		setSTs2Port(JSPUtil.getParameter(request, prefix + "s_ts2_port", ""));
		setPol4(JSPUtil.getParameter(request, prefix + "pol4", ""));
		setPol3(JSPUtil.getParameter(request, prefix + "pol3", ""));
		setPol2(JSPUtil.getParameter(request, prefix + "pol2", ""));
		setFmtTotSt(JSPUtil.getParameter(request, prefix + "fmt_tot_st", ""));
		setBkgCnt(JSPUtil.getParameter(request, prefix + "bkg_cnt", ""));
		setPol1(JSPUtil.getParameter(request, prefix + "pol1", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setPod2(JSPUtil.getParameter(request, prefix + "pod2", ""));
		setSTs1Port(JSPUtil.getParameter(request, prefix + "s_ts1_port", ""));
		setPod1(JSPUtil.getParameter(request, prefix + "pod1", ""));
		setTt4(JSPUtil.getParameter(request, prefix + "tt4", ""));
		setPod4(JSPUtil.getParameter(request, prefix + "pod4", ""));
		setPod3(JSPUtil.getParameter(request, prefix + "pod3", ""));
		setTt1(JSPUtil.getParameter(request, prefix + "tt1", ""));
		setSPod(JSPUtil.getParameter(request, prefix + "s_pod", ""));
		setTt3(JSPUtil.getParameter(request, prefix + "tt3", ""));
		setLinkCount(JSPUtil.getParameter(request, prefix + "link_count", ""));
		setTt2(JSPUtil.getParameter(request, prefix + "tt2", ""));
		setPrio(JSPUtil.getParameter(request, prefix + "prio", ""));
		setSTs1Lane(JSPUtil.getParameter(request, prefix + "s_ts1_lane", ""));
		setSPol(JSPUtil.getParameter(request, prefix + "s_pol", ""));
		setTgExist(JSPUtil.getParameter(request, prefix + "tg_exist", ""));
		setOrgLocCd(JSPUtil.getParameter(request, prefix + "org_loc_cd", ""));
		setDestLocCd(JSPUtil.getParameter(request, prefix + "dest_loc_cd", ""));
		setPol3etb(JSPUtil.getParameter(request, prefix + "pol3etb", ""));
		setSt3(JSPUtil.getParameter(request, prefix + "st3", ""));
		setSt1(JSPUtil.getParameter(request, prefix + "st1", ""));
		setSt2(JSPUtil.getParameter(request, prefix + "st2", ""));
		setDir3(JSPUtil.getParameter(request, prefix + "dir3", ""));
		setUpdIndCd(JSPUtil.getParameter(request, prefix + "upd_ind_cd", ""));
		setDir4(JSPUtil.getParameter(request, prefix + "dir4", ""));
		setPod2etb(JSPUtil.getParameter(request, prefix + "pod2etb", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDir1(JSPUtil.getParameter(request, prefix + "dir1", ""));
		setDir2(JSPUtil.getParameter(request, prefix + "dir2", ""));
		setFdrFlg1(JSPUtil.getParameter(request, prefix + "fdr_flg1", ""));
		setFdrFlg2(JSPUtil.getParameter(request, prefix + "fdr_flg2", ""));
		setFdrFlg3(JSPUtil.getParameter(request, prefix + "fdr_flg3", ""));
		setPod1etb(JSPUtil.getParameter(request, prefix + "pod1etb", ""));
		setFdrFlg4(JSPUtil.getParameter(request, prefix + "fdr_flg4", ""));
		setTotTt(JSPUtil.getParameter(request, prefix + "tot_tt", ""));
		setPod3etb(JSPUtil.getParameter(request, prefix + "pod3etb", ""));
		setSTs2Lane(JSPUtil.getParameter(request, prefix + "s_ts2_lane", ""));
		setBkgInd(JSPUtil.getParameter(request, prefix + "bkg_ind", ""));
		setRmk(JSPUtil.getParameter(request, prefix + "rmk", ""));
		setLane4(JSPUtil.getParameter(request, prefix + "lane4", ""));
		setSvcTp4(JSPUtil.getParameter(request, prefix + "svc_tp4", ""));
		setFmtTt(JSPUtil.getParameter(request, prefix + "fmt_tt", ""));
		setSTs3Port(JSPUtil.getParameter(request, prefix + "s_ts3_port", ""));
		setSTs4Lane(JSPUtil.getParameter(request, prefix + "s_ts4_lane", ""));
		setSvcTp2(JSPUtil.getParameter(request, prefix + "svc_tp2", ""));
		setLane2(JSPUtil.getParameter(request, prefix + "lane2", ""));
		setSvcTp3(JSPUtil.getParameter(request, prefix + "svc_tp3", ""));
		setLane3(JSPUtil.getParameter(request, prefix + "lane3", ""));
		setLane1(JSPUtil.getParameter(request, prefix + "lane1", ""));
		setSvcTp1(JSPUtil.getParameter(request, prefix + "svc_tp1", ""));
		setFdrUsd(JSPUtil.getParameter(request, prefix + "fdr_usd", ""));
		setPol4etb(JSPUtil.getParameter(request, prefix + "pol4etb", ""));
		setTotSt(JSPUtil.getParameter(request, prefix + "tot_st", ""));
		setFullRout(JSPUtil.getParameter(request, prefix + "full_rout", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOceanRouteSingleCreationVO[]
	 */
	public SearchOceanRouteSingleCreationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOceanRouteSingleCreationVO[]
	 */
	public SearchOceanRouteSingleCreationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOceanRouteSingleCreationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sTs3Lane = (JSPUtil.getParameter(request, prefix	+ "s_ts3_lane", length));
			String[] p1 = (JSPUtil.getParameter(request, prefix	+ "p1", length));
			String[] fmtTotTt = (JSPUtil.getParameter(request, prefix	+ "fmt_tot_tt", length));
			String[] cUser = (JSPUtil.getParameter(request, prefix	+ "c_user", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tsInd = (JSPUtil.getParameter(request, prefix	+ "ts_ind", length));
			String[] st = (JSPUtil.getParameter(request, prefix	+ "st", length));
			String[] linkValidFlg = (JSPUtil.getParameter(request, prefix	+ "link_valid_flg", length));
			String[] pol2etb = (JSPUtil.getParameter(request, prefix	+ "pol2etb", length));
			String[] cDate = (JSPUtil.getParameter(request, prefix	+ "c_date", length));
			String[] sTs2Port = (JSPUtil.getParameter(request, prefix	+ "s_ts2_port", length));
			String[] pol4 = (JSPUtil.getParameter(request, prefix	+ "pol4", length));
			String[] pol3 = (JSPUtil.getParameter(request, prefix	+ "pol3", length));
			String[] pol2 = (JSPUtil.getParameter(request, prefix	+ "pol2", length));
			String[] fmtTotSt = (JSPUtil.getParameter(request, prefix	+ "fmt_tot_st", length));
			String[] bkgCnt = (JSPUtil.getParameter(request, prefix	+ "bkg_cnt", length));
			String[] pol1 = (JSPUtil.getParameter(request, prefix	+ "pol1", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] pod2 = (JSPUtil.getParameter(request, prefix	+ "pod2", length));
			String[] sTs1Port = (JSPUtil.getParameter(request, prefix	+ "s_ts1_port", length));
			String[] pod1 = (JSPUtil.getParameter(request, prefix	+ "pod1", length));
			String[] tt4 = (JSPUtil.getParameter(request, prefix	+ "tt4", length));
			String[] pod4 = (JSPUtil.getParameter(request, prefix	+ "pod4", length));
			String[] pod3 = (JSPUtil.getParameter(request, prefix	+ "pod3", length));
			String[] tt1 = (JSPUtil.getParameter(request, prefix	+ "tt1", length));
			String[] sPod = (JSPUtil.getParameter(request, prefix	+ "s_pod", length));
			String[] tt3 = (JSPUtil.getParameter(request, prefix	+ "tt3", length));
			String[] linkCount = (JSPUtil.getParameter(request, prefix	+ "link_count", length));
			String[] tt2 = (JSPUtil.getParameter(request, prefix	+ "tt2", length));
			String[] prio = (JSPUtil.getParameter(request, prefix	+ "prio", length));
			String[] sTs1Lane = (JSPUtil.getParameter(request, prefix	+ "s_ts1_lane", length));
			String[] sPol = (JSPUtil.getParameter(request, prefix	+ "s_pol", length));
			String[] tgExist = (JSPUtil.getParameter(request, prefix	+ "tg_exist", length));
			String[] orgLocCd = (JSPUtil.getParameter(request, prefix	+ "org_loc_cd", length));
			String[] destLocCd = (JSPUtil.getParameter(request, prefix	+ "dest_loc_cd", length));
			String[] pol3etb = (JSPUtil.getParameter(request, prefix	+ "pol3etb", length));
			String[] st3 = (JSPUtil.getParameter(request, prefix	+ "st3", length));
			String[] st1 = (JSPUtil.getParameter(request, prefix	+ "st1", length));
			String[] st2 = (JSPUtil.getParameter(request, prefix	+ "st2", length));
			String[] dir3 = (JSPUtil.getParameter(request, prefix	+ "dir3", length));
			String[] updIndCd = (JSPUtil.getParameter(request, prefix	+ "upd_ind_cd", length));
			String[] dir4 = (JSPUtil.getParameter(request, prefix	+ "dir4", length));
			String[] pod2etb = (JSPUtil.getParameter(request, prefix	+ "pod2etb", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dir1 = (JSPUtil.getParameter(request, prefix	+ "dir1", length));
			String[] dir2 = (JSPUtil.getParameter(request, prefix	+ "dir2", length));
			String[] fdrFlg1 = (JSPUtil.getParameter(request, prefix	+ "fdr_flg1", length));
			String[] fdrFlg2 = (JSPUtil.getParameter(request, prefix	+ "fdr_flg2", length));
			String[] fdrFlg3 = (JSPUtil.getParameter(request, prefix	+ "fdr_flg3", length));
			String[] pod1etb = (JSPUtil.getParameter(request, prefix	+ "pod1etb", length));
			String[] fdrFlg4 = (JSPUtil.getParameter(request, prefix	+ "fdr_flg4", length));
			String[] totTt = (JSPUtil.getParameter(request, prefix	+ "tot_tt", length));
			String[] pod3etb = (JSPUtil.getParameter(request, prefix	+ "pod3etb", length));
			String[] sTs2Lane = (JSPUtil.getParameter(request, prefix	+ "s_ts2_lane", length));
			String[] bkgInd = (JSPUtil.getParameter(request, prefix	+ "bkg_ind", length));
			String[] rmk = (JSPUtil.getParameter(request, prefix	+ "rmk", length));
			String[] lane4 = (JSPUtil.getParameter(request, prefix	+ "lane4", length));
			String[] svcTp4 = (JSPUtil.getParameter(request, prefix	+ "svc_tp4", length));
			String[] fmtTt = (JSPUtil.getParameter(request, prefix	+ "fmt_tt", length));
			String[] sTs3Port = (JSPUtil.getParameter(request, prefix	+ "s_ts3_port", length));
			String[] sTs4Lane = (JSPUtil.getParameter(request, prefix	+ "s_ts4_lane", length));
			String[] svcTp2 = (JSPUtil.getParameter(request, prefix	+ "svc_tp2", length));
			String[] lane2 = (JSPUtil.getParameter(request, prefix	+ "lane2", length));
			String[] svcTp3 = (JSPUtil.getParameter(request, prefix	+ "svc_tp3", length));
			String[] lane3 = (JSPUtil.getParameter(request, prefix	+ "lane3", length));
			String[] lane1 = (JSPUtil.getParameter(request, prefix	+ "lane1", length));
			String[] svcTp1 = (JSPUtil.getParameter(request, prefix	+ "svc_tp1", length));
			String[] fdrUsd = (JSPUtil.getParameter(request, prefix	+ "fdr_usd", length));
			String[] pol4etb = (JSPUtil.getParameter(request, prefix	+ "pol4etb", length));
			String[] totSt = (JSPUtil.getParameter(request, prefix	+ "tot_st", length));
			String[] fullRout = (JSPUtil.getParameter(request, prefix	+ "full_rout", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOceanRouteSingleCreationVO();
				if (sTs3Lane[i] != null)
					model.setSTs3Lane(sTs3Lane[i]);
				if (p1[i] != null)
					model.setP1(p1[i]);
				if (fmtTotTt[i] != null)
					model.setFmtTotTt(fmtTotTt[i]);
				if (cUser[i] != null)
					model.setCUser(cUser[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tsInd[i] != null)
					model.setTsInd(tsInd[i]);
				if (st[i] != null)
					model.setSt(st[i]);
				if (linkValidFlg[i] != null)
					model.setLinkValidFlg(linkValidFlg[i]);
				if (pol2etb[i] != null)
					model.setPol2etb(pol2etb[i]);
				if (cDate[i] != null)
					model.setCDate(cDate[i]);
				if (sTs2Port[i] != null)
					model.setSTs2Port(sTs2Port[i]);
				if (pol4[i] != null)
					model.setPol4(pol4[i]);
				if (pol3[i] != null)
					model.setPol3(pol3[i]);
				if (pol2[i] != null)
					model.setPol2(pol2[i]);
				if (fmtTotSt[i] != null)
					model.setFmtTotSt(fmtTotSt[i]);
				if (bkgCnt[i] != null)
					model.setBkgCnt(bkgCnt[i]);
				if (pol1[i] != null)
					model.setPol1(pol1[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (pod2[i] != null)
					model.setPod2(pod2[i]);
				if (sTs1Port[i] != null)
					model.setSTs1Port(sTs1Port[i]);
				if (pod1[i] != null)
					model.setPod1(pod1[i]);
				if (tt4[i] != null)
					model.setTt4(tt4[i]);
				if (pod4[i] != null)
					model.setPod4(pod4[i]);
				if (pod3[i] != null)
					model.setPod3(pod3[i]);
				if (tt1[i] != null)
					model.setTt1(tt1[i]);
				if (sPod[i] != null)
					model.setSPod(sPod[i]);
				if (tt3[i] != null)
					model.setTt3(tt3[i]);
				if (linkCount[i] != null)
					model.setLinkCount(linkCount[i]);
				if (tt2[i] != null)
					model.setTt2(tt2[i]);
				if (prio[i] != null)
					model.setPrio(prio[i]);
				if (sTs1Lane[i] != null)
					model.setSTs1Lane(sTs1Lane[i]);
				if (sPol[i] != null)
					model.setSPol(sPol[i]);
				if (tgExist[i] != null)
					model.setTgExist(tgExist[i]);
				if (orgLocCd[i] != null)
					model.setOrgLocCd(orgLocCd[i]);
				if (destLocCd[i] != null)
					model.setDestLocCd(destLocCd[i]);
				if (pol3etb[i] != null)
					model.setPol3etb(pol3etb[i]);
				if (st3[i] != null)
					model.setSt3(st3[i]);
				if (st1[i] != null)
					model.setSt1(st1[i]);
				if (st2[i] != null)
					model.setSt2(st2[i]);
				if (dir3[i] != null)
					model.setDir3(dir3[i]);
				if (updIndCd[i] != null)
					model.setUpdIndCd(updIndCd[i]);
				if (dir4[i] != null)
					model.setDir4(dir4[i]);
				if (pod2etb[i] != null)
					model.setPod2etb(pod2etb[i]);
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
				if (pod1etb[i] != null)
					model.setPod1etb(pod1etb[i]);
				if (fdrFlg4[i] != null)
					model.setFdrFlg4(fdrFlg4[i]);
				if (totTt[i] != null)
					model.setTotTt(totTt[i]);
				if (pod3etb[i] != null)
					model.setPod3etb(pod3etb[i]);
				if (sTs2Lane[i] != null)
					model.setSTs2Lane(sTs2Lane[i]);
				if (bkgInd[i] != null)
					model.setBkgInd(bkgInd[i]);
				if (rmk[i] != null)
					model.setRmk(rmk[i]);
				if (lane4[i] != null)
					model.setLane4(lane4[i]);
				if (svcTp4[i] != null)
					model.setSvcTp4(svcTp4[i]);
				if (fmtTt[i] != null)
					model.setFmtTt(fmtTt[i]);
				if (sTs3Port[i] != null)
					model.setSTs3Port(sTs3Port[i]);
				if (sTs4Lane[i] != null)
					model.setSTs4Lane(sTs4Lane[i]);
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
				if (fdrUsd[i] != null)
					model.setFdrUsd(fdrUsd[i]);
				if (pol4etb[i] != null)
					model.setPol4etb(pol4etb[i]);
				if (totSt[i] != null)
					model.setTotSt(totSt[i]);
				if (fullRout[i] != null)
					model.setFullRout(fullRout[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOceanRouteSingleCreationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOceanRouteSingleCreationVO[]
	 */
	public SearchOceanRouteSingleCreationVO[] getSearchOceanRouteSingleCreationVOs(){
		SearchOceanRouteSingleCreationVO[] vos = (SearchOceanRouteSingleCreationVO[])models.toArray(new SearchOceanRouteSingleCreationVO[models.size()]);
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
		this.sTs3Lane = this.sTs3Lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p1 = this.p1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtTotTt = this.fmtTotTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cUser = this.cUser .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsInd = this.tsInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st = this.st .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.linkValidFlg = this.linkValidFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol2etb = this.pol2etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cDate = this.cDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs2Port = this.sTs2Port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol4 = this.pol4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol3 = this.pol3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol2 = this.pol2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtTotSt = this.fmtTotSt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCnt = this.bkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol1 = this.pol1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod2 = this.pod2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs1Port = this.sTs1Port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod1 = this.pod1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tt4 = this.tt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod4 = this.pod4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod3 = this.pod3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tt1 = this.tt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPod = this.sPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tt3 = this.tt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.linkCount = this.linkCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tt2 = this.tt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prio = this.prio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs1Lane = this.sTs1Lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPol = this.sPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tgExist = this.tgExist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLocCd = this.orgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocCd = this.destLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol3etb = this.pol3etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st3 = this.st3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1 = this.st1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st2 = this.st2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dir3 = this.dir3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updIndCd = this.updIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dir4 = this.dir4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod2etb = this.pod2etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dir1 = this.dir1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dir2 = this.dir2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrFlg1 = this.fdrFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrFlg2 = this.fdrFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrFlg3 = this.fdrFlg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod1etb = this.pod1etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrFlg4 = this.fdrFlg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totTt = this.totTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod3etb = this.pod3etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs2Lane = this.sTs2Lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgInd = this.bkgInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmk = this.rmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane4 = this.lane4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcTp4 = this.svcTp4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtTt = this.fmtTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs3Port = this.sTs3Port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs4Lane = this.sTs4Lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcTp2 = this.svcTp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane2 = this.lane2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcTp3 = this.svcTp3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane3 = this.lane3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane1 = this.lane1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcTp1 = this.svcTp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrUsd = this.fdrUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol4etb = this.pol4etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSt = this.totSt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullRout = this.fullRout .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
