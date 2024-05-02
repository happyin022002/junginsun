/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PrdCreateParamVO.java
 *@FileTitle : PrdCreateParamVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.22
 *@LastModifier : 
 *@LastVersion : 1.0
 * history
=========================================================*/

package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

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

public class PrdCreateParamVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(this.getClass().getName());
	private Collection<PrdCreateParamVO> models = new ArrayList<PrdCreateParamVO>();

	/* Column Info */
	private String com = null;
	/* Column Info */
	private String ldDt = null;
	/* Column Info */
	private String fCmd = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String rcvT = null;
	/* Column Info */
	private String polN = null;
	/* Column Info */
	private String pmF = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tVvd = null;
	/* Column Info */
	private String wgt = null;
	/* Column Info */
	private String rfaOfc = null;
	/* Column Info */
	private String pod1N = null;
	/* Column Info */
	private String porN = null;
	/* Column Info */
	private String podN = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String pol4N = null;
	/* Column Info */
	private String orgSalOfc = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String wgtUn = null;
	/* Column Info */
	private String pol4 = null;
	/* Column Info */
	private String bbF = null;
	/* Column Info */
	private String sc = null;
	/* Column Info */
	private String pol3 = null;
	/* Column Info */
	private String scOfc = null;
	/* Column Info */
	private String pol2 = null;
	/* Column Info */
	private String hgF = null;
	/* Column Info */
	private String pol1 = null;
	/* Column Info */
	private String repCom = null;
	/* Column Info */
	private String vvd2 = null;
	/* Column Info */
	private String drDt = null;
	/* Column Info */
	private String cngn = null;
	/* Column Info */
	private String vvd3 = null;
	/* Column Info */
	private String akF = null;
	/* Column Info */
	private String socF = null;
	/* Column Info */
	private String vvd1 = null;
	/* Column Info */
	private String pod2 = null;
	/* Column Info */
	private String pol3N = null;
	/* Column Info */
	private String pod1 = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String pod4 = null;
	/* Column Info */
	private String pod3 = null;
	/* Column Info */
	private String vvd4 = null;
	/* Column Info */
	private String pod2N = null;
	/* Column Info */
	private String mPu = null;
	/* Column Info */
	private String rdF = null;
	/* Column Info */
	private String delN = null;
	/* Column Info */
	private String pod4N = null;
	/* Column Info */
	private String rfa = null;
	/* Column Info */
	private String imdg = null;
	/* Column Info */
	private String delT = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String copyCnt = null;
	/* Column Info */
	private String bkgOfc = null;
	/* Column Info */
	private String fRt = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String pod3N = null;
	/* Column Info */
	private String pol2N = null;
	/* Column Info */
	private String pcMode = null;
	/* Column Info */
	private String comBkgNo = null;
	/* Column Info */
	private String subF = null;
	/* Column Info */
	private String lane4 = null;
	/* Column Info */
	private String hitchment = null;
	/* Column Info */
	private String lane2 = null;
	/* Column Info */
	private String lane3 = null;
	/* Column Info */
	private String lane1 = null;
	/* Column Info */
	private String dgF = null;
	/* Column Info */
	private String rfF = null;
	/* Column Info */
	private String noCost = null;
	/* Column Info */
	private String cgoTp = null;
	/* Column Info */
	private String shpr = null;
	/* Column Info */
	private String pol1N = null;

	private String obTrspMode = null;

	private String obPrioSeq = null;

	private String ibTrspMode = null;

	private String ibPrioSeq = null;

	private String bkgPctlNo = null;

	// replane 시에만 들어옴.
	private String dgClssCd = null;

	private String areaContiCd = null;
	private String copMapgSeq = null;

	private String mtPkupDt = null;

	// bkg main에서 t-vvd에 pseudo vvd가 들어오면 여기에 복사하고 t-vvd를 리셋해준다.
	// 그래서 pc생성을 ldd 로 할수 있게 해주고 pc가 모두 생성된후 vvd를 pseudo vvd로 다시 업데이트 해준다.
	private String pseudoVvd = "";

	// Mixed, Free i/o 일때는 term 이 변경되므로 bkg에서 보내준 원본 데이터를 가지고 있는다.
	private String bkgRcvT = "";
	private String bkgDelT = "";

	// 20100212 double calling 관련 추가 ,
	private String n1stPolDcSeq = "";
	private String n1stPodDcSeq = "";
	private String n2ndPolDcSeq = "";
	private String n2ndPodDcSeq = "";
	private String n3rdPolDcSeq = "";
	private String n3rdPodDcSeq = "";
	private String n4thPolDcSeq = "";
	private String n4thPodDcSeq = "";

	// 20100426 CA Issue 관련 추가
	private String ocnSeq = "";

	// prd mst 에 넣기 위해 나누어둠 , 만들어지는 데이터
	// shpr = shprCntCd + shprSeq
	private String shprCntCd = null;
	private String shprSeq = null;

	// cngn =CNEE_CNT_CD+ CNEE_SEQ
	private String cneeCntCd = null;
	private String cneeSeq = null;

	private String internalSkdType = null;

	private String mapSeq = null;

	private String mainPatternPctlNo = null;

	private String troSeq = null;

	private String troSubSeq = null;

	private String cTpsz = null;

	private String cQty = null;

	private String troPkupCy = null;

	private String dorZone = null;

	private String troRtnCy = null;

	private String cntrNo = null;

	private String haulage = null;

	private String trMode = null;

	private String mRt = null;

	private String replaneBndCd = null;

	private String termNode = null;

	private String copNo = null;

	private String polPodSep = null;

	private String sumBkgQty = null;

	// free cm 에 입력될 container type의 앞 1자리만을 모아둠.
	private String sumCTpSz = null;

	// Flex Height 관련 flag 추가
	private String flexHgtFlg = null;

	// D4@4,D5@6 형식을 받는 변수 추가
	private String cntrTpszQtyStr = null;

	private String cnstDelFlg = null;

	private String chkYd = null;

	private String moreCnt = null;

	private String ignoreHitch = null;
	
	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public PrdCreateParamVO() {
	}

	public String getN1stPolDcSeq() {
		return n1stPolDcSeq;
	}

	public void setN1stPolDcSeq(String polDcSeq) {
		n1stPolDcSeq = polDcSeq;
	}

	public String getN1stPodDcSeq() {
		return n1stPodDcSeq;
	}

	public void setN1stPodDcSeq(String podDcSeq) {
		n1stPodDcSeq = podDcSeq;
	}

	public String getN2ndPolDcSeq() {
		return n2ndPolDcSeq;
	}

	public void setN2ndPolDcSeq(String polDcSeq) {
		n2ndPolDcSeq = polDcSeq;
	}

	public String getN2ndPodDcSeq() {
		return n2ndPodDcSeq;
	}

	public void setN2ndPodDcSeq(String podDcSeq) {
		n2ndPodDcSeq = podDcSeq;
	}

	public String getN3rdPolDcSeq() {
		return n3rdPolDcSeq;
	}

	public void setN3rdPolDcSeq(String polDcSeq) {
		n3rdPolDcSeq = polDcSeq;
	}

	public String getN3rdPodDcSeq() {
		return n3rdPodDcSeq;
	}

	public void setN3rdPodDcSeq(String podDcSeq) {
		n3rdPodDcSeq = podDcSeq;
	}

	public String getN4thPolDcSeq() {
		return n4thPolDcSeq;
	}

	public void setN4thPolDcSeq(String polDcSeq) {
		n4thPolDcSeq = polDcSeq;
	}

	public String getN4thPodDcSeq() {
		return n4thPodDcSeq;
	}

	public void setN4thPodDcSeq(String podDcSeq) {
		n4thPodDcSeq = podDcSeq;
	}

	public String getOcnSeq() {
		return ocnSeq;
	}

	public void setOcnSeq(String ocnSeq) {
		this.ocnSeq = ocnSeq;
	}

	public String getBkgRcvT() {
		return bkgRcvT;
	}

	public void setBkgRcvT(String bkgRcvT) {
		this.bkgRcvT = bkgRcvT;
	}

	public String getBkgDelT() {
		return bkgDelT;
	}

	public void setBkgDelT(String bkgDelT) {
		this.bkgDelT = bkgDelT;
	}

	public String getPseudoVvd() {
		return pseudoVvd;
	}

	public void setPseudoVvd(String pseudoVvd) {
		this.pseudoVvd = pseudoVvd;
	}

	public String getMtPkupDt() {
		return mtPkupDt;
	}

	public void setMtPkupDt(String mtPkupDt) {
		this.mtPkupDt = mtPkupDt;
	}

	public String getCopMapgSeq() {
		return copMapgSeq;
	}

	public void setCopMapgSeq(String copMapgSeq) {
		this.copMapgSeq = copMapgSeq;
	}

	public String getAreaContiCd() {
		return areaContiCd;
	}

	public void setAreaContiCd(String areaContiCd) {
		this.areaContiCd = areaContiCd;
	}

	public String getDgClssCd() {
		return dgClssCd;
	}

	public void setDgClssCd(String dgClssCd) {
		this.dgClssCd = dgClssCd;
	}

	public String getCneeCntCd() {
		return cneeCntCd;
	}

	public void setCneeCntCd(String cneeCntCd) {
		this.cneeCntCd = cneeCntCd;
	}

	public String getCneeSeq() {
		return cneeSeq;
	}

	public void setCneeSeq(String cneeSeq) {
		this.cneeSeq = cneeSeq;
	}

	public String getShprCntCd() {
		return shprCntCd;
	}

	public void setShprCntCd(String shprCntCd) {
		this.shprCntCd = shprCntCd;
	}

	public String getShprSeq() {
		return shprSeq;
	}

	public void setShprSeq(String shprSeq) {
		this.shprSeq = shprSeq;
	}

	public String getSumBkgQty() {
		return sumBkgQty;
	}

	public void setSumBkgQty(String sumBkgQty) {
		this.sumBkgQty = sumBkgQty;
	}

	public String getSumCTpSz() {
		return sumCTpSz;
	}

	public void setSumCTpSz(String sumCTpSz) {
		this.sumCTpSz = sumCTpSz;
	}

	public String getCopNo() {
		return copNo;
	}

	public String getPolPodSep() {
		return polPodSep;
	}

	public void setPolPodSep(String polPodSep) {
		this.polPodSep = polPodSep;
	}

	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}

	public String getTermNode() {
		return termNode;
	}

	public void setTermNode(String termNode) {
		this.termNode = termNode;
	}

	public String getReplaneBndCd() {
		return replaneBndCd;
	}

	public void setReplaneBndCd(String replaneBndCd) {
		this.replaneBndCd = replaneBndCd;
	}

	public String getMRt() {
		return mRt;
	}

	public void setMRt(String rt) {
		mRt = rt;
	}

	public String getCTpsz() {
		return cTpsz;
	}

	public void setCTpsz(String tpsz) {
		cTpsz = tpsz;
	}

	public String getCQty() {
		return cQty;
	}

	public void setCQty(String qty) {
		cQty = qty;
	}

	public String getTroPkupCy() {
		return troPkupCy;
	}

	public void setTroPkupCy(String troPkupCy) {
		this.troPkupCy = troPkupCy;
	}

	public String getDorZone() {
		return dorZone;
	}

	public void setDorZone(String dorZone) {
		this.dorZone = dorZone;
	}

	public String getTroRtnCy() {
		return troRtnCy;
	}

	public void setTroRtnCy(String troRtnCy) {
		this.troRtnCy = troRtnCy;
	}

	public String getCntrNo() {
		return cntrNo;
	}

	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	public String getHaulage() {
		return haulage;
	}

	public void setHaulage(String haulage) {
		this.haulage = haulage;
	}

	public String getTrMode() {
		return trMode;
	}

	public void setTrMode(String trMode) {
		this.trMode = trMode;
	}

	public String getTroSeq() {
		return troSeq;
	}

	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
	}

	public String getTroSubSeq() {
		return troSubSeq;
	}

	public void setTroSubSeq(String troSubSeq) {
		this.troSubSeq = troSubSeq;
	}

	/**
	 * @return the flexHgtFlg
	 */
	public String getFlexHgtFlg() {
		return flexHgtFlg;
	}

	/**
	 * @param flexHgtFlg the flexHgtFlg to set
	 */
	public void setFlexHgtFlg(String flexHgtFlg) {
		this.flexHgtFlg = flexHgtFlg;
	}

	/**
	 * @return the cntrTpszQtyStr
	 */
	public String getCntrTpszQtyStr() {
		return cntrTpszQtyStr;
	}

	/**
	 * @param cntrTpszQtyStr the cntrTpszQtyStr to set
	 */
	public void setCntrTpszQtyStr(String cntrTpszQtyStr) {
		this.cntrTpszQtyStr = cntrTpszQtyStr;
	}

	public String getCnstDelFlg() {
		return cnstDelFlg;
	}

	public void setCnstDelFlg(String cnstDelFlg) {
		this.cnstDelFlg = cnstDelFlg;
	}

	public String getChkYd() {
		return chkYd;
	}

	public void setChkYd(String chkYd) {
		this.chkYd = chkYd;
	}

	public String getMoreCnt() {
		return moreCnt;
	}

	public void setMoreCnt(String moreCnt) {
		this.moreCnt = moreCnt;
	}

	public String getIgnoreHitch() {
		return ignoreHitch;
	}

	public void setIgnoreHitch(String ignoreHitch) {
		this.ignoreHitch = ignoreHitch;
	}

	public PrdCreateParamVO(String ibflag, String pagerows, String fCmd, String pcMode, String rcvT, String delT, String por, String porN, String pol, String polN, String pod, String podN, String del, String delN, String tVvd, String pod1, String pod1N, String pol1, String pol1N, String vvd1,
			String lane1, String pod2, String pod2N, String pol2, String pol2N, String vvd2, String lane2, String pod3, String pod3N, String pol3, String pol3N, String vvd3, String lane3, String pod4, String pod4N, String pol4, String pol4N, String vvd4, String lane4, String ldDt, String drDt,
			String mPu, String fRt, String cgoTp, String pmF, String dgF, String rfF, String akF, String bbF, String rdF, String socF, String com, String repCom, String bkgOfc, String orgSalOfc, String rfa, String sc, String rfaOfc, String scOfc, String shpr, String cngn, String wgt, String wgtUn,
			String hgF, String subF, String bkgNo, String imdg, String hitchment, String comBkgNo, String copyCnt, String noCost, String obTrspMode, String obPrioSeq, String ibTrspMode, String ibPrioSeq, String bkgPctlNo, String internalSkdType, String mapSeq, String mainPatternPctlNo,
			String troSeq, String troSubSeq, String cTpsz, String cQty, String troPkupCy, String dorZone, String troRtnCy, String cntrNo, String haulage, String trMode, String mRt, String replaneBndCd, String termNode, String copNo, String polPodSep, String sumBkgQty, String dgClssCd,
			String sumCTpSz, String areaContiCd, String mtPkupDt, String bkgRcvT, String bkgDelT, String n1stPolDcSeq, String n1stPodDcSeq, String n2ndPolDcSeq, String n2ndPodDcSeq, String n3rdPolDcSeq, String n3rdPodDcSeq, String n4thPolDcSeq, String n4thPodDcSeq, String copMapgSeq,
			String pseudoVvd, String shprCntCd, String shprSeq, String cneeCntCd, String cneeSeq, String ocnSeq, String flexHgtFlg, String cntrTpszQtyStr, String cnstDelFlg, String chkYd, String moreCnt, String ignoreHitch) {
		this.com = com;
		this.ldDt = ldDt;
		this.fCmd = fCmd;
		this.por = por;
		this.rcvT = rcvT;
		this.polN = polN;
		this.pmF = pmF;
		this.pagerows = pagerows;
		this.tVvd = tVvd;
		this.wgt = wgt;
		this.rfaOfc = rfaOfc;
		this.pod1N = pod1N;
		this.porN = porN;
		this.podN = podN;
		this.pol = pol;
		this.pol4N = pol4N;
		this.orgSalOfc = orgSalOfc;
		this.pod = pod;
		this.wgtUn = wgtUn;
		this.pol4 = pol4;
		this.bbF = bbF;
		this.sc = sc;
		this.pol3 = pol3;
		this.scOfc = scOfc;
		this.pol2 = pol2;
		this.hgF = hgF;
		this.pol1 = pol1;
		this.repCom = repCom;
		this.vvd2 = vvd2;
		this.drDt = drDt;
		this.cngn = cngn;
		this.vvd3 = vvd3;
		this.akF = akF;
		this.socF = socF;
		this.vvd1 = vvd1;
		this.pod2 = pod2;
		this.pol3N = pol3N;
		this.pod1 = pod1;
		this.bkgNo = bkgNo;
		this.pod4 = pod4;
		this.pod3 = pod3;
		this.vvd4 = vvd4;
		this.pod2N = pod2N;
		this.mPu = mPu;
		this.rdF = rdF;
		this.delN = delN;
		this.pod4N = pod4N;
		this.rfa = rfa;
		this.imdg = imdg;
		this.delT = delT;
		this.ibflag = ibflag;
		this.copyCnt = copyCnt;
		this.bkgOfc = bkgOfc;
		this.fRt = fRt;
		this.del = del;
		this.pod3N = pod3N;
		this.pol2N = pol2N;
		this.pcMode = pcMode;
		this.comBkgNo = comBkgNo;
		this.subF = subF;
		this.lane4 = lane4;
		this.hitchment = hitchment;
		this.lane2 = lane2;
		this.lane3 = lane3;
		this.lane1 = lane1;
		this.dgF = dgF;
		this.rfF = rfF;
		this.noCost = noCost;
		this.cgoTp = cgoTp;
		this.shpr = shpr;
		this.pol1N = pol1N;
		this.obTrspMode = obTrspMode;
		this.obPrioSeq = obPrioSeq;
		this.ibTrspMode = ibTrspMode;
		this.ibPrioSeq = ibPrioSeq;
		this.bkgPctlNo = bkgPctlNo;
		this.internalSkdType = internalSkdType;
		this.mapSeq = mapSeq;
		this.mainPatternPctlNo = mainPatternPctlNo;
		this.troSeq = troSeq;
		this.troSubSeq = troSubSeq;
		this.cTpsz = cTpsz;
		this.cQty = cQty;
		this.troPkupCy = troPkupCy;
		this.dorZone = dorZone;
		this.troRtnCy = troRtnCy;
		this.cntrNo = cntrNo;
		this.haulage = haulage;
		this.trMode = trMode;
		this.mRt = mRt;
		this.replaneBndCd = replaneBndCd;
		this.termNode = termNode;
		this.copNo = copNo;
		this.polPodSep = polPodSep;
		this.sumBkgQty = sumBkgQty;
		this.dgClssCd = dgClssCd;
		this.sumCTpSz = sumCTpSz;
		this.areaContiCd = areaContiCd;
		this.mtPkupDt = mtPkupDt;
		this.bkgRcvT = bkgRcvT;
		this.bkgDelT = bkgDelT;
		this.n1stPolDcSeq = n1stPolDcSeq;
		this.n1stPodDcSeq = n1stPodDcSeq;
		this.n2ndPolDcSeq = n2ndPolDcSeq;
		this.n2ndPodDcSeq = n2ndPodDcSeq;
		this.n3rdPolDcSeq = n3rdPolDcSeq;
		this.n3rdPodDcSeq = n3rdPodDcSeq;
		this.n4thPolDcSeq = n4thPolDcSeq;
		this.n4thPodDcSeq = n4thPodDcSeq;
		this.copMapgSeq = copMapgSeq;
		this.pseudoVvd = pseudoVvd;
		this.shprCntCd = shprCntCd;
		this.shprSeq = shprSeq;
		this.cneeCntCd = cneeCntCd;
		this.cneeSeq = cneeSeq;
		this.ocnSeq = ocnSeq;
		// [CHM-201005548-01]:[SCEM / PRD] F.H. 기능 연계한 개발요청 (변수 추가)
		this.flexHgtFlg = flexHgtFlg;
		this.cntrTpszQtyStr = cntrTpszQtyStr;
		this.cnstDelFlg = cnstDelFlg;
		this.chkYd = chkYd;
		this.moreCnt = moreCnt;
		this.ignoreHitch = ignoreHitch;

	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("com", getCom());
		this.hashColumns.put("ld_dt", getLdDt());
		this.hashColumns.put("f_cmd", getFCmd());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("rcv_t", getRcvT());
		this.hashColumns.put("pol_n", getPolN());
		this.hashColumns.put("pm_f", getPmF());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("wgt", getWgt());
		this.hashColumns.put("rfa_ofc", getRfaOfc());
		this.hashColumns.put("pod1_n", getPod1N());
		this.hashColumns.put("por_n", getPorN());
		this.hashColumns.put("pod_n", getPodN());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("pol4_n", getPol4N());
		this.hashColumns.put("org_sal_ofc", getOrgSalOfc());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("wgt_un", getWgtUn());
		this.hashColumns.put("pol4", getPol4());
		this.hashColumns.put("bb_f", getBbF());
		this.hashColumns.put("sc", getSc());
		this.hashColumns.put("pol3", getPol3());
		this.hashColumns.put("sc_ofc", getScOfc());
		this.hashColumns.put("pol2", getPol2());
		this.hashColumns.put("hg_f", getHgF());
		this.hashColumns.put("pol1", getPol1());
		this.hashColumns.put("rep_com", getRepCom());
		this.hashColumns.put("vvd2", getVvd2());
		this.hashColumns.put("dr_dt", getDrDt());
		this.hashColumns.put("cngn", getCngn());
		this.hashColumns.put("vvd3", getVvd3());
		this.hashColumns.put("ak_f", getAkF());
		this.hashColumns.put("soc_f", getSocF());
		this.hashColumns.put("vvd1", getVvd1());
		this.hashColumns.put("pod2", getPod2());
		this.hashColumns.put("pol3_n", getPol3N());
		this.hashColumns.put("pod1", getPod1());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pod4", getPod4());
		this.hashColumns.put("pod3", getPod3());
		this.hashColumns.put("vvd4", getVvd4());
		this.hashColumns.put("pod2_n", getPod2N());
		this.hashColumns.put("m_pu", getMPu());
		this.hashColumns.put("rd_f", getRdF());
		this.hashColumns.put("del_n", getDelN());
		this.hashColumns.put("pod4_n", getPod4N());
		this.hashColumns.put("rfa", getRfa());
		this.hashColumns.put("imdg", getImdg());
		this.hashColumns.put("del_t", getDelT());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("copy_cnt", getCopyCnt());
		this.hashColumns.put("bkg_ofc", getBkgOfc());
		this.hashColumns.put("f_rt", getFRt());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("pod3_n", getPod3N());
		this.hashColumns.put("pol2_n", getPol2N());
		this.hashColumns.put("pc_mode", getPcMode());
		this.hashColumns.put("com_bkg_no", getComBkgNo());
		this.hashColumns.put("sub_f", getSubF());
		this.hashColumns.put("lane4", getLane4());
		this.hashColumns.put("hitchment", getHitchment());
		this.hashColumns.put("lane2", getLane2());
		this.hashColumns.put("lane3", getLane3());
		this.hashColumns.put("lane1", getLane1());
		this.hashColumns.put("dg_f", getDgF());
		this.hashColumns.put("rf_f", getRfF());
		this.hashColumns.put("no_cost", getNoCost());
		this.hashColumns.put("cgo_tp", getCgoTp());
		this.hashColumns.put("shpr", getShpr());
		this.hashColumns.put("pol1_n", getPol1N());
		this.hashColumns.put("ob_trsp_mode", getObTrspMode());
		this.hashColumns.put("ob_prio_seq", getObPrioSeq());
		this.hashColumns.put("ib_trsp_mode", getIbTrspMode());
		this.hashColumns.put("ib_prio_seq", getIbPrioSeq());
		this.hashColumns.put("bkg_pctl_no", getBkgPctlNo());
		this.hashColumns.put("internal_skd_type", getInternalSkdType());
		this.hashColumns.put("map_seq", getMapSeq());
		this.hashColumns.put("main_pattern_pctl_no", getMainPatternPctlNo());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("tro_sub_seq", getTroSubSeq());

		this.hashColumns.put("c_tpsz", getCTpsz());
		this.hashColumns.put("c_qty", getCQty());
		this.hashColumns.put("tro_pkup_cy", getTroPkupCy());
		this.hashColumns.put("dor_zone", getDorZone());
		this.hashColumns.put("tro_rtn_cy", getTroRtnCy());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("haulage", getHaulage());
		this.hashColumns.put("tr_mode", getTrMode());
		this.hashColumns.put("m_rt", getMRt());
		this.hashColumns.put("replane_bnd_cd", getReplaneBndCd());
		this.hashColumns.put("term_node", getTermNode());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("pol_pod_sep", getPolPodSep());
		this.hashColumns.put("sum_bkg_qty", getSumBkgQty());
		this.hashColumns.put("dgClssCd", getDgClssCd());
		this.hashColumns.put("sumCTpSz", getSumCTpSz());
		this.hashColumns.put("areaContiCd", getAreaContiCd());
		this.hashColumns.put("mtPkupDt", getMtPkupDt());
		this.hashColumns.put("bkgRcvT", getBkgRcvT());
		this.hashColumns.put("bkgDelT", getBkgDelT());
		this.hashColumns.put("n1stPolDcSeq", getN1stPolDcSeq());
		this.hashColumns.put("n1stPodDcSeq", getN1stPodDcSeq());
		this.hashColumns.put("n2ndPolDcSeq", getN2ndPolDcSeq());
		this.hashColumns.put("n2ndPodDcSeq", getN2ndPodDcSeq());
		this.hashColumns.put("n3rdPolDcSeq", getN3rdPolDcSeq());
		this.hashColumns.put("n3rdPodDcSeq", getN3rdPodDcSeq());
		this.hashColumns.put("n4thPolDcSeq", getN4thPolDcSeq());

		this.hashColumns.put("copMapgSeq", getCopMapgSeq());
		this.hashColumns.put("pseudoVvd", getPseudoVvd());
		this.hashColumns.put("shprCntCd", getShprCntCd());
		this.hashColumns.put("shprSeq", getShprSeq());
		this.hashColumns.put("cneeCntCd", getCneeCntCd());
		this.hashColumns.put("cneeSeq", getCneeSeq());

		this.hashColumns.put("ocnSeq", getOcnSeq());
		// [CHM-201005548-01]:[SCEM / PRD] F.H. 기능 연계한 개발요청 (변수 추가)
		this.hashColumns.put("flexHgtFlg", getFlexHgtFlg());
		this.hashColumns.put("cntrTpszQtyStr", getCntrTpszQtyStr());
		this.hashColumns.put("cnstDelFlg", getCnstDelFlg());
		this.hashColumns.put("chkYd", getChkYd());

		this.hashColumns.put("moreCnt", getMoreCnt());
		this.hashColumns.put("ignoreHitch", getIgnoreHitch());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("com", "com");
		this.hashFields.put("ld_dt", "ldDt");
		this.hashFields.put("f_cmd", "fCmd");
		this.hashFields.put("por", "por");
		this.hashFields.put("rcv_t", "rcvT");
		this.hashFields.put("pol_n", "polN");
		this.hashFields.put("pm_f", "pmF");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("wgt", "wgt");
		this.hashFields.put("rfa_ofc", "rfaOfc");
		this.hashFields.put("pod1_n", "pod1N");
		this.hashFields.put("por_n", "porN");
		this.hashFields.put("pod_n", "podN");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("pol4_n", "pol4N");
		this.hashFields.put("org_sal_ofc", "orgSalOfc");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("wgt_un", "wgtUn");
		this.hashFields.put("pol4", "pol4");
		this.hashFields.put("bb_f", "bbF");
		this.hashFields.put("sc", "sc");
		this.hashFields.put("pol3", "pol3");
		this.hashFields.put("sc_ofc", "scOfc");
		this.hashFields.put("pol2", "pol2");
		this.hashFields.put("hg_f", "hgF");
		this.hashFields.put("pol1", "pol1");
		this.hashFields.put("rep_com", "repCom");
		this.hashFields.put("vvd2", "vvd2");
		this.hashFields.put("dr_dt", "drDt");
		this.hashFields.put("cngn", "cngn");
		this.hashFields.put("vvd3", "vvd3");
		this.hashFields.put("ak_f", "akF");
		this.hashFields.put("soc_f", "socF");
		this.hashFields.put("vvd1", "vvd1");
		this.hashFields.put("pod2", "pod2");
		this.hashFields.put("pol3_n", "pol3N");
		this.hashFields.put("pod1", "pod1");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pod4", "pod4");
		this.hashFields.put("pod3", "pod3");
		this.hashFields.put("vvd4", "vvd4");
		this.hashFields.put("pod2_n", "pod2N");
		this.hashFields.put("m_pu", "mPu");
		this.hashFields.put("rd_f", "rdF");
		this.hashFields.put("del_n", "delN");
		this.hashFields.put("pod4_n", "pod4N");
		this.hashFields.put("rfa", "rfa");
		this.hashFields.put("imdg", "imdg");
		this.hashFields.put("del_t", "delT");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("copy_cnt", "copyCnt");
		this.hashFields.put("bkg_ofc", "bkgOfc");
		this.hashFields.put("f_rt", "fRt");
		this.hashFields.put("del", "del");
		this.hashFields.put("pod3_n", "pod3N");
		this.hashFields.put("pol2_n", "pol2N");
		this.hashFields.put("pc_mode", "pcMode");
		this.hashFields.put("com_bkg_no", "comBkgNo");
		this.hashFields.put("sub_f", "subF");
		this.hashFields.put("lane4", "lane4");
		this.hashFields.put("hitchment", "hitchment");
		this.hashFields.put("lane2", "lane2");
		this.hashFields.put("lane3", "lane3");
		this.hashFields.put("lane1", "lane1");
		this.hashFields.put("dg_f", "dgF");
		this.hashFields.put("rf_f", "rfF");
		this.hashFields.put("no_cost", "noCost");
		this.hashFields.put("cgo_tp", "cgoTp");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("pol1_n", "pol1N");
		this.hashFields.put("ob_trsp_mode", "obTrspMode");
		this.hashFields.put("ob_prio_seq", "obPrioSeq");
		this.hashFields.put("ib_trsp_mode", "ibTrspMode");
		this.hashFields.put("ib_prio_seq", "ibPrioSeq");
		this.hashFields.put("bkg_pctl_no", "bkgPctlNo");
		this.hashFields.put("internal_skd_type", "internal_skd_type");
		this.hashFields.put("map_seq", "mapSeq");
		this.hashFields.put("main_pattern_pctl_no", "mainPatternPctlNo");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("tro_sub_seq", "troSubSeq");

		this.hashFields.put("c_tpsz", "cTpsz");
		this.hashFields.put("c_qty", "cQty");
		this.hashFields.put("tro_pkup_cy", "troPkupCy");
		this.hashFields.put("dor_zone", "dorZone");
		this.hashFields.put("tro_rtn_cy", "troRtnCy");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("haulage", "haulage");
		this.hashFields.put("tr_mode", "trMode");
		this.hashFields.put("m_rt", "mRt");
		this.hashFields.put("replane_bnd_cd", "replaneBndCd");
		this.hashFields.put("term_node", "termNode");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("pol_pod_sep", "polPodSep");
		this.hashFields.put("sum_bkg_qty", "sumBkgQty");
		this.hashFields.put("dg_clss_cd", "dgClssCd");
		this.hashFields.put("sum_c_tp_sz", "sumCTpSz");
		this.hashFields.put("area_conti_cd", "areaContiCd");
		this.hashFields.put("mt_pkup_dt", "mtPkupDt");
		this.hashFields.put("bkg_rcv_t", "bkgRcvT");
		this.hashFields.put("bkg_del_t", "bkgDelT");

		this.hashFields.put("n1st_pol_dc_seq", "n1stPolDcSeq");
		this.hashFields.put("n1st_pod_dc_seq", "n1stPodDcSeq");
		this.hashFields.put("n2nd_pol_dc_seq", "n2ndPolDcSeq");
		this.hashFields.put("n2nd_pod_dc_seq", "n2ndPodDcSeq");
		this.hashFields.put("n3rd_pol_dc_seq", "n3rdPolDcSeq");
		this.hashFields.put("n3rd_pod_dc_seq", "n3rdPodDcSeq");
		this.hashFields.put("n4th_pol_dc_seq", "n4thPolDcSeq");
		this.hashFields.put("n4th_pod_dc_seq", "n4thPodDcSeq");

		this.hashFields.put("cop_mapg_seq", "copMapgSeq");
		this.hashFields.put("pseudo_vvd", "pseudoVvd");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("shpr_seq", "shprSeq");
		this.hashFields.put("cnee_cnt_cd", "cneeCntCd");
		this.hashFields.put("cnee_seq", "cneeSeq");

		this.hashFields.put("ocn_seq", "ocnSeq");
		this.hashFields.put("flex_hgt_flg", "flexHgtFlg");
		this.hashFields.put("cntr_tpsz_qty_str", "cntrTpszQtyStr");
		this.hashFields.put("cnst_del_flg", "cnstDelFlg");
		this.hashFields.put("chk_yd", "chkYd");
		this.hashFields.put("more_cnt", "moreCnt");
		this.hashFields.put("ignore_hitch", "ignoreHitch");

		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return com
	 */
	public String getCom() {
		return this.com;
	}

	/**
	 * Column Info
	 * 
	 * @return ldDt
	 */
	public String getLdDt() {
		return this.ldDt;
	}

	/**
	 * Column Info
	 * 
	 * @return fCmd
	 */
	public String getFCmd() {
		return this.fCmd;
	}

	/**
	 * Column Info
	 * 
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}

	/**
	 * Column Info
	 * 
	 * @return rcvT
	 */
	public String getRcvT() {
		return this.rcvT;
	}

	/**
	 * Column Info
	 * 
	 * @return polN
	 */
	public String getPolN() {
		return this.polN;
	}

	/**
	 * Column Info
	 * 
	 * @return pmF
	 */
	public String getPmF() {
		return this.pmF;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @return tVvd
	 */
	public String getTVvd() {
		return this.tVvd;
	}

	/**
	 * Column Info
	 * 
	 * @return wgt
	 */
	public String getWgt() {
		return this.wgt;
	}

	/**
	 * Column Info
	 * 
	 * @return rfaOfc
	 */
	public String getRfaOfc() {
		return this.rfaOfc;
	}

	/**
	 * Column Info
	 * 
	 * @return pod1N
	 */
	public String getPod1N() {
		return this.pod1N;
	}

	/**
	 * Column Info
	 * 
	 * @return porN
	 */
	public String getPorN() {
		return this.porN;
	}

	/**
	 * Column Info
	 * 
	 * @return podN
	 */
	public String getPodN() {
		return this.podN;
	}

	/**
	 * Column Info
	 * 
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}

	/**
	 * Column Info
	 * 
	 * @return pol4N
	 */
	public String getPol4N() {
		return this.pol4N;
	}

	/**
	 * Column Info
	 * 
	 * @return orgSalOfc
	 */
	public String getOrgSalOfc() {
		return this.orgSalOfc;
	}

	/**
	 * Column Info
	 * 
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}

	/**
	 * Column Info
	 * 
	 * @return wgtUn
	 */
	public String getWgtUn() {
		return this.wgtUn;
	}

	/**
	 * Column Info
	 * 
	 * @return pol4
	 */
	public String getPol4() {
		return this.pol4;
	}

	/**
	 * Column Info
	 * 
	 * @return bbF
	 */
	public String getBbF() {
		return this.bbF;
	}

	/**
	 * Column Info
	 * 
	 * @return sc
	 */
	public String getSc() {
		return this.sc;
	}

	/**
	 * Column Info
	 * 
	 * @return pol3
	 */
	public String getPol3() {
		return this.pol3;
	}

	/**
	 * Column Info
	 * 
	 * @return scOfc
	 */
	public String getScOfc() {
		return this.scOfc;
	}

	/**
	 * Column Info
	 * 
	 * @return pol2
	 */
	public String getPol2() {
		return this.pol2;
	}

	/**
	 * Column Info
	 * 
	 * @return hgF
	 */
	public String getHgF() {
		return this.hgF;
	}

	/**
	 * Column Info
	 * 
	 * @return pol1
	 */
	public String getPol1() {
		return this.pol1;
	}

	/**
	 * Column Info
	 * 
	 * @return repCom
	 */
	public String getRepCom() {
		return this.repCom;
	}

	/**
	 * Column Info
	 * 
	 * @return vvd2
	 */
	public String getVvd2() {
		return this.vvd2;
	}

	/**
	 * Column Info
	 * 
	 * @return drDt
	 */
	public String getDrDt() {
		return this.drDt;
	}

	/**
	 * Column Info
	 * 
	 * @return cngn
	 */
	public String getCngn() {
		return this.cngn;
	}

	/**
	 * Column Info
	 * 
	 * @return vvd3
	 */
	public String getVvd3() {
		return this.vvd3;
	}

	/**
	 * Column Info
	 * 
	 * @return akF
	 */
	public String getAkF() {
		return this.akF;
	}

	/**
	 * Column Info
	 * 
	 * @return socF
	 */
	public String getSocF() {
		return this.socF;
	}

	/**
	 * Column Info
	 * 
	 * @return vvd1
	 */
	public String getVvd1() {
		return this.vvd1;
	}

	/**
	 * Column Info
	 * 
	 * @return pod2
	 */
	public String getPod2() {
		return this.pod2;
	}

	/**
	 * Column Info
	 * 
	 * @return pol3N
	 */
	public String getPol3N() {
		return this.pol3N;
	}

	/**
	 * Column Info
	 * 
	 * @return pod1
	 */
	public String getPod1() {
		return this.pod1;
	}

	/**
	 * Column Info
	 * 
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * 
	 * @return pod4
	 */
	public String getPod4() {
		return this.pod4;
	}

	/**
	 * Column Info
	 * 
	 * @return pod3
	 */
	public String getPod3() {
		return this.pod3;
	}

	/**
	 * Column Info
	 * 
	 * @return vvd4
	 */
	public String getVvd4() {
		return this.vvd4;
	}

	/**
	 * Column Info
	 * 
	 * @return pod2N
	 */
	public String getPod2N() {
		return this.pod2N;
	}

	/**
	 * Column Info
	 * 
	 * @return mPu
	 */
	public String getMPu() {
		return this.mPu;
	}

	/**
	 * Column Info
	 * 
	 * @return rdF
	 */
	public String getRdF() {
		return this.rdF;
	}

	/**
	 * Column Info
	 * 
	 * @return delN
	 */
	public String getDelN() {
		return this.delN;
	}

	/**
	 * Column Info
	 * 
	 * @return pod4N
	 */
	public String getPod4N() {
		return this.pod4N;
	}

	/**
	 * Column Info
	 * 
	 * @return rfa
	 */
	public String getRfa() {
		return this.rfa;
	}

	/**
	 * Column Info
	 * 
	 * @return imdg
	 */
	public String getImdg() {
		return this.imdg;
	}

	/**
	 * Column Info
	 * 
	 * @return delT
	 */
	public String getDelT() {
		return this.delT;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return copyCnt
	 */
	public String getCopyCnt() {
		return this.copyCnt;
	}

	/**
	 * Column Info
	 * 
	 * @return bkgOfc
	 */
	public String getBkgOfc() {
		return this.bkgOfc;
	}

	/**
	 * Column Info
	 * 
	 * @return fRt
	 */
	public String getFRt() {
		return this.fRt;
	}

	/**
	 * Column Info
	 * 
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}

	/**
	 * Column Info
	 * 
	 * @return pod3N
	 */
	public String getPod3N() {
		return this.pod3N;
	}

	/**
	 * Column Info
	 * 
	 * @return pol2N
	 */
	public String getPol2N() {
		return this.pol2N;
	}

	/**
	 * Column Info
	 * 
	 * @return pcMode
	 */
	public String getPcMode() {
		return this.pcMode;
	}

	/**
	 * Column Info
	 * 
	 * @return comBkgNo
	 */
	public String getComBkgNo() {
		return this.comBkgNo;
	}

	/**
	 * Column Info
	 * 
	 * @return subF
	 */
	public String getSubF() {
		return this.subF;
	}

	/**
	 * Column Info
	 * 
	 * @return lane4
	 */
	public String getLane4() {
		return this.lane4;
	}

	/**
	 * Column Info
	 * 
	 * @return hitchment
	 */
	public String getHitchment() {
		return this.hitchment;
	}

	/**
	 * Column Info
	 * 
	 * @return lane2
	 */
	public String getLane2() {
		return this.lane2;
	}

	/**
	 * Column Info
	 * 
	 * @return lane3
	 */
	public String getLane3() {
		return this.lane3;
	}

	/**
	 * Column Info
	 * 
	 * @return lane1
	 */
	public String getLane1() {
		return this.lane1;
	}

	/**
	 * Column Info
	 * 
	 * @return dgF
	 */
	public String getDgF() {
		return this.dgF;
	}

	/**
	 * Column Info
	 * 
	 * @return rfF
	 */
	public String getRfF() {
		return this.rfF;
	}

	/**
	 * Column Info
	 * 
	 * @return noCost
	 */
	public String getNoCost() {
		return this.noCost;
	}

	/**
	 * Column Info
	 * 
	 * @return cgoTp
	 */
	public String getCgoTp() {
		return this.cgoTp;
	}

	/**
	 * Column Info
	 * 
	 * @return shpr
	 */
	public String getShpr() {
		return this.shpr;
	}

	/**
	 * Column Info
	 * 
	 * @return pol1N
	 */
	public String getPol1N() {
		return this.pol1N;
	}

	public String getObTrspMode() {
		return obTrspMode;
	}

	public String getObPrioSeq() {
		return obPrioSeq;
	}

	public String getIbTrspMode() {
		return ibTrspMode;
	}

	public String getIbPrioSeq() {
		return ibPrioSeq;
	}

	public String getBkgPctlNo() {
		return bkgPctlNo;
	}

	public String getMapSeq() {
		return mapSeq;
	}

	public String getMainPatternPctlNo() {
		return mainPatternPctlNo;
	}

	public void setMainPatternPctlNo(String mainPatternPctlNo) {
		this.mainPatternPctlNo = mainPatternPctlNo;
	}

	public void setMapSeq(String mapSeq) {
		this.mapSeq = mapSeq;
	}

	public void setBkgPctlNo(String bkgPctlNo) {
		this.bkgPctlNo = bkgPctlNo;
	}

	public String getInternalSkdType() {
		return internalSkdType;
	}

	public void setInternalSkdType(String internalSkdType) {
		this.internalSkdType = internalSkdType;
	}

	public void setObTrspMode(String obTrspMode) {
		this.obTrspMode = obTrspMode;
	}

	public void setObPrioSeq(String obPrioSeq) {
		this.obPrioSeq = obPrioSeq;
	}

	public void setIbTrspMode(String ibTrspMode) {
		this.ibTrspMode = ibTrspMode;
	}

	public void setIbPrioSeq(String ibPrioSeq) {
		this.ibPrioSeq = ibPrioSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param com
	 */
	public void setCom(String com) {
		this.com = com;
	}

	/**
	 * Column Info
	 * 
	 * @param ldDt
	 */
	public void setLdDt(String ldDt) {
		this.ldDt = ldDt;
	}

	/**
	 * Column Info
	 * 
	 * @param fCmd
	 */
	public void setFCmd(String fCmd) {
		this.fCmd = fCmd;
	}

	/**
	 * Column Info
	 * 
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}

	/**
	 * Column Info
	 * 
	 * @param rcvT
	 */
	public void setRcvT(String rcvT) {
		this.rcvT = rcvT;
	}

	/**
	 * Column Info
	 * 
	 * @param polN
	 */
	public void setPolN(String polN) {
		this.polN = polN;
	}

	/**
	 * Column Info
	 * 
	 * @param pmF
	 */
	public void setPmF(String pmF) {
		this.pmF = pmF;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param tVvd
	 */
	public void setTVvd(String tVvd) {
		this.tVvd = tVvd;
	}

	/**
	 * Column Info
	 * 
	 * @param wgt
	 */
	public void setWgt(String wgt) {
		this.wgt = wgt;
	}

	/**
	 * Column Info
	 * 
	 * @param rfaOfc
	 */
	public void setRfaOfc(String rfaOfc) {
		this.rfaOfc = rfaOfc;
	}

	/**
	 * Column Info
	 * 
	 * @param pod1N
	 */
	public void setPod1N(String pod1N) {
		this.pod1N = pod1N;
	}

	/**
	 * Column Info
	 * 
	 * @param porN
	 */
	public void setPorN(String porN) {
		this.porN = porN;
	}

	/**
	 * Column Info
	 * 
	 * @param podN
	 */
	public void setPodN(String podN) {
		this.podN = podN;
	}

	/**
	 * Column Info
	 * 
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}

	/**
	 * Column Info
	 * 
	 * @param pol4N
	 */
	public void setPol4N(String pol4N) {
		this.pol4N = pol4N;
	}

	/**
	 * Column Info
	 * 
	 * @param orgSalOfc
	 */
	public void setOrgSalOfc(String orgSalOfc) {
		this.orgSalOfc = orgSalOfc;
	}

	/**
	 * Column Info
	 * 
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}

	/**
	 * Column Info
	 * 
	 * @param wgtUn
	 */
	public void setWgtUn(String wgtUn) {
		this.wgtUn = wgtUn;
	}

	/**
	 * Column Info
	 * 
	 * @param pol4
	 */
	public void setPol4(String pol4) {
		this.pol4 = pol4;
	}

	/**
	 * Column Info
	 * 
	 * @param bbF
	 */
	public void setBbF(String bbF) {
		this.bbF = bbF;
	}

	/**
	 * Column Info
	 * 
	 * @param sc
	 */
	public void setSc(String sc) {
		this.sc = sc;
	}

	/**
	 * Column Info
	 * 
	 * @param pol3
	 */
	public void setPol3(String pol3) {
		this.pol3 = pol3;
	}

	/**
	 * Column Info
	 * 
	 * @param scOfc
	 */
	public void setScOfc(String scOfc) {
		this.scOfc = scOfc;
	}

	/**
	 * Column Info
	 * 
	 * @param pol2
	 */
	public void setPol2(String pol2) {
		this.pol2 = pol2;
	}

	/**
	 * Column Info
	 * 
	 * @param hgF
	 */
	public void setHgF(String hgF) {
		this.hgF = hgF;
	}

	/**
	 * Column Info
	 * 
	 * @param pol1
	 */
	public void setPol1(String pol1) {
		this.pol1 = pol1;
	}

	/**
	 * Column Info
	 * 
	 * @param repCom
	 */
	public void setRepCom(String repCom) {
		this.repCom = repCom;
	}

	/**
	 * Column Info
	 * 
	 * @param vvd2
	 */
	public void setVvd2(String vvd2) {
		this.vvd2 = vvd2;
	}

	/**
	 * Column Info
	 * 
	 * @param drDt
	 */
	public void setDrDt(String drDt) {
		this.drDt = drDt;
	}

	/**
	 * Column Info
	 * 
	 * @param cngn
	 */
	public void setCngn(String cngn) {
		this.cngn = cngn;
	}

	/**
	 * Column Info
	 * 
	 * @param vvd3
	 */
	public void setVvd3(String vvd3) {
		this.vvd3 = vvd3;
	}

	/**
	 * Column Info
	 * 
	 * @param akF
	 */
	public void setAkF(String akF) {
		this.akF = akF;
	}

	/**
	 * Column Info
	 * 
	 * @param socF
	 */
	public void setSocF(String socF) {
		this.socF = socF;
	}

	/**
	 * Column Info
	 * 
	 * @param vvd1
	 */
	public void setVvd1(String vvd1) {
		this.vvd1 = vvd1;
	}

	/**
	 * Column Info
	 * 
	 * @param pod2
	 */
	public void setPod2(String pod2) {
		this.pod2 = pod2;
	}

	/**
	 * Column Info
	 * 
	 * @param pol3N
	 */
	public void setPol3N(String pol3N) {
		this.pol3N = pol3N;
	}

	/**
	 * Column Info
	 * 
	 * @param pod1
	 */
	public void setPod1(String pod1) {
		this.pod1 = pod1;
	}

	/**
	 * Column Info
	 * 
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * 
	 * @param pod4
	 */
	public void setPod4(String pod4) {
		this.pod4 = pod4;
	}

	/**
	 * Column Info
	 * 
	 * @param pod3
	 */
	public void setPod3(String pod3) {
		this.pod3 = pod3;
	}

	/**
	 * Column Info
	 * 
	 * @param vvd4
	 */
	public void setVvd4(String vvd4) {
		this.vvd4 = vvd4;
	}

	/**
	 * Column Info
	 * 
	 * @param pod2N
	 */
	public void setPod2N(String pod2N) {
		this.pod2N = pod2N;
	}

	/**
	 * Column Info
	 * 
	 * @param mPu
	 */
	public void setMPu(String mPu) {
		this.mPu = mPu;
	}

	/**
	 * Column Info
	 * 
	 * @param rdF
	 */
	public void setRdF(String rdF) {
		this.rdF = rdF;
	}

	/**
	 * Column Info
	 * 
	 * @param delN
	 */
	public void setDelN(String delN) {
		this.delN = delN;
	}

	/**
	 * Column Info
	 * 
	 * @param pod4N
	 */
	public void setPod4N(String pod4N) {
		this.pod4N = pod4N;
	}

	/**
	 * Column Info
	 * 
	 * @param rfa
	 */
	public void setRfa(String rfa) {
		this.rfa = rfa;
	}

	/**
	 * Column Info
	 * 
	 * @param imdg
	 */
	public void setImdg(String imdg) {
		this.imdg = imdg;
	}

	/**
	 * Column Info
	 * 
	 * @param delT
	 */
	public void setDelT(String delT) {
		this.delT = delT;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param copyCnt
	 */
	public void setCopyCnt(String copyCnt) {
		this.copyCnt = copyCnt;
	}

	/**
	 * Column Info
	 * 
	 * @param bkgOfc
	 */
	public void setBkgOfc(String bkgOfc) {
		this.bkgOfc = bkgOfc;
	}

	/**
	 * Column Info
	 * 
	 * @param fRt
	 */
	public void setFRt(String fRt) {
		this.fRt = fRt;
	}

	/**
	 * Column Info
	 * 
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}

	/**
	 * Column Info
	 * 
	 * @param pod3N
	 */
	public void setPod3N(String pod3N) {
		this.pod3N = pod3N;
	}

	/**
	 * Column Info
	 * 
	 * @param pol2N
	 */
	public void setPol2N(String pol2N) {
		this.pol2N = pol2N;
	}

	/**
	 * Column Info
	 * 
	 * @param pcMode
	 */
	public void setPcMode(String pcMode) {
		this.pcMode = pcMode;
	}

	/**
	 * Column Info
	 * 
	 * @param comBkgNo
	 */
	public void setComBkgNo(String comBkgNo) {
		this.comBkgNo = comBkgNo;
	}

	/**
	 * Column Info
	 * 
	 * @param subF
	 */
	public void setSubF(String subF) {
		this.subF = subF;
	}

	/**
	 * Column Info
	 * 
	 * @param lane4
	 */
	public void setLane4(String lane4) {
		this.lane4 = lane4;
	}

	/**
	 * Column Info
	 * 
	 * @param hitchment
	 */
	public void setHitchment(String hitchment) {
		this.hitchment = hitchment;
	}

	/**
	 * Column Info
	 * 
	 * @param lane2
	 */
	public void setLane2(String lane2) {
		this.lane2 = lane2;
	}

	/**
	 * Column Info
	 * 
	 * @param lane3
	 */
	public void setLane3(String lane3) {
		this.lane3 = lane3;
	}

	/**
	 * Column Info
	 * 
	 * @param lane1
	 */
	public void setLane1(String lane1) {
		this.lane1 = lane1;
	}

	/**
	 * Column Info
	 * 
	 * @param dgF
	 */
	public void setDgF(String dgF) {
		this.dgF = dgF;
	}

	/**
	 * Column Info
	 * 
	 * @param rfF
	 */
	public void setRfF(String rfF) {
		this.rfF = rfF;
	}

	/**
	 * Column Info
	 * 
	 * @param noCost
	 */
	public void setNoCost(String noCost) {
		this.noCost = noCost;
	}

	/**
	 * Column Info
	 * 
	 * @param cgoTp
	 */
	public void setCgoTp(String cgoTp) {
		this.cgoTp = cgoTp;
	}

	/**
	 * Column Info
	 * 
	 * @param shpr
	 */
	public void setShpr(String shpr) {
		this.shpr = shpr;
	}

	/**
	 * Column Info
	 * 
	 * @param pol1N
	 */
	public void setPol1N(String pol1N) {
		this.pol1N = pol1N;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 */
	public void fromRequest(HttpServletRequest request) {
		setCom(JSPUtil.getParameter(request, "com", ""));
		setLdDt(JSPUtil.getParameter(request, "ld_dt", ""));
		setFCmd(JSPUtil.getParameter(request, "f_cmd", ""));
		setPor(JSPUtil.getParameter(request, "por", ""));
		setRcvT(JSPUtil.getParameter(request, "rcv_t", ""));
		setPolN(JSPUtil.getParameter(request, "pol_n", ""));
		setPmF(JSPUtil.getParameter(request, "pm_f", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTVvd(JSPUtil.getParameter(request, "t_vvd", ""));
		setWgt(JSPUtil.getParameter(request, "wgt", ""));
		setRfaOfc(JSPUtil.getParameter(request, "rfa_ofc", ""));
		setPod1N(JSPUtil.getParameter(request, "pod1_n", ""));
		setPorN(JSPUtil.getParameter(request, "por_n", ""));
		setPodN(JSPUtil.getParameter(request, "pod_n", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setPol4N(JSPUtil.getParameter(request, "pol4_n", ""));
		setOrgSalOfc(JSPUtil.getParameter(request, "org_sal_ofc", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setWgtUn(JSPUtil.getParameter(request, "wgt_un", ""));
		setPol4(JSPUtil.getParameter(request, "pol4", ""));
		setBbF(JSPUtil.getParameter(request, "bb_f", ""));
		setSc(JSPUtil.getParameter(request, "sc", ""));
		setPol3(JSPUtil.getParameter(request, "pol3", ""));
		setScOfc(JSPUtil.getParameter(request, "sc_ofc", ""));
		setPol2(JSPUtil.getParameter(request, "pol2", ""));
		setHgF(JSPUtil.getParameter(request, "hg_f", ""));
		setPol1(JSPUtil.getParameter(request, "pol1", ""));
		setRepCom(JSPUtil.getParameter(request, "rep_com", ""));
		setVvd2(JSPUtil.getParameter(request, "vvd2", ""));
		setDrDt(JSPUtil.getParameter(request, "dr_dt", ""));
		setCngn(JSPUtil.getParameter(request, "cngn", ""));
		setVvd3(JSPUtil.getParameter(request, "vvd3", ""));
		setAkF(JSPUtil.getParameter(request, "ak_f", ""));
		setSocF(JSPUtil.getParameter(request, "soc_f", ""));
		setVvd1(JSPUtil.getParameter(request, "vvd1", ""));
		setPod2(JSPUtil.getParameter(request, "pod2", ""));
		setPol3N(JSPUtil.getParameter(request, "pol3_n", ""));
		setPod1(JSPUtil.getParameter(request, "pod1", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPod4(JSPUtil.getParameter(request, "pod4", ""));
		setPod3(JSPUtil.getParameter(request, "pod3", ""));
		setVvd4(JSPUtil.getParameter(request, "vvd4", ""));
		setPod2N(JSPUtil.getParameter(request, "pod2_n", ""));
		setMPu(JSPUtil.getParameter(request, "m_pu", ""));
		setRdF(JSPUtil.getParameter(request, "rd_f", ""));
		setDelN(JSPUtil.getParameter(request, "del_n", ""));
		setPod4N(JSPUtil.getParameter(request, "pod4_n", ""));
		setRfa(JSPUtil.getParameter(request, "rfa", ""));
		setImdg(JSPUtil.getParameter(request, "imdg", ""));
		setDelT(JSPUtil.getParameter(request, "del_t", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCopyCnt(JSPUtil.getParameter(request, "copy_cnt", ""));
		setBkgOfc(JSPUtil.getParameter(request, "bkg_ofc", ""));
		setFRt(JSPUtil.getParameter(request, "f_rt", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setPod3N(JSPUtil.getParameter(request, "pod3_n", ""));
		setPol2N(JSPUtil.getParameter(request, "pol2_n", ""));
		setPcMode(JSPUtil.getParameter(request, "pc_mode", ""));
		setComBkgNo(JSPUtil.getParameter(request, "com_bkg_no", ""));
		setSubF(JSPUtil.getParameter(request, "sub_f", ""));
		setLane4(JSPUtil.getParameter(request, "lane4", ""));
		setHitchment(JSPUtil.getParameter(request, "hitchment", ""));
		setLane2(JSPUtil.getParameter(request, "lane2", ""));
		setLane3(JSPUtil.getParameter(request, "lane3", ""));
		setLane1(JSPUtil.getParameter(request, "lane1", ""));
		setDgF(JSPUtil.getParameter(request, "dg_f", ""));
		setRfF(JSPUtil.getParameter(request, "rf_f", ""));
		setNoCost(JSPUtil.getParameter(request, "no_cost", ""));
		setCgoTp(JSPUtil.getParameter(request, "cgo_tp", ""));
		setShpr(JSPUtil.getParameter(request, "shpr", ""));
		setPol1N(JSPUtil.getParameter(request, "pol1_n", ""));
		setObTrspMode(JSPUtil.getParameter(request, "ob_trsp_mode", ""));
		setObPrioSeq(JSPUtil.getParameter(request, "ob_prio_seq", ""));
		setIbTrspMode(JSPUtil.getParameter(request, "ib_trsp_mode", ""));
		setIbPrioSeq(JSPUtil.getParameter(request, "ib_prio_seq", ""));
		setBkgPctlNo(JSPUtil.getParameter(request, "bkg_pctl_no", ""));
		setInternalSkdType(JSPUtil.getParameter(request, "internal_skd_type", ""));
		setMapSeq(JSPUtil.getParameter(request, "map_seq", ""));

		setMainPatternPctlNo(JSPUtil.getParameter(request, "main_pattern_pctl_no", ""));
		setTroSeq(JSPUtil.getParameter(request, "tro_seq", ""));
		setTroSubSeq(JSPUtil.getParameter(request, "tro_sub_seq", ""));

		setCTpsz(JSPUtil.getParameter(request, "c_tpsz", ""));
		setCQty(JSPUtil.getParameter(request, "c_qty", ""));
		setTroPkupCy(JSPUtil.getParameter(request, "tro_pkup_cy", ""));
		setDorZone(JSPUtil.getParameter(request, "dor_zone", ""));
		setTroRtnCy(JSPUtil.getParameter(request, "tro_rtn_cy", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setHaulage(JSPUtil.getParameter(request, "haulage", ""));
		setTrMode(JSPUtil.getParameter(request, "tr_mode", ""));
		setMRt(JSPUtil.getParameter(request, "m_rt", ""));
		setMRt(JSPUtil.getParameter(request, "replane_bnd_cd", ""));
		setTermNode(JSPUtil.getParameter(request, "term_node", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setPolPodSep(JSPUtil.getParameter(request, "pol_pod_sep", ""));
		setSumBkgQty(JSPUtil.getParameter(request, "sum_bkg_qty", ""));

		// SHPR_CNT_CD, SHPR_SEQ,
		setShprCntCd(getShpr().length() >= 2 ? getShpr().substring(0, 2) : "");
		setShprSeq(getShpr().length() >= 2 ? getShpr().substring(2) : "");

		// CNEE_CNT_CD, CNEE_SEQ
		setCneeCntCd(getCngn().length() >= 2 ? getCngn().substring(0, 2) : "");
		setCneeSeq(getCngn().length() >= 2 ? getCngn().substring(2) : "");

		setDgClssCd(JSPUtil.getParameter(request, "dg_clss_cd", ""));
		setSumCTpSz(JSPUtil.getParameter(request, "sum_c_tp_sz", ""));
		setAreaContiCd(JSPUtil.getParameter(request, "area_conti_cd", ""));
		setMtPkupDt(JSPUtil.getParameter(request, "mt_pkup_dt", ""));
		log.debug("\n\n request, mt_pkup_dt" + JSPUtil.getParameter(request, "mt_pkup_dt", ""));
		setBkgRcvT(JSPUtil.getParameter(request, "bkg_rcv_t", ""));
		setBkgDelT(JSPUtil.getParameter(request, "bkg_del_t", ""));

		// pc화면에서 다시 호출할때
		setN1stPolDcSeq(JSPUtil.getParameter(request, "n1st_pol_dc_seq", ""));
		setN1stPodDcSeq(JSPUtil.getParameter(request, "n1st_pod_dc_seq", ""));
		setN2ndPolDcSeq(JSPUtil.getParameter(request, "n2nd_pol_dc_seq", ""));
		setN2ndPodDcSeq(JSPUtil.getParameter(request, "n2nd_pod_dc_seq", ""));
		setN3rdPolDcSeq(JSPUtil.getParameter(request, "n3rd_pol_dc_seq", ""));
		setN3rdPodDcSeq(JSPUtil.getParameter(request, "n3rd_pod_dc_seq", ""));
		setN4thPolDcSeq(JSPUtil.getParameter(request, "n4th_pol_dc_seq", ""));
		setN4thPodDcSeq(JSPUtil.getParameter(request, "n4th_pod_dc_seq", ""));

		setOcnSeq(JSPUtil.getParameter(request, "ocn_seq", ""));
		// [CHM-201005548-01]:[SCEM / PRD] F.H. 기능 연계한 개발요청 (변수 추가)
		setFlexHgtFlg(JSPUtil.getParameter(request, "flex_hgt_flg", ""));
		setCntrTpszQtyStr(JSPUtil.getParameter(request, "cntr_tpsz_qty_str", ""));
		setCopMapgSeq(JSPUtil.getParameter(request, "cop_mapg_seq", ""));
		setCnstDelFlg(JSPUtil.getParameter(request, "cnst_del_flg", ""));
		setChkYd(JSPUtil.getParameter(request, "chk_yd", ""));
		setMoreCnt(JSPUtil.getParameter(request, "more_cnt", ""));
		setIgnoreHitch(JSPUtil.getParameter(request, "ignore_hitch", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return PrdCreateParamVO[]
	 */
	public PrdCreateParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return PrdCreateParamVO[]
	 */
	public PrdCreateParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PrdCreateParamVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] com = (JSPUtil.getParameter(request, prefix + "com", length));
			String[] ldDt = (JSPUtil.getParameter(request, prefix + "ld_dt", length));
			String[] fCmd = (JSPUtil.getParameter(request, prefix + "f_cmd", length));
			String[] por = (JSPUtil.getParameter(request, prefix + "por", length));
			String[] rcvT = (JSPUtil.getParameter(request, prefix + "rcv_t", length));
			String[] polN = (JSPUtil.getParameter(request, prefix + "pol_n", length));
			String[] pmF = (JSPUtil.getParameter(request, prefix + "pm_f", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix + "t_vvd", length));
			String[] wgt = (JSPUtil.getParameter(request, prefix + "wgt", length));
			String[] rfaOfc = (JSPUtil.getParameter(request, prefix + "rfa_ofc", length));
			String[] pod1N = (JSPUtil.getParameter(request, prefix + "pod1_n", length));
			String[] porN = (JSPUtil.getParameter(request, prefix + "por_n", length));
			String[] podN = (JSPUtil.getParameter(request, prefix + "pod_n", length));
			String[] pol = (JSPUtil.getParameter(request, prefix + "pol", length));
			String[] pol4N = (JSPUtil.getParameter(request, prefix + "pol4_n", length));
			String[] orgSalOfc = (JSPUtil.getParameter(request, prefix + "org_sal_ofc", length));
			String[] pod = (JSPUtil.getParameter(request, prefix + "pod", length));
			String[] wgtUn = (JSPUtil.getParameter(request, prefix + "wgt_un", length));
			String[] pol4 = (JSPUtil.getParameter(request, prefix + "pol4", length));
			String[] bbF = (JSPUtil.getParameter(request, prefix + "bb_f", length));
			String[] sc = (JSPUtil.getParameter(request, prefix + "sc", length));
			String[] pol3 = (JSPUtil.getParameter(request, prefix + "pol3", length));
			String[] scOfc = (JSPUtil.getParameter(request, prefix + "sc_ofc", length));
			String[] pol2 = (JSPUtil.getParameter(request, prefix + "pol2", length));
			String[] hgF = (JSPUtil.getParameter(request, prefix + "hg_f", length));
			String[] pol1 = (JSPUtil.getParameter(request, prefix + "pol1", length));
			String[] repCom = (JSPUtil.getParameter(request, prefix + "rep_com", length));
			String[] vvd2 = (JSPUtil.getParameter(request, prefix + "vvd2", length));
			String[] drDt = (JSPUtil.getParameter(request, prefix + "dr_dt", length));
			String[] cngn = (JSPUtil.getParameter(request, prefix + "cngn", length));
			String[] vvd3 = (JSPUtil.getParameter(request, prefix + "vvd3", length));
			String[] akF = (JSPUtil.getParameter(request, prefix + "ak_f", length));
			String[] socF = (JSPUtil.getParameter(request, prefix + "soc_f", length));
			String[] vvd1 = (JSPUtil.getParameter(request, prefix + "vvd1", length));
			String[] pod2 = (JSPUtil.getParameter(request, prefix + "pod2", length));
			String[] pol3N = (JSPUtil.getParameter(request, prefix + "pol3_n", length));
			String[] pod1 = (JSPUtil.getParameter(request, prefix + "pod1", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
			String[] pod4 = (JSPUtil.getParameter(request, prefix + "pod4", length));
			String[] pod3 = (JSPUtil.getParameter(request, prefix + "pod3", length));
			String[] vvd4 = (JSPUtil.getParameter(request, prefix + "vvd4", length));
			String[] pod2N = (JSPUtil.getParameter(request, prefix + "pod2_n", length));
			String[] mPu = (JSPUtil.getParameter(request, prefix + "m_pu", length));
			String[] rdF = (JSPUtil.getParameter(request, prefix + "rd_f", length));
			String[] delN = (JSPUtil.getParameter(request, prefix + "del_n", length));
			String[] pod4N = (JSPUtil.getParameter(request, prefix + "pod4_n", length));
			String[] rfa = (JSPUtil.getParameter(request, prefix + "rfa", length));
			String[] imdg = (JSPUtil.getParameter(request, prefix + "imdg", length));
			String[] delT = (JSPUtil.getParameter(request, prefix + "del_t", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] copyCnt = (JSPUtil.getParameter(request, prefix + "copy_cnt", length));
			String[] bkgOfc = (JSPUtil.getParameter(request, prefix + "bkg_ofc", length));
			String[] fRt = (JSPUtil.getParameter(request, prefix + "f_rt", length));
			String[] del = (JSPUtil.getParameter(request, prefix + "del", length));
			String[] pod3N = (JSPUtil.getParameter(request, prefix + "pod3_n", length));
			String[] pol2N = (JSPUtil.getParameter(request, prefix + "pol2_n", length));
			String[] pcMode = (JSPUtil.getParameter(request, prefix + "pc_mode", length));
			String[] comBkgNo = (JSPUtil.getParameter(request, prefix + "com_bkg_no", length));
			String[] subF = (JSPUtil.getParameter(request, prefix + "sub_f", length));
			String[] lane4 = (JSPUtil.getParameter(request, prefix + "lane4", length));
			String[] hitchment = (JSPUtil.getParameter(request, prefix + "hitchment", length));
			String[] lane2 = (JSPUtil.getParameter(request, prefix + "lane2", length));
			String[] lane3 = (JSPUtil.getParameter(request, prefix + "lane3", length));
			String[] lane1 = (JSPUtil.getParameter(request, prefix + "lane1", length));
			String[] dgF = (JSPUtil.getParameter(request, prefix + "dg_f", length));
			String[] rfF = (JSPUtil.getParameter(request, prefix + "rf_f", length));
			String[] noCost = (JSPUtil.getParameter(request, prefix + "no_cost", length));
			String[] cgoTp = (JSPUtil.getParameter(request, prefix + "cgo_tp", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix + "shpr", length));
			String[] pol1N = (JSPUtil.getParameter(request, prefix + "pol1_n", length));
			String[] obTrspMode = (JSPUtil.getParameter(request, prefix + "ob_trsp_mode", length));
			String[] obPrioSeq = (JSPUtil.getParameter(request, prefix + "ob_prio_seq", length));
			String[] ibTrspMode = (JSPUtil.getParameter(request, prefix + "ib_trsp_mode", length));
			String[] ibPrioSeq = (JSPUtil.getParameter(request, prefix + "ib_prio_seq", length));
			String[] bkgPctlNo = (JSPUtil.getParameter(request, prefix + "bkg_pctl_no", length));
			String[] internalSkdType = (JSPUtil.getParameter(request, prefix + "internal_skd_type", length));
			String[] mapSeq = (JSPUtil.getParameter(request, prefix + "map_seq", length));
			String[] mainPatternPctlNo = (JSPUtil.getParameter(request, prefix + "main_pattern_pctl_no", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix + "tro_seq", length));
			String[] troSubSeq = (JSPUtil.getParameter(request, prefix + "tro_sub_seq", length));

			String[] cTpsz = (JSPUtil.getParameter(request, prefix + "c_tpsz", length));
			String[] cQty = (JSPUtil.getParameter(request, prefix + "c_qty", length));
			String[] troPkupCy = (JSPUtil.getParameter(request, prefix + "tro_pkup_cy", length));
			String[] dorZone = (JSPUtil.getParameter(request, prefix + "dor_zone", length));
			String[] troRtnCy = (JSPUtil.getParameter(request, prefix + "tro_rtn_cy", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
			String[] haulage = (JSPUtil.getParameter(request, prefix + "haulage", length));
			String[] trMode = (JSPUtil.getParameter(request, prefix + "tr_mode", length));
			String[] mRt = (JSPUtil.getParameter(request, prefix + "m_rt", length));
			String[] replaneBndCd = (JSPUtil.getParameter(request, prefix + "replane_bnd_cd", length));
			String[] termNode = (JSPUtil.getParameter(request, prefix + "term_node", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix + "cop_no", length));
			String[] polPodSep = (JSPUtil.getParameter(request, prefix + "pol_pod_sep", length));
			String[] sumBkgQty = (JSPUtil.getParameter(request, prefix + "sum_bkg_qty", length));
			String[] dgClssCd = (JSPUtil.getParameter(request, prefix + "dg_clss_cd", length));
			String[] sumCTpSz = (JSPUtil.getParameter(request, prefix + "sum_c_tp_sz", length));
			String[] areaContiCd = (JSPUtil.getParameter(request, prefix + "area_conti_cd", length));
			String[] mtPkupDt = (JSPUtil.getParameter(request, prefix + "mt_pkup_dt", length));
			String[] bkgRcvT = (JSPUtil.getParameter(request, prefix + "bkg_rcv_t", length));
			String[] bkgDelT = (JSPUtil.getParameter(request, prefix + "bkg_del_t", length));

			String[] n1stPolDcSeq = (JSPUtil.getParameter(request, prefix + "n1st_pol_dc_seq", length));
			String[] n1stPodDcSeq = (JSPUtil.getParameter(request, prefix + "n1st_pod_dc_seq", length));
			String[] n2ndPolDcSeq = (JSPUtil.getParameter(request, prefix + "n2nd_pol_dc_seq", length));
			String[] n2ndPodDcSeq = (JSPUtil.getParameter(request, prefix + "n2nd_pod_dc_seq", length));
			String[] n3rdPolDcSeq = (JSPUtil.getParameter(request, prefix + "n3rd_pol_dc_seq", length));
			String[] n3rdPodDcSeq = (JSPUtil.getParameter(request, prefix + "n3rd_pod_dc_seq", length));
			String[] n4thPolDcSeq = (JSPUtil.getParameter(request, prefix + "n4th_pol_dc_seq", length));
			String[] n4thPodDcSeq = (JSPUtil.getParameter(request, prefix + "n4th_pod_dc_seq", length));

			String[] ocnSeq = (JSPUtil.getParameter(request, prefix + "ocn_seq", length));
			String[] flexHgtFlg = (JSPUtil.getParameter(request, prefix + "flex_hgt_flg", length));
			String[] cntrTpszQtyStr = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_qty_str", length));
			String[] cnstDelFlg = (JSPUtil.getParameter(request, prefix + "cnst_del_flg", length));
			String[] chkYd = (JSPUtil.getParameter(request, prefix + "chk_yd", length));
			String[] moreCnt = (JSPUtil.getParameter(request, prefix + "more_cnt", length));
			String[] ignoreHitch = (JSPUtil.getParameter(request, prefix + "ignore_hitch", length));

			for (int i = 0; i < length; i++) {
				model = new PrdCreateParamVO();
				if (com[i] != null)
					model.setCom(com[i]);
				if (ldDt[i] != null)
					model.setLdDt(ldDt[i]);
				if (fCmd[i] != null)
					model.setFCmd(fCmd[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (rcvT[i] != null)
					model.setRcvT(rcvT[i]);
				if (polN[i] != null)
					model.setPolN(polN[i]);
				if (pmF[i] != null)
					model.setPmF(pmF[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (wgt[i] != null)
					model.setWgt(wgt[i]);
				if (rfaOfc[i] != null)
					model.setRfaOfc(rfaOfc[i]);
				if (pod1N[i] != null)
					model.setPod1N(pod1N[i]);
				if (porN[i] != null)
					model.setPorN(porN[i]);
				if (podN[i] != null)
					model.setPodN(podN[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (pol4N[i] != null)
					model.setPol4N(pol4N[i]);
				if (orgSalOfc[i] != null)
					model.setOrgSalOfc(orgSalOfc[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (wgtUn[i] != null)
					model.setWgtUn(wgtUn[i]);
				if (pol4[i] != null)
					model.setPol4(pol4[i]);
				if (bbF[i] != null)
					model.setBbF(bbF[i]);
				if (sc[i] != null)
					model.setSc(sc[i]);
				if (pol3[i] != null)
					model.setPol3(pol3[i]);
				if (scOfc[i] != null)
					model.setScOfc(scOfc[i]);
				if (pol2[i] != null)
					model.setPol2(pol2[i]);
				if (hgF[i] != null)
					model.setHgF(hgF[i]);
				if (pol1[i] != null)
					model.setPol1(pol1[i]);
				if (repCom[i] != null)
					model.setRepCom(repCom[i]);
				if (vvd2[i] != null)
					model.setVvd2(vvd2[i]);
				if (drDt[i] != null)
					model.setDrDt(drDt[i]);
				if (cngn[i] != null)
					model.setCngn(cngn[i]);
				if (vvd3[i] != null)
					model.setVvd3(vvd3[i]);
				if (akF[i] != null)
					model.setAkF(akF[i]);
				if (socF[i] != null)
					model.setSocF(socF[i]);
				if (vvd1[i] != null)
					model.setVvd1(vvd1[i]);
				if (pod2[i] != null)
					model.setPod2(pod2[i]);
				if (pol3N[i] != null)
					model.setPol3N(pol3N[i]);
				if (pod1[i] != null)
					model.setPod1(pod1[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (pod4[i] != null)
					model.setPod4(pod4[i]);
				if (pod3[i] != null)
					model.setPod3(pod3[i]);
				if (vvd4[i] != null)
					model.setVvd4(vvd4[i]);
				if (pod2N[i] != null)
					model.setPod2N(pod2N[i]);
				if (mPu[i] != null)
					model.setMPu(mPu[i]);
				if (rdF[i] != null)
					model.setRdF(rdF[i]);
				if (delN[i] != null)
					model.setDelN(delN[i]);
				if (pod4N[i] != null)
					model.setPod4N(pod4N[i]);
				if (rfa[i] != null)
					model.setRfa(rfa[i]);
				if (imdg[i] != null)
					model.setImdg(imdg[i]);
				if (delT[i] != null)
					model.setDelT(delT[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (copyCnt[i] != null)
					model.setCopyCnt(copyCnt[i]);
				if (bkgOfc[i] != null)
					model.setBkgOfc(bkgOfc[i]);
				if (fRt[i] != null)
					model.setFRt(fRt[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (pod3N[i] != null)
					model.setPod3N(pod3N[i]);
				if (pol2N[i] != null)
					model.setPol2N(pol2N[i]);
				if (pcMode[i] != null)
					model.setPcMode(pcMode[i]);
				if (comBkgNo[i] != null)
					model.setComBkgNo(comBkgNo[i]);
				if (subF[i] != null)
					model.setSubF(subF[i]);
				if (lane4[i] != null)
					model.setLane4(lane4[i]);
				if (hitchment[i] != null)
					model.setHitchment(hitchment[i]);
				if (lane2[i] != null)
					model.setLane2(lane2[i]);
				if (lane3[i] != null)
					model.setLane3(lane3[i]);
				if (lane1[i] != null)
					model.setLane1(lane1[i]);
				if (dgF[i] != null)
					model.setDgF(dgF[i]);
				if (rfF[i] != null)
					model.setRfF(rfF[i]);
				if (noCost[i] != null)
					model.setNoCost(noCost[i]);
				if (cgoTp[i] != null)
					model.setCgoTp(cgoTp[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				if (pol1N[i] != null)
					model.setPol1N(pol1N[i]);
				if (obTrspMode[i] != null)
					model.setObTrspMode(obTrspMode[i]);
				if (obPrioSeq[i] != null)
					model.setObPrioSeq(obPrioSeq[i]);
				if (ibTrspMode[i] != null)
					model.setIbTrspMode(ibTrspMode[i]);
				if (ibPrioSeq[i] != null)
					model.setIbPrioSeq(ibPrioSeq[i]);
				if (bkgPctlNo[i] != null)
					model.setBkgPctlNo(bkgPctlNo[i]);
				if (internalSkdType[i] != null)
					model.setInternalSkdType(internalSkdType[i]);
				if (mapSeq[i] != null)
					model.setMapSeq(mapSeq[i]);
				if (mainPatternPctlNo[i] != null)
					model.setMainPatternPctlNo(mainPatternPctlNo[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (troSubSeq[i] != null)
					model.setTroSubSeq(troSubSeq[i]);

				if (cTpsz[i] != null)
					model.setCTpsz(cTpsz[i]);
				if (cQty[i] != null)
					model.setCQty(cQty[i]);
				if (troPkupCy[i] != null)
					model.setTroPkupCy(troPkupCy[i]);
				if (dorZone[i] != null)
					model.setDorZone(dorZone[i]);
				if (troRtnCy[i] != null)
					model.setTroRtnCy(troRtnCy[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (haulage[i] != null)
					model.setHaulage(haulage[i]);
				if (trMode[i] != null)
					model.setTrMode(trMode[i]);

				if (mRt[i] != null)
					model.setMRt(mRt[i]);

				if (replaneBndCd[i] != null)
					model.setReplaneBndCd(replaneBndCd[i]);

				if (termNode[i] != null)
					model.setTermNode(termNode[i]);

				if (copNo[i] != null)
					model.setCopNo(copNo[i]);

				if (polPodSep[i] != null)
					model.setPolPodSep(polPodSep[i]);

				if (sumBkgQty[i] != null)
					model.setSumBkgQty(sumBkgQty[i]);

				if (dgClssCd[i] != null)
					model.setDgClssCd(dgClssCd[i]);

				if (sumCTpSz[i] != null)
					model.setSumCTpSz(sumCTpSz[i]);

				if (areaContiCd[i] != null)
					model.setAreaContiCd(areaContiCd[i]);

				if (mtPkupDt[i] != null)
					model.setMtPkupDt(mtPkupDt[i]);
				if (bkgRcvT[i] != null)
					model.setBkgRcvT(bkgRcvT[i]);

				if (bkgDelT[i] != null)
					model.setBkgDelT(bkgDelT[i]);
				// [CHM-201005548-01]:[SCEM / PRD] F.H. 湲곕뒫 ?곌퀎??媛쒕컻?붿껌 (蹂??異붽?)
				if (flexHgtFlg[i] != null)
					model.setFlexHgtFlg(flexHgtFlg[i]);

				if (cntrTpszQtyStr[i] != null)
					model.setCntrTpszQtyStr(cntrTpszQtyStr[i]);
				if (cntrTpszQtyStr[i] != null)
					model.setCnstDelFlg(cnstDelFlg[i]);

				if (n1stPolDcSeq[i] != null)
					model.setN1stPolDcSeq(n1stPolDcSeq[i]);
				if (n1stPodDcSeq[i] != null)
					model.setN1stPodDcSeq(n1stPodDcSeq[i]);
				if (n2ndPolDcSeq[i] != null)
					model.setN2ndPolDcSeq(n2ndPolDcSeq[i]);
				if (n2ndPodDcSeq[i] != null)
					model.setN2ndPodDcSeq(n2ndPodDcSeq[i]);
				if (n3rdPolDcSeq[i] != null)
					model.setN3rdPolDcSeq(n3rdPolDcSeq[i]);
				if (n3rdPodDcSeq[i] != null)
					model.setN3rdPodDcSeq(n3rdPodDcSeq[i]);
				if (n4thPolDcSeq[i] != null)
					model.setN4thPolDcSeq(n4thPolDcSeq[i]);
				if (n4thPodDcSeq[i] != null)
					model.setN4thPodDcSeq(n4thPodDcSeq[i]);

				if (ocnSeq[i] != null)
					model.setOcnSeq(ocnSeq[i]);
				if (chkYd[i] != null)
					model.setChkYd(chkYd[i]);
				if (moreCnt[i] != null)
					model.setMoreCnt(moreCnt[i]);
				if (ignoreHitch[i] != null)
					model.setIgnoreHitch(ignoreHitch[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPrdCreateParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return PrdCreateParamVO[]
	 */
	public PrdCreateParamVO[] getPrdCreateParamVOs() {
		PrdCreateParamVO[] vos = (PrdCreateParamVO[]) models.toArray(new PrdCreateParamVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try {
			for (int i = 0; i < field.length; i++) {
				String[] arr = null;
				arr = getField(field, i);
				if (arr != null) {
					for (int j = 0; j < arr.length; j++) {
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
	 * 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try {
			arr = (String[]) field[i].get(this);
		} catch (Exception ex) {
			arr = null;
		}
		return arr;
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.com = this.com.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldDt = this.ldDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmd = this.fCmd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvT = this.rcvT.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polN = this.polN.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pmF = this.pmF.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt = this.wgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaOfc = this.rfaOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod1N = this.pod1N.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porN = this.porN.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podN = this.podN.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol4N = this.pol4N.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSalOfc = this.orgSalOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUn = this.wgtUn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol4 = this.pol4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbF = this.bbF.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sc = this.sc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol3 = this.pol3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scOfc = this.scOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol2 = this.pol2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hgF = this.hgF.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol1 = this.pol1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCom = this.repCom.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2 = this.vvd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drDt = this.drDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngn = this.cngn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd3 = this.vvd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akF = this.akF.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socF = this.socF.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1 = this.vvd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod2 = this.pod2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol3N = this.pol3N.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod1 = this.pod1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod4 = this.pod4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod3 = this.pod3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd4 = this.vvd4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod2N = this.pod2N.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mPu = this.mPu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdF = this.rdF.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delN = this.delN.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod4N = this.pod4N.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfa = this.rfa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdg = this.imdg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delT = this.delT.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copyCnt = this.copyCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfc = this.bkgOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRt = this.fRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod3N = this.pod3N.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol2N = this.pol2N.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcMode = this.pcMode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comBkgNo = this.comBkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subF = this.subF.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane4 = this.lane4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hitchment = this.hitchment.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane2 = this.lane2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane3 = this.lane3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane1 = this.lane1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgF = this.dgF.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfF = this.rfF.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noCost = this.noCost.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTp = this.cgoTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol1N = this.pol1N.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obTrspMode = this.obTrspMode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obPrioSeq = this.obPrioSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibTrspMode = this.ibTrspMode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibPrioSeq = this.ibPrioSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPctlNo = this.bkgPctlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.internalSkdType = this.internalSkdType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapSeq = this.mapSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mainPatternPctlNo = this.mainPatternPctlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSubSeq = this.troSubSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.cTpsz = this.cTpsz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cQty = this.cQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troPkupCy = this.troPkupCy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorZone = this.dorZone.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troRtnCy = this.troRtnCy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.haulage = this.haulage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trMode = this.trMode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mRt = this.mRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.replaneBndCd = this.replaneBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termNode = this.termNode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPodSep = this.polPodSep.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumBkgQty = this.sumBkgQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgClssCd = this.dgClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumCTpSz = this.sumCTpSz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaContiCd = this.areaContiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtPkupDt = this.mtPkupDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvT = this.bkgRcvT.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelT = this.bkgDelT.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.n1stPolDcSeq = this.n1stPolDcSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPodDcSeq = this.n1stPodDcSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPolDcSeq = this.n2ndPolDcSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPodDcSeq = this.n2ndPodDcSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPolDcSeq = this.n3rdPolDcSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPodDcSeq = this.n3rdPodDcSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPolDcSeq = this.n4thPolDcSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPodDcSeq = this.n4thPodDcSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.ocnSeq = this.ocnSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flexHgtFlg = this.flexHgtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszQtyStr = this.cntrTpszQtyStr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnstDelFlg = this.cnstDelFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkYd = this.chkYd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.moreCnt = this.moreCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ignoreHitch = this.ignoreHitch.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
