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
package com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.SpecialCargoQuotationManageSC;
import com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.vo.TrsAwkCgoTrfMngVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.AwkCgoExtraCostByRouteVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.TrsAwkCgoTrfHdrVO;
import com.hanjin.syscommon.common.table.TrsAwkCgoTrfTpSzVO;

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
	 * AWK Cargo Shuttle Tariff를 조회한다.<br>
	 * 
	 * @param TrsAwkCgoTrfMngVO trsAwkCgoTrfMngVO
	 * @return List<TrsAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TrsAwkCgoTrfMngVO> searchAwkCgoShuttleTrf(TrsAwkCgoTrfMngVO trsAwkCgoTrfMngVO) throws EventException;
	/**
	 * AWK Cargo Shuttle Tariff를 TrsAwkCgoTrfHdr에 insert 한다.<br>
	 * 
	 * @param List<TrsAwkCgoTrfHdrVO> insUpdHdrList
	 * @exception EventException
	 */
	public void modifyAwkCgoShuttleTrfHdr(List<TrsAwkCgoTrfHdrVO> insUpdHdrList) throws EventException;
	/**
	 * AWK Cargo Shuttle Tariff를 TrsAwkCgoTrfTpsz에 insert, update한다.<br>
	 * 
	 * @param List<TrsAwkCgoTrfTpSzVO> insUpdTpszList 
	 * @exception EventException
	 */
	public void modifyAwkCgoShuttleTrfTpSz(List<TrsAwkCgoTrfTpSzVO> insUpdTpszList) throws EventException;
	/**
	 * AWK Cargo Shuttle Tariff를 TrsAwkCgoTrfTpsz에 delete한다<br>
	 * 
	 * @param List<TrsAwkCgoTrfTpSzVO> deleteTpszList
	 * @exception EventException
	 */
	public void removeAwkCgoShuttleTrfTpSz(List<TrsAwkCgoTrfTpSzVO> deleteTpszList) throws EventException;
	/**
	 * AWK Cargo Shuttle Tariff를 TrsAwkCgoTrfHdr에 delete한다<br>
	 * 
	 * @param List<TrsAwkCgoTrfHdrVO> deleteHdrList
	 * @exception EventException
	 */
	public void removeAwkCgoShuttleTrfHdr(List<TrsAwkCgoTrfHdrVO> deleteHdrList) throws EventException;
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
	 * @return List<TrsAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TrsAwkCgoTrfMngVO> searchTmlCd(String ydCd) throws EventException;
	/**
	 * Currency Code를 조회한다.
	 * 
	 * @return List<TrsAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TrsAwkCgoTrfMngVO> searchCurrCd() throws EventException;
	/**
	 * 최근 Batch가 실행된 Year Month 를 가져온다.
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String setYearMonth() throws EventException;
	/**
	 * AWK Cargo Shuttle Tariff History를 조회한다.<br>
	 * 
	 * @param TrsAwkCgoTrfMngVO trsAwkCgoTrfMngVO
	 * @return List<TrsAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TrsAwkCgoTrfMngVO> searchAwkCgoShuttleTrfHis(TrsAwkCgoTrfMngVO trsAwkCgoTrfMngVO) throws EventException;
	/**
	 * 해당 월 환율적용하여 local amt를 usd amt로 변환한다.<br>
	 * 
	 * @param TrsAwkCgoTrfMngVO trsAwkCgoTrfMngVO
	 * @return String
	 * @exception EventException
	 */
	public String checkUsdConvert(TrsAwkCgoTrfMngVO trsAwkCgoTrfMngVO) throws EventException;
	/**
	 * Sheet에 입력한 Port+Tml Cd와 로그인 오피스를 비교하여 입력 권한을 체크한다.
	 * 
	 * @param String fmYdCd
	 * @param String toYdCd
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String checkYdCdInputAuth(String fmYdCd, String toYdCd, String ofcCd) throws EventException;
	/**
	 * Load / Unload Shuttle Extra Cost를 조회한다.<br>
	 * 
	 * @param AwkCgoExtraCostByRouteVO awkCgoExtraCostByRouteVO
	 * @return List<TrsAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TrsAwkCgoTrfMngVO> searchLoadUnloadShuttleExtCost(AwkCgoExtraCostByRouteVO awkCgoExtraCostByRouteVO) throws EventException;
}