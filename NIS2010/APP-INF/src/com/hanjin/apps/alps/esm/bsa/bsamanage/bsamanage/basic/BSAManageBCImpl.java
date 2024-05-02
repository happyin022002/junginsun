/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : BSAManageBCImpl.java
 *@FileTitle : BSA Manage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-02
 *@LastModifier : KimJongBeom
 *@LastVersion : 1.0
 * 2006-10-02 KimJongBeom
 * 1.0 최초 생성
 * 2008.10.01 전성진 CSR No.N200809059194 : Over Used Slot Price Table 생성
 * 2009.05.21  김종열 CSR No.N200904020151	:BSA Legacy 변경 관련 수정
 * 2009.07.01 김종열 CSR No.N200905220063 : H/C Rate 개발 관련 수정
 * 2009.08.14 Kim Ki-Dae ENIS : ENIS --> ALPS 변환   
 * 2009.11.18 남궁진호 [CHM-200901152] : Carrier Code의 MDM 통합관리에 따른 로직 수정
 * 2010.06.21 이행지  [CHM-201004175] : 소스품질검토결과 적용(20100503) 
 * 2010.09.09 최윤성 [CHM-201005881-01] session 정보 유저 ID 수정
 * 2010.12.07 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 - Rose 비교작업에서 doEnd 삭제
 * 2011.08.19 최성민 [CHM-201112943-01] Add Carrier Time-Out 에러 수정
 * 2012.08.24 이석준 [CHM-201219866] SPS INFO CREATION 의 OTHER SWAP NOTICE 삭제 기능 추가 요청 
 * 2014.12.11 김용습 [CHM-201433095] Error Finder 화면 추가
 * 2015.03.27 김용습 [CHM-201534456] 2015년 1월 소스 보안 결함 건 조치 요청
 =========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration.BSAManageDBDAO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaAddCarrierSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaHighCubicRateSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaManageSltPrcSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaOverUsedSlotCostSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaSlotInfoForSpcCntrSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaTableSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.CreateBSAVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchOverlappedContractInquiryListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchBsaConditionVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchBsaCrrRgstListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchChgSlotSwapListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchSpcJoPortDownDetailListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchSpcJoPortDownMasterListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchSpcScPortDownDetailListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchSpcScPortDownMasterListVO;
import com.hanjin.apps.alps.esm.bsa.common.Utils;
import com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BsaCrrInfoVO;
import com.hanjin.syscommon.common.table.BsaCrrRgstVO;
import com.hanjin.syscommon.common.table.BsaJntOpBzcVO;
import com.hanjin.syscommon.common.table.BsaJntOpCrrCapaVO;
import com.hanjin.syscommon.common.table.BsaJntOpPortDwnVO;
import com.hanjin.syscommon.common.table.BsaSltChtrBzcVO;
import com.hanjin.syscommon.common.table.BsaSltChtrCrrCapaVO;
import com.hanjin.syscommon.common.table.BsaSltChtrPortDwnVO;
import com.hanjin.syscommon.common.table.BsaSpcCtrlSwapVO;


