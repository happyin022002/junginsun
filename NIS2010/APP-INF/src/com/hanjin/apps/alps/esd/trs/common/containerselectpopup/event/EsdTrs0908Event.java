/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_908Event.java
*@FileTitle : Empty Repo & S/T On/Off Hire S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.29
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2006.10.31 kim_sang_geun
* 1.0 최초 생성
* --------------------------------------------------------
* History
* 2010.09.29 최 선  1.1 [] 불필요 variable 정리
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.containerselectpopup.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;


/**
 * ESD_TRS_908 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_908HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim_sang_geun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0908Event extends EventSupport {
	
	private TrsTrspSvcOrdVO trsTrspSvcOrdVO = null;
	
	private TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs = null;

	private String [] ibflag = null;
	private String [] bkgNos = null;
	private String [] trspSoOfcCtyCd = null;
	private String [] trspSoSeq = null;
	private String bkgNo = null;
	private String orgBkgNo = null;
	
	public EsdTrs0908Event(){}

	public String getEventName() {
		return "EsdTrs0908Event";
	}

	public String toString() {
		return "EsdTrs0908Event";
	}

	public void setIbflag(String [] ibflag) {
		this.ibflag = ibflag;
	}

	public String [] getIbflag() {
		return ibflag;
	}

	public void setBkgNos(String [] bkgNos) {
		this.bkgNos = bkgNos;
	}

	public String [] getBkgNos() {
		return bkgNos;
	}
	
	public void setBkgNo(String bkgNoValue) {
		this.bkgNo = bkgNoValue;
	}

	public String getBkgNo() {
		return bkgNo;
	}
	
	public void setOrgBkgNo(String orgBkgNoValue) {
		this.orgBkgNo = orgBkgNoValue;
	}

	public String getOrgBkgNo() {
		return orgBkgNo;
	}

	public void setTrsp_so_ofc_cty_cd(String [] trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}

	public String [] getTrsp_so_ofc_cty_cd() {
		return trspSoOfcCtyCd;
	}

	public void setTrsp_so_seq(String [] trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}

	public String [] getTrsp_so_seq() {
		return trspSoSeq;
	}

	public void setTrsTrspSvcOrdVO(TrsTrspSvcOrdVO trsTrspSvcOrdVO) {
		this.trsTrspSvcOrdVO = trsTrspSvcOrdVO;
	}

	public TrsTrspSvcOrdVO getTrsTrspSvcOrdVO() {
		return trsTrspSvcOrdVO;
	}

	public void setTrsTrspSvcOrdVOs(TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs) {
		this.trsTrspSvcOrdVOs = trsTrspSvcOrdVOs;
	}

	public TrsTrspSvcOrdVO[] getTrsTrspSvcOrdVOs() {
		return trsTrspSvcOrdVOs;
	}

}
