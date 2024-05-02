/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : ProductCatalogCreateBC.java
*@FileTitle : ProductCatalogCreate
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.22
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.08.22 정선용
* 1.0 Creation
* history
* 2010.08.31 채창호 [CHM-201005548-01]:[SCEM / PRD] F.H. 기능 연계한 개발요청
* 2012.05.31 박만건 [CHM-201217633] 구주 Hinterland
* 2012.08.17 정선용 [CHM-201219664] [PRD] Canada 향 D7 CNTR BKG block 을 위한 Hard-coding 설정요청	
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic;


import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0080Event;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdConstraintInfoVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdHinterlandInfoVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdPatternVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdQuantityVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSearchParamVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdParameterVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdQtyInfoVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Productcatalogcreate Business Logic Command Interface<br>
 * - ALPS-Productcatalogcreate에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author sun yong Jung
 * @see EventResponse 클래스파일 참조
 * @since J2EE 1.6
 */
public interface ProductCatalogCreateBC { 

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param PRD_PROD_CTL_DTL	pRD_PROD_CTL_DTL
	 * @return List<PRD_PROD_CTL_DTL>
	 * @exception EventException
	 */

	/**
	 * @param e
	 * @throws EventException
	 */
	public void createPrdCtlgFullRout(Event e) throws EventException;

//	public void updateContainerQtyforPreCm(Event e) throws EventException;
	
	/**
	 * @param e
	 * @param dbRowsetOcn
	 * @param railCargoAvailRtnTmMap
	 * @return
	 * @throws EventException
	 */
	public EventResponse selectPrdRoutUnit(Event e, DBRowSet dbRowsetOcn, Map railCargoAvailRtnTmMap)throws EventException;

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse selectPrdRoutUnit(Event e)throws EventException;

	/**
	 * @param e
	 * @param railCargoAvailRtnTmMap
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchRouteInfoByPctlNo(Event e, Map railCargoAvailRtnTmMap)throws EventException;

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchRouteInfoByPctlNo(Event e)throws EventException;

	/**
	 * @param minPctlNo
	 * @return
	 * @throws EventException
	 */
	public String selectReturnStrToBkg(String minPctlNo)throws EventException;
	
	/**
	 * @param prdParameterVO
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String createPrdCtlgRout(PrdParameterVO prdParameterVO, SignOnUserAccount account ) throws EventException ;

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchPrdCtlgFullRout(Event e)throws EventException;

	/**
	 * @param pctlNo
	 * @param bkgNo
	 * @return String
	 * @throws EventException
	 */
	public String searchPrdConstraint(String pctlNo, String bkgNo) throws EventException;
	
	
	/**
	 * @param pctlNo
	 * @param bkgNo
	 * @return String
	 * @throws EventException
	 */
	public String searchPrdImDgConstraint(String pctlNo, String bkgNo) throws EventException;

	/**
	 * @param e
	 * @param prdPatternVO
	 * @throws EventException
	 */
	public void createPrdCtlgIncludeReplane(Event e, PrdPatternVO prdPatternVO) throws EventException;	
	
	/**
	 * @param e
	 * @throws EventException
	 */
	public void addValCheck(Event e) throws EventException;
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public DBRowSet createPrdCtlgFullRoutForCOA(Event e) throws EventException;
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public DBRowSet createPrdCtlgFullRoutForCOAMAS(Event e) throws EventException;

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public List<PrdPatternVO> getReplanePatternForMultiPrd(Event e)throws EventException;
 
//	/**
//	 * @param mapSeq
//	 * @return
//	 * @throws EventException
//	 */
//	private List<PrdPatternVO> getReplanePatternByMapSeq(String mapSeq)throws EventException;

	/**
	 * @param mapSeq
	 * @param bkgNo
	 * @param mainPatternPctlNo
	 * @param copPattOrdNo
	 * @return
	 * @throws EventException
	 */
	public int updatePrdMapByPcNo(String mapSeq, String bkgNo,
			String mainPatternPctlNo, String copPattOrdNo)throws EventException;

	/**
	 * @param e
	 * @throws EventException
	 */
	public void createSubPatternPrdCtlgFullRout(Event e) throws EventException;

	/**
	 * @param event
	 * @return
	 * @throws EventException
	 */
	public DBRowSet createProductCatalogInquiry(Event event) throws EventException;

//	public DBRowSet createProductCatalogforPreCm(Event e) throws EventException;	
	
	/**
	 * @param event
	 * @return
	 * @throws EventException
	 */
	public List searchProductCatalogInquiryDetail(Event event) throws EventException;

//	public List searchProductCatalogforPreCmDetail(Event e) throws EventException;	
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchEqInventory(Event e) throws EventException;

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchCnstRemark(Event e) throws EventException;

	/**
	 *  split bkg 별로 bkg에서 call
	 * @param PrdParameterVO prdParameterVO
	 * @param SignOnUserAccount account
	 * @param List<String> cntrList
	 * @param int splitSeq
	 * @param List<String> bkgNoList
	 * @return String
	 * @throws EventException
	 */
	public String createPrdCtlgRoutSplit(PrdParameterVO prdParameterVO, SignOnUserAccount account, List<String> cntrList, int splitSeq , List<String> bkgNoList) throws EventException;

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse processReplaneFinish(Event e)throws EventException;
	
