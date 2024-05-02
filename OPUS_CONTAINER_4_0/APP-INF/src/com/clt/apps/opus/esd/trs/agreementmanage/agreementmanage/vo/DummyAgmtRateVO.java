/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DummyAgmtRateVO.java
*@FileTitle : DummyAgmtRateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.10
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.06.10 최종혁 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo;

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
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DummyAgmtRateVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;
    
    private Collection<DummyAgmtRateVO> models = new ArrayList<DummyAgmtRateVO>();
    
    /* Column Info */
    private String toNodYd = null;
    private String cgoTpCd = null;
    private String trspRndRt = null;
    private String pagerows = null;
    private String eqAal = null;
    private String ckVf = null;
    private String eqF2 = null;
    private String eqAl2 = null;
    private String eqF4 = null;
    private String eqF5 = null;
    private String eqAl5 = null;
    private String eqAl4 = null;
    private String eqDw = null;
    private String trspScgCd = null;
    private String eqAl7 = null;
    private String eqO4 = null;
    private String eqAl8 = null;
    private String eqAl9 = null;
    private String eqT2 = null;
    private String eqDx = null;
    private String eqT4 = null;
    private String trspOneWyRt = null;
    private String cmdtGrpCd = null;
    private String eqTal = null;
    private String eqPal = null;
    private String eqGn4 = null;
    private String eqGn5 = null;
    private String custCd = null;
    private String eqRal = null;
    private String eqSal = null;
    private String eqO2 = null;
    private String railSvcTpCd = null;
    private String orgTrspAgmtEqSzCd = null;
    private String deltFlg = null;
    private String toWgt = null;
    private String eqAlal = null;
    private String dorNodCd = null;
    private String eqD4 = null;
    private String eqD5 = null;
    private String eqSf4 = null;
    private String effFmDt = null;
    private String wtrDeTermCd = null;
    private String eqD7 = null;
    private String eqD2 = null;
    private String agmtScgRtDivCd = null;
    private String eqSf2 = null;
    private String eqD3 = null;
    private String trspAgmtEqTpCd = null;
    private String eqTa2 = null;
    private String eqD9 = null;
    private String eqD8 = null;
    private String chkRowno = null;
    private String eqKndCd = null;
    private String fmNodCd = null;
    private String eqUg = null;
    private String eqCg = null;
    private String viaNodCd = null;
    private String agmtTrspTpCd = null;
    private String trspAgmtBdlQty = null;
    private String viaNodYd = null;
    private String toNodCd = null;
    private String rlt = null;
    private String orgTrspAgmtEqTpCd = null;
    private String rowno = null;
    private String eqR7 = null;
    private String eqSfal = null;
    private String trspAgmtRtTpCd = null;
    private String trspAgmtEqSzCd = null;
    private String eqCb4 = null;
    private String eqR4 = null;
    private String eqR5 = null;
    private String eqR2 = null;
    private String orgEqtype = null;
    private String eqGnal = null;
    private String trspAgmtDist = null;
    private String eqOal = null;
    private String distMeasUtCd = null;
    private String eqZt4 = null;
    private String eqS2 = null;
    private String chk = null;
    private String eqS4 = null;
    private String eqSlal = null;
    private String trspAgmtSeq = null;
    private String wgtMeasUtCd = null;
    private String effToDt = null;
    private String eqEg5 = null;
    private String currCd = null;
    private String eqA2 = null;
    private String agmtRoutAllFlg = null;
    private String eqA4 = null;
    private String trspAgmtOfcCtyCd = null;
    private String eqEg8 = null;
    private String eqTaal = null;
    private String eqP4 = null;
    private String eqP2 = null;
    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;
    private String wtrRcvTermCd = null;
    private String trspRvsAplyFlg = null;
    private String eqFal = null;
    private String trspCostModCd = null;
    private String fmNodYd = null;
    private String eqEgal = null;
    private String eqSl2 = null;
    private String uiSeqno = null;
    private String dorNodYd = null;
    private String eqDal = null;
    private String trspDistTpCd = null;
    private String comScgAplyFlg = null;
    private String woAplyFlg = null;
    private String trspAgmtRtTpSerNo = null;
    private String trspAgmtNodSeq = null;
    private String trspAgmtRtSeq = null;
    private String trspAgmtScgNodSeq = null;
    private String trspAgmtScgRtSeq = null;
    private String trspBndCd = null;
    private String spclCgoCntrTpCd = null;
    private String usrDefRmk = null;
    private String aftUsrDefRmk = null;
    private String orgRtSeq = null;

    private String eqAalRtSeq = null;
    private String eqF2RtSeq = null;
    private String eqAl2RtSeq = null;
    private String eqF4RtSeq = null;
    private String eqF5RtSeq = null;
    private String eqAl5RtSeq = null;
    private String eqAl4RtSeq = null;
    private String eqDwRtSeq = null;
    private String eqAl7RtSeq = null;
    private String eqO4RtSeq = null;
    private String eqAl8RtSeq = null;
    private String eqAl9RtSeq = null;
    private String eqT2RtSeq = null;
    private String eqDxRtSeq = null;
    private String eqT4RtSeq = null;
    private String eqTalRtSeq = null;
    private String eqPalRtSeq = null;
    private String eqGn4RtSeq = null;
    private String eqGn5RtSeq = null;
    private String eqRalRtSeq = null;
    private String eqSalRtSeq = null;
    private String eqO2RtSeq = null;
    private String eqAlalRtSeq = null;
    private String eqD4RtSeq = null;
    private String eqD5RtSeq = null;
    private String eqSf4RtSeq = null;
    private String eqD7RtSeq = null;
    private String eqD2RtSeq = null;
    private String eqSf2RtSeq = null;
    private String eqD3RtSeq = null;
    private String eqTa2RtSeq = null;
    private String eqD9RtSeq = null;
    private String eqD8RtSeq = null;
    private String eqUgRtSeq = null;
    private String eqCgRtSeq = null;
    private String eqR7RtSeq = null;
    private String eqSfalRtSeq = null;
    private String eqCb4RtSeq = null;
    private String eqR4RtSeq = null;
    private String eqR5RtSeq = null;
    private String eqR2RtSeq = null;
    private String eqGnalRtSeq = null;
    private String eqOalRtSeq = null;
    private String eqZt4RtSeq = null;
    private String eqS2RtSeq = null;
    private String eqS4RtSeq = null;
    private String eqSlalRtSeq = null;
    private String eqEg5RtSeq = null;
    private String eqA2RtSeq = null;
    private String eqA4RtSeq = null;
    private String eqEg8RtSeq = null;
    private String eqTaalRtSeq = null;
    private String eqP4RtSeq = null;
    private String eqP2RtSeq = null;
    private String eqFalRtSeq = null;
    private String eqEgalRtSeq = null;
    private String eqSl2RtSeq = null;
    private String eqDalRtSeq = null;
    
    /* common apply */
    private String eqXxxx = null;
    private String eqXxxxRtSeq = null;
    
    /* COA case */
    private String agmtCostFlg = null;

    /*    테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();
    /*    테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public DummyAgmtRateVO() {}

    public DummyAgmtRateVO(String ibflag
                         , String pagerows
                         , String chk
                         , String rlt
                         , String trspCostModCd
                         , String agmtTrspTpCd
                         , String cgoTpCd
                         , String custCd
                         , String cmdtGrpCd
                         , String railSvcTpCd
                         , String fmNodCd
                         , String fmNodYd
                         , String viaNodCd
                         , String viaNodYd
                         , String dorNodCd
                         , String dorNodYd
                         , String toNodCd
                         , String toNodYd
                         , String trspDistTpCd
                         , String trspAgmtDist
                         , String distMeasUtCd
                         , String currCd
                         , String eqD2
                         , String eqD3
                         , String eqD4
                         , String eqD5
                         , String eqD7
                         , String eqD8
                         , String eqD9
                         , String eqDw
                         , String eqDx
                         , String eqR2
                         , String eqR4
                         , String eqR5
                         , String eqR7
                         , String eqA2
                         , String eqA4
                         , String eqF2
                         , String eqF4
                         , String eqF5
                         , String eqT2
                         , String eqT4
                         , String eqS2
                         , String eqS4
                         , String eqO2
                         , String eqO4
                         , String eqP2
                         , String eqP4
                         , String eqSf2
                         , String eqSf4
                         , String eqSl2
                         , String eqTa2
                         , String eqGn4
                         , String eqGn5
                         , String eqEg5
                         , String eqEg8
                         , String eqZt4
                         , String eqCb4
                         , String eqCg
                         , String eqUg
                         , String eqAlal
                         , String eqDal
                         , String eqRal
                         , String eqAal
                         , String eqFal
                         , String eqTal
                         , String eqSal
                         , String eqOal
                         , String eqPal
                         , String eqAl2
                         , String eqAl4
                         , String eqAl5
                         , String eqAl7
                         , String eqAl8
                         , String eqAl9
                         , String eqSfal
                         , String eqSlal
                         , String eqTaal
                         , String eqGnal
                         , String eqEgal
                         , String trspOneWyRt
                         , String trspRndRt
                         , String wtrRcvTermCd
                         , String wtrDeTermCd
                         , String trspAgmtBdlQty
                         , String toWgt
                         , String wgtMeasUtCd
                         , String trspRvsAplyFlg
                         , String trspAgmtOfcCtyCd
                         , String trspAgmtSeq
                         , String trspAgmtRtTpCd
                         , String effFmDt
                         , String effToDt
                         , String ckVf
                         , String eqKndCd
                         , String trspAgmtEqTpCd
                         , String trspAgmtEqSzCd
                         , String rowno
                         , String chkRowno
                         , String trspScgCd
                         , String agmtRoutAllFlg
                         , String deltFlg
                         , String orgEqtype
                         , String orgTrspAgmtEqTpCd
                         , String orgTrspAgmtEqSzCd
                         , String uiSeqno
                         , String agmtScgRtDivCd
                         , String comScgAplyFlg
                         , String woAplyFlg
                         , String trspAgmtRtTpSerNo
                         , String trspAgmtNodSeq
                         , String trspAgmtRtSeq
                         , String trspAgmtScgNodSeq
                         , String trspAgmtScgRtSeq
                         , String trspBndCd
                         , String spclCgoCntrTpCd
                         , String usrDefRmk
                         , String aftUsrDefRmk
                         , String orgRtSeq
                         , String eqAalRtSeq, String eqF2RtSeq, String eqAl2RtSeq, String eqF4RtSeq, String eqF5RtSeq, String eqAl5RtSeq, String eqAl4RtSeq, String eqDwRtSeq, String eqAl7RtSeq, String eqO4RtSeq, String eqAl8RtSeq, String eqAl9RtSeq, String eqT2RtSeq, String eqDxRtSeq, String eqT4RtSeq, String eqTalRtSeq, String eqPalRtSeq, String eqGn4RtSeq, String eqGn5RtSeq, String eqRalRtSeq, String eqSalRtSeq, String eqO2RtSeq, String eqAlalRtSeq, String eqD4RtSeq, String eqD5RtSeq, String eqSf4RtSeq, String eqD7RtSeq, String eqD2RtSeq, String eqSf2RtSeq, String eqD3RtSeq, String eqTa2RtSeq, String eqD9RtSeq, String eqD8RtSeq, String eqUgRtSeq, String eqCgRtSeq, String eqR7RtSeq, String eqSfalRtSeq, String eqCb4RtSeq, String eqR4RtSeq, String eqR5RtSeq, String eqR2RtSeq, String eqGnalRtSeq, String eqOalRtSeq, String eqZt4RtSeq, String eqS2RtSeq, String eqS4RtSeq, String eqSlalRtSeq, String eqEg5RtSeq, String eqA2RtSeq, String eqA4RtSeq, String eqEg8RtSeq, String eqTaalRtSeq, String eqP4RtSeq, String eqP2RtSeq, String eqFalRtSeq, String eqEgalRtSeq, String eqSl2RtSeq, String eqDalRtSeq
                         , String eqXxxx, String eqXxxxRtSeq
                         , String agmtCostFlg
                         ) {
        this.toNodYd = toNodYd;
        this.cgoTpCd = cgoTpCd;
        this.trspRndRt = trspRndRt;
        this.pagerows = pagerows;
        this.eqAal = eqAal;
        this.ckVf = ckVf;
        this.eqF2 = eqF2;
        this.eqAl2 = eqAl2;
        this.eqF4 = eqF4;
        this.eqF5 = eqF5;
        this.eqAl5 = eqAl5;
        this.eqAl4 = eqAl4;
        this.eqDw = eqDw;
        this.trspScgCd = trspScgCd;
        this.eqAl7 = eqAl7;
        this.eqO4 = eqO4;
        this.eqAl8 = eqAl8;
        this.eqAl9 = eqAl9;
        this.eqT2 = eqT2;
        this.eqDx = eqDx;
        this.eqT4 = eqT4;
        this.trspOneWyRt = trspOneWyRt;
        this.cmdtGrpCd = cmdtGrpCd;
        this.eqTal = eqTal;
        this.eqPal = eqPal;
        this.eqGn4 = eqGn4;
        this.eqGn5 = eqGn5;
        this.custCd = custCd;
        this.eqRal = eqRal;
        this.eqSal = eqSal;
        this.eqO2 = eqO2;
        this.railSvcTpCd = railSvcTpCd;
        this.orgTrspAgmtEqSzCd = orgTrspAgmtEqSzCd;
        this.deltFlg = deltFlg;
        this.toWgt = toWgt;
        this.eqAlal = eqAlal;
        this.dorNodCd = dorNodCd;
        this.eqD4 = eqD4;
        this.eqD5 = eqD5;
        this.eqSf4 = eqSf4;
        this.effFmDt = effFmDt;
        this.wtrDeTermCd = wtrDeTermCd;
        this.eqD7 = eqD7;
        this.eqD2 = eqD2;
        this.agmtScgRtDivCd = agmtScgRtDivCd;
        this.eqSf2 = eqSf2;
        this.eqD3 = eqD3;
        this.trspAgmtEqTpCd = trspAgmtEqTpCd;
        this.eqTa2 = eqTa2;
        this.eqD9 = eqD9;
        this.eqD8 = eqD8;
        this.chkRowno = chkRowno;
        this.eqKndCd = eqKndCd;
        this.fmNodCd = fmNodCd;
        this.eqUg = eqUg;
        this.eqCg = eqCg;
        this.viaNodCd = viaNodCd;
        this.agmtTrspTpCd = agmtTrspTpCd;
        this.trspAgmtBdlQty = trspAgmtBdlQty;
        this.viaNodYd = viaNodYd;
        this.toNodCd = toNodCd;
        this.rlt = rlt;
        this.orgTrspAgmtEqTpCd = orgTrspAgmtEqTpCd;
        this.rowno = rowno;
        this.eqR7 = eqR7;
        this.eqSfal = eqSfal;
        this.trspAgmtRtTpCd = trspAgmtRtTpCd;
        this.trspAgmtEqSzCd = trspAgmtEqSzCd;
        this.eqCb4 = eqCb4;
        this.eqR4 = eqR4;
        this.eqR5 = eqR5;
        this.eqR2 = eqR2;
        this.orgEqtype = orgEqtype;
        this.eqGnal = eqGnal;
        this.trspAgmtDist = trspAgmtDist;
        this.eqOal = eqOal;
        this.distMeasUtCd = distMeasUtCd;
        this.eqZt4 = eqZt4;
        this.eqS2 = eqS2;
        this.chk = chk;
        this.eqS4 = eqS4;
        this.eqSlal = eqSlal;
        this.trspAgmtSeq = trspAgmtSeq;
        this.wgtMeasUtCd = wgtMeasUtCd;
        this.effToDt = effToDt;
        this.eqEg5 = eqEg5;
        this.currCd = currCd;
        this.eqA2 = eqA2;
        this.agmtRoutAllFlg = agmtRoutAllFlg;
        this.eqA4 = eqA4;
        this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
        this.eqEg8 = eqEg8;
        this.eqTaal = eqTaal;
        this.eqP4 = eqP4;
        this.eqP2 = eqP2;
        this.ibflag = ibflag;
        this.wtrRcvTermCd = wtrRcvTermCd;
        this.trspRvsAplyFlg = trspRvsAplyFlg;
        this.eqFal = eqFal;
        this.trspCostModCd = trspCostModCd;
        this.fmNodYd = fmNodYd;
        this.eqEgal = eqEgal;
        this.eqSl2 = eqSl2;
        this.uiSeqno = uiSeqno;
        this.dorNodYd = dorNodYd;
        this.eqDal = eqDal;
        this.trspDistTpCd = trspDistTpCd;
        this.comScgAplyFlg = comScgAplyFlg;
        this.woAplyFlg = woAplyFlg;
        this.trspAgmtRtTpSerNo = trspAgmtRtTpSerNo;
        this.trspAgmtNodSeq = trspAgmtNodSeq;
        this.trspAgmtRtSeq = trspAgmtRtSeq;
        this.trspAgmtScgNodSeq = trspAgmtScgNodSeq;
        this.trspAgmtScgRtSeq = trspAgmtScgRtSeq;
        this.trspBndCd = trspBndCd;
        this.spclCgoCntrTpCd = spclCgoCntrTpCd;
        this.usrDefRmk = usrDefRmk;
        this.aftUsrDefRmk = aftUsrDefRmk;
        this.orgRtSeq = orgRtSeq;
        
        this.eqD4RtSeq = eqD4RtSeq;
		this.eqAalRtSeq = eqAalRtSeq;
		this.eqDalRtSeq = eqDalRtSeq;
		this.eqS2RtSeq = eqS2RtSeq;
		this.eqD5RtSeq = eqD5RtSeq;
		this.eqD9RtSeq = eqD9RtSeq;
		this.eqR4RtSeq = eqR4RtSeq;
		this.eqSlalRtSeq = eqSlalRtSeq;
		this.eqAl5RtSeq = eqAl5RtSeq;
		this.eqEg8RtSeq = eqEg8RtSeq;
		this.eqSfalRtSeq = eqSfalRtSeq;
		this.eqGnalRtSeq = eqGnalRtSeq;
		this.eqF2RtSeq = eqF2RtSeq;
		this.eqF5RtSeq = eqF5RtSeq;
		this.eqOalRtSeq = eqOalRtSeq;
		this.eqT2RtSeq = eqT2RtSeq;
		this.eqD8RtSeq = eqD8RtSeq;
		this.eqSf4RtSeq = eqSf4RtSeq;
		this.eqO4RtSeq = eqO4RtSeq;
		this.eqUgRtSeq = eqUgRtSeq;
		this.eqP2RtSeq = eqP2RtSeq;
		this.eqD3RtSeq = eqD3RtSeq;
		this.eqS4RtSeq = eqS4RtSeq;
		this.eqDxRtSeq = eqDxRtSeq;
		this.eqSalRtSeq = eqSalRtSeq;
		this.eqAlalRtSeq = eqAlalRtSeq;
		this.eqP4RtSeq = eqP4RtSeq;
		this.eqAl9RtSeq = eqAl9RtSeq;
		this.eqGn5RtSeq = eqGn5RtSeq;
		this.eqDwRtSeq = eqDwRtSeq;
		this.eqF4RtSeq = eqF4RtSeq;
		this.eqSl2RtSeq = eqSl2RtSeq;
		this.eqCgRtSeq = eqCgRtSeq;
		this.eqZt4RtSeq = eqZt4RtSeq;
		this.eqAl4RtSeq = eqAl4RtSeq;
		this.eqTaalRtSeq = eqTaalRtSeq;
		this.eqEgalRtSeq = eqEgalRtSeq;
		this.eqAl8RtSeq = eqAl8RtSeq;
		this.eqGn4RtSeq = eqGn4RtSeq;
		this.eqD2RtSeq = eqD2RtSeq;
		this.eqR7RtSeq = eqR7RtSeq;
		this.eqEg5RtSeq = eqEg5RtSeq;
		this.eqPalRtSeq = eqPalRtSeq;
		this.eqCb4RtSeq = eqCb4RtSeq;
		this.eqR5RtSeq = eqR5RtSeq;
		this.eqAl2RtSeq = eqAl2RtSeq;
		this.eqA2RtSeq = eqA2RtSeq;
		this.eqAl7RtSeq = eqAl7RtSeq;
		this.eqA4RtSeq = eqA4RtSeq;
		this.eqO2RtSeq = eqO2RtSeq;
		this.eqT4RtSeq = eqT4RtSeq;
		this.eqTalRtSeq = eqTalRtSeq;
		this.eqFalRtSeq = eqFalRtSeq;
		this.eqRalRtSeq = eqRalRtSeq;
		this.eqSf2RtSeq = eqSf2RtSeq;
		this.eqTa2RtSeq = eqTa2RtSeq;
		this.eqD7RtSeq = eqD7RtSeq;
		this.eqR2RtSeq = eqR2RtSeq;
		this.eqXxxx = eqXxxx;
		this.eqXxxxRtSeq = eqXxxxRtSeq;
		this.agmtCostFlg = agmtCostFlg;
    }
    

	/**
     * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
     * @return HashMap
     */
    public HashMap<String, String> getColumnValues(){
        this.hashColumns.put("to_nod_yd", getToNodYd());
        this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
        this.hashColumns.put("trsp_rnd_rt", getTrspRndRt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("eq_aal", getEqAal());
        this.hashColumns.put("ck_vf", getCkVf());
        this.hashColumns.put("eq_f2", getEqF2());
        this.hashColumns.put("eq_al2", getEqAl2());
        this.hashColumns.put("eq_f4", getEqF4());
        this.hashColumns.put("eq_f5", getEqF5());
        this.hashColumns.put("eq_al5", getEqAl5());
        this.hashColumns.put("eq_al4", getEqAl4());
        this.hashColumns.put("eq_dw", getEqDw());
        this.hashColumns.put("trsp_scg_cd", getTrspScgCd());
        this.hashColumns.put("eq_al7", getEqAl7());
        this.hashColumns.put("eq_o4", getEqO4());
        this.hashColumns.put("eq_al8", getEqAl8());
        this.hashColumns.put("eq_al9", getEqAl9());
        this.hashColumns.put("eq_t2", getEqT2());
        this.hashColumns.put("eq_dx", getEqDx());
        this.hashColumns.put("eq_t4", getEqT4());
        this.hashColumns.put("trsp_one_wy_rt", getTrspOneWyRt());
        this.hashColumns.put("cmdt_grp_cd", getCmdtGrpCd());
        this.hashColumns.put("eq_tal", getEqTal());
        this.hashColumns.put("eq_pal", getEqPal());
        this.hashColumns.put("eq_gn4", getEqGn4());
        this.hashColumns.put("eq_gn5", getEqGn5());
        this.hashColumns.put("cust_cd", getCustCd());
        this.hashColumns.put("eq_ral", getEqRal());
        this.hashColumns.put("eq_sal", getEqSal());
        this.hashColumns.put("eq_o2", getEqO2());
        this.hashColumns.put("rail_svc_tp_cd", getRailSvcTpCd());
        this.hashColumns.put("org_trsp_agmt_eq_sz_cd", getOrgTrspAgmtEqSzCd());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("to_wgt", getToWgt());
        this.hashColumns.put("eq_alal", getEqAlal());
        this.hashColumns.put("dor_nod_cd", getDorNodCd());
        this.hashColumns.put("eq_d4", getEqD4());
        this.hashColumns.put("eq_d5", getEqD5());
        this.hashColumns.put("eq_sf4", getEqSf4());
        this.hashColumns.put("eff_fm_dt", getEffFmDt());
        this.hashColumns.put("wtr_de_term_cd", getWtrDeTermCd());
        this.hashColumns.put("eq_d7", getEqD7());
        this.hashColumns.put("eq_d2", getEqD2());
        this.hashColumns.put("agmt_scg_rt_div_cd", getAgmtScgRtDivCd());
        this.hashColumns.put("eq_sf2", getEqSf2());
        this.hashColumns.put("eq_d3", getEqD3());
        this.hashColumns.put("trsp_agmt_eq_tp_cd", getTrspAgmtEqTpCd());
        this.hashColumns.put("eq_ta2", getEqTa2());
        this.hashColumns.put("eq_d9", getEqD9());
        this.hashColumns.put("eq_d8", getEqD8());
        this.hashColumns.put("chk_rowno", getChkRowno());
        this.hashColumns.put("eq_knd_cd", getEqKndCd());
        this.hashColumns.put("fm_nod_cd", getFmNodCd());
        this.hashColumns.put("eq_ug", getEqUg());
        this.hashColumns.put("eq_cg", getEqCg());
        this.hashColumns.put("via_nod_cd", getViaNodCd());
        this.hashColumns.put("agmt_trsp_tp_cd", getAgmtTrspTpCd());
        this.hashColumns.put("trsp_agmt_bdl_qty", getTrspAgmtBdlQty());
        this.hashColumns.put("via_nod_yd", getViaNodYd());
        this.hashColumns.put("to_nod_cd", getToNodCd());
        this.hashColumns.put("rlt", getRlt());
        this.hashColumns.put("org_trsp_agmt_eq_tp_cd", getOrgTrspAgmtEqTpCd());
        this.hashColumns.put("rowno", getRowno());
        this.hashColumns.put("eq_r7", getEqR7());
        this.hashColumns.put("eq_sfal", getEqSfal());
        this.hashColumns.put("trsp_agmt_rt_tp_cd", getTrspAgmtRtTpCd());
        this.hashColumns.put("trsp_agmt_eq_sz_cd", getTrspAgmtEqSzCd());
        this.hashColumns.put("eq_cb4", getEqCb4());
        this.hashColumns.put("eq_r4", getEqR4());
        this.hashColumns.put("eq_r5", getEqR5());
        this.hashColumns.put("eq_r2", getEqR2());
        this.hashColumns.put("org_eqtype", getOrgEqtype());
        this.hashColumns.put("eq_gnal", getEqGnal());
        this.hashColumns.put("trsp_agmt_dist", getTrspAgmtDist());
        this.hashColumns.put("eq_oal", getEqOal());
        this.hashColumns.put("dist_meas_ut_cd", getDistMeasUtCd());
        this.hashColumns.put("eq_zt4", getEqZt4());
        this.hashColumns.put("eq_s2", getEqS2());
        this.hashColumns.put("chk", getChk());
        this.hashColumns.put("eq_s4", getEqS4());
        this.hashColumns.put("eq_slal", getEqSlal());
        this.hashColumns.put("trsp_agmt_seq", getTrspAgmtSeq());
        this.hashColumns.put("wgt_meas_ut_cd", getWgtMeasUtCd());
        this.hashColumns.put("eff_to_dt", getEffToDt());
        this.hashColumns.put("eq_eg5", getEqEg5());
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("eq_a2", getEqA2());
        this.hashColumns.put("agmt_rout_all_flg", getAgmtRoutAllFlg());
        this.hashColumns.put("eq_a4", getEqA4());
        this.hashColumns.put("trsp_agmt_ofc_cty_cd", getTrspAgmtOfcCtyCd());
        this.hashColumns.put("eq_eg8", getEqEg8());
        this.hashColumns.put("eq_taal", getEqTaal());
        this.hashColumns.put("eq_p4", getEqP4());
        this.hashColumns.put("eq_p2", getEqP2());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("wtr_rcv_term_cd", getWtrRcvTermCd());
        this.hashColumns.put("trsp_rvs_aply_flg", getTrspRvsAplyFlg());
        this.hashColumns.put("eq_fal", getEqFal());
        this.hashColumns.put("trsp_cost_mod_cd", getTrspCostModCd());
        this.hashColumns.put("fm_nod_yd", getFmNodYd());
        this.hashColumns.put("eq_egal", getEqEgal());
        this.hashColumns.put("eq_sl2", getEqSl2());
        this.hashColumns.put("ui_seqno", getUiSeqno());
        this.hashColumns.put("dor_nod_yd", getDorNodYd());
        this.hashColumns.put("eq_dal", getEqDal());
        this.hashColumns.put("trsp_dist_tp_cd", getTrspDistTpCd());
        this.hashColumns.put("com_scg_aply_flg", getComScgAplyFlg());
        this.hashColumns.put("wo_aply_flg", getWoAplyFlg());
        this.hashColumns.put("trsp_agmt_rt_tp_ser_no", getTrspAgmtRtTpSerNo());
        this.hashColumns.put("trsp_agmt_nod_seq", getTrspAgmtNodSeq());
        this.hashColumns.put("trsp_agmt_rt_seq", getTrspAgmtRtSeq());
        this.hashColumns.put("trsp_agmt_scg_nod_seq", getTrspAgmtScgNodSeq());
        this.hashColumns.put("trsp_agmt_scg_rt_seq", getTrspAgmtScgRtSeq());
        this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
        this.hashColumns.put("spcl_cgo_cntr_tp_cd", getSpclCgoCntrTpCd());
        this.hashColumns.put("usr_def_rmk", getUsrDefRmk());
        this.hashColumns.put("aft_usr_def_rmk", getAftUsrDefRmk());
        this.hashColumns.put("org_rt_seq", getOrgRtSeq());

		this.hashColumns.put("eq_d4_rt_seq", getEqD4RtSeq());
		this.hashColumns.put("eq_aal_rt_seq", getEqAalRtSeq());
		this.hashColumns.put("eq_dal_rt_seq", getEqDalRtSeq());
		this.hashColumns.put("eq_s2_rt_seq", getEqS2RtSeq());
		this.hashColumns.put("eq_d5_rt_seq", getEqD5RtSeq());
		this.hashColumns.put("eq_d9_rt_seq", getEqD9RtSeq());
		this.hashColumns.put("eq_r4_rt_seq", getEqR4RtSeq());
		this.hashColumns.put("eq_slal_rt_seq", getEqSlalRtSeq());
		this.hashColumns.put("eq_al5_rt_seq", getEqAl5RtSeq());
		this.hashColumns.put("eq_eg8_rt_seq", getEqEg8RtSeq());
		this.hashColumns.put("eq_sfal_rt_seq", getEqSfalRtSeq());
		this.hashColumns.put("eq_gnal_rt_seq", getEqGnalRtSeq());
		this.hashColumns.put("eq_f2_rt_seq", getEqF2RtSeq());
		this.hashColumns.put("eq_f5_rt_seq", getEqF5RtSeq());
		this.hashColumns.put("eq_oal_rt_seq", getEqOalRtSeq());
		this.hashColumns.put("eq_t2_rt_seq", getEqT2RtSeq());
		this.hashColumns.put("eq_d8_rt_seq", getEqD8RtSeq());
		this.hashColumns.put("eq_sf4_rt_seq", getEqSf4RtSeq());
		this.hashColumns.put("eq_o4_rt_seq", getEqO4RtSeq());
		this.hashColumns.put("eq_ug_rt_seq", getEqUgRtSeq());
		this.hashColumns.put("eq_p2_rt_seq", getEqP2RtSeq());
		this.hashColumns.put("eq_d3_rt_seq", getEqD3RtSeq());
		this.hashColumns.put("eq_s4_rt_seq", getEqS4RtSeq());
		this.hashColumns.put("eq_dx_rt_seq", getEqDxRtSeq());
		this.hashColumns.put("eq_sal_rt_seq", getEqSalRtSeq());
		this.hashColumns.put("eq_alal_rt_seq", getEqAlalRtSeq());
		this.hashColumns.put("eq_p4_rt_seq", getEqP4RtSeq());
		this.hashColumns.put("eq_al9_rt_seq", getEqAl9RtSeq());
		this.hashColumns.put("eq_gn5_rt_seq", getEqGn5RtSeq());
		this.hashColumns.put("eq_dw_rt_seq", getEqDwRtSeq());
		this.hashColumns.put("eq_f4_rt_seq", getEqF4RtSeq());
		this.hashColumns.put("eq_sl2_rt_seq", getEqSl2RtSeq());
		this.hashColumns.put("eq_cg_rt_seq", getEqCgRtSeq());
		this.hashColumns.put("eq_zt4_rt_seq", getEqZt4RtSeq());
		this.hashColumns.put("eq_al4_rt_seq", getEqAl4RtSeq());
		this.hashColumns.put("eq_taal_rt_seq", getEqTaalRtSeq());
		this.hashColumns.put("eq_egal_rt_seq", getEqEgalRtSeq());
		this.hashColumns.put("eq_al8_rt_seq", getEqAl8RtSeq());
		this.hashColumns.put("eq_gn4_rt_seq", getEqGn4RtSeq());
		this.hashColumns.put("eq_d2_rt_seq", getEqD2RtSeq());
		this.hashColumns.put("eq_r7_rt_seq", getEqR7RtSeq());
		this.hashColumns.put("eq_eg5_rt_seq", getEqEg5RtSeq());
		this.hashColumns.put("eq_pal_rt_seq", getEqPalRtSeq());
		this.hashColumns.put("eq_cb4_rt_seq", getEqCb4RtSeq());
		this.hashColumns.put("eq_r5_rt_seq", getEqR5RtSeq());
		this.hashColumns.put("eq_al2_rt_seq", getEqAl2RtSeq());
		this.hashColumns.put("eq_a2_rt_seq", getEqA2RtSeq());
		this.hashColumns.put("eq_al7_rt_seq", getEqAl7RtSeq());
		this.hashColumns.put("eq_a4_rt_seq", getEqA4RtSeq());
		this.hashColumns.put("eq_o2_rt_seq", getEqO2RtSeq());
		this.hashColumns.put("eq_t4_rt_seq", getEqT4RtSeq());
		this.hashColumns.put("eq_tal_rt_seq", getEqTalRtSeq());
		this.hashColumns.put("eq_fal_rt_seq", getEqFalRtSeq());
		this.hashColumns.put("eq_ral_rt_seq", getEqRalRtSeq());
		this.hashColumns.put("eq_sf2_rt_seq", getEqSf2RtSeq());
		this.hashColumns.put("eq_ta2_rt_seq", getEqTa2RtSeq());
		this.hashColumns.put("eq_d7_rt_seq", getEqD7RtSeq());
		this.hashColumns.put("eq_r2_rt_seq", getEqR2RtSeq());
		this.hashColumns.put("eq_xxxx", getEqXxxx());
		this.hashColumns.put("eq_xxxx_rt_seq", getEqXxxxRtSeq());
		this.hashColumns.put("agmt_cost_flg", getAgmtCostFlg());
        return this.hashColumns;
    }
    
    /**
     * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
     * @return
     */
    public HashMap<String, String> getFieldNames(){
        this.hashFields.put("to_nod_yd", "toNodYd");
        this.hashFields.put("cgo_tp_cd", "cgoTpCd");
        this.hashFields.put("trsp_rnd_rt", "trspRndRt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("eq_aal", "eqAal");
        this.hashFields.put("ck_vf", "ckVf");
        this.hashFields.put("eq_f2", "eqF2");
        this.hashFields.put("eq_al2", "eqAl2");
        this.hashFields.put("eq_f4", "eqF4");
        this.hashFields.put("eq_f5", "eqF5");
        this.hashFields.put("eq_al5", "eqAl5");
        this.hashFields.put("eq_al4", "eqAl4");
        this.hashFields.put("eq_dw", "eqDw");
        this.hashFields.put("trsp_scg_cd", "trspScgCd");
        this.hashFields.put("eq_al7", "eqAl7");
        this.hashFields.put("eq_o4", "eqO4");
        this.hashFields.put("eq_al8", "eqAl8");
        this.hashFields.put("eq_al9", "eqAl9");
        this.hashFields.put("eq_t2", "eqT2");
        this.hashFields.put("eq_dx", "eqDx");
        this.hashFields.put("eq_t4", "eqT4");
        this.hashFields.put("trsp_one_wy_rt", "trspOneWyRt");
        this.hashFields.put("cmdt_grp_cd", "cmdtGrpCd");
        this.hashFields.put("eq_tal", "eqTal");
        this.hashFields.put("eq_pal", "eqPal");
        this.hashFields.put("eq_gn4", "eqGn4");
        this.hashFields.put("eq_gn5", "eqGn5");
        this.hashFields.put("cust_cd", "custCd");
        this.hashFields.put("eq_ral", "eqRal");
        this.hashFields.put("eq_sal", "eqSal");
        this.hashFields.put("eq_o2", "eqO2");
        this.hashFields.put("rail_svc_tp_cd", "railSvcTpCd");
        this.hashFields.put("org_trsp_agmt_eq_sz_cd", "orgTrspAgmtEqSzCd");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("to_wgt", "toWgt");
        this.hashFields.put("eq_alal", "eqAlal");
        this.hashFields.put("dor_nod_cd", "dorNodCd");
        this.hashFields.put("eq_d4", "eqD4");
        this.hashFields.put("eq_d5", "eqD5");
        this.hashFields.put("eq_sf4", "eqSf4");
        this.hashFields.put("eff_fm_dt", "effFmDt");
        this.hashFields.put("wtr_de_term_cd", "wtrDeTermCd");
        this.hashFields.put("eq_d7", "eqD7");
        this.hashFields.put("eq_d2", "eqD2");
        this.hashFields.put("agmt_scg_rt_div_cd", "agmtScgRtDivCd");
        this.hashFields.put("eq_sf2", "eqSf2");
        this.hashFields.put("eq_d3", "eqD3");
        this.hashFields.put("trsp_agmt_eq_tp_cd", "trspAgmtEqTpCd");
        this.hashFields.put("eq_ta2", "eqTa2");
        this.hashFields.put("eq_d9", "eqD9");
        this.hashFields.put("eq_d8", "eqD8");
        this.hashFields.put("chk_rowno", "chkRowno");
        this.hashFields.put("eq_knd_cd", "eqKndCd");
        this.hashFields.put("fm_nod_cd", "fmNodCd");
        this.hashFields.put("eq_ug", "eqUg");
        this.hashFields.put("eq_cg", "eqCg");
        this.hashFields.put("via_nod_cd", "viaNodCd");
        this.hashFields.put("agmt_trsp_tp_cd", "agmtTrspTpCd");
        this.hashFields.put("trsp_agmt_bdl_qty", "trspAgmtBdlQty");
        this.hashFields.put("via_nod_yd", "viaNodYd");
        this.hashFields.put("to_nod_cd", "toNodCd");
        this.hashFields.put("rlt", "rlt");
        this.hashFields.put("org_trsp_agmt_eq_tp_cd", "orgTrspAgmtEqTpCd");
        this.hashFields.put("rowno", "rowno");
        this.hashFields.put("eq_r7", "eqR7");
        this.hashFields.put("eq_sfal", "eqSfal");
        this.hashFields.put("trsp_agmt_rt_tp_cd", "trspAgmtRtTpCd");
        this.hashFields.put("trsp_agmt_eq_sz_cd", "trspAgmtEqSzCd");
        this.hashFields.put("eq_cb4", "eqCb4");
        this.hashFields.put("eq_r4", "eqR4");
        this.hashFields.put("eq_r5", "eqR5");
        this.hashFields.put("eq_r2", "eqR2");
        this.hashFields.put("org_eqtype", "orgEqtype");
        this.hashFields.put("eq_gnal", "eqGnal");
        this.hashFields.put("trsp_agmt_dist", "trspAgmtDist");
        this.hashFields.put("eq_oal", "eqOal");
        this.hashFields.put("dist_meas_ut_cd", "distMeasUtCd");
        this.hashFields.put("eq_zt4", "eqZt4");
        this.hashFields.put("eq_s2", "eqS2");
        this.hashFields.put("chk", "chk");
        this.hashFields.put("eq_s4", "eqS4");
        this.hashFields.put("eq_slal", "eqSlal");
        this.hashFields.put("trsp_agmt_seq", "trspAgmtSeq");
        this.hashFields.put("wgt_meas_ut_cd", "wgtMeasUtCd");
        this.hashFields.put("eff_to_dt", "effToDt");
        this.hashFields.put("eq_eg5", "eqEg5");
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("eq_a2", "eqA2");
        this.hashFields.put("agmt_rout_all_flg", "agmtRoutAllFlg");
        this.hashFields.put("eq_a4", "eqA4");
        this.hashFields.put("trsp_agmt_ofc_cty_cd", "trspAgmtOfcCtyCd");
        this.hashFields.put("eq_eg8", "eqEg8");
        this.hashFields.put("eq_taal", "eqTaal");
        this.hashFields.put("eq_p4", "eqP4");
        this.hashFields.put("eq_p2", "eqP2");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("wtr_rcv_term_cd", "wtrRcvTermCd");
        this.hashFields.put("trsp_rvs_aply_flg", "trspRvsAplyFlg");
        this.hashFields.put("eq_fal", "eqFal");
        this.hashFields.put("trsp_cost_mod_cd", "trspCostModCd");
        this.hashFields.put("fm_nod_yd", "fmNodYd");
        this.hashFields.put("eq_egal", "eqEgal");
        this.hashFields.put("eq_sl2", "eqSl2");
        this.hashFields.put("ui_seqno", "uiSeqno");
        this.hashFields.put("dor_nod_yd", "dorNodYd");
        this.hashFields.put("eq_dal", "eqDal");
        this.hashFields.put("trsp_dist_tp_cd", "trspDistTpCd");
        this.hashFields.put("com_scg_aply_flg", "comScgAplyFlg");
        this.hashFields.put("wo_aply_flg", "woAplyFlg");
        this.hashFields.put("trsp_agmt_rt_tp_ser_no", "trspAgmtRtTpSerNo");
        this.hashFields.put("trsp_agmt_nod_seq", "trspAgmtNodSeq");
        this.hashFields.put("trsp_agmt_rt_seq", "trspAgmtRtSeq");
        this.hashFields.put("trsp_agmt_scg_nod_seq", "trspAgmtScgNodSeq");
        this.hashFields.put("trsp_agmt_scg_rt_seq", "trspAgmtScgRtSeq");
        this.hashFields.put("trsp_bnd_cd", "trspBndCd");
        this.hashFields.put("spcl_cgo_cntr_tp_cd", "spclCgoCntrTpCd");
        this.hashFields.put("usr_def_rmk", "usrDefRmk");
        this.hashFields.put("aft_usr_def_rmk", "aftUsrDefRmk");
        this.hashFields.put("org_rt_seq", "orgRtSeq");

		this.hashFields.put("eq_d4_rt_seq", "eqD4RtSeq");
		this.hashFields.put("eq_aal_rt_seq", "eqAalRtSeq");
		this.hashFields.put("eq_dal_rt_seq", "eqDalRtSeq");
		this.hashFields.put("eq_s2_rt_seq", "eqS2RtSeq");
		this.hashFields.put("eq_d5_rt_seq", "eqD5RtSeq");
		this.hashFields.put("eq_d9_rt_seq", "eqD9RtSeq");
		this.hashFields.put("eq_r4_rt_seq", "eqR4RtSeq");
		this.hashFields.put("eq_slal_rt_seq", "eqSlalRtSeq");
		this.hashFields.put("eq_al5_rt_seq", "eqAl5RtSeq");
		this.hashFields.put("eq_eg8_rt_seq", "eqEg8RtSeq");
		this.hashFields.put("eq_sfal_rt_seq", "eqSfalRtSeq");
		this.hashFields.put("eq_gnal_rt_seq", "eqGnalRtSeq");
		this.hashFields.put("eq_f2_rt_seq", "eqF2RtSeq");
		this.hashFields.put("eq_f5_rt_seq", "eqF5RtSeq");
		this.hashFields.put("eq_oal_rt_seq", "eqOalRtSeq");
		this.hashFields.put("eq_t2_rt_seq", "eqT2RtSeq");
		this.hashFields.put("eq_d8_rt_seq", "eqD8RtSeq");
		this.hashFields.put("eq_sf4_rt_seq", "eqSf4RtSeq");
		this.hashFields.put("eq_o4_rt_seq", "eqO4RtSeq");
		this.hashFields.put("eq_ug_rt_seq", "eqUgRtSeq");
		this.hashFields.put("eq_p2_rt_seq", "eqP2RtSeq");
		this.hashFields.put("eq_d3_rt_seq", "eqD3RtSeq");
		this.hashFields.put("eq_s4_rt_seq", "eqS4RtSeq");
		this.hashFields.put("eq_dx_rt_seq", "eqDxRtSeq");
		this.hashFields.put("eq_sal_rt_seq", "eqSalRtSeq");
		this.hashFields.put("eq_alal_rt_seq", "eqAlalRtSeq");
		this.hashFields.put("eq_p4_rt_seq", "eqP4RtSeq");
		this.hashFields.put("eq_al9_rt_seq", "eqAl9RtSeq");
		this.hashFields.put("eq_gn5_rt_seq", "eqGn5RtSeq");
		this.hashFields.put("eq_dw_rt_seq", "eqDwRtSeq");
		this.hashFields.put("eq_f4_rt_seq", "eqF4RtSeq");
		this.hashFields.put("eq_sl2_rt_seq", "eqSl2RtSeq");
		this.hashFields.put("eq_cg_rt_seq", "eqCgRtSeq");
		this.hashFields.put("eq_zt4_rt_seq", "eqZt4RtSeq");
		this.hashFields.put("eq_al4_rt_seq", "eqAl4RtSeq");
		this.hashFields.put("eq_taal_rt_seq", "eqTaalRtSeq");
		this.hashFields.put("eq_egal_rt_seq", "eqEgalRtSeq");
		this.hashFields.put("eq_al8_rt_seq", "eqAl8RtSeq");
		this.hashFields.put("eq_gn4_rt_seq", "eqGn4RtSeq");
		this.hashFields.put("eq_d2_rt_seq", "eqD2RtSeq");
		this.hashFields.put("eq_r7_rt_seq", "eqR7RtSeq");
		this.hashFields.put("eq_eg5_rt_seq", "eqEg5RtSeq");
		this.hashFields.put("eq_pal_rt_seq", "eqPalRtSeq");
		this.hashFields.put("eq_cb4_rt_seq", "eqCb4RtSeq");
		this.hashFields.put("eq_r5_rt_seq", "eqR5RtSeq");
		this.hashFields.put("eq_al2_rt_seq", "eqAl2RtSeq");
		this.hashFields.put("eq_a2_rt_seq", "eqA2RtSeq");
		this.hashFields.put("eq_al7_rt_seq", "eqAl7RtSeq");
		this.hashFields.put("eq_a4_rt_seq", "eqA4RtSeq");
		this.hashFields.put("eq_o2_rt_seq", "eqO2RtSeq");
		this.hashFields.put("eq_t4_rt_seq", "eqT4RtSeq");
		this.hashFields.put("eq_tal_rt_seq", "eqTalRtSeq");
		this.hashFields.put("eq_fal_rt_seq", "eqFalRtSeq");
		this.hashFields.put("eq_ral_rt_seq", "eqRalRtSeq");
		this.hashFields.put("eq_sf2_rt_seq", "eqSf2RtSeq");
		this.hashFields.put("eq_ta2_rt_seq", "eqTa2RtSeq");
		this.hashFields.put("eq_d7_rt_seq", "eqD7RtSeq");
		this.hashFields.put("eq_r2_rt_seq", "eqR2RtSeq");
		this.hashFields.put("eq_xxxx", "eqXxxx");
		this.hashFields.put("eq_xxxx_rt_seq", "eqXxxxRtSeq");
		this.hashFields.put("agmt_cost_flg", "agmtCostFlg");
        return this.hashFields;
    }
    
    /**
     * Column Info
     * @return toNodYd
     */
    public String getToNodYd() {
        return this.toNodYd;
    }
    
    /**
     * Column Info
     * @return cgoTpCd
     */
    public String getCgoTpCd() {
        return this.cgoTpCd;
    }
    
    /**
     * Column Info
     * @return trspRndRt
     */
    public String getTrspRndRt() {
        return this.trspRndRt;
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
     * @return eqAal
     */
    public String getEqAal() {
        return this.eqAal;
    }
    
    /**
     * Column Info
     * @return ckVf
     */
    public String getCkVf() {
        return this.ckVf;
    }
    
    /**
     * Column Info
     * @return eqF2
     */
    public String getEqF2() {
        return this.eqF2;
    }
    
    /**
     * Column Info
     * @return eqAl2
     */
    public String getEqAl2() {
        return this.eqAl2;
    }
    
    /**
     * Column Info
     * @return eqF4
     */
    public String getEqF4() {
        return this.eqF4;
    }
    
    /**
     * Column Info
     * @return eqF5
     */
    public String getEqF5() {
        return this.eqF5;
    }
    
    /**
     * Column Info
     * @return eqAl5
     */
    public String getEqAl5() {
        return this.eqAl5;
    }
    
    /**
     * Column Info
     * @return eqAl4
     */
    public String getEqAl4() {
        return this.eqAl4;
    }
    
    /**
     * Column Info
     * @return eqDw
     */
    public String getEqDw() {
        return this.eqDw;
    }
    
    /**
     * Column Info
     * @return trspScgCd
     */
    public String getTrspScgCd() {
        return this.trspScgCd;
    }
    
    /**
     * Column Info
     * @return eqAl7
     */
    public String getEqAl7() {
        return this.eqAl7;
    }
    
    /**
     * Column Info
     * @return eqO4
     */
    public String getEqO4() {
        return this.eqO4;
    }
    
    /**
     * Column Info
     * @return eqAl8
     */
    public String getEqAl8() {
        return this.eqAl8;
    }
    
    /**
     * Column Info
     * @return eqAl9
     */
    public String getEqAl9() {
        return this.eqAl9;
    }
    
    /**
     * Column Info
     * @return eqT2
     */
    public String getEqT2() {
        return this.eqT2;
    }
    
    /**
     * Column Info
     * @return eqDx
     */
    public String getEqDx() {
        return this.eqDx;
    }
    
    /**
     * Column Info
     * @return eqT4
     */
    public String getEqT4() {
        return this.eqT4;
    }
    
    /**
     * Column Info
     * @return trspOneWyRt
     */
    public String getTrspOneWyRt() {
        return this.trspOneWyRt;
    }
    
    /**
     * Column Info
     * @return cmdtGrpCd
     */
    public String getCmdtGrpCd() {
        return this.cmdtGrpCd;
    }
    
    /**
     * Column Info
     * @return eqTal
     */
    public String getEqTal() {
        return this.eqTal;
    }
    
    /**
     * Column Info
     * @return eqPal
     */
    public String getEqPal() {
        return this.eqPal;
    }
    
    /**
     * Column Info
     * @return eqGn4
     */
    public String getEqGn4() {
        return this.eqGn4;
    }
    
    /**
     * Column Info
     * @return eqGn5
     */
    public String getEqGn5() {
        return this.eqGn5;
    }
    
    /**
     * Column Info
     * @return custCd
     */
    public String getCustCd() {
        return this.custCd;
    }
    
    /**
     * Column Info
     * @return eqRal
     */
    public String getEqRal() {
        return this.eqRal;
    }
    
    /**
     * Column Info
     * @return eqSal
     */
    public String getEqSal() {
        return this.eqSal;
    }
    
    /**
     * Column Info
     * @return eqO2
     */
    public String getEqO2() {
        return this.eqO2;
    }
    
    /**
     * Column Info
     * @return railSvcTpCd
     */
    public String getRailSvcTpCd() {
        return this.railSvcTpCd;
    }
    
    /**
     * Column Info
     * @return orgTrspAgmtEqSzCd
     */
    public String getOrgTrspAgmtEqSzCd() {
        return this.orgTrspAgmtEqSzCd;
    }
    
    /**
     * Column Info
     * @return deltFlg
     */
    public String getDeltFlg() {
        return this.deltFlg;
    }
    
    /**
     * Column Info
     * @return toWgt
     */
    public String getToWgt() {
        return this.toWgt;
    }
    
    /**
     * Column Info
     * @return eqAlal
     */
    public String getEqAlal() {
        return this.eqAlal;
    }
    
    /**
     * Column Info
     * @return dorNodCd
     */
    public String getDorNodCd() {
        return this.dorNodCd;
    }
    
    /**
     * Column Info
     * @return eqD4
     */
    public String getEqD4() {
        return this.eqD4;
    }
    
    /**
     * Column Info
     * @return eqD5
     */
    public String getEqD5() {
        return this.eqD5;
    }
    
    /**
     * Column Info
     * @return eqSf4
     */
    public String getEqSf4() {
        return this.eqSf4;
    }
    
    /**
     * Column Info
     * @return effFmDt
     */
    public String getEffFmDt() {
        return this.effFmDt;
    }
    
    /**
     * Column Info
     * @return wtrDeTermCd
     */
    public String getWtrDeTermCd() {
        return this.wtrDeTermCd;
    }
    
    /**
     * Column Info
     * @return eqD7
     */
    public String getEqD7() {
        return this.eqD7;
    }
    
    /**
     * Column Info
     * @return eqD2
     */
    public String getEqD2() {
        return this.eqD2;
    }
    
    /**
     * Column Info
     * @return agmtScgRtDivCd
     */
    public String getAgmtScgRtDivCd() {
        return this.agmtScgRtDivCd;
    }
    
    /**
     * Column Info
     * @return eqSf2
     */
    public String getEqSf2() {
        return this.eqSf2;
    }
    
    /**
     * Column Info
     * @return eqD3
     */
    public String getEqD3() {
        return this.eqD3;
    }
    
    /**
     * Column Info
     * @return trspAgmtEqTpCd
     */
    public String getTrspAgmtEqTpCd() {
        return this.trspAgmtEqTpCd;
    }
    
    /**
     * Column Info
     * @return eqTa2
     */
    public String getEqTa2() {
        return this.eqTa2;
    }
    
    /**
     * Column Info
     * @return eqD9
     */
    public String getEqD9() {
        return this.eqD9;
    }
    
    /**
     * Column Info
     * @return eqD8
     */
    public String getEqD8() {
        return this.eqD8;
    }
    
    /**
     * Column Info
     * @return chkRowno
     */
    public String getChkRowno() {
        return this.chkRowno;
    }
    
    /**
     * Column Info
     * @return eqKndCd
     */
    public String getEqKndCd() {
        return this.eqKndCd;
    }
    
    /**
     * Column Info
     * @return fmNodCd
     */
    public String getFmNodCd() {
        return this.fmNodCd;
    }
    
    /**
     * Column Info
     * @return eqUg
     */
    public String getEqUg() {
        return this.eqUg;
    }
    
    /**
     * Column Info
     * @return eqCg
     */
    public String getEqCg() {
        return this.eqCg;
    }
    
    /**
     * Column Info
     * @return viaNodCd
     */
    public String getViaNodCd() {
        return this.viaNodCd;
    }
    
    /**
     * Column Info
     * @return agmtTrspTpCd
     */
    public String getAgmtTrspTpCd() {
        return this.agmtTrspTpCd;
    }
    
    /**
     * Column Info
     * @return trspAgmtBdlQty
     */
    public String getTrspAgmtBdlQty() {
        return this.trspAgmtBdlQty;
    }
    
    /**
     * Column Info
     * @return viaNodYd
     */
    public String getViaNodYd() {
        return this.viaNodYd;
    }
    
    /**
     * Column Info
     * @return toNodCd
     */
    public String getToNodCd() {
        return this.toNodCd;
    }
    
    /**
     * Column Info
     * @return rlt
     */
    public String getRlt() {
        return this.rlt;
    }
    
    /**
     * Column Info
     * @return orgTrspAgmtEqTpCd
     */
    public String getOrgTrspAgmtEqTpCd() {
        return this.orgTrspAgmtEqTpCd;
    }
    
    /**
     * Column Info
     * @return rowno
     */
    public String getRowno() {
        return this.rowno;
    }
    
    /**
     * Column Info
     * @return eqR7
     */
    public String getEqR7() {
        return this.eqR7;
    }
    
    /**
     * Column Info
     * @return eqSfal
     */
    public String getEqSfal() {
        return this.eqSfal;
    }
    
    /**
     * Column Info
     * @return trspAgmtRtTpCd
     */
    public String getTrspAgmtRtTpCd() {
        return this.trspAgmtRtTpCd;
    }
    
    /**
     * Column Info
     * @return trspAgmtEqSzCd
     */
    public String getTrspAgmtEqSzCd() {
        return this.trspAgmtEqSzCd;
    }
    
    /**
     * Column Info
     * @return eqCb4
     */
    public String getEqCb4() {
        return this.eqCb4;
    }
    
    /**
     * Column Info
     * @return eqR4
     */
    public String getEqR4() {
        return this.eqR4;
    }
    
    /**
     * Column Info
     * @return eqR5
     */
    public String getEqR5() {
        return this.eqR5;
    }
    
    /**
     * Column Info
     * @return eqR2
     */
    public String getEqR2() {
        return this.eqR2;
    }
    
    /**
     * Column Info
     * @return orgEqtype
     */
    public String getOrgEqtype() {
        return this.orgEqtype;
    }
    
    /**
     * Column Info
     * @return eqGnal
     */
    public String getEqGnal() {
        return this.eqGnal;
    }
    
    /**
     * Column Info
     * @return trspAgmtDist
     */
    public String getTrspAgmtDist() {
        return this.trspAgmtDist;
    }
    
    /**
     * Column Info
     * @return eqOal
     */
    public String getEqOal() {
        return this.eqOal;
    }
    
    /**
     * Column Info
     * @return distMeasUtCd
     */
    public String getDistMeasUtCd() {
        return this.distMeasUtCd;
    }
    
    /**
     * Column Info
     * @return eqZt4
     */
    public String getEqZt4() {
        return this.eqZt4;
    }
    
    /**
     * Column Info
     * @return eqS2
     */
    public String getEqS2() {
        return this.eqS2;
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
     * @return eqS4
     */
    public String getEqS4() {
        return this.eqS4;
    }
    
    /**
     * Column Info
     * @return eqSlal
     */
    public String getEqSlal() {
        return this.eqSlal;
    }
    
    /**
     * Column Info
     * @return trspAgmtSeq
     */
    public String getTrspAgmtSeq() {
        return this.trspAgmtSeq;
    }
    
    /**
     * Column Info
     * @return wgtMeasUtCd
     */
    public String getWgtMeasUtCd() {
        return this.wgtMeasUtCd;
    }
    
    /**
     * Column Info
     * @return effToDt
     */
    public String getEffToDt() {
        return this.effToDt;
    }
    
    /**
     * Column Info
     * @return eqEg5
     */
    public String getEqEg5() {
        return this.eqEg5;
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
     * @return eqA2
     */
    public String getEqA2() {
        return this.eqA2;
    }
    
    /**
     * Column Info
     * @return agmtRoutAllFlg
     */
    public String getAgmtRoutAllFlg() {
        return this.agmtRoutAllFlg;
    }
    
    /**
     * Column Info
     * @return eqA4
     */
    public String getEqA4() {
        return this.eqA4;
    }
    
    /**
     * Column Info
     * @return trspAgmtOfcCtyCd
     */
    public String getTrspAgmtOfcCtyCd() {
        return this.trspAgmtOfcCtyCd;
    }
    
    /**
     * Column Info
     * @return eqEg8
     */
    public String getEqEg8() {
        return this.eqEg8;
    }
    
    /**
     * Column Info
     * @return eqTaal
     */
    public String getEqTaal() {
        return this.eqTaal;
    }
    
    /**
     * Column Info
     * @return eqP4
     */
    public String getEqP4() {
        return this.eqP4;
    }
    
    /**
     * Column Info
     * @return eqP2
     */
    public String getEqP2() {
        return this.eqP2;
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
     * @return wtrRcvTermCd
     */
    public String getWtrRcvTermCd() {
        return this.wtrRcvTermCd;
    }
    
    /**
     * Column Info
     * @return trspRvsAplyFlg
     */
    public String getTrspRvsAplyFlg() {
        return this.trspRvsAplyFlg;
    }
    
    /**
     * Column Info
     * @return eqFal
     */
    public String getEqFal() {
        return this.eqFal;
    }
    
    /**
     * Column Info
     * @return trspCostModCd
     */
    public String getTrspCostModCd() {
        return this.trspCostModCd;
    }
    
    /**
     * Column Info
     * @return fmNodYd
     */
    public String getFmNodYd() {
        return this.fmNodYd;
    }
    
    /**
     * Column Info
     * @return eqEgal
     */
    public String getEqEgal() {
        return this.eqEgal;
    }
    
    /**
     * Column Info
     * @return eqSl2
     */
    public String getEqSl2() {
        return this.eqSl2;
    }
    
    /**
     * Column Info
     * @return uiSeqno
     */
    public String getUiSeqno() {
        return this.uiSeqno;
    }
    
    /**
     * Column Info
     * @return dorNodYd
     */
    public String getDorNodYd() {
        return this.dorNodYd;
    }
    
    /**
     * Column Info
     * @return eqDal
     */
    public String getEqDal() {
        return this.eqDal;
    }
    
    /**
     * Column Info
     * @return trspDistTpCd
     */
    public String getTrspDistTpCd() {
        return this.trspDistTpCd;
    }
    
    /**
     * Column Info
     * @return comScgAplyFlg
     */
    public String getComScgAplyFlg() {
        return this.comScgAplyFlg;
    }

    /**
     * Column Info
     * @return woAplyFlg
     */
    public String getWoAplyFlg() {
        return this.woAplyFlg;
    }

    /**
     * Column Info
     * @return trspAgmtRtTpSerNo
     */
    public String getTrspAgmtRtTpSerNo() {
        return this.trspAgmtRtTpSerNo;
    }

    /**
     * Column Info
     * @return trspAgmtNodSeq
     */
    public String getTrspAgmtNodSeq() {
        return this.trspAgmtNodSeq;
    }

    /**
     * Column Info
     * @return trspAgmtRtSeq
     */
    public String getTrspAgmtRtSeq() {
        return this.trspAgmtRtSeq;
    }

    /**
     * Column Info
     * @return trspAgmtScgNodSeq
     */
    public String getTrspAgmtScgNodSeq() {
        return this.trspAgmtScgNodSeq;
    }

    /**
     * Column Info
     * @return trspAgmtScgRtSeq
     */
    public String getTrspAgmtScgRtSeq() {
        return this.trspAgmtScgRtSeq;
    }

    /**
     * Column Info
     * @return trspBndCd
     */
    public String getTrspBndCd() {
		return trspBndCd;
	}

	/**
     * Column Info
     * @return spclCgoCntrTpCd
     */
	public String getSpclCgoCntrTpCd() {
		return spclCgoCntrTpCd;
	}

    /**
     * Column Info
     * @param toNodYd
     */
    public void setToNodYd(String toNodYd) {
        this.toNodYd = toNodYd;
    }
    
    /**
     * Column Info
     * @param cgoTpCd
     */
    public void setCgoTpCd(String cgoTpCd) {
        this.cgoTpCd = cgoTpCd;
    }
    
    /**
     * Column Info
     * @param trspRndRt
     */
    public void setTrspRndRt(String trspRndRt) {
        this.trspRndRt = trspRndRt;
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
     * @param eqAal
     */
    public void setEqAal(String eqAal) {
        this.eqAal = eqAal;
    }
    
    /**
     * Column Info
     * @param ckVf
     */
    public void setCkVf(String ckVf) {
        this.ckVf = ckVf;
    }
    
    /**
     * Column Info
     * @param eqF2
     */
    public void setEqF2(String eqF2) {
        this.eqF2 = eqF2;
    }
    
    /**
     * Column Info
     * @param eqAl2
     */
    public void setEqAl2(String eqAl2) {
        this.eqAl2 = eqAl2;
    }
    
    /**
     * Column Info
     * @param eqF4
     */
    public void setEqF4(String eqF4) {
        this.eqF4 = eqF4;
    }
    
    /**
     * Column Info
     * @param eqF5
     */
    public void setEqF5(String eqF5) {
        this.eqF5 = eqF5;
    }
    
    /**
     * Column Info
     * @param eqAl5
     */
    public void setEqAl5(String eqAl5) {
        this.eqAl5 = eqAl5;
    }
    
    /**
     * Column Info
     * @param eqAl4
     */
    public void setEqAl4(String eqAl4) {
        this.eqAl4 = eqAl4;
    }
    
    /**
     * Column Info
     * @param eqDw
     */
    public void setEqDw(String eqDw) {
        this.eqDw = eqDw;
    }
    
    /**
     * Column Info
     * @param trspScgCd
     */
    public void setTrspScgCd(String trspScgCd) {
        this.trspScgCd = trspScgCd;
    }
    
    /**
     * Column Info
     * @param eqAl7
     */
    public void setEqAl7(String eqAl7) {
        this.eqAl7 = eqAl7;
    }
    
    /**
     * Column Info
     * @param eqO4
     */
    public void setEqO4(String eqO4) {
        this.eqO4 = eqO4;
    }
    
    /**
     * Column Info
     * @param eqAl8
     */
    public void setEqAl8(String eqAl8) {
        this.eqAl8 = eqAl8;
    }
    
    /**
     * Column Info
     * @param eqAl9
     */
    public void setEqAl9(String eqAl9) {
        this.eqAl9 = eqAl9;
    }
    
    /**
     * Column Info
     * @param eqT2
     */
    public void setEqT2(String eqT2) {
        this.eqT2 = eqT2;
    }
    
    /**
     * Column Info
     * @param eqDx
     */
    public void setEqDx(String eqDx) {
        this.eqDx = eqDx;
    }
    
    /**
     * Column Info
     * @param eqT4
     */
    public void setEqT4(String eqT4) {
        this.eqT4 = eqT4;
    }
    
    /**
     * Column Info
     * @param trspOneWyRt
     */
    public void setTrspOneWyRt(String trspOneWyRt) {
        this.trspOneWyRt = trspOneWyRt;
    }
    
    /**
     * Column Info
     * @param cmdtGrpCd
     */
    public void setCmdtGrpCd(String cmdtGrpCd) {
        this.cmdtGrpCd = cmdtGrpCd;
    }
    
    /**
     * Column Info
     * @param eqTal
     */
    public void setEqTal(String eqTal) {
        this.eqTal = eqTal;
    }
    
    /**
     * Column Info
     * @param eqPal
     */
    public void setEqPal(String eqPal) {
        this.eqPal = eqPal;
    }
    
    /**
     * Column Info
     * @param eqGn4
     */
    public void setEqGn4(String eqGn4) {
        this.eqGn4 = eqGn4;
    }
    
    /**
     * Column Info
     * @param eqGn5
     */
    public void setEqGn5(String eqGn5) {
        this.eqGn5 = eqGn5;
    }
    
    /**
     * Column Info
     * @param custCd
     */
    public void setCustCd(String custCd) {
        this.custCd = custCd;
    }
    
    /**
     * Column Info
     * @param eqRal
     */
    public void setEqRal(String eqRal) {
        this.eqRal = eqRal;
    }
    
    /**
     * Column Info
     * @param eqSal
     */
    public void setEqSal(String eqSal) {
        this.eqSal = eqSal;
    }
    
    /**
     * Column Info
     * @param eqO2
     */
    public void setEqO2(String eqO2) {
        this.eqO2 = eqO2;
    }
    
    /**
     * Column Info
     * @param railSvcTpCd
     */
    public void setRailSvcTpCd(String railSvcTpCd) {
        this.railSvcTpCd = railSvcTpCd;
    }
    
    /**
     * Column Info
     * @param orgTrspAgmtEqSzCd
     */
    public void setOrgTrspAgmtEqSzCd(String orgTrspAgmtEqSzCd) {
        this.orgTrspAgmtEqSzCd = orgTrspAgmtEqSzCd;
    }
    
    /**
     * Column Info
     * @param deltFlg
     */
    public void setDeltFlg(String deltFlg) {
        this.deltFlg = deltFlg;
    }
    
    /**
     * Column Info
     * @param toWgt
     */
    public void setToWgt(String toWgt) {
        this.toWgt = toWgt;
    }
    
    /**
     * Column Info
     * @param eqAlal
     */
    public void setEqAlal(String eqAlal) {
        this.eqAlal = eqAlal;
    }
    
    /**
     * Column Info
     * @param dorNodCd
     */
    public void setDorNodCd(String dorNodCd) {
        this.dorNodCd = dorNodCd;
    }
    
    /**
     * Column Info
     * @param eqD4
     */
    public void setEqD4(String eqD4) {
        this.eqD4 = eqD4;
    }
    
    /**
     * Column Info
     * @param eqD5
     */
    public void setEqD5(String eqD5) {
        this.eqD5 = eqD5;
    }
    
    /**
     * Column Info
     * @param eqSf4
     */
    public void setEqSf4(String eqSf4) {
        this.eqSf4 = eqSf4;
    }
    
    /**
     * Column Info
     * @param effFmDt
     */
    public void setEffFmDt(String effFmDt) {
        this.effFmDt = effFmDt;
    }
    
    /**
     * Column Info
     * @param wtrDeTermCd
     */
    public void setWtrDeTermCd(String wtrDeTermCd) {
        this.wtrDeTermCd = wtrDeTermCd;
    }
    
    /**
     * Column Info
     * @param eqD7
     */
    public void setEqD7(String eqD7) {
        this.eqD7 = eqD7;
    }
    
    /**
     * Column Info
     * @param eqD2
     */
    public void setEqD2(String eqD2) {
        this.eqD2 = eqD2;
    }
    
    /**
     * Column Info
     * @param agmtScgRtDivCd
     */
    public void setAgmtScgRtDivCd(String agmtScgRtDivCd) {
        this.agmtScgRtDivCd = agmtScgRtDivCd;
    }
    
    /**
     * Column Info
     * @param eqSf2
     */
    public void setEqSf2(String eqSf2) {
        this.eqSf2 = eqSf2;
    }
    
    /**
     * Column Info
     * @param eqD3
     */
    public void setEqD3(String eqD3) {
        this.eqD3 = eqD3;
    }
    
    /**
     * Column Info
     * @param trspAgmtEqTpCd
     */
    public void setTrspAgmtEqTpCd(String trspAgmtEqTpCd) {
        this.trspAgmtEqTpCd = trspAgmtEqTpCd;
    }
    
    /**
     * Column Info
     * @param eqTa2
     */
    public void setEqTa2(String eqTa2) {
        this.eqTa2 = eqTa2;
    }
    
    /**
     * Column Info
     * @param eqD9
     */
    public void setEqD9(String eqD9) {
        this.eqD9 = eqD9;
    }
    
    /**
     * Column Info
     * @param eqD8
     */
    public void setEqD8(String eqD8) {
        this.eqD8 = eqD8;
    }
    
    /**
     * Column Info
     * @param chkRowno
     */
    public void setChkRowno(String chkRowno) {
        this.chkRowno = chkRowno;
    }
    
    /**
     * Column Info
     * @param eqKndCd
     */
    public void setEqKndCd(String eqKndCd) {
        this.eqKndCd = eqKndCd;
    }
    
    /**
     * Column Info
     * @param fmNodCd
     */
    public void setFmNodCd(String fmNodCd) {
        this.fmNodCd = fmNodCd;
    }
    
    /**
     * Column Info
     * @param eqUg
     */
    public void setEqUg(String eqUg) {
        this.eqUg = eqUg;
    }
    
    /**
     * Column Info
     * @param eqCg
     */
    public void setEqCg(String eqCg) {
        this.eqCg = eqCg;
    }
    
    /**
     * Column Info
     * @param viaNodCd
     */
    public void setViaNodCd(String viaNodCd) {
        this.viaNodCd = viaNodCd;
    }
    
    /**
     * Column Info
     * @param agmtTrspTpCd
     */
    public void setAgmtTrspTpCd(String agmtTrspTpCd) {
        this.agmtTrspTpCd = agmtTrspTpCd;
    }
    
    /**
     * Column Info
     * @param trspAgmtBdlQty
     */
    public void setTrspAgmtBdlQty(String trspAgmtBdlQty) {
        this.trspAgmtBdlQty = trspAgmtBdlQty;
    }
    
    /**
     * Column Info
     * @param viaNodYd
     */
    public void setViaNodYd(String viaNodYd) {
        this.viaNodYd = viaNodYd;
    }
    
    /**
     * Column Info
     * @param toNodCd
     */
    public void setToNodCd(String toNodCd) {
        this.toNodCd = toNodCd;
    }
    
    /**
     * Column Info
     * @param rlt
     */
    public void setRlt(String rlt) {
        this.rlt = rlt;
    }
    
    /**
     * Column Info
     * @param orgTrspAgmtEqTpCd
     */
    public void setOrgTrspAgmtEqTpCd(String orgTrspAgmtEqTpCd) {
        this.orgTrspAgmtEqTpCd = orgTrspAgmtEqTpCd;
    }
    
    /**
     * Column Info
     * @param rowno
     */
    public void setRowno(String rowno) {
        this.rowno = rowno;
    }
    
    /**
     * Column Info
     * @param eqR7
     */
    public void setEqR7(String eqR7) {
        this.eqR7 = eqR7;
    }
    
    /**
     * Column Info
     * @param eqSfal
     */
    public void setEqSfal(String eqSfal) {
        this.eqSfal = eqSfal;
    }
    
    /**
     * Column Info
     * @param trspAgmtRtTpCd
     */
    public void setTrspAgmtRtTpCd(String trspAgmtRtTpCd) {
        this.trspAgmtRtTpCd = trspAgmtRtTpCd;
    }
    
    /**
     * Column Info
     * @param trspAgmtEqSzCd
     */
    public void setTrspAgmtEqSzCd(String trspAgmtEqSzCd) {
        this.trspAgmtEqSzCd = trspAgmtEqSzCd;
    }
    
    /**
     * Column Info
     * @param eqCb4
     */
    public void setEqCb4(String eqCb4) {
        this.eqCb4 = eqCb4;
    }
    
    /**
     * Column Info
     * @param eqR4
     */
    public void setEqR4(String eqR4) {
        this.eqR4 = eqR4;
    }
    
    /**
     * Column Info
     * @param eqR5
     */
    public void setEqR5(String eqR5) {
        this.eqR5 = eqR5;
    }
    
    /**
     * Column Info
     * @param eqR2
     */
    public void setEqR2(String eqR2) {
        this.eqR2 = eqR2;
    }
    
    /**
     * Column Info
     * @param orgEqtype
     */
    public void setOrgEqtype(String orgEqtype) {
        this.orgEqtype = orgEqtype;
    }
    
    /**
     * Column Info
     * @param eqGnal
     */
    public void setEqGnal(String eqGnal) {
        this.eqGnal = eqGnal;
    }
    
    /**
     * Column Info
     * @param trspAgmtDist
     */
    public void setTrspAgmtDist(String trspAgmtDist) {
        this.trspAgmtDist = trspAgmtDist;
    }
    
    /**
     * Column Info
     * @param eqOal
     */
    public void setEqOal(String eqOal) {
        this.eqOal = eqOal;
    }
    
    /**
     * Column Info
     * @param distMeasUtCd
     */
    public void setDistMeasUtCd(String distMeasUtCd) {
        this.distMeasUtCd = distMeasUtCd;
    }
    
    /**
     * Column Info
     * @param eqZt4
     */
    public void setEqZt4(String eqZt4) {
        this.eqZt4 = eqZt4;
    }
    
    /**
     * Column Info
     * @param eqS2
     */
    public void setEqS2(String eqS2) {
        this.eqS2 = eqS2;
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
     * @param eqS4
     */
    public void setEqS4(String eqS4) {
        this.eqS4 = eqS4;
    }
    
    /**
     * Column Info
     * @param eqSlal
     */
    public void setEqSlal(String eqSlal) {
        this.eqSlal = eqSlal;
    }
    
    /**
     * Column Info
     * @param trspAgmtSeq
     */
    public void setTrspAgmtSeq(String trspAgmtSeq) {
        this.trspAgmtSeq = trspAgmtSeq;
    }
    
    /**
     * Column Info
     * @param wgtMeasUtCd
     */
    public void setWgtMeasUtCd(String wgtMeasUtCd) {
        this.wgtMeasUtCd = wgtMeasUtCd;
    }
    
    /**
     * Column Info
     * @param effToDt
     */
    public void setEffToDt(String effToDt) {
        this.effToDt = effToDt;
    }
    
    /**
     * Column Info
     * @param eqEg5
     */
    public void setEqEg5(String eqEg5) {
        this.eqEg5 = eqEg5;
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
     * @param eqA2
     */
    public void setEqA2(String eqA2) {
        this.eqA2 = eqA2;
    }
    
    /**
     * Column Info
     * @param agmtRoutAllFlg
     */
    public void setAgmtRoutAllFlg(String agmtRoutAllFlg) {
        this.agmtRoutAllFlg = agmtRoutAllFlg;
    }
    
    /**
     * Column Info
     * @param eqA4
     */
    public void setEqA4(String eqA4) {
        this.eqA4 = eqA4;
    }
    
    /**
     * Column Info
     * @param trspAgmtOfcCtyCd
     */
    public void setTrspAgmtOfcCtyCd(String trspAgmtOfcCtyCd) {
        this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
    }
    
    /**
     * Column Info
     * @param eqEg8
     */
    public void setEqEg8(String eqEg8) {
        this.eqEg8 = eqEg8;
    }
    
    /**
     * Column Info
     * @param eqTaal
     */
    public void setEqTaal(String eqTaal) {
        this.eqTaal = eqTaal;
    }
    
    /**
     * Column Info
     * @param eqP4
     */
    public void setEqP4(String eqP4) {
        this.eqP4 = eqP4;
    }
    
    /**
     * Column Info
     * @param eqP2
     */
    public void setEqP2(String eqP2) {
        this.eqP2 = eqP2;
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
     * @param wtrRcvTermCd
     */
    public void setWtrRcvTermCd(String wtrRcvTermCd) {
        this.wtrRcvTermCd = wtrRcvTermCd;
    }
    
    /**
     * Column Info
     * @param trspRvsAplyFlg
     */
    public void setTrspRvsAplyFlg(String trspRvsAplyFlg) {
        this.trspRvsAplyFlg = trspRvsAplyFlg;
    }
    
    /**
     * Column Info
     * @param eqFal
     */
    public void setEqFal(String eqFal) {
        this.eqFal = eqFal;
    }
    
    /**
     * Column Info
     * @param trspCostModCd
     */
    public void setTrspCostModCd(String trspCostModCd) {
        this.trspCostModCd = trspCostModCd;
    }
    
    /**
     * Column Info
     * @param fmNodYd
     */
    public void setFmNodYd(String fmNodYd) {
        this.fmNodYd = fmNodYd;
    }
    
    /**
     * Column Info
     * @param eqEgal
     */
    public void setEqEgal(String eqEgal) {
        this.eqEgal = eqEgal;
    }
    
    /**
     * Column Info
     * @param eqSl2
     */
    public void setEqSl2(String eqSl2) {
        this.eqSl2 = eqSl2;
    }
    
    /**
     * Column Info
     * @param uiSeqno
     */
    public void setUiSeqno(String uiSeqno) {
        this.uiSeqno = uiSeqno;
    }
    
    /**
     * Column Info
     * @param dorNodYd
     */
    public void setDorNodYd(String dorNodYd) {
        this.dorNodYd = dorNodYd;
    }
    
    /**
     * Column Info
     * @param eqDal
     */
    public void setEqDal(String eqDal) {
        this.eqDal = eqDal;
    }
    
    /**
     * Column Info
     * @param trspDistTpCd
     */
    public void setTrspDistTpCd(String trspDistTpCd) {
        this.trspDistTpCd = trspDistTpCd;
    }
    
    /**
     * Column Info
     * @return comScgAplyFlg
     */
    public void setComScgAplyFlg(String comScgAplyFlg) {
        this.comScgAplyFlg = comScgAplyFlg;
    }

    /**
     * Column Info
     * @return woAplyFlg
     */
    public void setWoAplyFlg(String woAplyFlg) {
        this.woAplyFlg = woAplyFlg;
    }

    /**
     * Column Info
     * @return trspAgmtRtTpSerNo
     */
    public void setTrspAgmtRtTpSerNo(String trspAgmtRtTpSerNo) {
    	this.trspAgmtRtTpSerNo = trspAgmtRtTpSerNo;
    }

    /**
     * Column Info
     * @return trspAgmtNodSeq
     */
    public void setTrspAgmtNodSeq(String trspAgmtNodSeq) {
    	this.trspAgmtNodSeq = trspAgmtNodSeq;
    }

    /**
     * Column Info
     * @return trspAgmtRtSeq
     */
    public void setTrspAgmtRtSeq(String trspAgmtRtSeq) {
    	this.trspAgmtRtSeq = trspAgmtRtSeq;
    }

    /**
     * Column Info
     * @return trspAgmtScgNodSeq
     */
    public void setTrspAgmtScgNodSeq(String trspAgmtScgNodSeq) {
    	this.trspAgmtScgNodSeq = trspAgmtScgNodSeq;
    }

    /**
     * Column Info
     * @return trspAgmtScgRtSeq
     */
    public void setTrspAgmtScgRtSeq(String trspAgmtScgRtSeq) {
    	this.trspAgmtScgRtSeq = trspAgmtScgRtSeq;
    }

    /**
     * Column Info
     * @return trspBndCd
     */
	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}
	
	/**
     * Column Info
     * @return spclCgoCntrTpCd
     */
	public void setSpclCgoCntrTpCd(String spclCgoCntrTpCd) {
		this.spclCgoCntrTpCd = spclCgoCntrTpCd;
	}

	public String getUsrDefRmk() {
		return usrDefRmk;
	}

	public void setUsrDefRmk(String usrDefRmk) {
		this.usrDefRmk = usrDefRmk;
	}

	public String getAftUsrDefRmk() {
		return aftUsrDefRmk;
	}

	public void setAftUsrDefRmk(String aftUsrDefRmk) {
		this.aftUsrDefRmk = aftUsrDefRmk;
	}

	public String getOrgRtSeq() {
		return orgRtSeq;
	}

	public void setOrgRtSeq(String orgRtSeq) {
		this.orgRtSeq = orgRtSeq;
	}

	
	/**
	 * Column Info
	 * @return eqD4RtSeq
	 */
	public String getEqD4RtSeq() {
		return this.eqD4RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqAalRtSeq
	 */
	public String getEqAalRtSeq() {
		return this.eqAalRtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqDalRtSeq
	 */
	public String getEqDalRtSeq() {
		return this.eqDalRtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqS2RtSeq
	 */
	public String getEqS2RtSeq() {
		return this.eqS2RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqD5RtSeq
	 */
	public String getEqD5RtSeq() {
		return this.eqD5RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqD9RtSeq
	 */
	public String getEqD9RtSeq() {
		return this.eqD9RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqR4RtSeq
	 */
	public String getEqR4RtSeq() {
		return this.eqR4RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqSlalRtSeq
	 */
	public String getEqSlalRtSeq() {
		return this.eqSlalRtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqAl5RtSeq
	 */
	public String getEqAl5RtSeq() {
		return this.eqAl5RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqEg8RtSeq
	 */
	public String getEqEg8RtSeq() {
		return this.eqEg8RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqSfalRtSeq
	 */
	public String getEqSfalRtSeq() {
		return this.eqSfalRtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqGnalRtSeq
	 */
	public String getEqGnalRtSeq() {
		return this.eqGnalRtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqF2RtSeq
	 */
	public String getEqF2RtSeq() {
		return this.eqF2RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqF5RtSeq
	 */
	public String getEqF5RtSeq() {
		return this.eqF5RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqOalRtSeq
	 */
	public String getEqOalRtSeq() {
		return this.eqOalRtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqT2RtSeq
	 */
	public String getEqT2RtSeq() {
		return this.eqT2RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqD8RtSeq
	 */
	public String getEqD8RtSeq() {
		return this.eqD8RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqSf4RtSeq
	 */
	public String getEqSf4RtSeq() {
		return this.eqSf4RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqO4RtSeq
	 */
	public String getEqO4RtSeq() {
		return this.eqO4RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqUgRtSeq
	 */
	public String getEqUgRtSeq() {
		return this.eqUgRtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqP2RtSeq
	 */
	public String getEqP2RtSeq() {
		return this.eqP2RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqD3RtSeq
	 */
	public String getEqD3RtSeq() {
		return this.eqD3RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqS4RtSeq
	 */
	public String getEqS4RtSeq() {
		return this.eqS4RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqDxRtSeq
	 */
	public String getEqDxRtSeq() {
		return this.eqDxRtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqSalRtSeq
	 */
	public String getEqSalRtSeq() {
		return this.eqSalRtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqAlalRtSeq
	 */
	public String getEqAlalRtSeq() {
		return this.eqAlalRtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqP4RtSeq
	 */
	public String getEqP4RtSeq() {
		return this.eqP4RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqAl9RtSeq
	 */
	public String getEqAl9RtSeq() {
		return this.eqAl9RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqGn5RtSeq
	 */
	public String getEqGn5RtSeq() {
		return this.eqGn5RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqDwRtSeq
	 */
	public String getEqDwRtSeq() {
		return this.eqDwRtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqF4RtSeq
	 */
	public String getEqF4RtSeq() {
		return this.eqF4RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqSl2RtSeq
	 */
	public String getEqSl2RtSeq() {
		return this.eqSl2RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqCgRtSeq
	 */
	public String getEqCgRtSeq() {
		return this.eqCgRtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqZt4RtSeq
	 */
	public String getEqZt4RtSeq() {
		return this.eqZt4RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqAl4RtSeq
	 */
	public String getEqAl4RtSeq() {
		return this.eqAl4RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqTaalRtSeq
	 */
	public String getEqTaalRtSeq() {
		return this.eqTaalRtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqEgalRtSeq
	 */
	public String getEqEgalRtSeq() {
		return this.eqEgalRtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqAl8RtSeq
	 */
	public String getEqAl8RtSeq() {
		return this.eqAl8RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqGn4RtSeq
	 */
	public String getEqGn4RtSeq() {
		return this.eqGn4RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqD2RtSeq
	 */
	public String getEqD2RtSeq() {
		return this.eqD2RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqR7RtSeq
	 */
	public String getEqR7RtSeq() {
		return this.eqR7RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqEg5RtSeq
	 */
	public String getEqEg5RtSeq() {
		return this.eqEg5RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqPalRtSeq
	 */
	public String getEqPalRtSeq() {
		return this.eqPalRtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqCb4RtSeq
	 */
	public String getEqCb4RtSeq() {
		return this.eqCb4RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqR5RtSeq
	 */
	public String getEqR5RtSeq() {
		return this.eqR5RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqAl2RtSeq
	 */
	public String getEqAl2RtSeq() {
		return this.eqAl2RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqA2RtSeq
	 */
	public String getEqA2RtSeq() {
		return this.eqA2RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqAl7RtSeq
	 */
	public String getEqAl7RtSeq() {
		return this.eqAl7RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqA4RtSeq
	 */
	public String getEqA4RtSeq() {
		return this.eqA4RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqO2RtSeq
	 */
	public String getEqO2RtSeq() {
		return this.eqO2RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqT4RtSeq
	 */
	public String getEqT4RtSeq() {
		return this.eqT4RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqTalRtSeq
	 */
	public String getEqTalRtSeq() {
		return this.eqTalRtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqFalRtSeq
	 */
	public String getEqFalRtSeq() {
		return this.eqFalRtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqRalRtSeq
	 */
	public String getEqRalRtSeq() {
		return this.eqRalRtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqSf2RtSeq
	 */
	public String getEqSf2RtSeq() {
		return this.eqSf2RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqTa2RtSeq
	 */
	public String getEqTa2RtSeq() {
		return this.eqTa2RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqD7RtSeq
	 */
	public String getEqD7RtSeq() {
		return this.eqD7RtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqR2RtSeq
	 */
	public String getEqR2RtSeq() {
		return this.eqR2RtSeq;
	}
	

	/**
	 * Column Info
	 * @param eqD4RtSeq
	 */
	public void setEqD4RtSeq(String eqD4RtSeq) {
		this.eqD4RtSeq = eqD4RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqAalRtSeq
	 */
	public void setEqAalRtSeq(String eqAalRtSeq) {
		this.eqAalRtSeq = eqAalRtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqDalRtSeq
	 */
	public void setEqDalRtSeq(String eqDalRtSeq) {
		this.eqDalRtSeq = eqDalRtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqS2RtSeq
	 */
	public void setEqS2RtSeq(String eqS2RtSeq) {
		this.eqS2RtSeq = eqS2RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqD5RtSeq
	 */
	public void setEqD5RtSeq(String eqD5RtSeq) {
		this.eqD5RtSeq = eqD5RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqD9RtSeq
	 */
	public void setEqD9RtSeq(String eqD9RtSeq) {
		this.eqD9RtSeq = eqD9RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqR4RtSeq
	 */
	public void setEqR4RtSeq(String eqR4RtSeq) {
		this.eqR4RtSeq = eqR4RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqSlalRtSeq
	 */
	public void setEqSlalRtSeq(String eqSlalRtSeq) {
		this.eqSlalRtSeq = eqSlalRtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqAl5RtSeq
	 */
	public void setEqAl5RtSeq(String eqAl5RtSeq) {
		this.eqAl5RtSeq = eqAl5RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqEg8RtSeq
	 */
	public void setEqEg8RtSeq(String eqEg8RtSeq) {
		this.eqEg8RtSeq = eqEg8RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqSfalRtSeq
	 */
	public void setEqSfalRtSeq(String eqSfalRtSeq) {
		this.eqSfalRtSeq = eqSfalRtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqGnalRtSeq
	 */
	public void setEqGnalRtSeq(String eqGnalRtSeq) {
		this.eqGnalRtSeq = eqGnalRtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqF2RtSeq
	 */
	public void setEqF2RtSeq(String eqF2RtSeq) {
		this.eqF2RtSeq = eqF2RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqF5RtSeq
	 */
	public void setEqF5RtSeq(String eqF5RtSeq) {
		this.eqF5RtSeq = eqF5RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqOalRtSeq
	 */
	public void setEqOalRtSeq(String eqOalRtSeq) {
		this.eqOalRtSeq = eqOalRtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqT2RtSeq
	 */
	public void setEqT2RtSeq(String eqT2RtSeq) {
		this.eqT2RtSeq = eqT2RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqD8RtSeq
	 */
	public void setEqD8RtSeq(String eqD8RtSeq) {
		this.eqD8RtSeq = eqD8RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqSf4RtSeq
	 */
	public void setEqSf4RtSeq(String eqSf4RtSeq) {
		this.eqSf4RtSeq = eqSf4RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqO4RtSeq
	 */
	public void setEqO4RtSeq(String eqO4RtSeq) {
		this.eqO4RtSeq = eqO4RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqUgRtSeq
	 */
	public void setEqUgRtSeq(String eqUgRtSeq) {
		this.eqUgRtSeq = eqUgRtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqP2RtSeq
	 */
	public void setEqP2RtSeq(String eqP2RtSeq) {
		this.eqP2RtSeq = eqP2RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqD3RtSeq
	 */
	public void setEqD3RtSeq(String eqD3RtSeq) {
		this.eqD3RtSeq = eqD3RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqS4RtSeq
	 */
	public void setEqS4RtSeq(String eqS4RtSeq) {
		this.eqS4RtSeq = eqS4RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqDxRtSeq
	 */
	public void setEqDxRtSeq(String eqDxRtSeq) {
		this.eqDxRtSeq = eqDxRtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqSalRtSeq
	 */
	public void setEqSalRtSeq(String eqSalRtSeq) {
		this.eqSalRtSeq = eqSalRtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqAlalRtSeq
	 */
	public void setEqAlalRtSeq(String eqAlalRtSeq) {
		this.eqAlalRtSeq = eqAlalRtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqP4RtSeq
	 */
	public void setEqP4RtSeq(String eqP4RtSeq) {
		this.eqP4RtSeq = eqP4RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqAl9RtSeq
	 */
	public void setEqAl9RtSeq(String eqAl9RtSeq) {
		this.eqAl9RtSeq = eqAl9RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqGn5RtSeq
	 */
	public void setEqGn5RtSeq(String eqGn5RtSeq) {
		this.eqGn5RtSeq = eqGn5RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqDwRtSeq
	 */
	public void setEqDwRtSeq(String eqDwRtSeq) {
		this.eqDwRtSeq = eqDwRtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqF4RtSeq
	 */
	public void setEqF4RtSeq(String eqF4RtSeq) {
		this.eqF4RtSeq = eqF4RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqSl2RtSeq
	 */
	public void setEqSl2RtSeq(String eqSl2RtSeq) {
		this.eqSl2RtSeq = eqSl2RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqCgRtSeq
	 */
	public void setEqCgRtSeq(String eqCgRtSeq) {
		this.eqCgRtSeq = eqCgRtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqZt4RtSeq
	 */
	public void setEqZt4RtSeq(String eqZt4RtSeq) {
		this.eqZt4RtSeq = eqZt4RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqAl4RtSeq
	 */
	public void setEqAl4RtSeq(String eqAl4RtSeq) {
		this.eqAl4RtSeq = eqAl4RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqTaalRtSeq
	 */
	public void setEqTaalRtSeq(String eqTaalRtSeq) {
		this.eqTaalRtSeq = eqTaalRtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqEgalRtSeq
	 */
	public void setEqEgalRtSeq(String eqEgalRtSeq) {
		this.eqEgalRtSeq = eqEgalRtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqAl8RtSeq
	 */
	public void setEqAl8RtSeq(String eqAl8RtSeq) {
		this.eqAl8RtSeq = eqAl8RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqGn4RtSeq
	 */
	public void setEqGn4RtSeq(String eqGn4RtSeq) {
		this.eqGn4RtSeq = eqGn4RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqD2RtSeq
	 */
	public void setEqD2RtSeq(String eqD2RtSeq) {
		this.eqD2RtSeq = eqD2RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqR7RtSeq
	 */
	public void setEqR7RtSeq(String eqR7RtSeq) {
		this.eqR7RtSeq = eqR7RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqEg5RtSeq
	 */
	public void setEqEg5RtSeq(String eqEg5RtSeq) {
		this.eqEg5RtSeq = eqEg5RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqPalRtSeq
	 */
	public void setEqPalRtSeq(String eqPalRtSeq) {
		this.eqPalRtSeq = eqPalRtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqCb4RtSeq
	 */
	public void setEqCb4RtSeq(String eqCb4RtSeq) {
		this.eqCb4RtSeq = eqCb4RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqR5RtSeq
	 */
	public void setEqR5RtSeq(String eqR5RtSeq) {
		this.eqR5RtSeq = eqR5RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqAl2RtSeq
	 */
	public void setEqAl2RtSeq(String eqAl2RtSeq) {
		this.eqAl2RtSeq = eqAl2RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqA2RtSeq
	 */
	public void setEqA2RtSeq(String eqA2RtSeq) {
		this.eqA2RtSeq = eqA2RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqAl7RtSeq
	 */
	public void setEqAl7RtSeq(String eqAl7RtSeq) {
		this.eqAl7RtSeq = eqAl7RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqA4RtSeq
	 */
	public void setEqA4RtSeq(String eqA4RtSeq) {
		this.eqA4RtSeq = eqA4RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqO2RtSeq
	 */
	public void setEqO2RtSeq(String eqO2RtSeq) {
		this.eqO2RtSeq = eqO2RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqT4RtSeq
	 */
	public void setEqT4RtSeq(String eqT4RtSeq) {
		this.eqT4RtSeq = eqT4RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqTalRtSeq
	 */
	public void setEqTalRtSeq(String eqTalRtSeq) {
		this.eqTalRtSeq = eqTalRtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqFalRtSeq
	 */
	public void setEqFalRtSeq(String eqFalRtSeq) {
		this.eqFalRtSeq = eqFalRtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqRalRtSeq
	 */
	public void setEqRalRtSeq(String eqRalRtSeq) {
		this.eqRalRtSeq = eqRalRtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqSf2RtSeq
	 */
	public void setEqSf2RtSeq(String eqSf2RtSeq) {
		this.eqSf2RtSeq = eqSf2RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqTa2RtSeq
	 */
	public void setEqTa2RtSeq(String eqTa2RtSeq) {
		this.eqTa2RtSeq = eqTa2RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqD7RtSeq
	 */
	public void setEqD7RtSeq(String eqD7RtSeq) {
		this.eqD7RtSeq = eqD7RtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqR2RtSeq
	 */
	public void setEqR2RtSeq(String eqR2RtSeq) {
		this.eqR2RtSeq = eqR2RtSeq;
	}

	public String getEqXxxx() {
		return eqXxxx;
	}

	public void setEqXxxx(String eqXxxx) {
		this.eqXxxx = eqXxxx;
	}

	public String getEqXxxxRtSeq() {
		return eqXxxxRtSeq;
	}

	public void setEqXxxxRtSeq(String eqXxxxRtSeq) {
		this.eqXxxxRtSeq = eqXxxxRtSeq;
	}

	public String getAgmtCostFlg() {
		return agmtCostFlg;
	}

	public void setAgmtCostFlg(String agmtCostFlg) {
		this.agmtCostFlg = agmtCostFlg;
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
        setToNodYd(JSPUtil.getParameter(request, prefix + "to_nod_yd", ""));
        setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
        setTrspRndRt(JSPUtil.getParameter(request, prefix + "trsp_rnd_rt", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setEqAal(JSPUtil.getParameter(request, prefix + "eq_aal", ""));
        setCkVf(JSPUtil.getParameter(request, prefix + "ck_vf", ""));
        setEqF2(JSPUtil.getParameter(request, prefix + "eq_f2", ""));
        setEqAl2(JSPUtil.getParameter(request, prefix + "eq_al2", ""));
        setEqF4(JSPUtil.getParameter(request, prefix + "eq_f4", ""));
        setEqF5(JSPUtil.getParameter(request, prefix + "eq_f5", ""));
        setEqAl5(JSPUtil.getParameter(request, prefix + "eq_al5", ""));
        setEqAl4(JSPUtil.getParameter(request, prefix + "eq_al4", ""));
        setEqDw(JSPUtil.getParameter(request, prefix + "eq_dw", ""));
        setTrspScgCd(JSPUtil.getParameter(request, prefix + "trsp_scg_cd", ""));
        setEqAl7(JSPUtil.getParameter(request, prefix + "eq_al7", ""));
        setEqO4(JSPUtil.getParameter(request, prefix + "eq_o4", ""));
        setEqAl8(JSPUtil.getParameter(request, prefix + "eq_al8", ""));
        setEqAl9(JSPUtil.getParameter(request, prefix + "eq_al9", ""));
        setEqT2(JSPUtil.getParameter(request, prefix + "eq_t2", ""));
        setEqDx(JSPUtil.getParameter(request, prefix + "eq_dx", ""));
        setEqT4(JSPUtil.getParameter(request, prefix + "eq_t4", ""));
        setTrspOneWyRt(JSPUtil.getParameter(request, prefix + "trsp_one_wy_rt", ""));
        setCmdtGrpCd(JSPUtil.getParameter(request, prefix + "cmdt_grp_cd", ""));
        setEqTal(JSPUtil.getParameter(request, prefix + "eq_tal", ""));
        setEqPal(JSPUtil.getParameter(request, prefix + "eq_pal", ""));
        setEqGn4(JSPUtil.getParameter(request, prefix + "eq_gn4", ""));
        setEqGn5(JSPUtil.getParameter(request, prefix + "eq_gn5", ""));
        setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
        setEqRal(JSPUtil.getParameter(request, prefix + "eq_ral", ""));
        setEqSal(JSPUtil.getParameter(request, prefix + "eq_sal", ""));
        setEqO2(JSPUtil.getParameter(request, prefix + "eq_o2", ""));
        setRailSvcTpCd(JSPUtil.getParameter(request, prefix + "rail_svc_tp_cd", ""));
        setOrgTrspAgmtEqSzCd(JSPUtil.getParameter(request, prefix + "org_trsp_agmt_eq_sz_cd", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setToWgt(JSPUtil.getParameter(request, prefix + "to_wgt", ""));
        setEqAlal(JSPUtil.getParameter(request, prefix + "eq_alal", ""));
        setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
        setEqD4(JSPUtil.getParameter(request, prefix + "eq_d4", ""));
        setEqD5(JSPUtil.getParameter(request, prefix + "eq_d5", ""));
        setEqSf4(JSPUtil.getParameter(request, prefix + "eq_sf4", ""));
        setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
        setWtrDeTermCd(JSPUtil.getParameter(request, prefix + "wtr_de_term_cd", ""));
        setEqD7(JSPUtil.getParameter(request, prefix + "eq_d7", ""));
        setEqD2(JSPUtil.getParameter(request, prefix + "eq_d2", ""));
        setAgmtScgRtDivCd(JSPUtil.getParameter(request, prefix + "agmt_scg_rt_div_cd", ""));
        setEqSf2(JSPUtil.getParameter(request, prefix + "eq_sf2", ""));
        setEqD3(JSPUtil.getParameter(request, prefix + "eq_d3", ""));
        setTrspAgmtEqTpCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_eq_tp_cd", ""));
        setEqTa2(JSPUtil.getParameter(request, prefix + "eq_ta2", ""));
        setEqD9(JSPUtil.getParameter(request, prefix + "eq_d9", ""));
        setEqD8(JSPUtil.getParameter(request, prefix + "eq_d8", ""));
        setChkRowno(JSPUtil.getParameter(request, prefix + "chk_rowno", ""));
        setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
        setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
        setEqUg(JSPUtil.getParameter(request, prefix + "eq_ug", ""));
        setEqCg(JSPUtil.getParameter(request, prefix + "eq_cg", ""));
        setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
        setAgmtTrspTpCd(JSPUtil.getParameter(request, prefix + "agmt_trsp_tp_cd", ""));
        setTrspAgmtBdlQty(JSPUtil.getParameter(request, prefix + "trsp_agmt_bdl_qty", ""));
        setViaNodYd(JSPUtil.getParameter(request, prefix + "via_nod_yd", ""));
        setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
        setRlt(JSPUtil.getParameter(request, prefix + "rlt", ""));
        setOrgTrspAgmtEqTpCd(JSPUtil.getParameter(request, prefix + "org_trsp_agmt_eq_tp_cd", ""));
        setRowno(JSPUtil.getParameter(request, prefix + "rowno", ""));
        setEqR7(JSPUtil.getParameter(request, prefix + "eq_r7", ""));
        setEqSfal(JSPUtil.getParameter(request, prefix + "eq_sfal", ""));
        setTrspAgmtRtTpCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_tp_cd", ""));
        setTrspAgmtEqSzCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_eq_sz_cd", ""));
        setEqCb4(JSPUtil.getParameter(request, prefix + "eq_cb4", ""));
        setEqR4(JSPUtil.getParameter(request, prefix + "eq_r4", ""));
        setEqR5(JSPUtil.getParameter(request, prefix + "eq_r5", ""));
        setEqR2(JSPUtil.getParameter(request, prefix + "eq_r2", ""));
        setOrgEqtype(JSPUtil.getParameter(request, prefix + "org_eqtype", ""));
        setEqGnal(JSPUtil.getParameter(request, prefix + "eq_gnal", ""));
        setTrspAgmtDist(JSPUtil.getParameter(request, prefix + "trsp_agmt_dist", ""));
        setEqOal(JSPUtil.getParameter(request, prefix + "eq_oal", ""));
        setDistMeasUtCd(JSPUtil.getParameter(request, prefix + "dist_meas_ut_cd", ""));
        setEqZt4(JSPUtil.getParameter(request, prefix + "eq_zt4", ""));
        setEqS2(JSPUtil.getParameter(request, prefix + "eq_s2", ""));
        setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
        setEqS4(JSPUtil.getParameter(request, prefix + "eq_s4", ""));
        setEqSlal(JSPUtil.getParameter(request, prefix + "eq_slal", ""));
        setTrspAgmtSeq(JSPUtil.getParameter(request, prefix + "trsp_agmt_seq", ""));
        setWgtMeasUtCd(JSPUtil.getParameter(request, prefix + "wgt_meas_ut_cd", ""));
        setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
        setEqEg5(JSPUtil.getParameter(request, prefix + "eq_eg5", ""));
        setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
        setEqA2(JSPUtil.getParameter(request, prefix + "eq_a2", ""));
        setAgmtRoutAllFlg(JSPUtil.getParameter(request, prefix + "agmt_rout_all_flg", ""));
        setEqA4(JSPUtil.getParameter(request, prefix + "eq_a4", ""));
        setTrspAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_ofc_cty_cd", ""));
        setEqEg8(JSPUtil.getParameter(request, prefix + "eq_eg8", ""));
        setEqTaal(JSPUtil.getParameter(request, prefix + "eq_taal", ""));
        setEqP4(JSPUtil.getParameter(request, prefix + "eq_p4", ""));
        setEqP2(JSPUtil.getParameter(request, prefix + "eq_p2", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setWtrRcvTermCd(JSPUtil.getParameter(request, prefix + "wtr_rcv_term_cd", ""));
        setTrspRvsAplyFlg(JSPUtil.getParameter(request, prefix + "trsp_rvs_aply_flg", ""));
        setEqFal(JSPUtil.getParameter(request, prefix + "eq_fal", ""));
        setTrspCostModCd(JSPUtil.getParameter(request, prefix + "trsp_cost_mod_cd", ""));
        setFmNodYd(JSPUtil.getParameter(request, prefix + "fm_nod_yd", ""));
        setEqEgal(JSPUtil.getParameter(request, prefix + "eq_egal", ""));
        setEqSl2(JSPUtil.getParameter(request, prefix + "eq_sl2", ""));
        setUiSeqno(JSPUtil.getParameter(request, prefix + "ui_seqno", ""));
        setDorNodYd(JSPUtil.getParameter(request, prefix + "dor_nod_yd", ""));
        setEqDal(JSPUtil.getParameter(request, prefix + "eq_dal", ""));
        setTrspDistTpCd(JSPUtil.getParameter(request, prefix + "trsp_dist_tp_cd", ""));
        setComScgAplyFlg(JSPUtil.getParameter(request, prefix + "com_scg_aply_flg", ""));
        setWoAplyFlg(JSPUtil.getParameter(request, prefix + "wo_aply_flg", ""));
        setTrspAgmtRtTpSerNo(JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_tp_ser_no", ""));
        setTrspAgmtNodSeq(JSPUtil.getParameter(request, prefix + "trsp_agmt_nod_seq", ""));
        setTrspAgmtRtSeq(JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_seq", ""));
        setTrspAgmtScgNodSeq(JSPUtil.getParameter(request, prefix + "trsp_agmt_scg_nod_seq", ""));
        setTrspAgmtScgRtSeq(JSPUtil.getParameter(request, prefix + "trsp_agmt_scg_rt_seq", ""));
        setTrspBndCd(JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", ""));
        setSpclCgoCntrTpCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cntr_tp_cd", ""));
        setUsrDefRmk(JSPUtil.getParameter(request, prefix + "org_usr_def_rmk", ""));
        setAftUsrDefRmk(JSPUtil.getParameter(request, prefix + "usr_def_rmk", ""));
        setOrgRtSeq(JSPUtil.getParameter(request, prefix + "org_rt_seq", ""));

		setEqD4RtSeq(JSPUtil.getParameter(request, prefix + "eq_d4_rt_seq", ""));
		setEqAalRtSeq(JSPUtil.getParameter(request, prefix + "eq_aal_rt_seq", ""));
		setEqDalRtSeq(JSPUtil.getParameter(request, prefix + "eq_dal_rt_seq", ""));
		setEqS2RtSeq(JSPUtil.getParameter(request, prefix + "eq_s2_rt_seq", ""));
		setEqD5RtSeq(JSPUtil.getParameter(request, prefix + "eq_d5_rt_seq", ""));
		setEqD9RtSeq(JSPUtil.getParameter(request, prefix + "eq_d9_rt_seq", ""));
		setEqR4RtSeq(JSPUtil.getParameter(request, prefix + "eq_r4_rt_seq", ""));
		setEqSlalRtSeq(JSPUtil.getParameter(request, prefix + "eq_slal_rt_seq", ""));
		setEqAl5RtSeq(JSPUtil.getParameter(request, prefix + "eq_al5_rt_seq", ""));
		setEqEg8RtSeq(JSPUtil.getParameter(request, prefix + "eq_eg8_rt_seq", ""));
		setEqSfalRtSeq(JSPUtil.getParameter(request, prefix + "eq_sfal_rt_seq", ""));
		setEqGnalRtSeq(JSPUtil.getParameter(request, prefix + "eq_gnal_rt_seq", ""));
		setEqF2RtSeq(JSPUtil.getParameter(request, prefix + "eq_f2_rt_seq", ""));
		setEqF5RtSeq(JSPUtil.getParameter(request, prefix + "eq_f5_rt_seq", ""));
		setEqOalRtSeq(JSPUtil.getParameter(request, prefix + "eq_oal_rt_seq", ""));
		setEqT2RtSeq(JSPUtil.getParameter(request, prefix + "eq_t2_rt_seq", ""));
		setEqD8RtSeq(JSPUtil.getParameter(request, prefix + "eq_d8_rt_seq", ""));
		setEqSf4RtSeq(JSPUtil.getParameter(request, prefix + "eq_sf4_rt_seq", ""));
		setEqO4RtSeq(JSPUtil.getParameter(request, prefix + "eq_o4_rt_seq", ""));
		setEqUgRtSeq(JSPUtil.getParameter(request, prefix + "eq_ug_rt_seq", ""));
		setEqP2RtSeq(JSPUtil.getParameter(request, prefix + "eq_p2_rt_seq", ""));
		setEqD3RtSeq(JSPUtil.getParameter(request, prefix + "eq_d3_rt_seq", ""));
		setEqS4RtSeq(JSPUtil.getParameter(request, prefix + "eq_s4_rt_seq", ""));
		setEqDxRtSeq(JSPUtil.getParameter(request, prefix + "eq_dx_rt_seq", ""));
		setEqSalRtSeq(JSPUtil.getParameter(request, prefix + "eq_sal_rt_seq", ""));
		setEqAlalRtSeq(JSPUtil.getParameter(request, prefix + "eq_alal_rt_seq", ""));
		setEqP4RtSeq(JSPUtil.getParameter(request, prefix + "eq_p4_rt_seq", ""));
		setEqAl9RtSeq(JSPUtil.getParameter(request, prefix + "eq_al9_rt_seq", ""));
		setEqGn5RtSeq(JSPUtil.getParameter(request, prefix + "eq_gn5_rt_seq", ""));
		setEqDwRtSeq(JSPUtil.getParameter(request, prefix + "eq_dw_rt_seq", ""));
		setEqF4RtSeq(JSPUtil.getParameter(request, prefix + "eq_f4_rt_seq", ""));
		setEqSl2RtSeq(JSPUtil.getParameter(request, prefix + "eq_sl2_rt_seq", ""));
		setEqCgRtSeq(JSPUtil.getParameter(request, prefix + "eq_cg_rt_seq", ""));
		setEqZt4RtSeq(JSPUtil.getParameter(request, prefix + "eq_zt4_rt_seq", ""));
		setEqAl4RtSeq(JSPUtil.getParameter(request, prefix + "eq_al4_rt_seq", ""));
		setEqTaalRtSeq(JSPUtil.getParameter(request, prefix + "eq_taal_rt_seq", ""));
		setEqEgalRtSeq(JSPUtil.getParameter(request, prefix + "eq_egal_rt_seq", ""));
		setEqAl8RtSeq(JSPUtil.getParameter(request, prefix + "eq_al8_rt_seq", ""));
		setEqGn4RtSeq(JSPUtil.getParameter(request, prefix + "eq_gn4_rt_seq", ""));
		setEqD2RtSeq(JSPUtil.getParameter(request, prefix + "eq_d2_rt_seq", ""));
		setEqR7RtSeq(JSPUtil.getParameter(request, prefix + "eq_r7_rt_seq", ""));
		setEqEg5RtSeq(JSPUtil.getParameter(request, prefix + "eq_eg5_rt_seq", ""));
		setEqPalRtSeq(JSPUtil.getParameter(request, prefix + "eq_pal_rt_seq", ""));
		setEqCb4RtSeq(JSPUtil.getParameter(request, prefix + "eq_cb4_rt_seq", ""));
		setEqR5RtSeq(JSPUtil.getParameter(request, prefix + "eq_r5_rt_seq", ""));
		setEqAl2RtSeq(JSPUtil.getParameter(request, prefix + "eq_al2_rt_seq", ""));
		setEqA2RtSeq(JSPUtil.getParameter(request, prefix + "eq_a2_rt_seq", ""));
		setEqAl7RtSeq(JSPUtil.getParameter(request, prefix + "eq_al7_rt_seq", ""));
		setEqA4RtSeq(JSPUtil.getParameter(request, prefix + "eq_a4_rt_seq", ""));
		setEqO2RtSeq(JSPUtil.getParameter(request, prefix + "eq_o2_rt_seq", ""));
		setEqT4RtSeq(JSPUtil.getParameter(request, prefix + "eq_t4_rt_seq", ""));
		setEqTalRtSeq(JSPUtil.getParameter(request, prefix + "eq_tal_rt_seq", ""));
		setEqFalRtSeq(JSPUtil.getParameter(request, prefix + "eq_fal_rt_seq", ""));
		setEqRalRtSeq(JSPUtil.getParameter(request, prefix + "eq_ral_rt_seq", ""));
		setEqSf2RtSeq(JSPUtil.getParameter(request, prefix + "eq_sf2_rt_seq", ""));
		setEqTa2RtSeq(JSPUtil.getParameter(request, prefix + "eq_ta2_rt_seq", ""));
		setEqD7RtSeq(JSPUtil.getParameter(request, prefix + "eq_d7_rt_seq", ""));
		setEqR2RtSeq(JSPUtil.getParameter(request, prefix + "eq_r2_rt_seq", ""));

		setEqXxxx(JSPUtil.getParameter(request, prefix + "eq_xxxx", ""));
		setEqXxxxRtSeq(JSPUtil.getParameter(request, prefix + "eq_xxxx_rt_seq", ""));
		setAgmtCostFlg(JSPUtil.getParameter(request, prefix + "agmt_cost_flg", ""));
    }

    /**
     * Request 의 데이터를 VO 배열로 변환하여 반환.
     * @param request
     * @return DummyAgmtRateVO[]
     */
    public DummyAgmtRateVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
     * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
     * @param request
     * @param prefix
     * @return DummyAgmtRateVO[]
     */
    public DummyAgmtRateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        DummyAgmtRateVO model = null;
        
        String[] tmp = request.getParameterValues(prefix + "ibflag");
          if(tmp == null)
               return null;

          int length = request.getParameterValues(prefix + "ibflag").length;
  
        try {
            String[] toNodYd = (JSPUtil.getParameter(request, prefix    + "to_nod_yd", length));
            String[] cgoTpCd = (JSPUtil.getParameter(request, prefix    + "cgo_tp_cd", length));
            String[] trspRndRt = (JSPUtil.getParameter(request, prefix    + "trsp_rnd_rt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix    + "pagerows", length));
            String[] eqAal = (JSPUtil.getParameter(request, prefix    + "eq_aal", length));
            String[] ckVf = (JSPUtil.getParameter(request, prefix    + "ck_vf", length));
            String[] eqF2 = (JSPUtil.getParameter(request, prefix    + "eq_f2", length));
            String[] eqAl2 = (JSPUtil.getParameter(request, prefix    + "eq_al2", length));
            String[] eqF4 = (JSPUtil.getParameter(request, prefix    + "eq_f4", length));
            String[] eqF5 = (JSPUtil.getParameter(request, prefix    + "eq_f5", length));
            String[] eqAl5 = (JSPUtil.getParameter(request, prefix    + "eq_al5", length));
            String[] eqAl4 = (JSPUtil.getParameter(request, prefix    + "eq_al4", length));
            String[] eqDw = (JSPUtil.getParameter(request, prefix    + "eq_dw", length));
            String[] trspScgCd = (JSPUtil.getParameter(request, prefix    + "trsp_scg_cd", length));
            String[] eqAl7 = (JSPUtil.getParameter(request, prefix    + "eq_al7", length));
            String[] eqO4 = (JSPUtil.getParameter(request, prefix    + "eq_o4", length));
            String[] eqAl8 = (JSPUtil.getParameter(request, prefix    + "eq_al8", length));
            String[] eqAl9 = (JSPUtil.getParameter(request, prefix    + "eq_al9", length));
            String[] eqT2 = (JSPUtil.getParameter(request, prefix    + "eq_t2", length));
            String[] eqDx = (JSPUtil.getParameter(request, prefix    + "eq_dx", length));
            String[] eqT4 = (JSPUtil.getParameter(request, prefix    + "eq_t4", length));
            String[] trspOneWyRt = (JSPUtil.getParameter(request, prefix    + "trsp_one_wy_rt", length));
            String[] cmdtGrpCd = (JSPUtil.getParameter(request, prefix    + "cmdt_grp_cd", length));
            String[] eqTal = (JSPUtil.getParameter(request, prefix    + "eq_tal", length));
            String[] eqPal = (JSPUtil.getParameter(request, prefix    + "eq_pal", length));
            String[] eqGn4 = (JSPUtil.getParameter(request, prefix    + "eq_gn4", length));
            String[] eqGn5 = (JSPUtil.getParameter(request, prefix    + "eq_gn5", length));
            String[] custCd = (JSPUtil.getParameter(request, prefix    + "cust_cd", length));
            String[] eqRal = (JSPUtil.getParameter(request, prefix    + "eq_ral", length));
            String[] eqSal = (JSPUtil.getParameter(request, prefix    + "eq_sal", length));
            String[] eqO2 = (JSPUtil.getParameter(request, prefix    + "eq_o2", length));
            String[] railSvcTpCd = (JSPUtil.getParameter(request, prefix    + "rail_svc_tp_cd", length));
            String[] orgTrspAgmtEqSzCd = (JSPUtil.getParameter(request, prefix    + "org_trsp_agmt_eq_sz_cd", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix    + "delt_flg", length));
            String[] toWgt = (JSPUtil.getParameter(request, prefix    + "to_wgt", length));
            String[] eqAlal = (JSPUtil.getParameter(request, prefix    + "eq_alal", length));
            String[] dorNodCd = (JSPUtil.getParameter(request, prefix    + "dor_nod_cd", length));
            String[] eqD4 = (JSPUtil.getParameter(request, prefix    + "eq_d4", length));
            String[] eqD5 = (JSPUtil.getParameter(request, prefix    + "eq_d5", length));
            String[] eqSf4 = (JSPUtil.getParameter(request, prefix    + "eq_sf4", length));
            String[] effFmDt = (JSPUtil.getParameter(request, prefix    + "eff_fm_dt", length));
            String[] wtrDeTermCd = (JSPUtil.getParameter(request, prefix    + "wtr_de_term_cd", length));
            String[] eqD7 = (JSPUtil.getParameter(request, prefix    + "eq_d7", length));
            String[] eqD2 = (JSPUtil.getParameter(request, prefix    + "eq_d2", length));
            String[] agmtScgRtDivCd = (JSPUtil.getParameter(request, prefix    + "agmt_scg_rt_div_cd", length));
            String[] eqSf2 = (JSPUtil.getParameter(request, prefix    + "eq_sf2", length));
            String[] eqD3 = (JSPUtil.getParameter(request, prefix    + "eq_d3", length));
            String[] trspAgmtEqTpCd = (JSPUtil.getParameter(request, prefix    + "trsp_agmt_eq_tp_cd", length));
            String[] eqTa2 = (JSPUtil.getParameter(request, prefix    + "eq_ta2", length));
            String[] eqD9 = (JSPUtil.getParameter(request, prefix    + "eq_d9", length));
            String[] eqD8 = (JSPUtil.getParameter(request, prefix    + "eq_d8", length));
            String[] chkRowno = (JSPUtil.getParameter(request, prefix    + "chk_rowno", length));
            String[] eqKndCd = (JSPUtil.getParameter(request, prefix    + "eq_knd_cd", length));
            String[] fmNodCd = (JSPUtil.getParameter(request, prefix    + "fm_nod_cd", length));
            String[] eqUg = (JSPUtil.getParameter(request, prefix    + "eq_ug", length));
            String[] eqCg = (JSPUtil.getParameter(request, prefix    + "eq_cg", length));
            String[] viaNodCd = (JSPUtil.getParameter(request, prefix    + "via_nod_cd", length));
            String[] agmtTrspTpCd = (JSPUtil.getParameter(request, prefix    + "agmt_trsp_tp_cd", length));
            String[] trspAgmtBdlQty = (JSPUtil.getParameter(request, prefix    + "trsp_agmt_bdl_qty", length));
            String[] viaNodYd = (JSPUtil.getParameter(request, prefix    + "via_nod_yd", length));
            String[] toNodCd = (JSPUtil.getParameter(request, prefix    + "to_nod_cd", length));
            String[] rlt = (JSPUtil.getParameter(request, prefix    + "rlt", length));
            String[] orgTrspAgmtEqTpCd = (JSPUtil.getParameter(request, prefix    + "org_trsp_agmt_eq_tp_cd", length));
            String[] rowno = (JSPUtil.getParameter(request, prefix    + "rowno", length));
            String[] eqR7 = (JSPUtil.getParameter(request, prefix    + "eq_r7", length));
            String[] eqSfal = (JSPUtil.getParameter(request, prefix    + "eq_sfal", length));
            String[] trspAgmtRtTpCd = (JSPUtil.getParameter(request, prefix    + "trsp_agmt_rt_tp_cd", length));
            String[] trspAgmtEqSzCd = (JSPUtil.getParameter(request, prefix    + "trsp_agmt_eq_sz_cd", length));
            String[] eqCb4 = (JSPUtil.getParameter(request, prefix    + "eq_cb4", length));
            String[] eqR4 = (JSPUtil.getParameter(request, prefix    + "eq_r4", length));
            String[] eqR5 = (JSPUtil.getParameter(request, prefix    + "eq_r5", length));
            String[] eqR2 = (JSPUtil.getParameter(request, prefix    + "eq_r2", length));
            String[] orgEqtype = (JSPUtil.getParameter(request, prefix    + "org_eqtype", length));
            String[] eqGnal = (JSPUtil.getParameter(request, prefix    + "eq_gnal", length));
            String[] trspAgmtDist = (JSPUtil.getParameter(request, prefix    + "trsp_agmt_dist", length));
            String[] eqOal = (JSPUtil.getParameter(request, prefix    + "eq_oal", length));
            String[] distMeasUtCd = (JSPUtil.getParameter(request, prefix    + "dist_meas_ut_cd", length));
            String[] eqZt4 = (JSPUtil.getParameter(request, prefix    + "eq_zt4", length));
            String[] eqS2 = (JSPUtil.getParameter(request, prefix    + "eq_s2", length));
            String[] chk = (JSPUtil.getParameter(request, prefix    + "chk", length));
            String[] eqS4 = (JSPUtil.getParameter(request, prefix    + "eq_s4", length));
            String[] eqSlal = (JSPUtil.getParameter(request, prefix    + "eq_slal", length));
            String[] trspAgmtSeq = (JSPUtil.getParameter(request, prefix    + "trsp_agmt_seq", length));
            String[] wgtMeasUtCd = (JSPUtil.getParameter(request, prefix    + "wgt_meas_ut_cd", length));
            String[] effToDt = (JSPUtil.getParameter(request, prefix    + "eff_to_dt", length));
            String[] eqEg5 = (JSPUtil.getParameter(request, prefix    + "eq_eg5", length));
            String[] currCd = (JSPUtil.getParameter(request, prefix    + "curr_cd", length));
            String[] eqA2 = (JSPUtil.getParameter(request, prefix    + "eq_a2", length));
            String[] agmtRoutAllFlg = (JSPUtil.getParameter(request, prefix    + "agmt_rout_all_flg", length));
            String[] eqA4 = (JSPUtil.getParameter(request, prefix    + "eq_a4", length));
            String[] trspAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix    + "trsp_agmt_ofc_cty_cd", length));
            String[] eqEg8 = (JSPUtil.getParameter(request, prefix    + "eq_eg8", length));
            String[] eqTaal = (JSPUtil.getParameter(request, prefix    + "eq_taal", length));
            String[] eqP4 = (JSPUtil.getParameter(request, prefix    + "eq_p4", length));
            String[] eqP2 = (JSPUtil.getParameter(request, prefix    + "eq_p2", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix    + "ibflag", length));
            String[] wtrRcvTermCd = (JSPUtil.getParameter(request, prefix    + "wtr_rcv_term_cd", length));
            String[] trspRvsAplyFlg = (JSPUtil.getParameter(request, prefix    + "trsp_rvs_aply_flg", length));
            String[] eqFal = (JSPUtil.getParameter(request, prefix    + "eq_fal", length));
            String[] trspCostModCd = (JSPUtil.getParameter(request, prefix    + "trsp_cost_mod_cd", length));
            String[] fmNodYd = (JSPUtil.getParameter(request, prefix    + "fm_nod_yd", length));
            String[] eqEgal = (JSPUtil.getParameter(request, prefix    + "eq_egal", length));
            String[] eqSl2 = (JSPUtil.getParameter(request, prefix    + "eq_sl2", length));
            String[] uiSeqno = (JSPUtil.getParameter(request, prefix    + "ui_seqno", length));
            String[] dorNodYd = (JSPUtil.getParameter(request, prefix    + "dor_nod_yd", length));
            String[] eqDal = (JSPUtil.getParameter(request, prefix    + "eq_dal", length));
            String[] trspDistTpCd = (JSPUtil.getParameter(request, prefix    + "trsp_dist_tp_cd", length));
            String[] comScgAplyFlg = (JSPUtil.getParameter(request, prefix    + "com_scg_aply_flg", length));
            String[] woAplyFlg = (JSPUtil.getParameter(request, prefix    + "wo_aply_flg", length));
            String[] trspAgmtRtTpSerNo = (JSPUtil.getParameter(request, prefix    + "trsp_agmt_rt_tp_ser_no", length));
            String[] trspAgmtNodSeq = (JSPUtil.getParameter(request, prefix    + "trsp_agmt_nod_seq", length));
            String[] trspAgmtRtSeq = (JSPUtil.getParameter(request, prefix    + "trsp_agmt_rt_seq", length));
            String[] trspAgmtScgNodSeq = (JSPUtil.getParameter(request, prefix    + "trsp_agmt_scg_nod_seq", length));
            String[] trspAgmtScgRtSeq = (JSPUtil.getParameter(request, prefix    + "trsp_agmt_scg_rt_seq", length));
            String[] trspBndCd = (JSPUtil.getParameter(request, prefix    + "trsp_bnd_cd", length));
            String[] spclCgoCntrTpCd = (JSPUtil.getParameter(request, prefix    + "spcl_cgo_cntr_tp_cd", length));
            String[] usrDefRmk = (JSPUtil.getParameter(request, prefix    + "org_usr_def_rmk", length));
            String[] aftUsrDefRmk = (JSPUtil.getParameter(request, prefix    + "usr_def_rmk", length));
            String[] orgRtSeq = (JSPUtil.getParameter(request, prefix    + "org_rt_seq", length));

			String[] eqD4RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_d4_rt_seq", length));
			String[] eqAalRtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_aal_rt_seq", length));
			String[] eqDalRtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_dal_rt_seq", length));
			String[] eqS2RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_s2_rt_seq", length));
			String[] eqD5RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_d5_rt_seq", length));
			String[] eqD9RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_d9_rt_seq", length));
			String[] eqR4RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_r4_rt_seq", length));
			String[] eqSlalRtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_slal_rt_seq", length));
			String[] eqAl5RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_al5_rt_seq", length));
			String[] eqEg8RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_eg8_rt_seq", length));
			String[] eqSfalRtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_sfal_rt_seq", length));
			String[] eqGnalRtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_gnal_rt_seq", length));
			String[] eqF2RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_f2_rt_seq", length));
			String[] eqF5RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_f5_rt_seq", length));
			String[] eqOalRtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_oal_rt_seq", length));
			String[] eqT2RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_t2_rt_seq", length));
			String[] eqD8RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_d8_rt_seq", length));
			String[] eqSf4RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_sf4_rt_seq", length));
			String[] eqO4RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_o4_rt_seq", length));
			String[] eqUgRtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_ug_rt_seq", length));
			String[] eqP2RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_p2_rt_seq", length));
			String[] eqD3RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_d3_rt_seq", length));
			String[] eqS4RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_s4_rt_seq", length));
			String[] eqDxRtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_dx_rt_seq", length));
			String[] eqSalRtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_sal_rt_seq", length));
			String[] eqAlalRtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_alal_rt_seq", length));
			String[] eqP4RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_p4_rt_seq", length));
			String[] eqAl9RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_al9_rt_seq", length));
			String[] eqGn5RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_gn5_rt_seq", length));
			String[] eqDwRtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_dw_rt_seq", length));
			String[] eqF4RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_f4_rt_seq", length));
			String[] eqSl2RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_sl2_rt_seq", length));
			String[] eqCgRtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_cg_rt_seq", length));
			String[] eqZt4RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_zt4_rt_seq", length));
			String[] eqAl4RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_al4_rt_seq", length));
			String[] eqTaalRtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_taal_rt_seq", length));
			String[] eqEgalRtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_egal_rt_seq", length));
			String[] eqAl8RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_al8_rt_seq", length));
			String[] eqGn4RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_gn4_rt_seq", length));
			String[] eqD2RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_d2_rt_seq", length));
			String[] eqR7RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_r7_rt_seq", length));
			String[] eqEg5RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_eg5_rt_seq", length));
			String[] eqPalRtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_pal_rt_seq", length));
			String[] eqCb4RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_cb4_rt_seq", length));
			String[] eqR5RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_r5_rt_seq", length));
			String[] eqAl2RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_al2_rt_seq", length));
			String[] eqA2RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_a2_rt_seq", length));
			String[] eqAl7RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_al7_rt_seq", length));
			String[] eqA4RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_a4_rt_seq", length));
			String[] eqO2RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_o2_rt_seq", length));
			String[] eqT4RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_t4_rt_seq", length));
			String[] eqTalRtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_tal_rt_seq", length));
			String[] eqFalRtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_fal_rt_seq", length));
			String[] eqRalRtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_ral_rt_seq", length));
			String[] eqSf2RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_sf2_rt_seq", length));
			String[] eqTa2RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_ta2_rt_seq", length));
			String[] eqD7RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_d7_rt_seq", length));
			String[] eqR2RtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_r2_rt_seq", length));

			String[] eqXxxx = (JSPUtil.getParameter(request, prefix	+ "eq_xxxx", length));
			String[] eqXxxxRtSeq = (JSPUtil.getParameter(request, prefix	+ "eq_xxxx_rt_seq", length));
			String[] agmtCostFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_cost_flg", length));
            
            for (int i = 0; i < length; i++) {
                model = new DummyAgmtRateVO();
                if (toNodYd[i] != null)
                    model.setToNodYd(toNodYd[i]);
                if (cgoTpCd[i] != null)
                    model.setCgoTpCd(cgoTpCd[i]);
                if (trspRndRt[i] != null)
                    model.setTrspRndRt(trspRndRt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (eqAal[i] != null)
                    model.setEqAal(eqAal[i]);
                if (ckVf[i] != null)
                    model.setCkVf(ckVf[i]);
                if (eqF2[i] != null)
                    model.setEqF2(eqF2[i]);
                if (eqAl2[i] != null)
                    model.setEqAl2(eqAl2[i]);
                if (eqF4[i] != null)
                    model.setEqF4(eqF4[i]);
                if (eqF5[i] != null)
                    model.setEqF5(eqF5[i]);
                if (eqAl5[i] != null)
                    model.setEqAl5(eqAl5[i]);
                if (eqAl4[i] != null)
                    model.setEqAl4(eqAl4[i]);
                if (eqDw[i] != null)
                    model.setEqDw(eqDw[i]);
                if (trspScgCd[i] != null)
                    model.setTrspScgCd(trspScgCd[i]);
                if (eqAl7[i] != null)
                    model.setEqAl7(eqAl7[i]);
                if (eqO4[i] != null)
                    model.setEqO4(eqO4[i]);
                if (eqAl8[i] != null)
                    model.setEqAl8(eqAl8[i]);
                if (eqAl9[i] != null)
                    model.setEqAl9(eqAl9[i]);
                if (eqT2[i] != null)
                    model.setEqT2(eqT2[i]);
                if (eqDx[i] != null)
                    model.setEqDx(eqDx[i]);
                if (eqT4[i] != null)
                    model.setEqT4(eqT4[i]);
                if (trspOneWyRt[i] != null)
                    model.setTrspOneWyRt(trspOneWyRt[i]);
                if (cmdtGrpCd[i] != null)
                    model.setCmdtGrpCd(cmdtGrpCd[i]);
                if (eqTal[i] != null)
                    model.setEqTal(eqTal[i]);
                if (eqPal[i] != null)
                    model.setEqPal(eqPal[i]);
                if (eqGn4[i] != null)
                    model.setEqGn4(eqGn4[i]);
                if (eqGn5[i] != null)
                    model.setEqGn5(eqGn5[i]);
                if (custCd[i] != null)
                    model.setCustCd(custCd[i]);
                if (eqRal[i] != null)
                    model.setEqRal(eqRal[i]);
                if (eqSal[i] != null)
                    model.setEqSal(eqSal[i]);
                if (eqO2[i] != null)
                    model.setEqO2(eqO2[i]);
                if (railSvcTpCd[i] != null)
                    model.setRailSvcTpCd(railSvcTpCd[i]);
                if (orgTrspAgmtEqSzCd[i] != null)
                    model.setOrgTrspAgmtEqSzCd(orgTrspAgmtEqSzCd[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (toWgt[i] != null)
                    model.setToWgt(toWgt[i]);
                if (eqAlal[i] != null)
                    model.setEqAlal(eqAlal[i]);
                if (dorNodCd[i] != null)
                    model.setDorNodCd(dorNodCd[i]);
                if (eqD4[i] != null)
                    model.setEqD4(eqD4[i]);
                if (eqD5[i] != null)
                    model.setEqD5(eqD5[i]);
                if (eqSf4[i] != null)
                    model.setEqSf4(eqSf4[i]);
                if (effFmDt[i] != null)
                    model.setEffFmDt(effFmDt[i]);
                if (wtrDeTermCd[i] != null)
                    model.setWtrDeTermCd(wtrDeTermCd[i]);
                if (eqD7[i] != null)
                    model.setEqD7(eqD7[i]);
                if (eqD2[i] != null)
                    model.setEqD2(eqD2[i]);
                if (agmtScgRtDivCd[i] != null)
                    model.setAgmtScgRtDivCd(agmtScgRtDivCd[i]);
                if (eqSf2[i] != null)
                    model.setEqSf2(eqSf2[i]);
                if (eqD3[i] != null)
                    model.setEqD3(eqD3[i]);
                if (trspAgmtEqTpCd[i] != null)
                    model.setTrspAgmtEqTpCd(trspAgmtEqTpCd[i]);
                if (eqTa2[i] != null)
                    model.setEqTa2(eqTa2[i]);
                if (eqD9[i] != null)
                    model.setEqD9(eqD9[i]);
                if (eqD8[i] != null)
                    model.setEqD8(eqD8[i]);
                if (chkRowno[i] != null)
                    model.setChkRowno(chkRowno[i]);
                if (eqKndCd[i] != null)
                    model.setEqKndCd(eqKndCd[i]);
                if (fmNodCd[i] != null)
                    model.setFmNodCd(fmNodCd[i]);
                if (eqUg[i] != null)
                    model.setEqUg(eqUg[i]);
                if (eqCg[i] != null)
                    model.setEqCg(eqCg[i]);
                if (viaNodCd[i] != null)
                    model.setViaNodCd(viaNodCd[i]);
                if (agmtTrspTpCd[i] != null)
                    model.setAgmtTrspTpCd(agmtTrspTpCd[i]);
                if (trspAgmtBdlQty[i] != null)
                    model.setTrspAgmtBdlQty(trspAgmtBdlQty[i]);
                if (viaNodYd[i] != null)
                    model.setViaNodYd(viaNodYd[i]);
                if (toNodCd[i] != null)
                    model.setToNodCd(toNodCd[i]);
                if (rlt[i] != null)
                    model.setRlt(rlt[i]);
                if (orgTrspAgmtEqTpCd[i] != null)
                    model.setOrgTrspAgmtEqTpCd(orgTrspAgmtEqTpCd[i]);
                if (rowno[i] != null)
                    model.setRowno(rowno[i]);
                if (eqR7[i] != null)
                    model.setEqR7(eqR7[i]);
                if (eqSfal[i] != null)
                    model.setEqSfal(eqSfal[i]);
                if (trspAgmtRtTpCd[i] != null)
                    model.setTrspAgmtRtTpCd(trspAgmtRtTpCd[i]);
                if (trspAgmtEqSzCd[i] != null)
                    model.setTrspAgmtEqSzCd(trspAgmtEqSzCd[i]);
                if (eqCb4[i] != null)
                    model.setEqCb4(eqCb4[i]);
                if (eqR4[i] != null)
                    model.setEqR4(eqR4[i]);
                if (eqR5[i] != null)
                    model.setEqR5(eqR5[i]);
                if (eqR2[i] != null)
                    model.setEqR2(eqR2[i]);
                if (orgEqtype[i] != null)
                    model.setOrgEqtype(orgEqtype[i]);
                if (eqGnal[i] != null)
                    model.setEqGnal(eqGnal[i]);
                if (trspAgmtDist[i] != null)
                    model.setTrspAgmtDist(trspAgmtDist[i]);
                if (eqOal[i] != null)
                    model.setEqOal(eqOal[i]);
                if (distMeasUtCd[i] != null)
                    model.setDistMeasUtCd(distMeasUtCd[i]);
                if (eqZt4[i] != null)
                    model.setEqZt4(eqZt4[i]);
                if (eqS2[i] != null)
                    model.setEqS2(eqS2[i]);
                if (chk[i] != null)
                    model.setChk(chk[i]);
                if (eqS4[i] != null)
                    model.setEqS4(eqS4[i]);
                if (eqSlal[i] != null)
                    model.setEqSlal(eqSlal[i]);
                if (trspAgmtSeq[i] != null)
                    model.setTrspAgmtSeq(trspAgmtSeq[i]);
                if (wgtMeasUtCd[i] != null)
                    model.setWgtMeasUtCd(wgtMeasUtCd[i]);
                if (effToDt[i] != null)
                    model.setEffToDt(effToDt[i]);
                if (eqEg5[i] != null)
                    model.setEqEg5(eqEg5[i]);
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (eqA2[i] != null)
                    model.setEqA2(eqA2[i]);
                if (agmtRoutAllFlg[i] != null)
                    model.setAgmtRoutAllFlg(agmtRoutAllFlg[i]);
                if (eqA4[i] != null)
                    model.setEqA4(eqA4[i]);
                if (trspAgmtOfcCtyCd[i] != null)
                    model.setTrspAgmtOfcCtyCd(trspAgmtOfcCtyCd[i]);
                if (eqEg8[i] != null)
                    model.setEqEg8(eqEg8[i]);
                if (eqTaal[i] != null)
                    model.setEqTaal(eqTaal[i]);
                if (eqP4[i] != null)
                    model.setEqP4(eqP4[i]);
                if (eqP2[i] != null)
                    model.setEqP2(eqP2[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (wtrRcvTermCd[i] != null)
                    model.setWtrRcvTermCd(wtrRcvTermCd[i]);
                if (trspRvsAplyFlg[i] != null)
                    model.setTrspRvsAplyFlg(trspRvsAplyFlg[i]);
                if (eqFal[i] != null)
                    model.setEqFal(eqFal[i]);
                if (trspCostModCd[i] != null)
                    model.setTrspCostModCd(trspCostModCd[i]);
                if (fmNodYd[i] != null)
                    model.setFmNodYd(fmNodYd[i]);
                if (eqEgal[i] != null)
                    model.setEqEgal(eqEgal[i]);
                if (eqSl2[i] != null)
                    model.setEqSl2(eqSl2[i]);
                if (uiSeqno[i] != null)
                    model.setUiSeqno(uiSeqno[i]);
                if (dorNodYd[i] != null)
                    model.setDorNodYd(dorNodYd[i]);
                if (eqDal[i] != null)
                    model.setEqDal(eqDal[i]);
                if (trspDistTpCd[i] != null)
                    model.setTrspDistTpCd(trspDistTpCd[i]);
                if (comScgAplyFlg[i] != null)
                    model.setComScgAplyFlg(comScgAplyFlg[i]);
                if (woAplyFlg[i] != null)
                    model.setWoAplyFlg(woAplyFlg[i]);
                if (trspAgmtRtTpSerNo[i] != null)
                    model.setTrspAgmtRtTpSerNo(trspAgmtRtTpSerNo[i]);
                if (trspAgmtNodSeq[i] != null)
                    model.setTrspAgmtNodSeq(trspAgmtNodSeq[i]);
                if (trspAgmtRtSeq[i] != null)
                    model.setTrspAgmtRtSeq(trspAgmtRtSeq[i]);
                if (trspAgmtScgNodSeq[i] != null)
                    model.setTrspAgmtScgNodSeq(trspAgmtScgNodSeq[i]);
                if (trspAgmtScgRtSeq[i] != null)
                    model.setTrspAgmtScgRtSeq(trspAgmtScgRtSeq[i]);
                if (trspBndCd[i] != null)
                    model.setTrspBndCd(trspBndCd[i]);
                if (spclCgoCntrTpCd[i] != null)
                    model.setSpclCgoCntrTpCd(spclCgoCntrTpCd[i]);
                if (usrDefRmk[i] != null)
                    model.setUsrDefRmk(usrDefRmk[i]);
                if (aftUsrDefRmk[i] != null)
                    model.setAftUsrDefRmk(aftUsrDefRmk[i]);
                if (orgRtSeq[i] != null)
                    model.setOrgRtSeq(orgRtSeq[i]);

				if (eqD4RtSeq[i] != null)
					model.setEqD4RtSeq(eqD4RtSeq[i]);
				if (eqAalRtSeq[i] != null)
					model.setEqAalRtSeq(eqAalRtSeq[i]);
				if (eqDalRtSeq[i] != null)
					model.setEqDalRtSeq(eqDalRtSeq[i]);
				if (eqS2RtSeq[i] != null)
					model.setEqS2RtSeq(eqS2RtSeq[i]);
				if (eqD5RtSeq[i] != null)
					model.setEqD5RtSeq(eqD5RtSeq[i]);
				if (eqD9RtSeq[i] != null)
					model.setEqD9RtSeq(eqD9RtSeq[i]);
				if (eqR4RtSeq[i] != null)
					model.setEqR4RtSeq(eqR4RtSeq[i]);
				if (eqSlalRtSeq[i] != null)
					model.setEqSlalRtSeq(eqSlalRtSeq[i]);
				if (eqAl5RtSeq[i] != null)
					model.setEqAl5RtSeq(eqAl5RtSeq[i]);
				if (eqEg8RtSeq[i] != null)
					model.setEqEg8RtSeq(eqEg8RtSeq[i]);
				if (eqSfalRtSeq[i] != null)
					model.setEqSfalRtSeq(eqSfalRtSeq[i]);
				if (eqGnalRtSeq[i] != null)
					model.setEqGnalRtSeq(eqGnalRtSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqF2RtSeq[i] != null)
					model.setEqF2RtSeq(eqF2RtSeq[i]);
				if (eqF5RtSeq[i] != null)
					model.setEqF5RtSeq(eqF5RtSeq[i]);
				if (eqOalRtSeq[i] != null)
					model.setEqOalRtSeq(eqOalRtSeq[i]);
				if (eqT2RtSeq[i] != null)
					model.setEqT2RtSeq(eqT2RtSeq[i]);
				if (eqD8RtSeq[i] != null)
					model.setEqD8RtSeq(eqD8RtSeq[i]);
				if (eqSf4RtSeq[i] != null)
					model.setEqSf4RtSeq(eqSf4RtSeq[i]);
				if (eqO4RtSeq[i] != null)
					model.setEqO4RtSeq(eqO4RtSeq[i]);
				if (eqUgRtSeq[i] != null)
					model.setEqUgRtSeq(eqUgRtSeq[i]);
				if (eqP2RtSeq[i] != null)
					model.setEqP2RtSeq(eqP2RtSeq[i]);
				if (eqD3RtSeq[i] != null)
					model.setEqD3RtSeq(eqD3RtSeq[i]);
				if (eqS4RtSeq[i] != null)
					model.setEqS4RtSeq(eqS4RtSeq[i]);
				if (eqDxRtSeq[i] != null)
					model.setEqDxRtSeq(eqDxRtSeq[i]);
				if (eqSalRtSeq[i] != null)
					model.setEqSalRtSeq(eqSalRtSeq[i]);
				if (eqAlalRtSeq[i] != null)
					model.setEqAlalRtSeq(eqAlalRtSeq[i]);
				if (eqP4RtSeq[i] != null)
					model.setEqP4RtSeq(eqP4RtSeq[i]);
				if (eqAl9RtSeq[i] != null)
					model.setEqAl9RtSeq(eqAl9RtSeq[i]);
				if (eqGn5RtSeq[i] != null)
					model.setEqGn5RtSeq(eqGn5RtSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqDwRtSeq[i] != null)
					model.setEqDwRtSeq(eqDwRtSeq[i]);
				if (eqF4RtSeq[i] != null)
					model.setEqF4RtSeq(eqF4RtSeq[i]);
				if (eqSl2RtSeq[i] != null)
					model.setEqSl2RtSeq(eqSl2RtSeq[i]);
				if (eqCgRtSeq[i] != null)
					model.setEqCgRtSeq(eqCgRtSeq[i]);
				if (eqZt4RtSeq[i] != null)
					model.setEqZt4RtSeq(eqZt4RtSeq[i]);
				if (eqAl4RtSeq[i] != null)
					model.setEqAl4RtSeq(eqAl4RtSeq[i]);
				if (eqTaalRtSeq[i] != null)
					model.setEqTaalRtSeq(eqTaalRtSeq[i]);
				if (eqEgalRtSeq[i] != null)
					model.setEqEgalRtSeq(eqEgalRtSeq[i]);
				if (eqAl8RtSeq[i] != null)
					model.setEqAl8RtSeq(eqAl8RtSeq[i]);
				if (eqGn4RtSeq[i] != null)
					model.setEqGn4RtSeq(eqGn4RtSeq[i]);
				if (eqD2RtSeq[i] != null)
					model.setEqD2RtSeq(eqD2RtSeq[i]);
				if (eqR7RtSeq[i] != null)
					model.setEqR7RtSeq(eqR7RtSeq[i]);
				if (eqEg5RtSeq[i] != null)
					model.setEqEg5RtSeq(eqEg5RtSeq[i]);
				if (eqPalRtSeq[i] != null)
					model.setEqPalRtSeq(eqPalRtSeq[i]);
				if (eqCb4RtSeq[i] != null)
					model.setEqCb4RtSeq(eqCb4RtSeq[i]);
				if (eqR5RtSeq[i] != null)
					model.setEqR5RtSeq(eqR5RtSeq[i]);
				if (eqAl2RtSeq[i] != null)
					model.setEqAl2RtSeq(eqAl2RtSeq[i]);
				if (eqA2RtSeq[i] != null)
					model.setEqA2RtSeq(eqA2RtSeq[i]);
				if (eqAl7RtSeq[i] != null)
					model.setEqAl7RtSeq(eqAl7RtSeq[i]);
				if (eqA4RtSeq[i] != null)
					model.setEqA4RtSeq(eqA4RtSeq[i]);
				if (eqO2RtSeq[i] != null)
					model.setEqO2RtSeq(eqO2RtSeq[i]);
				if (eqT4RtSeq[i] != null)
					model.setEqT4RtSeq(eqT4RtSeq[i]);
				if (eqTalRtSeq[i] != null)
					model.setEqTalRtSeq(eqTalRtSeq[i]);
				if (eqFalRtSeq[i] != null)
					model.setEqFalRtSeq(eqFalRtSeq[i]);
				if (eqRalRtSeq[i] != null)
					model.setEqRalRtSeq(eqRalRtSeq[i]);
				if (eqSf2RtSeq[i] != null)
					model.setEqSf2RtSeq(eqSf2RtSeq[i]);
				if (eqTa2RtSeq[i] != null)
					model.setEqTa2RtSeq(eqTa2RtSeq[i]);
				if (eqD7RtSeq[i] != null)
					model.setEqD7RtSeq(eqD7RtSeq[i]);
				if (eqR2RtSeq[i] != null)
					model.setEqR2RtSeq(eqR2RtSeq[i]);

				if (eqXxxx[i] != null)
					model.setEqXxxx(eqXxxx[i]);
				if (eqXxxxRtSeq[i] != null)
					model.setEqXxxxRtSeq(eqXxxxRtSeq[i]);
				if (agmtCostFlg[i] != null)
					model.setAgmtCostFlg(agmtCostFlg[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getDummyAgmtRateVOs();
    }

    /**
     * VO 배열을 반환
     * @return DummyAgmtRateVO[]
     */
    public DummyAgmtRateVO[] getDummyAgmtRateVOs(){
        DummyAgmtRateVO[] vos = (DummyAgmtRateVO[])models.toArray(new DummyAgmtRateVO[models.size()]);
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
        this.toNodYd = this.toNodYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspRndRt = this.trspRndRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqAal = this.eqAal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ckVf = this.ckVf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqF2 = this.eqF2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqAl2 = this.eqAl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqF4 = this.eqF4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqF5 = this.eqF5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqAl5 = this.eqAl5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqAl4 = this.eqAl4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqDw = this.eqDw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspScgCd = this.trspScgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqAl7 = this.eqAl7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqO4 = this.eqO4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqAl8 = this.eqAl8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqAl9 = this.eqAl9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqT2 = this.eqT2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqDx = this.eqDx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqT4 = this.eqT4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspOneWyRt = this.trspOneWyRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtGrpCd = this.cmdtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqTal = this.eqTal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqPal = this.eqPal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqGn4 = this.eqGn4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqGn5 = this.eqGn5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqRal = this.eqRal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqSal = this.eqSal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqO2 = this.eqO2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.railSvcTpCd = this.railSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgTrspAgmtEqSzCd = this.orgTrspAgmtEqSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toWgt = this.toWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqAlal = this.eqAlal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqD4 = this.eqD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqD5 = this.eqD5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqSf4 = this.eqSf4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wtrDeTermCd = this.wtrDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqD7 = this.eqD7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqD2 = this.eqD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.agmtScgRtDivCd = this.agmtScgRtDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqSf2 = this.eqSf2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqD3 = this.eqD3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspAgmtEqTpCd = this.trspAgmtEqTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqTa2 = this.eqTa2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqD9 = this.eqD9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqD8 = this.eqD8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkRowno = this.chkRowno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqUg = this.eqUg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqCg = this.eqCg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.agmtTrspTpCd = this.agmtTrspTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspAgmtBdlQty = this.trspAgmtBdlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.viaNodYd = this.viaNodYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlt = this.rlt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgTrspAgmtEqTpCd = this.orgTrspAgmtEqTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rowno = this.rowno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqR7 = this.eqR7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqSfal = this.eqSfal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspAgmtRtTpCd = this.trspAgmtRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspAgmtEqSzCd = this.trspAgmtEqSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqCb4 = this.eqCb4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqR4 = this.eqR4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqR5 = this.eqR5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqR2 = this.eqR2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgEqtype = this.orgEqtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqGnal = this.eqGnal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspAgmtDist = this.trspAgmtDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqOal = this.eqOal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.distMeasUtCd = this.distMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqZt4 = this.eqZt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqS2 = this.eqS2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqS4 = this.eqS4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqSlal = this.eqSlal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspAgmtSeq = this.trspAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtMeasUtCd = this.wgtMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.effToDt = this.effToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqEg5 = this.eqEg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqA2 = this.eqA2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.agmtRoutAllFlg = this.agmtRoutAllFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqA4 = this.eqA4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspAgmtOfcCtyCd = this.trspAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqEg8 = this.eqEg8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqTaal = this.eqTaal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqP4 = this.eqP4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqP2 = this.eqP2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wtrRcvTermCd = this.wtrRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspRvsAplyFlg = this.trspRvsAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqFal = this.eqFal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspCostModCd = this.trspCostModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fmNodYd = this.fmNodYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqEgal = this.eqEgal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqSl2 = this.eqSl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.uiSeqno = this.uiSeqno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dorNodYd = this.dorNodYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqDal = this.eqDal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspDistTpCd = this.trspDistTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.comScgAplyFlg = this.comScgAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.woAplyFlg = this.woAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspAgmtRtTpSerNo = this.trspAgmtRtTpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspAgmtNodSeq = this.trspAgmtNodSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspAgmtRtSeq = this.trspAgmtRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspAgmtScgNodSeq = this.trspAgmtScgNodSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspAgmtScgRtSeq = this.trspAgmtScgRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoCntrTpCd = this.spclCgoCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrDefRmk = this.usrDefRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aftUsrDefRmk = this.aftUsrDefRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgRtSeq = this.orgRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.eqD4RtSeq = this.eqD4RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAalRtSeq = this.eqAalRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDalRtSeq = this.eqDalRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqS2RtSeq = this.eqS2RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqD5RtSeq = this.eqD5RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqD9RtSeq = this.eqD9RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqR4RtSeq = this.eqR4RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSlalRtSeq = this.eqSlalRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAl5RtSeq = this.eqAl5RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqEg8RtSeq = this.eqEg8RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSfalRtSeq = this.eqSfalRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqGnalRtSeq = this.eqGnalRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqF2RtSeq = this.eqF2RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqF5RtSeq = this.eqF5RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOalRtSeq = this.eqOalRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqT2RtSeq = this.eqT2RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqD8RtSeq = this.eqD8RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSf4RtSeq = this.eqSf4RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqO4RtSeq = this.eqO4RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqUgRtSeq = this.eqUgRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqP2RtSeq = this.eqP2RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqD3RtSeq = this.eqD3RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqS4RtSeq = this.eqS4RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDxRtSeq = this.eqDxRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSalRtSeq = this.eqSalRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAlalRtSeq = this.eqAlalRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqP4RtSeq = this.eqP4RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAl9RtSeq = this.eqAl9RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqGn5RtSeq = this.eqGn5RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDwRtSeq = this.eqDwRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqF4RtSeq = this.eqF4RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSl2RtSeq = this.eqSl2RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCgRtSeq = this.eqCgRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqZt4RtSeq = this.eqZt4RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAl4RtSeq = this.eqAl4RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTaalRtSeq = this.eqTaalRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqEgalRtSeq = this.eqEgalRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAl8RtSeq = this.eqAl8RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqGn4RtSeq = this.eqGn4RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqD2RtSeq = this.eqD2RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqR7RtSeq = this.eqR7RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqEg5RtSeq = this.eqEg5RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqPalRtSeq = this.eqPalRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCb4RtSeq = this.eqCb4RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqR5RtSeq = this.eqR5RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAl2RtSeq = this.eqAl2RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqA2RtSeq = this.eqA2RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAl7RtSeq = this.eqAl7RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqA4RtSeq = this.eqA4RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqO2RtSeq = this.eqO2RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqT4RtSeq = this.eqT4RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTalRtSeq = this.eqTalRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqFalRtSeq = this.eqFalRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRalRtSeq = this.eqRalRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSf2RtSeq = this.eqSf2RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTa2RtSeq = this.eqTa2RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqD7RtSeq = this.eqD7RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqR2RtSeq = this.eqR2RtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.eqXxxx = this.eqXxxx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqXxxxRtSeq = this.eqXxxxRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCostFlg = this.agmtCostFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
