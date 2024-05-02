/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FnsJoo0095Event.java
*@FileTitle : Basic Information for Loading Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.23
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.12.23 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event;

import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.BlkVygSttsVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0095 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0095HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0095HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0095Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BlkVygSttsVO BlkVygSttsVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BlkVygSttsVO[] BlkVygSttsVOs = null;

	public FnsJoo0095Event(){}
	
	public void setBlkVygSttsVO(BlkVygSttsVO BlkVygSttsVO){
		this. BlkVygSttsVO = BlkVygSttsVO;
	}

	public void setBlkVygSttsVOS(BlkVygSttsVO[] BlkVygSttsVOs){
		if (BlkVygSttsVOs != null) {
			BlkVygSttsVO[] tmpVOs = new BlkVygSttsVO[BlkVygSttsVOs.length];
			System.arraycopy(BlkVygSttsVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.BlkVygSttsVOs = tmpVOs;
		}		
	}

	public BlkVygSttsVO getBlkVygSttsVO(){
		return BlkVygSttsVO;
	}

	public BlkVygSttsVO[] getBlkVygSttsVOS(){
		BlkVygSttsVO[] rtnVOs = null;
		if (this.BlkVygSttsVOs != null) {
			rtnVOs = new BlkVygSttsVO[BlkVygSttsVOs.length];
			System.arraycopy(BlkVygSttsVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}
}