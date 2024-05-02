/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TotalLossMgtBCImpl.java
*@FileTitle : Total Loss No Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration.InterfaceMgtDBDAO;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.integration.TotalLossMgtDBDAO;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo.CustomMnrTtlLssCltVO;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo.CustomMnrTtlLssRqstDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo.CustomMnrTtlLssRqstHdrVO;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo.TotalLossGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo.TotalLossInfoGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo.TotalLossLessorReportINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo.TotalLossLessorReportVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-GeneralManage Business Logic Basic Command implementation<br>
 * - COM-GeneralManage disposing business logic<br>
 *
 * @author
 * @see 	EesMnr0195Event, TotalLossMgtBC, DAO Class
 * @since 	J2EE 1.4
 */
public  class TotalLossMgtBCImpl extends BasicCommandSupport implements TotalLossMgtBC {
	// Database Access Object
	private transient TotalLossMgtDBDAO dbDao = null;
	private transient InterfaceMgtDBDAO dbDao1 = null;
	/**
	 * Constructor
	 */
	public TotalLossMgtBCImpl() {
		dbDao = new TotalLossMgtDBDAO();
		dbDao1 = new InterfaceMgtDBDAO();
	}

	/**
	 * [EES_MNR_0098]Retrieving "Total Loss Collection & Inquiry" data<br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */
	public TotalLossGRPVO searchTotalLossWithCLTBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException {
		try {
			//CLT Search
			List<CustomMnrTtlLssCltVO> customMnrTtlLssCltVOS = dbDao.searchTotalLossCLTData(totalLossGRPVO.getTotalLossINVO());
			totalLossGRPVO.setListCustomMnrTtlLssCltVOS(customMnrTtlLssCltVOS);
			return totalLossGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Collection & Inquiry] searchTotalLossWithCLTBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Collection & Inquiry] searchTotalLossWithCLTBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0098]Deleting "Total Loss Collection & Inquiry" data<br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */
	public TotalLossGRPVO removeTotalLossBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException{
		try {
			CustomMnrTtlLssRqstHdrVO customMnrTtlLssRqstHdrVO = totalLossGRPVO.getCustomMnrTtlLssRqstHdrVO();
			dbDao.removeTotalLossDTLData(customMnrTtlLssRqstHdrVO);
			dbDao.removeTotalLossHDRData(customMnrTtlLssRqstHdrVO);
			return totalLossGRPVO;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Collection & Inquiry] removeTotalLossBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Collection & Inquiry] removeTotalLossBasic"}).getMessage(),de);
		}
	}

	/**
	 * [EES_MNR_0098]Deleting "Total Loss Request" data<br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */
	public TotalLossGRPVO removeTotalLossGRPBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException{
		try {
			CustomMnrTtlLssRqstHdrVO customMnrTtlLssRqstHdrVO = totalLossGRPVO.getCustomMnrTtlLssRqstHdrVO();
			dbDao.removeTotalLossDtlGRPData(customMnrTtlLssRqstHdrVO);
			dbDao.removeTotalLossHdrGRPData(customMnrTtlLssRqstHdrVO);
			return totalLossGRPVO;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] removeTotalLossGRPBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] removeTotalLossGRPBasic"}).getMessage(),de);
		}
	}

	/**
	 * [EES_MNR_0098]Retrieving "Total Loss Request" data<br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */
	public TotalLossGRPVO searchTotalLossListBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException {
		try {
			//Header Search
			List<CustomMnrTtlLssRqstHdrVO> customMnrTtlLssRqstHdrVOS = dbDao.searchTotalLossListData(totalLossGRPVO,account);
			totalLossGRPVO.setListCustomMnrTtlLssRqstHdrVO(customMnrTtlLssRqstHdrVOS);
			return totalLossGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] searchTotalLossListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] searchTotalLossListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0195]Retrieving "Total Loss No Inquiry_Pop Up" data<br>
	 *
	 * @param TotalLossInfoGRPVO totalLossInfoGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossInfoGRPVO
	 * @exception EventException
	 */
	public TotalLossInfoGRPVO searchTotalLossInfoByOFCListBasic(TotalLossInfoGRPVO totalLossInfoGRPVO, SignOnUserAccount account) throws EventException {
		try {
			List<CustomMnrTtlLssRqstHdrVO> listCustomMnrTtlLssRqstHdrVOs = null;

			listCustomMnrTtlLssRqstHdrVOs = dbDao.searchTotalLossInfoByOFCListData(totalLossInfoGRPVO, account);

			totalLossInfoGRPVO.setListCustomMnrTtlLssRqstHdrVOs(listCustomMnrTtlLssRqstHdrVOs);
			return totalLossInfoGRPVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss No Inquiry_Pop Up] searchTotalLossInfoByOFCListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss No Inquiry_Pop Up] searchTotalLossInfoByOFCListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0098]Retrieving "Total Loss Request" data<br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */
	public TotalLossGRPVO searchTotalLossBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException {
		try {
			//Checking Total Loss No
			String searchTtlLssNo = totalLossGRPVO.getTotalLossINVO().getSearchTtlLssNo();
			String rqstOfcCd = totalLossGRPVO.getTotalLossINVO().getRqstOfcCd();

			int ttlLssNoCnt = dbDao.checkTotalLossNoData(searchTtlLssNo, rqstOfcCd);
			if(ttlLssNoCnt < 1) {
				throw new EventException(new ErrorHandler("MNR00287",new String[]{searchTtlLssNo}).getMessage());
			}

            //Header Search
			List<CustomMnrTtlLssRqstHdrVO> customMnrTtlLssRqstHdrVO = dbDao.searchTotalLossData(totalLossGRPVO,account);
			totalLossGRPVO.setListCustomMnrTtlLssRqstHdrVO(customMnrTtlLssRqstHdrVO);

            //Detail Search
			List<List<CustomMnrTtlLssRqstDtlVO>> listCustomMnrTtlLssRqstDtlVOs = new ArrayList<List<CustomMnrTtlLssRqstDtlVO>>();

			totalLossGRPVO.getTotalLossINVO().setMnrInvTpCd("DV");
			List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVO0 = dbDao.searchTotalLossDetailListData(totalLossGRPVO);
			totalLossGRPVO.getTotalLossINVO().setMnrInvTpCd("TP");
			List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVO1 = dbDao.searchTotalLossDetailListData(totalLossGRPVO);
			totalLossGRPVO.getTotalLossINVO().setMnrInvTpCd("DS");
			List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVO2 = dbDao.searchTotalLossDetailListData(totalLossGRPVO);
			totalLossGRPVO.getTotalLossINVO().setMnrInvTpCd("SC");
			List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVO3 = dbDao.searchTotalLossDetailListData(totalLossGRPVO);
			totalLossGRPVO.getTotalLossINVO().setMnrInvTpCd("IR");
			List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVO4 = dbDao.searchTotalLossDetailListData(totalLossGRPVO);

			listCustomMnrTtlLssRqstDtlVOs.add(customMnrTtlLssRqstDtlVO0);
			listCustomMnrTtlLssRqstDtlVOs.add(customMnrTtlLssRqstDtlVO1);
			listCustomMnrTtlLssRqstDtlVOs.add(customMnrTtlLssRqstDtlVO2);
			listCustomMnrTtlLssRqstDtlVOs.add(customMnrTtlLssRqstDtlVO3);
			listCustomMnrTtlLssRqstDtlVOs.add(customMnrTtlLssRqstDtlVO4);

			totalLossGRPVO.setListCustomMnrTtlLssRqstDtlVOs(listCustomMnrTtlLssRqstDtlVOs);

			return totalLossGRPVO;
		} catch (EventException e){
		    log.error("err " + e.toString(), e);
			throw e;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] searchTotalLossBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] searchTotalLossBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0098]Adding, modifying, deleting "Total Loss Request" data<br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */
	public TotalLossGRPVO manageTotalLossBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException{
		try {
			//Setting header
			List<CustomMnrTtlLssRqstHdrVO> insertHdrVo = new ArrayList<CustomMnrTtlLssRqstHdrVO>();

			String paramTtlLssNo	= totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().getTtlLssNo();
			String ttlLssStsCd = totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().getTtlLssStsCd();
			String newTtlLssNo		= "";

			if(paramTtlLssNo.equals("NEW")|| paramTtlLssNo.equals("")) {
				//Retrieving created "Total Loss Number"
				newTtlLssNo = dbDao.searchTotalLossNoData(totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().getRqstOfcCd());
				totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().setTtlLssNo(newTtlLssNo);
			}
			totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().setCreUsrId(account.getUsr_id());
			totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().setUpdUsrId(account.getUsr_id());
			if(!totalLossGRPVO.getTotalLossINVO().getWorkType().equalsIgnoreCase("collection"))
			{
				totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().setTtlLssCfmDt("");
			}
			insertHdrVo.add(totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO());

			//Setting detail
			List<CustomMnrTtlLssRqstDtlVO> insertDtlVoList = new ArrayList<CustomMnrTtlLssRqstDtlVO>();
			List<CustomMnrTtlLssRqstDtlVO> updateDtlVoList = new ArrayList<CustomMnrTtlLssRqstDtlVO>();
			List<CustomMnrTtlLssRqstDtlVO> deleteDtlVoList = new ArrayList<CustomMnrTtlLssRqstDtlVO>();
			int addCnt=0;
			int maxSeq=0;
			
			List<String> eqList = new ArrayList<String>();
			for ( int i=0; i<totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs().length; i++ ) {
				if(totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getMnrInvTpCd().equalsIgnoreCase("DV")&&!ttlLssStsCd.equalsIgnoreCase("HJ")){
					int retVal = dbDao.checkCNTRActualDTData(totalLossGRPVO.getTotalLossINVO().getTtlLssDt().replaceAll("-",""), totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getRqstEqNo());
					if(retVal < 0){
						eqList.add(totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getRqstEqNo());
					}
				}
				
				if(totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getMnrInvTpCd().equalsIgnoreCase("DV")
						&& ttlLssStsCd.equalsIgnoreCase("HR"))
					{
						if("OW".equals(totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getLstmCd())){
							totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setMnrPrnrSeq(null);
							if("R".equals(totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getIbflag())){
								totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setIbflag("U");
							}
						}	
					}
				if ( totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getIbflag().equals("U")){
					totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setEqOwnrFlg("N");
					if(totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getTtlLssCfmFlg().equals("1")){
						totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setTtlLssCfmFlg("Y");
					} else {
						totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setTtlLssCfmFlg("N");
					}
					totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i]);
				}
				else if (totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getIbflag().equals("I")){
					if(totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getTtlLssNo().equals("NEW")){
						totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setTtlLssNo(newTtlLssNo);
					}
					totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setEqOwnrFlg("N");
					if(totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getTtlLssCfmFlg().equals("1")){
						totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setTtlLssCfmFlg("Y");
					} else {
						totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setTtlLssCfmFlg("N");
					}
					totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setTempSeq(String.valueOf(addCnt+1));
					totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setCreUsrId(account.getUsr_id());
					totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setUpdUsrId(account.getUsr_id());
					insertDtlVoList.add(totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i]);
					addCnt++;
				}
				else if ( totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getIbflag().equals("D")){
					deleteDtlVoList.add(totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i]);
				}

				if(!totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getTtlLssDtlSeq().equalsIgnoreCase("") && ttlLssStsCd.equalsIgnoreCase("HA"))
				{
				     int tempMaxSeq=Integer.parseInt(totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getTtlLssDtlSeq());
				     if(tempMaxSeq>maxSeq)
				     {
				    	 maxSeq=tempMaxSeq;
				     }
				}
			}
			
			if(eqList != null && eqList.size() > 0){
				throw new EventException(new ErrorHandler("MNR00326", new String[]{"EQ No: "+ eqList.toString() + " "}).getMessage());
			}
			
			if(ttlLssStsCd.equalsIgnoreCase("HA"))
			{
				for ( int i=0; i<totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs().length; i++ ) {
			    	if (totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getIbflag().equals("I"))
        			{
        			     totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setTtlLssDtlSeq(String.valueOf(++maxSeq));
        			}
				}
			}

			//Header
			if(paramTtlLssNo.equals("NEW")|| paramTtlLssNo.equals("")) {
			    dbDao.addTotalLossHeaderData(insertHdrVo);
			}else{
			    dbDao.modifyTotalLossHeaderData(insertHdrVo);
			}

			//Detail
			if ( insertDtlVoList.size() > 0 ) {
				dbDao.addTotalLossDetailData(insertDtlVoList);
			}
			if ( updateDtlVoList.size() > 0 ) {
				dbDao.modifyTotalLossDetailData(updateDtlVoList);
			}
			if ( deleteDtlVoList.size() > 0 ) {
				dbDao.removeTotalLossDetailData(deleteDtlVoList);
			}

			//Returning Total Loss No after saving
			if(paramTtlLssNo.equals("NEW")) {
				totalLossGRPVO.setTotalLossNo(newTtlLssNo);
			} else {
				totalLossGRPVO.setTotalLossNo(paramTtlLssNo);
			}

			CustomMnrTtlLssCltVO[] arrCustomMnrTtlLssCltVOS = totalLossGRPVO.getArrCustomMnrTtlLssCltVOS();
			CustomMnrTtlLssRqstHdrVO customMnrTtlLssRqstHdrVO = new CustomMnrTtlLssRqstHdrVO();
			customMnrTtlLssRqstHdrVO.setTtlLssNo(totalLossGRPVO.getTotalLossNo());
			dbDao.removeTotalLossCLTData(customMnrTtlLssRqstHdrVO);

			if(arrCustomMnrTtlLssCltVOS != null){
				List<CustomMnrTtlLssCltVO> insertVoList = new ArrayList<CustomMnrTtlLssCltVO>();
				for ( int i = 0; i < arrCustomMnrTtlLssCltVOS.length; i++ ) {
				    	if(arrCustomMnrTtlLssCltVOS[i].getType().equalsIgnoreCase("Manual"))
				    	{
        					arrCustomMnrTtlLssCltVOS[i].setCreUsrId(account.getUsr_id());
        					arrCustomMnrTtlLssCltVOS[i].setUpdUsrId(account.getUsr_id());
        					arrCustomMnrTtlLssCltVOS[i].setTtlLssNo(totalLossGRPVO.getTotalLossNo());
        					arrCustomMnrTtlLssCltVOS[i].setTtlLssCltSeq((i + 1) + "");
        					insertVoList.add(arrCustomMnrTtlLssCltVOS[i]);
				    	}
				}
				if ( insertVoList.size() > 0 ) {
					dbDao.addTotalLossCLTData(insertVoList);
				}
			}
			return totalLossGRPVO;

		} catch (EventException e){
		    log.error("err " + e.toString(), e);
			throw e;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] manageTotalLossBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] manageTotalLossBasic"}).getMessage(),de);
		}
	}

	/**
	 * [EES_MNR_0105]Retrieving "Total Loss Payment to Lessor Report" data<br>
	 *
	 * @param TotalLossLessorReportINVO totalLossLessorReportINVO
	 * @return List<TotalLossLessorReportVO>
	 * @exception EventException
	 */
	public List<TotalLossLessorReportVO> searchTotalLossLessorReportListBasic(TotalLossLessorReportINVO totalLossLessorReportINVO) throws EventException {
		try {
			return dbDao.searchTotalLossLessorReportListData(totalLossLessorReportINVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Payment to Lessor Report] searchTotalLossLessorReportListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Payment to Lessor Report] searchTotalLossLessorReportListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0096]Modifying "Total Loss Management" data<br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */
	public TotalLossGRPVO modifyTotalLossDetailBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException{
		try {

			//Setting detail
			List<CustomMnrTtlLssRqstDtlVO> updateDtlVoList = new ArrayList<CustomMnrTtlLssRqstDtlVO>();
			String ttlLssStsCd = totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().getTtlLssStsCd();
			for ( int i=0; i<totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs().length; i++ ) {

				if(!totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getIbflag().equalsIgnoreCase("D")){
					if(totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getMnrInvTpCd().equalsIgnoreCase("DV")
						&& ttlLssStsCd.equalsIgnoreCase("HR"))
					{
						if("OW".equals(totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getLstmCd())){
							totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setMnrPrnrSeq("6256");
							if("R".equals(totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getIbflag())){
								totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setIbflag("U");
							}
						}
					}
					totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setEqOwnrFlg("N");

					if(totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getTtlLssCfmFlg().equals("1") || totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getTtlLssCfmFlg().equals("Y")){
						totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setTtlLssCfmFlg("Y");
					} else {
						totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setTtlLssCfmFlg("N");
					}
					totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i]);
				}
			}

			if ( updateDtlVoList.size() > 0 ) {
				dbDao.modifyTotalLossDetailData(updateDtlVoList);
			}
			return totalLossGRPVO;

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] manageTotalLossBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] manageTotalLossBasic"}).getMessage(),de);
		}
	}
	
	/**
	 * [EES_MNR_0096]Modifying "Total Loss Management" data<br>
	 *
	 * @param CustomMnrTtlLssRqstDtlVO customMnrTtlLssRqstDtlVO
	 * @param String ttlLssDt
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */
	@Override
	public TotalLossGRPVO modifyTotalLossRevVvdBasic(CustomMnrTtlLssRqstDtlVO customMnrTtlLssRqstDtlVO, String ttlLssDt, SignOnUserAccount account) throws EventException {
		try {
			String bkgNo = dbDao.searchTotalLossBkgNoData(customMnrTtlLssRqstDtlVO.getRqstEqNo(), customMnrTtlLssRqstDtlVO.getEqKndCd(), ttlLssDt);
			if(!"".equals(bkgNo)){
				String revVvdCd = dbDao1.searchRevenueVvdData(bkgNo);
				
				customMnrTtlLssRqstDtlVO.setVslCd(revVvdCd.substring(0, 4));
				customMnrTtlLssRqstDtlVO.setSkdVoyNo(revVvdCd.substring(4, 8));
				customMnrTtlLssRqstDtlVO.setSkdDirCd(revVvdCd.substring(8, 9));
				customMnrTtlLssRqstDtlVO.setRevDirCd(revVvdCd.substring(9, 10));
				customMnrTtlLssRqstDtlVO.setSlanCd(revVvdCd.substring(10));
				customMnrTtlLssRqstDtlVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.manageTotalLossRevVvdData(customMnrTtlLssRqstDtlVO);
			}
			
		}catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Approval] modifyTotalLossRevVvdBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Approval] modifyTotalLossRevVvdBasic"}).getMessage(),de);
		}
		return null;
	}
}