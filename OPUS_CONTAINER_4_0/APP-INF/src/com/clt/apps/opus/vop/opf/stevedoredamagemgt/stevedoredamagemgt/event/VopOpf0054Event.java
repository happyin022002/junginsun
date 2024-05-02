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
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsStepHistoryVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.OpfStvDmgStepHisVO;
import com.clt.syscommon.common.table.OpfStvDmgVO;


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
			SdmsStepHistoryVO[] tmpVOs = Arrays.copyOf(sdmsStepHistoryVOs, sdmsStepHistoryVOs.length);
			this.sdmsStepHistoryVOs = tmpVOs;
		} // end if
	}

	public SdmsStepHistoryVO getSdmsStepHistoryVO(){
		return sdmsStepHistoryVO;
	}

	public SdmsStepHistoryVO[] getSdmsStepHistoryVOS(){
		SdmsStepHistoryVO[] rtnVOs = null;
		if (this.sdmsStepHistoryVOs != null) {
			rtnVOs = Arrays.copyOf(this.sdmsStepHistoryVOs, this.sdmsStepHistoryVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public void setOpfStvDmgStepHisVO(OpfStvDmgStepHisVO opfStvDmgStepHisVO){
		this. opfStvDmgStepHisVO = opfStvDmgStepHisVO;
	}

	public void setOpfStvDmgStepHisVOS(OpfStvDmgStepHisVO[] opfStvDmgStepHisVOs){
		if (opfStvDmgStepHisVOs != null) {
			OpfStvDmgStepHisVO[] tmpVOs = Arrays.copyOf(opfStvDmgStepHisVOs, opfStvDmgStepHisVOs.length);
			this.opfStvDmgStepHisVOs = tmpVOs;
		} // end ifopfStvDmgStepHisVOs
	}

	public OpfStvDmgStepHisVO getOpfStvDmgStepHisVO(){
		return opfStvDmgStepHisVO;
	}

	public OpfStvDmgStepHisVO[] getOpfStvDmgStepHisVOS(){
		OpfStvDmgStepHisVO[] rtnVOs = null;
		if (this.opfStvDmgStepHisVOs != null) {
			rtnVOs = Arrays.copyOf(this.opfStvDmgStepHisVOs, this.opfStvDmgStepHisVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public void setOpfStvDmgVO(OpfStvDmgVO opfStvDmgVO){
		this. opfStvDmgVO = opfStvDmgVO;
	}

	public void setOpfStvDmgVOS(OpfStvDmgVO[] opfStvDmgVOs){
		if (opfStvDmgVOs != null) {
			OpfStvDmgVO[] tmpVOs = Arrays.copyOf(opfStvDmgVOs, opfStvDmgVOs.length);
			this.opfStvDmgVOs = tmpVOs;
		} // end if
	}

	public OpfStvDmgVO getOpfStvDmgVO(){
		return opfStvDmgVO;
	}

	public OpfStvDmgVO[] getOpfStvDmgVOS(){
		OpfStvDmgVO[] rtnVOs = null;
		if (this.opfStvDmgVOs != null) {
			rtnVOs = Arrays.copyOf(this.opfStvDmgVOs, this.opfStvDmgVOs.length);
		} // end if
		return rtnVOs;
	}

}