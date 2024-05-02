/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GEMClosingScheduleMgtBCImpl.java
 *@FileTitle : Closing Confirmation & Interface Status
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.22
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.22 최정미
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemclosingschedulemgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.cps.gem.gemcommon.gemclosingschedulemgt.integration.GEMClosingScheduleMgtDBDAO;
import com.clt.apps.opus.cps.gem.gemcommon.gemclosingschedulemgt.vo.GemMonClzVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemclosingschedulemgt.vo.MonClzVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-GEMCommon Business Logic Basic Command implementation<br>
 * - NIS2010-GEMCommon에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author choijungmi
 * @see UI_GEM_0006EventResponse,GEMMasterCodeMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class GEMClosingScheduleMgtBCImpl extends BasicCommandSupport implements GEMClosingScheduleMgtBC {
	// Database Access Object
	private transient GEMClosingScheduleMgtDBDAO scheduleMgtDBDAO = null;

	/**
	 * GEMClosingScheduleMgtBCImpl 객체 생성<br>
	 * GEMClosingScheduleMgtDBDAO를 생성한다.<br>
	 */
	public GEMClosingScheduleMgtBCImpl() {
		scheduleMgtDBDAO = new GEMClosingScheduleMgtDBDAO();
	}

	// C.J.M
	// ===========================================================================

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0006] Closing Confirmation & Interface Status
	// ---------------------------------------------------------------------------
	
	/**
	 * 일반관리비 비용계획 수립 일정(마감)을 입력하고, 현지법인실적 입력일정 정보 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0006
	 * @category searchClosingInfo
	 * 
	 * @param year
	 * 
	 * @return List<GemMonClzVO>
	 * @exception EventException
	 */
	public List<MonClzVO> searchClosingInfo(String year) throws EventException {
		try {
			
			List<MonClzVO> returnList = new ArrayList<MonClzVO>();
			
	        List<GemMonClzVO> inList = scheduleMgtDBDAO.searchClosingInfo("IN", year);
	        List<GemMonClzVO> atList = scheduleMgtDBDAO.searchClosingInfo("AT", year);
	        
	        for(int i=0; i<13; i++) {
	        	MonClzVO monClzVO = new MonClzVO();
	        	
	        	String clzYrmon = "";
	        	if(i<10) clzYrmon = year+"0"+i;
	        	else clzYrmon = year+i;
	        	
	        	monClzVO.setInClzDivCd("IN");
	        	monClzVO.setInClzYrmon(clzYrmon);
	        	monClzVO.setInGlIfFlg("0");
	        	
	        	monClzVO.setAtClzDivCd("AT");
	        	monClzVO.setAtClzYrmon(clzYrmon);
	        	
	        	returnList.add(monClzVO);        	
	        }
	        
	        if(inList.size() > 0 || atList.size() > 0 ) {	        
		        // in
		        for(int i=0; i<inList.size(); i++) {
		        	GemMonClzVO inDTO = inList.get(i);
		        	
		        	String mm = inDTO.getClzYrmon();
		        	if(mm != null  && mm.length() > 0 ) {
		        		mm = mm.substring(4,6);
		        		int mmIdx = Integer.parseInt(mm);
		        		
		        		if(mmIdx == 13) mmIdx = 0;
		        		
		        		MonClzVO monClzVO = returnList.get(mmIdx);
		        			        		
		        		monClzVO.setInClzYrmon(inDTO.getClzYrmon());
		        		monClzVO.setInClzDivCd(inDTO.getClzDivCd());
		        		monClzVO.setInClzDt(inDTO.getClzDt());
		        		monClzVO.setInClzFlg(inDTO.getClzFlg());
		        		monClzVO.setInGlIfFlg(inDTO.getGlIfFlg());
		        		monClzVO.setInCreUsrId(inDTO.getCreUsrId());
		        		monClzVO.setInCreDt(inDTO.getCreDt());
		        		monClzVO.setInUpdUsrId(inDTO.getUpdUsrId());
		        		monClzVO.setInUpdDt(inDTO.getUpdDt());
		        	}
		        }
		        
		        // at
		        for(int i=0; i<atList.size(); i++) {
		        	GemMonClzVO atDTO = atList.get(i);
		        	
		        	String mm = atDTO.getClzYrmon();
		        	if(mm != null  && mm.length() > 0 ) {
		        		mm = mm.substring(4,6);
		        		int mmIdx = Integer.parseInt(mm);
		        		
		        		if(mmIdx == 13) mmIdx = 0;
		        		
		        		MonClzVO monClzVO = returnList.get(mmIdx);
		        			        		
		        		monClzVO.setAtClzYrmon(atDTO.getClzYrmon());
		        		monClzVO.setAtClzDivCd(atDTO.getClzDivCd());
		        		monClzVO.setAtClzDt(atDTO.getClzDt());
		        		monClzVO.setAtClzFlg(atDTO.getClzFlg());
		        		monClzVO.setAtCreUsrId(atDTO.getCreUsrId());
		        		monClzVO.setAtCreDt(atDTO.getCreDt());
		        		monClzVO.setAtUpdUsrId(atDTO.getUpdUsrId());
		        		monClzVO.setAtUpdDt(atDTO.getUpdDt());
		        	}
		        }
	        }
			return returnList;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}

	/**
	 * CPS_GEM_0006 멀티 이벤트 처리<br>
	 * In화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0006
	 * @category searchClosingInfo 
	 * @param MonClzVO[] monClzVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void manageClosingInfo(MonClzVO[] monClzVOs, String userId) throws EventException {
		try {
			List<GemMonClzVO> insertVoList = new ArrayList<GemMonClzVO>();
			List<GemMonClzVO> deleteVoList = new ArrayList<GemMonClzVO>();
			
 			// in 수정년도 삭제
			for (int i = 0; i < monClzVOs.length; i++) {
				GemMonClzVO gemMonClzVO = new GemMonClzVO();
				gemMonClzVO.setClzDivCd(monClzVOs[i].getInClzDivCd());
				gemMonClzVO.setClzYrmon(monClzVOs[i].getInClzYrmon());
				
				deleteVoList.add(gemMonClzVO);
			}
			// at 수정년도 삭제
			for (int i = 0; i < monClzVOs.length; i++) {
				GemMonClzVO gemMonClzVO = new GemMonClzVO();
				gemMonClzVO.setClzDivCd(monClzVOs[i].getAtClzDivCd());
				gemMonClzVO.setClzYrmon(monClzVOs[i].getAtClzYrmon());
				
				deleteVoList.add(gemMonClzVO);				
			}
			
			log.info("##### deleteVoList.size() : "+deleteVoList.size());
			if (deleteVoList.size() > 0) {
				scheduleMgtDBDAO.removeCloasingInfo(deleteVoList);
			}
						
			// in 수정년도 입력
			for (int i = 0; i < monClzVOs.length; i++) {				
        		GemMonClzVO gemMonClzVO = new GemMonClzVO();
        		if(!monClzVOs[i].getInClzDt().equals("")) {
	        		gemMonClzVO.setClzYrmon(monClzVOs[i].getInClzYrmon());
	        		gemMonClzVO.setClzDivCd(monClzVOs[i].getInClzDivCd());
	        		gemMonClzVO.setClzDt(monClzVOs[i].getInClzDt().replace("-", ""));
	        		gemMonClzVO.setClzFlg(monClzVOs[i].getInClzFlg().equals("1")?"Y":"N");
	        		gemMonClzVO.setGlIfFlg(monClzVOs[i].getInGlIfFlg().equals("1")?"Y":"N");
	        		
	        		gemMonClzVO.setCreUsrId(userId);
	        		gemMonClzVO.setCreDt(DateTime.getDateString().replace(".", "-") +" "+ DateTime.getTimeString());
	        		
	        		gemMonClzVO.setUpdUsrId(userId);
	        		insertVoList.add(gemMonClzVO);
        		}
			}
			
			// at 수정년도 입력
			for (int i = 0; i < monClzVOs.length; i++) {	        		
        		GemMonClzVO gemMonClzVO = new GemMonClzVO();
        		if(!monClzVOs[i].getAtClzDt().equals("")) {
	        		gemMonClzVO.setClzYrmon(monClzVOs[i].getAtClzYrmon());
	        		gemMonClzVO.setClzDivCd(monClzVOs[i].getAtClzDivCd());
	        		gemMonClzVO.setClzDt(monClzVOs[i].getAtClzDt().replace("-", ""));
	        		gemMonClzVO.setClzFlg(monClzVOs[i].getAtClzFlg().equals("1")?"Y":"N");
	        		gemMonClzVO.setGlIfFlg("N");
	        		
	        		gemMonClzVO.setCreUsrId(userId);
	        		gemMonClzVO.setCreDt(DateTime.getDateString().replace(".", "-") +" "+ DateTime.getTimeString());
	        		
	        		gemMonClzVO.setUpdUsrId(userId);
	        		insertVoList.add(gemMonClzVO);
        		}
			}
			
			log.info("##### insertVoList.size() : "+insertVoList.size());
			if (insertVoList.size() > 0) {
				scheduleMgtDBDAO.addClosingInfo(insertVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
}