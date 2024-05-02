/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName           : SPCManageBCImpl.java
 *@FileTitle          : SPC Manage
 *Open Issues         :
 *Change history      :
 *@LastModifyDate     : 
 *@LastModifier       : 
 *@LastVersion        : 1.0

 =========================================================*/

package com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.integration.SPCManageDBDAO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.BsaSpcSlotInfoByVvdSaveVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.DailyBatchConditionVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchOpJobCarrierListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchSpcConditionVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchSpcSlotInfoByVvdOnVesselListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchSpcSlotSwapByVvdListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchStepUpDownVvdDetailListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchStepUpDownVvdMasterListVO;
import com.clt.apps.opus.esm.bsa.common.Utils;
import com.clt.apps.opus.esm.bsa.common.vo.CommonBsaRsVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BsaVvdMstVO;
import com.clt.syscommon.common.table.BsaVvdOtrCrrVO;
import com.clt.syscommon.common.table.BsaVvdPortDwnVO;
import com.clt.syscommon.common.table.BsaVvdSwapInfoVO;

/**
 * SPCManage Business Logic Basic Command implementation<br>
 * - Handling business logic for SPCManage.<br>
 *
 * @author 
 * @see ESM_BSA_0xxEventResponse,BSAManageBC (Reference DAO Class of each)
 * @since J2EE 1.4
 */
public class SPCManageBCImpl extends BasicCommandSupport implements SPCManageBC {

	private transient SPCManageDBDAO dbDao = null;

	/**
	 * SPCManageBCImpl (Creating object)<br>
	 * Creating SPCManageDBDAO<br> 
	 */
	public SPCManageBCImpl() {
		dbDao = new SPCManageDBDAO();
	}

