/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ProductCatalogCreateBC.java
 *@FileTitle : ProductCatalogCreate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic;

import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0080Event;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdPatternVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdQuantityVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdParameterVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdQtyInfoVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Productcatalogcreate Business Logic Command Interface<br>
 * 
 * @author sun yong Jung
 * @see EventResponse
 * @since J2EE 1.6
 */
public interface ProductCatalogCreateBC {

	/**
	 * PC create logic for creating PC at BKG
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EsdPrd0080Event createPrdCtlgFullRout(Event e) throws EventException;

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse selectPrdRoutUnit(Event e) throws EventException;

	/**
	 * @param e
	 * @param railCargoAvailRtnTmMap
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchRouteInfoByPctlNo(Event e, Map<String, String> railCargoAvailRtnTmMap) throws EventException;

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchRouteInfoByPctlNo(Event e) throws EventException;

	/**
	 * @param minPctlNo
	 * @return
	 * @throws EventException
	 */
	public String selectReturnStrToBkg(String minPctlNo) throws EventException;

	/**
	 * @param prdParameterVO
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String createPrdCtlgRout(PrdParameterVO prdParameterVO, SignOnUserAccount account) throws EventException;

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchPrdCtlgFullRout(Event e) throws EventException;

	/**
	 * @param pctlNo
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchPrdConstraint(String pctlNo) throws EventException;

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
	public List<PrdPatternVO> getReplanePatternForMultiPrd(Event e) throws EventException;

	// /**
	// * @param mapSeq
	// * @return
	// * @throws EventException
	// */
	// private List<PrdPatternVO> getReplanePatternByMapSeq(String mapSeq)throws EventException;

	/**
	 * @param mapSeq
	 * @param bkgNo
	 * @param mainPatternPctlNo
	 * @param copPattOrdNo
	 * @return
	 * @throws EventException
	 */
	public int updatePrdMapByPcNo(String mapSeq, String bkgNo, String mainPatternPctlNo, String copPattOrdNo) throws EventException;

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

	// public DBRowSet createProductCatalogforPreCm(Event e) throws EventException;

	/**
	 * @param event
	 * @return
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public List searchProductCatalogInquiryDetail(Event event) throws EventException;

	// public List searchProductCatalogforPreCmDetail(Event e) throws EventException;

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
	 * calling from each bkg
	 * 
	 * @param PrdParameterVO prdParameterVO
	 * @param SignOnUserAccount account
	 * @param List<String> cntrList
	 * @param int splitSeq
	 * @param List<String> bkgNoList
	 * @return String
	 * @throws EventException
	 */
	public String createPrdCtlgRoutSplit(PrdParameterVO prdParameterVO, SignOnUserAccount account, List<String> cntrList, int splitSeq, List<String> bkgNoList) throws EventException;

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse processReplaneFinish(Event e) throws EventException;

	/**
	 * @param PrdCreateParamVO prdCreateParamVO
	 * @throws EventException
	 */
	public void checkReplan(PrdCreateParamVO prdCreateParamVO) throws EventException;

	/**
	 * @param e
	 * @param creUsrId
	 * @return
	 * @throws EventException
	 */
	public String createIrgSoReplane(Event e, String creUsrId) throws EventException;

	/**
	 * @param copNo
	 * @param ioBndCd
	 * @param creUsrId
	 * @return
	 * @throws EventException
	 */
	public String createSceSoReplan(String copNo, String ioBndCd, String creUsrId) throws EventException;

	/**
	 * @param copNo
	 * @param ioBndCd
	 * @param creUsrId
	 * @return
	 * @throws EventException
	 */
	public String createSceSoReplanByBkgInfo(String copNo, String ioBndCd, String creUsrId) throws EventException;

	/**
	 * @param copNo
	 * @param ioBndCd
	 * @param newNod
	 * @param creUsrId
	 * @return
	 * @throws EventException
	 */
	public String createSceManualReplan(String copNo, String ioBndCd, String newNod, String creUsrId) throws EventException;

	// public DBRowSet searchPrdOcnRout(String hdPctlNo) throws EventException;

	/**
	 * @param pctlNo
	 * @param prdQtyInfoVOs
	 * @param sumQty
	 * @param sumTpsz
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map getRailRecevingTime(String pctlNo, PrdQtyInfoVO[] prdQtyInfoVOs, String sumQty, String sumTpsz);

	/**
	 * calling in case of assigning vvd which contains "COXX COZZ COYY"
	 * 
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
	public int updateMainMapSeq(Event e) throws EventException;

	/**
	 * @param String bkgNo
	 * @param PrdQuantityVO[] prdQuantityVOs
	 * @return String
	 * @throws EventException
	 */
	public String getReplanCntrTpszQty(String bkgNo, PrdQuantityVO[] prdQuantityVO) throws EventException;

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public String checkEmptyPickUpYardValid(Event e) throws EventException;

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public String checkTpSz(Event e) throws EventException;

	/**
	 * 
	 * @param prdParameterVO
	 * @throws EventException
	 */
	public void modifyPrdProdCtlMstByPRI(PrdParameterVO prdParameterVO) throws EventException;

	/**
	 * searchInlandCutOffTime
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public String searchInlandCutOffTime(Event e) throws EventException;

}