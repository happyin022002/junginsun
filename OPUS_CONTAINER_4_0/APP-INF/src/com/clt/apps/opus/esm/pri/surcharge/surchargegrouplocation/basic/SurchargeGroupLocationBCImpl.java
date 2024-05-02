/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurchargeGroupLocationBCImpl.java
*@FileTitle : Surcharge Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.integration.SurchargeGroupLocationDBDAO;
import com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.vo.RsltPriScgGrpLocDtlVO;
import com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.vo.RsltPriScgGrpLocVO;
import com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.vo.SurchargeGroupLocationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriScgGrpLocDtlVO;
import com.clt.syscommon.common.table.PriScgGrpLocVO;

/**
 * Surcharge Business Logic Basic Command implementation<br>
 * - Handling a biz logic about Surcharge<br>
 *
 * @author Seung Jun Lee
 * @see ESM_PRI_4004EventResponse,SurchargeGroupLocationBC -refer to each DAO class
 * @since J2EE 1.4
 */

public class SurchargeGroupLocationBCImpl extends BasicCommandSupport implements SurchargeGroupLocationBC {

	// Database Access Object
	private transient SurchargeGroupLocationDBDAO dbDao = null;

	/**
	 * Creating SurchargeGroupLocationBCImpl object<br>
	 */
	public SurchargeGroupLocationBCImpl() {
		dbDao = new SurchargeGroupLocationDBDAO();
	}
	
	
	/**
	 *  Handling retrieving event for SurchargeGroupLocation screen<br>
	 * 
	 * @param SurchargeGroupLocationVO surchargeGroupLocation
	 * @return SurchargeGroupLocationVO
	 * @exception EventException
	 */
	public SurchargeGroupLocationVO searchGroupLocationList(SurchargeGroupLocationVO surchargeGroupLocation) throws EventException {
		try {
			SurchargeGroupLocationVO surchargeGroupLocationVO = new SurchargeGroupLocationVO();
			//Group Location, detail
			List<RsltPriScgGrpLocVO> rsltPriScgGrpLocVOList 		= new ArrayList<RsltPriScgGrpLocVO>();
			List<RsltPriScgGrpLocDtlVO> rsltPriScgGrpLocDtlVOList 	= new ArrayList<RsltPriScgGrpLocDtlVO>();
			
			int maxSeq = 0;
			String searchGubun = "";
			PriScgGrpLocVO priScgGrpLocVO 		= new PriScgGrpLocVO();
			PriScgGrpLocDtlVO priScgGrpLocDtlVO = new PriScgGrpLocDtlVO();
			
			searchGubun = surchargeGroupLocation.getSearchGubun();
			priScgGrpLocVO = surchargeGroupLocation.getPriScgGrpLocVO();
			priScgGrpLocDtlVO = surchargeGroupLocation.getPriScgGrpLocDtlVO();
			
			if("1".equals(searchGubun)) {
				rsltPriScgGrpLocVOList 	= dbDao.searchGroupLocationList(priScgGrpLocVO);
				surchargeGroupLocationVO.setRsltPriScgGrpLocVOList(rsltPriScgGrpLocVOList);
				
				//Getting max sequence
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
	 * Handling multi-event for SurchargeGroupLocation screen<br>
	 * 
	 * @param SurchargeGroupLocationVO surchargeGroupLocation
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupLocation(SurchargeGroupLocationVO surchargeGroupLocation, SignOnUserAccount account) throws EventException{
		try {
		
			//Getting Group location,detail from container vo
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
			
			////////////////////////////Group Location / detail saving/////////////////////////////////////	
			
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
					//deleting detail by body
					dbDao.removeGroupLocationDetail(priScgGrpLocVOs[i]);

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