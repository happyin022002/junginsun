/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsmCoa0014Event.java
*@FileTitle : US domestic cost/credit 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.16
*@LastModifier : 김보배
*@LastVersion : 1.0 
* 2012.10.16 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.common.event;

import com.clt.apps.opus.esm.coa.common.vo.AverageCostVO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_0014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author BOBAE KIM
 * @see ESM_COA_0014HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa4011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 입력 Data 처리 */
	private AverageCostVO averageCostVO = null;
	private AverageCostVO[] averageCostVOs = null;
	
	private String key = "";

	public EsmCoa4011Event(){}
	


	public AverageCostVO getAverageCostVO() {
		return averageCostVO;
	}

	public void setAverageCostVO(AverageCostVO averageCostVO) {
		this.averageCostVO = averageCostVO;
	}
	
	//SJH.20150507.소스품질
	public AverageCostVO[] getAverageCostVOs() {
		AverageCostVO[] rtnVOs = null;
		if (this.averageCostVOs != null) {
			rtnVOs = Arrays.copyOf(averageCostVOs, averageCostVOs.length);
		}
		return rtnVOs;
	}
	//SJH.20150507.소스품질
	public void setAverageCostVOs(AverageCostVO[] averageCostVOs){
		if(averageCostVOs != null){
			AverageCostVO[] tmpVOs = Arrays.copyOf(averageCostVOs, averageCostVOs.length);
			this.averageCostVOs = tmpVOs;
		}
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}