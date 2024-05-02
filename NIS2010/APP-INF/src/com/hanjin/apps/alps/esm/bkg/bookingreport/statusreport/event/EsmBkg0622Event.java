/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0622Event.java
*@FileTitle : O/B CONTAINER MOVEMENT STATUS (E-MAIL,SMS)
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.31
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.01.31 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMvntStsNtcListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMvntStsNtcListSumVO;



/**
 * ESM_BKG_0619 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0619HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHO JEONGMIN
 * @see ESM_BKG_0622HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0622Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OutBdMvntStsNtcListInVO outBdMvntStsNtcListInVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OutBdMvntStsNtcListInVO[] outBdMvntStsNtcListInVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OutBdMvntStsNtcListSumVO outBdMvntStsNtcListSumVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OutBdMvntStsNtcListSumVO[] outBdMvntStsNtcListSumVOs = null;

	public EsmBkg0622Event(){}
	
	public void setOutBdMvntStsNtcListInVO(OutBdMvntStsNtcListInVO outBdMvntStsNtcListInVO){
		this. outBdMvntStsNtcListInVO = outBdMvntStsNtcListInVO;
	}
 
	public void setOutBdMvntStsNtcListInVOS(OutBdMvntStsNtcListInVO[] outBdMvntStsNtcListInVOs){
		this. outBdMvntStsNtcListInVOs = outBdMvntStsNtcListInVOs;
	}

	public OutBdMvntStsNtcListInVO getOutBdMvntStsNtcListInVO(){
		return outBdMvntStsNtcListInVO;
	}

	public OutBdMvntStsNtcListInVO[] getOutBdMvntStsNtcListInVOS(){
		return outBdMvntStsNtcListInVOs;
	}
	
	
	public void setOutBdMvntStsNtcListSumVO(OutBdMvntStsNtcListSumVO outBdMvntStsNtcListSumVO){
		this. outBdMvntStsNtcListSumVO = outBdMvntStsNtcListSumVO;
	}
 
	public void setOutBdMvntStsNtcListSumVOS(OutBdMvntStsNtcListSumVO[] outBdMvntStsNtcListSumVOs){
		this. outBdMvntStsNtcListSumVOs = outBdMvntStsNtcListSumVOs;
	}

	public OutBdMvntStsNtcListSumVO getOutBdMvntStsNtcListSumVO(){
		return outBdMvntStsNtcListSumVO;
	}

	public OutBdMvntStsNtcListSumVO[] getOutBdMvntStsNtcListSumVOS(){
		return outBdMvntStsNtcListSumVOs;
	}

}