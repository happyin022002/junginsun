/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4012Event.java
*@FileTitle : Lane Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.26 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.servicelane.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;


/**
 * ESM_PRI_4012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_4012HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri4012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmVslSvcLaneVO mdmVslSvcLaneVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmVslSvcLaneVO[] mdmVslSvcLaneVOs = null;

	public EsmPri4012Event(){}
	
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
		MdmVslSvcLaneVO[] tmpVOs = null;
		if (this.mdmVslSvcLaneVOs != null) {
			tmpVOs = new MdmVslSvcLaneVO[mdmVslSvcLaneVOs.length];
			System.arraycopy(mdmVslSvcLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}