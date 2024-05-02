/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0054Event.java
*@FileTitle : Stevedore Damage History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.06.22 이선영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.OpfStvDmgStepHisVO;
import com.hanjin.syscommon.common.table.OpfStvDmgVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsOptionVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsStepHistoryVO;


/**
 * VOP_OPF_0054 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0054HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sunyoung
 * @see VOP_OPF_0054HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0054Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SdmsStepHistoryVO sdmsStepHistoryVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfStvDmgStepHisVO opfStvDmgStepHisVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfStvDmgVO opfStvDmgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SdmsStepHistoryVO[] sdmsStepHistoryVOs = null;
	/** Table Value Object Multi Data 처리 */
	private OpfStvDmgStepHisVO[] opfStvDmgStepHisVOs = null;
	/** Table Value Object Multi Data 처리 */
	private OpfStvDmgVO[] opfStvDmgVOs = null;

	public VopOpf0054Event(){}
	
	public void setSdmsStepHistoryVO(SdmsStepHistoryVO sdmsStepHistoryVO){
		this. sdmsStepHistoryVO = sdmsStepHistoryVO;
	}

	public void setSdmsStepHistoryVOS(SdmsStepHistoryVO[] sdmsStepHistoryVOs){
		if (sdmsStepHistoryVOs != null) {
			SdmsStepHistoryVO[] tmpVOs = new SdmsStepHistoryVO[sdmsStepHistoryVOs.length];
			System.arraycopy(sdmsStepHistoryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.sdmsStepHistoryVOs = tmpVOs;
		}
	}

	public SdmsStepHistoryVO getSdmsStepHistoryVO(){
		return sdmsStepHistoryVO;
	}

	public SdmsStepHistoryVO[] getSdmsStepHistoryVOS(){
		SdmsStepHistoryVO[] rtnVOs = null;

 		if (this.sdmsStepHistoryVOs != null) {
 			rtnVOs = new SdmsStepHistoryVO[sdmsStepHistoryVOs.length];
 			System.arraycopy(sdmsStepHistoryVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;	
	}
	
	public void setOpfStvDmgStepHisVO(OpfStvDmgStepHisVO opfStvDmgStepHisVO){
		this. opfStvDmgStepHisVO = opfStvDmgStepHisVO;
	}

	public void setOpfStvDmgStepHisVOS(OpfStvDmgStepHisVO[] opfStvDmgStepHisVOs){
		if (opfStvDmgStepHisVOs != null) {
			OpfStvDmgStepHisVO[] tmpVOs = new OpfStvDmgStepHisVO[opfStvDmgStepHisVOs.length];
			System.arraycopy(opfStvDmgStepHisVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfStvDmgStepHisVOs = tmpVOs;
		}
	}

	public OpfStvDmgStepHisVO getOpfStvDmgStepHisVO(){
		return opfStvDmgStepHisVO;
	}

	public OpfStvDmgStepHisVO[] getOpfStvDmgStepHisVOS(){
		OpfStvDmgStepHisVO[] rtnVOs = null;

 		if (this.opfStvDmgStepHisVOs != null) {
 			rtnVOs = new OpfStvDmgStepHisVO[opfStvDmgStepHisVOs.length];
 			System.arraycopy(opfStvDmgStepHisVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}
	
	public void setOpfStvDmgVO(OpfStvDmgVO opfStvDmgVO){
		this. opfStvDmgVO = opfStvDmgVO;
	}

	public void setOpfStvDmgVOS(OpfStvDmgVO[] opfStvDmgVOs){
		if (opfStvDmgVOs != null) {
			OpfStvDmgVO[] tmpVOs = new OpfStvDmgVO[opfStvDmgVOs.length];
			System.arraycopy(opfStvDmgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfStvDmgVOs = tmpVOs;
		}
		
	}

	public OpfStvDmgVO getOpfStvDmgVO(){
		return opfStvDmgVO;
	}

	public OpfStvDmgVO[] getOpfStvDmgVOS(){
		OpfStvDmgVO[] rtnVOs = null;

 		if (this.opfStvDmgVOs != null) {
 			rtnVOs = new OpfStvDmgVO[opfStvDmgVOs.length];
 			System.arraycopy(opfStvDmgVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

}