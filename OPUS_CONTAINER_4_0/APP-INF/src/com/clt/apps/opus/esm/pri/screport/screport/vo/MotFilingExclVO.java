/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : MotFilingExclVO.java
 *@FileTitle : MotFilingExclVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.04.21
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2016.04.21 jaewonLee 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.screport.screport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author jaewonLee
 * @since J2EE 1.6
 * @see	..
 */
public class MotFilingExclVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<MotFilingExclVO>  models =	new	ArrayList<MotFilingExclVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String nid = null;
	/*	Column Info	*/
	private String batExeDt = null;
	/*	Column Info	*/
	private String shprCntCd = null;
	/*	Column Info	*/
	private String shprSeq = null;
	/*	Column Info	*/
	private String seq = null;
	/*	Column Info	*/
	private String carrier = null;
	/*	Column Info	*/
	private String ctrtNo = null;
	/*	Column Info	*/
	private String ctrtHldNm = null;
	/*	Column Info	*/
	private String bkgShprNm = null;
	/*	Column Info	*/
	private String bkgCneeNm = null;
	/*	Column Info	*/
	private String foreTraComp = null;
	/*	Column Info	*/
	private String operAgt = null;
	/*	Column Info	*/
	private String lane = null;
	/*	Column Info	*/
	private String wayPort = null;
	/*	Column Info	*/
	private String polCd = null;
	/*	Column Info	*/
	private String deptTsitPort = null;
	/*	Column Info	*/
	private String destTsitPort = null;
	/*	Column Info	*/
	private String podCd = null;
	/*	Column Info	*/
	private String transTerm = null;
	/*	Column Info	*/
	private String cntrTp = null;
	/*	Column Info	*/
	private String cmdtTp = null;
	/*	Column Info	*/
	private String cntrSz = null;
	/*	Column Info	*/
	private String cntrVol1 = null;
	/*	Column Info	*/
	private String cntrVol2 = null;
	/*	Column Info	*/
	private String oftRt = null;
	/*	Column Info	*/
	private String com = null;
	/*	Column Info	*/
	private String cov = null;
	/*	Column Info	*/
	private String covCur = null;
	/*	Column Info	*/
	private String covExe = null;
	/*	Column Info	*/
	private String cod = null;
	/*	Column Info	*/
	private String codCur = null;
	/*	Column Info	*/
	private String codExe = null;
	/*	Column Info	*/
	private String ocr = null;
	/*	Column Info	*/
	private String crs = null;
	/*	Column Info	*/
	private String xei = null;
	/*	Column Info	*/
	private String kcs = null;
	/*	Column Info	*/
	private String ams = null;
	/*	Column Info	*/
	private String dpc = null;
	/*	Column Info	*/
	private String prs = null;
	/*	Column Info	*/
	private String enq = null;
	/*	Column Info	*/
	private String chc = null;
	/*	Column Info	*/
	private String ama = null;
	/*	Column Info	*/
	private String adh = null;
	/*	Column Info	*/
	private String gen = null;
	/*	Column Info	*/
	private String dem = null;
	/*	Column Info	*/
	private String det = null;
	/*	Column Info	*/
	private String xsw = null;
	/*	Column Info	*/
	private String xbs = null;
	/*	Column Info	*/
	private String xbr = null;
	/*	Column Info	*/
	private String xba = null;
	/*	Column Info	*/
	private String bkf = null;
	/*	Column Info	*/
	private String wha = null;
	/*	Column Info	*/
	private String tsl = null;
	/*	Column Info	*/
	private String tsd = null;
	/*	Column Info	*/
	private String slf = null;
	/*	Column Info	*/
	private String rpc = null;
	/*	Column Info	*/
	private String rls = null;
	/*	Column Info	*/
	private String rha = null;
	/*	Column Info	*/
	private String psc = null;
	/*	Column Info	*/
	private String mpl = null;
	/*	Column Info	*/
	private String llo = null;
	/*	Column Info	*/
	private String psf = null;
	/*	Column Info	*/
	private String ins = null;
	/*	Column Info	*/
	private String ifi = null;
	/*	Column Info	*/
	private String haf = null;
	/*	Column Info	*/
	private String hau = null;
	/*	Column Info	*/
	private String aha = null;
	/*	Column Info	*/
	private String gat = null;
	/*	Column Info	*/
	private String fdr = null;
	/*	Column Info	*/
	private String fed = null;
	/*	Column Info	*/
	private String fmf = null;
	/*	Column Info	*/
	private String esd = null;
	/*	Column Info	*/
	private String emp = null;
	/*	Column Info	*/
	private String elo = null;
	/*	Column Info	*/
	private String ehd = null;
	/*	Column Info	*/
	private String edi = null;
	/*	Column Info	*/
	private String emr = null;
	/*	Column Info	*/
	private String drp = null;
	/*	Column Info	*/
	private String xdo = null;
	/*	Column Info	*/
	private String doc = null;
	/*	Column Info	*/
	private String esi = null;
	/*	Column Info	*/
	private String xdd = null;
	/*	Column Info	*/
	private String dof = null;
	/*	Column Info	*/
	private String dey = null;
	/*	Column Info	*/
	private String xde = null;
	/*	Column Info	*/
	private String cys = null;
	/*	Column Info	*/
	private String cyr = null;
	/*	Column Info	*/
	private String csv = null;
	/*	Column Info	*/
	private String cvc = null;
	/*	Column Info	*/
	private String ctp = null;
	/*	Column Info	*/
	private String cmc = null;
	/*	Column Info	*/
	private String ccc = null;
	/*	Column Info	*/
	private String cfd = null;
	/*	Column Info	*/
	private String cdc = null;
	/*	Column Info	*/
	private String xwf = null;
	/*	Column Info	*/
	private String cdd = null;
	/*	Column Info	*/
	private String bao = null;
	/*	Column Info	*/
	private String bad = null;
	/*	Column Info	*/
	private String bio = null;
	/*	Column Info	*/
	private String ard = null;
	/*	Column Info	*/
	private String alm = null;
	/*	Column Info	*/
	private String baf = null;
	/*	Column Info	*/
	private String caf = null;
	/*	Column Info	*/
	private String ref = null;
	/*	Column Info	*/
	private String rsd = null;
	/*	Column Info	*/
	private String thl = null;
	/*	Column Info	*/
	private String thd = null;
	/*	Column Info	*/
	private String xer = null;
	/*	Column Info	*/
	private String neo = null;
	/*	Column Info	*/
	private String neoCur = null;
	/*	Column Info	*/
	private String neoExe = null;
	/*	Column Info	*/
	private String wtr = null;
	/*	Column Info	*/
	private String wtrCur = null;
	/*	Column Info	*/
	private String wtrExe = null;
	/*	Column Info	*/
	private String eca = null;
	/*	Column Info	*/
	private String ecaCur = null;
	/*	Column Info	*/
	private String ecaExe = null;
	/*	Column Info	*/
	private String wrc = null;
	/*	Column Info	*/
	private String wrcCur = null;
	/*	Column Info	*/
	private String wrcExe = null;
	/*	Column Info	*/
	private String tcs = null;
	/*	Column Info	*/
	private String tcsCur = null;
	/*	Column Info	*/
	private String tcsExe = null;
	/*	Column Info	*/
	private String win = null;
	/*	Column Info	*/
	private String winCur = null;
	/*	Column Info	*/
	private String winExe = null;
	/*	Column Info	*/
	private String yas = null;
	/*	Column Info	*/
	private String yasCur = null;
	/*	Column Info	*/
	private String yasExe = null;
	/*	Column Info	*/
	private String spt = null;
	/*	Column Info	*/
	private String sptCur = null;
	/*	Column Info	*/
	private String sptExe = null;
	/*	Column Info	*/
	private String sct = null;
	/*	Column Info	*/
	private String sctCur = null;
	/*	Column Info	*/
	private String sctExe = null;
	/*	Column Info	*/
	private String pss = null;
	/*	Column Info	*/
	private String pssCur = null;
	/*	Column Info	*/
	private String pssExe = null;
	/*	Column Info	*/
	private String pct = null;
	/*	Column Info	*/
	private String pctCur = null;
	/*	Column Info	*/
	private String pctExe = null;
	/*	Column Info	*/
	private String lsf = null;
	/*	Column Info	*/
	private String lsfCur = null;
	/*	Column Info	*/
	private String lsfExe = null;
	/*	Column Info	*/
	private String faf = null;
	/*	Column Info	*/
	private String fafCur = null;
	/*	Column Info	*/
	private String fafExe = null;
	/*	Column Info	*/
	private String ers = null;
	/*	Column Info	*/
	private String ersCur = null;
	/*	Column Info	*/
	private String ersExe = null;
	/*	Column Info	*/
	private String eis = null;
	/*	Column Info	*/
	private String eisCur = null;
	/*	Column Info	*/
	private String eisExe = null;
	/*	Column Info	*/
	private String env = null;
	/*	Column Info	*/
	private String envCur = null;
	/*	Column Info	*/
	private String envExe = null;
	/*	Column Info	*/
	private String ems = null;
	/*	Column Info	*/
	private String emsCur = null;
	/*	Column Info	*/
	private String emsExe = null;
	/*	Column Info	*/
	private String ebs = null;
	/*	Column Info	*/
	private String ebsCur = null;
	/*	Column Info	*/
	private String ebsExe = null;
	/*	Column Info	*/
	private String eba = null;
	/*	Column Info	*/
	private String ebaCur = null;
	/*	Column Info	*/
	private String ebaExe = null;
	/*	Column Info	*/
	private String eri = null;
	/*	Column Info	*/
	private String eriCur = null;
	/*	Column Info	*/
	private String eriExe = null;
	/*	Column Info	*/
	private String dcf = null;
	/*	Column Info	*/
	private String dcfCur = null;
	/*	Column Info	*/
	private String dcfExe = null;
	/*	Column Info	*/
	private String cbr = null;
	/*	Column Info	*/
	private String cbrCur = null;
	/*	Column Info	*/
	private String cbrExe = null;
	/*	Column Info	*/
	private String cgl = null;
	/*	Column Info	*/
	private String cglCur = null;
	/*	Column Info	*/
	private String cglExe = null;
	/*	Column Info	*/
	private String cgd = null;
	/*	Column Info	*/
	private String cgdCur = null;
	/*	Column Info	*/
	private String cgdExe = null;
	/*	Column Info	*/
	private String con = null;
	/*	Column Info	*/
	private String conCur = null;
	/*	Column Info	*/
	private String conExe = null;
	/*	Column Info	*/
	private String css = null;
	/*	Column Info	*/
	private String cssCur = null;
	/*	Column Info	*/
	private String cssExe = null;
	/*	Column Info	*/
	private String bct = null;
	/*	Column Info	*/
	private String bctCur = null;
	/*	Column Info	*/
	private String bctExe = null;
	/*	Column Info	*/
	private String afa = null;
	/*	Column Info	*/
	private String afaCur = null;
	/*	Column Info	*/
	private String afaExe = null;
	/*	Column Info	*/
	private String ags = null;
	/*	Column Info	*/
	private String agsCur = null;
	/*	Column Info	*/
	private String agsExe = null;
	/*	Column Info	*/
	private String ses = null;
	/*	Column Info	*/
	private String sesCur = null;
	/*	Column Info	*/
	private String sesExe = null;
	/*	Column Info	*/
	private String gh2 = null;
	/*	Column Info	*/
	private String gh2Cur = null;
	/*	Column Info	*/
	private String gh2Exe = null;
	/*	Column Info	*/
	private String aps = null;
	/*	Column Info	*/
	private String apsCur = null;
	/*	Column Info	*/
	private String apsExe = null;
	/*	Column Info	*/
	private String goh = null;
	/*	Column Info	*/
	private String gohCur = null;
	/*	Column Info	*/
	private String gohExe = null;
	/*	Column Info	*/
	private String hea = null;
	/*	Column Info	*/
	private String heaCur = null;
	/*	Column Info	*/
	private String heaExe = null;
	/*	Column Info	*/
	private String haz = null;
	/*	Column Info	*/
	private String hazCur = null;
	/*	Column Info	*/
	private String hazExe = null;
	/*	Column Info	*/
	private String dgs = null;
	/*	Column Info	*/
	private String dgsCur = null;
	/*	Column Info	*/
	private String dgsExe = null;
	/*	Column Info	*/
	private String effDt = null;
	/*	Column Info	*/
	private String expDt = null;
	/*	Column Info	*/
	private String remark = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public MotFilingExclVO(){}

	public MotFilingExclVO(String ibflag,String pagerows,String nid,String batExeDt,String shprCntCd,String shprSeq,String seq,String carrier,String ctrtNo,String ctrtHldNm,String bkgShprNm,String bkgCneeNm,String foreTraComp,String operAgt,String lane,String wayPort,String polCd,String deptTsitPort,String destTsitPort,String podCd,String transTerm,String cntrTp,String cmdtTp,String cntrSz,String cntrVol1,String cntrVol2,String oftRt,String com,String cov,String covCur,String covExe,String cod,String codCur,String codExe,String ocr,String crs,String xei,String kcs,String ams,String dpc,String prs,String enq,String chc,String ama,String adh,String gen,String dem,String det,String xsw,String xbs,String xbr,String xba,String bkf,String wha,String tsl,String tsd,String slf,String rpc,String rls,String rha,String psc,String mpl,String llo,String psf,String ins,String ifi,String haf,String hau,String aha,String gat,String fdr,String fed,String fmf,String esd,String emp,String elo,String ehd,String edi,String emr,String drp,String xdo,String doc,String esi,String xdd,String dof,String dey,String xde,String cys,String cyr,String csv,String cvc,String ctp,String cmc,String ccc,String cfd,String cdc,String xwf,String cdd,String bao,String bad,String bio,String ard,String alm,String baf,String caf,String ref,String rsd,String thl,String thd,String xer,String neo,String neoCur,String neoExe,String wtr,String wtrCur,String wtrExe,String eca,String ecaCur,String ecaExe,String wrc,String wrcCur,String wrcExe,String tcs,String tcsCur,String tcsExe,String win,String winCur,String winExe,String yas,String yasCur,String yasExe,String spt,String sptCur,String sptExe,String sct,String sctCur,String sctExe,String pss,String pssCur,String pssExe,String pct,String pctCur,String pctExe,String lsf,String lsfCur,String lsfExe,String faf,String fafCur,String fafExe,String ers,String ersCur,String ersExe,String eis,String eisCur,String eisExe,String env,String envCur,String envExe,String ems,String emsCur,String emsExe,String ebs,String ebsCur,String ebsExe,String eba,String ebaCur,String ebaExe,String eri,String eriCur,String eriExe,String dcf,String dcfCur,String dcfExe,String cbr,String cbrCur,String cbrExe,String cgl,String cglCur,String cglExe,String cgd,String cgdCur,String cgdExe,String con,String conCur,String conExe,String css,String cssCur,String cssExe,String bct,String bctCur,String bctExe,String afa,String afaCur,String afaExe,String ags,String agsCur,String agsExe,String ses,String sesCur,String sesExe,String gh2,String gh2Cur,String gh2Exe,String aps,String apsCur,String apsExe,String goh,String gohCur,String gohExe,String hea,String heaCur,String heaExe,String haz,String hazCur,String hazExe,String dgs,String dgsCur,String dgsExe,String effDt,String expDt,String remark)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.nid = nid;
		this.batExeDt = batExeDt;
		this.shprCntCd = shprCntCd;
		this.shprSeq = shprSeq;
		this.seq = seq;
		this.carrier = carrier;
		this.ctrtNo = ctrtNo;
		this.ctrtHldNm = ctrtHldNm;
		this.bkgShprNm = bkgShprNm;
		this.bkgCneeNm = bkgCneeNm;
		this.foreTraComp = foreTraComp;
		this.operAgt = operAgt;
		this.lane = lane;
		this.wayPort = wayPort;
		this.polCd = polCd;
		this.deptTsitPort = deptTsitPort;
		this.destTsitPort = destTsitPort;
		this.podCd = podCd;
		this.transTerm = transTerm;
		this.cntrTp = cntrTp;
		this.cmdtTp = cmdtTp;
		this.cntrSz = cntrSz;
		this.cntrVol1 = cntrVol1;
		this.cntrVol2 = cntrVol2;
		this.oftRt = oftRt;
		this.com = com;
		this.cov = cov;
		this.covCur = covCur;
		this.covExe = covExe;
		this.cod = cod;
		this.codCur = codCur;
		this.codExe = codExe;
		this.ocr = ocr;
		this.crs = crs;
		this.xei = xei;
		this.kcs = kcs;
		this.ams = ams;
		this.dpc = dpc;
		this.prs = prs;
		this.enq = enq;
		this.chc = chc;
		this.ama = ama;
		this.adh = adh;
		this.gen = gen;
		this.dem = dem;
		this.det = det;
		this.xsw = xsw;
		this.xbs = xbs;
		this.xbr = xbr;
		this.xba = xba;
		this.bkf = bkf;
		this.wha = wha;
		this.tsl = tsl;
		this.tsd = tsd;
		this.slf = slf;
		this.rpc = rpc;
		this.rls = rls;
		this.rha = rha;
		this.psc = psc;
		this.mpl = mpl;
		this.llo = llo;
		this.psf = psf;
		this.ins = ins;
		this.ifi = ifi;
		this.haf = haf;
		this.hau = hau;
		this.aha = aha;
		this.gat = gat;
		this.fdr = fdr;
		this.fed = fed;
		this.fmf = fmf;
		this.esd = esd;
		this.emp = emp;
		this.elo = elo;
		this.ehd = ehd;
		this.edi = edi;
		this.emr = emr;
		this.drp = drp;
		this.xdo = xdo;
		this.doc = doc;
		this.esi = esi;
		this.xdd = xdd;
		this.dof = dof;
		this.dey = dey;
		this.xde = xde;
		this.cys = cys;
		this.cyr = cyr;
		this.csv = csv;
		this.cvc = cvc;
		this.ctp = ctp;
		this.cmc = cmc;
		this.ccc = ccc;
		this.cfd = cfd;
		this.cdc = cdc;
		this.xwf = xwf;
		this.cdd = cdd;
		this.bao = bao;
		this.bad = bad;
		this.bio = bio;
		this.ard = ard;
		this.alm = alm;
		this.baf = baf;
		this.caf = caf;
		this.ref = ref;
		this.rsd = rsd;
		this.thl = thl;
		this.thd = thd;
		this.xer = xer;
		this.neo = neo;
		this.neoCur = neoCur;
		this.neoExe = neoExe;
		this.wtr = wtr;
		this.wtrCur = wtrCur;
		this.wtrExe = wtrExe;
		this.eca = eca;
		this.ecaCur = ecaCur;
		this.ecaExe = ecaExe;
		this.wrc = wrc;
		this.wrcCur = wrcCur;
		this.wrcExe = wrcExe;
		this.tcs = tcs;
		this.tcsCur = tcsCur;
		this.tcsExe = tcsExe;
		this.win = win;
		this.winCur = winCur;
		this.winExe = winExe;
		this.yas = yas;
		this.yasCur = yasCur;
		this.yasExe = yasExe;
		this.spt = spt;
		this.sptCur = sptCur;
		this.sptExe = sptExe;
		this.sct = sct;
		this.sctCur = sctCur;
		this.sctExe = sctExe;
		this.pss = pss;
		this.pssCur = pssCur;
		this.pssExe = pssExe;
		this.pct = pct;
		this.pctCur = pctCur;
		this.pctExe = pctExe;
		this.lsf = lsf;
		this.lsfCur = lsfCur;
		this.lsfExe = lsfExe;
		this.faf = faf;
		this.fafCur = fafCur;
		this.fafExe = fafExe;
		this.ers = ers;
		this.ersCur = ersCur;
		this.ersExe = ersExe;
		this.eis = eis;
		this.eisCur = eisCur;
		this.eisExe = eisExe;
		this.env = env;
		this.envCur = envCur;
		this.envExe = envExe;
		this.ems = ems;
		this.emsCur = emsCur;
		this.emsExe = emsExe;
		this.ebs = ebs;
		this.ebsCur = ebsCur;
		this.ebsExe = ebsExe;
		this.eba = eba;
		this.ebaCur = ebaCur;
		this.ebaExe = ebaExe;
		this.eri = eri;
		this.eriCur = eriCur;
		this.eriExe = eriExe;
		this.dcf = dcf;
		this.dcfCur = dcfCur;
		this.dcfExe = dcfExe;
		this.cbr = cbr;
		this.cbrCur = cbrCur;
		this.cbrExe = cbrExe;
		this.cgl = cgl;
		this.cglCur = cglCur;
		this.cglExe = cglExe;
		this.cgd = cgd;
		this.cgdCur = cgdCur;
		this.cgdExe = cgdExe;
		this.con = con;
		this.conCur = conCur;
		this.conExe = conExe;
		this.css = css;
		this.cssCur = cssCur;
		this.cssExe = cssExe;
		this.bct = bct;
		this.bctCur = bctCur;
		this.bctExe = bctExe;
		this.afa = afa;
		this.afaCur = afaCur;
		this.afaExe = afaExe;
		this.ags = ags;
		this.agsCur = agsCur;
		this.agsExe = agsExe;
		this.ses = ses;
		this.sesCur = sesCur;
		this.sesExe = sesExe;
		this.gh2 = gh2;
		this.gh2Cur = gh2Cur;
		this.gh2Exe = gh2Exe;
		this.aps = aps;
		this.apsCur = apsCur;
		this.apsExe = apsExe;
		this.goh = goh;
		this.gohCur = gohCur;
		this.gohExe = gohExe;
		this.hea = hea;
		this.heaCur = heaCur;
		this.heaExe = heaExe;
		this.haz = haz;
		this.hazCur = hazCur;
		this.hazExe = hazExe;
		this.dgs = dgs;
		this.dgsCur = dgsCur;
		this.dgsExe = dgsExe;
		this.effDt = effDt;
		this.expDt = expDt;
		this.remark = remark;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("nid", getNid());
		this.hashColumns.put("bat_exe_dt", getBatExeDt());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("shpr_seq", getShprSeq());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("carrier", getCarrier());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("ctrt_hld_nm", getCtrtHldNm());
		this.hashColumns.put("bkg_shpr_nm", getBkgShprNm());
		this.hashColumns.put("bkg_cnee_nm", getBkgCneeNm());
		this.hashColumns.put("fore_tra_comp", getForeTraComp());
		this.hashColumns.put("oper_agt", getOperAgt());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("way_port", getWayPort());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("dept_tsit_port", getDeptTsitPort());
		this.hashColumns.put("dest_tsit_port", getDestTsitPort());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("trans_term", getTransTerm());
		this.hashColumns.put("cntr_tp", getCntrTp());
		this.hashColumns.put("cmdt_tp", getCmdtTp());
		this.hashColumns.put("cntr_sz", getCntrSz());
		this.hashColumns.put("cntr_vol1", getCntrVol1());
		this.hashColumns.put("cntr_vol2", getCntrVol2());
		this.hashColumns.put("oft_rt", getOftRt());
		this.hashColumns.put("com", getCom());
		this.hashColumns.put("cov", getCov());
		this.hashColumns.put("cov_cur", getCovCur());
		this.hashColumns.put("cov_exe", getCovExe());
		this.hashColumns.put("cod", getCod());
		this.hashColumns.put("cod_cur", getCodCur());
		this.hashColumns.put("cod_exe", getCodExe());
		this.hashColumns.put("ocr", getOcr());
		this.hashColumns.put("crs", getCrs());
		this.hashColumns.put("xei", getXei());
		this.hashColumns.put("kcs", getKcs());
		this.hashColumns.put("ams", getAms());
		this.hashColumns.put("dpc", getDpc());
		this.hashColumns.put("prs", getPrs());
		this.hashColumns.put("enq", getEnq());
		this.hashColumns.put("chc", getChc());
		this.hashColumns.put("ama", getAma());
		this.hashColumns.put("adh", getAdh());
		this.hashColumns.put("gen", getGen());
		this.hashColumns.put("dem", getDem());
		this.hashColumns.put("det", getDet());
		this.hashColumns.put("xsw", getXsw());
		this.hashColumns.put("xbs", getXbs());
		this.hashColumns.put("xbr", getXbr());
		this.hashColumns.put("xba", getXba());
		this.hashColumns.put("bkf", getBkf());
		this.hashColumns.put("wha", getWha());
		this.hashColumns.put("tsl", getTsl());
		this.hashColumns.put("tsd", getTsd());
		this.hashColumns.put("slf", getSlf());
		this.hashColumns.put("rpc", getRpc());
		this.hashColumns.put("rls", getRls());
		this.hashColumns.put("rha", getRha());
		this.hashColumns.put("psc", getPsc());
		this.hashColumns.put("mpl", getMpl());
		this.hashColumns.put("llo", getLlo());
		this.hashColumns.put("psf", getPsf());
		this.hashColumns.put("ins", getIns());
		this.hashColumns.put("ifi", getIfi());
		this.hashColumns.put("haf", getHaf());
		this.hashColumns.put("hau", getHau());
		this.hashColumns.put("aha", getAha());
		this.hashColumns.put("gat", getGat());
		this.hashColumns.put("fdr", getFdr());
		this.hashColumns.put("fed", getFed());
		this.hashColumns.put("fmf", getFmf());
		this.hashColumns.put("esd", getEsd());
		this.hashColumns.put("emp", getEmp());
		this.hashColumns.put("elo", getElo());
		this.hashColumns.put("ehd", getEhd());
		this.hashColumns.put("edi", getEdi());
		this.hashColumns.put("emr", getEmr());
		this.hashColumns.put("drp", getDrp());
		this.hashColumns.put("xdo", getXdo());
		this.hashColumns.put("doc", getDoc());
		this.hashColumns.put("esi", getEsi());
		this.hashColumns.put("xdd", getXdd());
		this.hashColumns.put("dof", getDof());
		this.hashColumns.put("dey", getDey());
		this.hashColumns.put("xde", getXde());
		this.hashColumns.put("cys", getCys());
		this.hashColumns.put("cyr", getCyr());
		this.hashColumns.put("csv", getCsv());
		this.hashColumns.put("cvc", getCvc());
		this.hashColumns.put("ctp", getCtp());
		this.hashColumns.put("cmc", getCmc());
		this.hashColumns.put("ccc", getCcc());
		this.hashColumns.put("cfd", getCfd());
		this.hashColumns.put("cdc", getCdc());
		this.hashColumns.put("xwf", getXwf());
		this.hashColumns.put("cdd", getCdd());
		this.hashColumns.put("bao", getBao());
		this.hashColumns.put("bad", getBad());
		this.hashColumns.put("bio", getBio());
		this.hashColumns.put("ard", getArd());
		this.hashColumns.put("alm", getAlm());
		this.hashColumns.put("baf", getBaf());
		this.hashColumns.put("caf", getCaf());
		this.hashColumns.put("ref", getRef());
		this.hashColumns.put("rsd", getRsd());
		this.hashColumns.put("thl", getThl());
		this.hashColumns.put("thd", getThd());
		this.hashColumns.put("xer", getXer());
		this.hashColumns.put("neo", getNeo());
		this.hashColumns.put("neo_cur", getNeoCur());
		this.hashColumns.put("neo_exe", getNeoExe());
		this.hashColumns.put("wtr", getWtr());
		this.hashColumns.put("wtr_cur", getWtrCur());
		this.hashColumns.put("wtr_exe", getWtrExe());
		this.hashColumns.put("eca", getEca());
		this.hashColumns.put("eca_cur", getEcaCur());
		this.hashColumns.put("eca_exe", getEcaExe());
		this.hashColumns.put("wrc", getWrc());
		this.hashColumns.put("wrc_cur", getWrcCur());
		this.hashColumns.put("wrc_exe", getWrcExe());
		this.hashColumns.put("tcs", getTcs());
		this.hashColumns.put("tcs_cur", getTcsCur());
		this.hashColumns.put("tcs_exe", getTcsExe());
		this.hashColumns.put("win", getWin());
		this.hashColumns.put("win_cur", getWinCur());
		this.hashColumns.put("win_exe", getWinExe());
		this.hashColumns.put("yas", getYas());
		this.hashColumns.put("yas_cur", getYasCur());
		this.hashColumns.put("yas_exe", getYasExe());
		this.hashColumns.put("spt", getSpt());
		this.hashColumns.put("spt_cur", getSptCur());
		this.hashColumns.put("spt_exe", getSptExe());
		this.hashColumns.put("sct", getSct());
		this.hashColumns.put("sct_cur", getSctCur());
		this.hashColumns.put("sct_exe", getSctExe());
		this.hashColumns.put("pss", getPss());
		this.hashColumns.put("pss_cur", getPssCur());
		this.hashColumns.put("pss_exe", getPssExe());
		this.hashColumns.put("pct", getPct());
		this.hashColumns.put("pct_cur", getPctCur());
		this.hashColumns.put("pct_exe", getPctExe());
		this.hashColumns.put("lsf", getLsf());
		this.hashColumns.put("lsf_cur", getLsfCur());
		this.hashColumns.put("lsf_exe", getLsfExe());
		this.hashColumns.put("faf", getFaf());
		this.hashColumns.put("faf_cur", getFafCur());
		this.hashColumns.put("faf_exe", getFafExe());
		this.hashColumns.put("ers", getErs());
		this.hashColumns.put("ers_cur", getErsCur());
		this.hashColumns.put("ers_exe", getErsExe());
		this.hashColumns.put("eis", getEis());
		this.hashColumns.put("eis_cur", getEisCur());
		this.hashColumns.put("eis_exe", getEisExe());
		this.hashColumns.put("env", getEnv());
		this.hashColumns.put("env_cur", getEnvCur());
		this.hashColumns.put("env_exe", getEnvExe());
		this.hashColumns.put("ems", getEms());
		this.hashColumns.put("ems_cur", getEmsCur());
		this.hashColumns.put("ems_exe", getEmsExe());
		this.hashColumns.put("ebs", getEbs());
		this.hashColumns.put("ebs_cur", getEbsCur());
		this.hashColumns.put("ebs_exe", getEbsExe());
		this.hashColumns.put("eba", getEba());
		this.hashColumns.put("eba_cur", getEbaCur());
		this.hashColumns.put("eba_exe", getEbaExe());
		this.hashColumns.put("eri", getEri());
		this.hashColumns.put("eri_cur", getEriCur());
		this.hashColumns.put("eri_exe", getEriExe());
		this.hashColumns.put("dcf", getDcf());
		this.hashColumns.put("dcf_cur", getDcfCur());
		this.hashColumns.put("dcf_exe", getDcfExe());
		this.hashColumns.put("cbr", getCbr());
		this.hashColumns.put("cbr_cur", getCbrCur());
		this.hashColumns.put("cbr_exe", getCbrExe());
		this.hashColumns.put("cgl", getCgl());
		this.hashColumns.put("cgl_cur", getCglCur());
		this.hashColumns.put("cgl_exe", getCglExe());
		this.hashColumns.put("cgd", getCgd());
		this.hashColumns.put("cgd_cur", getCgdCur());
		this.hashColumns.put("cgd_exe", getCgdExe());
		this.hashColumns.put("con", getCon());
		this.hashColumns.put("con_cur", getConCur());
		this.hashColumns.put("con_exe", getConExe());
		this.hashColumns.put("css", getCss());
		this.hashColumns.put("css_cur", getCssCur());
		this.hashColumns.put("css_exe", getCssExe());
		this.hashColumns.put("bct", getBct());
		this.hashColumns.put("bct_cur", getBctCur());
		this.hashColumns.put("bct_exe", getBctExe());
		this.hashColumns.put("afa", getAfa());
		this.hashColumns.put("afa_cur", getAfaCur());
		this.hashColumns.put("afa_exe", getAfaExe());
		this.hashColumns.put("ags", getAgs());
		this.hashColumns.put("ags_cur", getAgsCur());
		this.hashColumns.put("ags_exe", getAgsExe());
		this.hashColumns.put("ses", getSes());
		this.hashColumns.put("ses_cur", getSesCur());
		this.hashColumns.put("ses_exe", getSesExe());
		this.hashColumns.put("gh2", getGh2());
		this.hashColumns.put("gh2_cur", getGh2Cur());
		this.hashColumns.put("gh2_exe", getGh2Exe());
		this.hashColumns.put("aps", getAps());
		this.hashColumns.put("aps_cur", getApsCur());
		this.hashColumns.put("aps_exe", getApsExe());
		this.hashColumns.put("goh", getGoh());
		this.hashColumns.put("goh_cur", getGohCur());
		this.hashColumns.put("goh_exe", getGohExe());
		this.hashColumns.put("hea", getHea());
		this.hashColumns.put("hea_cur", getHeaCur());
		this.hashColumns.put("hea_exe", getHeaExe());
		this.hashColumns.put("haz", getHaz());
		this.hashColumns.put("haz_cur", getHazCur());
		this.hashColumns.put("haz_exe", getHazExe());
		this.hashColumns.put("dgs", getDgs());
		this.hashColumns.put("dgs_cur", getDgsCur());
		this.hashColumns.put("dgs_exe", getDgsExe());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("remark", getRemark());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("nid", "nid");
		this.hashFields.put("bat_exe_dt", "batExeDt");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("shpr_seq", "shprSeq");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("carrier", "carrier");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("ctrt_hld_nm", "ctrtHldNm");
		this.hashFields.put("bkg_shpr_nm", "bkgShprNm");
		this.hashFields.put("bkg_cnee_nm", "bkgCneeNm");
		this.hashFields.put("fore_tra_comp", "foreTraComp");
		this.hashFields.put("oper_agt", "operAgt");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("way_port", "wayPort");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("dept_tsit_port", "deptTsitPort");
		this.hashFields.put("dest_tsit_port", "destTsitPort");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("trans_term", "transTerm");
		this.hashFields.put("cntr_tp", "cntrTp");
		this.hashFields.put("cmdt_tp", "cmdtTp");
		this.hashFields.put("cntr_sz", "cntrSz");
		this.hashFields.put("cntr_vol1", "cntrVol1");
		this.hashFields.put("cntr_vol2", "cntrVol2");
		this.hashFields.put("oft_rt", "oftRt");
		this.hashFields.put("com", "com");
		this.hashFields.put("cov", "cov");
		this.hashFields.put("cov_cur", "covCur");
		this.hashFields.put("cov_exe", "covExe");
		this.hashFields.put("cod", "cod");
		this.hashFields.put("cod_cur", "codCur");
		this.hashFields.put("cod_exe", "codExe");
		this.hashFields.put("ocr", "ocr");
		this.hashFields.put("crs", "crs");
		this.hashFields.put("xei", "xei");
		this.hashFields.put("kcs", "kcs");
		this.hashFields.put("ams", "ams");
		this.hashFields.put("dpc", "dpc");
		this.hashFields.put("prs", "prs");
		this.hashFields.put("enq", "enq");
		this.hashFields.put("chc", "chc");
		this.hashFields.put("ama", "ama");
		this.hashFields.put("adh", "adh");
		this.hashFields.put("gen", "gen");
		this.hashFields.put("dem", "dem");
		this.hashFields.put("det", "det");
		this.hashFields.put("xsw", "xsw");
		this.hashFields.put("xbs", "xbs");
		this.hashFields.put("xbr", "xbr");
		this.hashFields.put("xba", "xba");
		this.hashFields.put("bkf", "bkf");
		this.hashFields.put("wha", "wha");
		this.hashFields.put("tsl", "tsl");
		this.hashFields.put("tsd", "tsd");
		this.hashFields.put("slf", "slf");
		this.hashFields.put("rpc", "rpc");
		this.hashFields.put("rls", "rls");
		this.hashFields.put("rha", "rha");
		this.hashFields.put("psc", "psc");
		this.hashFields.put("mpl", "mpl");
		this.hashFields.put("llo", "llo");
		this.hashFields.put("psf", "psf");
		this.hashFields.put("ins", "ins");
		this.hashFields.put("ifi", "ifi");
		this.hashFields.put("haf", "haf");
		this.hashFields.put("hau", "hau");
		this.hashFields.put("aha", "aha");
		this.hashFields.put("gat", "gat");
		this.hashFields.put("fdr", "fdr");
		this.hashFields.put("fed", "fed");
		this.hashFields.put("fmf", "fmf");
		this.hashFields.put("esd", "esd");
		this.hashFields.put("emp", "emp");
		this.hashFields.put("elo", "elo");
		this.hashFields.put("ehd", "ehd");
		this.hashFields.put("edi", "edi");
		this.hashFields.put("emr", "emr");
		this.hashFields.put("drp", "drp");
		this.hashFields.put("xdo", "xdo");
		this.hashFields.put("doc", "doc");
		this.hashFields.put("esi", "esi");
		this.hashFields.put("xdd", "xdd");
		this.hashFields.put("dof", "dof");
		this.hashFields.put("dey", "dey");
		this.hashFields.put("xde", "xde");
		this.hashFields.put("cys", "cys");
		this.hashFields.put("cyr", "cyr");
		this.hashFields.put("csv", "csv");
		this.hashFields.put("cvc", "cvc");
		this.hashFields.put("ctp", "ctp");
		this.hashFields.put("cmc", "cmc");
		this.hashFields.put("ccc", "ccc");
		this.hashFields.put("cfd", "cfd");
		this.hashFields.put("cdc", "cdc");
		this.hashFields.put("xwf", "xwf");
		this.hashFields.put("cdd", "cdd");
		this.hashFields.put("bao", "bao");
		this.hashFields.put("bad", "bad");
		this.hashFields.put("bio", "bio");
		this.hashFields.put("ard", "ard");
		this.hashFields.put("alm", "alm");
		this.hashFields.put("baf", "baf");
		this.hashFields.put("caf", "caf");
		this.hashFields.put("ref", "ref");
		this.hashFields.put("rsd", "rsd");
		this.hashFields.put("thl", "thl");
		this.hashFields.put("thd", "thd");
		this.hashFields.put("xer", "xer");
		this.hashFields.put("neo", "neo");
		this.hashFields.put("neo_cur", "neoCur");
		this.hashFields.put("neo_exe", "neoExe");
		this.hashFields.put("wtr", "wtr");
		this.hashFields.put("wtr_cur", "wtrCur");
		this.hashFields.put("wtr_exe", "wtrExe");
		this.hashFields.put("eca", "eca");
		this.hashFields.put("eca_cur", "ecaCur");
		this.hashFields.put("eca_exe", "ecaExe");
		this.hashFields.put("wrc", "wrc");
		this.hashFields.put("wrc_cur", "wrcCur");
		this.hashFields.put("wrc_exe", "wrcExe");
		this.hashFields.put("tcs", "tcs");
		this.hashFields.put("tcs_cur", "tcsCur");
		this.hashFields.put("tcs_exe", "tcsExe");
		this.hashFields.put("win", "win");
		this.hashFields.put("win_cur", "winCur");
		this.hashFields.put("win_exe", "winExe");
		this.hashFields.put("yas", "yas");
		this.hashFields.put("yas_cur", "yasCur");
		this.hashFields.put("yas_exe", "yasExe");
		this.hashFields.put("spt", "spt");
		this.hashFields.put("spt_cur", "sptCur");
		this.hashFields.put("spt_exe", "sptExe");
		this.hashFields.put("sct", "sct");
		this.hashFields.put("sct_cur", "sctCur");
		this.hashFields.put("sct_exe", "sctExe");
		this.hashFields.put("pss", "pss");
		this.hashFields.put("pss_cur", "pssCur");
		this.hashFields.put("pss_exe", "pssExe");
		this.hashFields.put("pct", "pct");
		this.hashFields.put("pct_cur", "pctCur");
		this.hashFields.put("pct_exe", "pctExe");
		this.hashFields.put("lsf", "lsf");
		this.hashFields.put("lsf_cur", "lsfCur");
		this.hashFields.put("lsf_exe", "lsfExe");
		this.hashFields.put("faf", "faf");
		this.hashFields.put("faf_cur", "fafCur");
		this.hashFields.put("faf_exe", "fafExe");
		this.hashFields.put("ers", "ers");
		this.hashFields.put("ers_cur", "ersCur");
		this.hashFields.put("ers_exe", "ersExe");
		this.hashFields.put("eis", "eis");
		this.hashFields.put("eis_cur", "eisCur");
		this.hashFields.put("eis_exe", "eisExe");
		this.hashFields.put("env", "env");
		this.hashFields.put("env_cur", "envCur");
		this.hashFields.put("env_exe", "envExe");
		this.hashFields.put("ems", "ems");
		this.hashFields.put("ems_cur", "emsCur");
		this.hashFields.put("ems_exe", "emsExe");
		this.hashFields.put("ebs", "ebs");
		this.hashFields.put("ebs_cur", "ebsCur");
		this.hashFields.put("ebs_exe", "ebsExe");
		this.hashFields.put("eba", "eba");
		this.hashFields.put("eba_cur", "ebaCur");
		this.hashFields.put("eba_exe", "ebaExe");
		this.hashFields.put("eri", "eri");
		this.hashFields.put("eri_cur", "eriCur");
		this.hashFields.put("eri_exe", "eriExe");
		this.hashFields.put("dcf", "dcf");
		this.hashFields.put("dcf_cur", "dcfCur");
		this.hashFields.put("dcf_exe", "dcfExe");
		this.hashFields.put("cbr", "cbr");
		this.hashFields.put("cbr_cur", "cbrCur");
		this.hashFields.put("cbr_exe", "cbrExe");
		this.hashFields.put("cgl", "cgl");
		this.hashFields.put("cgl_cur", "cglCur");
		this.hashFields.put("cgl_exe", "cglExe");
		this.hashFields.put("cgd", "cgd");
		this.hashFields.put("cgd_cur", "cgdCur");
		this.hashFields.put("cgd_exe", "cgdExe");
		this.hashFields.put("con", "con");
		this.hashFields.put("con_cur", "conCur");
		this.hashFields.put("con_exe", "conExe");
		this.hashFields.put("css", "css");
		this.hashFields.put("css_cur", "cssCur");
		this.hashFields.put("css_exe", "cssExe");
		this.hashFields.put("bct", "bct");
		this.hashFields.put("bct_cur", "bctCur");
		this.hashFields.put("bct_exe", "bctExe");
		this.hashFields.put("afa", "afa");
		this.hashFields.put("afa_cur", "afaCur");
		this.hashFields.put("afa_exe", "afaExe");
		this.hashFields.put("ags", "ags");
		this.hashFields.put("ags_cur", "agsCur");
		this.hashFields.put("ags_exe", "agsExe");
		this.hashFields.put("ses", "ses");
		this.hashFields.put("ses_cur", "sesCur");
		this.hashFields.put("ses_exe", "sesExe");
		this.hashFields.put("gh2", "gh2");
		this.hashFields.put("gh2_cur", "gh2Cur");
		this.hashFields.put("gh2_exe", "gh2Exe");
		this.hashFields.put("aps", "aps");
		this.hashFields.put("aps_cur", "apsCur");
		this.hashFields.put("aps_exe", "apsExe");
		this.hashFields.put("goh", "goh");
		this.hashFields.put("goh_cur", "gohCur");
		this.hashFields.put("goh_exe", "gohExe");
		this.hashFields.put("hea", "hea");
		this.hashFields.put("hea_cur", "heaCur");
		this.hashFields.put("hea_exe", "heaExe");
		this.hashFields.put("haz", "haz");
		this.hashFields.put("haz_cur", "hazCur");
		this.hashFields.put("haz_exe", "hazExe");
		this.hashFields.put("dgs", "dgs");
		this.hashFields.put("dgs_cur", "dgsCur");
		this.hashFields.put("dgs_exe", "dgsExe");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("remark", "remark");
		return this.hashFields;
	}

	//	Getters	and	Setters

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public	String getIbflag() {
		return	this.ibflag;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public	String getPagerows() {
		return	this.pagerows;
	}

	/**
	 * Column Info
	 * @return nid
	 */
	public	String getNid() {
		return	this.nid;
	}

	/**
	 * Column Info
	 * @return batExeDt
	 */
	public	String getBatExeDt() {
		return	this.batExeDt;
	}

	/**
	 * Column Info
	 * @return shprCntCd
	 */
	public	String getShprCntCd() {
		return	this.shprCntCd;
	}

	/**
	 * Column Info
	 * @return shprSeq
	 */
	public	String getShprSeq() {
		return	this.shprSeq;
	}

	/**
	 * Column Info
	 * @return seq
	 */
	public	String getSeq() {
		return	this.seq;
	}

	/**
	 * Column Info
	 * @return carrier
	 */
	public	String getCarrier() {
		return	this.carrier;
	}

	/**
	 * Column Info
	 * @return ctrtNo
	 */
	public	String getCtrtNo() {
		return	this.ctrtNo;
	}

	/**
	 * Column Info
	 * @return ctrtHldNm
	 */
	public	String getCtrtHldNm() {
		return	this.ctrtHldNm;
	}

	/**
	 * Column Info
	 * @return bkgShprNm
	 */
	public	String getBkgShprNm() {
		return	this.bkgShprNm;
	}

	/**
	 * Column Info
	 * @return bkgCneeNm
	 */
	public	String getBkgCneeNm() {
		return	this.bkgCneeNm;
	}

	/**
	 * Column Info
	 * @return foreTraComp
	 */
	public	String getForeTraComp() {
		return	this.foreTraComp;
	}

	/**
	 * Column Info
	 * @return operAgt
	 */
	public	String getOperAgt() {
		return	this.operAgt;
	}

	/**
	 * Column Info
	 * @return lane
	 */
	public	String getLane() {
		return	this.lane;
	}

	/**
	 * Column Info
	 * @return wayPort
	 */
	public	String getWayPort() {
		return	this.wayPort;
	}

	/**
	 * Column Info
	 * @return polCd
	 */
	public	String getPolCd() {
		return	this.polCd;
	}

	/**
	 * Column Info
	 * @return deptTsitPort
	 */
	public	String getDeptTsitPort() {
		return	this.deptTsitPort;
	}

	/**
	 * Column Info
	 * @return destTsitPort
	 */
	public	String getDestTsitPort() {
		return	this.destTsitPort;
	}

	/**
	 * Column Info
	 * @return podCd
	 */
	public	String getPodCd() {
		return	this.podCd;
	}

	/**
	 * Column Info
	 * @return transTerm
	 */
	public	String getTransTerm() {
		return	this.transTerm;
	}

	/**
	 * Column Info
	 * @return cntrTp
	 */
	public	String getCntrTp() {
		return	this.cntrTp;
	}

	/**
	 * Column Info
	 * @return cmdtTp
	 */
	public	String getCmdtTp() {
		return	this.cmdtTp;
	}

	/**
	 * Column Info
	 * @return cntrSz
	 */
	public	String getCntrSz() {
		return	this.cntrSz;
	}

	/**
	 * Column Info
	 * @return cntrVol1
	 */
	public	String getCntrVol1() {
		return	this.cntrVol1;
	}

	/**
	 * Column Info
	 * @return cntrVol2
	 */
	public	String getCntrVol2() {
		return	this.cntrVol2;
	}

	/**
	 * Column Info
	 * @return oftRt
	 */
	public	String getOftRt() {
		return	this.oftRt;
	}

	/**
	 * Column Info
	 * @return com
	 */
	public	String getCom() {
		return	this.com;
	}

	/**
	 * Column Info
	 * @return cov
	 */
	public	String getCov() {
		return	this.cov;
	}

	/**
	 * Column Info
	 * @return covCur
	 */
	public	String getCovCur() {
		return	this.covCur;
	}

	/**
	 * Column Info
	 * @return covExe
	 */
	public	String getCovExe() {
		return	this.covExe;
	}

	/**
	 * Column Info
	 * @return cod
	 */
	public	String getCod() {
		return	this.cod;
	}

	/**
	 * Column Info
	 * @return codCur
	 */
	public	String getCodCur() {
		return	this.codCur;
	}

	/**
	 * Column Info
	 * @return codExe
	 */
	public	String getCodExe() {
		return	this.codExe;
	}

	/**
	 * Column Info
	 * @return ocr
	 */
	public	String getOcr() {
		return	this.ocr;
	}

	/**
	 * Column Info
	 * @return crs
	 */
	public	String getCrs() {
		return	this.crs;
	}

	/**
	 * Column Info
	 * @return xei
	 */
	public	String getXei() {
		return	this.xei;
	}

	/**
	 * Column Info
	 * @return kcs
	 */
	public	String getKcs() {
		return	this.kcs;
	}

	/**
	 * Column Info
	 * @return ams
	 */
	public	String getAms() {
		return	this.ams;
	}

	/**
	 * Column Info
	 * @return dpc
	 */
	public	String getDpc() {
		return	this.dpc;
	}

	/**
	 * Column Info
	 * @return prs
	 */
	public	String getPrs() {
		return	this.prs;
	}

	/**
	 * Column Info
	 * @return enq
	 */
	public	String getEnq() {
		return	this.enq;
	}

	/**
	 * Column Info
	 * @return chc
	 */
	public	String getChc() {
		return	this.chc;
	}

	/**
	 * Column Info
	 * @return ama
	 */
	public	String getAma() {
		return	this.ama;
	}

	/**
	 * Column Info
	 * @return adh
	 */
	public	String getAdh() {
		return	this.adh;
	}

	/**
	 * Column Info
	 * @return gen
	 */
	public	String getGen() {
		return	this.gen;
	}

	/**
	 * Column Info
	 * @return dem
	 */
	public	String getDem() {
		return	this.dem;
	}

	/**
	 * Column Info
	 * @return det
	 */
	public	String getDet() {
		return	this.det;
	}

	/**
	 * Column Info
	 * @return xsw
	 */
	public	String getXsw() {
		return	this.xsw;
	}

	/**
	 * Column Info
	 * @return xbs
	 */
	public	String getXbs() {
		return	this.xbs;
	}

	/**
	 * Column Info
	 * @return xbr
	 */
	public	String getXbr() {
		return	this.xbr;
	}

	/**
	 * Column Info
	 * @return xba
	 */
	public	String getXba() {
		return	this.xba;
	}

	/**
	 * Column Info
	 * @return bkf
	 */
	public	String getBkf() {
		return	this.bkf;
	}

	/**
	 * Column Info
	 * @return wha
	 */
	public	String getWha() {
		return	this.wha;
	}

	/**
	 * Column Info
	 * @return tsl
	 */
	public	String getTsl() {
		return	this.tsl;
	}

	/**
	 * Column Info
	 * @return tsd
	 */
	public	String getTsd() {
		return	this.tsd;
	}

	/**
	 * Column Info
	 * @return slf
	 */
	public	String getSlf() {
		return	this.slf;
	}

	/**
	 * Column Info
	 * @return rpc
	 */
	public	String getRpc() {
		return	this.rpc;
	}

	/**
	 * Column Info
	 * @return rls
	 */
	public	String getRls() {
		return	this.rls;
	}

	/**
	 * Column Info
	 * @return rha
	 */
	public	String getRha() {
		return	this.rha;
	}

	/**
	 * Column Info
	 * @return psc
	 */
	public	String getPsc() {
		return	this.psc;
	}

	/**
	 * Column Info
	 * @return mpl
	 */
	public	String getMpl() {
		return	this.mpl;
	}

	/**
	 * Column Info
	 * @return llo
	 */
	public	String getLlo() {
		return	this.llo;
	}

	/**
	 * Column Info
	 * @return psf
	 */
	public	String getPsf() {
		return	this.psf;
	}

	/**
	 * Column Info
	 * @return ins
	 */
	public	String getIns() {
		return	this.ins;
	}

	/**
	 * Column Info
	 * @return ifi
	 */
	public	String getIfi() {
		return	this.ifi;
	}

	/**
	 * Column Info
	 * @return haf
	 */
	public	String getHaf() {
		return	this.haf;
	}

	/**
	 * Column Info
	 * @return hau
	 */
	public	String getHau() {
		return	this.hau;
	}

	/**
	 * Column Info
	 * @return aha
	 */
	public	String getAha() {
		return	this.aha;
	}

	/**
	 * Column Info
	 * @return gat
	 */
	public	String getGat() {
		return	this.gat;
	}

	/**
	 * Column Info
	 * @return fdr
	 */
	public	String getFdr() {
		return	this.fdr;
	}

	/**
	 * Column Info
	 * @return fed
	 */
	public	String getFed() {
		return	this.fed;
	}

	/**
	 * Column Info
	 * @return fmf
	 */
	public	String getFmf() {
		return	this.fmf;
	}

	/**
	 * Column Info
	 * @return esd
	 */
	public	String getEsd() {
		return	this.esd;
	}

	/**
	 * Column Info
	 * @return emp
	 */
	public	String getEmp() {
		return	this.emp;
	}

	/**
	 * Column Info
	 * @return elo
	 */
	public	String getElo() {
		return	this.elo;
	}

	/**
	 * Column Info
	 * @return ehd
	 */
	public	String getEhd() {
		return	this.ehd;
	}

	/**
	 * Column Info
	 * @return edi
	 */
	public	String getEdi() {
		return	this.edi;
	}

	/**
	 * Column Info
	 * @return emr
	 */
	public	String getEmr() {
		return	this.emr;
	}

	/**
	 * Column Info
	 * @return drp
	 */
	public	String getDrp() {
		return	this.drp;
	}

	/**
	 * Column Info
	 * @return xdo
	 */
	public	String getXdo() {
		return	this.xdo;
	}

	/**
	 * Column Info
	 * @return doc
	 */
	public	String getDoc() {
		return	this.doc;
	}

	/**
	 * Column Info
	 * @return esi
	 */
	public	String getEsi() {
		return	this.esi;
	}

	/**
	 * Column Info
	 * @return xdd
	 */
	public	String getXdd() {
		return	this.xdd;
	}

	/**
	 * Column Info
	 * @return dof
	 */
	public	String getDof() {
		return	this.dof;
	}

	/**
	 * Column Info
	 * @return dey
	 */
	public	String getDey() {
		return	this.dey;
	}

	/**
	 * Column Info
	 * @return xde
	 */
	public	String getXde() {
		return	this.xde;
	}

	/**
	 * Column Info
	 * @return cys
	 */
	public	String getCys() {
		return	this.cys;
	}

	/**
	 * Column Info
	 * @return cyr
	 */
	public	String getCyr() {
		return	this.cyr;
	}

	/**
	 * Column Info
	 * @return csv
	 */
	public	String getCsv() {
		return	this.csv;
	}

	/**
	 * Column Info
	 * @return cvc
	 */
	public	String getCvc() {
		return	this.cvc;
	}

	/**
	 * Column Info
	 * @return ctp
	 */
	public	String getCtp() {
		return	this.ctp;
	}

	/**
	 * Column Info
	 * @return cmc
	 */
	public	String getCmc() {
		return	this.cmc;
	}

	/**
	 * Column Info
	 * @return ccc
	 */
	public	String getCcc() {
		return	this.ccc;
	}

	/**
	 * Column Info
	 * @return cfd
	 */
	public	String getCfd() {
		return	this.cfd;
	}

	/**
	 * Column Info
	 * @return cdc
	 */
	public	String getCdc() {
		return	this.cdc;
	}

	/**
	 * Column Info
	 * @return xwf
	 */
	public	String getXwf() {
		return	this.xwf;
	}

	/**
	 * Column Info
	 * @return cdd
	 */
	public	String getCdd() {
		return	this.cdd;
	}

	/**
	 * Column Info
	 * @return bao
	 */
	public	String getBao() {
		return	this.bao;
	}

	/**
	 * Column Info
	 * @return bad
	 */
	public	String getBad() {
		return	this.bad;
	}

	/**
	 * Column Info
	 * @return bio
	 */
	public	String getBio() {
		return	this.bio;
	}

	/**
	 * Column Info
	 * @return ard
	 */
	public	String getArd() {
		return	this.ard;
	}

	/**
	 * Column Info
	 * @return alm
	 */
	public	String getAlm() {
		return	this.alm;
	}

	/**
	 * Column Info
	 * @return baf
	 */
	public	String getBaf() {
		return	this.baf;
	}

	/**
	 * Column Info
	 * @return caf
	 */
	public	String getCaf() {
		return	this.caf;
	}

	/**
	 * Column Info
	 * @return ref
	 */
	public	String getRef() {
		return	this.ref;
	}

	/**
	 * Column Info
	 * @return rsd
	 */
	public	String getRsd() {
		return	this.rsd;
	}

	/**
	 * Column Info
	 * @return thl
	 */
	public	String getThl() {
		return	this.thl;
	}

	/**
	 * Column Info
	 * @return thd
	 */
	public	String getThd() {
		return	this.thd;
	}

	/**
	 * Column Info
	 * @return xer
	 */
	public	String getXer() {
		return	this.xer;
	}

	/**
	 * Column Info
	 * @return neo
	 */
	public	String getNeo() {
		return	this.neo;
	}

	/**
	 * Column Info
	 * @return neoCur
	 */
	public	String getNeoCur() {
		return	this.neoCur;
	}

	/**
	 * Column Info
	 * @return neoExe
	 */
	public	String getNeoExe() {
		return	this.neoExe;
	}

	/**
	 * Column Info
	 * @return wtr
	 */
	public	String getWtr() {
		return	this.wtr;
	}

	/**
	 * Column Info
	 * @return wtrCur
	 */
	public	String getWtrCur() {
		return	this.wtrCur;
	}

	/**
	 * Column Info
	 * @return wtrExe
	 */
	public	String getWtrExe() {
		return	this.wtrExe;
	}

	/**
	 * Column Info
	 * @return eca
	 */
	public	String getEca() {
		return	this.eca;
	}

	/**
	 * Column Info
	 * @return ecaCur
	 */
	public	String getEcaCur() {
		return	this.ecaCur;
	}

	/**
	 * Column Info
	 * @return ecaExe
	 */
	public	String getEcaExe() {
		return	this.ecaExe;
	}

	/**
	 * Column Info
	 * @return wrc
	 */
	public	String getWrc() {
		return	this.wrc;
	}

	/**
	 * Column Info
	 * @return wrcCur
	 */
	public	String getWrcCur() {
		return	this.wrcCur;
	}

	/**
	 * Column Info
	 * @return wrcExe
	 */
	public	String getWrcExe() {
		return	this.wrcExe;
	}

	/**
	 * Column Info
	 * @return tcs
	 */
	public	String getTcs() {
		return	this.tcs;
	}

	/**
	 * Column Info
	 * @return tcsCur
	 */
	public	String getTcsCur() {
		return	this.tcsCur;
	}

	/**
	 * Column Info
	 * @return tcsExe
	 */
	public	String getTcsExe() {
		return	this.tcsExe;
	}

	/**
	 * Column Info
	 * @return win
	 */
	public	String getWin() {
		return	this.win;
	}

	/**
	 * Column Info
	 * @return winCur
	 */
	public	String getWinCur() {
		return	this.winCur;
	}

	/**
	 * Column Info
	 * @return winExe
	 */
	public	String getWinExe() {
		return	this.winExe;
	}

	/**
	 * Column Info
	 * @return yas
	 */
	public	String getYas() {
		return	this.yas;
	}

	/**
	 * Column Info
	 * @return yasCur
	 */
	public	String getYasCur() {
		return	this.yasCur;
	}

	/**
	 * Column Info
	 * @return yasExe
	 */
	public	String getYasExe() {
		return	this.yasExe;
	}

	/**
	 * Column Info
	 * @return spt
	 */
	public	String getSpt() {
		return	this.spt;
	}

	/**
	 * Column Info
	 * @return sptCur
	 */
	public	String getSptCur() {
		return	this.sptCur;
	}

	/**
	 * Column Info
	 * @return sptExe
	 */
	public	String getSptExe() {
		return	this.sptExe;
	}

	/**
	 * Column Info
	 * @return sct
	 */
	public	String getSct() {
		return	this.sct;
	}

	/**
	 * Column Info
	 * @return sctCur
	 */
	public	String getSctCur() {
		return	this.sctCur;
	}

	/**
	 * Column Info
	 * @return sctExe
	 */
	public	String getSctExe() {
		return	this.sctExe;
	}

	/**
	 * Column Info
	 * @return pss
	 */
	public	String getPss() {
		return	this.pss;
	}

	/**
	 * Column Info
	 * @return pssCur
	 */
	public	String getPssCur() {
		return	this.pssCur;
	}

	/**
	 * Column Info
	 * @return pssExe
	 */
	public	String getPssExe() {
		return	this.pssExe;
	}

	/**
	 * Column Info
	 * @return pct
	 */
	public	String getPct() {
		return	this.pct;
	}

	/**
	 * Column Info
	 * @return pctCur
	 */
	public	String getPctCur() {
		return	this.pctCur;
	}

	/**
	 * Column Info
	 * @return pctExe
	 */
	public	String getPctExe() {
		return	this.pctExe;
	}

	/**
	 * Column Info
	 * @return lsf
	 */
	public	String getLsf() {
		return	this.lsf;
	}

	/**
	 * Column Info
	 * @return lsfCur
	 */
	public	String getLsfCur() {
		return	this.lsfCur;
	}

	/**
	 * Column Info
	 * @return lsfExe
	 */
	public	String getLsfExe() {
		return	this.lsfExe;
	}

	/**
	 * Column Info
	 * @return faf
	 */
	public	String getFaf() {
		return	this.faf;
	}

	/**
	 * Column Info
	 * @return fafCur
	 */
	public	String getFafCur() {
		return	this.fafCur;
	}

	/**
	 * Column Info
	 * @return fafExe
	 */
	public	String getFafExe() {
		return	this.fafExe;
	}

	/**
	 * Column Info
	 * @return ers
	 */
	public	String getErs() {
		return	this.ers;
	}

	/**
	 * Column Info
	 * @return ersCur
	 */
	public	String getErsCur() {
		return	this.ersCur;
	}

	/**
	 * Column Info
	 * @return ersExe
	 */
	public	String getErsExe() {
		return	this.ersExe;
	}

	/**
	 * Column Info
	 * @return eis
	 */
	public	String getEis() {
		return	this.eis;
	}

	/**
	 * Column Info
	 * @return eisCur
	 */
	public	String getEisCur() {
		return	this.eisCur;
	}

	/**
	 * Column Info
	 * @return eisExe
	 */
	public	String getEisExe() {
		return	this.eisExe;
	}

	/**
	 * Column Info
	 * @return env
	 */
	public	String getEnv() {
		return	this.env;
	}

	/**
	 * Column Info
	 * @return envCur
	 */
	public	String getEnvCur() {
		return	this.envCur;
	}

	/**
	 * Column Info
	 * @return envExe
	 */
	public	String getEnvExe() {
		return	this.envExe;
	}

	/**
	 * Column Info
	 * @return ems
	 */
	public	String getEms() {
		return	this.ems;
	}

	/**
	 * Column Info
	 * @return emsCur
	 */
	public	String getEmsCur() {
		return	this.emsCur;
	}

	/**
	 * Column Info
	 * @return emsExe
	 */
	public	String getEmsExe() {
		return	this.emsExe;
	}

	/**
	 * Column Info
	 * @return ebs
	 */
	public	String getEbs() {
		return	this.ebs;
	}

	/**
	 * Column Info
	 * @return ebsCur
	 */
	public	String getEbsCur() {
		return	this.ebsCur;
	}

	/**
	 * Column Info
	 * @return ebsExe
	 */
	public	String getEbsExe() {
		return	this.ebsExe;
	}

	/**
	 * Column Info
	 * @return eba
	 */
	public	String getEba() {
		return	this.eba;
	}

	/**
	 * Column Info
	 * @return ebaCur
	 */
	public	String getEbaCur() {
		return	this.ebaCur;
	}

	/**
	 * Column Info
	 * @return ebaExe
	 */
	public	String getEbaExe() {
		return	this.ebaExe;
	}

	/**
	 * Column Info
	 * @return eri
	 */
	public	String getEri() {
		return	this.eri;
	}

	/**
	 * Column Info
	 * @return eriCur
	 */
	public	String getEriCur() {
		return	this.eriCur;
	}

	/**
	 * Column Info
	 * @return eriExe
	 */
	public	String getEriExe() {
		return	this.eriExe;
	}

	/**
	 * Column Info
	 * @return dcf
	 */
	public	String getDcf() {
		return	this.dcf;
	}

	/**
	 * Column Info
	 * @return dcfCur
	 */
	public	String getDcfCur() {
		return	this.dcfCur;
	}

	/**
	 * Column Info
	 * @return dcfExe
	 */
	public	String getDcfExe() {
		return	this.dcfExe;
	}

	/**
	 * Column Info
	 * @return cbr
	 */
	public	String getCbr() {
		return	this.cbr;
	}

	/**
	 * Column Info
	 * @return cbrCur
	 */
	public	String getCbrCur() {
		return	this.cbrCur;
	}

	/**
	 * Column Info
	 * @return cbrExe
	 */
	public	String getCbrExe() {
		return	this.cbrExe;
	}

	/**
	 * Column Info
	 * @return cgl
	 */
	public	String getCgl() {
		return	this.cgl;
	}

	/**
	 * Column Info
	 * @return cglCur
	 */
	public	String getCglCur() {
		return	this.cglCur;
	}

	/**
	 * Column Info
	 * @return cglExe
	 */
	public	String getCglExe() {
		return	this.cglExe;
	}

	/**
	 * Column Info
	 * @return cgd
	 */
	public	String getCgd() {
		return	this.cgd;
	}

	/**
	 * Column Info
	 * @return cgdCur
	 */
	public	String getCgdCur() {
		return	this.cgdCur;
	}

	/**
	 * Column Info
	 * @return cgdExe
	 */
	public	String getCgdExe() {
		return	this.cgdExe;
	}

	/**
	 * Column Info
	 * @return con
	 */
	public	String getCon() {
		return	this.con;
	}

	/**
	 * Column Info
	 * @return conCur
	 */
	public	String getConCur() {
		return	this.conCur;
	}

	/**
	 * Column Info
	 * @return conExe
	 */
	public	String getConExe() {
		return	this.conExe;
	}

	/**
	 * Column Info
	 * @return css
	 */
	public	String getCss() {
		return	this.css;
	}

	/**
	 * Column Info
	 * @return cssCur
	 */
	public	String getCssCur() {
		return	this.cssCur;
	}

	/**
	 * Column Info
	 * @return cssExe
	 */
	public	String getCssExe() {
		return	this.cssExe;
	}

	/**
	 * Column Info
	 * @return bct
	 */
	public	String getBct() {
		return	this.bct;
	}

	/**
	 * Column Info
	 * @return bctCur
	 */
	public	String getBctCur() {
		return	this.bctCur;
	}

	/**
	 * Column Info
	 * @return bctExe
	 */
	public	String getBctExe() {
		return	this.bctExe;
	}

	/**
	 * Column Info
	 * @return afa
	 */
	public	String getAfa() {
		return	this.afa;
	}

	/**
	 * Column Info
	 * @return afaCur
	 */
	public	String getAfaCur() {
		return	this.afaCur;
	}

	/**
	 * Column Info
	 * @return afaExe
	 */
	public	String getAfaExe() {
		return	this.afaExe;
	}

	/**
	 * Column Info
	 * @return ags
	 */
	public	String getAgs() {
		return	this.ags;
	}

	/**
	 * Column Info
	 * @return agsCur
	 */
	public	String getAgsCur() {
		return	this.agsCur;
	}

	/**
	 * Column Info
	 * @return agsExe
	 */
	public	String getAgsExe() {
		return	this.agsExe;
	}

	/**
	 * Column Info
	 * @return ses
	 */
	public	String getSes() {
		return	this.ses;
	}

	/**
	 * Column Info
	 * @return sesCur
	 */
	public	String getSesCur() {
		return	this.sesCur;
	}

	/**
	 * Column Info
	 * @return sesExe
	 */
	public	String getSesExe() {
		return	this.sesExe;
	}

	/**
	 * Column Info
	 * @return gh2
	 */
	public	String getGh2() {
		return	this.gh2;
	}

	/**
	 * Column Info
	 * @return gh2Cur
	 */
	public	String getGh2Cur() {
		return	this.gh2Cur;
	}

	/**
	 * Column Info
	 * @return gh2Exe
	 */
	public	String getGh2Exe() {
		return	this.gh2Exe;
	}

	/**
	 * Column Info
	 * @return aps
	 */
	public	String getAps() {
		return	this.aps;
	}

	/**
	 * Column Info
	 * @return apsCur
	 */
	public	String getApsCur() {
		return	this.apsCur;
	}

	/**
	 * Column Info
	 * @return apsExe
	 */
	public	String getApsExe() {
		return	this.apsExe;
	}

	/**
	 * Column Info
	 * @return goh
	 */
	public	String getGoh() {
		return	this.goh;
	}

	/**
	 * Column Info
	 * @return gohCur
	 */
	public	String getGohCur() {
		return	this.gohCur;
	}

	/**
	 * Column Info
	 * @return gohExe
	 */
	public	String getGohExe() {
		return	this.gohExe;
	}

	/**
	 * Column Info
	 * @return hea
	 */
	public	String getHea() {
		return	this.hea;
	}

	/**
	 * Column Info
	 * @return heaCur
	 */
	public	String getHeaCur() {
		return	this.heaCur;
	}

	/**
	 * Column Info
	 * @return heaExe
	 */
	public	String getHeaExe() {
		return	this.heaExe;
	}

	/**
	 * Column Info
	 * @return haz
	 */
	public	String getHaz() {
		return	this.haz;
	}

	/**
	 * Column Info
	 * @return hazCur
	 */
	public	String getHazCur() {
		return	this.hazCur;
	}

	/**
	 * Column Info
	 * @return hazExe
	 */
	public	String getHazExe() {
		return	this.hazExe;
	}

	/**
	 * Column Info
	 * @return dgs
	 */
	public	String getDgs() {
		return	this.dgs;
	}

	/**
	 * Column Info
	 * @return dgsCur
	 */
	public	String getDgsCur() {
		return	this.dgsCur;
	}

	/**
	 * Column Info
	 * @return dgsExe
	 */
	public	String getDgsExe() {
		return	this.dgsExe;
	}

	/**
	 * Column Info
	 * @return effDt
	 */
	public	String getEffDt() {
		return	this.effDt;
	}

	/**
	 * Column Info
	 * @return expDt
	 */
	public	String getExpDt() {
		return	this.expDt;
	}

	/**
	 * Column Info
	 * @return remark
	 */
	public	String getRemark() {
		return	this.remark;
	}

 	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
	public void	setIbflag(String ibflag ) {
		this.ibflag =	ibflag;
	}
 	/**
	 * Page Number
	 * @param  pagerows
 	 */
	public void	setPagerows(String pagerows ) {
		this.pagerows =	pagerows;
	}
 	/**
	 * Column Info
	 * @param  nid
 	 */
	public void	setNid(String nid ) {
		this.nid =	nid;
	}
 	/**
	 * Column Info
	 * @param  batExeDt
 	 */
	public void	setBatExeDt(String batExeDt ) {
		this.batExeDt =	batExeDt;
	}
 	/**
	 * Column Info
	 * @param  shprCntCd
 	 */
	public void	setShprCntCd(String shprCntCd ) {
		this.shprCntCd =	shprCntCd;
	}
 	/**
	 * Column Info
	 * @param  shprSeq
 	 */
	public void	setShprSeq(String shprSeq ) {
		this.shprSeq =	shprSeq;
	}
 	/**
	 * Column Info
	 * @param  seq
 	 */
	public void	setSeq(String seq ) {
		this.seq =	seq;
	}
 	/**
	 * Column Info
	 * @param  carrier
 	 */
	public void	setCarrier(String carrier ) {
		this.carrier =	carrier;
	}
 	/**
	 * Column Info
	 * @param  ctrtNo
 	 */
	public void	setCtrtNo(String ctrtNo ) {
		this.ctrtNo =	ctrtNo;
	}
 	/**
	 * Column Info
	 * @param  ctrtHldNm
 	 */
	public void	setCtrtHldNm(String ctrtHldNm ) {
		this.ctrtHldNm =	ctrtHldNm;
	}
 	/**
	 * Column Info
	 * @param  bkgShprNm
 	 */
	public void	setBkgShprNm(String bkgShprNm ) {
		this.bkgShprNm =	bkgShprNm;
	}
 	/**
	 * Column Info
	 * @param  bkgCneeNm
 	 */
	public void	setBkgCneeNm(String bkgCneeNm ) {
		this.bkgCneeNm =	bkgCneeNm;
	}
 	/**
	 * Column Info
	 * @param  foreTraComp
 	 */
	public void	setForeTraComp(String foreTraComp ) {
		this.foreTraComp =	foreTraComp;
	}
 	/**
	 * Column Info
	 * @param  operAgt
 	 */
	public void	setOperAgt(String operAgt ) {
		this.operAgt =	operAgt;
	}
 	/**
	 * Column Info
	 * @param  lane
 	 */
	public void	setLane(String lane ) {
		this.lane =	lane;
	}
 	/**
	 * Column Info
	 * @param  wayPort
 	 */
	public void	setWayPort(String wayPort ) {
		this.wayPort =	wayPort;
	}
 	/**
	 * Column Info
	 * @param  polCd
 	 */
	public void	setPolCd(String polCd ) {
		this.polCd =	polCd;
	}
 	/**
	 * Column Info
	 * @param  deptTsitPort
 	 */
	public void	setDeptTsitPort(String deptTsitPort ) {
		this.deptTsitPort =	deptTsitPort;
	}
 	/**
	 * Column Info
	 * @param  destTsitPort
 	 */
	public void	setDestTsitPort(String destTsitPort ) {
		this.destTsitPort =	destTsitPort;
	}
 	/**
	 * Column Info
	 * @param  podCd
 	 */
	public void	setPodCd(String podCd ) {
		this.podCd =	podCd;
	}
 	/**
	 * Column Info
	 * @param  transTerm
 	 */
	public void	setTransTerm(String transTerm ) {
		this.transTerm =	transTerm;
	}
 	/**
	 * Column Info
	 * @param  cntrTp
 	 */
	public void	setCntrTp(String cntrTp ) {
		this.cntrTp =	cntrTp;
	}
 	/**
	 * Column Info
	 * @param  cmdtTp
 	 */
	public void	setCmdtTp(String cmdtTp ) {
		this.cmdtTp =	cmdtTp;
	}
 	/**
	 * Column Info
	 * @param  cntrSz
 	 */
	public void	setCntrSz(String cntrSz ) {
		this.cntrSz =	cntrSz;
	}
 	/**
	 * Column Info
	 * @param  cntrVol1
 	 */
	public void	setCntrVol1(String cntrVol1 ) {
		this.cntrVol1 =	cntrVol1;
	}
 	/**
	 * Column Info
	 * @param  cntrVol2
 	 */
	public void	setCntrVol2(String cntrVol2 ) {
		this.cntrVol2 =	cntrVol2;
	}
 	/**
	 * Column Info
	 * @param  oftRt
 	 */
	public void	setOftRt(String oftRt ) {
		this.oftRt =	oftRt;
	}
 	/**
	 * Column Info
	 * @param  com
 	 */
	public void	setCom(String com ) {
		this.com =	com;
	}
 	/**
	 * Column Info
	 * @param  cov
 	 */
	public void	setCov(String cov ) {
		this.cov =	cov;
	}
 	/**
	 * Column Info
	 * @param  covCur
 	 */
	public void	setCovCur(String covCur ) {
		this.covCur =	covCur;
	}
 	/**
	 * Column Info
	 * @param  covExe
 	 */
	public void	setCovExe(String covExe ) {
		this.covExe =	covExe;
	}
 	/**
	 * Column Info
	 * @param  cod
 	 */
	public void	setCod(String cod ) {
		this.cod =	cod;
	}
 	/**
	 * Column Info
	 * @param  codCur
 	 */
	public void	setCodCur(String codCur ) {
		this.codCur =	codCur;
	}
 	/**
	 * Column Info
	 * @param  codExe
 	 */
	public void	setCodExe(String codExe ) {
		this.codExe =	codExe;
	}
 	/**
	 * Column Info
	 * @param  ocr
 	 */
	public void	setOcr(String ocr ) {
		this.ocr =	ocr;
	}
 	/**
	 * Column Info
	 * @param  crs
 	 */
	public void	setCrs(String crs ) {
		this.crs =	crs;
	}
 	/**
	 * Column Info
	 * @param  xei
 	 */
	public void	setXei(String xei ) {
		this.xei =	xei;
	}
 	/**
	 * Column Info
	 * @param  kcs
 	 */
	public void	setKcs(String kcs ) {
		this.kcs =	kcs;
	}
 	/**
	 * Column Info
	 * @param  ams
 	 */
	public void	setAms(String ams ) {
		this.ams =	ams;
	}
 	/**
	 * Column Info
	 * @param  dpc
 	 */
	public void	setDpc(String dpc ) {
		this.dpc =	dpc;
	}
 	/**
	 * Column Info
	 * @param  prs
 	 */
	public void	setPrs(String prs ) {
		this.prs =	prs;
	}
 	/**
	 * Column Info
	 * @param  enq
 	 */
	public void	setEnq(String enq ) {
		this.enq =	enq;
	}
 	/**
	 * Column Info
	 * @param  chc
 	 */
	public void	setChc(String chc ) {
		this.chc =	chc;
	}
 	/**
	 * Column Info
	 * @param  ama
 	 */
	public void	setAma(String ama ) {
		this.ama =	ama;
	}
 	/**
	 * Column Info
	 * @param  adh
 	 */
	public void	setAdh(String adh ) {
		this.adh =	adh;
	}
 	/**
	 * Column Info
	 * @param  gen
 	 */
	public void	setGen(String gen ) {
		this.gen =	gen;
	}
 	/**
	 * Column Info
	 * @param  dem
 	 */
	public void	setDem(String dem ) {
		this.dem =	dem;
	}
 	/**
	 * Column Info
	 * @param  det
 	 */
	public void	setDet(String det ) {
		this.det =	det;
	}
 	/**
	 * Column Info
	 * @param  xsw
 	 */
	public void	setXsw(String xsw ) {
		this.xsw =	xsw;
	}
 	/**
	 * Column Info
	 * @param  xbs
 	 */
	public void	setXbs(String xbs ) {
		this.xbs =	xbs;
	}
 	/**
	 * Column Info
	 * @param  xbr
 	 */
	public void	setXbr(String xbr ) {
		this.xbr =	xbr;
	}
 	/**
	 * Column Info
	 * @param  xba
 	 */
	public void	setXba(String xba ) {
		this.xba =	xba;
	}
 	/**
	 * Column Info
	 * @param  bkf
 	 */
	public void	setBkf(String bkf ) {
		this.bkf =	bkf;
	}
 	/**
	 * Column Info
	 * @param  wha
 	 */
	public void	setWha(String wha ) {
		this.wha =	wha;
	}
 	/**
	 * Column Info
	 * @param  tsl
 	 */
	public void	setTsl(String tsl ) {
		this.tsl =	tsl;
	}
 	/**
	 * Column Info
	 * @param  tsd
 	 */
	public void	setTsd(String tsd ) {
		this.tsd =	tsd;
	}
 	/**
	 * Column Info
	 * @param  slf
 	 */
	public void	setSlf(String slf ) {
		this.slf =	slf;
	}
 	/**
	 * Column Info
	 * @param  rpc
 	 */
	public void	setRpc(String rpc ) {
		this.rpc =	rpc;
	}
 	/**
	 * Column Info
	 * @param  rls
 	 */
	public void	setRls(String rls ) {
		this.rls =	rls;
	}
 	/**
	 * Column Info
	 * @param  rha
 	 */
	public void	setRha(String rha ) {
		this.rha =	rha;
	}
 	/**
	 * Column Info
	 * @param  psc
 	 */
	public void	setPsc(String psc ) {
		this.psc =	psc;
	}
 	/**
	 * Column Info
	 * @param  mpl
 	 */
	public void	setMpl(String mpl ) {
		this.mpl =	mpl;
	}
 	/**
	 * Column Info
	 * @param  llo
 	 */
	public void	setLlo(String llo ) {
		this.llo =	llo;
	}
 	/**
	 * Column Info
	 * @param  psf
 	 */
	public void	setPsf(String psf ) {
		this.psf =	psf;
	}
 	/**
	 * Column Info
	 * @param  ins
 	 */
	public void	setIns(String ins ) {
		this.ins =	ins;
	}
 	/**
	 * Column Info
	 * @param  ifi
 	 */
	public void	setIfi(String ifi ) {
		this.ifi =	ifi;
	}
 	/**
	 * Column Info
	 * @param  haf
 	 */
	public void	setHaf(String haf ) {
		this.haf =	haf;
	}
 	/**
	 * Column Info
	 * @param  hau
 	 */
	public void	setHau(String hau ) {
		this.hau =	hau;
	}
 	/**
	 * Column Info
	 * @param  aha
 	 */
	public void	setAha(String aha ) {
		this.aha =	aha;
	}
 	/**
	 * Column Info
	 * @param  gat
 	 */
	public void	setGat(String gat ) {
		this.gat =	gat;
	}
 	/**
	 * Column Info
	 * @param  fdr
 	 */
	public void	setFdr(String fdr ) {
		this.fdr =	fdr;
	}
 	/**
	 * Column Info
	 * @param  fed
 	 */
	public void	setFed(String fed ) {
		this.fed =	fed;
	}
 	/**
	 * Column Info
	 * @param  fmf
 	 */
	public void	setFmf(String fmf ) {
		this.fmf =	fmf;
	}
 	/**
	 * Column Info
	 * @param  esd
 	 */
	public void	setEsd(String esd ) {
		this.esd =	esd;
	}
 	/**
	 * Column Info
	 * @param  emp
 	 */
	public void	setEmp(String emp ) {
		this.emp =	emp;
	}
 	/**
	 * Column Info
	 * @param  elo
 	 */
	public void	setElo(String elo ) {
		this.elo =	elo;
	}
 	/**
	 * Column Info
	 * @param  ehd
 	 */
	public void	setEhd(String ehd ) {
		this.ehd =	ehd;
	}
 	/**
	 * Column Info
	 * @param  edi
 	 */
	public void	setEdi(String edi ) {
		this.edi =	edi;
	}
 	/**
	 * Column Info
	 * @param  emr
 	 */
	public void	setEmr(String emr ) {
		this.emr =	emr;
	}
 	/**
	 * Column Info
	 * @param  drp
 	 */
	public void	setDrp(String drp ) {
		this.drp =	drp;
	}
 	/**
	 * Column Info
	 * @param  xdo
 	 */
	public void	setXdo(String xdo ) {
		this.xdo =	xdo;
	}
 	/**
	 * Column Info
	 * @param  doc
 	 */
	public void	setDoc(String doc ) {
		this.doc =	doc;
	}
 	/**
	 * Column Info
	 * @param  esi
 	 */
	public void	setEsi(String esi ) {
		this.esi =	esi;
	}
 	/**
	 * Column Info
	 * @param  xdd
 	 */
	public void	setXdd(String xdd ) {
		this.xdd =	xdd;
	}
 	/**
	 * Column Info
	 * @param  dof
 	 */
	public void	setDof(String dof ) {
		this.dof =	dof;
	}
 	/**
	 * Column Info
	 * @param  dey
 	 */
	public void	setDey(String dey ) {
		this.dey =	dey;
	}
 	/**
	 * Column Info
	 * @param  xde
 	 */
	public void	setXde(String xde ) {
		this.xde =	xde;
	}
 	/**
	 * Column Info
	 * @param  cys
 	 */
	public void	setCys(String cys ) {
		this.cys =	cys;
	}
 	/**
	 * Column Info
	 * @param  cyr
 	 */
	public void	setCyr(String cyr ) {
		this.cyr =	cyr;
	}
 	/**
	 * Column Info
	 * @param  csv
 	 */
	public void	setCsv(String csv ) {
		this.csv =	csv;
	}
 	/**
	 * Column Info
	 * @param  cvc
 	 */
	public void	setCvc(String cvc ) {
		this.cvc =	cvc;
	}
 	/**
	 * Column Info
	 * @param  ctp
 	 */
	public void	setCtp(String ctp ) {
		this.ctp =	ctp;
	}
 	/**
	 * Column Info
	 * @param  cmc
 	 */
	public void	setCmc(String cmc ) {
		this.cmc =	cmc;
	}
 	/**
	 * Column Info
	 * @param  ccc
 	 */
	public void	setCcc(String ccc ) {
		this.ccc =	ccc;
	}
 	/**
	 * Column Info
	 * @param  cfd
 	 */
	public void	setCfd(String cfd ) {
		this.cfd =	cfd;
	}
 	/**
	 * Column Info
	 * @param  cdc
 	 */
	public void	setCdc(String cdc ) {
		this.cdc =	cdc;
	}
 	/**
	 * Column Info
	 * @param  xwf
 	 */
	public void	setXwf(String xwf ) {
		this.xwf =	xwf;
	}
 	/**
	 * Column Info
	 * @param  cdd
 	 */
	public void	setCdd(String cdd ) {
		this.cdd =	cdd;
	}
 	/**
	 * Column Info
	 * @param  bao
 	 */
	public void	setBao(String bao ) {
		this.bao =	bao;
	}
 	/**
	 * Column Info
	 * @param  bad
 	 */
	public void	setBad(String bad ) {
		this.bad =	bad;
	}
 	/**
	 * Column Info
	 * @param  bio
 	 */
	public void	setBio(String bio ) {
		this.bio =	bio;
	}
 	/**
	 * Column Info
	 * @param  ard
 	 */
	public void	setArd(String ard ) {
		this.ard =	ard;
	}
 	/**
	 * Column Info
	 * @param  alm
 	 */
	public void	setAlm(String alm ) {
		this.alm =	alm;
	}
 	/**
	 * Column Info
	 * @param  baf
 	 */
	public void	setBaf(String baf ) {
		this.baf =	baf;
	}
 	/**
	 * Column Info
	 * @param  caf
 	 */
	public void	setCaf(String caf ) {
		this.caf =	caf;
	}
 	/**
	 * Column Info
	 * @param  ref
 	 */
	public void	setRef(String ref ) {
		this.ref =	ref;
	}
 	/**
	 * Column Info
	 * @param  rsd
 	 */
	public void	setRsd(String rsd ) {
		this.rsd =	rsd;
	}
 	/**
	 * Column Info
	 * @param  thl
 	 */
	public void	setThl(String thl ) {
		this.thl =	thl;
	}
 	/**
	 * Column Info
	 * @param  thd
 	 */
	public void	setThd(String thd ) {
		this.thd =	thd;
	}
 	/**
	 * Column Info
	 * @param  xer
 	 */
	public void	setXer(String xer ) {
		this.xer =	xer;
	}
 	/**
	 * Column Info
	 * @param  neo
 	 */
	public void	setNeo(String neo ) {
		this.neo =	neo;
	}
 	/**
	 * Column Info
	 * @param  neoCur
 	 */
	public void	setNeoCur(String neoCur ) {
		this.neoCur =	neoCur;
	}
 	/**
	 * Column Info
	 * @param  neoExe
 	 */
	public void	setNeoExe(String neoExe ) {
		this.neoExe =	neoExe;
	}
 	/**
	 * Column Info
	 * @param  wtr
 	 */
	public void	setWtr(String wtr ) {
		this.wtr =	wtr;
	}
 	/**
	 * Column Info
	 * @param  wtrCur
 	 */
	public void	setWtrCur(String wtrCur ) {
		this.wtrCur =	wtrCur;
	}
 	/**
	 * Column Info
	 * @param  wtrExe
 	 */
	public void	setWtrExe(String wtrExe ) {
		this.wtrExe =	wtrExe;
	}
 	/**
	 * Column Info
	 * @param  eca
 	 */
	public void	setEca(String eca ) {
		this.eca =	eca;
	}
 	/**
	 * Column Info
	 * @param  ecaCur
 	 */
	public void	setEcaCur(String ecaCur ) {
		this.ecaCur =	ecaCur;
	}
 	/**
	 * Column Info
	 * @param  ecaExe
 	 */
	public void	setEcaExe(String ecaExe ) {
		this.ecaExe =	ecaExe;
	}
 	/**
	 * Column Info
	 * @param  wrc
 	 */
	public void	setWrc(String wrc ) {
		this.wrc =	wrc;
	}
 	/**
	 * Column Info
	 * @param  wrcCur
 	 */
	public void	setWrcCur(String wrcCur ) {
		this.wrcCur =	wrcCur;
	}
 	/**
	 * Column Info
	 * @param  wrcExe
 	 */
	public void	setWrcExe(String wrcExe ) {
		this.wrcExe =	wrcExe;
	}
 	/**
	 * Column Info
	 * @param  tcs
 	 */
	public void	setTcs(String tcs ) {
		this.tcs =	tcs;
	}
 	/**
	 * Column Info
	 * @param  tcsCur
 	 */
	public void	setTcsCur(String tcsCur ) {
		this.tcsCur =	tcsCur;
	}
 	/**
	 * Column Info
	 * @param  tcsExe
 	 */
	public void	setTcsExe(String tcsExe ) {
		this.tcsExe =	tcsExe;
	}
 	/**
	 * Column Info
	 * @param  win
 	 */
	public void	setWin(String win ) {
		this.win =	win;
	}
 	/**
	 * Column Info
	 * @param  winCur
 	 */
	public void	setWinCur(String winCur ) {
		this.winCur =	winCur;
	}
 	/**
	 * Column Info
	 * @param  winExe
 	 */
	public void	setWinExe(String winExe ) {
		this.winExe =	winExe;
	}
 	/**
	 * Column Info
	 * @param  yas
 	 */
	public void	setYas(String yas ) {
		this.yas =	yas;
	}
 	/**
	 * Column Info
	 * @param  yasCur
 	 */
	public void	setYasCur(String yasCur ) {
		this.yasCur =	yasCur;
	}
 	/**
	 * Column Info
	 * @param  yasExe
 	 */
	public void	setYasExe(String yasExe ) {
		this.yasExe =	yasExe;
	}
 	/**
	 * Column Info
	 * @param  spt
 	 */
	public void	setSpt(String spt ) {
		this.spt =	spt;
	}
 	/**
	 * Column Info
	 * @param  sptCur
 	 */
	public void	setSptCur(String sptCur ) {
		this.sptCur =	sptCur;
	}
 	/**
	 * Column Info
	 * @param  sptExe
 	 */
	public void	setSptExe(String sptExe ) {
		this.sptExe =	sptExe;
	}
 	/**
	 * Column Info
	 * @param  sct
 	 */
	public void	setSct(String sct ) {
		this.sct =	sct;
	}
 	/**
	 * Column Info
	 * @param  sctCur
 	 */
	public void	setSctCur(String sctCur ) {
		this.sctCur =	sctCur;
	}
 	/**
	 * Column Info
	 * @param  sctExe
 	 */
	public void	setSctExe(String sctExe ) {
		this.sctExe =	sctExe;
	}
 	/**
	 * Column Info
	 * @param  pss
 	 */
	public void	setPss(String pss ) {
		this.pss =	pss;
	}
 	/**
	 * Column Info
	 * @param  pssCur
 	 */
	public void	setPssCur(String pssCur ) {
		this.pssCur =	pssCur;
	}
 	/**
	 * Column Info
	 * @param  pssExe
 	 */
	public void	setPssExe(String pssExe ) {
		this.pssExe =	pssExe;
	}
 	/**
	 * Column Info
	 * @param  pct
 	 */
	public void	setPct(String pct ) {
		this.pct =	pct;
	}
 	/**
	 * Column Info
	 * @param  pctCur
 	 */
	public void	setPctCur(String pctCur ) {
		this.pctCur =	pctCur;
	}
 	/**
	 * Column Info
	 * @param  pctExe
 	 */
	public void	setPctExe(String pctExe ) {
		this.pctExe =	pctExe;
	}
 	/**
	 * Column Info
	 * @param  lsf
 	 */
	public void	setLsf(String lsf ) {
		this.lsf =	lsf;
	}
 	/**
	 * Column Info
	 * @param  lsfCur
 	 */
	public void	setLsfCur(String lsfCur ) {
		this.lsfCur =	lsfCur;
	}
 	/**
	 * Column Info
	 * @param  lsfExe
 	 */
	public void	setLsfExe(String lsfExe ) {
		this.lsfExe =	lsfExe;
	}
 	/**
	 * Column Info
	 * @param  faf
 	 */
	public void	setFaf(String faf ) {
		this.faf =	faf;
	}
 	/**
	 * Column Info
	 * @param  fafCur
 	 */
	public void	setFafCur(String fafCur ) {
		this.fafCur =	fafCur;
	}
 	/**
	 * Column Info
	 * @param  fafExe
 	 */
	public void	setFafExe(String fafExe ) {
		this.fafExe =	fafExe;
	}
 	/**
	 * Column Info
	 * @param  ers
 	 */
	public void	setErs(String ers ) {
		this.ers =	ers;
	}
 	/**
	 * Column Info
	 * @param  ersCur
 	 */
	public void	setErsCur(String ersCur ) {
		this.ersCur =	ersCur;
	}
 	/**
	 * Column Info
	 * @param  ersExe
 	 */
	public void	setErsExe(String ersExe ) {
		this.ersExe =	ersExe;
	}
 	/**
	 * Column Info
	 * @param  eis
 	 */
	public void	setEis(String eis ) {
		this.eis =	eis;
	}
 	/**
	 * Column Info
	 * @param  eisCur
 	 */
	public void	setEisCur(String eisCur ) {
		this.eisCur =	eisCur;
	}
 	/**
	 * Column Info
	 * @param  eisExe
 	 */
	public void	setEisExe(String eisExe ) {
		this.eisExe =	eisExe;
	}
 	/**
	 * Column Info
	 * @param  env
 	 */
	public void	setEnv(String env ) {
		this.env =	env;
	}
 	/**
	 * Column Info
	 * @param  envCur
 	 */
	public void	setEnvCur(String envCur ) {
		this.envCur =	envCur;
	}
 	/**
	 * Column Info
	 * @param  envExe
 	 */
	public void	setEnvExe(String envExe ) {
		this.envExe =	envExe;
	}
 	/**
	 * Column Info
	 * @param  ems
 	 */
	public void	setEms(String ems ) {
		this.ems =	ems;
	}
 	/**
	 * Column Info
	 * @param  emsCur
 	 */
	public void	setEmsCur(String emsCur ) {
		this.emsCur =	emsCur;
	}
 	/**
	 * Column Info
	 * @param  emsExe
 	 */
	public void	setEmsExe(String emsExe ) {
		this.emsExe =	emsExe;
	}
 	/**
	 * Column Info
	 * @param  ebs
 	 */
	public void	setEbs(String ebs ) {
		this.ebs =	ebs;
	}
 	/**
	 * Column Info
	 * @param  ebsCur
 	 */
	public void	setEbsCur(String ebsCur ) {
		this.ebsCur =	ebsCur;
	}
 	/**
	 * Column Info
	 * @param  ebsExe
 	 */
	public void	setEbsExe(String ebsExe ) {
		this.ebsExe =	ebsExe;
	}
 	/**
	 * Column Info
	 * @param  eba
 	 */
	public void	setEba(String eba ) {
		this.eba =	eba;
	}
 	/**
	 * Column Info
	 * @param  ebaCur
 	 */
	public void	setEbaCur(String ebaCur ) {
		this.ebaCur =	ebaCur;
	}
 	/**
	 * Column Info
	 * @param  ebaExe
 	 */
	public void	setEbaExe(String ebaExe ) {
		this.ebaExe =	ebaExe;
	}
 	/**
	 * Column Info
	 * @param  eri
 	 */
	public void	setEri(String eri ) {
		this.eri =	eri;
	}
 	/**
	 * Column Info
	 * @param  eriCur
 	 */
	public void	setEriCur(String eriCur ) {
		this.eriCur =	eriCur;
	}
 	/**
	 * Column Info
	 * @param  eriExe
 	 */
	public void	setEriExe(String eriExe ) {
		this.eriExe =	eriExe;
	}
 	/**
	 * Column Info
	 * @param  dcf
 	 */
	public void	setDcf(String dcf ) {
		this.dcf =	dcf;
	}
 	/**
	 * Column Info
	 * @param  dcfCur
 	 */
	public void	setDcfCur(String dcfCur ) {
		this.dcfCur =	dcfCur;
	}
 	/**
	 * Column Info
	 * @param  dcfExe
 	 */
	public void	setDcfExe(String dcfExe ) {
		this.dcfExe =	dcfExe;
	}
 	/**
	 * Column Info
	 * @param  cbr
 	 */
	public void	setCbr(String cbr ) {
		this.cbr =	cbr;
	}
 	/**
	 * Column Info
	 * @param  cbrCur
 	 */
	public void	setCbrCur(String cbrCur ) {
		this.cbrCur =	cbrCur;
	}
 	/**
	 * Column Info
	 * @param  cbrExe
 	 */
	public void	setCbrExe(String cbrExe ) {
		this.cbrExe =	cbrExe;
	}
 	/**
	 * Column Info
	 * @param  cgl
 	 */
	public void	setCgl(String cgl ) {
		this.cgl =	cgl;
	}
 	/**
	 * Column Info
	 * @param  cglCur
 	 */
	public void	setCglCur(String cglCur ) {
		this.cglCur =	cglCur;
	}
 	/**
	 * Column Info
	 * @param  cglExe
 	 */
	public void	setCglExe(String cglExe ) {
		this.cglExe =	cglExe;
	}
 	/**
	 * Column Info
	 * @param  cgd
 	 */
	public void	setCgd(String cgd ) {
		this.cgd =	cgd;
	}
 	/**
	 * Column Info
	 * @param  cgdCur
 	 */
	public void	setCgdCur(String cgdCur ) {
		this.cgdCur =	cgdCur;
	}
 	/**
	 * Column Info
	 * @param  cgdExe
 	 */
	public void	setCgdExe(String cgdExe ) {
		this.cgdExe =	cgdExe;
	}
 	/**
	 * Column Info
	 * @param  con
 	 */
	public void	setCon(String con ) {
		this.con =	con;
	}
 	/**
	 * Column Info
	 * @param  conCur
 	 */
	public void	setConCur(String conCur ) {
		this.conCur =	conCur;
	}
 	/**
	 * Column Info
	 * @param  conExe
 	 */
	public void	setConExe(String conExe ) {
		this.conExe =	conExe;
	}
 	/**
	 * Column Info
	 * @param  css
 	 */
	public void	setCss(String css ) {
		this.css =	css;
	}
 	/**
	 * Column Info
	 * @param  cssCur
 	 */
	public void	setCssCur(String cssCur ) {
		this.cssCur =	cssCur;
	}
 	/**
	 * Column Info
	 * @param  cssExe
 	 */
	public void	setCssExe(String cssExe ) {
		this.cssExe =	cssExe;
	}
 	/**
	 * Column Info
	 * @param  bct
 	 */
	public void	setBct(String bct ) {
		this.bct =	bct;
	}
 	/**
	 * Column Info
	 * @param  bctCur
 	 */
	public void	setBctCur(String bctCur ) {
		this.bctCur =	bctCur;
	}
 	/**
	 * Column Info
	 * @param  bctExe
 	 */
	public void	setBctExe(String bctExe ) {
		this.bctExe =	bctExe;
	}
 	/**
	 * Column Info
	 * @param  afa
 	 */
	public void	setAfa(String afa ) {
		this.afa =	afa;
	}
 	/**
	 * Column Info
	 * @param  afaCur
 	 */
	public void	setAfaCur(String afaCur ) {
		this.afaCur =	afaCur;
	}
 	/**
	 * Column Info
	 * @param  afaExe
 	 */
	public void	setAfaExe(String afaExe ) {
		this.afaExe =	afaExe;
	}
 	/**
	 * Column Info
	 * @param  ags
 	 */
	public void	setAgs(String ags ) {
		this.ags =	ags;
	}
 	/**
	 * Column Info
	 * @param  agsCur
 	 */
	public void	setAgsCur(String agsCur ) {
		this.agsCur =	agsCur;
	}
 	/**
	 * Column Info
	 * @param  agsExe
 	 */
	public void	setAgsExe(String agsExe ) {
		this.agsExe =	agsExe;
	}
 	/**
	 * Column Info
	 * @param  ses
 	 */
	public void	setSes(String ses ) {
		this.ses =	ses;
	}
 	/**
	 * Column Info
	 * @param  sesCur
 	 */
	public void	setSesCur(String sesCur ) {
		this.sesCur =	sesCur;
	}
 	/**
	 * Column Info
	 * @param  sesExe
 	 */
	public void	setSesExe(String sesExe ) {
		this.sesExe =	sesExe;
	}
 	/**
	 * Column Info
	 * @param  gh2
 	 */
	public void	setGh2(String gh2 ) {
		this.gh2 =	gh2;
	}
 	/**
	 * Column Info
	 * @param  gh2Cur
 	 */
	public void	setGh2Cur(String gh2Cur ) {
		this.gh2Cur =	gh2Cur;
	}
 	/**
	 * Column Info
	 * @param  gh2Exe
 	 */
	public void	setGh2Exe(String gh2Exe ) {
		this.gh2Exe =	gh2Exe;
	}
 	/**
	 * Column Info
	 * @param  aps
 	 */
	public void	setAps(String aps ) {
		this.aps =	aps;
	}
 	/**
	 * Column Info
	 * @param  apsCur
 	 */
	public void	setApsCur(String apsCur ) {
		this.apsCur =	apsCur;
	}
 	/**
	 * Column Info
	 * @param  apsExe
 	 */
	public void	setApsExe(String apsExe ) {
		this.apsExe =	apsExe;
	}
 	/**
	 * Column Info
	 * @param  goh
 	 */
	public void	setGoh(String goh ) {
		this.goh =	goh;
	}
 	/**
	 * Column Info
	 * @param  gohCur
 	 */
	public void	setGohCur(String gohCur ) {
		this.gohCur =	gohCur;
	}
 	/**
	 * Column Info
	 * @param  gohExe
 	 */
	public void	setGohExe(String gohExe ) {
		this.gohExe =	gohExe;
	}
 	/**
	 * Column Info
	 * @param  hea
 	 */
	public void	setHea(String hea ) {
		this.hea =	hea;
	}
 	/**
	 * Column Info
	 * @param  heaCur
 	 */
	public void	setHeaCur(String heaCur ) {
		this.heaCur =	heaCur;
	}
 	/**
	 * Column Info
	 * @param  heaExe
 	 */
	public void	setHeaExe(String heaExe ) {
		this.heaExe =	heaExe;
	}
 	/**
	 * Column Info
	 * @param  haz
 	 */
	public void	setHaz(String haz ) {
		this.haz =	haz;
	}
 	/**
	 * Column Info
	 * @param  hazCur
 	 */
	public void	setHazCur(String hazCur ) {
		this.hazCur =	hazCur;
	}
 	/**
	 * Column Info
	 * @param  hazExe
 	 */
	public void	setHazExe(String hazExe ) {
		this.hazExe =	hazExe;
	}
 	/**
	 * Column Info
	 * @param  dgs
 	 */
	public void	setDgs(String dgs ) {
		this.dgs =	dgs;
	}
 	/**
	 * Column Info
	 * @param  dgsCur
 	 */
	public void	setDgsCur(String dgsCur ) {
		this.dgsCur =	dgsCur;
	}
 	/**
	 * Column Info
	 * @param  dgsExe
 	 */
	public void	setDgsExe(String dgsExe ) {
		this.dgsExe =	dgsExe;
	}
 	/**
	 * Column Info
	 * @param  effDt
 	 */
	public void	setEffDt(String effDt ) {
		this.effDt =	effDt;
	}
 	/**
	 * Column Info
	 * @param  expDt
 	 */
	public void	setExpDt(String expDt ) {
		this.expDt =	expDt;
	}
 	/**
	 * Column Info
	 * @param  remark
 	 */
	public void	setRemark(String remark ) {
		this.remark =	remark;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setNid(JSPUtil.getParameter(request,	prefix + "nid", ""));
		setBatExeDt(JSPUtil.getParameter(request,	prefix + "bat_exe_dt", ""));
		setShprCntCd(JSPUtil.getParameter(request,	prefix + "shpr_cnt_cd", ""));
		setShprSeq(JSPUtil.getParameter(request,	prefix + "shpr_seq", ""));
		setSeq(JSPUtil.getParameter(request,	prefix + "seq", ""));
		setCarrier(JSPUtil.getParameter(request,	prefix + "carrier", ""));
		setCtrtNo(JSPUtil.getParameter(request,	prefix + "ctrt_no", ""));
		setCtrtHldNm(JSPUtil.getParameter(request,	prefix + "ctrt_hld_nm", ""));
		setBkgShprNm(JSPUtil.getParameter(request,	prefix + "bkg_shpr_nm", ""));
		setBkgCneeNm(JSPUtil.getParameter(request,	prefix + "bkg_cnee_nm", ""));
		setForeTraComp(JSPUtil.getParameter(request,	prefix + "fore_tra_comp", ""));
		setOperAgt(JSPUtil.getParameter(request,	prefix + "oper_agt", ""));
		setLane(JSPUtil.getParameter(request,	prefix + "lane", ""));
		setWayPort(JSPUtil.getParameter(request,	prefix + "way_port", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setDeptTsitPort(JSPUtil.getParameter(request,	prefix + "dept_tsit_port", ""));
		setDestTsitPort(JSPUtil.getParameter(request,	prefix + "dest_tsit_port", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setTransTerm(JSPUtil.getParameter(request,	prefix + "trans_term", ""));
		setCntrTp(JSPUtil.getParameter(request,	prefix + "cntr_tp", ""));
		setCmdtTp(JSPUtil.getParameter(request,	prefix + "cmdt_tp", ""));
		setCntrSz(JSPUtil.getParameter(request,	prefix + "cntr_sz", ""));
		setCntrVol1(JSPUtil.getParameter(request,	prefix + "cntr_vol1", ""));
		setCntrVol2(JSPUtil.getParameter(request,	prefix + "cntr_vol2", ""));
		setOftRt(JSPUtil.getParameter(request,	prefix + "oft_rt", ""));
		setCom(JSPUtil.getParameter(request,	prefix + "com", ""));
		setCov(JSPUtil.getParameter(request,	prefix + "cov", ""));
		setCovCur(JSPUtil.getParameter(request,	prefix + "cov_cur", ""));
		setCovExe(JSPUtil.getParameter(request,	prefix + "cov_exe", ""));
		setCod(JSPUtil.getParameter(request,	prefix + "cod", ""));
		setCodCur(JSPUtil.getParameter(request,	prefix + "cod_cur", ""));
		setCodExe(JSPUtil.getParameter(request,	prefix + "cod_exe", ""));
		setOcr(JSPUtil.getParameter(request,	prefix + "ocr", ""));
		setCrs(JSPUtil.getParameter(request,	prefix + "crs", ""));
		setXei(JSPUtil.getParameter(request,	prefix + "xei", ""));
		setKcs(JSPUtil.getParameter(request,	prefix + "kcs", ""));
		setAms(JSPUtil.getParameter(request,	prefix + "ams", ""));
		setDpc(JSPUtil.getParameter(request,	prefix + "dpc", ""));
		setPrs(JSPUtil.getParameter(request,	prefix + "prs", ""));
		setEnq(JSPUtil.getParameter(request,	prefix + "enq", ""));
		setChc(JSPUtil.getParameter(request,	prefix + "chc", ""));
		setAma(JSPUtil.getParameter(request,	prefix + "ama", ""));
		setAdh(JSPUtil.getParameter(request,	prefix + "adh", ""));
		setGen(JSPUtil.getParameter(request,	prefix + "gen", ""));
		setDem(JSPUtil.getParameter(request,	prefix + "dem", ""));
		setDet(JSPUtil.getParameter(request,	prefix + "det", ""));
		setXsw(JSPUtil.getParameter(request,	prefix + "xsw", ""));
		setXbs(JSPUtil.getParameter(request,	prefix + "xbs", ""));
		setXbr(JSPUtil.getParameter(request,	prefix + "xbr", ""));
		setXba(JSPUtil.getParameter(request,	prefix + "xba", ""));
		setBkf(JSPUtil.getParameter(request,	prefix + "bkf", ""));
		setWha(JSPUtil.getParameter(request,	prefix + "wha", ""));
		setTsl(JSPUtil.getParameter(request,	prefix + "tsl", ""));
		setTsd(JSPUtil.getParameter(request,	prefix + "tsd", ""));
		setSlf(JSPUtil.getParameter(request,	prefix + "slf", ""));
		setRpc(JSPUtil.getParameter(request,	prefix + "rpc", ""));
		setRls(JSPUtil.getParameter(request,	prefix + "rls", ""));
		setRha(JSPUtil.getParameter(request,	prefix + "rha", ""));
		setPsc(JSPUtil.getParameter(request,	prefix + "psc", ""));
		setMpl(JSPUtil.getParameter(request,	prefix + "mpl", ""));
		setLlo(JSPUtil.getParameter(request,	prefix + "llo", ""));
		setPsf(JSPUtil.getParameter(request,	prefix + "psf", ""));
		setIns(JSPUtil.getParameter(request,	prefix + "ins", ""));
		setIfi(JSPUtil.getParameter(request,	prefix + "ifi", ""));
		setHaf(JSPUtil.getParameter(request,	prefix + "haf", ""));
		setHau(JSPUtil.getParameter(request,	prefix + "hau", ""));
		setAha(JSPUtil.getParameter(request,	prefix + "aha", ""));
		setGat(JSPUtil.getParameter(request,	prefix + "gat", ""));
		setFdr(JSPUtil.getParameter(request,	prefix + "fdr", ""));
		setFed(JSPUtil.getParameter(request,	prefix + "fed", ""));
		setFmf(JSPUtil.getParameter(request,	prefix + "fmf", ""));
		setEsd(JSPUtil.getParameter(request,	prefix + "esd", ""));
		setEmp(JSPUtil.getParameter(request,	prefix + "emp", ""));
		setElo(JSPUtil.getParameter(request,	prefix + "elo", ""));
		setEhd(JSPUtil.getParameter(request,	prefix + "ehd", ""));
		setEdi(JSPUtil.getParameter(request,	prefix + "edi", ""));
		setEmr(JSPUtil.getParameter(request,	prefix + "emr", ""));
		setDrp(JSPUtil.getParameter(request,	prefix + "drp", ""));
		setXdo(JSPUtil.getParameter(request,	prefix + "xdo", ""));
		setDoc(JSPUtil.getParameter(request,	prefix + "doc", ""));
		setEsi(JSPUtil.getParameter(request,	prefix + "esi", ""));
		setXdd(JSPUtil.getParameter(request,	prefix + "xdd", ""));
		setDof(JSPUtil.getParameter(request,	prefix + "dof", ""));
		setDey(JSPUtil.getParameter(request,	prefix + "dey", ""));
		setXde(JSPUtil.getParameter(request,	prefix + "xde", ""));
		setCys(JSPUtil.getParameter(request,	prefix + "cys", ""));
		setCyr(JSPUtil.getParameter(request,	prefix + "cyr", ""));
		setCsv(JSPUtil.getParameter(request,	prefix + "csv", ""));
		setCvc(JSPUtil.getParameter(request,	prefix + "cvc", ""));
		setCtp(JSPUtil.getParameter(request,	prefix + "ctp", ""));
		setCmc(JSPUtil.getParameter(request,	prefix + "cmc", ""));
		setCcc(JSPUtil.getParameter(request,	prefix + "ccc", ""));
		setCfd(JSPUtil.getParameter(request,	prefix + "cfd", ""));
		setCdc(JSPUtil.getParameter(request,	prefix + "cdc", ""));
		setXwf(JSPUtil.getParameter(request,	prefix + "xwf", ""));
		setCdd(JSPUtil.getParameter(request,	prefix + "cdd", ""));
		setBao(JSPUtil.getParameter(request,	prefix + "bao", ""));
		setBad(JSPUtil.getParameter(request,	prefix + "bad", ""));
		setBio(JSPUtil.getParameter(request,	prefix + "bio", ""));
		setArd(JSPUtil.getParameter(request,	prefix + "ard", ""));
		setAlm(JSPUtil.getParameter(request,	prefix + "alm", ""));
		setBaf(JSPUtil.getParameter(request,	prefix + "baf", ""));
		setCaf(JSPUtil.getParameter(request,	prefix + "caf", ""));
		setRef(JSPUtil.getParameter(request,	prefix + "ref", ""));
		setRsd(JSPUtil.getParameter(request,	prefix + "rsd", ""));
		setThl(JSPUtil.getParameter(request,	prefix + "thl", ""));
		setThd(JSPUtil.getParameter(request,	prefix + "thd", ""));
		setXer(JSPUtil.getParameter(request,	prefix + "xer", ""));
		setNeo(JSPUtil.getParameter(request,	prefix + "neo", ""));
		setNeoCur(JSPUtil.getParameter(request,	prefix + "neo_cur", ""));
		setNeoExe(JSPUtil.getParameter(request,	prefix + "neo_exe", ""));
		setWtr(JSPUtil.getParameter(request,	prefix + "wtr", ""));
		setWtrCur(JSPUtil.getParameter(request,	prefix + "wtr_cur", ""));
		setWtrExe(JSPUtil.getParameter(request,	prefix + "wtr_exe", ""));
		setEca(JSPUtil.getParameter(request,	prefix + "eca", ""));
		setEcaCur(JSPUtil.getParameter(request,	prefix + "eca_cur", ""));
		setEcaExe(JSPUtil.getParameter(request,	prefix + "eca_exe", ""));
		setWrc(JSPUtil.getParameter(request,	prefix + "wrc", ""));
		setWrcCur(JSPUtil.getParameter(request,	prefix + "wrc_cur", ""));
		setWrcExe(JSPUtil.getParameter(request,	prefix + "wrc_exe", ""));
		setTcs(JSPUtil.getParameter(request,	prefix + "tcs", ""));
		setTcsCur(JSPUtil.getParameter(request,	prefix + "tcs_cur", ""));
		setTcsExe(JSPUtil.getParameter(request,	prefix + "tcs_exe", ""));
		setWin(JSPUtil.getParameter(request,	prefix + "win", ""));
		setWinCur(JSPUtil.getParameter(request,	prefix + "win_cur", ""));
		setWinExe(JSPUtil.getParameter(request,	prefix + "win_exe", ""));
		setYas(JSPUtil.getParameter(request,	prefix + "yas", ""));
		setYasCur(JSPUtil.getParameter(request,	prefix + "yas_cur", ""));
		setYasExe(JSPUtil.getParameter(request,	prefix + "yas_exe", ""));
		setSpt(JSPUtil.getParameter(request,	prefix + "spt", ""));
		setSptCur(JSPUtil.getParameter(request,	prefix + "spt_cur", ""));
		setSptExe(JSPUtil.getParameter(request,	prefix + "spt_exe", ""));
		setSct(JSPUtil.getParameter(request,	prefix + "sct", ""));
		setSctCur(JSPUtil.getParameter(request,	prefix + "sct_cur", ""));
		setSctExe(JSPUtil.getParameter(request,	prefix + "sct_exe", ""));
		setPss(JSPUtil.getParameter(request,	prefix + "pss", ""));
		setPssCur(JSPUtil.getParameter(request,	prefix + "pss_cur", ""));
		setPssExe(JSPUtil.getParameter(request,	prefix + "pss_exe", ""));
		setPct(JSPUtil.getParameter(request,	prefix + "pct", ""));
		setPctCur(JSPUtil.getParameter(request,	prefix + "pct_cur", ""));
		setPctExe(JSPUtil.getParameter(request,	prefix + "pct_exe", ""));
		setLsf(JSPUtil.getParameter(request,	prefix + "lsf", ""));
		setLsfCur(JSPUtil.getParameter(request,	prefix + "lsf_cur", ""));
		setLsfExe(JSPUtil.getParameter(request,	prefix + "lsf_exe", ""));
		setFaf(JSPUtil.getParameter(request,	prefix + "faf", ""));
		setFafCur(JSPUtil.getParameter(request,	prefix + "faf_cur", ""));
		setFafExe(JSPUtil.getParameter(request,	prefix + "faf_exe", ""));
		setErs(JSPUtil.getParameter(request,	prefix + "ers", ""));
		setErsCur(JSPUtil.getParameter(request,	prefix + "ers_cur", ""));
		setErsExe(JSPUtil.getParameter(request,	prefix + "ers_exe", ""));
		setEis(JSPUtil.getParameter(request,	prefix + "eis", ""));
		setEisCur(JSPUtil.getParameter(request,	prefix + "eis_cur", ""));
		setEisExe(JSPUtil.getParameter(request,	prefix + "eis_exe", ""));
		setEnv(JSPUtil.getParameter(request,	prefix + "env", ""));
		setEnvCur(JSPUtil.getParameter(request,	prefix + "env_cur", ""));
		setEnvExe(JSPUtil.getParameter(request,	prefix + "env_exe", ""));
		setEms(JSPUtil.getParameter(request,	prefix + "ems", ""));
		setEmsCur(JSPUtil.getParameter(request,	prefix + "ems_cur", ""));
		setEmsExe(JSPUtil.getParameter(request,	prefix + "ems_exe", ""));
		setEbs(JSPUtil.getParameter(request,	prefix + "ebs", ""));
		setEbsCur(JSPUtil.getParameter(request,	prefix + "ebs_cur", ""));
		setEbsExe(JSPUtil.getParameter(request,	prefix + "ebs_exe", ""));
		setEba(JSPUtil.getParameter(request,	prefix + "eba", ""));
		setEbaCur(JSPUtil.getParameter(request,	prefix + "eba_cur", ""));
		setEbaExe(JSPUtil.getParameter(request,	prefix + "eba_exe", ""));
		setEri(JSPUtil.getParameter(request,	prefix + "eri", ""));
		setEriCur(JSPUtil.getParameter(request,	prefix + "eri_cur", ""));
		setEriExe(JSPUtil.getParameter(request,	prefix + "eri_exe", ""));
		setDcf(JSPUtil.getParameter(request,	prefix + "dcf", ""));
		setDcfCur(JSPUtil.getParameter(request,	prefix + "dcf_cur", ""));
		setDcfExe(JSPUtil.getParameter(request,	prefix + "dcf_exe", ""));
		setCbr(JSPUtil.getParameter(request,	prefix + "cbr", ""));
		setCbrCur(JSPUtil.getParameter(request,	prefix + "cbr_cur", ""));
		setCbrExe(JSPUtil.getParameter(request,	prefix + "cbr_exe", ""));
		setCgl(JSPUtil.getParameter(request,	prefix + "cgl", ""));
		setCglCur(JSPUtil.getParameter(request,	prefix + "cgl_cur", ""));
		setCglExe(JSPUtil.getParameter(request,	prefix + "cgl_exe", ""));
		setCgd(JSPUtil.getParameter(request,	prefix + "cgd", ""));
		setCgdCur(JSPUtil.getParameter(request,	prefix + "cgd_cur", ""));
		setCgdExe(JSPUtil.getParameter(request,	prefix + "cgd_exe", ""));
		setCon(JSPUtil.getParameter(request,	prefix + "con", ""));
		setConCur(JSPUtil.getParameter(request,	prefix + "con_cur", ""));
		setConExe(JSPUtil.getParameter(request,	prefix + "con_exe", ""));
		setCss(JSPUtil.getParameter(request,	prefix + "css", ""));
		setCssCur(JSPUtil.getParameter(request,	prefix + "css_cur", ""));
		setCssExe(JSPUtil.getParameter(request,	prefix + "css_exe", ""));
		setBct(JSPUtil.getParameter(request,	prefix + "bct", ""));
		setBctCur(JSPUtil.getParameter(request,	prefix + "bct_cur", ""));
		setBctExe(JSPUtil.getParameter(request,	prefix + "bct_exe", ""));
		setAfa(JSPUtil.getParameter(request,	prefix + "afa", ""));
		setAfaCur(JSPUtil.getParameter(request,	prefix + "afa_cur", ""));
		setAfaExe(JSPUtil.getParameter(request,	prefix + "afa_exe", ""));
		setAgs(JSPUtil.getParameter(request,	prefix + "ags", ""));
		setAgsCur(JSPUtil.getParameter(request,	prefix + "ags_cur", ""));
		setAgsExe(JSPUtil.getParameter(request,	prefix + "ags_exe", ""));
		setSes(JSPUtil.getParameter(request,	prefix + "ses", ""));
		setSesCur(JSPUtil.getParameter(request,	prefix + "ses_cur", ""));
		setSesExe(JSPUtil.getParameter(request,	prefix + "ses_exe", ""));
		setGh2(JSPUtil.getParameter(request,	prefix + "gh2", ""));
		setGh2Cur(JSPUtil.getParameter(request,	prefix + "gh2_cur", ""));
		setGh2Exe(JSPUtil.getParameter(request,	prefix + "gh2_exe", ""));
		setAps(JSPUtil.getParameter(request,	prefix + "aps", ""));
		setApsCur(JSPUtil.getParameter(request,	prefix + "aps_cur", ""));
		setApsExe(JSPUtil.getParameter(request,	prefix + "aps_exe", ""));
		setGoh(JSPUtil.getParameter(request,	prefix + "goh", ""));
		setGohCur(JSPUtil.getParameter(request,	prefix + "goh_cur", ""));
		setGohExe(JSPUtil.getParameter(request,	prefix + "goh_exe", ""));
		setHea(JSPUtil.getParameter(request,	prefix + "hea", ""));
		setHeaCur(JSPUtil.getParameter(request,	prefix + "hea_cur", ""));
		setHeaExe(JSPUtil.getParameter(request,	prefix + "hea_exe", ""));
		setHaz(JSPUtil.getParameter(request,	prefix + "haz", ""));
		setHazCur(JSPUtil.getParameter(request,	prefix + "haz_cur", ""));
		setHazExe(JSPUtil.getParameter(request,	prefix + "haz_exe", ""));
		setDgs(JSPUtil.getParameter(request,	prefix + "dgs", ""));
		setDgsCur(JSPUtil.getParameter(request,	prefix + "dgs_cur", ""));
		setDgsExe(JSPUtil.getParameter(request,	prefix + "dgs_exe", ""));
		setEffDt(JSPUtil.getParameter(request,	prefix + "eff_dt", ""));
		setExpDt(JSPUtil.getParameter(request,	prefix + "exp_dt", ""));
		setRemark(JSPUtil.getParameter(request,	prefix + "remark", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MotFilingExclVO[]
	 */
	public MotFilingExclVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return MotFilingExclVO[]
	 */
	public MotFilingExclVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		MotFilingExclVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] nid =	(JSPUtil.getParameter(request, prefix +	"nid",	length));
			String[] batExeDt =	(JSPUtil.getParameter(request, prefix +	"bat_exe_dt",	length));
			String[] shprCntCd =	(JSPUtil.getParameter(request, prefix +	"shpr_cnt_cd",	length));
			String[] shprSeq =	(JSPUtil.getParameter(request, prefix +	"shpr_seq",	length));
			String[] seq =	(JSPUtil.getParameter(request, prefix +	"seq",	length));
			String[] carrier =	(JSPUtil.getParameter(request, prefix +	"carrier",	length));
			String[] ctrtNo =	(JSPUtil.getParameter(request, prefix +	"ctrt_no",	length));
			String[] ctrtHldNm =	(JSPUtil.getParameter(request, prefix +	"ctrt_hld_nm",	length));
			String[] bkgShprNm =	(JSPUtil.getParameter(request, prefix +	"bkg_shpr_nm",	length));
			String[] bkgCneeNm =	(JSPUtil.getParameter(request, prefix +	"bkg_cnee_nm",	length));
			String[] foreTraComp =	(JSPUtil.getParameter(request, prefix +	"fore_tra_comp",	length));
			String[] operAgt =	(JSPUtil.getParameter(request, prefix +	"oper_agt",	length));
			String[] lane =	(JSPUtil.getParameter(request, prefix +	"lane",	length));
			String[] wayPort =	(JSPUtil.getParameter(request, prefix +	"way_port",	length));
			String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd",	length));
			String[] deptTsitPort =	(JSPUtil.getParameter(request, prefix +	"dept_tsit_port",	length));
			String[] destTsitPort =	(JSPUtil.getParameter(request, prefix +	"dest_tsit_port",	length));
			String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd",	length));
			String[] transTerm =	(JSPUtil.getParameter(request, prefix +	"trans_term",	length));
			String[] cntrTp =	(JSPUtil.getParameter(request, prefix +	"cntr_tp",	length));
			String[] cmdtTp =	(JSPUtil.getParameter(request, prefix +	"cmdt_tp",	length));
			String[] cntrSz =	(JSPUtil.getParameter(request, prefix +	"cntr_sz",	length));
			String[] cntrVol1 =	(JSPUtil.getParameter(request, prefix +	"cntr_vol1",	length));
			String[] cntrVol2 =	(JSPUtil.getParameter(request, prefix +	"cntr_vol2",	length));
			String[] oftRt =	(JSPUtil.getParameter(request, prefix +	"oft_rt",	length));
			String[] com =	(JSPUtil.getParameter(request, prefix +	"com",	length));
			String[] cov =	(JSPUtil.getParameter(request, prefix +	"cov",	length));
			String[] covCur =	(JSPUtil.getParameter(request, prefix +	"cov_cur",	length));
			String[] covExe =	(JSPUtil.getParameter(request, prefix +	"cov_exe",	length));
			String[] cod =	(JSPUtil.getParameter(request, prefix +	"cod",	length));
			String[] codCur =	(JSPUtil.getParameter(request, prefix +	"cod_cur",	length));
			String[] codExe =	(JSPUtil.getParameter(request, prefix +	"cod_exe",	length));
			String[] ocr =	(JSPUtil.getParameter(request, prefix +	"ocr",	length));
			String[] crs =	(JSPUtil.getParameter(request, prefix +	"crs",	length));
			String[] xei =	(JSPUtil.getParameter(request, prefix +	"xei",	length));
			String[] kcs =	(JSPUtil.getParameter(request, prefix +	"kcs",	length));
			String[] ams =	(JSPUtil.getParameter(request, prefix +	"ams",	length));
			String[] dpc =	(JSPUtil.getParameter(request, prefix +	"dpc",	length));
			String[] prs =	(JSPUtil.getParameter(request, prefix +	"prs",	length));
			String[] enq =	(JSPUtil.getParameter(request, prefix +	"enq",	length));
			String[] chc =	(JSPUtil.getParameter(request, prefix +	"chc",	length));
			String[] ama =	(JSPUtil.getParameter(request, prefix +	"ama",	length));
			String[] adh =	(JSPUtil.getParameter(request, prefix +	"adh",	length));
			String[] gen =	(JSPUtil.getParameter(request, prefix +	"gen",	length));
			String[] dem =	(JSPUtil.getParameter(request, prefix +	"dem",	length));
			String[] det =	(JSPUtil.getParameter(request, prefix +	"det",	length));
			String[] xsw =	(JSPUtil.getParameter(request, prefix +	"xsw",	length));
			String[] xbs =	(JSPUtil.getParameter(request, prefix +	"xbs",	length));
			String[] xbr =	(JSPUtil.getParameter(request, prefix +	"xbr",	length));
			String[] xba =	(JSPUtil.getParameter(request, prefix +	"xba",	length));
			String[] bkf =	(JSPUtil.getParameter(request, prefix +	"bkf",	length));
			String[] wha =	(JSPUtil.getParameter(request, prefix +	"wha",	length));
			String[] tsl =	(JSPUtil.getParameter(request, prefix +	"tsl",	length));
			String[] tsd =	(JSPUtil.getParameter(request, prefix +	"tsd",	length));
			String[] slf =	(JSPUtil.getParameter(request, prefix +	"slf",	length));
			String[] rpc =	(JSPUtil.getParameter(request, prefix +	"rpc",	length));
			String[] rls =	(JSPUtil.getParameter(request, prefix +	"rls",	length));
			String[] rha =	(JSPUtil.getParameter(request, prefix +	"rha",	length));
			String[] psc =	(JSPUtil.getParameter(request, prefix +	"psc",	length));
			String[] mpl =	(JSPUtil.getParameter(request, prefix +	"mpl",	length));
			String[] llo =	(JSPUtil.getParameter(request, prefix +	"llo",	length));
			String[] psf =	(JSPUtil.getParameter(request, prefix +	"psf",	length));
			String[] ins =	(JSPUtil.getParameter(request, prefix +	"ins",	length));
			String[] ifi =	(JSPUtil.getParameter(request, prefix +	"ifi",	length));
			String[] haf =	(JSPUtil.getParameter(request, prefix +	"haf",	length));
			String[] hau =	(JSPUtil.getParameter(request, prefix +	"hau",	length));
			String[] aha =	(JSPUtil.getParameter(request, prefix +	"aha",	length));
			String[] gat =	(JSPUtil.getParameter(request, prefix +	"gat",	length));
			String[] fdr =	(JSPUtil.getParameter(request, prefix +	"fdr",	length));
			String[] fed =	(JSPUtil.getParameter(request, prefix +	"fed",	length));
			String[] fmf =	(JSPUtil.getParameter(request, prefix +	"fmf",	length));
			String[] esd =	(JSPUtil.getParameter(request, prefix +	"esd",	length));
			String[] emp =	(JSPUtil.getParameter(request, prefix +	"emp",	length));
			String[] elo =	(JSPUtil.getParameter(request, prefix +	"elo",	length));
			String[] ehd =	(JSPUtil.getParameter(request, prefix +	"ehd",	length));
			String[] edi =	(JSPUtil.getParameter(request, prefix +	"edi",	length));
			String[] emr =	(JSPUtil.getParameter(request, prefix +	"emr",	length));
			String[] drp =	(JSPUtil.getParameter(request, prefix +	"drp",	length));
			String[] xdo =	(JSPUtil.getParameter(request, prefix +	"xdo",	length));
			String[] doc =	(JSPUtil.getParameter(request, prefix +	"doc",	length));
			String[] esi =	(JSPUtil.getParameter(request, prefix +	"esi",	length));
			String[] xdd =	(JSPUtil.getParameter(request, prefix +	"xdd",	length));
			String[] dof =	(JSPUtil.getParameter(request, prefix +	"dof",	length));
			String[] dey =	(JSPUtil.getParameter(request, prefix +	"dey",	length));
			String[] xde =	(JSPUtil.getParameter(request, prefix +	"xde",	length));
			String[] cys =	(JSPUtil.getParameter(request, prefix +	"cys",	length));
			String[] cyr =	(JSPUtil.getParameter(request, prefix +	"cyr",	length));
			String[] csv =	(JSPUtil.getParameter(request, prefix +	"csv",	length));
			String[] cvc =	(JSPUtil.getParameter(request, prefix +	"cvc",	length));
			String[] ctp =	(JSPUtil.getParameter(request, prefix +	"ctp",	length));
			String[] cmc =	(JSPUtil.getParameter(request, prefix +	"cmc",	length));
			String[] ccc =	(JSPUtil.getParameter(request, prefix +	"ccc",	length));
			String[] cfd =	(JSPUtil.getParameter(request, prefix +	"cfd",	length));
			String[] cdc =	(JSPUtil.getParameter(request, prefix +	"cdc",	length));
			String[] xwf =	(JSPUtil.getParameter(request, prefix +	"xwf",	length));
			String[] cdd =	(JSPUtil.getParameter(request, prefix +	"cdd",	length));
			String[] bao =	(JSPUtil.getParameter(request, prefix +	"bao",	length));
			String[] bad =	(JSPUtil.getParameter(request, prefix +	"bad",	length));
			String[] bio =	(JSPUtil.getParameter(request, prefix +	"bio",	length));
			String[] ard =	(JSPUtil.getParameter(request, prefix +	"ard",	length));
			String[] alm =	(JSPUtil.getParameter(request, prefix +	"alm",	length));
			String[] baf =	(JSPUtil.getParameter(request, prefix +	"baf",	length));
			String[] caf =	(JSPUtil.getParameter(request, prefix +	"caf",	length));
			String[] ref =	(JSPUtil.getParameter(request, prefix +	"ref",	length));
			String[] rsd =	(JSPUtil.getParameter(request, prefix +	"rsd",	length));
			String[] thl =	(JSPUtil.getParameter(request, prefix +	"thl",	length));
			String[] thd =	(JSPUtil.getParameter(request, prefix +	"thd",	length));
			String[] xer =	(JSPUtil.getParameter(request, prefix +	"xer",	length));
			String[] neo =	(JSPUtil.getParameter(request, prefix +	"neo",	length));
			String[] neoCur =	(JSPUtil.getParameter(request, prefix +	"neo_cur",	length));
			String[] neoExe =	(JSPUtil.getParameter(request, prefix +	"neo_exe",	length));
			String[] wtr =	(JSPUtil.getParameter(request, prefix +	"wtr",	length));
			String[] wtrCur =	(JSPUtil.getParameter(request, prefix +	"wtr_cur",	length));
			String[] wtrExe =	(JSPUtil.getParameter(request, prefix +	"wtr_exe",	length));
			String[] eca =	(JSPUtil.getParameter(request, prefix +	"eca",	length));
			String[] ecaCur =	(JSPUtil.getParameter(request, prefix +	"eca_cur",	length));
			String[] ecaExe =	(JSPUtil.getParameter(request, prefix +	"eca_exe",	length));
			String[] wrc =	(JSPUtil.getParameter(request, prefix +	"wrc",	length));
			String[] wrcCur =	(JSPUtil.getParameter(request, prefix +	"wrc_cur",	length));
			String[] wrcExe =	(JSPUtil.getParameter(request, prefix +	"wrc_exe",	length));
			String[] tcs =	(JSPUtil.getParameter(request, prefix +	"tcs",	length));
			String[] tcsCur =	(JSPUtil.getParameter(request, prefix +	"tcs_cur",	length));
			String[] tcsExe =	(JSPUtil.getParameter(request, prefix +	"tcs_exe",	length));
			String[] win =	(JSPUtil.getParameter(request, prefix +	"win",	length));
			String[] winCur =	(JSPUtil.getParameter(request, prefix +	"win_cur",	length));
			String[] winExe =	(JSPUtil.getParameter(request, prefix +	"win_exe",	length));
			String[] yas =	(JSPUtil.getParameter(request, prefix +	"yas",	length));
			String[] yasCur =	(JSPUtil.getParameter(request, prefix +	"yas_cur",	length));
			String[] yasExe =	(JSPUtil.getParameter(request, prefix +	"yas_exe",	length));
			String[] spt =	(JSPUtil.getParameter(request, prefix +	"spt",	length));
			String[] sptCur =	(JSPUtil.getParameter(request, prefix +	"spt_cur",	length));
			String[] sptExe =	(JSPUtil.getParameter(request, prefix +	"spt_exe",	length));
			String[] sct =	(JSPUtil.getParameter(request, prefix +	"sct",	length));
			String[] sctCur =	(JSPUtil.getParameter(request, prefix +	"sct_cur",	length));
			String[] sctExe =	(JSPUtil.getParameter(request, prefix +	"sct_exe",	length));
			String[] pss =	(JSPUtil.getParameter(request, prefix +	"pss",	length));
			String[] pssCur =	(JSPUtil.getParameter(request, prefix +	"pss_cur",	length));
			String[] pssExe =	(JSPUtil.getParameter(request, prefix +	"pss_exe",	length));
			String[] pct =	(JSPUtil.getParameter(request, prefix +	"pct",	length));
			String[] pctCur =	(JSPUtil.getParameter(request, prefix +	"pct_cur",	length));
			String[] pctExe =	(JSPUtil.getParameter(request, prefix +	"pct_exe",	length));
			String[] lsf =	(JSPUtil.getParameter(request, prefix +	"lsf",	length));
			String[] lsfCur =	(JSPUtil.getParameter(request, prefix +	"lsf_cur",	length));
			String[] lsfExe =	(JSPUtil.getParameter(request, prefix +	"lsf_exe",	length));
			String[] faf =	(JSPUtil.getParameter(request, prefix +	"faf",	length));
			String[] fafCur =	(JSPUtil.getParameter(request, prefix +	"faf_cur",	length));
			String[] fafExe =	(JSPUtil.getParameter(request, prefix +	"faf_exe",	length));
			String[] ers =	(JSPUtil.getParameter(request, prefix +	"ers",	length));
			String[] ersCur =	(JSPUtil.getParameter(request, prefix +	"ers_cur",	length));
			String[] ersExe =	(JSPUtil.getParameter(request, prefix +	"ers_exe",	length));
			String[] eis =	(JSPUtil.getParameter(request, prefix +	"eis",	length));
			String[] eisCur =	(JSPUtil.getParameter(request, prefix +	"eis_cur",	length));
			String[] eisExe =	(JSPUtil.getParameter(request, prefix +	"eis_exe",	length));
			String[] env =	(JSPUtil.getParameter(request, prefix +	"env",	length));
			String[] envCur =	(JSPUtil.getParameter(request, prefix +	"env_cur",	length));
			String[] envExe =	(JSPUtil.getParameter(request, prefix +	"env_exe",	length));
			String[] ems =	(JSPUtil.getParameter(request, prefix +	"ems",	length));
			String[] emsCur =	(JSPUtil.getParameter(request, prefix +	"ems_cur",	length));
			String[] emsExe =	(JSPUtil.getParameter(request, prefix +	"ems_exe",	length));
			String[] ebs =	(JSPUtil.getParameter(request, prefix +	"ebs",	length));
			String[] ebsCur =	(JSPUtil.getParameter(request, prefix +	"ebs_cur",	length));
			String[] ebsExe =	(JSPUtil.getParameter(request, prefix +	"ebs_exe",	length));
			String[] eba =	(JSPUtil.getParameter(request, prefix +	"eba",	length));
			String[] ebaCur =	(JSPUtil.getParameter(request, prefix +	"eba_cur",	length));
			String[] ebaExe =	(JSPUtil.getParameter(request, prefix +	"eba_exe",	length));
			String[] eri =	(JSPUtil.getParameter(request, prefix +	"eri",	length));
			String[] eriCur =	(JSPUtil.getParameter(request, prefix +	"eri_cur",	length));
			String[] eriExe =	(JSPUtil.getParameter(request, prefix +	"eri_exe",	length));
			String[] dcf =	(JSPUtil.getParameter(request, prefix +	"dcf",	length));
			String[] dcfCur =	(JSPUtil.getParameter(request, prefix +	"dcf_cur",	length));
			String[] dcfExe =	(JSPUtil.getParameter(request, prefix +	"dcf_exe",	length));
			String[] cbr =	(JSPUtil.getParameter(request, prefix +	"cbr",	length));
			String[] cbrCur =	(JSPUtil.getParameter(request, prefix +	"cbr_cur",	length));
			String[] cbrExe =	(JSPUtil.getParameter(request, prefix +	"cbr_exe",	length));
			String[] cgl =	(JSPUtil.getParameter(request, prefix +	"cgl",	length));
			String[] cglCur =	(JSPUtil.getParameter(request, prefix +	"cgl_cur",	length));
			String[] cglExe =	(JSPUtil.getParameter(request, prefix +	"cgl_exe",	length));
			String[] cgd =	(JSPUtil.getParameter(request, prefix +	"cgd",	length));
			String[] cgdCur =	(JSPUtil.getParameter(request, prefix +	"cgd_cur",	length));
			String[] cgdExe =	(JSPUtil.getParameter(request, prefix +	"cgd_exe",	length));
			String[] con =	(JSPUtil.getParameter(request, prefix +	"con",	length));
			String[] conCur =	(JSPUtil.getParameter(request, prefix +	"con_cur",	length));
			String[] conExe =	(JSPUtil.getParameter(request, prefix +	"con_exe",	length));
			String[] css =	(JSPUtil.getParameter(request, prefix +	"css",	length));
			String[] cssCur =	(JSPUtil.getParameter(request, prefix +	"css_cur",	length));
			String[] cssExe =	(JSPUtil.getParameter(request, prefix +	"css_exe",	length));
			String[] bct =	(JSPUtil.getParameter(request, prefix +	"bct",	length));
			String[] bctCur =	(JSPUtil.getParameter(request, prefix +	"bct_cur",	length));
			String[] bctExe =	(JSPUtil.getParameter(request, prefix +	"bct_exe",	length));
			String[] afa =	(JSPUtil.getParameter(request, prefix +	"afa",	length));
			String[] afaCur =	(JSPUtil.getParameter(request, prefix +	"afa_cur",	length));
			String[] afaExe =	(JSPUtil.getParameter(request, prefix +	"afa_exe",	length));
			String[] ags =	(JSPUtil.getParameter(request, prefix +	"ags",	length));
			String[] agsCur =	(JSPUtil.getParameter(request, prefix +	"ags_cur",	length));
			String[] agsExe =	(JSPUtil.getParameter(request, prefix +	"ags_exe",	length));
			String[] ses =	(JSPUtil.getParameter(request, prefix +	"ses",	length));
			String[] sesCur =	(JSPUtil.getParameter(request, prefix +	"ses_cur",	length));
			String[] sesExe =	(JSPUtil.getParameter(request, prefix +	"ses_exe",	length));
			String[] gh2 =	(JSPUtil.getParameter(request, prefix +	"gh2",	length));
			String[] gh2Cur =	(JSPUtil.getParameter(request, prefix +	"gh2_cur",	length));
			String[] gh2Exe =	(JSPUtil.getParameter(request, prefix +	"gh2_exe",	length));
			String[] aps =	(JSPUtil.getParameter(request, prefix +	"aps",	length));
			String[] apsCur =	(JSPUtil.getParameter(request, prefix +	"aps_cur",	length));
			String[] apsExe =	(JSPUtil.getParameter(request, prefix +	"aps_exe",	length));
			String[] goh =	(JSPUtil.getParameter(request, prefix +	"goh",	length));
			String[] gohCur =	(JSPUtil.getParameter(request, prefix +	"goh_cur",	length));
			String[] gohExe =	(JSPUtil.getParameter(request, prefix +	"goh_exe",	length));
			String[] hea =	(JSPUtil.getParameter(request, prefix +	"hea",	length));
			String[] heaCur =	(JSPUtil.getParameter(request, prefix +	"hea_cur",	length));
			String[] heaExe =	(JSPUtil.getParameter(request, prefix +	"hea_exe",	length));
			String[] haz =	(JSPUtil.getParameter(request, prefix +	"haz",	length));
			String[] hazCur =	(JSPUtil.getParameter(request, prefix +	"haz_cur",	length));
			String[] hazExe =	(JSPUtil.getParameter(request, prefix +	"haz_exe",	length));
			String[] dgs =	(JSPUtil.getParameter(request, prefix +	"dgs",	length));
			String[] dgsCur =	(JSPUtil.getParameter(request, prefix +	"dgs_cur",	length));
			String[] dgsExe =	(JSPUtil.getParameter(request, prefix +	"dgs_exe",	length));
			String[] effDt =	(JSPUtil.getParameter(request, prefix +	"eff_dt",	length));
			String[] expDt =	(JSPUtil.getParameter(request, prefix +	"exp_dt",	length));
			String[] remark =	(JSPUtil.getParameter(request, prefix +	"remark",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	MotFilingExclVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( nid[i] !=	null)
					model.setNid( nid[i]);
				if ( batExeDt[i] !=	null)
					model.setBatExeDt( batExeDt[i]);
				if ( shprCntCd[i] !=	null)
					model.setShprCntCd( shprCntCd[i]);
				if ( shprSeq[i] !=	null)
					model.setShprSeq( shprSeq[i]);
				if ( seq[i] !=	null)
					model.setSeq( seq[i]);
				if ( carrier[i] !=	null)
					model.setCarrier( carrier[i]);
				if ( ctrtNo[i] !=	null)
					model.setCtrtNo( ctrtNo[i]);
				if ( ctrtHldNm[i] !=	null)
					model.setCtrtHldNm( ctrtHldNm[i]);
				if ( bkgShprNm[i] !=	null)
					model.setBkgShprNm( bkgShprNm[i]);
				if ( bkgCneeNm[i] !=	null)
					model.setBkgCneeNm( bkgCneeNm[i]);
				if ( foreTraComp[i] !=	null)
					model.setForeTraComp( foreTraComp[i]);
				if ( operAgt[i] !=	null)
					model.setOperAgt( operAgt[i]);
				if ( lane[i] !=	null)
					model.setLane( lane[i]);
				if ( wayPort[i] !=	null)
					model.setWayPort( wayPort[i]);
				if ( polCd[i] !=	null)
					model.setPolCd( polCd[i]);
				if ( deptTsitPort[i] !=	null)
					model.setDeptTsitPort( deptTsitPort[i]);
				if ( destTsitPort[i] !=	null)
					model.setDestTsitPort( destTsitPort[i]);
				if ( podCd[i] !=	null)
					model.setPodCd( podCd[i]);
				if ( transTerm[i] !=	null)
					model.setTransTerm( transTerm[i]);
				if ( cntrTp[i] !=	null)
					model.setCntrTp( cntrTp[i]);
				if ( cmdtTp[i] !=	null)
					model.setCmdtTp( cmdtTp[i]);
				if ( cntrSz[i] !=	null)
					model.setCntrSz( cntrSz[i]);
				if ( cntrVol1[i] !=	null)
					model.setCntrVol1( cntrVol1[i]);
				if ( cntrVol2[i] !=	null)
					model.setCntrVol2( cntrVol2[i]);
				if ( oftRt[i] !=	null)
					model.setOftRt( oftRt[i]);
				if ( com[i] !=	null)
					model.setCom( com[i]);
				if ( cov[i] !=	null)
					model.setCov( cov[i]);
				if ( covCur[i] !=	null)
					model.setCovCur( covCur[i]);
				if ( covExe[i] !=	null)
					model.setCovExe( covExe[i]);
				if ( cod[i] !=	null)
					model.setCod( cod[i]);
				if ( codCur[i] !=	null)
					model.setCodCur( codCur[i]);
				if ( codExe[i] !=	null)
					model.setCodExe( codExe[i]);
				if ( ocr[i] !=	null)
					model.setOcr( ocr[i]);
				if ( crs[i] !=	null)
					model.setCrs( crs[i]);
				if ( xei[i] !=	null)
					model.setXei( xei[i]);
				if ( kcs[i] !=	null)
					model.setKcs( kcs[i]);
				if ( ams[i] !=	null)
					model.setAms( ams[i]);
				if ( dpc[i] !=	null)
					model.setDpc( dpc[i]);
				if ( prs[i] !=	null)
					model.setPrs( prs[i]);
				if ( enq[i] !=	null)
					model.setEnq( enq[i]);
				if ( chc[i] !=	null)
					model.setChc( chc[i]);
				if ( ama[i] !=	null)
					model.setAma( ama[i]);
				if ( adh[i] !=	null)
					model.setAdh( adh[i]);
				if ( gen[i] !=	null)
					model.setGen( gen[i]);
				if ( dem[i] !=	null)
					model.setDem( dem[i]);
				if ( det[i] !=	null)
					model.setDet( det[i]);
				if ( xsw[i] !=	null)
					model.setXsw( xsw[i]);
				if ( xbs[i] !=	null)
					model.setXbs( xbs[i]);
				if ( xbr[i] !=	null)
					model.setXbr( xbr[i]);
				if ( xba[i] !=	null)
					model.setXba( xba[i]);
				if ( bkf[i] !=	null)
					model.setBkf( bkf[i]);
				if ( wha[i] !=	null)
					model.setWha( wha[i]);
				if ( tsl[i] !=	null)
					model.setTsl( tsl[i]);
				if ( tsd[i] !=	null)
					model.setTsd( tsd[i]);
				if ( slf[i] !=	null)
					model.setSlf( slf[i]);
				if ( rpc[i] !=	null)
					model.setRpc( rpc[i]);
				if ( rls[i] !=	null)
					model.setRls( rls[i]);
				if ( rha[i] !=	null)
					model.setRha( rha[i]);
				if ( psc[i] !=	null)
					model.setPsc( psc[i]);
				if ( mpl[i] !=	null)
					model.setMpl( mpl[i]);
				if ( llo[i] !=	null)
					model.setLlo( llo[i]);
				if ( psf[i] !=	null)
					model.setPsf( psf[i]);
				if ( ins[i] !=	null)
					model.setIns( ins[i]);
				if ( ifi[i] !=	null)
					model.setIfi( ifi[i]);
				if ( haf[i] !=	null)
					model.setHaf( haf[i]);
				if ( hau[i] !=	null)
					model.setHau( hau[i]);
				if ( aha[i] !=	null)
					model.setAha( aha[i]);
				if ( gat[i] !=	null)
					model.setGat( gat[i]);
				if ( fdr[i] !=	null)
					model.setFdr( fdr[i]);
				if ( fed[i] !=	null)
					model.setFed( fed[i]);
				if ( fmf[i] !=	null)
					model.setFmf( fmf[i]);
				if ( esd[i] !=	null)
					model.setEsd( esd[i]);
				if ( emp[i] !=	null)
					model.setEmp( emp[i]);
				if ( elo[i] !=	null)
					model.setElo( elo[i]);
				if ( ehd[i] !=	null)
					model.setEhd( ehd[i]);
				if ( edi[i] !=	null)
					model.setEdi( edi[i]);
				if ( emr[i] !=	null)
					model.setEmr( emr[i]);
				if ( drp[i] !=	null)
					model.setDrp( drp[i]);
				if ( xdo[i] !=	null)
					model.setXdo( xdo[i]);
				if ( doc[i] !=	null)
					model.setDoc( doc[i]);
				if ( esi[i] !=	null)
					model.setEsi( esi[i]);
				if ( xdd[i] !=	null)
					model.setXdd( xdd[i]);
				if ( dof[i] !=	null)
					model.setDof( dof[i]);
				if ( dey[i] !=	null)
					model.setDey( dey[i]);
				if ( xde[i] !=	null)
					model.setXde( xde[i]);
				if ( cys[i] !=	null)
					model.setCys( cys[i]);
				if ( cyr[i] !=	null)
					model.setCyr( cyr[i]);
				if ( csv[i] !=	null)
					model.setCsv( csv[i]);
				if ( cvc[i] !=	null)
					model.setCvc( cvc[i]);
				if ( ctp[i] !=	null)
					model.setCtp( ctp[i]);
				if ( cmc[i] !=	null)
					model.setCmc( cmc[i]);
				if ( ccc[i] !=	null)
					model.setCcc( ccc[i]);
				if ( cfd[i] !=	null)
					model.setCfd( cfd[i]);
				if ( cdc[i] !=	null)
					model.setCdc( cdc[i]);
				if ( xwf[i] !=	null)
					model.setXwf( xwf[i]);
				if ( cdd[i] !=	null)
					model.setCdd( cdd[i]);
				if ( bao[i] !=	null)
					model.setBao( bao[i]);
				if ( bad[i] !=	null)
					model.setBad( bad[i]);
				if ( bio[i] !=	null)
					model.setBio( bio[i]);
				if ( ard[i] !=	null)
					model.setArd( ard[i]);
				if ( alm[i] !=	null)
					model.setAlm( alm[i]);
				if ( baf[i] !=	null)
					model.setBaf( baf[i]);
				if ( caf[i] !=	null)
					model.setCaf( caf[i]);
				if ( ref[i] !=	null)
					model.setRef( ref[i]);
				if ( rsd[i] !=	null)
					model.setRsd( rsd[i]);
				if ( thl[i] !=	null)
					model.setThl( thl[i]);
				if ( thd[i] !=	null)
					model.setThd( thd[i]);
				if ( xer[i] !=	null)
					model.setXer( xer[i]);
				if ( neo[i] !=	null)
					model.setNeo( neo[i]);
				if ( neoCur[i] !=	null)
					model.setNeoCur( neoCur[i]);
				if ( neoExe[i] !=	null)
					model.setNeoExe( neoExe[i]);
				if ( wtr[i] !=	null)
					model.setWtr( wtr[i]);
				if ( wtrCur[i] !=	null)
					model.setWtrCur( wtrCur[i]);
				if ( wtrExe[i] !=	null)
					model.setWtrExe( wtrExe[i]);
				if ( eca[i] !=	null)
					model.setEca( eca[i]);
				if ( ecaCur[i] !=	null)
					model.setEcaCur( ecaCur[i]);
				if ( ecaExe[i] !=	null)
					model.setEcaExe( ecaExe[i]);
				if ( wrc[i] !=	null)
					model.setWrc( wrc[i]);
				if ( wrcCur[i] !=	null)
					model.setWrcCur( wrcCur[i]);
				if ( wrcExe[i] !=	null)
					model.setWrcExe( wrcExe[i]);
				if ( tcs[i] !=	null)
					model.setTcs( tcs[i]);
				if ( tcsCur[i] !=	null)
					model.setTcsCur( tcsCur[i]);
				if ( tcsExe[i] !=	null)
					model.setTcsExe( tcsExe[i]);
				if ( win[i] !=	null)
					model.setWin( win[i]);
				if ( winCur[i] !=	null)
					model.setWinCur( winCur[i]);
				if ( winExe[i] !=	null)
					model.setWinExe( winExe[i]);
				if ( yas[i] !=	null)
					model.setYas( yas[i]);
				if ( yasCur[i] !=	null)
					model.setYasCur( yasCur[i]);
				if ( yasExe[i] !=	null)
					model.setYasExe( yasExe[i]);
				if ( spt[i] !=	null)
					model.setSpt( spt[i]);
				if ( sptCur[i] !=	null)
					model.setSptCur( sptCur[i]);
				if ( sptExe[i] !=	null)
					model.setSptExe( sptExe[i]);
				if ( sct[i] !=	null)
					model.setSct( sct[i]);
				if ( sctCur[i] !=	null)
					model.setSctCur( sctCur[i]);
				if ( sctExe[i] !=	null)
					model.setSctExe( sctExe[i]);
				if ( pss[i] !=	null)
					model.setPss( pss[i]);
				if ( pssCur[i] !=	null)
					model.setPssCur( pssCur[i]);
				if ( pssExe[i] !=	null)
					model.setPssExe( pssExe[i]);
				if ( pct[i] !=	null)
					model.setPct( pct[i]);
				if ( pctCur[i] !=	null)
					model.setPctCur( pctCur[i]);
				if ( pctExe[i] !=	null)
					model.setPctExe( pctExe[i]);
				if ( lsf[i] !=	null)
					model.setLsf( lsf[i]);
				if ( lsfCur[i] !=	null)
					model.setLsfCur( lsfCur[i]);
				if ( lsfExe[i] !=	null)
					model.setLsfExe( lsfExe[i]);
				if ( faf[i] !=	null)
					model.setFaf( faf[i]);
				if ( fafCur[i] !=	null)
					model.setFafCur( fafCur[i]);
				if ( fafExe[i] !=	null)
					model.setFafExe( fafExe[i]);
				if ( ers[i] !=	null)
					model.setErs( ers[i]);
				if ( ersCur[i] !=	null)
					model.setErsCur( ersCur[i]);
				if ( ersExe[i] !=	null)
					model.setErsExe( ersExe[i]);
				if ( eis[i] !=	null)
					model.setEis( eis[i]);
				if ( eisCur[i] !=	null)
					model.setEisCur( eisCur[i]);
				if ( eisExe[i] !=	null)
					model.setEisExe( eisExe[i]);
				if ( env[i] !=	null)
					model.setEnv( env[i]);
				if ( envCur[i] !=	null)
					model.setEnvCur( envCur[i]);
				if ( envExe[i] !=	null)
					model.setEnvExe( envExe[i]);
				if ( ems[i] !=	null)
					model.setEms( ems[i]);
				if ( emsCur[i] !=	null)
					model.setEmsCur( emsCur[i]);
				if ( emsExe[i] !=	null)
					model.setEmsExe( emsExe[i]);
				if ( ebs[i] !=	null)
					model.setEbs( ebs[i]);
				if ( ebsCur[i] !=	null)
					model.setEbsCur( ebsCur[i]);
				if ( ebsExe[i] !=	null)
					model.setEbsExe( ebsExe[i]);
				if ( eba[i] !=	null)
					model.setEba( eba[i]);
				if ( ebaCur[i] !=	null)
					model.setEbaCur( ebaCur[i]);
				if ( ebaExe[i] !=	null)
					model.setEbaExe( ebaExe[i]);
				if ( eri[i] !=	null)
					model.setEri( eri[i]);
				if ( eriCur[i] !=	null)
					model.setEriCur( eriCur[i]);
				if ( eriExe[i] !=	null)
					model.setEriExe( eriExe[i]);
				if ( dcf[i] !=	null)
					model.setDcf( dcf[i]);
				if ( dcfCur[i] !=	null)
					model.setDcfCur( dcfCur[i]);
				if ( dcfExe[i] !=	null)
					model.setDcfExe( dcfExe[i]);
				if ( cbr[i] !=	null)
					model.setCbr( cbr[i]);
				if ( cbrCur[i] !=	null)
					model.setCbrCur( cbrCur[i]);
				if ( cbrExe[i] !=	null)
					model.setCbrExe( cbrExe[i]);
				if ( cgl[i] !=	null)
					model.setCgl( cgl[i]);
				if ( cglCur[i] !=	null)
					model.setCglCur( cglCur[i]);
				if ( cglExe[i] !=	null)
					model.setCglExe( cglExe[i]);
				if ( cgd[i] !=	null)
					model.setCgd( cgd[i]);
				if ( cgdCur[i] !=	null)
					model.setCgdCur( cgdCur[i]);
				if ( cgdExe[i] !=	null)
					model.setCgdExe( cgdExe[i]);
				if ( con[i] !=	null)
					model.setCon( con[i]);
				if ( conCur[i] !=	null)
					model.setConCur( conCur[i]);
				if ( conExe[i] !=	null)
					model.setConExe( conExe[i]);
				if ( css[i] !=	null)
					model.setCss( css[i]);
				if ( cssCur[i] !=	null)
					model.setCssCur( cssCur[i]);
				if ( cssExe[i] !=	null)
					model.setCssExe( cssExe[i]);
				if ( bct[i] !=	null)
					model.setBct( bct[i]);
				if ( bctCur[i] !=	null)
					model.setBctCur( bctCur[i]);
				if ( bctExe[i] !=	null)
					model.setBctExe( bctExe[i]);
				if ( afa[i] !=	null)
					model.setAfa( afa[i]);
				if ( afaCur[i] !=	null)
					model.setAfaCur( afaCur[i]);
				if ( afaExe[i] !=	null)
					model.setAfaExe( afaExe[i]);
				if ( ags[i] !=	null)
					model.setAgs( ags[i]);
				if ( agsCur[i] !=	null)
					model.setAgsCur( agsCur[i]);
				if ( agsExe[i] !=	null)
					model.setAgsExe( agsExe[i]);
				if ( ses[i] !=	null)
					model.setSes( ses[i]);
				if ( sesCur[i] !=	null)
					model.setSesCur( sesCur[i]);
				if ( sesExe[i] !=	null)
					model.setSesExe( sesExe[i]);
				if ( gh2[i] !=	null)
					model.setGh2( gh2[i]);
				if ( gh2Cur[i] !=	null)
					model.setGh2Cur( gh2Cur[i]);
				if ( gh2Exe[i] !=	null)
					model.setGh2Exe( gh2Exe[i]);
				if ( aps[i] !=	null)
					model.setAps( aps[i]);
				if ( apsCur[i] !=	null)
					model.setApsCur( apsCur[i]);
				if ( apsExe[i] !=	null)
					model.setApsExe( apsExe[i]);
				if ( goh[i] !=	null)
					model.setGoh( goh[i]);
				if ( gohCur[i] !=	null)
					model.setGohCur( gohCur[i]);
				if ( gohExe[i] !=	null)
					model.setGohExe( gohExe[i]);
				if ( hea[i] !=	null)
					model.setHea( hea[i]);
				if ( heaCur[i] !=	null)
					model.setHeaCur( heaCur[i]);
				if ( heaExe[i] !=	null)
					model.setHeaExe( heaExe[i]);
				if ( haz[i] !=	null)
					model.setHaz( haz[i]);
				if ( hazCur[i] !=	null)
					model.setHazCur( hazCur[i]);
				if ( hazExe[i] !=	null)
					model.setHazExe( hazExe[i]);
				if ( dgs[i] !=	null)
					model.setDgs( dgs[i]);
				if ( dgsCur[i] !=	null)
					model.setDgsCur( dgsCur[i]);
				if ( dgsExe[i] !=	null)
					model.setDgsExe( dgsExe[i]);
				if ( effDt[i] !=	null)
					model.setEffDt( effDt[i]);
				if ( expDt[i] !=	null)
					model.setExpDt( expDt[i]);
				if ( remark[i] !=	null)
					model.setRemark( remark[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getMotFilingExclVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return MotFilingExclVO[]
	 */
	public MotFilingExclVO[]	 getMotFilingExclVOs(){
		MotFilingExclVO[] vos = (MotFilingExclVO[])models.toArray(new	MotFilingExclVO[models.size()]);
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
	public void	unDataFormat(){
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nid =	this.nid.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batExeDt =	this.batExeDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd =	this.shprCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprSeq =	this.shprSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq =	this.seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carrier =	this.carrier.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo =	this.ctrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtHldNm =	this.ctrtHldNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgShprNm =	this.bkgShprNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCneeNm =	this.bkgCneeNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foreTraComp =	this.foreTraComp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.operAgt =	this.operAgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane =	this.lane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wayPort =	this.wayPort.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deptTsitPort =	this.deptTsitPort.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTsitPort =	this.destTsitPort.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transTerm =	this.transTerm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTp =	this.cntrTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtTp =	this.cmdtTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSz =	this.cntrSz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVol1 =	this.cntrVol1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVol2 =	this.cntrVol2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftRt =	this.oftRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.com =	this.com.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cov =	this.cov.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.covCur =	this.covCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.covExe =	this.covExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cod =	this.cod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codCur =	this.codCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codExe =	this.codExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocr =	this.ocr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crs =	this.crs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xei =	this.xei.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcs =	this.kcs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ams =	this.ams.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpc =	this.dpc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prs =	this.prs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.enq =	this.enq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chc =	this.chc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ama =	this.ama.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adh =	this.adh.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gen =	this.gen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dem =	this.dem.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.det =	this.det.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xsw =	this.xsw.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xbs =	this.xbs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xbr =	this.xbr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xba =	this.xba.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkf =	this.bkf.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wha =	this.wha.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsl =	this.tsl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsd =	this.tsd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slf =	this.slf.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rpc =	this.rpc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rls =	this.rls.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rha =	this.rha.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psc =	this.psc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mpl =	this.mpl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.llo =	this.llo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psf =	this.psf.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ins =	this.ins.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifi =	this.ifi.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.haf =	this.haf.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hau =	this.hau.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aha =	this.aha.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gat =	this.gat.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdr =	this.fdr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fed =	this.fed.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmf =	this.fmf.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esd =	this.esd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emp =	this.emp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elo =	this.elo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ehd =	this.ehd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edi =	this.edi.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emr =	this.emr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drp =	this.drp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xdo =	this.xdo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doc =	this.doc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esi =	this.esi.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xdd =	this.xdd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dof =	this.dof.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dey =	this.dey.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xde =	this.xde.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cys =	this.cys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cyr =	this.cyr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csv =	this.csv.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvc =	this.cvc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctp =	this.ctp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmc =	this.cmc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ccc =	this.ccc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfd =	this.cfd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdc =	this.cdc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xwf =	this.xwf.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdd =	this.cdd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bao =	this.bao.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bad =	this.bad.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bio =	this.bio.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ard =	this.ard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alm =	this.alm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.baf =	this.baf.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caf =	this.caf.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ref =	this.ref.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsd =	this.rsd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thl =	this.thl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thd =	this.thd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xer =	this.xer.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.neo =	this.neo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.neoCur =	this.neoCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.neoExe =	this.neoExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtr =	this.wtr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrCur =	this.wtrCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrExe =	this.wtrExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eca =	this.eca.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ecaCur =	this.ecaCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ecaExe =	this.ecaExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrc =	this.wrc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrcCur =	this.wrcCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrcExe =	this.wrcExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tcs =	this.tcs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tcsCur =	this.tcsCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tcsExe =	this.tcsExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.win =	this.win.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.winCur =	this.winCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.winExe =	this.winExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yas =	this.yas.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yasCur =	this.yasCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yasExe =	this.yasExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spt =	this.spt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sptCur =	this.sptCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sptExe =	this.sptExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sct =	this.sct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sctCur =	this.sctCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sctExe =	this.sctExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pss =	this.pss.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pssCur =	this.pssCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pssExe =	this.pssExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pct =	this.pct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctCur =	this.pctCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctExe =	this.pctExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsf =	this.lsf.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsfCur =	this.lsfCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsfExe =	this.lsfExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faf =	this.faf.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fafCur =	this.fafCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fafExe =	this.fafExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ers =	this.ers.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ersCur =	this.ersCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ersExe =	this.ersExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eis =	this.eis.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eisCur =	this.eisCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eisExe =	this.eisExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.env =	this.env.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.envCur =	this.envCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.envExe =	this.envExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ems =	this.ems.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsCur =	this.emsCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsExe =	this.emsExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ebs =	this.ebs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ebsCur =	this.ebsCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ebsExe =	this.ebsExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eba =	this.eba.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ebaCur =	this.ebaCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ebaExe =	this.ebaExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eri =	this.eri.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eriCur =	this.eriCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eriExe =	this.eriExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcf =	this.dcf.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcfCur =	this.dcfCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcfExe =	this.dcfExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbr =	this.cbr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbrCur =	this.cbrCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbrExe =	this.cbrExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgl =	this.cgl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cglCur =	this.cglCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cglExe =	this.cglExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgd =	this.cgd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgdCur =	this.cgdCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgdExe =	this.cgdExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.con =	this.con.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.conCur =	this.conCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.conExe =	this.conExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.css =	this.css.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cssCur =	this.cssCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cssExe =	this.cssExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bct =	this.bct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bctCur =	this.bctCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bctExe =	this.bctExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.afa =	this.afa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.afaCur =	this.afaCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.afaExe =	this.afaExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ags =	this.ags.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agsCur =	this.agsCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agsExe =	this.agsExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ses =	this.ses.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sesCur =	this.sesCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sesExe =	this.sesExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gh2 =	this.gh2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gh2Cur =	this.gh2Cur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gh2Exe =	this.gh2Exe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aps =	this.aps.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apsCur =	this.apsCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apsExe =	this.apsExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.goh =	this.goh.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gohCur =	this.gohCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gohExe =	this.gohExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hea =	this.hea.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.heaCur =	this.heaCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.heaExe =	this.heaExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.haz =	this.haz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hazCur =	this.hazCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hazExe =	this.hazExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgs =	this.dgs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgsCur =	this.dgsCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgsExe =	this.dgsExe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt =	this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt =	this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark =	this.remark.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}