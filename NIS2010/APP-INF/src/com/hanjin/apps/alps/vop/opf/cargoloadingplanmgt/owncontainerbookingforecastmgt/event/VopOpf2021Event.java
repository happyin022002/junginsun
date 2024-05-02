/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf2021Event.java
*@FileTitle : Weight Group (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.05.11 우지석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event;

import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFSpecialStwgVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFSummaryVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CargoBookingForecastVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.OpfCgoBkgFcastWgtGrpVO;


/**
 * VOP_OPF-2021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF-2021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sunyoung
 * @see VOP_OPF-2021HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopOpf2021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CargoBookingForecastVO cargoBookingForecastVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CargoBookingForecastVO[] cargoBookingForecastVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfCgoBkgFcastWgtGrpVO opfCgoBkgFcastWgtGrpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OpfCgoBkgFcastWgtGrpVO[] opfCgoBkgFcastWgtGrpVOs = null;

	public VopOpf2021Event(){}
	
	public void setCargoBookingForecastVO(CargoBookingForecastVO cargoBookingForecastVO){
		this. cargoBookingForecastVO = cargoBookingForecastVO;
	}

	public void setCargoBookingForecastVOS(CargoBookingForecastVO[] cargoBookingForecastVOs){
		if (cargoBookingForecastVOs != null) {
			CargoBookingForecastVO[] tmpVOs = new CargoBookingForecastVO[cargoBookingForecastVOs.length];
			System.arraycopy(cargoBookingForecastVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cargoBookingForecastVOs = tmpVOs;
		}			
	}

	public void setOpfCgoBkgFcastWgtGrpVO(OpfCgoBkgFcastWgtGrpVO opfCgoBkgFcastWgtGrpVO){
		this. opfCgoBkgFcastWgtGrpVO = opfCgoBkgFcastWgtGrpVO;
	}

	public void setOpfCgoBkgFcastWgtGrpVOS(OpfCgoBkgFcastWgtGrpVO[] opfCgoBkgFcastWgtGrpVOs){
		if (opfCgoBkgFcastWgtGrpVOs != null) {
			OpfCgoBkgFcastWgtGrpVO[] tmpVOs = new OpfCgoBkgFcastWgtGrpVO[opfCgoBkgFcastWgtGrpVOs.length];
			System.arraycopy(opfCgoBkgFcastWgtGrpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfCgoBkgFcastWgtGrpVOs = tmpVOs;
		}
	}

	public CargoBookingForecastVO getCargoBookingForecastVO(){
		return cargoBookingForecastVO;
	}

	public CargoBookingForecastVO[] getCargoBookingForecastVOS(){
		CargoBookingForecastVO[] rtnVOs = null;
		
		if (this.cargoBookingForecastVOs != null) {
			rtnVOs = new CargoBookingForecastVO[cargoBookingForecastVOs.length];
			System.arraycopy(cargoBookingForecastVOs, 0, rtnVOs, 0, rtnVOs.length);
		}		
		return rtnVOs;	
	}

	public OpfCgoBkgFcastWgtGrpVO getOpfCgoBkgFcastWgtGrpVO(){
		return opfCgoBkgFcastWgtGrpVO;
	}

	public OpfCgoBkgFcastWgtGrpVO[] getOpfCgoBkgFcastWgtGrpVOS(){
		OpfCgoBkgFcastWgtGrpVO[] rtnVOs = null;
		
		if (this.opfCgoBkgFcastWgtGrpVOs != null) {
			rtnVOs = new OpfCgoBkgFcastWgtGrpVO[opfCgoBkgFcastWgtGrpVOs.length];
			System.arraycopy(opfCgoBkgFcastWgtGrpVOs, 0, rtnVOs, 0, rtnVOs.length);
		}		
		return rtnVOs;	
	}

}