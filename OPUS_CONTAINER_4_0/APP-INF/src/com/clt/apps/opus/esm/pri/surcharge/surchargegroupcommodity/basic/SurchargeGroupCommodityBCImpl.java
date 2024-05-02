/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonGroupCommodityBCImpl.java
*@FileTitle : GRI COMM Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.integration.SurchargeGroupCommodityDBDAO;
import com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.vo.CommonGroupCommodityVO;
import com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.vo.RsltPriComGrpCmdtExcelVO;
import com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.vo.RsltPriScgGrpCmdtDtlVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriScgGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriScgGrpCmdtVO;

/**
 * Surcharge Business Logic Basic Command implementation<br>
 * - handling biz logic about Surcharge <br>
 *
 * @author  
 * @see ESM_PRI_4008EventResponse,CommonGroupCommodityBC reference each DAO class
 * @since J2EE 1.4
 */

public class SurchargeGroupCommodityBCImpl extends BasicCommandSupport implements SurchargeGroupCommodityBC {

	// Database Access Object
	private transient SurchargeGroupCommodityDBDAO dbDao = null;

	/**
	 * CommonGroupCommodityBCImpl object creation<br>
	 * creating CommonGroupCommodityDBDAO<br>
	 */
	public SurchargeGroupCommodityBCImpl() {
		dbDao = new SurchargeGroupCommodityDBDAO();
	}

