/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CsScreenBCImpl.java
 *@FileTitle : Break Bulk Detail(s) Pop-up
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration.CargoReleaseOrderDBDAO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OtsRcvInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration.CsScreenDBDAO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.ArrNtcCneeInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.ArrNtcInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.ArrNtcNtfyInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.BkgBlInfosVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.BlCustInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.BlInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.BlInfosVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrBySealNoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrClmInfosVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrMvntDtlsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrMvntMstsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrMvntVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrPkupNtcInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrSoDtlVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrSoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CstmsClearInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.DgCgoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.PkupNtcCneeInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.PkupNtcInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.PkupNtcNtfyInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.SoInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.TopBlInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.TpszQtyVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsBlInfosVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsCntrSoDtlInfosVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsCntrSoInfosVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsCstmsRefInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsCustSvcInstrsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsFreigtInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgAwkCgoVO;
import com.clt.syscommon.common.table.BkgBbCgoVO;
import com.clt.syscommon.common.table.BkgCstmsAdvRsltVO;


/**
 *   CsScreenMgt Business Logic Basic Command implementation<br>
 * - CsScreenMgt handling business transaction.<br>
 *
 * @author
 * @see CsScreenBC
 * @since J2EE 1.4
 */

public class CsScreenBCImpl extends BasicCommandSupport implements CsScreenBC {

	// Database Access Object
	private transient CsScreenDBDAO dbDao = null;
	private transient CargoReleaseOrderDBDAO dbCargo = null;

	/**
	 * CsScreenBCImpl object creation.<br>
	 * CsScreenDBDAO object creation.<br>
	 */
	public CsScreenBCImpl() {
		dbDao = new CsScreenDBDAO();
		dbCargo = new CargoReleaseOrderDBDAO();
	}
	

