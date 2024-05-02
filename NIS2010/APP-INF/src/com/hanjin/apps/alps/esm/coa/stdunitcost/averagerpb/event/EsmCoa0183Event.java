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
package com.hanjin.apps.alps.esm.coa.stdunitcost.averagerpb.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.coa.stdunitcost.averagerpb.vo.AverageRPBVO;



/**
 * ESM_COA_0014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author BOBAE KIM
 * @see ESM_COA_0014HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0183Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 입력 Data 처리 */
	private AverageRPBVO averageRPBVO = null;
	private AverageRPBVO[] averageRPBVOs = null;
	
	private String key = "";

	public EsmCoa0183Event(){}
	


	public AverageRPBVO getAverageRPBVO() {
		return averageRPBVO;
	}

	public void setAverageRPBVO(AverageRPBVO averageRPBVO) {
		this.averageRPBVO = averageRPBVO;
	}

	

	public AverageRPBVO[] getAverageRPBVOs() {
		return averageRPBVOs;
	}

	public void setAverageRPBVOs(AverageRPBVO[] averageRPBVOs) {
		this.averageRPBVOs = averageRPBVOs;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}