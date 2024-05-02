/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes2005Event.java
*@FileTitle : Vendor Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.14 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesGnteHdrVO;


/**
 * ESD_TES_2005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TES_2005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author yOng hO lEE
 * @see ESD_TES_2005HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTes2005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TesGnteHdrVO tesGnteHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TesGnteHdrVO[] tesGnteHdrVOs = null;

	public EsdTes2005Event(){}
	
	public void setTesGnteHdrVO(TesGnteHdrVO tesGnteHdrVO){
		this. tesGnteHdrVO = tesGnteHdrVO;
	}

	public void setTesGnteHdrVOS(TesGnteHdrVO[] tesGnteHdrVOs){
		if (tesGnteHdrVOs != null) {
			TesGnteHdrVO[] tempVo = Arrays.copyOf(tesGnteHdrVOs, tesGnteHdrVOs.length);
			this.tesGnteHdrVOs = tempVo;
		}
	}

	public TesGnteHdrVO getTesGnteHdrVO(){
		return tesGnteHdrVO;
	}

	public TesGnteHdrVO[] getTesGnteHdrVOS(){
		TesGnteHdrVO[] tempVOs = null;
		
		if (this.tesGnteHdrVOs != null) {
			tempVOs = Arrays.copyOf(this.tesGnteHdrVOs, this.tesGnteHdrVOs.length);
		}
		return tempVOs;	
	}

}