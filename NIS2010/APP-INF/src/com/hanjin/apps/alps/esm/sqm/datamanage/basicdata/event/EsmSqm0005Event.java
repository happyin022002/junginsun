/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0005Event.java
*@FileTitle      : Target VVD Fix
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.08
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.08 JEONGMIN CHO
* 1.0 Creation
* 2015.09.01 김용습 [CHM-201536638] - Split08-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
* 2015.11.27 김용습 [CHM-201538876] [SQM] 연간 판매목표 VBP SKD I/F 후 매뉴얼 수정관련 로직 수정 요청
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmQtaTgtVvdVO;


/**
 * ESM_SQM_0005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SQM_0005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JEONGMIN CHO
 * @see ESM_SQM_0005HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmQtaTgtVvdVO sqmQtaTgtVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmQtaTgtVvdVO[] sqmQtaTgtVvdVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	String vbpIfFlg = null;

	public EsmSqm0005Event(){}
	
	public void setSqmQtaTgtVvdVO(SqmQtaTgtVvdVO sqmQtaTgtVvdVO){
		this. sqmQtaTgtVvdVO = sqmQtaTgtVvdVO;
	}

	public void setSqmQtaTgtVvdVOS(SqmQtaTgtVvdVO[] sqmQtaTgtVvdVOs){
		if(sqmQtaTgtVvdVOs != null){
			this.sqmQtaTgtVvdVOs = new SqmQtaTgtVvdVO[sqmQtaTgtVvdVOs.length];
			for(int i=0; i<sqmQtaTgtVvdVOs.length; ++i){
				this.sqmQtaTgtVvdVOs[i] = sqmQtaTgtVvdVOs[i];
			}
		}
	}

	public SqmQtaTgtVvdVO getSqmQtaTgtVvdVO(){
		return sqmQtaTgtVvdVO;
	}

	public SqmQtaTgtVvdVO[] getSqmQtaTgtVvdVOS(){
		SqmQtaTgtVvdVO[] ret = null;
		if(this.sqmQtaTgtVvdVOs != null){
			ret = new SqmQtaTgtVvdVO[sqmQtaTgtVvdVOs.length];
			for(int i=0; i<sqmQtaTgtVvdVOs.length; i++){
				ret[i] = this.sqmQtaTgtVvdVOs[i];
			}
		}
		return ret;
	}
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

	public String getVbpIfFlg() {
		return vbpIfFlg;
	}

	public void setVbpIfFlg(String vbpIfFlg) {
		this.vbpIfFlg = vbpIfFlg;
	}

}