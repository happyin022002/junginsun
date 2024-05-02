/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CalcTariffVO.java
 *@FileTitle : CalcTariffVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.08.02
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2009.11.20 김진일 
 * 1.0 Creation
=========================================================*/
/*
 * 2010.08.31 진마리아 CHM-201005695-01 Limit Time 및 Tier Object 로직 변경. estFlg 추가
 * 2012.08.02 진마리아 CHM-201219306-01 surcharge 반영(in/out)
 * 2014.06.27 이윤정 CHM-201429607 [PSO] New Object 생성 요청 (ESIscore)
 * 2014.06.27 이윤정 CHM-201429888 [PSO] New Object - Berthing Date
 * 2014.06.27 이윤정 CHM-201430610 [PSO] New OBject Creation (SCGT)
 */
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo;

import java.util.HashMap;

/**
 * @author Administrator
 * 
 */
public class CalcTariffVO {
	/**
	 * 
	 * Manually Input Object 의 맴버필드를 만들기 위한 SQL SELECT 'private String ' ||
	 * REPLACE ( REPLACE (REPLACE (obj_list_abbr_nm, '.', NULL), '/', NULL),
	 * ' ', NULL ) || ' = "" ;// ' || obj_list_no || ' ' || obj_list_nm FROM
	 * pso_obj_list WHERE pso_obj_list_tp_cd = 'M'
	 */
	private String arrDFT = "";// 2 Arrival Draft
	private String depDFT = "";// 3 Departure Draft
	private String arrNT = "";// 6 Arrival No. of Tug
	private String depNT = "";// 7 Departure No. of Tug
	private String arrTP = "";// 8 Arrival Tug Power
	private String depTP = "";// 9 Departure Tug Power
	private String arrTUH = "";// 10 Arrival Tug Used Hour
	private String depTUH = "";// 11 Departure Tug Used Hour
	private String boat = "";// 17 Boat
	private String depDFT1 = "";// 25 Departure Draft 1
	private String depDFT2 = "";// 26 Departure Draft 2
	private String iBVOL = "";// 32 Inbound Volume
	private String oBVOL = "";// 33 Outbound Volume
	private String slgVol = "";// 40 Sluge Volume
	private String barge = "";// 52 Barge
	private String buoy = "";// 57 Buoy
	private String depLH = "";// 60 Departure Line handing Hour
	private String depPOB = "";// 61 Departure POB
	private String holiday = "";// 75 Holiday
	private String iBVB = "";// 76 I/B Volume/Blocksize
	private String iN = "";// 77 IN
	private String inspection = "";// 78 Inspection
	private String night = "";// 86 Night
	private String oBVB = "";// 88 O/B Volume/Blocksize
	private String oUT = "";// 89 OUT
	private String sanit = "";// 97 Sanitation
	private String tUGRope = "";// 110 TUG Rope
	private String usdhrs = "" ;// 111 Used Hour
	private String newservice = ""; //119 New Service
	private String arrDFT1 = "";// 49 Arrival Draft 1
	private String arrLH = "";// 50 Arrival Line Handing Hour
	private String arrPOB = "";// 51 Arrival POB
	private String tier = "";// 115 Tier
	private String limitTm = "";// 116 Limit Time
	private String sDR = "";// 114 SDR
	private String vslCd = "";
	private String skdVoyNo;
	private String skdDirCd;
	private String vvd;
	private String ydChgNo;
	private String ydChgVerSeq;
	private String ydCd;
	private String lgsCostCd;
	private String currCd;
	private String ioFlag;
	private String calcType;
	private String base;
	private String surcharge;
	private String scnt;
	private String scntOne;
	private String cntrVslClssCapa;
	private String ddHolEtb;
	private String ddHolEtd;
	private String copilot;
	private String estFlg;
	private boolean budget;
	private String inBase;
	private String outBase;
	private String scgt;//163
	private String eSIScore;//167
	private String bowThurustPower;//168
	private String others = "";
	private String otherValue = "";
	private String baseTariffAmount = "";
	private String inSurcharge = "";
	private String outSurcharge = "";
	private String clptIndSeq = ""; //2016.04.26 Duble calling port Add
	private String clptSeq = ""; //2016.04.26 Duble calling port Add
	/**
	 * @return the inSurcharge
	 */
	public String getInSurcharge() {
		return inSurcharge;
	}

	/**
	 * @return the clptIndSeq
	 */
	public String getClptIndSeq() {
		return clptIndSeq;
	}

	/**
	 * @param clptIndSeq the clptIndSeq to set
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}

	/**
	 * @return the clptSeq
	 */
	public String getClptSeq() {
		return clptSeq;
	}

	/**
	 * @param clptSeq the clptSeq to set
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
	}

	/**
	 * @param inSurcharge the inSurcharge to set
	 */
	public void setInSurcharge(String inSurcharge) {
		this.inSurcharge = inSurcharge;
	}

	/**
	 * @return the outSurcharge
	 */
	public String getOutSurcharge() {
		return outSurcharge;
	}

