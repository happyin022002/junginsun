/*=========================================================
 *@FileName : ESD_TRS_0221Event.java
 *@FileTitle : Agreement Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-03-26
 *@LastModifier : jong hyek choi
 *@LastVersion : 1.0 
 * 2010-03-26 jong hyek choi
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event;

import java.util.ArrayList;
import java.util.Arrays;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.DummyAgmtRateVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0220 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0220HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jong hyek choi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0221Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	String fmAgmtno          = null;
    String fmTrspAgmtRtTpCd   = null;
    String fmAccountOfcCd  = null;
    String fmAccountUsrId  = null;
    String fmCtrtOfcCd     = null;
    String fmEqKndCd       = null;



///////////////////////////////////////////////////////////////////
    String fmVndrPrmrySeq = null;
    String fmAgmtRefNo = null;
    String fmTrspAgmtRtTpSerNo = null;
///////////////////////////////////////////////////////////////////



    private String headerRow = "";
    
    /** Verify위한 Temp Sequence */
    private String trspAgmtTmpSeq = null;
    
    private DummyAgmtRateVO dummyAgmtRateVO = null;
    private DummyAgmtRateVO[] dummyAgmtRateVOs = null;
    
    String custCode = null;

    public String getFm_agmtno() {
        return fmAgmtno;
    }

    public void setFm_agmtno(String fmAgmtno) {
        this.fmAgmtno = fmAgmtno;
    }

    public String getFm_trsp_agmt_rt_tp_cd() {
        return fmTrspAgmtRtTpCd;
    }

    public void setFm_trsp_agmt_rt_tp_cd(String fmTrspAgmtRtTpCd) {
        this.fmTrspAgmtRtTpCd = fmTrspAgmtRtTpCd;
    }

    public String getFm_account_ofc_cd() {
        return fmAccountOfcCd;
    }

    public void setFm_account_ofc_cd(String fmAccountOfcCd) {
        this.fmAccountOfcCd = fmAccountOfcCd;
    }

    public String getFm_account_usr_id() {
        return fmAccountUsrId;
    }

    public void setFm_account_usr_id(String fmAccountUsrId) {
        this.fmAccountUsrId = fmAccountUsrId;
    }

    public String getHeaderRow() {
        return headerRow;
    }

    public void setHeaderRow(String headerRow) {
        this.headerRow = headerRow;
    }

    public String getFm_eq_knd_cd() {
        return fmEqKndCd;
    }

    public void setFm_eq_knd_cd(String fmEqKndCd) {
        this.fmEqKndCd = fmEqKndCd;
    }

    public String getTrspAgmtTmpSeq() {
        return trspAgmtTmpSeq;
    }

    public void setTrspAgmtTmpSeq(String trspAgmtTmpSeq) {
        this.trspAgmtTmpSeq = trspAgmtTmpSeq;
    }

    public String getFm_ctrt_ofc_cd() {
        return fmCtrtOfcCd;
    }

    public void setFm_ctrt_ofc_cd(String fmCtrtOfcCd) {
        this.fmCtrtOfcCd = fmCtrtOfcCd;
    }



///////////////////////////////////////////////////////////////////
    public String getFmVndrPrmrySeq() {
        return fmVndrPrmrySeq;
    }

    public void setFmVndrPrmrySeq(String fmVndrPrmrySeq) {
        this.fmVndrPrmrySeq = fmVndrPrmrySeq;
    }

    public String getFmAgmtRefNo() {
        return fmAgmtRefNo;
    }

    public void setFmAgmtRefNo(String fmAgmtRefNo) {
        this.fmAgmtRefNo = fmAgmtRefNo;
    }

    public String getFmTrspAgmtRtTpSerNo() {
        return fmTrspAgmtRtTpSerNo;
    }

    public void setFmTrspAgmtRtTpSerNo(String fmTrspAgmtRtTpSerNo) {
        this.fmTrspAgmtRtTpSerNo = fmTrspAgmtRtTpSerNo;
    }
///////////////////////////////////////////////////////////////////



    public DummyAgmtRateVO getDummyAgmtRateVO() {
        return dummyAgmtRateVO;
    }

    public void setDummyAgmtRateVO(DummyAgmtRateVO dummyAgmtRateVO) {
        this.dummyAgmtRateVO = dummyAgmtRateVO;
    }

    public DummyAgmtRateVO[] getDummyAgmtRateVOs() {
        DummyAgmtRateVO[] rtnVOs = null;
		if (this.dummyAgmtRateVOs != null) {
			rtnVOs = Arrays.copyOf(dummyAgmtRateVOs, dummyAgmtRateVOs.length);
		} // end if
		return rtnVOs;
    }

    public void setDummyAgmtRateVOs(DummyAgmtRateVO[] dummyAgmtRateVOs) {
		if (dummyAgmtRateVOs != null) {
			DummyAgmtRateVO[] tmpVOs = Arrays.copyOf(dummyAgmtRateVOs, dummyAgmtRateVOs.length);
			this.dummyAgmtRateVOs = tmpVOs;
		} // end if
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

	@SuppressWarnings({ "rawtypes", "unchecked" })
    public ArrayList setArrayList(String[] src, ArrayList tgt){
        tgt = new ArrayList();

        for(int i=0;src != null && i<src.length; i++  ){
            tgt.add(src[i]);
        }
        return tgt;
    }
}
