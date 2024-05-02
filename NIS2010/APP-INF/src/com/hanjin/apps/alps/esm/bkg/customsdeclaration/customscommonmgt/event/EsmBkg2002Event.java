/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmBkg2002Event.java
*@FileTitle : Customs Package Type Code Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.13
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.04.13 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsPckTpConvVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ESM_BKG_2002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_2002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_BKG_2002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg2002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstmsPckTpConvVO cstmsPckTpConvVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CstmsPckTpConvVO[] cstmsPckTpConvVOs = null;
	
	public CstmsPckTpConvVO getCstmsPckTpConvVO() {
		return cstmsPckTpConvVO;
	}

	public void setCstmsPckTpConvVO(CstmsPckTpConvVO searchCstmsPckTpConvVO) {
		this.cstmsPckTpConvVO = searchCstmsPckTpConvVO;
	}

	public CstmsPckTpConvVO[] getCstmsPckTpConvVOs() {
		return cstmsPckTpConvVOs;
	}

	public void setCstmsPckTpConvVOs(CstmsPckTpConvVO[] cstmsPckTpConvVOs) {
		this.cstmsPckTpConvVOs = cstmsPckTpConvVOs;
	}

}