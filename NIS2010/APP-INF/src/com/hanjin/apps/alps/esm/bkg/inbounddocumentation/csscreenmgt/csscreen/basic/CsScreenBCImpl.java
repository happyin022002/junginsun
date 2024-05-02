/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CsScreenBCImpl.java
*@FileTitle : Break Bulk Detail(s) Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.04.28 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration.CargoReleaseOrderDBDAO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration.CargoReleaseOrderEAIDAO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCancelVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OtsRcvInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration.CsScreenDBDAO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.ArrNtcCneeInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.ArrNtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.ArrNtcNtfyInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.BkgBlInfosVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.BlCustInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.BlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.BlInfosVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrBySealNoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrClmInfosVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrMvntDtlsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrMvntMstsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrMvntVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrPkupNtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrSoDtlVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrSoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CstmsClearInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.DgCgoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.PkupNtcCneeInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.PkupNtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.PkupNtcNtfyInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.SoInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.TopBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.TpszQtyVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsBlInfosVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsCntrSoDtlInfosVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsCntrSoInfosVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsCstmsRefInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsFreigtInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsCustSvcInstrsVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgArrNtcDtlVO;
import com.hanjin.syscommon.common.table.BkgAwkCgoVO;
import com.hanjin.syscommon.common.table.BkgBbCgoVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvRsltVO;


