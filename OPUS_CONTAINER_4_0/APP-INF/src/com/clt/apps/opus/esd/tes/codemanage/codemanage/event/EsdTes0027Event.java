/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_027Event.java
*@FileTitle : Cost Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-07
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-09-07 jongbaemoon
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.codemanage.codemanage.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesLgsCostVO;


/**
 * ESD_TES_027 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_027HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jongbaemoon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0027Event extends EventSupport {

	/** tes_lgs_cost Table  Value Object */
	private TesLgsCostVO tesLgsCostVO = null;
	
    /**
     * 생성자
     */		
	public EsdTes0027Event(){}

	/**
	 * @return the tesLgsCostVO
	 */
	public TesLgsCostVO getTesLgsCostVO() {
		return tesLgsCostVO;
	}

	/**
	 * @param tesLgsCostVO the tesLgsCostVO to set
	 */
	public void setTesLgsCostVO(TesLgsCostVO tesLgsCostVO) {
		this.tesLgsCostVO = tesLgsCostVO;
	}	
}
