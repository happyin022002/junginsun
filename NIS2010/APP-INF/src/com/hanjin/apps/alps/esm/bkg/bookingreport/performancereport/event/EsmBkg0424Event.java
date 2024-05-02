/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0424Event.java
*@FileTitle : 0424 Open 시 Queue VVD List 정보를 조회합니다.
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueReportByPolListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueVvdListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0424 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0424HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_0424HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0424Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DocQueueVvdListVO infoVO = null;

	/** Table Value Object Multi Data 처리 */
	private DocQueueVvdListVO[] infoVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DocQueueReportByPolListInVO infoVO2 = null;

	public EsmBkg0424Event(){}

	public DocQueueReportByPolListInVO getInfoVO2() {
		return infoVO2;
	}


	public void setInfoVO2(DocQueueReportByPolListInVO infoVO2) {
		this.infoVO2 = infoVO2;
	}

	public DocQueueVvdListVO getInfoVO() {
		return infoVO;
	}


	public void setInfoVO(DocQueueVvdListVO infoVO) {
		this.infoVO = infoVO;
	}


	public DocQueueVvdListVO[] getInfoVOs() {
		DocQueueVvdListVO[] rtnVOs = null;
		if (this.infoVOs != null) {
			rtnVOs = Arrays.copyOf(infoVOs, infoVOs.length);
		}
		return rtnVOs;
	}


	public void setInfoVOs(DocQueueVvdListVO[] infoVOs){
		if(infoVOs != null){
			DocQueueVvdListVO[] tmpVOs = Arrays.copyOf(infoVOs, infoVOs.length);
			this.infoVOs = tmpVOs;
		}
	}
	
}