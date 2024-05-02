/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LseCommonBC.java
*@FileTitle : ETC LesCommon Code Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.09.29 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.lsecommon.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.vo.CdListVO;
import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.vo.LseRntlCostAcctOrdVO;
import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.vo.SearchInvoiceNoVO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.CommonListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.MstContainerVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;

/**
 * LseCommon Business Logic Command Interface<br>
 * LseCommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Jun-Woo
 * @see UI_LSE_0020EventResponse 참조
 * @since J2EE 1.6
 */
public interface LseCommonBC {
	/**
	 * Location - Port 코드목록을 조회합니다.<br>
	 *
	 * @param  String locCd
	 * @return List<MdmLocationVO>
	 * @exception EventException
	 */
	public List<MdmLocationVO> searchLocationPortBasic(String locCd) throws EventException;

	/**
	 * Vessel SKD 목록을 조회합니다.<br>
	 *
	 * @param  String vvdCd
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdVO> searchVesselSkdBasic(String vvdCd) throws EventException;

	/**
	 * 컨테이너 정보 조회합니다.<br>
	 *
	 * @param  String cntrNo
	 * @return MstContainerVO
	 * @exception EventException
	 */
	public MstContainerVO searchContainerInfoBrieflyBasic(String cntrNo) throws EventException;

	/**
	 * Office 코드목록을 조회합니다.<br>
	 *
	 * @param  String ofcCd
	 * @return List<MdmOrganizationVO>
	 * @exception EventException
	 */
	public List<MdmOrganizationVO> searchOfficeCodeBasic(String ofcCd) throws EventException;

	/**
	 * Vessel SVC Lane 목록을 조회합니다.<br>
	 *
	 * @param  String slanCd
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchServiceLaneBasic(String slanCd) throws EventException;
	
	/**
	 * Container Use Company 리스트 조회<br>
	 * 
	 * @param  CdListVO cdListVO
	 * @return List<CdListVO>
	 * @exception EventException
	 */
	public List<CdListVO> searchCntrUseCoCdListBasic(CdListVO cdListVO) throws EventException;
	
	/**
	 * Container Use Company 리스트 조회<br>
	 * 
	 * @param  CdListVO cdListVO
	 * @return List<CdListVO>
	 * @exception EventException
	 */
	public List<CdListVO> searchCompanyListBasic(CdListVO cdListVO) throws EventException;
	
	/**
	 * LP Term Lessor 리스트 조회<br>
	 * 
	 * @param  CdListVO cdListVO
	 * @return List<CdListVO>
	 * @exception EventException
	 */
	public List<CdListVO> searchVndrSeqListBasic(CdListVO cdListVO) throws EventException;
	
	/**
	 * 
	 * @return
	 * @throws EventException
	 */
	public List<LseRntlCostAcctOrdVO> searchRentalCostAccountOrdBasic () throws EventException;
	
	/**
	 * 
	 * @param lseRntlCostAcctOrdVOs
	 * @throws EventException
	 */
	public void manageRentalCostAccountOrdBasic(LseRntlCostAcctOrdVO[] lseRntlCostAcctOrdVOs) throws EventException;

	/**
	 * 
	 * @return  List<LseRntlCostAcctOrdVO>
	 * @throws EventException
	 */
	public List<LseRntlCostAcctOrdVO> searchChargeTpCd() throws EventException; 
	
	/**
	 * 
	 * @return  List<LseRntlCostAcctOrdVO>
	 * @throws EventException
	 */
	public List<LseRntlCostAcctOrdVO> searchLeaseTerm() throws EventException;

	/**
	 * @param intgCdId String
	 * @return List<CommonListVO>
	 * @exception EventException
	 */	
	public List<CommonListVO> searchComIntgCdBasic(String intgCdId) throws EventException;
	
	/**
	 * Search The Invoice No.
	 * @param SearchInvoiceNoVO searchInvoiceNoVO
	 * @return List<SearchInvoiceNoVO>
	 * @exception EventException
	 */
	public List<SearchInvoiceNoVO> searchInvoiceNo(SearchInvoiceNoVO searchInvoiceNoVO) throws EventException;
	
	/**
	 * Search Blud Up Date
	 * @param String schDate 
	 * @param String agmtSeq 
	 * @return String
	 * @exception EventException
	 */	
	public String searchBldUpDateCheckBasic(String schDate, String agmtSeq) throws EventException;
}
