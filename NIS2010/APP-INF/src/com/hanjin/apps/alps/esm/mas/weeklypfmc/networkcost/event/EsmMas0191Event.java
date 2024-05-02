/*=========================================================
*Copyright(c) 2014 CyberLogitec
**@FileName : EsmMas0191Event.java
*@FileTitle : MAS Create Monitor
*Open Issues :
*Change history :
*@LastModifyDate : 2015-06-26
*@LastModifier : Je Ryang Yoo
*@LastVersion : 
*  2015-06-26 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.MASCreateMonitorVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_0191 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0191HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Je Ryang Yoo
 * @see ESM_MAS_0191HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0191Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private MASCreateMonitorVO mASCreateMonitorVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private MASCreateMonitorVO[] mASCreateMonitorVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;

	/** Constructor */
	public EsmMas0191Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0191Event";
	}

	public MASCreateMonitorVO getMASCreateMonitorVO() {
		return mASCreateMonitorVO;
	}

	public void setMASCreateMonitorVO(MASCreateMonitorVO mASCreateMonitorVO) {
		this.mASCreateMonitorVO = mASCreateMonitorVO;
	}

	
	public MASCreateMonitorVO[] getMASCreateMonitorVOs() {
		return mASCreateMonitorVOs;
	}

	public void setMASCreateMonitorVOs(MASCreateMonitorVO[] mASCreateMonitorVOs) {
		this.mASCreateMonitorVOs = mASCreateMonitorVOs;
	}
		
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.searchConditionVO = searchConditionVO;
	}		
			
}
