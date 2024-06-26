/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim1011Event.java
*@FileTitle : Turn Time by Movement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.08.31 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TTSearchOptionInGereralVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;


/**
 * EES_CIM_1011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_1011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Prak Kwang Seok
 * @see EES_CIM_1011HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCim1011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TTSearchOptionInGereralVO tTSearchOptionInGereralVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TTSearchOptionInGereralVO[] tTSearchOptionInGereralVOs = null;

	public EesCim1011Event(){}
	
	public void setTTSearchOptionInGereralVO(TTSearchOptionInGereralVO tTSearchOptionInGereralVO){
		this. tTSearchOptionInGereralVO = tTSearchOptionInGereralVO;
	}

	public void setTTSearchOptionInGereralVOS(TTSearchOptionInGereralVO[] tTSearchOptionInGereralVOs){
		if (tTSearchOptionInGereralVOs != null) {
			TTSearchOptionInGereralVO[] tmpVOs = Arrays.copyOf(tTSearchOptionInGereralVOs, tTSearchOptionInGereralVOs.length);
			this.tTSearchOptionInGereralVOs = tmpVOs;
		}
	}

	public TTSearchOptionInGereralVO getTTSearchOptionInGereralVO(){
		return tTSearchOptionInGereralVO;
	}

	public TTSearchOptionInGereralVO[] getTTSearchOptionInGereralVOS(){
		TTSearchOptionInGereralVO[] rtnVOs = null;
		if (this.tTSearchOptionInGereralVOs != null) {
			rtnVOs = Arrays.copyOf(tTSearchOptionInGereralVOs, tTSearchOptionInGereralVOs.length);
		}
		return rtnVOs;
	}

}