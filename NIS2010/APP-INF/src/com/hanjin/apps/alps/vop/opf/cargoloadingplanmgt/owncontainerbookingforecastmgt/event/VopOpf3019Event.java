/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf3019Event.java
*@FileTitle : Weight Group (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.05.11 이선영
* 1.0 Creation
* 2011.12.15 김민아 [CHM-201115274-01] [VOP-OPF] Weight Group code 일괄 Update 요청
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event;

import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CargoBookingForecastVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.ComComboVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.OpfCgoBkgFcastWgtGrpVO;


/**
 * VOP_OPF-3019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF-3019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sunyoung
 * @see VOP_OPF-3019HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopOpf3019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CargoBookingForecastVO cargoBookingForecastVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CargoBookingForecastVO[] cargoBookingForecastVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfCgoBkgFcastWgtGrpVO opfCgoBkgFcastWgtGrpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OpfCgoBkgFcastWgtGrpVO[] opfCgoBkgFcastWgtGrpVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComComboVO comComboVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ComComboVO[] comComboVOs = null;

	public VopOpf3019Event(){}
	
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

	public void setComComboVO(ComComboVO comComboVO) {
		this.comComboVO = comComboVO;
	}

	public void setComComboVOs(ComComboVO[] comComboVOs) {
		if (comComboVOs != null) {
			ComComboVO[] tmpVOs = new ComComboVO[comComboVOs.length];
			System.arraycopy(comComboVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.comComboVOs = tmpVOs;
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

	public ComComboVO getComComboVO() {
		return comComboVO;
	}

	public ComComboVO[] getComComboVOs() {
	 	ComComboVO[] rtnVOs = null;
		
		if (this.comComboVOs != null) {
			rtnVOs = new ComComboVO[comComboVOs.length];
			System.arraycopy(comComboVOs, 0, rtnVOs, 0, rtnVOs.length);
		}		
		return rtnVOs;
	}

}