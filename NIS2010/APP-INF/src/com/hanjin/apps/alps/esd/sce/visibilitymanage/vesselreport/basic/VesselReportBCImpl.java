 /*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : VesselReportBCImpl.java
*@FileTitle : Vessel Report BC Impl
*Open Issues :
*Change history :
*@LastModifyDate : 2007-07-23
*@LastModifier : Jeong-Seon An , Yoon-Jung Lee
*@LastVersion : 1.0
* 2007-07-23 Jeong-Seon An , Yoon-Jung Lee
* 2007-08-17 Jeong-Seon An , Yoon-Jung Lee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.integration.VesselReportDBDAO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.vo.SearchUSIORInfoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.vo.SearchUSIORListVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ENIS-SCEM Commission Business Logic Basic Command implementation<br>
 * - ENIS-SCEM Commission에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Jeong-Seon An , Yoon-Jung Lee
 * @see EsdSce0056EventResponse,ManageUserBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class VesselReportBCImpl extends BasicCommandSupport implements VesselReportBC {

//     Database Access Object
//    private transient RailTransitReportDBDAO dbDao=null;
	private transient VesselReportDBDAO dbDao=null;

    /**
     * RailTransitReportBCImpl 객체 생성<br>
     * RailTransitReportDBDAO를 생성한다.<br>
     */
    public VesselReportBCImpl(){
        dbDao = new VesselReportDBDAO();
    }
    
// 20080923 미사용table관련 정리
//    /**
//     * Vessel Report
//     * 
//     * @param e EsdSce0056Event
//     * @return eventResponse EsdSce0056EventResponse
//     * @throws EventException
//     */
//    public EventResponse searchVORList(EsdSce0056Event event) throws EventException {
//    	RequestDataSetBC         dataSet       = event.getDataSet() ;
//    	EsdSce0056EventResponse eventResponse = null ;
//    	DBRowSet                 rowSet        = null ;
//    	int                      totCnt        = 0 ;
//    	
//    	try {
//			//20070612
////    		totCnt = dbDao.searchVORCount(dataSet) ;
////			rowSet = dbDao.searchVORList(dataSet) ;
//
//    		totCnt = dbDao.searchReportCount(dataSet) ;
//			rowSet = dbDao.searchReportList(dataSet) ;    		
//
//			eventResponse = new EsdSce0056EventResponse(rowSet, totCnt) ; 
//			
//		} catch (DAOException de) {
//			log.error(de.toString(),de);
//            throw new EventException(de.getMessage());
//		}
//    	
//		return eventResponse;
//	}
        
