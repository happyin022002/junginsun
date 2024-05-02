/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BSAYearlyPlanBCImpl.java
*@FileTitle : BSA Creation/Update
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.17
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.17 이행지
* 1.0 Creation
*=========================================================
* History :
* 2011.01.17 이행지 [CHM-201108497-01] 사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
* 2011.04.04 최윤성 [CHM-201109932-01] BSA Yearly PLan 메뉴에 Live Data I/F 기능 추가
* 2014.06.30 김용습 R4J 패치 사전 작업
* 2015.03.27 김용습 [CHM-201534456] 2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.basic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaTableSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.CreateBSAVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchBsaCrrRgstListVO;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration.BSAYearlyPlanDBDAO;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo.BsaYearlyPlanConditionVO;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo.ParamCoaMonVvdYryPlnVO;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo.RsltCoaMonVvdYryPlnVO;
import com.hanjin.apps.alps.esm.bsa.common.Utils;
import com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BsaBudJntOpBzcVO;
import com.hanjin.syscommon.common.table.BsaBudJntOpCrrCapaVO;
import com.hanjin.syscommon.common.table.BsaBudSltChtrBzcVO;
import com.hanjin.syscommon.common.table.BsaBudSltChtrCrrCapaVO;
import com.hanjin.syscommon.common.table.BsaBudSltPrcCrrVO;
import com.hanjin.syscommon.common.table.BsaBudSltPrcVO;
import com.hanjin.syscommon.common.util.ScheduleUtil;

/**
 * ALPS-BSAYearlyPlan Business Logic Command Interface<br>
 * - ALPS-BSAYearlyPlan에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Haeng-ji,Lee
 * @see BSAYearlyPlanSC 참조
 * @since J2EE 1.6
 */
public class BSAYearlyPlanBCImpl extends BasicCommandSupport implements BSAYearlyPlanBC {

	// Database Access Object
	private transient BSAYearlyPlanDBDAO dbDao = null;

	/**
	 * BSAYearlyPlanBCImpl 객체 생성<br>
	 * BSAYearlyPlanDBDAO를 생성한다.<br>
	 */
	public BSAYearlyPlanBCImpl() {
		dbDao = new BSAYearlyPlanDBDAO();
	}
	
