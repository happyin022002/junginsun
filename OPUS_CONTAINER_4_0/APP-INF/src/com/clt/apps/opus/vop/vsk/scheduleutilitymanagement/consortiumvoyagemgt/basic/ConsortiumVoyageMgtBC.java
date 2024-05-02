/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ConsortiumVoyageMgtBC.java
 *@FileTitle : ConsortiumVoyageMgtBC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.09.29
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.09.29 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.basic;

import java.util.List;

import com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.vo.ConsortiumVoyageVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdVO;

/**
 * @author
 * @see
 * @since J2EE 1.6
 */

public interface ConsortiumVoyageMgtBC {
	/**
	 * Retrieving
	 * 
	 * @param ConsortiumVoyageVO consortiumVoyageVO
	 * @return List<ConsortiumVoyageVO>
	 * @exception EventException
	 */
	public List<ConsortiumVoyageVO> searchConsortiumVoyage(ConsortiumVoyageVO consortiumVoyageVO) throws EventException;
	
	/**
	 * update from vsk_vsl_port_skd-side modifications
	 * @param 		List<ConsortiumVoyageVO> consortiumVoyageVOs
	 * @throws 		EventException
	 */
	public void modifyConsortiumVoyage(List<ConsortiumVoyageVO> consortiumVoyageVOs) throws EventException ;
	
	/**
	 * update from vsk_vsl_port_skd-side modifications
	 * @param 		List<ConsortiumVoyageVO> consortiumVoyageVOs
	 * @throws 		EventException
	 */
	public void modifyConsortiumVoyageList(List<ConsortiumVoyageVO> consortiumVoyageVOs) throws EventException ;
	
	// :: VIPS START ::
	/**
	 * Retrieving Vessel Port SKD
	 * @return List<VskVslPortSkdVO>
	 */
	public List<VskVslPortSkdVO> getVslPortSkdList();
	// :: VIPS END ::
	
	/**
	 * Retrieving Vessel SKD
	 * @return List<VskVslSkdVO>
	 */
	public List<VskVslSkdVO> getVskVslSkdList();
	// :: VIPS END ::
	
}
