/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMgtForGateNewBC.java
*@FileTitle : GATENEW Business Logic Command Interface
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.FlatFileForGateNewVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDICtmEqMvmtListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;


/**
 * OPUS-Equipmentmovementmgt Business Logic Command Interface
 *
 * @author \
 * @see Ees_ctm_0000EventResponse reference
 * @see UbizComOpusCtmEqmvmt EventResponse(MQ message INBOUND) reference
 * @since J2EE 1.4
 */
public interface ContainerMovementMgtForGateNewBC {

	/**
	 * GATE NEW <br>
	 *  Container Movement EDI Batch<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @return FlatFileVOForGateNew
	 * @exception EventException
	 */
	public FlatFileForGateNewVO gateNew( FlatFileForGateNewVO flatFileForGateNewVO ) throws EventException;
	
	/**
	 * EppBookingNew <br>
	 *  Container Movement EDI Batch<br>
	 *
	 * @param String flatFile
	 * @return SearchEDICtmEqMvmtListVO
	 * @exception EventException
	 */
	public List<SearchEDICtmEqMvmtListVO> setEppBookingNew( String flatFile) throws EventException;
	/**
	 * checking ACIAC_DIV_CD 
	 *
	 * @param String cntrNumber
	 * @param String bkgNumber
	 * @return String[]
	 * @throws DAOException,Exception
	 */
	public String[] checkAciacDivCd(String cntrNumber, String bkgNumber) throws DAOException,Exception;

	/**
	 * resultUpdb for GateNew<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return SearchEDIMovementListVO
	 * @exception EventException
	 **/
	public SearchEDIMovementListVO resultUpdb( SearchEDIMovementListVO searchEDIMovementListVO ) throws EventException;

	/**
	 * assignCommonVO for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @param int bkgKnt
	 * @return CusCtmMovementVO[]
	 * @exception EventException
	 **/
	public CusCtmMovementVO[] assignCommonVO( FlatFileForGateNewVO flatFileForGateNewVO, int bkgKnt ) throws EventException;

	/**
	 * assignSPPVO2FlatFileVO for GateNew<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @return FlatFileForGateNewVO
	 * @exception EventException
	 **/
	public FlatFileForGateNewVO assignSPPVO2FlatFileVO( CusCtmMovementVO cusCtmMovementVO ) throws EventException;

	/**
	 * assignFlatFileVO from MQ Messege<br>
	 *
	 * @param String flatFile
	 * @return FlatFileVOForGateNew[]
	 * @exception EventException
	 **/
	public FlatFileForGateNewVO[] assignFlatFileVO( String flatFile ) throws EventException;

	/**
	 * checking English Y/N
	 *
	 * @param String str
	 * @return Boolean
	 */
	public Boolean isAlpha( String str );

	/**
	 * assignEdiUiVO2FlatFileVO for GateNew<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return FlatFileForGateNewVO
	 * @exception EventException
	 **/
	public FlatFileForGateNewVO assignEdiUiVO2FlatFileVO( SearchEDIMovementListVO searchEDIMovementListVO ) throws EventException;

	/**
	 * assignFlatFileVO2EdiUiVO for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return SearchEDIMovementListVO
	 * @exception EventException
	 **/
	public SearchEDIMovementListVO assignFlatFileVO2EdiUiVO( FlatFileForGateNewVO flatFileForGateNewVO, SearchEDIMovementListVO searchEDIMovementListVO ) throws EventException;

}