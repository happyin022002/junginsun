/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TotalLossMgtBCImpl.java
*@FileTitle : Total Loss No Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.04
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2009.09.15 김완규
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.03.06 신혜정 [CHM-201216409] 3rd Party 탭 [CHNG INV No] 버튼 클릭시, invoice no 업데이트  
* 2013.01.04 조경완 [CHM-201220942-01] ALPS MNR-Total Loss Module에서 Write Off 처리 건을 위하여 추가 메뉴 개발 요청                       
* 2013.01.04 조경완 [CHM-201220984-01] ALPS MNR-Total Loss-Write Off - Approval
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration.TotalLossMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration.WriteOffMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.CustomMnrTtlLssCltVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.CustomMnrTtlLssRqstDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.CustomMnrTtlLssRqstHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.CustomMnrWrtfRqstHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.TotalLossGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.TotalLossInfoGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.TotalLossLessorReportINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.TotalLossLessorReportVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-GeneralManage Business Logic Basic Command implementation<br>
 * - alps-GeneralManage 에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author WanGyu Kim    
 * @see EesMnr0195Event,TotalLossMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4      
 */
public  class TotalLossMgtBCImpl extends BasicCommandSupport implements TotalLossMgtBC {
	// Database Access Object 
	private transient TotalLossMgtDBDAO dbDao = null;     
	private transient WriteOffMgtDBDAO dbDao1 = null;
	
	/** 	
	 * TotalLossMgtBCImpl 객체 생성<br>
	 * TotalLossMgtDBDAO 생성한다.<br>
	 */    
	public TotalLossMgtBCImpl() {  
		dbDao = new TotalLossMgtDBDAO();
		dbDao1 = new WriteOffMgtDBDAO();
	} 

