/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0157Event.java
*@FileTitle : COD Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.23 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.event;

import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodStsInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodStsVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0157 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0157HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0157HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0157Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CodStsVO codStsVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CodStsVO[] codStsVOs = null;
	
	private CodStsInputVO codStsInputVO = null;
	private CodStsInputVO[] codStsInputVOs = null;
	
	public EsmBkg0157Event(){}

	public CodStsVO getCodStsVO() {
		return codStsVO;
	}



	public void setCodStsHisVO(CodStsVO codStsVO) {
		this.codStsVO = codStsVO;
	}



	public CodStsVO[] getCodStsVOs() {
		return codStsVOs;
	}



	public void setCodStsVOs(CodStsVO[] codStsVOs) {
		this.codStsVOs = codStsVOs;
	}



	public CodStsInputVO getCodStsInputVO() {
		return codStsInputVO;
	}

	public void setCodStsInputVO(CodStsInputVO codStsInputVO) {
		this.codStsInputVO = codStsInputVO;
	}

	public CodStsInputVO[] getCodStsInputVOs() {
		return codStsInputVOs;
	}

	public void setCodStsInputVOs(CodStsInputVO[] codStsInputVOs) {
		this.codStsInputVOs = codStsInputVOs;
	}
	
}