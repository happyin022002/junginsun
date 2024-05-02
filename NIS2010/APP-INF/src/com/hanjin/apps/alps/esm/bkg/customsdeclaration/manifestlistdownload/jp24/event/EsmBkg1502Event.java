/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmBkg1502Event.java
*@FileTitle : EsmBkg1502Event
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.05
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.07.05 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpMarkDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.GetMdmCustomerVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1502에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1502HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_BKG_1502HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1502Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AdvJpBlVO advJpBlVO = null;
	private GetMdmCustomerVO getMdmCustomerVO = null;

	/** Table Value Object Multi Data 처리 */
	private AdvJpContainerVO[] advJpContainerVOs = null;
	private AdvJpMarkDescVO[] advJpMarkDescVOs = null;


	public EsmBkg1502Event() {}


	public AdvJpBlVO getAdvJpBlVO() {
		return advJpBlVO;
	}

	public void setAdvJpBlVO(AdvJpBlVO advJpBlVO) {
		this.advJpBlVO = advJpBlVO;
	}

	public GetMdmCustomerVO getGetMdmCustomerVO() {
		return getMdmCustomerVO;
	}

	public void setGetMdmCustomerVO(GetMdmCustomerVO getMdmCustomerVO) {
		this.getMdmCustomerVO = getMdmCustomerVO;
	}

	public AdvJpContainerVO[] getAdvJpContainerVOs() {
		return advJpContainerVOs;
	}

	public void setAdvJpContainerVOs(
			AdvJpContainerVO[] advJpContainerVOs) {
		this.advJpContainerVOs = advJpContainerVOs;
	}

	public AdvJpMarkDescVO[] getAdvJpMarkDescVOs() {
		return advJpMarkDescVOs;
	}

	public void setAdvJpMarkDescVOs(AdvJpMarkDescVO[] advJpMarkDescVOs) {
		this.advJpMarkDescVOs = advJpMarkDescVOs;
	}

}