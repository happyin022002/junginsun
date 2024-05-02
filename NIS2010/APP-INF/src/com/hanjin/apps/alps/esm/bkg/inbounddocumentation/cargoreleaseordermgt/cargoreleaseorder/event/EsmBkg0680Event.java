/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmBkg0680Event.java
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
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCntrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoSaveVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgDoRefVO;
import com.hanjin.syscommon.common.table.BkgDoVO;

/**
 * esm_bkg_0680 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0680HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lim Jin Young
 * @see ESM_BKG_0680HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0680Event extends EventSupport {

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
     * D/O Release Reference
     */
    private BkgDoRefVO[] refInfos = null;

//    /** Table Value Object Multi Data 처리 */
//    private DoEventVO[] doEventVOs = null;

    /**
     * Original B/L 회수 여부와 발행 통수 및  Detail정보
     */
    private BlIssVO[] blIssVOs = null;

    /**
     * D/O Release 기본 정보
     */
    private BkgDoVO[] blInfos = null;

    /**
     * B/L별 D/O의 STATUS
     */
    private DoRlseStsVO[] doRlseSts = null;

    /**
     * DOR I/F 정보
     */
    private EdoTransVO[] edoTrans = null;

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
     * India DO Save시 처리할 VO, bkg_do_ref, bkg_do 정보를 저장함.
     * @author Park Mangeon
     */
    private IdaDoSaveVO idaDoSave;

    private IdaDoRlseVO idaDoRlse;

    private String evntFlag;

    /**
     * OBL Change Flag
     */
    private String oblCngFlg = "";

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
     * B/L별 D/O의  정보
     */
    private DoCntrVO[] doCntrs = null;

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

    public IdaDoSaveVO getIdaDoSave() {
        return idaDoSave;
    }

    public void setIdaDoSave(IdaDoSaveVO idaDoSave) {
        this.idaDoSave = idaDoSave;
    }

    public IdaDoRlseVO getIdaDoRlse() {
        return idaDoRlse;
    }

    public void setIdaDoRlse(IdaDoRlseVO idaDoRlse) {
        this.idaDoRlse = idaDoRlse;
    }

    public DoCntrVO[] getDoCntrs() {
        return doCntrs;
    }

    public void setDoCntrs(DoCntrVO[] doCntrs) {
        this.doCntrs = doCntrs;
    }

//  public DoEventVO[] getDoEventVOs() {
//      return doEventVOs;
//  }
//
//  public void setDoEventVOs(DoEventVO[] doEventVOs) {
//      this.doEventVOs = doEventVOs;
//  }

    public String getEvntFlag() {
        return evntFlag;
    }

    public void setEvntFlag(String evntFlag) {
        this.evntFlag = evntFlag;
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


}