	//===============================================================================
	// ESM_BSA_0040: BSA Creation/Update(Yearly Plan)
	//=============================================================================== 
	/**
	 * ESM_BSA_0040: 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param BsaYearlyPlanConditionVO vo
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchBSATableJOList(BsaYearlyPlanConditionVO vo) throws EventException {
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
		
				vo.setTxtsdate( vo.getTxtsdate().replaceAll("-",""));
				vo.setTxtedate( vo.getTxtedate().replaceAll("-",""));

				//조회하기-------------------------------------
				retVoArray[1] = dbDao.searchBSATableJOList(vo,codeArr);
				//---------------------------------------------
				
				rsVo.setCommonBsaRsVOArray(retVoArray);
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
	 * ESM_BSA_0040: 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param BsaYearlyPlanConditionVO vo
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */	
	public CommonBsaRsVO searchBSATableSCList(BsaYearlyPlanConditionVO vo) throws EventException {
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
		
				vo.setTxtsdate( vo.getTxtsdate().replaceAll("-",""));
				vo.setTxtedate( vo.getTxtedate().replaceAll("-",""));			
				
				//조회하기-------------------------------------
				retVoArray[1] = dbDao.searchBSATableSCList(vo,codeArr);
				//----------------------------------------------

				rsVo.setCommonBsaRsVOArray(retVoArray);
			
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
	 * ESM_BSA_0040: 멀티 이벤트 처리<br>
	 * BSAManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param BsaBudJntOpBzcVO[] bsaBudJntOpBzcVOs
	 * @param BsaBudJntOpCrrCapaVO[] bsaBudJntOpCrrCapaVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void multiBSATableJO(BsaBudJntOpBzcVO[] bsaBudJntOpBzcVOs, BsaBudJntOpCrrCapaVO[] bsaBudJntOpCrrCapaVOs, SignOnUserAccount account) throws EventException{
		try{
			String usrId = account.getUsr_id();
			String bsaOpCd = "J";
			
			BsaBudJntOpBzcVO 	 bsaBudJntOpBzcVO		= null;
			BsaBudJntOpCrrCapaVO bsaBudJntOpCrrCapaVO	= null;
			
			List<BsaBudJntOpBzcVO> 	iBsaBudJntOpBzcVOs = new ArrayList<BsaBudJntOpBzcVO>();
			List<BsaBudJntOpBzcVO> 	mBsaBudJntOpBzcVOs = new ArrayList<BsaBudJntOpBzcVO>();
			List<BsaBudJntOpCrrCapaVO> iBsaBudJntOpCrrCapaVOs = new ArrayList<BsaBudJntOpCrrCapaVO>();
			List<BsaBudJntOpCrrCapaVO> mergeVOList = new ArrayList<BsaBudJntOpCrrCapaVO>();
			List<BsaBudJntOpCrrCapaVO> mergeVOList2 = new ArrayList<BsaBudJntOpCrrCapaVO>();
			List<BsaBudJntOpCrrCapaVO> mergeVOList3 = new ArrayList<BsaBudJntOpCrrCapaVO>();
			List<BsaBudJntOpCrrCapaVO> mergeVOList4 = new ArrayList<BsaBudJntOpCrrCapaVO>();
			
			for( int i=0; i<bsaBudJntOpBzcVOs.length; i++ ) {
				bsaBudJntOpBzcVOs[i].setCreUsrId(usrId);
				bsaBudJntOpBzcVOs[i].setUpdUsrId(usrId);
				if(bsaBudJntOpBzcVOs[i].getIbflag().equals("I")) {
					iBsaBudJntOpBzcVOs.add(bsaBudJntOpBzcVOs[i]);
					bsaBudJntOpBzcVO = bsaBudJntOpBzcVOs[i];
					
					bsaBudJntOpCrrCapaVO	= new BsaBudJntOpCrrCapaVO();
					bsaBudJntOpCrrCapaVO.setBsaOpCd(bsaOpCd);
					ObjectCloner.build(bsaBudJntOpBzcVO, bsaBudJntOpCrrCapaVO);
					mergeVOList3.add(bsaBudJntOpCrrCapaVO);
					
				} else if ( bsaBudJntOpBzcVOs[i].getIbflag().equals("U")) {
					mBsaBudJntOpBzcVOs.add(bsaBudJntOpBzcVOs[i]);
					
				}

				if(bsaBudJntOpBzcVOs[i].getIbflag().equals("I") || bsaBudJntOpBzcVOs[i].getIbflag().equals("U")) {
            	  	mergeVOList2.add(bsaBudJntOpCrrCapaVOs[i]);

					bsaBudJntOpBzcVO = bsaBudJntOpBzcVOs[i];

					bsaBudJntOpCrrCapaVO	= new BsaBudJntOpCrrCapaVO();
					ObjectCloner.build(bsaBudJntOpBzcVO,bsaBudJntOpCrrCapaVO);					
					bsaBudJntOpCrrCapaVO.setBsaOpJbCd("007");

            	  	if (Double.parseDouble(bsaBudJntOpBzcVOs[i].getOwnrVslWgt()) > 0) {
            	  		mergeVOList4.add(bsaBudJntOpCrrCapaVO);
            	  	}
            	  	
					
				}
			}
			for( int i=0; i<bsaBudJntOpCrrCapaVOs.length; i++ ) {
				bsaBudJntOpCrrCapaVOs[i].setCreUsrId(usrId);
				bsaBudJntOpCrrCapaVOs[i].setUpdUsrId(usrId);
				bsaBudJntOpCrrCapaVOs[i].setBsaOpCd(bsaOpCd);
				
				if(bsaBudJntOpCrrCapaVOs[i].getIbflag().equals("I") 
						|| bsaBudJntOpCrrCapaVOs[i].getIbflag().equals("U")){
					mergeVOList.add(bsaBudJntOpCrrCapaVOs[i]);
				} else if(bsaBudJntOpCrrCapaVOs[i].getIbflag().equals("I") )
				{
					iBsaBudJntOpCrrCapaVOs.add(bsaBudJntOpCrrCapaVOs[i]);
				}
			}	
		                
			// 1. BSA_JNT_OP_BZC 테이블의 데이터를 변경한다.(I/U)
			//----------------------------------------------------
		    //[DB 실행]
			 if (iBsaBudJntOpBzcVOs.size() > 0){
				 dbDao.addBsaBudJntOpBzc(iBsaBudJntOpBzcVOs);
			 }
			 if (mBsaBudJntOpBzcVOs.size() > 0){
				 dbDao.modifyBsaBudJntOpBzc(mBsaBudJntOpBzcVOs);
			 }
				
			// 2. BSA_JNT_OP_CRR_CAPA 테이블의 데이터를 변경한다.(I/U)
			 if (mergeVOList.size() > 0){
				dbDao.multiBsaBudJntOpCrrCapa(mergeVOList);
			 }
				
			 // 4. 추가된 데이터에 대한 Capa추가(006~019)[I]
			 if (iBsaBudJntOpCrrCapaVOs.size()> 0) {
				dbDao.addBsaBudJntOpCrrCapa(iBsaBudJntOpCrrCapaVOs);
			 }
				
			 // 6. BSA[007]의 Carrier정보를 다시 계산한다.[I/U]
			 if (mergeVOList2.size()> 0) {
				dbDao.modifyBsaBudJntOpCrrCapa1(mergeVOList2);
			 }

			 // 8. 이전 seq의 Weigth Per TEU, RF, D2, D4, D5, D7의 capa정보를 복제한다.[I]
			 if (mergeVOList3.size()> 0) {
				dbDao.modifyBsaBudJntOpCrrCapa2(mergeVOList3);
			 }

			 // 9. BSA의 HJS정보를 FNL_HJS_BSA_CAPA정보로 업데이트 한다.[I/U]
			 if (mergeVOList2.size()> 0) {
				dbDao.modifyBsaBudJntOpCrrCapa3(mergeVOList2);
			 }

			 // 10. BSA정보가 변경되면 TTL Weight정보를 다시 계산한다.[21,24][I/U]
			 if (mergeVOList2.size()> 0) {			 
					dbDao.modifyBsaBudJntOpCrrCapa4(mergeVOList2);
			 }
			 if (mergeVOList4.size()> 0) {
					dbDao.modifyBsaBudJntOpCrrCapa5(mergeVOList4);
			 }

			 // 11. TTL Weight 가 변경되었으므로[I/U]
			 if (mergeVOList2.size()> 0) {	
					dbDao.modifyBsaBudJntOpCrrCapa6(mergeVOList2);			        
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
	 * ESM_BSA_0040: 멀티 이벤트 처리<br>
	 * BSAManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param BsaBudSltChtrBzcVO[] bsaBudSltChtrBzcVOs
	 * @param BsaBudSltChtrCrrCapaVO[] bsaBudSltChtrCrrCapaVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiBSATableSC(BsaBudSltChtrBzcVO[] bsaBudSltChtrBzcVOs, BsaBudSltChtrCrrCapaVO[] bsaBudSltChtrCrrCapaVOs, SignOnUserAccount account) throws EventException{
		try{
			String creUsrId = account.getUsr_id();
			String updUsrId = account.getUsr_id();
			String vslBsaChkFlg = "";
			String bsaOpCd = "S";
			
			BsaBudSltChtrBzcVO		bsaBudSltChtrBzcVO  = null;
			BsaBudSltChtrCrrCapaVO	bsaBudSltChtrCrrCapaVO = null;
			
			List<BsaBudSltChtrBzcVO> 	  iBsaBudSltChtrBzcVOs = new ArrayList<BsaBudSltChtrBzcVO>();  
			List<BsaBudSltChtrCrrCapaVO> iBsaBudSltChtrCrrCapaVOs = new ArrayList<BsaBudSltChtrCrrCapaVO>();  
			List<BsaBudSltChtrBzcVO> 	  mBsaBudSltChtrBzcVOs = new ArrayList<BsaBudSltChtrBzcVO>();  
			List<BsaBudSltChtrCrrCapaVO>  mBsaBudSltChtrCrrCapaVOs = new ArrayList<BsaBudSltChtrCrrCapaVO>(); 
			List<BsaBudSltChtrCrrCapaVO> muiltVoList = new ArrayList<BsaBudSltChtrCrrCapaVO>(); 
			List<BsaBudSltChtrCrrCapaVO> muiltVoList2 = new ArrayList<BsaBudSltChtrCrrCapaVO>();
			
			for(int i = 0 ; i < bsaBudSltChtrBzcVOs.length ; i++){				
				bsaBudSltChtrBzcVOs[i].setCreUsrId(creUsrId);
				bsaBudSltChtrBzcVOs[i].setUpdUsrId(updUsrId);
				
				vslBsaChkFlg = Utils.change10ToYN(bsaBudSltChtrBzcVOs[i].getVslBsaChkFlg());
				bsaBudSltChtrBzcVOs[i].setVslBsaChkFlg(vslBsaChkFlg);
				
				if ( bsaBudSltChtrBzcVOs[i].getIbflag().equals("I")){					
					iBsaBudSltChtrBzcVOs.add(bsaBudSltChtrBzcVOs[i]);
					
					bsaBudSltChtrBzcVO  = new BsaBudSltChtrBzcVO();
					bsaBudSltChtrBzcVO  = bsaBudSltChtrBzcVOs[i];
					bsaBudSltChtrCrrCapaVO = new BsaBudSltChtrCrrCapaVO();
					
					ObjectCloner.build(bsaBudSltChtrBzcVO, bsaBudSltChtrCrrCapaVO);

//					bsaBudSltChtrCrrCapaVO.setTrdCd(bsaBudSltChtrBzcVO.getTrdCd());
//					bsaBudSltChtrCrrCapaVO.setRlaneCd(bsaBudSltChtrBzcVO.getRlaneCd());
//					bsaBudSltChtrCrrCapaVO.setDirCd(bsaBudSltChtrBzcVO.getDirCd());
//					bsaBudSltChtrCrrCapaVO.setBsaSeq(bsaBudSltChtrBzcVO.getBsaSeq());
//					bsaBudSltChtrCrrCapaVO.setVslSeq(bsaBudSltChtrBzcVO.getVslSeq());
//					bsaBudSltChtrCrrCapaVO.setBsaOpCd(bsaOpCd);
//					bsaBudSltChtrCrrCapaVO.setCreUsrId(creUsrId);
//					bsaBudSltChtrCrrCapaVO.setUpdUsrId(updUsrId);
					
					bsaBudSltChtrCrrCapaVO.setBsaOpCd(bsaOpCd);
					iBsaBudSltChtrCrrCapaVOs.add(bsaBudSltChtrCrrCapaVO);
				}
				if ( bsaBudSltChtrBzcVOs[i].getIbflag().equals("U")){					
					mBsaBudSltChtrBzcVOs.add(bsaBudSltChtrBzcVOs[i]);
				}

				if ( bsaBudSltChtrBzcVOs[i].getIbflag().equals("I") || bsaBudSltChtrBzcVOs[i].getIbflag().equals("U")){
					bsaBudSltChtrBzcVO  = new BsaBudSltChtrBzcVO();
					bsaBudSltChtrBzcVO  = bsaBudSltChtrBzcVOs[i];
					bsaBudSltChtrCrrCapaVO = new BsaBudSltChtrCrrCapaVO();

					bsaBudSltChtrCrrCapaVO.setTrdCd(bsaBudSltChtrBzcVO.getTrdCd());
					bsaBudSltChtrCrrCapaVO.setRlaneCd(bsaBudSltChtrBzcVO.getRlaneCd());
					bsaBudSltChtrCrrCapaVO.setDirCd(bsaBudSltChtrBzcVO.getDirCd());
					bsaBudSltChtrCrrCapaVO.setBsaSeq(bsaBudSltChtrBzcVO.getBsaSeq());
					bsaBudSltChtrCrrCapaVO.setVslSeq(bsaBudSltChtrBzcVO.getVslSeq());
					bsaBudSltChtrCrrCapaVO.setBsaOpCd(bsaOpCd);
					bsaBudSltChtrCrrCapaVO.setCreUsrId(creUsrId);
					bsaBudSltChtrCrrCapaVO.setUpdUsrId(updUsrId);
					
					ObjectCloner.build(bsaBudSltChtrBzcVO, bsaBudSltChtrCrrCapaVO);
					muiltVoList.add(bsaBudSltChtrCrrCapaVO);
					
					bsaBudSltChtrCrrCapaVO.setBsaOpJbCd("007");
					muiltVoList2.add(bsaBudSltChtrCrrCapaVO);
				}
			}
			

			
			for(int i = 0 ; i < bsaBudSltChtrCrrCapaVOs.length ; i++){
				if(bsaBudSltChtrCrrCapaVOs[i].getIbflag().equals("I") || bsaBudSltChtrCrrCapaVOs[i].getIbflag().equals("U")){
					bsaBudSltChtrCrrCapaVOs[i].setCreUsrId(account.getUsr_id());
					bsaBudSltChtrCrrCapaVOs[i].setUpdUsrId(account.getUsr_id());
					bsaBudSltChtrCrrCapaVOs[i].setBsaOpCd(bsaOpCd);
					mBsaBudSltChtrCrrCapaVOs.add(bsaBudSltChtrCrrCapaVOs[i]);
				}
			}	
		                
			// 1. BSA_JNT_OP_BZC 테이블의 데이터를 변경한다.(I/U)
			 if (iBsaBudSltChtrBzcVOs.size() > 0){
				 dbDao.addBsaBudSltChtrBzc(iBsaBudSltChtrBzcVOs);
			 }
			 if (mBsaBudSltChtrBzcVOs.size() > 0){
				 dbDao.modifyBsaBudSltChtrBzc(mBsaBudSltChtrBzcVOs);
			 }
			 
			// 2. BSA_JNT_OP_CRR_CAPA 테이블의 데이터를 변경한다.(I/U)
			 if (mBsaBudSltChtrCrrCapaVOs.size() > 0){
				dbDao.multiBsaBudSltChtrCrrCapa(mBsaBudSltChtrCrrCapaVOs);
			 }
						
			 // 3. 추가된 데이터에 대한 Capa추가(006~019)[I]
			 //----------------------------------------------------
		     //[DB 실행]
			 if (iBsaBudSltChtrCrrCapaVOs.size()> 0) {
				dbDao.addBsaBudSltChtrCrrCapa(iBsaBudSltChtrCrrCapaVOs);
			 }
			 
			 // 6. BSA[007]의 Carrier정보를 다시 계산한다.[I/U]
			 if (muiltVoList.size()> 0) {
				dbDao.modifyBsaBudSltChtrCrrCapa1(muiltVoList);
			 }

			
			 // 8. 이전 seq의 Weigth Per TEU, RF, D2, D4, D5, D7의 capa정보를 복제한다.[I]
			 //------------------------------------------------------------------
		     //[DB 실행]
			 if (iBsaBudSltChtrCrrCapaVOs.size()> 0) {
				dbDao.modifyBsaBudSltChtrCrrCapa2(iBsaBudSltChtrCrrCapaVOs);
			 }

			 // 9. BSA의 HJS정보를 FNL_HJS_BSA_CAPA정보로 업데이트 한다.[I/U]
			 if (muiltVoList.size()> 0) {
				dbDao.modifyBsaBudSltChtrCrrCapa3(muiltVoList);
			 }

			 // 10. BSA정보가 변경되면 TTL Weight정보를 다시 계산한다.[21,24][I/U]
			 if (muiltVoList2.size()> 0) {			 
					dbDao.modifyBsaBudSltChtrCrrCapa4(muiltVoList2);
			 }

			 // 11. TTL Weight 가 변경되었으므로[I/U]
    		 //[DB 실행]
			 if (muiltVoList.size()> 0) {	
					dbDao.modifyBsaBudSltChtrCrrCapa5(muiltVoList);			        
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
	 * ESM_BSA_0040: 삭제 이벤트 처리<br>
	 * BSAManage화면에 대한 삭제 이벤트 처리<br>
	 * 
	 * @param BsaBudJntOpBzcVO[] bsaBudJntOpBzcVOs
	 * @exception EventException
	 */
	public void removeBSATableJO(BsaBudJntOpBzcVO[] bsaBudJntOpBzcVOs) throws EventException{
		try{
			BsaBudJntOpBzcVO 	 bsaBudJntOpBzcVO		= null;
			BsaBudJntOpCrrCapaVO bsaBudJntOpCrrCapaVO	= null;
			String bsaOpCd = "J";
			
			List<BsaBudJntOpCrrCapaVO> dBsaBudJntOpCrrCapaVOs = new ArrayList<BsaBudJntOpCrrCapaVO>(); 
			List<BsaBudJntOpBzcVO> 	dBsaBudJntOpBzcVOs = new ArrayList<BsaBudJntOpBzcVO>();  
			
			for(int i = 0 ; i < bsaBudJntOpBzcVOs.length ; i++){
				if(bsaBudJntOpBzcVOs[i].getIbflag().equals("D")) {
					dBsaBudJntOpBzcVOs.add(bsaBudJntOpBzcVOs[i]);
					
					bsaBudJntOpBzcVO        = new BsaBudJntOpBzcVO();
					bsaBudJntOpBzcVO		= bsaBudJntOpBzcVOs[i];
					bsaBudJntOpCrrCapaVO	= new BsaBudJntOpCrrCapaVO();
					ObjectCloner.build(bsaBudJntOpBzcVO, bsaBudJntOpCrrCapaVO);
					bsaBudJntOpCrrCapaVO.setBsaOpCd(bsaOpCd);
					
					dBsaBudJntOpCrrCapaVOs.add(bsaBudJntOpCrrCapaVO);
				}
			}
			
			 if (dBsaBudJntOpCrrCapaVOs.size()> 0) {
				 dbDao.removeBsaBudJntOpCrrCapa(dBsaBudJntOpCrrCapaVOs);
			 }
			 if (dBsaBudJntOpBzcVOs.size()> 0) {
				 dbDao.removeBsaBudJntOpBzc(dBsaBudJntOpBzcVOs);
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
	 * ESM_BSA_0040: 삭제 이벤트 처리<br>
	 * BSAManage화면에 대한 삭제 이벤트 처리<br>
	 * 
	 * @param BsaBudSltChtrBzcVO[] bsaBudSltChtrBzcVOs
	 * @exception EventException
	 */
	public void removeBSATableSC(BsaBudSltChtrBzcVO[] bsaBudSltChtrBzcVOs) throws EventException{
		try{
			BsaBudSltChtrCrrCapaVO 	bsaBudSltChtrCrrCapaVO = null;
			BsaBudSltChtrBzcVO 		bsaBudSltChtrBzcVO  = null;
			String bsaOpCd = "S";
			
			List<BsaBudSltChtrCrrCapaVO>  deleteCrrVoList = new ArrayList<BsaBudSltChtrCrrCapaVO>();  	
			List<BsaBudSltChtrBzcVO> 	  deleteVoList = new ArrayList<BsaBudSltChtrBzcVO>();  
			
			 for(int i = 0 ; i < bsaBudSltChtrBzcVOs.length ; i++){
				 if(bsaBudSltChtrBzcVOs[i].getIbflag().equals("D")) {
					 deleteVoList.add(bsaBudSltChtrBzcVOs[i]);
					 					 
					 bsaBudSltChtrBzcVO  = new BsaBudSltChtrBzcVO();
					 bsaBudSltChtrBzcVO  = bsaBudSltChtrBzcVOs[i];
					 bsaBudSltChtrCrrCapaVO = new BsaBudSltChtrCrrCapaVO();
					 ObjectCloner.build(bsaBudSltChtrBzcVO, bsaBudSltChtrCrrCapaVO);
					 bsaBudSltChtrCrrCapaVO.setBsaOpCd(bsaOpCd);
					 
					 deleteCrrVoList.add(bsaBudSltChtrCrrCapaVO);
					 
				 }
			 }
			 if (deleteCrrVoList.size()> 0) {
				 dbDao.removeBsaBudSltChtrCrrCapa(deleteCrrVoList);
			 }
			 if (deleteVoList.size()> 0) {
				 dbDao.removeBsaBudSltChtrBzc(deleteVoList);
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
	 * ESM_BSA_0040: 생성시 정보를 조회 함.<br>
	 * 
	 * @param BsaYearlyPlanConditionVO vo
	 * @param SignOnUserAccount account
	 * @return CreateBSAVO
	 * @exception EventException
	 */
	public CreateBSAVO createBSA(BsaYearlyPlanConditionVO vo, SignOnUserAccount account) throws EventException{
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
			
			while(dbRowset.next()){
				creVo.setPFmYrwk(dbRowset.getString("fm_yrwk"));
				creVo.setPToYrwk(dbRowset.getString("to_yrwk"));
				creVo.setPInd(strOption);
				creVo.setPTrdCd(vo.getCobtrade());
				creVo.setPRlaneCd(vo.getCoblane());
				creVo.setPDirCd(vo.getCobdir());
				creVo.setPUserId(account.getUsr_id());
									
		        //[DB 실행]
				//retSaveVo = dbDao.createBSA(creVo);
			}
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
	 * ESM_BSA_0042: 조회 이벤트 처리<br>
	 * 
	 * @param BsaYearlyPlanConditionVO BsaYearlyPlanConditionVO
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchSlotCostList(BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO) throws EventException {
		List<SearchBsaCrrRgstListVO> codeArr = new ArrayList<SearchBsaCrrRgstListVO>();
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		CommonBsaRsVO[] retVoArray = new CommonBsaRsVO[2];
		
		int j = 0;
		try {
			// PDTO(Data Transfer Object including Parameters)
			retVoArray[0] = dbDao.searchBsaCrrRgstList();
			String bsaOpJbCd = JSPUtil.getNull(bsaYearlyPlanConditionVO.getBsaopjbcd()).trim();
			String crrCd       = JSPUtil.getNull(bsaYearlyPlanConditionVO.getCrrcd()).trim();
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
			
			bsaYearlyPlanConditionVO.setTxtedate(bsaYearlyPlanConditionVO.getTxtedate().replaceAll("-", ""));
			bsaYearlyPlanConditionVO.setTxtsdate(bsaYearlyPlanConditionVO.getTxtsdate().replaceAll("-", ""));
			retVoArray[1] =  dbDao.searchSlotCostList(bsaYearlyPlanConditionVO,codeArr);
							
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
	 * ESM_BSA_0041: 멀티 이벤트 처리<br>
	 * 
	 * @param BsaBudSltPrcVO[] bsaBudSltPrcVOs
	 * @param BsaBudSltPrcCrrVO[] bsaBudSltPrcCrrVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSlotCost(BsaBudSltPrcVO[] bsaBudSltPrcVOs, BsaBudSltPrcCrrVO[] bsaBudSltPrcCrrVOs, SignOnUserAccount account) throws EventException {
		try {
			List<BsaBudSltPrcVO>	mBsaBudSltPrcVOs	= new ArrayList<BsaBudSltPrcVO>();
			List<BsaBudSltPrcCrrVO>	mBsaBudSltPrcCrrVOs	= new ArrayList<BsaBudSltPrcCrrVO>();
			List<BsaBudSltPrcVO>	dBsaBudSltPrcVOs	= new ArrayList<BsaBudSltPrcVO>();
			List<BsaBudSltPrcCrrVO>	dBsaBudSltPrcCrrVOs	= new ArrayList<BsaBudSltPrcCrrVO>();
			
			for( int i=0; i<bsaBudSltPrcVOs.length; i++ ) {
				if(bsaBudSltPrcVOs[i].getIbflag().equals("I") || bsaBudSltPrcVOs[i].getIbflag().equals("U")){
					bsaBudSltPrcVOs[i].setCreUsrId(account.getUsr_id());
					bsaBudSltPrcVOs[i].setUpdUsrId(account.getUsr_id());
					mBsaBudSltPrcVOs.add(bsaBudSltPrcVOs[i]);
				} else if (bsaBudSltPrcVOs[i].getIbflag().equals("D")){
					dBsaBudSltPrcVOs.add(bsaBudSltPrcVOs[i]);
					dBsaBudSltPrcCrrVOs.add(bsaBudSltPrcCrrVOs[i]);
				}
			}
			
			for( int i=0; i<bsaBudSltPrcCrrVOs.length; i++ ) {
				if(bsaBudSltPrcCrrVOs[i].getIbflag().equals("I") || bsaBudSltPrcCrrVOs[i].getIbflag().equals("U")){
					bsaBudSltPrcCrrVOs[i].setCreUsrId(account.getUsr_id());
					bsaBudSltPrcCrrVOs[i].setUpdUsrId(account.getUsr_id());
					mBsaBudSltPrcCrrVOs.add(bsaBudSltPrcCrrVOs[i]);
				}
			}
			
			if ( mBsaBudSltPrcVOs.size() > 0 || mBsaBudSltPrcCrrVOs.size() > 0 ) {				
				dbDao.multiBsaBudSltPrc(mBsaBudSltPrcVOs);
				dbDao.multiBsaBudSltPrcCrr(mBsaBudSltPrcCrrVOs);				
			}
			
			if ( dBsaBudSltPrcVOs.size() > 0 ) {
				dbDao.removeBsaBudSltPrcCrr(dBsaBudSltPrcCrrVOs);
				dbDao.removeBsaBudSltPrc(dBsaBudSltPrcVOs);
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
	 * ESM_BSA_0042: 조회 이벤트 처리<br>
	 * 
	 * @param BsaYearlyPlanConditionVO vo
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchTEUPrcSwapVvdList(BsaYearlyPlanConditionVO vo) throws EventException {
		String[] codeArr = null;
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		CommonBsaRsVO[] retVoArray = new CommonBsaRsVO[2];
		String header ="";
		DBRowSet rowSet = new DBRowSet();
		int cnt = 1;
		
		//2014.06.30 김용습 R4J 패치 사전 작업
		String crrCd = "";
		String bsaOpJbCd = "";
		StringBuffer out1 = new StringBuffer();
		
		try {
			retVoArray[0] = dbDao.searchOpJobCarrierList(vo);
			
			rowSet = retVoArray[0].getDbRowset();
			if(rowSet != null){
				while(rowSet.next()){
					//header = header + rowSet.getString("crr_cd")+rowSet.getString("bsa_op_jb_cd");
					crrCd = rowSet.getString("crr_cd");
					bsaOpJbCd = rowSet.getString("bsa_op_jb_cd");
					
					out1.append(crrCd).append(bsaOpJbCd);
					
					if(cnt != rowSet.getRowCount()) 
						out1.append("|");
						//header = header + "|";
					cnt++;
				}
			}
			header = out1.toString();
			
			codeArr = header.split("[|]");
			
			if(rowSet != null){
				rowSet.first();
			}
			
			retVoArray[1] = dbDao.searchTEUPrcSwapVvdList(vo,codeArr);
			
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
	 * ESM_BSA_0043: 조회 이벤트 처리<br>
	 * 
	 * @param     BsaYearlyPlanConditionVO vo
	 * @return    CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchRevCostSwapVvdList(BsaYearlyPlanConditionVO vo) throws EventException{
		String[] codeArr = null;
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		CommonBsaRsVO[] retVoArray = new CommonBsaRsVO[2];
		String header ="";
		DBRowSet rowSet = new DBRowSet();
		int cnt = 1;
		
		//2014.06.30 김용습 R4J 패치 사전 작업
		String crrCd = "";
		String bsaOpJbCd = "";
		StringBuffer out1 = new StringBuffer();
		
		try {
			retVoArray[0] = dbDao.searchOpJobCarrierList(vo);
			
			rowSet = retVoArray[0].getDbRowset();
			if(rowSet != null){
				while(rowSet.next()){
					//header = header + rowSet.getString("crr_cd")+rowSet.getString("bsa_op_jb_cd");
					crrCd = rowSet.getString("crr_cd");
					bsaOpJbCd = rowSet.getString("bsa_op_jb_cd");
					
					out1.append(crrCd).append(bsaOpJbCd);
					
					if(cnt != rowSet.getRowCount()) 
						out1.append("|");
						//header = header + "|";
					cnt++;
				}
			}
			header = out1.toString();
			
			codeArr = header.split("[|]");
			
			if(rowSet != null){
				rowSet.first();
			}
			
			retVoArray[1] = dbDao.searchRevCostSwapVvdList(vo,codeArr);
			
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
	 * Target VVD 정보를 조회한다.
	 * 
	 * @param ParamCoaMonVvdYryPlnVO paramCoaMonVvdYryPlnVO
	 * @return List<RsltCoaMonVvdYryPlnVO>
	 * @exception EventException
	 */
	public List<RsltCoaMonVvdYryPlnVO> searchYearlyPlanTargetVVDList(ParamCoaMonVvdYryPlnVO paramCoaMonVvdYryPlnVO) throws EventException {
		try {
			return dbDao.searchYearlyPlanTargetVVDList(paramCoaMonVvdYryPlnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203",new String[]{"Target VVD"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203",new String[]{"Target VVD"}).getMessage(), ex);
		}
	}
	
	/**
     * 대상항차화면에 대한 배치를 실행한다.<br>
     * 
     * @param ParamCoaMonVvdYryPlnVO paramCoaMonVvdYryPlnVO
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
	public String createYearlyPlanTargetVVD(ParamCoaMonVvdYryPlnVO paramCoaMonVvdYryPlnVO, SignOnUserAccount account) throws EventException{
		BSAYearlyPlanBackEndJob backEndJob = new BSAYearlyPlanBackEndJob();
		
		paramCoaMonVvdYryPlnVO.setCreUsrId(account.getUsr_id());
		paramCoaMonVvdYryPlnVO.setUpdUsrId(account.getUsr_id());
		backEndJob.setCoaMonVvdYryPlnVO(paramCoaMonVvdYryPlnVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "Target VVD(Yearly Plan) - Creation");		
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
	public String searchBackEndJobVO(String key) throws EventException {
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
	 * ESM_BSA_0040: 생성시 정보를 조회 함.<br>
	 * 
	 * @param BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createBSABatch(BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO, SignOnUserAccount account) throws EventException{
		// Batch모듈을 직접 실행한다. 
		ScheduleUtil su = new ScheduleUtil();
		//실행 전 해당 Batch 모듈이 실행 중인지 확인한다. 
		boolean bIsRunning = false;
		try {
			bIsRunning = su.isRunning("ESM_BSA_B002");
		} catch (DAOException e) {
			throw new EventException(new ErrorHandler("BSA00001", new String[]{"BSA Creation"}).getUserMessage(),e);
		}
		log.debug("\nbIsRunning>> " + bIsRunning);
		if(bIsRunning)
			return "6";//진행 중
		else{
			String eventName = bsaYearlyPlanConditionVO.getEventName();
			String step = "";
			String only_step = "";
			
			if(eventName.equals("EsmBsa0044Event")){
				step = "2";
				only_step = "N";
			} else if(eventName.equals("EsmBsa0042Event")){
				step = "2";
				only_step = "Y";
			}
			
			String year    = bsaYearlyPlanConditionVO.getTxtyear();
			String week    = bsaYearlyPlanConditionVO.getTxtfmweek();
			int fmweek     = Integer.parseInt(week);
			int toweek     = Integer.parseInt(bsaYearlyPlanConditionVO.getTxttoweek());
			String dur     = ((toweek - fmweek)+1)+"";
			String trd     = bsaYearlyPlanConditionVO.getCobtrade();
			String rlane   = bsaYearlyPlanConditionVO.getCoblane();
			String ioc     = bsaYearlyPlanConditionVO.getCobioc();
			String vsl_cd  = bsaYearlyPlanConditionVO.getTxtvslCd();
			String voy_no  = bsaYearlyPlanConditionVO.getTxtskdVoyNo();
			String dir_cd  = bsaYearlyPlanConditionVO.getTxtdirCd();
			String user_id = (account.getUsr_id()==""?"BATCH":account.getUsr_id());
			
			//ESM_BSA_B002 2011#05#1#AES#CMEAE#O#YNBU#1049#E#userId
			log.debug(year+"#"+week+"#"+dur+"#"+step+"#"+only_step+"#"+trd+"#"+rlane+"#"+ioc+"#"+vsl_cd+"#"+voy_no+"#"+dir_cd+"#"+user_id);
			try {
				su.directExecuteJob("ESM_BSA_B002", year+"#"+week+"#"+dur+"#"+step+"#"+only_step+"#"+trd+"#"+rlane+"#"+ioc+"#"+vsl_cd+"#"+voy_no+"#"+dir_cd+"#"+user_id);
			} catch (IOException e) {
				throw new EventException(new ErrorHandler("BSA00001", new String[]{"BSA Creation"}).getUserMessage(),e);
			} catch (InterruptedException e) {
				throw new EventException(new ErrorHandler("BSA00001", new String[]{"BSA Creation"}).getUserMessage(),e);
			} catch (DAOException e) {
				throw new EventException(new ErrorHandler("BSA00001", new String[]{"BSA Creation"}).getUserMessage(),e);
			}
			return "4";//실행 성공
		}
	}
	
	/**
	 * ESM_BSA_0045: 생성 이벤트 처리<br>
	 * BSAManage화면에 대한 생성 이벤트 처리<br>
	 * 
	 * @param BsaTableSaveVO[] bsaTableSaveVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void interfaceBSAJO(BsaTableSaveVO[] bsaTableSaveVOs, SignOnUserAccount account) throws EventException{
		try{
			BsaBudJntOpBzcVO     bsaBudJntOpBzcVO     = null;
			BsaBudJntOpCrrCapaVO bsaBudJntOpCrrCapaVO = null;
			
			List<BsaBudJntOpBzcVO>     mBsaBudJntOpBzcVOs     = new ArrayList<BsaBudJntOpBzcVO>();
			List<BsaBudJntOpCrrCapaVO> mBsaBudJntOpCrrCapaVOs = new ArrayList<BsaBudJntOpCrrCapaVO>();
			
			for( int i=0; i<bsaTableSaveVOs.length; i++ ) {
				bsaBudJntOpBzcVO     = new BsaBudJntOpBzcVO();
				bsaBudJntOpCrrCapaVO = new BsaBudJntOpCrrCapaVO();
				
				bsaBudJntOpBzcVO.setBsaFmDt(bsaTableSaveVOs[i].getBsafmdt());
				bsaBudJntOpBzcVO.setBsaToDt(bsaTableSaveVOs[i].getBsatodt());
				bsaBudJntOpBzcVO.setTrdCd(bsaTableSaveVOs[i].getTrdcd());
				bsaBudJntOpBzcVO.setRlaneCd(bsaTableSaveVOs[i].getRlanecd());
				bsaBudJntOpBzcVO.setCreUsrId(account.getUsr_id());
				bsaBudJntOpBzcVO.setUpdUsrId(account.getUsr_id());
				mBsaBudJntOpBzcVOs.add(bsaBudJntOpBzcVO);
				
				bsaBudJntOpCrrCapaVO.setTrdCd(bsaTableSaveVOs[i].getTrdcd());
				bsaBudJntOpCrrCapaVO.setRlaneCd(bsaTableSaveVOs[i].getRlanecd());
				bsaBudJntOpCrrCapaVO.setCreUsrId(account.getUsr_id());
				bsaBudJntOpCrrCapaVO.setUpdUsrId(account.getUsr_id());
				mBsaBudJntOpCrrCapaVOs.add(bsaBudJntOpCrrCapaVO);
			}
			
			// BSA_BUD_JNT_OP_CRR_CAPA 테이블의 데이타 삭제
			if ( mBsaBudJntOpCrrCapaVOs.size() > 0 ) {
				dbDao.deleteBsaBudJntOpCrrCapa(mBsaBudJntOpCrrCapaVOs);
			}
			
			// BSA_BUD_JNT_OP_BZC 테이블의 데이타 삭제
			if ( mBsaBudJntOpBzcVOs.size() > 0 ) {				
				dbDao.deleteBsaBudJntOpBzc(mBsaBudJntOpBzcVOs);
			}
			
			// BSA_BUD_JNT_OP_BZC 테이블의 데이타 입력
			if ( mBsaBudJntOpBzcVOs.size() > 0 ) {				
				dbDao.insertBsaBudJntOpBzc(mBsaBudJntOpBzcVOs);
			}
			
			// BSA_BUD_JNT_OP_CRR_CAPA 테이블의 데이타 입력
			if ( mBsaBudJntOpCrrCapaVOs.size() > 0 ) {				
				dbDao.insertBsaBudJntOpCrrCapa(mBsaBudJntOpCrrCapaVOs);
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
	 * ESM_BSA_0045 : 생성 이벤트 처리<br>
	 * BSAManage화면에 대한 생성 이벤트 처리<br>
	 * 
	 * @param BsaTableSaveVO[] bsaTableSaveVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void interfaceBSASC(BsaTableSaveVO[] bsaTableSaveVOs, SignOnUserAccount account) throws EventException{
		try{
			
			BsaBudSltChtrBzcVO     bsaBudSltChtrBzcVO     = null;
			BsaBudSltChtrCrrCapaVO bsaBudSltChtrCrrCapaVO = null;
			
			List<BsaBudSltChtrBzcVO>     mBsaBudSltChtrBzcVOs     = new ArrayList<BsaBudSltChtrBzcVO>();
			List<BsaBudSltChtrCrrCapaVO> mBsaBudSltChtrCrrCapaVOs = new ArrayList<BsaBudSltChtrCrrCapaVO>();
			
			for( int i=0; i<bsaTableSaveVOs.length; i++ ) {
				bsaBudSltChtrBzcVO     = new BsaBudSltChtrBzcVO();
				bsaBudSltChtrCrrCapaVO = new BsaBudSltChtrCrrCapaVO();
				
				bsaBudSltChtrBzcVO.setBsaFmDt(bsaTableSaveVOs[i].getBsafmdt());
				bsaBudSltChtrBzcVO.setBsaToDt(bsaTableSaveVOs[i].getBsatodt());
				bsaBudSltChtrBzcVO.setTrdCd(bsaTableSaveVOs[i].getTrdcd());
				bsaBudSltChtrBzcVO.setRlaneCd(bsaTableSaveVOs[i].getRlanecd());
				bsaBudSltChtrBzcVO.setCreUsrId(account.getUsr_id());
				bsaBudSltChtrBzcVO.setUpdUsrId(account.getUsr_id());
				mBsaBudSltChtrBzcVOs.add(bsaBudSltChtrBzcVO);
				
				bsaBudSltChtrCrrCapaVO.setTrdCd(bsaTableSaveVOs[i].getTrdcd());
				bsaBudSltChtrCrrCapaVO.setRlaneCd(bsaTableSaveVOs[i].getRlanecd());
				bsaBudSltChtrCrrCapaVO.setCreUsrId(account.getUsr_id());
				bsaBudSltChtrCrrCapaVO.setUpdUsrId(account.getUsr_id());
				mBsaBudSltChtrCrrCapaVOs.add(bsaBudSltChtrCrrCapaVO);
			}
			
			// BSA_BUD_SLT_CHTR_CRR_CAPA 테이블의 데이타 삭제
			if ( mBsaBudSltChtrCrrCapaVOs.size() > 0 ) {				
				dbDao.deleteBsaBudSltChtrCrrCapa(mBsaBudSltChtrCrrCapaVOs);
			}
			
			// BSA_BUD_SLT_CHTR_BZC 테이블의 데이타 삭제
			if ( mBsaBudSltChtrBzcVOs.size() > 0 ) {				
				dbDao.deleteBsaBudSltChtrBzc(mBsaBudSltChtrBzcVOs);
			}
			
			// BSA_BUD_SLT_CHTR_BZC 테이블의 데이타 입력
			if ( mBsaBudSltChtrBzcVOs.size() > 0 ) {				
				dbDao.insertBsaBudSltChtrBzc(mBsaBudSltChtrBzcVOs);
			}
			
			// BSA_BUD_SLT_CHTR_CRR_CAPA 테이블의 데이타 입력
			if ( mBsaBudSltChtrCrrCapaVOs.size() > 0 ) {				
				dbDao.insertBsaBudSltChtrCrrCapa(mBsaBudSltChtrCrrCapaVOs);
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
	 * ESM_BSA_0045 : 생성 이벤트 처리<br>
	 * BSAManage화면에 대한 생성 이벤트 처리<br>
	 * 
	 * @param BsaTableSaveVO[] bsaTableSaveVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void interfaceSlotCost(BsaTableSaveVO[] bsaTableSaveVOs, SignOnUserAccount account) throws EventException{
		try{
			
			BsaBudSltPrcVO    bsaBudSltPrcVO    = null;
			BsaBudSltPrcCrrVO bsaBudSltPrcCrrVO = null;
			
			List<BsaBudSltPrcVO>    mBsaBudSltPrcVOs    = new ArrayList<BsaBudSltPrcVO>();
			List<BsaBudSltPrcCrrVO> mBsaBudSltPrcCrrVOs = new ArrayList<BsaBudSltPrcCrrVO>();
			
			for( int i=0; i<bsaTableSaveVOs.length; i++ ) {
				bsaBudSltPrcVO    = new BsaBudSltPrcVO();
				bsaBudSltPrcCrrVO = new BsaBudSltPrcCrrVO();
				
				bsaBudSltPrcVO.setBsaSltPrcFmDt(bsaTableSaveVOs[i].getBsafmdt());
				bsaBudSltPrcVO.setBsaSltPrcToDt(bsaTableSaveVOs[i].getBsatodt());
				bsaBudSltPrcVO.setTrdCd(bsaTableSaveVOs[i].getTrdcd());
				bsaBudSltPrcVO.setRlaneCd(bsaTableSaveVOs[i].getRlanecd());
				bsaBudSltPrcVO.setCreUsrId(account.getUsr_id());
				bsaBudSltPrcVO.setUpdUsrId(account.getUsr_id());
				mBsaBudSltPrcVOs.add(bsaBudSltPrcVO);
				
				bsaBudSltPrcCrrVO.setTrdCd(bsaTableSaveVOs[i].getTrdcd());
				bsaBudSltPrcCrrVO.setRlaneCd(bsaTableSaveVOs[i].getRlanecd());
				bsaBudSltPrcCrrVO.setCreUsrId(account.getUsr_id());
				bsaBudSltPrcCrrVO.setUpdUsrId(account.getUsr_id());
				mBsaBudSltPrcCrrVOs.add(bsaBudSltPrcCrrVO);
			}
			
			// BSA_BUD_SLT_PRC_CRR 테이블의 데이타 삭제
			if ( mBsaBudSltPrcCrrVOs.size() > 0 ) {				
				dbDao.deleteBsaBudSltPrcCrr(mBsaBudSltPrcCrrVOs);
			}
			
			// BSA_BUD_SLT_PRC 테이블의 데이타 삭제
			if ( mBsaBudSltPrcVOs.size() > 0 ) {				
				dbDao.deleteBsaBudSltPrc(mBsaBudSltPrcVOs);
			}
			
			// BSA_BUD_SLT_PRC 테이블의 데이타 입력
			if ( mBsaBudSltPrcVOs.size() > 0 ) {				
				dbDao.insertBsaBudSltPrc(mBsaBudSltPrcVOs);
			}
			
			// BSA_BUD_SLT_PRC_CRR 테이블의 데이타 입력
			if ( mBsaBudSltPrcCrrVOs.size() > 0 ) {				
				dbDao.insertBsaBudSltPrcCrr(mBsaBudSltPrcCrrVOs);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
}