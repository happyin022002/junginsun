/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0049Event.java
*@FileTitle : Load Reject Reason (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.18 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ScgLodRjctCdVO;


/**
 * VOP_SCG_0049 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0049HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_SCG_0049HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0049Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgLodRjctCdVO scgLodRjctCdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgLodRjctCdVO[] scgLodRjctCdVOs = null;

	/**
	 * @return the scgLodRjctCdVO
	 */
	public ScgLodRjctCdVO getScgLodRjctCdVO() {
		return scgLodRjctCdVO;
	}

	/**
	 * @return the scgLodRjctCdVOs
	 */
	public ScgLodRjctCdVO[] getScgLodRjctCdVOs() {
		ScgLodRjctCdVO[] rtnVOs = null;
		if (this.scgLodRjctCdVOs != null) {
			rtnVOs = Arrays.copyOf(scgLodRjctCdVOs, scgLodRjctCdVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param scgLodRjctCdVO the scgLodRjctCdVO to set
	 */
	public void setScgLodRjctCdVO(ScgLodRjctCdVO scgLodRjctCdVO) {
		this.scgLodRjctCdVO = scgLodRjctCdVO;
	}

	/**
	 * @param scgLodRjctCdVOs the scgLodRjctCdVOs to set
	 */
	public void setScgLodRjctCdVOs(ScgLodRjctCdVO[] scgLodRjctCdVOs) {
		if(scgLodRjctCdVOs != null){
			ScgLodRjctCdVO[] tmpVOs = Arrays.copyOf(scgLodRjctCdVOs, scgLodRjctCdVOs.length);
			this.scgLodRjctCdVOs = tmpVOs;
		}
	}
}