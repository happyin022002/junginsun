/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim1001Event.java
*@FileTitle : Turn Time by Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.04.24 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event;

import java.util.Arrays;

import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TTSearchOptionInGereralVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByTypeSizeVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CIM_1001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_1001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Prak Kwang Seok
 * @see EES_CIM_1001HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCim1001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TTSearchOptionInGereralVO ttsearchoptioningereralvo = null;
	
	/** Table Value Object Multi Data 처리 */
	private TTSearchOptionInGereralVO[] ttsearchoptioningereralvos = null;

	/** Table Value Object 조회건  */
	private TurnTimeByTypeSizeVO turntimebytypesizevo = null;

	public EesCim1001Event(){}
	 
	public void setTTSearchOptionInGereralVO(TTSearchOptionInGereralVO ttsearchoptioningereralvo){
		this. ttsearchoptioningereralvo = ttsearchoptioningereralvo;
	}

	public void setTTSearchOptionInGereralVOS(TTSearchOptionInGereralVO[] ttsearchoptioningereralvos){
		if (ttsearchoptioningereralvos != null) {
			TTSearchOptionInGereralVO[] tmpVOs = Arrays.copyOf(ttsearchoptioningereralvos, ttsearchoptioningereralvos.length);
			this.ttsearchoptioningereralvos = tmpVOs;
		}
	}

	public void setTurnTimeByTypeSizeVO(TurnTimeByTypeSizeVO turntimebytypesizevo){
		this. turntimebytypesizevo = turntimebytypesizevo;
	}

	public TTSearchOptionInGereralVO getTTSearchOptionInGereralVO(){
		return ttsearchoptioningereralvo;
	}

	public TTSearchOptionInGereralVO[] getTTSearchOptionInGereralVOS(){
		TTSearchOptionInGereralVO[] rtnVOs = null;
		if (this.ttsearchoptioningereralvos != null) {
			rtnVOs = Arrays.copyOf(ttsearchoptioningereralvos, ttsearchoptioningereralvos.length);
		}
		return rtnVOs;
	}

	public TurnTimeByTypeSizeVO getTurnTimeByTypeSizeVO(){
		return turntimebytypesizevo;
	}

}