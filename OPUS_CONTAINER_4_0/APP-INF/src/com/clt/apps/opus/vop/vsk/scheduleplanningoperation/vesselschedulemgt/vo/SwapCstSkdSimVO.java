/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SwapCstSkdSimVO.java
 *@FileTitle : SwapCstSkdSimVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.03.30
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2015.03.30 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

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
 * @author dongsoo
 * @since J2EE 1.6
 * @see	.. 
 */
public class SwapCstSkdSimVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SwapCstSkdSimVO> models = new ArrayList<SwapCstSkdSimVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /*	Column Info	*/
    private String ofcInpFlg = null;

    /*	Column Info	*/
    private String ts20ftTtlQty = null;

    /*	Column Info	*/
    private String bnkUnitAmt = null;

    /*	Column Info	*/
    private String plismVoyNo = null;

    /*	Column Info	*/
    private String tmlCd = null;

    /*	Column Info	*/
    private String psdoVvdCd = null;

    /*	Column Info	*/
    private String vpsPortCd = null;

    /*	Column Info	*/
    private String clptSeq = null;

    /*	Column Info	*/
    private String skdUsdIndCd = null;

    /*	Column Info	*/
    private String tmlHndl40ftTtlQty = null;

    /*	Column Info	*/
    private String noonRptInpFlg = null;

    /*	Column Info	*/
    private String ibIpcgoQty = null;

    /*	Column Info	*/
    private String vslDlayRsnDesc = null;

    /*	Column Info	*/
    private String obIpcgoQty = null;

    /*	Column Info	*/
    private String updUsrId = null;

    /*	Column Info	*/
    private String newClptIndSeq = null;

    /*	Column Info	*/
    private String initEtaDt = null;

    /*	Column Info	*/
    private String shpCallNoUpdUsrId = null;

    /*	Column Info	*/
    private String cngLaneCd = null;

    /*	Column Info	*/
    private String lnkDist = null;

    /*	Column Info	*/
    private String obCgoQty = null;

    /*	Column Info	*/
    private String etdDyNo = null;

    /*	Column Info	*/
    private String n1stPortBrthDt = null;

    /*	Column Info	*/
    private String skdVoyNo = null;

    /*	Column Info	*/
    private String tmlVslCd = null;

    /*	Column Info	*/
    private String ediSndKnt = null;

    /*	Column Info	*/
    private String cngVslCd = null;

    /*	Column Info	*/
    private String etdTmHrmnt = null;

    /*	Column Info	*/
    private String tmlHndl20ftTtlAmt = null;

    /*	Column Info	*/
    private String etbDyNo = null;

    /*	Column Info	*/
    private String usdFlg = null;

    /*	Column Info	*/
    private String seaBufSpd = null;

    /*	Column Info	*/
    private String vslDlayRsnLocCd = null;

    /*	Column Info	*/
    private String etbDyCd = null;

    /*	Column Info	*/
    private String pfSkdTpCd = null;

    /*	Column Info	*/
    private String phsIoRsnCd = null;

    /*	Column Info	*/
    private String tmlProdQty = null;

    /*	Column Info	*/
    private String turnSkdDirCd = null;

    /*	Column Info	*/
    private String portSkpTpCd = null;

    /*	Column Info	*/
    private String etaDelayFlg = null;

    /*	Column Info	*/
    private String skdVoyTpCd = null;

    /*	Column Info	*/
    private String skdRmk = null;

    /*	Column Info	*/
    private String vslDlayRsnCd = null;

    /*	Column Info	*/
    private String callYdIndSeq = null;

    /*	Column Info	*/
    private String ts20ftTtlAmt = null;

    /*	Column Info	*/
    private String plismVslCd = null;

    /*	Column Info	*/
    private String dlayDateText = null;

    /*	Column Info	*/
    private String timeDiff = null;

    /*	Column Info	*/
    private String ftDt = null;

    /*	Column Info	*/
    private String portSkpRsnOffrRmk = null;

    /*	Column Info	*/
    private String phsIoRmk = null;

    /*	Column Info	*/
    private String seaDateText = null;

    /*	Column Info	*/
    private String mnvrInHrs = null;

    /*	Column Info	*/
    private String diffRmk = null;

    /*	Column Info	*/
    private String slanCd = null;

    /*	Column Info	*/
    private String ydCd = null;

    /* Column Info */
    private String fmLocCd = null;

    /* Column Info */
    private String toLocCd = null;

    /* Column Info */
    private String portDist = null;

    /*	Column Info	*/
    private String etbTmHrmnt = null;

    /*	Column Info	*/
    private String clptIndSeq = null;

    /*	Column Info	*/
    private String depRptInpFlg = null;

    /*	Column Info	*/
    private String ts40ftTtlQty = null;

    /*	Column Info	*/
    private String bound = null;

    /*	Column Info	*/
    private String vslCd = null;

    /*	Column Info	*/
    private String lnkSpd = null;

    /*	Column Info	*/
    private String seaBufHrs = null;

    /*	Column Info	*/
    private String actWrkHrs = null;

    /*	Column Info	*/
    private String addBnkCsmQty = null;

    /*	Column Info	*/
    private String simNo = null;

    /*	Column Info	*/
    private String turnSkdVoyNo = null;

    /*	Column Info	*/
    private String portBufHrs = null;

    /*	Column Info	*/
    private String cngSkdVoyNo = null;

    /*	Column Info	*/
    private String initSkdInpFlg = null;

    /*	Column Info	*/
    private String tztmHrs = null;

    /*	Column Info	*/
    private String etdDyCd = null;

    /*	Column Info	*/
    private String ts40ftTtlAmt = null;

    /*	Column Info	*/
    private String turnPortIndCd = null;

    /*	Column Info	*/
    private String peUsdTtlAmt = null;

    /*	Column Info	*/
    private String skdBrthNo = null;

    /*	Column Info	*/
    private String tmlHndl40ftTtlAmt = null;

    /*	Column Info	*/
    private String portSkdStsCd = null;

    /*	Column Info	*/
    private String etbDelayFlg = null;

    /*	Column Info	*/
    private String vslSimTpCd = null;

    /*	Column Info	*/
    private String vpsEtdDt = null;

    /*	Column Info	*/
    private String initEtbDt = null;

    /*	Column Info	*/
    private String portSkpRsnCd = null;

    /*	Column Info	*/
    private String ibOcnCgoQty = null;

    /*	Column Info	*/
    private String plismYdCd = null;

    /*	Column Info	*/
    private String initEtdDt = null;

    /*	Column Info	*/
    private String autoSkdCngFlg = null;

    /*	Column Info	*/
    private String vvd = null;

    /*	Column Info	*/
    private String creUsrId = null;

    /*	Column Info	*/
    private String skdCngStsCd = null;

    /*	Column Info	*/
    private String bfrActFlg = null;

    /*	Column Info	*/
    private String shpCallNoUpdDt = null;

    /*	Column Info	*/
    private String cngSkdDirCd = null;

    /*	Column Info	*/
    private String usrHdnFlg = null;

    /*	Column Info	*/
    private String delayDate = null;

    /*	Column Info	*/
    private String turnClptIndSeq = null;

    /*	Column Info	*/
    private String mnvrOutHrs = null;

    /*	Column Info	*/
    private String vpsEtbDt = null;

    /*	Column Info	*/
    private String vpsRmk = null;

    /*	Column Info	*/
    private String turnPortFlg = null;

    /*	Column Info	*/
    private String creDt = null;

    /*	Column Info	*/
    private String simDt = null;

    /*	Column Info	*/
    private String vslSlanCd = null;

    /*	Column Info	*/
    private String tmlHndl20ftTtlQty = null;

    /*	Column Info	*/
    private String vpsEtaDt = null;

    /*	Column Info	*/
    private String skdStsCd = null;

    /*	Column Info	*/
    private String addBnkCostAmt = null;

    /*	Column Info	*/
    private String pfSvcTpCd = null;

    /*	Column Info	*/
    private String pfSpd = null;

    /*	Column Info	*/
    private String crnKnt = null;

    /*	Column Info	*/
    private String bnkUnitQty = null;

    /*	Column Info	*/
    private String tmlVoyNo = null;

    /*	Column Info	*/
    private String portRotnSeq = null;

    /*	Column Info	*/
    private String obOcnCgoQty = null;

    /*	Column Info	*/
    private String shpCallNo = null;

    /*	Column Info	*/
    private String updDt = null;

    /*	Column Info	*/
    private String prtChkFlg = null;

    /*	Column Info	*/
    private String tsPortCd = null;

    /*	Column Info	*/
    private String pfEtdDt = null;

    /*	Column Info	*/
    private String coCd = null;

    /*	Column Info	*/
    private String ttlDlayHrs = null;

    /*	Column Info	*/
    private String pfEtaDt = null;

    /*	Column Info	*/
    private String rtvFlg = null;

    /*	Column Info	*/
    private String etdDelayFlg = null;

    /*	Column Info	*/
    private String pfEtbDt = null;

    /*	Column Info	*/
    private String winRmk = null;

    /*	Column Info	*/
    private String actInpFlg = null;

    /*	Column Info	*/
    private String skdDirCd = null;

    /*	Column Info	*/
    private String updSts = null;

    /*	Column Info	*/
    private String ibCgoQty = null;

    /*	Column Info	*/
    private String seq = null;

    /*	Column Info	*/
    private String stPortCd = null;

    /*	Column Info	*/
    private String addVtPortSeq = null;

    /*	Column Info	*/
    private String pfLnkDist = null;

    /*	Column Info	*/
    private String pfLnkSpd = null;

    /*	Column Info	*/
    private String pfSeaBufHrs = null;

    /*	Column Info	*/
    private String pfPortBufHrs = null;

    /*	Column Info	*/
    private String pfTztmHrs = null;

    /*	Column Info	*/
    private String pfActWrkHrs = null;

    /*	Column Info	*/
    private String pfMnvrOutHrs = null;

    /*	Column Info	*/
    private String pfMnvrInHrs = null;

    /*	Column Info	*/
    private String vtAddCallFlg = null;

    /* Column Info */
    private String cssmVoyInitCreFlg = null;

    /* Column Info */
    private String vslRenmOldVslCd = null;

    /* Column Info */
    private String vslRenmOldVslEngNm = null;

    /* Column Info */
    private String vslRenmNewVslCd = null;

    /* Column Info */
    private String vslRenmNewVslEngNm = null;

    /* Column Info */
    private String vsldWks = null;

    /* Column Info */
    private String addCallFlg = null;

    /* Column Info */
    private String skpCallFlg = null;

    /* Column Info */
    private String addCallXterFlg = null;

    /* Column Info */
    private String privCallFlg = null;

    /* Column Info */
    private String ibCssmVoyNo = null;

    /* Column Info */
    private String obCssmVoyNo = null;

    /* Column Info */
    private String turnIbCssmVoyNo = null;

    /* Column Info */
    private String firstTurnPortClptSeq = null;

    /* Column Info */
    private String realClptSeq = null;

    /* Column Info */
    private String virPortClptSeq = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    /**	Constructor	*/
    public SwapCstSkdSimVO() {
    }

    public SwapCstSkdSimVO(String ibflag, String pagerows, String ofcInpFlg, String ts20ftTtlQty, String bnkUnitAmt, String plismVoyNo, String tmlCd, String psdoVvdCd, String vpsPortCd, String clptSeq, String skdUsdIndCd, String tmlHndl40ftTtlQty, String noonRptInpFlg, String ibIpcgoQty, String vslDlayRsnDesc, String obIpcgoQty, String updUsrId, String newClptIndSeq, String initEtaDt, String shpCallNoUpdUsrId, String cngLaneCd, String lnkDist, String obCgoQty, String etdDyNo, String n1stPortBrthDt, String skdVoyNo, String tmlVslCd, String ediSndKnt, String cngVslCd, String etdTmHrmnt, String tmlHndl20ftTtlAmt, String etbDyNo, String usdFlg, String seaBufSpd, String vslDlayRsnLocCd, String etbDyCd, String pfSkdTpCd, String phsIoRsnCd, String tmlProdQty, String turnSkdDirCd, String portSkpTpCd, String etaDelayFlg, String skdVoyTpCd, String skdRmk, String vslDlayRsnCd, String callYdIndSeq, String ts20ftTtlAmt, String plismVslCd, String dlayDateText, String timeDiff, String ftDt, String portSkpRsnOffrRmk, String phsIoRmk, String seaDateText, String mnvrInHrs, String diffRmk, String slanCd, String ydCd, String etbTmHrmnt, String clptIndSeq, String depRptInpFlg, String ts40ftTtlQty, String bound, String vslCd, String lnkSpd, String seaBufHrs, String actWrkHrs, String addBnkCsmQty, String simNo, String turnSkdVoyNo, String portBufHrs, String cngSkdVoyNo, String initSkdInpFlg, String tztmHrs, String etdDyCd, String ts40ftTtlAmt, String turnPortIndCd, String peUsdTtlAmt, String skdBrthNo, String tmlHndl40ftTtlAmt, String portSkdStsCd, String etbDelayFlg, String vslSimTpCd, String vpsEtdDt, String initEtbDt, String portSkpRsnCd, String ibOcnCgoQty, String plismYdCd, String initEtdDt, String autoSkdCngFlg, String vvd, String creUsrId, String skdCngStsCd, String bfrActFlg, String shpCallNoUpdDt, String cngSkdDirCd, String usrHdnFlg, String delayDate, String turnClptIndSeq, String mnvrOutHrs, String vpsEtbDt, String vpsRmk, String turnPortFlg, String creDt, String simDt, String vslSlanCd, String tmlHndl20ftTtlQty, String vpsEtaDt, String skdStsCd, String addBnkCostAmt, String pfSvcTpCd, String pfSpd, String crnKnt, String bnkUnitQty, String tmlVoyNo, String portRotnSeq, String obOcnCgoQty, String shpCallNo, String updDt, String prtChkFlg, String tsPortCd, String pfEtdDt, String coCd, String ttlDlayHrs, String pfEtaDt, String rtvFlg, String etdDelayFlg, String pfEtbDt, String winRmk, String actInpFlg, String skdDirCd, String updSts, String ibCgoQty, String seq, String stPortCd, String addVtPortSeq, String pfLnkDist, String pfLnkSpd, String pfSeaBufHrs, String pfPortBufHrs, String pfTztmHrs, String pfActWrkHrs, String pfMnvrOutHrs, String pfMnvrInHrs, String ibCssmVoyNo, String obCssmVoyNo, String cssmVoyInitCreFlg, String vslRenmOldVslCd, String vslRenmOldVslEngNm, String vslRenmNewVslCd, String vslRenmNewVslEngNm, String vsldWks, String addCallFlg, String skpCallFlg, String addCallXterFlg, String privCallFlg, String turnIbCssmVoyNo, String firstTurnPortClptSeq, String realClptSeq, String virPortClptSeq) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.ofcInpFlg = ofcInpFlg;
        this.ts20ftTtlQty = ts20ftTtlQty;
        this.bnkUnitAmt = bnkUnitAmt;
        this.plismVoyNo = plismVoyNo;
        this.tmlCd = tmlCd;
        this.psdoVvdCd = psdoVvdCd;
        this.vpsPortCd = vpsPortCd;
        this.clptSeq = clptSeq;
        this.skdUsdIndCd = skdUsdIndCd;
        this.tmlHndl40ftTtlQty = tmlHndl40ftTtlQty;
        this.noonRptInpFlg = noonRptInpFlg;
        this.ibIpcgoQty = ibIpcgoQty;
        this.vslDlayRsnDesc = vslDlayRsnDesc;
        this.obIpcgoQty = obIpcgoQty;
        this.updUsrId = updUsrId;
        this.newClptIndSeq = newClptIndSeq;
        this.initEtaDt = initEtaDt;
        this.shpCallNoUpdUsrId = shpCallNoUpdUsrId;
        this.cngLaneCd = cngLaneCd;
        this.lnkDist = lnkDist;
        this.obCgoQty = obCgoQty;
        this.etdDyNo = etdDyNo;
        this.n1stPortBrthDt = n1stPortBrthDt;
        this.skdVoyNo = skdVoyNo;
        this.tmlVslCd = tmlVslCd;
        this.ediSndKnt = ediSndKnt;
        this.cngVslCd = cngVslCd;
        this.etdTmHrmnt = etdTmHrmnt;
        this.tmlHndl20ftTtlAmt = tmlHndl20ftTtlAmt;
        this.etbDyNo = etbDyNo;
        this.usdFlg = usdFlg;
        this.seaBufSpd = seaBufSpd;
        this.vslDlayRsnLocCd = vslDlayRsnLocCd;
        this.etbDyCd = etbDyCd;
        this.pfSkdTpCd = pfSkdTpCd;
        this.phsIoRsnCd = phsIoRsnCd;
        this.tmlProdQty = tmlProdQty;
        this.turnSkdDirCd = turnSkdDirCd;
        this.portSkpTpCd = portSkpTpCd;
        this.etaDelayFlg = etaDelayFlg;
        this.skdVoyTpCd = skdVoyTpCd;
        this.skdRmk = skdRmk;
        this.vslDlayRsnCd = vslDlayRsnCd;
        this.callYdIndSeq = callYdIndSeq;
        this.ts20ftTtlAmt = ts20ftTtlAmt;
        this.plismVslCd = plismVslCd;
        this.dlayDateText = dlayDateText;
        this.timeDiff = timeDiff;
        this.ftDt = ftDt;
        this.portSkpRsnOffrRmk = portSkpRsnOffrRmk;
        this.phsIoRmk = phsIoRmk;
        this.seaDateText = seaDateText;
        this.mnvrInHrs = mnvrInHrs;
        this.diffRmk = diffRmk;
        this.slanCd = slanCd;
        this.ydCd = ydCd;
        this.etbTmHrmnt = etbTmHrmnt;
        this.clptIndSeq = clptIndSeq;
        this.depRptInpFlg = depRptInpFlg;
        this.ts40ftTtlQty = ts40ftTtlQty;
        this.bound = bound;
        this.vslCd = vslCd;
        this.lnkSpd = lnkSpd;
        this.seaBufHrs = seaBufHrs;
        this.actWrkHrs = actWrkHrs;
        this.addBnkCsmQty = addBnkCsmQty;
        this.simNo = simNo;
        this.turnSkdVoyNo = turnSkdVoyNo;
        this.portBufHrs = portBufHrs;
        this.cngSkdVoyNo = cngSkdVoyNo;
        this.initSkdInpFlg = initSkdInpFlg;
        this.tztmHrs = tztmHrs;
        this.etdDyCd = etdDyCd;
        this.ts40ftTtlAmt = ts40ftTtlAmt;
        this.turnPortIndCd = turnPortIndCd;
        this.peUsdTtlAmt = peUsdTtlAmt;
        this.skdBrthNo = skdBrthNo;
        this.tmlHndl40ftTtlAmt = tmlHndl40ftTtlAmt;
        this.portSkdStsCd = portSkdStsCd;
        this.etbDelayFlg = etbDelayFlg;
        this.vslSimTpCd = vslSimTpCd;
        this.vpsEtdDt = vpsEtdDt;
        this.initEtbDt = initEtbDt;
        this.portSkpRsnCd = portSkpRsnCd;
        this.ibOcnCgoQty = ibOcnCgoQty;
        this.plismYdCd = plismYdCd;
        this.initEtdDt = initEtdDt;
        this.autoSkdCngFlg = autoSkdCngFlg;
        this.vvd = vvd;
        this.creUsrId = creUsrId;
        this.skdCngStsCd = skdCngStsCd;
        this.bfrActFlg = bfrActFlg;
        this.shpCallNoUpdDt = shpCallNoUpdDt;
        this.cngSkdDirCd = cngSkdDirCd;
        this.usrHdnFlg = usrHdnFlg;
        this.delayDate = delayDate;
        this.turnClptIndSeq = turnClptIndSeq;
        this.mnvrOutHrs = mnvrOutHrs;
        this.vpsEtbDt = vpsEtbDt;
        this.vpsRmk = vpsRmk;
        this.turnPortFlg = turnPortFlg;
        this.creDt = creDt;
        this.simDt = simDt;
        this.vslSlanCd = vslSlanCd;
        this.tmlHndl20ftTtlQty = tmlHndl20ftTtlQty;
        this.vpsEtaDt = vpsEtaDt;
        this.skdStsCd = skdStsCd;
        this.addBnkCostAmt = addBnkCostAmt;
        this.pfSvcTpCd = pfSvcTpCd;
        this.pfSpd = pfSpd;
        this.crnKnt = crnKnt;
        this.bnkUnitQty = bnkUnitQty;
        this.tmlVoyNo = tmlVoyNo;
        this.portRotnSeq = portRotnSeq;
        this.obOcnCgoQty = obOcnCgoQty;
        this.shpCallNo = shpCallNo;
        this.updDt = updDt;
        this.prtChkFlg = prtChkFlg;
        this.tsPortCd = tsPortCd;
        this.pfEtdDt = pfEtdDt;
        this.coCd = coCd;
        this.ttlDlayHrs = ttlDlayHrs;
        this.pfEtaDt = pfEtaDt;
        this.rtvFlg = rtvFlg;
        this.etdDelayFlg = etdDelayFlg;
        this.pfEtbDt = pfEtbDt;
        this.winRmk = winRmk;
        this.actInpFlg = actInpFlg;
        this.skdDirCd = skdDirCd;
        this.updSts = updSts;
        this.ibCgoQty = ibCgoQty;
        this.seq = seq;
        this.stPortCd = stPortCd;
        this.addVtPortSeq = addVtPortSeq;
        this.pfLnkDist = pfLnkDist;
        this.pfLnkSpd = pfLnkSpd;
        this.pfSeaBufHrs = pfSeaBufHrs;
        this.pfPortBufHrs = pfPortBufHrs;
        this.pfTztmHrs = pfTztmHrs;
        this.pfActWrkHrs = pfActWrkHrs;
        this.pfMnvrOutHrs = pfMnvrOutHrs;
        this.pfMnvrInHrs = pfMnvrInHrs;
        this.ibCssmVoyNo = ibCssmVoyNo;
        this.obCssmVoyNo = obCssmVoyNo;
        this.cssmVoyInitCreFlg = cssmVoyInitCreFlg;
        this.vslRenmOldVslCd = vslRenmOldVslCd;
        this.vslRenmOldVslEngNm = vslRenmOldVslEngNm;
        this.vslRenmNewVslCd = vslRenmNewVslCd;
        this.vslRenmNewVslEngNm = vslRenmNewVslEngNm;
        this.vsldWks = vsldWks;
        this.addCallFlg = addCallFlg;
        this.skpCallFlg = skpCallFlg;
        this.addCallXterFlg = addCallXterFlg;
        this.privCallFlg = privCallFlg;
        this.ibCssmVoyNo = ibCssmVoyNo;
        this.obCssmVoyNo = obCssmVoyNo;
        this.turnIbCssmVoyNo = turnIbCssmVoyNo;
        this.firstTurnPortClptSeq = firstTurnPortClptSeq;
        this.realClptSeq = realClptSeq;
        this.virPortClptSeq = virPortClptSeq;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ofc_inp_flg", getOfcInpFlg());
        this.hashColumns.put("ts_20ft_ttl_qty", getTs20ftTtlQty());
        this.hashColumns.put("bnk_unit_amt", getBnkUnitAmt());
        this.hashColumns.put("plism_voy_no", getPlismVoyNo());
        this.hashColumns.put("tml_cd", getTmlCd());
        this.hashColumns.put("psdo_vvd_cd", getPsdoVvdCd());
        this.hashColumns.put("vps_port_cd", getVpsPortCd());
        this.hashColumns.put("clpt_seq", getClptSeq());
        this.hashColumns.put("skd_usd_ind_cd", getSkdUsdIndCd());
        this.hashColumns.put("tml_hndl_40ft_ttl_qty", getTmlHndl40ftTtlQty());
        this.hashColumns.put("noon_rpt_inp_flg", getNoonRptInpFlg());
        this.hashColumns.put("ib_ipcgo_qty", getIbIpcgoQty());
        this.hashColumns.put("vsl_dlay_rsn_desc", getVslDlayRsnDesc());
        this.hashColumns.put("ob_ipcgo_qty", getObIpcgoQty());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("new_clpt_ind_seq", getNewClptIndSeq());
        this.hashColumns.put("init_eta_dt", getInitEtaDt());
        this.hashColumns.put("shp_call_no_upd_usr_id", getShpCallNoUpdUsrId());
        this.hashColumns.put("cng_lane_cd", getCngLaneCd());
        this.hashColumns.put("lnk_dist", getLnkDist());
        this.hashColumns.put("ob_cgo_qty", getObCgoQty());
        this.hashColumns.put("etd_dy_no", getEtdDyNo());
        this.hashColumns.put("n1st_port_brth_dt", getN1stPortBrthDt());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("tml_vsl_cd", getTmlVslCd());
        this.hashColumns.put("edi_snd_knt", getEdiSndKnt());
        this.hashColumns.put("cng_vsl_cd", getCngVslCd());
        this.hashColumns.put("etd_tm_hrmnt", getEtdTmHrmnt());
        this.hashColumns.put("tml_hndl_20ft_ttl_amt", getTmlHndl20ftTtlAmt());
        this.hashColumns.put("etb_dy_no", getEtbDyNo());
        this.hashColumns.put("usd_flg", getUsdFlg());
        this.hashColumns.put("sea_buf_spd", getSeaBufSpd());
        this.hashColumns.put("vsl_dlay_rsn_loc_cd", getVslDlayRsnLocCd());
        this.hashColumns.put("etb_dy_cd", getEtbDyCd());
        this.hashColumns.put("pf_skd_tp_cd", getPfSkdTpCd());
        this.hashColumns.put("phs_io_rsn_cd", getPhsIoRsnCd());
        this.hashColumns.put("tml_prod_qty", getTmlProdQty());
        this.hashColumns.put("turn_skd_dir_cd", getTurnSkdDirCd());
        this.hashColumns.put("port_skp_tp_cd", getPortSkpTpCd());
        this.hashColumns.put("eta_delay_flg", getEtaDelayFlg());
        this.hashColumns.put("skd_voy_tp_cd", getSkdVoyTpCd());
        this.hashColumns.put("skd_rmk", getSkdRmk());
        this.hashColumns.put("vsl_dlay_rsn_cd", getVslDlayRsnCd());
        this.hashColumns.put("call_yd_ind_seq", getCallYdIndSeq());
        this.hashColumns.put("ts_20ft_ttl_amt", getTs20ftTtlAmt());
        this.hashColumns.put("plism_vsl_cd", getPlismVslCd());
        this.hashColumns.put("dlay_date_text", getDlayDateText());
        this.hashColumns.put("time_diff", getTimeDiff());
        this.hashColumns.put("ft_dt", getFtDt());
        this.hashColumns.put("port_skp_rsn_offr_rmk", getPortSkpRsnOffrRmk());
        this.hashColumns.put("phs_io_rmk", getPhsIoRmk());
        this.hashColumns.put("sea_date_text", getSeaDateText());
        this.hashColumns.put("mnvr_in_hrs", getMnvrInHrs());
        this.hashColumns.put("diff_rmk", getDiffRmk());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("yd_cd", getYdCd());
        this.hashColumns.put("to_loc_cd", getToLocCd());
        this.hashColumns.put("fm_loc_cd", getFmLocCd());
        this.hashColumns.put("port_dist", getPortDist());
        this.hashColumns.put("etb_tm_hrmnt", getEtbTmHrmnt());
        this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
        this.hashColumns.put("dep_rpt_inp_flg", getDepRptInpFlg());
        this.hashColumns.put("ts_40ft_ttl_qty", getTs40ftTtlQty());
        this.hashColumns.put("bound", getBound());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("lnk_spd", getLnkSpd());
        this.hashColumns.put("sea_buf_hrs", getSeaBufHrs());
        this.hashColumns.put("act_wrk_hrs", getActWrkHrs());
        this.hashColumns.put("add_bnk_csm_qty", getAddBnkCsmQty());
        this.hashColumns.put("sim_no", getSimNo());
        this.hashColumns.put("turn_skd_voy_no", getTurnSkdVoyNo());
        this.hashColumns.put("port_buf_hrs", getPortBufHrs());
        this.hashColumns.put("cng_skd_voy_no", getCngSkdVoyNo());
        this.hashColumns.put("init_skd_inp_flg", getInitSkdInpFlg());
        this.hashColumns.put("tztm_hrs", getTztmHrs());
        this.hashColumns.put("etd_dy_cd", getEtdDyCd());
        this.hashColumns.put("ts_40ft_ttl_amt", getTs40ftTtlAmt());
        this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());
        this.hashColumns.put("pe_usd_ttl_amt", getPeUsdTtlAmt());
        this.hashColumns.put("skd_brth_no", getSkdBrthNo());
        this.hashColumns.put("tml_hndl_40ft_ttl_amt", getTmlHndl40ftTtlAmt());
        this.hashColumns.put("port_skd_sts_cd", getPortSkdStsCd());
        this.hashColumns.put("etb_delay_flg", getEtbDelayFlg());
        this.hashColumns.put("vsl_sim_tp_cd", getVslSimTpCd());
        this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
        this.hashColumns.put("init_etb_dt", getInitEtbDt());
        this.hashColumns.put("port_skp_rsn_cd", getPortSkpRsnCd());
        this.hashColumns.put("ib_ocn_cgo_qty", getIbOcnCgoQty());
        this.hashColumns.put("plism_yd_cd", getPlismYdCd());
        this.hashColumns.put("init_etd_dt", getInitEtdDt());
        this.hashColumns.put("auto_skd_cng_flg", getAutoSkdCngFlg());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("skd_cng_sts_cd", getSkdCngStsCd());
        this.hashColumns.put("bfr_act_flg", getBfrActFlg());
        this.hashColumns.put("shp_call_no_upd_dt", getShpCallNoUpdDt());
        this.hashColumns.put("cng_skd_dir_cd", getCngSkdDirCd());
        this.hashColumns.put("usr_hdn_flg", getUsrHdnFlg());
        this.hashColumns.put("delay_date", getDelayDate());
        this.hashColumns.put("turn_clpt_ind_seq", getTurnClptIndSeq());
        this.hashColumns.put("mnvr_out_hrs", getMnvrOutHrs());
        this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
        this.hashColumns.put("vps_rmk", getVpsRmk());
        this.hashColumns.put("turn_port_flg", getTurnPortFlg());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("sim_dt", getSimDt());
        this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
        this.hashColumns.put("tml_hndl_20ft_ttl_qty", getTmlHndl20ftTtlQty());
        this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
        this.hashColumns.put("skd_sts_cd", getSkdStsCd());
        this.hashColumns.put("add_bnk_cost_amt", getAddBnkCostAmt());
        this.hashColumns.put("pf_svc_tp_cd", getPfSvcTpCd());
        this.hashColumns.put("pf_spd", getPfSpd());
        this.hashColumns.put("crn_knt", getCrnKnt());
        this.hashColumns.put("bnk_unit_qty", getBnkUnitQty());
        this.hashColumns.put("tml_voy_no", getTmlVoyNo());
        this.hashColumns.put("port_rotn_seq", getPortRotnSeq());
        this.hashColumns.put("ob_ocn_cgo_qty", getObOcnCgoQty());
        this.hashColumns.put("shp_call_no", getShpCallNo());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("prt_chk_flg", getPrtChkFlg());
        this.hashColumns.put("ts_port_cd", getTsPortCd());
        this.hashColumns.put("pf_etd_dt", getPfEtdDt());
        this.hashColumns.put("co_cd", getCoCd());
        this.hashColumns.put("ttl_dlay_hrs", getTtlDlayHrs());
        this.hashColumns.put("pf_eta_dt", getPfEtaDt());
        this.hashColumns.put("rtv_flg", getRtvFlg());
        this.hashColumns.put("etd_delay_flg", getEtdDelayFlg());
        this.hashColumns.put("pf_etb_dt", getPfEtbDt());
        this.hashColumns.put("win_rmk", getWinRmk());
        this.hashColumns.put("act_inp_flg", getActInpFlg());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("upd_sts", getUpdSts());
        this.hashColumns.put("ib_cgo_qty", getIbCgoQty());
        this.hashColumns.put("seq", getSeq());
        this.hashColumns.put("st_port_cd", getStPortCd());
        this.hashColumns.put("add_vt_port_seq", getAddVtPortSeq());
        this.hashColumns.put("pf_lnk_dist", getPfLnkDist());
        this.hashColumns.put("pf_lnk_spd", getPfLnkSpd());
        this.hashColumns.put("pf_sea_buf_hrs", getPfSeaBufHrs());
        this.hashColumns.put("pf_port_buf_hrs", getPfPortBufHrs());
        this.hashColumns.put("pf_tztm_hrs", getPfTztmHrs());
        this.hashColumns.put("pf_act_wrk_hrs", getPfActWrkHrs());
        this.hashColumns.put("pf_mnvr_out_hrs", getPfMnvrOutHrs());
        this.hashColumns.put("pf_mnvr_in_hrs", getPfMnvrInHrs());
        this.hashColumns.put("ib_cssm_voy_no", getIbCssmVoyNo());
        this.hashColumns.put("vt_add_call_flg", getVtAddCallFlg());
        this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
        this.hashColumns.put("cssm_voy_init_cre_flg", getCssmVoyInitCreFlg());
        this.hashColumns.put("vsl_renm_old_vsl_cd", getVslRenmOldVslCd());
        this.hashColumns.put("vsl_renm_old_vsl_eng_nm", getVslRenmOldVslEngNm());
        this.hashColumns.put("vsl_renm_new_vsl_cd", getVslRenmNewVslCd());
        this.hashColumns.put("vsl_renm_new_vsl_eng_nm", getVslRenmNewVslEngNm());
        this.hashColumns.put("vsld_wks", getVsldWks());
        this.hashColumns.put("add_call_flg", getAddCallFlg());
        this.hashColumns.put("skp_call_flg", getSkpCallFlg());
        this.hashColumns.put("add_call_xter_flg", getAddCallXterFlg());
        this.hashColumns.put("priv_call_flg", getPrivCallFlg());
        this.hashColumns.put("ib_cssm_voy_no", getIbCssmVoyNo());
        this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
        this.hashColumns.put("turn_ib_cssm_voy_no", getTurnIbCssmVoyNo());
        this.hashColumns.put("first_turn_port_clpt_seq", getFirstTurnPortClptSeq());
        this.hashColumns.put("real_clpt_seq", getRealClptSeq());
        this.hashColumns.put("vir_port_clpt_seq", getVirPortClptSeq());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ofc_inp_flg", "ofcInpFlg");
        this.hashFields.put("ts_20ft_ttl_qty", "ts20ftTtlQty");
        this.hashFields.put("bnk_unit_amt", "bnkUnitAmt");
        this.hashFields.put("plism_voy_no", "plismVoyNo");
        this.hashFields.put("tml_cd", "tmlCd");
        this.hashFields.put("psdo_vvd_cd", "psdoVvdCd");
        this.hashFields.put("vps_port_cd", "vpsPortCd");
        this.hashFields.put("clpt_seq", "clptSeq");
        this.hashFields.put("skd_usd_ind_cd", "skdUsdIndCd");
        this.hashFields.put("tml_hndl_40ft_ttl_qty", "tmlHndl40ftTtlQty");
        this.hashFields.put("noon_rpt_inp_flg", "noonRptInpFlg");
        this.hashFields.put("ib_ipcgo_qty", "ibIpcgoQty");
        this.hashFields.put("vsl_dlay_rsn_desc", "vslDlayRsnDesc");
        this.hashFields.put("ob_ipcgo_qty", "obIpcgoQty");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("new_clpt_ind_seq", "newClptIndSeq");
        this.hashFields.put("init_eta_dt", "initEtaDt");
        this.hashFields.put("shp_call_no_upd_usr_id", "shpCallNoUpdUsrId");
        this.hashFields.put("cng_lane_cd", "cngLaneCd");
        this.hashFields.put("lnk_dist", "lnkDist");
        this.hashFields.put("ob_cgo_qty", "obCgoQty");
        this.hashFields.put("etd_dy_no", "etdDyNo");
        this.hashFields.put("n1st_port_brth_dt", "n1stPortBrthDt");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("tml_vsl_cd", "tmlVslCd");
        this.hashFields.put("edi_snd_knt", "ediSndKnt");
        this.hashFields.put("cng_vsl_cd", "cngVslCd");
        this.hashFields.put("etd_tm_hrmnt", "etdTmHrmnt");
        this.hashFields.put("tml_hndl_20ft_ttl_amt", "tmlHndl20ftTtlAmt");
        this.hashFields.put("etb_dy_no", "etbDyNo");
        this.hashFields.put("usd_flg", "usdFlg");
        this.hashFields.put("sea_buf_spd", "seaBufSpd");
        this.hashFields.put("vsl_dlay_rsn_loc_cd", "vslDlayRsnLocCd");
        this.hashFields.put("etb_dy_cd", "etbDyCd");
        this.hashFields.put("pf_skd_tp_cd", "pfSkdTpCd");
        this.hashFields.put("phs_io_rsn_cd", "phsIoRsnCd");
        this.hashFields.put("tml_prod_qty", "tmlProdQty");
        this.hashFields.put("turn_skd_dir_cd", "turnSkdDirCd");
        this.hashFields.put("port_skp_tp_cd", "portSkpTpCd");
        this.hashFields.put("eta_delay_flg", "etaDelayFlg");
        this.hashFields.put("skd_voy_tp_cd", "skdVoyTpCd");
        this.hashFields.put("skd_rmk", "skdRmk");
        this.hashFields.put("vsl_dlay_rsn_cd", "vslDlayRsnCd");
        this.hashFields.put("call_yd_ind_seq", "callYdIndSeq");
        this.hashFields.put("ts_20ft_ttl_amt", "ts20ftTtlAmt");
        this.hashFields.put("plism_vsl_cd", "plismVslCd");
        this.hashFields.put("dlay_date_text", "dlayDateText");
        this.hashFields.put("time_diff", "timeDiff");
        this.hashFields.put("ft_dt", "ftDt");
        this.hashFields.put("port_skp_rsn_offr_rmk", "portSkpRsnOffrRmk");
        this.hashFields.put("phs_io_rmk", "phsIoRmk");
        this.hashFields.put("sea_date_text", "seaDateText");
        this.hashFields.put("mnvr_in_hrs", "mnvrInHrs");
        this.hashFields.put("diff_rmk", "diffRmk");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("yd_cd", "ydCd");
        this.hashFields.put("to_loc_cd", "toLocCd");
        this.hashFields.put("fm_loc_cd", "fmLocCd");
        this.hashFields.put("port_dist", "portDist");
        this.hashFields.put("etb_tm_hrmnt", "etbTmHrmnt");
        this.hashFields.put("clpt_ind_seq", "clptIndSeq");
        this.hashFields.put("dep_rpt_inp_flg", "depRptInpFlg");
        this.hashFields.put("ts_40ft_ttl_qty", "ts40ftTtlQty");
        this.hashFields.put("bound", "bound");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("lnk_spd", "lnkSpd");
        this.hashFields.put("sea_buf_hrs", "seaBufHrs");
        this.hashFields.put("act_wrk_hrs", "actWrkHrs");
        this.hashFields.put("add_bnk_csm_qty", "addBnkCsmQty");
        this.hashFields.put("sim_no", "simNo");
        this.hashFields.put("turn_skd_voy_no", "turnSkdVoyNo");
        this.hashFields.put("port_buf_hrs", "portBufHrs");
        this.hashFields.put("cng_skd_voy_no", "cngSkdVoyNo");
        this.hashFields.put("init_skd_inp_flg", "initSkdInpFlg");
        this.hashFields.put("tztm_hrs", "tztmHrs");
        this.hashFields.put("etd_dy_cd", "etdDyCd");
        this.hashFields.put("ts_40ft_ttl_amt", "ts40ftTtlAmt");
        this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
        this.hashFields.put("pe_usd_ttl_amt", "peUsdTtlAmt");
        this.hashFields.put("skd_brth_no", "skdBrthNo");
        this.hashFields.put("tml_hndl_40ft_ttl_amt", "tmlHndl40ftTtlAmt");
        this.hashFields.put("port_skd_sts_cd", "portSkdStsCd");
        this.hashFields.put("etb_delay_flg", "etbDelayFlg");
        this.hashFields.put("vsl_sim_tp_cd", "vslSimTpCd");
        this.hashFields.put("vps_etd_dt", "vpsEtdDt");
        this.hashFields.put("init_etb_dt", "initEtbDt");
        this.hashFields.put("port_skp_rsn_cd", "portSkpRsnCd");
        this.hashFields.put("ib_ocn_cgo_qty", "ibOcnCgoQty");
        this.hashFields.put("plism_yd_cd", "plismYdCd");
        this.hashFields.put("init_etd_dt", "initEtdDt");
        this.hashFields.put("auto_skd_cng_flg", "autoSkdCngFlg");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("skd_cng_sts_cd", "skdCngStsCd");
        this.hashFields.put("bfr_act_flg", "bfrActFlg");
        this.hashFields.put("shp_call_no_upd_dt", "shpCallNoUpdDt");
        this.hashFields.put("cng_skd_dir_cd", "cngSkdDirCd");
        this.hashFields.put("usr_hdn_flg", "usrHdnFlg");
        this.hashFields.put("delay_date", "delayDate");
        this.hashFields.put("turn_clpt_ind_seq", "turnClptIndSeq");
        this.hashFields.put("mnvr_out_hrs", "mnvrOutHrs");
        this.hashFields.put("vps_etb_dt", "vpsEtbDt");
        this.hashFields.put("vps_rmk", "vpsRmk");
        this.hashFields.put("turn_port_flg", "turnPortFlg");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("sim_dt", "simDt");
        this.hashFields.put("vsl_slan_cd", "vslSlanCd");
        this.hashFields.put("tml_hndl_20ft_ttl_qty", "tmlHndl20ftTtlQty");
        this.hashFields.put("vps_eta_dt", "vpsEtaDt");
        this.hashFields.put("skd_sts_cd", "skdStsCd");
        this.hashFields.put("add_bnk_cost_amt", "addBnkCostAmt");
        this.hashFields.put("pf_svc_tp_cd", "pfSvcTpCd");
        this.hashFields.put("pf_spd", "pfSpd");
        this.hashFields.put("crn_knt", "crnKnt");
        this.hashFields.put("bnk_unit_qty", "bnkUnitQty");
        this.hashFields.put("tml_voy_no", "tmlVoyNo");
        this.hashFields.put("port_rotn_seq", "portRotnSeq");
        this.hashFields.put("ob_ocn_cgo_qty", "obOcnCgoQty");
        this.hashFields.put("shp_call_no", "shpCallNo");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("prt_chk_flg", "prtChkFlg");
        this.hashFields.put("ts_port_cd", "tsPortCd");
        this.hashFields.put("pf_etd_dt", "pfEtdDt");
        this.hashFields.put("co_cd", "coCd");
        this.hashFields.put("ttl_dlay_hrs", "ttlDlayHrs");
        this.hashFields.put("pf_eta_dt", "pfEtaDt");
        this.hashFields.put("rtv_flg", "rtvFlg");
        this.hashFields.put("etd_delay_flg", "etdDelayFlg");
        this.hashFields.put("pf_etb_dt", "pfEtbDt");
        this.hashFields.put("win_rmk", "winRmk");
        this.hashFields.put("act_inp_flg", "actInpFlg");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("upd_sts", "updSts");
        this.hashFields.put("ib_cgo_qty", "ibCgoQty");
        this.hashFields.put("seq", "seq");
        this.hashFields.put("st_port_cd", "stPortCd");
        this.hashFields.put("add_vt_port_seq", "addVtPortSeq");
        this.hashFields.put("pf_lnk_dist", "pfLnkDist");
        this.hashFields.put("pf_lnk_spd", "pfLnkSpd");
        this.hashFields.put("pf_sea_buf_hrs", "pfSeaBufHrs");
        this.hashFields.put("pf_port_buf_hrs", "pfPortBufHrs");
        this.hashFields.put("pf_tztm_hrs", "pfTztmHrs");
        this.hashFields.put("pf_act_wrk_hrs", "pfActWrkHrs");
        this.hashFields.put("pf_mnvr_out_hrs", "pfMnvrOutHrs");
        this.hashFields.put("pf_mnvr_in_hrs", "pfMnvrInHrs");
        this.hashFields.put("ib_cssm_voy_no", "ibCssmVoyNo");
        this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");
        this.hashFields.put("vt_add_call_flg", "vtAddCallFlg");
        this.hashFields.put("cssm_voy_init_cre_flg", "cssmVoyInitCreFlg");
        this.hashFields.put("vsl_renm_old_vsl_cd", "vslRenmOldVslCd");
        this.hashFields.put("vsl_renm_old_vsl_eng_nm", "vslRenmOldVslEngNm");
        this.hashFields.put("vsl_renm_new_vsl_cd", "vslRenmNewVslCd");
        this.hashFields.put("vsl_renm_new_vsl_eng_nm", "vslRenmNewVslEngNm");
        this.hashFields.put("vsld_wks", "vsldWks");
        this.hashFields.put("add_call_flg", "addCallFlg");
        this.hashFields.put("skp_call_flg", "skpCallFlg");
        this.hashFields.put("add_call_xter_flg", "addCallXterFlg");
        this.hashFields.put("priv_call_flg", "privCallFlg");
        this.hashFields.put("ib_cssm_voy_no", "ibCssmVoyNo");
        this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");
        this.hashFields.put("turn_ib_cssm_voy_no", "turnIbCssmVoyNo");
        this.hashFields.put("first_turn_port_clpt_seq", "firstTurnPortClptSeq");
        this.hashFields.put("real_clpt_seq", "realClptSeq");
        this.hashFields.put("vir_port_clpt_seq", "virPortClptSeq");
        return this.hashFields;
    }

    //	Getters	and	Setters
    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
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
	 * @return ofcInpFlg
	 */
    public String getOfcInpFlg() {
        return this.ofcInpFlg;
    }

    /**
	 * Column Info
	 * @return ts20ftTtlQty
	 */
    public String getTs20ftTtlQty() {
        return this.ts20ftTtlQty;
    }

    /**
	 * Column Info
	 * @return bnkUnitAmt
	 */
    public String getBnkUnitAmt() {
        return this.bnkUnitAmt;
    }

    /**
	 * Column Info
	 * @return plismVoyNo
	 */
    public String getPlismVoyNo() {
        return this.plismVoyNo;
    }

    /**
	 * Column Info
	 * @return tmlCd
	 */
    public String getTmlCd() {
        return this.tmlCd;
    }

    /**
	 * Column Info
	 * @return psdoVvdCd
	 */
    public String getPsdoVvdCd() {
        return this.psdoVvdCd;
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
	 * @return clptSeq
	 */
    public String getClptSeq() {
        return this.clptSeq;
    }

    /**
	 * Column Info
	 * @return skdUsdIndCd
	 */
    public String getSkdUsdIndCd() {
        return this.skdUsdIndCd;
    }

    /**
	 * Column Info
	 * @return tmlHndl40ftTtlQty
	 */
    public String getTmlHndl40ftTtlQty() {
        return this.tmlHndl40ftTtlQty;
    }

    /**
	 * Column Info
	 * @return noonRptInpFlg
	 */
    public String getNoonRptInpFlg() {
        return this.noonRptInpFlg;
    }

    /**
	 * Column Info
	 * @return ibIpcgoQty
	 */
    public String getIbIpcgoQty() {
        return this.ibIpcgoQty;
    }

    /**
	 * Column Info
	 * @return vslDlayRsnDesc
	 */
    public String getVslDlayRsnDesc() {
        return this.vslDlayRsnDesc;
    }

    /**
	 * Column Info
	 * @return obIpcgoQty
	 */
    public String getObIpcgoQty() {
        return this.obIpcgoQty;
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
	 * @return newClptIndSeq
	 */
    public String getNewClptIndSeq() {
        return this.newClptIndSeq;
    }

    /**
	 * Column Info
	 * @return initEtaDt
	 */
    public String getInitEtaDt() {
        return this.initEtaDt;
    }

    /**
	 * Column Info
	 * @return shpCallNoUpdUsrId
	 */
    public String getShpCallNoUpdUsrId() {
        return this.shpCallNoUpdUsrId;
    }

    /**
	 * Column Info
	 * @return cngLaneCd
	 */
    public String getCngLaneCd() {
        return this.cngLaneCd;
    }

    /**
	 * Column Info
	 * @return lnkDist
	 */
    public String getLnkDist() {
        return this.lnkDist;
    }

    /**
	 * Column Info
	 * @return obCgoQty
	 */
    public String getObCgoQty() {
        return this.obCgoQty;
    }

    /**
	 * Column Info
	 * @return etdDyNo
	 */
    public String getEtdDyNo() {
        return this.etdDyNo;
    }

    /**
	 * Column Info
	 * @return n1stPortBrthDt
	 */
    public String getN1stPortBrthDt() {
        return this.n1stPortBrthDt;
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
	 * @return tmlVslCd
	 */
    public String getTmlVslCd() {
        return this.tmlVslCd;
    }

    /**
	 * Column Info
	 * @return ediSndKnt
	 */
    public String getEdiSndKnt() {
        return this.ediSndKnt;
    }

    /**
	 * Column Info
	 * @return cngVslCd
	 */
    public String getCngVslCd() {
        return this.cngVslCd;
    }

    /**
	 * Column Info
	 * @return etdTmHrmnt
	 */
    public String getEtdTmHrmnt() {
        return this.etdTmHrmnt;
    }

    /**
	 * Column Info
	 * @return tmlHndl20ftTtlAmt
	 */
    public String getTmlHndl20ftTtlAmt() {
        return this.tmlHndl20ftTtlAmt;
    }

    /**
	 * Column Info
	 * @return etbDyNo
	 */
    public String getEtbDyNo() {
        return this.etbDyNo;
    }

    /**
	 * Column Info
	 * @return usdFlg
	 */
    public String getUsdFlg() {
        return this.usdFlg;
    }

    /**
	 * Column Info
	 * @return seaBufSpd
	 */
    public String getSeaBufSpd() {
        return this.seaBufSpd;
    }

    /**
	 * Column Info
	 * @return vslDlayRsnLocCd
	 */
    public String getVslDlayRsnLocCd() {
        return this.vslDlayRsnLocCd;
    }

    /**
	 * Column Info
	 * @return etbDyCd
	 */
    public String getEtbDyCd() {
        return this.etbDyCd;
    }

    /**
	 * Column Info
	 * @return pfSkdTpCd
	 */
    public String getPfSkdTpCd() {
        return this.pfSkdTpCd;
    }

    /**
	 * Column Info
	 * @return phsIoRsnCd
	 */
    public String getPhsIoRsnCd() {
        return this.phsIoRsnCd;
    }

    /**
	 * Column Info
	 * @return tmlProdQty
	 */
    public String getTmlProdQty() {
        return this.tmlProdQty;
    }

    /**
	 * Column Info
	 * @return turnSkdDirCd
	 */
    public String getTurnSkdDirCd() {
        return this.turnSkdDirCd;
    }

    /**
	 * Column Info
	 * @return portSkpTpCd
	 */
    public String getPortSkpTpCd() {
        return this.portSkpTpCd;
    }

    /**
	 * Column Info
	 * @return etaDelayFlg
	 */
    public String getEtaDelayFlg() {
        return this.etaDelayFlg;
    }

    /**
	 * Column Info
	 * @return skdVoyTpCd
	 */
    public String getSkdVoyTpCd() {
        return this.skdVoyTpCd;
    }

    /**
	 * Column Info
	 * @return skdRmk
	 */
    public String getSkdRmk() {
        return this.skdRmk;
    }

    /**
	 * Column Info
	 * @return vslDlayRsnCd
	 */
    public String getVslDlayRsnCd() {
        return this.vslDlayRsnCd;
    }

    /**
	 * Column Info
	 * @return callYdIndSeq
	 */
    public String getCallYdIndSeq() {
        return this.callYdIndSeq;
    }

    /**
	 * Column Info
	 * @return ts20ftTtlAmt
	 */
    public String getTs20ftTtlAmt() {
        return this.ts20ftTtlAmt;
    }

    /**
	 * Column Info
	 * @return plismVslCd
	 */
    public String getPlismVslCd() {
        return this.plismVslCd;
    }

    /**
	 * Column Info
	 * @return dlayDateText
	 */
    public String getDlayDateText() {
        return this.dlayDateText;
    }

    /**
	 * Column Info
	 * @return timeDiff
	 */
    public String getTimeDiff() {
        return this.timeDiff;
    }

    /**
	 * Column Info
	 * @return ftDt
	 */
    public String getFtDt() {
        return this.ftDt;
    }

    /**
	 * Column Info
	 * @return portSkpRsnOffrRmk
	 */
    public String getPortSkpRsnOffrRmk() {
        return this.portSkpRsnOffrRmk;
    }

    /**
	 * Column Info
	 * @return phsIoRmk
	 */
    public String getPhsIoRmk() {
        return this.phsIoRmk;
    }

    /**
	 * Column Info
	 * @return seaDateText
	 */
    public String getSeaDateText() {
        return this.seaDateText;
    }

    /**
	 * Column Info
	 * @return mnvrInHrs
	 */
    public String getMnvrInHrs() {
        return this.mnvrInHrs;
    }

    /**
	 * Column Info
	 * @return diffRmk
	 */
    public String getDiffRmk() {
        return this.diffRmk;
    }

    /**
	 * Column Info
	 * @return slanCd
	 */
    public String getSlanCd() {
        return this.slanCd;
    }

    /**
	 * Column Info
	 * @return ydCd
	 */
    public String getYdCd() {
        return this.ydCd;
    }

    /**
	 * Column Info
	 * @return etbTmHrmnt
	 */
    public String getEtbTmHrmnt() {
        return this.etbTmHrmnt;
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
	 * @return depRptInpFlg
	 */
    public String getDepRptInpFlg() {
        return this.depRptInpFlg;
    }

    /**
	 * Column Info
	 * @return ts40ftTtlQty
	 */
    public String getTs40ftTtlQty() {
        return this.ts40ftTtlQty;
    }

    /**
	 * Column Info
	 * @return bound
	 */
    public String getBound() {
        return this.bound;
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
	 * @return lnkSpd
	 */
    public String getLnkSpd() {
        return this.lnkSpd;
    }

    /**
	 * Column Info
	 * @return seaBufHrs
	 */
    public String getSeaBufHrs() {
        return this.seaBufHrs;
    }

    /**
	 * Column Info
	 * @return actWrkHrs
	 */
    public String getActWrkHrs() {
        return this.actWrkHrs;
    }

    /**
	 * Column Info
	 * @return addBnkCsmQty
	 */
    public String getAddBnkCsmQty() {
        return this.addBnkCsmQty;
    }

    /**
	 * Column Info
	 * @return simNo
	 */
    public String getSimNo() {
        return this.simNo;
    }

    /**
	 * Column Info
	 * @return turnSkdVoyNo
	 */
    public String getTurnSkdVoyNo() {
        return this.turnSkdVoyNo;
    }

    /**
	 * Column Info
	 * @return portBufHrs
	 */
    public String getPortBufHrs() {
        return this.portBufHrs;
    }

    /**
	 * Column Info
	 * @return cngSkdVoyNo
	 */
    public String getCngSkdVoyNo() {
        return this.cngSkdVoyNo;
    }

    /**
	 * Column Info
	 * @return initSkdInpFlg
	 */
    public String getInitSkdInpFlg() {
        return this.initSkdInpFlg;
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
	 * @return etdDyCd
	 */
    public String getEtdDyCd() {
        return this.etdDyCd;
    }

    /**
	 * Column Info
	 * @return ts40ftTtlAmt
	 */
    public String getTs40ftTtlAmt() {
        return this.ts40ftTtlAmt;
    }

    /**
	 * Column Info
	 * @return turnPortIndCd
	 */
    public String getTurnPortIndCd() {
        return this.turnPortIndCd;
    }

    /**
	 * Column Info
	 * @return peUsdTtlAmt
	 */
    public String getPeUsdTtlAmt() {
        return this.peUsdTtlAmt;
    }

    /**
	 * Column Info
	 * @return skdBrthNo
	 */
    public String getSkdBrthNo() {
        return this.skdBrthNo;
    }

    /**
	 * Column Info
	 * @return tmlHndl40ftTtlAmt
	 */
    public String getTmlHndl40ftTtlAmt() {
        return this.tmlHndl40ftTtlAmt;
    }

    /**
	 * Column Info
	 * @return portSkdStsCd
	 */
    public String getPortSkdStsCd() {
        return this.portSkdStsCd;
    }

    /**
	 * Column Info
	 * @return etbDelayFlg
	 */
    public String getEtbDelayFlg() {
        return this.etbDelayFlg;
    }

    /**
	 * Column Info
	 * @return vslSimTpCd
	 */
    public String getVslSimTpCd() {
        return this.vslSimTpCd;
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
	 * @return initEtbDt
	 */
    public String getInitEtbDt() {
        return this.initEtbDt;
    }

    /**
	 * Column Info
	 * @return portSkpRsnCd
	 */
    public String getPortSkpRsnCd() {
        return this.portSkpRsnCd;
    }

    /**
	 * Column Info
	 * @return ibOcnCgoQty
	 */
    public String getIbOcnCgoQty() {
        return this.ibOcnCgoQty;
    }

    /**
	 * Column Info
	 * @return plismYdCd
	 */
    public String getPlismYdCd() {
        return this.plismYdCd;
    }

    /**
	 * Column Info
	 * @return initEtdDt
	 */
    public String getInitEtdDt() {
        return this.initEtdDt;
    }

    /**
	 * Column Info
	 * @return autoSkdCngFlg
	 */
    public String getAutoSkdCngFlg() {
        return this.autoSkdCngFlg;
    }

    /**
	 * Column Info
	 * @return vvd
	 */
    public String getVvd() {
        return this.vvd;
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
	 * @return skdCngStsCd
	 */
    public String getSkdCngStsCd() {
        return this.skdCngStsCd;
    }

    /**
	 * Column Info
	 * @return bfrActFlg
	 */
    public String getBfrActFlg() {
        return this.bfrActFlg;
    }

    /**
	 * Column Info
	 * @return shpCallNoUpdDt
	 */
    public String getShpCallNoUpdDt() {
        return this.shpCallNoUpdDt;
    }

    /**
	 * Column Info
	 * @return cngSkdDirCd
	 */
    public String getCngSkdDirCd() {
        return this.cngSkdDirCd;
    }

    /**
	 * Column Info
	 * @return usrHdnFlg
	 */
    public String getUsrHdnFlg() {
        return this.usrHdnFlg;
    }

    /**
	 * Column Info
	 * @return delayDate
	 */
    public String getDelayDate() {
        return this.delayDate;
    }

    /**
	 * Column Info
	 * @return turnClptIndSeq
	 */
    public String getTurnClptIndSeq() {
        return this.turnClptIndSeq;
    }

    /**
	 * Column Info
	 * @return mnvrOutHrs
	 */
    public String getMnvrOutHrs() {
        return this.mnvrOutHrs;
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
	 * @return vpsRmk
	 */
    public String getVpsRmk() {
        return this.vpsRmk;
    }

    /**
	 * Column Info
	 * @return turnPortFlg
	 */
    public String getTurnPortFlg() {
        return this.turnPortFlg;
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
	 * @return simDt
	 */
    public String getSimDt() {
        return this.simDt;
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
	 * @return tmlHndl20ftTtlQty
	 */
    public String getTmlHndl20ftTtlQty() {
        return this.tmlHndl20ftTtlQty;
    }

    /**
	 * Column Info
	 * @return vpsEtaDt
	 */
    public String getVpsEtaDt() {
        return this.vpsEtaDt;
    }

    /**
	 * Column Info
	 * @return skdStsCd
	 */
    public String getSkdStsCd() {
        return this.skdStsCd;
    }

    /**
	 * Column Info
	 * @return addBnkCostAmt
	 */
    public String getAddBnkCostAmt() {
        return this.addBnkCostAmt;
    }

    /**
	 * Column Info
	 * @return pfSvcTpCd
	 */
    public String getPfSvcTpCd() {
        return this.pfSvcTpCd;
    }

    /**
	 * Column Info
	 * @return pfSpd
	 */
    public String getPfSpd() {
        return this.pfSpd;
    }

    /**
	 * Column Info
	 * @return crnKnt
	 */
    public String getCrnKnt() {
        return this.crnKnt;
    }

    /**
	 * Column Info
	 * @return bnkUnitQty
	 */
    public String getBnkUnitQty() {
        return this.bnkUnitQty;
    }

    /**
	 * Column Info
	 * @return tmlVoyNo
	 */
    public String getTmlVoyNo() {
        return this.tmlVoyNo;
    }

    /**
	 * Column Info
	 * @return portRotnSeq
	 */
    public String getPortRotnSeq() {
        return this.portRotnSeq;
    }

    /**
	 * Column Info
	 * @return obOcnCgoQty
	 */
    public String getObOcnCgoQty() {
        return this.obOcnCgoQty;
    }

    /**
	 * Column Info
	 * @return shpCallNo
	 */
    public String getShpCallNo() {
        return this.shpCallNo;
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
	 * @return prtChkFlg
	 */
    public String getPrtChkFlg() {
        return this.prtChkFlg;
    }

    /**
	 * Column Info
	 * @return tsPortCd
	 */
    public String getTsPortCd() {
        return this.tsPortCd;
    }

    /**
	 * Column Info
	 * @return pfEtdDt
	 */
    public String getPfEtdDt() {
        return this.pfEtdDt;
    }

    /**
	 * Column Info
	 * @return coCd
	 */
    public String getCoCd() {
        return this.coCd;
    }

    /**
	 * Column Info
	 * @return ttlDlayHrs
	 */
    public String getTtlDlayHrs() {
        return this.ttlDlayHrs;
    }

    /**
	 * Column Info
	 * @return pfEtaDt
	 */
    public String getPfEtaDt() {
        return this.pfEtaDt;
    }

    /**
	 * Column Info
	 * @return rtvFlg
	 */
    public String getRtvFlg() {
        return this.rtvFlg;
    }

    /**
	 * Column Info
	 * @return etdDelayFlg
	 */
    public String getEtdDelayFlg() {
        return this.etdDelayFlg;
    }

    /**
	 * Column Info
	 * @return pfEtbDt
	 */
    public String getPfEtbDt() {
        return this.pfEtbDt;
    }

    /**
	 * Column Info
	 * @return winRmk
	 */
    public String getWinRmk() {
        return this.winRmk;
    }

    /**
	 * Column Info
	 * @return actInpFlg
	 */
    public String getActInpFlg() {
        return this.actInpFlg;
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
	 * @return updSts
	 */
    public String getUpdSts() {
        return this.updSts;
    }

    /**
	 * Column Info
	 * @return ibCgoQty
	 */
    public String getIbCgoQty() {
        return this.ibCgoQty;
    }

    /**
	 * Column Info
	 * @return seq
	 */
    public String getSeq() {
        return this.seq;
    }

    /**
	 * Column Info
	 * @return stPortCd
	 */
    public String getStPortCd() {
        return this.stPortCd;
    }

    /**
	 * Column Info
	 * @return addVtPortSeq
	 */
    public String getAddVtPortSeq() {
        return this.addVtPortSeq;
    }

    /**
	 * Column Info
	 * @return pfLnkDist
	 */
    public String getPfLnkDist() {
        return this.pfLnkDist;
    }

    /**
	 * Column Info
	 * @return pfLnkSpd
	 */
    public String getPfLnkSpd() {
        return this.pfLnkSpd;
    }

    /**
	 * Column Info
	 * @return pfSeaBufHrs
	 */
    public String getPfSeaBufHrs() {
        return this.pfSeaBufHrs;
    }

    /**
	 * Column Info
	 * @return pfPortBufHrs
	 */
    public String getPfPortBufHrs() {
        return this.pfPortBufHrs;
    }

    /**
	 * Column Info
	 * @return pfTztmHrs
	 */
    public String getPfTztmHrs() {
        return this.pfTztmHrs;
    }

    /**
	 * Column Info
	 * @return pfActWrkHrs
	 */
    public String getPfActWrkHrs() {
        return this.pfActWrkHrs;
    }

    /**
	 * Column Info
	 * @return pfMnvrOutHrs
	 */
    public String getPfMnvrOutHrs() {
        return this.pfMnvrOutHrs;
    }

    /**
	 * Column Info
	 * @return pfMnvrInHrs
	 */
    public String getPfMnvrInHrs() {
        return this.pfMnvrInHrs;
    }

    /**
	 * Column Info
	 * @return vtAddCallFlg
	 */
    public String getVtAddCallFlg() {
        return this.vtAddCallFlg;
    }

    /**
 	* Column Info
 	* @return vslRenmOldVslCd
 	*/
    public String getVslRenmOldVslCd() {
        return this.vslRenmOldVslCd;
    }

    /**
 	* Column Info
 	* @return vslRenmOldVslEngNm
 	*/
    public String getVslRenmOldVslEngNm() {
        return this.vslRenmOldVslEngNm;
    }

    /**
 	* Column Info
 	* @return vslRenmNewVslCd
 	*/
    public String getVslRenmNewVslCd() {
        return this.vslRenmNewVslCd;
    }

    /**
 	* Column Info
 	* @return vslRenmNewVslEngNm
 	*/
    public String getVslRenmNewVslEngNm() {
        return this.vslRenmNewVslEngNm;
    }

    /**
 	* Column Info
 	* @return vsldWks
 	*/
    public String getVsldWks() {
        return this.vsldWks;
    }

    /**
	* Column Info
	* @return addCallFlg
	*/
    public String getAddCallFlg() {
        return this.addCallFlg;
    }

    /**
	* Column Info
	* @return skpCallFlg
	*/
    public String getSkpCallFlg() {
        return this.skpCallFlg;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  vtAddCallFlg
 	 */
    public void setVtAddCallFlg(String vtAddCallFlg) {
        this.vtAddCallFlg = vtAddCallFlg;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Page Number
	 * @param  pagerows
 	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * @param  ofcInpFlg
 	 */
    public void setOfcInpFlg(String ofcInpFlg) {
        this.ofcInpFlg = ofcInpFlg;
    }

    /**
	 * Column Info
	 * @param  ts20ftTtlQty
 	 */
    public void setTs20ftTtlQty(String ts20ftTtlQty) {
        this.ts20ftTtlQty = ts20ftTtlQty;
    }

    /**
	 * Column Info
	 * @param  bnkUnitAmt
 	 */
    public void setBnkUnitAmt(String bnkUnitAmt) {
        this.bnkUnitAmt = bnkUnitAmt;
    }

    /**
	 * Column Info
	 * @param  plismVoyNo
 	 */
    public void setPlismVoyNo(String plismVoyNo) {
        this.plismVoyNo = plismVoyNo;
    }

    /**
	 * Column Info
	 * @param  tmlCd
 	 */
    public void setTmlCd(String tmlCd) {
        this.tmlCd = tmlCd;
    }

    /**
	 * Column Info
	 * @param  psdoVvdCd
 	 */
    public void setPsdoVvdCd(String psdoVvdCd) {
        this.psdoVvdCd = psdoVvdCd;
    }

    /**
	 * Column Info
	 * @param  vpsPortCd
 	 */
    public void setVpsPortCd(String vpsPortCd) {
        this.vpsPortCd = vpsPortCd;
    }

    /**
	 * Column Info
	 * @param  clptSeq
 	 */
    public void setClptSeq(String clptSeq) {
        this.clptSeq = clptSeq;
    }

    /**
	 * Column Info
	 * @param  skdUsdIndCd
 	 */
    public void setSkdUsdIndCd(String skdUsdIndCd) {
        this.skdUsdIndCd = skdUsdIndCd;
    }

    /**
	 * Column Info
	 * @param  tmlHndl40ftTtlQty
 	 */
    public void setTmlHndl40ftTtlQty(String tmlHndl40ftTtlQty) {
        this.tmlHndl40ftTtlQty = tmlHndl40ftTtlQty;
    }

    /**
	 * Column Info
	 * @param  noonRptInpFlg
 	 */
    public void setNoonRptInpFlg(String noonRptInpFlg) {
        this.noonRptInpFlg = noonRptInpFlg;
    }

    /**
	 * Column Info
	 * @param  ibIpcgoQty
 	 */
    public void setIbIpcgoQty(String ibIpcgoQty) {
        this.ibIpcgoQty = ibIpcgoQty;
    }

    /**
	 * Column Info
	 * @param  vslDlayRsnDesc
 	 */
    public void setVslDlayRsnDesc(String vslDlayRsnDesc) {
        this.vslDlayRsnDesc = vslDlayRsnDesc;
    }

    /**
	 * Column Info
	 * @param  obIpcgoQty
 	 */
    public void setObIpcgoQty(String obIpcgoQty) {
        this.obIpcgoQty = obIpcgoQty;
    }

    /**
	 * Column Info
	 * @param  updUsrId
 	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * Column Info
	 * @param  newClptIndSeq
 	 */
    public void setNewClptIndSeq(String newClptIndSeq) {
        this.newClptIndSeq = newClptIndSeq;
    }

    /**
	 * Column Info
	 * @param  initEtaDt
 	 */
    public void setInitEtaDt(String initEtaDt) {
        this.initEtaDt = initEtaDt;
    }

    /**
	 * Column Info
	 * @param  shpCallNoUpdUsrId
 	 */
    public void setShpCallNoUpdUsrId(String shpCallNoUpdUsrId) {
        this.shpCallNoUpdUsrId = shpCallNoUpdUsrId;
    }

    /**
	 * Column Info
	 * @param  cngLaneCd
 	 */
    public void setCngLaneCd(String cngLaneCd) {
        this.cngLaneCd = cngLaneCd;
    }

    /**
	 * Column Info
	 * @param  lnkDist
 	 */
    public void setLnkDist(String lnkDist) {
        this.lnkDist = lnkDist;
    }

    /**
	 * Column Info
	 * @param  obCgoQty
 	 */
    public void setObCgoQty(String obCgoQty) {
        this.obCgoQty = obCgoQty;
    }

    /**
	 * Column Info
	 * @param  etdDyNo
 	 */
    public void setEtdDyNo(String etdDyNo) {
        this.etdDyNo = etdDyNo;
    }

    /**
	 * Column Info
	 * @param  n1stPortBrthDt
 	 */
    public void setN1stPortBrthDt(String n1stPortBrthDt) {
        this.n1stPortBrthDt = n1stPortBrthDt;
    }

    /**
	 * Column Info
	 * @param  skdVoyNo
 	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * Column Info
	 * @param  tmlVslCd
 	 */
    public void setTmlVslCd(String tmlVslCd) {
        this.tmlVslCd = tmlVslCd;
    }

    /**
	 * Column Info
	 * @param  ediSndKnt
 	 */
    public void setEdiSndKnt(String ediSndKnt) {
        this.ediSndKnt = ediSndKnt;
    }

    /**
	 * Column Info
	 * @param  cngVslCd
 	 */
    public void setCngVslCd(String cngVslCd) {
        this.cngVslCd = cngVslCd;
    }

    /**
	 * Column Info
	 * @param  etdTmHrmnt
 	 */
    public void setEtdTmHrmnt(String etdTmHrmnt) {
        this.etdTmHrmnt = etdTmHrmnt;
    }

    /**
	 * Column Info
	 * @param  tmlHndl20ftTtlAmt
 	 */
    public void setTmlHndl20ftTtlAmt(String tmlHndl20ftTtlAmt) {
        this.tmlHndl20ftTtlAmt = tmlHndl20ftTtlAmt;
    }

    /**
	 * Column Info
	 * @param  etbDyNo
 	 */
    public void setEtbDyNo(String etbDyNo) {
        this.etbDyNo = etbDyNo;
    }

    /**
	 * Column Info
	 * @param  usdFlg
 	 */
    public void setUsdFlg(String usdFlg) {
        this.usdFlg = usdFlg;
    }

    /**
	 * Column Info
	 * @param  seaBufSpd
 	 */
    public void setSeaBufSpd(String seaBufSpd) {
        this.seaBufSpd = seaBufSpd;
    }

    /**
	 * Column Info
	 * @param  vslDlayRsnLocCd
 	 */
    public void setVslDlayRsnLocCd(String vslDlayRsnLocCd) {
        this.vslDlayRsnLocCd = vslDlayRsnLocCd;
    }

    /**
	 * Column Info
	 * @param  etbDyCd
 	 */
    public void setEtbDyCd(String etbDyCd) {
        this.etbDyCd = etbDyCd;
    }

    /**
	 * Column Info
	 * @param  pfSkdTpCd
 	 */
    public void setPfSkdTpCd(String pfSkdTpCd) {
        this.pfSkdTpCd = pfSkdTpCd;
    }

    /**
	 * Column Info
	 * @param  phsIoRsnCd
 	 */
    public void setPhsIoRsnCd(String phsIoRsnCd) {
        this.phsIoRsnCd = phsIoRsnCd;
    }

    /**
	 * Column Info
	 * @param  tmlProdQty
 	 */
    public void setTmlProdQty(String tmlProdQty) {
        this.tmlProdQty = tmlProdQty;
    }

    /**
	 * Column Info
	 * @param  turnSkdDirCd
 	 */
    public void setTurnSkdDirCd(String turnSkdDirCd) {
        this.turnSkdDirCd = turnSkdDirCd;
    }

    /**
	 * Column Info
	 * @param  portSkpTpCd
 	 */
    public void setPortSkpTpCd(String portSkpTpCd) {
        this.portSkpTpCd = portSkpTpCd;
    }

    /**
	 * Column Info
	 * @param  etaDelayFlg
 	 */
    public void setEtaDelayFlg(String etaDelayFlg) {
        this.etaDelayFlg = etaDelayFlg;
    }

    /**
	 * Column Info
	 * @param  skdVoyTpCd
 	 */
    public void setSkdVoyTpCd(String skdVoyTpCd) {
        this.skdVoyTpCd = skdVoyTpCd;
    }

    /**
	 * Column Info
	 * @param  skdRmk
 	 */
    public void setSkdRmk(String skdRmk) {
        this.skdRmk = skdRmk;
    }

    /**
	 * Column Info
	 * @param  vslDlayRsnCd
 	 */
    public void setVslDlayRsnCd(String vslDlayRsnCd) {
        this.vslDlayRsnCd = vslDlayRsnCd;
    }

    /**
	 * Column Info
	 * @param  callYdIndSeq
 	 */
    public void setCallYdIndSeq(String callYdIndSeq) {
        this.callYdIndSeq = callYdIndSeq;
    }

    /**
	 * Column Info
	 * @param  ts20ftTtlAmt
 	 */
    public void setTs20ftTtlAmt(String ts20ftTtlAmt) {
        this.ts20ftTtlAmt = ts20ftTtlAmt;
    }

    /**
	 * Column Info
	 * @param  plismVslCd
 	 */
    public void setPlismVslCd(String plismVslCd) {
        this.plismVslCd = plismVslCd;
    }

    /**
	 * Column Info
	 * @param  dlayDateText
 	 */
    public void setDlayDateText(String dlayDateText) {
        this.dlayDateText = dlayDateText;
    }

    /**
	 * Column Info
	 * @param  timeDiff
 	 */
    public void setTimeDiff(String timeDiff) {
        this.timeDiff = timeDiff;
    }

    /**
	 * Column Info
	 * @param  ftDt
 	 */
    public void setFtDt(String ftDt) {
        this.ftDt = ftDt;
    }

    /**
	 * Column Info
	 * @param  portSkpRsnOffrRmk
 	 */
    public void setPortSkpRsnOffrRmk(String portSkpRsnOffrRmk) {
        this.portSkpRsnOffrRmk = portSkpRsnOffrRmk;
    }

    /**
	 * Column Info
	 * @param  phsIoRmk
 	 */
    public void setPhsIoRmk(String phsIoRmk) {
        this.phsIoRmk = phsIoRmk;
    }

    /**
	 * Column Info
	 * @param  seaDateText
 	 */
    public void setSeaDateText(String seaDateText) {
        this.seaDateText = seaDateText;
    }

    /**
	 * Column Info
	 * @param  mnvrInHrs
 	 */
    public void setMnvrInHrs(String mnvrInHrs) {
        this.mnvrInHrs = mnvrInHrs;
    }

    /**
	 * Column Info
	 * @param  diffRmk
 	 */
    public void setDiffRmk(String diffRmk) {
        this.diffRmk = diffRmk;
    }

    /**
	 * Column Info
	 * @param  slanCd
 	 */
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    /**
	 * Column Info
	 * @param  ydCd
 	 */
    public void setYdCd(String ydCd) {
        this.ydCd = ydCd;
    }

    /**
	 * Column Info
	 * @param  etbTmHrmnt
 	 */
    public void setEtbTmHrmnt(String etbTmHrmnt) {
        this.etbTmHrmnt = etbTmHrmnt;
    }

    /**
	 * Column Info
	 * @param  clptIndSeq
 	 */
    public void setClptIndSeq(String clptIndSeq) {
        this.clptIndSeq = clptIndSeq;
    }

    /**
	 * Column Info
	 * @param  depRptInpFlg
 	 */
    public void setDepRptInpFlg(String depRptInpFlg) {
        this.depRptInpFlg = depRptInpFlg;
    }

    /**
	 * Column Info
	 * @param  ts40ftTtlQty
 	 */
    public void setTs40ftTtlQty(String ts40ftTtlQty) {
        this.ts40ftTtlQty = ts40ftTtlQty;
    }

    /**
	 * Column Info
	 * @param  bound
 	 */
    public void setBound(String bound) {
        this.bound = bound;
    }

    /**
	 * Column Info
	 * @param  vslCd
 	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * Column Info
	 * @param  lnkSpd
 	 */
    public void setLnkSpd(String lnkSpd) {
        this.lnkSpd = lnkSpd;
    }

    /**
	 * Column Info
	 * @param  seaBufHrs
 	 */
    public void setSeaBufHrs(String seaBufHrs) {
        this.seaBufHrs = seaBufHrs;
    }

    /**
	 * Column Info
	 * @param  actWrkHrs
 	 */
    public void setActWrkHrs(String actWrkHrs) {
        this.actWrkHrs = actWrkHrs;
    }

    /**
	 * Column Info
	 * @param  addBnkCsmQty
 	 */
    public void setAddBnkCsmQty(String addBnkCsmQty) {
        this.addBnkCsmQty = addBnkCsmQty;
    }

    /**
	 * Column Info
	 * @param  simNo
 	 */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
	 * Column Info
	 * @param  turnSkdVoyNo
 	 */
    public void setTurnSkdVoyNo(String turnSkdVoyNo) {
        this.turnSkdVoyNo = turnSkdVoyNo;
    }

    /**
	 * Column Info
	 * @param  portBufHrs
 	 */
    public void setPortBufHrs(String portBufHrs) {
        this.portBufHrs = portBufHrs;
    }

    /**
	 * Column Info
	 * @param  cngSkdVoyNo
 	 */
    public void setCngSkdVoyNo(String cngSkdVoyNo) {
        this.cngSkdVoyNo = cngSkdVoyNo;
    }

    /**
	 * Column Info
	 * @param  initSkdInpFlg
 	 */
    public void setInitSkdInpFlg(String initSkdInpFlg) {
        this.initSkdInpFlg = initSkdInpFlg;
    }

    /**
	 * Column Info
	 * @param  tztmHrs
 	 */
    public void setTztmHrs(String tztmHrs) {
        this.tztmHrs = tztmHrs;
    }

    /**
	 * Column Info
	 * @param  etdDyCd
 	 */
    public void setEtdDyCd(String etdDyCd) {
        this.etdDyCd = etdDyCd;
    }

    /**
	 * Column Info
	 * @param  ts40ftTtlAmt
 	 */
    public void setTs40ftTtlAmt(String ts40ftTtlAmt) {
        this.ts40ftTtlAmt = ts40ftTtlAmt;
    }

    /**
	 * Column Info
	 * @param  turnPortIndCd
 	 */
    public void setTurnPortIndCd(String turnPortIndCd) {
        this.turnPortIndCd = turnPortIndCd;
    }

    /**
	 * Column Info
	 * @param  peUsdTtlAmt
 	 */
    public void setPeUsdTtlAmt(String peUsdTtlAmt) {
        this.peUsdTtlAmt = peUsdTtlAmt;
    }

    /**
	 * Column Info
	 * @param  skdBrthNo
 	 */
    public void setSkdBrthNo(String skdBrthNo) {
        this.skdBrthNo = skdBrthNo;
    }

    /**
	 * Column Info
	 * @param  tmlHndl40ftTtlAmt
 	 */
    public void setTmlHndl40ftTtlAmt(String tmlHndl40ftTtlAmt) {
        this.tmlHndl40ftTtlAmt = tmlHndl40ftTtlAmt;
    }

    /**
	 * Column Info
	 * @param  portSkdStsCd
 	 */
    public void setPortSkdStsCd(String portSkdStsCd) {
        this.portSkdStsCd = portSkdStsCd;
    }

    /**
	 * Column Info
	 * @param  etbDelayFlg
 	 */
    public void setEtbDelayFlg(String etbDelayFlg) {
        this.etbDelayFlg = etbDelayFlg;
    }

    /**
	 * Column Info
	 * @param  vslSimTpCd
 	 */
    public void setVslSimTpCd(String vslSimTpCd) {
        this.vslSimTpCd = vslSimTpCd;
    }

    /**
	 * Column Info
	 * @param  vpsEtdDt
 	 */
    public void setVpsEtdDt(String vpsEtdDt) {
        this.vpsEtdDt = vpsEtdDt;
    }

    /**
	 * Column Info
	 * @param  initEtbDt
 	 */
    public void setInitEtbDt(String initEtbDt) {
        this.initEtbDt = initEtbDt;
    }

    /**
	 * Column Info
	 * @param  portSkpRsnCd
 	 */
    public void setPortSkpRsnCd(String portSkpRsnCd) {
        this.portSkpRsnCd = portSkpRsnCd;
    }

    /**
	 * Column Info
	 * @param  ibOcnCgoQty
 	 */
    public void setIbOcnCgoQty(String ibOcnCgoQty) {
        this.ibOcnCgoQty = ibOcnCgoQty;
    }

    /**
	 * Column Info
	 * @param  plismYdCd
 	 */
    public void setPlismYdCd(String plismYdCd) {
        this.plismYdCd = plismYdCd;
    }

    /**
	 * Column Info
	 * @param  initEtdDt
 	 */
    public void setInitEtdDt(String initEtdDt) {
        this.initEtdDt = initEtdDt;
    }

    /**
	 * Column Info
	 * @param  autoSkdCngFlg
 	 */
    public void setAutoSkdCngFlg(String autoSkdCngFlg) {
        this.autoSkdCngFlg = autoSkdCngFlg;
    }

    /**
	 * Column Info
	 * @param  vvd
 	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    /**
	 * Column Info
	 * @param  creUsrId
 	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * Column Info
	 * @param  skdCngStsCd
 	 */
    public void setSkdCngStsCd(String skdCngStsCd) {
        this.skdCngStsCd = skdCngStsCd;
    }

    /**
	 * Column Info
	 * @param  bfrActFlg
 	 */
    public void setBfrActFlg(String bfrActFlg) {
        this.bfrActFlg = bfrActFlg;
    }

    /**
	 * Column Info
	 * @param  shpCallNoUpdDt
 	 */
    public void setShpCallNoUpdDt(String shpCallNoUpdDt) {
        this.shpCallNoUpdDt = shpCallNoUpdDt;
    }

    /**
	 * Column Info
	 * @param  cngSkdDirCd
 	 */
    public void setCngSkdDirCd(String cngSkdDirCd) {
        this.cngSkdDirCd = cngSkdDirCd;
    }

    /**
	 * Column Info
	 * @param  usrHdnFlg
 	 */
    public void setUsrHdnFlg(String usrHdnFlg) {
        this.usrHdnFlg = usrHdnFlg;
    }

    /**
	 * Column Info
	 * @param  delayDate
 	 */
    public void setDelayDate(String delayDate) {
        this.delayDate = delayDate;
    }

    /**
	 * Column Info
	 * @param  turnClptIndSeq
 	 */
    public void setTurnClptIndSeq(String turnClptIndSeq) {
        this.turnClptIndSeq = turnClptIndSeq;
    }

    /**
	 * Column Info
	 * @param  mnvrOutHrs
 	 */
    public void setMnvrOutHrs(String mnvrOutHrs) {
        this.mnvrOutHrs = mnvrOutHrs;
    }

    /**
	 * Column Info
	 * @param  vpsEtbDt
 	 */
    public void setVpsEtbDt(String vpsEtbDt) {
        this.vpsEtbDt = vpsEtbDt;
    }

    /**
	 * Column Info
	 * @param  vpsRmk
 	 */
    public void setVpsRmk(String vpsRmk) {
        this.vpsRmk = vpsRmk;
    }

    /**
	 * Column Info
	 * @param  turnPortFlg
 	 */
    public void setTurnPortFlg(String turnPortFlg) {
        this.turnPortFlg = turnPortFlg;
    }

    /**
	 * Column Info
	 * @param  creDt
 	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * Column Info
	 * @param  simDt
 	 */
    public void setSimDt(String simDt) {
        this.simDt = simDt;
    }

    /**
	 * Column Info
	 * @param  vslSlanCd
 	 */
    public void setVslSlanCd(String vslSlanCd) {
        this.vslSlanCd = vslSlanCd;
    }

    /**
	 * Column Info
	 * @param  tmlHndl20ftTtlQty
 	 */
    public void setTmlHndl20ftTtlQty(String tmlHndl20ftTtlQty) {
        this.tmlHndl20ftTtlQty = tmlHndl20ftTtlQty;
    }

    /**
	 * Column Info
	 * @param  vpsEtaDt
 	 */
    public void setVpsEtaDt(String vpsEtaDt) {
        this.vpsEtaDt = vpsEtaDt;
    }

    /**
	 * Column Info
	 * @param  skdStsCd
 	 */
    public void setSkdStsCd(String skdStsCd) {
        this.skdStsCd = skdStsCd;
    }

    /**
	 * Column Info
	 * @param  addBnkCostAmt
 	 */
    public void setAddBnkCostAmt(String addBnkCostAmt) {
        this.addBnkCostAmt = addBnkCostAmt;
    }

    /**
	 * Column Info
	 * @param  pfSvcTpCd
 	 */
    public void setPfSvcTpCd(String pfSvcTpCd) {
        this.pfSvcTpCd = pfSvcTpCd;
    }

    /**
	 * Column Info
	 * @param  pfSpd
 	 */
    public void setPfSpd(String pfSpd) {
        this.pfSpd = pfSpd;
    }

    /**
	 * Column Info
	 * @param  crnKnt
 	 */
    public void setCrnKnt(String crnKnt) {
        this.crnKnt = crnKnt;
    }

    /**
	 * Column Info
	 * @param  bnkUnitQty
 	 */
    public void setBnkUnitQty(String bnkUnitQty) {
        this.bnkUnitQty = bnkUnitQty;
    }

    /**
	 * Column Info
	 * @param  tmlVoyNo
 	 */
    public void setTmlVoyNo(String tmlVoyNo) {
        this.tmlVoyNo = tmlVoyNo;
    }

    /**
	 * Column Info
	 * @param  portRotnSeq
 	 */
    public void setPortRotnSeq(String portRotnSeq) {
        this.portRotnSeq = portRotnSeq;
    }

    /**
	 * Column Info
	 * @param  obOcnCgoQty
 	 */
    public void setObOcnCgoQty(String obOcnCgoQty) {
        this.obOcnCgoQty = obOcnCgoQty;
    }

    /**
	 * Column Info
	 * @param  shpCallNo
 	 */
    public void setShpCallNo(String shpCallNo) {
        this.shpCallNo = shpCallNo;
    }

    /**
	 * Column Info
	 * @param  updDt
 	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * Column Info
	 * @param  prtChkFlg
 	 */
    public void setPrtChkFlg(String prtChkFlg) {
        this.prtChkFlg = prtChkFlg;
    }

    /**
	 * Column Info
	 * @param  tsPortCd
 	 */
    public void setTsPortCd(String tsPortCd) {
        this.tsPortCd = tsPortCd;
    }

    /**
	 * Column Info
	 * @param  pfEtdDt
 	 */
    public void setPfEtdDt(String pfEtdDt) {
        this.pfEtdDt = pfEtdDt;
    }

    /**
	 * Column Info
	 * @param  coCd
 	 */
    public void setCoCd(String coCd) {
        this.coCd = coCd;
    }

    /**
	 * Column Info
	 * @param  ttlDlayHrs
 	 */
    public void setTtlDlayHrs(String ttlDlayHrs) {
        this.ttlDlayHrs = ttlDlayHrs;
    }

    /**
	 * Column Info
	 * @param  pfEtaDt
 	 */
    public void setPfEtaDt(String pfEtaDt) {
        this.pfEtaDt = pfEtaDt;
    }

    /**
	 * Column Info
	 * @param  rtvFlg
 	 */
    public void setRtvFlg(String rtvFlg) {
        this.rtvFlg = rtvFlg;
    }

    /**
	 * Column Info
	 * @param  etdDelayFlg
 	 */
    public void setEtdDelayFlg(String etdDelayFlg) {
        this.etdDelayFlg = etdDelayFlg;
    }

    /**
	 * Column Info
	 * @param  pfEtbDt
 	 */
    public void setPfEtbDt(String pfEtbDt) {
        this.pfEtbDt = pfEtbDt;
    }

    /**
	 * Column Info
	 * @param  winRmk
 	 */
    public void setWinRmk(String winRmk) {
        this.winRmk = winRmk;
    }

    /**
	 * Column Info
	 * @param  actInpFlg
 	 */
    public void setActInpFlg(String actInpFlg) {
        this.actInpFlg = actInpFlg;
    }

    /**
	 * Column Info
	 * @param  skdDirCd
 	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * Column Info
	 * @param  updSts
 	 */
    public void setUpdSts(String updSts) {
        this.updSts = updSts;
    }

    /**
	 * Column Info
	 * @param  ibCgoQty
 	 */
    public void setIbCgoQty(String ibCgoQty) {
        this.ibCgoQty = ibCgoQty;
    }

    /**
	 * Column Info
	 * @param  seq
 	 */
    public void setSeq(String seq) {
        this.seq = seq;
    }

    /**
	 * Column Info
	 * @param  stPortCd
 	 */
    public void setStPortCd(String stPortCd) {
        this.stPortCd = stPortCd;
    }

    /**
	 * Column Info
	 * @param  addVtPortSeq
 	 */
    public void setAddVtPortSeq(String addVtPortSeq) {
        this.addVtPortSeq = addVtPortSeq;
    }

    /**
	 * Column Info
	 * @param  pfLnkDist
 	 */
    public void setPfLnkDist(String pfLnkDist) {
        this.pfLnkDist = pfLnkDist;
    }

    /**
	 * Column Info
	 * @param  pfLnkSpd
 	 */
    public void setPfLnkSpd(String pfLnkSpd) {
        this.pfLnkSpd = pfLnkSpd;
    }

    /**
	 * Column Info
	 * @param  pfSeaBufHrs
 	 */
    public void setPfSeaBufHrs(String pfSeaBufHrs) {
        this.pfSeaBufHrs = pfSeaBufHrs;
    }

    /**
	 * Column Info
	 * @param  pfPortBufHrs
 	 */
    public void setPfPortBufHrs(String pfPortBufHrs) {
        this.pfPortBufHrs = pfPortBufHrs;
    }

    /**
	 * Column Info
	 * @param  pfTztmHrs
 	 */
    public void setPfTztmHrs(String pfTztmHrs) {
        this.pfTztmHrs = pfTztmHrs;
    }

    /**
	 * Column Info
	 * @param  pfActWrkHrs
 	 */
    public void setPfActWrkHrs(String pfActWrkHrs) {
        this.pfActWrkHrs = pfActWrkHrs;
    }

    /**
	 * Column Info
	 * @param  pfMnvrOutHrs
 	 */
    public void setPfMnvrOutHrs(String pfMnvrOutHrs) {
        this.pfMnvrOutHrs = pfMnvrOutHrs;
    }

    /**
	 * Column Info
	 * @param  pfMnvrInHrs
 	 */
    public void setPfMnvrInHrs(String pfMnvrInHrs) {
        this.pfMnvrInHrs = pfMnvrInHrs;
    }

    /**
	 * Column Info
	 * @return fmLocCd
	 */
    public String getFmLocCd() {
        return this.fmLocCd;
    }

    /**
	 * Column Info
	 * @return toLocCd
	 */
    public String getToLocCd() {
        return this.toLocCd;
    }

    /**
	 * Column Info
	 * @return portDist
	 */
    public String getPortDist() {
        return this.portDist;
    }

    /**
	 * Column Info
	 * @param portDist
	 */
    public void setPortDist(String portDist) {
        this.portDist = portDist;
    }

    /**
	 * Column Info
	 * @param toLocCd
	 */
    public void setToLocCd(String toLocCd) {
        this.toLocCd = toLocCd;
    }

    /**
	 * Column Info
	 * @param fmLocCd
	 */
    public void setFmLocCd(String fmLocCd) {
        this.fmLocCd = fmLocCd;
    }

    public void setCssmVoyInitCreFlg(String cssmVoyInitCreFlg) {
        this.cssmVoyInitCreFlg = cssmVoyInitCreFlg;
    }

    public String getCssmVoyInitCreFlg() {
        return this.cssmVoyInitCreFlg;
    }

    /**
	 * Column Info
	 * @param  vslRenmOldVslCd
 	 */
    public void setVslRenmOldVslCd(String vslRenmOldVslCd) {
        this.vslRenmOldVslCd = vslRenmOldVslCd;
    }

    /**
	 * Column Info
	 * @param  vslRenmOldVslEngNm
 	 */
    public void setVslRenmOldVslEngNm(String vslRenmOldVslEngNm) {
        this.vslRenmOldVslEngNm = vslRenmOldVslEngNm;
    }

    /**
	 * Column Info
	 * @param  vslRenmNewVslCd
 	 */
    public void setVslRenmNewVslCd(String vslRenmNewVslCd) {
        this.vslRenmNewVslCd = vslRenmNewVslCd;
    }

    /**
	 * Column Info
	 * @param  vslRenmNewVslEngNm
 	 */
    public void setVslRenmNewVslEngNm(String vslRenmNewVslEngNm) {
        this.vslRenmNewVslEngNm = vslRenmNewVslEngNm;
    }

    /**
	 * Column Info
	 * @param  vsldWks
 	 */
    public void setVsldWks(String vsldWks) {
        this.vsldWks = vsldWks;
    }

    /**
	 * Column Info
	 * @param  addCallFlg
 	 */
    public void setAddCallFlg(String addCallFlg) {
        this.addCallFlg = addCallFlg;
    }

    /**
	 * Column Info
	 * @param skpCallFlg
 	 */
    public void setSkpCallFlg(String skpCallFlg) {
        this.skpCallFlg = skpCallFlg;
    }

    public void setAddCallXterFlg(String addCallXterFlg) {
        this.addCallXterFlg = addCallXterFlg;
    }

    public String getAddCallXterFlg() {
        return this.addCallXterFlg;
    }

    public void setPrivCallFlg(String privCallFlg) {
        this.privCallFlg = privCallFlg;
    }

    public String getPrivCallFlg() {
        return this.privCallFlg;
    }

    public void setIbCssmVoyNo(String ibCssmVoyNo) {
        this.ibCssmVoyNo = ibCssmVoyNo;
    }

    public String getIbCssmVoyNo() {
        return this.ibCssmVoyNo;
    }

    public void setObCssmVoyNo(String obCssmVoyNo) {
        this.obCssmVoyNo = obCssmVoyNo;
    }

    public String getObCssmVoyNo() {
        return this.obCssmVoyNo;
    }

    public void setTurnIbCssmVoyNo(String turnIbCssmVoyNo) {
        this.turnIbCssmVoyNo = turnIbCssmVoyNo;
    }

    public String getTurnIbCssmVoyNo() {
        return this.turnIbCssmVoyNo;
    }

    public void setFirstTurnPortClptSeq(String firstTurnPortClptSeq) {
        this.firstTurnPortClptSeq = firstTurnPortClptSeq;
    }

    public String getFirstTurnPortClptSeq() {
        return this.firstTurnPortClptSeq;
    }

    public void setRealClptSeq(String realClptSeq) {
        this.realClptSeq = realClptSeq;
    }

    public String getRealClptSeq() {
        return this.realClptSeq;
    }

    public void setVirPortClptSeq(String virPortClptSeq) {
        this.virPortClptSeq = virPortClptSeq;
    }

    public String getVirPortClptSeq() {
        return this.virPortClptSeq;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setOfcInpFlg(JSPUtil.getParameter(request, prefix + "ofc_inp_flg", ""));
        setTs20ftTtlQty(JSPUtil.getParameter(request, prefix + "ts_20ft_ttl_qty", ""));
        setBnkUnitAmt(JSPUtil.getParameter(request, prefix + "bnk_unit_amt", ""));
        setPlismVoyNo(JSPUtil.getParameter(request, prefix + "plism_voy_no", ""));
        setTmlCd(JSPUtil.getParameter(request, prefix + "tml_cd", ""));
        setPsdoVvdCd(JSPUtil.getParameter(request, prefix + "psdo_vvd_cd", ""));
        setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
        setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
        setSkdUsdIndCd(JSPUtil.getParameter(request, prefix + "skd_usd_ind_cd", ""));
        setTmlHndl40ftTtlQty(JSPUtil.getParameter(request, prefix + "tml_hndl_40ft_ttl_qty", ""));
        setNoonRptInpFlg(JSPUtil.getParameter(request, prefix + "noon_rpt_inp_flg", ""));
        setIbIpcgoQty(JSPUtil.getParameter(request, prefix + "ib_ipcgo_qty", ""));
        setVslDlayRsnDesc(JSPUtil.getParameter(request, prefix + "vsl_dlay_rsn_desc", ""));
        setObIpcgoQty(JSPUtil.getParameter(request, prefix + "ob_ipcgo_qty", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setNewClptIndSeq(JSPUtil.getParameter(request, prefix + "new_clpt_ind_seq", ""));
        setInitEtaDt(JSPUtil.getParameter(request, prefix + "init_eta_dt", ""));
        setShpCallNoUpdUsrId(JSPUtil.getParameter(request, prefix + "shp_call_no_upd_usr_id", ""));
        setCngLaneCd(JSPUtil.getParameter(request, prefix + "cng_lane_cd", ""));
        setLnkDist(JSPUtil.getParameter(request, prefix + "lnk_dist", ""));
        setObCgoQty(JSPUtil.getParameter(request, prefix + "ob_cgo_qty", ""));
        setEtdDyNo(JSPUtil.getParameter(request, prefix + "etd_dy_no", ""));
        setN1stPortBrthDt(JSPUtil.getParameter(request, prefix + "n1st_port_brth_dt", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setTmlVslCd(JSPUtil.getParameter(request, prefix + "tml_vsl_cd", ""));
        setEdiSndKnt(JSPUtil.getParameter(request, prefix + "edi_snd_knt", ""));
        setCngVslCd(JSPUtil.getParameter(request, prefix + "cng_vsl_cd", ""));
        setEtdTmHrmnt(JSPUtil.getParameter(request, prefix + "etd_tm_hrmnt", ""));
        setTmlHndl20ftTtlAmt(JSPUtil.getParameter(request, prefix + "tml_hndl_20ft_ttl_amt", ""));
        setEtbDyNo(JSPUtil.getParameter(request, prefix + "etb_dy_no", ""));
        setUsdFlg(JSPUtil.getParameter(request, prefix + "usd_flg", ""));
        setSeaBufSpd(JSPUtil.getParameter(request, prefix + "sea_buf_spd", ""));
        setVslDlayRsnLocCd(JSPUtil.getParameter(request, prefix + "vsl_dlay_rsn_loc_cd", ""));
        setEtbDyCd(JSPUtil.getParameter(request, prefix + "etb_dy_cd", ""));
        setPfSkdTpCd(JSPUtil.getParameter(request, prefix + "pf_skd_tp_cd", ""));
        setPhsIoRsnCd(JSPUtil.getParameter(request, prefix + "phs_io_rsn_cd", ""));
        setTmlProdQty(JSPUtil.getParameter(request, prefix + "tml_prod_qty", ""));
        setTurnSkdDirCd(JSPUtil.getParameter(request, prefix + "turn_skd_dir_cd", ""));
        setPortSkpTpCd(JSPUtil.getParameter(request, prefix + "port_skp_tp_cd", ""));
        setEtaDelayFlg(JSPUtil.getParameter(request, prefix + "eta_delay_flg", ""));
        setSkdVoyTpCd(JSPUtil.getParameter(request, prefix + "skd_voy_tp_cd", ""));
        setSkdRmk(JSPUtil.getParameter(request, prefix + "skd_rmk", ""));
        setVslDlayRsnCd(JSPUtil.getParameter(request, prefix + "vsl_dlay_rsn_cd", ""));
        setCallYdIndSeq(JSPUtil.getParameter(request, prefix + "call_yd_ind_seq", ""));
        setTs20ftTtlAmt(JSPUtil.getParameter(request, prefix + "ts_20ft_ttl_amt", ""));
        setPlismVslCd(JSPUtil.getParameter(request, prefix + "plism_vsl_cd", ""));
        setDlayDateText(JSPUtil.getParameter(request, prefix + "dlay_date_text", ""));
        setTimeDiff(JSPUtil.getParameter(request, prefix + "time_diff", ""));
        setFtDt(JSPUtil.getParameter(request, prefix + "ft_dt", ""));
        setPortSkpRsnOffrRmk(JSPUtil.getParameter(request, prefix + "port_skp_rsn_offr_rmk", ""));
        setPhsIoRmk(JSPUtil.getParameter(request, prefix + "phs_io_rmk", ""));
        setSeaDateText(JSPUtil.getParameter(request, prefix + "sea_date_text", ""));
        setMnvrInHrs(JSPUtil.getParameter(request, prefix + "mnvr_in_hrs", ""));
        setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
        setEtbTmHrmnt(JSPUtil.getParameter(request, prefix + "etb_tm_hrmnt", ""));
        setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
        setDepRptInpFlg(JSPUtil.getParameter(request, prefix + "dep_rpt_inp_flg", ""));
        setTs40ftTtlQty(JSPUtil.getParameter(request, prefix + "ts_40ft_ttl_qty", ""));
        setBound(JSPUtil.getParameter(request, prefix + "bound", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setLnkSpd(JSPUtil.getParameter(request, prefix + "lnk_spd", ""));
        setSeaBufHrs(JSPUtil.getParameter(request, prefix + "sea_buf_hrs", ""));
        setActWrkHrs(JSPUtil.getParameter(request, prefix + "act_wrk_hrs", ""));
        setAddBnkCsmQty(JSPUtil.getParameter(request, prefix + "add_bnk_csm_qty", ""));
        setSimNo(JSPUtil.getParameter(request, prefix + "sim_no", ""));
        setTurnSkdVoyNo(JSPUtil.getParameter(request, prefix + "turn_skd_voy_no", ""));
        setPortBufHrs(JSPUtil.getParameter(request, prefix + "port_buf_hrs", ""));
        setCngSkdVoyNo(JSPUtil.getParameter(request, prefix + "cng_skd_voy_no", ""));
        setInitSkdInpFlg(JSPUtil.getParameter(request, prefix + "init_skd_inp_flg", ""));
        setTztmHrs(JSPUtil.getParameter(request, prefix + "tztm_hrs", ""));
        setEtdDyCd(JSPUtil.getParameter(request, prefix + "etd_dy_cd", ""));
        setTs40ftTtlAmt(JSPUtil.getParameter(request, prefix + "ts_40ft_ttl_amt", ""));
        setTurnPortIndCd(JSPUtil.getParameter(request, prefix + "turn_port_ind_cd", ""));
        setPeUsdTtlAmt(JSPUtil.getParameter(request, prefix + "pe_usd_ttl_amt", ""));
        setSkdBrthNo(JSPUtil.getParameter(request, prefix + "skd_brth_no", ""));
        setTmlHndl40ftTtlAmt(JSPUtil.getParameter(request, prefix + "tml_hndl_40ft_ttl_amt", ""));
        setPortSkdStsCd(JSPUtil.getParameter(request, prefix + "port_skd_sts_cd", ""));
        setEtbDelayFlg(JSPUtil.getParameter(request, prefix + "etb_delay_flg", ""));
        setVslSimTpCd(JSPUtil.getParameter(request, prefix + "vsl_sim_tp_cd", ""));
        setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
        setInitEtbDt(JSPUtil.getParameter(request, prefix + "init_etb_dt", ""));
        setPortSkpRsnCd(JSPUtil.getParameter(request, prefix + "port_skp_rsn_cd", ""));
        setIbOcnCgoQty(JSPUtil.getParameter(request, prefix + "ib_ocn_cgo_qty", ""));
        setPlismYdCd(JSPUtil.getParameter(request, prefix + "plism_yd_cd", ""));
        setInitEtdDt(JSPUtil.getParameter(request, prefix + "init_etd_dt", ""));
        setAutoSkdCngFlg(JSPUtil.getParameter(request, prefix + "auto_skd_cng_flg", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setSkdCngStsCd(JSPUtil.getParameter(request, prefix + "skd_cng_sts_cd", ""));
        setBfrActFlg(JSPUtil.getParameter(request, prefix + "bfr_act_flg", ""));
        setShpCallNoUpdDt(JSPUtil.getParameter(request, prefix + "shp_call_no_upd_dt", ""));
        setCngSkdDirCd(JSPUtil.getParameter(request, prefix + "cng_skd_dir_cd", ""));
        setUsrHdnFlg(JSPUtil.getParameter(request, prefix + "usr_hdn_flg", ""));
        setDelayDate(JSPUtil.getParameter(request, prefix + "delay_date", ""));
        setTurnClptIndSeq(JSPUtil.getParameter(request, prefix + "turn_clpt_ind_seq", ""));
        setMnvrOutHrs(JSPUtil.getParameter(request, prefix + "mnvr_out_hrs", ""));
        setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
        setVpsRmk(JSPUtil.getParameter(request, prefix + "vps_rmk", ""));
        setTurnPortFlg(JSPUtil.getParameter(request, prefix + "turn_port_flg", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setSimDt(JSPUtil.getParameter(request, prefix + "sim_dt", ""));
        setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
        setTmlHndl20ftTtlQty(JSPUtil.getParameter(request, prefix + "tml_hndl_20ft_ttl_qty", ""));
        setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
        setSkdStsCd(JSPUtil.getParameter(request, prefix + "skd_sts_cd", ""));
        setAddBnkCostAmt(JSPUtil.getParameter(request, prefix + "add_bnk_cost_amt", ""));
        setPfSvcTpCd(JSPUtil.getParameter(request, prefix + "pf_svc_tp_cd", ""));
        setPfSpd(JSPUtil.getParameter(request, prefix + "pf_spd", ""));
        setCrnKnt(JSPUtil.getParameter(request, prefix + "crn_knt", ""));
        setBnkUnitQty(JSPUtil.getParameter(request, prefix + "bnk_unit_qty", ""));
        setTmlVoyNo(JSPUtil.getParameter(request, prefix + "tml_voy_no", ""));
        setPortRotnSeq(JSPUtil.getParameter(request, prefix + "port_rotn_seq", ""));
        setObOcnCgoQty(JSPUtil.getParameter(request, prefix + "ob_ocn_cgo_qty", ""));
        setShpCallNo(JSPUtil.getParameter(request, prefix + "shp_call_no", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setPrtChkFlg(JSPUtil.getParameter(request, prefix + "prt_chk_flg", ""));
        setTsPortCd(JSPUtil.getParameter(request, prefix + "ts_port_cd", ""));
        setPfEtdDt(JSPUtil.getParameter(request, prefix + "pf_etd_dt", ""));
        setCoCd(JSPUtil.getParameter(request, prefix + "co_cd", ""));
        setTtlDlayHrs(JSPUtil.getParameter(request, prefix + "ttl_dlay_hrs", ""));
        setPfEtaDt(JSPUtil.getParameter(request, prefix + "pf_eta_dt", ""));
        setRtvFlg(JSPUtil.getParameter(request, prefix + "rtv_flg", ""));
        setEtdDelayFlg(JSPUtil.getParameter(request, prefix + "etd_delay_flg", ""));
        setPfEtbDt(JSPUtil.getParameter(request, prefix + "pf_etb_dt", ""));
        setWinRmk(JSPUtil.getParameter(request, prefix + "win_rmk", ""));
        setActInpFlg(JSPUtil.getParameter(request, prefix + "act_inp_flg", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setUpdSts(JSPUtil.getParameter(request, prefix + "upd_sts", ""));
        setIbCgoQty(JSPUtil.getParameter(request, prefix + "ib_cgo_qty", ""));
        setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
        setStPortCd(JSPUtil.getParameter(request, prefix + "st_port_cd", ""));
        setAddVtPortSeq(JSPUtil.getParameter(request, prefix + "add_vt_port_seq", ""));
        setPfLnkDist(JSPUtil.getParameter(request, prefix + "pf_lnk_dist", ""));
        setPfLnkSpd(JSPUtil.getParameter(request, prefix + "pf_lnk_spd", ""));
        setPfSeaBufHrs(JSPUtil.getParameter(request, prefix + "pf_sea_buf_hrs", ""));
        setPfPortBufHrs(JSPUtil.getParameter(request, prefix + "pf_port_buf_hrs", ""));
        setPfTztmHrs(JSPUtil.getParameter(request, prefix + "pf_tztm_hrs", ""));
        setPfActWrkHrs(JSPUtil.getParameter(request, prefix + "pf_act_wrk_hrs", ""));
        setPfMnvrOutHrs(JSPUtil.getParameter(request, prefix + "pf_mnvr_out_hrs", ""));
        setPfMnvrInHrs(JSPUtil.getParameter(request, prefix + "pf_mnvr_in_hrs", ""));
        setIbCssmVoyNo(JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", ""));
        setObCssmVoyNo(JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", ""));
        setToLocCd(JSPUtil.getParameter(request, "to_loc_cd", ""));
        setFmLocCd(JSPUtil.getParameter(request, "fm_loc_cd", ""));
        setPortDist(JSPUtil.getParameter(request, "port_dist", ""));
        setVtAddCallFlg(JSPUtil.getParameter(request, "vt_add_call_flg", ""));
        setCssmVoyInitCreFlg(JSPUtil.getParameter(request, prefix + "cssm_voy_init_cre_flg", ""));
        setVslRenmOldVslCd(JSPUtil.getParameter(request, prefix + "vsl_renm_old_vsl_cd", ""));
        setVslRenmOldVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_renm_old_vsl_eng_nm", ""));
        setVslRenmNewVslCd(JSPUtil.getParameter(request, prefix + "vsl_renm_new_vsl_cd", ""));
        setVslRenmNewVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_renm_new_vsl_eng_nm", ""));
        setVsldWks(JSPUtil.getParameter(request, prefix + "vsld_wks", ""));
        setAddCallFlg(JSPUtil.getParameter(request, prefix + "add_call_flg", ""));
        setSkpCallFlg(JSPUtil.getParameter(request, prefix + "skp_call_flg", ""));
        setAddCallXterFlg(JSPUtil.getParameter(request, prefix + "add_call_xter_flg", ""));
        setPrivCallFlg(JSPUtil.getParameter(request, prefix + "priv_call_flg", ""));
        setIbCssmVoyNo(JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", ""));
        setObCssmVoyNo(JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", ""));
        setTurnIbCssmVoyNo(JSPUtil.getParameter(request, prefix + "turn_ib_cssm_voy_no", ""));
        setFirstTurnPortClptSeq(JSPUtil.getParameter(request, prefix + "first_turn_port_clpt_seq", ""));
        setRealClptSeq(JSPUtil.getParameter(request, prefix + "real_clpt_seq", ""));
        setVirPortClptSeq(JSPUtil.getParameter(request, prefix + "vir_port_clpt_seq", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SwapCstSkdSimVO[]
	 */
    public SwapCstSkdSimVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SwapCstSkdSimVO[]
	 */
    public SwapCstSkdSimVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SwapCstSkdSimVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ofcInpFlg = (JSPUtil.getParameter(request, prefix + "ofc_inp_flg", length));
            String[] ts20ftTtlQty = (JSPUtil.getParameter(request, prefix + "ts_20ft_ttl_qty", length));
            String[] bnkUnitAmt = (JSPUtil.getParameter(request, prefix + "bnk_unit_amt", length));
            String[] plismVoyNo = (JSPUtil.getParameter(request, prefix + "plism_voy_no", length));
            String[] tmlCd = (JSPUtil.getParameter(request, prefix + "tml_cd", length));
            String[] psdoVvdCd = (JSPUtil.getParameter(request, prefix + "psdo_vvd_cd", length));
            String[] vpsPortCd = (JSPUtil.getParameter(request, prefix + "vps_port_cd", length));
            String[] clptSeq = (JSPUtil.getParameter(request, prefix + "clpt_seq", length));
            String[] skdUsdIndCd = (JSPUtil.getParameter(request, prefix + "skd_usd_ind_cd", length));
            String[] tmlHndl40ftTtlQty = (JSPUtil.getParameter(request, prefix + "tml_hndl_40ft_ttl_qty", length));
            String[] noonRptInpFlg = (JSPUtil.getParameter(request, prefix + "noon_rpt_inp_flg", length));
            String[] ibIpcgoQty = (JSPUtil.getParameter(request, prefix + "ib_ipcgo_qty", length));
            String[] vslDlayRsnDesc = (JSPUtil.getParameter(request, prefix + "vsl_dlay_rsn_desc", length));
            String[] obIpcgoQty = (JSPUtil.getParameter(request, prefix + "ob_ipcgo_qty", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] newClptIndSeq = (JSPUtil.getParameter(request, prefix + "new_clpt_ind_seq", length));
            String[] initEtaDt = (JSPUtil.getParameter(request, prefix + "init_eta_dt", length));
            String[] shpCallNoUpdUsrId = (JSPUtil.getParameter(request, prefix + "shp_call_no_upd_usr_id", length));
            String[] cngLaneCd = (JSPUtil.getParameter(request, prefix + "cng_lane_cd", length));
            String[] lnkDist = (JSPUtil.getParameter(request, prefix + "lnk_dist", length));
            String[] obCgoQty = (JSPUtil.getParameter(request, prefix + "ob_cgo_qty", length));
            String[] etdDyNo = (JSPUtil.getParameter(request, prefix + "etd_dy_no", length));
            String[] n1stPortBrthDt = (JSPUtil.getParameter(request, prefix + "n1st_port_brth_dt", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] tmlVslCd = (JSPUtil.getParameter(request, prefix + "tml_vsl_cd", length));
            String[] ediSndKnt = (JSPUtil.getParameter(request, prefix + "edi_snd_knt", length));
            String[] cngVslCd = (JSPUtil.getParameter(request, prefix + "cng_vsl_cd", length));
            String[] etdTmHrmnt = (JSPUtil.getParameter(request, prefix + "etd_tm_hrmnt", length));
            String[] tmlHndl20ftTtlAmt = (JSPUtil.getParameter(request, prefix + "tml_hndl_20ft_ttl_amt", length));
            String[] etbDyNo = (JSPUtil.getParameter(request, prefix + "etb_dy_no", length));
            String[] usdFlg = (JSPUtil.getParameter(request, prefix + "usd_flg", length));
            String[] seaBufSpd = (JSPUtil.getParameter(request, prefix + "sea_buf_spd", length));
            String[] vslDlayRsnLocCd = (JSPUtil.getParameter(request, prefix + "vsl_dlay_rsn_loc_cd", length));
            String[] etbDyCd = (JSPUtil.getParameter(request, prefix + "etb_dy_cd", length));
            String[] pfSkdTpCd = (JSPUtil.getParameter(request, prefix + "pf_skd_tp_cd", length));
            String[] phsIoRsnCd = (JSPUtil.getParameter(request, prefix + "phs_io_rsn_cd", length));
            String[] tmlProdQty = (JSPUtil.getParameter(request, prefix + "tml_prod_qty", length));
            String[] turnSkdDirCd = (JSPUtil.getParameter(request, prefix + "turn_skd_dir_cd", length));
            String[] portSkpTpCd = (JSPUtil.getParameter(request, prefix + "port_skp_tp_cd", length));
            String[] etaDelayFlg = (JSPUtil.getParameter(request, prefix + "eta_delay_flg", length));
            String[] skdVoyTpCd = (JSPUtil.getParameter(request, prefix + "skd_voy_tp_cd", length));
            String[] skdRmk = (JSPUtil.getParameter(request, prefix + "skd_rmk", length));
            String[] vslDlayRsnCd = (JSPUtil.getParameter(request, prefix + "vsl_dlay_rsn_cd", length));
            String[] callYdIndSeq = (JSPUtil.getParameter(request, prefix + "call_yd_ind_seq", length));
            String[] ts20ftTtlAmt = (JSPUtil.getParameter(request, prefix + "ts_20ft_ttl_amt", length));
            String[] plismVslCd = (JSPUtil.getParameter(request, prefix + "plism_vsl_cd", length));
            String[] dlayDateText = (JSPUtil.getParameter(request, prefix + "dlay_date_text", length));
            String[] timeDiff = (JSPUtil.getParameter(request, prefix + "time_diff", length));
            String[] ftDt = (JSPUtil.getParameter(request, prefix + "ft_dt", length));
            String[] portSkpRsnOffrRmk = (JSPUtil.getParameter(request, prefix + "port_skp_rsn_offr_rmk", length));
            String[] phsIoRmk = (JSPUtil.getParameter(request, prefix + "phs_io_rmk", length));
            String[] seaDateText = (JSPUtil.getParameter(request, prefix + "sea_date_text", length));
            String[] mnvrInHrs = (JSPUtil.getParameter(request, prefix + "mnvr_in_hrs", length));
            String[] diffRmk = (JSPUtil.getParameter(request, prefix + "diff_rmk", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] ydCd = (JSPUtil.getParameter(request, prefix + "yd_cd", length));
            String[] etbTmHrmnt = (JSPUtil.getParameter(request, prefix + "etb_tm_hrmnt", length));
            String[] clptIndSeq = (JSPUtil.getParameter(request, prefix + "clpt_ind_seq", length));
            String[] depRptInpFlg = (JSPUtil.getParameter(request, prefix + "dep_rpt_inp_flg", length));
            String[] ts40ftTtlQty = (JSPUtil.getParameter(request, prefix + "ts_40ft_ttl_qty", length));
            String[] bound = (JSPUtil.getParameter(request, prefix + "bound", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] lnkSpd = (JSPUtil.getParameter(request, prefix + "lnk_spd", length));
            String[] seaBufHrs = (JSPUtil.getParameter(request, prefix + "sea_buf_hrs", length));
            String[] actWrkHrs = (JSPUtil.getParameter(request, prefix + "act_wrk_hrs", length));
            String[] addBnkCsmQty = (JSPUtil.getParameter(request, prefix + "add_bnk_csm_qty", length));
            String[] simNo = (JSPUtil.getParameter(request, prefix + "sim_no", length));
            String[] turnSkdVoyNo = (JSPUtil.getParameter(request, prefix + "turn_skd_voy_no", length));
            String[] portBufHrs = (JSPUtil.getParameter(request, prefix + "port_buf_hrs", length));
            String[] cngSkdVoyNo = (JSPUtil.getParameter(request, prefix + "cng_skd_voy_no", length));
            String[] initSkdInpFlg = (JSPUtil.getParameter(request, prefix + "init_skd_inp_flg", length));
            String[] tztmHrs = (JSPUtil.getParameter(request, prefix + "tztm_hrs", length));
            String[] etdDyCd = (JSPUtil.getParameter(request, prefix + "etd_dy_cd", length));
            String[] ts40ftTtlAmt = (JSPUtil.getParameter(request, prefix + "ts_40ft_ttl_amt", length));
            String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix + "turn_port_ind_cd", length));
            String[] peUsdTtlAmt = (JSPUtil.getParameter(request, prefix + "pe_usd_ttl_amt", length));
            String[] skdBrthNo = (JSPUtil.getParameter(request, prefix + "skd_brth_no", length));
            String[] tmlHndl40ftTtlAmt = (JSPUtil.getParameter(request, prefix + "tml_hndl_40ft_ttl_amt", length));
            String[] portSkdStsCd = (JSPUtil.getParameter(request, prefix + "port_skd_sts_cd", length));
            String[] etbDelayFlg = (JSPUtil.getParameter(request, prefix + "etb_delay_flg", length));
            String[] vslSimTpCd = (JSPUtil.getParameter(request, prefix + "vsl_sim_tp_cd", length));
            String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix + "vps_etd_dt", length));
            String[] initEtbDt = (JSPUtil.getParameter(request, prefix + "init_etb_dt", length));
            String[] portSkpRsnCd = (JSPUtil.getParameter(request, prefix + "port_skp_rsn_cd", length));
            String[] ibOcnCgoQty = (JSPUtil.getParameter(request, prefix + "ib_ocn_cgo_qty", length));
            String[] plismYdCd = (JSPUtil.getParameter(request, prefix + "plism_yd_cd", length));
            String[] initEtdDt = (JSPUtil.getParameter(request, prefix + "init_etd_dt", length));
            String[] autoSkdCngFlg = (JSPUtil.getParameter(request, prefix + "auto_skd_cng_flg", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] skdCngStsCd = (JSPUtil.getParameter(request, prefix + "skd_cng_sts_cd", length));
            String[] bfrActFlg = (JSPUtil.getParameter(request, prefix + "bfr_act_flg", length));
            String[] shpCallNoUpdDt = (JSPUtil.getParameter(request, prefix + "shp_call_no_upd_dt", length));
            String[] cngSkdDirCd = (JSPUtil.getParameter(request, prefix + "cng_skd_dir_cd", length));
            String[] usrHdnFlg = (JSPUtil.getParameter(request, prefix + "usr_hdn_flg", length));
            String[] delayDate = (JSPUtil.getParameter(request, prefix + "delay_date", length));
            String[] turnClptIndSeq = (JSPUtil.getParameter(request, prefix + "turn_clpt_ind_seq", length));
            String[] mnvrOutHrs = (JSPUtil.getParameter(request, prefix + "mnvr_out_hrs", length));
            String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix + "vps_etb_dt", length));
            String[] vpsRmk = (JSPUtil.getParameter(request, prefix + "vps_rmk", length));
            String[] turnPortFlg = (JSPUtil.getParameter(request, prefix + "turn_port_flg", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] simDt = (JSPUtil.getParameter(request, prefix + "sim_dt", length));
            String[] vslSlanCd = (JSPUtil.getParameter(request, prefix + "vsl_slan_cd", length));
            String[] tmlHndl20ftTtlQty = (JSPUtil.getParameter(request, prefix + "tml_hndl_20ft_ttl_qty", length));
            String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix + "vps_eta_dt", length));
            String[] skdStsCd = (JSPUtil.getParameter(request, prefix + "skd_sts_cd", length));
            String[] addBnkCostAmt = (JSPUtil.getParameter(request, prefix + "add_bnk_cost_amt", length));
            String[] pfSvcTpCd = (JSPUtil.getParameter(request, prefix + "pf_svc_tp_cd", length));
            String[] pfSpd = (JSPUtil.getParameter(request, prefix + "pf_spd", length));
            String[] crnKnt = (JSPUtil.getParameter(request, prefix + "crn_knt", length));
            String[] bnkUnitQty = (JSPUtil.getParameter(request, prefix + "bnk_unit_qty", length));
            String[] tmlVoyNo = (JSPUtil.getParameter(request, prefix + "tml_voy_no", length));
            String[] portRotnSeq = (JSPUtil.getParameter(request, prefix + "port_rotn_seq", length));
            String[] obOcnCgoQty = (JSPUtil.getParameter(request, prefix + "ob_ocn_cgo_qty", length));
            String[] shpCallNo = (JSPUtil.getParameter(request, prefix + "shp_call_no", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] prtChkFlg = (JSPUtil.getParameter(request, prefix + "prt_chk_flg", length));
            String[] tsPortCd = (JSPUtil.getParameter(request, prefix + "ts_port_cd", length));
            String[] pfEtdDt = (JSPUtil.getParameter(request, prefix + "pf_etd_dt", length));
            String[] coCd = (JSPUtil.getParameter(request, prefix + "co_cd", length));
            String[] ttlDlayHrs = (JSPUtil.getParameter(request, prefix + "ttl_dlay_hrs", length));
            String[] pfEtaDt = (JSPUtil.getParameter(request, prefix + "pf_eta_dt", length));
            String[] rtvFlg = (JSPUtil.getParameter(request, prefix + "rtv_flg", length));
            String[] etdDelayFlg = (JSPUtil.getParameter(request, prefix + "etd_delay_flg", length));
            String[] pfEtbDt = (JSPUtil.getParameter(request, prefix + "pf_etb_dt", length));
            String[] winRmk = (JSPUtil.getParameter(request, prefix + "win_rmk", length));
            String[] actInpFlg = (JSPUtil.getParameter(request, prefix + "act_inp_flg", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] updSts = (JSPUtil.getParameter(request, prefix + "upd_sts", length));
            String[] ibCgoQty = (JSPUtil.getParameter(request, prefix + "ib_cgo_qty", length));
            String[] seq = (JSPUtil.getParameter(request, prefix + "seq", length));
            String[] stPortCd = (JSPUtil.getParameter(request, prefix + "st_port_cd", length));
            String[] addVtPortSeq = (JSPUtil.getParameter(request, prefix + "add_vt_port_seq", length));
            String[] pfLnkDist = (JSPUtil.getParameter(request, prefix + "pf_lnk_dist", length));
            String[] pfLnkSpd = (JSPUtil.getParameter(request, prefix + "pf_lnk_spd", length));
            String[] pfSeaBufHrs = (JSPUtil.getParameter(request, prefix + "pf_sea_buf_hrs", length));
            String[] pfPortBufHrs = (JSPUtil.getParameter(request, prefix + "pf_port_buf_hrs", length));
            String[] pfTztmHrs = (JSPUtil.getParameter(request, prefix + "pf_tztm_hrs", length));
            String[] pfActWrkHrs = (JSPUtil.getParameter(request, prefix + "pf_act_wrk_hrs", length));
            String[] pfMnvrOutHrs = (JSPUtil.getParameter(request, prefix + "pf_mnvr_out_hrs", length));
            String[] pfMnvrInHrs = (JSPUtil.getParameter(request, prefix + "pf_mnvr_in_hrs", length));
            String[] ibCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", length));
            String[] obCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", length));
            String[] toLocCd = (JSPUtil.getParameter(request, prefix + "to_loc_cd".trim(), length));
            String[] fmLocCd = (JSPUtil.getParameter(request, prefix + "fm_loc_cd".trim(), length));
            String[] portDist = (JSPUtil.getParameter(request, prefix + "port_dist".trim(), length));
            String[] vtAddCallFlg = (JSPUtil.getParameter(request, prefix + "vt_add_call_flg".trim(), length));
            String[] cssmVoyInitCreFlg = (JSPUtil.getParameter(request, prefix + "cssm_voy_init_cre_flg", length));
            String[] vslRenmOldVslCd = (JSPUtil.getParameter(request, prefix + "vsl_renm_old_vsl_cd", length));
            String[] vslRenmOldVslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_renm_old_vsl_eng_nm", length));
            String[] vslRenmNewVslCd = (JSPUtil.getParameter(request, prefix + "vsl_renm_new_vsl_cd", length));
            String[] vslRenmNewVslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_renm_new_vsl_eng_nm", length));
            String[] vsldWks = (JSPUtil.getParameter(request, prefix + "vsld_wks", length));
            String[] addCallFlg = (JSPUtil.getParameter(request, prefix + "add_call_flg", length));
            String[] skpCallFlg = (JSPUtil.getParameter(request, prefix + "skp_call_flg", length));
            String[] addCallXterFlg = (JSPUtil.getParameter(request, prefix + "add_call_xter_flg", length));
            String[] privCallFlg = (JSPUtil.getParameter(request, prefix + "priv_call_flg", length));
            String[] turnIbCssmVoyNo = (JSPUtil.getParameter(request, prefix + "turn_ib_cssm_voy_no", length));
            String[] firstTurnPortClptSeq = (JSPUtil.getParameter(request, prefix + "first_turn_port_clpt_seq", length));
            String[] realClptSeq = (JSPUtil.getParameter(request, prefix + "real_clpt_seq", length));
	    	String[] virPortClptSeq = (JSPUtil.getParameter(request, prefix + "vir_port_clpt_seq", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SwapCstSkdSimVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ofcInpFlg[i] != null)
                    model.setOfcInpFlg(ofcInpFlg[i]);
                if (ts20ftTtlQty[i] != null)
                    model.setTs20ftTtlQty(ts20ftTtlQty[i]);
                if (bnkUnitAmt[i] != null)
                    model.setBnkUnitAmt(bnkUnitAmt[i]);
                if (plismVoyNo[i] != null)
                    model.setPlismVoyNo(plismVoyNo[i]);
                if (tmlCd[i] != null)
                    model.setTmlCd(tmlCd[i]);
                if (psdoVvdCd[i] != null)
                    model.setPsdoVvdCd(psdoVvdCd[i]);
                if (vpsPortCd[i] != null)
                    model.setVpsPortCd(vpsPortCd[i]);
                if (clptSeq[i] != null)
                    model.setClptSeq(clptSeq[i]);
                if (skdUsdIndCd[i] != null)
                    model.setSkdUsdIndCd(skdUsdIndCd[i]);
                if (tmlHndl40ftTtlQty[i] != null)
                    model.setTmlHndl40ftTtlQty(tmlHndl40ftTtlQty[i]);
                if (noonRptInpFlg[i] != null)
                    model.setNoonRptInpFlg(noonRptInpFlg[i]);
                if (ibIpcgoQty[i] != null)
                    model.setIbIpcgoQty(ibIpcgoQty[i]);
                if (vslDlayRsnDesc[i] != null)
                    model.setVslDlayRsnDesc(vslDlayRsnDesc[i]);
                if (obIpcgoQty[i] != null)
                    model.setObIpcgoQty(obIpcgoQty[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (newClptIndSeq[i] != null)
                    model.setNewClptIndSeq(newClptIndSeq[i]);
                if (initEtaDt[i] != null)
                    model.setInitEtaDt(initEtaDt[i]);
                if (shpCallNoUpdUsrId[i] != null)
                    model.setShpCallNoUpdUsrId(shpCallNoUpdUsrId[i]);
                if (cngLaneCd[i] != null)
                    model.setCngLaneCd(cngLaneCd[i]);
                if (lnkDist[i] != null)
                    model.setLnkDist(lnkDist[i]);
                if (obCgoQty[i] != null)
                    model.setObCgoQty(obCgoQty[i]);
                if (etdDyNo[i] != null)
                    model.setEtdDyNo(etdDyNo[i]);
                if (n1stPortBrthDt[i] != null)
                    model.setN1stPortBrthDt(n1stPortBrthDt[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (tmlVslCd[i] != null)
                    model.setTmlVslCd(tmlVslCd[i]);
                if (ediSndKnt[i] != null)
                    model.setEdiSndKnt(ediSndKnt[i]);
                if (cngVslCd[i] != null)
                    model.setCngVslCd(cngVslCd[i]);
                if (etdTmHrmnt[i] != null)
                    model.setEtdTmHrmnt(etdTmHrmnt[i]);
                if (tmlHndl20ftTtlAmt[i] != null)
                    model.setTmlHndl20ftTtlAmt(tmlHndl20ftTtlAmt[i]);
                if (etbDyNo[i] != null)
                    model.setEtbDyNo(etbDyNo[i]);
                if (usdFlg[i] != null)
                    model.setUsdFlg(usdFlg[i]);
                if (seaBufSpd[i] != null)
                    model.setSeaBufSpd(seaBufSpd[i]);
                if (vslDlayRsnLocCd[i] != null)
                    model.setVslDlayRsnLocCd(vslDlayRsnLocCd[i]);
                if (etbDyCd[i] != null)
                    model.setEtbDyCd(etbDyCd[i]);
                if (pfSkdTpCd[i] != null)
                    model.setPfSkdTpCd(pfSkdTpCd[i]);
                if (phsIoRsnCd[i] != null)
                    model.setPhsIoRsnCd(phsIoRsnCd[i]);
                if (tmlProdQty[i] != null)
                    model.setTmlProdQty(tmlProdQty[i]);
                if (turnSkdDirCd[i] != null)
                    model.setTurnSkdDirCd(turnSkdDirCd[i]);
                if (portSkpTpCd[i] != null)
                    model.setPortSkpTpCd(portSkpTpCd[i]);
                if (etaDelayFlg[i] != null)
                    model.setEtaDelayFlg(etaDelayFlg[i]);
                if (skdVoyTpCd[i] != null)
                    model.setSkdVoyTpCd(skdVoyTpCd[i]);
                if (skdRmk[i] != null)
                    model.setSkdRmk(skdRmk[i]);
                if (vslDlayRsnCd[i] != null)
                    model.setVslDlayRsnCd(vslDlayRsnCd[i]);
                if (callYdIndSeq[i] != null)
                    model.setCallYdIndSeq(callYdIndSeq[i]);
                if (ts20ftTtlAmt[i] != null)
                    model.setTs20ftTtlAmt(ts20ftTtlAmt[i]);
                if (plismVslCd[i] != null)
                    model.setPlismVslCd(plismVslCd[i]);
                if (dlayDateText[i] != null)
                    model.setDlayDateText(dlayDateText[i]);
                if (timeDiff[i] != null)
                    model.setTimeDiff(timeDiff[i]);
                if (ftDt[i] != null)
                    model.setFtDt(ftDt[i]);
                if (portSkpRsnOffrRmk[i] != null)
                    model.setPortSkpRsnOffrRmk(portSkpRsnOffrRmk[i]);
                if (phsIoRmk[i] != null)
                    model.setPhsIoRmk(phsIoRmk[i]);
                if (seaDateText[i] != null)
                    model.setSeaDateText(seaDateText[i]);
                if (mnvrInHrs[i] != null)
                    model.setMnvrInHrs(mnvrInHrs[i]);
                if (diffRmk[i] != null)
                    model.setDiffRmk(diffRmk[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (ydCd[i] != null)
                    model.setYdCd(ydCd[i]);
                if (etbTmHrmnt[i] != null)
                    model.setEtbTmHrmnt(etbTmHrmnt[i]);
                if (clptIndSeq[i] != null)
                    model.setClptIndSeq(clptIndSeq[i]);
                if (depRptInpFlg[i] != null)
                    model.setDepRptInpFlg(depRptInpFlg[i]);
                if (ts40ftTtlQty[i] != null)
                    model.setTs40ftTtlQty(ts40ftTtlQty[i]);
                if (bound[i] != null)
                    model.setBound(bound[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (lnkSpd[i] != null)
                    model.setLnkSpd(lnkSpd[i]);
                if (seaBufHrs[i] != null)
                    model.setSeaBufHrs(seaBufHrs[i]);
                if (actWrkHrs[i] != null)
                    model.setActWrkHrs(actWrkHrs[i]);
                if (addBnkCsmQty[i] != null)
                    model.setAddBnkCsmQty(addBnkCsmQty[i]);
                if (simNo[i] != null)
                    model.setSimNo(simNo[i]);
                if (turnSkdVoyNo[i] != null)
                    model.setTurnSkdVoyNo(turnSkdVoyNo[i]);
                if (portBufHrs[i] != null)
                    model.setPortBufHrs(portBufHrs[i]);
                if (cngSkdVoyNo[i] != null)
                    model.setCngSkdVoyNo(cngSkdVoyNo[i]);
                if (initSkdInpFlg[i] != null)
                    model.setInitSkdInpFlg(initSkdInpFlg[i]);
                if (tztmHrs[i] != null)
                    model.setTztmHrs(tztmHrs[i]);
                if (etdDyCd[i] != null)
                    model.setEtdDyCd(etdDyCd[i]);
                if (ts40ftTtlAmt[i] != null)
                    model.setTs40ftTtlAmt(ts40ftTtlAmt[i]);
                if (turnPortIndCd[i] != null)
                    model.setTurnPortIndCd(turnPortIndCd[i]);
                if (peUsdTtlAmt[i] != null)
                    model.setPeUsdTtlAmt(peUsdTtlAmt[i]);
                if (skdBrthNo[i] != null)
                    model.setSkdBrthNo(skdBrthNo[i]);
                if (tmlHndl40ftTtlAmt[i] != null)
                    model.setTmlHndl40ftTtlAmt(tmlHndl40ftTtlAmt[i]);
                if (portSkdStsCd[i] != null)
                    model.setPortSkdStsCd(portSkdStsCd[i]);
                if (etbDelayFlg[i] != null)
                    model.setEtbDelayFlg(etbDelayFlg[i]);
                if (vslSimTpCd[i] != null)
                    model.setVslSimTpCd(vslSimTpCd[i]);
                if (vpsEtdDt[i] != null)
                    model.setVpsEtdDt(vpsEtdDt[i]);
                if (initEtbDt[i] != null)
                    model.setInitEtbDt(initEtbDt[i]);
                if (portSkpRsnCd[i] != null)
                    model.setPortSkpRsnCd(portSkpRsnCd[i]);
                if (ibOcnCgoQty[i] != null)
                    model.setIbOcnCgoQty(ibOcnCgoQty[i]);
                if (plismYdCd[i] != null)
                    model.setPlismYdCd(plismYdCd[i]);
                if (initEtdDt[i] != null)
                    model.setInitEtdDt(initEtdDt[i]);
                if (autoSkdCngFlg[i] != null)
                    model.setAutoSkdCngFlg(autoSkdCngFlg[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (skdCngStsCd[i] != null)
                    model.setSkdCngStsCd(skdCngStsCd[i]);
                if (bfrActFlg[i] != null)
                    model.setBfrActFlg(bfrActFlg[i]);
                if (shpCallNoUpdDt[i] != null)
                    model.setShpCallNoUpdDt(shpCallNoUpdDt[i]);
                if (cngSkdDirCd[i] != null)
                    model.setCngSkdDirCd(cngSkdDirCd[i]);
                if (usrHdnFlg[i] != null)
                    model.setUsrHdnFlg(usrHdnFlg[i]);
                if (delayDate[i] != null)
                    model.setDelayDate(delayDate[i]);
                if (turnClptIndSeq[i] != null)
                    model.setTurnClptIndSeq(turnClptIndSeq[i]);
                if (mnvrOutHrs[i] != null)
                    model.setMnvrOutHrs(mnvrOutHrs[i]);
                if (vpsEtbDt[i] != null)
                    model.setVpsEtbDt(vpsEtbDt[i]);
                if (vpsRmk[i] != null)
                    model.setVpsRmk(vpsRmk[i]);
                if (turnPortFlg[i] != null)
                    model.setTurnPortFlg(turnPortFlg[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (simDt[i] != null)
                    model.setSimDt(simDt[i]);
                if (vslSlanCd[i] != null)
                    model.setVslSlanCd(vslSlanCd[i]);
                if (tmlHndl20ftTtlQty[i] != null)
                    model.setTmlHndl20ftTtlQty(tmlHndl20ftTtlQty[i]);
                if (vpsEtaDt[i] != null)
                    model.setVpsEtaDt(vpsEtaDt[i]);
                if (skdStsCd[i] != null)
                    model.setSkdStsCd(skdStsCd[i]);
                if (addBnkCostAmt[i] != null)
                    model.setAddBnkCostAmt(addBnkCostAmt[i]);
                if (pfSvcTpCd[i] != null)
                    model.setPfSvcTpCd(pfSvcTpCd[i]);
                if (pfSpd[i] != null)
                    model.setPfSpd(pfSpd[i]);
                if (crnKnt[i] != null)
                    model.setCrnKnt(crnKnt[i]);
                if (bnkUnitQty[i] != null)
                    model.setBnkUnitQty(bnkUnitQty[i]);
                if (tmlVoyNo[i] != null)
                    model.setTmlVoyNo(tmlVoyNo[i]);
                if (portRotnSeq[i] != null)
                    model.setPortRotnSeq(portRotnSeq[i]);
                if (obOcnCgoQty[i] != null)
                    model.setObOcnCgoQty(obOcnCgoQty[i]);
                if (shpCallNo[i] != null)
                    model.setShpCallNo(shpCallNo[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (prtChkFlg[i] != null)
                    model.setPrtChkFlg(prtChkFlg[i]);
                if (tsPortCd[i] != null)
                    model.setTsPortCd(tsPortCd[i]);
                if (pfEtdDt[i] != null)
                    model.setPfEtdDt(pfEtdDt[i]);
                if (coCd[i] != null)
                    model.setCoCd(coCd[i]);
                if (ttlDlayHrs[i] != null)
                    model.setTtlDlayHrs(ttlDlayHrs[i]);
                if (pfEtaDt[i] != null)
                    model.setPfEtaDt(pfEtaDt[i]);
                if (rtvFlg[i] != null)
                    model.setRtvFlg(rtvFlg[i]);
                if (etdDelayFlg[i] != null)
                    model.setEtdDelayFlg(etdDelayFlg[i]);
                if (pfEtbDt[i] != null)
                    model.setPfEtbDt(pfEtbDt[i]);
                if (winRmk[i] != null)
                    model.setWinRmk(winRmk[i]);
                if (actInpFlg[i] != null)
                    model.setActInpFlg(actInpFlg[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (updSts[i] != null)
                    model.setUpdSts(updSts[i]);
                if (ibCgoQty[i] != null)
                    model.setIbCgoQty(ibCgoQty[i]);
                if (seq[i] != null)
                    model.setSeq(seq[i]);
                if (stPortCd[i] != null)
                    model.setStPortCd(stPortCd[i]);
                if (addVtPortSeq[i] != null)
                    model.setAddVtPortSeq(addVtPortSeq[i]);
                if (pfLnkDist[i] != null)
                    model.setPfLnkDist(pfLnkDist[i]);
                if (pfLnkSpd[i] != null)
                    model.setPfLnkSpd(pfLnkSpd[i]);
                if (pfSeaBufHrs[i] != null)
                    model.setPfSeaBufHrs(pfSeaBufHrs[i]);
                if (pfPortBufHrs[i] != null)
                    model.setPfPortBufHrs(pfPortBufHrs[i]);
                if (pfTztmHrs[i] != null)
                    model.setPfTztmHrs(pfTztmHrs[i]);
                if (pfActWrkHrs[i] != null)
                    model.setPfActWrkHrs(pfActWrkHrs[i]);
                if (pfMnvrOutHrs[i] != null)
                    model.setPfMnvrOutHrs(pfMnvrOutHrs[i]);
                if (pfMnvrInHrs[i] != null)
                    model.setPfMnvrInHrs(pfMnvrInHrs[i]);
                if (ibCssmVoyNo[i] != null)
                    model.setIbCssmVoyNo(ibCssmVoyNo[i]);
                if (obCssmVoyNo[i] != null)
                    model.setObCssmVoyNo(obCssmVoyNo[i]);
                if (toLocCd[i] != null)
                    model.setToLocCd(toLocCd[i]);
                if (fmLocCd[i] != null)
                    model.setFmLocCd(fmLocCd[i]);
                if (portDist[i] != null)
                    model.setPortDist(portDist[i]);
                if (vtAddCallFlg[i] != null)
                    model.setVtAddCallFlg(vtAddCallFlg[i]);
                if (cssmVoyInitCreFlg[i] != null)
                    model.setCssmVoyInitCreFlg(cssmVoyInitCreFlg[i]);
                if (vslRenmOldVslCd[i] != null)
                    model.setVslRenmOldVslCd(vslRenmOldVslCd[i]);
                if (vslRenmOldVslEngNm[i] != null)
                    model.setVslRenmOldVslEngNm(vslRenmOldVslEngNm[i]);
                if (vslRenmNewVslCd[i] != null)
                    model.setVslRenmNewVslCd(vslRenmNewVslCd[i]);
                if (vslRenmNewVslEngNm[i] != null)
                    model.setVslRenmNewVslEngNm(vslRenmNewVslEngNm[i]);
                if (vsldWks[i] != null)
                    model.setVsldWks(vsldWks[i]);
                if (addCallFlg[i] != null)
                    model.setAddCallFlg(addCallFlg[i]);
                if (skpCallFlg[i] != null)
                    model.setSkpCallFlg(skpCallFlg[i]);
                if (addCallXterFlg[i] != null)
                    model.setAddCallXterFlg(addCallXterFlg[i]);
                if (privCallFlg[i] != null)
                    model.setPrivCallFlg(privCallFlg[i]);
                if (ibCssmVoyNo[i] != null)
                    model.setIbCssmVoyNo(ibCssmVoyNo[i]);
                if (obCssmVoyNo[i] != null)
                    model.setObCssmVoyNo(obCssmVoyNo[i]);
                if (turnIbCssmVoyNo[i] != null)
                    model.setTurnIbCssmVoyNo(turnIbCssmVoyNo[i]);
                if (firstTurnPortClptSeq[i] != null)
                    model.setFirstTurnPortClptSeq(firstTurnPortClptSeq[i]);
                if (realClptSeq[i] != null) 
		    		model.setRealClptSeq(realClptSeq[i]);
				if (virPortClptSeq[i] != null) 
		    		model.setVirPortClptSeq(virPortClptSeq[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSwapCstSkdSimVOs();
    }

    /**
	 *  VO 배열을 반환
	 * @return SwapCstSkdSimVO[]
	 */
    public SwapCstSkdSimVO[] getSwapCstSkdSimVOs() {
        SwapCstSkdSimVO[] vos = (SwapCstSkdSimVO[]) models.toArray(new SwapCstSkdSimVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
    public void unDataFormat() {
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcInpFlg = this.ofcInpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ts20ftTtlQty = this.ts20ftTtlQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bnkUnitAmt = this.bnkUnitAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.plismVoyNo = this.plismVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmlCd = this.tmlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.psdoVvdCd = this.psdoVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsPortCd = this.vpsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptSeq = this.clptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdUsdIndCd = this.skdUsdIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmlHndl40ftTtlQty = this.tmlHndl40ftTtlQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.noonRptInpFlg = this.noonRptInpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibIpcgoQty = this.ibIpcgoQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslDlayRsnDesc = this.vslDlayRsnDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obIpcgoQty = this.obIpcgoQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.newClptIndSeq = this.newClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.initEtaDt = this.initEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shpCallNoUpdUsrId = this.shpCallNoUpdUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cngLaneCd = this.cngLaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lnkDist = this.lnkDist.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obCgoQty = this.obCgoQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etdDyNo = this.etdDyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n1stPortBrthDt = this.n1stPortBrthDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmlVslCd = this.tmlVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediSndKnt = this.ediSndKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cngVslCd = this.cngVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etdTmHrmnt = this.etdTmHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmlHndl20ftTtlAmt = this.tmlHndl20ftTtlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etbDyNo = this.etbDyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usdFlg = this.usdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.seaBufSpd = this.seaBufSpd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslDlayRsnLocCd = this.vslDlayRsnLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etbDyCd = this.etbDyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfSkdTpCd = this.pfSkdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.phsIoRsnCd = this.phsIoRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmlProdQty = this.tmlProdQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnSkdDirCd = this.turnSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portSkpTpCd = this.portSkpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etaDelayFlg = this.etaDelayFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyTpCd = this.skdVoyTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdRmk = this.skdRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslDlayRsnCd = this.vslDlayRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.callYdIndSeq = this.callYdIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ts20ftTtlAmt = this.ts20ftTtlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.plismVslCd = this.plismVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dlayDateText = this.dlayDateText.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.timeDiff = this.timeDiff.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftDt = this.ftDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portSkpRsnOffrRmk = this.portSkpRsnOffrRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.phsIoRmk = this.phsIoRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.seaDateText = this.seaDateText.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnvrInHrs = this.mnvrInHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diffRmk = this.diffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCd = this.ydCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etbTmHrmnt = this.etbTmHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptIndSeq = this.clptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.depRptInpFlg = this.depRptInpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ts40ftTtlQty = this.ts40ftTtlQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bound = this.bound.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lnkSpd = this.lnkSpd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.seaBufHrs = this.seaBufHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actWrkHrs = this.actWrkHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.addBnkCsmQty = this.addBnkCsmQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.simNo = this.simNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnSkdVoyNo = this.turnSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portBufHrs = this.portBufHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cngSkdVoyNo = this.cngSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.initSkdInpFlg = this.initSkdInpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tztmHrs = this.tztmHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etdDyCd = this.etdDyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ts40ftTtlAmt = this.ts40ftTtlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnPortIndCd = this.turnPortIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.peUsdTtlAmt = this.peUsdTtlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdBrthNo = this.skdBrthNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmlHndl40ftTtlAmt = this.tmlHndl40ftTtlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portSkdStsCd = this.portSkdStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etbDelayFlg = this.etbDelayFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSimTpCd = this.vslSimTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtdDt = this.vpsEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.initEtbDt = this.initEtbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portSkpRsnCd = this.portSkpRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibOcnCgoQty = this.ibOcnCgoQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.plismYdCd = this.plismYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.initEtdDt = this.initEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.autoSkdCngFlg = this.autoSkdCngFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdCngStsCd = this.skdCngStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrActFlg = this.bfrActFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shpCallNoUpdDt = this.shpCallNoUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cngSkdDirCd = this.cngSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrHdnFlg = this.usrHdnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delayDate = this.delayDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnClptIndSeq = this.turnClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnvrOutHrs = this.mnvrOutHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtbDt = this.vpsEtbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsRmk = this.vpsRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnPortFlg = this.turnPortFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.simDt = this.simDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSlanCd = this.vslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmlHndl20ftTtlQty = this.tmlHndl20ftTtlQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtaDt = this.vpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdStsCd = this.skdStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.addBnkCostAmt = this.addBnkCostAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfSvcTpCd = this.pfSvcTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfSpd = this.pfSpd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crnKnt = this.crnKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bnkUnitQty = this.bnkUnitQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmlVoyNo = this.tmlVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portRotnSeq = this.portRotnSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obOcnCgoQty = this.obOcnCgoQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shpCallNo = this.shpCallNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prtChkFlg = this.prtChkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsPortCd = this.tsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfEtdDt = this.pfEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.coCd = this.coCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlDlayHrs = this.ttlDlayHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfEtaDt = this.pfEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtvFlg = this.rtvFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etdDelayFlg = this.etdDelayFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfEtbDt = this.pfEtbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.winRmk = this.winRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actInpFlg = this.actInpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updSts = this.updSts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibCgoQty = this.ibCgoQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.seq = this.seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stPortCd = this.stPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.addVtPortSeq = this.addVtPortSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfLnkDist = this.pfLnkDist.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfLnkSpd = this.pfLnkSpd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfSeaBufHrs = this.pfSeaBufHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfPortBufHrs = this.pfPortBufHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfTztmHrs = this.pfTztmHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfActWrkHrs = this.pfActWrkHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfMnvrOutHrs = this.pfMnvrOutHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfMnvrInHrs = this.pfMnvrInHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibCssmVoyNo = this.ibCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obCssmVoyNo = this.obCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cssmVoyInitCreFlg = this.cssmVoyInitCreFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslRenmOldVslCd = this.vslRenmOldVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslRenmOldVslEngNm = this.vslRenmOldVslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslRenmNewVslCd = this.vslRenmNewVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslRenmNewVslEngNm = this.vslRenmNewVslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vsldWks = this.vsldWks.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.addCallFlg = this.addCallFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skpCallFlg = this.skpCallFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.addCallXterFlg = this.addCallXterFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.privCallFlg = this.privCallFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibCssmVoyNo = this.ibCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obCssmVoyNo = this.obCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnIbCssmVoyNo = this.turnIbCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.firstTurnPortClptSeq = this.firstTurnPortClptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.realClptSeq = this.realClptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.virPortClptSeq = this.virPortClptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
