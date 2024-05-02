/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurchargeGroupLocationBCImpl.java
*@FileTitle : Surcharge Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.06 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.surchargegrouplocation.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.surcharge.surchargegrouplocation.integration.SurchargeGroupLocationDBDAO;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegrouplocation.vo.RsltPriScgGrpLocDtlVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegrouplocation.vo.RsltPriScgGrpLocVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegrouplocation.vo.SurchargeGroupLocationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriScgGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriScgGrpLocVO;

/**
 * NIS2010-Surcharge Business Logic Basic Command implementation<br>
 * - NIS2010-Surcharge에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Seung Jun Lee
 * @see ESM_PRI_4004EventResponse,SurchargeGroupLocationBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class SurchargeGroupLocationBCImpl extends BasicCommandSupport implements SurchargeGroupLocationBC {

	// Database Access Object
	private transient SurchargeGroupLocationDBDAO dbDao = null;

	/**
	 * SurchargeGroupLocationBCImpl 객체 생성<br>
	 * ${DAO}DAO를 생성한다.<br>
	 */
	public SurchargeGroupLocationBCImpl() {
		dbDao = new SurchargeGroupLocationDBDAO();
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 *  SurchargeGroupLocation화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SurchargeGroupLocationVO surchargeGroupLocation
	 * @return SurchargeGroupLocationVO
	 * @exception EventException
	 */
	public SurchargeGroupLocationVO searchGroupLocationList(SurchargeGroupLocationVO surchargeGroupLocation) throws EventException {
		try {
			//컨테이너 vo
			SurchargeGroupLocationVO surchargeGroupLocationVO = new SurchargeGroupLocationVO();
			//Group Location, detail
			List<RsltPriScgGrpLocVO> rsltPriScgGrpLocVOList 		= new ArrayList<RsltPriScgGrpLocVO>();
			List<RsltPriScgGrpLocDtlVO> rsltPriScgGrpLocDtlVOList 	= new ArrayList<RsltPriScgGrpLocDtlVO>();
			
			int maxSeq = 0;
			String searchGubun = "";
			PriScgGrpLocVO priScgGrpLocVO 		= new PriScgGrpLocVO();
			PriScgGrpLocDtlVO priScgGrpLocDtlVO = new PriScgGrpLocDtlVO();
			
			//param으로 넘어온 container vo를 각 vo로 셋한다
			searchGubun = surchargeGroupLocation.getSearchGubun();
			priScgGrpLocVO = surchargeGroupLocation.getPriScgGrpLocVO();
			priScgGrpLocDtlVO = surchargeGroupLocation.getPriScgGrpLocDtlVO();
			
			//각 리스트를 받아서 컨테이너 vo에 담는다
			if("1".equals(searchGubun)) {
				rsltPriScgGrpLocVOList 	= dbDao.searchGroupLocationList(priScgGrpLocVO);
				surchargeGroupLocationVO.setRsltPriScgGrpLocVOList(rsltPriScgGrpLocVOList);
				
				//시퀀스 맥스값을 구한다
				maxSeq = dbDao.searchGroupLocationMaxSeq(priScgGrpLocVO);
				surchargeGroupLocationVO.setMaxSeq(String.valueOf(maxSeq));
			}	
			else if("2".equals(searchGubun)) {
				rsltPriScgGrpLocDtlVOList 	= dbDao.searchGroupLocationDetailList(priScgGrpLocDtlVO);
				surchargeGroupLocationVO.setRsltPriScgGrpLocDtlVOList(rsltPriScgGrpLocDtlVOList);
			}	
			else if("3".equals(searchGubun)) {
				rsltPriScgGrpLocVOList 	= dbDao.searchGroupLocationList(priScgGrpLocVO);
				surchargeGroupLocationVO.setRsltPriScgGrpLocVOList(rsltPriScgGrpLocVOList);
				
				rsltPriScgGrpLocDtlVOList 	= dbDao.searchGroupLocationDetailList(priScgGrpLocDtlVO);
				surchargeGroupLocationVO.setRsltPriScgGrpLocDtlVOList(rsltPriScgGrpLocDtlVOList);
			}
			
			return surchargeGroupLocationVO;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * SurchargeGroupLocation화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param SurchargeGroupLocationVO surchargeGroupLocation
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageGroupLocation(SurchargeGroupLocationVO surchargeGroupLocation, SignOnUserAccount account) throws EventException{
		try {
		
			//컨테이너 vo에서 Group Location, detail을 뺀다
			PriScgGrpLocVO[] priScgGrpLocVOs 		= surchargeGroupLocation.getPriScgGrpLocVOs();
			PriScgGrpLocDtlVO[] priScgGrpLocDtlVOs 	= surchargeGroupLocation.getPriScgGrpLocDtlVOs();
			
			//Group Location
			List<PriScgGrpLocVO> insertVoList = new ArrayList<PriScgGrpLocVO>();
			List<PriScgGrpLocVO> updateVoList = new ArrayList<PriScgGrpLocVO>();
			List<PriScgGrpLocVO> deleteVoList = new ArrayList<PriScgGrpLocVO>();
			//Group Locationdetail 
			List<PriScgGrpLocDtlVO> insertDtlVoList = new ArrayList<PriScgGrpLocDtlVO>();
			List<PriScgGrpLocDtlVO> updateDtlVoList = new ArrayList<PriScgGrpLocDtlVO>();
			List<PriScgGrpLocDtlVO> deleteDtlVoList = new ArrayList<PriScgGrpLocDtlVO>();

			
			////////////////////////////Group Location / detail 저장/////////////////////////////////////	
			
			//Group Location
			for (int i = 0; priScgGrpLocVOs != null && i < priScgGrpLocVOs.length; i++) {
				
				if ( priScgGrpLocVOs[i].getIbflag().equals("I")){
					priScgGrpLocVOs[i].setCreUsrId(account.getUsr_id());
					priScgGrpLocVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priScgGrpLocVOs[i]);
				} else if ( priScgGrpLocVOs[i].getIbflag().equals("U")){
					priScgGrpLocVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priScgGrpLocVOs[i]);
				} else if ( priScgGrpLocVOs[i].getIbflag().equals("D")){
					priScgGrpLocVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priScgGrpLocVOs[i]);
					//본문별 디테일 삭제
					dbDao.removeGroupLocationDetail(priScgGrpLocVOs[i]);
					//디테일을 이미 삭제 했으므로 널로 세팅
					priScgGrpLocDtlVOs = null;
				}
				
			}
			
			//detail
			for (int i = 0; priScgGrpLocDtlVOs != null && i < priScgGrpLocDtlVOs.length; i++) {
				
				if ( priScgGrpLocDtlVOs[i].getIbflag().equals("I")) {
					priScgGrpLocDtlVOs[i].setCreUsrId(account.getUsr_id());
					priScgGrpLocDtlVOs[i].setUpdUsrId(account.getUsr_id());

					insertDtlVoList.add(priScgGrpLocDtlVOs[i]);
				} else if ( priScgGrpLocDtlVOs[i].getIbflag().equals("U")){
					priScgGrpLocDtlVOs[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(priScgGrpLocDtlVOs[i]);
				} else if ( priScgGrpLocDtlVOs[i].getIbflag().equals("D")){
					deleteDtlVoList.add(priScgGrpLocDtlVOs[i]);
				}
			}
			
			
			if (insertVoList.size() > 0) {
				dbDao.addGroupLocation(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addGroupLocationDetail(insertDtlVoList);
			}
			
			if (updateVoList.size() > 0) {
				dbDao.modifyGroupLocation(updateVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyGroupLocationDetail(updateDtlVoList);
			}
			
			if (deleteDtlVoList.size() > 0) {
				dbDao.removeGroupLocationDetail(deleteDtlVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeGroupLocation(deleteVoList);
			}
			
		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
}