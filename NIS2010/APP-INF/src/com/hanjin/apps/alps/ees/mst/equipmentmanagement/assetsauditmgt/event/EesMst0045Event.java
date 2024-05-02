/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0045Event.java
*@FileTitle :  Container Average using Day by TP/SZ
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.09.18 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqAverageUsingDayVO;
import com.hanjin.framework.support.layer.event.EventSupport;
/**
 * EES_MST_0045 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0045HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Sun
 * @see EES_MST_0045HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0045Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	/**
	 * @return the eqAverageUsingDayVOs
	 */
	public EqAverageUsingDayVO[] getEqAverageUsingDayVOs() {
		return eqAverageUsingDayVOs;
	}

	/**
	 * @param eqAverageUsingDayVOs the eqAverageUsingDayVOs to set
	 */
	public void setEqAverageUsingDayVOs(EqAverageUsingDayVO[] eqAverageUsingDayVOs) {
		this.eqAverageUsingDayVOs = eqAverageUsingDayVOs;
	}

	/**
	 * @return the eqAverageUsingDayVO
	 */
	public EqAverageUsingDayVO getEqAverageUsingDayVO() {
		return eqAverageUsingDayVO;
	}

	/**
	 * @param eqAverageUsingDayVO the eqAverageUsingDayVO to set
	 */
	public void setEqAverageUsingDayVO(EqAverageUsingDayVO eqAverageUsingDayVO) {
		this.eqAverageUsingDayVO = eqAverageUsingDayVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	public EqAverageUsingDayVO[] eqAverageUsingDayVOs = null;
	
	/** 검색결과 **/
	private EqAverageUsingDayVO eqAverageUsingDayVO = null;	

}