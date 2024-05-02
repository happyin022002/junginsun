/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGExternalFinderBCImpl.java
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

import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.integration.SCGExternalFinderDBDAO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.vo.BKGOutputVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.vo.CheckLaneVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.vo.SearchPortVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.vo.SearchVVDVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgBookingVO;
import com.hanjin.syscommon.common.table.MdmCarrierVO;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.ScgImdgCompGrpVO;
import com.hanjin.syscommon.common.table.ScgRgnShpOprCdVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;

/**
 * ALPS-SCGCommon Business Logic Basic Command implementation<br>
 * - ALPS-SCGCommon에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Dohyoung Lee
 * @see SCG_COM_EventResponse,SCGExternalFinderBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class SCGExternalFinderBCImpl extends BasicCommandSupport implements SCGExternalFinderBC {

	// Database Access Object
	private transient SCGExternalFinderDBDAO dbDao = null;

	/**
	 * SCGExternalFinderBCImpl 객체 생성<br>
	 * SCGExternalFinderDBDAO를 생성한다.<br>
	 */
	public SCGExternalFinderBCImpl() {
		dbDao = new SCGExternalFinderDBDAO();
	}

	/**
     * Carreier Code를 체크한다. <br>
	 * 
	 * @param crrCd
	 * @return List<MdmCarrierVO>
	 * @exception EventException
	 */
	public List<MdmCarrierVO> checkCarrier(String crrCd) throws EventException {
		try {
			return dbDao.checkCarrier(crrCd);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Carrier Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Carrier Code"}).getMessage(), ex);
		}		
	}
	/**
     * PortCode 체크한다. <br>
	 * 
	 * @param  String portCode
	 * @return String
	 * @exception EventException
	 */	
	public String checkPort(String portCode) throws EventException {
		try {
			return dbDao.checkPort(portCode);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Code"}).getMessage(), ex);
		}		
	}
 

	/**
     * Lane Code 체크한다. <br>
	 * 
	 * @param vslSlanCd
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> checkLane(String vslSlanCd) throws EventException {
		try {
			return dbDao.checkLane(vslSlanCd);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Lane Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Lane Code"}).getMessage(), ex);
		}		
	}

	/**
	 * Booking Number 를 체크한다. <br>
	 * 
	 * @param bkgBookingVO
	 * @return List<BKGOutputVO>
	 * @exception EventException
	 */
	public List<BKGOutputVO> checkBKG(BkgBookingVO bkgBookingVO) throws EventException {
		try {
			return dbDao.checkBKG(bkgBookingVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Booking"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Booking"}).getMessage(), ex);
		}		
	}

	/**
	 * B/L Number 를 체크한다. <br>
	 * 
	 * @param bkgBookingVO
	 * @return List<BKGOutputVO>
	 * @exception EventException
	 */
	public List<BKGOutputVO> checkBL(BkgBookingVO bkgBookingVO) throws EventException {
		try {
			return dbDao.checkBL(bkgBookingVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"BL No"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"BL No"}).getMessage(), ex);
		}		
	}
	
	/**
	 * VVD 코드를 조회한다.
	 * 
	 * @param vskVslSkdVO
	 * @return List<SearchVVDVO>
	 * @exception EventException
	 */
	public List<SearchVVDVO> searchVVD(VskVslSkdVO vskVslSkdVO) throws EventException {
		try {
			return dbDao.searchVVD(vskVslSkdVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"VVD Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"VVD Code"}).getMessage(), ex);
		}		
	}
	
	/**
	 * Container Type Size 를 조회한다. <br>
	 * 
	 * @param mdmCntrTpSzVO
	 * @return List<MdmCntrTpSzVO>
	 * @exception EventException
	 */
	public List<MdmCntrTpSzVO> searchCNTRTPSZ(MdmCntrTpSzVO mdmCntrTpSzVO) throws EventException {
		try {
			return dbDao.searchCNTRTPSZ(mdmCntrTpSzVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CNTR TPSZ"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CNTR TPSZ"}).getMessage(), ex);
		}		
	}

	/**
	 * Comp Group 을 조회한다. <br>
	 * 
	 * @param imdgCompGrpCd
	 * @return List<ScgImdgCompGrpVO>
	 * @throws DAOException
	 */
	public List<ScgImdgCompGrpVO> searchCompGrp(String imdgCompGrpCd) throws EventException{
		try {
			return dbDao.searchCompGrp(imdgCompGrpCd);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Compatibility Group"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Compatibility Group"}).getMessage(), ex);
		}		
	}
	/**
     * 프레임워크의 공통코드(코드,명칭)조회<br>
	 *
	 * @param String intgCdId
	 * @param int sortkey
	 * @param String exceptKeys
	 * @return String  ex) val1|val2|val3|$$|text1|text2|text3
	 * @exception EventException
	 */

	public String getCodeSelect(String intgCdId, int sortkey, String exceptKeys) throws EventException {
		CodeUtil cdUtil = CodeUtil.getInstance(); 	
		String[]   aExceptionKey =  exceptKeys.split("\\|" ); 
		StringBuilder itemComboText1 = new StringBuilder();
		StringBuilder itemComboValue1 = new StringBuilder();

		try{
			List<CodeInfo> list =  (List<CodeInfo>) cdUtil.getCodeSelect( intgCdId , sortkey);
			
	        CodeInfo[] codelist1 = list.toArray(new CodeInfo[list.size()]);
	        
	        for (int i = 0; i < codelist1.length; i++) {
	            boolean skip = false;
	            for(int j=0;j<aExceptionKey.length;j++){
	                if( aExceptionKey[j].equals( codelist1[i].getCode()) ){
	                    skip = true;
	                }
	            }
	            if( skip ){continue;}
	            if (i != 0 ) {
	                itemComboText1.append("|");
	                itemComboValue1.append("|");
	            }            
	            itemComboValue1.append(codelist1[i].getCode());
	            itemComboText1.append(codelist1[i].getName());
	        }
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Compatibility Group"}).getMessage(), ex);
		}
	        
		return itemComboValue1  +"|##|" + itemComboText1;			
	}
  
	/**
	 * Class Comp 를 조회한다. <br>
	 * 
	 * @param  ScgImdgCompGrpVO scgImdgCompGrpVO
	 * @return List<ScgImdgCompGrpVO>
	 * @exception EventException
	 */
	public List<ScgImdgCompGrpVO> searchClassComp(ScgImdgCompGrpVO scgImdgCompGrpVO) throws EventException {
		try {
			return dbDao.searchClassComp(scgImdgCompGrpVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Compatibility Group"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Compatibility Group"}).getMessage(), ex);
		}		
	}
	
	/**
	 * VVD내의 Port 목록을 가져온다.<br>
	 * 
	 * @param searchPortVO
	 * @return List<SearchPortVO>
	 * @exception EventException
	 */
	public List<SearchPortVO> searchPort(SearchPortVO searchPortVO) throws EventException {
		try {
			return dbDao.searchPort(searchPortVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Prot Code"}).getMessage(), ex);
		}		
	}

    /**
     * 
     * POL과 POD 사이의 TARGET LANE CODE를 조회한다.<br>
     *
     * @param   pol
     * @param   pod
     * @throws  EventException
     * @return  List<CheckLaneVO> 
     * @author  jang kang cheol
     */
    public List<CheckLaneVO> searchTargetLane(String pol, String pod)
            throws EventException {
        try {
            return dbDao.searchTargetLane(pol, pod);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Target Lane"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Target Lane"}).getMessage(), ex);
		}		
    }

	/**
	 * 로그인사용자의 소속오피스에 해당되는 RSO 찾기
	 * 2011.04.08 추가 by 2004612<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchOfcRso(SignOnUserAccount account) throws EventException {
		String rso = "";
		try {
			List<ScgRgnShpOprCdVO> list = dbDao.searchOfcRso(account);
			
			if( list.size() > 0 ) {
				rso = list.get(0).getRgnShpOprCd();
			}
			return rso;
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}
	}

	/**
	 * 로그인사용자의 USR_ROLE_CD 검색 <br>
	 * 
	 * @param String pgmNo
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String checkUserRole(String pgmNo, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.checkUserRole(pgmNo, account);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}
	}
	
	/**
	 * 입력된 Booking의 Split & Combine History 정보가 가장 최신 정보를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchBkgHistory(String bkgNo) throws EventException {
		try {
			return dbDao.searchBkgHistory(bkgNo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Split and Combine History"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Split and Combine History"}).getMessage(), ex);
		}
	}

}