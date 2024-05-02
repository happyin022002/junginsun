/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ManualCntrMappBCImpl.java
*@FileTitle : Manual Container Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 2008-03-03
*@LastModifier : Hun-Il Jung
*@LastVersion : 1.0
* 2008-03-03 Hun-Il Jung
* 1.0 최초 생성
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.BkgCopManageVO;
import com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.integration.ManualCntrlMappDBDAO;
import com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.vo.ManualReplanInfoVO;
import com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.vo.SearchCntrMapgListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.SceCopHdrVO;

/**
 * ENIS-SCEM Business Logic Basic Command implementation<br> - ENIS-SCEM에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author yong_cheon_shin
 * @see EsdSce028EventResponse,ExceptionDataBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ManualCntrMappBCImpl extends BasicCommandSupport implements ManualCntrMappBC {

	private static final long serialVersionUID = 1L;
	// Database Access Object
	private transient ManualCntrlMappDBDAO dbDao = null;

	/**
	 * ScemSetupBCImpl 객체 생성<br>
	 * ScemSetupDBDAO를 생성한다.<br>
	 */
	public ManualCntrMappBCImpl() {
		dbDao = new ManualCntrlMappDBDAO();
	}

    /**
     * Manual Container Mapping(하단리스트 조회) &&&
     * @param ManualReplanInfoVO[] inqVOs
     * @return List<SceCopHdrVO>
     * @throws EventException
     */
	public List<SceCopHdrVO>  searchCopMapgList(ManualReplanInfoVO[] inqVOs) throws EventException {
		
		List<SceCopHdrVO> list = null;
		try {

			list = dbDao.searchCopMapgList( inqVOs);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return list;
	}
    /**
     * Manual Container Mapping(상단리스트 조회) &&&
     * @param ManualReplanInfoVO inqVO
     * @return List<SearchCntrMapgListVO>
     * @throws EventException
     */
	public List<SearchCntrMapgListVO> searchCntrMapgList(ManualReplanInfoVO inqVO) throws EventException {
		List<SearchCntrMapgListVO> list = null;

		try {
			list = dbDao.searchCntrMapgList(inqVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return list;
	}

    /**
     * Manual Container Mapping(Save-저장) &&&
     *
     * @param BkgCopManageVO[] vos
     * @throws EventException
     */
	public void multiCntrMapg(BkgCopManageVO[] vos) throws EventException {

		log.debug("\n BC.multiCntrMapg  vos:"+vos+" --------------------------");
		try {
			//dbDao.multiCntrMapg1(event.getDataSet());
			BkgCopManageBC command = new BkgCopManageBCImpl();
			if(vos != null){
				for(int i=0; i<vos.length; i++){
					BkgCopManageVO bkgCopManageVO = vos[i];
					command.attachCntr(bkgCopManageVO.getBkgNo(), bkgCopManageVO.getCntrNo(), bkgCopManageVO.getFlgPartial());
				}
			}

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	
//	/**
//	 * Manual Container Mapping(Save-저장) &&&
//	 *
//	 * @param e
//	 *            Event
//	 * @return EventResponse
//	 * @throws EventException
//	 */
//	public EventResponse multiCntrMapg1(Event e) throws EventException {
//		EsdSce0115Event event = (EsdSce0115Event) e; // PDTO(Data Transfer Object including Parameters)
//		log.debug("\n BC.multiCntrMapg1--------------------------");
//		try {
//			dbDao.multiCntrMapg1(event.getDataSet());
//			return null; //searchCntrMapgList( e);
////			return null;
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}
//
//	/**
//	 * Manual Container Mapping(Save-저장) &&&
//	 *
//	 * @param e
//	 *            Event
//	 * @return EventResponse
//	 * @throws EventException
//	 */
//	public EventResponse multiCntrMapg2(Event e) throws EventException {
//		EsdSce0115Event event = (EsdSce0115Event) e; // PDTO(Data Transfer Object including Parameters)
//		log.debug("\n BC.multiCntrMapg2--------------------------");
//		try {
//			dbDao.multiCntrMapg2(event.getDataSet());
//			return null; //searchCntrMapgList( e);
////			return null;
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}
//	
}