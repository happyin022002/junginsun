/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FcmDepRptVO.java
*@FileTitle : FcmDepRptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.11  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FcmDepRptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FcmDepRptVO> models = new ArrayList<FcmDepRptVO>();
	
	/* Column Info */
	private String splLowSulpFoilActWgt = null;
	/* Column Info */
	private String pltInDt = null;
	/* Column Info */
	private String seaBlrDoilCsmQty = null;
	/* Column Info */
	private String seaDnst = null;
	/* Column Info */
	private String seaDetRsnCd1 = null;
	/* Column Info */
	private String lstRfCntrObrdKntCtnt = null;
	/* Column Info */
	private String arrBlrLowSulpFoilCsmQty = null;
	/* Column Info */
	private String seaDetRsnCd3 = null;
	/* Column Info */
	private String bfrBrthAnkDrpDt = null;
	/* Column Info */
	private String nxtLowSulpDoilWgt = null;
	/* Column Info */
	private String seaDetRsnCd2 = null;
	/* Column Info */
	private String foSlgWgt = null;
	/* Column Info */
	private String nxtPortCd = null;
	/* Column Info */
	private String arrFoilWgt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blkCgoTpCd5 = null;
	/* Column Info */
	private String blkCgoTpCd3 = null;
	/* Column Info */
	private String nvgtMlDist = null;
	/* Column Info */
	private String blkCgoTpCd4 = null;
	/* Column Info */
	private String blkCgoTpCd1 = null;
	/* Column Info */
	private String depBlstWgt = null;
	/* Column Info */
	private String blkCgoTpCd2 = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String capNm = null;
	/* Column Info */
	private String seaGnrLowSulpFoilCsmQty = null;
	/* Column Info */
	private String depFoilWgt = null;
	/* Column Info */
	private String splLowSulpFoilBdrWgt = null;
	/* Column Info */
	private String lstDepDoilCtnt = null;
	/* Column Info */
	private String splFoilActWgt = null;
	/* Column Info */
	private String avgRpmPwr = null;
	/* Column Info */
	private String nxtDoilWgt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String lstPortRupDt = null;
	/* Column Info */
	private String pltOutDt = null;
	/* Column Info */
	private String arrGnrLowSulpFoilCsmQty = null;
	/* Column Info */
	private String depRpmUusdTo = null;
	/* Column Info */
	private String depFwddrHgt = null;
	/* Column Info */
	private String depGmHgt = null;
	/* Column Info */
	private String incnrSlgWgt = null;
	/* Column Info */
	private String depLat = null;
	/* Column Info */
	private String splFrshWtrActWgt = null;
	/* Column Info */
	private String portBlrDoilCsmQty = null;
	/* Column Info */
	private String depDplWgt = null;
	/* Column Info */
	private String foilPurfDchgItval = null;
	/* Column Info */
	private String splFoilSulpWgt = null;
	/* Column Info */
	private String blkDepCgoTtlWgt = null;
	/* Column Info */
	private String lstDepLowSulpFoilCtnt = null;
	/* Column Info */
	private String rmnSdgWgt = null;
	/* Column Info */
	private String bfrBrthAnkOffDt = null;
	/* Column Info */
	private String arrLon = null;
	/* Column Info */
	private String rmnAvgSpd = null;
	/* Column Info */
	private String blkLodDchgStsCd = null;
	/* Column Info */
	private String nxtLowSulpFoilWgt = null;
	/* Column Info */
	private String dplSlgWgt = null;
	/* Column Info */
	private String depCgoWgt = null;
	/* Column Info */
	private String mnvrInMlDist = null;
	/* Column Info */
	private String arrBlstWgt = null;
	/* Column Info */
	private String depDoilWgt = null;
	/* Column Info */
	private String arrMnLowSulpFoilCsmQty = null;
	/* Column Info */
	private String splLowSulpDoilActWgt = null;
	/* Column Info */
	private String lstDepFoilCtnt = null;
	/* Column Info */
	private String splLowSulpFoilSulpWgt = null;
	/* Column Info */
	private String arrLowSulpDoilWgt = null;
	/* Column Info */
	private String splDoilActWgt = null;
	/* Column Info */
	private String ttlSlgWgt = null;
	/* Column Info */
	private String arrEngMl = null;
	/* Column Info */
	private String rupDt = null;
	/* Column Info */
	private String sbEngDt = null;
	/* Column Info */
	private String portMnLowSulpFoilCsmQty = null;
	/* Column Info */
	private String cgoWrkEndDt = null;
	/* Column Info */
	private String arrAftdrHgt = null;
	/* Column Info */
	private String depLowSulpDoilWgt = null;
	/* Column Info */
	private String depAftdrHgt = null;
	/* Column Info */
	private String seaGnrLowSulpDoilCsmQty = null;
	/* Column Info */
	private String portMnFoilCsmQty = null;
	/* Column Info */
	private String arrSailHrs = null;
	/* Column Info */
	private String depLon = null;
	/* Column Info */
	private String nxtMidDrftHgt = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String rfCntrDchgKnt = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String rfCntrObrdKnt = null;
	/* Column Info */
	private String splLowSulpDoilSulpWgt = null;
	/* Column Info */
	private String depLowSulpFoilWgt = null;
	/* Column Info */
	private String depArrPltMgnHrs = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String seaBlrLowSulpDoilCsmQty = null;
	/* Column Info */
	private String splDoilBrgWgt1 = null;
	/* Column Info */
	private String aftUnbrthAnkOffDt = null;
	/* Column Info */
	private String lstDepPortCd = null;
	/* Column Info */
	private String nxtBlstWgt = null;
	/* Column Info */
	private String seaMnLowSulpFoilCsmQty = null;
	/* Column Info */
	private String depRpmMaxPwr = null;
	/* Column Info */
	private String rfCntrLodKnt = null;
	/* Column Info */
	private String splDoilBrgWgt2 = null;
	/* Column Info */
	private String cgoWrkStDt = null;
	/* Column Info */
	private String aftUnbrthAnkDrpDt = null;
	/* Column Info */
	private String portDetRsnHrs1 = null;
	/* Column Info */
	private String arrFrshWtrWgt = null;
	/* Column Info */
	private String nxtGmHgt = null;
	/* Column Info */
	private String seaGnrDoilCsmQty = null;
	/* Column Info */
	private String portDetRsnHrs2 = null;
	/* Column Info */
	private String portDetRsnHrs3 = null;
	/* Column Info */
	private String depRpmMinPwr = null;
	/* Column Info */
	private String arrDoilCsmQty = null;
	/* Column Info */
	private String mnvrOutMlDist = null;
	/* Column Info */
	private String mtyCntrObrdTeu = null;
	/* Column Info */
	private String splLowSulpDoilBdrWgt = null;
	/* Column Info */
	private String arrLowSulpDoilCsmQty = null;
	/* Column Info */
	private String portGnrLowSulpFoilCsmQty = null;
	/* Column Info */
	private String arrMidDrftHgt = null;
	/* Column Info */
	private String arrNvgtMl = null;
	/* Column Info */
	private String arrFwddrHgt = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String gmtTdHrs = null;
	/* Column Info */
	private String portBlrFoilCsmQty = null;
	/* Column Info */
	private String arrGnrFoilCsmQty = null;
	/* Column Info */
	private String depRmk = null;
	/* Column Info */
	private String portMnLowSulpDoilCsmQty = null;
	/* Column Info */
	private String rmnDist = null;
	/* Column Info */
	private String arrRpmPwr = null;
	/* Column Info */
	private String seaGnrFoilCsmQty = null;
	/* Column Info */
	private String engMlDist = null;
	/* Column Info */
	private String cntrDznCapa = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String splFoilBrgWgt2 = null;
	/* Column Info */
	private String portMnDoilCsmQty = null;
	/* Column Info */
	private String splFoilBrgWgt1 = null;
	/* Column Info */
	private String cfEngNm = null;
	/* Column Info */
	private String blkHldLoadQty6 = null;
	/* Column Info */
	private String nxtPortEtaDt = null;
	/* Column Info */
	private String blkHldLoadQty5 = null;
	/* Column Info */
	private String blkHldLoadQty8 = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String blkHldLoadQty7 = null;
	/* Column Info */
	private String blkHldLoadQty2 = null;
	/* Column Info */
	private String blkHldLoadQty1 = null;
	/* Column Info */
	private String blkHldLoadQty4 = null;
	/* Column Info */
	private String blkHldLoadQty3 = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String portBlrLowSulpFoilCsmQty = null;
	/* Column Info */
	private String portGnrDoilCsmQty = null;
	/* Column Info */
	private String arrLowSulpFoilWgt = null;
	/* Column Info */
	private String depFrshWtrWgt = null;
	/* Column Info */
	private String splLowSulpDoilBrgWgt1 = null;
	/* Column Info */
	private String depStsCd = null;
	/* Column Info */
	private String splLowSulpDoilBrgWgt2 = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String blkHldLoadQty9 = null;
	/* Column Info */
	private String splLowSulpFoilBrgWgt2 = null;
	/* Column Info */
	private String splLowSulpFoilBrgWgt1 = null;
	/* Column Info */
	private String seaBlrFoilCsmQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lstDepLowSulpDoilCtnt = null;
	/* Column Info */
	private String splDoilSulpWgt = null;
	/* Column Info */
	private String arrDoilWgt = null;
	/* Column Info */
	private String runHrsInHvWe = null;
	/* Column Info */
	private String portDetRsnCd3 = null;
	/* Column Info */
	private String portDetRsnCd2 = null;
	/* Column Info */
	private String portDetRsnCd1 = null;
	/* Column Info */
	private String seaMnFoilCsmQty = null;
	/* Column Info */
	private String depRpmUusdFm = null;
	/* Column Info */
	private String arrBlrFoilCsmQty = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String depRsnForMgnTm = null;
	/* Column Info */
	private String splDoilBdrWgt = null;
	/* Column Info */
	private String nxtAftdrHgt = null;
	/* Column Info */
	private String nxtFoilWgt = null;
	/* Column Info */
	private String ttlCntrObrdTeu = null;
	/* Column Info */
	private String nxtFwddrHgt = null;
	/* Column Info */
	private String arrLat = null;
	/* Column Info */
	private String depPortCd = null;
	/* Column Info */
	private String fullCntrObrdTeu = null;
	/* Column Info */
	private String arrGmHgt = null;
	/* Column Info */
	private String portGnrLowSulpDoilCsmQty = null;
	/* Column Info */
	private String portGnrFoilCsmQty = null;
	/* Column Info */
	private String seaMnDoilCsmQty = null;
	/* Column Info */
	private String dplSlgSp = null;
	/* Column Info */
	private String splFoilBdrWgt = null;
	/* Column Info */
	private String portBlrLowSulpDoilCsmQty = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String seaBlrLowSulpFoilCsmQty = null;
	/* Column Info */
	private String seaMnLowSulpDoilCsmQty = null;
	/* Column Info */
	private String depMidDrftHgt = null;
	/* Column Info */
	private String arrMnFoilCsmQty = null;
	/* Column Info */
	private String nxtFrshWtrWgt = null;
	/* Column Info */
	private String avgSpd = null;
	/* Column Info */
	private String depArrPltMgnMnts = null;
	/* Column Info */
	private String seaDetRsnHrs3 = null;
	/* Column Info */
	private String depRpmPwr = null;
	/* Column Info */
	private String seaDetRsnHrs2 = null;
	/* Column Info */
	private String seaDetRsnHrs1 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public FcmDepRptVO() {}

	public FcmDepRptVO(String ibflag, String pagerows, String cntrDznCapa, String lstDepFoilCtnt, String lstDepLowSulpFoilCtnt, String lstDepDoilCtnt, String lstDepLowSulpDoilCtnt, String lstDepPortCd, String lstRfCntrObrdKntCtnt, String lstPortRupDt, String vslCd, String skdVoyNo, String skdDirCd, String vslSlanCd, String depPortCd, String clptIndSeq, String refNo, String gmtTdHrs, String nxtPortCd, String depStsCd, String rmnDist, String rmnAvgSpd, String nxtPortEtaDt, String sbEngDt, String pltInDt, String bfrBrthAnkDrpDt, String bfrBrthAnkOffDt, String vpsEtbDt, String cgoWrkStDt, String cgoWrkEndDt, String vpsEtdDt, String aftUnbrthAnkDrpDt, String aftUnbrthAnkOffDt, String pltOutDt, String rupDt, String mnvrInMlDist, String mnvrOutMlDist, String nvgtMlDist, String engMlDist, String avgSpd, String avgRpmPwr, String runHrsInHvWe, String seaDetRsnCd1, String seaDetRsnHrs1, String seaDetRsnCd2, String seaDetRsnHrs2, String seaDetRsnCd3, String seaDetRsnHrs3, String portDetRsnCd1, String portDetRsnHrs1, String portDetRsnCd2, String portDetRsnHrs2, String portDetRsnCd3, String portDetRsnHrs3, String arrFwddrHgt, String arrMidDrftHgt, String arrAftdrHgt, String arrGmHgt, String arrFoilWgt, String arrDoilWgt, String arrFrshWtrWgt, String arrBlstWgt, String arrLowSulpFoilWgt, String arrLowSulpDoilWgt, String depFwddrHgt, String depMidDrftHgt, String depAftdrHgt, String depGmHgt, String depFoilWgt, String depDoilWgt, String depFrshWtrWgt, String depBlstWgt, String depLowSulpFoilWgt, String depLowSulpDoilWgt, String nxtFwddrHgt, String nxtMidDrftHgt, String nxtAftdrHgt, String nxtGmHgt, String nxtFoilWgt, String nxtDoilWgt, String nxtFrshWtrWgt, String nxtBlstWgt, String nxtLowSulpFoilWgt, String nxtLowSulpDoilWgt, String seaMnFoilCsmQty, String seaGnrFoilCsmQty, String seaBlrFoilCsmQty, String seaMnDoilCsmQty, String seaGnrDoilCsmQty, String seaBlrDoilCsmQty, String seaMnLowSulpFoilCsmQty, String seaGnrLowSulpFoilCsmQty, String seaBlrLowSulpFoilCsmQty, String seaMnLowSulpDoilCsmQty, String seaGnrLowSulpDoilCsmQty, String seaBlrLowSulpDoilCsmQty, String portMnFoilCsmQty, String portGnrFoilCsmQty, String portBlrFoilCsmQty, String portMnDoilCsmQty, String portGnrDoilCsmQty, String portBlrDoilCsmQty, String portMnLowSulpFoilCsmQty, String portGnrLowSulpFoilCsmQty, String portBlrLowSulpFoilCsmQty, String portMnLowSulpDoilCsmQty, String portGnrLowSulpDoilCsmQty, String portBlrLowSulpDoilCsmQty, String splFoilBdrWgt, String splFoilActWgt, String splFoilSulpWgt, String splFoilBrgWgt1, String splFoilBrgWgt2, String splDoilBdrWgt, String splDoilActWgt, String splDoilSulpWgt, String splDoilBrgWgt1, String splDoilBrgWgt2, String splFrshWtrActWgt, String splLowSulpFoilBdrWgt, String splLowSulpFoilActWgt, String splLowSulpFoilSulpWgt, String splLowSulpFoilBrgWgt1, String splLowSulpFoilBrgWgt2, String splLowSulpDoilBdrWgt, String splLowSulpDoilActWgt, String splLowSulpDoilSulpWgt, String splLowSulpDoilBrgWgt1, String splLowSulpDoilBrgWgt2, String seaDnst, String fullCntrObrdTeu, String mtyCntrObrdTeu, String ttlCntrObrdTeu, String rfCntrDchgKnt, String rfCntrLodKnt, String rfCntrObrdKnt, String depCgoWgt, String depDplWgt, String blkLodDchgStsCd, String blkCgoTpCd1, String blkCgoTpCd2, String blkCgoTpCd3, String blkCgoTpCd4, String blkCgoTpCd5, String blkHldLoadQty1, String blkHldLoadQty2, String blkHldLoadQty3, String blkHldLoadQty4, String blkHldLoadQty5, String blkHldLoadQty6, String blkHldLoadQty7, String blkHldLoadQty8, String blkHldLoadQty9, String blkDepCgoTtlWgt, String ttlSlgWgt, String foSlgWgt, String incnrSlgWgt, String dplSlgWgt, String dplSlgSp, String rmnSdgWgt, String foilPurfDchgItval, String depRmk, String arrLat, String arrLon, String arrSailHrs, String arrNvgtMl, String arrEngMl, String arrRpmPwr, String arrMnFoilCsmQty, String arrMnLowSulpFoilCsmQty, String arrGnrFoilCsmQty, String arrGnrLowSulpFoilCsmQty, String arrBlrFoilCsmQty, String arrBlrLowSulpFoilCsmQty, String arrDoilCsmQty, String arrLowSulpDoilCsmQty, String depLat, String depLon, String depRpmPwr, String depRpmMaxPwr, String depRpmMinPwr, String depRpmUusdFm, String depRpmUusdTo, String depArrPltMgnHrs, String depArrPltMgnMnts, String depRsnForMgnTm, String capNm, String cfEngNm, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.splLowSulpFoilActWgt = splLowSulpFoilActWgt;
		this.pltInDt = pltInDt;
		this.seaBlrDoilCsmQty = seaBlrDoilCsmQty;
		this.seaDnst = seaDnst;
		this.seaDetRsnCd1 = seaDetRsnCd1;
		this.lstRfCntrObrdKntCtnt = lstRfCntrObrdKntCtnt;
		this.arrBlrLowSulpFoilCsmQty = arrBlrLowSulpFoilCsmQty;
		this.seaDetRsnCd3 = seaDetRsnCd3;
		this.bfrBrthAnkDrpDt = bfrBrthAnkDrpDt;
		this.nxtLowSulpDoilWgt = nxtLowSulpDoilWgt;
		this.seaDetRsnCd2 = seaDetRsnCd2;
		this.foSlgWgt = foSlgWgt;
		this.nxtPortCd = nxtPortCd;
		this.arrFoilWgt = arrFoilWgt;
		this.pagerows = pagerows;
		this.blkCgoTpCd5 = blkCgoTpCd5;
		this.blkCgoTpCd3 = blkCgoTpCd3;
		this.nvgtMlDist = nvgtMlDist;
		this.blkCgoTpCd4 = blkCgoTpCd4;
		this.blkCgoTpCd1 = blkCgoTpCd1;
		this.depBlstWgt = depBlstWgt;
		this.blkCgoTpCd2 = blkCgoTpCd2;
		this.updUsrId = updUsrId;
		this.capNm = capNm;
		this.seaGnrLowSulpFoilCsmQty = seaGnrLowSulpFoilCsmQty;
		this.depFoilWgt = depFoilWgt;
		this.splLowSulpFoilBdrWgt = splLowSulpFoilBdrWgt;
		this.lstDepDoilCtnt = lstDepDoilCtnt;
		this.splFoilActWgt = splFoilActWgt;
		this.avgRpmPwr = avgRpmPwr;
		this.nxtDoilWgt = nxtDoilWgt;
		this.skdVoyNo = skdVoyNo;
		this.lstPortRupDt = lstPortRupDt;
		this.pltOutDt = pltOutDt;
		this.arrGnrLowSulpFoilCsmQty = arrGnrLowSulpFoilCsmQty;
		this.depRpmUusdTo = depRpmUusdTo;
		this.depFwddrHgt = depFwddrHgt;
		this.depGmHgt = depGmHgt;
		this.incnrSlgWgt = incnrSlgWgt;
		this.depLat = depLat;
		this.splFrshWtrActWgt = splFrshWtrActWgt;
		this.portBlrDoilCsmQty = portBlrDoilCsmQty;
		this.depDplWgt = depDplWgt;
		this.foilPurfDchgItval = foilPurfDchgItval;
		this.splFoilSulpWgt = splFoilSulpWgt;
		this.blkDepCgoTtlWgt = blkDepCgoTtlWgt;
		this.lstDepLowSulpFoilCtnt = lstDepLowSulpFoilCtnt;
		this.rmnSdgWgt = rmnSdgWgt;
		this.bfrBrthAnkOffDt = bfrBrthAnkOffDt;
		this.arrLon = arrLon;
		this.rmnAvgSpd = rmnAvgSpd;
		this.blkLodDchgStsCd = blkLodDchgStsCd;
		this.nxtLowSulpFoilWgt = nxtLowSulpFoilWgt;
		this.dplSlgWgt = dplSlgWgt;
		this.depCgoWgt = depCgoWgt;
		this.mnvrInMlDist = mnvrInMlDist;
		this.arrBlstWgt = arrBlstWgt;
		this.depDoilWgt = depDoilWgt;
		this.arrMnLowSulpFoilCsmQty = arrMnLowSulpFoilCsmQty;
		this.splLowSulpDoilActWgt = splLowSulpDoilActWgt;
		this.lstDepFoilCtnt = lstDepFoilCtnt;
		this.splLowSulpFoilSulpWgt = splLowSulpFoilSulpWgt;
		this.arrLowSulpDoilWgt = arrLowSulpDoilWgt;
		this.splDoilActWgt = splDoilActWgt;
		this.ttlSlgWgt = ttlSlgWgt;
		this.arrEngMl = arrEngMl;
		this.rupDt = rupDt;
		this.sbEngDt = sbEngDt;
		this.portMnLowSulpFoilCsmQty = portMnLowSulpFoilCsmQty;
		this.cgoWrkEndDt = cgoWrkEndDt;
		this.arrAftdrHgt = arrAftdrHgt;
		this.depLowSulpDoilWgt = depLowSulpDoilWgt;
		this.depAftdrHgt = depAftdrHgt;
		this.seaGnrLowSulpDoilCsmQty = seaGnrLowSulpDoilCsmQty;
		this.portMnFoilCsmQty = portMnFoilCsmQty;
		this.arrSailHrs = arrSailHrs;
		this.depLon = depLon;
		this.nxtMidDrftHgt = nxtMidDrftHgt;
		this.clptIndSeq = clptIndSeq;
		this.rfCntrDchgKnt = rfCntrDchgKnt;
		this.refNo = refNo;
		this.rfCntrObrdKnt = rfCntrObrdKnt;
		this.splLowSulpDoilSulpWgt = splLowSulpDoilSulpWgt;
		this.depLowSulpFoilWgt = depLowSulpFoilWgt;
		this.depArrPltMgnHrs = depArrPltMgnHrs;
		this.vslCd = vslCd;
		this.seaBlrLowSulpDoilCsmQty = seaBlrLowSulpDoilCsmQty;
		this.splDoilBrgWgt1 = splDoilBrgWgt1;
		this.aftUnbrthAnkOffDt = aftUnbrthAnkOffDt;
		this.lstDepPortCd = lstDepPortCd;
		this.nxtBlstWgt = nxtBlstWgt;
		this.seaMnLowSulpFoilCsmQty = seaMnLowSulpFoilCsmQty;
		this.depRpmMaxPwr = depRpmMaxPwr;
		this.rfCntrLodKnt = rfCntrLodKnt;
		this.splDoilBrgWgt2 = splDoilBrgWgt2;
		this.cgoWrkStDt = cgoWrkStDt;
		this.aftUnbrthAnkDrpDt = aftUnbrthAnkDrpDt;
		this.portDetRsnHrs1 = portDetRsnHrs1;
		this.arrFrshWtrWgt = arrFrshWtrWgt;
		this.nxtGmHgt = nxtGmHgt;
		this.seaGnrDoilCsmQty = seaGnrDoilCsmQty;
		this.portDetRsnHrs2 = portDetRsnHrs2;
		this.portDetRsnHrs3 = portDetRsnHrs3;
		this.depRpmMinPwr = depRpmMinPwr;
		this.arrDoilCsmQty = arrDoilCsmQty;
		this.mnvrOutMlDist = mnvrOutMlDist;
		this.mtyCntrObrdTeu = mtyCntrObrdTeu;
		this.splLowSulpDoilBdrWgt = splLowSulpDoilBdrWgt;
		this.arrLowSulpDoilCsmQty = arrLowSulpDoilCsmQty;
		this.portGnrLowSulpFoilCsmQty = portGnrLowSulpFoilCsmQty;
		this.arrMidDrftHgt = arrMidDrftHgt;
		this.arrNvgtMl = arrNvgtMl;
		this.arrFwddrHgt = arrFwddrHgt;
		this.vpsEtdDt = vpsEtdDt;
		this.gmtTdHrs = gmtTdHrs;
		this.portBlrFoilCsmQty = portBlrFoilCsmQty;
		this.arrGnrFoilCsmQty = arrGnrFoilCsmQty;
		this.depRmk = depRmk;
		this.portMnLowSulpDoilCsmQty = portMnLowSulpDoilCsmQty;
		this.rmnDist = rmnDist;
		this.arrRpmPwr = arrRpmPwr;
		this.seaGnrFoilCsmQty = seaGnrFoilCsmQty;
		this.engMlDist = engMlDist;
		this.cntrDznCapa = cntrDznCapa;
		this.creUsrId = creUsrId;
		this.splFoilBrgWgt2 = splFoilBrgWgt2;
		this.portMnDoilCsmQty = portMnDoilCsmQty;
		this.splFoilBrgWgt1 = splFoilBrgWgt1;
		this.cfEngNm = cfEngNm;
		this.blkHldLoadQty6 = blkHldLoadQty6;
		this.nxtPortEtaDt = nxtPortEtaDt;
		this.blkHldLoadQty5 = blkHldLoadQty5;
		this.blkHldLoadQty8 = blkHldLoadQty8;
		this.vpsEtbDt = vpsEtbDt;
		this.blkHldLoadQty7 = blkHldLoadQty7;
		this.blkHldLoadQty2 = blkHldLoadQty2;
		this.blkHldLoadQty1 = blkHldLoadQty1;
		this.blkHldLoadQty4 = blkHldLoadQty4;
		this.blkHldLoadQty3 = blkHldLoadQty3;
		this.creDt = creDt;
		this.portBlrLowSulpFoilCsmQty = portBlrLowSulpFoilCsmQty;
		this.portGnrDoilCsmQty = portGnrDoilCsmQty;
		this.arrLowSulpFoilWgt = arrLowSulpFoilWgt;
		this.depFrshWtrWgt = depFrshWtrWgt;
		this.splLowSulpDoilBrgWgt1 = splLowSulpDoilBrgWgt1;
		this.depStsCd = depStsCd;
		this.splLowSulpDoilBrgWgt2 = splLowSulpDoilBrgWgt2;
		this.vslSlanCd = vslSlanCd;
		this.blkHldLoadQty9 = blkHldLoadQty9;
		this.splLowSulpFoilBrgWgt2 = splLowSulpFoilBrgWgt2;
		this.splLowSulpFoilBrgWgt1 = splLowSulpFoilBrgWgt1;
		this.seaBlrFoilCsmQty = seaBlrFoilCsmQty;
		this.ibflag = ibflag;
		this.lstDepLowSulpDoilCtnt = lstDepLowSulpDoilCtnt;
		this.splDoilSulpWgt = splDoilSulpWgt;
		this.arrDoilWgt = arrDoilWgt;
		this.runHrsInHvWe = runHrsInHvWe;
		this.portDetRsnCd3 = portDetRsnCd3;
		this.portDetRsnCd2 = portDetRsnCd2;
		this.portDetRsnCd1 = portDetRsnCd1;
		this.seaMnFoilCsmQty = seaMnFoilCsmQty;
		this.depRpmUusdFm = depRpmUusdFm;
		this.arrBlrFoilCsmQty = arrBlrFoilCsmQty;
		this.updDt = updDt;
		this.depRsnForMgnTm = depRsnForMgnTm;
		this.splDoilBdrWgt = splDoilBdrWgt;
		this.nxtAftdrHgt = nxtAftdrHgt;
		this.nxtFoilWgt = nxtFoilWgt;
		this.ttlCntrObrdTeu = ttlCntrObrdTeu;
		this.nxtFwddrHgt = nxtFwddrHgt;
		this.arrLat = arrLat;
		this.depPortCd = depPortCd;
		this.fullCntrObrdTeu = fullCntrObrdTeu;
		this.arrGmHgt = arrGmHgt;
		this.portGnrLowSulpDoilCsmQty = portGnrLowSulpDoilCsmQty;
		this.portGnrFoilCsmQty = portGnrFoilCsmQty;
		this.seaMnDoilCsmQty = seaMnDoilCsmQty;
		this.dplSlgSp = dplSlgSp;
		this.splFoilBdrWgt = splFoilBdrWgt;
		this.portBlrLowSulpDoilCsmQty = portBlrLowSulpDoilCsmQty;
		this.skdDirCd = skdDirCd;
		this.seaBlrLowSulpFoilCsmQty = seaBlrLowSulpFoilCsmQty;
		this.seaMnLowSulpDoilCsmQty = seaMnLowSulpDoilCsmQty;
		this.depMidDrftHgt = depMidDrftHgt;
		this.arrMnFoilCsmQty = arrMnFoilCsmQty;
		this.nxtFrshWtrWgt = nxtFrshWtrWgt;
		this.avgSpd = avgSpd;
		this.depArrPltMgnMnts = depArrPltMgnMnts;
		this.seaDetRsnHrs3 = seaDetRsnHrs3;
		this.depRpmPwr = depRpmPwr;
		this.seaDetRsnHrs2 = seaDetRsnHrs2;
		this.seaDetRsnHrs1 = seaDetRsnHrs1;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("spl_low_sulp_foil_act_wgt", getSplLowSulpFoilActWgt());
		this.hashColumns.put("plt_in_dt", getPltInDt());
		this.hashColumns.put("sea_blr_doil_csm_qty", getSeaBlrDoilCsmQty());
		this.hashColumns.put("sea_dnst", getSeaDnst());
		this.hashColumns.put("sea_det_rsn_cd1", getSeaDetRsnCd1());
		this.hashColumns.put("lst_rf_cntr_obrd_knt_ctnt", getLstRfCntrObrdKntCtnt());
		this.hashColumns.put("arr_blr_low_sulp_foil_csm_qty", getArrBlrLowSulpFoilCsmQty());
		this.hashColumns.put("sea_det_rsn_cd3", getSeaDetRsnCd3());
		this.hashColumns.put("bfr_brth_ank_drp_dt", getBfrBrthAnkDrpDt());
		this.hashColumns.put("nxt_low_sulp_doil_wgt", getNxtLowSulpDoilWgt());
		this.hashColumns.put("sea_det_rsn_cd2", getSeaDetRsnCd2());
		this.hashColumns.put("fo_slg_wgt", getFoSlgWgt());
		this.hashColumns.put("nxt_port_cd", getNxtPortCd());
		this.hashColumns.put("arr_foil_wgt", getArrFoilWgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("blk_cgo_tp_cd5", getBlkCgoTpCd5());
		this.hashColumns.put("blk_cgo_tp_cd3", getBlkCgoTpCd3());
		this.hashColumns.put("nvgt_ml_dist", getNvgtMlDist());
		this.hashColumns.put("blk_cgo_tp_cd4", getBlkCgoTpCd4());
		this.hashColumns.put("blk_cgo_tp_cd1", getBlkCgoTpCd1());
		this.hashColumns.put("dep_blst_wgt", getDepBlstWgt());
		this.hashColumns.put("blk_cgo_tp_cd2", getBlkCgoTpCd2());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cap_nm", getCapNm());
		this.hashColumns.put("sea_gnr_low_sulp_foil_csm_qty", getSeaGnrLowSulpFoilCsmQty());
		this.hashColumns.put("dep_foil_wgt", getDepFoilWgt());
		this.hashColumns.put("spl_low_sulp_foil_bdr_wgt", getSplLowSulpFoilBdrWgt());
		this.hashColumns.put("lst_dep_doil_ctnt", getLstDepDoilCtnt());
		this.hashColumns.put("spl_foil_act_wgt", getSplFoilActWgt());
		this.hashColumns.put("avg_rpm_pwr", getAvgRpmPwr());
		this.hashColumns.put("nxt_doil_wgt", getNxtDoilWgt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("lst_port_rup_dt", getLstPortRupDt());
		this.hashColumns.put("plt_out_dt", getPltOutDt());
		this.hashColumns.put("arr_gnr_low_sulp_foil_csm_qty", getArrGnrLowSulpFoilCsmQty());
		this.hashColumns.put("dep_rpm_uusd_to", getDepRpmUusdTo());
		this.hashColumns.put("dep_fwddr_hgt", getDepFwddrHgt());
		this.hashColumns.put("dep_gm_hgt", getDepGmHgt());
		this.hashColumns.put("incnr_slg_wgt", getIncnrSlgWgt());
		this.hashColumns.put("dep_lat", getDepLat());
		this.hashColumns.put("spl_frsh_wtr_act_wgt", getSplFrshWtrActWgt());
		this.hashColumns.put("port_blr_doil_csm_qty", getPortBlrDoilCsmQty());
		this.hashColumns.put("dep_dpl_wgt", getDepDplWgt());
		this.hashColumns.put("foil_purf_dchg_itval", getFoilPurfDchgItval());
		this.hashColumns.put("spl_foil_sulp_wgt", getSplFoilSulpWgt());
		this.hashColumns.put("blk_dep_cgo_ttl_wgt", getBlkDepCgoTtlWgt());
		this.hashColumns.put("lst_dep_low_sulp_foil_ctnt", getLstDepLowSulpFoilCtnt());
		this.hashColumns.put("rmn_sdg_wgt", getRmnSdgWgt());
		this.hashColumns.put("bfr_brth_ank_off_dt", getBfrBrthAnkOffDt());
		this.hashColumns.put("arr_lon", getArrLon());
		this.hashColumns.put("rmn_avg_spd", getRmnAvgSpd());
		this.hashColumns.put("blk_lod_dchg_sts_cd", getBlkLodDchgStsCd());
		this.hashColumns.put("nxt_low_sulp_foil_wgt", getNxtLowSulpFoilWgt());
		this.hashColumns.put("dpl_slg_wgt", getDplSlgWgt());
		this.hashColumns.put("dep_cgo_wgt", getDepCgoWgt());
		this.hashColumns.put("mnvr_in_ml_dist", getMnvrInMlDist());
		this.hashColumns.put("arr_blst_wgt", getArrBlstWgt());
		this.hashColumns.put("dep_doil_wgt", getDepDoilWgt());
		this.hashColumns.put("arr_mn_low_sulp_foil_csm_qty", getArrMnLowSulpFoilCsmQty());
		this.hashColumns.put("spl_low_sulp_doil_act_wgt", getSplLowSulpDoilActWgt());
		this.hashColumns.put("lst_dep_foil_ctnt", getLstDepFoilCtnt());
		this.hashColumns.put("spl_low_sulp_foil_sulp_wgt", getSplLowSulpFoilSulpWgt());
		this.hashColumns.put("arr_low_sulp_doil_wgt", getArrLowSulpDoilWgt());
		this.hashColumns.put("spl_doil_act_wgt", getSplDoilActWgt());
		this.hashColumns.put("ttl_slg_wgt", getTtlSlgWgt());
		this.hashColumns.put("arr_eng_ml", getArrEngMl());
		this.hashColumns.put("rup_dt", getRupDt());
		this.hashColumns.put("sb_eng_dt", getSbEngDt());
		this.hashColumns.put("port_mn_low_sulp_foil_csm_qty", getPortMnLowSulpFoilCsmQty());
		this.hashColumns.put("cgo_wrk_end_dt", getCgoWrkEndDt());
		this.hashColumns.put("arr_aftdr_hgt", getArrAftdrHgt());
		this.hashColumns.put("dep_low_sulp_doil_wgt", getDepLowSulpDoilWgt());
		this.hashColumns.put("dep_aftdr_hgt", getDepAftdrHgt());
		this.hashColumns.put("sea_gnr_low_sulp_doil_csm_qty", getSeaGnrLowSulpDoilCsmQty());
		this.hashColumns.put("port_mn_foil_csm_qty", getPortMnFoilCsmQty());
		this.hashColumns.put("arr_sail_hrs", getArrSailHrs());
		this.hashColumns.put("dep_lon", getDepLon());
		this.hashColumns.put("nxt_mid_drft_hgt", getNxtMidDrftHgt());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("rf_cntr_dchg_knt", getRfCntrDchgKnt());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("rf_cntr_obrd_knt", getRfCntrObrdKnt());
		this.hashColumns.put("spl_low_sulp_doil_sulp_wgt", getSplLowSulpDoilSulpWgt());
		this.hashColumns.put("dep_low_sulp_foil_wgt", getDepLowSulpFoilWgt());
		this.hashColumns.put("dep_arr_plt_mgn_hrs", getDepArrPltMgnHrs());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("sea_blr_low_sulp_doil_csm_qty", getSeaBlrLowSulpDoilCsmQty());
		this.hashColumns.put("spl_doil_brg_wgt1", getSplDoilBrgWgt1());
		this.hashColumns.put("aft_unbrth_ank_off_dt", getAftUnbrthAnkOffDt());
		this.hashColumns.put("lst_dep_port_cd", getLstDepPortCd());
		this.hashColumns.put("nxt_blst_wgt", getNxtBlstWgt());
		this.hashColumns.put("sea_mn_low_sulp_foil_csm_qty", getSeaMnLowSulpFoilCsmQty());
		this.hashColumns.put("dep_rpm_max_pwr", getDepRpmMaxPwr());
		this.hashColumns.put("rf_cntr_lod_knt", getRfCntrLodKnt());
		this.hashColumns.put("spl_doil_brg_wgt2", getSplDoilBrgWgt2());
		this.hashColumns.put("cgo_wrk_st_dt", getCgoWrkStDt());
		this.hashColumns.put("aft_unbrth_ank_drp_dt", getAftUnbrthAnkDrpDt());
		this.hashColumns.put("port_det_rsn_hrs1", getPortDetRsnHrs1());
		this.hashColumns.put("arr_frsh_wtr_wgt", getArrFrshWtrWgt());
		this.hashColumns.put("nxt_gm_hgt", getNxtGmHgt());
		this.hashColumns.put("sea_gnr_doil_csm_qty", getSeaGnrDoilCsmQty());
		this.hashColumns.put("port_det_rsn_hrs2", getPortDetRsnHrs2());
		this.hashColumns.put("port_det_rsn_hrs3", getPortDetRsnHrs3());
		this.hashColumns.put("dep_rpm_min_pwr", getDepRpmMinPwr());
		this.hashColumns.put("arr_doil_csm_qty", getArrDoilCsmQty());
		this.hashColumns.put("mnvr_out_ml_dist", getMnvrOutMlDist());
		this.hashColumns.put("mty_cntr_obrd_teu", getMtyCntrObrdTeu());
		this.hashColumns.put("spl_low_sulp_doil_bdr_wgt", getSplLowSulpDoilBdrWgt());
		this.hashColumns.put("arr_low_sulp_doil_csm_qty", getArrLowSulpDoilCsmQty());
		this.hashColumns.put("port_gnr_low_sulp_foil_csm_qty", getPortGnrLowSulpFoilCsmQty());
		this.hashColumns.put("arr_mid_drft_hgt", getArrMidDrftHgt());
		this.hashColumns.put("arr_nvgt_ml", getArrNvgtMl());
		this.hashColumns.put("arr_fwddr_hgt", getArrFwddrHgt());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("gmt_td_hrs", getGmtTdHrs());
		this.hashColumns.put("port_blr_foil_csm_qty", getPortBlrFoilCsmQty());
		this.hashColumns.put("arr_gnr_foil_csm_qty", getArrGnrFoilCsmQty());
		this.hashColumns.put("dep_rmk", getDepRmk());
		this.hashColumns.put("port_mn_low_sulp_doil_csm_qty", getPortMnLowSulpDoilCsmQty());
		this.hashColumns.put("rmn_dist", getRmnDist());
		this.hashColumns.put("arr_rpm_pwr", getArrRpmPwr());
		this.hashColumns.put("sea_gnr_foil_csm_qty", getSeaGnrFoilCsmQty());
		this.hashColumns.put("eng_ml_dist", getEngMlDist());
		this.hashColumns.put("cntr_dzn_capa", getCntrDznCapa());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("spl_foil_brg_wgt2", getSplFoilBrgWgt2());
		this.hashColumns.put("port_mn_doil_csm_qty", getPortMnDoilCsmQty());
		this.hashColumns.put("spl_foil_brg_wgt1", getSplFoilBrgWgt1());
		this.hashColumns.put("cf_eng_nm", getCfEngNm());
		this.hashColumns.put("blk_hld_load_qty6", getBlkHldLoadQty6());
		this.hashColumns.put("nxt_port_eta_dt", getNxtPortEtaDt());
		this.hashColumns.put("blk_hld_load_qty5", getBlkHldLoadQty5());
		this.hashColumns.put("blk_hld_load_qty8", getBlkHldLoadQty8());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("blk_hld_load_qty7", getBlkHldLoadQty7());
		this.hashColumns.put("blk_hld_load_qty2", getBlkHldLoadQty2());
		this.hashColumns.put("blk_hld_load_qty1", getBlkHldLoadQty1());
		this.hashColumns.put("blk_hld_load_qty4", getBlkHldLoadQty4());
		this.hashColumns.put("blk_hld_load_qty3", getBlkHldLoadQty3());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("port_blr_low_sulp_foil_csm_qty", getPortBlrLowSulpFoilCsmQty());
		this.hashColumns.put("port_gnr_doil_csm_qty", getPortGnrDoilCsmQty());
		this.hashColumns.put("arr_low_sulp_foil_wgt", getArrLowSulpFoilWgt());
		this.hashColumns.put("dep_frsh_wtr_wgt", getDepFrshWtrWgt());
		this.hashColumns.put("spl_low_sulp_doil_brg_wgt1", getSplLowSulpDoilBrgWgt1());
		this.hashColumns.put("dep_sts_cd", getDepStsCd());
		this.hashColumns.put("spl_low_sulp_doil_brg_wgt2", getSplLowSulpDoilBrgWgt2());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("blk_hld_load_qty9", getBlkHldLoadQty9());
		this.hashColumns.put("spl_low_sulp_foil_brg_wgt2", getSplLowSulpFoilBrgWgt2());
		this.hashColumns.put("spl_low_sulp_foil_brg_wgt1", getSplLowSulpFoilBrgWgt1());
		this.hashColumns.put("sea_blr_foil_csm_qty", getSeaBlrFoilCsmQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lst_dep_low_sulp_doil_ctnt", getLstDepLowSulpDoilCtnt());
		this.hashColumns.put("spl_doil_sulp_wgt", getSplDoilSulpWgt());
		this.hashColumns.put("arr_doil_wgt", getArrDoilWgt());
		this.hashColumns.put("run_hrs_in_hv_we", getRunHrsInHvWe());
		this.hashColumns.put("port_det_rsn_cd3", getPortDetRsnCd3());
		this.hashColumns.put("port_det_rsn_cd2", getPortDetRsnCd2());
		this.hashColumns.put("port_det_rsn_cd1", getPortDetRsnCd1());
		this.hashColumns.put("sea_mn_foil_csm_qty", getSeaMnFoilCsmQty());
		this.hashColumns.put("dep_rpm_uusd_fm", getDepRpmUusdFm());
		this.hashColumns.put("arr_blr_foil_csm_qty", getArrBlrFoilCsmQty());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dep_rsn_for_mgn_tm", getDepRsnForMgnTm());
		this.hashColumns.put("spl_doil_bdr_wgt", getSplDoilBdrWgt());
		this.hashColumns.put("nxt_aftdr_hgt", getNxtAftdrHgt());
		this.hashColumns.put("nxt_foil_wgt", getNxtFoilWgt());
		this.hashColumns.put("ttl_cntr_obrd_teu", getTtlCntrObrdTeu());
		this.hashColumns.put("nxt_fwddr_hgt", getNxtFwddrHgt());
		this.hashColumns.put("arr_lat", getArrLat());
		this.hashColumns.put("dep_port_cd", getDepPortCd());
		this.hashColumns.put("full_cntr_obrd_teu", getFullCntrObrdTeu());
		this.hashColumns.put("arr_gm_hgt", getArrGmHgt());
		this.hashColumns.put("port_gnr_low_sulp_doil_csm_qty", getPortGnrLowSulpDoilCsmQty());
		this.hashColumns.put("port_gnr_foil_csm_qty", getPortGnrFoilCsmQty());
		this.hashColumns.put("sea_mn_doil_csm_qty", getSeaMnDoilCsmQty());
		this.hashColumns.put("dpl_slg_sp", getDplSlgSp());
		this.hashColumns.put("spl_foil_bdr_wgt", getSplFoilBdrWgt());
		this.hashColumns.put("port_blr_low_sulp_doil_csm_qty", getPortBlrLowSulpDoilCsmQty());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("sea_blr_low_sulp_foil_csm_qty", getSeaBlrLowSulpFoilCsmQty());
		this.hashColumns.put("sea_mn_low_sulp_doil_csm_qty", getSeaMnLowSulpDoilCsmQty());
		this.hashColumns.put("dep_mid_drft_hgt", getDepMidDrftHgt());
		this.hashColumns.put("arr_mn_foil_csm_qty", getArrMnFoilCsmQty());
		this.hashColumns.put("nxt_frsh_wtr_wgt", getNxtFrshWtrWgt());
		this.hashColumns.put("avg_spd", getAvgSpd());
		this.hashColumns.put("dep_arr_plt_mgn_mnts", getDepArrPltMgnMnts());
		this.hashColumns.put("sea_det_rsn_hrs3", getSeaDetRsnHrs3());
		this.hashColumns.put("dep_rpm_pwr", getDepRpmPwr());
		this.hashColumns.put("sea_det_rsn_hrs2", getSeaDetRsnHrs2());
		this.hashColumns.put("sea_det_rsn_hrs1", getSeaDetRsnHrs1());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("spl_low_sulp_foil_act_wgt", "splLowSulpFoilActWgt");
		this.hashFields.put("plt_in_dt", "pltInDt");
		this.hashFields.put("sea_blr_doil_csm_qty", "seaBlrDoilCsmQty");
		this.hashFields.put("sea_dnst", "seaDnst");
		this.hashFields.put("sea_det_rsn_cd1", "seaDetRsnCd1");
		this.hashFields.put("lst_rf_cntr_obrd_knt_ctnt", "lstRfCntrObrdKntCtnt");
		this.hashFields.put("arr_blr_low_sulp_foil_csm_qty", "arrBlrLowSulpFoilCsmQty");
		this.hashFields.put("sea_det_rsn_cd3", "seaDetRsnCd3");
		this.hashFields.put("bfr_brth_ank_drp_dt", "bfrBrthAnkDrpDt");
		this.hashFields.put("nxt_low_sulp_doil_wgt", "nxtLowSulpDoilWgt");
		this.hashFields.put("sea_det_rsn_cd2", "seaDetRsnCd2");
		this.hashFields.put("fo_slg_wgt", "foSlgWgt");
		this.hashFields.put("nxt_port_cd", "nxtPortCd");
		this.hashFields.put("arr_foil_wgt", "arrFoilWgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("blk_cgo_tp_cd5", "blkCgoTpCd5");
		this.hashFields.put("blk_cgo_tp_cd3", "blkCgoTpCd3");
		this.hashFields.put("nvgt_ml_dist", "nvgtMlDist");
		this.hashFields.put("blk_cgo_tp_cd4", "blkCgoTpCd4");
		this.hashFields.put("blk_cgo_tp_cd1", "blkCgoTpCd1");
		this.hashFields.put("dep_blst_wgt", "depBlstWgt");
		this.hashFields.put("blk_cgo_tp_cd2", "blkCgoTpCd2");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cap_nm", "capNm");
		this.hashFields.put("sea_gnr_low_sulp_foil_csm_qty", "seaGnrLowSulpFoilCsmQty");
		this.hashFields.put("dep_foil_wgt", "depFoilWgt");
		this.hashFields.put("spl_low_sulp_foil_bdr_wgt", "splLowSulpFoilBdrWgt");
		this.hashFields.put("lst_dep_doil_ctnt", "lstDepDoilCtnt");
		this.hashFields.put("spl_foil_act_wgt", "splFoilActWgt");
		this.hashFields.put("avg_rpm_pwr", "avgRpmPwr");
		this.hashFields.put("nxt_doil_wgt", "nxtDoilWgt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("lst_port_rup_dt", "lstPortRupDt");
		this.hashFields.put("plt_out_dt", "pltOutDt");
		this.hashFields.put("arr_gnr_low_sulp_foil_csm_qty", "arrGnrLowSulpFoilCsmQty");
		this.hashFields.put("dep_rpm_uusd_to", "depRpmUusdTo");
		this.hashFields.put("dep_fwddr_hgt", "depFwddrHgt");
		this.hashFields.put("dep_gm_hgt", "depGmHgt");
		this.hashFields.put("incnr_slg_wgt", "incnrSlgWgt");
		this.hashFields.put("dep_lat", "depLat");
		this.hashFields.put("spl_frsh_wtr_act_wgt", "splFrshWtrActWgt");
		this.hashFields.put("port_blr_doil_csm_qty", "portBlrDoilCsmQty");
		this.hashFields.put("dep_dpl_wgt", "depDplWgt");
		this.hashFields.put("foil_purf_dchg_itval", "foilPurfDchgItval");
		this.hashFields.put("spl_foil_sulp_wgt", "splFoilSulpWgt");
		this.hashFields.put("blk_dep_cgo_ttl_wgt", "blkDepCgoTtlWgt");
		this.hashFields.put("lst_dep_low_sulp_foil_ctnt", "lstDepLowSulpFoilCtnt");
		this.hashFields.put("rmn_sdg_wgt", "rmnSdgWgt");
		this.hashFields.put("bfr_brth_ank_off_dt", "bfrBrthAnkOffDt");
		this.hashFields.put("arr_lon", "arrLon");
		this.hashFields.put("rmn_avg_spd", "rmnAvgSpd");
		this.hashFields.put("blk_lod_dchg_sts_cd", "blkLodDchgStsCd");
		this.hashFields.put("nxt_low_sulp_foil_wgt", "nxtLowSulpFoilWgt");
		this.hashFields.put("dpl_slg_wgt", "dplSlgWgt");
		this.hashFields.put("dep_cgo_wgt", "depCgoWgt");
		this.hashFields.put("mnvr_in_ml_dist", "mnvrInMlDist");
		this.hashFields.put("arr_blst_wgt", "arrBlstWgt");
		this.hashFields.put("dep_doil_wgt", "depDoilWgt");
		this.hashFields.put("arr_mn_low_sulp_foil_csm_qty", "arrMnLowSulpFoilCsmQty");
		this.hashFields.put("spl_low_sulp_doil_act_wgt", "splLowSulpDoilActWgt");
		this.hashFields.put("lst_dep_foil_ctnt", "lstDepFoilCtnt");
		this.hashFields.put("spl_low_sulp_foil_sulp_wgt", "splLowSulpFoilSulpWgt");
		this.hashFields.put("arr_low_sulp_doil_wgt", "arrLowSulpDoilWgt");
		this.hashFields.put("spl_doil_act_wgt", "splDoilActWgt");
		this.hashFields.put("ttl_slg_wgt", "ttlSlgWgt");
		this.hashFields.put("arr_eng_ml", "arrEngMl");
		this.hashFields.put("rup_dt", "rupDt");
		this.hashFields.put("sb_eng_dt", "sbEngDt");
		this.hashFields.put("port_mn_low_sulp_foil_csm_qty", "portMnLowSulpFoilCsmQty");
		this.hashFields.put("cgo_wrk_end_dt", "cgoWrkEndDt");
		this.hashFields.put("arr_aftdr_hgt", "arrAftdrHgt");
		this.hashFields.put("dep_low_sulp_doil_wgt", "depLowSulpDoilWgt");
		this.hashFields.put("dep_aftdr_hgt", "depAftdrHgt");
		this.hashFields.put("sea_gnr_low_sulp_doil_csm_qty", "seaGnrLowSulpDoilCsmQty");
		this.hashFields.put("port_mn_foil_csm_qty", "portMnFoilCsmQty");
		this.hashFields.put("arr_sail_hrs", "arrSailHrs");
		this.hashFields.put("dep_lon", "depLon");
		this.hashFields.put("nxt_mid_drft_hgt", "nxtMidDrftHgt");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("rf_cntr_dchg_knt", "rfCntrDchgKnt");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("rf_cntr_obrd_knt", "rfCntrObrdKnt");
		this.hashFields.put("spl_low_sulp_doil_sulp_wgt", "splLowSulpDoilSulpWgt");
		this.hashFields.put("dep_low_sulp_foil_wgt", "depLowSulpFoilWgt");
		this.hashFields.put("dep_arr_plt_mgn_hrs", "depArrPltMgnHrs");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("sea_blr_low_sulp_doil_csm_qty", "seaBlrLowSulpDoilCsmQty");
		this.hashFields.put("spl_doil_brg_wgt1", "splDoilBrgWgt1");
		this.hashFields.put("aft_unbrth_ank_off_dt", "aftUnbrthAnkOffDt");
		this.hashFields.put("lst_dep_port_cd", "lstDepPortCd");
		this.hashFields.put("nxt_blst_wgt", "nxtBlstWgt");
		this.hashFields.put("sea_mn_low_sulp_foil_csm_qty", "seaMnLowSulpFoilCsmQty");
		this.hashFields.put("dep_rpm_max_pwr", "depRpmMaxPwr");
		this.hashFields.put("rf_cntr_lod_knt", "rfCntrLodKnt");
		this.hashFields.put("spl_doil_brg_wgt2", "splDoilBrgWgt2");
		this.hashFields.put("cgo_wrk_st_dt", "cgoWrkStDt");
		this.hashFields.put("aft_unbrth_ank_drp_dt", "aftUnbrthAnkDrpDt");
		this.hashFields.put("port_det_rsn_hrs1", "portDetRsnHrs1");
		this.hashFields.put("arr_frsh_wtr_wgt", "arrFrshWtrWgt");
		this.hashFields.put("nxt_gm_hgt", "nxtGmHgt");
		this.hashFields.put("sea_gnr_doil_csm_qty", "seaGnrDoilCsmQty");
		this.hashFields.put("port_det_rsn_hrs2", "portDetRsnHrs2");
		this.hashFields.put("port_det_rsn_hrs3", "portDetRsnHrs3");
		this.hashFields.put("dep_rpm_min_pwr", "depRpmMinPwr");
		this.hashFields.put("arr_doil_csm_qty", "arrDoilCsmQty");
		this.hashFields.put("mnvr_out_ml_dist", "mnvrOutMlDist");
		this.hashFields.put("mty_cntr_obrd_teu", "mtyCntrObrdTeu");
		this.hashFields.put("spl_low_sulp_doil_bdr_wgt", "splLowSulpDoilBdrWgt");
		this.hashFields.put("arr_low_sulp_doil_csm_qty", "arrLowSulpDoilCsmQty");
		this.hashFields.put("port_gnr_low_sulp_foil_csm_qty", "portGnrLowSulpFoilCsmQty");
		this.hashFields.put("arr_mid_drft_hgt", "arrMidDrftHgt");
		this.hashFields.put("arr_nvgt_ml", "arrNvgtMl");
		this.hashFields.put("arr_fwddr_hgt", "arrFwddrHgt");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("gmt_td_hrs", "gmtTdHrs");
		this.hashFields.put("port_blr_foil_csm_qty", "portBlrFoilCsmQty");
		this.hashFields.put("arr_gnr_foil_csm_qty", "arrGnrFoilCsmQty");
		this.hashFields.put("dep_rmk", "depRmk");
		this.hashFields.put("port_mn_low_sulp_doil_csm_qty", "portMnLowSulpDoilCsmQty");
		this.hashFields.put("rmn_dist", "rmnDist");
		this.hashFields.put("arr_rpm_pwr", "arrRpmPwr");
		this.hashFields.put("sea_gnr_foil_csm_qty", "seaGnrFoilCsmQty");
		this.hashFields.put("eng_ml_dist", "engMlDist");
		this.hashFields.put("cntr_dzn_capa", "cntrDznCapa");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("spl_foil_brg_wgt2", "splFoilBrgWgt2");
		this.hashFields.put("port_mn_doil_csm_qty", "portMnDoilCsmQty");
		this.hashFields.put("spl_foil_brg_wgt1", "splFoilBrgWgt1");
		this.hashFields.put("cf_eng_nm", "cfEngNm");
		this.hashFields.put("blk_hld_load_qty6", "blkHldLoadQty6");
		this.hashFields.put("nxt_port_eta_dt", "nxtPortEtaDt");
		this.hashFields.put("blk_hld_load_qty5", "blkHldLoadQty5");
		this.hashFields.put("blk_hld_load_qty8", "blkHldLoadQty8");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("blk_hld_load_qty7", "blkHldLoadQty7");
		this.hashFields.put("blk_hld_load_qty2", "blkHldLoadQty2");
		this.hashFields.put("blk_hld_load_qty1", "blkHldLoadQty1");
		this.hashFields.put("blk_hld_load_qty4", "blkHldLoadQty4");
		this.hashFields.put("blk_hld_load_qty3", "blkHldLoadQty3");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("port_blr_low_sulp_foil_csm_qty", "portBlrLowSulpFoilCsmQty");
		this.hashFields.put("port_gnr_doil_csm_qty", "portGnrDoilCsmQty");
		this.hashFields.put("arr_low_sulp_foil_wgt", "arrLowSulpFoilWgt");
		this.hashFields.put("dep_frsh_wtr_wgt", "depFrshWtrWgt");
		this.hashFields.put("spl_low_sulp_doil_brg_wgt1", "splLowSulpDoilBrgWgt1");
		this.hashFields.put("dep_sts_cd", "depStsCd");
		this.hashFields.put("spl_low_sulp_doil_brg_wgt2", "splLowSulpDoilBrgWgt2");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("blk_hld_load_qty9", "blkHldLoadQty9");
		this.hashFields.put("spl_low_sulp_foil_brg_wgt2", "splLowSulpFoilBrgWgt2");
		this.hashFields.put("spl_low_sulp_foil_brg_wgt1", "splLowSulpFoilBrgWgt1");
		this.hashFields.put("sea_blr_foil_csm_qty", "seaBlrFoilCsmQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lst_dep_low_sulp_doil_ctnt", "lstDepLowSulpDoilCtnt");
		this.hashFields.put("spl_doil_sulp_wgt", "splDoilSulpWgt");
		this.hashFields.put("arr_doil_wgt", "arrDoilWgt");
		this.hashFields.put("run_hrs_in_hv_we", "runHrsInHvWe");
		this.hashFields.put("port_det_rsn_cd3", "portDetRsnCd3");
		this.hashFields.put("port_det_rsn_cd2", "portDetRsnCd2");
		this.hashFields.put("port_det_rsn_cd1", "portDetRsnCd1");
		this.hashFields.put("sea_mn_foil_csm_qty", "seaMnFoilCsmQty");
		this.hashFields.put("dep_rpm_uusd_fm", "depRpmUusdFm");
		this.hashFields.put("arr_blr_foil_csm_qty", "arrBlrFoilCsmQty");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dep_rsn_for_mgn_tm", "depRsnForMgnTm");
		this.hashFields.put("spl_doil_bdr_wgt", "splDoilBdrWgt");
		this.hashFields.put("nxt_aftdr_hgt", "nxtAftdrHgt");
		this.hashFields.put("nxt_foil_wgt", "nxtFoilWgt");
		this.hashFields.put("ttl_cntr_obrd_teu", "ttlCntrObrdTeu");
		this.hashFields.put("nxt_fwddr_hgt", "nxtFwddrHgt");
		this.hashFields.put("arr_lat", "arrLat");
		this.hashFields.put("dep_port_cd", "depPortCd");
		this.hashFields.put("full_cntr_obrd_teu", "fullCntrObrdTeu");
		this.hashFields.put("arr_gm_hgt", "arrGmHgt");
		this.hashFields.put("port_gnr_low_sulp_doil_csm_qty", "portGnrLowSulpDoilCsmQty");
		this.hashFields.put("port_gnr_foil_csm_qty", "portGnrFoilCsmQty");
		this.hashFields.put("sea_mn_doil_csm_qty", "seaMnDoilCsmQty");
		this.hashFields.put("dpl_slg_sp", "dplSlgSp");
		this.hashFields.put("spl_foil_bdr_wgt", "splFoilBdrWgt");
		this.hashFields.put("port_blr_low_sulp_doil_csm_qty", "portBlrLowSulpDoilCsmQty");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("sea_blr_low_sulp_foil_csm_qty", "seaBlrLowSulpFoilCsmQty");
		this.hashFields.put("sea_mn_low_sulp_doil_csm_qty", "seaMnLowSulpDoilCsmQty");
		this.hashFields.put("dep_mid_drft_hgt", "depMidDrftHgt");
		this.hashFields.put("arr_mn_foil_csm_qty", "arrMnFoilCsmQty");
		this.hashFields.put("nxt_frsh_wtr_wgt", "nxtFrshWtrWgt");
		this.hashFields.put("avg_spd", "avgSpd");
		this.hashFields.put("dep_arr_plt_mgn_mnts", "depArrPltMgnMnts");
		this.hashFields.put("sea_det_rsn_hrs3", "seaDetRsnHrs3");
		this.hashFields.put("dep_rpm_pwr", "depRpmPwr");
		this.hashFields.put("sea_det_rsn_hrs2", "seaDetRsnHrs2");
		this.hashFields.put("sea_det_rsn_hrs1", "seaDetRsnHrs1");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpFoilActWgt
	 */
	public String getSplLowSulpFoilActWgt() {
		return this.splLowSulpFoilActWgt;
	}
	
	/**
	 * Column Info
	 * @return pltInDt
	 */
	public String getPltInDt() {
		return this.pltInDt;
	}
	
	/**
	 * Column Info
	 * @return seaBlrDoilCsmQty
	 */
	public String getSeaBlrDoilCsmQty() {
		return this.seaBlrDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return seaDnst
	 */
	public String getSeaDnst() {
		return this.seaDnst;
	}
	
	/**
	 * Column Info
	 * @return seaDetRsnCd1
	 */
	public String getSeaDetRsnCd1() {
		return this.seaDetRsnCd1;
	}
	
	/**
	 * Column Info
	 * @return lstRfCntrObrdKntCtnt
	 */
	public String getLstRfCntrObrdKntCtnt() {
		return this.lstRfCntrObrdKntCtnt;
	}
	
	/**
	 * Column Info
	 * @return arrBlrLowSulpFoilCsmQty
	 */
	public String getArrBlrLowSulpFoilCsmQty() {
		return this.arrBlrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return seaDetRsnCd3
	 */
	public String getSeaDetRsnCd3() {
		return this.seaDetRsnCd3;
	}
	
	/**
	 * Column Info
	 * @return bfrBrthAnkDrpDt
	 */
	public String getBfrBrthAnkDrpDt() {
		return this.bfrBrthAnkDrpDt;
	}
	
	/**
	 * Column Info
	 * @return nxtLowSulpDoilWgt
	 */
	public String getNxtLowSulpDoilWgt() {
		return this.nxtLowSulpDoilWgt;
	}
	
	/**
	 * Column Info
	 * @return seaDetRsnCd2
	 */
	public String getSeaDetRsnCd2() {
		return this.seaDetRsnCd2;
	}
	
	/**
	 * Column Info
	 * @return foSlgWgt
	 */
	public String getFoSlgWgt() {
		return this.foSlgWgt;
	}
	
	/**
	 * Column Info
	 * @return nxtPortCd
	 */
	public String getNxtPortCd() {
		return this.nxtPortCd;
	}
	
	/**
	 * Column Info
	 * @return arrFoilWgt
	 */
	public String getArrFoilWgt() {
		return this.arrFoilWgt;
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
	 * @return blkCgoTpCd5
	 */
	public String getBlkCgoTpCd5() {
		return this.blkCgoTpCd5;
	}
	
	/**
	 * Column Info
	 * @return blkCgoTpCd3
	 */
	public String getBlkCgoTpCd3() {
		return this.blkCgoTpCd3;
	}
	
	/**
	 * Column Info
	 * @return nvgtMlDist
	 */
	public String getNvgtMlDist() {
		return this.nvgtMlDist;
	}
	
	/**
	 * Column Info
	 * @return blkCgoTpCd4
	 */
	public String getBlkCgoTpCd4() {
		return this.blkCgoTpCd4;
	}
	
	/**
	 * Column Info
	 * @return blkCgoTpCd1
	 */
	public String getBlkCgoTpCd1() {
		return this.blkCgoTpCd1;
	}
	
	/**
	 * Column Info
	 * @return depBlstWgt
	 */
	public String getDepBlstWgt() {
		return this.depBlstWgt;
	}
	
	/**
	 * Column Info
	 * @return blkCgoTpCd2
	 */
	public String getBlkCgoTpCd2() {
		return this.blkCgoTpCd2;
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
	 * @return capNm
	 */
	public String getCapNm() {
		return this.capNm;
	}
	
	/**
	 * Column Info
	 * @return seaGnrLowSulpFoilCsmQty
	 */
	public String getSeaGnrLowSulpFoilCsmQty() {
		return this.seaGnrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return depFoilWgt
	 */
	public String getDepFoilWgt() {
		return this.depFoilWgt;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpFoilBdrWgt
	 */
	public String getSplLowSulpFoilBdrWgt() {
		return this.splLowSulpFoilBdrWgt;
	}
	
	/**
	 * Column Info
	 * @return lstDepDoilCtnt
	 */
	public String getLstDepDoilCtnt() {
		return this.lstDepDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return splFoilActWgt
	 */
	public String getSplFoilActWgt() {
		return this.splFoilActWgt;
	}
	
	/**
	 * Column Info
	 * @return avgRpmPwr
	 */
	public String getAvgRpmPwr() {
		return this.avgRpmPwr;
	}
	
	/**
	 * Column Info
	 * @return nxtDoilWgt
	 */
	public String getNxtDoilWgt() {
		return this.nxtDoilWgt;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return lstPortRupDt
	 */
	public String getLstPortRupDt() {
		return this.lstPortRupDt;
	}
	
	/**
	 * Column Info
	 * @return pltOutDt
	 */
	public String getPltOutDt() {
		return this.pltOutDt;
	}
	
	/**
	 * Column Info
	 * @return arrGnrLowSulpFoilCsmQty
	 */
	public String getArrGnrLowSulpFoilCsmQty() {
		return this.arrGnrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return depRpmUusdTo
	 */
	public String getDepRpmUusdTo() {
		return this.depRpmUusdTo;
	}
	
	/**
	 * Column Info
	 * @return depFwddrHgt
	 */
	public String getDepFwddrHgt() {
		return this.depFwddrHgt;
	}
	
	/**
	 * Column Info
	 * @return depGmHgt
	 */
	public String getDepGmHgt() {
		return this.depGmHgt;
	}
	
	/**
	 * Column Info
	 * @return incnrSlgWgt
	 */
	public String getIncnrSlgWgt() {
		return this.incnrSlgWgt;
	}
	
	/**
	 * Column Info
	 * @return depLat
	 */
	public String getDepLat() {
		return this.depLat;
	}
	
	/**
	 * Column Info
	 * @return splFrshWtrActWgt
	 */
	public String getSplFrshWtrActWgt() {
		return this.splFrshWtrActWgt;
	}
	
	/**
	 * Column Info
	 * @return portBlrDoilCsmQty
	 */
	public String getPortBlrDoilCsmQty() {
		return this.portBlrDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return depDplWgt
	 */
	public String getDepDplWgt() {
		return this.depDplWgt;
	}
	
	/**
	 * Column Info
	 * @return foilPurfDchgItval
	 */
	public String getFoilPurfDchgItval() {
		return this.foilPurfDchgItval;
	}
	
	/**
	 * Column Info
	 * @return splFoilSulpWgt
	 */
	public String getSplFoilSulpWgt() {
		return this.splFoilSulpWgt;
	}
	
	/**
	 * Column Info
	 * @return blkDepCgoTtlWgt
	 */
	public String getBlkDepCgoTtlWgt() {
		return this.blkDepCgoTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return lstDepLowSulpFoilCtnt
	 */
	public String getLstDepLowSulpFoilCtnt() {
		return this.lstDepLowSulpFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return rmnSdgWgt
	 */
	public String getRmnSdgWgt() {
		return this.rmnSdgWgt;
	}
	
	/**
	 * Column Info
	 * @return bfrBrthAnkOffDt
	 */
	public String getBfrBrthAnkOffDt() {
		return this.bfrBrthAnkOffDt;
	}
	
	/**
	 * Column Info
	 * @return arrLon
	 */
	public String getArrLon() {
		return this.arrLon;
	}
	
	/**
	 * Column Info
	 * @return rmnAvgSpd
	 */
	public String getRmnAvgSpd() {
		return this.rmnAvgSpd;
	}
	
	/**
	 * Column Info
	 * @return blkLodDchgStsCd
	 */
	public String getBlkLodDchgStsCd() {
		return this.blkLodDchgStsCd;
	}
	
	/**
	 * Column Info
	 * @return nxtLowSulpFoilWgt
	 */
	public String getNxtLowSulpFoilWgt() {
		return this.nxtLowSulpFoilWgt;
	}
	
	/**
	 * Column Info
	 * @return dplSlgWgt
	 */
	public String getDplSlgWgt() {
		return this.dplSlgWgt;
	}
	
	/**
	 * Column Info
	 * @return depCgoWgt
	 */
	public String getDepCgoWgt() {
		return this.depCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return mnvrInMlDist
	 */
	public String getMnvrInMlDist() {
		return this.mnvrInMlDist;
	}
	
	/**
	 * Column Info
	 * @return arrBlstWgt
	 */
	public String getArrBlstWgt() {
		return this.arrBlstWgt;
	}
	
	/**
	 * Column Info
	 * @return depDoilWgt
	 */
	public String getDepDoilWgt() {
		return this.depDoilWgt;
	}
	
	/**
	 * Column Info
	 * @return arrMnLowSulpFoilCsmQty
	 */
	public String getArrMnLowSulpFoilCsmQty() {
		return this.arrMnLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpDoilActWgt
	 */
	public String getSplLowSulpDoilActWgt() {
		return this.splLowSulpDoilActWgt;
	}
	
	/**
	 * Column Info
	 * @return lstDepFoilCtnt
	 */
	public String getLstDepFoilCtnt() {
		return this.lstDepFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpFoilSulpWgt
	 */
	public String getSplLowSulpFoilSulpWgt() {
		return this.splLowSulpFoilSulpWgt;
	}
	
	/**
	 * Column Info
	 * @return arrLowSulpDoilWgt
	 */
	public String getArrLowSulpDoilWgt() {
		return this.arrLowSulpDoilWgt;
	}
	
	/**
	 * Column Info
	 * @return splDoilActWgt
	 */
	public String getSplDoilActWgt() {
		return this.splDoilActWgt;
	}
	
	/**
	 * Column Info
	 * @return ttlSlgWgt
	 */
	public String getTtlSlgWgt() {
		return this.ttlSlgWgt;
	}
	
	/**
	 * Column Info
	 * @return arrEngMl
	 */
	public String getArrEngMl() {
		return this.arrEngMl;
	}
	
	/**
	 * Column Info
	 * @return rupDt
	 */
	public String getRupDt() {
		return this.rupDt;
	}
	
	/**
	 * Column Info
	 * @return sbEngDt
	 */
	public String getSbEngDt() {
		return this.sbEngDt;
	}
	
	/**
	 * Column Info
	 * @return portMnLowSulpFoilCsmQty
	 */
	public String getPortMnLowSulpFoilCsmQty() {
		return this.portMnLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return cgoWrkEndDt
	 */
	public String getCgoWrkEndDt() {
		return this.cgoWrkEndDt;
	}
	
	/**
	 * Column Info
	 * @return arrAftdrHgt
	 */
	public String getArrAftdrHgt() {
		return this.arrAftdrHgt;
	}
	
	/**
	 * Column Info
	 * @return depLowSulpDoilWgt
	 */
	public String getDepLowSulpDoilWgt() {
		return this.depLowSulpDoilWgt;
	}
	
	/**
	 * Column Info
	 * @return depAftdrHgt
	 */
	public String getDepAftdrHgt() {
		return this.depAftdrHgt;
	}
	
	/**
	 * Column Info
	 * @return seaGnrLowSulpDoilCsmQty
	 */
	public String getSeaGnrLowSulpDoilCsmQty() {
		return this.seaGnrLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return portMnFoilCsmQty
	 */
	public String getPortMnFoilCsmQty() {
		return this.portMnFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return arrSailHrs
	 */
	public String getArrSailHrs() {
		return this.arrSailHrs;
	}
	
	/**
	 * Column Info
	 * @return depLon
	 */
	public String getDepLon() {
		return this.depLon;
	}
	
	/**
	 * Column Info
	 * @return nxtMidDrftHgt
	 */
	public String getNxtMidDrftHgt() {
		return this.nxtMidDrftHgt;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return rfCntrDchgKnt
	 */
	public String getRfCntrDchgKnt() {
		return this.rfCntrDchgKnt;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return rfCntrObrdKnt
	 */
	public String getRfCntrObrdKnt() {
		return this.rfCntrObrdKnt;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpDoilSulpWgt
	 */
	public String getSplLowSulpDoilSulpWgt() {
		return this.splLowSulpDoilSulpWgt;
	}
	
	/**
	 * Column Info
	 * @return depLowSulpFoilWgt
	 */
	public String getDepLowSulpFoilWgt() {
		return this.depLowSulpFoilWgt;
	}
	
	/**
	 * Column Info
	 * @return depArrPltMgnHrs
	 */
	public String getDepArrPltMgnHrs() {
		return this.depArrPltMgnHrs;
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
	 * @return seaBlrLowSulpDoilCsmQty
	 */
	public String getSeaBlrLowSulpDoilCsmQty() {
		return this.seaBlrLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return splDoilBrgWgt1
	 */
	public String getSplDoilBrgWgt1() {
		return this.splDoilBrgWgt1;
	}
	
	/**
	 * Column Info
	 * @return aftUnbrthAnkOffDt
	 */
	public String getAftUnbrthAnkOffDt() {
		return this.aftUnbrthAnkOffDt;
	}
	
	/**
	 * Column Info
	 * @return lstDepPortCd
	 */
	public String getLstDepPortCd() {
		return this.lstDepPortCd;
	}
	
	/**
	 * Column Info
	 * @return nxtBlstWgt
	 */
	public String getNxtBlstWgt() {
		return this.nxtBlstWgt;
	}
	
	/**
	 * Column Info
	 * @return seaMnLowSulpFoilCsmQty
	 */
	public String getSeaMnLowSulpFoilCsmQty() {
		return this.seaMnLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return depRpmMaxPwr
	 */
	public String getDepRpmMaxPwr() {
		return this.depRpmMaxPwr;
	}
	
	/**
	 * Column Info
	 * @return rfCntrLodKnt
	 */
	public String getRfCntrLodKnt() {
		return this.rfCntrLodKnt;
	}
	
	/**
	 * Column Info
	 * @return splDoilBrgWgt2
	 */
	public String getSplDoilBrgWgt2() {
		return this.splDoilBrgWgt2;
	}
	
	/**
	 * Column Info
	 * @return cgoWrkStDt
	 */
	public String getCgoWrkStDt() {
		return this.cgoWrkStDt;
	}
	
	/**
	 * Column Info
	 * @return aftUnbrthAnkDrpDt
	 */
	public String getAftUnbrthAnkDrpDt() {
		return this.aftUnbrthAnkDrpDt;
	}
	
	/**
	 * Column Info
	 * @return portDetRsnHrs1
	 */
	public String getPortDetRsnHrs1() {
		return this.portDetRsnHrs1;
	}
	
	/**
	 * Column Info
	 * @return arrFrshWtrWgt
	 */
	public String getArrFrshWtrWgt() {
		return this.arrFrshWtrWgt;
	}
	
	/**
	 * Column Info
	 * @return nxtGmHgt
	 */
	public String getNxtGmHgt() {
		return this.nxtGmHgt;
	}
	
	/**
	 * Column Info
	 * @return seaGnrDoilCsmQty
	 */
	public String getSeaGnrDoilCsmQty() {
		return this.seaGnrDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return portDetRsnHrs2
	 */
	public String getPortDetRsnHrs2() {
		return this.portDetRsnHrs2;
	}
	
	/**
	 * Column Info
	 * @return portDetRsnHrs3
	 */
	public String getPortDetRsnHrs3() {
		return this.portDetRsnHrs3;
	}
	
	/**
	 * Column Info
	 * @return depRpmMinPwr
	 */
	public String getDepRpmMinPwr() {
		return this.depRpmMinPwr;
	}
	
	/**
	 * Column Info
	 * @return arrDoilCsmQty
	 */
	public String getArrDoilCsmQty() {
		return this.arrDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return mnvrOutMlDist
	 */
	public String getMnvrOutMlDist() {
		return this.mnvrOutMlDist;
	}
	
	/**
	 * Column Info
	 * @return mtyCntrObrdTeu
	 */
	public String getMtyCntrObrdTeu() {
		return this.mtyCntrObrdTeu;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpDoilBdrWgt
	 */
	public String getSplLowSulpDoilBdrWgt() {
		return this.splLowSulpDoilBdrWgt;
	}
	
	/**
	 * Column Info
	 * @return arrLowSulpDoilCsmQty
	 */
	public String getArrLowSulpDoilCsmQty() {
		return this.arrLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return portGnrLowSulpFoilCsmQty
	 */
	public String getPortGnrLowSulpFoilCsmQty() {
		return this.portGnrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return arrMidDrftHgt
	 */
	public String getArrMidDrftHgt() {
		return this.arrMidDrftHgt;
	}
	
	/**
	 * Column Info
	 * @return arrNvgtMl
	 */
	public String getArrNvgtMl() {
		return this.arrNvgtMl;
	}
	
	/**
	 * Column Info
	 * @return arrFwddrHgt
	 */
	public String getArrFwddrHgt() {
		return this.arrFwddrHgt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return gmtTdHrs
	 */
	public String getGmtTdHrs() {
		return this.gmtTdHrs;
	}
	
	/**
	 * Column Info
	 * @return portBlrFoilCsmQty
	 */
	public String getPortBlrFoilCsmQty() {
		return this.portBlrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return arrGnrFoilCsmQty
	 */
	public String getArrGnrFoilCsmQty() {
		return this.arrGnrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return depRmk
	 */
	public String getDepRmk() {
		return this.depRmk;
	}
	
	/**
	 * Column Info
	 * @return portMnLowSulpDoilCsmQty
	 */
	public String getPortMnLowSulpDoilCsmQty() {
		return this.portMnLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return rmnDist
	 */
	public String getRmnDist() {
		return this.rmnDist;
	}
	
	/**
	 * Column Info
	 * @return arrRpmPwr
	 */
	public String getArrRpmPwr() {
		return this.arrRpmPwr;
	}
	
	/**
	 * Column Info
	 * @return seaGnrFoilCsmQty
	 */
	public String getSeaGnrFoilCsmQty() {
		return this.seaGnrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return engMlDist
	 */
	public String getEngMlDist() {
		return this.engMlDist;
	}
	
	/**
	 * Column Info
	 * @return cntrDznCapa
	 */
	public String getCntrDznCapa() {
		return this.cntrDznCapa;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return splFoilBrgWgt2
	 */
	public String getSplFoilBrgWgt2() {
		return this.splFoilBrgWgt2;
	}
	
	/**
	 * Column Info
	 * @return portMnDoilCsmQty
	 */
	public String getPortMnDoilCsmQty() {
		return this.portMnDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return splFoilBrgWgt1
	 */
	public String getSplFoilBrgWgt1() {
		return this.splFoilBrgWgt1;
	}
	
	/**
	 * Column Info
	 * @return cfEngNm
	 */
	public String getCfEngNm() {
		return this.cfEngNm;
	}
	
	/**
	 * Column Info
	 * @return blkHldLoadQty6
	 */
	public String getBlkHldLoadQty6() {
		return this.blkHldLoadQty6;
	}
	
	/**
	 * Column Info
	 * @return nxtPortEtaDt
	 */
	public String getNxtPortEtaDt() {
		return this.nxtPortEtaDt;
	}
	
	/**
	 * Column Info
	 * @return blkHldLoadQty5
	 */
	public String getBlkHldLoadQty5() {
		return this.blkHldLoadQty5;
	}
	
	/**
	 * Column Info
	 * @return blkHldLoadQty8
	 */
	public String getBlkHldLoadQty8() {
		return this.blkHldLoadQty8;
	}
	
	/**
	 * Column Info
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return blkHldLoadQty7
	 */
	public String getBlkHldLoadQty7() {
		return this.blkHldLoadQty7;
	}
	
	/**
	 * Column Info
	 * @return blkHldLoadQty2
	 */
	public String getBlkHldLoadQty2() {
		return this.blkHldLoadQty2;
	}
	
	/**
	 * Column Info
	 * @return blkHldLoadQty1
	 */
	public String getBlkHldLoadQty1() {
		return this.blkHldLoadQty1;
	}
	
	/**
	 * Column Info
	 * @return blkHldLoadQty4
	 */
	public String getBlkHldLoadQty4() {
		return this.blkHldLoadQty4;
	}
	
	/**
	 * Column Info
	 * @return blkHldLoadQty3
	 */
	public String getBlkHldLoadQty3() {
		return this.blkHldLoadQty3;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return portBlrLowSulpFoilCsmQty
	 */
	public String getPortBlrLowSulpFoilCsmQty() {
		return this.portBlrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return portGnrDoilCsmQty
	 */
	public String getPortGnrDoilCsmQty() {
		return this.portGnrDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return arrLowSulpFoilWgt
	 */
	public String getArrLowSulpFoilWgt() {
		return this.arrLowSulpFoilWgt;
	}
	
	/**
	 * Column Info
	 * @return depFrshWtrWgt
	 */
	public String getDepFrshWtrWgt() {
		return this.depFrshWtrWgt;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpDoilBrgWgt1
	 */
	public String getSplLowSulpDoilBrgWgt1() {
		return this.splLowSulpDoilBrgWgt1;
	}
	
	/**
	 * Column Info
	 * @return depStsCd
	 */
	public String getDepStsCd() {
		return this.depStsCd;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpDoilBrgWgt2
	 */
	public String getSplLowSulpDoilBrgWgt2() {
		return this.splLowSulpDoilBrgWgt2;
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
	 * @return blkHldLoadQty9
	 */
	public String getBlkHldLoadQty9() {
		return this.blkHldLoadQty9;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpFoilBrgWgt2
	 */
	public String getSplLowSulpFoilBrgWgt2() {
		return this.splLowSulpFoilBrgWgt2;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpFoilBrgWgt1
	 */
	public String getSplLowSulpFoilBrgWgt1() {
		return this.splLowSulpFoilBrgWgt1;
	}
	
	/**
	 * Column Info
	 * @return seaBlrFoilCsmQty
	 */
	public String getSeaBlrFoilCsmQty() {
		return this.seaBlrFoilCsmQty;
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
	 * @return lstDepLowSulpDoilCtnt
	 */
	public String getLstDepLowSulpDoilCtnt() {
		return this.lstDepLowSulpDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return splDoilSulpWgt
	 */
	public String getSplDoilSulpWgt() {
		return this.splDoilSulpWgt;
	}
	
	/**
	 * Column Info
	 * @return arrDoilWgt
	 */
	public String getArrDoilWgt() {
		return this.arrDoilWgt;
	}
	
	/**
	 * Column Info
	 * @return runHrsInHvWe
	 */
	public String getRunHrsInHvWe() {
		return this.runHrsInHvWe;
	}
	
	/**
	 * Column Info
	 * @return portDetRsnCd3
	 */
	public String getPortDetRsnCd3() {
		return this.portDetRsnCd3;
	}
	
	/**
	 * Column Info
	 * @return portDetRsnCd2
	 */
	public String getPortDetRsnCd2() {
		return this.portDetRsnCd2;
	}
	
	/**
	 * Column Info
	 * @return portDetRsnCd1
	 */
	public String getPortDetRsnCd1() {
		return this.portDetRsnCd1;
	}
	
	/**
	 * Column Info
	 * @return seaMnFoilCsmQty
	 */
	public String getSeaMnFoilCsmQty() {
		return this.seaMnFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return depRpmUusdFm
	 */
	public String getDepRpmUusdFm() {
		return this.depRpmUusdFm;
	}
	
	/**
	 * Column Info
	 * @return arrBlrFoilCsmQty
	 */
	public String getArrBlrFoilCsmQty() {
		return this.arrBlrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return depRsnForMgnTm
	 */
	public String getDepRsnForMgnTm() {
		return this.depRsnForMgnTm;
	}
	
	/**
	 * Column Info
	 * @return splDoilBdrWgt
	 */
	public String getSplDoilBdrWgt() {
		return this.splDoilBdrWgt;
	}
	
	/**
	 * Column Info
	 * @return nxtAftdrHgt
	 */
	public String getNxtAftdrHgt() {
		return this.nxtAftdrHgt;
	}
	
	/**
	 * Column Info
	 * @return nxtFoilWgt
	 */
	public String getNxtFoilWgt() {
		return this.nxtFoilWgt;
	}
	
	/**
	 * Column Info
	 * @return ttlCntrObrdTeu
	 */
	public String getTtlCntrObrdTeu() {
		return this.ttlCntrObrdTeu;
	}
	
	/**
	 * Column Info
	 * @return nxtFwddrHgt
	 */
	public String getNxtFwddrHgt() {
		return this.nxtFwddrHgt;
	}
	
	/**
	 * Column Info
	 * @return arrLat
	 */
	public String getArrLat() {
		return this.arrLat;
	}
	
	/**
	 * Column Info
	 * @return depPortCd
	 */
	public String getDepPortCd() {
		return this.depPortCd;
	}
	
	/**
	 * Column Info
	 * @return fullCntrObrdTeu
	 */
	public String getFullCntrObrdTeu() {
		return this.fullCntrObrdTeu;
	}
	
	/**
	 * Column Info
	 * @return arrGmHgt
	 */
	public String getArrGmHgt() {
		return this.arrGmHgt;
	}
	
	/**
	 * Column Info
	 * @return portGnrLowSulpDoilCsmQty
	 */
	public String getPortGnrLowSulpDoilCsmQty() {
		return this.portGnrLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return portGnrFoilCsmQty
	 */
	public String getPortGnrFoilCsmQty() {
		return this.portGnrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return seaMnDoilCsmQty
	 */
	public String getSeaMnDoilCsmQty() {
		return this.seaMnDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return dplSlgSp
	 */
	public String getDplSlgSp() {
		return this.dplSlgSp;
	}
	
	/**
	 * Column Info
	 * @return splFoilBdrWgt
	 */
	public String getSplFoilBdrWgt() {
		return this.splFoilBdrWgt;
	}
	
	/**
	 * Column Info
	 * @return portBlrLowSulpDoilCsmQty
	 */
	public String getPortBlrLowSulpDoilCsmQty() {
		return this.portBlrLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return seaBlrLowSulpFoilCsmQty
	 */
	public String getSeaBlrLowSulpFoilCsmQty() {
		return this.seaBlrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return seaMnLowSulpDoilCsmQty
	 */
	public String getSeaMnLowSulpDoilCsmQty() {
		return this.seaMnLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return depMidDrftHgt
	 */
	public String getDepMidDrftHgt() {
		return this.depMidDrftHgt;
	}
	
	/**
	 * Column Info
	 * @return arrMnFoilCsmQty
	 */
	public String getArrMnFoilCsmQty() {
		return this.arrMnFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return nxtFrshWtrWgt
	 */
	public String getNxtFrshWtrWgt() {
		return this.nxtFrshWtrWgt;
	}
	
	/**
	 * Column Info
	 * @return avgSpd
	 */
	public String getAvgSpd() {
		return this.avgSpd;
	}
	
	/**
	 * Column Info
	 * @return depArrPltMgnMnts
	 */
	public String getDepArrPltMgnMnts() {
		return this.depArrPltMgnMnts;
	}
	
	/**
	 * Column Info
	 * @return seaDetRsnHrs3
	 */
	public String getSeaDetRsnHrs3() {
		return this.seaDetRsnHrs3;
	}
	
	/**
	 * Column Info
	 * @return depRpmPwr
	 */
	public String getDepRpmPwr() {
		return this.depRpmPwr;
	}
	
	/**
	 * Column Info
	 * @return seaDetRsnHrs2
	 */
	public String getSeaDetRsnHrs2() {
		return this.seaDetRsnHrs2;
	}
	
	/**
	 * Column Info
	 * @return seaDetRsnHrs1
	 */
	public String getSeaDetRsnHrs1() {
		return this.seaDetRsnHrs1;
	}
	

	/**
	 * Column Info
	 * @param splLowSulpFoilActWgt
	 */
	public void setSplLowSulpFoilActWgt(String splLowSulpFoilActWgt) {
		this.splLowSulpFoilActWgt = splLowSulpFoilActWgt;
	}
	
	/**
	 * Column Info
	 * @param pltInDt
	 */
	public void setPltInDt(String pltInDt) {
		this.pltInDt = pltInDt;
	}
	
	/**
	 * Column Info
	 * @param seaBlrDoilCsmQty
	 */
	public void setSeaBlrDoilCsmQty(String seaBlrDoilCsmQty) {
		this.seaBlrDoilCsmQty = seaBlrDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param seaDnst
	 */
	public void setSeaDnst(String seaDnst) {
		this.seaDnst = seaDnst;
	}
	
	/**
	 * Column Info
	 * @param seaDetRsnCd1
	 */
	public void setSeaDetRsnCd1(String seaDetRsnCd1) {
		this.seaDetRsnCd1 = seaDetRsnCd1;
	}
	
	/**
	 * Column Info
	 * @param lstRfCntrObrdKntCtnt
	 */
	public void setLstRfCntrObrdKntCtnt(String lstRfCntrObrdKntCtnt) {
		this.lstRfCntrObrdKntCtnt = lstRfCntrObrdKntCtnt;
	}
	
	/**
	 * Column Info
	 * @param arrBlrLowSulpFoilCsmQty
	 */
	public void setArrBlrLowSulpFoilCsmQty(String arrBlrLowSulpFoilCsmQty) {
		this.arrBlrLowSulpFoilCsmQty = arrBlrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param seaDetRsnCd3
	 */
	public void setSeaDetRsnCd3(String seaDetRsnCd3) {
		this.seaDetRsnCd3 = seaDetRsnCd3;
	}
	
	/**
	 * Column Info
	 * @param bfrBrthAnkDrpDt
	 */
	public void setBfrBrthAnkDrpDt(String bfrBrthAnkDrpDt) {
		this.bfrBrthAnkDrpDt = bfrBrthAnkDrpDt;
	}
	
	/**
	 * Column Info
	 * @param nxtLowSulpDoilWgt
	 */
	public void setNxtLowSulpDoilWgt(String nxtLowSulpDoilWgt) {
		this.nxtLowSulpDoilWgt = nxtLowSulpDoilWgt;
	}
	
	/**
	 * Column Info
	 * @param seaDetRsnCd2
	 */
	public void setSeaDetRsnCd2(String seaDetRsnCd2) {
		this.seaDetRsnCd2 = seaDetRsnCd2;
	}
	
	/**
	 * Column Info
	 * @param foSlgWgt
	 */
	public void setFoSlgWgt(String foSlgWgt) {
		this.foSlgWgt = foSlgWgt;
	}
	
	/**
	 * Column Info
	 * @param nxtPortCd
	 */
	public void setNxtPortCd(String nxtPortCd) {
		this.nxtPortCd = nxtPortCd;
	}
	
	/**
	 * Column Info
	 * @param arrFoilWgt
	 */
	public void setArrFoilWgt(String arrFoilWgt) {
		this.arrFoilWgt = arrFoilWgt;
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
	 * @param blkCgoTpCd5
	 */
	public void setBlkCgoTpCd5(String blkCgoTpCd5) {
		this.blkCgoTpCd5 = blkCgoTpCd5;
	}
	
	/**
	 * Column Info
	 * @param blkCgoTpCd3
	 */
	public void setBlkCgoTpCd3(String blkCgoTpCd3) {
		this.blkCgoTpCd3 = blkCgoTpCd3;
	}
	
	/**
	 * Column Info
	 * @param nvgtMlDist
	 */
	public void setNvgtMlDist(String nvgtMlDist) {
		this.nvgtMlDist = nvgtMlDist;
	}
	
	/**
	 * Column Info
	 * @param blkCgoTpCd4
	 */
	public void setBlkCgoTpCd4(String blkCgoTpCd4) {
		this.blkCgoTpCd4 = blkCgoTpCd4;
	}
	
	/**
	 * Column Info
	 * @param blkCgoTpCd1
	 */
	public void setBlkCgoTpCd1(String blkCgoTpCd1) {
		this.blkCgoTpCd1 = blkCgoTpCd1;
	}
	
	/**
	 * Column Info
	 * @param depBlstWgt
	 */
	public void setDepBlstWgt(String depBlstWgt) {
		this.depBlstWgt = depBlstWgt;
	}
	
	/**
	 * Column Info
	 * @param blkCgoTpCd2
	 */
	public void setBlkCgoTpCd2(String blkCgoTpCd2) {
		this.blkCgoTpCd2 = blkCgoTpCd2;
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
	 * @param capNm
	 */
	public void setCapNm(String capNm) {
		this.capNm = capNm;
	}
	
	/**
	 * Column Info
	 * @param seaGnrLowSulpFoilCsmQty
	 */
	public void setSeaGnrLowSulpFoilCsmQty(String seaGnrLowSulpFoilCsmQty) {
		this.seaGnrLowSulpFoilCsmQty = seaGnrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param depFoilWgt
	 */
	public void setDepFoilWgt(String depFoilWgt) {
		this.depFoilWgt = depFoilWgt;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpFoilBdrWgt
	 */
	public void setSplLowSulpFoilBdrWgt(String splLowSulpFoilBdrWgt) {
		this.splLowSulpFoilBdrWgt = splLowSulpFoilBdrWgt;
	}
	
	/**
	 * Column Info
	 * @param lstDepDoilCtnt
	 */
	public void setLstDepDoilCtnt(String lstDepDoilCtnt) {
		this.lstDepDoilCtnt = lstDepDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param splFoilActWgt
	 */
	public void setSplFoilActWgt(String splFoilActWgt) {
		this.splFoilActWgt = splFoilActWgt;
	}
	
	/**
	 * Column Info
	 * @param avgRpmPwr
	 */
	public void setAvgRpmPwr(String avgRpmPwr) {
		this.avgRpmPwr = avgRpmPwr;
	}
	
	/**
	 * Column Info
	 * @param nxtDoilWgt
	 */
	public void setNxtDoilWgt(String nxtDoilWgt) {
		this.nxtDoilWgt = nxtDoilWgt;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param lstPortRupDt
	 */
	public void setLstPortRupDt(String lstPortRupDt) {
		this.lstPortRupDt = lstPortRupDt;
	}
	
	/**
	 * Column Info
	 * @param pltOutDt
	 */
	public void setPltOutDt(String pltOutDt) {
		this.pltOutDt = pltOutDt;
	}
	
	/**
	 * Column Info
	 * @param arrGnrLowSulpFoilCsmQty
	 */
	public void setArrGnrLowSulpFoilCsmQty(String arrGnrLowSulpFoilCsmQty) {
		this.arrGnrLowSulpFoilCsmQty = arrGnrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param depRpmUusdTo
	 */
	public void setDepRpmUusdTo(String depRpmUusdTo) {
		this.depRpmUusdTo = depRpmUusdTo;
	}
	
	/**
	 * Column Info
	 * @param depFwddrHgt
	 */
	public void setDepFwddrHgt(String depFwddrHgt) {
		this.depFwddrHgt = depFwddrHgt;
	}
	
	/**
	 * Column Info
	 * @param depGmHgt
	 */
	public void setDepGmHgt(String depGmHgt) {
		this.depGmHgt = depGmHgt;
	}
	
	/**
	 * Column Info
	 * @param incnrSlgWgt
	 */
	public void setIncnrSlgWgt(String incnrSlgWgt) {
		this.incnrSlgWgt = incnrSlgWgt;
	}
	
	/**
	 * Column Info
	 * @param depLat
	 */
	public void setDepLat(String depLat) {
		this.depLat = depLat;
	}
	
	/**
	 * Column Info
	 * @param splFrshWtrActWgt
	 */
	public void setSplFrshWtrActWgt(String splFrshWtrActWgt) {
		this.splFrshWtrActWgt = splFrshWtrActWgt;
	}
	
	/**
	 * Column Info
	 * @param portBlrDoilCsmQty
	 */
	public void setPortBlrDoilCsmQty(String portBlrDoilCsmQty) {
		this.portBlrDoilCsmQty = portBlrDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param depDplWgt
	 */
	public void setDepDplWgt(String depDplWgt) {
		this.depDplWgt = depDplWgt;
	}
	
	/**
	 * Column Info
	 * @param foilPurfDchgItval
	 */
	public void setFoilPurfDchgItval(String foilPurfDchgItval) {
		this.foilPurfDchgItval = foilPurfDchgItval;
	}
	
	/**
	 * Column Info
	 * @param splFoilSulpWgt
	 */
	public void setSplFoilSulpWgt(String splFoilSulpWgt) {
		this.splFoilSulpWgt = splFoilSulpWgt;
	}
	
	/**
	 * Column Info
	 * @param blkDepCgoTtlWgt
	 */
	public void setBlkDepCgoTtlWgt(String blkDepCgoTtlWgt) {
		this.blkDepCgoTtlWgt = blkDepCgoTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param lstDepLowSulpFoilCtnt
	 */
	public void setLstDepLowSulpFoilCtnt(String lstDepLowSulpFoilCtnt) {
		this.lstDepLowSulpFoilCtnt = lstDepLowSulpFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param rmnSdgWgt
	 */
	public void setRmnSdgWgt(String rmnSdgWgt) {
		this.rmnSdgWgt = rmnSdgWgt;
	}
	
	/**
	 * Column Info
	 * @param bfrBrthAnkOffDt
	 */
	public void setBfrBrthAnkOffDt(String bfrBrthAnkOffDt) {
		this.bfrBrthAnkOffDt = bfrBrthAnkOffDt;
	}
	
	/**
	 * Column Info
	 * @param arrLon
	 */
	public void setArrLon(String arrLon) {
		this.arrLon = arrLon;
	}
	
	/**
	 * Column Info
	 * @param rmnAvgSpd
	 */
	public void setRmnAvgSpd(String rmnAvgSpd) {
		this.rmnAvgSpd = rmnAvgSpd;
	}
	
	/**
	 * Column Info
	 * @param blkLodDchgStsCd
	 */
	public void setBlkLodDchgStsCd(String blkLodDchgStsCd) {
		this.blkLodDchgStsCd = blkLodDchgStsCd;
	}
	
	/**
	 * Column Info
	 * @param nxtLowSulpFoilWgt
	 */
	public void setNxtLowSulpFoilWgt(String nxtLowSulpFoilWgt) {
		this.nxtLowSulpFoilWgt = nxtLowSulpFoilWgt;
	}
	
	/**
	 * Column Info
	 * @param dplSlgWgt
	 */
	public void setDplSlgWgt(String dplSlgWgt) {
		this.dplSlgWgt = dplSlgWgt;
	}
	
	/**
	 * Column Info
	 * @param depCgoWgt
	 */
	public void setDepCgoWgt(String depCgoWgt) {
		this.depCgoWgt = depCgoWgt;
	}
	
	/**
	 * Column Info
	 * @param mnvrInMlDist
	 */
	public void setMnvrInMlDist(String mnvrInMlDist) {
		this.mnvrInMlDist = mnvrInMlDist;
	}
	
	/**
	 * Column Info
	 * @param arrBlstWgt
	 */
	public void setArrBlstWgt(String arrBlstWgt) {
		this.arrBlstWgt = arrBlstWgt;
	}
	
	/**
	 * Column Info
	 * @param depDoilWgt
	 */
	public void setDepDoilWgt(String depDoilWgt) {
		this.depDoilWgt = depDoilWgt;
	}
	
	/**
	 * Column Info
	 * @param arrMnLowSulpFoilCsmQty
	 */
	public void setArrMnLowSulpFoilCsmQty(String arrMnLowSulpFoilCsmQty) {
		this.arrMnLowSulpFoilCsmQty = arrMnLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpDoilActWgt
	 */
	public void setSplLowSulpDoilActWgt(String splLowSulpDoilActWgt) {
		this.splLowSulpDoilActWgt = splLowSulpDoilActWgt;
	}
	
	/**
	 * Column Info
	 * @param lstDepFoilCtnt
	 */
	public void setLstDepFoilCtnt(String lstDepFoilCtnt) {
		this.lstDepFoilCtnt = lstDepFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpFoilSulpWgt
	 */
	public void setSplLowSulpFoilSulpWgt(String splLowSulpFoilSulpWgt) {
		this.splLowSulpFoilSulpWgt = splLowSulpFoilSulpWgt;
	}
	
	/**
	 * Column Info
	 * @param arrLowSulpDoilWgt
	 */
	public void setArrLowSulpDoilWgt(String arrLowSulpDoilWgt) {
		this.arrLowSulpDoilWgt = arrLowSulpDoilWgt;
	}
	
	/**
	 * Column Info
	 * @param splDoilActWgt
	 */
	public void setSplDoilActWgt(String splDoilActWgt) {
		this.splDoilActWgt = splDoilActWgt;
	}
	
	/**
	 * Column Info
	 * @param ttlSlgWgt
	 */
	public void setTtlSlgWgt(String ttlSlgWgt) {
		this.ttlSlgWgt = ttlSlgWgt;
	}
	
	/**
	 * Column Info
	 * @param arrEngMl
	 */
	public void setArrEngMl(String arrEngMl) {
		this.arrEngMl = arrEngMl;
	}
	
	/**
	 * Column Info
	 * @param rupDt
	 */
	public void setRupDt(String rupDt) {
		this.rupDt = rupDt;
	}
	
	/**
	 * Column Info
	 * @param sbEngDt
	 */
	public void setSbEngDt(String sbEngDt) {
		this.sbEngDt = sbEngDt;
	}
	
	/**
	 * Column Info
	 * @param portMnLowSulpFoilCsmQty
	 */
	public void setPortMnLowSulpFoilCsmQty(String portMnLowSulpFoilCsmQty) {
		this.portMnLowSulpFoilCsmQty = portMnLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param cgoWrkEndDt
	 */
	public void setCgoWrkEndDt(String cgoWrkEndDt) {
		this.cgoWrkEndDt = cgoWrkEndDt;
	}
	
	/**
	 * Column Info
	 * @param arrAftdrHgt
	 */
	public void setArrAftdrHgt(String arrAftdrHgt) {
		this.arrAftdrHgt = arrAftdrHgt;
	}
	
	/**
	 * Column Info
	 * @param depLowSulpDoilWgt
	 */
	public void setDepLowSulpDoilWgt(String depLowSulpDoilWgt) {
		this.depLowSulpDoilWgt = depLowSulpDoilWgt;
	}
	
	/**
	 * Column Info
	 * @param depAftdrHgt
	 */
	public void setDepAftdrHgt(String depAftdrHgt) {
		this.depAftdrHgt = depAftdrHgt;
	}
	
	/**
	 * Column Info
	 * @param seaGnrLowSulpDoilCsmQty
	 */
	public void setSeaGnrLowSulpDoilCsmQty(String seaGnrLowSulpDoilCsmQty) {
		this.seaGnrLowSulpDoilCsmQty = seaGnrLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param portMnFoilCsmQty
	 */
	public void setPortMnFoilCsmQty(String portMnFoilCsmQty) {
		this.portMnFoilCsmQty = portMnFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param arrSailHrs
	 */
	public void setArrSailHrs(String arrSailHrs) {
		this.arrSailHrs = arrSailHrs;
	}
	
	/**
	 * Column Info
	 * @param depLon
	 */
	public void setDepLon(String depLon) {
		this.depLon = depLon;
	}
	
	/**
	 * Column Info
	 * @param nxtMidDrftHgt
	 */
	public void setNxtMidDrftHgt(String nxtMidDrftHgt) {
		this.nxtMidDrftHgt = nxtMidDrftHgt;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param rfCntrDchgKnt
	 */
	public void setRfCntrDchgKnt(String rfCntrDchgKnt) {
		this.rfCntrDchgKnt = rfCntrDchgKnt;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param rfCntrObrdKnt
	 */
	public void setRfCntrObrdKnt(String rfCntrObrdKnt) {
		this.rfCntrObrdKnt = rfCntrObrdKnt;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpDoilSulpWgt
	 */
	public void setSplLowSulpDoilSulpWgt(String splLowSulpDoilSulpWgt) {
		this.splLowSulpDoilSulpWgt = splLowSulpDoilSulpWgt;
	}
	
	/**
	 * Column Info
	 * @param depLowSulpFoilWgt
	 */
	public void setDepLowSulpFoilWgt(String depLowSulpFoilWgt) {
		this.depLowSulpFoilWgt = depLowSulpFoilWgt;
	}
	
	/**
	 * Column Info
	 * @param depArrPltMgnHrs
	 */
	public void setDepArrPltMgnHrs(String depArrPltMgnHrs) {
		this.depArrPltMgnHrs = depArrPltMgnHrs;
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
	 * @param seaBlrLowSulpDoilCsmQty
	 */
	public void setSeaBlrLowSulpDoilCsmQty(String seaBlrLowSulpDoilCsmQty) {
		this.seaBlrLowSulpDoilCsmQty = seaBlrLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param splDoilBrgWgt1
	 */
	public void setSplDoilBrgWgt1(String splDoilBrgWgt1) {
		this.splDoilBrgWgt1 = splDoilBrgWgt1;
	}
	
	/**
	 * Column Info
	 * @param aftUnbrthAnkOffDt
	 */
	public void setAftUnbrthAnkOffDt(String aftUnbrthAnkOffDt) {
		this.aftUnbrthAnkOffDt = aftUnbrthAnkOffDt;
	}
	
	/**
	 * Column Info
	 * @param lstDepPortCd
	 */
	public void setLstDepPortCd(String lstDepPortCd) {
		this.lstDepPortCd = lstDepPortCd;
	}
	
	/**
	 * Column Info
	 * @param nxtBlstWgt
	 */
	public void setNxtBlstWgt(String nxtBlstWgt) {
		this.nxtBlstWgt = nxtBlstWgt;
	}
	
	/**
	 * Column Info
	 * @param seaMnLowSulpFoilCsmQty
	 */
	public void setSeaMnLowSulpFoilCsmQty(String seaMnLowSulpFoilCsmQty) {
		this.seaMnLowSulpFoilCsmQty = seaMnLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param depRpmMaxPwr
	 */
	public void setDepRpmMaxPwr(String depRpmMaxPwr) {
		this.depRpmMaxPwr = depRpmMaxPwr;
	}
	
	/**
	 * Column Info
	 * @param rfCntrLodKnt
	 */
	public void setRfCntrLodKnt(String rfCntrLodKnt) {
		this.rfCntrLodKnt = rfCntrLodKnt;
	}
	
	/**
	 * Column Info
	 * @param splDoilBrgWgt2
	 */
	public void setSplDoilBrgWgt2(String splDoilBrgWgt2) {
		this.splDoilBrgWgt2 = splDoilBrgWgt2;
	}
	
	/**
	 * Column Info
	 * @param cgoWrkStDt
	 */
	public void setCgoWrkStDt(String cgoWrkStDt) {
		this.cgoWrkStDt = cgoWrkStDt;
	}
	
	/**
	 * Column Info
	 * @param aftUnbrthAnkDrpDt
	 */
	public void setAftUnbrthAnkDrpDt(String aftUnbrthAnkDrpDt) {
		this.aftUnbrthAnkDrpDt = aftUnbrthAnkDrpDt;
	}
	
	/**
	 * Column Info
	 * @param portDetRsnHrs1
	 */
	public void setPortDetRsnHrs1(String portDetRsnHrs1) {
		this.portDetRsnHrs1 = portDetRsnHrs1;
	}
	
	/**
	 * Column Info
	 * @param arrFrshWtrWgt
	 */
	public void setArrFrshWtrWgt(String arrFrshWtrWgt) {
		this.arrFrshWtrWgt = arrFrshWtrWgt;
	}
	
	/**
	 * Column Info
	 * @param nxtGmHgt
	 */
	public void setNxtGmHgt(String nxtGmHgt) {
		this.nxtGmHgt = nxtGmHgt;
	}
	
	/**
	 * Column Info
	 * @param seaGnrDoilCsmQty
	 */
	public void setSeaGnrDoilCsmQty(String seaGnrDoilCsmQty) {
		this.seaGnrDoilCsmQty = seaGnrDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param portDetRsnHrs2
	 */
	public void setPortDetRsnHrs2(String portDetRsnHrs2) {
		this.portDetRsnHrs2 = portDetRsnHrs2;
	}
	
	/**
	 * Column Info
	 * @param portDetRsnHrs3
	 */
	public void setPortDetRsnHrs3(String portDetRsnHrs3) {
		this.portDetRsnHrs3 = portDetRsnHrs3;
	}
	
	/**
	 * Column Info
	 * @param depRpmMinPwr
	 */
	public void setDepRpmMinPwr(String depRpmMinPwr) {
		this.depRpmMinPwr = depRpmMinPwr;
	}
	
	/**
	 * Column Info
	 * @param arrDoilCsmQty
	 */
	public void setArrDoilCsmQty(String arrDoilCsmQty) {
		this.arrDoilCsmQty = arrDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param mnvrOutMlDist
	 */
	public void setMnvrOutMlDist(String mnvrOutMlDist) {
		this.mnvrOutMlDist = mnvrOutMlDist;
	}
	
	/**
	 * Column Info
	 * @param mtyCntrObrdTeu
	 */
	public void setMtyCntrObrdTeu(String mtyCntrObrdTeu) {
		this.mtyCntrObrdTeu = mtyCntrObrdTeu;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpDoilBdrWgt
	 */
	public void setSplLowSulpDoilBdrWgt(String splLowSulpDoilBdrWgt) {
		this.splLowSulpDoilBdrWgt = splLowSulpDoilBdrWgt;
	}
	
	/**
	 * Column Info
	 * @param arrLowSulpDoilCsmQty
	 */
	public void setArrLowSulpDoilCsmQty(String arrLowSulpDoilCsmQty) {
		this.arrLowSulpDoilCsmQty = arrLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param portGnrLowSulpFoilCsmQty
	 */
	public void setPortGnrLowSulpFoilCsmQty(String portGnrLowSulpFoilCsmQty) {
		this.portGnrLowSulpFoilCsmQty = portGnrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param arrMidDrftHgt
	 */
	public void setArrMidDrftHgt(String arrMidDrftHgt) {
		this.arrMidDrftHgt = arrMidDrftHgt;
	}
	
	/**
	 * Column Info
	 * @param arrNvgtMl
	 */
	public void setArrNvgtMl(String arrNvgtMl) {
		this.arrNvgtMl = arrNvgtMl;
	}
	
	/**
	 * Column Info
	 * @param arrFwddrHgt
	 */
	public void setArrFwddrHgt(String arrFwddrHgt) {
		this.arrFwddrHgt = arrFwddrHgt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param gmtTdHrs
	 */
	public void setGmtTdHrs(String gmtTdHrs) {
		this.gmtTdHrs = gmtTdHrs;
	}
	
	/**
	 * Column Info
	 * @param portBlrFoilCsmQty
	 */
	public void setPortBlrFoilCsmQty(String portBlrFoilCsmQty) {
		this.portBlrFoilCsmQty = portBlrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param arrGnrFoilCsmQty
	 */
	public void setArrGnrFoilCsmQty(String arrGnrFoilCsmQty) {
		this.arrGnrFoilCsmQty = arrGnrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param depRmk
	 */
	public void setDepRmk(String depRmk) {
		this.depRmk = depRmk;
	}
	
	/**
	 * Column Info
	 * @param portMnLowSulpDoilCsmQty
	 */
	public void setPortMnLowSulpDoilCsmQty(String portMnLowSulpDoilCsmQty) {
		this.portMnLowSulpDoilCsmQty = portMnLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param rmnDist
	 */
	public void setRmnDist(String rmnDist) {
		this.rmnDist = rmnDist;
	}
	
	/**
	 * Column Info
	 * @param arrRpmPwr
	 */
	public void setArrRpmPwr(String arrRpmPwr) {
		this.arrRpmPwr = arrRpmPwr;
	}
	
	/**
	 * Column Info
	 * @param seaGnrFoilCsmQty
	 */
	public void setSeaGnrFoilCsmQty(String seaGnrFoilCsmQty) {
		this.seaGnrFoilCsmQty = seaGnrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param engMlDist
	 */
	public void setEngMlDist(String engMlDist) {
		this.engMlDist = engMlDist;
	}
	
	/**
	 * Column Info
	 * @param cntrDznCapa
	 */
	public void setCntrDznCapa(String cntrDznCapa) {
		this.cntrDznCapa = cntrDznCapa;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param splFoilBrgWgt2
	 */
	public void setSplFoilBrgWgt2(String splFoilBrgWgt2) {
		this.splFoilBrgWgt2 = splFoilBrgWgt2;
	}
	
	/**
	 * Column Info
	 * @param portMnDoilCsmQty
	 */
	public void setPortMnDoilCsmQty(String portMnDoilCsmQty) {
		this.portMnDoilCsmQty = portMnDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param splFoilBrgWgt1
	 */
	public void setSplFoilBrgWgt1(String splFoilBrgWgt1) {
		this.splFoilBrgWgt1 = splFoilBrgWgt1;
	}
	
	/**
	 * Column Info
	 * @param cfEngNm
	 */
	public void setCfEngNm(String cfEngNm) {
		this.cfEngNm = cfEngNm;
	}
	
	/**
	 * Column Info
	 * @param blkHldLoadQty6
	 */
	public void setBlkHldLoadQty6(String blkHldLoadQty6) {
		this.blkHldLoadQty6 = blkHldLoadQty6;
	}
	
	/**
	 * Column Info
	 * @param nxtPortEtaDt
	 */
	public void setNxtPortEtaDt(String nxtPortEtaDt) {
		this.nxtPortEtaDt = nxtPortEtaDt;
	}
	
	/**
	 * Column Info
	 * @param blkHldLoadQty5
	 */
	public void setBlkHldLoadQty5(String blkHldLoadQty5) {
		this.blkHldLoadQty5 = blkHldLoadQty5;
	}
	
	/**
	 * Column Info
	 * @param blkHldLoadQty8
	 */
	public void setBlkHldLoadQty8(String blkHldLoadQty8) {
		this.blkHldLoadQty8 = blkHldLoadQty8;
	}
	
	/**
	 * Column Info
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param blkHldLoadQty7
	 */
	public void setBlkHldLoadQty7(String blkHldLoadQty7) {
		this.blkHldLoadQty7 = blkHldLoadQty7;
	}
	
	/**
	 * Column Info
	 * @param blkHldLoadQty2
	 */
	public void setBlkHldLoadQty2(String blkHldLoadQty2) {
		this.blkHldLoadQty2 = blkHldLoadQty2;
	}
	
	/**
	 * Column Info
	 * @param blkHldLoadQty1
	 */
	public void setBlkHldLoadQty1(String blkHldLoadQty1) {
		this.blkHldLoadQty1 = blkHldLoadQty1;
	}
	
	/**
	 * Column Info
	 * @param blkHldLoadQty4
	 */
	public void setBlkHldLoadQty4(String blkHldLoadQty4) {
		this.blkHldLoadQty4 = blkHldLoadQty4;
	}
	
	/**
	 * Column Info
	 * @param blkHldLoadQty3
	 */
	public void setBlkHldLoadQty3(String blkHldLoadQty3) {
		this.blkHldLoadQty3 = blkHldLoadQty3;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param portBlrLowSulpFoilCsmQty
	 */
	public void setPortBlrLowSulpFoilCsmQty(String portBlrLowSulpFoilCsmQty) {
		this.portBlrLowSulpFoilCsmQty = portBlrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param portGnrDoilCsmQty
	 */
	public void setPortGnrDoilCsmQty(String portGnrDoilCsmQty) {
		this.portGnrDoilCsmQty = portGnrDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param arrLowSulpFoilWgt
	 */
	public void setArrLowSulpFoilWgt(String arrLowSulpFoilWgt) {
		this.arrLowSulpFoilWgt = arrLowSulpFoilWgt;
	}
	
	/**
	 * Column Info
	 * @param depFrshWtrWgt
	 */
	public void setDepFrshWtrWgt(String depFrshWtrWgt) {
		this.depFrshWtrWgt = depFrshWtrWgt;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpDoilBrgWgt1
	 */
	public void setSplLowSulpDoilBrgWgt1(String splLowSulpDoilBrgWgt1) {
		this.splLowSulpDoilBrgWgt1 = splLowSulpDoilBrgWgt1;
	}
	
	/**
	 * Column Info
	 * @param depStsCd
	 */
	public void setDepStsCd(String depStsCd) {
		this.depStsCd = depStsCd;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpDoilBrgWgt2
	 */
	public void setSplLowSulpDoilBrgWgt2(String splLowSulpDoilBrgWgt2) {
		this.splLowSulpDoilBrgWgt2 = splLowSulpDoilBrgWgt2;
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
	 * @param blkHldLoadQty9
	 */
	public void setBlkHldLoadQty9(String blkHldLoadQty9) {
		this.blkHldLoadQty9 = blkHldLoadQty9;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpFoilBrgWgt2
	 */
	public void setSplLowSulpFoilBrgWgt2(String splLowSulpFoilBrgWgt2) {
		this.splLowSulpFoilBrgWgt2 = splLowSulpFoilBrgWgt2;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpFoilBrgWgt1
	 */
	public void setSplLowSulpFoilBrgWgt1(String splLowSulpFoilBrgWgt1) {
		this.splLowSulpFoilBrgWgt1 = splLowSulpFoilBrgWgt1;
	}
	
	/**
	 * Column Info
	 * @param seaBlrFoilCsmQty
	 */
	public void setSeaBlrFoilCsmQty(String seaBlrFoilCsmQty) {
		this.seaBlrFoilCsmQty = seaBlrFoilCsmQty;
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
	 * @param lstDepLowSulpDoilCtnt
	 */
	public void setLstDepLowSulpDoilCtnt(String lstDepLowSulpDoilCtnt) {
		this.lstDepLowSulpDoilCtnt = lstDepLowSulpDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param splDoilSulpWgt
	 */
	public void setSplDoilSulpWgt(String splDoilSulpWgt) {
		this.splDoilSulpWgt = splDoilSulpWgt;
	}
	
	/**
	 * Column Info
	 * @param arrDoilWgt
	 */
	public void setArrDoilWgt(String arrDoilWgt) {
		this.arrDoilWgt = arrDoilWgt;
	}
	
	/**
	 * Column Info
	 * @param runHrsInHvWe
	 */
	public void setRunHrsInHvWe(String runHrsInHvWe) {
		this.runHrsInHvWe = runHrsInHvWe;
	}
	
	/**
	 * Column Info
	 * @param portDetRsnCd3
	 */
	public void setPortDetRsnCd3(String portDetRsnCd3) {
		this.portDetRsnCd3 = portDetRsnCd3;
	}
	
	/**
	 * Column Info
	 * @param portDetRsnCd2
	 */
	public void setPortDetRsnCd2(String portDetRsnCd2) {
		this.portDetRsnCd2 = portDetRsnCd2;
	}
	
	/**
	 * Column Info
	 * @param portDetRsnCd1
	 */
	public void setPortDetRsnCd1(String portDetRsnCd1) {
		this.portDetRsnCd1 = portDetRsnCd1;
	}
	
	/**
	 * Column Info
	 * @param seaMnFoilCsmQty
	 */
	public void setSeaMnFoilCsmQty(String seaMnFoilCsmQty) {
		this.seaMnFoilCsmQty = seaMnFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param depRpmUusdFm
	 */
	public void setDepRpmUusdFm(String depRpmUusdFm) {
		this.depRpmUusdFm = depRpmUusdFm;
	}
	
	/**
	 * Column Info
	 * @param arrBlrFoilCsmQty
	 */
	public void setArrBlrFoilCsmQty(String arrBlrFoilCsmQty) {
		this.arrBlrFoilCsmQty = arrBlrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param depRsnForMgnTm
	 */
	public void setDepRsnForMgnTm(String depRsnForMgnTm) {
		this.depRsnForMgnTm = depRsnForMgnTm;
	}
	
	/**
	 * Column Info
	 * @param splDoilBdrWgt
	 */
	public void setSplDoilBdrWgt(String splDoilBdrWgt) {
		this.splDoilBdrWgt = splDoilBdrWgt;
	}
	
	/**
	 * Column Info
	 * @param nxtAftdrHgt
	 */
	public void setNxtAftdrHgt(String nxtAftdrHgt) {
		this.nxtAftdrHgt = nxtAftdrHgt;
	}
	
	/**
	 * Column Info
	 * @param nxtFoilWgt
	 */
	public void setNxtFoilWgt(String nxtFoilWgt) {
		this.nxtFoilWgt = nxtFoilWgt;
	}
	
	/**
	 * Column Info
	 * @param ttlCntrObrdTeu
	 */
	public void setTtlCntrObrdTeu(String ttlCntrObrdTeu) {
		this.ttlCntrObrdTeu = ttlCntrObrdTeu;
	}
	
	/**
	 * Column Info
	 * @param nxtFwddrHgt
	 */
	public void setNxtFwddrHgt(String nxtFwddrHgt) {
		this.nxtFwddrHgt = nxtFwddrHgt;
	}
	
	/**
	 * Column Info
	 * @param arrLat
	 */
	public void setArrLat(String arrLat) {
		this.arrLat = arrLat;
	}
	
	/**
	 * Column Info
	 * @param depPortCd
	 */
	public void setDepPortCd(String depPortCd) {
		this.depPortCd = depPortCd;
	}
	
	/**
	 * Column Info
	 * @param fullCntrObrdTeu
	 */
	public void setFullCntrObrdTeu(String fullCntrObrdTeu) {
		this.fullCntrObrdTeu = fullCntrObrdTeu;
	}
	
	/**
	 * Column Info
	 * @param arrGmHgt
	 */
	public void setArrGmHgt(String arrGmHgt) {
		this.arrGmHgt = arrGmHgt;
	}
	
	/**
	 * Column Info
	 * @param portGnrLowSulpDoilCsmQty
	 */
	public void setPortGnrLowSulpDoilCsmQty(String portGnrLowSulpDoilCsmQty) {
		this.portGnrLowSulpDoilCsmQty = portGnrLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param portGnrFoilCsmQty
	 */
	public void setPortGnrFoilCsmQty(String portGnrFoilCsmQty) {
		this.portGnrFoilCsmQty = portGnrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param seaMnDoilCsmQty
	 */
	public void setSeaMnDoilCsmQty(String seaMnDoilCsmQty) {
		this.seaMnDoilCsmQty = seaMnDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param dplSlgSp
	 */
	public void setDplSlgSp(String dplSlgSp) {
		this.dplSlgSp = dplSlgSp;
	}
	
	/**
	 * Column Info
	 * @param splFoilBdrWgt
	 */
	public void setSplFoilBdrWgt(String splFoilBdrWgt) {
		this.splFoilBdrWgt = splFoilBdrWgt;
	}
	
	/**
	 * Column Info
	 * @param portBlrLowSulpDoilCsmQty
	 */
	public void setPortBlrLowSulpDoilCsmQty(String portBlrLowSulpDoilCsmQty) {
		this.portBlrLowSulpDoilCsmQty = portBlrLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param seaBlrLowSulpFoilCsmQty
	 */
	public void setSeaBlrLowSulpFoilCsmQty(String seaBlrLowSulpFoilCsmQty) {
		this.seaBlrLowSulpFoilCsmQty = seaBlrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param seaMnLowSulpDoilCsmQty
	 */
	public void setSeaMnLowSulpDoilCsmQty(String seaMnLowSulpDoilCsmQty) {
		this.seaMnLowSulpDoilCsmQty = seaMnLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param depMidDrftHgt
	 */
	public void setDepMidDrftHgt(String depMidDrftHgt) {
		this.depMidDrftHgt = depMidDrftHgt;
	}
	
	/**
	 * Column Info
	 * @param arrMnFoilCsmQty
	 */
	public void setArrMnFoilCsmQty(String arrMnFoilCsmQty) {
		this.arrMnFoilCsmQty = arrMnFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param nxtFrshWtrWgt
	 */
	public void setNxtFrshWtrWgt(String nxtFrshWtrWgt) {
		this.nxtFrshWtrWgt = nxtFrshWtrWgt;
	}
	
	/**
	 * Column Info
	 * @param avgSpd
	 */
	public void setAvgSpd(String avgSpd) {
		this.avgSpd = avgSpd;
	}
	
	/**
	 * Column Info
	 * @param depArrPltMgnMnts
	 */
	public void setDepArrPltMgnMnts(String depArrPltMgnMnts) {
		this.depArrPltMgnMnts = depArrPltMgnMnts;
	}
	
	/**
	 * Column Info
	 * @param seaDetRsnHrs3
	 */
	public void setSeaDetRsnHrs3(String seaDetRsnHrs3) {
		this.seaDetRsnHrs3 = seaDetRsnHrs3;
	}
	
	/**
	 * Column Info
	 * @param depRpmPwr
	 */
	public void setDepRpmPwr(String depRpmPwr) {
		this.depRpmPwr = depRpmPwr;
	}
	
	/**
	 * Column Info
	 * @param seaDetRsnHrs2
	 */
	public void setSeaDetRsnHrs2(String seaDetRsnHrs2) {
		this.seaDetRsnHrs2 = seaDetRsnHrs2;
	}
	
	/**
	 * Column Info
	 * @param seaDetRsnHrs1
	 */
	public void setSeaDetRsnHrs1(String seaDetRsnHrs1) {
		this.seaDetRsnHrs1 = seaDetRsnHrs1;
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
		setSplLowSulpFoilActWgt(JSPUtil.getParameter(request, prefix + "spl_low_sulp_foil_act_wgt", ""));
		setPltInDt(JSPUtil.getParameter(request, prefix + "plt_in_dt", ""));
		setSeaBlrDoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_blr_doil_csm_qty", ""));
		setSeaDnst(JSPUtil.getParameter(request, prefix + "sea_dnst", ""));
		setSeaDetRsnCd1(JSPUtil.getParameter(request, prefix + "sea_det_rsn_cd1", ""));
		setLstRfCntrObrdKntCtnt(JSPUtil.getParameter(request, prefix + "lst_rf_cntr_obrd_knt_ctnt", ""));
		setArrBlrLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "arr_blr_low_sulp_foil_csm_qty", ""));
		setSeaDetRsnCd3(JSPUtil.getParameter(request, prefix + "sea_det_rsn_cd3", ""));
		setBfrBrthAnkDrpDt(JSPUtil.getParameter(request, prefix + "bfr_brth_ank_drp_dt", ""));
		setNxtLowSulpDoilWgt(JSPUtil.getParameter(request, prefix + "nxt_low_sulp_doil_wgt", ""));
		setSeaDetRsnCd2(JSPUtil.getParameter(request, prefix + "sea_det_rsn_cd2", ""));
		setFoSlgWgt(JSPUtil.getParameter(request, prefix + "fo_slg_wgt", ""));
		setNxtPortCd(JSPUtil.getParameter(request, prefix + "nxt_port_cd", ""));
		setArrFoilWgt(JSPUtil.getParameter(request, prefix + "arr_foil_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBlkCgoTpCd5(JSPUtil.getParameter(request, prefix + "blk_cgo_tp_cd5", ""));
		setBlkCgoTpCd3(JSPUtil.getParameter(request, prefix + "blk_cgo_tp_cd3", ""));
		setNvgtMlDist(JSPUtil.getParameter(request, prefix + "nvgt_ml_dist", ""));
		setBlkCgoTpCd4(JSPUtil.getParameter(request, prefix + "blk_cgo_tp_cd4", ""));
		setBlkCgoTpCd1(JSPUtil.getParameter(request, prefix + "blk_cgo_tp_cd1", ""));
		setDepBlstWgt(JSPUtil.getParameter(request, prefix + "dep_blst_wgt", ""));
		setBlkCgoTpCd2(JSPUtil.getParameter(request, prefix + "blk_cgo_tp_cd2", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCapNm(JSPUtil.getParameter(request, prefix + "cap_nm", ""));
		setSeaGnrLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_gnr_low_sulp_foil_csm_qty", ""));
		setDepFoilWgt(JSPUtil.getParameter(request, prefix + "dep_foil_wgt", ""));
		setSplLowSulpFoilBdrWgt(JSPUtil.getParameter(request, prefix + "spl_low_sulp_foil_bdr_wgt", ""));
		setLstDepDoilCtnt(JSPUtil.getParameter(request, prefix + "lst_dep_doil_ctnt", ""));
		setSplFoilActWgt(JSPUtil.getParameter(request, prefix + "spl_foil_act_wgt", ""));
		setAvgRpmPwr(JSPUtil.getParameter(request, prefix + "avg_rpm_pwr", ""));
		setNxtDoilWgt(JSPUtil.getParameter(request, prefix + "nxt_doil_wgt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setLstPortRupDt(JSPUtil.getParameter(request, prefix + "lst_port_rup_dt", ""));
		setPltOutDt(JSPUtil.getParameter(request, prefix + "plt_out_dt", ""));
		setArrGnrLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "arr_gnr_low_sulp_foil_csm_qty", ""));
		setDepRpmUusdTo(JSPUtil.getParameter(request, prefix + "dep_rpm_uusd_to", ""));
		setDepFwddrHgt(JSPUtil.getParameter(request, prefix + "dep_fwddr_hgt", ""));
		setDepGmHgt(JSPUtil.getParameter(request, prefix + "dep_gm_hgt", ""));
		setIncnrSlgWgt(JSPUtil.getParameter(request, prefix + "incnr_slg_wgt", ""));
		setDepLat(JSPUtil.getParameter(request, prefix + "dep_lat", ""));
		setSplFrshWtrActWgt(JSPUtil.getParameter(request, prefix + "spl_frsh_wtr_act_wgt", ""));
		setPortBlrDoilCsmQty(JSPUtil.getParameter(request, prefix + "port_blr_doil_csm_qty", ""));
		setDepDplWgt(JSPUtil.getParameter(request, prefix + "dep_dpl_wgt", ""));
		setFoilPurfDchgItval(JSPUtil.getParameter(request, prefix + "foil_purf_dchg_itval", ""));
		setSplFoilSulpWgt(JSPUtil.getParameter(request, prefix + "spl_foil_sulp_wgt", ""));
		setBlkDepCgoTtlWgt(JSPUtil.getParameter(request, prefix + "blk_dep_cgo_ttl_wgt", ""));
		setLstDepLowSulpFoilCtnt(JSPUtil.getParameter(request, prefix + "lst_dep_low_sulp_foil_ctnt", ""));
		setRmnSdgWgt(JSPUtil.getParameter(request, prefix + "rmn_sdg_wgt", ""));
		setBfrBrthAnkOffDt(JSPUtil.getParameter(request, prefix + "bfr_brth_ank_off_dt", ""));
		setArrLon(JSPUtil.getParameter(request, prefix + "arr_lon", ""));
		setRmnAvgSpd(JSPUtil.getParameter(request, prefix + "rmn_avg_spd", ""));
		setBlkLodDchgStsCd(JSPUtil.getParameter(request, prefix + "blk_lod_dchg_sts_cd", ""));
		setNxtLowSulpFoilWgt(JSPUtil.getParameter(request, prefix + "nxt_low_sulp_foil_wgt", ""));
		setDplSlgWgt(JSPUtil.getParameter(request, prefix + "dpl_slg_wgt", ""));
		setDepCgoWgt(JSPUtil.getParameter(request, prefix + "dep_cgo_wgt", ""));
		setMnvrInMlDist(JSPUtil.getParameter(request, prefix + "mnvr_in_ml_dist", ""));
		setArrBlstWgt(JSPUtil.getParameter(request, prefix + "arr_blst_wgt", ""));
		setDepDoilWgt(JSPUtil.getParameter(request, prefix + "dep_doil_wgt", ""));
		setArrMnLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "arr_mn_low_sulp_foil_csm_qty", ""));
		setSplLowSulpDoilActWgt(JSPUtil.getParameter(request, prefix + "spl_low_sulp_doil_act_wgt", ""));
		setLstDepFoilCtnt(JSPUtil.getParameter(request, prefix + "lst_dep_foil_ctnt", ""));
		setSplLowSulpFoilSulpWgt(JSPUtil.getParameter(request, prefix + "spl_low_sulp_foil_sulp_wgt", ""));
		setArrLowSulpDoilWgt(JSPUtil.getParameter(request, prefix + "arr_low_sulp_doil_wgt", ""));
		setSplDoilActWgt(JSPUtil.getParameter(request, prefix + "spl_doil_act_wgt", ""));
		setTtlSlgWgt(JSPUtil.getParameter(request, prefix + "ttl_slg_wgt", ""));
		setArrEngMl(JSPUtil.getParameter(request, prefix + "arr_eng_ml", ""));
		setRupDt(JSPUtil.getParameter(request, prefix + "rup_dt", ""));
		setSbEngDt(JSPUtil.getParameter(request, prefix + "sb_eng_dt", ""));
		setPortMnLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "port_mn_low_sulp_foil_csm_qty", ""));
		setCgoWrkEndDt(JSPUtil.getParameter(request, prefix + "cgo_wrk_end_dt", ""));
		setArrAftdrHgt(JSPUtil.getParameter(request, prefix + "arr_aftdr_hgt", ""));
		setDepLowSulpDoilWgt(JSPUtil.getParameter(request, prefix + "dep_low_sulp_doil_wgt", ""));
		setDepAftdrHgt(JSPUtil.getParameter(request, prefix + "dep_aftdr_hgt", ""));
		setSeaGnrLowSulpDoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_gnr_low_sulp_doil_csm_qty", ""));
		setPortMnFoilCsmQty(JSPUtil.getParameter(request, prefix + "port_mn_foil_csm_qty", ""));
		setArrSailHrs(JSPUtil.getParameter(request, prefix + "arr_sail_hrs", ""));
		setDepLon(JSPUtil.getParameter(request, prefix + "dep_lon", ""));
		setNxtMidDrftHgt(JSPUtil.getParameter(request, prefix + "nxt_mid_drft_hgt", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setRfCntrDchgKnt(JSPUtil.getParameter(request, prefix + "rf_cntr_dchg_knt", ""));
		setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));
		setRfCntrObrdKnt(JSPUtil.getParameter(request, prefix + "rf_cntr_obrd_knt", ""));
		setSplLowSulpDoilSulpWgt(JSPUtil.getParameter(request, prefix + "spl_low_sulp_doil_sulp_wgt", ""));
		setDepLowSulpFoilWgt(JSPUtil.getParameter(request, prefix + "dep_low_sulp_foil_wgt", ""));
		setDepArrPltMgnHrs(JSPUtil.getParameter(request, prefix + "dep_arr_plt_mgn_hrs", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setSeaBlrLowSulpDoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_blr_low_sulp_doil_csm_qty", ""));
		setSplDoilBrgWgt1(JSPUtil.getParameter(request, prefix + "spl_doil_brg_wgt1", ""));
		setAftUnbrthAnkOffDt(JSPUtil.getParameter(request, prefix + "aft_unbrth_ank_off_dt", ""));
		setLstDepPortCd(JSPUtil.getParameter(request, prefix + "lst_dep_port_cd", ""));
		setNxtBlstWgt(JSPUtil.getParameter(request, prefix + "nxt_blst_wgt", ""));
		setSeaMnLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_mn_low_sulp_foil_csm_qty", ""));
		setDepRpmMaxPwr(JSPUtil.getParameter(request, prefix + "dep_rpm_max_pwr", ""));
		setRfCntrLodKnt(JSPUtil.getParameter(request, prefix + "rf_cntr_lod_knt", ""));
		setSplDoilBrgWgt2(JSPUtil.getParameter(request, prefix + "spl_doil_brg_wgt2", ""));
		setCgoWrkStDt(JSPUtil.getParameter(request, prefix + "cgo_wrk_st_dt", ""));
		setAftUnbrthAnkDrpDt(JSPUtil.getParameter(request, prefix + "aft_unbrth_ank_drp_dt", ""));
		setPortDetRsnHrs1(JSPUtil.getParameter(request, prefix + "port_det_rsn_hrs1", ""));
		setArrFrshWtrWgt(JSPUtil.getParameter(request, prefix + "arr_frsh_wtr_wgt", ""));
		setNxtGmHgt(JSPUtil.getParameter(request, prefix + "nxt_gm_hgt", ""));
		setSeaGnrDoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_gnr_doil_csm_qty", ""));
		setPortDetRsnHrs2(JSPUtil.getParameter(request, prefix + "port_det_rsn_hrs2", ""));
		setPortDetRsnHrs3(JSPUtil.getParameter(request, prefix + "port_det_rsn_hrs3", ""));
		setDepRpmMinPwr(JSPUtil.getParameter(request, prefix + "dep_rpm_min_pwr", ""));
		setArrDoilCsmQty(JSPUtil.getParameter(request, prefix + "arr_doil_csm_qty", ""));
		setMnvrOutMlDist(JSPUtil.getParameter(request, prefix + "mnvr_out_ml_dist", ""));
		setMtyCntrObrdTeu(JSPUtil.getParameter(request, prefix + "mty_cntr_obrd_teu", ""));
		setSplLowSulpDoilBdrWgt(JSPUtil.getParameter(request, prefix + "spl_low_sulp_doil_bdr_wgt", ""));
		setArrLowSulpDoilCsmQty(JSPUtil.getParameter(request, prefix + "arr_low_sulp_doil_csm_qty", ""));
		setPortGnrLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "port_gnr_low_sulp_foil_csm_qty", ""));
		setArrMidDrftHgt(JSPUtil.getParameter(request, prefix + "arr_mid_drft_hgt", ""));
		setArrNvgtMl(JSPUtil.getParameter(request, prefix + "arr_nvgt_ml", ""));
		setArrFwddrHgt(JSPUtil.getParameter(request, prefix + "arr_fwddr_hgt", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setGmtTdHrs(JSPUtil.getParameter(request, prefix + "gmt_td_hrs", ""));
		setPortBlrFoilCsmQty(JSPUtil.getParameter(request, prefix + "port_blr_foil_csm_qty", ""));
		setArrGnrFoilCsmQty(JSPUtil.getParameter(request, prefix + "arr_gnr_foil_csm_qty", ""));
		setDepRmk(JSPUtil.getParameter(request, prefix + "dep_rmk", ""));
		setPortMnLowSulpDoilCsmQty(JSPUtil.getParameter(request, prefix + "port_mn_low_sulp_doil_csm_qty", ""));
		setRmnDist(JSPUtil.getParameter(request, prefix + "rmn_dist", ""));
		setArrRpmPwr(JSPUtil.getParameter(request, prefix + "arr_rpm_pwr", ""));
		setSeaGnrFoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_gnr_foil_csm_qty", ""));
		setEngMlDist(JSPUtil.getParameter(request, prefix + "eng_ml_dist", ""));
		setCntrDznCapa(JSPUtil.getParameter(request, prefix + "cntr_dzn_capa", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSplFoilBrgWgt2(JSPUtil.getParameter(request, prefix + "spl_foil_brg_wgt2", ""));
		setPortMnDoilCsmQty(JSPUtil.getParameter(request, prefix + "port_mn_doil_csm_qty", ""));
		setSplFoilBrgWgt1(JSPUtil.getParameter(request, prefix + "spl_foil_brg_wgt1", ""));
		setCfEngNm(JSPUtil.getParameter(request, prefix + "cf_eng_nm", ""));
		setBlkHldLoadQty6(JSPUtil.getParameter(request, prefix + "blk_hld_load_qty6", ""));
		setNxtPortEtaDt(JSPUtil.getParameter(request, prefix + "nxt_port_eta_dt", ""));
		setBlkHldLoadQty5(JSPUtil.getParameter(request, prefix + "blk_hld_load_qty5", ""));
		setBlkHldLoadQty8(JSPUtil.getParameter(request, prefix + "blk_hld_load_qty8", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setBlkHldLoadQty7(JSPUtil.getParameter(request, prefix + "blk_hld_load_qty7", ""));
		setBlkHldLoadQty2(JSPUtil.getParameter(request, prefix + "blk_hld_load_qty2", ""));
		setBlkHldLoadQty1(JSPUtil.getParameter(request, prefix + "blk_hld_load_qty1", ""));
		setBlkHldLoadQty4(JSPUtil.getParameter(request, prefix + "blk_hld_load_qty4", ""));
		setBlkHldLoadQty3(JSPUtil.getParameter(request, prefix + "blk_hld_load_qty3", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPortBlrLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "port_blr_low_sulp_foil_csm_qty", ""));
		setPortGnrDoilCsmQty(JSPUtil.getParameter(request, prefix + "port_gnr_doil_csm_qty", ""));
		setArrLowSulpFoilWgt(JSPUtil.getParameter(request, prefix + "arr_low_sulp_foil_wgt", ""));
		setDepFrshWtrWgt(JSPUtil.getParameter(request, prefix + "dep_frsh_wtr_wgt", ""));
		setSplLowSulpDoilBrgWgt1(JSPUtil.getParameter(request, prefix + "spl_low_sulp_doil_brg_wgt1", ""));
		setDepStsCd(JSPUtil.getParameter(request, prefix + "dep_sts_cd", ""));
		setSplLowSulpDoilBrgWgt2(JSPUtil.getParameter(request, prefix + "spl_low_sulp_doil_brg_wgt2", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setBlkHldLoadQty9(JSPUtil.getParameter(request, prefix + "blk_hld_load_qty9", ""));
		setSplLowSulpFoilBrgWgt2(JSPUtil.getParameter(request, prefix + "spl_low_sulp_foil_brg_wgt2", ""));
		setSplLowSulpFoilBrgWgt1(JSPUtil.getParameter(request, prefix + "spl_low_sulp_foil_brg_wgt1", ""));
		setSeaBlrFoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_blr_foil_csm_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLstDepLowSulpDoilCtnt(JSPUtil.getParameter(request, prefix + "lst_dep_low_sulp_doil_ctnt", ""));
		setSplDoilSulpWgt(JSPUtil.getParameter(request, prefix + "spl_doil_sulp_wgt", ""));
		setArrDoilWgt(JSPUtil.getParameter(request, prefix + "arr_doil_wgt", ""));
		setRunHrsInHvWe(JSPUtil.getParameter(request, prefix + "run_hrs_in_hv_we", ""));
		setPortDetRsnCd3(JSPUtil.getParameter(request, prefix + "port_det_rsn_cd3", ""));
		setPortDetRsnCd2(JSPUtil.getParameter(request, prefix + "port_det_rsn_cd2", ""));
		setPortDetRsnCd1(JSPUtil.getParameter(request, prefix + "port_det_rsn_cd1", ""));
		setSeaMnFoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_mn_foil_csm_qty", ""));
		setDepRpmUusdFm(JSPUtil.getParameter(request, prefix + "dep_rpm_uusd_fm", ""));
		setArrBlrFoilCsmQty(JSPUtil.getParameter(request, prefix + "arr_blr_foil_csm_qty", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDepRsnForMgnTm(JSPUtil.getParameter(request, prefix + "dep_rsn_for_mgn_tm", ""));
		setSplDoilBdrWgt(JSPUtil.getParameter(request, prefix + "spl_doil_bdr_wgt", ""));
		setNxtAftdrHgt(JSPUtil.getParameter(request, prefix + "nxt_aftdr_hgt", ""));
		setNxtFoilWgt(JSPUtil.getParameter(request, prefix + "nxt_foil_wgt", ""));
		setTtlCntrObrdTeu(JSPUtil.getParameter(request, prefix + "ttl_cntr_obrd_teu", ""));
		setNxtFwddrHgt(JSPUtil.getParameter(request, prefix + "nxt_fwddr_hgt", ""));
		setArrLat(JSPUtil.getParameter(request, prefix + "arr_lat", ""));
		setDepPortCd(JSPUtil.getParameter(request, prefix + "dep_port_cd", ""));
		setFullCntrObrdTeu(JSPUtil.getParameter(request, prefix + "full_cntr_obrd_teu", ""));
		setArrGmHgt(JSPUtil.getParameter(request, prefix + "arr_gm_hgt", ""));
		setPortGnrLowSulpDoilCsmQty(JSPUtil.getParameter(request, prefix + "port_gnr_low_sulp_doil_csm_qty", ""));
		setPortGnrFoilCsmQty(JSPUtil.getParameter(request, prefix + "port_gnr_foil_csm_qty", ""));
		setSeaMnDoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_mn_doil_csm_qty", ""));
		setDplSlgSp(JSPUtil.getParameter(request, prefix + "dpl_slg_sp", ""));
		setSplFoilBdrWgt(JSPUtil.getParameter(request, prefix + "spl_foil_bdr_wgt", ""));
		setPortBlrLowSulpDoilCsmQty(JSPUtil.getParameter(request, prefix + "port_blr_low_sulp_doil_csm_qty", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setSeaBlrLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_blr_low_sulp_foil_csm_qty", ""));
		setSeaMnLowSulpDoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_mn_low_sulp_doil_csm_qty", ""));
		setDepMidDrftHgt(JSPUtil.getParameter(request, prefix + "dep_mid_drft_hgt", ""));
		setArrMnFoilCsmQty(JSPUtil.getParameter(request, prefix + "arr_mn_foil_csm_qty", ""));
		setNxtFrshWtrWgt(JSPUtil.getParameter(request, prefix + "nxt_frsh_wtr_wgt", ""));
		setAvgSpd(JSPUtil.getParameter(request, prefix + "avg_spd", ""));
		setDepArrPltMgnMnts(JSPUtil.getParameter(request, prefix + "dep_arr_plt_mgn_mnts", ""));
		setSeaDetRsnHrs3(JSPUtil.getParameter(request, prefix + "sea_det_rsn_hrs3", ""));
		setDepRpmPwr(JSPUtil.getParameter(request, prefix + "dep_rpm_pwr", ""));
		setSeaDetRsnHrs2(JSPUtil.getParameter(request, prefix + "sea_det_rsn_hrs2", ""));
		setSeaDetRsnHrs1(JSPUtil.getParameter(request, prefix + "sea_det_rsn_hrs1", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FcmDepRptVO[]
	 */
	public FcmDepRptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FcmDepRptVO[]
	 */
	public FcmDepRptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FcmDepRptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] splLowSulpFoilActWgt = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_foil_act_wgt", length));
			String[] pltInDt = (JSPUtil.getParameter(request, prefix	+ "plt_in_dt", length));
			String[] seaBlrDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_blr_doil_csm_qty", length));
			String[] seaDnst = (JSPUtil.getParameter(request, prefix	+ "sea_dnst", length));
			String[] seaDetRsnCd1 = (JSPUtil.getParameter(request, prefix	+ "sea_det_rsn_cd1", length));
			String[] lstRfCntrObrdKntCtnt = (JSPUtil.getParameter(request, prefix	+ "lst_rf_cntr_obrd_knt_ctnt", length));
			String[] arrBlrLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "arr_blr_low_sulp_foil_csm_qty", length));
			String[] seaDetRsnCd3 = (JSPUtil.getParameter(request, prefix	+ "sea_det_rsn_cd3", length));
			String[] bfrBrthAnkDrpDt = (JSPUtil.getParameter(request, prefix	+ "bfr_brth_ank_drp_dt", length));
			String[] nxtLowSulpDoilWgt = (JSPUtil.getParameter(request, prefix	+ "nxt_low_sulp_doil_wgt", length));
			String[] seaDetRsnCd2 = (JSPUtil.getParameter(request, prefix	+ "sea_det_rsn_cd2", length));
			String[] foSlgWgt = (JSPUtil.getParameter(request, prefix	+ "fo_slg_wgt", length));
			String[] nxtPortCd = (JSPUtil.getParameter(request, prefix	+ "nxt_port_cd", length));
			String[] arrFoilWgt = (JSPUtil.getParameter(request, prefix	+ "arr_foil_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blkCgoTpCd5 = (JSPUtil.getParameter(request, prefix	+ "blk_cgo_tp_cd5", length));
			String[] blkCgoTpCd3 = (JSPUtil.getParameter(request, prefix	+ "blk_cgo_tp_cd3", length));
			String[] nvgtMlDist = (JSPUtil.getParameter(request, prefix	+ "nvgt_ml_dist", length));
			String[] blkCgoTpCd4 = (JSPUtil.getParameter(request, prefix	+ "blk_cgo_tp_cd4", length));
			String[] blkCgoTpCd1 = (JSPUtil.getParameter(request, prefix	+ "blk_cgo_tp_cd1", length));
			String[] depBlstWgt = (JSPUtil.getParameter(request, prefix	+ "dep_blst_wgt", length));
			String[] blkCgoTpCd2 = (JSPUtil.getParameter(request, prefix	+ "blk_cgo_tp_cd2", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] capNm = (JSPUtil.getParameter(request, prefix	+ "cap_nm", length));
			String[] seaGnrLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_gnr_low_sulp_foil_csm_qty", length));
			String[] depFoilWgt = (JSPUtil.getParameter(request, prefix	+ "dep_foil_wgt", length));
			String[] splLowSulpFoilBdrWgt = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_foil_bdr_wgt", length));
			String[] lstDepDoilCtnt = (JSPUtil.getParameter(request, prefix	+ "lst_dep_doil_ctnt", length));
			String[] splFoilActWgt = (JSPUtil.getParameter(request, prefix	+ "spl_foil_act_wgt", length));
			String[] avgRpmPwr = (JSPUtil.getParameter(request, prefix	+ "avg_rpm_pwr", length));
			String[] nxtDoilWgt = (JSPUtil.getParameter(request, prefix	+ "nxt_doil_wgt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] lstPortRupDt = (JSPUtil.getParameter(request, prefix	+ "lst_port_rup_dt", length));
			String[] pltOutDt = (JSPUtil.getParameter(request, prefix	+ "plt_out_dt", length));
			String[] arrGnrLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "arr_gnr_low_sulp_foil_csm_qty", length));
			String[] depRpmUusdTo = (JSPUtil.getParameter(request, prefix	+ "dep_rpm_uusd_to", length));
			String[] depFwddrHgt = (JSPUtil.getParameter(request, prefix	+ "dep_fwddr_hgt", length));
			String[] depGmHgt = (JSPUtil.getParameter(request, prefix	+ "dep_gm_hgt", length));
			String[] incnrSlgWgt = (JSPUtil.getParameter(request, prefix	+ "incnr_slg_wgt", length));
			String[] depLat = (JSPUtil.getParameter(request, prefix	+ "dep_lat", length));
			String[] splFrshWtrActWgt = (JSPUtil.getParameter(request, prefix	+ "spl_frsh_wtr_act_wgt", length));
			String[] portBlrDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_blr_doil_csm_qty", length));
			String[] depDplWgt = (JSPUtil.getParameter(request, prefix	+ "dep_dpl_wgt", length));
			String[] foilPurfDchgItval = (JSPUtil.getParameter(request, prefix	+ "foil_purf_dchg_itval", length));
			String[] splFoilSulpWgt = (JSPUtil.getParameter(request, prefix	+ "spl_foil_sulp_wgt", length));
			String[] blkDepCgoTtlWgt = (JSPUtil.getParameter(request, prefix	+ "blk_dep_cgo_ttl_wgt", length));
			String[] lstDepLowSulpFoilCtnt = (JSPUtil.getParameter(request, prefix	+ "lst_dep_low_sulp_foil_ctnt", length));
			String[] rmnSdgWgt = (JSPUtil.getParameter(request, prefix	+ "rmn_sdg_wgt", length));
			String[] bfrBrthAnkOffDt = (JSPUtil.getParameter(request, prefix	+ "bfr_brth_ank_off_dt", length));
			String[] arrLon = (JSPUtil.getParameter(request, prefix	+ "arr_lon", length));
			String[] rmnAvgSpd = (JSPUtil.getParameter(request, prefix	+ "rmn_avg_spd", length));
			String[] blkLodDchgStsCd = (JSPUtil.getParameter(request, prefix	+ "blk_lod_dchg_sts_cd", length));
			String[] nxtLowSulpFoilWgt = (JSPUtil.getParameter(request, prefix	+ "nxt_low_sulp_foil_wgt", length));
			String[] dplSlgWgt = (JSPUtil.getParameter(request, prefix	+ "dpl_slg_wgt", length));
			String[] depCgoWgt = (JSPUtil.getParameter(request, prefix	+ "dep_cgo_wgt", length));
			String[] mnvrInMlDist = (JSPUtil.getParameter(request, prefix	+ "mnvr_in_ml_dist", length));
			String[] arrBlstWgt = (JSPUtil.getParameter(request, prefix	+ "arr_blst_wgt", length));
			String[] depDoilWgt = (JSPUtil.getParameter(request, prefix	+ "dep_doil_wgt", length));
			String[] arrMnLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "arr_mn_low_sulp_foil_csm_qty", length));
			String[] splLowSulpDoilActWgt = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_doil_act_wgt", length));
			String[] lstDepFoilCtnt = (JSPUtil.getParameter(request, prefix	+ "lst_dep_foil_ctnt", length));
			String[] splLowSulpFoilSulpWgt = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_foil_sulp_wgt", length));
			String[] arrLowSulpDoilWgt = (JSPUtil.getParameter(request, prefix	+ "arr_low_sulp_doil_wgt", length));
			String[] splDoilActWgt = (JSPUtil.getParameter(request, prefix	+ "spl_doil_act_wgt", length));
			String[] ttlSlgWgt = (JSPUtil.getParameter(request, prefix	+ "ttl_slg_wgt", length));
			String[] arrEngMl = (JSPUtil.getParameter(request, prefix	+ "arr_eng_ml", length));
			String[] rupDt = (JSPUtil.getParameter(request, prefix	+ "rup_dt", length));
			String[] sbEngDt = (JSPUtil.getParameter(request, prefix	+ "sb_eng_dt", length));
			String[] portMnLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_mn_low_sulp_foil_csm_qty", length));
			String[] cgoWrkEndDt = (JSPUtil.getParameter(request, prefix	+ "cgo_wrk_end_dt", length));
			String[] arrAftdrHgt = (JSPUtil.getParameter(request, prefix	+ "arr_aftdr_hgt", length));
			String[] depLowSulpDoilWgt = (JSPUtil.getParameter(request, prefix	+ "dep_low_sulp_doil_wgt", length));
			String[] depAftdrHgt = (JSPUtil.getParameter(request, prefix	+ "dep_aftdr_hgt", length));
			String[] seaGnrLowSulpDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_gnr_low_sulp_doil_csm_qty", length));
			String[] portMnFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_mn_foil_csm_qty", length));
			String[] arrSailHrs = (JSPUtil.getParameter(request, prefix	+ "arr_sail_hrs", length));
			String[] depLon = (JSPUtil.getParameter(request, prefix	+ "dep_lon", length));
			String[] nxtMidDrftHgt = (JSPUtil.getParameter(request, prefix	+ "nxt_mid_drft_hgt", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] rfCntrDchgKnt = (JSPUtil.getParameter(request, prefix	+ "rf_cntr_dchg_knt", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] rfCntrObrdKnt = (JSPUtil.getParameter(request, prefix	+ "rf_cntr_obrd_knt", length));
			String[] splLowSulpDoilSulpWgt = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_doil_sulp_wgt", length));
			String[] depLowSulpFoilWgt = (JSPUtil.getParameter(request, prefix	+ "dep_low_sulp_foil_wgt", length));
			String[] depArrPltMgnHrs = (JSPUtil.getParameter(request, prefix	+ "dep_arr_plt_mgn_hrs", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] seaBlrLowSulpDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_blr_low_sulp_doil_csm_qty", length));
			String[] splDoilBrgWgt1 = (JSPUtil.getParameter(request, prefix	+ "spl_doil_brg_wgt1", length));
			String[] aftUnbrthAnkOffDt = (JSPUtil.getParameter(request, prefix	+ "aft_unbrth_ank_off_dt", length));
			String[] lstDepPortCd = (JSPUtil.getParameter(request, prefix	+ "lst_dep_port_cd", length));
			String[] nxtBlstWgt = (JSPUtil.getParameter(request, prefix	+ "nxt_blst_wgt", length));
			String[] seaMnLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_mn_low_sulp_foil_csm_qty", length));
			String[] depRpmMaxPwr = (JSPUtil.getParameter(request, prefix	+ "dep_rpm_max_pwr", length));
			String[] rfCntrLodKnt = (JSPUtil.getParameter(request, prefix	+ "rf_cntr_lod_knt", length));
			String[] splDoilBrgWgt2 = (JSPUtil.getParameter(request, prefix	+ "spl_doil_brg_wgt2", length));
			String[] cgoWrkStDt = (JSPUtil.getParameter(request, prefix	+ "cgo_wrk_st_dt", length));
			String[] aftUnbrthAnkDrpDt = (JSPUtil.getParameter(request, prefix	+ "aft_unbrth_ank_drp_dt", length));
			String[] portDetRsnHrs1 = (JSPUtil.getParameter(request, prefix	+ "port_det_rsn_hrs1", length));
			String[] arrFrshWtrWgt = (JSPUtil.getParameter(request, prefix	+ "arr_frsh_wtr_wgt", length));
			String[] nxtGmHgt = (JSPUtil.getParameter(request, prefix	+ "nxt_gm_hgt", length));
			String[] seaGnrDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_gnr_doil_csm_qty", length));
			String[] portDetRsnHrs2 = (JSPUtil.getParameter(request, prefix	+ "port_det_rsn_hrs2", length));
			String[] portDetRsnHrs3 = (JSPUtil.getParameter(request, prefix	+ "port_det_rsn_hrs3", length));
			String[] depRpmMinPwr = (JSPUtil.getParameter(request, prefix	+ "dep_rpm_min_pwr", length));
			String[] arrDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "arr_doil_csm_qty", length));
			String[] mnvrOutMlDist = (JSPUtil.getParameter(request, prefix	+ "mnvr_out_ml_dist", length));
			String[] mtyCntrObrdTeu = (JSPUtil.getParameter(request, prefix	+ "mty_cntr_obrd_teu", length));
			String[] splLowSulpDoilBdrWgt = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_doil_bdr_wgt", length));
			String[] arrLowSulpDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "arr_low_sulp_doil_csm_qty", length));
			String[] portGnrLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_gnr_low_sulp_foil_csm_qty", length));
			String[] arrMidDrftHgt = (JSPUtil.getParameter(request, prefix	+ "arr_mid_drft_hgt", length));
			String[] arrNvgtMl = (JSPUtil.getParameter(request, prefix	+ "arr_nvgt_ml", length));
			String[] arrFwddrHgt = (JSPUtil.getParameter(request, prefix	+ "arr_fwddr_hgt", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] gmtTdHrs = (JSPUtil.getParameter(request, prefix	+ "gmt_td_hrs", length));
			String[] portBlrFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_blr_foil_csm_qty", length));
			String[] arrGnrFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "arr_gnr_foil_csm_qty", length));
			String[] depRmk = (JSPUtil.getParameter(request, prefix	+ "dep_rmk", length));
			String[] portMnLowSulpDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_mn_low_sulp_doil_csm_qty", length));
			String[] rmnDist = (JSPUtil.getParameter(request, prefix	+ "rmn_dist", length));
			String[] arrRpmPwr = (JSPUtil.getParameter(request, prefix	+ "arr_rpm_pwr", length));
			String[] seaGnrFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_gnr_foil_csm_qty", length));
			String[] engMlDist = (JSPUtil.getParameter(request, prefix	+ "eng_ml_dist", length));
			String[] cntrDznCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_dzn_capa", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] splFoilBrgWgt2 = (JSPUtil.getParameter(request, prefix	+ "spl_foil_brg_wgt2", length));
			String[] portMnDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_mn_doil_csm_qty", length));
			String[] splFoilBrgWgt1 = (JSPUtil.getParameter(request, prefix	+ "spl_foil_brg_wgt1", length));
			String[] cfEngNm = (JSPUtil.getParameter(request, prefix	+ "cf_eng_nm", length));
			String[] blkHldLoadQty6 = (JSPUtil.getParameter(request, prefix	+ "blk_hld_load_qty6", length));
			String[] nxtPortEtaDt = (JSPUtil.getParameter(request, prefix	+ "nxt_port_eta_dt", length));
			String[] blkHldLoadQty5 = (JSPUtil.getParameter(request, prefix	+ "blk_hld_load_qty5", length));
			String[] blkHldLoadQty8 = (JSPUtil.getParameter(request, prefix	+ "blk_hld_load_qty8", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] blkHldLoadQty7 = (JSPUtil.getParameter(request, prefix	+ "blk_hld_load_qty7", length));
			String[] blkHldLoadQty2 = (JSPUtil.getParameter(request, prefix	+ "blk_hld_load_qty2", length));
			String[] blkHldLoadQty1 = (JSPUtil.getParameter(request, prefix	+ "blk_hld_load_qty1", length));
			String[] blkHldLoadQty4 = (JSPUtil.getParameter(request, prefix	+ "blk_hld_load_qty4", length));
			String[] blkHldLoadQty3 = (JSPUtil.getParameter(request, prefix	+ "blk_hld_load_qty3", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] portBlrLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_blr_low_sulp_foil_csm_qty", length));
			String[] portGnrDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_gnr_doil_csm_qty", length));
			String[] arrLowSulpFoilWgt = (JSPUtil.getParameter(request, prefix	+ "arr_low_sulp_foil_wgt", length));
			String[] depFrshWtrWgt = (JSPUtil.getParameter(request, prefix	+ "dep_frsh_wtr_wgt", length));
			String[] splLowSulpDoilBrgWgt1 = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_doil_brg_wgt1", length));
			String[] depStsCd = (JSPUtil.getParameter(request, prefix	+ "dep_sts_cd", length));
			String[] splLowSulpDoilBrgWgt2 = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_doil_brg_wgt2", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] blkHldLoadQty9 = (JSPUtil.getParameter(request, prefix	+ "blk_hld_load_qty9", length));
			String[] splLowSulpFoilBrgWgt2 = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_foil_brg_wgt2", length));
			String[] splLowSulpFoilBrgWgt1 = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_foil_brg_wgt1", length));
			String[] seaBlrFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_blr_foil_csm_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lstDepLowSulpDoilCtnt = (JSPUtil.getParameter(request, prefix	+ "lst_dep_low_sulp_doil_ctnt", length));
			String[] splDoilSulpWgt = (JSPUtil.getParameter(request, prefix	+ "spl_doil_sulp_wgt", length));
			String[] arrDoilWgt = (JSPUtil.getParameter(request, prefix	+ "arr_doil_wgt", length));
			String[] runHrsInHvWe = (JSPUtil.getParameter(request, prefix	+ "run_hrs_in_hv_we", length));
			String[] portDetRsnCd3 = (JSPUtil.getParameter(request, prefix	+ "port_det_rsn_cd3", length));
			String[] portDetRsnCd2 = (JSPUtil.getParameter(request, prefix	+ "port_det_rsn_cd2", length));
			String[] portDetRsnCd1 = (JSPUtil.getParameter(request, prefix	+ "port_det_rsn_cd1", length));
			String[] seaMnFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_mn_foil_csm_qty", length));
			String[] depRpmUusdFm = (JSPUtil.getParameter(request, prefix	+ "dep_rpm_uusd_fm", length));
			String[] arrBlrFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "arr_blr_foil_csm_qty", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] depRsnForMgnTm = (JSPUtil.getParameter(request, prefix	+ "dep_rsn_for_mgn_tm", length));
			String[] splDoilBdrWgt = (JSPUtil.getParameter(request, prefix	+ "spl_doil_bdr_wgt", length));
			String[] nxtAftdrHgt = (JSPUtil.getParameter(request, prefix	+ "nxt_aftdr_hgt", length));
			String[] nxtFoilWgt = (JSPUtil.getParameter(request, prefix	+ "nxt_foil_wgt", length));
			String[] ttlCntrObrdTeu = (JSPUtil.getParameter(request, prefix	+ "ttl_cntr_obrd_teu", length));
			String[] nxtFwddrHgt = (JSPUtil.getParameter(request, prefix	+ "nxt_fwddr_hgt", length));
			String[] arrLat = (JSPUtil.getParameter(request, prefix	+ "arr_lat", length));
			String[] depPortCd = (JSPUtil.getParameter(request, prefix	+ "dep_port_cd", length));
			String[] fullCntrObrdTeu = (JSPUtil.getParameter(request, prefix	+ "full_cntr_obrd_teu", length));
			String[] arrGmHgt = (JSPUtil.getParameter(request, prefix	+ "arr_gm_hgt", length));
			String[] portGnrLowSulpDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_gnr_low_sulp_doil_csm_qty", length));
			String[] portGnrFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_gnr_foil_csm_qty", length));
			String[] seaMnDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_mn_doil_csm_qty", length));
			String[] dplSlgSp = (JSPUtil.getParameter(request, prefix	+ "dpl_slg_sp", length));
			String[] splFoilBdrWgt = (JSPUtil.getParameter(request, prefix	+ "spl_foil_bdr_wgt", length));
			String[] portBlrLowSulpDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_blr_low_sulp_doil_csm_qty", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] seaBlrLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_blr_low_sulp_foil_csm_qty", length));
			String[] seaMnLowSulpDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_mn_low_sulp_doil_csm_qty", length));
			String[] depMidDrftHgt = (JSPUtil.getParameter(request, prefix	+ "dep_mid_drft_hgt", length));
			String[] arrMnFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "arr_mn_foil_csm_qty", length));
			String[] nxtFrshWtrWgt = (JSPUtil.getParameter(request, prefix	+ "nxt_frsh_wtr_wgt", length));
			String[] avgSpd = (JSPUtil.getParameter(request, prefix	+ "avg_spd", length));
			String[] depArrPltMgnMnts = (JSPUtil.getParameter(request, prefix	+ "dep_arr_plt_mgn_mnts", length));
			String[] seaDetRsnHrs3 = (JSPUtil.getParameter(request, prefix	+ "sea_det_rsn_hrs3", length));
			String[] depRpmPwr = (JSPUtil.getParameter(request, prefix	+ "dep_rpm_pwr", length));
			String[] seaDetRsnHrs2 = (JSPUtil.getParameter(request, prefix	+ "sea_det_rsn_hrs2", length));
			String[] seaDetRsnHrs1 = (JSPUtil.getParameter(request, prefix	+ "sea_det_rsn_hrs1", length));
			
			for (int i = 0; i < length; i++) {
				model = new FcmDepRptVO();
				if (splLowSulpFoilActWgt[i] != null)
					model.setSplLowSulpFoilActWgt(splLowSulpFoilActWgt[i]);
				if (pltInDt[i] != null)
					model.setPltInDt(pltInDt[i]);
				if (seaBlrDoilCsmQty[i] != null)
					model.setSeaBlrDoilCsmQty(seaBlrDoilCsmQty[i]);
				if (seaDnst[i] != null)
					model.setSeaDnst(seaDnst[i]);
				if (seaDetRsnCd1[i] != null)
					model.setSeaDetRsnCd1(seaDetRsnCd1[i]);
				if (lstRfCntrObrdKntCtnt[i] != null)
					model.setLstRfCntrObrdKntCtnt(lstRfCntrObrdKntCtnt[i]);
				if (arrBlrLowSulpFoilCsmQty[i] != null)
					model.setArrBlrLowSulpFoilCsmQty(arrBlrLowSulpFoilCsmQty[i]);
				if (seaDetRsnCd3[i] != null)
					model.setSeaDetRsnCd3(seaDetRsnCd3[i]);
				if (bfrBrthAnkDrpDt[i] != null)
					model.setBfrBrthAnkDrpDt(bfrBrthAnkDrpDt[i]);
				if (nxtLowSulpDoilWgt[i] != null)
					model.setNxtLowSulpDoilWgt(nxtLowSulpDoilWgt[i]);
				if (seaDetRsnCd2[i] != null)
					model.setSeaDetRsnCd2(seaDetRsnCd2[i]);
				if (foSlgWgt[i] != null)
					model.setFoSlgWgt(foSlgWgt[i]);
				if (nxtPortCd[i] != null)
					model.setNxtPortCd(nxtPortCd[i]);
				if (arrFoilWgt[i] != null)
					model.setArrFoilWgt(arrFoilWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blkCgoTpCd5[i] != null)
					model.setBlkCgoTpCd5(blkCgoTpCd5[i]);
				if (blkCgoTpCd3[i] != null)
					model.setBlkCgoTpCd3(blkCgoTpCd3[i]);
				if (nvgtMlDist[i] != null)
					model.setNvgtMlDist(nvgtMlDist[i]);
				if (blkCgoTpCd4[i] != null)
					model.setBlkCgoTpCd4(blkCgoTpCd4[i]);
				if (blkCgoTpCd1[i] != null)
					model.setBlkCgoTpCd1(blkCgoTpCd1[i]);
				if (depBlstWgt[i] != null)
					model.setDepBlstWgt(depBlstWgt[i]);
				if (blkCgoTpCd2[i] != null)
					model.setBlkCgoTpCd2(blkCgoTpCd2[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (capNm[i] != null)
					model.setCapNm(capNm[i]);
				if (seaGnrLowSulpFoilCsmQty[i] != null)
					model.setSeaGnrLowSulpFoilCsmQty(seaGnrLowSulpFoilCsmQty[i]);
				if (depFoilWgt[i] != null)
					model.setDepFoilWgt(depFoilWgt[i]);
				if (splLowSulpFoilBdrWgt[i] != null)
					model.setSplLowSulpFoilBdrWgt(splLowSulpFoilBdrWgt[i]);
				if (lstDepDoilCtnt[i] != null)
					model.setLstDepDoilCtnt(lstDepDoilCtnt[i]);
				if (splFoilActWgt[i] != null)
					model.setSplFoilActWgt(splFoilActWgt[i]);
				if (avgRpmPwr[i] != null)
					model.setAvgRpmPwr(avgRpmPwr[i]);
				if (nxtDoilWgt[i] != null)
					model.setNxtDoilWgt(nxtDoilWgt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (lstPortRupDt[i] != null)
					model.setLstPortRupDt(lstPortRupDt[i]);
				if (pltOutDt[i] != null)
					model.setPltOutDt(pltOutDt[i]);
				if (arrGnrLowSulpFoilCsmQty[i] != null)
					model.setArrGnrLowSulpFoilCsmQty(arrGnrLowSulpFoilCsmQty[i]);
				if (depRpmUusdTo[i] != null)
					model.setDepRpmUusdTo(depRpmUusdTo[i]);
				if (depFwddrHgt[i] != null)
					model.setDepFwddrHgt(depFwddrHgt[i]);
				if (depGmHgt[i] != null)
					model.setDepGmHgt(depGmHgt[i]);
				if (incnrSlgWgt[i] != null)
					model.setIncnrSlgWgt(incnrSlgWgt[i]);
				if (depLat[i] != null)
					model.setDepLat(depLat[i]);
				if (splFrshWtrActWgt[i] != null)
					model.setSplFrshWtrActWgt(splFrshWtrActWgt[i]);
				if (portBlrDoilCsmQty[i] != null)
					model.setPortBlrDoilCsmQty(portBlrDoilCsmQty[i]);
				if (depDplWgt[i] != null)
					model.setDepDplWgt(depDplWgt[i]);
				if (foilPurfDchgItval[i] != null)
					model.setFoilPurfDchgItval(foilPurfDchgItval[i]);
				if (splFoilSulpWgt[i] != null)
					model.setSplFoilSulpWgt(splFoilSulpWgt[i]);
				if (blkDepCgoTtlWgt[i] != null)
					model.setBlkDepCgoTtlWgt(blkDepCgoTtlWgt[i]);
				if (lstDepLowSulpFoilCtnt[i] != null)
					model.setLstDepLowSulpFoilCtnt(lstDepLowSulpFoilCtnt[i]);
				if (rmnSdgWgt[i] != null)
					model.setRmnSdgWgt(rmnSdgWgt[i]);
				if (bfrBrthAnkOffDt[i] != null)
					model.setBfrBrthAnkOffDt(bfrBrthAnkOffDt[i]);
				if (arrLon[i] != null)
					model.setArrLon(arrLon[i]);
				if (rmnAvgSpd[i] != null)
					model.setRmnAvgSpd(rmnAvgSpd[i]);
				if (blkLodDchgStsCd[i] != null)
					model.setBlkLodDchgStsCd(blkLodDchgStsCd[i]);
				if (nxtLowSulpFoilWgt[i] != null)
					model.setNxtLowSulpFoilWgt(nxtLowSulpFoilWgt[i]);
				if (dplSlgWgt[i] != null)
					model.setDplSlgWgt(dplSlgWgt[i]);
				if (depCgoWgt[i] != null)
					model.setDepCgoWgt(depCgoWgt[i]);
				if (mnvrInMlDist[i] != null)
					model.setMnvrInMlDist(mnvrInMlDist[i]);
				if (arrBlstWgt[i] != null)
					model.setArrBlstWgt(arrBlstWgt[i]);
				if (depDoilWgt[i] != null)
					model.setDepDoilWgt(depDoilWgt[i]);
				if (arrMnLowSulpFoilCsmQty[i] != null)
					model.setArrMnLowSulpFoilCsmQty(arrMnLowSulpFoilCsmQty[i]);
				if (splLowSulpDoilActWgt[i] != null)
					model.setSplLowSulpDoilActWgt(splLowSulpDoilActWgt[i]);
				if (lstDepFoilCtnt[i] != null)
					model.setLstDepFoilCtnt(lstDepFoilCtnt[i]);
				if (splLowSulpFoilSulpWgt[i] != null)
					model.setSplLowSulpFoilSulpWgt(splLowSulpFoilSulpWgt[i]);
				if (arrLowSulpDoilWgt[i] != null)
					model.setArrLowSulpDoilWgt(arrLowSulpDoilWgt[i]);
				if (splDoilActWgt[i] != null)
					model.setSplDoilActWgt(splDoilActWgt[i]);
				if (ttlSlgWgt[i] != null)
					model.setTtlSlgWgt(ttlSlgWgt[i]);
				if (arrEngMl[i] != null)
					model.setArrEngMl(arrEngMl[i]);
				if (rupDt[i] != null)
					model.setRupDt(rupDt[i]);
				if (sbEngDt[i] != null)
					model.setSbEngDt(sbEngDt[i]);
				if (portMnLowSulpFoilCsmQty[i] != null)
					model.setPortMnLowSulpFoilCsmQty(portMnLowSulpFoilCsmQty[i]);
				if (cgoWrkEndDt[i] != null)
					model.setCgoWrkEndDt(cgoWrkEndDt[i]);
				if (arrAftdrHgt[i] != null)
					model.setArrAftdrHgt(arrAftdrHgt[i]);
				if (depLowSulpDoilWgt[i] != null)
					model.setDepLowSulpDoilWgt(depLowSulpDoilWgt[i]);
				if (depAftdrHgt[i] != null)
					model.setDepAftdrHgt(depAftdrHgt[i]);
				if (seaGnrLowSulpDoilCsmQty[i] != null)
					model.setSeaGnrLowSulpDoilCsmQty(seaGnrLowSulpDoilCsmQty[i]);
				if (portMnFoilCsmQty[i] != null)
					model.setPortMnFoilCsmQty(portMnFoilCsmQty[i]);
				if (arrSailHrs[i] != null)
					model.setArrSailHrs(arrSailHrs[i]);
				if (depLon[i] != null)
					model.setDepLon(depLon[i]);
				if (nxtMidDrftHgt[i] != null)
					model.setNxtMidDrftHgt(nxtMidDrftHgt[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (rfCntrDchgKnt[i] != null)
					model.setRfCntrDchgKnt(rfCntrDchgKnt[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (rfCntrObrdKnt[i] != null)
					model.setRfCntrObrdKnt(rfCntrObrdKnt[i]);
				if (splLowSulpDoilSulpWgt[i] != null)
					model.setSplLowSulpDoilSulpWgt(splLowSulpDoilSulpWgt[i]);
				if (depLowSulpFoilWgt[i] != null)
					model.setDepLowSulpFoilWgt(depLowSulpFoilWgt[i]);
				if (depArrPltMgnHrs[i] != null)
					model.setDepArrPltMgnHrs(depArrPltMgnHrs[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (seaBlrLowSulpDoilCsmQty[i] != null)
					model.setSeaBlrLowSulpDoilCsmQty(seaBlrLowSulpDoilCsmQty[i]);
				if (splDoilBrgWgt1[i] != null)
					model.setSplDoilBrgWgt1(splDoilBrgWgt1[i]);
				if (aftUnbrthAnkOffDt[i] != null)
					model.setAftUnbrthAnkOffDt(aftUnbrthAnkOffDt[i]);
				if (lstDepPortCd[i] != null)
					model.setLstDepPortCd(lstDepPortCd[i]);
				if (nxtBlstWgt[i] != null)
					model.setNxtBlstWgt(nxtBlstWgt[i]);
				if (seaMnLowSulpFoilCsmQty[i] != null)
					model.setSeaMnLowSulpFoilCsmQty(seaMnLowSulpFoilCsmQty[i]);
				if (depRpmMaxPwr[i] != null)
					model.setDepRpmMaxPwr(depRpmMaxPwr[i]);
				if (rfCntrLodKnt[i] != null)
					model.setRfCntrLodKnt(rfCntrLodKnt[i]);
				if (splDoilBrgWgt2[i] != null)
					model.setSplDoilBrgWgt2(splDoilBrgWgt2[i]);
				if (cgoWrkStDt[i] != null)
					model.setCgoWrkStDt(cgoWrkStDt[i]);
				if (aftUnbrthAnkDrpDt[i] != null)
					model.setAftUnbrthAnkDrpDt(aftUnbrthAnkDrpDt[i]);
				if (portDetRsnHrs1[i] != null)
					model.setPortDetRsnHrs1(portDetRsnHrs1[i]);
				if (arrFrshWtrWgt[i] != null)
					model.setArrFrshWtrWgt(arrFrshWtrWgt[i]);
				if (nxtGmHgt[i] != null)
					model.setNxtGmHgt(nxtGmHgt[i]);
				if (seaGnrDoilCsmQty[i] != null)
					model.setSeaGnrDoilCsmQty(seaGnrDoilCsmQty[i]);
				if (portDetRsnHrs2[i] != null)
					model.setPortDetRsnHrs2(portDetRsnHrs2[i]);
				if (portDetRsnHrs3[i] != null)
					model.setPortDetRsnHrs3(portDetRsnHrs3[i]);
				if (depRpmMinPwr[i] != null)
					model.setDepRpmMinPwr(depRpmMinPwr[i]);
				if (arrDoilCsmQty[i] != null)
					model.setArrDoilCsmQty(arrDoilCsmQty[i]);
				if (mnvrOutMlDist[i] != null)
					model.setMnvrOutMlDist(mnvrOutMlDist[i]);
				if (mtyCntrObrdTeu[i] != null)
					model.setMtyCntrObrdTeu(mtyCntrObrdTeu[i]);
				if (splLowSulpDoilBdrWgt[i] != null)
					model.setSplLowSulpDoilBdrWgt(splLowSulpDoilBdrWgt[i]);
				if (arrLowSulpDoilCsmQty[i] != null)
					model.setArrLowSulpDoilCsmQty(arrLowSulpDoilCsmQty[i]);
				if (portGnrLowSulpFoilCsmQty[i] != null)
					model.setPortGnrLowSulpFoilCsmQty(portGnrLowSulpFoilCsmQty[i]);
				if (arrMidDrftHgt[i] != null)
					model.setArrMidDrftHgt(arrMidDrftHgt[i]);
				if (arrNvgtMl[i] != null)
					model.setArrNvgtMl(arrNvgtMl[i]);
				if (arrFwddrHgt[i] != null)
					model.setArrFwddrHgt(arrFwddrHgt[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (gmtTdHrs[i] != null)
					model.setGmtTdHrs(gmtTdHrs[i]);
				if (portBlrFoilCsmQty[i] != null)
					model.setPortBlrFoilCsmQty(portBlrFoilCsmQty[i]);
				if (arrGnrFoilCsmQty[i] != null)
					model.setArrGnrFoilCsmQty(arrGnrFoilCsmQty[i]);
				if (depRmk[i] != null)
					model.setDepRmk(depRmk[i]);
				if (portMnLowSulpDoilCsmQty[i] != null)
					model.setPortMnLowSulpDoilCsmQty(portMnLowSulpDoilCsmQty[i]);
				if (rmnDist[i] != null)
					model.setRmnDist(rmnDist[i]);
				if (arrRpmPwr[i] != null)
					model.setArrRpmPwr(arrRpmPwr[i]);
				if (seaGnrFoilCsmQty[i] != null)
					model.setSeaGnrFoilCsmQty(seaGnrFoilCsmQty[i]);
				if (engMlDist[i] != null)
					model.setEngMlDist(engMlDist[i]);
				if (cntrDznCapa[i] != null)
					model.setCntrDznCapa(cntrDznCapa[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (splFoilBrgWgt2[i] != null)
					model.setSplFoilBrgWgt2(splFoilBrgWgt2[i]);
				if (portMnDoilCsmQty[i] != null)
					model.setPortMnDoilCsmQty(portMnDoilCsmQty[i]);
				if (splFoilBrgWgt1[i] != null)
					model.setSplFoilBrgWgt1(splFoilBrgWgt1[i]);
				if (cfEngNm[i] != null)
					model.setCfEngNm(cfEngNm[i]);
				if (blkHldLoadQty6[i] != null)
					model.setBlkHldLoadQty6(blkHldLoadQty6[i]);
				if (nxtPortEtaDt[i] != null)
					model.setNxtPortEtaDt(nxtPortEtaDt[i]);
				if (blkHldLoadQty5[i] != null)
					model.setBlkHldLoadQty5(blkHldLoadQty5[i]);
				if (blkHldLoadQty8[i] != null)
					model.setBlkHldLoadQty8(blkHldLoadQty8[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (blkHldLoadQty7[i] != null)
					model.setBlkHldLoadQty7(blkHldLoadQty7[i]);
				if (blkHldLoadQty2[i] != null)
					model.setBlkHldLoadQty2(blkHldLoadQty2[i]);
				if (blkHldLoadQty1[i] != null)
					model.setBlkHldLoadQty1(blkHldLoadQty1[i]);
				if (blkHldLoadQty4[i] != null)
					model.setBlkHldLoadQty4(blkHldLoadQty4[i]);
				if (blkHldLoadQty3[i] != null)
					model.setBlkHldLoadQty3(blkHldLoadQty3[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (portBlrLowSulpFoilCsmQty[i] != null)
					model.setPortBlrLowSulpFoilCsmQty(portBlrLowSulpFoilCsmQty[i]);
				if (portGnrDoilCsmQty[i] != null)
					model.setPortGnrDoilCsmQty(portGnrDoilCsmQty[i]);
				if (arrLowSulpFoilWgt[i] != null)
					model.setArrLowSulpFoilWgt(arrLowSulpFoilWgt[i]);
				if (depFrshWtrWgt[i] != null)
					model.setDepFrshWtrWgt(depFrshWtrWgt[i]);
				if (splLowSulpDoilBrgWgt1[i] != null)
					model.setSplLowSulpDoilBrgWgt1(splLowSulpDoilBrgWgt1[i]);
				if (depStsCd[i] != null)
					model.setDepStsCd(depStsCd[i]);
				if (splLowSulpDoilBrgWgt2[i] != null)
					model.setSplLowSulpDoilBrgWgt2(splLowSulpDoilBrgWgt2[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (blkHldLoadQty9[i] != null)
					model.setBlkHldLoadQty9(blkHldLoadQty9[i]);
				if (splLowSulpFoilBrgWgt2[i] != null)
					model.setSplLowSulpFoilBrgWgt2(splLowSulpFoilBrgWgt2[i]);
				if (splLowSulpFoilBrgWgt1[i] != null)
					model.setSplLowSulpFoilBrgWgt1(splLowSulpFoilBrgWgt1[i]);
				if (seaBlrFoilCsmQty[i] != null)
					model.setSeaBlrFoilCsmQty(seaBlrFoilCsmQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lstDepLowSulpDoilCtnt[i] != null)
					model.setLstDepLowSulpDoilCtnt(lstDepLowSulpDoilCtnt[i]);
				if (splDoilSulpWgt[i] != null)
					model.setSplDoilSulpWgt(splDoilSulpWgt[i]);
				if (arrDoilWgt[i] != null)
					model.setArrDoilWgt(arrDoilWgt[i]);
				if (runHrsInHvWe[i] != null)
					model.setRunHrsInHvWe(runHrsInHvWe[i]);
				if (portDetRsnCd3[i] != null)
					model.setPortDetRsnCd3(portDetRsnCd3[i]);
				if (portDetRsnCd2[i] != null)
					model.setPortDetRsnCd2(portDetRsnCd2[i]);
				if (portDetRsnCd1[i] != null)
					model.setPortDetRsnCd1(portDetRsnCd1[i]);
				if (seaMnFoilCsmQty[i] != null)
					model.setSeaMnFoilCsmQty(seaMnFoilCsmQty[i]);
				if (depRpmUusdFm[i] != null)
					model.setDepRpmUusdFm(depRpmUusdFm[i]);
				if (arrBlrFoilCsmQty[i] != null)
					model.setArrBlrFoilCsmQty(arrBlrFoilCsmQty[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (depRsnForMgnTm[i] != null)
					model.setDepRsnForMgnTm(depRsnForMgnTm[i]);
				if (splDoilBdrWgt[i] != null)
					model.setSplDoilBdrWgt(splDoilBdrWgt[i]);
				if (nxtAftdrHgt[i] != null)
					model.setNxtAftdrHgt(nxtAftdrHgt[i]);
				if (nxtFoilWgt[i] != null)
					model.setNxtFoilWgt(nxtFoilWgt[i]);
				if (ttlCntrObrdTeu[i] != null)
					model.setTtlCntrObrdTeu(ttlCntrObrdTeu[i]);
				if (nxtFwddrHgt[i] != null)
					model.setNxtFwddrHgt(nxtFwddrHgt[i]);
				if (arrLat[i] != null)
					model.setArrLat(arrLat[i]);
				if (depPortCd[i] != null)
					model.setDepPortCd(depPortCd[i]);
				if (fullCntrObrdTeu[i] != null)
					model.setFullCntrObrdTeu(fullCntrObrdTeu[i]);
				if (arrGmHgt[i] != null)
					model.setArrGmHgt(arrGmHgt[i]);
				if (portGnrLowSulpDoilCsmQty[i] != null)
					model.setPortGnrLowSulpDoilCsmQty(portGnrLowSulpDoilCsmQty[i]);
				if (portGnrFoilCsmQty[i] != null)
					model.setPortGnrFoilCsmQty(portGnrFoilCsmQty[i]);
				if (seaMnDoilCsmQty[i] != null)
					model.setSeaMnDoilCsmQty(seaMnDoilCsmQty[i]);
				if (dplSlgSp[i] != null)
					model.setDplSlgSp(dplSlgSp[i]);
				if (splFoilBdrWgt[i] != null)
					model.setSplFoilBdrWgt(splFoilBdrWgt[i]);
				if (portBlrLowSulpDoilCsmQty[i] != null)
					model.setPortBlrLowSulpDoilCsmQty(portBlrLowSulpDoilCsmQty[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (seaBlrLowSulpFoilCsmQty[i] != null)
					model.setSeaBlrLowSulpFoilCsmQty(seaBlrLowSulpFoilCsmQty[i]);
				if (seaMnLowSulpDoilCsmQty[i] != null)
					model.setSeaMnLowSulpDoilCsmQty(seaMnLowSulpDoilCsmQty[i]);
				if (depMidDrftHgt[i] != null)
					model.setDepMidDrftHgt(depMidDrftHgt[i]);
				if (arrMnFoilCsmQty[i] != null)
					model.setArrMnFoilCsmQty(arrMnFoilCsmQty[i]);
				if (nxtFrshWtrWgt[i] != null)
					model.setNxtFrshWtrWgt(nxtFrshWtrWgt[i]);
				if (avgSpd[i] != null)
					model.setAvgSpd(avgSpd[i]);
				if (depArrPltMgnMnts[i] != null)
					model.setDepArrPltMgnMnts(depArrPltMgnMnts[i]);
				if (seaDetRsnHrs3[i] != null)
					model.setSeaDetRsnHrs3(seaDetRsnHrs3[i]);
				if (depRpmPwr[i] != null)
					model.setDepRpmPwr(depRpmPwr[i]);
				if (seaDetRsnHrs2[i] != null)
					model.setSeaDetRsnHrs2(seaDetRsnHrs2[i]);
				if (seaDetRsnHrs1[i] != null)
					model.setSeaDetRsnHrs1(seaDetRsnHrs1[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFcmDepRptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FcmDepRptVO[]
	 */
	public FcmDepRptVO[] getFcmDepRptVOs(){
		FcmDepRptVO[] vos = (FcmDepRptVO[])models.toArray(new FcmDepRptVO[models.size()]);
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
		this.splLowSulpFoilActWgt = this.splLowSulpFoilActWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pltInDt = this.pltInDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBlrDoilCsmQty = this.seaBlrDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaDnst = this.seaDnst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaDetRsnCd1 = this.seaDetRsnCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstRfCntrObrdKntCtnt = this.lstRfCntrObrdKntCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrBlrLowSulpFoilCsmQty = this.arrBlrLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaDetRsnCd3 = this.seaDetRsnCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrBrthAnkDrpDt = this.bfrBrthAnkDrpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtLowSulpDoilWgt = this.nxtLowSulpDoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaDetRsnCd2 = this.seaDetRsnCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foSlgWgt = this.foSlgWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPortCd = this.nxtPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrFoilWgt = this.arrFoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkCgoTpCd5 = this.blkCgoTpCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkCgoTpCd3 = this.blkCgoTpCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvgtMlDist = this.nvgtMlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkCgoTpCd4 = this.blkCgoTpCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkCgoTpCd1 = this.blkCgoTpCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depBlstWgt = this.depBlstWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkCgoTpCd2 = this.blkCgoTpCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capNm = this.capNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaGnrLowSulpFoilCsmQty = this.seaGnrLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depFoilWgt = this.depFoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpFoilBdrWgt = this.splLowSulpFoilBdrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstDepDoilCtnt = this.lstDepDoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splFoilActWgt = this.splFoilActWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgRpmPwr = this.avgRpmPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtDoilWgt = this.nxtDoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstPortRupDt = this.lstPortRupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pltOutDt = this.pltOutDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrGnrLowSulpFoilCsmQty = this.arrGnrLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRpmUusdTo = this.depRpmUusdTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depFwddrHgt = this.depFwddrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depGmHgt = this.depGmHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incnrSlgWgt = this.incnrSlgWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLat = this.depLat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splFrshWtrActWgt = this.splFrshWtrActWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBlrDoilCsmQty = this.portBlrDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDplWgt = this.depDplWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilPurfDchgItval = this.foilPurfDchgItval .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splFoilSulpWgt = this.splFoilSulpWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkDepCgoTtlWgt = this.blkDepCgoTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstDepLowSulpFoilCtnt = this.lstDepLowSulpFoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmnSdgWgt = this.rmnSdgWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrBrthAnkOffDt = this.bfrBrthAnkOffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLon = this.arrLon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmnAvgSpd = this.rmnAvgSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkLodDchgStsCd = this.blkLodDchgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtLowSulpFoilWgt = this.nxtLowSulpFoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dplSlgWgt = this.dplSlgWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depCgoWgt = this.depCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrInMlDist = this.mnvrInMlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrBlstWgt = this.arrBlstWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDoilWgt = this.depDoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrMnLowSulpFoilCsmQty = this.arrMnLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpDoilActWgt = this.splLowSulpDoilActWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstDepFoilCtnt = this.lstDepFoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpFoilSulpWgt = this.splLowSulpFoilSulpWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLowSulpDoilWgt = this.arrLowSulpDoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splDoilActWgt = this.splDoilActWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlSlgWgt = this.ttlSlgWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrEngMl = this.arrEngMl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rupDt = this.rupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sbEngDt = this.sbEngDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portMnLowSulpFoilCsmQty = this.portMnLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWrkEndDt = this.cgoWrkEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrAftdrHgt = this.arrAftdrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLowSulpDoilWgt = this.depLowSulpDoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depAftdrHgt = this.depAftdrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaGnrLowSulpDoilCsmQty = this.seaGnrLowSulpDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portMnFoilCsmQty = this.portMnFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrSailHrs = this.arrSailHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLon = this.depLon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtMidDrftHgt = this.nxtMidDrftHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCntrDchgKnt = this.rfCntrDchgKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCntrObrdKnt = this.rfCntrObrdKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpDoilSulpWgt = this.splLowSulpDoilSulpWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLowSulpFoilWgt = this.depLowSulpFoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depArrPltMgnHrs = this.depArrPltMgnHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBlrLowSulpDoilCsmQty = this.seaBlrLowSulpDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splDoilBrgWgt1 = this.splDoilBrgWgt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftUnbrthAnkOffDt = this.aftUnbrthAnkOffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstDepPortCd = this.lstDepPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtBlstWgt = this.nxtBlstWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaMnLowSulpFoilCsmQty = this.seaMnLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRpmMaxPwr = this.depRpmMaxPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCntrLodKnt = this.rfCntrLodKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splDoilBrgWgt2 = this.splDoilBrgWgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWrkStDt = this.cgoWrkStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftUnbrthAnkDrpDt = this.aftUnbrthAnkDrpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portDetRsnHrs1 = this.portDetRsnHrs1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrFrshWtrWgt = this.arrFrshWtrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtGmHgt = this.nxtGmHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaGnrDoilCsmQty = this.seaGnrDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portDetRsnHrs2 = this.portDetRsnHrs2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portDetRsnHrs3 = this.portDetRsnHrs3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRpmMinPwr = this.depRpmMinPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDoilCsmQty = this.arrDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrOutMlDist = this.mnvrOutMlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyCntrObrdTeu = this.mtyCntrObrdTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpDoilBdrWgt = this.splLowSulpDoilBdrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLowSulpDoilCsmQty = this.arrLowSulpDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portGnrLowSulpFoilCsmQty = this.portGnrLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrMidDrftHgt = this.arrMidDrftHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrNvgtMl = this.arrNvgtMl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrFwddrHgt = this.arrFwddrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gmtTdHrs = this.gmtTdHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBlrFoilCsmQty = this.portBlrFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrGnrFoilCsmQty = this.arrGnrFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRmk = this.depRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portMnLowSulpDoilCsmQty = this.portMnLowSulpDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmnDist = this.rmnDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrRpmPwr = this.arrRpmPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaGnrFoilCsmQty = this.seaGnrFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engMlDist = this.engMlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDznCapa = this.cntrDznCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splFoilBrgWgt2 = this.splFoilBrgWgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portMnDoilCsmQty = this.portMnDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splFoilBrgWgt1 = this.splFoilBrgWgt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfEngNm = this.cfEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkHldLoadQty6 = this.blkHldLoadQty6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPortEtaDt = this.nxtPortEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkHldLoadQty5 = this.blkHldLoadQty5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkHldLoadQty8 = this.blkHldLoadQty8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkHldLoadQty7 = this.blkHldLoadQty7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkHldLoadQty2 = this.blkHldLoadQty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkHldLoadQty1 = this.blkHldLoadQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkHldLoadQty4 = this.blkHldLoadQty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkHldLoadQty3 = this.blkHldLoadQty3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBlrLowSulpFoilCsmQty = this.portBlrLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portGnrDoilCsmQty = this.portGnrDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLowSulpFoilWgt = this.arrLowSulpFoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depFrshWtrWgt = this.depFrshWtrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpDoilBrgWgt1 = this.splLowSulpDoilBrgWgt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depStsCd = this.depStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpDoilBrgWgt2 = this.splLowSulpDoilBrgWgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkHldLoadQty9 = this.blkHldLoadQty9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpFoilBrgWgt2 = this.splLowSulpFoilBrgWgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpFoilBrgWgt1 = this.splLowSulpFoilBrgWgt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBlrFoilCsmQty = this.seaBlrFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstDepLowSulpDoilCtnt = this.lstDepLowSulpDoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splDoilSulpWgt = this.splDoilSulpWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDoilWgt = this.arrDoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.runHrsInHvWe = this.runHrsInHvWe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portDetRsnCd3 = this.portDetRsnCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portDetRsnCd2 = this.portDetRsnCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portDetRsnCd1 = this.portDetRsnCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaMnFoilCsmQty = this.seaMnFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRpmUusdFm = this.depRpmUusdFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrBlrFoilCsmQty = this.arrBlrFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRsnForMgnTm = this.depRsnForMgnTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splDoilBdrWgt = this.splDoilBdrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtAftdrHgt = this.nxtAftdrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtFoilWgt = this.nxtFoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCntrObrdTeu = this.ttlCntrObrdTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtFwddrHgt = this.nxtFwddrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLat = this.arrLat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depPortCd = this.depPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullCntrObrdTeu = this.fullCntrObrdTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrGmHgt = this.arrGmHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portGnrLowSulpDoilCsmQty = this.portGnrLowSulpDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portGnrFoilCsmQty = this.portGnrFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaMnDoilCsmQty = this.seaMnDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dplSlgSp = this.dplSlgSp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splFoilBdrWgt = this.splFoilBdrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBlrLowSulpDoilCsmQty = this.portBlrLowSulpDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBlrLowSulpFoilCsmQty = this.seaBlrLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaMnLowSulpDoilCsmQty = this.seaMnLowSulpDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depMidDrftHgt = this.depMidDrftHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrMnFoilCsmQty = this.arrMnFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtFrshWtrWgt = this.nxtFrshWtrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgSpd = this.avgSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depArrPltMgnMnts = this.depArrPltMgnMnts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaDetRsnHrs3 = this.seaDetRsnHrs3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRpmPwr = this.depRpmPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaDetRsnHrs2 = this.seaDetRsnHrs2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaDetRsnHrs1 = this.seaDetRsnHrs1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
