/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName           : SPCManageBCImpl.java
 *@FileTitle          : SPC Manage
 *Open Issues         :
 *Change history      :
 *@LastModifyDate     : 2006-12-21
 *@LastModifier       : Park Eun Ju
 *@LastVersion        : 1.0
 * 1.0 최초 생성
 =========================================================
 * History :
 * 2008.05.07 PEJ Error Message 변경 
 * 2008.10.24 전성진 CSR No.N200810100017 [030]
 *                   : Slot Price 및 TEU & Slot Price 화면 추가
 *                     searchSlotPrcSwapVvdList, searchTEUPrcSwapVvdList
 * 2009.06.01 박은주 CSR No.R200905280002 품질검토결과 수정사항 반영
 * 2010.09.09 최윤성 [CHM-201005881-01] session 정보 유저 ID 수정
 * 2010.12.07 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 - Rose 비교작업에서 doEnd 삭제
 * 2014.06.30 김용습 R4J 패치 사전 작업
 * 2015.03.27 김용습 [CHM-201534456] 2015년 1월 소스 보안 결함 건 조치 요청
 * 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
 * 2016.01.29 김성욱 [CHM-201539410] BSA System 개선의 건 / 동일 날짜에 서로 다른 항차 BSA 입력 가능 실현
 =========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration.SPCManageDBDAO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.BsaSpcSlotInfoByVvdSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.DailyBatchConditionVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.MultiSupplySwapVvdVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchOpJobCarrierListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchSpcConditionVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchSpcSlotInfoByVvdOnVesselListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchSpcSlotSwapByVvdListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchStepUpDownVvdDetailListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchStepUpDownVvdMasterListVO;
import com.hanjin.apps.alps.esm.bsa.common.Utils;
import com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BsaVvdMstVO;
import com.hanjin.syscommon.common.table.BsaVvdOtrCrrVO;
import com.hanjin.syscommon.common.table.BsaVvdPortDwnVO;
import com.hanjin.syscommon.common.table.BsaVvdSwapInfoVO;

