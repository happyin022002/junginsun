/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes2002Event.java
*@FileTitle : Guarantee Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.14 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.event;

import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesGnteHdrVO;


/**
 * ESD_TES_2002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TES_2002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author yOng hO lEE
 * @see ESD_TES_2002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTes2002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private GuaranteeCommonVO	guaranteeCommonVO	= null;
	private TesGnteHdrVO		tesGnteHdrVO		= null;
	
	/** Table Value Object Multi Data 처리 */
	private GuaranteeCommonVO[]	guaranteeCommonVOs	= null;
	private TesGnteHdrVO[]		tesGnteHdrVOs		= null;

	public EsdTes2002Event(){}

	public GuaranteeCommonVO getGuaranteeCommonVO() {
		return guaranteeCommonVO;
	}

	public void setGuaranteeCommonVO(GuaranteeCommonVO guaranteeCommonVO) {
		this.guaranteeCommonVO = guaranteeCommonVO;
	}

	public TesGnteHdrVO getTesGnteHdrVO() {
		return tesGnteHdrVO;
	}

	public void setTesGnteHdrVO(TesGnteHdrVO tesGnteHdrVO) {
		this.tesGnteHdrVO = tesGnteHdrVO;
	}

	public GuaranteeCommonVO[] getGuaranteeCommonVOs() {
		return guaranteeCommonVOs;
	}

	public void setGuaranteeCommonVOs(GuaranteeCommonVO[] guaranteeCommonVOs) {
		this.guaranteeCommonVOs = guaranteeCommonVOs;
	}

	public TesGnteHdrVO[] getTesGnteHdrVOs() {
		return tesGnteHdrVOs;
	}

	public void setTesGnteHdrVOs(TesGnteHdrVO[] tesGnteHdrVOs) {
		this.tesGnteHdrVOs = tesGnteHdrVOs;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	


}