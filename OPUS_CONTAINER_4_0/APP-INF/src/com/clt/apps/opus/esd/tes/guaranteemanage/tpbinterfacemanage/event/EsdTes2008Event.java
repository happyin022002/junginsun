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
package com.clt.apps.opus.esd.tes.guaranteemanage.tpbinterfacemanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesGnteCntrListVO;
import com.clt.syscommon.common.table.TesGnteHdrVO;
import com.clt.syscommon.common.table.TesN3rdPtyIfVO;


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
		GuaranteeCommonVO[] rtnVOs = null;
		if (this.guaranteeCommonVOs != null) {
			rtnVOs = Arrays.copyOf(guaranteeCommonVOs, guaranteeCommonVOs.length);
		}
		return rtnVOs;
	}

	public void setGuaranteeCommonVOs(GuaranteeCommonVO[] guaranteeCommonVOs){
		if(guaranteeCommonVOs != null){
			GuaranteeCommonVO[] tmpVOs = Arrays.copyOf(guaranteeCommonVOs, guaranteeCommonVOs.length);
			this.guaranteeCommonVOs = tmpVOs;
		}
	}

	public TesGnteHdrVO[] getTesGnteHdrVOs() {
		TesGnteHdrVO[] rtnVOs = null;
		if (this.tesGnteHdrVOs != null) {
			rtnVOs = Arrays.copyOf(tesGnteHdrVOs, tesGnteHdrVOs.length);
		}
		return rtnVOs;
	}

	public void setTesGnteHdrVOs(TesGnteHdrVO[] tesGnteHdrVOs){
		if(tesGnteHdrVOs != null){
			TesGnteHdrVO[] tmpVOs = Arrays.copyOf(tesGnteHdrVOs, tesGnteHdrVOs.length);
			this.tesGnteHdrVOs = tmpVOs;
		}
	}

	public TesN3rdPtyIfVO[] getTesN3rdPtyIfVOs() {
		TesN3rdPtyIfVO[] rtnVOs = null;
		if (this.tesN3rdPtyIfVOs != null) {
			rtnVOs = Arrays.copyOf(tesN3rdPtyIfVOs, tesN3rdPtyIfVOs.length);
		}
		return rtnVOs;
	}

	public void setTesN3rdPtyIfVOs(TesN3rdPtyIfVO[] tesN3rdPtyIfVOs){
		if(tesN3rdPtyIfVOs != null){
			TesN3rdPtyIfVO[] tmpVOs = Arrays.copyOf(tesN3rdPtyIfVOs, tesN3rdPtyIfVOs.length);
			this.tesN3rdPtyIfVOs = tmpVOs;
		}
	}

	public TesGnteCntrListVO[] getTesGnteCntrListVOs() {
		TesGnteCntrListVO[] rtnVOs = null;
		if (this.tesGnteCntrListVOs != null) {
			rtnVOs = Arrays.copyOf(tesGnteCntrListVOs, tesGnteCntrListVOs.length);
		}
		return rtnVOs;
	}

	public void setTesGnteCntrListVOs(TesGnteCntrListVO[] tesGnteCntrListVOs){
		if(tesGnteCntrListVOs != null){
			TesGnteCntrListVO[] tmpVOs = Arrays.copyOf(tesGnteCntrListVOs, tesGnteCntrListVOs.length);
			this.tesGnteCntrListVOs = tmpVOs;
		}
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}



}