/**
 * ALPS-CsScreenMgt Business Logic Basic Command implementation<br>
 * - ALPS-CsScreenMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Park Mi Ok
 * @see CsScreenBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class CsScreenBCImpl extends BasicCommandSupport implements CsScreenBC {

	// Database Access Object
	private transient CsScreenDBDAO dbDao = null;
	private transient CargoReleaseOrderDBDAO dbCargo = null;
    // Database Access Object
    private transient CargoReleaseOrderEAIDAO eaiDbDao = null;

	/**
	 * CsScreenBCImpl 객체 생성<br>
	 * CsScreenDBDAO를 생성한다.<br>
	 */
	public CsScreenBCImpl() {
		dbDao = new CsScreenDBDAO();
		dbCargo = new CargoReleaseOrderDBDAO();
        eaiDbDao = new CargoReleaseOrderEAIDAO();		
	}
	

	/**
	 * DG Cargo Detail(s) Pop-up(UI_BKG-0659) 화면에 대한 조회 이벤트 처리한다.<br>
	 * 
	 * @param String bkgNo Booking No.
	 * @param String cntrNo Container No.
	 * @return List<DgCgoVO>
	 * @exception EventException
	 */
	public List<DgCgoVO> searchDgCargoList(String bkgNo, String cntrNo) throws EventException {
		try {
			return dbDao.searchDgCargoList(bkgNo, cntrNo);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
	
	/**
	 * Break Bulk Detail(s) Pop-up(UI_BKG-0660) 화면에 대한 조회 이벤트 처리한다.<br>
	 * 
	 * @param String bkgNo Booking No.
	 * @return List<BkgBbCgoVO>
	 * @exception EventException
	 */
	public List<BkgBbCgoVO> searchBbCargoList(String bkgNo) throws EventException {
		try {
			return dbDao.searchBbCargoList(bkgNo);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	
	
	/**
	 * Awkward Dimension Detail(s) Pop-up(UI_BKG-0661) 화면에 대한 조회 이벤트 처리한다.<br>
	 * 
	 * @param String bkgNo Booking No.
	 * @param String cntrNo Container No.
	 * @return List<BkgAwkCgoVO>
	 * @exception EventException
	 */
	public List<BkgAwkCgoVO> searchAwkCargoList(String bkgNo, String cntrNo) throws EventException {
		try {
			return dbDao.searchAwkCargoList(bkgNo, cntrNo);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
	
    /**
     * 조회 이벤트 처리<br>
     * UI_BKG_0292 화면의 B/L Info 조회한다.<br>
     * 
     * @param String bkgNo Booking No.
     * @param SignOnUserAccount account
     * @return BlInfoVO
     * @exception EventException
     */
    public BlInfoVO searchBlInfo(String bkgNo, SignOnUserAccount account) throws EventException {

        BlInfoVO blInfoVO = new BlInfoVO();

        String strCustomsRefNo = null;
        String bkgStsCd        = null;
        String retBkgNo        = bkgNo;
        
        try {
            // Booking Status를 체크한다.
            log.debug("===================================================================");
            log.debug("    Booking Status를 체크한다.                                      ");
            log.debug("===================================================================");

            bkgStsCd = validateBkgSts(retBkgNo);
            log.debug("    Booking Status를 체크한다. ===> " + bkgStsCd);
            	
            // 기본 정보를 조회한다.
            log.debug("============================================================");
            log.debug("    기본 Reference 정보  조회      ");
            log.debug("============================================================");

            BlInfosVO blInfosVO = dbDao.searchBlInfo(retBkgNo);
            blInfoVO.setBlInfosVO(blInfosVO);

            if(blInfosVO != null){
            	
                // Customs Ref No를 조회한다.
                log.debug("===================================================================");
                log.debug("    Customs Ref No를 조회한다.                                      ");
                log.debug("===================================================================");

                strCustomsRefNo = dbDao.searchCstmsRefNo(blInfosVO.getBlNo(), account);
                log.debug("    Customs Ref No를 조회한다. ===> " + strCustomsRefNo);
                blInfoVO.setCustomsRefNo(strCustomsRefNo);

                // TP/SZ QTY 리스트 를 조회한다.
                log.debug("===================================================================");
                log.debug("    TP/SZ QTY 리스트 를 조회한다.                                    ");
                log.debug("===================================================================");

                List<TpszQtyVO> tpszQtyVOs = dbDao.searchQtyForCntrByTpsz(retBkgNo);
                blInfoVO.setTpszQtyVOs(tpszQtyVOs);


              // BKG_CONTAINER 테이블에서 데이터 를 조회한다.
              log.debug("===================================================================");
              log.debug("    BKG_CONTAINER 를 조회한다.                                      ");
              log.debug("===================================================================");

              List<CntrInfoVO> cntrInfoVOs = dbDao.searchCntrInfo(retBkgNo, blInfosVO.getBkgCgoTpCd(), blInfosVO.getBbCgoFlg());
              blInfoVO.setCntrInfoVOs(cntrInfoVOs);

              log.debug("=========================================================================");
              log.debug("    Outstanding Amounts 조회를 위한 Office 정보 조회                                                               ");
              log.debug("=========================================================================");
              
              OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
              log.debug("ERP I/F를 위한 EAIDAO 호출");
              //by sungho 2010.03.04
              //otsRcvInfoVO = eaiDbDao.searchOtsInfo(blInfosVO.getBlNo());
              otsRcvInfoVO = this.searchErpOtsInfo(blInfosVO.getBlNo());
              
              blInfoVO.setOtsRcvInfoVO(otsRcvInfoVO);
              
              //blInfosVO와 otsRcvInfoVO를 merge한다.              
              if (blInfoVO.getOtsRcvInfoVO() != null) {
            	  ObjectCloner.build(otsRcvInfoVO, blInfosVO);
            	  
            	  blInfoVO.setBlInfosVO(blInfosVO);
              }
              
              log.debug("==================================================================");
              log.debug("    DEM.DET I/F를 위한 Booking Number에 연계된 Container Number 조회     ");
              log.debug("==================================================================");
              String[] cntrs = dbCargo.searchDemDetCntrList(retBkgNo);
              blInfoVO.setCntrs(cntrs);

              // BKG_CONTAINER 과 BKG_CNTR_SEAL_NO 테이블을 조인하여 CNTR_SEAL_NO를 조회한다.
              log.debug("===================================================================");
              log.debug(" BKG_CONTAINER 과 BKG_CNTR_SEAL_NO 테이블을 조인하여 CNTR_SEAL_NO를 조회한다. ");
              log.debug("===================================================================");

              List<CntrBySealNoVO> cntrBySealNoVOs = dbDao.searchCntrBySealNo(retBkgNo);
              blInfoVO.setCntrBySealNoVOs(cntrBySealNoVOs);
	              
            }
            return blInfoVO;

		} catch(EventException ex) {
			throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
    }
    
	/**
	 * Movement 화면에 대한 조회 이벤트 처리한다.<br>
	 * 
	 * @param String bkgNo Booking No.
	 * @return CntrMvntVO
	 * @exception EventException
	 */
	public CntrMvntVO searchCntrMvntInfo(String bkgNo) throws EventException {
		
		CntrMvntVO cntrMvntVO = new CntrMvntVO();

		String retBkgNo = bkgNo;
		String bkgStsCd = null;

		
		try {

            // Booking Status를 체크한다.
            log.debug("===================================================================");
            log.debug("    Booking Status를 체크한다.                                      ");
            log.debug("===================================================================");

            bkgStsCd = validateBkgSts(retBkgNo);
            log.debug("    Booking Status를 체크한다. ===> " + bkgStsCd);
			
        	List<CntrMvntMstsVO> cntrMvntMstsVOs = dbDao.searchCntrMvntMstInfo(retBkgNo);
            cntrMvntVO.setCntrMvntMstsVOs(cntrMvntMstsVOs);

            log.debug("*********** setActMvntVOs ***************");
            
            if(cntrMvntMstsVOs != null){
    	        List<CntrMvntDtlsVO> cntrMvntDtlsVOs = dbDao.searchCntrMvntDtlInfo(retBkgNo);
                cntrMvntVO.setCntrMvntDtlsVOs(cntrMvntDtlsVOs);

                log.debug("*********** setCntrMvntDtlsVOs ***************");


                // 기본 정보를 조회한다.
                log.debug("============================================================");
                log.debug("    기본 Reference 정보  조회      ");
                log.debug("============================================================");

//                TopBlInfoVO bkgInfoVO = dbDao.searchTopBlInfo(retBkgNo);
//                cntrMvntVO.setBkgInfoVO(bkgInfoVO);            
            
            }	            
            return cntrMvntVO;
		} catch(EventException ex) {
			throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
	}    

	/**
	 * S/O Info 화면에 대한 조회 이벤트 처리한다.<br>
	 * 
	 * @param String bkgNo Booking No.
	 * @return SoInfoVO
	 * @exception EventException
	 */
	public SoInfoVO searchUsSoInfo(String bkgNo) throws EventException {
		
		SoInfoVO soVO = new SoInfoVO();

		String retBkgNo = bkgNo;
		String bkgStsCd = null;

		
		try {

            // Booking Status를 체크한다.
            log.debug("===================================================================");
            log.debug("    Booking Status를 체크한다.                                      ");
            log.debug("===================================================================");

            bkgStsCd = validateBkgSts(retBkgNo);
            log.debug("    Booking Status를 체크한다. ===> " + bkgStsCd);
			
        	List<UsCntrSoInfosVO> usCntrSoInfosVOs = dbDao.searchUsCntrSoInfo(retBkgNo);
	        soVO.setUsCntrSoInfosVOs(usCntrSoInfosVOs);

            log.debug("*********** cntrSoVOs ***************");
            
            if(usCntrSoInfosVOs != null){
                log.debug("===================================================================");
                log.debug("    searchUsCntrSoDtlInfo 리스트 를 조회한다.                           ");
                log.debug("===================================================================");
            	List<UsCntrSoDtlInfosVO> usCntrSoDtlInfosVOs = dbDao.searchUsCntrSoDtlInfo(retBkgNo);
    	        soVO.setUsCntrSoDtlInfosVOs(usCntrSoDtlInfosVOs);

                log.debug("*********** setCntrMvntDtlsVOs ***************");

            	
            	// TP/SZ QTY 리스트 를 조회한다.
                log.debug("===================================================================");
                log.debug("    TP/SZ QTY 리스트 를 조회한다.                                    ");
                log.debug("===================================================================");

                List<TpszQtyVO> tpszQtyVOs = dbDao.searchQtyForCntrByTpsz(retBkgNo);
                soVO.setTpszQtyVOs(tpszQtyVOs);

                // 기본 정보를 조회한다.
                log.debug("============================================================");
                log.debug("    기본 Reference 정보  조회      ");
                log.debug("============================================================");

//                BkgInfoVO bkgInfoVO = dbDao.searchBkgInfo(retBkgNo);
//                TopBlInfoVO bkgInfoVO = dbDao.searchTopBlInfo(retBkgNo);
//                soVO.setBkgInfoVO(bkgInfoVO);            
                
            }

            return soVO;
		} catch(EventException ex) {
			throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
	}    

	/**
	 * S/O Info 화면에 대한 조회 이벤트 처리한다.<br>
	 * 
	 * @param String bkgNo Booking No.
	 * @return SoInfoVO
	 * @exception EventException
	 */
	public SoInfoVO searchSoInfo(String bkgNo) throws EventException {
		
		SoInfoVO soVO = new SoInfoVO();

		String retBkgNo = bkgNo;
		String bkgStsCd = null;

		
		try {

            // Booking Status를 체크한다.
            log.debug("===================================================================");
            log.debug("    Booking Status를 체크한다.                                      ");
            log.debug("===================================================================");

            bkgStsCd = validateBkgSts(retBkgNo);
            log.debug("    Booking Status를 체크한다. ===> " + bkgStsCd);
			
        	List<CntrSoVO> cntrSoVOs = dbDao.searchCntrSoInfo(retBkgNo);
	        soVO.setCntrSoVOs(cntrSoVOs);

            log.debug("*********** cntrSoVOs ***************");
            
            if(cntrSoVOs != null){
                log.debug("===================================================================");
                log.debug("    setCntrMvntDtlsVOs 리스트 를 조회한다.                           ");
                log.debug("===================================================================");
            	List<CntrSoDtlVO> cntrSoDtlVOs = dbDao.searchCntrSoDtlInfo(retBkgNo);
    	        soVO.setCntrSoDtlVOs(cntrSoDtlVOs);

                log.debug("*********** setCntrMvntDtlsVOs ***************");

            	
            	// TP/SZ QTY 리스트 를 조회한다.
                log.debug("===================================================================");
                log.debug("    TP/SZ QTY 리스트 를 조회한다.                                    ");
                log.debug("===================================================================");

                List<TpszQtyVO> tpszQtyVOs = dbDao.searchQtyForCntrByTpsz(retBkgNo);
                soVO.setTpszQtyVOs(tpszQtyVOs);

                // 기본 정보를 조회한다.
                log.debug("============================================================");
                log.debug("    기본 Reference 정보  조회      ");
                log.debug("============================================================");

//                BkgInfoVO bkgInfoVO = dbDao.searchBkgInfo(retBkgNo);
//                TopBlInfoVO bkgInfoVO = dbDao.searchTopBlInfo(retBkgNo);
//                soVO.setBkgInfoVO(bkgInfoVO);            
                
            }

            return soVO;
		} catch(EventException ex) {
			throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
	}    
	
	
	/**
	 * Booking Status를 체크한다.<br>
	 * 
	 * @param String bkgNo Booking No.
	 * @return String
	 * @exception EventException
	 */
	private String validateBkgSts(String bkgNo) throws EventException {
		try {
			String bkgStsCd = null;
			
			bkgStsCd = dbDao.searchBkgStatus(bkgNo);
			
			if (bkgStsCd.equals("W")) {
	            throw new EventException(new ErrorHandler("BKG04004").getMessage());
			} else if (bkgStsCd.equals("X")) {
	            throw new EventException(new ErrorHandler("BKG00005").getMessage());
			} else if (bkgStsCd.equals("")) {
	            throw new EventException(new ErrorHandler("BKG40033", new String[]{bkgNo}).getMessage());
			} else {
				bkgStsCd = dbDao.searchBkgCgoTp(bkgNo);
			}
			
			log.debug("bkgStsCd  ===> " + bkgStsCd);

	        if (bkgStsCd.equals("P")) {        	
	            throw new EventException(new ErrorHandler("BKG40030").getMessage());
	        }
	        
			return bkgStsCd;
		} catch(EventException ex) {
			throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
	}

    /**
     * 조회 이벤트 처리<br>
     * UI_BKG_0668 화면의 B/L Info 조회한다.<br>
     * 
     * @param String bkgNo Booking No.
     * @param SignOnUserAccount account
     * @param String CntrNo
     * @return BlInfoVO
     * @exception EventException
     */
    public BlInfoVO searchUsBlInfo(String bkgNo, SignOnUserAccount account, String CntrNo) throws EventException {

        BlInfoVO blInfoVO = new BlInfoVO();
        String retBkgNo = bkgNo;
        String retCntrNo = CntrNo;
        String retPartialYn = "";
        
        try {

            // Booking Status를 체크한다.
            log.debug("===================================================================");
            log.debug("    Booking Status를 체크한다.                                      ");
            log.debug("===================================================================");

            String bkgStsCd = validateBkgSts(retBkgNo);
            
            log.debug("    Booking Status를 체크한다. ===> " + bkgStsCd);
        	        	
	            	
            // 기본 정보를 조회한다.
            log.debug("============================================================");
            log.debug("    기본 Reference 정보  조회      ");
            log.debug("============================================================");

            BlInfosVO blInfosVO = dbDao.searchBlInfo(retBkgNo);
            blInfoVO.setBlInfosVO(blInfosVO);
            
            if(blInfosVO != null){
            	UsBlInfosVO usBlInfosVO = new UsBlInfosVO();
            	ObjectCloner.build(blInfosVO, usBlInfosVO);
            	blInfoVO.setUsBlInfosVO(usBlInfosVO);
            	retPartialYn = blInfosVO.getPartial();  // Partial 여부 Y N
            	
            	// searchUsCstmsRef를 조회한다.
                log.debug("===================================================================");
                log.debug("    searchUsCstmsRef를 조회한다.s                                    ");
                log.debug("===================================================================");
                UsCstmsRefInfoVO usCstmsRefVO = dbDao.searchUsCstmsRefInfo(retBkgNo);
	            blInfoVO.setUsCstmsRefVO(usCstmsRefVO);

	            //blInfosVO와 usCstmsRefVO를 merge한다.              
	            if (blInfoVO.getUsCstmsRefVO() != null) {
	            	ObjectCloner.build(usCstmsRefVO, usBlInfosVO);
	            	  
	            	blInfoVO.setUsBlInfosVO(usBlInfosVO);
	            }	            
	            
	            // TP/SZ QTY 리스트 를 조회한다.
                log.debug("===================================================================");
                log.debug("    TP/SZ QTY 리스트 를 조회한다.                                    ");
                log.debug("===================================================================");

                List<TpszQtyVO> tpszQtyVOs = dbDao.searchQtyForCntrByTpsz(retBkgNo);
                blInfoVO.setTpszQtyVOs(tpszQtyVOs);

	            // Customs Clear 정보를 조회한다.
                log.debug("===================================================================");
                log.debug("    Customs Clear 정보를 조회한다.                                  ");
                log.debug("===================================================================");
                CstmsClearInfoVO cstmsClearInfoVO = dbDao.searchCstmsClearInfo(retBkgNo);
                blInfoVO.setCstmsClearInfoVO(cstmsClearInfoVO);
                
	            //blInfosVO와 cstmsClearInfoVO를 merge한다.              
	            if (blInfoVO.getCstmsClearInfoVO() != null) {
	            	ObjectCloner.build(cstmsClearInfoVO, usBlInfosVO);
	            	  
	            	blInfoVO.setUsBlInfosVO(usBlInfosVO);
	            }	            
                
                
	            log.debug("=========================================================================");
	            log.debug("    Outstanding Amounts 조회를 위한 Office 정보 조회                                                               ");
	            log.debug("=========================================================================");

	            UsFreigtInfoVO usFreigtInfoVO = dbDao.searchUsFrgightInfo(retBkgNo);
                blInfoVO.setUsFreigtInfoVO(usFreigtInfoVO);

                //blInfosVO와 usFreigtInfoVO를 merge한다.              
	            if (blInfoVO.getUsFreigtInfoVO() != null) {
	            	ObjectCloner.build(usFreigtInfoVO, usBlInfosVO);
	            	  
	            	blInfoVO.setUsBlInfosVO(usBlInfosVO);
	            }	   
	            
	            OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
	            log.debug("ERP I/F를 위한 EAIDAO 호출");
	            //by sungho 2010.03.04
	            //otsRcvInfoVO = eaiDbDao.searchOtsInfo(blInfosVO.getBlNo());
	            otsRcvInfoVO = this.searchErpOtsInfo(blInfosVO.getBlNo());
	            blInfoVO.setOtsRcvInfoVO(otsRcvInfoVO);

                //blInfosVO와 otsRcvInfoVO를 merge한다.              
	            if (blInfoVO.getOtsRcvInfoVO() != null) {
	            	ObjectCloner.build(otsRcvInfoVO, usBlInfosVO);
	            	  
	            	blInfoVO.setUsBlInfosVO(usBlInfosVO);
	            }	   
	            
	            // 고객 응대를 위한 In-bound US C/S Screen_Main_US)에서 Container별 P/N  발송 정보를 조회한다.
                log.debug("===================================================================");
                log.debug(" 고객 응대를 위한 In-bound US C/S Screen_Main_US)에서 Container별 P/N  발송 정보를 조회한다. ");
                log.debug("===================================================================");

                List<CntrPkupNtcInfoVO> cntrPkupNtcInfoVO = dbDao.searchUsCntrInfo(retBkgNo, account.getOfc_cd(), retCntrNo , retPartialYn );
                blInfoVO.setCntrPkupNtcInfoVOs(cntrPkupNtcInfoVO);
                
                // BKG_CONTAINER 테이블에서 데이터 를 조회한다.
	            log.debug("===================================================================");
	            log.debug("    BKG_CONTAINER 를 조회한다.                                      ");
	            log.debug("===================================================================");			
	            List<CntrInfoVO> cntrInfoVOs = dbDao.searchCntrInfo(retBkgNo, blInfosVO.getBkgCgoTpCd(), blInfosVO.getBbCgoFlg());
	            blInfoVO.setCntrInfoVOs(cntrInfoVOs);
	            
	            log.debug("==================================================================");
	            log.debug("    DEM.DET I/F를 위한 Booking Number에 연계된 Container Number 조회     ");
	            log.debug("==================================================================");
	            String[] cntrs = dbCargo.searchDemDetCntrList(retBkgNo);
	            blInfoVO.setCntrs(cntrs);
	
	            // BKG_CONTAINER 과 BKG_CNTR_SEAL_NO 테이블을 조인하여 CNTR_SEAL_NO를 조회한다.
	            log.debug("===================================================================");
	            log.debug(" BKG_CONTAINER 과 BKG_CNTR_SEAL_NO 테이블을 조인하여 CNTR_SEAL_NO를 조회한다. ");
	            log.debug("===================================================================");			
	            List<CntrBySealNoVO> cntrBySealNoVOs = dbDao.searchCntrBySealNo(retBkgNo);
	            blInfoVO.setCntrBySealNoVOs(cntrBySealNoVOs);			            
            }
            
            return blInfoVO;

		} catch(EventException ex) {
			throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
    }
    
    
    /**
     * 조회 이벤트 처리<br>
     * ESM_BKG_0668_5 화면의 Customs Result 를 조회한다.<br>
     * 
     * @param String bkgNo Booking No.
     * @return List<BkgCstmsAdvRsltVO>
     * @exception EventException
     */
    public List<BkgCstmsAdvRsltVO> searchUsCstmsAdvRsltInfo(String bkgNo) throws EventException
    {
    	List<BkgCstmsAdvRsltVO> list = null;
    	String bkgStsCd = null;
    	try
    	{
    		bkgStsCd = validateBkgSts(bkgNo);
    		log.debug("    Booking Status를 체크한다. ===> " + bkgStsCd);
            list = dbDao.searchUsCstmsRstInfo(bkgNo);
		} catch(EventException ex) {
			throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
    	return list;
    }

	/**
	 * Movement 화면에 대한 조회 이벤트 처리한다.<br>
	 * 
	 * @param String bkgNo Booking No.
	 * @return CntrMvntVO
	 * @exception EventException
	 */
	public CntrMvntVO searchCntrMvntInfoByUs(String bkgNo) throws EventException {
		
		CntrMvntVO cntrMvntVO = new CntrMvntVO();

		String retBkgNo = bkgNo;
		String bkgStsCd = null;
		String cntrNo   = null;
		
		try {

            // Booking Status를 체크한다.
            log.debug("===================================================================");
            log.debug("    Booking Status를 체크한다.                                      ");
            log.debug("===================================================================");

            bkgStsCd = validateBkgSts(retBkgNo);
            log.debug("    Booking Status를 체크한다. ===> " + bkgStsCd);
			
        	List<CntrMvntMstsVO> cntrMvntMstsVOs = dbDao.searchCntrMvntMstInfo(retBkgNo);
            cntrMvntVO.setCntrMvntMstsVOs(cntrMvntMstsVOs);

            log.debug("*********** setCntrMvntMstsVOs ***************");
            
            if(cntrMvntMstsVOs != null){
            	
            	// 첫번째 cntrNo의 값을 조회하여 값을 넘겨준다. 값이 없는 경우 조회하지 않는다.
            	if (cntrMvntMstsVOs.size() > 0) {
            		cntrNo = cntrMvntMstsVOs.get(0).getCntrNo();
	            	
	            	List<CntrClmInfosVO> cntrClmInfosVOs = dbDao.searchCntrClmInfo(retBkgNo, cntrNo);
	                cntrMvntVO.setCntrClmInfosVOs(cntrClmInfosVOs);
	                log.debug("*********** setCntrUsMvntDtlsVOs ***************");
            	} else {
            		cntrMvntVO.setCntrClmInfosVOs(null);
            	}
            	
            	List<CntrMvntDtlsVO> cntrMvntDtlsVOs = dbDao.searchCntrMvntDtlInfo(retBkgNo);
                cntrMvntVO.setCntrMvntDtlsVOs(cntrMvntDtlsVOs);		
                log.debug("*********** setCntrMvntDtlsVOs ***************");


                // 기본 정보를 조회한다.
                log.debug("============================================================");
                log.debug("    기본 Reference 정보  조회      ");
                log.debug("============================================================");

//                BkgInfoVO bkgInfoVO = dbDao.searchBkgInfo(retBkgNo);
//                TopBlInfoVO bkgInfoVO = dbDao.searchTopBlInfo(retBkgNo);
//                cntrMvntVO.setBkgInfoVO(bkgInfoVO);       
            }	            
            return cntrMvntVO;
		} catch(EventException ex) {
			throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
	}    

	/**
	 * Movement 화면에서 선택한 Container No. 대한 CLM목록을 조회한다.<br>
	 * 
	 * @param String bkgNo Booking No.
	 * @param String cntrNo Container No.
	 * @return List<CntrClmInfosVO>
	 * @exception EventException
	 */
	public List<CntrClmInfosVO> searchCntrClmInfo(String bkgNo, String cntrNo) throws EventException {
		try {
			return dbDao.searchCntrClmInfo(bkgNo, cntrNo);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
	}

	/**
	 * 조회 이벤트 처리<br>
     * Container No로 조회시 연계된 B/L이 LCL인 경우,관련 B/L List를 조회하고 <br>
	 * LCL이 아닌 경우,단건의 B/L 정보를 조회한다.<br>
	 * @param String cntrNo Container No.
	 * @return List<BkgBlInfosVO>
	 * @exception EventException
	 */	
	public List<BkgBlInfosVO> searchBlListByCntrNo(String cntrNo)  throws EventException {
		try {
			log.debug("BC (searchBlListByCntrNo) =====> " + cntrNo);
			
			return dbDao.searchBlListByCntrNo(cntrNo);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
	}

	/**
	 * BKG 공통 UTIL <br>
	 *  P.O. No에 둘이상의 B/L 또는 관련 B/L 목록을 List Up하고 아니면 단건의 B/L 항목을 조회한다.  <br>
	 * @param String poNo P/O No.
	 * @return BkgBlInfosVO
	 * @exception EventException
	 */
	
	public List<BkgBlInfosVO> searchBlListByPoNo (String poNo) throws EventException {
		try {
			return dbDao.searchBlListByPoNo(poNo);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * HB/L No로 BKG NO 조회. <br>
	 * @param String hbl_no H.B/L No.
	 * @return List<BkgBlInfosVO>
	 * @exception EventException
	 */
	
	public  List<BkgBlInfosVO> searchBlListByHblNo (String hbl_no) throws EventException {
		try {
			return dbDao.searchBlListByHblNo(hbl_no);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
	}

	/**
	 * 조회 이벤트 처리<br>
	 * BKG No로 SPLIT BL NO 조회. <br>
	 * @param String bkg_no Booking No.
	 * @return List<BkgBlInfosVO>
	 * @exception EventException
	 */
	
	public  List<BkgBlInfosVO> searchBlListByBkgSplit (String bkg_no) throws EventException {
		try {
			return dbDao.searchBlListByBkgSplit(bkg_no);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
	}
	
	/**
	 * 고객 응대를 위한 Arrival Notice & B/L Copy 발송 정보 관리<br>
	 * @param String bkgNo Booking No.
     * @param SignOnUserAccount account
	 * @return ArrNtcInfoVO
	 * @exception EventException
	 */
	public ArrNtcInfoVO searchUsArrNtcInfo (String bkgNo, SignOnUserAccount account) throws EventException {
		ArrNtcInfoVO arrNtcInfoVO = new ArrNtcInfoVO();

		String bkgStsCd = null;
		
		try {

            // Booking Status를 체크한다.
            log.debug("===================================================================");
            log.debug("    Booking Status를 체크한다.                                      ");
            log.debug("===================================================================");

            bkgStsCd = validateBkgSts(bkgNo);
            log.debug("    Booking Status를 체크한다. ===> " + bkgStsCd);
			
            List<BlCustInfoVO> blCustInfoVOs = dbDao.searchBlCustInfo(bkgNo);
            arrNtcInfoVO.setBlCustInfoVOs(blCustInfoVOs);

            log.debug("*********** searchArrNtcCustInfo ***************");
            
            if(blCustInfoVOs != null){
            	
            	List<ArrNtcCneeInfoVO> arrNtcCneeInfoVOs = dbDao.searchArrNtcCneeInfo(bkgNo, account);
            	arrNtcInfoVO.setArrNtcCneeInfoVOs(arrNtcCneeInfoVOs);
                log.debug("*********** searchArrNtcCneeInfo ***************");

            	List<ArrNtcNtfyInfoVO> arrNtcNtfyInfoVOs = dbDao.searchArrNtcNtfyInfo(bkgNo, account);
            	arrNtcInfoVO.setArrNtcNtfyInfoVOs(arrNtcNtfyInfoVOs);
                log.debug("*********** searchArrNtcNtfyInfo ***************");
                

                // 기본 정보를 조회한다.
                log.debug("============================================================");
                log.debug("    기본 Reference 정보  조회      ");
                log.debug("============================================================");

//                BkgInfoVO bkgInfoVO = dbDao.searchBkgInfo(bkgNo);
                TopBlInfoVO bkgInfoVO = dbDao.searchTopBlInfo(bkgNo);
                arrNtcInfoVO.setBkgInfoVO(bkgInfoVO);       
            }	            
            return arrNtcInfoVO;
		} catch(EventException ex) {
			throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
	}

//	/**
//	 * 고객 응대를 위한 Arrival Notice & B/L Copy 발송 정보 관리<br>
//	 * @param String bkgNo Booking No.
//     * @param SignOnUserAccount account
//	 * @return ArrNtcBlCopyInfoVO
//	 * @exception EventException
//	 */
//	public ArrNtcBlCopyInfoVO searchUsArrNtcBlCopyInfo (String bkgNo, SignOnUserAccount account) throws EventException {
//		ArrNtcBlCopyInfoVO arrNtcBlCopyInfoVO = new ArrNtcBlCopyInfoVO();
//
//		String bkgStsCd = null;
//		
//		try {
//
//            // Booking Status를 체크한다.
//            log.debug("===================================================================");
//            log.debug("    Booking Status를 체크한다.                                      ");
//            log.debug("===================================================================");
//
//            bkgStsCd = validateBkgSts(bkgNo);
//            log.debug("    Booking Status를 체크한다. ===> " + bkgStsCd);
//			
//            ArrNtcBlCopyBkgInfoVO arrNtcBlCopyBkgInfoVO = dbDao.searchArrNtcBlCopyBkgInfo(bkgNo);
//            arrNtcBlCopyInfoVO.setArrNtcBlCopyBkgInfoVO(arrNtcBlCopyBkgInfoVO);
//
//            log.debug("*********** setCntrMvntMstsVOs ***************");
//            
//            if(arrNtcBlCopyBkgInfoVO != null){
//            	
//            	List<ArrNtcBlCopyFaxInfoVO> arrNtcBlCopyFaxInfoVOs = dbDao.searchArrNtcBlCopyFaxInfo(bkgNo, account);
//            	arrNtcBlCopyInfoVO.setArrNtcBlCopyFaxInfoVOs(arrNtcBlCopyFaxInfoVOs);
//                log.debug("*********** setArrNtcBlCopyFaxInfoVOs ***************");
//
//            	List<ArrNtcBlCopyMailInfoVO> arrNtcBlCopyMailInfoVOs = dbDao.searchArrNtcBlCopyMailInfo(bkgNo, account);
//            	arrNtcBlCopyInfoVO.setArrNtcBlCopyMailInfoVOs(arrNtcBlCopyMailInfoVOs);
//                log.debug("*********** setArrNtcBlCopyMailInfoVOs ***************");
//                
//
//                // 기본 정보를 조회한다.
//                log.debug("============================================================");
//                log.debug("    기본 Reference 정보  조회      ");
//                log.debug("============================================================");
//
//                BkgInfoVO bkgInfoVO = dbDao.searchBkgInfo(bkgNo);
//                arrNtcBlCopyInfoVO.setBkgInfoVO(bkgInfoVO);       
//            }	            
//            return arrNtcBlCopyInfoVO;
//		} catch(EventException ex) {
//			throw ex;
//        } catch(DAOException ex) {
//            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
//        } catch(Exception ex) {
//            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
//        }
//	}

	/**
	 * B/L 단위로 Email 로 P/N를 송부한다. <br>
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return PkupNtcInfoVO
	 * @exception EventException
	 */
	public PkupNtcInfoVO searchPkupNtcInfo (String bkgNo, SignOnUserAccount account) throws EventException {
		PkupNtcInfoVO pkupNtcInfoVO = new PkupNtcInfoVO();

		String bkgStsCd = null;
		
		try {

            // Booking Status를 체크한다.
            log.debug("===================================================================");
            log.debug("    Booking Status를 체크한다.                                      ");
            log.debug("===================================================================");

            bkgStsCd = validateBkgSts(bkgNo);
            log.debug("    Booking Status를 체크한다. ===> " + bkgStsCd);
			
            List<BlCustInfoVO> blCustInfoVOs = dbDao.searchBlCustInfo(bkgNo);
            pkupNtcInfoVO.setBlCustInfoVOs(blCustInfoVOs);

            log.debug("*********** searchBlCustInfo ***************");
            
            if(blCustInfoVOs != null){
            	
            	List<PkupNtcCneeInfoVO> pkupNtcCneeInfoVOs = dbDao.searchPkupNtcCneeInfo(bkgNo, account.getOfc_cd());
            	pkupNtcInfoVO.setPkupNtcCneeInfoVOs(pkupNtcCneeInfoVOs);
                log.debug("*********** searchPkupNtcFaxInfo ***************");

            	List<PkupNtcNtfyInfoVO> pkupNtcNtfyInfoVOs = dbDao.searchPkupNtcNtfyInfo(bkgNo, account.getOfc_cd());
            	pkupNtcInfoVO.setPkupNtcNtfyInfoVOs(pkupNtcNtfyInfoVOs);
                log.debug("*********** searchPkupNtcMailInfo ***************");
                

                // 기본 정보를 조회한다.
                log.debug("============================================================");
                log.debug("    기본 Reference 정보  조회      ");
                log.debug("============================================================");

//                BkgInfoVO bkgInfoVO = dbDao.searchBkgInfo(bkgNo);
//                TopBlInfoVO bkgInfoVO = dbDao.searchTopBlInfo(bkgNo);
//                pkupNtcInfoVO.setBkgInfoVO(bkgInfoVO);       
            }	            
            return pkupNtcInfoVO;
		} catch(EventException ex) {
			throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
	}
	
	/**
	 *  미주 Inbound Cargo Release에 대한 List를 Item별로 조회한다. <br>
	 * @param String bkgNo Booking No.
	 * @return BkgInfoVO
	 * @exception EventException
	 */
	public BlInfoVO searchUsCgoRlseInfo (String bkgNo) throws EventException {
		
		BlInfoVO blInfoVO = new BlInfoVO();
		
		String retBkgNo = bkgNo;
		String bkgStsCd = null;

		
		try {

            // Booking Status를 체크한다.
            log.debug("===================================================================");
            log.debug("    Booking Status를 체크한다.                                      ");
            log.debug("===================================================================");

            bkgStsCd = validateBkgSts(retBkgNo);
            log.debug("    Booking Status를 체크한다. ===> " + bkgStsCd);
			
            // 기본 정보를 조회한다.
            log.debug("============================================================");
            log.debug("    기본 Reference 정보  조회      ");
            log.debug("============================================================");

            BlInfosVO blInfo = dbDao.searchBlInfo(bkgNo);
            if(blInfo != null){
                
            	log.debug("PODCD : " + blInfo.getPodCd());
            	
                if(!blInfo.getPodCd().substring(0,2).equals("US")){
                    String[] msg = new String[]{blInfo.getPodCd()};
                    throw new EventException(new ErrorHandler("BKG40091", msg).getMessage());
                    //You can't handle this B/L Because the Port of Discharging is [$s]
                }
            	
                blInfoVO.setBlInfosVO(blInfo);
            }
            
            
            return blInfoVO;
		} catch(EventException ex) {
			throw ex;
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
	}  	
	
	/**
     * 조회 이벤트 처리<br>
     * C/S Screen Top부분의 공통적인 영역을 담당한다.<br>
     * 
     * @param String bkgNo Booking No.
     * @return TopBlInfoVO
     * @exception EventException
     */
    public TopBlInfoVO searchTopBlInfo(String bkgNo) throws EventException {

    	TopBlInfoVO blInfoVO = new TopBlInfoVO();

        String bkgStsCd        = null;
        String retBkgNo        = bkgNo;
        
        try {
            // Booking Status를 체크한다.
            log.debug("===================================================================");
            log.debug("    Booking Status를 체크한다.                                      ");
            log.debug("===================================================================");

            bkgStsCd = validateBkgSts(retBkgNo);
            log.debug("    Booking Status를 체크한다. ===> " + bkgStsCd);
            	
            // 기본 정보를 조회한다.
            log.debug("============================================================");
            log.debug("    기본 Reference 정보  조회      ");
            log.debug("============================================================");

            blInfoVO = dbDao.searchTopBlInfo(retBkgNo);

            return blInfoVO;

		} catch(EventException ex) {
			throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
    }	
    
    /**
	 * 고객 응대를 위한 Arrival Notice & B/L Copy 발송 정보 관리<br>
	 * @param String bkgNo Booking No.
	 * @param SignOnUserAccount account
	 * @return ArrNtcInfoVO
	 * @exception EventException
	 */
	public  ArrNtcInfoVO searchArrNtcInfo (String bkgNo, SignOnUserAccount account) throws EventException {
		ArrNtcInfoVO arrNtcInfoVO = new ArrNtcInfoVO();

		String bkgStsCd = null;
		
		try {

            // Booking Status를 체크한다.
            log.debug("===================================================================");
            log.debug("    Booking Status를 체크한다.                                      ");
            log.debug("===================================================================");

            bkgStsCd = validateBkgSts(bkgNo);
            log.debug("    Booking Status를 체크한다. ===> " + bkgStsCd);
			
            List<BlCustInfoVO> blCustInfoVOs = dbDao.searchBlCustInfo(bkgNo);
            arrNtcInfoVO.setBlCustInfoVOs(blCustInfoVOs);

            log.debug("*********** searchArrNtcCustInfo ***************");
            
            if(blCustInfoVOs != null){ 
            	
            	List<ArrNtcCneeInfoVO> arrNtcCneeInfoVOs = dbDao.searchArrNtcCneeInfo(bkgNo, account);
            	arrNtcInfoVO.setArrNtcCneeInfoVOs(arrNtcCneeInfoVOs);
                log.debug("*********** searchArrNtcCneeInfo ***************");

            	List<ArrNtcNtfyInfoVO> arrNtcNtfyInfoVOs = dbDao.searchArrNtcNtfyInfo(bkgNo, account);
            	arrNtcInfoVO.setArrNtcNtfyInfoVOs(arrNtcNtfyInfoVOs);
                log.debug("*********** searchArrNtcNtfyInfo ***************");
                

                // 기본 정보를 조회한다.
                log.debug("============================================================");
                log.debug("    기본 Reference 정보  조회      ");
                log.debug("============================================================");

//                TopBlInfoVO bkgInfoVO = dbDao.searchTopBlInfo(bkgNo);
//                
//                arrNtcInfoVO.setBkgInfoVO(bkgInfoVO);       
            }	            
            return arrNtcInfoVO;
		} catch(EventException ex) {
			throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
	}
	
	
    /**
     * ERP I/F를 위한 EAIDAO 호출
     *
     * @param String blNo
     * @return OtsRcvInfoVO
     * @exception EventException
     */
    public OtsRcvInfoVO searchErpOtsInfo(String blNo) throws EventException {
        OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
        try {
            log.debug("ERP I/F를 위한 EAIDAO 호출");            
            otsRcvInfoVO = eaiDbDao.searchOtsInfo(blNo);
            
            
            log.debug("------------------- otsRcvInfoVO " + otsRcvInfoVO.getColumnValues());
          //if(otsRcvInfoVO.getTotOtsCurrCd1() == null || otsRcvInfoVO.getTotOtsCurrCd1().trim().equals("")){
            if(otsRcvInfoVO.getTotOtsAmt1() == null 
            		|| otsRcvInfoVO.getTotOtsAmt1().trim().equals("")
            		|| otsRcvInfoVO.getTotOtsStsCd() == null
            		|| otsRcvInfoVO.getTotOtsStsCd().trim().equals("")
            		){
            	otsRcvInfoVO.setTotOtsStsCd("");            
                otsRcvInfoVO.setTotOtsAmt1("N/A");
            }
            //if(true){
            //	throw new EventException(new ErrorHandler("COM12240").getMessage());
            //}
        } catch (DAOException de) {
        	//중첩 Try문 사용 이유 : Business Logic 상 Exception 처리불가. (ERP 모듈 Exception이 발생해도 InBound 로직은 진행되어야 한다.)
            log.error("err " + de.toString(), de);
            otsRcvInfoVO.setTotOtsStsCd("");            
            otsRcvInfoVO.setTotOtsAmt1("ERP I/F Error");
            //throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
        	//중첩 Try문 사용 이유 : Business Logic 상 Exception 처리불가. (ERP 모듈 Exception이 발생해도 InBound 로직은 진행되어야 한다.)
            log.error("err " + ex.toString(), ex);
            otsRcvInfoVO.setTotOtsStsCd("");            
            otsRcvInfoVO.setTotOtsAmt1("ERP I/F Error");
            //throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return otsRcvInfoVO;
   }
    
    /**
	 * Inbound C/S_USA SCREEN에서 저장된 Remark를 조회한다.<br>
	 * 
	 * @param String bkgNo Booking No.
	 * @return List<usCustSvcInstrsVO>
	 * @exception EventException
	 */    
	public List<UsCustSvcInstrsVO> searchUsCustSvcInstr(String bkgNo) throws EventException {
		try {
			return dbDao.searchUsCustSvcInstr(bkgNo);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
	
	/**
	 * Inbound C/S_USA SCREEN에서 저장된 Remark를 등록한다.<br>
	 * 
	 * @param UsCustSvcInstrsVO usCustSvcInstrs
	 * @exception EventException
	 */
	public void createUsCustSvcInstr(UsCustSvcInstrsVO usCustSvcInstrs) throws EventException{
		try{

			dbDao.addUsCustSvcInstr(usCustSvcInstrs);		
			
		}catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
		//}
	}	

	/**
	 * Inbound C/S_USA SCREEN에서 저장된 Remark를 삭제한다.<br>
	 * 
	 * @param UsCustSvcInstrsVO usCustSvcInstrs
	 * @exception EventException
	 */
	public void removeUsCustSvcInstr(UsCustSvcInstrsVO usCustSvcInstrs) throws EventException{
		try{

			dbDao.removeUsCustSvcInstr(usCustSvcInstrs);		
			
		}catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
		//}
	}	
	
}