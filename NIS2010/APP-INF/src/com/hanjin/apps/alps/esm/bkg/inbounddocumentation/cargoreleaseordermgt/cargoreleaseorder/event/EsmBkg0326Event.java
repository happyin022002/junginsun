/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmBkg0326Event.java
*@FileTitle      : Attorney Create Pop-up
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009-09-04
*@LastModifier   : 임진영
*@LastVersion    : 1.0
* 2009-09-04 임진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BlIssVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoHoldVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoSaveVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDorStatusVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgDoRefVO;
import com.hanjin.syscommon.common.table.BkgDoVO;

/**
 * esm_bkg_0326 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0326HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lim Jin Young
 * @see ESM_BKG_0326HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0326Event extends EventSupport {

    /**
     *
     */
    private static final long serialVersionUID = 8656847190059914500L;

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
     * D/O Release Reference
     */
    private BkgDoRefVO[] refInfos = null;

    /**
     * D/O Release Reference Customer VO
     */
    private JapDoSaveVO[] japDoSave = null;

    /**
     * Original B/L 회수 여부와 발행 통수 및  Detail정보
     */
    private BlIssVO[] blIssVOs = null;

    /**
     * D/O Release 기본 정보
     */
    private BkgDoVO[] blInfos = null;

    private DoBlInfoVO[] doBlInfo = null;

    /**
     * B/L별 D/O의 STATUS
     */
    private DoRlseStsVO[] doRlseSts = null;

    /**
     * DOR I/F 정보
     */
    private EdoTransVO[] edoTrans = null;

    /**
     * DOR I/F 정보
     */
    private DoHoldVO[] doHold = null;

    /**
     * Jap Do Id 정보
     */
    private JapDorStatusVO[] japDorStatus = null;

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
     * Release For Remark
     */
    private String releaseRemark;
    
    /**
     * @param bkgNo the bkgNo to set
     */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
     * @return the bkgNo
     */
    public String getBkgNo() {
        return bkgNo;
    }

    /**
     * @param blNo the blNo to set
     */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    /**
     * @return the blNo
     */
    public String getBlNo() {
        return blNo;
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
     * @param expDeldt the expDelDt to set
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
     * @param svcCd the svcCd to set
     */
    public void setSvcCd(String svcCd) {
        this.svcCd = svcCd;
    }

    /**
     * @return the svcCd
     */
    public String getSvcCd() {
        return svcCd;
    }

    /**
     * @param edoTrans the edoTrans to set
     */
    public void setEdoTrans(EdoTransVO[] edoTrans) {
        this.edoTrans = edoTrans;
    }

    /**
     * @return the edoTrans
     */
    public EdoTransVO[] getEdoTrans() {
        return edoTrans;
    }

    /**
     * @param oblCngFlg the oblCngFlg to set
     */
    public void setOblCngFlg(String oblCngFlg) {
        this.oblCngFlg = oblCngFlg;
    }

    /**
     * @return the oblCngFlg
     */
    public String getOblCngFlg() {
        return oblCngFlg;
    }

    /**
     * @param japDoSave the japDoSave to set
     */
    public void setJapDoSave(JapDoSaveVO[] japDoSave) {
        this.japDoSave = japDoSave;
    }

    /**
     * @return the japDoSave
     */
    public JapDoSaveVO[] getJapDoSave() {
        return japDoSave;
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
     * @param doBlInfo the doBlInfo to set
     */
    public void setDoBlInfo(DoBlInfoVO[] doBlInfo) {
        this.doBlInfo = doBlInfo;
    }

    /**
     * @return the doBlInfo
     */
    public DoBlInfoVO[] getDoBlInfo() {
        return doBlInfo;
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
     * @param japDorStatus the japDorStatus to set
     */
    public void setJapDorStatus(JapDorStatusVO[] japDorStatus) {
        this.japDorStatus = japDorStatus;
    }

    /**
     * @return the japDorStatus
     */
    public JapDorStatusVO[] getJapDorStatus() {
        return japDorStatus;
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
}