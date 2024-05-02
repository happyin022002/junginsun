/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ResultChangeStatusVO.java
*@FileTitle : ResultChangeStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.08.12 서창열 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 서창열
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ResultDelayStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ResultDelayStatusVO> models = new ArrayList<ResultDelayStatusVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String boa = null;
	/* Column Info */
	private String wdg = null;
	/* Column Info */
	private String wdh = null;
	/* Column Info */
	private String ieFlg = null;
	/* Column Info */
	private String dlc = null;
	/* Column Info */
	private String wdl = null;
	/* Column Info */
	private String actInpToDt = null;
	/* Column Info */
	private String wda = null;
	/* Column Info */
	private String whm = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String dso = null;
	/* Column Info */
	private String wdc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dbs = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String ontmCnt = null;
	/* Column Info */
	private String wct = null;
	/* Column Info */
	private String wgs = null;
	/* Column Info */
	private String oth = null;
	/* Column Info */
	private String wyc = null;
	/* Column Info */
	private String vhd = null;
	/* Column Info */
	private String cntHrs = null;
	/* Column Info */
	private String callCnt = null;
	/* Column Info */
	private String ctl = null;
	/* Column Info */
	private String actInpFmDt = null;
	/* Column Info */
	private String bwd = null;
	/* Column Info */
	private String dws = null;
	/* Column Info */
	private String grpFlg = null;
	/* Column Info */
	private String ipe = null;
	/* Column Info */
	private String wbw = null;
	/* Column Info */
	private String bwo = null;
	/* Column Info */
	private String bws = null;
	/* Column Info */
	private String pts = null;
	/* Column Info */
	private String mvs = null;
	/* Column Info */
	private String bww = null;
	/* Column Info */
	private String vsp = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String arrDep = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String wsc = null;
	/* Column Info */
	private String xxx = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String laneGrpNm = null;
	/* Column Info */
	private String bds = null;
	/* Column Info */
	private String eng = null;
	/* Column Info */
	private String wts = null;
	/* Column Info */
	private String laneGrp = null;
	/* Column Info */
	private String bpc = null;
	/* Column Info */
	private String dcc = null;
	/* Column Info */
	private String pdt = null;
	/* Column Info */
	private String vdp = null;
	/* Column Info */
	private String psb = null;
	/* Column Info */
	private String ttl = null;
	/* Column Info */
	private String vtr = null;
	/* Column Info */
	private String vds = null;
	/* Column Info */
	private String wdy = null;
	/* Column Info */
	private String bda = null;
	/* Column Info */
	private String wdw = null;
	/* Column Info */
	private String hda = null;
	/* Column Info */
	private String wdt = null;
	/* Column Info */
	private String wls = null;
	/* Column Info */
	private String wds = null;
	/* Column Info */
	private String vad = null;
	/* Column Info */
	private String wlm = null;
	/* Column Info */
	private String intgCdId = null;
	/* Column Info */
	private String grpFlgCd = null;

	/* Column Info */
	private String smt = null;
	private String svd = null;
	private String sda = null;
	private String wad = null;
	private String wpg = null;
	private String wpc = null;
	private String wpv = null;
	private String wmt = null;
	private String wca = null;
	private String wio = null;
	private String wnh = null;
	private String btt = null;
	private String bls = null;
	private String bns = null;
	private String bcw = null;
	private String bcm = null;
	private String brb = null;
	private String bsp = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ResultDelayStatusVO() {}

	public ResultDelayStatusVO(String ibflag, String pagerows, String lane, String cntHrs, String bda, String bds, String boa, String bpc, String bwd, String bwo, String bws, String bww, String ctl, String dbs, String dcc, String dlc, String dso, String dws, String eng, String hda, String ipe, String mvs, String oth, String pdt, String psb, String pts, String vad, String vdp, String vds, String vhd, String vsp, String vtr, String wbw, String wct, String wda, String wdc, String wdg, String wdh, String wdl, String wds, String wdt, String wdw, String wdy, String wgs, String whm, String wlm, String wls, String wsc, String wts, String wyc, String xxx, String ttl, String arrDep, String callCnt, String ontmCnt, String grpFlg, String actInpFmDt, String actInpToDt, String laneGrp, String vslSlanCd, String usrId, String laneGrpNm, String vslCd, String vpsPortCd, String crrCd, String ieFlg, String intgCdId, String grpFlgCd,
			String sbw ,String smt ,String svd ,String sda ,String wad ,String wpg ,String wpc ,String wpv ,String wmt ,String wca ,String wio ,String wnh ,String btt ,String bls ,String bns ,String bcw ,String bcm ,String brb ,String bsp) {
		this.vslCd = vslCd;
		this.boa = boa;
		this.wdg = wdg;
		this.wdh = wdh;
		this.ieFlg = ieFlg;
		this.dlc = dlc;
		this.wdl = wdl;
		this.actInpToDt = actInpToDt;
		this.wda = wda;
		this.whm = whm;
		this.crrCd = crrCd;
		this.dso = dso;
		this.wdc = wdc;
		this.pagerows = pagerows;
		this.dbs = dbs;
		this.vpsPortCd = vpsPortCd;
		this.ontmCnt = ontmCnt;
		this.wct = wct;
		this.wgs = wgs;
		this.oth = oth;
		this.wyc = wyc;
		this.vhd = vhd;
		this.cntHrs = cntHrs;
		this.callCnt = callCnt;
		this.ctl = ctl;
		this.actInpFmDt = actInpFmDt;
		this.bwd = bwd;
		this.dws = dws;
		this.grpFlg = grpFlg;
		this.ipe = ipe;
		this.wbw = wbw;
		this.bwo = bwo;
		this.bws = bws;
		this.pts = pts;
		this.mvs = mvs;
		this.bww = bww;
		this.vsp = vsp;
		this.vslSlanCd = vslSlanCd;
		this.arrDep = arrDep;
		this.lane = lane;
		this.wsc = wsc;
		this.xxx = xxx;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.laneGrpNm = laneGrpNm;
		this.bds = bds;
		this.eng = eng;
		this.wts = wts;
		this.laneGrp = laneGrp;
		this.bpc = bpc;
		this.dcc = dcc;
		this.pdt = pdt;
		this.vdp = vdp;
		this.psb = psb;
		this.ttl = ttl;
		this.vtr = vtr;
		this.vds = vds;
		this.wdy = wdy;
		this.bda = bda;
		this.wdw = wdw;
		this.hda = hda;
		this.wdt = wdt;
		this.wls = wls;
		this.wds = wds;
		this.vad = vad;
		this.wlm = wlm;
		this.intgCdId = intgCdId;
		this.grpFlgCd = grpFlgCd;
		
		this.sbw = sbw;
		this.smt = smt;
		this.svd = svd;
		this.sda = sda;
		this.wad = wad;
		this.wpg = wpg;
		this.wpc = wpc;
		this.wpv = wpv;
		this.wmt = wmt;
		this.wca = wca;
		this.wio = wio;
		this.wnh = wnh;
		this.btt = btt;
		this.bls = bls;
		this.bns = bns;
		this.bcw = bcw;
		this.bcm = bcm;
		this.brb = brb;
		this.bsp = bsp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("boa", getBoa());
		this.hashColumns.put("wdg", getWdg());
		this.hashColumns.put("wdh", getWdh());
		this.hashColumns.put("ie_flg", getIeFlg());
		this.hashColumns.put("dlc", getDlc());
		this.hashColumns.put("wdl", getWdl());
		this.hashColumns.put("act_inp_to_dt", getActInpToDt());
		this.hashColumns.put("wda", getWda());
		this.hashColumns.put("whm", getWhm());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("dso", getDso());
		this.hashColumns.put("wdc", getWdc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dbs", getDbs());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ontm_cnt", getOntmCnt());
		this.hashColumns.put("wct", getWct());
		this.hashColumns.put("wgs", getWgs());
		this.hashColumns.put("oth", getOth());
		this.hashColumns.put("wyc", getWyc());
		this.hashColumns.put("vhd", getVhd());
		this.hashColumns.put("cnt_hrs", getCntHrs());
		this.hashColumns.put("call_cnt", getCallCnt());
		this.hashColumns.put("ctl", getCtl());
		this.hashColumns.put("act_inp_fm_dt", getActInpFmDt());
		this.hashColumns.put("bwd", getBwd());
		this.hashColumns.put("dws", getDws());
		this.hashColumns.put("grp_flg", getGrpFlg());
		this.hashColumns.put("ipe", getIpe());
		this.hashColumns.put("wbw", getWbw());
		this.hashColumns.put("bwo", getBwo());
		this.hashColumns.put("bws", getBws());
		this.hashColumns.put("pts", getPts());
		this.hashColumns.put("mvs", getMvs());
		this.hashColumns.put("bww", getBww());
		this.hashColumns.put("vsp", getVsp());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("arr_dep", getArrDep());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("wsc", getWsc());
		this.hashColumns.put("xxx", getXxx());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("lane_grp_nm", getLaneGrpNm());
		this.hashColumns.put("bds", getBds());
		this.hashColumns.put("eng", getEng());
		this.hashColumns.put("wts", getWts());
		this.hashColumns.put("lane_grp", getLaneGrp());
		this.hashColumns.put("bpc", getBpc());
		this.hashColumns.put("dcc", getDcc());
		this.hashColumns.put("pdt", getPdt());
		this.hashColumns.put("vdp", getVdp());
		this.hashColumns.put("psb", getPsb());
		this.hashColumns.put("ttl", getTtl());
		this.hashColumns.put("vtr", getVtr());
		this.hashColumns.put("vds", getVds());
		this.hashColumns.put("wdy", getWdy());
		this.hashColumns.put("bda", getBda());
		this.hashColumns.put("wdw", getWdw());
		this.hashColumns.put("hda", getHda());
		this.hashColumns.put("wdt", getWdt());
		this.hashColumns.put("wls", getWls());
		this.hashColumns.put("wds", getWds());
		this.hashColumns.put("vad", getVad());
		this.hashColumns.put("wlm", getWlm());
		this.hashColumns.put("intg_cd_id", getIntgCdId());
		this.hashColumns.put("grp_flg_cd", getGrpFlgCd());
		
		this.hashColumns.put("sbw", getSbw());
		this.hashColumns.put("smt", getSmt());
		this.hashColumns.put("svd", getSvd());
		this.hashColumns.put("sda", getSda());
		this.hashColumns.put("wad", getWad());
		this.hashColumns.put("wpg", getWpg());
		this.hashColumns.put("wpc", getWpc());
		this.hashColumns.put("wpv", getWpv());
		this.hashColumns.put("wmt", getWmt());
		this.hashColumns.put("wca", getWca());
		this.hashColumns.put("wio", getWio());
		this.hashColumns.put("wnh", getWnh());
		this.hashColumns.put("btt", getBtt());
		this.hashColumns.put("bls", getBls());
		this.hashColumns.put("bns", getBns());
		this.hashColumns.put("bcw", getBcw());
		this.hashColumns.put("bcm", getBcm());
		this.hashColumns.put("brb", getBrb());
		this.hashColumns.put("bsp", getBsp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("boa", "boa");
		this.hashFields.put("wdg", "wdg");
		this.hashFields.put("wdh", "wdh");
		this.hashFields.put("ie_flg", "ieFlg");
		this.hashFields.put("dlc", "dlc");
		this.hashFields.put("wdl", "wdl");
		this.hashFields.put("act_inp_to_dt", "actInpToDt");
		this.hashFields.put("wda", "wda");
		this.hashFields.put("whm", "whm");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("dso", "dso");
		this.hashFields.put("wdc", "wdc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dbs", "dbs");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ontm_cnt", "ontmCnt");
		this.hashFields.put("wct", "wct");
		this.hashFields.put("wgs", "wgs");
		this.hashFields.put("oth", "oth");
		this.hashFields.put("wyc", "wyc");
		this.hashFields.put("vhd", "vhd");
		this.hashFields.put("cnt_hrs", "cntHrs");
		this.hashFields.put("call_cnt", "callCnt");
		this.hashFields.put("ctl", "ctl");
		this.hashFields.put("act_inp_fm_dt", "actInpFmDt");
		this.hashFields.put("bwd", "bwd");
		this.hashFields.put("dws", "dws");
		this.hashFields.put("grp_flg", "grpFlg");
		this.hashFields.put("ipe", "ipe");
		this.hashFields.put("wbw", "wbw");
		this.hashFields.put("bwo", "bwo");
		this.hashFields.put("bws", "bws");
		this.hashFields.put("pts", "pts");
		this.hashFields.put("mvs", "mvs");
		this.hashFields.put("bww", "bww");
		this.hashFields.put("vsp", "vsp");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("arr_dep", "arrDep");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("wsc", "wsc");
		this.hashFields.put("xxx", "xxx");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("lane_grp_nm", "laneGrpNm");
		this.hashFields.put("bds", "bds");
		this.hashFields.put("eng", "eng");
		this.hashFields.put("wts", "wts");
		this.hashFields.put("lane_grp", "laneGrp");
		this.hashFields.put("bpc", "bpc");
		this.hashFields.put("dcc", "dcc");
		this.hashFields.put("pdt", "pdt");
		this.hashFields.put("vdp", "vdp");
		this.hashFields.put("psb", "psb");
		this.hashFields.put("ttl", "ttl");
		this.hashFields.put("vtr", "vtr");
		this.hashFields.put("vds", "vds");
		this.hashFields.put("wdy", "wdy");
		this.hashFields.put("bda", "bda");
		this.hashFields.put("wdw", "wdw");
		this.hashFields.put("hda", "hda");
		this.hashFields.put("wdt", "wdt");
		this.hashFields.put("wls", "wls");
		this.hashFields.put("wds", "wds");
		this.hashFields.put("vad", "vad");
		this.hashFields.put("wlm", "wlm");
		this.hashFields.put("intg_cd_id", "intgCdId");
		this.hashFields.put("grp_flg_cd", "grpFlgCd");
		
		this.hashFields.put("sbw", "sbw");
		this.hashFields.put("smt", "smt");
		this.hashFields.put("svd", "svd");
		this.hashFields.put("sda", "sda");
		this.hashFields.put("wad", "wad");
		this.hashFields.put("wpg", "wpg");
		this.hashFields.put("wpc", "wpc");
		this.hashFields.put("wpv", "wpv");
		this.hashFields.put("wmt", "wmt");
		this.hashFields.put("wca", "wca");
		this.hashFields.put("wio", "wio");
		this.hashFields.put("wnh", "wnh");
		this.hashFields.put("btt", "btt");
		this.hashFields.put("bls", "bls");
		this.hashFields.put("bns", "bns");
		this.hashFields.put("bcw", "bcw");
		this.hashFields.put("bcm", "bcm");
		this.hashFields.put("brb", "brb");
		this.hashFields.put("bsp", "bsp");

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
	 * @return boa
	 */
	public String getBoa() {
		return this.boa;
	}
	
	/**
	 * Column Info
	 * @return wdg
	 */
	public String getWdg() {
		return this.wdg;
	}
	
	/**
	 * Column Info
	 * @return wdh
	 */
	public String getWdh() {
		return this.wdh;
	}
	
	/**
	 * Column Info
	 * @return ieFlg
	 */
	public String getIeFlg() {
		return this.ieFlg;
	}
	
	/**
	 * Column Info
	 * @return dlc
	 */
	public String getDlc() {
		return this.dlc;
	}
	
	/**
	 * Column Info
	 * @return wdl
	 */
	public String getWdl() {
		return this.wdl;
	}
	
	/**
	 * Column Info
	 * @return actInpToDt
	 */
	public String getActInpToDt() {
		return this.actInpToDt;
	}
	
	/**
	 * Column Info
	 * @return wda
	 */
	public String getWda() {
		return this.wda;
	}
	
	/**
	 * Column Info
	 * @return whm
	 */
	public String getWhm() {
		return this.whm;
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
	 * @return dso
	 */
	public String getDso() {
		return this.dso;
	}
	
	/**
	 * Column Info
	 * @return wdc
	 */
	public String getWdc() {
		return this.wdc;
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
	 * @return dbs
	 */
	public String getDbs() {
		return this.dbs;
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
	 * @return ontmCnt
	 */
	public String getOntmCnt() {
		return this.ontmCnt;
	}
	
	/**
	 * Column Info
	 * @return wct
	 */
	public String getWct() {
		return this.wct;
	}
	
	/**
	 * Column Info
	 * @return wgs
	 */
	public String getWgs() {
		return this.wgs;
	}
	
	/**
	 * Column Info
	 * @return oth
	 */
	public String getOth() {
		return this.oth;
	}
	
	/**
	 * Column Info
	 * @return wyc
	 */
	public String getWyc() {
		return this.wyc;
	}
	
	/**
	 * Column Info
	 * @return vhd
	 */
	public String getVhd() {
		return this.vhd;
	}
	
	/**
	 * Column Info
	 * @return cntHrs
	 */
	public String getCntHrs() {
		return this.cntHrs;
	}
	
	/**
	 * Column Info
	 * @return callCnt
	 */
	public String getCallCnt() {
		return this.callCnt;
	}
	
	/**
	 * Column Info
	 * @return ctl
	 */
	public String getCtl() {
		return this.ctl;
	}
	
	/**
	 * Column Info
	 * @return actInpFmDt
	 */
	public String getActInpFmDt() {
		return this.actInpFmDt;
	}
	
	/**
	 * Column Info
	 * @return bwd
	 */
	public String getBwd() {
		return this.bwd;
	}
	
	/**
	 * Column Info
	 * @return dws
	 */
	public String getDws() {
		return this.dws;
	}
	
	/**
	 * Column Info
	 * @return grpFlg
	 */
	public String getGrpFlg() {
		return this.grpFlg;
	}
	
	/**
	 * Column Info
	 * @return ipe
	 */
	public String getIpe() {
		return this.ipe;
	}
	
	/**
	 * Column Info
	 * @return wbw
	 */
	public String getWbw() {
		return this.wbw;
	}
	
	/**
	 * Column Info
	 * @return bwo
	 */
	public String getBwo() {
		return this.bwo;
	}
	
	/**
	 * Column Info
	 * @return bws
	 */
	public String getBws() {
		return this.bws;
	}
	
	/**
	 * Column Info
	 * @return pts
	 */
	public String getPts() {
		return this.pts;
	}
	
	/**
	 * Column Info
	 * @return mvs
	 */
	public String getMvs() {
		return this.mvs;
	}
	
	/**
	 * Column Info
	 * @return bww
	 */
	public String getBww() {
		return this.bww;
	}
	
	/**
	 * Column Info
	 * @return vsp
	 */
	public String getVsp() {
		return this.vsp;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return arrDep
	 */
	public String getArrDep() {
		return this.arrDep;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}
	
	/**
	 * Column Info
	 * @return wsc
	 */
	public String getWsc() {
		return this.wsc;
	}
	
	/**
	 * Column Info
	 * @return xxx
	 */
	public String getXxx() {
		return this.xxx;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return laneGrpNm
	 */
	public String getLaneGrpNm() {
		return this.laneGrpNm;
	}
	
	/**
	 * Column Info
	 * @return bds
	 */
	public String getBds() {
		return this.bds;
	}
	
	/**
	 * Column Info
	 * @return eng
	 */
	public String getEng() {
		return this.eng;
	}
	
	/**
	 * Column Info
	 * @return wts
	 */
	public String getWts() {
		return this.wts;
	}
	
	/**
	 * Column Info
	 * @return laneGrp
	 */
	public String getLaneGrp() {
		return this.laneGrp;
	}
	
	/**
	 * Column Info
	 * @return bpc
	 */
	public String getBpc() {
		return this.bpc;
	}
	
	/**
	 * Column Info
	 * @return dcc
	 */
	public String getDcc() {
		return this.dcc;
	}
	
	/**
	 * Column Info
	 * @return pdt
	 */
	public String getPdt() {
		return this.pdt;
	}
	
	/**
	 * Column Info
	 * @return vdp
	 */
	public String getVdp() {
		return this.vdp;
	}
	
	/**
	 * Column Info
	 * @return psb
	 */
	public String getPsb() {
		return this.psb;
	}
	
	/**
	 * Column Info
	 * @return ttl
	 */
	public String getTtl() {
		return this.ttl;
	}
	
	/**
	 * Column Info
	 * @return vtr
	 */
	public String getVtr() {
		return this.vtr;
	}
	
	/**
	 * Column Info
	 * @return vds
	 */
	public String getVds() {
		return this.vds;
	}
	
	/**
	 * Column Info
	 * @return wdy
	 */
	public String getWdy() {
		return this.wdy;
	}
	
	/**
	 * Column Info
	 * @return bda
	 */
	public String getBda() {
		return this.bda;
	}
	
	/**
	 * Column Info
	 * @return wdw
	 */
	public String getWdw() {
		return this.wdw;
	}
	
	/**
	 * Column Info
	 * @return hda
	 */
	public String getHda() {
		return this.hda;
	}
	
	/**
	 * Column Info
	 * @return wdt
	 */
	public String getWdt() {
		return this.wdt;
	}
	
	/**
	 * Column Info
	 * @return wls
	 */
	public String getWls() {
		return this.wls;
	}
	
	/**
	 * Column Info
	 * @return wds
	 */
	public String getWds() {
		return this.wds;
	}
	
	/**
	 * Column Info
	 * @return vad
	 */
	public String getVad() {
		return this.vad;
	}
	
	/**
	 * Column Info
	 * @return wlm
	 */
	public String getWlm() {
		return this.wlm;
	}
	
	/**
	 * Column Info
	 * @return wlm
	 */
	public String getIntgCdId() {
		return this.intgCdId;
	}
	
	/**
	 * Column Info
	 * @return wlm
	 */
	public String getGrpFlgCd() {
		return this.grpFlgCd;
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
	 * @param boa
	 */
	public void setBoa(String boa) {
		this.boa = boa;
	}
	
	/**
	 * Column Info
	 * @param wdg
	 */
	public void setWdg(String wdg) {
		this.wdg = wdg;
	}
	
	/**
	 * Column Info
	 * @param wdh
	 */
	public void setWdh(String wdh) {
		this.wdh = wdh;
	}
	
	/**
	 * Column Info
	 * @param ieFlg
	 */
	public void setIeFlg(String ieFlg) {
		this.ieFlg = ieFlg;
	}
	
	/**
	 * Column Info
	 * @param dlc
	 */
	public void setDlc(String dlc) {
		this.dlc = dlc;
	}
	
	/**
	 * Column Info
	 * @param wdl
	 */
	public void setWdl(String wdl) {
		this.wdl = wdl;
	}
	
	/**
	 * Column Info
	 * @param actInpToDt
	 */
	public void setActInpToDt(String actInpToDt) {
		this.actInpToDt = actInpToDt;
	}
	
	/**
	 * Column Info
	 * @param wda
	 */
	public void setWda(String wda) {
		this.wda = wda;
	}
	
	/**
	 * Column Info
	 * @param whm
	 */
	public void setWhm(String whm) {
		this.whm = whm;
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
	 * @param dso
	 */
	public void setDso(String dso) {
		this.dso = dso;
	}
	
	/**
	 * Column Info
	 * @param wdc
	 */
	public void setWdc(String wdc) {
		this.wdc = wdc;
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
	 * @param dbs
	 */
	public void setDbs(String dbs) {
		this.dbs = dbs;
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
	 * @param ontmCnt
	 */
	public void setOntmCnt(String ontmCnt) {
		this.ontmCnt = ontmCnt;
	}
	
	/**
	 * Column Info
	 * @param wct
	 */
	public void setWct(String wct) {
		this.wct = wct;
	}
	
	/**
	 * Column Info
	 * @param wgs
	 */
	public void setWgs(String wgs) {
		this.wgs = wgs;
	}
	
	/**
	 * Column Info
	 * @param oth
	 */
	public void setOth(String oth) {
		this.oth = oth;
	}
	
	/**
	 * Column Info
	 * @param wyc
	 */
	public void setWyc(String wyc) {
		this.wyc = wyc;
	}
	
	/**
	 * Column Info
	 * @param vhd
	 */
	public void setVhd(String vhd) {
		this.vhd = vhd;
	}
	
	/**
	 * Column Info
	 * @param cntHrs
	 */
	public void setCntHrs(String cntHrs) {
		this.cntHrs = cntHrs;
	}
	
	/**
	 * Column Info
	 * @param callCnt
	 */
	public void setCallCnt(String callCnt) {
		this.callCnt = callCnt;
	}
	
	/**
	 * Column Info
	 * @param ctl
	 */
	public void setCtl(String ctl) {
		this.ctl = ctl;
	}
	
	/**
	 * Column Info
	 * @param actInpFmDt
	 */
	public void setActInpFmDt(String actInpFmDt) {
		this.actInpFmDt = actInpFmDt;
	}
	
	/**
	 * Column Info
	 * @param bwd
	 */
	public void setBwd(String bwd) {
		this.bwd = bwd;
	}
	
	/**
	 * Column Info
	 * @param dws
	 */
	public void setDws(String dws) {
		this.dws = dws;
	}
	
	/**
	 * Column Info
	 * @param grpFlg
	 */
	public void setGrpFlg(String grpFlg) {
		this.grpFlg = grpFlg;
	}
	
	/**
	 * Column Info
	 * @param ipe
	 */
	public void setIpe(String ipe) {
		this.ipe = ipe;
	}
	
	/**
	 * Column Info
	 * @param wbw
	 */
	public void setWbw(String wbw) {
		this.wbw = wbw;
	}
	
	/**
	 * Column Info
	 * @param bwo
	 */
	public void setBwo(String bwo) {
		this.bwo = bwo;
	}
	
	/**
	 * Column Info
	 * @param bws
	 */
	public void setBws(String bws) {
		this.bws = bws;
	}
	
	/**
	 * Column Info
	 * @param pts
	 */
	public void setPts(String pts) {
		this.pts = pts;
	}
	
	/**
	 * Column Info
	 * @param mvs
	 */
	public void setMvs(String mvs) {
		this.mvs = mvs;
	}
	
	/**
	 * Column Info
	 * @param bww
	 */
	public void setBww(String bww) {
		this.bww = bww;
	}
	
	/**
	 * Column Info
	 * @param vsp
	 */
	public void setVsp(String vsp) {
		this.vsp = vsp;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param arrDep
	 */
	public void setArrDep(String arrDep) {
		this.arrDep = arrDep;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Column Info
	 * @param wsc
	 */
	public void setWsc(String wsc) {
		this.wsc = wsc;
	}
	
	/**
	 * Column Info
	 * @param xxx
	 */
	public void setXxx(String xxx) {
		this.xxx = xxx;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param laneGrpNm
	 */
	public void setLaneGrpNm(String laneGrpNm) {
		this.laneGrpNm = laneGrpNm;
	}
	
	/**
	 * Column Info
	 * @param bds
	 */
	public void setBds(String bds) {
		this.bds = bds;
	}
	
	/**
	 * Column Info
	 * @param eng
	 */
	public void setEng(String eng) {
		this.eng = eng;
	}
	
	/**
	 * Column Info
	 * @param wts
	 */
	public void setWts(String wts) {
		this.wts = wts;
	}
	
	/**
	 * Column Info
	 * @param laneGrp
	 */
	public void setLaneGrp(String laneGrp) {
		this.laneGrp = laneGrp;
	}
	
	/**
	 * Column Info
	 * @param bpc
	 */
	public void setBpc(String bpc) {
		this.bpc = bpc;
	}
	
	/**
	 * Column Info
	 * @param dcc
	 */
	public void setDcc(String dcc) {
		this.dcc = dcc;
	}
	
	/**
	 * Column Info
	 * @param pdt
	 */
	public void setPdt(String pdt) {
		this.pdt = pdt;
	}
	
	/**
	 * Column Info
	 * @param vdp
	 */
	public void setVdp(String vdp) {
		this.vdp = vdp;
	}
	
	/**
	 * Column Info
	 * @param psb
	 */
	public void setPsb(String psb) {
		this.psb = psb;
	}
	
	/**
	 * Column Info
	 * @param ttl
	 */
	public void setTtl(String ttl) {
		this.ttl = ttl;
	}
	
	/**
	 * Column Info
	 * @param vtr
	 */
	public void setVtr(String vtr) {
		this.vtr = vtr;
	}
	
	/**
	 * Column Info
	 * @param vds
	 */
	public void setVds(String vds) {
		this.vds = vds;
	}
	
	/**
	 * Column Info
	 * @param wdy
	 */
	public void setWdy(String wdy) {
		this.wdy = wdy;
	}
	
	/**
	 * Column Info
	 * @param bda
	 */
	public void setBda(String bda) {
		this.bda = bda;
	}
	
	/**
	 * Column Info
	 * @param wdw
	 */
	public void setWdw(String wdw) {
		this.wdw = wdw;
	}
	
	/**
	 * Column Info
	 * @param hda
	 */
	public void setHda(String hda) {
		this.hda = hda;
	}
	
	/**
	 * Column Info
	 * @param wdt
	 */
	public void setWdt(String wdt) {
		this.wdt = wdt;
	}
	
	/**
	 * Column Info
	 * @param wls
	 */
	public void setWls(String wls) {
		this.wls = wls;
	}
	
	/**
	 * Column Info
	 * @param wds
	 */
	public void setWds(String wds) {
		this.wds = wds;
	}
	
	/**
	 * Column Info
	 * @param vad
	 */
	public void setVad(String vad) {
		this.vad = vad;
	}
	
	/**
	 * Column Info
	 * @param wlm
	 */
	public void setWlm(String wlm) {
		this.wlm = wlm;
	}
	
	/**
	 * Column Info
	 * @param wlm
	 */
	public void setIntgCdId(String intgCdId) {
		this.intgCdId = intgCdId;
	}
	
	/**
	 * Column Info
	 * @param wlm
	 */
	public void setGrpFlgCd(String grpFlgCd) {
		this.grpFlgCd = grpFlgCd;
	}
	
	
	/* Column Info */
	private String sbw = null;
	/**
	 * @return the sbw
	 */
	public String getSbw() {
		return sbw;
	}

	/**
	 * @param sbw the sbw to set
	 */
	public void setSbw(String sbw) {
		this.sbw = sbw;
	}

	/**
	 * @return the smt
	 */
	public String getSmt() {
		return smt;
	}

	/**
	 * @param smt the smt to set
	 */
	public void setSmt(String smt) {
		this.smt = smt;
	}

	/**
	 * @return the svd
	 */
	public String getSvd() {
		return svd;
	}

	/**
	 * @param svd the svd to set
	 */
	public void setSvd(String svd) {
		this.svd = svd;
	}

	/**
	 * @return the sda
	 */
	public String getSda() {
		return sda;
	}

	/**
	 * @param sda the sda to set
	 */
	public void setSda(String sda) {
		this.sda = sda;
	}

	/**
	 * @return the wad
	 */
	public String getWad() {
		return wad;
	}

	/**
	 * @param wad the wad to set
	 */
	public void setWad(String wad) {
		this.wad = wad;
	}

	/**
	 * @return the wpg
	 */
	public String getWpg() {
		return wpg;
	}

	/**
	 * @param wpg the wpg to set
	 */
	public void setWpg(String wpg) {
		this.wpg = wpg;
	}

	/**
	 * @return the wpc
	 */
	public String getWpc() {
		return wpc;
	}

	/**
	 * @param wpc the wpc to set
	 */
	public void setWpc(String wpc) {
		this.wpc = wpc;
	}

	/**
	 * @return the wpv
	 */
	public String getWpv() {
		return wpv;
	}

	/**
	 * @param wpv the wpv to set
	 */
	public void setWpv(String wpv) {
		this.wpv = wpv;
	}

	/**
	 * @return the wmt
	 */
	public String getWmt() {
		return wmt;
	}

	/**
	 * @param wmt the wmt to set
	 */
	public void setWmt(String wmt) {
		this.wmt = wmt;
	}

	/**
	 * @return the wca
	 */
	public String getWca() {
		return wca;
	}

	/**
	 * @param wca the wca to set
	 */
	public void setWca(String wca) {
		this.wca = wca;
	}

	/**
	 * @return the wio
	 */
	public String getWio() {
		return wio;
	}

	/**
	 * @param wio the wio to set
	 */
	public void setWio(String wio) {
		this.wio = wio;
	}

	/**
	 * @return the wnh
	 */
	public String getWnh() {
		return wnh;
	}

	/**
	 * @param wnh the wnh to set
	 */
	public void setWnh(String wnh) {
		this.wnh = wnh;
	}

	/**
	 * @return the btt
	 */
	public String getBtt() {
		return btt;
	}

	/**
	 * @param btt the btt to set
	 */
	public void setBtt(String btt) {
		this.btt = btt;
	}

	/**
	 * @return the bls
	 */
	public String getBls() {
		return bls;
	}

	/**
	 * @param bls the bls to set
	 */
	public void setBls(String bls) {
		this.bls = bls;
	}

	/**
	 * @return the bns
	 */
	public String getBns() {
		return bns;
	}

	/**
	 * @param bns the bns to set
	 */
	public void setBns(String bns) {
		this.bns = bns;
	}

	/**
	 * @return the bcw
	 */
	public String getBcw() {
		return bcw;
	}

	/**
	 * @param bcw the bcw to set
	 */
	public void setBcw(String bcw) {
		this.bcw = bcw;
	}

	/**
	 * @return the bcm
	 */
	public String getBcm() {
		return bcm;
	}

	/**
	 * @param bcm the bcm to set
	 */
	public void setBcm(String bcm) {
		this.bcm = bcm;
	}

	/**
	 * @return the brb
	 */
	public String getBrb() {
		return brb;
	}

	/**
	 * @param brb the brb to set
	 */
	public void setBrb(String brb) {
		this.brb = brb;
	}

	/**
	 * @return the bsp
	 */
	public String getBsp() {
		return bsp;
	}

	/**
	 * @param bsp the bsp to set
	 */
	public void setBsp(String bsp) {
		this.bsp = bsp;
	}

	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setBoa(JSPUtil.getParameter(request, "boa", ""));
		setWdg(JSPUtil.getParameter(request, "wdg", ""));
		setWdh(JSPUtil.getParameter(request, "wdh", ""));
		setIeFlg(JSPUtil.getParameter(request, "ie_flg", ""));
		setDlc(JSPUtil.getParameter(request, "dlc", ""));
		setWdl(JSPUtil.getParameter(request, "wdl", ""));
		setActInpToDt(JSPUtil.getParameter(request, "act_inp_to_dt", ""));
		setWda(JSPUtil.getParameter(request, "wda", ""));
		setWhm(JSPUtil.getParameter(request, "whm", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setDso(JSPUtil.getParameter(request, "dso", ""));
		setWdc(JSPUtil.getParameter(request, "wdc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDbs(JSPUtil.getParameter(request, "dbs", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setOntmCnt(JSPUtil.getParameter(request, "ontm_cnt", ""));
		setWct(JSPUtil.getParameter(request, "wct", ""));
		setWgs(JSPUtil.getParameter(request, "wgs", ""));
		setOth(JSPUtil.getParameter(request, "oth", ""));
		setWyc(JSPUtil.getParameter(request, "wyc", ""));
		setVhd(JSPUtil.getParameter(request, "vhd", ""));
		setCntHrs(JSPUtil.getParameter(request, "cnt_hrs", ""));
		setCallCnt(JSPUtil.getParameter(request, "call_cnt", ""));
		setCtl(JSPUtil.getParameter(request, "ctl", ""));
		setActInpFmDt(JSPUtil.getParameter(request, "act_inp_fm_dt", ""));
		setBwd(JSPUtil.getParameter(request, "bwd", ""));
		setDws(JSPUtil.getParameter(request, "dws", ""));
		setGrpFlg(JSPUtil.getParameter(request, "grp_flg", ""));
		setIpe(JSPUtil.getParameter(request, "ipe", ""));
		setWbw(JSPUtil.getParameter(request, "wbw", ""));
		setBwo(JSPUtil.getParameter(request, "bwo", ""));
		setBws(JSPUtil.getParameter(request, "bws", ""));
		setPts(JSPUtil.getParameter(request, "pts", ""));
		setMvs(JSPUtil.getParameter(request, "mvs", ""));
		setBww(JSPUtil.getParameter(request, "bww", ""));
		setVsp(JSPUtil.getParameter(request, "vsp", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setArrDep(JSPUtil.getParameter(request, "arr_dep", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setWsc(JSPUtil.getParameter(request, "wsc", ""));
		setXxx(JSPUtil.getParameter(request, "xxx", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setLaneGrpNm(JSPUtil.getParameter(request, "lane_grp_nm", ""));
		setBds(JSPUtil.getParameter(request, "bds", ""));
		setEng(JSPUtil.getParameter(request, "eng", ""));
		setWts(JSPUtil.getParameter(request, "wts", ""));
		setLaneGrp(JSPUtil.getParameter(request, "lane_grp", ""));
		setBpc(JSPUtil.getParameter(request, "bpc", ""));
		setDcc(JSPUtil.getParameter(request, "dcc", ""));
		setPdt(JSPUtil.getParameter(request, "pdt", ""));
		setVdp(JSPUtil.getParameter(request, "vdp", ""));
		setPsb(JSPUtil.getParameter(request, "psb", ""));
		setTtl(JSPUtil.getParameter(request, "ttl", ""));
		setVtr(JSPUtil.getParameter(request, "vtr", ""));
		setVds(JSPUtil.getParameter(request, "vds", ""));
		setWdy(JSPUtil.getParameter(request, "wdy", ""));
		setBda(JSPUtil.getParameter(request, "bda", ""));
		setWdw(JSPUtil.getParameter(request, "wdw", ""));
		setHda(JSPUtil.getParameter(request, "hda", ""));
		setWdt(JSPUtil.getParameter(request, "wdt", ""));
		setWls(JSPUtil.getParameter(request, "wls", ""));
		setWds(JSPUtil.getParameter(request, "wds", ""));
		setVad(JSPUtil.getParameter(request, "vad", ""));
		setWlm(JSPUtil.getParameter(request, "wlm", ""));
		setIntgCdId(JSPUtil.getParameter(request, "intg_cd_id", ""));
		setGrpFlgCd(JSPUtil.getParameter(request, "grp_flg_cd", ""));
		
		setSbw(JSPUtil.getParameter(request, "sbw", ""));
		setSmt(JSPUtil.getParameter(request, "smt", ""));
		setSvd(JSPUtil.getParameter(request, "svd", ""));
		setSda(JSPUtil.getParameter(request, "sda", ""));
		setWad(JSPUtil.getParameter(request, "wad", ""));
		setWpg(JSPUtil.getParameter(request, "wpg", ""));
		setWpc(JSPUtil.getParameter(request, "wpc", ""));
		setWpv(JSPUtil.getParameter(request, "wpv", ""));
		setWmt(JSPUtil.getParameter(request, "wmt", ""));
		setWca(JSPUtil.getParameter(request, "wca", ""));
		setWio(JSPUtil.getParameter(request, "wio", ""));
		setWnh(JSPUtil.getParameter(request, "wnh", ""));
		setBtt(JSPUtil.getParameter(request, "btt", ""));
		setBls(JSPUtil.getParameter(request, "bls", ""));
		setBns(JSPUtil.getParameter(request, "bns", ""));
		setBcw(JSPUtil.getParameter(request, "bcw", ""));
		setBcm(JSPUtil.getParameter(request, "bcm", ""));
		setBrb(JSPUtil.getParameter(request, "brb", ""));
		setBsp(JSPUtil.getParameter(request, "bsp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ResultChangeStatusVO[]
	 */
	public ResultDelayStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ResultChangeStatusVO[]
	 */
	public ResultDelayStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ResultDelayStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] boa = (JSPUtil.getParameter(request, prefix	+ "boa", length));
			String[] wdg = (JSPUtil.getParameter(request, prefix	+ "wdg", length));
			String[] wdh = (JSPUtil.getParameter(request, prefix	+ "wdh", length));
			String[] ieFlg = (JSPUtil.getParameter(request, prefix	+ "ie_flg", length));
			String[] dlc = (JSPUtil.getParameter(request, prefix	+ "dlc", length));
			String[] wdl = (JSPUtil.getParameter(request, prefix	+ "wdl", length));
			String[] actInpToDt = (JSPUtil.getParameter(request, prefix	+ "act_inp_to_dt", length));
			String[] wda = (JSPUtil.getParameter(request, prefix	+ "wda", length));
			String[] whm = (JSPUtil.getParameter(request, prefix	+ "whm", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] dso = (JSPUtil.getParameter(request, prefix	+ "dso", length));
			String[] wdc = (JSPUtil.getParameter(request, prefix	+ "wdc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dbs = (JSPUtil.getParameter(request, prefix	+ "dbs", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ontmCnt = (JSPUtil.getParameter(request, prefix	+ "ontm_cnt", length));
			String[] wct = (JSPUtil.getParameter(request, prefix	+ "wct", length));
			String[] wgs = (JSPUtil.getParameter(request, prefix	+ "wgs", length));
			String[] oth = (JSPUtil.getParameter(request, prefix	+ "oth", length));
			String[] wyc = (JSPUtil.getParameter(request, prefix	+ "wyc", length));
			String[] vhd = (JSPUtil.getParameter(request, prefix	+ "vhd", length));
			String[] cntHrs = (JSPUtil.getParameter(request, prefix	+ "cnt_hrs", length));
			String[] callCnt = (JSPUtil.getParameter(request, prefix	+ "call_cnt", length));
			String[] ctl = (JSPUtil.getParameter(request, prefix	+ "ctl", length));
			String[] actInpFmDt = (JSPUtil.getParameter(request, prefix	+ "act_inp_fm_dt", length));
			String[] bwd = (JSPUtil.getParameter(request, prefix	+ "bwd", length));
			String[] dws = (JSPUtil.getParameter(request, prefix	+ "dws", length));
			String[] grpFlg = (JSPUtil.getParameter(request, prefix	+ "grp_flg", length));
			String[] ipe = (JSPUtil.getParameter(request, prefix	+ "ipe", length));
			String[] wbw = (JSPUtil.getParameter(request, prefix	+ "wbw", length));
			String[] bwo = (JSPUtil.getParameter(request, prefix	+ "bwo", length));
			String[] bws = (JSPUtil.getParameter(request, prefix	+ "bws", length));
			String[] pts = (JSPUtil.getParameter(request, prefix	+ "pts", length));
			String[] mvs = (JSPUtil.getParameter(request, prefix	+ "mvs", length));
			String[] bww = (JSPUtil.getParameter(request, prefix	+ "bww", length));
			String[] vsp = (JSPUtil.getParameter(request, prefix	+ "vsp", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] arrDep = (JSPUtil.getParameter(request, prefix	+ "arr_dep", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] wsc = (JSPUtil.getParameter(request, prefix	+ "wsc", length));
			String[] xxx = (JSPUtil.getParameter(request, prefix	+ "xxx", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] laneGrpNm = (JSPUtil.getParameter(request, prefix	+ "lane_grp_nm", length));
			String[] bds = (JSPUtil.getParameter(request, prefix	+ "bds", length));
			String[] eng = (JSPUtil.getParameter(request, prefix	+ "eng", length));
			String[] wts = (JSPUtil.getParameter(request, prefix	+ "wts", length));
			String[] laneGrp = (JSPUtil.getParameter(request, prefix	+ "lane_grp", length));
			String[] bpc = (JSPUtil.getParameter(request, prefix	+ "bpc", length));
			String[] dcc = (JSPUtil.getParameter(request, prefix	+ "dcc", length));
			String[] pdt = (JSPUtil.getParameter(request, prefix	+ "pdt", length));
			String[] vdp = (JSPUtil.getParameter(request, prefix	+ "vdp", length));
			String[] psb = (JSPUtil.getParameter(request, prefix	+ "psb", length));
			String[] ttl = (JSPUtil.getParameter(request, prefix	+ "ttl", length));
			String[] vtr = (JSPUtil.getParameter(request, prefix	+ "vtr", length));
			String[] vds = (JSPUtil.getParameter(request, prefix	+ "vds", length));
			String[] wdy = (JSPUtil.getParameter(request, prefix	+ "wdy", length));
			String[] bda = (JSPUtil.getParameter(request, prefix	+ "bda", length));
			String[] wdw = (JSPUtil.getParameter(request, prefix	+ "wdw", length));
			String[] hda = (JSPUtil.getParameter(request, prefix	+ "hda", length));
			String[] wdt = (JSPUtil.getParameter(request, prefix	+ "wdt", length));
			String[] wls = (JSPUtil.getParameter(request, prefix	+ "wls", length));
			String[] wds = (JSPUtil.getParameter(request, prefix	+ "wds", length));
			String[] vad = (JSPUtil.getParameter(request, prefix	+ "vad", length));
			String[] wlm = (JSPUtil.getParameter(request, prefix	+ "wlm", length));
			String[] intgCdId = (JSPUtil.getParameter(request, prefix	+ "intg_cd_id", length));
			String[] grpFlgCd = (JSPUtil.getParameter(request, prefix	+ "grp_flg_cd", length));
			
			String[] sbw = (JSPUtil.getParameter(request, prefix	+ "sbw", length));
			String[] smt = (JSPUtil.getParameter(request, prefix	+ "smt", length));
			String[] svd = (JSPUtil.getParameter(request, prefix	+ "svd", length));
			String[] sda = (JSPUtil.getParameter(request, prefix	+ "sda", length));
			String[] wad = (JSPUtil.getParameter(request, prefix	+ "wad", length));
			String[] wpg = (JSPUtil.getParameter(request, prefix	+ "wpg", length));
			String[] wpc = (JSPUtil.getParameter(request, prefix	+ "wpc", length));
			String[] wpv = (JSPUtil.getParameter(request, prefix	+ "wpv", length));
			String[] wmt = (JSPUtil.getParameter(request, prefix	+ "wmt", length));
			String[] wca = (JSPUtil.getParameter(request, prefix	+ "wca", length));
			String[] wio = (JSPUtil.getParameter(request, prefix	+ "wio", length));
			String[] wnh = (JSPUtil.getParameter(request, prefix	+ "wnh", length));
			String[] btt = (JSPUtil.getParameter(request, prefix	+ "btt", length));
			String[] bls = (JSPUtil.getParameter(request, prefix	+ "bls", length));
			String[] bns = (JSPUtil.getParameter(request, prefix	+ "bns", length));
			String[] bcw = (JSPUtil.getParameter(request, prefix	+ "bcw", length));
			String[] bcm = (JSPUtil.getParameter(request, prefix	+ "bcm", length));
			String[] brb = (JSPUtil.getParameter(request, prefix	+ "brb", length));
			String[] bsp = (JSPUtil.getParameter(request, prefix	+ "bsp", length));

			
			for (int i = 0; i < length; i++) {
				model = new ResultDelayStatusVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (boa[i] != null)
					model.setBoa(boa[i]);
				if (wdg[i] != null)
					model.setWdg(wdg[i]);
				if (wdh[i] != null)
					model.setWdh(wdh[i]);
				if (ieFlg[i] != null)
					model.setIeFlg(ieFlg[i]);
				if (dlc[i] != null)
					model.setDlc(dlc[i]);
				if (wdl[i] != null)
					model.setWdl(wdl[i]);
				if (actInpToDt[i] != null)
					model.setActInpToDt(actInpToDt[i]);
				if (wda[i] != null)
					model.setWda(wda[i]);
				if (whm[i] != null)
					model.setWhm(whm[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (dso[i] != null)
					model.setDso(dso[i]);
				if (wdc[i] != null)
					model.setWdc(wdc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dbs[i] != null)
					model.setDbs(dbs[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ontmCnt[i] != null)
					model.setOntmCnt(ontmCnt[i]);
				if (wct[i] != null)
					model.setWct(wct[i]);
				if (wgs[i] != null)
					model.setWgs(wgs[i]);
				if (oth[i] != null)
					model.setOth(oth[i]);
				if (wyc[i] != null)
					model.setWyc(wyc[i]);
				if (vhd[i] != null)
					model.setVhd(vhd[i]);
				if (cntHrs[i] != null)
					model.setCntHrs(cntHrs[i]);
				if (callCnt[i] != null)
					model.setCallCnt(callCnt[i]);
				if (ctl[i] != null)
					model.setCtl(ctl[i]);
				if (actInpFmDt[i] != null)
					model.setActInpFmDt(actInpFmDt[i]);
				if (bwd[i] != null)
					model.setBwd(bwd[i]);
				if (dws[i] != null)
					model.setDws(dws[i]);
				if (grpFlg[i] != null)
					model.setGrpFlg(grpFlg[i]);
				if (ipe[i] != null)
					model.setIpe(ipe[i]);
				if (wbw[i] != null)
					model.setWbw(wbw[i]);
				if (bwo[i] != null)
					model.setBwo(bwo[i]);
				if (bws[i] != null)
					model.setBws(bws[i]);
				if (pts[i] != null)
					model.setPts(pts[i]);
				if (mvs[i] != null)
					model.setMvs(mvs[i]);
				if (bww[i] != null)
					model.setBww(bww[i]);
				if (vsp[i] != null)
					model.setVsp(vsp[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (arrDep[i] != null)
					model.setArrDep(arrDep[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (wsc[i] != null)
					model.setWsc(wsc[i]);
				if (xxx[i] != null)
					model.setXxx(xxx[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (laneGrpNm[i] != null)
					model.setLaneGrpNm(laneGrpNm[i]);
				if (bds[i] != null)
					model.setBds(bds[i]);
				if (eng[i] != null)
					model.setEng(eng[i]);
				if (wts[i] != null)
					model.setWts(wts[i]);
				if (laneGrp[i] != null)
					model.setLaneGrp(laneGrp[i]);
				if (bpc[i] != null)
					model.setBpc(bpc[i]);
				if (dcc[i] != null)
					model.setDcc(dcc[i]);
				if (pdt[i] != null)
					model.setPdt(pdt[i]);
				if (vdp[i] != null)
					model.setVdp(vdp[i]);
				if (psb[i] != null)
					model.setPsb(psb[i]);
				if (ttl[i] != null)
					model.setTtl(ttl[i]);
				if (vtr[i] != null)
					model.setVtr(vtr[i]);
				if (vds[i] != null)
					model.setVds(vds[i]);
				if (wdy[i] != null)
					model.setWdy(wdy[i]);
				if (bda[i] != null)
					model.setBda(bda[i]);
				if (wdw[i] != null)
					model.setWdw(wdw[i]);
				if (hda[i] != null)
					model.setHda(hda[i]);
				if (wdt[i] != null)
					model.setWdt(wdt[i]);
				if (wls[i] != null)
					model.setWls(wls[i]);
				if (wds[i] != null)
					model.setWds(wds[i]);
				if (vad[i] != null)
					model.setVad(vad[i]);
				if (wlm[i] != null)
					model.setWlm(wlm[i]);
				if (intgCdId[i] != null)
					model.setIntgCdId(intgCdId[i]);
				if (grpFlgCd[i] != null)
					model.setGrpFlgCd(grpFlgCd[i]);
				if (sbw[i] != null)
					model.setSbw(sbw[i]);
				if (smt[i] != null)
					model.setSmt(smt[i]);
				if (svd[i] != null)
					model.setSvd(svd[i]);
				if (sda[i] != null)
					model.setSda(sda[i]);
				if (wad[i] != null)
					model.setWad(wad[i]);
				if (wpg[i] != null)
					model.setWpg(wpg[i]);
				if (wpc[i] != null)
					model.setWpc(wpc[i]);
				if (wpv[i] != null)
					model.setWpv(wpv[i]);
				if (wmt[i] != null)
					model.setWmt(wmt[i]);
				if (wca[i] != null)
					model.setWca(wca[i]);
				if (wio[i] != null)
					model.setWio(wio[i]);
				if (wnh[i] != null)
					model.setWnh(wnh[i]);
				if (btt[i] != null)
					model.setBtt(btt[i]);
				if (bls[i] != null)
					model.setBls(bls[i]);
				if (bns[i] != null)
					model.setBns(bns[i]);
				if (bcw[i] != null)
					model.setBcw(bcw[i]);
				if (bcm[i] != null)
					model.setBcm(bcm[i]);
				if (brb[i] != null)
					model.setBrb(brb[i]);
				if (bsp[i] != null)
					model.setBsp(bsp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getResultChangeStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ResultChangeStatusVO[]
	 */
	public ResultDelayStatusVO[] getResultChangeStatusVOs(){
		ResultDelayStatusVO[] vos = (ResultDelayStatusVO[])models.toArray(new ResultDelayStatusVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boa = this.boa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wdg = this.wdg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wdh = this.wdh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ieFlg = this.ieFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlc = this.dlc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wdl = this.wdl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInpToDt = this.actInpToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wda = this.wda .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whm = this.whm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dso = this.dso .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wdc = this.wdc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dbs = this.dbs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ontmCnt = this.ontmCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wct = this.wct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgs = this.wgs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oth = this.oth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wyc = this.wyc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vhd = this.vhd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntHrs = this.cntHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callCnt = this.callCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctl = this.ctl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInpFmDt = this.actInpFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bwd = this.bwd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dws = this.dws .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpFlg = this.grpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ipe = this.ipe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wbw = this.wbw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bwo = this.bwo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bws = this.bws .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pts = this.pts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvs = this.mvs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bww = this.bww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vsp = this.vsp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDep = this.arrDep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wsc = this.wsc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xxx = this.xxx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneGrpNm = this.laneGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bds = this.bds .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eng = this.eng .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wts = this.wts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneGrp = this.laneGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bpc = this.bpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcc = this.dcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pdt = this.pdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vdp = this.vdp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psb = this.psb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl = this.ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vtr = this.vtr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vds = this.vds .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wdy = this.wdy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bda = this.bda .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wdw = this.wdw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hda = this.hda .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wdt = this.wdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wls = this.wls .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wds = this.wds .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vad = this.vad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wlm = this.wlm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdId = this.intgCdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpFlgCd = this.grpFlgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sbw = this.sbw.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smt = this.smt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svd = this.svd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sda = this.sda.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wad = this.wad.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wpg = this.wpg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wpc = this.wpc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wpv = this.wpv.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wmt = this.wmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wca = this.wca.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wio = this.wio.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wnh = this.wnh.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btt = this.btt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bls = this.bls.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bns = this.bns.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bcw = this.bcw.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bcm = this.bcm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brb = this.brb.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsp = this.bsp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