	/**
	 * @param PrdCreateParamVO prdCreateParamVO
	 * @throws EventException
	 */
	public void checkReplan(PrdCreateParamVO prdCreateParamVO)throws EventException;
	
	/**
	 * @param e
	 * @param creUsrId
	 * @return
	 * @throws EventException
	 */
	public String createIrgSoReplane(Event e,String creUsrId) throws EventException;	
	
	/**
	 * @param copNo
	 * @param ioBndCd
	 * @param creUsrId
	 * @return
	 * @throws EventException
	 */
	public String createSceSoReplan(String copNo,String ioBndCd ,String creUsrId) throws EventException;
	/**
	 * @param copNo
	 * @param ioBndCd
	 * @param creUsrId
	 * @return
	 * @throws EventException
	 */
	public String createSceSoReplanByBkgInfo(String copNo,String ioBndCd ,String creUsrId) throws EventException;
	
	/**
	 * @param copNo
	 * @param ioBndCd
	 * @param newNod
	 * @param creUsrId
	 * @return
	 * @throws EventException
	 */
	public String createSceManualReplan(String copNo,String ioBndCd ,String newNod ,String creUsrId) throws EventException;

//	public DBRowSet searchPrdOcnRout(String hdPctlNo) throws EventException;

	/**
	 * @param pctlNo
	 * @param prdQtyInfoVOs
	 * @param sumQty
	 * @param sumTpsz
	 * @return
	 */
	public Map getRailRecevingTime(String pctlNo, PrdQtyInfoVO[] prdQtyInfoVOs, String sumQty, String sumTpsz, String bkgNo);

	/**
	 * BKG 에서 "HJXX HJZZ HJYY" 인 vvd를 포함하는 vvd assign 시  바로 호출하는 메소드
	 * @param PrdParameterVO prdParameterVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String updateBkgAssignVvd(PrdParameterVO prdParameterVO, SignOnUserAccount account) throws EventException;

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public int updateMainMapSeq(Event e)throws EventException;
	
	//CHM-201005548-01:[SCEM / PRD] F.H. 기능 연계한 개발요청 메소드 추가
	/**
	 * @param String bkgNo - Booking 번호
	 * @param PrdQuantityVO[] prdQuantityVOs - 화면에서 제공되는 Booking Quantity 정보를 Parameter로 받는다.
	 * @return String - 화면 또는 DB에 있는 Booking Quantity 정보와 SO Quantity정보를 Merge한 것을 한줄의 String 형식으로 반환한다.
	 * @throws EventException
	 */
	public String getReplanCntrTpszQty(String bkgNo ,PrdQuantityVO[] prdQuantityVO) throws EventException;
	

	/**
	 * @param String pctlNo
	 * @return List<PrdConstraintInfoVO>
	 * @throws EventException
	 */
	public List<PrdConstraintInfoVO> searchPrdCnstInfoNode(String pctlNo) throws EventException;

	/**
	 * @param String pctlNo
	 * @return List<PrdConstraintInfoVO>
	 * @throws EventException
	 */
	public List<PrdConstraintInfoVO> searchPrdCnstInfoLink(String pctlNo) throws EventException;
	
	/**
	 * @param String pctlNo
	 * @return List<PrdConstraintInfoVO>
	 * @throws EventException
	 */
	public List<PrdConstraintInfoVO> searchPrdCnstInfoRoute(String pctlNo) throws EventException;
	
	/**
	 * @param prdSearchParamVO
	 * @return List<PrdConstraintInfoVO>
	 * @throws EventException
	 */
	public List<PrdConstraintInfoVO> searchPrdCnstInfoIrgPolPod(PrdSearchParamVO prdSearchParamVO) throws EventException;
	
	/**
	 * Hinterland관련한 PC를 생성한다.
	 * - Inland(Hinterland)의 PC는 H로 시작한다.
	 * - Feeder의 PC는 F로 시작한다.
	 * @param PrdHinterlandInfoVO hinterlandInfoVo
	 * @return PrdHinterlandInfoVO
	 */
	public PrdHinterlandInfoVO createPrdCtlgHinterland(PrdHinterlandInfoVO hinterlandInfoVo);

	/**
	 * @param String pctlNo
	 * @return String
	 * @throws EventException
	 */
	public String searchPrdCnstInfoCanadaException(String pctlNo) throws EventException;
	
	/**
	 * @param SignOnUserAccount account
	 * @param EsdPrd0080Event event
	 * @return String
	 * @throws EventException
	 */
	public String startPrdBackEndJob(SignOnUserAccount account, EsdPrd0080Event event) throws EventException;

	/**
	 * @param eventResponse
	 * @param event
	 * @throws EventException
	 */
	public void getERD(GeneralEventResponse eventResponse, EsdPrd0080Event event) throws EventException;

	/**
	 * @param e
	 * @throws EventException
	 */
	public void createPrdCtlgFullRoutWeb(Event e)  throws EventException;

}