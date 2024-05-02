/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoQuotationManageBCImpl.java
*@FileTitle : SpecialCargoQuotationManageBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.18
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.18 이혜민
* 1.0 Creation
* 2015.01.20 김영신 [CHM-201432134] CGRFTX_B/BULK cost code mapping 수정요청
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0001Event;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.SpecialCargoQuotationManageSC;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.event.EsdTes9051Event;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration.SpecialCargoQuotationManageDBDAO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.TesAwkCgoTrfMngVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.TesBbCgoCostVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.TesBbCgoDtlVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.BlCustomerInfoVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.BbCgoApplVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.AwkCgoExtraCostByRouteVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.TesAwkCgoAdonHdrVO;
import com.hanjin.syscommon.common.table.TesAwkCgoAdonTpSzVO;
import com.hanjin.syscommon.common.table.TesAwkCgoTrfDtlVO;
import com.hanjin.syscommon.common.table.TesAwkCgoTrfHdrVO;
import com.hanjin.syscommon.common.table.TesAwkCgoTrfTpSzVO;
import com.hanjin.syscommon.common.table.TesTmlSoBbDtlVO;
import com.hanjin.syscommon.common.table.TesTmlSoDtlVO;

/**
 * ALPS-SpecialCargoQuotationManage Business Logic Command Interface<br>
 * - ALPS-SpecialCargoQuotationManage 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 이혜민
 * @see SpecialCargoQuotationManageSC 참조
 * @since J2EE 1.6
 */
public class SpecialCargoQuotationManageBCImpl extends BasicCommandSupport implements SpecialCargoQuotationManageBC {

	// Database Access Object
	private transient SpecialCargoQuotationManageDBDAO dbDao = null;

	/**
	 * SpecialCargoQuotationManageBCImpl 객체 생성<br>
	 * SpecialCargoQuotationManageDBDAO 생성한다.<br>
	 */
	public SpecialCargoQuotationManageBCImpl() {
		dbDao = new SpecialCargoQuotationManageDBDAO();
	}
	
