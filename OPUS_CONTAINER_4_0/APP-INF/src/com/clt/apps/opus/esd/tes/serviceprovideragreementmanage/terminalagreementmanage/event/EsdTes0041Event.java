/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes0041Event.java
*@FileTitle : China Special Feeder
*Open Issues :
*Change history :
*@LastModifyDate : 2012-04-17
*@LastModifier : JEONGMIN CHO
*@LastVersion : 1.0
* 2012-04-17 JEONGMIN CHO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo.ChinaFdCodVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TES_0041 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TES_0041HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JEONGMIN CHO
 * @see ESD_TES_0041HTMLAction 참조
 * @since JEONGMIN CHO
 */
public class EsdTes0041Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChinaFdCodVO chinaFdCodVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChinaFdCodVO[] chinaFdCodVOs = null;

	public ChinaFdCodVO getChinaFdCodVO() {
		return chinaFdCodVO;
	}

	public void setChinaFdCodVO(ChinaFdCodVO chinaFdCodVO) {
		this.chinaFdCodVO = chinaFdCodVO;
	}

	public ChinaFdCodVO[] getChinaFdCodVOs() {
		ChinaFdCodVO[] rtnVOs = null;
		if (this.chinaFdCodVOs != null) {
			rtnVOs = Arrays.copyOf(chinaFdCodVOs, chinaFdCodVOs.length);
		}
		return rtnVOs;
	}

	public void setChinaFdCodVOs(ChinaFdCodVO[] chinaFdCodVOs){
		if(chinaFdCodVOs != null){
			ChinaFdCodVO[] tmpVOs = Arrays.copyOf(chinaFdCodVOs, chinaFdCodVOs.length);
			this.chinaFdCodVOs = tmpVOs;
		}
	}

}
