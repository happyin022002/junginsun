/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_012Event.java
*@FileTitle : Empty Repo & S/T On/Off Hire S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-10-30 kim_sang_geun
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.vo.SingleTransportationSOManageSearchVO;
import com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.vo.SingleTransportationSOManageVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim_sang_geun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0012Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	private String radWoIssued   = null;
	private String radDate       = null;
	private String hidFrmreqdate = null;
	private String hidToreqdate  = null;
	private String selKind       = null;
	private String selTransmode  = null;
	private String frmNode       = null;
	private String toNode        = null;
	private String cntrNo        = null;
	private String referenceNo   = null;
	private String bkgNo		 = null;
	private String ctrlOfcCd    = null;	
	private String frmYard = null;
	private String toYard = null;
	private String eqNoVerify = "";
	private String frmNodeVerify = "";
	private SingleTransportationSOManageVO singleTransportationSOManageVO = null;
	private SingleTransportationSOManageVO[] singleTransportationSOManageVOs = null;	
	private SingleTransportationSOManageSearchVO singleTransportationSOManageSearchVO = null;
	private SingleTransportationVO[] singleTransportationVOs = null;
	private String cbstatus = null;
	private String hidCntrNo = null;
	private String hidEqNo="";
	private String searchFmNode = null;
	private String searchToNode = null;
	
	public String getHidEqNo() {
		return hidEqNo;
	}
	public void setHidEqNo(String hidEqNo) {
		this.hidEqNo = hidEqNo;
	}
	public String getHidCntrNo() {
		return hidCntrNo;
	}
	public void setHidCntrNo(String hidCntrNo) {
		this.hidCntrNo = hidCntrNo;
	}
	public String getCbstatus() {
		return cbstatus;
	}
	public void setCbstatus(String cbstatus) {
		this.cbstatus = cbstatus;
	}
	public SingleTransportationSOManageVO getSingleTransportationSOManageVO() {
		return singleTransportationSOManageVO;
	}
	public void setSingleTransportationSOManageVO(
			SingleTransportationSOManageVO singleTransportationSOManageVO) {
		this.singleTransportationSOManageVO = singleTransportationSOManageVO;
	}
	public SingleTransportationSOManageVO[] getSingleTransportationSOManageVOs() {
		SingleTransportationSOManageVO[] rtnVOs = null;
		if (this.singleTransportationSOManageVOs != null) {
			rtnVOs = Arrays.copyOf(singleTransportationSOManageVOs, singleTransportationSOManageVOs.length);
		} // end if
		return rtnVOs;
	}
	public void setSingleTransportationSOManageVOs(
			SingleTransportationSOManageVO[] singleTransportationSOManageVOs) {
		if (singleTransportationSOManageVOs != null) {
			SingleTransportationSOManageVO[] tmpVOs = Arrays.copyOf(singleTransportationSOManageVOs, singleTransportationSOManageVOs.length);
			this.singleTransportationSOManageVOs = tmpVOs;
		} // end if
	}
	public String getEqNoVerify() {
		return eqNoVerify;
	}
	public void setEqNoVerify(String eqNoVerify) {
		this.eqNoVerify = eqNoVerify;
	}
	public String getFrmNodeVerify() {
		return frmNodeVerify;
	}
	public void setFrmNodeVerify(String frmNodeVerify) {
		this.frmNodeVerify = frmNodeVerify;
	}
	public String getFrmYard() {
		return frmYard;
	}	
	public void setFrmYard(String frmYard) {
		this.frmYard = frmYard;
	}
	public String getToYard() {
		return toYard;
	}
	public void setToYard(String toYard) {
		this.toYard = toYard;
	}
	public EsdTrs0012Event(){}		
	public String getRadDate() {
		return radDate;
	}

	public void setRadDate(String radDate) {
		this.radDate = radDate;
	}

	public String getHidFrmreqdate() {
		return hidFrmreqdate;
	}

	public void setHidFrmreqdate(String hidFrmreqdate) {
		this.hidFrmreqdate = hidFrmreqdate;
	}

	public String getHidToreqdate() {
		return hidToreqdate;
	}

	public void setHidToreqdate(String hidToreqdate) {
		this.hidToreqdate = hidToreqdate;
	}

	public String getSelKind() {
		return selKind;
	}

	public void setSelKind(String selKind) {
		this.selKind = selKind;
	}

	public String getSelTransmode() {
		return selTransmode;
	}

	public void setSelTransmode(String selTransmode) {
		this.selTransmode = selTransmode;
	}

	public String getFrmNode() {
		return frmNode;
	}

	public void setFrmNode(String frmNode) {
		this.frmNode = frmNode;
	}

	public String getToNode() {
		return toNode;
	}

	public void setToNode(String toNode) {
		this.toNode = toNode;
	}

	public String getCntrNo() {
		return cntrNo;
	}

	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	
	public String getBkgNo() {
		return bkgNo;
	}
	
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	public String getCtrlOfcCd() {
		return ctrlOfcCd;
	}

	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}

	public String getSearchFmNode() {
		return searchFmNode;
	}

	public void setSearchFmNode(String searchFmNode) {
		this.searchFmNode = searchFmNode;
	}

	public String getSearchToNode() {
		return searchToNode;
	}

	public void setSearchToNode(String searchToNode) {
		this.searchToNode = searchToNode;
	}

	public String getEventName() {
		return "EsdTrs0012Event";
	}

	public String toString() {
		return "EsdTrs0012Event";
	}	

	public void setSingleTransportationSOManageSearchVO(
			SingleTransportationSOManageSearchVO singleTransportationSOManageSearchVO) {
		this.singleTransportationSOManageSearchVO = singleTransportationSOManageSearchVO;
	}
	public SingleTransportationSOManageSearchVO getSingleTransportationSOManageSearchVO() {
		return singleTransportationSOManageSearchVO;
	}
	public void setSingleTransportationVOs(SingleTransportationVO[] singleTransportationVOs) {
		if (singleTransportationVOs != null) {
			SingleTransportationVO[] tmpVOs = Arrays.copyOf(singleTransportationVOs, singleTransportationVOs.length);
			this.singleTransportationVOs = tmpVOs;
		} // end if
	}
	public SingleTransportationVO[] getSingleTransportationVOs() {
		SingleTransportationVO[] rtnVOs = null;
		if (this.singleTransportationVOs != null) {
			rtnVOs = Arrays.copyOf(singleTransportationVOs, singleTransportationVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public String getRadWoIssued() {
		return radWoIssued;
	}
	
	public void setRadWoIssued(String radWoIssued) {
		this.radWoIssued = radWoIssued;
	}
}
