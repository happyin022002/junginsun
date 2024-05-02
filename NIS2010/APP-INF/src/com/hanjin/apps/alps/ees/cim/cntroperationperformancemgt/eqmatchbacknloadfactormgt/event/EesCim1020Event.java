/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim1020Event.java
*@FileTitle : Lane M/B by Logistics-Wise
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.05.21 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBSearchOptionInGereralVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;


/**
 * EES_CIM_1020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_1020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Prak Kwang Seok
 * @see EES_CIM_1020HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCim1020Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MBSearchOptionInGereralVO mBSearchOptionInGereralVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MBSearchOptionInGereralVO[] mBSearchOptionInGereralVOs = null;

	public EesCim1020Event(){}
	
	public void setMBSearchOptionInGereralVO(MBSearchOptionInGereralVO mBSearchOptionInGereralVO){
		this. mBSearchOptionInGereralVO = mBSearchOptionInGereralVO;
	}

	public void setMBSearchOptionInGereralVOS(MBSearchOptionInGereralVO[] mBSearchOptionInGereralVOs){
		if (mBSearchOptionInGereralVOs != null) {
			MBSearchOptionInGereralVO[] tmpVOs = Arrays.copyOf(mBSearchOptionInGereralVOs, mBSearchOptionInGereralVOs.length);
			this.mBSearchOptionInGereralVOs = tmpVOs;
		}
	}

	public MBSearchOptionInGereralVO getMBSearchOptionInGereralVO(){
		return mBSearchOptionInGereralVO;
	}

	public MBSearchOptionInGereralVO[] getMBSearchOptionInGereralVOS(){
		MBSearchOptionInGereralVO[] rtnVOs = null;
		if (this.mBSearchOptionInGereralVOs != null) {
			rtnVOs = Arrays.copyOf(mBSearchOptionInGereralVOs, mBSearchOptionInGereralVOs.length);
		}
		return rtnVOs;
	}

}