/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_EAS_0011Event.java
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2012-03-02
*@LastModifier : sungho park
*@LastVersion : 1.0
* 2012-03-02 sungho park
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.event;

import java.util.HashMap;

import com.hanjin.apps.alps.esd.eas.transportmanage.vo.CommEasDrffChgTrfVO;
import com.hanjin.apps.alps.esd.eas.transportmanage.vo.DofChgTrfListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EasDrffChgTrfHdrVO;

/**
 * ESD_EAS_0011Event PDTO(Data Transfer Object including Parameters)<br>
 * @author sungho park
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0011Event extends EventSupport {
	
	private DofChgTrfListVO dofChgTrfListVO = null;
	private EasDrffChgTrfHdrVO easDrffChgTrfHdrVO = null;
	private CommEasDrffChgTrfVO commEasDrffChgTrfVO = null;
	private DofChgTrfListVO[] dofChgTrfListVOs = null;
	private EasDrffChgTrfHdrVO[] easDrffChgTrfHdrVOs = null;
	private CommEasDrffChgTrfVO[] commEasDrffChgTrfVOs = null;

    private String selCntCd =null;
    private String custCntSeq=null;
    private String sType=null;
    private String sLocCd=null;
    private String sCustInfo=null;
    private String sContiCd=null;
    private String sContiCdOld=null;
    private String sCntrTpCd=null;
    private String sCurrCd=null;
    private String newEffDate=null;
    private String ctrlUserId=null;
    private String ctrlOfcCd=null;
    private String cntCd =null;
    private String rfaNo=null;
    private String drffChgTrfVerNo = null;
    private String drffChgTrfSeq = null;
    private String maxSeq = null;
    private String creUsrId = null;
    private String sccCd = null;
    private String sccCd2 = null;
    private String isSave = null;
    private String isUpload = null;    
    
    
	public String getCtrlOfcCd() {
		return ctrlOfcCd;
	}
	
	public String getIsSave() {
		return isSave;
	}
	
	public String getSccCd() {
		return sccCd;
	}
	
	public String getSccCd2() {
		return sccCd2;
	}	
	
	public String getIsUpload() {
		return isUpload;
	}

	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	public String getMaxSeq() {
		return this.maxSeq;
	}
	
	public void setMaxSeq(String maxSeq) {
		this.maxSeq = maxSeq;
	}
	
	public String getCtrlUserId() {
		return ctrlUserId;
	}
	
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	public void setSccCd2(String sccCd2) {
		this.sccCd2 = sccCd2;
	}	
	
	public void setCtrlUserId(String ctrlUserId) {
		this.ctrlUserId = ctrlUserId;
	}
	
	public void setIsSave(String isSave) {
		this.isSave = isSave;
	}

	public void setIsUpload(String isUpload) {
		this.isUpload = isUpload;
	}	
	
	public String getNewEffDate() {
		return newEffDate;
	}
	
	public String getDrffChgTrfSeq() {
		return this.drffChgTrfSeq;
	}
	
	public void setDrffChgTrfSeq(String drffChgTrfSeq) {
		this.drffChgTrfSeq = drffChgTrfSeq;
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
	
	public EasDrffChgTrfHdrVO getEasDrffChgTrfHdrVO() {
		return easDrffChgTrfHdrVO;
	}

	public void setEasDrffChgTrfHdrVO(EasDrffChgTrfHdrVO easDrffChgTrfHdrVO) {
		this.easDrffChgTrfHdrVO = easDrffChgTrfHdrVO;
	}

	public CommEasDrffChgTrfVO getCommEasDrffChgTrfVO() {
		return commEasDrffChgTrfVO;
	}

	public void setCommEasDrffChgTrfVO(CommEasDrffChgTrfVO commEasDrffChgTrfVO) {
		this.commEasDrffChgTrfVO = commEasDrffChgTrfVO;
	}
	
	public DofChgTrfListVO[] getDofChgTrfListVOs() {
		DofChgTrfListVO[] rtnVOs = null;
		if (this.dofChgTrfListVOs != null) {
			rtnVOs = new DofChgTrfListVO[dofChgTrfListVOs.length];
			System.arraycopy(dofChgTrfListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setDofChgTrfListVOs(DofChgTrfListVO[] dofChgTrfListVOs){
		if(dofChgTrfListVOs != null){
			DofChgTrfListVO[] tmpVOs = new DofChgTrfListVO[dofChgTrfListVOs.length];
			System.arraycopy(dofChgTrfListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dofChgTrfListVOs = tmpVOs;
		}
	}
	
	public EasDrffChgTrfHdrVO[] getEasDrffChgTrfHdrVOs() {
		EasDrffChgTrfHdrVO[] rtnVOs = null;
		if (this.easDrffChgTrfHdrVOs != null) {
			rtnVOs = new EasDrffChgTrfHdrVO[easDrffChgTrfHdrVOs.length];
			System.arraycopy(easDrffChgTrfHdrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setEasDrffChgTrfHdrVOs(EasDrffChgTrfHdrVO[] easDrffChgTrfHdrVOs){
		if(easDrffChgTrfHdrVOs != null){
			EasDrffChgTrfHdrVO[] tmpVOs = new EasDrffChgTrfHdrVO[easDrffChgTrfHdrVOs.length];
			System.arraycopy(easDrffChgTrfHdrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.easDrffChgTrfHdrVOs = tmpVOs;
		}
	}
	
	public CommEasDrffChgTrfVO[] getCommEasDrffChgTrfVOs() {
		CommEasDrffChgTrfVO[] rtnVOs = null;
		if (this.commEasDrffChgTrfVOs != null) {
			rtnVOs = new CommEasDrffChgTrfVO[commEasDrffChgTrfVOs.length];
			System.arraycopy(commEasDrffChgTrfVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setCommEasDrffChgTrfVOs(CommEasDrffChgTrfVO[] commEasDrffChgTrfVOs){
		if(commEasDrffChgTrfVOs != null){
			CommEasDrffChgTrfVO[] tmpVOs = new CommEasDrffChgTrfVO[commEasDrffChgTrfVOs.length];
			System.arraycopy(commEasDrffChgTrfVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.commEasDrffChgTrfVOs = tmpVOs;
		}
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
	
	public String getSContiCdOld() {
		return sContiCdOld;
	}

	public String getDrffChgTrfVerNo() {
		return drffChgTrfVerNo;
	}
	
	public void setDrffChgTrfVerNo(String drffChgTrfVerNo) {
		this.drffChgTrfVerNo = drffChgTrfVerNo;
	}
	
	public void setSContiCdOld(String contiCdOld) {
		sContiCdOld = contiCdOld;
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
	
	public String getRfaNo() {
		return rfaNo;
	}

	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	public String getCntCd() {
		return cntCd;
	}
	
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
     * 객체 표현 문자열(ESD_EAS_0011Event)을 반환
     *
     * @return response String
     */
    public String toString() {
        return "EsdEas0011Event";
    }
    
    /**
     * 이벤트 명(ESD_EAS_0011Event)을 반환
     *
     * @return response String
     */
    public String getEventName() {
        return "EsdEas0011Event";
    }
    
}
