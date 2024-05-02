/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0003Event.java
*@FileTitle : Inquiry of Vendor / Customer Code
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.18 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event;

import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarrierVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0003HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsJoo0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CarrierVO carrierVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CarrierVO[] carrierVOs = null;

	public FnsJoo0003Event(){}
	
	public void setCarrierVO(CarrierVO carrierVO){
		this. carrierVO = carrierVO;
	}

	public void setCarrierVOS(CarrierVO[] carrierVOs){
		if (carrierVOs != null) {
			CarrierVO[] tmpVOs = new CarrierVO[carrierVOs.length];
			System.arraycopy(carrierVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.carrierVOs = tmpVOs;
		}
	}

	public CarrierVO getCarrierVO(){
		return carrierVO;
	}

	public CarrierVO[] getCarrierVOS(){
		CarrierVO[] tmpVOs = null;
		if (this.carrierVOs != null) {
			tmpVOs = new CarrierVO[carrierVOs.length];
			System.arraycopy(carrierVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}