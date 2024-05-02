/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpfUtilBC.java
*@FileTitle : OpfUtil Common
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.vop.opf.opfcommon.opfutil.basic;

import java.util.List;

import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.ComComboVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.OpfComboVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.OpfUtilSearchOptVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.OpfXterCdConvVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.RdrRgnCdVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.SearchVVDVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.syscommon.common.table.BkgContainerVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.VskCarrierVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdVO;

/**
 * OPUS-Opfcommon Business Logic Command Interface<br>
 *
 * @author 
 * @see Reference OpfutilEventResponse 
 * @since J2EE 1.4
 */

public interface OpfUtilBC {
	/**
	 * Retrieve[OPF Combo]<br>
	 * 
	 * @param String comCode
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchCombo(String comCode) throws EventException; 
	
	/**
	 * Retrieve[I-Stowge Code]<br>
	 * 
	 * @param String comCode
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchComboGeneral(String comCode) throws EventException;
	
	/**
	 * Retrieve[Lane Code]<br>
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException;
	
	/**
	 * Retrieve[Lane Code]<br>
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> checkLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException;
	
	/**
	 * Retrieve[Carrier Code]<br>
	 * 
	 * @param VskCarrierVO vskCarrierVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> checkCarrier(VskCarrierVO vskCarrierVO) throws EventException;
	
	/**
	 * Retrieve [Yard of VVD]<br>
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchVvdYard(VskVslPortSkdVO vskVslPortSkdVO) throws EventException;
	
	/**
	 * Checking VVD<br>
	 * 
	 * @param VskVslSkdVO vskVslSkdVO
	 * @return List<SearchVVDVO>
	 * @exception EventException
	 */
	public List<SearchVVDVO> searchVVD(VskVslSkdVO vskVslSkdVO) throws EventException;
	
	/**
	 * Checking Container <br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<BkgContainerVO>
	 * @exception EventException
	 */
	public List<BkgContainerVO> searchContainer(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * Retrieve[Pod of VVD]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchVskVslPortList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * Retrieve[Pod of VVD]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchVskVslPortLoadVolList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * Retrieve[Container Type/Size]<br>
	 * 
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchCntrTpSzList() throws EventException;
	
    /**
     * Retrieve Port of VVD Code <br>
     * 
     * @param OpfUtilSearchOptVO opfUtilSearchOptVO
     * @return List<OpfUtilSearchOptVO>
     * @exception EventException
     */
    public List<OpfUtilSearchOptVO> searchVvdPort(OpfUtilSearchOptVO opfUtilSearchOptVO) throws EventException;
    
    /**
     * Retrieve Port Info <br>
     * 
     * @param  OpfUtilSearchOptVO opfUtilSearchOptVO
     * @return List<OpfComboVO> 
     * @throws DAOException
     */
     public List<OpfComboVO> searchPortInfo(OpfUtilSearchOptVO opfUtilSearchOptVO) throws EventException;

     /**
      * Checking Container No. Validation in MST_CONTAINE
      * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
      * @return List<OpfComboVO>
      * @throws EventException
      */
 	public List<OpfComboVO> searchCntrNoValid(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * Get RHQ_OFC_CD by OFC_CD
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchRHQofPortCd(String ofcCd) throws EventException;
	
	/**
	 * Get RHQ_OFC_CD by OFC_CD
	 * @return List<OpfComboVO>
	 * @throws EventException
	 */
	public List<OpfComboVO> searchRhqCdList() throws EventException;	
	
    /**
     * 공통코드를 조회 합니다. <br>
     * 
     * @param ComComboVO comComboVO
     * @return List<ComComboVO>
     * @exception EventException
     */
    public List<ComComboVO> searchComComboList(ComComboVO comComboVO) throws EventException;
    
	/**
	 * Retrieve[Region Code]<br>
	 * 
	 * @param RdrRgnCdVO rdrRgnCdVO
	 * @return List<RdrRgnCdVO>
	 * @exception EventException
	 */
	public List<RdrRgnCdVO> searchRegion(RdrRgnCdVO rdrRgnCdVO) throws EventException;

	/**
	 * Retrieve[Responsible Party Code]<br>
	 * 
	 * @param VskCarrierVO vskCarrierVO
	 * @return List<OpfXterCdConvVO>
	 * @exception EventException
	 */
	public List<OpfXterCdConvVO> searchParty(VskCarrierVO vskCarrierVO) throws EventException;
}