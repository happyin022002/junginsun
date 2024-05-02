/*=========================================================
*Copyright(c) 20006 CyberLogitec
*@FileName : COPManageBCImpl.java
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 20006-08-29
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 20006-08-29 Seong-mun Kang
* 1.0 최초 생성
* 20009.02.26 - 안정선 - CSR NO. N20009020300014 COP Inquiry 화면과 COP Summary 화면을 하나의 화면으로 통합
* 2009.09.03 - 오현경  - NIS2010 Construction
* 2010.11.01 김진승 [소스품질 보완] searchCOPDetail throw 보완; 불필요 주석 정리; 
* 2010.12.15 김영철 [] IRG상 BKG&Temp Flag 적용
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.basic;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.EsdSce0006Event;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration.COPSearchDBDAO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.BookingInfoVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.COPDetailVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.COPInquiryVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.COPReplanInfoVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchActualInfoVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchCOPDetailDtInfoVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchCOPMainListVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchSCInfoVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchSOCostInfoVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchSceCopHdrInfoVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchTargetCOPInfoListVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchTransportationInfoVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0151Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwllNtfcSrchVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ENIS-SCE Business Logic Basic Command implementation<br>
 * - ENIS-SCE에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Seong-mun Kang
 * @see EsdSce0001EventResponse , COPManageBC 각 DAO 클래스 참조 
 * @since J2EE 1.4
 */
public class COPSearchBCImpl   extends BasicCommandSupport implements COPSearchBC {

    // Database Access Object
    private transient COPSearchDBDAO dbDao = null;

    /**
     * COPManageBCImpl 객체 생성<br>
     * COPManageDBDAO를 생성한다.<br>
     */
    public COPSearchBCImpl(){
        dbDao = new COPSearchDBDAO();
    }

    /**
     * 조회 이벤트 처리<br>
     * COP Main 조회 이벤트 처리<br>
     *
     * @param COPInquiryVO inqVO
     * @return List<SearchCOPMainListVO>
     * @throws EventException ... 
     */
    public List<SearchCOPMainListVO>  searchCOPMainList(COPInquiryVO inqVO) throws EventException {
    	
        List<SearchCOPMainListVO> list = null;
        try {

        	log.debug("\n COPSearchBCImpl");
        	// 검색 리스트
            list = dbDao.searchCOPMainList(inqVO);
       
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
	    }catch (Exception de) {
	    	log.error(de.getMessage(), de);
	    	throw new EventException(de.getMessage());
	    }
	    return list;
    }
    