	/**
	 * EsmBsa0030Event retreive event process<br>
	 * BSAManage  op job Carrier retreive<br>
	 * 
     * @author
     * @param SearchSpcConditionVO vo
     * @return CommonBsaRsVO
     * @exception EventException
     */	
	@SuppressWarnings("unchecked")
	public CommonBsaRsVO searchOpJobCarrierList(SearchSpcConditionVO vo) throws EventException {
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		List<SearchOpJobCarrierListVO>list = null;
		try {
						
			rsVo = dbDao.searchOpJobCarrierList(vo);
			
			list = (List)RowSetUtil.rowSetToVOs(rsVo.getDbRowset(), SearchOpJobCarrierListVO .class);
			rsVo.setResultVOList(list);
			return rsVo;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}


	/**
	 * EsmBsa0030Event retreive event process<br>
	 * BSAManage  supply swap vvd list retreive<br>
	 * 
     * @author
     * @param  SearchSpcConditionVO vo
     * @return CommonBsaRsVO
     * @exception EventException
     */	
	public CommonBsaRsVO searchSupplySwapVvdList(SearchSpcConditionVO vo) throws EventException {
		String[] codeArr = null;
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		CommonBsaRsVO[] retVoArray = new CommonBsaRsVO[2];
		String header ="";
		DBRowSet rowSet = new DBRowSet();
		int cnt = 1;
		
		try {
			retVoArray[0] = dbDao.searchOpJobCarrierList(vo);
			
			rowSet = retVoArray[0].getDbRowset();
			
			if(rowSet != null){
				StringBuffer sb1 = new StringBuffer();													//SJH.20150508.소스품질
				while(rowSet.next()){
//					header = header + rowSet.getString("crr_cd")+rowSet.getString("bsa_op_jb_cd");  
//					if(cnt != rowSet.getRowCount()) header = header + "|";
					//SJH.20150508.소스품질
					sb1.append(rowSet.getString("crr_cd")).append(rowSet.getString("bsa_op_jb_cd"));
					if(cnt != rowSet.getRowCount()) sb1.append("|");
					header = sb1.toString();					
					cnt++;
				}
			}
			
			codeArr = header.split("[|]");
			if(rowSet != null)	rowSet.first();															//20150522.소스품질
			//SJH.20150508.소스품질
			if(codeArr != null) {
				retVoArray[1] = dbDao.searchSupplySwapVvdList(vo,codeArr);
			} else {
				retVoArray[1] = dbDao.searchSupplySwapVvdList(vo,null);
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
	 * EsmBsa0030Event retreive event process<br>
	 * BSAManage  slot price retreive<br>
	 * 
     * @author
     * @param SearchSpcConditionVO vo
     * @return CommonBsaRsVO
     * @exception EventException
     */	
	public CommonBsaRsVO searchSlotPrcSwapVvdList(SearchSpcConditionVO vo) throws EventException {
			String[] codeArr = null;
			CommonBsaRsVO rsVo = new CommonBsaRsVO();
			CommonBsaRsVO[] retVoArray = new CommonBsaRsVO[2];
			String header ="";
			DBRowSet rowSet = new DBRowSet();
			int cnt = 1;
			
			try {
				retVoArray[0] = dbDao.searchOpJobCarrierList(vo);
				
				rowSet = retVoArray[0].getDbRowset();
				if(rowSet != null){
					StringBuffer sb1 = new StringBuffer();													//SJH.20150508.소스품질
					while(rowSet.next()){
//						header = header + rowSet.getString("crr_cd")+rowSet.getString("bsa_op_jb_cd");
//						if(cnt != rowSet.getRowCount()) header = header + "|";						
						//SJH.20150508.소스품질
						sb1.append(rowSet.getString("crr_cd")).append(rowSet.getString("bsa_op_jb_cd"));
						if(cnt != rowSet.getRowCount()) sb1.append("|");
						header = sb1.toString();						
						cnt++;
					}
				}
				
				codeArr = header.split("[|]");
				if(rowSet != null)	rowSet.first();															//20150522.소스품질
				//SJH.20150508.소스품질
				if(codeArr != null) {
					retVoArray[1] = dbDao.searchSlotPrcSwapVvdList(vo,codeArr);
				} else {
					retVoArray[1] = dbDao.searchSlotPrcSwapVvdList(vo,null);
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
	 * EsmBsa0030Event retreive event process<br>
	 * BSAManage  TEU & Slot Price retreive<br>
	 * 
     * @author
     * @param SearchSpcConditionVO vo
     * @return CommonBsaRsVO
     * @exception EventException
     */	
	public CommonBsaRsVO searchTEUPrcSwapVvdList(SearchSpcConditionVO vo) throws EventException {
		String[] codeArr = null;
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		CommonBsaRsVO[] retVoArray = new CommonBsaRsVO[2];
		String header ="";
		DBRowSet rowSet = new DBRowSet();
		int cnt = 1;
		
		try {
			retVoArray[0] = dbDao.searchOpJobCarrierList(vo);
			
			rowSet = retVoArray[0].getDbRowset();
			if(rowSet != null){
				StringBuffer sb1 = new StringBuffer();													//SJH.20150508.소스품질
				while(rowSet.next()){
//					header = header + rowSet.getString("crr_cd")+rowSet.getString("bsa_op_jb_cd");
//					if(cnt != rowSet.getRowCount()) header = header + "|";					
					//SJH.20150508.소스품질
					sb1.append(rowSet.getString("crr_cd")).append(rowSet.getString("bsa_op_jb_cd"));
					if(cnt != rowSet.getRowCount()) sb1.append("|");
					header = sb1.toString();					
					cnt++;
				}
			}
			
			codeArr = header.split("[|]");
			if(rowSet != null)	rowSet.first();															//20150522.소스품질
			//SJH.20150508.소스품질
			if(codeArr != null) {
				retVoArray[1] = dbDao.searchTEUPrcSwapVvdList(vo,codeArr);
			} else {
				retVoArray[1] = dbDao.searchTEUPrcSwapVvdList(vo,null);
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
	 * EsmBsa0030Event retreive event process<br>
	 * BSAManage  Revenue & Cost Of Slot-swap By VVD List retreive<br>
	 * 
     * @author
     * @param SearchSpcConditionVO vo
     * @return CommonBsaRsVO
     * @exception EventException
     */	
	public CommonBsaRsVO searchRevCostSwapVvdList(SearchSpcConditionVO vo) throws EventException{
		String[] codeArr = null;
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		CommonBsaRsVO[] retVoArray = new CommonBsaRsVO[2];
		String header ="";
		DBRowSet rowSet = new DBRowSet();
		int cnt = 1;
		
		try {
			retVoArray[0] = dbDao.searchOpJobCarrierList(vo);
			
			rowSet = retVoArray[0].getDbRowset();
			if(rowSet != null){
				StringBuffer sb1 = new StringBuffer();													//SJH.20150508.소스품질
				while(rowSet.next()){
//					header = header + rowSet.getString("crr_cd")+rowSet.getString("bsa_op_jb_cd");
//					if(cnt != rowSet.getRowCount()) header = header + "|";
					//SJH.20150508.소스품질
					sb1.append(rowSet.getString("crr_cd")).append(rowSet.getString("bsa_op_jb_cd"));
					if(cnt != rowSet.getRowCount()) sb1.append("|");
					header = sb1.toString();					
					cnt++;
				}
			}
			
			codeArr = header.split("[|]");
			if(rowSet != null)	rowSet.first();															//20150522.MOD : 소스품질
			
			//SJH.20150508.소스품질
			if(codeArr != null) {
				retVoArray[1] = dbDao.searchRevCostSwapVvdList(vo,codeArr);
			} else {
				retVoArray[1] = dbDao.searchRevCostSwapVvdList(vo,null);
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
	 * EsmBsa0030Event create event process<br>
	 * BSAManage  Slot-swap By VVD List create<br>
	 * 
     * @author
     * @param     SearchSpcConditionVO vo
	 * @param     SignOnUserAccount account
     * @return CommonBsaRsVO
     * @exception EventException
     */	
	public CommonBsaRsVO createSupplySwapVvd(SearchSpcConditionVO vo, SignOnUserAccount account) throws EventException {
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		String err_cd = "00000";
		String err_msg = "OK!";
//		ArrayList rtnResult = null;
		DailyBatchConditionVO rtnResult = new DailyBatchConditionVO();
		
		try {
			// BSA VVD Zero Reset.
			String year       = vo.getTxtyear();			
			String fm_week    = vo.getTxtfmweek();			
			String to_week    = vo.getTxttoweek();	
			String duration   = "";
			String trd_cd     = vo.getCobtrade();			
			String rlane_cd   = vo.getCoblane();
			String ioc_cd     = vo.getCobioc();			                        
			String vsl_cd     = vo.getTxtvslCd();
			String skd_voy_no = vo.getTxtskdVoyNo();
			String dir_cd     = vo.getTxtdirCd();
			String user_id    = account.getUsr_id();
			
			
			duration = this.searchYrWkDu(year, fm_week, to_week);
			if(!duration.equals("")){
				// BSA VVD Creation.
				rtnResult = this.dailyBatch (year, fm_week, duration, "2", "Y", "BSA", trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, dir_cd, user_id);
	
				if(rtnResult != null){
					err_cd  = rtnResult.getPErrCd();
					if(!err_cd.equals("00000")){
						
						if(rtnResult.getPErrMsg().indexOf("BSAVVDCreation11ORA-01400")!=-1){
							String[] msg = rtnResult.getPErrMsg().split("[♀]");
							String[] errMessage = { "Vessel Carrier " };
							String err = (new ErrorHandler("COA00031", errMessage).getMessage()).replaceAll("<","♀");
							String[] errs = err.split("[♀]");
							//log.debug(errs[0] + " : " + errs[1] + " : " + errs[2] + " : " + errs[3] + " : "+err);
							err_cd = "99999";
							err_msg = errs[3] +" "+ msg[2];							
						}else if(rtnResult.getPErrMsg().indexOf("BSAVVDCreation2ORA-00001")!=-1){
							String[] msg = rtnResult.getPErrMsg().split("[♀]");
							String[] errMessage = { "BSA Table " };
							String err = (new ErrorHandler("COA00031", errMessage).getMessage()).replaceAll("<","♀");
							String[] errs = err.split("[♀]");
							//log.debug(errs[0] + " : " + errs[1] + " : " + errs[2] + " : " + errs[3] + " : "+err);
							err_cd = "99999";
							err_msg = errs[3] +" "+ msg[2];
						}else if(rtnResult.getPErrMsg().indexOf("BSAVVDCreation10ORA-01427")!=-1 ||
							     rtnResult.getPErrMsg().indexOf("BSAVVDCreation12ORA-01427")!=-1){
							String[] msg = rtnResult.getPErrMsg().split("[♀]");
							String[] errMessage = { "Slot Price " };
							String err = (new ErrorHandler("COA00031", errMessage).getMessage()).replaceAll("<","♀");
							String[] errs = err.split("[♀]");
							//log.debug(errs[0] + " : " + errs[1] + " : " + errs[2] + " : " + errs[3] + " : "+err);
							err_cd = "99999";
							err_msg = errs[3] +" "+ msg[2];
							
						}else if(rtnResult.getPErrMsg().indexOf("ORA-01013")!=-1){
							err_cd  = "99999";
							err_msg = "TimeOut. Please try again.";
						} else {
							String[] msg = rtnResult.getPErrMsg().split("[♀]");
							err_cd = "99999";
							err_msg = msg[1];
						}
					}
//					BSA Table has incorrect information.
//					Please try again after change data.
				} else {
					err_cd = "";
					err_msg = "";
				}
				
				if(err_cd.equals("00000")){
					// initializing data of particular BSA VVD to zero 
					this.dailyBatch ("", "", "", "4", "Y", "BSA", trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, dir_cd, user_id);
				}
				rsVo.setErrorCode(err_cd);
				rsVo.setErrorMsg(err_msg);	
			}
			log.debug("\n\n createSupplySwapVvd err_cd : " + err_cd);	
			
		} catch (Exception ex) {
			rsVo.setErrorCode(ex.getMessage());
			rsVo.setErrorMsg(ex.getMessage());
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
	}

	/**
	 * EsmBsa0030Event retreive event process<br>
	 * BSAManage  Slot-swap By VVD List modify<br>
	 * 
     * @author
     * @param     SearchSpcConditionVO vo
	 * @param     SignOnUserAccount account
     * @return    CommonBsaRsVO
     * @exception EventException
     */	
	public CommonBsaRsVO resetSupplySwapVvd(SearchSpcConditionVO vo, SignOnUserAccount account) throws EventException {
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		String err_cd = "00000";
		String err_msg = "OK!";
		DailyBatchConditionVO rtnResult = new DailyBatchConditionVO();
//		ArrayList rtnResult = null;
		
		try {
			// BSA VVD Zero Reset.
			String year       = vo.getTxtyear();			
			String fm_week    = vo.getTxtfmweek();			
			String to_week    = vo.getTxttoweek();	
			String duration   = "";
			String trd_cd     = vo.getCobtrade();			
			String rlane_cd   = vo.getCoblane();
			String ioc_cd     = vo.getCobioc();			                        
			String vsl_cd     = vo.getTxtvslCd();
			String skd_voy_no = vo.getTxtskdVoyNo();
			String dir_cd     = vo.getTxtdirCd();
			String user_id    = account.getUsr_id();
			
			
			duration = this.searchYrWkDu(year, fm_week, to_week);
			if(!duration.equals("")){
				// BSA VVD Reset.
				rtnResult = this.dailyBatch (year, fm_week, duration, "3", "Y", "BSA", trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, dir_cd, user_id);
				
				if(rtnResult != null){
					err_cd  = rtnResult.getPErrCd();
					if(!err_cd.equals("00000")){
						if(rtnResult.getPErrMsg().indexOf("BSAReset4ORA-01427")!=-1 || 
						   rtnResult.getPErrMsg().indexOf("BSAReset5ORA-01427")!=-1){
							String[] msg = rtnResult.getPErrMsg().split("[♀]");
							String[] errMessage = { "BSA Table " };
							String err = (new ErrorHandler("COA00031", errMessage).getMessage()).replaceAll("<","♀");
							String[] errs = err.split("[♀]");
							//log.debug(errs[0] + " : " + errs[1] + " : " + errs[2] + " : " + errs[3] + " : "+err);
							err_cd = "99999";
							err_msg = errs[3] +" "+ msg[2];
							
						}else if(rtnResult.getPErrMsg().indexOf("BSAReset14ORA-01427")!=-1){
							String[] msg = rtnResult.getPErrMsg().split("[♀]");
							String[] errMessage = { "Slot Price " };
							String err = (new ErrorHandler("COA00031", errMessage).getMessage()).replaceAll("<","♀");
							String[] errs = err.split("[♀]");
							//log.debug(errs[0] + " : " + errs[1] + " : " + errs[2] + " : " + errs[3] + " : "+err);
							err_cd = "99999";
							err_msg = errs[3] +" "+ msg[2];
							
						}else if(rtnResult.getPErrMsg().indexOf("BSAReset0ORA-06502")!=-1){
							String[] msg = rtnResult.getPErrMsg().split("[♀]");
							String[] errMessage = { "Vessel Carrier " };
							String err = (new ErrorHandler("COA00031", errMessage).getMessage()).replaceAll("<","♀");
							String[] errs = err.split("[♀]");
							//log.debug(errs[0] + " : " + errs[1] + " : " + errs[2] + " : " + errs[3] + " : "+err);
							err_cd = "99999";
							err_msg = errs[3] +" "+ msg[2];
						}else if(rtnResult.getPErrMsg().indexOf("ORA-01013")!=-1){
							err_cd  = "99999";
							err_msg = "TimeOut. Please try again.";
						} else {
							String[] msg = rtnResult.getPErrMsg().split("[♀]");
							err_cd = "99999";
							err_msg = msg[1];
						}
					}
				} else {
					err_cd = "";
					err_msg = "";
				}
				
				if(err_cd.equals("00000")){
				// Initializing data of particular BSA VVD to zero 
					this.dailyBatch ("", "", "", "4", "Y", "BSA", trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, dir_cd, user_id);
				}
				
				rsVo.setErrorCode(err_cd);
				rsVo.setErrorMsg(err_msg);		
				
			}
			log.debug("\n\n resetSupplySwapVvd err_msg : " + err_msg);
			return rsVo;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	

	/**
	 * EsmBsa0104Event retreive event process<br>
	 * BSAManage  SlotInfo by vvd retreive<br>
	 * 
     * @author
     * @param SearchSpcConditionVO vo
     * @return CommonBsaRsVO
     * @exception EventException
     */	
	public CommonBsaRsVO searchSpcSlotInfoByVvdList(SearchSpcConditionVO vo) throws EventException{
		String[] codeArr =null;
		
		try {
			// PDTO(Data Transfer Object including Parameters)
			String crr_cd       = JSPUtil.getNull(vo.getHeader()).trim();
			
			
			if( crr_cd != null && !crr_cd.equals("")){
				codeArr = crr_cd.split("[|]");				
			}		
			
			//SJH.20150508.소스품질
			if(codeArr != null) {
				return  dbDao.searchSpcSlotInfoByVvdList(vo,codeArr);
			} else {
				return  dbDao.searchSpcSlotInfoByVvdList(vo,null);
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
	 * EsmBsa0104Event modify event process<br>
	 * BSAManage  SlotInfo by vvd modify<br>
	 * 
     * @author
     * @param BsaSpcSlotInfoByVvdSaveVO[] vos
     * @param SignOnUserAccount account 
     * @exception EventException
     */	
	public void multiSpcSlotInfoByVvd(BsaSpcSlotInfoByVvdSaveVO[] vos,SignOnUserAccount account) throws EventException {
try {
			List<BsaVvdOtrCrrVO> insertVoList1 = new ArrayList<BsaVvdOtrCrrVO>();
			List<BsaVvdMstVO> updateVoList1 = new ArrayList<BsaVvdMstVO>();
			List<BsaVvdPortDwnVO> updateVoList2 = new ArrayList<BsaVvdPortDwnVO>();
			List<BsaVvdSwapInfoVO> insertVoList2 = new ArrayList<BsaVvdSwapInfoVO>();
			List<BsaVvdOtrCrrVO> updateVoList3 = new ArrayList<BsaVvdOtrCrrVO>();
			List<BsaVvdOtrCrrVO> updateVoList4 = new ArrayList<BsaVvdOtrCrrVO>();
			
			String bsaOpJbCd    	 	= "";
			
			String trdCd 				= "";
			String rlaneCd 				= "";
			String vslCd 				= "";
			String skdVoyNo 			= "";
			String skdDirCd 			= "";
			String fnlCoBsaCapa 		= "";
			String n2ndFnlCoBsaCapa 	= "";
			String freeAddTeuCapa 		= "";
			String freeAddWgt 			= "";
			String companyCode			= ConstantMgr.getCompanyCode();
			
			String[] crrCd         		= null;
			String[] crrBsaCapa 	    = null;
			String[] spcCtrlSltCapa 	= null;
			String[] slsCrrCapa 		= null;
			String[] purCrrCapa 		= null;
			String[] sltCrrCapa 		= null;
					
			for ( int i=0; i<vos .length; i++ ) {
				BsaVvdOtrCrrVO crrVO = new BsaVvdOtrCrrVO();
				BsaVvdMstVO mstVO	= new BsaVvdMstVO();
				BsaVvdPortDwnVO portDwnVO = new BsaVvdPortDwnVO();
				BsaVvdSwapInfoVO infoVO = new BsaVvdSwapInfoVO();
			 if ( vos[i].getIbflag().equals("U")){
				 bsaOpJbCd		= vos[i].getRdoopjob();
				 trdCd				= vos[i].getTrdCd();
				 rlaneCd			= vos[i].getRlaneCd();
				 vslCd				= vos[i].getVslCd();
				 skdVoyNo			= vos[i].getSkdVoyNo();
				 skdDirCd			= vos[i].getSkdDirCd();
				 fnlCoBsaCapa   	= vos[i].getFnlCoBsaCapa();
				 
				 crrCd 				= vos[i].getHeader().split("[|]");
				 crrBsaCapa 		= vos[i].getCrrBsaCapa().split("[|]");
				 spcCtrlSltCapa  	= vos[i].getSpcCtrtSltCapa().split("[|]");
				 
				 if(!bsaOpJbCd.equals("008") && !bsaOpJbCd.equals("009")){
						slsCrrCapa 	= vos[i].getSlsTeuCapa().split("[|]");
						purCrrCapa 	= vos[i].getPurTeuCapa().split("[|]");
						sltCrrCapa 	= vos[i].getSltSwapTeuCapa().split("[|]");
						
						n2ndFnlCoBsaCapa 	= vos[i].getN2ndFnlCoBsaCapa();
						freeAddTeuCapa 		= vos[i].getFreeAddTeuCapa();
						freeAddWgt			= vos[i].getFreeAddWgt();
					
				 }
				 double tmpSum =0;
				 for(int k=0; k<crrCd.length; k++){	
					 crrVO = new BsaVvdOtrCrrVO();
					 portDwnVO = new BsaVvdPortDwnVO();
					 if (k==0){
						 crrVO.setTrdCd(trdCd);
						 crrVO.setRlaneCd(rlaneCd);
						 crrVO.setVslCd(vslCd);
						 crrVO.setSkdVoyNo(skdVoyNo);
						 crrVO.setSkdDirCd(skdDirCd);
						 crrVO.setBsaOpJbCd(bsaOpJbCd);
						 crrVO.setCrrCd(companyCode);
						 if(bsaOpJbCd.equals("008") || bsaOpJbCd.equals("009")){
							 crrVO.setCrrBsaCapa(fnlCoBsaCapa);
							 crrVO.setSpcCtrlSltCapa("0");
							 log.debug("bsa_vvd_otr_crr : ["+trdCd+"]["+rlaneCd+"]["+vslCd+"]["+skdVoyNo+"]["+skdDirCd+"]["+bsaOpJbCd+"]["+companyCode+"]["+fnlCoBsaCapa+"][0]");
						 }else{
							 crrVO.setCrrBsaCapa(fnlCoBsaCapa);
							 crrVO.setSpcCtrlSltCapa(n2ndFnlCoBsaCapa);
							 log.debug("bsa_vvd_otr_crr : ["+trdCd+"]["+rlaneCd+"]["+vslCd+"]["+skdVoyNo+"]["+skdDirCd+"]["+bsaOpJbCd+"]["+companyCode+"]["+fnlCoBsaCapa+"]["+n2ndFnlCoBsaCapa+"]");
						 }
					    crrVO.setCreUsrId(account.getUsr_id());
						
					    insertVoList1.add(crrVO);
					    
					    crrVO = new BsaVvdOtrCrrVO();
					    if(bsaOpJbCd.equals("007")){		
					    	portDwnVO.setPortBsaCapa(n2ndFnlCoBsaCapa);
					    	portDwnVO.setTrdCd(trdCd);
					    	portDwnVO.setRlaneCd(rlaneCd);
					    	portDwnVO.setVslCd(vslCd);
					    	portDwnVO.setSkdVoyNo(skdVoyNo);
					    	portDwnVO.setSkdDirCd(skdDirCd);
					    	
					    	updateVoList2.add(portDwnVO);
							log.debug("\n bsa_vvd_port_dwn : ["+trdCd+"]["+rlaneCd+"]["+vslCd+"]["+skdVoyNo+"]["+skdDirCd+"]["+n2ndFnlCoBsaCapa+"]");
						}
					 }
					 
					 crrVO.setTrdCd(trdCd);
					 crrVO.setRlaneCd(rlaneCd);
					 crrVO.setVslCd(vslCd);
					 crrVO.setSkdVoyNo(skdVoyNo);
					 crrVO.setSkdDirCd(skdDirCd);
					 crrVO.setBsaOpJbCd(bsaOpJbCd);
					 crrVO.setCrrCd(crrCd[k]);
					 
					 if(bsaOpJbCd.equals("008") || bsaOpJbCd.equals("009")){
						 crrVO.setCrrBsaCapa(crrBsaCapa[k]);
						 crrVO.setSpcCtrlSltCapa("0");
						log.debug("bsa_vvd_otr_crr : ["+trdCd+"]["+rlaneCd+"]["+vslCd+"]["+skdVoyNo+"]["+skdDirCd+"]["+bsaOpJbCd+"]["+crrCd[k]+"]["+crrBsaCapa[k]+"][0]");
					}else{
						 crrVO.setCrrBsaCapa(crrBsaCapa[k]);
						 crrVO.setSpcCtrlSltCapa(spcCtrlSltCapa[k]);
						log.debug("bsa_vvd_otr_crr : ["+trdCd+"]["+rlaneCd+"]["+vslCd+"]["+skdVoyNo+"]["+skdDirCd+"]["+bsaOpJbCd+"]["+crrCd[k]+"]["+crrBsaCapa[k]+"]["+spcCtrlSltCapa[k]+"]");
					}
					crrVO.setCreUsrId(account.getUsr_id());
						
					insertVoList1.add(crrVO);
					 
					if(!bsaOpJbCd.equals("008") && !bsaOpJbCd.equals("009")){
						tmpSum = tmpSum + Double.parseDouble(slsCrrCapa[k]) + Double.parseDouble(purCrrCapa[k]) + Double.parseDouble(sltCrrCapa[k]);
					}
				 }
				 log.debug("---for(int k=0; k<crrCd.length; k++)------End---------");
				 
				//-----------------------------------------------------------------------------------------------
				// Updating master info (BSA_VVD_MST)
				//-----------------------------------------------------------------------------------------------
				 if(bsaOpJbCd.equals("007")){
					 mstVO	= new BsaVvdMstVO();
					 mstVO.setN2ndFnlCoBsaCapa(n2ndFnlCoBsaCapa);
					 mstVO.setFreeAddTeuCapa(freeAddTeuCapa);
					 mstVO.setFreeAddWgt(freeAddWgt);
					 mstVO.setSpcOtrSwapFlg(Utils.iif(tmpSum>0, "Y", ""));
					 mstVO.setUpdUsrId(account.getUsr_id());
					 
					 mstVO.setTrdCd(trdCd);
					 mstVO.setRlaneCd(rlaneCd);
					 mstVO.setVslCd(vslCd);
					 mstVO.setSkdVoyNo(skdVoyNo);
					 mstVO.setSkdDirCd(skdDirCd);
					 
					 updateVoList1.add(mstVO);
						log.debug("\n bsa_vvd_mst : ["+n2ndFnlCoBsaCapa+"]["+freeAddTeuCapa+"]["+freeAddWgt+"]");
					}
				 
					//-----------------------------------------------------------------
					// Adding FREE ADDITION Info in BSA_VVD_SWAP_INFO
					//-----------------------------------------------------------------
					if(!bsaOpJbCd.equals("008") && !bsaOpJbCd.equals("009")){
						
						infoVO.setTrdCd(trdCd);
						infoVO.setRlaneCd(rlaneCd);
						infoVO.setVslCd(vslCd);
						infoVO.setSkdVoyNo(skdVoyNo);
						infoVO.setSkdDirCd(skdDirCd);
						infoVO.setBsaOpJbCd(bsaOpJbCd);
						infoVO.setFreeAddTeuCapa(freeAddTeuCapa);
						infoVO.setFreeAddWgt(freeAddWgt);
						infoVO.setCreUsrId(account.getUsr_id());
						
						insertVoList2.add(infoVO);
					}
					//-------------------------------------------------------------------------------------------------------------------------
					// Changing TTL Weight in case of changing BSA, Weight Per TEU.
					//-------------------------------------------------------------------------------------------------------------------------
					 if(bsaOpJbCd.equals("007") || bsaOpJbCd.equals("008")){
						 crrVO = new BsaVvdOtrCrrVO();
						 crrVO.setTrdCd(trdCd);
						 crrVO.setRlaneCd(rlaneCd);
						 crrVO.setVslCd(vslCd);
						 crrVO.setSkdVoyNo(skdVoyNo);
						 crrVO.setSkdDirCd(skdDirCd);
						 
						 updateVoList3.add(crrVO) ;
						log.debug("["+trdCd+"] : ["+rlaneCd+"] : ["+vslCd+"] : ["+skdVoyNo+"] : ["+skdDirCd+"]");
					 }
					 
					//-------------------------------------------------------------------------------------------------------------------------
					// Changing Weight Per TEU in case of changing TTL Weight
					//-------------------------------------------------------------------------------------------------------------------------
					 if(bsaOpJbCd.equals("009")){
						 crrVO = new BsaVvdOtrCrrVO();
						 crrVO.setTrdCd(trdCd);
						 crrVO.setRlaneCd(rlaneCd);
						 crrVO.setVslCd(vslCd);
						 crrVO.setSkdVoyNo(skdVoyNo);
						 crrVO.setSkdDirCd(skdDirCd);
						 
						updateVoList4.add(crrVO) ;
						log.debug("["+trdCd+"] : ["+rlaneCd+"] : ["+vslCd+"] : ["+skdVoyNo+"] : ["+skdDirCd+"]");
					 }
			  }
			 log.debug("---if ( vos[i].getIbflag().equals(U)){------End---------");
			}
			
			
			if ( insertVoList1.size() > 0 ) {
				dbDao.multiSpcSlotInfoByVvdOtrCrr(insertVoList1);
				log.debug( "multiSpcSlotInfoByVvdOtrCrr");
			}
			
			if ( insertVoList2.size() > 0 ) {
				dbDao.multiSpcSlotInfoByVvd(insertVoList2);
				log.debug( "multiSpcSlotInfoByVvd");
			}
			
			
			if ( updateVoList1.size() > 0 ) {
				dbDao.modifymultiSpcSlotInfoByVvdMaster(updateVoList1);
				log.debug( "modifymultiSpcSlotInfoByVvdMaster");
			}
			
			if ( updateVoList2.size() > 0 ) {
				dbDao.modifymultiSpcSlotInfoByVvdPortDwn(updateVoList2);
				log.debug( "modifymultiSpcSlotInfoByVvdPortDwn");
			}
			
			if ( updateVoList3.size() > 0 ) {
				dbDao.modifymultiSpcSlotInfoByVvdOtrCrr(updateVoList3);
				log.debug( "modifymultiSpcSlotInfoByVvdOtrCrr");
			}
			
			if ( updateVoList4.size() > 0 ) {
				dbDao.modifymultiSpcSlotInfoByVvdOtrCrr2(updateVoList4);
				log.debug( "modifymultiSpcSlotInfoByVvdOtrCrr2");
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
	 * EsmBsa0104Event retrieve event process<br>
	 * BSAManage  Slot swap by vvd retrieve for ESM_BSA_0121 Pop-up<br>
	 * 
     * @author
     * @param SearchSpcConditionVO vo
     * @return List< SearchSpcSlotSwapByVvdListVO >
     * @exception EventException
     */	
	public List<SearchSpcSlotSwapByVvdListVO> searchSpcSlotSwapByVvdList(SearchSpcConditionVO vo) throws EventException{
		try {
			// PDTO(Data Transfer Object including Parameters)
			
			return  dbDao.searchSpcSlotSwapByVvdList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	

	
	/**
	 * EsmBsa0104Event modify event process<br>
	 * BSAManage  Slot swap by vvd modify for ESM_BSA_0121 Pop-up<br>
	 * 
     * @author
     * @param    SearchSpcConditionVO VO
	 * @param    BsaVvdSwapInfoVO[] VOs
	 * @param    SignOnUserAccount account
     * @exception EventException
     */	
	public void multiSpcSlotSwapByVvd(SearchSpcConditionVO VO,BsaVvdSwapInfoVO[] VOs, SignOnUserAccount account) throws EventException {
		try {
			
			boolean isUpdate2 = false;
			
			BsaVvdMstVO mstVo = new BsaVvdMstVO();
			List<BsaVvdSwapInfoVO> insertVoList = new ArrayList<BsaVvdSwapInfoVO>();
			List<BsaVvdSwapInfoVO> updateVoList = new ArrayList<BsaVvdSwapInfoVO>();
			List<BsaVvdMstVO> updateVoList2 = new ArrayList<BsaVvdMstVO>();
			
			String trdCd = VO.getPtrdCd();
			String rlandCd = VO.getPrlaneCd();
			String vslCd  =VO.getPvslCd();
			String skdVoyNo = VO.getPskdVoyNo();
			String skdDdirCd = VO.getPdirCd();
			String bsaOpJbCd = VO.getPbsaOpJbCd();
			
			String spcOtrSwapFlg ="";
			
			for ( int i=0; i<VOs .length; i++ ) {
				if ( VOs[i].getIbflag().equals("I")){
					VOs[i].setTrdCd(trdCd);
					VOs[i].setRlaneCd(rlandCd);
					VOs[i].setVslCd(vslCd);
					VOs[i].setSkdVoyNo(skdVoyNo);
					VOs[i].setSkdDirCd(skdDdirCd);
					VOs[i].setBsaOpJbCd(bsaOpJbCd);
					
					VOs[i].setCreUsrId(account.getUsr_id());
					VOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(VOs[i]);
				} else if ( VOs[i].getIbflag().equals("U")){
					VOs[i].setTrdCd(trdCd);
					VOs[i].setRlaneCd(rlandCd);
					VOs[i].setVslCd(vslCd);
					VOs[i].setSkdVoyNo(skdVoyNo);
					VOs[i].setSkdDirCd(skdDdirCd);
					VOs[i].setBsaOpJbCd(bsaOpJbCd);
					
					VOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(VOs[i]);
				}
				
				/* BSA VVD MST Update */
				if(Double.parseDouble(VOs[i].getSlsTeuCapa())+Double.parseDouble(VOs[i].getPurTeuCapa())+Double.parseDouble(VOs[i].getSltSwapTeuCapa())>0){
					isUpdate2 = true;
					spcOtrSwapFlg = "Y";
				}
			}
			
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiSpcSlotSwapByVvd(insertVoList);
				log.debug( "AddmultiSpcSlotSwapByVvd");
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiSpcSlotSwapByVvd(updateVoList);
				log.debug( "ModifymultiSpcSlotSwapByVvd");
			}
			
			if ( isUpdate2) {
				
				mstVo.setTrdCd(trdCd);
				mstVo.setRlaneCd(rlandCd);
				mstVo.setVslCd(vslCd);
				mstVo.setSkdVoyNo(skdVoyNo);
				mstVo.setSkdDirCd(skdDdirCd);
				
				mstVo.setSpcOtrSwapFlg(spcOtrSwapFlg);
				mstVo.setUpdUsrId(account.getUsr_id());
				
				updateVoList2.add(mstVo);
				dbDao.modifySpcSlotSwapByVvdMaster(updateVoList2);
				log.debug( "ModifySpcSlotSwapByVvdMaster");
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
	 * EsmBsa0104Event retrieve event process<br>
	 * BSAManage  Slot info by vvd on vessel list retrieve<br>
	 * 
     * @author
     * @param SearchSpcConditionVO vo
     * @return List<SearchSpcSlotInfoByVvdOnVesselListVO>
     * @exception EventException
     */	
	public List<SearchSpcSlotInfoByVvdOnVesselListVO> searchSpcSlotInfoByVvdOnVesselList(SearchSpcConditionVO vo) throws EventException{
		try {
			return dbDao.searchSpcSlotInfoByVvdOnVesselList(vo);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	
	

	/**
	 * EsmBsa0032Event retrieve event process<br>
	 * BSAManage step up down vvd master retrieve<br>
	 * 
     * @author
     * @param SearchSpcConditionVO vo
     * @return List< SearchStepUpDownVvdMasterListVO >
     * @exception EventException
     */	
	public List<SearchStepUpDownVvdMasterListVO> searchStepUpDownVvdMasterList(SearchSpcConditionVO vo) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			return  dbDao.searchStepUpDownVvdMasterList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * EsmBsa0032Event retrieve event process<br>
	 * BSAManage step up down vvd detail retrieve<br>
	 * 
     * @author
     * @param SearchSpcConditionVO vo
     * @return List< SearchStepUpDownVvdDetailListVO >
     * @exception EventException
     */	
	public List<SearchStepUpDownVvdDetailListVO> searchStepUpDownVvdDetailList(SearchSpcConditionVO vo) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			return  dbDao.searchStepUpDownVvdDetailList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * EsmBsa0032Event modify event process<br>
	 * BSAManage step up down vvd master modify<br>
	 * 
     * @author
     * @param BsaVvdMstVO[] VOs
	 * @param SignOnUserAccount account
     * @exception EventException
     */	
	public void modifyStepUpDownVvdMaster(BsaVvdMstVO[] VOs, SignOnUserAccount account) throws EventException {
		try {
			List<BsaVvdMstVO> updateVoList = new ArrayList<BsaVvdMstVO>();
			for ( int i=0; i<VOs.length; i++ ) {
				if ( VOs[i].getIbflag().equals("U")){
					VOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(VOs[i]);
				} 
			}
						
			if ( updateVoList.size() > 0 ) {
				dbDao.modifySetUpDownVvdMaster(updateVoList);
				log.debug( "modifySetUpDownVvdMaster");
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
	 * EsmBsa0032Event modify event process<br>
	 * BSAManage step up down vvd modify<br>
	 * 
     * @author
     * @param BsaVvdPortDwnVO[] VOs
	 * @param SignOnUserAccount account
     * @exception EventException
     */	
	public void multiStepUpDownVvd(BsaVvdPortDwnVO[] VOs,SignOnUserAccount account) throws EventException {
		try {
			List<BsaVvdPortDwnVO> insertVoList = new ArrayList<BsaVvdPortDwnVO>();
			List<BsaVvdPortDwnVO> updateVoList = new ArrayList<BsaVvdPortDwnVO>();
			List<BsaVvdPortDwnVO> deleteVoList = new ArrayList<BsaVvdPortDwnVO>();
			for ( int i=0; i<VOs .length; i++ ) {
				if ( VOs[i].getIbflag().equals("I")){
					VOs[i].setCreUsrId(account.getUsr_id());
					VOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(VOs[i]);
				} else if ( VOs[i].getIbflag().equals("U")){
					VOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(VOs[i]);
				} else if ( VOs[i].getIbflag().equals("D")){
					deleteVoList.add(VOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiBsaVvdPortDwn(insertVoList);
				log.debug( "addmultiBsaVvdPortDwn");
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiBsaVvdPortDwn(updateVoList);
				log.debug( "modifymultiBsaVvdPortDwn");
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiBsaVvdPortDwn(deleteVoList);
				log.debug( "removemultiBsaVvdPortDwn");
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
	 * The method hanling batch for vvd and BSA by reqiring other package.
	 * @author
	 * @param String year
	 * @param String week
	 * @param String duration
	 * @param String step
	 * @param String onlyStep
	 * @param String bsacoa
	 * @param String trdCd
	 * @param String rlaneCd
	 * @param String iocCd
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String dirCd
	 * @param String userId
	 * @return DailyBatchConditionVO
	 * @throws EventException
	 */
	public DailyBatchConditionVO dailyBatch (String year, String week, String duration, String step, String onlyStep, String bsacoa,
			                  String trdCd, String rlaneCd, String iocCd, String vslCd, String skdVoyNo, String dirCd,String userId) throws EventException {
		log.info("\n\n BSACreateBCImpl.dailyBatch() ..........");
		DailyBatchConditionVO vo = new DailyBatchConditionVO();
		try {
			vo.setPYear(year);
			vo.setPWeek(week);
			vo.setPDuration(duration);
			vo.setPStep(step);
			vo.setPOnlyStep(onlyStep);
			vo.setPBsa(bsacoa);
			vo.setPTrdCd(trdCd);
			vo.setPRlaneCd(rlaneCd);
			vo.setPIocCd(iocCd);
			vo.setPVslCd(vslCd);
			vo.setPSkdVoyNo(skdVoyNo);
			vo.setPDirCd(dirCd);
			vo.setPUserId(userId);
			
			vo = dbDao.dailyBatch (vo);	
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return vo;
	}
	
	/**
	 * Returning duration<br>
	 * 
	 * @param String year
	 * @param String fmWeek
	 * @param String toWeek
	 * @return String
	 * @exception EventException
	 */
	public String searchYrWkDu(String year, String fmWeek, String toWeek) throws EventException{
		String rtnResult = ""; 
		DBRowSet rowSet = null; 
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		try {
			rsVo = dbDao.searchYrWkDu(year, fmWeek, toWeek);
			
			rowSet = rsVo.getDbRowset();
			if(rowSet != null){
				while(rowSet.next()){
					rtnResult = rowSet.getString("cnt");
				}
			}
			return rtnResult;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

}