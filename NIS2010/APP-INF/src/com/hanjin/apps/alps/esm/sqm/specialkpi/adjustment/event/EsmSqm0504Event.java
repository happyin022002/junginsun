/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0504Event.java
*@FileTitle      : KPI Creation & Edit
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.15
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.15 이혜민
* 1.0 Creation
* 2015.09.01 김용습 [CHM-201536638] - Split08-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
* 2015.11.23 김용습 [CHM-201538496] [CSR 전환건] KPI Creation & Edit 화면 보완 (Trade Direction 칼럼 추가)
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchKpiCreationEditVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmSpclCfmQtaVO;

/**
 * ESM_SQM_0504 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SQM_0504HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이혜민
 * @see ESM_SQM_0504HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0504Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0504Event(){}
	
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmSpclCfmQtaVO sqmSpclCfmQtaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmSpclCfmQtaVO[] sqmSpclCfmQtaVOs = null;
	
	public void setSqmSpclCfmQtaVO(SqmSpclCfmQtaVO sqmSpclCfmQtaVO){
		this. sqmSpclCfmQtaVO = sqmSpclCfmQtaVO;
	}
	
	public void setSqmSpclCfmQtaVOS(SqmSpclCfmQtaVO[] sqmSpclCfmQtaVOs){
		if(sqmSpclCfmQtaVOs != null){
			this.sqmSpclCfmQtaVOs = new SqmSpclCfmQtaVO[sqmSpclCfmQtaVOs.length];
			for(int i=0; i<sqmSpclCfmQtaVOs.length; ++i){
				this.sqmSpclCfmQtaVOs[i] = sqmSpclCfmQtaVOs[i];
			}
		}
	}
	
	public SqmSpclCfmQtaVO getSqmSpclCfmQtaVO(){
		return sqmSpclCfmQtaVO;
	}
	
	public SqmSpclCfmQtaVO[] getSqmSpclCfmQtaVOS(){
		SqmSpclCfmQtaVO[] ret = null;
		if(this.sqmSpclCfmQtaVOs != null){
			ret = new SqmSpclCfmQtaVO[sqmSpclCfmQtaVOs.length];
			for(int i=0; i<sqmSpclCfmQtaVOs.length; i++){
				ret[i] = this.sqmSpclCfmQtaVOs[i];
			}
		}
		return ret;
	}
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchKpiCreationEditVO searchKpiCreationEditVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchKpiCreationEditVO[] searchKpiCreationEditVOs = null;
	
	public void setSearchKpiCreationEditVO(SearchKpiCreationEditVO searchKpiCreationEditVO){
		this. searchKpiCreationEditVO = searchKpiCreationEditVO;
	}

	public void setSearchKpiCreationEditVOS(SearchKpiCreationEditVO[] searchKpiCreationEditVOs){
		if(searchKpiCreationEditVOs != null){
			this.searchKpiCreationEditVOs = new SearchKpiCreationEditVO[searchKpiCreationEditVOs.length];
			for(int i=0; i<searchKpiCreationEditVOs.length; ++i){
				this.searchKpiCreationEditVOs[i] = searchKpiCreationEditVOs[i];
			}
		}
	}

	public SearchKpiCreationEditVO getSearchKpiCreationEditVO(){
		return searchKpiCreationEditVO;
	}

	public SearchKpiCreationEditVO[] getSearchKpiCreationEditVOS(){
		SearchKpiCreationEditVO[] ret = null;
		if(this.searchKpiCreationEditVOs != null){
			ret = new SearchKpiCreationEditVO[searchKpiCreationEditVOs.length];
			for(int i=0; i<searchKpiCreationEditVOs.length; i++){
				ret[i] = this.searchKpiCreationEditVOs[i];
			}
		}
		return ret;
	}
	
	
}