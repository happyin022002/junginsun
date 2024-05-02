/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0052Event.java
*@FileTitle : Confirmation and Distribution
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2009.09.28 주선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotarelease.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SaqMonQtaRlseTrdVO;
import com.clt.syscommon.common.table.SaqMonQtaRlseVO;
 

/**
 * ESM_SAQ_0052 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0052HTMLAction에서 작성<br> 
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ju Sun Young
 * @see ESM_SAQ_0052HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0052Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    private String  year ="";
    private String  quarter ="";
    private String  ofcCd ="";
    private String  mqtaRlseVerNo ="";
    private String  isNewVersion ="";
    
    
    private SaqMonQtaRlseVO saqMonQtaRlseVO = null;
    private SaqMonQtaRlseTrdVO saqMonQtaRlseTrdVO = null;
    private SaqMonQtaRlseTrdVO[] saqMonQtaRlseTrdVOs = null;
    
	private QuotaConditionVO quotaConditionVO = null;
	private QuotaConditionVO[] quotaConditionVOs = null;
    
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getQuarter() {
		return quarter;
	}
	
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	
	public String getOfcCd() {
		return ofcCd;
	}
	
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	public String getMqtaRlseVerNo() {
		return mqtaRlseVerNo;
	}
	
	public void setMqtaRlseVerNo(String mqtaRlseVerNo) {
		this.mqtaRlseVerNo = mqtaRlseVerNo;
	}
	
	public String getIsNewVersion() {
		return isNewVersion;
	}
	
	public void setIsNewVersion(String isNewVersion) {
		this.isNewVersion = isNewVersion;
	}
	
	public SaqMonQtaRlseVO getSaqMonQtaRlseVO() {
		return saqMonQtaRlseVO;
	}
	
	public void setSaqMonQtaRlseVO(SaqMonQtaRlseVO saqMonQtaRlseVO) {
		this.saqMonQtaRlseVO = saqMonQtaRlseVO;
	}
	
	public SaqMonQtaRlseTrdVO getSaqMonQtaRlseTrdVO() {
		return saqMonQtaRlseTrdVO;
	}
	
	public void setSaqMonQtaRlseTrdVO(SaqMonQtaRlseTrdVO saqMonQtaRlseTrdVO) {
		this.saqMonQtaRlseTrdVO = saqMonQtaRlseTrdVO;
	}
	
	public SaqMonQtaRlseTrdVO[] getSaqMonQtaRlseTrdVOs() {
		SaqMonQtaRlseTrdVO[] rtnVOs = null;
		if (this.saqMonQtaRlseTrdVOs != null) {
			rtnVOs = Arrays.copyOf(saqMonQtaRlseTrdVOs, saqMonQtaRlseTrdVOs.length);
		}
		return rtnVOs;
	}
	
	public void setSaqMonQtaRlseTrdVOs(SaqMonQtaRlseTrdVO[] saqMonQtaRlseTrdVOs) {
		if(saqMonQtaRlseTrdVOs != null){
			SaqMonQtaRlseTrdVO[] tmpVOs = Arrays.copyOf(saqMonQtaRlseTrdVOs, saqMonQtaRlseTrdVOs.length);
			this.saqMonQtaRlseTrdVOs  = tmpVOs;
		}
	}
	
	public QuotaConditionVO getQuotaConditionVO() {
		return quotaConditionVO;
	}
	
	public void setQuotaConditionVO(QuotaConditionVO quotaConditionVO) {
		this.quotaConditionVO = quotaConditionVO;
	}
	
	public QuotaConditionVO[] getQuotaConditionVOs() {
		QuotaConditionVO[] rtnVOs = null;
		if (this.quotaConditionVOs != null) {
			rtnVOs = Arrays.copyOf(quotaConditionVOs, quotaConditionVOs.length);
		}
		return rtnVOs;
	}
	
	public void setQuotaConditionVOs(QuotaConditionVO[] quotaConditionVOs) {
		if(quotaConditionVOs != null){
			QuotaConditionVO[] tmpVOs = Arrays.copyOf(quotaConditionVOs, quotaConditionVOs.length);
			this.quotaConditionVOs  = tmpVOs;
		}
	}
}