/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RuLabelManagementBCImpl.java
*@FileTitle : RuLabelManagement
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.basic;

import java.util.ArrayList;
import java.util.List;


import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration.RuLabelManagementDBDAO;

import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.vo.RuLabelListVO;
import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.vo.RuLabelInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * RuLabelManagement Business Logic Basic Command implementation<br>
 * handling business logic about EquipmentManagement<br>
 *
 * @author 
 * @see EES_MST_0050EventResponse,ContainerOnOffhireBC,ContainerOnOffhireDBDAO
 * @since J2EE 1.6
 */
public class RuLabelManagementBCImpl extends BasicCommandSupport implements RuLabelManagementBC 
{

	// Database Access Object
	private transient RuLabelManagementDBDAO dbDao = null;
	
	/**
	 * creating ContainerOnOffhireDBDAO<br>
	 */
	public RuLabelManagementBCImpl() 
	{
		dbDao  = new RuLabelManagementDBDAO();
	}

    
    /**
	  * EES_MST_0050 : retrieve <br>
	 * retrieving for RU Label Maintenace
	 * @category EES_MST_0050
	 * @category searchRuLabelListBasic 
	 * @param ruLabelInfoVO RuLabelInfoVO
	 * @return List<RuLabelListVO> 
	 * @exception EventException
	 */	
	public List<RuLabelListVO> searchRuLabelListBasic(RuLabelInfoVO ruLabelInfoVO) throws EventException {
		try {
			
			if("ALL".equals(ruLabelInfoVO.getRuLabelType())) {
				ruLabelInfoVO.setRuLabelType("");
			}
			return dbDao.searchRuLabelListData(ruLabelInfoVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"RU Label Maintenace"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"RU Label Maintenace"}).getMessage(),ex);
		}		
	}
	
	
	
	/**
	  * EES_MST_0050 : RU Label 중복체크 <br>
	 * retrieving for RU Label Maintenace
	 * @category EES_MST_0050
	 * @category searchRuLabelListBasic 
	 * @param ruLabelListVO RuLabelListVO
	 * @return List<RuLabelListVO> 
	 * @exception EventException
	 */	
	public String searchRuLabelDeleteCntBasic(RuLabelListVO ruLabelListVO) throws EventException {
		String strRuLabelType = "";
		try {
			
			strRuLabelType = dbDao.searchRuLabelDeleteCntData(ruLabelListVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"RU Label Maintenace"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"RU Label Maintenace"}).getMessage(),ex);
		}		
		
		return strRuLabelType;
	}
	
	
	/**
	 * EES_MST_0050 : save <br>
	 * saving RU Label Maintenace
	 * @author Park Young Jin
	 * @category EES_MST_0050
	 * @category actionRuLabelListBasic 
	 * @param RuLabelListVO[] ruLabelListVOs
	 * @exception EventException
	 */		
	@Override
	public void actionRuLabelListBasic(RuLabelListVO[] ruLabelListVOs) throws EventException {
		try {
			List<RuLabelListVO> insertVoList = new ArrayList<RuLabelListVO>();
			List<RuLabelListVO> updateVoList = new ArrayList<RuLabelListVO>();
			List<RuLabelListVO> deleteVoList = new ArrayList<RuLabelListVO>();
			
			for (int i = 0; i < ruLabelListVOs.length; i++) {
				if (ruLabelListVOs[i].getIbflag().equals("I")) {
					
					String ruTpCd = ruLabelListVOs[i].getRstrUsgTpCd();
					String ruLblNm = ruLabelListVOs[i].getRstrUsgLblNm();
					
					String rstrUsgCdFlg = dbDao.checkRulabelDuplication(ruTpCd, ruLblNm);
					if(rstrUsgCdFlg.equals("Y")){
						throw new EventException(new ErrorHandler("MST02021").getMessage());
					} else {
						insertVoList.add(ruLabelListVOs[i]);
					}
				} else if (ruLabelListVOs[i].getIbflag().equals("U")) {
					updateVoList.add(ruLabelListVOs[i]);
				} else if (ruLabelListVOs[i].getIbflag().equals("D")) {
					if(ruLabelListVOs[i].getRuLabelType().equals("FLOW")) ruLabelListVOs[i].setRstrUsgTpLblNm1("");
					if(ruLabelListVOs[i].getRuLabelType().equals("OWFU")) ruLabelListVOs[i].setRstrUsgTpLblNm2("");
					if(ruLabelListVOs[i].getRuLabelType().equals("OFHR")) ruLabelListVOs[i].setRstrUsgTpLblNm3("");
					if(ruLabelListVOs[i].getRuLabelType().equals("DOME")) ruLabelListVOs[i].setRstrUsgTpLblNm4("");
					if(ruLabelListVOs[i].getRuLabelType().equals("SALE")) ruLabelListVOs[i].setRstrUsgTpLblNm5("");
					if(ruLabelListVOs[i].getRuLabelType().equals("GOHH")) ruLabelListVOs[i].setRstrUsgTpLblNm6("");
					if(ruLabelListVOs[i].getRuLabelType().equals("REFR")) ruLabelListVOs[i].setRstrUsgTpLblNm7("");
					if(ruLabelListVOs[i].getRuLabelType().equals("ASST")) ruLabelListVOs[i].setRstrUsgTpLblNm8("");
					if(ruLabelListVOs[i].getRuLabelType().equals("OTR1")) ruLabelListVOs[i].setRstrUsgTpLblNm9("");
					if(ruLabelListVOs[i].getRuLabelType().equals("OTR2")) ruLabelListVOs[i].setRstrUsgTpLblNm10("");
					if(ruLabelListVOs[i].getRuLabelType().equals("ORT3")) ruLabelListVOs[i].setRstrUsgTpLblNm11("");
					
					deleteVoList.add(ruLabelListVOs[i]);			
				}
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addRuLabelData(insertVoList);
			}
			
			if (updateVoList.size() > 0) {
				dbDao.modifyRuLabelData(updateVoList);
			}
			
			if (deleteVoList.size() > 0) {
				dbDao.removeRuLabelData(deleteVoList); //MST_RSTR_USG_CD UPDATE
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MST00013").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MST00013").getMessage(), ex);
		}
	}	
	
	
	
	
	
	/**
	  * EES_MST_0051 : retrieve <br>
	 * retrieving for RU Label Attachment / Detachment
	 * @category EES_MST_0051
	 * @category searchRuLabelAttachListBasic 
	 * @param ruLabelListVO RuLabelListVO
	 * @return List<RuLabelListVO> 
	 * @exception EventException
	 */	
	public List<RuLabelListVO> searchRuLabelAttachListBasic(RuLabelListVO ruLabelListVO) throws EventException {
		try {
			return dbDao.searchRuLabelAttachListData(ruLabelListVO); 
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"RU Label Attachment / Detachment"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"RU Label Attachment / Detachment"}).getMessage(),ex);
		}		
	}
	
	
	
	/**
	  * EES_MST_0051 : retrieve <br>
	 * retrieving for RU Label Attachment / Detachment
	 * @category EES_MST_0051
	 * @category searchRuLabelAttachExcelListBasic 
	 * @param ruLabelListVO RuLabelListVO
	 * @return List<RuLabelListVO> 
	 * @exception EventException
	 */	
	public List<RuLabelListVO> searchRuLabelAttachExcelListBasic(RuLabelListVO ruLabelListVO) throws EventException {
		try {
			
			return dbDao.searchRuLabelAttachExcelListData(ruLabelListVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"RU Label Attachment / Detachment"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"RU Label Attachment / Detachment"}).getMessage(),ex);
		}		
	}
	
	
	/**
	  * EES_MST_0051 : retrieve <br>
	 * retrieving for RU Label Attachment / Detachment
	 * @category EES_MST_0051
	 * @category searchCntrTotalRuLabelAttachListBasic 
	 * @param ruLabelListVO RuLabelListVO
	 * @return int 
	 * @exception EventException
	 */	
	public int searchCntrTotalRuLabelAttachListBasic(RuLabelListVO ruLabelListVO) throws EventException {
		int totalCnt = 0; 
		try {
			totalCnt = dbDao.searchCntrTotalRuLabelAttachListData(ruLabelListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"RU Label Attachment / Detachment"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"RU Label Attachment / Detachment"}).getMessage(),ex);
		}		
		
		return totalCnt;
	}
	
	
	
	/**
	 *  retrieving for RU Label Attachment / Detachment
	 * 
     * @category EES_MST_0051
     * @category searchRuLabelAttachCntrListBasic
	 * @param RuLabelListVO ruLabelListVO
	 * @return selectVoList
	 * @exception EventException
	 */	
	public List<RuLabelListVO> searchRuLabelAttachCntrListBasic(RuLabelListVO ruLabelListVO) throws EventException {
		List<RuLabelListVO> selectVoList = new ArrayList<RuLabelListVO>();		
		try {
				selectVoList = dbDao.searchRuLabelAttachCntrListData(ruLabelListVO);	 
				
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"RU Label Attachment / Detachment"}).getMessage(),ex);			
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"RU Label Attachment / Detachment"}).getMessage(),de);
		}
		return selectVoList;
	}
	
	
	/**
	  * EES_MST_0051 : retrieve <br>
	 * retrieving for RU Label Value
	 * @category EES_MST_0051
	 * @category searchRuLabelValueListBasic 
	 * @param ruLabelListVO RuLabelListVO
	 * @return List<RuLabelListVO> 
	 * @exception EventException
	 */	
	public List<RuLabelListVO> searchRuLabelValueListBasic(RuLabelListVO ruLabelListVO) throws EventException {
		try {
			return dbDao.searchRuLabelValueListData(ruLabelListVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"RU Label Attachment / Detachment"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"RU Label Attachment / Detachment"}).getMessage(),ex);
		}		
	}
	
	
	/**
	 * EES_MST_0051 : save <br>
	 * saving RU Label Attachment / Detachment
	 * @author Park Young Jin
	 * @category EES_MST_0051
	 * @category actionRuLabelAttachListBasic 
	 * @param RuLabelListVO[] ruLabelListVOs
	 * @exception EventException
	 */		
	@Override
	public void actionRuLabelAttachListBasic(RuLabelListVO[] ruLabelListVOs) throws EventException {
		try {
			List<RuLabelListVO> insertVoList = new ArrayList<RuLabelListVO>();
			List<RuLabelListVO> updateVoList = new ArrayList<RuLabelListVO>();
			List<RuLabelListVO> deleteVoList = new ArrayList<RuLabelListVO>();
			
			for (int i = 0; i < ruLabelListVOs.length; i++) {
				ruLabelListVOs[i].setRstrUsgTpLblNm1("");	
				ruLabelListVOs[i].setRstrUsgTpLblNm2("");
				ruLabelListVOs[i].setRstrUsgTpLblNm3("");
				ruLabelListVOs[i].setRstrUsgTpLblNm4("");
				ruLabelListVOs[i].setRstrUsgTpLblNm5("");
				ruLabelListVOs[i].setRstrUsgTpLblNm6("");
				ruLabelListVOs[i].setRstrUsgTpLblNm7("");
				ruLabelListVOs[i].setRstrUsgTpLblNm8("");
				ruLabelListVOs[i].setRstrUsgTpLblNm9("");
				ruLabelListVOs[i].setRstrUsgTpLblNm10("");
				ruLabelListVOs[i].setRstrUsgTpLblNm11("");
				
				if(ruLabelListVOs[i].getRuLabelType().equals("FLOW")) ruLabelListVOs[i].setRstrUsgTpLblNm1(ruLabelListVOs[i].getRuLabelValue());
				if(ruLabelListVOs[i].getRuLabelType().equals("OWFU")) ruLabelListVOs[i].setRstrUsgTpLblNm2(ruLabelListVOs[i].getRuLabelValue());
				if(ruLabelListVOs[i].getRuLabelType().equals("OFHR")) ruLabelListVOs[i].setRstrUsgTpLblNm3(ruLabelListVOs[i].getRuLabelValue());
				if(ruLabelListVOs[i].getRuLabelType().equals("DOME")) ruLabelListVOs[i].setRstrUsgTpLblNm4(ruLabelListVOs[i].getRuLabelValue());
				if(ruLabelListVOs[i].getRuLabelType().equals("SALE")) ruLabelListVOs[i].setRstrUsgTpLblNm5(ruLabelListVOs[i].getRuLabelValue());
				if(ruLabelListVOs[i].getRuLabelType().equals("GOHH")) ruLabelListVOs[i].setRstrUsgTpLblNm6(ruLabelListVOs[i].getRuLabelValue());
				if(ruLabelListVOs[i].getRuLabelType().equals("REFR")) ruLabelListVOs[i].setRstrUsgTpLblNm7(ruLabelListVOs[i].getRuLabelValue());
				if(ruLabelListVOs[i].getRuLabelType().equals("ASST")) ruLabelListVOs[i].setRstrUsgTpLblNm8(ruLabelListVOs[i].getRuLabelValue());
				if(ruLabelListVOs[i].getRuLabelType().equals("OTR1")) ruLabelListVOs[i].setRstrUsgTpLblNm9(ruLabelListVOs[i].getRuLabelValue());
				if(ruLabelListVOs[i].getRuLabelType().equals("OTR2")) ruLabelListVOs[i].setRstrUsgTpLblNm10(ruLabelListVOs[i].getRuLabelValue());
				if(ruLabelListVOs[i].getRuLabelType().equals("ORT3")) ruLabelListVOs[i].setRstrUsgTpLblNm11(ruLabelListVOs[i].getRuLabelValue());
				
				if(ruLabelListVOs[i].getRuLabelValue() == null || "".equals(ruLabelListVOs[i].getRuLabelValue())) {
					ruLabelListVOs[i].setRuLabelValue(ruLabelListVOs[i].getHisRuLabelValue());
				}
				
				if (ruLabelListVOs[i].getIbflag().equals("I")) {
					ruLabelListVOs[i].setRstrUsgUpdTpCd("C");
					insertVoList.add(ruLabelListVOs[i]);
				} else if (ruLabelListVOs[i].getIbflag().equals("U")) {
					if("".equals(ruLabelListVOs[i].getHisRuLabelValue())) {
						ruLabelListVOs[i].setRstrUsgUpdTpCd("C");
					}else{
						ruLabelListVOs[i].setRstrUsgUpdTpCd("U");
					}
					updateVoList.add(ruLabelListVOs[i]);
				} else if (ruLabelListVOs[i].getIbflag().equals("D")) {
					ruLabelListVOs[i].setRstrUsgUpdTpCd("D");
					if(ruLabelListVOs[i].getRuLabelType().equals("FLOW")) ruLabelListVOs[i].setRstrUsgTpLblNm1("");
					if(ruLabelListVOs[i].getRuLabelType().equals("OWFU")) ruLabelListVOs[i].setRstrUsgTpLblNm2("");
					if(ruLabelListVOs[i].getRuLabelType().equals("OFHR")) ruLabelListVOs[i].setRstrUsgTpLblNm3("");
					if(ruLabelListVOs[i].getRuLabelType().equals("DOME")) ruLabelListVOs[i].setRstrUsgTpLblNm4("");
					if(ruLabelListVOs[i].getRuLabelType().equals("SALE")) ruLabelListVOs[i].setRstrUsgTpLblNm5("");
					if(ruLabelListVOs[i].getRuLabelType().equals("GOHH")) ruLabelListVOs[i].setRstrUsgTpLblNm6("");
					if(ruLabelListVOs[i].getRuLabelType().equals("REFR")) ruLabelListVOs[i].setRstrUsgTpLblNm7("");
					if(ruLabelListVOs[i].getRuLabelType().equals("ASST")) ruLabelListVOs[i].setRstrUsgTpLblNm8("");
					if(ruLabelListVOs[i].getRuLabelType().equals("OTR1")) ruLabelListVOs[i].setRstrUsgTpLblNm9("");
					if(ruLabelListVOs[i].getRuLabelType().equals("OTR2")) ruLabelListVOs[i].setRstrUsgTpLblNm10("");
					if(ruLabelListVOs[i].getRuLabelType().equals("ORT3")) ruLabelListVOs[i].setRstrUsgTpLblNm11("");
					
					deleteVoList.add(ruLabelListVOs[i]);
				}
				
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addRuLabelAttachData(insertVoList);
				dbDao.addRuLabelHistoryData(insertVoList);
			}
			
			if (updateVoList.size() > 0) {
				dbDao.addRuLabelAttachData(updateVoList);
				dbDao.addRuLabelHistoryData(updateVoList);
			}
			
			if (deleteVoList.size() > 0) {
				dbDao.addRuLabelAttachData(deleteVoList);
				dbDao.addRuLabelHistoryData(deleteVoList);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MST00013").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MST00013").getMessage(), ex);
		}
	}	
	
	
	

	/**
	  * EES_MST_0052 : retrieve <br>
	 * retrieving for RU Label History
	 * @category EES_MST_0052
	 * @category searchRuLabelHistoryListBasic 
	 * @param RuLabelListVO ruLabelListVO
	 * @return List<RuLabelListVO> 
	 * @exception EventException
	 */	
	public List<RuLabelListVO> searchRuLabelHistoryListBasic(RuLabelListVO ruLabelListVO) throws EventException {
		try {
			if("ALL".equals(ruLabelListVO.getSRuLabelType())) {
				ruLabelListVO.setSRuLabelType("");
			}
			return dbDao.searchRuLabelHistoryListData(ruLabelListVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"RU Label History"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"RU Label History"}).getMessage(),ex);
		}		
	}
	
	
	/**
	 * EES_MST_0051 : retrieve <br>
	 * checking for RU Label
	 * @category EES_MST_0051
	 * @category checkRuLabel 
	 * @param cntrNo String 
	 * @param ruLabelType String  
	 * @return String 
	 * @exception EventException
	 */	
	public String checkRuLabel(String cntrNo, String ruLabelType) throws EventException {
		try {
			return dbDao.checkRuLabel(cntrNo, ruLabelType);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MST00013", new String[]{"RU Label History"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MST00013", new String[]{"RU Label History"}).getMessage(),ex);
		}
	}
	
	/**
	  * EES_MST_0053 : retrieve <br>
	 * retrieving for RU Label Info
	 * @category EES_MST_0053
	 * @category searchRuLabelInfoService 
	 * @param ruLabelListVO RuLabelListVO
	 * @return List<RuLabelListVO> 
	 * @exception EventException
	 */	
	public List<RuLabelListVO> searchRuLabelInfoService(RuLabelListVO ruLabelListVO) throws EventException {
		try {
			return dbDao.searchRuLabelInfoService(ruLabelListVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{""}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{""}).getMessage(),ex);
		}		
	}
	
	/**
	  * EES_MST_0054 : retrieve <br>
	 * retrieving for RU Label - Search Condition
	 * @category EES_MST_0054
	 * @category searchRuLabelConditionService 
	 * @param ruLabelListVO RuLabelListVO
	 * @return List<RuLabelListVO> 
	 * @exception EventException
	 */	
	public List<RuLabelListVO> searchRuLabelConditionService(RuLabelListVO ruLabelListVO) throws EventException {
		try {
			return dbDao.searchRuLabelConditionService(ruLabelListVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{""}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{""}).getMessage(),ex);
		}		
	}
	
	/**
	 * [EES_MST_0051]Excel Load. <br>
	 *
	 * @param RuLabelListVO[] ruLabelListVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */ 
	public String createMstTempBasic(RuLabelListVO[] ruLabelListVOs,SignOnUserAccount account) throws EventException {
		String seqValue  = "";
		try {  
			List<RuLabelListVO> insertVoList = new ArrayList<RuLabelListVO>();
			           
			seqValue = dbDao.addMnrTempSequenceData();
			for(int i=0;i<ruLabelListVOs.length;i++) {
				ruLabelListVOs[i].setTmpSeq(seqValue); 
				ruLabelListVOs[i].setCreUsrId(account.getUsr_id());
				ruLabelListVOs[i].setUpdUsrId(account.getUsr_id());
				ruLabelListVOs[i].setTmpDtlSeq((i + 1) + "");
				insertVoList.add(ruLabelListVOs[i]);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addMnrTempData(insertVoList);   
			} 
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Sold Creation File Import_Pop Up ] createMnrTempBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Sold Creation File Import_Pop Up ] createMnrTempBasic"}).getMessage(),de);
		} 
		return seqValue;
	}
	
	
	/**
	 *  retrieving for RU Label Attachment / Detachment
	 * 
     * @category EES_MST_0051
     * @category searchRuLabelAttachCntrExcelListBasic
	 * @param RuLabelListVO ruLabelListVO
	 * @param seqValue String
	 * @return List<RuLabelListVO>
	 * @exception EventException
	 */	
	public List<RuLabelListVO> searchRuLabelAttachCntrExcelListBasic(RuLabelListVO ruLabelListVO, String seqValue) throws EventException {
		List<RuLabelListVO> selectVoList = new ArrayList<RuLabelListVO>();		
		try {
				selectVoList = dbDao.searchRuLabelAttachCntrExcelListData(ruLabelListVO, seqValue);	 
				
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"RU Label Attachment / Detachment"}).getMessage(),ex);			
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"RU Label Attachment / Detachment"}).getMessage(),de);
		}
		return selectVoList;
	}
}