	/**
     * COP Inquiry S/O 유무 확인
     * 
     * @param COPInquiryVO inqVO
     * @return List<SearchSceCopHdrInfoVO>
     * @throws EventException ... 
     */
	public List<SearchSceCopHdrInfoVO> searchSceCopHdrInfo(COPInquiryVO inqVO) throws EventException{
		//DBRowSet rowSet = null;
		List<SearchSceCopHdrInfoVO> list = null;
		try{
			list = dbDao.searchSceCopHdrInfo(inqVO);
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
		return list;
	}

    /**
     * Search Master S/O 여부 조회
     * 
     * @param COPInquiryVO inqVO
     * @return List<SearchSCInfoVO>
     * @throws EventException ...
     */
	public List<SearchSCInfoVO> searchSCInfo(COPInquiryVO inqVO) throws EventException{
		List<SearchSCInfoVO> list = null;

		try{
			list = dbDao.searchSCInfo(inqVO); 
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
		return list;
	}
    
	/**
     * SCE_COP_HDR Update
     * 
     * @param COPInquiryVO inqVO
     * @throws EventException ... 
     */
	public void modifyPCopHdr(COPInquiryVO inqVO) throws EventException{
		try{
			dbDao.modifyPCopHdr(inqVO);
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}	
	
	/**
     * trs_trsp_rail_bil_ord,trs_trsp_svc_ord Update
     * 
     * @param SearchSCInfoVO inqVO
     * @throws EventException ... 
     */
	public void modifyTrsRailSvcOrd(SearchSCInfoVO inqVO) throws EventException{
		try{
			dbDao.modifyTrsRailSvcOrd(inqVO);
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}	
	
	/**
     * SCE_COP_HDR Update
     * @param COPInquiryVO inqVO
     * @throws EventException ... 
     */
	public void modifyCopHdr(COPInquiryVO inqVO) throws EventException{
		try{
			dbDao.modifyCopHdr(inqVO);
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
	
   /**
   * sce_cop_log insert
   * 
   * @param inqVO COPInquiryVO 
   * @exception EventException ... 
   */
	public void addSceCopHis(COPInquiryVO inqVO)throws EventException{
		try{
			dbDao.addSceCopHis(inqVO);
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}	
	
    /*============================================= 박세훈 =========================================================*/
    /**
     * BKG Detail 조회 이벤트 처리<br>
     *
     * @param inqVO COPInquiryVO 
     * @return List
     * @throws EventException ...
     */
     @SuppressWarnings("unchecked")
	public List searchBookingDetail(COPInquiryVO inqVO) throws EventException {
 	     DBRowSet rowSet		= null;
    	 List<Object> returnList = new ArrayList<Object>();
    	 List<BookingInfoVO> listVVD = null;
    	 
 	     try {
 	    	rowSet		 = dbDao.searchBookingAllDetail(inqVO);
 	    	listVVD 	 = dbDao.searchBookingVVDDetail(inqVO);

 	     } catch (DAOException de) {
 	         log.error("err "+de.toString(),de);
 	         throw new EventException(de.getMessage());
 	     }
 	     
		returnList.add(0, rowSet);
		returnList.add(1, listVVD);
		return returnList;
     }
	
 	/** 
 	 * COP Sub Status Change.
 	 * @param mainListVOs SearchCOPMainListVO[] 
 	 * @throws EventException ... 
 	 */
 	public void modifyCOPStatusChange(SearchCOPMainListVO[] mainListVOs) throws EventException {
 		try {
 			// history관리 기능 포함 (08 03 19)
 			if(mainListVOs != null){
 				for(int i=0; i<mainListVOs.length; i++){
 					String copSubStsCd = "";
 					if( "Y".equals(mainListVOs[i].getCopSubStsCd()) ) {
 						copSubStsCd = "R";
 					}else{
 						copSubStsCd = "";
 					}
 					// status change
 					dbDao.modifyCOPStatusChange(mainListVOs[i].getRCopNo(), copSubStsCd);
 					
 					//history 
 		 			COPInquiryVO histVO = new COPInquiryVO (); 	
 		 			histVO.setNewCopNo(mainListVOs[i].getRCopNo());
 		 			histVO.setUsrId(mainListVOs[i].getCreUsrId());
 		 			histVO.setBkgEventTpCd("SC");
 		 			dbDao.addSceCopHis(histVO);
 				}
 			}
       
 		} catch (DAOException de) {
 			log.error("err "+de.toString(),de);
 			throw new EventException(de.getMessage());
 		}
 	}     
	/*============================================= 강성문 =========================================================*/

    /**
     * 조회 이벤트 처리<br>
     * Booking List 조회 이벤트 처리<br>
     *
     * @param COPDetailVO inqVO
     * @return List<SearchSceCopHdrInfoVO>
     * @throws EventException ... 
     */
    public  List<SearchSceCopHdrInfoVO> searchBookingList(COPDetailVO inqVO) throws EventException {
		List<SearchSceCopHdrInfoVO> list = null;        
        try {
        	list = dbDao.searchBookingList(inqVO);
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
        return list;
    }

    /**
     * 현재 진행중인 detail 정보를 구한다.<br>
     * CSHA9917655412
     * @param inqVOs COPReplanInfoVO[] 
     * @param inqVO COPReplanInfoVO 
     * @return String[]
     * @throws EventException ... 
     */
    public String[] searchCopCurrentInfo(COPReplanInfoVO[] inqVOs, COPReplanInfoVO inqVO) throws EventException {
    
        String frmtoNumArray[] = {"","","","",""};
        
        //prd call 
        String copno   = "" ;
        String ioBndCd = "" ;
        String newNod  = "" ;
        String creUsrId= "TEST" ;

        try {
        	copno = inqVO.getCopNo();//event.getSCE_COP_HDR_INFO().getCop_no();
        	
        	log.debug(  "\n getIscompled    : " + inqVO.getIscompled()+
			        	"\n getBound_name   : " + inqVO.getBoundName()+
			        	"\n ++ Planned Route Only ++"+
			        	"\n getIsnodchg     : " + inqVO.getIsnodchg()+
			        	"\n getNodcd        : " + inqVO.getNodcd()+
			        	"\n ++ Include Completed Route ++"+
			        	"\n getIsfrmchg     : " + inqVO.getIsfrmchg()+
			        	"\n getFrmcd        : " + inqVO.getFrmcd()+
			        	"\n ");

        	if(inqVO.getIscompled().equals("N")){ // Planned Route Only 버튼 체크
        		
        		ioBndCd = dbDao.searchCopCurrentBound(copno);
        		newNod  = inqVO.getNodcd();
        		
        	}else{ // Include Completed Route 버튼 체크
        		
        		log.debug("\n Include Completed Route 버튼 체크 ");
        		ioBndCd = inqVO.getBoundName();
        		newNod  = inqVO.getFrmcd();
        		
        	}

			frmtoNumArray[0] = copno;
			frmtoNumArray[1] = ioBndCd;
			frmtoNumArray[2] = newNod;        	
			frmtoNumArray[3] = creUsrId;			
			
            return frmtoNumArray;

        }  catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }catch (Exception de) {
        	log.error(de.getMessage(), de);
        	throw new EventException(de.getMessage());
        }
    }

    /**
     * COP Detail 조회 이벤트 처리<br>
     *
     * @param COPDetailVO inqVO
     * @return GeneralEventResponse
     * @throws EventException ...
     */
    public GeneralEventResponse searchCOPDetail(COPDetailVO inqVO) throws EventException {
        //Collection       models   = null;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        //SEARCHLIST01
        List<SearchTransportationInfoVO> transList = null; 
        List<SearchCOPDetailDtInfoVO> dtList = null;      
        //SEARCHLIST03
        DBRowSet soCostInfoList = null;  
        //SEARCHLIST04
        List<SearchActualInfoVO> actualInfoList = null;      	
    	
        try {
        	// command
        	int command = Integer.parseInt(inqVO.getFCmd()) ;

        	// 헤더와 Transportation 탭 검색인경우
        	if(command==FormCommand.SEARCHLIST01){
    			transList = dbDao.searchTransportationInfo(inqVO) ;
    			dtList = dbDao.searchCOPDetailDtInfo(inqVO);
    			if(dtList != null && dtList.size() > 0){
    				SearchCOPDetailDtInfoVO etcVO = (SearchCOPDetailDtInfoVO)dtList.get(0);
    				Map<String, String> mapVO = etcVO.getColumnValues();
    				eventResponse.setETCData(mapVO);
    			}
    	    	eventResponse.setRsVoList(transList);	
        	}

        	//S/O Cost 탭
        	else if(command==FormCommand.SEARCHLIST03){
        		 soCostInfoList = dbDao.searchSOCostInfo(inqVO);
     	    	eventResponse.setRs(soCostInfoList);        		 
        	}

//        	Actual Information 탭
        	else if(command==FormCommand.SEARCHLIST04){
        		actualInfoList = dbDao.searchActualInfo(inqVO);
     	    	eventResponse.setRsVoList(actualInfoList);        		
        	}

        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
		}

        return eventResponse;
    }

     /*============================================= 김창규 코딩 시작 =========================================================*/

     /**
      * Target COP Infomation 조회 이벤트 처리<br>
      *
      * @param COPReplanInfoVO inqVO
      * @return List<SearchTargetCOPInfoListVO>
      * @throws EventException ... 
      */
     public  List<SearchTargetCOPInfoListVO> searchTargetCOPInfoList(COPReplanInfoVO inqVO) throws EventException {
    	 List<SearchTargetCOPInfoListVO> list = null;    	 
 	 	try {
         	// 검색 리스트
 	 		list = dbDao.searchTargetCOPInfoList(inqVO);
 	 	 } catch (DAOException de) {
        	 log.error("err "+de.toString(),de);
             throw new EventException(de.getMessage());
         }
 	 	 return list;
     }
     
     /**
      * Target PC Infomation 조회 이벤트 처리<br>
      *
      * @param inqVOs COPReplanInfoVO[] 
      * @param inqVO COPReplanInfoVO 
      * @param frmtoNum String[] 
      * @return GeneralEventResponse
      * @throws EventException ...
      */
     public GeneralEventResponse  searchTargetPCInfoList(COPReplanInfoVO[] inqVOs, COPReplanInfoVO inqVO, String[] frmtoNum) throws EventException {
     	GeneralEventResponse eventResponse = new GeneralEventResponse();    	 

		List<SearchTargetCOPInfoListVO> list = null;
 	 	try {
 	 		String paramPctlNo = frmtoNum[0];
 	 		String copNo = frmtoNum[1];
 	 	 	String ioBndCd = frmtoNum[2];
 	 	 	String new_nod = frmtoNum[3];

 	 	 	int colCnt = 0;
 	 		if(!paramPctlNo.equals("") && paramPctlNo.length() > 0){
 	 			inqVO.setPctlNo(paramPctlNo);
 	 			inqVO.setIoBndCd(ioBndCd);
 	 			inqVO.setCopNo(copNo);
 	 			list = dbDao.searchTargetCOPInfoList2(inqVO);
 	 			colCnt = dbDao.searchTargetCOPInfoList2Cnt(inqVO);
 	 		}else{
 	 			log.info("\n @@@@@@@@@@@@@@@@@@@ pctlNo 확인할 것 "); 	 			
 	 			throw new DAOException(new ErrorHandler("SCE00031").getMessage());
 	 		}
 	 		
 	 		 
            if (list == null || list.size() == 0) {
            	// so 로 인해 pc 가 생성되지 않았는지 조회?
            	if (dbDao.searchSOExistence(copNo) && !dbDao.searchValidSOByCopNo(copNo, ioBndCd, new_nod))
            		throw new EventException(new ErrorHandler("SCE00052").getMessage());
            }

 	 		int rowSize = list != null ? list.size() : 0;
 	 		int colSize = ((colCnt * 2) + 1) + 3 + 1 + 1 ; // 2008-06-20 Combined Flag 추가 때문에 마지막에 +1 

 	 		String dataSet[][] = new String[rowSize][colSize];
 	 		String pctlNo       = "";
 	 		String orgNodCd     = "";
 	 		String[] orgNodArry = null;
 	 		String estDlvTm     = "";
 	 		String estTotCost   = "";
 	 		int itemCnt = 0;
 	 		int itemMaxCnt = 0;
 	 		String inlndRoutCmgFlg = ""; // 2008-06-20 Combined Flag 추가
 	 		String inlndRoutTmpFlg = ""; // 2010-12-15 Tmp Flag 추가

 	 		String[] tmpOrgNodArry = null;

 	 		for(int i=0; i < rowSize; i++) {
 	 			SearchTargetCOPInfoListVO vo = (SearchTargetCOPInfoListVO)list.get(i);

 	 			pctlNo     = vo.getPctlNo();//row[0];
 	 			orgNodCd   = vo.getOrgNodCdVal();//row[1]; //node정보
 	 			estDlvTm   = vo.getEstDlvTm();//row[2];
 	 			estTotCost = vo.getEstTotCost();//row[3];
 	 			itemCnt    = Integer.parseInt(vo.getItemCnt());
 	 			itemMaxCnt = Integer.parseInt(vo.getItemMaxCnt());
 	 			inlndRoutCmgFlg = vo.getInlndRoutCmbFlg();
 	 			inlndRoutTmpFlg = vo.getInlndRoutTmpFlg();
 	 			 
 	 			tmpOrgNodArry = orgNodCd.split("/");
 	 			orgNodArry = new String[itemMaxCnt];

 	 			for(int m=0; m < itemMaxCnt; m++) {
 	 				if(m < itemCnt) {
 	 					orgNodArry[m] = tmpOrgNodArry[m];
 	 				} else {
 	 					orgNodArry[m] = "";
 	 				}
 	 			}

 	 			for(int j=0; j < colSize; j++) {
 	 				
 	 				if(j == 0) {
 	 					dataSet[i][j] = pctlNo;
 	 				} else if(j > 0 && j < colSize - 4) {
 	 					dataSet[i][j] = orgNodArry[j-1];
 	 				} else if(j == colSize - 4) {
 	 					dataSet[i][j] = estDlvTm;
 	 				} else if(j == colSize - 3) {
 	 					dataSet[i][j] = estTotCost;
 	 				} else if(j == colSize - 2) {
 	 					dataSet[i][j] = inlndRoutCmgFlg; // 2008-06-20 Combined Flag 추가
 	 				} else if(j == colSize - 1) {
 	 					dataSet[i][j] = inlndRoutTmpFlg; // 2010.12.15 Tmp Flag 추가
 	 				}
 	 				
 	 			}
 	 		}
	    	
			Map<String, String> mapVO = new HashMap<String, String>(); 	
			mapVO.put("max_cnt", new Integer(colCnt).toString());
			mapVO.put("io_bnd_Cd", ioBndCd);			
			eventResponse.setETCData(mapVO);
			
			eventResponse.setCustomData("list", dataSet);

 	 	 } catch (DAOException de) {
        	 log.error("err "+de.toString(),de);
             throw new EventException(de.getMessage());
         }
 	 	 return eventResponse;
     }

 	/** get MT node
 	 * @param String cop_no
 	 * @param String ioBndCd
 	 * @return String
 	 * @throws EventException ... 
 	 */
 	public String getMTNode(String cop_no, String ioBndCd) throws EventException{
 		String mtNode = "";
 		try {
 			mtNode = dbDao.getMTNode(cop_no, ioBndCd);
 		} catch (DAOException de) {
         	log.error(de.getMessage(), de);
             throw new EventException(de.getMessage());
         } catch (Exception e) {
         	log.error(e.getMessage(), e);
             throw new EventException(e.getMessage());
         }
         return mtNode;
 	}
 	
 	/** TRS S/O Candidate Creation
 	 * @throws EventException ... 
 	 */
 	public EventResponse modifyTRSSoCnddtCreation(Event e) throws EventException{
 		try{			
 			
 			EsdSce0006Event event=(EsdSce0006Event)e;
 			SearchSOCostInfoVO[] models = event.getSearchSOCostInfoVOs();
 			
 			for(int i=0; i<models.length; i++){
 				dbDao.modifyTRSSoCnddtCreation(models[i]);
 			}
 			
            return null;
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
 	}


 	
     /*============================================= 김창규 코딩 종료 =========================================================*/
}
