/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsmMas0014Event.java
*@FileTitle : US domestic cost/credit 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.16
*@LastModifier : 김보배
*@LastVersion : 1.0 
* 2012.10.16 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.averagerpb.event;

import com.hanjin.apps.alps.esm.mas.stdunitcost.averagerpb.vo.AverageRPBVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.event.ESM_MAS_0014HTMLAction;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.AverageUCVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ESM_MAS_0014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author BOBAE KIM
 * @see ESM_MAS_0014HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0184Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 입력 Data 처리 */
	private AverageUCVO averageUCVO = null;
	private AverageRPBVO averageRPBVO = null;
	private AverageRPBVO[] averageRPBVOs = null;
	
	private String key = "";

	public EsmMas0184Event(){}
	

	

	/**
	 * @return the averageUCVO
	 */
	public AverageUCVO getAverageUCVO() {
		return averageUCVO;
	}




	/**
	 * @param averageUCVO the averageUCVO to set
	 */
	public void setAverageUCVO(AverageUCVO averageUCVO) {
		this.averageUCVO = averageUCVO;
	}




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