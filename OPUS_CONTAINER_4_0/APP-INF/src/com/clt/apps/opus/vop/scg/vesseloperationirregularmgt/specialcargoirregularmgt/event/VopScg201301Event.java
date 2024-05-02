/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg201301Event.java
*@FileTitle : Supporting Documents or Pictures
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.08 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrregularVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ScgIrrFileListVO;


/**
 * VOP_SCG_2013_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_2013_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HyunUk Kim
 * @see VOP_SCG_2013_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg201301Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgIrrFileListVO scgIrrFileListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private IrregularVO irregularVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgIrrFileListVO[] scgIrrFileListVOs = null;

	public VopScg201301Event(){}
	
	public void setScgIrrFileListVO(ScgIrrFileListVO scgIrrFileListVO){
		this. scgIrrFileListVO = scgIrrFileListVO;
	}
	
	public void setIrregularVO(IrregularVO irregularVO){
		this. irregularVO = irregularVO;
	}

	public void setScgIrrFileListVOS(ScgIrrFileListVO[] scgIrrFileListVOs){
		if(scgIrrFileListVOs != null){
			ScgIrrFileListVO[] tmpVOs = Arrays.copyOf(scgIrrFileListVOs, scgIrrFileListVOs.length);
			this.scgIrrFileListVOs = tmpVOs;
		}
	}

	public ScgIrrFileListVO getScgIrrFileListVO(){
		return scgIrrFileListVO;
	}
	
	public IrregularVO getIrregularVO(){
		return irregularVO;
	}

	public ScgIrrFileListVO[] getScgIrrFileListVOS(){
		ScgIrrFileListVO[] rtnVOs = null;
		if (this.scgIrrFileListVOs != null) {
			rtnVOs = Arrays.copyOf(scgIrrFileListVOs, scgIrrFileListVOs.length);
		}
		return rtnVOs;
	}

}