	/**
	 * @param outSurcharge the outSurcharge to set
	 */
	public void setOutSurcharge(String outSurcharge) {
		this.outSurcharge = outSurcharge;
	}

	public String getBaseTariffAmount() {
		return baseTariffAmount;
	}

	public void setBaseTariffAmount(String baseTariffAmount) {
		this.baseTariffAmount = baseTariffAmount;
	}

	public boolean isBudget(){
		return budget;
	}
	
	public void setBudget(boolean budget){
		this.budget = budget;
	}

	public String getEstFlg() {
		return estFlg;
	}

	public void setEstFlg(String estFlg) {
		this.estFlg = estFlg;
	}

	public HashMap<String,String> hMap = new HashMap<String,String>();
	private String from = "INITIAL"; 
	
	public String getFrom() {
		return from;
	}

	public String getCntrVslClssCapa() {
		return cntrVslClssCapa;
	}

	public void setScntOne(String scntOne) {
		this.scntOne = scntOne;
	}

	public void setScnt(String scnt) {
		this.scnt = scnt;
	}

	public String getSurcharge() {
		return surcharge;
	}

	public void setSurcharge(String surcharge) {
		this.surcharge = surcharge;
	}

	public String getBase() {
		return base;
	}

	public String getCalcType() {
		return calcType;
	}

	public String getIoFlag() {
		return ioFlag;
	}

	public String getCurrCd() {
		return currCd;
	}

	public String getLgsCostCd() {
		return lgsCostCd;
	}

	public String getYdCd() {
		return ydCd;
	}

	public String getYdChgVerSeq() {
		return ydChgVerSeq;
	}

	public void setYdChgVerSeq(String ydChgVerSeq) {
		this.ydChgVerSeq = ydChgVerSeq;
	}

	public String getYdChgNo() {
		return ydChgNo;
	}

	public String getVvd() {
		return vvd;
	}

	public String getSkdDirCd() {
		return skdDirCd;
	}

	public String getSkdVoyNo() {
		return skdVoyNo;
	}

	public String getVslCd() {
		return vslCd;
	}

	public String getArrDFT() {
		return arrDFT;
	}

	public void setArrDFT(String arrDFT) {
		this.arrDFT = arrDFT;
	}

	public String getDepDFT() {
		return depDFT;
	}

	public void setDepDFT(String depDFT) {
		this.depDFT = depDFT;
	}

	public String getArrNT() {
		return arrNT;
	}

	public void setArrNT(String arrNT) {
		this.arrNT = arrNT;
	}

	public String getDepNT() {
		return depNT;
	}

	public void setDepNT(String depNT) {
		this.depNT = depNT;
	}

	public String getArrTP() {
		return arrTP;
	}

	public void setArrTP(String arrTP) {
		this.arrTP = arrTP;
	}

	public String getDepTP() {
		return depTP;
	}

	public void setDepTP(String depTP) {
		this.depTP = depTP;
	}

	public String getArrTUH() {
		return arrTUH;
	}

	public void setArrTUH(String arrTUH) {
		this.arrTUH = arrTUH;
	}

	public String getDepTUH() {
		return depTUH;
	}

	public void setDepTUH(String depTUH) {
		this.depTUH = depTUH;
	}

	public String getBoat() {
		return boat;
	}

	public void setBoat(String boat) {
		this.boat = boat;
	}

	public String getDepDFT1() {
		return depDFT1;
	}

	public void setDepDFT1(String depDFT1) {
		this.depDFT1 = depDFT1;
	}

	public String getDepDFT2() {
		return depDFT2;
	}

	public void setDepDFT2(String depDFT2) {
		this.depDFT2 = depDFT2;
	}

	public String getIBVOL() {
		return iBVOL;
	}

	public void setIBVOL(String ibvol) {
		iBVOL = ibvol;
	}

	public String getOBVOL() {
		return oBVOL;
	}

	public void setOBVOL(String obvol) {
		oBVOL = obvol;
	}

	public String getSlgVol() {
		return slgVol;
	}

	public void setSlgVol(String slgVol) {
		this.slgVol = slgVol;
	}

	public String getBarge() {
		return barge;
	}

	public void setBarge(String barge) {
		this.barge = barge;
	}

	public String getBuoy() {
		return buoy;
	}

	public void setBuoy(String buoy) {
		this.buoy = buoy;
	}

	public String getDepLH() {
		return depLH;
	}

	public void setDepLH(String depLH) {
		this.depLH = depLH;
	}

	public String getDepPOB() {
		return depPOB;
	}

	public void setDepPOB(String depPOB) {
		this.depPOB = depPOB;
	}

