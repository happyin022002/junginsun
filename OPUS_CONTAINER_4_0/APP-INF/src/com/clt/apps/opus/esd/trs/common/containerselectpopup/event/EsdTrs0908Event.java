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
package com.clt.apps.opus.esd.trs.common.containerselectpopup.event;

import java.util.Arrays;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;


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
	private static final long serialVersionUID = 1L;
	
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
		if (ibflag != null) {
			String[] tmpVOs = Arrays.copyOf(ibflag, ibflag.length);
			this.ibflag = tmpVOs;
		} // end if
	}

	public String [] getIbflag() {
		String[] rtnVOs = null;
		if (this.ibflag != null) {
			rtnVOs = Arrays.copyOf(ibflag, ibflag.length);
		} // end if
		return rtnVOs;
	}

	public void setBkgNos(String [] bkgNos) {
		if (bkgNos != null) {
			String[] tmpVOs = Arrays.copyOf(bkgNos, bkgNos.length);
			this.bkgNos = tmpVOs;
		} // end if
	}

	public String [] getBkgNos() {
		String[] rtnVOs = null;
		if (this.bkgNos != null) {
			rtnVOs = Arrays.copyOf(bkgNos, bkgNos.length);
		} // end if
		return rtnVOs;
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
		if (trspSoOfcCtyCd != null) {
			String[] tmpVOs = Arrays.copyOf(trspSoOfcCtyCd, trspSoOfcCtyCd.length);
			this.trspSoOfcCtyCd = tmpVOs;
		} // end if
	}

	public String [] getTrsp_so_ofc_cty_cd() {
		String[] rtnVOs = null;
		if (this.trspSoOfcCtyCd != null) {
			rtnVOs = Arrays.copyOf(trspSoOfcCtyCd, trspSoOfcCtyCd.length);
		} // end if
		return rtnVOs;
	}

	public void setTrsp_so_seq(String [] trspSoSeq) {
		if (trspSoSeq != null) {
			String[] tmpVOs = Arrays.copyOf(trspSoSeq, trspSoSeq.length);
			this.trspSoSeq = tmpVOs;
		} // end if
	}

	public String [] getTrsp_so_seq() {
		String[] rtnVOs = null;
		if (this.trspSoSeq != null) {
			rtnVOs = Arrays.copyOf(trspSoSeq, trspSoSeq.length);
		} // end if
		return rtnVOs;
	}

	public void setTrsTrspSvcOrdVO(TrsTrspSvcOrdVO trsTrspSvcOrdVO) {
		this.trsTrspSvcOrdVO = trsTrspSvcOrdVO;
	}

	public TrsTrspSvcOrdVO getTrsTrspSvcOrdVO() {
		return trsTrspSvcOrdVO;
	}

	public void setTrsTrspSvcOrdVOs(TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs) {
		if (trsTrspSvcOrdVOs != null) {
			TrsTrspSvcOrdVO[] tmpVOs = Arrays.copyOf(trsTrspSvcOrdVOs, trsTrspSvcOrdVOs.length);
			this.trsTrspSvcOrdVOs = tmpVOs;
		} // end if
	}

	public TrsTrspSvcOrdVO[] getTrsTrspSvcOrdVOs() {
		TrsTrspSvcOrdVO[] rtnVOs = null;
		if (this.trsTrspSvcOrdVOs != null) {
			rtnVOs = Arrays.copyOf(trsTrspSvcOrdVOs, trsTrspSvcOrdVOs.length);
		} // end if
		return rtnVOs;
	}

}