	/**
	 * AWK Cargo Basic Tariff를 조회한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TesAwkCgoTrfMngVO> searchAwkCgoBasicTrf(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws EventException {
		try {
			return dbDao.searchAwkCgoBasicTrf(tesAwkCgoTrfMngVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo T/S Tariff를 조회한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TesAwkCgoTrfMngVO> searchAwkCgoTsTrf(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws EventException {
		try {
			return dbDao.searchAwkCgoTsTrf(tesAwkCgoTrfMngVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo Add On	Tariff를 조회한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TesAwkCgoTrfMngVO> searchAwkCgoAddOnTrf(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws EventException {
		try {
			return dbDao.searchAwkCgoAddOnTrf(tesAwkCgoTrfMngVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Port Code 가 존재하는지 여부를 조회합니다.
	 * 
	 * @param String ydCd
	 * @return String
	 * @exception EventException
	 */
	public String checkPort(String ydCd) throws EventException {
		try {
			return dbDao.checkPort(ydCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 해당 Port에 해당하는 Terminal을 조회한다.
	 * 
	 * @param String ydCd
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TesAwkCgoTrfMngVO> searchTmlCd(String ydCd) throws EventException {
		try {
			return dbDao.searchTmlCd(ydCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Currency Code를 조회한다.
	 * 
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TesAwkCgoTrfMngVO> searchCurrCd() throws EventException {
		try {
			return dbDao.searchCurrCd();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Main Yard 존재유무를 확인한다.
	 * 
	 * @param String ydCd
	 * @return String
	 * @exception EventException
	 */
	public String checkMnYdFlg(String ydCd) throws EventException {
		try {
			return dbDao.checkMnYdFlg(ydCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 최근 Batch가 실행된 Year Month 를 가져온다.
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String setYearMonth() throws EventException {
		try {
			return dbDao.setYearMonth();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Sheet에 입력한 Port+Tml Cd와 로그인 오피스를 비교하여 입력 권한을 체크한다.
	 * 
	 * @param String ydCd
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String checkYdCdInputAuth(String ydCd , String ofcCd) throws EventException {
		try {
			return dbDao.checkYdCdInputAuth(ydCd , ofcCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Sheet에 입력한 Port+Tml Cd와 로그인 오피스를 비교하여 입력 권한을 체크한다.
	 * 
	 * @param String fmYdCd
	 * @param String toYdCd
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String checkYdCdInputAuthAddon(String fmYdCd, String toYdCd, String ofcCd) throws EventException {
		try {
			return dbDao.checkYdCdInputAuthAddon(fmYdCd , toYdCd ,ofcCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo Basic Tariff를 AwkCgoBasicTrfHdr에 delete한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfHdrVO> deleteHdrList
	 * @exception EventException
	 */
	public void removeAwkCgoBasicTrfHdr(List<TesAwkCgoTrfHdrVO> deleteHdrList) throws EventException{
		try {
				dbDao.removeAwkCgoBasicTrfHdr(deleteHdrList);
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo Basic Tariff를 AwkCgoBasicTrfDtl에 delete 한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfDtlVO> deleteDtlList
	 * @exception EventException
	 */
	public void removeAwkCgoBasicTrfDtl(List<TesAwkCgoTrfDtlVO> deleteDtlList) throws EventException{
		try {
				dbDao.removeAwkCgoBasicTrfDtl(deleteDtlList);
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo Basic Tariff를 AwkCgoBasicTrfTpSz에 delete 한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfTpSzVO> deleteTpszList
	 * @exception EventException
	 */
	public void removeAwkCgoBasicTrfTpSz(List<TesAwkCgoTrfTpSzVO> deleteTpszList) throws EventException{
		try {
				dbDao.removeAwkCgoBasicTrfTpSz(deleteTpszList);
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo Basic Tariff를 AwkCgoBasicTrfHdr에 insert, update한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfHdrVO> InsUpdHdrList
	 * @exception EventException
	 */
	public void modifyAwkCgoBasicTrfHdr(List<TesAwkCgoTrfHdrVO> InsUpdHdrList) throws EventException{
		try {
				dbDao.modifyAwkCgoBasicTrfHdr(InsUpdHdrList);
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo Basic Tariff를 AwkCgoBasicTrfDtl에 insert 한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfDtlVO> InsUpdDtlList
	 * @exception EventException
	 */
	public void modifyAwkCgoBasicTrfDtl(List<TesAwkCgoTrfDtlVO> InsUpdDtlList) throws EventException{
		try {
				dbDao.modifyAwkCgoBasicTrfDtl(InsUpdDtlList);
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo Basic Tariff를 AwkCgoBasicTrfTpSz에 insert, update한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfTpSzVO> InsUpdTpszList
	 * @exception EventException
	 */
	public void modifyAwkCgoBasicTrfTpSz(List<TesAwkCgoTrfTpSzVO> InsUpdTpszList) throws EventException{
		try {
				dbDao.modifyAwkCgoBasicTrfTpSz(InsUpdTpszList);
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo T/S Tariff를 AwkCgoTsTrfHdr에 delete한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfHdrVO> deleteHdrList
	 * @exception EventException
	 */
	public void removeAwkCgoTsTrfHdr(List<TesAwkCgoTrfHdrVO> deleteHdrList) throws EventException{
		try {
				dbDao.removeAwkCgoTsTrfHdr(deleteHdrList);
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo T/S Tariff를 AwkCgoTsTrfDtl에 delete 한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfDtlVO> deleteDtlList
	 * @exception EventException
	 */
	public void removeAwkCgoTsTrfDtl(List<TesAwkCgoTrfDtlVO> deleteDtlList) throws EventException{
		try {
				dbDao.removeAwkCgoTsTrfDtl(deleteDtlList);
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo T/S Tariff를 AwkCgoTsTrfTpSz에 delete 한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfTpSzVO> deleteTpszList
	 * @exception EventException
	 */
	public void removeAwkCgoTsTrfTpSz(List<TesAwkCgoTrfTpSzVO> deleteTpszList) throws EventException{
		try {
				dbDao.removeAwkCgoTsTrfTpSz(deleteTpszList);
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo T/S Tariff를 AwkCgoTsTrfHdr에 insert, update한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfHdrVO> InsUpdHdrList
	 * @exception EventException
	 */
	public void modifyAwkCgoTsTrfHdr(List<TesAwkCgoTrfHdrVO> InsUpdHdrList) throws EventException{
		try {
				dbDao.modifyAwkCgoTsTrfHdr(InsUpdHdrList);
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo T/S Tariff를 AwkCgoTsTrfDtl에 insert 한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfDtlVO> InsUpdDtlList
	 * @exception EventException
	 */
	public void modifyAwkCgoTsTrfDtl(List<TesAwkCgoTrfDtlVO> InsUpdDtlList) throws EventException{
		try {
				dbDao.modifyAwkCgoTsTrfDtl(InsUpdDtlList);
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo T/S Tariff를 AwkCgoTsTrfTpSz에 insert, update한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfTpSzVO> InsUpdTpszList
	 * @exception EventException
	 */
	public void modifyAwkCgoTsTrfTpSz(List<TesAwkCgoTrfTpSzVO> InsUpdTpszList) throws EventException{
		try {
			dbDao.modifyAwkCgoTsTrfTpSz(InsUpdTpszList);
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo Basic Tariff History를 조회한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TesAwkCgoTrfMngVO> searchAwkCgoBasicTrfHis(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws EventException {
		try {
			return dbDao.searchAwkCgoBasicTrfHis(tesAwkCgoTrfMngVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo T/S Tariff History를 조회한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TesAwkCgoTrfMngVO> searchAwkCgoTsTrfHis(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws EventException {
		try {
			return dbDao.searchAwkCgoTsTrfHis(tesAwkCgoTrfMngVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo Add-On Tariff History를 조회한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TesAwkCgoTrfMngVO> searchAwkCgoAddOnTrfHis(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws EventException {
		try {
			return dbDao.searchAwkCgoAddOnTrfHis(tesAwkCgoTrfMngVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo Add-On Tariff를 AwkCgoAdonTrfHdr에 insert 한다.<br>
	 * 
	 * @param List<TesAwkCgoAdonHdrVO> insUpdHdrList
	 * @exception EventException
	 */
	public void modifyAwkCgoAddOnTrfHdr(List<TesAwkCgoAdonHdrVO> insUpdHdrList) throws EventException{
		try {
			dbDao.modifyAwkCgoAddOnTrfHdr(insUpdHdrList);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo Add-On Tariff를 AwkCgoAdonTrfTpSz에 insert, update한다.<br>
	 * 
	 * @param List<TesAwkCgoAdonTpSzVO> insUpdTpszList 
	 * @exception EventException
	 */
	public void modifyAwkCgoAddOnTrfTpSz(List<TesAwkCgoAdonTpSzVO> insUpdTpszList ) throws EventException{
		try {
			dbDao.modifyAwkCgoAddOnTrfTpSz(insUpdTpszList);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo Add-On Tariff를 AwkCgoAdonTrfHdr에 delete한다<br>
	 * 
	 * @param List<TesAwkCgoAdonHdrVO> deleteHdrList
	 * @exception EventException
	 */
	public void removeAwkCgoAddOnTrfHdr(List<TesAwkCgoAdonHdrVO> deleteHdrList) throws EventException{
		try {
			dbDao.removeAwkCgoAddOnTrfHdr(deleteHdrList);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo Add-On Tariff를 AwkCgoAdonTrfTpSz에 delete한다<br>
	 * 
	 * @param List<TesAwkCgoAdonTpSzVO> deleteTpszList
	 * @exception EventException
	 */
	public void removeAwkCgoAddOnTrfTpSz(List<TesAwkCgoAdonTpSzVO> deleteTpszList) throws EventException{
		try {
			dbDao.removeAwkCgoAddOnTrfTpSz(deleteTpszList);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Load / Unload Extra Cost를 조회한다.<br>
	 * 
	 * @param AwkCgoExtraCostByRouteVO awkCgoExtraCostByRouteVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TesAwkCgoTrfMngVO> searchLoadUnloadExtCost(AwkCgoExtraCostByRouteVO awkCgoExtraCostByRouteVO) throws EventException {
		try {
			return dbDao.searchLoadUnloadExtCost(awkCgoExtraCostByRouteVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Load / Unload T/S Extra Cost를 조회한다.<br>
	 * 
	 * @param AwkCgoExtraCostByRouteVO awkCgoExtraCostByRouteVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception EventException
	 */
	public List<TesAwkCgoTrfMngVO> searchLoadUnloadTsExtCost(AwkCgoExtraCostByRouteVO awkCgoExtraCostByRouteVO) throws EventException {
		try {
			return dbDao.searchLoadUnloadTsExtCost(awkCgoExtraCostByRouteVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * BB Booking Information을 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @return BbCgoApplVO 
	 * @exception EventException
	 */
	public BbCgoApplVO searchBbCargoInfo(String bkgNo) throws EventException {

		BbCgoApplVO bbCgoApplVO = new BbCgoApplVO();		
		
        try {
            bbCgoApplVO.setBkgBbCgoVO(dbDao.searchBbCgoList(bkgNo));                
            bbCgoApplVO.setBbCntrListVO(dbDao.searchBbCgoCntrList(bkgNo));
            bbCgoApplVO.setCntrTypzQty(dbDao.searchCntrTpszQty(bkgNo));  

        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler(ex).getMessage(), ex);    
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler(ex).getMessage(), ex);      
        }
        return bbCgoApplVO;
    }
	
	/**
	 * BB Booking Customer Infomation을 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @return BlCustomerInfoVO 
	 * @exception EventException
	 */
	public BlCustomerInfoVO searchBkgCustomer(String bkgNo) throws EventException {
        try {
            return dbDao.searchBkgCustomer(bkgNo);
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler(ex).getMessage(), ex);    
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler(ex).getMessage(), ex);      
        }
    }
	
	/**
	 * BB Booking Cost Information을 조회한다.<br>
	 * 
	 * @param TesBbCgoCostVO tesBbCgoCostVO
	 * @return List<tesBbCgoCostVO>
	 * @exception EventException
	 */
	public List<TesBbCgoCostVO> searchBbCargoCostInfo(TesBbCgoCostVO tesBbCgoCostVO) throws EventException {
		try {
			return dbDao.searchBbCargoCostInfo(tesBbCgoCostVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * BB Booking No을 조회한다.<br>
	 * 
	 * @param TesBbCgoCostVO tesBbCgoCostVO
	 * @return List<tesBbCgoCostVO>
	 * @exception EventException
	 */
	public List<TesBbCgoCostVO> searchBbBkgNo(TesBbCgoCostVO tesBbCgoCostVO) throws EventException {
		try {
			return dbDao.searchBbBkgNo(tesBbCgoCostVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * BB Cargo Amount 를 insert, update한다.<br>
	 * 
	 * @param TesBbCgoCostVO[] tesBbCgoCostVOs
	 * @param TesBbCgoDtlVO[] tesBbCgoDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBbCargoCostAmount(TesBbCgoCostVO[] tesBbCgoCostVOs, TesBbCgoDtlVO[] tesBbCgoDtlVOs,SignOnUserAccount account) throws EventException {
		
		String [] isExist = null;
		int maxSeq = 0;
		String lg_usr_id = account.getUsr_id();
		String lg_ofc_cd = account.getOfc_cd();
		
		try {
			
			dbDao.multiTerminalInvoiceVVD(tesBbCgoDtlVOs[0].getTmlSoSeq(), tesBbCgoDtlVOs[0].getTmlSoOfcCtyCd(), tesBbCgoDtlVOs[0].getIoBndCd(), tesBbCgoDtlVOs[0].getVvd(), tesBbCgoDtlVOs[0].getAtbDt(), account.getUsr_id());
			for (int i=0; tesBbCgoDtlVOs!= null && i<tesBbCgoDtlVOs.length; i++){
				TesTmlSoDtlVO tesTmlSoDtlVO = new TesTmlSoDtlVO();
				TesTmlSoBbDtlVO tesTmlSoBbDtlVO = new TesTmlSoBbDtlVO();
				float sumInvAmt = 0;	//SVLDBB로 통합하므로 누적금액을 구한다.(소수점 2자리 까지 허용)
				
				if(tesBbCgoDtlVOs[i].getDtlInvAmt() != null && !tesBbCgoDtlVOs[i].getDtlInvAmt().equals("") || tesBbCgoDtlVOs[i].getDtlBbCgoRmk().equals("Y")){
					//SVLDBB로 mapping
					tesBbCgoDtlVOs[i].setDtlLgsCostCd("SVLDBB");
					
					isExist = dbDao.checkTesTmlSoDtlCostExist(tesBbCgoDtlVOs[i].getTmlSoOfcCtyCd(), tesBbCgoDtlVOs[i].getTmlSoSeq(), tesBbCgoDtlVOs[i].getBkgNo(), tesBbCgoDtlVOs[i].getDtlLgsCostCd());
					//insert
					if(isExist[0].equals("N")){
						
						for (int k=0; tesBbCgoCostVOs != null && k<tesBbCgoCostVOs.length; k++){
							if(tesBbCgoCostVOs[k].getInvAmt()!= null && !tesBbCgoCostVOs[k].getInvAmt().equals("")  && tesBbCgoCostVOs[k].getInvAmt()!= "0"){
								sumInvAmt = sumInvAmt + Float.parseFloat(tesBbCgoCostVOs[k].getInvAmt());
							}
						}
						
						maxSeq = Integer.parseInt(isExist[1]);
						
						tesTmlSoDtlVO.setBkgNo(tesBbCgoDtlVOs[i].getBkgNo());
						tesTmlSoDtlVO.setTmlSoOfcCtyCd(tesBbCgoDtlVOs[i].getTmlSoOfcCtyCd());
						tesTmlSoDtlVO.setTmlSoSeq(tesBbCgoDtlVOs[i].getTmlSoSeq());
						tesTmlSoDtlVO.setTmlSoDtlSeq(maxSeq+"");
						tesTmlSoDtlVO.setLgsCostCd(tesBbCgoDtlVOs[i].getDtlLgsCostCd());
						tesTmlSoDtlVO.setInvAmt(sumInvAmt+"");
						tesTmlSoDtlVO.setVvd(tesBbCgoDtlVOs[i].getVvd());
						tesTmlSoDtlVO.setIoBndCd(tesBbCgoDtlVOs[i].getIoBndCd());
						tesTmlSoDtlVO.setAtbDt(tesBbCgoDtlVOs[i].getAtbDt());
						tesTmlSoDtlVO.setCreUsrId(lg_usr_id);
						tesTmlSoDtlVO.setUpdUsrId(lg_usr_id);
						tesTmlSoDtlVO.setLgOfcCd(lg_ofc_cd);
						
						dbDao.addTesTmlSoDtl(tesTmlSoDtlVO);
						
						for (int j=0; tesBbCgoCostVOs != null && j<tesBbCgoCostVOs.length; j++){
							if(tesBbCgoCostVOs[j].getInvAmt()!= null && !tesBbCgoCostVOs[j].getInvAmt().equals("") && tesBbCgoCostVOs[j].getInvAmt()!= "0"){
								//if(tesBbCgoDtlVOs[i].getDtlLgsCostCd().equals(tesBbCgoCostVOs[j].getLgsCostCd())){
									tesTmlSoBbDtlVO.setBkgNo(tesBbCgoCostVOs[j].getBkgNo());
									tesTmlSoBbDtlVO.setTmlSoOfcCtyCd(tesBbCgoCostVOs[j].getTmlSoOfcCtyCd());
									tesTmlSoBbDtlVO.setTmlSoSeq(tesBbCgoCostVOs[j].getTmlSoSeq());
									tesTmlSoBbDtlVO.setTmlSoDtlSeq(maxSeq+"");
									tesTmlSoBbDtlVO.setBbCgoTpSeq(tesBbCgoCostVOs[j].getBbCgoTpSeq());
									tesTmlSoBbDtlVO.setLgsCostCd(tesBbCgoCostVOs[j].getLgsCostCd());
									tesTmlSoBbDtlVO.setInvAmt(tesBbCgoCostVOs[j].getInvAmt());
									tesTmlSoBbDtlVO.setBbCgoRmk(tesBbCgoCostVOs[j].getBbCgoRmk());
									tesTmlSoBbDtlVO.setCreUsrId(lg_usr_id);
									tesTmlSoBbDtlVO.setUpdUsrId(lg_usr_id);
									
									dbDao.manageTesTmlSoBbDtl(tesTmlSoBbDtlVO);
								//}
							}
						}
					}
				}
			}
			
			for (int i=0; tesBbCgoDtlVOs != null && i<tesBbCgoDtlVOs.length; i++){
				TesTmlSoDtlVO tesTmlSoDtlVO = new TesTmlSoDtlVO();
				TesTmlSoBbDtlVO tesTmlSoBbDtlVO = new TesTmlSoBbDtlVO();
				float sumInvAmt = 0;	//SVLDBB로 통합하므로 누적금액을 구한다.(소수점 2자리 까지 허용)
				
				if(tesBbCgoDtlVOs[i].getDtlInvAmt() != null && !tesBbCgoDtlVOs[i].getDtlInvAmt().equals("") || tesBbCgoDtlVOs[i].getDtlBbCgoRmk().equals("Y")){
					
					//SVLDBB로 mapping
					tesBbCgoDtlVOs[i].setDtlLgsCostCd("SVLDBB");
					
					isExist = dbDao.checkTesTmlSoDtlCostExist(tesBbCgoDtlVOs[i].getTmlSoOfcCtyCd(), tesBbCgoDtlVOs[i].getTmlSoSeq(), tesBbCgoDtlVOs[i].getBkgNo(), tesBbCgoDtlVOs[i].getDtlLgsCostCd());
					//update
					if(isExist[0].equals("Y")){
						
						for (int k=0; tesBbCgoCostVOs != null && k<tesBbCgoCostVOs.length; k++){
							if(tesBbCgoCostVOs[k].getInvAmt()!= null && !tesBbCgoCostVOs[k].getInvAmt().equals("")  && tesBbCgoCostVOs[k].getInvAmt()!= "0"){
								sumInvAmt = sumInvAmt + Float.parseFloat(tesBbCgoCostVOs[k].getInvAmt());
							}
						}
						
						tesTmlSoDtlVO.setTmlSoOfcCtyCd(tesBbCgoDtlVOs[i].getTmlSoOfcCtyCd());
						tesTmlSoDtlVO.setTmlSoSeq(tesBbCgoDtlVOs[i].getTmlSoSeq());
						tesTmlSoDtlVO.setTmlSoDtlSeq(isExist[1]);
						tesTmlSoDtlVO.setLgsCostCd(tesBbCgoDtlVOs[i].getDtlLgsCostCd());
						tesTmlSoDtlVO.setInvAmt(sumInvAmt+"");
						tesTmlSoDtlVO.setCreUsrId(lg_usr_id);
						tesTmlSoDtlVO.setUpdUsrId(lg_usr_id);
						tesTmlSoDtlVO.setLgOfcCd(lg_ofc_cd);
						
						dbDao.modifyTesTmlSoDtl(tesTmlSoDtlVO);
						
						for (int j=0; tesBbCgoCostVOs != null && j<tesBbCgoCostVOs.length; j++){
							if(tesBbCgoCostVOs[j].getInvAmt() != null && !tesBbCgoCostVOs[j].getInvAmt().equals("") && tesBbCgoCostVOs[j].getInvAmt()!= "0"){
								//if(tesBbCgoDtlVOs[i].getDtlLgsCostCd().equals(tesBbCgoCostVOs[j].getLgsCostCd())){
									tesTmlSoBbDtlVO.setBkgNo(tesBbCgoCostVOs[j].getBkgNo());
									tesTmlSoBbDtlVO.setTmlSoOfcCtyCd(tesBbCgoCostVOs[j].getTmlSoOfcCtyCd());
									tesTmlSoBbDtlVO.setTmlSoSeq(tesBbCgoCostVOs[j].getTmlSoSeq());
									tesTmlSoBbDtlVO.setTmlSoDtlSeq(isExist[1]);
									tesTmlSoBbDtlVO.setBbCgoTpSeq(tesBbCgoCostVOs[j].getBbCgoTpSeq());
									tesTmlSoBbDtlVO.setLgsCostCd(tesBbCgoCostVOs[j].getLgsCostCd());
									tesTmlSoBbDtlVO.setInvAmt(tesBbCgoCostVOs[j].getInvAmt());
									tesTmlSoBbDtlVO.setBbCgoRmk(tesBbCgoCostVOs[j].getBbCgoRmk());
									tesTmlSoBbDtlVO.setCreUsrId(lg_usr_id);
									tesTmlSoBbDtlVO.setUpdUsrId(lg_usr_id);
									
									dbDao.manageTesTmlSoBbDtl(tesTmlSoBbDtlVO);
								//}
							}
						}
					}
				}
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo Add On Tariff를 Verify한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return String
	 * @exception EventException
	 */
	public String verifyAwkCgoAddOnTrf(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws EventException {
		try {
			return dbDao.verifyAwkCgoAddOnTrf(tesAwkCgoTrfMngVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo Basic Tariff를 Verify한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return String
	 * @exception EventException
	 */
	public String verifyAwkCgoBasicTrf(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws EventException {
		try {
			return dbDao.verifyAwkCgoBasicTrf(tesAwkCgoTrfMngVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo T/S Tariff를 Verify한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return String
	 * @exception EventException
	 */
	public String verifyAwkCgoTsTrf(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws EventException {
		try {
			return dbDao.verifyAwkCgoTsTrf(tesAwkCgoTrfMngVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AWK Cargo Add On Tariff의 local curr를 USD로 바꾼다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return TesAwkCgoTrfMngVO
	 * @exception EventException
	 */
			
	public TesAwkCgoTrfMngVO searchUSDExchange(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws EventException {
			
		try {
			return dbDao.searchUSDExchange(tesAwkCgoTrfMngVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
}