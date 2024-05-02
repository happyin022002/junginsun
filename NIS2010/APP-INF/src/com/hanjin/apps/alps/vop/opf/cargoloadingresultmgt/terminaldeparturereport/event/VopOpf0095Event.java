/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VopOpf0095Event.java
*@FileTitle : Missing TDR Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.26
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.11.26 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.MissingTDRCondVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.MissingTDRVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TmnlPerformVO;


/**
 * VOP_OPF_0095 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0095HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see VOP_OPF_0095HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0095Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MissingTDRCondVO missingTDRCondVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MissingTDRVO missingTDRVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MissingTDRVO[] missingTDRVOs = null;

	public VopOpf0095Event(){}
	
	public MissingTDRCondVO getMissingTDRCondVO() {
		return missingTDRCondVO;
	}

	public void setMissingTDRCondVO(MissingTDRCondVO missingTDRCondVO) {
		this.missingTDRCondVO = missingTDRCondVO;
	}

	public void setMissingTDRVO(MissingTDRVO missingTDRVO){
		this. missingTDRVO = missingTDRVO;
	}

	public void setMissingTDRVOS(MissingTDRVO[] missingTDRVOs){
		if (missingTDRVOs != null) {
			MissingTDRVO[] tmpVOs = new MissingTDRVO[missingTDRVOs.length];
			System.arraycopy(missingTDRVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.missingTDRVOs = tmpVOs;
		}
	}

	public MissingTDRVO getMissingTDRVO(){
		return missingTDRVO;
	}

	public MissingTDRVO[] getMissingTDRVOS(){
		MissingTDRVO[] rtnVOs = null;
 		
 		if (this.missingTDRVOs != null) {
 			rtnVOs = new MissingTDRVO[missingTDRVOs.length];
 			System.arraycopy(missingTDRVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

}