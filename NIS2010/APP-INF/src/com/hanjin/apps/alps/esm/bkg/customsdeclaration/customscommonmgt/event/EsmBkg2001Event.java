/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmBkg2001Event.java
*@FileTitle : Customs Common Code
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsCdConvVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ESM_BKG_2001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_2001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_BKG_2001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg2001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstmsCdConvVO cstmsCdConvVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CstmsCdConvVO[] cstmsCdConvVOs = null;
	
	public CstmsCdConvVO getCstmsCdConvVO() {
		return cstmsCdConvVO;
	}

	public void setCstmsCdConvVO(CstmsCdConvVO searchCstmsCdConvVO) {
		this.cstmsCdConvVO= searchCstmsCdConvVO;
	}

	public CstmsCdConvVO[] getCstmsCdConvVOs() {
		return cstmsCdConvVOs;
	}

	public void setCstmsCdConvVOs(CstmsCdConvVO[] cstmsCdConvVOs) {
		this.cstmsCdConvVOs = cstmsCdConvVOs;
	}
	
}