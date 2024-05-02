/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf1052Event.java
*@FileTitle : Supporting Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.06.25 이선영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event;

import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsReportVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.OpfStvDmgAtchFileVO;


/**
 * VOP_OPF_1052 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_1052HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sunyoung
 * @see VOP_OPF_1052HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf1052Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfStvDmgAtchFileVO opfStvDmgAtchFileVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVOs = null;

	public VopOpf1052Event(){}
	
	public void setOpfStvDmgAtchFileVO(OpfStvDmgAtchFileVO opfStvDmgAtchFileVO){
		this. opfStvDmgAtchFileVO = opfStvDmgAtchFileVO;
	}

	public void setOpfStvDmgAtchFileVOS(OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVOs){
		if (opfStvDmgAtchFileVOs != null) {
			OpfStvDmgAtchFileVO[] tmpVOs = new OpfStvDmgAtchFileVO[opfStvDmgAtchFileVOs.length];
			System.arraycopy(opfStvDmgAtchFileVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfStvDmgAtchFileVOs = tmpVOs;
		}
	}

	public OpfStvDmgAtchFileVO getOpfStvDmgAtchFileVO(){
		return opfStvDmgAtchFileVO;
	}

	public OpfStvDmgAtchFileVO[] getOpfStvDmgAtchFileVOS(){
		OpfStvDmgAtchFileVO[] rtnVOs = null;

 		if (this.opfStvDmgAtchFileVOs != null) {
 			rtnVOs = new OpfStvDmgAtchFileVO[opfStvDmgAtchFileVOs.length];
 			System.arraycopy(opfStvDmgAtchFileVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;	
	}

}