/**
 * enis-SPCManage Business Logic Basic Command implementation<br>
 * - enis-SPCManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Park eun ju
 * @see ESM_BSA_0xxEventResponse,BSAManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class SPCManageBCImpl extends BasicCommandSupport implements SPCManageBC {

	private transient SPCManageDBDAO dbDao = null;

	/**
	 * SPCManageBCImpl 객체를 생성<br>
	 * SPCManageDBDAO를  생성한다.<br>
	 */
	public SPCManageBCImpl() {
		dbDao = new SPCManageDBDAO();
	}
	
	/**
	 * 1. 기능 : Header 목록을 조회 (ESM_BSA_030)<p>
	 * 2. 처리개요 : <p>
	 *    - 
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.12.21<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * 
	 * @param     SearchSpcConditionVO vo
	 * @return    CommonBsaRsVO
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
	 * 1. 기능 : ESM_BSA_0030 목록을 조회 (ESM_BSA_0030)<p>
	 * 2. 처리개요 : <p>
	 *    - 
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.12.22<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param   SearchSpcConditionVO vo
	 * @return    CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchSupplySwapVvdList(SearchSpcConditionVO vo) throws EventException {
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
					//2014.06.30 김용습 R4J 패치 사전 작업
					crrCd = rowSet.getString("crr_cd");
					bsaOpJbCd = rowSet.getString("bsa_op_jb_cd");
					
					//header = header + rowSet.getString("crr_cd")+rowSet.getString("bsa_op_jb_cd");
					
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
			
			retVoArray[1] = dbDao.searchSupplySwapVvdList(vo,codeArr);
			
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
	 * 1. 기능 : ESM_BSA_0030 목록을 조회 (ESM_BSA_0030)<p>
	 * 2. 처리개요 : <p>
	 *    - 
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : 전성진 /2008.10.16<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param     SearchSpcConditionVO vo
	 * @return    CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchSlotPrcSwapVvdList(SearchSpcConditionVO vo) throws EventException {
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
						//2014.06.30 김용습 R4J 패치 사전 작업
						crrCd = rowSet.getString("crr_cd");
						bsaOpJbCd = rowSet.getString("bsa_op_jb_cd");
						
						//header = header + rowSet.getString("crr_cd")+rowSet.getString("bsa_op_jb_cd");
						
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
				
				retVoArray[1] = dbDao.searchSlotPrcSwapVvdList(vo,codeArr);
				
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
	 * 1. 기능 : ESM_BSA_0030 목록을 조회 (ESM_BSA_0030)<p>
	 * 2. 처리개요 : TEU & Slot Price   조회<p>
	 *    - 
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : 전성진 /2008.10.16<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param     SearchSpcConditionVO vo
	 * @return    CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchTEUPrcSwapVvdList(SearchSpcConditionVO vo) throws EventException {
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
					//2014.06.30 김용습 R4J 패치 사전 작업
					crrCd = rowSet.getString("crr_cd");
					bsaOpJbCd = rowSet.getString("bsa_op_jb_cd");
					
					//header = header + rowSet.getString("crr_cd")+rowSet.getString("bsa_op_jb_cd");
					
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
	 * 1. 기능 : ESM_BSA_0030 목록을 조회 (ESM_BSA_0030)
	 * 2. 처리개요 : <p>
	 *    - 
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.12.27<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * 
	 * @param     SearchSpcConditionVO vo
	 * @return    CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchRevCostSwapVvdList(SearchSpcConditionVO vo) throws EventException{
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
					//2014.06.30 김용습 R4J 패치 사전 작업
					crrCd = rowSet.getString("crr_cd");
					bsaOpJbCd = rowSet.getString("bsa_op_jb_cd");
					
					//header = header + rowSet.getString("crr_cd")+rowSet.getString("bsa_op_jb_cd");
					
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
	 * 1. 기능 : ESM_BSA_030 CREATION (ESM_BSA_030)<p>
	 * 2. 처리개요 : <p>
	 *    - 
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.12.26<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * 
	 * @param     SearchSpcConditionVO vo
	 * @param     SignOnUserAccount account
	 * @return    CommonBsaRsVO
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
							String err = (new ErrorHandler("MAS00031", errMessage).getMessage()).replaceAll("<","♀");
							String[] errs = err.split("[♀]");
							//log.debug(errs[0] + " : " + errs[1] + " : " + errs[2] + " : " + errs[3] + " : "+err);
							err_cd = "99999";
							err_msg = errs[3] +" "+ msg[2];							
						}else if(rtnResult.getPErrMsg().indexOf("BSAVVDCreation2ORA-00001")!=-1){
							String[] msg = rtnResult.getPErrMsg().split("[♀]");
							String[] errMessage = { "BSA Table " };
							String err = (new ErrorHandler("MAS00031", errMessage).getMessage()).replaceAll("<","♀");
							String[] errs = err.split("[♀]");
							//log.debug(errs[0] + " : " + errs[1] + " : " + errs[2] + " : " + errs[3] + " : "+err);
							err_cd = "99999";
							err_msg = errs[3] +" "+ msg[2];
						}else if(rtnResult.getPErrMsg().indexOf("BSAVVDCreation10ORA-01427")!=-1 ||
							     rtnResult.getPErrMsg().indexOf("BSAVVDCreation12ORA-01427")!=-1){
							String[] msg = rtnResult.getPErrMsg().split("[♀]");
							String[] errMessage = { "Slot Price " };
							String err = (new ErrorHandler("MAS00031", errMessage).getMessage()).replaceAll("<","♀");
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
					// BSA VVD의 특정항차들의 값을 '0'으로 초기화 
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
	 * 1. 기능 : ESM_BSA_030 RESET (ESM_BSA_030)<p>
	 * 2. 처리개요 : <p>
	 *    - 
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : kim jong beom /2007.01.26<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * 
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
							String err = (new ErrorHandler("MAS00031", errMessage).getMessage()).replaceAll("<","♀");
							String[] errs = err.split("[♀]");
							//log.debug(errs[0] + " : " + errs[1] + " : " + errs[2] + " : " + errs[3] + " : "+err);
							err_cd = "99999";
							err_msg = errs[3] +" "+ msg[2];
							
						}else if(rtnResult.getPErrMsg().indexOf("BSAReset14ORA-01427")!=-1){
							String[] msg = rtnResult.getPErrMsg().split("[♀]");
							String[] errMessage = { "Slot Price " };
							String err = (new ErrorHandler("MAS00031", errMessage).getMessage()).replaceAll("<","♀");
							String[] errs = err.split("[♀]");
							//log.debug(errs[0] + " : " + errs[1] + " : " + errs[2] + " : " + errs[3] + " : "+err);
							err_cd = "99999";
							err_msg = errs[3] +" "+ msg[2];
							
						}else if(rtnResult.getPErrMsg().indexOf("BSAReset0ORA-06502")!=-1){
							String[] msg = rtnResult.getPErrMsg().split("[♀]");
							String[] errMessage = { "Vessel Carrier " };
							String err = (new ErrorHandler("MAS00031", errMessage).getMessage()).replaceAll("<","♀");
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
				// BSA VVD의 특정항차들의 값을 '0'으로 초기화 
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
	 * 저장 기능 , 0030
	 * 
	 * @param     MultiSupplySwapVvdVO[] multiSupplySwapVvdVOs
	 * @param     SignOnUserAccount account
	 * @return    CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO saveSupplySwapVvd(MultiSupplySwapVvdVO[] multiSupplySwapVvdVOs, SignOnUserAccount account) throws EventException{
		log.debug("################# SPCManageBCImpl.saveSupplySwapVvd() ############################[START]");
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		String err_cd = "00000";
		String err_msg = "OK!";
		try {
			log.debug("################# SPCManageBCImpl.saveSupplySwapVvd() ############################[1. BSA Table value modify]");
			//1. BSA Table value modify 
			dbDao.saveSupplySwapVvd( multiSupplySwapVvdVOs , account );
			
			DailyBatchConditionVO rtnResult = new DailyBatchConditionVO();

				//2. then Create call
				// BSA VVD Zero Reset.
				int vSize = multiSupplySwapVvdVOs.length;
				log.debug("################# SPCManageBCImpl.saveSupplySwapVvd() ############################[ Batch call / Count : "+vSize+" ]");
				 
				for( int x=0 ; x<vSize ; x++ ) {
					MultiSupplySwapVvdVO vo = multiSupplySwapVvdVOs[x];
					
					if( vo.getYyww() == null || vo.getYyww().length() < 4)
						continue;
					String year       = vo.getYyww().substring(0, 4);			
					String fm_week    = vo.getFmWeek();			
					String to_week    = vo.getToWeek();	
					String duration   = "";
					String trd_cd     = vo.getTrdCd();			
					String rlane_cd   = vo.getLaneCd();
					String ioc_cd     = vo.getIocCd();			                        
					String vsl_cd     = vo.getVslCd();
					String skd_voy_no = vo.getVoyNo();
					String dir_cd     = vo.getDirCd();
					String user_id    = account.getUsr_id();
					
					log.debug("################# SPCManageBCImpl.saveSupplySwapVvd() ############################[2. then Create call]");
					
					duration = this.searchYrWkDu(year, fm_week, to_week);
					if(!duration.equals("")){
						// BSA VVD Create
						rtnResult = this.dailyBatch (year, fm_week, duration, "2", "Y", "BSA", trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, dir_cd, user_id);
						if(rtnResult != null){
							err_cd  = rtnResult.getPErrCd();
							if(!err_cd.equals("00000")){
								if(rtnResult.getPErrMsg().indexOf("BSAReset4ORA-01427")!=-1 || 
								   rtnResult.getPErrMsg().indexOf("BSAReset5ORA-01427")!=-1){
									String[] msg = rtnResult.getPErrMsg().split("[♀]");
									String[] errMessage = { "BSA Table " };
									String err = (new ErrorHandler("MAS00031", errMessage).getMessage()).replaceAll("<","♀");
									String[] errs = err.split("[♀]");
									//log.debug(errs[0] + " : " + errs[1] + " : " + errs[2] + " : " + errs[3] + " : "+err);
									err_cd = "99999";
									err_msg = errs[3] +" "+ msg[2];
									
								}else if(rtnResult.getPErrMsg().indexOf("BSAReset14ORA-01427")!=-1){
									String[] msg = rtnResult.getPErrMsg().split("[♀]");
									String[] errMessage = { "Slot Price " };
									String err = (new ErrorHandler("MAS00031", errMessage).getMessage()).replaceAll("<","♀");
									String[] errs = err.split("[♀]");
									//log.debug(errs[0] + " : " + errs[1] + " : " + errs[2] + " : " + errs[3] + " : "+err);
									err_cd = "99999";
									err_msg = errs[3] +" "+ msg[2];
									
								}else if(rtnResult.getPErrMsg().indexOf("BSAReset0ORA-06502")!=-1){
									String[] msg = rtnResult.getPErrMsg().split("[♀]");
									String[] errMessage = { "Vessel Carrier " };
									String err = (new ErrorHandler("MAS00031", errMessage).getMessage()).replaceAll("<","♀");
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
//						if(err_cd.equals("00000")){
//							log.debug("################# SPCManageBCImpl.saveSupplySwapVvd() ############################[2. Create proceduer ERROR "+err_cd+"]");
//							// BSA VVD의 특정항차들의 값을 '0'으로 초기화 
//							this.dailyBatch ("", "", "", "4", "Y", "BSA", trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, dir_cd, user_id);
//						}
						
						rsVo.setErrorCode(err_cd);
						rsVo.setErrorMsg(err_msg);
					}
	
					log.debug("################# SPCManageBCImpl.saveSupplySwapVvd() ############################[3. Reset proceduer call]");
					//3. Reset proceduer call
					if(!duration.equals("")){
						rtnResult = this.dailyBatch (year, fm_week, duration, "3", "Y", "BSA", trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, dir_cd, user_id);
						if(rtnResult != null){
							err_cd  = rtnResult.getPErrCd();
							if(!err_cd.equals("00000")){
								if(rtnResult.getPErrMsg().indexOf("BSAReset4ORA-01427")!=-1 || 
								   rtnResult.getPErrMsg().indexOf("BSAReset5ORA-01427")!=-1){
									String[] msg = rtnResult.getPErrMsg().split("[♀]");
									String[] errMessage = { "BSA Table " };
									String err = (new ErrorHandler("MAS00031", errMessage).getMessage()).replaceAll("<","♀");
									String[] errs = err.split("[♀]");
									//log.debug(errs[0] + " : " + errs[1] + " : " + errs[2] + " : " + errs[3] + " : "+err);
									err_cd = "99999";
									err_msg = errs[3] +" "+ msg[2];
									
								}else if(rtnResult.getPErrMsg().indexOf("BSAReset14ORA-01427")!=-1){
									String[] msg = rtnResult.getPErrMsg().split("[♀]");
									String[] errMessage = { "Slot Price " };
									String err = (new ErrorHandler("MAS00031", errMessage).getMessage()).replaceAll("<","♀");
									String[] errs = err.split("[♀]");
									//log.debug(errs[0] + " : " + errs[1] + " : " + errs[2] + " : " + errs[3] + " : "+err);
									err_cd = "99999";
									err_msg = errs[3] +" "+ msg[2];
									
								}else if(rtnResult.getPErrMsg().indexOf("BSAReset0ORA-06502")!=-1){
									String[] msg = rtnResult.getPErrMsg().split("[♀]");
									String[] errMessage = { "Vessel Carrier " };
									String err = (new ErrorHandler("MAS00031", errMessage).getMessage()).replaceAll("<","♀");
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
							log.debug("################# SPCManageBCImpl.saveSupplySwapVvd() ############################[2. Create proceduer ERROR "+err_cd+"]");
							// BSA VVD의 특정항차들의 값을 '0'으로 초기화 
							this.dailyBatch ("", "", "", "4", "Y", "BSA", trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, dir_cd, user_id);
						}
					}
				}
		} catch (DAOException ex) {
			// TODO Auto-generated catch block
			log.debug("################ IMPLE::DAOExecption ####################");
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
	}
	/**
	 * 1. 기능 : ESM_BSA_0104 목록을 조회 (ESM_BSA_104)
	 * 2. 처리개요 : <p>
	 *    - 
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2007.01.03<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * 
	 * @param     SearchSpcConditionVO vo
	 * @return    CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchSpcSlotInfoByVvdList(SearchSpcConditionVO vo) throws EventException{
		
		try {
			// PDTO(Data Transfer Object including Parameters)
			String crr_cd       = JSPUtil.getNull(vo.getHeader()).trim();
			
			int arrLen = 0;
			if( crr_cd != null && !crr_cd.equals("")){
				arrLen = crr_cd.split("[|]").length;				
			}
			
			String[] codeArr = new String[arrLen];
			if(arrLen>0 ) codeArr = crr_cd.split("[|]");
			
			return  dbDao.searchSpcSlotInfoByVvdList(vo,codeArr);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 1. 기능 : ESM_BSA_0104 입력/수정 처리 (ESM_BSA_0104)
	 * 2. 처리개요 : <p>
	 *    - 
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2007.01.03<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * 
	 * @param     BsaSpcSlotInfoByVvdSaveVO[] vos
	 * @param     SignOnUserAccount account
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
			String fnlHjsBsaCapa 		= "";
			String n2ndFnlHjsBsaCapa 	= "";
			String freeAddTeuCapa 		= "";
			String freeAddWgt 			= "";
			
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
				 fnlHjsBsaCapa   	= vos[i].getFnlHjsBsaCapa();
				 
				 crrCd 				= vos[i].getHeader().split("[|]");
				 crrBsaCapa 		= vos[i].getCrrBsaCapa().split("[|]");
				 spcCtrlSltCapa  	= vos[i].getSpcCtrtSltCapa().split("[|]");
				 
				 if(!bsaOpJbCd.equals("008") && !bsaOpJbCd.equals("009")){
						slsCrrCapa 	= vos[i].getSlsTeuCapa().split("[|]");
						purCrrCapa 	= vos[i].getPurTeuCapa().split("[|]");
						sltCrrCapa 	= vos[i].getSltSwapTeuCapa().split("[|]");
						
						n2ndFnlHjsBsaCapa 	= vos[i].getN2ndFnlHjsBsaCapa();
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
						 crrVO.setCrrCd("SML");
						 if(bsaOpJbCd.equals("008") || bsaOpJbCd.equals("009")){
							 crrVO.setCrrBsaCapa(fnlHjsBsaCapa);
							 crrVO.setSpcCtrlSltCapa("0");
							 log.debug("bsa_vvd_otr_crr : ["+trdCd+"]["+rlaneCd+"]["+vslCd+"]["+skdVoyNo+"]["+skdDirCd+"]["+bsaOpJbCd+"][SML]["+fnlHjsBsaCapa+"][0]");
						 }else{
							 crrVO.setCrrBsaCapa(fnlHjsBsaCapa);
							 crrVO.setSpcCtrlSltCapa(n2ndFnlHjsBsaCapa);
							 log.debug("bsa_vvd_otr_crr : ["+trdCd+"]["+rlaneCd+"]["+vslCd+"]["+skdVoyNo+"]["+skdDirCd+"]["+bsaOpJbCd+"][SML]["+fnlHjsBsaCapa+"]["+n2ndFnlHjsBsaCapa+"]");
						 }
					    crrVO.setCreUsrId(account.getUsr_id());
						
					    insertVoList1.add(crrVO);
					    
					    crrVO = new BsaVvdOtrCrrVO();
					    if(bsaOpJbCd.equals("007")){		
					    	portDwnVO.setPortBsaCapa(n2ndFnlHjsBsaCapa);
					    	portDwnVO.setTrdCd(trdCd);
					    	portDwnVO.setRlaneCd(rlaneCd);
					    	portDwnVO.setVslCd(vslCd);
					    	portDwnVO.setSkdVoyNo(skdVoyNo);
					    	portDwnVO.setSkdDirCd(skdDirCd);
					    	
					    	updateVoList2.add(portDwnVO);
							log.debug("\n bsa_vvd_port_dwn : ["+trdCd+"]["+rlaneCd+"]["+vslCd+"]["+skdVoyNo+"]["+skdDirCd+"]["+n2ndFnlHjsBsaCapa+"]");
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
				// BSA_VVD_MST 마스터정보 업데이트 
				//-----------------------------------------------------------------------------------------------
				 if(bsaOpJbCd.equals("007")){
					 mstVO	= new BsaVvdMstVO();
					 mstVO.setN2ndFnlHjsBsaCapa(n2ndFnlHjsBsaCapa);
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
						log.debug("\n bsa_vvd_mst : ["+n2ndFnlHjsBsaCapa+"]["+freeAddTeuCapa+"]["+freeAddWgt+"]");
					}
				 
					//-----------------------------------------------------------------
					// BSA_VVD_SWAP_INFO에 FREE ADDITION 정보를 입력한다 
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
					// BSA, Weight Per TEU가 변경되었을때 TTL Weight의 값도 변경시켜준다.
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
					// TTL Weight가 변경되었을때 Weight Per TEU의 값도 변경시켜준다.
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
	 * 1. 기능 : ESM_BSA_104 목록을 조회 (ESM_BSA_104)
	 * 2. 처리개요 : <p>
	 *    - 
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2007.01.08<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * 
	 * @param     SearchSpcConditionVO vo
	 * @return    List< SearchSpcSlotSwapByVvdListVO >
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
	 * 1. 기능 : ESM_BSA_0104 입력/수정 처리 (ESM_BSA_0104)
	 * 2. 처리개요 : <p>
	 *    - 
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2007.01.03<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * 
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
	 * ESM_BSA_0143: 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
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
	 * ESM_BSA_0032: 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param  SearchSpcConditionVO vo
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
	 * ESM_BSA_0032: 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchSpcConditionVO vo
	 * @return  List< SearchStepUpDownVvdDetailListVO >
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
	 * ESM_BSA_0032: 멀티 이벤트 처리<br>
	 * SPCManage화면에 대한 멀티 이벤트 처리<br>
	 * 
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
	 * ESM_BSA_0032: 멀티 이벤트 처리<br>
	 * SPCManage화면에 대한 멀티 이벤트 처리<br>
	 * 
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
	 * 타 package에서 대상항차 및 BSA를 돌리고자 할때 사용하는 메소드.
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
	 * duration을 리턴한다.<br>
	 * 
	 * @param String year
	 * @param String fmWeek
	 * @param String toWeek
	 * @return String
	 * @exception EventException
	 */
	public String searchYrWkDu(String year, String fmWeek, String toWeek) throws EventException{
		String rtnResult = ""; // 수행 결과가 정상인지를 판별하기 위한 변수
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
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