/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmBkg1508Event.java
*@FileTitle : EsmBkg1508Event
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.14
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2014.05.14 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChinaVslRgstVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1508에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1508HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_BKG_1508HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1508Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChinaVslRgstVO chinaVslRgstVO = null;

	/** Table Value Object Multi Data 처리 */
	private ChinaVslRgstVO[] chinaVslRgstVOs = null;

	public EsmBkg1508Event() {}

	public ChinaVslRgstVO getChinaVslRgstVO() {
		return chinaVslRgstVO;
	}

	public void setChinaVslRgstVO(ChinaVslRgstVO chinaVslRgstVO) {
		this.chinaVslRgstVO = chinaVslRgstVO;
	}

	public ChinaVslRgstVO[] getChinaVslRgstVOs() {
		return chinaVslRgstVOs;
	}

	public void setChinaVslRgstVOs(ChinaVslRgstVO[] chinaVslRgstVOs) {
		this.chinaVslRgstVOs = chinaVslRgstVOs;
	}

}