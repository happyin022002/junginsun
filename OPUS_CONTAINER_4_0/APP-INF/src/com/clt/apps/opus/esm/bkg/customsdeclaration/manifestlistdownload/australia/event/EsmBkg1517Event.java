/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmBkg1517Event.java
*@FileTitle : EsmBkg1517Event
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusResultCuscarVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusSearchCuscarVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1517에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1517HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_BKG_1517HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1517Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AusSearchCuscarVO ausSearchCuscarVO = null;

	/** Table Value Object 단건 및 Multi Data 처리 */
	private AusResultCuscarVO[] ausResultCuscarVOs = null;

	public EsmBkg1517Event() {}

	public AusSearchCuscarVO getAusSearchCuscarVO() {
		return ausSearchCuscarVO;
	}

	public void setAusSearchCuscarVO(AusSearchCuscarVO ausSearchCuscarVO) {
		this.ausSearchCuscarVO = ausSearchCuscarVO;
	}

	public AusResultCuscarVO[] getAusResultCuscarVOs() {
		AusResultCuscarVO[] rtnVOs = null;
		if (this.ausResultCuscarVOs != null) {
			rtnVOs = Arrays.copyOf(ausResultCuscarVOs, ausResultCuscarVOs.length);
		}
		return rtnVOs;
	}

	public void setAusResultCuscarVOs(AusResultCuscarVO[] ausResultCuscarVOs) {
		if (ausResultCuscarVOs != null) {
			AusResultCuscarVO[] tmpVOs = Arrays.copyOf(ausResultCuscarVOs, ausResultCuscarVOs.length);
			this.ausResultCuscarVOs = tmpVOs;
		}
	}

}

