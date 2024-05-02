/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EQCOrgChartBCImpl.java
*@FileTitle : EQC Organization Chart
*Open Issues :
*Change history :
*@LastModifyDate : 2013-06-03
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.eqcorgchart.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.eqr.cntrfcstsimul.eqcorgchart.integration.EQCOrgChartDBDAO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.eqcorgchart.vo.EQCOrgChartListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * eNIS-BIZCOMMON Business Logic Basic Command implementation<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Hyung Choon_Roh
 * @see COM_ENS_0O1EventResponse,EQOrgChartBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class EQCOrgChartBCImpl   extends BasicCommandSupport implements EQCOrgChartBC {

	// Database Access Object
	private transient EQCOrgChartDBDAO dbDao=null;

	/**
	 * EQOrgChartBCImpl 객체 생성<br>
	 * EQOrgChartDBDAO를 생성한다.<br>
	 */
	public EQCOrgChartBCImpl(){
		dbDao = new EQCOrgChartDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * EQOrgChart화면에 대한 조회 이벤트 처리<br>
	 * @param String depth
	 * @param String chkDepth
	 * @param SignOnUserAccount account
	 * @return List<EQQrgChartListVO>
	 * @exception EventException
	 */
	public List<EQCOrgChartListVO> searchEQCOrgChartList(String depth, String chkDepth, SignOnUserAccount account) throws EventException {
		List<EQCOrgChartListVO> list = null;
		int cnt = 0;
        String creUsrId = account.getUsr_id();
        try {
        	cnt    = dbDao.totalEQCOrgChartList(depth, chkDepth);
        	list   = dbDao.searchEQCOrgChartList(depth, chkDepth, creUsrId);
            
        	if(list.size()>0){
        		list.get(0).setMaxRows(cnt);
        	}
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (Exception e2) {
			log.error("err "+e2.toString(),e2);
            throw new EventException(e2.getMessage());
		}
        return list;
	}
	
	/**
	 * EQC Organization Chart 화면에 대한 저장 이벤트 처리<br>
	 * @param EQCOrgChartListVO[] eQCOrgChartListVOs
	 * @param SignOnUserAccount account
	 * @return int[]
	 * @exception EventException
	 */
	public int[] multiEqrCtrlFcastLocBasic(EQCOrgChartListVO[] eQCOrgChartListVOs, SignOnUserAccount account) throws EventException {
		int[] result = null;
        String usrId = account.getUsr_id();
        try {
        	List<EQCOrgChartListVO> insertVoList = new ArrayList<EQCOrgChartListVO>();		
			
			for ( int i=0; i<eQCOrgChartListVOs.length; i++ ) {
				if ( eQCOrgChartListVOs[i].getChk().equals("1")){
					eQCOrgChartListVOs[i].setCreUsrId(account.getUsr_id());					
					insertVoList.add(eQCOrgChartListVOs[i]);
				}
			}
			
			dbDao.removeEqrCtrlFcastLocData(usrId);
			if ( insertVoList.size() > 0 ) {
				result = dbDao.addEqrCtrlFcastLocData(insertVoList);
			}
        	
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (Exception e2) {
			log.error("err "+e2.toString(),e2);
            throw new EventException(e2.getMessage());
		}
        return result;
	}
	
	/**
	 * BIZCOMMON 업무 시나리오 마감작업<br>
	 * EQOrgChart업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}