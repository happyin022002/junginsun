/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PortLimitManagementBC.java
*@FileTitle : PortLimitManagement
*Open Issues :
*Change history : 2014.11.21
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.basic;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;

import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.integration.PortLimitManagmentDBDAO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsBkgVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsDataVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsDgTotalWeightVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsUnNoVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLmtSubsRskVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-portlimitmanagement Business Logic Basic Command implementation<br>
 * - Handling business transactions of OPUS-portlimitmanagement<br>
 *
 * @author
 * @see VOP_SCG-5021EventResponse,PortLimitManagementBC
 * @since J2EE 1.4
 */

public class PortLimitManagementBCImpl extends BasicCommandSupport implements PortLimitManagementBC {

	// Database Access Object
	private transient PortLimitManagmentDBDAO dbDao = null;

	/**
	 * PortLimitManagementBCImpl object creation<br>
	 * PortLimitManagmentDBDAO creation<br>
	 */
	public PortLimitManagementBCImpl() {
		dbDao = new PortLimitManagmentDBDAO();
	}
	
	/**
	 * VOP_SCG_5021 : Retrieve <br>
	 * Retrieve Port Limit Info
	 * @category VOP_SCG_5021
	 * @category PortLimitManagementBC 
	 * @param PortLimitsDataVO portLimitsDataVO
	 * @return List<PortLimitsDataVO> 
	 * @exception EventException
	 */
	public List<PortLimitsDataVO> searchPortLimitsData(PortLimitsDataVO portLimitsDataVO) throws EventException {
		try {
			
			return dbDao.searchPortLimitsData(portLimitsDataVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("", new String[]{""}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("", new String[]{""}).getMessage(),ex);
		}		
	}
	
	/**
	 * VOP_SCG_5023 : Retrieve <br>
	 * Retrieve Port Limit Class Info
	 * @category VOP_SCG_5023
	 * @category PortLimitManagementBC 
	 * @param PortLimitsDataVO portLimitsDataVO
	 * @return List<PortLimitsDataVO> 
	 * @exception EventException
	 */
	public List<PortLimitsDataVO> searchPortLimitsClass(PortLimitsDataVO portLimitsDataVO) throws EventException {
		try {
			
			return dbDao.searchPortLimitsClass(portLimitsDataVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("", new String[]{""}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("", new String[]{""}).getMessage(),ex);
		}		
	}
	
	/**
	 * VOP_SCG_5024 : Retrieve <br>
	 * Retrieve Port Limit Bkg Info
	 * @category VOP_SCG_5024
	 * @category PortLimitManagementBC 
	 * @param PortLimitsBkgVO portLimitsBkgVO
	 * @return List<PortLimitsDataVO> 
	 * @exception EventException
	 */
	public List<PortLimitsBkgVO> searchPortLimitsBkg(PortLimitsBkgVO portLimitsBkgVO) throws EventException {
		try {
			
			return dbDao.searchPortLimitsBkg(portLimitsBkgVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("", new String[]{""}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("", new String[]{""}).getMessage(),ex);
		}		
	}
	
	/**
	 * VOP_SCG_5922 : Retrieve <br>
	 * Retrieve Port Limit Un No Info
	 * @category VOP_SCG_5922
	 * @category PortLimitManagementBC 
	 * @param PortLimitsDataVO portLimitsDataVO
	 * @return List<PortLimitsDataVO> 
	 * @exception EventException
	 */
	public List<PortLimitsDataVO> searchPortLimitsUnNo(PortLimitsDataVO portLimitsDataVO) throws EventException {
		try {
			
			return dbDao.searchPortLimitsUnNo(portLimitsDataVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("", new String[]{""}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("", new String[]{""}).getMessage(),ex);
		}
	}
	
	/**
	 * VOP_SCG_5923 : Retrieve <br>
	 * Retrieve Port Limit SubRsk Info
	 * @category VOP_SCG_5923
	 * @category PortLimitManagementBC 
	 * @param PortLmtSubsRskVO portLmtSubsRskVO
	 * @return List<PortLmtSubsRskVO> 
	 * @exception EventException
	 */
	public List<PortLmtSubsRskVO> searchPortLimitsSubRsk(PortLmtSubsRskVO portLmtSubsRskVO) throws EventException{
		try {
			
			return dbDao.searchPortLimitsSubRsk(portLmtSubsRskVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("", new String[]{""}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("", new String[]{""}).getMessage(),ex);
		}
	}
	
	/**
	 * VOP_SCG_5021 : Manage <br>
	 * Manage Port Limit Info
	 * @category VOP_SCG_5021
	 * @category PortLimitManagementBC 
	 * @param PortLimitsDataVO[] portLimitsDataVOs
	 * @param String gubun
	 * @exception EventException
	 */
	@Override
	public void managePortLimitsData(PortLimitsDataVO[] portLimitsDataVOs, String gubun) throws EventException {
		try {
			List<PortLimitsDataVO> insertVoList = new ArrayList<PortLimitsDataVO>();
			List<PortLimitsDataVO> updateVoList = new ArrayList<PortLimitsDataVO>();
			List<PortLimitsDataVO> deleteVoList = new ArrayList<PortLimitsDataVO>();
			List<PortLmtSubsRskVO> deleteVoList2 = new ArrayList<PortLmtSubsRskVO>();
			
			for (int i = 0; i < portLimitsDataVOs.length; i++) {
				if (portLimitsDataVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(portLimitsDataVOs[i]);
					
					PortLmtSubsRskVO portLmtSubsRskVO= new PortLmtSubsRskVO();
					
					portLmtSubsRskVO.setPortCd(portLimitsDataVOs[i].getPortCd());
					portLmtSubsRskVO.setPortLmtSeq(portLimitsDataVOs[i].getPortLmtSeq());
					deleteVoList2.add(portLmtSubsRskVO);
					
				} else if (portLimitsDataVOs[i].getIbflag().equals("U")) {
					updateVoList.add(portLimitsDataVOs[i]);
				} else if (portLimitsDataVOs[i].getIbflag().equals("I")) {
					insertVoList.add(portLimitsDataVOs[i]);
				}
			}
			
			if (deleteVoList.size() > 0) {
				dbDao.removePortLimitsComp(deleteVoList);
				dbDao.removePortLimitsClass(deleteVoList);
				
//				PortLimitsUnNoVO unvo = new PortLimitsUnNoVO();
//				unvo.setPortCd(deleteVoList.get(0).getPortCd());
//				unvo.setLmtWgtTpCd(deleteVoList.get(0).getLmtWgtTpCd());
//				unvo.setPortLmtSeq(deleteVoList.get(0).getPortLmtSeq());
//				deleteVoList2.add(unvo);
				dbDao.removePortLimitsUnNo(deleteVoList);
				
				dbDao.removePortLimitsSubRsk(deleteVoList2);
				
				dbDao.removePortLimitsData(deleteVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyPortLimitsData(updateVoList);
			}
			
			if (insertVoList.size() > 0) {
				if("pop".equals(gubun)){
					dbDao.addPortLimitsDataPop(insertVoList);					
				}else{
					dbDao.addPortLimitsData(insertVoList);
				}
			}
			
			/*dbDao.removePortLimitsDataForSeq(PortCd); // Remove Port Limits Data For renumbering "port_lmt_seq"
			
			for (int i = 0; i < portLimitsDataVOs.length; i++) {
				if (!portLimitsDataVOs[i].getIbflag().equals("D")) {
					String Seq = Integer.toString(i);
					portLimitsDataVOs[i].setPortLmtSeq(Seq);
					insertVoList.add(portLimitsDataVOs[i]);
				}
			}
			
			dbDao.addPortLimitsData(insertVoList);*/

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("").getMessage(), ex);
		}
	}
	
	/**
	 * 중복제거로직
	 * @param portLimitsDataVOs
	 * @return
	 */
	public PortLimitsDataVO[] getUniqueAry(PortLimitsDataVO[] portLimitsDataVOs){
		TreeSet<String> ts = new TreeSet<String>();
		Hashtable<String, String> ht = null;
		int aryTotLen = portLimitsDataVOs.length;
		int aryLen = 0;
		
		for (int i = 0; i < portLimitsDataVOs.length; i++) {
			if (!portLimitsDataVOs[i].getIbflag().equals("D")) {
				aryLen++;
			}
		}
		
		String[] portCdAry 	   = new String[aryLen];
		String[] portLmtSeqAry = new String[aryLen];
		String[] imdgClssCdAry = new String[aryLen];
		String[] creUsrIdAry   = new String[aryLen];
		String[] updUsrIdAry   = new String[aryLen];
		
		Vector<String> portCdVec 	 = new Vector<String>();
		Vector<String> portLmtSeqVec = new Vector<String>();
		Vector<String> imdgClssCdVec = new Vector<String>();
		Vector<String> creUsrIdVec   = new Vector<String>();
		Vector<String> updUsrIdVec   = new Vector<String>();
		
		ht = new Hashtable<String, String>();
		
		int addi = 0;
		for(int i=0; i < aryTotLen; i++){
			PortLimitsDataVO vo  = portLimitsDataVOs[i];
			
			if (!vo.getIbflag().equals("D")) {
				portCdAry[addi]     = vo.getPortCd();
				portLmtSeqAry[addi] = vo.getPortLmtSeq();
				imdgClssCdAry[addi] = vo.getImdgClssCd(); 
				creUsrIdAry[addi]   = vo.getCreUsrId();
				updUsrIdAry[addi]   = vo.getUpdUsrId();
				addi++;
			}
		}
		
		for(int i = 0; i < aryLen; i++) {
			ts.add(imdgClssCdAry[i]);
			ht.put(imdgClssCdAry[i], portCdAry[i] + "," +
									 portLmtSeqAry[i] + "," +
									 creUsrIdAry[i] + "," +
									 updUsrIdAry[i]);
		}
		
		Iterator<String> ir = ts.iterator();

		String tmpStr = "";
		String[] tmpArray = null;

		while(ir.hasNext()) {
		  tmpStr = (String) ir.next();

		  imdgClssCdVec.add(tmpStr);

		  tmpStr = (String)ht.get(tmpStr);
		  tmpArray = tmpStr.split(",");

		  portCdVec.add(tmpArray[0]);
		  portLmtSeqVec.add(tmpArray[1]);
		  creUsrIdVec.add(tmpArray[2]);
		  updUsrIdVec.add(tmpArray[3]);
		}
		
		PortLimitsDataVO[] voGen = new PortLimitsDataVO[imdgClssCdVec.size()];
		
		for(int i=0; i < imdgClssCdVec.size(); i++){
			String portCdStr   = (String)portCdVec.get(i);
			String portLmtSeqStr = (String)portLmtSeqVec.get(i);
			String imdgClssCdStr = (String)imdgClssCdVec.get(i);
			String creUsrIdStr = (String)creUsrIdVec.get(i);
			String updUsrIdStr = (String)updUsrIdVec.get(i);
			
			PortLimitsDataVO zvo  = new PortLimitsDataVO();
			
			voGen[i] = zvo;
			
			voGen[i].setPortCd(portCdStr);
			voGen[i].setPortLmtSeq(portLmtSeqStr);
			voGen[i].setImdgClssCd(imdgClssCdStr); 
			
			voGen[i].setCreUsrId(creUsrIdStr);
			voGen[i].setUpdUsrId(updUsrIdStr);
		}
		
		return voGen;

	}
	
	/**
	 * VOP_SCG_5922 : Manage <br>
	 * Manage Port Limit Info
	 * @category VOP_SCG_5922
	 * @category PortLimitManagementBC 
	 * @param PortLimitsDataVO[] portLimitsDataVOs
	 * @param PortLimitsUnNoVO[] portLimitsUnNoVOs
	 * @exception EventException
	 */
	@Override
	public void managePortLimitsClass(PortLimitsDataVO[] portLimitsDataVOs, PortLimitsUnNoVO[] portLimitsUnNoVOs) throws EventException {
		try {
			if(portLimitsDataVOs != null && portLimitsDataVOs.length > 0){
				List<PortLimitsDataVO> deleteVoList = new ArrayList<PortLimitsDataVO>();
				
				deleteVoList.add(portLimitsDataVOs[0]);
				
				if (deleteVoList.size() > 0) {
					dbDao.removePortLimitsComp(deleteVoList);
					dbDao.removePortLimitsClass(deleteVoList);
				}
				
				boolean brk = true;
				for (int i = 0; i < portLimitsDataVOs.length; i++) {
					if (!portLimitsDataVOs[i].getIbflag().equals("D")) {	//전체삭제후, 삭제가 아닌경우 모두 저장
						
						//IMDG_CLSS_CD 중복제거후 저장
						if(brk){
							PortLimitsDataVO[] clssAry = getUniqueAry(portLimitsDataVOs);
							
							for (int j = 0; j < clssAry.length; j++) {
									dbDao.addPortLimitsClass(clssAry[j]);
							}
							
							brk = false;
						}
						
						if(!"".equals(portLimitsDataVOs[i].getImdgCompGrpCd()) && portLimitsDataVOs[i].getImdgCompGrpCd() != null){
							dbDao.addPortLimitsComp(portLimitsDataVOs[i]);
						}
					}
				}
			}
			
			if(portLimitsUnNoVOs != null && portLimitsUnNoVOs.length > 0){
				List<PortLimitsDataVO> deleteVoList2 = new ArrayList<PortLimitsDataVO>();
				PortLimitsDataVO vo = new PortLimitsDataVO();
				vo.setPortCd(portLimitsUnNoVOs[0].getPortCd());
				//vo.setLmtWgtTpCd(portLimitsUnNoVOs[0].getLmtWgtTpCd());
				vo.setPortLmtSeq(portLimitsUnNoVOs[0].getPortLmtSeq());
				deleteVoList2.add(vo);
				if (deleteVoList2.size() > 0) {
					dbDao.removePortLimitsUnNo(deleteVoList2);
				}
				
				for (int i = 0; i < portLimitsUnNoVOs.length; i++) {
					if (!portLimitsUnNoVOs[i].getIbflag().equals("D")) {	//전체삭제후, 삭제가 아닌경우 모두 저장
						dbDao.addPortLimitsUnNo(portLimitsUnNoVOs[i]);
					}
				}
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("").getMessage(), ex);
		}
	}

	/**
	 * VOP_SCG_5023 : Manage <br>
	 * Manage Port Limit Info
	 * @category VOP_SCG_5023
	 * @category PortLimitManagementBC 
	 * @param PortLmtSubsRskVO[] portLmtSubsRskVOs
	 * @exception EventException
	 */
	@Override
	public void managePortLimitsSubRsk(PortLmtSubsRskVO[] portLmtSubsRskVOs) throws EventException {
		try {
			if(portLmtSubsRskVOs != null && portLmtSubsRskVOs.length > 0){
				List<PortLmtSubsRskVO> deleteVoList2 = new ArrayList<PortLmtSubsRskVO>();
				PortLmtSubsRskVO vo = new PortLmtSubsRskVO();
				vo.setPortCd(portLmtSubsRskVOs[0].getPortCd());
				vo.setPortLmtSeq(portLmtSubsRskVOs[0].getPortLmtSeq());
				deleteVoList2.add(vo);
				if (deleteVoList2.size() > 0) {
					dbDao.removePortLimitsSubRsk(deleteVoList2);
				}
				
				for (int i = 0; i < portLmtSubsRskVOs.length; i++) {
					if (!portLmtSubsRskVOs[i].getIbflag().equals("D")) {	//전체삭제후, 삭제가 아닌경우 모두 저장
						dbDao.addPortLimitsSubRsk(portLmtSubsRskVOs[i]);
					}
				}
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("").getMessage(), ex);
		}
	}
	
	/**
	 * VOP_SCG_5022 : Retrieve <br>
	 * Retrieve Port Limits DG Total Weight
	 * @category VOP_SCG_5022
	 * @category PortLimitManagementBC 
	 * @param PortLimitsDgTotalWeightVO portLimitsDgTotalWeightVO
	 * @return List<PortLimitsDgTotalWeightVO>
	 * @exception EventException
	 */	
	public List<PortLimitsDgTotalWeightVO> searchPortLimitsDgTotalWeightCheck(PortLimitsDgTotalWeightVO portLimitsDgTotalWeightVO) throws EventException {
		
		try {
			//신규View List
//			List<PortLimitsDgTotalWeightVO> voList = null;
			//조회List
			List<PortLimitsDgTotalWeightVO> portLimits = new ArrayList<PortLimitsDgTotalWeightVO>();
			if(portLimitsDgTotalWeightVO.getPlmtPortCd().equals("CNSHA")) {
				portLimits = dbDao.searchPortLimitsDgTotalWeightCheckSha(portLimitsDgTotalWeightVO);
			} else {
				portLimits = dbDao.searchPortLimitsDgTotalWeightCheck	(portLimitsDgTotalWeightVO);
				for(int i=0;i<portLimits.size();i++){
				PortLimitsDgTotalWeightVO vo = (PortLimitsDgTotalWeightVO)portLimits.get(i);
				portLimitsDgTotalWeightVO.setArrivalBkgNo(vo.getArrivalBkgNo());
				portLimitsDgTotalWeightVO.setDischargeBkgNo(vo.getDischargeBkgNo());
				portLimitsDgTotalWeightVO.setLoadBkgNo(vo.getLoadBkgNo());
				portLimitsDgTotalWeightVO.setDepartureBkgNo(vo.getDepartureBkgNo());
				}
				
				
			}
			//
//			for(int i=0; i < portLimits.size(); i++){
//				PortLimitsDgTotalWeightVO vo = new PortLimitsDgTotalWeightVO();
//				
//				vo.setArr
//				
//				voList.add(vo);
//			}

			return portLimits;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("", new String[]{""}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("", new String[]{""}).getMessage(),ex);
		}		
	}
	
	/**
	 * VOP_SCG_5921 : PortLmtSeq Search & Setting
	 * @param portLimitsDataVO
	 * @return String
	 * @throws EventException
	 */
	public String srchPortLmtSeq(PortLimitsDataVO portLimitsDataVO) throws EventException{
		String portLmtSeqStr = "";
		try {
			
		portLmtSeqStr = dbDao.srchPortLmtSeq(portLimitsDataVO);
		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("", new String[]{""}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("", new String[]{""}).getMessage(),ex);
		}
		return portLmtSeqStr;
	}
}