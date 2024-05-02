/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EsmFms0098Event.java
*@FileTitle : Off-Hire Expenses
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.29
*@LastModifier : 채창호
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomSdmsSettlementVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.FrgnExchangeVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.FrgnExchangeTransactionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/** 
 * ESM_FMS_0014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JUNGYOONTAE
 * @see ESM_FMS_0014HTMLAction 참조
 * @since J2EE 1.5 
 */

public class EsmFms0098Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FrgnExchangeTransactionVO frgnExchangeTransactionVO = null;
	private FrgnExchangeVO[] frgnExchangeVOs = null;
	
	public EsmFms0098Event(){}
	
	public FrgnExchangeTransactionVO getFrgnExchangeTransactionVO() {
		return frgnExchangeTransactionVO;
	}

	public void setFrgnExchangeTransactionVO(
			FrgnExchangeTransactionVO frgnExchangeTransactionVO) {
		this.frgnExchangeTransactionVO = frgnExchangeTransactionVO;
	}

	
	public FrgnExchangeVO[] getFrgnExchangeVOS(){
		FrgnExchangeVO[] rtnVOs = null;
		if (this.frgnExchangeVOs != null) {
			rtnVOs = Arrays.copyOf(frgnExchangeVOs, frgnExchangeVOs.length);
		}
		return rtnVOs;
	}
	
	public void setFrgnExchangeVOS(FrgnExchangeVO[] frgnExchangeVOs){
		if (frgnExchangeVOs != null) {
			FrgnExchangeVO[] tmpVOs = Arrays.copyOf(frgnExchangeVOs, frgnExchangeVOs.length);
			this.frgnExchangeVOs = tmpVOs;
		}
	}
}
