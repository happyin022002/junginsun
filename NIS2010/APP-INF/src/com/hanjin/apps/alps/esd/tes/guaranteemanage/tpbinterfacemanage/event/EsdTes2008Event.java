/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes2008Event.java
*@FileTitle : Guarantee TPB I/F
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.11.11 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.tpbinterfacemanage.event;

import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesGnteCntrListVO;
import com.hanjin.syscommon.common.table.TesGnteHdrVO;
import com.hanjin.syscommon.common.table.TesN3rdPtyIfVO;


/**
 * ESD_TES_2008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TES_2008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author yOng hO lEE
 * @see ESD_TES_2008HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTes2008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private GuaranteeCommonVO				guaranteeCommonVO			= null;
	private TesGnteHdrVO					tesGnteHdrVO 				= null;
	private TesN3rdPtyIfVO					tesN3rdPtyIfVO 				= null;
	private TesGnteCntrListVO				tesGnteCntrListVO 			= null;
	
	/** Table Value Object Multi Data 처리 */
	private GuaranteeCommonVO[]				guaranteeCommonVOs			= null;
	private TesGnteHdrVO[]					tesGnteHdrVOs 				= null;
	private TesN3rdPtyIfVO[]				tesN3rdPtyIfVOs 			= null;
	private TesGnteCntrListVO[]				tesGnteCntrListVOs			= null;

	public EsdTes2008Event(){}

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

	public TesN3rdPtyIfVO getTesN3rdPtyIfVO() {
		return tesN3rdPtyIfVO;
	}

	public void setTesN3rdPtyIfVO(TesN3rdPtyIfVO tesN3rdPtyIfVO) {
		this.tesN3rdPtyIfVO = tesN3rdPtyIfVO;
	}

	public TesGnteCntrListVO getTesGnteCntrListVO() {
		return tesGnteCntrListVO;
	}

	public void setTesGnteCntrListVO(TesGnteCntrListVO tesGnteCntrListVO) {
		this.tesGnteCntrListVO = tesGnteCntrListVO;
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

	public TesN3rdPtyIfVO[] getTesN3rdPtyIfVOs() {
		return tesN3rdPtyIfVOs;
	}

	public void setTesN3rdPtyIfVOs(TesN3rdPtyIfVO[] tesN3rdPtyIfVOs) {
		this.tesN3rdPtyIfVOs = tesN3rdPtyIfVOs;
	}

	public TesGnteCntrListVO[] getTesGnteCntrListVOs() {
		return tesGnteCntrListVOs;
	}

	public void setTesGnteCntrListVOs(TesGnteCntrListVO[] tesGnteCntrListVOs) {
		this.tesGnteCntrListVOs = tesGnteCntrListVOs;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}



}