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
package com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsCdConvVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsPckTpConvVO;
import com.clt.framework.support.layer.event.EventSupport;



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
		CstmsPckTpConvVO[] rtnVOs = null;
		if (this.cstmsPckTpConvVOs != null) {
			rtnVOs = Arrays.copyOf(cstmsPckTpConvVOs, cstmsPckTpConvVOs.length);
		}
		return rtnVOs;
	}

	public void setCstmsPckTpConvVOs(CstmsPckTpConvVO[] cstmsPckTpConvVOs) {
		if (cstmsPckTpConvVOs != null) {
			CstmsPckTpConvVO[] tmpVOs = Arrays.copyOf(cstmsPckTpConvVOs, cstmsPckTpConvVOs.length);
			this.cstmsPckTpConvVOs = tmpVOs;
		}
	}

	private CstmsCdConvVO cstmsCdConvVO = null;

	public CstmsCdConvVO getCstmsCdConvVO() {
		return cstmsCdConvVO;
	}

	public void setCstmsCdConvVO(CstmsCdConvVO searchCstmsCdConvVO) {
		this.cstmsCdConvVO= searchCstmsCdConvVO;
	}

}