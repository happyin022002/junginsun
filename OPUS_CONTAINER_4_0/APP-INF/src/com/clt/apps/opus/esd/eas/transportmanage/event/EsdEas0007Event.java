/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_006Event.java
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-29
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-29 yujin
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.event;

import com.clt.apps.opus.esd.eas.transportmanage.vo.DofChgTrfListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_EAS_007Event PDTO(Data Transfer Object including Parameters)<br>
 * @author yujin
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0007Event extends EventSupport {
	private DofChgTrfListVO dofChgTrfListVO = null;
	private DofChgTrfListVO[] dofChgTrfListVOs = null;
	
    private String selCntCd =null;
    private String custCntSeq=null;
    private String sType=null;
    private String sLocCd=null;
    private String sCustInfo=null;
    private String sContiCd=null;
    private String sCntrTpCd=null;
    private String sCurrCd=null;
    private String newEffDate=null;
    private String ctrlUserId=null;
    private String ctrlOfcCd=null;
        


	public String getCtrlOfcCd() {
		return ctrlOfcCd;
	}

	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}

	public String getCtrlUserId() {
		return ctrlUserId;
	}

	public void setCtrlUserId(String ctrlUserId) {
		this.ctrlUserId = ctrlUserId;
	}

	public String getNewEffDate() {
		return newEffDate;
	}

	public void setNewEffDate(String newEffDate) {
		this.newEffDate = newEffDate;
	}



	public DofChgTrfListVO getDofChgTrfListVO() {
		return dofChgTrfListVO;
	}

	public void setDofChgTrfListVO(DofChgTrfListVO dofChgTrfListVO) {
		this.dofChgTrfListVO = dofChgTrfListVO;
	}

	public DofChgTrfListVO[] getDofChgTrfListVOs() {
		return dofChgTrfListVOs;
	}

	public void setDofChgTrfListVOs(DofChgTrfListVO[] dofChgTrfListVOs) {
		this.dofChgTrfListVOs = dofChgTrfListVOs;
	}

	public String getSCurrCd() {
		return sCurrCd;
	}

	public void setSCurrCd(String currCd) {
		sCurrCd = currCd;
	}

	public String getSLocCd() {
		return sLocCd;
	}

	public void setSLocCd(String locCd) {
		sLocCd = locCd;
	}

	public String getSCustInfo() {
		return sCustInfo;
	}

	public void setSCustInfo(String custInfo) {
		sCustInfo = custInfo;
	}

	public String getSContiCd() {
		return sContiCd;
	}

	public void setSContiCd(String contiCd) {
		sContiCd = contiCd;
	}

	public String getSCntrTpCd() {
		return sCntrTpCd;
	}

	public void setSCntrTpCd(String cntrTpCd) {
		sCntrTpCd = cntrTpCd;
	}

	public String getSelCntCd() {
		return selCntCd;
	}

	public void setSelCntCd(String selCntCd) {
		this.selCntCd = selCntCd;
	}

	public String getCustCntSeq() {
		return custCntSeq;
	}

	public void setCustCntSeq(String custCntSeq) {
		this.custCntSeq = custCntSeq;
	}

	public String getSType() {
		return sType;
	}

	public void setSType(String type) {
		sType = type;
	}

	/**
     * 객체 표현 문자열(ESD_EAS_007Event)을 반환
     *
     * @return response String
     */
    public String toString() {
        return "EsdEas0007Event";
    }

    /**
     * 이벤트 명(ESD_EAS_007Event)을 반환
     *
     * @return response String
     */
    public String getEventName() {
        return "EsdEas0007Event";
    }

}
