/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0039Event.java
*@FileTitle : S/P Performance Evaluation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.08
*@LastModifier : 최 선 
*@LastVersion : 1.1 
* 2006.11.27 juhyun
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2010.11.09 최 선     1.1 [CHM-201006928] Performance Evaluation Save 후, 불필요한 재조회 프로세스 제외 처리
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry.spperformancevaluation.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TrsTrspVndrPerfEvVO;


/**
 * ESD_TRS_0039 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_039HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author juhyun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0039Event extends EventSupport {
	private TrsTrspVndrPerfEvVO trsTrspVndrPerfEvVO = null;
	private TrsTrspVndrPerfEvVO[] trsTrspVndrPerfEvVOs = null;
	
	private String wonumber = null;
	private String hidCreDt = null;
	private String hidCreUsrId = null;
	private String hidCreOfcCd = null;
	private String hidPeriod = null;
	private String hidFromDate = null;
	private String hidToDate = null;
	private String hidProvider = null;	
	private String trspWoOfcCtyCd = null;
	private String trspWoSeq = null;
	public String getHidCreDt() {
		return hidCreDt;
	}

	public void setHidCreDt(String hidCreDt) {
		this.hidCreDt = hidCreDt;
	}

	public String getHidCreUsrId() {
		return hidCreUsrId;
	}

	public void setHidCreUsrId(String hidCreUsrId) {
		this.hidCreUsrId = hidCreUsrId;
	}

	public String getHidCreOfcCd() {
		return hidCreOfcCd;
	}

	public void setHidCreOfcCd(String hidCreOfcCd) {
		this.hidCreOfcCd = hidCreOfcCd;
	}

	public String getHidPeriod() {
		return hidPeriod;
	}

	public void setHidPeriod(String hidPeriod) {
		this.hidPeriod = hidPeriod;
	}

	public String getHidFromDate() {
		return hidFromDate;
	}

	public void setHidFromDate(String hidFromDate) {
		this.hidFromDate = hidFromDate;
	}

	public String getHidToDate() {
		return hidToDate;
	}

	public void setHidToDate(String hidToDate) {
		this.hidToDate = hidToDate;
	}

	public String getHidProvider() {
		return hidProvider;
	}

	public void setHidProvider(String hidProvider) {
		this.hidProvider = hidProvider;
	}

	public String getWonumber() {
		return wonumber;
	}

	public void setWonumber(String wonumber) {
		this.wonumber = wonumber;
	}	
	
	public String getTrspWoOfcCtyCd() {
		return trspWoOfcCtyCd;
	}

	public void setTrspWoOfcCtyCd(String trspWoOfcCtyCd) {
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
	}	
	
	public String getTrspWoSeq() {
		return trspWoSeq;
	}

	public void setTrspWoSeq(String trspWoSeq) {
		this.trspWoSeq = trspWoSeq;
	}	
	
	public TrsTrspVndrPerfEvVO getTrsTrspVndrPerfEvVO() {
		return trsTrspVndrPerfEvVO;
	}

	public void setTrsTrspVndrPerfEvVO(TrsTrspVndrPerfEvVO trsTrspVndrPerfEvVO) {
		this.trsTrspVndrPerfEvVO = trsTrspVndrPerfEvVO;
	}

	public TrsTrspVndrPerfEvVO[] getTrsTrspVndrPerfEvVOs() {
		return trsTrspVndrPerfEvVOs;
	}

	public void setTrsTrspVndrPerfEvVOs(TrsTrspVndrPerfEvVO[] trsTrspVndrPerfEvVOs) {
		this.trsTrspVndrPerfEvVOs = trsTrspVndrPerfEvVOs;
	}
	

	/** getEventName */
	public String getEventName() {
		return "EsdTrs0039Event";
	}

	/** toString */
	public String toString() {
		return "EsdTrs0039Event";
	}

}
