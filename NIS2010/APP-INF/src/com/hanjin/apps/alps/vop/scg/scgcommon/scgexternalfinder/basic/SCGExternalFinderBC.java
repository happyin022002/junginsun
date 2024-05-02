/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGExternalFinderBC.java
*@FileTitle : 공통유틸
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.17
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.15 이도형
* 1.0 Creation
*  
* History
* 2012.12.17 진마리아 [CHM-201221863-01] [VOP-SCG] Application Detail for Own BKG 에 combine, split 정보 추가
=========================================================*/
package com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.vo.BKGOutputVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.vo.CheckLaneVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.vo.SearchPortVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.vo.SearchVVDVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgBookingVO;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.ScgImdgCompGrpVO;
import com.hanjin.syscommon.common.table.MdmCarrierVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;


/**
 * ALPS-Scgcommon Business Logic Command Interface<br>
 * - ALPS-Scgcommon에 대한 비지니스 로직에 대한 인터페이스<br>
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
	 * 로그인사용자의 소속오피스에 해당되는 RSO 찾기
	 * 2011.04.08 추가 by 2004612<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchOfcRso(SignOnUserAccount account) throws EventException;

	/**
	 * 로그인사용자의 USR_ROLE_CD 검색 <br>
	 * 
	 * @param String pgmNo
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String checkUserRole(String pgmNo, SignOnUserAccount account) throws EventException;
	
	/**
	 * 입력된 Booking의 Split & Combine History 정보가 가장 최신 정보를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchBkgHistory(String bkgNo) throws EventException;
	
}