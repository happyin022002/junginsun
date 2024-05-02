/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0034Event.java
*@FileTitle : Demand Forecast Parameter Management 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.01 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchAutoRunParameterVO;
import com.hanjin.syscommon.common.table.EqrAutoRunFcastParaVO;

/**
 * EES_EQR_0034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Change Ho
 * @see EES_EQR_0034HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0034Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAutoRunParameterVO searchAutoRunParameter = null;
	
	/** Table Value Object Multi Data 처리 */
	//private searchAutoRunParameterVO[] searchAutoRunParameters = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrAutoRunFcastParaVO[] eqrAutoRunFcastParaVO = null;
	
	/** Table Value Object 단건 Data 처리 */
	private EqrAutoRunFcastParaVO eqrAutoRunFcastParaVOs = null;


	/**
	 * @return the eqrAutoRunFcastParaVOs
	 */
	public EqrAutoRunFcastParaVO getEqrAutoRunFcastParaVOs() {
		return eqrAutoRunFcastParaVOs;
	}

	/**
	 * @param eqrAutoRunFcastParaVOs the eqrAutoRunFcastParaVOs to set
	 */
	public void setEqrAutoRunFcastParaVOs(EqrAutoRunFcastParaVO eqrAutoRunFcastParaVOs) {
		this.eqrAutoRunFcastParaVOs = eqrAutoRunFcastParaVOs;
	}

	/**
	 * @return the eqrAutoRunFcastParaVO
	 */
	public EqrAutoRunFcastParaVO[] getEqrAutoRunFcastParaVO() {
		return eqrAutoRunFcastParaVO;
	}

	/**
	 * @param eqrAutoRunFcastParaVO the eqrAutoRunFcastParaVO to set
	 */
	public void setEqrAutoRunFcastParaVO(EqrAutoRunFcastParaVO[] eqrAutoRunFcastParaVO) {
		this.eqrAutoRunFcastParaVO = eqrAutoRunFcastParaVO;
	}

	public EesEqr0034Event(){}
	
	public void setsearchAutoRunParameter(SearchAutoRunParameterVO searchAutoRunParameter){
		this. searchAutoRunParameter = searchAutoRunParameter;
	}

//	public void setsearchAutoRunParameterS(searchAutoRunParameterVO[] searchAutoRunParameters){
//		this. searchAutoRunParameters = searchAutoRunParameters;
//	}

	public SearchAutoRunParameterVO getsearchAutoRunParameter(){
		return searchAutoRunParameter;
	}

//	public searchAutoRunParameterVO[] getsearchAutoRunParameterS(){
//		return searchAutoRunParameters;
//	}

}
