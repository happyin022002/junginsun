/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmBkg1501Event.java
*@FileTitle : EsmBkg1501Event
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.28
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.06.28 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoHeaderVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1501에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1501HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_BKG_1501HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1501Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 단건 처리  */
	private CargoInfoHeaderVO cargoInfoHeaderVO = null;

	/** Table Value Object 단건 및 Multi Data 처리 */
	private CargoInfoDetailVO[] cargoInfoDetailVOs = null;



	public EsmBkg1501Event() {}



	public CargoInfoHeaderVO getCargoInfoHeaderVO() {
		return cargoInfoHeaderVO;
	}


	public void setCargoInfoHeaderVO(CargoInfoHeaderVO cargoInfoHeaderVO) {
		this.cargoInfoHeaderVO = cargoInfoHeaderVO;
	}


	public CargoInfoDetailVO[] getCargoInfoDetailVOs() {
		return cargoInfoDetailVOs;
	}


	public void setCargoInfoDetailVOs(CargoInfoDetailVO[] cargoInfoDetailVOs) {
		this.cargoInfoDetailVOs = cargoInfoDetailVOs;
	}

}