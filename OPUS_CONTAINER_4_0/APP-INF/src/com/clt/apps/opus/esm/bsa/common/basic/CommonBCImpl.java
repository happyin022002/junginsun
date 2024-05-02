/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COACommonBCImpl.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-18
*@LastModifier : eunju park
*@LastVersion : 1.0
* 2006-08-25 eunju park
* 1.0 최초 생성
* 2009.02 박은주 Project : Lane Simulation System 개선 요청
* 2009.03.26 박은주 : 품질검토결과 수정사항 반영  
* 2010.06.21 이행지  - CHM-201004175 : 소스품질검토결과 적용(20100503)
* 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
=========================================================*/
package com.clt.apps.opus.esm.bsa.common.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.esm.bsa.common.integration.CommonDBDAO;
import com.clt.apps.opus.esm.bsa.common.vo.ComboVO;
import com.clt.apps.opus.esm.bsa.common.vo.GetCodeSelectVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.layer.basic.BasicCommandSupport;


/**
 * Business Logic Basic Command implementation<br>
 * - BSA에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author eunju park
 * @see ESM_BSA_051EventResponse,LaneSimulationBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CommonBCImpl extends BasicCommandSupport implements CommonBC {

    // Database Access Object
    private transient CommonDBDAO dbDao=null;

    /**
     * LaneSimulationBCImpl 객체 생성<br>
     * LaneSimulationDBDAO를 생성한다.<br>
     */
    public CommonBCImpl(){
        dbDao = new CommonDBDAO();
    }

    /**
     * 1. 기능 : 데이터 기간을 리턴한다.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : eun-ju PARK/2006.09.18<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @param ComboVO vo
     * @return String
     * @exception EventException
     */
    public String searchDatePeriod(ComboVO vo) throws EventException {
        DBRowSet rowSet = null;							// 데이터전송을 위한 DB ResultSet
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
        } catch(Exception se){
            log.error("err "+se.toString(),se);
            throw new EventException(se.getMessage());
        }
    }

    /**
     * 1. 기능 : 전주를 리턴한다.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : eun-ju PARK/2007.03.06<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @param String year
     * @param String week
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
        }
        return rtnValue;
    }

    /**
     * 1. 기능 : Vessel sub trade 목록을 조회한다.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : eun-ju PARK/2006.10.18<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @param String vslCd
     * @param String skdVoyNo
     * @param String dirCd
     * @return    String
     * @exception EventException
     */
    public String searchFirstEtd(String vslCd,String skdVoyNo,String dirCd) throws EventException {
    	
    	try {
    		return dbDao.searchFirstEtd(vslCd, skdVoyNo, dirCd);
    	} catch (DAOException de) {
    		log.error("err "+de.toString(),de);
    		throw new EventException(de.getMessage());
    	}
    }
    
    /**
     * 1. 기능 : Vessel sub trade 목록을 조회한다.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : eun-ju PARK/2006.10.18<br>
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
    public String searchPrevWkPrd() throws EventException {
        
        try {
        	return dbDao.searchPrevWkPrd();
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
	/**
     * 1. 기능 : Location code 유무를 리턴.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : eun-ju PARK/2006.11.13<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @param     String locCd
     * @return    String
     * @exception EventException
     */
    public String checkLocationCode(String locCd) throws EventException {
        DBRowSet rowSet = null;							// 데이터전송을 위한 DB ResultSet
        String check = "";
        
        try {
            rowSet=dbDao.checkLocationCode(locCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		check = rowSet.getString(1);
//            		if(!rowSet.getString(1).equals("X")) rtnValue = true;
            	}
            }
            return check;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }

    /**
     * 1. 기능 : default combo,ibsheet codelist를 return <p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * 
     * @param codeItem  	업무 구분
	 *  					01.ServiceLane			: sLane         => mdm_vsl_svc_lane
	 *  											  sLane2(trd_cd)=> COA_LANE_RGST, Trade코드가 들어 오지 않으면 전체를 조회한다
	 *  											  sLane3(trd_cd)=> COA_LANE_RGST
	 *                                                simLane       => simulation 에서 사용하는 service lane
	 *  					02.TradeList			: trade
	 *  					03.SubTradeList			: subTrade(trd_cd)
	 *  					04.RevenuelaneList		: rLane(trd_cd) => COA_LANE_RGST (콤보 반환)
	 *  											  rLane2(trd_cd)=> COA_LANE_RGST (HashMap 반환)
	 *  											  rLane3()      => COA_LANE_RGST (콤보 반환)
	 *  					05.DirectionList		: Dir
	 *  					06.Interport/OceanList	: IOC
	 *  					07.VessellanetypeList	: laneTP
	 *  					08.vesselList	 	 	: vessel
	 *  					  .simVessel	 	 	: simVsl
	 *  					09.SimulationVesselList	: simVessel(sLane|sim_dt|sim_no)
	 *  					10.화물변동비항목	    : codeItem
	 *  					10.OP 계정과목 			: simOpAcct
	 *  					11.CarrierList		 	: Carrier
	 *  					12.OptionList(BSA)		: optBSA(삭제)
	 *  					13.COAMainGroup		 	: mnGroup
	 *  					14.COASubGroup			: subGroup(mgrp_cost_cd)
	 *  					15.VesselSubTradeList	: vslSubTrade(sub_trd_chk_flg)
	 *  					16.ECCList				: ecc([rcc_cd | lcc_cd])
	 *  					17.SCCList				: scc(ecc_cd)
	 *  					18.LOCList				: loc({ecc|ecc_cd} or {scc|scc_cd})
	 *  					19.OfficeCodeList		: office()			=> 지역본부단위의 Office Code List
	 *  											  office2(ofc_cd)   => 점소단위의 Office Code List
	 *                      20. Container Type Size : tpSz
	 *                      21. vessel capa List    : vslCapa
	 *                      22. Currency List       : currency
	 *                      23. Port Class List     : PortClass
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
	 *                      47. Report view     	: rptAuth(공통코드에서 관라하는 코드[CD00939][CD00940][CD00941])
	 *                      48. All Office Level	: allOFCLevel(ofc_lvl)	
	 *                      49. sub office code		: office3(ofc_cd|ofc_lvl|selected ofc_lvl)
	 *                      50. coaCode				: coaCode(subGrp) ==> 해당 서브그룹코트에 해당하는 stnd_cost_cd
	 *                      51. lgsKPI				: Lobistics KPI               
	 *                      53. costTableTpsz		: Cost Table Container Type Size RD2->R2, RD4->R4
	 *                      54. key Account 		: keyAcc
	 *                      55. tmlCd				: coa_inter_tml_if_mgmt 테이블의 terminal 코드
	 *                      56. LOGISTICT RHQ       : lgsRHQ (logistics 에서 사용하는 RHQ)
	 *                      57. Simulatin Vsl Class : simVslCls()
	 *                      59. Original TPSZ : ORITPSZ
	 *                      60. AllOffice           : AllOffice - Pre CM에서 사용하는 OFFICE CODE
	 *                      61. Other Commission Location : Agency Other Commission에서 사용하는 Location
	 *                      62. SMU Sub Trade 		: SMU에서 사용하는 Sub Trade, Trunk IPC 제외
	 *                      63. EMU POD ECC 		: EMU POD 단가에 사용하는 ECC (Port만 Inland ECC 제외)
	 *                      64. simulation dept     : dept(code) - Simulation에서사용하는 dept code
	 *                                            
	 *                      
     * @param codeItem      	Where절에 들어갈 코드그룹
     * @param code      	    Where절에 들어갈 코드조건값
     * @return List<GetCodeSelectVO>
     * @throws EventException
     */
    @SuppressWarnings("unchecked")
	public List<GetCodeSelectVO> getCodeSelectList(String codeItem, String code) throws EventException {
    	List<GetCodeSelectVO> list = new ArrayList<GetCodeSelectVO>();
    	DBRowSet dRs = null;
	        try {	        	
	        	if(codeItem.equalsIgnoreCase("trade")){				     // 2. Trade List
	        		dRs = dbDao.searchTradeList();
	        	}else if(codeItem.equalsIgnoreCase("subTrade")){		 // 3. Sub Trade List
	        		dRs = dbDao.searchSubTradeList(code);
	        	}else if(codeItem.equalsIgnoreCase("rLane")){			 // 4. Revenue lane List
	        		dRs = dbDao.searchRevLaneList(code);
	        	}else if(codeItem.equalsIgnoreCase("rLane4")){			
	        		dRs = dbDao.searchRLaneList4(code);
	        	}else if(codeItem.equalsIgnoreCase("carrier")){
	        		if( code == null || code.equals("")){
	        			code = "J"; // Joint Operation
	        		}
	        		dRs = dbDao.searchCarrierRgstBSA(code);
	        	}else if(codeItem.equalsIgnoreCase("ui")){
	        		dRs = dbDao.searchUI(code);
	        	}
	        	else{
        	    //공통코드	
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
     * 기능 : default combo,ibsheet codelist를 return <p>
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
	    	 	    combovo.setCode("All");
	    			list.add(0,combovo);
	    		} else if (array[i][2].equals("Blank")){
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
     * 
     * @param code
     * @return
     * @throws EventException
     */
    public String searchIBCodeList(String code) throws EventException {
	    DBRowSet rowSet = null;
        String rtnString = "";
        
        try {
        	if(!code.equals("")){
	            rowSet=dbDao.searchRevLaneList(code);
	            if(rowSet!=null) {
	            	while(rowSet.next()){
	            		if(!rowSet.getString(1).equals(""))rtnString = rtnString+"|"+rowSet.getString(1);
	            	}
	            }
        	}
            return rtnString;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }
    
    /**
     * 
     * @return String
     * @throws EventException
     */
    public String searchBSAOpt() throws EventException {
	    DBRowSet rowSet = null;
        String code = "";
        String name = "";
        String rtnString = "";
        
        try {
            rowSet=dbDao.searchBSAOpt();
            if(rowSet!=null) {
            	while(rowSet.next()){
            		if(!rowSet.getString(1).equals(""))code = code+rowSet.getString(1)+"|";
            		if(!rowSet.getString(2).equals(""))name = name+rowSet.getString(2)+"|";
            	}
            }
            rtnString = code + "|$$|"+name;
            return rtnString;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }
    
    /**
     * @param  String code
     * @return HashMap<String, String>
     * @throws EventException
     */
    public HashMap<String, String> getCodeIBCombo(String code) throws EventException {
    	HashMap<String, String> hMap = new HashMap<String, String>();
		String key = "";
		String tmp = "";
		StringBuffer sbText = new StringBuffer();
    	DBRowSet rowSet = null;
    	try {
    		if(code.equals("rLane4")){
    			rowSet = dbDao.searchRLaneList4("");
    		}
    		
    		if(rowSet != null){									//SJH.20150508.소스품질
        		while(rowSet.next()){
        			key = rowSet.getString("KEY");
        			if( !tmp.equals("") && !key.equals(tmp)){
        				sbText = new StringBuffer();
        			}
        			sbText.append("|");
        			sbText.append(rowSet.getString("CODE"));

    				hMap.put(key, sbText.toString());
    				tmp = key;
        		}    			
    		}
    	} catch (DAOException de) {
	    	log.error("DAOException : " +de.getMessage());
	    	throw new EventException("DAOException : " + de.getMessage());
	    } catch(Exception ex){
	    	log.error("Exception : " +ex.getMessage());
	    	throw new EventException("Exception : " + ex.getMessage());
	    }
    	return hMap;
    }
}