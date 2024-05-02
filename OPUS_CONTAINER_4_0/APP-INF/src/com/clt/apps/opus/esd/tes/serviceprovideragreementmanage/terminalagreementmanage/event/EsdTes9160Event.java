/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes9160Event.java
*@FileTitle : Agreement Terminal Rate List Excel Load
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.09.23 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesTmlAgmtVrfyMzdVO;

/**
 * ESD_TES_9160 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TES_9160HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author yOng hO lEE
 * @see ESD_TES_9160HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTes9160Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TesTmlAgmtVrfyMzdVO				tesTmlAgmtVrfyMzdVO					= null;
	
	/** Table Value Object Multi Data 처리 */
	private TesTmlAgmtVrfyMzdVO[]			tesTmlAgmtVrfyMzdVOs				= null;

	public EsdTes9160Event(){}

	public TesTmlAgmtVrfyMzdVO getTesTmlAgmtVrfyMzdVO() {
		return tesTmlAgmtVrfyMzdVO;
	}

	public void setTesTmlAgmtVrfyMzdVO(TesTmlAgmtVrfyMzdVO tesTmlAgmtVrfyMzdVO) {
		this.tesTmlAgmtVrfyMzdVO = tesTmlAgmtVrfyMzdVO;
	}

	public TesTmlAgmtVrfyMzdVO[] getTesTmlAgmtVrfyMzdVOs() {
		TesTmlAgmtVrfyMzdVO[] rtnVOs = null;
		if (this.tesTmlAgmtVrfyMzdVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlAgmtVrfyMzdVOs, tesTmlAgmtVrfyMzdVOs.length);
		}
		return rtnVOs;
	}

	public void setTesTmlAgmtVrfyMzdVOs(TesTmlAgmtVrfyMzdVO[] tesTmlAgmtVrfyMzdVOs){
		if(tesTmlAgmtVrfyMzdVOs != null){
			TesTmlAgmtVrfyMzdVO[] tmpVOs = Arrays.copyOf(tesTmlAgmtVrfyMzdVOs, tesTmlAgmtVrfyMzdVOs.length);
			this.tesTmlAgmtVrfyMzdVOs = tmpVOs;
		}
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
}
