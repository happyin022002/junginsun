/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COACommonBCImpl.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.coa.common.basic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.coa.common.event.CodeInfo;
import com.clt.apps.opus.esm.coa.common.integration.CommonDBDAO;
import com.clt.apps.opus.esm.coa.common.vo.AverageCostVO;
import com.clt.apps.opus.esm.coa.common.vo.BkgSokeupVO;				//SJH.20140818.ADD
import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.GetCodeSelectVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchSimNoDescVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;		//SJH.20140818.ADD
import com.clt.syscommon.common.table.CoaUtCostCreStsVO;
import com.clt.syscommon.common.util.ScheduleUtil;


/**
 * OPUS-COA Business Logic Basic Command implementation<br>
 * 2017.01.11 ESM_COA_4013 삭제처리(createOperationDays method) Defect 소스와 싱크를 맞춤.
 * 
 * @author
 * @see ESM_COA_051EventResponse,LaneSimulationBC reference the each DAO class 
 * @since J2EE 1.4
 */ 
public class CommonBCImpl extends BasicCommandSupport implements CommonBC {

    // Database Access Object
    private transient CommonDBDAO dbDao=null;

    /**
     * LaneSimulationBCImpl Object creation<br>
     * LaneSimulationDBDAO Creation<br>
     */
    public CommonBCImpl(){
        dbDao = new CommonDBDAO();
    }

