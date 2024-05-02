/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AocPopUpBC.java
*@FileTitle : AOC Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.04
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.aocpopup.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.aoc.common.aocpopup.vo.FdrCostBatchErrorVO;
import com.hanjin.apps.alps.esd.aoc.common.aocpopup.vo.InlandCostBatchErrorVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESD-AOC Business Logic Command Interface<br>
 * - ESD-AOC에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see BC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public interface AocPopUpBC  {
	
	/**
	 * @param inlandCostBatchErrorVO
	 * @return
	 * @throws EventException
	 */
	public List<InlandCostBatchErrorVO> searchInlandCostBatchError(InlandCostBatchErrorVO inlandCostBatchErrorVO) throws EventException;
	
	/**
	 * @param fdrCostBatchErrorVO
	 * @return
	 * @throws EventException
	 */
	public List<FdrCostBatchErrorVO> searchFdrCostBatchError(FdrCostBatchErrorVO fdrCostBatchErrorVO) throws EventException;
	
}