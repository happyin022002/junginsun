/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoQuotationManageBC.java
*@FileTitle : SpecialCargoQuotationManageBC
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.18
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.18 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.SpecialCargoQuotationManageSC;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.TesAwkCgoTrfMngVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.TesBbCgoCostVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.TesBbCgoDtlVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.BlCustomerInfoVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.BbCgoApplVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.AwkCgoExtraCostByRouteVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.TesAwkCgoAdonHdrVO;
import com.hanjin.syscommon.common.table.TesAwkCgoAdonTpSzVO;
import com.hanjin.syscommon.common.table.TesAwkCgoTrfDtlVO;
import com.hanjin.syscommon.common.table.TesAwkCgoTrfHdrVO;
import com.hanjin.syscommon.common.table.TesAwkCgoTrfTpSzVO;

/**
 * ALPS-SpecialCargoQuotationManage Business Logic Command Interface<br>
 * - ALPS-SpecialCargoQuotationManage 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 이혜민
 * @see SpecialCargoQuotationManageSC 참조
 * @since J2EE 1.6
 */
public interface SpecialCargoQuotationManageBC {

	/**
	 * AWK Cargo Basic Tariff를 조회한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	
	public List<TesAwkCgoTrfMngVO> searchAwkCgoBasicTrf(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws EventException;
	/**
	 * AWK Cargo T/S Tariff를 조회한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	
	public List<TesAwkCgoTrfMngVO> searchAwkCgoTsTrf(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws EventException;
	/**
	 * AWK Cargo Add On Tariff를 조회한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	
	public List<TesAwkCgoTrfMngVO> searchAwkCgoAddOnTrf(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws EventException;
	/**
	 * Port Code 존재유무를 확인한다.
	 * 
	 * @param String ydCd
	 * @return String
	 * @exception EventException
	 */
	public String checkPort(String ydCd) throws EventException;
	/**
	 * 해당 Port에 해당하는 Terminal을 조회한다.
	 * 
	 * @param String ydCd
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TesAwkCgoTrfMngVO> searchTmlCd(String ydCd) throws EventException;
	/**
	 * Currency Code를 조회한다.
	 * 
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TesAwkCgoTrfMngVO> searchCurrCd() throws EventException;
	/**
	 * Main Yard 존재유무를 확인한다.
	 * 
	 * @param String ydCd
	 * @return String
	 * @exception EventException
	 */
	public String checkMnYdFlg(String ydCd) throws EventException;
	/**
	 * 최근 Batch가 실행된 Year Month 를 가져온다.
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String setYearMonth() throws EventException;
	/**
	 * Sheet에 입력한 Port+Tml Cd와 로그인 오피스를 비교하여 입력 권한을 체크한다.
	 * 
	 * @param String ydCd
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String checkYdCdInputAuth(String ydCd , String ofcCd) throws EventException;
	/**
	 * Sheet에 입력한 Port+Tml Cd와 로그인 오피스를 비교하여 입력 권한을 체크한다.
	 * 
	 * @param String fmYdCd
	 * @param String toYdCd
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String checkYdCdInputAuthAddon(String fmYdCd, String toYdCd, String ofcCd) throws EventException;
	/**
	 * AWK Cargo Basic Tariff를 AwkCgoBasicTrfHdr에 delete한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfHdrVO> deleteHdrList
	 * @exception EventException
	 */
	public void removeAwkCgoBasicTrfHdr(List<TesAwkCgoTrfHdrVO> deleteHdrList) throws EventException;
	/**
	 * AWK Cargo Basic Tariff를 AwkCgoBasicTrfDtl에 delete한다<br>
	 * 
	 * @param List<TesAwkCgoTrfDtlVO> deleteDtlList
	 * @exception EventException
	 */
	public void removeAwkCgoBasicTrfDtl(List<TesAwkCgoTrfDtlVO> deleteDtlList) throws EventException;
	/**
	 * AWK Cargo Basic Tariff를 AwkCgoBasicTrfTpSz에 delete한다<br>
	 * 
	 * @param List<TesAwkCgoTrfTpSzVO> deleteTpszList
	 * @exception EventException
	 */
	public void removeAwkCgoBasicTrfTpSz(List<TesAwkCgoTrfTpSzVO> deleteTpszList) throws EventException;
	/**
	 * AWK Cargo Basic Tariff를 AwkCgoBasicTrfHdr에 insert, update한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfHdrVO> InsUpdHdrList
	 * @exception EventException
	 */
	public void modifyAwkCgoBasicTrfHdr(List<TesAwkCgoTrfHdrVO> InsUpdHdrList) throws EventException;
	/**
	 * AWK Cargo Basic Tariff를 AwkCgoBasicTrfDtl에 insert 한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfDtlVO> InsUpdDtlList
	 * @exception EventException
	 */
	public void modifyAwkCgoBasicTrfDtl(List<TesAwkCgoTrfDtlVO> InsUpdDtlList) throws EventException;
	/**
	 * AWK Cargo Basic Tariff를 AwkCgoBasicTrfTpSz에 insert, update한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfTpSzVO> InsUpdTpszList
	 * @exception EventException
	 */
	public void modifyAwkCgoBasicTrfTpSz(List<TesAwkCgoTrfTpSzVO> InsUpdTpszList) throws EventException;
	/**
	 * AWK Cargo T/S Tariff를 AwkCgoTsTrfHdr에 delete한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfHdrVO> deleteHdrList
	 * @exception EventException
	 */
	public void removeAwkCgoTsTrfHdr(List<TesAwkCgoTrfHdrVO> deleteHdrList) throws EventException;
	/**
	 * AWK Cargo T/S Tariff를 AwkCgoTsTrfDtl에 delete한다<br>
	 * 
	 * @param List<TesAwkCgoTrfDtlVO> deleteDtlList
	 * @exception EventException
	 */
	public void removeAwkCgoTsTrfDtl(List<TesAwkCgoTrfDtlVO> deleteDtlList) throws EventException;
	/**
	 * AWK Cargo T/S Tariff를 AwkCgoTsTrfTpSz에 delete한다<br>
	 * 
	 * @param List<TesAwkCgoTrfTpSzVO> deleteTpszList
	 * @exception EventException
	 */
	public void removeAwkCgoTsTrfTpSz(List<TesAwkCgoTrfTpSzVO> deleteTpszList) throws EventException;
	/**
	 * AWK Cargo T/S Tariff를 AwkCgoTsTrfHdr에 insert, update한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfHdrVO> InsUpdHdrList
	 * @exception EventException
	 */
	public void modifyAwkCgoTsTrfHdr(List<TesAwkCgoTrfHdrVO> InsUpdHdrList) throws EventException;
	/**
	 * AWK Cargo T/S Tariff를 AwkCgoTsTrfDtl에 insert 한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfDtlVO> InsUpdDtlList
	 * @exception EventException
	 */
	public void modifyAwkCgoTsTrfDtl(List<TesAwkCgoTrfDtlVO> InsUpdDtlList) throws EventException;
	/**
	 * AWK Cargo T/S Tariff를 AwkCgoTsTrfTpSz에 insert, update한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfTpSzVO> InsUpdTpszList
	 * @exception EventException
	 */
	public void modifyAwkCgoTsTrfTpSz(List<TesAwkCgoTrfTpSzVO> InsUpdTpszList) throws EventException;
	/**
	 * AWK Cargo Basic Tariff History를 조회한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TesAwkCgoTrfMngVO> searchAwkCgoBasicTrfHis(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws EventException;
	/**
	 * AWK Cargo T/S Tariff History를 조회한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TesAwkCgoTrfMngVO> searchAwkCgoTsTrfHis(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws EventException;
	/**
	 * AWK Cargo Add-On Tariff History를 조회한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TesAwkCgoTrfMngVO> searchAwkCgoAddOnTrfHis(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws EventException;
	/**
	 * AWK Cargo Add-On Tariff를 AwkCgoAdonTrfHdr에 insert 한다.<br>
	 * 
	 * @param List<TesAwkCgoAdonHdrVO> insUpdHdrList
	 * @exception EventException
	 */
	public void modifyAwkCgoAddOnTrfHdr(List<TesAwkCgoAdonHdrVO> insUpdHdrList) throws EventException;
	/**
	 * AWK Cargo Add-On Tariff를 AwkCgoAdonTrfTpSz에 insert, update한다.<br>
	 * 
	 * @param List<TesAwkCgoAdonTpSzVO> insUpdTpszList 
	 * @exception EventException
	 */
	public void modifyAwkCgoAddOnTrfTpSz(List<TesAwkCgoAdonTpSzVO> insUpdTpszList) throws EventException;
	/**
	 * AWK Cargo Add-On Tariff를 AwkCgoAdonTrfTpSz에 delete한다<br>
	 * 
	 * @param List<TesAwkCgoAdonTpSzVO> deleteTpszList
	 * @exception EventException
	 */
	public void removeAwkCgoAddOnTrfTpSz(List<TesAwkCgoAdonTpSzVO> deleteTpszList) throws EventException;
	/**
	 * AWK Cargo Add-On Tariff를 AwkCgoAdonTrfHdr에 delete한다<br>
	 * 
	 * @param List<TesAwkCgoAdonHdrVO> deleteHdrList
	 * @exception EventException
	 */
	public void removeAwkCgoAddOnTrfHdr(List<TesAwkCgoAdonHdrVO> deleteHdrList) throws EventException;
	/**
	 * Load / Unload Extra Cost를 조회한다.<br>
	 * 
	 * @param AwkCgoExtraCostByRouteVO awkCgoExtraCostByRouteVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TesAwkCgoTrfMngVO> searchLoadUnloadExtCost(AwkCgoExtraCostByRouteVO awkCgoExtraCostByRouteVO) throws EventException;
	/**
	 * Load / Unload T/S Extra Cost를 조회한다.<br>
	 * 
	 * @param AwkCgoExtraCostByRouteVO awkCgoExtraCostByRouteVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TesAwkCgoTrfMngVO> searchLoadUnloadTsExtCost(AwkCgoExtraCostByRouteVO awkCgoExtraCostByRouteVO) throws EventException;
	/**
	 * BB Booking Information을 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @return BbCgoApplVO
	 * @exception EventException
	 */
	public BbCgoApplVO searchBbCargoInfo(String bkgNo) throws EventException;
	/**
	 * BB Booking Customer Infomation을 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @return BlCustomerInfoVO
	 * @exception EventException
	 */
	public BlCustomerInfoVO searchBkgCustomer(String bkgNo) throws EventException;
	/**
	 * BB Booking Cost Information을 조회한다.<br>
	 * 
	 * @param TesBbCgoCostVO tesBbCgoCostVO
	 * @return List<TesBbCgoCostVO>
	 * @exception EventException
	 */
	public List<TesBbCgoCostVO> searchBbCargoCostInfo(TesBbCgoCostVO tesBbCgoCostVO) throws EventException;
	/**
	 * BB Booking No을 조회한다.<br>
	 * 
	 * @param TesBbCgoCostVO tesBbCgoCostVO
	 * @return List<TesBbCgoCostVO>
	 * @exception EventException
	 */
	public List<TesBbCgoCostVO> searchBbBkgNo(TesBbCgoCostVO tesBbCgoCostVO) throws EventException;
	/**
	 * BB Cargo Amount 를 insert, update한다.<br>
	 * 
	 * @param TesBbCgoCostVO[] tesBbCgoCostVOs
	 * @param TesBbCgoDtlVO[] tesBbCgoDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBbCargoCostAmount(TesBbCgoCostVO[] tesBbCgoCostVOs, TesBbCgoDtlVO[] tesBbCgoDtlVOs,SignOnUserAccount account) throws EventException;
	/**
	 * AWK Cargo Add On Tariff를 Verify한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return String
	 * @exception EventException
	 */	
	public String verifyAwkCgoAddOnTrf(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws EventException;
	/**
	 * AWK Cargo Basic Tariff를 Verify한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return String
	 * @exception EventException
	 */	
	public String verifyAwkCgoBasicTrf(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws EventException;
	/**
	 * AWK Cargo T/S Tariff를 Verify한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return String
	 * @exception EventException
	 */	
	public String verifyAwkCgoTsTrf(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws EventException;
	/**
	 * AWK Cargo Add On Tariff의 local curr를 USD로 바꾼다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return TesAwkCgoTrfMngVO
	 * @exception EventException
	 */	
	public TesAwkCgoTrfMngVO searchUSDExchange(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws EventException;
	
}