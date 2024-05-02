/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonGroupCommodityBCImpl.java
*@FileTitle : GRI COMM Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.08 이승준
* 1.0 Creation
=========================================================
* 2016.02.04 전지예 [CHM-201640066] TPW Non-Cargo NOS 체크 권한 로직 부여 Request by Hye-In Ahn
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.integration.SurchargeGroupCommodityDBDAO;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.vo.CommonGroupCommodityVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.vo.RsltPriComGrpCmdtExcelVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.vo.RsltPriScgGrpCmdtDtlVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriScgGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriScgGrpCmdtVO;

/**
 * NIS2010-Surcharge Business Logic Basic Command implementation<br>
 * - NIS2010-Surcharge에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Seung Jun Lee
 * @see ESM_PRI_4008EventResponse,CommonGroupCommodityBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class SurchargeGroupCommodityBCImpl extends BasicCommandSupport implements SurchargeGroupCommodityBC {

	// Database Access Object
	private transient SurchargeGroupCommodityDBDAO dbDao = null;

	/**
	 * CommonGroupCommodityBCImpl 객체 생성<br>
	 * CommonGroupCommodityDBDAO를 생성한다.<br>
	 */
	public SurchargeGroupCommodityBCImpl() {
		dbDao = new SurchargeGroupCommodityDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * GRI Commodity 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param CommonGroupCommodityVO commonGroupCommodity
	 * @return CommonGroupCommodityVO
	 * @exception EventException
	 */
//	public CommonGroupCommodityVO searchGRICommodityList(CommonGroupCommodityVO commonGroupCommodity) throws EventException {
//		try {
//			//컨테이너 vo
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
//			//param으로 넘어온 container vo를 각 vo로 셋한다
//			searchGubun = commonGroupCommodity.getSearchGubun();
//			priComGrpCmdtVO = commonGroupCommodity.getPriScgGrpCmdtVO();
//			//priComGrpCmdtDtlVO = commonGroupCommodity.getPriComGrpCmdtDtlVO();
//			
//			//각 리스트를 받아서 컨테이너 vo에 담는다
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
     * 조회 이벤트 처리<br>
     * GRI Commodity 화면에 대한 Master 조회 이벤트 처리<br>
     * 
     * @param PriScgGrpCmdtVO priScgGrpCmdtVO
     * @return CommonGroupCommodityVO
     * @exception EventException
     */
    public CommonGroupCommodityVO searchSurchargeGroupCommodityList(PriScgGrpCmdtVO priScgGrpCmdtVO) throws EventException {
        try {
            //컨테이너 vo
            CommonGroupCommodityVO commonGroupCommodityVO = new CommonGroupCommodityVO();
            //Group Location, detail
            List<PriScgGrpCmdtVO> priComGrpCmdtVOList                   = new ArrayList<PriScgGrpCmdtVO>();
            
            int maxSeq = 0;

            // 리스트를 받아서 컨테이너 vo에 담는다
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
     * 조회 이벤트 처리<br>
     * GRI Commodity 화면에 대한 Detail 조회 이벤트 처리<br>
     * 
     * @param PriScgGrpCmdtVO priScgGrpCmdtVO
	 * @param SignOnUserAccount account
     * @return List<RsltPriScgGrpCmdtDtlVO>
     * @exception EventException
     */
    public List<RsltPriScgGrpCmdtDtlVO> searchSurchargeGroupCommodityDetailList(PriScgGrpCmdtVO priScgGrpCmdtVO, SignOnUserAccount account) throws EventException {
        try {
            return dbDao.searchSurchargeGroupCommodityDetailList(priScgGrpCmdtVO, account);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
    }
    
    
    /**
     * 조회 이벤트 처리<br>
     * GRI Commodity 화면에 대한 Excel 조회 이벤트 처리<br>
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
	 * 멀티 이벤트 처리<br>
	 * GRI Commodity 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param CommonGroupCommodityVO commonGroupCommodityVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageSurchargeGroupCommodity(CommonGroupCommodityVO commonGroupCommodityVO, SignOnUserAccount account) throws EventException{
		try {
		
			//컨테이너 vo에서 commodity, detail을 뺀다
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

			
			
			////////////////////////////commodity / detail 저장/////////////////////////////////////	
			
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
					//본문별 디테일 삭제
					dbDao.removeGRICommodityDetail(priComGrpCmdtVOs[i]);
					//디테일을 이미 삭제 했으므로 널로 세팅
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