//    /**
//     * US INLAND OPERATION REPORT
//     * 
//     * @param e EsdSce0056Event
//     * @return eventResponse EsdSce0056EventResponse
//     * @throws EventException
//     */
//    public EventResponse searchUSIORListOLD(EsdSce0056Event event) throws EventException {
//    	RequestDataSetBC         dataSet       = event.getDataSet() ;
//    	
//    	EsdSce0056EventResponse eventResponse = null ;
//    	DBRowSet                 rowSet        = null ;
//    	int                      totCnt        = 0 ;
//    	String                   getTotal      = event.getCountFlag();
//    	String                   getList       = event.getListFlag();
//    	
//    	try {
//			//20070612
////    		totCnt = dbDao.searchVORCount(dataSet) ;
////			rowSet = dbDao.searchVORList(dataSet) ;
//    		log.debug("\n 여기는 bc-searchUSIORList \n");
//    		log.debug("\n getTotal "+getTotal);
//    		log.debug("\n getList "+getList);
//    		eventResponse = new EsdSce0056EventResponse();
//    		if("Y".equals(getTotal)){
//    			totCnt = dbDao.searchUSIORCount(dataSet, event.getLoginOffice()) ;
//    			//event.setTotalRows(totCnt);
//    			eventResponse.setTotCnt(totCnt);
//    		}else if("Y".equals(getList)){
//    			rowSet = dbDao.searchUSIORList(dataSet, event.getLoginOffice()) ;
//    			//totCnt = rowSet.getRowCount();
//    			eventResponse.setRowSet(rowSet);
//    		}
//
//			//eventResponse = new EsdSce0056EventResponse(rowSet, totCnt) ; 
//			
//		} catch (DAOException de) {
//			log.error(de.toString(),de);
//            throw new EventException(de.getMessage());
//		}
//    	
//		return eventResponse;
//	}
        

    /**
     * US INLAND OPERATION REPORT
     * 
     * @param SearchUSIORInfoVO usiorInfo
     * @param String ofcCd
     * @return List<SearchUSIORListVO>
     * @throws EventException
     */
    public DBRowSet searchUSIORList(SearchUSIORInfoVO usiorInfo, String ofcCd) throws EventException {
    	log.debug("searchUSIORList Start!! ");
    	
    	try {
    		return dbDao.searchUSIORList(usiorInfo, ofcCd) ;
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
    
    /**
     * 조회조건(combo)을 위한 West Cost, East Cost에 따른 Location 조회.
     * 
     * @param String costDiv
     * @return List<SearchUSIORListVO>
     * @throws EventException
     */
    public List<SearchUSIORListVO> searchCostPod(String costDiv) throws EventException {
    	log.debug("searchUSIORList Start!! ");
    	
    	try {
    		return dbDao.searchCostPod(costDiv) ;
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
    
    /**
     * 조회조건(combo)을 위한 Equipment Office Code 조회.
     * 
     * @return List<SearchUSIORListVO>
     * @throws EventException
     */
    public List<SearchUSIORListVO> searchEqmtOfcCd() throws EventException {
    	log.debug("searchUSIORList Start!! ");
    	
    	try {
    		return dbDao.searchEqmtOfcCd() ;
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
    
 
	/**
	 * 조회 이벤트 처리<br>
	 * USA404EDIStatusInquiry화면에 대한 Down Excel 이벤트 처리<br>
	 *
	 * @param SearchUSIORInfoVO usiorInfo
	 * @param String ofcCd
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchUSIORInquiry(SearchUSIORInfoVO usiorInfo, String ofcCd) throws EventException {
//	    command.searchUSIORList(event.getSearchUSIORInfo(), account.getOfc_cd());

		log.debug("searchUSIORList excel only Start!! ");
		
    	try {
    		return dbDao.searchUSIORInquiry(usiorInfo, ofcCd) ;
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
	/**
	 * 조회 이벤트 처리<br>
	 * USA404EDIStatusInquiry화면에 대한 Down Excel 이벤트 처리<br>
	 * @return String[]
	 */
    @Override
	public String[] getColumns() {
		// 컬럼헤더와 매핑되는 DB Column 명 정의
		String[] titleField = new String[69];
		titleField[0] = " "                ;
		titleField[1] = "bkg_no"              ;     
		titleField[2] = "unmatch_flg"          ;                
		titleField[3] = "bkg_pod_cd" ;                          
		titleField[4] = "bkg_del_cd"      ;                     
		titleField[5] = "cop_pod_cd"        ;                   
		titleField[6] = "cop_del_cd"          ;                 
		titleField[7] = "cntr_no"     ;                         
		titleField[8] = "tpsz"        ;                         
		titleField[9]  = "mvmt_sts"                ;            
		titleField[10] = "mvmt_yd"           ;                  
		titleField[11] = "mvmt_dt"           ;                  
		titleField[12] = "vvd"            ;                     
		titleField[13] = "lane"            ;                    
		titleField[14] = "eta"                ;                 
		titleField[15] = "spe"        ;                         
		titleField[16] = "rail_dest"            ;               
		titleField[17] = "cstms_loc_cd"            ;            
		titleField[18] = "eq_ctrl_ofc_cd"        ;              
		titleField[19] = "term"            ;                    
		titleField[20] = "add_trsp"            ;                
		titleField[21] = "rl_so_pln_flg"           ;            
		titleField[22] = "rl_so_flg"            ;               
		titleField[23] = "rl_wo_flg"                 ;          
		titleField[24] = "ts_so_pln_flg"        ;               
		titleField[25] = "ts_so_flg"        ;                   
		titleField[26] = "ts_wo_flg"             ;              
		titleField[27] = "tc_so_pln_flg"          ;             
		titleField[28] = "tc_so_flg"             ;              
		titleField[29] = "tc_wo_flg"             ;              
		titleField[30] = "dr_so_pln_flg"             ;          
		titleField[31] = "dr_so_flg"      ;                     
		titleField[32] = "dr_wo_flg"          ;                 
		titleField[33] = "dr_wo_dt"          ;                  
		titleField[34] = "dr_fm"           ;                    
		titleField[35] = "dr_to"              ;                 
		titleField[36] = "dr_sp"         ;                      
		titleField[37] = "dr_sp_nm"             ;               
		titleField[38] = "cop_sts_cd"             ;             
		titleField[39] = "from"            ;                    
		titleField[40] = "guide"            ;                   
		titleField[41] = "pkup_yd_cd"           ;               
		titleField[42] = "pkup_aval_dt"        ;                
		titleField[43] = "pkup_free_dt"          ;              
		titleField[44] = "F"           ;                        
		titleField[45] = "O"           ;                        
		titleField[46] = "C"          ;                         
		titleField[47] = "dspo_cd"      ;                       
		titleField[48] = "pkup_no"       ;                      
		titleField[49] = "pkup_ofc_cd"           ;              
		titleField[50] = "pkup_end"       ;                     
		titleField[51] = "sc_no"           ;                    
		titleField[52] = "cnee_nm"   ;                          
		titleField[53] = "cnee_addr"          ;                 
		titleField[54] = "shpr_nm"          ;                   
		titleField[55] = "shpr_addr"      ;                     
		titleField[56] = "ntfy_nm"          ;                   
		titleField[57] = "ntfy_addr"      ;                     
		titleField[58] = "filer"          ;                     
		titleField[59] = "it_no"          ;                     
		titleField[60] = "it_date"               ;              
		titleField[61] = "po_no"           ;                    
		titleField[62] = "seal_no"           ;                  
		titleField[63] = "cntr_wgt"               ;             
		titleField[64] = "clm_crnt_sts"            ;            
		titleField[65] = "clm_loc"       ;                      
		titleField[66] = "clm_state"       ;                    
		titleField[67] = "clm_dt"      ;                        
		titleField[68] = "bkg_cntr_rmk"       ;                 


		return titleField;
	}
	/**
	 * 조회 이벤트 처리<br>
	 * USA404EDIStatusInquiry화면에 대한 Down Excel 이벤트 처리<br>
	 * @return String[]
	 */
	@Override
	public String[] getTitle() {
		// 엑셀의 컬럼헤더 정의
		String[] title = new String[71];
		title[0] = "Seq.";
		title[1] = "BKG";
		title[2] = "B/L No";  
		title[3] = "UNMATCH_FLAG";            
		title[4] = "BKG POD";                 
		title[5] = "BKG DEL";                 
		title[6] = "COP POD";                 
		title[7] = "COP DEL";                 
		title[8] = "CNTR NO";                 
		title[9] = "TPSZ";                    
		title[10] =  "MVMT";                   
		title[11] = "MVMT YARD";              
		title[12] = "MVMT DATE";   
		title[13] = "DUP"; 
		title[14] = "VVD";                    
		title[15] = "LANE";                   
		title[16] = "ETA";                    
		title[17] = "SPECIAL";                
		title[18] = "RAIL DEST";              
		title[19] = "CUSTOM CLR LOC";         
		title[20] = "EQ OFFICE";              
		title[21] = "TERM";                   
		title[22] = "ADD";                    
		title[23] = "RAIL PLAN";              
		title[24] = "RAIL S/O";               
		title[25] = "RAIL W/O ";              
		title[26] = "SHUTTLE PLAN";           
		title[27] = "SHUTTLE S/O";            
		title[28] = "SHUTTLE W/O";            
		title[29] = "ADDTIONAL TRUCK PLAN";   
		title[30] = "ADDTIONAL TRUCK S/O";    
		title[31] = "ADDTIONAL TRUCK W/O";    
		title[32] = "Door PLAN";              
		title[33] = "Door S/O";               
		title[34] = "Door W/O";               
		title[35] = "Door W/O DT";            
		title[36] = "Door FROM";              
		title[37] = "Door TO";                
		title[38] = "Door S/P";               
		title[39] = "Door S/P NM";            
		title[40] = "COP STATUS";             
		title[41] = "FROM";                   
		title[42] = "GUIDE";                  
		title[43] = "P/UP NODE";              
		title[44] = "P/UP AVAIL DATE";        
		title[45] = "P/UP FREE DATE";         
		title[46] = "F";                      
		title[47] = "O";                      
		title[48] = "C";                      
		title[49] = "CM";                     
		title[50] = "P/UP NO";                
		title[51] = "P/UP OFFICE";            
		title[52] = "P/UP END";               
		title[53] = "S/C NO";                 
		title[54] = "CNEE";                   
		title[55] = "CNEE ADDRESS";           
		title[56] = "SHPR";                   
		title[57] = "SHPR ADDRESS";           
		title[58] = "NTFY";                   
		title[59] = "NTFY ADDRESS";           
		title[60] = "FILER";                  
		title[61] = "IT NO";                  
		title[62] = "IT DATE";                
		title[63] = "PO NO";                  
		title[64] = "SEAL NO";                
		title[65] = "WEIGHT";                 
		title[66] = "CLM STATUS";             
		title[67] = "CLM LOCATION";           
		title[68] = "CLM ST";                 
		title[69] = "CLM DATE";               
		title[70] = "REMARK";                 


		return title;
	}	
}