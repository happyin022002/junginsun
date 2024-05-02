/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmBkg1501Event.java
*@FileTitle : EsmBkg1501Event
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.28
*@LastModifier :
*@LastVersion : 1.0
* 2013.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoHeaderVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1501에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1501HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_BKG_1501HTMLAction 참조
 * @since J2EE 1.6
 */

@SuppressWarnings("serial")
public class EsmBkg1501Event extends EventSupport {

	/** Table Value Object 조회 조건 단건 처리  */
	private CargoInfoHeaderVO cargoInfoHeaderVO = null;
	private CargoInfoDetailVO cargoInfoDetailVO = null;

	/** Table Value Object 저장 및 Multi Data 처리 */
	private CargoInfoDetailVO[] cargoInfoDetailVOs = null;

	public EsmBkg1501Event() {}

	public CargoInfoHeaderVO getCargoInfoHeaderVO() {
		return cargoInfoHeaderVO;
	}

	public void setCargoInfoHeaderVO(CargoInfoHeaderVO cargoInfoHeaderVO) {
		this.cargoInfoHeaderVO = cargoInfoHeaderVO;
	}

	public CargoInfoDetailVO getCargoInfoDetailVO() {
		return cargoInfoDetailVO;
	}

	public void setCargoInfoDetailVO(CargoInfoDetailVO cargoInfoDetailVO) {
		this.cargoInfoDetailVO = cargoInfoDetailVO;
	}

	public CargoInfoDetailVO[] getCargoInfoDetailVOs() {
		CargoInfoDetailVO[] rtnVOs = null;
		if (this.cargoInfoDetailVOs != null) {
			rtnVOs = Arrays.copyOf(cargoInfoDetailVOs, cargoInfoDetailVOs.length);
		}
		return rtnVOs;
	}

	public void setCargoInfoDetailVOs(CargoInfoDetailVO[] cargoInfoDetailVOs) {
		if (cargoInfoDetailVOs != null) {
			CargoInfoDetailVO[] tmpVOs = Arrays.copyOf(cargoInfoDetailVOs, cargoInfoDetailVOs.length);
			this.cargoInfoDetailVOs = tmpVOs;
		}
	}

}