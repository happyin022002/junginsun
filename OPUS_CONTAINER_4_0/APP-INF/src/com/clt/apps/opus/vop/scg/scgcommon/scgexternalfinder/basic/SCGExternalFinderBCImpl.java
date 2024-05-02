/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGExternalFinderBCImpl.java
*@FileTitle : Common Utility
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.basic;

import java.util.List;

import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.integration.SCGExternalFinderDBDAO;
import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.vo.BKGOutputVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.vo.CheckLaneVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.vo.SearchPortVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.vo.SearchVVDVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.MdmCarrierVO;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
import com.clt.syscommon.common.table.MdmCntrTpVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.ScgImdgCompGrpVO;
import com.clt.syscommon.common.table.VskVslSkdVO;

/**
 * OPUS-SCGCommon Business Logic Basic Command implementation<br>
 * - Handling business transactions of OPUS-SCGCommon<br>
 *
 * @author
 * @see SCG_COM_EventResponse,SCGExternalFinderBC
 * @since J2EE 1.4
 */
public class SCGExternalFinderBCImpl extends BasicCommandSupport implements SCGExternalFinderBC {

	// Database Access Object
	private transient SCGExternalFinderDBDAO dbDao = null;

	/**
	 * SCGExternalFinderBCImpl object creation<br>
	 * SCGExternalFinderDBDAO creation<br>
	 */
	public SCGExternalFinderBCImpl() {
		dbDao = new SCGExternalFinderDBDAO();
	}

	/**
     * Carreier Code check <br>
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
     * PortCode check <br>
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
     * Lane Code check <br>
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
	 * Booking Number check <br>
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
	 * B/L Number check <br>
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
	 * VVD code check
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
	 * Container Type Size retrieve <br>
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
	 * Comp Group retrieve <br>
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
     * Framework's common code(code,name) retrieve<br>
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
	 * Class Comp retrieve <br>
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
	 * Inside VVD Port list retrieve<br>
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
     * TARGET LANE CODE between POL POD retrieve<br>
     *
     * @param   pol
     * @param   pod
     * @throws  EventException
     * @return  List<CheckLaneVO> 
     * @author
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
	 * Container Type retrieve <br>
	 * 
	 * @param mdmCntrTpVO
	 * @return List<MdmCntrTpVO>
	 * @exception EventException
	 */
	public List<MdmCntrTpVO> searchCNTRTP(MdmCntrTpVO mdmCntrTpVO) throws EventException {
		try {
			return dbDao.searchCNTRTP(mdmCntrTpVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CNTR TP"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CNTR TP"}).getMessage(), ex);
		}		
	}

}