/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmBkg1506Event.java
*@FileTitle : EsmBkg1506Event
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.03
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.12.03 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.FlatFileVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1506에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1506HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_BKG_1506HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1506Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private FlatFileVO flatFileVO = null;

	public EsmBkg1506Event() {}

	public FlatFileVO getFlatFileVO() {
		return flatFileVO;
	}

	public void setFlatFileVO(FlatFileVO flatFileVO) {
		this.flatFileVO = flatFileVO;
	}

}
