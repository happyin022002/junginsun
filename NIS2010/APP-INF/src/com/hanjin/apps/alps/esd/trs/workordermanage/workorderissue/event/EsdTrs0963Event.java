/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_TRS_963Event.java
*@FileTitle : Bundling
*Open Issues :
*Change history :
*@LastModifyDate : 2011-04-11
*@LastModifier : Kim Young Chul
*@LastVersion : 1.1
* 1.0 최초 생성
* --------------------------------------------------------
* History
* 2011.07.14 김영철 [CHM-201110224] [TRS] Flat rack CNTR Bundling 기능 추가요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.event;

import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.vo.BundlingListVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;


/**
 * ESD_TRS_963 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_963HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim_sang_geun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class EsdTrs0963Event extends EventSupport {
	
	private TrsTrspSvcOrdVO trsTrspSvcOrdVO = null;
	
	private TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs = null;
	
	private BundlingListVO bundlingListVO = null;
	
	private BundlingListVO[] bundlingListVOs = null;

	private String [] ibflag = null;
	private String [] trspSoOfcCtyCd = null;
	private String [] trspSoSeq = null;
	
	public EsdTrs0963Event(){}

	public String getEventName() {
		return "EsdTrs0963Event";
	}

	public String toString() {
		return "EsdTrs0963Event";
	}

	public void setIbflag(String [] ibflag) {
		this.ibflag = ibflag;
	}

	public String [] getIbflag() {
		return ibflag;
	}

	public void setTrspSoOfcCtyCd(String [] trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}

	public String [] getTrspSoOfcCtyCd() {
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

	public BundlingListVO[] getBundlingListVOs() {
		return bundlingListVOs;
	}

	public void setBundlingListVOs(BundlingListVO[] bundlingListVOs) {
		this.bundlingListVOs = bundlingListVOs;
	}

	public BundlingListVO getBundlingListVO() {
		return bundlingListVO;
	}

	public void setBundlingListVO(BundlingListVO bundlingListVO) {
		this.bundlingListVO = bundlingListVO;
	}
}
