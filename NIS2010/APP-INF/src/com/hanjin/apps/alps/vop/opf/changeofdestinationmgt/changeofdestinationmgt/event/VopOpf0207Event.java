/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0207Event.java
*@FileTitle : COD Tariff Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.29 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.event;

import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.BkgCodCostListVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ChangeOfDestinationMgtConditionVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.OpfCodDvsFeeViewVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgCodCostVO;
import com.hanjin.syscommon.common.table.OpfCodDvsFeeVO;


/**
 * VOP_OPF_0207 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0207HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see VOP_OPF_0207HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0207Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfCodDvsFeeVO opfCodDvsFeeVO = null;
	private OpfCodDvsFeeViewVO opfCodDvsFeeViewVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OpfCodDvsFeeVO[] opfCodDvsFeeVOs = null;
	private OpfCodDvsFeeViewVO[] opfCodDvsFeeViewVOs = null;
	private ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO = null;
	
	public VopOpf0207Event(){}
	
	public void setOpfCodDvsFeeVO(OpfCodDvsFeeVO opfCodDvsFeeVO){
		this. opfCodDvsFeeVO = opfCodDvsFeeVO;
	}

	public void setOpfCodDvsFeeVOS(OpfCodDvsFeeVO[] opfCodDvsFeeVOs){
		if (opfCodDvsFeeVOs != null) {
			OpfCodDvsFeeVO[] tmpVOs = new OpfCodDvsFeeVO[opfCodDvsFeeVOs.length];
			System.arraycopy(opfCodDvsFeeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfCodDvsFeeVOs = tmpVOs;
		}
	}
	
	public void setOpfCodDvsFeeViewVO(OpfCodDvsFeeViewVO opfCodDvsFeeViewVO){
		this. opfCodDvsFeeViewVO = opfCodDvsFeeViewVO;
	}

	public void setOpfCodDvsFeeViewVOS(OpfCodDvsFeeViewVO[] opfCodDvsFeeViewVOs){
		if (opfCodDvsFeeViewVOs != null) {
			OpfCodDvsFeeViewVO[] tmpVOs = new OpfCodDvsFeeViewVO[opfCodDvsFeeViewVOs.length];
			System.arraycopy(opfCodDvsFeeViewVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfCodDvsFeeViewVOs = tmpVOs;
		}
	}

	public OpfCodDvsFeeVO getOpfCodDvsFeeVO(){
		return opfCodDvsFeeVO;
	}

	public OpfCodDvsFeeVO[] getOpfCodDvsFeeVOS(){
		OpfCodDvsFeeVO[] rtnVOs = null;

 		if (this.opfCodDvsFeeVOs != null) {
 			rtnVOs = new OpfCodDvsFeeVO[opfCodDvsFeeVOs.length];
 			System.arraycopy(opfCodDvsFeeVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

	public OpfCodDvsFeeViewVO getopfCodDvsFeeViewVO(){
		return opfCodDvsFeeViewVO;
	}

	public OpfCodDvsFeeViewVO[] getOpfCodDvsFeeViewVOS(){
		OpfCodDvsFeeViewVO[] rtnVOs = null;

 		if (this.opfCodDvsFeeViewVOs != null) {
 			rtnVOs = new OpfCodDvsFeeViewVO[opfCodDvsFeeViewVOs.length];
 			System.arraycopy(opfCodDvsFeeViewVOs, 0, rtnVOs, 0, rtnVOs.length);
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