	/**
	 * Retrieving GRI Commodity screen<br>
	 * 
	 * @param CommonGroupCommodityVO commonGroupCommodity
	 * @return CommonGroupCommodityVO
	 * @exception EventException
	 */
//	public CommonGroupCommodityVO searchGRICommodityList(CommonGroupCommodityVO commonGroupCommodity) throws EventException {
//		try {
//			CommonGroupCommodityVO commonGroupCommodityVO = new CommonGroupCommodityVO();
//			//Group Location, detail
//			List<PriScgGrpCmdtVO> priComGrpCmdtVOList 					= new ArrayList<PriScgGrpCmdtVO>();
//			List<RsltPriScgGrpCmdtDtlVO> rsltPriComGrpCmdtDtlVOList 	= new ArrayList<RsltPriScgGrpCmdtDtlVO>();
//			
//			int maxSeq = 0;
//			String searchGubun = "";
//			PriScgGrpCmdtVO priComGrpCmdtVO 		= new PriScgGrpCmdtVO();
//			//PriComGrpCmdtDtlVO priComGrpCmdtDtlVO   = new PriComGrpCmdtDtlVO();
//			
//			searchGubun = commonGroupCommodity.getSearchGubun();
//			priComGrpCmdtVO = commonGroupCommodity.getPriScgGrpCmdtVO();
//			//priComGrpCmdtDtlVO = commonGroupCommodity.getPriComGrpCmdtDtlVO();

//			if("1".equals(searchGubun)) {
//				priComGrpCmdtVOList 	= dbDao.searchGRICommodityList(priComGrpCmdtVO);
//				commonGroupCommodityVO.setPriScgGrpCmdtVOList(priComGrpCmdtVOList);
//				//max seq
//				maxSeq = dbDao.searchGRICommodityMaxSeq(priComGrpCmdtVO);
//				commonGroupCommodityVO.setMaxSeq(String.valueOf(maxSeq));
//			}	
//			else if("2".equals(searchGubun)) {
//				rsltPriComGrpCmdtDtlVOList 	= dbDao.searchGRICommodityDetailList(priComGrpCmdtVO);
//				commonGroupCommodityVO.setRsltPriScgGrpCmdtDtlVOList(rsltPriComGrpCmdtDtlVOList);
//			}	
//			else if("3".equals(searchGubun)) {
//				priComGrpCmdtVOList 	= dbDao.searchGRICommodityList(priComGrpCmdtVO);
//				commonGroupCommodityVO.setPriScgGrpCmdtVOList(priComGrpCmdtVOList);
//				
//				rsltPriComGrpCmdtDtlVOList 	= dbDao.searchGRICommodityDetailList(priComGrpCmdtVO);
//				commonGroupCommodityVO.setRsltPriScgGrpCmdtDtlVOList(rsltPriComGrpCmdtDtlVOList);
//			}
//			
//			return commonGroupCommodityVO;
//			
//		} catch (DAOException ex) {
//			ex.printStackTrace();
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}
//	}

	
    /**
     * Retrieving GRI Commodity's Master list<br>
     * 
     * @param PriScgGrpCmdtVO priScgGrpCmdtVO
     * @return CommonGroupCommodityVO
     * @exception EventException
     */
    public CommonGroupCommodityVO searchSurchargeGroupCommodityList(PriScgGrpCmdtVO priScgGrpCmdtVO) throws EventException {
        try {

            CommonGroupCommodityVO commonGroupCommodityVO = new CommonGroupCommodityVO();
            //Group Location, detail
            List<PriScgGrpCmdtVO> priComGrpCmdtVOList                   = new ArrayList<PriScgGrpCmdtVO>();
            
            int maxSeq = 0;

            priComGrpCmdtVOList     = dbDao.searchSurchargeGroupCommodityList(priScgGrpCmdtVO);
            commonGroupCommodityVO.setPriScgGrpCmdtVOList(priComGrpCmdtVOList);
            //max seq
            maxSeq = dbDao.searchGRICommodityMaxSeq(priScgGrpCmdtVO);
            commonGroupCommodityVO.setMaxSeq(String.valueOf(maxSeq));
            
            return commonGroupCommodityVO;
            
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
    }
	
    /**
     * Retrieving GRI Commodity's Detail list<br>
     * 
     * @param PriScgGrpCmdtVO priScgGrpCmdtVO
     * @return List<RsltPriScgGrpCmdtDtlVO>
     * @exception EventException
     */
    public List<RsltPriScgGrpCmdtDtlVO> searchSurchargeGroupCommodityDetailList(PriScgGrpCmdtVO priScgGrpCmdtVO) throws EventException {
        try {
            return dbDao.searchSurchargeGroupCommodityDetailList(priScgGrpCmdtVO);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
    }
    
    
    /**
     * Retrieving GRI Commodity's Download Excel list<br>
     * 
     * @param PriScgGrpCmdtVO priScgGrpCmdtVO
     * @return List<RsltPriComGrpCmdtExcelVO>
     * @exception EventException
     */
    public List<RsltPriComGrpCmdtExcelVO> searchSurchargeGroupCommodityExcelList(PriScgGrpCmdtVO priScgGrpCmdtVO) throws EventException {
        try {
            return dbDao.searchSurchargeGroupCommodityExcelList(priScgGrpCmdtVO);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
    }
	
	/**
	 * Saving GRI Commodity information <br>
	 * 
	 * @param CommonGroupCommodityVO commonGroupCommodityVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSurchargeGroupCommodity(CommonGroupCommodityVO commonGroupCommodityVO, SignOnUserAccount account) throws EventException{
		try {

			PriScgGrpCmdtVO[] priComGrpCmdtVOs 			= commonGroupCommodityVO.getPriScgGrpCmdtVOs();
			PriScgGrpCmdtDtlVO[] priComGrpCmdtDtlVOs 	= commonGroupCommodityVO.getPriScgGrpCmdtDtlVOs();
			
			//commodity
			List<PriScgGrpCmdtVO> insertVoList = new ArrayList<PriScgGrpCmdtVO>();
			List<PriScgGrpCmdtVO> updateVoList = new ArrayList<PriScgGrpCmdtVO>();
			List<PriScgGrpCmdtVO> deleteVoList = new ArrayList<PriScgGrpCmdtVO>();
			//commodity detail 
			List<PriScgGrpCmdtDtlVO> insertDtlVoList = new ArrayList<PriScgGrpCmdtDtlVO>();
			List<PriScgGrpCmdtDtlVO> updateDtlVoList = new ArrayList<PriScgGrpCmdtDtlVO>();
			List<PriScgGrpCmdtDtlVO> deleteDtlVoList = new ArrayList<PriScgGrpCmdtDtlVO>();
			
			//Group Location
			for (int i = 0; priComGrpCmdtVOs != null && i < priComGrpCmdtVOs.length; i++) {
				
				if ( priComGrpCmdtVOs[i].getIbflag().equals("I")){
					priComGrpCmdtVOs[i].setCreUsrId(account.getUsr_id());
					priComGrpCmdtVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priComGrpCmdtVOs[i]);
				} else if ( priComGrpCmdtVOs[i].getIbflag().equals("U")){
					priComGrpCmdtVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priComGrpCmdtVOs[i]);
				} else if ( priComGrpCmdtVOs[i].getIbflag().equals("D")){
					priComGrpCmdtVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priComGrpCmdtVOs[i]);
					dbDao.removeGRICommodityDetail(priComGrpCmdtVOs[i]);
					priComGrpCmdtDtlVOs = null;
				}
				
			}
			
			//detail
			for (int i = 0; priComGrpCmdtDtlVOs != null && i < priComGrpCmdtDtlVOs.length; i++) {
				
				if ( priComGrpCmdtDtlVOs[i].getIbflag().equals("I")) {
					priComGrpCmdtDtlVOs[i].setCreUsrId(account.getUsr_id());
					priComGrpCmdtDtlVOs[i].setUpdUsrId(account.getUsr_id());
					insertDtlVoList.add(priComGrpCmdtDtlVOs[i]);
				} else if ( priComGrpCmdtDtlVOs[i].getIbflag().equals("U")){
					priComGrpCmdtDtlVOs[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(priComGrpCmdtDtlVOs[i]);
				} else if ( priComGrpCmdtDtlVOs[i].getIbflag().equals("D")){
					deleteDtlVoList.add(priComGrpCmdtDtlVOs[i]);
				}
			}
			
			
			if (insertVoList.size() > 0) {
				dbDao.addGRICommodityS(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addGRICommodityDetailS(insertDtlVoList);
			}
			
			if (updateVoList.size() > 0) {
				dbDao.modifyGRICommodityS(updateVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyGRICommodityDetailS(updateDtlVoList);
			}
			
			if (deleteDtlVoList.size() > 0) {
				dbDao.removeGRICommodityDetailS(deleteDtlVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeGRICommodityS(deleteVoList);
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