	/**
	 * DG Cargo Detail(s) Pop-up(UI_BKG-0659) retrieve event process..<br>
	 * 
	 * @author
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
	 * Break Bulk Detail(s) Pop-up(UI_BKG-0660) retrieve event process..<br>
	 * 
	 * @author
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
	 * Awkward Dimension Detail(s) Pop-up(UI_BKG-0661) retrieve event process..<br>
	 * 
	 * @author
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
     * retrieve event process.<br>
     * retrieve B/L Info of UI_BKG_0292. 
     *
     * @author
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
            // checking Booking Status
            log.debug("===================================================================");
            log.debug("    checking Booking Status                                        ");
            log.debug("===================================================================");

            bkgStsCd = validateBkgSts(retBkgNo);
            log.debug("    checking Booking Status. ===> " + bkgStsCd);
            	
            // retrieve basic Reference Info
            log.debug("============================================================");
            log.debug("    retrieve basic Reference Info      ");
            log.debug("============================================================");

            BlInfosVO blInfosVO = dbDao.searchBlInfo(retBkgNo);
            blInfoVO.setBlInfosVO(blInfosVO);

            if(blInfosVO != null){
            	
                // retrieve Customs Ref No
                log.debug("===================================================================");
                log.debug("    retrieve Customs Ref No.                                      ");
                log.debug("===================================================================");

                strCustomsRefNo = dbDao.searchCstmsRefNo(blInfosVO.getBlNo(), account);
                log.debug("    retrieve Customs Ref No. ===> " + strCustomsRefNo);
                blInfoVO.setCustomsRefNo(strCustomsRefNo);

                // retrieve TP/SZ QTY
                log.debug("===================================================================");
                log.debug("    retrieve TP/SZ QTY.                                    ");
                log.debug("===================================================================");

                List<TpszQtyVO> tpszQtyVOs = dbDao.searchQtyForCntrByTpsz(retBkgNo);
                blInfoVO.setTpszQtyVOs(tpszQtyVOs);


              // retrieve BKG_CONTAINER
              log.debug("===================================================================");
              log.debug("    retrieve BKG_CONTAINER.                                      ");
              log.debug("===================================================================");

              List<CntrInfoVO> cntrInfoVOs = dbDao.searchCntrInfo(retBkgNo, blInfosVO.getBkgCgoTpCd(), blInfosVO.getBbCgoFlg());
              blInfoVO.setCntrInfoVOs(cntrInfoVOs);

              log.debug("=========================================================================");
              log.debug("    retrieve Office for retrieving Outstanding Amounts                   ");
              log.debug("=========================================================================");
              
              OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
              log.debug("Call EAIDAO for ERP I/F");
              otsRcvInfoVO = this.searchErpOtsInfo(blInfosVO.getBlNo());
              
              blInfoVO.setOtsRcvInfoVO(otsRcvInfoVO);
              
              // blInfosVO and otsRcvInfoVO merge.
              if (blInfoVO.getOtsRcvInfoVO() != null) {
            	  ObjectCloner.build(otsRcvInfoVO, blInfosVO);
            	  
            	  blInfoVO.setBlInfosVO(blInfosVO);
              }
              
              log.debug("==================================================================");
              log.debug("    Retrieve Container Number for DEM.DET I/F                     ");
              log.debug("==================================================================");
              String[] cntrs = dbCargo.searchDemDetCntrList(retBkgNo);
              blInfoVO.setCntrs(cntrs);

              // retrieve CNTR_SEAL_NO by join table BKG_CONTAINER and BKG_CNTR_SEAL_NO
              log.debug("===================================================================");
              log.debug(" retrieve CNTR_SEAL_NO by join table BKG_CONTAINER and BKG_CNTR_SEAL_NO. ");
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
	 * Movement retrieve event process..<br>
	 * 
	 * @author
	 * @param String bkgNo Booking No.
	 * @return CntrMvntVO
	 * @exception EventException
	 */
	public CntrMvntVO searchCntrMvntInfo(String bkgNo) throws EventException {
		
		CntrMvntVO cntrMvntVO = new CntrMvntVO();

		String retBkgNo = bkgNo;
		String bkgStsCd = null;

		
		try {

            // check Booking Status
            log.debug("===================================================================");
            log.debug("    check Booking Status.                                          ");
            log.debug("===================================================================");

            bkgStsCd = validateBkgSts(retBkgNo);
            log.debug("    check Booking Status. ===> " + bkgStsCd);
			
        	List<CntrMvntMstsVO> cntrMvntMstsVOs = dbDao.searchCntrMvntMstInfo(retBkgNo);
            cntrMvntVO.setCntrMvntMstsVOs(cntrMvntMstsVOs);

            log.debug("*********** setActMvntVOs ***************");
            
            if(cntrMvntMstsVOs != null){
    	        List<CntrMvntDtlsVO> cntrMvntDtlsVOs = dbDao.searchCntrMvntDtlInfo(retBkgNo);
                cntrMvntVO.setCntrMvntDtlsVOs(cntrMvntDtlsVOs);

                log.debug("*********** setCntrMvntDtlsVOs ***************");


                // retrieve basic Reference Info
                log.debug("============================================================");
                log.debug("    retrieve basic Reference Info      ");
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
	 * S/O Info retrieve event process..<br>
	 * 
	 * @author
	 * @param String bkgNo Booking No.
	 * @return SoInfoVO
	 * @exception EventException
	 */
	public SoInfoVO searchUsSoInfo(String bkgNo) throws EventException {
		
		SoInfoVO soVO = new SoInfoVO();

		String retBkgNo = bkgNo;
		String bkgStsCd = null;

		
		try {

            // check Booking Status
            log.debug("===================================================================");
            log.debug("    check Booking Status                                      ");
            log.debug("===================================================================");

            bkgStsCd = validateBkgSts(retBkgNo);
            log.debug("    check Booking Status ===> " + bkgStsCd);
			
        	List<UsCntrSoInfosVO> usCntrSoInfosVOs = dbDao.searchUsCntrSoInfo(retBkgNo);
	        soVO.setUsCntrSoInfosVOs(usCntrSoInfosVOs);

            log.debug("*********** cntrSoVOs ***************");
            
            if(usCntrSoInfosVOs != null){
                log.debug("===================================================================");
                log.debug("    searchUsCntrSoDtlInfo retrieve list.                           ");
                log.debug("===================================================================");
            	List<UsCntrSoDtlInfosVO> usCntrSoDtlInfosVOs = dbDao.searchUsCntrSoDtlInfo(retBkgNo);
    	        soVO.setUsCntrSoDtlInfosVOs(usCntrSoDtlInfosVOs);

                log.debug("*********** setCntrMvntDtlsVOs ***************");

            	
            	// TP/SZ QTY retrieve list.
                log.debug("===================================================================");
                log.debug("    TP/SZ QTY retrieve list.                                    ");
                log.debug("===================================================================");

                List<TpszQtyVO> tpszQtyVOs = dbDao.searchQtyForCntrByTpsz(retBkgNo);
                soVO.setTpszQtyVOs(tpszQtyVOs);

                // retrieve basic Reference Info
                log.debug("============================================================");
                log.debug("    retrieve basic Reference Info      ");
                log.debug("============================================================");

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
	 * S/O Info retrieve event process..<br>
	 * 
	 * @author
	 * @param String bkgNo Booking No.
	 * @return SoInfoVO
	 * @exception EventException
	 */
	public SoInfoVO searchSoInfo(String bkgNo) throws EventException {
		
		SoInfoVO soVO = new SoInfoVO();

		String retBkgNo = bkgNo;
		String bkgStsCd = null;

		
		try {

            // check Booking Status
            log.debug("===================================================================");
            log.debug("    check Booking Status                                      ");
            log.debug("===================================================================");

            bkgStsCd = validateBkgSts(retBkgNo);
            log.debug("    check Booking Status ===> " + bkgStsCd);
			
        	List<CntrSoVO> cntrSoVOs = dbDao.searchCntrSoInfo(retBkgNo);
	        soVO.setCntrSoVOs(cntrSoVOs);

            log.debug("*********** cntrSoVOs ***************");
            
            if(cntrSoVOs != null){
                log.debug("===================================================================");
                log.debug("    setCntrMvntDtlsVOs retrieve list.                           ");
                log.debug("===================================================================");
            	List<CntrSoDtlVO> cntrSoDtlVOs = dbDao.searchCntrSoDtlInfo(retBkgNo);
    	        soVO.setCntrSoDtlVOs(cntrSoDtlVOs);

                log.debug("*********** setCntrMvntDtlsVOs ***************");

            	
            	// TP/SZ QTY retrieve list.
                log.debug("===================================================================");
                log.debug("    TP/SZ QTY retrieve list.                                    ");
                log.debug("===================================================================");

                List<TpszQtyVO> tpszQtyVOs = dbDao.searchQtyForCntrByTpsz(retBkgNo);
                soVO.setTpszQtyVOs(tpszQtyVOs);

                // retrieve basic Reference Info
                log.debug("============================================================");
                log.debug("    retrieve basic Reference Info      ");
                log.debug("============================================================");

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
	 * check booking Status.<br>
	 * 
	 * @author
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
     * retrieve event process.<br>
     * retrieve B/L Info of UI_BKG_0668. 
     * 
     * @author
     * @param String bkgNo Booking No.
     * @param SignOnUserAccount account
     * @return BlInfoVO
     * @exception EventException
     */
    public BlInfoVO searchUsBlInfo(String bkgNo, SignOnUserAccount account) throws EventException {

        BlInfoVO blInfoVO = new BlInfoVO();
        String retBkgNo = bkgNo;
        
        try {

            // check Booking Status
            log.debug("===================================================================");
            log.debug("    check Booking Status                                      ");
            log.debug("===================================================================");

            String bkgStsCd = validateBkgSts(retBkgNo);
            
            log.debug("    check Booking Status ===> " + bkgStsCd);
        	        	
	            	
            // retrieve basic Reference Info
            log.debug("============================================================");
            log.debug("    retrieve basic Reference Info      ");
            log.debug("============================================================");

            BlInfosVO blInfosVO = dbDao.searchBlInfo(retBkgNo);
            blInfoVO.setBlInfosVO(blInfosVO);
            
            if(blInfosVO != null){
            	UsBlInfosVO usBlInfosVO = new UsBlInfosVO();
            	ObjectCloner.build(blInfosVO, usBlInfosVO);
            	blInfoVO.setUsBlInfosVO(usBlInfosVO);
            	
            	// searchUsCstmsRef retrieve
                log.debug("===================================================================");
                log.debug("    searchUsCstmsRef retrieve.                                     ");
                log.debug("===================================================================");
                UsCstmsRefInfoVO usCstmsRefVO = dbDao.searchUsCstmsRefInfo(retBkgNo);
	            blInfoVO.setUsCstmsRefVO(usCstmsRefVO);

	            //blInfosVO and usCstmsRefVO merge              
	            if (blInfoVO.getUsCstmsRefVO() != null) {
	            	ObjectCloner.build(usCstmsRefVO, usBlInfosVO);
	            	  
	            	blInfoVO.setUsBlInfosVO(usBlInfosVO);
	            }	            
	            
	            // TP/SZ QTY retrieve list.
                log.debug("===================================================================");
                log.debug("    TP/SZ QTY retrieve list.                                    ");
                log.debug("===================================================================");

                List<TpszQtyVO> tpszQtyVOs = dbDao.searchQtyForCntrByTpsz(retBkgNo);
                blInfoVO.setTpszQtyVOs(tpszQtyVOs);

	            // Customs Clear retrieve Info.
                log.debug("===================================================================");
                log.debug("    Customs Clear retrieve Info.                                  ");
                log.debug("===================================================================");
                CstmsClearInfoVO cstmsClearInfoVO = dbDao.searchCstmsClearInfo(retBkgNo);
                blInfoVO.setCstmsClearInfoVO(cstmsClearInfoVO);
                
                //blInfosVO and cstmsClearInfoVO merge
	            if (blInfoVO.getCstmsClearInfoVO() != null) {
	            	ObjectCloner.build(cstmsClearInfoVO, usBlInfosVO);
	            	  
	            	blInfoVO.setUsBlInfosVO(usBlInfosVO);
	            }	            
                
                
	            log.debug("=========================================================================");
	            log.debug("    retrieve Office Info for search Outstanding Amounts                  ");
	            log.debug("=========================================================================");

	            UsFreigtInfoVO usFreigtInfoVO = dbDao.searchUsFrgightInfo(retBkgNo);
                blInfoVO.setUsFreigtInfoVO(usFreigtInfoVO);

                //blInfosVO and usFreigtInfoVO merge
	            if (blInfoVO.getUsFreigtInfoVO() != null) {
	            	ObjectCloner.build(usFreigtInfoVO, usBlInfosVO);
	            	  
	            	blInfoVO.setUsBlInfosVO(usBlInfosVO);
	            }	   
	            
	            OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
	            log.debug("Call EAIDAO for ERP I/F");
	            otsRcvInfoVO = this.searchErpOtsInfo(blInfosVO.getBlNo());
	            blInfoVO.setOtsRcvInfoVO(otsRcvInfoVO);

                //blInfosVO and otsRcvInfoVO merge
	            if (blInfoVO.getOtsRcvInfoVO() != null) {
	            	ObjectCloner.build(otsRcvInfoVO, usBlInfosVO);
	            	  
	            	blInfoVO.setUsBlInfosVO(usBlInfosVO);
	            }	   
	            
	            // retrieve sending history by Container P/N in the In-bound US C/S Screen_Main_US.
                log.debug("===================================================================");
                log.debug(" retrieve sending history by Container P/N in the In-bound US C/S Screen_Main_US. ");
                log.debug("===================================================================");

                List<CntrPkupNtcInfoVO> cntrPkupNtcInfoVO = dbDao.searchUsCntrInfo(retBkgNo, account.getOfc_cd());
                blInfoVO.setCntrPkupNtcInfoVOs(cntrPkupNtcInfoVO);
                
                // retrieve in the BKG_CONTAINER table.
	            log.debug("===================================================================");
	            log.debug("    retrieve in the BKG_CONTAINER table.                           ");
	            log.debug("===================================================================");			
	            List<CntrInfoVO> cntrInfoVOs = dbDao.searchCntrInfo(retBkgNo, blInfosVO.getBkgCgoTpCd(), blInfosVO.getBbCgoFlg());
	            blInfoVO.setCntrInfoVOs(cntrInfoVOs);
	            
	            log.debug("==================================================================");
	            log.debug("    Retrieve Container Number for DEM.DET I/F                     ");
	            log.debug("==================================================================");
	            String[] cntrs = dbCargo.searchDemDetCntrList(retBkgNo);
	            blInfoVO.setCntrs(cntrs);
	
	            // retrieve CNTR_SEAL_NO by join BKG_CONTAINER and BKG_CNTR_SEAL_NO.
	            log.debug("===================================================================");
	            log.debug(" retrieve CNTR_SEAL_NO by join BKG_CONTAINER and BKG_CNTR_SEAL_NO. ");
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
     * retrieve event process.<br>
     * retrieve Customs Result of ESM_BKG_0668_5.
     * 
     * @author
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
    		log.debug("    check Booking Status ===> " + bkgStsCd);
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
	 * Movement retrieve event process..<br>
	 * 
	 * @author
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

            // check Booking Status
            log.debug("===================================================================");
            log.debug("    check Booking Status                                      ");
            log.debug("===================================================================");

            bkgStsCd = validateBkgSts(retBkgNo);
            log.debug("    check Booking Status ===> " + bkgStsCd);
			
        	List<CntrMvntMstsVO> cntrMvntMstsVOs = dbDao.searchCntrMvntMstInfo(retBkgNo);
            cntrMvntVO.setCntrMvntMstsVOs(cntrMvntMstsVOs);

            log.debug("*********** setCntrMvntMstsVOs ***************");
            
            if(cntrMvntMstsVOs != null){
            	
            	// retrieve first cntrNo and returing.
            	// if have not cntrNo, not retrieve.
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


                // retrieve basic Reference Info
                log.debug("============================================================");
                log.debug("    retrieve basic Reference Info      ");
                log.debug("============================================================");

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
	 * retrieve CLM List.
	 * 
	 * @author
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
	 * retrieve event process.<br>
	 * retrieve B/L list by Container No.
	 * 
	 * @author
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
	 * BKG Common UTIL <br>
	 * retrieve B/L list by P.O no.
	 *  
	 * @author
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
	 * retrieve event process.<br>
	 * retrieve BKG No by HB/L no.
	 * 
	 * @author
	 * @param String hblNo H.B/L No.
	 * @return List<BkgBlInfosVO>
	 * @exception EventException
	 */
	public  List<BkgBlInfosVO> searchBlListByHblNo (String hblNo) throws EventException {
		try {
			return dbDao.searchBlListByHblNo(hblNo);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
	}

	/**
	 * retrieve event process.<br>
	 * retrieve SPLIT B/L No by BKG No.
	 *
	 * @author
	 * @param String bkgNo Booking No.
	 * @return List<BkgBlInfosVO>
	 * @exception EventException
	 */
	public  List<BkgBlInfosVO> searchBlListByBkgSplit (String bkgNo) throws EventException {
		try {
			return dbDao.searchBlListByBkgSplit(bkgNo);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
	}
	
	/**
	 * retrieve Arrival Notice and B/L Copy sending list for dealing with customers. 
	 * 
	 * @author
	 * @param String bkgNo Booking No.
     * @param SignOnUserAccount account
	 * @return ArrNtcInfoVO
	 * @exception EventException
	 */
	public ArrNtcInfoVO searchUsArrNtcInfo (String bkgNo, SignOnUserAccount account) throws EventException {
		ArrNtcInfoVO arrNtcInfoVO = new ArrNtcInfoVO();

		String bkgStsCd = null;
		
		try {

            // check Booking Status
            log.debug("===================================================================");
            log.debug("    check Booking Status                                      ");
            log.debug("===================================================================");

            bkgStsCd = validateBkgSts(bkgNo);
            log.debug("    check Booking Status ===> " + bkgStsCd);
			
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
                

                // retrieve basic Reference Info
                log.debug("============================================================");
                log.debug("    retrieve basic Reference Info      ");
                log.debug("============================================================");

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

	/**
	 * send P/N by Email of group B/L
	 * 
	 * @author
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return PkupNtcInfoVO
	 * @exception EventException
	 */
	public PkupNtcInfoVO searchPkupNtcInfo (String bkgNo, SignOnUserAccount account) throws EventException {
		PkupNtcInfoVO pkupNtcInfoVO = new PkupNtcInfoVO();

		String bkgStsCd = null;
		
		try {

            // check Booking Status
            log.debug("===================================================================");
            log.debug("    check Booking Status                                      ");
            log.debug("===================================================================");

            bkgStsCd = validateBkgSts(bkgNo);
            log.debug("    check Booking Status ===> " + bkgStsCd);
			
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
                

                // retrieve basic Reference Info
                log.debug("============================================================");
                log.debug("    retrieve basic Reference Info      ");
                log.debug("============================================================");

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
	 * Retrieving List about American Inbound Cargo Release by Item
	 * 
	 * @author
	 * @param String bkgNo Booking No.
	 * @return BkgInfoVO
	 * @exception EventException
	 */
	public BlInfoVO searchUsCgoRlseInfo (String bkgNo) throws EventException {
		
		BlInfoVO blInfoVO = new BlInfoVO();
		
		String retBkgNo = bkgNo;
		String bkgStsCd = null;

		
		try {

            // check Booking Status
            log.debug("===================================================================");
            log.debug("    check Booking Status                                      ");
            log.debug("===================================================================");

            bkgStsCd = validateBkgSts(retBkgNo);
            log.debug("    check Booking Status ===> " + bkgStsCd);
			
            // retrieve basic Reference Info
            log.debug("============================================================");
            log.debug("    retrieve basic Reference Info      ");
            log.debug("============================================================");

            BlInfosVO blInfo = dbDao.searchBlInfo(bkgNo);
//            if(blInfo != null){
            if(blInfo.getMaxRows() > 0){
                
            	log.debug("PODCD : " + blInfo.getPodCd());
            	
                if(!blInfo.getPodCd().substring(0,2).equals("US")){
                    String[] msg = new String[]{blInfo.getPodCd()};
                    throw new EventException(new ErrorHandler("BKG40091", msg).getMessage());
                    //You can't handle this B/L Because the Port of Discharging is [$s]
                }
            	
            }
            
            blInfoVO.setBlInfosVO(blInfo);
            
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
     * retrieve event process.<br>
     * retrieve Top B/L Info
     * 
     * @author
     * @param String bkgNo Booking No.
     * @return TopBlInfoVO
     * @exception EventException
     */
    public TopBlInfoVO searchTopBlInfo(String bkgNo) throws EventException {

    	TopBlInfoVO blInfoVO = new TopBlInfoVO();

        String bkgStsCd        = null;
        String retBkgNo        = bkgNo;
        
        try {
            // check Booking Status
            log.debug("===================================================================");
            log.debug("    check Booking Status                                      ");
            log.debug("===================================================================");

            bkgStsCd = validateBkgSts(retBkgNo);
            log.debug("    check Booking Status ===> " + bkgStsCd);
            	
            // retrieve basic Reference Info
            log.debug("============================================================");
            log.debug("    retrieve basic Reference Info      ");
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
	 * retrieve Arrival Notice and B/L Copy sending list for dealing with customers. 
	 * 
	 * @author
	 * @param String bkgNo Booking No.
	 * @param SignOnUserAccount account
	 * @return ArrNtcInfoVO
	 * @exception EventException
	 */
	public  ArrNtcInfoVO searchArrNtcInfo (String bkgNo, SignOnUserAccount account) throws EventException {
		ArrNtcInfoVO arrNtcInfoVO = new ArrNtcInfoVO();

		String bkgStsCd = null;
		
		try {

            // check Booking Status
            log.debug("===================================================================");
            log.debug("    check Booking Status                                      ");
            log.debug("===================================================================");

            bkgStsCd = validateBkgSts(bkgNo);
            log.debug("    check Booking Status ===> " + bkgStsCd);
			
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
                

                // retrieve basic Reference Info
                log.debug("============================================================");
                log.debug("    retrieve basic Reference Info      ");
                log.debug("============================================================");

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
     * Call EAIDAO for ERP I/F
     *
     * @author
     * @param String blNo
     * @return OtsRcvInfoVO
     * @exception EventException
     */
    public OtsRcvInfoVO searchErpOtsInfo(String blNo) throws EventException {
        OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
        try {
            log.debug("Call EAIDAO for ERP I/F");            
            otsRcvInfoVO = dbCargo.searchOtsInfo(blNo);
            
            
            log.debug("------------------- otsRcvInfoVO " + otsRcvInfoVO.getColumnValues());
            if(otsRcvInfoVO.getTotOtsAmt1() == null 
            		|| otsRcvInfoVO.getTotOtsAmt1().trim().equals("")
            		|| otsRcvInfoVO.getTotOtsStsCd() == null
            		|| otsRcvInfoVO.getTotOtsStsCd().trim().equals("")
            		){
            	otsRcvInfoVO.setTotOtsStsCd("");            
                otsRcvInfoVO.setTotOtsAmt1("N/A");
            }
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            otsRcvInfoVO.setTotOtsStsCd("");            
            otsRcvInfoVO.setTotOtsAmt1("ERP I/F Error");
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            otsRcvInfoVO.setTotOtsStsCd("");            
            otsRcvInfoVO.setTotOtsAmt1("ERP I/F Error");
        }
        return otsRcvInfoVO;
   }
    
    /**
	 * retrieve Remark.
	 * 
	 * @author
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
	 * create Remark.
	 *
	 * @author
	 * @param UsCustSvcInstrsVO usCustSvcInstrs
	 * @exception EventException
	 */
	public void createUsCustSvcInstr(UsCustSvcInstrsVO usCustSvcInstrs) throws EventException{
		try{

			dbDao.addUsCustSvcInstr(usCustSvcInstrs);		
			
		}catch (DAOException de) {
            // BKG00110 : Fail (Insert, Modify, Delete)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : Fail (Insert, Modify, Delete)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
		//}
	}	

	/**
	 * delete Remark.
	 * 
	 * @author
	 * @param UsCustSvcInstrsVO usCustSvcInstrs
	 * @exception EventException
	 */
	public void removeUsCustSvcInstr(UsCustSvcInstrsVO usCustSvcInstrs) throws EventException{
		try{

			dbDao.removeUsCustSvcInstr(usCustSvcInstrs);		
			
		}catch (DAOException de) {
            // BKG00110 : Fail (Insert, Modify, Delete)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : Fail (Insert, Modify, Delete)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
		//}
	}	
	
}