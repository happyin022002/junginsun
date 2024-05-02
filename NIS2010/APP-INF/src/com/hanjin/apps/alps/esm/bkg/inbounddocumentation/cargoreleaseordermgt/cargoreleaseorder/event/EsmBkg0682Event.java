/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmBkg0682Event.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.05.12
*@LastModifier   : 임진영
*@LastVersion    : 1.0
* 2009.05.12 임진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BlIssVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoAsignVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoEventVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoHoldVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoRqstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoRlseVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoSaveVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgDoRefVO;
import com.hanjin.syscommon.common.table.BkgDoVO;
import com.hanjin.syscommon.common.table.BkgEdoLogVO;

/**
 * ESM_BKG_0682 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0682HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lim Jin Young
 * @see ESM_BKG_0682HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0682Event extends EventSupport {

    /**
     *
     */
    private static final long serialVersionUID = 6505397460113280378L;

    /**
     * 선적예약 요청 번호
     */
    private String bkgNo = "";

    /**
     * 선화증권 번호
     */
    private String blNo = "";

    /**
     * Demurrage 타입
     */
    private String demurType = "";

    /**
     * Expect Delivery Date
     */
    private String expDelDt  = "";

    /**
     * O/BL 회수  여부 원래 값
     */
    private String oriOblRdemFlg = "";

    /**
     * O/BL 회수  여부 입력 요건에 따라서 변경 된 값
     */
    private String aftOblRdemFlg = "";

    /**
     * D/O의 진행 상태 코드
     */
    private String rlseStsCd   = "";

    /**
     * D/O의 최종 진행 상태 코드
     */
    private String lastRlseStsCd = "";

    /**
     * BKG 화물이 도착된 후 화주에게 화물을 찾아 가도록 발행하는 지시하는 번호
     */
    private String doNo = "";

    /**
     * Delivery Order Number가 Split 할  경우 입력
     */
    private String doNoSplit = "";

    /**
     * D/O 관련업무에서 발생하는 주요 EVENT
     */
    private String doCngEvntCd = "";

    /**
     * D/O EVENT에서 변경되기 전의 값
     */
    private String preCtnt   = "";

    /**
     * D/O EVENT에서 변경된 값
     */
    private String crntCtnt  = "";

    /**
     * partial 여부
     */
    private String cntrPrtFlg = "";

    /**
     * DOR 버튼 클릭 시 설정 값
     */
    private String svcCd = "";

    /**
     * OBL Change Flag
     */
    private String oblCngFlg = "";

    /**
     * O/BL Received 변경 후 값
     */
    private String oldOblRdemKnt = "";

    /**
     * O/BL Received 변경 전 값
     */
    private String newOblRdemKnt = "";

    private String evntFlag = "";

    /**
     * EDO 요청 번호
     */
    private String rqstNo = "";

    /**
     * 외부 파트너로부터 전송받은 DO 상태코드
     */
    private String ackInd = "";

    /**
     * D/O 단위의 SEQUENCE
     */
    private String rlseSeq = "";

    /**
     * EAI 수신 Flat File
     */
    private String flatFile;

    /**
     * EDI ID 조회하기 위한 쿼리 조건 값
     */
    private String discLocCd;

    /**
     * Self Trans To TMNL 체크 여부
     */
    private String selfTrnsFlg;
    
    /**
     * Release For Remark
     */
    private String releaseRemark;
    

    private KorDoEdiTransVO[] korDoEdiTrans = null;

    /**
     * D/O Release Reference
     */
    private BkgDoRefVO[] refInfos = null;

    /**
     * D/O Release Reference Customer VO
     */
    private KorDoSaveVO[] korDoSave = null;

    /**
     * Original B/L 회수 여부와 발행 통수 및  Detail정보
     */
    private BlIssVO[] blIssVOs = null;

    /**
     * D/O Release 기본 정보
     */
    private BkgDoVO[] blInfos = null;

    private DoBlInfoVO[] doBlInfo = null;

    private DoAsignVO[] doAsign = null;

    private KorDoRlseVO[] korDoRlse = null;

    /**
     * B/L별 D/O의 STATUS
     */
    private DoRlseStsVO[] doRlseSts = null;

    /**
     * DOR I/F 정보
     */
    private EdoTransVO[] edoTrans = null;

    /**
     * D/O Hold 정보
     */
    private DoHoldVO[] doHold = null;

    /** Table Value Object 조회 조건 및 단건 처리  */
    private DoEventVO doEventVO = null;

    /** Table Value Object Multi Data 처리 */
    private DoEventVO[] doEventVOs = null;

    private String exptDelDt = "";

    /** Table Value Object 조회 조건 및 단건 처리  */
    private DoRlseStsVO doStsVO = null;

    /** Table Value Object Multi Data 처리 */
    private DoRlseStsVO[] doStsVOs = null;

    /** Table Value Object 조회 조건 및 단건 처리  */
    private EdoRqstVO edoRqstVO = null;

    /** EDO LOG 수신  */
    private BkgEdoLogVO bkgEdoLogVO = null;

    public EsmBkg0682Event(){}

    /**
     * @return the bkgNo
     */
    public String getBkgNo() {
        return bkgNo;
    }

    /**
     * @param bkgNo the bkgNo to set
     */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
     * @return the blNo
     */
    public String getBlNo() {
        return blNo;
    }

    /**
     * @param blNo the blNo to set
     */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    /**
     * @return the demurType
     */
    public String getDemurType() {
        return demurType;
    }

    /**
     * @param demurType the demurType to set
     */
    public void setDemurType(String demurType) {
        this.demurType = demurType;
    }

    /**
     * @return the expDelDt
     */
    public String getExpDelDt() {
        return expDelDt;
    }

    /**
     * @param expDelDt the expDelDt to set
     */
    public void setExpDelDt(String expDelDt) {
        this.expDelDt = expDelDt;
    }

    /**
     * @return the oriOblRdemFlg
     */
    public String getOriOblRdemFlg() {
        return oriOblRdemFlg;
    }

    /**
     * @param oriOblRdemFlg the oriOblRdemFlg to set
     */
    public void setOriOblRdemFlg(String oriOblRdemFlg) {
        this.oriOblRdemFlg = oriOblRdemFlg;
    }

    /**
     * @return the aftOblRdemFlg
     */
    public String getAftOblRdemFlg() {
        return aftOblRdemFlg;
    }

    /**
     * @param aftOblRdemFlg the aftOblRdemFlg to set
     */
    public void setAftOblRdemFlg(String aftOblRdemFlg) {
        this.aftOblRdemFlg = aftOblRdemFlg;
    }

    /**
     * @return the rlseStsCd
     */
    public String getRlseStsCd() {
        return rlseStsCd;
    }

    /**
     * @param rlseStsCd the rlseStsCd to set
     */
    public void setRlseStsCd(String rlseStsCd) {
        this.rlseStsCd = rlseStsCd;
    }

    /**
     * @return the lastRlseStsCd
     */
    public String getLastRlseStsCd() {
        return lastRlseStsCd;
    }
   
    /**
     * @param lastRlseStsCd the lastRlseStsCd to set
     */
    public void setLastRlseStsCd(String lastRlseStsCd) {
        this.lastRlseStsCd = lastRlseStsCd;
    }
    
    /**
     * @return the releaseRemark
     */
    public String getReleaseRemark() {
        return releaseRemark;
    }
    

    /**
     * @param releaseRemark the releaseRemark to set
     */
    public void setReleaseRemark(String releaseRemark) {
        this.releaseRemark = releaseRemark;
    }

    /**
     * @return the doNo
     */
    public String getDoNo() {
        return doNo;
    }

    /**
     * @param doNo the doNo to set
     */
    public void setDoNo(String doNo) {
        this.doNo = doNo;
    }

    /**
     * @return the doNoSplit
     */
    public String getDoNoSplit() {
        return doNoSplit;
    }

    /**
     * @param doNoSplit the doNoSplit to set
     */
    public void setDoNoSplit(String doNoSplit) {
        this.doNoSplit = doNoSplit;
    }

    /**
     * @return the refInfos
     */
    public BkgDoRefVO[] getRefInfos() {
        return refInfos;
    }

    /**
     * @param refInfos the refInfos to set
     */
    public void setRefInfos(BkgDoRefVO[] refInfos) {
        this.refInfos = refInfos;
    }

    /**
     * @return the blIssVOs
     */
    public BlIssVO[] getBlIssVOs() {
        return blIssVOs;
    }

    /**
     * @param blIssVOs the blIssVOs to set
     */
    public void setBlIssVOs(BlIssVO[] blIssVOs) {
        this.blIssVOs = blIssVOs;
    }

    /**
     * @return the blInfos
     */
    public BkgDoVO[] getBlInfos() {
        return blInfos;
    }

    /**
     * @param blInfos the blInfos to set
     */
    public void setBlInfos(BkgDoVO[] blInfos) {
        this.blInfos = blInfos;
    }

    /**
     * @return the doBlInfo
     */
    public DoBlInfoVO[] getDoBlInfo() {
        return doBlInfo;
    }

    /**
     * @param doBlInfo the doBlInfo to set
     */
    public void setDoBlInfo(DoBlInfoVO[] doBlInfo) {
        this.doBlInfo = doBlInfo;
    }

    /**
     * @return the doRlseSts
     */
    public DoRlseStsVO[] getDoRlseSts() {
        return doRlseSts;
    }

    /**
     * @param doRlseSts the doRlseSts to set
     */
    public void setDoRlseSts(DoRlseStsVO[] doRlseSts) {
        this.doRlseSts = doRlseSts;
    }

    /**
     * @return the edoTrans
     */
    public EdoTransVO[] getEdoTrans() {
        return edoTrans;
    }

    /**
     * @param edoTrans the edoTrans to set
     */
    public void setEdoTrans(EdoTransVO[] edoTrans) {
        this.edoTrans = edoTrans;
    }

    /**
     * @return the doHold
     */
    public DoHoldVO[] getDoHold() {
        return doHold;
    }

    /**
     * @param doHold the doHold to set
     */
    public void setDoHold(DoHoldVO[] doHold) {
        this.doHold = doHold;
    }

    /**
     * @return the doCngEvntCd
     */
    public String getDoCngEvntCd() {
        return doCngEvntCd;
    }

    /**
     * @param doCngEvntCd the doCngEvntCd to set
     */
    public void setDoCngEvntCd(String doCngEvntCd) {
        this.doCngEvntCd = doCngEvntCd;
    }

    /**
     * @return the preCtnt
     */
    public String getPreCtnt() {
        return preCtnt;
    }

    /**
     * @param preCtnt the preCtnt to set
     */
    public void setPreCtnt(String preCtnt) {
        this.preCtnt = preCtnt;
    }

    /**
     * @return the crntCtnt
     */
    public String getCrntCtnt() {
        return crntCtnt;
    }

    /**
     * @param crntCtnt the crntCtnt to set
     */
    public void setCrntCtnt(String crntCtnt) {
        this.crntCtnt = crntCtnt;
    }

    /**
     * @return the cntrPrtFlg
     */
    public String getCntrPrtFlg() {
        return cntrPrtFlg;
    }

    /**
     * @param cntrPrtFlg the cntrPrtFlg to set
     */
    public void setCntrPrtFlg(String cntrPrtFlg) {
        this.cntrPrtFlg = cntrPrtFlg;
    }

    /**
     * @return the svcCd
     */
    public String getSvcCd() {
        return svcCd;
    }

    /**
     * @param svcCd the svcCd to set
     */
    public void setSvcCd(String svcCd) {
        this.svcCd = svcCd;
    }

    /**
     * @return the oblCngFlg
     */
    public String getOblCngFlg() {
        return oblCngFlg;
    }

    /**
     * @param oblCngFlg the oblCngFlg to set
     */
    public void setOblCngFlg(String oblCngFlg) {
        this.oblCngFlg = oblCngFlg;
    }

    /**
     * @return the oldOblRdemKnt
     */
    public String getOldOblRdemKnt() {
        return oldOblRdemKnt;
    }

    /**
     * @param oldOblRdemKnt the oldOblRdemKnt to set
     */
    public void setOldOblRdemKnt(String oldOblRdemKnt) {
        this.oldOblRdemKnt = oldOblRdemKnt;
    }

    /**
     * @return the newOblRdemKnt
     */
    public String getNewOblRdemKnt() {
        return newOblRdemKnt;
    }

    /**
     * @param newOblRdemKnt the newOblRdemKnt to set
     */
    public void setNewOblRdemKnt(String newOblRdemKnt) {
        this.newOblRdemKnt = newOblRdemKnt;
    }

    /**
     * @return the evntFlag
     */
    public String getEvntFlag() {
        return evntFlag;
    }

    /**
     * @param evntFlag the evntFlag to set
     */
    public void setEvntFlag(String evntFlag) {
        this.evntFlag = evntFlag;
    }

    /**
     * @return the rqstNo
     */
    public String getRqstNo() {
        return rqstNo;
    }

    /**
     * @param rqstNo the rqstNo to set
     */
    public void setRqstNo(String rqstNo) {
        this.rqstNo = rqstNo;
    }

    /**
     * @return the ackInd
     */
    public String getAckInd() {
        return ackInd;
    }

    /**
     * @param ackInd the ackInd to set
     */
    public void setAckInd(String ackInd) {
        this.ackInd = ackInd;
    }

    /**
     * @return the doEventVO
     */
    public DoEventVO getDoEventVO() {
        return doEventVO;
    }

    /**
     * @param doEventVO the doEventVO to set
     */
    public void setDoEventVO(DoEventVO doEventVO) {
        this.doEventVO = doEventVO;
    }

    /**
     * @return the doEventVOs
     */
    public DoEventVO[] getDoEventVOs() {
        return doEventVOs;
    }

    /**
     * @param doEventVOs the doEventVOs to set
     */
    public void setDoEventVOs(DoEventVO[] doEventVOs) {
        this.doEventVOs = doEventVOs;
    }

    /**
     * @return the exptDelDt
     */
    public String getExptDelDt() {
        return exptDelDt;
    }

    /**
     * @param exptDelDt the exptDelDt to set
     */
    public void setExptDelDt(String exptDelDt) {
        this.exptDelDt = exptDelDt;
    }

    /**
     * @return the doStsVO
     */
    public DoRlseStsVO getDoStsVO() {
        return doStsVO;
    }

    /**
     * @param doStsVO the doStsVO to set
     */
    public void setDoStsVO(DoRlseStsVO doStsVO) {
        this.doStsVO = doStsVO;
    }

    /**
     * @return the doStsVOs
     */
    public DoRlseStsVO[] getDoStsVOs() {
        return doStsVOs;
    }

    /**
     * @param doStsVOs the doStsVOs to set
     */
    public void setDoStsVOs(DoRlseStsVO[] doStsVOs) {
        this.doStsVOs = doStsVOs;
    }

    /**
     * @return the rlseSeq
     */
    public String getRlseSeq() {
        return rlseSeq;
    }

    /**
     * @param rlseSeq the rlseSeq to set
     */
    public void setRlseSeq(String rlseSeq) {
        this.rlseSeq = rlseSeq;
    }

    /**
     * @return the flatFile
     */
    public String getFlatFile() {
        return flatFile;
    }

    /**
     * @param flatFile the flatFile to set
     */
    public void setFlatFile(String flatFile) {
        this.flatFile = flatFile;
    }

    /**
     * @return the edoRqstVO
     */
    public EdoRqstVO getEdoRqstVO() {
        return edoRqstVO;
    }

    /**
     * @param edoRqstVO the edoRqstVO to set
     */
    public void setEdoRqstVO(EdoRqstVO edoRqstVO) {
        this.edoRqstVO = edoRqstVO;
    }

    /**
     * @return the bkgEdoLogVO
     */
    public BkgEdoLogVO getBkgEdoLogVO() {
        return bkgEdoLogVO;
    }

    /**
     * @param bkgEdoLogVO the bkgEdoLogVO to set
     */
    public void setBkgEdoLogVO(BkgEdoLogVO bkgEdoLogVO) {
        this.bkgEdoLogVO = bkgEdoLogVO;
    }

    /**
     * @return the korDoSave
     */
    public KorDoSaveVO[] getKorDoSave() {
        return korDoSave;
    }

    /**
     * @param korDoSave the korDoSave to set
     */
    public void setKorDoSave(KorDoSaveVO[] korDoSave) {
        this.korDoSave = korDoSave;
    }

    /**
     * @param doAsign the doAsign to set
     */
    public void setDoAsign(DoAsignVO[] doAsign) {
        this.doAsign = doAsign;
    }

    /**
     * @return the doAsign
     */
    public DoAsignVO[] getDoAsign() {
        return doAsign;
    }

    /**
     * @param korDoRlse the korDoRlse to set
     */
    public void setKorDoRlse(KorDoRlseVO[] korDoRlse) {
        this.korDoRlse = korDoRlse;
    }

    /**
     * @return the korDoRlse
     */
    public KorDoRlseVO[] getKorDoRlse() {
        return korDoRlse;
    }

    /**
     * @param discLocCd the discLocCd to set
     */
    public void setDiscLocCd(String discLocCd) {
        this.discLocCd = discLocCd;
    }

    /**
     * @return the discLocCd
     */
    public String getDiscLocCd() {
        return discLocCd;
    }

    /**
     * @param korDoEdiTrans the korDoEdiTrans to set
     */
    public void setKorDoEdiTrans(KorDoEdiTransVO[] korDoEdiTrans) {
        this.korDoEdiTrans = korDoEdiTrans;
    }

    /**
     * @return the korDoEdiTrans
     */
    public KorDoEdiTransVO[] getKorDoEdiTrans() {
        return korDoEdiTrans;
    }

    /**
     * @param selfTrnsFlg the selfTrnsFlg to set
     */
    public void setSelfTrnsFlg(String selfTrnsFlg) {
        this.selfTrnsFlg = selfTrnsFlg;
    }

    /**
     * @return the selfTrnsFlg
     */
    public String getSelfTrnsFlg() {
        return selfTrnsFlg;
    }
}