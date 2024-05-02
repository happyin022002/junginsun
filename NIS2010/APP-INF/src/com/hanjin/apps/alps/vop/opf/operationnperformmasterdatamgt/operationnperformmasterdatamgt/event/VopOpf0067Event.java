/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0067Event.java
*@FileTitle : TPR Target Lanes Register
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.05.19 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.OpfStvDmgCdVO;


/**
 * vop_opf_0067 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  vop_opf_0067HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see vop_opf_0067HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopOpf0067Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmVslSvcLaneVO mdmVslSvcLaneVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmVslSvcLaneVO[] mdmVslSvcLaneVOs = null;

	public VopOpf0067Event(){}
	
	public void setMdmVslSvcLaneVO(MdmVslSvcLaneVO mdmVslSvcLaneVO){
		this. mdmVslSvcLaneVO = mdmVslSvcLaneVO;
	}

	public void setMdmVslSvcLaneVOS(MdmVslSvcLaneVO[] mdmVslSvcLaneVOs){
		if (mdmVslSvcLaneVOs != null) {
			MdmVslSvcLaneVO[] tmpVOs = new MdmVslSvcLaneVO[mdmVslSvcLaneVOs.length];
			System.arraycopy(mdmVslSvcLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmVslSvcLaneVOs = tmpVOs;
		}
		
	}

	public MdmVslSvcLaneVO getMdmVslSvcLaneVO(){
		return mdmVslSvcLaneVO;
	}

	public MdmVslSvcLaneVO[] getMdmVslSvcLaneVOS(){
		MdmVslSvcLaneVO[] rtnVOs = null;

 		if (this.mdmVslSvcLaneVOs != null) {
 			rtnVOs = new MdmVslSvcLaneVO[mdmVslSvcLaneVOs.length];
 			System.arraycopy(mdmVslSvcLaneVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

}