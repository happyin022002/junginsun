/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0033Event.java
*@FileTitle : COD Approve Main Screen
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.20 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.OpfTdrAtchFileVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.CODRequestListVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ChangeOfDestinationMgtConditionVO;

/**
 * VOP_OPF_0033 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0033HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see VOP_OPF_0033HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0033Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CODRequestListVO cODRequestListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CODRequestListVO[] cODRequestListVOs = null;
	private ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO = null;
	
	public VopOpf0033Event(){}
	
	public void setCODRequestListVO(CODRequestListVO cODRequestListVO){
		this. cODRequestListVO = cODRequestListVO;
	}

	public void setCODRequestListVOS(CODRequestListVO[] cODRequestListVOs){
		if (cODRequestListVOs != null) {
			CODRequestListVO[] tmpVOs = new CODRequestListVO[cODRequestListVOs.length];
			System.arraycopy(cODRequestListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cODRequestListVOs = tmpVOs;
		}
	}

	public CODRequestListVO getCODRequestListVO(){
		return cODRequestListVO;
	}

	public CODRequestListVO[] getCODRequestListVOS(){
		CODRequestListVO[] rtnVOs = null;

 		if (this.cODRequestListVOs != null) {
 			rtnVOs = new CODRequestListVO[cODRequestListVOs.length];
 			System.arraycopy(cODRequestListVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

	public void setChangeOfDestinationMgtConditionVO(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) {
		this.changeOfDestinationMgtConditionVO = changeOfDestinationMgtConditionVO;
	}
	
	public ChangeOfDestinationMgtConditionVO getChangeOfDestinationMgtConditionVO() {
		return changeOfDestinationMgtConditionVO;
	}	
}