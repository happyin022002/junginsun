/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GuaranteecommonEvent.java
*@FileTitle : GuaranteeCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.22 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.guaranteecommon.event;

import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesGnteCntrListVO;
import com.hanjin.syscommon.common.table.TesGnteHdrVO;
import com.hanjin.syscommon.common.table.TesIrrHdrVO;


/**
 * GuaranteeCommon 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  GuaranteeCommonHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author yOng hO lEE
 * @see GuaranteeCommonHTMLAction 참조
 * @since J2EE 1.6
 */
public class GuaranteeCommonEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TesIrrHdrVO 					tesIrrHdrVO			= null;
	private TesGnteHdrVO 					tesGnteHdrVO		= null;
	private TesGnteCntrListVO				tesGnteCntrListVO	= null;
	private GuaranteeCommonVO				guaranteeCommonVO	= null;

	
	/** Table Value Object Multi Data 처리 */
	private TesIrrHdrVO[] 					tesIrrHdrVOs		= null;
	private TesGnteHdrVO[] 					tesGnteHdrVOs		= null;
	private TesGnteCntrListVO[]				tesGnteCntrListVOs	= null;
	private GuaranteeCommonVO[]				guaranteeCommonVOs	= null;

	public GuaranteeCommonEvent(){}

	public TesIrrHdrVO getTesIrrHdrVO() {
		return tesIrrHdrVO;
	}

	public void setTesIrrHdrVO(TesIrrHdrVO tesIrrHdrVO) {
		this.tesIrrHdrVO = tesIrrHdrVO;
	}

	public TesGnteHdrVO getTesGnteHdrVO() {
		return tesGnteHdrVO;
	}

	public void setTesGnteHdrVO(TesGnteHdrVO tesGnteHdrVO) {
		this.tesGnteHdrVO = tesGnteHdrVO;
	}

	public TesGnteCntrListVO getTesGnteCntrListVO() {
		return tesGnteCntrListVO;
	}

	public void setTesGnteCntrListVO(TesGnteCntrListVO tesGnteCntrListVO) {
		this.tesGnteCntrListVO = tesGnteCntrListVO;
	}

	public GuaranteeCommonVO getGuaranteeCommonVO() {
		return guaranteeCommonVO;
	}

	public void setGuaranteeCommonVO(GuaranteeCommonVO guaranteeCommonVO) {
		this.guaranteeCommonVO = guaranteeCommonVO;
	}

	public TesIrrHdrVO[] getTesIrrHdrVOs() {
		return tesIrrHdrVOs;
	}

	public void setTesIrrHdrVOs(TesIrrHdrVO[] tesIrrHdrVOs) {
		this.tesIrrHdrVOs = tesIrrHdrVOs;
	}

	public TesGnteHdrVO[] getTesGnteHdrVOs() {
		return tesGnteHdrVOs;
	}

	public void setTesGnteHdrVOs(TesGnteHdrVO[] tesGnteHdrVOs) {
		this.tesGnteHdrVOs = tesGnteHdrVOs;
	}

	public TesGnteCntrListVO[] getTesGnteCntrListVOs() {
		return tesGnteCntrListVOs;
	}

	public void setTesGnteCntrListVOs(TesGnteCntrListVO[] tesGnteCntrListVOs) {
		this.tesGnteCntrListVOs = tesGnteCntrListVOs;
	}

	public GuaranteeCommonVO[] getGuaranteeCommonVOs() {
		return guaranteeCommonVOs;
	}

	public void setGuaranteeCommonVOs(GuaranteeCommonVO[] guaranteeCommonVOs) {
		this.guaranteeCommonVOs = guaranteeCommonVOs;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}


}