	/**
	 * [EES_MNR_0098] Total Loss Collection & Inquiry의 정보를 삭제 합니다. <br>
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
	 * [EES_MNR_0095] Total Loss Request의 정보를 삭제 합니다. <br>
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
	 * [EES_MNR_0195] Total Loss No Inquiry_Pop Up의 정보를 조회 합니다. <br>
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
	 * [EES_MNR_0098] Total Loss Request의 정보를 조회 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */
	public TotalLossGRPVO searchTotalLossBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException {
		try {
			//check Total Loss No
			String searchTtlLssNo = totalLossGRPVO.getTotalLossINVO().getSearchTtlLssNo();
			String rqstOfcCd = totalLossGRPVO.getTotalLossINVO().getRqstOfcCd();
//			String pageSeparator = totalLossGRPVO.getPageSeparator();
			
//			int ttlLssNoCnt = dbDao.checkTotalLossNoData(searchTtlLssNo, rqstOfcCd, pageSeparator);
			int ttlLssNoCnt = dbDao.checkTotalLossNoData(searchTtlLssNo, rqstOfcCd);
			if(ttlLssNoCnt < 1) {
				throw new EventException(new ErrorHandler("MNR00411",new String[]{searchTtlLssNo}).getMessage());
//				if("Y".equals(pageSeparator)){
//					throw new EventException(new ErrorHandler("MNR00411",new String[]{searchTtlLssNo}).getMessage());
//				} else {
//					throw new EventException(new ErrorHandler("MNR00287",new String[]{searchTtlLssNo}).getMessage());
//				}
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
		} catch (EventException e ){ 
		    log.error("err " + e.toString(), e);
			throw e;	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] searchTotalLossBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] searchTotalLossBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0098]Total Loss Collection & Inquiry의 정보를 조회 합니다. <br>
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
	 * [EES_MNR_0098]Total Loss Request의 정보를 조회 합니다. <br>
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
	 * [EES_MNR_0098]Total Loss Request의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */ 
	public TotalLossGRPVO manageTotalLossBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException{
		try {
			//Header 설정//////////////////////////////////////////////////////////////////////
			List<CustomMnrTtlLssRqstHdrVO> insertHdrVo = new ArrayList<CustomMnrTtlLssRqstHdrVO>();
			
			String paramTtlLssNo	= totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().getTtlLssNo();
			String ttlLssStsCd = totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().getTtlLssStsCd();
			String newTtlLssNo		= "";
			
			if(paramTtlLssNo.equals("NEW")|| paramTtlLssNo.equals("")) {
				//Total Loss No 생성 조회
				newTtlLssNo = dbDao.searchTotalLossNoData(totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().getRqstOfcCd());
				totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().setTtlLssNo(newTtlLssNo);
			}
			totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().setCreUsrId(account.getUsr_id());
			totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().setUpdUsrId(account.getUsr_id());
			if(!totalLossGRPVO.getTotalLossINVO().getWorkType().equalsIgnoreCase("collection"))
			{
				totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().setTtlLssCfmDt("");
			}
			
			// file_seq 항목이 undefined 이면 강제로 undefined ==> "" 로 변경 (방치하면 ORACLE ERROR 발생함)
			if(totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().getFileSeq().equals("undefined")) {
				totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().setFileSeq("");
			}
			
			insertHdrVo.add(totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO());
			
			//Detail 설정//////////////////////////////////////////////////////////////////////
			List<CustomMnrTtlLssRqstDtlVO> insertDtlVoList = new ArrayList<CustomMnrTtlLssRqstDtlVO>();
			List<CustomMnrTtlLssRqstDtlVO> updateDtlVoList = new ArrayList<CustomMnrTtlLssRqstDtlVO>();
			List<CustomMnrTtlLssRqstDtlVO> deleteDtlVoList = new ArrayList<CustomMnrTtlLssRqstDtlVO>();
			int addCnt=0;
			int maxSeq=0;
			for ( int i=0; i<totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs().length; i++ ) {
//				if( totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getMnrInvTpCd().equalsIgnoreCase("DV") && ttlLssStsCd.equalsIgnoreCase("HR") ){
//					totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setMnrPrnrSeq("6256");
//				}
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
				dbDao.modifyTotalLossRequestOffficeModification(updateDtlVoList);
			}
			if ( deleteDtlVoList.size() > 0 ) {
				dbDao.removeTotalLossDetailData(deleteDtlVoList);
			}
		
			//저장후 Total Loss No Return
			if(paramTtlLssNo.equals("NEW")) {
				totalLossGRPVO.setTotalLossNo(newTtlLssNo);
			} else {
				totalLossGRPVO.setTotalLossNo(paramTtlLssNo);
			}
			
			//Park myoung sin 추가 분 Total Loss Collection
			CustomMnrTtlLssCltVO[] arrCustomMnrTtlLssCltVOS = totalLossGRPVO.getArrCustomMnrTtlLssCltVOS();
			CustomMnrTtlLssRqstHdrVO customMnrTtlLssRqstHdrVO = new CustomMnrTtlLssRqstHdrVO();
			customMnrTtlLssRqstHdrVO.setTtlLssNo(totalLossGRPVO.getTotalLossNo());   
			dbDao.removeTotalLossCLTData(customMnrTtlLssRqstHdrVO);    
			
			//디테일 매각 바이어 데이타 삽입   
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
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] manageTotalLossBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] manageTotalLossBasic"}).getMessage(),de);
		}	
	}
		
	/** 
	 * [EES_MNR_0105]Total Loss Payment to Lessor Report의 정보를 조회 합니다. <br>
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
	 * [EES_MNR_0096]Total Loss Management의 정보를 수정 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */ 
	public TotalLossGRPVO modifyTotalLossDetailBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException{
		try {

			//Detail 설정//////////////////////////////////////////////////////////////////////
			List<CustomMnrTtlLssRqstDtlVO> updateDtlVoList = new ArrayList<CustomMnrTtlLssRqstDtlVO>();
			String ttlLssStsCd = totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().getTtlLssStsCd();
			for ( int i=0; i<totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs().length; i++ ) {
			    
				if( !totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getIbflag().equalsIgnoreCase("D") ){
//					if( totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getMnrInvTpCd().equalsIgnoreCase("DV") && ttlLssStsCd.equalsIgnoreCase("HR") ){
//						totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setMnrPrnrSeq("6256");
//					}
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
				dbDao.modifyTotalLossRequestOffficeModification(updateDtlVoList);
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
	 * [EES_MNR_0098]Total Loss Collection & Inquiry 의 invoice no를 수정 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */ 
	public void modifyTotalLossDetailInvNoBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException{
		try {

			List<CustomMnrTtlLssRqstDtlVO> updateDtlVoList = new ArrayList<CustomMnrTtlLssRqstDtlVO>();
			
			for ( int i=0; i<totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs().length; i++ ) {
				
				if(!totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].getIbflag().equalsIgnoreCase("D")){
					
					totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i].setUpdUsrId(account.getUsr_id());					
					updateDtlVoList.add(totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs()[i]);
				} 
			}  

			if ( updateDtlVoList.size() > 0 ) {
				dbDao.modifyTotalLossDetailInvNoData(updateDtlVoList);
				
			}         
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Collection & Inquiry] modifyTotalLossDetailInvNoBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Collection & Inquiry] modifyTotalLossDetailInvNoBasic"}).getMessage(),de);
		}	
	}

	/**
	 * [EES_MNR_0095]Total Loss Request 에서 로그인 Office의 지역이 US인지 조회합니다. <br>
	 *
	 * @param String rqstOfcCd
	 * @return int
	 * @exception EventException
	 */
	public int searchOfficeAreaUS(String rqstOfcCd) throws EventException {
		try {
		
			return dbDao.searchOfficeAreaUS(rqstOfcCd);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] searchOfficeAreaUS"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] searchOfficeAreaUS"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0262] Write Off Request 정보를 조회 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */ 
	public TotalLossGRPVO searchTotalLossWriteOffRqstListBasic(TotalLossGRPVO totalLossGRPVO) throws EventException {
		try { 	
//			String searchTtlLssNo = totalLossGRPVO.getTotalLossINVO().getSearchTtlLssNo();
//			String rqstOfcCd = "";
//			if(!"".equals(searchTtlLssNo)){
//				int ttlLssNoCnt = dbDao1.checkTotalLossWriteOFfData(searchTtlLssNo);
//				if(ttlLssNoCnt < 1) {
//					throw new EventException(new ErrorHandler("MNR00287",new String[]{searchTtlLssNo}).getMessage());
//				}
//			}
			
			//Header Search   	
			List<CustomMnrTtlLssRqstHdrVO> customMnrTtlLssRqstHdrVOS = dbDao1.searchTotalLossWriteOffHdrListData(totalLossGRPVO);
			totalLossGRPVO.setListCustomMnrTtlLssRqstHdrVO(customMnrTtlLssRqstHdrVOS);
			
			if("".equals(totalLossGRPVO.getTotalLossINVO().getWrtfNo())||"NEW".equals(totalLossGRPVO.getTotalLossINVO().getWrtfNo())){
				totalLossGRPVO.getTotalLossINVO().setWrtfNo(dbDao1.searchMaxWriteOffNoData(totalLossGRPVO.getTotalLossINVO()));
			}
			
			if(!"".equals(totalLossGRPVO.getTotalLossINVO().getWrtfNo())){
				List<CustomMnrWrtfRqstHdrVO> customMnrWrtfRqstHdrVOS = dbDao1.searchTotalWriteOffRmkListData(totalLossGRPVO);
				totalLossGRPVO.setListCustomMnrWrtfRqstHdrVO(customMnrWrtfRqstHdrVOS);
				totalLossGRPVO.getTotalLossINVO().setTtlLssStsCd(customMnrWrtfRqstHdrVOS.get(0).getWrtfStsCd());
				totalLossGRPVO.setWrtfNo(customMnrWrtfRqstHdrVOS.get(0).getWrtfNo());
			}
			List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVOS = dbDao1.searchTotalWriteOffDtlListData(totalLossGRPVO);
			
			totalLossGRPVO.setListCustomMnrTtlLssRqstDtlVO(customMnrTtlLssRqstDtlVOS);
			
			return totalLossGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Write Off Request] searchTotalLossWriteOffRqstListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Write Off Request] searchTotalLossWriteOffRqstListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0262]Write Off Request의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */ 
	public TotalLossGRPVO manageWriteOffBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException{
		try {
			//Header 설정//////////////////////////////////////////////////////////////////////
			List<CustomMnrWrtfRqstHdrVO> insertHdrVo = new ArrayList<CustomMnrWrtfRqstHdrVO>();
			
			String paramWrtfNo	= totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().getWrtfNo();
			String paramWrtfStsCd = totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().getWrtfStsCd();
			String newWrtfNo = "";
			String workType = totalLossGRPVO.getTotalLossINVO().getWorkType();
			if("SAVE".equals(workType)){
				if(paramWrtfNo.equals("NEW")|| paramWrtfNo.equals("")||"RQ".equals(paramWrtfStsCd)||"RD".equals(paramWrtfStsCd)) {
					//Write Off No 생성 조회
					newWrtfNo = dbDao1.searchWriteOffNoData((totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().getWrtfRqstOfcCd()));
					totalLossGRPVO.setWrtfNo(newWrtfNo);
					totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().setWrtfNo(newWrtfNo);
				}else{
					totalLossGRPVO.setWrtfNo(totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().getWrtfNo());
				}
			}
			totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().setCreUsrId(account.getUsr_id());
			totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().setUpdUsrId(account.getUsr_id());
			if("REQUEST".equals(workType)){
				totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().setWrtfStsCd("RQ");
				insertHdrVo.add(totalLossGRPVO.getCustomMnrWrtfRqstHdrVO());
			}else{
				insertHdrVo.add(totalLossGRPVO.getCustomMnrWrtfRqstHdrVO());
			}
//			//Detail 설정//////////////////////////////////////////////////////////////////////
//			List<CustomMnrTtlLssRqstDtlVO> insertDtlVoList = new ArrayList<CustomMnrTtlLssRqstDtlVO>();
			List<CustomMnrTtlLssRqstDtlVO> updateDtlVoList = new ArrayList<CustomMnrTtlLssRqstDtlVO>();
			CustomMnrTtlLssRqstDtlVO[] customMnrTtlLssRqstDtlVOs = totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs();
			if("SAVE".equals(workType)){
				for(int i = 0; i<customMnrTtlLssRqstDtlVOs.length ; i++){
					if("U".equals(customMnrTtlLssRqstDtlVOs[i].getIbflag())){
						if(paramWrtfNo.equals("NEW")|| paramWrtfNo.equals("")||"RQ".equals(paramWrtfStsCd)||"RD".equals(paramWrtfStsCd)) {
							customMnrTtlLssRqstDtlVOs[i].setWrtfNo(newWrtfNo);
						}else{
							customMnrTtlLssRqstDtlVOs[i].setWrtfNo(totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().getWrtfNo());
						}
						updateDtlVoList.add(customMnrTtlLssRqstDtlVOs[i]);
					}
				}
			}

			//Header
			if(paramWrtfNo.equals("NEW")|| paramWrtfNo.equals("")||"RQ".equals(paramWrtfStsCd)||"RD".equals(paramWrtfStsCd)) {
			    dbDao1.addWriteOffHeaderData(insertHdrVo);
			}else{
				if("REQUEST".equals(workType)){
					dbDao1.modifyWriteOffHdrData(insertHdrVo);
				}else{
					dbDao1.modifyWriteOffHeaderData(insertHdrVo);
				}
			}
			
			if ( updateDtlVoList.size() > 0 ) {
				dbDao1.modifyWriteOffDetailData(updateDtlVoList);
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
	 * [EES_MNR_0262]Write Off Request의 정보를 삭제 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */ 
	@Override
	public TotalLossGRPVO removeWriteOffBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException {
		try {
			List<CustomMnrWrtfRqstHdrVO> insertHdrVo = new ArrayList<CustomMnrWrtfRqstHdrVO>();
			
			totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().setCreUsrId(account.getUsr_id());
			totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().setUpdUsrId(account.getUsr_id());
			insertHdrVo.add(totalLossGRPVO.getCustomMnrWrtfRqstHdrVO());

			List<CustomMnrTtlLssRqstDtlVO> updateDtlVoList = new ArrayList<CustomMnrTtlLssRqstDtlVO>();
			CustomMnrTtlLssRqstDtlVO[] customMnrTtlLssRqstDtlVOs = totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs();
			for(int i = 0; i<customMnrTtlLssRqstDtlVOs.length ; i++){
				if(!"".equals(customMnrTtlLssRqstDtlVOs[i].getWrtfNo())){
					updateDtlVoList.add(customMnrTtlLssRqstDtlVOs[i]);
				}
			}

			if( insertHdrVo.size() > 0){
				dbDao1.removeWriteOffHeaderData(insertHdrVo);
			}
			
			if ( updateDtlVoList.size() > 0 ) {
				dbDao1.removeWriteOffDetailData(updateDtlVoList);
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
	 * [EES_MNR_0263] Write Off Approval 정보를 조회 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */ 
	public TotalLossGRPVO searchWriteOffApprovalListBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException{
		try { 	
			//Header Search   	
			List<CustomMnrTtlLssRqstHdrVO> customMnrTtlLssRqstHdrVOS = dbDao1.searchWriteOffApprovalListData(totalLossGRPVO, account);
			totalLossGRPVO.setListCustomMnrTtlLssRqstHdrVO(customMnrTtlLssRqstHdrVOS);
			return totalLossGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Write Off Approval] searchWriteOffApprovalListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Write Off Approval] searchWriteOffApprovalListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0263] Write Off Approval Detail 정보를 조회 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */ 
	public TotalLossGRPVO searchWriteOffApprovalDetailBasic(TotalLossGRPVO totalLossGRPVO) throws EventException{
		try { 	
			List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVOS = dbDao1.searchWriteOffApprovalDetailListData(totalLossGRPVO);
			List<CustomMnrWrtfRqstHdrVO> customMnrWrtfRqstHdrVOS = dbDao1.searchTotalWriteOffRmkListData(totalLossGRPVO);
			
			totalLossGRPVO.setListCustomMnrWrtfRqstHdrVO(customMnrWrtfRqstHdrVOS);
			totalLossGRPVO.setListCustomMnrTtlLssRqstDtlVO(customMnrTtlLssRqstDtlVOS);
			
			return totalLossGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Write Off Approval] searchWriteOffApprovalDetailBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Write Off Approval] searchWriteOffApprovalDetailBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0263]Write Off Approval의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */ 
	public TotalLossGRPVO manageWriteOffApprovalBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException{
		try {

			List<CustomMnrWrtfRqstHdrVO> updateVoList = new ArrayList<CustomMnrWrtfRqstHdrVO>();
			String workType = totalLossGRPVO.getTotalLossINVO().getWorkType();
			totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().setCreUsrId(account.getUsr_id());
			totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().setUpdUsrId(account.getUsr_id());
			totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().setWrtfAproUsrId(account.getUsr_id());
			totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().setWrtfAproOfcCd(account.getOfc_cd());
			totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().setWrtfCfmUsrId(account.getUsr_id());
			totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().setWrtfCfmOfcCd(account.getOfc_cd());
			
			if("Approval".equals(workType)){
				if("BB".equals(totalLossGRPVO.getOfcTpCd())){
					totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().setWrtfStsCd("BV");
				}else if("HQ".equals(totalLossGRPVO.getOfcTpCd())){
					totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().setWrtfStsCd("QV");
				}else if("HO".equals(totalLossGRPVO.getOfcTpCd())){
					totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().setWrtfStsCd("OV");
				}
			}else if ("Reject".equals(workType)){
				if("BB".equals(totalLossGRPVO.getOfcTpCd())){
					totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().setWrtfStsCd("BJ");
				}else if("HQ".equals(totalLossGRPVO.getOfcTpCd())){
					totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().setWrtfStsCd("QJ");
				}else if("HO".equals(totalLossGRPVO.getOfcTpCd())){
					totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().setWrtfStsCd("OJ");
				}
			}
			
			updateVoList.add(totalLossGRPVO.getCustomMnrWrtfRqstHdrVO());
			
			if ( updateVoList.size() > 0 ) {
				if("HO".equals(totalLossGRPVO.getOfcTpCd())){
					dbDao1.modifyWriteOffConfirmData(updateVoList);
				}else{
					dbDao1.modifyWriteOffApprovalData(updateVoList);
				}
			}
			
			return totalLossGRPVO;
			
		} 
		catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] manageTotalLossBasic"}).getMessage(),de);
		} 
		catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] manageTotalLossBasic"}).getMessage(),de);
		}	
	}
	
	/**
	 * [EES_MNR_0264] Write Off Approval 정보를 조회 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */ 
	public TotalLossGRPVO searchWriteOffApprovalInquiryBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException{
		try { 	
			//Header Search   	
			List<CustomMnrTtlLssRqstHdrVO> customMnrTtlLssRqstHdrVOS = dbDao1.searchWriteOffApprovalInquiryData(totalLossGRPVO, account);
			totalLossGRPVO.setListCustomMnrTtlLssRqstHdrVO(customMnrTtlLssRqstHdrVOS);
			return totalLossGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Write Off Approval Inquiry] searchWriteOffApprovalInquiryBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Write Off Approval Inquiry] searchWriteOffApprovalInquiryBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0098]장비가 현재 활성화(A)인지 비활성화(I)인지 확인합니다. <br>
	 *
	 * @param String eq_kind_cd
	 * @param String eq_no
	 * @return List<String>
	 * @exception EventException
	 */ 
	public List<String> searchEqCurrentStatus(String eq_kind_cd, String eq_no) throws EventException{
		try { 	
			//Header Search   
			
			List<String> returnVal = dbDao.searchEqCurrentStatus(eq_kind_cd, eq_no);
			return returnVal;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Collection] searchEqCurrentStatus"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Collection] searchEqCurrentStatus"}).getMessage(),ex);
		}
	}
	
}
