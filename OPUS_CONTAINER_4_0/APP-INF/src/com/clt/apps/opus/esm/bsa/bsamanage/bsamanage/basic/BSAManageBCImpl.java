/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : BSAManageBCImpl.java
 *@FileTitle : BSA Manage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 =========================================================*/

package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration.BSAManageDBDAO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.BsaAddCarrierSaveVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.BsaHighCubicRateSaveVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.BsaManageSltPrcSaveVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.BsaOverUsedSlotCostSaveVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.BsaSlotInfoForSpcCntrSaveVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.BsaTableSaveVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.CreateBSAVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchBsaConditionVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchBsaCrrRgstListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchChgSlotSwapListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchSpcJoPortDownDetailListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchSpcJoPortDownMasterListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchSpcScPortDownDetailListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchSpcScPortDownMasterListVO;
import com.clt.apps.opus.esm.bsa.common.Utils;
import com.clt.apps.opus.esm.bsa.common.vo.CommonBsaRsVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BsaCrrInfoVO;
import com.clt.syscommon.common.table.BsaCrrRgstVO;
import com.clt.syscommon.common.table.BsaJntOpBzcVO;
import com.clt.syscommon.common.table.BsaJntOpCrrCapaVO;
import com.clt.syscommon.common.table.BsaJntOpPortDwnVO;
import com.clt.syscommon.common.table.BsaSltChtrBzcVO;
import com.clt.syscommon.common.table.BsaSltChtrCrrCapaVO;
import com.clt.syscommon.common.table.BsaSltChtrPortDwnVO;
import com.clt.syscommon.common.table.BsaSpcCtrlSwapVO;


/**
 * BSAManage Business Logic Basic Command implementation<br>
 * - Handling business logic for BSAManage<br>
 *
 * @author 
 * @see ESM_BSA_0xxEventResponse,BSAManageBC (Reference DAO Class of each)
 * @since J2EE 1.4
 */

public class BSAManageBCImpl extends BasicCommandSupport implements BSAManageBC {

	private transient BSAManageDBDAO dbDao = null;
	/**
	 * BSAManageBCImpl (Creating object)<br>
	 * Creating BSAManageDBDAO<br>
	 */
	public BSAManageBCImpl() {
		dbDao = new BSAManageDBDAO();
	}