	public String getHoliday() {
		return holiday;
	}

	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}

	public String getIBVB() {
		return iBVB;
	}

	public void setIBVB(String ibvb) {
		iBVB = ibvb;
	}

	public String getIN() {
		return iN;
	}

	public void setIN(String in) {
		iN = in;
	}

	public String getInspection() {
		return inspection;
	}

	public void setInspection(String inspection) {
		this.inspection = inspection;
	}

	public String getNight() {
		return night;
	}

	public void setNight(String night) {
		this.night = night;
	}

	public String getOBVB() {
		return oBVB;
	}

	public void setOBVB(String obvb) {
		oBVB = obvb;
	}

	public String getOUT() {
		return oUT;
	}

	public void setOUT(String out) {
		oUT = out;
	}

	public String getSanit() {
		return sanit;
	}

	public void setSanit(String sanit) {
		this.sanit = sanit;
	}

	public String getTUGRope() {
		return tUGRope;
	}

	public void setTUGRope(String rope) {
		tUGRope = rope;
	}

	public String getNewservice() {
		return newservice;
	}

	public void setNewservice(String newservice) {
		this.newservice = newservice;
	}

	public String getArrDFT1() {
		return arrDFT1;
	}

	public void setArrDFT1(String arrDFT1) {
		this.arrDFT1 = arrDFT1;
	}

	public String getArrLH() {
		return arrLH;
	}

	public void setArrLH(String arrLH) {
		this.arrLH = arrLH;
	}

	public String getArrPOB() {
		return arrPOB;
	}

	public void setArrPOB(String arrPOB) {
		this.arrPOB = arrPOB;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public String getLimitTm() {
		return limitTm;
	}

	public void setLimitTm(String limitTm) {
		this.limitTm = limitTm;
	}

	public String getSDR() {
		return sDR;
	}

	public void setSDR(String sdr) {
		sDR = sdr;
	}

	public void setVslCd(String vslCd) {
		// TODO Auto-generated method stub
		this.vslCd  = vslCd;
	}

	public void setSkdVoyNo(String skdVoyNo) {
		// TODO Auto-generated method stub
		this.skdVoyNo = skdVoyNo;
	}

	public void setSkdDirCd(String skdDirCd) {
		// TODO Auto-generated method stub
		this.skdDirCd = skdDirCd;
	}

	public void setVvd(String vvd) {
		// TODO Auto-generated method stub
		this.vvd = vvd;
	}

	public void setYdChgNo(String ydChgNo) {
		// TODO Auto-generated method stub
		this.ydChgNo = ydChgNo;
	}

	public void setChgVerSeq(String ydChgVerSeq) {
		// TODO Auto-generated method stub
		this.ydChgVerSeq = ydChgVerSeq;
	}

	public void setYdCd(String ydCd) {
		// TODO Auto-generated method stub
		this.ydCd = ydCd;
	}

	public void setLgsCostCd(String lgsCostCd) {
		// TODO Auto-generated method stub
		this.lgsCostCd = lgsCostCd;
	}

	public void setCurrCd(String currCd) {
		// TODO Auto-generated method stub
		this.currCd = currCd;
	}

	public void setIoFlag(String ioFlag) {
		// TODO Auto-generated method stub
		this.ioFlag = ioFlag;
	}

	public void setCalcType(String calcType) {
		// TODO Auto-generated method stub
		this.calcType = calcType;
	}

	public void setBase(String base) {
		// TODO Auto-generated method stub
		this.base = base;
	}

	public String getScnt() {
		// TODO Auto-generated method stub
		return this.scnt;
	}

	public String getScntOne() {
		// TODO Auto-generated method stub
		return this.scntOne;
	}

	public String getDdHolEtb() {
		return ddHolEtb;
	}

	public void setDdHolEtb(String ddHolEtb) {
		this.ddHolEtb = ddHolEtb;
	}

	public String getDdHolEtd() {
		return ddHolEtd;
	}

	public void setDdHolEtd(String ddHolEtd) {
		this.ddHolEtd = ddHolEtd;
	}

	public String getCopilot() {
		return copilot;
	}

	public void setCopilot(String copilot) {
		this.copilot = copilot;
	}

	public void setCntrVslClssCapa(String cntrVslClssCapa) {
		this.cntrVslClssCapa = cntrVslClssCapa;
	}

	public void setFrom(String from) {
		this.from =  from;		
	}
	
	public String getUsdhrs() {
		return usdhrs;
	}

	public void setUsdhrs(String usdhrs) {
		this.usdhrs = usdhrs;
	}

	public String getInBase() {
		return inBase;
	}

	public void setInBase(String inBase) {
		this.inBase = inBase;
	}

	public String getOutBase() {
		return outBase;
	}

	public void setOutBase(String outBase) {
		this.outBase = outBase;
	}
	public String getScgt() {
		return scgt;
	}

	public void setScgt(String scgt) {
		this.scgt = scgt;
	}
	
	public String getESIScore() {
		return eSIScore;
	}

	public void setESIScore(String eSIScore) {
		this.eSIScore = eSIScore;
	}
	
	public String getBowThurustBHP() {
		return bowThurustPower;
	}

	public void setBowThurustBHP(String bowThurustPower) {
		this.bowThurustPower = bowThurustPower;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public String getOtherValue() {
		return otherValue;
	}

	public void setOtherValue(String otherValue) {
		this.otherValue = otherValue;
	}
	
}
