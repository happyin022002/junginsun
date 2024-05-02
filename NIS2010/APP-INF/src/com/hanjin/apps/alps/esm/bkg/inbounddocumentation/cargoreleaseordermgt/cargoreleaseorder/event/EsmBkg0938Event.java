/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmBkg0938Event.java
*@FileTitle      : EU Cargo Release (D/O)
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.09.16
*@LastModifier   : 안진응
*@LastVersion    : 1.0
* 2009.09.16 안진응
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BlIssVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCancelVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCntrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuCstmsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoCntrRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoRlseVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoSaveVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgDoRefVO;
import com.hanjin.syscommon.common.table.BkgDoVO;

/**
 * esm_bkg_0938 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0938HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author An Jin Eung
 * @see ESM_BKG_0938HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0938Event extends EventSupport {

    /**
     *
     */
    private static final long serialVersionUID = 8656847190059914500L;

    /**
     * D/O Release Reference
     */
    private BkgDoRefVO[] refInfos = null;

    private EuCstmsVO[] euCstms = null;

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
    private EuDoRlseStsVO[] euDoRlseSts = null;

    /**
     * B/L별 D/O의 Release 정보
     */
    private EuDoRlseVO euDoRlse = null;

    /**
     * B/L별 D/O의  정보
     */
    private DoCntrVO[] doCntrs = null;

    /**
     * EU DO Save 저장 VO
     */
    private EuDoSaveVO euDoSave = null;

    private DoCancelVO doCancel = null;

    private EuDoCntrRlseStsVO[] euDoCntrRlseSts = null;

    private DoBlInfoVO[] doBlInfo = null;

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
     * D/O의 진행 상태 코드
     */
    private String rlseStsCd   = "";

    /**
     * D/O의 최종 진행 상태 코드
     */
    private String lastRlseStsCd = "";

    /**
     * DOR 버튼 클릭 시 설정 값
     */
    private String svcCd = "";


    /**
     * O/BL 변경 이벤트 발생
     */
    private String oblCngFlg = "";

    private String cstmsRefNm = "";
    private String cstmsRefCtnt = "";
    private String cstmsAsgnNm = "";
    private String cstmsAsgnCtnt = "";
    private String interRmk = "";
    private String doSplitFlg = "";
    private String evntFlag = "";
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

    public String getCntrPrtFlg() {
        return cntrPrtFlg;
    }

    public void setCntrPrtFlg(String cntrPrtFlg) {
        this.cntrPrtFlg = cntrPrtFlg;
    }

    public String getRlseStsCd() {
        return rlseStsCd;
    }

    public void setRlseStsCd(String rlseStsCd) {
        this.rlseStsCd = rlseStsCd;
    }

    public String getLastRlseStsCd() {
        return lastRlseStsCd;
    }

    public void setLastRlseStsCd(String lastRlseStsCd) {
        this.lastRlseStsCd = lastRlseStsCd;
    }

    public String getSvcCd() {
        return svcCd;
    }

    public void setSvcCd(String svcCd) {
        this.svcCd = svcCd;
    }

    public EuDoRlseStsVO[] getEuDoRlseSts() {
        return euDoRlseSts;
    }

    public void setEuDoRlseSts(EuDoRlseStsVO[] euDoRlseSts) {
        this.euDoRlseSts = euDoRlseSts;
    }

    public EuDoRlseVO getEuDoRlse() {
        return euDoRlse;
    }

    public void setEuDoRlse(EuDoRlseVO euDoRlse) {
        this.euDoRlse = euDoRlse;
    }

    public DoCntrVO[] getDoCntrs() {
        return doCntrs;
    }

    public void setDoCntrs(DoCntrVO[] doCntrs) {
        this.doCntrs = doCntrs;
    }

    public String getOblCngFlg() {
        return oblCngFlg;
    }

    public void setOblCngFlg(String oblCngFlg) {
        this.oblCngFlg = oblCngFlg;
    }

    public String getCstmsRefNm() {
        return cstmsRefNm;
    }

    public void setCstmsRefNm(String cstmsRefNm) {
        this.cstmsRefNm = cstmsRefNm;
    }

    public String getCstmsRefCtnt() {
        return cstmsRefCtnt;
    }

    public void setCstmsRefCtnt(String cstmsRefCtnt) {
        this.cstmsRefCtnt = cstmsRefCtnt;
    }

    public String getCstmsAsgnNm() {
        return cstmsAsgnNm;
    }

    public void setCstmsAsgnNm(String cstmsAsgnNm) {
        this.cstmsAsgnNm = cstmsAsgnNm;
    }

    public String getCstmsAsgnCtnt() {
        return cstmsAsgnCtnt;
    }

    public void setCstmsAsgnCtnt(String cstmsAsgnCtnt) {
        this.cstmsAsgnCtnt = cstmsAsgnCtnt;
    }

    public String getInterRmk() {
        return interRmk;
    }

    public void setInterRmk(String interRmk) {
        this.interRmk = interRmk;
    }

    public String getDoSplitFlg() {
        return doSplitFlg;
    }

    public void setDoSplitFlg(String doSplitFlg) {
        this.doSplitFlg = doSplitFlg;
    }

    public EuCstmsVO[] getEuCstms() {
        return euCstms;
    }

    public void setEuCstms(EuCstmsVO[] euCstms) {
        this.euCstms = euCstms;
    }

    public EuDoSaveVO getEuDoSave() {
        return euDoSave;
    }

    public void setEuDoSave(EuDoSaveVO euDoSave) {
        this.euDoSave = euDoSave;
    }

    public EuDoCntrRlseStsVO[] getEuDoCntrRlseSts() {
        return euDoCntrRlseSts;
    }

    public void setEuDoCntrRlseSts(EuDoCntrRlseStsVO[] euDoCntrRlseSts) {
        this.euDoCntrRlseSts = euDoCntrRlseSts;
    }

    public DoCancelVO getDoCancel() {
        return doCancel;
    }

    public void setDoCancel(DoCancelVO doCancel) {
        this.doCancel = doCancel;
    }

    public DoBlInfoVO[] getDoBlInfo() {
        return doBlInfo;
    }

    public void setDoBlInfo(DoBlInfoVO[] doBlInfo) {
        this.doBlInfo = doBlInfo;
    }

    public String getEvntFlag() {
        return evntFlag;
    }

    public void setEvntFlag(String evntFlag) {
        this.evntFlag = evntFlag;
    }
}