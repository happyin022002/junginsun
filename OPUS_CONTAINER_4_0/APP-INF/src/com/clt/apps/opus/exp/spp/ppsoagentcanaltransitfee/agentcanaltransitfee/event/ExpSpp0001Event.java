/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpSpp0001Event.java
*@FileTitle : Canal Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.05.29 김성광
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event;

import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeSumVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzListInVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzVVDListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EXP_SPP_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EXP_SPP_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Seong Kwang
 * @see EXP_SPP_0001HTMLAction 참조
 * @since J2EE 1.6 
 */

public class ExpSpp0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CanalTzListInVO canalTzListInVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CanalTzListInVO[] canalTzListInVOs = null;		
	
	/*canal invoice 조회 조건 사용 vo*/
	private CanalTzFeeSumVO canalTzFeeSumVO = null;
	
	/*CanalTzVVDList 조회 조건 사용 vo*/
	private CanalTzVVDListVO canalTzVVDListVO = null;
	
	
	public ExpSpp0001Event(){}
	
	public void setCanalTzListInVO(CanalTzListInVO canalTzListInVO){
		this. canalTzListInVO = canalTzListInVO;
	}

	public void setCanalTzListInVOS(CanalTzListInVO[] canalTzListInVOs){
		this. canalTzListInVOs = canalTzListInVOs;
	}	

	public CanalTzListInVO getCanalTzListInVO(){
		return canalTzListInVO;
	}

	public CanalTzListInVO[] getCanalTzListInVOS(){
		return canalTzListInVOs;
	}

	/**
	 * Canal Invoice List를 조회하기 위한 조건 vo의 setter
	 * @param vo
	 */
	public void setCanalTzFeeSumVO(CanalTzFeeSumVO vo) {
		// TODO Auto-generated method stub
		this.canalTzFeeSumVO = vo;
	}

	/**
	 * Canal Invoice List를 조회하기 위한 조건 vo의 getter
	 * @return
	 */
	public CanalTzFeeSumVO getCanalTzFeeSumVO() {
		// TODO Auto-generated method stub
		return this.canalTzFeeSumVO;
	}
	
	/**
	 * CanalTzVVDList를 조회하기 위한 조건 vo의 setter
	 * @param vo
	 */
	public void setCanalTzVVDListVO(CanalTzVVDListVO vo) {
		// TODO Auto-generated method stub
		this.canalTzVVDListVO = vo;
	}

	/**
	 * CanalTzVVDList를 조회하기 위한 조건 vo의 getter
	 * @return
	 */
	public CanalTzVVDListVO getCanalTzVVDListVO() {
		// TODO Auto-generated method stub
		return this.canalTzVVDListVO;
	}
}