/**
 * enis-BSAManage Business Logic Basic Command implementation<br>
 * - enis-BSAManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KimJongBeom
 * @see ESM_BSA_0xxEventResponse,BSAManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class BSAManageBCImpl extends BasicCommandSupport implements BSAManageBC {

	private transient BSAManageDBDAO dbDao = null;
	/**
	 * BSAManageBCImpl 객체를 생성<br>
	 * BSAManageDBDAO를  생성한다.<br>
	 */
	public BSAManageBCImpl() {
		dbDao = new BSAManageDBDAO();
	}

	/**
	 * ESM_BSA_0021: 헤더구성 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 헤더구성 조회 이벤트 처리<br>
	 * 
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */		

	public CommonBsaRsVO searchBSATableHeaderList() throws EventException {
		log.debug("################# BSAManageBCImpl.searchBSATableHeaderList() ############################[START]");
		try {
			CommonBsaRsVO[] rVoArray = new CommonBsaRsVO[2];
			CommonBsaRsVO rsVo = new CommonBsaRsVO();
			
			rVoArray[0] = new CommonBsaRsVO();
			rVoArray[1] = new CommonBsaRsVO();
			
			rVoArray[0] = dbDao.searchBSATableHeaderList("J");
			
			rVoArray[1] = dbDao.searchBSATableHeaderList("S");
				
			rsVo.setCommonBsaRsVOArray(rVoArray);				
			log.debug("################# BSAManageBCImpl.searchBSATableHeaderList() ############################[END]");
			return rsVo;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}		
	}	

	/**
	 * ESM_BSA_0021: 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO vo
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */	
	public CommonBsaRsVO searchBSATableJOList(SearchBsaConditionVO vo) throws EventException {
		log.debug("################# BSAManageBCImpl.searchBSATableJOList() ############################[START]");
		try {
			List<SearchBsaCrrRgstListVO> codeArr = new ArrayList<SearchBsaCrrRgstListVO>();
			CommonBsaRsVO rsVo = new CommonBsaRsVO();
			CommonBsaRsVO[] retVoArray = new CommonBsaRsVO[2];
			retVoArray[0] = new CommonBsaRsVO();
			retVoArray[1] = new CommonBsaRsVO();
			
			DBRowSet dbRowset = null;
			
			int cnt =0;
			int i =0;
			
			String bsaOpCd = vo.getRdoopcd();
				//조회하기-----------------------------------------
				retVoArray[0] = dbDao.searchBSATableHeaderList(bsaOpCd);
				//--------------------------------------------------
				
				dbRowset = retVoArray[0].getDbRowset();
				
				cnt = dbRowset.getRowCount();
				
			    if(cnt > 0){			    	
			    		while(dbRowset.next()){
			    			SearchBsaCrrRgstListVO arrVo = new SearchBsaCrrRgstListVO();
							arrVo.setBsaOpJbCd(JSPUtil.getNull(dbRowset.getString("bsa_op_jb_cd")));
							arrVo.setCrrCd(JSPUtil.getNull(dbRowset.getString("crr_cd")));
							codeArr.add(i, arrVo);
							i++;
			    		}
			    }	
			    dbRowset.beforeFirst() ;
//				String bsaOpJbCd = vo.getBsaopjbcd();
//				String crrCd     = vo.getJheader();
//				
//				if (bsaOpJbCd.length()>0) { 
//					bsaOpJbCd = bsaOpJbCd.substring(1); 
//				}
//				if (crrCd.length()>0){ 
//					crrCd = crrCd.substring(1); 
//				}
				
//				if(bsaOpJbCd != null && !bsaOpJbCd.equals("") && crrCd != null && !crrCd.equals("")){
//					
//					StringTokenizer st1  = new StringTokenizer(bsaOpJbCd, "|");
//					StringTokenizer st2  = new StringTokenizer(crrCd, "|");
//					
//					List<String> tempArrList1 = new ArrayList<String>();
//					List<String> tempArrList2 = new ArrayList<String>();
//					
//					while( st1.hasMoreTokens() ) {
//						tempArrList1.add(j++, st1.nextToken());
//					}
//					j = 0;
//					while( st2.hasMoreTokens() ) {
//						tempArrList2.add(j++, st2.nextToken());
//					}
//					
//					int cnt1 = tempArrList1.size();
//					int cnt2 = tempArrList2.size();
//					
//					if(cnt1 == cnt2){
//						for(int i=0; i<cnt1; i++){
//							SearchBsaCrrRgstListVO arrVo = new SearchBsaCrrRgstListVO();
//							arrVo.setBsaOpJbCd((String)tempArrList1.get(i));
//							arrVo.setCrrCd((String)tempArrList2.get(i));
//							codeArr.add(i, arrVo);
//						}
//					}
//				}
		
				vo.setTxtsdate( vo.getTxtsdate().replaceAll("-",""));
				vo.setTxtedate( vo.getTxtedate().replaceAll("-",""));

				//조회하기-------------------------------------
				retVoArray[1] = dbDao.searchBSATableJOList(vo,codeArr);
				//---------------------------------------------
				
				rsVo.setCommonBsaRsVOArray(retVoArray);
				
				log.debug("################# BSAManageBCImpl.searchBSATableJOList() ############################[END]");
			return rsVo;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}		
	}		

	/**
	 * ESM_BSA_0021: 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO vo
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */	
	public CommonBsaRsVO searchBSATableSCList(SearchBsaConditionVO vo) throws EventException {
		log.debug("################# BSAManageBCImpl.searchBSATableSCList() ############################[START]");
		try {
			List<SearchBsaCrrRgstListVO> codeArr = new ArrayList<SearchBsaCrrRgstListVO>();
			CommonBsaRsVO rsVo = new CommonBsaRsVO();
			CommonBsaRsVO[] retVoArray = new CommonBsaRsVO[2];
			retVoArray[0] = new CommonBsaRsVO();
			retVoArray[1] = new CommonBsaRsVO();
			
			DBRowSet dbRowset = null;
			
			int cnt =0;
			int i =0;
			
			String bsaOpCd = vo.getRdoopcd();
				//조회하기-----------------------------------------
				retVoArray[0] = dbDao.searchBSATableHeaderList(bsaOpCd);
				//--------------------------------------------------
				
				dbRowset = retVoArray[0].getDbRowset();
				
				cnt = dbRowset.getRowCount();
				
			    if(cnt > 0){			    	
			    		while(dbRowset.next()){
			    			SearchBsaCrrRgstListVO arrVo = new SearchBsaCrrRgstListVO();
							arrVo.setBsaOpJbCd(JSPUtil.getNull(dbRowset.getString("bsa_op_jb_cd")));
							arrVo.setCrrCd(JSPUtil.getNull(dbRowset.getString("crr_cd")));
							codeArr.add(i, arrVo);
							i++;
			    		}
			    }		
			    dbRowset.beforeFirst() ;
				
//				String bsaOpJbCd = vo.getBsaopjbcd2();
//				String crrCd     = vo.getSheader();
//				
//				if (bsaOpJbCd.length()>0) { 
//					bsaOpJbCd = bsaOpJbCd.substring(1); 
//				}
//				if (crrCd.length()>0){ 
//					crrCd = crrCd.substring(1); 
//				}
//				
//				if(bsaOpJbCd != null && !bsaOpJbCd.equals("") && crrCd != null && !crrCd.equals("")){
//					
//					StringTokenizer st1  = new StringTokenizer(bsaOpJbCd, "|");
//					StringTokenizer st2  = new StringTokenizer(crrCd, "|");
//					
//					List<String> tempArrList1 = new ArrayList<String>();
//					List<String> tempArrList2 = new ArrayList<String>();
//					
//					while( st1.hasMoreTokens() ) {
//						tempArrList1.add(j++, st1.nextToken());
//					}
//					j = 0;
//					while( st2.hasMoreTokens() ) {
//						tempArrList2.add(j++, st2.nextToken());
//					}
//					
//					int cnt1 = tempArrList1.size();
//					int cnt2 = tempArrList2.size();
//					
//					if(cnt1 == cnt2){
//						for(int i=0; i<cnt1; i++){
//							SearchBsaCrrRgstListVO arrVo = new SearchBsaCrrRgstListVO();
//							arrVo.setBsaOpJbCd((String)tempArrList1.get(i));
//							arrVo.setCrrCd((String)tempArrList2.get(i));
//							codeArr.add(i, arrVo);
//						}
//					}
//				}
		
				vo.setTxtsdate( vo.getTxtsdate().replaceAll("-",""));
				vo.setTxtedate( vo.getTxtedate().replaceAll("-",""));			
				
				//조회하기-------------------------------------
				retVoArray[1] = dbDao.searchBSATableSCList(vo,codeArr);
				//----------------------------------------------

				rsVo.setCommonBsaRsVOArray(retVoArray);
			
			log.debug("################# BSAManageBCImpl.searchBSATableSCList() ############################[END]");
			return rsVo;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}		
	}		

	/**
	 * ESM_BSA_0021: 멀티 이벤트 처리<br>
	 * BSAManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param BsaTableSaveVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void multiBSATableJO(BsaTableSaveVO[] vos, SignOnUserAccount account) throws EventException{
		try{
			String creUsrId = account.getUsr_id();
			String updUsrId = account.getUsr_id();
			
			BsaJntOpBzcVO 		paramVo  = null;
			BsaJntOpCrrCapaVO 	paramVo2 = null;
			BsaSpcCtrlSwapVO 	paramVo3 = null;
			BsaJntOpPortDwnVO   paramVo4 = null;
			
			List<BsaJntOpBzcVO> 	insertVoList = new ArrayList<BsaJntOpBzcVO>();  
			List<BsaSpcCtrlSwapVO> 	insertVoList2 = new ArrayList<BsaSpcCtrlSwapVO>();  
			List<BsaJntOpCrrCapaVO> insertVoList3 = new ArrayList<BsaJntOpCrrCapaVO>();  									
			List<BsaJntOpPortDwnVO> insertVoList4 = new ArrayList<BsaJntOpPortDwnVO>();  
			List<BsaJntOpCrrCapaVO> insertVoList5 = new ArrayList<BsaJntOpCrrCapaVO>();
			List<BsaJntOpBzcVO> 	updateVoList = new ArrayList<BsaJntOpBzcVO>();  
			List<BsaJntOpCrrCapaVO> updateVoList2 = new ArrayList<BsaJntOpCrrCapaVO>(); 
			List<BsaJntOpCrrCapaVO> updateVoList3 = new ArrayList<BsaJntOpCrrCapaVO>(); 
			List<BsaJntOpCrrCapaVO> updateVoList4 = new ArrayList<BsaJntOpCrrCapaVO>();
			List<BsaJntOpCrrCapaVO> muiltVoList = new ArrayList<BsaJntOpCrrCapaVO>(); 
			List<BsaJntOpCrrCapaVO> muiltVoList2 = new ArrayList<BsaJntOpCrrCapaVO>(); 
			List<BsaJntOpCrrCapaVO> muiltVoList3 = new ArrayList<BsaJntOpCrrCapaVO>(); 
			List<BsaJntOpCrrCapaVO> muiltVoList4 = new ArrayList<BsaJntOpCrrCapaVO>(); 
			
			 for(int i = 0 ; i < vos.length ; i++){
				 paramVo = new BsaJntOpBzcVO();
				 
				//채번하기 -------------------------------------------------------
//				 if(vos[i].getIbflag().equals("I")) {
//    				 [DB 실행]
//					String seq = dbDao.bsaJntOpBzcSeqno(vos[i]);
//				 }
				 String bsaSeq 	= vos[i].getBsaseq();
				 String trdCd  	= vos[i].getTrdcd();
				 String rlaneCd = vos[i].getRlanecd();
				 String dirCd	= vos[i].getDircd();
				 String vopCd	= vos[i].getVopcd();
				 String vslCapa	= vos[i].getVslcapa();
				 String vvdCd	= vos[i].getVvdcd();
				 String bsaFmDt	= vos[i].getBsafmdt();
				 String bsaToDt	= vos[i].getBsatodt();
				 String bsaCapa	= vos[i].getBsacapa();
				 String joDesc	= vos[i].getJodesc();
				 String fnlHjsBsaCapa 	 = vos[i].getFnlhjsbsacapa();
				 String	hjsBsaBfrSubCapa = vos[i].getHjsbsabfrsubcapa();
				 String spcOtrSwapFlg	 = vos[i].getSpcotrswapflg();
				 String ownrVslWgt		 = vos[i].getOwnrvslwgt();
				 
				 String bsaOpCd		 = vos[i].getRdoopcd();
				 String[] bsaOpJbCd	 = vos[i].getBsaopjbcd().split("[|]");
				 String[] crrCd 	 = vos[i].getJheader().split("[|]");
				 String[] crrBsaCapa = vos[i].getCrrbsacapa().split("[|]");
				 						 
				 
				//----------------------------------------------------
				// 1. BSA_JNT_OP_BZC 테이블의 데이터를 변경한다.(I/U)
				//----------------------------------------------------
				 paramVo.setBsaSeq(bsaSeq);
            	 paramVo.setTrdCd(trdCd);
            	 paramVo.setRlaneCd(rlaneCd);
            	 paramVo.setDirCd(dirCd);
            	 paramVo.setVopCd(vopCd);
            	 paramVo.setVslCapa(vslCapa);
            	 paramVo.setVvdCd(vvdCd);
            	 paramVo.setBsaFmDt(bsaFmDt);
            	 paramVo.setBsaToDt(bsaToDt);
            	 paramVo.setBsaCapa(bsaCapa);
            	 paramVo.setFnlHjsBsaCapa(fnlHjsBsaCapa);
            	 paramVo.setHjsBsaBfrSubCapa(hjsBsaBfrSubCapa);
            	 paramVo.setJoDesc(joDesc);
            	 paramVo.setSpcOtrSwapFlg(spcOtrSwapFlg);
            	 paramVo.setOwnrVslWgt(ownrVslWgt);
            	 paramVo.setCreUsrId(creUsrId);
            	 paramVo.setUpdUsrId(updUsrId);
            	 
            	
            	 if(vos[i].getIbflag().equals("I")) {
                	 insertVoList.add(paramVo);
                	 
                 }else if(vos[i].getIbflag().equals("U")) {
                	 updateVoList.add(paramVo);
                 }	 
            	//---------------------------------------------------- 
            	// 2. BSA_JNT_OP_CRR_CAPA 테이블의 데이터를 변경한다.(I/U)
 				//----------------------------------------------------
            	 for (int j = 0; j < bsaOpJbCd.length; j++) {
            		 paramVo2 = new BsaJntOpCrrCapaVO();
					 
            		 paramVo2.setBsaSeq(bsaSeq);
                	 paramVo2.setTrdCd(trdCd);
                	 paramVo2.setRlaneCd(rlaneCd);
                	 paramVo2.setDirCd(dirCd);
                	 paramVo2.setVopCd(vopCd);
                	 paramVo2.setVslCapa(vslCapa);
                	 paramVo2.setBsaOpCd(bsaOpCd);
                	 paramVo2.setBsaOpJbCd(bsaOpJbCd[j]);
                	 paramVo2.setCrrCd(crrCd[j]);
                	 paramVo2.setCrrBsaCapa(crrBsaCapa[j]);
                	 paramVo2.setCreUsrId(creUsrId);
                	 paramVo2.setUpdUsrId(updUsrId);
                	 
                	 if(vos[i].getIbflag().equals("I") || vos[i].getIbflag().equals("U")) {
                		 muiltVoList.add(paramVo2);
                     }	 
				}
               //----------------------------------------------------
               // 3. Row Add시 이전 SEQ의 SWAP정보가 있으면 이전 SEQ의
 			   //    SWAP정보로 BSA_SPC_CTRL_SWAP에 SWAP정보를 추가한다.[I]
 			   //----------------------------------------------------
            	 if(vos[i].getIbflag().equals("I")) { 	
	            	 paramVo3 = new BsaSpcCtrlSwapVO();
	            	  	
	            	 	paramVo3.setBsaSeq(bsaSeq);
	            	  	paramVo3.setTrdCd(trdCd);
	            	  	paramVo3.setRlaneCd(rlaneCd);
	            	  	paramVo3.setDirCd(dirCd);
	            	  	paramVo3.setVopCd(vopCd);
	            	  	paramVo3.setVslCapa(vslCapa);
	            	  	paramVo3.setCreUsrId(creUsrId);
	            	  	paramVo3.setUpdUsrId(updUsrId);

	            	  	insertVoList2.add(paramVo3);
                    }
            
               //----------------------------------------------------
               // 4. 추가된 데이터에 대한 Capa추가(006~019)[I]
    		   //----------------------------------------------------
            	  if(vos[i].getIbflag().equals("I")) {	
	            	  	paramVo2 = new BsaJntOpCrrCapaVO();
	            	  	
	            	  	paramVo2.setBsaOpCd(bsaOpCd);
	            	  	paramVo2.setBsaSeq(bsaSeq);
	            	  	paramVo2.setTrdCd(trdCd);
	            	  	paramVo2.setRlaneCd(rlaneCd);
	            	  	paramVo2.setDirCd(dirCd);
	            	  	paramVo2.setVopCd(vopCd);
	            	  	paramVo2.setVslCapa(vslCapa);
	            	  	paramVo2.setCreUsrId(creUsrId);
	            	  	paramVo2.setUpdUsrId(updUsrId);
	            	  	
	            	  	insertVoList3.add(paramVo2);
                    }
             //----------------------------------------------------            	  	
             // 5. 추가된 데이터에 대한 Port 추가[I]
    		 //----------------------------------------------------
            	  if(vos[i].getIbflag().equals("I")) {	
	            	 	paramVo4 = new BsaJntOpPortDwnVO();
	            	  	
	            	  	paramVo4.setBsaOpCd(bsaOpCd);
	            	  	paramVo4.setBsaSeq(bsaSeq);
	            	  	paramVo4.setTrdCd(trdCd);
	            	  	paramVo4.setRlaneCd(rlaneCd);
	            	  	paramVo4.setDirCd(dirCd);
	            	  	paramVo4.setVopCd(vopCd);
	            	  	paramVo4.setVslCapa(vslCapa);
	            	  	paramVo4.setCreUsrId(creUsrId);
	            	  	paramVo4.setUpdUsrId(updUsrId);
	            	  	
	            	  	insertVoList4.add(paramVo4);
                  }
            	//------------------------------------------------------------------
            	// 6. BSA[007]의 Carrier정보를 다시 계산한다.[I/U]
  				//------------------------------------------------------------------  
            	  if(vos[i].getIbflag().equals("I")||vos[i].getIbflag().equals("U")) {	
	            	  	paramVo2 = new BsaJntOpCrrCapaVO();
	            	  	
	            	  	paramVo2.setBsaOpCd(bsaOpCd);
	            	  	paramVo2.setBsaSeq(bsaSeq);
	            	  	paramVo2.setTrdCd(trdCd);
	            	  	paramVo2.setRlaneCd(rlaneCd);
	            	  	paramVo2.setDirCd(dirCd);
	            	  	paramVo2.setVopCd(vopCd);
	            	  	paramVo2.setVslCapa(vslCapa);
	            	  	paramVo2.setCreUsrId(creUsrId);
	            	  	paramVo2.setUpdUsrId(updUsrId);
	            	  	
	            	  	muiltVoList2.add(paramVo2);
                  }
            	  
            	//------------------------------------------------------------------
            	// 7. BSA의 slot swap정보가 있으면 swap정보를 이용하여 Carrier정보를 다시 계산한다.[21,24][I/U]
  				//------------------------------------------------------------------
            	  if(vos[i].getIbflag().equals("I")||vos[i].getIbflag().equals("U")) {	
	            	  	paramVo2 = new BsaJntOpCrrCapaVO();
	            	  	
	            	  	paramVo2.setBsaOpCd(bsaOpCd);
	            	  	paramVo2.setBsaOpJbCd("007");
	            	  	paramVo2.setBsaSeq(bsaSeq);
	            	  	paramVo2.setTrdCd(trdCd);
	            	  	paramVo2.setRlaneCd(rlaneCd);
	            	  	paramVo2.setDirCd(dirCd);
	            	  	paramVo2.setVopCd(vopCd);
	            	  	paramVo2.setVslCapa(vslCapa);
	            	  	paramVo2.setCreUsrId(creUsrId);
	            	  	paramVo2.setUpdUsrId(updUsrId);
	            	  	
	            	  	muiltVoList3.add(paramVo2);
                }
            	  
            	//------------------------------------------------------------------  
            	// 8. 이전 seq의 Weigth Per TEU, RF, D2, D4, D5, D7의 capa정보를 복제한다.[I]
  				//------------------------------------------------------------------
            	  if(vos[i].getIbflag().equals("I")) {	
	            	  	paramVo2 = new BsaJntOpCrrCapaVO();
	            	  	
//	            	  	int srcBsaSeq =Integer.parseInt(bsaSeq) - 1;
//	  					쿼리상에서 -1 처리 함
//	            	  	paramVo3.setBsaSeq( String.valueOf(srcBsaSeq));
	            	  	
	            	  	paramVo2.setBsaSeq(bsaSeq);
	            	  	paramVo2.setTrdCd(trdCd);
	            	  	paramVo2.setRlaneCd(rlaneCd);
	            	  	paramVo2.setDirCd(dirCd);
	            	  	paramVo2.setVopCd(vopCd);
	            	  	paramVo2.setVslCapa(vslCapa);
	            	  	paramVo2.setCreUsrId(creUsrId);
	            	  	paramVo2.setUpdUsrId(updUsrId);
	            	  	
	            	  	insertVoList5.add(paramVo2);
            	  }
            	//------------------------------------------------------------------	 
            	// 9. BSA의 HJS정보를 FNL_HJS_BSA_CAPA정보로 업데이트 한다.[I/U]
  				//------------------------------------------------------------------	  
            	  if(vos[i].getIbflag().equals("I")||vos[i].getIbflag().equals("U")) {	
	            	  	paramVo2 = new BsaJntOpCrrCapaVO();
	            	  	
	            	  	paramVo2.setBsaOpCd(bsaOpCd);
	            	  	paramVo2.setBsaSeq(bsaSeq);
	            	  	paramVo2.setTrdCd(trdCd);
	            	  	paramVo2.setRlaneCd(rlaneCd);
	            	  	paramVo2.setDirCd(dirCd);
	            	  	paramVo2.setVopCd(vopCd);
	            	  	paramVo2.setVslCapa(vslCapa);
	            	  	paramVo2.setCreUsrId(creUsrId);
	            	  	paramVo2.setUpdUsrId(updUsrId);
	            	  	
	            	  	muiltVoList4.add(paramVo2);
            	  }
            	  
            //------------------------------------------------------------------
            // 10. BSA정보가 변경되면 TTL Weight정보를 다시 계산한다.[21,24][I/U]
  			//------------------------------------------------------------------
            	  if(vos[i].getIbflag().equals("I")||vos[i].getIbflag().equals("U")) {	
	            	  	paramVo2 = new BsaJntOpCrrCapaVO();
	            	  	
	            	  	paramVo2.setBsaOpCd(bsaOpCd);
	            	  	paramVo2.setBsaOpJbCd("007");
	            	  	paramVo2.setBsaSeq(bsaSeq);
	            	  	paramVo2.setTrdCd(trdCd);
	            	  	paramVo2.setRlaneCd(rlaneCd);
	            	  	paramVo2.setDirCd(dirCd);
	            	  	paramVo2.setVopCd(vopCd);
	            	  	paramVo2.setVslCapa(vslCapa);
	            	  	paramVo2.setCreUsrId(creUsrId);
	            	  	paramVo2.setUpdUsrId(updUsrId);
	            	  	
	            	  	updateVoList2.add(paramVo2);
	            	  	if (Double.parseDouble(ownrVslWgt) > 0) {
	            	  		updateVoList3.add(paramVo2);
	            	  	}
            	  }
	        //------------------------------------------------------------------
	        // 11. TTL Weight 가 변경되었으므로[I/U]
	    	//------------------------------------------------------------------
            	  if(vos[i].getIbflag().equals("I")||vos[i].getIbflag().equals("U")) {	
	            	  	paramVo2 = new BsaJntOpCrrCapaVO();
	            	  	
	            	  	paramVo2.setBsaOpCd(bsaOpCd);
	            	  	paramVo2.setBsaSeq(bsaSeq);
	            	  	paramVo2.setTrdCd(trdCd);
	            	  	paramVo2.setRlaneCd(rlaneCd);
	            	  	paramVo2.setDirCd(dirCd);
	            	  	paramVo2.setVopCd(vopCd);
	            	  	paramVo2.setVslCapa(vslCapa);
	            	  	paramVo2.setCreUsrId(creUsrId);
	            	  	paramVo2.setUpdUsrId(updUsrId);
	            	  	
	            	  	updateVoList4.add(paramVo2);
            	  }
             }			
		                
			// 1. BSA_JNT_OP_BZC 테이블의 데이터를 변경한다.(I/U)
			//----------------------------------------------------
		    //[DB 실행]
			 if (insertVoList.size() > 0){
				 dbDao.addMultiBsaJntOpBzc(insertVoList);
			 }
			 if (updateVoList.size() > 0){
				 dbDao.modifyMultiBsaJntOpBzc(updateVoList);
			 }
				
			// 2. BSA_JNT_OP_CRR_CAPA 테이블의 데이터를 변경한다.(I/U)
			//----------------------------------------------------
		    //[DB 실행]
			 if (muiltVoList.size() > 0){
				dbDao.multiBsaJntOpCrrCapa(muiltVoList);
			 }
			
			 // 3. Row Add시 이전 SEQ의 SWAP정보가 있으면  #######################
			 //     이전 SEQ의 SWAP정보로 BSA_SPC_CTRL_SWAP에 SWAP정보를 추가한다.[I]  START
		     //[DB 실행]
			 if (insertVoList2.size()> 0) {
		        dbDao.addBsaSpcCtrlSwap(insertVoList2);
			 }
				
			 // 4. 추가된 데이터에 대한 Capa추가(006~019)[I]
			 //----------------------------------------------------
		     //[DB 실행]
			 if (insertVoList3.size()> 0) {
				dbDao.addSpcJoCrrCapa(insertVoList3);
			 }
				
			// 5. 추가된 데이터에 대한 Port 추가[I]
			//----------------------------------------------------
		    //[DB 실행]insertVoList4
			 if (insertVoList4.size()> 0) {
				dbDao.addSpcJoPortDwn(insertVoList4);
			 }
				
			 // 6. BSA[007]의 Carrier정보를 다시 계산한다.[I/U]
			 //------------------------------------------------------------------
		     //[DB 실행]
			 if (muiltVoList2.size()> 0) {
				dbDao.modifySpcJoBsaCapa(muiltVoList2);
			 }

			 // 7. BSA의 slot swap정보가 있으면 swap정보를 이용하여 Carrier정보를 다시 계산한다.[21,24][I/U]
			 //------------------------------------------------------------------
		     //[DB 실행]
			 if (muiltVoList3.size()> 0) {
				dbDao.modifySpcJoSwapCapa(muiltVoList3) ;
			 }

			 // 8. 이전 seq의 Weigth Per TEU, RF, D2, D4, D5, D7의 capa정보를 복제한다.[I]
			 //------------------------------------------------------------------
		     //[DB 실행]
			 if (insertVoList5.size()> 0) {
				dbDao.modifySpcJoOthCapa(insertVoList5);
			 }

			 // 9. BSA의 HJS정보를 FNL_HJS_BSA_CAPA정보로 업데이트 한다.[I/U]
			 //------------------------------------------------------------------
			 //[DB 실행] 
			 if (muiltVoList4.size()> 0) {
				dbDao.modifySpcJoHJSBsaCapa(muiltVoList4);
			 }

			 // 10. BSA정보가 변경되면 TTL Weight정보를 다시 계산한다.[21,24][I/U]
			 //------------------------------------------------------------------			
			 //[DB 실행]
			 if (updateVoList2.size()> 0) {			 
					dbDao.modifySpcJoTTLWeight1(updateVoList2);
			 }
			 if (updateVoList3.size()> 0) {
					dbDao.modifySpcJoTTLWeight2(updateVoList3);
			 }

			 // 11. TTL Weight 가 변경되었으므로[I/U]
			 //------------------------------------------------------------------
    		 //[DB 실행]
			 if (updateVoList4.size()> 0) {	
					dbDao.modifySpcJoWeightPerTEU(updateVoList4);			        
			 }
				
				//############################################################################
	
				// 6. 신규/수정된 데이터에 대한 BSA(007)의 capa 정보를 계산한다
				// 7. 신규/수정된 데이터에 대한 BSA(007)의 swap 정보를 적용하여 capa정보를 재계산한다.
				// 8. 새로 추가된 Row에 이전 seq의 Weigth Per TEU, RF, D2, D4, D5, D7의 capa정보를 복제한다.
				// 9. 신규/수정된 데이터에 대한 TTL Weight(009)의 capa 정보를 계산하다.(BSA[007] * Weight Per TEU[008])
				//10. 신규/수정된 데이터에 대한 BSA(007) SML carrier 의 capa정보를 계산한다.
				//------------------------------------------------------------------
				//dbDao.modifyCoaBsaJntOpCrrCapa(event);		
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} 	
	}

	/**
	 * ESM_BSA_0021: 멀티 이벤트 처리<br>
	 * BSAManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param BsaTableSaveVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiBSATableSC(BsaTableSaveVO[] vos, SignOnUserAccount account) throws EventException{
		try{
			String creUsrId = account.getUsr_id();
			String updUsrId = account.getUsr_id();
			
			BsaSltChtrBzcVO			paramVo  = null;
			BsaSltChtrCrrCapaVO 	paramVo2 = null;
			BsaSltChtrPortDwnVO   	paramVo4 = null;
			
			List<BsaSltChtrBzcVO> 	  insertVoList = new ArrayList<BsaSltChtrBzcVO>();  
			List<BsaSltChtrCrrCapaVO> insertVoList3 = new ArrayList<BsaSltChtrCrrCapaVO>();  									
			List<BsaSltChtrPortDwnVO> insertVoList4 = new ArrayList<BsaSltChtrPortDwnVO>();  
			List<BsaSltChtrCrrCapaVO> insertVoList5 = new ArrayList<BsaSltChtrCrrCapaVO>();
			List<BsaSltChtrBzcVO> 	  updateVoList = new ArrayList<BsaSltChtrBzcVO>();  
			List<BsaSltChtrCrrCapaVO> updateVoList2 = new ArrayList<BsaSltChtrCrrCapaVO>(); 
			List<BsaSltChtrCrrCapaVO> updateVoList4 = new ArrayList<BsaSltChtrCrrCapaVO>();
			List<BsaSltChtrCrrCapaVO> muiltVoList = new ArrayList<BsaSltChtrCrrCapaVO>(); 
			List<BsaSltChtrCrrCapaVO> muiltVoList2 = new ArrayList<BsaSltChtrCrrCapaVO>(); 
			List<BsaSltChtrCrrCapaVO> muiltVoList4 = new ArrayList<BsaSltChtrCrrCapaVO>(); 
			
			 for(int i = 0 ; i < vos.length ; i++){
				 paramVo = new BsaSltChtrBzcVO();
				 
				//채번하기 -------------------------------------------------------
//				 if(vos[i].getIbflag().equals("I")) {
//    				 [DB 실행]
//					String seq = dbDao.bsaSltChtrBzcSeqno(vos[i]);
//				 }
				 String bsaSeq 	= vos[i].getBsaseq();
				 String trdCd  	= vos[i].getTrdcd();
				 String rlaneCd = vos[i].getRlanecd();
				 String dirCd	= vos[i].getDircd();
				 String vslSeq	= vos[i].getVslseq();
				 String vvdCd	= vos[i].getVvdcd();
				 String bsaFmDt	= vos[i].getBsafmdt();
				 String bsaToDt	= vos[i].getBsatodt();
				 String vslCd	= vos[i].getVslcd();
				 String schtDesc	= vos[i].getSchtdesc();
				 String hjsFnlBsaCapa 	 = vos[i].getHjsfnlbsacapa();
				 String	hjsBsaBfrSubCapa = vos[i].getHjsbsabfrsubcapa();
				 String vslBsaChkFlg	 = Utils.change10ToYN(vos[i].getVslbsachkflg());
				 
				 String bsaOpCd		 = vos[i].getRdoopcd();
				 String[] bsaOpJbCd	 = vos[i].getBsaopjbcd2().split("[|]");
				 String[] crrCd 	 = vos[i].getSheader().split("[|]");
				 String[] crrBsaCapa = vos[i].getCrrbsacapa().split("[|]");
				 						 
				 
				//----------------------------------------------------
				// 1.BSA_SLT_CHTR_BZC 테이블의 데이터를 변경한다.(I/U)
				//----------------------------------------------------
				 paramVo.setBsaSeq(bsaSeq);
            	 paramVo.setTrdCd(trdCd);
            	 paramVo.setRlaneCd(rlaneCd);
            	 paramVo.setDirCd(dirCd);
            	 paramVo.setVslSeq(vslSeq);
            	 paramVo.setVvdCd(vvdCd);
            	 paramVo.setBsaFmDt(bsaFmDt);
            	 paramVo.setBsaToDt(bsaToDt);
            	 paramVo.setVslCd(vslCd);
            	 paramVo.setHjsFnlBsaCapa(hjsFnlBsaCapa);
            	 paramVo.setHjsBsaBfrSubCapa(hjsBsaBfrSubCapa);
            	 paramVo.setVslBsaChkFlg(vslBsaChkFlg);
            	 paramVo.setSchtDesc(schtDesc);
            	 paramVo.setCreUsrId(creUsrId);
            	 paramVo.setUpdUsrId(updUsrId);
            	 
            	
            	 if(vos[i].getIbflag().equals("I")) {
                	 insertVoList.add(paramVo);
                	 
                 }else if(vos[i].getIbflag().equals("U")) {
                	 updateVoList.add(paramVo);
                 }	 
            	//---------------------------------------------------- 
            	// 2. BSA_SLT_CHTR_CRR_CAPA 테이블의 데이터를 변경한다.(I/U)
 				//----------------------------------------------------
            	 for (int j = 0; j < bsaOpJbCd.length; j++) {
            		 paramVo2 = new BsaSltChtrCrrCapaVO();
					 
            		 paramVo2.setBsaSeq(bsaSeq);
                	 paramVo2.setTrdCd(trdCd);
                	 paramVo2.setRlaneCd(rlaneCd);
                	 paramVo2.setDirCd(dirCd);
                	 paramVo2.setVslSeq(vslSeq);
                	 paramVo2.setBsaOpCd(bsaOpCd);
                	 paramVo2.setBsaOpJbCd(bsaOpJbCd[j]);
                	 paramVo2.setCrrCd(crrCd[j]);
                	 paramVo2.setCrrBsaCapa(crrBsaCapa[j]);
                	 paramVo2.setCreUsrId(creUsrId);
                	 paramVo2.setUpdUsrId(updUsrId);
                	 
                	 if(vos[i].getIbflag().equals("I") || vos[i].getIbflag().equals("U")) {
                		 muiltVoList.add(paramVo2);
                     }	 
				}
                          
               //----------------------------------------------------
               // 3. 추가된 데이터에 대한 Capa추가(006~019)
    		   //----------------------------------------------------
            	  if(vos[i].getIbflag().equals("I")) {	
	            	  	paramVo2 = new BsaSltChtrCrrCapaVO();
	            	  	
	            	  	paramVo2.setBsaOpCd(bsaOpCd);
	            	  	paramVo2.setBsaSeq(bsaSeq);
	            	  	paramVo2.setTrdCd(trdCd);
	            	  	paramVo2.setRlaneCd(rlaneCd);
	            	  	paramVo2.setDirCd(dirCd);
	            	  	paramVo2.setVslSeq(vslSeq);
	            	  	paramVo2.setCreUsrId(creUsrId);
	            	  	paramVo2.setUpdUsrId(updUsrId);
	            	  	
	            	  	insertVoList3.add(paramVo2);
                    }
             //----------------------------------------------------            	  	
             //4. 추가된 데이터에 대한 Port 추가
    		 //----------------------------------------------------
            	  if(vos[i].getIbflag().equals("I")) {	
	            	 	paramVo4 = new BsaSltChtrPortDwnVO();
	            	  	
	            	  	paramVo4.setBsaOpCd(bsaOpCd);
	            	  	paramVo4.setBsaSeq(bsaSeq);
	            	  	paramVo4.setTrdCd(trdCd);
	            	  	paramVo4.setRlaneCd(rlaneCd);
	            	  	paramVo4.setDirCd(dirCd);
	            	  	paramVo4.setVslSeq(vslSeq);
	            	  	paramVo4.setCreUsrId(creUsrId);
	            	  	paramVo4.setUpdUsrId(updUsrId);
	            	  	
	            	  	insertVoList4.add(paramVo4);
                  }
            	//------------------------------------------------------------------
            	// 6. BSA[007]의 Carrier정보를 다시 계산한다.[I/U]
  				//------------------------------------------------------------------  
            	  if(vos[i].getIbflag().equals("I")||vos[i].getIbflag().equals("U")) {	
	            	  	paramVo2 = new BsaSltChtrCrrCapaVO();
	            	  	
	            	  	paramVo2.setBsaOpCd(bsaOpCd);
	            	  	paramVo2.setBsaSeq(bsaSeq);
	            	  	paramVo2.setTrdCd(trdCd);
	            	  	paramVo2.setRlaneCd(rlaneCd);
	            	  	paramVo2.setDirCd(dirCd);
	            	  	paramVo2.setVslSeq(vslSeq);
	            	  	paramVo2.setCreUsrId(creUsrId);
	            	  	paramVo2.setUpdUsrId(updUsrId);
	            	  	
	            	  	muiltVoList2.add(paramVo2);
                  }
            	  
            	            	  
            	//------------------------------------------------------------------  
            	// 8. 이전 seq의 Weigth Per TEU, RF, D2, D4, D5, D7의 capa정보를 복제한다.[I]
  				//------------------------------------------------------------------
            	  if(vos[i].getIbflag().equals("I")) {	
	            	  	paramVo2 = new BsaSltChtrCrrCapaVO();
	            	  	
//	            	  	int srcBsaSeq =Integer.parseInt(bsaSeq) - 1;
//	  					쿼리상에서 -1 처리 함
//	            	  	paramVo3.setBsaSeq( String.valueOf(srcBsaSeq));
	            	  	
	            	  	paramVo2.setBsaSeq(bsaSeq);
	            	  	paramVo2.setTrdCd(trdCd);
	            	  	paramVo2.setRlaneCd(rlaneCd);
	            	  	paramVo2.setDirCd(dirCd);
	            	  	paramVo2.setVslSeq(vslSeq);
	            	  	paramVo2.setCreUsrId(creUsrId);
	            	  	paramVo2.setUpdUsrId(updUsrId);
	            	  	
	            	  	insertVoList5.add(paramVo2);
            	  }
            	//------------------------------------------------------------------	 
            	// 9. BSA의 HJS정보를 FNL_HJS_BSA_CAPA정보로 업데이트 한다.[I/U]
  				//------------------------------------------------------------------	  
            	  if(vos[i].getIbflag().equals("I")||vos[i].getIbflag().equals("U")) {	
	            	  	paramVo2 = new BsaSltChtrCrrCapaVO();
	            	  	
	            	  	paramVo2.setBsaOpCd(bsaOpCd);
	            	  	paramVo2.setBsaSeq(bsaSeq);
	            	  	paramVo2.setTrdCd(trdCd);
	            	  	paramVo2.setRlaneCd(rlaneCd);
	            	  	paramVo2.setDirCd(dirCd);
	            	  	paramVo2.setVslSeq(vslSeq);
	            	  	paramVo2.setCreUsrId(creUsrId);
	            	  	paramVo2.setUpdUsrId(updUsrId);
	            	  	
	            	  	muiltVoList4.add(paramVo2);
            	  }
            	  
            //------------------------------------------------------------------
            // 10. BSA정보가 변경되면 TTL Weight정보를 다시 계산한다.[21,24][I/U]
  			//------------------------------------------------------------------
            	  if(vos[i].getIbflag().equals("I")||vos[i].getIbflag().equals("U")) {	
	            	  	paramVo2 = new BsaSltChtrCrrCapaVO();
	            	  	
	            	  	paramVo2.setBsaOpCd(bsaOpCd);
	            	  	paramVo2.setBsaOpJbCd("007");
	            	  	paramVo2.setBsaSeq(bsaSeq);
	            	  	paramVo2.setTrdCd(trdCd);
	            	  	paramVo2.setRlaneCd(rlaneCd);
	            	  	paramVo2.setDirCd(dirCd);
	            	  	paramVo2.setVslSeq(vslSeq);
	            	  	paramVo2.setCreUsrId(creUsrId);
	            	  	paramVo2.setUpdUsrId(updUsrId);
	            	  	
	            	  	updateVoList2.add(paramVo2);
            	  }
	        //------------------------------------------------------------------
	        // 11. TTL Weight 가 변경되었으므로[I/U]
	    	//------------------------------------------------------------------
            	  if(vos[i].getIbflag().equals("I")||vos[i].getIbflag().equals("U")) {	
	            	  	paramVo2 = new BsaSltChtrCrrCapaVO();
	            	  	
	            	  	paramVo2.setBsaOpCd(bsaOpCd);
	            	  	paramVo2.setBsaSeq(bsaSeq);
	            	  	paramVo2.setTrdCd(trdCd);
	            	  	paramVo2.setRlaneCd(rlaneCd);
	            	  	paramVo2.setDirCd(dirCd);
	            	  	paramVo2.setVslSeq(vslSeq);
	            	  	paramVo2.setCreUsrId(creUsrId);
	            	  	paramVo2.setUpdUsrId(updUsrId);
	            	  	
	            	  	updateVoList4.add(paramVo2);
            	  }
             }			
		                
			// 1. BSA_JNT_OP_BZC 테이블의 데이터를 변경한다.(I/U)
			//----------------------------------------------------
		    //[DB 실행]
			 if (insertVoList.size() > 0){
				 dbDao.addMultiBsaSltChtrBzc(insertVoList);
			 }
			 if (updateVoList.size() > 0){
				 dbDao.modifyMultiBsaSltChtrBzc(updateVoList);
			 }
			 
			// 2. BSA_JNT_OP_CRR_CAPA 테이블의 데이터를 변경한다.(I/U)
			//----------------------------------------------------
		    //[DB 실행]
			 if (muiltVoList.size() > 0){
				dbDao.multiBsaSltChtrCrrCapa(muiltVoList);
			 }
						
			 // 3. 추가된 데이터에 대한 Capa추가(006~019)[I]
			 //----------------------------------------------------
		     //[DB 실행]
			 if (insertVoList3.size()> 0) {
				dbDao.addSpcScCrrCapa(insertVoList3);
			 }
				
			// 4. 추가된 데이터에 대한 Port 추가[I]
			//----------------------------------------------------
		    //[DB 실행]insertVoList4
			 if (insertVoList4.size()> 0) {
				dbDao.addSpcScPortDwn(insertVoList4);
			 }
			 
			 // 6. BSA[007]의 Carrier정보를 다시 계산한다.[I/U]
			 //------------------------------------------------------------------
		     //[DB 실행]
			 if (muiltVoList2.size()> 0) {
				dbDao.modifySpcScBsaCapa(muiltVoList2);
			 }

			
			 // 8. 이전 seq의 Weigth Per TEU, RF, D2, D4, D5, D7의 capa정보를 복제한다.[I]
			 //------------------------------------------------------------------
		     //[DB 실행]
			 if (insertVoList5.size()> 0) {
				dbDao.modifySpcScOthCapa(insertVoList5);
			 }

			 // 9. BSA의 HJS정보를 FNL_HJS_BSA_CAPA정보로 업데이트 한다.[I/U]
			 //------------------------------------------------------------------
			 //[DB 실행] 
			 if (muiltVoList4.size()> 0) {
				dbDao.modifySpcScHJSBsaCapa(muiltVoList4);
			 }

			 // 10. BSA정보가 변경되면 TTL Weight정보를 다시 계산한다.[21,24][I/U]
			 //------------------------------------------------------------------			
			 //[DB 실행]
			 if (updateVoList2.size()> 0) {			 
					dbDao.modifySpcScTTLWeight(updateVoList2);
			 }

			 // 11. TTL Weight 가 변경되었으므로[I/U]
			 //------------------------------------------------------------------
    		 //[DB 실행]
			 if (updateVoList4.size()> 0) {	
					dbDao.modifySpcScWeightPerTEU(updateVoList4);			        
			 }
				
				//############################################################################
	
				// 6. 신규/수정된 데이터에 대한 BSA(007)의 capa 정보를 계산한다
				// 7. 신규/수정된 데이터에 대한 BSA(007)의 swap 정보를 적용하여 capa정보를 재계산한다.
				// 8. 새로 추가된 Row에 이전 seq의 Weigth Per TEU, RF, D2, D4, D5, D7의 capa정보를 복제한다.
				// 9. 신규/수정된 데이터에 대한 TTL Weight(009)의 capa 정보를 계산하다.(BSA[007] * Weight Per TEU[008])
				//10. 신규/수정된 데이터에 대한 BSA(007) SML carrier 의 capa정보를 계산한다.
				//------------------------------------------------------------------
				//dbDao.modifyCoaBsaJntOpCrrCapa(event);		
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} 	
	}

	/**
	 * ESM_BSA_0021: 삭제 이벤트 처리<br>
	 * BSAManage화면에 대한 삭제 이벤트 처리<br>
	 * 
	 * @param BsaTableSaveVO[] vos
	 * @exception EventException
	 */
	public void removeBSATableJO(BsaTableSaveVO[] vos) throws EventException{
		try{
			BsaJntOpPortDwnVO   paramVo1 = null;
			BsaJntOpCrrCapaVO 	paramVo2 = null;
			BsaSpcCtrlSwapVO 	paramVo3 = null;
			BsaJntOpBzcVO 		paramVo4  = null;
			
			List<BsaJntOpPortDwnVO> deleteVoList1 = new ArrayList<BsaJntOpPortDwnVO>();  
			List<BsaJntOpCrrCapaVO> deleteVoList2 = new ArrayList<BsaJntOpCrrCapaVO>();  	
			List<BsaSpcCtrlSwapVO> 	deleteVoList3 = new ArrayList<BsaSpcCtrlSwapVO>();
			List<BsaJntOpBzcVO> 	deleteVoList4 = new ArrayList<BsaJntOpBzcVO>();  
			
			 for(int i = 0 ; i < vos.length ; i++){
				 if(vos[i].getIbflag().equals("D")) {
					 String bsaSeq 	= vos[i].getBsaseq();
					 String trdCd  	= vos[i].getTrdcd();
					 String rlaneCd = vos[i].getRlanecd();
					 String dirCd	= vos[i].getDircd();
					 String vopCd	= vos[i].getVopcd();
					 String vslCapa	= vos[i].getVslcapa();
					 
					 paramVo1 =  new BsaJntOpPortDwnVO();
					 paramVo1.setBsaSeq(bsaSeq);
					 paramVo1.setTrdCd(trdCd);
					 paramVo1.setRlaneCd(rlaneCd);
					 paramVo1.setDirCd(dirCd);
					 paramVo1.setVopCd(vopCd);
					 paramVo1.setVslCapa(vslCapa);
					 
					 deleteVoList1.add(paramVo1);
					 
					 paramVo2 =  new BsaJntOpCrrCapaVO();
					 paramVo2.setBsaSeq(bsaSeq);
					 paramVo2.setTrdCd(trdCd);
					 paramVo2.setRlaneCd(rlaneCd);
					 paramVo2.setDirCd(dirCd);
					 paramVo2.setVopCd(vopCd);
					 paramVo2.setVslCapa(vslCapa);
					 
					 deleteVoList2.add(paramVo2);
					 
					 paramVo3 =  new BsaSpcCtrlSwapVO();
					 paramVo3.setBsaSeq(bsaSeq);
					 paramVo3.setTrdCd(trdCd);
					 paramVo3.setRlaneCd(rlaneCd);
					 paramVo3.setDirCd(dirCd);
					 paramVo3.setVopCd(vopCd);
					 paramVo3.setVslCapa(vslCapa);
					 
					 deleteVoList3.add(paramVo3);
					 
					 paramVo4 =  new BsaJntOpBzcVO();
					 paramVo4.setBsaSeq(bsaSeq);
					 paramVo4.setTrdCd(trdCd);
					 paramVo4.setRlaneCd(rlaneCd);
					 paramVo4.setDirCd(dirCd);
					 paramVo4.setVopCd(vopCd);
					 paramVo4.setVslCapa(vslCapa);
					 
					 deleteVoList4.add(paramVo4);
				 }
			 }
			 if (deleteVoList1.size()> 0) {
				 dbDao.removeBSATableJO1(deleteVoList1);
			 }
			 if (deleteVoList2.size()> 0) {
				 dbDao.removeBSATableJO2(deleteVoList2);
			 }
			 if (deleteVoList3.size()> 0) {
				 dbDao.removeBSATableJO3(deleteVoList3);
			 }
			 if (deleteVoList4.size()> 0) {
				 dbDao.removeBSATableJO4(deleteVoList4);
			 }
            
	} catch (DAOException ex) {
		//log.error("err " + ex.toString(), ex);
		throw new EventException(ex.getMessage(),ex);
	} catch (Exception ex) {
		//log.error("err " + ex.toString(), ex);
		throw new EventException(ex.getMessage(),ex);
	} 	
}

	/**
	 * ESM_BSA_0021: 삭제 이벤트 처리<br>
	 * BSAManage화면에 대한 삭제 이벤트 처리<br>
	 * 
	 * @param BsaTableSaveVO[] vos
	 * @exception EventException
	 */
	public void removeBSATableSC(BsaTableSaveVO[] vos) throws EventException{
		try{
			BsaSltChtrPortDwnVO   	paramVo1 = null;
			BsaSltChtrCrrCapaVO 	paramVo2 = null;
			BsaSltChtrBzcVO 		paramVo3  = null;
			
			List<BsaSltChtrPortDwnVO> deleteVoList1 = new ArrayList<BsaSltChtrPortDwnVO>();  
			List<BsaSltChtrCrrCapaVO> deleteVoList2 = new ArrayList<BsaSltChtrCrrCapaVO>();  	
			List<BsaSltChtrBzcVO> 	  deleteVoList3 = new ArrayList<BsaSltChtrBzcVO>();  
			
			 for(int i = 0 ; i < vos.length ; i++){
				 if(vos[i].getIbflag().equals("D")) {
					 String bsaSeq 	= vos[i].getBsaseq();
					 String trdCd  	= vos[i].getTrdcd();
					 String rlaneCd = vos[i].getRlanecd();
					 String dirCd	= vos[i].getDircd();
					 String vslSeq	= vos[i].getVslseq();
					 
					 paramVo1 =  new BsaSltChtrPortDwnVO();
					 paramVo1.setBsaSeq(bsaSeq);
					 paramVo1.setTrdCd(trdCd);
					 paramVo1.setRlaneCd(rlaneCd);
					 paramVo1.setDirCd(dirCd);
					 paramVo1.setVslSeq(vslSeq);
					 
					 deleteVoList1.add(paramVo1);
					 
					 paramVo2 =  new BsaSltChtrCrrCapaVO();
					 paramVo2.setBsaSeq(bsaSeq);
					 paramVo2.setTrdCd(trdCd);
					 paramVo2.setRlaneCd(rlaneCd);
					 paramVo2.setDirCd(dirCd);
					 paramVo2.setVslSeq(vslSeq);
					 
					 deleteVoList2.add(paramVo2);
					 
					 paramVo3 =  new BsaSltChtrBzcVO();
					 paramVo3.setBsaSeq(bsaSeq);
					 paramVo3.setTrdCd(trdCd);
					 paramVo3.setRlaneCd(rlaneCd);
					 paramVo3.setDirCd(dirCd);
					 paramVo3.setVslSeq(vslSeq);
					 
					 deleteVoList3.add(paramVo3);
					 
				 }
			 }
			 if (deleteVoList1.size()> 0) {
				 dbDao.removeBSATableSC1(deleteVoList1);
			 }
			 if (deleteVoList2.size()> 0) {
				 dbDao.removeBSATableSC2(deleteVoList2);
			 }
			 if (deleteVoList3.size()> 0) {
				 dbDao.removeBSATableSC3(deleteVoList3);
			 }
            
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} 	
	}

	/**
	 * ESM_BSA_0021: 생성시 정보를 조회 함.<br>
	 * BSAManage화면에 생성시 정보를 조회 함<br>
	 * 
	 * @param SearchBsaConditionVO vo
	 * @param SignOnUserAccount account
	 * @return CreateBSAVO
	 * @exception EventException
	 */
	public CreateBSAVO createBSA(SearchBsaConditionVO vo, SignOnUserAccount account) throws EventException{
		log.debug("################# BSAManageBCImpl.createBSA() ############################[START]");
		try{
			CreateBSAVO retSaveVo = new CreateBSAVO();
			CreateBSAVO creVo = new CreateBSAVO();
			
			vo.setTxtsdate( vo.getTxtsdate().replaceAll("-",""));
			vo.setTxtedate( vo.getTxtedate().replaceAll("-",""));
			
			String strOption = "JO";
			if (vo.getRdoopcd().equals("J")) {
				strOption = "JO";
			} else if (vo.getRdoopcd().equals("S")) {
				strOption = "SC";
			}
			
			DBRowSet dbRowset = dbDao.searchCreateBSAInfo(vo);	
				
//				int rowCnt = dbRowset.getRowCount();
				while(dbRowset.next()){
					
					creVo.setPFmYrwk(dbRowset.getString("fm_yrwk"));
					creVo.setPToYrwk(dbRowset.getString("to_yrwk"));
					creVo.setPInd(strOption);
					creVo.setPTrdCd(vo.getCobtrade());
					creVo.setPRlaneCd(vo.getCoblane());
					creVo.setPDirCd(vo.getCobdir());
					creVo.setPUserId(account.getUsr_id());
										
			        //[DB 실행]
					retSaveVo = dbDao.createBSA(creVo);					
				}	
			log.debug("################# BSAManageBCImpl.createBSA() ############################[END]");
			return retSaveVo;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}		
		
	}	
	
	/**
	 * ESM_BSA_0035: 조회 이벤트 처리 (JOINT OPERATING)<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO vo
	 * @return List<SearchOverlappedContractCheckListVO>
	 * @exception EventException
	 */	
	public List<SearchOverlappedContractInquiryListVO> searchOverlappedContractInquiryJOList(SearchBsaConditionVO vo) throws EventException {
		log.debug("################# BSAManageBCImpl.searchOverlappedContractInquiryJOList() ############################[START]");
		try {
			
			return dbDao.searchOverlappedContractInquiryJOList(vo);
				
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}		
	}		

	/**
	 * ESM_BSA_0035: 조회 이벤트 처리 (SPACE CHARTERING)<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO vo
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */	
	public List<SearchOverlappedContractInquiryListVO> searchOverlappedContractInquirySCList(SearchBsaConditionVO vo) throws EventException {
		log.debug("################# BSAManageBCImpl.searchOverlappedContractInquirySCList() ############################[START]");
		try {
			
			return dbDao.searchOverlappedContractInquirySCList(vo);
				
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}		
	}	
	
	/**
	 * ESM_BSA_0035: 조회 이벤트 처리 (SLOT PRICE)<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO vo
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */	
	public List<SearchOverlappedContractInquiryListVO> searchOverlappedContractInquirySPList(SearchBsaConditionVO vo) throws EventException {
		log.debug("################# BSAManageBCImpl.searchOverlappedContractInquirySPList() ############################[START]");
		try {
			
			return dbDao.searchOverlappedContractInquirySPList(vo);
				
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}		
	}

	/**
	 * ESM_BSA_0023: 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String bsaOpCd
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchCarrierRegisterList(String bsaOpCd) throws EventException {
		log.debug("################# BSAManageBCImpl.searchCarrierRegisterList() ############################[START]");
		try {
			CommonBsaRsVO[] rVoArray = new CommonBsaRsVO[3];
			CommonBsaRsVO rsVo = new CommonBsaRsVO();
				
				rVoArray[0] = new CommonBsaRsVO();
				rVoArray[0] = dbDao.searchCarrierRegisterHeaderList();

				rVoArray[1] = new CommonBsaRsVO();
				rVoArray[1] = dbDao.searchCarrierRegisterMasterList(bsaOpCd);
				
				rVoArray[2] = new CommonBsaRsVO();
				rVoArray[2] = dbDao.searchCarrierRegisterDetailList(bsaOpCd);				
				
				rsVo.setCommonBsaRsVOArray(rVoArray);
				
			log.debug("################# BSAManageBCImpl.searchCarrierRegisterList() ############################[END]");
			return rsVo;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}		
	}	

	/**
	 * ESM_BSA_0023: 수정 이벤트 처리<br>
	 * BSAManage화면에 대한 수정 이벤트 처리<br>
	 * 
	 * @param BsaAddCarrierSaveVO[] vos
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String modifyCarrierRegister(BsaAddCarrierSaveVO[] vos, SignOnUserAccount account) throws EventException{
		BSAManageCarrierBackEndJob backEndJob = new BSAManageCarrierBackEndJob();		
		List<BsaAddCarrierSaveVO> updateVoList  = new ArrayList<BsaAddCarrierSaveVO>();	
		
        for(int i = 0 ; i < vos.length ; i++){
            if(vos[i].getIbflag().equals("U")) {            	
            	vos[i].setCreUsrId(account.getUsr_id());
            	vos[i].setUpdUsrId(account.getUsr_id());            	
            	updateVoList.add(vos[i]);                      	
            }
        }	
        
		backEndJob.setBsaAddCarrierVO(updateVoList);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "BSA Creation/Update - Add Carrier");		
        } catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
    }
	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchBackEndJobStatus(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}
			
	/**
	 * ESM_BSA_0026: 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO vo
	 * @return List<SearchSpcJoPortDownMasterListVO>
	 * @exception EventException
	 */
	public List<SearchSpcJoPortDownMasterListVO> searchSpcJoPortDownMasterList(SearchBsaConditionVO vo) throws EventException {
		log.debug("################# BSAManageBCImpl.searchSpcJoPortDownMasterList() [Jo]############################[START]");
		try {
			List<SearchSpcJoPortDownMasterListVO> list = null ;
			
		        vo.setTxtsdate	(vo.getTxtsdate().replaceAll("-",""));
		                 				
				list = dbDao.searchSpcJoPortDownMasterList(vo);
				log.debug("################# BSAManageBCImpl.searchSpcJoPortDownMasterList() [Jo]############################[END]");
			return list;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}	

	/**
	 * ESM_BSA_026: 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO vo
	 * @return List<SearchSpcJoPortDownDetailListVO>
	 * @exception EventException
	 */
	public List<SearchSpcJoPortDownDetailListVO> searchSpcJoPortDownDetailList(SearchBsaConditionVO vo) throws EventException {
		log.debug("################# BSAManageBCImpl.searchSpcScPortDownDetailList() [Jo]############################[START]");
		try {
			List<SearchSpcJoPortDownDetailListVO> list = null;
			list = dbDao.searchSpcJoPortDownDetailList(vo);
			log.debug("################# BSAManageBCImpl.searchSpcScPortDownDetailList() [Jo]############################[END]");
			return list;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}		

	/**
	 * ESM_BSA_0026: 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO vo
	 * @return List<SearchSpcScPortDownMasterListVO>
	 * @exception EventException
	 */
	public List<SearchSpcScPortDownMasterListVO> searchSpcScPortDownMasterList(SearchBsaConditionVO vo) throws EventException {
		try {
			List<SearchSpcScPortDownMasterListVO> list = null;
			 vo.setTxtsdate	(vo.getTxtsdate().replaceAll("-",""));
				
				list = dbDao.searchSpcScPortDownMasterList(vo);
			return list;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}	
		

	/**
	 * ESM_BSA_0026: 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO vo
	 * @return List<SearchSpcScPortDownDetailListVO>
	 * @exception EventException
	 */
	public List<SearchSpcScPortDownDetailListVO> searchSpcScPortDownDetailList(SearchBsaConditionVO vo) throws EventException {
		log.debug("################# BSAManageBCImpl.searchSpcScPortDownDetailList() [SC]############################[START]");
		try {
			List<SearchSpcScPortDownDetailListVO> list = null;
				
				list = dbDao.searchSpcScPortDownDetailList(vo);
			log.debug("################# BSAManageBCImpl.searchSpcScPortDownDetailList() [SC] ############################[END]");
			return list;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}		

	/**
	 * ESM_BSA_0026: RESET 이벤트 처리<br>
	 * BSAManage화면에 대한 RESET 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void resetSpcJoPortDown( SearchBsaConditionVO vo, SignOnUserAccount account) throws EventException{
		try {
			String updUsrId = account.getUsr_id();
			
			// 1. BSA_SLT_CHTR_BZC 테이블의 데이터를 변경한다.(I/U)
			//----------------------------------------------------
				dbDao.resetSpcJoPortDown(vo,updUsrId);
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
		

	/**
	 * ESM_BSA_0026: 생성 이벤트 처리<br>
	 * BSAManage화면에 대한 생성 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createSpcJoPortDown(SearchBsaConditionVO vo, SignOnUserAccount account) throws EventException{
		log.debug("################# BSAManageBCImpl.createSpcJoPortDown() ############################[START]");
		try{
			String usrId = account.getUsr_id();
				//[DB 실행]
				dbDao.removeSpcJoPortDownDetail(vo);
				//############################################################################
	
                //[DB 실행]
                dbDao.createSpcJoPortDownDetail(vo,usrId);
                //############################################################################

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}              
	}	

	/**
	 * ESM_BSA_0026: 멀티 이벤트 처리<br>
	 * BSAManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param BsaJntOpCrrCapaVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSPCDownPortJOMaster(BsaJntOpCrrCapaVO[] vos, SignOnUserAccount account) throws EventException{
		try{

				List<BsaJntOpCrrCapaVO> updateVoList = new ArrayList<BsaJntOpCrrCapaVO>();
		                
				// 1. BSA_SLT_CHTR_BZC 테이블의 데이터를 변경한다.(I/U)
				//----------------------------------------------------
                    for(int i = 0 ; i < vos.length ; i++){
                        if(vos[i].getIbflag().equals("U")) {
                        	vos[i].setUpdUsrId(account.getUsr_id());
                        	updateVoList.add(vos[i]);                      	
                        }
                    }	
				//[DB 실행]
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyJOCrrCapa(updateVoList);
				}
				//############################################################################
				
			} catch (DAOException ex) {
				//log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage(),ex);
			} catch (Exception ex) {
				//log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage(),ex);
			}          
	}		

	/**
	 * ESM_BSA_0026: 멀티 이벤트 처리<br>
	 * BSAManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param BsaJntOpPortDwnVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSPCDownPortJODetail(BsaJntOpPortDwnVO[] vos, SignOnUserAccount account) throws EventException{
		try{	
				String creUsrId = account.getUsr_id();
				String updUsrId	= account.getUsr_id();
				List<BsaJntOpPortDwnVO> insertVoList 	 = new ArrayList<BsaJntOpPortDwnVO>();
				List<BsaJntOpPortDwnVO> updateVoList 	 = new ArrayList<BsaJntOpPortDwnVO>();
				List<BsaJntOpPortDwnVO> deleteVoList     = new ArrayList<BsaJntOpPortDwnVO>();	     

				// 1. BSA_SLT_CHTR_BZC 테이블의 데이터를 변경한다.(I/U)
				//----------------------------------------------------                
                for(int i = 0 ; i < vos.length ; i++){
                    if(vos[i].getIbflag().equals("I")) {
                        vos[i].setCreUsrId(creUsrId);
                        vos[i].setUpdUsrId(updUsrId);                        
                    	
                        insertVoList.add( vos[i]);                        
                    }
                    else if(vos[i].getIbflag().equals("U")) {
                    	 vos[i].setUpdUsrId(updUsrId);                         	
                    	
                    	 updateVoList.add(vos[i]);
                    }
                    else if(vos[i].getIbflag().equals("D")) {
                    	deleteVoList.add(vos[i]);
                    }                        
                }
              //[DB 실행]
                if ( insertVoList.size() > 0 ) {
					dbDao.addMultiBsaJntOpPortDwn(insertVoList);
				}
                if ( updateVoList.size() > 0 ) {
					dbDao.modifyMultiBsaJntOpPortDwn(updateVoList);
				}
				if ( deleteVoList.size() > 0 ) {
					dbDao.removeMultiBsaJntOpPortDwn(deleteVoList);
				}
				//############################################################################
            
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}           
	}		

	/**
	 * ESM_BSA_0026: RESET 이벤트 처리<br>
	 * BSAManage화면에 대한 RESET 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void resetSpcScPortDown(SearchBsaConditionVO vo, SignOnUserAccount account) throws EventException{
		try{
			String updUsrId = account.getUsr_id();
				//[DB 실행]
				dbDao.resetSpcScPortDown(vo,updUsrId);
				//############################################################################				
            
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}              
	}	

	/**
	 * ESM_BSA_026: 생성 이벤트 처리<br>
	 * BSAManage화면에 대한 생성 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createSpcScPortDown(SearchBsaConditionVO vo, SignOnUserAccount account) throws EventException{
		try{
			String usrId = account.getUsr_id();  			
				//[DB 실행]
				dbDao.removeSpcScPortDownDetail(vo);
				//############################################################################
                //[DB 실행]
                dbDao.createSpcScPortDownDetail(vo,usrId);
                //############################################################################

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}                       
	}	

	/**
	 * ESM_BSA_0026: 멀티 이벤트 처리<br>
	 * BSAManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param BsaSltChtrCrrCapaVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSPCDownPortSCMaster(BsaSltChtrCrrCapaVO[] vos, SignOnUserAccount account) throws EventException{
		try{
				
				List<BsaSltChtrCrrCapaVO> updateVoList = new ArrayList<BsaSltChtrCrrCapaVO>();     

				// 1. BSA_SLT_CHTR_BZC 테이블의 데이터를 변경한다.(I/U)
				//----------------------------------------------------
                
				 for(int i = 0 ; i < vos.length ; i++){
                     if(vos[i].getIbflag().equals("U")) {
                     	vos[i].setUpdUsrId(account.getUsr_id());
                     	updateVoList.add(vos[i]);                      	
                     }
                 }		
				
				//[DB 실행]
				dbDao.modifySCCrrCapa(updateVoList);
				//############################################################################
            
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}               
	}	

	/**
	 * ESM_BSA_0026: 멀티 이벤트 처리<br>
	 * BSAManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param BsaSltChtrPortDwnVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSPCDownPortSCDetail(BsaSltChtrPortDwnVO[] vos, SignOnUserAccount account) throws EventException{
		try{
			String creUsrId = account.getUsr_id();
			String updUsrId	= account.getUsr_id();
			List<BsaSltChtrPortDwnVO> insertVoList 	 = new ArrayList<BsaSltChtrPortDwnVO>();
			List<BsaSltChtrPortDwnVO> updateVoList 	 = new ArrayList<BsaSltChtrPortDwnVO>();
			List<BsaSltChtrPortDwnVO> deleteVoList     = new ArrayList<BsaSltChtrPortDwnVO>();	     
	
			// 1. BSA_SLT_CHTR_BZC 테이블의 데이터를 변경한다.(I/U)
			//----------------------------------------------------                
	        for(int i = 0 ; i < vos.length ; i++){
	            if(vos[i].getIbflag().equals("I")) {
	                vos[i].setCreUsrId(creUsrId);
	                vos[i].setUpdUsrId(updUsrId);                        
	            	
	                insertVoList.add( vos[i]);                        
	            }
	            else if(vos[i].getIbflag().equals("U")) {
	            	 vos[i].setUpdUsrId(updUsrId);                         	
	            	
	            	 updateVoList.add(vos[i]);
	            }
	            else if(vos[i].getIbflag().equals("D")) {
	            	deleteVoList.add(vos[i]);
	            }                        
	        }
	      //[DB 실행]
	        if ( insertVoList.size() > 0 ) {
				dbDao.addMultiBsaSltChtrPortDwn(insertVoList);
			}
	        if ( updateVoList.size() > 0 ) {
				dbDao.modifyMultiBsaSltChtrPortDwn(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeMultiBsaSltChtrPortDwn(deleteVoList);
			} 
			//############################################################################
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} 	
	}
				

	/**
	 * 1. 기능 : BSAManage Slot-info for SPC Control JO화면의 Carrier목록을 조회 (ESM_BSA_0024)<p>
	 * 2. 처리개요 : <p>
	 *    - Carrier목록을 조회
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.10.24<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param String bsaOpCd
	 * @return String
	 * @exception EventException
	 */

	public String searchCarrierItem(String bsaOpCd) throws EventException {
		log.debug("################# BSAManageBCImpl.searchCarrierItem() ############################[START]");
		StringBuffer strItem = new StringBuffer();
		try {
			List<BsaCrrRgstVO> list = dbDao.searchCarrierItem(bsaOpCd);
			
			int listCnt = list.size();
			
			for(int i=0; i<listCnt; i++){
				BsaCrrRgstVO retVo = (BsaCrrRgstVO)list.get(i);
				strItem.append(retVo.getCrrCd());
				if (listCnt - 1 > i){
					strItem.append("|");
				}
			}
				
			log.debug("Carrier Item : " + strItem.toString());
			log.debug("################# BSAManageBCImpl.searchCarrierItem() ############################[END]");
			return strItem.toString();				
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}		
	}
	

	/**
	 * 1. 기능 : BSAManage Slot-info for SPC Control JO화면에 대한 조회 이벤트 처리(ESM_BSA_0024)<p>
	 * 2. 처리개요 : <p>
	 *    - BSAManage Slot-info for SPC Control JO에 대한 리스트를 조회
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.10.24<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param SearchBsaConditionVO vo
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchSPCJOBSA(SearchBsaConditionVO vo) throws EventException {
		String bsaOpCd="";
		String[] codeArr = null;
		try {
			CommonBsaRsVO retVo = new CommonBsaRsVO();
			if(vo.getRdoopcd() == null || vo.getRdoopcd().trim().equals("")){
				bsaOpCd = "J";
			}
			else{
				bsaOpCd=vo.getRdoopcd();
			}

			String strItem = searchCarrierItem(bsaOpCd);

			log.debug("strItem = " + strItem);
			//vo.setHeader(strItem);
			
			if( strItem != null && !strItem.equals("")){
				codeArr = strItem.split("[|]");				
			}		
			
			vo.setTxtedate(vo.getTxtedate().replaceAll("-", ""));
			vo.setTxtsdate(vo.getTxtsdate().replaceAll("-", ""));

			if (codeArr != null){
			retVo = dbDao.searchSpcJoBSA(vo,codeArr);
			}

			return retVo;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}		

	/**
	 * 1. 기능 : BSAManage Slot-info for SPC Control JO화면에 대한 멀티 이벤트 처리(ESM_BSA_0024)<p>
	 * 2. 처리개요 : <p>
	 *    - BSAManage Slot-info for SPC Control JO에 대한 리스트를 조회
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.10.24<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param BsaSlotInfoForSpcCntrSaveVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSPCJOBSA(BsaSlotInfoForSpcCntrSaveVO[] vos, SignOnUserAccount account) throws EventException{
		try{
			
//			String creUsrId	= account.getUsr_id();
			String updUsrId	= account.getUsr_id();
			String bsaOpJbCd ="";
			String bsaOpCd	 ="";
			
			List<BsaJntOpCrrCapaVO> updateList = new ArrayList<BsaJntOpCrrCapaVO>();
			List<BsaJntOpCrrCapaVO> updateList1 = new ArrayList<BsaJntOpCrrCapaVO>();
			List<BsaJntOpCrrCapaVO> updateList2 = new ArrayList<BsaJntOpCrrCapaVO>();
			List<BsaJntOpBzcVO> updateList3 = new ArrayList<BsaJntOpBzcVO>();
			List<BsaJntOpCrrCapaVO> updateList4 = new ArrayList<BsaJntOpCrrCapaVO>();
			List<BsaJntOpPortDwnVO> updateList5 = new ArrayList<BsaJntOpPortDwnVO>();
			
			for ( int i=0; i<vos .length; i++ ) {
				bsaOpJbCd= vos[i].getRdoopjbcd();
				bsaOpCd	= vos[i].getRdoopcd();
				
//				String ibflag 	= vos[i].getIbflag();
				String bsaSeq 	= vos[i].getBsaSeq();
				String trdCd  	= vos[i].getTrdCd();
				String rlaneCd	= vos[i].getRlaneCd();
				String dirCd	= vos[i].getDirCd();
				String vslCapa	= vos[i].getVslCapa();
				String vopCd	= vos[i].getVopCd();
				String ownrVslWgt = vos[i].getOwnrVslWgt();
				String fnlHjsBsaCapa=vos[i].getFnlHjsBsaCapa();
//				String vvdCd	= vos[i].getVvdCd();
				
				String crrCdTmp = vos[i].getJheader() + "|SML";
				String spcCtrlSltCapaTmp = vos[i].getHeaderCapa()+fnlHjsBsaCapa;
				String[] crrCd	= crrCdTmp.split("[|]");
				String[] spcCtrlSltCapa = spcCtrlSltCapaTmp.split("[|]");
				
				//0. multiSpcJoBSA 
				for (int j = 0; j < crrCd.length; j++) {
					BsaJntOpCrrCapaVO paramVo = new BsaJntOpCrrCapaVO();
					
					paramVo.setBsaSeq(bsaSeq);
					paramVo.setTrdCd(trdCd);
					paramVo.setRlaneCd(rlaneCd);
					paramVo.setDirCd(dirCd);
					paramVo.setVslCapa(vslCapa);
					paramVo.setVopCd(vopCd);
					paramVo.setBsaOpCd(bsaOpCd);
					paramVo.setBsaOpJbCd(bsaOpJbCd);
					paramVo.setCrrCd(crrCd[j]);
					paramVo.setSpcCtrlSltCapa(spcCtrlSltCapa[j]);
					paramVo.setUpdUsrId(updUsrId);
					
					updateList.add(paramVo);
				}
				
				// 1. BSA, Weight Per TEU가 변경되었을때 TTL Weight의 값도 변경시켜준다.
				//    - 전체 Carrier값을 업데이트한다
				//    - BSA_JNT_OP_BZC 테이블의 ownr_vsl_wgt값이 0보다 크면
				//      HJS값을 업데이트한다.(OWNR_VSL_WGT-SUM(CARRIERS[HJS제외]))
				//--------------------------------------------------------------
				if(bsaOpJbCd.equals("007")||bsaOpJbCd.equals("008")){
					BsaJntOpCrrCapaVO paramVo = new BsaJntOpCrrCapaVO();
					
					paramVo.setBsaSeq(bsaSeq);
					paramVo.setTrdCd(trdCd);
					paramVo.setRlaneCd(rlaneCd);
					paramVo.setDirCd(dirCd);
					paramVo.setVslCapa(vslCapa);
					paramVo.setVopCd(vopCd);
					paramVo.setBsaOpCd(bsaOpCd);
					paramVo.setBsaOpJbCd(bsaOpJbCd);
					paramVo.setUpdUsrId(updUsrId);
					
					updateList1.add(paramVo);
					
					if(Double.parseDouble(ownrVslWgt) > 0){
						updateList2.add(paramVo);
					}
				}
				// 2. BSA_JNT_OP_BZC 테이블의 Own Vessel Weight값을  변경시켜준다.
				//--------------------------------------------------------------
				if(bsaOpJbCd.equals("009")){
					BsaJntOpBzcVO paramVo2 = new BsaJntOpBzcVO();
					
					paramVo2.setBsaSeq(bsaSeq);
					paramVo2.setTrdCd(trdCd);
					paramVo2.setRlaneCd(rlaneCd);
					paramVo2.setDirCd(dirCd);
					paramVo2.setVslCapa(vslCapa);
					paramVo2.setVopCd(vopCd);
					paramVo2.setOwnrVslWgt(ownrVslWgt);
					paramVo2.setUpdUsrId(updUsrId);
					
					updateList3.add(paramVo2);
				}
				// 3. BSA, TTL Weight가 변경되었을때 Weight Per TEU의 값을 변경시켜준다.
				//--------------------------------------------------------------
				if(bsaOpJbCd.equals("007") || bsaOpJbCd.equals("009")){
					BsaJntOpCrrCapaVO paramVo = new BsaJntOpCrrCapaVO();
					
					paramVo.setBsaSeq(bsaSeq);
					paramVo.setTrdCd(trdCd);
					paramVo.setRlaneCd(rlaneCd);
					paramVo.setDirCd(dirCd);
					paramVo.setVslCapa(vslCapa);
					paramVo.setVopCd(vopCd);
					paramVo.setBsaOpCd(bsaOpCd);
					paramVo.setUpdUsrId(updUsrId);
					
					updateList4.add(paramVo);
				}
				
				// 4. BSA가 변경되었을때 COA_BSA_JNT_OP_PORT_DWN의 값도 변경시켜준다.
				//--------------------------------------------------------------
				if(bsaOpJbCd.equals("007")){
					BsaJntOpPortDwnVO paramVo3 = new BsaJntOpPortDwnVO();
					
					paramVo3.setBsaSeq(bsaSeq);
					paramVo3.setTrdCd(trdCd);
					paramVo3.setRlaneCd(rlaneCd);
					paramVo3.setDirCd(dirCd);
					paramVo3.setVslCapa(vslCapa);
					paramVo3.setVopCd(vopCd);
					paramVo3.setBsaOpCd(bsaOpCd);
					paramVo3.setBsaOpJbCd(bsaOpJbCd);
					paramVo3.setUpdUsrId(updUsrId);
					
					updateList5.add(paramVo3);
				}
			}
			
			if ( updateList.size() > 0 ) {
				dbDao.multiSpcJoBSA(updateList, bsaOpJbCd);
			}
			
			if ( updateList1.size() > 0 ) {
				dbDao.modifySpcJoTTLWeight1(updateList1);
			}
			
			if ( updateList2.size() > 0 ) {
				dbDao.modifySpcJoTTLWeight2(updateList2);
			}
			
			if ( updateList3.size() > 0 ) {
				dbDao.modifySpcJoOwnVslWeight(updateList3);
			}
			
			if ( updateList4.size() > 0 ) {
				dbDao.modifySpcJoWeightPerTEU(updateList4);
			}
			
			if ( updateList5.size() > 0 ) {
				dbDao.modifySpcJoPortDwn(updateList5);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}		

	/**
	 * 1. 기능 : BSAManage Slot-info for SPC Control JO PopUp화면에 대한 조회 이벤트 처리(ESM_BSA_0024)<p>
	 * 2. 처리개요 : <p>
	 *    - BSAManage Slot-info for SPC Control JO에 대한 리스트를 조회
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.10.31<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param SearchBsaConditionVO VO
	 * @return List<SearchChgSlotSwapListVO>
	 * @exception EventException
	 */
	public List<SearchChgSlotSwapListVO> searchChgSlotSwapList(SearchBsaConditionVO VO) throws EventException {
		try {
			return dbDao.searchChgSlotSwapList(VO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 1. 기능 : BSAManage Slot-info for SPC Control JO PopUp 화면에 대한 멀티 이벤트 처리(ESM_BSA_024)<p>
	 * 2. 처리개요 : <p>
	 *    - BSAManage Slot-info for SPC Control JO에 대한 리스트를 조회
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.10.31<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param BsaSpcCtrlSwapVO[] VOs
	 * @param SearchBsaConditionVO VO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiChgSlotSwap(BsaSpcCtrlSwapVO[] VOs,SearchBsaConditionVO VO, SignOnUserAccount account) throws EventException{
		try{
			List<BsaSpcCtrlSwapVO> insertVoList = new ArrayList<BsaSpcCtrlSwapVO>();
			List<BsaSpcCtrlSwapVO> updateVoList = new ArrayList<BsaSpcCtrlSwapVO>();
			List<BsaSpcCtrlSwapVO> deleteVoList = new ArrayList<BsaSpcCtrlSwapVO>();// Insert/update시 Delete용
//			List<BsaSpcCtrlSwapVO> deleteVoList2 = new ArrayList<BsaSpcCtrlSwapVO>();// Delete시 Delete용
			List<BsaJntOpCrrCapaVO> updateVoList2 = new ArrayList<BsaJntOpCrrCapaVO>();
			
			BsaJntOpCrrCapaVO crrVo = new BsaJntOpCrrCapaVO();
						
			String trdCd = VO.getPtrdcd();
			String laneCd = VO.getPrlanecd();
			String dirCd = VO.getPdircd();
			String bsaSeq = VO.getPbsaseq();
			String vopCd = VO.getPvopcd();
			String vslCapa = VO.getPvslcapa();
			String bsaOpJbCd = VO.getPbsaopjbcd();
			String bsaOpCd = VO.getPbsaopcd();
//			String bsa_fm_dt = VO.getPbsafmdt();
//			String bsa_to_dt = VO.getPbsatodt(); 
			
			crrVo.setBsaSeq(bsaSeq);
			crrVo.setTrdCd(trdCd);
			crrVo.setRlaneCd(laneCd);
			crrVo.setDirCd(dirCd);
			crrVo.setVopCd(vopCd);
			crrVo.setVslCapa(vslCapa);
			crrVo.setBsaOpCd(bsaOpCd);
			crrVo.setBsaOpJbCd(bsaOpJbCd);
			crrVo.setUpdUsrId(account.getUsr_id());
			
			
			
			if(VOs.length > 0){
				updateVoList2.add(crrVo);
				 for(int i = 0 ; i < VOs.length ; i++){
						VOs[i].setBsaSeq(bsaSeq);
						VOs[i].setTrdCd(trdCd);
						VOs[i].setRlaneCd(laneCd);
						VOs[i].setDirCd(dirCd);
						VOs[i].setVopCd(vopCd);
						VOs[i].setVslCapa(vslCapa);
						VOs[i].setBsaOpCd(bsaOpCd);
						VOs[i].setBsaOpJbCd(bsaOpJbCd);
						VOs[i].setCreUsrId(account.getUsr_id());
						VOs[i].setUpdUsrId(account.getUsr_id());
					if(VOs[i].getIbflag().equals("I")||VOs[i].getIbflag().equals("U")){					
						insertVoList.add(VOs[i]);
					} else if (VOs[i].getIbflag().equals("D")){
						deleteVoList.add(VOs[i]);
					}
					if (i==0){
						updateVoList.add(VOs[i]);				
						log.debug("Delete Data : ["+bsaSeq+"]["+trdCd+"]["+laneCd+"]["+dirCd+"]["+vopCd+"]["+vslCapa+"]["+bsaOpCd+"]["+bsaOpJbCd+"]");
					}
				 }
			}

			// 1.BSA_JNT_OP_BZC 테이블의 데이터를 변경한다.(I/U)
			//----------------------------------------------------
			if ( insertVoList.size() > 0 ) {
				dbDao.removemultiChgSlotSwap(insertVoList);
				dbDao.addmultiChgSlotSwap(insertVoList);
				log.debug( "multiChgSlotSwap-01");
			}
			
			// 1.BSA_JNT_OP_BZC 테이블의 데이터를 변경한다.(I/U)
			//----------------------------------------------------
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiChgSlotSwap(deleteVoList);
				log.debug( "multiChgSlotSwap-01");
			}
			
			if (deleteVoList.size() > 0 ||insertVoList.size() > 0 ){
				dbDao.modifyemultiChgSlotSwap(updateVoList);
			}
		        
			// 2. Solt Swap정보를 가지고 BSA_JNT_OP_CRR_CAPA 테이블의  
			//    spc_ctrl_slt_capa을 변경한다.
			//----------------------------------------------
			if ( insertVoList.size() > 0 || deleteVoList.size() >0 ) {
				dbDao.modifySpcJoSwapCapa(updateVoList2);
				dbDao.modifySpcJoTTLWeight1(updateVoList2);
				log.debug( "modifySpcJoSwapCapa-02");
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}		

	/**
	 * 1. 기능 : BSAManage Slot-info for SPC Control SC화면에 대한 조회 이벤트 처리(ESM_BSA_024)<p>
	 * 2. 처리개요 : <p>
	 *    - BSAManage Slot-info for SPC Control SC에 대한 리스트를 조회
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.10.27<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param SearchBsaConditionVO  vo
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchSPCSCBSA(SearchBsaConditionVO  vo) throws EventException {
		String bsaOpCd="";
		String[] codeArr = null;
		try {
			CommonBsaRsVO retVo = new CommonBsaRsVO();
			if(vo.getRdoopcd() == null || vo.getRdoopcd().trim().equals("")){
				bsaOpCd = "S";
			}
			else{
				bsaOpCd=vo.getRdoopcd();
			}

			String strItem = searchCarrierItem(bsaOpCd);

			log.debug("strItem = " + strItem);
			//vo.setHeader(strItem);
			
			if( strItem != null && !strItem.equals("")){
				codeArr = strItem.split("[|]");				
			}		
			
			vo.setTxtedate(vo.getTxtedate().replaceAll("-", ""));
			vo.setTxtsdate(vo.getTxtsdate().replaceAll("-", ""));

			if (codeArr != null){
			retVo = dbDao.searchSpcScBSA(vo,codeArr);
			}

			return retVo;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}	
	

	/**
	 * 1. 기능 : BSAManage Slot-info for SPC Control SC화면에 대한 멀티 이벤트 처리(ESM_BSA_0024)<p>
	 * 2. 처리개요 : <p>
	 *            BSA_SLT_CHTR_CRR_CAPA 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 *            BSA(007) or Weight Per TEU(008)일경우 BSA_SLT_CHTR_CRR_CAPA테이블에 TTL Weight(009)를 Update한다.
	 *            BSA(007)일 경우 BSA_SLT_CHTR_PORT_DWN테이블에 Carrier정보를 Update한다.
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.10.27<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param BsaSlotInfoForSpcCntrSaveVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSPCSCBSA(BsaSlotInfoForSpcCntrSaveVO[] vos, SignOnUserAccount account) throws EventException{
		try{
			String updUsrId	= account.getUsr_id();
			String bsaOpJbCd ="";
			String bsaOpCd	 ="";
			
			List<BsaSltChtrCrrCapaVO> updateList  = new ArrayList<BsaSltChtrCrrCapaVO>();
			List<BsaSltChtrCrrCapaVO> updateList2 = new ArrayList<BsaSltChtrCrrCapaVO>();
			List<BsaSltChtrCrrCapaVO> updateList3 = new ArrayList<BsaSltChtrCrrCapaVO>();
			List<BsaSltChtrPortDwnVO> updateList4 = new ArrayList<BsaSltChtrPortDwnVO>();
			
			for ( int i=0; i<vos .length; i++ ) {
				bsaOpJbCd= vos[i].getRdoopjbcd2();
				bsaOpCd	= vos[i].getRdoopcd();
				
//				String ibflag 	= vos[i].getIbflag();
				String bsaSeq 	= vos[i].getBsaSeq();
				String trdCd  	= vos[i].getTrdCd();
				String rlaneCd	= vos[i].getRlaneCd();
				String dirCd	= vos[i].getDirCd();
//				String vslCd	= vos[i].getVslCd();
				String vslSeq	= vos[i].getVslSeq();
				String fnlHjsBsaCapa=vos[i].getFnlHjsBsaCapa();
				
				String crrCdTmp = vos[i].getSheader() + "|SML";
				String spcCtrlSltCapaTmp = vos[i].getHeaderCapa()+fnlHjsBsaCapa;
				String[] crrCd	= crrCdTmp.split("[|]");
				String[] spcCtrlSltCapa = spcCtrlSltCapaTmp.split("[|]");
				
				// 1. BSA_SLT_CHTR_CRR_CAPA 테이블에 정보를 변경한다.
				//--------------------------------------------------------------
				for (int j = 0; j < crrCd.length; j++) {
					BsaSltChtrCrrCapaVO paramVo = new BsaSltChtrCrrCapaVO();
					
					paramVo.setBsaSeq(bsaSeq);
					paramVo.setTrdCd(trdCd);
					paramVo.setRlaneCd(rlaneCd);
					paramVo.setDirCd(dirCd);
					paramVo.setVslSeq(vslSeq);
					paramVo.setBsaOpCd(bsaOpCd);
					paramVo.setBsaOpJbCd(bsaOpJbCd);
					paramVo.setCrrCd(crrCd[j]);
					paramVo.setCrrBsaCapa(spcCtrlSltCapa[j]);
					paramVo.setUpdUsrId(updUsrId);
					
					updateList.add(paramVo);
				}
				// 2. BSA, Weight Per TEU가 변경되었을때 TTL Weight의 값도 변경시켜준다.
				//--------------------------------------------------------------
				if(bsaOpJbCd.equals("007") || bsaOpJbCd.equals("008")){
					BsaSltChtrCrrCapaVO paramVo = new BsaSltChtrCrrCapaVO();
						
						paramVo.setBsaSeq(bsaSeq);
						paramVo.setTrdCd(trdCd);
						paramVo.setRlaneCd(rlaneCd);
						paramVo.setDirCd(dirCd);
						paramVo.setVslSeq(vslSeq);
						paramVo.setBsaOpCd(bsaOpCd);
						paramVo.setBsaOpJbCd(bsaOpJbCd);
						paramVo.setUpdUsrId(updUsrId);
						
						updateList2.add(paramVo);
						
				}
				// 3. TTL Weight가 변경되었을때 Weight Per TEU의 값을 변경시켜준다.
				//--------------------------------------------------------------
				if(bsaOpJbCd.equals("007") || bsaOpJbCd.equals("009")){
					BsaSltChtrCrrCapaVO paramVo = new BsaSltChtrCrrCapaVO();
					
					paramVo.setBsaSeq(bsaSeq);
					paramVo.setTrdCd(trdCd);
					paramVo.setRlaneCd(rlaneCd);
					paramVo.setDirCd(dirCd);
					paramVo.setVslSeq(vslSeq);
					paramVo.setBsaOpCd(bsaOpCd);
					paramVo.setUpdUsrId(updUsrId);
					
					updateList3.add(paramVo);
				}
				// 4. BSA가 변경되었을때 COA_BSA_SLT_CHTR_PORT_DWN의 값도 변경시켜준다.
				//--------------------------------------------------------------
				if(bsaOpJbCd.equals("007")){
					BsaSltChtrPortDwnVO paramVo = new BsaSltChtrPortDwnVO();
					
					paramVo.setBsaSeq(bsaSeq);
					paramVo.setTrdCd(trdCd);
					paramVo.setRlaneCd(rlaneCd);
					paramVo.setDirCd(dirCd);
					paramVo.setVslSeq(vslSeq);
					paramVo.setBsaOpCd(bsaOpCd);
					paramVo.setBsaOpJbCd(bsaOpJbCd);
					paramVo.setUpdUsrId(updUsrId);
					
					updateList4.add(paramVo);
				}
				
			}
			
			if ( updateList.size() > 0 ) {
				dbDao.multiSpcScBSA(updateList);
			}
			
			if ( updateList2.size() > 0 ) {
				dbDao.modifySpcScTTLWeight(updateList2);
			}
			
			if ( updateList3.size() > 0 ) {
				dbDao.modifySpcScWeightPerTEU(updateList3);
			}
			
			if ( updateList4.size() > 0 ) {
				dbDao.modifySpcScPortDwn(updateList4);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}	

	/* ---------------------------------------------------- */

	/**
	 * ESM_BSA_0120: 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return List<BsaCrrInfoVO>
	 * @exception EventException
	 */
	public List<BsaCrrInfoVO> searchCarrierInfoList() throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			return  dbDao.searchCarrierInfoList();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 *ESM_BSA_0120: 멀티 이벤트 처리<br>
	 * BSAManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiCarrierInfo(SearchBsaConditionVO vo,SignOnUserAccount account) throws EventException {
		try {
			List<BsaCrrRgstVO> insertVoList2 = new ArrayList<BsaCrrRgstVO>();
			
			String strBsaOpCd = new String();
			String strBsaOpJbCd = new String();
			String strAplyFlg = "N";
			
			String strCrrCd = vo.getCrrcd();
					
			for (int ix = 0; ix < 2; ix++) {
				if (ix == 0)
					strBsaOpCd = "J";
				else
					strBsaOpCd = "S";

				for (int iy = 1; iy < 23; iy++) {
					BsaCrrRgstVO rGstVo = new BsaCrrRgstVO();
					strBsaOpJbCd = Utils.fillSpace(iy + "", 3, "0", "left");
					if (iy > 5) {
						strAplyFlg = "Y";
					} else {
						strAplyFlg = "N";
					}
					rGstVo.setBsaOpCd(strBsaOpCd);
					rGstVo.setBsaOpJbCd(strBsaOpJbCd);
					rGstVo.setCrrCd(strCrrCd);
					rGstVo.setCrrDpNo(iy + "");
					rGstVo.setAplyFlg(strAplyFlg);
					rGstVo.setCreUsrId(account.getUsr_id());
					rGstVo.setUpdUsrId(account.getUsr_id());
					
					insertVoList2.add(rGstVo);
				}
			}
				
			
			if ( insertVoList2.size() > 0 ) {
//				dbDao.addMultiBsaCrrInfo(insertVoList);
				dbDao.addMultiBsaCrrRgst(insertVoList2);
			}
//			if ( updateVoList.size() > 0 ) {
//				dbDao.modifyMultiBsaCrrInfo(updateVoList);
//			}		
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_BSA_0172: 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO vo
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchBSARateList(SearchBsaConditionVO vo) throws EventException {
		String[] codeArr = null;
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		try {
			// PDTO(Data Transfer Object including Parameters)
			String crrCd       = JSPUtil.getNull(vo.getHeader2()).trim();
			
			if( crrCd != null && !crrCd.equals("")){
				codeArr = crrCd.split("[|]");				
			}		
			
			vo.setTxtedate(vo.getTxtedate().replaceAll("-", ""));
			vo.setTxtsdate(vo.getTxtsdate().replaceAll("-", ""));
			
			if (codeArr != null){
			rsVo =  dbDao.searchBSARateList(vo,codeArr);
			}
			
			return rsVo;
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_BSA_0172: 멀티 이벤트 처리<br>
	 * BSAManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param BsaHighCubicRateSaveVO[] VOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiBSARate(BsaHighCubicRateSaveVO[] vos, SignOnUserAccount account) throws EventException{
		try {
			List<BsaHighCubicRateSaveVO> voList = new ArrayList<BsaHighCubicRateSaveVO>();
			
			
			for ( int i=0; i<vos .length; i++ ) {
				
				vos[i].setHeader2("|"+vos[i].getHeader2() + "|");
				vos[i].setArrwtnrate( vos[i].getArrwtnrate()+"|" );
				vos[i].setArrratetype(vos[i].getArrratetype()+"|" );
				vos[i].setArrovrrate( vos[i].getArrovrrate()+"|" );
				vos[i].setUpdUsrId(account.getUsr_id());
				
				voList.add(vos[i]);				
			}
			
			if ( voList.size() > 0 ) {
				dbDao.multiBSARate(voList);
			}
			
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BSA_0162: 헤더구성 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public CommonBsaRsVO searchBsaCrrRgstList2() throws EventException {
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		List<SearchBsaCrrRgstListVO>list = null;
		try {
			rsVo= dbDao.searchBsaCrrRgstList();
			
			list = (List)RowSetUtil.rowSetToVOs(rsVo.getDbRowset(), SearchBsaCrrRgstListVO .class);
			rsVo.setResultVOList(list);
			return rsVo;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BSA_0162: 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO searchBsaConditionVO
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchOverUsedSlotCostList(SearchBsaConditionVO searchBsaConditionVO) throws EventException{
		List<SearchBsaCrrRgstListVO> codeArr = new ArrayList<SearchBsaCrrRgstListVO>();
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		CommonBsaRsVO[] retVoArray = new CommonBsaRsVO[2];
		
		int j = 0;
		try {
			
			// PDTO(Data Transfer Object including Parameters)
			retVoArray[0] = dbDao.searchBsaCrrRgstList();
			String bsaOpJbCd = JSPUtil.getNull(searchBsaConditionVO.getBsaopjbcd()).trim();
			String crrCd       = JSPUtil.getNull(searchBsaConditionVO.getCrrcd()).trim();
			if (bsaOpJbCd.length()>0) { 
				bsaOpJbCd = bsaOpJbCd.substring(1); 
			}
			if (crrCd.length()>0){ 
				crrCd = crrCd.substring(1); 
			}
			
			if(bsaOpJbCd != null && !bsaOpJbCd.equals("") && crrCd != null && !crrCd.equals("")){
							
				StringTokenizer st1  = new StringTokenizer(bsaOpJbCd, "|");
				StringTokenizer st2  = new StringTokenizer(crrCd, "|");
				
				List<String> tempArrList1 = new ArrayList<String>();
				List<String> tempArrList2 = new ArrayList<String>();
				
				while( st1.hasMoreTokens() ) {
					tempArrList1.add(j++, st1.nextToken());
				}
				j = 0;
				while( st2.hasMoreTokens() ) {
					tempArrList2.add(j++, st2.nextToken());
				}
				
				int cnt1 = tempArrList1.size();
				int cnt2 = tempArrList2.size();
				
				if(cnt1 == cnt2){
					for(int i=0; i<cnt1; i++){
						SearchBsaCrrRgstListVO vo = new SearchBsaCrrRgstListVO();
						vo.setBsaOpJbCd((String)tempArrList1.get(i));
						vo.setCrrCd((String)tempArrList2.get(i));
						codeArr.add(i, vo);
					}
				}
			}		
			
			searchBsaConditionVO.setTxtedate(searchBsaConditionVO.getTxtedate().replaceAll("-", ""));
			searchBsaConditionVO.setTxtsdate(searchBsaConditionVO.getTxtsdate().replaceAll("-", ""));
			retVoArray[1] =  dbDao.searchOverUsedSlotCostList(searchBsaConditionVO,codeArr);
							
			rsVo.setCommonBsaRsVOArray(retVoArray);
			return rsVo;
				
		 } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_BSA_0162: 멀티 이벤트 처리<br>
	 * BSAManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param BsaOverUsedSlotCostSaveVO[] VOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiOverUsedSlotCost(BsaOverUsedSlotCostSaveVO[] vos, SignOnUserAccount account) throws EventException {
		try {
			List<BsaOverUsedSlotCostSaveVO> voList = new ArrayList<BsaOverUsedSlotCostSaveVO>();
			
			for ( int i=0; i<vos .length; i++ ) {
				
				vos[i].setCrrCd(vos[i].getCrrCd() + "|");
				vos[i].setBsaOpJbCd( vos[i].getBsaOpJbCd()+"|" );
				vos[i].setCreUsrId(account.getUsr_id());
				
				voList.add(vos[i]);				
			}
			
			if ( voList.size() > 0 ) {
				dbDao.multiOverUsedSlotCost(voList);
			}
			
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BSA_0172: 헤더구성 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchBsaCrrRgstList1() throws EventException {
		try {
			String headSet = this.searchCarrierItem("");
			
			return headSet;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * ESM_BSA_0028: 헤더구성 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public CommonBsaRsVO searchBsaCrrRgstList() throws EventException {
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		List<SearchBsaCrrRgstListVO>list = null;
		try {
			rsVo= dbDao.searchBsaCrrRgstList();
			String headSet = this.searchCarrierItem("");
			
			rsVo.setStrTemp(headSet);
			list = (List)RowSetUtil.rowSetToVOs(rsVo.getDbRowset(), SearchBsaCrrRgstListVO .class);
			rsVo.setResultVOList(list);
			return rsVo;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * ESM_BSA_0028: 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO searchBsaConditionVO
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchSlotCostList(SearchBsaConditionVO searchBsaConditionVO) throws EventException {
		
		List<SearchBsaCrrRgstListVO> codeArr = new ArrayList<SearchBsaCrrRgstListVO>();
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		CommonBsaRsVO[] retVoArray = new CommonBsaRsVO[2];
		
		int j = 0;
		try {
			
			// PDTO(Data Transfer Object including Parameters)
			retVoArray[0] = dbDao.searchBsaCrrRgstList();
			String bsaOpJbCd = JSPUtil.getNull(searchBsaConditionVO.getBsaopjbcd()).trim();
			String crrCd       = JSPUtil.getNull(searchBsaConditionVO.getCrrcd()).trim();
			if (bsaOpJbCd.length()>0) { 
				bsaOpJbCd = bsaOpJbCd.substring(1); 
			}
			if (crrCd.length()>0){ 
				crrCd = crrCd.substring(1); 
			}
			
			if(bsaOpJbCd != null && !bsaOpJbCd.equals("") && crrCd != null && !crrCd.equals("")){
							
				StringTokenizer st1  = new StringTokenizer(bsaOpJbCd, "|");
				StringTokenizer st2  = new StringTokenizer(crrCd, "|");
				
				List<String> tempArrList1 = new ArrayList<String>();
				List<String> tempArrList2 = new ArrayList<String>();
				
				while( st1.hasMoreTokens() ) {
					tempArrList1.add(j++, st1.nextToken());
				}
				j = 0;
				while( st2.hasMoreTokens() ) {
					tempArrList2.add(j++, st2.nextToken());
				}
				
				int cnt1 = tempArrList1.size();
				int cnt2 = tempArrList2.size();
				
				if(cnt1 == cnt2){
					for(int i=0; i<cnt1; i++){
						SearchBsaCrrRgstListVO vo = new SearchBsaCrrRgstListVO();
						vo.setBsaOpJbCd((String)tempArrList1.get(i));
						vo.setCrrCd((String)tempArrList2.get(i));
						codeArr.add(i, vo);
					}
				}
			}		
			
			searchBsaConditionVO.setTxtedate(searchBsaConditionVO.getTxtedate().replaceAll("-", ""));
			searchBsaConditionVO.setTxtsdate(searchBsaConditionVO.getTxtsdate().replaceAll("-", ""));
			retVoArray[1] =  dbDao.searchSlotCostList(searchBsaConditionVO,codeArr);
							
			rsVo.setCommonBsaRsVOArray(retVoArray);
			return rsVo;
				
		 } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
		 * ESM_BSA_0028: 조회 이벤트 처리<br>
		 * BSAManage화면에 대한 조회 이벤트 처리<br>
		 * 
		 * @param SearchBsaConditionVO vo
		 * @return CommonBsaRsVO
		 * @exception EventException
		 */
		public CommonBsaRsVO searchRFCostList(SearchBsaConditionVO vo) throws EventException {
			String[] codeArr = null;
			CommonBsaRsVO rsVo = new CommonBsaRsVO();
			CommonBsaRsVO[] retVoArray = new CommonBsaRsVO[2];
			
			try {
				
				// PDTO(Data Transfer Object including Parameters)
				String crrCd       = JSPUtil.getNull(vo.getHeader2()).trim();
			
				if( crrCd != null && !crrCd.equals("")){
					codeArr = crrCd.split("[|]");				
				}		
				
				vo.setTxtedate(vo.getTxtedate().replaceAll("-", ""));
				vo.setTxtsdate(vo.getTxtsdate().replaceAll("-", ""));
				
				String rdoType2 = vo.getRdotype2();
				
				if(rdoType2.equals("0")){
					vo.setRdotype("018");
				}
				if(rdoType2.equals("1")){
					vo.setRdotype("019");
				}
				
				if (codeArr != null){
				retVoArray[0] =  dbDao.searchRFCostList(vo,codeArr);
				}
								
				rsVo.setCommonBsaRsVOArray(retVoArray);
				return rsVo;
			} catch(DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler(ex).getMessage());
	 		} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler(ex).getMessage());
			}
		}

	/**
		 * ESM_BSA_0028: 조회 이벤트 처리<br>
		 * BSAManage화면에 대한 조회 이벤트 처리<br>
		 * 
		 * @param SearchBsaConditionVO vo
		 * @return CommonBsaRsVO
		 * @exception EventException
		 */
		public CommonBsaRsVO searchOverCostList(SearchBsaConditionVO vo) throws EventException {
			String[] codeArr = null;
			CommonBsaRsVO rsVo = new CommonBsaRsVO();
			CommonBsaRsVO[] retVoArray = new CommonBsaRsVO[2];
			
			try {
				
				// PDTO(Data Transfer Object including Parameters)
				String crrCd       = JSPUtil.getNull(vo.getHeader2()).trim();
				
				if( crrCd != null && !crrCd.equals("")){
					codeArr = crrCd.split("[|]");				
				}		
				
				vo.setTxtedate(vo.getTxtedate().replaceAll("-", ""));
				vo.setTxtsdate(vo.getTxtsdate().replaceAll("-", ""));
				
				String rdoType2 = vo.getRdotype2();
				
				if(rdoType2.equals("0")){
					vo.setRdotype("020");
				}
				if(rdoType2.equals("1")){
					vo.setRdotype("021");
				}
				
				if (codeArr != null){
					retVoArray[0] =  dbDao.searchOverCostList(vo,codeArr);
				}				
								
				rsVo.setCommonBsaRsVOArray(retVoArray);
				return rsVo;
			} catch(DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler(ex).getMessage());
	 		} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler(ex).getMessage());
			}
		}

	/**
	 * ESM_BSA_0028: 멀티 이벤트 처리<br>
	 * BSAManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param BsaManageSltPrcSaveVO[] VOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSlotCost(BsaManageSltPrcSaveVO[] VOs,SignOnUserAccount account) throws EventException {
		try {
			List<BsaManageSltPrcSaveVO> voList1 = new ArrayList<BsaManageSltPrcSaveVO>();
			List<BsaManageSltPrcSaveVO> voList2 = new ArrayList<BsaManageSltPrcSaveVO>();
			List<BsaManageSltPrcSaveVO> deleteVoList = new ArrayList<BsaManageSltPrcSaveVO>();
			String trdCd ="";
			String rlaneCd="";
			String dirCd="";
			String costTp="";
			String prcSeq="";
			
			for ( int i=0; i<VOs.length; i++ ) {
				if ( trdCd.equals(VOs[i].getTrdCd()) && rlaneCd.equals(VOs[i].getRlaneCd()) &&
					 dirCd.equals(VOs[i].getDirCd()) && costTp.equals(VOs[i].getBsaSltCostTpCd()) && 
					 prcSeq.equals(VOs[i].getSltPrcSeq()))
				{
					if ( VOs[i].getIbflag().equals("I") || VOs[i].getIbflag().equals("U")){
						 VOs[i].setCreUsrId(account.getUsr_id());
						 VOs[i].setUpdUsrId(account.getUsr_id());
						 voList2.add(VOs[i]);
					} 
				}else{
					if ( VOs[i].getIbflag().equals("I") || VOs[i].getIbflag().equals("U")){
						VOs[i].setCreUsrId(account.getUsr_id());
						VOs[i].setUpdUsrId(account.getUsr_id());
						voList1.add(VOs[i]);
						voList2.add(VOs[i]);
					} else if ( VOs[i].getIbflag().equals("D")
							|| !VOs[i].getSltPrcSeq().equals(VOs[i].getSltPrcSeqOrg()) ){
						deleteVoList.add(VOs[i]);						
					}
				}
				
				trdCd =VOs[i].getTrdCd();
				rlaneCd=VOs[i].getRlaneCd();
				dirCd=VOs[i].getDirCd();
				costTp=VOs[i].getBsaSltCostTpCd();
				prcSeq=VOs[i].getSltPrcSeq();
			}
			
			if ( voList1.size() > 0 || voList2.size() > 0 ) {				
				dbDao.multiBsaSltPrc(voList1);
				dbDao.multiBsaSltPrcCrr(voList2);				
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeBsaSltPrc(deleteVoList);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		
	}

	/**
	 * ESM_BSA_0028: 멀티 이벤트 처리<br>
	 * BSAManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param BsaManageSltPrcSaveVO[] VOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiRFCost(BsaManageSltPrcSaveVO[] VOs,SignOnUserAccount account) throws EventException {
		try {
			List<BsaManageSltPrcSaveVO> voList = new ArrayList<BsaManageSltPrcSaveVO>();
			
			for ( int i=0; i<VOs .length; i++ ) {
				if ( VOs[i].getIbflag().equals("I")){
					if(VOs[i].getRdoType2().equals("0")){
						VOs[i].setBsaSltCostTpCd("018");
					}
					if(VOs[i].getRdoType2().equals("1")){
						VOs[i].setBsaSltCostTpCd("019");
					}				
				}
				VOs[i].setUpdUsrId(account.getUsr_id());
				VOs[i].setCrrCd(VOs[i].getCrrCd() + "|");
				VOs[i].setSltPrcCapa( VOs[i].getSltPrcCapa()+"|" );
				
				voList.add(VOs[i]);				
			}
			
			if ( voList.size() > 0 ) {
				dbDao.multiRFCost(voList);
			}
			
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * ESM_BSA_0028: 멀티 이벤트 처리<br>
	 * BSAManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param BsaManageSltPrcSaveVO[] VOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiOverCost(BsaManageSltPrcSaveVO[] VOs,SignOnUserAccount account) throws EventException {
		try {
			List<BsaManageSltPrcSaveVO> voList = new ArrayList<BsaManageSltPrcSaveVO>();
			
			for ( int i=0; i<VOs .length; i++ ) {
				if ( VOs[i].getIbflag().equals("I")){
					if(VOs[i].getRdoType2().equals("0")){
						VOs[i].setBsaSltCostTpCd("020");
					}
					if(VOs[i].getRdoType2().equals("1")){
						VOs[i].setBsaSltCostTpCd("021");
					}				
				}
				VOs[i].setUpdUsrId(account.getUsr_id());
				VOs[i].setCrrCd(VOs[i].getCrrCd() + "|");
				VOs[i].setSltPrcCapa( VOs[i].getSltPrcCapa()+"|" );
				
				
				voList.add(VOs[i]);				
			}
			
			if ( voList.size() > 0 ) {
				dbDao.multiOverCost(voList);
			}
			
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BSA_0123: 조회 처리<br>
	 * BSAManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO searchBsaConditionVO
	 * @return List<BsaTableSaveVO>
	 * @exception EventException
	 */
	public List<BsaTableSaveVO> searchBSATableVvdList(SearchBsaConditionVO searchBsaConditionVO) throws EventException {
		try {
			return dbDao.searchBSATableVvdList(searchBsaConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	} 

}