    /**
     * 1. Function : Return a period<p>
     * 2. Overview : <p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @param  SearchConditionVO vo
     * @return String
     * @exception EventException
     */
    public String searchDatePeriod(SearchConditionVO vo) throws EventException {
        DBRowSet rowSet = null;							// DB ResultSet
        String rtnValue = "";
        
        try {
            rowSet = dbDao.searchDatePeriod(vo);
            if(rowSet != null){
            	while(rowSet.next()){
            		rtnValue = rowSet.getString("RTN_DATE");
            	}
            }
            return rtnValue;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }

    /**
     * 1. Function : Return the previous week.<p>
     * 2. Overview : <p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @param year
     * @param week
     * @return String
     * @exception EventException
     */
    public String searchPreWeek(String year, String week) throws EventException {
        String rtnValue = "";
        
        try {
        	rtnValue = dbDao.searchPreWeek(year, week);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        return rtnValue;
    }

    /**
     * 1. Function : Vessel sub trade list Inquiry<p>
     * 2. Overview : <p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @return    DBRowSet
     * @exception EventException
     */
    public DBRowSet searchVSLSubTradeList() throws EventException {
        
        try {
        	return dbDao.searchVSLSubTradeList();
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }

    /**
     * 1. Function : Vessel sub trade list Inquiry<p>
     * 2. Overview : <p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @param vsl_cd
     * @param skd_voy_no
     * @param skd_dir_cd
     * @return    String
     * @exception EventException
     */
    public String searchFirstEtd(String vsl_cd, String skd_voy_no, String skd_dir_cd) throws EventException {
    	
    	try {
    		return dbDao.searchFirstEtd(vsl_cd, skd_voy_no, skd_dir_cd);
    	} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }
    
    /**
     * 1. Function : Vessel sub trade list Inquiry<p>
     * 2. Overview : <p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @return    String
     * @exception EventException
     */
    public String searchPrevWkPrd() throws EventException {
        
        try {
        	return dbDao.searchPrevWkPrd();
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }
    
    /**
     * 1. Function : Vessel sub trade list Inquiry<p>
     * 2. Overview : <p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @return    String
     * @exception EventException
     * @author SJH.20150106.ADD
     */
    public String[] searchPrevWkPrdYW() throws EventException {
        
        try {
        	return dbDao.searchPrevWkPrdYW();
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }       

    /**
     * 1. Function : Return a level of the office code<p>
     * 2. Overview : <p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @param ofc_cd
     * @return    String
     * @exception EventException
     */
    public String searchOFCLevel(String ofc_cd) throws EventException{
        try {
        	return dbDao.searchOFCLevel(ofc_cd);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }
    
	/**
	 * Return a HQ's office code in case of the HQ's is and not a Area
	 * @param ofc_cd
	 * @return
	 * @throws EventException
	 */
	public String searchChgOffice(String ofc_cd) throws EventException{
        try {
        	return dbDao.searchChgOffice(ofc_cd);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }		
	}

   

    /**
     * 1. Function : Return whether or not the Booking Number is<p>
     * 2. Overview : <p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @return    boolean
	 * @param bkg_no
     * @exception EventException
     */
    public boolean checkBKGNo(String bkg_no) throws EventException {
        DBRowSet rowSet = null;							// DB ResultSet
        boolean rtnValue = false;
        
        try {
            rowSet=dbDao.checkBKGNo(bkg_no);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		if(!rowSet.getString(1).equals(""))rtnValue = true;
            	}
            }
            return rtnValue;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }

    /**
     * 1. Function : Return whether or not the Location code is<p>
     * 2. Overview : <p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @return    boolean
     * @param String loc_cd
     * @exception EventException
     */
    public boolean checkLocationCode(String loc_cd) throws EventException {
        DBRowSet rowSet = null;							// DB ResultSet
        boolean rtnValue = false;
        
        try {
            rowSet=dbDao.checkLocationCode(loc_cd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		if(!rowSet.getString(1).equals(""))rtnValue = true;
            	}
            }
            return rtnValue;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }

    /**
     * 1. Function : Return whether or not the Vessel Code.<p>
     * 2. Overview : <p>
     * 3. Caution : <p>
		* ===================================<br>
     * <p/>
     * @return    boolean
     * @param     vsl_cd String
     * @exception EventException
     */
    public boolean checkVesselCode(String vsl_cd) throws EventException {
        DBRowSet rowSet = null;							// DB ResultSet
        boolean rtnValue = false;
        
        try {
            rowSet=dbDao.checkVesselCode(vsl_cd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		if(!rowSet.getString(1).equals(""))rtnValue = true;
            	}
            }
            return rtnValue;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }
    
    /**
     * 1. Function : Return whether or not the VVD Code.<p>
     * 2. Overview : <p>
     * 3. Caution : <p>
* ===================================<br>
     * <p/>
     * @return    boolean
	 * @param vsl_cd
	 * @param skd_voy_no
	 * @param dir_cd
     * @exception EventException
     */
    public boolean checkVVDCode(String vsl_cd, String skd_voy_no, String dir_cd) throws EventException {
        DBRowSet rowSet = null;							// DB ResultSet
        boolean rtnValue = false;
        
        try {
            rowSet=dbDao.checkVVDCode(vsl_cd, skd_voy_no, dir_cd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		if(!rowSet.getString(1).equals(""))rtnValue = true;
            	}
            }
            return rtnValue;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }

    /**
     * 1. Function : Return whether or not the Office Code<p>
     * 2. Overview : <p>
     * 3. Caution : <p>
* ===================================<br>
     * <p/>
     * @return    boolean
     * @param     ofc_cd
     * @exception EventException
     */
    public boolean checkOfficeCode(String ofc_cd) throws EventException {
        DBRowSet rowSet = null;							// DB ResultSet
        boolean rtnValue = false;
        
        try {
            rowSet=dbDao.checkOfficeCode(ofc_cd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		if(!rowSet.getString(1).equals(""))rtnValue = true;
            	}
            }
            return rtnValue;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }

    /**
     * 1. Function : Return whether or not the Revenue Lane Code.<p>
     * 2. Overview : <p>
     * 3. Caution : <p>
* ===================================<br>
     * <p/>
     * @return    boolean
     * @param     rlane_cd
     * @exception EventException
     */
    public boolean checkRevLaneCode(String rlane_cd) throws EventException {
        DBRowSet rowSet = null;										// DB ResultSet
        boolean rtnValue = false;
        
        try {
            rowSet=dbDao.checkRevLaneCode(rlane_cd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		if(!rowSet.getString(1).equals(""))rtnValue = true;
            	}
            }
            return rtnValue;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }
    
    /**
     * 1. Function : Revenue Lane Code 유무를 리턴.<p>
     * 2. Overview : <p>
     * 3. Caution : <p>
* ===================================<br>     * <p/>
     * @return    boolean
     * @param     slane_cd
     * @exception EventException
     */
    public boolean checkSLaneCode(String slane_cd) throws EventException {
        DBRowSet rowSet = null;						// DB ResultSet
        boolean rtnValue = false;
        
        try {
            rowSet=dbDao.checkSLaneCode(slane_cd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		if(!rowSet.getString(1).equals(""))rtnValue = true;
            	}
            }
            return rtnValue;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }

    /**
     * 1. Function : Return whether or not the Node Code<p>
     * 2. Overview : <p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @return    boolean
     * @param     node_cd
     * @exception EventException
     */
    public boolean checkNodeCode(String node_cd) throws EventException {
        DBRowSet rowSet = null;										// DB ResultSet
        boolean rtnValue = false;
        
        try {
            rowSet=dbDao.checkNodeCode(node_cd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		if(!rowSet.getString(1).equals(""))rtnValue = true;
            	}
            }
            return rtnValue;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }
	
	/**
	 * Conversion exchange rate
	 * 
	 * @param cost_yrmon
	 * @param locl_curr_cd
	 * @param lcl_amt
	 * @return usd_amt
	 * @throws EventException
	 */
	public float getUSDAmt(String cost_yrmon, String locl_curr_cd, float lcl_amt) throws EventException{
        try {
        	return dbDao.getUSDAmt(cost_yrmon, locl_curr_cd, lcl_amt);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }	
	}  
	
	/**
	 * Conversion exchange rate
	 * 
	 * @param cost_yrmon
	 * @param locl_curr_cd
	 * @param lcl_amt
	 * @return usd_amt
	 * @throws EventException
	 */
	public float getUSDAmt2(String cost_yrmon, String locl_curr_cd, float lcl_amt) throws EventException{
        try {
        	return dbDao.getUSDAmt2(cost_yrmon, locl_curr_cd, lcl_amt);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }	
	}  
  
	
	/**
	 * Return a office code by the Location Code
	 * 
	 * @param loc_cd
	 * @return ofc_cd
	 * @throws EventException
	 */
	public String getLocationToOffice(String loc_cd) throws EventException{
        try {
        	return dbDao.searchLocationToOffice(loc_cd);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }		
	}	
	

    /**
     * 1. Function : default combo,ibsheet codelist를 return <p>
     * 2. Overview : <p>
     * 3. Caution : <p>
     * 
     * @param codeItem  	BIZ DIV
	 *  					01.ServiceLane			: sLane         => mdm_vsl_svc_lane
	 *  											  sLane2(trd_cd)=> COA_LANE_RGST, 
	 *  											  sLane3(trd_cd)=> COA_LANE_RGST
	 *                                                simLane       => simulation's  service lane
	 *  					02.TradeList			: trade
	 *  					03.SubTradeList			: subTrade(trd_cd)
	 *  					04.RevenuelaneList		: rLane(trd_cd) => COA_LANE_RGST 
	 *  											  rLane2(trd_cd)=> COA_LANE_RGST (HashMap )
	 *  											  rLane3()      => COA_LANE_RGST (combo)
	 *  					05.DirectionList		: Dir
	 *  					06.Interport/OceanList	: IOC
	 *  					07.VessellanetypeList	: laneTP
	 *  					08.vesselList	 	 	: vessel
	 *  					  .simVessel	 	 	: simVsl
	 *  					09.SimulationVesselList	: simVessel(sLane|sim_dt|sim_no)
	 *  					10.freight variable cost  : codeItem
	 *  					10.OP account 			: simOpAcct
	 *  					11.CarrierList		 	: Carrier
	 *  					12.OptionList(BSA)		: optBSA(del)
	 *  					13.COAMainGroup		 	: mnGroup
	 *  					14.COASubGroup			: subGroup(mgrp_cost_cd)
	 *  					15.VesselSubTradeList	: vslSubTrade(sub_trd_chk_flg)
	 *  					16.ECCList				: ecc([rcc_cd | lcc_cd])
	 *  					17.SCCList				: scc(ecc_cd)
	 *  					18.LOCList				: loc({ecc|ecc_cd} or {scc|scc_cd})
	 *  					19.OfficeCodeList		: office()			=> RHQ Office Code List
	 *  											  office2(ofc_cd)   => Office Code List
	 *                      20. Container Type Size : tpSz
	 *                      21. vessel capa List    : vslCapa
	 *                      22. Currency List       : currency
	
	 *                      24. BSA Operation Job List : bsaOpJb
	 *                      25. Commodity List		: commodity
	 *                      26. Report Item Info List : slctItmFom(cre_usr_id)
	 *                      27. Regional Headquarter: RHQ
	 *                      28. Owner Terminal List : OwnTML
	 *                      29. Carrier List(BSA)   : BSACarrier(code[bsa_op_cd])
	 *                      30. EQ Reposition Contribution Type Size : EQRepoTpSz
	 *                      31. RA MainGroup	    : raMnGrp
	 *                      32. RA SubGroup : raSubGrp(ra_mn_cost_cd)
	 *                      33. RCC List            : RCC
	 *                      34. LCC List            : LCC(rcc_cd)
	 *                      35. SimInfo             : SimInfo(slan_cd)
	 *                      36. Standard Cost Code  : StndCost
	 *                      37. ofcActivity         : ofcActivity(cost_yrmon)
	 *                      38. ownVessel           : ownVessel()
	 *                      39. chtVessel           : chtVessel()                     
	 *                      41. activity group code : actgrp
	 *                      42. country code        : cnt
	 *                      43. rhq code            : rhqCode
	 *                      
	 *                      45. Cost Source Code	: srcCd(stnd_cost_cd)
	 *                      46. TML Trf Dtl Code	: tmlTrf
	 *                      47. Report view     	: rptAuth(Common code-[CD00939][CD00940][CD00941])
	 *                      48. All Office Level	: allOFCLevel(ofc_lvl)	
	 *                      49. sub office code		: office3(ofc_cd|ofc_lvl|selected ofc_lvl)
	 *                      50. coaCode				: coaCode(subGrp) ==> stnd_cost_cd
	 *                      51. lgsKPI				: Lobistics KPI               
	 *                      53. costTableTpsz		: Cost Table Container Type Size RD2->R2, RD4->R4
	 *                      54. key Account 		: keyAcc
	 *                      55. tmlCd				: coa_inter_tml_if_mgmt - terminal code
	 *                      56. LOGISTICT RHQ       : lgsRHQ (logistics's RHQ)
	 *                      57. Simulatin Vsl Class : simVslCls()
	 *                      59. Original TPSZ : ORITPSZ
	 *                      60. AllOffice           : AllOffice - Pre CM's OFFICE CODE
	 *                      61. Other Commission Location : Agency Other Commission's Location
	 *                      62. SMU Sub Trade 		: SMU's Sub Trade, Trunk IPC except
	 *                      63. EMU POD ECC 		: EMU POD cost's ECC (only Port,  except Inland ECC)
	 *                      64. simulation dept     : dept(code) - Simulation's dept code
	 *                                            
	 *                      
     * @param codeItem      	Code group
     * @param code      	    Code option
     * @return List<GetCodeSelectVO>
     * @throws EventException
     */
   
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<GetCodeSelectVO> getCodeSelectList(String codeItem, String code) throws EventException {
    	List<GetCodeSelectVO> list = new ArrayList<GetCodeSelectVO>();
    	Collection<CodeInfo> codeList  = null;
    	DBRowSet dRs = null;
    	log.debug("=&&&&&&&&&& codeItem :"+codeItem);
    	log.debug("========= code :"+code);
	        try {	        	
	        	if(codeItem.equalsIgnoreCase("sLane")){					// 1. Service Lane
	        		dRs = dbDao.searchSVCLaneList();
	        	}else if(codeItem.equalsIgnoreCase("sLane2")){	
	        		dRs = dbDao.searchSLaneList(code);
	        	}else if(codeItem.equalsIgnoreCase("sLane3")){	
	        		if(!code.equals("")) {
	        			dRs = dbDao.searchSLaneList(code);
	        		}
	        	}else if(codeItem.equalsIgnoreCase("trade")){				// 2. Trade List
	        		dRs = dbDao.searchTradeList();
	        	}else if(codeItem.equalsIgnoreCase("subTrade")){			// 3. Sub Trade List
	        		dRs = dbDao.searchSubTradeList(code);
	        	}else if(codeItem.equalsIgnoreCase("subTrade2")){			//    Sub Trade List2 (중복제거) : SJH.20141224.ADD
	        		dRs = dbDao.searchSubTradeList2(code);	        		
	        	}else if(codeItem.equalsIgnoreCase("rLane")){				// 4. Revenue lane List
	        		dRs = dbDao.searchRevLaneList(code);
	        	}else if(codeItem.equalsIgnoreCase("rLane3")){				
	        		dRs = dbDao.searchRevLaneList2();
	        	}else if(codeItem.equalsIgnoreCase("rLane2")){			
	        		dRs = dbDao.searchRLaneList(code);
	        	}else if(codeItem.equalsIgnoreCase("Dir")){				// 5. Direction List
	        		codeList = dbDao.setDirList();
	        		Iterator iterator = codeList.iterator();
    				CodeInfo codeModel = null;
	        		GetCodeSelectVO vo = null;
	    			while (iterator.hasNext()) {
	    				codeModel = (CodeInfo) iterator.next();
	    				vo = new GetCodeSelectVO();
	    				vo.setCode(codeModel.getCode());
	    				vo.setName(codeModel.getName());
	    				list.add(vo);
	    			}
	        	}else if(codeItem.equalsIgnoreCase("IOC")){				// 6. Interport/Ocean List
	        		codeList = dbDao.setIOCList();
	        		Iterator iterator = codeList.iterator();
    				CodeInfo codeModel = null;
	        		GetCodeSelectVO vo = null;
	    			while (iterator.hasNext()) {
	    				codeModel = (CodeInfo) iterator.next();
	    				vo = new GetCodeSelectVO();
	    				vo.setCode(codeModel.getCode());
	    				vo.setName(codeModel.getName());
	    				list.add(vo);
	    			}
	        	}else if(codeItem.equalsIgnoreCase("laneTP")){			// 7. Vessel lane type List
	        		codeList = dbDao.setLaneTPList();
	        		Iterator iterator = codeList.iterator();
    				CodeInfo codeModel = null;
	        		GetCodeSelectVO vo = null;
	        		while (iterator.hasNext()) {
	    				codeModel = (CodeInfo) iterator.next();
	    				vo = new GetCodeSelectVO();
	    				vo.setCode(codeModel.getCode());
	    				vo.setName(codeModel.getName());
	    				list.add(vo);
	    			}
	        	}else if(codeItem.equalsIgnoreCase("vessel")){			// 8. vessel List
	        		dRs = dbDao.searchVesselList();
	        	}else if(codeItem.equalsIgnoreCase("codeItem")){			// 10. freight variable cost Item
	        		dRs = dbDao.searchSIMCostItem();
	        	}else if(codeItem.equalsIgnoreCase("mnGroup")){			// 13. COA Main Group	
	        		dRs = dbDao.searchMNGRPCostList(code);
	        	}else if(codeItem.equalsIgnoreCase("subGroup")){			// 14. COA Sub Group
	        		dRs = dbDao.searchSubGRPCostList(code);
	        	}else if(codeItem.equalsIgnoreCase("vslSubTrade")){		// 15. Vessel Sub Trade List
	        		dRs = dbDao.searchVSLSubTradeList();
	        	}else if(codeItem.equalsIgnoreCase("ecc")){				// 16. ECC List([rcclcc_cd])
	        		dRs = dbDao.searchEccList(code);
	        	}else if(codeItem.equalsIgnoreCase("scc")){				// 17. SCC List(ecc_cd)
	        		dRs = dbDao.searchSccList(code);
	        	}else if(codeItem.equalsIgnoreCase("loc")){				// 18. LOC List
	        		dRs = dbDao.searchLocList(code);
	        	}else if(codeItem.equalsIgnoreCase("office")){			// 19. Office code List
	        		dRs = dbDao.searchOFCHQList();
	        	}else if(codeItem.equalsIgnoreCase("tpSz")){				// 20. Container Type Size
	        		dRs = dbDao.searchTpSzList();
	        	}else if(codeItem.equalsIgnoreCase("vslCapa")){			// 21. vessel capa List
	        		dRs = dbDao.searchVslCapaList();
	        	}else if(codeItem.equalsIgnoreCase("currency")){			// 22. currency List
	        		dRs = dbDao.searchCurrencyList();
	        	}else if(codeItem.equalsIgnoreCase("VesselClass")){			// 23. Port Class List
	        		dRs = dbDao.searchVesselClassList();
	        	}else if(codeItem.equalsIgnoreCase("commodity")){			// 25. Commodity List
	        		dRs = dbDao.searchRepCMDTList();	
	        	}else if(codeItem.equalsIgnoreCase("slctItmFom")){		// 26. Report Item Info List : slctItmFom(cre_usr_id)
	        		dRs = dbDao.searchReportItem(code);	
	        	}else if(codeItem.equalsIgnoreCase("RHQ")){				//27. Regional Headquarter: RHQ
	        		dRs = dbDao.searchRHQList();
	        	}else if(codeItem.equalsIgnoreCase("EQRepoTpSz")){		//30. EQ Reposition Contribution Type Size
	        		dRs = dbDao.searchEQRepoTpSzList();
	        	}else if(codeItem.equalsIgnoreCase("raMnGrp")){			//31. RA MainGroup	: raMnGrp
	        		dRs = dbDao.searchRAMainGroupList();
	        	}else if(codeItem.equalsIgnoreCase("raSubGrp")){			//32. RA SubGroup : raSubGrp(ra_mn_cost_cd)
	        		dRs = dbDao.searchRASubGroupList(code);
	        	}else if(codeItem.equalsIgnoreCase("RCC")){				//33. RCC List : RCC
	        		dRs = dbDao.searchRccList();
	        	}else if(codeItem.equalsIgnoreCase("LCC")){				//34. LCC List : LCC(rcc_cd)
	        		dRs = dbDao.searchLccList(code);
	        	}else if(codeItem.equalsIgnoreCase("StndCost")){		   //36. Standard Cost Code  : StndCost
	        		dRs = dbDao.searchStndCostList();
	        	}else if(codeItem.equalsIgnoreCase("ownVessel")){	   	   //38. ownVessel         : ownVessel()
	        		dRs = dbDao.searchOwnVesselList();
	        	}else if(codeItem.equalsIgnoreCase("chtVessel")){	       //39. chtVessel         : chtVessel()
	        		dRs = dbDao.searchChtVesselList();	        	
	        	}else if(codeItem.equalsIgnoreCase("actgrp")){		   // 41. activity group code
	        		dRs = dbDao.searchActGrpList();
        	    }else if(codeItem.equalsIgnoreCase("cnt")){		       // 42. country group code
        	    	dRs = dbDao.searchCntList();
        	    }else if(codeItem.equalsIgnoreCase("LOC2ECC")) {			//44. LOC2ECC
        	    	dRs = dbDao.searchLoc2EccList(code);      	    	
        	    }
        	    else if(codeItem.equalsIgnoreCase("srcCd")) {				//45. Cost Source Code	: srcCd(stnd_cost_cd)
        	    	dRs = dbDao.searchCostSourceCodeList(code);     	    	
        	    }else if(codeItem.equalsIgnoreCase("rptAuth")) {			//47. Report view	: rptAuth	
        	    	dRs = dbDao.searchRPTAuthList(code);      	    	
        	    }else if(codeItem.equalsIgnoreCase("allOFCLevel")) {		//48. All Office Level	: allOFCLevel(ofc_lvl)	
        	    	dRs = dbDao.searchOFCLevelList(code);      	    	
        	    }else if(codeItem.equalsIgnoreCase("office3")) {			//49. sub office code	: office3(ofc_cd|ofc_lvl|selected ofc_lvl)	 	
        	    	dRs = dbDao.searchSubOFCList(code);      	    	
        	    }else if(codeItem.equalsIgnoreCase("coaCode")) {			//50. coaCode	: coaCode(subGrp)
        	    	dRs = dbDao.searchCoaCodeList(code);      	    	
        	    } else if(codeItem.equalsIgnoreCase("lgsKPI")) {			//51. lgsKPI:Lobistics KPI(costGrp)
        	    	dRs = dbDao.searchLogisticsKpiList(code);      	    	
        	    } else if(codeItem.equalsIgnoreCase("costTableTpsz")) {	//53. costTableTpsz		: Cost Table Container Type Size RD2->R2, RD4->R4
        	    	dRs = dbDao.searchCostTableCntrTpszList();      	    	
        	    } else if(codeItem.equalsIgnoreCase("keyAcc")) {	//54. key Account 		: keyAcc
        	    	dRs = dbDao.searchKeyAccountList();      	    	
        	    } else if(codeItem.equalsIgnoreCase("lgsRHQ")){		   // 56. LOGISTICT RHQ       : lgsRHQ (logistics's RHQ)
        	    	dRs = dbDao.searchLogisticsRhqCode();
        	    } else if(codeItem.equalsIgnoreCase("lgsOFC")){		   // 57. LOGISTICT OFFICE    : lgsOFC (logistics's OFFICE CODE)
        	    	dRs = dbDao.searchLogisticsOfficeCode(code);
        	    } else if(codeItem.equalsIgnoreCase("srcStndCd")){		   // 58. Cost Srouce Code/Stnd Code    : srcStndCd
        	    	dRs = dbDao.searchCostSourceCodeStndCodeList(code);
        	    } else if(codeItem.equalsIgnoreCase("ORITPSZ")){		   // 59. Original TPSZ : ORITPSZ
        	    	dRs = dbDao.searchOriginalCntrTpszList();
        	    } else if(codeItem.equalsIgnoreCase("OtrCommLoc")){		   // 61. OtrCommLoc : Agency Other Commission's Location
        	    	dRs = dbDao.searchOtrCommLocList();
        	    }else if(codeItem.equalsIgnoreCase("SMUSubTrade")){	      // 62. SMU Sub Trade 		: SMU's Sub Trade, Trunk IPC 제외
        	    	dRs = dbDao.searchSMUSubTradeList(code);
        	    }else if(codeItem.equalsIgnoreCase("PODECC")){		   // 63. EMU POD ECC 		: EMU POD cost's ECC 
        	    	dRs = dbDao.searchPodEccList();
        	    }else if(codeItem.equalsIgnoreCase("keyAcctGroup")){		   // 67. Group ID
        	    	dRs = dbDao.searchCustGrpIdcList();

        	    }else if(codeItem.equalsIgnoreCase("keyAcctIndvl")){		   // 68. Key AccoutList : code => group id
        	    	dRs = dbDao.searchKeyAcctInDvlList(code);
        	    	
        	    }else if(codeItem.equalsIgnoreCase("mltTrdGroup")){
        	    	dRs = dbDao.searchMltTrdGrpIdcList();
        	    }else if(codeItem.equalsIgnoreCase("mltTrdIndvl")){
        	    	dRs = dbDao.searchMltTrdInDvlList(code);	
        	    	
        	    }else if(codeItem.equalsIgnoreCase("avgSubGrp")){		  	   // 70. Average SUB GROUP's code,name
	        	   dRs = dbDao.searchAvgSubGrpList();
        	    }else if(codeItem.equalsIgnoreCase("avgCoaCode")){		  	   // 69. Average COA's code,name
        	    	dRs = dbDao.searchAvgCoaCodeList(code);

        	    }else if(codeItem.equalsIgnoreCase("mdmChargeCd")){	
        	    	dRs = dbDao.searchMdmChargeList();
        	    }else if(codeItem.equalsIgnoreCase("mdmChargeTypeCd")){	
        	    	dRs = dbDao.searchMdmChargeTypeList();	
        	    }else if(codeItem.equalsIgnoreCase("demdetCACd")){				//DEM/DET, Vol Discount (PA/RA) - C/A Code
        	    	dRs = dbDao.searchDemDetStandardCdList();	
        	    }else if(codeItem.equalsIgnoreCase("costSrcAcctGrpCd")){		//COA_COST_SRC_ACCT's code list
        	    	dRs = dbDao.searchCostSourceGroupCodeList(code);	
        	    }else if(codeItem.equalsIgnoreCase("VslOwner")){	
        	    	dRs = dbDao.searchVslOwnerList(code);		
        	    }else if(codeItem.equalsIgnoreCase("mdmUSARegion")){			//MDM Region(CA, US) List 
        	    	dRs = dbDao.searchMdmRegionList();	
	        	}else if(codeItem.equalsIgnoreCase("SimInfo")){			//35. SimInfo : SimInfo(slan_cd)
	        		dRs = dbDao.searchSimList(code);  // EAI 테스트를 위해 주석처리함
	        	}else if(codeItem.equalsIgnoreCase("DEPT")){		   // 64. sinulation dept code
        	    	dRs = dbDao.searchSimDeptList(code);
        	    }else if(codeItem.equalsIgnoreCase("simLane")){	
	        		dRs = dbDao.searchSimSLaneList();
	        	}else if(codeItem.equalsIgnoreCase("simVsl")){			// 9. Simulation Vessel List
	        		dRs = dbDao.searchSimVesselList();
	        	}else if(codeItem.equalsIgnoreCase("simVessel")){			// 9. Simulation Vessel
	        		dRs = dbDao.searchSimVessel(code);
	        	}else if(codeItem.equalsIgnoreCase("simVslCls")){	
	        		dRs = dbDao.searchSimVslClssList();
	        	}else if(codeItem.equalsIgnoreCase("simOpAcct")){			// 10. OP 계정코드를 조회한다.
	        		dRs = dbDao.searchSimOpAcct();	
        	    }else if(codeItem.equalsIgnoreCase("sokeupStatus")){		// 83. sokeupStatus 조회 : SJH.20140818.ADD
        	    	dRs = dbDao.searchSokeupCodeList();	  
	        	}else if(codeItem.equalsIgnoreCase("svcScpCd")){		// 84. svcScpCd 조회 : PCM.20141218.ADD
        	    	dRs = dbDao.searchSvcScpCodeList();	 	        	
        	    }else if(codeItem.equalsIgnoreCase("svcScpCd")){		// 84. svcScpCd 조회 : PCM.20141218.ADD
            	    	dRs = dbDao.searchSvcScpCodeList();	
	        	}else if(codeItem.equalsIgnoreCase("locAll")){			// 85. LOC List All: SJH.20150105.ADD
	        		dRs = dbDao.searchLocListAll(code);            	    	
	        	}else if(codeItem.equalsIgnoreCase("cntrTpszCd")){		// 86. cntrTpszCd List All: SJH.20150105.ADD
	        		dRs = dbDao.searchCntrTpszCdList(code);            	    	
	        	}else if(codeItem.equalsIgnoreCase("avgAgnAcTpCd")){		// 86. 2017.01.11 Add Account Type Code 
	        		dRs = dbDao.searchAcmAccountTypeList(code);            	    	
	        	}else if(codeItem.equalsIgnoreCase("avgAgnIoBndCd")){		// 86. 2017.01.11 Add Bound Code
	        		dRs = dbDao.searchAcmBoundList(code);            	    	
	        	}else if(codeItem.equalsIgnoreCase("avgAgnCostCd")){		// 86. 2017.01.11 Add Cost Code
	        		dRs = dbDao.searchAcmCostList(code);            	    	
	        	}else{
        	    //Common code	
        	    	Collection codeList2 = null; 
        	    	codeList2 = com.clt.framework.component.util.code.CodeUtil.getInstance().getCodeSelect(codeItem,0);
        	    	Iterator iterator = codeList2.iterator();
	        		
	                 
	        		com.clt.framework.component.util.code.CodeInfo codeModel2 = null;
	    			while (iterator.hasNext()) {
	    				codeModel2 = (com.clt.framework.component.util.code.CodeInfo) iterator.next();
	    				if (codeModel2 != null){
	    					GetCodeSelectVO vo = new GetCodeSelectVO();
		    				vo.setCode(codeModel2.getCode());
		    				vo.setName(codeModel2.getName());
		    				list.add(vo);
	    				}
	    			}
        	    }
	        	
	        	if (dRs != null){
	        		list = (List) RowSetUtil.rowSetToVOs(dRs, GetCodeSelectVO.class);
	        	}
	        } catch(SQLException se){
	            log.error("SQLException : " +se.getMessage());
	            throw new EventException("SQLException : " + se.getMessage());
	        } catch (DAOException de) {
	            log.error("DAOException : " +de.getMessage());
	            throw new EventException("DAOException : " + de.getMessage());
	        } catch(Exception ex){
	        	log.error("Exception : " +ex.getMessage());
	        	throw new EventException("Exception : " + ex.getMessage());
	        }
	        return list;  
   }
    /**
     * Function : default combo,ibsheet codelist return <p>
     * 
     * @param GeneralEventResponse eventResponse
     * @param String[][] array
     * @return GeneralEventResponse
     * <br><b>Example : </b>
	 * <pre>
	 *     String array[][] = {{"trade","",""}};
	 *     eventResponse = CodeUtil.getMakeCodeSelectList(eventResponse,array);
	 * </pre>
     * @throws EventException
     */
   public GeneralEventResponse getMakeCodeSelectList(GeneralEventResponse eventResponse,String[][] array) throws EventException {
    	List<GetCodeSelectVO> list = new ArrayList<GetCodeSelectVO>();
    	GetCodeSelectVO combovo = new GetCodeSelectVO();
 	    
 	    try {
	    	for(int i=0 ; i< array.length ; i++) {
	    		list = getCodeSelectList((array[i][0]).toString(), array[i][1]);
	    		if (array[i][2].equals("All")){
	    			combovo.setName("All");
	    	 	    //combovo.setCode("All");		//SJH.20141223.MOD
	    			combovo.setCode("");
	    			list.add(0,combovo);
	    		}else if (array[i][2].equals("Blank")){
	    			combovo.setName(" ");
	    	 	    combovo.setCode(" ");
	    			list.add(0,combovo);
	    		}
	    		eventResponse.setRsVoList(list);   
	    	}
 	   } catch(Exception ex){
 		   log.error("Exception : " +ex.getMessage());
 		   throw new EventException("Exception : " + ex.getMessage());
       }
    	return eventResponse;
   }
   
   /**
	 * Setting the IBSheet dynamic combo in case of retrieving
	 * 
	 * @param tagName       Select List Box name
	 * @param codeItem      Return the below list
	 *                      01. Sub Trade List         	: subTrade
	 *                      02. COA Main Group          : mnGroup
	 *                      03. COA Sub Group          	: subGroup
	 *                      04. Service Lane List		: sLane2
	 *                      05. Revenue Lane List		: rLane2
	 *                      06. Office List	: office2
	 *                      07. RA SubGroup 			:raSubGrp
	 *                      08. Stndard Cost Code List  : coaCode
	 *                      09. Revenue Lane List		: rLane4 (Except IP)
	 *                      
	 * @param searchCode
	 * @param rtnType       name  : name return
	 *                      code  : code return
	 * @return
	 * @throws EventException
	 */
   @SuppressWarnings("unchecked")
	public HashMap<String, String> getCodeCombo(String tagName, String codeItem, String searchCode, String rtnType) throws EventException {
		HashMap<String, String> h = new HashMap<String, String>();
		StringBuffer sbText = new StringBuffer();
		StringBuffer sbValue = new StringBuffer();
		List<GetCodeSelectVO> totalList = new ArrayList();
		
		log.debug("########### tagName :"+tagName);
		log.debug("########### codeItem :"+codeItem);
		log.debug("########### searchCode :"+searchCode);
		
		try{
			totalList = getCodeSelectList(codeItem, searchCode);
//			log.debug("########### totalList :"+totalList); 
			String tmpStr = "";
			GetCodeSelectVO vo = null;
			for(int i=0 ; i< totalList.size() ; i++) {
				vo = totalList.get(i);
				if (vo.getKey() == null) vo.setKey("");
				if (tmpStr.equals(vo.getKey()) || tmpStr.equals("")){
					sbText.append("|");
					sbText.append(vo.getName());
					sbValue.append("|");
					sbValue.append(vo.getCode());
					tmpStr = vo.getKey();
				}else{
					if(rtnType.equals("name")){
						h.put(tmpStr, " " +sbText.toString());
					}else if(rtnType.equals("code")){
						h.put(tmpStr, " " +sbValue.toString());
					}	
					sbText = new StringBuffer();
					sbValue = new StringBuffer();
					
					sbText.append("|");
					sbText.append(vo.getName());
					sbValue.append("|");
					sbValue.append(vo.getCode());
					tmpStr = vo.getKey();
				}
				
			}
			
			if(!sbText.toString().equals("")){
				if(rtnType.equals("name")){
					h.put(tmpStr, " " +sbText.toString());
				}else if(rtnType.equals("code")){
					h.put(tmpStr, " " +sbValue.toString());
				}
			}		
		} catch(Exception ex){
	 		   log.error("Exception : " +ex.getMessage());
	 		   throw new EventException("Exception : " + ex.getMessage());
	       }
		return h;		
		
	}
   
   /**
	 * Setting the IBSheet dynamic combo in case of retrieving
	 * 
	 * @param tagName       Select List Box name
	 * @param codeItem      Return the below list
	 *                      01. Sub Trade List         	: subTrade
	 *                      02. COA Main Group          : mnGroup
	 *                      03. COA Sub Group          	: subGroup
	 *                      04. Service Lane List		: sLane2
	 *                      05. Revenue Lane List		: rLane2
	 *                      06. Office List	: office2
	 *                      07. RA SubGroup 			:raSubGrp
	 *                      08. Stndard Cost Code List  : coaCode
	 *                      09. Revenue Lane List		: rLane4 (Except IP)
	 *                      
	 * @param searchCode
	 * @param rtnType       name  : name return
	 *                      code  : code return
	 * @return
	 * @throws EventException
	 */
	public String getIbCodeCombo(String tagName, String codeItem, String searchCode, String rtnType) throws EventException {
	   HashMap<String, String> hmIbCode	= null;
	   String strIbCodeCombo = "";
	   try{
		   	hmIbCode = getCodeCombo(tagName, codeItem, searchCode, rtnType);
		   	strIbCodeCombo = (String)hmIbCode.get(searchCode);
	   } catch(Exception ex){
 		   log.error("Exception : " +ex.getMessage());
 		   throw new EventException("Exception : " + ex.getMessage());
       }	
	   return strIbCodeCombo;
   	}

	/**
	 * User's office level return
	 * @param ofc_cd
	 * @return String
	 * @throws EventException
	 */
	public String getUserLevel(String ofc_cd) throws EventException {
		
		String rtn_ofc_lvl = "";
		
		try {		
				rtn_ofc_lvl = searchOFCLevel(ofc_cd);			
			
	    }  catch (Exception e){
	        log.error("err "+e.toString(),e);
	        throw new EventException(e.getMessage());
	    }
		return rtn_ofc_lvl;
	}
	
	/**
	 * User's office code  return
	 * @param ofc_cd
	 * @return	String
	 * @throws EventException
	 */
	public String getUserOffice2(String ofc_cd) throws EventException {
		String lvl_no = "";
				
		lvl_no = getUserLevel(ofc_cd);
		
		try {
			if(lvl_no.equals("1")){
				ofc_cd = ConstantMgr.getHeadOfficeCode();
			} else if(lvl_no.equals("2")){
				// in case of a HQ is but not a Area, return HQ's office code 
				ofc_cd = searchChgOffice(ofc_cd);
			} else if(lvl_no.equals("3")){
				// SQ's return office code
				ofc_cd = searchChgOffice(ofc_cd);
			} else {				
			}
		}  catch (Exception e){
	        log.error("err "+e.toString(),e);
	        throw new EventException(e.getMessage());
	    }
		return ofc_cd;
	}
	
	/**
	 * Return [year, month] or [year, week]
	 * 
	 * @param year		year
	 * @param date		month(09), week(23) possible
	 * @param type		date's type 
	 * 					month
	 * 					week
	 * @return
	 * @exception EventException
	 */
	public String getDatePeriod(String year, String date, String type) throws EventException{
		String period = "";
		SearchConditionVO vo = new SearchConditionVO();
		
		try{
			if(type.toUpperCase().equals("MONTH")){
				vo.setFYear(year);
				vo.setFYearmonth(date);
			} else if (type.toUpperCase().equals("WEEK")){
				vo.setFYear(year);
				vo.setFYearweek(date);
			}
			period = searchDatePeriod(vo);
			if(period.equals("~"))period = "INVALID PERIOD";
		}  catch (Exception e){
	        log.error("err "+e.toString(),e);
	        throw new EventException(e.getMessage());
	    }
		return period;
	}
	
	/**
	 * Return a period [year, from month~to month] or [year, ,from week~to week] or [year, ,, week]
	 * 
	 * @param year		year
	 * @param frmDate	
	 * @param toDate	
	 * @param type		
	 * 					month, week, monthWeek
	 * @return
	 * @exception EventException
	 */
	public String getDatePeriod(String year, String frmDate, String toDate, String type) throws EventException{
		String period = "";
		SearchConditionVO vo = new SearchConditionVO();
		
		try{
			if(type.toUpperCase().equals("MONTH")){
				vo.setFYear(year);
				vo.setFFmMon(frmDate);
				vo.setFToMon(toDate);
			}else if (type.toUpperCase().equals("WEEK")){
				vo.setFYear(year);
				vo.setFFmWk(frmDate);
				vo.setFToWk(toDate);
			}
			period = searchDatePeriod(vo);
			if(period.equals("~"))period = "INVALID PERIOD";
		}  catch (Exception e){
	        log.error("err "+e.toString(),e);
	        throw new EventException(e.getMessage());
	    }
		return period;
	}
	
	/**
	 * Return a period [year, from month~to month, from week~to week]
	 * 
	 * @param year
	 * @param frmMonth		
	 * @param toMonth		
	 * @param frmWeek		
	 * @param toWeek		
	 * @return String
	 * @exception EventException
	 */
	public String getDatePeriod(String year, String frmMonth, String toMonth, String frmWeek, String toWeek) throws EventException{
		String period = "";
		SearchConditionVO vo = new SearchConditionVO();
		
		try{
			vo.setFYear(year);
			vo.setFFmMon(frmMonth);
			vo.setFToMon(toMonth);
			vo.setFFmWk(frmWeek);
			vo.setFToWk(toWeek);
			
			period = searchDatePeriod(vo);
			if(period.equals("~"))period = "INVALID PERIOD";
		}  catch (Exception e){
	        log.error("err "+e.toString(),e);
	        throw new EventException(e.getMessage());
	    }
		return period;		
		
	}
	
	/**
	 * 날짜에 대한 Max Simulation No를 조회한다.
	 * 
	 * @return String
	 * @throws EventException
	 */
	public String searchMaxSimNo() throws EventException{
        try {
        	return dbDao.searchMaxSimNo();
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }		
	}

    /**
     * 1. 기능 : 전주차의 년도를 조회한다.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : CHLOE MIJIN SEO /2013.01.10<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @return    String
     * @exception EventException
     */
    public String searchPrevYearPrd() throws EventException {      
        try {
        	return dbDao.searchPrevYearPrd();
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }
    

    /**
     * 1. 기능 : Simulation number의 설명을 조회한다.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : eun-ju PARK/2007.01.03<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @param vo
     * @return List<SearchSimNoDescVO>
     * @exception EventException
     */
    public List<SearchSimNoDescVO> searchSimNoDesc(SearchConditionVO vo) throws EventException {
    	String[] params = null;
        
        try {
        	params = vo.getFSim().split("[|]");
        	vo.setFSimDt(params[1].replaceAll("-", ""));
        	vo.setFSimNo(params[2]);
        	
			return dbDao.searchSimNoDesc(vo);	
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
    
    /**
     * ESM_COA_9000 : BKG 소급 리스트 조회<br>
	 * 
	 * @param BkgSokeupVO bkgSokeupVO
	 * @return List<BkgSokeupVO>
	 * @exception EventException
	 * @author SJH.20140818.ADD
     */
	@SuppressWarnings("unchecked")
	public List<BkgSokeupVO> searchBkgSokeupStatus(BkgSokeupVO bkgSokeupVO) throws EventException {
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		List<BkgSokeupVO> list = null;		

		try {			
			rowSet = dbDao.searchBkgSokeupStatus(bkgSokeupVO);
			list = (List)RowSetUtil.rowSetToVOs(rowSet, BkgSokeupVO.class);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESM_COA_9000 : BKG 소급<br>
	 * @param BkgSokeupVO[] bkgSokeupVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author SJH.20140818.ADD
	 */
	public void manageBkgSokeup(BkgSokeupVO[] bkgSokeupVOS, SignOnUserAccount account) throws EventException{
		try {
			List<BkgSokeupVO> bkgSokeupVoList = new ArrayList<BkgSokeupVO>();
			
			String max_seq = null;
			
			max_seq = dbDao.checkMaxBatSeq();
			
			for ( int i=0; i<bkgSokeupVOS.length; i++ ) {
				  if (bkgSokeupVOS[i].getIbflag().equals("I")){
					  bkgSokeupVOS[i].setUpdUsrId(account.getUsr_id());	
					  bkgSokeupVOS[i].setCreUsrId(account.getUsr_id());
					  bkgSokeupVOS[i].setMaxSeq(max_seq);
					  bkgSokeupVoList.add(bkgSokeupVOS[i]);					
				}
			}
				dbDao.addBkgSokeupHistory(bkgSokeupVoList);
				dbDao.addBkgSokeupCalc(bkgSokeupVoList);

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}    
	
	/**
	 * [ESM_COA_4004]
	 * Mass Calculation Batch List 조회<br>
	 *
	 * @param SearchConditionVO searchVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 * @author SJH.20141117.ADD
	 */
    public CommonCoaRsVO searchBatchManagement(SearchConditionVO searchVO) throws EventException {
        try {
        	CommonCoaRsVO retVo = new CommonCoaRsVO();
			            
			retVo = dbDao.searchBatchManagement(searchVO, retVo);
            return retVo;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	

	/**
	 * [ESM_COA_4004]
	 * Simulation Batch List 조회<br>
	 *
	 * @param SearchConditionVO searchVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 * @author SJH.20141117.ADD
	 */
    public CommonCoaRsVO searchSimBatchManagement(SearchConditionVO searchVO) throws EventException {
        try {
        	CommonCoaRsVO retVo = new CommonCoaRsVO();
			            
			retVo = dbDao.searchSimBatchManagement(searchVO, retVo);
            return retVo;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }
    
	/**
	 * Target YRMON 에 대해 AverageCost 배치가 실행 되었는지 확인한다.
	 * 
	 * @param String fTargetYrMon
	 * @param String fCostTypeCd
	 * @return String
	 * @throws EventException
	 */
	public String searchAverageCostStatus(String fTargetYrMon, String fCostTypeCd) throws EventException {
		String tagetYrMonStatus ="N";
		try {
			List<CoaUtCostCreStsVO> list = dbDao.searchCostStatus(fTargetYrMon, fCostTypeCd);			
			// 돌고 있는 batch 가 있다
			if (list.size() > 0) { 
				tagetYrMonStatus = "Y";
			}		
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Average Cost BATCH STATUS CHECK ABOUT TARGET YRMON"}).getMessage(),e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return tagetYrMonStatus;
	}
	
	/**
	 * Average Cost BATCH 가 실행중인지를 check 한다.
	 * @param AverageCostVO averageCostVO
	 * @return String
	 * @throws EventException
	 */
	public String checkAverageCostCreateBatchStatus(AverageCostVO averageCostVO) throws EventException {
		String batchRunning ="C";
		try {
			List<CoaUtCostCreStsVO> list = dbDao.checkAverageCostCreateBatchStatus(averageCostVO);			
			// 돌고 있는 batch 가 있다
			if (list.size() > 0) { 
//				batchRunning = "P";
				batchRunning = list.get(0).getCostCreStsCd();		//20150817.MOD
			}		
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Average Cost BATCH STATUS CHECK"}).getMessage(),e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return batchRunning;
	}
	
	/**
	 * Average Cost BATCH status 를 생성한다. <br>
	 * 
	 * @param AverageCostVO averageCostVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAverageCostStatus(AverageCostVO averageCostVO, SignOnUserAccount account) throws EventException{
		try{
			// shipper 를 user id 담기 위해 사용
			averageCostVO.setUsrId(account.getUsr_id());
			dbDao.modifyAverageCostStatus(averageCostVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
    
	/**
	 * Week 단위로 Average Cost BATCH 를 수행한다. <br>
	 * 
	 * @param AverageCostVO averageCostVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createAverageCost(AverageCostVO averageCostVO, SignOnUserAccount account) throws EventException {	
		ScheduleUtil su = new ScheduleUtil();
        String params = "";
		
		try {
			averageCostVO.setUsrId(account.getUsr_id());					//20150605.ADD
			params = dbDao.searchAverageCostParam(averageCostVO);
			log.debug("params=========== : "+params);
			su.directExecuteJob("ESM_COA_B011",params);

		} catch (IOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Average Cost Creation"}).getMessage(),e);
		} catch (InterruptedException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Average Cost Creation"}).getMessage(),e);
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Average Cost Creation"}).getMessage(),e);
		} catch (Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Average Cost Creation"}).getMessage(),e);
		}
		return "R";//실행 성공
	}	
}