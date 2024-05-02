/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ManualCntrMappBCImpl.java
*@FileTitle : Manual Container Mapping
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.sce.copreport.manualcntrmapping.basic;

import java.util.List;

import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.BkgCopManageVO;
import com.clt.apps.opus.esd.sce.copreport.manualcntrmapping.integration.ManualCntrlMappDBDAO;
import com.clt.apps.opus.esd.sce.copreport.manualcntrmapping.vo.ManualReplanInfoVO;
import com.clt.apps.opus.esd.sce.copreport.manualcntrmapping.vo.SearchCntrMapgListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.SceCopHdrVO;

/**
 * SCEM Business Logic Basic Command implementation<br> - SCEM handling business logic.<br>
 *
 * @author 
 * @see EsdSce028EventResponse,ExceptionDataBCImpl related objects creation
 * @since J2EE 1.4
 */
public class ManualCntrMappBCImpl extends BasicCommandSupport implements ManualCntrMappBC {
	private transient ManualCntrlMappDBDAO dbDao = null;

	/**
	 * ScemSetupBCImpl related objects creation<br>
	 * ScemSetupDBDAOrelated objects creation.<br>
	 */
	public ManualCntrMappBCImpl() {
		dbDao = new ManualCntrlMappDBDAO();
	}

    /**
     * Manual Container Mapping(The bottom of the Display List) &&&
     * @param ManualReplanInfoVO[] inqVOs
     * @return List<SceCopHdrVO>
     * @throws EventException
     */
	public List<SceCopHdrVO>  searchCopMapgList(ManualReplanInfoVO[] inqVOs) throws EventException {
		//EsdSce0115Event event = (EsdSce0115Event) e;
//		DBRowSet rowSet = null;
		List<SceCopHdrVO> list = null;
		try {
			//rowSet = dbDao.searchCopMapgList(event.getDataSet());
			list = dbDao.searchCopMapgList( inqVOs);
			
			//return new EsdSce0115EventResponse(rowSet, "SUCCESS");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return list;
	}
    /**
     * Manual Container Mapping(Display List of top) &&&
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
     * Manual Container Mapping(Save) &&&
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

	
}