/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ActMappingHisBC.java
*@FileTitle : Actual Mapping History
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.copreport.actmappinghis.basic;


import java.util.List;

import com.clt.apps.opus.esd.sce.copreport.actmappinghis.vo.SearchActMappingHisVO;
import com.clt.framework.core.layer.event.EventException;

/**
 *  Business Logic Command Interface<br>
 * - 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see 
 * @since J2EE 1.4
 */
public interface ActMappingHisBC  {

	/**
	 * Actual Mapping History 조회
	 * 
	 * @param SearchActMappingHisVO searchActMappingHisVO
	 * @return List<SearchActMappingHisVO>
	 * @exception EventException
	 */
	public List<SearchActMappingHisVO> searchActMappingHisList(
			SearchActMappingHisVO searchActMappingHisVO) throws EventException;

}
