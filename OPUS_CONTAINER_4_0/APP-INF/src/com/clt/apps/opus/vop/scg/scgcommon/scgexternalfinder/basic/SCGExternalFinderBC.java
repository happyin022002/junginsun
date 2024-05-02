/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGExternalFinderBC.java
*@FileTitle : 공통유틸
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.15
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.15 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.basic;

import java.util.List;

import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.vo.BKGOutputVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.vo.CheckLaneVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.vo.SearchPortVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.vo.SearchVVDVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.MdmCarrierVO;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
import com.clt.syscommon.common.table.MdmCntrTpVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.ScgImdgCompGrpVO;
import com.clt.syscommon.common.table.VskVslSkdVO;


/**
 * OPUS-Scgcommon Business Logic Command Interface<br>
 * - OPUS-Scgcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Dohyoung Lee
 * @see Scg_com_EventResponse 참조
 * @since J2EE 1.4
 */

public interface SCGExternalFinderBC {
	/**
	 * Carreier Code를 체크한다. <br>
	 * 
	 * @param String crrCd
	 * @return List<MdmCarrierVO>
	 * @exception EventException
	 */
	public List<MdmCarrierVO> checkCarrier(String crrCd) throws EventException;

	/**
     * Lane Code를 체크한다. <br>
	 * 
	 * @param  String vslSlanCd
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> checkLane(String vslSlanCd) throws EventException;

	/**
	 * PortCode 체크한다. <br>
	 * 
	 * @param  String portCode
	 * @return String
	 * @exception EventException
	 */
	public String checkPort(String portCode) throws EventException;	
 
	
	/**
     * Booking 정보를 체크한다.
     * 
	 * @param bkgBookingVO
	 * @return List<BKGOutputVO>
	 * @exception EventException
	 */
	public List<BKGOutputVO> checkBKG(BkgBookingVO bkgBookingVO) throws EventException;
	
	/**
	 * Booking BL 체크한다. <br>
	 * 
	 * @param bkgBookingVO
	 * @return List<BKGOutputVO>
	 * @exception EventException
	 */
	public List<BKGOutputVO> checkBL(BkgBookingVO bkgBookingVO) throws EventException;
	
	/**
	 * VVD Code를 체크한다. <br>
	 * 
	 * @param vskVslSkdVO
	 * @return List<SearchVVDVO>
	 * @exception EventException
	 */
	public List<SearchVVDVO> searchVVD(VskVslSkdVO vskVslSkdVO) throws EventException;
	
	/**
	 * Container Type Size 를 조회한다. <br>
	 * 
	 * @param mdmCntrTpSzVO
	 * @return List<MdmCntrTpSzVO>
	 * @exception EventException
	 */
	public List<MdmCntrTpSzVO> searchCNTRTPSZ(MdmCntrTpSzVO mdmCntrTpSzVO) throws EventException;
	

	/**
	 * Comp Group 을 조회한다. <br>
	 * 
	 * @param  imdgCompGrpCd
	 * @return List<ScgImdgCompGrpVO>
	 * @throws DAOException
	 */
	public List<ScgImdgCompGrpVO> searchCompGrp(String imdgCompGrpCd) throws EventException;
	
	/**
	 * 프레임워크의 공통코드(코드,명칭)조회<br>
	 *
	 * @param  String intgCdId
	 * @param  int sortkey
	 * @param  String exceptKey
	 * @return String
	 * @exception EventException
	 */
	public String getCodeSelect(String intgCdId, int sortkey, String exceptKey) throws EventException;
	
	
	
	/**
	 * Class Comp 를 조회한다. <br>
	 * 
	 * @param  ScgImdgCompGrpVO scgImdgCompGrpVO
	 * @return List<ScgImdgCompGrpVO>
	 * @exception EventException
	 */
	public List<ScgImdgCompGrpVO> searchClassComp(ScgImdgCompGrpVO scgImdgCompGrpVO) throws EventException;
	
	/**
	 * VVD내의 Port 목록을 가져온다.<br>
	 * 
	 * @param  SearchPortVO searchPortVO
	 * @return List<SearchPortVO>
	 * @exception EventException
	 */
	public List<SearchPortVO> searchPort(SearchPortVO searchPortVO) throws EventException;
 
    /**
     * POL과 POD 사이의 TARGET LANE CODE를 조회한다.<br>
     *
     * @param   String pol
     * @param   String  pod
     * @throws  EventException
     * @return  List<CheckLaneVO> 
     * @author  jang kang cheol
     */	
    public List<CheckLaneVO> searchTargetLane(String pol, String pod) throws EventException;	
    	
	/**
	 * Container Type retrieve <br>
	 * 
	 * @param mdmCntrTpVO
	 * @return List<MdmCntrTpVO>
	 * @exception EventException
	 */
	public List<MdmCntrTpVO> searchCNTRTP(MdmCntrTpVO mdmCntrTpVO) throws EventException;
 
}