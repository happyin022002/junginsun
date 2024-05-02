/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmBsa0045Event.java
*@FileTitle      : BSA I/F
*Open Issues     :
*Change history  :
*@LastModifyDate : 2011.04.04
*@LastModifier   : 최윤성
*@LastVersion    : 1.0
* 2011.04.04
* 1.0 Creation
*=========================================================
* History :
* 2011.04.04 최윤성 [CHM-201109932-01] BSA Yearly PLan 메뉴에 Live Data I/F 기능 추가 
* 2015.03.27 김용습 [CHM-201534456] 2015년 1월 소스 보안 결함 건 조치 요청
*=========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.event;

import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaTableSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo.BsaYearlyPlanConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BSA_0045 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BSA_0045HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 최윤성
 * @see ESM_BSA_0045HTMLAction 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class EsmBsa0045Event extends EventSupport {
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO = null;
	
	/** 단건처리 */
	private BsaTableSaveVO bsaTableSaveVO = null;
	
	/** 멀티처리 */
	private BsaTableSaveVO[] bsaTableSaveVOs= null;
	
	/** Constructor */
	public EsmBsa0045Event(){}	
	
	/** Search Condition Getter */
	public BsaYearlyPlanConditionVO getBsaYearlyPlanConditionVO() {
		return bsaYearlyPlanConditionVO;
	}

	/** Search Condition Setter */
	public void setBsaYearlyPlanConditionVO(BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO) {
		this.bsaYearlyPlanConditionVO = bsaYearlyPlanConditionVO;
	}
	
	/** Save Getter */	
	public BsaTableSaveVO getBsaTableSaveVO() {
		return bsaTableSaveVO;
	}
	/** Save Setter */
	public void setBsaTableSaveVO(BsaTableSaveVO bsaTableSaveVO) {
		this.bsaTableSaveVO = bsaTableSaveVO;
	}
		
	/** Save Getter */	
	//Yongseup Kim - Secure Coding [CWE-495]
	public BsaTableSaveVO[] getBsaTableSaveVOs() {
		BsaTableSaveVO[] ret = null;
		if(this.bsaTableSaveVOs != null){
			ret = new BsaTableSaveVO[bsaTableSaveVOs.length];
			for(int i=0; i< bsaTableSaveVOs.length; i++){
				ret[i] = this.bsaTableSaveVOs[i];
			}
		}
		return ret;
	}
	
	/** Save Setter */	
	//Yongseup Kim - Secure Coding [CWE-496]
	public void setBsaTableSaveVOs(BsaTableSaveVO[] bsaTableSaveVOs) {
		this.bsaTableSaveVOs = new BsaTableSaveVO[bsaTableSaveVOs.length];
		for(int i=0; i< bsaTableSaveVOs.length; ++i){
			this.bsaTableSaveVOs[i] = bsaTableSaveVOs[i];
		}
	}
}
