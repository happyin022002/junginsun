/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : LaneSimulationBCImpl.java
*@FileTitle : 항로 Simulation 마스터 및 W/F 생성/조회/변경
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-25
*@LastModifier : eunju park
*@LastVersion : 1.0
* 2006-08-25 eunju park
* 1.0 최초 생성
* 2009.03.31 박은주,박상희 S2K-09U-002(Lane Simulation System 개선)
* 2009.06.15 배진환 N200905220060 Lane Simulation System 수정사항
* 2010.02.05 임옥영 소스품질검토 결과 반영 (지역변수 소문자로 시작하게, multiSimGrpbProj의 CtrbMgnCostList->ctrbMgnCostList)
*                   주석들 변경 
* 2010.02.09 임옥영 소스품질검토 결과 반영Line No. 2316 :  : shall be matched with size of parameter
* 2010.02.18 윤진영 소스품질검토 결과 반영 (사용하지 않는 변수 삭제)
* 2010.10.08 박은주 CHM-201006307 Session 정보 변경 및 프로그램 오류수정
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
* 2011.07.13 최성민 [CHM-201111826] R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.mas.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.mas.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.integration.LaneSimulationDBDAO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.CreateSimDailyHireVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.LaneInfoListConditionVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.MergyVolProjConditionVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.MultiSimSummaryRptVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchBSAbyVVDListConditionVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchBSAbyVVDListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchFileMgmtListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchLaneInfoListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchReportConditionVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimBunkerListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimConditionVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimContiPairListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimDailyHireInfoVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimLaneListConditionVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimLaneListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimLaneRPBListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimPortChargeListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimPortListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimReportMasterListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimRtnRowSetVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimVesselListConditionVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimVesselListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimYardConditionVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimYardListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchTMLOPDysListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchTocHireListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchTsVolumeVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchVesselInfoConditionVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchVesselInfoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MasBnkCsmVO;
import com.hanjin.syscommon.common.table.MasSimBnkCostVO;
import com.hanjin.syscommon.common.table.MasSimCtrbMgnCostVO;
import com.hanjin.syscommon.common.table.MasSimDlyHirVO;
import com.hanjin.syscommon.common.table.MasSimInfoVO;
import com.hanjin.syscommon.common.table.MasSimIntrTrnsVolVO;
import com.hanjin.syscommon.common.table.MasSimNonOpExpnVO;
import com.hanjin.syscommon.common.table.MasSimPortChgVO;
import com.hanjin.syscommon.common.table.MasSimTmlInfoVO;
import com.hanjin.syscommon.common.table.MasTmChtrOutHirVO;
import com.hanjin.syscommon.common.table.VskPfSkdVO;

/**
 * ALPS-MAS Business Logic Basic Command implementation<br>
 * - ALPS-MAS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author 윤진영
 * @see LaneSimulationBC 각 LaneSimulationDBDAO 클래스 참조
 * @since J2EE 1.4
 */
public class LaneSimulationBCImpl extends BasicCommandSupport implements LaneSimulationBC {

    // Database Access Object
    private transient LaneSimulationDBDAO dbDao=null;

    /**
     * LaneSimulationBCImpl 객체 생성<br>
     * LaneSimulationDBDAO를 생성한다.<br>
     */
    public LaneSimulationBCImpl(){
        dbDao = new LaneSimulationDBDAO();
    }


