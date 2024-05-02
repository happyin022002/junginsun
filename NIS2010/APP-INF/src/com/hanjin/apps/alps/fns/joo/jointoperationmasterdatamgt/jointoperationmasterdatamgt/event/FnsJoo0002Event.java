/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0002Event.java
*@FileTitle : Entry and Inquiry of Financial Affairs
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.04.28 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarFinanMtrxGrpVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarFinanMtrxVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarrierVO;


/**
 * UI_JOO_0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_JOO_0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0002HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsJoo0002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CarFinanMtrxVO carFinanMtrxVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CarFinanMtrxVO[] carFinanMtrxVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CarrierVO carrierVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CarrierVO[] carrierVOs = null;
	
	private CarFinanMtrxGrpVO carFinanMtrxGrpVO = new CarFinanMtrxGrpVO(); 

	public FnsJoo0002Event(){}
	
	public void setCarFinanMtrxVO(CarFinanMtrxVO carFinanMtrxVO){
		this. carFinanMtrxVO = carFinanMtrxVO;
	}

	public void setCarFinanMtrxVOS(CarFinanMtrxVO[] carFinanMtrxVOs){
		if (carFinanMtrxVOs != null) {
			CarFinanMtrxVO[] tmpVOs = new CarFinanMtrxVO[carFinanMtrxVOs.length];
			System.arraycopy(carFinanMtrxVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.carFinanMtrxVOs = tmpVOs;
		}		
	}

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

	public CarFinanMtrxVO getCarFinanMtrxVO(){
		return carFinanMtrxVO;
	}

	public CarFinanMtrxVO[] getCarFinanMtrxVOS(){
		CarFinanMtrxVO[] rtnVOs = null;
		if (this.carFinanMtrxVOs != null) {
			rtnVOs = new CarFinanMtrxVO[carFinanMtrxVOs.length];
			System.arraycopy(carFinanMtrxVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
		
	}

	public CarrierVO getCarrierVO(){
		return carrierVO;
	}

	public CarrierVO[] getCarrierVOS(){
		CarrierVO[] rtnVOs = null;
		if (this.carrierVOs != null) {
			rtnVOs = new CarrierVO[carrierVOs.length];
			System.arraycopy(carrierVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}
	
	public void setCarFinanMtrxGrpVO(CarFinanMtrxVO[] pCarFinanMtrxVOs, String reDivrCd){
		List<CarFinanMtrxVO> listVOs = new ArrayList<CarFinanMtrxVO>();
		
		if (pCarFinanMtrxVOs != null){
			for(int inx=0; inx<pCarFinanMtrxVOs.length; inx++){
				listVOs.add(pCarFinanMtrxVOs[inx]);
			}
		}
		if ("R".equals(reDivrCd)){
			carFinanMtrxGrpVO.setRCarFinanMtrxVOs(listVOs);
		}else{
			carFinanMtrxGrpVO.setECarFinanMtrxVOs(listVOs);
		}
	}
	
	public void setCarFinanMtrxGrpVO(CarrierVO carrierVO){
		carFinanMtrxGrpVO.setCarrierVO(carrierVO);
	}
	
	public CarFinanMtrxGrpVO getCarFinanMtrxGrpVO(){
		return carFinanMtrxGrpVO;
	}

}