	/**
	 * EsmBsa0021Event retrieve event process<br>
	 * BSAManage Header List retrieve<br>
	 * 
     * @author
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
	 * EsmBsa0021Event retrieve event process<br>
	 * BSAManage  selective retrieve (JO List)<br>
	 * 
     * @author
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
				
				retVoArray[0] = dbDao.searchBSATableHeaderList(bsaOpCd);
				
				
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

				
				retVoArray[1] = dbDao.searchBSATableJOList(vo,codeArr);
				
				
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
	 * EsmBsa0021Event retrieve event process<br>
	 * BSAManage  selective retrieve (SC List)<br>
	 * 
     * @author
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
				//-----------------------------------------
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
				
				
				retVoArray[1] = dbDao.searchBSATableSCList(vo,codeArr);
				

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
	 * EsmBsa0021Event retrieve event process<br>
	 * BSAManage  selective retrieve (JO)<br>
	 * 
     * @author
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
				 String fnlCoBsaCapa 	 = vos[i].getFnlcobsacapa();
				 String	coBsaBfrSubCapa = vos[i].getCobsabfrsubcapa();
				 String spcOtrSwapFlg	 = vos[i].getSpcotrswapflg();
				 String ownrVslWgt		 = vos[i].getOwnrvslwgt();
				 
				 String bsaOpCd		 = vos[i].getRdoopcd();
				 String[] bsaOpJbCd	 = vos[i].getBsaopjbcd().split("[|]");
				 String[] crrCd 	 = vos[i].getJheader().split("[|]");
				 String[] crrBsaCapa = vos[i].getCrrbsacapa().split("[|]");
				 						 
				 
				//----------------------------------------------------
				//1.modifying data in BSA_JNT_OP_BZC Table.(I/U)
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
            	 paramVo.setFnlCoBsaCapa(fnlCoBsaCapa);
            	 paramVo.setCoBsaBfrSubCapa(coBsaBfrSubCapa);
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
            	// 2. modifying data in BSA_JNT_OP_CRR_CAPA Table.(I/U)
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
               // 3. Adding SWAP Information of previous seq into BSA_SPC_CTRL_SWAP 
               //	 in case of existing SWAP Information in previous seq for adding row
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
               // 4. Adding Capa of Added data(006~019)[I]
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
             // 5. Adding port of Added data[I]
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
            	// 6. Recalculating Carrier of BSA[007] [I/U]
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
            	// 7. Recalculating carrier info with Swap info in case of exiting slot swap info of BSA.[21,24][I/U]
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
            	// 8. Cloning  Capa info of Weigth Per TEU, RF, D2, D4, D5 and D7 in previous seq.[I]
  				//------------------------------------------------------------------
            	  if(vos[i].getIbflag().equals("I")) {	
	            	  	paramVo2 = new BsaJntOpCrrCapaVO();
	            	  	
//	            	  	int srcBsaSeq =Integer.parseInt(bsaSeq) - 1;

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
            	// 9. Changing company info of BSA to  FNL_CO_BSA_CAPA [I/U]
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
            // 10. Recalculating TTL weight info in case of modifying BSA info.[21,24][I/U]
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
		                
			// 1. Modifying data in BSA_JNT_OP_BZC Table.(I/U)
			//----------------------------------------------------
		    
			 if (insertVoList.size() > 0){
				 dbDao.addMultiBsaJntOpBzc(insertVoList);
			 }
			 if (updateVoList.size() > 0){
				 dbDao.modifyMultiBsaJntOpBzc(updateVoList);
			 }
				
			// 2. Modifying data in BSA_JNT_OP_CRR_CAPA Table.(I/U) 
			//----------------------------------------------------
		   
			 if (muiltVoList.size() > 0){
				dbDao.multiBsaJntOpCrrCapa(muiltVoList);
			 }
			
			 // 3. Inserting SWAP Information of previous seq into BSA_SPC_CTRL_SWAP 
             //	 in case of existing SWAP Information in previous seq for adding row
			 
			 if (insertVoList2.size()> 0) {
		        dbDao.addBsaSpcCtrlSwap(insertVoList2);
			 }
				
			 // 4. Inserting Capa of Added data(006~019)[I] 
			 //----------------------------------------------------
		    
			 if (insertVoList3.size()> 0) {
				dbDao.addSpcJoCrrCapa(insertVoList3);
			 }
				
			// 5. Inserting Port of Added data [I]
			//----------------------------------------------------
		    
			 if (insertVoList4.size()> 0) {
				dbDao.addSpcJoPortDwn(insertVoList4);
			 }
				
			 // 6. Recalculating carrier info of BSA[007].[I/U]
			 //------------------------------------------------------------------
		     
			 if (muiltVoList2.size()> 0) {
				dbDao.modifySpcJoBsaCapa(muiltVoList2);
			 }

			 // 7. Recalculating carrier info with Swap info in case of exiting slot swap info of BSA.[21,24][I/U]
			 //------------------------------------------------------------------
		     
			 if (muiltVoList3.size()> 0) {
				dbDao.modifySpcJoSwapCapa(muiltVoList3) ;
			 }

			 // 8. Cloning  Capa info of Weigth Per TEU, RF, D2, D4, D5 and D7 in previous seq.[I]
			 //------------------------------------------------------------------
		     
			 if (insertVoList5.size()> 0) {
				dbDao.modifySpcJoOthCapa(insertVoList5);
			 }

			 //9. modifying company info of BSA to  FNL_CO_BSA_CAPA [I/U]
			 //------------------------------------------------------------------
			  
			 if (muiltVoList4.size()> 0) {
				dbDao.modifySpcJoCompanyBsaCapa(muiltVoList4);
			 }

			 // 10. Recalculating TTL weight info in case of modifying BSA info.[21,24][I/U]
			 //------------------------------------------------------------------			
			 
			 if (updateVoList2.size()> 0) {			 
					dbDao.modifySpcJoTTLWeight1(updateVoList2);
			 }
			 if (updateVoList3.size()> 0) {
					dbDao.modifySpcJoTTLWeight2(updateVoList3);
			 }

			 if (updateVoList4.size()> 0) {	
					dbDao.modifySpcJoWeightPerTEU(updateVoList4);			        
			 }
				
				//############################################################################
	
				// 6. Calculating Capa of BSA(007) for inserted of modified data 
				// 7. Recalculating Capa info with applying swap of BSA(007) for inserted of modified data 
				// 8. Cloning Capa of Weigth Per TEU, RF, D2, D4, D5 and D7 in Previous Seq to Added Row
				// 9. Calculating Capa Info of TTL Weight(009) for inserted of modified data
			    //10. Calculating Capa Info of BSA(007) Company carrier for inserted of modified data
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
	 * EsmBsa0021Event save event process<br>
	 * BSAManage  selective save (SC)<br>
	 * 
     * @author
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
				 String coFnlBsaCapa 	 = vos[i].getCofnlbsacapa();
				 String	coBsaBfrSubCapa = vos[i].getCobsabfrsubcapa();
				 String vslBsaChkFlg	 = Utils.change10ToYN(vos[i].getVslbsachkflg());
				 
				 String bsaOpCd		 = vos[i].getRdoopcd();
				 String[] bsaOpJbCd	 = vos[i].getBsaopjbcd2().split("[|]");
				 String[] crrCd 	 = vos[i].getSheader().split("[|]");
				 String[] crrBsaCapa = vos[i].getCrrbsacapa().split("[|]");
				 						 
				 
				//----------------------------------------------------
				// 1.Changing data in BSA_SLT_CHTR_BZC Table.(I/U)
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
            	 paramVo.setCoFnlBsaCapa(coFnlBsaCapa);
            	 paramVo.setCoBsaBfrSubCapa(coBsaBfrSubCapa);
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
            	// 2. Changing data in BSA_SLT_CHTR_CRR_CAPA Table.(I/U)
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
               // 3. Add Capa for added data(006~019)
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
             //4. Add Port for added data 
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
            	// 6. Recalculating Carrier info of BSA[007].[I/U]
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
            	// 8. Cloning  Capa info of Weigth Per TEU, RF, D2, D4, D5 and D7 in previous seq.[I]
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
            	//9. modifying company info of BSA to  FNL_CO_BSA_CAPA [I/U]  
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
            // 10. Recalculating TTL weight info in case of modifying BSA info.[21,24][I/U]	  
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
	        // 11. As modifying TTL Weight[I/U]
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
		                
			// 1. Modifying data in BSA_JNT_OP_BZC Table.(I/U) 
			//----------------------------------------------------
		    
			 if (insertVoList.size() > 0){
				 dbDao.addMultiBsaSltChtrBzc(insertVoList);
			 }
			 if (updateVoList.size() > 0){
				 dbDao.modifyMultiBsaSltChtrBzc(updateVoList);
			 }
			 
			// 2. Modifying data in BSA_JNT_OP_CRR_CAPA Table.(I/U)  
			//----------------------------------------------------
		   
			 if (muiltVoList.size() > 0){
				dbDao.multiBsaSltChtrCrrCapa(muiltVoList);
			 }
						
			 // 3. Add Capa for added data(006~019)
			 //----------------------------------------------------
		     
			 if (insertVoList3.size()> 0) {
				dbDao.addSpcScCrrCapa(insertVoList3);
			 }
				
			// 4. Add Port for added data [I]
			//----------------------------------------------------
		    
			 if (insertVoList4.size()> 0) {
				dbDao.addSpcScPortDwn(insertVoList4);
			 }
			 
			 // 6. Recalculating Carrier Info of BSA[007].[I/U]
			 //------------------------------------------------------------------
		     
			 if (muiltVoList2.size()> 0) {
				dbDao.modifySpcScBsaCapa(muiltVoList2);
			 }

			
			 // 8. Cloning  Capa info of Weigth Per TEU, RF, D2, D4, D5 and D7 in previous seq.[I]
			 //------------------------------------------------------------------
		     
			 if (insertVoList5.size()> 0) {
				dbDao.modifySpcScOthCapa(insertVoList5);
			 }

			 //9. modifying company info of BSA to  FNL_CO_BSA_CAPA [I/U]
			 //------------------------------------------------------------------
			
			 if (muiltVoList4.size()> 0) {
				dbDao.modifySpcScCompanyBsaCapa(muiltVoList4);
			 }

			 // 10. Recalculating TTL weight info in case of modifying BSA info.[21,24][I/U]
			 //------------------------------------------------------------------			
			
			 if (updateVoList2.size()> 0) {			 
					dbDao.modifySpcScTTLWeight(updateVoList2);
			 }

			 // 11. As modifying TTL Weight[I/U]
			 //------------------------------------------------------------------
    		 
			 if (updateVoList4.size()> 0) {	
					dbDao.modifySpcScWeightPerTEU(updateVoList4);			        
			 }
				
				//############################################################################
	
		 
			    // 6. Calculating Capa of BSA(007) for inserted of modified data 
			    // 7. Recalculating Capa info with applying swap of BSA(007) for inserted of modified data 
			    // 8. Cloning Capa of Weigth Per TEU, RF, D2, D4, D5 and D7 in Previous Seq to Added Row
			    // 9. Calculating Capa Info of TTL Weight(009) for inserted of modified data (BSA[007] * Weight Per TEU[008])
			    //10. Calculating Capa Info of BSA(007) Company carrier for inserted of modified data
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
	 * EsmBsa0021Event remove event process<br>
	 * BSAManage  selective retrieve (JO)<br>
	 * 
     * @author
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
	 * EsmBsa0021Event remove event process<br>
	 * BSAManage  selective retrieve (SC)<br>
	 * 
     * @author
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
	 * EsmBsa0021Event create event process<br>
	 * BSAManage  BSA Create<br>
	 * 
     * @author
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
	 * EsmBsa0023Event retrieve event process<br>
	 * BSAManage  CarrierRegister retrieve<br>
	 * 
     * @author
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
	 * EsmBsa0023Event modify event process<br>
	 * BSAManage  CarrierRegister modify<br>
	 * 
     * @author
     * @param BsaAddCarrierSaveVO[] vos
     * @param SignOnUserAccount account
     * @exception EventException
     */	
	public void modifyCarrierRegister(BsaAddCarrierSaveVO[] vos, SignOnUserAccount account) throws EventException{
		try{	
				List<BsaAddCarrierSaveVO> updateVoList  = new ArrayList<BsaAddCarrierSaveVO>();	
				String bsaOpCd ="";
				// Modifying data in BSA_CRR_RGST Table.(I/U)
				//----------------------------------------------------
                    for(int i = 0 ; i < vos.length ; i++){
                    	if(i==0) bsaOpCd = vos[i].getBsaOpCd();
                        if(vos[i].getIbflag().equals("U")) {
                        	
                        	vos[i].setCreUsrId(account.getUsr_id());
                        	vos[i].setUpdUsrId(account.getUsr_id());
                        	
                        	updateVoList.add(vos[i]);                      	
                        }
                    }	
                
                if (bsaOpCd.equals("J")){
				
					if ( updateVoList.size() > 0 ) {
						dbDao.modifyCarrierRegisterJO(updateVoList);
					}
                }else{
					
                	if ( updateVoList.size() > 0 ) {
                		dbDao.addCarrierRegisterSC(updateVoList);
                		dbDao.modifyCarrierRegisterSC(updateVoList);
					}
					
				}

		
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}	


	/**
	 * EsmBsa0026Event retreive event process<br>
	 * BSAManage  Jo Port Down Master retreive<br>
	 * 
     * @author
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
	 * EsmBsa0026Event retreive event process<br>
	 * BSAManage  Jo Port Down Detail retreive<br>
	 * 
     * @author
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
	 * EsmBsa0026Event retreive event process<br>
	 * BSAManage  SC Port Down master retreive<br>
	 * 
     * @author
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
	 * EsmBsa0026Event retreive event process<br>
	 * BSAManage  SC Port Down detail retreive<br>
	 * 
     * @author
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
	 * EsmBsa0026Event modify event process<br>
	 * BSAManage  Jo Port Down modify<br>
	 * 
     * @author
     * @param SearchBsaConditionVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */	
	public void resetSpcJoPortDown( SearchBsaConditionVO vo, SignOnUserAccount account) throws EventException{
		try {
			String updUsrId = account.getUsr_id();
			
			// 1. Modifying data in BSA_SLT_CHTR_BZC Table.(I/U)
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
	 * EsmBsa0026Event create event process<br>
	 * BSAManage  Jo Port Down create<br>
	 * 
     * @author
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
	 * EsmBsa0026Event modify event process<br>
	 * BSAManage  Jo Port Down master modify<br>
	 * 
     * @author
     * @param BsaJntOpCrrCapaVO[] vos
     * @param SignOnUserAccount account
     * @exception EventException
     */	
	public void multiSPCDownPortJOMaster(BsaJntOpCrrCapaVO[] vos, SignOnUserAccount account) throws EventException{
		try{

				List<BsaJntOpCrrCapaVO> updateVoList = new ArrayList<BsaJntOpCrrCapaVO>();
		                
				// 1. Modifying data in BSA_SLT_CHTR_BZC Table.(I/U)
				//----------------------------------------------------
                    for(int i = 0 ; i < vos.length ; i++){
                        if(vos[i].getIbflag().equals("U")) {
                        	vos[i].setUpdUsrId(account.getUsr_id());
                        	updateVoList.add(vos[i]);                      	
                        }
                    }	
				
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
	 * EsmBsa0026Event modify event process<br>
	 * BSAManage  Jo Port Down Detail modify<br>
	 * 
     * @author
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

				// 1. Modifying data in BSA_SLT_CHTR_BZC Table.(I/U)
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
	 * EsmBsa0026Event modify event process<br>
	 * BSAManage  SC Port Down modify<br>
	 * 
     * @author
     * @param SearchBsaConditionVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */	
	public void resetSpcScPortDown(SearchBsaConditionVO vo, SignOnUserAccount account) throws EventException{
		try{
			String updUsrId = account.getUsr_id();
				
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
	 * EsmBsa0026Event create event process<br>
	 * BSAManage  SC Port Down create<br>
	 * 
     * @author
     * @param SearchBsaConditionVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */	
	public void createSpcScPortDown(SearchBsaConditionVO vo, SignOnUserAccount account) throws EventException{
		try{
			String usrId = account.getUsr_id();  			
				
				dbDao.removeSpcScPortDownDetail(vo);
				//############################################################################
                
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
	 * EsmBsa0026Event modify event process<br>
	 * BSAManage  SC Port Down master modify<br>
	 * 
     * @author
     * @param BsaSltChtrCrrCapaVO[] vos
     * @param SignOnUserAccount account
     * @exception EventException
     */	
	public void multiSPCDownPortSCMaster(BsaSltChtrCrrCapaVO[] vos, SignOnUserAccount account) throws EventException{
		try{
				
				List<BsaSltChtrCrrCapaVO> updateVoList = new ArrayList<BsaSltChtrCrrCapaVO>();     

				// 1. Modifying data in BSA_SLT_CHTR_BZC Table.(I/U)
				//----------------------------------------------------
                
				 for(int i = 0 ; i < vos.length ; i++){
                     if(vos[i].getIbflag().equals("U")) {
                     	vos[i].setUpdUsrId(account.getUsr_id());
                     	updateVoList.add(vos[i]);                      	
                     }
                 }		
				
				
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
	 * EsmBsa0026Event modify event process<br>
	 * BSAManage  SC Port Down detail modify<br>
	 * 
     * @author
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
	
			// 1. Modifying data in BSA_SLT_CHTR_BZC Table.(I/U)
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
	 * EsmBsa0024Event & EsmBsa0104Event retrieve event process<br>
	 * BSAManage Carrier Item retrieve<br>
	 * 
     * @author
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
	 * EsmBsa0024Event retrieve event process<br>
	 * BSAManage BSAManage SPC Control J/O list retrieve<br>
	 * 
     * @author
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
			
			//SJH.20150507.소스품질
			if(codeArr != null) {
				retVo = dbDao.searchSpcJoBSA(vo,codeArr);
			} else {
				retVo = dbDao.searchSpcJoBSA(vo,null);
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
	 * EsmBsa0024Event modify event process<br>
	 * BSAManage BSAManage SPC Control J/O list modify<br>
	 * 
     * @author
     * @param BsaSlotInfoForSpcCntrSaveVO[] vos
	 * @param SignOnUserAccount account
     * @exception EventException
     */	
	public void multiSPCJOBSA(BsaSlotInfoForSpcCntrSaveVO[] vos, SignOnUserAccount account) throws EventException{
		try{
			
			String updUsrId	= account.getUsr_id();
			String bsaOpJbCd ="";
			String bsaOpCd	 ="";
			String companyCode = ConstantMgr.getCompanyCode();
			
			List<BsaJntOpCrrCapaVO> updateList = new ArrayList<BsaJntOpCrrCapaVO>();
			List<BsaJntOpCrrCapaVO> updateList1 = new ArrayList<BsaJntOpCrrCapaVO>();
			List<BsaJntOpCrrCapaVO> updateList2 = new ArrayList<BsaJntOpCrrCapaVO>();
			List<BsaJntOpBzcVO> updateList3 = new ArrayList<BsaJntOpBzcVO>();
			List<BsaJntOpCrrCapaVO> updateList4 = new ArrayList<BsaJntOpCrrCapaVO>();
			List<BsaJntOpPortDwnVO> updateList5 = new ArrayList<BsaJntOpPortDwnVO>();
			
			for ( int i=0; i<vos .length; i++ ) {
				bsaOpJbCd= vos[i].getRdoopjbcd();
				bsaOpCd	= vos[i].getRdoopcd();
				
				String bsaSeq 	= vos[i].getBsaSeq();
				String trdCd  	= vos[i].getTrdCd();
				String rlaneCd	= vos[i].getRlaneCd();
				String dirCd	= vos[i].getDirCd();
				String vslCapa	= vos[i].getVslCapa();
				String vopCd	= vos[i].getVopCd();
				String ownrVslWgt = vos[i].getOwnrVslWgt();
				String fnlCoBsaCapa=vos[i].getFnlCoBsaCapa();
				
				String crrCdTmp = vos[i].getJheader() + "|"+companyCode;
				String spcCtrlSltCapaTmp = vos[i].getHeaderCapa()+fnlCoBsaCapa;
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
				
				// 1. Modifying TTL Weight with modifying BSA, Weight Per TEU.
				//    - Updating All Carrier data
				//    - Updating Company data in case of  ownr_vsl_wgt > 0 in BSA_JNT_OP_BZC Table
				//      (OWNR_VSL_WGT-SUM(CARRIERS[ except (CompanyCode)]))
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
				// 2. Changing Own Vessel Weight in BSA_JNT_OP_BZC Table.
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
				// 3. Changing Weight Per TEU in case of Changing BSA and TTL Weight
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
				
				// 4. Changing COA_BSA_JNT_OP_PORT_DWN in case of Changing BSA 
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
	 * EsmBsa0024Event retrieve event process<br>
	 * BSAManage BSAManage SPC Control J/O POPUP List retrieve<br>
	 * 
     * @author
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
	 * EsmBsa0024Event save event process<br>
	 * BSAManage BSAManage SPC Control J/O POPUP List save<br>
	 * 
     * @author
     * @param BsaSpcCtrlSwapVO[] VOs
	 * @param SearchBsaConditionVO VO
	 * @param SignOnUserAccount account
     * @exception EventException
     */	
	public void multiChgSlotSwap(BsaSpcCtrlSwapVO[] VOs,SearchBsaConditionVO VO, SignOnUserAccount account) throws EventException{
		try{
			List<BsaSpcCtrlSwapVO> insertVoList = new ArrayList<BsaSpcCtrlSwapVO>();
			List<BsaSpcCtrlSwapVO> updateVoList = new ArrayList<BsaSpcCtrlSwapVO>();
			List<BsaSpcCtrlSwapVO> deleteVoList = new ArrayList<BsaSpcCtrlSwapVO>();
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
			crrVo.setDirCd(vopCd);
			crrVo.setVopCd(vopCd);
			crrVo.setVslCapa(vslCapa);
			crrVo.setBsaOpCd(bsaOpCd);
			crrVo.setBsaOpJbCd(bsaOpJbCd);
			
			if(VOs.length > 0){
				 for(int i = 0 ; i < VOs.length ; i++){
					if(VOs[i].getIbflag().equals("I")||VOs[i].getIbflag().equals("U")){
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
							
						if(Integer.parseInt(VOs[i].getCrrSwapCapa()) > 0){
							insertVoList.add(VOs[i]);
						}
						if (i==0){
							updateVoList.add(VOs[i]);
							deleteVoList.add(VOs[i]);
							updateVoList2.add(crrVo);
							
							log.debug("Delete Data : ["+bsaSeq+"]["+trdCd+"]["+laneCd+"]["+dirCd+"]["+vopCd+"]["+vslCapa+"]["+bsaOpCd+"]["+bsaOpJbCd+"]");
						}
					}
				 }
			}

			// 1.Modifying data in BSA_JNT_OP_BZC Table.(I/U)
			//----------------------------------------------------
			if ( insertVoList.size() > 0 ) {
				dbDao.removemultiChgSlotSwap(deleteVoList);
				dbDao.addmultiChgSlotSwap(insertVoList);
				dbDao.modifyemultiChgSlotSwap(updateVoList);
				log.debug( "multiChgSlotSwap-01");
			}
		        
			// 2. Modifying spc_ctrl_slt_capa in BSA_JNT_OP_CRR_CAPA Table with Solt Swap Info
			//----------------------------------------------
			if ( insertVoList.size() > 0 ) {
				dbDao.modifySpcJoSwapCapa(updateVoList2);
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
	 * EsmBsa0024Event retrieve event process<br>
	 * BSAManage BSAManage SPC Control J/O List retrieve<br>
	 * 
     * @author
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
			
			//SJH.20150507.소스품질
			if(codeArr != null) {
				retVo = dbDao.searchSpcScBSA(vo,codeArr);
			} else {
				retVo = dbDao.searchSpcJoBSA(vo,null);
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
	 * EsmBsa0025Event save event process<br>
	 * BSAManage BSAManage SPC Control J/O List save<br>
	 * 
     * @author
     * @param BsaSlotInfoForSpcCntrSaveVO[] vos
	 * @param SignOnUserAccount account
     * @exception EventException
     */		
	public void multiSPCSCBSA(BsaSlotInfoForSpcCntrSaveVO[] vos, SignOnUserAccount account) throws EventException{
		try{
			String updUsrId	= account.getUsr_id();
			String bsaOpJbCd ="";
			String bsaOpCd	 ="";
			String companyCode = ConstantMgr.getCompanyCode();
			
			List<BsaSltChtrCrrCapaVO> updateList  = new ArrayList<BsaSltChtrCrrCapaVO>();
			List<BsaSltChtrCrrCapaVO> updateList2 = new ArrayList<BsaSltChtrCrrCapaVO>();
			List<BsaSltChtrCrrCapaVO> updateList3 = new ArrayList<BsaSltChtrCrrCapaVO>();
			List<BsaSltChtrPortDwnVO> updateList4 = new ArrayList<BsaSltChtrPortDwnVO>();
			
			for ( int i=0; i<vos .length; i++ ) {
				bsaOpJbCd= vos[i].getRdoopjbcd2();
				bsaOpCd	= vos[i].getRdoopcd();
				
				String bsaSeq 	= vos[i].getBsaSeq();
				String trdCd  	= vos[i].getTrdCd();
				String rlaneCd	= vos[i].getRlaneCd();
				String dirCd	= vos[i].getDirCd();
				String vslSeq	= vos[i].getVslSeq();
				String fnlCoBsaCapa=vos[i].getFnlCoBsaCapa();
				
				String crrCdTmp = vos[i].getSheader() + "|"+companyCode;
				String spcCtrlSltCapaTmp = vos[i].getHeaderCapa()+fnlCoBsaCapa;
				String[] crrCd	= crrCdTmp.split("[|]");
				String[] spcCtrlSltCapa = spcCtrlSltCapaTmp.split("[|]");
				
				// 1. Changing info in BSA_SLT_CHTR_CRR_CAPA Table .
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
				// 2. Changing TTL Weight in case of modifying BSA, Weight Per TEU.
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
				// 3. Changing Weight Per TEU in case of modifying TTL Weight.
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
				// 4. Changing COA_BSA_SLT_CHTR_PORT_DWN in case of modifying BSA.
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
	 * EsmBsa0120Event retrieve event process<br>
	 * BSAManage carrier info list retrieve<br>
	 * 
     * @author
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
	 * EsmBsa0120Event save event process<br>
	 * BSAManage carrier info list save<br>
	 * 
     * @author
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
	 * EsmBsa0172Event retrieve event process<br>
	 * BSAManage BSA rate list retrieve<br>
	 * 
     * @author
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
			
			//SJH.20150507.소스품질
			if(codeArr != null) {
				rsVo = dbDao.searchBSARateList(vo,codeArr);
			} else {
				rsVo = dbDao.searchBSARateList(vo,null);
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
	 * EsmBsa0172Event save event process<br>
	 * BSAManage BSA rate list save<br>
	 * 
     * @author
     * @param BsaHighCubicRateSaveVO[] VOs
	 * @param SignOnUserAccount account
	 * @param Event e
     * @exception EventException
     * @return String
     */	
	public String multiBSARate(BsaHighCubicRateSaveVO[] vos, SignOnUserAccount account, Event e) throws EventException{
		try {
			String result = "S";						//20150819.ADD
			int[] checkCnt = new int[] {0,0};			//20150819.ADD		
			
			for ( int i=0; i<vos .length; i++ ) {
				
				vos[i].setHeader2("|"+vos[i].getHeader2() + "|");
				//20150615.ADD : 기존에 Arrwtnrate 안들어감 D3, D5만 Arrovrrate 와 같은값 세팅
				if (e.getFormCommand().isCommand(FormCommand.MULTI)||e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					vos[i].setArrwtnrate( vos[i].getArrovrrate()+"|" );
				} else {
					vos[i].setArrwtnrate( vos[i].getArrwtnrate()+"|" );
				}
				vos[i].setArrratetype(vos[i].getArrratetype()+"|" );
				vos[i].setArrovrrate( vos[i].getArrovrrate()+"|" );
				vos[i].setUpdUsrId(account.getUsr_id());
				
				//insert 경우만 : 20150819.ADD/MOD
				if ( vos[i].getIbflag().equals("I")){
					 checkCnt = dbDao.checkBSARate(vos[i]);		//Dup Check, get Max Seq 
					 if(checkCnt[0] == 0 && checkCnt[1] == 0){
						 dbDao.multiBSARateIndv(vos[i]);
					 }else{
						if(checkCnt[0] > 0)
							result = "Dup";
						else if(checkCnt[1] > 0)
							result = "Over";
					 }	
			    // update, delete는 잘못넣은 데이타인경우 본인책임.후 수정요청오면 keyfield를 막는다.
				} else {
					dbDao.multiBSARateIndv(vos[i]);
				}	
						
			}
			return result;
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	/**
	 * EsmBsa0162Event retrieve event process<br>
	 * BSAManage BSA register retrieve<br>
	 * 
     * @author
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
	 * EsmBsa0162Event retrieve event process<br>
	 * BSAManage Used slot cost retrieve<br>
	 * 
     * @author
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
	 * EsmBsa0162Event save event process<br>
	 * BSAManage Used slot cost save<br>
	 * 
     * @author
     * @param BsaOverUsedSlotCostSaveVO[] VOs
	 * @param SignOnUserAccount account
     * @exception EventException
     * @return String
     */	
	public String multiOverUsedSlotCost(BsaOverUsedSlotCostSaveVO[] vos, SignOnUserAccount account) throws EventException {
		try {
			String result = "S";						//20150819.ADD
			int[] checkCnt = new int[] {0,0};			//20150819.ADD
			
			for ( int i=0; i<vos .length; i++ ) {
				
				vos[i].setCrrCd(vos[i].getCrrCd() + "|");
				vos[i].setBsaOpJbCd( vos[i].getBsaOpJbCd()+"|" );
				vos[i].setCreUsrId(account.getUsr_id());
				
				//insert 경우만 : 20150819.ADD/MOD
				if ( vos[i].getIbflag().equals("I")){
					 checkCnt = dbDao.checkSlotCost(vos[i]);		//Dup Check, get Max Seq 
					 if(checkCnt[0] == 0 && checkCnt[1] == 0){
						 dbDao.multiOverUsedSlotCostIndv(vos[i]);
					 }else{
						if(checkCnt[0] > 0)
							result = "Dup";
						else if(checkCnt[1] > 0)
							result = "Over";
					 }	
			    // update, delete는 잘못넣은 데이타인경우 본인책임.후 수정요청오면 keyfield를 막는다.
				} else {
					dbDao.multiOverUsedSlotCostIndv(vos[i]);
				}				
			}			
			return result;
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	/**
	 * EsmBsa0172Event retrieve event process<br>
	 * BSAManage carrier register list retrieve<br>
	 * 
     * @author
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
	 * EsmBsa0028Event retrieve event process<br>
	 * BSAManage carrier register list retrieve<br>
	 * 
     * @author
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
	 * EsmBsa0028Event retrieve event process<br>
	 * BSAManage slot cost list retrieve<br>
	 * 
     * @author
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
	 * EsmBsa0028Event retrieve event process<br>
	 * BSAManage RF cost list retrieve<br>
	 * 
     * @author
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
				
				//SJH.20150507.소스품질
				if(codeArr != null) {
					retVoArray[0] =  dbDao.searchRFCostList(vo,codeArr);
				} else {
					retVoArray[0] =  dbDao.searchRFCostList(vo,null);
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
		 * EsmBsa0028Event retrieve event process<br>
		 * BSAManage over cost list retrieve<br>
		 * 
	     * @author
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
				
//				vo.setTxtedate(vo.getTxtedate().replaceAll("-", ""));
				vo.setTxtsdate(vo.getTxtsdate().replaceAll("-", ""));
				
				String rdoType2 = vo.getRdotype2();
				
				if(rdoType2.equals("0")){
					vo.setRdotype("020");
				}
				if(rdoType2.equals("1")){
					vo.setRdotype("021");
				}
				
				//SJH.20150507.소스품질
				if(codeArr != null) {
					retVoArray[0] =  dbDao.searchOverCostList(vo,codeArr);
				} else {
					retVoArray[0] =  dbDao.searchOverCostList(vo,null);
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
		 * EsmBsa0028Event save event process<br>
		 * BSAManage slot cost save<br>
		 * 
	     * @author
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
	 * EsmBsa0028Event save event process<br>
	 * BSAManage RF cost save<br>
	 * 
     * @author
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
	 * EsmBsa0028Event save event process<br>
	 * BSAManage Over cost save<br>
	 * 
     * @author
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
	 * EsmBsa0028Event retrieve event process<br>
	 * BSAManage op slot cost list retrieve<br>
	 * 
     * @author
     * @param SearchBsaConditionVO searchBsaConditionVO
     * @return CommonBsaRsVO
     * @exception EventException
     * @author 20150514.ADD
     */	
	public CommonBsaRsVO searchOpSlotCostList(SearchBsaConditionVO searchBsaConditionVO) throws EventException {
		
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
			retVoArray[1] =  dbDao.searchOpSlotCostList(searchBsaConditionVO,codeArr);
							
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
	 * EsmBsa0028Event save event process<br>
	 * BSAManage slot cost save<br>
	 * 
     * @author
     * @param BsaManageSltPrcSaveVO[] VOs
     * @param SignOnUserAccount account
     * @param Event e
     * @return String
     * @exception EventException
     * @author 20150514.ADD
     */			
public String multiOpSlotCost(BsaManageSltPrcSaveVO[] VOs, SignOnUserAccount account, Event e) throws EventException {
	try {
		List<BsaManageSltPrcSaveVO> voList1 = new ArrayList<BsaManageSltPrcSaveVO>();
		List<BsaManageSltPrcSaveVO> voList2 = new ArrayList<BsaManageSltPrcSaveVO>();
		List<BsaManageSltPrcSaveVO> deleteVoList = new ArrayList<BsaManageSltPrcSaveVO>();
		List<BsaManageSltPrcSaveVO> batchVoList = new ArrayList<BsaManageSltPrcSaveVO>();
		String trdCd ="";
		String rlaneCd="";
		String dirCd="";
		String vslCapa="";
		String prcSeq="";
		int[] checkCnt = new int[] {0,0};
		String result = "S";
		int batCnt[] = null;																					//20150527.ADD
		
		for ( int i=0; i<VOs.length; i++ ) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI06)) {												//20150518.ADD : 엑셀로 로드한 경우
				if ( trdCd.equals(VOs[i].getTrdCd()) && rlaneCd.equals(VOs[i].getRlaneCd()) &&
					 dirCd.equals(VOs[i].getDirCd()) && vslCapa.equals(VOs[i].getVslCapa()) && 
					 (i>0 && VOs[i].getBsaSltPrcFmDt().equals(VOs[i-1].getBsaSltPrcFmDt())))
				{
					VOs[i].setSltPrcSeq(prcSeq);
				}
			}
			if ( trdCd.equals(VOs[i].getTrdCd()) && rlaneCd.equals(VOs[i].getRlaneCd()) &&
				 dirCd.equals(VOs[i].getDirCd()) && vslCapa.equals(VOs[i].getVslCapa()) && 
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
					//20150518.ADD : 엑셀로 로드한 경우					
					if(e.getFormCommand().isCommand(FormCommand.MULTI06)) {
						
						checkCnt = dbDao.checkOpSltInt(VOs[i]);		//Dup Check, get Max Seq 		
						
						if(checkCnt[0] == 0){
							VOs[i].setSltPrcSeq(String.valueOf(checkCnt[1]));
							dbDao.multiBsaOpSltPrcDtl(VOs[i]);
							dbDao.multiBsaOpSltPrcCrrDtl(VOs[i]);
							batchVoList.add(VOs[i]);
						} else {
							result = "Not";
						}
					} else {
						voList1.add(VOs[i]);
						voList2.add(VOs[i]);
					}					
				} else if ( VOs[i].getIbflag().equals("D")
						|| !VOs[i].getSltPrcSeq().equals(VOs[i].getSltPrcSeqOrg()) ){
					deleteVoList.add(VOs[i]);						
				}
			}
						
			trdCd =VOs[i].getTrdCd();
			rlaneCd=VOs[i].getRlaneCd();
			dirCd=VOs[i].getDirCd();
			vslCapa=VOs[i].getVslCapa();
			prcSeq=VOs[i].getSltPrcSeq(); 		
		}
						
		if ( voList1.size() > 0 || voList2.size() > 0 ) {				
			dbDao.multiBsaOpSltPrc(voList1);
			dbDao.multiBsaOpSltPrcCrr(voList2);	
		}
		
		if ( deleteVoList.size() > 0 ) {
			dbDao.removeBsaOpSltPrc(deleteVoList);
		}
		
		//20150527.ADD
		if (e.getFormCommand().isCommand(FormCommand.MULTI06) && batchVoList.size() > 0) {
			batCnt = dbDao.batchUpOpSltPrc(batchVoList, e);
			log.debug("######## batch update cnt : "+batCnt.length);
		}		
		
		return result;
		
	} catch (DAOException ex) {
		//log.error("err " + ex.toString(), ex);
		throw new EventException(ex.getMessage(),ex);
	} catch (Exception ex) {
		//log.error("err " + ex.toString(), ex);
		throw new EventException(ex.getMessage(),ex);
	}
	
}	

/**
 * EsmBsa0024Event & EsmBsa0104Event retrieve event process<br>
 * BSAManage Carrier Item retrieve<br>
 * 
 * @author
 * @param String bsaOpCd
 * @return String
 * @exception EventException
 */	
public String searchCarrierItem2(String bsaOpCd) throws EventException {
	log.debug("################# BSAManageBCImpl.searchCarrierItem() ############################[START]");
	StringBuffer strItem = new StringBuffer();
	try {
		List<BsaCrrRgstVO> list = dbDao.searchCarrierItem2(bsaOpCd);
		
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
 * EsmBsa0172Event retrieve event process<br>
 * BSAManage carrier register list retrieve<br>
 * 
 * @author
 * @return String
 * @exception EventException
 */	
public String searchBsaCrrRgstList3() throws EventException {
	try {
		String headSet = this.searchCarrierItem2("");
		
		return headSet;
	} catch (Exception ex) {
		throw new EventException(ex.getMessage(),ex);
	}
}

}