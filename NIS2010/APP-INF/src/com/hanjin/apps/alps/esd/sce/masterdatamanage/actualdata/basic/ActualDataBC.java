/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ActualDataBC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : Se-Hoon PARK
*@LastVersion : 1.0
* 2006-08-29 Se-Hoon PARK
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.vo.SearchActualDataInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.vo.SearchActualDataListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.MdmActivityVO;


/**
 * ENIS-SCEM Commission Business Logic Command Interface<br>
 * - ENIS-SCEM Commission에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kildong_hong
 * @see UI_ID_11EventResponse 참조
 * @since J2EE 1.4
 */
public interface ActualDataBC  {

	/**
     * Actual Source Registration 조회<br>
     *
     * @param SearchActualDataInfoVO actInfo
     * @return List<SearchActualDataListVO>
     * @exception EventException
     */
    public List<SearchActualDataListVO> searchActualSourceList(SearchActualDataInfoVO actInfo) throws EventException;
    
	/**
	 * Activity 콤보를 조회 합니다.<br>
	 * 
	 * @return List<MdmActivityVO>
	 * @exception EventException
	 */
	public List<MdmActivityVO> searchActivityCombo() throws EventException;
}