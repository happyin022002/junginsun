/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSceRplnEvent.java
*@FileTitle : Replan 을 수행하는 공통 class 를 구동한다.
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.09.01 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.replanmanage.replanmanage.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SceCopHdrVO;


/**
 * ESD_SCE_RPLN 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SCE_RPLNHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim In-soo
 * @see ESD_SCE_RPLNHTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSceRplnEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SceCopHdrVO sceCopHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SceCopHdrVO[] sceCopHdrVOs = null;

	public EsdSceRplnEvent(){}
	
	public void setSceCopHdrVO(SceCopHdrVO sceCopHdrVO){
		this. sceCopHdrVO = sceCopHdrVO;
	}

	public void setSceCopHdrVOS(SceCopHdrVO[] sceCopHdrVOs){
		if(sceCopHdrVOs != null){
			SceCopHdrVO[] tmpVOs = Arrays.copyOf(sceCopHdrVOs, sceCopHdrVOs.length);
			this.sceCopHdrVOs = tmpVOs;
		}
	}

	public SceCopHdrVO getSceCopHdrVO(){
		return sceCopHdrVO;
	}

	public SceCopHdrVO[] getSceCopHdrVOS(){
		SceCopHdrVO[] rtnVOs = null;
		if (this.sceCopHdrVOs != null) {
			rtnVOs = Arrays.copyOf(sceCopHdrVOs, sceCopHdrVOs.length);
		}
		return rtnVOs;
	}

}