    /**
     * 1. 기능 : sheet1조회 이벤트 처리(ESM_MAS_0051)<p>
     * 2. 처리개요 : <p>
     *    - Lane Info I/F : MDM의 Lane 정보 및 P/F SKD의 frequency 정보 I/F
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : park sang hee/2009.02.18<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @param LaneInfoListConditionVO laneInfoListConditionVO
     * @return List<SearchLaneInfoListVO>
     * @exception EventException
     */
    public List<SearchLaneInfoListVO> searchLaneInfoList(LaneInfoListConditionVO laneInfoListConditionVO) throws EventException {
        try {
        	return dbDao.searchLaneInfoList(laneInfoListConditionVO);
        }  	
        catch(DAOException ex) {
        	log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler(ex).getMessage());
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler(ex).getMessage());
    	}
    		
    }
    /**
     * 1. 기능 : master sheet조회 이벤트 처리(ESM_MAS_0051)<p>
     * 2. 처리개요 : <p>
     *    - LaneSimulation master에 대한 리스트를 조회
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : eun-ju PARK/2006.08.28<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @param SearchSimLaneListConditionVO searchSimLaneListConditionVO
     * @return List<SearchSimLaneListVO>
     * @exception EventException
     */
    public List<SearchSimLaneListVO> searchSimLaneList(SearchSimLaneListConditionVO searchSimLaneListConditionVO) throws EventException {
        try {
            return dbDao.searchSimLaneList(searchSimLaneListConditionVO);
        } catch(DAOException ex) {
        	log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler(ex).getMessage());
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler(ex).getMessage());
    	}
    }
    /**
     * 1. 기능 : master sheet 삭제 이벤트 처리<p>
     * 2. 처리개요 :  <p>
     *    - ESM_MAS_0051 화면에 대한 멀티 이벤트 처리<br>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : parkeunju/2006.08.28<br>
     * ===================================<br>
     * 5. 수정사항<p> EsmMas0051EventResponse("","SUCCESS");
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>parksanghee/2009.02.13
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @param SearchSimLaneListConditionVO[] searchSimLaneListConditionVO
     * @exception EventException
     */
    public void removeSimLane(SearchSimLaneListConditionVO[] searchSimLaneListConditionVO) throws EventException{
        try {
        	for ( int i=0; i<searchSimLaneListConditionVO.length; i++ ) {
        		dbDao.removeSimLane(searchSimLaneListConditionVO[i]);
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
     * 1. 기능 : master sheet 멀티 이벤트 처리<p>
     * 2. 처리개요 :  <p>
     *    - ESM_MAS_0051 화면에 대한 멀티 이벤트 처리<br>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : parkeunju/2006.08.28<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @param SearchSimLaneListVO[] searchSimLaneListVO
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String multiSimLane(SearchSimLaneListVO[] searchSimLaneListVO, SignOnUserAccount account) throws EventException{
        CommonBC command = new CommonBCImpl();
        DBRowSet rowSet = null;
        int updNo = 0;
        String newLane = "N";
        String sim_no = "";
        String slan_cd = "";
        String sim_dt = "";
        String dept_cd = "";
        String return_val = "";
        try {
        	slan_cd = JSPUtil.getNull(searchSimLaneListVO[0].getSlanCd());
        	sim_dt  = JSPUtil.getNull(searchSimLaneListVO[0].getSimDt().replaceAll("-",""));
        	dept_cd = JSPUtil.getNull(searchSimLaneListVO[0].getDeptCd());
			sim_no  = JSPUtil.getNull(searchSimLaneListVO[0].getSimNo());

        	rowSet = dbDao.searchSimulationNo(sim_dt,sim_no); //UPDATE와 INSERT(신규) 구분하기 위해
        	for ( int i=0; i<searchSimLaneListVO .length; i++ ) {
				if ( searchSimLaneListVO[i].getIbflag().equals("I")){
		        	if(sim_no.equals("")){ 
		    	        sim_no = command.searchMaxSimNo();
		        	} 
					searchSimLaneListVO[i].setCreUsrId(account.getUsr_id());
					searchSimLaneListVO[i].setUpdUsrId(account.getUsr_id());
		        	searchSimLaneListVO[i].setSimNo(sim_no);
		        	searchSimLaneListVO[i].setSimDt(sim_dt);
		        	searchSimLaneListVO[i].setSlanCd(slan_cd);
		        	searchSimLaneListVO[i].setDeptCd(dept_cd);
		        	if(rowSet.getRowCount()==0 && i==0){ //master table 입력은 한번만 진행 
		        		newLane = "N";
		        		newLane = dbDao.searchSLane2(slan_cd); //신규 LANE 판별 위해        
		        		searchSimLaneListVO[i].setExtdLaneFlg(newLane);
		        		dbDao.addSimLane(searchSimLaneListVO[i]); //MAS_SIM_INFO 머지
		        	}
		        	dbDao.addmultiSimLane(searchSimLaneListVO[i]); // detail table 다수 입력가능 MAS_SIM_SVC_LANE INSERT
				} else if ( searchSimLaneListVO[i].getIbflag().equals("U")){
					searchSimLaneListVO[i].setUpdUsrId(account.getUsr_id());
					searchSimLaneListVO[i].setSimNo(sim_no);
		        	searchSimLaneListVO[i].setSimDt(sim_dt);
		        	searchSimLaneListVO[i].setSlanCd(slan_cd);
		        	searchSimLaneListVO[i].setDeptCd(dept_cd);
					if(rowSet.getRowCount()>0 && updNo==0){ //master table 수정은 한번만 진행
						newLane = searchSimLaneListVO[i].getExtdLaneFlg();
		        		dbDao.addSimLane(searchSimLaneListVO[i]);
		        		updNo++;
		        	}
					dbDao.modifymultiSimLane(searchSimLaneListVO[i]); // detail table 다수수정가능
				}
        	}
            return_val = newLane + "|" +sim_no;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return return_val;
    }
    /**
     * 1. 기능 : detail sheet 조회 이벤트 처리(ESM_MAS_0051)<p>
     * 
     * @param SearchSimVesselListConditionVO searchSimVesselListConditionVO
     * @return List<SearchSimVesselListVO>
     * @exception EventException
     */
    
    public List<SearchSimVesselListVO> searchSimVesselList(SearchSimVesselListConditionVO searchSimVesselListConditionVO) throws EventException {
        try {
            return dbDao.searchSimVesselList(searchSimVesselListConditionVO);
        } catch(DAOException ex) {
        	log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler(ex).getMessage());
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler(ex).getMessage());
    	}
    }

    /**
     * 1. 기능 : detail sheet 조회 이벤트 처리<p>
     *
     * @param SearchVesselInfoConditionVO searchVesselInfoConditionVO
     * @return List<SearchVesselInfoVO>
     * @exception EventException
     */
    public List<SearchVesselInfoVO> searchVesselInfo(SearchVesselInfoConditionVO searchVesselInfoConditionVO) throws EventException {

    	String flag    = "";
    	String tradeCd = "";
    	String trade   = "";
    	String sRow    = "";
    	List<SearchVesselInfoVO> retList = new ArrayList<SearchVesselInfoVO>();
    	try {
    		flag  = JSPUtil.getNull(searchVesselInfoConditionVO.getFlag());
    		trade = JSPUtil.getNull(searchVesselInfoConditionVO.getTrdCd());
    		sRow  = JSPUtil.getNull(searchVesselInfoConditionVO.getSrow());
    		if(flag.equals("subTrade")) {
    			//tradeCd = ComboUtil.getIBCodeCombo("subTrade", "", "", "subTrade", trade, "code", "");
    			CommonBC commonBC = new CommonBCImpl();
    			tradeCd = commonBC.getIbCodeCombo("subTrade", "subTrade", trade, "code");
    			
    			SearchVesselInfoVO retVo = new SearchVesselInfoVO();
    			retVo.setTradeCd(tradeCd);
    			retVo.setProcgb("single");
    			retVo.setSrow(sRow);
    			retList.add(retVo);
    		} else {
    			retList = dbDao.searchVesselInfo(searchVesselInfoConditionVO);
    		}
        	return retList;
        } catch(DAOException ex) {
        	log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler(ex).getMessage());
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler(ex).getMessage());
    	}
    }
    /**
     * 1. 기능 : detail sheet 멀티 이벤트 처리<p>
     * 
     * @param SearchSimVesselListVO[] searchSimVesselListVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void multiSimVesselInfo(SearchSimVesselListVO[] searchSimVesselListVO, SignOnUserAccount account) throws EventException{
    	String ibflag = "";
    	String vsl_flg = "";
    	String vsl_cd = "";

    	boolean isDelete = false; // 한번만 delete처리 하기 위한 flag
    	boolean isUpdate = false; // 한번만 update처리 하기 위한 flag
    	try {
    		//MAS_SIM_VSL_INFO의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정)<br>
    		
    		String sim_no="";
    		String sim_dt="";
    		String sect_no="";
    		
    		if(searchSimVesselListVO.length > 0) {
    			sim_no = JSPUtil.getNull(searchSimVesselListVO[0].getSimNo());
    			sim_dt = JSPUtil.getNull(searchSimVesselListVO[0].getSimDt());
    			sect_no =JSPUtil.getNull(searchSimVesselListVO[0].getSectNo()); 
    		}
    		for(int i=0;i<searchSimVesselListVO.length-1;i++) {
    			ibflag = JSPUtil.getNull(searchSimVesselListVO[i].getIbflag());
    			vsl_flg = JSPUtil.getNull(searchSimVesselListVO[i].getVslFlg());
    			vsl_cd = JSPUtil.getNull(searchSimVesselListVO[i].getVslCd());
    			SearchSimVesselListVO retVo = new SearchSimVesselListVO();
				retVo = searchSimVesselListVO[i];
				// Y : 신규, N : 기존
    			if (vsl_flg.equals("Y") && !vsl_cd.equals("XXXX")) {
    				retVo.setUserId(account.getUsr_id());
    				dbDao.addSimVslInfo(searchSimVesselListVO[i]);  //MAS_SIM_VSL_RGST INSERT
    			} else if(ibflag.equals("U")) {
    				retVo.setUserId(account.getUsr_id());
    				dbDao.modifySimVslInfo(searchSimVesselListVO[i]); //MAS_SIM_VSL_RGST UPDATE
    			}
    		}
    		SearchSimVesselListVO retVo3 = new SearchSimVesselListVO(); //update 용
    		for(int k=0;k<searchSimVesselListVO.length;k++) {
    			SearchSimVesselListVO retVo1 = new SearchSimVesselListVO(); //delete,insert1 용
    			SearchSimVesselListVO retVo2 = new SearchSimVesselListVO(); //insert2 용
    			retVo1 = searchSimVesselListVO[k];
    			retVo2 = searchSimVesselListVO[k];
    			retVo3 = searchSimVesselListVO[k];
    		
    			if(!isDelete) {
    				isDelete = true;
    				dbDao.deleteSimVesselInfo(retVo1);
    				if(searchSimVesselListVO[k].getIbflag().equals("D")) {
    					dbDao.deleteSimVesselInfo2(retVo1);
    				}
    			}
    			if(!retVo1.getIbflag().equals("D")) {
    				if(retVo1.getSimDivCd().equals("2")) {
    					retVo1.setVslCd("XXXX");
    					retVo1.setVslClssCapa("");
    					retVo1.setVopCd("");
    					retVo1.setVslCapa("");
    					retVo1.setBsaCapa("");
    					retVo1.setFnlHjsBsaCapa("");
    					retVo1.setLdfRto("");
    				} else {
    					retVo1.setLdfRto(String.valueOf(Float.parseFloat(searchSimVesselListVO[k].getLdfRto().equals("")?"0":searchSimVesselListVO[k].getLdfRto())/100));
    				}
    				retVo1.setUserId(account.getUsr_id());
    				retVo1.setSimDt(sim_dt);
    				retVo1.setSimNo(sim_no);
    				retVo1.setSectNo(sect_no);
    				dbDao.insertSimVesselInfo(retVo1);
    				if(retVo2.getSimDivCd().equals("2")) {
						for(int x=0;x<searchSimVesselListVO.length;x++) {
							retVo2 = searchSimVesselListVO[x];
							if(retVo2.getSimDivCd().equals("1") && !retVo2.getIbflag().equals("D")) {
								retVo2.setSimDivCd("3");
								// 2010.01.14 LF 값세팅중  100 으로 나누는 부분을 제외
								retVo2.setLdfRto(String.valueOf((Float.parseFloat(retVo2.getLdfRto()))));
								if(retVo2.getVopCd().equals("SML")) {
									retVo2.setHjsBfrBsaCapa("0");
									retVo2.setOtrCrrBsaCapa1(String.valueOf((Float.parseFloat(retVo2.getOtrCrrBsaCapa1().equals("")?"0":retVo2.getOtrCrrBsaCapa1()) * Float.parseFloat(retVo2.getOtrCrrBsaCapa1().equals("")?"0":retVo2.getOtrCrrBsaCapa1()))));
									retVo2.setOtrCrrBsaCapa1(String.valueOf((Float.parseFloat(retVo2.getOtrCrrBsaCapa2().equals("")?"0":retVo2.getOtrCrrBsaCapa2()) * Float.parseFloat(retVo2.getOtrCrrBsaCapa2().equals("")?"0":retVo2.getOtrCrrBsaCapa2()))));
									retVo2.setOtrCrrBsaCapa1(String.valueOf((Float.parseFloat(retVo2.getOtrCrrBsaCapa3().equals("")?"0":retVo2.getOtrCrrBsaCapa3()) * Float.parseFloat(retVo2.getOtrCrrBsaCapa3().equals("")?"0":retVo2.getOtrCrrBsaCapa3()))));
									retVo2.setOtrCrrBsaCapa1(String.valueOf((Float.parseFloat(retVo2.getOtrCrrBsaCapa4().equals("")?"0":retVo2.getOtrCrrBsaCapa4()) * Float.parseFloat(retVo2.getOtrCrrBsaCapa4().equals("")?"0":retVo2.getOtrCrrBsaCapa4()))));
									retVo2.setOtrCrrBsaCapa1(String.valueOf((Float.parseFloat(retVo2.getOtrCrrBsaCapa5().equals("")?"0":retVo2.getOtrCrrBsaCapa5()) * Float.parseFloat(retVo2.getOtrCrrBsaCapa5().equals("")?"0":retVo2.getOtrCrrBsaCapa5()))));
								} else {
									retVo2.setHjsBfrBsaCapa(String.valueOf((Float.parseFloat(retVo2.getHjsBfrBsaCapa().equals("")?"0":retVo2.getHjsBfrBsaCapa()) * Float.parseFloat(retVo2.getHjsBfrBsaCapa().equals("")?"0":retVo2.getHjsBfrBsaCapa()))));
									retVo2.setOtrCrrBsaCapa1("0");
									retVo2.setOtrCrrBsaCapa2("0");
									retVo2.setOtrCrrBsaCapa3("0");
									retVo2.setOtrCrrBsaCapa4("0");
									retVo2.setOtrCrrBsaCapa5("0");
								}
								retVo2.setSubLseCapa1(String.valueOf((Float.parseFloat(retVo2.getSubLseCapa1().equals("")?"0":retVo2.getSubLseCapa1()) * Float.parseFloat(retVo2.getSubLseCapa1().equals("")?"0":retVo2.getSubLseCapa1()))));
								retVo2.setSubLseCapa2(String.valueOf((Float.parseFloat(retVo2.getSubLseCapa2().equals("")?"0":retVo2.getSubLseCapa2()) * Float.parseFloat(retVo2.getSubLseCapa2().equals("")?"0":retVo2.getSubLseCapa2()))));
								retVo2.setSubLseCapa3(String.valueOf((Float.parseFloat(retVo2.getSubLseCapa3().equals("")?"0":retVo2.getSubLseCapa3()) * Float.parseFloat(retVo2.getSubLseCapa3().equals("")?"0":retVo2.getSubLseCapa3()))));
								retVo2.setSubLseCapa4(String.valueOf((Float.parseFloat(retVo2.getSubLseCapa4().equals("")?"0":retVo2.getSubLseCapa4()) * Float.parseFloat(retVo2.getSubLseCapa4().equals("")?"0":retVo2.getSubLseCapa4()))));
								retVo2.setSubLseCapa5(String.valueOf((Float.parseFloat(retVo2.getSubLseCapa5().equals("")?"0":retVo2.getSubLseCapa5()) * Float.parseFloat(retVo2.getSubLseCapa5().equals("")?"0":retVo2.getSubLseCapa5()))));
								retVo2.setSubChtrCapa1(String.valueOf((Float.parseFloat(retVo2.getSubChtrCapa1().equals("")?"0":retVo2.getSubChtrCapa1()) * Float.parseFloat(retVo2.getSubChtrCapa1().equals("")?"0":retVo2.getSubChtrCapa1()))));
								retVo2.setSubChtrCapa2(String.valueOf((Float.parseFloat(retVo2.getSubChtrCapa2().equals("")?"0":retVo2.getSubChtrCapa2()) * Float.parseFloat(retVo2.getSubChtrCapa1().equals("")?"0":retVo2.getSubChtrCapa2()))));
								retVo2.setSubChtrCapa3(String.valueOf((Float.parseFloat(retVo2.getSubChtrCapa3().equals("")?"0":retVo2.getSubChtrCapa3()) * Float.parseFloat(retVo2.getSubChtrCapa1().equals("")?"0":retVo2.getSubChtrCapa3()))));
								retVo2.setSubChtrCapa4(String.valueOf((Float.parseFloat(retVo2.getSubChtrCapa4().equals("")?"0":retVo2.getSubChtrCapa4()) * Float.parseFloat(retVo2.getSubChtrCapa1().equals("")?"0":retVo2.getSubChtrCapa4()))));
								retVo2.setSubChtrCapa5(String.valueOf((Float.parseFloat(retVo2.getSubChtrCapa5().equals("")?"0":retVo2.getSubChtrCapa5()) * Float.parseFloat(retVo2.getSubChtrCapa1().equals("")?"0":retVo2.getSubChtrCapa5()))));
								retVo2.setUserId(account.getUsr_id());
								retVo2.setSimDt(sim_dt);
								retVo2.setSimNo(sim_no);
								retVo2.setSectNo(sect_no);
								dbDao.insertSimVesselInfo(retVo2);
							}//end if
						} //end for
    				} //end if
    				if(!isUpdate) {
    					isUpdate=true;
    				}
    			} //end if
    		} //end for

    		// 2010.01.14 해당 부분은 변경된 사항이 있을 경우 모든 사항이 적용후 처리되어야 함
    		if(isUpdate){
    			dbDao.updateSimVesselInfo(retVo3);
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
     * Step1에서 Continent Pair 정보를 조회한다.
     * 
     * @param SearchSimContiPairListVO searchSimContiPairListVO
     * @return List<SearchSimContiPairListVO>
     * @exception EventException
     */
    public List<SearchSimContiPairListVO> searchSimContiPairList(SearchSimContiPairListVO searchSimContiPairListVO) throws EventException {
        try {
            return dbDao.searchSimContiPairList(searchSimContiPairListVO);
        } catch(DAOException ex) {
         	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }
    
    /**
     * Step1 에서 Continent Pair 정보릉 입력/수정/삭제한다.
     * 
     * @param SearchSimContiPairListVO[] searchSimContiPairListVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void multiSimContiPair(SearchSimContiPairListVO[] searchSimContiPairListVO,SignOnUserAccount account) throws EventException{
       	try {
       		String ibflag = "";
       		for(int i=0;i<searchSimContiPairListVO.length;i++) {
       			ibflag = JSPUtil.getNull(searchSimContiPairListVO[i].getIbflag());
       			if (ibflag.equals("I")) {
       				searchSimContiPairListVO[i].setCreUsrId(account.getUsr_id());
       				searchSimContiPairListVO[i].setUpdUsrId(account.getUsr_id());       				
       				dbDao.addSimContiPairList(searchSimContiPairListVO[i]);
       			} else if(ibflag.equals("U")) {
       				searchSimContiPairListVO[i].setUpdUsrId(account.getUsr_id());
       				dbDao.modifySimContiPairList(searchSimContiPairListVO[i]);
       			} else if(ibflag.equals("D")) {
       				dbDao.deleteSimContiPairList(searchSimContiPairListVO[i]);
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
	 * 1. 기능 : Step1 :IAS T/S Volume 팝업화면 정보를 조회한다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchTsVolumeVO>
	 * @exception EventException
	 */
    public List<SearchTsVolumeVO> searchTsVolumeList(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchSimTsVolumeList(searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 1. 기능 : Step1 :IAS T/S Volume 팝업화면 정보를 변경한다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SearchTsVolumeVO[] searchTsVolumeVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
    public void multiTsVolume(SearchConditionVO searchConditionVO,SearchTsVolumeVO[] searchTsVolumeVO,SignOnUserAccount account) throws EventException {
		try {
			List<MasSimIntrTrnsVolVO> insertVoList = new ArrayList<MasSimIntrTrnsVolVO>();
			List<MasSimIntrTrnsVolVO> updateVoList = new ArrayList<MasSimIntrTrnsVolVO>();
			List<MasSimIntrTrnsVolVO> deleteVoList = new ArrayList<MasSimIntrTrnsVolVO>();
			for ( int i=0; i<searchTsVolumeVO.length; i++ ) {
				if ( searchTsVolumeVO[i].getIbflag().equals("I")){
					MasSimIntrTrnsVolVO vo = new MasSimIntrTrnsVolVO();
					
					vo.setSimDt(searchConditionVO.getFSimDt().replace("-", ""));
					vo.setSimNo(searchConditionVO.getFSimNo());
					vo.setSkdDirCd("E");
					vo.setVslCd(searchTsVolumeVO[i].getVslCd());
					vo.setVslTrnsQty(searchTsVolumeVO[i].getEQty());
					vo.setIocCd(searchTsVolumeVO[i].getIocCd());
					vo.setCreUsrId(account.getUsr_id());
					vo.setUpdUsrId(account.getUsr_id());
					insertVoList.add(vo);
					
					MasSimIntrTrnsVolVO vo2 = new MasSimIntrTrnsVolVO();
					vo2.setSimDt(searchConditionVO.getFSimDt().replace("-", ""));
					vo2.setSimNo(searchConditionVO.getFSimNo());
					vo2.setSkdDirCd("W");
					vo2.setVslCd(searchTsVolumeVO[i].getVslCd());
					vo2.setVslTrnsQty(searchTsVolumeVO[i].getWQty());
					vo2.setIocCd(searchTsVolumeVO[i].getIocCd());
					vo2.setCreUsrId(account.getUsr_id());
					vo2.setUpdUsrId(account.getUsr_id());
					insertVoList.add(vo2);

				} else if ( searchTsVolumeVO[i].getIbflag().equals("U")){
					MasSimIntrTrnsVolVO vo = new MasSimIntrTrnsVolVO();
					
					vo.setSimDt(searchConditionVO.getFSimDt().replace("-", ""));
					vo.setSimNo(searchConditionVO.getFSimNo());
					vo.setSkdDirCd("E");
					vo.setVslCd(searchTsVolumeVO[i].getVslCd());
					vo.setVslTrnsQty(searchTsVolumeVO[i].getEQty());
					vo.setIocCd(searchTsVolumeVO[i].getIocCd());
					vo.setCreUsrId(account.getUsr_id());
					vo.setUpdUsrId(account.getUsr_id());
					updateVoList.add(vo);
					
					MasSimIntrTrnsVolVO vo2 = new MasSimIntrTrnsVolVO();
					vo2.setSimDt(searchConditionVO.getFSimDt().replace("-", ""));
					vo2.setSimNo(searchConditionVO.getFSimNo());
					vo2.setSkdDirCd("W");
					vo2.setVslCd(searchTsVolumeVO[i].getVslCd());
					vo2.setVslTrnsQty(searchTsVolumeVO[i].getWQty());
					vo2.setIocCd(searchTsVolumeVO[i].getIocCd());
					vo2.setCreUsrId(account.getUsr_id());
					vo2.setUpdUsrId(account.getUsr_id());
					updateVoList.add(vo2);
				} else if ( searchTsVolumeVO[i].getIbflag().equals("D")){
					MasSimIntrTrnsVolVO vo = new MasSimIntrTrnsVolVO();
					vo.setSimDt(searchConditionVO.getFSimDt().replace("-", ""));
					vo.setSimNo(searchConditionVO.getFSimNo());
					vo.setVslCd(searchTsVolumeVO[i].getVslCd());
					deleteVoList.add(vo);
				}
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiSimTsVolumeS(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiSimTsVolumeS(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiSimTsVolumeS(deleteVoList);
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
	 * 1. 기능 : Step1 : Non Operating Expense 팝업화면 정보를 조회한다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<MasSimNonOpExpnVO>
	 * @exception EventException
	 */
    public List<MasSimNonOpExpnVO> searchNonOpExpnList(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchNonOpExpnList(searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 1. 기능 : Step1 : Non Operating Expense 팝업화면 정보를 변경한다.<br>
	 * 
	 * @param MasSimNonOpExpnVO[] masSimNonOpExpnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
    public void multiNonOpExpn(MasSimNonOpExpnVO[] masSimNonOpExpnVO,SignOnUserAccount account) throws EventException {
		try {
			List<MasSimNonOpExpnVO> insertVoList = new ArrayList<MasSimNonOpExpnVO>();
			List<MasSimNonOpExpnVO> updateVoList = new ArrayList<MasSimNonOpExpnVO>();
			List<MasSimNonOpExpnVO> deleteVoList = new ArrayList<MasSimNonOpExpnVO>();
			for ( int i=0; i<masSimNonOpExpnVO.length; i++ ) {
				if ( masSimNonOpExpnVO[i].getIbflag().equals("I")){
					MasSimNonOpExpnVO vo = new MasSimNonOpExpnVO();
					vo.setCostYrmon(masSimNonOpExpnVO[0].getCostYrmon());
					vo.setVslCd(masSimNonOpExpnVO[i].getVslCd());
					vo.setUcAmt(masSimNonOpExpnVO[i].getUcAmt());
					vo.setCreUsrId(account.getUsr_id());
					vo.setUpdUsrId(account.getUsr_id());
					insertVoList.add(vo);
				} else if ( masSimNonOpExpnVO[i].getIbflag().equals("U")){
					MasSimNonOpExpnVO vo = new MasSimNonOpExpnVO();
					vo.setCostYrmon(masSimNonOpExpnVO[0].getCostYrmon());
					vo.setVslCd(masSimNonOpExpnVO[i].getVslCd());
					vo.setUcAmt(masSimNonOpExpnVO[i].getUcAmt());
					vo.setCreUsrId(account.getUsr_id());
					vo.setUpdUsrId(account.getUsr_id());
					updateVoList.add(vo);
				} else if ( masSimNonOpExpnVO[i].getIbflag().equals("D")){
					MasSimNonOpExpnVO vo = new MasSimNonOpExpnVO();					
					vo.setCostYrmon(masSimNonOpExpnVO[0].getCostYrmon());
					vo.setVslCd(masSimNonOpExpnVO[i].getVslCd());
					deleteVoList.add(vo);
				}
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiNonOpExpn(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiNonOpExpn(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiNonOpExpn(deleteVoList);
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
     * 1. 기능 : Step1에서 FileMgmt 정보를 조회한다.
     * 2. 작성자/작성일 : 윤진영 / 2009.09.01
     * @param SearchFileMgmtListVO searchFileMgmtListVO
     * @param SignOnUserAccount account
     * @return List<SearchFileMgmtListVO>
     * @exception EventException
     */
    public List<SearchFileMgmtListVO> searchFileMgmtList(SearchFileMgmtListVO searchFileMgmtListVO, SignOnUserAccount account) throws EventException {
        try {
        	SearchFileMgmtListVO retVo = new SearchFileMgmtListVO(); //update 용
			retVo.setUserId(account.getUsr_id());
            retVo.setSlanCd(searchFileMgmtListVO.getSlanCd());
			return dbDao.searchFileMgmtList(retVo);
        } catch(DAOException ex) {
         	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }
    /**
     * 1. 기능 : Step1에서 FileMgmt 정보를 삭제한다.
     * 2. 작성자/작성일 : 윤진영 / 2009.09.10
     * @param SearchFileMgmtListVO[] vos
     * @exception EventException
     */
    public void multiFileMgmt(SearchFileMgmtListVO[] vos) throws EventException {
        try {
            dbDao.multiFileMgmt(vos);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }    
    /**
     * 1. 기능 : Step1에서 BSA by VVD 정보를 조회한다.
     * 2. 작성자/작성일 : 윤진영 / 2009.09.18
     * @param SearchBSAbyVVDListConditionVO searchBSAbyVVDListConditionVO
     * @return SearchBSAbyVVDListVO
     * @exception EventException
     */
    public SearchBSAbyVVDListVO searchBSAbyVVDList(SearchBSAbyVVDListConditionVO searchBSAbyVVDListConditionVO) throws EventException {
        try {
        	return dbDao.searchBSAbyVVDList(searchBSAbyVVDListConditionVO);
        }    
        catch(DAOException ex) {
          	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler(ex).getMessage());
        } 
    }
	/* ====================================================================================
	 	ESM_MAS_0052화면
       ==================================================================================== */
    /**
     * 1. 기능 : Step2 : Tab1 : Port/TMNL Setting > Port 정보 변경시 해당 Yard Code를 조회한다.<br>
     * 2. 작성자/작성일 : 윤진영/2009.02.13<br>
     * @param SearchSimYardConditionVO vo
     * @return List<SearchSimYardListVO>
     * @throws EventException
     */
    public List<SearchSimYardListVO> searchSimYardList(SearchSimYardConditionVO vo) throws EventException {
        try {
        	String newLane = dbDao.searchSLane2(String.valueOf(vo.getSlanCd())); //신규 LANE 판별 위해
        	return dbDao.searchSimYardList(vo,newLane);
        }catch(DAOException ex) {
           	log.error("err " + ex.toString(), ex);
           	throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
           	log.error("err " + ex.toString(), ex);
           	throw new EventException(new ErrorHandler(ex).getMessage());
        } 
    }
    /**
     * 1. 기능 : Step2 : Tab1 : Port/TMNL Setting > Retrieve <br>
     * 2. 작성자/작성일 : 윤진영/2009.09.06<br>
     * @param SearchSimLaneListConditionVO vo
     * @return EventResponse ESM_MAS_052EventResponse
     * @throws EventException
     */
    public SearchSimPortListVO searchSimPortList(SearchSimLaneListConditionVO vo) throws EventException {
    	try {
    		SearchSimPortListVO rtnVo = null;	
    		DBRowSet rSet = null;
    		List<SearchSimPortListVO> list = null;
    		list = dbDao.searchSimPortList(vo);
    		rtnVo = new SearchSimPortListVO();
			rSet   = new DBRowSet();
        	rtnVo = dbDao.searchVslClassRank3(vo);
			rSet   = rtnVo.getRowSet();
			String vslCdClass = "";
			String vslCdCnt = "";
			StringBuffer vslCdClass2 = new StringBuffer();
            StringBuffer vslCdCnt2 = new StringBuffer();
			//화면에 VSL_CD 설정 
			if(rSet != null) {
				while(rSet.next()) {
					vslCdClass2 = vslCdClass2.append(rSet.getString("vsl_clss_capa")).append("|");
					vslCdCnt2 = vslCdCnt2.append(rSet.getString("vsl_cnt")).append("|");
				}
				vslCdClass = vslCdClass2.toString();
				vslCdCnt = vslCdCnt2.toString();
				
	        	if(!vslCdClass.equals("") && !vslCdCnt.equals("")) {
	        		list.get(0).setVslClssCapa(vslCdClass);
	        		list.get(0).setVslCnt(vslCdCnt);
	        	}
			}
			//화면에 MAX,MIN SPD 설정
			rtnVo = dbDao.searchTmlSeaSpeed(vo);
			rSet   = rtnVo.getRowSet();
			if(rtnVo != null && rSet.next()) {
				if(!rSet.getString("max_spd").equals("0")) {
					list.get(0).setMaxSpeed(JSPUtil.getNull(rSet.getString("max_spd"))); //조회조건으로 return할 sea speed max값
					list.get(0).setMinSpeed(JSPUtil.getNull(rSet.getString("min_spd"))); //조회조건으로 return할 sea speed min값
				} 
			}
    		rtnVo.setListSet(list);
			return rtnVo;
    	} catch(DAOException ex) {
         	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler(ex).getMessage());
        } 
    }
    /**
     * 1. 기능 : Step2 : Tab1 : Port/TMNL Setting > Existing Lane 일 경우 P/F SKD의 Port TMNL 정보를 조회한다. <br>
     * 2. 작성자/작성일 : 윤진영/2009.10.16<br>
     * @param SearchSimLaneListConditionVO vo
     * @param SignOnUserAccount account
     * @return SearchSimPortListVO
     * @throws EventException
     */
    
    public SearchSimPortListVO multiSimPortGetOpDay(SearchSimLaneListConditionVO vo,SignOnUserAccount account) throws EventException {
    	try {
    		SearchSimPortListVO rtnVo = new SearchSimPortListVO();	
    		List<SearchSimPortListVO> list = null;
    		dbDao.multiSimPortGetOpDay(vo,account);
    		list = dbDao.searchSimPortGetOpDay(vo);
    		rtnVo.setListSet(list);
    		return rtnVo;
    	} catch (DAOException de) {
    		log.error("err "+de.toString(),de);
    		throw new EventException(de.getMessage());
    	}
    }
    /**
     * 1. 기능 : Step2 : Tab1 : Port/TMNL Setting > 1차 Save <br>
     * 2. 작성자/작성일 : 윤진영/2009.10.01<br>
     * @param SearchSimPortListVO[] vos
     * @param SearchSimLaneListConditionVO vo
     * @param SignOnUserAccount account
     * @return SearchSimLaneListConditionVO
     * @throws EventException
     */
    public SearchSimLaneListConditionVO multiSimPortInfo(SearchSimPortListVO[] vos,SearchSimLaneListConditionVO vo,SignOnUserAccount account) throws EventException{
    	SearchSimPortListVO rSetVo = null;
    	SearchSimPortListVO delVo = new SearchSimPortListVO();
    	SearchSimPortListVO updVo = new SearchSimPortListVO();    	
    	DBRowSet rSet = null;
    	List<SearchSimPortListVO> insertVoList = new ArrayList<SearchSimPortListVO>();
		List<SearchSimPortListVO> deleteVoList = new ArrayList<SearchSimPortListVO>();
		String[] portArr = vo.getPortArr().split("[|]"); 
        String lnkSpd = "";
        int insertSeq = 1;
        int portIdx = 0;
		try {
    		if(vos != null) {
				rSetVo = dbDao.searchTmlSeaSpeed(vo);
				rSet   = rSetVo.getRowSet();
				if(rSet != null && rSet.next()) {
					lnkSpd = JSPUtil.getNull(rSet.getString("lnk_spd"));
					vo.setMaxSpeed(JSPUtil.getNull(rSet.getString("max_spd"))); //조회조건으로 return할 sea speed max값
					vo.setMinSpeed(JSPUtil.getNull(rSet.getString("min_spd"))); //조회조건으로 return할 sea speed min값
				}
				//====================================================================================================    			
				for(int j=0;j<vos.length;j++) { 
					portIdx = Integer.parseInt(vos[j].getRowNum());
					vo.setTmlCd(vos[j].getTmlCd());
					if(vos[j].getIbflag().equals("I") || vos[j].getIbflag().equals("U")) {
						if(j==0) {
							delVo.setSimDt(vo.getFSimDt());
							delVo.setSimNo(vo.getFSimNo());
							deleteVoList.add(delVo);
							dbDao.deleteSimPortInfo(deleteVoList);
							deleteVoList.clear();
						}
						if(vos[j].getLnkSpd().equals("0")) {
							vos[j].setLnkSpd(lnkSpd);
						} 
						//Manu IN/OUT 가져오기====================================================
						rSetVo = new SearchSimPortListVO();
						rSet   = new DBRowSet();
						rSetVo = dbDao.searchManuInOut(vo);
						rSet   = rSetVo.getRowSet();
						if(rSet != null && rSet.next()) {
							vos[j].setMnvrInHrs(JSPUtil.getNull(rSet.getString("mnvr_in_hrs")));
							vos[j].setMnvrOutHrs(JSPUtil.getNull(rSet.getString("mnvr_out_hrs")));
						} 
						
						//========================================================================	
						rSetVo = new SearchSimPortListVO();
						rSet   = new DBRowSet();
						if(insertSeq==1) {
							vo.setPortCd(null);
						} else {
							vo.setPortCd(portArr[portIdx-2]);
						}
						vo.setNextPortCd(portArr[portIdx-1]);
						rSetVo = dbDao.searchTmlDistance(vo);
						rSet   = rSetVo.getRowSet();
						if(rSet != null && rSet.next()) {
							if(portIdx > 1) {
								vos[j-1].setLnkDist(JSPUtil.getNull(rSet.getString("lnk_dist")));
							} else {
								vos[j].setLnkDist(JSPUtil.getNull(rSet.getString("lnk_dist")));
							}
							vos[j].setPortBufHrs(JSPUtil.getNull(rSet.getString("port_buf_hrs")));
							int tempCrnKnt = Integer.parseInt(JSPUtil.getNull(rSet.getString("crn_knt")));
							if(tempCrnKnt > 100) {  // 임시... 꼭 삭제해야 함
								vos[j].setCrnKnt("99");
							} else {
								vos[j].setCrnKnt(JSPUtil.getNull(rSet.getString("crn_knt")));
							}
							vos[j].setTmlProdQty(JSPUtil.getNull(rSet.getString("tml_prod_qty")));
							vos[j].setZd(JSPUtil.getNull(rSet.getString("zd")));
						} 
						//Sea Speed 가져오기
						vos[j].setSimDt(vo.getFSimDt());
						vos[j].setSimNo(vo.getFSimNo());
						vos[j].setCreUsrId(account.getUsr_id());
						vos[j].setUpdUsrId(account.getUsr_id());
						//seq 세팅(delete insert이므로 impl에서 생성)
						vos[j].setPortSeq(String.valueOf(insertSeq));
						//TURN_PORT_IND_CD 세팅
						vos[j].setTurnPortIndCd(vos[j].getTurnPortFlg());
						insertSeq++;
						insertVoList.add(vos[j]);
					} else {
						vos[j].setSimDt(vo.getFSimDt());
						vos[j].setSimNo(vo.getFSimNo());
						vos[j].setCreUsrId(account.getUsr_id());
						vos[j].setUpdUsrId(account.getUsr_id());
						deleteVoList.add(vos[j]);
					}
				}
				if(insertVoList.size() >  0) {
					insertVoList.get(0).setTurnPortIndCd("N");
					insertVoList.get(insertVoList.size()-1).setTurnPortIndCd("F");						
					dbDao.addSimPortInfo(insertVoList);
					updVo = insertVoList.get(0);
					//MAS_SIM_INFO 테이블에 FREQUENCY,DURATION 정보를 넣는다.
					dbDao.modifySimInfo(updVo);					
				}
				if(deleteVoList.size() >  0) {
					dbDao.deleteSimPortInfo(deleteVoList);
				}
    		}
       		return vo;
    	} catch(DAOException ex) {
         	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler(ex).getMessage());
        } 
    }
    /**
     * 1. 기능 : Step2 : Tab1 : Port/TMNL Setting > 2차 Save <br>
     * 2. 작성자/작성일 : 윤진영/2006.10.01<br>
     * @param SearchSimPortListVO[] vos
     * @param SearchSimLaneListConditionVO vo
     * @param SignOnUserAccount account
     * @return SearchSimLaneListConditionVO
     * @throws EventException
     */
    public SearchSimLaneListConditionVO multiSimPortInfo2(SearchSimPortListVO[] vos,SearchSimLaneListConditionVO vo,SignOnUserAccount account) throws EventException{
    	SearchSimPortListVO delVo = new SearchSimPortListVO();
    	SearchSimPortListVO updVo = new SearchSimPortListVO();
    	List<SearchSimPortListVO> insertVoList = new ArrayList<SearchSimPortListVO>();
		List<SearchSimPortListVO> deleteVoList = new ArrayList<SearchSimPortListVO>();
        int insertSeq = 1;
		try {
    		if(vos != null) {
				//====================================================================================================    			
				for(int j=0;j<vos.length;j++) { 
					vo.setTmlCd(vos[j].getTmlCd());
					if(vos[j].getIbflag().equals("I") || vos[j].getIbflag().equals("U")
							||vos[j].getIbflag().equals("R")) {
						if(j==0) {
							delVo.setSimDt(vo.getFSimDt());
							delVo.setSimNo(vo.getFSimNo());
							deleteVoList.add(delVo);
							dbDao.deleteSimPortInfo(deleteVoList);
							deleteVoList.clear();
						}
						vos[j].setSimDt(vo.getFSimDt());
						vos[j].setSimNo(vo.getFSimNo());
						vos[j].setCreUsrId(account.getUsr_id());
						vos[j].setUpdUsrId(account.getUsr_id());
						//seq 세팅(delete insert이므로 impl에서 생성)
						vos[j].setPortSeq(String.valueOf(insertSeq));
						//TURN_PORT_IND_CD 세팅
						vos[j].setTurnPortIndCd(vos[j].getTurnPortFlg());					
						insertSeq++;
						insertVoList.add(vos[j]);
					} else if(vos[j].getIbflag().equals("D")) {
						vos[j].setSimDt(vo.getFSimDt());
						vos[j].setSimNo(vo.getFSimNo());
						vos[j].setCreUsrId(account.getUsr_id());
						vos[j].setUpdUsrId(account.getUsr_id());
						deleteVoList.add(vos[j]);
					}
				}
				if(insertVoList.size() >  0) { 
					//turnPortFlg 처음N 마지막F 세팅
					insertVoList.get(0).setTurnPortIndCd("N");
					insertVoList.get(insertVoList.size()-1).setTurnPortIndCd("F");					
					dbDao.addSimPortInfo(insertVoList);
					updVo = insertVoList.get(0);
					//MAS_SIM_INFO 테이블에 FREQUENCY,DURATION 정보를 넣는다.
					dbDao.modifySimInfo(updVo);
				}
				if(deleteVoList.size() >  0) {
					dbDao.deleteSimPortInfo(deleteVoList);
				}
    		} 
       		return vo;
        } catch (DAOException ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler(ex).getMessage());
        } 
    }    
//    /**
//     * 1. 기능 : Step2 : Tab1 : Port/TMNL Setting > Calcuration <br>
//     * 2. 작성자/작성일 : 윤진영/2009.10.15<br>
//     * @param e ESM_MAS_052Event
//     * @return EventResponse ESM_MAS_052EventResponse
//     * @throws EventException
//     */    
//    public SearchSimCalcVO multiSimPortCalc(SearchSimCalcVO vos) throws EventException {
//    	try {
//    		//Master Data  : PF_SKD Table VO
//    		//MasSimTmlInfoVO masterVO = vo.getMasSimTmlInfoVO();
//			//화면 그리드의 원본 데이타를 담은 VO
//			List<SearchSimPortListVO> detailVOs = vos.getSearchSimPortListVOs();
//
//			//화면에서 ibFlag가 Delete로 삭제된 데이타를 제외한 나머지 데이타로 다시 시뮬레이션을
//			//하고 화면에 리턴 시킬 VO
//			List<SearchSimPortListVO> rtnDetailVOs = new ArrayList<SearchSimPortListVO>();
//			SearchSimCalcVO returnVO = new SearchSimCalcVO();
//			
//			//Vsl Class의 최대 Min 값을 가져온다
//			SearchSimPortListVO searchSimPortListVO = detailVOs.get(0);
//			String minMaxSpd = "";//masSimTmlInfoVO.getMinMaxSpd();
//			minMaxSpd = minMaxSpd.replace(" ", "");
//			
//			if(minMaxSpd == null || "".equals(minMaxSpd)){
//				minMaxSpd = "1";
//			}
//				
//			String eventNav = "A";
//			for(int i=0; i<detailVOs.size(); i++){
//				if(!"D".equals(detailVOs.get(i).getIbflag())){
//					rtnDetailVOs.add(detailVOs.get(i));
//				}
//			}        	
//			//Ocean out 세팅
//			String simDt =  rtnDetailVOs.get(0).getSimDt();
//			String simNo =  rtnDetailVOs.get(0).getSimNo();
//			Map<String,Object> mapVo = new HashMap<String,Object>();
//
//			mapVo = getOceanOut(simDt,simNo);
//			
//			for(int i=0; i<rtnDetailVOs.size(); i++){
//				if(i == 0){							
//					// 첫번째 ETD 구하는 공식 : 당차수 ETB + Working H + Port Buffer
//					String etbDyNo = rtnDetailVOs.get(i).getEtbDyNo();
//					String etbDyCd = rtnDetailVOs.get(i).getEtbDyCd();
//					String etbTmHrmnt = rtnDetailVOs.get(i).getEtbTmHrmnt();
//					String n1ActWrkHrs = rtnDetailVOs.get(i).getActWrkHrs();
//					String n1PortBufHrs = rtnDetailVOs.get(i).getPortBufHrs();
//
//					HashMap<String, String> etdParamM = new HashMap<String, String>();
//					etdParamM.put("etbDyNo",etbDyNo);
//					etdParamM.put("etbDyCd",etbDyCd);
//					etdParamM.put("etbTmHrmnt",etbTmHrmnt);
//					etdParamM.put("actWrkHrs",n1ActWrkHrs);
//					etdParamM.put("portBufHrs",n1PortBufHrs);
//					
//					HashMap<String, String> valM = calETDTime(etdParamM);
//					String calNo = (String)valM.get("ratDay");
//					String calWeek = (String)valM.get("calWeek");
//					String ratTm = (String)valM.get("ratTm");
//
//					rtnDetailVOs.get(i).setEtdDyNo(calNo);
//					rtnDetailVOs.get(i).setEtdDyCd(calWeek);
//					rtnDetailVOs.get(i).setEtdTmHrmnt(ratTm);
//					rtnDetailVOs.get(i).setTurnPortFlg("Y");
//					rtnDetailVOs.get(i).setTurnPortIndCd("N");
//					
//					//Sea Time 계산
//					double dLnkDist = Double.parseDouble((rtnDetailVOs.get(i).getLnkDist()));  //DISTANCE
//					double dLnkSpd = Double.parseDouble((rtnDetailVOs.get(i).getLnkSpd()));  //SEA SPEED
//					double dTempTztmHrs = 0;
//					BigDecimal bTztmHrs = null;
//					if( 0 < Double.compare(dLnkDist,0) && 0 < Double.compare(dLnkSpd,0)){
//						dTempTztmHrs = dLnkDist / dLnkSpd;
//						BigDecimal  bigTztmHrs = new BigDecimal(dTempTztmHrs);
//						bTztmHrs = bigTztmHrs.setScale(0,bigTztmHrs.ROUND_HALF_UP);			
//						rtnDetailVOs.get(i).setTztmHrs(bTztmHrs.toString());
//					}
//					
//					//Sea Buffer Spd 계산 
//					double dSeaBuffer = Double.parseDouble((detailVOs.get(i).getSeaBufHrs())); //Sea Buffer
//					double dTempVal = dTempTztmHrs + dSeaBuffer;
//					double dTempSeaBufSpd = 0;
//					BigDecimal bSeaBufSpd = null;
//					if( 0 < Double.compare(dLnkDist,0) && 0 < Double.compare(dTempVal,0)){
//						dTempSeaBufSpd = dLnkDist / dTempVal;
//						BigDecimal  bigSeaBufSpd = new BigDecimal(dTempSeaBufSpd);
//						bSeaBufSpd = bigSeaBufSpd.setScale(0,bigSeaBufSpd.ROUND_HALF_UP);	
//						rtnDetailVOs.get(i).setSeaBufSpd(bSeaBufSpd.toString());
//					}
//
//					//Ocean out 세팅
//					String tmpPortCd = rtnDetailVOs.get(i).getPortCd();
//					rtnDetailVOs.get(i).setObOcnCgoQty(mapVo.get(tmpPortCd).toString());
//					
//					//Working Hour = 전체 물량 (IPC In + IPC + Out + Ocean In + Ocean Out ) / 터미널 생산성으로 표시
//					double iIbIpcgoQty = Double.parseDouble(rtnDetailVOs.get(i).getIbIpcgoQty());
//					double iObIpcgoQty = Double.parseDouble(rtnDetailVOs.get(i).getObIpcgoQty());
//					double iIbOcnCgoQty = Double.parseDouble(rtnDetailVOs.get(i).getIbOcnCgoQty());
//					double iObOcnCgoQty = Double.parseDouble(rtnDetailVOs.get(i).getObOcnCgoQty());
//					double dTotCgoQty = (double)(iIbIpcgoQty+iObIpcgoQty+iIbOcnCgoQty+iObOcnCgoQty);
//					double dTmlProdQty = Double.parseDouble(rtnDetailVOs.get(i).getTmlProdQty());
//					
//					double dTempWorkingHur = 0;
//					BigDecimal bWorkingHur = null;
//					if( 0 < Double.compare(dTotCgoQty,0) && 0 < Double.compare(dTmlProdQty,0)){
//						dTempWorkingHur = dTotCgoQty/dTmlProdQty;
//						BigDecimal  bigWorkingHur = new BigDecimal(dTempWorkingHur);
//						bWorkingHur = bigWorkingHur.setScale(0,bigWorkingHur.ROUND_HALF_UP);	
//						rtnDetailVOs.get(i).setActWrkHrs(bWorkingHur.toString());
//					}
//					
//					//minMaxSpd = resultV0.getLnkSpd();
//					//rtnDetailVOs.get(i).setMinMaxSpd(minMaxSpd);
//					//rtnDetailVOs.get(i).setEventNav("A");
//
//				}else{
//					//첫번째 로우 이후의 공식
//					//ETB = SEATIME(전차수) + SEA BUFFER(전차수)+(MANU/IN(전차수)+MANU/OUT(전차수))+ZD(현재차수(ZD)-전차수(ZD))+ETD(전차수)
//					//2009.09.22 임창빈 수석 업무 수정
//					//ETB = SEATIME(전차수) + SEA BUFFER(전차수)+(MANU/IN(현재차수)+MANU/OUT(전차수))+ZD(현재차수(ZD)-전차수(ZD))+ETD(전차수)
//					String tztmHrs = rtnDetailVOs.get(i-1).getTztmHrs();
//				    String seaBufHrs = rtnDetailVOs.get(i-1).getSeaBufHrs();
//					String mnvrInHrs = rtnDetailVOs.get(i).getMnvrInHrs();
//					String mnvrOutHrs = rtnDetailVOs.get(i-1).getMnvrOutHrs();
//	
//					String postZd = rtnDetailVOs.get(i-1).getZd();
//					if(postZd == null || postZd.equals("")){
//						postZd = "0";
//					}
//					String currZd = rtnDetailVOs.get(i).getZd();
//					if(currZd == null || currZd.equals("")){
//						currZd = "0";
//					}
//					String etdDyNo = rtnDetailVOs.get(i-1).getEtdDyNo();
//					String etdDyCd = rtnDetailVOs.get(i-1).getEtdDyCd();
//					String etdTmHrmnt = rtnDetailVOs.get(i-1).getEtdTmHrmnt();
//					etdTmHrmnt = etdTmHrmnt.replace(":", ".");
//					HashMap<String, String> paramMap = new HashMap<String, String>();
//					paramMap.put("tztmHrs", tztmHrs);
//					paramMap.put("seaBufHrs", seaBufHrs);
//					paramMap.put("mnvrInHrs", mnvrInHrs);
//					paramMap.put("mnvrOutHrs", mnvrOutHrs);
//					paramMap.put("postZd", postZd);
//					paramMap.put("currZd", currZd);
//					paramMap.put("etdDyNo", etdDyNo);
//					paramMap.put("etdDyCd", etdDyCd);
//					paramMap.put("etdTmHrmnt", etdTmHrmnt);
//	
//					HashMap<String, String> etbValM = calETBTime(paramMap);
//					String calEtbDyCd = (String)etbValM.get("etbDyCd");
//					String calEtbDyNo = (String)etbValM.get("etbDyNo");
//					String calEtbTmHrmnt = (String)etbValM.get("etbTmHrmnt");
//					
//					SearchSimPortListVO tempEtbVO = rtnDetailVOs.get(i);
//					tempEtbVO.setEtbDyNo(calEtbDyNo);
//					tempEtbVO.setEtbDyCd(calEtbDyCd);
//					tempEtbVO.setEtbTmHrmnt(calEtbTmHrmnt);
//					rtnDetailVOs.set(i, tempEtbVO);
//					
//					String etbDyNo = rtnDetailVOs.get(i).getEtbDyNo();
//					String etbDyCd = rtnDetailVOs.get(i).getEtbDyCd();
//					String etbTmHrmnt = rtnDetailVOs.get(i).getEtbTmHrmnt();
//					etbTmHrmnt = etbTmHrmnt.replace(":", ".");
//					
//					String actWrkHrs = rtnDetailVOs.get(i).getActWrkHrs();
//					String portBufHrs = rtnDetailVOs.get(i).getPortBufHrs();
//									
//					HashMap<String, String> etdParamM = new HashMap<String, String>();
//					etdParamM.put("etbDyNo",etbDyNo);
//					etdParamM.put("etbDyCd",etbDyCd);
//					etdParamM.put("etbTmHrmnt",etbTmHrmnt);
//					etdParamM.put("actWrkHrs",actWrkHrs);
//					etdParamM.put("portBufHrs",portBufHrs);
//					HashMap<String, String> valM = calETDTime(etdParamM);
//					String calNo = (String)valM.get("ratDay");
//					String calWeek = (String)valM.get("calWeek");
//					String ratTm = (String)valM.get("ratTm");
//					SearchSimPortListVO tempEtdVO = rtnDetailVOs.get(i);
//					tempEtdVO.setEtdDyNo(calNo);
//					tempEtdVO.setEtdDyCd(calWeek);
//					tempEtdVO.setEtdTmHrmnt(ratTm);
//					tempEtdVO.setTurnPortIndCd(tempEtdVO.getTurnPortFlg());
//					rtnDetailVOs.set(i, tempEtdVO);
//					
//					//Sea Time 계산
//					double dLnkDist = Double.parseDouble((rtnDetailVOs.get(i).getLnkDist()));  //DISTANCE
//					double dLnkSpd = Double.parseDouble((rtnDetailVOs.get(i).getLnkSpd()));  //SEA SPEED
//					double dTempTztmHrs = 0;
//					BigDecimal bTztmHrs = null;
//					if( 0 < Double.compare(dLnkDist,0) && 0 < Double.compare(dLnkSpd,0)){
//						dTempTztmHrs = dLnkDist / dLnkSpd;
//						BigDecimal  bigTztmHrs = new BigDecimal(dTempTztmHrs);
//						bTztmHrs = bigTztmHrs.setScale(0,bigTztmHrs.ROUND_HALF_UP);			
//						rtnDetailVOs.get(i).setTztmHrs(bTztmHrs.toString());
//					}
//			
//					//Sea Buffer Spd 계산 
//					double dSeaBuffer = Double.parseDouble((rtnDetailVOs.get(i).getSeaBufHrs())); //Sea Buffer
//					double dTempVal = dTempTztmHrs + dSeaBuffer;
//					double dTempSeaBufSpd = 0;
//					BigDecimal bSeaBufSpd = null;
//					if( 0 < Double.compare(dLnkDist,0) && 0 < Double.compare(dTempVal,0)){
//						dTempSeaBufSpd = dLnkDist / dTempVal;
//						BigDecimal  bigSeaBufSpd = new BigDecimal(dTempSeaBufSpd);
//						bSeaBufSpd = bigSeaBufSpd.setScale(0,bigSeaBufSpd.ROUND_HALF_UP);	
//						rtnDetailVOs.get(i).setSeaBufSpd(bSeaBufSpd.toString());
//					}
//												
//					//Ocean out 세팅
//					String tmpPortCd = rtnDetailVOs.get(i).getPortCd();
//					rtnDetailVOs.get(i).setObOcnCgoQty(mapVo.get(tmpPortCd).toString());				
//					
//					//Working Hour = 전체 물량 (IPC In + IPC + Out + Ocean In + Ocean Out ) / 터미널 생산성으로 표시
//					double iIbIpcgoQty = Double.parseDouble(rtnDetailVOs.get(i).getIbIpcgoQty());
//					double iObIpcgoQty = Double.parseDouble(rtnDetailVOs.get(i).getObIpcgoQty());
//					double iIbOcnCgoQty = Double.parseDouble(rtnDetailVOs.get(i).getIbOcnCgoQty());
//					double iObOcnCgoQty = Double.parseDouble(rtnDetailVOs.get(i).getObOcnCgoQty());
//					double dTotCgoQty = (double)(iIbIpcgoQty+iObIpcgoQty+iIbOcnCgoQty+iObOcnCgoQty);
//					double dTmlProdQty = Double.parseDouble(rtnDetailVOs.get(i).getTmlProdQty());
//												
//					double dTempWorkingHur = 0;
//					BigDecimal bWorkingHur = null;
//					if( 0 < Double.compare(dTotCgoQty,0) && 0 < Double.compare(dTmlProdQty,0)){
//						dTempWorkingHur = dTotCgoQty/dTmlProdQty;
//						BigDecimal  bigWorkingHur = new BigDecimal(dTempWorkingHur);
//						bWorkingHur = bigWorkingHur.setScale(0,bigWorkingHur.ROUND_HALF_UP);	
//						rtnDetailVOs.get(i).setActWrkHrs(bWorkingHur.toString());
//					}
//											
//					//minMaxSpd = resultV0.getLnkSpd();
//					//rtnDetailVOs.get(i).setMinMaxSpd(minMaxSpd);
//				}	
//			}
//			String firstDirCd = rtnDetailVOs.get(0).getSkdDirCd();
//			String[] dirCdArr = new String[2];
//			dirCdArr[0] = firstDirCd;
//			int firstPos = 0;
//			
//			for(int i=1; i<rtnDetailVOs.size(); i++){				
//				if(!rtnDetailVOs.get(i).getSkdDirCd().equals(firstDirCd)){
//					firstPos = i;
//					break;
//				}
//			}
//			rtnDetailVOs.get(firstPos).setTurnPortFlg("Y");
//			rtnDetailVOs.get(firstPos).setTurnPortIndCd("Y");
//			
//			//마지막 로우의 ETD와 DIST,SEA SPEED등 데이타 초기화
//			SearchSimPortListVO  lastVO = rtnDetailVOs.get(rtnDetailVOs.size()-1);
//			//첫번째 로우의 Terminal Code를 마지막 로우에 셋팅한다
//			//lastVO.setYdCd(rtnDetailVOs.get(0).getYdCd());
//			lastVO.setTurnPortFlg("N");
//			lastVO.setTurnPortIndCd("F");
//			rtnDetailVOs.set(rtnDetailVOs.size()-1, lastVO);				
//
//			//returnVO.setMasSimTmlInfoVO(masterVO);
//			returnVO.setSearchSimPortListVOs(rtnDetailVOs);
//
//			return returnVO;
//        } catch (Exception ex) {
//           	log.error("err " + ex.toString(), ex);
//           	throw new EventException(new ErrorHandler(ex).getMessage());
//        } 
//    }
    
//    /**
//     * 1. 기능 : Step2 : Tab1 : Port/TMNL Setting > Ocean out 가져오기 <br>
//     * 2. 작성자/작성일 : 윤진영/2009.10.15<br>
//     * @param String simDt
//     * @param String simNo
//     * @return Map
//     * @throws EventException
//     */    
//    public Map getOceanOut(String simDt,String simNo) throws EventException{
//    	try {
//    		LaneSimulationCommonVO rSetVo = null;
//    		DBRowSet rSet = null;
//    		Map<String, Object> mapVo = new HashMap<String, Object>();
//			rSetVo = new LaneSimulationCommonVO();
//			rSet   = new DBRowSet();
//			rSetVo = dbDao.searchOceanQty(simDt,simNo);
//			rSet   = rSetVo.getRowSet();
//			if(rSet !=null) {
//				while(rSet.next()) {
//					mapVo.put(JSPUtil.getNull(rSet.getString("port_cd")), JSPUtil.getNull(rSet.getString("qty")));
//				}
//			} 			
//			return mapVo;
//		} catch(DAOException ex) {
//	     	log.error("err " + ex.toString(), ex);
//	    	throw new EventException(new ErrorHandler(ex).getMessage());
//	    } catch (Exception ex) {
//	    	log.error("err " + ex.toString(), ex);
//	    	throw new EventException(new ErrorHandler(ex).getMessage());
//	    } 
//    }
//	/**
//	 * P/F SKD Settlement Simulation 이벤트 처리<br>
//	 * ProformaScheduleMgt의 ETDTime 구하는 메소드 <br>
//	 * 
//	 * @param HashMap paramMap
//	 * @return HashMap
//	 * @exception EventException
//	 */
//	public HashMap<String, String> calETDTime(HashMap<String, String> paramMap){
//
//		HashMap<String,String> hMap = new HashMap<String,String>();
//		float totTm = 0;
//		int ietbDyNo = Integer.parseInt((String)paramMap.get("etbDyNo"));
//		String setbDyCd = (String)paramMap.get("etbDyCd");
//		String setbTm = (String)paramMap.get("etbTmHrmnt");
//		String tempSetbTm = setbTm.substring(0,2).replace(".", "");
//
//		if(tempSetbTm.length() < 2){
//			tempSetbTm = "0"+tempSetbTm;
//		}
//		int ietbTm = Integer.parseInt(tempSetbTm);
//		String tempActWrkHrs = (String)paramMap.get("actWrkHrs");
//		tempActWrkHrs = tempActWrkHrs.replace(".3", ".5");
//		float fworkTm = Float.parseFloat(tempActWrkHrs);
//		String tempPortBufHrs = (String)paramMap.get("portBufHrs");
//		tempPortBufHrs = tempPortBufHrs.replace(".3", ".5");
//		float fportTm = Float.parseFloat(tempPortBufHrs);
//		
//		totTm = ietbTm + fworkTm + fportTm;
//		int itotTm = (int)totTm;
//		float totSec = totTm - itotTm;
//		int ratDay = itotTm / 24;
//		int ratTm = itotTm % 24;
//		String ratSec = "0";
//		if(0 > Double.compare(totSec, 0.5)){
//			if(ratTm < 10){
//				String ratTmF =  ratSec + ratTm + ":00";				
//				hMap.put("ratTm", ratTmF);
//			}else{				
//				String ratTmF =  ratTm  +":00";
//				hMap.put("ratTm", ratTmF);	
//			}
//			
//		}else if(0 == Double.compare(totSec, 0.5)){
//			if(ratTm < 10){
//				//String ratTmF = (Integer.toString(ratTm)+":30");
//				String ratTmF = ratSec + ratTm+":30";
//				hMap.put("ratTm", ratTmF);
//			}else{
//				String ratTmF = (Integer.toString(ratTm)+":30");
//				hMap.put("ratTm", ratTmF);
//			}
//			
//		}else{		
//			if(ratTm < 10){
//				//String ratTmF = ratTm + Integer.parseInt("1") + ":00";
//				int ratTmTemp = ratTm + Integer.parseInt("1");					
//				if(ratTmTemp < 10){
//					String ratTmF = ratSec +(ratTm + 1) + ":00";			
//					hMap.put("ratTm", ratTmF);					
//				}else{
//					String ratTmF = ratTm + Integer.parseInt("1") + ":00";
//					hMap.put("ratTm", ratTmF);
//				}
//			}else{
//				String ratTmF = ratTm + Integer.parseInt("1") + ":00";
//				hMap.put("ratTm", ratTmF);
//			}
//		}		
//		
//		ietbDyNo = ietbDyNo+ratDay;
//		
//		hMap.put("ratDay", Integer.toString(ietbDyNo));
//		String calWeek = getCalWeek(setbDyCd, ratDay);
//		hMap.put("calWeek", calWeek);
//		
//		return hMap;
//	}
//	
//	/**
//	 * P/F SKD Settlement Simulation 이벤트 처리<br>
//	 * ProformaScheduleMgt의 calETBTime 구하는 메소드 <br>
//	 * 
//	 * @param HashMap paramMap
//	 * @return HashMap
//	 * @exception EventException
//	 */
//	public HashMap<String, String> calETBTime(HashMap<String, String> paramMap){
//		HashMap<String,String> hMap = new HashMap<String,String>();
//		float totTm = 0;
//		int etbDyNo = 0;
//
//		String tempTztmHrs = (String)paramMap.get("tztmHrs");
//		tempTztmHrs = tempTztmHrs.replace(".3", ".5");
//		float ftztmHrs = Float.parseFloat(tempTztmHrs);
//		String tempSeaBufHrs = (String)paramMap.get("seaBufHrs");
//		tempSeaBufHrs = tempSeaBufHrs.replace(".3", ".5");
//		float fseaBufHrs = Float.parseFloat(tempSeaBufHrs);
//		String tempMnvrInHrs = (String)paramMap.get("mnvrInHrs");
//		tempMnvrInHrs = tempMnvrInHrs.replace(".3", ".5");
//		float fmnvrInHrs = Float.parseFloat(tempMnvrInHrs);
//		String tempMnvrOutHrs = (String)paramMap.get("mnvrOutHrs");
//		tempMnvrOutHrs = tempMnvrOutHrs.replace(".3", ".5");
//		float fmnvrOutHrs = Float.parseFloat(tempMnvrOutHrs);
//		
//		float fpostZd = Float.parseFloat((String)paramMap.get("postZd"));
//		float fcurrZd = Float.parseFloat((String)paramMap.get("currZd"));
//		int ietdDyNo = Integer.parseInt((String)paramMap.get("etdDyNo")); 
//		String setdDyCd = (String)paramMap.get("etdDyCd");
//		String tempEtdTmHrmnt = (String)paramMap.get("etdTmHrmnt");
//		tempEtdTmHrmnt = tempEtdTmHrmnt.replace(".3", ".5");
//		float fegdTmHrmnt = Float.parseFloat(tempEtdTmHrmnt);
//
//		totTm = ftztmHrs+fseaBufHrs+(fmnvrInHrs+fmnvrOutHrs)+(fcurrZd-fpostZd)+fegdTmHrmnt;
//		
//		int itotTm = (int)totTm;
//		float totSec = totTm - itotTm;
//
//		int ratDay = itotTm / 24;
//		int ratTm = itotTm % 24;
//						
//		String ratSec = "0";
//		if(0 > Double.compare(totSec, 0.5)){
//			if(ratTm < 10){
//				String ratTmF =  ratSec + ratTm + ":00";				
//				hMap.put("etbTmHrmnt", ratTmF);
//			}else{				
//				String ratTmF =  ratTm  +":00";
//				hMap.put("etbTmHrmnt", ratTmF);	
//			}
//		}else if(0 == Double.compare(totSec, 0.5)){
//			if(ratTm < 10){
//				String ratTmF = ratSec + ratTm+":30";
//				hMap.put("etbTmHrmnt", ratTmF);
//			}else{
//				String ratTmF = (Integer.toString(ratTm)+":30");
//				hMap.put("etbTmHrmnt", ratTmF);
//			}
//		}else{
//			if(ratTm < 10){
//				int ratTmTemp = ratTm + Integer.parseInt("1");					
//				if(ratTmTemp < 10){
//					String ratTmF = ratSec +(ratTm + 1) + ":00";			
//					hMap.put("etbTmHrmnt", ratTmF);					
//				}else{
//					String ratTmF = ratTm + Integer.parseInt("1") + ":00";
//					hMap.put("etbTmHrmnt", ratTmF);
//				}
//			}else{
//				String ratTmF = ratTm + Integer.parseInt("1") + ":00";
//				hMap.put("etbTmHrmnt", ratTmF);
//			}
//		}		
//		
//		etbDyNo = ietdDyNo+ratDay;
//				
//		String calWeek = getCalWeek(setdDyCd, ratDay);
//		hMap.put("etbDyNo", Integer.toString(etbDyNo));
//		hMap.put("etbDyCd", calWeek);
//			
//		return hMap;
//	}
//	
//	/**
//	 * P/F SKD Settlement Simulation 이벤트 처리<br>
//	 * ProformaScheduleMgt의 NEXT PORT의 요일을 구하는 메서드 <br>
//	 * 
//	 * @param HashMap paramMap
//	 * @return HashMap
//	 * @exception EventException
//	 */
//	public String getCalWeek(String dyCd, int tmVal){
//		String[] dayCd = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
//		String reVal = "";
//		int currPos = 0;
//		int nextPos = 0;
//		for(int i=0; i<dayCd.length; i++){
//			if(dayCd[i].equals(dyCd)){
//				currPos = i;
//			}
//		}
//		nextPos = currPos + tmVal;
//		nextPos = nextPos % 7;
//		reVal = dayCd[nextPos];
//		
//		return reVal;
//	}        
    /**
     * 1. 기능 : Step2 : Tab2 : Route Projection - Lane G.RPB Projection > Retrieve
     * 2. 작성자/작성일 : eun-ju PARK/2006.09.08<br>
     * @param SearchSimLaneListConditionVO searchSimLaneListConditionVO
     * @return List<SearchSimLaneRPBListVO>
     * @exception EventException
     */
    public List<SearchSimLaneRPBListVO> searchSimLaneRPBList(SearchSimLaneListConditionVO searchSimLaneListConditionVO) throws EventException {
        try {
        	return dbDao.searchSimLaneRPBList(searchSimLaneListConditionVO);
        }    
        catch(DAOException ex) {
          	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler(ex).getMessage());
        } 
    }
   /**
     * 1. 기능 : Step2 : Tab2 : Route Projection - Lane G.RPB Projection > Save<p>
     * 4. 작성자/작성일 : parkeunju/2006.09.08<br>
     * @param SearchSimLaneRPBListVO[] searchSimLaneRPBListVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifySimGrpb(SearchSimLaneRPBListVO[] searchSimLaneRPBListVO,SignOnUserAccount account) throws EventException{
    	try {
    		SearchSimLaneRPBListVO retVo = new SearchSimLaneRPBListVO();
        	for(int i=0;i<searchSimLaneRPBListVO.length;i++) { 
        		retVo = searchSimLaneRPBListVO[i];
        		dbDao.modifySimGrpb(retVo,account);
        		dbDao.modifySimGrpbProj(retVo,account);
        	}
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    /**
     * 1. 기능 : Step2 : Tab2 : Route Projection - Volume > Retrieve<p>
     * 4. 작성자/작성일 : eun-ju PARK/2006.09.08<br>
     * @param SearchSimConditionVO searchVO
     * @return SearchSimRtnRowSetVO
     * @exception EventException
     */
	public SearchSimRtnRowSetVO searchSimVolProjList(SearchSimConditionVO searchVO) throws EventException {
		try {
			StringBuffer header = new StringBuffer();
			int cnt = 1;
			SearchSimRtnRowSetVO tempVo = dbDao.searchSimPort(searchVO);
        	if(tempVo.getRowSet() != null){
        		while(tempVo.getRowSet().next()){
        			header.append(tempVo.getRowSet().getString("tml_cd"));
        			if(cnt != tempVo.getRowSet().getRowCount()) header.append("|");
        			cnt++;
    			}
        	}
        	//DAO 결과값 RowSet을 VO에 넣은 값을 받아서 returnVO에 생성한다.
        	//########################################################################################
        	SearchSimRtnRowSetVO returnVo = dbDao.searchSimVolProjList(searchVO, header.toString());
        	//########################################################################################
        	//해더값을 VO에 생성한다.
        	searchVO.setFHeader(header.toString());
			return returnVo;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}		
	}	   
    /**
     * 1. 기능 : Step2 : Tab2 : Route Projection - Volume > Save<p>
     * 4. 작성자/작성일 : parkeunju/2006.09.08<br>
     * @param MergyVolProjConditionVO vo
     * @param MergyVolProjConditionVO[] mVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void multiSimVolProj(MergyVolProjConditionVO vo,MergyVolProjConditionVO[] mVO,SignOnUserAccount account) throws EventException{
    	List<MergyVolProjConditionVO> grpb2List       = new ArrayList<MergyVolProjConditionVO>();
    	List<MergyVolProjConditionVO> ctrbMgnCostList = new ArrayList<MergyVolProjConditionVO>();
    	List<SearchSimLaneRPBListVO>  grpbProjList    = new ArrayList<SearchSimLaneRPBListVO>();
    	SearchSimLaneRPBListVO retVo = new SearchSimLaneRPBListVO();
    	try {
    		List createList = new ArrayList();
    		String sim_dt 	   = JSPUtil.getNull(mVO[0].getSimDt()).replaceAll("-","");
    		String sim_no 	   = JSPUtil.getNull(mVO[0].getSimNo());
    		String sect_no 	   = JSPUtil.getNull(mVO[0].getSectNo());
    		String lod_ttl_qty = JSPUtil.getNull(mVO[0].getLodTtlQty());
    		String totSum 	   = JSPUtil.getNull(mVO[0].getTotsum());
    		String cre_usr_id  = JSPUtil.getNull(account.getUsr_id());
    		String upd_usr_id  = JSPUtil.getNull(account.getUsr_id());
    		List<HashMap<String, Object>> podCdList = mVO[0].getDynamicPodCd();
	        for(int j=0;j<mVO.length;j++) { 
	        	if(j==0) {
	        		mVO[j].setSimDt(sim_dt);
	        		mVO[j].setSimNo(sim_no);
	        		mVO[j].setSectNo(sect_no);
	        		mVO[j].setCreUsrId(cre_usr_id);
	        		mVO[j].setUpdUsrId(upd_usr_id);
	        		retVo.setSimDt(sim_dt);
	        		retVo.setSimNo(sim_no);
	        		retVo.setUpdUsrId(upd_usr_id);
	        		grpbProjList.add(retVo);
	        		grpb2List.add(mVO[j]);
	        		ctrbMgnCostList.add(mVO[j]);
	        	}
	        	String[] pod_cd = mVO[0].getHeader().split("[|]");
				for(int k=0;k<pod_cd.length;k++) {
					HashMap<String, Object> hMap = (HashMap<String, Object>)podCdList.get(k);
					String[] port_pair_qty = (String[])hMap.get(pod_cd[k]);
					float f_prot_pair_qty = port_pair_qty[j] == null ? 0 : Float.parseFloat(port_pair_qty[j]);
					if(!mVO[j].getIbflag().equals("D")) {
						HashMap<String, String> param = new HashMap<String, String>();
						param.put("lod_ttl_qty", vo.getLodTtlQty());
						param.put("totsum", vo.getTotsum());
						param.put("trd_cd", vo.getTrdCd());
						param.put("header", vo.getHeader());
						param.put("pagerows", vo.getPagerows());
						param.put("port_pair_rto", vo.getPortPairRto());
						param.put("ibflag", vo.getIbflag());
						param.put("sim_dt",sim_dt);
						param.put("sim_no",sim_no);
						param.put("sect_no",sect_no);
						param.put("pod_cd",pod_cd[k]);
						param.put("pol_cd",mVO[j].getPolCd());
						param.put("port_pair_qty",(String.valueOf(f_prot_pair_qty)));
						param.put("port_pair_lod_qty", totSum.equals("0")?"0":( f_prot_pair_qty/Float.parseFloat(totSum) )*(Float.parseFloat(lod_ttl_qty)) +"");
						param.put("port_pair_rto", totSum.equals("0")?"0":( f_prot_pair_qty/Float.parseFloat(totSum) ) +"");
						param.put("cre_usr_id", cre_usr_id); 
						param.put("upd_usr_id", upd_usr_id);
						createList.add(param);
					}
				}
	        }
    		vo.setMultiCreateList(createList);
    		dbDao.multiSimVolProj(vo);
    		dbDao.modifySimGrpb2(grpb2List);
    		dbDao.modifySimGrpbProj(grpbProjList);
    		dbDao.multiSimCtrbMgnCost(ctrbMgnCostList);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }	
    /**
     * 1. 기능 : Step2 : Tab2 : Route Projection - Volume > Creation<p>
     * 4. 작성자/작성일 : parkeunju/2006.09.08<br>
     * @param MergyVolProjConditionVO vo
     * @param SearchSimLaneListConditionVO vo2
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void createSimVolProj(MergyVolProjConditionVO vo
    		                             ,SearchSimLaneListConditionVO vo2
    		                             ,SignOnUserAccount account) throws EventException{
        SearchSimRtnRowSetVO rtnVO = new SearchSimRtnRowSetVO();
        List<MergyVolProjConditionVO> grpb2List = new ArrayList<MergyVolProjConditionVO>();        
        try {
        	// 1.SKD[Port스케줄] 정보를 조회한다.
        	vo2.setFSectNo(null);
        	rtnVO = dbDao.searchSimPort(vo2);
        	// 2.MAS_SIM_VOL_PRJ 데이터 삭제
        	dbDao.deleteSimVolProj2(vo);
        	// 3.MAS_SIM_CTRB_MGN_COST 데이터 삭제
        	dbDao.deleteSimVolProj(vo);
        	// 4.MAS_SIM_VOL_PRJ 데이터 생성
        	dbDao.createSimVolProj1(vo, rtnVO, account);
        	// 5.MAS_SIM_CTRB_MGN_COST 데이터 생성
        	dbDao.createSimVolProj2(vo,account);
        	// 6.MAS_SIM_SVC_LANE 정보변경
        	vo.setUpdUsrId(account.getUpd_usr_id());
        	grpb2List.add(vo);
            dbDao.modifySimGrpb2(grpb2List);
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}	
    }	
    /**
     * 1. 기능 : Step2 : Tab2 : Route Projection - G.RPB > Retrieve<p>
     * 4. 작성자/작성일 : eun-ju PARK/2006.09.08<br>
     * @param SearchSimConditionVO searchVO
     * @return SearchSimRtnRowSetVO
     * @exception EventException
     */
	public SearchSimRtnRowSetVO searchSimGrpbProjList(SearchSimConditionVO searchVO) throws EventException {
		try {
			StringBuffer header = new StringBuffer();
			int cnt = 1;
			
			SearchSimRtnRowSetVO tempVo = dbDao.searchSimPort(searchVO);
        	if(tempVo.getRowSet() != null){
        		while(tempVo.getRowSet().next()){
        			header.append(tempVo.getRowSet().getString("tml_cd"));
        			if(cnt != tempVo.getRowSet().getRowCount()) header.append("|");
        			cnt++;
    			}
        	}
        	//DAO 결과값 RowSet을 VO에 넣은 값을 받아서 returnVO에 생성한다.
        	//########################################################################################
        	SearchSimRtnRowSetVO returnVo = dbDao.searchSimGrpbProjList(searchVO, header.toString());
        	//########################################################################################
        	//화면에서 넘어 온 파라미터를 VO에 생성한다.
//        	returnVo.setVPrdCd(searchVO.getFPrdCd());
//        	returnVo.setVTrdCd(searchVO.getFTrdCd());
//        	returnVo.setVRlaneCd(searchVO.getFRlaneCd());
//        	returnVo.setVDirCd(searchVO.getFDirCd());
        	searchVO.setFHeader(header.toString());
//        	//해더값을 VO에 생성한다.
//        	returnVo.setHeader(header.toString());
			return returnVo;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}		
	}	    
    /**
     * 1. 기능 : Step2 : Tab2 : Route Projection - G.RPB > Save<p>
     * 4. 작성자/작성일 : parkeunju/2006.09.08<br>
     * @param MergyVolProjConditionVO vo
     * @param MergyVolProjConditionVO[] mVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void multiSimGrpbProj(MergyVolProjConditionVO vo,MergyVolProjConditionVO[] mVO,SignOnUserAccount account) throws EventException{
    	List<MergyVolProjConditionVO> ctrbMgnCostList = new ArrayList<MergyVolProjConditionVO>();
    	try {
    		List<MergyVolProjConditionVO> grpb2List = new ArrayList<MergyVolProjConditionVO>();  
    		List createList = new ArrayList();

    		String sim_dt 	   = JSPUtil.getNull(mVO[0].getSimDt()).replaceAll("-","");
    		String sim_no 	   = JSPUtil.getNull(mVO[0].getSimNo());
    		
    		String sect_no 	   = JSPUtil.getNull(mVO[0].getSectNo());
    		String cre_usr_id  = JSPUtil.getNull(account.getUsr_id());   
    		String upd_usr_id  = JSPUtil.getNull(account.getUsr_id());
    		List<HashMap<String, Object>> podCdList = mVO[0].getDynamicPodCd();
	        for(int j=0;j<mVO.length;j++) { 
	        	if(j==0) {
	        		mVO[j].setSimDt(sim_dt);
	        		mVO[j].setSimNo(sim_no);
	        		mVO[j].setSectNo(sect_no);
	        		mVO[j].setCreUsrId(cre_usr_id);
	        		mVO[j].setUpdUsrId(upd_usr_id);
	        		ctrbMgnCostList.add(mVO[j]);
	        	}
	        	String[] pod_cd = mVO[0].getHeader().split("[|]");
				for(int k=0;k<pod_cd.length;k++) {
					HashMap<String, Object> hMap = (HashMap<String, Object>)podCdList.get(k);
					String[] grs_rpb_rev = (String[])hMap.get(pod_cd[k]);
					String v_grs_rpb_rev = grs_rpb_rev[j] == null ? "0" : grs_rpb_rev[j];

					if(!mVO[j].getIbflag().equals("D")) {
						HashMap<String, String> param = new HashMap<String, String>();
						param.put("sim_dt",sim_dt);
						param.put("sim_no",sim_no);
						param.put("sect_no",sect_no);
						param.put("pol_cd",mVO[j].getPolCd());
						param.put("pod_cd",pod_cd[k]);						
						param.put("grs_rpb_rev", v_grs_rpb_rev);
						param.put("pagerows", vo.getPagerows());
						param.put("ibflag", vo.getIbflag());
						param.put("cre_usr_id", cre_usr_id); 
						param.put("upd_usr_id", upd_usr_id);
						createList.add(param);
					}
				}
	        }
    		vo.setMultiCreateList(createList);
    		dbDao.multiSimGrpbProj(vo);
    		vo.setUpdUsrId(account.getUpd_usr_id());
    		grpb2List.add(vo);
    		dbDao.modifySimGrpb2(grpb2List);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }	
    /**
     * 1. 기능 : Step2 : Tab3 : TMNL Transit Time > Retrieve<br>
     * 2. 작성자/작성일 : 윤진영 /2009.10.01<br>
     * @param SearchTMLOPDysListVO vo
     * @return List<SearchTMLOPDysListVO>
     * @throws EventException
     */
    public List<SearchTMLOPDysListVO> searchTMLOPDysList(SearchTMLOPDysListVO vo) throws EventException{
		try {
			List<SearchTMLOPDysListVO> returnVO = dbDao.searchTMLOPDysList(vo);
			return returnVO;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}
    }
    /**
     * 1. 기능 : Step2 : Tab3 : TMNL Transit Time > Save<br>
     * 2. 작성자/작성일 : 윤진영 / 2009.10.01
     * @param SearchTMLOPDysListVO vo
     * @param SearchTMLOPDysListVO[] vos
     * @param SignOnUserAccount account
     * @throws EventException 
     */
    public void modifyTMLOPDys(SearchTMLOPDysListVO vo,SearchTMLOPDysListVO[] vos,SignOnUserAccount account) throws EventException{
    	try {
    		List updateList = new ArrayList();    		
    		for(int i=0;i<vos.length;i++) {
				HashMap<String,String> param = new HashMap<String,String>();
				param.put("port_dys", vos[i].getPortDys());
				param.put("trd_cd", vos[i].getTrdCd());
				param.put("f_sim_dt", vos[0].getSimDt());   //form 객체가 한번만 들어 오므로.
				param.put("sect_no", vos[i].getSectNo());
				param.put("rlane_cd", vos[i].getRlaneCd());
				param.put("f_sim_no", vos[0].getSimNo());   //form 객체가 한번만 들어 오므로.
				param.put("tml_cd", vos[i].getTmlCd());
				param.put("skd_dir_cd", vos[i].getSkdDirCd());
				param.put("pagerows", vos[i].getPagerows());
				param.put("sea_dys", vos[i].getSeaDys());
				param.put("port_seq", vos[i].getPortSeq());
				param.put("aply_voy_rto", vos[i].getAplyVoyRto());
				param.put("ibflag", vos[i].getIbflag());
				param.put("vsl_dbl_call_seq", vos[i].getVslDblCallSeq());
				param.put("ttl_tz_dys", vos[i].getTtlTzDys());
				param.put("upd_usr_id",account.getUpd_usr_id());
				param.put("f_slan_cd",vos[i].getSLanCd());
				updateList.add(param);
			}
			vo.setMultiUpdateList(updateList);
			dbDao.modifyTMLOPDys(vo);
			//return new ESM_MAS_052EventResponse("SUCCESS");
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}
    }
    /**
     * 1. 기능 : Step2 : Tab3 : TMNL Transit Time > Create
     * 2. 작성자/작성일 : 윤진영 / 2009.09.10
     * @param SearchTMLOPDysListVO vo
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void createTMLOPDys(SearchTMLOPDysListVO vo,SignOnUserAccount account) throws EventException{
		try {
			boolean turnPortIndFlg = true;
			turnPortIndFlg = dbDao.searchTurnPortInd(vo);
			if(turnPortIndFlg) {
				dbDao.deleteTMLOPDys(vo);
				vo.setUpdUsrId(account.getUsr_id());
				dbDao.createTMLOPDys(vo);
			} else {
				//메세징 처리...Check the Turning point indicator on Port TMNL Setting 
				throw new EventException(new ErrorHandler("MAS00033").getMessage());
			}
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}
    }
  	/* ====================================================================================
    	ESM_MAS_053화면
       ==================================================================================== */
     /**
     * Step3 : Tab1 : TML 정보를 조회<p>
     *
     * @param SearchSimConditionVO searchVO
     * @return String
     * @exception EventException
     */    
    private String searchSimPort(SearchSimConditionVO searchVO) throws EventException {
		DBRowSet rowSet = null;							// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		SearchSimRtnRowSetVO selVo=null;
		StringBuffer header = new StringBuffer();
		int cnt = 1;
        try {
        	selVo = dbDao.searchSimPort(searchVO);
        	rowSet = selVo.getRowSet();
        	if(rowSet != null){
        		while(rowSet.next()){
        			header.append(rowSet.getString("tml_cd"));
        			if(cnt != rowSet.getRowCount()) header.append("|");
        			cnt++;
        		}
        	}
            return header.toString();
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception et){
            log.error("err "+et.toString(),et);
            throw new EventException(et.getMessage());
        }    	
    }
    /**
     * Step3 : Tab1 : CM_Lane Summary> Retrieve
     * 
     * @param SearchSimConditionVO vo
     * @return SearchSimRtnRowSetVO
     * @exception EventException
     */
    public SearchSimRtnRowSetVO searchSimCgoCostList(SearchSimConditionVO vo) throws EventException {
		try {
	    	return dbDao.searchSimCgoCostList(vo);
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}		
	}	
    /**
     * Step3 : Tab1 : CM_Route Summary> Retrieve
     * 
     * @param SearchSimConditionVO searchVO
     * @return List<SearchSimRtnRowSetVO> 
     * @exception EventException
     */
    public List<SearchSimRtnRowSetVO> searchSimCMCostList(SearchSimConditionVO searchVO) throws EventException {
    	List<SearchSimRtnRowSetVO> list = null;							// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String header ="";
        try {
        	// Header 정보를 조회
        	header = searchSimPort(searchVO);
        	// Route Summary Sheet1 Data
        	SearchSimRtnRowSetVO vo1 = dbDao.searchSimCMCostList(searchVO, header.toString());
        	// Route Summary Sheet2 Data -- Hidden 
        	SearchSimRtnRowSetVO vo2 = dbDao.searchSimVolProjList2(searchVO, header.toString());
        	// Hearer 정보 입력
        	searchVO.setFHeader(header.toString());
        	
        	// RowSet 배열에 각각의 RowSet을 담아서  배열에 넣어 준다.
        	DBRowSet[] rowSets = new DBRowSet[2];
        	rowSets[0] = vo1.getRowSet();
        	rowSets[1] = vo2.getRowSet();
        	vo1.setRowSet(rowSets);
        	
        	// List에 담아서 리턴한다.
			list = new ArrayList<SearchSimRtnRowSetVO>();
        	list.add(vo1);
            return list;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception et){
            log.error("err "+et.toString(),et);
            throw new EventException(et.getMessage());
        }
    }
    /**
     * 1. 기능 : Step3 : Tab1 : CM_Route Summary > Save <p>
     * 2. 작성자/작성일 : parkeunju/2006.09.13<br>
     * @param MasSimCtrbMgnCostVO[] vo
     * @param SearchSimConditionVO searchVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifySimCMCost(MasSimCtrbMgnCostVO[] vo, SearchSimConditionVO searchVO,SignOnUserAccount account) throws EventException {
		List<MasSimCtrbMgnCostVO> insertVoList = new ArrayList<MasSimCtrbMgnCostVO>();
        try {
        	if(vo != null){
        		for(int i=0; i< vo.length; i++){
        			if(!vo[i].getIbflag().equals("D")){
        				vo[i].setCreUsrId(account.getUsr_id());
        				vo[i].setUpdUsrId(account.getUsr_id());
        				insertVoList.add(vo[i]);
        			}
        		}
        	}
        	if(insertVoList.size()>0){
        		dbDao.removeSimCMCost(searchVO);
        		dbDao.addSimCMCost(insertVoList);
        	}
            //rowSet = dbDao.searchSimCgoCostList(event); 20091013 jsp 단에서 처리
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception et){
            log.error("err "+et.toString(),et);
            throw new EventException(et.getMessage());
        }
    }
    /**
     * Step3 : Tab2 : Port Charge > Retrieve <p>
     * 
     * @param SearchSimConditionVO searchVO
     * @return List<SearchSimPortChargeListVO>
     * @exception EventException
     */
    public List<SearchSimPortChargeListVO> searchSimPortChargeList(SearchSimConditionVO searchVO) throws EventException {
        try {
            return dbDao.searchSimPortChargeList(searchVO);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    /**
     * Step3 : Tab2 : Port Charge > Save
     * 
     * @param MasSimPortChgVO[] vo
     * @param SearchSimConditionVO searchVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void multiSimPortCharge(MasSimPortChgVO[] vo, SearchSimConditionVO searchVO, SignOnUserAccount account) throws EventException {
    	List<MasSimPortChgVO> insertVoList = new ArrayList<MasSimPortChgVO>();
    	List<MasSimPortChgVO> updateVoList = new ArrayList<MasSimPortChgVO>();
        try {
        	if(vo != null){
        		for(int i=0; i< vo.length; i++){
        			if(vo[i].getIbflag().equals("I")){
        				vo[i].setSimDt(searchVO.getFSimDt());
        				vo[i].setSimNo(searchVO.getFSimNo());
        				vo[i].setCreUsrId(account.getUsr_id());
        				vo[i].setUpdUsrId(account.getUsr_id());
        				insertVoList.add(vo[i]);
        			} else if(vo[i].getIbflag().equals("U")){
        				vo[i].setSimDt(searchVO.getFSimDt());
        				vo[i].setSimNo(searchVO.getFSimNo());
        				vo[i].setUpdUsrId(account.getUsr_id());
        				updateVoList.add(vo[i]);
        			}
        		}
        	}
        	if(insertVoList.size()>0){
        		dbDao.addSimPortCharge(insertVoList);
        	}            
        	if(updateVoList.size()>0){
        		dbDao.modifySimPortCharge(updateVoList);
        	}            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    /**
     * Step3 : Tab2 : Port Charge > Create <p>
     *
     * @param SearchSimConditionVO searchVO
     * @exception EventException
     */
    public void createSimPortCharge(SearchSimConditionVO searchVO) throws EventException {
    	try {
    		dbDao.createSimPortCharge(searchVO);
    	} catch (DAOException de) {
    		log.error("err "+de.toString(),de);
    		throw new EventException(de.getMessage());
    	}
    }
    /**
     * Step3 : Tab3 : Bunker Cost > Retrieve
     *
     * @param SearchSimConditionVO searchVO
     * @return List<SearchSimBunkerListVO>
     * @exception EventException
     */
    public List<SearchSimBunkerListVO> searchSimBunkerList(SearchSimConditionVO searchVO) throws EventException {
        try {
        	return dbDao.searchSimBunkerList(searchVO);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     * Step3 : Tab3 : Bunker Cost > Basic
     * 
     * @param MasSimBnkCostVO[] vo
     * @param SearchSimConditionVO searchVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void createSimBunkerList(MasSimBnkCostVO[] vo,SearchSimConditionVO searchVO, SignOnUserAccount account) throws EventException {
    	List<MasSimBnkCostVO> updateVoList = new ArrayList<MasSimBnkCostVO>();
        try {
        	if(vo != null){
        		for(int i=0; i< vo.length; i++){
    				vo[i].setSimDt(searchVO.getFSimDt());
    				vo[i].setSimNo(searchVO.getFSimNo());
    				vo[i].setCreUsrId(account.getUsr_id());
    				vo[i].setUpdUsrId(account.getUsr_id());
    				updateVoList.add(vo[i]);
    				
        		}
        	}
        	if(updateVoList.size()>0){
        		dbDao.createSimBunkerList(updateVoList);
        	}    	
    	} catch (DAOException de) {
    		log.error("err "+de.toString(),de);
    		throw new EventException(de.getMessage());
    	}
    }
    /**
     * Step3 : Tab3 : Bunker Cost > Save
     * 
     * @param MasSimBnkCostVO[] vo
     * @param SearchSimConditionVO searchVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void multiSimBunkerCost(MasSimBnkCostVO[] vo, SearchSimConditionVO searchVO, SignOnUserAccount account) throws EventException {
    	List<MasSimBnkCostVO> insertVoList = new ArrayList<MasSimBnkCostVO>();
    	List<MasSimBnkCostVO> deleteVoList = new ArrayList<MasSimBnkCostVO>();
        try {
        	if(vo != null){
        		for(int i=0; i< vo.length; i++){
    				vo[i].setSimDt(searchVO.getFSimDt());
    				vo[i].setSimNo(searchVO.getFSimNo());
    				vo[i].setCreUsrId(account.getUsr_id());
    				vo[i].setUpdUsrId(account.getUsr_id());
    				insertVoList.add(vo[i]);
    				if(i==0){
        				vo[i].setSimDt(searchVO.getFSimDt());
        				vo[i].setSimNo(searchVO.getFSimNo());
        				vo[i].setUpdUsrId(account.getUsr_id());
        				deleteVoList.add(vo[i]);
    				}
        		}
        	}
        	if(deleteVoList.size()>0){
        		dbDao.removeSimBnkCost(deleteVoList);
        	}            
        	if(insertVoList.size()>0){
        		dbDao.addSimBnkCost(insertVoList);
        	}            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }        
    }
    /**
     * Step3 : Tab4 : Hire/TC Rev/Layup(Daily) > Retreive<p>
     * 
     * @param MasSimCtrbMgnCostVO vo
     * @return SearchSimDailyHireInfoVO
     * @exception EventException
     */
    public SearchSimDailyHireInfoVO searchSimDailyHireList(MasSimCtrbMgnCostVO vo) throws EventException {
        try {
        	return dbDao.searchSimDailyHireList(vo);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    /**
     * Step3 : Tab4 : Hire/TC Rev/Layup(Daily) > Create<p>
     * 
     * @param CreateSimDailyHireVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void createSimDailyHire(CreateSimDailyHireVO vo,SignOnUserAccount account) throws EventException {
        try {
            dbDao.createSimDailyHire(vo,account);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    /**
     * Step3 : Tab4 : Hire/TC Rev/Layup(Daily) > Save<p>
     *
     * @param MasSimDlyHirVO[] vos
     * @param CreateSimDailyHireVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void multiSimDailyHire(MasSimDlyHirVO[] vos,CreateSimDailyHireVO vo, SignOnUserAccount account) throws EventException {
		List<MasSimDlyHirVO> insertVoList = new ArrayList<MasSimDlyHirVO>();
        try {
        	if(vo != null){
        		for(int i=0; i< vos.length; i++){
        			if(!vos[i].getIbflag().equals("D")){
        				vos[i].setCreUsrId(account.getUsr_id());
        				vos[i].setUpdUsrId(account.getUsr_id());
        				insertVoList.add(vos[i]);
        			}
        		}
        	}
        	if(insertVoList.size()>0){
        		dbDao.deleteDailyHire(vo);
        		dbDao.addDailyHire(insertVoList);
        	}
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception et){
            log.error("err "+et.toString(),et);
            throw new EventException(et.getMessage());
        }
    }                     
    /**
     * 기능 : Step3 : Tab4 : Hire/TC Rev/Layup(Daily) > Save
     * 
     * @param MasSimCtrbMgnCostVO vo
     * @param SignOnUserAccount account
     * @return int
     * @exception EventException
     */
    public int createSimNWCost(MasSimCtrbMgnCostVO vo,SignOnUserAccount account) throws EventException{
        try {
        	return dbDao.createSimNWCost(vo,account);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    /**
     * Step3 : Tab5 : Network Cost > Retrieve
     * 
     * @param MasSimCtrbMgnCostVO vo
     * @return SearchSimDailyHireInfoVO
     * @exception EventException
     */
    public SearchSimDailyHireInfoVO searchSimNWCostList(MasSimCtrbMgnCostVO vo) throws EventException {
        try {
        	return dbDao.searchSimNWCostList(vo);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     * Step3 : Tab6 : After Ocean T/S > Retrieve
     *
     * @param MasSimCtrbMgnCostVO vo
     * @return SearchSimDailyHireInfoVO
     * @exception EventException
     */
   
    public SearchSimDailyHireInfoVO searchSimAfterOcenaTSList(MasSimCtrbMgnCostVO vo) throws EventException {
        try {
        	return dbDao.searchSimAfterOcenaTSList(vo);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     * Step3 : Tab4 : TO/C Hire Popup ( Hire/TC Rev/Layup(Daily) Open)  > Retrieve
     * 
     * @return List<SearchTocHireListVO>
     * @exception EventException
     */
    public List<SearchTocHireListVO> searchTOCHireList() throws EventException {
        try {
        	return dbDao.searchTOCHireList();
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }

    /**
     * Step3 : Tab4 : TO/C Hire Popup ( Hire/TC Rev/Layup(Daily) Open)  > Save<p>
     * 
     * @param MasTmChtrOutHirVO[] vos
     * @param SearchTocHireListVO[] vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void multiTOCHire(MasTmChtrOutHirVO[] vos,SearchTocHireListVO[] vo,SignOnUserAccount account) throws EventException{
        try {
        	List<MasTmChtrOutHirVO> insertList = new ArrayList<MasTmChtrOutHirVO>();
        	List<MasTmChtrOutHirVO> updateList = new ArrayList<MasTmChtrOutHirVO>();
        	List<MasTmChtrOutHirVO> deleteList = new ArrayList<MasTmChtrOutHirVO>();
        	String user_id = account.getUsr_id();
            String fm_vsl_clss_capa = "";
            String to_vsl_clss_capa = "";
            int seq = 1;
            for(int j=0; j<vos.length; j++){
            	if(vos[j].getIbflag().equals("I")){
            		if(j==0){
	            		fm_vsl_clss_capa = "0";
            		}else{
            			fm_vsl_clss_capa = vo[j].getVslClssCapa();
            		}
                    if(j < vos.length-1) to_vsl_clss_capa = (Integer.parseInt(vo[j+1].getVslClssCapa())-1)+"";
                    else to_vsl_clss_capa = "99999";

            		vos[j].setToHirSeq(String.valueOf(seq));
            		vos[j].setFmVslClssCapa(fm_vsl_clss_capa);
            		vos[j].setToVslClssCapa(to_vsl_clss_capa);
            		vos[j].setCreUsrId(user_id);
            		seq++;
            		insertList.add(vos[j]);
            	} else if(vos[j].getIbflag().equals("U")){
            		if(j==0){
	            		fm_vsl_clss_capa = "0";
            		}else{
            			fm_vsl_clss_capa = vo[j].getVslClssCapa();
            		}
            		if(j < vos.length-1){
	            		// 다음 Row가 삭제되었을 경우 다다음 Row 의 from data를 가져와서 계산
	            		if(vos[j+1].getIbflag().equals("D")) {
	            			if(j < vos.length-2){
	            				to_vsl_clss_capa = (Integer.parseInt(vo[j+2].getVslClssCapa())-1)+"";
	            			} else {
	            				to_vsl_clss_capa = "99999";
	            			}
	               		// 다음 Row가 변경되었을 경우 다음 Row 의 from data를 가져와서 계산
	            		} else {
	            			if(j < vos.length-1){
	            				to_vsl_clss_capa = (Integer.parseInt(vo[j+1].getVslClssCapa())-1)+"";
	            			} else {
	            				to_vsl_clss_capa = "99999";
	            			}
	            		}
            		} else {
            			to_vsl_clss_capa = "99999";
            		}
            		vos[j].setFmVslClssCapa(fm_vsl_clss_capa);
            		vos[j].setToVslClssCapa(to_vsl_clss_capa);
            		vos[j].setUpdUsrId(account.getUpd_usr_id());
            		updateList.add(vos[j]);	
            	} else if(vos[j].getIbflag().equals("D")){
            		deleteList.add(vos[j]);
            	}
            }        	
            if(insertList.size() > 0) {
            	dbDao.addMultiTOCHire(insertList);
        	}
        	if(updateList.size() > 0) {
        		dbDao.modifyMultiTOCHire(updateList);
    		}
    		if(deleteList.size() > 0) {
    			dbDao.deleteMultiTOCHire(deleteList);
			}
        
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    /**
     * Step5에서 Consumption Matrix by Class 정보를 조회한다.
     * 
     * @param MasBnkCsmVO masBnkCsmVO
     * @return List<MasBnkCsmVO>
     * @exception EventException
     */
    public List<MasBnkCsmVO> searchSimConsumList(MasBnkCsmVO masBnkCsmVO) throws EventException {
    	try {
    		return dbDao.searchSimConsumList(masBnkCsmVO);
    	} catch (DAOException de) {
    		log.error("err "+de.toString(),de);
    		throw new EventException(de.getMessage());
    	}
    }
    /**
     * Step5 에서 Consumption Matrix by Class 정보릉 입력/수정/삭제한다.
     * 
     * @param MasBnkCsmVO[] vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void multiSimConsum(MasBnkCsmVO[] vo,SignOnUserAccount account) throws EventException{
		List<MasBnkCsmVO> insertVoList = new ArrayList<MasBnkCsmVO>();
		List<MasBnkCsmVO> updateVoList = new ArrayList<MasBnkCsmVO>();
		List<MasBnkCsmVO> deleteVoList = new ArrayList<MasBnkCsmVO>();
    	try {
        	if(vo != null){
        		for(int i=0; i< vo.length; i++){    		
        			if(vo[i].getIbflag().equals("I")) {
        				vo[i].setCreUsrId(account.getUsr_id());
        				vo[i].setUpdUsrId(account.getUsr_id());
        				insertVoList.add(vo[i]);
        			} else if(vo[i].getIbflag().equals("U")) {
        				vo[i].setUpdUsrId(account.getUsr_id());
        				updateVoList.add(vo[i]);
        			} else {
        				deleteVoList.add(vo[i]);
        			}
        		}	
        	}		
        	if(insertVoList.size() > 0) {
        		dbDao.addMultiSimConsum(insertVoList);
        	}
        	if(updateVoList.size() > 0) {
        		dbDao.modifyMultiSimConsum(updateVoList);
        	}
        	if(deleteVoList.size() > 0) {
        		dbDao.deleteMultiSimConsum(deleteVoList);
        	}
    	} catch (DAOException de) {
    		log.error("err "+de.toString(),de);
    		throw new EventException(de.getMessage());
    	}
    }
    /*================================================================================================================*/
    /**
     * Header 정보를 조회 이벤트 처리(ESM_MAS_054)<p>
	 *
     * @param SearchSimLaneListConditionVO vo
     * @return SearchSimLaneListConditionVO
     * @exception EventException
     */
    public SearchSimLaneListConditionVO searchSectionNoList(SearchSimLaneListConditionVO vo) throws EventException {
    	try {
            return dbDao.searchSectionNoList(vo);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    /**
     * Simulation Report의 Report No. 멀티콤보 세팅을 위한 데이터 조회
     * 
     * @param SearchSimLaneListConditionVO vo
     * @return SearchSimLaneListConditionVO
     * @throws EventException
     */
    public SearchSimLaneListConditionVO searchSimReportNoList(SearchSimLaneListConditionVO vo) throws EventException {
    	SearchSimLaneListConditionVO rtnVo = null;
        try {
   			rtnVo = dbDao.searchSimReportNoList(vo);
   			return rtnVo;
    	} catch(DAOException ex) {
         	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler(ex).getMessage());
        } 
    }
/*    public SearchSimLaneListConditionVO searchSimReportNoList(SearchSimLaneListConditionVO vo) throws EventException {
    	SearchSimLaneListConditionVO rtnVo = null;
        DBRowSet rowSet=null;							// 데이터 전송을 위해 DB ResultSet을 구현한 객체
        String conditionStr="";
        try {
        	rtnVo = new SearchSimLaneListConditionVO();
        	rtnVo = dbDao.searchSectionNoList(vo);
			rowSet = rtnVo.getDbRowSet();
   			while(rowSet.next()) {
    					conditionStr = conditionStr 
    					+ " (SELECT sim_rmk FROM mas_sim_rpt_mst a1 WHERE a1.sim_dt = b1.sim_dt AND a1.sim_no = b1.sim_no AND a1.sim_rpt_no = b1.sim_rpt_no AND a1.sect_no = '" 
    					+ rowSet.getString("code")
    					+ "') || ' ' || ";
    		}
        	rtnVo = new SearchSimLaneListConditionVO();
   			rtnVo = dbDao.searchSimReportNoList(vo,conditionStr);
   			return rtnVo;
    	} catch(DAOException ex) {
         	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler(ex).getMessage());
        } 
    }
    */

    
    /**
     * sheet1조회 이벤트 처리
     * 
     * @param SearchReportConditionVO vo
     * @return SearchReportConditionVO
     * @throws EventException
     */
    public SearchReportConditionVO searchSimSummaryReportList(SearchReportConditionVO vo) throws EventException {
    	SearchSimLaneListConditionVO retVo = new SearchSimLaneListConditionVO();
        DBRowSet rowSet2=null;							// 데이터 전송을 위해 DB ResultSet을 구현한 객체
        String header = "";
        String headerNM = "";
        StringBuffer headerCD2 = new StringBuffer();
        StringBuffer headerNM2 = new StringBuffer();
        int cnt = 0;
        int i=1;
        try {
        	retVo.setFSimDt(vo.getFSimDt());
        	retVo.setFSimNo(vo.getFSimNo());
        	retVo.setFTrdCd(vo.getFTrdCd());
        	retVo = dbDao.searchSectionNoList(retVo);
        	rowSet2 = retVo.getDbRowSet();
        	if(rowSet2 != null){
        		cnt = rowSet2.getRowCount();
				while(rowSet2.next()){
					headerCD2 = headerCD2.append(rowSet2.getString("code"));
					headerNM2 = headerNM2.append(rowSet2.getString("name"));
					if(cnt != i){
						headerCD2 = headerCD2.append("|");
						headerNM2 = headerNM2.append("|");
					}
					i++;
				}
        	}
        	header = headerCD2.toString();
        	headerNM = headerNM2.toString();
        	
            return dbDao.searchSimSummaryReportList(vo, header, headerNM);     
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch(Exception ex){
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage());
        }
    }
    /**
     * Simulation Report의 MAS_SIM_RPT_MST ROW수
     * 
  	 * @param SearchSimLaneListConditionVO vo
  	 * @return int
     * @throws EventException
     */
    public int searchSimReportMasterCount(SearchSimLaneListConditionVO vo) throws EventException {
    	try {
    		//데이터 있는지 확인
    		return dbDao.searchSimReportMasterCount(vo);
    		
    	} catch (DAOException de) {
    		log.error("err "+de.toString(),de);
    		throw new EventException(de.getMessage());
    	}
    	
    }    
    /**
     * Simulation 에서 사용하는 Creation (Variant Change)팝업 정보를 생성
     * 
     * @param SearchSimLaneListConditionVO vo
     * @param SignOnUserAccount account
     * @return List<SearchSimReportMasterListVO>
     * @throws EventException
     */
    public List<SearchSimReportMasterListVO> createDefaultSimReport(SearchSimLaneListConditionVO vo,SignOnUserAccount account) throws EventException{
    	List<SearchSimReportMasterListVO> list = null;
    	try {
    		int rtnVal = 0;
    		//MAS_SIM_RPT_MST 데이터 생성
    		rtnVal = dbDao.createSimSummaryReport(vo,account);
    		rtnVal = dbDao.createSimReportMaster(vo,account);  
    		if(rtnVal > 0){
    			list = dbDao.searchSimReportMasterList(vo);
    		}
    		return list;
 		
    	} catch (DAOException de) {
    		log.error("err "+de.toString(),de);
    		throw new EventException(de.getMessage());
    	}
    }
    /**
     * Simulation에서 사용하는 Creation (Variant Change)팝업 정보를 조회
     * 
     * @param SearchSimLaneListConditionVO vo
     * @return List<SearchSimReportMasterListVO>
     * @throws EventException
     */
    public List<SearchSimReportMasterListVO> searchSimReportMasterList(SearchSimLaneListConditionVO vo) throws EventException {
    	try {
    		//레포트 조회
    		return dbDao.searchSimReportMasterList(vo);    		
    	} catch (DAOException de) {
    		log.error("err "+de.toString(),de);
    		throw new EventException(de.getMessage());
    	}
    }
    /**
     * Simulation 에서 사용하는 Creation (Variant Change)팝업 정보를 생성
     * 
     * @param MultiSimSummaryRptVO[] vos
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void multiSimReport(MultiSimSummaryRptVO[] vos,SignOnUserAccount account) throws EventException{
    	List<MultiSimSummaryRptVO> list = new ArrayList<MultiSimSummaryRptVO>();
    	try {
    		//MAS_SIM_RPT_MST 데이터 생성
    		if(vos != null) {
				for(int i=0;i<vos.length;i++) {
					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					list.add(vos[i]);
				}
    		} 
    		if(list.size() > 0) {
    			dbDao.multiSimReportMaster(list);
    			dbDao.multiSimSummaryReport(list);
    		} 
    	} catch (DAOException de) {
    		log.error("err "+de.toString(),de);
    		throw new EventException(de.getMessage());
    	}
    }
    /**
     * VSK 모듈에서 데이터를 받아서 Sim 테이블에 저장한다.
     * 
     * @param pfSkdGRPVO PfSkdGRPVO
     * @param ind Strig [I:신규,U:수정]
     * @param account
     * @return List<MasSimInfoVO>
     * @throws EventException
     */
    public List<MasSimInfoVO> createMasSimRqst(PfSkdGRPVO pfSkdGRPVO, String ind, SignOnUserAccount account) throws EventException{
    	SearchSimLaneListConditionVO searchVo = new SearchSimLaneListConditionVO();
    	Map<String, Object> param = new HashMap<String, Object>();
    	List<MasSimTmlInfoVO> list = new ArrayList<MasSimTmlInfoVO>();
    	CommonBC command = new CommonBCImpl();
    	MasSimTmlInfoVO tmlVo = null;
    	DBRowSet rowSet = null;
    	String v_sim_no = "";
    	String v_sim_dt = "";
    	int cnt = 0;
    	//VSK 개발
    	VskPfSkdVO vskPfSkdVO = pfSkdGRPVO.getVskPfSkdVO();
		List<VskPfSkdDtlVO> vskPfSkdDtlVOs = pfSkdGRPVO.getVskPfSkdDtlVOs();
    	try {
    		MasSimTmlInfoVO[] vo = new MasSimTmlInfoVO[vskPfSkdDtlVOs.size()];
    		int len = vskPfSkdDtlVOs.size();

    		for(int i=0; i<len;i++){
    			if(i == len-1){
    				vo[i] = new MasSimTmlInfoVO();
    				int simNoLen = vskPfSkdVO.getSimNo().length();
    				String tempSimNo = vskPfSkdVO.getSimNo();
    				if(simNoLen == 1){
    					tempSimNo = "00"+tempSimNo;
    				}else if(simNoLen == 2){
    					tempSimNo = "0"+tempSimNo;
    				}
        			vo[i].setSimNo(tempSimNo);
        			vo[i].setSimDt(vskPfSkdVO.getSimDt());
        			vo[i].setTmlCd(vskPfSkdDtlVOs.get(i).getPortCd()+vskPfSkdDtlVOs.get(i).getYdCd());
        			vo[i].setSkdDirCd(vskPfSkdDtlVOs.get(i).getSkdDirCd());
        			vo[i].setVslDblCallSeq(vskPfSkdDtlVOs.get(i).getClptSeq());
        			vo[i].setPortSeq(Integer.toString((i+1)));
        			vo[i].setPortDys("0");	
        			vo[i].setSeaDys("0");
        			vo[i].setTurnPortIndCd(vskPfSkdDtlVOs.get(i).getTurnPortIndCd());
        			vo[i].setBzcVslSpd("0");
        			vo[i].setCreUsrId(account.getUsr_id());
        			vo[i].setUpdUsrId(account.getUsr_id());
        			vo[i].setCrnKnt(vskPfSkdDtlVOs.get(i).getCrnKnt());
        			vo[i].setEtbDyNo(vskPfSkdDtlVOs.get(i).getEtbDyNo());
        			vo[i].setEtbDyCd(vskPfSkdDtlVOs.get(i).getEtbDyCd());
        			vo[i].setEtbTmHrmnt(vskPfSkdDtlVOs.get(i).getEtbTmHrmnt());
        			vo[i].setEtdDyNo(vskPfSkdDtlVOs.get(i).getEtdDyNo());
        			vo[i].setEtdDyCd(vskPfSkdDtlVOs.get(i).getEtdDyCd());
        			vo[i].setEtdTmHrmnt(vskPfSkdDtlVOs.get(i).getEtdTmHrmnt());
        			vo[i].setLnkSpd(vskPfSkdDtlVOs.get(i).getLnkSpd());
        			vo[i].setSeaBufSpd(vskPfSkdDtlVOs.get(i).getSeaBufSpd());
        			vo[i].setLnkDist(vskPfSkdDtlVOs.get(i).getLnkDist());
        			vo[i].setTztmHrs(vskPfSkdDtlVOs.get(i).getTztmHrs());
        			vo[i].setSeaBufHrs(vskPfSkdDtlVOs.get(i).getSeaBufHrs());
        			vo[i].setMnvrInHrs(vskPfSkdDtlVOs.get(i).getMnvrInHrs());
        			vo[i].setMnvrOutHrs(vskPfSkdDtlVOs.get(i).getMnvrOutHrs());
        			vo[i].setPortBufHrs(vskPfSkdDtlVOs.get(i).getPortBufHrs());
        			vo[i].setActWrkHrs(vskPfSkdDtlVOs.get(i).getActWrkHrs());
        			vo[i].setTmlProdQty(vskPfSkdDtlVOs.get(i).getTmlProdQty());
        			vo[i].setIbIpcgoQty(vskPfSkdDtlVOs.get(i).getIbIpcgoQty());
        			vo[i].setIbOcnCgoQty(vskPfSkdDtlVOs.get(i).getIbOcnCgoQty());
        			vo[i].setObIpcgoQty(vskPfSkdDtlVOs.get(i).getObIpcgoQty());
        			vo[i].setObOcnCgoQty(vskPfSkdDtlVOs.get(i).getObOcnCgoQty());
        			vo[i].setTurnPortFlg(vskPfSkdDtlVOs.get(i).getTurnPortFlg());
        			vo[i].setCallYdIndSeq(vskPfSkdDtlVOs.get(i).getCallYdIndSeq());
        			vo[i].setPortUsdAmt("0");
    			}else{
    				vo[i] = new MasSimTmlInfoVO();
    				int simNoLen = vskPfSkdVO.getSimNo().length();
    				String tempSimNo = vskPfSkdVO.getSimNo();
    				if(simNoLen == 1){
    					tempSimNo = "00"+tempSimNo;
    				}else if(simNoLen == 2){
    					tempSimNo = "0"+tempSimNo;
    				}
        			vo[i].setSimNo(tempSimNo);
        			vo[i].setSimDt(vskPfSkdVO.getSimDt());
        			vo[i].setTmlCd(vskPfSkdDtlVOs.get(i).getPortCd()+vskPfSkdDtlVOs.get(i).getYdCd());
        			vo[i].setSkdDirCd(vskPfSkdDtlVOs.get(i).getSkdDirCd());
        			vo[i].setVslDblCallSeq(vskPfSkdDtlVOs.get(i).getClptSeq());
        			//vo[i].setPortSeq(vskPfSkdDtlVOs.get(i).getPortRotnSeq());
        			vo[i].setPortSeq(Integer.toString((i+1)));
        			//현재 포트의 Working H + Port Buffer
        			double dSumPortDys = Double.parseDouble(vskPfSkdDtlVOs.get(i).getActWrkHrs()) + Double.parseDouble(vskPfSkdDtlVOs.get(i).getPortBufHrs());
        			if( 0 < Double.compare(dSumPortDys,0)){
        				double dTempPortDys = dSumPortDys / 24;
        				double iTempDys = 0;
        				BigDecimal bigTempPortDys = null;
        				BigDecimal bigPortDys = new BigDecimal(dTempPortDys);
        				bigTempPortDys = bigPortDys.setScale(1,bigPortDys.ROUND_HALF_UP);
        				iTempDys = bigTempPortDys.doubleValue();
        				vo[i].setPortDys(Double.toString(iTempDys));	
        			}else{
        				vo[i].setPortDys("0");	
        			}
        			//SEA_DYS  = MNVR_OUT_HRS(현재 포트) + MNVR_IN_HRS(다음 포트) + TZTM_HRS(현재 포트) + SEA_BUF_HRS(현재 포트) + (현재 포트 ZD - 다음 포트 ZD )
        			double dSumSeaDys = Double.parseDouble(vskPfSkdDtlVOs.get(i).getTztmHrs()) + Double.parseDouble(vskPfSkdDtlVOs.get(i).getSeaBufHrs())
        								+ Double.parseDouble(vskPfSkdDtlVOs.get(i).getMnvrOutHrs())+ Double.parseDouble(vskPfSkdDtlVOs.get(i+1).getMnvrInHrs()) 
        								+ (Double.parseDouble(vskPfSkdDtlVOs.get(i).getZd())) - Double.parseDouble((vskPfSkdDtlVOs.get(i+1).getZd()));
        			
        			if(0 < Double.compare(dSumSeaDys,0)){
        				double dTempSeaDys = dSumSeaDys / 24;
        				double dSeaDys = 0;
        				BigDecimal bigTempSeaDys = null;
        				BigDecimal bigSeaDys = new BigDecimal(dTempSeaDys);
        				bigTempSeaDys = bigSeaDys.setScale(1,bigSeaDys.ROUND_HALF_UP);
        				dSeaDys = bigTempSeaDys.doubleValue();
        				vo[i].setSeaDys(Double.toString(dSeaDys));
        			}else{
        				vo[i].setSeaDys("0");
        			}
        			vo[i].setTurnPortIndCd(vskPfSkdDtlVOs.get(i).getTurnPortIndCd());
        			vo[i].setBzcVslSpd("0");
        			vo[i].setCreUsrId(account.getUsr_id());
        			vo[i].setUpdUsrId(account.getUsr_id());
        			vo[i].setCrnKnt(vskPfSkdDtlVOs.get(i).getCrnKnt());
        			vo[i].setEtbDyNo(vskPfSkdDtlVOs.get(i).getEtbDyNo());
        			vo[i].setEtbDyCd(vskPfSkdDtlVOs.get(i).getEtbDyCd());
        			vo[i].setEtbTmHrmnt(vskPfSkdDtlVOs.get(i).getEtbTmHrmnt());
        			vo[i].setEtdDyNo(vskPfSkdDtlVOs.get(i).getEtdDyNo());
        			vo[i].setEtdDyCd(vskPfSkdDtlVOs.get(i).getEtdDyCd());
        			vo[i].setEtdTmHrmnt(vskPfSkdDtlVOs.get(i).getEtdTmHrmnt());
        			vo[i].setLnkSpd(vskPfSkdDtlVOs.get(i).getLnkSpd());
        			vo[i].setSeaBufSpd(vskPfSkdDtlVOs.get(i).getSeaBufSpd());
        			vo[i].setLnkDist(vskPfSkdDtlVOs.get(i).getLnkDist());
        			vo[i].setTztmHrs(vskPfSkdDtlVOs.get(i).getTztmHrs());
        			vo[i].setSeaBufHrs(vskPfSkdDtlVOs.get(i).getSeaBufHrs());
        			vo[i].setMnvrInHrs(vskPfSkdDtlVOs.get(i).getMnvrInHrs());
        			vo[i].setMnvrOutHrs(vskPfSkdDtlVOs.get(i).getMnvrOutHrs());
        			vo[i].setPortBufHrs(vskPfSkdDtlVOs.get(i).getPortBufHrs());
        			vo[i].setActWrkHrs(vskPfSkdDtlVOs.get(i).getActWrkHrs());
        			vo[i].setTmlProdQty(vskPfSkdDtlVOs.get(i).getTmlProdQty());
        			vo[i].setIbIpcgoQty(vskPfSkdDtlVOs.get(i).getIbIpcgoQty());
        			vo[i].setIbOcnCgoQty(vskPfSkdDtlVOs.get(i).getIbOcnCgoQty());
        			vo[i].setObIpcgoQty(vskPfSkdDtlVOs.get(i).getObIpcgoQty());
        			vo[i].setObOcnCgoQty(vskPfSkdDtlVOs.get(i).getObOcnCgoQty());
        			vo[i].setTurnPortFlg(vskPfSkdDtlVOs.get(i).getTurnPortFlg());
        			vo[i].setCallYdIndSeq(vskPfSkdDtlVOs.get(i).getCallYdIndSeq());
        			vo[i].setPortUsdAmt("0");
    			}
    		}
    		if(vo != null){
	    		tmlVo = vo[0];
	    		if (ind.equals("U")){// 1. ind = U 일경우  Report까지 생성되었는지 체크하여  있으면 에러 발생
	    			searchVo.setFSimDt(tmlVo.getSimDt());
	    			searchVo.setFSimNo(tmlVo.getSimNo());
	    			param.put("sim_dt", tmlVo.getSimDt());
	    			param.put("sim_no", tmlVo.getSimNo());
//	    			searchVo.setFSimDt("20090713");
//	    			searchVo.setFSimNo("001");
//	    			param.put("sim_dt", "20090713");
//	    			param.put("sim_no", "001");
	    			cnt = dbDao.searchSimProCount(searchVo);
	    			if(cnt>0){	// 1-1. I/F 후 수지분석을 진행했으면 에러 발생
//	    				throw new DAOException(new ErrorHandler("MAS00025",errMessage).getMessage());
	    				//---> 예제 : throw new EventException("수지분석 진행 중 입니다.");
	    				//throw new EventException("수지분석 진행 중 입니다.");
	    				throw new EventException(new ErrorHandler("MAS00032").getMessage());
	    			} else {	// 1-2. 작업을 하지 않았으면 mas_sim_tml_info 테이블에 데이터 Update
		    			for(int i=0; i<vo.length; i++){
//		    				vo[i].setSimDt("20090713");
//		    				vo[i].setSimNo("001");
		    				vo[i].setCreUsrId(account.getUsr_id());
		    				vo[i].setUpdUsrId(account.getUsr_id());
		    				list.add(vo[i]);
		    			}
		    			dbDao.createMasSimRqst(param, list, ind);
	    			}
	    		} else {
	    			// 2. ind = I 일경우 Sim number를 새로 부여해서 데이터를 입력
	    			//    COPY : [MAS_SIM_INFO, MAS_SIM_SVC_LANE, MAS_SIM_VSL_SET_INFO]
	    			//    INSERT : [MAS_SIM_TML_INFO]
	    			// Max Sim Number를 조회한다.
	    			v_sim_no = command.searchMaxSimNo(); 
	    			v_sim_dt = JSPUtil.getKSTDate().replaceAll("/", "");
log.debug(" v_sim_dt : " + v_sim_dt);	    			
log.debug(" v_sim_no : " + v_sim_no);	    			
//	    			param.put("f_sim_dt", "20090413");
//	    			param.put("f_sim_no", "001");
	    			param.put("f_sim_dt", tmlVo.getSimDt());
	    			param.put("f_sim_no", tmlVo.getSimNo());
	    			param.put("usr_id", account.getUsr_id());
	    			param.put("sim_dt", v_sim_dt);
	    			param.put("sim_no", v_sim_no);
	    			for(int i=0; i<vo.length; i++){
//	    				vo[i].setSimDt("20090413");
//	    				vo[i].setSimNo("001");
	    				vo[i].setSimDt(v_sim_dt);
	    				vo[i].setSimNo(v_sim_no);
	    				vo[i].setCreUsrId(account.getUsr_id());
	    				vo[i].setUpdUsrId(account.getUsr_id());
	    				list.add(vo[i]);
	    			}
	    			dbDao.createMasSimRqst(param, list, ind);
	    			// MAS_SIM_INFO에 신규로 입력한 정보를 조회하여 리턴한다
	    			rowSet = dbDao.searchSimulationNo(v_sim_dt,v_sim_no);
	    		}
    		}
    		if (rowSet != null){
    			return (List)RowSetUtil.rowSetToVOs(rowSet, MasSimInfoVO .class);
    		}else {
    			return null;
    		}
        } catch (EventException ex) {
            throw ex; 
    	} catch (DAOException de) {
    		log.error("err "+de.toString(),de);
    		throw new EventException(de.getMessage());
    	} catch(Exception e){
    		log.error("err "+e.toString(),e);
    		throw new EventException(e.getMessage());
    	} 
    }

    /*================================================================================================================*/

}
